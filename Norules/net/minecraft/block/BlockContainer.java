package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.stats.*;
import net.minecraft.enchantment.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public abstract class BlockContainer extends Block implements ITileEntityProvider
{
    protected BlockContainer(final Material lllllllllllllIlIllllIIllIIlIIlIl) {
        this(lllllllllllllIlIllllIIllIIlIIlIl, lllllllllllllIlIllllIIllIIlIIlIl.getMaterialMapColor());
    }
    
    @Override
    public boolean eventReceived(final IBlockState lllllllllllllIlIllllIIlIllIIlIll, final World lllllllllllllIlIllllIIlIllIlIIIl, final BlockPos lllllllllllllIlIllllIIlIllIIlIIl, final int lllllllllllllIlIllllIIlIllIIllll, final int lllllllllllllIlIllllIIlIllIIlllI) {
        super.eventReceived(lllllllllllllIlIllllIIlIllIIlIll, lllllllllllllIlIllllIIlIllIlIIIl, lllllllllllllIlIllllIIlIllIIlIIl, lllllllllllllIlIllllIIlIllIIllll, lllllllllllllIlIllllIIlIllIIlllI);
        final TileEntity lllllllllllllIlIllllIIlIllIIllIl = lllllllllllllIlIllllIIlIllIlIIIl.getTileEntity(lllllllllllllIlIllllIIlIllIIlIIl);
        return lllllllllllllIlIllllIIlIllIIllIl != null && lllllllllllllIlIllllIIlIllIIllIl.receiveClientEvent(lllllllllllllIlIllllIIlIllIIllll, lllllllllllllIlIllllIIlIllIIlllI);
    }
    
    protected boolean hasInvalidNeighbor(final World lllllllllllllIlIllllIIllIIIIlIII, final BlockPos lllllllllllllIlIllllIIllIIIIIlll) {
        return this.isInvalidNeighbor(lllllllllllllIlIllllIIllIIIIlIII, lllllllllllllIlIllllIIllIIIIIlll, EnumFacing.NORTH) || this.isInvalidNeighbor(lllllllllllllIlIllllIIllIIIIlIII, lllllllllllllIlIllllIIllIIIIIlll, EnumFacing.SOUTH) || this.isInvalidNeighbor(lllllllllllllIlIllllIIllIIIIlIII, lllllllllllllIlIllllIIllIIIIIlll, EnumFacing.WEST) || this.isInvalidNeighbor(lllllllllllllIlIllllIIllIIIIlIII, lllllllllllllIlIllllIIllIIIIIlll, EnumFacing.EAST);
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIlIllllIIlIlllllIll, final BlockPos lllllllllllllIlIllllIIlIlllllIlI, final IBlockState lllllllllllllIlIllllIIlIlllllIIl) {
        super.breakBlock(lllllllllllllIlIllllIIlIlllllIll, lllllllllllllIlIllllIIlIlllllIlI, lllllllllllllIlIllllIIlIlllllIIl);
        lllllllllllllIlIllllIIlIlllllIll.removeTileEntity(lllllllllllllIlIllllIIlIlllllIlI);
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllIlIllllIIlIlllIllIl, final EntityPlayer lllllllllllllIlIllllIIlIlllIIIlI, final BlockPos lllllllllllllIlIllllIIlIlllIlIll, final IBlockState lllllllllllllIlIllllIIlIlllIlIlI, @Nullable final TileEntity lllllllllllllIlIllllIIlIllIlllll, final ItemStack lllllllllllllIlIllllIIlIlllIlIII) {
        if (lllllllllllllIlIllllIIlIllIlllll instanceof IWorldNameable && ((IWorldNameable)lllllllllllllIlIllllIIlIllIlllll).hasCustomName()) {
            lllllllllllllIlIllllIIlIlllIIIlI.addStat(StatList.getBlockStats(this));
            lllllllllllllIlIllllIIlIlllIIIlI.addExhaustion(0.005f);
            if (lllllllllllllIlIllllIIlIlllIllIl.isRemote) {
                return;
            }
            final int lllllllllllllIlIllllIIlIlllIIlll = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, lllllllllllllIlIllllIIlIlllIlIII);
            final Item lllllllllllllIlIllllIIlIlllIIllI = this.getItemDropped(lllllllllllllIlIllllIIlIlllIlIlI, lllllllllllllIlIllllIIlIlllIllIl.rand, lllllllllllllIlIllllIIlIlllIIlll);
            if (lllllllllllllIlIllllIIlIlllIIllI == Items.field_190931_a) {
                return;
            }
            final ItemStack lllllllllllllIlIllllIIlIlllIIlIl = new ItemStack(lllllllllllllIlIllllIIlIlllIIllI, this.quantityDropped(lllllllllllllIlIllllIIlIlllIllIl.rand));
            lllllllllllllIlIllllIIlIlllIIlIl.setStackDisplayName(((IWorldNameable)lllllllllllllIlIllllIIlIllIlllll).getName());
            Block.spawnAsEntity(lllllllllllllIlIllllIIlIlllIllIl, lllllllllllllIlIllllIIlIlllIlIll, lllllllllllllIlIllllIIlIlllIIlIl);
        }
        else {
            super.harvestBlock(lllllllllllllIlIllllIIlIlllIllIl, lllllllllllllIlIllllIIlIlllIIIlI, lllllllllllllIlIllllIIlIlllIlIll, lllllllllllllIlIllllIIlIlllIlIlI, null, lllllllllllllIlIllllIIlIlllIlIII);
        }
    }
    
    protected boolean isInvalidNeighbor(final World lllllllllllllIlIllllIIllIIIlIlIl, final BlockPos lllllllllllllIlIllllIIllIIIlIlII, final EnumFacing lllllllllllllIlIllllIIllIIIlIIll) {
        return lllllllllllllIlIllllIIllIIIlIlIl.getBlockState(lllllllllllllIlIllllIIllIIIlIlII.offset(lllllllllllllIlIllllIIllIIIlIIll)).getMaterial() == Material.CACTUS;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIlIllllIIllIIIIIlIl) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    protected BlockContainer(final Material lllllllllllllIlIllllIIllIIIllIll, final MapColor lllllllllllllIlIllllIIllIIIllIlI) {
        super(lllllllllllllIlIllllIIllIIIllIll, lllllllllllllIlIllllIIllIIIllIlI);
        this.isBlockContainer = true;
    }
}
