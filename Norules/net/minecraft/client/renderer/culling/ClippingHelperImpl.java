package net.minecraft.client.renderer.culling;

import java.nio.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;

public class ClippingHelperImpl extends ClippingHelper
{
    private final /* synthetic */ FloatBuffer floatBuffer16;
    private final /* synthetic */ FloatBuffer modelviewMatrixBuffer;
    private final /* synthetic */ FloatBuffer projectionMatrixBuffer;
    private static final /* synthetic */ ClippingHelperImpl instance;
    
    private void normalize(final float[] llllllllllllllllIIIIIIIlIIlIllII) {
        final float llllllllllllllllIIIIIIIlIIlIllIl = MathHelper.sqrt(llllllllllllllllIIIIIIIlIIlIllII[0] * llllllllllllllllIIIIIIIlIIlIllII[0] + llllllllllllllllIIIIIIIlIIlIllII[1] * llllllllllllllllIIIIIIIlIIlIllII[1] + llllllllllllllllIIIIIIIlIIlIllII[2] * llllllllllllllllIIIIIIIlIIlIllII[2]);
        final int n = 0;
        llllllllllllllllIIIIIIIlIIlIllII[n] /= llllllllllllllllIIIIIIIlIIlIllIl;
        final int n2 = 1;
        llllllllllllllllIIIIIIIlIIlIllII[n2] /= llllllllllllllllIIIIIIIlIIlIllIl;
        final int n3 = 2;
        llllllllllllllllIIIIIIIlIIlIllII[n3] /= llllllllllllllllIIIIIIIlIIlIllIl;
        final int n4 = 3;
        llllllllllllllllIIIIIIIlIIlIllII[n4] /= llllllllllllllllIIIIIIIlIIlIllIl;
    }
    
    public ClippingHelperImpl() {
        this.projectionMatrixBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.modelviewMatrixBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.floatBuffer16 = GLAllocation.createDirectFloatBuffer(16);
    }
    
    public static ClippingHelper getInstance() {
        ClippingHelperImpl.instance.init();
        return ClippingHelperImpl.instance;
    }
    
