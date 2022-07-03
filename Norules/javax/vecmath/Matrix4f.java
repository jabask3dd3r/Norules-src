package javax.vecmath;

import java.io.*;

public class Matrix4f implements Serializable, Cloneable
{
    public /* synthetic */ float m20;
    public /* synthetic */ float m23;
    public /* synthetic */ float m21;
    public /* synthetic */ float m13;
    public /* synthetic */ float m31;
    public /* synthetic */ float m12;
    public /* synthetic */ float m02;
    public /* synthetic */ float m00;
    public /* synthetic */ float m30;
    public /* synthetic */ float m33;
    public /* synthetic */ float m22;
    public /* synthetic */ float m32;
    public /* synthetic */ float m01;
    public /* synthetic */ float m11;
    public /* synthetic */ float m10;
    public /* synthetic */ float m03;
    
    public final void invert(final Matrix4f lllllllllllllllllIIIIlIlIIIIlIII) {
        this.invertGeneral(lllllllllllllllllIIIIlIlIIIIlIII);
    }
    
    public final float getM00() {
        return this.m00;
    }
    
    public final float getM23() {
        return this.m23;
    }
    
    public final float getM03() {
        return this.m03;
    }
    
    public final void setRow(final int lllllllllllllllllIIIIllIIIIIllII, final float lllllllllllllllllIIIIllIIIIlIIIl, final float lllllllllllllllllIIIIllIIIIlIIII, final float lllllllllllllllllIIIIllIIIIIlIIl, final float lllllllllllllllllIIIIllIIIIIlIII) {
        switch (lllllllllllllllllIIIIllIIIIIllII) {
            case 0: {
                this.m00 = lllllllllllllllllIIIIllIIIIlIIIl;
                this.m01 = lllllllllllllllllIIIIllIIIIlIIII;
                this.m02 = lllllllllllllllllIIIIllIIIIIlIIl;
                this.m03 = lllllllllllllllllIIIIllIIIIIlIII;
                break;
            }
            case 1: {
                this.m10 = lllllllllllllllllIIIIllIIIIlIIIl;
                this.m11 = lllllllllllllllllIIIIllIIIIlIIII;
                this.m12 = lllllllllllllllllIIIIllIIIIIlIIl;
                this.m13 = lllllllllllllllllIIIIllIIIIIlIII;
                break;
            }
            case 2: {
                this.m20 = lllllllllllllllllIIIIllIIIIlIIIl;
                this.m21 = lllllllllllllllllIIIIllIIIIlIIII;
                this.m22 = lllllllllllllllllIIIIllIIIIIlIIl;
                this.m23 = lllllllllllllllllIIIIllIIIIIlIII;
                break;
            }
            case 3: {
                this.m30 = lllllllllllllllllIIIIllIIIIlIIIl;
                this.m31 = lllllllllllllllllIIIIllIIIIlIIII;
                this.m32 = lllllllllllllllllIIIIllIIIIIlIIl;
                this.m33 = lllllllllllllllllIIIIllIIIIIlIII;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
            }
        }
    }
    
    public final void setRow(final int lllllllllllllllllIIIIllIIIIIIIII, final Vector4f lllllllllllllllllIIIIlIlllllllll) {
        switch (lllllllllllllllllIIIIllIIIIIIIII) {
            case 0: {
                this.m00 = lllllllllllllllllIIIIlIlllllllll.x;
                this.m01 = lllllllllllllllllIIIIlIlllllllll.y;
                this.m02 = lllllllllllllllllIIIIlIlllllllll.z;
                this.m03 = lllllllllllllllllIIIIlIlllllllll.w;
                break;
            }
            case 1: {
                this.m10 = lllllllllllllllllIIIIlIlllllllll.x;
                this.m11 = lllllllllllllllllIIIIlIlllllllll.y;
                this.m12 = lllllllllllllllllIIIIlIlllllllll.z;
                this.m13 = lllllllllllllllllIIIIlIlllllllll.w;
                break;
            }
            case 2: {
                this.m20 = lllllllllllllllllIIIIlIlllllllll.x;
                this.m21 = lllllllllllllllllIIIIlIlllllllll.y;
                this.m22 = lllllllllllllllllIIIIlIlllllllll.z;
                this.m23 = lllllllllllllllllIIIIlIlllllllll.w;
                break;
            }
            case 3: {
                this.m30 = lllllllllllllllllIIIIlIlllllllll.x;
                this.m31 = lllllllllllllllllIIIIlIlllllllll.y;
                this.m32 = lllllllllllllllllIIIIlIlllllllll.z;
                this.m33 = lllllllllllllllllIIIIlIlllllllll.w;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
            }
        }
    }
    
