package net.minecraft.block;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;

public class BlockCarrot extends BlockCrops
{
    private static final /* synthetic */ AxisAlignedBB[] CARROT_AABB;
    
    @Override
    protected Item getCrop() {
        return Items.CARROT;
    }
    
    static {
        CARROT_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.1875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.4375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5625, 1.0) };
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIIIIIIllIlIlIlIlII, final IBlockAccess llllllllllllllIIIIIIllIlIlIlIlll, final BlockPos llllllllllllllIIIIIIllIlIlIlIllI) {
        return BlockCarrot.CARROT_AABB[llllllllllllllIIIIIIllIlIlIlIlII.getValue((IProperty<Integer>)this.getAgeProperty())];
    }
    
    @Override
    protected Item getSeed() {
        return Items.CARROT;
    }
}
