package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.stats.*;
import java.util.*;
import net.minecraft.item.*;

public class BlockDeadBush extends BlockBush
{
    protected static final /* synthetic */ AxisAlignedBB DEAD_BUSH_AABB;
    
    @Override
    protected boolean canSustainBush(final IBlockState lllllllllllllIIIIIIIIllIIIIlIlII) {
        return lllllllllllllIIIIIIIIllIIIIlIlII.getBlock() == Blocks.SAND || lllllllllllllIIIIIIIIllIIIIlIlII.getBlock() == Blocks.HARDENED_CLAY || lllllllllllllIIIIIIIIllIIIIlIlII.getBlock() == Blocks.STAINED_HARDENED_CLAY || lllllllllllllIIIIIIIIllIIIIlIlII.getBlock() == Blocks.DIRT;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIIIIIIIllIIIIllIIl, final IBlockAccess lllllllllllllIIIIIIIIllIIIIllIII, final BlockPos lllllllllllllIIIIIIIIllIIIIlIlll) {
        return MapColor.WOOD;
    }
    
    protected BlockDeadBush() {
        super(Material.VINE);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIIIIIIllIIIIlllIl, final IBlockAccess lllllllllllllIIIIIIIIllIIIIlllII, final BlockPos lllllllllllllIIIIIIIIllIIIIllIll) {
        return BlockDeadBush.DEAD_BUSH_AABB;
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllllllllllllIIIIIIIIllIIIIlIIIl, final BlockPos lllllllllllllIIIIIIIIllIIIIlIIII) {
        return true;
    }
    
    static {
        DEAD_BUSH_AABB = new AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421);
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllIIIIIIIIlIllllllIII, final EntityPlayer lllllllllllllIIIIIIIIlIlllllIlll, final BlockPos lllllllllllllIIIIIIIIlIlllllIllI, final IBlockState lllllllllllllIIIIIIIIlIlllllIlIl, @Nullable final TileEntity lllllllllllllIIIIIIIIlIllllllIll, final ItemStack lllllllllllllIIIIIIIIlIllllllIlI) {
        if (!lllllllllllllIIIIIIIIlIllllllIII.isRemote && lllllllllllllIIIIIIIIlIllllllIlI.getItem() == Items.SHEARS) {
            lllllllllllllIIIIIIIIlIlllllIlll.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(lllllllllllllIIIIIIIIlIllllllIII, lllllllllllllIIIIIIIIlIlllllIllI, new ItemStack(Blocks.DEADBUSH, 1, 0));
        }
        else {
            super.harvestBlock(lllllllllllllIIIIIIIIlIllllllIII, lllllllllllllIIIIIIIIlIlllllIlll, lllllllllllllIIIIIIIIlIlllllIllI, lllllllllllllIIIIIIIIlIlllllIlIl, lllllllllllllIIIIIIIIlIllllllIll, lllllllllllllIIIIIIIIlIllllllIlI);
        }
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIIIIIIIIllIIIIIllII) {
        return lllllllllllllIIIIIIIIllIIIIIllII.nextInt(3);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIIIIIIIllIIIIIlIlI, final Random lllllllllllllIIIIIIIIllIIIIIlIIl, final int lllllllllllllIIIIIIIIllIIIIIlIII) {
        return Items.STICK;
    }
}
