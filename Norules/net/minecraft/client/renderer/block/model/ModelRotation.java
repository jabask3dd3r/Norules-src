package net.minecraft.client.renderer.block.model;

import com.google.common.collect.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import org.lwjgl.util.vector.*;
import java.util.*;
import net.minecraftforge.common.model.*;
import optifine.*;

public enum ModelRotation implements IModelState, ITransformation
{
    private final /* synthetic */ Matrix4f matrix4d;
    
    X0_Y90("X0_Y90", 1, 0, 90), 
    X180_Y180("X180_Y180", 10, 180, 180), 
    X180_Y90("X180_Y90", 9, 180, 90), 
    X180_Y0("X180_Y0", 8, 180, 0), 
    X0_Y180("X0_Y180", 2, 0, 180), 
    X180_Y270("X180_Y270", 11, 180, 270);
    
    private static final /* synthetic */ Map<Integer, ModelRotation> MAP_ROTATIONS;
    
    X90_Y180("X90_Y180", 6, 90, 180), 
    X90_Y0("X90_Y0", 4, 90, 0), 
    X270_Y270("X270_Y270", 15, 270, 270), 
    X270_Y0("X270_Y0", 12, 270, 0), 
    X90_Y270("X90_Y270", 7, 90, 270), 
    X270_Y90("X270_Y90", 13, 270, 90), 
    X0_Y270("X0_Y270", 3, 0, 270);
    
    private final /* synthetic */ int quartersX;
    private final /* synthetic */ int quartersY;
    
    X90_Y90("X90_Y90", 5, 90, 90), 
    X0_Y0("X0_Y0", 0, 0, 0);
    
    private final /* synthetic */ int combinedXY;
    
    X270_Y180("X270_Y180", 14, 270, 180);
    
    static {
        MAP_ROTATIONS = Maps.newHashMap();
        final Exception llllllllllllllIlIIlllIIIlllIIIII;
        final char llllllllllllllIlIIlllIIIlllIIIIl = (char)((ModelRotation[])(Object)(llllllllllllllIlIIlllIIIlllIIIII = (Exception)(Object)values())).length;
        for (byte llllllllllllllIlIIlllIIIlllIIIlI = 0; llllllllllllllIlIIlllIIIlllIIIlI < llllllllllllllIlIIlllIIIlllIIIIl; ++llllllllllllllIlIIlllIIIlllIIIlI) {
            final ModelRotation llllllllllllllIlIIlllIIIlllIIlII = llllllllllllllIlIIlllIIIlllIIIII[llllllllllllllIlIIlllIIIlllIIIlI];
            ModelRotation.MAP_ROTATIONS.put(llllllllllllllIlIIlllIIIlllIIlII.combinedXY, llllllllllllllIlIIlllIIIlllIIlII);
        }
    }
    
    public EnumFacing rotateFace(final EnumFacing llllllllllllllIlIIlllIIIlIlllIIl) {
        EnumFacing llllllllllllllIlIIlllIIIlIllllIl = llllllllllllllIlIIlllIIIlIlllIIl;
        for (int llllllllllllllIlIIlllIIIlIllllII = 0; llllllllllllllIlIIlllIIIlIllllII < this.quartersX; ++llllllllllllllIlIIlllIIIlIllllII) {
            llllllllllllllIlIIlllIIIlIllllIl = llllllllllllllIlIIlllIIIlIllllIl.rotateAround(EnumFacing.Axis.X);
        }
        if (llllllllllllllIlIIlllIIIlIllllIl.getAxis() != EnumFacing.Axis.Y) {
            for (int llllllllllllllIlIIlllIIIlIlllIll = 0; llllllllllllllIlIIlllIIIlIlllIll < this.quartersY; ++llllllllllllllIlIIlllIIIlIlllIll) {
                llllllllllllllIlIIlllIIIlIllllIl = llllllllllllllIlIIlllIIIlIllllIl.rotateAround(EnumFacing.Axis.Y);
            }
        }
        return llllllllllllllIlIIlllIIIlIllllIl;
    }
    
    public static ModelRotation getModelRotation(final int llllllllllllllIlIIlllIIIlIlIIIlI, final int llllllllllllllIlIIlllIIIlIIlllll) {
        return ModelRotation.MAP_ROTATIONS.get(combineXY(MathHelper.normalizeAngle(llllllllllllllIlIIlllIIIlIlIIIlI, 360), MathHelper.normalizeAngle(llllllllllllllIlIIlllIIIlIIlllll, 360)));
    }
    
