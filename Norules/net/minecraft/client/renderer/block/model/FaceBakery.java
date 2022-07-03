package net.minecraft.client.renderer.block.model;

import net.minecraft.util.*;
import net.minecraftforge.common.model.*;
import net.minecraft.client.renderer.texture.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import optifine.*;
import shadersmod.client.*;
import org.lwjgl.util.vector.*;
import net.minecraft.client.renderer.vertex.*;

public class FaceBakery
{
    private static final /* synthetic */ Rotation UV_ROTATION_270;
    private static final /* synthetic */ float SCALE_ROTATION_22_5;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    private static final /* synthetic */ Rotation UV_ROTATION_90;
    private static final /* synthetic */ float SCALE_ROTATION_GENERAL;
    private static final /* synthetic */ Rotation UV_ROTATION_INVERSE;
    private static final /* synthetic */ Rotation UV_ROTATION_0;
    private static final /* synthetic */ Rotation[] UV_ROTATIONS;
    
    private BlockFaceUV applyUVLock(final BlockFaceUV llllllllllllllIIIIlIlIllIIIIIIIl, final EnumFacing llllllllllllllIIIIlIlIlIllllllII, final ModelRotation llllllllllllllIIIIlIlIlIlllllIlI) {
        return FaceBakery.UV_ROTATIONS[getIndex(llllllllllllllIIIIlIlIlIlllllIlI, llllllllllllllIIIIlIlIlIllllllII)].rotateUV(llllllllllllllIIIIlIlIllIIIIIIIl);
    }
    
    private void rotateScale(final Vector3f llllllllllllllIIIIlIlIlIIIIIlIIl, final Vector3f llllllllllllllIIIIlIlIlIIIIIlIII, final Matrix4f llllllllllllllIIIIlIlIlIIIIIIIlI, final Vector3f llllllllllllllIIIIlIlIlIIIIIIIIl) {
        final Vector4f llllllllllllllIIIIlIlIlIIIIIIlIl = new Vector4f(llllllllllllllIIIIlIlIlIIIIIlIIl.x - llllllllllllllIIIIlIlIlIIIIIlIII.x, llllllllllllllIIIIlIlIlIIIIIlIIl.y - llllllllllllllIIIIlIlIlIIIIIlIII.y, llllllllllllllIIIIlIlIlIIIIIlIIl.z - llllllllllllllIIIIlIlIlIIIIIlIII.z, 1.0f);
        Matrix4f.transform(llllllllllllllIIIIlIlIlIIIIIIIlI, llllllllllllllIIIIlIlIlIIIIIIlIl, llllllllllllllIIIIlIlIlIIIIIIlIl);
        final Vector4f vector4f = llllllllllllllIIIIlIlIlIIIIIIlIl;
        vector4f.x *= llllllllllllllIIIIlIlIlIIIIIIIIl.x;
        final Vector4f vector4f2 = llllllllllllllIIIIlIlIlIIIIIIlIl;
        vector4f2.y *= llllllllllllllIIIIlIlIlIIIIIIIIl.y;
        final Vector4f vector4f3 = llllllllllllllIIIIlIlIlIIIIIIlIl;
        vector4f3.z *= llllllllllllllIIIIlIlIlIIIIIIIIl.z;
        llllllllllllllIIIIlIlIlIIIIIlIIl.set(llllllllllllllIIIIlIlIlIIIIIIlIl.x + llllllllllllllIIIIlIlIlIIIIIlIII.x, llllllllllllllIIIIlIlIlIIIIIIlIl.y + llllllllllllllIIIIlIlIlIIIIIlIII.y, llllllllllllllIIIIlIlIlIIIIIIlIl.z + llllllllllllllIIIIlIlIlIIIIIlIII.z);
    }
    
    public int rotateVertex(final Vector3f llllllllllllllIIIIlIlIlIIIIlIIll, final EnumFacing llllllllllllllIIIIlIlIlIIIIlIlll, final int llllllllllllllIIIIlIlIlIIIIlIllI, final ITransformation llllllllllllllIIIIlIlIlIIIIlIIII) {
        if (llllllllllllllIIIIlIlIlIIIIlIIII == ModelRotation.X0_Y0) {
            return llllllllllllllIIIIlIlIlIIIIlIllI;
        }
        if (Reflector.ForgeHooksClient_transform.exists()) {
            Reflector.call(Reflector.ForgeHooksClient_transform, llllllllllllllIIIIlIlIlIIIIlIIll, llllllllllllllIIIIlIlIlIIIIlIIII.getMatrix());
        }
        else {
            this.rotateScale(llllllllllllllIIIIlIlIlIIIIlIIll, new Vector3f(0.5f, 0.5f, 0.5f), ((ModelRotation)llllllllllllllIIIIlIlIlIIIIlIIII).getMatrix4d(), new Vector3f(1.0f, 1.0f, 1.0f));
        }
        return llllllllllllllIIIIlIlIlIIIIlIIII.rotate(llllllllllllllIIIIlIlIlIIIIlIlll, llllllllllllllIIIIlIlIlIIIIlIllI);
    }
    
