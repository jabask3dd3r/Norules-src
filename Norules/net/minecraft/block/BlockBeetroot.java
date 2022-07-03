package net.minecraft.block;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import java.util.*;

public class BlockBeetroot extends BlockCrops
{
    public static final /* synthetic */ PropertyInteger BEETROOT_AGE;
    private static final /* synthetic */ AxisAlignedBB[] BEETROOT_AABB;
    
    @Override
    protected PropertyInteger getAgeProperty() {
        return BlockBeetroot.BEETROOT_AGE;
    }
    
    @Override
    protected int getBonemealAgeIncrease(final World llllllllllllllllIlllIIllIIlllllI) {
        return super.getBonemealAgeIncrease(llllllllllllllllIlllIIllIIlllllI) / 3;
    }
    
    @Override
    protected Item getSeed() {
        return Items.BEETROOT_SEEDS;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBeetroot.BEETROOT_AGE });
    }
    
    static {
        BEETROOT_AGE = PropertyInteger.create("age", 0, 3);
        BEETROOT_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0) };
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllllIlllIIllIIllIlIl, final IBlockAccess llllllllllllllllIlllIIllIIllIlII, final BlockPos llllllllllllllllIlllIIllIIllIIll) {
        return BlockBeetroot.BEETROOT_AABB[llllllllllllllllIlllIIllIIllIlIl.getValue((IProperty<Integer>)this.getAgeProperty())];
    }
    
    @Override
    public int getMaxAge() {
        return 3;
    }
    
    @Override
    protected Item getCrop() {
        return Items.BEETROOT;
    }
    
    @Override
    public void updateTick(final World llllllllllllllllIlllIIllIlIIIlIl, final BlockPos llllllllllllllllIlllIIllIlIIIlII, final IBlockState llllllllllllllllIlllIIllIlIIIIll, final Random llllllllllllllllIlllIIllIlIIIlll) {
        if (llllllllllllllllIlllIIllIlIIIlll.nextInt(3) == 0) {
            this.checkAndDropBlock(llllllllllllllllIlllIIllIlIIIlIl, llllllllllllllllIlllIIllIlIIIlII, llllllllllllllllIlllIIllIlIIIIll);
        }
        else {
            super.updateTick(llllllllllllllllIlllIIllIlIIIlIl, llllllllllllllllIlllIIllIlIIIlII, llllllllllllllllIlllIIllIlIIIIll, llllllllllllllllIlllIIllIlIIIlll);
        }
    }
}
