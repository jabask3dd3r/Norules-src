package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.item.*;

public class BlockRedstoneRepeater extends BlockRedstoneDiode
{
    public static final /* synthetic */ PropertyBool LOCKED;
    public static final /* synthetic */ PropertyInteger DELAY;
    
    @Override
    protected int getDelay(final IBlockState lllllllllllllIIllllIlIlllIlIIIll) {
        return lllllllllllllIIllllIlIlllIlIIIll.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY) * 2;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIllllIlIlllIllllII, final Mirror lllllllllllllIIllllIlIlllIlllIll) {
        return lllllllllllllIIllllIlIlllIllllII.withRotation(lllllllllllllIIllllIlIlllIlllIll.toRotation(lllllllllllllIIllllIlIlllIllllII.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING)));
    }
    
    @Override
    protected IBlockState getPoweredState(final IBlockState lllllllllllllIIllllIlIlllIIllIIl) {
        final Integer lllllllllllllIIllllIlIlllIIlllII = lllllllllllllIIllllIlIlllIIllIIl.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY);
        final Boolean lllllllllllllIIllllIlIlllIIllIll = lllllllllllllIIllllIlIlllIIllIIl.getValue((IProperty<Boolean>)BlockRedstoneRepeater.LOCKED);
        final EnumFacing lllllllllllllIIllllIlIlllIIllIlI = lllllllllllllIIllllIlIlllIIllIIl.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING);
        return Blocks.POWERED_REPEATER.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, lllllllllllllIIllllIlIlllIIllIlI).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY, lllllllllllllIIllllIlIlllIIlllII).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, lllllllllllllIIllllIlIlllIIllIll);
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIIllllIlIllIlIIIIll, final BlockPos lllllllllllllIIllllIlIllIlIIIllI, final IBlockState lllllllllllllIIllllIlIllIlIIIlIl) {
        super.breakBlock(lllllllllllllIIllllIlIllIlIIIIll, lllllllllllllIIllllIlIllIlIIIllI, lllllllllllllIIllllIlIllIlIIIlIl);
        this.notifyNeighbors(lllllllllllllIIllllIlIllIlIIIIll, lllllllllllllIIllllIlIllIlIIIllI, lllllllllllllIIllllIlIllIlIIIlIl);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIllllIlIllIIllIlll) {
        int lllllllllllllIIllllIlIllIIllIllI = 0;
        lllllllllllllIIllllIlIllIIllIllI |= lllllllllllllIIllllIlIllIIllIlll.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING).getHorizontalIndex();
        lllllllllllllIIllllIlIllIIllIllI |= lllllllllllllIIllllIlIllIIllIlll.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY) - 1 << 2;
        return lllllllllllllIIllllIlIllIIllIllI;
    }
    
    @Override
    public boolean isLocked(final IBlockAccess lllllllllllllIIllllIlIllIlllIlll, final BlockPos lllllllllllllIIllllIlIllIllllIlI, final IBlockState lllllllllllllIIllllIlIllIlllIlIl) {
        return this.getPowerOnSides(lllllllllllllIIllllIlIllIlllIlll, lllllllllllllIIllllIlIllIllllIlI, lllllllllllllIIllllIlIllIlllIlIl) > 0;
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.diode.name");
    }
    
    @Override
    protected IBlockState getUnpoweredState(final IBlockState lllllllllllllIIllllIlIlllIIIllII) {
        final Integer lllllllllllllIIllllIlIlllIIIllll = lllllllllllllIIllllIlIlllIIIllII.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY);
        final Boolean lllllllllllllIIllllIlIlllIIIlllI = lllllllllllllIIllllIlIlllIIIllII.getValue((IProperty<Boolean>)BlockRedstoneRepeater.LOCKED);
        final EnumFacing lllllllllllllIIllllIlIlllIIIllIl = lllllllllllllIIllllIlIlllIIIllII.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING);
        return Blocks.UNPOWERED_REPEATER.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, lllllllllllllIIllllIlIlllIIIllIl).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY, lllllllllllllIIllllIlIlllIIIllll).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, lllllllllllllIIllllIlIlllIIIlllI);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIllllIlIlllIIIIIll, final BlockPos lllllllllllllIIllllIlIlllIIIIIlI, final IBlockState lllllllllllllIIllllIlIlllIIIIIIl) {
        return new ItemStack(Items.REPEATER);
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllIIllllIlIllIllIIIll, final World lllllllllllllIIllllIlIllIlIlIllI, final BlockPos lllllllllllllIIllllIlIllIlIlIlIl, final Random lllllllllllllIIllllIlIllIllIIIII) {
        if (this.isRepeaterPowered) {
            final EnumFacing lllllllllllllIIllllIlIllIlIlllll = lllllllllllllIIllllIlIllIllIIIll.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING);
            final double lllllllllllllIIllllIlIllIlIllllI = lllllllllllllIIllllIlIllIlIlIlIl.getX() + 0.5f + (lllllllllllllIIllllIlIllIllIIIII.nextFloat() - 0.5f) * 0.2;
            final double lllllllllllllIIllllIlIllIlIlllIl = lllllllllllllIIllllIlIllIlIlIlIl.getY() + 0.4f + (lllllllllllllIIllllIlIllIllIIIII.nextFloat() - 0.5f) * 0.2;
            final double lllllllllllllIIllllIlIllIlIlllII = lllllllllllllIIllllIlIllIlIlIlIl.getZ() + 0.5f + (lllllllllllllIIllllIlIllIllIIIII.nextFloat() - 0.5f) * 0.2;
            float lllllllllllllIIllllIlIllIlIllIll = -5.0f;
            if (lllllllllllllIIllllIlIllIllIIIII.nextBoolean()) {
                lllllllllllllIIllllIlIllIlIllIll = (float)(lllllllllllllIIllllIlIllIllIIIll.getValue((IProperty<Integer>)BlockRedstoneRepeater.DELAY) * 2 - 1);
            }
            lllllllllllllIIllllIlIllIlIllIll /= 16.0f;
            final double lllllllllllllIIllllIlIllIlIllIlI = lllllllllllllIIllllIlIllIlIllIll * lllllllllllllIIllllIlIllIlIlllll.getFrontOffsetX();
            final double lllllllllllllIIllllIlIllIlIllIIl = lllllllllllllIIllllIlIllIlIllIll * lllllllllllllIIllllIlIllIlIlllll.getFrontOffsetZ();
            lllllllllllllIIllllIlIllIlIlIllI.spawnParticle(EnumParticleTypes.REDSTONE, lllllllllllllIIllllIlIllIlIllllI + lllllllllllllIIllllIlIllIlIllIlI, lllllllllllllIIllllIlIllIlIlllIl, lllllllllllllIIllllIlIllIlIlllII + lllllllllllllIIllllIlIllIlIllIIl, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIllllIlIllllIIIIll, final Rotation lllllllllllllIIllllIlIllllIIIIlI) {
        return lllllllllllllIIllllIlIllllIIIIll.withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, lllllllllllllIIllllIlIllllIIIIlI.rotate(lllllllllllllIIllllIlIllllIIIIll.getValue((IProperty<EnumFacing>)BlockRedstoneRepeater.FACING)));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIllllIlIllIIlllIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, EnumFacing.getHorizontal(lllllllllllllIIllllIlIllIIlllIll)).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, false).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY, 1 + (lllllllllllllIIllllIlIllIIlllIll >> 2));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRedstoneRepeater.FACING, BlockRedstoneRepeater.DELAY, BlockRedstoneRepeater.LOCKED });
    }
    
    @Override
    protected boolean isAlternateInput(final IBlockState lllllllllllllIIllllIlIllIlllIIIl) {
        return BlockRedstoneDiode.isDiode(lllllllllllllIIllllIlIllIlllIIIl);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIllllIlIlllIllIIll, final BlockPos lllllllllllllIIllllIlIlllIllIIlI, final IBlockState lllllllllllllIIllllIlIlllIllIIIl, final EntityPlayer lllllllllllllIIllllIlIlllIlIIlll, final EnumHand lllllllllllllIIllllIlIlllIlIllll, final EnumFacing lllllllllllllIIllllIlIlllIlIlllI, final float lllllllllllllIIllllIlIlllIlIllIl, final float lllllllllllllIIllllIlIlllIlIllII, final float lllllllllllllIIllllIlIlllIlIlIll) {
        if (!lllllllllllllIIllllIlIlllIlIIlll.capabilities.allowEdit) {
            return false;
        }
        lllllllllllllIIllllIlIlllIllIIll.setBlockState(lllllllllllllIIllllIlIlllIllIIlI, lllllllllllllIIllllIlIlllIllIIIl.cycleProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY), 3);
        return true;
    }
    
    static {
        LOCKED = PropertyBool.create("locked");
        DELAY = PropertyInteger.create("delay", 1, 4);
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllIIllllIlIllllIIlIIl, final IBlockAccess lllllllllllllIIllllIlIllllIIlIII, final BlockPos lllllllllllllIIllllIlIllllIIlIll) {
        return lllllllllllllIIllllIlIllllIIlIIl.withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, this.isLocked(lllllllllllllIIllllIlIllllIIlIII, lllllllllllllIIllllIlIllllIIlIll, lllllllllllllIIllllIlIllllIIlIIl));
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIllllIlIlllIIIIlll, final Random lllllllllllllIIllllIlIlllIIIIllI, final int lllllllllllllIIllllIlIlllIIIIlIl) {
        return Items.REPEATER;
    }
    
    protected BlockRedstoneRepeater(final boolean lllllllllllllIIllllIlIllllIlIllI) {
        super(lllllllllllllIIllllIlIllllIlIllI);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockRedstoneRepeater.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.DELAY, 1).withProperty((IProperty<Comparable>)BlockRedstoneRepeater.LOCKED, false));
    }
}
