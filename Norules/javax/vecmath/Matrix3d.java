package javax.vecmath;

import java.io.*;

public class Matrix3d implements Cloneable, Serializable
{
    public /* synthetic */ double m21;
    public /* synthetic */ double m01;
    public /* synthetic */ double m02;
    public /* synthetic */ double m12;
    public /* synthetic */ double m22;
    public /* synthetic */ double m11;
    public /* synthetic */ double m20;
    public /* synthetic */ double m00;
    public /* synthetic */ double m10;
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.m00)).append(", ").append(this.m01).append(", ").append(this.m02).append("\n").append(this.m10).append(", ").append(this.m11).append(", ").append(this.m12).append("\n").append(this.m20).append(", ").append(this.m21).append(", ").append(this.m22).append("\n"));
    }
    
    static boolean luDecomposition(final double[] lllllllllllllIIlIlIIIIIIIlllIIll, final int[] lllllllllllllIIlIlIIIIIIIlIlIIll) {
        final double[] lllllllllllllIIlIlIIIIIIIlllIIIl = new double[3];
        int lllllllllllllIIlIlIIIIIIIllIlllI = 0;
        int lllllllllllllIIlIlIIIIIIIllIllIl = 0;
        int lllllllllllllIIlIlIIIIIIIlllIIII = 3;
        while (lllllllllllllIIlIlIIIIIIIlllIIII-- != 0) {
            double lllllllllllllIIlIlIIIIIIIllIllII = 0.0;
            int lllllllllllllIIlIlIIIIIIIllIllll = 3;
            while (lllllllllllllIIlIlIIIIIIIllIllll-- != 0) {
                double lllllllllllllIIlIlIIIIIIIllIlIll = lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIllIlllI++];
                lllllllllllllIIlIlIIIIIIIllIlIll = Math.abs(lllllllllllllIIlIlIIIIIIIllIlIll);
                if (lllllllllllllIIlIlIIIIIIIllIlIll > lllllllllllllIIlIlIIIIIIIllIllII) {
                    lllllllllllllIIlIlIIIIIIIllIllII = lllllllllllllIIlIlIIIIIIIllIlIll;
                }
            }
            if (lllllllllllllIIlIlIIIIIIIllIllII == 0.0) {
                return false;
            }
            lllllllllllllIIlIlIIIIIIIlllIIIl[lllllllllllllIIlIlIIIIIIIllIllIl++] = 1.0 / lllllllllllllIIlIlIIIIIIIllIllII;
        }
        final int lllllllllllllIIlIlIIIIIIIllIlIIl = 0;
        for (int lllllllllllllIIlIlIIIIIIIllIlIlI = 0; lllllllllllllIIlIlIIIIIIIllIlIlI < 3; ++lllllllllllllIIlIlIIIIIIIllIlIlI) {
            for (int lllllllllllllIIlIlIIIIIIIllIlIII = 0; lllllllllllllIIlIlIIIIIIIllIlIII < lllllllllllllIIlIlIIIIIIIllIlIlI; ++lllllllllllllIIlIlIIIIIIIllIlIII) {
                final int lllllllllllllIIlIlIIIIIIIllIIIll = lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * lllllllllllllIIlIlIIIIIIIllIlIII + lllllllllllllIIlIlIIIIIIIllIlIlI;
                double lllllllllllllIIlIlIIIIIIIlIllIlI = lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIllIIIll];
                int lllllllllllllIIlIlIIIIIIIllIIllI = lllllllllllllIIlIlIIIIIIIllIlIII;
                int lllllllllllllIIlIlIIIIIIIllIIIII = lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * lllllllllllllIIlIlIIIIIIIllIlIII;
                int lllllllllllllIIlIlIIIIIIIlIlllIl = lllllllllllllIIlIlIIIIIIIllIlIIl + lllllllllllllIIlIlIIIIIIIllIlIlI;
                while (lllllllllllllIIlIlIIIIIIIllIIllI-- != 0) {
                    lllllllllllllIIlIlIIIIIIIlIllIlI -= lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIllIIIII] * lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIlIlllIl];
                    ++lllllllllllllIIlIlIIIIIIIllIIIII;
                    lllllllllllllIIlIlIIIIIIIlIlllIl += 3;
                }
                lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIllIIIll] = lllllllllllllIIlIlIIIIIIIlIllIlI;
            }
            double lllllllllllllIIlIlIIIIIIIlIllIII = 0.0;
            int lllllllllllllIIlIlIIIIIIIllIIlll = -1;
            for (int lllllllllllllIIlIlIIIIIIIllIlIII = lllllllllllllIIlIlIIIIIIIllIlIlI; lllllllllllllIIlIlIIIIIIIllIlIII < 3; ++lllllllllllllIIlIlIIIIIIIllIlIII) {
                final int lllllllllllllIIlIlIIIIIIIllIIIlI = lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * lllllllllllllIIlIlIIIIIIIllIlIII + lllllllllllllIIlIlIIIIIIIllIlIlI;
                double lllllllllllllIIlIlIIIIIIIlIllIIl = lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIllIIIlI];
                int lllllllllllllIIlIlIIIIIIIllIIlIl = lllllllllllllIIlIlIIIIIIIllIlIlI;
                int lllllllllllllIIlIlIIIIIIIlIlllll = lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * lllllllllllllIIlIlIIIIIIIllIlIII;
                int lllllllllllllIIlIlIIIIIIIlIlllII = lllllllllllllIIlIlIIIIIIIllIlIIl + lllllllllllllIIlIlIIIIIIIllIlIlI;
                while (lllllllllllllIIlIlIIIIIIIllIIlIl-- != 0) {
                    lllllllllllllIIlIlIIIIIIIlIllIIl -= lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIlIlllll] * lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIlIlllII];
                    ++lllllllllllllIIlIlIIIIIIIlIlllll;
                    lllllllllllllIIlIlIIIIIIIlIlllII += 3;
                }
                lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIllIIIlI] = lllllllllllllIIlIlIIIIIIIlIllIIl;
                final double lllllllllllllIIlIlIIIIIIIlIlIlll;
                if ((lllllllllllllIIlIlIIIIIIIlIlIlll = lllllllllllllIIlIlIIIIIIIlllIIIl[lllllllllllllIIlIlIIIIIIIllIlIII] * Math.abs(lllllllllllllIIlIlIIIIIIIlIllIIl)) >= lllllllllllllIIlIlIIIIIIIlIllIII) {
                    lllllllllllllIIlIlIIIIIIIlIllIII = lllllllllllllIIlIlIIIIIIIlIlIlll;
                    lllllllllllllIIlIlIIIIIIIllIIlll = lllllllllllllIIlIlIIIIIIIllIlIII;
                }
            }
            if (lllllllllllllIIlIlIIIIIIIllIIlll < 0) {
                throw new RuntimeException(VecMathI18N.getString("Matrix3d13"));
            }
            if (lllllllllllllIIlIlIIIIIIIllIlIlI != lllllllllllllIIlIlIIIIIIIllIIlll) {
                int lllllllllllllIIlIlIIIIIIIllIIlII = 3;
                int lllllllllllllIIlIlIIIIIIIlIllllI = lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * lllllllllllllIIlIlIIIIIIIllIIlll;
                int lllllllllllllIIlIlIIIIIIIlIllIll = lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * lllllllllllllIIlIlIIIIIIIllIlIlI;
                while (lllllllllllllIIlIlIIIIIIIllIIlII-- != 0) {
                    final double lllllllllllllIIlIlIIIIIIIlIlIllI = lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIlIllllI];
                    lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIlIllllI++] = lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIlIllIll];
                    lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIlIllIll++] = lllllllllllllIIlIlIIIIIIIlIlIllI;
                }
                lllllllllllllIIlIlIIIIIIIlllIIIl[lllllllllllllIIlIlIIIIIIIllIIlll] = lllllllllllllIIlIlIIIIIIIlllIIIl[lllllllllllllIIlIlIIIIIIIllIlIlI];
            }
            lllllllllllllIIlIlIIIIIIIlIlIIll[lllllllllllllIIlIlIIIIIIIllIlIlI] = lllllllllllllIIlIlIIIIIIIllIIlll;
            if (lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * lllllllllllllIIlIlIIIIIIIllIlIlI + lllllllllllllIIlIlIIIIIIIllIlIlI] == 0.0) {
                return false;
            }
            if (lllllllllllllIIlIlIIIIIIIllIlIlI != 2) {
                final double lllllllllllllIIlIlIIIIIIIlIlIlIl = 1.0 / lllllllllllllIIlIlIIIIIIIlllIIll[lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * lllllllllllllIIlIlIIIIIIIllIlIlI + lllllllllllllIIlIlIIIIIIIllIlIlI];
                int lllllllllllllIIlIlIIIIIIIllIIIIl = lllllllllllllIIlIlIIIIIIIllIlIIl + 3 * (lllllllllllllIIlIlIIIIIIIllIlIlI + 1) + lllllllllllllIIlIlIIIIIIIllIlIlI;
                int lllllllllllllIIlIlIIIIIIIllIlIII = 2 - lllllllllllllIIlIlIIIIIIIllIlIlI;
                while (lllllllllllllIIlIlIIIIIIIllIlIII-- != 0) {
                    final int n = lllllllllllllIIlIlIIIIIIIllIIIIl;
                    lllllllllllllIIlIlIIIIIIIlllIIll[n] *= lllllllllllllIIlIlIIIIIIIlIlIlIl;
                    lllllllllllllIIlIlIIIIIIIllIIIIl += 3;
                }
            }
        }
        return true;
    }
    
    public final void setRow(final int lllllllllllllIIlIlIIIIIlIlllIIII, final Vector3d lllllllllllllIIlIlIIIIIlIlllIIlI) {
        switch (lllllllllllllIIlIlIIIIIlIlllIIII) {
            case 0: {
                this.m00 = lllllllllllllIIlIlIIIIIlIlllIIlI.x;
                this.m01 = lllllllllllllIIlIlIIIIIlIlllIIlI.y;
                this.m02 = lllllllllllllIIlIlIIIIIlIlllIIlI.z;
                break;
            }
            case 1: {
                this.m10 = lllllllllllllIIlIlIIIIIlIlllIIlI.x;
                this.m11 = lllllllllllllIIlIlIIIIIlIlllIIlI.y;
                this.m12 = lllllllllllllIIlIlIIIIIlIlllIIlI.z;
                break;
            }
            case 2: {
                this.m20 = lllllllllllllIIlIlIIIIIlIlllIIlI.x;
                this.m21 = lllllllllllllIIlIlIIIIIlIlllIIlI.y;
                this.m22 = lllllllllllllIIlIlIIIIIlIlllIIlI.z;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
            }
        }
    }
    
    public final double getScale() {
        final double[] lllllllllllllIIlIlIIIIIlIlIIIIII = new double[3];
        final double[] lllllllllllllIIlIlIIIIIlIIllllll = new double[9];
        this.getScaleRotate(lllllllllllllIIlIlIIIIIlIlIIIIII, lllllllllllllIIlIlIIIIIlIIllllll);
        return max3(lllllllllllllIIlIlIIIIIlIlIIIIII);
    }
    
    public final void setM00(final double lllllllllllllIIlIIllllIIIllllIIl) {
        this.m00 = lllllllllllllIIlIIllllIIIllllIIl;
    }
    
    static double d_sign(final double lllllllllllllIIlIIllllIllIllIlII, final double lllllllllllllIIlIIllllIllIllIIII) {
        final double lllllllllllllIIlIIllllIllIllIIlI = (lllllllllllllIIlIIllllIllIllIlII >= 0.0) ? lllllllllllllIIlIIllllIllIllIlII : (-lllllllllllllIIlIIllllIllIllIlII);
        return (lllllllllllllIIlIIllllIllIllIIII >= 0.0) ? lllllllllllllIIlIIllllIllIllIIlI : (-lllllllllllllIIlIIllllIllIllIIlI);
    }
    
    public final double getM22() {
        return this.m22;
    }
    
    public final void transform(final Tuple3d lllllllllllllIIlIIlllllIlIllIIIl) {
        final double lllllllllllllIIlIIlllllIlIllIIII = this.m00 * lllllllllllllIIlIIlllllIlIllIIIl.x + this.m01 * lllllllllllllIIlIIlllllIlIllIIIl.y + this.m02 * lllllllllllllIIlIIlllllIlIllIIIl.z;
        final double lllllllllllllIIlIIlllllIlIlIllll = this.m10 * lllllllllllllIIlIIlllllIlIllIIIl.x + this.m11 * lllllllllllllIIlIIlllllIlIllIIIl.y + this.m12 * lllllllllllllIIlIIlllllIlIllIIIl.z;
        final double lllllllllllllIIlIIlllllIlIlIlllI = this.m20 * lllllllllllllIIlIIlllllIlIllIIIl.x + this.m21 * lllllllllllllIIlIIlllllIlIllIIIl.y + this.m22 * lllllllllllllIIlIIlllllIlIllIIIl.z;
        lllllllllllllIIlIIlllllIlIllIIIl.set(lllllllllllllIIlIIlllllIlIllIIII, lllllllllllllIIlIIlllllIlIlIllll, lllllllllllllIIlIIlllllIlIlIlllI);
    }
    
    static void mat_mul(final double[] lllllllllllllIIlIIllllIIlIlIlllI, final double[] lllllllllllllIIlIIllllIIlIllIIlI, final double[] lllllllllllllIIlIIllllIIlIlIllII) {
        final double[] lllllllllllllIIlIIllllIIlIlIllll = { lllllllllllllIIlIIllllIIlIlIlllI[0] * lllllllllllllIIlIIllllIIlIllIIlI[0] + lllllllllllllIIlIIllllIIlIlIlllI[1] * lllllllllllllIIlIIllllIIlIllIIlI[3] + lllllllllllllIIlIIllllIIlIlIlllI[2] * lllllllllllllIIlIIllllIIlIllIIlI[6], lllllllllllllIIlIIllllIIlIlIlllI[0] * lllllllllllllIIlIIllllIIlIllIIlI[1] + lllllllllllllIIlIIllllIIlIlIlllI[1] * lllllllllllllIIlIIllllIIlIllIIlI[4] + lllllllllllllIIlIIllllIIlIlIlllI[2] * lllllllllllllIIlIIllllIIlIllIIlI[7], lllllllllllllIIlIIllllIIlIlIlllI[0] * lllllllllllllIIlIIllllIIlIllIIlI[2] + lllllllllllllIIlIIllllIIlIlIlllI[1] * lllllllllllllIIlIIllllIIlIllIIlI[5] + lllllllllllllIIlIIllllIIlIlIlllI[2] * lllllllllllllIIlIIllllIIlIllIIlI[8], lllllllllllllIIlIIllllIIlIlIlllI[3] * lllllllllllllIIlIIllllIIlIllIIlI[0] + lllllllllllllIIlIIllllIIlIlIlllI[4] * lllllllllllllIIlIIllllIIlIllIIlI[3] + lllllllllllllIIlIIllllIIlIlIlllI[5] * lllllllllllllIIlIIllllIIlIllIIlI[6], lllllllllllllIIlIIllllIIlIlIlllI[3] * lllllllllllllIIlIIllllIIlIllIIlI[1] + lllllllllllllIIlIIllllIIlIlIlllI[4] * lllllllllllllIIlIIllllIIlIllIIlI[4] + lllllllllllllIIlIIllllIIlIlIlllI[5] * lllllllllllllIIlIIllllIIlIllIIlI[7], lllllllllllllIIlIIllllIIlIlIlllI[3] * lllllllllllllIIlIIllllIIlIllIIlI[2] + lllllllllllllIIlIIllllIIlIlIlllI[4] * lllllllllllllIIlIIllllIIlIllIIlI[5] + lllllllllllllIIlIIllllIIlIlIlllI[5] * lllllllllllllIIlIIllllIIlIllIIlI[8], lllllllllllllIIlIIllllIIlIlIlllI[6] * lllllllllllllIIlIIllllIIlIllIIlI[0] + lllllllllllllIIlIIllllIIlIlIlllI[7] * lllllllllllllIIlIIllllIIlIllIIlI[3] + lllllllllllllIIlIIllllIIlIlIlllI[8] * lllllllllllllIIlIIllllIIlIllIIlI[6], lllllllllllllIIlIIllllIIlIlIlllI[6] * lllllllllllllIIlIIllllIIlIllIIlI[1] + lllllllllllllIIlIIllllIIlIlIlllI[7] * lllllllllllllIIlIIllllIIlIllIIlI[4] + lllllllllllllIIlIIllllIIlIlIlllI[8] * lllllllllllllIIlIIllllIIlIllIIlI[7], lllllllllllllIIlIIllllIIlIlIlllI[6] * lllllllllllllIIlIIllllIIlIllIIlI[2] + lllllllllllllIIlIIllllIIlIlIlllI[7] * lllllllllllllIIlIIllllIIlIllIIlI[5] + lllllllllllllIIlIIllllIIlIlIlllI[8] * lllllllllllllIIlIIllllIIlIllIIlI[8] };
        for (int lllllllllllllIIlIIllllIIlIllIIII = 0; lllllllllllllIIlIIllllIIlIllIIII < 9; ++lllllllllllllIIlIIllllIIlIllIIII) {
            lllllllllllllIIlIIllllIIlIlIllII[lllllllllllllIIlIIllllIIlIllIIII] = lllllllllllllIIlIIllllIIlIlIllll[lllllllllllllIIlIIllllIIlIllIIII];
        }
    }
    
    public final void setElement(final int lllllllllllllIIlIlIIIIIllIlllIlI, final int lllllllllllllIIlIlIIIIIllIllIlIl, final double lllllllllllllIIlIlIIIIIllIllIlII) {
        Label_0234: {
            switch (lllllllllllllIIlIlIIIIIllIlllIlI) {
                case 0: {
                    switch (lllllllllllllIIlIlIIIIIllIllIlIl) {
                        case 0: {
                            this.m00 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        case 1: {
                            this.m01 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        case 2: {
                            this.m02 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
                        }
                    }
                    break;
                }
                case 1: {
                    switch (lllllllllllllIIlIlIIIIIllIllIlIl) {
                        case 0: {
                            this.m10 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        case 1: {
                            this.m11 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        case 2: {
                            this.m12 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
                        }
                    }
                    break;
                }
                case 2: {
                    switch (lllllllllllllIIlIlIIIIIllIllIlIl) {
                        case 0: {
                            this.m20 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        case 1: {
                            this.m21 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        case 2: {
                            this.m22 = lllllllllllllIIlIlIIIIIllIllIlII;
                            break Label_0234;
                        }
                        default: {
                            throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
                        }
                    }
                    break;
                }
                default: {
                    throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d0"));
                }
            }
        }
    }
    
    public final void invert(final Matrix3d lllllllllllllIIlIlIIIIIIlIIlIlll) {
        this.invertGeneral(lllllllllllllIIlIlIIIIIIlIIlIlll);
    }
    
    public final void mulTransposeBoth(final Matrix3d lllllllllllllIIlIIllllllIllIllll, final Matrix3d lllllllllllllIIlIIllllllIllIIIIl) {
        if (this != lllllllllllllIIlIIllllllIllIllll && this != lllllllllllllIIlIIllllllIllIIIIl) {
            this.m00 = lllllllllllllIIlIIllllllIllIllll.m00 * lllllllllllllIIlIIllllllIllIIIIl.m00 + lllllllllllllIIlIIllllllIllIllll.m10 * lllllllllllllIIlIIllllllIllIIIIl.m01 + lllllllllllllIIlIIllllllIllIllll.m20 * lllllllllllllIIlIIllllllIllIIIIl.m02;
            this.m01 = lllllllllllllIIlIIllllllIllIllll.m00 * lllllllllllllIIlIIllllllIllIIIIl.m10 + lllllllllllllIIlIIllllllIllIllll.m10 * lllllllllllllIIlIIllllllIllIIIIl.m11 + lllllllllllllIIlIIllllllIllIllll.m20 * lllllllllllllIIlIIllllllIllIIIIl.m12;
            this.m02 = lllllllllllllIIlIIllllllIllIllll.m00 * lllllllllllllIIlIIllllllIllIIIIl.m20 + lllllllllllllIIlIIllllllIllIllll.m10 * lllllllllllllIIlIIllllllIllIIIIl.m21 + lllllllllllllIIlIIllllllIllIllll.m20 * lllllllllllllIIlIIllllllIllIIIIl.m22;
            this.m10 = lllllllllllllIIlIIllllllIllIllll.m01 * lllllllllllllIIlIIllllllIllIIIIl.m00 + lllllllllllllIIlIIllllllIllIllll.m11 * lllllllllllllIIlIIllllllIllIIIIl.m01 + lllllllllllllIIlIIllllllIllIllll.m21 * lllllllllllllIIlIIllllllIllIIIIl.m02;
            this.m11 = lllllllllllllIIlIIllllllIllIllll.m01 * lllllllllllllIIlIIllllllIllIIIIl.m10 + lllllllllllllIIlIIllllllIllIllll.m11 * lllllllllllllIIlIIllllllIllIIIIl.m11 + lllllllllllllIIlIIllllllIllIllll.m21 * lllllllllllllIIlIIllllllIllIIIIl.m12;
            this.m12 = lllllllllllllIIlIIllllllIllIllll.m01 * lllllllllllllIIlIIllllllIllIIIIl.m20 + lllllllllllllIIlIIllllllIllIllll.m11 * lllllllllllllIIlIIllllllIllIIIIl.m21 + lllllllllllllIIlIIllllllIllIllll.m21 * lllllllllllllIIlIIllllllIllIIIIl.m22;
            this.m20 = lllllllllllllIIlIIllllllIllIllll.m02 * lllllllllllllIIlIIllllllIllIIIIl.m00 + lllllllllllllIIlIIllllllIllIllll.m12 * lllllllllllllIIlIIllllllIllIIIIl.m01 + lllllllllllllIIlIIllllllIllIllll.m22 * lllllllllllllIIlIIllllllIllIIIIl.m02;
            this.m21 = lllllllllllllIIlIIllllllIllIllll.m02 * lllllllllllllIIlIIllllllIllIIIIl.m10 + lllllllllllllIIlIIllllllIllIllll.m12 * lllllllllllllIIlIIllllllIllIIIIl.m11 + lllllllllllllIIlIIllllllIllIllll.m22 * lllllllllllllIIlIIllllllIllIIIIl.m12;
            this.m22 = lllllllllllllIIlIIllllllIllIllll.m02 * lllllllllllllIIlIIllllllIllIIIIl.m20 + lllllllllllllIIlIIllllllIllIllll.m12 * lllllllllllllIIlIIllllllIllIIIIl.m21 + lllllllllllllIIlIIllllllIllIllll.m22 * lllllllllllllIIlIIllllllIllIIIIl.m22;
        }
        else {
            final double lllllllllllllIIlIIllllllIllIllIl = lllllllllllllIIlIIllllllIllIllll.m00 * lllllllllllllIIlIIllllllIllIIIIl.m00 + lllllllllllllIIlIIllllllIllIllll.m10 * lllllllllllllIIlIIllllllIllIIIIl.m01 + lllllllllllllIIlIIllllllIllIllll.m20 * lllllllllllllIIlIIllllllIllIIIIl.m02;
            final double lllllllllllllIIlIIllllllIllIllII = lllllllllllllIIlIIllllllIllIllll.m00 * lllllllllllllIIlIIllllllIllIIIIl.m10 + lllllllllllllIIlIIllllllIllIllll.m10 * lllllllllllllIIlIIllllllIllIIIIl.m11 + lllllllllllllIIlIIllllllIllIllll.m20 * lllllllllllllIIlIIllllllIllIIIIl.m12;
            final double lllllllllllllIIlIIllllllIllIlIll = lllllllllllllIIlIIllllllIllIllll.m00 * lllllllllllllIIlIIllllllIllIIIIl.m20 + lllllllllllllIIlIIllllllIllIllll.m10 * lllllllllllllIIlIIllllllIllIIIIl.m21 + lllllllllllllIIlIIllllllIllIllll.m20 * lllllllllllllIIlIIllllllIllIIIIl.m22;
            final double lllllllllllllIIlIIllllllIllIlIlI = lllllllllllllIIlIIllllllIllIllll.m01 * lllllllllllllIIlIIllllllIllIIIIl.m00 + lllllllllllllIIlIIllllllIllIllll.m11 * lllllllllllllIIlIIllllllIllIIIIl.m01 + lllllllllllllIIlIIllllllIllIllll.m21 * lllllllllllllIIlIIllllllIllIIIIl.m02;
            final double lllllllllllllIIlIIllllllIllIlIIl = lllllllllllllIIlIIllllllIllIllll.m01 * lllllllllllllIIlIIllllllIllIIIIl.m10 + lllllllllllllIIlIIllllllIllIllll.m11 * lllllllllllllIIlIIllllllIllIIIIl.m11 + lllllllllllllIIlIIllllllIllIllll.m21 * lllllllllllllIIlIIllllllIllIIIIl.m12;
            final double lllllllllllllIIlIIllllllIllIlIII = lllllllllllllIIlIIllllllIllIllll.m01 * lllllllllllllIIlIIllllllIllIIIIl.m20 + lllllllllllllIIlIIllllllIllIllll.m11 * lllllllllllllIIlIIllllllIllIIIIl.m21 + lllllllllllllIIlIIllllllIllIllll.m21 * lllllllllllllIIlIIllllllIllIIIIl.m22;
            final double lllllllllllllIIlIIllllllIllIIlll = lllllllllllllIIlIIllllllIllIllll.m02 * lllllllllllllIIlIIllllllIllIIIIl.m00 + lllllllllllllIIlIIllllllIllIllll.m12 * lllllllllllllIIlIIllllllIllIIIIl.m01 + lllllllllllllIIlIIllllllIllIllll.m22 * lllllllllllllIIlIIllllllIllIIIIl.m02;
            final double lllllllllllllIIlIIllllllIllIIllI = lllllllllllllIIlIIllllllIllIllll.m02 * lllllllllllllIIlIIllllllIllIIIIl.m10 + lllllllllllllIIlIIllllllIllIllll.m12 * lllllllllllllIIlIIllllllIllIIIIl.m11 + lllllllllllllIIlIIllllllIllIllll.m22 * lllllllllllllIIlIIllllllIllIIIIl.m12;
            final double lllllllllllllIIlIIllllllIllIIlIl = lllllllllllllIIlIIllllllIllIllll.m02 * lllllllllllllIIlIIllllllIllIIIIl.m20 + lllllllllllllIIlIIllllllIllIllll.m12 * lllllllllllllIIlIIllllllIllIIIIl.m21 + lllllllllllllIIlIIllllllIllIllll.m22 * lllllllllllllIIlIIllllllIllIIIIl.m22;
            this.m00 = lllllllllllllIIlIIllllllIllIllIl;
            this.m01 = lllllllllllllIIlIIllllllIllIllII;
            this.m02 = lllllllllllllIIlIIllllllIllIlIll;
            this.m10 = lllllllllllllIIlIIllllllIllIlIlI;
            this.m11 = lllllllllllllIIlIIllllllIllIlIIl;
            this.m12 = lllllllllllllIIlIIllllllIllIlIII;
            this.m20 = lllllllllllllIIlIIllllllIllIIlll;
            this.m21 = lllllllllllllIIlIIllllllIllIIllI;
            this.m22 = lllllllllllllIIlIIllllllIllIIlIl;
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIIlllllIllIlIlll) {
        try {
            final Matrix3d lllllllllllllIIlIIlllllIllIllIll = (Matrix3d)lllllllllllllIIlIIlllllIllIlIlll;
            return this.m00 == lllllllllllllIIlIIlllllIllIllIll.m00 && this.m01 == lllllllllllllIIlIIlllllIllIllIll.m01 && this.m02 == lllllllllllllIIlIIlllllIllIllIll.m02 && this.m10 == lllllllllllllIIlIIlllllIllIllIll.m10 && this.m11 == lllllllllllllIIlIIlllllIllIllIll.m11 && this.m12 == lllllllllllllIIlIIlllllIllIllIll.m12 && this.m20 == lllllllllllllIIlIIlllllIllIllIll.m20 && this.m21 == lllllllllllllIIlIIlllllIllIllIll.m21 && this.m22 == lllllllllllllIIlIIlllllIllIllIll.m22;
        }
        catch (ClassCastException lllllllllllllIIlIIlllllIllIllIlI) {
            return false;
        }
        catch (NullPointerException lllllllllllllIIlIIlllllIllIllIIl) {
            return false;
        }
    }
    
    public final void normalizeCP(final Matrix3d lllllllllllllIIlIIlllllIlllIlllI) {
        double lllllllllllllIIlIIlllllIlllIllIl = 1.0 / Math.sqrt(lllllllllllllIIlIIlllllIlllIlllI.m00 * lllllllllllllIIlIIlllllIlllIlllI.m00 + lllllllllllllIIlIIlllllIlllIlllI.m10 * lllllllllllllIIlIIlllllIlllIlllI.m10 + lllllllllllllIIlIIlllllIlllIlllI.m20 * lllllllllllllIIlIIlllllIlllIlllI.m20);
        this.m00 = lllllllllllllIIlIIlllllIlllIlllI.m00 * lllllllllllllIIlIIlllllIlllIllIl;
        this.m10 = lllllllllllllIIlIIlllllIlllIlllI.m10 * lllllllllllllIIlIIlllllIlllIllIl;
        this.m20 = lllllllllllllIIlIIlllllIlllIlllI.m20 * lllllllllllllIIlIIlllllIlllIllIl;
        lllllllllllllIIlIIlllllIlllIllIl = 1.0 / Math.sqrt(lllllllllllllIIlIIlllllIlllIlllI.m01 * lllllllllllllIIlIIlllllIlllIlllI.m01 + lllllllllllllIIlIIlllllIlllIlllI.m11 * lllllllllllllIIlIIlllllIlllIlllI.m11 + lllllllllllllIIlIIlllllIlllIlllI.m21 * lllllllllllllIIlIIlllllIlllIlllI.m21);
        this.m01 = lllllllllllllIIlIIlllllIlllIlllI.m01 * lllllllllllllIIlIIlllllIlllIllIl;
        this.m11 = lllllllllllllIIlIIlllllIlllIlllI.m11 * lllllllllllllIIlIIlllllIlllIllIl;
        this.m21 = lllllllllllllIIlIIlllllIlllIlllI.m21 * lllllllllllllIIlIIlllllIlllIllIl;
        this.m02 = this.m10 * this.m21 - this.m11 * this.m20;
        this.m12 = this.m01 * this.m20 - this.m00 * this.m21;
        this.m22 = this.m00 * this.m11 - this.m01 * this.m10;
    }
    
    public final double getM20() {
        return this.m20;
    }
    
    public final void setColumn(final int lllllllllllllIIlIlIIIIIlIlIIIllI, final double[] lllllllllllllIIlIlIIIIIlIlIIIlIl) {
        switch (lllllllllllllIIlIlIIIIIlIlIIIllI) {
            case 0: {
                this.m00 = lllllllllllllIIlIlIIIIIlIlIIIlIl[0];
                this.m10 = lllllllllllllIIlIlIIIIIlIlIIIlIl[1];
                this.m20 = lllllllllllllIIlIlIIIIIlIlIIIlIl[2];
                break;
            }
            case 1: {
                this.m01 = lllllllllllllIIlIlIIIIIlIlIIIlIl[0];
                this.m11 = lllllllllllllIIlIlIIIIIlIlIIIlIl[1];
                this.m21 = lllllllllllllIIlIlIIIIIlIlIIIlIl[2];
                break;
            }
            case 2: {
                this.m02 = lllllllllllllIIlIlIIIIIlIlIIIlIl[0];
                this.m12 = lllllllllllllIIlIlIIIIIlIlIIIlIl[1];
                this.m22 = lllllllllllllIIlIlIIIIIlIlIIIlIl[2];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
            }
        }
    }
    
    public final double getM00() {
        return this.m00;
    }
    
    public final double getElement(final int lllllllllllllIIlIlIIIIIllIlIllII, final int lllllllllllllIIlIlIIIIIllIlIlIll) {
        Label_0162: {
            switch (lllllllllllllIIlIlIIIIIllIlIllII) {
                case 0: {
                    switch (lllllllllllllIIlIlIIIIIllIlIlIll) {
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
                    switch (lllllllllllllIIlIlIIIIIllIlIlIll) {
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
                    switch (lllllllllllllIIlIlIIIIIllIlIlIll) {
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
        throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d1"));
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIIlIIlllllIllIIIllI = 1L;
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m00);
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m01);
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m02);
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m10);
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m11);
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m12);
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m20);
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m21);
        lllllllllllllIIlIIlllllIllIIIllI = VecMathUtil.hashDoubleBits(lllllllllllllIIlIIlllllIllIIIllI, this.m22);
        return VecMathUtil.hashFinish(lllllllllllllIIlIIlllllIllIIIllI);
    }
    
    public final double determinant() {
        final double lllllllllllllIIlIlIIIIIIIIIllllI = this.m00 * (this.m11 * this.m22 - this.m12 * this.m21) + this.m01 * (this.m12 * this.m20 - this.m10 * this.m22) + this.m02 * (this.m10 * this.m21 - this.m11 * this.m20);
        return lllllllllllllIIlIlIIIIIIIIIllllI;
    }
    
    public final void set(final double[] lllllllllllllIIlIlIIIIIIlIIlllIl) {
        this.m00 = lllllllllllllIIlIlIIIIIIlIIlllIl[0];
        this.m01 = lllllllllllllIIlIlIIIIIIlIIlllIl[1];
        this.m02 = lllllllllllllIIlIlIIIIIIlIIlllIl[2];
        this.m10 = lllllllllllllIIlIlIIIIIIlIIlllIl[3];
        this.m11 = lllllllllllllIIlIlIIIIIIlIIlllIl[4];
        this.m12 = lllllllllllllIIlIlIIIIIIlIIlllIl[5];
        this.m20 = lllllllllllllIIlIlIIIIIIlIIlllIl[6];
        this.m21 = lllllllllllllIIlIlIIIIIIlIIlllIl[7];
        this.m22 = lllllllllllllIIlIlIIIIIIlIIlllIl[8];
    }
    
    public final void setScale(final double lllllllllllllIIlIlIIIIIlllIIIllI) {
        final double[] lllllllllllllIIlIlIIIIIlllIIIlIl = new double[9];
        final double[] lllllllllllllIIlIlIIIIIlllIIIlII = new double[3];
        this.getScaleRotate(lllllllllllllIIlIlIIIIIlllIIIlII, lllllllllllllIIlIlIIIIIlllIIIlIl);
        this.m00 = lllllllllllllIIlIlIIIIIlllIIIlIl[0] * lllllllllllllIIlIlIIIIIlllIIIllI;
        this.m01 = lllllllllllllIIlIlIIIIIlllIIIlIl[1] * lllllllllllllIIlIlIIIIIlllIIIllI;
        this.m02 = lllllllllllllIIlIlIIIIIlllIIIlIl[2] * lllllllllllllIIlIlIIIIIlllIIIllI;
        this.m10 = lllllllllllllIIlIlIIIIIlllIIIlIl[3] * lllllllllllllIIlIlIIIIIlllIIIllI;
        this.m11 = lllllllllllllIIlIlIIIIIlllIIIlIl[4] * lllllllllllllIIlIlIIIIIlllIIIllI;
        this.m12 = lllllllllllllIIlIlIIIIIlllIIIlIl[5] * lllllllllllllIIlIlIIIIIlllIIIllI;
        this.m20 = lllllllllllllIIlIlIIIIIlllIIIlIl[6] * lllllllllllllIIlIlIIIIIlllIIIllI;
        this.m21 = lllllllllllllIIlIlIIIIIlllIIIlIl[7] * lllllllllllllIIlIlIIIIIlllIIIllI;
        this.m22 = lllllllllllllIIlIlIIIIIlllIIIlIl[8] * lllllllllllllIIlIlIIIIIlllIIIllI;
    }
    
    public final void transpose() {
        double lllllllllllllIIlIlIIIIIlIIIIlIll = this.m10;
        this.m10 = this.m01;
        this.m01 = lllllllllllllIIlIlIIIIIlIIIIlIll;
        lllllllllllllIIlIlIIIIIlIIIIlIll = this.m20;
        this.m20 = this.m02;
        this.m02 = lllllllllllllIIlIlIIIIIlIIIIlIll;
        lllllllllllllIIlIlIIIIIlIIIIlIll = this.m21;
        this.m21 = this.m12;
        this.m12 = lllllllllllllIIlIlIIIIIlIIIIlIll;
    }
    
    public final void getColumn(final int lllllllllllllIIlIlIIIIIllIIlIlII, final Vector3d lllllllllllllIIlIlIIIIIllIIlIIll) {
        if (lllllllllllllIIlIlIIIIIllIIlIlII == 0) {
            lllllllllllllIIlIlIIIIIllIIlIIll.x = this.m00;
            lllllllllllllIIlIlIIIIIllIIlIIll.y = this.m10;
            lllllllllllllIIlIlIIIIIllIIlIIll.z = this.m20;
        }
        else if (lllllllllllllIIlIlIIIIIllIIlIlII == 1) {
            lllllllllllllIIlIlIIIIIllIIlIIll.x = this.m01;
            lllllllllllllIIlIlIIIIIllIIlIIll.y = this.m11;
            lllllllllllllIIlIlIIIIIllIIlIIll.z = this.m21;
        }
        else {
            if (lllllllllllllIIlIlIIIIIllIIlIlII != 2) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d4"));
            }
            lllllllllllllIIlIlIIIIIllIIlIIll.x = this.m02;
            lllllllllllllIIlIlIIIIIllIIlIIll.y = this.m12;
            lllllllllllllIIlIlIIIIIllIIlIIll.z = this.m22;
        }
    }
    
    public final void setM01(final double lllllllllllllIIlIIllllIIIllIlllI) {
        this.m01 = lllllllllllllIIlIIllllIIIllIlllI;
    }
    
    public final void setM02(final double lllllllllllllIIlIIllllIIIllIIlll) {
        this.m02 = lllllllllllllIIlIIllllIIIllIIlll;
    }
    
    public Matrix3d(final Matrix3d lllllllllllllIIlIlIIIIIlllIlllIl) {
        this.m00 = lllllllllllllIIlIlIIIIIlllIlllIl.m00;
        this.m01 = lllllllllllllIIlIlIIIIIlllIlllIl.m01;
        this.m02 = lllllllllllllIIlIlIIIIIlllIlllIl.m02;
        this.m10 = lllllllllllllIIlIlIIIIIlllIlllIl.m10;
        this.m11 = lllllllllllllIIlIlIIIIIlllIlllIl.m11;
        this.m12 = lllllllllllllIIlIlIIIIIlllIlllIl.m12;
        this.m20 = lllllllllllllIIlIlIIIIIlllIlllIl.m20;
        this.m21 = lllllllllllllIIlIlIIIIIlllIlllIl.m21;
        this.m22 = lllllllllllllIIlIlIIIIIlllIlllIl.m22;
    }
    
    static int compute_qr(final double[] lllllllllllllIIlIIllllIlllllIIll, final double[] lllllllllllllIIlIIllllIlllIlIlll, final double[] lllllllllllllIIlIIllllIlllIlIlIl, final double[] lllllllllllllIIlIIllllIlllllIIII) {
        final double[] lllllllllllllIIlIIllllIllllIlIll = new double[2];
        final double[] lllllllllllllIIlIIllllIllllIlIlI = new double[2];
        final double[] lllllllllllllIIlIIllllIllllIlIIl = new double[2];
        final double[] lllllllllllllIIlIIllllIllllIlIII = new double[2];
        final double[] lllllllllllllIIlIIllllIllllIIlll = new double[9];
        final int lllllllllllllIIlIIllllIlllIllllI = 10;
        final double lllllllllllllIIlIIllllIlllIlllIl = 4.89E-15;
        final double lllllllllllllIIlIIllllIlllIlllII = 1.0;
        final double lllllllllllllIIlIIllllIlllIllIll = -1.0;
        boolean lllllllllllllIIlIIllllIllllIlllI = false;
        int lllllllllllllIIlIIllllIlllIllIlI = 1;
        if (Math.abs(lllllllllllllIIlIIllllIlllIlIlll[1]) < 4.89E-15 || Math.abs(lllllllllllllIIlIIllllIlllIlIlll[0]) < 4.89E-15) {
            lllllllllllllIIlIIllllIllllIlllI = true;
        }
        for (int lllllllllllllIIlIIllllIllllIllll = 0; lllllllllllllIIlIIllllIllllIllll < 10 && !lllllllllllllIIlIIllllIllllIlllI; ++lllllllllllllIIlIIllllIllllIllll) {
            final double lllllllllllllIIlIIllllIllllIllIl = compute_shift(lllllllllllllIIlIIllllIlllllIIll[1], lllllllllllllIIlIIllllIlllIlIlll[1], lllllllllllllIIlIIllllIlllllIIll[2]);
            double lllllllllllllIIlIIllllIllllIIIII = (Math.abs(lllllllllllllIIlIIllllIlllllIIll[0]) - lllllllllllllIIlIIllllIllllIllIl) * (d_sign(lllllllllllllIIlIIllllIlllIlllII, lllllllllllllIIlIIllllIlllllIIll[0]) + lllllllllllllIIlIIllllIllllIllIl / lllllllllllllIIlIIllllIlllllIIll[0]);
            double lllllllllllllIIlIIllllIlllIlllll = lllllllllllllIIlIIllllIlllIlIlll[0];
            double lllllllllllllIIlIIllllIllllIllII = compute_rot(lllllllllllllIIlIIllllIllllIIIII, lllllllllllllIIlIIllllIlllIlllll, lllllllllllllIIlIIllllIllllIlIII, lllllllllllllIIlIIllllIllllIlIlI, 0, lllllllllllllIIlIIllllIlllIllIlI);
            lllllllllllllIIlIIllllIllllIIIII = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIll[0] + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllIlIlll[0];
            lllllllllllllIIlIIllllIlllIlIlll[0] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllIlIlll[0] - lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIll[0];
            lllllllllllllIIlIIllllIlllIlllll = lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIll[1];
            lllllllllllllIIlIIllllIlllllIIll[1] *= lllllllllllllIIlIIllllIllllIlIlI[0];
            lllllllllllllIIlIIllllIllllIllII = compute_rot(lllllllllllllIIlIIllllIllllIIIII, lllllllllllllIIlIIllllIlllIlllll, lllllllllllllIIlIIllllIllllIlIIl, lllllllllllllIIlIIllllIllllIlIll, 0, lllllllllllllIIlIIllllIlllIllIlI);
            lllllllllllllIIlIIllllIlllIllIlI = 0;
            lllllllllllllIIlIIllllIlllllIIll[0] = lllllllllllllIIlIIllllIllllIllII;
            lllllllllllllIIlIIllllIllllIIIII = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlll[0] + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllllIIll[1];
            lllllllllllllIIlIIllllIlllllIIll[1] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllllIIll[1] - lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlll[0];
            lllllllllllllIIlIIllllIlllIlllll = lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlll[1];
            lllllllllllllIIlIIllllIlllIlIlll[1] *= lllllllllllllIIlIIllllIllllIlIll[0];
            lllllllllllllIIlIIllllIllllIllII = compute_rot(lllllllllllllIIlIIllllIllllIIIII, lllllllllllllIIlIIllllIlllIlllll, lllllllllllllIIlIIllllIllllIlIII, lllllllllllllIIlIIllllIllllIlIlI, 1, lllllllllllllIIlIIllllIlllIllIlI);
            lllllllllllllIIlIIllllIlllIlIlll[0] = lllllllllllllIIlIIllllIllllIllII;
            lllllllllllllIIlIIllllIllllIIIII = lllllllllllllIIlIIllllIllllIlIlI[1] * lllllllllllllIIlIIllllIlllllIIll[1] + lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIlllIlIlll[1];
            lllllllllllllIIlIIllllIlllIlIlll[1] = lllllllllllllIIlIIllllIllllIlIlI[1] * lllllllllllllIIlIIllllIlllIlIlll[1] - lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIlllllIIll[1];
            lllllllllllllIIlIIllllIlllIlllll = lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIlllllIIll[2];
            lllllllllllllIIlIIllllIlllllIIll[2] *= lllllllllllllIIlIIllllIllllIlIlI[1];
            lllllllllllllIIlIIllllIllllIllII = compute_rot(lllllllllllllIIlIIllllIllllIIIII, lllllllllllllIIlIIllllIlllIlllll, lllllllllllllIIlIIllllIllllIlIIl, lllllllllllllIIlIIllllIllllIlIll, 1, lllllllllllllIIlIIllllIlllIllIlI);
            lllllllllllllIIlIIllllIlllllIIll[1] = lllllllllllllIIlIIllllIllllIllII;
            lllllllllllllIIlIIllllIllllIIIII = lllllllllllllIIlIIllllIllllIlIll[1] * lllllllllllllIIlIIllllIlllIlIlll[1] + lllllllllllllIIlIIllllIllllIlIIl[1] * lllllllllllllIIlIIllllIlllllIIll[2];
            lllllllllllllIIlIIllllIlllllIIll[2] = lllllllllllllIIlIIllllIllllIlIll[1] * lllllllllllllIIlIIllllIlllllIIll[2] - lllllllllllllIIlIIllllIllllIlIIl[1] * lllllllllllllIIlIIllllIlllIlIlll[1];
            lllllllllllllIIlIIllllIlllIlIlll[1] = lllllllllllllIIlIIllllIllllIIIII;
            double lllllllllllllIIlIIllllIllllIIllI = lllllllllllllIIlIIllllIlllIlIlIl[0];
            lllllllllllllIIlIIllllIlllIlIlIl[0] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[3];
            lllllllllllllIIlIIllllIlllIlIlIl[3] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[3];
            lllllllllllllIIlIIllllIllllIIllI = lllllllllllllIIlIIllllIlllIlIlIl[1];
            lllllllllllllIIlIIllllIlllIlIlIl[1] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[4];
            lllllllllllllIIlIIllllIlllIlIlIl[4] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[4];
            lllllllllllllIIlIIllllIllllIIllI = lllllllllllllIIlIIllllIlllIlIlIl[2];
            lllllllllllllIIlIIllllIlllIlIlIl[2] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[5];
            lllllllllllllIIlIIllllIlllIlIlIl[5] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[5];
            lllllllllllllIIlIIllllIllllIIllI = lllllllllllllIIlIIllllIlllIlIlIl[3];
            lllllllllllllIIlIIllllIlllIlIlIl[3] = lllllllllllllIIlIIllllIllllIlIll[1] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIIl[1] * lllllllllllllIIlIIllllIlllIlIlIl[6];
            lllllllllllllIIlIIllllIlllIlIlIl[6] = -lllllllllllllIIlIIllllIllllIlIIl[1] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIll[1] * lllllllllllllIIlIIllllIlllIlIlIl[6];
            lllllllllllllIIlIIllllIllllIIllI = lllllllllllllIIlIIllllIlllIlIlIl[4];
            lllllllllllllIIlIIllllIlllIlIlIl[4] = lllllllllllllIIlIIllllIllllIlIll[1] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIIl[1] * lllllllllllllIIlIIllllIlllIlIlIl[7];
            lllllllllllllIIlIIllllIlllIlIlIl[7] = -lllllllllllllIIlIIllllIllllIlIIl[1] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIll[1] * lllllllllllllIIlIIllllIlllIlIlIl[7];
            lllllllllllllIIlIIllllIllllIIllI = lllllllllllllIIlIIllllIlllIlIlIl[5];
            lllllllllllllIIlIIllllIlllIlIlIl[5] = lllllllllllllIIlIIllllIllllIlIll[1] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIIl[1] * lllllllllllllIIlIIllllIlllIlIlIl[8];
            lllllllllllllIIlIIllllIlllIlIlIl[8] = -lllllllllllllIIlIIllllIllllIlIIl[1] * lllllllllllllIIlIIllllIllllIIllI + lllllllllllllIIlIIllllIllllIlIll[1] * lllllllllllllIIlIIllllIlllIlIlIl[8];
            double lllllllllllllIIlIIllllIllllIIIll = lllllllllllllIIlIIllllIlllllIIII[0];
            lllllllllllllIIlIIllllIlllllIIII[0] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[1];
            lllllllllllllIIlIIllllIlllllIIII[1] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[1];
            lllllllllllllIIlIIllllIllllIIIll = lllllllllllllIIlIIllllIlllllIIII[3];
            lllllllllllllIIlIIllllIlllllIIII[3] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[4];
            lllllllllllllIIlIIllllIlllllIIII[4] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[4];
            lllllllllllllIIlIIllllIllllIIIll = lllllllllllllIIlIIllllIlllllIIII[6];
            lllllllllllllIIlIIllllIlllllIIII[6] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[7];
            lllllllllllllIIlIIllllIlllllIIII[7] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[7];
            lllllllllllllIIlIIllllIllllIIIll = lllllllllllllIIlIIllllIlllllIIII[1];
            lllllllllllllIIlIIllllIlllllIIII[1] = lllllllllllllIIlIIllllIllllIlIlI[1] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIlllllIIII[2];
            lllllllllllllIIlIIllllIlllllIIII[2] = -lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIlI[1] * lllllllllllllIIlIIllllIlllllIIII[2];
            lllllllllllllIIlIIllllIllllIIIll = lllllllllllllIIlIIllllIlllllIIII[4];
            lllllllllllllIIlIIllllIlllllIIII[4] = lllllllllllllIIlIIllllIllllIlIlI[1] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIlllllIIII[5];
            lllllllllllllIIlIIllllIlllllIIII[5] = -lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIlI[1] * lllllllllllllIIlIIllllIlllllIIII[5];
            lllllllllllllIIlIIllllIllllIIIll = lllllllllllllIIlIIllllIlllllIIII[7];
            lllllllllllllIIlIIllllIlllllIIII[7] = lllllllllllllIIlIIllllIllllIlIlI[1] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIlllllIIII[8];
            lllllllllllllIIlIIllllIlllllIIII[8] = -lllllllllllllIIlIIllllIllllIlIII[1] * lllllllllllllIIlIIllllIllllIIIll + lllllllllllllIIlIIllllIllllIlIlI[1] * lllllllllllllIIlIIllllIlllllIIII[8];
            lllllllllllllIIlIIllllIllllIIlll[0] = lllllllllllllIIlIIllllIlllllIIll[0];
            lllllllllllllIIlIIllllIllllIIlll[1] = lllllllllllllIIlIIllllIlllIlIlll[0];
            lllllllllllllIIlIIllllIllllIIlll[3] = (lllllllllllllIIlIIllllIllllIIlll[2] = 0.0);
            lllllllllllllIIlIIllllIllllIIlll[4] = lllllllllllllIIlIIllllIlllllIIll[1];
            lllllllllllllIIlIIllllIllllIIlll[5] = lllllllllllllIIlIIllllIlllIlIlll[1];
            lllllllllllllIIlIIllllIllllIIlll[7] = (lllllllllllllIIlIIllllIllllIIlll[6] = 0.0);
            lllllllllllllIIlIIllllIllllIIlll[8] = lllllllllllllIIlIIllllIlllllIIll[2];
            if (Math.abs(lllllllllllllIIlIIllllIlllIlIlll[1]) < 4.89E-15 || Math.abs(lllllllllllllIIlIIllllIlllIlIlll[0]) < 4.89E-15) {
                lllllllllllllIIlIIllllIllllIlllI = true;
            }
        }
        if (Math.abs(lllllllllllllIIlIIllllIlllIlIlll[1]) < 4.89E-15) {
            compute_2X2(lllllllllllllIIlIIllllIlllllIIll[0], lllllllllllllIIlIIllllIlllIlIlll[0], lllllllllllllIIlIIllllIlllllIIll[1], lllllllllllllIIlIIllllIlllllIIll, lllllllllllllIIlIIllllIllllIlIIl, lllllllllllllIIlIIllllIllllIlIll, lllllllllllllIIlIIllllIllllIlIII, lllllllllllllIIlIIllllIllllIlIlI, 0);
            double lllllllllllllIIlIIllllIllllIIlIl = lllllllllllllIIlIIllllIlllIlIlIl[0];
            lllllllllllllIIlIIllllIlllIlIlIl[0] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIlIl + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[3];
            lllllllllllllIIlIIllllIlllIlIlIl[3] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIlIl + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[3];
            lllllllllllllIIlIIllllIllllIIlIl = lllllllllllllIIlIIllllIlllIlIlIl[1];
            lllllllllllllIIlIIllllIlllIlIlIl[1] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIlIl + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[4];
            lllllllllllllIIlIIllllIlllIlIlIl[4] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIlIl + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[4];
            lllllllllllllIIlIIllllIllllIIlIl = lllllllllllllIIlIIllllIlllIlIlIl[2];
            lllllllllllllIIlIIllllIlllIlIlIl[2] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIlIl + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[5];
            lllllllllllllIIlIIllllIlllIlIlIl[5] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIlIl + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[5];
            double lllllllllllllIIlIIllllIllllIIIlI = lllllllllllllIIlIIllllIlllllIIII[0];
            lllllllllllllIIlIIllllIlllllIIII[0] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIlI + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[1];
            lllllllllllllIIlIIllllIlllllIIII[1] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIlI + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[1];
            lllllllllllllIIlIIllllIllllIIIlI = lllllllllllllIIlIIllllIlllllIIII[3];
            lllllllllllllIIlIIllllIlllllIIII[3] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIlI + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[4];
            lllllllllllllIIlIIllllIlllllIIII[4] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIlI + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[4];
            lllllllllllllIIlIIllllIllllIIIlI = lllllllllllllIIlIIllllIlllllIIII[6];
            lllllllllllllIIlIIllllIlllllIIII[6] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIlI + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[7];
            lllllllllllllIIlIIllllIlllllIIII[7] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIlI + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[7];
        }
        else {
            compute_2X2(lllllllllllllIIlIIllllIlllllIIll[1], lllllllllllllIIlIIllllIlllIlIlll[1], lllllllllllllIIlIIllllIlllllIIll[2], lllllllllllllIIlIIllllIlllllIIll, lllllllllllllIIlIIllllIllllIlIIl, lllllllllllllIIlIIllllIllllIlIll, lllllllllllllIIlIIllllIllllIlIII, lllllllllllllIIlIIllllIllllIlIlI, 1);
            double lllllllllllllIIlIIllllIllllIIlII = lllllllllllllIIlIIllllIlllIlIlIl[3];
            lllllllllllllIIlIIllllIlllIlIlIl[3] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIlII + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[6];
            lllllllllllllIIlIIllllIlllIlIlIl[6] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIlII + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[6];
            lllllllllllllIIlIIllllIllllIIlII = lllllllllllllIIlIIllllIlllIlIlIl[4];
            lllllllllllllIIlIIllllIlllIlIlIl[4] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIlII + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[7];
            lllllllllllllIIlIIllllIlllIlIlIl[7] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIlII + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[7];
            lllllllllllllIIlIIllllIllllIIlII = lllllllllllllIIlIIllllIlllIlIlIl[5];
            lllllllllllllIIlIIllllIlllIlIlIl[5] = lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIllllIIlII + lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIlllIlIlIl[8];
            lllllllllllllIIlIIllllIlllIlIlIl[8] = -lllllllllllllIIlIIllllIllllIlIIl[0] * lllllllllllllIIlIIllllIllllIIlII + lllllllllllllIIlIIllllIllllIlIll[0] * lllllllllllllIIlIIllllIlllIlIlIl[8];
            double lllllllllllllIIlIIllllIllllIIIIl = lllllllllllllIIlIIllllIlllllIIII[1];
            lllllllllllllIIlIIllllIlllllIIII[1] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIIl + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[2];
            lllllllllllllIIlIIllllIlllllIIII[2] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIIl + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[2];
            lllllllllllllIIlIIllllIllllIIIIl = lllllllllllllIIlIIllllIlllllIIII[4];
            lllllllllllllIIlIIllllIlllllIIII[4] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIIl + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[5];
            lllllllllllllIIlIIllllIlllllIIII[5] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIIl + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[5];
            lllllllllllllIIlIIllllIllllIIIIl = lllllllllllllIIlIIllllIlllllIIII[7];
            lllllllllllllIIlIIllllIlllllIIII[7] = lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIllllIIIIl + lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIlllllIIII[8];
            lllllllllllllIIlIIllllIlllllIIII[8] = -lllllllllllllIIlIIllllIllllIlIII[0] * lllllllllllllIIlIIllllIllllIIIIl + lllllllllllllIIlIIllllIllllIlIlI[0] * lllllllllllllIIlIIllllIlllllIIII[8];
        }
        return 0;
    }
    
    public final void set(final Quat4f lllllllllllllIIlIlIIIIIIllIlIlIl) {
        this.m00 = 1.0 - 2.0 * lllllllllllllIIlIlIIIIIIllIlIlIl.y * lllllllllllllIIlIlIIIIIIllIlIlIl.y - 2.0 * lllllllllllllIIlIlIIIIIIllIlIlIl.z * lllllllllllllIIlIlIIIIIIllIlIlIl.z;
        this.m10 = 2.0 * (lllllllllllllIIlIlIIIIIIllIlIlIl.x * lllllllllllllIIlIlIIIIIIllIlIlIl.y + lllllllllllllIIlIlIIIIIIllIlIlIl.w * lllllllllllllIIlIlIIIIIIllIlIlIl.z);
        this.m20 = 2.0 * (lllllllllllllIIlIlIIIIIIllIlIlIl.x * lllllllllllllIIlIlIIIIIIllIlIlIl.z - lllllllllllllIIlIlIIIIIIllIlIlIl.w * lllllllllllllIIlIlIIIIIIllIlIlIl.y);
        this.m01 = 2.0 * (lllllllllllllIIlIlIIIIIIllIlIlIl.x * lllllllllllllIIlIlIIIIIIllIlIlIl.y - lllllllllllllIIlIlIIIIIIllIlIlIl.w * lllllllllllllIIlIlIIIIIIllIlIlIl.z);
        this.m11 = 1.0 - 2.0 * lllllllllllllIIlIlIIIIIIllIlIlIl.x * lllllllllllllIIlIlIIIIIIllIlIlIl.x - 2.0 * lllllllllllllIIlIlIIIIIIllIlIlIl.z * lllllllllllllIIlIlIIIIIIllIlIlIl.z;
        this.m21 = 2.0 * (lllllllllllllIIlIlIIIIIIllIlIlIl.y * lllllllllllllIIlIlIIIIIIllIlIlIl.z + lllllllllllllIIlIlIIIIIIllIlIlIl.w * lllllllllllllIIlIlIIIIIIllIlIlIl.x);
        this.m02 = 2.0 * (lllllllllllllIIlIlIIIIIIllIlIlIl.x * lllllllllllllIIlIlIIIIIIllIlIlIl.z + lllllllllllllIIlIlIIIIIIllIlIlIl.w * lllllllllllllIIlIlIIIIIIllIlIlIl.y);
        this.m12 = 2.0 * (lllllllllllllIIlIlIIIIIIllIlIlIl.y * lllllllllllllIIlIlIIIIIIllIlIlIl.z - lllllllllllllIIlIlIIIIIIllIlIlIl.w * lllllllllllllIIlIlIIIIIIllIlIlIl.x);
        this.m22 = 1.0 - 2.0 * lllllllllllllIIlIlIIIIIIllIlIlIl.x * lllllllllllllIIlIlIIIIIIllIlIlIl.x - 2.0 * lllllllllllllIIlIlIIIIIIllIlIlIl.y * lllllllllllllIIlIlIIIIIIllIlIlIl.y;
    }
    
    public Matrix3d(final double lllllllllllllIIlIlIIIIIllllllIIl, final double lllllllllllllIIlIlIIIIIllllIllIl, final double lllllllllllllIIlIlIIIIIllllIllII, final double lllllllllllllIIlIlIIIIIlllllIllI, final double lllllllllllllIIlIlIIIIIllllIlIlI, final double lllllllllllllIIlIlIIIIIlllllIlII, final double lllllllllllllIIlIlIIIIIllllIlIII, final double lllllllllllllIIlIlIIIIIllllIIlll, final double lllllllllllllIIlIlIIIIIllllIlllI) {
        this.m00 = lllllllllllllIIlIlIIIIIllllllIIl;
        this.m01 = lllllllllllllIIlIlIIIIIllllIllIl;
        this.m02 = lllllllllllllIIlIlIIIIIllllIllII;
        this.m10 = lllllllllllllIIlIlIIIIIlllllIllI;
        this.m11 = lllllllllllllIIlIlIIIIIllllIlIlI;
        this.m12 = lllllllllllllIIlIlIIIIIlllllIlII;
        this.m20 = lllllllllllllIIlIlIIIIIllllIlIII;
        this.m21 = lllllllllllllIIlIlIIIIIllllIIlll;
        this.m22 = lllllllllllllIIlIlIIIIIllllIlllI;
    }
    
    static void svdReorder(final double[] lllllllllllllIIlIIlllllIIIIllIII, final double[] lllllllllllllIIlIIlllllIIIIlIlll, final double[] lllllllllllllIIlIIlllllIIIllIlII, final double[] lllllllllllllIIlIIlllllIIIIlIlIl, final double[] lllllllllllllIIlIIlllllIIIIlIlII, final double[] lllllllllllllIIlIIlllllIIIllIIIl) {
        final int[] lllllllllllllIIlIIlllllIIIllIIII = new int[3];
        final int[] lllllllllllllIIlIIlllllIIIlIllll = new int[3];
        final double[] lllllllllllllIIlIIlllllIIIIllIlI = new double[3];
        final double[] lllllllllllllIIlIIlllllIIIIllIIl = new double[9];
        if (lllllllllllllIIlIIlllllIIIIlIlIl[0] < 0.0) {
            lllllllllllllIIlIIlllllIIIIlIlIl[0] = -lllllllllllllIIlIIlllllIIIIlIlIl[0];
            lllllllllllllIIlIIlllllIIIllIlII[0] = -lllllllllllllIIlIIlllllIIIllIlII[0];
            lllllllllllllIIlIIlllllIIIllIlII[1] = -lllllllllllllIIlIIlllllIIIllIlII[1];
            lllllllllllllIIlIIlllllIIIllIlII[2] = -lllllllllllllIIlIIlllllIIIllIlII[2];
        }
        if (lllllllllllllIIlIIlllllIIIIlIlIl[1] < 0.0) {
            lllllllllllllIIlIIlllllIIIIlIlIl[1] = -lllllllllllllIIlIIlllllIIIIlIlIl[1];
            lllllllllllllIIlIIlllllIIIllIlII[3] = -lllllllllllllIIlIIlllllIIIllIlII[3];
            lllllllllllllIIlIIlllllIIIllIlII[4] = -lllllllllllllIIlIIlllllIIIllIlII[4];
            lllllllllllllIIlIIlllllIIIllIlII[5] = -lllllllllllllIIlIIlllllIIIllIlII[5];
        }
        if (lllllllllllllIIlIIlllllIIIIlIlIl[2] < 0.0) {
            lllllllllllllIIlIIlllllIIIIlIlIl[2] = -lllllllllllllIIlIIlllllIIIIlIlIl[2];
            lllllllllllllIIlIIlllllIIIllIlII[6] = -lllllllllllllIIlIIlllllIIIllIlII[6];
            lllllllllllllIIlIIlllllIIIllIlII[7] = -lllllllllllllIIlIIlllllIIIllIlII[7];
            lllllllllllllIIlIIlllllIIIllIlII[8] = -lllllllllllllIIlIIlllllIIIllIlII[8];
        }
        mat_mul(lllllllllllllIIlIIlllllIIIIlIlll, lllllllllllllIIlIIlllllIIIllIlII, lllllllllllllIIlIIlllllIIIIllIIl);
        if (almostEqual(Math.abs(lllllllllllllIIlIIlllllIIIIlIlIl[0]), Math.abs(lllllllllllllIIlIIlllllIIIIlIlIl[1])) && almostEqual(Math.abs(lllllllllllllIIlIIlllllIIIIlIlIl[1]), Math.abs(lllllllllllllIIlIIlllllIIIIlIlIl[2]))) {
            for (int lllllllllllllIIlIIlllllIIIIllIll = 0; lllllllllllllIIlIIlllllIIIIllIll < 9; ++lllllllllllllIIlIIlllllIIIIllIll) {
                lllllllllllllIIlIIlllllIIIIlIlII[lllllllllllllIIlIIlllllIIIIllIll] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIllIll];
            }
            for (int lllllllllllllIIlIIlllllIIIIllIll = 0; lllllllllllllIIlIIlllllIIIIllIll < 3; ++lllllllllllllIIlIIlllllIIIIllIll) {
                lllllllllllllIIlIIlllllIIIllIIIl[lllllllllllllIIlIIlllllIIIIllIll] = lllllllllllllIIlIIlllllIIIIlIlIl[lllllllllllllIIlIIlllllIIIIllIll];
            }
        }
        else {
            if (lllllllllllllIIlIIlllllIIIIlIlIl[0] > lllllllllllllIIlIIlllllIIIIlIlIl[1]) {
                if (lllllllllllllIIlIIlllllIIIIlIlIl[0] > lllllllllllllIIlIIlllllIIIIlIlIl[2]) {
                    if (lllllllllllllIIlIIlllllIIIIlIlIl[2] > lllllllllllllIIlIIlllllIIIIlIlIl[1]) {
                        lllllllllllllIIlIIlllllIIIllIIII[0] = 0;
                        lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIllIIII[1] = 2] = 1;
                    }
                    else {
                        lllllllllllllIIlIIlllllIIIllIIII[0] = 0;
                        lllllllllllllIIlIIlllllIIIllIIII[1] = 1;
                        lllllllllllllIIlIIlllllIIIllIIII[2] = 2;
                    }
                }
                else {
                    lllllllllllllIIlIIlllllIIIllIIII[0] = 2;
                    lllllllllllllIIlIIlllllIIIllIIII[1] = 0;
                    lllllllllllllIIlIIlllllIIIllIIII[2] = 1;
                }
            }
            else if (lllllllllllllIIlIIlllllIIIIlIlIl[1] > lllllllllllllIIlIIlllllIIIIlIlIl[2]) {
                if (lllllllllllllIIlIIlllllIIIIlIlIl[2] > lllllllllllllIIlIIlllllIIIIlIlIl[0]) {
                    lllllllllllllIIlIIlllllIIIllIIII[0] = 1;
                    lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIllIIII[1] = 2] = 0;
                }
                else {
                    lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIllIIII[0] = 1] = 0;
                    lllllllllllllIIlIIlllllIIIllIIII[2] = 2;
                }
            }
            else {
                lllllllllllllIIlIIlllllIIIllIIII[0] = 2;
                lllllllllllllIIlIIlllllIIIllIIII[1] = 1;
                lllllllllllllIIlIIlllllIIIllIIII[2] = 0;
            }
            lllllllllllllIIlIIlllllIIIIllIlI[0] = lllllllllllllIIlIIlllllIIIIllIII[0] * lllllllllllllIIlIIlllllIIIIllIII[0] + lllllllllllllIIlIIlllllIIIIllIII[1] * lllllllllllllIIlIIlllllIIIIllIII[1] + lllllllllllllIIlIIlllllIIIIllIII[2] * lllllllllllllIIlIIlllllIIIIllIII[2];
            lllllllllllllIIlIIlllllIIIIllIlI[1] = lllllllllllllIIlIIlllllIIIIllIII[3] * lllllllllllllIIlIIlllllIIIIllIII[3] + lllllllllllllIIlIIlllllIIIIllIII[4] * lllllllllllllIIlIIlllllIIIIllIII[4] + lllllllllllllIIlIIlllllIIIIllIII[5] * lllllllllllllIIlIIlllllIIIIllIII[5];
            lllllllllllllIIlIIlllllIIIIllIlI[2] = lllllllllllllIIlIIlllllIIIIllIII[6] * lllllllllllllIIlIIlllllIIIIllIII[6] + lllllllllllllIIlIIlllllIIIIllIII[7] * lllllllllllllIIlIIlllllIIIIllIII[7] + lllllllllllllIIlIIlllllIIIIllIII[8] * lllllllllllllIIlIIlllllIIIIllIII[8];
            int lllllllllllllIIlIIlllllIIIIlllIl = 0;
            int lllllllllllllIIlIIlllllIIIlIIIll = 0;
            int lllllllllllllIIlIIlllllIIIlIlIIl = 0;
            if (lllllllllllllIIlIIlllllIIIIllIlI[0] > lllllllllllllIIlIIlllllIIIIllIlI[1]) {
                if (lllllllllllllIIlIIlllllIIIIllIlI[0] > lllllllllllllIIlIIlllllIIIIllIlI[2]) {
                    if (lllllllllllllIIlIIlllllIIIIllIlI[2] > lllllllllllllIIlIIlllllIIIIllIlI[1]) {
                        final int lllllllllllllIIlIIlllllIIIlIlllI = 0;
                        final int lllllllllllllIIlIIlllllIIIlIIIlI = 1;
                        final int lllllllllllllIIlIIlllllIIIlIlIII = 2;
                    }
                    else {
                        final int lllllllllllllIIlIIlllllIIIlIllIl = 0;
                        final int lllllllllllllIIlIIlllllIIIlIIlll = 1;
                        final int lllllllllllllIIlIIlllllIIIlIIIIl = 2;
                    }
                }
                else {
                    final int lllllllllllllIIlIIlllllIIIlIIIII = 0;
                    final int lllllllllllllIIlIIlllllIIIlIllII = 1;
                    final int lllllllllllllIIlIIlllllIIIlIIllI = 2;
                }
            }
            else if (lllllllllllllIIlIIlllllIIIIllIlI[1] > lllllllllllllIIlIIlllllIIIIllIlI[2]) {
                if (lllllllllllllIIlIIlllllIIIIllIlI[2] > lllllllllllllIIlIIlllllIIIIllIlI[0]) {
                    final int lllllllllllllIIlIIlllllIIIlIIlIl = 0;
                    final int lllllllllllllIIlIIlllllIIIIlllll = 1;
                    final int lllllllllllllIIlIIlllllIIIlIlIll = 2;
                }
                else {
                    final int lllllllllllllIIlIIlllllIIIlIIlII = 0;
                    final int lllllllllllllIIlIIlllllIIIlIlIlI = 1;
                    final int lllllllllllllIIlIIlllllIIIIllllI = 2;
                }
            }
            else {
                lllllllllllllIIlIIlllllIIIIlllIl = 0;
                lllllllllllllIIlIIlllllIIIlIIIll = 1;
                lllllllllllllIIlIIlllllIIIlIlIIl = 2;
            }
            int lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIlIlIIl];
            lllllllllllllIIlIIlllllIIIllIIIl[0] = lllllllllllllIIlIIlllllIIIIlIlIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIlIIIll];
            lllllllllllllIIlIIlllllIIIllIIIl[1] = lllllllllllllIIlIIlllllIIIIlIlIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIIlllIl];
            lllllllllllllIIlIIlllllIIIllIIIl[2] = lllllllllllllIIlIIlllllIIIIlIlIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIlIlIIl];
            lllllllllllllIIlIIlllllIIIIlIlII[0] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIlIlIIl] + 3;
            lllllllllllllIIlIIlllllIIIIlIlII[3] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIlIlIIl] + 6;
            lllllllllllllIIlIIlllllIIIIlIlII[6] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIlIIIll];
            lllllllllllllIIlIIlllllIIIIlIlII[1] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIlIIIll] + 3;
            lllllllllllllIIlIIlllllIIIIlIlII[4] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIlIIIll] + 6;
            lllllllllllllIIlIIlllllIIIIlIlII[7] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIIlllIl];
            lllllllllllllIIlIIlllllIIIIlIlII[2] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIIlllIl] + 3;
            lllllllllllllIIlIIlllllIIIIlIlII[5] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
            lllllllllllllIIlIIlllllIIIIlllII = lllllllllllllIIlIIlllllIIIllIIII[lllllllllllllIIlIIlllllIIIIlllIl] + 6;
            lllllllllllllIIlIIlllllIIIIlIlII[8] = lllllllllllllIIlIIlllllIIIIllIIl[lllllllllllllIIlIIlllllIIIIlllII];
        }
    }
    
    public final void setRow(final int lllllllllllllIIlIlIIIIIllIIIIIII, final double lllllllllllllIIlIlIIIIIlIlllllll, final double lllllllllllllIIlIlIIIIIlIllllllI, final double lllllllllllllIIlIlIIIIIlIllllIII) {
        switch (lllllllllllllIIlIlIIIIIllIIIIIII) {
            case 0: {
                this.m00 = lllllllllllllIIlIlIIIIIlIlllllll;
                this.m01 = lllllllllllllIIlIlIIIIIlIllllllI;
                this.m02 = lllllllllllllIIlIlIIIIIlIllllIII;
                break;
            }
            case 1: {
                this.m10 = lllllllllllllIIlIlIIIIIlIlllllll;
                this.m11 = lllllllllllllIIlIlIIIIIlIllllllI;
                this.m12 = lllllllllllllIIlIlIIIIIlIllllIII;
                break;
            }
            case 2: {
                this.m20 = lllllllllllllIIlIlIIIIIlIlllllll;
                this.m21 = lllllllllllllIIlIlIIIIIlIllllllI;
                this.m22 = lllllllllllllIIlIlIIIIIlIllllIII;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
            }
        }
    }
    
    public final void mulNormalize(final Matrix3d lllllllllllllIIlIIlllllllIIIIlll, final Matrix3d lllllllllllllIIlIIlllllllIIIIIII) {
        final double[] lllllllllllllIIlIIlllllllIIIIlIl = new double[9];
        final double[] lllllllllllllIIlIIlllllllIIIIlII = new double[9];
        final double[] lllllllllllllIIlIIlllllllIIIIIll = new double[3];
        lllllllllllllIIlIIlllllllIIIIlIl[0] = lllllllllllllIIlIIlllllllIIIIlll.m00 * lllllllllllllIIlIIlllllllIIIIIII.m00 + lllllllllllllIIlIIlllllllIIIIlll.m01 * lllllllllllllIIlIIlllllllIIIIIII.m10 + lllllllllllllIIlIIlllllllIIIIlll.m02 * lllllllllllllIIlIIlllllllIIIIIII.m20;
        lllllllllllllIIlIIlllllllIIIIlIl[1] = lllllllllllllIIlIIlllllllIIIIlll.m00 * lllllllllllllIIlIIlllllllIIIIIII.m01 + lllllllllllllIIlIIlllllllIIIIlll.m01 * lllllllllllllIIlIIlllllllIIIIIII.m11 + lllllllllllllIIlIIlllllllIIIIlll.m02 * lllllllllllllIIlIIlllllllIIIIIII.m21;
        lllllllllllllIIlIIlllllllIIIIlIl[2] = lllllllllllllIIlIIlllllllIIIIlll.m00 * lllllllllllllIIlIIlllllllIIIIIII.m02 + lllllllllllllIIlIIlllllllIIIIlll.m01 * lllllllllllllIIlIIlllllllIIIIIII.m12 + lllllllllllllIIlIIlllllllIIIIlll.m02 * lllllllllllllIIlIIlllllllIIIIIII.m22;
        lllllllllllllIIlIIlllllllIIIIlIl[3] = lllllllllllllIIlIIlllllllIIIIlll.m10 * lllllllllllllIIlIIlllllllIIIIIII.m00 + lllllllllllllIIlIIlllllllIIIIlll.m11 * lllllllllllllIIlIIlllllllIIIIIII.m10 + lllllllllllllIIlIIlllllllIIIIlll.m12 * lllllllllllllIIlIIlllllllIIIIIII.m20;
        lllllllllllllIIlIIlllllllIIIIlIl[4] = lllllllllllllIIlIIlllllllIIIIlll.m10 * lllllllllllllIIlIIlllllllIIIIIII.m01 + lllllllllllllIIlIIlllllllIIIIlll.m11 * lllllllllllllIIlIIlllllllIIIIIII.m11 + lllllllllllllIIlIIlllllllIIIIlll.m12 * lllllllllllllIIlIIlllllllIIIIIII.m21;
        lllllllllllllIIlIIlllllllIIIIlIl[5] = lllllllllllllIIlIIlllllllIIIIlll.m10 * lllllllllllllIIlIIlllllllIIIIIII.m02 + lllllllllllllIIlIIlllllllIIIIlll.m11 * lllllllllllllIIlIIlllllllIIIIIII.m12 + lllllllllllllIIlIIlllllllIIIIlll.m12 * lllllllllllllIIlIIlllllllIIIIIII.m22;
        lllllllllllllIIlIIlllllllIIIIlIl[6] = lllllllllllllIIlIIlllllllIIIIlll.m20 * lllllllllllllIIlIIlllllllIIIIIII.m00 + lllllllllllllIIlIIlllllllIIIIlll.m21 * lllllllllllllIIlIIlllllllIIIIIII.m10 + lllllllllllllIIlIIlllllllIIIIlll.m22 * lllllllllllllIIlIIlllllllIIIIIII.m20;
        lllllllllllllIIlIIlllllllIIIIlIl[7] = lllllllllllllIIlIIlllllllIIIIlll.m20 * lllllllllllllIIlIIlllllllIIIIIII.m01 + lllllllllllllIIlIIlllllllIIIIlll.m21 * lllllllllllllIIlIIlllllllIIIIIII.m11 + lllllllllllllIIlIIlllllllIIIIlll.m22 * lllllllllllllIIlIIlllllllIIIIIII.m21;
        lllllllllllllIIlIIlllllllIIIIlIl[8] = lllllllllllllIIlIIlllllllIIIIlll.m20 * lllllllllllllIIlIIlllllllIIIIIII.m02 + lllllllllllllIIlIIlllllllIIIIlll.m21 * lllllllllllllIIlIIlllllllIIIIIII.m12 + lllllllllllllIIlIIlllllllIIIIlll.m22 * lllllllllllllIIlIIlllllllIIIIIII.m22;
        compute_svd(lllllllllllllIIlIIlllllllIIIIlIl, lllllllllllllIIlIIlllllllIIIIIll, lllllllllllllIIlIIlllllllIIIIlII);
        this.m00 = lllllllllllllIIlIIlllllllIIIIlII[0];
        this.m01 = lllllllllllllIIlIIlllllllIIIIlII[1];
        this.m02 = lllllllllllllIIlIIlllllllIIIIlII[2];
        this.m10 = lllllllllllllIIlIIlllllllIIIIlII[3];
        this.m11 = lllllllllllllIIlIIlllllllIIIIlII[4];
        this.m12 = lllllllllllllIIlIIlllllllIIIIlII[5];
        this.m20 = lllllllllllllIIlIIlllllllIIIIlII[6];
        this.m21 = lllllllllllllIIlIIlllllllIIIIlII[7];
        this.m22 = lllllllllllllIIlIIlllllllIIIIlII[8];
    }
    
    private final void invertGeneral(final Matrix3d lllllllllllllIIlIlIIIIIIlIIIIllI) {
        final double[] lllllllllllllIIlIlIIIIIIlIIIlIll = new double[9];
        final int[] lllllllllllllIIlIlIIIIIIlIIIlIlI = new int[3];
        final double[] lllllllllllllIIlIlIIIIIIlIIIlIII = { lllllllllllllIIlIlIIIIIIlIIIIllI.m00, lllllllllllllIIlIlIIIIIIlIIIIllI.m01, lllllllllllllIIlIlIIIIIIlIIIIllI.m02, lllllllllllllIIlIlIIIIIIlIIIIllI.m10, lllllllllllllIIlIlIIIIIIlIIIIllI.m11, lllllllllllllIIlIlIIIIIIlIIIIllI.m12, lllllllllllllIIlIlIIIIIIlIIIIllI.m20, lllllllllllllIIlIlIIIIIIlIIIIllI.m21, lllllllllllllIIlIlIIIIIIlIIIIllI.m22 };
        if (!luDecomposition(lllllllllllllIIlIlIIIIIIlIIIlIII, lllllllllllllIIlIlIIIIIIlIIIlIlI)) {
            throw new SingularMatrixException(VecMathI18N.getString("Matrix3d12"));
        }
        for (int lllllllllllllIIlIlIIIIIIlIIIlIIl = 0; lllllllllllllIIlIlIIIIIIlIIIlIIl < 9; ++lllllllllllllIIlIlIIIIIIlIIIlIIl) {
            lllllllllllllIIlIlIIIIIIlIIIlIll[lllllllllllllIIlIlIIIIIIlIIIlIIl] = 0.0;
        }
        lllllllllllllIIlIlIIIIIIlIIIlIll[0] = 1.0;
        lllllllllllllIIlIlIIIIIIlIIIlIll[8] = (lllllllllllllIIlIlIIIIIIlIIIlIll[4] = 1.0);
        luBacksubstitution(lllllllllllllIIlIlIIIIIIlIIIlIII, lllllllllllllIIlIlIIIIIIlIIIlIlI, lllllllllllllIIlIlIIIIIIlIIIlIll);
        this.m00 = lllllllllllllIIlIlIIIIIIlIIIlIll[0];
        this.m01 = lllllllllllllIIlIlIIIIIIlIIIlIll[1];
        this.m02 = lllllllllllllIIlIlIIIIIIlIIIlIll[2];
        this.m10 = lllllllllllllIIlIlIIIIIIlIIIlIll[3];
        this.m11 = lllllllllllllIIlIlIIIIIIlIIIlIll[4];
        this.m12 = lllllllllllllIIlIlIIIIIIlIIIlIll[5];
        this.m20 = lllllllllllllIIlIlIIIIIIlIIIlIll[6];
        this.m21 = lllllllllllllIIlIlIIIIIIlIIIlIll[7];
        this.m22 = lllllllllllllIIlIlIIIIIIlIIIlIll[8];
    }
    
    public final void sub(final Matrix3d lllllllllllllIIlIlIIIIIlIIIIllll) {
        this.m00 -= lllllllllllllIIlIlIIIIIlIIIIllll.m00;
        this.m01 -= lllllllllllllIIlIlIIIIIlIIIIllll.m01;
        this.m02 -= lllllllllllllIIlIlIIIIIlIIIIllll.m02;
        this.m10 -= lllllllllllllIIlIlIIIIIlIIIIllll.m10;
        this.m11 -= lllllllllllllIIlIlIIIIIlIIIIllll.m11;
        this.m12 -= lllllllllllllIIlIlIIIIIlIIIIllll.m12;
        this.m20 -= lllllllllllllIIlIlIIIIIlIIIIllll.m20;
        this.m21 -= lllllllllllllIIlIlIIIIIlIIIIllll.m21;
        this.m22 -= lllllllllllllIIlIlIIIIIlIIIIllll.m22;
    }
    
    public final void add(final double lllllllllllllIIlIlIIIIIlIIllIllI) {
        this.m00 += lllllllllllllIIlIlIIIIIlIIllIllI;
        this.m01 += lllllllllllllIIlIlIIIIIlIIllIllI;
        this.m02 += lllllllllllllIIlIlIIIIIlIIllIllI;
        this.m10 += lllllllllllllIIlIlIIIIIlIIllIllI;
        this.m11 += lllllllllllllIIlIlIIIIIlIIllIllI;
        this.m12 += lllllllllllllIIlIlIIIIIlIIllIllI;
        this.m20 += lllllllllllllIIlIlIIIIIlIIllIllI;
        this.m21 += lllllllllllllIIlIlIIIIIlIIllIllI;
        this.m22 += lllllllllllllIIlIlIIIIIlIIllIllI;
    }
    
    public final void mul(final double lllllllllllllIIlIIlllllllllIIlll, final Matrix3d lllllllllllllIIlIIlllllllllIIllI) {
        this.m00 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m00;
        this.m01 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m01;
        this.m02 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m02;
        this.m10 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m10;
        this.m11 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m11;
        this.m12 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m12;
        this.m20 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m20;
        this.m21 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m21;
        this.m22 = lllllllllllllIIlIIlllllllllIIlll * lllllllllllllIIlIIlllllllllIIllI.m22;
    }
    
    static void print_mat(final double[] lllllllllllllIIlIIllllIIllIIIIlI) {
        for (int lllllllllllllIIlIIllllIIllIIIIIl = 0; lllllllllllllIIlIIllllIIllIIIIIl < 3; ++lllllllllllllIIlIIllllIIllIIIIIl) {
            System.out.println(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIIllllIIllIIIIlI[lllllllllllllIIlIIllllIIllIIIIIl * 3 + 0])).append(" ").append(lllllllllllllIIlIIllllIIllIIIIlI[lllllllllllllIIlIIllllIIllIIIIIl * 3 + 1]).append(" ").append(lllllllllllllIIlIIllllIIllIIIIlI[lllllllllllllIIlIIllllIIllIIIIIl * 3 + 2]).append("\n")));
        }
    }
    
    public final void mul(final Matrix3d lllllllllllllIIlIIllllllllIIlIlI) {
        final double lllllllllllllIIlIIllllllllIlIlIl = this.m00 * lllllllllllllIIlIIllllllllIIlIlI.m00 + this.m01 * lllllllllllllIIlIIllllllllIIlIlI.m10 + this.m02 * lllllllllllllIIlIIllllllllIIlIlI.m20;
        final double lllllllllllllIIlIIllllllllIlIlII = this.m00 * lllllllllllllIIlIIllllllllIIlIlI.m01 + this.m01 * lllllllllllllIIlIIllllllllIIlIlI.m11 + this.m02 * lllllllllllllIIlIIllllllllIIlIlI.m21;
        final double lllllllllllllIIlIIllllllllIlIIll = this.m00 * lllllllllllllIIlIIllllllllIIlIlI.m02 + this.m01 * lllllllllllllIIlIIllllllllIIlIlI.m12 + this.m02 * lllllllllllllIIlIIllllllllIIlIlI.m22;
        final double lllllllllllllIIlIIllllllllIlIIlI = this.m10 * lllllllllllllIIlIIllllllllIIlIlI.m00 + this.m11 * lllllllllllllIIlIIllllllllIIlIlI.m10 + this.m12 * lllllllllllllIIlIIllllllllIIlIlI.m20;
        final double lllllllllllllIIlIIllllllllIlIIIl = this.m10 * lllllllllllllIIlIIllllllllIIlIlI.m01 + this.m11 * lllllllllllllIIlIIllllllllIIlIlI.m11 + this.m12 * lllllllllllllIIlIIllllllllIIlIlI.m21;
        final double lllllllllllllIIlIIllllllllIlIIII = this.m10 * lllllllllllllIIlIIllllllllIIlIlI.m02 + this.m11 * lllllllllllllIIlIIllllllllIIlIlI.m12 + this.m12 * lllllllllllllIIlIIllllllllIIlIlI.m22;
        final double lllllllllllllIIlIIllllllllIIllll = this.m20 * lllllllllllllIIlIIllllllllIIlIlI.m00 + this.m21 * lllllllllllllIIlIIllllllllIIlIlI.m10 + this.m22 * lllllllllllllIIlIIllllllllIIlIlI.m20;
        final double lllllllllllllIIlIIllllllllIIlllI = this.m20 * lllllllllllllIIlIIllllllllIIlIlI.m01 + this.m21 * lllllllllllllIIlIIllllllllIIlIlI.m11 + this.m22 * lllllllllllllIIlIIllllllllIIlIlI.m21;
        final double lllllllllllllIIlIIllllllllIIllIl = this.m20 * lllllllllllllIIlIIllllllllIIlIlI.m02 + this.m21 * lllllllllllllIIlIIllllllllIIlIlI.m12 + this.m22 * lllllllllllllIIlIIllllllllIIlIlI.m22;
        this.m00 = lllllllllllllIIlIIllllllllIlIlIl;
        this.m01 = lllllllllllllIIlIIllllllllIlIlII;
        this.m02 = lllllllllllllIIlIIllllllllIlIIll;
        this.m10 = lllllllllllllIIlIIllllllllIlIIlI;
        this.m11 = lllllllllllllIIlIIllllllllIlIIIl;
        this.m12 = lllllllllllllIIlIIllllllllIlIIII;
        this.m20 = lllllllllllllIIlIIllllllllIIllll;
        this.m21 = lllllllllllllIIlIIllllllllIIlllI;
        this.m22 = lllllllllllllIIlIIllllllllIIllIl;
    }
    
    public final void mulNormalize(final Matrix3d lllllllllllllIIlIIlllllllIIlIlll) {
        final double[] lllllllllllllIIlIIlllllllIIlIllI = new double[9];
        final double[] lllllllllllllIIlIIlllllllIIlIlIl = new double[9];
        final double[] lllllllllllllIIlIIlllllllIIlIlII = new double[3];
        lllllllllllllIIlIIlllllllIIlIllI[0] = this.m00 * lllllllllllllIIlIIlllllllIIlIlll.m00 + this.m01 * lllllllllllllIIlIIlllllllIIlIlll.m10 + this.m02 * lllllllllllllIIlIIlllllllIIlIlll.m20;
        lllllllllllllIIlIIlllllllIIlIllI[1] = this.m00 * lllllllllllllIIlIIlllllllIIlIlll.m01 + this.m01 * lllllllllllllIIlIIlllllllIIlIlll.m11 + this.m02 * lllllllllllllIIlIIlllllllIIlIlll.m21;
        lllllllllllllIIlIIlllllllIIlIllI[2] = this.m00 * lllllllllllllIIlIIlllllllIIlIlll.m02 + this.m01 * lllllllllllllIIlIIlllllllIIlIlll.m12 + this.m02 * lllllllllllllIIlIIlllllllIIlIlll.m22;
        lllllllllllllIIlIIlllllllIIlIllI[3] = this.m10 * lllllllllllllIIlIIlllllllIIlIlll.m00 + this.m11 * lllllllllllllIIlIIlllllllIIlIlll.m10 + this.m12 * lllllllllllllIIlIIlllllllIIlIlll.m20;
        lllllllllllllIIlIIlllllllIIlIllI[4] = this.m10 * lllllllllllllIIlIIlllllllIIlIlll.m01 + this.m11 * lllllllllllllIIlIIlllllllIIlIlll.m11 + this.m12 * lllllllllllllIIlIIlllllllIIlIlll.m21;
        lllllllllllllIIlIIlllllllIIlIllI[5] = this.m10 * lllllllllllllIIlIIlllllllIIlIlll.m02 + this.m11 * lllllllllllllIIlIIlllllllIIlIlll.m12 + this.m12 * lllllllllllllIIlIIlllllllIIlIlll.m22;
        lllllllllllllIIlIIlllllllIIlIllI[6] = this.m20 * lllllllllllllIIlIIlllllllIIlIlll.m00 + this.m21 * lllllllllllllIIlIIlllllllIIlIlll.m10 + this.m22 * lllllllllllllIIlIIlllllllIIlIlll.m20;
        lllllllllllllIIlIIlllllllIIlIllI[7] = this.m20 * lllllllllllllIIlIIlllllllIIlIlll.m01 + this.m21 * lllllllllllllIIlIIlllllllIIlIlll.m11 + this.m22 * lllllllllllllIIlIIlllllllIIlIlll.m21;
        lllllllllllllIIlIIlllllllIIlIllI[8] = this.m20 * lllllllllllllIIlIIlllllllIIlIlll.m02 + this.m21 * lllllllllllllIIlIIlllllllIIlIlll.m12 + this.m22 * lllllllllllllIIlIIlllllllIIlIlll.m22;
        compute_svd(lllllllllllllIIlIIlllllllIIlIllI, lllllllllllllIIlIIlllllllIIlIlII, lllllllllllllIIlIIlllllllIIlIlIl);
        this.m00 = lllllllllllllIIlIIlllllllIIlIlIl[0];
        this.m01 = lllllllllllllIIlIIlllllllIIlIlIl[1];
        this.m02 = lllllllllllllIIlIIlllllllIIlIlIl[2];
        this.m10 = lllllllllllllIIlIIlllllllIIlIlIl[3];
        this.m11 = lllllllllllllIIlIIlllllllIIlIlIl[4];
        this.m12 = lllllllllllllIIlIIlllllllIIlIlIl[5];
        this.m20 = lllllllllllllIIlIIlllllllIIlIlIl[6];
        this.m21 = lllllllllllllIIlIIlllllllIIlIlIl[7];
        this.m22 = lllllllllllllIIlIIlllllllIIlIlIl[8];
    }
    
    static int compute_2X2(final double lllllllllllllIIlIIllllIlIlIlIIll, final double lllllllllllllIIlIIllllIlIIlIlIII, final double lllllllllllllIIlIIllllIlIlIlIIIl, final double[] lllllllllllllIIlIIllllIlIlIlIIII, final double[] lllllllllllllIIlIIllllIlIIlIIlIl, final double[] lllllllllllllIIlIIllllIlIlIIlllI, final double[] lllllllllllllIIlIIllllIlIIlIIIll, final double[] lllllllllllllIIlIIllllIlIIlIIIlI, final int lllllllllllllIIlIIllllIlIIlIIIIl) {
        final double lllllllllllllIIlIIllllIlIlIIlIlI = 2.0;
        final double lllllllllllllIIlIIllllIlIlIIlIIl = 1.0;
        double lllllllllllllIIlIIllllIlIIlIlIll = lllllllllllllIIlIIllllIlIlIlIIII[0];
        double lllllllllllllIIlIIllllIlIIlIllII = lllllllllllllIIlIIllllIlIlIlIIII[1];
        double lllllllllllllIIlIIllllIlIIllIIII = 0.0;
        double lllllllllllllIIlIIllllIlIIlIllll = 0.0;
        double lllllllllllllIIlIIllllIlIIlIlllI = 0.0;
        double lllllllllllllIIlIIllllIlIIlIllIl = 0.0;
        double lllllllllllllIIlIIllllIlIIlllIlI = 0.0;
        double lllllllllllllIIlIIllllIlIIllIllI = lllllllllllllIIlIIllllIlIlIlIIll;
        double lllllllllllllIIlIIllllIlIIlllIIl = Math.abs(lllllllllllllIIlIIllllIlIIllIllI);
        double lllllllllllllIIlIIllllIlIIllIlII = lllllllllllllIIlIIllllIlIlIlIIIl;
        double lllllllllllllIIlIIllllIlIIllIlll = Math.abs(lllllllllllllIIlIIllllIlIlIlIIIl);
        int lllllllllllllIIlIIllllIlIlIIIlll = 1;
        boolean lllllllllllllIIlIIllllIlIlIIIlII = false;
        if (lllllllllllllIIlIIllllIlIIllIlll > lllllllllllllIIlIIllllIlIIlllIIl) {
            final boolean lllllllllllllIIlIIllllIlIlIIIlIl = true;
        }
        else {
            lllllllllllllIIlIIllllIlIlIIIlII = false;
        }
        if (lllllllllllllIIlIIllllIlIlIIIlII) {
            lllllllllllllIIlIIllllIlIlIIIlll = 3;
            double lllllllllllllIIlIIllllIlIlIIIllI = lllllllllllllIIlIIllllIlIIllIllI;
            lllllllllllllIIlIIllllIlIIllIllI = lllllllllllllIIlIIllllIlIIllIlII;
            lllllllllllllIIlIIllllIlIIllIlII = lllllllllllllIIlIIllllIlIlIIIllI;
            lllllllllllllIIlIIllllIlIlIIIllI = lllllllllllllIIlIIllllIlIIlllIIl;
            lllllllllllllIIlIIllllIlIIlllIIl = lllllllllllllIIlIIllllIlIIllIlll;
            lllllllllllllIIlIIllllIlIIllIlll = lllllllllllllIIlIIllllIlIlIIIllI;
        }
        final double lllllllllllllIIlIIllllIlIIllIlIl = lllllllllllllIIlIIllllIlIIlIlIII;
        final double lllllllllllllIIlIIllllIlIIlllIII = Math.abs(lllllllllllllIIlIIllllIlIIllIlIl);
        if (lllllllllllllIIlIIllllIlIIlllIII == 0.0) {
            lllllllllllllIIlIIllllIlIlIlIIII[1] = lllllllllllllIIlIIllllIlIIllIlll;
            lllllllllllllIIlIIllllIlIlIlIIII[0] = lllllllllllllIIlIIllllIlIIlllIIl;
            lllllllllllllIIlIIllllIlIIllIIII = 1.0;
            lllllllllllllIIlIIllllIlIIlIllll = 1.0;
            lllllllllllllIIlIIllllIlIIlIlllI = 0.0;
            lllllllllllllIIlIIllllIlIIlIllIl = 0.0;
        }
        else {
            boolean lllllllllllllIIlIIllllIlIIllIIlI = true;
            if (lllllllllllllIIlIIllllIlIIlllIII > lllllllllllllIIlIIllllIlIIlllIIl) {
                lllllllllllllIIlIIllllIlIlIIIlll = 2;
                if (lllllllllllllIIlIIllllIlIIlllIIl / lllllllllllllIIlIIllllIlIIlllIII < 1.110223024E-16) {
                    lllllllllllllIIlIIllllIlIIllIIlI = false;
                    lllllllllllllIIlIIllllIlIIlIlIll = lllllllllllllIIlIIllllIlIIlllIII;
                    if (lllllllllllllIIlIIllllIlIIllIlll > 1.0) {
                        lllllllllllllIIlIIllllIlIIlIllII = lllllllllllllIIlIIllllIlIIlllIIl / (lllllllllllllIIlIIllllIlIIlllIII / lllllllllllllIIlIIllllIlIIllIlll);
                    }
                    else {
                        lllllllllllllIIlIIllllIlIIlIllII = lllllllllllllIIlIIllllIlIIlllIIl / lllllllllllllIIlIIllllIlIIlllIII * lllllllllllllIIlIIllllIlIIllIlll;
                    }
                    lllllllllllllIIlIIllllIlIIllIIII = 1.0;
                    lllllllllllllIIlIIllllIlIIlIlllI = lllllllllllllIIlIIllllIlIIllIlII / lllllllllllllIIlIIllllIlIIllIlIl;
                    lllllllllllllIIlIIllllIlIIlIllIl = 1.0;
                    lllllllllllllIIlIIllllIlIIlIllll = lllllllllllllIIlIIllllIlIIllIllI / lllllllllllllIIlIIllllIlIIllIlIl;
                }
            }
            if (lllllllllllllIIlIIllllIlIIllIIlI) {
                double lllllllllllllIIlIIllllIlIlIIIIlI = lllllllllllllIIlIIllllIlIIlllIIl - lllllllllllllIIlIIllllIlIIllIlll;
                double lllllllllllllIIlIIllllIlIlIIIIII = 0.0;
                if (lllllllllllllIIlIIllllIlIlIIIIlI == lllllllllllllIIlIIllllIlIIlllIIl) {
                    final double lllllllllllllIIlIIllllIlIlIIIIIl = 1.0;
                }
                else {
                    lllllllllllllIIlIIllllIlIlIIIIII = lllllllllllllIIlIIllllIlIlIIIIlI / lllllllllllllIIlIIllllIlIIlllIIl;
                }
                double lllllllllllllIIlIIllllIlIIllllll = lllllllllllllIIlIIllllIlIIllIlIl / lllllllllllllIIlIIllllIlIIllIllI;
                double lllllllllllllIIlIIllllIlIIlllIll = 2.0 - lllllllllllllIIlIIllllIlIlIIIIII;
                double lllllllllllllIIlIIllllIlIIllIIll = lllllllllllllIIlIIllllIlIIllllll * lllllllllllllIIlIIllllIlIIllllll;
                double lllllllllllllIIlIIllllIlIIllIIIl = lllllllllllllIIlIIllllIlIIlllIll * lllllllllllllIIlIIllllIlIIlllIll;
                double lllllllllllllIIlIIllllIlIIllllII = Math.sqrt(lllllllllllllIIlIIllllIlIIllIIIl + lllllllllllllIIlIIllllIlIIllIIll);
                double lllllllllllllIIlIIllllIlIIllllIl = 0.0;
                if (lllllllllllllIIlIIllllIlIlIIIIII == 0.0) {
                    final double lllllllllllllIIlIIllllIlIIlllllI = Math.abs(lllllllllllllIIlIIllllIlIIllllll);
                }
                else {
                    lllllllllllllIIlIIllllIlIIllllIl = Math.sqrt(lllllllllllllIIlIIllllIlIlIIIIII * lllllllllllllIIlIIllllIlIlIIIIII + lllllllllllllIIlIIllllIlIIllIIll);
                }
                double lllllllllllllIIlIIllllIlIlIIIIll = (lllllllllllllIIlIIllllIlIIllllII + lllllllllllllIIlIIllllIlIIllllIl) * 0.5;
                if (lllllllllllllIIlIIllllIlIIlllIII > lllllllllllllIIlIIllllIlIIlllIIl) {
                    lllllllllllllIIlIIllllIlIlIIIlll = 2;
                    if (lllllllllllllIIlIIllllIlIIlllIIl / lllllllllllllIIlIIllllIlIIlllIII < 1.110223024E-16) {
                        lllllllllllllIIlIIllllIlIIllIIlI = false;
                        lllllllllllllIIlIIllllIlIIlIlIll = lllllllllllllIIlIIllllIlIIlllIII;
                        if (lllllllllllllIIlIIllllIlIIllIlll > 1.0) {
                            lllllllllllllIIlIIllllIlIIlIllII = lllllllllllllIIlIIllllIlIIlllIIl / (lllllllllllllIIlIIllllIlIIlllIII / lllllllllllllIIlIIllllIlIIllIlll);
                        }
                        else {
                            lllllllllllllIIlIIllllIlIIlIllII = lllllllllllllIIlIIllllIlIIlllIIl / lllllllllllllIIlIIllllIlIIlllIII * lllllllllllllIIlIIllllIlIIllIlll;
                        }
                        lllllllllllllIIlIIllllIlIIllIIII = 1.0;
                        lllllllllllllIIlIIllllIlIIlIlllI = lllllllllllllIIlIIllllIlIIllIlII / lllllllllllllIIlIIllllIlIIllIlIl;
                        lllllllllllllIIlIIllllIlIIlIllIl = 1.0;
                        lllllllllllllIIlIIllllIlIIlIllll = lllllllllllllIIlIIllllIlIIllIllI / lllllllllllllIIlIIllllIlIIllIlIl;
                    }
                }
                if (lllllllllllllIIlIIllllIlIIllIIlI) {
                    lllllllllllllIIlIIllllIlIlIIIIlI = lllllllllllllIIlIIllllIlIIlllIIl - lllllllllllllIIlIIllllIlIIllIlll;
                    if (lllllllllllllIIlIIllllIlIlIIIIlI == lllllllllllllIIlIIllllIlIIlllIIl) {
                        lllllllllllllIIlIIllllIlIlIIIIII = 1.0;
                    }
                    else {
                        lllllllllllllIIlIIllllIlIlIIIIII = lllllllllllllIIlIIllllIlIlIIIIlI / lllllllllllllIIlIIllllIlIIlllIIl;
                    }
                    lllllllllllllIIlIIllllIlIIllllll = lllllllllllllIIlIIllllIlIIllIlIl / lllllllllllllIIlIIllllIlIIllIllI;
                    lllllllllllllIIlIIllllIlIIlllIll = 2.0 - lllllllllllllIIlIIllllIlIlIIIIII;
                    lllllllllllllIIlIIllllIlIIllIIll = lllllllllllllIIlIIllllIlIIllllll * lllllllllllllIIlIIllllIlIIllllll;
                    lllllllllllllIIlIIllllIlIIllIIIl = lllllllllllllIIlIIllllIlIIlllIll * lllllllllllllIIlIIllllIlIIlllIll;
                    lllllllllllllIIlIIllllIlIIllllII = Math.sqrt(lllllllllllllIIlIIllllIlIIllIIIl + lllllllllllllIIlIIllllIlIIllIIll);
                    if (lllllllllllllIIlIIllllIlIlIIIIII == 0.0) {
                        lllllllllllllIIlIIllllIlIIllllIl = Math.abs(lllllllllllllIIlIIllllIlIIllllll);
                    }
                    else {
                        lllllllllllllIIlIIllllIlIIllllIl = Math.sqrt(lllllllllllllIIlIIllllIlIlIIIIII * lllllllllllllIIlIIllllIlIlIIIIII + lllllllllllllIIlIIllllIlIIllIIll);
                    }
                    lllllllllllllIIlIIllllIlIlIIIIll = (lllllllllllllIIlIIllllIlIIllllII + lllllllllllllIIlIIllllIlIIllllIl) * 0.5;
                    lllllllllllllIIlIIllllIlIIlIllII = lllllllllllllIIlIIllllIlIIllIlll / lllllllllllllIIlIIllllIlIlIIIIll;
                    lllllllllllllIIlIIllllIlIIlIlIll = lllllllllllllIIlIIllllIlIIlllIIl * lllllllllllllIIlIIllllIlIlIIIIll;
                    if (lllllllllllllIIlIIllllIlIIllIIll == 0.0) {
                        if (lllllllllllllIIlIIllllIlIlIIIIII == 0.0) {
                            lllllllllllllIIlIIllllIlIIlllIll = d_sign(lllllllllllllIIlIIllllIlIlIIlIlI, lllllllllllllIIlIIllllIlIIllIllI) * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIIllIlIl);
                        }
                        else {
                            lllllllllllllIIlIIllllIlIIlllIll = lllllllllllllIIlIIllllIlIIllIlIl / d_sign(lllllllllllllIIlIIllllIlIlIIIIlI, lllllllllllllIIlIIllllIlIIllIllI) + lllllllllllllIIlIIllllIlIIllllll / lllllllllllllIIlIIllllIlIIlllIll;
                        }
                    }
                    else {
                        lllllllllllllIIlIIllllIlIIlllIll = (lllllllllllllIIlIIllllIlIIllllll / (lllllllllllllIIlIIllllIlIIllllII + lllllllllllllIIlIIllllIlIIlllIll) + lllllllllllllIIlIIllllIlIIllllll / (lllllllllllllIIlIIllllIlIIllllIl + lllllllllllllIIlIIllllIlIlIIIIII)) * (lllllllllllllIIlIIllllIlIlIIIIll + 1.0);
                    }
                    lllllllllllllIIlIIllllIlIlIIIIII = Math.sqrt(lllllllllllllIIlIIllllIlIIlllIll * lllllllllllllIIlIIllllIlIIlllIll + 4.0);
                    lllllllllllllIIlIIllllIlIIlIllll = 2.0 / lllllllllllllIIlIIllllIlIlIIIIII;
                    lllllllllllllIIlIIllllIlIIlIllIl = lllllllllllllIIlIIllllIlIIlllIll / lllllllllllllIIlIIllllIlIlIIIIII;
                    lllllllllllllIIlIIllllIlIIllIIII = (lllllllllllllIIlIIllllIlIIlIllll + lllllllllllllIIlIIllllIlIIlIllIl * lllllllllllllIIlIIllllIlIIllllll) / lllllllllllllIIlIIllllIlIlIIIIll;
                    lllllllllllllIIlIIllllIlIIlIlllI = lllllllllllllIIlIIllllIlIIllIlII / lllllllllllllIIlIIllllIlIIllIllI * lllllllllllllIIlIIllllIlIIlIllIl / lllllllllllllIIlIIllllIlIlIIIIll;
                }
            }
            if (lllllllllllllIIlIIllllIlIlIIIlII) {
                lllllllllllllIIlIIllllIlIlIIlllI[0] = lllllllllllllIIlIIllllIlIIlIllIl;
                lllllllllllllIIlIIllllIlIIlIIlIl[0] = lllllllllllllIIlIIllllIlIIlIllll;
                lllllllllllllIIlIIllllIlIIlIIIlI[0] = lllllllllllllIIlIIllllIlIIlIlllI;
                lllllllllllllIIlIIllllIlIIlIIIll[0] = lllllllllllllIIlIIllllIlIIllIIII;
            }
            else {
                lllllllllllllIIlIIllllIlIlIIlllI[0] = lllllllllllllIIlIIllllIlIIllIIII;
                lllllllllllllIIlIIllllIlIIlIIlIl[0] = lllllllllllllIIlIIllllIlIIlIlllI;
                lllllllllllllIIlIIllllIlIIlIIIlI[0] = lllllllllllllIIlIIllllIlIIlIllll;
                lllllllllllllIIlIIllllIlIIlIIIll[0] = lllllllllllllIIlIIllllIlIIlIllIl;
            }
            if (lllllllllllllIIlIIllllIlIlIIIlll == 1) {
                lllllllllllllIIlIIllllIlIIlllIlI = d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIIlIIIlI[0]) * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIlIIlllI[0]) * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIlIlIIll);
            }
            if (lllllllllllllIIlIIllllIlIlIIIlll == 2) {
                lllllllllllllIIlIIllllIlIIlllIlI = d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIIlIIIll[0]) * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIlIIlllI[0]) * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIIlIlIII);
            }
            if (lllllllllllllIIlIIllllIlIlIIIlll == 3) {
                lllllllllllllIIlIIllllIlIIlllIlI = d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIIlIIIll[0]) * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIIlIIlIl[0]) * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIlIlIIIl);
            }
            lllllllllllllIIlIIllllIlIlIlIIII[lllllllllllllIIlIIllllIlIIlIIIIl] = d_sign(lllllllllllllIIlIIllllIlIIlIlIll, lllllllllllllIIlIIllllIlIIlllIlI);
            final double lllllllllllllIIlIIllllIlIlIIlIII = lllllllllllllIIlIIllllIlIIlllIlI * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIlIlIIll) * d_sign(lllllllllllllIIlIIllllIlIlIIlIIl, lllllllllllllIIlIIllllIlIlIlIIIl);
            lllllllllllllIIlIIllllIlIlIlIIII[lllllllllllllIIlIIllllIlIIlIIIIl + 1] = d_sign(lllllllllllllIIlIIllllIlIIlIllII, lllllllllllllIIlIIllllIlIlIIlIII);
        }
        return 0;
    }
    
    public final void rotZ(final double lllllllllllllIIlIIlllllllllllIII) {
        final double lllllllllllllIIlIIllllllllllIlll = Math.sin(lllllllllllllIIlIIlllllllllllIII);
        final double lllllllllllllIIlIIllllllllllIllI = Math.cos(lllllllllllllIIlIIlllllllllllIII);
        this.m00 = lllllllllllllIIlIIllllllllllIllI;
        this.m01 = -lllllllllllllIIlIIllllllllllIlll;
        this.m02 = 0.0;
        this.m10 = lllllllllllllIIlIIllllllllllIlll;
        this.m11 = lllllllllllllIIlIIllllllllllIllI;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 1.0;
    }
    
    public final void rotY(final double lllllllllllllIIlIlIIIIIIIIIIIlII) {
        final double lllllllllllllIIlIlIIIIIIIIIIIIll = Math.sin(lllllllllllllIIlIlIIIIIIIIIIIlII);
        final double lllllllllllllIIlIlIIIIIIIIIIIIlI = Math.cos(lllllllllllllIIlIlIIIIIIIIIIIlII);
        this.m00 = lllllllllllllIIlIlIIIIIIIIIIIIlI;
        this.m01 = 0.0;
        this.m02 = lllllllllllllIIlIlIIIIIIIIIIIIll;
        this.m10 = 0.0;
        this.m11 = 1.0;
        this.m12 = 0.0;
        this.m20 = -lllllllllllllIIlIlIIIIIIIIIIIIll;
        this.m21 = 0.0;
        this.m22 = lllllllllllllIIlIlIIIIIIIIIIIIlI;
    }
    
    static double compute_shift(final double lllllllllllllIIlIIllllIllIIlllll, final double lllllllllllllIIlIIllllIllIIllllI, final double lllllllllllllIIlIIllllIllIIlllIl) {
        final double lllllllllllllIIlIIllllIllIIlIlIl = Math.abs(lllllllllllllIIlIIllllIllIIlllll);
        final double lllllllllllllIIlIIllllIllIIlIlII = Math.abs(lllllllllllllIIlIIllllIllIIllllI);
        final double lllllllllllllIIlIIllllIllIIlIIll = Math.abs(lllllllllllllIIlIIllllIllIIlllIl);
        final double lllllllllllllIIlIIllllIllIIllIIl = min(lllllllllllllIIlIIllllIllIIlIlIl, lllllllllllllIIlIIllllIllIIlIIll);
        final double lllllllllllllIIlIIllllIllIIllIII = max(lllllllllllllIIlIIllllIllIIlIlIl, lllllllllllllIIlIIllllIllIIlIIll);
        double lllllllllllllIIlIIllllIllIIIlIIl = 0.0;
        if (lllllllllllllIIlIIllllIllIIllIIl == 0.0) {
            final double lllllllllllllIIlIIllllIllIIIllII = 0.0;
            if (lllllllllllllIIlIIllllIllIIllIII != 0.0) {
                final double n = min(lllllllllllllIIlIIllllIllIIllIII, lllllllllllllIIlIIllllIllIIlIlII) / max(lllllllllllllIIlIIllllIllIIllIII, lllllllllllllIIlIIllllIllIIlIlII);
            }
        }
        else if (lllllllllllllIIlIIllllIllIIlIlII < lllllllllllllIIlIIllllIllIIllIII) {
            final double lllllllllllllIIlIIllllIllIIlIIlI = lllllllllllllIIlIIllllIllIIllIIl / lllllllllllllIIlIIllllIllIIllIII + 1.0;
            final double lllllllllllllIIlIIllllIllIIlIIII = (lllllllllllllIIlIIllllIllIIllIII - lllllllllllllIIlIIllllIllIIllIIl) / lllllllllllllIIlIIllllIllIIllIII;
            final double lllllllllllllIIlIIllllIllIIlllII = lllllllllllllIIlIIllllIllIIlIlII / lllllllllllllIIlIIllllIllIIllIII;
            final double lllllllllllllIIlIIllllIllIIIlllI = lllllllllllllIIlIIllllIllIIlllII * lllllllllllllIIlIIllllIllIIlllII;
            final double lllllllllllllIIlIIllllIllIIlIlll = 2.0 / (Math.sqrt(lllllllllllllIIlIIllllIllIIlIIlI * lllllllllllllIIlIIllllIllIIlIIlI + lllllllllllllIIlIIllllIllIIIlllI) + Math.sqrt(lllllllllllllIIlIIllllIllIIlIIII * lllllllllllllIIlIIllllIllIIlIIII + lllllllllllllIIlIIllllIllIIIlllI));
            final double lllllllllllllIIlIIllllIllIIIlIll = lllllllllllllIIlIIllllIllIIllIIl * lllllllllllllIIlIIllllIllIIlIlll;
        }
        else {
            final double lllllllllllllIIlIIllllIllIIIllIl = lllllllllllllIIlIIllllIllIIllIII / lllllllllllllIIlIIllllIllIIlIlII;
            if (lllllllllllllIIlIIllllIllIIIllIl == 0.0) {
                final double lllllllllllllIIlIIllllIllIIIlIlI = lllllllllllllIIlIIllllIllIIllIIl * lllllllllllllIIlIIllllIllIIllIII / lllllllllllllIIlIIllllIllIIlIlII;
            }
            else {
                final double lllllllllllllIIlIIllllIllIIlIIIl = lllllllllllllIIlIIllllIllIIllIIl / lllllllllllllIIlIIllllIllIIllIII + 1.0;
                final double lllllllllllllIIlIIllllIllIIIllll = (lllllllllllllIIlIIllllIllIIllIII - lllllllllllllIIlIIllllIllIIllIIl) / lllllllllllllIIlIIllllIllIIllIII;
                final double lllllllllllllIIlIIllllIllIIllIll = lllllllllllllIIlIIllllIllIIlIIIl * lllllllllllllIIlIIllllIllIIIllIl;
                final double lllllllllllllIIlIIllllIllIIllIlI = lllllllllllllIIlIIllllIllIIIllll * lllllllllllllIIlIIllllIllIIIllIl;
                final double lllllllllllllIIlIIllllIllIIlIllI = 1.0 / (Math.sqrt(lllllllllllllIIlIIllllIllIIllIll * lllllllllllllIIlIIllllIllIIllIll + 1.0) + Math.sqrt(lllllllllllllIIlIIllllIllIIllIlI * lllllllllllllIIlIIllllIllIIllIlI + 1.0));
                lllllllllllllIIlIIllllIllIIIlIIl = lllllllllllllIIlIIllllIllIIllIIl * lllllllllllllIIlIIllllIllIIlIllI * lllllllllllllIIlIIllllIllIIIllIl;
                lllllllllllllIIlIIllllIllIIIlIIl += lllllllllllllIIlIIllllIllIIIlIIl;
            }
        }
        return lllllllllllllIIlIIllllIllIIIlIIl;
    }
    
    public final void set(final Matrix3d lllllllllllllIIlIlIIIIIIlIlIIlIl) {
        this.m00 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m00;
        this.m01 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m01;
        this.m02 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m02;
        this.m10 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m10;
        this.m11 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m11;
        this.m12 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m12;
        this.m20 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m20;
        this.m21 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m21;
        this.m22 = lllllllllllllIIlIlIIIIIIlIlIIlIl.m22;
    }
    
    public final void add(final double lllllllllllllIIlIlIIIIIlIIllIIIl, final Matrix3d lllllllllllllIIlIlIIIIIlIIlIllIl) {
        this.m00 = lllllllllllllIIlIlIIIIIlIIlIllIl.m00 + lllllllllllllIIlIlIIIIIlIIllIIIl;
        this.m01 = lllllllllllllIIlIlIIIIIlIIlIllIl.m01 + lllllllllllllIIlIlIIIIIlIIllIIIl;
        this.m02 = lllllllllllllIIlIlIIIIIlIIlIllIl.m02 + lllllllllllllIIlIlIIIIIlIIllIIIl;
        this.m10 = lllllllllllllIIlIlIIIIIlIIlIllIl.m10 + lllllllllllllIIlIlIIIIIlIIllIIIl;
        this.m11 = lllllllllllllIIlIlIIIIIlIIlIllIl.m11 + lllllllllllllIIlIlIIIIIlIIllIIIl;
        this.m12 = lllllllllllllIIlIlIIIIIlIIlIllIl.m12 + lllllllllllllIIlIlIIIIIlIIllIIIl;
        this.m20 = lllllllllllllIIlIlIIIIIlIIlIllIl.m20 + lllllllllllllIIlIlIIIIIlIIllIIIl;
        this.m21 = lllllllllllllIIlIlIIIIIlIIlIllIl.m21 + lllllllllllllIIlIlIIIIIlIIllIIIl;
        this.m22 = lllllllllllllIIlIlIIIIIlIIlIllIl.m22 + lllllllllllllIIlIlIIIIIlIIllIIIl;
    }
    
    public boolean equals(final Matrix3d lllllllllllllIIlIIlllllIlllIIIlI) {
        try {
            return this.m00 == lllllllllllllIIlIIlllllIlllIIIlI.m00 && this.m01 == lllllllllllllIIlIIlllllIlllIIIlI.m01 && this.m02 == lllllllllllllIIlIIlllllIlllIIIlI.m02 && this.m10 == lllllllllllllIIlIIlllllIlllIIIlI.m10 && this.m11 == lllllllllllllIIlIIlllllIlllIIIlI.m11 && this.m12 == lllllllllllllIIlIIlllllIlllIIIlI.m12 && this.m20 == lllllllllllllIIlIIlllllIlllIIIlI.m20 && this.m21 == lllllllllllllIIlIIlllllIlllIIIlI.m21 && this.m22 == lllllllllllllIIlIIlllllIlllIIIlI.m22;
        }
        catch (NullPointerException lllllllllllllIIlIIlllllIlllIIlII) {
            return false;
        }
    }
    
    public final void mul(final Matrix3d lllllllllllllIIlIIlllllllIlIlIII, final Matrix3d lllllllllllllIIlIIlllllllIllIIll) {
        if (this != lllllllllllllIIlIIlllllllIlIlIII && this != lllllllllllllIIlIIlllllllIllIIll) {
            this.m00 = lllllllllllllIIlIIlllllllIlIlIII.m00 * lllllllllllllIIlIIlllllllIllIIll.m00 + lllllllllllllIIlIIlllllllIlIlIII.m01 * lllllllllllllIIlIIlllllllIllIIll.m10 + lllllllllllllIIlIIlllllllIlIlIII.m02 * lllllllllllllIIlIIlllllllIllIIll.m20;
            this.m01 = lllllllllllllIIlIIlllllllIlIlIII.m00 * lllllllllllllIIlIIlllllllIllIIll.m01 + lllllllllllllIIlIIlllllllIlIlIII.m01 * lllllllllllllIIlIIlllllllIllIIll.m11 + lllllllllllllIIlIIlllllllIlIlIII.m02 * lllllllllllllIIlIIlllllllIllIIll.m21;
            this.m02 = lllllllllllllIIlIIlllllllIlIlIII.m00 * lllllllllllllIIlIIlllllllIllIIll.m02 + lllllllllllllIIlIIlllllllIlIlIII.m01 * lllllllllllllIIlIIlllllllIllIIll.m12 + lllllllllllllIIlIIlllllllIlIlIII.m02 * lllllllllllllIIlIIlllllllIllIIll.m22;
            this.m10 = lllllllllllllIIlIIlllllllIlIlIII.m10 * lllllllllllllIIlIIlllllllIllIIll.m00 + lllllllllllllIIlIIlllllllIlIlIII.m11 * lllllllllllllIIlIIlllllllIllIIll.m10 + lllllllllllllIIlIIlllllllIlIlIII.m12 * lllllllllllllIIlIIlllllllIllIIll.m20;
            this.m11 = lllllllllllllIIlIIlllllllIlIlIII.m10 * lllllllllllllIIlIIlllllllIllIIll.m01 + lllllllllllllIIlIIlllllllIlIlIII.m11 * lllllllllllllIIlIIlllllllIllIIll.m11 + lllllllllllllIIlIIlllllllIlIlIII.m12 * lllllllllllllIIlIIlllllllIllIIll.m21;
            this.m12 = lllllllllllllIIlIIlllllllIlIlIII.m10 * lllllllllllllIIlIIlllllllIllIIll.m02 + lllllllllllllIIlIIlllllllIlIlIII.m11 * lllllllllllllIIlIIlllllllIllIIll.m12 + lllllllllllllIIlIIlllllllIlIlIII.m12 * lllllllllllllIIlIIlllllllIllIIll.m22;
            this.m20 = lllllllllllllIIlIIlllllllIlIlIII.m20 * lllllllllllllIIlIIlllllllIllIIll.m00 + lllllllllllllIIlIIlllllllIlIlIII.m21 * lllllllllllllIIlIIlllllllIllIIll.m10 + lllllllllllllIIlIIlllllllIlIlIII.m22 * lllllllllllllIIlIIlllllllIllIIll.m20;
            this.m21 = lllllllllllllIIlIIlllllllIlIlIII.m20 * lllllllllllllIIlIIlllllllIllIIll.m01 + lllllllllllllIIlIIlllllllIlIlIII.m21 * lllllllllllllIIlIIlllllllIllIIll.m11 + lllllllllllllIIlIIlllllllIlIlIII.m22 * lllllllllllllIIlIIlllllllIllIIll.m21;
            this.m22 = lllllllllllllIIlIIlllllllIlIlIII.m20 * lllllllllllllIIlIIlllllllIllIIll.m02 + lllllllllllllIIlIIlllllllIlIlIII.m21 * lllllllllllllIIlIIlllllllIllIIll.m12 + lllllllllllllIIlIIlllllllIlIlIII.m22 * lllllllllllllIIlIIlllllllIllIIll.m22;
        }
        else {
            final double lllllllllllllIIlIIlllllllIllIIlI = lllllllllllllIIlIIlllllllIlIlIII.m00 * lllllllllllllIIlIIlllllllIllIIll.m00 + lllllllllllllIIlIIlllllllIlIlIII.m01 * lllllllllllllIIlIIlllllllIllIIll.m10 + lllllllllllllIIlIIlllllllIlIlIII.m02 * lllllllllllllIIlIIlllllllIllIIll.m20;
            final double lllllllllllllIIlIIlllllllIllIIIl = lllllllllllllIIlIIlllllllIlIlIII.m00 * lllllllllllllIIlIIlllllllIllIIll.m01 + lllllllllllllIIlIIlllllllIlIlIII.m01 * lllllllllllllIIlIIlllllllIllIIll.m11 + lllllllllllllIIlIIlllllllIlIlIII.m02 * lllllllllllllIIlIIlllllllIllIIll.m21;
            final double lllllllllllllIIlIIlllllllIllIIII = lllllllllllllIIlIIlllllllIlIlIII.m00 * lllllllllllllIIlIIlllllllIllIIll.m02 + lllllllllllllIIlIIlllllllIlIlIII.m01 * lllllllllllllIIlIIlllllllIllIIll.m12 + lllllllllllllIIlIIlllllllIlIlIII.m02 * lllllllllllllIIlIIlllllllIllIIll.m22;
            final double lllllllllllllIIlIIlllllllIlIllll = lllllllllllllIIlIIlllllllIlIlIII.m10 * lllllllllllllIIlIIlllllllIllIIll.m00 + lllllllllllllIIlIIlllllllIlIlIII.m11 * lllllllllllllIIlIIlllllllIllIIll.m10 + lllllllllllllIIlIIlllllllIlIlIII.m12 * lllllllllllllIIlIIlllllllIllIIll.m20;
            final double lllllllllllllIIlIIlllllllIlIlllI = lllllllllllllIIlIIlllllllIlIlIII.m10 * lllllllllllllIIlIIlllllllIllIIll.m01 + lllllllllllllIIlIIlllllllIlIlIII.m11 * lllllllllllllIIlIIlllllllIllIIll.m11 + lllllllllllllIIlIIlllllllIlIlIII.m12 * lllllllllllllIIlIIlllllllIllIIll.m21;
            final double lllllllllllllIIlIIlllllllIlIllIl = lllllllllllllIIlIIlllllllIlIlIII.m10 * lllllllllllllIIlIIlllllllIllIIll.m02 + lllllllllllllIIlIIlllllllIlIlIII.m11 * lllllllllllllIIlIIlllllllIllIIll.m12 + lllllllllllllIIlIIlllllllIlIlIII.m12 * lllllllllllllIIlIIlllllllIllIIll.m22;
            final double lllllllllllllIIlIIlllllllIlIllII = lllllllllllllIIlIIlllllllIlIlIII.m20 * lllllllllllllIIlIIlllllllIllIIll.m00 + lllllllllllllIIlIIlllllllIlIlIII.m21 * lllllllllllllIIlIIlllllllIllIIll.m10 + lllllllllllllIIlIIlllllllIlIlIII.m22 * lllllllllllllIIlIIlllllllIllIIll.m20;
            final double lllllllllllllIIlIIlllllllIlIlIll = lllllllllllllIIlIIlllllllIlIlIII.m20 * lllllllllllllIIlIIlllllllIllIIll.m01 + lllllllllllllIIlIIlllllllIlIlIII.m21 * lllllllllllllIIlIIlllllllIllIIll.m11 + lllllllllllllIIlIIlllllllIlIlIII.m22 * lllllllllllllIIlIIlllllllIllIIll.m21;
            final double lllllllllllllIIlIIlllllllIlIlIlI = lllllllllllllIIlIIlllllllIlIlIII.m20 * lllllllllllllIIlIIlllllllIllIIll.m02 + lllllllllllllIIlIIlllllllIlIlIII.m21 * lllllllllllllIIlIIlllllllIllIIll.m12 + lllllllllllllIIlIIlllllllIlIlIII.m22 * lllllllllllllIIlIIlllllllIllIIll.m22;
            this.m00 = lllllllllllllIIlIIlllllllIllIIlI;
            this.m01 = lllllllllllllIIlIIlllllllIllIIIl;
            this.m02 = lllllllllllllIIlIIlllllllIllIIII;
            this.m10 = lllllllllllllIIlIIlllllllIlIllll;
            this.m11 = lllllllllllllIIlIIlllllllIlIlllI;
            this.m12 = lllllllllllllIIlIIlllllllIlIllIl;
            this.m20 = lllllllllllllIIlIIlllllllIlIllII;
            this.m21 = lllllllllllllIIlIIlllllllIlIlIll;
            this.m22 = lllllllllllllIIlIIlllllllIlIlIlI;
        }
    }
    
    public final double getM11() {
        return this.m11;
    }
    
    public final void getRow(final int lllllllllllllIIlIlIIIIIllIlIIllI, final Vector3d lllllllllllllIIlIlIIIIIllIlIIlIl) {
        if (lllllllllllllIIlIlIIIIIllIlIIllI == 0) {
            lllllllllllllIIlIlIIIIIllIlIIlIl.x = this.m00;
            lllllllllllllIIlIlIIIIIllIlIIlIl.y = this.m01;
            lllllllllllllIIlIlIIIIIllIlIIlIl.z = this.m02;
        }
        else if (lllllllllllllIIlIlIIIIIllIlIIllI == 1) {
            lllllllllllllIIlIlIIIIIllIlIIlIl.x = this.m10;
            lllllllllllllIIlIlIIIIIllIlIIlIl.y = this.m11;
            lllllllllllllIIlIlIIIIIllIlIIlIl.z = this.m12;
        }
        else {
            if (lllllllllllllIIlIlIIIIIllIlIIllI != 2) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d2"));
            }
            lllllllllllllIIlIlIIIIIllIlIIlIl.x = this.m20;
            lllllllllllllIIlIlIIIIIllIlIIlIl.y = this.m21;
            lllllllllllllIIlIlIIIIIllIlIIlIl.z = this.m22;
        }
    }
    
    public boolean epsilonEquals(final Matrix3d lllllllllllllIIlIIlllllIllIlIIII, final double lllllllllllllIIlIIlllllIllIIlIll) {
        double lllllllllllllIIlIIlllllIllIIlllI = this.m00 - lllllllllllllIIlIIlllllIllIlIIII.m00;
        if (((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) > lllllllllllllIIlIIlllllIllIIlIll) {
            return false;
        }
        lllllllllllllIIlIIlllllIllIIlllI = this.m01 - lllllllllllllIIlIIlllllIllIlIIII.m01;
        if (((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) > lllllllllllllIIlIIlllllIllIIlIll) {
            return false;
        }
        lllllllllllllIIlIIlllllIllIIlllI = this.m02 - lllllllllllllIIlIIlllllIllIlIIII.m02;
        if (((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) > lllllllllllllIIlIIlllllIllIIlIll) {
            return false;
        }
        lllllllllllllIIlIIlllllIllIIlllI = this.m10 - lllllllllllllIIlIIlllllIllIlIIII.m10;
        if (((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) > lllllllllllllIIlIIlllllIllIIlIll) {
            return false;
        }
        lllllllllllllIIlIIlllllIllIIlllI = this.m11 - lllllllllllllIIlIIlllllIllIlIIII.m11;
        if (((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) > lllllllllllllIIlIIlllllIllIIlIll) {
            return false;
        }
        lllllllllllllIIlIIlllllIllIIlllI = this.m12 - lllllllllllllIIlIIlllllIllIlIIII.m12;
        if (((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) > lllllllllllllIIlIIlllllIllIIlIll) {
            return false;
        }
        lllllllllllllIIlIIlllllIllIIlllI = this.m20 - lllllllllllllIIlIIlllllIllIlIIII.m20;
        if (((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) > lllllllllllllIIlIIlllllIllIIlIll) {
            return false;
        }
        lllllllllllllIIlIIlllllIllIIlllI = this.m21 - lllllllllllllIIlIIlllllIllIlIIII.m21;
        if (((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) > lllllllllllllIIlIIlllllIllIIlIll) {
            return false;
        }
        lllllllllllllIIlIIlllllIllIIlllI = this.m22 - lllllllllllllIIlIIlllllIllIlIIII.m22;
        return ((lllllllllllllIIlIIlllllIllIIlllI < 0.0) ? (-lllllllllllllIIlIIlllllIllIIlllI) : lllllllllllllIIlIIlllllIllIIlllI) <= lllllllllllllIIlIIlllllIllIIlIll;
    }
    
    public final void setIdentity() {
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
    
    private static final boolean almostEqual(final double lllllllllllllIIlIIllllIIlIIlIIII, final double lllllllllllllIIlIIllllIIlIIIllll) {
        if (lllllllllllllIIlIIllllIIlIIlIIII == lllllllllllllIIlIIllllIIlIIIllll) {
            return true;
        }
        final double lllllllllllllIIlIIllllIIlIIlIllI = 1.0E-6;
        final double lllllllllllllIIlIIllllIIlIIlIlIl = 1.0E-4;
        final double lllllllllllllIIlIIllllIIlIIlIlII = Math.abs(lllllllllllllIIlIIllllIIlIIlIIII - lllllllllllllIIlIIllllIIlIIIllll);
        final double lllllllllllllIIlIIllllIIlIIlIIll = Math.abs(lllllllllllllIIlIIllllIIlIIlIIII);
        final double lllllllllllllIIlIIllllIIlIIlIIlI = Math.abs(lllllllllllllIIlIIllllIIlIIIllll);
        final double lllllllllllllIIlIIllllIIlIIlIIIl = (lllllllllllllIIlIIllllIIlIIlIIll >= lllllllllllllIIlIIllllIIlIIlIIlI) ? lllllllllllllIIlIIllllIIlIIlIIll : lllllllllllllIIlIIllllIIlIIlIIlI;
        return lllllllllllllIIlIIllllIIlIIlIlII < 1.0E-6 || lllllllllllllIIlIIllllIIlIIlIlII / lllllllllllllIIlIIllllIIlIIlIIIl < 1.0E-4;
    }
    
    public final double getM12() {
        return this.m12;
    }
    
    public final void sub(final Matrix3d lllllllllllllIIlIlIIIIIlIIIllIIl, final Matrix3d lllllllllllllIIlIlIIIIIlIIIlIlIl) {
        this.m00 = lllllllllllllIIlIlIIIIIlIIIllIIl.m00 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m00;
        this.m01 = lllllllllllllIIlIlIIIIIlIIIllIIl.m01 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m01;
        this.m02 = lllllllllllllIIlIlIIIIIlIIIllIIl.m02 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m02;
        this.m10 = lllllllllllllIIlIlIIIIIlIIIllIIl.m10 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m10;
        this.m11 = lllllllllllllIIlIlIIIIIlIIIllIIl.m11 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m11;
        this.m12 = lllllllllllllIIlIlIIIIIlIIIllIIl.m12 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m12;
        this.m20 = lllllllllllllIIlIlIIIIIlIIIllIIl.m20 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m20;
        this.m21 = lllllllllllllIIlIlIIIIIlIIIllIIl.m21 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m21;
        this.m22 = lllllllllllllIIlIlIIIIIlIIIllIIl.m22 - lllllllllllllIIlIlIIIIIlIIIlIlIl.m22;
    }
    
    public final void rotX(final double lllllllllllllIIlIlIIIIIIIIIlIIII) {
        final double lllllllllllllIIlIlIIIIIIIIIIllll = Math.sin(lllllllllllllIIlIlIIIIIIIIIlIIII);
        final double lllllllllllllIIlIlIIIIIIIIIIlllI = Math.cos(lllllllllllllIIlIlIIIIIIIIIlIIII);
        this.m00 = 1.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = lllllllllllllIIlIlIIIIIIIIIIlllI;
        this.m12 = -lllllllllllllIIlIlIIIIIIIIIIllll;
        this.m20 = 0.0;
        this.m21 = lllllllllllllIIlIlIIIIIIIIIIllll;
        this.m22 = lllllllllllllIIlIlIIIIIIIIIIlllI;
    }
    
    public final void set(final AxisAngle4f lllllllllllllIIlIlIIIIIIllIIIlIl) {
        double lllllllllllllIIlIlIIIIIIllIIIlII = Math.sqrt(lllllllllllllIIlIlIIIIIIllIIIlIl.x * lllllllllllllIIlIlIIIIIIllIIIlIl.x + lllllllllllllIIlIlIIIIIIllIIIlIl.y * lllllllllllllIIlIlIIIIIIllIIIlIl.y + lllllllllllllIIlIlIIIIIIllIIIlIl.z * lllllllllllllIIlIlIIIIIIllIIIlIl.z);
        if (lllllllllllllIIlIlIIIIIIllIIIlII < 1.110223024E-16) {
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
            lllllllllllllIIlIlIIIIIIllIIIlII = 1.0 / lllllllllllllIIlIlIIIIIIllIIIlII;
            final double lllllllllllllIIlIlIIIIIIllIIIIll = lllllllllllllIIlIlIIIIIIllIIIlIl.x * lllllllllllllIIlIlIIIIIIllIIIlII;
            final double lllllllllllllIIlIlIIIIIIllIIIIlI = lllllllllllllIIlIlIIIIIIllIIIlIl.y * lllllllllllllIIlIlIIIIIIllIIIlII;
            final double lllllllllllllIIlIlIIIIIIllIIIIIl = lllllllllllllIIlIlIIIIIIllIIIlIl.z * lllllllllllllIIlIlIIIIIIllIIIlII;
            final double lllllllllllllIIlIlIIIIIIllIIIIII = Math.sin(lllllllllllllIIlIlIIIIIIllIIIlIl.angle);
            final double lllllllllllllIIlIlIIIIIIlIllllll = Math.cos(lllllllllllllIIlIlIIIIIIllIIIlIl.angle);
            final double lllllllllllllIIlIlIIIIIIlIlllllI = 1.0 - lllllllllllllIIlIlIIIIIIlIllllll;
            final double lllllllllllllIIlIlIIIIIIlIllllIl = lllllllllllllIIlIlIIIIIIllIIIIll * lllllllllllllIIlIlIIIIIIllIIIIIl;
            final double lllllllllllllIIlIlIIIIIIlIllllII = lllllllllllllIIlIlIIIIIIllIIIIll * lllllllllllllIIlIlIIIIIIllIIIIlI;
            final double lllllllllllllIIlIlIIIIIIlIlllIll = lllllllllllllIIlIlIIIIIIllIIIIlI * lllllllllllllIIlIlIIIIIIllIIIIIl;
            this.m00 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIllIIIIll * lllllllllllllIIlIlIIIIIIllIIIIll + lllllllllllllIIlIlIIIIIIlIllllll;
            this.m01 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIlIllllII - lllllllllllllIIlIlIIIIIIllIIIIII * lllllllllllllIIlIlIIIIIIllIIIIIl;
            this.m02 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIlIllllIl + lllllllllllllIIlIlIIIIIIllIIIIII * lllllllllllllIIlIlIIIIIIllIIIIlI;
            this.m10 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIlIllllII + lllllllllllllIIlIlIIIIIIllIIIIII * lllllllllllllIIlIlIIIIIIllIIIIIl;
            this.m11 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIllIIIIlI * lllllllllllllIIlIlIIIIIIllIIIIlI + lllllllllllllIIlIlIIIIIIlIllllll;
            this.m12 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIlIlllIll - lllllllllllllIIlIlIIIIIIllIIIIII * lllllllllllllIIlIlIIIIIIllIIIIll;
            this.m20 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIlIllllIl - lllllllllllllIIlIlIIIIIIllIIIIII * lllllllllllllIIlIlIIIIIIllIIIIlI;
            this.m21 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIlIlllIll + lllllllllllllIIlIlIIIIIIllIIIIII * lllllllllllllIIlIlIIIIIIllIIIIll;
            this.m22 = lllllllllllllIIlIlIIIIIIlIlllllI * lllllllllllllIIlIlIIIIIIllIIIIIl * lllllllllllllIIlIlIIIIIIllIIIIIl + lllllllllllllIIlIlIIIIIIlIllllll;
        }
    }
    
    static double compute_rot(final double lllllllllllllIIlIIllllIIllllIlII, final double lllllllllllllIIlIIllllIIllIlIIll, final double[] lllllllllllllIIlIIllllIIllllIIlI, final double[] lllllllllllllIIlIIllllIIllIlIIIl, final int lllllllllllllIIlIIllllIIllIlIIII, final int lllllllllllllIIlIIllllIIlllIllll) {
        final double lllllllllllllIIlIIllllIIllIlIllI = 2.002083095183101E-146;
        final double lllllllllllllIIlIIllllIIllIlIlIl = 4.9947976805055876E145;
        double lllllllllllllIIlIIllllIIllIlIlll = 0.0;
        double lllllllllllllIIlIIllllIIlllIlIII = 0.0;
        double lllllllllllllIIlIIllllIIlllIIIll = 0.0;
        if (lllllllllllllIIlIIllllIIllIlIIll == 0.0) {
            final double lllllllllllllIIlIIllllIIlllIllII = 1.0;
            final double lllllllllllllIIlIIllllIIlllIIlll = 0.0;
            final double lllllllllllllIIlIIllllIIllIllIll = lllllllllllllIIlIIllllIIllllIlII;
        }
        else if (lllllllllllllIIlIIllllIIllllIlII == 0.0) {
            final double lllllllllllllIIlIIllllIIlllIlIll = 0.0;
            final double lllllllllllllIIlIIllllIIlllIIllI = 1.0;
            final double lllllllllllllIIlIIllllIIllIllIlI = lllllllllllllIIlIIllllIIllIlIIll;
        }
        else {
            double lllllllllllllIIlIIllllIIllIlllIl = lllllllllllllIIlIIllllIIllllIlII;
            double lllllllllllllIIlIIllllIIllIlllII = lllllllllllllIIlIIllllIIllIlIIll;
            double lllllllllllllIIlIIllllIIlllIIIII = max(Math.abs(lllllllllllllIIlIIllllIIllIlllIl), Math.abs(lllllllllllllIIlIIllllIIllIlllII));
            if (lllllllllllllIIlIIllllIIlllIIIII >= 4.9947976805055876E145) {
                int lllllllllllllIIlIIllllIIllIlllll = 0;
                while (lllllllllllllIIlIIllllIIlllIIIII >= 4.9947976805055876E145) {
                    ++lllllllllllllIIlIIllllIIllIlllll;
                    lllllllllllllIIlIIllllIIllIlllIl *= 2.002083095183101E-146;
                    lllllllllllllIIlIIllllIIllIlllII *= 2.002083095183101E-146;
                    lllllllllllllIIlIIllllIIlllIIIII = max(Math.abs(lllllllllllllIIlIIllllIIllIlllIl), Math.abs(lllllllllllllIIlIIllllIIllIlllII));
                }
                double lllllllllllllIIlIIllllIIllIllIIl = Math.sqrt(lllllllllllllIIlIIllllIIllIlllIl * lllllllllllllIIlIIllllIIllIlllIl + lllllllllllllIIlIIllllIIllIlllII * lllllllllllllIIlIIllllIIllIlllII);
                final double lllllllllllllIIlIIllllIIlllIlIlI = lllllllllllllIIlIIllllIIllIlllIl / lllllllllllllIIlIIllllIIllIllIIl;
                final double lllllllllllllIIlIIllllIIlllIIlIl = lllllllllllllIIlIIllllIIllIlllII / lllllllllllllIIlIIllllIIllIllIIl;
                final int lllllllllllllIIlIIllllIIlllIlllI = lllllllllllllIIlIIllllIIllIlllll;
                for (int lllllllllllllIIlIIllllIIlllIIIlI = 1; lllllllllllllIIlIIllllIIlllIIIlI <= lllllllllllllIIlIIllllIIllIlllll; ++lllllllllllllIIlIIllllIIlllIIIlI) {
                    lllllllllllllIIlIIllllIIllIllIIl *= 4.9947976805055876E145;
                }
            }
            else if (lllllllllllllIIlIIllllIIlllIIIII <= 2.002083095183101E-146) {
                int lllllllllllllIIlIIllllIIllIllllI = 0;
                while (lllllllllllllIIlIIllllIIlllIIIII <= 2.002083095183101E-146) {
                    ++lllllllllllllIIlIIllllIIllIllllI;
                    lllllllllllllIIlIIllllIIllIlllIl *= 4.9947976805055876E145;
                    lllllllllllllIIlIIllllIIllIlllII *= 4.9947976805055876E145;
                    lllllllllllllIIlIIllllIIlllIIIII = max(Math.abs(lllllllllllllIIlIIllllIIllIlllIl), Math.abs(lllllllllllllIIlIIllllIIllIlllII));
                }
                double lllllllllllllIIlIIllllIIllIllIII = Math.sqrt(lllllllllllllIIlIIllllIIllIlllIl * lllllllllllllIIlIIllllIIllIlllIl + lllllllllllllIIlIIllllIIllIlllII * lllllllllllllIIlIIllllIIllIlllII);
                final double lllllllllllllIIlIIllllIIlllIlIIl = lllllllllllllIIlIIllllIIllIlllIl / lllllllllllllIIlIIllllIIllIllIII;
                final double lllllllllllllIIlIIllllIIlllIIlII = lllllllllllllIIlIIllllIIllIlllII / lllllllllllllIIlIIllllIIllIllIII;
                final int lllllllllllllIIlIIllllIIlllIllIl = lllllllllllllIIlIIllllIIllIllllI;
                for (int lllllllllllllIIlIIllllIIlllIIIIl = 1; lllllllllllllIIlIIllllIIlllIIIIl <= lllllllllllllIIlIIllllIIllIllllI; ++lllllllllllllIIlIIllllIIlllIIIIl) {
                    lllllllllllllIIlIIllllIIllIllIII *= 2.002083095183101E-146;
                }
            }
            else {
                lllllllllllllIIlIIllllIIllIlIlll = Math.sqrt(lllllllllllllIIlIIllllIIllIlllIl * lllllllllllllIIlIIllllIIllIlllIl + lllllllllllllIIlIIllllIIllIlllII * lllllllllllllIIlIIllllIIllIlllII);
                lllllllllllllIIlIIllllIIlllIlIII = lllllllllllllIIlIIllllIIllIlllIl / lllllllllllllIIlIIllllIIllIlIlll;
                lllllllllllllIIlIIllllIIlllIIIll = lllllllllllllIIlIIllllIIllIlllII / lllllllllllllIIlIIllllIIllIlIlll;
            }
            if (Math.abs(lllllllllllllIIlIIllllIIllllIlII) > Math.abs(lllllllllllllIIlIIllllIIllIlIIll) && lllllllllllllIIlIIllllIIlllIlIII < 0.0) {
                lllllllllllllIIlIIllllIIlllIlIII = -lllllllllllllIIlIIllllIIlllIlIII;
                lllllllllllllIIlIIllllIIlllIIIll = -lllllllllllllIIlIIllllIIlllIIIll;
                lllllllllllllIIlIIllllIIllIlIlll = -lllllllllllllIIlIIllllIIllIlIlll;
            }
        }
        lllllllllllllIIlIIllllIIllllIIlI[lllllllllllllIIlIIllllIIllIlIIII] = lllllllllllllIIlIIllllIIlllIIIll;
        lllllllllllllIIlIIllllIIllIlIIIl[lllllllllllllIIlIIllllIIllIlIIII] = lllllllllllllIIlIIllllIIlllIlIII;
        return lllllllllllllIIlIIllllIIllIlIlll;
    }
    
    public final double getM02() {
        return this.m02;
    }
    
    public final void set(final Quat4d lllllllllllllIIlIlIIIIIIllllllIl) {
        this.m00 = 1.0 - 2.0 * lllllllllllllIIlIlIIIIIIllllllIl.y * lllllllllllllIIlIlIIIIIIllllllIl.y - 2.0 * lllllllllllllIIlIlIIIIIIllllllIl.z * lllllllllllllIIlIlIIIIIIllllllIl.z;
        this.m10 = 2.0 * (lllllllllllllIIlIlIIIIIIllllllIl.x * lllllllllllllIIlIlIIIIIIllllllIl.y + lllllllllllllIIlIlIIIIIIllllllIl.w * lllllllllllllIIlIlIIIIIIllllllIl.z);
        this.m20 = 2.0 * (lllllllllllllIIlIlIIIIIIllllllIl.x * lllllllllllllIIlIlIIIIIIllllllIl.z - lllllllllllllIIlIlIIIIIIllllllIl.w * lllllllllllllIIlIlIIIIIIllllllIl.y);
        this.m01 = 2.0 * (lllllllllllllIIlIlIIIIIIllllllIl.x * lllllllllllllIIlIlIIIIIIllllllIl.y - lllllllllllllIIlIlIIIIIIllllllIl.w * lllllllllllllIIlIlIIIIIIllllllIl.z);
        this.m11 = 1.0 - 2.0 * lllllllllllllIIlIlIIIIIIllllllIl.x * lllllllllllllIIlIlIIIIIIllllllIl.x - 2.0 * lllllllllllllIIlIlIIIIIIllllllIl.z * lllllllllllllIIlIlIIIIIIllllllIl.z;
        this.m21 = 2.0 * (lllllllllllllIIlIlIIIIIIllllllIl.y * lllllllllllllIIlIlIIIIIIllllllIl.z + lllllllllllllIIlIlIIIIIIllllllIl.w * lllllllllllllIIlIlIIIIIIllllllIl.x);
        this.m02 = 2.0 * (lllllllllllllIIlIlIIIIIIllllllIl.x * lllllllllllllIIlIlIIIIIIllllllIl.z + lllllllllllllIIlIlIIIIIIllllllIl.w * lllllllllllllIIlIlIIIIIIllllllIl.y);
        this.m12 = 2.0 * (lllllllllllllIIlIlIIIIIIllllllIl.y * lllllllllllllIIlIlIIIIIIllllllIl.z - lllllllllllllIIlIlIIIIIIllllllIl.w * lllllllllllllIIlIlIIIIIIllllllIl.x);
        this.m22 = 1.0 - 2.0 * lllllllllllllIIlIlIIIIIIllllllIl.x * lllllllllllllIIlIlIIIIIIllllllIl.x - 2.0 * lllllllllllllIIlIlIIIIIIllllllIl.y * lllllllllllllIIlIlIIIIIIllllllIl.y;
    }
    
    static double min(final double lllllllllllllIIlIIllllIllIlllIll, final double lllllllllllllIIlIIllllIllIlllIII) {
        if (lllllllllllllIIlIIllllIllIlllIll < lllllllllllllIIlIIllllIllIlllIII) {
            return lllllllllllllIIlIIllllIllIlllIll;
        }
        return lllllllllllllIIlIIllllIllIlllIII;
    }
    
    public final void setM20(final double lllllllllllllIIlIIllllIIIlIIIIll) {
        this.m20 = lllllllllllllIIlIIllllIIIlIIIIll;
    }
    
    public final void transpose(final Matrix3d lllllllllllllIIlIlIIIIIlIIIIIIll) {
        if (this != lllllllllllllIIlIlIIIIIlIIIIIIll) {
            this.m00 = lllllllllllllIIlIlIIIIIlIIIIIIll.m00;
            this.m01 = lllllllllllllIIlIlIIIIIlIIIIIIll.m10;
            this.m02 = lllllllllllllIIlIlIIIIIlIIIIIIll.m20;
            this.m10 = lllllllllllllIIlIlIIIIIlIIIIIIll.m01;
            this.m11 = lllllllllllllIIlIlIIIIIlIIIIIIll.m11;
            this.m12 = lllllllllllllIIlIlIIIIIlIIIIIIll.m21;
            this.m20 = lllllllllllllIIlIlIIIIIlIIIIIIll.m02;
            this.m21 = lllllllllllllIIlIlIIIIIlIIIIIIll.m12;
            this.m22 = lllllllllllllIIlIlIIIIIlIIIIIIll.m22;
        }
        else {
            this.transpose();
        }
    }
    
    public Object clone() {
        Matrix3d lllllllllllllIIlIIllllIIlIIIIlII = null;
        try {
            lllllllllllllIIlIIllllIIlIIIIlII = (Matrix3d)super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIIlIIllllIIlIIIIIll) {
            throw new InternalError();
        }
        return lllllllllllllIIlIIllllIIlIIIIlII;
    }
    
    public final double getM10() {
        return this.m10;
    }
    
    public final void getRow(final int lllllllllllllIIlIlIIIIIllIIlllIl, final double[] lllllllllllllIIlIlIIIIIllIIllIIl) {
        if (lllllllllllllIIlIlIIIIIllIIlllIl == 0) {
            lllllllllllllIIlIlIIIIIllIIllIIl[0] = this.m00;
            lllllllllllllIIlIlIIIIIllIIllIIl[1] = this.m01;
            lllllllllllllIIlIlIIIIIllIIllIIl[2] = this.m02;
        }
        else if (lllllllllllllIIlIlIIIIIllIIlllIl == 1) {
            lllllllllllllIIlIlIIIIIllIIllIIl[0] = this.m10;
            lllllllllllllIIlIlIIIIIllIIllIIl[1] = this.m11;
            lllllllllllllIIlIlIIIIIllIIllIIl[2] = this.m12;
        }
        else {
            if (lllllllllllllIIlIlIIIIIllIIlllIl != 2) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d2"));
            }
            lllllllllllllIIlIlIIIIIllIIllIIl[0] = this.m20;
            lllllllllllllIIlIlIIIIIllIIllIIl[1] = this.m21;
            lllllllllllllIIlIlIIIIIllIIllIIl[2] = this.m22;
        }
    }
    
    public final void set(final Matrix3f lllllllllllllIIlIlIIIIIIlIlIlIll) {
        this.m00 = lllllllllllllIIlIlIIIIIIlIlIlIll.m00;
        this.m01 = lllllllllllllIIlIlIIIIIIlIlIlIll.m01;
        this.m02 = lllllllllllllIIlIlIIIIIIlIlIlIll.m02;
        this.m10 = lllllllllllllIIlIlIIIIIIlIlIlIll.m10;
        this.m11 = lllllllllllllIIlIlIIIIIIlIlIlIll.m11;
        this.m12 = lllllllllllllIIlIlIIIIIIlIlIlIll.m12;
        this.m20 = lllllllllllllIIlIlIIIIIIlIlIlIll.m20;
        this.m21 = lllllllllllllIIlIlIIIIIIlIlIlIll.m21;
        this.m22 = lllllllllllllIIlIlIIIIIIlIlIlIll.m22;
    }
    
    public final void setColumn(final int lllllllllllllIIlIlIIIIIlIlIlIIlI, final Vector3d lllllllllllllIIlIlIIIIIlIlIIlllI) {
        switch (lllllllllllllIIlIlIIIIIlIlIlIIlI) {
            case 0: {
                this.m00 = lllllllllllllIIlIlIIIIIlIlIIlllI.x;
                this.m10 = lllllllllllllIIlIlIIIIIlIlIIlllI.y;
                this.m20 = lllllllllllllIIlIlIIIIIlIlIIlllI.z;
                break;
            }
            case 1: {
                this.m01 = lllllllllllllIIlIlIIIIIlIlIIlllI.x;
                this.m11 = lllllllllllllIIlIlIIIIIlIlIIlllI.y;
                this.m21 = lllllllllllllIIlIlIIIIIlIlIIlllI.z;
                break;
            }
            case 2: {
                this.m02 = lllllllllllllIIlIlIIIIIlIlIIlllI.x;
                this.m12 = lllllllllllllIIlIlIIIIIlIlIIlllI.y;
                this.m22 = lllllllllllllIIlIlIIIIIlIlIIlllI.z;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
            }
        }
    }
    
    public final void setM12(final double lllllllllllllIIlIIllllIIIlIIllII) {
        this.m12 = lllllllllllllIIlIIllllIIIlIIllII;
    }
    
    public Matrix3d() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
    }
    
    public final void add(final Matrix3d lllllllllllllIIlIlIIIIIlIIlIIIII) {
        this.m00 += lllllllllllllIIlIlIIIIIlIIlIIIII.m00;
        this.m01 += lllllllllllllIIlIlIIIIIlIIlIIIII.m01;
        this.m02 += lllllllllllllIIlIlIIIIIlIIlIIIII.m02;
        this.m10 += lllllllllllllIIlIlIIIIIlIIlIIIII.m10;
        this.m11 += lllllllllllllIIlIlIIIIIlIIlIIIII.m11;
        this.m12 += lllllllllllllIIlIlIIIIIlIIlIIIII.m12;
        this.m20 += lllllllllllllIIlIlIIIIIlIIlIIIII.m20;
        this.m21 += lllllllllllllIIlIlIIIIIlIIlIIIII.m21;
        this.m22 += lllllllllllllIIlIlIIIIIlIIlIIIII.m22;
    }
    
    public final double getM01() {
        return this.m01;
    }
    
    public final void mulTransposeLeft(final Matrix3d lllllllllllllIIlIIllllllIIIllIll, final Matrix3d lllllllllllllIIlIIllllllIIlIIllI) {
        if (this != lllllllllllllIIlIIllllllIIIllIll && this != lllllllllllllIIlIIllllllIIlIIllI) {
            this.m00 = lllllllllllllIIlIIllllllIIIllIll.m00 * lllllllllllllIIlIIllllllIIlIIllI.m00 + lllllllllllllIIlIIllllllIIIllIll.m10 * lllllllllllllIIlIIllllllIIlIIllI.m10 + lllllllllllllIIlIIllllllIIIllIll.m20 * lllllllllllllIIlIIllllllIIlIIllI.m20;
            this.m01 = lllllllllllllIIlIIllllllIIIllIll.m00 * lllllllllllllIIlIIllllllIIlIIllI.m01 + lllllllllllllIIlIIllllllIIIllIll.m10 * lllllllllllllIIlIIllllllIIlIIllI.m11 + lllllllllllllIIlIIllllllIIIllIll.m20 * lllllllllllllIIlIIllllllIIlIIllI.m21;
            this.m02 = lllllllllllllIIlIIllllllIIIllIll.m00 * lllllllllllllIIlIIllllllIIlIIllI.m02 + lllllllllllllIIlIIllllllIIIllIll.m10 * lllllllllllllIIlIIllllllIIlIIllI.m12 + lllllllllllllIIlIIllllllIIIllIll.m20 * lllllllllllllIIlIIllllllIIlIIllI.m22;
            this.m10 = lllllllllllllIIlIIllllllIIIllIll.m01 * lllllllllllllIIlIIllllllIIlIIllI.m00 + lllllllllllllIIlIIllllllIIIllIll.m11 * lllllllllllllIIlIIllllllIIlIIllI.m10 + lllllllllllllIIlIIllllllIIIllIll.m21 * lllllllllllllIIlIIllllllIIlIIllI.m20;
            this.m11 = lllllllllllllIIlIIllllllIIIllIll.m01 * lllllllllllllIIlIIllllllIIlIIllI.m01 + lllllllllllllIIlIIllllllIIIllIll.m11 * lllllllllllllIIlIIllllllIIlIIllI.m11 + lllllllllllllIIlIIllllllIIIllIll.m21 * lllllllllllllIIlIIllllllIIlIIllI.m21;
            this.m12 = lllllllllllllIIlIIllllllIIIllIll.m01 * lllllllllllllIIlIIllllllIIlIIllI.m02 + lllllllllllllIIlIIllllllIIIllIll.m11 * lllllllllllllIIlIIllllllIIlIIllI.m12 + lllllllllllllIIlIIllllllIIIllIll.m21 * lllllllllllllIIlIIllllllIIlIIllI.m22;
            this.m20 = lllllllllllllIIlIIllllllIIIllIll.m02 * lllllllllllllIIlIIllllllIIlIIllI.m00 + lllllllllllllIIlIIllllllIIIllIll.m12 * lllllllllllllIIlIIllllllIIlIIllI.m10 + lllllllllllllIIlIIllllllIIIllIll.m22 * lllllllllllllIIlIIllllllIIlIIllI.m20;
            this.m21 = lllllllllllllIIlIIllllllIIIllIll.m02 * lllllllllllllIIlIIllllllIIlIIllI.m01 + lllllllllllllIIlIIllllllIIIllIll.m12 * lllllllllllllIIlIIllllllIIlIIllI.m11 + lllllllllllllIIlIIllllllIIIllIll.m22 * lllllllllllllIIlIIllllllIIlIIllI.m21;
            this.m22 = lllllllllllllIIlIIllllllIIIllIll.m02 * lllllllllllllIIlIIllllllIIlIIllI.m02 + lllllllllllllIIlIIllllllIIIllIll.m12 * lllllllllllllIIlIIllllllIIlIIllI.m12 + lllllllllllllIIlIIllllllIIIllIll.m22 * lllllllllllllIIlIIllllllIIlIIllI.m22;
        }
        else {
            final double lllllllllllllIIlIIllllllIIlIIlIl = lllllllllllllIIlIIllllllIIIllIll.m00 * lllllllllllllIIlIIllllllIIlIIllI.m00 + lllllllllllllIIlIIllllllIIIllIll.m10 * lllllllllllllIIlIIllllllIIlIIllI.m10 + lllllllllllllIIlIIllllllIIIllIll.m20 * lllllllllllllIIlIIllllllIIlIIllI.m20;
            final double lllllllllllllIIlIIllllllIIlIIlII = lllllllllllllIIlIIllllllIIIllIll.m00 * lllllllllllllIIlIIllllllIIlIIllI.m01 + lllllllllllllIIlIIllllllIIIllIll.m10 * lllllllllllllIIlIIllllllIIlIIllI.m11 + lllllllllllllIIlIIllllllIIIllIll.m20 * lllllllllllllIIlIIllllllIIlIIllI.m21;
            final double lllllllllllllIIlIIllllllIIlIIIll = lllllllllllllIIlIIllllllIIIllIll.m00 * lllllllllllllIIlIIllllllIIlIIllI.m02 + lllllllllllllIIlIIllllllIIIllIll.m10 * lllllllllllllIIlIIllllllIIlIIllI.m12 + lllllllllllllIIlIIllllllIIIllIll.m20 * lllllllllllllIIlIIllllllIIlIIllI.m22;
            final double lllllllllllllIIlIIllllllIIlIIIlI = lllllllllllllIIlIIllllllIIIllIll.m01 * lllllllllllllIIlIIllllllIIlIIllI.m00 + lllllllllllllIIlIIllllllIIIllIll.m11 * lllllllllllllIIlIIllllllIIlIIllI.m10 + lllllllllllllIIlIIllllllIIIllIll.m21 * lllllllllllllIIlIIllllllIIlIIllI.m20;
            final double lllllllllllllIIlIIllllllIIlIIIIl = lllllllllllllIIlIIllllllIIIllIll.m01 * lllllllllllllIIlIIllllllIIlIIllI.m01 + lllllllllllllIIlIIllllllIIIllIll.m11 * lllllllllllllIIlIIllllllIIlIIllI.m11 + lllllllllllllIIlIIllllllIIIllIll.m21 * lllllllllllllIIlIIllllllIIlIIllI.m21;
            final double lllllllllllllIIlIIllllllIIlIIIII = lllllllllllllIIlIIllllllIIIllIll.m01 * lllllllllllllIIlIIllllllIIlIIllI.m02 + lllllllllllllIIlIIllllllIIIllIll.m11 * lllllllllllllIIlIIllllllIIlIIllI.m12 + lllllllllllllIIlIIllllllIIIllIll.m21 * lllllllllllllIIlIIllllllIIlIIllI.m22;
            final double lllllllllllllIIlIIllllllIIIlllll = lllllllllllllIIlIIllllllIIIllIll.m02 * lllllllllllllIIlIIllllllIIlIIllI.m00 + lllllllllllllIIlIIllllllIIIllIll.m12 * lllllllllllllIIlIIllllllIIlIIllI.m10 + lllllllllllllIIlIIllllllIIIllIll.m22 * lllllllllllllIIlIIllllllIIlIIllI.m20;
            final double lllllllllllllIIlIIllllllIIIllllI = lllllllllllllIIlIIllllllIIIllIll.m02 * lllllllllllllIIlIIllllllIIlIIllI.m01 + lllllllllllllIIlIIllllllIIIllIll.m12 * lllllllllllllIIlIIllllllIIlIIllI.m11 + lllllllllllllIIlIIllllllIIIllIll.m22 * lllllllllllllIIlIIllllllIIlIIllI.m21;
            final double lllllllllllllIIlIIllllllIIIlllIl = lllllllllllllIIlIIllllllIIIllIll.m02 * lllllllllllllIIlIIllllllIIlIIllI.m02 + lllllllllllllIIlIIllllllIIIllIll.m12 * lllllllllllllIIlIIllllllIIlIIllI.m12 + lllllllllllllIIlIIllllllIIIllIll.m22 * lllllllllllllIIlIIllllllIIlIIllI.m22;
            this.m00 = lllllllllllllIIlIIllllllIIlIIlIl;
            this.m01 = lllllllllllllIIlIIllllllIIlIIlII;
            this.m02 = lllllllllllllIIlIIllllllIIlIIIll;
            this.m10 = lllllllllllllIIlIIllllllIIlIIIlI;
            this.m11 = lllllllllllllIIlIIllllllIIlIIIIl;
            this.m12 = lllllllllllllIIlIIllllllIIlIIIII;
            this.m20 = lllllllllllllIIlIIllllllIIIlllll;
            this.m21 = lllllllllllllIIlIIllllllIIIllllI;
            this.m22 = lllllllllllllIIlIIllllllIIIlllIl;
        }
    }
    
    public final void setZero() {
        this.m00 = 0.0;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = 0.0;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = 0.0;
    }
    
    final void getScaleRotate(final double[] lllllllllllllIIlIIlllllIlIIlIIII, final double[] lllllllllllllIIlIIlllllIlIIIllll) {
        final double[] lllllllllllllIIlIIlllllIlIIlIIlI = { this.m00, this.m01, this.m02, this.m10, this.m11, this.m12, this.m20, this.m21, this.m22 };
        compute_svd(lllllllllllllIIlIIlllllIlIIlIIlI, lllllllllllllIIlIIlllllIlIIlIIII, lllllllllllllIIlIIlllllIlIIIllll);
    }
    
    public final void setM21(final double lllllllllllllIIlIIllllIIIIlllIII) {
        this.m21 = lllllllllllllIIlIIllllIIIIlllIII;
    }
    
    static void luBacksubstitution(final double[] lllllllllllllIIlIlIIIIIIIIlIllIl, final int[] lllllllllllllIIlIlIIIIIIIIlIllII, final double[] lllllllllllllIIlIlIIIIIIIIlllIII) {
        final int lllllllllllllIIlIlIIIIIIIIllIIlI = 0;
        for (int lllllllllllllIIlIlIIIIIIIIllIIll = 0; lllllllllllllIIlIlIIIIIIIIllIIll < 3; ++lllllllllllllIIlIlIIIIIIIIllIIll) {
            final int lllllllllllllIIlIlIIIIIIIIllIIIl = lllllllllllllIIlIlIIIIIIIIllIIll;
            int lllllllllllllIIlIlIIIIIIIIllIllI = -1;
            for (int lllllllllllllIIlIlIIIIIIIIllIlll = 0; lllllllllllllIIlIlIIIIIIIIllIlll < 3; ++lllllllllllllIIlIlIIIIIIIIllIlll) {
                final int lllllllllllllIIlIlIIIIIIIIllIlIl = lllllllllllllIIlIlIIIIIIIIlIllII[lllllllllllllIIlIlIIIIIIIIllIIlI + lllllllllllllIIlIlIIIIIIIIllIlll];
                double lllllllllllllIIlIlIIIIIIIIlIlllI = lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 3 * lllllllllllllIIlIlIIIIIIIIllIlIl];
                lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 3 * lllllllllllllIIlIlIIIIIIIIllIlIl] = lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 3 * lllllllllllllIIlIlIIIIIIIIllIlll];
                if (lllllllllllllIIlIlIIIIIIIIllIllI >= 0) {
                    final int lllllllllllllIIlIlIIIIIIIIllIIII = lllllllllllllIIlIlIIIIIIIIllIlll * 3;
                    for (int lllllllllllllIIlIlIIIIIIIIllIlII = lllllllllllllIIlIlIIIIIIIIllIllI; lllllllllllllIIlIlIIIIIIIIllIlII <= lllllllllllllIIlIlIIIIIIIIllIlll - 1; ++lllllllllllllIIlIlIIIIIIIIllIlII) {
                        lllllllllllllIIlIlIIIIIIIIlIlllI -= lllllllllllllIIlIlIIIIIIIIlIllIl[lllllllllllllIIlIlIIIIIIIIllIIII + lllllllllllllIIlIlIIIIIIIIllIlII] * lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 3 * lllllllllllllIIlIlIIIIIIIIllIlII];
                    }
                }
                else if (lllllllllllllIIlIlIIIIIIIIlIlllI != 0.0) {
                    lllllllllllllIIlIlIIIIIIIIllIllI = lllllllllllllIIlIlIIIIIIIIllIlll;
                }
                lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 3 * lllllllllllllIIlIlIIIIIIIIllIlll] = lllllllllllllIIlIlIIIIIIIIlIlllI;
            }
            int lllllllllllllIIlIlIIIIIIIIlIllll = 6;
            final int n = lllllllllllllIIlIlIIIIIIIIllIIIl + 6;
            lllllllllllllIIlIlIIIIIIIIlllIII[n] /= lllllllllllllIIlIlIIIIIIIIlIllIl[lllllllllllllIIlIlIIIIIIIIlIllll + 2];
            lllllllllllllIIlIlIIIIIIIIlIllll -= 3;
            lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 3] = (lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 3] - lllllllllllllIIlIlIIIIIIIIlIllIl[lllllllllllllIIlIlIIIIIIIIlIllll + 2] * lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 6]) / lllllllllllllIIlIlIIIIIIIIlIllIl[lllllllllllllIIlIlIIIIIIIIlIllll + 1];
            lllllllllllllIIlIlIIIIIIIIlIllll -= 3;
            lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 0] = (lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 0] - lllllllllllllIIlIlIIIIIIIIlIllIl[lllllllllllllIIlIlIIIIIIIIlIllll + 1] * lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 3] - lllllllllllllIIlIlIIIIIIIIlIllIl[lllllllllllllIIlIlIIIIIIIIlIllll + 2] * lllllllllllllIIlIlIIIIIIIIlllIII[lllllllllllllIIlIlIIIIIIIIllIIIl + 6]) / lllllllllllllIIlIlIIIIIIIIlIllIl[lllllllllllllIIlIlIIIIIIIIlIllll + 0];
        }
    }
    
    public final void setRow(final int lllllllllllllIIlIlIIIIIlIllIlIlI, final double[] lllllllllllllIIlIlIIIIIlIllIlIIl) {
        switch (lllllllllllllIIlIlIIIIIlIllIlIlI) {
            case 0: {
                this.m00 = lllllllllllllIIlIlIIIIIlIllIlIIl[0];
                this.m01 = lllllllllllllIIlIlIIIIIlIllIlIIl[1];
                this.m02 = lllllllllllllIIlIlIIIIIlIllIlIIl[2];
                break;
            }
            case 1: {
                this.m10 = lllllllllllllIIlIlIIIIIlIllIlIIl[0];
                this.m11 = lllllllllllllIIlIlIIIIIlIllIlIIl[1];
                this.m12 = lllllllllllllIIlIlIIIIIlIllIlIIl[2];
                break;
            }
            case 2: {
                this.m20 = lllllllllllllIIlIlIIIIIlIllIlIIl[0];
                this.m21 = lllllllllllllIIlIlIIIIIlIllIlIIl[1];
                this.m22 = lllllllllllllIIlIlIIIIIlIllIlIIl[2];
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d6"));
            }
        }
    }
    
    public final void negate(final Matrix3d lllllllllllllIIlIIlllllIlIlllIlI) {
        this.m00 = -lllllllllllllIIlIIlllllIlIlllIlI.m00;
        this.m01 = -lllllllllllllIIlIIlllllIlIlllIlI.m01;
        this.m02 = -lllllllllllllIIlIIlllllIlIlllIlI.m02;
        this.m10 = -lllllllllllllIIlIIlllllIlIlllIlI.m10;
        this.m11 = -lllllllllllllIIlIIlllllIlIlllIlI.m11;
        this.m12 = -lllllllllllllIIlIIlllllIlIlllIlI.m12;
        this.m20 = -lllllllllllllIIlIIlllllIlIlllIlI.m20;
        this.m21 = -lllllllllllllIIlIIlllllIlIlllIlI.m21;
        this.m22 = -lllllllllllllIIlIIlllllIlIlllIlI.m22;
    }
    
    static void print_det(final double[] lllllllllllllIIlIIllllIIlIlllIlI) {
        final double lllllllllllllIIlIIllllIIlIlllIll = lllllllllllllIIlIIllllIIlIlllIlI[0] * lllllllllllllIIlIIllllIIlIlllIlI[4] * lllllllllllllIIlIIllllIIlIlllIlI[8] + lllllllllllllIIlIIllllIIlIlllIlI[1] * lllllllllllllIIlIIllllIIlIlllIlI[5] * lllllllllllllIIlIIllllIIlIlllIlI[6] + lllllllllllllIIlIIllllIIlIlllIlI[2] * lllllllllllllIIlIIllllIIlIlllIlI[3] * lllllllllllllIIlIIllllIIlIlllIlI[7] - lllllllllllllIIlIIllllIIlIlllIlI[2] * lllllllllllllIIlIIllllIIlIlllIlI[4] * lllllllllllllIIlIIllllIIlIlllIlI[6] - lllllllllllllIIlIIllllIIlIlllIlI[0] * lllllllllllllIIlIIllllIIlIlllIlI[5] * lllllllllllllIIlIIllllIIlIlllIlI[7] - lllllllllllllIIlIIllllIIlIlllIlI[1] * lllllllllllllIIlIIllllIIlIlllIlI[3] * lllllllllllllIIlIIllllIIlIlllIlI[8];
        System.out.println(String.valueOf(new StringBuilder("det= ").append(lllllllllllllIIlIIllllIIlIlllIll)));
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
    
    public final void set(final AxisAngle4d lllllllllllllIIlIlIIIIIIlllIIIlI) {
        double lllllllllllllIIlIlIIIIIIlllIlllI = Math.sqrt(lllllllllllllIIlIlIIIIIIlllIIIlI.x * lllllllllllllIIlIlIIIIIIlllIIIlI.x + lllllllllllllIIlIlIIIIIIlllIIIlI.y * lllllllllllllIIlIlIIIIIIlllIIIlI.y + lllllllllllllIIlIlIIIIIIlllIIIlI.z * lllllllllllllIIlIlIIIIIIlllIIIlI.z);
        if (lllllllllllllIIlIlIIIIIIlllIlllI < 1.110223024E-16) {
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
            lllllllllllllIIlIlIIIIIIlllIlllI = 1.0 / lllllllllllllIIlIlIIIIIIlllIlllI;
            final double lllllllllllllIIlIlIIIIIIlllIllIl = lllllllllllllIIlIlIIIIIIlllIIIlI.x * lllllllllllllIIlIlIIIIIIlllIlllI;
            final double lllllllllllllIIlIlIIIIIIlllIllII = lllllllllllllIIlIlIIIIIIlllIIIlI.y * lllllllllllllIIlIlIIIIIIlllIlllI;
            final double lllllllllllllIIlIlIIIIIIlllIlIll = lllllllllllllIIlIlIIIIIIlllIIIlI.z * lllllllllllllIIlIlIIIIIIlllIlllI;
            final double lllllllllllllIIlIlIIIIIIlllIlIlI = Math.sin(lllllllllllllIIlIlIIIIIIlllIIIlI.angle);
            final double lllllllllllllIIlIlIIIIIIlllIlIIl = Math.cos(lllllllllllllIIlIlIIIIIIlllIIIlI.angle);
            final double lllllllllllllIIlIlIIIIIIlllIlIII = 1.0 - lllllllllllllIIlIlIIIIIIlllIlIIl;
            final double lllllllllllllIIlIlIIIIIIlllIIlll = lllllllllllllIIlIlIIIIIIlllIllIl * lllllllllllllIIlIlIIIIIIlllIlIll;
            final double lllllllllllllIIlIlIIIIIIlllIIllI = lllllllllllllIIlIlIIIIIIlllIllIl * lllllllllllllIIlIlIIIIIIlllIllII;
            final double lllllllllllllIIlIlIIIIIIlllIIlIl = lllllllllllllIIlIlIIIIIIlllIllII * lllllllllllllIIlIlIIIIIIlllIlIll;
            this.m00 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIllIl * lllllllllllllIIlIlIIIIIIlllIllIl + lllllllllllllIIlIlIIIIIIlllIlIIl;
            this.m01 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIIllI - lllllllllllllIIlIlIIIIIIlllIlIlI * lllllllllllllIIlIlIIIIIIlllIlIll;
            this.m02 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIIlll + lllllllllllllIIlIlIIIIIIlllIlIlI * lllllllllllllIIlIlIIIIIIlllIllII;
            this.m10 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIIllI + lllllllllllllIIlIlIIIIIIlllIlIlI * lllllllllllllIIlIlIIIIIIlllIlIll;
            this.m11 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIllII * lllllllllllllIIlIlIIIIIIlllIllII + lllllllllllllIIlIlIIIIIIlllIlIIl;
            this.m12 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIIlIl - lllllllllllllIIlIlIIIIIIlllIlIlI * lllllllllllllIIlIlIIIIIIlllIllIl;
            this.m20 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIIlll - lllllllllllllIIlIlIIIIIIlllIlIlI * lllllllllllllIIlIlIIIIIIlllIllII;
            this.m21 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIIlIl + lllllllllllllIIlIlIIIIIIlllIlIlI * lllllllllllllIIlIlIIIIIIlllIllIl;
            this.m22 = lllllllllllllIIlIlIIIIIIlllIlIII * lllllllllllllIIlIlIIIIIIlllIlIll * lllllllllllllIIlIlIIIIIIlllIlIll + lllllllllllllIIlIlIIIIIIlllIlIIl;
        }
    }
    
    public final void add(final Matrix3d lllllllllllllIIlIlIIIIIlIIlIlIII, final Matrix3d lllllllllllllIIlIlIIIIIlIIlIIlll) {
        this.m00 = lllllllllllllIIlIlIIIIIlIIlIlIII.m00 + lllllllllllllIIlIlIIIIIlIIlIIlll.m00;
        this.m01 = lllllllllllllIIlIlIIIIIlIIlIlIII.m01 + lllllllllllllIIlIlIIIIIlIIlIIlll.m01;
        this.m02 = lllllllllllllIIlIlIIIIIlIIlIlIII.m02 + lllllllllllllIIlIlIIIIIlIIlIIlll.m02;
        this.m10 = lllllllllllllIIlIlIIIIIlIIlIlIII.m10 + lllllllllllllIIlIlIIIIIlIIlIIlll.m10;
        this.m11 = lllllllllllllIIlIlIIIIIlIIlIlIII.m11 + lllllllllllllIIlIlIIIIIlIIlIIlll.m11;
        this.m12 = lllllllllllllIIlIlIIIIIlIIlIlIII.m12 + lllllllllllllIIlIlIIIIIlIIlIIlll.m12;
        this.m20 = lllllllllllllIIlIlIIIIIlIIlIlIII.m20 + lllllllllllllIIlIlIIIIIlIIlIIlll.m20;
        this.m21 = lllllllllllllIIlIlIIIIIlIIlIlIII.m21 + lllllllllllllIIlIlIIIIIlIIlIIlll.m21;
        this.m22 = lllllllllllllIIlIlIIIIIlIIlIlIII.m22 + lllllllllllllIIlIlIIIIIlIIlIIlll.m22;
    }
    
    public Matrix3d(final Matrix3f lllllllllllllIIlIlIIIIIlllIlIlll) {
        this.m00 = lllllllllllllIIlIlIIIIIlllIlIlll.m00;
        this.m01 = lllllllllllllIIlIlIIIIIlllIlIlll.m01;
        this.m02 = lllllllllllllIIlIlIIIIIlllIlIlll.m02;
        this.m10 = lllllllllllllIIlIlIIIIIlllIlIlll.m10;
        this.m11 = lllllllllllllIIlIlIIIIIlllIlIlll.m11;
        this.m12 = lllllllllllllIIlIlIIIIIlllIlIlll.m12;
        this.m20 = lllllllllllllIIlIlIIIIIlllIlIlll.m20;
        this.m21 = lllllllllllllIIlIlIIIIIlllIlIlll.m21;
        this.m22 = lllllllllllllIIlIlIIIIIlllIlIlll.m22;
    }
    
    public final void getColumn(final int lllllllllllllIIlIlIIIIIllIIIlIll, final double[] lllllllllllllIIlIlIIIIIllIIIlIlI) {
        if (lllllllllllllIIlIlIIIIIllIIIlIll == 0) {
            lllllllllllllIIlIlIIIIIllIIIlIlI[0] = this.m00;
            lllllllllllllIIlIlIIIIIllIIIlIlI[1] = this.m10;
            lllllllllllllIIlIlIIIIIllIIIlIlI[2] = this.m20;
        }
        else if (lllllllllllllIIlIlIIIIIllIIIlIll == 1) {
            lllllllllllllIIlIlIIIIIllIIIlIlI[0] = this.m01;
            lllllllllllllIIlIlIIIIIllIIIlIlI[1] = this.m11;
            lllllllllllllIIlIlIIIIIllIIIlIlI[2] = this.m21;
        }
        else {
            if (lllllllllllllIIlIlIIIIIllIIIlIll != 2) {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d4"));
            }
            lllllllllllllIIlIlIIIIIllIIIlIlI[0] = this.m02;
            lllllllllllllIIlIlIIIIIllIIIlIlI[1] = this.m12;
            lllllllllllllIIlIlIIIIIllIIIlIlI[2] = this.m22;
        }
    }
    
    public final void set(final double lllllllllllllIIlIlIIIIIIIIIlIllI) {
        this.m00 = lllllllllllllIIlIlIIIIIIIIIlIllI;
        this.m01 = 0.0;
        this.m02 = 0.0;
        this.m10 = 0.0;
        this.m11 = lllllllllllllIIlIlIIIIIIIIIlIllI;
        this.m12 = 0.0;
        this.m20 = 0.0;
        this.m21 = 0.0;
        this.m22 = lllllllllllllIIlIlIIIIIIIIIlIllI;
    }
    
    public final void setM10(final double lllllllllllllIIlIIllllIIIlIllllI) {
        this.m10 = lllllllllllllIIlIIllllIIIlIllllI;
    }
    
    static void compute_svd(final double[] lllllllllllllIIlIIlllllIIlIlllII, final double[] lllllllllllllIIlIIlllllIIlllIlIl, final double[] lllllllllllllIIlIIlllllIIlIllIII) {
        final double[] lllllllllllllIIlIIlllllIIllIlllI = new double[9];
        final double[] lllllllllllllIIlIIlllllIIllIllIl = new double[9];
        final double[] lllllllllllllIIlIIlllllIIllIllII = new double[9];
        final double[] lllllllllllllIIlIIlllllIIllIlIll = new double[9];
        final double[] lllllllllllllIIlIIlllllIIllIlIlI = lllllllllllllIIlIIlllllIIllIllII;
        final double[] lllllllllllllIIlIIlllllIIllIlIIl = lllllllllllllIIlIIlllllIIllIlIll;
        final double[] lllllllllllllIIlIIlllllIIllIlIII = new double[9];
        final double[] lllllllllllllIIlIIlllllIIllIIlll = new double[3];
        final double[] lllllllllllllIIlIIlllllIIllIIllI = new double[3];
        int lllllllllllllIIlIIlllllIIllIIlIl = 0;
        for (int lllllllllllllIIlIIlllllIIlllIIll = 0; lllllllllllllIIlIIlllllIIlllIIll < 9; ++lllllllllllllIIlIIlllllIIlllIIll) {
            lllllllllllllIIlIIlllllIIllIlIII[lllllllllllllIIlIIlllllIIlllIIll] = lllllllllllllIIlIIlllllIIlIlllII[lllllllllllllIIlIIlllllIIlllIIll];
        }
        if (lllllllllllllIIlIIlllllIIlIlllII[3] * lllllllllllllIIlIIlllllIIlIlllII[3] < 1.110223024E-16) {
            lllllllllllllIIlIIlllllIIllIlllI[0] = 1.0;
            lllllllllllllIIlIIlllllIIllIlllI[1] = 0.0;
            lllllllllllllIIlIIlllllIIllIlllI[3] = (lllllllllllllIIlIIlllllIIllIlllI[2] = 0.0);
            lllllllllllllIIlIIlllllIIllIlllI[4] = 1.0;
            lllllllllllllIIlIIlllllIIllIlllI[5] = 0.0;
            lllllllllllllIIlIIlllllIIllIlllI[7] = (lllllllllllllIIlIIlllllIIllIlllI[6] = 0.0);
            lllllllllllllIIlIIlllllIIllIlllI[8] = 1.0;
        }
        else if (lllllllllllllIIlIIlllllIIlIlllII[0] * lllllllllllllIIlIIlllllIIlIlllII[0] < 1.110223024E-16) {
            lllllllllllllIIlIIlllllIIllIlIlI[0] = lllllllllllllIIlIIlllllIIlIlllII[0];
            lllllllllllllIIlIIlllllIIllIlIlI[1] = lllllllllllllIIlIIlllllIIlIlllII[1];
            lllllllllllllIIlIIlllllIIllIlIlI[2] = lllllllllllllIIlIIlllllIIlIlllII[2];
            lllllllllllllIIlIIlllllIIlIlllII[0] = lllllllllllllIIlIIlllllIIlIlllII[3];
            lllllllllllllIIlIIlllllIIlIlllII[1] = lllllllllllllIIlIIlllllIIlIlllII[4];
            lllllllllllllIIlIIlllllIIlIlllII[2] = lllllllllllllIIlIIlllllIIlIlllII[5];
            lllllllllllllIIlIIlllllIIlIlllII[3] = -lllllllllllllIIlIIlllllIIllIlIlI[0];
            lllllllllllllIIlIIlllllIIlIlllII[4] = -lllllllllllllIIlIIlllllIIllIlIlI[1];
            lllllllllllllIIlIIlllllIIlIlllII[5] = -lllllllllllllIIlIIlllllIIllIlIlI[2];
            lllllllllllllIIlIIlllllIIllIlllI[0] = 0.0;
            lllllllllllllIIlIIlllllIIllIlllI[1] = 1.0;
            lllllllllllllIIlIIlllllIIllIlllI[2] = 0.0;
            lllllllllllllIIlIIlllllIIllIlllI[3] = -1.0;
            lllllllllllllIIlIIlllllIIllIlllI[5] = (lllllllllllllIIlIIlllllIIllIlllI[4] = 0.0);
            lllllllllllllIIlIIlllllIIllIlllI[7] = (lllllllllllllIIlIIlllllIIllIlllI[6] = 0.0);
            lllllllllllllIIlIIlllllIIllIlllI[8] = 1.0;
        }
        else {
            final double lllllllllllllIIlIIlllllIIlllIIlI = 1.0 / Math.sqrt(lllllllllllllIIlIIlllllIIlIlllII[0] * lllllllllllllIIlIIlllllIIlIlllII[0] + lllllllllllllIIlIIlllllIIlIlllII[3] * lllllllllllllIIlIIlllllIIlIlllII[3]);
            final double lllllllllllllIIlIIlllllIIllIIlII = lllllllllllllIIlIIlllllIIlIlllII[0] * lllllllllllllIIlIIlllllIIlllIIlI;
            final double lllllllllllllIIlIIlllllIIllIIIII = lllllllllllllIIlIIlllllIIlIlllII[3] * lllllllllllllIIlIIlllllIIlllIIlI;
            lllllllllllllIIlIIlllllIIllIlIlI[0] = lllllllllllllIIlIIlllllIIllIIlII * lllllllllllllIIlIIlllllIIlIlllII[0] + lllllllllllllIIlIIlllllIIllIIIII * lllllllllllllIIlIIlllllIIlIlllII[3];
            lllllllllllllIIlIIlllllIIllIlIlI[1] = lllllllllllllIIlIIlllllIIllIIlII * lllllllllllllIIlIIlllllIIlIlllII[1] + lllllllllllllIIlIIlllllIIllIIIII * lllllllllllllIIlIIlllllIIlIlllII[4];
            lllllllllllllIIlIIlllllIIllIlIlI[2] = lllllllllllllIIlIIlllllIIllIIlII * lllllllllllllIIlIIlllllIIlIlllII[2] + lllllllllllllIIlIIlllllIIllIIIII * lllllllllllllIIlIIlllllIIlIlllII[5];
            lllllllllllllIIlIIlllllIIlIlllII[3] = -lllllllllllllIIlIIlllllIIllIIIII * lllllllllllllIIlIIlllllIIlIlllII[0] + lllllllllllllIIlIIlllllIIllIIlII * lllllllllllllIIlIIlllllIIlIlllII[3];
            lllllllllllllIIlIIlllllIIlIlllII[4] = -lllllllllllllIIlIIlllllIIllIIIII * lllllllllllllIIlIIlllllIIlIlllII[1] + lllllllllllllIIlIIlllllIIllIIlII * lllllllllllllIIlIIlllllIIlIlllII[4];
            lllllllllllllIIlIIlllllIIlIlllII[5] = -lllllllllllllIIlIIlllllIIllIIIII * lllllllllllllIIlIIlllllIIlIlllII[2] + lllllllllllllIIlIIlllllIIllIIlII * lllllllllllllIIlIIlllllIIlIlllII[5];
            lllllllllllllIIlIIlllllIIlIlllII[0] = lllllllllllllIIlIIlllllIIllIlIlI[0];
            lllllllllllllIIlIIlllllIIlIlllII[1] = lllllllllllllIIlIIlllllIIllIlIlI[1];
            lllllllllllllIIlIIlllllIIlIlllII[2] = lllllllllllllIIlIIlllllIIllIlIlI[2];
            lllllllllllllIIlIIlllllIIllIlllI[0] = lllllllllllllIIlIIlllllIIllIIlII;
            lllllllllllllIIlIIlllllIIllIlllI[1] = lllllllllllllIIlIIlllllIIllIIIII;
            lllllllllllllIIlIIlllllIIllIlllI[2] = 0.0;
            lllllllllllllIIlIIlllllIIllIlllI[3] = -lllllllllllllIIlIIlllllIIllIIIII;
            lllllllllllllIIlIIlllllIIllIlllI[4] = lllllllllllllIIlIIlllllIIllIIlII;
            lllllllllllllIIlIIlllllIIllIlllI[5] = 0.0;
            lllllllllllllIIlIIlllllIIllIlllI[7] = (lllllllllllllIIlIIlllllIIllIlllI[6] = 0.0);
            lllllllllllllIIlIIlllllIIllIlllI[8] = 1.0;
        }
        if (lllllllllllllIIlIIlllllIIlIlllII[6] * lllllllllllllIIlIIlllllIIlIlllII[6] >= 1.110223024E-16) {
            if (lllllllllllllIIlIIlllllIIlIlllII[0] * lllllllllllllIIlIIlllllIIlIlllII[0] < 1.110223024E-16) {
                lllllllllllllIIlIIlllllIIllIlIlI[0] = lllllllllllllIIlIIlllllIIlIlllII[0];
                lllllllllllllIIlIIlllllIIllIlIlI[1] = lllllllllllllIIlIIlllllIIlIlllII[1];
                lllllllllllllIIlIIlllllIIllIlIlI[2] = lllllllllllllIIlIIlllllIIlIlllII[2];
                lllllllllllllIIlIIlllllIIlIlllII[0] = lllllllllllllIIlIIlllllIIlIlllII[6];
                lllllllllllllIIlIIlllllIIlIlllII[1] = lllllllllllllIIlIIlllllIIlIlllII[7];
                lllllllllllllIIlIIlllllIIlIlllII[2] = lllllllllllllIIlIIlllllIIlIlllII[8];
                lllllllllllllIIlIIlllllIIlIlllII[6] = -lllllllllllllIIlIIlllllIIllIlIlI[0];
                lllllllllllllIIlIIlllllIIlIlllII[7] = -lllllllllllllIIlIIlllllIIllIlIlI[1];
                lllllllllllllIIlIIlllllIIlIlllII[8] = -lllllllllllllIIlIIlllllIIllIlIlI[2];
                lllllllllllllIIlIIlllllIIllIlIlI[0] = lllllllllllllIIlIIlllllIIllIlllI[0];
                lllllllllllllIIlIIlllllIIllIlIlI[1] = lllllllllllllIIlIIlllllIIllIlllI[1];
                lllllllllllllIIlIIlllllIIllIlIlI[2] = lllllllllllllIIlIIlllllIIllIlllI[2];
                lllllllllllllIIlIIlllllIIllIlllI[0] = lllllllllllllIIlIIlllllIIllIlllI[6];
                lllllllllllllIIlIIlllllIIllIlllI[1] = lllllllllllllIIlIIlllllIIllIlllI[7];
                lllllllllllllIIlIIlllllIIllIlllI[2] = lllllllllllllIIlIIlllllIIllIlllI[8];
                lllllllllllllIIlIIlllllIIllIlllI[6] = -lllllllllllllIIlIIlllllIIllIlIlI[0];
                lllllllllllllIIlIIlllllIIllIlllI[7] = -lllllllllllllIIlIIlllllIIllIlIlI[1];
                lllllllllllllIIlIIlllllIIllIlllI[8] = -lllllllllllllIIlIIlllllIIllIlIlI[2];
            }
            else {
                final double lllllllllllllIIlIIlllllIIlllIIIl = 1.0 / Math.sqrt(lllllllllllllIIlIIlllllIIlIlllII[0] * lllllllllllllIIlIIlllllIIlIlllII[0] + lllllllllllllIIlIIlllllIIlIlllII[6] * lllllllllllllIIlIIlllllIIlIlllII[6]);
                final double lllllllllllllIIlIIlllllIIllIIIll = lllllllllllllIIlIIlllllIIlIlllII[0] * lllllllllllllIIlIIlllllIIlllIIIl;
                final double lllllllllllllIIlIIlllllIIlIlllll = lllllllllllllIIlIIlllllIIlIlllII[6] * lllllllllllllIIlIIlllllIIlllIIIl;
                lllllllllllllIIlIIlllllIIllIlIlI[0] = lllllllllllllIIlIIlllllIIllIIIll * lllllllllllllIIlIIlllllIIlIlllII[0] + lllllllllllllIIlIIlllllIIlIlllll * lllllllllllllIIlIIlllllIIlIlllII[6];
                lllllllllllllIIlIIlllllIIllIlIlI[1] = lllllllllllllIIlIIlllllIIllIIIll * lllllllllllllIIlIIlllllIIlIlllII[1] + lllllllllllllIIlIIlllllIIlIlllll * lllllllllllllIIlIIlllllIIlIlllII[7];
                lllllllllllllIIlIIlllllIIllIlIlI[2] = lllllllllllllIIlIIlllllIIllIIIll * lllllllllllllIIlIIlllllIIlIlllII[2] + lllllllllllllIIlIIlllllIIlIlllll * lllllllllllllIIlIIlllllIIlIlllII[8];
                lllllllllllllIIlIIlllllIIlIlllII[6] = -lllllllllllllIIlIIlllllIIlIlllll * lllllllllllllIIlIIlllllIIlIlllII[0] + lllllllllllllIIlIIlllllIIllIIIll * lllllllllllllIIlIIlllllIIlIlllII[6];
                lllllllllllllIIlIIlllllIIlIlllII[7] = -lllllllllllllIIlIIlllllIIlIlllll * lllllllllllllIIlIIlllllIIlIlllII[1] + lllllllllllllIIlIIlllllIIllIIIll * lllllllllllllIIlIIlllllIIlIlllII[7];
                lllllllllllllIIlIIlllllIIlIlllII[8] = -lllllllllllllIIlIIlllllIIlIlllll * lllllllllllllIIlIIlllllIIlIlllII[2] + lllllllllllllIIlIIlllllIIllIIIll * lllllllllllllIIlIIlllllIIlIlllII[8];
                lllllllllllllIIlIIlllllIIlIlllII[0] = lllllllllllllIIlIIlllllIIllIlIlI[0];
                lllllllllllllIIlIIlllllIIlIlllII[1] = lllllllllllllIIlIIlllllIIllIlIlI[1];
                lllllllllllllIIlIIlllllIIlIlllII[2] = lllllllllllllIIlIIlllllIIllIlIlI[2];
                lllllllllllllIIlIIlllllIIllIlIlI[0] = lllllllllllllIIlIIlllllIIllIIIll * lllllllllllllIIlIIlllllIIllIlllI[0];
                lllllllllllllIIlIIlllllIIllIlIlI[1] = lllllllllllllIIlIIlllllIIllIIIll * lllllllllllllIIlIIlllllIIllIlllI[1];
                lllllllllllllIIlIIlllllIIllIlllI[2] = lllllllllllllIIlIIlllllIIlIlllll;
                lllllllllllllIIlIIlllllIIllIlIlI[6] = -lllllllllllllIIlIIlllllIIllIlllI[0] * lllllllllllllIIlIIlllllIIlIlllll;
                lllllllllllllIIlIIlllllIIllIlIlI[7] = -lllllllllllllIIlIIlllllIIllIlllI[1] * lllllllllllllIIlIIlllllIIlIlllll;
                lllllllllllllIIlIIlllllIIllIlllI[8] = lllllllllllllIIlIIlllllIIllIIIll;
                lllllllllllllIIlIIlllllIIllIlllI[0] = lllllllllllllIIlIIlllllIIllIlIlI[0];
                lllllllllllllIIlIIlllllIIllIlllI[1] = lllllllllllllIIlIIlllllIIllIlIlI[1];
                lllllllllllllIIlIIlllllIIllIlllI[6] = lllllllllllllIIlIIlllllIIllIlIlI[6];
                lllllllllllllIIlIIlllllIIllIlllI[7] = lllllllllllllIIlIIlllllIIllIlIlI[7];
            }
        }
        if (lllllllllllllIIlIIlllllIIlIlllII[2] * lllllllllllllIIlIIlllllIIlIlllII[2] < 1.110223024E-16) {
            lllllllllllllIIlIIlllllIIllIllIl[0] = 1.0;
            lllllllllllllIIlIIlllllIIllIllIl[1] = 0.0;
            lllllllllllllIIlIIlllllIIllIllIl[3] = (lllllllllllllIIlIIlllllIIllIllIl[2] = 0.0);
            lllllllllllllIIlIIlllllIIllIllIl[4] = 1.0;
            lllllllllllllIIlIIlllllIIllIllIl[5] = 0.0;
            lllllllllllllIIlIIlllllIIllIllIl[7] = (lllllllllllllIIlIIlllllIIllIllIl[6] = 0.0);
            lllllllllllllIIlIIlllllIIllIllIl[8] = 1.0;
        }
        else if (lllllllllllllIIlIIlllllIIlIlllII[1] * lllllllllllllIIlIIlllllIIlIlllII[1] < 1.110223024E-16) {
            lllllllllllllIIlIIlllllIIllIlIlI[2] = lllllllllllllIIlIIlllllIIlIlllII[2];
            lllllllllllllIIlIIlllllIIllIlIlI[5] = lllllllllllllIIlIIlllllIIlIlllII[5];
            lllllllllllllIIlIIlllllIIllIlIlI[8] = lllllllllllllIIlIIlllllIIlIlllII[8];
            lllllllllllllIIlIIlllllIIlIlllII[2] = -lllllllllllllIIlIIlllllIIlIlllII[1];
            lllllllllllllIIlIIlllllIIlIlllII[5] = -lllllllllllllIIlIIlllllIIlIlllII[4];
            lllllllllllllIIlIIlllllIIlIlllII[8] = -lllllllllllllIIlIIlllllIIlIlllII[7];
            lllllllllllllIIlIIlllllIIlIlllII[1] = lllllllllllllIIlIIlllllIIllIlIlI[2];
            lllllllllllllIIlIIlllllIIlIlllII[4] = lllllllllllllIIlIIlllllIIllIlIlI[5];
            lllllllllllllIIlIIlllllIIlIlllII[7] = lllllllllllllIIlIIlllllIIllIlIlI[8];
            lllllllllllllIIlIIlllllIIllIllIl[0] = 1.0;
            lllllllllllllIIlIIlllllIIllIllIl[2] = (lllllllllllllIIlIIlllllIIllIllIl[1] = 0.0);
            lllllllllllllIIlIIlllllIIllIllIl[4] = (lllllllllllllIIlIIlllllIIllIllIl[3] = 0.0);
            lllllllllllllIIlIIlllllIIllIllIl[5] = -1.0;
            lllllllllllllIIlIIlllllIIllIllIl[6] = 0.0;
            lllllllllllllIIlIIlllllIIllIllIl[7] = 1.0;
            lllllllllllllIIlIIlllllIIllIllIl[8] = 0.0;
        }
        else {
            final double lllllllllllllIIlIIlllllIIlllIIII = 1.0 / Math.sqrt(lllllllllllllIIlIIlllllIIlIlllII[1] * lllllllllllllIIlIIlllllIIlIlllII[1] + lllllllllllllIIlIIlllllIIlIlllII[2] * lllllllllllllIIlIIlllllIIlIlllII[2]);
            final double lllllllllllllIIlIIlllllIIllIIIlI = lllllllllllllIIlIIlllllIIlIlllII[1] * lllllllllllllIIlIIlllllIIlllIIII;
            final double lllllllllllllIIlIIlllllIIlIllllI = lllllllllllllIIlIIlllllIIlIlllII[2] * lllllllllllllIIlIIlllllIIlllIIII;
            lllllllllllllIIlIIlllllIIllIlIlI[1] = lllllllllllllIIlIIlllllIIllIIIlI * lllllllllllllIIlIIlllllIIlIlllII[1] + lllllllllllllIIlIIlllllIIlIllllI * lllllllllllllIIlIIlllllIIlIlllII[2];
            lllllllllllllIIlIIlllllIIlIlllII[2] = -lllllllllllllIIlIIlllllIIlIllllI * lllllllllllllIIlIIlllllIIlIlllII[1] + lllllllllllllIIlIIlllllIIllIIIlI * lllllllllllllIIlIIlllllIIlIlllII[2];
            lllllllllllllIIlIIlllllIIlIlllII[1] = lllllllllllllIIlIIlllllIIllIlIlI[1];
            lllllllllllllIIlIIlllllIIllIlIlI[4] = lllllllllllllIIlIIlllllIIllIIIlI * lllllllllllllIIlIIlllllIIlIlllII[4] + lllllllllllllIIlIIlllllIIlIllllI * lllllllllllllIIlIIlllllIIlIlllII[5];
            lllllllllllllIIlIIlllllIIlIlllII[5] = -lllllllllllllIIlIIlllllIIlIllllI * lllllllllllllIIlIIlllllIIlIlllII[4] + lllllllllllllIIlIIlllllIIllIIIlI * lllllllllllllIIlIIlllllIIlIlllII[5];
            lllllllllllllIIlIIlllllIIlIlllII[4] = lllllllllllllIIlIIlllllIIllIlIlI[4];
            lllllllllllllIIlIIlllllIIllIlIlI[7] = lllllllllllllIIlIIlllllIIllIIIlI * lllllllllllllIIlIIlllllIIlIlllII[7] + lllllllllllllIIlIIlllllIIlIllllI * lllllllllllllIIlIIlllllIIlIlllII[8];
            lllllllllllllIIlIIlllllIIlIlllII[8] = -lllllllllllllIIlIIlllllIIlIllllI * lllllllllllllIIlIIlllllIIlIlllII[7] + lllllllllllllIIlIIlllllIIllIIIlI * lllllllllllllIIlIIlllllIIlIlllII[8];
            lllllllllllllIIlIIlllllIIlIlllII[7] = lllllllllllllIIlIIlllllIIllIlIlI[7];
            lllllllllllllIIlIIlllllIIllIllIl[0] = 1.0;
            lllllllllllllIIlIIlllllIIllIllIl[1] = 0.0;
            lllllllllllllIIlIIlllllIIllIllIl[3] = (lllllllllllllIIlIIlllllIIllIllIl[2] = 0.0);
            lllllllllllllIIlIIlllllIIllIllIl[4] = lllllllllllllIIlIIlllllIIllIIIlI;
            lllllllllllllIIlIIlllllIIllIllIl[5] = -lllllllllllllIIlIIlllllIIlIllllI;
            lllllllllllllIIlIIlllllIIllIllIl[6] = 0.0;
            lllllllllllllIIlIIlllllIIllIllIl[7] = lllllllllllllIIlIIlllllIIlIllllI;
            lllllllllllllIIlIIlllllIIllIllIl[8] = lllllllllllllIIlIIlllllIIllIIIlI;
        }
        if (lllllllllllllIIlIIlllllIIlIlllII[7] * lllllllllllllIIlIIlllllIIlIlllII[7] >= 1.110223024E-16) {
            if (lllllllllllllIIlIIlllllIIlIlllII[4] * lllllllllllllIIlIIlllllIIlIlllII[4] < 1.110223024E-16) {
                lllllllllllllIIlIIlllllIIllIlIlI[3] = lllllllllllllIIlIIlllllIIlIlllII[3];
                lllllllllllllIIlIIlllllIIllIlIlI[4] = lllllllllllllIIlIIlllllIIlIlllII[4];
                lllllllllllllIIlIIlllllIIllIlIlI[5] = lllllllllllllIIlIIlllllIIlIlllII[5];
                lllllllllllllIIlIIlllllIIlIlllII[3] = lllllllllllllIIlIIlllllIIlIlllII[6];
                lllllllllllllIIlIIlllllIIlIlllII[4] = lllllllllllllIIlIIlllllIIlIlllII[7];
                lllllllllllllIIlIIlllllIIlIlllII[5] = lllllllllllllIIlIIlllllIIlIlllII[8];
                lllllllllllllIIlIIlllllIIlIlllII[6] = -lllllllllllllIIlIIlllllIIllIlIlI[3];
                lllllllllllllIIlIIlllllIIlIlllII[7] = -lllllllllllllIIlIIlllllIIllIlIlI[4];
                lllllllllllllIIlIIlllllIIlIlllII[8] = -lllllllllllllIIlIIlllllIIllIlIlI[5];
                lllllllllllllIIlIIlllllIIllIlIlI[3] = lllllllllllllIIlIIlllllIIllIlllI[3];
                lllllllllllllIIlIIlllllIIllIlIlI[4] = lllllllllllllIIlIIlllllIIllIlllI[4];
                lllllllllllllIIlIIlllllIIllIlIlI[5] = lllllllllllllIIlIIlllllIIllIlllI[5];
                lllllllllllllIIlIIlllllIIllIlllI[3] = lllllllllllllIIlIIlllllIIllIlllI[6];
                lllllllllllllIIlIIlllllIIllIlllI[4] = lllllllllllllIIlIIlllllIIllIlllI[7];
                lllllllllllllIIlIIlllllIIllIlllI[5] = lllllllllllllIIlIIlllllIIllIlllI[8];
                lllllllllllllIIlIIlllllIIllIlllI[6] = -lllllllllllllIIlIIlllllIIllIlIlI[3];
                lllllllllllllIIlIIlllllIIllIlllI[7] = -lllllllllllllIIlIIlllllIIllIlIlI[4];
                lllllllllllllIIlIIlllllIIllIlllI[8] = -lllllllllllllIIlIIlllllIIllIlIlI[5];
            }
            else {
                final double lllllllllllllIIlIIlllllIIllIllll = 1.0 / Math.sqrt(lllllllllllllIIlIIlllllIIlIlllII[4] * lllllllllllllIIlIIlllllIIlIlllII[4] + lllllllllllllIIlIIlllllIIlIlllII[7] * lllllllllllllIIlIIlllllIIlIlllII[7]);
                final double lllllllllllllIIlIIlllllIIllIIIIl = lllllllllllllIIlIIlllllIIlIlllII[4] * lllllllllllllIIlIIlllllIIllIllll;
                final double lllllllllllllIIlIIlllllIIlIlllIl = lllllllllllllIIlIIlllllIIlIlllII[7] * lllllllllllllIIlIIlllllIIllIllll;
                lllllllllllllIIlIIlllllIIllIlIlI[3] = lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIlIlllII[3] + lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIlIlllII[6];
                lllllllllllllIIlIIlllllIIlIlllII[6] = -lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIlIlllII[3] + lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIlIlllII[6];
                lllllllllllllIIlIIlllllIIlIlllII[3] = lllllllllllllIIlIIlllllIIllIlIlI[3];
                lllllllllllllIIlIIlllllIIllIlIlI[4] = lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIlIlllII[4] + lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIlIlllII[7];
                lllllllllllllIIlIIlllllIIlIlllII[7] = -lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIlIlllII[4] + lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIlIlllII[7];
                lllllllllllllIIlIIlllllIIlIlllII[4] = lllllllllllllIIlIIlllllIIllIlIlI[4];
                lllllllllllllIIlIIlllllIIllIlIlI[5] = lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIlIlllII[5] + lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIlIlllII[8];
                lllllllllllllIIlIIlllllIIlIlllII[8] = -lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIlIlllII[5] + lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIlIlllII[8];
                lllllllllllllIIlIIlllllIIlIlllII[5] = lllllllllllllIIlIIlllllIIllIlIlI[5];
                lllllllllllllIIlIIlllllIIllIlIlI[3] = lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIllIlllI[3] + lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIllIlllI[6];
                lllllllllllllIIlIIlllllIIllIlllI[6] = -lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIllIlllI[3] + lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIllIlllI[6];
                lllllllllllllIIlIIlllllIIllIlllI[3] = lllllllllllllIIlIIlllllIIllIlIlI[3];
                lllllllllllllIIlIIlllllIIllIlIlI[4] = lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIllIlllI[4] + lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIllIlllI[7];
                lllllllllllllIIlIIlllllIIllIlllI[7] = -lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIllIlllI[4] + lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIllIlllI[7];
                lllllllllllllIIlIIlllllIIllIlllI[4] = lllllllllllllIIlIIlllllIIllIlIlI[4];
                lllllllllllllIIlIIlllllIIllIlIlI[5] = lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIllIlllI[5] + lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIllIlllI[8];
                lllllllllllllIIlIIlllllIIllIlllI[8] = -lllllllllllllIIlIIlllllIIlIlllIl * lllllllllllllIIlIIlllllIIllIlllI[5] + lllllllllllllIIlIIlllllIIllIIIIl * lllllllllllllIIlIIlllllIIllIlllI[8];
                lllllllllllllIIlIIlllllIIllIlllI[5] = lllllllllllllIIlIIlllllIIllIlIlI[5];
            }
        }
        lllllllllllllIIlIIlllllIIllIlIIl[0] = lllllllllllllIIlIIlllllIIlIlllII[0];
        lllllllllllllIIlIIlllllIIllIlIIl[1] = lllllllllllllIIlIIlllllIIlIlllII[4];
        lllllllllllllIIlIIlllllIIllIlIIl[2] = lllllllllllllIIlIIlllllIIlIlllII[8];
        lllllllllllllIIlIIlllllIIllIIlll[0] = lllllllllllllIIlIIlllllIIlIlllII[1];
        lllllllllllllIIlIIlllllIIllIIlll[1] = lllllllllllllIIlIIlllllIIlIlllII[5];
        if (lllllllllllllIIlIIlllllIIllIIlll[0] * lllllllllllllIIlIIlllllIIllIIlll[0] >= 1.110223024E-16 || lllllllllllllIIlIIlllllIIllIIlll[1] * lllllllllllllIIlIIlllllIIllIIlll[1] >= 1.110223024E-16) {
            compute_qr(lllllllllllllIIlIIlllllIIllIlIIl, lllllllllllllIIlIIlllllIIllIIlll, lllllllllllllIIlIIlllllIIllIlllI, lllllllllllllIIlIIlllllIIllIllIl);
        }
        lllllllllllllIIlIIlllllIIllIIllI[0] = lllllllllllllIIlIIlllllIIllIlIIl[0];
        lllllllllllllIIlIIlllllIIllIIllI[1] = lllllllllllllIIlIIlllllIIllIlIIl[1];
        lllllllllllllIIlIIlllllIIllIIllI[2] = lllllllllllllIIlIIlllllIIllIlIIl[2];
        if (almostEqual(Math.abs(lllllllllllllIIlIIlllllIIllIIllI[0]), 1.0) && almostEqual(Math.abs(lllllllllllllIIlIIlllllIIllIIllI[1]), 1.0) && almostEqual(Math.abs(lllllllllllllIIlIIlllllIIllIIllI[2]), 1.0)) {
            for (int lllllllllllllIIlIIlllllIIlllIIll = 0; lllllllllllllIIlIIlllllIIlllIIll < 3; ++lllllllllllllIIlIIlllllIIlllIIll) {
                if (lllllllllllllIIlIIlllllIIllIIllI[lllllllllllllIIlIIlllllIIlllIIll] < 0.0) {
                    ++lllllllllllllIIlIIlllllIIllIIlIl;
                }
            }
            if (lllllllllllllIIlIIlllllIIllIIlIl == 0 || lllllllllllllIIlIIlllllIIllIIlIl == 2) {
                final int n = 0;
                final int n2 = 1;
                final int n3 = 2;
                final double n4 = 1.0;
                lllllllllllllIIlIIlllllIIlllIlIl[n3] = n4;
                lllllllllllllIIlIIlllllIIlllIlIl[n] = (lllllllllllllIIlIIlllllIIlllIlIl[n2] = n4);
                for (int lllllllllllllIIlIIlllllIIlllIIll = 0; lllllllllllllIIlIIlllllIIlllIIll < 9; ++lllllllllllllIIlIIlllllIIlllIIll) {
                    lllllllllllllIIlIIlllllIIlIllIII[lllllllllllllIIlIIlllllIIlllIIll] = lllllllllllllIIlIIlllllIIllIlIII[lllllllllllllIIlIIlllllIIlllIIll];
                }
                return;
            }
        }
        transpose_mat(lllllllllllllIIlIIlllllIIllIlllI, lllllllllllllIIlIIlllllIIllIllII);
        transpose_mat(lllllllllllllIIlIIlllllIIllIllIl, lllllllllllllIIlIIlllllIIllIlIll);
        svdReorder(lllllllllllllIIlIIlllllIIlIlllII, lllllllllllllIIlIIlllllIIllIllII, lllllllllllllIIlIIlllllIIllIlIll, lllllllllllllIIlIIlllllIIllIIllI, lllllllllllllIIlIIlllllIIlIllIII, lllllllllllllIIlIIlllllIIlllIlIl);
    }
    
    static double max(final double lllllllllllllIIlIIllllIllIllllll, final double lllllllllllllIIlIIllllIllIlllllI) {
        if (lllllllllllllIIlIIllllIllIllllll > lllllllllllllIIlIIllllIllIlllllI) {
            return lllllllllllllIIlIIllllIllIllllll;
        }
        return lllllllllllllIIlIIllllIllIlllllI;
    }
    
    public final void setM11(final double lllllllllllllIIlIIllllIIIlIlIIll) {
        this.m11 = lllllllllllllIIlIIllllIIIlIlIIll;
    }
    
    public final void invert() {
        this.invertGeneral(this);
    }
    
    static double max3(final double[] lllllllllllllIIlIIllllIIlIlIIIlI) {
        if (lllllllllllllIIlIIllllIIlIlIIIlI[0] > lllllllllllllIIlIIllllIIlIlIIIlI[1]) {
            if (lllllllllllllIIlIIllllIIlIlIIIlI[0] > lllllllllllllIIlIIllllIIlIlIIIlI[2]) {
                return lllllllllllllIIlIIllllIIlIlIIIlI[0];
            }
            return lllllllllllllIIlIIllllIIlIlIIIlI[2];
        }
        else {
            if (lllllllllllllIIlIIllllIIlIlIIIlI[1] > lllllllllllllIIlIIllllIIlIlIIIlI[2]) {
                return lllllllllllllIIlIIllllIIlIlIIIlI[1];
            }
            return lllllllllllllIIlIIllllIIlIlIIIlI[2];
        }
    }
    
    public Matrix3d(final double[] lllllllllllllIIlIlIIIIIllllIIIIl) {
        this.m00 = lllllllllllllIIlIlIIIIIllllIIIIl[0];
        this.m01 = lllllllllllllIIlIlIIIIIllllIIIIl[1];
        this.m02 = lllllllllllllIIlIlIIIIIllllIIIIl[2];
        this.m10 = lllllllllllllIIlIlIIIIIllllIIIIl[3];
        this.m11 = lllllllllllllIIlIlIIIIIllllIIIIl[4];
        this.m12 = lllllllllllllIIlIlIIIIIllllIIIIl[5];
        this.m20 = lllllllllllllIIlIlIIIIIllllIIIIl[6];
        this.m21 = lllllllllllllIIlIlIIIIIllllIIIIl[7];
        this.m22 = lllllllllllllIIlIlIIIIIllllIIIIl[8];
    }
    
    public final void normalize() {
        final double[] lllllllllllllIIlIIllllllIIIIllII = new double[9];
        final double[] lllllllllllllIIlIIllllllIIIIlIll = new double[3];
        this.getScaleRotate(lllllllllllllIIlIIllllllIIIIlIll, lllllllllllllIIlIIllllllIIIIllII);
        this.m00 = lllllllllllllIIlIIllllllIIIIllII[0];
        this.m01 = lllllllllllllIIlIIllllllIIIIllII[1];
        this.m02 = lllllllllllllIIlIIllllllIIIIllII[2];
        this.m10 = lllllllllllllIIlIIllllllIIIIllII[3];
        this.m11 = lllllllllllllIIlIIllllllIIIIllII[4];
        this.m12 = lllllllllllllIIlIIllllllIIIIllII[5];
        this.m20 = lllllllllllllIIlIIllllllIIIIllII[6];
        this.m21 = lllllllllllllIIlIIllllllIIIIllII[7];
        this.m22 = lllllllllllllIIlIIllllllIIIIllII[8];
    }
    
    static void transpose_mat(final double[] lllllllllllllIIlIIllllIIlIlIIlIl, final double[] lllllllllllllIIlIIllllIIlIlIIlII) {
        lllllllllllllIIlIIllllIIlIlIIlII[0] = lllllllllllllIIlIIllllIIlIlIIlIl[0];
        lllllllllllllIIlIIllllIIlIlIIlII[1] = lllllllllllllIIlIIllllIIlIlIIlIl[3];
        lllllllllllllIIlIIllllIIlIlIIlII[2] = lllllllllllllIIlIIllllIIlIlIIlIl[6];
        lllllllllllllIIlIIllllIIlIlIIlII[3] = lllllllllllllIIlIIllllIIlIlIIlIl[1];
        lllllllllllllIIlIIllllIIlIlIIlII[4] = lllllllllllllIIlIIllllIIlIlIIlIl[4];
        lllllllllllllIIlIIllllIIlIlIIlII[5] = lllllllllllllIIlIIllllIIlIlIIlIl[7];
        lllllllllllllIIlIIllllIIlIlIIlII[6] = lllllllllllllIIlIIllllIIlIlIIlIl[2];
        lllllllllllllIIlIIllllIIlIlIIlII[7] = lllllllllllllIIlIIllllIIlIlIIlIl[5];
        lllllllllllllIIlIIllllIIlIlIIlII[8] = lllllllllllllIIlIIllllIIlIlIIlIl[8];
    }
    
    public final void mulTransposeRight(final Matrix3d lllllllllllllIIlIIllllllIlIIlIll, final Matrix3d lllllllllllllIIlIIllllllIIllllIl) {
        if (this != lllllllllllllIIlIIllllllIlIIlIll && this != lllllllllllllIIlIIllllllIIllllIl) {
            this.m00 = lllllllllllllIIlIIllllllIlIIlIll.m00 * lllllllllllllIIlIIllllllIIllllIl.m00 + lllllllllllllIIlIIllllllIlIIlIll.m01 * lllllllllllllIIlIIllllllIIllllIl.m01 + lllllllllllllIIlIIllllllIlIIlIll.m02 * lllllllllllllIIlIIllllllIIllllIl.m02;
            this.m01 = lllllllllllllIIlIIllllllIlIIlIll.m00 * lllllllllllllIIlIIllllllIIllllIl.m10 + lllllllllllllIIlIIllllllIlIIlIll.m01 * lllllllllllllIIlIIllllllIIllllIl.m11 + lllllllllllllIIlIIllllllIlIIlIll.m02 * lllllllllllllIIlIIllllllIIllllIl.m12;
            this.m02 = lllllllllllllIIlIIllllllIlIIlIll.m00 * lllllllllllllIIlIIllllllIIllllIl.m20 + lllllllllllllIIlIIllllllIlIIlIll.m01 * lllllllllllllIIlIIllllllIIllllIl.m21 + lllllllllllllIIlIIllllllIlIIlIll.m02 * lllllllllllllIIlIIllllllIIllllIl.m22;
            this.m10 = lllllllllllllIIlIIllllllIlIIlIll.m10 * lllllllllllllIIlIIllllllIIllllIl.m00 + lllllllllllllIIlIIllllllIlIIlIll.m11 * lllllllllllllIIlIIllllllIIllllIl.m01 + lllllllllllllIIlIIllllllIlIIlIll.m12 * lllllllllllllIIlIIllllllIIllllIl.m02;
            this.m11 = lllllllllllllIIlIIllllllIlIIlIll.m10 * lllllllllllllIIlIIllllllIIllllIl.m10 + lllllllllllllIIlIIllllllIlIIlIll.m11 * lllllllllllllIIlIIllllllIIllllIl.m11 + lllllllllllllIIlIIllllllIlIIlIll.m12 * lllllllllllllIIlIIllllllIIllllIl.m12;
            this.m12 = lllllllllllllIIlIIllllllIlIIlIll.m10 * lllllllllllllIIlIIllllllIIllllIl.m20 + lllllllllllllIIlIIllllllIlIIlIll.m11 * lllllllllllllIIlIIllllllIIllllIl.m21 + lllllllllllllIIlIIllllllIlIIlIll.m12 * lllllllllllllIIlIIllllllIIllllIl.m22;
            this.m20 = lllllllllllllIIlIIllllllIlIIlIll.m20 * lllllllllllllIIlIIllllllIIllllIl.m00 + lllllllllllllIIlIIllllllIlIIlIll.m21 * lllllllllllllIIlIIllllllIIllllIl.m01 + lllllllllllllIIlIIllllllIlIIlIll.m22 * lllllllllllllIIlIIllllllIIllllIl.m02;
            this.m21 = lllllllllllllIIlIIllllllIlIIlIll.m20 * lllllllllllllIIlIIllllllIIllllIl.m10 + lllllllllllllIIlIIllllllIlIIlIll.m21 * lllllllllllllIIlIIllllllIIllllIl.m11 + lllllllllllllIIlIIllllllIlIIlIll.m22 * lllllllllllllIIlIIllllllIIllllIl.m12;
            this.m22 = lllllllllllllIIlIIllllllIlIIlIll.m20 * lllllllllllllIIlIIllllllIIllllIl.m20 + lllllllllllllIIlIIllllllIlIIlIll.m21 * lllllllllllllIIlIIllllllIIllllIl.m21 + lllllllllllllIIlIIllllllIlIIlIll.m22 * lllllllllllllIIlIIllllllIIllllIl.m22;
        }
        else {
            final double lllllllllllllIIlIIllllllIlIIlIIl = lllllllllllllIIlIIllllllIlIIlIll.m00 * lllllllllllllIIlIIllllllIIllllIl.m00 + lllllllllllllIIlIIllllllIlIIlIll.m01 * lllllllllllllIIlIIllllllIIllllIl.m01 + lllllllllllllIIlIIllllllIlIIlIll.m02 * lllllllllllllIIlIIllllllIIllllIl.m02;
            final double lllllllllllllIIlIIllllllIlIIlIII = lllllllllllllIIlIIllllllIlIIlIll.m00 * lllllllllllllIIlIIllllllIIllllIl.m10 + lllllllllllllIIlIIllllllIlIIlIll.m01 * lllllllllllllIIlIIllllllIIllllIl.m11 + lllllllllllllIIlIIllllllIlIIlIll.m02 * lllllllllllllIIlIIllllllIIllllIl.m12;
            final double lllllllllllllIIlIIllllllIlIIIlll = lllllllllllllIIlIIllllllIlIIlIll.m00 * lllllllllllllIIlIIllllllIIllllIl.m20 + lllllllllllllIIlIIllllllIlIIlIll.m01 * lllllllllllllIIlIIllllllIIllllIl.m21 + lllllllllllllIIlIIllllllIlIIlIll.m02 * lllllllllllllIIlIIllllllIIllllIl.m22;
            final double lllllllllllllIIlIIllllllIlIIIllI = lllllllllllllIIlIIllllllIlIIlIll.m10 * lllllllllllllIIlIIllllllIIllllIl.m00 + lllllllllllllIIlIIllllllIlIIlIll.m11 * lllllllllllllIIlIIllllllIIllllIl.m01 + lllllllllllllIIlIIllllllIlIIlIll.m12 * lllllllllllllIIlIIllllllIIllllIl.m02;
            final double lllllllllllllIIlIIllllllIlIIIlIl = lllllllllllllIIlIIllllllIlIIlIll.m10 * lllllllllllllIIlIIllllllIIllllIl.m10 + lllllllllllllIIlIIllllllIlIIlIll.m11 * lllllllllllllIIlIIllllllIIllllIl.m11 + lllllllllllllIIlIIllllllIlIIlIll.m12 * lllllllllllllIIlIIllllllIIllllIl.m12;
            final double lllllllllllllIIlIIllllllIlIIIlII = lllllllllllllIIlIIllllllIlIIlIll.m10 * lllllllllllllIIlIIllllllIIllllIl.m20 + lllllllllllllIIlIIllllllIlIIlIll.m11 * lllllllllllllIIlIIllllllIIllllIl.m21 + lllllllllllllIIlIIllllllIlIIlIll.m12 * lllllllllllllIIlIIllllllIIllllIl.m22;
            final double lllllllllllllIIlIIllllllIlIIIIll = lllllllllllllIIlIIllllllIlIIlIll.m20 * lllllllllllllIIlIIllllllIIllllIl.m00 + lllllllllllllIIlIIllllllIlIIlIll.m21 * lllllllllllllIIlIIllllllIIllllIl.m01 + lllllllllllllIIlIIllllllIlIIlIll.m22 * lllllllllllllIIlIIllllllIIllllIl.m02;
            final double lllllllllllllIIlIIllllllIlIIIIlI = lllllllllllllIIlIIllllllIlIIlIll.m20 * lllllllllllllIIlIIllllllIIllllIl.m10 + lllllllllllllIIlIIllllllIlIIlIll.m21 * lllllllllllllIIlIIllllllIIllllIl.m11 + lllllllllllllIIlIIllllllIlIIlIll.m22 * lllllllllllllIIlIIllllllIIllllIl.m12;
            final double lllllllllllllIIlIIllllllIlIIIIIl = lllllllllllllIIlIIllllllIlIIlIll.m20 * lllllllllllllIIlIIllllllIIllllIl.m20 + lllllllllllllIIlIIllllllIlIIlIll.m21 * lllllllllllllIIlIIllllllIIllllIl.m21 + lllllllllllllIIlIIllllllIlIIlIll.m22 * lllllllllllllIIlIIllllllIIllllIl.m22;
            this.m00 = lllllllllllllIIlIIllllllIlIIlIIl;
            this.m01 = lllllllllllllIIlIIllllllIlIIlIII;
            this.m02 = lllllllllllllIIlIIllllllIlIIIlll;
            this.m10 = lllllllllllllIIlIIllllllIlIIIllI;
            this.m11 = lllllllllllllIIlIIllllllIlIIIlIl;
            this.m12 = lllllllllllllIIlIIllllllIlIIIlII;
            this.m20 = lllllllllllllIIlIIllllllIlIIIIll;
            this.m21 = lllllllllllllIIlIIllllllIlIIIIlI;
            this.m22 = lllllllllllllIIlIIllllllIlIIIIIl;
        }
    }
    
    public final void transform(final Tuple3d lllllllllllllIIlIIlllllIlIlIIIlI, final Tuple3d lllllllllllllIIlIIlllllIlIlIIIIl) {
        final double lllllllllllllIIlIIlllllIlIlIIIII = this.m00 * lllllllllllllIIlIIlllllIlIlIIIlI.x + this.m01 * lllllllllllllIIlIIlllllIlIlIIIlI.y + this.m02 * lllllllllllllIIlIIlllllIlIlIIIlI.z;
        final double lllllllllllllIIlIIlllllIlIIlllll = this.m10 * lllllllllllllIIlIIlllllIlIlIIIlI.x + this.m11 * lllllllllllllIIlIIlllllIlIlIIIlI.y + this.m12 * lllllllllllllIIlIIlllllIlIlIIIlI.z;
        lllllllllllllIIlIIlllllIlIlIIIIl.z = this.m20 * lllllllllllllIIlIIlllllIlIlIIIlI.x + this.m21 * lllllllllllllIIlIIlllllIlIlIIIlI.y + this.m22 * lllllllllllllIIlIIlllllIlIlIIIlI.z;
        lllllllllllllIIlIIlllllIlIlIIIIl.x = lllllllllllllIIlIIlllllIlIlIIIII;
        lllllllllllllIIlIIlllllIlIlIIIIl.y = lllllllllllllIIlIIlllllIlIIlllll;
    }
    
    public final void normalize(final Matrix3d lllllllllllllIIlIIlllllIllllllII) {
        final double[] lllllllllllllIIlIIllllllIIIIIIII = new double[9];
        final double[] lllllllllllllIIlIIlllllIllllllll = new double[9];
        final double[] lllllllllllllIIlIIlllllIlllllllI = new double[3];
        lllllllllllllIIlIIllllllIIIIIIII[0] = lllllllllllllIIlIIlllllIllllllII.m00;
        lllllllllllllIIlIIllllllIIIIIIII[1] = lllllllllllllIIlIIlllllIllllllII.m01;
        lllllllllllllIIlIIllllllIIIIIIII[2] = lllllllllllllIIlIIlllllIllllllII.m02;
        lllllllllllllIIlIIllllllIIIIIIII[3] = lllllllllllllIIlIIlllllIllllllII.m10;
        lllllllllllllIIlIIllllllIIIIIIII[4] = lllllllllllllIIlIIlllllIllllllII.m11;
        lllllllllllllIIlIIllllllIIIIIIII[5] = lllllllllllllIIlIIlllllIllllllII.m12;
        lllllllllllllIIlIIllllllIIIIIIII[6] = lllllllllllllIIlIIlllllIllllllII.m20;
        lllllllllllllIIlIIllllllIIIIIIII[7] = lllllllllllllIIlIIlllllIllllllII.m21;
        lllllllllllllIIlIIllllllIIIIIIII[8] = lllllllllllllIIlIIlllllIllllllII.m22;
        compute_svd(lllllllllllllIIlIIllllllIIIIIIII, lllllllllllllIIlIIlllllIlllllllI, lllllllllllllIIlIIlllllIllllllll);
        this.m00 = lllllllllllllIIlIIlllllIllllllll[0];
        this.m01 = lllllllllllllIIlIIlllllIllllllll[1];
        this.m02 = lllllllllllllIIlIIlllllIllllllll[2];
        this.m10 = lllllllllllllIIlIIlllllIllllllll[3];
        this.m11 = lllllllllllllIIlIIlllllIllllllll[4];
        this.m12 = lllllllllllllIIlIIlllllIllllllll[5];
        this.m20 = lllllllllllllIIlIIlllllIllllllll[6];
        this.m21 = lllllllllllllIIlIIlllllIllllllll[7];
        this.m22 = lllllllllllllIIlIIlllllIllllllll[8];
    }
    
    public final void normalizeCP() {
        double lllllllllllllIIlIIlllllIllllIlIl = 1.0 / Math.sqrt(this.m00 * this.m00 + this.m10 * this.m10 + this.m20 * this.m20);
        this.m00 *= lllllllllllllIIlIIlllllIllllIlIl;
        this.m10 *= lllllllllllllIIlIIlllllIllllIlIl;
        this.m20 *= lllllllllllllIIlIIlllllIllllIlIl;
        lllllllllllllIIlIIlllllIllllIlIl = 1.0 / Math.sqrt(this.m01 * this.m01 + this.m11 * this.m11 + this.m21 * this.m21);
        this.m01 *= lllllllllllllIIlIIlllllIllllIlIl;
        this.m11 *= lllllllllllllIIlIIlllllIllllIlIl;
        this.m21 *= lllllllllllllIIlIIlllllIllllIlIl;
        this.m02 = this.m10 * this.m21 - this.m11 * this.m20;
        this.m12 = this.m01 * this.m20 - this.m00 * this.m21;
        this.m22 = this.m00 * this.m11 - this.m01 * this.m10;
    }
    
    public final void setColumn(final int lllllllllllllIIlIlIIIIIlIlIllIlI, final double lllllllllllllIIlIlIIIIIlIlIllllI, final double lllllllllllllIIlIlIIIIIlIlIllIII, final double lllllllllllllIIlIlIIIIIlIlIlIlll) {
        switch (lllllllllllllIIlIlIIIIIlIlIllIlI) {
            case 0: {
                this.m00 = lllllllllllllIIlIlIIIIIlIlIllllI;
                this.m10 = lllllllllllllIIlIlIIIIIlIlIllIII;
                this.m20 = lllllllllllllIIlIlIIIIIlIlIlIlll;
                break;
            }
            case 1: {
                this.m01 = lllllllllllllIIlIlIIIIIlIlIllllI;
                this.m11 = lllllllllllllIIlIlIIIIIlIlIllIII;
                this.m21 = lllllllllllllIIlIlIIIIIlIlIlIlll;
                break;
            }
            case 2: {
                this.m02 = lllllllllllllIIlIlIIIIIlIlIllllI;
                this.m12 = lllllllllllllIIlIlIIIIIlIlIllIII;
                this.m22 = lllllllllllllIIlIlIIIIIlIlIlIlll;
                break;
            }
            default: {
                throw new ArrayIndexOutOfBoundsException(VecMathI18N.getString("Matrix3d9"));
            }
        }
    }
    
    public final double getM21() {
        return this.m21;
    }
    
    public final void mul(final double lllllllllllllIIlIIlllllllllIllII) {
        this.m00 *= lllllllllllllIIlIIlllllllllIllII;
        this.m01 *= lllllllllllllIIlIIlllllllllIllII;
        this.m02 *= lllllllllllllIIlIIlllllllllIllII;
        this.m10 *= lllllllllllllIIlIIlllllllllIllII;
        this.m11 *= lllllllllllllIIlIIlllllllllIllII;
        this.m12 *= lllllllllllllIIlIIlllllllllIllII;
        this.m20 *= lllllllllllllIIlIIlllllllllIllII;
        this.m21 *= lllllllllllllIIlIIlllllllllIllII;
        this.m22 *= lllllllllllllIIlIIlllllllllIllII;
    }
    
    public final void setM22(final double lllllllllllllIIlIIllllIIIIlIllll) {
        this.m22 = lllllllllllllIIlIIllllIIIIlIllll;
    }
}
