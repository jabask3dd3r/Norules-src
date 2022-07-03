package net.minecraft.block.state;

import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public interface IBlockProperties
{
    int getLightValue();
    
    boolean isBlockNormalCube();
    
    boolean isFullyOpaque();
    
    boolean isFullBlock();
    
    float getBlockHardness(final World p0, final BlockPos p1);
    
    boolean isNormalCube();
    
    AxisAlignedBB getBoundingBox(final IBlockAccess p0, final BlockPos p1);
    
    boolean shouldSideBeRendered(final IBlockAccess p0, final BlockPos p1, final EnumFacing p2);
    
    EnumPushReaction getMobilityFlag();
    
    int getComparatorInputOverride(final World p0, final BlockPos p1);
    
    float getPlayerRelativeBlockHardness(final EntityPlayer p0, final World p1, final BlockPos p2);
    
    IBlockState withMirror(final Mirror p0);
    
    AxisAlignedBB getSelectedBoundingBox(final World p0, final BlockPos p1);
    
    void addCollisionBoxToList(final World p0, final BlockPos p1, final AxisAlignedBB p2, final List<AxisAlignedBB> p3, final Entity p4, final boolean p5);
    
    boolean isOpaqueCube();
    
    int getStrongPower(final IBlockAccess p0, final BlockPos p1, final EnumFacing p2);
    
    RayTraceResult collisionRayTrace(final World p0, final BlockPos p1, final Vec3d p2, final Vec3d p3);
    
    @Nullable
    AxisAlignedBB getCollisionBoundingBox(final IBlockAccess p0, final BlockPos p1);
    
    boolean isTranslucent();
    
    float getAmbientOcclusionLightValue();
    
    boolean useNeighborBrightness();
    
    boolean canEntitySpawn(final Entity p0);
    
    int getPackedLightmapCoords(final IBlockAccess p0, final BlockPos p1);
    
    boolean func_191057_i();
    
    int getLightOpacity();
    
    EnumBlockRenderType getRenderType();
    
    IBlockState withRotation(final Rotation p0);
    
    int getWeakPower(final IBlockAccess p0, final BlockPos p1, final EnumFacing p2);
    
    Vec3d func_191059_e(final IBlockAccess p0, final BlockPos p1);
    
    boolean isFullCube();
    
    boolean func_191058_s();
    
    boolean hasComparatorInputOverride();
    
    MapColor getMapColor(final IBlockAccess p0, final BlockPos p1);
    
    IBlockState getActualState(final IBlockAccess p0, final BlockPos p1);
    
    Material getMaterial();
    
    boolean canProvidePower();
    
    BlockFaceShape func_193401_d(final IBlockAccess p0, final BlockPos p1, final EnumFacing p2);
}
