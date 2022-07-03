package javax.vecmath;

import java.io.*;

public class Matrix3f implements Cloneable, Serializable
{
    public /* synthetic */ float m22;
    public /* synthetic */ float m01;
    public /* synthetic */ float m20;
    public /* synthetic */ float m21;
    public /* synthetic */ float m10;
    public /* synthetic */ float m12;
    public /* synthetic */ float m11;
    public /* synthetic */ float m02;
    public /* synthetic */ float m00;
    
    public final float getM20() {
        return this.m20;
    }
    
    public final float getM00() {
        return this.m00;
    }
    
    public final void getColumn(final int llllllllllllllllIIllIllIIIllIIll, final float[] llllllllllllllllIIllIllIIIllIIlI) {
        if (llllllllllllllllIIllIllIIIllIIll == 0) {
            llllllllllllllllIIllIllIIIllIIlI[0] = this.m00;
            llllllllllllllllIIllIllIIIllIIlI[1] = this.m10;
            llllllllllllllllIIllIllIIIllIIlI[2] = this.m20;
        }
        else if (llllllllllllllllIIllIllIIIllIIll == 1) {
            llllllllllllllllIIllIllIIIllIIlI[0] = this.m01;
            llllllllllllllllIIllIllIIIllIIlI[1] = this.m11;
            llllllllllllllllIIllIllIIIllIIlI[2] = this.m21;
        }
        else {
            if (llllllllllllllllIIllIllIIIllIIll != 2) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f3"));
            }
            llllllllllllllllIIllIllIIIllIIlI[0] = this.m02;
            llllllllllllllllIIllIllIIIllIIlI[1] = this.m12;
            llllllllllllllllIIllIllIIIllIIlI[2] = this.m22;
        }
    }
    
    public final void mulNormalize(final Matrix3f llllllllllllllllIIllIlIIIIIllIII, final Matrix3f llllllllllllllllIIllIlIIIIIlIIIl) {
        final double[] llllllllllllllllIIllIlIIIIIlIllI = new double[9];
        final double[] llllllllllllllllIIllIlIIIIIlIlIl = new double[9];
        final double[] llllllllllllllllIIllIlIIIIIlIlII = new double[3];
        llllllllllllllllIIllIlIIIIIlIllI[0] = llllllllllllllllIIllIlIIIIIllIII.m00 * llllllllllllllllIIllIlIIIIIlIIIl.m00 + llllllllllllllllIIllIlIIIIIllIII.m01 * llllllllllllllllIIllIlIIIIIlIIIl.m10 + llllllllllllllllIIllIlIIIIIllIII.m02 * llllllllllllllllIIllIlIIIIIlIIIl.m20;
        llllllllllllllllIIllIlIIIIIlIllI[1] = llllllllllllllllIIllIlIIIIIllIII.m00 * llllllllllllllllIIllIlIIIIIlIIIl.m01 + llllllllllllllllIIllIlIIIIIllIII.m01 * llllllllllllllllIIllIlIIIIIlIIIl.m11 + llllllllllllllllIIllIlIIIIIllIII.m02 * llllllllllllllllIIllIlIIIIIlIIIl.m21;
        llllllllllllllllIIllIlIIIIIlIllI[2] = llllllllllllllllIIllIlIIIIIllIII.m00 * llllllllllllllllIIllIlIIIIIlIIIl.m02 + llllllllllllllllIIllIlIIIIIllIII.m01 * llllllllllllllllIIllIlIIIIIlIIIl.m12 + llllllllllllllllIIllIlIIIIIllIII.m02 * llllllllllllllllIIllIlIIIIIlIIIl.m22;
        llllllllllllllllIIllIlIIIIIlIllI[3] = llllllllllllllllIIllIlIIIIIllIII.m10 * llllllllllllllllIIllIlIIIIIlIIIl.m00 + llllllllllllllllIIllIlIIIIIllIII.m11 * llllllllllllllllIIllIlIIIIIlIIIl.m10 + llllllllllllllllIIllIlIIIIIllIII.m12 * llllllllllllllllIIllIlIIIIIlIIIl.m20;
        llllllllllllllllIIllIlIIIIIlIllI[4] = llllllllllllllllIIllIlIIIIIllIII.m10 * llllllllllllllllIIllIlIIIIIlIIIl.m01 + llllllllllllllllIIllIlIIIIIllIII.m11 * llllllllllllllllIIllIlIIIIIlIIIl.m11 + llllllllllllllllIIllIlIIIIIllIII.m12 * llllllllllllllllIIllIlIIIIIlIIIl.m21;
        llllllllllllllllIIllIlIIIIIlIllI[5] = llllllllllllllllIIllIlIIIIIllIII.m10 * llllllllllllllllIIllIlIIIIIlIIIl.m02 + llllllllllllllllIIllIlIIIIIllIII.m11 * llllllllllllllllIIllIlIIIIIlIIIl.m12 + llllllllllllllllIIllIlIIIIIllIII.m12 * llllllllllllllllIIllIlIIIIIlIIIl.m22;
        llllllllllllllllIIllIlIIIIIlIllI[6] = llllllllllllllllIIllIlIIIIIllIII.m20 * llllllllllllllllIIllIlIIIIIlIIIl.m00 + llllllllllllllllIIllIlIIIIIllIII.m21 * llllllllllllllllIIllIlIIIIIlIIIl.m10 + llllllllllllllllIIllIlIIIIIllIII.m22 * llllllllllllllllIIllIlIIIIIlIIIl.m20;
        llllllllllllllllIIllIlIIIIIlIllI[7] = llllllllllllllllIIllIlIIIIIllIII.m20 * llllllllllllllllIIllIlIIIIIlIIIl.m01 + llllllllllllllllIIllIlIIIIIllIII.m21 * llllllllllllllllIIllIlIIIIIlIIIl.m11 + llllllllllllllllIIllIlIIIIIllIII.m22 * llllllllllllllllIIllIlIIIIIlIIIl.m21;
        llllllllllllllllIIllIlIIIIIlIllI[8] = llllllllllllllllIIllIlIIIIIllIII.m20 * llllllllllllllllIIllIlIIIIIlIIIl.m02 + llllllllllllllllIIllIlIIIIIllIII.m21 * llllllllllllllllIIllIlIIIIIlIIIl.m12 + llllllllllllllllIIllIlIIIIIllIII.m22 * llllllllllllllllIIllIlIIIIIlIIIl.m22;
        Matrix3d.compute_svd(llllllllllllllllIIllIlIIIIIlIllI, llllllllllllllllIIllIlIIIIIlIlII, llllllllllllllllIIllIlIIIIIlIlIl);
        this.m00 = (float)llllllllllllllllIIllIlIIIIIlIlIl[0];
        this.m01 = (float)llllllllllllllllIIllIlIIIIIlIlIl[1];
        this.m02 = (float)llllllllllllllllIIllIlIIIIIlIlIl[2];
        this.m10 = (float)llllllllllllllllIIllIlIIIIIlIlIl[3];
        this.m11 = (float)llllllllllllllllIIllIlIIIIIlIlIl[4];
        this.m12 = (float)llllllllllllllllIIllIlIIIIIlIlIl[5];
        this.m20 = (float)llllllllllllllllIIllIlIIIIIlIlIl[6];
        this.m21 = (float)llllllllllllllllIIllIlIIIIIlIlIl[7];
        this.m22 = (float)llllllllllllllllIIllIlIIIIIlIlIl[8];
    }
    
    public final void mulTransposeLeft(final Matrix3f llllllllllllllllIIllIIlllIlllIII, final Matrix3f llllllllllllllllIIllIIlllIllIlll) {
        if (this != llllllllllllllllIIllIIlllIlllIII && this != llllllllllllllllIIllIIlllIllIlll) {
            this.m00 = llllllllllllllllIIllIIlllIlllIII.m00 * llllllllllllllllIIllIIlllIllIlll.m00 + llllllllllllllllIIllIIlllIlllIII.m10 * llllllllllllllllIIllIIlllIllIlll.m10 + llllllllllllllllIIllIIlllIlllIII.m20 * llllllllllllllllIIllIIlllIllIlll.m20;
            this.m01 = llllllllllllllllIIllIIlllIlllIII.m00 * llllllllllllllllIIllIIlllIllIlll.m01 + llllllllllllllllIIllIIlllIlllIII.m10 * llllllllllllllllIIllIIlllIllIlll.m11 + llllllllllllllllIIllIIlllIlllIII.m20 * llllllllllllllllIIllIIlllIllIlll.m21;
            this.m02 = llllllllllllllllIIllIIlllIlllIII.m00 * llllllllllllllllIIllIIlllIllIlll.m02 + llllllllllllllllIIllIIlllIlllIII.m10 * llllllllllllllllIIllIIlllIllIlll.m12 + llllllllllllllllIIllIIlllIlllIII.m20 * llllllllllllllllIIllIIlllIllIlll.m22;
            this.m10 = llllllllllllllllIIllIIlllIlllIII.m01 * llllllllllllllllIIllIIlllIllIlll.m00 + llllllllllllllllIIllIIlllIlllIII.m11 * llllllllllllllllIIllIIlllIllIlll.m10 + llllllllllllllllIIllIIlllIlllIII.m21 * llllllllllllllllIIllIIlllIllIlll.m20;
            this.m11 = llllllllllllllllIIllIIlllIlllIII.m01 * llllllllllllllllIIllIIlllIllIlll.m01 + llllllllllllllllIIllIIlllIlllIII.m11 * llllllllllllllllIIllIIlllIllIlll.m11 + llllllllllllllllIIllIIlllIlllIII.m21 * llllllllllllllllIIllIIlllIllIlll.m21;
            this.m12 = llllllllllllllllIIllIIlllIlllIII.m01 * llllllllllllllllIIllIIlllIllIlll.m02 + llllllllllllllllIIllIIlllIlllIII.m11 * llllllllllllllllIIllIIlllIllIlll.m12 + llllllllllllllllIIllIIlllIlllIII.m21 * llllllllllllllllIIllIIlllIllIlll.m22;
            this.m20 = llllllllllllllllIIllIIlllIlllIII.m02 * llllllllllllllllIIllIIlllIllIlll.m00 + llllllllllllllllIIllIIlllIlllIII.m12 * llllllllllllllllIIllIIlllIllIlll.m10 + llllllllllllllllIIllIIlllIlllIII.m22 * llllllllllllllllIIllIIlllIllIlll.m20;
            this.m21 = llllllllllllllllIIllIIlllIlllIII.m02 * llllllllllllllllIIllIIlllIllIlll.m01 + llllllllllllllllIIllIIlllIlllIII.m12 * llllllllllllllllIIllIIlllIllIlll.m11 + llllllllllllllllIIllIIlllIlllIII.m22 * llllllllllllllllIIllIIlllIllIlll.m21;
            this.m22 = llllllllllllllllIIllIIlllIlllIII.m02 * llllllllllllllllIIllIIlllIllIlll.m02 + llllllllllllllllIIllIIlllIlllIII.m12 * llllllllllllllllIIllIIlllIllIlll.m12 + llllllllllllllllIIllIIlllIlllIII.m22 * llllllllllllllllIIllIIlllIllIlll.m22;
        }
        else {
            final float llllllllllllllllIIllIIlllIllIllI = llllllllllllllllIIllIIlllIlllIII.m00 * llllllllllllllllIIllIIlllIllIlll.m00 + llllllllllllllllIIllIIlllIlllIII.m10 * llllllllllllllllIIllIIlllIllIlll.m10 + llllllllllllllllIIllIIlllIlllIII.m20 * llllllllllllllllIIllIIlllIllIlll.m20;
            final float llllllllllllllllIIllIIlllIllIlIl = llllllllllllllllIIllIIlllIlllIII.m00 * llllllllllllllllIIllIIlllIllIlll.m01 + llllllllllllllllIIllIIlllIlllIII.m10 * llllllllllllllllIIllIIlllIllIlll.m11 + llllllllllllllllIIllIIlllIlllIII.m20 * llllllllllllllllIIllIIlllIllIlll.m21;
            final float llllllllllllllllIIllIIlllIllIlII = llllllllllllllllIIllIIlllIlllIII.m00 * llllllllllllllllIIllIIlllIllIlll.m02 + llllllllllllllllIIllIIlllIlllIII.m10 * llllllllllllllllIIllIIlllIllIlll.m12 + llllllllllllllllIIllIIlllIlllIII.m20 * llllllllllllllllIIllIIlllIllIlll.m22;
            final float llllllllllllllllIIllIIlllIllIIll = llllllllllllllllIIllIIlllIlllIII.m01 * llllllllllllllllIIllIIlllIllIlll.m00 + llllllllllllllllIIllIIlllIlllIII.m11 * llllllllllllllllIIllIIlllIllIlll.m10 + llllllllllllllllIIllIIlllIlllIII.m21 * llllllllllllllllIIllIIlllIllIlll.m20;
            final float llllllllllllllllIIllIIlllIllIIlI = llllllllllllllllIIllIIlllIlllIII.m01 * llllllllllllllllIIllIIlllIllIlll.m01 + llllllllllllllllIIllIIlllIlllIII.m11 * llllllllllllllllIIllIIlllIllIlll.m11 + llllllllllllllllIIllIIlllIlllIII.m21 * llllllllllllllllIIllIIlllIllIlll.m21;
            final float llllllllllllllllIIllIIlllIllIIIl = llllllllllllllllIIllIIlllIlllIII.m01 * llllllllllllllllIIllIIlllIllIlll.m02 + llllllllllllllllIIllIIlllIlllIII.m11 * llllllllllllllllIIllIIlllIllIlll.m12 + llllllllllllllllIIllIIlllIlllIII.m21 * llllllllllllllllIIllIIlllIllIlll.m22;
            final float llllllllllllllllIIllIIlllIllIIII = llllllllllllllllIIllIIlllIlllIII.m02 * llllllllllllllllIIllIIlllIllIlll.m00 + llllllllllllllllIIllIIlllIlllIII.m12 * llllllllllllllllIIllIIlllIllIlll.m10 + llllllllllllllllIIllIIlllIlllIII.m22 * llllllllllllllllIIllIIlllIllIlll.m20;
            final float llllllllllllllllIIllIIlllIlIllll = llllllllllllllllIIllIIlllIlllIII.m02 * llllllllllllllllIIllIIlllIllIlll.m01 + llllllllllllllllIIllIIlllIlllIII.m12 * llllllllllllllllIIllIIlllIllIlll.m11 + llllllllllllllllIIllIIlllIlllIII.m22 * llllllllllllllllIIllIIlllIllIlll.m21;
            final float llllllllllllllllIIllIIlllIlIlllI = llllllllllllllllIIllIIlllIlllIII.m02 * llllllllllllllllIIllIIlllIllIlll.m02 + llllllllllllllllIIllIIlllIlllIII.m12 * llllllllllllllllIIllIIlllIllIlll.m12 + llllllllllllllllIIllIIlllIlllIII.m22 * llllllllllllllllIIllIIlllIllIlll.m22;
            this.m00 = llllllllllllllllIIllIIlllIllIllI;
            this.m01 = llllllllllllllllIIllIIlllIllIlIl;
            this.m02 = llllllllllllllllIIllIIlllIllIlII;
            this.m10 = llllllllllllllllIIllIIlllIllIIll;
            this.m11 = llllllllllllllllIIllIIlllIllIIlI;
            this.m12 = llllllllllllllllIIllIIlllIllIIIl;
            this.m20 = llllllllllllllllIIllIIlllIllIIII;
            this.m21 = llllllllllllllllIIllIIlllIlIllll;
            this.m22 = llllllllllllllllIIllIIlllIlIlllI;
        }
    }
    
    public final void setM20(final float llllllllllllllllIIllIIlIllIlIlll) {
        this.m20 = llllllllllllllllIIllIIlIllIlIlll;
    }
    
    public final void setScale(final float llllllllllllllllIIllIllIIllIIlIl) {
        final double[] llllllllllllllllIIllIllIIllIIlII = new double[9];
        final double[] llllllllllllllllIIllIllIIllIIIll = new double[3];
        this.getScaleRotate(llllllllllllllllIIllIllIIllIIIll, llllllllllllllllIIllIllIIllIIlII);
        this.m00 = (float)(llllllllllllllllIIllIllIIllIIlII[0] * llllllllllllllllIIllIllIIllIIlIl);
        this.m01 = (float)(llllllllllllllllIIllIllIIllIIlII[1] * llllllllllllllllIIllIllIIllIIlIl);
        this.m02 = (float)(llllllllllllllllIIllIllIIllIIlII[2] * llllllllllllllllIIllIllIIllIIlIl);
        this.m10 = (float)(llllllllllllllllIIllIllIIllIIlII[3] * llllllllllllllllIIllIllIIllIIlIl);
        this.m11 = (float)(llllllllllllllllIIllIllIIllIIlII[4] * llllllllllllllllIIllIllIIllIIlIl);
        this.m12 = (float)(llllllllllllllllIIllIllIIllIIlII[5] * llllllllllllllllIIllIllIIllIIlIl);
        this.m20 = (float)(llllllllllllllllIIllIllIIllIIlII[6] * llllllllllllllllIIllIllIIllIIlIl);
        this.m21 = (float)(llllllllllllllllIIllIllIIllIIlII[7] * llllllllllllllllIIllIllIIllIIlIl);
        this.m22 = (float)(llllllllllllllllIIllIllIIllIIlII[8] * llllllllllllllllIIllIllIIllIIlIl);
    }
    
    public final void normalize(final Matrix3f llllllllllllllllIIllIIlllIIlIIlI) {
        final double[] llllllllllllllllIIllIIlllIIlIIIl = new double[9];
        final double[] llllllllllllllllIIllIIlllIIlIIII = new double[9];
        final double[] llllllllllllllllIIllIIlllIIIllll = new double[3];
        llllllllllllllllIIllIIlllIIlIIIl[0] = llllllllllllllllIIllIIlllIIlIIlI.m00;
        llllllllllllllllIIllIIlllIIlIIIl[1] = llllllllllllllllIIllIIlllIIlIIlI.m01;
        llllllllllllllllIIllIIlllIIlIIIl[2] = llllllllllllllllIIllIIlllIIlIIlI.m02;
        llllllllllllllllIIllIIlllIIlIIIl[3] = llllllllllllllllIIllIIlllIIlIIlI.m10;
        llllllllllllllllIIllIIlllIIlIIIl[4] = llllllllllllllllIIllIIlllIIlIIlI.m11;
        llllllllllllllllIIllIIlllIIlIIIl[5] = llllllllllllllllIIllIIlllIIlIIlI.m12;
        llllllllllllllllIIllIIlllIIlIIIl[6] = llllllllllllllllIIllIIlllIIlIIlI.m20;
        llllllllllllllllIIllIIlllIIlIIIl[7] = llllllllllllllllIIllIIlllIIlIIlI.m21;
        llllllllllllllllIIllIIlllIIlIIIl[8] = llllllllllllllllIIllIIlllIIlIIlI.m22;
        Matrix3d.compute_svd(llllllllllllllllIIllIIlllIIlIIIl, llllllllllllllllIIllIIlllIIIllll, llllllllllllllllIIllIIlllIIlIIII);
        this.m00 = (float)llllllllllllllllIIllIIlllIIlIIII[0];
        this.m01 = (float)llllllllllllllllIIllIIlllIIlIIII[1];
        this.m02 = (float)llllllllllllllllIIllIIlllIIlIIII[2];
        this.m10 = (float)llllllllllllllllIIllIIlllIIlIIII[3];
        this.m11 = (float)llllllllllllllllIIllIIlllIIlIIII[4];
        this.m12 = (float)llllllllllllllllIIllIIlllIIlIIII[5];
        this.m20 = (float)llllllllllllllllIIllIIlllIIlIIII[6];
        this.m21 = (float)llllllllllllllllIIllIIlllIIlIIII[7];
        this.m22 = (float)llllllllllllllllIIllIIlllIIlIIII[8];
    }
    
    public final void rotZ(final float llllllllllllllllIIllIlIIlIIIlIIl) {
        final float llllllllllllllllIIllIlIIlIIIlIII = (float)Math.sin(llllllllllllllllIIllIlIIlIIIlIIl);
        final float llllllllllllllllIIllIlIIlIIIIlll = (float)Math.cos(llllllllllllllllIIllIlIIlIIIlIIl);
        this.m00 = llllllllllllllllIIllIlIIlIIIIlll;
        this.m01 = -llllllllllllllllIIllIlIIlIIIlIII;
        this.m02 = 0.0f;
        this.m10 = llllllllllllllllIIllIlIIlIIIlIII;
        this.m11 = llllllllllllllllIIllIlIIlIIIIlll;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
    }
    
    public final void setRow(final int llllllllllllllllIIllIllIIIIIIllI, final float[] llllllllllllllllIIllIllIIIIIlIII) {
        switch (llllllllllllllllIIllIllIIIIIIllI) {
            case 0: {
                this.m00 = llllllllllllllllIIllIllIIIIIlIII[0];
                this.m01 = llllllllllllllllIIllIllIIIIIlIII[1];
                this.m02 = llllllllllllllllIIllIllIIIIIlIII[2];
                break;
            }
            case 1: {
                this.m10 = llllllllllllllllIIllIllIIIIIlIII[0];
                this.m11 = llllllllllllllllIIllIllIIIIIlIII[1];
                this.m12 = llllllllllllllllIIllIllIIIIIlIII[2];
                break;
            }
            case 2: {
                this.m20 = llllllllllllllllIIllIllIIIIIlIII[0];
                this.m21 = llllllllllllllllIIllIllIIIIIlIII[1];
                this.m22 = llllllllllllllllIIllIllIIIIIlIII[2];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f6"));
            }
        }
    }
    
    void getScaleRotate(final double[] llllllllllllllllIIllIIllIIlIIlIl, final double[] llllllllllllllllIIllIIllIIlIIlII) {
        final double[] llllllllllllllllIIllIIllIIlIIIll = { this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22 };
        Matrix3d.compute_svd(llllllllllllllllIIllIIllIIlIIIll, llllllllllllllllIIllIIllIIlIIlIl, llllllllllllllllIIllIIllIIlIIlII);
    }
    
    public final void setColumn(final int llllllllllllllllIIllIlIllllIlIII, final float[] llllllllllllllllIIllIlIllllIIlII) {
        switch (llllllllllllllllIIllIlIllllIlIII) {
            case 0: {
                this.m00 = llllllllllllllllIIllIlIllllIIlII[0];
                this.m10 = llllllllllllllllIIllIlIllllIIlII[1];
                this.m20 = llllllllllllllllIIllIlIllllIIlII[2];
                break;
            }
            case 1: {
                this.m01 = llllllllllllllllIIllIlIllllIIlII[0];
                this.m11 = llllllllllllllllIIllIlIllllIIlII[1];
                this.m21 = llllllllllllllllIIllIlIllllIIlII[2];
                break;
            }
            case 2: {
                this.m02 = llllllllllllllllIIllIlIllllIIlII[0];
                this.m12 = llllllllllllllllIIllIlIllllIIlII[1];
                this.m22 = llllllllllllllllIIllIlIllllIIlII[2];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f9"));
            }
        }
    }
    
    public final void sub(final Matrix3f llllllllllllllllIIllIlIllIlllIII, final Matrix3f llllllllllllllllIIllIlIllIllIlll) {
        this.m00 = llllllllllllllllIIllIlIllIlllIII.m00 - llllllllllllllllIIllIlIllIllIlll.m00;
        this.m01 = llllllllllllllllIIllIlIllIlllIII.m01 - llllllllllllllllIIllIlIllIllIlll.m01;
        this.m02 = llllllllllllllllIIllIlIllIlllIII.m02 - llllllllllllllllIIllIlIllIllIlll.m02;
        this.m10 = llllllllllllllllIIllIlIllIlllIII.m10 - llllllllllllllllIIllIlIllIllIlll.m10;
        this.m11 = llllllllllllllllIIllIlIllIlllIII.m11 - llllllllllllllllIIllIlIllIllIlll.m11;
        this.m12 = llllllllllllllllIIllIlIllIlllIII.m12 - llllllllllllllllIIllIlIllIllIlll.m12;
        this.m20 = llllllllllllllllIIllIlIllIlllIII.m20 - llllllllllllllllIIllIlIllIllIlll.m20;
        this.m21 = llllllllllllllllIIllIlIllIlllIII.m21 - llllllllllllllllIIllIlIllIllIlll.m21;
        this.m22 = llllllllllllllllIIllIlIllIlllIII.m22 - llllllllllllllllIIllIlIllIllIlll.m22;
    }
    
    public Matrix3f(final Matrix3f llllllllllllllllIIllIllIIlllIllI) {
        this.m00 = llllllllllllllllIIllIllIIlllIllI.m00;
        this.m01 = llllllllllllllllIIllIllIIlllIllI.m01;
        this.m02 = llllllllllllllllIIllIllIIlllIllI.m02;
        this.m10 = llllllllllllllllIIllIllIIlllIllI.m10;
        this.m11 = llllllllllllllllIIllIllIIlllIllI.m11;
        this.m12 = llllllllllllllllIIllIllIIlllIllI.m12;
        this.m20 = llllllllllllllllIIllIllIIlllIllI.m20;
        this.m21 = llllllllllllllllIIllIllIIlllIllI.m21;
        this.m22 = llllllllllllllllIIllIllIIlllIllI.m22;
    }
    
    public final void getRow(final int llllllllllllllllIIllIllIIlIIIIlI, final float[] llllllllllllllllIIllIllIIlIIIlII) {
        if (llllllllllllllllIIllIllIIlIIIIlI == 0) {
            llllllllllllllllIIllIllIIlIIIlII[0] = this.m00;
            llllllllllllllllIIllIllIIlIIIlII[1] = this.m01;
            llllllllllllllllIIllIllIIlIIIlII[2] = this.m02;
        }
        else if (llllllllllllllllIIllIllIIlIIIIlI == 1) {
            llllllllllllllllIIllIllIIlIIIlII[0] = this.m10;
            llllllllllllllllIIllIllIIlIIIlII[1] = this.m11;
            llllllllllllllllIIllIllIIlIIIlII[2] = this.m12;
        }
        else {
            if (llllllllllllllllIIllIllIIlIIIIlI != 2) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f1"));
            }
            llllllllllllllllIIllIllIIlIIIlII[0] = this.m20;
            llllllllllllllllIIllIllIIlIIIlII[1] = this.m21;
            llllllllllllllllIIllIllIIlIIIlII[2] = this.m22;
        }
    }
    
    public Object clone() {
        Matrix3f llllllllllllllllIIllIIllIIIllIlI = null;
        try {
            llllllllllllllllIIllIIllIIIllIlI = (Matrix3f)super.clone();
        }
        catch (CloneNotSupportedException llllllllllllllllIIllIIllIIIllIIl) {
            throw new InternalError();
        }
        return llllllllllllllllIIllIIllIIIllIlI;
    }
    
    public final void setM02(final float llllllllllllllllIIllIIlIlllllIll) {
        this.m02 = llllllllllllllllIIllIIlIlllllIll;
    }
    
    public final void sub(final Matrix3f llllllllllllllllIIllIlIllIlIlllI) {
        this.m00 -= llllllllllllllllIIllIlIllIlIlllI.m00;
        this.m01 -= llllllllllllllllIIllIlIllIlIlllI.m01;
        this.m02 -= llllllllllllllllIIllIlIllIlIlllI.m02;
        this.m10 -= llllllllllllllllIIllIlIllIlIlllI.m10;
        this.m11 -= llllllllllllllllIIllIlIllIlIlllI.m11;
        this.m12 -= llllllllllllllllIIllIlIllIlIlllI.m12;
        this.m20 -= llllllllllllllllIIllIlIllIlIlllI.m20;
        this.m21 -= llllllllllllllllIIllIlIllIlIlllI.m21;
        this.m22 -= llllllllllllllllIIllIlIllIlIlllI.m22;
    }
    
    public final float getM12() {
        return this.m12;
    }
    
    public boolean equals(final Matrix3f llllllllllllllllIIllIIllIlllIllI) {
        try {
            return this.m00 == llllllllllllllllIIllIIllIlllIllI.m00 && this.m01 == llllllllllllllllIIllIIllIlllIllI.m01 && this.m02 == llllllllllllllllIIllIIllIlllIllI.m02 && this.m10 == llllllllllllllllIIllIIllIlllIllI.m10 && this.m11 == llllllllllllllllIIllIIllIlllIllI.m11 && this.m12 == llllllllllllllllIIllIIllIlllIllI.m12 && this.m20 == llllllllllllllllIIllIIllIlllIllI.m20 && this.m21 == llllllllllllllllIIllIIllIlllIllI.m21 && this.m22 == llllllllllllllllIIllIIllIlllIllI.m22;
        }
        catch (NullPointerException llllllllllllllllIIllIIllIlllIlIl) {
            return false;
        }
    }
    
    public final void set(final AxisAngle4d llllllllllllllllIIllIlIlIlIlllIl) {
        double llllllllllllllllIIllIlIlIllIlIIl = Math.sqrt(llllllllllllllllIIllIlIlIlIlllIl.x * llllllllllllllllIIllIlIlIlIlllIl.x + llllllllllllllllIIllIlIlIlIlllIl.y * llllllllllllllllIIllIlIlIlIlllIl.y + llllllllllllllllIIllIlIlIlIlllIl.z * llllllllllllllllIIllIlIlIlIlllIl.z);
        if (llllllllllllllllIIllIlIlIllIlIIl < 1.0E-8) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            this.m20 = 0.0f;
            this.m21 = 0.0f;
            this.m22 = 1.0f;
        }
        else {
            llllllllllllllllIIllIlIlIllIlIIl = 1.0 / llllllllllllllllIIllIlIlIllIlIIl;
            final double llllllllllllllllIIllIlIlIllIlIII = llllllllllllllllIIllIlIlIlIlllIl.x * llllllllllllllllIIllIlIlIllIlIIl;
            final double llllllllllllllllIIllIlIlIllIIlll = llllllllllllllllIIllIlIlIlIlllIl.y * llllllllllllllllIIllIlIlIllIlIIl;
            final double llllllllllllllllIIllIlIlIllIIllI = llllllllllllllllIIllIlIlIlIlllIl.z * llllllllllllllllIIllIlIlIllIlIIl;
            final double llllllllllllllllIIllIlIlIllIIlIl = Math.sin(llllllllllllllllIIllIlIlIlIlllIl.angle);
            final double llllllllllllllllIIllIlIlIllIIlII = Math.cos(llllllllllllllllIIllIlIlIlIlllIl.angle);
            final double llllllllllllllllIIllIlIlIllIIIll = 1.0 - llllllllllllllllIIllIlIlIllIIlII;
            final double llllllllllllllllIIllIlIlIllIIIlI = llllllllllllllllIIllIlIlIllIlIII * llllllllllllllllIIllIlIlIllIIllI;
            final double llllllllllllllllIIllIlIlIllIIIIl = llllllllllllllllIIllIlIlIllIlIII * llllllllllllllllIIllIlIlIllIIlll;
            final double llllllllllllllllIIllIlIlIllIIIII = llllllllllllllllIIllIlIlIllIIlll * llllllllllllllllIIllIlIlIllIIllI;
            this.m00 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIlIII * llllllllllllllllIIllIlIlIllIlIII + llllllllllllllllIIllIlIlIllIIlII);
            this.m01 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIIIIl - llllllllllllllllIIllIlIlIllIIlIl * llllllllllllllllIIllIlIlIllIIllI);
            this.m02 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIIIlI + llllllllllllllllIIllIlIlIllIIlIl * llllllllllllllllIIllIlIlIllIIlll);
            this.m10 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIIIIl + llllllllllllllllIIllIlIlIllIIlIl * llllllllllllllllIIllIlIlIllIIllI);
            this.m11 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIIlll * llllllllllllllllIIllIlIlIllIIlll + llllllllllllllllIIllIlIlIllIIlII);
            this.m12 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIIIII - llllllllllllllllIIllIlIlIllIIlIl * llllllllllllllllIIllIlIlIllIlIII);
            this.m20 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIIIlI - llllllllllllllllIIllIlIlIllIIlIl * llllllllllllllllIIllIlIlIllIIlll);
            this.m21 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIIIII + llllllllllllllllIIllIlIlIllIIlIl * llllllllllllllllIIllIlIlIllIlIII);
            this.m22 = (float)(llllllllllllllllIIllIlIlIllIIIll * llllllllllllllllIIllIlIlIllIIllI * llllllllllllllllIIllIlIlIllIIllI + llllllllllllllllIIllIlIlIllIIlII);
        }
    }
    
    public final void setColumn(final int llllllllllllllllIIllIlIllllIlllI, final Vector3f llllllllllllllllIIllIlIllllIllIl) {
        switch (llllllllllllllllIIllIlIllllIlllI) {
            case 0: {
                this.m00 = llllllllllllllllIIllIlIllllIllIl.x;
                this.m10 = llllllllllllllllIIllIlIllllIllIl.y;
                this.m20 = llllllllllllllllIIllIlIllllIllIl.z;
                break;
            }
            case 1: {
                this.m01 = llllllllllllllllIIllIlIllllIllIl.x;
                this.m11 = llllllllllllllllIIllIlIllllIllIl.y;
                this.m21 = llllllllllllllllIIllIlIllllIllIl.z;
                break;
            }
            case 2: {
                this.m02 = llllllllllllllllIIllIlIllllIllIl.x;
                this.m12 = llllllllllllllllIIllIlIllllIllIl.y;
                this.m22 = llllllllllllllllIIllIlIllllIllIl.z;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f9"));
            }
        }
    }
    
    public final void normalizeCP() {
        float llllllllllllllllIIllIIlllIIIIllI = 1.0f / (float)Math.sqrt(this.m00 * this.m00 + this.m10 * this.m10 + this.m20 * this.m20);
        this.m00 *= llllllllllllllllIIllIIlllIIIIllI;
        this.m10 *= llllllllllllllllIIllIIlllIIIIllI;
        this.m20 *= llllllllllllllllIIllIIlllIIIIllI;
        llllllllllllllllIIllIIlllIIIIllI = 1.0f / (float)Math.sqrt(this.m01 * this.m01 + this.m11 * this.m11 + this.m21 * this.m21);
        this.m01 *= llllllllllllllllIIllIIlllIIIIllI;
        this.m11 *= llllllllllllllllIIllIIlllIIIIllI;
        this.m21 *= llllllllllllllllIIllIIlllIIIIllI;
        this.m02 = this.m10 * this.m21 - this.m11 * this.m20;
        this.m12 = this.m01 * this.m20 - this.m00 * this.m21;
        this.m22 = this.m00 * this.m11 - this.m01 * this.m10;
    }
    
    private final void invertGeneral(final Matrix3f llllllllllllllllIIllIlIlIIIlllll) {
        final double[] llllllllllllllllIIllIlIlIIlIIlIl = new double[9];
        final double[] llllllllllllllllIIllIlIlIIlIIIll = new double[9];
        final int[] llllllllllllllllIIllIlIlIIlIIIlI = new int[3];
        llllllllllllllllIIllIlIlIIlIIlIl[0] = llllllllllllllllIIllIlIlIIIlllll.m00;
        llllllllllllllllIIllIlIlIIlIIlIl[1] = llllllllllllllllIIllIlIlIIIlllll.m01;
        llllllllllllllllIIllIlIlIIlIIlIl[2] = llllllllllllllllIIllIlIlIIIlllll.m02;
        llllllllllllllllIIllIlIlIIlIIlIl[3] = llllllllllllllllIIllIlIlIIIlllll.m10;
        llllllllllllllllIIllIlIlIIlIIlIl[4] = llllllllllllllllIIllIlIlIIIlllll.m11;
        llllllllllllllllIIllIlIlIIlIIlIl[5] = llllllllllllllllIIllIlIlIIIlllll.m12;
        llllllllllllllllIIllIlIlIIlIIlIl[6] = llllllllllllllllIIllIlIlIIIlllll.m20;
        llllllllllllllllIIllIlIlIIlIIlIl[7] = llllllllllllllllIIllIlIlIIIlllll.m21;
        llllllllllllllllIIllIlIlIIlIIlIl[8] = llllllllllllllllIIllIlIlIIIlllll.m22;
        if (!luDecomposition(llllllllllllllllIIllIlIlIIlIIlIl, llllllllllllllllIIllIlIlIIlIIIlI)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix3f12"));
        }
        for (int llllllllllllllllIIllIlIlIIlIIIIl = 0; llllllllllllllllIIllIlIlIIlIIIIl < 9; ++llllllllllllllllIIllIlIlIIlIIIIl) {
            llllllllllllllllIIllIlIlIIlIIIll[llllllllllllllllIIllIlIlIIlIIIIl] = 0.0;
        }
        llllllllllllllllIIllIlIlIIlIIIll[0] = 1.0;
        llllllllllllllllIIllIlIlIIlIIIll[8] = (llllllllllllllllIIllIlIlIIlIIIll[4] = 1.0);
        luBacksubstitution(llllllllllllllllIIllIlIlIIlIIlIl, llllllllllllllllIIllIlIlIIlIIIlI, llllllllllllllllIIllIlIlIIlIIIll);
        this.m00 = (float)llllllllllllllllIIllIlIlIIlIIIll[0];
        this.m01 = (float)llllllllllllllllIIllIlIlIIlIIIll[1];
        this.m02 = (float)llllllllllllllllIIllIlIlIIlIIIll[2];
        this.m10 = (float)llllllllllllllllIIllIlIlIIlIIIll[3];
        this.m11 = (float)llllllllllllllllIIllIlIlIIlIIIll[4];
        this.m12 = (float)llllllllllllllllIIllIlIlIIlIIIll[5];
        this.m20 = (float)llllllllllllllllIIllIlIlIIlIIIll[6];
        this.m21 = (float)llllllllllllllllIIllIlIlIIlIIIll[7];
        this.m22 = (float)llllllllllllllllIIllIlIlIIlIIIll[8];
    }
    
    public Matrix3f(final float llllllllllllllllIIllIllIlIIllIII, final float llllllllllllllllIIllIllIlIIlIlll, final float llllllllllllllllIIllIllIlIIlIllI, final float llllllllllllllllIIllIllIlIIIlIll, final float llllllllllllllllIIllIllIlIIlIlII, final float llllllllllllllllIIllIllIlIIlIIll, final float llllllllllllllllIIllIllIlIIlIIlI, final float llllllllllllllllIIllIllIlIIIIlll, final float llllllllllllllllIIllIllIlIIIIllI) {
        this.m00 = llllllllllllllllIIllIllIlIIllIII;
        this.m01 = llllllllllllllllIIllIllIlIIlIlll;
        this.m02 = llllllllllllllllIIllIllIlIIlIllI;
        this.m10 = llllllllllllllllIIllIllIlIIIlIll;
        this.m11 = llllllllllllllllIIllIllIlIIlIlII;
        this.m12 = llllllllllllllllIIllIllIlIIlIIll;
        this.m20 = llllllllllllllllIIllIllIlIIlIIlI;
        this.m21 = llllllllllllllllIIllIllIlIIIIlll;
        this.m22 = llllllllllllllllIIllIllIlIIIIllI;
    }
    
    public final float getElement(final int llllllllllllllllIIllIllIIIlIIlll, final int llllllllllllllllIIllIllIIIlIIllI) {
        Label_0162: {
            switch (llllllllllllllllIIllIllIIIlIIlll) {
                case 0: {
                    switch (llllllllllllllllIIllIllIIIlIIllI) {
                        case 0: {
                            return this.m00;
                        }
                        case 1: {
                            return this.m01;
                        }
                        case 2: {
                            return this.m02;
                        }
                        default: {
                            break Label_0162;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (llllllllllllllllIIllIllIIIlIIllI) {
                        case 0: {
                            return this.m10;
                        }
                        case 1: {
                            return this.m11;
                        }
                        case 2: {
                            return this.m12;
                        }
                        default: {
                            break Label_0162;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (llllllllllllllllIIllIllIIIlIIllI) {
                        case 0: {
                            return this.m20;
                        }
                        case 1: {
                            return this.m21;
                        }
                        case 2: {
                            return this.m22;
                        }
                        default: {
                            break Label_0162;
                        }
                    }
                    break;
                }
            }
        }
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f5"));
    }
    
    public final void set(final Quat4f llllllllllllllllIIllIlIllIIlllII) {
        this.m00 = 1.0f - 2.0f * llllllllllllllllIIllIlIllIIlllII.y * llllllllllllllllIIllIlIllIIlllII.y - 2.0f * llllllllllllllllIIllIlIllIIlllII.z * llllllllllllllllIIllIlIllIIlllII.z;
        this.m10 = 2.0f * (llllllllllllllllIIllIlIllIIlllII.x * llllllllllllllllIIllIlIllIIlllII.y + llllllllllllllllIIllIlIllIIlllII.w * llllllllllllllllIIllIlIllIIlllII.z);
        this.m20 = 2.0f * (llllllllllllllllIIllIlIllIIlllII.x * llllllllllllllllIIllIlIllIIlllII.z - llllllllllllllllIIllIlIllIIlllII.w * llllllllllllllllIIllIlIllIIlllII.y);
        this.m01 = 2.0f * (llllllllllllllllIIllIlIllIIlllII.x * llllllllllllllllIIllIlIllIIlllII.y - llllllllllllllllIIllIlIllIIlllII.w * llllllllllllllllIIllIlIllIIlllII.z);
        this.m11 = 1.0f - 2.0f * llllllllllllllllIIllIlIllIIlllII.x * llllllllllllllllIIllIlIllIIlllII.x - 2.0f * llllllllllllllllIIllIlIllIIlllII.z * llllllllllllllllIIllIlIllIIlllII.z;
        this.m21 = 2.0f * (llllllllllllllllIIllIlIllIIlllII.y * llllllllllllllllIIllIlIllIIlllII.z + llllllllllllllllIIllIlIllIIlllII.w * llllllllllllllllIIllIlIllIIlllII.x);
        this.m02 = 2.0f * (llllllllllllllllIIllIlIllIIlllII.x * llllllllllllllllIIllIlIllIIlllII.z + llllllllllllllllIIllIlIllIIlllII.w * llllllllllllllllIIllIlIllIIlllII.y);
        this.m12 = 2.0f * (llllllllllllllllIIllIlIllIIlllII.y * llllllllllllllllIIllIlIllIIlllII.z - llllllllllllllllIIllIlIllIIlllII.w * llllllllllllllllIIllIlIllIIlllII.x);
        this.m22 = 1.0f - 2.0f * llllllllllllllllIIllIlIllIIlllII.x * llllllllllllllllIIllIlIllIIlllII.x - 2.0f * llllllllllllllllIIllIlIllIIlllII.y * llllllllllllllllIIllIlIllIIlllII.y;
    }
    
    public final void setElement(final int llllllllllllllllIIllIllIIlIllIIl, final int llllllllllllllllIIllIllIIlIlIlII, final float llllllllllllllllIIllIllIIlIlIlll) {
        Label_0236: {
            switch (llllllllllllllllIIllIllIIlIllIIl) {
                case 0: {
                    switch (llllllllllllllllIIllIllIIlIlIlII) {
                        case 0: {
                            this.m00 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        case 1: {
                            this.m01 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        case 2: {
                            this.m02 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f0"));
                        }
                    }
                    break;
                }
                case 1: {
                    switch (llllllllllllllllIIllIllIIlIlIlII) {
                        case 0: {
                            this.m10 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        case 1: {
                            this.m11 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        case 2: {
                            this.m12 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f0"));
                        }
                    }
                    break;
                }
                case 2: {
                    switch (llllllllllllllllIIllIllIIlIlIlII) {
                        case 0: {
                            this.m20 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        case 1: {
                            this.m21 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        case 2: {
                            this.m22 = llllllllllllllllIIllIllIIlIlIlll;
                            break Label_0236;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f0"));
                        }
                    }
                    break;
                }
                default: {
                    throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f0"));
                }
            }
        }
    }
    
    public final void setRow(final int llllllllllllllllIIllIllIIIIllIlI, final float llllllllllllllllIIllIllIIIIllllI, final float llllllllllllllllIIllIllIIIIlllIl, final float llllllllllllllllIIllIllIIIIlllII) {
        switch (llllllllllllllllIIllIllIIIIllIlI) {
            case 0: {
                this.m00 = llllllllllllllllIIllIllIIIIllllI;
                this.m01 = llllllllllllllllIIllIllIIIIlllIl;
                this.m02 = llllllllllllllllIIllIllIIIIlllII;
                break;
            }
            case 1: {
                this.m10 = llllllllllllllllIIllIllIIIIllllI;
                this.m11 = llllllllllllllllIIllIllIIIIlllIl;
                this.m12 = llllllllllllllllIIllIllIIIIlllII;
                break;
            }
            case 2: {
                this.m20 = llllllllllllllllIIllIllIIIIllllI;
                this.m21 = llllllllllllllllIIllIllIIIIlllIl;
                this.m22 = llllllllllllllllIIllIllIIIIlllII;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f6"));
            }
        }
    }
    
    public final float getM02() {
        return this.m02;
    }
    
    @Override
    public int hashCode() {
        long llllllllllllllllIIllIIllIlIlIlll = 1L;
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m00);
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m01);
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m02);
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m10);
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m11);
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m12);
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m20);
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m21);
        llllllllllllllllIIllIIllIlIlIlll = VecMathUtil.hashFloatBits(llllllllllllllllIIllIIllIlIlIlll, this.m22);
        return VecMathUtil.hashFinish(llllllllllllllllIIllIIllIlIlIlll);
    }
    
    public final void mul(final float llllllllllllllllIIllIlIIIllllIII, final Matrix3f llllllllllllllllIIllIlIIIlllIlII) {
        this.m00 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m00;
        this.m01 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m01;
        this.m02 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m02;
        this.m10 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m10;
        this.m11 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m11;
        this.m12 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m12;
        this.m20 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m20;
        this.m21 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m21;
        this.m22 = llllllllllllllllIIllIlIIIllllIII * llllllllllllllllIIllIlIIIlllIlII.m22;
    }
    
    public final void transpose() {
        float llllllllllllllllIIllIlIllIlIlIlI = this.m10;
        this.m10 = this.m01;
        this.m01 = llllllllllllllllIIllIlIllIlIlIlI;
        llllllllllllllllIIllIlIllIlIlIlI = this.m20;
        this.m20 = this.m02;
        this.m02 = llllllllllllllllIIllIlIllIlIlIlI;
        llllllllllllllllIIllIlIllIlIlIlI = this.m21;
        this.m21 = this.m12;
        this.m12 = llllllllllllllllIIllIlIllIlIlIlI;
    }
    
    public final void setRow(final int llllllllllllllllIIllIllIIIIlIIlI, final Vector3f llllllllllllllllIIllIllIIIIlIIIl) {
        switch (llllllllllllllllIIllIllIIIIlIIlI) {
            case 0: {
                this.m00 = llllllllllllllllIIllIllIIIIlIIIl.x;
                this.m01 = llllllllllllllllIIllIllIIIIlIIIl.y;
                this.m02 = llllllllllllllllIIllIllIIIIlIIIl.z;
                break;
            }
            case 1: {
                this.m10 = llllllllllllllllIIllIllIIIIlIIIl.x;
                this.m11 = llllllllllllllllIIllIllIIIIlIIIl.y;
                this.m12 = llllllllllllllllIIllIllIIIIlIIIl.z;
                break;
            }
            case 2: {
                this.m20 = llllllllllllllllIIllIllIIIIlIIIl.x;
                this.m21 = llllllllllllllllIIllIllIIIIlIIIl.y;
                this.m22 = llllllllllllllllIIllIllIIIIlIIIl.z;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f6"));
            }
        }
    }
    
    public final void add(final Matrix3f llllllllllllllllIIllIlIlllIIIlll, final Matrix3f llllllllllllllllIIllIlIlllIIIIll) {
        this.m00 = llllllllllllllllIIllIlIlllIIIlll.m00 + llllllllllllllllIIllIlIlllIIIIll.m00;
        this.m01 = llllllllllllllllIIllIlIlllIIIlll.m01 + llllllllllllllllIIllIlIlllIIIIll.m01;
        this.m02 = llllllllllllllllIIllIlIlllIIIlll.m02 + llllllllllllllllIIllIlIlllIIIIll.m02;
        this.m10 = llllllllllllllllIIllIlIlllIIIlll.m10 + llllllllllllllllIIllIlIlllIIIIll.m10;
        this.m11 = llllllllllllllllIIllIlIlllIIIlll.m11 + llllllllllllllllIIllIlIlllIIIIll.m11;
        this.m12 = llllllllllllllllIIllIlIlllIIIlll.m12 + llllllllllllllllIIllIlIlllIIIIll.m12;
        this.m20 = llllllllllllllllIIllIlIlllIIIlll.m20 + llllllllllllllllIIllIlIlllIIIIll.m20;
        this.m21 = llllllllllllllllIIllIlIlllIIIlll.m21 + llllllllllllllllIIllIlIlllIIIIll.m21;
        this.m22 = llllllllllllllllIIllIlIlllIIIlll.m22 + llllllllllllllllIIllIlIlllIIIIll.m22;
    }
    
    public final float getScale() {
        final double[] llllllllllllllllIIllIlIlllIlllll = new double[9];
        final double[] llllllllllllllllIIllIlIlllIllllI = new double[3];
        this.getScaleRotate(llllllllllllllllIIllIlIlllIllllI, llllllllllllllllIIllIlIlllIlllll);
        return (float)Matrix3d.max3(llllllllllllllllIIllIlIlllIllllI);
    }
    
    public final void normalize() {
        final double[] llllllllllllllllIIllIIlllIIlllIl = new double[9];
        final double[] llllllllllllllllIIllIIlllIIlllII = new double[3];
        this.getScaleRotate(llllllllllllllllIIllIIlllIIlllII, llllllllllllllllIIllIIlllIIlllIl);
        this.m00 = (float)llllllllllllllllIIllIIlllIIlllIl[0];
        this.m01 = (float)llllllllllllllllIIllIIlllIIlllIl[1];
        this.m02 = (float)llllllllllllllllIIllIIlllIIlllIl[2];
        this.m10 = (float)llllllllllllllllIIllIIlllIIlllIl[3];
        this.m11 = (float)llllllllllllllllIIllIIlllIIlllIl[4];
        this.m12 = (float)llllllllllllllllIIllIIlllIIlllIl[5];
        this.m20 = (float)llllllllllllllllIIllIIlllIIlllIl[6];
        this.m21 = (float)llllllllllllllllIIllIIlllIIlllIl[7];
        this.m22 = (float)llllllllllllllllIIllIIlllIIlllIl[8];
    }
    
    public final void mul(final Matrix3f llllllllllllllllIIllIlIIIlIIIlIl, final Matrix3f llllllllllllllllIIllIlIIIIlllIII) {
        if (this != llllllllllllllllIIllIlIIIlIIIlIl && this != llllllllllllllllIIllIlIIIIlllIII) {
            this.m00 = llllllllllllllllIIllIlIIIlIIIlIl.m00 * llllllllllllllllIIllIlIIIIlllIII.m00 + llllllllllllllllIIllIlIIIlIIIlIl.m01 * llllllllllllllllIIllIlIIIIlllIII.m10 + llllllllllllllllIIllIlIIIlIIIlIl.m02 * llllllllllllllllIIllIlIIIIlllIII.m20;
            this.m01 = llllllllllllllllIIllIlIIIlIIIlIl.m00 * llllllllllllllllIIllIlIIIIlllIII.m01 + llllllllllllllllIIllIlIIIlIIIlIl.m01 * llllllllllllllllIIllIlIIIIlllIII.m11 + llllllllllllllllIIllIlIIIlIIIlIl.m02 * llllllllllllllllIIllIlIIIIlllIII.m21;
            this.m02 = llllllllllllllllIIllIlIIIlIIIlIl.m00 * llllllllllllllllIIllIlIIIIlllIII.m02 + llllllllllllllllIIllIlIIIlIIIlIl.m01 * llllllllllllllllIIllIlIIIIlllIII.m12 + llllllllllllllllIIllIlIIIlIIIlIl.m02 * llllllllllllllllIIllIlIIIIlllIII.m22;
            this.m10 = llllllllllllllllIIllIlIIIlIIIlIl.m10 * llllllllllllllllIIllIlIIIIlllIII.m00 + llllllllllllllllIIllIlIIIlIIIlIl.m11 * llllllllllllllllIIllIlIIIIlllIII.m10 + llllllllllllllllIIllIlIIIlIIIlIl.m12 * llllllllllllllllIIllIlIIIIlllIII.m20;
            this.m11 = llllllllllllllllIIllIlIIIlIIIlIl.m10 * llllllllllllllllIIllIlIIIIlllIII.m01 + llllllllllllllllIIllIlIIIlIIIlIl.m11 * llllllllllllllllIIllIlIIIIlllIII.m11 + llllllllllllllllIIllIlIIIlIIIlIl.m12 * llllllllllllllllIIllIlIIIIlllIII.m21;
            this.m12 = llllllllllllllllIIllIlIIIlIIIlIl.m10 * llllllllllllllllIIllIlIIIIlllIII.m02 + llllllllllllllllIIllIlIIIlIIIlIl.m11 * llllllllllllllllIIllIlIIIIlllIII.m12 + llllllllllllllllIIllIlIIIlIIIlIl.m12 * llllllllllllllllIIllIlIIIIlllIII.m22;
            this.m20 = llllllllllllllllIIllIlIIIlIIIlIl.m20 * llllllllllllllllIIllIlIIIIlllIII.m00 + llllllllllllllllIIllIlIIIlIIIlIl.m21 * llllllllllllllllIIllIlIIIIlllIII.m10 + llllllllllllllllIIllIlIIIlIIIlIl.m22 * llllllllllllllllIIllIlIIIIlllIII.m20;
            this.m21 = llllllllllllllllIIllIlIIIlIIIlIl.m20 * llllllllllllllllIIllIlIIIIlllIII.m01 + llllllllllllllllIIllIlIIIlIIIlIl.m21 * llllllllllllllllIIllIlIIIIlllIII.m11 + llllllllllllllllIIllIlIIIlIIIlIl.m22 * llllllllllllllllIIllIlIIIIlllIII.m21;
            this.m22 = llllllllllllllllIIllIlIIIlIIIlIl.m20 * llllllllllllllllIIllIlIIIIlllIII.m02 + llllllllllllllllIIllIlIIIlIIIlIl.m21 * llllllllllllllllIIllIlIIIIlllIII.m12 + llllllllllllllllIIllIlIIIlIIIlIl.m22 * llllllllllllllllIIllIlIIIIlllIII.m22;
        }
        else {
            final float llllllllllllllllIIllIlIIIlIIIIll = llllllllllllllllIIllIlIIIlIIIlIl.m00 * llllllllllllllllIIllIlIIIIlllIII.m00 + llllllllllllllllIIllIlIIIlIIIlIl.m01 * llllllllllllllllIIllIlIIIIlllIII.m10 + llllllllllllllllIIllIlIIIlIIIlIl.m02 * llllllllllllllllIIllIlIIIIlllIII.m20;
            final float llllllllllllllllIIllIlIIIlIIIIlI = llllllllllllllllIIllIlIIIlIIIlIl.m00 * llllllllllllllllIIllIlIIIIlllIII.m01 + llllllllllllllllIIllIlIIIlIIIlIl.m01 * llllllllllllllllIIllIlIIIIlllIII.m11 + llllllllllllllllIIllIlIIIlIIIlIl.m02 * llllllllllllllllIIllIlIIIIlllIII.m21;
            final float llllllllllllllllIIllIlIIIlIIIIIl = llllllllllllllllIIllIlIIIlIIIlIl.m00 * llllllllllllllllIIllIlIIIIlllIII.m02 + llllllllllllllllIIllIlIIIlIIIlIl.m01 * llllllllllllllllIIllIlIIIIlllIII.m12 + llllllllllllllllIIllIlIIIlIIIlIl.m02 * llllllllllllllllIIllIlIIIIlllIII.m22;
            final float llllllllllllllllIIllIlIIIlIIIIII = llllllllllllllllIIllIlIIIlIIIlIl.m10 * llllllllllllllllIIllIlIIIIlllIII.m00 + llllllllllllllllIIllIlIIIlIIIlIl.m11 * llllllllllllllllIIllIlIIIIlllIII.m10 + llllllllllllllllIIllIlIIIlIIIlIl.m12 * llllllllllllllllIIllIlIIIIlllIII.m20;
            final float llllllllllllllllIIllIlIIIIllllll = llllllllllllllllIIllIlIIIlIIIlIl.m10 * llllllllllllllllIIllIlIIIIlllIII.m01 + llllllllllllllllIIllIlIIIlIIIlIl.m11 * llllllllllllllllIIllIlIIIIlllIII.m11 + llllllllllllllllIIllIlIIIlIIIlIl.m12 * llllllllllllllllIIllIlIIIIlllIII.m21;
            final float llllllllllllllllIIllIlIIIIlllllI = llllllllllllllllIIllIlIIIlIIIlIl.m10 * llllllllllllllllIIllIlIIIIlllIII.m02 + llllllllllllllllIIllIlIIIlIIIlIl.m11 * llllllllllllllllIIllIlIIIIlllIII.m12 + llllllllllllllllIIllIlIIIlIIIlIl.m12 * llllllllllllllllIIllIlIIIIlllIII.m22;
            final float llllllllllllllllIIllIlIIIIllllIl = llllllllllllllllIIllIlIIIlIIIlIl.m20 * llllllllllllllllIIllIlIIIIlllIII.m00 + llllllllllllllllIIllIlIIIlIIIlIl.m21 * llllllllllllllllIIllIlIIIIlllIII.m10 + llllllllllllllllIIllIlIIIlIIIlIl.m22 * llllllllllllllllIIllIlIIIIlllIII.m20;
            final float llllllllllllllllIIllIlIIIIllllII = llllllllllllllllIIllIlIIIlIIIlIl.m20 * llllllllllllllllIIllIlIIIIlllIII.m01 + llllllllllllllllIIllIlIIIlIIIlIl.m21 * llllllllllllllllIIllIlIIIIlllIII.m11 + llllllllllllllllIIllIlIIIlIIIlIl.m22 * llllllllllllllllIIllIlIIIIlllIII.m21;
            final float llllllllllllllllIIllIlIIIIlllIll = llllllllllllllllIIllIlIIIlIIIlIl.m20 * llllllllllllllllIIllIlIIIIlllIII.m02 + llllllllllllllllIIllIlIIIlIIIlIl.m21 * llllllllllllllllIIllIlIIIIlllIII.m12 + llllllllllllllllIIllIlIIIlIIIlIl.m22 * llllllllllllllllIIllIlIIIIlllIII.m22;
            this.m00 = llllllllllllllllIIllIlIIIlIIIIll;
            this.m01 = llllllllllllllllIIllIlIIIlIIIIlI;
            this.m02 = llllllllllllllllIIllIlIIIlIIIIIl;
            this.m10 = llllllllllllllllIIllIlIIIlIIIIII;
            this.m11 = llllllllllllllllIIllIlIIIIllllll;
            this.m12 = llllllllllllllllIIllIlIIIIlllllI;
            this.m20 = llllllllllllllllIIllIlIIIIllllIl;
            this.m21 = llllllllllllllllIIllIlIIIIllllII;
            this.m22 = llllllllllllllllIIllIlIIIIlllIll;
        }
    }
    
    public final void add(final Matrix3f llllllllllllllllIIllIlIllIllllll) {
        this.m00 += llllllllllllllllIIllIlIllIllllll.m00;
        this.m01 += llllllllllllllllIIllIlIllIllllll.m01;
        this.m02 += llllllllllllllllIIllIlIllIllllll.m02;
        this.m10 += llllllllllllllllIIllIlIllIllllll.m10;
        this.m11 += llllllllllllllllIIllIlIllIllllll.m11;
        this.m12 += llllllllllllllllIIllIlIllIllllll.m12;
        this.m20 += llllllllllllllllIIllIlIllIllllll.m20;
        this.m21 += llllllllllllllllIIllIlIllIllllll.m21;
        this.m22 += llllllllllllllllIIllIlIllIllllll.m22;
    }
    
    public final void transform(final Tuple3f llllllllllllllllIIllIIllIIllIIll, final Tuple3f llllllllllllllllIIllIIllIIllIIlI) {
        final float llllllllllllllllIIllIIllIIllIIIl = this.m00 * llllllllllllllllIIllIIllIIllIIll.x + this.m01 * llllllllllllllllIIllIIllIIllIIll.y + this.m02 * llllllllllllllllIIllIIllIIllIIll.z;
        final float llllllllllllllllIIllIIllIIllIIII = this.m10 * llllllllllllllllIIllIIllIIllIIll.x + this.m11 * llllllllllllllllIIllIIllIIllIIll.y + this.m12 * llllllllllllllllIIllIIllIIllIIll.z;
        llllllllllllllllIIllIIllIIllIIlI.z = this.m20 * llllllllllllllllIIllIIllIIllIIll.x + this.m21 * llllllllllllllllIIllIIllIIllIIll.y + this.m22 * llllllllllllllllIIllIIllIIllIIll.z;
        llllllllllllllllIIllIIllIIllIIlI.x = llllllllllllllllIIllIIllIIllIIIl;
        llllllllllllllllIIllIIllIIllIIlI.y = llllllllllllllllIIllIIllIIllIIII;
    }
    
    public final void mulNormalize(final Matrix3f llllllllllllllllIIllIlIIIIlIlIII) {
        final double[] llllllllllllllllIIllIlIIIIlIIlll = new double[9];
        final double[] llllllllllllllllIIllIlIIIIlIIllI = new double[9];
        final double[] llllllllllllllllIIllIlIIIIlIIlIl = new double[3];
        llllllllllllllllIIllIlIIIIlIIlll[0] = this.m00 * llllllllllllllllIIllIlIIIIlIlIII.m00 + this.m01 * llllllllllllllllIIllIlIIIIlIlIII.m10 + this.m02 * llllllllllllllllIIllIlIIIIlIlIII.m20;
        llllllllllllllllIIllIlIIIIlIIlll[1] = this.m00 * llllllllllllllllIIllIlIIIIlIlIII.m01 + this.m01 * llllllllllllllllIIllIlIIIIlIlIII.m11 + this.m02 * llllllllllllllllIIllIlIIIIlIlIII.m21;
        llllllllllllllllIIllIlIIIIlIIlll[2] = this.m00 * llllllllllllllllIIllIlIIIIlIlIII.m02 + this.m01 * llllllllllllllllIIllIlIIIIlIlIII.m12 + this.m02 * llllllllllllllllIIllIlIIIIlIlIII.m22;
        llllllllllllllllIIllIlIIIIlIIlll[3] = this.m10 * llllllllllllllllIIllIlIIIIlIlIII.m00 + this.m11 * llllllllllllllllIIllIlIIIIlIlIII.m10 + this.m12 * llllllllllllllllIIllIlIIIIlIlIII.m20;
        llllllllllllllllIIllIlIIIIlIIlll[4] = this.m10 * llllllllllllllllIIllIlIIIIlIlIII.m01 + this.m11 * llllllllllllllllIIllIlIIIIlIlIII.m11 + this.m12 * llllllllllllllllIIllIlIIIIlIlIII.m21;
        llllllllllllllllIIllIlIIIIlIIlll[5] = this.m10 * llllllllllllllllIIllIlIIIIlIlIII.m02 + this.m11 * llllllllllllllllIIllIlIIIIlIlIII.m12 + this.m12 * llllllllllllllllIIllIlIIIIlIlIII.m22;
        llllllllllllllllIIllIlIIIIlIIlll[6] = this.m20 * llllllllllllllllIIllIlIIIIlIlIII.m00 + this.m21 * llllllllllllllllIIllIlIIIIlIlIII.m10 + this.m22 * llllllllllllllllIIllIlIIIIlIlIII.m20;
        llllllllllllllllIIllIlIIIIlIIlll[7] = this.m20 * llllllllllllllllIIllIlIIIIlIlIII.m01 + this.m21 * llllllllllllllllIIllIlIIIIlIlIII.m11 + this.m22 * llllllllllllllllIIllIlIIIIlIlIII.m21;
        llllllllllllllllIIllIlIIIIlIIlll[8] = this.m20 * llllllllllllllllIIllIlIIIIlIlIII.m02 + this.m21 * llllllllllllllllIIllIlIIIIlIlIII.m12 + this.m22 * llllllllllllllllIIllIlIIIIlIlIII.m22;
        Matrix3d.compute_svd(llllllllllllllllIIllIlIIIIlIIlll, llllllllllllllllIIllIlIIIIlIIlIl, llllllllllllllllIIllIlIIIIlIIllI);
        this.m00 = (float)llllllllllllllllIIllIlIIIIlIIllI[0];
        this.m01 = (float)llllllllllllllllIIllIlIIIIlIIllI[1];
        this.m02 = (float)llllllllllllllllIIllIlIIIIlIIllI[2];
        this.m10 = (float)llllllllllllllllIIllIlIIIIlIIllI[3];
        this.m11 = (float)llllllllllllllllIIllIlIIIIlIIllI[4];
        this.m12 = (float)llllllllllllllllIIllIlIIIIlIIllI[5];
        this.m20 = (float)llllllllllllllllIIllIlIIIIlIIllI[6];
        this.m21 = (float)llllllllllllllllIIllIlIIIIlIIllI[7];
        this.m22 = (float)llllllllllllllllIIllIlIIIIlIIllI[8];
    }
    
    public final void add(final float llllllllllllllllIIllIlIlllIlIlll) {
        this.m00 += llllllllllllllllIIllIlIlllIlIlll;
        this.m01 += llllllllllllllllIIllIlIlllIlIlll;
        this.m02 += llllllllllllllllIIllIlIlllIlIlll;
        this.m10 += llllllllllllllllIIllIlIlllIlIlll;
        this.m11 += llllllllllllllllIIllIlIlllIlIlll;
        this.m12 += llllllllllllllllIIllIlIlllIlIlll;
        this.m20 += llllllllllllllllIIllIlIlllIlIlll;
        this.m21 += llllllllllllllllIIllIlIlllIlIlll;
        this.m22 += llllllllllllllllIIllIlIlllIlIlll;
    }
    
    public final float getM01() {
        return this.m01;
    }
    
    public final void mul(final Matrix3f llllllllllllllllIIllIlIIIlIlllII) {
        final float llllllllllllllllIIllIlIIIllIIllI = this.m00 * llllllllllllllllIIllIlIIIlIlllII.m00 + this.m01 * llllllllllllllllIIllIlIIIlIlllII.m10 + this.m02 * llllllllllllllllIIllIlIIIlIlllII.m20;
        final float llllllllllllllllIIllIlIIIllIIlIl = this.m00 * llllllllllllllllIIllIlIIIlIlllII.m01 + this.m01 * llllllllllllllllIIllIlIIIlIlllII.m11 + this.m02 * llllllllllllllllIIllIlIIIlIlllII.m21;
        final float llllllllllllllllIIllIlIIIllIIlII = this.m00 * llllllllllllllllIIllIlIIIlIlllII.m02 + this.m01 * llllllllllllllllIIllIlIIIlIlllII.m12 + this.m02 * llllllllllllllllIIllIlIIIlIlllII.m22;
        final float llllllllllllllllIIllIlIIIllIIIll = this.m10 * llllllllllllllllIIllIlIIIlIlllII.m00 + this.m11 * llllllllllllllllIIllIlIIIlIlllII.m10 + this.m12 * llllllllllllllllIIllIlIIIlIlllII.m20;
        final float llllllllllllllllIIllIlIIIllIIIlI = this.m10 * llllllllllllllllIIllIlIIIlIlllII.m01 + this.m11 * llllllllllllllllIIllIlIIIlIlllII.m11 + this.m12 * llllllllllllllllIIllIlIIIlIlllII.m21;
        final float llllllllllllllllIIllIlIIIllIIIIl = this.m10 * llllllllllllllllIIllIlIIIlIlllII.m02 + this.m11 * llllllllllllllllIIllIlIIIlIlllII.m12 + this.m12 * llllllllllllllllIIllIlIIIlIlllII.m22;
        final float llllllllllllllllIIllIlIIIllIIIII = this.m20 * llllllllllllllllIIllIlIIIlIlllII.m00 + this.m21 * llllllllllllllllIIllIlIIIlIlllII.m10 + this.m22 * llllllllllllllllIIllIlIIIlIlllII.m20;
        final float llllllllllllllllIIllIlIIIlIlllll = this.m20 * llllllllllllllllIIllIlIIIlIlllII.m01 + this.m21 * llllllllllllllllIIllIlIIIlIlllII.m11 + this.m22 * llllllllllllllllIIllIlIIIlIlllII.m21;
        final float llllllllllllllllIIllIlIIIlIllllI = this.m20 * llllllllllllllllIIllIlIIIlIlllII.m02 + this.m21 * llllllllllllllllIIllIlIIIlIlllII.m12 + this.m22 * llllllllllllllllIIllIlIIIlIlllII.m22;
        this.m00 = llllllllllllllllIIllIlIIIllIIllI;
        this.m01 = llllllllllllllllIIllIlIIIllIIlIl;
        this.m02 = llllllllllllllllIIllIlIIIllIIlII;
        this.m10 = llllllllllllllllIIllIlIIIllIIIll;
        this.m11 = llllllllllllllllIIllIlIIIllIIIlI;
        this.m12 = llllllllllllllllIIllIlIIIllIIIIl;
        this.m20 = llllllllllllllllIIllIlIIIllIIIII;
        this.m21 = llllllllllllllllIIllIlIIIlIlllll;
        this.m22 = llllllllllllllllIIllIlIIIlIllllI;
    }
    
    public final float determinant() {
        final float llllllllllllllllIIllIlIIlIlIllll = this.m00 * (this.m11 * this.m22 - this.m12 * this.m21) + this.m01 * (this.m12 * this.m20 - this.m10 * this.m22) + this.m02 * (this.m10 * this.m21 - this.m11 * this.m20);
        return llllllllllllllllIIllIlIIlIlIllll;
    }
    
    static boolean luDecomposition(final double[] llllllllllllllllIIllIlIlIIIIIlII, final int[] llllllllllllllllIIllIlIIlllIIlII) {
        final double[] llllllllllllllllIIllIlIlIIIIIIlI = new double[3];
        int llllllllllllllllIIllIlIIllllllll = 0;
        int llllllllllllllllIIllIlIIlllllllI = 0;
        int llllllllllllllllIIllIlIlIIIIIIIl = 3;
        while (llllllllllllllllIIllIlIlIIIIIIIl-- != 0) {
            double llllllllllllllllIIllIlIIllllllIl = 0.0;
            int llllllllllllllllIIllIlIlIIIIIIII = 3;
            while (llllllllllllllllIIllIlIlIIIIIIII-- != 0) {
                double llllllllllllllllIIllIlIIllllllII = llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIllllllll++];
                llllllllllllllllIIllIlIIllllllII = Math.abs(llllllllllllllllIIllIlIIllllllII);
                if (llllllllllllllllIIllIlIIllllllII > llllllllllllllllIIllIlIIllllllIl) {
                    llllllllllllllllIIllIlIIllllllIl = llllllllllllllllIIllIlIIllllllII;
                }
            }
            if (llllllllllllllllIIllIlIIllllllIl == 0.0) {
                return false;
            }
            llllllllllllllllIIllIlIlIIIIIIlI[llllllllllllllllIIllIlIIlllllllI++] = 1.0 / llllllllllllllllIIllIlIIllllllIl;
        }
        final int llllllllllllllllIIllIlIIlllllIlI = 0;
        for (int llllllllllllllllIIllIlIIlllllIll = 0; llllllllllllllllIIllIlIIlllllIll < 3; ++llllllllllllllllIIllIlIIlllllIll) {
            for (int llllllllllllllllIIllIlIIlllllIIl = 0; llllllllllllllllIIllIlIIlllllIIl < llllllllllllllllIIllIlIIlllllIll; ++llllllllllllllllIIllIlIIlllllIIl) {
                final int llllllllllllllllIIllIlIIllllIlII = llllllllllllllllIIllIlIIlllllIlI + 3 * llllllllllllllllIIllIlIIlllllIIl + llllllllllllllllIIllIlIIlllllIll;
                double llllllllllllllllIIllIlIIlllIlIll = llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIllllIlII];
                int llllllllllllllllIIllIlIIllllIlll = llllllllllllllllIIllIlIIlllllIIl;
                int llllllllllllllllIIllIlIIllllIIIl = llllllllllllllllIIllIlIIlllllIlI + 3 * llllllllllllllllIIllIlIIlllllIIl;
                int llllllllllllllllIIllIlIIlllIlllI = llllllllllllllllIIllIlIIlllllIlI + llllllllllllllllIIllIlIIlllllIll;
                while (llllllllllllllllIIllIlIIllllIlll-- != 0) {
                    llllllllllllllllIIllIlIIlllIlIll -= llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIllllIIIl] * llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIlllIlllI];
                    ++llllllllllllllllIIllIlIIllllIIIl;
                    llllllllllllllllIIllIlIIlllIlllI += 3;
                }
                llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIllllIlII] = llllllllllllllllIIllIlIIlllIlIll;
            }
            double llllllllllllllllIIllIlIIlllIlIIl = 0.0;
            int llllllllllllllllIIllIlIIlllllIII = -1;
            for (int llllllllllllllllIIllIlIIlllllIIl = llllllllllllllllIIllIlIIlllllIll; llllllllllllllllIIllIlIIlllllIIl < 3; ++llllllllllllllllIIllIlIIlllllIIl) {
                final int llllllllllllllllIIllIlIIllllIIll = llllllllllllllllIIllIlIIlllllIlI + 3 * llllllllllllllllIIllIlIIlllllIIl + llllllllllllllllIIllIlIIlllllIll;
                double llllllllllllllllIIllIlIIlllIlIlI = llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIllllIIll];
                int llllllllllllllllIIllIlIIllllIllI = llllllllllllllllIIllIlIIlllllIll;
                int llllllllllllllllIIllIlIIllllIIII = llllllllllllllllIIllIlIIlllllIlI + 3 * llllllllllllllllIIllIlIIlllllIIl;
                int llllllllllllllllIIllIlIIlllIllIl = llllllllllllllllIIllIlIIlllllIlI + llllllllllllllllIIllIlIIlllllIll;
                while (llllllllllllllllIIllIlIIllllIllI-- != 0) {
                    llllllllllllllllIIllIlIIlllIlIlI -= llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIllllIIII] * llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIlllIllIl];
                    ++llllllllllllllllIIllIlIIllllIIII;
                    llllllllllllllllIIllIlIIlllIllIl += 3;
                }
                llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIllllIIll] = llllllllllllllllIIllIlIIlllIlIlI;
                final double llllllllllllllllIIllIlIIlllIlIII;
                if ((llllllllllllllllIIllIlIIlllIlIII = llllllllllllllllIIllIlIlIIIIIIlI[llllllllllllllllIIllIlIIlllllIIl] * Math.abs(llllllllllllllllIIllIlIIlllIlIlI)) >= llllllllllllllllIIllIlIIlllIlIIl) {
                    llllllllllllllllIIllIlIIlllIlIIl = llllllllllllllllIIllIlIIlllIlIII;
                    llllllllllllllllIIllIlIIlllllIII = llllllllllllllllIIllIlIIlllllIIl;
                }
            }
            if (llllllllllllllllIIllIlIIlllllIII < 0) {
                throw new RuntimeException(VecMathI18N.getString("Matrix3f13"));
            }
            if (llllllllllllllllIIllIlIIlllllIll != llllllllllllllllIIllIlIIlllllIII) {
                int llllllllllllllllIIllIlIIllllIlIl = 3;
                int llllllllllllllllIIllIlIIlllIllll = llllllllllllllllIIllIlIIlllllIlI + 3 * llllllllllllllllIIllIlIIlllllIII;
                int llllllllllllllllIIllIlIIlllIllII = llllllllllllllllIIllIlIIlllllIlI + 3 * llllllllllllllllIIllIlIIlllllIll;
                while (llllllllllllllllIIllIlIIllllIlIl-- != 0) {
                    final double llllllllllllllllIIllIlIIlllIIlll = llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIlllIllll];
                    llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIlllIllll++] = llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIlllIllII];
                    llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIlllIllII++] = llllllllllllllllIIllIlIIlllIIlll;
                }
                llllllllllllllllIIllIlIlIIIIIIlI[llllllllllllllllIIllIlIIlllllIII] = llllllllllllllllIIllIlIlIIIIIIlI[llllllllllllllllIIllIlIIlllllIll];
            }
            llllllllllllllllIIllIlIIlllIIlII[llllllllllllllllIIllIlIIlllllIll] = llllllllllllllllIIllIlIIlllllIII;
            if (llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIlllllIlI + 3 * llllllllllllllllIIllIlIIlllllIll + llllllllllllllllIIllIlIIlllllIll] == 0.0) {
                return false;
            }
            if (llllllllllllllllIIllIlIIlllllIll != 2) {
                final double llllllllllllllllIIllIlIIlllIIllI = 1.0 / llllllllllllllllIIllIlIlIIIIIlII[llllllllllllllllIIllIlIIlllllIlI + 3 * llllllllllllllllIIllIlIIlllllIll + llllllllllllllllIIllIlIIlllllIll];
                int llllllllllllllllIIllIlIIllllIIlI = llllllllllllllllIIllIlIIlllllIlI + 3 * (llllllllllllllllIIllIlIIlllllIll + 1) + llllllllllllllllIIllIlIIlllllIll;
                int llllllllllllllllIIllIlIIlllllIIl = 2 - llllllllllllllllIIllIlIIlllllIll;
                while (llllllllllllllllIIllIlIIlllllIIl-- != 0) {
                    final int n = llllllllllllllllIIllIlIIllllIIlI;
                    llllllllllllllllIIllIlIlIIIIIlII[n] *= llllllllllllllllIIllIlIIlllIIllI;
                    llllllllllllllllIIllIlIIllllIIlI += 3;
                }
            }
        }
        return true;
    }
    
    public final void setM22(final float llllllllllllllllIIllIIlIllIIIlll) {
        this.m22 = llllllllllllllllIIllIIlIllIIIlll;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllllIIllIIllIllIllIl) {
        try {
            final Matrix3f llllllllllllllllIIllIIllIllIllII = (Matrix3f)llllllllllllllllIIllIIllIllIllIl;
            return this.m00 == llllllllllllllllIIllIIllIllIllII.m00 && this.m01 == llllllllllllllllIIllIIllIllIllII.m01 && this.m02 == llllllllllllllllIIllIIllIllIllII.m02 && this.m10 == llllllllllllllllIIllIIllIllIllII.m10 && this.m11 == llllllllllllllllIIllIIllIllIllII.m11 && this.m12 == llllllllllllllllIIllIIllIllIllII.m12 && this.m20 == llllllllllllllllIIllIIllIllIllII.m20 && this.m21 == llllllllllllllllIIllIIllIllIllII.m21 && this.m22 == llllllllllllllllIIllIIllIllIllII.m22;
        }
        catch (ClassCastException llllllllllllllllIIllIIllIllIlIll) {
            return false;
        }
        catch (NullPointerException llllllllllllllllIIllIIllIllIlIlI) {
            return false;
        }
    }
    
    public final void set(final Quat4d llllllllllllllllIIllIlIlIlIIlllI) {
        this.m00 = (float)(1.0 - 2.0 * llllllllllllllllIIllIlIlIlIIlllI.y * llllllllllllllllIIllIlIlIlIIlllI.y - 2.0 * llllllllllllllllIIllIlIlIlIIlllI.z * llllllllllllllllIIllIlIlIlIIlllI.z);
        this.m10 = (float)(2.0 * (llllllllllllllllIIllIlIlIlIIlllI.x * llllllllllllllllIIllIlIlIlIIlllI.y + llllllllllllllllIIllIlIlIlIIlllI.w * llllllllllllllllIIllIlIlIlIIlllI.z));
        this.m20 = (float)(2.0 * (llllllllllllllllIIllIlIlIlIIlllI.x * llllllllllllllllIIllIlIlIlIIlllI.z - llllllllllllllllIIllIlIlIlIIlllI.w * llllllllllllllllIIllIlIlIlIIlllI.y));
        this.m01 = (float)(2.0 * (llllllllllllllllIIllIlIlIlIIlllI.x * llllllllllllllllIIllIlIlIlIIlllI.y - llllllllllllllllIIllIlIlIlIIlllI.w * llllllllllllllllIIllIlIlIlIIlllI.z));
        this.m11 = (float)(1.0 - 2.0 * llllllllllllllllIIllIlIlIlIIlllI.x * llllllllllllllllIIllIlIlIlIIlllI.x - 2.0 * llllllllllllllllIIllIlIlIlIIlllI.z * llllllllllllllllIIllIlIlIlIIlllI.z);
        this.m21 = (float)(2.0 * (llllllllllllllllIIllIlIlIlIIlllI.y * llllllllllllllllIIllIlIlIlIIlllI.z + llllllllllllllllIIllIlIlIlIIlllI.w * llllllllllllllllIIllIlIlIlIIlllI.x));
        this.m02 = (float)(2.0 * (llllllllllllllllIIllIlIlIlIIlllI.x * llllllllllllllllIIllIlIlIlIIlllI.z + llllllllllllllllIIllIlIlIlIIlllI.w * llllllllllllllllIIllIlIlIlIIlllI.y));
        this.m12 = (float)(2.0 * (llllllllllllllllIIllIlIlIlIIlllI.y * llllllllllllllllIIllIlIlIlIIlllI.z - llllllllllllllllIIllIlIlIlIIlllI.w * llllllllllllllllIIllIlIlIlIIlllI.x));
        this.m22 = (float)(1.0 - 2.0 * llllllllllllllllIIllIlIlIlIIlllI.x * llllllllllllllllIIllIlIlIlIIlllI.x - 2.0 * llllllllllllllllIIllIlIlIlIIlllI.y * llllllllllllllllIIllIlIlIlIIlllI.y);
    }
    
    public final void invert() {
        this.invertGeneral(this);
    }
    
    public final void setM00(final float llllllllllllllllIIllIIllIIIIllll) {
        this.m00 = llllllllllllllllIIllIIllIIIIllll;
    }
    
    public final void setM12(final float llllllllllllllllIIllIIlIlllIIIII) {
        this.m12 = llllllllllllllllIIllIIlIlllIIIII;
    }
    
    public Matrix3f() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
    }
    
    public final float getM22() {
        return this.m22;
    }
    
    public final void set(final Matrix3f llllllllllllllllIIllIlIlIlIIIIlI) {
        this.m00 = llllllllllllllllIIllIlIlIlIIIIlI.m00;
        this.m01 = llllllllllllllllIIllIlIlIlIIIIlI.m01;
        this.m02 = llllllllllllllllIIllIlIlIlIIIIlI.m02;
        this.m10 = llllllllllllllllIIllIlIlIlIIIIlI.m10;
        this.m11 = llllllllllllllllIIllIlIlIlIIIIlI.m11;
        this.m12 = llllllllllllllllIIllIlIlIlIIIIlI.m12;
        this.m20 = llllllllllllllllIIllIlIlIlIIIIlI.m20;
        this.m21 = llllllllllllllllIIllIlIlIlIIIIlI.m21;
        this.m22 = llllllllllllllllIIllIlIlIlIIIIlI.m22;
    }
    
    public final void normalizeCP(final Matrix3f llllllllllllllllIIllIIllIlllllll) {
        float llllllllllllllllIIllIIllIllllllI = 1.0f / (float)Math.sqrt(llllllllllllllllIIllIIllIlllllll.m00 * llllllllllllllllIIllIIllIlllllll.m00 + llllllllllllllllIIllIIllIlllllll.m10 * llllllllllllllllIIllIIllIlllllll.m10 + llllllllllllllllIIllIIllIlllllll.m20 * llllllllllllllllIIllIIllIlllllll.m20);
        this.m00 = llllllllllllllllIIllIIllIlllllll.m00 * llllllllllllllllIIllIIllIllllllI;
        this.m10 = llllllllllllllllIIllIIllIlllllll.m10 * llllllllllllllllIIllIIllIllllllI;
        this.m20 = llllllllllllllllIIllIIllIlllllll.m20 * llllllllllllllllIIllIIllIllllllI;
        llllllllllllllllIIllIIllIllllllI = 1.0f / (float)Math.sqrt(llllllllllllllllIIllIIllIlllllll.m01 * llllllllllllllllIIllIIllIlllllll.m01 + llllllllllllllllIIllIIllIlllllll.m11 * llllllllllllllllIIllIIllIlllllll.m11 + llllllllllllllllIIllIIllIlllllll.m21 * llllllllllllllllIIllIIllIlllllll.m21);
        this.m01 = llllllllllllllllIIllIIllIlllllll.m01 * llllllllllllllllIIllIIllIllllllI;
        this.m11 = llllllllllllllllIIllIIllIlllllll.m11 * llllllllllllllllIIllIIllIllllllI;
        this.m21 = llllllllllllllllIIllIIllIlllllll.m21 * llllllllllllllllIIllIIllIllllllI;
        this.m02 = this.m10 * this.m21 - this.m11 * this.m20;
        this.m12 = this.m01 * this.m20 - this.m00 * this.m21;
        this.m22 = this.m00 * this.m11 - this.m01 * this.m10;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.m00)).append(", ").append(this.m01).append(", ").append(this.m02).append("\n").append(this.m10).append(", ").append(this.m11).append(", ").append(this.m12).append("\n").append(this.m20).append(", ").append(this.m21).append(", ").append(this.m22).append("\n"));
    }
    
    public final void setM21(final float llllllllllllllllIIllIIlIllIlIIII) {
        this.m21 = llllllllllllllllIIllIIlIllIlIIII;
    }
    
    public final void mulTransposeBoth(final Matrix3f llllllllllllllllIIllIIllllllIlII, final Matrix3f llllllllllllllllIIllIIllllllllll) {
        if (this != llllllllllllllllIIllIIllllllIlII && this != llllllllllllllllIIllIIllllllllll) {
            this.m00 = llllllllllllllllIIllIIllllllIlII.m00 * llllllllllllllllIIllIIllllllllll.m00 + llllllllllllllllIIllIIllllllIlII.m10 * llllllllllllllllIIllIIllllllllll.m01 + llllllllllllllllIIllIIllllllIlII.m20 * llllllllllllllllIIllIIllllllllll.m02;
            this.m01 = llllllllllllllllIIllIIllllllIlII.m00 * llllllllllllllllIIllIIllllllllll.m10 + llllllllllllllllIIllIIllllllIlII.m10 * llllllllllllllllIIllIIllllllllll.m11 + llllllllllllllllIIllIIllllllIlII.m20 * llllllllllllllllIIllIIllllllllll.m12;
            this.m02 = llllllllllllllllIIllIIllllllIlII.m00 * llllllllllllllllIIllIIllllllllll.m20 + llllllllllllllllIIllIIllllllIlII.m10 * llllllllllllllllIIllIIllllllllll.m21 + llllllllllllllllIIllIIllllllIlII.m20 * llllllllllllllllIIllIIllllllllll.m22;
            this.m10 = llllllllllllllllIIllIIllllllIlII.m01 * llllllllllllllllIIllIIllllllllll.m00 + llllllllllllllllIIllIIllllllIlII.m11 * llllllllllllllllIIllIIllllllllll.m01 + llllllllllllllllIIllIIllllllIlII.m21 * llllllllllllllllIIllIIllllllllll.m02;
            this.m11 = llllllllllllllllIIllIIllllllIlII.m01 * llllllllllllllllIIllIIllllllllll.m10 + llllllllllllllllIIllIIllllllIlII.m11 * llllllllllllllllIIllIIllllllllll.m11 + llllllllllllllllIIllIIllllllIlII.m21 * llllllllllllllllIIllIIllllllllll.m12;
            this.m12 = llllllllllllllllIIllIIllllllIlII.m01 * llllllllllllllllIIllIIllllllllll.m20 + llllllllllllllllIIllIIllllllIlII.m11 * llllllllllllllllIIllIIllllllllll.m21 + llllllllllllllllIIllIIllllllIlII.m21 * llllllllllllllllIIllIIllllllllll.m22;
            this.m20 = llllllllllllllllIIllIIllllllIlII.m02 * llllllllllllllllIIllIIllllllllll.m00 + llllllllllllllllIIllIIllllllIlII.m12 * llllllllllllllllIIllIIllllllllll.m01 + llllllllllllllllIIllIIllllllIlII.m22 * llllllllllllllllIIllIIllllllllll.m02;
            this.m21 = llllllllllllllllIIllIIllllllIlII.m02 * llllllllllllllllIIllIIllllllllll.m10 + llllllllllllllllIIllIIllllllIlII.m12 * llllllllllllllllIIllIIllllllllll.m11 + llllllllllllllllIIllIIllllllIlII.m22 * llllllllllllllllIIllIIllllllllll.m12;
            this.m22 = llllllllllllllllIIllIIllllllIlII.m02 * llllllllllllllllIIllIIllllllllll.m20 + llllllllllllllllIIllIIllllllIlII.m12 * llllllllllllllllIIllIIllllllllll.m21 + llllllllllllllllIIllIIllllllIlII.m22 * llllllllllllllllIIllIIllllllllll.m22;
        }
        else {
            final float llllllllllllllllIIllIIlllllllllI = llllllllllllllllIIllIIllllllIlII.m00 * llllllllllllllllIIllIIllllllllll.m00 + llllllllllllllllIIllIIllllllIlII.m10 * llllllllllllllllIIllIIllllllllll.m01 + llllllllllllllllIIllIIllllllIlII.m20 * llllllllllllllllIIllIIllllllllll.m02;
            final float llllllllllllllllIIllIIllllllllIl = llllllllllllllllIIllIIllllllIlII.m00 * llllllllllllllllIIllIIllllllllll.m10 + llllllllllllllllIIllIIllllllIlII.m10 * llllllllllllllllIIllIIllllllllll.m11 + llllllllllllllllIIllIIllllllIlII.m20 * llllllllllllllllIIllIIllllllllll.m12;
            final float llllllllllllllllIIllIIllllllllII = llllllllllllllllIIllIIllllllIlII.m00 * llllllllllllllllIIllIIllllllllll.m20 + llllllllllllllllIIllIIllllllIlII.m10 * llllllllllllllllIIllIIllllllllll.m21 + llllllllllllllllIIllIIllllllIlII.m20 * llllllllllllllllIIllIIllllllllll.m22;
            final float llllllllllllllllIIllIIlllllllIll = llllllllllllllllIIllIIllllllIlII.m01 * llllllllllllllllIIllIIllllllllll.m00 + llllllllllllllllIIllIIllllllIlII.m11 * llllllllllllllllIIllIIllllllllll.m01 + llllllllllllllllIIllIIllllllIlII.m21 * llllllllllllllllIIllIIllllllllll.m02;
            final float llllllllllllllllIIllIIlllllllIlI = llllllllllllllllIIllIIllllllIlII.m01 * llllllllllllllllIIllIIllllllllll.m10 + llllllllllllllllIIllIIllllllIlII.m11 * llllllllllllllllIIllIIllllllllll.m11 + llllllllllllllllIIllIIllllllIlII.m21 * llllllllllllllllIIllIIllllllllll.m12;
            final float llllllllllllllllIIllIIlllllllIIl = llllllllllllllllIIllIIllllllIlII.m01 * llllllllllllllllIIllIIllllllllll.m20 + llllllllllllllllIIllIIllllllIlII.m11 * llllllllllllllllIIllIIllllllllll.m21 + llllllllllllllllIIllIIllllllIlII.m21 * llllllllllllllllIIllIIllllllllll.m22;
            final float llllllllllllllllIIllIIlllllllIII = llllllllllllllllIIllIIllllllIlII.m02 * llllllllllllllllIIllIIllllllllll.m00 + llllllllllllllllIIllIIllllllIlII.m12 * llllllllllllllllIIllIIllllllllll.m01 + llllllllllllllllIIllIIllllllIlII.m22 * llllllllllllllllIIllIIllllllllll.m02;
            final float llllllllllllllllIIllIIllllllIlll = llllllllllllllllIIllIIllllllIlII.m02 * llllllllllllllllIIllIIllllllllll.m10 + llllllllllllllllIIllIIllllllIlII.m12 * llllllllllllllllIIllIIllllllllll.m11 + llllllllllllllllIIllIIllllllIlII.m22 * llllllllllllllllIIllIIllllllllll.m12;
            final float llllllllllllllllIIllIIllllllIllI = llllllllllllllllIIllIIllllllIlII.m02 * llllllllllllllllIIllIIllllllllll.m20 + llllllllllllllllIIllIIllllllIlII.m12 * llllllllllllllllIIllIIllllllllll.m21 + llllllllllllllllIIllIIllllllIlII.m22 * llllllllllllllllIIllIIllllllllll.m22;
            this.m00 = llllllllllllllllIIllIIlllllllllI;
            this.m01 = llllllllllllllllIIllIIllllllllIl;
            this.m02 = llllllllllllllllIIllIIllllllllII;
            this.m10 = llllllllllllllllIIllIIlllllllIll;
            this.m11 = llllllllllllllllIIllIIlllllllIlI;
            this.m12 = llllllllllllllllIIllIIlllllllIIl;
            this.m20 = llllllllllllllllIIllIIlllllllIII;
            this.m21 = llllllllllllllllIIllIIllllllIlll;
            this.m22 = llllllllllllllllIIllIIllllllIllI;
        }
    }
    
    public final void rotX(final float llllllllllllllllIIllIlIIlIIlllIl) {
        final float llllllllllllllllIIllIlIIlIlIIIII = (float)Math.sin(llllllllllllllllIIllIlIIlIIlllIl);
        final float llllllllllllllllIIllIlIIlIIlllll = (float)Math.cos(llllllllllllllllIIllIlIIlIIlllIl);
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = llllllllllllllllIIllIlIIlIIlllll;
        this.m12 = -llllllllllllllllIIllIlIIlIlIIIII;
        this.m20 = 0.0f;
        this.m21 = llllllllllllllllIIllIlIIlIlIIIII;
        this.m22 = llllllllllllllllIIllIlIIlIIlllll;
    }
    
    public final float getM21() {
        return this.m21;
    }
    
    public final void mulTransposeRight(final Matrix3f llllllllllllllllIIllIIllllIlllII, final Matrix3f llllllllllllllllIIllIIllllIllIll) {
        if (this != llllllllllllllllIIllIIllllIlllII && this != llllllllllllllllIIllIIllllIllIll) {
            this.m00 = llllllllllllllllIIllIIllllIlllII.m00 * llllllllllllllllIIllIIllllIllIll.m00 + llllllllllllllllIIllIIllllIlllII.m01 * llllllllllllllllIIllIIllllIllIll.m01 + llllllllllllllllIIllIIllllIlllII.m02 * llllllllllllllllIIllIIllllIllIll.m02;
            this.m01 = llllllllllllllllIIllIIllllIlllII.m00 * llllllllllllllllIIllIIllllIllIll.m10 + llllllllllllllllIIllIIllllIlllII.m01 * llllllllllllllllIIllIIllllIllIll.m11 + llllllllllllllllIIllIIllllIlllII.m02 * llllllllllllllllIIllIIllllIllIll.m12;
            this.m02 = llllllllllllllllIIllIIllllIlllII.m00 * llllllllllllllllIIllIIllllIllIll.m20 + llllllllllllllllIIllIIllllIlllII.m01 * llllllllllllllllIIllIIllllIllIll.m21 + llllllllllllllllIIllIIllllIlllII.m02 * llllllllllllllllIIllIIllllIllIll.m22;
            this.m10 = llllllllllllllllIIllIIllllIlllII.m10 * llllllllllllllllIIllIIllllIllIll.m00 + llllllllllllllllIIllIIllllIlllII.m11 * llllllllllllllllIIllIIllllIllIll.m01 + llllllllllllllllIIllIIllllIlllII.m12 * llllllllllllllllIIllIIllllIllIll.m02;
            this.m11 = llllllllllllllllIIllIIllllIlllII.m10 * llllllllllllllllIIllIIllllIllIll.m10 + llllllllllllllllIIllIIllllIlllII.m11 * llllllllllllllllIIllIIllllIllIll.m11 + llllllllllllllllIIllIIllllIlllII.m12 * llllllllllllllllIIllIIllllIllIll.m12;
            this.m12 = llllllllllllllllIIllIIllllIlllII.m10 * llllllllllllllllIIllIIllllIllIll.m20 + llllllllllllllllIIllIIllllIlllII.m11 * llllllllllllllllIIllIIllllIllIll.m21 + llllllllllllllllIIllIIllllIlllII.m12 * llllllllllllllllIIllIIllllIllIll.m22;
            this.m20 = llllllllllllllllIIllIIllllIlllII.m20 * llllllllllllllllIIllIIllllIllIll.m00 + llllllllllllllllIIllIIllllIlllII.m21 * llllllllllllllllIIllIIllllIllIll.m01 + llllllllllllllllIIllIIllllIlllII.m22 * llllllllllllllllIIllIIllllIllIll.m02;
            this.m21 = llllllllllllllllIIllIIllllIlllII.m20 * llllllllllllllllIIllIIllllIllIll.m10 + llllllllllllllllIIllIIllllIlllII.m21 * llllllllllllllllIIllIIllllIllIll.m11 + llllllllllllllllIIllIIllllIlllII.m22 * llllllllllllllllIIllIIllllIllIll.m12;
            this.m22 = llllllllllllllllIIllIIllllIlllII.m20 * llllllllllllllllIIllIIllllIllIll.m20 + llllllllllllllllIIllIIllllIlllII.m21 * llllllllllllllllIIllIIllllIllIll.m21 + llllllllllllllllIIllIIllllIlllII.m22 * llllllllllllllllIIllIIllllIllIll.m22;
        }
        else {
            final float llllllllllllllllIIllIIllllIllIlI = llllllllllllllllIIllIIllllIlllII.m00 * llllllllllllllllIIllIIllllIllIll.m00 + llllllllllllllllIIllIIllllIlllII.m01 * llllllllllllllllIIllIIllllIllIll.m01 + llllllllllllllllIIllIIllllIlllII.m02 * llllllllllllllllIIllIIllllIllIll.m02;
            final float llllllllllllllllIIllIIllllIllIIl = llllllllllllllllIIllIIllllIlllII.m00 * llllllllllllllllIIllIIllllIllIll.m10 + llllllllllllllllIIllIIllllIlllII.m01 * llllllllllllllllIIllIIllllIllIll.m11 + llllllllllllllllIIllIIllllIlllII.m02 * llllllllllllllllIIllIIllllIllIll.m12;
            final float llllllllllllllllIIllIIllllIllIII = llllllllllllllllIIllIIllllIlllII.m00 * llllllllllllllllIIllIIllllIllIll.m20 + llllllllllllllllIIllIIllllIlllII.m01 * llllllllllllllllIIllIIllllIllIll.m21 + llllllllllllllllIIllIIllllIlllII.m02 * llllllllllllllllIIllIIllllIllIll.m22;
            final float llllllllllllllllIIllIIllllIlIlll = llllllllllllllllIIllIIllllIlllII.m10 * llllllllllllllllIIllIIllllIllIll.m00 + llllllllllllllllIIllIIllllIlllII.m11 * llllllllllllllllIIllIIllllIllIll.m01 + llllllllllllllllIIllIIllllIlllII.m12 * llllllllllllllllIIllIIllllIllIll.m02;
            final float llllllllllllllllIIllIIllllIlIllI = llllllllllllllllIIllIIllllIlllII.m10 * llllllllllllllllIIllIIllllIllIll.m10 + llllllllllllllllIIllIIllllIlllII.m11 * llllllllllllllllIIllIIllllIllIll.m11 + llllllllllllllllIIllIIllllIlllII.m12 * llllllllllllllllIIllIIllllIllIll.m12;
            final float llllllllllllllllIIllIIllllIlIlIl = llllllllllllllllIIllIIllllIlllII.m10 * llllllllllllllllIIllIIllllIllIll.m20 + llllllllllllllllIIllIIllllIlllII.m11 * llllllllllllllllIIllIIllllIllIll.m21 + llllllllllllllllIIllIIllllIlllII.m12 * llllllllllllllllIIllIIllllIllIll.m22;
            final float llllllllllllllllIIllIIllllIlIlII = llllllllllllllllIIllIIllllIlllII.m20 * llllllllllllllllIIllIIllllIllIll.m00 + llllllllllllllllIIllIIllllIlllII.m21 * llllllllllllllllIIllIIllllIllIll.m01 + llllllllllllllllIIllIIllllIlllII.m22 * llllllllllllllllIIllIIllllIllIll.m02;
            final float llllllllllllllllIIllIIllllIlIIll = llllllllllllllllIIllIIllllIlllII.m20 * llllllllllllllllIIllIIllllIllIll.m10 + llllllllllllllllIIllIIllllIlllII.m21 * llllllllllllllllIIllIIllllIllIll.m11 + llllllllllllllllIIllIIllllIlllII.m22 * llllllllllllllllIIllIIllllIllIll.m12;
            final float llllllllllllllllIIllIIllllIlIIlI = llllllllllllllllIIllIIllllIlllII.m20 * llllllllllllllllIIllIIllllIllIll.m20 + llllllllllllllllIIllIIllllIlllII.m21 * llllllllllllllllIIllIIllllIllIll.m21 + llllllllllllllllIIllIIllllIlllII.m22 * llllllllllllllllIIllIIllllIllIll.m22;
            this.m00 = llllllllllllllllIIllIIllllIllIlI;
            this.m01 = llllllllllllllllIIllIIllllIllIIl;
            this.m02 = llllllllllllllllIIllIIllllIllIII;
            this.m10 = llllllllllllllllIIllIIllllIlIlll;
            this.m11 = llllllllllllllllIIllIIllllIlIllI;
            this.m12 = llllllllllllllllIIllIIllllIlIlIl;
            this.m20 = llllllllllllllllIIllIIllllIlIlII;
            this.m21 = llllllllllllllllIIllIIllllIlIIll;
            this.m22 = llllllllllllllllIIllIIllllIlIIlI;
        }
    }
    
    public final void setIdentity() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
    }
    
    public final void setM11(final float llllllllllllllllIIllIIlIlllIlIll) {
        this.m11 = llllllllllllllllIIllIIlIlllIlIll;
    }
    
    static void luBacksubstitution(final double[] llllllllllllllllIIllIlIIllIIlIll, final int[] llllllllllllllllIIllIlIIllIIlIlI, final double[] llllllllllllllllIIllIlIIllIIlIIl) {
        final int llllllllllllllllIIllIlIIllIIIIll = 0;
        for (int llllllllllllllllIIllIlIIllIIIlII = 0; llllllllllllllllIIllIlIIllIIIlII < 3; ++llllllllllllllllIIllIlIIllIIIlII) {
            final int llllllllllllllllIIllIlIIllIIIIlI = llllllllllllllllIIllIlIIllIIIlII;
            int llllllllllllllllIIllIlIIllIIIlll = -1;
            for (int llllllllllllllllIIllIlIIllIIlIII = 0; llllllllllllllllIIllIlIIllIIlIII < 3; ++llllllllllllllllIIllIlIIllIIlIII) {
                final int llllllllllllllllIIllIlIIllIIIllI = llllllllllllllllIIllIlIIllIIlIlI[llllllllllllllllIIllIlIIllIIIIll + llllllllllllllllIIllIlIIllIIlIII];
                double llllllllllllllllIIllIlIIlIllllll = llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 3 * llllllllllllllllIIllIlIIllIIIllI];
                llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 3 * llllllllllllllllIIllIlIIllIIIllI] = llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 3 * llllllllllllllllIIllIlIIllIIlIII];
                if (llllllllllllllllIIllIlIIllIIIlll >= 0) {
                    final int llllllllllllllllIIllIlIIllIIIIIl = llllllllllllllllIIllIlIIllIIlIII * 3;
                    for (int llllllllllllllllIIllIlIIllIIIlIl = llllllllllllllllIIllIlIIllIIIlll; llllllllllllllllIIllIlIIllIIIlIl <= llllllllllllllllIIllIlIIllIIlIII - 1; ++llllllllllllllllIIllIlIIllIIIlIl) {
                        llllllllllllllllIIllIlIIlIllllll -= llllllllllllllllIIllIlIIllIIlIll[llllllllllllllllIIllIlIIllIIIIIl + llllllllllllllllIIllIlIIllIIIlIl] * llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 3 * llllllllllllllllIIllIlIIllIIIlIl];
                    }
                }
                else if (llllllllllllllllIIllIlIIlIllllll != 0.0) {
                    llllllllllllllllIIllIlIIllIIIlll = llllllllllllllllIIllIlIIllIIlIII;
                }
                llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 3 * llllllllllllllllIIllIlIIllIIlIII] = llllllllllllllllIIllIlIIlIllllll;
            }
            int llllllllllllllllIIllIlIIllIIIIII = 6;
            final int n = llllllllllllllllIIllIlIIllIIIIlI + 6;
            llllllllllllllllIIllIlIIllIIlIIl[n] /= llllllllllllllllIIllIlIIllIIlIll[llllllllllllllllIIllIlIIllIIIIII + 2];
            llllllllllllllllIIllIlIIllIIIIII -= 3;
            llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 3] = (llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 3] - llllllllllllllllIIllIlIIllIIlIll[llllllllllllllllIIllIlIIllIIIIII + 2] * llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 6]) / llllllllllllllllIIllIlIIllIIlIll[llllllllllllllllIIllIlIIllIIIIII + 1];
            llllllllllllllllIIllIlIIllIIIIII -= 3;
            llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 0] = (llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 0] - llllllllllllllllIIllIlIIllIIlIll[llllllllllllllllIIllIlIIllIIIIII + 1] * llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 3] - llllllllllllllllIIllIlIIllIIlIll[llllllllllllllllIIllIlIIllIIIIII + 2] * llllllllllllllllIIllIlIIllIIlIIl[llllllllllllllllIIllIlIIllIIIIlI + 6]) / llllllllllllllllIIllIlIIllIIlIll[llllllllllllllllIIllIlIIllIIIIII + 0];
        }
    }
    
    public final void set(final float llllllllllllllllIIllIlIIlIlIIlll) {
        this.m00 = llllllllllllllllIIllIlIIlIlIIlll;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = llllllllllllllllIIllIlIIlIlIIlll;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = llllllllllllllllIIllIlIIlIlIIlll;
    }
    
    public final void setM01(final float llllllllllllllllIIllIIllIIIIIllI) {
        this.m01 = llllllllllllllllIIllIIllIIIIIllI;
    }
    
    public Matrix3f(final Matrix3d llllllllllllllllIIllIllIIllllIlI) {
        this.m00 = (float)llllllllllllllllIIllIllIIllllIlI.m00;
        this.m01 = (float)llllllllllllllllIIllIllIIllllIlI.m01;
        this.m02 = (float)llllllllllllllllIIllIllIIllllIlI.m02;
        this.m10 = (float)llllllllllllllllIIllIllIIllllIlI.m10;
        this.m11 = (float)llllllllllllllllIIllIllIIllllIlI.m11;
        this.m12 = (float)llllllllllllllllIIllIllIIllllIlI.m12;
        this.m20 = (float)llllllllllllllllIIllIllIIllllIlI.m20;
        this.m21 = (float)llllllllllllllllIIllIllIIllllIlI.m21;
        this.m22 = (float)llllllllllllllllIIllIllIIllllIlI.m22;
    }
    
    public final float getM10() {
        return this.m10;
    }
    
    public final void setColumn(final int llllllllllllllllIIllIlIllllllIIl, final float llllllllllllllllIIllIlIllllllIII, final float llllllllllllllllIIllIlIlllllIlll, final float llllllllllllllllIIllIlIllllllIll) {
        switch (llllllllllllllllIIllIlIllllllIIl) {
            case 0: {
                this.m00 = llllllllllllllllIIllIlIllllllIII;
                this.m10 = llllllllllllllllIIllIlIlllllIlll;
                this.m20 = llllllllllllllllIIllIlIllllllIll;
                break;
            }
            case 1: {
                this.m01 = llllllllllllllllIIllIlIllllllIII;
                this.m11 = llllllllllllllllIIllIlIlllllIlll;
                this.m21 = llllllllllllllllIIllIlIllllllIll;
                break;
            }
            case 2: {
                this.m02 = llllllllllllllllIIllIlIllllllIII;
                this.m12 = llllllllllllllllIIllIlIlllllIlll;
                this.m22 = llllllllllllllllIIllIlIllllllIll;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f9"));
            }
        }
    }
    
    public final void transpose(final Matrix3f llllllllllllllllIIllIlIllIlIIIlI) {
        if (this != llllllllllllllllIIllIlIllIlIIIlI) {
            this.m00 = llllllllllllllllIIllIlIllIlIIIlI.m00;
            this.m01 = llllllllllllllllIIllIlIllIlIIIlI.m10;
            this.m02 = llllllllllllllllIIllIlIllIlIIIlI.m20;
            this.m10 = llllllllllllllllIIllIlIllIlIIIlI.m01;
            this.m11 = llllllllllllllllIIllIlIllIlIIIlI.m11;
            this.m12 = llllllllllllllllIIllIlIllIlIIIlI.m21;
            this.m20 = llllllllllllllllIIllIlIllIlIIIlI.m02;
            this.m21 = llllllllllllllllIIllIlIllIlIIIlI.m12;
            this.m22 = llllllllllllllllIIllIlIllIlIIIlI.m22;
        }
        else {
            this.transpose();
        }
    }
    
    public final void setZero() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
    }
    
    public final void mul(final float llllllllllllllllIIllIlIIIlllllIl) {
        this.m00 *= llllllllllllllllIIllIlIIIlllllIl;
        this.m01 *= llllllllllllllllIIllIlIIIlllllIl;
        this.m02 *= llllllllllllllllIIllIlIIIlllllIl;
        this.m10 *= llllllllllllllllIIllIlIIIlllllIl;
        this.m11 *= llllllllllllllllIIllIlIIIlllllIl;
        this.m12 *= llllllllllllllllIIllIlIIIlllllIl;
        this.m20 *= llllllllllllllllIIllIlIIIlllllIl;
        this.m21 *= llllllllllllllllIIllIlIIIlllllIl;
        this.m22 *= llllllllllllllllIIllIlIIIlllllIl;
    }
    
    public boolean epsilonEquals(final Matrix3f llllllllllllllllIIllIIllIlIlllIl, final float llllllllllllllllIIllIIllIllIIIII) {
        boolean llllllllllllllllIIllIIllIlIlllll = true;
        if (Math.abs(this.m00 - llllllllllllllllIIllIIllIlIlllIl.m00) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        if (Math.abs(this.m01 - llllllllllllllllIIllIIllIlIlllIl.m01) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        if (Math.abs(this.m02 - llllllllllllllllIIllIIllIlIlllIl.m02) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        if (Math.abs(this.m10 - llllllllllllllllIIllIIllIlIlllIl.m10) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        if (Math.abs(this.m11 - llllllllllllllllIIllIIllIlIlllIl.m11) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        if (Math.abs(this.m12 - llllllllllllllllIIllIIllIlIlllIl.m12) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        if (Math.abs(this.m20 - llllllllllllllllIIllIIllIlIlllIl.m20) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        if (Math.abs(this.m21 - llllllllllllllllIIllIIllIlIlllIl.m21) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        if (Math.abs(this.m22 - llllllllllllllllIIllIIllIlIlllIl.m22) > llllllllllllllllIIllIIllIllIIIII) {
            llllllllllllllllIIllIIllIlIlllll = false;
        }
        return llllllllllllllllIIllIIllIlIlllll;
    }
    
    public final void getColumn(final int llllllllllllllllIIllIllIIIllllII, final Vector3f llllllllllllllllIIllIllIIIlllIll) {
        if (llllllllllllllllIIllIllIIIllllII == 0) {
            llllllllllllllllIIllIllIIIlllIll.x = this.m00;
            llllllllllllllllIIllIllIIIlllIll.y = this.m10;
            llllllllllllllllIIllIllIIIlllIll.z = this.m20;
        }
        else if (llllllllllllllllIIllIllIIIllllII == 1) {
            llllllllllllllllIIllIllIIIlllIll.x = this.m01;
            llllllllllllllllIIllIllIIIlllIll.y = this.m11;
            llllllllllllllllIIllIllIIIlllIll.z = this.m21;
        }
        else {
            if (llllllllllllllllIIllIllIIIllllII != 2) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f3"));
            }
            llllllllllllllllIIllIllIIIlllIll.x = this.m02;
            llllllllllllllllIIllIllIIIlllIll.y = this.m12;
            llllllllllllllllIIllIllIIIlllIll.z = this.m22;
        }
    }
    
    public final void set(final AxisAngle4f llllllllllllllllIIllIlIllIIIIIlI) {
        float llllllllllllllllIIllIlIllIIIllIl = (float)Math.sqrt(llllllllllllllllIIllIlIllIIIIIlI.x * llllllllllllllllIIllIlIllIIIIIlI.x + llllllllllllllllIIllIlIllIIIIIlI.y * llllllllllllllllIIllIlIllIIIIIlI.y + llllllllllllllllIIllIlIllIIIIIlI.z * llllllllllllllllIIllIlIllIIIIIlI.z);
        if (llllllllllllllllIIllIlIllIIIllIl < 1.0E-8) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            this.m20 = 0.0f;
            this.m21 = 0.0f;
            this.m22 = 1.0f;
        }
        else {
            llllllllllllllllIIllIlIllIIIllIl = 1.0f / llllllllllllllllIIllIlIllIIIllIl;
            final float llllllllllllllllIIllIlIllIIIllII = llllllllllllllllIIllIlIllIIIIIlI.x * llllllllllllllllIIllIlIllIIIllIl;
            final float llllllllllllllllIIllIlIllIIIlIll = llllllllllllllllIIllIlIllIIIIIlI.y * llllllllllllllllIIllIlIllIIIllIl;
            final float llllllllllllllllIIllIlIllIIIlIlI = llllllllllllllllIIllIlIllIIIIIlI.z * llllllllllllllllIIllIlIllIIIllIl;
            final float llllllllllllllllIIllIlIllIIIlIIl = (float)Math.sin(llllllllllllllllIIllIlIllIIIIIlI.angle);
            final float llllllllllllllllIIllIlIllIIIlIII = (float)Math.cos(llllllllllllllllIIllIlIllIIIIIlI.angle);
            final float llllllllllllllllIIllIlIllIIIIlll = 1.0f - llllllllllllllllIIllIlIllIIIlIII;
            final float llllllllllllllllIIllIlIllIIIIllI = llllllllllllllllIIllIlIllIIIllII * llllllllllllllllIIllIlIllIIIlIlI;
            final float llllllllllllllllIIllIlIllIIIIlIl = llllllllllllllllIIllIlIllIIIllII * llllllllllllllllIIllIlIllIIIlIll;
            final float llllllllllllllllIIllIlIllIIIIlII = llllllllllllllllIIllIlIllIIIlIll * llllllllllllllllIIllIlIllIIIlIlI;
            this.m00 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIllII * llllllllllllllllIIllIlIllIIIllII + llllllllllllllllIIllIlIllIIIlIII;
            this.m01 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIIlIl - llllllllllllllllIIllIlIllIIIlIIl * llllllllllllllllIIllIlIllIIIlIlI;
            this.m02 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIIllI + llllllllllllllllIIllIlIllIIIlIIl * llllllllllllllllIIllIlIllIIIlIll;
            this.m10 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIIlIl + llllllllllllllllIIllIlIllIIIlIIl * llllllllllllllllIIllIlIllIIIlIlI;
            this.m11 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIlIll * llllllllllllllllIIllIlIllIIIlIll + llllllllllllllllIIllIlIllIIIlIII;
            this.m12 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIIlII - llllllllllllllllIIllIlIllIIIlIIl * llllllllllllllllIIllIlIllIIIllII;
            this.m20 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIIllI - llllllllllllllllIIllIlIllIIIlIIl * llllllllllllllllIIllIlIllIIIlIll;
            this.m21 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIIlII + llllllllllllllllIIllIlIllIIIlIIl * llllllllllllllllIIllIlIllIIIllII;
            this.m22 = llllllllllllllllIIllIlIllIIIIlll * llllllllllllllllIIllIlIllIIIlIlI * llllllllllllllllIIllIlIllIIIlIlI + llllllllllllllllIIllIlIllIIIlIII;
        }
    }
    
    public final void set(final Matrix3d llllllllllllllllIIllIlIlIIlllllI) {
        this.m00 = (float)llllllllllllllllIIllIlIlIIlllllI.m00;
        this.m01 = (float)llllllllllllllllIIllIlIlIIlllllI.m01;
        this.m02 = (float)llllllllllllllllIIllIlIlIIlllllI.m02;
        this.m10 = (float)llllllllllllllllIIllIlIlIIlllllI.m10;
        this.m11 = (float)llllllllllllllllIIllIlIlIIlllllI.m11;
        this.m12 = (float)llllllllllllllllIIllIlIlIIlllllI.m12;
        this.m20 = (float)llllllllllllllllIIllIlIlIIlllllI.m20;
        this.m21 = (float)llllllllllllllllIIllIlIlIIlllllI.m21;
        this.m22 = (float)llllllllllllllllIIllIlIlIIlllllI.m22;
    }
    
    public final void transform(final Tuple3f llllllllllllllllIIllIIllIIllllIl) {
        final float llllllllllllllllIIllIIllIlIIIIIl = this.m00 * llllllllllllllllIIllIIllIIllllIl.x + this.m01 * llllllllllllllllIIllIIllIIllllIl.y + this.m02 * llllllllllllllllIIllIIllIIllllIl.z;
        final float llllllllllllllllIIllIIllIlIIIIII = this.m10 * llllllllllllllllIIllIIllIIllllIl.x + this.m11 * llllllllllllllllIIllIIllIIllllIl.y + this.m12 * llllllllllllllllIIllIIllIIllllIl.z;
        final float llllllllllllllllIIllIIllIIllllll = this.m20 * llllllllllllllllIIllIIllIIllllIl.x + this.m21 * llllllllllllllllIIllIIllIIllllIl.y + this.m22 * llllllllllllllllIIllIIllIIllllIl.z;
        llllllllllllllllIIllIIllIIllllIl.set(llllllllllllllllIIllIIllIlIIIIIl, llllllllllllllllIIllIIllIlIIIIII, llllllllllllllllIIllIIllIIllllll);
    }
    
    public final float getM11() {
        return this.m11;
    }
    
    public final void invert(final Matrix3f llllllllllllllllIIllIlIlIIllIllI) {
        this.invertGeneral(llllllllllllllllIIllIlIlIIllIllI);
    }
    
    public final void setM10(final float llllllllllllllllIIllIIlIllllIIlI) {
        this.m10 = llllllllllllllllIIllIIlIllllIIlI;
    }
    
    public final void set(final float[] llllllllllllllllIIllIlIlIlIIlIII) {
        this.m00 = llllllllllllllllIIllIlIlIlIIlIII[0];
        this.m01 = llllllllllllllllIIllIlIlIlIIlIII[1];
        this.m02 = llllllllllllllllIIllIlIlIlIIlIII[2];
        this.m10 = llllllllllllllllIIllIlIlIlIIlIII[3];
        this.m11 = llllllllllllllllIIllIlIlIlIIlIII[4];
        this.m12 = llllllllllllllllIIllIlIlIlIIlIII[5];
        this.m20 = llllllllllllllllIIllIlIlIlIIlIII[6];
        this.m21 = llllllllllllllllIIllIlIlIlIIlIII[7];
        this.m22 = llllllllllllllllIIllIlIlIlIIlIII[8];
    }
    
    public final void add(final float llllllllllllllllIIllIlIlllIIllIl, final Matrix3f llllllllllllllllIIllIlIlllIIllII) {
        this.m00 = llllllllllllllllIIllIlIlllIIllII.m00 + llllllllllllllllIIllIlIlllIIllIl;
        this.m01 = llllllllllllllllIIllIlIlllIIllII.m01 + llllllllllllllllIIllIlIlllIIllIl;
        this.m02 = llllllllllllllllIIllIlIlllIIllII.m02 + llllllllllllllllIIllIlIlllIIllIl;
        this.m10 = llllllllllllllllIIllIlIlllIIllII.m10 + llllllllllllllllIIllIlIlllIIllIl;
        this.m11 = llllllllllllllllIIllIlIlllIIllII.m11 + llllllllllllllllIIllIlIlllIIllIl;
        this.m12 = llllllllllllllllIIllIlIlllIIllII.m12 + llllllllllllllllIIllIlIlllIIllIl;
        this.m20 = llllllllllllllllIIllIlIlllIIllII.m20 + llllllllllllllllIIllIlIlllIIllIl;
        this.m21 = llllllllllllllllIIllIlIlllIIllII.m21 + llllllllllllllllIIllIlIlllIIllIl;
        this.m22 = llllllllllllllllIIllIlIlllIIllII.m22 + llllllllllllllllIIllIlIlllIIllIl;
    }
    
    public Matrix3f(final float[] llllllllllllllllIIllIllIlIIIIIII) {
        this.m00 = llllllllllllllllIIllIllIlIIIIIII[0];
        this.m01 = llllllllllllllllIIllIllIlIIIIIII[1];
        this.m02 = llllllllllllllllIIllIllIlIIIIIII[2];
        this.m10 = llllllllllllllllIIllIllIlIIIIIII[3];
        this.m11 = llllllllllllllllIIllIllIlIIIIIII[4];
        this.m12 = llllllllllllllllIIllIllIlIIIIIII[5];
        this.m20 = llllllllllllllllIIllIllIlIIIIIII[6];
        this.m21 = llllllllllllllllIIllIllIlIIIIIII[7];
        this.m22 = llllllllllllllllIIllIllIlIIIIIII[8];
    }
    
    public final void rotY(final float llllllllllllllllIIllIlIIlIIlIIIl) {
        final float llllllllllllllllIIllIlIIlIIlIlII = (float)Math.sin(llllllllllllllllIIllIlIIlIIlIIIl);
        final float llllllllllllllllIIllIlIIlIIlIIll = (float)Math.cos(llllllllllllllllIIllIlIIlIIlIIIl);
        this.m00 = llllllllllllllllIIllIlIIlIIlIIll;
        this.m01 = 0.0f;
        this.m02 = llllllllllllllllIIllIlIIlIIlIlII;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m20 = -llllllllllllllllIIllIlIIlIIlIlII;
        this.m21 = 0.0f;
        this.m22 = llllllllllllllllIIllIlIIlIIlIIll;
    }
    
    public final void negate() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
    }
    
    public final void getRow(final int llllllllllllllllIIllIllIIlIIlIll, final Vector3f llllllllllllllllIIllIllIIlIIlIlI) {
        if (llllllllllllllllIIllIllIIlIIlIll == 0) {
            llllllllllllllllIIllIllIIlIIlIlI.x = this.m00;
            llllllllllllllllIIllIllIIlIIlIlI.y = this.m01;
            llllllllllllllllIIllIllIIlIIlIlI.z = this.m02;
        }
        else if (llllllllllllllllIIllIllIIlIIlIll == 1) {
            llllllllllllllllIIllIllIIlIIlIlI.x = this.m10;
            llllllllllllllllIIllIllIIlIIlIlI.y = this.m11;
            llllllllllllllllIIllIllIIlIIlIlI.z = this.m12;
        }
        else {
            if (llllllllllllllllIIllIllIIlIIlIll != 2) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3f1"));
            }
            llllllllllllllllIIllIllIIlIIlIlI.x = this.m20;
            llllllllllllllllIIllIllIIlIIlIlI.y = this.m21;
            llllllllllllllllIIllIllIIlIIlIlI.z = this.m22;
        }
    }
    
    public final void negate(final Matrix3f llllllllllllllllIIllIIllIlIIlIll) {
        this.m00 = -llllllllllllllllIIllIIllIlIIlIll.m00;
        this.m01 = -llllllllllllllllIIllIIllIlIIlIll.m01;
        this.m02 = -llllllllllllllllIIllIIllIlIIlIll.m02;
        this.m10 = -llllllllllllllllIIllIIllIlIIlIll.m10;
        this.m11 = -llllllllllllllllIIllIIllIlIIlIll.m11;
        this.m12 = -llllllllllllllllIIllIIllIlIIlIll.m12;
        this.m20 = -llllllllllllllllIIllIIllIlIIlIll.m20;
        this.m21 = -llllllllllllllllIIllIIllIlIIlIll.m21;
        this.m22 = -llllllllllllllllIIllIIllIlIIlIll.m22;
    }
}
