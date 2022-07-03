package shadersmod.client;

import net.minecraft.client.renderer.culling.*;
import net.minecraft.util.math.*;

public class ClippingHelperShadow extends ClippingHelper
{
    /* synthetic */ float[] vecIntersection;
    /* synthetic */ float[][] shadowClipPlanes;
    /* synthetic */ float[] matInvMP;
    /* synthetic */ float[] frustumTest;
    private static /* synthetic */ ClippingHelperShadow instance;
    /* synthetic */ int shadowClipPlaneCount;
    
    private float distance(final float lllllllllllllIIlllllIlllIlIIlIII, final float lllllllllllllIIlllllIlllIlIIIlll, final float lllllllllllllIIlllllIlllIlIIIllI, final float lllllllllllllIIlllllIlllIlIIIlIl, final float lllllllllllllIIlllllIlllIlIIlIll, final float lllllllllllllIIlllllIlllIlIIlIlI) {
        return this.length(lllllllllllllIIlllllIlllIlIIlIII - lllllllllllllIIlllllIlllIlIIIlIl, lllllllllllllIIlllllIlllIlIIIlll - lllllllllllllIIlllllIlllIlIIlIll, lllllllllllllIIlllllIlllIlIIIllI - lllllllllllllIIlllllIlllIlIIlIlI);
    }
    
    private void normalizePlane(final float[] lllllllllllllIIlllllIllllIIlIllI) {
        final float lllllllllllllIIlllllIllllIIlIlIl = MathHelper.sqrt(lllllllllllllIIlllllIllllIIlIllI[0] * lllllllllllllIIlllllIllllIIlIllI[0] + lllllllllllllIIlllllIllllIIlIllI[1] * lllllllllllllIIlllllIllllIIlIllI[1] + lllllllllllllIIlllllIllllIIlIllI[2] * lllllllllllllIIlllllIllllIIlIllI[2]);
        final int n = 0;
        lllllllllllllIIlllllIllllIIlIllI[n] /= lllllllllllllIIlllllIllllIIlIlIl;
        final int n2 = 1;
        lllllllllllllIIlllllIllllIIlIllI[n2] /= lllllllllllllIIlllllIllllIIlIlIl;
        final int n3 = 2;
        lllllllllllllIIlllllIllllIIlIllI[n3] /= lllllllllllllIIlllllIllllIIlIlIl;
        final int n4 = 3;
        lllllllllllllIIlllllIllllIIlIllI[n4] /= lllllllllllllIIlllllIllllIIlIlIl;
    }
    
