package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;

public class BlockEnchantmentTable extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB AABB;
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllllllllIIIIIlIlIllll) {
        return EnumBlockRenderType.MODEL;
    }
    
    static {
        AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
    }
    
    protected BlockEnchantmentTable() {
        super(Material.ROCK, MapColor.RED);
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllllllIIIIIlIlIllIl, final int lllllllllllllllllllIIIIIlIlIllII) {
        return new TileEntityEnchantmentTable();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllllllIIIIIllIlIIlI, final IBlockAccess lllllllllllllllllllIIIIIllIlIIIl, final BlockPos lllllllllllllllllllIIIIIllIlIIII) {
        return BlockEnchantmentTable.AABB;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllllllIIIIIllIIlllI) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllllllIIIIIlIllIIIl) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllllllIIIIIlIIlllII, final BlockPos lllllllllllllllllllIIIIIlIIllIll, final IBlockState lllllllllllllllllllIIIIIlIlIIlII, final EntityPlayer lllllllllllllllllllIIIIIlIIllIlI, final EnumHand lllllllllllllllllllIIIIIlIlIIIlI, final EnumFacing lllllllllllllllllllIIIIIlIlIIIIl, final float lllllllllllllllllllIIIIIlIlIIIII, final float lllllllllllllllllllIIIIIlIIlllll, final float lllllllllllllllllllIIIIIlIIllllI) {
        if (lllllllllllllllllllIIIIIlIIlllII.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllllllllIIIIIlIIlllIl = lllllllllllllllllllIIIIIlIIlllII.getTileEntity(lllllllllllllllllllIIIIIlIIllIll);
        if (lllllllllllllllllllIIIIIlIIlllIl instanceof TileEntityEnchantmentTable) {
            lllllllllllllllllllIIIIIlIIllIlI.displayGui((IInteractionObject)lllllllllllllllllllIIIIIlIIlllIl);
        }
        return true;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllllllllIIIIIlIlllIlI, final World lllllllllllllllllllIIIIIlIlllIIl, final BlockPos lllllllllllllllllllIIIIIlIlllIII, final Random lllllllllllllllllllIIIIIllIIIIII) {
        super.randomDisplayTick(lllllllllllllllllllIIIIIlIlllIlI, lllllllllllllllllllIIIIIlIlllIIl, lllllllllllllllllllIIIIIlIlllIII, lllllllllllllllllllIIIIIllIIIIII);
        for (int lllllllllllllllllllIIIIIlIllllll = -2; lllllllllllllllllllIIIIIlIllllll <= 2; ++lllllllllllllllllllIIIIIlIllllll) {
            for (int lllllllllllllllllllIIIIIlIlllllI = -2; lllllllllllllllllllIIIIIlIlllllI <= 2; ++lllllllllllllllllllIIIIIlIlllllI) {
                if (lllllllllllllllllllIIIIIlIllllll > -2 && lllllllllllllllllllIIIIIlIllllll < 2 && lllllllllllllllllllIIIIIlIlllllI == -1) {
                    lllllllllllllllllllIIIIIlIlllllI = 2;
                }
                if (lllllllllllllllllllIIIIIllIIIIII.nextInt(16) == 0) {
                    for (int lllllllllllllllllllIIIIIlIllllIl = 0; lllllllllllllllllllIIIIIlIllllIl <= 1; ++lllllllllllllllllllIIIIIlIllllIl) {
                        final BlockPos lllllllllllllllllllIIIIIlIllllII = lllllllllllllllllllIIIIIlIlllIII.add(lllllllllllllllllllIIIIIlIllllll, lllllllllllllllllllIIIIIlIllllIl, lllllllllllllllllllIIIIIlIlllllI);
                        if (lllllllllllllllllllIIIIIlIlllIIl.getBlockState(lllllllllllllllllllIIIIIlIllllII).getBlock() == Blocks.BOOKSHELF) {
                            if (!lllllllllllllllllllIIIIIlIlllIIl.isAirBlock(lllllllllllllllllllIIIIIlIlllIII.add(lllllllllllllllllllIIIIIlIllllll / 2, 0, lllllllllllllllllllIIIIIlIlllllI / 2))) {
                                break;
                            }
                            lllllllllllllllllllIIIIIlIlllIIl.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, lllllllllllllllllllIIIIIlIlllIII.getX() + 0.5, lllllllllllllllllllIIIIIlIlllIII.getY() + 2.0, lllllllllllllllllllIIIIIlIlllIII.getZ() + 0.5, lllllllllllllllllllIIIIIlIllllll + lllllllllllllllllllIIIIIllIIIIII.nextFloat() - 0.5, lllllllllllllllllllIIIIIlIllllIl - lllllllllllllllllllIIIIIllIIIIII.nextFloat() - 1.0f, lllllllllllllllllllIIIIIlIlllllI + lllllllllllllllllllIIIIIllIIIIII.nextFloat() - 0.5, new int[0]);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllllllIIIIIlIIIIIIl, final IBlockState lllllllllllllllllllIIIIIlIIIIIII, final BlockPos lllllllllllllllllllIIIIIIlllllll, final EnumFacing lllllllllllllllllllIIIIIIllllllI) {
        return (lllllllllllllllllllIIIIIIllllllI == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllllllllIIIIIlIIlIIII, final BlockPos lllllllllllllllllllIIIIIlIIIllll, final IBlockState lllllllllllllllllllIIIIIlIIIlllI, final EntityLivingBase lllllllllllllllllllIIIIIlIIIIllI, final ItemStack lllllllllllllllllllIIIIIlIIIIlIl) {
        super.onBlockPlacedBy(lllllllllllllllllllIIIIIlIIlIIII, lllllllllllllllllllIIIIIlIIIllll, lllllllllllllllllllIIIIIlIIIlllI, lllllllllllllllllllIIIIIlIIIIllI, lllllllllllllllllllIIIIIlIIIIlIl);
        if (lllllllllllllllllllIIIIIlIIIIlIl.hasDisplayName()) {
            final TileEntity lllllllllllllllllllIIIIIlIIIlIll = lllllllllllllllllllIIIIIlIIlIIII.getTileEntity(lllllllllllllllllllIIIIIlIIIllll);
            if (lllllllllllllllllllIIIIIlIIIlIll instanceof TileEntityEnchantmentTable) {
                ((TileEntityEnchantmentTable)lllllllllllllllllllIIIIIlIIIlIll).setCustomName(lllllllllllllllllllIIIIIlIIIIlIl.getDisplayName());
            }
        }
    }
}