    public void init() {
        this.projectionMatrixBuffer.clear();
        this.modelviewMatrixBuffer.clear();
        this.floatBuffer16.clear();
        GlStateManager.getFloat(2983, this.projectionMatrixBuffer);
        GlStateManager.getFloat(2982, this.modelviewMatrixBuffer);
        final float[] llllllllllllllllIIIIIIIlIIIlIllI = this.projectionMatrix;
        final float[] llllllllllllllllIIIIIIIlIIIlIlIl = this.modelviewMatrix;
        this.projectionMatrixBuffer.flip().limit(16);
        this.projectionMatrixBuffer.get(llllllllllllllllIIIIIIIlIIIlIllI);
        this.modelviewMatrixBuffer.flip().limit(16);
        this.modelviewMatrixBuffer.get(llllllllllllllllIIIIIIIlIIIlIlIl);
        this.clippingMatrix[0] = llllllllllllllllIIIIIIIlIIIlIlIl[0] * llllllllllllllllIIIIIIIlIIIlIllI[0] + llllllllllllllllIIIIIIIlIIIlIlIl[1] * llllllllllllllllIIIIIIIlIIIlIllI[4] + llllllllllllllllIIIIIIIlIIIlIlIl[2] * llllllllllllllllIIIIIIIlIIIlIllI[8] + llllllllllllllllIIIIIIIlIIIlIlIl[3] * llllllllllllllllIIIIIIIlIIIlIllI[12];
        this.clippingMatrix[1] = llllllllllllllllIIIIIIIlIIIlIlIl[0] * llllllllllllllllIIIIIIIlIIIlIllI[1] + llllllllllllllllIIIIIIIlIIIlIlIl[1] * llllllllllllllllIIIIIIIlIIIlIllI[5] + llllllllllllllllIIIIIIIlIIIlIlIl[2] * llllllllllllllllIIIIIIIlIIIlIllI[9] + llllllllllllllllIIIIIIIlIIIlIlIl[3] * llllllllllllllllIIIIIIIlIIIlIllI[13];
        this.clippingMatrix[2] = llllllllllllllllIIIIIIIlIIIlIlIl[0] * llllllllllllllllIIIIIIIlIIIlIllI[2] + llllllllllllllllIIIIIIIlIIIlIlIl[1] * llllllllllllllllIIIIIIIlIIIlIllI[6] + llllllllllllllllIIIIIIIlIIIlIlIl[2] * llllllllllllllllIIIIIIIlIIIlIllI[10] + llllllllllllllllIIIIIIIlIIIlIlIl[3] * llllllllllllllllIIIIIIIlIIIlIllI[14];
        this.clippingMatrix[3] = llllllllllllllllIIIIIIIlIIIlIlIl[0] * llllllllllllllllIIIIIIIlIIIlIllI[3] + llllllllllllllllIIIIIIIlIIIlIlIl[1] * llllllllllllllllIIIIIIIlIIIlIllI[7] + llllllllllllllllIIIIIIIlIIIlIlIl[2] * llllllllllllllllIIIIIIIlIIIlIllI[11] + llllllllllllllllIIIIIIIlIIIlIlIl[3] * llllllllllllllllIIIIIIIlIIIlIllI[15];
        this.clippingMatrix[4] = llllllllllllllllIIIIIIIlIIIlIlIl[4] * llllllllllllllllIIIIIIIlIIIlIllI[0] + llllllllllllllllIIIIIIIlIIIlIlIl[5] * llllllllllllllllIIIIIIIlIIIlIllI[4] + llllllllllllllllIIIIIIIlIIIlIlIl[6] * llllllllllllllllIIIIIIIlIIIlIllI[8] + llllllllllllllllIIIIIIIlIIIlIlIl[7] * llllllllllllllllIIIIIIIlIIIlIllI[12];
        this.clippingMatrix[5] = llllllllllllllllIIIIIIIlIIIlIlIl[4] * llllllllllllllllIIIIIIIlIIIlIllI[1] + llllllllllllllllIIIIIIIlIIIlIlIl[5] * llllllllllllllllIIIIIIIlIIIlIllI[5] + llllllllllllllllIIIIIIIlIIIlIlIl[6] * llllllllllllllllIIIIIIIlIIIlIllI[9] + llllllllllllllllIIIIIIIlIIIlIlIl[7] * llllllllllllllllIIIIIIIlIIIlIllI[13];
        this.clippingMatrix[6] = llllllllllllllllIIIIIIIlIIIlIlIl[4] * llllllllllllllllIIIIIIIlIIIlIllI[2] + llllllllllllllllIIIIIIIlIIIlIlIl[5] * llllllllllllllllIIIIIIIlIIIlIllI[6] + llllllllllllllllIIIIIIIlIIIlIlIl[6] * llllllllllllllllIIIIIIIlIIIlIllI[10] + llllllllllllllllIIIIIIIlIIIlIlIl[7] * llllllllllllllllIIIIIIIlIIIlIllI[14];
        this.clippingMatrix[7] = llllllllllllllllIIIIIIIlIIIlIlIl[4] * llllllllllllllllIIIIIIIlIIIlIllI[3] + llllllllllllllllIIIIIIIlIIIlIlIl[5] * llllllllllllllllIIIIIIIlIIIlIllI[7] + llllllllllllllllIIIIIIIlIIIlIlIl[6] * llllllllllllllllIIIIIIIlIIIlIllI[11] + llllllllllllllllIIIIIIIlIIIlIlIl[7] * llllllllllllllllIIIIIIIlIIIlIllI[15];
        this.clippingMatrix[8] = llllllllllllllllIIIIIIIlIIIlIlIl[8] * llllllllllllllllIIIIIIIlIIIlIllI[0] + llllllllllllllllIIIIIIIlIIIlIlIl[9] * llllllllllllllllIIIIIIIlIIIlIllI[4] + llllllllllllllllIIIIIIIlIIIlIlIl[10] * llllllllllllllllIIIIIIIlIIIlIllI[8] + llllllllllllllllIIIIIIIlIIIlIlIl[11] * llllllllllllllllIIIIIIIlIIIlIllI[12];
        this.clippingMatrix[9] = llllllllllllllllIIIIIIIlIIIlIlIl[8] * llllllllllllllllIIIIIIIlIIIlIllI[1] + llllllllllllllllIIIIIIIlIIIlIlIl[9] * llllllllllllllllIIIIIIIlIIIlIllI[5] + llllllllllllllllIIIIIIIlIIIlIlIl[10] * llllllllllllllllIIIIIIIlIIIlIllI[9] + llllllllllllllllIIIIIIIlIIIlIlIl[11] * llllllllllllllllIIIIIIIlIIIlIllI[13];
        this.clippingMatrix[10] = llllllllllllllllIIIIIIIlIIIlIlIl[8] * llllllllllllllllIIIIIIIlIIIlIllI[2] + llllllllllllllllIIIIIIIlIIIlIlIl[9] * llllllllllllllllIIIIIIIlIIIlIllI[6] + llllllllllllllllIIIIIIIlIIIlIlIl[10] * llllllllllllllllIIIIIIIlIIIlIllI[10] + llllllllllllllllIIIIIIIlIIIlIlIl[11] * llllllllllllllllIIIIIIIlIIIlIllI[14];
        this.clippingMatrix[11] = llllllllllllllllIIIIIIIlIIIlIlIl[8] * llllllllllllllllIIIIIIIlIIIlIllI[3] + llllllllllllllllIIIIIIIlIIIlIlIl[9] * llllllllllllllllIIIIIIIlIIIlIllI[7] + llllllllllllllllIIIIIIIlIIIlIlIl[10] * llllllllllllllllIIIIIIIlIIIlIllI[11] + llllllllllllllllIIIIIIIlIIIlIlIl[11] * llllllllllllllllIIIIIIIlIIIlIllI[15];
        this.clippingMatrix[12] = llllllllllllllllIIIIIIIlIIIlIlIl[12] * llllllllllllllllIIIIIIIlIIIlIllI[0] + llllllllllllllllIIIIIIIlIIIlIlIl[13] * llllllllllllllllIIIIIIIlIIIlIllI[4] + llllllllllllllllIIIIIIIlIIIlIlIl[14] * llllllllllllllllIIIIIIIlIIIlIllI[8] + llllllllllllllllIIIIIIIlIIIlIlIl[15] * llllllllllllllllIIIIIIIlIIIlIllI[12];
        this.clippingMatrix[13] = llllllllllllllllIIIIIIIlIIIlIlIl[12] * llllllllllllllllIIIIIIIlIIIlIllI[1] + llllllllllllllllIIIIIIIlIIIlIlIl[13] * llllllllllllllllIIIIIIIlIIIlIllI[5] + llllllllllllllllIIIIIIIlIIIlIlIl[14] * llllllllllllllllIIIIIIIlIIIlIllI[9] + llllllllllllllllIIIIIIIlIIIlIlIl[15] * llllllllllllllllIIIIIIIlIIIlIllI[13];
        this.clippingMatrix[14] = llllllllllllllllIIIIIIIlIIIlIlIl[12] * llllllllllllllllIIIIIIIlIIIlIllI[2] + llllllllllllllllIIIIIIIlIIIlIlIl[13] * llllllllllllllllIIIIIIIlIIIlIllI[6] + llllllllllllllllIIIIIIIlIIIlIlIl[14] * llllllllllllllllIIIIIIIlIIIlIllI[10] + llllllllllllllllIIIIIIIlIIIlIlIl[15] * llllllllllllllllIIIIIIIlIIIlIllI[14];
        this.clippingMatrix[15] = llllllllllllllllIIIIIIIlIIIlIlIl[12] * llllllllllllllllIIIIIIIlIIIlIllI[3] + llllllllllllllllIIIIIIIlIIIlIlIl[13] * llllllllllllllllIIIIIIIlIIIlIllI[7] + llllllllllllllllIIIIIIIlIIIlIlIl[14] * llllllllllllllllIIIIIIIlIIIlIllI[11] + llllllllllllllllIIIIIIIlIIIlIlIl[15] * llllllllllllllllIIIIIIIlIIIlIllI[15];
        final float[] llllllllllllllllIIIIIIIlIIIlIlII = this.frustum[0];
        llllllllllllllllIIIIIIIlIIIlIlII[0] = this.clippingMatrix[3] - this.clippingMatrix[0];
        llllllllllllllllIIIIIIIlIIIlIlII[1] = this.clippingMatrix[7] - this.clippingMatrix[4];
        llllllllllllllllIIIIIIIlIIIlIlII[2] = this.clippingMatrix[11] - this.clippingMatrix[8];
        llllllllllllllllIIIIIIIlIIIlIlII[3] = this.clippingMatrix[15] - this.clippingMatrix[12];
        this.normalize(llllllllllllllllIIIIIIIlIIIlIlII);
        final float[] llllllllllllllllIIIIIIIlIIIlIIll = this.frustum[1];
        llllllllllllllllIIIIIIIlIIIlIIll[0] = this.clippingMatrix[3] + this.clippingMatrix[0];
        llllllllllllllllIIIIIIIlIIIlIIll[1] = this.clippingMatrix[7] + this.clippingMatrix[4];
        llllllllllllllllIIIIIIIlIIIlIIll[2] = this.clippingMatrix[11] + this.clippingMatrix[8];
        llllllllllllllllIIIIIIIlIIIlIIll[3] = this.clippingMatrix[15] + this.clippingMatrix[12];
        this.normalize(llllllllllllllllIIIIIIIlIIIlIIll);
        final float[] llllllllllllllllIIIIIIIlIIIlIIlI = this.frustum[2];
        llllllllllllllllIIIIIIIlIIIlIIlI[0] = this.clippingMatrix[3] + this.clippingMatrix[1];
        llllllllllllllllIIIIIIIlIIIlIIlI[1] = this.clippingMatrix[7] + this.clippingMatrix[5];
        llllllllllllllllIIIIIIIlIIIlIIlI[2] = this.clippingMatrix[11] + this.clippingMatrix[9];
        llllllllllllllllIIIIIIIlIIIlIIlI[3] = this.clippingMatrix[15] + this.clippingMatrix[13];
        this.normalize(llllllllllllllllIIIIIIIlIIIlIIlI);
        final float[] llllllllllllllllIIIIIIIlIIIlIIIl = this.frustum[3];
        llllllllllllllllIIIIIIIlIIIlIIIl[0] = this.clippingMatrix[3] - this.clippingMatrix[1];
        llllllllllllllllIIIIIIIlIIIlIIIl[1] = this.clippingMatrix[7] - this.clippingMatrix[5];
        llllllllllllllllIIIIIIIlIIIlIIIl[2] = this.clippingMatrix[11] - this.clippingMatrix[9];
        llllllllllllllllIIIIIIIlIIIlIIIl[3] = this.clippingMatrix[15] - this.clippingMatrix[13];
        this.normalize(llllllllllllllllIIIIIIIlIIIlIIIl);
        final float[] llllllllllllllllIIIIIIIlIIIlIIII = this.frustum[4];
        llllllllllllllllIIIIIIIlIIIlIIII[0] = this.clippingMatrix[3] - this.clippingMatrix[2];
        llllllllllllllllIIIIIIIlIIIlIIII[1] = this.clippingMatrix[7] - this.clippingMatrix[6];
        llllllllllllllllIIIIIIIlIIIlIIII[2] = this.clippingMatrix[11] - this.clippingMatrix[10];
        llllllllllllllllIIIIIIIlIIIlIIII[3] = this.clippingMatrix[15] - this.clippingMatrix[14];
        this.normalize(llllllllllllllllIIIIIIIlIIIlIIII);
        final float[] llllllllllllllllIIIIIIIlIIIIllll = this.frustum[5];
        llllllllllllllllIIIIIIIlIIIIllll[0] = this.clippingMatrix[3] + this.clippingMatrix[2];
        llllllllllllllllIIIIIIIlIIIIllll[1] = this.clippingMatrix[7] + this.clippingMatrix[6];
        llllllllllllllllIIIIIIIlIIIIllll[2] = this.clippingMatrix[11] + this.clippingMatrix[10];
        llllllllllllllllIIIIIIIlIIIIllll[3] = this.clippingMatrix[15] + this.clippingMatrix[14];
        this.normalize(llllllllllllllllIIIIIIIlIIIIllll);
    }
    
    static {
        instance = new ClippingHelperImpl();
    }
}