    public static EnumFacing getFacingFromVertexData(final int[] llllllllllllllIIIIlIlIIlllIllIII) {
        final int llllllllllllllIIIIlIlIIllllIIlll = llllllllllllllIIIIlIlIIlllIllIII.length / 4;
        final int llllllllllllllIIIIlIlIIllllIIllI = llllllllllllllIIIIlIlIIllllIIlll * 2;
        final Vector3f llllllllllllllIIIIlIlIIllllIIlIl = new Vector3f(Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[0]), Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[1]), Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[2]));
        final Vector3f llllllllllllllIIIIlIlIIllllIIlII = new Vector3f(Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[llllllllllllllIIIIlIlIIllllIIlll]), Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[llllllllllllllIIIIlIlIIllllIIlll + 1]), Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[llllllllllllllIIIIlIlIIllllIIlll + 2]));
        final Vector3f llllllllllllllIIIIlIlIIllllIIIll = new Vector3f(Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[llllllllllllllIIIIlIlIIllllIIllI]), Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[llllllllllllllIIIIlIlIIllllIIllI + 1]), Float.intBitsToFloat(llllllllllllllIIIIlIlIIlllIllIII[llllllllllllllIIIIlIlIIllllIIllI + 2]));
        final Vector3f llllllllllllllIIIIlIlIIllllIIIlI = new Vector3f();
        final Vector3f llllllllllllllIIIIlIlIIllllIIIIl = new Vector3f();
        final Vector3f llllllllllllllIIIIlIlIIllllIIIII = new Vector3f();
        Vector3f.sub(llllllllllllllIIIIlIlIIllllIIlIl, llllllllllllllIIIIlIlIIllllIIlII, llllllllllllllIIIIlIlIIllllIIIlI);
        Vector3f.sub(llllllllllllllIIIIlIlIIllllIIIll, llllllllllllllIIIIlIlIIllllIIlII, llllllllllllllIIIIlIlIIllllIIIIl);
        Vector3f.cross(llllllllllllllIIIIlIlIIllllIIIIl, llllllllllllllIIIIlIlIIllllIIIlI, llllllllllllllIIIIlIlIIllllIIIII);
        final float llllllllllllllIIIIlIlIIlllIlllll = (float)Math.sqrt(llllllllllllllIIIIlIlIIllllIIIII.x * llllllllllllllIIIIlIlIIllllIIIII.x + llllllllllllllIIIIlIlIIllllIIIII.y * llllllllllllllIIIIlIlIIllllIIIII.y + llllllllllllllIIIIlIlIIllllIIIII.z * llllllllllllllIIIIlIlIIllllIIIII.z);
        final Vector3f vector3f = llllllllllllllIIIIlIlIIllllIIIII;
        vector3f.x /= llllllllllllllIIIIlIlIIlllIlllll;
        final Vector3f vector3f2 = llllllllllllllIIIIlIlIIllllIIIII;
        vector3f2.y /= llllllllllllllIIIIlIlIIlllIlllll;
        final Vector3f vector3f3 = llllllllllllllIIIIlIlIIllllIIIII;
        vector3f3.z /= llllllllllllllIIIIlIlIIlllIlllll;
        EnumFacing llllllllllllllIIIIlIlIIlllIllllI = null;
        float llllllllllllllIIIIlIlIIlllIlllIl = 0.0f;
        final float llllllllllllllIIIIlIlIIlllIIlIIl;
        final long llllllllllllllIIIIlIlIIlllIIlIlI = ((EnumFacing[])(Object)(llllllllllllllIIIIlIlIIlllIIlIIl = (float)(Object)EnumFacing.values())).length;
        for (float llllllllllllllIIIIlIlIIlllIIlIll = 0; llllllllllllllIIIIlIlIIlllIIlIll < llllllllllllllIIIIlIlIIlllIIlIlI; ++llllllllllllllIIIIlIlIIlllIIlIll) {
            final EnumFacing llllllllllllllIIIIlIlIIlllIlllII = llllllllllllllIIIIlIlIIlllIIlIIl[llllllllllllllIIIIlIlIIlllIIlIll];
            final Vec3i llllllllllllllIIIIlIlIIlllIllIll = llllllllllllllIIIIlIlIIlllIlllII.getDirectionVec();
            final Vector3f llllllllllllllIIIIlIlIIlllIllIlI = new Vector3f((float)llllllllllllllIIIIlIlIIlllIllIll.getX(), (float)llllllllllllllIIIIlIlIIlllIllIll.getY(), (float)llllllllllllllIIIIlIlIIlllIllIll.getZ());
            final float llllllllllllllIIIIlIlIIlllIllIIl = Vector3f.dot(llllllllllllllIIIIlIlIIllllIIIII, llllllllllllllIIIIlIlIIlllIllIlI);
            if (llllllllllllllIIIIlIlIIlllIllIIl >= 0.0f && llllllllllllllIIIIlIlIIlllIllIIl > llllllllllllllIIIIlIlIIlllIlllIl) {
                llllllllllllllIIIIlIlIIlllIlllIl = llllllllllllllIIIIlIlIIlllIllIIl;
                llllllllllllllIIIIlIlIIlllIllllI = llllllllllllllIIIIlIlIIlllIlllII;
            }
        }
        if (llllllllllllllIIIIlIlIIlllIllllI == null) {
            return EnumFacing.UP;
        }
        return llllllllllllllIIIIlIlIIlllIllllI;
    }
    
    private void fillVertexData(final int[] llllllllllllllIIIIlIlIlIIlllIlIl, final int llllllllllllllIIIIlIlIlIIllIIlIl, final EnumFacing llllllllllllllIIIIlIlIlIIlllIIll, final BlockFaceUV llllllllllllllIIIIlIlIlIIllIIIll, final float[] llllllllllllllIIIIlIlIlIIllIIIlI, final TextureAtlasSprite llllllllllllllIIIIlIlIlIIlllIIII, final ITransformation llllllllllllllIIIIlIlIlIIllIIIII, @Nullable final BlockPartRotation llllllllllllllIIIIlIlIlIIlIlllll, final boolean llllllllllllllIIIIlIlIlIIlIllllI) {
        final EnumFacing llllllllllllllIIIIlIlIlIIllIllII = llllllllllllllIIIIlIlIlIIllIIIII.rotate(llllllllllllllIIIIlIlIlIIlllIIll);
        final int llllllllllllllIIIIlIlIlIIllIlIll = llllllllllllllIIIIlIlIlIIlIllllI ? this.getFaceShadeColor(llllllllllllllIIIIlIlIlIIllIllII) : -1;
        final EnumFaceDirection.VertexInformation llllllllllllllIIIIlIlIlIIllIlIlI = EnumFaceDirection.getFacing(llllllllllllllIIIIlIlIlIIlllIIll).getVertexInformation(llllllllllllllIIIIlIlIlIIllIIlIl);
        final Vector3f llllllllllllllIIIIlIlIlIIllIlIIl = new Vector3f(llllllllllllllIIIIlIlIlIIllIIIlI[llllllllllllllIIIIlIlIlIIllIlIlI.xIndex], llllllllllllllIIIIlIlIlIIllIIIlI[llllllllllllllIIIIlIlIlIIllIlIlI.yIndex], llllllllllllllIIIIlIlIlIIllIIIlI[llllllllllllllIIIIlIlIlIIllIlIlI.zIndex]);
        this.rotatePart(llllllllllllllIIIIlIlIlIIllIlIIl, llllllllllllllIIIIlIlIlIIlIlllll);
        final int llllllllllllllIIIIlIlIlIIllIlIII = this.rotateVertex(llllllllllllllIIIIlIlIlIIllIlIIl, llllllllllllllIIIIlIlIlIIlllIIll, llllllllllllllIIIIlIlIlIIllIIlIl, llllllllllllllIIIIlIlIlIIllIIIII);
        BlockModelUtils.snapVertexPosition(llllllllllllllIIIIlIlIlIIllIlIIl);
        this.storeVertexData(llllllllllllllIIIIlIlIlIIlllIlIl, llllllllllllllIIIIlIlIlIIllIlIII, llllllllllllllIIIIlIlIlIIllIIlIl, llllllllllllllIIIIlIlIlIIllIlIIl, llllllllllllllIIIIlIlIlIIllIlIll, llllllllllllllIIIIlIlIlIIlllIIII, llllllllllllllIIIIlIlIlIIllIIIll);
    }
    
    private void storeVertexData(final int[] llllllllllllllIIIIlIlIlIIlIIIlIl, final int llllllllllllllIIIIlIlIlIIlIIllIl, final int llllllllllllllIIIIlIlIlIIlIIllII, final Vector3f llllllllllllllIIIIlIlIlIIlIIlIll, final int llllllllllllllIIIIlIlIlIIlIIlIlI, final TextureAtlasSprite llllllllllllllIIIIlIlIlIIlIIIIII, final BlockFaceUV llllllllllllllIIIIlIlIlIIlIIlIII) {
        final int llllllllllllllIIIIlIlIlIIlIIIlll = llllllllllllllIIIIlIlIlIIlIIIlIl.length / 4;
        final int llllllllllllllIIIIlIlIlIIlIIIllI = llllllllllllllIIIIlIlIlIIlIIllIl * llllllllllllllIIIIlIlIlIIlIIIlll;
        llllllllllllllIIIIlIlIlIIlIIIlIl[llllllllllllllIIIIlIlIlIIlIIIllI] = Float.floatToRawIntBits(llllllllllllllIIIIlIlIlIIlIIlIll.x);
        llllllllllllllIIIIlIlIlIIlIIIlIl[llllllllllllllIIIIlIlIlIIlIIIllI + 1] = Float.floatToRawIntBits(llllllllllllllIIIIlIlIlIIlIIlIll.y);
        llllllllllllllIIIIlIlIlIIlIIIlIl[llllllllllllllIIIIlIlIlIIlIIIllI + 2] = Float.floatToRawIntBits(llllllllllllllIIIIlIlIlIIlIIlIll.z);
        llllllllllllllIIIIlIlIlIIlIIIlIl[llllllllllllllIIIIlIlIlIIlIIIllI + 3] = llllllllllllllIIIIlIlIlIIlIIlIlI;
        llllllllllllllIIIIlIlIlIIlIIIlIl[llllllllllllllIIIIlIlIlIIlIIIllI + 4] = Float.floatToRawIntBits(llllllllllllllIIIIlIlIlIIlIIIIII.getInterpolatedU(llllllllllllllIIIIlIlIlIIlIIlIII.getVertexU(llllllllllllllIIIIlIlIlIIlIIllII) * 0.999 + llllllllllllllIIIIlIlIlIIlIIlIII.getVertexU((llllllllllllllIIIIlIlIlIIlIIllII + 2) % 4) * 0.001));
        llllllllllllllIIIIlIlIlIIlIIIlIl[llllllllllllllIIIIlIlIlIIlIIIllI + 4 + 1] = Float.floatToRawIntBits(llllllllllllllIIIIlIlIlIIlIIIIII.getInterpolatedV(llllllllllllllIIIIlIlIlIIlIIlIII.getVertexV(llllllllllllllIIIIlIlIlIIlIIllII) * 0.999 + llllllllllllllIIIIlIlIlIIlIIlIII.getVertexV((llllllllllllllIIIIlIlIlIIlIIllII + 2) % 4) * 0.001));
    }
    
    private int getFaceShadeColor(final EnumFacing llllllllllllllIIIIlIlIlIlIIlIlIl) {
        final float llllllllllllllIIIIlIlIlIlIIlIlll = getFaceBrightness(llllllllllllllIIIIlIlIlIlIIlIlIl);
        final int llllllllllllllIIIIlIlIlIlIIlIllI = MathHelper.clamp((int)(llllllllllllllIIIIlIlIlIlIIlIlll * 255.0f), 0, 255);
        return 0xFF000000 | llllllllllllllIIIIlIlIlIlIIlIllI << 16 | llllllllllllllIIIIlIlIlIlIIlIllI << 8 | llllllllllllllIIIIlIlIlIlIIlIllI;
    }
    
    public static float getFaceBrightness(final EnumFacing llllllllllllllIIIIlIlIlIlIIlIIII) {
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllllIIIIlIlIlIlIIlIIII.ordinal()]) {
            case 1: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel05;
                }
                return 0.5f;
            }
            case 2: {
                return 1.0f;
            }
            case 3:
            case 4: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel08;
                }
                return 0.8f;
            }
            case 5:
            case 6: {
                if (Config.isShaders()) {
                    return Shaders.blockLightLevel06;
                }
                return 0.6f;
            }
            default: {
                return 1.0f;
            }
        }
    }
    
    private void rotatePart(final Vector3f llllllllllllllIIIIlIlIlIIIllIIIl, @Nullable final BlockPartRotation llllllllllllllIIIIlIlIlIIIllIlIl) {
        if (llllllllllllllIIIIlIlIlIIIllIlIl != null) {
            final Matrix4f llllllllllllllIIIIlIlIlIIIllIlII = this.getMatrixIdentity();
            final Vector3f llllllllllllllIIIIlIlIlIIIllIIll = new Vector3f(0.0f, 0.0f, 0.0f);
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[llllllllllllllIIIIlIlIlIIIllIlIl.axis.ordinal()]) {
                case 1: {
                    Matrix4f.rotate(llllllllllllllIIIIlIlIlIIIllIlIl.angle * 0.017453292f, new Vector3f(1.0f, 0.0f, 0.0f), llllllllllllllIIIIlIlIlIIIllIlII, llllllllllllllIIIIlIlIlIIIllIlII);
                    llllllllllllllIIIIlIlIlIIIllIIll.set(0.0f, 1.0f, 1.0f);
                    break;
                }
                case 2: {
                    Matrix4f.rotate(llllllllllllllIIIIlIlIlIIIllIlIl.angle * 0.017453292f, new Vector3f(0.0f, 1.0f, 0.0f), llllllllllllllIIIIlIlIlIIIllIlII, llllllllllllllIIIIlIlIlIIIllIlII);
                    llllllllllllllIIIIlIlIlIIIllIIll.set(1.0f, 0.0f, 1.0f);
                    break;
                }
                case 3: {
                    Matrix4f.rotate(llllllllllllllIIIIlIlIlIIIllIlIl.angle * 0.017453292f, new Vector3f(0.0f, 0.0f, 1.0f), llllllllllllllIIIIlIlIlIIIllIlII, llllllllllllllIIIIlIlIlIIIllIlII);
                    llllllllllllllIIIIlIlIlIIIllIIll.set(1.0f, 1.0f, 0.0f);
                    break;
                }
            }
            if (llllllllllllllIIIIlIlIlIIIllIlIl.rescale) {
                if (Math.abs(llllllllllllllIIIIlIlIlIIIllIlIl.angle) == 22.5f) {
                    llllllllllllllIIIIlIlIlIIIllIIll.scale(FaceBakery.SCALE_ROTATION_22_5);
                }
                else {
                    llllllllllllllIIIIlIlIlIIIllIIll.scale(FaceBakery.SCALE_ROTATION_GENERAL);
                }
                Vector3f.add(llllllllllllllIIIIlIlIlIIIllIIll, new Vector3f(1.0f, 1.0f, 1.0f), llllllllllllllIIIIlIlIlIIIllIIll);
            }
            else {
                llllllllllllllIIIIlIlIlIIIllIIll.set(1.0f, 1.0f, 1.0f);
            }
            this.rotateScale(llllllllllllllIIIIlIlIlIIIllIIIl, new Vector3f((ReadableVector3f)llllllllllllllIIIIlIlIlIIIllIlIl.origin), llllllllllllllIIIIlIlIlIIIllIlII, llllllllllllllIIIIlIlIlIIIllIIll);
        }
    }
    
    private static void addUvRotation(final ModelRotation llllllllllllllIIIIlIlIIllIIIIllI, final EnumFacing llllllllllllllIIIIlIlIIllIIIlIII, final Rotation llllllllllllllIIIIlIlIIllIIIIlll) {
        FaceBakery.UV_ROTATIONS[getIndex(llllllllllllllIIIIlIlIIllIIIIllI, llllllllllllllIIIIlIlIIllIIIlIII)] = llllllllllllllIIIIlIlIIllIIIIlll;
    }
    
    private float[] getPositionsDiv16(final Vector3f llllllllllllllIIIIlIlIlIlIIIlIII, final Vector3f llllllllllllllIIIIlIlIlIlIIIIlll) {
        final float[] llllllllllllllIIIIlIlIlIlIIIlIIl = new float[EnumFacing.values().length];
        llllllllllllllIIIIlIlIlIlIIIlIIl[EnumFaceDirection.Constants.WEST_INDEX] = llllllllllllllIIIIlIlIlIlIIIlIII.x / 16.0f;
        llllllllllllllIIIIlIlIlIlIIIlIIl[EnumFaceDirection.Constants.DOWN_INDEX] = llllllllllllllIIIIlIlIlIlIIIlIII.y / 16.0f;
        llllllllllllllIIIIlIlIlIlIIIlIIl[EnumFaceDirection.Constants.NORTH_INDEX] = llllllllllllllIIIIlIlIlIlIIIlIII.z / 16.0f;
        llllllllllllllIIIIlIlIlIlIIIlIIl[EnumFaceDirection.Constants.EAST_INDEX] = llllllllllllllIIIIlIlIlIlIIIIlll.x / 16.0f;
        llllllllllllllIIIIlIlIlIlIIIlIIl[EnumFaceDirection.Constants.UP_INDEX] = llllllllllllllIIIIlIlIlIlIIIIlll.y / 16.0f;
        llllllllllllllIIIIlIlIlIlIIIlIIl[EnumFaceDirection.Constants.SOUTH_INDEX] = llllllllllllllIIIIlIlIlIlIIIIlll.z / 16.0f;
        return llllllllllllllIIIIlIlIlIlIIIlIIl;
    }
    
    private int[] makeQuadVertexData(final BlockFaceUV llllllllllllllIIIIlIlIlIllIIlIIl, final TextureAtlasSprite llllllllllllllIIIIlIlIlIlIllIlll, final EnumFacing llllllllllllllIIIIlIlIlIlIllIlIl, final float[] llllllllllllllIIIIlIlIlIllIIIllI, final ITransformation llllllllllllllIIIIlIlIlIlIllIIIl, @Nullable final BlockPartRotation llllllllllllllIIIIlIlIlIlIlIllll, final boolean llllllllllllllIIIIlIlIlIlIlIllIl) {
        int llllllllllllllIIIIlIlIlIllIIIIlI = 28;
        if (Config.isShaders()) {
            llllllllllllllIIIIlIlIlIllIIIIlI = 56;
        }
        final int[] llllllllllllllIIIIlIlIlIllIIIIII = new int[llllllllllllllIIIIlIlIlIllIIIIlI];
        for (int llllllllllllllIIIIlIlIlIlIlllllI = 0; llllllllllllllIIIIlIlIlIlIlllllI < 4; ++llllllllllllllIIIIlIlIlIlIlllllI) {
            this.fillVertexData(llllllllllllllIIIIlIlIlIllIIIIII, llllllllllllllIIIIlIlIlIlIlllllI, llllllllllllllIIIIlIlIlIlIllIlIl, llllllllllllllIIIIlIlIlIllIIlIIl, llllllllllllllIIIIlIlIlIllIIIllI, llllllllllllllIIIIlIlIlIlIllIlll, llllllllllllllIIIIlIlIlIlIllIIIl, llllllllllllllIIIIlIlIlIlIlIllll, llllllllllllllIIIIlIlIlIlIlIllIl);
        }
        return llllllllllllllIIIIlIlIlIllIIIIII;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = FaceBakery.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final Exception llllllllllllllIIIIlIlIIlIllllIlI = (Object)new int[EnumFacing.Axis.values().length];
        try {
            llllllllllllllIIIIlIlIIlIllllIlI[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIIlIlIIlIllllIlI[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIIlIlIIlIllllIlI[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return FaceBakery.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)llllllllllllllIIIIlIlIIlIllllIlI;
    }
    
    private void applyFacing(final int[] llllllllllllllIIIIlIlIIllIIlllIl, final EnumFacing llllllllllllllIIIIlIlIIllIllIIlI) {
        final int[] llllllllllllllIIIIlIlIIllIllIIIl = new int[llllllllllllllIIIIlIlIIllIIlllIl.length];
        System.arraycopy(llllllllllllllIIIIlIlIIllIIlllIl, 0, llllllllllllllIIIIlIlIIllIllIIIl, 0, llllllllllllllIIIIlIlIIllIIlllIl.length);
        final float[] llllllllllllllIIIIlIlIIllIllIIII = new float[EnumFacing.values().length];
        llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.WEST_INDEX] = 999.0f;
        llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.DOWN_INDEX] = 999.0f;
        llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.NORTH_INDEX] = 999.0f;
        llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.EAST_INDEX] = -999.0f;
        llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.UP_INDEX] = -999.0f;
        llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.SOUTH_INDEX] = -999.0f;
        final int llllllllllllllIIIIlIlIIllIlIllll = llllllllllllllIIIIlIlIIllIIlllIl.length / 4;
        for (int llllllllllllllIIIIlIlIIllIlIlllI = 0; llllllllllllllIIIIlIlIIllIlIlllI < 4; ++llllllllllllllIIIIlIlIIllIlIlllI) {
            final int llllllllllllllIIIIlIlIIllIlIllIl = llllllllllllllIIIIlIlIIllIlIllll * llllllllllllllIIIIlIlIIllIlIlllI;
            final float llllllllllllllIIIIlIlIIllIlIllII = Float.intBitsToFloat(llllllllllllllIIIIlIlIIllIllIIIl[llllllllllllllIIIIlIlIIllIlIllIl]);
            final float llllllllllllllIIIIlIlIIllIlIlIll = Float.intBitsToFloat(llllllllllllllIIIIlIlIIllIllIIIl[llllllllllllllIIIIlIlIIllIlIllIl + 1]);
            final float llllllllllllllIIIIlIlIIllIlIlIlI = Float.intBitsToFloat(llllllllllllllIIIIlIlIIllIllIIIl[llllllllllllllIIIIlIlIIllIlIllIl + 2]);
            if (llllllllllllllIIIIlIlIIllIlIllII < llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.WEST_INDEX]) {
                llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.WEST_INDEX] = llllllllllllllIIIIlIlIIllIlIllII;
            }
            if (llllllllllllllIIIIlIlIIllIlIlIll < llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.DOWN_INDEX]) {
                llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.DOWN_INDEX] = llllllllllllllIIIIlIlIIllIlIlIll;
            }
            if (llllllllllllllIIIIlIlIIllIlIlIlI < llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.NORTH_INDEX]) {
                llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.NORTH_INDEX] = llllllllllllllIIIIlIlIIllIlIlIlI;
            }
            if (llllllllllllllIIIIlIlIIllIlIllII > llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.EAST_INDEX]) {
                llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.EAST_INDEX] = llllllllllllllIIIIlIlIIllIlIllII;
            }
            if (llllllllllllllIIIIlIlIIllIlIlIll > llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.UP_INDEX]) {
                llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.UP_INDEX] = llllllllllllllIIIIlIlIIllIlIlIll;
            }
            if (llllllllllllllIIIIlIlIIllIlIlIlI > llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.SOUTH_INDEX]) {
                llllllllllllllIIIIlIlIIllIllIIII[EnumFaceDirection.Constants.SOUTH_INDEX] = llllllllllllllIIIIlIlIIllIlIlIlI;
            }
        }
        final EnumFaceDirection llllllllllllllIIIIlIlIIllIlIlIIl = EnumFaceDirection.getFacing(llllllllllllllIIIIlIlIIllIllIIlI);
        for (int llllllllllllllIIIIlIlIIllIlIlIII = 0; llllllllllllllIIIIlIlIIllIlIlIII < 4; ++llllllllllllllIIIIlIlIIllIlIlIII) {
            final int llllllllllllllIIIIlIlIIllIlIIlll = llllllllllllllIIIIlIlIIllIlIllll * llllllllllllllIIIIlIlIIllIlIlIII;
            final EnumFaceDirection.VertexInformation llllllllllllllIIIIlIlIIllIlIIllI = llllllllllllllIIIIlIlIIllIlIlIIl.getVertexInformation(llllllllllllllIIIIlIlIIllIlIlIII);
            final float llllllllllllllIIIIlIlIIllIlIIlIl = llllllllllllllIIIIlIlIIllIllIIII[llllllllllllllIIIIlIlIIllIlIIllI.xIndex];
            final float llllllllllllllIIIIlIlIIllIlIIlII = llllllllllllllIIIIlIlIIllIllIIII[llllllllllllllIIIIlIlIIllIlIIllI.yIndex];
            final float llllllllllllllIIIIlIlIIllIlIIIll = llllllllllllllIIIIlIlIIllIllIIII[llllllllllllllIIIIlIlIIllIlIIllI.zIndex];
            llllllllllllllIIIIlIlIIllIIlllIl[llllllllllllllIIIIlIlIIllIlIIlll] = Float.floatToRawIntBits(llllllllllllllIIIIlIlIIllIlIIlIl);
            llllllllllllllIIIIlIlIIllIIlllIl[llllllllllllllIIIIlIlIIllIlIIlll + 1] = Float.floatToRawIntBits(llllllllllllllIIIIlIlIIllIlIIlII);
            llllllllllllllIIIIlIlIIllIIlllIl[llllllllllllllIIIIlIlIIllIlIIlll + 2] = Float.floatToRawIntBits(llllllllllllllIIIIlIlIIllIlIIIll);
            for (int llllllllllllllIIIIlIlIIllIlIIIlI = 0; llllllllllllllIIIIlIlIIllIlIIIlI < 4; ++llllllllllllllIIIIlIlIIllIlIIIlI) {
                final int llllllllllllllIIIIlIlIIllIlIIIIl = llllllllllllllIIIIlIlIIllIlIllll * llllllllllllllIIIIlIlIIllIlIIIlI;
                final float llllllllllllllIIIIlIlIIllIlIIIII = Float.intBitsToFloat(llllllllllllllIIIIlIlIIllIllIIIl[llllllllllllllIIIIlIlIIllIlIIIIl]);
                final float llllllllllllllIIIIlIlIIllIIlllll = Float.intBitsToFloat(llllllllllllllIIIIlIlIIllIllIIIl[llllllllllllllIIIIlIlIIllIlIIIIl + 1]);
                final float llllllllllllllIIIIlIlIIllIIllllI = Float.intBitsToFloat(llllllllllllllIIIIlIlIIllIllIIIl[llllllllllllllIIIIlIlIIllIlIIIIl + 2]);
                if (MathHelper.epsilonEquals(llllllllllllllIIIIlIlIIllIlIIlIl, llllllllllllllIIIIlIlIIllIlIIIII) && MathHelper.epsilonEquals(llllllllllllllIIIIlIlIIllIlIIlII, llllllllllllllIIIIlIlIIllIIlllll) && MathHelper.epsilonEquals(llllllllllllllIIIIlIlIIllIlIIIll, llllllllllllllIIIIlIlIIllIIllllI)) {
                    llllllllllllllIIIIlIlIIllIIlllIl[llllllllllllllIIIIlIlIIllIlIIlll + 4] = llllllllllllllIIIIlIlIIllIllIIIl[llllllllllllllIIIIlIlIIllIlIIIIl + 4];
                    llllllllllllllIIIIlIlIIllIIlllIl[llllllllllllllIIIIlIlIIllIlIIlll + 4 + 1] = llllllllllllllIIIIlIlIIllIllIIIl[llllllllllllllIIIIlIlIIllIlIIIIl + 4 + 1];
                }
            }
        }
    }
    
    static {
        SCALE_ROTATION_22_5 = 1.0f / (float)Math.cos(0.39269909262657166) - 1.0f;
        SCALE_ROTATION_GENERAL = 1.0f / (float)Math.cos(0.7853981633974483) - 1.0f;
        UV_ROTATIONS = new Rotation[ModelRotation.values().length * EnumFacing.values().length];
        UV_ROTATION_0 = new Rotation() {
            @Override
            BlockFaceUV makeRotatedUV(final float lllllllllllllllIlIlllIIllIlIIlIl, final float lllllllllllllllIlIlllIIllIlIIlII, final float lllllllllllllllIlIlllIIllIIlllll, final float lllllllllllllllIlIlllIIllIIllllI) {
                return new BlockFaceUV(new float[] { lllllllllllllllIlIlllIIllIlIIlIl, lllllllllllllllIlIlllIIllIlIIlII, lllllllllllllllIlIlllIIllIIlllll, lllllllllllllllIlIlllIIllIIllllI }, 0);
            }
        };
        UV_ROTATION_270 = new Rotation() {
            @Override
            BlockFaceUV makeRotatedUV(final float llIllIlllIlllI, final float llIllIlllIlIIl, final float llIllIlllIllII, final float llIllIlllIlIll) {
                return new BlockFaceUV(new float[] { llIllIlllIlIll, 16.0f - llIllIlllIlllI, llIllIlllIlIIl, 16.0f - llIllIlllIllII }, 270);
            }
        };
        UV_ROTATION_INVERSE = new Rotation() {
            @Override
            BlockFaceUV makeRotatedUV(final float llllllllllllllllIlIIIIIlIIlIlllI, final float llllllllllllllllIlIIIIIlIIllIIIl, final float llllllllllllllllIlIIIIIlIIllIIII, final float llllllllllllllllIlIIIIIlIIlIlIll) {
                return new BlockFaceUV(new float[] { 16.0f - llllllllllllllllIlIIIIIlIIlIlllI, 16.0f - llllllllllllllllIlIIIIIlIIllIIIl, 16.0f - llllllllllllllllIlIIIIIlIIllIIII, 16.0f - llllllllllllllllIlIIIIIlIIlIlIll }, 0);
            }
        };
        UV_ROTATION_90 = new Rotation() {
            @Override
            BlockFaceUV makeRotatedUV(final float lllllllllllllIIlIllIIIlIllIlIlll, final float lllllllllllllIIlIllIIIlIllIlIllI, final float lllllllllllllIIlIllIIIlIllIlIlIl, final float lllllllllllllIIlIllIIIlIllIlIIII) {
                return new BlockFaceUV(new float[] { 16.0f - lllllllllllllIIlIllIIIlIllIlIllI, lllllllllllllIIlIllIIIlIllIlIlIl, 16.0f - lllllllllllllIIlIllIIIlIllIlIIII, lllllllllllllIIlIllIIIlIllIlIlll }, 90);
            }
        };
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.EAST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y0, EnumFacing.WEST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.EAST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.WEST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.EAST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.WEST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.EAST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.WEST, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.DOWN, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.NORTH, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.UP, FaceBakery.UV_ROTATION_0);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.UP, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.DOWN, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.WEST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.WEST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.WEST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.NORTH, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.WEST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.UP, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.DOWN, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.EAST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.EAST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.NORTH, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.EAST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.EAST, FaceBakery.UV_ROTATION_270);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X0_Y180, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.EAST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y0, EnumFacing.WEST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.EAST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.WEST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.EAST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.UP, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y180, EnumFacing.WEST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.EAST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.WEST, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.NORTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.DOWN, FaceBakery.UV_ROTATION_INVERSE);
        addUvRotation(ModelRotation.X0_Y90, EnumFacing.UP, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X0_Y270, EnumFacing.DOWN, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y0, EnumFacing.EAST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.EAST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.NORTH, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y90, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y180, EnumFacing.EAST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X90_Y270, EnumFacing.EAST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y0, EnumFacing.WEST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X180_Y90, EnumFacing.DOWN, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X180_Y270, EnumFacing.UP, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y90, EnumFacing.WEST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y180, EnumFacing.WEST, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.NORTH, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.SOUTH, FaceBakery.UV_ROTATION_90);
        addUvRotation(ModelRotation.X270_Y270, EnumFacing.WEST, FaceBakery.UV_ROTATION_90);
    }
    
    private static int getIndex(final ModelRotation llllllllllllllIIIIlIlIIlIlllllll, final EnumFacing llllllllllllllIIIIlIlIIlIllllllI) {
        return ModelRotation.values().length * llllllllllllllIIIIlIlIIlIllllllI.ordinal() + llllllllllllllIIIIlIlIIlIlllllll.ordinal();
    }
    
    public BakedQuad makeBakedQuad(final Vector3f llllllllllllllIIIIlIlIllIIlllIll, final Vector3f llllllllllllllIIIIlIlIllIlIIIlll, final BlockPartFace llllllllllllllIIIIlIlIllIlIIIllI, final TextureAtlasSprite llllllllllllllIIIIlIlIllIlIIIlIl, final EnumFacing llllllllllllllIIIIlIlIllIIllIlll, final ModelRotation llllllllllllllIIIIlIlIllIlIIIIll, @Nullable final BlockPartRotation llllllllllllllIIIIlIlIllIIllIlIl, final boolean llllllllllllllIIIIlIlIllIlIIIIIl, final boolean llllllllllllllIIIIlIlIllIIllIIll) {
        BlockFaceUV llllllllllllllIIIIlIlIllIIllllll = llllllllllllllIIIIlIlIllIlIIIllI.blockFaceUV;
        if (llllllllllllllIIIIlIlIllIlIIIIIl) {
            llllllllllllllIIIIlIlIllIIllllll = this.applyUVLock(llllllllllllllIIIIlIlIllIlIIIllI.blockFaceUV, llllllllllllllIIIIlIlIllIIllIlll, llllllllllllllIIIIlIlIllIlIIIIll);
        }
        final int[] llllllllllllllIIIIlIlIllIIlllllI = this.makeQuadVertexData(llllllllllllllIIIIlIlIllIIllllll, llllllllllllllIIIIlIlIllIlIIIlIl, llllllllllllllIIIIlIlIllIIllIlll, this.getPositionsDiv16(llllllllllllllIIIIlIlIllIIlllIll, llllllllllllllIIIIlIlIllIlIIIlll), llllllllllllllIIIIlIlIllIlIIIIll, llllllllllllllIIIIlIlIllIIllIlIl, llllllllllllllIIIIlIlIllIIllIIll);
        final EnumFacing llllllllllllllIIIIlIlIllIIllllIl = getFacingFromVertexData(llllllllllllllIIIIlIlIllIIlllllI);
        if (llllllllllllllIIIIlIlIllIIllIlIl == null) {
            this.applyFacing(llllllllllllllIIIIlIlIllIIlllllI, llllllllllllllIIIIlIlIllIIllllIl);
        }
        return new BakedQuad(llllllllllllllIIIIlIlIllIIlllllI, llllllllllllllIIIIlIlIllIlIIIllI.tintIndex, llllllllllllllIIIIlIlIllIIllllIl, llllllllllllllIIIIlIlIllIlIIIlIl);
    }
    
    public BakedQuad makeBakedQuad(final Vector3f llllllllllllllIIIIlIlIllIIlIIIII, final Vector3f llllllllllllllIIIIlIlIllIIIlIIIl, final BlockPartFace llllllllllllllIIIIlIlIllIIIlIIII, final TextureAtlasSprite llllllllllllllIIIIlIlIllIIIIllll, final EnumFacing llllllllllllllIIIIlIlIllIIIlllII, final ITransformation llllllllllllllIIIIlIlIllIIIllIll, final BlockPartRotation llllllllllllllIIIIlIlIllIIIIllII, final boolean llllllllllllllIIIIlIlIllIIIllIIl, final boolean llllllllllllllIIIIlIlIllIIIllIII) {
        BlockFaceUV llllllllllllllIIIIlIlIllIIIlIlll = llllllllllllllIIIIlIlIllIIIlIIII.blockFaceUV;
        if (llllllllllllllIIIIlIlIllIIIllIIl) {
            if (Reflector.ForgeHooksClient_applyUVLock.exists()) {
                llllllllllllllIIIIlIlIllIIIlIlll = (BlockFaceUV)Reflector.call(Reflector.ForgeHooksClient_applyUVLock, llllllllllllllIIIIlIlIllIIIlIIII.blockFaceUV, llllllllllllllIIIIlIlIllIIIlllII, llllllllllllllIIIIlIlIllIIIllIll);
            }
            else {
                llllllllllllllIIIIlIlIllIIIlIlll = this.applyUVLock(llllllllllllllIIIIlIlIllIIIlIIII.blockFaceUV, llllllllllllllIIIIlIlIllIIIlllII, (ModelRotation)llllllllllllllIIIIlIlIllIIIllIll);
            }
        }
        final boolean llllllllllllllIIIIlIlIllIIIlIllI = llllllllllllllIIIIlIlIllIIIllIII && !Reflector.ForgeHooksClient_fillNormal.exists();
        final int[] llllllllllllllIIIIlIlIllIIIlIlIl = this.makeQuadVertexData(llllllllllllllIIIIlIlIllIIIlIlll, llllllllllllllIIIIlIlIllIIIIllll, llllllllllllllIIIIlIlIllIIIlllII, this.getPositionsDiv16(llllllllllllllIIIIlIlIllIIlIIIII, llllllllllllllIIIIlIlIllIIIlIIIl), llllllllllllllIIIIlIlIllIIIllIll, llllllllllllllIIIIlIlIllIIIIllII, llllllllllllllIIIIlIlIllIIIlIllI);
        final EnumFacing llllllllllllllIIIIlIlIllIIIlIlII = getFacingFromVertexData(llllllllllllllIIIIlIlIllIIIlIlIl);
        if (llllllllllllllIIIIlIlIllIIIIllII == null) {
            this.applyFacing(llllllllllllllIIIIlIlIllIIIlIlIl, llllllllllllllIIIIlIlIllIIIlIlII);
        }
        if (Reflector.ForgeHooksClient_fillNormal.exists()) {
            Reflector.call(Reflector.ForgeHooksClient_fillNormal, llllllllllllllIIIIlIlIllIIIlIlIl, llllllllllllllIIIIlIlIllIIIlIlII);
            return new BakedQuad(llllllllllllllIIIIlIlIllIIIlIlIl, llllllllllllllIIIIlIlIllIIIlIIII.tintIndex, llllllllllllllIIIIlIlIllIIIlIlII, llllllllllllllIIIIlIlIllIIIIllll, llllllllllllllIIIIlIlIllIIIllIII, DefaultVertexFormats.ITEM);
        }
        return new BakedQuad(llllllllllllllIIIIlIlIllIIIlIlIl, llllllllllllllIIIIlIlIllIIIlIIII.tintIndex, llllllllllllllIIIIlIlIllIIIlIlII, llllllllllllllIIIIlIlIllIIIIllll);
    }
    
    public int rotateVertex(final Vector3f llllllllllllllIIIIlIlIlIIIlIIlll, final EnumFacing llllllllllllllIIIIlIlIlIIIlIIIIl, final int llllllllllllllIIIIlIlIlIIIlIIlIl, final ModelRotation llllllllllllllIIIIlIlIlIIIIlllll) {
        return this.rotateVertex(llllllllllllllIIIIlIlIlIIIlIIlll, llllllllllllllIIIIlIlIlIIIlIIIIl, llllllllllllllIIIIlIlIlIIIlIIlIl, llllllllllllllIIIIlIlIlIIIIlllll);
    }
    
    private Matrix4f getMatrixIdentity() {
        final Matrix4f llllllllllllllIIIIlIlIIlllllllIl = new Matrix4f();
        llllllllllllllIIIIlIlIIlllllllIl.setIdentity();
        return llllllllllllllIIIIlIlIIlllllllIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = FaceBakery.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final boolean llllllllllllllIIIIlIlIIlIlllllII = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllllIIIIlIlIIlIlllllII[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIIIlIlIIlIlllllII[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIIIlIlIIlIlllllII[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIIIlIlIIlIlllllII[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIIIIlIlIIlIlllllII[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIIIIlIlIIlIlllllII[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return FaceBakery.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllllIIIIlIlIIlIlllllII;
    }
    
    abstract static class Rotation
    {
        abstract BlockFaceUV makeRotatedUV(final float p0, final float p1, final float p2, final float p3);
        
        public BlockFaceUV rotateUV(final BlockFaceUV llllllllllllllllIllIIlllIIlIIIII) {
            final float llllllllllllllllIllIIlllIIIlllll = llllllllllllllllIllIIlllIIlIIIII.getVertexU(llllllllllllllllIllIIlllIIlIIIII.getVertexRotatedRev(0));
            final float llllllllllllllllIllIIlllIIIllllI = llllllllllllllllIllIIlllIIlIIIII.getVertexV(llllllllllllllllIllIIlllIIlIIIII.getVertexRotatedRev(0));
            final float llllllllllllllllIllIIlllIIIlllIl = llllllllllllllllIllIIlllIIlIIIII.getVertexU(llllllllllllllllIllIIlllIIlIIIII.getVertexRotatedRev(2));
            final float llllllllllllllllIllIIlllIIIlllII = llllllllllllllllIllIIlllIIlIIIII.getVertexV(llllllllllllllllIllIIlllIIlIIIII.getVertexRotatedRev(2));
            return this.makeRotatedUV(llllllllllllllllIllIIlllIIIlllll, llllllllllllllllIllIIlllIIIllllI, llllllllllllllllIllIIlllIIIlllIl, llllllllllllllllIllIIlllIIIlllII);
        }
        
        private Rotation() {
        }
    }
}
