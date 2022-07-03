package net.minecraft.client.renderer.culling;

public class ClippingHelper
{
    public /* synthetic */ float[] modelviewMatrix;
    public /* synthetic */ float[] projectionMatrix;
    public /* synthetic */ float[] clippingMatrix;
    public /* synthetic */ float[][] frustum;
    
    public ClippingHelper() {
        this.frustum = new float[6][4];
        this.projectionMatrix = new float[16];
        this.modelviewMatrix = new float[16];
        this.clippingMatrix = new float[16];
    }
    
    private float dot(final float[] llllllllllllIlllllIllIIIIIlIIllI, final float llllllllllllIlllllIllIIIIIlIlIIl, final float llllllllllllIlllllIllIIIIIlIlIII, final float llllllllllllIlllllIllIIIIIlIIlll) {
        return llllllllllllIlllllIllIIIIIlIIllI[0] * llllllllllllIlllllIllIIIIIlIlIIl + llllllllllllIlllllIllIIIIIlIIllI[1] * llllllllllllIlllllIllIIIIIlIlIII + llllllllllllIlllllIllIIIIIlIIllI[2] * llllllllllllIlllllIllIIIIIlIIlll + llllllllllllIlllllIllIIIIIlIIllI[3];
    }
    
    public boolean isBoxInFrustum(final double llllllllllllIlllllIllIIIIIIlIIlI, final double llllllllllllIlllllIllIIIIIIIIIlI, final double llllllllllllIlllllIllIIIIIIlIIII, final double llllllllllllIlllllIllIIIIIIIllll, final double llllllllllllIlllllIllIIIIIIIlllI, final double llllllllllllIlllllIlIllllllllllI) {
        final float llllllllllllIlllllIllIIIIIIIllII = (float)llllllllllllIlllllIllIIIIIIlIIlI;
        final float llllllllllllIlllllIllIIIIIIIlIll = (float)llllllllllllIlllllIllIIIIIIIIIlI;
        final float llllllllllllIlllllIllIIIIIIIlIlI = (float)llllllllllllIlllllIllIIIIIIlIIII;
        final float llllllllllllIlllllIllIIIIIIIlIIl = (float)llllllllllllIlllllIllIIIIIIIllll;
        final float llllllllllllIlllllIllIIIIIIIlIII = (float)llllllllllllIlllllIllIIIIIIIlllI;
        final float llllllllllllIlllllIllIIIIIIIIlll = (float)llllllllllllIlllllIlIllllllllllI;
        for (int llllllllllllIlllllIllIIIIIIIIllI = 0; llllllllllllIlllllIllIIIIIIIIllI < 6; ++llllllllllllIlllllIllIIIIIIIIllI) {
            final float[] llllllllllllIlllllIllIIIIIIIIlIl = this.frustum[llllllllllllIlllllIllIIIIIIIIllI];
            if (this.dot(llllllllllllIlllllIllIIIIIIIIlIl, llllllllllllIlllllIllIIIIIIIllII, llllllllllllIlllllIllIIIIIIIlIll, llllllllllllIlllllIllIIIIIIIlIlI) <= 0.0f && this.dot(llllllllllllIlllllIllIIIIIIIIlIl, llllllllllllIlllllIllIIIIIIIlIIl, llllllllllllIlllllIllIIIIIIIlIll, llllllllllllIlllllIllIIIIIIIlIlI) <= 0.0f && this.dot(llllllllllllIlllllIllIIIIIIIIlIl, llllllllllllIlllllIllIIIIIIIllII, llllllllllllIlllllIllIIIIIIIlIII, llllllllllllIlllllIllIIIIIIIlIlI) <= 0.0f && this.dot(llllllllllllIlllllIllIIIIIIIIlIl, llllllllllllIlllllIllIIIIIIIlIIl, llllllllllllIlllllIllIIIIIIIlIII, llllllllllllIlllllIllIIIIIIIlIlI) <= 0.0f && this.dot(llllllllllllIlllllIllIIIIIIIIlIl, llllllllllllIlllllIllIIIIIIIllII, llllllllllllIlllllIllIIIIIIIlIll, llllllllllllIlllllIllIIIIIIIIlll) <= 0.0f && this.dot(llllllllllllIlllllIllIIIIIIIIlIl, llllllllllllIlllllIllIIIIIIIlIIl, llllllllllllIlllllIllIIIIIIIlIll, llllllllllllIlllllIllIIIIIIIIlll) <= 0.0f && this.dot(llllllllllllIlllllIllIIIIIIIIlIl, llllllllllllIlllllIllIIIIIIIllII, llllllllllllIlllllIllIIIIIIIlIII, llllllllllllIlllllIllIIIIIIIIlll) <= 0.0f && this.dot(llllllllllllIlllllIllIIIIIIIIlIl, llllllllllllIlllllIllIIIIIIIlIIl, llllllllllllIlllllIllIIIIIIIlIII, llllllllllllIlllllIllIIIIIIIIlll) <= 0.0f) {
                return false;
            }
        }
        return true;
    }
}