    private ModelRotation(final String llllllllllllllIlIIlllIIIllIIllII, final int llllllllllllllIlIIlllIIIllIIlIll, final int llllllllllllllIlIIlllIIIllIlIIIl, final int llllllllllllllIlIIlllIIIllIIlIIl) {
        this.combinedXY = combineXY(llllllllllllllIlIIlllIIIllIlIIIl, llllllllllllllIlIIlllIIIllIIlIIl);
        this.matrix4d = new Matrix4f();
        final Matrix4f llllllllllllllIlIIlllIIIllIIllll = new Matrix4f();
        llllllllllllllIlIIlllIIIllIIllll.setIdentity();
        Matrix4f.rotate(-llllllllllllllIlIIlllIIIllIlIIIl * 0.017453292f, new Vector3f(1.0f, 0.0f, 0.0f), llllllllllllllIlIIlllIIIllIIllll, llllllllllllllIlIIlllIIIllIIllll);
        this.quartersX = MathHelper.abs(llllllllllllllIlIIlllIIIllIlIIIl / 90);
        final Matrix4f llllllllllllllIlIIlllIIIllIIlllI = new Matrix4f();
        llllllllllllllIlIIlllIIIllIIlllI.setIdentity();
        Matrix4f.rotate(-llllllllllllllIlIIlllIIIllIIlIIl * 0.017453292f, new Vector3f(0.0f, 1.0f, 0.0f), llllllllllllllIlIIlllIIIllIIlllI, llllllllllllllIlIIlllIIIllIIlllI);
        this.quartersY = MathHelper.abs(llllllllllllllIlIIlllIIIllIIlIIl / 90);
        Matrix4f.mul(llllllllllllllIlIIlllIIIllIIlllI, llllllllllllllIlIIlllIIIllIIllll, this.matrix4d);
    }
    
    @Override
    public EnumFacing rotate(final EnumFacing llllllllllllllIlIIlllIIIlIIlIIlI) {
        return this.rotateFace(llllllllllllllIlIIlllIIIlIIlIIlI);
    }
    
    private static int combineXY(final int llllllllllllllIlIIlllIIIllIllIll, final int llllllllllllllIlIIlllIIIllIllIlI) {
        return llllllllllllllIlIIlllIIIllIllIll * 360 + llllllllllllllIlIIlllIIIllIllIlI;
    }
    
    @Override
    public Optional<TRSRTransformation> apply(final Optional<? extends IModelPart> llllllllllllllIlIIlllIIIlIIllIIl) {
        return (Optional<TRSRTransformation>)Reflector.call(Reflector.ForgeHooksClient_applyTransform, this.getMatrix(), llllllllllllllIlIIlllIIIlIIllIIl);
    }
    
    public Matrix4f getMatrix4d() {
        return this.matrix4d;
    }
    
    @Override
    public int rotate(final EnumFacing llllllllllllllIlIIlllIIIlIIIlIII, final int llllllllllllllIlIIlllIIIlIIIlIlI) {
        return this.rotateVertex(llllllllllllllIlIIlllIIIlIIIlIII, llllllllllllllIlIIlllIIIlIIIlIlI);
    }
    
    public int rotateVertex(final EnumFacing llllllllllllllIlIIlllIIIlIlIlIIl, final int llllllllllllllIlIIlllIIIlIlIlllI) {
        int llllllllllllllIlIIlllIIIlIlIllIl = llllllllllllllIlIIlllIIIlIlIlllI;
        if (llllllllllllllIlIIlllIIIlIlIlIIl.getAxis() == EnumFacing.Axis.X) {
            llllllllllllllIlIIlllIIIlIlIllIl = (llllllllllllllIlIIlllIIIlIlIlllI + this.quartersX) % 4;
        }
        EnumFacing llllllllllllllIlIIlllIIIlIlIllII = llllllllllllllIlIIlllIIIlIlIlIIl;
        for (int llllllllllllllIlIIlllIIIlIlIlIll = 0; llllllllllllllIlIIlllIIIlIlIlIll < this.quartersX; ++llllllllllllllIlIIlllIIIlIlIlIll) {
            llllllllllllllIlIIlllIIIlIlIllII = llllllllllllllIlIIlllIIIlIlIllII.rotateAround(EnumFacing.Axis.X);
        }
        if (llllllllllllllIlIIlllIIIlIlIllII.getAxis() == EnumFacing.Axis.Y) {
            llllllllllllllIlIIlllIIIlIlIllIl = (llllllllllllllIlIIlllIIIlIlIllIl + this.quartersY) % 4;
        }
        return llllllllllllllIlIIlllIIIlIlIllIl;
    }
    
    @Override
    public javax.vecmath.Matrix4f getMatrix() {
        return (javax.vecmath.Matrix4f)(Reflector.ForgeHooksClient_getMatrix.exists() ? Reflector.call(Reflector.ForgeHooksClient_getMatrix, this) : new javax.vecmath.Matrix4f());
    }
}
