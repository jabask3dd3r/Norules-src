package net.minecraft.block;

import net.minecraft.init.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;

public class BlockDaylightDetector extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB DAYLIGHT_DETECTOR_AABB;
    private final /* synthetic */ boolean inverted;
    public static final /* synthetic */ PropertyInteger POWER;
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllllIIlIIlIlIlIlIIIII) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIIlIIlIlIlIlIlIII, final BlockPos lllllllllllllllIIlIIlIlIlIlIIlll, final IBlockState lllllllllllllllIIlIIlIlIlIlIIllI) {
        return new ItemStack(Blocks.DAYLIGHT_DETECTOR);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllllIIlIIlIlIlIIIlIIl, final NonNullList<ItemStack> lllllllllllllllIIlIIlIlIlIIIIlIl) {
        if (!this.inverted) {
            super.getSubBlocks(lllllllllllllllIIlIIlIlIlIIIlIIl, lllllllllllllllIIlIIlIlIlIIIIlIl);
        }
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIIlIIlIlIllIIIIII, final BlockPos lllllllllllllllIIlIIlIlIlIllIlIl, final IBlockState lllllllllllllllIIlIIlIlIlIlllllI, final EntityPlayer lllllllllllllllIIlIIlIlIlIllIIll, final EnumHand lllllllllllllllIIlIIlIlIlIllIIlI, final EnumFacing lllllllllllllllIIlIIlIlIlIllIIIl, final float lllllllllllllllIIlIIlIlIlIlllIlI, final float lllllllllllllllIIlIIlIlIlIlIllll, final float lllllllllllllllIIlIIlIlIlIlllIII) {
        if (!lllllllllllllllIIlIIlIlIlIllIIll.isAllowEdit()) {
            return super.onBlockActivated(lllllllllllllllIIlIIlIlIllIIIIII, lllllllllllllllIIlIIlIlIlIllIlIl, lllllllllllllllIIlIIlIlIlIlllllI, lllllllllllllllIIlIIlIlIlIllIIll, lllllllllllllllIIlIIlIlIlIllIIlI, lllllllllllllllIIlIIlIlIlIllIIIl, lllllllllllllllIIlIIlIlIlIlllIlI, lllllllllllllllIIlIIlIlIlIlIllll, lllllllllllllllIIlIIlIlIlIlllIII);
        }
        if (lllllllllllllllIIlIIlIlIllIIIIII.isRemote) {
            return true;
        }
        if (this.inverted) {
            lllllllllllllllIIlIIlIlIllIIIIII.setBlockState(lllllllllllllllIIlIIlIlIlIllIlIl, Blocks.DAYLIGHT_DETECTOR.getDefaultState().withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, (Integer)lllllllllllllllIIlIIlIlIlIlllllI.getValue((IProperty<V>)BlockDaylightDetector.POWER)), 4);
            Blocks.DAYLIGHT_DETECTOR.updatePower(lllllllllllllllIIlIIlIlIllIIIIII, lllllllllllllllIIlIIlIlIlIllIlIl);
        }
        else {
            lllllllllllllllIIlIIlIlIllIIIIII.setBlockState(lllllllllllllllIIlIIlIlIlIllIlIl, Blocks.DAYLIGHT_DETECTOR_INVERTED.getDefaultState().withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, (Integer)lllllllllllllllIIlIIlIlIlIlllllI.getValue((IProperty<V>)BlockDaylightDetector.POWER)), 4);
            Blocks.DAYLIGHT_DETECTOR_INVERTED.updatePower(lllllllllllllllIIlIIlIlIllIIIIII, lllllllllllllllIIlIIlIlIlIllIlIl);
        }
        return true;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIIlIIlIlIlIlIIIlI) {
        return false;
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllllIIlIIlIlIlllIIIIl, final IBlockAccess lllllllllllllllIIlIIlIlIlllIIlII, final BlockPos lllllllllllllllIIlIIlIlIlllIIIll, final EnumFacing lllllllllllllllIIlIIlIlIlllIIIlI) {
        return lllllllllllllllIIlIIlIlIlllIIIIl.getValue((IProperty<Integer>)BlockDaylightDetector.POWER);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIIlIIlIlIlllIlIlI, final IBlockAccess lllllllllllllllIIlIIlIlIlllIlIIl, final BlockPos lllllllllllllllIIlIIlIlIlllIlIII) {
        return BlockDaylightDetector.DAYLIGHT_DETECTOR_AABB;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIlIIlIlIlIIlIIIl) {
        return lllllllllllllllIIlIIlIlIlIIlIIIl.getValue((IProperty<Integer>)BlockDaylightDetector.POWER);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIlIIlIlIlIIlIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, lllllllllllllllIIlIIlIlIlIIlIlIl);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIIlIIlIlIlIlIIlII) {
        return false;
    }
    
    public void updatePower(final World lllllllllllllllIIlIIlIlIllIlIIIl, final BlockPos lllllllllllllllIIlIIlIlIllIlIlll) {
        if (lllllllllllllllIIlIIlIlIllIlIIIl.provider.func_191066_m()) {
            final IBlockState lllllllllllllllIIlIIlIlIllIlIllI = lllllllllllllllIIlIIlIlIllIlIIIl.getBlockState(lllllllllllllllIIlIIlIlIllIlIlll);
            int lllllllllllllllIIlIIlIlIllIlIlIl = lllllllllllllllIIlIIlIlIllIlIIIl.getLightFor(EnumSkyBlock.SKY, lllllllllllllllIIlIIlIlIllIlIlll) - lllllllllllllllIIlIIlIlIllIlIIIl.getSkylightSubtracted();
            float lllllllllllllllIIlIIlIlIllIlIlII = lllllllllllllllIIlIIlIlIllIlIIIl.getCelestialAngleRadians(1.0f);
            if (this.inverted) {
                lllllllllllllllIIlIIlIlIllIlIlIl = 15 - lllllllllllllllIIlIIlIlIllIlIlIl;
            }
            if (lllllllllllllllIIlIIlIlIllIlIlIl > 0 && !this.inverted) {
                final float lllllllllllllllIIlIIlIlIllIlIIll = (lllllllllllllllIIlIIlIlIllIlIlII < 3.1415927f) ? 0.0f : 6.2831855f;
                lllllllllllllllIIlIIlIlIllIlIlII += (lllllllllllllllIIlIIlIlIllIlIIll - lllllllllllllllIIlIIlIlIllIlIlII) * 0.2f;
                lllllllllllllllIIlIIlIlIllIlIlIl = Math.round(lllllllllllllllIIlIIlIlIllIlIlIl * MathHelper.cos(lllllllllllllllIIlIIlIlIllIlIlII));
            }
            lllllllllllllllIIlIIlIlIllIlIlIl = MathHelper.clamp(lllllllllllllllIIlIIlIlIllIlIlIl, 0, 15);
            if (lllllllllllllllIIlIIlIlIllIlIllI.getValue((IProperty<Integer>)BlockDaylightDetector.POWER) != lllllllllllllllIIlIIlIlIllIlIlIl) {
                lllllllllllllllIIlIIlIlIllIlIIIl.setBlockState(lllllllllllllllIIlIIlIlIllIlIlll, lllllllllllllllIIlIIlIlIllIlIllI.withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, lllllllllllllllIIlIIlIlIllIlIlIl), 3);
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDaylightDetector.POWER });
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllIIlIIlIlIlIIlllII, final int lllllllllllllllIIlIIlIlIlIIllIll) {
        return new TileEntityDaylightDetector();
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIIlIIlIlIlIlIllII, final Random lllllllllllllllIIlIIlIlIlIlIlIll, final int lllllllllllllllIIlIIlIlIlIlIlIlI) {
        return Item.getItemFromBlock(Blocks.DAYLIGHT_DETECTOR);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIIlIIlIlIlIIIIIlI, final IBlockState lllllllllllllllIIlIIlIlIlIIIIIIl, final BlockPos lllllllllllllllIIlIIlIlIlIIIIIII, final EnumFacing lllllllllllllllIIlIIlIlIIllllllI) {
        return (lllllllllllllllIIlIIlIlIIllllllI == EnumFacing.DOWN) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    public BlockDaylightDetector(final boolean lllllllllllllllIIlIIlIlIlllIlllI) {
        super(Material.WOOD);
        this.inverted = lllllllllllllllIIlIIlIlIlllIlllI;
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockDaylightDetector.POWER, 0));
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setHardness(0.2f);
        this.setSoundType(SoundType.WOOD);
        this.setUnlocalizedName("daylightDetector");
    }
    
    static {
        POWER = PropertyInteger.create("power", 0, 15);
        DAYLIGHT_DETECTOR_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0);
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllllIIlIIlIlIlIIllllI) {
        return true;
    }
}