    private void addShadowClipPlane(final float[] lllllllllllllIIlllllIlllIllIIIlI) {
        this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], lllllllllllllIIlllllIlllIllIIIlI);
    }
    
    private double dot3(final float[] lllllllllllllIIlllllIllllIIllIll, final float[] lllllllllllllIIlllllIllllIIlllII) {
        return lllllllllllllIIlllllIllllIIllIll[0] * (double)lllllllllllllIIlllllIllllIIlllII[0] + lllllllllllllIIlllllIllllIIllIll[1] * (double)lllllllllllllIIlllllIllllIIlllII[1] + lllllllllllllIIlllllIllllIIllIll[2] * (double)lllllllllllllIIlllllIllllIIlllII[2];
    }
    
    @Override
    public boolean isBoxInFrustum(final double lllllllllllllIIlllllIllllIllIlIl, final double lllllllllllllIIlllllIllllIllllIl, final double lllllllllllllIIlllllIllllIllIIll, final double lllllllllllllIIlllllIllllIlllIll, final double lllllllllllllIIlllllIllllIlllIlI, final double lllllllllllllIIlllllIllllIlllIIl) {
        for (int lllllllllllllIIlllllIllllIlllIII = 0; lllllllllllllIIlllllIllllIlllIII < this.shadowClipPlaneCount; ++lllllllllllllIIlllllIllllIlllIII) {
            final float[] lllllllllllllIIlllllIllllIllIlll = this.shadowClipPlanes[lllllllllllllIIlllllIllllIlllIII];
            if (this.dot4(lllllllllllllIIlllllIllllIllIlll, lllllllllllllIIlllllIllllIllIlIl, lllllllllllllIIlllllIllllIllllIl, lllllllllllllIIlllllIllllIllIIll) <= 0.0 && this.dot4(lllllllllllllIIlllllIllllIllIlll, lllllllllllllIIlllllIllllIlllIll, lllllllllllllIIlllllIllllIllllIl, lllllllllllllIIlllllIllllIllIIll) <= 0.0 && this.dot4(lllllllllllllIIlllllIllllIllIlll, lllllllllllllIIlllllIllllIllIlIl, lllllllllllllIIlllllIllllIlllIlI, lllllllllllllIIlllllIllllIllIIll) <= 0.0 && this.dot4(lllllllllllllIIlllllIllllIllIlll, lllllllllllllIIlllllIllllIlllIll, lllllllllllllIIlllllIllllIlllIlI, lllllllllllllIIlllllIllllIllIIll) <= 0.0 && this.dot4(lllllllllllllIIlllllIllllIllIlll, lllllllllllllIIlllllIllllIllIlIl, lllllllllllllIIlllllIllllIllllIl, lllllllllllllIIlllllIllllIlllIIl) <= 0.0 && this.dot4(lllllllllllllIIlllllIllllIllIlll, lllllllllllllIIlllllIllllIlllIll, lllllllllllllIIlllllIllllIllllIl, lllllllllllllIIlllllIllllIlllIIl) <= 0.0 && this.dot4(lllllllllllllIIlllllIllllIllIlll, lllllllllllllIIlllllIllllIllIlIl, lllllllllllllIIlllllIllllIlllIlI, lllllllllllllIIlllllIllllIlllIIl) <= 0.0 && this.dot4(lllllllllllllIIlllllIllllIllIlll, lllllllllllllIIlllllIllllIlllIll, lllllllllllllIIlllllIllllIlllIlI, lllllllllllllIIlllllIllllIlllIIl) <= 0.0) {
                return false;
            }
        }
        return true;
    }
    
    public void init() {
        final float[] lllllllllllllIIlllllIllIlIlIlIlI = this.projectionMatrix;
        final float[] lllllllllllllIIlllllIllIlIlIlIIl = this.modelviewMatrix;
        final float[] lllllllllllllIIlllllIllIlIlIlIII = this.clippingMatrix;
        System.arraycopy(Shaders.faProjection, 0, lllllllllllllIIlllllIllIlIlIlIlI, 0, 16);
        System.arraycopy(Shaders.faModelView, 0, lllllllllllllIIlllllIllIlIlIlIIl, 0, 16);
        SMath.multiplyMat4xMat4(lllllllllllllIIlllllIllIlIlIlIII, lllllllllllllIIlllllIllIlIlIlIIl, lllllllllllllIIlllllIllIlIlIlIlI);
        this.assignPlane(this.frustum[0], lllllllllllllIIlllllIllIlIlIlIII[3] - lllllllllllllIIlllllIllIlIlIlIII[0], lllllllllllllIIlllllIllIlIlIlIII[7] - lllllllllllllIIlllllIllIlIlIlIII[4], lllllllllllllIIlllllIllIlIlIlIII[11] - lllllllllllllIIlllllIllIlIlIlIII[8], lllllllllllllIIlllllIllIlIlIlIII[15] - lllllllllllllIIlllllIllIlIlIlIII[12]);
        this.assignPlane(this.frustum[1], lllllllllllllIIlllllIllIlIlIlIII[3] + lllllllllllllIIlllllIllIlIlIlIII[0], lllllllllllllIIlllllIllIlIlIlIII[7] + lllllllllllllIIlllllIllIlIlIlIII[4], lllllllllllllIIlllllIllIlIlIlIII[11] + lllllllllllllIIlllllIllIlIlIlIII[8], lllllllllllllIIlllllIllIlIlIlIII[15] + lllllllllllllIIlllllIllIlIlIlIII[12]);
        this.assignPlane(this.frustum[2], lllllllllllllIIlllllIllIlIlIlIII[3] + lllllllllllllIIlllllIllIlIlIlIII[1], lllllllllllllIIlllllIllIlIlIlIII[7] + lllllllllllllIIlllllIllIlIlIlIII[5], lllllllllllllIIlllllIllIlIlIlIII[11] + lllllllllllllIIlllllIllIlIlIlIII[9], lllllllllllllIIlllllIllIlIlIlIII[15] + lllllllllllllIIlllllIllIlIlIlIII[13]);
        this.assignPlane(this.frustum[3], lllllllllllllIIlllllIllIlIlIlIII[3] - lllllllllllllIIlllllIllIlIlIlIII[1], lllllllllllllIIlllllIllIlIlIlIII[7] - lllllllllllllIIlllllIllIlIlIlIII[5], lllllllllllllIIlllllIllIlIlIlIII[11] - lllllllllllllIIlllllIllIlIlIlIII[9], lllllllllllllIIlllllIllIlIlIlIII[15] - lllllllllllllIIlllllIllIlIlIlIII[13]);
        this.assignPlane(this.frustum[4], lllllllllllllIIlllllIllIlIlIlIII[3] - lllllllllllllIIlllllIllIlIlIlIII[2], lllllllllllllIIlllllIllIlIlIlIII[7] - lllllllllllllIIlllllIllIlIlIlIII[6], lllllllllllllIIlllllIllIlIlIlIII[11] - lllllllllllllIIlllllIllIlIlIlIII[10], lllllllllllllIIlllllIllIlIlIlIII[15] - lllllllllllllIIlllllIllIlIlIlIII[14]);
        this.assignPlane(this.frustum[5], lllllllllllllIIlllllIllIlIlIlIII[3] + lllllllllllllIIlllllIllIlIlIlIII[2], lllllllllllllIIlllllIllIlIlIlIII[7] + lllllllllllllIIlllllIllIlIlIlIII[6], lllllllllllllIIlllllIllIlIlIlIII[11] + lllllllllllllIIlllllIllIlIlIlIII[10], lllllllllllllIIlllllIllIlIlIlIII[15] + lllllllllllllIIlllllIllIlIlIlIII[14]);
        final float[] lllllllllllllIIlllllIllIlIlIIlll = Shaders.shadowLightPositionVector;
        final float lllllllllllllIIlllllIllIlIlIIllI = (float)this.dot3(this.frustum[0], lllllllllllllIIlllllIllIlIlIIlll);
        final float lllllllllllllIIlllllIllIlIlIIlIl = (float)this.dot3(this.frustum[1], lllllllllllllIIlllllIllIlIlIIlll);
        final float lllllllllllllIIlllllIllIlIlIIlII = (float)this.dot3(this.frustum[2], lllllllllllllIIlllllIllIlIlIIlll);
        final float lllllllllllllIIlllllIllIlIlIIIll = (float)this.dot3(this.frustum[3], lllllllllllllIIlllllIllIlIlIIlll);
        final float lllllllllllllIIlllllIllIlIlIIIlI = (float)this.dot3(this.frustum[4], lllllllllllllIIlllllIllIlIlIIlll);
        final float lllllllllllllIIlllllIllIlIlIIIIl = (float)this.dot3(this.frustum[5], lllllllllllllIIlllllIllIlIlIIlll);
        this.shadowClipPlaneCount = 0;
        if (lllllllllllllIIlllllIllIlIlIIllI >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0]);
            if (lllllllllllllIIlllllIllIlIlIIllI > 0.0f) {
                if (lllllllllllllIIlllllIllIlIlIIlII < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0], this.frustum[2], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIll < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0], this.frustum[3], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIlI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0], this.frustum[4], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[0], this.frustum[5], lllllllllllllIIlllllIllIlIlIIlll);
                }
            }
        }
        if (lllllllllllllIIlllllIllIlIlIIlIl >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1]);
            if (lllllllllllllIIlllllIllIlIlIIlIl > 0.0f) {
                if (lllllllllllllIIlllllIllIlIlIIlII < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1], this.frustum[2], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIll < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1], this.frustum[3], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIlI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1], this.frustum[4], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[1], this.frustum[5], lllllllllllllIIlllllIllIlIlIIlll);
                }
            }
        }
        if (lllllllllllllIIlllllIllIlIlIIlII >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2]);
            if (lllllllllllllIIlllllIllIlIlIIlII > 0.0f) {
                if (lllllllllllllIIlllllIllIlIlIIllI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2], this.frustum[0], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIlIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2], this.frustum[1], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIlI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2], this.frustum[4], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[2], this.frustum[5], lllllllllllllIIlllllIllIlIlIIlll);
                }
            }
        }
        if (lllllllllllllIIlllllIllIlIlIIIll >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3]);
            if (lllllllllllllIIlllllIllIlIlIIIll > 0.0f) {
                if (lllllllllllllIIlllllIllIlIlIIllI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3], this.frustum[0], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIlIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3], this.frustum[1], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIlI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3], this.frustum[4], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[3], this.frustum[5], lllllllllllllIIlllllIllIlIlIIlll);
                }
            }
        }
        if (lllllllllllllIIlllllIllIlIlIIIlI >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4]);
            if (lllllllllllllIIlllllIllIlIlIIIlI > 0.0f) {
                if (lllllllllllllIIlllllIllIlIlIIllI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4], this.frustum[0], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIlIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4], this.frustum[1], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIlII < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4], this.frustum[2], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIll < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[4], this.frustum[3], lllllllllllllIIlllllIllIlIlIIlll);
                }
            }
        }
        if (lllllllllllllIIlllllIllIlIlIIIIl >= 0.0f) {
            this.copyPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5]);
            if (lllllllllllllIIlllllIllIlIlIIIIl > 0.0f) {
                if (lllllllllllllIIlllllIllIlIlIIllI < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5], this.frustum[0], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIlIl < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5], this.frustum[1], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIlII < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5], this.frustum[2], lllllllllllllIIlllllIllIlIlIIlll);
                }
                if (lllllllllllllIIlllllIllIlIlIIIll < 0.0f) {
                    this.makeShadowPlane(this.shadowClipPlanes[this.shadowClipPlaneCount++], this.frustum[5], this.frustum[3], lllllllllllllIIlllllIllIlIlIIlll);
                }
            }
        }
    }
    
    private void normalize3(final float[] lllllllllllllIIlllllIllllIIIllll) {
        float lllllllllllllIIlllllIllllIIIlllI = MathHelper.sqrt(lllllllllllllIIlllllIllllIIIllll[0] * lllllllllllllIIlllllIllllIIIllll[0] + lllllllllllllIIlllllIllllIIIllll[1] * lllllllllllllIIlllllIllllIIIllll[1] + lllllllllllllIIlllllIllllIIIllll[2] * lllllllllllllIIlllllIllllIIIllll[2]);
        if (lllllllllllllIIlllllIllllIIIlllI == 0.0f) {
            lllllllllllllIIlllllIllllIIIlllI = 1.0f;
        }
        final int n = 0;
        lllllllllllllIIlllllIllllIIIllll[n] /= lllllllllllllIIlllllIllllIIIlllI;
        final int n2 = 1;
        lllllllllllllIIlllllIllllIIIllll[n2] /= lllllllllllllIIlllllIllllIIIlllI;
        final int n3 = 2;
        lllllllllllllIIlllllIllllIIIllll[n3] /= lllllllllllllIIlllllIllllIIIlllI;
    }
    
    private double dot4(final float[] lllllllllllllIIlllllIllllIlIlIII, final double lllllllllllllIIlllllIllllIlIIlll, final double lllllllllllllIIlllllIllllIlIIllI, final double lllllllllllllIIlllllIllllIlIIIIl) {
        return lllllllllllllIIlllllIllllIlIlIII[0] * lllllllllllllIIlllllIllllIlIIlll + lllllllllllllIIlllllIllllIlIlIII[1] * lllllllllllllIIlllllIllllIlIIllI + lllllllllllllIIlllllIllllIlIlIII[2] * lllllllllllllIIlllllIllllIlIIIIl + lllllllllllllIIlllllIllllIlIlIII[3];
    }
    
    private float length(final float lllllllllllllIIlllllIlllIlIllIlI, final float lllllllllllllIIlllllIlllIlIlllII, final float lllllllllllllIIlllllIlllIlIllIll) {
        return (float)Math.sqrt(lllllllllllllIIlllllIlllIlIllIlI * lllllllllllllIIlllllIlllIlIllIlI + lllllllllllllIIlllllIlllIlIlllII * lllllllllllllIIlllllIlllIlIlllII + lllllllllllllIIlllllIlllIlIllIll * lllllllllllllIIlllllIlllIlIllIll);
    }
    
    static {
        ClippingHelperShadow.instance = new ClippingHelperShadow();
    }
    
    private void makeShadowPlane(final float[] lllllllllllllIIlllllIlllIIIlIlll, final float[] lllllllllllllIIlllllIlllIIIlIlIl, final float[] lllllllllllllIIlllllIllIllllllIl, final float[] lllllllllllllIIlllllIllIllllllII) {
        this.cross3(this.vecIntersection, lllllllllllllIIlllllIlllIIIlIlIl, lllllllllllllIIlllllIllIllllllIl);
        this.cross3(lllllllllllllIIlllllIlllIIIlIlll, this.vecIntersection, lllllllllllllIIlllllIllIllllllII);
        this.normalize3(lllllllllllllIIlllllIlllIIIlIlll);
        final float lllllllllllllIIlllllIlllIIIlIIII = (float)this.dot3(lllllllllllllIIlllllIlllIIIlIlIl, lllllllllllllIIlllllIllIllllllIl);
        final float lllllllllllllIIlllllIlllIIIIllll = (float)this.dot3(lllllllllllllIIlllllIlllIIIlIlll, lllllllllllllIIlllllIllIllllllIl);
        final float lllllllllllllIIlllllIlllIIIIlllI = this.distance(lllllllllllllIIlllllIlllIIIlIlll[0], lllllllllllllIIlllllIlllIIIlIlll[1], lllllllllllllIIlllllIlllIIIlIlll[2], lllllllllllllIIlllllIllIllllllIl[0] * lllllllllllllIIlllllIlllIIIIllll, lllllllllllllIIlllllIllIllllllIl[1] * lllllllllllllIIlllllIlllIIIIllll, lllllllllllllIIlllllIllIllllllIl[2] * lllllllllllllIIlllllIlllIIIIllll);
        final float lllllllllllllIIlllllIlllIIIIllII = this.distance(lllllllllllllIIlllllIlllIIIlIlIl[0], lllllllllllllIIlllllIlllIIIlIlIl[1], lllllllllllllIIlllllIlllIIIlIlIl[2], lllllllllllllIIlllllIllIllllllIl[0] * lllllllllllllIIlllllIlllIIIlIIII, lllllllllllllIIlllllIllIllllllIl[1] * lllllllllllllIIlllllIlllIIIlIIII, lllllllllllllIIlllllIllIllllllIl[2] * lllllllllllllIIlllllIlllIIIlIIII);
        final float lllllllllllllIIlllllIlllIIIIlIlI = lllllllllllllIIlllllIlllIIIIlllI / lllllllllllllIIlllllIlllIIIIllII;
        final float lllllllllllllIIlllllIlllIIIIlIIl = (float)this.dot3(lllllllllllllIIlllllIlllIIIlIlll, lllllllllllllIIlllllIlllIIIlIlIl);
        final float lllllllllllllIIlllllIlllIIIIIlll = this.distance(lllllllllllllIIlllllIlllIIIlIlll[0], lllllllllllllIIlllllIlllIIIlIlll[1], lllllllllllllIIlllllIlllIIIlIlll[2], lllllllllllllIIlllllIlllIIIlIlIl[0] * lllllllllllllIIlllllIlllIIIIlIIl, lllllllllllllIIlllllIlllIIIlIlIl[1] * lllllllllllllIIlllllIlllIIIIlIIl, lllllllllllllIIlllllIlllIIIlIlIl[2] * lllllllllllllIIlllllIlllIIIIlIIl);
        final float lllllllllllllIIlllllIlllIIIIIllI = this.distance(lllllllllllllIIlllllIllIllllllIl[0], lllllllllllllIIlllllIllIllllllIl[1], lllllllllllllIIlllllIllIllllllIl[2], lllllllllllllIIlllllIlllIIIlIlIl[0] * lllllllllllllIIlllllIlllIIIlIIII, lllllllllllllIIlllllIlllIIIlIlIl[1] * lllllllllllllIIlllllIlllIIIlIIII, lllllllllllllIIlllllIlllIIIlIlIl[2] * lllllllllllllIIlllllIlllIIIlIIII);
        final float lllllllllllllIIlllllIlllIIIIIlIl = lllllllllllllIIlllllIlllIIIIIlll / lllllllllllllIIlllllIlllIIIIIllI;
        lllllllllllllIIlllllIlllIIIlIlll[3] = lllllllllllllIIlllllIlllIIIlIlIl[3] * lllllllllllllIIlllllIlllIIIIlIlI + lllllllllllllIIlllllIllIllllllIl[3] * lllllllllllllIIlllllIlllIIIIIlIl;
    }
    
    public ClippingHelperShadow() {
        this.frustumTest = new float[6];
        this.shadowClipPlanes = new float[10][4];
        this.matInvMP = new float[16];
        this.vecIntersection = new float[4];
    }
    
    public static ClippingHelper getInstance() {
        ClippingHelperShadow.instance.init();
        return ClippingHelperShadow.instance;
    }
    
    private void cross3(final float[] lllllllllllllIIlllllIlllIllIlIlI, final float[] lllllllllllllIIlllllIlllIllIlIIl, final float[] lllllllllllllIIlllllIlllIllIlIII) {
        lllllllllllllIIlllllIlllIllIlIlI[0] = lllllllllllllIIlllllIlllIllIlIIl[1] * lllllllllllllIIlllllIlllIllIlIII[2] - lllllllllllllIIlllllIlllIllIlIIl[2] * lllllllllllllIIlllllIlllIllIlIII[1];
        lllllllllllllIIlllllIlllIllIlIlI[1] = lllllllllllllIIlllllIlllIllIlIIl[2] * lllllllllllllIIlllllIlllIllIlIII[0] - lllllllllllllIIlllllIlllIllIlIIl[0] * lllllllllllllIIlllllIlllIllIlIII[2];
        lllllllllllllIIlllllIlllIllIlIlI[2] = lllllllllllllIIlllllIlllIllIlIIl[0] * lllllllllllllIIlllllIlllIllIlIII[1] - lllllllllllllIIlllllIlllIllIlIIl[1] * lllllllllllllIIlllllIlllIllIlIII[0];
    }
    
    private void copyPlane(final float[] lllllllllllllIIlllllIlllIlllIIll, final float[] lllllllllllllIIlllllIlllIlllIIlI) {
        lllllllllllllIIlllllIlllIlllIIll[0] = lllllllllllllIIlllllIlllIlllIIlI[0];
        lllllllllllllIIlllllIlllIlllIIll[1] = lllllllllllllIIlllllIlllIlllIIlI[1];
        lllllllllllllIIlllllIlllIlllIIll[2] = lllllllllllllIIlllllIlllIlllIIlI[2];
        lllllllllllllIIlllllIlllIlllIIll[3] = lllllllllllllIIlllllIlllIlllIIlI[3];
    }
    
    private void assignPlane(final float[] lllllllllllllIIlllllIlllIllllllI, final float lllllllllllllIIlllllIlllIlllllIl, final float lllllllllllllIIlllllIllllIIIIIlI, final float lllllllllllllIIlllllIlllIllllIll, final float lllllllllllllIIlllllIllllIIIIIII) {
        final float lllllllllllllIIlllllIlllIlllllll = (float)Math.sqrt(lllllllllllllIIlllllIlllIlllllIl * lllllllllllllIIlllllIlllIlllllIl + lllllllllllllIIlllllIllllIIIIIlI * lllllllllllllIIlllllIllllIIIIIlI + lllllllllllllIIlllllIlllIllllIll * lllllllllllllIIlllllIlllIllllIll);
        lllllllllllllIIlllllIlllIllllllI[0] = lllllllllllllIIlllllIlllIlllllIl / lllllllllllllIIlllllIlllIlllllll;
        lllllllllllllIIlllllIlllIllllllI[1] = lllllllllllllIIlllllIllllIIIIIlI / lllllllllllllIIlllllIlllIlllllll;
        lllllllllllllIIlllllIlllIllllllI[2] = lllllllllllllIIlllllIlllIllllIll / lllllllllllllIIlllllIlllIlllllll;
        lllllllllllllIIlllllIlllIllllllI[3] = lllllllllllllIIlllllIllllIIIIIII / lllllllllllllIIlllllIlllIlllllll;
    }
}
