package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class BlockPressurePlateWeighted extends BlockBasePressurePlate
{
    public static final /* synthetic */ PropertyInteger POWER;
    private final /* synthetic */ int maxWeight;
    
    protected BlockPressurePlateWeighted(final Material lllllllllllllIIIlIIlIIllIllIllIl, final int lllllllllllllIIIlIIlIIllIllIllII, final MapColor lllllllllllllIIIlIIlIIllIllIlIll) {
        super(lllllllllllllIIIlIIlIIllIllIllIl, lllllllllllllIIIlIIlIIllIllIlIll);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockPressurePlateWeighted.POWER, 0));
        this.maxWeight = lllllllllllllIIIlIIlIIllIllIllII;
    }
    
    static {
        POWER = PropertyInteger.create("power", 0, 15);
    }
    
    protected BlockPressurePlateWeighted(final Material lllllllllllllIIIlIIlIIllIlllIlll, final int lllllllllllllIIIlIIlIIllIlllIllI) {
        this(lllllllllllllIIIlIIlIIllIlllIlll, lllllllllllllIIIlIIlIIllIlllIllI, lllllllllllllIIIlIIlIIllIlllIlll.getMaterialMapColor());
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockPressurePlateWeighted.POWER });
    }
    
    @Override
    public int tickRate(final World lllllllllllllIIIlIIlIIllIIllllIl) {
        return 10;
    }
    
    @Override
    protected int getRedstoneStrength(final IBlockState lllllllllllllIIIlIIlIIllIlIIIllI) {
        return lllllllllllllIIIlIIlIIllIlIIIllI.getValue((IProperty<Integer>)BlockPressurePlateWeighted.POWER);
    }
    
    @Override
    protected void playClickOffSound(final World lllllllllllllIIIlIIlIIllIlIIlIll, final BlockPos lllllllllllllIIIlIIlIIllIlIIllII) {
        lllllllllllllIIIlIIlIIllIlIIlIll.playSound(null, lllllllllllllIIIlIIlIIllIlIIllII, SoundEvents.BLOCK_METAL_PRESSPLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3f, 0.75f);
    }
    
    @Override
    protected int computeRedstoneStrength(final World lllllllllllllIIIlIIlIIllIllIIIII, final BlockPos lllllllllllllIIIlIIlIIllIlIlllll) {
        final int lllllllllllllIIIlIIlIIllIlIllllI = Math.min(lllllllllllllIIIlIIlIIllIllIIIII.getEntitiesWithinAABB((Class<? extends Entity>)Entity.class, BlockPressurePlateWeighted.PRESSURE_AABB.offset(lllllllllllllIIIlIIlIIllIlIlllll)).size(), this.maxWeight);
        if (lllllllllllllIIIlIIlIIllIlIllllI > 0) {
            final float lllllllllllllIIIlIIlIIllIlIlllIl = Math.min(this.maxWeight, lllllllllllllIIIlIIlIIllIlIllllI) / (float)this.maxWeight;
            return MathHelper.ceil(lllllllllllllIIIlIIlIIllIlIlllIl * 15.0f);
        }
        return 0;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIlIIlIIllIIllIIll) {
        return lllllllllllllIIIlIIlIIllIIllIIll.getValue((IProperty<Integer>)BlockPressurePlateWeighted.POWER);
    }
    
    @Override
    protected IBlockState setRedstoneStrength(final IBlockState lllllllllllllIIIlIIlIIllIlIIIIlI, final int lllllllllllllIIIlIIlIIllIlIIIIIl) {
        return lllllllllllllIIIlIIlIIllIlIIIIlI.withProperty((IProperty<Comparable>)BlockPressurePlateWeighted.POWER, lllllllllllllIIIlIIlIIllIlIIIIIl);
    }
    
    @Override
    protected void playClickOnSound(final World lllllllllllllIIIlIIlIIllIlIlIlII, final BlockPos lllllllllllllIIIlIIlIIllIlIlIIll) {
        lllllllllllllIIIlIIlIIllIlIlIlII.playSound(null, lllllllllllllIIIlIIlIIllIlIlIIll, SoundEvents.BLOCK_METAL_PRESSPLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3f, 0.90000004f);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIlIIlIIllIIlllIIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockPressurePlateWeighted.POWER, lllllllllllllIIIlIIlIIllIIlllIIl);
    }
}
