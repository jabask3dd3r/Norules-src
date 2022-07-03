package net.minecraft.client.renderer;

import java.nio.*;
import net.minecraft.entity.player.*;
import org.lwjgl.util.glu.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;

public class ActiveRenderInfo
{
    private static final /* synthetic */ IntBuffer VIEWPORT;
    private static final /* synthetic */ FloatBuffer MODELVIEW;
    private static final /* synthetic */ FloatBuffer PROJECTION;
    private static /* synthetic */ float rotationX;
    private static /* synthetic */ float rotationXZ;
    private static /* synthetic */ float rotationZ;
    private static /* synthetic */ float rotationXY;
    private static /* synthetic */ Vec3d position;
    private static /* synthetic */ float rotationYZ;
    private static final /* synthetic */ FloatBuffer OBJECTCOORDS;
    
    static {
        VIEWPORT = GLAllocation.createDirectIntBuffer(16);
        MODELVIEW = GLAllocation.createDirectFloatBuffer(16);
        PROJECTION = GLAllocation.createDirectFloatBuffer(16);
        OBJECTCOORDS = GLAllocation.createDirectFloatBuffer(3);
        ActiveRenderInfo.position = new Vec3d(0.0, 0.0, 0.0);
    }
    
    public static float getRotationXY() {
        return ActiveRenderInfo.rotationXY;
    }
    
    public static void updateRenderInfo(final EntityPlayer lllllllllllllIlIIlIIIlIIlIlIlllI, final boolean lllllllllllllIlIIlIIIlIIlIlIllIl) {
        GlStateManager.getFloat(2982, ActiveRenderInfo.MODELVIEW);
        GlStateManager.getFloat(2983, ActiveRenderInfo.PROJECTION);
        GlStateManager.glGetInteger(2978, ActiveRenderInfo.VIEWPORT);
        final float lllllllllllllIlIIlIIIlIIlIlIllII = (float)((ActiveRenderInfo.VIEWPORT.get(0) + ActiveRenderInfo.VIEWPORT.get(2)) / 2);
        final float lllllllllllllIlIIlIIIlIIlIlIlIll = (float)((ActiveRenderInfo.VIEWPORT.get(1) + ActiveRenderInfo.VIEWPORT.get(3)) / 2);
        GLU.gluUnProject(lllllllllllllIlIIlIIIlIIlIlIllII, lllllllllllllIlIIlIIIlIIlIlIlIll, 0.0f, ActiveRenderInfo.MODELVIEW, ActiveRenderInfo.PROJECTION, ActiveRenderInfo.VIEWPORT, ActiveRenderInfo.OBJECTCOORDS);
        ActiveRenderInfo.position = new Vec3d(ActiveRenderInfo.OBJECTCOORDS.get(0), ActiveRenderInfo.OBJECTCOORDS.get(1), ActiveRenderInfo.OBJECTCOORDS.get(2));
        final int lllllllllllllIlIIlIIIlIIlIlIlIlI = lllllllllllllIlIIlIIIlIIlIlIllIl ? 1 : 0;
        final float lllllllllllllIlIIlIIIlIIlIlIlIIl = lllllllllllllIlIIlIIIlIIlIlIlllI.rotationPitch;
        final float lllllllllllllIlIIlIIIlIIlIlIlIII = lllllllllllllIlIIlIIIlIIlIlIlllI.rotationYaw;
        ActiveRenderInfo.rotationX = MathHelper.cos(lllllllllllllIlIIlIIIlIIlIlIlIII * 0.017453292f) * (1 - lllllllllllllIlIIlIIIlIIlIlIlIlI * 2);
        ActiveRenderInfo.rotationZ = MathHelper.sin(lllllllllllllIlIIlIIIlIIlIlIlIII * 0.017453292f) * (1 - lllllllllllllIlIIlIIIlIIlIlIlIlI * 2);
        ActiveRenderInfo.rotationYZ = -ActiveRenderInfo.rotationZ * MathHelper.sin(lllllllllllllIlIIlIIIlIIlIlIlIIl * 0.017453292f) * (1 - lllllllllllllIlIIlIIIlIIlIlIlIlI * 2);
        ActiveRenderInfo.rotationXY = ActiveRenderInfo.rotationX * MathHelper.sin(lllllllllllllIlIIlIIIlIIlIlIlIIl * 0.017453292f) * (1 - lllllllllllllIlIIlIIIlIIlIlIlIlI * 2);
        ActiveRenderInfo.rotationXZ = MathHelper.cos(lllllllllllllIlIIlIIIlIIlIlIlIIl * 0.017453292f);
    }
    
