package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.properties.*;

public class BlockPotato extends BlockCrops
{
    private static final /* synthetic */ AxisAlignedBB[] POTATO_AABB;
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIllllllIIlIIIlIlll, final BlockPos llllllllllllllIllllllIIlIIIlIllI, final IBlockState llllllllllllllIllllllIIlIIIIllll, final float llllllllllllllIllllllIIlIIIlIlII, final int llllllllllllllIllllllIIlIIIIllIl) {
        super.dropBlockAsItemWithChance(llllllllllllllIllllllIIlIIIlIlll, llllllllllllllIllllllIIlIIIlIllI, llllllllllllllIllllllIIlIIIIllll, llllllllllllllIllllllIIlIIIlIlII, llllllllllllllIllllllIIlIIIIllIl);
        if (!llllllllllllllIllllllIIlIIIlIlll.isRemote && this.isMaxAge(llllllllllllllIllllllIIlIIIIllll) && llllllllllllllIllllllIIlIIIlIlll.rand.nextInt(50) == 0) {
            Block.spawnAsEntity(llllllllllllllIllllllIIlIIIlIlll, llllllllllllllIllllllIIlIIIlIllI, new ItemStack(Items.POISONOUS_POTATO));
        }
    }
    
    @Override
    protected Item getCrop() {
        return Items.POTATO;
    }
    
    @Override
    protected Item getSeed() {
        return Items.POTATO;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIllllllIIlIIIIlIIl, final IBlockAccess llllllllllllllIllllllIIlIIIIlIII, final BlockPos llllllllllllllIllllllIIlIIIIIlll) {
        return BlockPotato.POTATO_AABB[llllllllllllllIllllllIIlIIIIlIIl.getValue((IProperty<Integer>)this.getAgeProperty())];
    }
    
    static {
        POTATO_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.1875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.25, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.4375, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5625, 1.0) };
    }
}