    public final void set(final Matrix3f lllllllllllllllllIIIIlIIIlIlIIIl, final Vector3f lllllllllllllllllIIIIlIIIlIlIlII, final float lllllllllllllllllIIIIlIIIlIlIIll) {
        this.m00 = lllllllllllllllllIIIIlIIIlIlIIIl.m00 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m01 = lllllllllllllllllIIIIlIIIlIlIIIl.m01 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m02 = lllllllllllllllllIIIIlIIIlIlIIIl.m02 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m03 = lllllllllllllllllIIIIlIIIlIlIlII.x;
        this.m10 = lllllllllllllllllIIIIlIIIlIlIIIl.m10 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m11 = lllllllllllllllllIIIIlIIIlIlIIIl.m11 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m12 = lllllllllllllllllIIIIlIIIlIlIIIl.m12 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m13 = lllllllllllllllllIIIIlIIIlIlIlII.y;
        this.m20 = lllllllllllllllllIIIIlIIIlIlIIIl.m20 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m21 = lllllllllllllllllIIIIlIIIlIlIIIl.m21 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m22 = lllllllllllllllllIIIIlIIIlIlIIIl.m22 * lllllllllllllllllIIIIlIIIlIlIIll;
        this.m23 = lllllllllllllllllIIIIlIIIlIlIlII.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void mulTransposeRight(final Matrix4f lllllllllllllllllIIIIIllIIlllIlI, final Matrix4f lllllllllllllllllIIIIIllIIlllIIl) {
        if (this != lllllllllllllllllIIIIIllIIlllIlI && this != lllllllllllllllllIIIIIllIIlllIIl) {
            this.m00 = lllllllllllllllllIIIIIllIIlllIlI.m00 * lllllllllllllllllIIIIIllIIlllIIl.m00 + lllllllllllllllllIIIIIllIIlllIlI.m01 * lllllllllllllllllIIIIIllIIlllIIl.m01 + lllllllllllllllllIIIIIllIIlllIlI.m02 * lllllllllllllllllIIIIIllIIlllIIl.m02 + lllllllllllllllllIIIIIllIIlllIlI.m03 * lllllllllllllllllIIIIIllIIlllIIl.m03;
            this.m01 = lllllllllllllllllIIIIIllIIlllIlI.m00 * lllllllllllllllllIIIIIllIIlllIIl.m10 + lllllllllllllllllIIIIIllIIlllIlI.m01 * lllllllllllllllllIIIIIllIIlllIIl.m11 + lllllllllllllllllIIIIIllIIlllIlI.m02 * lllllllllllllllllIIIIIllIIlllIIl.m12 + lllllllllllllllllIIIIIllIIlllIlI.m03 * lllllllllllllllllIIIIIllIIlllIIl.m13;
            this.m02 = lllllllllllllllllIIIIIllIIlllIlI.m00 * lllllllllllllllllIIIIIllIIlllIIl.m20 + lllllllllllllllllIIIIIllIIlllIlI.m01 * lllllllllllllllllIIIIIllIIlllIIl.m21 + lllllllllllllllllIIIIIllIIlllIlI.m02 * lllllllllllllllllIIIIIllIIlllIIl.m22 + lllllllllllllllllIIIIIllIIlllIlI.m03 * lllllllllllllllllIIIIIllIIlllIIl.m23;
            this.m03 = lllllllllllllllllIIIIIllIIlllIlI.m00 * lllllllllllllllllIIIIIllIIlllIIl.m30 + lllllllllllllllllIIIIIllIIlllIlI.m01 * lllllllllllllllllIIIIIllIIlllIIl.m31 + lllllllllllllllllIIIIIllIIlllIlI.m02 * lllllllllllllllllIIIIIllIIlllIIl.m32 + lllllllllllllllllIIIIIllIIlllIlI.m03 * lllllllllllllllllIIIIIllIIlllIIl.m33;
            this.m10 = lllllllllllllllllIIIIIllIIlllIlI.m10 * lllllllllllllllllIIIIIllIIlllIIl.m00 + lllllllllllllllllIIIIIllIIlllIlI.m11 * lllllllllllllllllIIIIIllIIlllIIl.m01 + lllllllllllllllllIIIIIllIIlllIlI.m12 * lllllllllllllllllIIIIIllIIlllIIl.m02 + lllllllllllllllllIIIIIllIIlllIlI.m13 * lllllllllllllllllIIIIIllIIlllIIl.m03;
            this.m11 = lllllllllllllllllIIIIIllIIlllIlI.m10 * lllllllllllllllllIIIIIllIIlllIIl.m10 + lllllllllllllllllIIIIIllIIlllIlI.m11 * lllllllllllllllllIIIIIllIIlllIIl.m11 + lllllllllllllllllIIIIIllIIlllIlI.m12 * lllllllllllllllllIIIIIllIIlllIIl.m12 + lllllllllllllllllIIIIIllIIlllIlI.m13 * lllllllllllllllllIIIIIllIIlllIIl.m13;
            this.m12 = lllllllllllllllllIIIIIllIIlllIlI.m10 * lllllllllllllllllIIIIIllIIlllIIl.m20 + lllllllllllllllllIIIIIllIIlllIlI.m11 * lllllllllllllllllIIIIIllIIlllIIl.m21 + lllllllllllllllllIIIIIllIIlllIlI.m12 * lllllllllllllllllIIIIIllIIlllIIl.m22 + lllllllllllllllllIIIIIllIIlllIlI.m13 * lllllllllllllllllIIIIIllIIlllIIl.m23;
            this.m13 = lllllllllllllllllIIIIIllIIlllIlI.m10 * lllllllllllllllllIIIIIllIIlllIIl.m30 + lllllllllllllllllIIIIIllIIlllIlI.m11 * lllllllllllllllllIIIIIllIIlllIIl.m31 + lllllllllllllllllIIIIIllIIlllIlI.m12 * lllllllllllllllllIIIIIllIIlllIIl.m32 + lllllllllllllllllIIIIIllIIlllIlI.m13 * lllllllllllllllllIIIIIllIIlllIIl.m33;
            this.m20 = lllllllllllllllllIIIIIllIIlllIlI.m20 * lllllllllllllllllIIIIIllIIlllIIl.m00 + lllllllllllllllllIIIIIllIIlllIlI.m21 * lllllllllllllllllIIIIIllIIlllIIl.m01 + lllllllllllllllllIIIIIllIIlllIlI.m22 * lllllllllllllllllIIIIIllIIlllIIl.m02 + lllllllllllllllllIIIIIllIIlllIlI.m23 * lllllllllllllllllIIIIIllIIlllIIl.m03;
            this.m21 = lllllllllllllllllIIIIIllIIlllIlI.m20 * lllllllllllllllllIIIIIllIIlllIIl.m10 + lllllllllllllllllIIIIIllIIlllIlI.m21 * lllllllllllllllllIIIIIllIIlllIIl.m11 + lllllllllllllllllIIIIIllIIlllIlI.m22 * lllllllllllllllllIIIIIllIIlllIIl.m12 + lllllllllllllllllIIIIIllIIlllIlI.m23 * lllllllllllllllllIIIIIllIIlllIIl.m13;
            this.m22 = lllllllllllllllllIIIIIllIIlllIlI.m20 * lllllllllllllllllIIIIIllIIlllIIl.m20 + lllllllllllllllllIIIIIllIIlllIlI.m21 * lllllllllllllllllIIIIIllIIlllIIl.m21 + lllllllllllllllllIIIIIllIIlllIlI.m22 * lllllllllllllllllIIIIIllIIlllIIl.m22 + lllllllllllllllllIIIIIllIIlllIlI.m23 * lllllllllllllllllIIIIIllIIlllIIl.m23;
            this.m23 = lllllllllllllllllIIIIIllIIlllIlI.m20 * lllllllllllllllllIIIIIllIIlllIIl.m30 + lllllllllllllllllIIIIIllIIlllIlI.m21 * lllllllllllllllllIIIIIllIIlllIIl.m31 + lllllllllllllllllIIIIIllIIlllIlI.m22 * lllllllllllllllllIIIIIllIIlllIIl.m32 + lllllllllllllllllIIIIIllIIlllIlI.m23 * lllllllllllllllllIIIIIllIIlllIIl.m33;
            this.m30 = lllllllllllllllllIIIIIllIIlllIlI.m30 * lllllllllllllllllIIIIIllIIlllIIl.m00 + lllllllllllllllllIIIIIllIIlllIlI.m31 * lllllllllllllllllIIIIIllIIlllIIl.m01 + lllllllllllllllllIIIIIllIIlllIlI.m32 * lllllllllllllllllIIIIIllIIlllIIl.m02 + lllllllllllllllllIIIIIllIIlllIlI.m33 * lllllllllllllllllIIIIIllIIlllIIl.m03;
            this.m31 = lllllllllllllllllIIIIIllIIlllIlI.m30 * lllllllllllllllllIIIIIllIIlllIIl.m10 + lllllllllllllllllIIIIIllIIlllIlI.m31 * lllllllllllllllllIIIIIllIIlllIIl.m11 + lllllllllllllllllIIIIIllIIlllIlI.m32 * lllllllllllllllllIIIIIllIIlllIIl.m12 + lllllllllllllllllIIIIIllIIlllIlI.m33 * lllllllllllllllllIIIIIllIIlllIIl.m13;
            this.m32 = lllllllllllllllllIIIIIllIIlllIlI.m30 * lllllllllllllllllIIIIIllIIlllIIl.m20 + lllllllllllllllllIIIIIllIIlllIlI.m31 * lllllllllllllllllIIIIIllIIlllIIl.m21 + lllllllllllllllllIIIIIllIIlllIlI.m32 * lllllllllllllllllIIIIIllIIlllIIl.m22 + lllllllllllllllllIIIIIllIIlllIlI.m33 * lllllllllllllllllIIIIIllIIlllIIl.m23;
            this.m33 = lllllllllllllllllIIIIIllIIlllIlI.m30 * lllllllllllllllllIIIIIllIIlllIIl.m30 + lllllllllllllllllIIIIIllIIlllIlI.m31 * lllllllllllllllllIIIIIllIIlllIIl.m31 + lllllllllllllllllIIIIIllIIlllIlI.m32 * lllllllllllllllllIIIIIllIIlllIIl.m32 + lllllllllllllllllIIIIIllIIlllIlI.m33 * lllllllllllllllllIIIIIllIIlllIIl.m33;
        }
        else {
            final float lllllllllllllllllIIIIIllIlIIlIll = lllllllllllllllllIIIIIllIIlllIlI.m00 * lllllllllllllllllIIIIIllIIlllIIl.m00 + lllllllllllllllllIIIIIllIIlllIlI.m01 * lllllllllllllllllIIIIIllIIlllIIl.m01 + lllllllllllllllllIIIIIllIIlllIlI.m02 * lllllllllllllllllIIIIIllIIlllIIl.m02 + lllllllllllllllllIIIIIllIIlllIlI.m03 * lllllllllllllllllIIIIIllIIlllIIl.m03;
            final float lllllllllllllllllIIIIIllIlIIlIlI = lllllllllllllllllIIIIIllIIlllIlI.m00 * lllllllllllllllllIIIIIllIIlllIIl.m10 + lllllllllllllllllIIIIIllIIlllIlI.m01 * lllllllllllllllllIIIIIllIIlllIIl.m11 + lllllllllllllllllIIIIIllIIlllIlI.m02 * lllllllllllllllllIIIIIllIIlllIIl.m12 + lllllllllllllllllIIIIIllIIlllIlI.m03 * lllllllllllllllllIIIIIllIIlllIIl.m13;
            final float lllllllllllllllllIIIIIllIlIIlIIl = lllllllllllllllllIIIIIllIIlllIlI.m00 * lllllllllllllllllIIIIIllIIlllIIl.m20 + lllllllllllllllllIIIIIllIIlllIlI.m01 * lllllllllllllllllIIIIIllIIlllIIl.m21 + lllllllllllllllllIIIIIllIIlllIlI.m02 * lllllllllllllllllIIIIIllIIlllIIl.m22 + lllllllllllllllllIIIIIllIIlllIlI.m03 * lllllllllllllllllIIIIIllIIlllIIl.m23;
            final float lllllllllllllllllIIIIIllIlIIlIII = lllllllllllllllllIIIIIllIIlllIlI.m00 * lllllllllllllllllIIIIIllIIlllIIl.m30 + lllllllllllllllllIIIIIllIIlllIlI.m01 * lllllllllllllllllIIIIIllIIlllIIl.m31 + lllllllllllllllllIIIIIllIIlllIlI.m02 * lllllllllllllllllIIIIIllIIlllIIl.m32 + lllllllllllllllllIIIIIllIIlllIlI.m03 * lllllllllllllllllIIIIIllIIlllIIl.m33;
            final float lllllllllllllllllIIIIIllIlIIIlll = lllllllllllllllllIIIIIllIIlllIlI.m10 * lllllllllllllllllIIIIIllIIlllIIl.m00 + lllllllllllllllllIIIIIllIIlllIlI.m11 * lllllllllllllllllIIIIIllIIlllIIl.m01 + lllllllllllllllllIIIIIllIIlllIlI.m12 * lllllllllllllllllIIIIIllIIlllIIl.m02 + lllllllllllllllllIIIIIllIIlllIlI.m13 * lllllllllllllllllIIIIIllIIlllIIl.m03;
            final float lllllllllllllllllIIIIIllIlIIIllI = lllllllllllllllllIIIIIllIIlllIlI.m10 * lllllllllllllllllIIIIIllIIlllIIl.m10 + lllllllllllllllllIIIIIllIIlllIlI.m11 * lllllllllllllllllIIIIIllIIlllIIl.m11 + lllllllllllllllllIIIIIllIIlllIlI.m12 * lllllllllllllllllIIIIIllIIlllIIl.m12 + lllllllllllllllllIIIIIllIIlllIlI.m13 * lllllllllllllllllIIIIIllIIlllIIl.m13;
            final float lllllllllllllllllIIIIIllIlIIIlIl = lllllllllllllllllIIIIIllIIlllIlI.m10 * lllllllllllllllllIIIIIllIIlllIIl.m20 + lllllllllllllllllIIIIIllIIlllIlI.m11 * lllllllllllllllllIIIIIllIIlllIIl.m21 + lllllllllllllllllIIIIIllIIlllIlI.m12 * lllllllllllllllllIIIIIllIIlllIIl.m22 + lllllllllllllllllIIIIIllIIlllIlI.m13 * lllllllllllllllllIIIIIllIIlllIIl.m23;
            final float lllllllllllllllllIIIIIllIlIIIlII = lllllllllllllllllIIIIIllIIlllIlI.m10 * lllllllllllllllllIIIIIllIIlllIIl.m30 + lllllllllllllllllIIIIIllIIlllIlI.m11 * lllllllllllllllllIIIIIllIIlllIIl.m31 + lllllllllllllllllIIIIIllIIlllIlI.m12 * lllllllllllllllllIIIIIllIIlllIIl.m32 + lllllllllllllllllIIIIIllIIlllIlI.m13 * lllllllllllllllllIIIIIllIIlllIIl.m33;
            final float lllllllllllllllllIIIIIllIlIIIIll = lllllllllllllllllIIIIIllIIlllIlI.m20 * lllllllllllllllllIIIIIllIIlllIIl.m00 + lllllllllllllllllIIIIIllIIlllIlI.m21 * lllllllllllllllllIIIIIllIIlllIIl.m01 + lllllllllllllllllIIIIIllIIlllIlI.m22 * lllllllllllllllllIIIIIllIIlllIIl.m02 + lllllllllllllllllIIIIIllIIlllIlI.m23 * lllllllllllllllllIIIIIllIIlllIIl.m03;
            final float lllllllllllllllllIIIIIllIlIIIIlI = lllllllllllllllllIIIIIllIIlllIlI.m20 * lllllllllllllllllIIIIIllIIlllIIl.m10 + lllllllllllllllllIIIIIllIIlllIlI.m21 * lllllllllllllllllIIIIIllIIlllIIl.m11 + lllllllllllllllllIIIIIllIIlllIlI.m22 * lllllllllllllllllIIIIIllIIlllIIl.m12 + lllllllllllllllllIIIIIllIIlllIlI.m23 * lllllllllllllllllIIIIIllIIlllIIl.m13;
            final float lllllllllllllllllIIIIIllIlIIIIIl = lllllllllllllllllIIIIIllIIlllIlI.m20 * lllllllllllllllllIIIIIllIIlllIIl.m20 + lllllllllllllllllIIIIIllIIlllIlI.m21 * lllllllllllllllllIIIIIllIIlllIIl.m21 + lllllllllllllllllIIIIIllIIlllIlI.m22 * lllllllllllllllllIIIIIllIIlllIIl.m22 + lllllllllllllllllIIIIIllIIlllIlI.m23 * lllllllllllllllllIIIIIllIIlllIIl.m23;
            final float lllllllllllllllllIIIIIllIlIIIIII = lllllllllllllllllIIIIIllIIlllIlI.m20 * lllllllllllllllllIIIIIllIIlllIIl.m30 + lllllllllllllllllIIIIIllIIlllIlI.m21 * lllllllllllllllllIIIIIllIIlllIIl.m31 + lllllllllllllllllIIIIIllIIlllIlI.m22 * lllllllllllllllllIIIIIllIIlllIIl.m32 + lllllllllllllllllIIIIIllIIlllIlI.m23 * lllllllllllllllllIIIIIllIIlllIIl.m33;
            final float lllllllllllllllllIIIIIllIIllllll = lllllllllllllllllIIIIIllIIlllIlI.m30 * lllllllllllllllllIIIIIllIIlllIIl.m00 + lllllllllllllllllIIIIIllIIlllIlI.m31 * lllllllllllllllllIIIIIllIIlllIIl.m01 + lllllllllllllllllIIIIIllIIlllIlI.m32 * lllllllllllllllllIIIIIllIIlllIIl.m02 + lllllllllllllllllIIIIIllIIlllIlI.m33 * lllllllllllllllllIIIIIllIIlllIIl.m03;
            final float lllllllllllllllllIIIIIllIIlllllI = lllllllllllllllllIIIIIllIIlllIlI.m30 * lllllllllllllllllIIIIIllIIlllIIl.m10 + lllllllllllllllllIIIIIllIIlllIlI.m31 * lllllllllllllllllIIIIIllIIlllIIl.m11 + lllllllllllllllllIIIIIllIIlllIlI.m32 * lllllllllllllllllIIIIIllIIlllIIl.m12 + lllllllllllllllllIIIIIllIIlllIlI.m33 * lllllllllllllllllIIIIIllIIlllIIl.m13;
            final float lllllllllllllllllIIIIIllIIllllIl = lllllllllllllllllIIIIIllIIlllIlI.m30 * lllllllllllllllllIIIIIllIIlllIIl.m20 + lllllllllllllllllIIIIIllIIlllIlI.m31 * lllllllllllllllllIIIIIllIIlllIIl.m21 + lllllllllllllllllIIIIIllIIlllIlI.m32 * lllllllllllllllllIIIIIllIIlllIIl.m22 + lllllllllllllllllIIIIIllIIlllIlI.m33 * lllllllllllllllllIIIIIllIIlllIIl.m23;
            final float lllllllllllllllllIIIIIllIIllllII = lllllllllllllllllIIIIIllIIlllIlI.m30 * lllllllllllllllllIIIIIllIIlllIIl.m30 + lllllllllllllllllIIIIIllIIlllIlI.m31 * lllllllllllllllllIIIIIllIIlllIIl.m31 + lllllllllllllllllIIIIIllIIlllIlI.m32 * lllllllllllllllllIIIIIllIIlllIIl.m32 + lllllllllllllllllIIIIIllIIlllIlI.m33 * lllllllllllllllllIIIIIllIIlllIIl.m33;
            this.m00 = lllllllllllllllllIIIIIllIlIIlIll;
            this.m01 = lllllllllllllllllIIIIIllIlIIlIlI;
            this.m02 = lllllllllllllllllIIIIIllIlIIlIIl;
            this.m03 = lllllllllllllllllIIIIIllIlIIlIII;
            this.m10 = lllllllllllllllllIIIIIllIlIIIlll;
            this.m11 = lllllllllllllllllIIIIIllIlIIIllI;
            this.m12 = lllllllllllllllllIIIIIllIlIIIlIl;
            this.m13 = lllllllllllllllllIIIIIllIlIIIlII;
            this.m20 = lllllllllllllllllIIIIIllIlIIIIll;
            this.m21 = lllllllllllllllllIIIIIllIlIIIIlI;
            this.m22 = lllllllllllllllllIIIIIllIlIIIIIl;
            this.m23 = lllllllllllllllllIIIIIllIlIIIIII;
            this.m30 = lllllllllllllllllIIIIIllIIllllll;
            this.m31 = lllllllllllllllllIIIIIllIIlllllI;
            this.m32 = lllllllllllllllllIIIIIllIIllllIl;
            this.m33 = lllllllllllllllllIIIIIllIIllllII;
        }
    }
    
    public Matrix4f(final float[] lllllllllllllllllIIIIllIllllIIIl) {
        this.m00 = lllllllllllllllllIIIIllIllllIIIl[0];
        this.m01 = lllllllllllllllllIIIIllIllllIIIl[1];
        this.m02 = lllllllllllllllllIIIIllIllllIIIl[2];
        this.m03 = lllllllllllllllllIIIIllIllllIIIl[3];
        this.m10 = lllllllllllllllllIIIIllIllllIIIl[4];
        this.m11 = lllllllllllllllllIIIIllIllllIIIl[5];
        this.m12 = lllllllllllllllllIIIIllIllllIIIl[6];
        this.m13 = lllllllllllllllllIIIIllIllllIIIl[7];
        this.m20 = lllllllllllllllllIIIIllIllllIIIl[8];
        this.m21 = lllllllllllllllllIIIIllIllllIIIl[9];
        this.m22 = lllllllllllllllllIIIIllIllllIIIl[10];
        this.m23 = lllllllllllllllllIIIIllIllllIIIl[11];
        this.m30 = lllllllllllllllllIIIIllIllllIIIl[12];
        this.m31 = lllllllllllllllllIIIIllIllllIIIl[13];
        this.m32 = lllllllllllllllllIIIIllIllllIIIl[14];
        this.m33 = lllllllllllllllllIIIIllIllllIIIl[15];
    }
    
    public final float getElement(final int lllllllllllllllllIIIIllIlIIlllII, final int lllllllllllllllllIIIIllIlIIllllI) {
        Label_0255: {
            switch (lllllllllllllllllIIIIllIlIIlllII) {
                case 0: {
                    switch (lllllllllllllllllIIIIllIlIIllllI) {
                        case 0: {
                            return this.m00;
                        }
                        case 1: {
                            return this.m01;
                        }
                        case 2: {
                            return this.m02;
                        }
                        case 3: {
                            return this.m03;
                        }
                        default: {
                            break Label_0255;
                        }
                    }
                    break;
                }
                case 1: {
                    switch (lllllllllllllllllIIIIllIlIIllllI) {
                        case 0: {
                            return this.m10;
                        }
                        case 1: {
                            return this.m11;
                        }
                        case 2: {
                            return this.m12;
                        }
                        case 3: {
                            return this.m13;
                        }
                        default: {
                            break Label_0255;
                        }
                    }
                    break;
                }
                case 2: {
                    switch (lllllllllllllllllIIIIllIlIIllllI) {
                        case 0: {
                            return this.m20;
                        }
                        case 1: {
                            return this.m21;
                        }
                        case 2: {
                            return this.m22;
                        }
                        case 3: {
                            return this.m23;
                        }
                        default: {
                            break Label_0255;
                        }
                    }
                    break;
                }
                case 3: {
                    switch (lllllllllllllllllIIIIllIlIIllllI) {
                        case 0: {
                            return this.m30;
                        }
                        case 1: {
                            return this.m31;
                        }
                        case 2: {
                            return this.m32;
                        }
                        case 3: {
                            return this.m33;
                        }
                        default: {
                            break Label_0255;
                        }
                    }
                    break;
                }
            }
        }
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f1"));
    }
    
    public final void setRotation(final Matrix3f lllllllllllllllllIIIIIlIIllIIIIl) {
        final double[] lllllllllllllllllIIIIIlIIllIIIII = new double[9];
        final double[] lllllllllllllllllIIIIIlIIlIlllll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIIlIIlIlllll, lllllllllllllllllIIIIIlIIllIIIII);
        this.m00 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m00 * lllllllllllllllllIIIIIlIIlIlllll[0]);
        this.m01 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m01 * lllllllllllllllllIIIIIlIIlIlllll[1]);
        this.m02 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m02 * lllllllllllllllllIIIIIlIIlIlllll[2]);
        this.m10 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m10 * lllllllllllllllllIIIIIlIIlIlllll[0]);
        this.m11 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m11 * lllllllllllllllllIIIIIlIIlIlllll[1]);
        this.m12 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m12 * lllllllllllllllllIIIIIlIIlIlllll[2]);
        this.m20 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m20 * lllllllllllllllllIIIIIlIIlIlllll[0]);
        this.m21 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m21 * lllllllllllllllllIIIIIlIIlIlllll[1]);
        this.m22 = (float)(lllllllllllllllllIIIIIlIIllIIIIl.m22 * lllllllllllllllllIIIIIlIIlIlllll[2]);
    }
    
    public final float getM12() {
        return this.m12;
    }
    
    public final void setTranslation(final Vector3f lllllllllllllllllIIIIlIIIIllllll) {
        this.m03 = lllllllllllllllllIIIIlIIIIllllll.x;
        this.m13 = lllllllllllllllllIIIIlIIIIllllll.y;
        this.m23 = lllllllllllllllllIIIIlIIIIllllll.z;
    }
    
    public final void set(final Quat4d lllllllllllllllllIIIIlIlIIlIlIlI, final Vector3d lllllllllllllllllIIIIlIlIIlIIlIl, final double lllllllllllllllllIIIIlIlIIlIIlII) {
        this.m00 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (1.0 - 2.0 * lllllllllllllllllIIIIlIlIIlIlIlI.y * lllllllllllllllllIIIIlIlIIlIlIlI.y - 2.0 * lllllllllllllllllIIIIlIlIIlIlIlI.z * lllllllllllllllllIIIIlIlIIlIlIlI.z));
        this.m10 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (2.0 * (lllllllllllllllllIIIIlIlIIlIlIlI.x * lllllllllllllllllIIIIlIlIIlIlIlI.y + lllllllllllllllllIIIIlIlIIlIlIlI.w * lllllllllllllllllIIIIlIlIIlIlIlI.z)));
        this.m20 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (2.0 * (lllllllllllllllllIIIIlIlIIlIlIlI.x * lllllllllllllllllIIIIlIlIIlIlIlI.z - lllllllllllllllllIIIIlIlIIlIlIlI.w * lllllllllllllllllIIIIlIlIIlIlIlI.y)));
        this.m01 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (2.0 * (lllllllllllllllllIIIIlIlIIlIlIlI.x * lllllllllllllllllIIIIlIlIIlIlIlI.y - lllllllllllllllllIIIIlIlIIlIlIlI.w * lllllllllllllllllIIIIlIlIIlIlIlI.z)));
        this.m11 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (1.0 - 2.0 * lllllllllllllllllIIIIlIlIIlIlIlI.x * lllllllllllllllllIIIIlIlIIlIlIlI.x - 2.0 * lllllllllllllllllIIIIlIlIIlIlIlI.z * lllllllllllllllllIIIIlIlIIlIlIlI.z));
        this.m21 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (2.0 * (lllllllllllllllllIIIIlIlIIlIlIlI.y * lllllllllllllllllIIIIlIlIIlIlIlI.z + lllllllllllllllllIIIIlIlIIlIlIlI.w * lllllllllllllllllIIIIlIlIIlIlIlI.x)));
        this.m02 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (2.0 * (lllllllllllllllllIIIIlIlIIlIlIlI.x * lllllllllllllllllIIIIlIlIIlIlIlI.z + lllllllllllllllllIIIIlIlIIlIlIlI.w * lllllllllllllllllIIIIlIlIIlIlIlI.y)));
        this.m12 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (2.0 * (lllllllllllllllllIIIIlIlIIlIlIlI.y * lllllllllllllllllIIIIlIlIIlIlIlI.z - lllllllllllllllllIIIIlIlIIlIlIlI.w * lllllllllllllllllIIIIlIlIIlIlIlI.x)));
        this.m22 = (float)(lllllllllllllllllIIIIlIlIIlIIlII * (1.0 - 2.0 * lllllllllllllllllIIIIlIlIIlIlIlI.x * lllllllllllllllllIIIIlIlIIlIlIlI.x - 2.0 * lllllllllllllllllIIIIlIlIIlIlIlI.y * lllllllllllllllllIIIIlIlIIlIlIlI.y));
        this.m03 = (float)lllllllllllllllllIIIIlIlIIlIIlIl.x;
        this.m13 = (float)lllllllllllllllllIIIIlIlIIlIIlIl.y;
        this.m23 = (float)lllllllllllllllllIIIIlIlIIlIIlIl.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void mul(final Matrix4f lllllllllllllllllIIIIIlllllIIlII) {
        final float lllllllllllllllllIIIIIllllllIlIl = this.m00 * lllllllllllllllllIIIIIlllllIIlII.m00 + this.m01 * lllllllllllllllllIIIIIlllllIIlII.m10 + this.m02 * lllllllllllllllllIIIIIlllllIIlII.m20 + this.m03 * lllllllllllllllllIIIIIlllllIIlII.m30;
        final float lllllllllllllllllIIIIIllllllIlII = this.m00 * lllllllllllllllllIIIIIlllllIIlII.m01 + this.m01 * lllllllllllllllllIIIIIlllllIIlII.m11 + this.m02 * lllllllllllllllllIIIIIlllllIIlII.m21 + this.m03 * lllllllllllllllllIIIIIlllllIIlII.m31;
        final float lllllllllllllllllIIIIIllllllIIll = this.m00 * lllllllllllllllllIIIIIlllllIIlII.m02 + this.m01 * lllllllllllllllllIIIIIlllllIIlII.m12 + this.m02 * lllllllllllllllllIIIIIlllllIIlII.m22 + this.m03 * lllllllllllllllllIIIIIlllllIIlII.m32;
        final float lllllllllllllllllIIIIIllllllIIlI = this.m00 * lllllllllllllllllIIIIIlllllIIlII.m03 + this.m01 * lllllllllllllllllIIIIIlllllIIlII.m13 + this.m02 * lllllllllllllllllIIIIIlllllIIlII.m23 + this.m03 * lllllllllllllllllIIIIIlllllIIlII.m33;
        final float lllllllllllllllllIIIIIllllllIIIl = this.m10 * lllllllllllllllllIIIIIlllllIIlII.m00 + this.m11 * lllllllllllllllllIIIIIlllllIIlII.m10 + this.m12 * lllllllllllllllllIIIIIlllllIIlII.m20 + this.m13 * lllllllllllllllllIIIIIlllllIIlII.m30;
        final float lllllllllllllllllIIIIIllllllIIII = this.m10 * lllllllllllllllllIIIIIlllllIIlII.m01 + this.m11 * lllllllllllllllllIIIIIlllllIIlII.m11 + this.m12 * lllllllllllllllllIIIIIlllllIIlII.m21 + this.m13 * lllllllllllllllllIIIIIlllllIIlII.m31;
        final float lllllllllllllllllIIIIIlllllIllll = this.m10 * lllllllllllllllllIIIIIlllllIIlII.m02 + this.m11 * lllllllllllllllllIIIIIlllllIIlII.m12 + this.m12 * lllllllllllllllllIIIIIlllllIIlII.m22 + this.m13 * lllllllllllllllllIIIIIlllllIIlII.m32;
        final float lllllllllllllllllIIIIIlllllIlllI = this.m10 * lllllllllllllllllIIIIIlllllIIlII.m03 + this.m11 * lllllllllllllllllIIIIIlllllIIlII.m13 + this.m12 * lllllllllllllllllIIIIIlllllIIlII.m23 + this.m13 * lllllllllllllllllIIIIIlllllIIlII.m33;
        final float lllllllllllllllllIIIIIlllllIllIl = this.m20 * lllllllllllllllllIIIIIlllllIIlII.m00 + this.m21 * lllllllllllllllllIIIIIlllllIIlII.m10 + this.m22 * lllllllllllllllllIIIIIlllllIIlII.m20 + this.m23 * lllllllllllllllllIIIIIlllllIIlII.m30;
        final float lllllllllllllllllIIIIIlllllIllII = this.m20 * lllllllllllllllllIIIIIlllllIIlII.m01 + this.m21 * lllllllllllllllllIIIIIlllllIIlII.m11 + this.m22 * lllllllllllllllllIIIIIlllllIIlII.m21 + this.m23 * lllllllllllllllllIIIIIlllllIIlII.m31;
        final float lllllllllllllllllIIIIIlllllIlIll = this.m20 * lllllllllllllllllIIIIIlllllIIlII.m02 + this.m21 * lllllllllllllllllIIIIIlllllIIlII.m12 + this.m22 * lllllllllllllllllIIIIIlllllIIlII.m22 + this.m23 * lllllllllllllllllIIIIIlllllIIlII.m32;
        final float lllllllllllllllllIIIIIlllllIlIlI = this.m20 * lllllllllllllllllIIIIIlllllIIlII.m03 + this.m21 * lllllllllllllllllIIIIIlllllIIlII.m13 + this.m22 * lllllllllllllllllIIIIIlllllIIlII.m23 + this.m23 * lllllllllllllllllIIIIIlllllIIlII.m33;
        final float lllllllllllllllllIIIIIlllllIlIIl = this.m30 * lllllllllllllllllIIIIIlllllIIlII.m00 + this.m31 * lllllllllllllllllIIIIIlllllIIlII.m10 + this.m32 * lllllllllllllllllIIIIIlllllIIlII.m20 + this.m33 * lllllllllllllllllIIIIIlllllIIlII.m30;
        final float lllllllllllllllllIIIIIlllllIlIII = this.m30 * lllllllllllllllllIIIIIlllllIIlII.m01 + this.m31 * lllllllllllllllllIIIIIlllllIIlII.m11 + this.m32 * lllllllllllllllllIIIIIlllllIIlII.m21 + this.m33 * lllllllllllllllllIIIIIlllllIIlII.m31;
        final float lllllllllllllllllIIIIIlllllIIlll = this.m30 * lllllllllllllllllIIIIIlllllIIlII.m02 + this.m31 * lllllllllllllllllIIIIIlllllIIlII.m12 + this.m32 * lllllllllllllllllIIIIIlllllIIlII.m22 + this.m33 * lllllllllllllllllIIIIIlllllIIlII.m32;
        final float lllllllllllllllllIIIIIlllllIIllI = this.m30 * lllllllllllllllllIIIIIlllllIIlII.m03 + this.m31 * lllllllllllllllllIIIIIlllllIIlII.m13 + this.m32 * lllllllllllllllllIIIIIlllllIIlII.m23 + this.m33 * lllllllllllllllllIIIIIlllllIIlII.m33;
        this.m00 = lllllllllllllllllIIIIIllllllIlIl;
        this.m01 = lllllllllllllllllIIIIIllllllIlII;
        this.m02 = lllllllllllllllllIIIIIllllllIIll;
        this.m03 = lllllllllllllllllIIIIIllllllIIlI;
        this.m10 = lllllllllllllllllIIIIIllllllIIIl;
        this.m11 = lllllllllllllllllIIIIIllllllIIII;
        this.m12 = lllllllllllllllllIIIIIlllllIllll;
        this.m13 = lllllllllllllllllIIIIIlllllIlllI;
        this.m20 = lllllllllllllllllIIIIIlllllIllIl;
        this.m21 = lllllllllllllllllIIIIIlllllIllII;
        this.m22 = lllllllllllllllllIIIIIlllllIlIll;
        this.m23 = lllllllllllllllllIIIIIlllllIlIlI;
        this.m30 = lllllllllllllllllIIIIIlllllIlIIl;
        this.m31 = lllllllllllllllllIIIIIlllllIlIII;
        this.m32 = lllllllllllllllllIIIIIlllllIIlll;
        this.m33 = lllllllllllllllllIIIIIlllllIIllI;
    }
    
    public final void add(final Matrix4f lllllllllllllllllIIIIlIllIlllllI, final Matrix4f lllllllllllllllllIIIIlIllIlllIlI) {
        this.m00 = lllllllllllllllllIIIIlIllIlllllI.m00 + lllllllllllllllllIIIIlIllIlllIlI.m00;
        this.m01 = lllllllllllllllllIIIIlIllIlllllI.m01 + lllllllllllllllllIIIIlIllIlllIlI.m01;
        this.m02 = lllllllllllllllllIIIIlIllIlllllI.m02 + lllllllllllllllllIIIIlIllIlllIlI.m02;
        this.m03 = lllllllllllllllllIIIIlIllIlllllI.m03 + lllllllllllllllllIIIIlIllIlllIlI.m03;
        this.m10 = lllllllllllllllllIIIIlIllIlllllI.m10 + lllllllllllllllllIIIIlIllIlllIlI.m10;
        this.m11 = lllllllllllllllllIIIIlIllIlllllI.m11 + lllllllllllllllllIIIIlIllIlllIlI.m11;
        this.m12 = lllllllllllllllllIIIIlIllIlllllI.m12 + lllllllllllllllllIIIIlIllIlllIlI.m12;
        this.m13 = lllllllllllllllllIIIIlIllIlllllI.m13 + lllllllllllllllllIIIIlIllIlllIlI.m13;
        this.m20 = lllllllllllllllllIIIIlIllIlllllI.m20 + lllllllllllllllllIIIIlIllIlllIlI.m20;
        this.m21 = lllllllllllllllllIIIIlIllIlllllI.m21 + lllllllllllllllllIIIIlIllIlllIlI.m21;
        this.m22 = lllllllllllllllllIIIIlIllIlllllI.m22 + lllllllllllllllllIIIIlIllIlllIlI.m22;
        this.m23 = lllllllllllllllllIIIIlIllIlllllI.m23 + lllllllllllllllllIIIIlIllIlllIlI.m23;
        this.m30 = lllllllllllllllllIIIIlIllIlllllI.m30 + lllllllllllllllllIIIIlIllIlllIlI.m30;
        this.m31 = lllllllllllllllllIIIIlIllIlllllI.m31 + lllllllllllllllllIIIIlIllIlllIlI.m31;
        this.m32 = lllllllllllllllllIIIIlIllIlllllI.m32 + lllllllllllllllllIIIIlIllIlllIlI.m32;
        this.m33 = lllllllllllllllllIIIIlIllIlllllI.m33 + lllllllllllllllllIIIIlIllIlllIlI.m33;
    }
    
    public final void transpose() {
        float lllllllllllllllllIIIIlIllIIIllII = this.m10;
        this.m10 = this.m01;
        this.m01 = lllllllllllllllllIIIIlIllIIIllII;
        lllllllllllllllllIIIIlIllIIIllII = this.m20;
        this.m20 = this.m02;
        this.m02 = lllllllllllllllllIIIIlIllIIIllII;
        lllllllllllllllllIIIIlIllIIIllII = this.m30;
        this.m30 = this.m03;
        this.m03 = lllllllllllllllllIIIIlIllIIIllII;
        lllllllllllllllllIIIIlIllIIIllII = this.m21;
        this.m21 = this.m12;
        this.m12 = lllllllllllllllllIIIIlIllIIIllII;
        lllllllllllllllllIIIIlIllIIIllII = this.m31;
        this.m31 = this.m13;
        this.m13 = lllllllllllllllllIIIIlIllIIIllII;
        lllllllllllllllllIIIIlIllIIIllII = this.m32;
        this.m32 = this.m23;
        this.m23 = lllllllllllllllllIIIIlIllIIIllII;
    }
    
    public final void mulTransposeLeft(final Matrix4f lllllllllllllllllIIIIIllIIIlIlII, final Matrix4f lllllllllllllllllIIIIIllIIIlIIll) {
        if (this != lllllllllllllllllIIIIIllIIIlIlII && this != lllllllllllllllllIIIIIllIIIlIIll) {
            this.m00 = lllllllllllllllllIIIIIllIIIlIlII.m00 * lllllllllllllllllIIIIIllIIIlIIll.m00 + lllllllllllllllllIIIIIllIIIlIlII.m10 * lllllllllllllllllIIIIIllIIIlIIll.m10 + lllllllllllllllllIIIIIllIIIlIlII.m20 * lllllllllllllllllIIIIIllIIIlIIll.m20 + lllllllllllllllllIIIIIllIIIlIlII.m30 * lllllllllllllllllIIIIIllIIIlIIll.m30;
            this.m01 = lllllllllllllllllIIIIIllIIIlIlII.m00 * lllllllllllllllllIIIIIllIIIlIIll.m01 + lllllllllllllllllIIIIIllIIIlIlII.m10 * lllllllllllllllllIIIIIllIIIlIIll.m11 + lllllllllllllllllIIIIIllIIIlIlII.m20 * lllllllllllllllllIIIIIllIIIlIIll.m21 + lllllllllllllllllIIIIIllIIIlIlII.m30 * lllllllllllllllllIIIIIllIIIlIIll.m31;
            this.m02 = lllllllllllllllllIIIIIllIIIlIlII.m00 * lllllllllllllllllIIIIIllIIIlIIll.m02 + lllllllllllllllllIIIIIllIIIlIlII.m10 * lllllllllllllllllIIIIIllIIIlIIll.m12 + lllllllllllllllllIIIIIllIIIlIlII.m20 * lllllllllllllllllIIIIIllIIIlIIll.m22 + lllllllllllllllllIIIIIllIIIlIlII.m30 * lllllllllllllllllIIIIIllIIIlIIll.m32;
            this.m03 = lllllllllllllllllIIIIIllIIIlIlII.m00 * lllllllllllllllllIIIIIllIIIlIIll.m03 + lllllllllllllllllIIIIIllIIIlIlII.m10 * lllllllllllllllllIIIIIllIIIlIIll.m13 + lllllllllllllllllIIIIIllIIIlIlII.m20 * lllllllllllllllllIIIIIllIIIlIIll.m23 + lllllllllllllllllIIIIIllIIIlIlII.m30 * lllllllllllllllllIIIIIllIIIlIIll.m33;
            this.m10 = lllllllllllllllllIIIIIllIIIlIlII.m01 * lllllllllllllllllIIIIIllIIIlIIll.m00 + lllllllllllllllllIIIIIllIIIlIlII.m11 * lllllllllllllllllIIIIIllIIIlIIll.m10 + lllllllllllllllllIIIIIllIIIlIlII.m21 * lllllllllllllllllIIIIIllIIIlIIll.m20 + lllllllllllllllllIIIIIllIIIlIlII.m31 * lllllllllllllllllIIIIIllIIIlIIll.m30;
            this.m11 = lllllllllllllllllIIIIIllIIIlIlII.m01 * lllllllllllllllllIIIIIllIIIlIIll.m01 + lllllllllllllllllIIIIIllIIIlIlII.m11 * lllllllllllllllllIIIIIllIIIlIIll.m11 + lllllllllllllllllIIIIIllIIIlIlII.m21 * lllllllllllllllllIIIIIllIIIlIIll.m21 + lllllllllllllllllIIIIIllIIIlIlII.m31 * lllllllllllllllllIIIIIllIIIlIIll.m31;
            this.m12 = lllllllllllllllllIIIIIllIIIlIlII.m01 * lllllllllllllllllIIIIIllIIIlIIll.m02 + lllllllllllllllllIIIIIllIIIlIlII.m11 * lllllllllllllllllIIIIIllIIIlIIll.m12 + lllllllllllllllllIIIIIllIIIlIlII.m21 * lllllllllllllllllIIIIIllIIIlIIll.m22 + lllllllllllllllllIIIIIllIIIlIlII.m31 * lllllllllllllllllIIIIIllIIIlIIll.m32;
            this.m13 = lllllllllllllllllIIIIIllIIIlIlII.m01 * lllllllllllllllllIIIIIllIIIlIIll.m03 + lllllllllllllllllIIIIIllIIIlIlII.m11 * lllllllllllllllllIIIIIllIIIlIIll.m13 + lllllllllllllllllIIIIIllIIIlIlII.m21 * lllllllllllllllllIIIIIllIIIlIIll.m23 + lllllllllllllllllIIIIIllIIIlIlII.m31 * lllllllllllllllllIIIIIllIIIlIIll.m33;
            this.m20 = lllllllllllllllllIIIIIllIIIlIlII.m02 * lllllllllllllllllIIIIIllIIIlIIll.m00 + lllllllllllllllllIIIIIllIIIlIlII.m12 * lllllllllllllllllIIIIIllIIIlIIll.m10 + lllllllllllllllllIIIIIllIIIlIlII.m22 * lllllllllllllllllIIIIIllIIIlIIll.m20 + lllllllllllllllllIIIIIllIIIlIlII.m32 * lllllllllllllllllIIIIIllIIIlIIll.m30;
            this.m21 = lllllllllllllllllIIIIIllIIIlIlII.m02 * lllllllllllllllllIIIIIllIIIlIIll.m01 + lllllllllllllllllIIIIIllIIIlIlII.m12 * lllllllllllllllllIIIIIllIIIlIIll.m11 + lllllllllllllllllIIIIIllIIIlIlII.m22 * lllllllllllllllllIIIIIllIIIlIIll.m21 + lllllllllllllllllIIIIIllIIIlIlII.m32 * lllllllllllllllllIIIIIllIIIlIIll.m31;
            this.m22 = lllllllllllllllllIIIIIllIIIlIlII.m02 * lllllllllllllllllIIIIIllIIIlIIll.m02 + lllllllllllllllllIIIIIllIIIlIlII.m12 * lllllllllllllllllIIIIIllIIIlIIll.m12 + lllllllllllllllllIIIIIllIIIlIlII.m22 * lllllllllllllllllIIIIIllIIIlIIll.m22 + lllllllllllllllllIIIIIllIIIlIlII.m32 * lllllllllllllllllIIIIIllIIIlIIll.m32;
            this.m23 = lllllllllllllllllIIIIIllIIIlIlII.m02 * lllllllllllllllllIIIIIllIIIlIIll.m03 + lllllllllllllllllIIIIIllIIIlIlII.m12 * lllllllllllllllllIIIIIllIIIlIIll.m13 + lllllllllllllllllIIIIIllIIIlIlII.m22 * lllllllllllllllllIIIIIllIIIlIIll.m23 + lllllllllllllllllIIIIIllIIIlIlII.m32 * lllllllllllllllllIIIIIllIIIlIIll.m33;
            this.m30 = lllllllllllllllllIIIIIllIIIlIlII.m03 * lllllllllllllllllIIIIIllIIIlIIll.m00 + lllllllllllllllllIIIIIllIIIlIlII.m13 * lllllllllllllllllIIIIIllIIIlIIll.m10 + lllllllllllllllllIIIIIllIIIlIlII.m23 * lllllllllllllllllIIIIIllIIIlIIll.m20 + lllllllllllllllllIIIIIllIIIlIlII.m33 * lllllllllllllllllIIIIIllIIIlIIll.m30;
            this.m31 = lllllllllllllllllIIIIIllIIIlIlII.m03 * lllllllllllllllllIIIIIllIIIlIIll.m01 + lllllllllllllllllIIIIIllIIIlIlII.m13 * lllllllllllllllllIIIIIllIIIlIIll.m11 + lllllllllllllllllIIIIIllIIIlIlII.m23 * lllllllllllllllllIIIIIllIIIlIIll.m21 + lllllllllllllllllIIIIIllIIIlIlII.m33 * lllllllllllllllllIIIIIllIIIlIIll.m31;
            this.m32 = lllllllllllllllllIIIIIllIIIlIlII.m03 * lllllllllllllllllIIIIIllIIIlIIll.m02 + lllllllllllllllllIIIIIllIIIlIlII.m13 * lllllllllllllllllIIIIIllIIIlIIll.m12 + lllllllllllllllllIIIIIllIIIlIlII.m23 * lllllllllllllllllIIIIIllIIIlIIll.m22 + lllllllllllllllllIIIIIllIIIlIlII.m33 * lllllllllllllllllIIIIIllIIIlIIll.m32;
            this.m33 = lllllllllllllllllIIIIIllIIIlIlII.m03 * lllllllllllllllllIIIIIllIIIlIIll.m03 + lllllllllllllllllIIIIIllIIIlIlII.m13 * lllllllllllllllllIIIIIllIIIlIIll.m13 + lllllllllllllllllIIIIIllIIIlIlII.m23 * lllllllllllllllllIIIIIllIIIlIIll.m23 + lllllllllllllllllIIIIIllIIIlIlII.m33 * lllllllllllllllllIIIIIllIIIlIIll.m33;
        }
        else {
            final float lllllllllllllllllIIIIIllIIIlIIlI = lllllllllllllllllIIIIIllIIIlIlII.m00 * lllllllllllllllllIIIIIllIIIlIIll.m00 + lllllllllllllllllIIIIIllIIIlIlII.m10 * lllllllllllllllllIIIIIllIIIlIIll.m10 + lllllllllllllllllIIIIIllIIIlIlII.m20 * lllllllllllllllllIIIIIllIIIlIIll.m20 + lllllllllllllllllIIIIIllIIIlIlII.m30 * lllllllllllllllllIIIIIllIIIlIIll.m30;
            final float lllllllllllllllllIIIIIllIIIlIIIl = lllllllllllllllllIIIIIllIIIlIlII.m00 * lllllllllllllllllIIIIIllIIIlIIll.m01 + lllllllllllllllllIIIIIllIIIlIlII.m10 * lllllllllllllllllIIIIIllIIIlIIll.m11 + lllllllllllllllllIIIIIllIIIlIlII.m20 * lllllllllllllllllIIIIIllIIIlIIll.m21 + lllllllllllllllllIIIIIllIIIlIlII.m30 * lllllllllllllllllIIIIIllIIIlIIll.m31;
            final float lllllllllllllllllIIIIIllIIIlIIII = lllllllllllllllllIIIIIllIIIlIlII.m00 * lllllllllllllllllIIIIIllIIIlIIll.m02 + lllllllllllllllllIIIIIllIIIlIlII.m10 * lllllllllllllllllIIIIIllIIIlIIll.m12 + lllllllllllllllllIIIIIllIIIlIlII.m20 * lllllllllllllllllIIIIIllIIIlIIll.m22 + lllllllllllllllllIIIIIllIIIlIlII.m30 * lllllllllllllllllIIIIIllIIIlIIll.m32;
            final float lllllllllllllllllIIIIIllIIIIllll = lllllllllllllllllIIIIIllIIIlIlII.m00 * lllllllllllllllllIIIIIllIIIlIIll.m03 + lllllllllllllllllIIIIIllIIIlIlII.m10 * lllllllllllllllllIIIIIllIIIlIIll.m13 + lllllllllllllllllIIIIIllIIIlIlII.m20 * lllllllllllllllllIIIIIllIIIlIIll.m23 + lllllllllllllllllIIIIIllIIIlIlII.m30 * lllllllllllllllllIIIIIllIIIlIIll.m33;
            final float lllllllllllllllllIIIIIllIIIIlllI = lllllllllllllllllIIIIIllIIIlIlII.m01 * lllllllllllllllllIIIIIllIIIlIIll.m00 + lllllllllllllllllIIIIIllIIIlIlII.m11 * lllllllllllllllllIIIIIllIIIlIIll.m10 + lllllllllllllllllIIIIIllIIIlIlII.m21 * lllllllllllllllllIIIIIllIIIlIIll.m20 + lllllllllllllllllIIIIIllIIIlIlII.m31 * lllllllllllllllllIIIIIllIIIlIIll.m30;
            final float lllllllllllllllllIIIIIllIIIIllIl = lllllllllllllllllIIIIIllIIIlIlII.m01 * lllllllllllllllllIIIIIllIIIlIIll.m01 + lllllllllllllllllIIIIIllIIIlIlII.m11 * lllllllllllllllllIIIIIllIIIlIIll.m11 + lllllllllllllllllIIIIIllIIIlIlII.m21 * lllllllllllllllllIIIIIllIIIlIIll.m21 + lllllllllllllllllIIIIIllIIIlIlII.m31 * lllllllllllllllllIIIIIllIIIlIIll.m31;
            final float lllllllllllllllllIIIIIllIIIIllII = lllllllllllllllllIIIIIllIIIlIlII.m01 * lllllllllllllllllIIIIIllIIIlIIll.m02 + lllllllllllllllllIIIIIllIIIlIlII.m11 * lllllllllllllllllIIIIIllIIIlIIll.m12 + lllllllllllllllllIIIIIllIIIlIlII.m21 * lllllllllllllllllIIIIIllIIIlIIll.m22 + lllllllllllllllllIIIIIllIIIlIlII.m31 * lllllllllllllllllIIIIIllIIIlIIll.m32;
            final float lllllllllllllllllIIIIIllIIIIlIll = lllllllllllllllllIIIIIllIIIlIlII.m01 * lllllllllllllllllIIIIIllIIIlIIll.m03 + lllllllllllllllllIIIIIllIIIlIlII.m11 * lllllllllllllllllIIIIIllIIIlIIll.m13 + lllllllllllllllllIIIIIllIIIlIlII.m21 * lllllllllllllllllIIIIIllIIIlIIll.m23 + lllllllllllllllllIIIIIllIIIlIlII.m31 * lllllllllllllllllIIIIIllIIIlIIll.m33;
            final float lllllllllllllllllIIIIIllIIIIlIlI = lllllllllllllllllIIIIIllIIIlIlII.m02 * lllllllllllllllllIIIIIllIIIlIIll.m00 + lllllllllllllllllIIIIIllIIIlIlII.m12 * lllllllllllllllllIIIIIllIIIlIIll.m10 + lllllllllllllllllIIIIIllIIIlIlII.m22 * lllllllllllllllllIIIIIllIIIlIIll.m20 + lllllllllllllllllIIIIIllIIIlIlII.m32 * lllllllllllllllllIIIIIllIIIlIIll.m30;
            final float lllllllllllllllllIIIIIllIIIIlIIl = lllllllllllllllllIIIIIllIIIlIlII.m02 * lllllllllllllllllIIIIIllIIIlIIll.m01 + lllllllllllllllllIIIIIllIIIlIlII.m12 * lllllllllllllllllIIIIIllIIIlIIll.m11 + lllllllllllllllllIIIIIllIIIlIlII.m22 * lllllllllllllllllIIIIIllIIIlIIll.m21 + lllllllllllllllllIIIIIllIIIlIlII.m32 * lllllllllllllllllIIIIIllIIIlIIll.m31;
            final float lllllllllllllllllIIIIIllIIIIlIII = lllllllllllllllllIIIIIllIIIlIlII.m02 * lllllllllllllllllIIIIIllIIIlIIll.m02 + lllllllllllllllllIIIIIllIIIlIlII.m12 * lllllllllllllllllIIIIIllIIIlIIll.m12 + lllllllllllllllllIIIIIllIIIlIlII.m22 * lllllllllllllllllIIIIIllIIIlIIll.m22 + lllllllllllllllllIIIIIllIIIlIlII.m32 * lllllllllllllllllIIIIIllIIIlIIll.m32;
            final float lllllllllllllllllIIIIIllIIIIIlll = lllllllllllllllllIIIIIllIIIlIlII.m02 * lllllllllllllllllIIIIIllIIIlIIll.m03 + lllllllllllllllllIIIIIllIIIlIlII.m12 * lllllllllllllllllIIIIIllIIIlIIll.m13 + lllllllllllllllllIIIIIllIIIlIlII.m22 * lllllllllllllllllIIIIIllIIIlIIll.m23 + lllllllllllllllllIIIIIllIIIlIlII.m32 * lllllllllllllllllIIIIIllIIIlIIll.m33;
            final float lllllllllllllllllIIIIIllIIIIIllI = lllllllllllllllllIIIIIllIIIlIlII.m03 * lllllllllllllllllIIIIIllIIIlIIll.m00 + lllllllllllllllllIIIIIllIIIlIlII.m13 * lllllllllllllllllIIIIIllIIIlIIll.m10 + lllllllllllllllllIIIIIllIIIlIlII.m23 * lllllllllllllllllIIIIIllIIIlIIll.m20 + lllllllllllllllllIIIIIllIIIlIlII.m33 * lllllllllllllllllIIIIIllIIIlIIll.m30;
            final float lllllllllllllllllIIIIIllIIIIIlIl = lllllllllllllllllIIIIIllIIIlIlII.m03 * lllllllllllllllllIIIIIllIIIlIIll.m01 + lllllllllllllllllIIIIIllIIIlIlII.m13 * lllllllllllllllllIIIIIllIIIlIIll.m11 + lllllllllllllllllIIIIIllIIIlIlII.m23 * lllllllllllllllllIIIIIllIIIlIIll.m21 + lllllllllllllllllIIIIIllIIIlIlII.m33 * lllllllllllllllllIIIIIllIIIlIIll.m31;
            final float lllllllllllllllllIIIIIllIIIIIlII = lllllllllllllllllIIIIIllIIIlIlII.m03 * lllllllllllllllllIIIIIllIIIlIIll.m02 + lllllllllllllllllIIIIIllIIIlIlII.m13 * lllllllllllllllllIIIIIllIIIlIIll.m12 + lllllllllllllllllIIIIIllIIIlIlII.m23 * lllllllllllllllllIIIIIllIIIlIIll.m22 + lllllllllllllllllIIIIIllIIIlIlII.m33 * lllllllllllllllllIIIIIllIIIlIIll.m32;
            final float lllllllllllllllllIIIIIllIIIIIIll = lllllllllllllllllIIIIIllIIIlIlII.m03 * lllllllllllllllllIIIIIllIIIlIIll.m03 + lllllllllllllllllIIIIIllIIIlIlII.m13 * lllllllllllllllllIIIIIllIIIlIIll.m13 + lllllllllllllllllIIIIIllIIIlIlII.m23 * lllllllllllllllllIIIIIllIIIlIIll.m23 + lllllllllllllllllIIIIIllIIIlIlII.m33 * lllllllllllllllllIIIIIllIIIlIIll.m33;
            this.m00 = lllllllllllllllllIIIIIllIIIlIIlI;
            this.m01 = lllllllllllllllllIIIIIllIIIlIIIl;
            this.m02 = lllllllllllllllllIIIIIllIIIlIIII;
            this.m03 = lllllllllllllllllIIIIIllIIIIllll;
            this.m10 = lllllllllllllllllIIIIIllIIIIlllI;
            this.m11 = lllllllllllllllllIIIIIllIIIIllIl;
            this.m12 = lllllllllllllllllIIIIIllIIIIllII;
            this.m13 = lllllllllllllllllIIIIIllIIIIlIll;
            this.m20 = lllllllllllllllllIIIIIllIIIIlIlI;
            this.m21 = lllllllllllllllllIIIIIllIIIIlIIl;
            this.m22 = lllllllllllllllllIIIIIllIIIIlIII;
            this.m23 = lllllllllllllllllIIIIIllIIIIIlll;
            this.m30 = lllllllllllllllllIIIIIllIIIIIllI;
            this.m31 = lllllllllllllllllIIIIIllIIIIIlIl;
            this.m32 = lllllllllllllllllIIIIIllIIIIIlII;
            this.m33 = lllllllllllllllllIIIIIllIIIIIIll;
        }
    }
    
    public final void setRotation(final Quat4f lllllllllllllllllIIIIIlIIlIlIlIl) {
        final double[] lllllllllllllllllIIIIIlIIlIlIlII = new double[9];
        final double[] lllllllllllllllllIIIIIlIIlIlIIll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIIlIIlIlIIll, lllllllllllllllllIIIIIlIIlIlIlII);
        this.m00 = (float)((1.0f - 2.0f * lllllllllllllllllIIIIIlIIlIlIlIl.y * lllllllllllllllllIIIIIlIIlIlIlIl.y - 2.0f * lllllllllllllllllIIIIIlIIlIlIlIl.z * lllllllllllllllllIIIIIlIIlIlIlIl.z) * lllllllllllllllllIIIIIlIIlIlIIll[0]);
        this.m10 = (float)(2.0f * (lllllllllllllllllIIIIIlIIlIlIlIl.x * lllllllllllllllllIIIIIlIIlIlIlIl.y + lllllllllllllllllIIIIIlIIlIlIlIl.w * lllllllllllllllllIIIIIlIIlIlIlIl.z) * lllllllllllllllllIIIIIlIIlIlIIll[0]);
        this.m20 = (float)(2.0f * (lllllllllllllllllIIIIIlIIlIlIlIl.x * lllllllllllllllllIIIIIlIIlIlIlIl.z - lllllllllllllllllIIIIIlIIlIlIlIl.w * lllllllllllllllllIIIIIlIIlIlIlIl.y) * lllllllllllllllllIIIIIlIIlIlIIll[0]);
        this.m01 = (float)(2.0f * (lllllllllllllllllIIIIIlIIlIlIlIl.x * lllllllllllllllllIIIIIlIIlIlIlIl.y - lllllllllllllllllIIIIIlIIlIlIlIl.w * lllllllllllllllllIIIIIlIIlIlIlIl.z) * lllllllllllllllllIIIIIlIIlIlIIll[1]);
        this.m11 = (float)((1.0f - 2.0f * lllllllllllllllllIIIIIlIIlIlIlIl.x * lllllllllllllllllIIIIIlIIlIlIlIl.x - 2.0f * lllllllllllllllllIIIIIlIIlIlIlIl.z * lllllllllllllllllIIIIIlIIlIlIlIl.z) * lllllllllllllllllIIIIIlIIlIlIIll[1]);
        this.m21 = (float)(2.0f * (lllllllllllllllllIIIIIlIIlIlIlIl.y * lllllllllllllllllIIIIIlIIlIlIlIl.z + lllllllllllllllllIIIIIlIIlIlIlIl.w * lllllllllllllllllIIIIIlIIlIlIlIl.x) * lllllllllllllllllIIIIIlIIlIlIIll[1]);
        this.m02 = (float)(2.0f * (lllllllllllllllllIIIIIlIIlIlIlIl.x * lllllllllllllllllIIIIIlIIlIlIlIl.z + lllllllllllllllllIIIIIlIIlIlIlIl.w * lllllllllllllllllIIIIIlIIlIlIlIl.y) * lllllllllllllllllIIIIIlIIlIlIIll[2]);
        this.m12 = (float)(2.0f * (lllllllllllllllllIIIIIlIIlIlIlIl.y * lllllllllllllllllIIIIIlIIlIlIlIl.z - lllllllllllllllllIIIIIlIIlIlIlIl.w * lllllllllllllllllIIIIIlIIlIlIlIl.x) * lllllllllllllllllIIIIIlIIlIlIIll[2]);
        this.m22 = (float)((1.0f - 2.0f * lllllllllllllllllIIIIIlIIlIlIlIl.x * lllllllllllllllllIIIIIlIIlIlIlIl.x - 2.0f * lllllllllllllllllIIIIIlIIlIlIlIl.y * lllllllllllllllllIIIIIlIIlIlIlIl.y) * lllllllllllllllllIIIIIlIIlIlIIll[2]);
    }
    
    public final void setScale(final float lllllllllllllllllIIIIllIIlllIIIl) {
        final double[] lllllllllllllllllIIIIllIIlllIIII = new double[9];
        final double[] lllllllllllllllllIIIIllIIllIllll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIllIIllIllll, lllllllllllllllllIIIIllIIlllIIII);
        this.m00 = (float)(lllllllllllllllllIIIIllIIlllIIII[0] * lllllllllllllllllIIIIllIIlllIIIl);
        this.m01 = (float)(lllllllllllllllllIIIIllIIlllIIII[1] * lllllllllllllllllIIIIllIIlllIIIl);
        this.m02 = (float)(lllllllllllllllllIIIIllIIlllIIII[2] * lllllllllllllllllIIIIllIIlllIIIl);
        this.m10 = (float)(lllllllllllllllllIIIIllIIlllIIII[3] * lllllllllllllllllIIIIllIIlllIIIl);
        this.m11 = (float)(lllllllllllllllllIIIIllIIlllIIII[4] * lllllllllllllllllIIIIllIIlllIIIl);
        this.m12 = (float)(lllllllllllllllllIIIIllIIlllIIII[5] * lllllllllllllllllIIIIllIIlllIIIl);
        this.m20 = (float)(lllllllllllllllllIIIIllIIlllIIII[6] * lllllllllllllllllIIIIllIIlllIIIl);
        this.m21 = (float)(lllllllllllllllllIIIIllIIlllIIII[7] * lllllllllllllllllIIIIllIIlllIIIl);
        this.m22 = (float)(lllllllllllllllllIIIIllIIlllIIII[8] * lllllllllllllllllIIIIllIIlllIIIl);
    }
    
    public final void setRotation(final Quat4d lllllllllllllllllIIIIIlIIlIIlIIl) {
        final double[] lllllllllllllllllIIIIIlIIlIIlIII = new double[9];
        final double[] lllllllllllllllllIIIIIlIIlIIIlll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIIlIIlIIIlll, lllllllllllllllllIIIIIlIIlIIlIII);
        this.m00 = (float)((1.0 - 2.0 * lllllllllllllllllIIIIIlIIlIIlIIl.y * lllllllllllllllllIIIIIlIIlIIlIIl.y - 2.0 * lllllllllllllllllIIIIIlIIlIIlIIl.z * lllllllllllllllllIIIIIlIIlIIlIIl.z) * lllllllllllllllllIIIIIlIIlIIIlll[0]);
        this.m10 = (float)(2.0 * (lllllllllllllllllIIIIIlIIlIIlIIl.x * lllllllllllllllllIIIIIlIIlIIlIIl.y + lllllllllllllllllIIIIIlIIlIIlIIl.w * lllllllllllllllllIIIIIlIIlIIlIIl.z) * lllllllllllllllllIIIIIlIIlIIIlll[0]);
        this.m20 = (float)(2.0 * (lllllllllllllllllIIIIIlIIlIIlIIl.x * lllllllllllllllllIIIIIlIIlIIlIIl.z - lllllllllllllllllIIIIIlIIlIIlIIl.w * lllllllllllllllllIIIIIlIIlIIlIIl.y) * lllllllllllllllllIIIIIlIIlIIIlll[0]);
        this.m01 = (float)(2.0 * (lllllllllllllllllIIIIIlIIlIIlIIl.x * lllllllllllllllllIIIIIlIIlIIlIIl.y - lllllllllllllllllIIIIIlIIlIIlIIl.w * lllllllllllllllllIIIIIlIIlIIlIIl.z) * lllllllllllllllllIIIIIlIIlIIIlll[1]);
        this.m11 = (float)((1.0 - 2.0 * lllllllllllllllllIIIIIlIIlIIlIIl.x * lllllllllllllllllIIIIIlIIlIIlIIl.x - 2.0 * lllllllllllllllllIIIIIlIIlIIlIIl.z * lllllllllllllllllIIIIIlIIlIIlIIl.z) * lllllllllllllllllIIIIIlIIlIIIlll[1]);
        this.m21 = (float)(2.0 * (lllllllllllllllllIIIIIlIIlIIlIIl.y * lllllllllllllllllIIIIIlIIlIIlIIl.z + lllllllllllllllllIIIIIlIIlIIlIIl.w * lllllllllllllllllIIIIIlIIlIIlIIl.x) * lllllllllllllllllIIIIIlIIlIIIlll[1]);
        this.m02 = (float)(2.0 * (lllllllllllllllllIIIIIlIIlIIlIIl.x * lllllllllllllllllIIIIIlIIlIIlIIl.z + lllllllllllllllllIIIIIlIIlIIlIIl.w * lllllllllllllllllIIIIIlIIlIIlIIl.y) * lllllllllllllllllIIIIIlIIlIIIlll[2]);
        this.m12 = (float)(2.0 * (lllllllllllllllllIIIIIlIIlIIlIIl.y * lllllllllllllllllIIIIIlIIlIIlIIl.z - lllllllllllllllllIIIIIlIIlIIlIIl.w * lllllllllllllllllIIIIIlIIlIIlIIl.x) * lllllllllllllllllIIIIIlIIlIIIlll[2]);
        this.m22 = (float)((1.0 - 2.0 * lllllllllllllllllIIIIIlIIlIIlIIl.x * lllllllllllllllllIIIIIlIIlIIlIIl.x - 2.0 * lllllllllllllllllIIIIIlIIlIIlIIl.y * lllllllllllllllllIIIIIlIIlIIlIIl.y) * lllllllllllllllllIIIIIlIIlIIIlll[2]);
    }
    
    public final float getM21() {
        return this.m21;
    }
    
    public final void getRow(final int lllllllllllllllllIIIIllIlIIIlIlI, final float[] lllllllllllllllllIIIIllIlIIIlIIl) {
        if (lllllllllllllllllIIIIllIlIIIlIlI == 0) {
            lllllllllllllllllIIIIllIlIIIlIIl[0] = this.m00;
            lllllllllllllllllIIIIllIlIIIlIIl[1] = this.m01;
            lllllllllllllllllIIIIllIlIIIlIIl[2] = this.m02;
            lllllllllllllllllIIIIllIlIIIlIIl[3] = this.m03;
        }
        else if (lllllllllllllllllIIIIllIlIIIlIlI == 1) {
            lllllllllllllllllIIIIllIlIIIlIIl[0] = this.m10;
            lllllllllllllllllIIIIllIlIIIlIIl[1] = this.m11;
            lllllllllllllllllIIIIllIlIIIlIIl[2] = this.m12;
            lllllllllllllllllIIIIllIlIIIlIIl[3] = this.m13;
        }
        else if (lllllllllllllllllIIIIllIlIIIlIlI == 2) {
            lllllllllllllllllIIIIllIlIIIlIIl[0] = this.m20;
            lllllllllllllllllIIIIllIlIIIlIIl[1] = this.m21;
            lllllllllllllllllIIIIllIlIIIlIIl[2] = this.m22;
            lllllllllllllllllIIIIllIlIIIlIIl[3] = this.m23;
        }
        else {
            if (lllllllllllllllllIIIIllIlIIIlIlI != 3) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f2"));
            }
            lllllllllllllllllIIIIllIlIIIlIIl[0] = this.m30;
            lllllllllllllllllIIIIllIlIIIlIIl[1] = this.m31;
            lllllllllllllllllIIIIllIlIIIlIIl[2] = this.m32;
            lllllllllllllllllIIIIllIlIIIlIIl[3] = this.m33;
        }
    }
    
    public boolean equals(final Matrix4f lllllllllllllllllIIIIIlIlllIlIll) {
        try {
            return this.m00 == lllllllllllllllllIIIIIlIlllIlIll.m00 && this.m01 == lllllllllllllllllIIIIIlIlllIlIll.m01 && this.m02 == lllllllllllllllllIIIIIlIlllIlIll.m02 && this.m03 == lllllllllllllllllIIIIIlIlllIlIll.m03 && this.m10 == lllllllllllllllllIIIIIlIlllIlIll.m10 && this.m11 == lllllllllllllllllIIIIIlIlllIlIll.m11 && this.m12 == lllllllllllllllllIIIIIlIlllIlIll.m12 && this.m13 == lllllllllllllllllIIIIIlIlllIlIll.m13 && this.m20 == lllllllllllllllllIIIIIlIlllIlIll.m20 && this.m21 == lllllllllllllllllIIIIIlIlllIlIll.m21 && this.m22 == lllllllllllllllllIIIIIlIlllIlIll.m22 && this.m23 == lllllllllllllllllIIIIIlIlllIlIll.m23 && this.m30 == lllllllllllllllllIIIIIlIlllIlIll.m30 && this.m31 == lllllllllllllllllIIIIIlIlllIlIll.m31 && this.m32 == lllllllllllllllllIIIIIlIlllIlIll.m32 && this.m33 == lllllllllllllllllIIIIIlIlllIlIll.m33;
        }
        catch (NullPointerException lllllllllllllllllIIIIIlIlllIlIlI) {
            return false;
        }
    }
    
    public final void set(final float[] lllllllllllllllllIIIIlIIIlllIIll) {
        this.m00 = lllllllllllllllllIIIIlIIIlllIIll[0];
        this.m01 = lllllllllllllllllIIIIlIIIlllIIll[1];
        this.m02 = lllllllllllllllllIIIIlIIIlllIIll[2];
        this.m03 = lllllllllllllllllIIIIlIIIlllIIll[3];
        this.m10 = lllllllllllllllllIIIIlIIIlllIIll[4];
        this.m11 = lllllllllllllllllIIIIlIIIlllIIll[5];
        this.m12 = lllllllllllllllllIIIIlIIIlllIIll[6];
        this.m13 = lllllllllllllllllIIIIlIIIlllIIll[7];
        this.m20 = lllllllllllllllllIIIIlIIIlllIIll[8];
        this.m21 = lllllllllllllllllIIIIlIIIlllIIll[9];
        this.m22 = lllllllllllllllllIIIIlIIIlllIIll[10];
        this.m23 = lllllllllllllllllIIIIlIIIlllIIll[11];
        this.m30 = lllllllllllllllllIIIIlIIIlllIIll[12];
        this.m31 = lllllllllllllllllIIIIlIIIlllIIll[13];
        this.m32 = lllllllllllllllllIIIIlIIIlllIIll[14];
        this.m33 = lllllllllllllllllIIIIlIIIlllIIll[15];
    }
    
    public final float determinant() {
        float lllllllllllllllllIIIIlIIlIIIllIl = this.m00 * (this.m11 * this.m22 * this.m33 + this.m12 * this.m23 * this.m31 + this.m13 * this.m21 * this.m32 - this.m13 * this.m22 * this.m31 - this.m11 * this.m23 * this.m32 - this.m12 * this.m21 * this.m33);
        lllllllllllllllllIIIIlIIlIIIllIl -= this.m01 * (this.m10 * this.m22 * this.m33 + this.m12 * this.m23 * this.m30 + this.m13 * this.m20 * this.m32 - this.m13 * this.m22 * this.m30 - this.m10 * this.m23 * this.m32 - this.m12 * this.m20 * this.m33);
        lllllllllllllllllIIIIlIIlIIIllIl += this.m02 * (this.m10 * this.m21 * this.m33 + this.m11 * this.m23 * this.m30 + this.m13 * this.m20 * this.m31 - this.m13 * this.m21 * this.m30 - this.m10 * this.m23 * this.m31 - this.m11 * this.m20 * this.m33);
        lllllllllllllllllIIIIlIIlIIIllIl -= this.m03 * (this.m10 * this.m21 * this.m32 + this.m11 * this.m22 * this.m30 + this.m12 * this.m20 * this.m31 - this.m12 * this.m21 * this.m30 - this.m10 * this.m22 * this.m31 - this.m11 * this.m20 * this.m32);
        return lllllllllllllllllIIIIlIIlIIIllIl;
    }
    
    public final void set(final Matrix4f lllllllllllllllllIIIIlIlIIIIlllI) {
        this.m00 = lllllllllllllllllIIIIlIlIIIIlllI.m00;
        this.m01 = lllllllllllllllllIIIIlIlIIIIlllI.m01;
        this.m02 = lllllllllllllllllIIIIlIlIIIIlllI.m02;
        this.m03 = lllllllllllllllllIIIIlIlIIIIlllI.m03;
        this.m10 = lllllllllllllllllIIIIlIlIIIIlllI.m10;
        this.m11 = lllllllllllllllllIIIIlIlIIIIlllI.m11;
        this.m12 = lllllllllllllllllIIIIlIlIIIIlllI.m12;
        this.m13 = lllllllllllllllllIIIIlIlIIIIlllI.m13;
        this.m20 = lllllllllllllllllIIIIlIlIIIIlllI.m20;
        this.m21 = lllllllllllllllllIIIIlIlIIIIlllI.m21;
        this.m22 = lllllllllllllllllIIIIlIlIIIIlllI.m22;
        this.m23 = lllllllllllllllllIIIIlIlIIIIlllI.m23;
        this.m30 = lllllllllllllllllIIIIlIlIIIIlllI.m30;
        this.m31 = lllllllllllllllllIIIIlIlIIIIlllI.m31;
        this.m32 = lllllllllllllllllIIIIlIlIIIIlllI.m32;
        this.m33 = lllllllllllllllllIIIIlIlIIIIlllI.m33;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.m00)).append(", ").append(this.m01).append(", ").append(this.m02).append(", ").append(this.m03).append("\n").append(this.m10).append(", ").append(this.m11).append(", ").append(this.m12).append(", ").append(this.m13).append("\n").append(this.m20).append(", ").append(this.m21).append(", ").append(this.m22).append(", ").append(this.m23).append("\n").append(this.m30).append(", ").append(this.m31).append(", ").append(this.m32).append(", ").append(this.m33).append("\n"));
    }
    
    public final float getM13() {
        return this.m13;
    }
    
    public final void setM20(final float lllllllllllllllllIIIIIIllIlllIIl) {
        this.m20 = lllllllllllllllllIIIIIIllIlllIIl;
    }
    
    public final void getColumn(final int lllllllllllllllllIIIIllIlIIIIIIl, final Vector4f lllllllllllllllllIIIIllIlIIIIIII) {
        if (lllllllllllllllllIIIIllIlIIIIIIl == 0) {
            lllllllllllllllllIIIIllIlIIIIIII.x = this.m00;
            lllllllllllllllllIIIIllIlIIIIIII.y = this.m10;
            lllllllllllllllllIIIIllIlIIIIIII.z = this.m20;
            lllllllllllllllllIIIIllIlIIIIIII.w = this.m30;
        }
        else if (lllllllllllllllllIIIIllIlIIIIIIl == 1) {
            lllllllllllllllllIIIIllIlIIIIIII.x = this.m01;
            lllllllllllllllllIIIIllIlIIIIIII.y = this.m11;
            lllllllllllllllllIIIIllIlIIIIIII.z = this.m21;
            lllllllllllllllllIIIIllIlIIIIIII.w = this.m31;
        }
        else if (lllllllllllllllllIIIIllIlIIIIIIl == 2) {
            lllllllllllllllllIIIIllIlIIIIIII.x = this.m02;
            lllllllllllllllllIIIIllIlIIIIIII.y = this.m12;
            lllllllllllllllllIIIIllIlIIIIIII.z = this.m22;
            lllllllllllllllllIIIIllIlIIIIIII.w = this.m32;
        }
        else {
            if (lllllllllllllllllIIIIllIlIIIIIIl != 3) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f4"));
            }
            lllllllllllllllllIIIIllIlIIIIIII.x = this.m03;
            lllllllllllllllllIIIIllIlIIIIIII.y = this.m13;
            lllllllllllllllllIIIIllIlIIIIIII.z = this.m23;
            lllllllllllllllllIIIIllIlIIIIIII.w = this.m33;
        }
    }
    
    public final void set(final Quat4f lllllllllllllllllIIIIlIllIIIIIII) {
        this.m00 = 1.0f - 2.0f * lllllllllllllllllIIIIlIllIIIIIII.y * lllllllllllllllllIIIIlIllIIIIIII.y - 2.0f * lllllllllllllllllIIIIlIllIIIIIII.z * lllllllllllllllllIIIIlIllIIIIIII.z;
        this.m10 = 2.0f * (lllllllllllllllllIIIIlIllIIIIIII.x * lllllllllllllllllIIIIlIllIIIIIII.y + lllllllllllllllllIIIIlIllIIIIIII.w * lllllllllllllllllIIIIlIllIIIIIII.z);
        this.m20 = 2.0f * (lllllllllllllllllIIIIlIllIIIIIII.x * lllllllllllllllllIIIIlIllIIIIIII.z - lllllllllllllllllIIIIlIllIIIIIII.w * lllllllllllllllllIIIIlIllIIIIIII.y);
        this.m01 = 2.0f * (lllllllllllllllllIIIIlIllIIIIIII.x * lllllllllllllllllIIIIlIllIIIIIII.y - lllllllllllllllllIIIIlIllIIIIIII.w * lllllllllllllllllIIIIlIllIIIIIII.z);
        this.m11 = 1.0f - 2.0f * lllllllllllllllllIIIIlIllIIIIIII.x * lllllllllllllllllIIIIlIllIIIIIII.x - 2.0f * lllllllllllllllllIIIIlIllIIIIIII.z * lllllllllllllllllIIIIlIllIIIIIII.z;
        this.m21 = 2.0f * (lllllllllllllllllIIIIlIllIIIIIII.y * lllllllllllllllllIIIIlIllIIIIIII.z + lllllllllllllllllIIIIlIllIIIIIII.w * lllllllllllllllllIIIIlIllIIIIIII.x);
        this.m02 = 2.0f * (lllllllllllllllllIIIIlIllIIIIIII.x * lllllllllllllllllIIIIlIllIIIIIII.z + lllllllllllllllllIIIIlIllIIIIIII.w * lllllllllllllllllIIIIlIllIIIIIII.y);
        this.m12 = 2.0f * (lllllllllllllllllIIIIlIllIIIIIII.y * lllllllllllllllllIIIIlIllIIIIIII.z - lllllllllllllllllIIIIlIllIIIIIII.w * lllllllllllllllllIIIIlIllIIIIIII.x);
        this.m22 = 1.0f - 2.0f * lllllllllllllllllIIIIlIllIIIIIII.x * lllllllllllllllllIIIIlIllIIIIIII.x - 2.0f * lllllllllllllllllIIIIlIllIIIIIII.y * lllllllllllllllllIIIIlIllIIIIIII.y;
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    static boolean luDecomposition(final double[] lllllllllllllllllIIIIlIIllIIIIll, final int[] lllllllllllllllllIIIIlIIllIIIIlI) {
        final double[] lllllllllllllllllIIIIlIIlllIIIII = new double[4];
        int lllllllllllllllllIIIIlIIllIlllIl = 0;
        int lllllllllllllllllIIIIlIIllIlllII = 0;
        int lllllllllllllllllIIIIlIIllIlllll = 4;
        while (lllllllllllllllllIIIIlIIllIlllll-- != 0) {
            double lllllllllllllllllIIIIlIIllIllIll = 0.0;
            int lllllllllllllllllIIIIlIIllIllllI = 4;
            while (lllllllllllllllllIIIIlIIllIllllI-- != 0) {
                double lllllllllllllllllIIIIlIIllIllIlI = lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIlllIl++];
                lllllllllllllllllIIIIlIIllIllIlI = Math.abs(lllllllllllllllllIIIIlIIllIllIlI);
                if (lllllllllllllllllIIIIlIIllIllIlI > lllllllllllllllllIIIIlIIllIllIll) {
                    lllllllllllllllllIIIIlIIllIllIll = lllllllllllllllllIIIIlIIllIllIlI;
                }
            }
            if (lllllllllllllllllIIIIlIIllIllIll == 0.0) {
                return false;
            }
            lllllllllllllllllIIIIlIIlllIIIII[lllllllllllllllllIIIIlIIllIlllII++] = 1.0 / lllllllllllllllllIIIIlIIllIllIll;
        }
        final int lllllllllllllllllIIIIlIIllIllIII = 0;
        for (int lllllllllllllllllIIIIlIIllIllIIl = 0; lllllllllllllllllIIIIlIIllIllIIl < 4; ++lllllllllllllllllIIIIlIIllIllIIl) {
            for (int lllllllllllllllllIIIIlIIllIlIlll = 0; lllllllllllllllllIIIIlIIllIlIlll < lllllllllllllllllIIIIlIIllIllIIl; ++lllllllllllllllllIIIIlIIllIlIlll) {
                final int lllllllllllllllllIIIIlIIllIlIIlI = lllllllllllllllllIIIIlIIllIllIII + 4 * lllllllllllllllllIIIIlIIllIlIlll + lllllllllllllllllIIIIlIIllIllIIl;
                double lllllllllllllllllIIIIlIIllIIlIIl = lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIlIIlI];
                int lllllllllllllllllIIIIlIIllIlIlIl = lllllllllllllllllIIIIlIIllIlIlll;
                int lllllllllllllllllIIIIlIIllIIllll = lllllllllllllllllIIIIlIIllIllIII + 4 * lllllllllllllllllIIIIlIIllIlIlll;
                int lllllllllllllllllIIIIlIIllIIllII = lllllllllllllllllIIIIlIIllIllIII + lllllllllllllllllIIIIlIIllIllIIl;
                while (lllllllllllllllllIIIIlIIllIlIlIl-- != 0) {
                    lllllllllllllllllIIIIlIIllIIlIIl -= lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIIllll] * lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIIllII];
                    ++lllllllllllllllllIIIIlIIllIIllll;
                    lllllllllllllllllIIIIlIIllIIllII += 4;
                }
                lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIlIIlI] = lllllllllllllllllIIIIlIIllIIlIIl;
            }
            double lllllllllllllllllIIIIlIIllIIIlll = 0.0;
            int lllllllllllllllllIIIIlIIllIlIllI = -1;
            for (int lllllllllllllllllIIIIlIIllIlIlll = lllllllllllllllllIIIIlIIllIllIIl; lllllllllllllllllIIIIlIIllIlIlll < 4; ++lllllllllllllllllIIIIlIIllIlIlll) {
                final int lllllllllllllllllIIIIlIIllIlIIIl = lllllllllllllllllIIIIlIIllIllIII + 4 * lllllllllllllllllIIIIlIIllIlIlll + lllllllllllllllllIIIIlIIllIllIIl;
                double lllllllllllllllllIIIIlIIllIIlIII = lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIlIIIl];
                int lllllllllllllllllIIIIlIIllIlIlII = lllllllllllllllllIIIIlIIllIllIIl;
                int lllllllllllllllllIIIIlIIllIIlllI = lllllllllllllllllIIIIlIIllIllIII + 4 * lllllllllllllllllIIIIlIIllIlIlll;
                int lllllllllllllllllIIIIlIIllIIlIll = lllllllllllllllllIIIIlIIllIllIII + lllllllllllllllllIIIIlIIllIllIIl;
                while (lllllllllllllllllIIIIlIIllIlIlII-- != 0) {
                    lllllllllllllllllIIIIlIIllIIlIII -= lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIIlllI] * lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIIlIll];
                    ++lllllllllllllllllIIIIlIIllIIlllI;
                    lllllllllllllllllIIIIlIIllIIlIll += 4;
                }
                lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIlIIIl] = lllllllllllllllllIIIIlIIllIIlIII;
                final double lllllllllllllllllIIIIlIIllIIIllI;
                if ((lllllllllllllllllIIIIlIIllIIIllI = lllllllllllllllllIIIIlIIlllIIIII[lllllllllllllllllIIIIlIIllIlIlll] * Math.abs(lllllllllllllllllIIIIlIIllIIlIII)) >= lllllllllllllllllIIIIlIIllIIIlll) {
                    lllllllllllllllllIIIIlIIllIIIlll = lllllllllllllllllIIIIlIIllIIIllI;
                    lllllllllllllllllIIIIlIIllIlIllI = lllllllllllllllllIIIIlIIllIlIlll;
                }
            }
            if (lllllllllllllllllIIIIlIIllIlIllI < 0) {
                throw new RuntimeException(VecMathI18N.getString("Matrix4f13"));
            }
            if (lllllllllllllllllIIIIlIIllIllIIl != lllllllllllllllllIIIIlIIllIlIllI) {
                int lllllllllllllllllIIIIlIIllIlIIll = 4;
                int lllllllllllllllllIIIIlIIllIIllIl = lllllllllllllllllIIIIlIIllIllIII + 4 * lllllllllllllllllIIIIlIIllIlIllI;
                int lllllllllllllllllIIIIlIIllIIlIlI = lllllllllllllllllIIIIlIIllIllIII + 4 * lllllllllllllllllIIIIlIIllIllIIl;
                while (lllllllllllllllllIIIIlIIllIlIIll-- != 0) {
                    final double lllllllllllllllllIIIIlIIllIIIlIl = lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIIllIl];
                    lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIIllIl++] = lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIIlIlI];
                    lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIIlIlI++] = lllllllllllllllllIIIIlIIllIIIlIl;
                }
                lllllllllllllllllIIIIlIIlllIIIII[lllllllllllllllllIIIIlIIllIlIllI] = lllllllllllllllllIIIIlIIlllIIIII[lllllllllllllllllIIIIlIIllIllIIl];
            }
            lllllllllllllllllIIIIlIIllIIIIlI[lllllllllllllllllIIIIlIIllIllIIl] = lllllllllllllllllIIIIlIIllIlIllI;
            if (lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIllIII + 4 * lllllllllllllllllIIIIlIIllIllIIl + lllllllllllllllllIIIIlIIllIllIIl] == 0.0) {
                return false;
            }
            if (lllllllllllllllllIIIIlIIllIllIIl != 3) {
                final double lllllllllllllllllIIIIlIIllIIIlII = 1.0 / lllllllllllllllllIIIIlIIllIIIIll[lllllllllllllllllIIIIlIIllIllIII + 4 * lllllllllllllllllIIIIlIIllIllIIl + lllllllllllllllllIIIIlIIllIllIIl];
                int lllllllllllllllllIIIIlIIllIlIIII = lllllllllllllllllIIIIlIIllIllIII + 4 * (lllllllllllllllllIIIIlIIllIllIIl + 1) + lllllllllllllllllIIIIlIIllIllIIl;
                int lllllllllllllllllIIIIlIIllIlIlll = 3 - lllllllllllllllllIIIIlIIllIllIIl;
                while (lllllllllllllllllIIIIlIIllIlIlll-- != 0) {
                    final int n = lllllllllllllllllIIIIlIIllIlIIII;
                    lllllllllllllllllIIIIlIIllIIIIll[n] *= lllllllllllllllllIIIIlIIllIIIlII;
                    lllllllllllllllllIIIIlIIllIlIIII += 4;
                }
            }
        }
        return true;
    }
    
    public final void setM03(final float lllllllllllllllllIIIIIIllIlIIIII) {
        this.m03 = lllllllllllllllllIIIIIIllIlIIIII;
    }
    
    public final void transform(final Point3f lllllllllllllllllIIIIIlIlIlIIIlI, final Point3f lllllllllllllllllIIIIIlIlIIlllII) {
        final float lllllllllllllllllIIIIIlIlIlIIIII = this.m00 * lllllllllllllllllIIIIIlIlIlIIIlI.x + this.m01 * lllllllllllllllllIIIIIlIlIlIIIlI.y + this.m02 * lllllllllllllllllIIIIIlIlIlIIIlI.z + this.m03;
        final float lllllllllllllllllIIIIIlIlIIlllll = this.m10 * lllllllllllllllllIIIIIlIlIlIIIlI.x + this.m11 * lllllllllllllllllIIIIIlIlIlIIIlI.y + this.m12 * lllllllllllllllllIIIIIlIlIlIIIlI.z + this.m13;
        lllllllllllllllllIIIIIlIlIIlllII.z = this.m20 * lllllllllllllllllIIIIIlIlIlIIIlI.x + this.m21 * lllllllllllllllllIIIIIlIlIlIIIlI.y + this.m22 * lllllllllllllllllIIIIIlIlIlIIIlI.z + this.m23;
        lllllllllllllllllIIIIIlIlIIlllII.x = lllllllllllllllllIIIIIlIlIlIIIII;
        lllllllllllllllllIIIIIlIlIIlllII.y = lllllllllllllllllIIIIIlIlIIlllll;
    }
    
    public final void rotZ(final float lllllllllllllllllIIIIlIIIIIlllll) {
        final float lllllllllllllllllIIIIlIIIIIllllI = (float)Math.sin(lllllllllllllllllIIIIlIIIIIlllll);
        final float lllllllllllllllllIIIIlIIIIIlllIl = (float)Math.cos(lllllllllllllllllIIIIlIIIIIlllll);
        this.m00 = lllllllllllllllllIIIIlIIIIIlllIl;
        this.m01 = -lllllllllllllllllIIIIlIIIIIllllI;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = lllllllllllllllllIIIIlIIIIIllllI;
        this.m11 = lllllllllllllllllIIIIlIIIIIlllIl;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public boolean epsilonEquals(final Matrix4f lllllllllllllllllIIIIIlIllIlIllI, final float lllllllllllllllllIIIIIlIllIlIlIl) {
        boolean lllllllllllllllllIIIIIlIllIlIlII = true;
        if (Math.abs(this.m00 - lllllllllllllllllIIIIIlIllIlIllI.m00) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m01 - lllllllllllllllllIIIIIlIllIlIllI.m01) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m02 - lllllllllllllllllIIIIIlIllIlIllI.m02) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m03 - lllllllllllllllllIIIIIlIllIlIllI.m03) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m10 - lllllllllllllllllIIIIIlIllIlIllI.m10) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m11 - lllllllllllllllllIIIIIlIllIlIllI.m11) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m12 - lllllllllllllllllIIIIIlIllIlIllI.m12) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m13 - lllllllllllllllllIIIIIlIllIlIllI.m13) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m20 - lllllllllllllllllIIIIIlIllIlIllI.m20) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m21 - lllllllllllllllllIIIIIlIllIlIllI.m21) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m22 - lllllllllllllllllIIIIIlIllIlIllI.m22) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m23 - lllllllllllllllllIIIIIlIllIlIllI.m23) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m30 - lllllllllllllllllIIIIIlIllIlIllI.m30) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m31 - lllllllllllllllllIIIIIlIllIlIllI.m31) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m32 - lllllllllllllllllIIIIIlIllIlIllI.m32) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        if (Math.abs(this.m33 - lllllllllllllllllIIIIIlIllIlIllI.m33) > lllllllllllllllllIIIIIlIllIlIlIl) {
            lllllllllllllllllIIIIIlIllIlIlII = false;
        }
        return lllllllllllllllllIIIIIlIllIlIlII;
    }
    
    public Object clone() {
        Matrix4f lllllllllllllllllIIIIIIlllllllII = null;
        try {
            lllllllllllllllllIIIIIIlllllllII = (Matrix4f)super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllllllIIIIIIllllllIll) {
            throw new InternalError();
        }
        return lllllllllllllllllIIIIIIlllllllII;
    }
    
    public final void setElement(final int lllllllllllllllllIIIIllIlIlIlIlI, final int lllllllllllllllllIIIIllIlIlIIlIl, final float lllllllllllllllllIIIIllIlIlIIlII) {
        Label_0352: {
            switch (lllllllllllllllllIIIIllIlIlIlIlI) {
                case 0: {
                    switch (lllllllllllllllllIIIIllIlIlIIlIl) {
                        case 0: {
                            this.m00 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 1: {
                            this.m01 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 2: {
                            this.m02 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 3: {
                            this.m03 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                        }
                    }
                    break;
                }
                case 1: {
                    switch (lllllllllllllllllIIIIllIlIlIIlIl) {
                        case 0: {
                            this.m10 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 1: {
                            this.m11 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 2: {
                            this.m12 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 3: {
                            this.m13 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                        }
                    }
                    break;
                }
                case 2: {
                    switch (lllllllllllllllllIIIIllIlIlIIlIl) {
                        case 0: {
                            this.m20 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 1: {
                            this.m21 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 2: {
                            this.m22 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 3: {
                            this.m23 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                        }
                    }
                    break;
                }
                case 3: {
                    switch (lllllllllllllllllIIIIllIlIlIIlIl) {
                        case 0: {
                            this.m30 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 1: {
                            this.m31 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 2: {
                            this.m32 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        case 3: {
                            this.m33 = lllllllllllllllllIIIIllIlIlIIlII;
                            break Label_0352;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                        }
                    }
                    break;
                }
                default: {
                    throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f0"));
                }
            }
        }
    }
    
    public Matrix4f(final Matrix3f lllllllllllllllllIIIIllIlIllllll, final Vector3f lllllllllllllllllIIIIllIlIlllllI, final float lllllllllllllllllIIIIllIlIlllIIl) {
        this.m00 = lllllllllllllllllIIIIllIlIllllll.m00 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m01 = lllllllllllllllllIIIIllIlIllllll.m01 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m02 = lllllllllllllllllIIIIllIlIllllll.m02 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m03 = lllllllllllllllllIIIIllIlIlllllI.x;
        this.m10 = lllllllllllllllllIIIIllIlIllllll.m10 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m11 = lllllllllllllllllIIIIllIlIllllll.m11 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m12 = lllllllllllllllllIIIIllIlIllllll.m12 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m13 = lllllllllllllllllIIIIllIlIlllllI.y;
        this.m20 = lllllllllllllllllIIIIllIlIllllll.m20 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m21 = lllllllllllllllllIIIIllIlIllllll.m21 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m22 = lllllllllllllllllIIIIllIlIllllll.m22 * lllllllllllllllllIIIIllIlIlllIIl;
        this.m23 = lllllllllllllllllIIIIllIlIlllllI.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final float getM33() {
        return this.m33;
    }
    
    public final void setColumn(final int lllllllllllllllllIIIIlIllllIlIII, final float lllllllllllllllllIIIIlIllllIIlll, final float lllllllllllllllllIIIIlIllllIllII, final float lllllllllllllllllIIIIlIllllIIlIl, final float lllllllllllllllllIIIIlIllllIlIlI) {
        switch (lllllllllllllllllIIIIlIllllIlIII) {
            case 0: {
                this.m00 = lllllllllllllllllIIIIlIllllIIlll;
                this.m10 = lllllllllllllllllIIIIlIllllIllII;
                this.m20 = lllllllllllllllllIIIIlIllllIIlIl;
                this.m30 = lllllllllllllllllIIIIlIllllIlIlI;
                break;
            }
            case 1: {
                this.m01 = lllllllllllllllllIIIIlIllllIIlll;
                this.m11 = lllllllllllllllllIIIIlIllllIllII;
                this.m21 = lllllllllllllllllIIIIlIllllIIlIl;
                this.m31 = lllllllllllllllllIIIIlIllllIlIlI;
                break;
            }
            case 2: {
                this.m02 = lllllllllllllllllIIIIlIllllIIlll;
                this.m12 = lllllllllllllllllIIIIlIllllIllII;
                this.m22 = lllllllllllllllllIIIIlIllllIIlIl;
                this.m32 = lllllllllllllllllIIIIlIllllIlIlI;
                break;
            }
            case 3: {
                this.m03 = lllllllllllllllllIIIIlIllllIIlll;
                this.m13 = lllllllllllllllllIIIIlIllllIllII;
                this.m23 = lllllllllllllllllIIIIlIllllIIlIl;
                this.m33 = lllllllllllllllllIIIIlIllllIlIlI;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
            }
        }
    }
    
    public final void mul(final float lllllllllllllllllIIIIlIIIIIlIlIl) {
        this.m00 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m01 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m02 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m03 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m10 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m11 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m12 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m13 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m20 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m21 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m22 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m23 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m30 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m31 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m32 *= lllllllllllllllllIIIIlIIIIIlIlIl;
        this.m33 *= lllllllllllllllllIIIIlIIIIIlIlIl;
    }
    
    public final void set(final Matrix3f lllllllllllllllllIIIIlIIlIIIIlIl) {
        this.m00 = lllllllllllllllllIIIIlIIlIIIIlIl.m00;
        this.m01 = lllllllllllllllllIIIIlIIlIIIIlIl.m01;
        this.m02 = lllllllllllllllllIIIIlIIlIIIIlIl.m02;
        this.m03 = 0.0f;
        this.m10 = lllllllllllllllllIIIIlIIlIIIIlIl.m10;
        this.m11 = lllllllllllllllllIIIIlIIlIIIIlIl.m11;
        this.m12 = lllllllllllllllllIIIIlIIlIIIIlIl.m12;
        this.m13 = 0.0f;
        this.m20 = lllllllllllllllllIIIIlIIlIIIIlIl.m20;
        this.m21 = lllllllllllllllllIIIIlIIlIIIIlIl.m21;
        this.m22 = lllllllllllllllllIIIIlIIlIIIIlIl.m22;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    static void luBacksubstitution(final double[] lllllllllllllllllIIIIlIIlIlIlIIl, final int[] lllllllllllllllllIIIIlIIlIIllIll, final double[] lllllllllllllllllIIIIlIIlIIllIlI) {
        final int lllllllllllllllllIIIIlIIlIlIIIIl = 0;
        for (int lllllllllllllllllIIIIlIIlIlIIIlI = 0; lllllllllllllllllIIIIlIIlIlIIIlI < 4; ++lllllllllllllllllIIIIlIIlIlIIIlI) {
            final int lllllllllllllllllIIIIlIIlIlIIIII = lllllllllllllllllIIIIlIIlIlIIIlI;
            int lllllllllllllllllIIIIlIIlIlIIlIl = -1;
            for (int lllllllllllllllllIIIIlIIlIlIIllI = 0; lllllllllllllllllIIIIlIIlIlIIllI < 4; ++lllllllllllllllllIIIIlIIlIlIIllI) {
                final int lllllllllllllllllIIIIlIIlIlIIlII = lllllllllllllllllIIIIlIIlIIllIll[lllllllllllllllllIIIIlIIlIlIIIIl + lllllllllllllllllIIIIlIIlIlIIllI];
                double lllllllllllllllllIIIIlIIlIIlllIl = lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 4 * lllllllllllllllllIIIIlIIlIlIIlII];
                lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 4 * lllllllllllllllllIIIIlIIlIlIIlII] = lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 4 * lllllllllllllllllIIIIlIIlIlIIllI];
                if (lllllllllllllllllIIIIlIIlIlIIlIl >= 0) {
                    final int lllllllllllllllllIIIIlIIlIIlllll = lllllllllllllllllIIIIlIIlIlIIllI * 4;
                    for (int lllllllllllllllllIIIIlIIlIlIIIll = lllllllllllllllllIIIIlIIlIlIIlIl; lllllllllllllllllIIIIlIIlIlIIIll <= lllllllllllllllllIIIIlIIlIlIIllI - 1; ++lllllllllllllllllIIIIlIIlIlIIIll) {
                        lllllllllllllllllIIIIlIIlIIlllIl -= lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIlllll + lllllllllllllllllIIIIlIIlIlIIIll] * lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 4 * lllllllllllllllllIIIIlIIlIlIIIll];
                    }
                }
                else if (lllllllllllllllllIIIIlIIlIIlllIl != 0.0) {
                    lllllllllllllllllIIIIlIIlIlIIlIl = lllllllllllllllllIIIIlIIlIlIIllI;
                }
                lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 4 * lllllllllllllllllIIIIlIIlIlIIllI] = lllllllllllllllllIIIIlIIlIIlllIl;
            }
            int lllllllllllllllllIIIIlIIlIIllllI = 12;
            final int n = lllllllllllllllllIIIIlIIlIlIIIII + 12;
            lllllllllllllllllIIIIlIIlIIllIlI[n] /= lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 3];
            lllllllllllllllllIIIIlIIlIIllllI -= 4;
            lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 8] = (lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 8] - lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 3] * lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 12]) / lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 2];
            lllllllllllllllllIIIIlIIlIIllllI -= 4;
            lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 4] = (lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 4] - lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 2] * lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 8] - lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 3] * lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 12]) / lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 1];
            lllllllllllllllllIIIIlIIlIIllllI -= 4;
            lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 0] = (lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 0] - lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 1] * lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 4] - lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 2] * lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 8] - lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 3] * lllllllllllllllllIIIIlIIlIIllIlI[lllllllllllllllllIIIIlIIlIlIIIII + 12]) / lllllllllllllllllIIIIlIIlIlIlIIl[lllllllllllllllllIIIIlIIlIIllllI + 0];
        }
    }
    
    public final void set(final Vector3f lllllllllllllllllIIIIlIIIlIlllII, final float lllllllllllllllllIIIIlIIIlIllllI) {
        this.m00 = lllllllllllllllllIIIIlIIIlIllllI;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = lllllllllllllllllIIIIlIIIlIllllI * lllllllllllllllllIIIIlIIIlIlllII.x;
        this.m10 = 0.0f;
        this.m11 = lllllllllllllllllIIIIlIIIlIllllI;
        this.m12 = 0.0f;
        this.m13 = lllllllllllllllllIIIIlIIIlIllllI * lllllllllllllllllIIIIlIIIlIlllII.y;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = lllllllllllllllllIIIIlIIIlIllllI;
        this.m23 = lllllllllllllllllIIIIlIIIlIllllI * lllllllllllllllllIIIIlIIIlIlllII.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void set(final Vector3f lllllllllllllllllIIIIlIIIllIllIl) {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = lllllllllllllllllIIIIlIIIllIllIl.x;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = lllllllllllllllllIIIIlIIIllIllIl.y;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = lllllllllllllllllIIIIlIIIllIllIl.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void set(final Quat4d lllllllllllllllllIIIIlIlIlIlIlII) {
        this.m00 = (float)(1.0 - 2.0 * lllllllllllllllllIIIIlIlIlIlIlII.y * lllllllllllllllllIIIIlIlIlIlIlII.y - 2.0 * lllllllllllllllllIIIIlIlIlIlIlII.z * lllllllllllllllllIIIIlIlIlIlIlII.z);
        this.m10 = (float)(2.0 * (lllllllllllllllllIIIIlIlIlIlIlII.x * lllllllllllllllllIIIIlIlIlIlIlII.y + lllllllllllllllllIIIIlIlIlIlIlII.w * lllllllllllllllllIIIIlIlIlIlIlII.z));
        this.m20 = (float)(2.0 * (lllllllllllllllllIIIIlIlIlIlIlII.x * lllllllllllllllllIIIIlIlIlIlIlII.z - lllllllllllllllllIIIIlIlIlIlIlII.w * lllllllllllllllllIIIIlIlIlIlIlII.y));
        this.m01 = (float)(2.0 * (lllllllllllllllllIIIIlIlIlIlIlII.x * lllllllllllllllllIIIIlIlIlIlIlII.y - lllllllllllllllllIIIIlIlIlIlIlII.w * lllllllllllllllllIIIIlIlIlIlIlII.z));
        this.m11 = (float)(1.0 - 2.0 * lllllllllllllllllIIIIlIlIlIlIlII.x * lllllllllllllllllIIIIlIlIlIlIlII.x - 2.0 * lllllllllllllllllIIIIlIlIlIlIlII.z * lllllllllllllllllIIIIlIlIlIlIlII.z);
        this.m21 = (float)(2.0 * (lllllllllllllllllIIIIlIlIlIlIlII.y * lllllllllllllllllIIIIlIlIlIlIlII.z + lllllllllllllllllIIIIlIlIlIlIlII.w * lllllllllllllllllIIIIlIlIlIlIlII.x));
        this.m02 = (float)(2.0 * (lllllllllllllllllIIIIlIlIlIlIlII.x * lllllllllllllllllIIIIlIlIlIlIlII.z + lllllllllllllllllIIIIlIlIlIlIlII.w * lllllllllllllllllIIIIlIlIlIlIlII.y));
        this.m12 = (float)(2.0 * (lllllllllllllllllIIIIlIlIlIlIlII.y * lllllllllllllllllIIIIlIlIlIlIlII.z - lllllllllllllllllIIIIlIlIlIlIlII.w * lllllllllllllllllIIIIlIlIlIlIlII.x));
        this.m22 = (float)(1.0 - 2.0 * lllllllllllllllllIIIIlIlIlIlIlII.x * lllllllllllllllllIIIIlIlIlIlIlII.x - 2.0 * lllllllllllllllllIIIIlIlIlIlIlII.y * lllllllllllllllllIIIIlIlIlIlIlII.y);
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void mul(final Matrix4f lllllllllllllllllIIIIIlllIllllll, final Matrix4f lllllllllllllllllIIIIIlllIlllllI) {
        if (this != lllllllllllllllllIIIIIlllIllllll && this != lllllllllllllllllIIIIIlllIlllllI) {
            this.m00 = lllllllllllllllllIIIIIlllIllllll.m00 * lllllllllllllllllIIIIIlllIlllllI.m00 + lllllllllllllllllIIIIIlllIllllll.m01 * lllllllllllllllllIIIIIlllIlllllI.m10 + lllllllllllllllllIIIIIlllIllllll.m02 * lllllllllllllllllIIIIIlllIlllllI.m20 + lllllllllllllllllIIIIIlllIllllll.m03 * lllllllllllllllllIIIIIlllIlllllI.m30;
            this.m01 = lllllllllllllllllIIIIIlllIllllll.m00 * lllllllllllllllllIIIIIlllIlllllI.m01 + lllllllllllllllllIIIIIlllIllllll.m01 * lllllllllllllllllIIIIIlllIlllllI.m11 + lllllllllllllllllIIIIIlllIllllll.m02 * lllllllllllllllllIIIIIlllIlllllI.m21 + lllllllllllllllllIIIIIlllIllllll.m03 * lllllllllllllllllIIIIIlllIlllllI.m31;
            this.m02 = lllllllllllllllllIIIIIlllIllllll.m00 * lllllllllllllllllIIIIIlllIlllllI.m02 + lllllllllllllllllIIIIIlllIllllll.m01 * lllllllllllllllllIIIIIlllIlllllI.m12 + lllllllllllllllllIIIIIlllIllllll.m02 * lllllllllllllllllIIIIIlllIlllllI.m22 + lllllllllllllllllIIIIIlllIllllll.m03 * lllllllllllllllllIIIIIlllIlllllI.m32;
            this.m03 = lllllllllllllllllIIIIIlllIllllll.m00 * lllllllllllllllllIIIIIlllIlllllI.m03 + lllllllllllllllllIIIIIlllIllllll.m01 * lllllllllllllllllIIIIIlllIlllllI.m13 + lllllllllllllllllIIIIIlllIllllll.m02 * lllllllllllllllllIIIIIlllIlllllI.m23 + lllllllllllllllllIIIIIlllIllllll.m03 * lllllllllllllllllIIIIIlllIlllllI.m33;
            this.m10 = lllllllllllllllllIIIIIlllIllllll.m10 * lllllllllllllllllIIIIIlllIlllllI.m00 + lllllllllllllllllIIIIIlllIllllll.m11 * lllllllllllllllllIIIIIlllIlllllI.m10 + lllllllllllllllllIIIIIlllIllllll.m12 * lllllllllllllllllIIIIIlllIlllllI.m20 + lllllllllllllllllIIIIIlllIllllll.m13 * lllllllllllllllllIIIIIlllIlllllI.m30;
            this.m11 = lllllllllllllllllIIIIIlllIllllll.m10 * lllllllllllllllllIIIIIlllIlllllI.m01 + lllllllllllllllllIIIIIlllIllllll.m11 * lllllllllllllllllIIIIIlllIlllllI.m11 + lllllllllllllllllIIIIIlllIllllll.m12 * lllllllllllllllllIIIIIlllIlllllI.m21 + lllllllllllllllllIIIIIlllIllllll.m13 * lllllllllllllllllIIIIIlllIlllllI.m31;
            this.m12 = lllllllllllllllllIIIIIlllIllllll.m10 * lllllllllllllllllIIIIIlllIlllllI.m02 + lllllllllllllllllIIIIIlllIllllll.m11 * lllllllllllllllllIIIIIlllIlllllI.m12 + lllllllllllllllllIIIIIlllIllllll.m12 * lllllllllllllllllIIIIIlllIlllllI.m22 + lllllllllllllllllIIIIIlllIllllll.m13 * lllllllllllllllllIIIIIlllIlllllI.m32;
            this.m13 = lllllllllllllllllIIIIIlllIllllll.m10 * lllllllllllllllllIIIIIlllIlllllI.m03 + lllllllllllllllllIIIIIlllIllllll.m11 * lllllllllllllllllIIIIIlllIlllllI.m13 + lllllllllllllllllIIIIIlllIllllll.m12 * lllllllllllllllllIIIIIlllIlllllI.m23 + lllllllllllllllllIIIIIlllIllllll.m13 * lllllllllllllllllIIIIIlllIlllllI.m33;
            this.m20 = lllllllllllllllllIIIIIlllIllllll.m20 * lllllllllllllllllIIIIIlllIlllllI.m00 + lllllllllllllllllIIIIIlllIllllll.m21 * lllllllllllllllllIIIIIlllIlllllI.m10 + lllllllllllllllllIIIIIlllIllllll.m22 * lllllllllllllllllIIIIIlllIlllllI.m20 + lllllllllllllllllIIIIIlllIllllll.m23 * lllllllllllllllllIIIIIlllIlllllI.m30;
            this.m21 = lllllllllllllllllIIIIIlllIllllll.m20 * lllllllllllllllllIIIIIlllIlllllI.m01 + lllllllllllllllllIIIIIlllIllllll.m21 * lllllllllllllllllIIIIIlllIlllllI.m11 + lllllllllllllllllIIIIIlllIllllll.m22 * lllllllllllllllllIIIIIlllIlllllI.m21 + lllllllllllllllllIIIIIlllIllllll.m23 * lllllllllllllllllIIIIIlllIlllllI.m31;
            this.m22 = lllllllllllllllllIIIIIlllIllllll.m20 * lllllllllllllllllIIIIIlllIlllllI.m02 + lllllllllllllllllIIIIIlllIllllll.m21 * lllllllllllllllllIIIIIlllIlllllI.m12 + lllllllllllllllllIIIIIlllIllllll.m22 * lllllllllllllllllIIIIIlllIlllllI.m22 + lllllllllllllllllIIIIIlllIllllll.m23 * lllllllllllllllllIIIIIlllIlllllI.m32;
            this.m23 = lllllllllllllllllIIIIIlllIllllll.m20 * lllllllllllllllllIIIIIlllIlllllI.m03 + lllllllllllllllllIIIIIlllIllllll.m21 * lllllllllllllllllIIIIIlllIlllllI.m13 + lllllllllllllllllIIIIIlllIllllll.m22 * lllllllllllllllllIIIIIlllIlllllI.m23 + lllllllllllllllllIIIIIlllIllllll.m23 * lllllllllllllllllIIIIIlllIlllllI.m33;
            this.m30 = lllllllllllllllllIIIIIlllIllllll.m30 * lllllllllllllllllIIIIIlllIlllllI.m00 + lllllllllllllllllIIIIIlllIllllll.m31 * lllllllllllllllllIIIIIlllIlllllI.m10 + lllllllllllllllllIIIIIlllIllllll.m32 * lllllllllllllllllIIIIIlllIlllllI.m20 + lllllllllllllllllIIIIIlllIllllll.m33 * lllllllllllllllllIIIIIlllIlllllI.m30;
            this.m31 = lllllllllllllllllIIIIIlllIllllll.m30 * lllllllllllllllllIIIIIlllIlllllI.m01 + lllllllllllllllllIIIIIlllIllllll.m31 * lllllllllllllllllIIIIIlllIlllllI.m11 + lllllllllllllllllIIIIIlllIllllll.m32 * lllllllllllllllllIIIIIlllIlllllI.m21 + lllllllllllllllllIIIIIlllIllllll.m33 * lllllllllllllllllIIIIIlllIlllllI.m31;
            this.m32 = lllllllllllllllllIIIIIlllIllllll.m30 * lllllllllllllllllIIIIIlllIlllllI.m02 + lllllllllllllllllIIIIIlllIllllll.m31 * lllllllllllllllllIIIIIlllIlllllI.m12 + lllllllllllllllllIIIIIlllIllllll.m32 * lllllllllllllllllIIIIIlllIlllllI.m22 + lllllllllllllllllIIIIIlllIllllll.m33 * lllllllllllllllllIIIIIlllIlllllI.m32;
            this.m33 = lllllllllllllllllIIIIIlllIllllll.m30 * lllllllllllllllllIIIIIlllIlllllI.m03 + lllllllllllllllllIIIIIlllIllllll.m31 * lllllllllllllllllIIIIIlllIlllllI.m13 + lllllllllllllllllIIIIIlllIllllll.m32 * lllllllllllllllllIIIIIlllIlllllI.m23 + lllllllllllllllllIIIIIlllIllllll.m33 * lllllllllllllllllIIIIIlllIlllllI.m33;
        }
        else {
            final float lllllllllllllllllIIIIIlllIllllIl = lllllllllllllllllIIIIIlllIllllll.m00 * lllllllllllllllllIIIIIlllIlllllI.m00 + lllllllllllllllllIIIIIlllIllllll.m01 * lllllllllllllllllIIIIIlllIlllllI.m10 + lllllllllllllllllIIIIIlllIllllll.m02 * lllllllllllllllllIIIIIlllIlllllI.m20 + lllllllllllllllllIIIIIlllIllllll.m03 * lllllllllllllllllIIIIIlllIlllllI.m30;
            final float lllllllllllllllllIIIIIlllIllllII = lllllllllllllllllIIIIIlllIllllll.m00 * lllllllllllllllllIIIIIlllIlllllI.m01 + lllllllllllllllllIIIIIlllIllllll.m01 * lllllllllllllllllIIIIIlllIlllllI.m11 + lllllllllllllllllIIIIIlllIllllll.m02 * lllllllllllllllllIIIIIlllIlllllI.m21 + lllllllllllllllllIIIIIlllIllllll.m03 * lllllllllllllllllIIIIIlllIlllllI.m31;
            final float lllllllllllllllllIIIIIlllIlllIll = lllllllllllllllllIIIIIlllIllllll.m00 * lllllllllllllllllIIIIIlllIlllllI.m02 + lllllllllllllllllIIIIIlllIllllll.m01 * lllllllllllllllllIIIIIlllIlllllI.m12 + lllllllllllllllllIIIIIlllIllllll.m02 * lllllllllllllllllIIIIIlllIlllllI.m22 + lllllllllllllllllIIIIIlllIllllll.m03 * lllllllllllllllllIIIIIlllIlllllI.m32;
            final float lllllllllllllllllIIIIIlllIlllIlI = lllllllllllllllllIIIIIlllIllllll.m00 * lllllllllllllllllIIIIIlllIlllllI.m03 + lllllllllllllllllIIIIIlllIllllll.m01 * lllllllllllllllllIIIIIlllIlllllI.m13 + lllllllllllllllllIIIIIlllIllllll.m02 * lllllllllllllllllIIIIIlllIlllllI.m23 + lllllllllllllllllIIIIIlllIllllll.m03 * lllllllllllllllllIIIIIlllIlllllI.m33;
            final float lllllllllllllllllIIIIIlllIlllIIl = lllllllllllllllllIIIIIlllIllllll.m10 * lllllllllllllllllIIIIIlllIlllllI.m00 + lllllllllllllllllIIIIIlllIllllll.m11 * lllllllllllllllllIIIIIlllIlllllI.m10 + lllllllllllllllllIIIIIlllIllllll.m12 * lllllllllllllllllIIIIIlllIlllllI.m20 + lllllllllllllllllIIIIIlllIllllll.m13 * lllllllllllllllllIIIIIlllIlllllI.m30;
            final float lllllllllllllllllIIIIIlllIlllIII = lllllllllllllllllIIIIIlllIllllll.m10 * lllllllllllllllllIIIIIlllIlllllI.m01 + lllllllllllllllllIIIIIlllIllllll.m11 * lllllllllllllllllIIIIIlllIlllllI.m11 + lllllllllllllllllIIIIIlllIllllll.m12 * lllllllllllllllllIIIIIlllIlllllI.m21 + lllllllllllllllllIIIIIlllIllllll.m13 * lllllllllllllllllIIIIIlllIlllllI.m31;
            final float lllllllllllllllllIIIIIlllIllIlll = lllllllllllllllllIIIIIlllIllllll.m10 * lllllllllllllllllIIIIIlllIlllllI.m02 + lllllllllllllllllIIIIIlllIllllll.m11 * lllllllllllllllllIIIIIlllIlllllI.m12 + lllllllllllllllllIIIIIlllIllllll.m12 * lllllllllllllllllIIIIIlllIlllllI.m22 + lllllllllllllllllIIIIIlllIllllll.m13 * lllllllllllllllllIIIIIlllIlllllI.m32;
            final float lllllllllllllllllIIIIIlllIllIllI = lllllllllllllllllIIIIIlllIllllll.m10 * lllllllllllllllllIIIIIlllIlllllI.m03 + lllllllllllllllllIIIIIlllIllllll.m11 * lllllllllllllllllIIIIIlllIlllllI.m13 + lllllllllllllllllIIIIIlllIllllll.m12 * lllllllllllllllllIIIIIlllIlllllI.m23 + lllllllllllllllllIIIIIlllIllllll.m13 * lllllllllllllllllIIIIIlllIlllllI.m33;
            final float lllllllllllllllllIIIIIlllIllIlIl = lllllllllllllllllIIIIIlllIllllll.m20 * lllllllllllllllllIIIIIlllIlllllI.m00 + lllllllllllllllllIIIIIlllIllllll.m21 * lllllllllllllllllIIIIIlllIlllllI.m10 + lllllllllllllllllIIIIIlllIllllll.m22 * lllllllllllllllllIIIIIlllIlllllI.m20 + lllllllllllllllllIIIIIlllIllllll.m23 * lllllllllllllllllIIIIIlllIlllllI.m30;
            final float lllllllllllllllllIIIIIlllIllIlII = lllllllllllllllllIIIIIlllIllllll.m20 * lllllllllllllllllIIIIIlllIlllllI.m01 + lllllllllllllllllIIIIIlllIllllll.m21 * lllllllllllllllllIIIIIlllIlllllI.m11 + lllllllllllllllllIIIIIlllIllllll.m22 * lllllllllllllllllIIIIIlllIlllllI.m21 + lllllllllllllllllIIIIIlllIllllll.m23 * lllllllllllllllllIIIIIlllIlllllI.m31;
            final float lllllllllllllllllIIIIIlllIllIIll = lllllllllllllllllIIIIIlllIllllll.m20 * lllllllllllllllllIIIIIlllIlllllI.m02 + lllllllllllllllllIIIIIlllIllllll.m21 * lllllllllllllllllIIIIIlllIlllllI.m12 + lllllllllllllllllIIIIIlllIllllll.m22 * lllllllllllllllllIIIIIlllIlllllI.m22 + lllllllllllllllllIIIIIlllIllllll.m23 * lllllllllllllllllIIIIIlllIlllllI.m32;
            final float lllllllllllllllllIIIIIlllIllIIlI = lllllllllllllllllIIIIIlllIllllll.m20 * lllllllllllllllllIIIIIlllIlllllI.m03 + lllllllllllllllllIIIIIlllIllllll.m21 * lllllllllllllllllIIIIIlllIlllllI.m13 + lllllllllllllllllIIIIIlllIllllll.m22 * lllllllllllllllllIIIIIlllIlllllI.m23 + lllllllllllllllllIIIIIlllIllllll.m23 * lllllllllllllllllIIIIIlllIlllllI.m33;
            final float lllllllllllllllllIIIIIlllIllIIIl = lllllllllllllllllIIIIIlllIllllll.m30 * lllllllllllllllllIIIIIlllIlllllI.m00 + lllllllllllllllllIIIIIlllIllllll.m31 * lllllllllllllllllIIIIIlllIlllllI.m10 + lllllllllllllllllIIIIIlllIllllll.m32 * lllllllllllllllllIIIIIlllIlllllI.m20 + lllllllllllllllllIIIIIlllIllllll.m33 * lllllllllllllllllIIIIIlllIlllllI.m30;
            final float lllllllllllllllllIIIIIlllIllIIII = lllllllllllllllllIIIIIlllIllllll.m30 * lllllllllllllllllIIIIIlllIlllllI.m01 + lllllllllllllllllIIIIIlllIllllll.m31 * lllllllllllllllllIIIIIlllIlllllI.m11 + lllllllllllllllllIIIIIlllIllllll.m32 * lllllllllllllllllIIIIIlllIlllllI.m21 + lllllllllllllllllIIIIIlllIllllll.m33 * lllllllllllllllllIIIIIlllIlllllI.m31;
            final float lllllllllllllllllIIIIIlllIlIllll = lllllllllllllllllIIIIIlllIllllll.m30 * lllllllllllllllllIIIIIlllIlllllI.m02 + lllllllllllllllllIIIIIlllIllllll.m31 * lllllllllllllllllIIIIIlllIlllllI.m12 + lllllllllllllllllIIIIIlllIllllll.m32 * lllllllllllllllllIIIIIlllIlllllI.m22 + lllllllllllllllllIIIIIlllIllllll.m33 * lllllllllllllllllIIIIIlllIlllllI.m32;
            final float lllllllllllllllllIIIIIlllIlIlllI = lllllllllllllllllIIIIIlllIllllll.m30 * lllllllllllllllllIIIIIlllIlllllI.m03 + lllllllllllllllllIIIIIlllIllllll.m31 * lllllllllllllllllIIIIIlllIlllllI.m13 + lllllllllllllllllIIIIIlllIllllll.m32 * lllllllllllllllllIIIIIlllIlllllI.m23 + lllllllllllllllllIIIIIlllIllllll.m33 * lllllllllllllllllIIIIIlllIlllllI.m33;
            this.m00 = lllllllllllllllllIIIIIlllIllllIl;
            this.m01 = lllllllllllllllllIIIIIlllIllllII;
            this.m02 = lllllllllllllllllIIIIIlllIlllIll;
            this.m03 = lllllllllllllllllIIIIIlllIlllIlI;
            this.m10 = lllllllllllllllllIIIIIlllIlllIIl;
            this.m11 = lllllllllllllllllIIIIIlllIlllIII;
            this.m12 = lllllllllllllllllIIIIIlllIllIlll;
            this.m13 = lllllllllllllllllIIIIIlllIllIllI;
            this.m20 = lllllllllllllllllIIIIIlllIllIlIl;
            this.m21 = lllllllllllllllllIIIIIlllIllIlII;
            this.m22 = lllllllllllllllllIIIIIlllIllIIll;
            this.m23 = lllllllllllllllllIIIIIlllIllIIlI;
            this.m30 = lllllllllllllllllIIIIIlllIllIIIl;
            this.m31 = lllllllllllllllllIIIIIlllIllIIII;
            this.m32 = lllllllllllllllllIIIIIlllIlIllll;
            this.m33 = lllllllllllllllllIIIIIlllIlIlllI;
        }
    }
    
    public final void rotX(final float lllllllllllllllllIIIIlIIIIllIIll) {
        final float lllllllllllllllllIIIIlIIIIllIllI = (float)Math.sin(lllllllllllllllllIIIIlIIIIllIIll);
        final float lllllllllllllllllIIIIlIIIIllIlIl = (float)Math.cos(lllllllllllllllllIIIIlIIIIllIIll);
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = lllllllllllllllllIIIIlIIIIllIlIl;
        this.m12 = -lllllllllllllllllIIIIlIIIIllIllI;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = lllllllllllllllllIIIIlIIIIllIllI;
        this.m22 = lllllllllllllllllIIIIlIIIIllIlIl;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void setM31(final float lllllllllllllllllIIIIIIlIllllIlI) {
        this.m31 = lllllllllllllllllIIIIIIlIllllIlI;
    }
    
    public final void sub(final Matrix4f lllllllllllllllllIIIIlIllIIllIlI, final Matrix4f lllllllllllllllllIIIIlIllIIllIIl) {
        this.m00 = lllllllllllllllllIIIIlIllIIllIlI.m00 - lllllllllllllllllIIIIlIllIIllIIl.m00;
        this.m01 = lllllllllllllllllIIIIlIllIIllIlI.m01 - lllllllllllllllllIIIIlIllIIllIIl.m01;
        this.m02 = lllllllllllllllllIIIIlIllIIllIlI.m02 - lllllllllllllllllIIIIlIllIIllIIl.m02;
        this.m03 = lllllllllllllllllIIIIlIllIIllIlI.m03 - lllllllllllllllllIIIIlIllIIllIIl.m03;
        this.m10 = lllllllllllllllllIIIIlIllIIllIlI.m10 - lllllllllllllllllIIIIlIllIIllIIl.m10;
        this.m11 = lllllllllllllllllIIIIlIllIIllIlI.m11 - lllllllllllllllllIIIIlIllIIllIIl.m11;
        this.m12 = lllllllllllllllllIIIIlIllIIllIlI.m12 - lllllllllllllllllIIIIlIllIIllIIl.m12;
        this.m13 = lllllllllllllllllIIIIlIllIIllIlI.m13 - lllllllllllllllllIIIIlIllIIllIIl.m13;
        this.m20 = lllllllllllllllllIIIIlIllIIllIlI.m20 - lllllllllllllllllIIIIlIllIIllIIl.m20;
        this.m21 = lllllllllllllllllIIIIlIllIIllIlI.m21 - lllllllllllllllllIIIIlIllIIllIIl.m21;
        this.m22 = lllllllllllllllllIIIIlIllIIllIlI.m22 - lllllllllllllllllIIIIlIllIIllIIl.m22;
        this.m23 = lllllllllllllllllIIIIlIllIIllIlI.m23 - lllllllllllllllllIIIIlIllIIllIIl.m23;
        this.m30 = lllllllllllllllllIIIIlIllIIllIlI.m30 - lllllllllllllllllIIIIlIllIIllIIl.m30;
        this.m31 = lllllllllllllllllIIIIlIllIIllIlI.m31 - lllllllllllllllllIIIIlIllIIllIIl.m31;
        this.m32 = lllllllllllllllllIIIIlIllIIllIlI.m32 - lllllllllllllllllIIIIlIllIIllIIl.m32;
        this.m33 = lllllllllllllllllIIIIlIllIIllIlI.m33 - lllllllllllllllllIIIIlIllIIllIIl.m33;
    }
    
    public final void setM30(final float lllllllllllllllllIIIIIIllIIIIlIl) {
        this.m30 = lllllllllllllllllIIIIIIllIIIIlIl;
    }
    
    public final void add(final Matrix4f lllllllllllllllllIIIIlIllIlIIIIl) {
        this.m00 += lllllllllllllllllIIIIlIllIlIIIIl.m00;
        this.m01 += lllllllllllllllllIIIIlIllIlIIIIl.m01;
        this.m02 += lllllllllllllllllIIIIlIllIlIIIIl.m02;
        this.m03 += lllllllllllllllllIIIIlIllIlIIIIl.m03;
        this.m10 += lllllllllllllllllIIIIlIllIlIIIIl.m10;
        this.m11 += lllllllllllllllllIIIIlIllIlIIIIl.m11;
        this.m12 += lllllllllllllllllIIIIlIllIlIIIIl.m12;
        this.m13 += lllllllllllllllllIIIIlIllIlIIIIl.m13;
        this.m20 += lllllllllllllllllIIIIlIllIlIIIIl.m20;
        this.m21 += lllllllllllllllllIIIIlIllIlIIIIl.m21;
        this.m22 += lllllllllllllllllIIIIlIllIlIIIIl.m22;
        this.m23 += lllllllllllllllllIIIIlIllIlIIIIl.m23;
        this.m30 += lllllllllllllllllIIIIlIllIlIIIIl.m30;
        this.m31 += lllllllllllllllllIIIIlIllIlIIIIl.m31;
        this.m32 += lllllllllllllllllIIIIlIllIlIIIIl.m32;
        this.m33 += lllllllllllllllllIIIIlIllIlIIIIl.m33;
    }
    
    public final float getM10() {
        return this.m10;
    }
    
    public final void setM00(final float lllllllllllllllllIIIIIIlllllIIIl) {
        this.m00 = lllllllllllllllllIIIIIIlllllIIIl;
    }
    
    public final void setRotationScale(final Matrix3f lllllllllllllllllIIIIllIIIIlllII) {
        this.m00 = lllllllllllllllllIIIIllIIIIlllII.m00;
        this.m01 = lllllllllllllllllIIIIllIIIIlllII.m01;
        this.m02 = lllllllllllllllllIIIIllIIIIlllII.m02;
        this.m10 = lllllllllllllllllIIIIllIIIIlllII.m10;
        this.m11 = lllllllllllllllllIIIIllIIIIlllII.m11;
        this.m12 = lllllllllllllllllIIIIllIIIIlllII.m12;
        this.m20 = lllllllllllllllllIIIIllIIIIlllII.m20;
        this.m21 = lllllllllllllllllIIIIllIIIIlllII.m21;
        this.m22 = lllllllllllllllllIIIIllIIIIlllII.m22;
    }
    
    public final void getRotationScale(final Matrix3f lllllllllllllllllIIIIllIIIlIlIIl) {
        lllllllllllllllllIIIIllIIIlIlIIl.m00 = this.m00;
        lllllllllllllllllIIIIllIIIlIlIIl.m01 = this.m01;
        lllllllllllllllllIIIIllIIIlIlIIl.m02 = this.m02;
        lllllllllllllllllIIIIllIIIlIlIIl.m10 = this.m10;
        lllllllllllllllllIIIIllIIIlIlIIl.m11 = this.m11;
        lllllllllllllllllIIIIllIIIlIlIIl.m12 = this.m12;
        lllllllllllllllllIIIIllIIIlIlIIl.m20 = this.m20;
        lllllllllllllllllIIIIllIIIlIlIIl.m21 = this.m21;
        lllllllllllllllllIIIIllIIIlIlIIl.m22 = this.m22;
    }
    
    public Matrix4f() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
    }
    
    public final void setZero() {
        this.m00 = 0.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 0.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 0.0f;
    }
    
    public final void setIdentity() {
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = 1.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void set(final Matrix3d lllllllllllllllllIIIIlIIIlllllll) {
        this.m00 = (float)lllllllllllllllllIIIIlIIIlllllll.m00;
        this.m01 = (float)lllllllllllllllllIIIIlIIIlllllll.m01;
        this.m02 = (float)lllllllllllllllllIIIIlIIIlllllll.m02;
        this.m03 = 0.0f;
        this.m10 = (float)lllllllllllllllllIIIIlIIIlllllll.m10;
        this.m11 = (float)lllllllllllllllllIIIIlIIIlllllll.m11;
        this.m12 = (float)lllllllllllllllllIIIIlIIIlllllll.m12;
        this.m13 = 0.0f;
        this.m20 = (float)lllllllllllllllllIIIIlIIIlllllll.m20;
        this.m21 = (float)lllllllllllllllllIIIIlIIIlllllll.m21;
        this.m22 = (float)lllllllllllllllllIIIIlIIIlllllll.m22;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void setM23(final float lllllllllllllllllIIIIIIllIIIllII) {
        this.m23 = lllllllllllllllllIIIIIIllIIIllII;
    }
    
    public final void sub(final Matrix4f lllllllllllllllllIIIIlIllIIlIIlI) {
        this.m00 -= lllllllllllllllllIIIIlIllIIlIIlI.m00;
        this.m01 -= lllllllllllllllllIIIIlIllIIlIIlI.m01;
        this.m02 -= lllllllllllllllllIIIIlIllIIlIIlI.m02;
        this.m03 -= lllllllllllllllllIIIIlIllIIlIIlI.m03;
        this.m10 -= lllllllllllllllllIIIIlIllIIlIIlI.m10;
        this.m11 -= lllllllllllllllllIIIIlIllIIlIIlI.m11;
        this.m12 -= lllllllllllllllllIIIIlIllIIlIIlI.m12;
        this.m13 -= lllllllllllllllllIIIIlIllIIlIIlI.m13;
        this.m20 -= lllllllllllllllllIIIIlIllIIlIIlI.m20;
        this.m21 -= lllllllllllllllllIIIIlIllIIlIIlI.m21;
        this.m22 -= lllllllllllllllllIIIIlIllIIlIIlI.m22;
        this.m23 -= lllllllllllllllllIIIIlIllIIlIIlI.m23;
        this.m30 -= lllllllllllllllllIIIIlIllIIlIIlI.m30;
        this.m31 -= lllllllllllllllllIIIIlIllIIlIIlI.m31;
        this.m32 -= lllllllllllllllllIIIIlIllIIlIIlI.m32;
        this.m33 -= lllllllllllllllllIIIIlIllIIlIIlI.m33;
    }
    
    public final void set(final Quat4f lllllllllllllllllIIIIlIlIIIllIlI, final Vector3f lllllllllllllllllIIIIlIlIIIlllIl, final float lllllllllllllllllIIIIlIlIIIlllII) {
        this.m00 = lllllllllllllllllIIIIlIlIIIlllII * (1.0f - 2.0f * lllllllllllllllllIIIIlIlIIIllIlI.y * lllllllllllllllllIIIIlIlIIIllIlI.y - 2.0f * lllllllllllllllllIIIIlIlIIIllIlI.z * lllllllllllllllllIIIIlIlIIIllIlI.z);
        this.m10 = lllllllllllllllllIIIIlIlIIIlllII * (2.0f * (lllllllllllllllllIIIIlIlIIIllIlI.x * lllllllllllllllllIIIIlIlIIIllIlI.y + lllllllllllllllllIIIIlIlIIIllIlI.w * lllllllllllllllllIIIIlIlIIIllIlI.z));
        this.m20 = lllllllllllllllllIIIIlIlIIIlllII * (2.0f * (lllllllllllllllllIIIIlIlIIIllIlI.x * lllllllllllllllllIIIIlIlIIIllIlI.z - lllllllllllllllllIIIIlIlIIIllIlI.w * lllllllllllllllllIIIIlIlIIIllIlI.y));
        this.m01 = lllllllllllllllllIIIIlIlIIIlllII * (2.0f * (lllllllllllllllllIIIIlIlIIIllIlI.x * lllllllllllllllllIIIIlIlIIIllIlI.y - lllllllllllllllllIIIIlIlIIIllIlI.w * lllllllllllllllllIIIIlIlIIIllIlI.z));
        this.m11 = lllllllllllllllllIIIIlIlIIIlllII * (1.0f - 2.0f * lllllllllllllllllIIIIlIlIIIllIlI.x * lllllllllllllllllIIIIlIlIIIllIlI.x - 2.0f * lllllllllllllllllIIIIlIlIIIllIlI.z * lllllllllllllllllIIIIlIlIIIllIlI.z);
        this.m21 = lllllllllllllllllIIIIlIlIIIlllII * (2.0f * (lllllllllllllllllIIIIlIlIIIllIlI.y * lllllllllllllllllIIIIlIlIIIllIlI.z + lllllllllllllllllIIIIlIlIIIllIlI.w * lllllllllllllllllIIIIlIlIIIllIlI.x));
        this.m02 = lllllllllllllllllIIIIlIlIIIlllII * (2.0f * (lllllllllllllllllIIIIlIlIIIllIlI.x * lllllllllllllllllIIIIlIlIIIllIlI.z + lllllllllllllllllIIIIlIlIIIllIlI.w * lllllllllllllllllIIIIlIlIIIllIlI.y));
        this.m12 = lllllllllllllllllIIIIlIlIIIlllII * (2.0f * (lllllllllllllllllIIIIlIlIIIllIlI.y * lllllllllllllllllIIIIlIlIIIllIlI.z - lllllllllllllllllIIIIlIlIIIllIlI.w * lllllllllllllllllIIIIlIlIIIllIlI.x));
        this.m22 = lllllllllllllllllIIIIlIlIIIlllII * (1.0f - 2.0f * lllllllllllllllllIIIIlIlIIIllIlI.x * lllllllllllllllllIIIIlIlIIIllIlI.x - 2.0f * lllllllllllllllllIIIIlIlIIIllIlI.y * lllllllllllllllllIIIIlIlIIIllIlI.y);
        this.m03 = lllllllllllllllllIIIIlIlIIIlllIl.x;
        this.m13 = lllllllllllllllllIIIIlIlIIIlllIl.y;
        this.m23 = lllllllllllllllllIIIIlIlIIIlllIl.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void setM02(final float lllllllllllllllllIIIIIIlllIlllll) {
        this.m02 = lllllllllllllllllIIIIIIlllIlllll;
    }
    
    public final float getM32() {
        return this.m32;
    }
    
    public final void get(final Matrix3d lllllllllllllllllIIIIllIIllIIlIl) {
        final double[] lllllllllllllllllIIIIllIIllIIlII = new double[9];
        final double[] lllllllllllllllllIIIIllIIllIIIll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIllIIllIIIll, lllllllllllllllllIIIIllIIllIIlII);
        lllllllllllllllllIIIIllIIllIIlIl.m00 = lllllllllllllllllIIIIllIIllIIlII[0];
        lllllllllllllllllIIIIllIIllIIlIl.m01 = lllllllllllllllllIIIIllIIllIIlII[1];
        lllllllllllllllllIIIIllIIllIIlIl.m02 = lllllllllllllllllIIIIllIIllIIlII[2];
        lllllllllllllllllIIIIllIIllIIlIl.m10 = lllllllllllllllllIIIIllIIllIIlII[3];
        lllllllllllllllllIIIIllIIllIIlIl.m11 = lllllllllllllllllIIIIllIIllIIlII[4];
        lllllllllllllllllIIIIllIIllIIlIl.m12 = lllllllllllllllllIIIIllIIllIIlII[5];
        lllllllllllllllllIIIIllIIllIIlIl.m20 = lllllllllllllllllIIIIllIIllIIlII[6];
        lllllllllllllllllIIIIllIIllIIlIl.m21 = lllllllllllllllllIIIIllIIllIIlII[7];
        lllllllllllllllllIIIIllIIllIIlIl.m22 = lllllllllllllllllIIIIllIIllIIlII[8];
    }
    
    public final void transform(final Vector3f lllllllllllllllllIIIIIlIlIIIIIlI, final Vector3f lllllllllllllllllIIIIIlIlIIIIllI) {
        final float lllllllllllllllllIIIIIlIlIIIIlIl = this.m00 * lllllllllllllllllIIIIIlIlIIIIIlI.x + this.m01 * lllllllllllllllllIIIIIlIlIIIIIlI.y + this.m02 * lllllllllllllllllIIIIIlIlIIIIIlI.z;
        final float lllllllllllllllllIIIIIlIlIIIIlII = this.m10 * lllllllllllllllllIIIIIlIlIIIIIlI.x + this.m11 * lllllllllllllllllIIIIIlIlIIIIIlI.y + this.m12 * lllllllllllllllllIIIIIlIlIIIIIlI.z;
        lllllllllllllllllIIIIIlIlIIIIllI.z = this.m20 * lllllllllllllllllIIIIIlIlIIIIIlI.x + this.m21 * lllllllllllllllllIIIIIlIlIIIIIlI.y + this.m22 * lllllllllllllllllIIIIIlIlIIIIIlI.z;
        lllllllllllllllllIIIIIlIlIIIIllI.x = lllllllllllllllllIIIIIlIlIIIIlIl;
        lllllllllllllllllIIIIIlIlIIIIllI.y = lllllllllllllllllIIIIIlIlIIIIlII;
    }
    
    public final void transform(final Tuple4f lllllllllllllllllIIIIIlIlIlIllII) {
        final float lllllllllllllllllIIIIIlIlIllIIII = this.m00 * lllllllllllllllllIIIIIlIlIlIllII.x + this.m01 * lllllllllllllllllIIIIIlIlIlIllII.y + this.m02 * lllllllllllllllllIIIIIlIlIlIllII.z + this.m03 * lllllllllllllllllIIIIIlIlIlIllII.w;
        final float lllllllllllllllllIIIIIlIlIlIllll = this.m10 * lllllllllllllllllIIIIIlIlIlIllII.x + this.m11 * lllllllllllllllllIIIIIlIlIlIllII.y + this.m12 * lllllllllllllllllIIIIIlIlIlIllII.z + this.m13 * lllllllllllllllllIIIIIlIlIlIllII.w;
        final float lllllllllllllllllIIIIIlIlIlIlllI = this.m20 * lllllllllllllllllIIIIIlIlIlIllII.x + this.m21 * lllllllllllllllllIIIIIlIlIlIllII.y + this.m22 * lllllllllllllllllIIIIIlIlIlIllII.z + this.m23 * lllllllllllllllllIIIIIlIlIlIllII.w;
        lllllllllllllllllIIIIIlIlIlIllII.w = this.m30 * lllllllllllllllllIIIIIlIlIlIllII.x + this.m31 * lllllllllllllllllIIIIIlIlIlIllII.y + this.m32 * lllllllllllllllllIIIIIlIlIlIllII.z + this.m33 * lllllllllllllllllIIIIIlIlIlIllII.w;
        lllllllllllllllllIIIIIlIlIlIllII.x = lllllllllllllllllIIIIIlIlIllIIII;
        lllllllllllllllllIIIIIlIlIlIllII.y = lllllllllllllllllIIIIIlIlIlIllll;
        lllllllllllllllllIIIIIlIlIlIllII.z = lllllllllllllllllIIIIIlIlIlIlllI;
    }
    
    public Matrix4f(final Matrix4d lllllllllllllllllIIIIllIllIIlIll) {
        this.m00 = (float)lllllllllllllllllIIIIllIllIIlIll.m00;
        this.m01 = (float)lllllllllllllllllIIIIllIllIIlIll.m01;
        this.m02 = (float)lllllllllllllllllIIIIllIllIIlIll.m02;
        this.m03 = (float)lllllllllllllllllIIIIllIllIIlIll.m03;
        this.m10 = (float)lllllllllllllllllIIIIllIllIIlIll.m10;
        this.m11 = (float)lllllllllllllllllIIIIllIllIIlIll.m11;
        this.m12 = (float)lllllllllllllllllIIIIllIllIIlIll.m12;
        this.m13 = (float)lllllllllllllllllIIIIllIllIIlIll.m13;
        this.m20 = (float)lllllllllllllllllIIIIllIllIIlIll.m20;
        this.m21 = (float)lllllllllllllllllIIIIllIllIIlIll.m21;
        this.m22 = (float)lllllllllllllllllIIIIllIllIIlIll.m22;
        this.m23 = (float)lllllllllllllllllIIIIllIllIIlIll.m23;
        this.m30 = (float)lllllllllllllllllIIIIllIllIIlIll.m30;
        this.m31 = (float)lllllllllllllllllIIIIllIllIIlIll.m31;
        this.m32 = (float)lllllllllllllllllIIIIllIllIIlIll.m32;
        this.m33 = (float)lllllllllllllllllIIIIllIllIIlIll.m33;
    }
    
    final void invertGeneral(final Matrix4f lllllllllllllllllIIIIlIIlllllIll) {
        final double[] lllllllllllllllllIIIIlIIlllllIlI = new double[16];
        final double[] lllllllllllllllllIIIIlIIlllllIIl = new double[16];
        final int[] lllllllllllllllllIIIIlIIlllllIII = new int[4];
        lllllllllllllllllIIIIlIIlllllIlI[0] = lllllllllllllllllIIIIlIIlllllIll.m00;
        lllllllllllllllllIIIIlIIlllllIlI[1] = lllllllllllllllllIIIIlIIlllllIll.m01;
        lllllllllllllllllIIIIlIIlllllIlI[2] = lllllllllllllllllIIIIlIIlllllIll.m02;
        lllllllllllllllllIIIIlIIlllllIlI[3] = lllllllllllllllllIIIIlIIlllllIll.m03;
        lllllllllllllllllIIIIlIIlllllIlI[4] = lllllllllllllllllIIIIlIIlllllIll.m10;
        lllllllllllllllllIIIIlIIlllllIlI[5] = lllllllllllllllllIIIIlIIlllllIll.m11;
        lllllllllllllllllIIIIlIIlllllIlI[6] = lllllllllllllllllIIIIlIIlllllIll.m12;
        lllllllllllllllllIIIIlIIlllllIlI[7] = lllllllllllllllllIIIIlIIlllllIll.m13;
        lllllllllllllllllIIIIlIIlllllIlI[8] = lllllllllllllllllIIIIlIIlllllIll.m20;
        lllllllllllllllllIIIIlIIlllllIlI[9] = lllllllllllllllllIIIIlIIlllllIll.m21;
        lllllllllllllllllIIIIlIIlllllIlI[10] = lllllllllllllllllIIIIlIIlllllIll.m22;
        lllllllllllllllllIIIIlIIlllllIlI[11] = lllllllllllllllllIIIIlIIlllllIll.m23;
        lllllllllllllllllIIIIlIIlllllIlI[12] = lllllllllllllllllIIIIlIIlllllIll.m30;
        lllllllllllllllllIIIIlIIlllllIlI[13] = lllllllllllllllllIIIIlIIlllllIll.m31;
        lllllllllllllllllIIIIlIIlllllIlI[14] = lllllllllllllllllIIIIlIIlllllIll.m32;
        lllllllllllllllllIIIIlIIlllllIlI[15] = lllllllllllllllllIIIIlIIlllllIll.m33;
        if (!luDecomposition(lllllllllllllllllIIIIlIIlllllIlI, lllllllllllllllllIIIIlIIlllllIII)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix4f12"));
        }
        for (int lllllllllllllllllIIIIlIIllllIlll = 0; lllllllllllllllllIIIIlIIllllIlll < 16; ++lllllllllllllllllIIIIlIIllllIlll) {
            lllllllllllllllllIIIIlIIlllllIIl[lllllllllllllllllIIIIlIIllllIlll] = 0.0;
        }
        lllllllllllllllllIIIIlIIlllllIIl[5] = (lllllllllllllllllIIIIlIIlllllIIl[0] = 1.0);
        lllllllllllllllllIIIIlIIlllllIIl[15] = (lllllllllllllllllIIIIlIIlllllIIl[10] = 1.0);
        luBacksubstitution(lllllllllllllllllIIIIlIIlllllIlI, lllllllllllllllllIIIIlIIlllllIII, lllllllllllllllllIIIIlIIlllllIIl);
        this.m00 = (float)lllllllllllllllllIIIIlIIlllllIIl[0];
        this.m01 = (float)lllllllllllllllllIIIIlIIlllllIIl[1];
        this.m02 = (float)lllllllllllllllllIIIIlIIlllllIIl[2];
        this.m03 = (float)lllllllllllllllllIIIIlIIlllllIIl[3];
        this.m10 = (float)lllllllllllllllllIIIIlIIlllllIIl[4];
        this.m11 = (float)lllllllllllllllllIIIIlIIlllllIIl[5];
        this.m12 = (float)lllllllllllllllllIIIIlIIlllllIIl[6];
        this.m13 = (float)lllllllllllllllllIIIIlIIlllllIIl[7];
        this.m20 = (float)lllllllllllllllllIIIIlIIlllllIIl[8];
        this.m21 = (float)lllllllllllllllllIIIIlIIlllllIIl[9];
        this.m22 = (float)lllllllllllllllllIIIIlIIlllllIIl[10];
        this.m23 = (float)lllllllllllllllllIIIIlIIlllllIIl[11];
        this.m30 = (float)lllllllllllllllllIIIIlIIlllllIIl[12];
        this.m31 = (float)lllllllllllllllllIIIIlIIlllllIIl[13];
        this.m32 = (float)lllllllllllllllllIIIIlIIlllllIIl[14];
        this.m33 = (float)lllllllllllllllllIIIIlIIlllllIIl[15];
    }
    
    public final void transform(final Tuple4f lllllllllllllllllIIIIIlIlIllllII, final Tuple4f lllllllllllllllllIIIIIlIlIlllIll) {
        final float lllllllllllllllllIIIIIlIllIIIIII = this.m00 * lllllllllllllllllIIIIIlIlIllllII.x + this.m01 * lllllllllllllllllIIIIIlIlIllllII.y + this.m02 * lllllllllllllllllIIIIIlIlIllllII.z + this.m03 * lllllllllllllllllIIIIIlIlIllllII.w;
        final float lllllllllllllllllIIIIIlIlIllllll = this.m10 * lllllllllllllllllIIIIIlIlIllllII.x + this.m11 * lllllllllllllllllIIIIIlIlIllllII.y + this.m12 * lllllllllllllllllIIIIIlIlIllllII.z + this.m13 * lllllllllllllllllIIIIIlIlIllllII.w;
        final float lllllllllllllllllIIIIIlIlIlllllI = this.m20 * lllllllllllllllllIIIIIlIlIllllII.x + this.m21 * lllllllllllllllllIIIIIlIlIllllII.y + this.m22 * lllllllllllllllllIIIIIlIlIllllII.z + this.m23 * lllllllllllllllllIIIIIlIlIllllII.w;
        lllllllllllllllllIIIIIlIlIlllIll.w = this.m30 * lllllllllllllllllIIIIIlIlIllllII.x + this.m31 * lllllllllllllllllIIIIIlIlIllllII.y + this.m32 * lllllllllllllllllIIIIIlIlIllllII.z + this.m33 * lllllllllllllllllIIIIIlIlIllllII.w;
        lllllllllllllllllIIIIIlIlIlllIll.x = lllllllllllllllllIIIIIlIllIIIIII;
        lllllllllllllllllIIIIIlIlIlllIll.y = lllllllllllllllllIIIIIlIlIllllll;
        lllllllllllllllllIIIIIlIlIlllIll.z = lllllllllllllllllIIIIIlIlIlllllI;
    }
    
    public final void transform(final Vector3f lllllllllllllllllIIIIIlIIlllIlIl) {
        final float lllllllllllllllllIIIIIlIIllllIII = this.m00 * lllllllllllllllllIIIIIlIIlllIlIl.x + this.m01 * lllllllllllllllllIIIIIlIIlllIlIl.y + this.m02 * lllllllllllllllllIIIIIlIIlllIlIl.z;
        final float lllllllllllllllllIIIIIlIIlllIlll = this.m10 * lllllllllllllllllIIIIIlIIlllIlIl.x + this.m11 * lllllllllllllllllIIIIIlIIlllIlIl.y + this.m12 * lllllllllllllllllIIIIIlIIlllIlIl.z;
        lllllllllllllllllIIIIIlIIlllIlIl.z = this.m20 * lllllllllllllllllIIIIIlIIlllIlIl.x + this.m21 * lllllllllllllllllIIIIIlIIlllIlIl.y + this.m22 * lllllllllllllllllIIIIIlIIlllIlIl.z;
        lllllllllllllllllIIIIIlIIlllIlIl.x = lllllllllllllllllIIIIIlIIllllIII;
        lllllllllllllllllIIIIIlIIlllIlIl.y = lllllllllllllllllIIIIIlIIlllIlll;
    }
    
    public final void setM11(final float lllllllllllllllllIIIIIIlllIIllIl) {
        this.m11 = lllllllllllllllllIIIIIIlllIIllIl;
    }
    
    public Matrix4f(final float lllllllllllllllllIIIIlllIIIllIll, final float lllllllllllllllllIIIIlllIIIllIIl, final float lllllllllllllllllIIIIlllIIIlIlll, final float lllllllllllllllllIIIIlllIIIlIlIl, final float lllllllllllllllllIIIIlllIIIlIIll, final float lllllllllllllllllIIIIlllIIIlIIIl, final float lllllllllllllllllIIIIlllIIlIlIll, final float lllllllllllllllllIIIIlllIIlIlIIl, final float lllllllllllllllllIIIIlllIIIIlIll, final float lllllllllllllllllIIIIlllIIIIlIIl, final float lllllllllllllllllIIIIlllIIIIIlll, final float lllllllllllllllllIIIIlllIIIIIllI, final float lllllllllllllllllIIIIlllIIlIIIll, final float lllllllllllllllllIIIIlllIIIIIlII, final float lllllllllllllllllIIIIlllIIlIIIIl, final float lllllllllllllllllIIIIlllIIIIIIlI) {
        this.m00 = lllllllllllllllllIIIIlllIIIllIll;
        this.m01 = lllllllllllllllllIIIIlllIIIllIIl;
        this.m02 = lllllllllllllllllIIIIlllIIIlIlll;
        this.m03 = lllllllllllllllllIIIIlllIIIlIlIl;
        this.m10 = lllllllllllllllllIIIIlllIIIlIIll;
        this.m11 = lllllllllllllllllIIIIlllIIIlIIIl;
        this.m12 = lllllllllllllllllIIIIlllIIlIlIll;
        this.m13 = lllllllllllllllllIIIIlllIIlIlIIl;
        this.m20 = lllllllllllllllllIIIIlllIIIIlIll;
        this.m21 = lllllllllllllllllIIIIlllIIIIlIIl;
        this.m22 = lllllllllllllllllIIIIlllIIIIIlll;
        this.m23 = lllllllllllllllllIIIIlllIIIIIllI;
        this.m30 = lllllllllllllllllIIIIlllIIlIIIll;
        this.m31 = lllllllllllllllllIIIIlllIIIIIlII;
        this.m32 = lllllllllllllllllIIIIlllIIlIIIIl;
        this.m33 = lllllllllllllllllIIIIlllIIIIIIlI;
    }
    
    public Matrix4f(final Matrix4f lllllllllllllllllIIIIllIllIIIlIl) {
        this.m00 = lllllllllllllllllIIIIllIllIIIlIl.m00;
        this.m01 = lllllllllllllllllIIIIllIllIIIlIl.m01;
        this.m02 = lllllllllllllllllIIIIllIllIIIlIl.m02;
        this.m03 = lllllllllllllllllIIIIllIllIIIlIl.m03;
        this.m10 = lllllllllllllllllIIIIllIllIIIlIl.m10;
        this.m11 = lllllllllllllllllIIIIllIllIIIlIl.m11;
        this.m12 = lllllllllllllllllIIIIllIllIIIlIl.m12;
        this.m13 = lllllllllllllllllIIIIllIllIIIlIl.m13;
        this.m20 = lllllllllllllllllIIIIllIllIIIlIl.m20;
        this.m21 = lllllllllllllllllIIIIllIllIIIlIl.m21;
        this.m22 = lllllllllllllllllIIIIllIllIIIlIl.m22;
        this.m23 = lllllllllllllllllIIIIllIllIIIlIl.m23;
        this.m30 = lllllllllllllllllIIIIllIllIIIlIl.m30;
        this.m31 = lllllllllllllllllIIIIllIllIIIlIl.m31;
        this.m32 = lllllllllllllllllIIIIllIllIIIlIl.m32;
        this.m33 = lllllllllllllllllIIIIllIllIIIlIl.m33;
    }
    
    public final void setM13(final float lllllllllllllllllIIIIIIllIIlIlll) {
        this.m13 = lllllllllllllllllIIIIIIllIIlIlll;
    }
    
    public final float getM22() {
        return this.m22;
    }
    
    private final void getScaleRotate(final double[] lllllllllllllllllIIIIIlIIIIIIlll, final double[] lllllllllllllllllIIIIIlIIIIIIIlI) {
        final double[] lllllllllllllllllIIIIIlIIIIIIlIl = { this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22 };
        Matrix3d.compute_svd(lllllllllllllllllIIIIIlIIIIIIlIl, lllllllllllllllllIIIIIlIIIIIIlll, lllllllllllllllllIIIIIlIIIIIIIlI);
    }
    
    public final float getM11() {
        return this.m11;
    }
    
    public final void setRotation(final Matrix3d lllllllllllllllllIIIIIlIIllIlIIl) {
        final double[] lllllllllllllllllIIIIIlIIllIllII = new double[9];
        final double[] lllllllllllllllllIIIIIlIIllIlIll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIIlIIllIlIll, lllllllllllllllllIIIIIlIIllIllII);
        this.m00 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m00 * lllllllllllllllllIIIIIlIIllIlIll[0]);
        this.m01 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m01 * lllllllllllllllllIIIIIlIIllIlIll[1]);
        this.m02 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m02 * lllllllllllllllllIIIIIlIIllIlIll[2]);
        this.m10 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m10 * lllllllllllllllllIIIIIlIIllIlIll[0]);
        this.m11 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m11 * lllllllllllllllllIIIIIlIIllIlIll[1]);
        this.m12 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m12 * lllllllllllllllllIIIIIlIIllIlIll[2]);
        this.m20 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m20 * lllllllllllllllllIIIIIlIIllIlIll[0]);
        this.m21 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m21 * lllllllllllllllllIIIIIlIIllIlIll[1]);
        this.m22 = (float)(lllllllllllllllllIIIIIlIIllIlIIl.m22 * lllllllllllllllllIIIIIlIIllIlIll[2]);
    }
    
    public final void setRow(final int lllllllllllllllllIIIIlIllllllIlI, final float[] lllllllllllllllllIIIIlIlllllIllI) {
        switch (lllllllllllllllllIIIIlIllllllIlI) {
            case 0: {
                this.m00 = lllllllllllllllllIIIIlIlllllIllI[0];
                this.m01 = lllllllllllllllllIIIIlIlllllIllI[1];
                this.m02 = lllllllllllllllllIIIIlIlllllIllI[2];
                this.m03 = lllllllllllllllllIIIIlIlllllIllI[3];
                break;
            }
            case 1: {
                this.m10 = lllllllllllllllllIIIIlIlllllIllI[0];
                this.m11 = lllllllllllllllllIIIIlIlllllIllI[1];
                this.m12 = lllllllllllllllllIIIIlIlllllIllI[2];
                this.m13 = lllllllllllllllllIIIIlIlllllIllI[3];
                break;
            }
            case 2: {
                this.m20 = lllllllllllllllllIIIIlIlllllIllI[0];
                this.m21 = lllllllllllllllllIIIIlIlllllIllI[1];
                this.m22 = lllllllllllllllllIIIIlIlllllIllI[2];
                this.m23 = lllllllllllllllllIIIIlIlllllIllI[3];
                break;
            }
            case 3: {
                this.m30 = lllllllllllllllllIIIIlIlllllIllI[0];
                this.m31 = lllllllllllllllllIIIIlIlllllIllI[1];
                this.m32 = lllllllllllllllllIIIIlIlllllIllI[2];
                this.m33 = lllllllllllllllllIIIIlIlllllIllI[3];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f6"));
            }
        }
    }
    
    public final void setM21(final float lllllllllllllllllIIIIIIllIllIIlI) {
        this.m21 = lllllllllllllllllIIIIIIllIllIIlI;
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllllllIIIIIlIllIIllII = 1L;
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m00);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m01);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m02);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m03);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m10);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m11);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m12);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m13);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m20);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m21);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m22);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m23);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m30);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m31);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m32);
        lllllllllllllllllIIIIIlIllIIllII = VecMathUtil.hashFloatBits(lllllllllllllllllIIIIIlIllIIllII, this.m33);
        return VecMathUtil.hashFinish(lllllllllllllllllIIIIIlIllIIllII);
    }
    
    public final float getM01() {
        return this.m01;
    }
    
    public final void set(final Matrix4d lllllllllllllllllIIIIlIlIIIlIIlI) {
        this.m00 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m00;
        this.m01 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m01;
        this.m02 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m02;
        this.m03 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m03;
        this.m10 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m10;
        this.m11 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m11;
        this.m12 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m12;
        this.m13 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m13;
        this.m20 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m20;
        this.m21 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m21;
        this.m22 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m22;
        this.m23 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m23;
        this.m30 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m30;
        this.m31 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m31;
        this.m32 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m32;
        this.m33 = (float)lllllllllllllllllIIIIlIlIIIlIIlI.m33;
    }
    
    public final void add(final float lllllllllllllllllIIIIlIlllIIlllI) {
        this.m00 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m01 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m02 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m03 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m10 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m11 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m12 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m13 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m20 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m21 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m22 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m23 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m30 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m31 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m32 += lllllllllllllllllIIIIlIlllIIlllI;
        this.m33 += lllllllllllllllllIIIIlIlllIIlllI;
    }
    
    public final float getM20() {
        return this.m20;
    }
    
    public final void setColumn(final int lllllllllllllllllIIIIlIlllIlIllI, final float[] lllllllllllllllllIIIIlIlllIlIIlI) {
        switch (lllllllllllllllllIIIIlIlllIlIllI) {
            case 0: {
                this.m00 = lllllllllllllllllIIIIlIlllIlIIlI[0];
                this.m10 = lllllllllllllllllIIIIlIlllIlIIlI[1];
                this.m20 = lllllllllllllllllIIIIlIlllIlIIlI[2];
                this.m30 = lllllllllllllllllIIIIlIlllIlIIlI[3];
                break;
            }
            case 1: {
                this.m01 = lllllllllllllllllIIIIlIlllIlIIlI[0];
                this.m11 = lllllllllllllllllIIIIlIlllIlIIlI[1];
                this.m21 = lllllllllllllllllIIIIlIlllIlIIlI[2];
                this.m31 = lllllllllllllllllIIIIlIlllIlIIlI[3];
                break;
            }
            case 2: {
                this.m02 = lllllllllllllllllIIIIlIlllIlIIlI[0];
                this.m12 = lllllllllllllllllIIIIlIlllIlIIlI[1];
                this.m22 = lllllllllllllllllIIIIlIlllIlIIlI[2];
                this.m32 = lllllllllllllllllIIIIlIlllIlIIlI[3];
                break;
            }
            case 3: {
                this.m03 = lllllllllllllllllIIIIlIlllIlIIlI[0];
                this.m13 = lllllllllllllllllIIIIlIlllIlIIlI[1];
                this.m23 = lllllllllllllllllIIIIlIlllIlIIlI[2];
                this.m33 = lllllllllllllllllIIIIlIlllIlIIlI[3];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
            }
        }
    }
    
    public final void negate(final Matrix4f lllllllllllllllllIIIIIlIIIIIllIl) {
        this.m00 = -lllllllllllllllllIIIIIlIIIIIllIl.m00;
        this.m01 = -lllllllllllllllllIIIIIlIIIIIllIl.m01;
        this.m02 = -lllllllllllllllllIIIIIlIIIIIllIl.m02;
        this.m03 = -lllllllllllllllllIIIIIlIIIIIllIl.m03;
        this.m10 = -lllllllllllllllllIIIIIlIIIIIllIl.m10;
        this.m11 = -lllllllllllllllllIIIIIlIIIIIllIl.m11;
        this.m12 = -lllllllllllllllllIIIIIlIIIIIllIl.m12;
        this.m13 = -lllllllllllllllllIIIIIlIIIIIllIl.m13;
        this.m20 = -lllllllllllllllllIIIIIlIIIIIllIl.m20;
        this.m21 = -lllllllllllllllllIIIIIlIIIIIllIl.m21;
        this.m22 = -lllllllllllllllllIIIIIlIIIIIllIl.m22;
        this.m23 = -lllllllllllllllllIIIIIlIIIIIllIl.m23;
        this.m30 = -lllllllllllllllllIIIIIlIIIIIllIl.m30;
        this.m31 = -lllllllllllllllllIIIIIlIIIIIllIl.m31;
        this.m32 = -lllllllllllllllllIIIIIlIIIIIllIl.m32;
        this.m33 = -lllllllllllllllllIIIIIlIIIIIllIl.m33;
    }
    
    public final void setM32(final float lllllllllllllllllIIIIIIlIlllIIIl) {
        this.m32 = lllllllllllllllllIIIIIIlIlllIIIl;
    }
    
    public final float getM31() {
        return this.m31;
    }
    
    public final void set(final float lllllllllllllllllIIIIlIIIllIIlIl, final Vector3f lllllllllllllllllIIIIlIIIllIIlll) {
        this.m00 = lllllllllllllllllIIIIlIIIllIIlIl;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = lllllllllllllllllIIIIlIIIllIIlll.x;
        this.m10 = 0.0f;
        this.m11 = lllllllllllllllllIIIIlIIIllIIlIl;
        this.m12 = 0.0f;
        this.m13 = lllllllllllllllllIIIIlIIIllIIlll.y;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = lllllllllllllllllIIIIlIIIllIIlIl;
        this.m23 = lllllllllllllllllIIIIlIIIllIIlll.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void setRotation(final AxisAngle4f lllllllllllllllllIIIIIlIIIlIIlIl) {
        final double[] lllllllllllllllllIIIIIlIIIllIIlI = new double[9];
        final double[] lllllllllllllllllIIIIIlIIIllIIIl = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIIlIIIllIIIl, lllllllllllllllllIIIIIlIIIllIIlI);
        double lllllllllllllllllIIIIIlIIIllIIII = Math.sqrt(lllllllllllllllllIIIIIlIIIlIIlIl.x * lllllllllllllllllIIIIIlIIIlIIlIl.x + lllllllllllllllllIIIIIlIIIlIIlIl.y * lllllllllllllllllIIIIIlIIIlIIlIl.y + lllllllllllllllllIIIIIlIIIlIIlIl.z * lllllllllllllllllIIIIIlIIIlIIlIl.z);
        if (lllllllllllllllllIIIIIlIIIllIIII < 1.0E-8) {
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
            lllllllllllllllllIIIIIlIIIllIIII = 1.0 / lllllllllllllllllIIIIIlIIIllIIII;
            final double lllllllllllllllllIIIIIlIIIlIllll = lllllllllllllllllIIIIIlIIIlIIlIl.x * lllllllllllllllllIIIIIlIIIllIIII;
            final double lllllllllllllllllIIIIIlIIIlIlllI = lllllllllllllllllIIIIIlIIIlIIlIl.y * lllllllllllllllllIIIIIlIIIllIIII;
            final double lllllllllllllllllIIIIIlIIIlIllIl = lllllllllllllllllIIIIIlIIIlIIlIl.z * lllllllllllllllllIIIIIlIIIllIIII;
            final double lllllllllllllllllIIIIIlIIIlIllII = Math.sin(lllllllllllllllllIIIIIlIIIlIIlIl.angle);
            final double lllllllllllllllllIIIIIlIIIlIlIll = Math.cos(lllllllllllllllllIIIIIlIIIlIIlIl.angle);
            final double lllllllllllllllllIIIIIlIIIlIlIlI = 1.0 - lllllllllllllllllIIIIIlIIIlIlIll;
            final double lllllllllllllllllIIIIIlIIIlIlIIl = lllllllllllllllllIIIIIlIIIlIIlIl.x * lllllllllllllllllIIIIIlIIIlIIlIl.z;
            final double lllllllllllllllllIIIIIlIIIlIlIII = lllllllllllllllllIIIIIlIIIlIIlIl.x * lllllllllllllllllIIIIIlIIIlIIlIl.y;
            final double lllllllllllllllllIIIIIlIIIlIIlll = lllllllllllllllllIIIIIlIIIlIIlIl.y * lllllllllllllllllIIIIIlIIIlIIlIl.z;
            this.m00 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIllll * lllllllllllllllllIIIIIlIIIlIllll + lllllllllllllllllIIIIIlIIIlIlIll) * lllllllllllllllllIIIIIlIIIllIIIl[0]);
            this.m01 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIlIII - lllllllllllllllllIIIIIlIIIlIllII * lllllllllllllllllIIIIIlIIIlIllIl) * lllllllllllllllllIIIIIlIIIllIIIl[1]);
            this.m02 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIlIIl + lllllllllllllllllIIIIIlIIIlIllII * lllllllllllllllllIIIIIlIIIlIlllI) * lllllllllllllllllIIIIIlIIIllIIIl[2]);
            this.m10 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIlIII + lllllllllllllllllIIIIIlIIIlIllII * lllllllllllllllllIIIIIlIIIlIllIl) * lllllllllllllllllIIIIIlIIIllIIIl[0]);
            this.m11 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIlllI * lllllllllllllllllIIIIIlIIIlIlllI + lllllllllllllllllIIIIIlIIIlIlIll) * lllllllllllllllllIIIIIlIIIllIIIl[1]);
            this.m12 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIIlll - lllllllllllllllllIIIIIlIIIlIllII * lllllllllllllllllIIIIIlIIIlIllll) * lllllllllllllllllIIIIIlIIIllIIIl[2]);
            this.m20 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIlIIl - lllllllllllllllllIIIIIlIIIlIllII * lllllllllllllllllIIIIIlIIIlIlllI) * lllllllllllllllllIIIIIlIIIllIIIl[0]);
            this.m21 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIIlll + lllllllllllllllllIIIIIlIIIlIllII * lllllllllllllllllIIIIIlIIIlIllll) * lllllllllllllllllIIIIIlIIIllIIIl[1]);
            this.m22 = (float)((lllllllllllllllllIIIIIlIIIlIlIlI * lllllllllllllllllIIIIIlIIIlIllIl * lllllllllllllllllIIIIIlIIIlIllIl + lllllllllllllllllIIIIIlIIIlIlIll) * lllllllllllllllllIIIIIlIIIllIIIl[2]);
        }
    }
    
    public final void get(final Vector3f lllllllllllllllllIIIIllIIIllIIIl) {
        lllllllllllllllllIIIIllIIIllIIIl.x = this.m03;
        lllllllllllllllllIIIIllIIIllIIIl.y = this.m13;
        lllllllllllllllllIIIIllIIIllIIIl.z = this.m23;
    }
    
    public final void rotY(final float lllllllllllllllllIIIIlIIIIlIlIll) {
        final float lllllllllllllllllIIIIlIIIIlIlIlI = (float)Math.sin(lllllllllllllllllIIIIlIIIIlIlIll);
        final float lllllllllllllllllIIIIlIIIIlIlIIl = (float)Math.cos(lllllllllllllllllIIIIlIIIIlIlIll);
        this.m00 = lllllllllllllllllIIIIlIIIIlIlIIl;
        this.m01 = 0.0f;
        this.m02 = lllllllllllllllllIIIIlIIIIlIlIlI;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = -lllllllllllllllllIIIIlIIIIlIlIlI;
        this.m21 = 0.0f;
        this.m22 = lllllllllllllllllIIIIlIIIIlIlIIl;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void setM33(final float lllllllllllllllllIIIIIIlIllIlIII) {
        this.m33 = lllllllllllllllllIIIIIIlIllIlIII;
    }
    
    public final void set(final float lllllllllllllllllIIIIlIIIllllIll) {
        this.m00 = lllllllllllllllllIIIIlIIIllllIll;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m03 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = lllllllllllllllllIIIIlIIIllllIll;
        this.m12 = 0.0f;
        this.m13 = 0.0f;
        this.m20 = 0.0f;
        this.m21 = 0.0f;
        this.m22 = lllllllllllllllllIIIIlIIIllllIll;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final float getM02() {
        return this.m02;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIIIIIlIllIlllIl) {
        try {
            final Matrix4f lllllllllllllllllIIIIIlIlllIIIIl = (Matrix4f)lllllllllllllllllIIIIIlIllIlllIl;
            return this.m00 == lllllllllllllllllIIIIIlIlllIIIIl.m00 && this.m01 == lllllllllllllllllIIIIIlIlllIIIIl.m01 && this.m02 == lllllllllllllllllIIIIIlIlllIIIIl.m02 && this.m03 == lllllllllllllllllIIIIIlIlllIIIIl.m03 && this.m10 == lllllllllllllllllIIIIIlIlllIIIIl.m10 && this.m11 == lllllllllllllllllIIIIIlIlllIIIIl.m11 && this.m12 == lllllllllllllllllIIIIIlIlllIIIIl.m12 && this.m13 == lllllllllllllllllIIIIIlIlllIIIIl.m13 && this.m20 == lllllllllllllllllIIIIIlIlllIIIIl.m20 && this.m21 == lllllllllllllllllIIIIIlIlllIIIIl.m21 && this.m22 == lllllllllllllllllIIIIIlIlllIIIIl.m22 && this.m23 == lllllllllllllllllIIIIIlIlllIIIIl.m23 && this.m30 == lllllllllllllllllIIIIIlIlllIIIIl.m30 && this.m31 == lllllllllllllllllIIIIIlIlllIIIIl.m31 && this.m32 == lllllllllllllllllIIIIIlIlllIIIIl.m32 && this.m33 == lllllllllllllllllIIIIIlIlllIIIIl.m33;
        }
        catch (ClassCastException lllllllllllllllllIIIIIlIlllIIIII) {
            return false;
        }
        catch (NullPointerException lllllllllllllllllIIIIIlIllIlllll) {
            return false;
        }
    }
    
    public final void mul(final float lllllllllllllllllIIIIlIIIIIIlllI, final Matrix4f lllllllllllllllllIIIIlIIIIIIlIlI) {
        this.m00 = lllllllllllllllllIIIIlIIIIIIlIlI.m00 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m01 = lllllllllllllllllIIIIlIIIIIIlIlI.m01 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m02 = lllllllllllllllllIIIIlIIIIIIlIlI.m02 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m03 = lllllllllllllllllIIIIlIIIIIIlIlI.m03 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m10 = lllllllllllllllllIIIIlIIIIIIlIlI.m10 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m11 = lllllllllllllllllIIIIlIIIIIIlIlI.m11 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m12 = lllllllllllllllllIIIIlIIIIIIlIlI.m12 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m13 = lllllllllllllllllIIIIlIIIIIIlIlI.m13 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m20 = lllllllllllllllllIIIIlIIIIIIlIlI.m20 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m21 = lllllllllllllllllIIIIlIIIIIIlIlI.m21 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m22 = lllllllllllllllllIIIIlIIIIIIlIlI.m22 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m23 = lllllllllllllllllIIIIlIIIIIIlIlI.m23 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m30 = lllllllllllllllllIIIIlIIIIIIlIlI.m30 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m31 = lllllllllllllllllIIIIlIIIIIIlIlI.m31 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m32 = lllllllllllllllllIIIIlIIIIIIlIlI.m32 * lllllllllllllllllIIIIlIIIIIIlllI;
        this.m33 = lllllllllllllllllIIIIlIIIIIIlIlI.m33 * lllllllllllllllllIIIIlIIIIIIlllI;
    }
    
    public final void negate() {
        this.m00 = -this.m00;
        this.m01 = -this.m01;
        this.m02 = -this.m02;
        this.m03 = -this.m03;
        this.m10 = -this.m10;
        this.m11 = -this.m11;
        this.m12 = -this.m12;
        this.m13 = -this.m13;
        this.m20 = -this.m20;
        this.m21 = -this.m21;
        this.m22 = -this.m22;
        this.m23 = -this.m23;
        this.m30 = -this.m30;
        this.m31 = -this.m31;
        this.m32 = -this.m32;
        this.m33 = -this.m33;
    }
    
    public final void getRow(final int lllllllllllllllllIIIIllIlIIlIllI, final Vector4f lllllllllllllllllIIIIllIlIIlIlIl) {
        if (lllllllllllllllllIIIIllIlIIlIllI == 0) {
            lllllllllllllllllIIIIllIlIIlIlIl.x = this.m00;
            lllllllllllllllllIIIIllIlIIlIlIl.y = this.m01;
            lllllllllllllllllIIIIllIlIIlIlIl.z = this.m02;
            lllllllllllllllllIIIIllIlIIlIlIl.w = this.m03;
        }
        else if (lllllllllllllllllIIIIllIlIIlIllI == 1) {
            lllllllllllllllllIIIIllIlIIlIlIl.x = this.m10;
            lllllllllllllllllIIIIllIlIIlIlIl.y = this.m11;
            lllllllllllllllllIIIIllIlIIlIlIl.z = this.m12;
            lllllllllllllllllIIIIllIlIIlIlIl.w = this.m13;
        }
        else if (lllllllllllllllllIIIIllIlIIlIllI == 2) {
            lllllllllllllllllIIIIllIlIIlIlIl.x = this.m20;
            lllllllllllllllllIIIIllIlIIlIlIl.y = this.m21;
            lllllllllllllllllIIIIllIlIIlIlIl.z = this.m22;
            lllllllllllllllllIIIIllIlIIlIlIl.w = this.m23;
        }
        else {
            if (lllllllllllllllllIIIIllIlIIlIllI != 3) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f2"));
            }
            lllllllllllllllllIIIIllIlIIlIlIl.x = this.m30;
            lllllllllllllllllIIIIllIlIIlIlIl.y = this.m31;
            lllllllllllllllllIIIIllIlIIlIlIl.z = this.m32;
            lllllllllllllllllIIIIllIlIIlIlIl.w = this.m33;
        }
    }
    
    public final void setM22(final float lllllllllllllllllIIIIIIllIlIIlll) {
        this.m22 = lllllllllllllllllIIIIIIllIlIIlll;
    }
    
    public final void setM01(final float lllllllllllllllllIIIIIIllllIIllI) {
        this.m01 = lllllllllllllllllIIIIIIllllIIllI;
    }
    
    public final void get(final Quat4f lllllllllllllllllIIIIllIIIlllIII) {
        final double[] lllllllllllllllllIIIIllIIIllllII = new double[9];
        final double[] lllllllllllllllllIIIIllIIIlllIll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIllIIIlllIll, lllllllllllllllllIIIIllIIIllllII);
        double lllllllllllllllllIIIIllIIIlllIlI = 0.25 * (1.0 + lllllllllllllllllIIIIllIIIllllII[0] + lllllllllllllllllIIIIllIIIllllII[4] + lllllllllllllllllIIIIllIIIllllII[8]);
        if (((lllllllllllllllllIIIIllIIIlllIlI < 0.0) ? (-lllllllllllllllllIIIIllIIIlllIlI) : lllllllllllllllllIIIIllIIIlllIlI) >= 1.0E-30) {
            lllllllllllllllllIIIIllIIIlllIII.w = (float)Math.sqrt(lllllllllllllllllIIIIllIIIlllIlI);
            lllllllllllllllllIIIIllIIIlllIlI = 0.25 / lllllllllllllllllIIIIllIIIlllIII.w;
            lllllllllllllllllIIIIllIIIlllIII.x = (float)((lllllllllllllllllIIIIllIIIllllII[7] - lllllllllllllllllIIIIllIIIllllII[5]) * lllllllllllllllllIIIIllIIIlllIlI);
            lllllllllllllllllIIIIllIIIlllIII.y = (float)((lllllllllllllllllIIIIllIIIllllII[2] - lllllllllllllllllIIIIllIIIllllII[6]) * lllllllllllllllllIIIIllIIIlllIlI);
            lllllllllllllllllIIIIllIIIlllIII.z = (float)((lllllllllllllllllIIIIllIIIllllII[3] - lllllllllllllllllIIIIllIIIllllII[1]) * lllllllllllllllllIIIIllIIIlllIlI);
            return;
        }
        lllllllllllllllllIIIIllIIIlllIII.w = 0.0f;
        lllllllllllllllllIIIIllIIIlllIlI = -0.5 * (lllllllllllllllllIIIIllIIIllllII[4] + lllllllllllllllllIIIIllIIIllllII[8]);
        if (((lllllllllllllllllIIIIllIIIlllIlI < 0.0) ? (-lllllllllllllllllIIIIllIIIlllIlI) : lllllllllllllllllIIIIllIIIlllIlI) >= 1.0E-30) {
            lllllllllllllllllIIIIllIIIlllIII.x = (float)Math.sqrt(lllllllllllllllllIIIIllIIIlllIlI);
            lllllllllllllllllIIIIllIIIlllIlI = 0.5 / lllllllllllllllllIIIIllIIIlllIII.x;
            lllllllllllllllllIIIIllIIIlllIII.y = (float)(lllllllllllllllllIIIIllIIIllllII[3] * lllllllllllllllllIIIIllIIIlllIlI);
            lllllllllllllllllIIIIllIIIlllIII.z = (float)(lllllllllllllllllIIIIllIIIllllII[6] * lllllllllllllllllIIIIllIIIlllIlI);
            return;
        }
        lllllllllllllllllIIIIllIIIlllIII.x = 0.0f;
        lllllllllllllllllIIIIllIIIlllIlI = 0.5 * (1.0 - lllllllllllllllllIIIIllIIIllllII[8]);
        if (((lllllllllllllllllIIIIllIIIlllIlI < 0.0) ? (-lllllllllllllllllIIIIllIIIlllIlI) : lllllllllllllllllIIIIllIIIlllIlI) >= 1.0E-30) {
            lllllllllllllllllIIIIllIIIlllIII.y = (float)Math.sqrt(lllllllllllllllllIIIIllIIIlllIlI);
            lllllllllllllllllIIIIllIIIlllIII.z = (float)(lllllllllllllllllIIIIllIIIllllII[7] / (2.0 * lllllllllllllllllIIIIllIIIlllIII.y));
            return;
        }
        lllllllllllllllllIIIIllIIIlllIII.y = 0.0f;
        lllllllllllllllllIIIIllIIIlllIII.z = 1.0f;
    }
    
    public final void transform(final Point3f lllllllllllllllllIIIIIlIlIIlIlII) {
        final float lllllllllllllllllIIIIIlIlIIlIIll = this.m00 * lllllllllllllllllIIIIIlIlIIlIlII.x + this.m01 * lllllllllllllllllIIIIIlIlIIlIlII.y + this.m02 * lllllllllllllllllIIIIIlIlIIlIlII.z + this.m03;
        final float lllllllllllllllllIIIIIlIlIIlIIlI = this.m10 * lllllllllllllllllIIIIIlIlIIlIlII.x + this.m11 * lllllllllllllllllIIIIIlIlIIlIlII.y + this.m12 * lllllllllllllllllIIIIIlIlIIlIlII.z + this.m13;
        lllllllllllllllllIIIIIlIlIIlIlII.z = this.m20 * lllllllllllllllllIIIIIlIlIIlIlII.x + this.m21 * lllllllllllllllllIIIIIlIlIIlIlII.y + this.m22 * lllllllllllllllllIIIIIlIlIIlIlII.z + this.m23;
        lllllllllllllllllIIIIIlIlIIlIlII.x = lllllllllllllllllIIIIIlIlIIlIIll;
        lllllllllllllllllIIIIIlIlIIlIlII.y = lllllllllllllllllIIIIIlIlIIlIIlI;
    }
    
    public final void set(final AxisAngle4d lllllllllllllllllIIIIlIlIIlllIlI) {
        double lllllllllllllllllIIIIlIlIlIIIlIl = Math.sqrt(lllllllllllllllllIIIIlIlIIlllIlI.x * lllllllllllllllllIIIIlIlIIlllIlI.x + lllllllllllllllllIIIIlIlIIlllIlI.y * lllllllllllllllllIIIIlIlIIlllIlI.y + lllllllllllllllllIIIIlIlIIlllIlI.z * lllllllllllllllllIIIIlIlIIlllIlI.z);
        if (lllllllllllllllllIIIIlIlIlIIIlIl < 1.0E-8) {
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
            lllllllllllllllllIIIIlIlIlIIIlIl = 1.0 / lllllllllllllllllIIIIlIlIlIIIlIl;
            final double lllllllllllllllllIIIIlIlIlIIIlII = lllllllllllllllllIIIIlIlIIlllIlI.x * lllllllllllllllllIIIIlIlIlIIIlIl;
            final double lllllllllllllllllIIIIlIlIlIIIIll = lllllllllllllllllIIIIlIlIIlllIlI.y * lllllllllllllllllIIIIlIlIlIIIlIl;
            final double lllllllllllllllllIIIIlIlIlIIIIlI = lllllllllllllllllIIIIlIlIIlllIlI.z * lllllllllllllllllIIIIlIlIlIIIlIl;
            final float lllllllllllllllllIIIIlIlIlIIIIIl = (float)Math.sin(lllllllllllllllllIIIIlIlIIlllIlI.angle);
            final float lllllllllllllllllIIIIlIlIlIIIIII = (float)Math.cos(lllllllllllllllllIIIIlIlIIlllIlI.angle);
            final float lllllllllllllllllIIIIlIlIIllllll = 1.0f - lllllllllllllllllIIIIlIlIlIIIIII;
            final float lllllllllllllllllIIIIlIlIIlllllI = (float)(lllllllllllllllllIIIIlIlIlIIIlII * lllllllllllllllllIIIIlIlIlIIIIlI);
            final float lllllllllllllllllIIIIlIlIIllllIl = (float)(lllllllllllllllllIIIIlIlIlIIIlII * lllllllllllllllllIIIIlIlIlIIIIll);
            final float lllllllllllllllllIIIIlIlIIllllII = (float)(lllllllllllllllllIIIIlIlIlIIIIll * lllllllllllllllllIIIIlIlIlIIIIlI);
            this.m00 = lllllllllllllllllIIIIlIlIIllllll * (float)(lllllllllllllllllIIIIlIlIlIIIlII * lllllllllllllllllIIIIlIlIlIIIlII) + lllllllllllllllllIIIIlIlIlIIIIII;
            this.m01 = lllllllllllllllllIIIIlIlIIllllll * lllllllllllllllllIIIIlIlIIllllIl - lllllllllllllllllIIIIlIlIlIIIIIl * (float)lllllllllllllllllIIIIlIlIlIIIIlI;
            this.m02 = lllllllllllllllllIIIIlIlIIllllll * lllllllllllllllllIIIIlIlIIlllllI + lllllllllllllllllIIIIlIlIlIIIIIl * (float)lllllllllllllllllIIIIlIlIlIIIIll;
            this.m10 = lllllllllllllllllIIIIlIlIIllllll * lllllllllllllllllIIIIlIlIIllllIl + lllllllllllllllllIIIIlIlIlIIIIIl * (float)lllllllllllllllllIIIIlIlIlIIIIlI;
            this.m11 = lllllllllllllllllIIIIlIlIIllllll * (float)(lllllllllllllllllIIIIlIlIlIIIIll * lllllllllllllllllIIIIlIlIlIIIIll) + lllllllllllllllllIIIIlIlIlIIIIII;
            this.m12 = lllllllllllllllllIIIIlIlIIllllll * lllllllllllllllllIIIIlIlIIllllII - lllllllllllllllllIIIIlIlIlIIIIIl * (float)lllllllllllllllllIIIIlIlIlIIIlII;
            this.m20 = lllllllllllllllllIIIIlIlIIllllll * lllllllllllllllllIIIIlIlIIlllllI - lllllllllllllllllIIIIlIlIlIIIIIl * (float)lllllllllllllllllIIIIlIlIlIIIIll;
            this.m21 = lllllllllllllllllIIIIlIlIIllllll * lllllllllllllllllIIIIlIlIIllllII + lllllllllllllllllIIIIlIlIlIIIIIl * (float)lllllllllllllllllIIIIlIlIlIIIlII;
            this.m22 = lllllllllllllllllIIIIlIlIIllllll * (float)(lllllllllllllllllIIIIlIlIlIIIIlI * lllllllllllllllllIIIIlIlIlIIIIlI) + lllllllllllllllllIIIIlIlIlIIIIII;
        }
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void add(final float lllllllllllllllllIIIIlIlllIIIlII, final Matrix4f lllllllllllllllllIIIIlIlllIIIllI) {
        this.m00 = lllllllllllllllllIIIIlIlllIIIllI.m00 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m01 = lllllllllllllllllIIIIlIlllIIIllI.m01 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m02 = lllllllllllllllllIIIIlIlllIIIllI.m02 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m03 = lllllllllllllllllIIIIlIlllIIIllI.m03 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m10 = lllllllllllllllllIIIIlIlllIIIllI.m10 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m11 = lllllllllllllllllIIIIlIlllIIIllI.m11 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m12 = lllllllllllllllllIIIIlIlllIIIllI.m12 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m13 = lllllllllllllllllIIIIlIlllIIIllI.m13 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m20 = lllllllllllllllllIIIIlIlllIIIllI.m20 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m21 = lllllllllllllllllIIIIlIlllIIIllI.m21 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m22 = lllllllllllllllllIIIIlIlllIIIllI.m22 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m23 = lllllllllllllllllIIIIlIlllIIIllI.m23 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m30 = lllllllllllllllllIIIIlIlllIIIllI.m30 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m31 = lllllllllllllllllIIIIlIlllIIIllI.m31 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m32 = lllllllllllllllllIIIIlIlllIIIllI.m32 + lllllllllllllllllIIIIlIlllIIIlII;
        this.m33 = lllllllllllllllllIIIIlIlllIIIllI.m33 + lllllllllllllllllIIIIlIlllIIIlII;
    }
    
    public final void setM10(final float lllllllllllllllllIIIIIIlllIlIllI) {
        this.m10 = lllllllllllllllllIIIIIIlllIlIllI;
    }
    
    public final void set(final Matrix3d lllllllllllllllllIIIIlIIIlIIIlIl, final Vector3d lllllllllllllllllIIIIlIIIlIIlIII, final double lllllllllllllllllIIIIlIIIlIIIIll) {
        this.m00 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m00 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m01 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m01 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m02 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m02 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m03 = (float)lllllllllllllllllIIIIlIIIlIIlIII.x;
        this.m10 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m10 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m11 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m11 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m12 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m12 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m13 = (float)lllllllllllllllllIIIIlIIIlIIlIII.y;
        this.m20 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m20 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m21 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m21 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m22 = (float)(lllllllllllllllllIIIIlIIIlIIIlIl.m22 * lllllllllllllllllIIIIlIIIlIIIIll);
        this.m23 = (float)lllllllllllllllllIIIIlIIIlIIlIII.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void setM12(final float lllllllllllllllllIIIIIIlllIIIIlI) {
        this.m12 = lllllllllllllllllIIIIIIlllIIIIlI;
    }
    
    public final void get(final Matrix3f lllllllllllllllllIIIIllIIlIllIIl) {
        final double[] lllllllllllllllllIIIIllIIlIllIII = new double[9];
        final double[] lllllllllllllllllIIIIllIIlIlIlll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIllIIlIlIlll, lllllllllllllllllIIIIllIIlIllIII);
        lllllllllllllllllIIIIllIIlIllIIl.m00 = (float)lllllllllllllllllIIIIllIIlIllIII[0];
        lllllllllllllllllIIIIllIIlIllIIl.m01 = (float)lllllllllllllllllIIIIllIIlIllIII[1];
        lllllllllllllllllIIIIllIIlIllIIl.m02 = (float)lllllllllllllllllIIIIllIIlIllIII[2];
        lllllllllllllllllIIIIllIIlIllIIl.m10 = (float)lllllllllllllllllIIIIllIIlIllIII[3];
        lllllllllllllllllIIIIllIIlIllIIl.m11 = (float)lllllllllllllllllIIIIllIIlIllIII[4];
        lllllllllllllllllIIIIllIIlIllIIl.m12 = (float)lllllllllllllllllIIIIllIIlIllIII[5];
        lllllllllllllllllIIIIllIIlIllIIl.m20 = (float)lllllllllllllllllIIIIllIIlIllIII[6];
        lllllllllllllllllIIIIllIIlIllIIl.m21 = (float)lllllllllllllllllIIIIllIIlIllIII[7];
        lllllllllllllllllIIIIllIIlIllIIl.m22 = (float)lllllllllllllllllIIIIllIIlIllIII[8];
    }
    
    public final void transpose(final Matrix4f lllllllllllllllllIIIIlIllIIIIlII) {
        if (this != lllllllllllllllllIIIIlIllIIIIlII) {
            this.m00 = lllllllllllllllllIIIIlIllIIIIlII.m00;
            this.m01 = lllllllllllllllllIIIIlIllIIIIlII.m10;
            this.m02 = lllllllllllllllllIIIIlIllIIIIlII.m20;
            this.m03 = lllllllllllllllllIIIIlIllIIIIlII.m30;
            this.m10 = lllllllllllllllllIIIIlIllIIIIlII.m01;
            this.m11 = lllllllllllllllllIIIIlIllIIIIlII.m11;
            this.m12 = lllllllllllllllllIIIIlIllIIIIlII.m21;
            this.m13 = lllllllllllllllllIIIIlIllIIIIlII.m31;
            this.m20 = lllllllllllllllllIIIIlIllIIIIlII.m02;
            this.m21 = lllllllllllllllllIIIIlIllIIIIlII.m12;
            this.m22 = lllllllllllllllllIIIIlIllIIIIlII.m22;
            this.m23 = lllllllllllllllllIIIIlIllIIIIlII.m32;
            this.m30 = lllllllllllllllllIIIIlIllIIIIlII.m03;
            this.m31 = lllllllllllllllllIIIIlIllIIIIlII.m13;
            this.m32 = lllllllllllllllllIIIIlIllIIIIlII.m23;
            this.m33 = lllllllllllllllllIIIIlIllIIIIlII.m33;
        }
        else {
            this.transpose();
        }
    }
    
    public final void setColumn(final int lllllllllllllllllIIIIlIlllIlllII, final Vector4f lllllllllllllllllIIIIlIlllIllIll) {
        switch (lllllllllllllllllIIIIlIlllIlllII) {
            case 0: {
                this.m00 = lllllllllllllllllIIIIlIlllIllIll.x;
                this.m10 = lllllllllllllllllIIIIlIlllIllIll.y;
                this.m20 = lllllllllllllllllIIIIlIlllIllIll.z;
                this.m30 = lllllllllllllllllIIIIlIlllIllIll.w;
                break;
            }
            case 1: {
                this.m01 = lllllllllllllllllIIIIlIlllIllIll.x;
                this.m11 = lllllllllllllllllIIIIlIlllIllIll.y;
                this.m21 = lllllllllllllllllIIIIlIlllIllIll.z;
                this.m31 = lllllllllllllllllIIIIlIlllIllIll.w;
                break;
            }
            case 2: {
                this.m02 = lllllllllllllllllIIIIlIlllIllIll.x;
                this.m12 = lllllllllllllllllIIIIlIlllIllIll.y;
                this.m22 = lllllllllllllllllIIIIlIlllIllIll.z;
                this.m32 = lllllllllllllllllIIIIlIlllIllIll.w;
                break;
            }
            case 3: {
                this.m03 = lllllllllllllllllIIIIlIlllIllIll.x;
                this.m13 = lllllllllllllllllIIIIlIlllIllIll.y;
                this.m23 = lllllllllllllllllIIIIlIlllIllIll.z;
                this.m33 = lllllllllllllllllIIIIlIlllIllIll.w;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f9"));
            }
        }
    }
    
    public final float getM30() {
        return this.m30;
    }
    
    public final float get(final Matrix3f lllllllllllllllllIIIIllIIlIIIlll, final Vector3f lllllllllllllllllIIIIllIIlIIIllI) {
        final double[] lllllllllllllllllIIIIllIIlIIlIlI = new double[9];
        final double[] lllllllllllllllllIIIIllIIlIIlIIl = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIllIIlIIlIIl, lllllllllllllllllIIIIllIIlIIlIlI);
        lllllllllllllllllIIIIllIIlIIIlll.m00 = (float)lllllllllllllllllIIIIllIIlIIlIlI[0];
        lllllllllllllllllIIIIllIIlIIIlll.m01 = (float)lllllllllllllllllIIIIllIIlIIlIlI[1];
        lllllllllllllllllIIIIllIIlIIIlll.m02 = (float)lllllllllllllllllIIIIllIIlIIlIlI[2];
        lllllllllllllllllIIIIllIIlIIIlll.m10 = (float)lllllllllllllllllIIIIllIIlIIlIlI[3];
        lllllllllllllllllIIIIllIIlIIIlll.m11 = (float)lllllllllllllllllIIIIllIIlIIlIlI[4];
        lllllllllllllllllIIIIllIIlIIIlll.m12 = (float)lllllllllllllllllIIIIllIIlIIlIlI[5];
        lllllllllllllllllIIIIllIIlIIIlll.m20 = (float)lllllllllllllllllIIIIllIIlIIlIlI[6];
        lllllllllllllllllIIIIllIIlIIIlll.m21 = (float)lllllllllllllllllIIIIllIIlIIlIlI[7];
        lllllllllllllllllIIIIllIIlIIIlll.m22 = (float)lllllllllllllllllIIIIllIIlIIlIlI[8];
        lllllllllllllllllIIIIllIIlIIIllI.x = this.m03;
        lllllllllllllllllIIIIllIIlIIIllI.y = this.m13;
        lllllllllllllllllIIIIllIIlIIIllI.z = this.m23;
        return (float)Matrix3d.max3(lllllllllllllllllIIIIllIIlIIlIIl);
    }
    
    public final float getScale() {
        final double[] lllllllllllllllllIIIIllIIIlIIlII = new double[9];
        final double[] lllllllllllllllllIIIIllIIIlIIIll = new double[3];
        this.getScaleRotate(lllllllllllllllllIIIIllIIIlIIIll, lllllllllllllllllIIIIllIIIlIIlII);
        return (float)Matrix3d.max3(lllllllllllllllllIIIIllIIIlIIIll);
    }
    
    public Matrix4f(final Quat4f lllllllllllllllllIIIIllIllIlIlll, final Vector3f lllllllllllllllllIIIIllIllIlIIlI, final float lllllllllllllllllIIIIllIllIlIlIl) {
        this.m00 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (1.0 - 2.0 * lllllllllllllllllIIIIllIllIlIlll.y * lllllllllllllllllIIIIllIllIlIlll.y - 2.0 * lllllllllllllllllIIIIllIllIlIlll.z * lllllllllllllllllIIIIllIllIlIlll.z));
        this.m10 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (2.0 * (lllllllllllllllllIIIIllIllIlIlll.x * lllllllllllllllllIIIIllIllIlIlll.y + lllllllllllllllllIIIIllIllIlIlll.w * lllllllllllllllllIIIIllIllIlIlll.z)));
        this.m20 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (2.0 * (lllllllllllllllllIIIIllIllIlIlll.x * lllllllllllllllllIIIIllIllIlIlll.z - lllllllllllllllllIIIIllIllIlIlll.w * lllllllllllllllllIIIIllIllIlIlll.y)));
        this.m01 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (2.0 * (lllllllllllllllllIIIIllIllIlIlll.x * lllllllllllllllllIIIIllIllIlIlll.y - lllllllllllllllllIIIIllIllIlIlll.w * lllllllllllllllllIIIIllIllIlIlll.z)));
        this.m11 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (1.0 - 2.0 * lllllllllllllllllIIIIllIllIlIlll.x * lllllllllllllllllIIIIllIllIlIlll.x - 2.0 * lllllllllllllllllIIIIllIllIlIlll.z * lllllllllllllllllIIIIllIllIlIlll.z));
        this.m21 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (2.0 * (lllllllllllllllllIIIIllIllIlIlll.y * lllllllllllllllllIIIIllIllIlIlll.z + lllllllllllllllllIIIIllIllIlIlll.w * lllllllllllllllllIIIIllIllIlIlll.x)));
        this.m02 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (2.0 * (lllllllllllllllllIIIIllIllIlIlll.x * lllllllllllllllllIIIIllIllIlIlll.z + lllllllllllllllllIIIIllIllIlIlll.w * lllllllllllllllllIIIIllIllIlIlll.y)));
        this.m12 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (2.0 * (lllllllllllllllllIIIIllIllIlIlll.y * lllllllllllllllllIIIIllIllIlIlll.z - lllllllllllllllllIIIIllIllIlIlll.w * lllllllllllllllllIIIIllIllIlIlll.x)));
        this.m22 = (float)(lllllllllllllllllIIIIllIllIlIlIl * (1.0 - 2.0 * lllllllllllllllllIIIIllIllIlIlll.x * lllllllllllllllllIIIIllIllIlIlll.x - 2.0 * lllllllllllllllllIIIIllIllIlIlll.y * lllllllllllllllllIIIIllIllIlIlll.y));
        this.m03 = lllllllllllllllllIIIIllIllIlIIlI.x;
        this.m13 = lllllllllllllllllIIIIllIllIlIIlI.y;
        this.m23 = lllllllllllllllllIIIIllIllIlIIlI.z;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void invert() {
        this.invertGeneral(this);
    }
    
    public final void mulTransposeBoth(final Matrix4f lllllllllllllllllIIIIIlllIIIIllI, final Matrix4f lllllllllllllllllIIIIIllIlllIIlI) {
        if (this != lllllllllllllllllIIIIIlllIIIIllI && this != lllllllllllllllllIIIIIllIlllIIlI) {
            this.m00 = lllllllllllllllllIIIIIlllIIIIllI.m00 * lllllllllllllllllIIIIIllIlllIIlI.m00 + lllllllllllllllllIIIIIlllIIIIllI.m10 * lllllllllllllllllIIIIIllIlllIIlI.m01 + lllllllllllllllllIIIIIlllIIIIllI.m20 * lllllllllllllllllIIIIIllIlllIIlI.m02 + lllllllllllllllllIIIIIlllIIIIllI.m30 * lllllllllllllllllIIIIIllIlllIIlI.m03;
            this.m01 = lllllllllllllllllIIIIIlllIIIIllI.m00 * lllllllllllllllllIIIIIllIlllIIlI.m10 + lllllllllllllllllIIIIIlllIIIIllI.m10 * lllllllllllllllllIIIIIllIlllIIlI.m11 + lllllllllllllllllIIIIIlllIIIIllI.m20 * lllllllllllllllllIIIIIllIlllIIlI.m12 + lllllllllllllllllIIIIIlllIIIIllI.m30 * lllllllllllllllllIIIIIllIlllIIlI.m13;
            this.m02 = lllllllllllllllllIIIIIlllIIIIllI.m00 * lllllllllllllllllIIIIIllIlllIIlI.m20 + lllllllllllllllllIIIIIlllIIIIllI.m10 * lllllllllllllllllIIIIIllIlllIIlI.m21 + lllllllllllllllllIIIIIlllIIIIllI.m20 * lllllllllllllllllIIIIIllIlllIIlI.m22 + lllllllllllllllllIIIIIlllIIIIllI.m30 * lllllllllllllllllIIIIIllIlllIIlI.m23;
            this.m03 = lllllllllllllllllIIIIIlllIIIIllI.m00 * lllllllllllllllllIIIIIllIlllIIlI.m30 + lllllllllllllllllIIIIIlllIIIIllI.m10 * lllllllllllllllllIIIIIllIlllIIlI.m31 + lllllllllllllllllIIIIIlllIIIIllI.m20 * lllllllllllllllllIIIIIllIlllIIlI.m32 + lllllllllllllllllIIIIIlllIIIIllI.m30 * lllllllllllllllllIIIIIllIlllIIlI.m33;
            this.m10 = lllllllllllllllllIIIIIlllIIIIllI.m01 * lllllllllllllllllIIIIIllIlllIIlI.m00 + lllllllllllllllllIIIIIlllIIIIllI.m11 * lllllllllllllllllIIIIIllIlllIIlI.m01 + lllllllllllllllllIIIIIlllIIIIllI.m21 * lllllllllllllllllIIIIIllIlllIIlI.m02 + lllllllllllllllllIIIIIlllIIIIllI.m31 * lllllllllllllllllIIIIIllIlllIIlI.m03;
            this.m11 = lllllllllllllllllIIIIIlllIIIIllI.m01 * lllllllllllllllllIIIIIllIlllIIlI.m10 + lllllllllllllllllIIIIIlllIIIIllI.m11 * lllllllllllllllllIIIIIllIlllIIlI.m11 + lllllllllllllllllIIIIIlllIIIIllI.m21 * lllllllllllllllllIIIIIllIlllIIlI.m12 + lllllllllllllllllIIIIIlllIIIIllI.m31 * lllllllllllllllllIIIIIllIlllIIlI.m13;
            this.m12 = lllllllllllllllllIIIIIlllIIIIllI.m01 * lllllllllllllllllIIIIIllIlllIIlI.m20 + lllllllllllllllllIIIIIlllIIIIllI.m11 * lllllllllllllllllIIIIIllIlllIIlI.m21 + lllllllllllllllllIIIIIlllIIIIllI.m21 * lllllllllllllllllIIIIIllIlllIIlI.m22 + lllllllllllllllllIIIIIlllIIIIllI.m31 * lllllllllllllllllIIIIIllIlllIIlI.m23;
            this.m13 = lllllllllllllllllIIIIIlllIIIIllI.m01 * lllllllllllllllllIIIIIllIlllIIlI.m30 + lllllllllllllllllIIIIIlllIIIIllI.m11 * lllllllllllllllllIIIIIllIlllIIlI.m31 + lllllllllllllllllIIIIIlllIIIIllI.m21 * lllllllllllllllllIIIIIllIlllIIlI.m32 + lllllllllllllllllIIIIIlllIIIIllI.m31 * lllllllllllllllllIIIIIllIlllIIlI.m33;
            this.m20 = lllllllllllllllllIIIIIlllIIIIllI.m02 * lllllllllllllllllIIIIIllIlllIIlI.m00 + lllllllllllllllllIIIIIlllIIIIllI.m12 * lllllllllllllllllIIIIIllIlllIIlI.m01 + lllllllllllllllllIIIIIlllIIIIllI.m22 * lllllllllllllllllIIIIIllIlllIIlI.m02 + lllllllllllllllllIIIIIlllIIIIllI.m32 * lllllllllllllllllIIIIIllIlllIIlI.m03;
            this.m21 = lllllllllllllllllIIIIIlllIIIIllI.m02 * lllllllllllllllllIIIIIllIlllIIlI.m10 + lllllllllllllllllIIIIIlllIIIIllI.m12 * lllllllllllllllllIIIIIllIlllIIlI.m11 + lllllllllllllllllIIIIIlllIIIIllI.m22 * lllllllllllllllllIIIIIllIlllIIlI.m12 + lllllllllllllllllIIIIIlllIIIIllI.m32 * lllllllllllllllllIIIIIllIlllIIlI.m13;
            this.m22 = lllllllllllllllllIIIIIlllIIIIllI.m02 * lllllllllllllllllIIIIIllIlllIIlI.m20 + lllllllllllllllllIIIIIlllIIIIllI.m12 * lllllllllllllllllIIIIIllIlllIIlI.m21 + lllllllllllllllllIIIIIlllIIIIllI.m22 * lllllllllllllllllIIIIIllIlllIIlI.m22 + lllllllllllllllllIIIIIlllIIIIllI.m32 * lllllllllllllllllIIIIIllIlllIIlI.m23;
            this.m23 = lllllllllllllllllIIIIIlllIIIIllI.m02 * lllllllllllllllllIIIIIllIlllIIlI.m30 + lllllllllllllllllIIIIIlllIIIIllI.m12 * lllllllllllllllllIIIIIllIlllIIlI.m31 + lllllllllllllllllIIIIIlllIIIIllI.m22 * lllllllllllllllllIIIIIllIlllIIlI.m32 + lllllllllllllllllIIIIIlllIIIIllI.m32 * lllllllllllllllllIIIIIllIlllIIlI.m33;
            this.m30 = lllllllllllllllllIIIIIlllIIIIllI.m03 * lllllllllllllllllIIIIIllIlllIIlI.m00 + lllllllllllllllllIIIIIlllIIIIllI.m13 * lllllllllllllllllIIIIIllIlllIIlI.m01 + lllllllllllllllllIIIIIlllIIIIllI.m23 * lllllllllllllllllIIIIIllIlllIIlI.m02 + lllllllllllllllllIIIIIlllIIIIllI.m33 * lllllllllllllllllIIIIIllIlllIIlI.m03;
            this.m31 = lllllllllllllllllIIIIIlllIIIIllI.m03 * lllllllllllllllllIIIIIllIlllIIlI.m10 + lllllllllllllllllIIIIIlllIIIIllI.m13 * lllllllllllllllllIIIIIllIlllIIlI.m11 + lllllllllllllllllIIIIIlllIIIIllI.m23 * lllllllllllllllllIIIIIllIlllIIlI.m12 + lllllllllllllllllIIIIIlllIIIIllI.m33 * lllllllllllllllllIIIIIllIlllIIlI.m13;
            this.m32 = lllllllllllllllllIIIIIlllIIIIllI.m03 * lllllllllllllllllIIIIIllIlllIIlI.m20 + lllllllllllllllllIIIIIlllIIIIllI.m13 * lllllllllllllllllIIIIIllIlllIIlI.m21 + lllllllllllllllllIIIIIlllIIIIllI.m23 * lllllllllllllllllIIIIIllIlllIIlI.m22 + lllllllllllllllllIIIIIlllIIIIllI.m33 * lllllllllllllllllIIIIIllIlllIIlI.m23;
            this.m33 = lllllllllllllllllIIIIIlllIIIIllI.m03 * lllllllllllllllllIIIIIllIlllIIlI.m30 + lllllllllllllllllIIIIIlllIIIIllI.m13 * lllllllllllllllllIIIIIllIlllIIlI.m31 + lllllllllllllllllIIIIIlllIIIIllI.m23 * lllllllllllllllllIIIIIllIlllIIlI.m32 + lllllllllllllllllIIIIIlllIIIIllI.m33 * lllllllllllllllllIIIIIllIlllIIlI.m33;
        }
        else {
            final float lllllllllllllllllIIIIIlllIIIIlII = lllllllllllllllllIIIIIlllIIIIllI.m00 * lllllllllllllllllIIIIIllIlllIIlI.m00 + lllllllllllllllllIIIIIlllIIIIllI.m10 * lllllllllllllllllIIIIIllIlllIIlI.m01 + lllllllllllllllllIIIIIlllIIIIllI.m20 * lllllllllllllllllIIIIIllIlllIIlI.m02 + lllllllllllllllllIIIIIlllIIIIllI.m30 * lllllllllllllllllIIIIIllIlllIIlI.m03;
            final float lllllllllllllllllIIIIIlllIIIIIll = lllllllllllllllllIIIIIlllIIIIllI.m00 * lllllllllllllllllIIIIIllIlllIIlI.m10 + lllllllllllllllllIIIIIlllIIIIllI.m10 * lllllllllllllllllIIIIIllIlllIIlI.m11 + lllllllllllllllllIIIIIlllIIIIllI.m20 * lllllllllllllllllIIIIIllIlllIIlI.m12 + lllllllllllllllllIIIIIlllIIIIllI.m30 * lllllllllllllllllIIIIIllIlllIIlI.m13;
            final float lllllllllllllllllIIIIIlllIIIIIlI = lllllllllllllllllIIIIIlllIIIIllI.m00 * lllllllllllllllllIIIIIllIlllIIlI.m20 + lllllllllllllllllIIIIIlllIIIIllI.m10 * lllllllllllllllllIIIIIllIlllIIlI.m21 + lllllllllllllllllIIIIIlllIIIIllI.m20 * lllllllllllllllllIIIIIllIlllIIlI.m22 + lllllllllllllllllIIIIIlllIIIIllI.m30 * lllllllllllllllllIIIIIllIlllIIlI.m23;
            final float lllllllllllllllllIIIIIlllIIIIIIl = lllllllllllllllllIIIIIlllIIIIllI.m00 * lllllllllllllllllIIIIIllIlllIIlI.m30 + lllllllllllllllllIIIIIlllIIIIllI.m10 * lllllllllllllllllIIIIIllIlllIIlI.m31 + lllllllllllllllllIIIIIlllIIIIllI.m20 * lllllllllllllllllIIIIIllIlllIIlI.m32 + lllllllllllllllllIIIIIlllIIIIllI.m30 * lllllllllllllllllIIIIIllIlllIIlI.m33;
            final float lllllllllllllllllIIIIIlllIIIIIII = lllllllllllllllllIIIIIlllIIIIllI.m01 * lllllllllllllllllIIIIIllIlllIIlI.m00 + lllllllllllllllllIIIIIlllIIIIllI.m11 * lllllllllllllllllIIIIIllIlllIIlI.m01 + lllllllllllllllllIIIIIlllIIIIllI.m21 * lllllllllllllllllIIIIIllIlllIIlI.m02 + lllllllllllllllllIIIIIlllIIIIllI.m31 * lllllllllllllllllIIIIIllIlllIIlI.m03;
            final float lllllllllllllllllIIIIIllIlllllll = lllllllllllllllllIIIIIlllIIIIllI.m01 * lllllllllllllllllIIIIIllIlllIIlI.m10 + lllllllllllllllllIIIIIlllIIIIllI.m11 * lllllllllllllllllIIIIIllIlllIIlI.m11 + lllllllllllllllllIIIIIlllIIIIllI.m21 * lllllllllllllllllIIIIIllIlllIIlI.m12 + lllllllllllllllllIIIIIlllIIIIllI.m31 * lllllllllllllllllIIIIIllIlllIIlI.m13;
            final float lllllllllllllllllIIIIIllIllllllI = lllllllllllllllllIIIIIlllIIIIllI.m01 * lllllllllllllllllIIIIIllIlllIIlI.m20 + lllllllllllllllllIIIIIlllIIIIllI.m11 * lllllllllllllllllIIIIIllIlllIIlI.m21 + lllllllllllllllllIIIIIlllIIIIllI.m21 * lllllllllllllllllIIIIIllIlllIIlI.m22 + lllllllllllllllllIIIIIlllIIIIllI.m31 * lllllllllllllllllIIIIIllIlllIIlI.m23;
            final float lllllllllllllllllIIIIIllIlllllIl = lllllllllllllllllIIIIIlllIIIIllI.m01 * lllllllllllllllllIIIIIllIlllIIlI.m30 + lllllllllllllllllIIIIIlllIIIIllI.m11 * lllllllllllllllllIIIIIllIlllIIlI.m31 + lllllllllllllllllIIIIIlllIIIIllI.m21 * lllllllllllllllllIIIIIllIlllIIlI.m32 + lllllllllllllllllIIIIIlllIIIIllI.m31 * lllllllllllllllllIIIIIllIlllIIlI.m33;
            final float lllllllllllllllllIIIIIllIlllllII = lllllllllllllllllIIIIIlllIIIIllI.m02 * lllllllllllllllllIIIIIllIlllIIlI.m00 + lllllllllllllllllIIIIIlllIIIIllI.m12 * lllllllllllllllllIIIIIllIlllIIlI.m01 + lllllllllllllllllIIIIIlllIIIIllI.m22 * lllllllllllllllllIIIIIllIlllIIlI.m02 + lllllllllllllllllIIIIIlllIIIIllI.m32 * lllllllllllllllllIIIIIllIlllIIlI.m03;
            final float lllllllllllllllllIIIIIllIllllIll = lllllllllllllllllIIIIIlllIIIIllI.m02 * lllllllllllllllllIIIIIllIlllIIlI.m10 + lllllllllllllllllIIIIIlllIIIIllI.m12 * lllllllllllllllllIIIIIllIlllIIlI.m11 + lllllllllllllllllIIIIIlllIIIIllI.m22 * lllllllllllllllllIIIIIllIlllIIlI.m12 + lllllllllllllllllIIIIIlllIIIIllI.m32 * lllllllllllllllllIIIIIllIlllIIlI.m13;
            final float lllllllllllllllllIIIIIllIllllIlI = lllllllllllllllllIIIIIlllIIIIllI.m02 * lllllllllllllllllIIIIIllIlllIIlI.m20 + lllllllllllllllllIIIIIlllIIIIllI.m12 * lllllllllllllllllIIIIIllIlllIIlI.m21 + lllllllllllllllllIIIIIlllIIIIllI.m22 * lllllllllllllllllIIIIIllIlllIIlI.m22 + lllllllllllllllllIIIIIlllIIIIllI.m32 * lllllllllllllllllIIIIIllIlllIIlI.m23;
            final float lllllllllllllllllIIIIIllIllllIIl = lllllllllllllllllIIIIIlllIIIIllI.m02 * lllllllllllllllllIIIIIllIlllIIlI.m30 + lllllllllllllllllIIIIIlllIIIIllI.m12 * lllllllllllllllllIIIIIllIlllIIlI.m31 + lllllllllllllllllIIIIIlllIIIIllI.m22 * lllllllllllllllllIIIIIllIlllIIlI.m32 + lllllllllllllllllIIIIIlllIIIIllI.m32 * lllllllllllllllllIIIIIllIlllIIlI.m33;
            final float lllllllllllllllllIIIIIllIllllIII = lllllllllllllllllIIIIIlllIIIIllI.m03 * lllllllllllllllllIIIIIllIlllIIlI.m00 + lllllllllllllllllIIIIIlllIIIIllI.m13 * lllllllllllllllllIIIIIllIlllIIlI.m01 + lllllllllllllllllIIIIIlllIIIIllI.m23 * lllllllllllllllllIIIIIllIlllIIlI.m02 + lllllllllllllllllIIIIIlllIIIIllI.m33 * lllllllllllllllllIIIIIllIlllIIlI.m03;
            final float lllllllllllllllllIIIIIllIlllIlll = lllllllllllllllllIIIIIlllIIIIllI.m03 * lllllllllllllllllIIIIIllIlllIIlI.m10 + lllllllllllllllllIIIIIlllIIIIllI.m13 * lllllllllllllllllIIIIIllIlllIIlI.m11 + lllllllllllllllllIIIIIlllIIIIllI.m23 * lllllllllllllllllIIIIIllIlllIIlI.m12 + lllllllllllllllllIIIIIlllIIIIllI.m33 * lllllllllllllllllIIIIIllIlllIIlI.m13;
            final float lllllllllllllllllIIIIIllIlllIllI = lllllllllllllllllIIIIIlllIIIIllI.m03 * lllllllllllllllllIIIIIllIlllIIlI.m20 + lllllllllllllllllIIIIIlllIIIIllI.m13 * lllllllllllllllllIIIIIllIlllIIlI.m21 + lllllllllllllllllIIIIIlllIIIIllI.m23 * lllllllllllllllllIIIIIllIlllIIlI.m22 + lllllllllllllllllIIIIIlllIIIIllI.m33 * lllllllllllllllllIIIIIllIlllIIlI.m23;
            final float lllllllllllllllllIIIIIllIlllIlIl = lllllllllllllllllIIIIIlllIIIIllI.m03 * lllllllllllllllllIIIIIllIlllIIlI.m30 + lllllllllllllllllIIIIIlllIIIIllI.m13 * lllllllllllllllllIIIIIllIlllIIlI.m31 + lllllllllllllllllIIIIIlllIIIIllI.m23 * lllllllllllllllllIIIIIllIlllIIlI.m32 + lllllllllllllllllIIIIIlllIIIIllI.m33 * lllllllllllllllllIIIIIllIlllIIlI.m33;
            this.m00 = lllllllllllllllllIIIIIlllIIIIlII;
            this.m01 = lllllllllllllllllIIIIIlllIIIIIll;
            this.m02 = lllllllllllllllllIIIIIlllIIIIIlI;
            this.m03 = lllllllllllllllllIIIIIlllIIIIIIl;
            this.m10 = lllllllllllllllllIIIIIlllIIIIIII;
            this.m11 = lllllllllllllllllIIIIIllIlllllll;
            this.m12 = lllllllllllllllllIIIIIllIllllllI;
            this.m13 = lllllllllllllllllIIIIIllIlllllIl;
            this.m20 = lllllllllllllllllIIIIIllIlllllII;
            this.m21 = lllllllllllllllllIIIIIllIllllIll;
            this.m22 = lllllllllllllllllIIIIIllIllllIlI;
            this.m23 = lllllllllllllllllIIIIIllIllllIIl;
            this.m30 = lllllllllllllllllIIIIIllIllllIII;
            this.m31 = lllllllllllllllllIIIIIllIlllIlll;
            this.m32 = lllllllllllllllllIIIIIllIlllIllI;
            this.m33 = lllllllllllllllllIIIIIllIlllIlIl;
        }
    }
    
    public final void set(final AxisAngle4f lllllllllllllllllIIIIlIlIlllIIII) {
        float lllllllllllllllllIIIIlIlIllIllll = (float)Math.sqrt(lllllllllllllllllIIIIlIlIlllIIII.x * lllllllllllllllllIIIIlIlIlllIIII.x + lllllllllllllllllIIIIlIlIlllIIII.y * lllllllllllllllllIIIIlIlIlllIIII.y + lllllllllllllllllIIIIlIlIlllIIII.z * lllllllllllllllllIIIIlIlIlllIIII.z);
        if (lllllllllllllllllIIIIlIlIllIllll < 1.0E-8) {
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
            lllllllllllllllllIIIIlIlIllIllll = 1.0f / lllllllllllllllllIIIIlIlIllIllll;
            final float lllllllllllllllllIIIIlIlIllIlllI = lllllllllllllllllIIIIlIlIlllIIII.x * lllllllllllllllllIIIIlIlIllIllll;
            final float lllllllllllllllllIIIIlIlIllIllIl = lllllllllllllllllIIIIlIlIlllIIII.y * lllllllllllllllllIIIIlIlIllIllll;
            final float lllllllllllllllllIIIIlIlIllIllII = lllllllllllllllllIIIIlIlIlllIIII.z * lllllllllllllllllIIIIlIlIllIllll;
            final float lllllllllllllllllIIIIlIlIllIlIll = (float)Math.sin(lllllllllllllllllIIIIlIlIlllIIII.angle);
            final float lllllllllllllllllIIIIlIlIllIlIlI = (float)Math.cos(lllllllllllllllllIIIIlIlIlllIIII.angle);
            final float lllllllllllllllllIIIIlIlIllIlIIl = 1.0f - lllllllllllllllllIIIIlIlIllIlIlI;
            final float lllllllllllllllllIIIIlIlIllIlIII = lllllllllllllllllIIIIlIlIllIlllI * lllllllllllllllllIIIIlIlIllIllII;
            final float lllllllllllllllllIIIIlIlIllIIlll = lllllllllllllllllIIIIlIlIllIlllI * lllllllllllllllllIIIIlIlIllIllIl;
            final float lllllllllllllllllIIIIlIlIllIIllI = lllllllllllllllllIIIIlIlIllIllIl * lllllllllllllllllIIIIlIlIllIllII;
            this.m00 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIlllI * lllllllllllllllllIIIIlIlIllIlllI + lllllllllllllllllIIIIlIlIllIlIlI;
            this.m01 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIIlll - lllllllllllllllllIIIIlIlIllIlIll * lllllllllllllllllIIIIlIlIllIllII;
            this.m02 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIlIII + lllllllllllllllllIIIIlIlIllIlIll * lllllllllllllllllIIIIlIlIllIllIl;
            this.m10 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIIlll + lllllllllllllllllIIIIlIlIllIlIll * lllllllllllllllllIIIIlIlIllIllII;
            this.m11 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIllIl * lllllllllllllllllIIIIlIlIllIllIl + lllllllllllllllllIIIIlIlIllIlIlI;
            this.m12 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIIllI - lllllllllllllllllIIIIlIlIllIlIll * lllllllllllllllllIIIIlIlIllIlllI;
            this.m20 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIlIII - lllllllllllllllllIIIIlIlIllIlIll * lllllllllllllllllIIIIlIlIllIllIl;
            this.m21 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIIllI + lllllllllllllllllIIIIlIlIllIlIll * lllllllllllllllllIIIIlIlIllIlllI;
            this.m22 = lllllllllllllllllIIIIlIlIllIlIIl * lllllllllllllllllIIIIlIlIllIllII * lllllllllllllllllIIIIlIlIllIllII + lllllllllllllllllIIIIlIlIllIlIlI;
        }
        this.m03 = 0.0f;
        this.m13 = 0.0f;
        this.m23 = 0.0f;
        this.m30 = 0.0f;
        this.m31 = 0.0f;
        this.m32 = 0.0f;
        this.m33 = 1.0f;
    }
    
    public final void getColumn(final int lllllllllllllllllIIIIllIIllllIll, final float[] lllllllllllllllllIIIIllIIllllIlI) {
        if (lllllllllllllllllIIIIllIIllllIll == 0) {
            lllllllllllllllllIIIIllIIllllIlI[0] = this.m00;
            lllllllllllllllllIIIIllIIllllIlI[1] = this.m10;
            lllllllllllllllllIIIIllIIllllIlI[2] = this.m20;
            lllllllllllllllllIIIIllIIllllIlI[3] = this.m30;
        }
        else if (lllllllllllllllllIIIIllIIllllIll == 1) {
            lllllllllllllllllIIIIllIIllllIlI[0] = this.m01;
            lllllllllllllllllIIIIllIIllllIlI[1] = this.m11;
            lllllllllllllllllIIIIllIIllllIlI[2] = this.m21;
            lllllllllllllllllIIIIllIIllllIlI[3] = this.m31;
        }
        else if (lllllllllllllllllIIIIllIIllllIll == 2) {
            lllllllllllllllllIIIIllIIllllIlI[0] = this.m02;
            lllllllllllllllllIIIIllIIllllIlI[1] = this.m12;
            lllllllllllllllllIIIIllIIllllIlI[2] = this.m22;
            lllllllllllllllllIIIIllIIllllIlI[3] = this.m32;
        }
        else {
            if (lllllllllllllllllIIIIllIIllllIll != 3) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4f4"));
            }
            lllllllllllllllllIIIIllIIllllIlI[0] = this.m03;
            lllllllllllllllllIIIIllIIllllIlI[1] = this.m13;
            lllllllllllllllllIIIIllIIllllIlI[2] = this.m23;
            lllllllllllllllllIIIIllIIllllIlI[3] = this.m33;
        }
    }
}