    public static Vec3d projectViewFromEntity(final Entity lllllllllllllIlIIlIIIlIIlIIllIII, final double lllllllllllllIlIIlIIIlIIlIIlIlll) {
        final double lllllllllllllIlIIlIIIlIIlIIlIllI = lllllllllllllIlIIlIIIlIIlIIllIII.prevPosX + (lllllllllllllIlIIlIIIlIIlIIllIII.posX - lllllllllllllIlIIlIIIlIIlIIllIII.prevPosX) * lllllllllllllIlIIlIIIlIIlIIlIlll;
        final double lllllllllllllIlIIlIIIlIIlIIlIlIl = lllllllllllllIlIIlIIIlIIlIIllIII.prevPosY + (lllllllllllllIlIIlIIIlIIlIIllIII.posY - lllllllllllllIlIIlIIIlIIlIIllIII.prevPosY) * lllllllllllllIlIIlIIIlIIlIIlIlll;
        final double lllllllllllllIlIIlIIIlIIlIIlIlII = lllllllllllllIlIIlIIIlIIlIIllIII.prevPosZ + (lllllllllllllIlIIlIIIlIIlIIllIII.posZ - lllllllllllllIlIIlIIIlIIlIIllIII.prevPosZ) * lllllllllllllIlIIlIIIlIIlIIlIlll;
        final double lllllllllllllIlIIlIIIlIIlIIlIIll = lllllllllllllIlIIlIIIlIIlIIlIllI + ActiveRenderInfo.position.xCoord;
        final double lllllllllllllIlIIlIIIlIIlIIlIIlI = lllllllllllllIlIIlIIIlIIlIIlIlIl + ActiveRenderInfo.position.yCoord;
        final double lllllllllllllIlIIlIIIlIIlIIlIIIl = lllllllllllllIlIIlIIIlIIlIIlIlII + ActiveRenderInfo.position.zCoord;
        return new Vec3d(lllllllllllllIlIIlIIIlIIlIIlIIll, lllllllllllllIlIIlIIIlIIlIIlIIlI, lllllllllllllIlIIlIIIlIIlIIlIIIl);
    }
    
    public static IBlockState getBlockStateAtEntityViewpoint(final World lllllllllllllIlIIlIIIlIIIllllIII, final Entity lllllllllllllIlIIlIIIlIIIlllllll, final float lllllllllllllIlIIlIIIlIIIlllIllI) {
        final Vec3d lllllllllllllIlIIlIIIlIIIlllllIl = projectViewFromEntity(lllllllllllllIlIIlIIIlIIIlllllll, lllllllllllllIlIIlIIIlIIIlllIllI);
        final BlockPos lllllllllllllIlIIlIIIlIIIlllllII = new BlockPos(lllllllllllllIlIIlIIIlIIIlllllIl);
        IBlockState lllllllllllllIlIIlIIIlIIIllllIll = lllllllllllllIlIIlIIIlIIIllllIII.getBlockState(lllllllllllllIlIIlIIIlIIIlllllII);
        if (lllllllllllllIlIIlIIIlIIIllllIll.getMaterial().isLiquid()) {
            float lllllllllllllIlIIlIIIlIIIllllIlI = 0.0f;
            if (lllllllllllllIlIIlIIIlIIIllllIll.getBlock() instanceof BlockLiquid) {
                lllllllllllllIlIIlIIIlIIIllllIlI = BlockLiquid.getLiquidHeightPercent(lllllllllllllIlIIlIIIlIIIllllIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL)) - 0.11111111f;
            }
            final float lllllllllllllIlIIlIIIlIIIllllIIl = lllllllllllllIlIIlIIIlIIIlllllII.getY() + 1 - lllllllllllllIlIIlIIIlIIIllllIlI;
            if (lllllllllllllIlIIlIIIlIIIlllllIl.yCoord >= lllllllllllllIlIIlIIIlIIIllllIIl) {
                lllllllllllllIlIIlIIIlIIIllllIll = lllllllllllllIlIIlIIIlIIIllllIII.getBlockState(lllllllllllllIlIIlIIIlIIIlllllII.up());
            }
        }
        return lllllllllllllIlIIlIIIlIIIllllIll;
    }
    
    public static float getRotationXZ() {
        return ActiveRenderInfo.rotationXZ;
    }
    
    public static float getRotationX() {
        return ActiveRenderInfo.rotationX;
    }
    
    public static float getRotationZ() {
        return ActiveRenderInfo.rotationZ;
    }
    
    public static float getRotationYZ() {
        return ActiveRenderInfo.rotationYZ;
    }
}
