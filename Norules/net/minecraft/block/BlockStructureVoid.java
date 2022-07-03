package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;

public class BlockStructureVoid extends Block
{
    private static final /* synthetic */ AxisAlignedBB STRUCTURE_VOID_AABB;
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIIIlllIIlIllIlIIl, final IBlockState lllllllllllllllIIIlllIIlIllIlIII, final BlockPos lllllllllllllllIIIlllIIlIllIIlll, final EnumFacing lllllllllllllllIIIlllIIlIllIIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIIIlllIIlIlllIlIl) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIIIlllIIlIllllIll, final IBlockAccess lllllllllllllllIIIlllIIlIllllIlI, final BlockPos lllllllllllllllIIIlllIIlIllllIIl) {
        return BlockStructureVoid.STRUCTURE_VOID_AABB;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllllllIIIlllIIlIllIlIll) {
        return EnumPushReaction.DESTROY;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllllIIIlllIIllIIIIIIl) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllllIIIlllIIlIlllllll, final IBlockAccess lllllllllllllllIIIlllIIlIllllllI, final BlockPos lllllllllllllllIIIlllIIlIlllllIl) {
        return BlockStructureVoid.NULL_AABB;
    }
    
    @Override
    public float getAmbientOcclusionLightValue(final IBlockState lllllllllllllllIIIlllIIlIlllIIll) {
        return 1.0f;
    }
    
    static {
        STRUCTURE_VOID_AABB = new AxisAlignedBB(0.3, 0.3, 0.3, 0.7, 0.7, 0.7);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIIIlllIIlIlllIlll) {
        return false;
    }
    
    protected BlockStructureVoid() {
        super(Material.STRUCTURE_VOID);
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllllIIIlllIIlIlllIIIl, final BlockPos lllllllllllllllIIIlllIIlIlllIIII, final IBlockState lllllllllllllllIIIlllIIlIllIllll, final float lllllllllllllllIIIlllIIlIllIlllI, final int lllllllllllllllIIIlllIIlIllIllIl) {
    }
}
