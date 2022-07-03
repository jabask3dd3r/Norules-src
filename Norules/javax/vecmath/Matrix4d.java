package javax.vecmath;

import java.io.*;

public class Matrix4d implements Serializable, Cloneable
{
    public /* synthetic */ double m00;
    public /* synthetic */ double m10;
    public /* synthetic */ double m02;
    public /* synthetic */ double m31;
    public /* synthetic */ double m11;
    public /* synthetic */ double m21;
    public /* synthetic */ double m03;
    public /* synthetic */ double m13;
    public /* synthetic */ double m30;
    public /* synthetic */ double m12;
    public /* synthetic */ double m32;
    public /* synthetic */ double m22;
    public /* synthetic */ double m33;
    public /* synthetic */ double m01;
    public /* synthetic */ double m20;
    public /* synthetic */ double m23;
    
    public final double get(final Matrix3d lllllllllllllIIllIlIlIIIlllIlllI, final Vector3d lllllllllllllIIllIlIlIIIllllIIlI) {
        final double[] lllllllllllllIIllIlIlIIIllllIIIl = new double[9];
        final double[] lllllllllllllIIllIlIlIIIllllIIII = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIlIIIllllIIII, lllllllllllllIIllIlIlIIIllllIIIl);
        lllllllllllllIIllIlIlIIIlllIlllI.m00 = lllllllllllllIIllIlIlIIIllllIIIl[0];
        lllllllllllllIIllIlIlIIIlllIlllI.m01 = lllllllllllllIIllIlIlIIIllllIIIl[1];
        lllllllllllllIIllIlIlIIIlllIlllI.m02 = lllllllllllllIIllIlIlIIIllllIIIl[2];
        lllllllllllllIIllIlIlIIIlllIlllI.m10 = lllllllllllllIIllIlIlIIIllllIIIl[3];
        lllllllllllllIIllIlIlIIIlllIlllI.m11 = lllllllllllllIIllIlIlIIIllllIIIl[4];
        lllllllllllllIIllIlIlIIIlllIlllI.m12 = lllllllllllllIIllIlIlIIIllllIIIl[5];
        lllllllllllllIIllIlIlIIIlllIlllI.m20 = lllllllllllllIIllIlIlIIIllllIIIl[6];
        lllllllllllllIIllIlIlIIIlllIlllI.m21 = lllllllllllllIIllIlIlIIIllllIIIl[7];
        lllllllllllllIIllIlIlIIIlllIlllI.m22 = lllllllllllllIIllIlIlIIIllllIIIl[8];
        lllllllllllllIIllIlIlIIIllllIIlI.x = this.m03;
        lllllllllllllIIllIlIlIIIllllIIlI.y = this.m13;
        lllllllllllllIIllIlIlIIIllllIIlI.z = this.m23;
        return Matrix3d.max3(lllllllllllllIIllIlIlIIIllllIIII);
    }
    
    public Matrix4d(final Matrix4d lllllllllllllIIllIlIlIIllIIIlIll) {
        this.m00 = lllllllllllllIIllIlIlIIllIIIlIll.m00;
        this.m01 = lllllllllllllIIllIlIlIIllIIIlIll.m01;
        this.m02 = lllllllllllllIIllIlIlIIllIIIlIll.m02;
        this.m03 = lllllllllllllIIllIlIlIIllIIIlIll.m03;
        this.m10 = lllllllllllllIIllIlIlIIllIIIlIll.m10;
        this.m11 = lllllllllllllIIllIlIlIIllIIIlIll.m11;
        this.m12 = lllllllllllllIIllIlIlIIllIIIlIll.m12;
        this.m13 = lllllllllllllIIllIlIlIIllIIIlIll.m13;
        this.m20 = lllllllllllllIIllIlIlIIllIIIlIll.m20;
        this.m21 = lllllllllllllIIllIlIlIIllIIIlIll.m21;
        this.m22 = lllllllllllllIIllIlIlIIllIIIlIll.m22;
        this.m23 = lllllllllllllIIllIlIlIIllIIIlIll.m23;
        this.m30 = lllllllllllllIIllIlIlIIllIIIlIll.m30;
        this.m31 = lllllllllllllIIllIlIlIIllIIIlIll.m31;
        this.m32 = lllllllllllllIIllIlIlIIllIIIlIll.m32;
        this.m33 = lllllllllllllIIllIlIlIIllIIIlIll.m33;
    }
    
    public final void setScale(final double lllllllllllllIIllIlIlIIIIlllIIII) {
        final double[] lllllllllllllIIllIlIlIIIIllIllll = new double[9];
        final double[] lllllllllllllIIllIlIlIIIIllIlllI = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIlIIIIllIlllI, lllllllllllllIIllIlIlIIIIllIllll);
        this.m00 = lllllllllllllIIllIlIlIIIIllIllll[0] * lllllllllllllIIllIlIlIIIIlllIIII;
        this.m01 = lllllllllllllIIllIlIlIIIIllIllll[1] * lllllllllllllIIllIlIlIIIIlllIIII;
        this.m02 = lllllllllllllIIllIlIlIIIIllIllll[2] * lllllllllllllIIllIlIlIIIIlllIIII;
        this.m10 = lllllllllllllIIllIlIlIIIIllIllll[3] * lllllllllllllIIllIlIlIIIIlllIIII;
        this.m11 = lllllllllllllIIllIlIlIIIIllIllll[4] * lllllllllllllIIllIlIlIIIIlllIIII;
        this.m12 = lllllllllllllIIllIlIlIIIIllIllll[5] * lllllllllllllIIllIlIlIIIIlllIIII;
        this.m20 = lllllllllllllIIllIlIlIIIIllIllll[6] * lllllllllllllIIllIlIlIIIIlllIIII;
        this.m21 = lllllllllllllIIllIlIlIIIIllIllll[7] * lllllllllllllIIllIlIlIIIIlllIIII;
        this.m22 = lllllllllllllIIllIlIlIIIIllIllll[8] * lllllllllllllIIllIlIlIIIIlllIIII;
    }
    
    public final double getElement(final int lllllllllllllIIllIlIlIIlIlIlIIIl, final int lllllllllllllIIllIlIlIIlIlIIllIl) {
        Label_0255: {
            switch (lllllllllllllIIllIlIlIIlIlIlIIIl) {
                case 0: {
                    switch (lllllllllllllIIllIlIlIIlIlIIllIl) {
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
                    switch (lllllllllllllIIllIlIlIIlIlIIllIl) {
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
                    switch (lllllllllllllIIllIlIlIIlIlIIllIl) {
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
                    switch (lllllllllllllIIllIlIlIIlIlIIllIl) {
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
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d1"));
    }
    
    public final void transform(final Vector3d lllllllllllllIIllIlIIlIIIIllIlII) {
        final double lllllllllllllIIllIlIIlIIIIllIIll = this.m00 * lllllllllllllIIllIlIIlIIIIllIlII.x + this.m01 * lllllllllllllIIllIlIIlIIIIllIlII.y + this.m02 * lllllllllllllIIllIlIIlIIIIllIlII.z;
        final double lllllllllllllIIllIlIIlIIIIllIIlI = this.m10 * lllllllllllllIIllIlIIlIIIIllIlII.x + this.m11 * lllllllllllllIIllIlIIlIIIIllIlII.y + this.m12 * lllllllllllllIIllIlIIlIIIIllIlII.z;
        lllllllllllllIIllIlIIlIIIIllIlII.z = this.m20 * lllllllllllllIIllIlIIlIIIIllIlII.x + this.m21 * lllllllllllllIIllIlIIlIIIIllIlII.y + this.m22 * lllllllllllllIIllIlIIlIIIIllIlII.z;
        lllllllllllllIIllIlIIlIIIIllIlII.x = lllllllllllllIIllIlIIlIIIIllIIll;
        lllllllllllllIIllIlIIlIIIIllIlII.y = lllllllllllllIIllIlIIlIIIIllIIlI;
    }
    
    public final void setRow(final int lllllllllllllIIllIlIlIIIIlIlllII, final double lllllllllllllIIllIlIlIIIIllIIIIl, final double lllllllllllllIIllIlIlIIIIlIllIlI, final double lllllllllllllIIllIlIlIIIIlIllIIl, final double lllllllllllllIIllIlIlIIIIlIllllI) {
        switch (lllllllllllllIIllIlIlIIIIlIlllII) {
            case 0: {
                this.m00 = lllllllllllllIIllIlIlIIIIllIIIIl;
                this.m01 = lllllllllllllIIllIlIlIIIIlIllIlI;
                this.m02 = lllllllllllllIIllIlIlIIIIlIllIIl;
                this.m03 = lllllllllllllIIllIlIlIIIIlIllllI;
                break;
            }
            case 1: {
                this.m10 = lllllllllllllIIllIlIlIIIIllIIIIl;
                this.m11 = lllllllllllllIIllIlIlIIIIlIllIlI;
                this.m12 = lllllllllllllIIllIlIlIIIIlIllIIl;
                this.m13 = lllllllllllllIIllIlIlIIIIlIllllI;
                break;
            }
            case 2: {
                this.m20 = lllllllllllllIIllIlIlIIIIllIIIIl;
                this.m21 = lllllllllllllIIllIlIlIIIIlIllIlI;
                this.m22 = lllllllllllllIIllIlIlIIIIlIllIIl;
                this.m23 = lllllllllllllIIllIlIlIIIIlIllllI;
                break;
            }
            case 3: {
                this.m30 = lllllllllllllIIllIlIlIIIIllIIIIl;
                this.m31 = lllllllllllllIIllIlIlIIIIlIllIlI;
                this.m32 = lllllllllllllIIllIlIlIIIIlIllIIl;
                this.m33 = lllllllllllllIIllIlIlIIIIlIllllI;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
            }
        }
    }
    
    public final void setM30(final double lllllllllllllIIllIlIIIllIIlIIIll) {
        this.m30 = lllllllllllllIIllIlIIIllIIlIIIll;
    }
    
    public final void getColumn(final int lllllllllllllIIllIlIlIIlIIlIllIl, final double[] lllllllllllllIIllIlIlIIlIIlIllII) {
        if (lllllllllllllIIllIlIlIIlIIlIllIl == 0) {
            lllllllllllllIIllIlIlIIlIIlIllII[0] = this.m00;
            lllllllllllllIIllIlIlIIlIIlIllII[1] = this.m10;
            lllllllllllllIIllIlIlIIlIIlIllII[2] = this.m20;
            lllllllllllllIIllIlIlIIlIIlIllII[3] = this.m30;
        }
        else if (lllllllllllllIIllIlIlIIlIIlIllIl == 1) {
            lllllllllllllIIllIlIlIIlIIlIllII[0] = this.m01;
            lllllllllllllIIllIlIlIIlIIlIllII[1] = this.m11;
            lllllllllllllIIllIlIlIIlIIlIllII[2] = this.m21;
            lllllllllllllIIllIlIlIIlIIlIllII[3] = this.m31;
        }
        else if (lllllllllllllIIllIlIlIIlIIlIllIl == 2) {
            lllllllllllllIIllIlIlIIlIIlIllII[0] = this.m02;
            lllllllllllllIIllIlIlIIlIIlIllII[1] = this.m12;
            lllllllllllllIIllIlIlIIlIIlIllII[2] = this.m22;
            lllllllllllllIIllIlIlIIlIIlIllII[3] = this.m32;
        }
        else {
            if (lllllllllllllIIllIlIlIIlIIlIllIl != 3) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d3"));
            }
            lllllllllllllIIllIlIlIIlIIlIllII[0] = this.m03;
            lllllllllllllIIllIlIlIIlIIlIllII[1] = this.m13;
            lllllllllllllIIllIlIlIIlIIlIllII[2] = this.m23;
            lllllllllllllIIllIlIlIIlIIlIllII[3] = this.m33;
        }
    }
    
    public final void setM23(final double lllllllllllllIIllIlIIIllIIlIllII) {
        this.m23 = lllllllllllllIIllIlIIIllIIlIllII;
    }
    
    public final double getM01() {
        return this.m01;
    }
    
    public final void set(final double[] lllllllllllllIIllIlIIllllllIIlIl) {
        this.m00 = lllllllllllllIIllIlIIllllllIIlIl[0];
        this.m01 = lllllllllllllIIllIlIIllllllIIlIl[1];
        this.m02 = lllllllllllllIIllIlIIllllllIIlIl[2];
        this.m03 = lllllllllllllIIllIlIIllllllIIlIl[3];
        this.m10 = lllllllllllllIIllIlIIllllllIIlIl[4];
        this.m11 = lllllllllllllIIllIlIIllllllIIlIl[5];
        this.m12 = lllllllllllllIIllIlIIllllllIIlIl[6];
        this.m13 = lllllllllllllIIllIlIIllllllIIlIl[7];
        this.m20 = lllllllllllllIIllIlIIllllllIIlIl[8];
        this.m21 = lllllllllllllIIllIlIIllllllIIlIl[9];
        this.m22 = lllllllllllllIIllIlIIllllllIIlIl[10];
        this.m23 = lllllllllllllIIllIlIIllllllIIlIl[11];
        this.m30 = lllllllllllllIIllIlIIllllllIIlIl[12];
        this.m31 = lllllllllllllIIllIlIIllllllIIlIl[13];
        this.m32 = lllllllllllllIIllIlIIllllllIIlIl[14];
        this.m33 = lllllllllllllIIllIlIIllllllIIlIl[15];
    }
    
    public final void set(final AxisAngle4d lllllllllllllIIllIlIIllllIllIllI) {
        double lllllllllllllIIllIlIIlllllIIIIlI = Math.sqrt(lllllllllllllIIllIlIIllllIllIllI.x * lllllllllllllIIllIlIIllllIllIllI.x + lllllllllllllIIllIlIIllllIllIllI.y * lllllllllllllIIllIlIIllllIllIllI.y + lllllllllllllIIllIlIIllllIllIllI.z * lllllllllllllIIllIlIIllllIllIllI.z);
        if (lllllllllllllIIllIlIIlllllIIIIlI < 1.0E-10) {
            this.m00 = 1.0;
            this.m01 = 0.0;
            this.m02 = 0.0;
            this.m10 = 0.0;
            this.m11 = 1.0;
            this.m12 = 0.0;
            this.m20 = 0.0;
            this.m21 = 0.0;
            this.m22 = 1.0;
        }
        else {
            lllllllllllllIIllIlIIlllllIIIIlI = 1.0 / lllllllllllllIIllIlIIlllllIIIIlI;
            final double lllllllllllllIIllIlIIlllllIIIIIl = lllllllllllllIIllIlIIllllIllIllI.x * lllllllllllllIIllIlIIlllllIIIIlI;
            final double lllllllllllllIIllIlIIlllllIIIIII = lllllllllllllIIllIlIIllllIllIllI.y * lllllllllllllIIllIlIIlllllIIIIlI;
            final double lllllllllllllIIllIlIIllllIllllll = lllllllllllllIIllIlIIllllIllIllI.z * lllllllllllllIIllIlIIlllllIIIIlI;
            final double lllllllllllllIIllIlIIllllIlllllI = Math.sin(lllllllllllllIIllIlIIllllIllIllI.angle);
            final double lllllllllllllIIllIlIIllllIllllIl = Math.cos(lllllllllllllIIllIlIIllllIllIllI.angle);
            final double lllllllllllllIIllIlIIllllIllllII = 1.0 - lllllllllllllIIllIlIIllllIllllIl;
            final double lllllllllllllIIllIlIIllllIlllIll = lllllllllllllIIllIlIIlllllIIIIIl * lllllllllllllIIllIlIIllllIllllll;
            final double lllllllllllllIIllIlIIllllIlllIlI = lllllllllllllIIllIlIIlllllIIIIIl * lllllllllllllIIllIlIIlllllIIIIII;
            final double lllllllllllllIIllIlIIllllIlllIIl = lllllllllllllIIllIlIIlllllIIIIII * lllllllllllllIIllIlIIllllIllllll;
            this.m00 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIlllllIIIIIl * lllllllllllllIIllIlIIlllllIIIIIl + lllllllllllllIIllIlIIllllIllllIl;
            this.m01 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIllllIlllIlI - lllllllllllllIIllIlIIllllIlllllI * lllllllllllllIIllIlIIllllIllllll;
            this.m02 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIllllIlllIll + lllllllllllllIIllIlIIllllIlllllI * lllllllllllllIIllIlIIlllllIIIIII;
            this.m10 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIllllIlllIlI + lllllllllllllIIllIlIIllllIlllllI * lllllllllllllIIllIlIIllllIllllll;
            this.m11 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIlllllIIIIII * lllllllllllllIIllIlIIlllllIIIIII + lllllllllllllIIllIlIIllllIllllIl;
            this.m12 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIllllIlllIIl - lllllllllllllIIllIlIIllllIlllllI * lllllllllllllIIllIlIIlllllIIIIIl;
            this.m20 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIllllIlllIll - lllllllllllllIIllIlIIllllIlllllI * lllllllllllllIIllIlIIlllllIIIIII;
            this.m21 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIllllIlllIIl + lllllllllllllIIllIlIIllllIlllllI * lllllllllllllIIllIlIIlllllIIIIIl;
            this.m22 = lllllllllllllIIllIlIIllllIllllII * lllllllllllllIIllIlIIllllIllllll * lllllllllllllIIllIlIIllllIllllll + lllllllllllllIIllIlIIllllIllllIl;
        }
        this.m03 = 0.0;
        this.m13 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void setM21(final double lllllllllllllIIllIlIIIllIlIlIIII) {
        this.m21 = lllllllllllllIIllIlIIIllIlIlIIII;
    }
    
    public final double getM03() {
        return this.m03;
    }
    
    public Matrix4d(final Matrix4f lllllllllllllIIllIlIlIIllIIIIIll) {
        this.m00 = lllllllllllllIIllIlIlIIllIIIIIll.m00;
        this.m01 = lllllllllllllIIllIlIlIIllIIIIIll.m01;
        this.m02 = lllllllllllllIIllIlIlIIllIIIIIll.m02;
        this.m03 = lllllllllllllIIllIlIlIIllIIIIIll.m03;
        this.m10 = lllllllllllllIIllIlIlIIllIIIIIll.m10;
        this.m11 = lllllllllllllIIllIlIlIIllIIIIIll.m11;
        this.m12 = lllllllllllllIIllIlIlIIllIIIIIll.m12;
        this.m13 = lllllllllllllIIllIlIlIIllIIIIIll.m13;
        this.m20 = lllllllllllllIIllIlIlIIllIIIIIll.m20;
        this.m21 = lllllllllllllIIllIlIlIIllIIIIIll.m21;
        this.m22 = lllllllllllllIIllIlIlIIllIIIIIll.m22;
        this.m23 = lllllllllllllIIllIlIlIIllIIIIIll.m23;
        this.m30 = lllllllllllllIIllIlIlIIllIIIIIll.m30;
        this.m31 = lllllllllllllIIllIlIlIIllIIIIIll.m31;
        this.m32 = lllllllllllllIIllIlIlIIllIIIIIll.m32;
        this.m33 = lllllllllllllIIllIlIlIIllIIIIIll.m33;
    }
    
    public final void transform(final Point3d lllllllllllllIIllIlIIlIIIlllIIll, final Point3d lllllllllllllIIllIlIIlIIIlllIlll) {
        final double lllllllllllllIIllIlIIlIIIlllIllI = this.m00 * lllllllllllllIIllIlIIlIIIlllIIll.x + this.m01 * lllllllllllllIIllIlIIlIIIlllIIll.y + this.m02 * lllllllllllllIIllIlIIlIIIlllIIll.z + this.m03;
        final double lllllllllllllIIllIlIIlIIIlllIlIl = this.m10 * lllllllllllllIIllIlIIlIIIlllIIll.x + this.m11 * lllllllllllllIIllIlIIlIIIlllIIll.y + this.m12 * lllllllllllllIIllIlIIlIIIlllIIll.z + this.m13;
        lllllllllllllIIllIlIIlIIIlllIlll.z = this.m20 * lllllllllllllIIllIlIIlIIIlllIIll.x + this.m21 * lllllllllllllIIllIlIIlIIIlllIIll.y + this.m22 * lllllllllllllIIllIlIIlIIIlllIIll.z + this.m23;
        lllllllllllllIIllIlIIlIIIlllIlll.x = lllllllllllllIIllIlIIlIIIlllIllI;
        lllllllllllllIIllIlIIlIIIlllIlll.y = lllllllllllllIIllIlIIlIIIlllIlIl;
    }
    
    public final void setZero() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 0.0;
    }
    
    public final void rotY(final double lllllllllllllIIllIlIIllIlIIIIlII) {
        final double lllllllllllllIIllIlIIllIlIIIIIll = Math.sin(lllllllllllllIIllIlIIllIlIIIIlII);
        final double lllllllllllllIIllIlIIllIlIIIIIlI = Math.cos(lllllllllllllIIllIlIIllIlIIIIlII);
        this.m00 = lllllllllllllIIllIlIIllIlIIIIIlI;
        this.m01 = 0.0;
        this.m02 = lllllllllllllIIllIlIIllIlIIIIIll;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = -lllllllllllllIIllIlIIllIlIIIIIll;
        this.m21 = 0.0;
        this.m22 = lllllllllllllIIllIlIIllIlIIIIIlI;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void setRotationScale(final Matrix3f lllllllllllllIIllIlIlIIIIllllIII) {
        this.m00 = lllllllllllllIIllIlIlIIIIllllIII.m00;
        this.m01 = lllllllllllllIIllIlIlIIIIllllIII.m01;
        this.m02 = lllllllllllllIIllIlIlIIIIllllIII.m02;
        this.m10 = lllllllllllllIIllIlIlIIIIllllIII.m10;
        this.m11 = lllllllllllllIIllIlIlIIIIllllIII.m11;
        this.m12 = lllllllllllllIIllIlIlIIIIllllIII.m12;
        this.m20 = lllllllllllllIIllIlIlIIIIllllIII.m20;
        this.m21 = lllllllllllllIIllIlIlIIIIllllIII.m21;
        this.m22 = lllllllllllllIIllIlIlIIIIllllIII.m22;
    }
    
    public final void getRotationScale(final Matrix3d lllllllllllllIIllIlIlIIIlIIIllIl) {
        lllllllllllllIIllIlIlIIIlIIIllIl.m00 = this.m00;
        lllllllllllllIIllIlIlIIIlIIIllIl.m01 = this.m01;
        lllllllllllllIIllIlIlIIIlIIIllIl.m02 = this.m02;
        lllllllllllllIIllIlIlIIIlIIIllIl.m10 = this.m10;
        lllllllllllllIIllIlIlIIIlIIIllIl.m11 = this.m11;
        lllllllllllllIIllIlIlIIIlIIIllIl.m12 = this.m12;
        lllllllllllllIIllIlIlIIIlIIIllIl.m20 = this.m20;
        lllllllllllllIIllIlIlIIIlIIIllIl.m21 = this.m21;
        lllllllllllllIIllIlIlIIIlIIIllIl.m22 = this.m22;
    }
    
    public final void rotX(final double lllllllllllllIIllIlIIllIlIIlIIII) {
        final double lllllllllllllIIllIlIIllIlIIIllll = Math.sin(lllllllllllllIIllIlIIllIlIIlIIII);
        final double lllllllllllllIIllIlIIllIlIIIlllI = Math.cos(lllllllllllllIIllIlIIllIlIIlIIII);
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = lllllllllllllIIllIlIIllIlIIIlllI;
        this.m12 = -lllllllllllllIIllIlIIllIlIIIllll;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = lllllllllllllIIllIlIIllIlIIIllll;
        this.m22 = lllllllllllllIIllIlIIllIlIIIlllI;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void getRow(final int lllllllllllllIIllIlIlIIlIIllllII, final double[] lllllllllllllIIllIlIlIIlIIlllIll) {
        if (lllllllllllllIIllIlIlIIlIIllllII == 0) {
            lllllllllllllIIllIlIlIIlIIlllIll[0] = this.m00;
            lllllllllllllIIllIlIlIIlIIlllIll[1] = this.m01;
            lllllllllllllIIllIlIlIIlIIlllIll[2] = this.m02;
            lllllllllllllIIllIlIlIIlIIlllIll[3] = this.m03;
        }
        else if (lllllllllllllIIllIlIlIIlIIllllII == 1) {
            lllllllllllllIIllIlIlIIlIIlllIll[0] = this.m10;
            lllllllllllllIIllIlIlIIlIIlllIll[1] = this.m11;
            lllllllllllllIIllIlIlIIlIIlllIll[2] = this.m12;
            lllllllllllllIIllIlIlIIlIIlllIll[3] = this.m13;
        }
        else if (lllllllllllllIIllIlIlIIlIIllllII == 2) {
            lllllllllllllIIllIlIlIIlIIlllIll[0] = this.m20;
            lllllllllllllIIllIlIlIIlIIlllIll[1] = this.m21;
            lllllllllllllIIllIlIlIIlIIlllIll[2] = this.m22;
            lllllllllllllIIllIlIlIIlIIlllIll[3] = this.m23;
        }
        else {
            if (lllllllllllllIIllIlIlIIlIIllllII != 3) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d2"));
            }
            lllllllllllllIIllIlIlIIlIIlllIll[0] = this.m30;
            lllllllllllllIIllIlIlIIlIIlllIll[1] = this.m31;
            lllllllllllllIIllIlIlIIlIIlllIll[2] = this.m32;
            lllllllllllllIIllIlIlIIlIIlllIll[3] = this.m33;
        }
    }
    
    static boolean luDecomposition(final double[] lllllllllllllIIllIlIIlllIIlIlIIl, final int[] lllllllllllllIIllIlIIlllIIIIlIIl) {
        final double[] lllllllllllllIIllIlIIlllIIlIIlll = new double[4];
        int lllllllllllllIIllIlIIlllIIlIIlII = 0;
        int lllllllllllllIIllIlIIlllIIlIIIll = 0;
        int lllllllllllllIIllIlIIlllIIlIIllI = 4;
        while (lllllllllllllIIllIlIIlllIIlIIllI-- != 0) {
            double lllllllllllllIIllIlIIlllIIlIIIlI = 0.0;
            int lllllllllllllIIllIlIIlllIIlIIlIl = 4;
            while (lllllllllllllIIllIlIIlllIIlIIlIl-- != 0) {
                double lllllllllllllIIllIlIIlllIIlIIIIl = lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIlIIlII++];
                lllllllllllllIIllIlIIlllIIlIIIIl = Math.abs(lllllllllllllIIllIlIIlllIIlIIIIl);
                if (lllllllllllllIIllIlIIlllIIlIIIIl > lllllllllllllIIllIlIIlllIIlIIIlI) {
                    lllllllllllllIIllIlIIlllIIlIIIlI = lllllllllllllIIllIlIIlllIIlIIIIl;
                }
            }
            if (lllllllllllllIIllIlIIlllIIlIIIlI == 0.0) {
                return false;
            }
            lllllllllllllIIllIlIIlllIIlIIlll[lllllllllllllIIllIlIIlllIIlIIIll++] = 1.0 / lllllllllllllIIllIlIIlllIIlIIIlI;
        }
        final int lllllllllllllIIllIlIIlllIIIlllll = 0;
        for (int lllllllllllllIIllIlIIlllIIlIIIII = 0; lllllllllllllIIllIlIIlllIIlIIIII < 4; ++lllllllllllllIIllIlIIlllIIlIIIII) {
            for (int lllllllllllllIIllIlIIlllIIIllllI = 0; lllllllllllllIIllIlIIlllIIIllllI < lllllllllllllIIllIlIIlllIIlIIIII; ++lllllllllllllIIllIlIIlllIIIllllI) {
                final int lllllllllllllIIllIlIIlllIIIllIIl = lllllllllllllIIllIlIIlllIIIlllll + 4 * lllllllllllllIIllIlIIlllIIIllllI + lllllllllllllIIllIlIIlllIIlIIIII;
                double lllllllllllllIIllIlIIlllIIIlIIII = lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIllIIl];
                int lllllllllllllIIllIlIIlllIIIlllII = lllllllllllllIIllIlIIlllIIIllllI;
                int lllllllllllllIIllIlIIlllIIIlIllI = lllllllllllllIIllIlIIlllIIIlllll + 4 * lllllllllllllIIllIlIIlllIIIllllI;
                int lllllllllllllIIllIlIIlllIIIlIIll = lllllllllllllIIllIlIIlllIIIlllll + lllllllllllllIIllIlIIlllIIlIIIII;
                while (lllllllllllllIIllIlIIlllIIIlllII-- != 0) {
                    lllllllllllllIIllIlIIlllIIIlIIII -= lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlIllI] * lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlIIll];
                    ++lllllllllllllIIllIlIIlllIIIlIllI;
                    lllllllllllllIIllIlIIlllIIIlIIll += 4;
                }
                lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIllIIl] = lllllllllllllIIllIlIIlllIIIlIIII;
            }
            double lllllllllllllIIllIlIIlllIIIIlllI = 0.0;
            int lllllllllllllIIllIlIIlllIIIlllIl = -1;
            for (int lllllllllllllIIllIlIIlllIIIllllI = lllllllllllllIIllIlIIlllIIlIIIII; lllllllllllllIIllIlIIlllIIIllllI < 4; ++lllllllllllllIIllIlIIlllIIIllllI) {
                final int lllllllllllllIIllIlIIlllIIIllIII = lllllllllllllIIllIlIIlllIIIlllll + 4 * lllllllllllllIIllIlIIlllIIIllllI + lllllllllllllIIllIlIIlllIIlIIIII;
                double lllllllllllllIIllIlIIlllIIIIllll = lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIllIII];
                int lllllllllllllIIllIlIIlllIIIllIll = lllllllllllllIIllIlIIlllIIlIIIII;
                int lllllllllllllIIllIlIIlllIIIlIlIl = lllllllllllllIIllIlIIlllIIIlllll + 4 * lllllllllllllIIllIlIIlllIIIllllI;
                int lllllllllllllIIllIlIIlllIIIlIIlI = lllllllllllllIIllIlIIlllIIIlllll + lllllllllllllIIllIlIIlllIIlIIIII;
                while (lllllllllllllIIllIlIIlllIIIllIll-- != 0) {
                    lllllllllllllIIllIlIIlllIIIIllll -= lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlIlIl] * lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlIIlI];
                    ++lllllllllllllIIllIlIIlllIIIlIlIl;
                    lllllllllllllIIllIlIIlllIIIlIIlI += 4;
                }
                lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIllIII] = lllllllllllllIIllIlIIlllIIIIllll;
                final double lllllllllllllIIllIlIIlllIIIIllIl;
                if ((lllllllllllllIIllIlIIlllIIIIllIl = lllllllllllllIIllIlIIlllIIlIIlll[lllllllllllllIIllIlIIlllIIIllllI] * Math.abs(lllllllllllllIIllIlIIlllIIIIllll)) >= lllllllllllllIIllIlIIlllIIIIlllI) {
                    lllllllllllllIIllIlIIlllIIIIlllI = lllllllllllllIIllIlIIlllIIIIllIl;
                    lllllllllllllIIllIlIIlllIIIlllIl = lllllllllllllIIllIlIIlllIIIllllI;
                }
            }
            if (lllllllllllllIIllIlIIlllIIIlllIl < 0) {
                throw new RuntimeException(VecMathI18N.getString("Matrix4d11"));
            }
            if (lllllllllllllIIllIlIIlllIIlIIIII != lllllllllllllIIllIlIIlllIIIlllIl) {
                int lllllllllllllIIllIlIIlllIIIllIlI = 4;
                int lllllllllllllIIllIlIIlllIIIlIlII = lllllllllllllIIllIlIIlllIIIlllll + 4 * lllllllllllllIIllIlIIlllIIIlllIl;
                int lllllllllllllIIllIlIIlllIIIlIIIl = lllllllllllllIIllIlIIlllIIIlllll + 4 * lllllllllllllIIllIlIIlllIIlIIIII;
                while (lllllllllllllIIllIlIIlllIIIllIlI-- != 0) {
                    final double lllllllllllllIIllIlIIlllIIIIllII = lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlIlII];
                    lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlIlII++] = lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlIIIl];
                    lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlIIIl++] = lllllllllllllIIllIlIIlllIIIIllII;
                }
                lllllllllllllIIllIlIIlllIIlIIlll[lllllllllllllIIllIlIIlllIIIlllIl] = lllllllllllllIIllIlIIlllIIlIIlll[lllllllllllllIIllIlIIlllIIlIIIII];
            }
            lllllllllllllIIllIlIIlllIIIIlIIl[lllllllllllllIIllIlIIlllIIlIIIII] = lllllllllllllIIllIlIIlllIIIlllIl;
            if (lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlllll + 4 * lllllllllllllIIllIlIIlllIIlIIIII + lllllllllllllIIllIlIIlllIIlIIIII] == 0.0) {
                return false;
            }
            if (lllllllllllllIIllIlIIlllIIlIIIII != 3) {
                final double lllllllllllllIIllIlIIlllIIIIlIll = 1.0 / lllllllllllllIIllIlIIlllIIlIlIIl[lllllllllllllIIllIlIIlllIIIlllll + 4 * lllllllllllllIIllIlIIlllIIlIIIII + lllllllllllllIIllIlIIlllIIlIIIII];
                int lllllllllllllIIllIlIIlllIIIlIlll = lllllllllllllIIllIlIIlllIIIlllll + 4 * (lllllllllllllIIllIlIIlllIIlIIIII + 1) + lllllllllllllIIllIlIIlllIIlIIIII;
                int lllllllllllllIIllIlIIlllIIIllllI = 3 - lllllllllllllIIllIlIIlllIIlIIIII;
                while (lllllllllllllIIllIlIIlllIIIllllI-- != 0) {
                    final int n = lllllllllllllIIllIlIIlllIIIlIlll;
                    lllllllllllllIIllIlIIlllIIlIlIIl[n] *= lllllllllllllIIllIlIIlllIIIIlIll;
                    lllllllllllllIIllIlIIlllIIIlIlll += 4;
                }
            }
        }
        return true;
    }
    
    public final double getM20() {
        return this.m20;
    }
    
    public final double getM31() {
        return this.m31;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.m00)).append(", ").append(this.m01).append(", ").append(this.m02).append(", ").append(this.m03).append("\n").append(this.m10).append(", ").append(this.m11).append(", ").append(this.m12).append(", ").append(this.m13).append("\n").append(this.m20).append(", ").append(this.m21).append(", ").append(this.m22).append(", ").append(this.m23).append("\n").append(this.m30).append(", ").append(this.m31).append(", ").append(this.m32).append(", ").append(this.m33).append("\n"));
    }
    
    public final void mul(final double lllllllllllllIIllIlIIllIIllIIlll, final Matrix4d lllllllllllllIIllIlIIllIIllIIIll) {
        this.m00 = lllllllllllllIIllIlIIllIIllIIIll.m00 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m01 = lllllllllllllIIllIlIIllIIllIIIll.m01 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m02 = lllllllllllllIIllIlIIllIIllIIIll.m02 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m03 = lllllllllllllIIllIlIIllIIllIIIll.m03 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m10 = lllllllllllllIIllIlIIllIIllIIIll.m10 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m11 = lllllllllllllIIllIlIIllIIllIIIll.m11 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m12 = lllllllllllllIIllIlIIllIIllIIIll.m12 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m13 = lllllllllllllIIllIlIIllIIllIIIll.m13 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m20 = lllllllllllllIIllIlIIllIIllIIIll.m20 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m21 = lllllllllllllIIllIlIIllIIllIIIll.m21 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m22 = lllllllllllllIIllIlIIllIIllIIIll.m22 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m23 = lllllllllllllIIllIlIIllIIllIIIll.m23 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m30 = lllllllllllllIIllIlIIllIIllIIIll.m30 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m31 = lllllllllllllIIllIlIIllIIllIIIll.m31 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m32 = lllllllllllllIIllIlIIllIIllIIIll.m32 * lllllllllllllIIllIlIIllIIllIIlll;
        this.m33 = lllllllllllllIIllIlIIllIIllIIIll.m33 * lllllllllllllIIllIlIIllIIllIIlll;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllIlIIlIIlllIIIlI) {
        try {
            final Matrix4d lllllllllllllIIllIlIIlIIlllIIIIl = (Matrix4d)lllllllllllllIIllIlIIlIIlllIIIlI;
            return this.m00 == lllllllllllllIIllIlIIlIIlllIIIIl.m00 && this.m01 == lllllllllllllIIllIlIIlIIlllIIIIl.m01 && this.m02 == lllllllllllllIIllIlIIlIIlllIIIIl.m02 && this.m03 == lllllllllllllIIllIlIIlIIlllIIIIl.m03 && this.m10 == lllllllllllllIIllIlIIlIIlllIIIIl.m10 && this.m11 == lllllllllllllIIllIlIIlIIlllIIIIl.m11 && this.m12 == lllllllllllllIIllIlIIlIIlllIIIIl.m12 && this.m13 == lllllllllllllIIllIlIIlIIlllIIIIl.m13 && this.m20 == lllllllllllllIIllIlIIlIIlllIIIIl.m20 && this.m21 == lllllllllllllIIllIlIIlIIlllIIIIl.m21 && this.m22 == lllllllllllllIIllIlIIlIIlllIIIIl.m22 && this.m23 == lllllllllllllIIllIlIIlIIlllIIIIl.m23 && this.m30 == lllllllllllllIIllIlIIlIIlllIIIIl.m30 && this.m31 == lllllllllllllIIllIlIIlIIlllIIIIl.m31 && this.m32 == lllllllllllllIIllIlIIlIIlllIIIIl.m32 && this.m33 == lllllllllllllIIllIlIIlIIlllIIIIl.m33;
        }
        catch (ClassCastException lllllllllllllIIllIlIIlIIlllIIIII) {
            return false;
        }
        catch (NullPointerException lllllllllllllIIllIlIIlIIllIlllll) {
            return false;
        }
    }
    
    public final double get(final Matrix3f lllllllllllllIIllIlIlIIIllIIlIIl, final Vector3d lllllllllllllIIllIlIlIIIllIIlIII) {
        final double[] lllllllllllllIIllIlIlIIIllIIIlll = new double[9];
        final double[] lllllllllllllIIllIlIlIIIllIIIllI = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIlIIIllIIIllI, lllllllllllllIIllIlIlIIIllIIIlll);
        lllllllllllllIIllIlIlIIIllIIlIIl.m00 = (float)lllllllllllllIIllIlIlIIIllIIIlll[0];
        lllllllllllllIIllIlIlIIIllIIlIIl.m01 = (float)lllllllllllllIIllIlIlIIIllIIIlll[1];
        lllllllllllllIIllIlIlIIIllIIlIIl.m02 = (float)lllllllllllllIIllIlIlIIIllIIIlll[2];
        lllllllllllllIIllIlIlIIIllIIlIIl.m10 = (float)lllllllllllllIIllIlIlIIIllIIIlll[3];
        lllllllllllllIIllIlIlIIIllIIlIIl.m11 = (float)lllllllllllllIIllIlIlIIIllIIIlll[4];
        lllllllllllllIIllIlIlIIIllIIlIIl.m12 = (float)lllllllllllllIIllIlIlIIIllIIIlll[5];
        lllllllllllllIIllIlIlIIIllIIlIIl.m20 = (float)lllllllllllllIIllIlIlIIIllIIIlll[6];
        lllllllllllllIIllIlIlIIIllIIlIIl.m21 = (float)lllllllllllllIIllIlIlIIIllIIIlll[7];
        lllllllllllllIIllIlIlIIIllIIlIIl.m22 = (float)lllllllllllllIIllIlIlIIIllIIIlll[8];
        lllllllllllllIIllIlIlIIIllIIlIII.x = this.m03;
        lllllllllllllIIllIlIlIIIllIIlIII.y = this.m13;
        lllllllllllllIIllIlIlIIIllIIlIII.z = this.m23;
        return Matrix3d.max3(lllllllllllllIIllIlIlIIIllIIIllI);
    }
    
    public boolean equals(final Matrix4d lllllllllllllIIllIlIIlIIlllIlIII) {
        try {
            return this.m00 == lllllllllllllIIllIlIIlIIlllIlIII.m00 && this.m01 == lllllllllllllIIllIlIIlIIlllIlIII.m01 && this.m02 == lllllllllllllIIllIlIIlIIlllIlIII.m02 && this.m03 == lllllllllllllIIllIlIIlIIlllIlIII.m03 && this.m10 == lllllllllllllIIllIlIIlIIlllIlIII.m10 && this.m11 == lllllllllllllIIllIlIIlIIlllIlIII.m11 && this.m12 == lllllllllllllIIllIlIIlIIlllIlIII.m12 && this.m13 == lllllllllllllIIllIlIIlIIlllIlIII.m13 && this.m20 == lllllllllllllIIllIlIIlIIlllIlIII.m20 && this.m21 == lllllllllllllIIllIlIIlIIlllIlIII.m21 && this.m22 == lllllllllllllIIllIlIIlIIlllIlIII.m22 && this.m23 == lllllllllllllIIllIlIIlIIlllIlIII.m23 && this.m30 == lllllllllllllIIllIlIIlIIlllIlIII.m30 && this.m31 == lllllllllllllIIllIlIIlIIlllIlIII.m31 && this.m32 == lllllllllllllIIllIlIIlIIlllIlIII.m32 && this.m33 == lllllllllllllIIllIlIIlIIlllIlIII.m33;
        }
        catch (NullPointerException lllllllllllllIIllIlIIlIIlllIlIlI) {
            return false;
        }
    }
    
    @Deprecated
    public boolean epsilonEquals(final Matrix4d lllllllllllllIIllIlIIlIIllIlIlII, final float lllllllllllllIIllIlIIlIIllIlIIll) {
        return this.epsilonEquals(lllllllllllllIIllIlIIlIIllIlIlII, (double)lllllllllllllIIllIlIIlIIllIlIIll);
    }
    
    public final void get(final Matrix3f lllllllllllllIIllIlIlIIlIIIlIIIl) {
        final double[] lllllllllllllIIllIlIlIIlIIIlIIII = new double[9];
        final double[] lllllllllllllIIllIlIlIIlIIIIllll = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIlIIlIIIIllll, lllllllllllllIIllIlIlIIlIIIlIIII);
        lllllllllllllIIllIlIlIIlIIIlIIIl.m00 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[0];
        lllllllllllllIIllIlIlIIlIIIlIIIl.m01 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[1];
        lllllllllllllIIllIlIlIIlIIIlIIIl.m02 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[2];
        lllllllllllllIIllIlIlIIlIIIlIIIl.m10 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[3];
        lllllllllllllIIllIlIlIIlIIIlIIIl.m11 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[4];
        lllllllllllllIIllIlIlIIlIIIlIIIl.m12 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[5];
        lllllllllllllIIllIlIlIIlIIIlIIIl.m20 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[6];
        lllllllllllllIIllIlIlIIlIIIlIIIl.m21 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[7];
        lllllllllllllIIllIlIlIIlIIIlIIIl.m22 = (float)lllllllllllllIIllIlIlIIlIIIlIIII[8];
    }
    
    public final double getScale() {
        final double[] lllllllllllllIIllIlIlIIIlIIIIllI = new double[9];
        final double[] lllllllllllllIIllIlIlIIIlIIIIlIl = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIlIIIlIIIIlIl, lllllllllllllIIllIlIlIIIlIIIIllI);
        return Matrix3d.max3(lllllllllllllIIllIlIlIIIlIIIIlIl);
    }
    
    public final void set(final Matrix3d lllllllllllllIIllIlIIllIlIlIIIlI, final Vector3d lllllllllllllIIllIlIIllIlIIlllIl, final double lllllllllllllIIllIlIIllIlIIlllII) {
        this.m00 = lllllllllllllIIllIlIIllIlIlIIIlI.m00 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m01 = lllllllllllllIIllIlIIllIlIlIIIlI.m01 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m02 = lllllllllllllIIllIlIIllIlIlIIIlI.m02 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m03 = lllllllllllllIIllIlIIllIlIIlllIl.x;
        this.m10 = lllllllllllllIIllIlIIllIlIlIIIlI.m10 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m11 = lllllllllllllIIllIlIIllIlIlIIIlI.m11 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m12 = lllllllllllllIIllIlIIllIlIlIIIlI.m12 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m13 = lllllllllllllIIllIlIIllIlIIlllIl.y;
        this.m20 = lllllllllllllIIllIlIIllIlIlIIIlI.m20 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m21 = lllllllllllllIIllIlIIllIlIlIIIlI.m21 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m22 = lllllllllllllIIllIlIIllIlIlIIIlI.m22 * lllllllllllllIIllIlIIllIlIIlllII;
        this.m23 = lllllllllllllIIllIlIIllIlIIlllIl.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final double determinant() {
        double lllllllllllllIIllIlIIllIllIlIlII = this.m00 * (this.m11 * this.m22 * this.m33 + this.m12 * this.m23 * this.m31 + this.m13 * this.m21 * this.m32 - this.m13 * this.m22 * this.m31 - this.m11 * this.m23 * this.m32 - this.m12 * this.m21 * this.m33);
        lllllllllllllIIllIlIIllIllIlIlII -= this.m01 * (this.m10 * this.m22 * this.m33 + this.m12 * this.m23 * this.m30 + this.m13 * this.m20 * this.m32 - this.m13 * this.m22 * this.m30 - this.m10 * this.m23 * this.m32 - this.m12 * this.m20 * this.m33);
        lllllllllllllIIllIlIIllIllIlIlII += this.m02 * (this.m10 * this.m21 * this.m33 + this.m11 * this.m23 * this.m30 + this.m13 * this.m20 * this.m31 - this.m13 * this.m21 * this.m30 - this.m10 * this.m23 * this.m31 - this.m11 * this.m20 * this.m33);
        lllllllllllllIIllIlIIllIllIlIlII -= this.m03 * (this.m10 * this.m21 * this.m32 + this.m11 * this.m22 * this.m30 + this.m12 * this.m20 * this.m31 - this.m12 * this.m21 * this.m30 - this.m10 * this.m22 * this.m31 - this.m11 * this.m20 * this.m32);
        return lllllllllllllIIllIlIIllIllIlIlII;
    }
    
    public final void setRow(final int lllllllllllllIIllIlIlIIIIlIlIIII, final Vector4d lllllllllllllIIllIlIlIIIIlIIllll) {
        switch (lllllllllllllIIllIlIlIIIIlIlIIII) {
            case 0: {
                this.m00 = lllllllllllllIIllIlIlIIIIlIIllll.x;
                this.m01 = lllllllllllllIIllIlIlIIIIlIIllll.y;
                this.m02 = lllllllllllllIIllIlIlIIIIlIIllll.z;
                this.m03 = lllllllllllllIIllIlIlIIIIlIIllll.w;
                break;
            }
            case 1: {
                this.m10 = lllllllllllllIIllIlIlIIIIlIIllll.x;
                this.m11 = lllllllllllllIIllIlIlIIIIlIIllll.y;
                this.m12 = lllllllllllllIIllIlIlIIIIlIIllll.z;
                this.m13 = lllllllllllllIIllIlIlIIIIlIIllll.w;
                break;
            }
            case 2: {
                this.m20 = lllllllllllllIIllIlIlIIIIlIIllll.x;
                this.m21 = lllllllllllllIIllIlIlIIIIlIIllll.y;
                this.m22 = lllllllllllllIIllIlIlIIIIlIIllll.z;
                this.m23 = lllllllllllllIIllIlIlIIIIlIIllll.w;
                break;
            }
            case 3: {
                this.m30 = lllllllllllllIIllIlIlIIIIlIIllll.x;
                this.m31 = lllllllllllllIIllIlIlIIIIlIIllll.y;
                this.m32 = lllllllllllllIIllIlIlIIIIlIIllll.z;
                this.m33 = lllllllllllllIIllIlIlIIIIlIIllll.w;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
            }
        }
    }
    
    public final void mulTransposeBoth(final Matrix4d lllllllllllllIIllIlIIlIllIIIIllI, final Matrix4d lllllllllllllIIllIlIIlIllIIIIlIl) {
        if (this != lllllllllllllIIllIlIIlIllIIIIllI && this != lllllllllllllIIllIlIIlIllIIIIlIl) {
            this.m00 = lllllllllllllIIllIlIIlIllIIIIllI.m00 * lllllllllllllIIllIlIIlIllIIIIlIl.m00 + lllllllllllllIIllIlIIlIllIIIIllI.m10 * lllllllllllllIIllIlIIlIllIIIIlIl.m01 + lllllllllllllIIllIlIIlIllIIIIllI.m20 * lllllllllllllIIllIlIIlIllIIIIlIl.m02 + lllllllllllllIIllIlIIlIllIIIIllI.m30 * lllllllllllllIIllIlIIlIllIIIIlIl.m03;
            this.m01 = lllllllllllllIIllIlIIlIllIIIIllI.m00 * lllllllllllllIIllIlIIlIllIIIIlIl.m10 + lllllllllllllIIllIlIIlIllIIIIllI.m10 * lllllllllllllIIllIlIIlIllIIIIlIl.m11 + lllllllllllllIIllIlIIlIllIIIIllI.m20 * lllllllllllllIIllIlIIlIllIIIIlIl.m12 + lllllllllllllIIllIlIIlIllIIIIllI.m30 * lllllllllllllIIllIlIIlIllIIIIlIl.m13;
            this.m02 = lllllllllllllIIllIlIIlIllIIIIllI.m00 * lllllllllllllIIllIlIIlIllIIIIlIl.m20 + lllllllllllllIIllIlIIlIllIIIIllI.m10 * lllllllllllllIIllIlIIlIllIIIIlIl.m21 + lllllllllllllIIllIlIIlIllIIIIllI.m20 * lllllllllllllIIllIlIIlIllIIIIlIl.m22 + lllllllllllllIIllIlIIlIllIIIIllI.m30 * lllllllllllllIIllIlIIlIllIIIIlIl.m23;
            this.m03 = lllllllllllllIIllIlIIlIllIIIIllI.m00 * lllllllllllllIIllIlIIlIllIIIIlIl.m30 + lllllllllllllIIllIlIIlIllIIIIllI.m10 * lllllllllllllIIllIlIIlIllIIIIlIl.m31 + lllllllllllllIIllIlIIlIllIIIIllI.m20 * lllllllllllllIIllIlIIlIllIIIIlIl.m32 + lllllllllllllIIllIlIIlIllIIIIllI.m30 * lllllllllllllIIllIlIIlIllIIIIlIl.m33;
            this.m10 = lllllllllllllIIllIlIIlIllIIIIllI.m01 * lllllllllllllIIllIlIIlIllIIIIlIl.m00 + lllllllllllllIIllIlIIlIllIIIIllI.m11 * lllllllllllllIIllIlIIlIllIIIIlIl.m01 + lllllllllllllIIllIlIIlIllIIIIllI.m21 * lllllllllllllIIllIlIIlIllIIIIlIl.m02 + lllllllllllllIIllIlIIlIllIIIIllI.m31 * lllllllllllllIIllIlIIlIllIIIIlIl.m03;
            this.m11 = lllllllllllllIIllIlIIlIllIIIIllI.m01 * lllllllllllllIIllIlIIlIllIIIIlIl.m10 + lllllllllllllIIllIlIIlIllIIIIllI.m11 * lllllllllllllIIllIlIIlIllIIIIlIl.m11 + lllllllllllllIIllIlIIlIllIIIIllI.m21 * lllllllllllllIIllIlIIlIllIIIIlIl.m12 + lllllllllllllIIllIlIIlIllIIIIllI.m31 * lllllllllllllIIllIlIIlIllIIIIlIl.m13;
            this.m12 = lllllllllllllIIllIlIIlIllIIIIllI.m01 * lllllllllllllIIllIlIIlIllIIIIlIl.m20 + lllllllllllllIIllIlIIlIllIIIIllI.m11 * lllllllllllllIIllIlIIlIllIIIIlIl.m21 + lllllllllllllIIllIlIIlIllIIIIllI.m21 * lllllllllllllIIllIlIIlIllIIIIlIl.m22 + lllllllllllllIIllIlIIlIllIIIIllI.m31 * lllllllllllllIIllIlIIlIllIIIIlIl.m23;
            this.m13 = lllllllllllllIIllIlIIlIllIIIIllI.m01 * lllllllllllllIIllIlIIlIllIIIIlIl.m30 + lllllllllllllIIllIlIIlIllIIIIllI.m11 * lllllllllllllIIllIlIIlIllIIIIlIl.m31 + lllllllllllllIIllIlIIlIllIIIIllI.m21 * lllllllllllllIIllIlIIlIllIIIIlIl.m32 + lllllllllllllIIllIlIIlIllIIIIllI.m31 * lllllllllllllIIllIlIIlIllIIIIlIl.m33;
            this.m20 = lllllllllllllIIllIlIIlIllIIIIllI.m02 * lllllllllllllIIllIlIIlIllIIIIlIl.m00 + lllllllllllllIIllIlIIlIllIIIIllI.m12 * lllllllllllllIIllIlIIlIllIIIIlIl.m01 + lllllllllllllIIllIlIIlIllIIIIllI.m22 * lllllllllllllIIllIlIIlIllIIIIlIl.m02 + lllllllllllllIIllIlIIlIllIIIIllI.m32 * lllllllllllllIIllIlIIlIllIIIIlIl.m03;
            this.m21 = lllllllllllllIIllIlIIlIllIIIIllI.m02 * lllllllllllllIIllIlIIlIllIIIIlIl.m10 + lllllllllllllIIllIlIIlIllIIIIllI.m12 * lllllllllllllIIllIlIIlIllIIIIlIl.m11 + lllllllllllllIIllIlIIlIllIIIIllI.m22 * lllllllllllllIIllIlIIlIllIIIIlIl.m12 + lllllllllllllIIllIlIIlIllIIIIllI.m32 * lllllllllllllIIllIlIIlIllIIIIlIl.m13;
            this.m22 = lllllllllllllIIllIlIIlIllIIIIllI.m02 * lllllllllllllIIllIlIIlIllIIIIlIl.m20 + lllllllllllllIIllIlIIlIllIIIIllI.m12 * lllllllllllllIIllIlIIlIllIIIIlIl.m21 + lllllllllllllIIllIlIIlIllIIIIllI.m22 * lllllllllllllIIllIlIIlIllIIIIlIl.m22 + lllllllllllllIIllIlIIlIllIIIIllI.m32 * lllllllllllllIIllIlIIlIllIIIIlIl.m23;
            this.m23 = lllllllllllllIIllIlIIlIllIIIIllI.m02 * lllllllllllllIIllIlIIlIllIIIIlIl.m30 + lllllllllllllIIllIlIIlIllIIIIllI.m12 * lllllllllllllIIllIlIIlIllIIIIlIl.m31 + lllllllllllllIIllIlIIlIllIIIIllI.m22 * lllllllllllllIIllIlIIlIllIIIIlIl.m32 + lllllllllllllIIllIlIIlIllIIIIllI.m32 * lllllllllllllIIllIlIIlIllIIIIlIl.m33;
            this.m30 = lllllllllllllIIllIlIIlIllIIIIllI.m03 * lllllllllllllIIllIlIIlIllIIIIlIl.m00 + lllllllllllllIIllIlIIlIllIIIIllI.m13 * lllllllllllllIIllIlIIlIllIIIIlIl.m01 + lllllllllllllIIllIlIIlIllIIIIllI.m23 * lllllllllllllIIllIlIIlIllIIIIlIl.m02 + lllllllllllllIIllIlIIlIllIIIIllI.m33 * lllllllllllllIIllIlIIlIllIIIIlIl.m03;
            this.m31 = lllllllllllllIIllIlIIlIllIIIIllI.m03 * lllllllllllllIIllIlIIlIllIIIIlIl.m10 + lllllllllllllIIllIlIIlIllIIIIllI.m13 * lllllllllllllIIllIlIIlIllIIIIlIl.m11 + lllllllllllllIIllIlIIlIllIIIIllI.m23 * lllllllllllllIIllIlIIlIllIIIIlIl.m12 + lllllllllllllIIllIlIIlIllIIIIllI.m33 * lllllllllllllIIllIlIIlIllIIIIlIl.m13;
            this.m32 = lllllllllllllIIllIlIIlIllIIIIllI.m03 * lllllllllllllIIllIlIIlIllIIIIlIl.m20 + lllllllllllllIIllIlIIlIllIIIIllI.m13 * lllllllllllllIIllIlIIlIllIIIIlIl.m21 + lllllllllllllIIllIlIIlIllIIIIllI.m23 * lllllllllllllIIllIlIIlIllIIIIlIl.m22 + lllllllllllllIIllIlIIlIllIIIIllI.m33 * lllllllllllllIIllIlIIlIllIIIIlIl.m23;
            this.m33 = lllllllllllllIIllIlIIlIllIIIIllI.m03 * lllllllllllllIIllIlIIlIllIIIIlIl.m30 + lllllllllllllIIllIlIIlIllIIIIllI.m13 * lllllllllllllIIllIlIIlIllIIIIlIl.m31 + lllllllllllllIIllIlIIlIllIIIIllI.m23 * lllllllllllllIIllIlIIlIllIIIIlIl.m32 + lllllllllllllIIllIlIIlIllIIIIllI.m33 * lllllllllllllIIllIlIIlIllIIIIlIl.m33;
        }
        else {
            final double lllllllllllllIIllIlIIlIllIIIIlII = lllllllllllllIIllIlIIlIllIIIIllI.m00 * lllllllllllllIIllIlIIlIllIIIIlIl.m00 + lllllllllllllIIllIlIIlIllIIIIllI.m10 * lllllllllllllIIllIlIIlIllIIIIlIl.m01 + lllllllllllllIIllIlIIlIllIIIIllI.m20 * lllllllllllllIIllIlIIlIllIIIIlIl.m02 + lllllllllllllIIllIlIIlIllIIIIllI.m30 * lllllllllllllIIllIlIIlIllIIIIlIl.m03;
            final double lllllllllllllIIllIlIIlIllIIIIIll = lllllllllllllIIllIlIIlIllIIIIllI.m00 * lllllllllllllIIllIlIIlIllIIIIlIl.m10 + lllllllllllllIIllIlIIlIllIIIIllI.m10 * lllllllllllllIIllIlIIlIllIIIIlIl.m11 + lllllllllllllIIllIlIIlIllIIIIllI.m20 * lllllllllllllIIllIlIIlIllIIIIlIl.m12 + lllllllllllllIIllIlIIlIllIIIIllI.m30 * lllllllllllllIIllIlIIlIllIIIIlIl.m13;
            final double lllllllllllllIIllIlIIlIllIIIIIlI = lllllllllllllIIllIlIIlIllIIIIllI.m00 * lllllllllllllIIllIlIIlIllIIIIlIl.m20 + lllllllllllllIIllIlIIlIllIIIIllI.m10 * lllllllllllllIIllIlIIlIllIIIIlIl.m21 + lllllllllllllIIllIlIIlIllIIIIllI.m20 * lllllllllllllIIllIlIIlIllIIIIlIl.m22 + lllllllllllllIIllIlIIlIllIIIIllI.m30 * lllllllllllllIIllIlIIlIllIIIIlIl.m23;
            final double lllllllllllllIIllIlIIlIllIIIIIIl = lllllllllllllIIllIlIIlIllIIIIllI.m00 * lllllllllllllIIllIlIIlIllIIIIlIl.m30 + lllllllllllllIIllIlIIlIllIIIIllI.m10 * lllllllllllllIIllIlIIlIllIIIIlIl.m31 + lllllllllllllIIllIlIIlIllIIIIllI.m20 * lllllllllllllIIllIlIIlIllIIIIlIl.m32 + lllllllllllllIIllIlIIlIllIIIIllI.m30 * lllllllllllllIIllIlIIlIllIIIIlIl.m33;
            final double lllllllllllllIIllIlIIlIllIIIIIII = lllllllllllllIIllIlIIlIllIIIIllI.m01 * lllllllllllllIIllIlIIlIllIIIIlIl.m00 + lllllllllllllIIllIlIIlIllIIIIllI.m11 * lllllllllllllIIllIlIIlIllIIIIlIl.m01 + lllllllllllllIIllIlIIlIllIIIIllI.m21 * lllllllllllllIIllIlIIlIllIIIIlIl.m02 + lllllllllllllIIllIlIIlIllIIIIllI.m31 * lllllllllllllIIllIlIIlIllIIIIlIl.m03;
            final double lllllllllllllIIllIlIIlIlIlllllll = lllllllllllllIIllIlIIlIllIIIIllI.m01 * lllllllllllllIIllIlIIlIllIIIIlIl.m10 + lllllllllllllIIllIlIIlIllIIIIllI.m11 * lllllllllllllIIllIlIIlIllIIIIlIl.m11 + lllllllllllllIIllIlIIlIllIIIIllI.m21 * lllllllllllllIIllIlIIlIllIIIIlIl.m12 + lllllllllllllIIllIlIIlIllIIIIllI.m31 * lllllllllllllIIllIlIIlIllIIIIlIl.m13;
            final double lllllllllllllIIllIlIIlIlIllllllI = lllllllllllllIIllIlIIlIllIIIIllI.m01 * lllllllllllllIIllIlIIlIllIIIIlIl.m20 + lllllllllllllIIllIlIIlIllIIIIllI.m11 * lllllllllllllIIllIlIIlIllIIIIlIl.m21 + lllllllllllllIIllIlIIlIllIIIIllI.m21 * lllllllllllllIIllIlIIlIllIIIIlIl.m22 + lllllllllllllIIllIlIIlIllIIIIllI.m31 * lllllllllllllIIllIlIIlIllIIIIlIl.m23;
            final double lllllllllllllIIllIlIIlIlIlllllIl = lllllllllllllIIllIlIIlIllIIIIllI.m01 * lllllllllllllIIllIlIIlIllIIIIlIl.m30 + lllllllllllllIIllIlIIlIllIIIIllI.m11 * lllllllllllllIIllIlIIlIllIIIIlIl.m31 + lllllllllllllIIllIlIIlIllIIIIllI.m21 * lllllllllllllIIllIlIIlIllIIIIlIl.m32 + lllllllllllllIIllIlIIlIllIIIIllI.m31 * lllllllllllllIIllIlIIlIllIIIIlIl.m33;
            final double lllllllllllllIIllIlIIlIlIlllllII = lllllllllllllIIllIlIIlIllIIIIllI.m02 * lllllllllllllIIllIlIIlIllIIIIlIl.m00 + lllllllllllllIIllIlIIlIllIIIIllI.m12 * lllllllllllllIIllIlIIlIllIIIIlIl.m01 + lllllllllllllIIllIlIIlIllIIIIllI.m22 * lllllllllllllIIllIlIIlIllIIIIlIl.m02 + lllllllllllllIIllIlIIlIllIIIIllI.m32 * lllllllllllllIIllIlIIlIllIIIIlIl.m03;
            final double lllllllllllllIIllIlIIlIlIllllIll = lllllllllllllIIllIlIIlIllIIIIllI.m02 * lllllllllllllIIllIlIIlIllIIIIlIl.m10 + lllllllllllllIIllIlIIlIllIIIIllI.m12 * lllllllllllllIIllIlIIlIllIIIIlIl.m11 + lllllllllllllIIllIlIIlIllIIIIllI.m22 * lllllllllllllIIllIlIIlIllIIIIlIl.m12 + lllllllllllllIIllIlIIlIllIIIIllI.m32 * lllllllllllllIIllIlIIlIllIIIIlIl.m13;
            final double lllllllllllllIIllIlIIlIlIllllIlI = lllllllllllllIIllIlIIlIllIIIIllI.m02 * lllllllllllllIIllIlIIlIllIIIIlIl.m20 + lllllllllllllIIllIlIIlIllIIIIllI.m12 * lllllllllllllIIllIlIIlIllIIIIlIl.m21 + lllllllllllllIIllIlIIlIllIIIIllI.m22 * lllllllllllllIIllIlIIlIllIIIIlIl.m22 + lllllllllllllIIllIlIIlIllIIIIllI.m32 * lllllllllllllIIllIlIIlIllIIIIlIl.m23;
            final double lllllllllllllIIllIlIIlIlIllllIIl = lllllllllllllIIllIlIIlIllIIIIllI.m02 * lllllllllllllIIllIlIIlIllIIIIlIl.m30 + lllllllllllllIIllIlIIlIllIIIIllI.m12 * lllllllllllllIIllIlIIlIllIIIIlIl.m31 + lllllllllllllIIllIlIIlIllIIIIllI.m22 * lllllllllllllIIllIlIIlIllIIIIlIl.m32 + lllllllllllllIIllIlIIlIllIIIIllI.m32 * lllllllllllllIIllIlIIlIllIIIIlIl.m33;
            final double lllllllllllllIIllIlIIlIlIllllIII = lllllllllllllIIllIlIIlIllIIIIllI.m03 * lllllllllllllIIllIlIIlIllIIIIlIl.m00 + lllllllllllllIIllIlIIlIllIIIIllI.m13 * lllllllllllllIIllIlIIlIllIIIIlIl.m01 + lllllllllllllIIllIlIIlIllIIIIllI.m23 * lllllllllllllIIllIlIIlIllIIIIlIl.m02 + lllllllllllllIIllIlIIlIllIIIIllI.m33 * lllllllllllllIIllIlIIlIllIIIIlIl.m03;
            final double lllllllllllllIIllIlIIlIlIlllIlll = lllllllllllllIIllIlIIlIllIIIIllI.m03 * lllllllllllllIIllIlIIlIllIIIIlIl.m10 + lllllllllllllIIllIlIIlIllIIIIllI.m13 * lllllllllllllIIllIlIIlIllIIIIlIl.m11 + lllllllllllllIIllIlIIlIllIIIIllI.m23 * lllllllllllllIIllIlIIlIllIIIIlIl.m12 + lllllllllllllIIllIlIIlIllIIIIllI.m33 * lllllllllllllIIllIlIIlIllIIIIlIl.m13;
            final double lllllllllllllIIllIlIIlIlIlllIllI = lllllllllllllIIllIlIIlIllIIIIllI.m03 * lllllllllllllIIllIlIIlIllIIIIlIl.m20 + lllllllllllllIIllIlIIlIllIIIIllI.m13 * lllllllllllllIIllIlIIlIllIIIIlIl.m21 + lllllllllllllIIllIlIIlIllIIIIllI.m23 * lllllllllllllIIllIlIIlIllIIIIlIl.m22 + lllllllllllllIIllIlIIlIllIIIIllI.m33 * lllllllllllllIIllIlIIlIllIIIIlIl.m23;
            final double lllllllllllllIIllIlIIlIlIlllIlIl = lllllllllllllIIllIlIIlIllIIIIllI.m03 * lllllllllllllIIllIlIIlIllIIIIlIl.m30 + lllllllllllllIIllIlIIlIllIIIIllI.m13 * lllllllllllllIIllIlIIlIllIIIIlIl.m31 + lllllllllllllIIllIlIIlIllIIIIllI.m23 * lllllllllllllIIllIlIIlIllIIIIlIl.m32 + lllllllllllllIIllIlIIlIllIIIIllI.m33 * lllllllllllllIIllIlIIlIllIIIIlIl.m33;
            this.m00 = lllllllllllllIIllIlIIlIllIIIIlII;
            this.m01 = lllllllllllllIIllIlIIlIllIIIIIll;
            this.m02 = lllllllllllllIIllIlIIlIllIIIIIlI;
            this.m03 = lllllllllllllIIllIlIIlIllIIIIIIl;
            this.m10 = lllllllllllllIIllIlIIlIllIIIIIII;
            this.m11 = lllllllllllllIIllIlIIlIlIlllllll;
            this.m12 = lllllllllllllIIllIlIIlIlIllllllI;
            this.m13 = lllllllllllllIIllIlIIlIlIlllllIl;
            this.m20 = lllllllllllllIIllIlIIlIlIlllllII;
            this.m21 = lllllllllllllIIllIlIIlIlIllllIll;
            this.m22 = lllllllllllllIIllIlIIlIlIllllIlI;
            this.m23 = lllllllllllllIIllIlIIlIlIllllIIl;
            this.m30 = lllllllllllllIIllIlIIlIlIllllIII;
            this.m31 = lllllllllllllIIllIlIIlIlIlllIlll;
            this.m32 = lllllllllllllIIllIlIIlIlIlllIllI;
            this.m33 = lllllllllllllIIllIlIIlIlIlllIlIl;
        }
    }
    
    public final double getM23() {
        return this.m23;
    }
    
    public final void set(final Quat4d lllllllllllllIIllIlIIlllIllllIIl, final Vector3d lllllllllllllIIllIlIIlllIlllllII, final double lllllllllllllIIllIlIIlllIlllIlll) {
        this.m00 = lllllllllllllIIllIlIIlllIlllIlll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllllIIl.y * lllllllllllllIIllIlIIlllIllllIIl.y - 2.0 * lllllllllllllIIllIlIIlllIllllIIl.z * lllllllllllllIIllIlIIlllIllllIIl.z);
        this.m10 = lllllllllllllIIllIlIIlllIlllIlll * (2.0 * (lllllllllllllIIllIlIIlllIllllIIl.x * lllllllllllllIIllIlIIlllIllllIIl.y + lllllllllllllIIllIlIIlllIllllIIl.w * lllllllllllllIIllIlIIlllIllllIIl.z));
        this.m20 = lllllllllllllIIllIlIIlllIlllIlll * (2.0 * (lllllllllllllIIllIlIIlllIllllIIl.x * lllllllllllllIIllIlIIlllIllllIIl.z - lllllllllllllIIllIlIIlllIllllIIl.w * lllllllllllllIIllIlIIlllIllllIIl.y));
        this.m01 = lllllllllllllIIllIlIIlllIlllIlll * (2.0 * (lllllllllllllIIllIlIIlllIllllIIl.x * lllllllllllllIIllIlIIlllIllllIIl.y - lllllllllllllIIllIlIIlllIllllIIl.w * lllllllllllllIIllIlIIlllIllllIIl.z));
        this.m11 = lllllllllllllIIllIlIIlllIlllIlll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllllIIl.x * lllllllllllllIIllIlIIlllIllllIIl.x - 2.0 * lllllllllllllIIllIlIIlllIllllIIl.z * lllllllllllllIIllIlIIlllIllllIIl.z);
        this.m21 = lllllllllllllIIllIlIIlllIlllIlll * (2.0 * (lllllllllllllIIllIlIIlllIllllIIl.y * lllllllllllllIIllIlIIlllIllllIIl.z + lllllllllllllIIllIlIIlllIllllIIl.w * lllllllllllllIIllIlIIlllIllllIIl.x));
        this.m02 = lllllllllllllIIllIlIIlllIlllIlll * (2.0 * (lllllllllllllIIllIlIIlllIllllIIl.x * lllllllllllllIIllIlIIlllIllllIIl.z + lllllllllllllIIllIlIIlllIllllIIl.w * lllllllllllllIIllIlIIlllIllllIIl.y));
        this.m12 = lllllllllllllIIllIlIIlllIlllIlll * (2.0 * (lllllllllllllIIllIlIIlllIllllIIl.y * lllllllllllllIIllIlIIlllIllllIIl.z - lllllllllllllIIllIlIIlllIllllIIl.w * lllllllllllllIIllIlIIlllIllllIIl.x));
        this.m22 = lllllllllllllIIllIlIIlllIlllIlll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllllIIl.x * lllllllllllllIIllIlIIlllIllllIIl.x - 2.0 * lllllllllllllIIllIlIIlllIllllIIl.y * lllllllllllllIIllIlIIlllIllllIIl.y);
        this.m03 = lllllllllllllIIllIlIIlllIlllllII.x;
        this.m13 = lllllllllllllIIllIlIIlllIlllllII.y;
        this.m23 = lllllllllllllIIllIlIIlllIlllllII.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final double getM32() {
        return this.m32;
    }
    
    public final void get(final Quat4f lllllllllllllIIllIlIlIIIlIllIlII) {
        final double[] lllllllllllllIIllIlIlIIIlIllIIll = new double[9];
        final double[] lllllllllllllIIllIlIlIIIlIllIIlI = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIlIIIlIllIIlI, lllllllllllllIIllIlIlIIIlIllIIll);
        double lllllllllllllIIllIlIlIIIlIllIIIl = 0.25 * (1.0 + lllllllllllllIIllIlIlIIIlIllIIll[0] + lllllllllllllIIllIlIlIIIlIllIIll[4] + lllllllllllllIIllIlIlIIIlIllIIll[8]);
        if (((lllllllllllllIIllIlIlIIIlIllIIIl < 0.0) ? (-lllllllllllllIIllIlIlIIIlIllIIIl) : lllllllllllllIIllIlIlIIIlIllIIIl) >= 1.0E-30) {
            lllllllllllllIIllIlIlIIIlIllIlII.w = (float)Math.sqrt(lllllllllllllIIllIlIlIIIlIllIIIl);
            lllllllllllllIIllIlIlIIIlIllIIIl = 0.25 / lllllllllllllIIllIlIlIIIlIllIlII.w;
            lllllllllllllIIllIlIlIIIlIllIlII.x = (float)((lllllllllllllIIllIlIlIIIlIllIIll[7] - lllllllllllllIIllIlIlIIIlIllIIll[5]) * lllllllllllllIIllIlIlIIIlIllIIIl);
            lllllllllllllIIllIlIlIIIlIllIlII.y = (float)((lllllllllllllIIllIlIlIIIlIllIIll[2] - lllllllllllllIIllIlIlIIIlIllIIll[6]) * lllllllllllllIIllIlIlIIIlIllIIIl);
            lllllllllllllIIllIlIlIIIlIllIlII.z = (float)((lllllllllllllIIllIlIlIIIlIllIIll[3] - lllllllllllllIIllIlIlIIIlIllIIll[1]) * lllllllllllllIIllIlIlIIIlIllIIIl);
            return;
        }
        lllllllllllllIIllIlIlIIIlIllIlII.w = 0.0f;
        lllllllllllllIIllIlIlIIIlIllIIIl = -0.5 * (lllllllllllllIIllIlIlIIIlIllIIll[4] + lllllllllllllIIllIlIlIIIlIllIIll[8]);
        if (((lllllllllllllIIllIlIlIIIlIllIIIl < 0.0) ? (-lllllllllllllIIllIlIlIIIlIllIIIl) : lllllllllllllIIllIlIlIIIlIllIIIl) >= 1.0E-30) {
            lllllllllllllIIllIlIlIIIlIllIlII.x = (float)Math.sqrt(lllllllllllllIIllIlIlIIIlIllIIIl);
            lllllllllllllIIllIlIlIIIlIllIIIl = 0.5 / lllllllllllllIIllIlIlIIIlIllIlII.x;
            lllllllllllllIIllIlIlIIIlIllIlII.y = (float)(lllllllllllllIIllIlIlIIIlIllIIll[3] * lllllllllllllIIllIlIlIIIlIllIIIl);
            lllllllllllllIIllIlIlIIIlIllIlII.z = (float)(lllllllllllllIIllIlIlIIIlIllIIll[6] * lllllllllllllIIllIlIlIIIlIllIIIl);
            return;
        }
        lllllllllllllIIllIlIlIIIlIllIlII.x = 0.0f;
        lllllllllllllIIllIlIlIIIlIllIIIl = 0.5 * (1.0 - lllllllllllllIIllIlIlIIIlIllIIll[8]);
        if (((lllllllllllllIIllIlIlIIIlIllIIIl < 0.0) ? (-lllllllllllllIIllIlIlIIIlIllIIIl) : lllllllllllllIIllIlIlIIIlIllIIIl) >= 1.0E-30) {
            lllllllllllllIIllIlIlIIIlIllIlII.y = (float)Math.sqrt(lllllllllllllIIllIlIlIIIlIllIIIl);
            lllllllllllllIIllIlIlIIIlIllIlII.z = (float)(lllllllllllllIIllIlIlIIIlIllIIll[7] / (2.0 * lllllllllllllIIllIlIlIIIlIllIlII.y));
            return;
        }
        lllllllllllllIIllIlIlIIIlIllIlII.y = 0.0f;
        lllllllllllllIIllIlIlIIIlIllIlII.z = 1.0f;
    }
    
    public final void transform(final Tuple4f lllllllllllllIIllIlIIlIIlIIIIlll) {
        final float lllllllllllllIIllIlIIlIIlIIIIllI = (float)(this.m00 * lllllllllllllIIllIlIIlIIlIIIIlll.x + this.m01 * lllllllllllllIIllIlIIlIIlIIIIlll.y + this.m02 * lllllllllllllIIllIlIIlIIlIIIIlll.z + this.m03 * lllllllllllllIIllIlIIlIIlIIIIlll.w);
        final float lllllllllllllIIllIlIIlIIlIIIIlIl = (float)(this.m10 * lllllllllllllIIllIlIIlIIlIIIIlll.x + this.m11 * lllllllllllllIIllIlIIlIIlIIIIlll.y + this.m12 * lllllllllllllIIllIlIIlIIlIIIIlll.z + this.m13 * lllllllllllllIIllIlIIlIIlIIIIlll.w);
        final float lllllllllllllIIllIlIIlIIlIIIIlII = (float)(this.m20 * lllllllllllllIIllIlIIlIIlIIIIlll.x + this.m21 * lllllllllllllIIllIlIIlIIlIIIIlll.y + this.m22 * lllllllllllllIIllIlIIlIIlIIIIlll.z + this.m23 * lllllllllllllIIllIlIIlIIlIIIIlll.w);
        lllllllllllllIIllIlIIlIIlIIIIlll.w = (float)(this.m30 * lllllllllllllIIllIlIIlIIlIIIIlll.x + this.m31 * lllllllllllllIIllIlIIlIIlIIIIlll.y + this.m32 * lllllllllllllIIllIlIIlIIlIIIIlll.z + this.m33 * lllllllllllllIIllIlIIlIIlIIIIlll.w);
        lllllllllllllIIllIlIIlIIlIIIIlll.x = lllllllllllllIIllIlIIlIIlIIIIllI;
        lllllllllllllIIllIlIIlIIlIIIIlll.y = lllllllllllllIIllIlIIlIIlIIIIlIl;
        lllllllllllllIIllIlIIlIIlIIIIlll.z = lllllllllllllIIllIlIIlIIlIIIIlII;
    }
    
    public final double getM02() {
        return this.m02;
    }
    
    public final void getRow(final int lllllllllllllIIllIlIlIIlIlIIlIII, final Vector4d lllllllllllllIIllIlIlIIlIlIIIlII) {
        if (lllllllllllllIIllIlIlIIlIlIIlIII == 0) {
            lllllllllllllIIllIlIlIIlIlIIIlII.x = this.m00;
            lllllllllllllIIllIlIlIIlIlIIIlII.y = this.m01;
            lllllllllllllIIllIlIlIIlIlIIIlII.z = this.m02;
            lllllllllllllIIllIlIlIIlIlIIIlII.w = this.m03;
        }
        else if (lllllllllllllIIllIlIlIIlIlIIlIII == 1) {
            lllllllllllllIIllIlIlIIlIlIIIlII.x = this.m10;
            lllllllllllllIIllIlIlIIlIlIIIlII.y = this.m11;
            lllllllllllllIIllIlIlIIlIlIIIlII.z = this.m12;
            lllllllllllllIIllIlIlIIlIlIIIlII.w = this.m13;
        }
        else if (lllllllllllllIIllIlIlIIlIlIIlIII == 2) {
            lllllllllllllIIllIlIlIIlIlIIIlII.x = this.m20;
            lllllllllllllIIllIlIlIIlIlIIIlII.y = this.m21;
            lllllllllllllIIllIlIlIIlIlIIIlII.z = this.m22;
            lllllllllllllIIllIlIlIIlIlIIIlII.w = this.m23;
        }
        else {
            if (lllllllllllllIIllIlIlIIlIlIIlIII != 3) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d2"));
            }
            lllllllllllllIIllIlIlIIlIlIIIlII.x = this.m30;
            lllllllllllllIIllIlIlIIlIlIIIlII.y = this.m31;
            lllllllllllllIIllIlIlIIlIlIIIlII.z = this.m32;
            lllllllllllllIIllIlIlIIlIlIIIlII.w = this.m33;
        }
    }
    
    public Matrix4d() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 0.0;
    }
    
    public final void setRotation(final Quat4f lllllllllllllIIllIlIIIllllllIlIl) {
        final double[] lllllllllllllIIllIlIIIllllllIlII = new double[9];
        final double[] lllllllllllllIIllIlIIIllllllIIll = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIIIllllllIIll, lllllllllllllIIllIlIIIllllllIlII);
        this.m00 = (1.0 - 2.0f * lllllllllllllIIllIlIIIllllllIlIl.y * lllllllllllllIIllIlIIIllllllIlIl.y - 2.0f * lllllllllllllIIllIlIIIllllllIlIl.z * lllllllllllllIIllIlIIIllllllIlIl.z) * lllllllllllllIIllIlIIIllllllIIll[0];
        this.m10 = 2.0 * (lllllllllllllIIllIlIIIllllllIlIl.x * lllllllllllllIIllIlIIIllllllIlIl.y + lllllllllllllIIllIlIIIllllllIlIl.w * lllllllllllllIIllIlIIIllllllIlIl.z) * lllllllllllllIIllIlIIIllllllIIll[0];
        this.m20 = 2.0 * (lllllllllllllIIllIlIIIllllllIlIl.x * lllllllllllllIIllIlIIIllllllIlIl.z - lllllllllllllIIllIlIIIllllllIlIl.w * lllllllllllllIIllIlIIIllllllIlIl.y) * lllllllllllllIIllIlIIIllllllIIll[0];
        this.m01 = 2.0 * (lllllllllllllIIllIlIIIllllllIlIl.x * lllllllllllllIIllIlIIIllllllIlIl.y - lllllllllllllIIllIlIIIllllllIlIl.w * lllllllllllllIIllIlIIIllllllIlIl.z) * lllllllllllllIIllIlIIIllllllIIll[1];
        this.m11 = (1.0 - 2.0f * lllllllllllllIIllIlIIIllllllIlIl.x * lllllllllllllIIllIlIIIllllllIlIl.x - 2.0f * lllllllllllllIIllIlIIIllllllIlIl.z * lllllllllllllIIllIlIIIllllllIlIl.z) * lllllllllllllIIllIlIIIllllllIIll[1];
        this.m21 = 2.0 * (lllllllllllllIIllIlIIIllllllIlIl.y * lllllllllllllIIllIlIIIllllllIlIl.z + lllllllllllllIIllIlIIIllllllIlIl.w * lllllllllllllIIllIlIIIllllllIlIl.x) * lllllllllllllIIllIlIIIllllllIIll[1];
        this.m02 = 2.0 * (lllllllllllllIIllIlIIIllllllIlIl.x * lllllllllllllIIllIlIIIllllllIlIl.z + lllllllllllllIIllIlIIIllllllIlIl.w * lllllllllllllIIllIlIIIllllllIlIl.y) * lllllllllllllIIllIlIIIllllllIIll[2];
        this.m12 = 2.0 * (lllllllllllllIIllIlIIIllllllIlIl.y * lllllllllllllIIllIlIIIllllllIlIl.z - lllllllllllllIIllIlIIIllllllIlIl.w * lllllllllllllIIllIlIIIllllllIlIl.x) * lllllllllllllIIllIlIIIllllllIIll[2];
        this.m22 = (1.0 - 2.0f * lllllllllllllIIllIlIIIllllllIlIl.x * lllllllllllllIIllIlIIIllllllIlIl.x - 2.0f * lllllllllllllIIllIlIIIllllllIlIl.y * lllllllllllllIIllIlIIIllllllIlIl.y) * lllllllllllllIIllIlIIIllllllIIll[2];
    }
    
    public final void setRotationScale(final Matrix3d lllllllllllllIIllIlIlIIIIllllllI) {
        this.m00 = lllllllllllllIIllIlIlIIIIllllllI.m00;
        this.m01 = lllllllllllllIIllIlIlIIIIllllllI.m01;
        this.m02 = lllllllllllllIIllIlIlIIIIllllllI.m02;
        this.m10 = lllllllllllllIIllIlIlIIIIllllllI.m10;
        this.m11 = lllllllllllllIIllIlIlIIIIllllllI.m11;
        this.m12 = lllllllllllllIIllIlIlIIIIllllllI.m12;
        this.m20 = lllllllllllllIIllIlIlIIIIllllllI.m20;
        this.m21 = lllllllllllllIIllIlIlIIIIllllllI.m21;
        this.m22 = lllllllllllllIIllIlIlIIIIllllllI.m22;
    }
    
    public final void set(final Vector3d lllllllllllllIIllIlIIllIlIllIlIl, final double lllllllllllllIIllIlIIllIlIllIlll) {
        this.m00 = lllllllllllllIIllIlIIllIlIllIlll;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = lllllllllllllIIllIlIIllIlIllIlll * lllllllllllllIIllIlIIllIlIllIlIl.x;
        this.m10 = 0.0;
        this.m11 = lllllllllllllIIllIlIIllIlIllIlll;
        this.m12 = 0.0;
        this.m13 = lllllllllllllIIllIlIIllIlIllIlll * lllllllllllllIIllIlIIllIlIllIlIl.y;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = lllllllllllllIIllIlIIllIlIllIlll;
        this.m23 = lllllllllllllIIllIlIIllIlIllIlll * lllllllllllllIIllIlIIllIlIllIlIl.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void transform(final Tuple4d lllllllllllllIIllIlIIlIIlIlIlIII) {
        final double lllllllllllllIIllIlIIlIIlIlIIlll = this.m00 * lllllllllllllIIllIlIIlIIlIlIlIII.x + this.m01 * lllllllllllllIIllIlIIlIIlIlIlIII.y + this.m02 * lllllllllllllIIllIlIIlIIlIlIlIII.z + this.m03 * lllllllllllllIIllIlIIlIIlIlIlIII.w;
        final double lllllllllllllIIllIlIIlIIlIlIIllI = this.m10 * lllllllllllllIIllIlIIlIIlIlIlIII.x + this.m11 * lllllllllllllIIllIlIIlIIlIlIlIII.y + this.m12 * lllllllllllllIIllIlIIlIIlIlIlIII.z + this.m13 * lllllllllllllIIllIlIIlIIlIlIlIII.w;
        final double lllllllllllllIIllIlIIlIIlIlIIlIl = this.m20 * lllllllllllllIIllIlIIlIIlIlIlIII.x + this.m21 * lllllllllllllIIllIlIIlIIlIlIlIII.y + this.m22 * lllllllllllllIIllIlIIlIIlIlIlIII.z + this.m23 * lllllllllllllIIllIlIIlIIlIlIlIII.w;
        lllllllllllllIIllIlIIlIIlIlIlIII.w = this.m30 * lllllllllllllIIllIlIIlIIlIlIlIII.x + this.m31 * lllllllllllllIIllIlIIlIIlIlIlIII.y + this.m32 * lllllllllllllIIllIlIIlIIlIlIlIII.z + this.m33 * lllllllllllllIIllIlIIlIIlIlIlIII.w;
        lllllllllllllIIllIlIIlIIlIlIlIII.x = lllllllllllllIIllIlIIlIIlIlIIlll;
        lllllllllllllIIllIlIIlIIlIlIlIII.y = lllllllllllllIIllIlIIlIIlIlIIllI;
        lllllllllllllIIllIlIIlIIlIlIlIII.z = lllllllllllllIIllIlIIlIIlIlIIlIl;
    }
    
    public final void set(final Matrix3f lllllllllllllIIllIlIIlllllIlllIl) {
        this.m00 = lllllllllllllIIllIlIIlllllIlllIl.m00;
        this.m01 = lllllllllllllIIllIlIIlllllIlllIl.m01;
        this.m02 = lllllllllllllIIllIlIIlllllIlllIl.m02;
        this.m03 = 0.0;
        this.m10 = lllllllllllllIIllIlIIlllllIlllIl.m10;
        this.m11 = lllllllllllllIIllIlIIlllllIlllIl.m11;
        this.m12 = lllllllllllllIIllIlIIlllllIlllIl.m12;
        this.m13 = 0.0;
        this.m20 = lllllllllllllIIllIlIIlllllIlllIl.m20;
        this.m21 = lllllllllllllIIllIlIIlllllIlllIl.m21;
        this.m22 = lllllllllllllIIllIlIIlllllIlllIl.m22;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void transform(final Tuple4d lllllllllllllIIllIlIIlIIlIlllIIl, final Tuple4d lllllllllllllIIllIlIIlIIlIllIIlI) {
        final double lllllllllllllIIllIlIIlIIlIllIlll = this.m00 * lllllllllllllIIllIlIIlIIlIlllIIl.x + this.m01 * lllllllllllllIIllIlIIlIIlIlllIIl.y + this.m02 * lllllllllllllIIllIlIIlIIlIlllIIl.z + this.m03 * lllllllllllllIIllIlIIlIIlIlllIIl.w;
        final double lllllllllllllIIllIlIIlIIlIllIllI = this.m10 * lllllllllllllIIllIlIIlIIlIlllIIl.x + this.m11 * lllllllllllllIIllIlIIlIIlIlllIIl.y + this.m12 * lllllllllllllIIllIlIIlIIlIlllIIl.z + this.m13 * lllllllllllllIIllIlIIlIIlIlllIIl.w;
        final double lllllllllllllIIllIlIIlIIlIllIlIl = this.m20 * lllllllllllllIIllIlIIlIIlIlllIIl.x + this.m21 * lllllllllllllIIllIlIIlIIlIlllIIl.y + this.m22 * lllllllllllllIIllIlIIlIIlIlllIIl.z + this.m23 * lllllllllllllIIllIlIIlIIlIlllIIl.w;
        lllllllllllllIIllIlIIlIIlIllIIlI.w = this.m30 * lllllllllllllIIllIlIIlIIlIlllIIl.x + this.m31 * lllllllllllllIIllIlIIlIIlIlllIIl.y + this.m32 * lllllllllllllIIllIlIIlIIlIlllIIl.z + this.m33 * lllllllllllllIIllIlIIlIIlIlllIIl.w;
        lllllllllllllIIllIlIIlIIlIllIIlI.x = lllllllllllllIIllIlIIlIIlIllIlll;
        lllllllllllllIIllIlIIlIIlIllIIlI.y = lllllllllllllIIllIlIIlIIlIllIllI;
        lllllllllllllIIllIlIIlIIlIllIIlI.z = lllllllllllllIIllIlIIlIIlIllIlIl;
    }
    
    public final void set(final Quat4f lllllllllllllIIllIlIIllllIlIlIIl) {
        this.m00 = 1.0 - 2.0 * lllllllllllllIIllIlIIllllIlIlIIl.y * lllllllllllllIIllIlIIllllIlIlIIl.y - 2.0 * lllllllllllllIIllIlIIllllIlIlIIl.z * lllllllllllllIIllIlIIllllIlIlIIl.z;
        this.m10 = 2.0 * (lllllllllllllIIllIlIIllllIlIlIIl.x * lllllllllllllIIllIlIIllllIlIlIIl.y + lllllllllllllIIllIlIIllllIlIlIIl.w * lllllllllllllIIllIlIIllllIlIlIIl.z);
        this.m20 = 2.0 * (lllllllllllllIIllIlIIllllIlIlIIl.x * lllllllllllllIIllIlIIllllIlIlIIl.z - lllllllllllllIIllIlIIllllIlIlIIl.w * lllllllllllllIIllIlIIllllIlIlIIl.y);
        this.m01 = 2.0 * (lllllllllllllIIllIlIIllllIlIlIIl.x * lllllllllllllIIllIlIIllllIlIlIIl.y - lllllllllllllIIllIlIIllllIlIlIIl.w * lllllllllllllIIllIlIIllllIlIlIIl.z);
        this.m11 = 1.0 - 2.0 * lllllllllllllIIllIlIIllllIlIlIIl.x * lllllllllllllIIllIlIIllllIlIlIIl.x - 2.0 * lllllllllllllIIllIlIIllllIlIlIIl.z * lllllllllllllIIllIlIIllllIlIlIIl.z;
        this.m21 = 2.0 * (lllllllllllllIIllIlIIllllIlIlIIl.y * lllllllllllllIIllIlIIllllIlIlIIl.z + lllllllllllllIIllIlIIllllIlIlIIl.w * lllllllllllllIIllIlIIllllIlIlIIl.x);
        this.m02 = 2.0 * (lllllllllllllIIllIlIIllllIlIlIIl.x * lllllllllllllIIllIlIIllllIlIlIIl.z + lllllllllllllIIllIlIIllllIlIlIIl.w * lllllllllllllIIllIlIIllllIlIlIIl.y);
        this.m12 = 2.0 * (lllllllllllllIIllIlIIllllIlIlIIl.y * lllllllllllllIIllIlIIllllIlIlIIl.z - lllllllllllllIIllIlIIllllIlIlIIl.w * lllllllllllllIIllIlIIllllIlIlIIl.x);
        this.m22 = 1.0 - 2.0 * lllllllllllllIIllIlIIllllIlIlIIl.x * lllllllllllllIIllIlIIllllIlIlIIl.x - 2.0 * lllllllllllllIIllIlIIllllIlIlIIl.y * lllllllllllllIIllIlIIllllIlIlIIl.y;
        this.m03 = 0.0;
        this.m13 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void rotZ(final double lllllllllllllIIllIlIIllIIllllIII) {
        final double lllllllllllllIIllIlIIllIIlllIlll = Math.sin(lllllllllllllIIllIlIIllIIllllIII);
        final double lllllllllllllIIllIlIIllIIlllIllI = Math.cos(lllllllllllllIIllIlIIllIIllllIII);
        this.m00 = lllllllllllllIIllIlIIllIIlllIllI;
        this.m01 = -lllllllllllllIIllIlIIllIIlllIlll;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = lllllllllllllIIllIlIIllIIlllIlll;
        this.m11 = lllllllllllllIIllIlIIllIIlllIllI;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void transform(final Vector3f lllllllllllllIIllIlIIlIIIIlIIIlI, final Vector3f lllllllllllllIIllIlIIlIIIIlIIIIl) {
        final float lllllllllllllIIllIlIIlIIIIlIIlIl = (float)(this.m00 * lllllllllllllIIllIlIIlIIIIlIIIlI.x + this.m01 * lllllllllllllIIllIlIIlIIIIlIIIlI.y + this.m02 * lllllllllllllIIllIlIIlIIIIlIIIlI.z);
        final float lllllllllllllIIllIlIIlIIIIlIIlII = (float)(this.m10 * lllllllllllllIIllIlIIlIIIIlIIIlI.x + this.m11 * lllllllllllllIIllIlIIlIIIIlIIIlI.y + this.m12 * lllllllllllllIIllIlIIlIIIIlIIIlI.z);
        lllllllllllllIIllIlIIlIIIIlIIIIl.z = (float)(this.m20 * lllllllllllllIIllIlIIlIIIIlIIIlI.x + this.m21 * lllllllllllllIIllIlIIlIIIIlIIIlI.y + this.m22 * lllllllllllllIIllIlIIlIIIIlIIIlI.z);
        lllllllllllllIIllIlIIlIIIIlIIIIl.x = lllllllllllllIIllIlIIlIIIIlIIlIl;
        lllllllllllllIIllIlIIlIIIIlIIIIl.y = lllllllllllllIIllIlIIlIIIIlIIlII;
    }
    
    public final void set(final Quat4d lllllllllllllIIllIlIIlllllIlIIll) {
        this.m00 = 1.0 - 2.0 * lllllllllllllIIllIlIIlllllIlIIll.y * lllllllllllllIIllIlIIlllllIlIIll.y - 2.0 * lllllllllllllIIllIlIIlllllIlIIll.z * lllllllllllllIIllIlIIlllllIlIIll.z;
        this.m10 = 2.0 * (lllllllllllllIIllIlIIlllllIlIIll.x * lllllllllllllIIllIlIIlllllIlIIll.y + lllllllllllllIIllIlIIlllllIlIIll.w * lllllllllllllIIllIlIIlllllIlIIll.z);
        this.m20 = 2.0 * (lllllllllllllIIllIlIIlllllIlIIll.x * lllllllllllllIIllIlIIlllllIlIIll.z - lllllllllllllIIllIlIIlllllIlIIll.w * lllllllllllllIIllIlIIlllllIlIIll.y);
        this.m01 = 2.0 * (lllllllllllllIIllIlIIlllllIlIIll.x * lllllllllllllIIllIlIIlllllIlIIll.y - lllllllllllllIIllIlIIlllllIlIIll.w * lllllllllllllIIllIlIIlllllIlIIll.z);
        this.m11 = 1.0 - 2.0 * lllllllllllllIIllIlIIlllllIlIIll.x * lllllllllllllIIllIlIIlllllIlIIll.x - 2.0 * lllllllllllllIIllIlIIlllllIlIIll.z * lllllllllllllIIllIlIIlllllIlIIll.z;
        this.m21 = 2.0 * (lllllllllllllIIllIlIIlllllIlIIll.y * lllllllllllllIIllIlIIlllllIlIIll.z + lllllllllllllIIllIlIIlllllIlIIll.w * lllllllllllllIIllIlIIlllllIlIIll.x);
        this.m02 = 2.0 * (lllllllllllllIIllIlIIlllllIlIIll.x * lllllllllllllIIllIlIIlllllIlIIll.z + lllllllllllllIIllIlIIlllllIlIIll.w * lllllllllllllIIllIlIIlllllIlIIll.y);
        this.m12 = 2.0 * (lllllllllllllIIllIlIIlllllIlIIll.y * lllllllllllllIIllIlIIlllllIlIIll.z - lllllllllllllIIllIlIIlllllIlIIll.w * lllllllllllllIIllIlIIlllllIlIIll.x);
        this.m22 = 1.0 - 2.0 * lllllllllllllIIllIlIIlllllIlIIll.x * lllllllllllllIIllIlIIlllllIlIIll.x - 2.0 * lllllllllllllIIllIlIIlllllIlIIll.y * lllllllllllllIIllIlIIlllllIlIIll.y;
        this.m03 = 0.0;
        this.m13 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void set(final Matrix4f lllllllllllllIIllIlIIlllIlIllIll) {
        this.m00 = lllllllllllllIIllIlIIlllIlIllIll.m00;
        this.m01 = lllllllllllllIIllIlIIlllIlIllIll.m01;
        this.m02 = lllllllllllllIIllIlIIlllIlIllIll.m02;
        this.m03 = lllllllllllllIIllIlIIlllIlIllIll.m03;
        this.m10 = lllllllllllllIIllIlIIlllIlIllIll.m10;
        this.m11 = lllllllllllllIIllIlIIlllIlIllIll.m11;
        this.m12 = lllllllllllllIIllIlIIlllIlIllIll.m12;
        this.m13 = lllllllllllllIIllIlIIlllIlIllIll.m13;
        this.m20 = lllllllllllllIIllIlIIlllIlIllIll.m20;
        this.m21 = lllllllllllllIIllIlIIlllIlIllIll.m21;
        this.m22 = lllllllllllllIIllIlIIlllIlIllIll.m22;
        this.m23 = lllllllllllllIIllIlIIlllIlIllIll.m23;
        this.m30 = lllllllllllllIIllIlIIlllIlIllIll.m30;
        this.m31 = lllllllllllllIIllIlIIlllIlIllIll.m31;
        this.m32 = lllllllllllllIIllIlIIlllIlIllIll.m32;
        this.m33 = lllllllllllllIIllIlIIlllIlIllIll.m33;
    }
    
    public final double getM10() {
        return this.m10;
    }
    
    public final void sub(final Matrix4d lllllllllllllIIllIlIIlllllllIlIl) {
        this.m00 -= lllllllllllllIIllIlIIlllllllIlIl.m00;
        this.m01 -= lllllllllllllIIllIlIIlllllllIlIl.m01;
        this.m02 -= lllllllllllllIIllIlIIlllllllIlIl.m02;
        this.m03 -= lllllllllllllIIllIlIIlllllllIlIl.m03;
        this.m10 -= lllllllllllllIIllIlIIlllllllIlIl.m10;
        this.m11 -= lllllllllllllIIllIlIIlllllllIlIl.m11;
        this.m12 -= lllllllllllllIIllIlIIlllllllIlIl.m12;
        this.m13 -= lllllllllllllIIllIlIIlllllllIlIl.m13;
        this.m20 -= lllllllllllllIIllIlIIlllllllIlIl.m20;
        this.m21 -= lllllllllllllIIllIlIIlllllllIlIl.m21;
        this.m22 -= lllllllllllllIIllIlIIlllllllIlIl.m22;
        this.m23 -= lllllllllllllIIllIlIIlllllllIlIl.m23;
        this.m30 -= lllllllllllllIIllIlIIlllllllIlIl.m30;
        this.m31 -= lllllllllllllIIllIlIIlllllllIlIl.m31;
        this.m32 -= lllllllllllllIIllIlIIlllllllIlIl.m32;
        this.m33 -= lllllllllllllIIllIlIIlllllllIlIl.m33;
    }
    
    public final void setM32(final double lllllllllllllIIllIlIIIllIIIlIIll) {
        this.m32 = lllllllllllllIIllIlIIIllIIIlIIll;
    }
    
    public Matrix4d(final Matrix3f lllllllllllllIIllIlIlIIlIlllllIl, final Vector3d lllllllllllllIIllIlIlIIlIlllllII, final double lllllllllllllIIllIlIlIIlIlllIlll) {
        this.m00 = lllllllllllllIIllIlIlIIlIlllllIl.m00 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m01 = lllllllllllllIIllIlIlIIlIlllllIl.m01 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m02 = lllllllllllllIIllIlIlIIlIlllllIl.m02 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m03 = lllllllllllllIIllIlIlIIlIlllllII.x;
        this.m10 = lllllllllllllIIllIlIlIIlIlllllIl.m10 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m11 = lllllllllllllIIllIlIlIIlIlllllIl.m11 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m12 = lllllllllllllIIllIlIlIIlIlllllIl.m12 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m13 = lllllllllllllIIllIlIlIIlIlllllII.y;
        this.m20 = lllllllllllllIIllIlIlIIlIlllllIl.m20 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m21 = lllllllllllllIIllIlIlIIlIlllllIl.m21 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m22 = lllllllllllllIIllIlIlIIlIlllllIl.m22 * lllllllllllllIIllIlIlIIlIlllIlll;
        this.m23 = lllllllllllllIIllIlIlIIlIlllllII.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void transform(final Point3f lllllllllllllIIllIlIIlIIIlIllIII, final Point3f lllllllllllllIIllIlIIlIIIlIlIlll) {
        final float lllllllllllllIIllIlIIlIIIlIllIll = (float)(this.m00 * lllllllllllllIIllIlIIlIIIlIllIII.x + this.m01 * lllllllllllllIIllIlIIlIIIlIllIII.y + this.m02 * lllllllllllllIIllIlIIlIIIlIllIII.z + this.m03);
        final float lllllllllllllIIllIlIIlIIIlIllIlI = (float)(this.m10 * lllllllllllllIIllIlIIlIIIlIllIII.x + this.m11 * lllllllllllllIIllIlIIlIIIlIllIII.y + this.m12 * lllllllllllllIIllIlIIlIIIlIllIII.z + this.m13);
        lllllllllllllIIllIlIIlIIIlIlIlll.z = (float)(this.m20 * lllllllllllllIIllIlIIlIIIlIllIII.x + this.m21 * lllllllllllllIIllIlIIlIIIlIllIII.y + this.m22 * lllllllllllllIIllIlIIlIIIlIllIII.z + this.m23);
        lllllllllllllIIllIlIIlIIIlIlIlll.x = lllllllllllllIIllIlIIlIIIlIllIll;
        lllllllllllllIIllIlIIlIIIlIlIlll.y = lllllllllllllIIllIlIIlIIIlIllIlI;
    }
    
    public final double getM30() {
        return this.m30;
    }
    
    public final void setRotation(final Quat4d lllllllllllllIIllIlIIIlllllIIlIl) {
        final double[] lllllllllllllIIllIlIIIlllllIlIII = new double[9];
        final double[] lllllllllllllIIllIlIIIlllllIIlll = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIIIlllllIIlll, lllllllllllllIIllIlIIIlllllIlIII);
        this.m00 = (1.0 - 2.0 * lllllllllllllIIllIlIIIlllllIIlIl.y * lllllllllllllIIllIlIIIlllllIIlIl.y - 2.0 * lllllllllllllIIllIlIIIlllllIIlIl.z * lllllllllllllIIllIlIIIlllllIIlIl.z) * lllllllllllllIIllIlIIIlllllIIlll[0];
        this.m10 = 2.0 * (lllllllllllllIIllIlIIIlllllIIlIl.x * lllllllllllllIIllIlIIIlllllIIlIl.y + lllllllllllllIIllIlIIIlllllIIlIl.w * lllllllllllllIIllIlIIIlllllIIlIl.z) * lllllllllllllIIllIlIIIlllllIIlll[0];
        this.m20 = 2.0 * (lllllllllllllIIllIlIIIlllllIIlIl.x * lllllllllllllIIllIlIIIlllllIIlIl.z - lllllllllllllIIllIlIIIlllllIIlIl.w * lllllllllllllIIllIlIIIlllllIIlIl.y) * lllllllllllllIIllIlIIIlllllIIlll[0];
        this.m01 = 2.0 * (lllllllllllllIIllIlIIIlllllIIlIl.x * lllllllllllllIIllIlIIIlllllIIlIl.y - lllllllllllllIIllIlIIIlllllIIlIl.w * lllllllllllllIIllIlIIIlllllIIlIl.z) * lllllllllllllIIllIlIIIlllllIIlll[1];
        this.m11 = (1.0 - 2.0 * lllllllllllllIIllIlIIIlllllIIlIl.x * lllllllllllllIIllIlIIIlllllIIlIl.x - 2.0 * lllllllllllllIIllIlIIIlllllIIlIl.z * lllllllllllllIIllIlIIIlllllIIlIl.z) * lllllllllllllIIllIlIIIlllllIIlll[1];
        this.m21 = 2.0 * (lllllllllllllIIllIlIIIlllllIIlIl.y * lllllllllllllIIllIlIIIlllllIIlIl.z + lllllllllllllIIllIlIIIlllllIIlIl.w * lllllllllllllIIllIlIIIlllllIIlIl.x) * lllllllllllllIIllIlIIIlllllIIlll[1];
        this.m02 = 2.0 * (lllllllllllllIIllIlIIIlllllIIlIl.x * lllllllllllllIIllIlIIIlllllIIlIl.z + lllllllllllllIIllIlIIIlllllIIlIl.w * lllllllllllllIIllIlIIIlllllIIlIl.y) * lllllllllllllIIllIlIIIlllllIIlll[2];
        this.m12 = 2.0 * (lllllllllllllIIllIlIIIlllllIIlIl.y * lllllllllllllIIllIlIIIlllllIIlIl.z - lllllllllllllIIllIlIIIlllllIIlIl.w * lllllllllllllIIllIlIIIlllllIIlIl.x) * lllllllllllllIIllIlIIIlllllIIlll[2];
        this.m22 = (1.0 - 2.0 * lllllllllllllIIllIlIIIlllllIIlIl.x * lllllllllllllIIllIlIIIlllllIIlIl.x - 2.0 * lllllllllllllIIllIlIIIlllllIIlIl.y * lllllllllllllIIllIlIIIlllllIIlIl.y) * lllllllllllllIIllIlIIIlllllIIlll[2];
    }
    
    public final void add(final Matrix4d lllllllllllllIIllIlIlIIIIIIIIlII) {
        this.m00 += lllllllllllllIIllIlIlIIIIIIIIlII.m00;
        this.m01 += lllllllllllllIIllIlIlIIIIIIIIlII.m01;
        this.m02 += lllllllllllllIIllIlIlIIIIIIIIlII.m02;
        this.m03 += lllllllllllllIIllIlIlIIIIIIIIlII.m03;
        this.m10 += lllllllllllllIIllIlIlIIIIIIIIlII.m10;
        this.m11 += lllllllllllllIIllIlIlIIIIIIIIlII.m11;
        this.m12 += lllllllllllllIIllIlIlIIIIIIIIlII.m12;
        this.m13 += lllllllllllllIIllIlIlIIIIIIIIlII.m13;
        this.m20 += lllllllllllllIIllIlIlIIIIIIIIlII.m20;
        this.m21 += lllllllllllllIIllIlIlIIIIIIIIlII.m21;
        this.m22 += lllllllllllllIIllIlIlIIIIIIIIlII.m22;
        this.m23 += lllllllllllllIIllIlIlIIIIIIIIlII.m23;
        this.m30 += lllllllllllllIIllIlIlIIIIIIIIlII.m30;
        this.m31 += lllllllllllllIIllIlIlIIIIIIIIlII.m31;
        this.m32 += lllllllllllllIIllIlIlIIIIIIIIlII.m32;
        this.m33 += lllllllllllllIIllIlIlIIIIIIIIlII.m33;
    }
    
    public final void setM11(final double lllllllllllllIIllIlIIIllIllIllIl) {
        this.m11 = lllllllllllllIIllIlIIIllIllIllIl;
    }
    
    public final void invert() {
        this.invertGeneral(this);
    }
    
    public final void setRotation(final Matrix3d lllllllllllllIIllIlIIlIIIIIIlIIl) {
        final double[] lllllllllllllIIllIlIIlIIIIIIllII = new double[9];
        final double[] lllllllllllllIIllIlIIlIIIIIIlIll = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIIlIIIIIIlIll, lllllllllllllIIllIlIIlIIIIIIllII);
        this.m00 = lllllllllllllIIllIlIIlIIIIIIlIIl.m00 * lllllllllllllIIllIlIIlIIIIIIlIll[0];
        this.m01 = lllllllllllllIIllIlIIlIIIIIIlIIl.m01 * lllllllllllllIIllIlIIlIIIIIIlIll[1];
        this.m02 = lllllllllllllIIllIlIIlIIIIIIlIIl.m02 * lllllllllllllIIllIlIIlIIIIIIlIll[2];
        this.m10 = lllllllllllllIIllIlIIlIIIIIIlIIl.m10 * lllllllllllllIIllIlIIlIIIIIIlIll[0];
        this.m11 = lllllllllllllIIllIlIIlIIIIIIlIIl.m11 * lllllllllllllIIllIlIIlIIIIIIlIll[1];
        this.m12 = lllllllllllllIIllIlIIlIIIIIIlIIl.m12 * lllllllllllllIIllIlIIlIIIIIIlIll[2];
        this.m20 = lllllllllllllIIllIlIIlIIIIIIlIIl.m20 * lllllllllllllIIllIlIIlIIIIIIlIll[0];
        this.m21 = lllllllllllllIIllIlIIlIIIIIIlIIl.m21 * lllllllllllllIIllIlIIlIIIIIIlIll[1];
        this.m22 = lllllllllllllIIllIlIIlIIIIIIlIIl.m22 * lllllllllllllIIllIlIIlIIIIIIlIll[2];
    }
    
    public final void mulTransposeRight(final Matrix4d lllllllllllllIIllIlIIlIlIlIIllIl, final Matrix4d lllllllllllllIIllIlIIlIlIlIIllII) {
        if (this != lllllllllllllIIllIlIIlIlIlIIllIl && this != lllllllllllllIIllIlIIlIlIlIIllII) {
            this.m00 = lllllllllllllIIllIlIIlIlIlIIllIl.m00 * lllllllllllllIIllIlIIlIlIlIIllII.m00 + lllllllllllllIIllIlIIlIlIlIIllIl.m01 * lllllllllllllIIllIlIIlIlIlIIllII.m01 + lllllllllllllIIllIlIIlIlIlIIllIl.m02 * lllllllllllllIIllIlIIlIlIlIIllII.m02 + lllllllllllllIIllIlIIlIlIlIIllIl.m03 * lllllllllllllIIllIlIIlIlIlIIllII.m03;
            this.m01 = lllllllllllllIIllIlIIlIlIlIIllIl.m00 * lllllllllllllIIllIlIIlIlIlIIllII.m10 + lllllllllllllIIllIlIIlIlIlIIllIl.m01 * lllllllllllllIIllIlIIlIlIlIIllII.m11 + lllllllllllllIIllIlIIlIlIlIIllIl.m02 * lllllllllllllIIllIlIIlIlIlIIllII.m12 + lllllllllllllIIllIlIIlIlIlIIllIl.m03 * lllllllllllllIIllIlIIlIlIlIIllII.m13;
            this.m02 = lllllllllllllIIllIlIIlIlIlIIllIl.m00 * lllllllllllllIIllIlIIlIlIlIIllII.m20 + lllllllllllllIIllIlIIlIlIlIIllIl.m01 * lllllllllllllIIllIlIIlIlIlIIllII.m21 + lllllllllllllIIllIlIIlIlIlIIllIl.m02 * lllllllllllllIIllIlIIlIlIlIIllII.m22 + lllllllllllllIIllIlIIlIlIlIIllIl.m03 * lllllllllllllIIllIlIIlIlIlIIllII.m23;
            this.m03 = lllllllllllllIIllIlIIlIlIlIIllIl.m00 * lllllllllllllIIllIlIIlIlIlIIllII.m30 + lllllllllllllIIllIlIIlIlIlIIllIl.m01 * lllllllllllllIIllIlIIlIlIlIIllII.m31 + lllllllllllllIIllIlIIlIlIlIIllIl.m02 * lllllllllllllIIllIlIIlIlIlIIllII.m32 + lllllllllllllIIllIlIIlIlIlIIllIl.m03 * lllllllllllllIIllIlIIlIlIlIIllII.m33;
            this.m10 = lllllllllllllIIllIlIIlIlIlIIllIl.m10 * lllllllllllllIIllIlIIlIlIlIIllII.m00 + lllllllllllllIIllIlIIlIlIlIIllIl.m11 * lllllllllllllIIllIlIIlIlIlIIllII.m01 + lllllllllllllIIllIlIIlIlIlIIllIl.m12 * lllllllllllllIIllIlIIlIlIlIIllII.m02 + lllllllllllllIIllIlIIlIlIlIIllIl.m13 * lllllllllllllIIllIlIIlIlIlIIllII.m03;
            this.m11 = lllllllllllllIIllIlIIlIlIlIIllIl.m10 * lllllllllllllIIllIlIIlIlIlIIllII.m10 + lllllllllllllIIllIlIIlIlIlIIllIl.m11 * lllllllllllllIIllIlIIlIlIlIIllII.m11 + lllllllllllllIIllIlIIlIlIlIIllIl.m12 * lllllllllllllIIllIlIIlIlIlIIllII.m12 + lllllllllllllIIllIlIIlIlIlIIllIl.m13 * lllllllllllllIIllIlIIlIlIlIIllII.m13;
            this.m12 = lllllllllllllIIllIlIIlIlIlIIllIl.m10 * lllllllllllllIIllIlIIlIlIlIIllII.m20 + lllllllllllllIIllIlIIlIlIlIIllIl.m11 * lllllllllllllIIllIlIIlIlIlIIllII.m21 + lllllllllllllIIllIlIIlIlIlIIllIl.m12 * lllllllllllllIIllIlIIlIlIlIIllII.m22 + lllllllllllllIIllIlIIlIlIlIIllIl.m13 * lllllllllllllIIllIlIIlIlIlIIllII.m23;
            this.m13 = lllllllllllllIIllIlIIlIlIlIIllIl.m10 * lllllllllllllIIllIlIIlIlIlIIllII.m30 + lllllllllllllIIllIlIIlIlIlIIllIl.m11 * lllllllllllllIIllIlIIlIlIlIIllII.m31 + lllllllllllllIIllIlIIlIlIlIIllIl.m12 * lllllllllllllIIllIlIIlIlIlIIllII.m32 + lllllllllllllIIllIlIIlIlIlIIllIl.m13 * lllllllllllllIIllIlIIlIlIlIIllII.m33;
            this.m20 = lllllllllllllIIllIlIIlIlIlIIllIl.m20 * lllllllllllllIIllIlIIlIlIlIIllII.m00 + lllllllllllllIIllIlIIlIlIlIIllIl.m21 * lllllllllllllIIllIlIIlIlIlIIllII.m01 + lllllllllllllIIllIlIIlIlIlIIllIl.m22 * lllllllllllllIIllIlIIlIlIlIIllII.m02 + lllllllllllllIIllIlIIlIlIlIIllIl.m23 * lllllllllllllIIllIlIIlIlIlIIllII.m03;
            this.m21 = lllllllllllllIIllIlIIlIlIlIIllIl.m20 * lllllllllllllIIllIlIIlIlIlIIllII.m10 + lllllllllllllIIllIlIIlIlIlIIllIl.m21 * lllllllllllllIIllIlIIlIlIlIIllII.m11 + lllllllllllllIIllIlIIlIlIlIIllIl.m22 * lllllllllllllIIllIlIIlIlIlIIllII.m12 + lllllllllllllIIllIlIIlIlIlIIllIl.m23 * lllllllllllllIIllIlIIlIlIlIIllII.m13;
            this.m22 = lllllllllllllIIllIlIIlIlIlIIllIl.m20 * lllllllllllllIIllIlIIlIlIlIIllII.m20 + lllllllllllllIIllIlIIlIlIlIIllIl.m21 * lllllllllllllIIllIlIIlIlIlIIllII.m21 + lllllllllllllIIllIlIIlIlIlIIllIl.m22 * lllllllllllllIIllIlIIlIlIlIIllII.m22 + lllllllllllllIIllIlIIlIlIlIIllIl.m23 * lllllllllllllIIllIlIIlIlIlIIllII.m23;
            this.m23 = lllllllllllllIIllIlIIlIlIlIIllIl.m20 * lllllllllllllIIllIlIIlIlIlIIllII.m30 + lllllllllllllIIllIlIIlIlIlIIllIl.m21 * lllllllllllllIIllIlIIlIlIlIIllII.m31 + lllllllllllllIIllIlIIlIlIlIIllIl.m22 * lllllllllllllIIllIlIIlIlIlIIllII.m32 + lllllllllllllIIllIlIIlIlIlIIllIl.m23 * lllllllllllllIIllIlIIlIlIlIIllII.m33;
            this.m30 = lllllllllllllIIllIlIIlIlIlIIllIl.m30 * lllllllllllllIIllIlIIlIlIlIIllII.m00 + lllllllllllllIIllIlIIlIlIlIIllIl.m31 * lllllllllllllIIllIlIIlIlIlIIllII.m01 + lllllllllllllIIllIlIIlIlIlIIllIl.m32 * lllllllllllllIIllIlIIlIlIlIIllII.m02 + lllllllllllllIIllIlIIlIlIlIIllIl.m33 * lllllllllllllIIllIlIIlIlIlIIllII.m03;
            this.m31 = lllllllllllllIIllIlIIlIlIlIIllIl.m30 * lllllllllllllIIllIlIIlIlIlIIllII.m10 + lllllllllllllIIllIlIIlIlIlIIllIl.m31 * lllllllllllllIIllIlIIlIlIlIIllII.m11 + lllllllllllllIIllIlIIlIlIlIIllIl.m32 * lllllllllllllIIllIlIIlIlIlIIllII.m12 + lllllllllllllIIllIlIIlIlIlIIllIl.m33 * lllllllllllllIIllIlIIlIlIlIIllII.m13;
            this.m32 = lllllllllllllIIllIlIIlIlIlIIllIl.m30 * lllllllllllllIIllIlIIlIlIlIIllII.m20 + lllllllllllllIIllIlIIlIlIlIIllIl.m31 * lllllllllllllIIllIlIIlIlIlIIllII.m21 + lllllllllllllIIllIlIIlIlIlIIllIl.m32 * lllllllllllllIIllIlIIlIlIlIIllII.m22 + lllllllllllllIIllIlIIlIlIlIIllIl.m33 * lllllllllllllIIllIlIIlIlIlIIllII.m23;
            this.m33 = lllllllllllllIIllIlIIlIlIlIIllIl.m30 * lllllllllllllIIllIlIIlIlIlIIllII.m30 + lllllllllllllIIllIlIIlIlIlIIllIl.m31 * lllllllllllllIIllIlIIlIlIlIIllII.m31 + lllllllllllllIIllIlIIlIlIlIIllIl.m32 * lllllllllllllIIllIlIIlIlIlIIllII.m32 + lllllllllllllIIllIlIIlIlIlIIllIl.m33 * lllllllllllllIIllIlIIlIlIlIIllII.m33;
        }
        else {
            final double lllllllllllllIIllIlIIlIlIlIIlIll = lllllllllllllIIllIlIIlIlIlIIllIl.m00 * lllllllllllllIIllIlIIlIlIlIIllII.m00 + lllllllllllllIIllIlIIlIlIlIIllIl.m01 * lllllllllllllIIllIlIIlIlIlIIllII.m01 + lllllllllllllIIllIlIIlIlIlIIllIl.m02 * lllllllllllllIIllIlIIlIlIlIIllII.m02 + lllllllllllllIIllIlIIlIlIlIIllIl.m03 * lllllllllllllIIllIlIIlIlIlIIllII.m03;
            final double lllllllllllllIIllIlIIlIlIlIIlIlI = lllllllllllllIIllIlIIlIlIlIIllIl.m00 * lllllllllllllIIllIlIIlIlIlIIllII.m10 + lllllllllllllIIllIlIIlIlIlIIllIl.m01 * lllllllllllllIIllIlIIlIlIlIIllII.m11 + lllllllllllllIIllIlIIlIlIlIIllIl.m02 * lllllllllllllIIllIlIIlIlIlIIllII.m12 + lllllllllllllIIllIlIIlIlIlIIllIl.m03 * lllllllllllllIIllIlIIlIlIlIIllII.m13;
            final double lllllllllllllIIllIlIIlIlIlIIlIIl = lllllllllllllIIllIlIIlIlIlIIllIl.m00 * lllllllllllllIIllIlIIlIlIlIIllII.m20 + lllllllllllllIIllIlIIlIlIlIIllIl.m01 * lllllllllllllIIllIlIIlIlIlIIllII.m21 + lllllllllllllIIllIlIIlIlIlIIllIl.m02 * lllllllllllllIIllIlIIlIlIlIIllII.m22 + lllllllllllllIIllIlIIlIlIlIIllIl.m03 * lllllllllllllIIllIlIIlIlIlIIllII.m23;
            final double lllllllllllllIIllIlIIlIlIlIIlIII = lllllllllllllIIllIlIIlIlIlIIllIl.m00 * lllllllllllllIIllIlIIlIlIlIIllII.m30 + lllllllllllllIIllIlIIlIlIlIIllIl.m01 * lllllllllllllIIllIlIIlIlIlIIllII.m31 + lllllllllllllIIllIlIIlIlIlIIllIl.m02 * lllllllllllllIIllIlIIlIlIlIIllII.m32 + lllllllllllllIIllIlIIlIlIlIIllIl.m03 * lllllllllllllIIllIlIIlIlIlIIllII.m33;
            final double lllllllllllllIIllIlIIlIlIlIIIlll = lllllllllllllIIllIlIIlIlIlIIllIl.m10 * lllllllllllllIIllIlIIlIlIlIIllII.m00 + lllllllllllllIIllIlIIlIlIlIIllIl.m11 * lllllllllllllIIllIlIIlIlIlIIllII.m01 + lllllllllllllIIllIlIIlIlIlIIllIl.m12 * lllllllllllllIIllIlIIlIlIlIIllII.m02 + lllllllllllllIIllIlIIlIlIlIIllIl.m13 * lllllllllllllIIllIlIIlIlIlIIllII.m03;
            final double lllllllllllllIIllIlIIlIlIlIIIllI = lllllllllllllIIllIlIIlIlIlIIllIl.m10 * lllllllllllllIIllIlIIlIlIlIIllII.m10 + lllllllllllllIIllIlIIlIlIlIIllIl.m11 * lllllllllllllIIllIlIIlIlIlIIllII.m11 + lllllllllllllIIllIlIIlIlIlIIllIl.m12 * lllllllllllllIIllIlIIlIlIlIIllII.m12 + lllllllllllllIIllIlIIlIlIlIIllIl.m13 * lllllllllllllIIllIlIIlIlIlIIllII.m13;
            final double lllllllllllllIIllIlIIlIlIlIIIlIl = lllllllllllllIIllIlIIlIlIlIIllIl.m10 * lllllllllllllIIllIlIIlIlIlIIllII.m20 + lllllllllllllIIllIlIIlIlIlIIllIl.m11 * lllllllllllllIIllIlIIlIlIlIIllII.m21 + lllllllllllllIIllIlIIlIlIlIIllIl.m12 * lllllllllllllIIllIlIIlIlIlIIllII.m22 + lllllllllllllIIllIlIIlIlIlIIllIl.m13 * lllllllllllllIIllIlIIlIlIlIIllII.m23;
            final double lllllllllllllIIllIlIIlIlIlIIIlII = lllllllllllllIIllIlIIlIlIlIIllIl.m10 * lllllllllllllIIllIlIIlIlIlIIllII.m30 + lllllllllllllIIllIlIIlIlIlIIllIl.m11 * lllllllllllllIIllIlIIlIlIlIIllII.m31 + lllllllllllllIIllIlIIlIlIlIIllIl.m12 * lllllllllllllIIllIlIIlIlIlIIllII.m32 + lllllllllllllIIllIlIIlIlIlIIllIl.m13 * lllllllllllllIIllIlIIlIlIlIIllII.m33;
            final double lllllllllllllIIllIlIIlIlIlIIIIll = lllllllllllllIIllIlIIlIlIlIIllIl.m20 * lllllllllllllIIllIlIIlIlIlIIllII.m00 + lllllllllllllIIllIlIIlIlIlIIllIl.m21 * lllllllllllllIIllIlIIlIlIlIIllII.m01 + lllllllllllllIIllIlIIlIlIlIIllIl.m22 * lllllllllllllIIllIlIIlIlIlIIllII.m02 + lllllllllllllIIllIlIIlIlIlIIllIl.m23 * lllllllllllllIIllIlIIlIlIlIIllII.m03;
            final double lllllllllllllIIllIlIIlIlIlIIIIlI = lllllllllllllIIllIlIIlIlIlIIllIl.m20 * lllllllllllllIIllIlIIlIlIlIIllII.m10 + lllllllllllllIIllIlIIlIlIlIIllIl.m21 * lllllllllllllIIllIlIIlIlIlIIllII.m11 + lllllllllllllIIllIlIIlIlIlIIllIl.m22 * lllllllllllllIIllIlIIlIlIlIIllII.m12 + lllllllllllllIIllIlIIlIlIlIIllIl.m23 * lllllllllllllIIllIlIIlIlIlIIllII.m13;
            final double lllllllllllllIIllIlIIlIlIlIIIIIl = lllllllllllllIIllIlIIlIlIlIIllIl.m20 * lllllllllllllIIllIlIIlIlIlIIllII.m20 + lllllllllllllIIllIlIIlIlIlIIllIl.m21 * lllllllllllllIIllIlIIlIlIlIIllII.m21 + lllllllllllllIIllIlIIlIlIlIIllIl.m22 * lllllllllllllIIllIlIIlIlIlIIllII.m22 + lllllllllllllIIllIlIIlIlIlIIllIl.m23 * lllllllllllllIIllIlIIlIlIlIIllII.m23;
            final double lllllllllllllIIllIlIIlIlIlIIIIII = lllllllllllllIIllIlIIlIlIlIIllIl.m20 * lllllllllllllIIllIlIIlIlIlIIllII.m30 + lllllllllllllIIllIlIIlIlIlIIllIl.m21 * lllllllllllllIIllIlIIlIlIlIIllII.m31 + lllllllllllllIIllIlIIlIlIlIIllIl.m22 * lllllllllllllIIllIlIIlIlIlIIllII.m32 + lllllllllllllIIllIlIIlIlIlIIllIl.m23 * lllllllllllllIIllIlIIlIlIlIIllII.m33;
            final double lllllllllllllIIllIlIIlIlIIllllll = lllllllllllllIIllIlIIlIlIlIIllIl.m30 * lllllllllllllIIllIlIIlIlIlIIllII.m00 + lllllllllllllIIllIlIIlIlIlIIllIl.m31 * lllllllllllllIIllIlIIlIlIlIIllII.m01 + lllllllllllllIIllIlIIlIlIlIIllIl.m32 * lllllllllllllIIllIlIIlIlIlIIllII.m02 + lllllllllllllIIllIlIIlIlIlIIllIl.m33 * lllllllllllllIIllIlIIlIlIlIIllII.m03;
            final double lllllllllllllIIllIlIIlIlIIlllllI = lllllllllllllIIllIlIIlIlIlIIllIl.m30 * lllllllllllllIIllIlIIlIlIlIIllII.m10 + lllllllllllllIIllIlIIlIlIlIIllIl.m31 * lllllllllllllIIllIlIIlIlIlIIllII.m11 + lllllllllllllIIllIlIIlIlIlIIllIl.m32 * lllllllllllllIIllIlIIlIlIlIIllII.m12 + lllllllllllllIIllIlIIlIlIlIIllIl.m33 * lllllllllllllIIllIlIIlIlIlIIllII.m13;
            final double lllllllllllllIIllIlIIlIlIIllllIl = lllllllllllllIIllIlIIlIlIlIIllIl.m30 * lllllllllllllIIllIlIIlIlIlIIllII.m20 + lllllllllllllIIllIlIIlIlIlIIllIl.m31 * lllllllllllllIIllIlIIlIlIlIIllII.m21 + lllllllllllllIIllIlIIlIlIlIIllIl.m32 * lllllllllllllIIllIlIIlIlIlIIllII.m22 + lllllllllllllIIllIlIIlIlIlIIllIl.m33 * lllllllllllllIIllIlIIlIlIlIIllII.m23;
            final double lllllllllllllIIllIlIIlIlIIllllII = lllllllllllllIIllIlIIlIlIlIIllIl.m30 * lllllllllllllIIllIlIIlIlIlIIllII.m30 + lllllllllllllIIllIlIIlIlIlIIllIl.m31 * lllllllllllllIIllIlIIlIlIlIIllII.m31 + lllllllllllllIIllIlIIlIlIlIIllIl.m32 * lllllllllllllIIllIlIIlIlIlIIllII.m32 + lllllllllllllIIllIlIIlIlIlIIllIl.m33 * lllllllllllllIIllIlIIlIlIlIIllII.m33;
            this.m00 = lllllllllllllIIllIlIIlIlIlIIlIll;
            this.m01 = lllllllllllllIIllIlIIlIlIlIIlIlI;
            this.m02 = lllllllllllllIIllIlIIlIlIlIIlIIl;
            this.m03 = lllllllllllllIIllIlIIlIlIlIIlIII;
            this.m10 = lllllllllllllIIllIlIIlIlIlIIIlll;
            this.m11 = lllllllllllllIIllIlIIlIlIlIIIllI;
            this.m12 = lllllllllllllIIllIlIIlIlIlIIIlIl;
            this.m13 = lllllllllllllIIllIlIIlIlIlIIIlII;
            this.m20 = lllllllllllllIIllIlIIlIlIlIIIIll;
            this.m21 = lllllllllllllIIllIlIIlIlIlIIIIlI;
            this.m22 = lllllllllllllIIllIlIIlIlIlIIIIIl;
            this.m23 = lllllllllllllIIllIlIIlIlIlIIIIII;
            this.m30 = lllllllllllllIIllIlIIlIlIIllllll;
            this.m31 = lllllllllllllIIllIlIIlIlIIlllllI;
            this.m32 = lllllllllllllIIllIlIIlIlIIllllIl;
            this.m33 = lllllllllllllIIllIlIIlIlIIllllII;
        }
    }
    
    public Matrix4d(final double lllllllllllllIIllIlIlIIllllIlIII, final double lllllllllllllIIllIlIlIIllllIIlll, final double lllllllllllllIIllIlIlIIllllIIllI, final double lllllllllllllIIllIlIlIIlllIlIlII, final double lllllllllllllIIllIlIlIIllllIIlII, final double lllllllllllllIIllIlIlIIllllIIIll, final double lllllllllllllIIllIlIlIIlllIlIIIl, final double lllllllllllllIIllIlIlIIllllIIIIl, final double lllllllllllllIIllIlIlIIlllIIllll, final double lllllllllllllIIllIlIlIIlllIlllll, final double lllllllllllllIIllIlIlIIlllIllllI, final double lllllllllllllIIllIlIlIIlllIIllII, final double lllllllllllllIIllIlIlIIlllIlllII, final double lllllllllllllIIllIlIlIIlllIIlIlI, final double lllllllllllllIIllIlIlIIlllIIlIIl, final double lllllllllllllIIllIlIlIIlllIllIIl) {
        this.m00 = lllllllllllllIIllIlIlIIllllIlIII;
        this.m01 = lllllllllllllIIllIlIlIIllllIIlll;
        this.m02 = lllllllllllllIIllIlIlIIllllIIllI;
        this.m03 = lllllllllllllIIllIlIlIIlllIlIlII;
        this.m10 = lllllllllllllIIllIlIlIIllllIIlII;
        this.m11 = lllllllllllllIIllIlIlIIllllIIIll;
        this.m12 = lllllllllllllIIllIlIlIIlllIlIIIl;
        this.m13 = lllllllllllllIIllIlIlIIllllIIIIl;
        this.m20 = lllllllllllllIIllIlIlIIlllIIllll;
        this.m21 = lllllllllllllIIllIlIlIIlllIlllll;
        this.m22 = lllllllllllllIIllIlIlIIlllIllllI;
        this.m23 = lllllllllllllIIllIlIlIIlllIIllII;
        this.m30 = lllllllllllllIIllIlIlIIlllIlllII;
        this.m31 = lllllllllllllIIllIlIlIIlllIIlIlI;
        this.m32 = lllllllllllllIIllIlIlIIlllIIlIIl;
        this.m33 = lllllllllllllIIllIlIlIIlllIllIIl;
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIIllIlIIlIIllIIIIll = 1L;
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m00);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m01);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m02);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m03);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m10);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m11);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m12);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m13);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m20);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m21);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m22);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m23);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m30);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m31);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m32);
        lllllllllllllIIllIlIIlIIllIIIIll = VecMathUtil.hashDoubleBits(lllllllllllllIIllIlIIlIIllIIIIll, this.m33);
        return VecMathUtil.hashFinish(lllllllllllllIIllIlIIlIIllIIIIll);
    }
    
    public final void set(final double lllllllllllllIIllIlIIllIllIIIIIl, final Vector3d lllllllllllllIIllIlIIllIlIllllIl) {
        this.m00 = lllllllllllllIIllIlIIllIllIIIIIl;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = lllllllllllllIIllIlIIllIlIllllIl.x;
        this.m10 = 0.0;
        this.m11 = lllllllllllllIIllIlIIllIllIIIIIl;
        this.m12 = 0.0;
        this.m13 = lllllllllllllIIllIlIIllIlIllllIl.y;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = lllllllllllllIIllIlIIllIllIIIIIl;
        this.m23 = lllllllllllllIIllIlIIllIlIllllIl.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    static void luBacksubstitution(final double[] lllllllllllllIIllIlIIllIlllIIIll, final int[] lllllllllllllIIllIlIIllIlllIllll, final double[] lllllllllllllIIllIlIIllIlllIIIIl) {
        final int lllllllllllllIIllIlIIllIlllIlIII = 0;
        for (int lllllllllllllIIllIlIIllIlllIlIIl = 0; lllllllllllllIIllIlIIllIlllIlIIl < 4; ++lllllllllllllIIllIlIIllIlllIlIIl) {
            final int lllllllllllllIIllIlIIllIlllIIlll = lllllllllllllIIllIlIIllIlllIlIIl;
            int lllllllllllllIIllIlIIllIlllIllII = -1;
            for (int lllllllllllllIIllIlIIllIlllIllIl = 0; lllllllllllllIIllIlIIllIlllIllIl < 4; ++lllllllllllllIIllIlIIllIlllIllIl) {
                final int lllllllllllllIIllIlIIllIlllIlIll = lllllllllllllIIllIlIIllIlllIllll[lllllllllllllIIllIlIIllIlllIlIII + lllllllllllllIIllIlIIllIlllIllIl];
                double lllllllllllllIIllIlIIllIlllIIlII = lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 4 * lllllllllllllIIllIlIIllIlllIlIll];
                lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 4 * lllllllllllllIIllIlIIllIlllIlIll] = lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 4 * lllllllllllllIIllIlIIllIlllIllIl];
                if (lllllllllllllIIllIlIIllIlllIllII >= 0) {
                    final int lllllllllllllIIllIlIIllIlllIIllI = lllllllllllllIIllIlIIllIlllIllIl * 4;
                    for (int lllllllllllllIIllIlIIllIlllIlIlI = lllllllllllllIIllIlIIllIlllIllII; lllllllllllllIIllIlIIllIlllIlIlI <= lllllllllllllIIllIlIIllIlllIllIl - 1; ++lllllllllllllIIllIlIIllIlllIlIlI) {
                        lllllllllllllIIllIlIIllIlllIIlII -= lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIllI + lllllllllllllIIllIlIIllIlllIlIlI] * lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 4 * lllllllllllllIIllIlIIllIlllIlIlI];
                    }
                }
                else if (lllllllllllllIIllIlIIllIlllIIlII != 0.0) {
                    lllllllllllllIIllIlIIllIlllIllII = lllllllllllllIIllIlIIllIlllIllIl;
                }
                lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 4 * lllllllllllllIIllIlIIllIlllIllIl] = lllllllllllllIIllIlIIllIlllIIlII;
            }
            int lllllllllllllIIllIlIIllIlllIIlIl = 12;
            final int n = lllllllllllllIIllIlIIllIlllIIlll + 12;
            lllllllllllllIIllIlIIllIlllIIIIl[n] /= lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 3];
            lllllllllllllIIllIlIIllIlllIIlIl -= 4;
            lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 8] = (lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 8] - lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 3] * lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 12]) / lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 2];
            lllllllllllllIIllIlIIllIlllIIlIl -= 4;
            lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 4] = (lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 4] - lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 2] * lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 8] - lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 3] * lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 12]) / lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 1];
            lllllllllllllIIllIlIIllIlllIIlIl -= 4;
            lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 0] = (lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 0] - lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 1] * lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 4] - lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 2] * lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 8] - lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 3] * lllllllllllllIIllIlIIllIlllIIIIl[lllllllllllllIIllIlIIllIlllIIlll + 12]) / lllllllllllllIIllIlIIllIlllIIIll[lllllllllllllIIllIlIIllIlllIIlIl + 0];
        }
    }
    
    public final void setM03(final double lllllllllllllIIllIlIIIllIIlllllI) {
        this.m03 = lllllllllllllIIllIlIIIllIIlllllI;
    }
    
    public final void setM13(final double lllllllllllllIIllIlIIIllIIllIlll) {
        this.m13 = lllllllllllllIIllIlIIIllIIllIlll;
    }
    
    public final double getM33() {
        return this.m33;
    }
    
    public final void add(final double lllllllllllllIIllIlIlIIIIIIlllII) {
        this.m00 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m01 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m02 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m03 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m10 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m11 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m12 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m13 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m20 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m21 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m22 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m23 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m30 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m31 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m32 += lllllllllllllIIllIlIlIIIIIIlllII;
        this.m33 += lllllllllllllIIllIlIlIIIIIIlllII;
    }
    
    public final void transform(final Vector3f lllllllllllllIIllIlIIlIIIIIllIIl) {
        final float lllllllllllllIIllIlIIlIIIIIllIII = (float)(this.m00 * lllllllllllllIIllIlIIlIIIIIllIIl.x + this.m01 * lllllllllllllIIllIlIIlIIIIIllIIl.y + this.m02 * lllllllllllllIIllIlIIlIIIIIllIIl.z);
        final float lllllllllllllIIllIlIIlIIIIIlIlll = (float)(this.m10 * lllllllllllllIIllIlIIlIIIIIllIIl.x + this.m11 * lllllllllllllIIllIlIIlIIIIIllIIl.y + this.m12 * lllllllllllllIIllIlIIlIIIIIllIIl.z);
        lllllllllllllIIllIlIIlIIIIIllIIl.z = (float)(this.m20 * lllllllllllllIIllIlIIlIIIIIllIIl.x + this.m21 * lllllllllllllIIllIlIIlIIIIIllIIl.y + this.m22 * lllllllllllllIIllIlIIlIIIIIllIIl.z);
        lllllllllllllIIllIlIIlIIIIIllIIl.x = lllllllllllllIIllIlIIlIIIIIllIII;
        lllllllllllllIIllIlIIlIIIIIllIIl.y = lllllllllllllIIllIlIIlIIIIIlIlll;
    }
    
    public final double getM12() {
        return this.m12;
    }
    
    public final void getColumn(final int lllllllllllllIIllIlIlIIlIIllIIll, final Vector4d lllllllllllllIIllIlIlIIlIIllIlIl) {
        if (lllllllllllllIIllIlIlIIlIIllIIll == 0) {
            lllllllllllllIIllIlIlIIlIIllIlIl.x = this.m00;
            lllllllllllllIIllIlIlIIlIIllIlIl.y = this.m10;
            lllllllllllllIIllIlIlIIlIIllIlIl.z = this.m20;
            lllllllllllllIIllIlIlIIlIIllIlIl.w = this.m30;
        }
        else if (lllllllllllllIIllIlIlIIlIIllIIll == 1) {
            lllllllllllllIIllIlIlIIlIIllIlIl.x = this.m01;
            lllllllllllllIIllIlIlIIlIIllIlIl.y = this.m11;
            lllllllllllllIIllIlIlIIlIIllIlIl.z = this.m21;
            lllllllllllllIIllIlIlIIlIIllIlIl.w = this.m31;
        }
        else if (lllllllllllllIIllIlIlIIlIIllIIll == 2) {
            lllllllllllllIIllIlIlIIlIIllIlIl.x = this.m02;
            lllllllllllllIIllIlIlIIlIIllIlIl.y = this.m12;
            lllllllllllllIIllIlIlIIlIIllIlIl.z = this.m22;
            lllllllllllllIIllIlIlIIlIIllIlIl.w = this.m32;
        }
        else {
            if (lllllllllllllIIllIlIlIIlIIllIIll != 3) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d3"));
            }
            lllllllllllllIIllIlIlIIlIIllIlIl.x = this.m03;
            lllllllllllllIIllIlIlIIlIIllIlIl.y = this.m13;
            lllllllllllllIIllIlIlIIlIIllIlIl.z = this.m23;
            lllllllllllllIIllIlIlIIlIIllIlIl.w = this.m33;
        }
    }
    
    public final void transform(final Tuple4f lllllllllllllIIllIlIIlIIlIIllIII, final Tuple4f lllllllllllllIIllIlIIlIIlIIlIlll) {
        final float lllllllllllllIIllIlIIlIIlIIlIllI = (float)(this.m00 * lllllllllllllIIllIlIIlIIlIIllIII.x + this.m01 * lllllllllllllIIllIlIIlIIlIIllIII.y + this.m02 * lllllllllllllIIllIlIIlIIlIIllIII.z + this.m03 * lllllllllllllIIllIlIIlIIlIIllIII.w);
        final float lllllllllllllIIllIlIIlIIlIIlIlIl = (float)(this.m10 * lllllllllllllIIllIlIIlIIlIIllIII.x + this.m11 * lllllllllllllIIllIlIIlIIlIIllIII.y + this.m12 * lllllllllllllIIllIlIIlIIlIIllIII.z + this.m13 * lllllllllllllIIllIlIIlIIlIIllIII.w);
        final float lllllllllllllIIllIlIIlIIlIIlIlII = (float)(this.m20 * lllllllllllllIIllIlIIlIIlIIllIII.x + this.m21 * lllllllllllllIIllIlIIlIIlIIllIII.y + this.m22 * lllllllllllllIIllIlIIlIIlIIllIII.z + this.m23 * lllllllllllllIIllIlIIlIIlIIllIII.w);
        lllllllllllllIIllIlIIlIIlIIlIlll.w = (float)(this.m30 * lllllllllllllIIllIlIIlIIlIIllIII.x + this.m31 * lllllllllllllIIllIlIIlIIlIIllIII.y + this.m32 * lllllllllllllIIllIlIIlIIlIIllIII.z + this.m33 * lllllllllllllIIllIlIIlIIlIIllIII.w);
        lllllllllllllIIllIlIIlIIlIIlIlll.x = lllllllllllllIIllIlIIlIIlIIlIllI;
        lllllllllllllIIllIlIIlIIlIIlIlll.y = lllllllllllllIIllIlIIlIIlIIlIlIl;
        lllllllllllllIIllIlIIlIIlIIlIlll.z = lllllllllllllIIllIlIIlIIlIIlIlII;
    }
    
    public final double getM00() {
        return this.m00;
    }
    
    public final void transpose() {
        double lllllllllllllIIllIlIIlllllllIIIl = this.m10;
        this.m10 = this.m01;
        this.m01 = lllllllllllllIIllIlIIlllllllIIIl;
        lllllllllllllIIllIlIIlllllllIIIl = this.m20;
        this.m20 = this.m02;
        this.m02 = lllllllllllllIIllIlIIlllllllIIIl;
        lllllllllllllIIllIlIIlllllllIIIl = this.m30;
        this.m30 = this.m03;
        this.m03 = lllllllllllllIIllIlIIlllllllIIIl;
        lllllllllllllIIllIlIIlllllllIIIl = this.m21;
        this.m21 = this.m12;
        this.m12 = lllllllllllllIIllIlIIlllllllIIIl;
        lllllllllllllIIllIlIIlllllllIIIl = this.m31;
        this.m31 = this.m13;
        this.m13 = lllllllllllllIIllIlIIlllllllIIIl;
        lllllllllllllIIllIlIIlllllllIIIl = this.m32;
        this.m32 = this.m23;
        this.m23 = lllllllllllllIIllIlIIlllllllIIIl;
    }
    
    public final void get(final Quat4d lllllllllllllIIllIlIlIIIlIlIIlIl) {
        final double[] lllllllllllllIIllIlIlIIIlIlIIlII = new double[9];
        final double[] lllllllllllllIIllIlIlIIIlIlIIIll = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIlIIIlIlIIIll, lllllllllllllIIllIlIlIIIlIlIIlII);
        double lllllllllllllIIllIlIlIIIlIlIIIlI = 0.25 * (1.0 + lllllllllllllIIllIlIlIIIlIlIIlII[0] + lllllllllllllIIllIlIlIIIlIlIIlII[4] + lllllllllllllIIllIlIlIIIlIlIIlII[8]);
        if (((lllllllllllllIIllIlIlIIIlIlIIIlI < 0.0) ? (-lllllllllllllIIllIlIlIIIlIlIIIlI) : lllllllllllllIIllIlIlIIIlIlIIIlI) >= 1.0E-30) {
            lllllllllllllIIllIlIlIIIlIlIIlIl.w = Math.sqrt(lllllllllllllIIllIlIlIIIlIlIIIlI);
            lllllllllllllIIllIlIlIIIlIlIIIlI = 0.25 / lllllllllllllIIllIlIlIIIlIlIIlIl.w;
            lllllllllllllIIllIlIlIIIlIlIIlIl.x = (lllllllllllllIIllIlIlIIIlIlIIlII[7] - lllllllllllllIIllIlIlIIIlIlIIlII[5]) * lllllllllllllIIllIlIlIIIlIlIIIlI;
            lllllllllllllIIllIlIlIIIlIlIIlIl.y = (lllllllllllllIIllIlIlIIIlIlIIlII[2] - lllllllllllllIIllIlIlIIIlIlIIlII[6]) * lllllllllllllIIllIlIlIIIlIlIIIlI;
            lllllllllllllIIllIlIlIIIlIlIIlIl.z = (lllllllllllllIIllIlIlIIIlIlIIlII[3] - lllllllllllllIIllIlIlIIIlIlIIlII[1]) * lllllllllllllIIllIlIlIIIlIlIIIlI;
            return;
        }
        lllllllllllllIIllIlIlIIIlIlIIlIl.w = 0.0;
        lllllllllllllIIllIlIlIIIlIlIIIlI = -0.5 * (lllllllllllllIIllIlIlIIIlIlIIlII[4] + lllllllllllllIIllIlIlIIIlIlIIlII[8]);
        if (((lllllllllllllIIllIlIlIIIlIlIIIlI < 0.0) ? (-lllllllllllllIIllIlIlIIIlIlIIIlI) : lllllllllllllIIllIlIlIIIlIlIIIlI) >= 1.0E-30) {
            lllllllllllllIIllIlIlIIIlIlIIlIl.x = Math.sqrt(lllllllllllllIIllIlIlIIIlIlIIIlI);
            lllllllllllllIIllIlIlIIIlIlIIIlI = 0.5 / lllllllllllllIIllIlIlIIIlIlIIlIl.x;
            lllllllllllllIIllIlIlIIIlIlIIlIl.y = lllllllllllllIIllIlIlIIIlIlIIlII[3] * lllllllllllllIIllIlIlIIIlIlIIIlI;
            lllllllllllllIIllIlIlIIIlIlIIlIl.z = lllllllllllllIIllIlIlIIIlIlIIlII[6] * lllllllllllllIIllIlIlIIIlIlIIIlI;
            return;
        }
        lllllllllllllIIllIlIlIIIlIlIIlIl.x = 0.0;
        lllllllllllllIIllIlIlIIIlIlIIIlI = 0.5 * (1.0 - lllllllllllllIIllIlIlIIIlIlIIlII[8]);
        if (((lllllllllllllIIllIlIlIIIlIlIIIlI < 0.0) ? (-lllllllllllllIIllIlIlIIIlIlIIIlI) : lllllllllllllIIllIlIlIIIlIlIIIlI) >= 1.0E-30) {
            lllllllllllllIIllIlIlIIIlIlIIlIl.y = Math.sqrt(lllllllllllllIIllIlIlIIIlIlIIIlI);
            lllllllllllllIIllIlIlIIIlIlIIlIl.z = lllllllllllllIIllIlIlIIIlIlIIlII[7] / (2.0 * lllllllllllllIIllIlIlIIIlIlIIlIl.y);
            return;
        }
        lllllllllllllIIllIlIlIIIlIlIIlIl.y = 0.0;
        lllllllllllllIIllIlIlIIIlIlIIlIl.z = 1.0;
    }
    
    public final void setIdentity() {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void setM20(final double lllllllllllllIIllIlIIIllIlIllIll) {
        this.m20 = lllllllllllllIIllIlIIIllIlIllIll;
    }
    
    public final void setRotation(final AxisAngle4d lllllllllllllIIllIlIIIllllIlIIll) {
        final double[] lllllllllllllIIllIlIIIllllIlIIlI = new double[9];
        final double[] lllllllllllllIIllIlIIIllllIlIIIl = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIIIllllIlIIIl, lllllllllllllIIllIlIIIllllIlIIlI);
        final double lllllllllllllIIllIlIIIllllIlIIII = 1.0 / Math.sqrt(lllllllllllllIIllIlIIIllllIlIIll.x * lllllllllllllIIllIlIIIllllIlIIll.x + lllllllllllllIIllIlIIIllllIlIIll.y * lllllllllllllIIllIlIIIllllIlIIll.y + lllllllllllllIIllIlIIIllllIlIIll.z * lllllllllllllIIllIlIIIllllIlIIll.z);
        final double lllllllllllllIIllIlIIIllllIIllll = lllllllllllllIIllIlIIIllllIlIIll.x * lllllllllllllIIllIlIIIllllIlIIII;
        final double lllllllllllllIIllIlIIIllllIIlllI = lllllllllllllIIllIlIIIllllIlIIll.y * lllllllllllllIIllIlIIIllllIlIIII;
        final double lllllllllllllIIllIlIIIllllIIllIl = lllllllllllllIIllIlIIIllllIlIIll.z * lllllllllllllIIllIlIIIllllIlIIII;
        final double lllllllllllllIIllIlIIIllllIIllII = Math.sin(lllllllllllllIIllIlIIIllllIlIIll.angle);
        final double lllllllllllllIIllIlIIIllllIIlIll = Math.cos(lllllllllllllIIllIlIIIllllIlIIll.angle);
        final double lllllllllllllIIllIlIIIllllIIlIlI = 1.0 - lllllllllllllIIllIlIIIllllIIlIll;
        final double lllllllllllllIIllIlIIIllllIIlIIl = lllllllllllllIIllIlIIIllllIlIIll.x * lllllllllllllIIllIlIIIllllIlIIll.z;
        final double lllllllllllllIIllIlIIIllllIIlIII = lllllllllllllIIllIlIIIllllIlIIll.x * lllllllllllllIIllIlIIIllllIlIIll.y;
        final double lllllllllllllIIllIlIIIllllIIIlll = lllllllllllllIIllIlIIIllllIlIIll.y * lllllllllllllIIllIlIIIllllIlIIll.z;
        this.m00 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIllll * lllllllllllllIIllIlIIIllllIIllll + lllllllllllllIIllIlIIIllllIIlIll) * lllllllllllllIIllIlIIIllllIlIIIl[0];
        this.m01 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIlIII - lllllllllllllIIllIlIIIllllIIllII * lllllllllllllIIllIlIIIllllIIllIl) * lllllllllllllIIllIlIIIllllIlIIIl[1];
        this.m02 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIlIIl + lllllllllllllIIllIlIIIllllIIllII * lllllllllllllIIllIlIIIllllIIlllI) * lllllllllllllIIllIlIIIllllIlIIIl[2];
        this.m10 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIlIII + lllllllllllllIIllIlIIIllllIIllII * lllllllllllllIIllIlIIIllllIIllIl) * lllllllllllllIIllIlIIIllllIlIIIl[0];
        this.m11 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIlllI * lllllllllllllIIllIlIIIllllIIlllI + lllllllllllllIIllIlIIIllllIIlIll) * lllllllllllllIIllIlIIIllllIlIIIl[1];
        this.m12 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIIlll - lllllllllllllIIllIlIIIllllIIllII * lllllllllllllIIllIlIIIllllIIllll) * lllllllllllllIIllIlIIIllllIlIIIl[2];
        this.m20 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIlIIl - lllllllllllllIIllIlIIIllllIIllII * lllllllllllllIIllIlIIIllllIIlllI) * lllllllllllllIIllIlIIIllllIlIIIl[0];
        this.m21 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIIlll + lllllllllllllIIllIlIIIllllIIllII * lllllllllllllIIllIlIIIllllIIllll) * lllllllllllllIIllIlIIIllllIlIIIl[1];
        this.m22 = (lllllllllllllIIllIlIIIllllIIlIlI * lllllllllllllIIllIlIIIllllIIllIl * lllllllllllllIIllIlIIIllllIIllIl + lllllllllllllIIllIlIIIllllIIlIll) * lllllllllllllIIllIlIIIllllIlIIIl[2];
    }
    
    public final void set(final Matrix3d lllllllllllllIIllIlIIlllllIllIIl) {
        this.m00 = lllllllllllllIIllIlIIlllllIllIIl.m00;
        this.m01 = lllllllllllllIIllIlIIlllllIllIIl.m01;
        this.m02 = lllllllllllllIIllIlIIlllllIllIIl.m02;
        this.m03 = 0.0;
        this.m10 = lllllllllllllIIllIlIIlllllIllIIl.m10;
        this.m11 = lllllllllllllIIllIlIIlllllIllIIl.m11;
        this.m12 = lllllllllllllIIllIlIIlllllIllIIl.m12;
        this.m13 = 0.0;
        this.m20 = lllllllllllllIIllIlIIlllllIllIIl.m20;
        this.m21 = lllllllllllllIIllIlIIlllllIllIIl.m21;
        this.m22 = lllllllllllllIIllIlIIlllllIllIIl.m22;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final double getM11() {
        return this.m11;
    }
    
    public final void get(final Vector3d lllllllllllllIIllIlIlIIIlIIllIIl) {
        lllllllllllllIIllIlIlIIIlIIllIIl.x = this.m03;
        lllllllllllllIIllIlIlIIIlIIllIIl.y = this.m13;
        lllllllllllllIIllIlIlIIIlIIllIIl.z = this.m23;
    }
    
    public final void add(final Matrix4d lllllllllllllIIllIlIlIIIIIIIlIll, final Matrix4d lllllllllllllIIllIlIlIIIIIIIllIl) {
        this.m00 = lllllllllllllIIllIlIlIIIIIIIlIll.m00 + lllllllllllllIIllIlIlIIIIIIIllIl.m00;
        this.m01 = lllllllllllllIIllIlIlIIIIIIIlIll.m01 + lllllllllllllIIllIlIlIIIIIIIllIl.m01;
        this.m02 = lllllllllllllIIllIlIlIIIIIIIlIll.m02 + lllllllllllllIIllIlIlIIIIIIIllIl.m02;
        this.m03 = lllllllllllllIIllIlIlIIIIIIIlIll.m03 + lllllllllllllIIllIlIlIIIIIIIllIl.m03;
        this.m10 = lllllllllllllIIllIlIlIIIIIIIlIll.m10 + lllllllllllllIIllIlIlIIIIIIIllIl.m10;
        this.m11 = lllllllllllllIIllIlIlIIIIIIIlIll.m11 + lllllllllllllIIllIlIlIIIIIIIllIl.m11;
        this.m12 = lllllllllllllIIllIlIlIIIIIIIlIll.m12 + lllllllllllllIIllIlIlIIIIIIIllIl.m12;
        this.m13 = lllllllllllllIIllIlIlIIIIIIIlIll.m13 + lllllllllllllIIllIlIlIIIIIIIllIl.m13;
        this.m20 = lllllllllllllIIllIlIlIIIIIIIlIll.m20 + lllllllllllllIIllIlIlIIIIIIIllIl.m20;
        this.m21 = lllllllllllllIIllIlIlIIIIIIIlIll.m21 + lllllllllllllIIllIlIlIIIIIIIllIl.m21;
        this.m22 = lllllllllllllIIllIlIlIIIIIIIlIll.m22 + lllllllllllllIIllIlIlIIIIIIIllIl.m22;
        this.m23 = lllllllllllllIIllIlIlIIIIIIIlIll.m23 + lllllllllllllIIllIlIlIIIIIIIllIl.m23;
        this.m30 = lllllllllllllIIllIlIlIIIIIIIlIll.m30 + lllllllllllllIIllIlIlIIIIIIIllIl.m30;
        this.m31 = lllllllllllllIIllIlIlIIIIIIIlIll.m31 + lllllllllllllIIllIlIlIIIIIIIllIl.m31;
        this.m32 = lllllllllllllIIllIlIlIIIIIIIlIll.m32 + lllllllllllllIIllIlIlIIIIIIIllIl.m32;
        this.m33 = lllllllllllllIIllIlIlIIIIIIIlIll.m33 + lllllllllllllIIllIlIlIIIIIIIllIl.m33;
    }
    
    public final void transform(final Point3d lllllllllllllIIllIlIIlIIIllIlIlI) {
        final double lllllllllllllIIllIlIIlIIIllIlIIl = this.m00 * lllllllllllllIIllIlIIlIIIllIlIlI.x + this.m01 * lllllllllllllIIllIlIIlIIIllIlIlI.y + this.m02 * lllllllllllllIIllIlIIlIIIllIlIlI.z + this.m03;
        final double lllllllllllllIIllIlIIlIIIllIlIII = this.m10 * lllllllllllllIIllIlIIlIIIllIlIlI.x + this.m11 * lllllllllllllIIllIlIIlIIIllIlIlI.y + this.m12 * lllllllllllllIIllIlIIlIIIllIlIlI.z + this.m13;
        lllllllllllllIIllIlIIlIIIllIlIlI.z = this.m20 * lllllllllllllIIllIlIIlIIIllIlIlI.x + this.m21 * lllllllllllllIIllIlIIlIIIllIlIlI.y + this.m22 * lllllllllllllIIllIlIIlIIIllIlIlI.z + this.m23;
        lllllllllllllIIllIlIIlIIIllIlIlI.x = lllllllllllllIIllIlIIlIIIllIlIIl;
        lllllllllllllIIllIlIIlIIIllIlIlI.y = lllllllllllllIIllIlIIlIIIllIlIII;
    }
    
    public final void transform(final Point3f lllllllllllllIIllIlIIlIIIlIIlIll) {
        final float lllllllllllllIIllIlIIlIIIlIIlllI = (float)(this.m00 * lllllllllllllIIllIlIIlIIIlIIlIll.x + this.m01 * lllllllllllllIIllIlIIlIIIlIIlIll.y + this.m02 * lllllllllllllIIllIlIIlIIIlIIlIll.z + this.m03);
        final float lllllllllllllIIllIlIIlIIIlIIllIl = (float)(this.m10 * lllllllllllllIIllIlIIlIIIlIIlIll.x + this.m11 * lllllllllllllIIllIlIIlIIIlIIlIll.y + this.m12 * lllllllllllllIIllIlIIlIIIlIIlIll.z + this.m13);
        lllllllllllllIIllIlIIlIIIlIIlIll.z = (float)(this.m20 * lllllllllllllIIllIlIIlIIIlIIlIll.x + this.m21 * lllllllllllllIIllIlIIlIIIlIIlIll.y + this.m22 * lllllllllllllIIllIlIIlIIIlIIlIll.z + this.m23);
        lllllllllllllIIllIlIIlIIIlIIlIll.x = lllllllllllllIIllIlIIlIIIlIIlllI;
        lllllllllllllIIllIlIIlIIIlIIlIll.y = lllllllllllllIIllIlIIlIIIlIIllIl;
    }
    
    public final void setM02(final double lllllllllllllIIllIlIIIllIlllllll) {
        this.m02 = lllllllllllllIIllIlIIIllIlllllll;
    }
    
    public Object clone() {
        Matrix4d lllllllllllllIIllIlIIIlllIIlllII = null;
        try {
            lllllllllllllIIllIlIIIlllIIlllII = (Matrix4d)super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIIllIlIIIlllIIllIll) {
            throw new InternalError();
        }
        return lllllllllllllIIllIlIIIlllIIlllII;
    }
    
    public final void invert(final Matrix4d lllllllllllllIIllIlIIlllIlIIllIl) {
        this.invertGeneral(lllllllllllllIIllIlIIlllIlIIllIl);
    }
    
    public final void setM22(final double lllllllllllllIIllIlIIIllIlIIIlll) {
        this.m22 = lllllllllllllIIllIlIIIllIlIIIlll;
    }
    
    public final void transform(final Vector3d lllllllllllllIIllIlIIlIIIlIIIIlI, final Vector3d lllllllllllllIIllIlIIlIIIlIIIIIl) {
        final double lllllllllllllIIllIlIIlIIIlIIIIII = this.m00 * lllllllllllllIIllIlIIlIIIlIIIIlI.x + this.m01 * lllllllllllllIIllIlIIlIIIlIIIIlI.y + this.m02 * lllllllllllllIIllIlIIlIIIlIIIIlI.z;
        final double lllllllllllllIIllIlIIlIIIIllllll = this.m10 * lllllllllllllIIllIlIIlIIIlIIIIlI.x + this.m11 * lllllllllllllIIllIlIIlIIIlIIIIlI.y + this.m12 * lllllllllllllIIllIlIIlIIIlIIIIlI.z;
        lllllllllllllIIllIlIIlIIIlIIIIIl.z = this.m20 * lllllllllllllIIllIlIIlIIIlIIIIlI.x + this.m21 * lllllllllllllIIllIlIIlIIIlIIIIlI.y + this.m22 * lllllllllllllIIllIlIIlIIIlIIIIlI.z;
        lllllllllllllIIllIlIIlIIIlIIIIIl.x = lllllllllllllIIllIlIIlIIIlIIIIII;
        lllllllllllllIIllIlIIlIIIlIIIIIl.y = lllllllllllllIIllIlIIlIIIIllllll;
    }
    
    public Matrix4d(final Matrix3d lllllllllllllIIllIlIlIIlIlllIIIl, final Vector3d lllllllllllllIIllIlIlIIlIlllIIII, final double lllllllllllllIIllIlIlIIlIllIlIll) {
        this.m00 = lllllllllllllIIllIlIlIIlIlllIIIl.m00 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m01 = lllllllllllllIIllIlIlIIlIlllIIIl.m01 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m02 = lllllllllllllIIllIlIlIIlIlllIIIl.m02 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m03 = lllllllllllllIIllIlIlIIlIlllIIII.x;
        this.m10 = lllllllllllllIIllIlIlIIlIlllIIIl.m10 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m11 = lllllllllllllIIllIlIlIIlIlllIIIl.m11 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m12 = lllllllllllllIIllIlIlIIlIlllIIIl.m12 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m13 = lllllllllllllIIllIlIlIIlIlllIIII.y;
        this.m20 = lllllllllllllIIllIlIlIIlIlllIIIl.m20 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m21 = lllllllllllllIIllIlIlIIlIlllIIIl.m21 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m22 = lllllllllllllIIllIlIlIIlIlllIIIl.m22 * lllllllllllllIIllIlIlIIlIllIlIll;
        this.m23 = lllllllllllllIIllIlIlIIlIlllIIII.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final double getM22() {
        return this.m22;
    }
    
    public final void setM00(final double lllllllllllllIIllIlIIIlllIIIllll) {
        this.m00 = lllllllllllllIIllIlIIIlllIIIllll;
    }
    
    public final void setColumn(final int lllllllllllllIIllIlIlIIIIIlllllI, final double lllllllllllllIIllIlIlIIIIIllllIl, final double lllllllllllllIIllIlIlIIIIIllIllI, final double lllllllllllllIIllIlIlIIIIIlllIll, final double lllllllllllllIIllIlIlIIIIIlllIlI) {
        switch (lllllllllllllIIllIlIlIIIIIlllllI) {
            case 0: {
                this.m00 = lllllllllllllIIllIlIlIIIIIllllIl;
                this.m10 = lllllllllllllIIllIlIlIIIIIllIllI;
                this.m20 = lllllllllllllIIllIlIlIIIIIlllIll;
                this.m30 = lllllllllllllIIllIlIlIIIIIlllIlI;
                break;
            }
            case 1: {
                this.m01 = lllllllllllllIIllIlIlIIIIIllllIl;
                this.m11 = lllllllllllllIIllIlIlIIIIIllIllI;
                this.m21 = lllllllllllllIIllIlIlIIIIIlllIll;
                this.m31 = lllllllllllllIIllIlIlIIIIIlllIlI;
                break;
            }
            case 2: {
                this.m02 = lllllllllllllIIllIlIlIIIIIllllIl;
                this.m12 = lllllllllllllIIllIlIlIIIIIllIllI;
                this.m22 = lllllllllllllIIllIlIlIIIIIlllIll;
                this.m32 = lllllllllllllIIllIlIlIIIIIlllIlI;
                break;
            }
            case 3: {
                this.m03 = lllllllllllllIIllIlIlIIIIIllllIl;
                this.m13 = lllllllllllllIIllIlIlIIIIIllIllI;
                this.m23 = lllllllllllllIIllIlIlIIIIIlllIll;
                this.m33 = lllllllllllllIIllIlIlIIIIIlllIlI;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
            }
        }
    }
    
    public final void set(final Matrix4d lllllllllllllIIllIlIIlllIlIlIIll) {
        this.m00 = lllllllllllllIIllIlIIlllIlIlIIll.m00;
        this.m01 = lllllllllllllIIllIlIIlllIlIlIIll.m01;
        this.m02 = lllllllllllllIIllIlIIlllIlIlIIll.m02;
        this.m03 = lllllllllllllIIllIlIIlllIlIlIIll.m03;
        this.m10 = lllllllllllllIIllIlIIlllIlIlIIll.m10;
        this.m11 = lllllllllllllIIllIlIIlllIlIlIIll.m11;
        this.m12 = lllllllllllllIIllIlIIlllIlIlIIll.m12;
        this.m13 = lllllllllllllIIllIlIIlllIlIlIIll.m13;
        this.m20 = lllllllllllllIIllIlIIlllIlIlIIll.m20;
        this.m21 = lllllllllllllIIllIlIIlllIlIlIIll.m21;
        this.m22 = lllllllllllllIIllIlIIlllIlIlIIll.m22;
        this.m23 = lllllllllllllIIllIlIIlllIlIlIIll.m23;
        this.m30 = lllllllllllllIIllIlIIlllIlIlIIll.m30;
        this.m31 = lllllllllllllIIllIlIIlllIlIlIIll.m31;
        this.m32 = lllllllllllllIIllIlIIlllIlIlIIll.m32;
        this.m33 = lllllllllllllIIllIlIIlllIlIlIIll.m33;
    }
    
    public final void sub(final Matrix4d lllllllllllllIIllIlIIlllllllllII, final Matrix4d lllllllllllllIIllIlIIllllllllIll) {
        this.m00 = lllllllllllllIIllIlIIlllllllllII.m00 - lllllllllllllIIllIlIIllllllllIll.m00;
        this.m01 = lllllllllllllIIllIlIIlllllllllII.m01 - lllllllllllllIIllIlIIllllllllIll.m01;
        this.m02 = lllllllllllllIIllIlIIlllllllllII.m02 - lllllllllllllIIllIlIIllllllllIll.m02;
        this.m03 = lllllllllllllIIllIlIIlllllllllII.m03 - lllllllllllllIIllIlIIllllllllIll.m03;
        this.m10 = lllllllllllllIIllIlIIlllllllllII.m10 - lllllllllllllIIllIlIIllllllllIll.m10;
        this.m11 = lllllllllllllIIllIlIIlllllllllII.m11 - lllllllllllllIIllIlIIllllllllIll.m11;
        this.m12 = lllllllllllllIIllIlIIlllllllllII.m12 - lllllllllllllIIllIlIIllllllllIll.m12;
        this.m13 = lllllllllllllIIllIlIIlllllllllII.m13 - lllllllllllllIIllIlIIllllllllIll.m13;
        this.m20 = lllllllllllllIIllIlIIlllllllllII.m20 - lllllllllllllIIllIlIIllllllllIll.m20;
        this.m21 = lllllllllllllIIllIlIIlllllllllII.m21 - lllllllllllllIIllIlIIllllllllIll.m21;
        this.m22 = lllllllllllllIIllIlIIlllllllllII.m22 - lllllllllllllIIllIlIIllllllllIll.m22;
        this.m23 = lllllllllllllIIllIlIIlllllllllII.m23 - lllllllllllllIIllIlIIllllllllIll.m23;
        this.m30 = lllllllllllllIIllIlIIlllllllllII.m30 - lllllllllllllIIllIlIIllllllllIll.m30;
        this.m31 = lllllllllllllIIllIlIIlllllllllII.m31 - lllllllllllllIIllIlIIllllllllIll.m31;
        this.m32 = lllllllllllllIIllIlIIlllllllllII.m32 - lllllllllllllIIllIlIIllllllllIll.m32;
        this.m33 = lllllllllllllIIllIlIIlllllllllII.m33 - lllllllllllllIIllIlIIllllllllIll.m33;
    }
    
    public final void setM31(final double lllllllllllllIIllIlIIIllIIIlllII) {
        this.m31 = lllllllllllllIIllIlIIIllIIIlllII;
    }
    
    public final void set(final Quat4f lllllllllllllIIllIlIIlllIllIIlIl, final Vector3f lllllllllllllIIllIlIIlllIllIIlII, final float lllllllllllllIIllIlIIlllIlIlllll) {
        this.m00 = lllllllllllllIIllIlIIlllIlIlllll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllIIlIl.y * lllllllllllllIIllIlIIlllIllIIlIl.y - 2.0 * lllllllllllllIIllIlIIlllIllIIlIl.z * lllllllllllllIIllIlIIlllIllIIlIl.z);
        this.m10 = lllllllllllllIIllIlIIlllIlIlllll * (2.0 * (lllllllllllllIIllIlIIlllIllIIlIl.x * lllllllllllllIIllIlIIlllIllIIlIl.y + lllllllllllllIIllIlIIlllIllIIlIl.w * lllllllllllllIIllIlIIlllIllIIlIl.z));
        this.m20 = lllllllllllllIIllIlIIlllIlIlllll * (2.0 * (lllllllllllllIIllIlIIlllIllIIlIl.x * lllllllllllllIIllIlIIlllIllIIlIl.z - lllllllllllllIIllIlIIlllIllIIlIl.w * lllllllllllllIIllIlIIlllIllIIlIl.y));
        this.m01 = lllllllllllllIIllIlIIlllIlIlllll * (2.0 * (lllllllllllllIIllIlIIlllIllIIlIl.x * lllllllllllllIIllIlIIlllIllIIlIl.y - lllllllllllllIIllIlIIlllIllIIlIl.w * lllllllllllllIIllIlIIlllIllIIlIl.z));
        this.m11 = lllllllllllllIIllIlIIlllIlIlllll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllIIlIl.x * lllllllllllllIIllIlIIlllIllIIlIl.x - 2.0 * lllllllllllllIIllIlIIlllIllIIlIl.z * lllllllllllllIIllIlIIlllIllIIlIl.z);
        this.m21 = lllllllllllllIIllIlIIlllIlIlllll * (2.0 * (lllllllllllllIIllIlIIlllIllIIlIl.y * lllllllllllllIIllIlIIlllIllIIlIl.z + lllllllllllllIIllIlIIlllIllIIlIl.w * lllllllllllllIIllIlIIlllIllIIlIl.x));
        this.m02 = lllllllllllllIIllIlIIlllIlIlllll * (2.0 * (lllllllllllllIIllIlIIlllIllIIlIl.x * lllllllllllllIIllIlIIlllIllIIlIl.z + lllllllllllllIIllIlIIlllIllIIlIl.w * lllllllllllllIIllIlIIlllIllIIlIl.y));
        this.m12 = lllllllllllllIIllIlIIlllIlIlllll * (2.0 * (lllllllllllllIIllIlIIlllIllIIlIl.y * lllllllllllllIIllIlIIlllIllIIlIl.z - lllllllllllllIIllIlIIlllIllIIlIl.w * lllllllllllllIIllIlIIlllIllIIlIl.x));
        this.m22 = lllllllllllllIIllIlIIlllIlIlllll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllIIlIl.x * lllllllllllllIIllIlIIlllIllIIlIl.x - 2.0 * lllllllllllllIIllIlIIlllIllIIlIl.y * lllllllllllllIIllIlIIlllIllIIlIl.y);
        this.m03 = lllllllllllllIIllIlIIlllIllIIlII.x;
        this.m13 = lllllllllllllIIllIlIIlllIllIIlII.y;
        this.m23 = lllllllllllllIIllIlIIlllIllIIlII.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
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
    
    public final double getM21() {
        return this.m21;
    }
    
    public Matrix4d(final Quat4f lllllllllllllIIllIlIlIIllIIlIIIl, final Vector3d lllllllllllllIIllIlIlIIllIIlIIII, final double lllllllllllllIIllIlIlIIllIIlIIll) {
        this.m00 = lllllllllllllIIllIlIlIIllIIlIIll * (1.0 - 2.0 * lllllllllllllIIllIlIlIIllIIlIIIl.y * lllllllllllllIIllIlIlIIllIIlIIIl.y - 2.0 * lllllllllllllIIllIlIlIIllIIlIIIl.z * lllllllllllllIIllIlIlIIllIIlIIIl.z);
        this.m10 = lllllllllllllIIllIlIlIIllIIlIIll * (2.0 * (lllllllllllllIIllIlIlIIllIIlIIIl.x * lllllllllllllIIllIlIlIIllIIlIIIl.y + lllllllllllllIIllIlIlIIllIIlIIIl.w * lllllllllllllIIllIlIlIIllIIlIIIl.z));
        this.m20 = lllllllllllllIIllIlIlIIllIIlIIll * (2.0 * (lllllllllllllIIllIlIlIIllIIlIIIl.x * lllllllllllllIIllIlIlIIllIIlIIIl.z - lllllllllllllIIllIlIlIIllIIlIIIl.w * lllllllllllllIIllIlIlIIllIIlIIIl.y));
        this.m01 = lllllllllllllIIllIlIlIIllIIlIIll * (2.0 * (lllllllllllllIIllIlIlIIllIIlIIIl.x * lllllllllllllIIllIlIlIIllIIlIIIl.y - lllllllllllllIIllIlIlIIllIIlIIIl.w * lllllllllllllIIllIlIlIIllIIlIIIl.z));
        this.m11 = lllllllllllllIIllIlIlIIllIIlIIll * (1.0 - 2.0 * lllllllllllllIIllIlIlIIllIIlIIIl.x * lllllllllllllIIllIlIlIIllIIlIIIl.x - 2.0 * lllllllllllllIIllIlIlIIllIIlIIIl.z * lllllllllllllIIllIlIlIIllIIlIIIl.z);
        this.m21 = lllllllllllllIIllIlIlIIllIIlIIll * (2.0 * (lllllllllllllIIllIlIlIIllIIlIIIl.y * lllllllllllllIIllIlIlIIllIIlIIIl.z + lllllllllllllIIllIlIlIIllIIlIIIl.w * lllllllllllllIIllIlIlIIllIIlIIIl.x));
        this.m02 = lllllllllllllIIllIlIlIIllIIlIIll * (2.0 * (lllllllllllllIIllIlIlIIllIIlIIIl.x * lllllllllllllIIllIlIlIIllIIlIIIl.z + lllllllllllllIIllIlIlIIllIIlIIIl.w * lllllllllllllIIllIlIlIIllIIlIIIl.y));
        this.m12 = lllllllllllllIIllIlIlIIllIIlIIll * (2.0 * (lllllllllllllIIllIlIlIIllIIlIIIl.y * lllllllllllllIIllIlIlIIllIIlIIIl.z - lllllllllllllIIllIlIlIIllIIlIIIl.w * lllllllllllllIIllIlIlIIllIIlIIIl.x));
        this.m22 = lllllllllllllIIllIlIlIIllIIlIIll * (1.0 - 2.0 * lllllllllllllIIllIlIlIIllIIlIIIl.x * lllllllllllllIIllIlIlIIllIIlIIIl.x - 2.0 * lllllllllllllIIllIlIlIIllIIlIIIl.y * lllllllllllllIIllIlIlIIllIIlIIIl.y);
        this.m03 = lllllllllllllIIllIlIlIIllIIlIIII.x;
        this.m13 = lllllllllllllIIllIlIlIIllIIlIIII.y;
        this.m23 = lllllllllllllIIllIlIlIIllIIlIIII.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void transpose(final Matrix4d lllllllllllllIIllIlIIllllllIlIIl) {
        if (this != lllllllllllllIIllIlIIllllllIlIIl) {
            this.m00 = lllllllllllllIIllIlIIllllllIlIIl.m00;
            this.m01 = lllllllllllllIIllIlIIllllllIlIIl.m10;
            this.m02 = lllllllllllllIIllIlIIllllllIlIIl.m20;
            this.m03 = lllllllllllllIIllIlIIllllllIlIIl.m30;
            this.m10 = lllllllllllllIIllIlIIllllllIlIIl.m01;
            this.m11 = lllllllllllllIIllIlIIllllllIlIIl.m11;
            this.m12 = lllllllllllllIIllIlIIllllllIlIIl.m21;
            this.m13 = lllllllllllllIIllIlIIllllllIlIIl.m31;
            this.m20 = lllllllllllllIIllIlIIllllllIlIIl.m02;
            this.m21 = lllllllllllllIIllIlIIllllllIlIIl.m12;
            this.m22 = lllllllllllllIIllIlIIllllllIlIIl.m22;
            this.m23 = lllllllllllllIIllIlIIllllllIlIIl.m32;
            this.m30 = lllllllllllllIIllIlIIllllllIlIIl.m03;
            this.m31 = lllllllllllllIIllIlIIllllllIlIIl.m13;
            this.m32 = lllllllllllllIIllIlIIllllllIlIIl.m23;
            this.m33 = lllllllllllllIIllIlIIllllllIlIIl.m33;
        }
        else {
            this.transpose();
        }
    }
    
    public final void setM12(final double lllllllllllllIIllIlIIIllIllIIlII) {
        this.m12 = lllllllllllllIIllIlIIIllIllIIlII;
    }
    
    public final void set(final double lllllllllllllIIllIlIIllIllIIllII) {
        this.m00 = lllllllllllllIIllIlIIllIllIIllII;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = 0.0;
        this.m10 = 0.0;
        this.m11 = lllllllllllllIIllIlIIllIllIIllII;
        this.m12 = 0.0;
        this.m13 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = lllllllllllllIIllIlIIllIllIIllII;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public boolean epsilonEquals(final Matrix4d lllllllllllllIIllIlIIlIIllIIlIIl, final double lllllllllllllIIllIlIIlIIllIIlIII) {
        double lllllllllllllIIllIlIIlIIllIIlIll = this.m00 - lllllllllllllIIllIlIIlIIllIIlIIl.m00;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m01 - lllllllllllllIIllIlIIlIIllIIlIIl.m01;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m02 - lllllllllllllIIllIlIIlIIllIIlIIl.m02;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m03 - lllllllllllllIIllIlIIlIIllIIlIIl.m03;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m10 - lllllllllllllIIllIlIIlIIllIIlIIl.m10;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m11 - lllllllllllllIIllIlIIlIIllIIlIIl.m11;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m12 - lllllllllllllIIllIlIIlIIllIIlIIl.m12;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m13 - lllllllllllllIIllIlIIlIIllIIlIIl.m13;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m20 - lllllllllllllIIllIlIIlIIllIIlIIl.m20;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m21 - lllllllllllllIIllIlIIlIIllIIlIIl.m21;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m22 - lllllllllllllIIllIlIIlIIllIIlIIl.m22;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m23 - lllllllllllllIIllIlIIlIIllIIlIIl.m23;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m30 - lllllllllllllIIllIlIIlIIllIIlIIl.m30;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m31 - lllllllllllllIIllIlIIlIIllIIlIIl.m31;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m32 - lllllllllllllIIllIlIIlIIllIIlIIl.m32;
        if (((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) > lllllllllllllIIllIlIIlIIllIIlIII) {
            return false;
        }
        lllllllllllllIIllIlIIlIIllIIlIll = this.m33 - lllllllllllllIIllIlIIlIIllIIlIIl.m33;
        return ((lllllllllllllIIllIlIIlIIllIIlIll < 0.0) ? (-lllllllllllllIIllIlIIlIIllIIlIll) : lllllllllllllIIllIlIIlIIllIIlIll) <= lllllllllllllIIllIlIIlIIllIIlIII;
    }
    
    final void invertGeneral(final Matrix4d lllllllllllllIIllIlIIlllIIllllII) {
        final double[] lllllllllllllIIllIlIIlllIlIIIIIl = new double[16];
        final int[] lllllllllllllIIllIlIIlllIlIIIIII = new int[4];
        final double[] lllllllllllllIIllIlIIlllIIlllllI = { lllllllllllllIIllIlIIlllIIllllII.m00, lllllllllllllIIllIlIIlllIIllllII.m01, lllllllllllllIIllIlIIlllIIllllII.m02, lllllllllllllIIllIlIIlllIIllllII.m03, lllllllllllllIIllIlIIlllIIllllII.m10, lllllllllllllIIllIlIIlllIIllllII.m11, lllllllllllllIIllIlIIlllIIllllII.m12, lllllllllllllIIllIlIIlllIIllllII.m13, lllllllllllllIIllIlIIlllIIllllII.m20, lllllllllllllIIllIlIIlllIIllllII.m21, lllllllllllllIIllIlIIlllIIllllII.m22, lllllllllllllIIllIlIIlllIIllllII.m23, lllllllllllllIIllIlIIlllIIllllII.m30, lllllllllllllIIllIlIIlllIIllllII.m31, lllllllllllllIIllIlIIlllIIllllII.m32, lllllllllllllIIllIlIIlllIIllllII.m33 };
        if (!luDecomposition(lllllllllllllIIllIlIIlllIIlllllI, lllllllllllllIIllIlIIlllIlIIIIII)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix4d10"));
        }
        for (int lllllllllllllIIllIlIIlllIIllllll = 0; lllllllllllllIIllIlIIlllIIllllll < 16; ++lllllllllllllIIllIlIIlllIIllllll) {
            lllllllllllllIIllIlIIlllIlIIIIIl[lllllllllllllIIllIlIIlllIIllllll] = 0.0;
        }
        lllllllllllllIIllIlIIlllIlIIIIIl[5] = (lllllllllllllIIllIlIIlllIlIIIIIl[0] = 1.0);
        lllllllllllllIIllIlIIlllIlIIIIIl[15] = (lllllllllllllIIllIlIIlllIlIIIIIl[10] = 1.0);
        luBacksubstitution(lllllllllllllIIllIlIIlllIIlllllI, lllllllllllllIIllIlIIlllIlIIIIII, lllllllllllllIIllIlIIlllIlIIIIIl);
        this.m00 = lllllllllllllIIllIlIIlllIlIIIIIl[0];
        this.m01 = lllllllllllllIIllIlIIlllIlIIIIIl[1];
        this.m02 = lllllllllllllIIllIlIIlllIlIIIIIl[2];
        this.m03 = lllllllllllllIIllIlIIlllIlIIIIIl[3];
        this.m10 = lllllllllllllIIllIlIIlllIlIIIIIl[4];
        this.m11 = lllllllllllllIIllIlIIlllIlIIIIIl[5];
        this.m12 = lllllllllllllIIllIlIIlllIlIIIIIl[6];
        this.m13 = lllllllllllllIIllIlIIlllIlIIIIIl[7];
        this.m20 = lllllllllllllIIllIlIIlllIlIIIIIl[8];
        this.m21 = lllllllllllllIIllIlIIlllIlIIIIIl[9];
        this.m22 = lllllllllllllIIllIlIIlllIlIIIIIl[10];
        this.m23 = lllllllllllllIIllIlIIlllIlIIIIIl[11];
        this.m30 = lllllllllllllIIllIlIIlllIlIIIIIl[12];
        this.m31 = lllllllllllllIIllIlIIlllIlIIIIIl[13];
        this.m32 = lllllllllllllIIllIlIIlllIlIIIIIl[14];
        this.m33 = lllllllllllllIIllIlIIlllIlIIIIIl[15];
    }
    
    public final double getM13() {
        return this.m13;
    }
    
    private final void getScaleRotate(final double[] lllllllllllllIIllIlIIIlllIlIIIll, final double[] lllllllllllllIIllIlIIIlllIlIIIlI) {
        final double[] lllllllllllllIIllIlIIIlllIlIIlIl = { this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22 };
        Matrix3d.compute_svd(lllllllllllllIIllIlIIIlllIlIIlIl, lllllllllllllIIllIlIIIlllIlIIIll, lllllllllllllIIllIlIIIlllIlIIIlI);
    }
    
    public final void set(final Quat4f lllllllllllllIIllIlIIlllIllIllIl, final Vector3d lllllllllllllIIllIlIIlllIlllIIII, final double lllllllllllllIIllIlIIlllIllIllll) {
        this.m00 = lllllllllllllIIllIlIIlllIllIllll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllIllIl.y * lllllllllllllIIllIlIIlllIllIllIl.y - 2.0 * lllllllllllllIIllIlIIlllIllIllIl.z * lllllllllllllIIllIlIIlllIllIllIl.z);
        this.m10 = lllllllllllllIIllIlIIlllIllIllll * (2.0 * (lllllllllllllIIllIlIIlllIllIllIl.x * lllllllllllllIIllIlIIlllIllIllIl.y + lllllllllllllIIllIlIIlllIllIllIl.w * lllllllllllllIIllIlIIlllIllIllIl.z));
        this.m20 = lllllllllllllIIllIlIIlllIllIllll * (2.0 * (lllllllllllllIIllIlIIlllIllIllIl.x * lllllllllllllIIllIlIIlllIllIllIl.z - lllllllllllllIIllIlIIlllIllIllIl.w * lllllllllllllIIllIlIIlllIllIllIl.y));
        this.m01 = lllllllllllllIIllIlIIlllIllIllll * (2.0 * (lllllllllllllIIllIlIIlllIllIllIl.x * lllllllllllllIIllIlIIlllIllIllIl.y - lllllllllllllIIllIlIIlllIllIllIl.w * lllllllllllllIIllIlIIlllIllIllIl.z));
        this.m11 = lllllllllllllIIllIlIIlllIllIllll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllIllIl.x * lllllllllllllIIllIlIIlllIllIllIl.x - 2.0 * lllllllllllllIIllIlIIlllIllIllIl.z * lllllllllllllIIllIlIIlllIllIllIl.z);
        this.m21 = lllllllllllllIIllIlIIlllIllIllll * (2.0 * (lllllllllllllIIllIlIIlllIllIllIl.y * lllllllllllllIIllIlIIlllIllIllIl.z + lllllllllllllIIllIlIIlllIllIllIl.w * lllllllllllllIIllIlIIlllIllIllIl.x));
        this.m02 = lllllllllllllIIllIlIIlllIllIllll * (2.0 * (lllllllllllllIIllIlIIlllIllIllIl.x * lllllllllllllIIllIlIIlllIllIllIl.z + lllllllllllllIIllIlIIlllIllIllIl.w * lllllllllllllIIllIlIIlllIllIllIl.y));
        this.m12 = lllllllllllllIIllIlIIlllIllIllll * (2.0 * (lllllllllllllIIllIlIIlllIllIllIl.y * lllllllllllllIIllIlIIlllIllIllIl.z - lllllllllllllIIllIlIIlllIllIllIl.w * lllllllllllllIIllIlIIlllIllIllIl.x));
        this.m22 = lllllllllllllIIllIlIIlllIllIllll * (1.0 - 2.0 * lllllllllllllIIllIlIIlllIllIllIl.x * lllllllllllllIIllIlIIlllIllIllIl.x - 2.0 * lllllllllllllIIllIlIIlllIllIllIl.y * lllllllllllllIIllIlIIlllIllIllIl.y);
        this.m03 = lllllllllllllIIllIlIIlllIlllIIII.x;
        this.m13 = lllllllllllllIIllIlIIlllIlllIIII.y;
        this.m23 = lllllllllllllIIllIlIIlllIlllIIII.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void mul(final Matrix4d lllllllllllllIIllIlIIllIIIIllIII, final Matrix4d lllllllllllllIIllIlIIllIIIIlIlll) {
        if (this != lllllllllllllIIllIlIIllIIIIllIII && this != lllllllllllllIIllIlIIllIIIIlIlll) {
            this.m00 = lllllllllllllIIllIlIIllIIIIllIII.m00 * lllllllllllllIIllIlIIllIIIIlIlll.m00 + lllllllllllllIIllIlIIllIIIIllIII.m01 * lllllllllllllIIllIlIIllIIIIlIlll.m10 + lllllllllllllIIllIlIIllIIIIllIII.m02 * lllllllllllllIIllIlIIllIIIIlIlll.m20 + lllllllllllllIIllIlIIllIIIIllIII.m03 * lllllllllllllIIllIlIIllIIIIlIlll.m30;
            this.m01 = lllllllllllllIIllIlIIllIIIIllIII.m00 * lllllllllllllIIllIlIIllIIIIlIlll.m01 + lllllllllllllIIllIlIIllIIIIllIII.m01 * lllllllllllllIIllIlIIllIIIIlIlll.m11 + lllllllllllllIIllIlIIllIIIIllIII.m02 * lllllllllllllIIllIlIIllIIIIlIlll.m21 + lllllllllllllIIllIlIIllIIIIllIII.m03 * lllllllllllllIIllIlIIllIIIIlIlll.m31;
            this.m02 = lllllllllllllIIllIlIIllIIIIllIII.m00 * lllllllllllllIIllIlIIllIIIIlIlll.m02 + lllllllllllllIIllIlIIllIIIIllIII.m01 * lllllllllllllIIllIlIIllIIIIlIlll.m12 + lllllllllllllIIllIlIIllIIIIllIII.m02 * lllllllllllllIIllIlIIllIIIIlIlll.m22 + lllllllllllllIIllIlIIllIIIIllIII.m03 * lllllllllllllIIllIlIIllIIIIlIlll.m32;
            this.m03 = lllllllllllllIIllIlIIllIIIIllIII.m00 * lllllllllllllIIllIlIIllIIIIlIlll.m03 + lllllllllllllIIllIlIIllIIIIllIII.m01 * lllllllllllllIIllIlIIllIIIIlIlll.m13 + lllllllllllllIIllIlIIllIIIIllIII.m02 * lllllllllllllIIllIlIIllIIIIlIlll.m23 + lllllllllllllIIllIlIIllIIIIllIII.m03 * lllllllllllllIIllIlIIllIIIIlIlll.m33;
            this.m10 = lllllllllllllIIllIlIIllIIIIllIII.m10 * lllllllllllllIIllIlIIllIIIIlIlll.m00 + lllllllllllllIIllIlIIllIIIIllIII.m11 * lllllllllllllIIllIlIIllIIIIlIlll.m10 + lllllllllllllIIllIlIIllIIIIllIII.m12 * lllllllllllllIIllIlIIllIIIIlIlll.m20 + lllllllllllllIIllIlIIllIIIIllIII.m13 * lllllllllllllIIllIlIIllIIIIlIlll.m30;
            this.m11 = lllllllllllllIIllIlIIllIIIIllIII.m10 * lllllllllllllIIllIlIIllIIIIlIlll.m01 + lllllllllllllIIllIlIIllIIIIllIII.m11 * lllllllllllllIIllIlIIllIIIIlIlll.m11 + lllllllllllllIIllIlIIllIIIIllIII.m12 * lllllllllllllIIllIlIIllIIIIlIlll.m21 + lllllllllllllIIllIlIIllIIIIllIII.m13 * lllllllllllllIIllIlIIllIIIIlIlll.m31;
            this.m12 = lllllllllllllIIllIlIIllIIIIllIII.m10 * lllllllllllllIIllIlIIllIIIIlIlll.m02 + lllllllllllllIIllIlIIllIIIIllIII.m11 * lllllllllllllIIllIlIIllIIIIlIlll.m12 + lllllllllllllIIllIlIIllIIIIllIII.m12 * lllllllllllllIIllIlIIllIIIIlIlll.m22 + lllllllllllllIIllIlIIllIIIIllIII.m13 * lllllllllllllIIllIlIIllIIIIlIlll.m32;
            this.m13 = lllllllllllllIIllIlIIllIIIIllIII.m10 * lllllllllllllIIllIlIIllIIIIlIlll.m03 + lllllllllllllIIllIlIIllIIIIllIII.m11 * lllllllllllllIIllIlIIllIIIIlIlll.m13 + lllllllllllllIIllIlIIllIIIIllIII.m12 * lllllllllllllIIllIlIIllIIIIlIlll.m23 + lllllllllllllIIllIlIIllIIIIllIII.m13 * lllllllllllllIIllIlIIllIIIIlIlll.m33;
            this.m20 = lllllllllllllIIllIlIIllIIIIllIII.m20 * lllllllllllllIIllIlIIllIIIIlIlll.m00 + lllllllllllllIIllIlIIllIIIIllIII.m21 * lllllllllllllIIllIlIIllIIIIlIlll.m10 + lllllllllllllIIllIlIIllIIIIllIII.m22 * lllllllllllllIIllIlIIllIIIIlIlll.m20 + lllllllllllllIIllIlIIllIIIIllIII.m23 * lllllllllllllIIllIlIIllIIIIlIlll.m30;
            this.m21 = lllllllllllllIIllIlIIllIIIIllIII.m20 * lllllllllllllIIllIlIIllIIIIlIlll.m01 + lllllllllllllIIllIlIIllIIIIllIII.m21 * lllllllllllllIIllIlIIllIIIIlIlll.m11 + lllllllllllllIIllIlIIllIIIIllIII.m22 * lllllllllllllIIllIlIIllIIIIlIlll.m21 + lllllllllllllIIllIlIIllIIIIllIII.m23 * lllllllllllllIIllIlIIllIIIIlIlll.m31;
            this.m22 = lllllllllllllIIllIlIIllIIIIllIII.m20 * lllllllllllllIIllIlIIllIIIIlIlll.m02 + lllllllllllllIIllIlIIllIIIIllIII.m21 * lllllllllllllIIllIlIIllIIIIlIlll.m12 + lllllllllllllIIllIlIIllIIIIllIII.m22 * lllllllllllllIIllIlIIllIIIIlIlll.m22 + lllllllllllllIIllIlIIllIIIIllIII.m23 * lllllllllllllIIllIlIIllIIIIlIlll.m32;
            this.m23 = lllllllllllllIIllIlIIllIIIIllIII.m20 * lllllllllllllIIllIlIIllIIIIlIlll.m03 + lllllllllllllIIllIlIIllIIIIllIII.m21 * lllllllllllllIIllIlIIllIIIIlIlll.m13 + lllllllllllllIIllIlIIllIIIIllIII.m22 * lllllllllllllIIllIlIIllIIIIlIlll.m23 + lllllllllllllIIllIlIIllIIIIllIII.m23 * lllllllllllllIIllIlIIllIIIIlIlll.m33;
            this.m30 = lllllllllllllIIllIlIIllIIIIllIII.m30 * lllllllllllllIIllIlIIllIIIIlIlll.m00 + lllllllllllllIIllIlIIllIIIIllIII.m31 * lllllllllllllIIllIlIIllIIIIlIlll.m10 + lllllllllllllIIllIlIIllIIIIllIII.m32 * lllllllllllllIIllIlIIllIIIIlIlll.m20 + lllllllllllllIIllIlIIllIIIIllIII.m33 * lllllllllllllIIllIlIIllIIIIlIlll.m30;
            this.m31 = lllllllllllllIIllIlIIllIIIIllIII.m30 * lllllllllllllIIllIlIIllIIIIlIlll.m01 + lllllllllllllIIllIlIIllIIIIllIII.m31 * lllllllllllllIIllIlIIllIIIIlIlll.m11 + lllllllllllllIIllIlIIllIIIIllIII.m32 * lllllllllllllIIllIlIIllIIIIlIlll.m21 + lllllllllllllIIllIlIIllIIIIllIII.m33 * lllllllllllllIIllIlIIllIIIIlIlll.m31;
            this.m32 = lllllllllllllIIllIlIIllIIIIllIII.m30 * lllllllllllllIIllIlIIllIIIIlIlll.m02 + lllllllllllllIIllIlIIllIIIIllIII.m31 * lllllllllllllIIllIlIIllIIIIlIlll.m12 + lllllllllllllIIllIlIIllIIIIllIII.m32 * lllllllllllllIIllIlIIllIIIIlIlll.m22 + lllllllllllllIIllIlIIllIIIIllIII.m33 * lllllllllllllIIllIlIIllIIIIlIlll.m32;
            this.m33 = lllllllllllllIIllIlIIllIIIIllIII.m30 * lllllllllllllIIllIlIIllIIIIlIlll.m03 + lllllllllllllIIllIlIIllIIIIllIII.m31 * lllllllllllllIIllIlIIllIIIIlIlll.m13 + lllllllllllllIIllIlIIllIIIIllIII.m32 * lllllllllllllIIllIlIIllIIIIlIlll.m23 + lllllllllllllIIllIlIIllIIIIllIII.m33 * lllllllllllllIIllIlIIllIIIIlIlll.m33;
        }
        else {
            final double lllllllllllllIIllIlIIllIIIIlIllI = lllllllllllllIIllIlIIllIIIIllIII.m00 * lllllllllllllIIllIlIIllIIIIlIlll.m00 + lllllllllllllIIllIlIIllIIIIllIII.m01 * lllllllllllllIIllIlIIllIIIIlIlll.m10 + lllllllllllllIIllIlIIllIIIIllIII.m02 * lllllllllllllIIllIlIIllIIIIlIlll.m20 + lllllllllllllIIllIlIIllIIIIllIII.m03 * lllllllllllllIIllIlIIllIIIIlIlll.m30;
            final double lllllllllllllIIllIlIIllIIIIlIlIl = lllllllllllllIIllIlIIllIIIIllIII.m00 * lllllllllllllIIllIlIIllIIIIlIlll.m01 + lllllllllllllIIllIlIIllIIIIllIII.m01 * lllllllllllllIIllIlIIllIIIIlIlll.m11 + lllllllllllllIIllIlIIllIIIIllIII.m02 * lllllllllllllIIllIlIIllIIIIlIlll.m21 + lllllllllllllIIllIlIIllIIIIllIII.m03 * lllllllllllllIIllIlIIllIIIIlIlll.m31;
            final double lllllllllllllIIllIlIIllIIIIlIlII = lllllllllllllIIllIlIIllIIIIllIII.m00 * lllllllllllllIIllIlIIllIIIIlIlll.m02 + lllllllllllllIIllIlIIllIIIIllIII.m01 * lllllllllllllIIllIlIIllIIIIlIlll.m12 + lllllllllllllIIllIlIIllIIIIllIII.m02 * lllllllllllllIIllIlIIllIIIIlIlll.m22 + lllllllllllllIIllIlIIllIIIIllIII.m03 * lllllllllllllIIllIlIIllIIIIlIlll.m32;
            final double lllllllllllllIIllIlIIllIIIIlIIll = lllllllllllllIIllIlIIllIIIIllIII.m00 * lllllllllllllIIllIlIIllIIIIlIlll.m03 + lllllllllllllIIllIlIIllIIIIllIII.m01 * lllllllllllllIIllIlIIllIIIIlIlll.m13 + lllllllllllllIIllIlIIllIIIIllIII.m02 * lllllllllllllIIllIlIIllIIIIlIlll.m23 + lllllllllllllIIllIlIIllIIIIllIII.m03 * lllllllllllllIIllIlIIllIIIIlIlll.m33;
            final double lllllllllllllIIllIlIIllIIIIlIIlI = lllllllllllllIIllIlIIllIIIIllIII.m10 * lllllllllllllIIllIlIIllIIIIlIlll.m00 + lllllllllllllIIllIlIIllIIIIllIII.m11 * lllllllllllllIIllIlIIllIIIIlIlll.m10 + lllllllllllllIIllIlIIllIIIIllIII.m12 * lllllllllllllIIllIlIIllIIIIlIlll.m20 + lllllllllllllIIllIlIIllIIIIllIII.m13 * lllllllllllllIIllIlIIllIIIIlIlll.m30;
            final double lllllllllllllIIllIlIIllIIIIlIIIl = lllllllllllllIIllIlIIllIIIIllIII.m10 * lllllllllllllIIllIlIIllIIIIlIlll.m01 + lllllllllllllIIllIlIIllIIIIllIII.m11 * lllllllllllllIIllIlIIllIIIIlIlll.m11 + lllllllllllllIIllIlIIllIIIIllIII.m12 * lllllllllllllIIllIlIIllIIIIlIlll.m21 + lllllllllllllIIllIlIIllIIIIllIII.m13 * lllllllllllllIIllIlIIllIIIIlIlll.m31;
            final double lllllllllllllIIllIlIIllIIIIlIIII = lllllllllllllIIllIlIIllIIIIllIII.m10 * lllllllllllllIIllIlIIllIIIIlIlll.m02 + lllllllllllllIIllIlIIllIIIIllIII.m11 * lllllllllllllIIllIlIIllIIIIlIlll.m12 + lllllllllllllIIllIlIIllIIIIllIII.m12 * lllllllllllllIIllIlIIllIIIIlIlll.m22 + lllllllllllllIIllIlIIllIIIIllIII.m13 * lllllllllllllIIllIlIIllIIIIlIlll.m32;
            final double lllllllllllllIIllIlIIllIIIIIllll = lllllllllllllIIllIlIIllIIIIllIII.m10 * lllllllllllllIIllIlIIllIIIIlIlll.m03 + lllllllllllllIIllIlIIllIIIIllIII.m11 * lllllllllllllIIllIlIIllIIIIlIlll.m13 + lllllllllllllIIllIlIIllIIIIllIII.m12 * lllllllllllllIIllIlIIllIIIIlIlll.m23 + lllllllllllllIIllIlIIllIIIIllIII.m13 * lllllllllllllIIllIlIIllIIIIlIlll.m33;
            final double lllllllllllllIIllIlIIllIIIIIlllI = lllllllllllllIIllIlIIllIIIIllIII.m20 * lllllllllllllIIllIlIIllIIIIlIlll.m00 + lllllllllllllIIllIlIIllIIIIllIII.m21 * lllllllllllllIIllIlIIllIIIIlIlll.m10 + lllllllllllllIIllIlIIllIIIIllIII.m22 * lllllllllllllIIllIlIIllIIIIlIlll.m20 + lllllllllllllIIllIlIIllIIIIllIII.m23 * lllllllllllllIIllIlIIllIIIIlIlll.m30;
            final double lllllllllllllIIllIlIIllIIIIIllIl = lllllllllllllIIllIlIIllIIIIllIII.m20 * lllllllllllllIIllIlIIllIIIIlIlll.m01 + lllllllllllllIIllIlIIllIIIIllIII.m21 * lllllllllllllIIllIlIIllIIIIlIlll.m11 + lllllllllllllIIllIlIIllIIIIllIII.m22 * lllllllllllllIIllIlIIllIIIIlIlll.m21 + lllllllllllllIIllIlIIllIIIIllIII.m23 * lllllllllllllIIllIlIIllIIIIlIlll.m31;
            final double lllllllllllllIIllIlIIllIIIIIllII = lllllllllllllIIllIlIIllIIIIllIII.m20 * lllllllllllllIIllIlIIllIIIIlIlll.m02 + lllllllllllllIIllIlIIllIIIIllIII.m21 * lllllllllllllIIllIlIIllIIIIlIlll.m12 + lllllllllllllIIllIlIIllIIIIllIII.m22 * lllllllllllllIIllIlIIllIIIIlIlll.m22 + lllllllllllllIIllIlIIllIIIIllIII.m23 * lllllllllllllIIllIlIIllIIIIlIlll.m32;
            final double lllllllllllllIIllIlIIllIIIIIlIll = lllllllllllllIIllIlIIllIIIIllIII.m20 * lllllllllllllIIllIlIIllIIIIlIlll.m03 + lllllllllllllIIllIlIIllIIIIllIII.m21 * lllllllllllllIIllIlIIllIIIIlIlll.m13 + lllllllllllllIIllIlIIllIIIIllIII.m22 * lllllllllllllIIllIlIIllIIIIlIlll.m23 + lllllllllllllIIllIlIIllIIIIllIII.m23 * lllllllllllllIIllIlIIllIIIIlIlll.m33;
            final double lllllllllllllIIllIlIIllIIIIIlIlI = lllllllllllllIIllIlIIllIIIIllIII.m30 * lllllllllllllIIllIlIIllIIIIlIlll.m00 + lllllllllllllIIllIlIIllIIIIllIII.m31 * lllllllllllllIIllIlIIllIIIIlIlll.m10 + lllllllllllllIIllIlIIllIIIIllIII.m32 * lllllllllllllIIllIlIIllIIIIlIlll.m20 + lllllllllllllIIllIlIIllIIIIllIII.m33 * lllllllllllllIIllIlIIllIIIIlIlll.m30;
            final double lllllllllllllIIllIlIIllIIIIIlIIl = lllllllllllllIIllIlIIllIIIIllIII.m30 * lllllllllllllIIllIlIIllIIIIlIlll.m01 + lllllllllllllIIllIlIIllIIIIllIII.m31 * lllllllllllllIIllIlIIllIIIIlIlll.m11 + lllllllllllllIIllIlIIllIIIIllIII.m32 * lllllllllllllIIllIlIIllIIIIlIlll.m21 + lllllllllllllIIllIlIIllIIIIllIII.m33 * lllllllllllllIIllIlIIllIIIIlIlll.m31;
            final double lllllllllllllIIllIlIIllIIIIIlIII = lllllllllllllIIllIlIIllIIIIllIII.m30 * lllllllllllllIIllIlIIllIIIIlIlll.m02 + lllllllllllllIIllIlIIllIIIIllIII.m31 * lllllllllllllIIllIlIIllIIIIlIlll.m12 + lllllllllllllIIllIlIIllIIIIllIII.m32 * lllllllllllllIIllIlIIllIIIIlIlll.m22 + lllllllllllllIIllIlIIllIIIIllIII.m33 * lllllllllllllIIllIlIIllIIIIlIlll.m32;
            final double lllllllllllllIIllIlIIllIIIIIIlll = lllllllllllllIIllIlIIllIIIIllIII.m30 * lllllllllllllIIllIlIIllIIIIlIlll.m03 + lllllllllllllIIllIlIIllIIIIllIII.m31 * lllllllllllllIIllIlIIllIIIIlIlll.m13 + lllllllllllllIIllIlIIllIIIIllIII.m32 * lllllllllllllIIllIlIIllIIIIlIlll.m23 + lllllllllllllIIllIlIIllIIIIllIII.m33 * lllllllllllllIIllIlIIllIIIIlIlll.m33;
            this.m00 = lllllllllllllIIllIlIIllIIIIlIllI;
            this.m01 = lllllllllllllIIllIlIIllIIIIlIlIl;
            this.m02 = lllllllllllllIIllIlIIllIIIIlIlII;
            this.m03 = lllllllllllllIIllIlIIllIIIIlIIll;
            this.m10 = lllllllllllllIIllIlIIllIIIIlIIlI;
            this.m11 = lllllllllllllIIllIlIIllIIIIlIIIl;
            this.m12 = lllllllllllllIIllIlIIllIIIIlIIII;
            this.m13 = lllllllllllllIIllIlIIllIIIIIllll;
            this.m20 = lllllllllllllIIllIlIIllIIIIIlllI;
            this.m21 = lllllllllllllIIllIlIIllIIIIIllIl;
            this.m22 = lllllllllllllIIllIlIIllIIIIIllII;
            this.m23 = lllllllllllllIIllIlIIllIIIIIlIll;
            this.m30 = lllllllllllllIIllIlIIllIIIIIlIlI;
            this.m31 = lllllllllllllIIllIlIIllIIIIIlIIl;
            this.m32 = lllllllllllllIIllIlIIllIIIIIlIII;
            this.m33 = lllllllllllllIIllIlIIllIIIIIIlll;
        }
    }
    
    public final void set(final Matrix3f lllllllllllllIIllIlIIllIlIlIlllI, final Vector3f lllllllllllllIIllIlIIllIlIlIlIIl, final float lllllllllllllIIllIlIIllIlIlIlIII) {
        this.m00 = lllllllllllllIIllIlIIllIlIlIlllI.m00 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m01 = lllllllllllllIIllIlIIllIlIlIlllI.m01 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m02 = lllllllllllllIIllIlIIllIlIlIlllI.m02 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m03 = lllllllllllllIIllIlIIllIlIlIlIIl.x;
        this.m10 = lllllllllllllIIllIlIIllIlIlIlllI.m10 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m11 = lllllllllllllIIllIlIIllIlIlIlllI.m11 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m12 = lllllllllllllIIllIlIIllIlIlIlllI.m12 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m13 = lllllllllllllIIllIlIIllIlIlIlIIl.y;
        this.m20 = lllllllllllllIIllIlIIllIlIlIlllI.m20 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m21 = lllllllllllllIIllIlIIllIlIlIlllI.m21 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m22 = lllllllllllllIIllIlIIllIlIlIlllI.m22 * lllllllllllllIIllIlIIllIlIlIlIII;
        this.m23 = lllllllllllllIIllIlIIllIlIlIlIIl.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void mul(final Matrix4d lllllllllllllIIllIlIIllIIIllllII) {
        final double lllllllllllllIIllIlIIllIIlIIlllI = this.m00 * lllllllllllllIIllIlIIllIIIllllII.m00 + this.m01 * lllllllllllllIIllIlIIllIIIllllII.m10 + this.m02 * lllllllllllllIIllIlIIllIIIllllII.m20 + this.m03 * lllllllllllllIIllIlIIllIIIllllII.m30;
        final double lllllllllllllIIllIlIIllIIlIIllIl = this.m00 * lllllllllllllIIllIlIIllIIIllllII.m01 + this.m01 * lllllllllllllIIllIlIIllIIIllllII.m11 + this.m02 * lllllllllllllIIllIlIIllIIIllllII.m21 + this.m03 * lllllllllllllIIllIlIIllIIIllllII.m31;
        final double lllllllllllllIIllIlIIllIIlIIllII = this.m00 * lllllllllllllIIllIlIIllIIIllllII.m02 + this.m01 * lllllllllllllIIllIlIIllIIIllllII.m12 + this.m02 * lllllllllllllIIllIlIIllIIIllllII.m22 + this.m03 * lllllllllllllIIllIlIIllIIIllllII.m32;
        final double lllllllllllllIIllIlIIllIIlIIlIll = this.m00 * lllllllllllllIIllIlIIllIIIllllII.m03 + this.m01 * lllllllllllllIIllIlIIllIIIllllII.m13 + this.m02 * lllllllllllllIIllIlIIllIIIllllII.m23 + this.m03 * lllllllllllllIIllIlIIllIIIllllII.m33;
        final double lllllllllllllIIllIlIIllIIlIIlIlI = this.m10 * lllllllllllllIIllIlIIllIIIllllII.m00 + this.m11 * lllllllllllllIIllIlIIllIIIllllII.m10 + this.m12 * lllllllllllllIIllIlIIllIIIllllII.m20 + this.m13 * lllllllllllllIIllIlIIllIIIllllII.m30;
        final double lllllllllllllIIllIlIIllIIlIIlIIl = this.m10 * lllllllllllllIIllIlIIllIIIllllII.m01 + this.m11 * lllllllllllllIIllIlIIllIIIllllII.m11 + this.m12 * lllllllllllllIIllIlIIllIIIllllII.m21 + this.m13 * lllllllllllllIIllIlIIllIIIllllII.m31;
        final double lllllllllllllIIllIlIIllIIlIIlIII = this.m10 * lllllllllllllIIllIlIIllIIIllllII.m02 + this.m11 * lllllllllllllIIllIlIIllIIIllllII.m12 + this.m12 * lllllllllllllIIllIlIIllIIIllllII.m22 + this.m13 * lllllllllllllIIllIlIIllIIIllllII.m32;
        final double lllllllllllllIIllIlIIllIIlIIIlll = this.m10 * lllllllllllllIIllIlIIllIIIllllII.m03 + this.m11 * lllllllllllllIIllIlIIllIIIllllII.m13 + this.m12 * lllllllllllllIIllIlIIllIIIllllII.m23 + this.m13 * lllllllllllllIIllIlIIllIIIllllII.m33;
        final double lllllllllllllIIllIlIIllIIlIIIllI = this.m20 * lllllllllllllIIllIlIIllIIIllllII.m00 + this.m21 * lllllllllllllIIllIlIIllIIIllllII.m10 + this.m22 * lllllllllllllIIllIlIIllIIIllllII.m20 + this.m23 * lllllllllllllIIllIlIIllIIIllllII.m30;
        final double lllllllllllllIIllIlIIllIIlIIIlIl = this.m20 * lllllllllllllIIllIlIIllIIIllllII.m01 + this.m21 * lllllllllllllIIllIlIIllIIIllllII.m11 + this.m22 * lllllllllllllIIllIlIIllIIIllllII.m21 + this.m23 * lllllllllllllIIllIlIIllIIIllllII.m31;
        final double lllllllllllllIIllIlIIllIIlIIIlII = this.m20 * lllllllllllllIIllIlIIllIIIllllII.m02 + this.m21 * lllllllllllllIIllIlIIllIIIllllII.m12 + this.m22 * lllllllllllllIIllIlIIllIIIllllII.m22 + this.m23 * lllllllllllllIIllIlIIllIIIllllII.m32;
        final double lllllllllllllIIllIlIIllIIlIIIIll = this.m20 * lllllllllllllIIllIlIIllIIIllllII.m03 + this.m21 * lllllllllllllIIllIlIIllIIIllllII.m13 + this.m22 * lllllllllllllIIllIlIIllIIIllllII.m23 + this.m23 * lllllllllllllIIllIlIIllIIIllllII.m33;
        final double lllllllllllllIIllIlIIllIIlIIIIlI = this.m30 * lllllllllllllIIllIlIIllIIIllllII.m00 + this.m31 * lllllllllllllIIllIlIIllIIIllllII.m10 + this.m32 * lllllllllllllIIllIlIIllIIIllllII.m20 + this.m33 * lllllllllllllIIllIlIIllIIIllllII.m30;
        final double lllllllllllllIIllIlIIllIIlIIIIIl = this.m30 * lllllllllllllIIllIlIIllIIIllllII.m01 + this.m31 * lllllllllllllIIllIlIIllIIIllllII.m11 + this.m32 * lllllllllllllIIllIlIIllIIIllllII.m21 + this.m33 * lllllllllllllIIllIlIIllIIIllllII.m31;
        final double lllllllllllllIIllIlIIllIIlIIIIII = this.m30 * lllllllllllllIIllIlIIllIIIllllII.m02 + this.m31 * lllllllllllllIIllIlIIllIIIllllII.m12 + this.m32 * lllllllllllllIIllIlIIllIIIllllII.m22 + this.m33 * lllllllllllllIIllIlIIllIIIllllII.m32;
        final double lllllllllllllIIllIlIIllIIIllllll = this.m30 * lllllllllllllIIllIlIIllIIIllllII.m03 + this.m31 * lllllllllllllIIllIlIIllIIIllllII.m13 + this.m32 * lllllllllllllIIllIlIIllIIIllllII.m23 + this.m33 * lllllllllllllIIllIlIIllIIIllllII.m33;
        this.m00 = lllllllllllllIIllIlIIllIIlIIlllI;
        this.m01 = lllllllllllllIIllIlIIllIIlIIllIl;
        this.m02 = lllllllllllllIIllIlIIllIIlIIllII;
        this.m03 = lllllllllllllIIllIlIIllIIlIIlIll;
        this.m10 = lllllllllllllIIllIlIIllIIlIIlIlI;
        this.m11 = lllllllllllllIIllIlIIllIIlIIlIIl;
        this.m12 = lllllllllllllIIllIlIIllIIlIIlIII;
        this.m13 = lllllllllllllIIllIlIIllIIlIIIlll;
        this.m20 = lllllllllllllIIllIlIIllIIlIIIllI;
        this.m21 = lllllllllllllIIllIlIIllIIlIIIlIl;
        this.m22 = lllllllllllllIIllIlIIllIIlIIIlII;
        this.m23 = lllllllllllllIIllIlIIllIIlIIIIll;
        this.m30 = lllllllllllllIIllIlIIllIIlIIIIlI;
        this.m31 = lllllllllllllIIllIlIIllIIlIIIIIl;
        this.m32 = lllllllllllllIIllIlIIllIIlIIIIII;
        this.m33 = lllllllllllllIIllIlIIllIIIllllll;
    }
    
    public final void getRotationScale(final Matrix3f lllllllllllllIIllIlIlIIIlIIlIIIl) {
        lllllllllllllIIllIlIlIIIlIIlIIIl.m00 = (float)this.m00;
        lllllllllllllIIllIlIlIIIlIIlIIIl.m01 = (float)this.m01;
        lllllllllllllIIllIlIlIIIlIIlIIIl.m02 = (float)this.m02;
        lllllllllllllIIllIlIlIIIlIIlIIIl.m10 = (float)this.m10;
        lllllllllllllIIllIlIlIIIlIIlIIIl.m11 = (float)this.m11;
        lllllllllllllIIllIlIlIIIlIIlIIIl.m12 = (float)this.m12;
        lllllllllllllIIllIlIlIIIlIIlIIIl.m20 = (float)this.m20;
        lllllllllllllIIllIlIlIIIlIIlIIIl.m21 = (float)this.m21;
        lllllllllllllIIllIlIlIIIlIIlIIIl.m22 = (float)this.m22;
    }
    
    public Matrix4d(final Quat4d lllllllllllllIIllIlIlIIllIlllIlI, final Vector3d lllllllllllllIIllIlIlIIllIllIIII, final double lllllllllllllIIllIlIlIIllIlIlllI) {
        this.m00 = lllllllllllllIIllIlIlIIllIlIlllI * (1.0 - 2.0 * lllllllllllllIIllIlIlIIllIlllIlI.y * lllllllllllllIIllIlIlIIllIlllIlI.y - 2.0 * lllllllllllllIIllIlIlIIllIlllIlI.z * lllllllllllllIIllIlIlIIllIlllIlI.z);
        this.m10 = lllllllllllllIIllIlIlIIllIlIlllI * (2.0 * (lllllllllllllIIllIlIlIIllIlllIlI.x * lllllllllllllIIllIlIlIIllIlllIlI.y + lllllllllllllIIllIlIlIIllIlllIlI.w * lllllllllllllIIllIlIlIIllIlllIlI.z));
        this.m20 = lllllllllllllIIllIlIlIIllIlIlllI * (2.0 * (lllllllllllllIIllIlIlIIllIlllIlI.x * lllllllllllllIIllIlIlIIllIlllIlI.z - lllllllllllllIIllIlIlIIllIlllIlI.w * lllllllllllllIIllIlIlIIllIlllIlI.y));
        this.m01 = lllllllllllllIIllIlIlIIllIlIlllI * (2.0 * (lllllllllllllIIllIlIlIIllIlllIlI.x * lllllllllllllIIllIlIlIIllIlllIlI.y - lllllllllllllIIllIlIlIIllIlllIlI.w * lllllllllllllIIllIlIlIIllIlllIlI.z));
        this.m11 = lllllllllllllIIllIlIlIIllIlIlllI * (1.0 - 2.0 * lllllllllllllIIllIlIlIIllIlllIlI.x * lllllllllllllIIllIlIlIIllIlllIlI.x - 2.0 * lllllllllllllIIllIlIlIIllIlllIlI.z * lllllllllllllIIllIlIlIIllIlllIlI.z);
        this.m21 = lllllllllllllIIllIlIlIIllIlIlllI * (2.0 * (lllllllllllllIIllIlIlIIllIlllIlI.y * lllllllllllllIIllIlIlIIllIlllIlI.z + lllllllllllllIIllIlIlIIllIlllIlI.w * lllllllllllllIIllIlIlIIllIlllIlI.x));
        this.m02 = lllllllllllllIIllIlIlIIllIlIlllI * (2.0 * (lllllllllllllIIllIlIlIIllIlllIlI.x * lllllllllllllIIllIlIlIIllIlllIlI.z + lllllllllllllIIllIlIlIIllIlllIlI.w * lllllllllllllIIllIlIlIIllIlllIlI.y));
        this.m12 = lllllllllllllIIllIlIlIIllIlIlllI * (2.0 * (lllllllllllllIIllIlIlIIllIlllIlI.y * lllllllllllllIIllIlIlIIllIlllIlI.z - lllllllllllllIIllIlIlIIllIlllIlI.w * lllllllllllllIIllIlIlIIllIlllIlI.x));
        this.m22 = lllllllllllllIIllIlIlIIllIlIlllI * (1.0 - 2.0 * lllllllllllllIIllIlIlIIllIlllIlI.x * lllllllllllllIIllIlIlIIllIlllIlI.x - 2.0 * lllllllllllllIIllIlIlIIllIlllIlI.y * lllllllllllllIIllIlIlIIllIlllIlI.y);
        this.m03 = lllllllllllllIIllIlIlIIllIllIIII.x;
        this.m13 = lllllllllllllIIllIlIlIIllIllIIII.y;
        this.m23 = lllllllllllllIIllIlIlIIllIllIIII.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void setM33(final double lllllllllllllIIllIlIIIllIIIIlIlI) {
        this.m33 = lllllllllllllIIllIlIIIllIIIIlIlI;
    }
    
    public final void mul(final double lllllllllllllIIllIlIIllIIllIlllI) {
        this.m00 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m01 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m02 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m03 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m10 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m11 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m12 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m13 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m20 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m21 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m22 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m23 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m30 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m31 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m32 *= lllllllllllllIIllIlIIllIIllIlllI;
        this.m33 *= lllllllllllllIIllIlIIllIIllIlllI;
    }
    
    public final void setColumn(final int lllllllllllllIIllIlIlIIIIIlIllII, final Vector4d lllllllllllllIIllIlIlIIIIIlIlIll) {
        switch (lllllllllllllIIllIlIlIIIIIlIllII) {
            case 0: {
                this.m00 = lllllllllllllIIllIlIlIIIIIlIlIll.x;
                this.m10 = lllllllllllllIIllIlIlIIIIIlIlIll.y;
                this.m20 = lllllllllllllIIllIlIlIIIIIlIlIll.z;
                this.m30 = lllllllllllllIIllIlIlIIIIIlIlIll.w;
                break;
            }
            case 1: {
                this.m01 = lllllllllllllIIllIlIlIIIIIlIlIll.x;
                this.m11 = lllllllllllllIIllIlIlIIIIIlIlIll.y;
                this.m21 = lllllllllllllIIllIlIlIIIIIlIlIll.z;
                this.m31 = lllllllllllllIIllIlIlIIIIIlIlIll.w;
                break;
            }
            case 2: {
                this.m02 = lllllllllllllIIllIlIlIIIIIlIlIll.x;
                this.m12 = lllllllllllllIIllIlIlIIIIIlIlIll.y;
                this.m22 = lllllllllllllIIllIlIlIIIIIlIlIll.z;
                this.m32 = lllllllllllllIIllIlIlIIIIIlIlIll.w;
                break;
            }
            case 3: {
                this.m03 = lllllllllllllIIllIlIlIIIIIlIlIll.x;
                this.m13 = lllllllllllllIIllIlIlIIIIIlIlIll.y;
                this.m23 = lllllllllllllIIllIlIlIIIIIlIlIll.z;
                this.m33 = lllllllllllllIIllIlIlIIIIIlIlIll.w;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
            }
        }
    }
    
    public final void setRow(final int lllllllllllllIIllIlIlIIIIlIIlIlI, final double[] lllllllllllllIIllIlIlIIIIlIIlIIl) {
        switch (lllllllllllllIIllIlIlIIIIlIIlIlI) {
            case 0: {
                this.m00 = lllllllllllllIIllIlIlIIIIlIIlIIl[0];
                this.m01 = lllllllllllllIIllIlIlIIIIlIIlIIl[1];
                this.m02 = lllllllllllllIIllIlIlIIIIlIIlIIl[2];
                this.m03 = lllllllllllllIIllIlIlIIIIlIIlIIl[3];
                break;
            }
            case 1: {
                this.m10 = lllllllllllllIIllIlIlIIIIlIIlIIl[0];
                this.m11 = lllllllllllllIIllIlIlIIIIlIIlIIl[1];
                this.m12 = lllllllllllllIIllIlIlIIIIlIIlIIl[2];
                this.m13 = lllllllllllllIIllIlIlIIIIlIIlIIl[3];
                break;
            }
            case 2: {
                this.m20 = lllllllllllllIIllIlIlIIIIlIIlIIl[0];
                this.m21 = lllllllllllllIIllIlIlIIIIlIIlIIl[1];
                this.m22 = lllllllllllllIIllIlIlIIIIlIIlIIl[2];
                this.m23 = lllllllllllllIIllIlIlIIIIlIIlIIl[3];
                break;
            }
            case 3: {
                this.m30 = lllllllllllllIIllIlIlIIIIlIIlIIl[0];
                this.m31 = lllllllllllllIIllIlIlIIIIlIIlIIl[1];
                this.m32 = lllllllllllllIIllIlIlIIIIlIIlIIl[2];
                this.m33 = lllllllllllllIIllIlIlIIIIlIIlIIl[3];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d4"));
            }
        }
    }
    
    public final void add(final double lllllllllllllIIllIlIlIIIIIIlIlII, final Matrix4d lllllllllllllIIllIlIlIIIIIIlIIll) {
        this.m00 = lllllllllllllIIllIlIlIIIIIIlIIll.m00 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m01 = lllllllllllllIIllIlIlIIIIIIlIIll.m01 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m02 = lllllllllllllIIllIlIlIIIIIIlIIll.m02 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m03 = lllllllllllllIIllIlIlIIIIIIlIIll.m03 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m10 = lllllllllllllIIllIlIlIIIIIIlIIll.m10 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m11 = lllllllllllllIIllIlIlIIIIIIlIIll.m11 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m12 = lllllllllllllIIllIlIlIIIIIIlIIll.m12 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m13 = lllllllllllllIIllIlIlIIIIIIlIIll.m13 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m20 = lllllllllllllIIllIlIlIIIIIIlIIll.m20 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m21 = lllllllllllllIIllIlIlIIIIIIlIIll.m21 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m22 = lllllllllllllIIllIlIlIIIIIIlIIll.m22 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m23 = lllllllllllllIIllIlIlIIIIIIlIIll.m23 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m30 = lllllllllllllIIllIlIlIIIIIIlIIll.m30 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m31 = lllllllllllllIIllIlIlIIIIIIlIIll.m31 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m32 = lllllllllllllIIllIlIlIIIIIIlIIll.m32 + lllllllllllllIIllIlIlIIIIIIlIlII;
        this.m33 = lllllllllllllIIllIlIlIIIIIIlIIll.m33 + lllllllllllllIIllIlIlIIIIIIlIlII;
    }
    
    public final void get(final Matrix3d lllllllllllllIIllIlIlIIlIIIlllll) {
        final double[] lllllllllllllIIllIlIlIIlIIlIIIlI = new double[9];
        final double[] lllllllllllllIIllIlIlIIlIIlIIIIl = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIlIIlIIlIIIIl, lllllllllllllIIllIlIlIIlIIlIIIlI);
        lllllllllllllIIllIlIlIIlIIIlllll.m00 = lllllllllllllIIllIlIlIIlIIlIIIlI[0];
        lllllllllllllIIllIlIlIIlIIIlllll.m01 = lllllllllllllIIllIlIlIIlIIlIIIlI[1];
        lllllllllllllIIllIlIlIIlIIIlllll.m02 = lllllllllllllIIllIlIlIIlIIlIIIlI[2];
        lllllllllllllIIllIlIlIIlIIIlllll.m10 = lllllllllllllIIllIlIlIIlIIlIIIlI[3];
        lllllllllllllIIllIlIlIIlIIIlllll.m11 = lllllllllllllIIllIlIlIIlIIlIIIlI[4];
        lllllllllllllIIllIlIlIIlIIIlllll.m12 = lllllllllllllIIllIlIlIIlIIlIIIlI[5];
        lllllllllllllIIllIlIlIIlIIIlllll.m20 = lllllllllllllIIllIlIlIIlIIlIIIlI[6];
        lllllllllllllIIllIlIlIIlIIIlllll.m21 = lllllllllllllIIllIlIlIIlIIlIIIlI[7];
        lllllllllllllIIllIlIlIIlIIIlllll.m22 = lllllllllllllIIllIlIlIIlIIlIIIlI[8];
    }
    
    public final void negate(final Matrix4d lllllllllllllIIllIlIIIlllIlIllIl) {
        this.m00 = -lllllllllllllIIllIlIIIlllIlIllIl.m00;
        this.m01 = -lllllllllllllIIllIlIIIlllIlIllIl.m01;
        this.m02 = -lllllllllllllIIllIlIIIlllIlIllIl.m02;
        this.m03 = -lllllllllllllIIllIlIIIlllIlIllIl.m03;
        this.m10 = -lllllllllllllIIllIlIIIlllIlIllIl.m10;
        this.m11 = -lllllllllllllIIllIlIIIlllIlIllIl.m11;
        this.m12 = -lllllllllllllIIllIlIIIlllIlIllIl.m12;
        this.m13 = -lllllllllllllIIllIlIIIlllIlIllIl.m13;
        this.m20 = -lllllllllllllIIllIlIIIlllIlIllIl.m20;
        this.m21 = -lllllllllllllIIllIlIIIlllIlIllIl.m21;
        this.m22 = -lllllllllllllIIllIlIIIlllIlIllIl.m22;
        this.m23 = -lllllllllllllIIllIlIIIlllIlIllIl.m23;
        this.m30 = -lllllllllllllIIllIlIIIlllIlIllIl.m30;
        this.m31 = -lllllllllllllIIllIlIIIlllIlIllIl.m31;
        this.m32 = -lllllllllllllIIllIlIIIlllIlIllIl.m32;
        this.m33 = -lllllllllllllIIllIlIIIlllIlIllIl.m33;
    }
    
    public final void setColumn(final int lllllllllllllIIllIlIlIIIIIlIIllI, final double[] lllllllllllllIIllIlIlIIIIIlIIlIl) {
        switch (lllllllllllllIIllIlIlIIIIIlIIllI) {
            case 0: {
                this.m00 = lllllllllllllIIllIlIlIIIIIlIIlIl[0];
                this.m10 = lllllllllllllIIllIlIlIIIIIlIIlIl[1];
                this.m20 = lllllllllllllIIllIlIlIIIIIlIIlIl[2];
                this.m30 = lllllllllllllIIllIlIlIIIIIlIIlIl[3];
                break;
            }
            case 1: {
                this.m01 = lllllllllllllIIllIlIlIIIIIlIIlIl[0];
                this.m11 = lllllllllllllIIllIlIlIIIIIlIIlIl[1];
                this.m21 = lllllllllllllIIllIlIlIIIIIlIIlIl[2];
                this.m31 = lllllllllllllIIllIlIlIIIIIlIIlIl[3];
                break;
            }
            case 2: {
                this.m02 = lllllllllllllIIllIlIlIIIIIlIIlIl[0];
                this.m12 = lllllllllllllIIllIlIlIIIIIlIIlIl[1];
                this.m22 = lllllllllllllIIllIlIlIIIIIlIIlIl[2];
                this.m32 = lllllllllllllIIllIlIlIIIIIlIIlIl[3];
                break;
            }
            case 3: {
                this.m03 = lllllllllllllIIllIlIlIIIIIlIIlIl[0];
                this.m13 = lllllllllllllIIllIlIlIIIIIlIIlIl[1];
                this.m23 = lllllllllllllIIllIlIlIIIIIlIIlIl[2];
                this.m33 = lllllllllllllIIllIlIlIIIIIlIIlIl[3];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d7"));
            }
        }
    }
    
    public final void setM01(final double lllllllllllllIIllIlIIIlllIIIlIII) {
        this.m01 = lllllllllllllIIllIlIIIlllIIIlIII;
    }
    
    public final void mulTransposeLeft(final Matrix4d lllllllllllllIIllIlIIlIlIIIlIlII, final Matrix4d lllllllllllllIIllIlIIlIIllllllll) {
        if (this != lllllllllllllIIllIlIIlIlIIIlIlII && this != lllllllllllllIIllIlIIlIIllllllll) {
            this.m00 = lllllllllllllIIllIlIIlIlIIIlIlII.m00 * lllllllllllllIIllIlIIlIIllllllll.m00 + lllllllllllllIIllIlIIlIlIIIlIlII.m10 * lllllllllllllIIllIlIIlIIllllllll.m10 + lllllllllllllIIllIlIIlIlIIIlIlII.m20 * lllllllllllllIIllIlIIlIIllllllll.m20 + lllllllllllllIIllIlIIlIlIIIlIlII.m30 * lllllllllllllIIllIlIIlIIllllllll.m30;
            this.m01 = lllllllllllllIIllIlIIlIlIIIlIlII.m00 * lllllllllllllIIllIlIIlIIllllllll.m01 + lllllllllllllIIllIlIIlIlIIIlIlII.m10 * lllllllllllllIIllIlIIlIIllllllll.m11 + lllllllllllllIIllIlIIlIlIIIlIlII.m20 * lllllllllllllIIllIlIIlIIllllllll.m21 + lllllllllllllIIllIlIIlIlIIIlIlII.m30 * lllllllllllllIIllIlIIlIIllllllll.m31;
            this.m02 = lllllllllllllIIllIlIIlIlIIIlIlII.m00 * lllllllllllllIIllIlIIlIIllllllll.m02 + lllllllllllllIIllIlIIlIlIIIlIlII.m10 * lllllllllllllIIllIlIIlIIllllllll.m12 + lllllllllllllIIllIlIIlIlIIIlIlII.m20 * lllllllllllllIIllIlIIlIIllllllll.m22 + lllllllllllllIIllIlIIlIlIIIlIlII.m30 * lllllllllllllIIllIlIIlIIllllllll.m32;
            this.m03 = lllllllllllllIIllIlIIlIlIIIlIlII.m00 * lllllllllllllIIllIlIIlIIllllllll.m03 + lllllllllllllIIllIlIIlIlIIIlIlII.m10 * lllllllllllllIIllIlIIlIIllllllll.m13 + lllllllllllllIIllIlIIlIlIIIlIlII.m20 * lllllllllllllIIllIlIIlIIllllllll.m23 + lllllllllllllIIllIlIIlIlIIIlIlII.m30 * lllllllllllllIIllIlIIlIIllllllll.m33;
            this.m10 = lllllllllllllIIllIlIIlIlIIIlIlII.m01 * lllllllllllllIIllIlIIlIIllllllll.m00 + lllllllllllllIIllIlIIlIlIIIlIlII.m11 * lllllllllllllIIllIlIIlIIllllllll.m10 + lllllllllllllIIllIlIIlIlIIIlIlII.m21 * lllllllllllllIIllIlIIlIIllllllll.m20 + lllllllllllllIIllIlIIlIlIIIlIlII.m31 * lllllllllllllIIllIlIIlIIllllllll.m30;
            this.m11 = lllllllllllllIIllIlIIlIlIIIlIlII.m01 * lllllllllllllIIllIlIIlIIllllllll.m01 + lllllllllllllIIllIlIIlIlIIIlIlII.m11 * lllllllllllllIIllIlIIlIIllllllll.m11 + lllllllllllllIIllIlIIlIlIIIlIlII.m21 * lllllllllllllIIllIlIIlIIllllllll.m21 + lllllllllllllIIllIlIIlIlIIIlIlII.m31 * lllllllllllllIIllIlIIlIIllllllll.m31;
            this.m12 = lllllllllllllIIllIlIIlIlIIIlIlII.m01 * lllllllllllllIIllIlIIlIIllllllll.m02 + lllllllllllllIIllIlIIlIlIIIlIlII.m11 * lllllllllllllIIllIlIIlIIllllllll.m12 + lllllllllllllIIllIlIIlIlIIIlIlII.m21 * lllllllllllllIIllIlIIlIIllllllll.m22 + lllllllllllllIIllIlIIlIlIIIlIlII.m31 * lllllllllllllIIllIlIIlIIllllllll.m32;
            this.m13 = lllllllllllllIIllIlIIlIlIIIlIlII.m01 * lllllllllllllIIllIlIIlIIllllllll.m03 + lllllllllllllIIllIlIIlIlIIIlIlII.m11 * lllllllllllllIIllIlIIlIIllllllll.m13 + lllllllllllllIIllIlIIlIlIIIlIlII.m21 * lllllllllllllIIllIlIIlIIllllllll.m23 + lllllllllllllIIllIlIIlIlIIIlIlII.m31 * lllllllllllllIIllIlIIlIIllllllll.m33;
            this.m20 = lllllllllllllIIllIlIIlIlIIIlIlII.m02 * lllllllllllllIIllIlIIlIIllllllll.m00 + lllllllllllllIIllIlIIlIlIIIlIlII.m12 * lllllllllllllIIllIlIIlIIllllllll.m10 + lllllllllllllIIllIlIIlIlIIIlIlII.m22 * lllllllllllllIIllIlIIlIIllllllll.m20 + lllllllllllllIIllIlIIlIlIIIlIlII.m32 * lllllllllllllIIllIlIIlIIllllllll.m30;
            this.m21 = lllllllllllllIIllIlIIlIlIIIlIlII.m02 * lllllllllllllIIllIlIIlIIllllllll.m01 + lllllllllllllIIllIlIIlIlIIIlIlII.m12 * lllllllllllllIIllIlIIlIIllllllll.m11 + lllllllllllllIIllIlIIlIlIIIlIlII.m22 * lllllllllllllIIllIlIIlIIllllllll.m21 + lllllllllllllIIllIlIIlIlIIIlIlII.m32 * lllllllllllllIIllIlIIlIIllllllll.m31;
            this.m22 = lllllllllllllIIllIlIIlIlIIIlIlII.m02 * lllllllllllllIIllIlIIlIIllllllll.m02 + lllllllllllllIIllIlIIlIlIIIlIlII.m12 * lllllllllllllIIllIlIIlIIllllllll.m12 + lllllllllllllIIllIlIIlIlIIIlIlII.m22 * lllllllllllllIIllIlIIlIIllllllll.m22 + lllllllllllllIIllIlIIlIlIIIlIlII.m32 * lllllllllllllIIllIlIIlIIllllllll.m32;
            this.m23 = lllllllllllllIIllIlIIlIlIIIlIlII.m02 * lllllllllllllIIllIlIIlIIllllllll.m03 + lllllllllllllIIllIlIIlIlIIIlIlII.m12 * lllllllllllllIIllIlIIlIIllllllll.m13 + lllllllllllllIIllIlIIlIlIIIlIlII.m22 * lllllllllllllIIllIlIIlIIllllllll.m23 + lllllllllllllIIllIlIIlIlIIIlIlII.m32 * lllllllllllllIIllIlIIlIIllllllll.m33;
            this.m30 = lllllllllllllIIllIlIIlIlIIIlIlII.m03 * lllllllllllllIIllIlIIlIIllllllll.m00 + lllllllllllllIIllIlIIlIlIIIlIlII.m13 * lllllllllllllIIllIlIIlIIllllllll.m10 + lllllllllllllIIllIlIIlIlIIIlIlII.m23 * lllllllllllllIIllIlIIlIIllllllll.m20 + lllllllllllllIIllIlIIlIlIIIlIlII.m33 * lllllllllllllIIllIlIIlIIllllllll.m30;
            this.m31 = lllllllllllllIIllIlIIlIlIIIlIlII.m03 * lllllllllllllIIllIlIIlIIllllllll.m01 + lllllllllllllIIllIlIIlIlIIIlIlII.m13 * lllllllllllllIIllIlIIlIIllllllll.m11 + lllllllllllllIIllIlIIlIlIIIlIlII.m23 * lllllllllllllIIllIlIIlIIllllllll.m21 + lllllllllllllIIllIlIIlIlIIIlIlII.m33 * lllllllllllllIIllIlIIlIIllllllll.m31;
            this.m32 = lllllllllllllIIllIlIIlIlIIIlIlII.m03 * lllllllllllllIIllIlIIlIIllllllll.m02 + lllllllllllllIIllIlIIlIlIIIlIlII.m13 * lllllllllllllIIllIlIIlIIllllllll.m12 + lllllllllllllIIllIlIIlIlIIIlIlII.m23 * lllllllllllllIIllIlIIlIIllllllll.m22 + lllllllllllllIIllIlIIlIlIIIlIlII.m33 * lllllllllllllIIllIlIIlIIllllllll.m32;
            this.m33 = lllllllllllllIIllIlIIlIlIIIlIlII.m03 * lllllllllllllIIllIlIIlIIllllllll.m03 + lllllllllllllIIllIlIIlIlIIIlIlII.m13 * lllllllllllllIIllIlIIlIIllllllll.m13 + lllllllllllllIIllIlIIlIlIIIlIlII.m23 * lllllllllllllIIllIlIIlIIllllllll.m23 + lllllllllllllIIllIlIIlIlIIIlIlII.m33 * lllllllllllllIIllIlIIlIIllllllll.m33;
        }
        else {
            final double lllllllllllllIIllIlIIlIlIIIlIIlI = lllllllllllllIIllIlIIlIlIIIlIlII.m00 * lllllllllllllIIllIlIIlIIllllllll.m00 + lllllllllllllIIllIlIIlIlIIIlIlII.m10 * lllllllllllllIIllIlIIlIIllllllll.m10 + lllllllllllllIIllIlIIlIlIIIlIlII.m20 * lllllllllllllIIllIlIIlIIllllllll.m20 + lllllllllllllIIllIlIIlIlIIIlIlII.m30 * lllllllllllllIIllIlIIlIIllllllll.m30;
            final double lllllllllllllIIllIlIIlIlIIIlIIIl = lllllllllllllIIllIlIIlIlIIIlIlII.m00 * lllllllllllllIIllIlIIlIIllllllll.m01 + lllllllllllllIIllIlIIlIlIIIlIlII.m10 * lllllllllllllIIllIlIIlIIllllllll.m11 + lllllllllllllIIllIlIIlIlIIIlIlII.m20 * lllllllllllllIIllIlIIlIIllllllll.m21 + lllllllllllllIIllIlIIlIlIIIlIlII.m30 * lllllllllllllIIllIlIIlIIllllllll.m31;
            final double lllllllllllllIIllIlIIlIlIIIlIIII = lllllllllllllIIllIlIIlIlIIIlIlII.m00 * lllllllllllllIIllIlIIlIIllllllll.m02 + lllllllllllllIIllIlIIlIlIIIlIlII.m10 * lllllllllllllIIllIlIIlIIllllllll.m12 + lllllllllllllIIllIlIIlIlIIIlIlII.m20 * lllllllllllllIIllIlIIlIIllllllll.m22 + lllllllllllllIIllIlIIlIlIIIlIlII.m30 * lllllllllllllIIllIlIIlIIllllllll.m32;
            final double lllllllllllllIIllIlIIlIlIIIIllll = lllllllllllllIIllIlIIlIlIIIlIlII.m00 * lllllllllllllIIllIlIIlIIllllllll.m03 + lllllllllllllIIllIlIIlIlIIIlIlII.m10 * lllllllllllllIIllIlIIlIIllllllll.m13 + lllllllllllllIIllIlIIlIlIIIlIlII.m20 * lllllllllllllIIllIlIIlIIllllllll.m23 + lllllllllllllIIllIlIIlIlIIIlIlII.m30 * lllllllllllllIIllIlIIlIIllllllll.m33;
            final double lllllllllllllIIllIlIIlIlIIIIlllI = lllllllllllllIIllIlIIlIlIIIlIlII.m01 * lllllllllllllIIllIlIIlIIllllllll.m00 + lllllllllllllIIllIlIIlIlIIIlIlII.m11 * lllllllllllllIIllIlIIlIIllllllll.m10 + lllllllllllllIIllIlIIlIlIIIlIlII.m21 * lllllllllllllIIllIlIIlIIllllllll.m20 + lllllllllllllIIllIlIIlIlIIIlIlII.m31 * lllllllllllllIIllIlIIlIIllllllll.m30;
            final double lllllllllllllIIllIlIIlIlIIIIllIl = lllllllllllllIIllIlIIlIlIIIlIlII.m01 * lllllllllllllIIllIlIIlIIllllllll.m01 + lllllllllllllIIllIlIIlIlIIIlIlII.m11 * lllllllllllllIIllIlIIlIIllllllll.m11 + lllllllllllllIIllIlIIlIlIIIlIlII.m21 * lllllllllllllIIllIlIIlIIllllllll.m21 + lllllllllllllIIllIlIIlIlIIIlIlII.m31 * lllllllllllllIIllIlIIlIIllllllll.m31;
            final double lllllllllllllIIllIlIIlIlIIIIllII = lllllllllllllIIllIlIIlIlIIIlIlII.m01 * lllllllllllllIIllIlIIlIIllllllll.m02 + lllllllllllllIIllIlIIlIlIIIlIlII.m11 * lllllllllllllIIllIlIIlIIllllllll.m12 + lllllllllllllIIllIlIIlIlIIIlIlII.m21 * lllllllllllllIIllIlIIlIIllllllll.m22 + lllllllllllllIIllIlIIlIlIIIlIlII.m31 * lllllllllllllIIllIlIIlIIllllllll.m32;
            final double lllllllllllllIIllIlIIlIlIIIIlIll = lllllllllllllIIllIlIIlIlIIIlIlII.m01 * lllllllllllllIIllIlIIlIIllllllll.m03 + lllllllllllllIIllIlIIlIlIIIlIlII.m11 * lllllllllllllIIllIlIIlIIllllllll.m13 + lllllllllllllIIllIlIIlIlIIIlIlII.m21 * lllllllllllllIIllIlIIlIIllllllll.m23 + lllllllllllllIIllIlIIlIlIIIlIlII.m31 * lllllllllllllIIllIlIIlIIllllllll.m33;
            final double lllllllllllllIIllIlIIlIlIIIIlIlI = lllllllllllllIIllIlIIlIlIIIlIlII.m02 * lllllllllllllIIllIlIIlIIllllllll.m00 + lllllllllllllIIllIlIIlIlIIIlIlII.m12 * lllllllllllllIIllIlIIlIIllllllll.m10 + lllllllllllllIIllIlIIlIlIIIlIlII.m22 * lllllllllllllIIllIlIIlIIllllllll.m20 + lllllllllllllIIllIlIIlIlIIIlIlII.m32 * lllllllllllllIIllIlIIlIIllllllll.m30;
            final double lllllllllllllIIllIlIIlIlIIIIlIIl = lllllllllllllIIllIlIIlIlIIIlIlII.m02 * lllllllllllllIIllIlIIlIIllllllll.m01 + lllllllllllllIIllIlIIlIlIIIlIlII.m12 * lllllllllllllIIllIlIIlIIllllllll.m11 + lllllllllllllIIllIlIIlIlIIIlIlII.m22 * lllllllllllllIIllIlIIlIIllllllll.m21 + lllllllllllllIIllIlIIlIlIIIlIlII.m32 * lllllllllllllIIllIlIIlIIllllllll.m31;
            final double lllllllllllllIIllIlIIlIlIIIIlIII = lllllllllllllIIllIlIIlIlIIIlIlII.m02 * lllllllllllllIIllIlIIlIIllllllll.m02 + lllllllllllllIIllIlIIlIlIIIlIlII.m12 * lllllllllllllIIllIlIIlIIllllllll.m12 + lllllllllllllIIllIlIIlIlIIIlIlII.m22 * lllllllllllllIIllIlIIlIIllllllll.m22 + lllllllllllllIIllIlIIlIlIIIlIlII.m32 * lllllllllllllIIllIlIIlIIllllllll.m32;
            final double lllllllllllllIIllIlIIlIlIIIIIlll = lllllllllllllIIllIlIIlIlIIIlIlII.m02 * lllllllllllllIIllIlIIlIIllllllll.m03 + lllllllllllllIIllIlIIlIlIIIlIlII.m12 * lllllllllllllIIllIlIIlIIllllllll.m13 + lllllllllllllIIllIlIIlIlIIIlIlII.m22 * lllllllllllllIIllIlIIlIIllllllll.m23 + lllllllllllllIIllIlIIlIlIIIlIlII.m32 * lllllllllllllIIllIlIIlIIllllllll.m33;
            final double lllllllllllllIIllIlIIlIlIIIIIllI = lllllllllllllIIllIlIIlIlIIIlIlII.m03 * lllllllllllllIIllIlIIlIIllllllll.m00 + lllllllllllllIIllIlIIlIlIIIlIlII.m13 * lllllllllllllIIllIlIIlIIllllllll.m10 + lllllllllllllIIllIlIIlIlIIIlIlII.m23 * lllllllllllllIIllIlIIlIIllllllll.m20 + lllllllllllllIIllIlIIlIlIIIlIlII.m33 * lllllllllllllIIllIlIIlIIllllllll.m30;
            final double lllllllllllllIIllIlIIlIlIIIIIlIl = lllllllllllllIIllIlIIlIlIIIlIlII.m03 * lllllllllllllIIllIlIIlIIllllllll.m01 + lllllllllllllIIllIlIIlIlIIIlIlII.m13 * lllllllllllllIIllIlIIlIIllllllll.m11 + lllllllllllllIIllIlIIlIlIIIlIlII.m23 * lllllllllllllIIllIlIIlIIllllllll.m21 + lllllllllllllIIllIlIIlIlIIIlIlII.m33 * lllllllllllllIIllIlIIlIIllllllll.m31;
            final double lllllllllllllIIllIlIIlIlIIIIIlII = lllllllllllllIIllIlIIlIlIIIlIlII.m03 * lllllllllllllIIllIlIIlIIllllllll.m02 + lllllllllllllIIllIlIIlIlIIIlIlII.m13 * lllllllllllllIIllIlIIlIIllllllll.m12 + lllllllllllllIIllIlIIlIlIIIlIlII.m23 * lllllllllllllIIllIlIIlIIllllllll.m22 + lllllllllllllIIllIlIIlIlIIIlIlII.m33 * lllllllllllllIIllIlIIlIIllllllll.m32;
            final double lllllllllllllIIllIlIIlIlIIIIIIll = lllllllllllllIIllIlIIlIlIIIlIlII.m03 * lllllllllllllIIllIlIIlIIllllllll.m03 + lllllllllllllIIllIlIIlIlIIIlIlII.m13 * lllllllllllllIIllIlIIlIIllllllll.m13 + lllllllllllllIIllIlIIlIlIIIlIlII.m23 * lllllllllllllIIllIlIIlIIllllllll.m23 + lllllllllllllIIllIlIIlIlIIIlIlII.m33 * lllllllllllllIIllIlIIlIIllllllll.m33;
            this.m00 = lllllllllllllIIllIlIIlIlIIIlIIlI;
            this.m01 = lllllllllllllIIllIlIIlIlIIIlIIIl;
            this.m02 = lllllllllllllIIllIlIIlIlIIIlIIII;
            this.m03 = lllllllllllllIIllIlIIlIlIIIIllll;
            this.m10 = lllllllllllllIIllIlIIlIlIIIIlllI;
            this.m11 = lllllllllllllIIllIlIIlIlIIIIllIl;
            this.m12 = lllllllllllllIIllIlIIlIlIIIIllII;
            this.m13 = lllllllllllllIIllIlIIlIlIIIIlIll;
            this.m20 = lllllllllllllIIllIlIIlIlIIIIlIlI;
            this.m21 = lllllllllllllIIllIlIIlIlIIIIlIIl;
            this.m22 = lllllllllllllIIllIlIIlIlIIIIlIII;
            this.m23 = lllllllllllllIIllIlIIlIlIIIIIlll;
            this.m30 = lllllllllllllIIllIlIIlIlIIIIIllI;
            this.m31 = lllllllllllllIIllIlIIlIlIIIIIlIl;
            this.m32 = lllllllllllllIIllIlIIlIlIIIIIlII;
            this.m33 = lllllllllllllIIllIlIIlIlIIIIIIll;
        }
    }
    
    public final void setM10(final double lllllllllllllIIllIlIIIllIlllIllI) {
        this.m10 = lllllllllllllIIllIlIIIllIlllIllI;
    }
    
    public final void set(final AxisAngle4f lllllllllllllIIllIlIIllllIIIllII) {
        double lllllllllllllIIllIlIIllllIIllIII = Math.sqrt(lllllllllllllIIllIlIIllllIIIllII.x * lllllllllllllIIllIlIIllllIIIllII.x + lllllllllllllIIllIlIIllllIIIllII.y * lllllllllllllIIllIlIIllllIIIllII.y + lllllllllllllIIllIlIIllllIIIllII.z * lllllllllllllIIllIlIIllllIIIllII.z);
        if (lllllllllllllIIllIlIIllllIIllIII < 1.0E-10) {
            this.m00 = 1.0;
            this.m01 = 0.0;
            this.m02 = 0.0;
            this.m10 = 0.0;
            this.m11 = 1.0;
            this.m12 = 0.0;
            this.m20 = 0.0;
            this.m21 = 0.0;
            this.m22 = 1.0;
        }
        else {
            lllllllllllllIIllIlIIllllIIllIII = 1.0 / lllllllllllllIIllIlIIllllIIllIII;
            final double lllllllllllllIIllIlIIllllIIlIlll = lllllllllllllIIllIlIIllllIIIllII.x * lllllllllllllIIllIlIIllllIIllIII;
            final double lllllllllllllIIllIlIIllllIIlIllI = lllllllllllllIIllIlIIllllIIIllII.y * lllllllllllllIIllIlIIllllIIllIII;
            final double lllllllllllllIIllIlIIllllIIlIlIl = lllllllllllllIIllIlIIllllIIIllII.z * lllllllllllllIIllIlIIllllIIllIII;
            final double lllllllllllllIIllIlIIllllIIlIlII = Math.sin(lllllllllllllIIllIlIIllllIIIllII.angle);
            final double lllllllllllllIIllIlIIllllIIlIIll = Math.cos(lllllllllllllIIllIlIIllllIIIllII.angle);
            final double lllllllllllllIIllIlIIllllIIlIIlI = 1.0 - lllllllllllllIIllIlIIllllIIlIIll;
            final double lllllllllllllIIllIlIIllllIIlIIIl = lllllllllllllIIllIlIIllllIIlIlll * lllllllllllllIIllIlIIllllIIlIlIl;
            final double lllllllllllllIIllIlIIllllIIlIIII = lllllllllllllIIllIlIIllllIIlIlll * lllllllllllllIIllIlIIllllIIlIllI;
            final double lllllllllllllIIllIlIIllllIIIllll = lllllllllllllIIllIlIIllllIIlIllI * lllllllllllllIIllIlIIllllIIlIlIl;
            this.m00 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIlIlll * lllllllllllllIIllIlIIllllIIlIlll + lllllllllllllIIllIlIIllllIIlIIll;
            this.m01 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIlIIII - lllllllllllllIIllIlIIllllIIlIlII * lllllllllllllIIllIlIIllllIIlIlIl;
            this.m02 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIlIIIl + lllllllllllllIIllIlIIllllIIlIlII * lllllllllllllIIllIlIIllllIIlIllI;
            this.m10 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIlIIII + lllllllllllllIIllIlIIllllIIlIlII * lllllllllllllIIllIlIIllllIIlIlIl;
            this.m11 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIlIllI * lllllllllllllIIllIlIIllllIIlIllI + lllllllllllllIIllIlIIllllIIlIIll;
            this.m12 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIIllll - lllllllllllllIIllIlIIllllIIlIlII * lllllllllllllIIllIlIIllllIIlIlll;
            this.m20 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIlIIIl - lllllllllllllIIllIlIIllllIIlIlII * lllllllllllllIIllIlIIllllIIlIllI;
            this.m21 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIIllll + lllllllllllllIIllIlIIllllIIlIlII * lllllllllllllIIllIlIIllllIIlIlll;
            this.m22 = lllllllllllllIIllIlIIllllIIlIIlI * lllllllllllllIIllIlIIllllIIlIlIl * lllllllllllllIIllIlIIllllIIlIlIl + lllllllllllllIIllIlIIllllIIlIIll;
        }
        this.m03 = 0.0;
        this.m13 = 0.0;
        this.m23 = 0.0;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
    
    public final void setElement(final int lllllllllllllIIllIlIlIIlIlIlllII, final int lllllllllllllIIllIlIlIIlIlIlIlll, final double lllllllllllllIIllIlIlIIlIlIlIllI) {
        Label_0352: {
            switch (lllllllllllllIIllIlIlIIlIlIlllII) {
                case 0: {
                    switch (lllllllllllllIIllIlIlIIlIlIlIlll) {
                        case 0: {
                            this.m00 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 1: {
                            this.m01 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 2: {
                            this.m02 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 3: {
                            this.m03 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
                        }
                    }
                    break;
                }
                case 1: {
                    switch (lllllllllllllIIllIlIlIIlIlIlIlll) {
                        case 0: {
                            this.m10 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 1: {
                            this.m11 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 2: {
                            this.m12 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 3: {
                            this.m13 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
                        }
                    }
                    break;
                }
                case 2: {
                    switch (lllllllllllllIIllIlIlIIlIlIlIlll) {
                        case 0: {
                            this.m20 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 1: {
                            this.m21 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 2: {
                            this.m22 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 3: {
                            this.m23 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
                        }
                    }
                    break;
                }
                case 3: {
                    switch (lllllllllllllIIllIlIlIIlIlIlIlll) {
                        case 0: {
                            this.m30 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 1: {
                            this.m31 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 2: {
                            this.m32 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        case 3: {
                            this.m33 = lllllllllllllIIllIlIlIIlIlIlIllI;
                            break Label_0352;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
                        }
                    }
                    break;
                }
                default: {
                    throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix4d0"));
                }
            }
        }
    }
    
    public final void setTranslation(final Vector3d lllllllllllllIIllIlIIllIlIIllIII) {
        this.m03 = lllllllllllllIIllIlIIllIlIIllIII.x;
        this.m13 = lllllllllllllIIllIlIIllIlIIllIII.y;
        this.m23 = lllllllllllllIIllIlIIllIlIIllIII.z;
    }
    
    public Matrix4d(final double[] lllllllllllllIIllIlIlIIlllIIIlII) {
        this.m00 = lllllllllllllIIllIlIlIIlllIIIlII[0];
        this.m01 = lllllllllllllIIllIlIlIIlllIIIlII[1];
        this.m02 = lllllllllllllIIllIlIlIIlllIIIlII[2];
        this.m03 = lllllllllllllIIllIlIlIIlllIIIlII[3];
        this.m10 = lllllllllllllIIllIlIlIIlllIIIlII[4];
        this.m11 = lllllllllllllIIllIlIlIIlllIIIlII[5];
        this.m12 = lllllllllllllIIllIlIlIIlllIIIlII[6];
        this.m13 = lllllllllllllIIllIlIlIIlllIIIlII[7];
        this.m20 = lllllllllllllIIllIlIlIIlllIIIlII[8];
        this.m21 = lllllllllllllIIllIlIlIIlllIIIlII[9];
        this.m22 = lllllllllllllIIllIlIlIIlllIIIlII[10];
        this.m23 = lllllllllllllIIllIlIlIIlllIIIlII[11];
        this.m30 = lllllllllllllIIllIlIlIIlllIIIlII[12];
        this.m31 = lllllllllllllIIllIlIlIIlllIIIlII[13];
        this.m32 = lllllllllllllIIllIlIlIIlllIIIlII[14];
        this.m33 = lllllllllllllIIllIlIlIIlllIIIlII[15];
    }
    
    public final void setRotation(final Matrix3f lllllllllllllIIllIlIIlIIIIIIIIIl) {
        final double[] lllllllllllllIIllIlIIlIIIIIIIIII = new double[9];
        final double[] lllllllllllllIIllIlIIIllllllllll = new double[3];
        this.getScaleRotate(lllllllllllllIIllIlIIIllllllllll, lllllllllllllIIllIlIIlIIIIIIIIII);
        this.m00 = lllllllllllllIIllIlIIlIIIIIIIIIl.m00 * lllllllllllllIIllIlIIIllllllllll[0];
        this.m01 = lllllllllllllIIllIlIIlIIIIIIIIIl.m01 * lllllllllllllIIllIlIIIllllllllll[1];
        this.m02 = lllllllllllllIIllIlIIlIIIIIIIIIl.m02 * lllllllllllllIIllIlIIIllllllllll[2];
        this.m10 = lllllllllllllIIllIlIIlIIIIIIIIIl.m10 * lllllllllllllIIllIlIIIllllllllll[0];
        this.m11 = lllllllllllllIIllIlIIlIIIIIIIIIl.m11 * lllllllllllllIIllIlIIIllllllllll[1];
        this.m12 = lllllllllllllIIllIlIIlIIIIIIIIIl.m12 * lllllllllllllIIllIlIIIllllllllll[2];
        this.m20 = lllllllllllllIIllIlIIlIIIIIIIIIl.m20 * lllllllllllllIIllIlIIIllllllllll[0];
        this.m21 = lllllllllllllIIllIlIIlIIIIIIIIIl.m21 * lllllllllllllIIllIlIIIllllllllll[1];
        this.m22 = lllllllllllllIIllIlIIlIIIIIIIIIl.m22 * lllllllllllllIIllIlIIIllllllllll[2];
    }
    
    public final void set(final Vector3d lllllllllllllIIllIlIIllIllIIlIII) {
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m03 = lllllllllllllIIllIlIIllIllIIlIII.x;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m13 = lllllllllllllIIllIlIIllIllIIlIII.y;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
        this.m23 = lllllllllllllIIllIlIIllIllIIlIII.z;
        this.m30 = 0.0;
        this.m31 = 0.0;
        this.m32 = 0.0;
        this.m33 = 1.0;
    }
}
