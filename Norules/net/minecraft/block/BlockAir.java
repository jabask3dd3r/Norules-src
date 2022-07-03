package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import java.util.*;

public class BlockAir extends Block
{
    private static /* synthetic */ Map mapOriginalOpacity;
    
    @Override
    public void dropBlockAsItemWithChance(final World lllIlIIIIlIllll, final BlockPos lllIlIIIIlIlllI, final IBlockState lllIlIIIIlIllIl, final float lllIlIIIIlIllII, final int lllIlIIIIlIlIll) {
    }
    
    public static void restoreLightOpacity(final Block lllIlIIIIIllIll) {
        if (BlockAir.mapOriginalOpacity.containsKey(lllIlIIIIIllIll)) {
            final int lllIlIIIIIlllII = BlockAir.mapOriginalOpacity.get(lllIlIIIIIllIll);
            setLightOpacity(lllIlIIIIIllIll, lllIlIIIIIlllII);
        }
    }
    
    public static void setLightOpacity(final Block lllIlIIIIlIIIIl, final int lllIlIIIIlIIIlI) {
        if (!BlockAir.mapOriginalOpacity.containsKey(lllIlIIIIlIIIIl)) {
            BlockAir.mapOriginalOpacity.put(lllIlIIIIlIIIIl, lllIlIIIIlIIIIl.lightOpacity);
        }
        lllIlIIIIlIIIIl.lightOpacity = lllIlIIIIlIIIlI;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllIlIIIIlllIII, final IBlockAccess lllIlIIIIllIlll, final BlockPos lllIlIIIIllIllI) {
        return BlockAir.NULL_AABB;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllIlIIIIlllIlI) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    protected BlockAir() {
        super(Material.AIR);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllIlIIIIlIIllI) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllIlIIIIIllIII, final IBlockState lllIlIIIIIlIlll, final BlockPos lllIlIIIIIlIllI, final EnumFacing lllIlIIIIIlIlIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllIlIIIIllIlII) {
        return false;
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllIlIIIIlIlIIl, final BlockPos lllIlIIIIlIlIII) {
        return true;
    }
    
    static {
        BlockAir.mapOriginalOpacity = new IdentityHashMap();
    }
    
    @Override
    public boolean canCollideCheck(final IBlockState lllIlIIIIllIIlI, final boolean lllIlIIIIllIIIl) {
        return false;
    }
}
