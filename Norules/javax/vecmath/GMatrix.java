package javax.vecmath;

import java.io.*;

public class GMatrix implements Cloneable, Serializable
{
    /* synthetic */ int nRow;
    /* synthetic */ double[][] values;
    /* synthetic */ int nCol;
    
    public final void get(final GMatrix lllllllllllllIlllllIlIlllllIIIIl) {
        int lllllllllllllIlllllIlIlllllIIlIl = 0;
        if (this.nCol < lllllllllllllIlllllIlIlllllIIIIl.nCol) {
            final int lllllllllllllIlllllIlIlllllIIllI = this.nCol;
        }
        else {
            lllllllllllllIlllllIlIlllllIIlIl = lllllllllllllIlllllIlIlllllIIIIl.nCol;
        }
        int lllllllllllllIlllllIlIlllllIIIll = 0;
        if (this.nRow < lllllllllllllIlllllIlIlllllIIIIl.nRow) {
            final int lllllllllllllIlllllIlIlllllIIlII = this.nRow;
        }
        else {
            lllllllllllllIlllllIlIlllllIIIll = lllllllllllllIlllllIlIlllllIIIIl.nRow;
        }
        for (int lllllllllllllIlllllIlIlllllIlIlI = 0; lllllllllllllIlllllIlIlllllIlIlI < lllllllllllllIlllllIlIlllllIIIll; ++lllllllllllllIlllllIlIlllllIlIlI) {
            for (int lllllllllllllIlllllIlIlllllIlIIl = 0; lllllllllllllIlllllIlIlllllIlIIl < lllllllllllllIlllllIlIlllllIIlIl; ++lllllllllllllIlllllIlIlllllIlIIl) {
                lllllllllllllIlllllIlIlllllIIIIl.values[lllllllllllllIlllllIlIlllllIlIlI][lllllllllllllIlllllIlIlllllIlIIl] = this.values[lllllllllllllIlllllIlIlllllIlIlI][lllllllllllllIlllllIlIlllllIlIIl];
            }
        }
        for (int lllllllllllllIlllllIlIlllllIlIlI = lllllllllllllIlllllIlIlllllIIIll; lllllllllllllIlllllIlIlllllIlIlI < lllllllllllllIlllllIlIlllllIIIIl.nRow; ++lllllllllllllIlllllIlIlllllIlIlI) {
            for (int lllllllllllllIlllllIlIlllllIlIII = 0; lllllllllllllIlllllIlIlllllIlIII < lllllllllllllIlllllIlIlllllIIIIl.nCol; ++lllllllllllllIlllllIlIlllllIlIII) {
                lllllllllllllIlllllIlIlllllIIIIl.values[lllllllllllllIlllllIlIlllllIlIlI][lllllllllllllIlllllIlIlllllIlIII] = 0.0;
            }
        }
        for (int lllllllllllllIlllllIlIlllllIIlll = lllllllllllllIlllllIlIlllllIIlIl; lllllllllllllIlllllIlIlllllIIlll < lllllllllllllIlllllIlIlllllIIIIl.nCol; ++lllllllllllllIlllllIlIlllllIIlll) {
            for (int lllllllllllllIlllllIlIlllllIlIlI = 0; lllllllllllllIlllllIlIlllllIlIlI < lllllllllllllIlllllIlIlllllIIIll; ++lllllllllllllIlllllIlIlllllIlIlI) {
                lllllllllllllIlllllIlIlllllIIIIl.values[lllllllllllllIlllllIlIlllllIlIlI][lllllllllllllIlllllIlIlllllIIlll] = 0.0;
            }
        }
    }
    
    public final void identityMinus() {
        for (int lllllllllllllIlllllIllIIlllIllIl = 0; lllllllllllllIlllllIllIIlllIllIl < this.nRow; ++lllllllllllllIlllllIllIIlllIllIl) {
            for (int lllllllllllllIlllllIllIIlllIllII = 0; lllllllllllllIlllllIllIIlllIllII < this.nCol; ++lllllllllllllIlllllIllIIlllIllII) {
                this.values[lllllllllllllIlllllIllIIlllIllIl][lllllllllllllIlllllIllIIlllIllII] = -this.values[lllllllllllllIlllllIllIIlllIllIl][lllllllllllllIlllllIllIIlllIllII];
            }
        }
        int lllllllllllllIlllllIllIIlllIlIlI = 0;
        if (this.nRow < this.nCol) {
            final int lllllllllllllIlllllIllIIlllIlIll = this.nRow;
        }
        else {
            lllllllllllllIlllllIllIIlllIlIlI = this.nCol;
        }
        for (int lllllllllllllIlllllIllIIlllIllIl = 0; lllllllllllllIlllllIllIIlllIllIl < lllllllllllllIlllllIllIIlllIlIlI; ++lllllllllllllIlllllIllIIlllIllIl) {
            final double[] array = this.values[lllllllllllllIlllllIllIIlllIllIl];
            final int n = lllllllllllllIlllllIllIIlllIllIl;
            ++array[n];
        }
    }
    
    public final void setIdentity() {
        for (int lllllllllllllIlllllIllIlIIIIIIll = 0; lllllllllllllIlllllIllIlIIIIIIll < this.nRow; ++lllllllllllllIlllllIllIlIIIIIIll) {
            for (int lllllllllllllIlllllIllIlIIIIIIlI = 0; lllllllllllllIlllllIllIlIIIIIIlI < this.nCol; ++lllllllllllllIlllllIllIlIIIIIIlI) {
                this.values[lllllllllllllIlllllIllIlIIIIIIll][lllllllllllllIlllllIllIlIIIIIIlI] = 0.0;
            }
        }
        int lllllllllllllIlllllIllIlIIIIIIII = 0;
        if (this.nRow < this.nCol) {
            final int lllllllllllllIlllllIllIlIIIIIIIl = this.nRow;
        }
        else {
            lllllllllllllIlllllIllIlIIIIIIII = this.nCol;
        }
        for (int lllllllllllllIlllllIllIlIIIIIIll = 0; lllllllllllllIlllllIllIlIIIIIIll < lllllllllllllIlllllIllIlIIIIIIII; ++lllllllllllllIlllllIllIlIIIIIIll) {
            this.values[lllllllllllllIlllllIllIlIIIIIIll][lllllllllllllIlllllIllIlIIIIIIll] = 1.0;
        }
    }
    
    public final void get(final Matrix3f lllllllllllllIlllllIllIIIIIIIIIl) {
        if (this.nRow < 3 || this.nCol < 3) {
            lllllllllllllIlllllIllIIIIIIIIIl.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    lllllllllllllIlllllIllIIIIIIIIIl.m00 = (float)this.values[0][0];
                    if (this.nRow > 1) {
                        lllllllllllllIlllllIllIIIIIIIIIl.m10 = (float)this.values[1][0];
                        if (this.nRow > 2) {
                            lllllllllllllIlllllIllIIIIIIIIIl.m20 = (float)this.values[2][0];
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        lllllllllllllIlllllIllIIIIIIIIIl.m01 = (float)this.values[0][1];
                        if (this.nRow > 1) {
                            lllllllllllllIlllllIllIIIIIIIIIl.m11 = (float)this.values[1][1];
                            if (this.nRow > 2) {
                                lllllllllllllIlllllIllIIIIIIIIIl.m21 = (float)this.values[2][1];
                            }
                        }
                    }
                    if (this.nCol > 2 && this.nRow > 0) {
                        lllllllllllllIlllllIllIIIIIIIIIl.m02 = (float)this.values[0][2];
                        if (this.nRow > 1) {
                            lllllllllllllIlllllIllIIIIIIIIIl.m12 = (float)this.values[1][2];
                            if (this.nRow > 2) {
                                lllllllllllllIlllllIllIIIIIIIIIl.m22 = (float)this.values[2][2];
                            }
                        }
                    }
                }
            }
        }
        else {
            lllllllllllllIlllllIllIIIIIIIIIl.m00 = (float)this.values[0][0];
            lllllllllllllIlllllIllIIIIIIIIIl.m01 = (float)this.values[0][1];
            lllllllllllllIlllllIllIIIIIIIIIl.m02 = (float)this.values[0][2];
            lllllllllllllIlllllIllIIIIIIIIIl.m10 = (float)this.values[1][0];
            lllllllllllllIlllllIllIIIIIIIIIl.m11 = (float)this.values[1][1];
            lllllllllllllIlllllIllIIIIIIIIIl.m12 = (float)this.values[1][2];
            lllllllllllllIlllllIllIIIIIIIIIl.m20 = (float)this.values[2][0];
            lllllllllllllIlllllIllIIIIIIIIIl.m21 = (float)this.values[2][1];
            lllllllllllllIlllllIllIIIIIIIIIl.m22 = (float)this.values[2][2];
        }
    }
    
    public final void mul(final GMatrix lllllllllllllIlllllIllIlIllIlIII, final GMatrix lllllllllllllIlllllIllIlIllIlllI) {
        if (lllllllllllllIlllllIllIlIllIlIII.nCol != lllllllllllllIlllllIllIlIllIlllI.nRow || this.nRow != lllllllllllllIlllllIllIlIllIlIII.nRow || this.nCol != lllllllllllllIlllllIllIlIllIlllI.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix1"));
        }
        final double[][] lllllllllllllIlllllIllIlIllIlIlI = new double[this.nRow][this.nCol];
        for (int lllllllllllllIlllllIllIlIllIllIl = 0; lllllllllllllIlllllIllIlIllIllIl < lllllllllllllIlllllIllIlIllIlIII.nRow; ++lllllllllllllIlllllIllIlIllIllIl) {
            for (int lllllllllllllIlllllIllIlIllIllII = 0; lllllllllllllIlllllIllIlIllIllII < lllllllllllllIlllllIllIlIllIlllI.nCol; ++lllllllllllllIlllllIllIlIllIllII) {
                lllllllllllllIlllllIllIlIllIlIlI[lllllllllllllIlllllIllIlIllIllIl][lllllllllllllIlllllIllIlIllIllII] = 0.0;
                for (int lllllllllllllIlllllIllIlIllIlIll = 0; lllllllllllllIlllllIllIlIllIlIll < lllllllllllllIlllllIllIlIllIlIII.nCol; ++lllllllllllllIlllllIllIlIllIlIll) {
                    final double[] array = lllllllllllllIlllllIllIlIllIlIlI[lllllllllllllIlllllIllIlIllIllIl];
                    final int n = lllllllllllllIlllllIllIlIllIllII;
                    array[n] += lllllllllllllIlllllIllIlIllIlIII.values[lllllllllllllIlllllIllIlIllIllIl][lllllllllllllIlllllIllIlIllIlIll] * lllllllllllllIlllllIllIlIllIlllI.values[lllllllllllllIlllllIllIlIllIlIll][lllllllllllllIlllllIllIlIllIllII];
                }
            }
        }
        this.values = lllllllllllllIlllllIllIlIllIlIlI;
    }
    
    public final void mulTransposeBoth(final GMatrix lllllllllllllIlllllIlIlllIlIIlII, final GMatrix lllllllllllllIlllllIlIlllIIllIIl) {
        if (lllllllllllllIlllllIlIlllIlIIlII.nRow != lllllllllllllIlllllIlIlllIIllIIl.nCol || this.nRow != lllllllllllllIlllllIlIlllIlIIlII.nCol || this.nCol != lllllllllllllIlllllIlIlllIIllIIl.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix14"));
        }
        if (lllllllllllllIlllllIlIlllIlIIlII == this || lllllllllllllIlllllIlIlllIIllIIl == this) {
            final double[][] lllllllllllllIlllllIlIlllIIlllII = new double[this.nRow][this.nCol];
            for (int lllllllllllllIlllllIlIlllIlIIIlI = 0; lllllllllllllIlllllIlIlllIlIIIlI < this.nRow; ++lllllllllllllIlllllIlIlllIlIIIlI) {
                for (int lllllllllllllIlllllIlIlllIlIIIII = 0; lllllllllllllIlllllIlIlllIlIIIII < this.nCol; ++lllllllllllllIlllllIlIlllIlIIIII) {
                    lllllllllllllIlllllIlIlllIIlllII[lllllllllllllIlllllIlIlllIlIIIlI][lllllllllllllIlllllIlIlllIlIIIII] = 0.0;
                    for (int lllllllllllllIlllllIlIlllIIllllI = 0; lllllllllllllIlllllIlIlllIIllllI < lllllllllllllIlllllIlIlllIlIIlII.nRow; ++lllllllllllllIlllllIlIlllIIllllI) {
                        final double[] array = lllllllllllllIlllllIlIlllIIlllII[lllllllllllllIlllllIlIlllIlIIIlI];
                        final int n = lllllllllllllIlllllIlIlllIlIIIII;
                        array[n] += lllllllllllllIlllllIlIlllIlIIlII.values[lllllllllllllIlllllIlIlllIIllllI][lllllllllllllIlllllIlIlllIlIIIlI] * lllllllllllllIlllllIlIlllIIllIIl.values[lllllllllllllIlllllIlIlllIlIIIII][lllllllllllllIlllllIlIlllIIllllI];
                    }
                }
            }
            this.values = lllllllllllllIlllllIlIlllIIlllII;
        }
        else {
            for (int lllllllllllllIlllllIlIlllIlIIIIl = 0; lllllllllllllIlllllIlIlllIlIIIIl < this.nRow; ++lllllllllllllIlllllIlIlllIlIIIIl) {
                for (int lllllllllllllIlllllIlIlllIIlllll = 0; lllllllllllllIlllllIlIlllIIlllll < this.nCol; ++lllllllllllllIlllllIlIlllIIlllll) {
                    this.values[lllllllllllllIlllllIlIlllIlIIIIl][lllllllllllllIlllllIlIlllIIlllll] = 0.0;
                    for (int lllllllllllllIlllllIlIlllIIlllIl = 0; lllllllllllllIlllllIlIlllIIlllIl < lllllllllllllIlllllIlIlllIlIIlII.nRow; ++lllllllllllllIlllllIlIlllIIlllIl) {
                        final double[] array2 = this.values[lllllllllllllIlllllIlIlllIlIIIIl];
                        final int n2 = lllllllllllllIlllllIlIlllIIlllll;
                        array2[n2] += lllllllllllllIlllllIlIlllIlIIlII.values[lllllllllllllIlllllIlIlllIIlllIl][lllllllllllllIlllllIlIlllIlIIIIl] * lllllllllllllIlllllIlIlllIIllIIl.values[lllllllllllllIlllllIlIlllIIlllll][lllllllllllllIlllllIlIlllIIlllIl];
                    }
                }
            }
        }
    }
    
    private static void chase_across(final double[] lllllllllllllIlllllIlIIIlIlIllIl, final double[] lllllllllllllIlllllIlIIIlIlIllII, final int lllllllllllllIlllllIlIIIlIlIlIll, final GMatrix lllllllllllllIlllllIlIIIlIllIllI) {
        final double[] lllllllllllllIlllllIlIIIlIllIIlI = { 0.0 };
        final double[] lllllllllllllIlllllIlIIIlIllIIIl = { 0.0 };
        final GMatrix lllllllllllllIlllllIlIIIlIlIllll = new GMatrix(lllllllllllllIlllllIlIIIlIllIllI.nRow, lllllllllllllIlllllIlIIIlIllIllI.nCol);
        final GMatrix lllllllllllllIlllllIlIIIlIlIlllI = new GMatrix(lllllllllllllIlllllIlIIIlIllIllI.nRow, lllllllllllllIlllllIlIIIlIllIllI.nCol);
        double lllllllllllllIlllllIlIIIlIllIlII = lllllllllllllIlllllIlIIIlIlIllII[lllllllllllllIlllllIlIIIlIlIlIll];
        double lllllllllllllIlllllIlIIIlIllIlIl = lllllllllllllIlllllIlIIIlIlIllIl[lllllllllllllIlllllIlIIIlIlIlIll + 1];
        int lllllllllllllIlllllIlIIIlIllIIII;
        for (lllllllllllllIlllllIlIIIlIllIIII = lllllllllllllIlllllIlIIIlIlIlIll; lllllllllllllIlllllIlIIIlIllIIII < lllllllllllllIlllllIlIIIlIllIllI.nCol - 2; ++lllllllllllllIlllllIlIIIlIllIIII) {
            final double lllllllllllllIlllllIlIIIlIllIIll = compute_rot(lllllllllllllIlllllIlIIIlIllIlIl, lllllllllllllIlllllIlIIIlIllIlII, lllllllllllllIlllllIlIIIlIllIIIl, lllllllllllllIlllllIlIIIlIllIIlI);
            lllllllllllllIlllllIlIIIlIllIlII = -lllllllllllllIlllllIlIIIlIlIllII[lllllllllllllIlllllIlIIIlIllIIII + 1] * lllllllllllllIlllllIlIIIlIllIIIl[0];
            lllllllllllllIlllllIlIIIlIllIlIl = lllllllllllllIlllllIlIIIlIlIllIl[lllllllllllllIlllllIlIIIlIllIIII + 2];
            lllllllllllllIlllllIlIIIlIlIllIl[lllllllllllllIlllllIlIIIlIllIIII + 1] = lllllllllllllIlllllIlIIIlIllIIll;
            lllllllllllllIlllllIlIIIlIlIllII[lllllllllllllIlllllIlIIIlIllIIII + 1] *= lllllllllllllIlllllIlIIIlIllIIlI[0];
            update_u_split(lllllllllllllIlllllIlIIIlIlIlIll, lllllllllllllIlllllIlIIIlIllIIII + 1, lllllllllllllIlllllIlIIIlIllIllI, lllllllllllllIlllllIlIIIlIllIIlI, lllllllllllllIlllllIlIIIlIllIIIl, lllllllllllllIlllllIlIIIlIlIllll, lllllllllllllIlllllIlIIIlIlIlllI);
        }
        lllllllllllllIlllllIlIIIlIlIllIl[lllllllllllllIlllllIlIIIlIllIIII + 1] = compute_rot(lllllllllllllIlllllIlIIIlIllIlIl, lllllllllllllIlllllIlIIIlIllIlII, lllllllllllllIlllllIlIIIlIllIIIl, lllllllllllllIlllllIlIIIlIllIIlI);
        update_u_split(lllllllllllllIlllllIlIIIlIlIlIll, lllllllllllllIlllllIlIIIlIllIIII + 1, lllllllllllllIlllllIlIIIlIllIllI, lllllllllllllIlllllIlIIIlIllIIlI, lllllllllllllIlllllIlIIIlIllIIIl, lllllllllllllIlllllIlIIIlIlIllll, lllllllllllllIlllllIlIIIlIlIlllI);
    }
    
    public final double getElement(final int lllllllllllllIlllllIllIIIlIIlIll, final int lllllllllllllIlllllIllIIIlIIlIlI) {
        return this.values[lllllllllllllIlllllIllIIIlIIlIll][lllllllllllllIlllllIllIIIlIIlIlI];
    }
    
    public final void sub(final GMatrix lllllllllllllIlllllIllIlIIlIIllI, final GMatrix lllllllllllllIlllllIllIlIIlIIIII) {
        if (lllllllllllllIlllllIllIlIIlIIIII.nRow != lllllllllllllIlllllIllIlIIlIIllI.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix10"));
        }
        if (lllllllllllllIlllllIllIlIIlIIIII.nCol != lllllllllllllIlllllIllIlIIlIIllI.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix11"));
        }
        if (this.nRow != lllllllllllllIlllllIllIlIIlIIllI.nRow || this.nCol != lllllllllllllIlllllIllIlIIlIIllI.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix12"));
        }
        for (int lllllllllllllIlllllIllIlIIlIIlII = 0; lllllllllllllIlllllIllIlIIlIIlII < this.nRow; ++lllllllllllllIlllllIllIlIIlIIlII) {
            for (int lllllllllllllIlllllIllIlIIlIIIll = 0; lllllllllllllIlllllIllIlIIlIIIll < this.nCol; ++lllllllllllllIlllllIllIlIIlIIIll) {
                this.values[lllllllllllllIlllllIllIlIIlIIlII][lllllllllllllIlllllIllIlIIlIIIll] = lllllllllllllIlllllIllIlIIlIIllI.values[lllllllllllllIlllllIllIlIIlIIlII][lllllllllllllIlllllIllIlIIlIIIll] - lllllllllllllIlllllIllIlIIlIIIII.values[lllllllllllllIlllllIllIlIIlIIlII][lllllllllllllIlllllIllIlIIlIIIll];
            }
        }
    }
    
    public final void set(final Matrix3d lllllllllllllIlllllIllIIlIIIIIIl) {
        if (this.nRow < 3 || this.nCol < 3) {
            this.values = new double[3][3];
            this.nRow = 3;
            this.nCol = 3;
        }
        this.values[0][0] = lllllllllllllIlllllIllIIlIIIIIIl.m00;
        this.values[0][1] = lllllllllllllIlllllIllIIlIIIIIIl.m01;
        this.values[0][2] = lllllllllllllIlllllIllIIlIIIIIIl.m02;
        this.values[1][0] = lllllllllllllIlllllIllIIlIIIIIIl.m10;
        this.values[1][1] = lllllllllllllIlllllIllIIlIIIIIIl.m11;
        this.values[1][2] = lllllllllllllIlllllIllIIlIIIIIIl.m12;
        this.values[2][0] = lllllllllllllIlllllIllIIlIIIIIIl.m20;
        this.values[2][1] = lllllllllllllIlllllIllIIlIIIIIIl.m21;
        this.values[2][2] = lllllllllllllIlllllIllIIlIIIIIIl.m22;
        for (int lllllllllllllIlllllIllIIlIIIIIII = 3; lllllllllllllIlllllIllIIlIIIIIII < this.nRow; ++lllllllllllllIlllllIllIIlIIIIIII) {
            for (int lllllllllllllIlllllIllIIIlllllll = 3; lllllllllllllIlllllIllIIIlllllll < this.nCol; ++lllllllllllllIlllllIllIIIlllllll) {
                this.values[lllllllllllllIlllllIllIIlIIIIIII][lllllllllllllIlllllIllIIIlllllll] = 0.0;
            }
        }
    }
    
    static double compute_shift(final double lllllllllllllIlllllIlIIIIIIlIlII, final double lllllllllllllIlllllIlIIIIIIlIIll, final double lllllllllllllIlllllIlIIIIIIlIIlI) {
        final double lllllllllllllIlllllIlIIIIIIIlIlI = Math.abs(lllllllllllllIlllllIlIIIIIIlIlII);
        final double lllllllllllllIlllllIlIIIIIIIlIIl = Math.abs(lllllllllllllIlllllIlIIIIIIlIIll);
        final double lllllllllllllIlllllIlIIIIIIIlIII = Math.abs(lllllllllllllIlllllIlIIIIIIlIIlI);
        final double lllllllllllllIlllllIlIIIIIIIlllI = min(lllllllllllllIlllllIlIIIIIIIlIlI, lllllllllllllIlllllIlIIIIIIIlIII);
        final double lllllllllllllIlllllIlIIIIIIIllIl = max(lllllllllllllIlllllIlIIIIIIIlIlI, lllllllllllllIlllllIlIIIIIIIlIII);
        double lllllllllllllIlllllIIllllllllllI = 0.0;
        if (lllllllllllllIlllllIlIIIIIIIlllI == 0.0) {
            final double lllllllllllllIlllllIlIIIIIIIIIIl = 0.0;
            if (lllllllllllllIlllllIlIIIIIIIllIl != 0.0) {
                final boolean lllllllllllllIlllllIIllllllllIlI = min(lllllllllllllIlllllIlIIIIIIIllIl, lllllllllllllIlllllIlIIIIIIIlIIl) / max(lllllllllllllIlllllIlIIIIIIIllIl, lllllllllllllIlllllIlIIIIIIIlIIl) != 0.0;
            }
        }
        else if (lllllllllllllIlllllIlIIIIIIIlIIl < lllllllllllllIlllllIlIIIIIIIllIl) {
            final double lllllllllllllIlllllIlIIIIIIIIlll = lllllllllllllIlllllIlIIIIIIIlllI / lllllllllllllIlllllIlIIIIIIIllIl + 1.0;
            final double lllllllllllllIlllllIlIIIIIIIIlIl = (lllllllllllllIlllllIlIIIIIIIllIl - lllllllllllllIlllllIlIIIIIIIlllI) / lllllllllllllIlllllIlIIIIIIIllIl;
            final double lllllllllllllIlllllIlIIIIIIlIIIl = lllllllllllllIlllllIlIIIIIIIlIIl / lllllllllllllIlllllIlIIIIIIIllIl;
            final double lllllllllllllIlllllIlIIIIIIIIIll = lllllllllllllIlllllIlIIIIIIlIIIl * lllllllllllllIlllllIlIIIIIIlIIIl;
            final double lllllllllllllIlllllIlIIIIIIIllII = 2.0 / (Math.sqrt(lllllllllllllIlllllIlIIIIIIIIlll * lllllllllllllIlllllIlIIIIIIIIlll + lllllllllllllIlllllIlIIIIIIIIIll) + Math.sqrt(lllllllllllllIlllllIlIIIIIIIIlIl * lllllllllllllIlllllIlIIIIIIIIlIl + lllllllllllllIlllllIlIIIIIIIIIll));
            final double lllllllllllllIlllllIlIIIIIIIIIII = lllllllllllllIlllllIlIIIIIIIlllI * lllllllllllllIlllllIlIIIIIIIllII;
        }
        else {
            final double lllllllllllllIlllllIlIIIIIIIIIlI = lllllllllllllIlllllIlIIIIIIIllIl / lllllllllllllIlllllIlIIIIIIIlIIl;
            if (lllllllllllllIlllllIlIIIIIIIIIlI == 0.0) {
                final double lllllllllllllIlllllIIlllllllllll = lllllllllllllIlllllIlIIIIIIIlllI * lllllllllllllIlllllIlIIIIIIIllIl / lllllllllllllIlllllIlIIIIIIIlIIl;
            }
            else {
                final double lllllllllllllIlllllIlIIIIIIIIllI = lllllllllllllIlllllIlIIIIIIIlllI / lllllllllllllIlllllIlIIIIIIIllIl + 1.0;
                final double lllllllllllllIlllllIlIIIIIIIIlII = (lllllllllllllIlllllIlIIIIIIIllIl - lllllllllllllIlllllIlIIIIIIIlllI) / lllllllllllllIlllllIlIIIIIIIllIl;
                final double lllllllllllllIlllllIlIIIIIIlIIII = lllllllllllllIlllllIlIIIIIIIIllI * lllllllllllllIlllllIlIIIIIIIIIlI;
                final double lllllllllllllIlllllIlIIIIIIIllll = lllllllllllllIlllllIlIIIIIIIIlII * lllllllllllllIlllllIlIIIIIIIIIlI;
                final double lllllllllllllIlllllIlIIIIIIIlIll = 1.0 / (Math.sqrt(lllllllllllllIlllllIlIIIIIIlIIII * lllllllllllllIlllllIlIIIIIIlIIII + 1.0) + Math.sqrt(lllllllllllllIlllllIlIIIIIIIllll * lllllllllllllIlllllIlIIIIIIIllll + 1.0));
                lllllllllllllIlllllIIllllllllllI = lllllllllllllIlllllIlIIIIIIIlllI * lllllllllllllIlllllIlIIIIIIIlIll * lllllllllllllIlllllIlIIIIIIIIIlI;
                lllllllllllllIlllllIIllllllllllI += lllllllllllllIlllllIIllllllllllI;
            }
        }
        return lllllllllllllIlllllIIllllllllllI;
    }
    
    static double compute_rot(final double lllllllllllllIlllllIIlllIlIIllII, final double lllllllllllllIlllllIIlllIlIIlIll, final double[] lllllllllllllIlllllIIlllIllIlIII, final double[] lllllllllllllIlllllIIlllIllIIlll) {
        final double lllllllllllllIlllllIIlllIlIIlllI = 2.002083095183101E-146;
        final double lllllllllllllIlllllIIlllIlIIllIl = 4.9947976805055876E145;
        double lllllllllllllIlllllIIlllIlIIllll = 0.0;
        double lllllllllllllIlllllIIlllIllIIIII = 0.0;
        double lllllllllllllIlllllIIlllIlIllIll = 0.0;
        if (lllllllllllllIlllllIIlllIlIIlIll == 0.0) {
            final double lllllllllllllIlllllIIlllIllIIlII = 1.0;
            final double lllllllllllllIlllllIIlllIlIlllll = 0.0;
            final double lllllllllllllIlllllIIlllIlIlIIll = lllllllllllllIlllllIIlllIlIIllII;
        }
        else if (lllllllllllllIlllllIIlllIlIIllII == 0.0) {
            final double lllllllllllllIlllllIIlllIllIIIll = 0.0;
            final double lllllllllllllIlllllIIlllIlIllllI = 1.0;
            final double lllllllllllllIlllllIIlllIlIlIIlI = lllllllllllllIlllllIIlllIlIIlIll;
        }
        else {
            double lllllllllllllIlllllIIlllIlIlIlIl = lllllllllllllIlllllIIlllIlIIllII;
            double lllllllllllllIlllllIIlllIlIlIlII = lllllllllllllIlllllIIlllIlIIlIll;
            double lllllllllllllIlllllIIlllIlIllIII = max(Math.abs(lllllllllllllIlllllIIlllIlIlIlIl), Math.abs(lllllllllllllIlllllIIlllIlIlIlII));
            if (lllllllllllllIlllllIIlllIlIllIII >= 4.9947976805055876E145) {
                int lllllllllllllIlllllIIlllIlIlIlll = 0;
                while (lllllllllllllIlllllIIlllIlIllIII >= 4.9947976805055876E145) {
                    ++lllllllllllllIlllllIIlllIlIlIlll;
                    lllllllllllllIlllllIIlllIlIlIlIl *= 2.002083095183101E-146;
                    lllllllllllllIlllllIIlllIlIlIlII *= 2.002083095183101E-146;
                    lllllllllllllIlllllIIlllIlIllIII = max(Math.abs(lllllllllllllIlllllIIlllIlIlIlIl), Math.abs(lllllllllllllIlllllIIlllIlIlIlII));
                }
                double lllllllllllllIlllllIIlllIlIlIIIl = Math.sqrt(lllllllllllllIlllllIIlllIlIlIlIl * lllllllllllllIlllllIIlllIlIlIlIl + lllllllllllllIlllllIIlllIlIlIlII * lllllllllllllIlllllIIlllIlIlIlII);
                final double lllllllllllllIlllllIIlllIllIIIlI = lllllllllllllIlllllIIlllIlIlIlIl / lllllllllllllIlllllIIlllIlIlIIIl;
                final double lllllllllllllIlllllIIlllIlIlllIl = lllllllllllllIlllllIIlllIlIlIlII / lllllllllllllIlllllIIlllIlIlIIIl;
                final int lllllllllllllIlllllIIlllIllIIllI = lllllllllllllIlllllIIlllIlIlIlll;
                for (int lllllllllllllIlllllIIlllIlIllIlI = 1; lllllllllllllIlllllIIlllIlIllIlI <= lllllllllllllIlllllIIlllIlIlIlll; ++lllllllllllllIlllllIIlllIlIllIlI) {
                    lllllllllllllIlllllIIlllIlIlIIIl *= 4.9947976805055876E145;
                }
            }
            else if (lllllllllllllIlllllIIlllIlIllIII <= 2.002083095183101E-146) {
                int lllllllllllllIlllllIIlllIlIlIllI = 0;
                while (lllllllllllllIlllllIIlllIlIllIII <= 2.002083095183101E-146) {
                    ++lllllllllllllIlllllIIlllIlIlIllI;
                    lllllllllllllIlllllIIlllIlIlIlIl *= 4.9947976805055876E145;
                    lllllllllllllIlllllIIlllIlIlIlII *= 4.9947976805055876E145;
                    lllllllllllllIlllllIIlllIlIllIII = max(Math.abs(lllllllllllllIlllllIIlllIlIlIlIl), Math.abs(lllllllllllllIlllllIIlllIlIlIlII));
                }
                double lllllllllllllIlllllIIlllIlIlIIII = Math.sqrt(lllllllllllllIlllllIIlllIlIlIlIl * lllllllllllllIlllllIIlllIlIlIlIl + lllllllllllllIlllllIIlllIlIlIlII * lllllllllllllIlllllIIlllIlIlIlII);
                final double lllllllllllllIlllllIIlllIllIIIIl = lllllllllllllIlllllIIlllIlIlIlIl / lllllllllllllIlllllIIlllIlIlIIII;
                final double lllllllllllllIlllllIIlllIlIlllII = lllllllllllllIlllllIIlllIlIlIlII / lllllllllllllIlllllIIlllIlIlIIII;
                final int lllllllllllllIlllllIIlllIllIIlIl = lllllllllllllIlllllIIlllIlIlIllI;
                for (int lllllllllllllIlllllIIlllIlIllIIl = 1; lllllllllllllIlllllIIlllIlIllIIl <= lllllllllllllIlllllIIlllIlIlIllI; ++lllllllllllllIlllllIIlllIlIllIIl) {
                    lllllllllllllIlllllIIlllIlIlIIII *= 2.002083095183101E-146;
                }
            }
            else {
                lllllllllllllIlllllIIlllIlIIllll = Math.sqrt(lllllllllllllIlllllIIlllIlIlIlIl * lllllllllllllIlllllIIlllIlIlIlIl + lllllllllllllIlllllIIlllIlIlIlII * lllllllllllllIlllllIIlllIlIlIlII);
                lllllllllllllIlllllIIlllIllIIIII = lllllllllllllIlllllIIlllIlIlIlIl / lllllllllllllIlllllIIlllIlIIllll;
                lllllllllllllIlllllIIlllIlIllIll = lllllllllllllIlllllIIlllIlIlIlII / lllllllllllllIlllllIIlllIlIIllll;
            }
            if (Math.abs(lllllllllllllIlllllIIlllIlIIllII) > Math.abs(lllllllllllllIlllllIIlllIlIIlIll) && lllllllllllllIlllllIIlllIllIIIII < 0.0) {
                lllllllllllllIlllllIIlllIllIIIII = -lllllllllllllIlllllIIlllIllIIIII;
                lllllllllllllIlllllIIlllIlIllIll = -lllllllllllllIlllllIIlllIlIllIll;
                lllllllllllllIlllllIIlllIlIIllll = -lllllllllllllIlllllIIlllIlIIllll;
            }
        }
        lllllllllllllIlllllIIlllIllIlIII[0] = lllllllllllllIlllllIIlllIlIllIll;
        lllllllllllllIlllllIIlllIllIIlll[0] = lllllllllllllIlllllIIlllIllIIIII;
        return lllllllllllllIlllllIIlllIlIIllll;
    }
    
    public final void invert() {
        this.invertGeneral(this);
    }
    
    public final void get(final Matrix4d lllllllllllllIlllllIlIlllllllIll) {
        if (this.nRow < 4 || this.nCol < 4) {
            lllllllllllllIlllllIlIlllllllIll.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    lllllllllllllIlllllIlIlllllllIll.m00 = this.values[0][0];
                    if (this.nRow > 1) {
                        lllllllllllllIlllllIlIlllllllIll.m10 = this.values[1][0];
                        if (this.nRow > 2) {
                            lllllllllllllIlllllIlIlllllllIll.m20 = this.values[2][0];
                            if (this.nRow > 3) {
                                lllllllllllllIlllllIlIlllllllIll.m30 = this.values[3][0];
                            }
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        lllllllllllllIlllllIlIlllllllIll.m01 = this.values[0][1];
                        if (this.nRow > 1) {
                            lllllllllllllIlllllIlIlllllllIll.m11 = this.values[1][1];
                            if (this.nRow > 2) {
                                lllllllllllllIlllllIlIlllllllIll.m21 = this.values[2][1];
                                if (this.nRow > 3) {
                                    lllllllllllllIlllllIlIlllllllIll.m31 = this.values[3][1];
                                }
                            }
                        }
                    }
                    if (this.nCol > 2) {
                        if (this.nRow > 0) {
                            lllllllllllllIlllllIlIlllllllIll.m02 = this.values[0][2];
                            if (this.nRow > 1) {
                                lllllllllllllIlllllIlIlllllllIll.m12 = this.values[1][2];
                                if (this.nRow > 2) {
                                    lllllllllllllIlllllIlIlllllllIll.m22 = this.values[2][2];
                                    if (this.nRow > 3) {
                                        lllllllllllllIlllllIlIlllllllIll.m32 = this.values[3][2];
                                    }
                                }
                            }
                        }
                        if (this.nCol > 3 && this.nRow > 0) {
                            lllllllllllllIlllllIlIlllllllIll.m03 = this.values[0][3];
                            if (this.nRow > 1) {
                                lllllllllllllIlllllIlIlllllllIll.m13 = this.values[1][3];
                                if (this.nRow > 2) {
                                    lllllllllllllIlllllIlIlllllllIll.m23 = this.values[2][3];
                                    if (this.nRow > 3) {
                                        lllllllllllllIlllllIlIlllllllIll.m33 = this.values[3][3];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            lllllllllllllIlllllIlIlllllllIll.m00 = this.values[0][0];
            lllllllllllllIlllllIlIlllllllIll.m01 = this.values[0][1];
            lllllllllllllIlllllIlIlllllllIll.m02 = this.values[0][2];
            lllllllllllllIlllllIlIlllllllIll.m03 = this.values[0][3];
            lllllllllllllIlllllIlIlllllllIll.m10 = this.values[1][0];
            lllllllllllllIlllllIlIlllllllIll.m11 = this.values[1][1];
            lllllllllllllIlllllIlIlllllllIll.m12 = this.values[1][2];
            lllllllllllllIlllllIlIlllllllIll.m13 = this.values[1][3];
            lllllllllllllIlllllIlIlllllllIll.m20 = this.values[2][0];
            lllllllllllllIlllllIlIlllllllIll.m21 = this.values[2][1];
            lllllllllllllIlllllIlIlllllllIll.m22 = this.values[2][2];
            lllllllllllllIlllllIlIlllllllIll.m23 = this.values[2][3];
            lllllllllllllIlllllIlIlllllllIll.m30 = this.values[3][0];
            lllllllllllllIlllllIlIlllllllIll.m31 = this.values[3][1];
            lllllllllllllIlllllIlIlllllllIll.m32 = this.values[3][2];
            lllllllllllllIlllllIlIlllllllIll.m33 = this.values[3][3];
        }
    }
    
    public final void get(final Matrix4f lllllllllllllIlllllIlIllllllIlIl) {
        if (this.nRow < 4 || this.nCol < 4) {
            lllllllllllllIlllllIlIllllllIlIl.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    lllllllllllllIlllllIlIllllllIlIl.m00 = (float)this.values[0][0];
                    if (this.nRow > 1) {
                        lllllllllllllIlllllIlIllllllIlIl.m10 = (float)this.values[1][0];
                        if (this.nRow > 2) {
                            lllllllllllllIlllllIlIllllllIlIl.m20 = (float)this.values[2][0];
                            if (this.nRow > 3) {
                                lllllllllllllIlllllIlIllllllIlIl.m30 = (float)this.values[3][0];
                            }
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        lllllllllllllIlllllIlIllllllIlIl.m01 = (float)this.values[0][1];
                        if (this.nRow > 1) {
                            lllllllllllllIlllllIlIllllllIlIl.m11 = (float)this.values[1][1];
                            if (this.nRow > 2) {
                                lllllllllllllIlllllIlIllllllIlIl.m21 = (float)this.values[2][1];
                                if (this.nRow > 3) {
                                    lllllllllllllIlllllIlIllllllIlIl.m31 = (float)this.values[3][1];
                                }
                            }
                        }
                    }
                    if (this.nCol > 2) {
                        if (this.nRow > 0) {
                            lllllllllllllIlllllIlIllllllIlIl.m02 = (float)this.values[0][2];
                            if (this.nRow > 1) {
                                lllllllllllllIlllllIlIllllllIlIl.m12 = (float)this.values[1][2];
                                if (this.nRow > 2) {
                                    lllllllllllllIlllllIlIllllllIlIl.m22 = (float)this.values[2][2];
                                    if (this.nRow > 3) {
                                        lllllllllllllIlllllIlIllllllIlIl.m32 = (float)this.values[3][2];
                                    }
                                }
                            }
                        }
                        if (this.nCol > 3 && this.nRow > 0) {
                            lllllllllllllIlllllIlIllllllIlIl.m03 = (float)this.values[0][3];
                            if (this.nRow > 1) {
                                lllllllllllllIlllllIlIllllllIlIl.m13 = (float)this.values[1][3];
                                if (this.nRow > 2) {
                                    lllllllllllllIlllllIlIllllllIlIl.m23 = (float)this.values[2][3];
                                    if (this.nRow > 3) {
                                        lllllllllllllIlllllIlIllllllIlIl.m33 = (float)this.values[3][3];
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            lllllllllllllIlllllIlIllllllIlIl.m00 = (float)this.values[0][0];
            lllllllllllllIlllllIlIllllllIlIl.m01 = (float)this.values[0][1];
            lllllllllllllIlllllIlIllllllIlIl.m02 = (float)this.values[0][2];
            lllllllllllllIlllllIlIllllllIlIl.m03 = (float)this.values[0][3];
            lllllllllllllIlllllIlIllllllIlIl.m10 = (float)this.values[1][0];
            lllllllllllllIlllllIlIllllllIlIl.m11 = (float)this.values[1][1];
            lllllllllllllIlllllIlIllllllIlIl.m12 = (float)this.values[1][2];
            lllllllllllllIlllllIlIllllllIlIl.m13 = (float)this.values[1][3];
            lllllllllllllIlllllIlIllllllIlIl.m20 = (float)this.values[2][0];
            lllllllllllllIlllllIlIllllllIlIl.m21 = (float)this.values[2][1];
            lllllllllllllIlllllIlIllllllIlIl.m22 = (float)this.values[2][2];
            lllllllllllllIlllllIlIllllllIlIl.m23 = (float)this.values[2][3];
            lllllllllllllIlllllIlIllllllIlIl.m30 = (float)this.values[3][0];
            lllllllllllllIlllllIlIllllllIlIl.m31 = (float)this.values[3][1];
            lllllllllllllIlllllIlIllllllIlIl.m32 = (float)this.values[3][2];
            lllllllllllllIlllllIlIllllllIlIl.m33 = (float)this.values[3][3];
        }
    }
    
    public final int getNumRow() {
        return this.nRow;
    }
    
    final void invertGeneral(final GMatrix lllllllllllllIlllllIlIlIlIIlIIIl) {
        final int lllllllllllllIlllllIlIlIlIIlIIII = lllllllllllllIlllllIlIlIlIIlIIIl.nRow * lllllllllllllIlllllIlIlIlIIlIIIl.nCol;
        final double[] lllllllllllllIlllllIlIlIlIIIllll = new double[lllllllllllllIlllllIlIlIlIIlIIII];
        final double[] lllllllllllllIlllllIlIlIlIIIlllI = new double[lllllllllllllIlllllIlIlIlIIlIIII];
        final int[] lllllllllllllIlllllIlIlIlIIIllIl = new int[lllllllllllllIlllllIlIlIlIIlIIIl.nRow];
        final int[] lllllllllllllIlllllIlIlIlIIIllII = { 0 };
        if (lllllllllllllIlllllIlIlIlIIlIIIl.nRow != lllllllllllllIlllllIlIlIlIIlIIIl.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix22"));
        }
        for (int lllllllllllllIlllllIlIlIlIIIlIll = 0; lllllllllllllIlllllIlIlIlIIIlIll < this.nRow; ++lllllllllllllIlllllIlIlIlIIIlIll) {
            for (int lllllllllllllIlllllIlIlIlIIIlIlI = 0; lllllllllllllIlllllIlIlIlIIIlIlI < this.nCol; ++lllllllllllllIlllllIlIlIlIIIlIlI) {
                lllllllllllllIlllllIlIlIlIIIllll[lllllllllllllIlllllIlIlIlIIIlIll * this.nCol + lllllllllllllIlllllIlIlIlIIIlIlI] = lllllllllllllIlllllIlIlIlIIlIIIl.values[lllllllllllllIlllllIlIlIlIIIlIll][lllllllllllllIlllllIlIlIlIIIlIlI];
            }
        }
        if (!luDecomposition(lllllllllllllIlllllIlIlIlIIlIIIl.nRow, lllllllllllllIlllllIlIlIlIIIllll, lllllllllllllIlllllIlIlIlIIIllIl, lllllllllllllIlllllIlIlIlIIIllII)) {
            throw new SingularMatrixException(VecMathI18N.getString("GMatrix21"));
        }
        for (int lllllllllllllIlllllIlIlIlIIIlIll = 0; lllllllllllllIlllllIlIlIlIIIlIll < lllllllllllllIlllllIlIlIlIIlIIII; ++lllllllllllllIlllllIlIlIlIIIlIll) {
            lllllllllllllIlllllIlIlIlIIIlllI[lllllllllllllIlllllIlIlIlIIIlIll] = 0.0;
        }
        for (int lllllllllllllIlllllIlIlIlIIIlIll = 0; lllllllllllllIlllllIlIlIlIIIlIll < this.nCol; ++lllllllllllllIlllllIlIlIlIIIlIll) {
            lllllllllllllIlllllIlIlIlIIIlllI[lllllllllllllIlllllIlIlIlIIIlIll + lllllllllllllIlllllIlIlIlIIIlIll * this.nCol] = 1.0;
        }
        luBacksubstitution(lllllllllllllIlllllIlIlIlIIlIIIl.nRow, lllllllllllllIlllllIlIlIlIIIllll, lllllllllllllIlllllIlIlIlIIIllIl, lllllllllllllIlllllIlIlIlIIIlllI);
        for (int lllllllllllllIlllllIlIlIlIIIlIll = 0; lllllllllllllIlllllIlIlIlIIIlIll < this.nRow; ++lllllllllllllIlllllIlIlIlIIIlIll) {
            for (int lllllllllllllIlllllIlIlIlIIIlIIl = 0; lllllllllllllIlllllIlIlIlIIIlIIl < this.nCol; ++lllllllllllllIlllllIlIlIlIIIlIIl) {
                this.values[lllllllllllllIlllllIlIlIlIIIlIll][lllllllllllllIlllllIlIlIlIIIlIIl] = lllllllllllllIlllllIlIlIlIIIlllI[lllllllllllllIlllllIlIlIlIIIlIll * this.nCol + lllllllllllllIlllllIlIlIlIIIlIIl];
            }
        }
    }
    
    public final void add(final GMatrix lllllllllllllIlllllIllIlIIllllII, final GMatrix lllllllllllllIlllllIllIlIIlllIll) {
        if (lllllllllllllIlllllIllIlIIlllIll.nRow != lllllllllllllIlllllIllIlIIllllII.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix6"));
        }
        if (lllllllllllllIlllllIllIlIIlllIll.nCol != lllllllllllllIlllllIllIlIIllllII.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix7"));
        }
        if (this.nCol != lllllllllllllIlllllIllIlIIllllII.nCol || this.nRow != lllllllllllllIlllllIllIlIIllllII.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix8"));
        }
        for (int lllllllllllllIlllllIllIlIIllllll = 0; lllllllllllllIlllllIllIlIIllllll < this.nRow; ++lllllllllllllIlllllIllIlIIllllll) {
            for (int lllllllllllllIlllllIllIlIIlllllI = 0; lllllllllllllIlllllIllIlIIlllllI < this.nCol; ++lllllllllllllIlllllIllIlIIlllllI) {
                this.values[lllllllllllllIlllllIllIlIIllllll][lllllllllllllIlllllIllIlIIlllllI] = lllllllllllllIlllllIllIlIIllllII.values[lllllllllllllIlllllIllIlIIllllll][lllllllllllllIlllllIllIlIIlllllI] + lllllllllllllIlllllIllIlIIlllIll.values[lllllllllllllIlllllIllIlIIllllll][lllllllllllllIlllllIllIlIIlllllI];
            }
        }
    }
    
    public final void setColumn(final int lllllllllllllIlllllIlIlllIlIllll, final GVector lllllllllllllIlllllIlIlllIlIlllI) {
        for (int lllllllllllllIlllllIlIlllIllIIIl = 0; lllllllllllllIlllllIlIlllIllIIIl < this.nRow; ++lllllllllllllIlllllIlIlllIllIIIl) {
            this.values[lllllllllllllIlllllIlIlllIllIIIl][lllllllllllllIlllllIlIlllIlIllll] = lllllllllllllIlllllIlIlllIlIlllI.values[lllllllllllllIlllllIlIlllIllIIIl];
        }
    }
    
    static int computeSVD(final GMatrix lllllllllllllIlllllIlIIllIIllIlI, final GMatrix lllllllllllllIlllllIlIIllIIllIIl, final GMatrix lllllllllllllIlllllIlIIlllIIlIlI, final GMatrix lllllllllllllIlllllIlIIlllIIlIIl) {
        final GMatrix lllllllllllllIlllllIlIIllIlIIlIl = new GMatrix(lllllllllllllIlllllIlIIllIIllIlI.nRow, lllllllllllllIlllllIlIIllIIllIlI.nCol);
        final GMatrix lllllllllllllIlllllIlIIllIlIIlII = new GMatrix(lllllllllllllIlllllIlIIllIIllIlI.nRow, lllllllllllllIlllllIlIIllIIllIlI.nCol);
        final GMatrix lllllllllllllIlllllIlIIllIlIIIll = new GMatrix(lllllllllllllIlllllIlIIllIIllIlI.nRow, lllllllllllllIlllllIlIIllIIllIlI.nCol);
        final GMatrix lllllllllllllIlllllIlIIllIlIIIlI = new GMatrix(lllllllllllllIlllllIlIIllIIllIlI);
        int lllllllllllllIlllllIlIIllIlIlIII = 0;
        int lllllllllllllIlllllIlIIllIlIlIlI = 0;
        if (lllllllllllllIlllllIlIIllIlIIIlI.nRow >= lllllllllllllIlllllIlIIllIlIIIlI.nCol) {
            final int lllllllllllllIlllllIlIIllIlIlIIl = lllllllllllllIlllllIlIIllIlIIIlI.nCol;
            final int lllllllllllllIlllllIlIIllIlIlIll = lllllllllllllIlllllIlIIllIlIIIlI.nCol - 1;
        }
        else {
            lllllllllllllIlllllIlIIllIlIlIII = lllllllllllllIlllllIlIIllIlIIIlI.nRow;
            lllllllllllllIlllllIlIIllIlIlIlI = lllllllllllllIlllllIlIIllIlIIIlI.nRow;
        }
        int lllllllllllllIlllllIlIIllIlIIllI = 0;
        if (lllllllllllllIlllllIlIIllIlIIIlI.nRow > lllllllllllllIlllllIlIIllIlIIIlI.nCol) {
            final int lllllllllllllIlllllIlIIllIlIIlll = lllllllllllllIlllllIlIIllIlIIIlI.nRow;
        }
        else {
            lllllllllllllIlllllIlIIllIlIIllI = lllllllllllllIlllllIlIIllIlIIIlI.nCol;
        }
        final double[] lllllllllllllIlllllIlIIllIlIIIIl = new double[lllllllllllllIlllllIlIIllIlIIllI];
        final double[] lllllllllllllIlllllIlIIllIlIIIII = new double[lllllllllllllIlllllIlIIllIlIlIII];
        final double[] lllllllllllllIlllllIlIIllIIlllll = new double[lllllllllllllIlllllIlIIllIlIlIlI];
        int lllllllllllllIlllllIlIIllIllIIlI = 0;
        lllllllllllllIlllllIlIIllIIllIIl.setIdentity();
        lllllllllllllIlllllIlIIlllIIlIIl.setIdentity();
        int lllllllllllllIlllllIlIIllIllIlIl = lllllllllllllIlllllIlIIllIlIIIlI.nRow;
        int lllllllllllllIlllllIlIIllIllIlII = lllllllllllllIlllllIlIIllIlIIIlI.nCol;
        for (int lllllllllllllIlllllIlIIllIllIIll = 0; lllllllllllllIlllllIlIIllIllIIll < lllllllllllllIlllllIlIIllIlIlIII; ++lllllllllllllIlllllIlIIllIllIIll) {
            if (lllllllllllllIlllllIlIIllIllIlIl > 1) {
                double lllllllllllllIlllllIlIIllIllIIIl = 0.0;
                for (int lllllllllllllIlllllIlIIlllIIlIII = 0; lllllllllllllIlllllIlIIlllIIlIII < lllllllllllllIlllllIlIIllIllIlIl; ++lllllllllllllIlllllIlIIlllIIlIII) {
                    lllllllllllllIlllllIlIIllIllIIIl += lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIlIII + lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll] * lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIlIII + lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll];
                }
                lllllllllllllIlllllIlIIllIllIIIl = Math.sqrt(lllllllllllllIlllllIlIIllIllIIIl);
                if (lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll] == 0.0) {
                    lllllllllllllIlllllIlIIllIlIIIIl[0] = lllllllllllllIlllllIlIIllIllIIIl;
                }
                else {
                    lllllllllllllIlllllIlIIllIlIIIIl[0] = lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll] + d_sign(lllllllllllllIlllllIlIIllIllIIIl, lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll]);
                }
                for (int lllllllllllllIlllllIlIIlllIIlIII = 1; lllllllllllllIlllllIlIIlllIIlIII < lllllllllllllIlllllIlIIllIllIlIl; ++lllllllllllllIlllllIlIIlllIIlIII) {
                    lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIlIII] = lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll + lllllllllllllIlllllIlIIlllIIlIII][lllllllllllllIlllllIlIIllIllIIll];
                }
                double lllllllllllllIlllllIlIIllIlIllll = 0.0;
                for (int lllllllllllllIlllllIlIIlllIIlIII = 0; lllllllllllllIlllllIlIIlllIIlIII < lllllllllllllIlllllIlIIllIllIlIl; ++lllllllllllllIlllllIlIIlllIIlIII) {
                    lllllllllllllIlllllIlIIllIlIllll += lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIlIII] * lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIlIII];
                }
                lllllllllllllIlllllIlIIllIlIllll = 2.0 / lllllllllllllIlllllIlIIllIlIllll;
                for (int lllllllllllllIlllllIlIIlllIIIlIl = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIIlIl < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlIl) {
                    for (int lllllllllllllIlllllIlIIlllIIIIlI = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIIIlI < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIIlI) {
                        lllllllllllllIlllllIlIIllIlIIlII.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIlllIIIIlI] = -lllllllllllllIlllllIlIIllIlIllll * lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIIlIl - lllllllllllllIlllllIlIIllIllIIll] * lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIIIlI - lllllllllllllIlllllIlIIllIllIIll];
                    }
                }
                for (int lllllllllllllIlllllIlIIlllIIlIII = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIlIII < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIlIII) {
                    final double[] array = lllllllllllllIlllllIlIIllIlIIlII.values[lllllllllllllIlllllIlIIlllIIlIII];
                    final int n = lllllllllllllIlllllIlIIlllIIlIII;
                    ++array[n];
                }
                double lllllllllllllIlllllIlIIllIlIllIl = 0.0;
                for (int lllllllllllllIlllllIlIIlllIIlIII = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIlIII < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIlIII) {
                    lllllllllllllIlllllIlIIllIlIllIl += lllllllllllllIlllllIlIIllIlIIlII.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIlllIIlIII] * lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIlIII][lllllllllllllIlllllIlIIllIllIIll];
                }
                lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll] = lllllllllllllIlllllIlIIllIlIllIl;
                for (int lllllllllllllIlllllIlIIlllIIIlIl = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIIlIl < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlIl) {
                    for (int lllllllllllllIlllllIlIIlllIIIIIl = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIlllIIIIIl < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIlllIIIIIl) {
                        lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIlllIIIIIl] = 0.0;
                        for (int lllllllllllllIlllllIlIIlllIIlIII = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIlIII < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIlllIIlIII) {
                            final double[] array2 = lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlIl];
                            final int n2 = lllllllllllllIlllllIlIIlllIIIIIl;
                            array2[n2] += lllllllllllllIlllllIlIIllIlIIlII.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIlllIIlIII] * lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIlIII][lllllllllllllIlllllIlIIlllIIIIIl];
                        }
                    }
                }
                for (int lllllllllllllIlllllIlIIlllIIIlIl = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIIlIl < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlIl) {
                    for (int lllllllllllllIlllllIlIIllIllllll = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIllIllllll < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIllIllllll) {
                        lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIllIllllll] = lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIllIllllll];
                    }
                }
                for (int lllllllllllllIlllllIlIIlllIIIlIl = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIIlIl < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlIl) {
                    for (int lllllllllllllIlllllIlIIllIlllllI = 0; lllllllllllllIlllllIlIIllIlllllI < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIllIlllllI) {
                        lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIllIlllllI] = 0.0;
                        for (int lllllllllllllIlllllIlIIlllIIlIII = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIlIII < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIlllIIlIII) {
                            final double[] array3 = lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlIl];
                            final int n3 = lllllllllllllIlllllIlIIllIlllllI;
                            array3[n3] += lllllllllllllIlllllIlIIllIlIIlII.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIlllIIlIII] * lllllllllllllIlllllIlIIllIIllIIl.values[lllllllllllllIlllllIlIIlllIIlIII][lllllllllllllIlllllIlIIllIlllllI];
                        }
                    }
                }
                for (int lllllllllllllIlllllIlIIlllIIIlIl = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIIlIl < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlIl) {
                    for (int lllllllllllllIlllllIlIIllIllllII = 0; lllllllllllllIlllllIlIIllIllllII < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIllIllllII) {
                        lllllllllllllIlllllIlIIllIIllIIl.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIllIllllII] = lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlIl][lllllllllllllIlllllIlIIllIllllII];
                    }
                }
                --lllllllllllllIlllllIlIIllIllIlIl;
            }
            if (lllllllllllllIlllllIlIIllIllIlII > 2) {
                double lllllllllllllIlllllIlIIllIllIIII = 0.0;
                for (int lllllllllllllIlllllIlIIlllIIIlll = 1; lllllllllllllIlllllIlIIlllIIIlll < lllllllllllllIlllllIlIIllIllIlII; ++lllllllllllllIlllllIlIIlllIIIlll) {
                    lllllllllllllIlllllIlIIllIllIIII += lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll + lllllllllllllIlllllIlIIlllIIIlll] * lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll + lllllllllllllIlllllIlIIlllIIIlll];
                }
                lllllllllllllIlllllIlIIllIllIIII = Math.sqrt(lllllllllllllIlllllIlIIllIllIIII);
                if (lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll + 1] == 0.0) {
                    lllllllllllllIlllllIlIIllIlIIIIl[0] = lllllllllllllIlllllIlIIllIllIIII;
                }
                else {
                    lllllllllllllIlllllIlIIllIlIIIIl[0] = lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll + 1] + d_sign(lllllllllllllIlllllIlIIllIllIIII, lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll + 1]);
                }
                for (int lllllllllllllIlllllIlIIlllIIIlll = 1; lllllllllllllIlllllIlIIlllIIIlll < lllllllllllllIlllllIlIIllIllIlII - 1; ++lllllllllllllIlllllIlIIlllIIIlll) {
                    lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIIlll] = lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll + lllllllllllllIlllllIlIIlllIIIlll + 1];
                }
                double lllllllllllllIlllllIlIIllIlIlllI = 0.0;
                for (int lllllllllllllIlllllIlIIlllIIIlll = 0; lllllllllllllIlllllIlIIlllIIIlll < lllllllllllllIlllllIlIIllIllIlII - 1; ++lllllllllllllIlllllIlIIlllIIIlll) {
                    lllllllllllllIlllllIlIIllIlIlllI += lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIIlll] * lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIIlll];
                }
                lllllllllllllIlllllIlIIllIlIlllI = 2.0 / lllllllllllllIlllllIlIIllIlIlllI;
                for (int lllllllllllllIlllllIlIIlllIIIlII = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIlllIIIlII < lllllllllllllIlllllIlIIllIllIlII; ++lllllllllllllIlllllIlIIlllIIIlII) {
                    for (int lllllllllllllIlllllIlIIllIlllIlI = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIllIlllIlI < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIllIlllIlI) {
                        lllllllllllllIlllllIlIIllIlIIIll.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIllIlllIlI] = -lllllllllllllIlllllIlIIllIlIlllI * lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIlllIIIlII - lllllllllllllIlllllIlIIllIllIIll - 1] * lllllllllllllIlllllIlIIllIlIIIIl[lllllllllllllIlllllIlIIllIlllIlI - lllllllllllllIlllllIlIIllIllIIll - 1];
                    }
                }
                for (int lllllllllllllIlllllIlIIlllIIIlll = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIlllIIIlll < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIlllIIIlll) {
                    final double[] array4 = lllllllllllllIlllllIlIIllIlIIIll.values[lllllllllllllIlllllIlIIlllIIIlll];
                    final int n4 = lllllllllllllIlllllIlIIlllIIIlll;
                    ++array4[n4];
                }
                double lllllllllllllIlllllIlIIllIlIllII = 0.0;
                for (int lllllllllllllIlllllIlIIlllIIIlll = lllllllllllllIlllllIlIIllIllIIll; lllllllllllllIlllllIlIIlllIIIlll < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIlllIIIlll) {
                    lllllllllllllIlllllIlIIllIlIllII += lllllllllllllIlllllIlIIllIlIIIll.values[lllllllllllllIlllllIlIIlllIIIlll][lllllllllllllIlllllIlIIllIllIIll + 1] * lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIlllIIIlll];
                }
                lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIllIllIIll][lllllllllllllIlllllIlIIllIllIIll + 1] = lllllllllllllIlllllIlIIllIlIllII;
                for (int lllllllllllllIlllllIlIIlllIIIlII = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIlllIIIlII < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlII) {
                    for (int lllllllllllllIlllllIlIIllIlllIIl = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIllIlllIIl < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIllIlllIIl) {
                        lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIllIlllIIl] = 0.0;
                        for (int lllllllllllllIlllllIlIIlllIIIlll = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIlllIIIlll < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIlllIIIlll) {
                            final double[] array5 = lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlII];
                            final int n5 = lllllllllllllIlllllIlIIllIlllIIl;
                            array5[n5] += lllllllllllllIlllllIlIIllIlIIIll.values[lllllllllllllIlllllIlIIlllIIIlll][lllllllllllllIlllllIlIIllIlllIIl] * lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIlllIIIlll];
                        }
                    }
                }
                for (int lllllllllllllIlllllIlIIlllIIIlII = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIlllIIIlII < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlII) {
                    for (int lllllllllllllIlllllIlIIllIlllIII = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIllIlllIII < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIllIlllIII) {
                        lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIllIlllIII] = lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIllIlllIII];
                    }
                }
                for (int lllllllllllllIlllllIlIIlllIIIlII = 0; lllllllllllllIlllllIlIIlllIIIlII < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlII) {
                    for (int lllllllllllllIlllllIlIIllIllIlll = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIllIllIlll < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIllIllIlll) {
                        lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIllIllIlll] = 0.0;
                        for (int lllllllllllllIlllllIlIIlllIIIlll = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIlllIIIlll < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIlllIIIlll) {
                            final double[] array6 = lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlII];
                            final int n6 = lllllllllllllIlllllIlIIllIllIlll;
                            array6[n6] += lllllllllllllIlllllIlIIllIlIIIll.values[lllllllllllllIlllllIlIIlllIIIlll][lllllllllllllIlllllIlIIllIllIlll] * lllllllllllllIlllllIlIIlllIIlIIl.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIlllIIIlll];
                        }
                    }
                }
                for (int lllllllllllllIlllllIlIIlllIIIlII = 0; lllllllllllllIlllllIlIIlllIIIlII < lllllllllllllIlllllIlIIllIlIIIlI.nRow; ++lllllllllllllIlllllIlIIlllIIIlII) {
                    for (int lllllllllllllIlllllIlIIllIllIllI = lllllllllllllIlllllIlIIllIllIIll + 1; lllllllllllllIlllllIlIIllIllIllI < lllllllllllllIlllllIlIIllIlIIIlI.nCol; ++lllllllllllllIlllllIlIIllIllIllI) {
                        lllllllllllllIlllllIlIIlllIIlIIl.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIllIllIllI] = lllllllllllllIlllllIlIIllIlIIlIl.values[lllllllllllllIlllllIlIIlllIIIlII][lllllllllllllIlllllIlIIllIllIllI];
                    }
                }
                --lllllllllllllIlllllIlIIllIllIlII;
            }
        }
        for (int lllllllllllllIlllllIlIIlllIIIllI = 0; lllllllllllllIlllllIlIIlllIIIllI < lllllllllllllIlllllIlIIllIlIlIII; ++lllllllllllllIlllllIlIIlllIIIllI) {
            lllllllllllllIlllllIlIIllIlIIIII[lllllllllllllIlllllIlIIlllIIIllI] = lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIIllI][lllllllllllllIlllllIlIIlllIIIllI];
        }
        for (int lllllllllllllIlllllIlIIlllIIIllI = 0; lllllllllllllIlllllIlIIlllIIIllI < lllllllllllllIlllllIlIIllIlIlIlI; ++lllllllllllllIlllllIlIIlllIIIllI) {
            lllllllllllllIlllllIlIIllIIlllll[lllllllllllllIlllllIlIIlllIIIllI] = lllllllllllllIlllllIlIIllIlIIIlI.values[lllllllllllllIlllllIlIIlllIIIllI][lllllllllllllIlllllIlIIlllIIIllI + 1];
        }
        if (lllllllllllllIlllllIlIIllIlIIIlI.nRow == 2 && lllllllllllllIlllllIlIIllIlIIIlI.nCol == 2) {
            final double[] lllllllllllllIlllllIlIIllIIllllI = { 0.0 };
            final double[] lllllllllllllIlllllIlIIllIIlllIl = { 0.0 };
            final double[] lllllllllllllIlllllIlIIllIIlllII = { 0.0 };
            final double[] lllllllllllllIlllllIlIIllIIllIll = { 0.0 };
            compute_2X2(lllllllllllllIlllllIlIIllIlIIIII[0], lllllllllllllIlllllIlIIllIIlllll[0], lllllllllllllIlllllIlIIllIlIIIII[1], lllllllllllllIlllllIlIIllIlIIIII, lllllllllllllIlllllIlIIllIIlllII, lllllllllllllIlllllIlIIllIIllllI, lllllllllllllIlllllIlIIllIIllIll, lllllllllllllIlllllIlIIllIIlllIl, 0);
            update_u(0, lllllllllllllIlllllIlIIllIIllIIl, lllllllllllllIlllllIlIIllIIllllI, lllllllllllllIlllllIlIIllIIlllII);
            update_v(0, lllllllllllllIlllllIlIIlllIIlIIl, lllllllllllllIlllllIlIIllIIlllIl, lllllllllllllIlllllIlIIllIIllIll);
            return 2;
        }
        compute_qr(0, lllllllllllllIlllllIlIIllIIlllll.length - 1, lllllllllllllIlllllIlIIllIlIIIII, lllllllllllllIlllllIlIIllIIlllll, lllllllllllllIlllllIlIIllIIllIIl, lllllllllllllIlllllIlIIlllIIlIIl);
        lllllllllllllIlllllIlIIllIllIIlI = lllllllllllllIlllllIlIIllIlIIIII.length;
        return lllllllllllllIlllllIlIIllIllIIlI;
    }
    
    public boolean equals(final GMatrix lllllllllllllIlllllIlIllIIIllllI) {
        try {
            if (this.nRow != lllllllllllllIlllllIlIllIIIllllI.nRow || this.nCol != lllllllllllllIlllllIlIllIIIllllI.nCol) {
                return false;
            }
            for (int lllllllllllllIlllllIlIllIIlIIIlI = 0; lllllllllllllIlllllIlIllIIlIIIlI < this.nRow; ++lllllllllllllIlllllIlIllIIlIIIlI) {
                for (int lllllllllllllIlllllIlIllIIlIIIIl = 0; lllllllllllllIlllllIlIllIIlIIIIl < this.nCol; ++lllllllllllllIlllllIlIllIIlIIIIl) {
                    if (this.values[lllllllllllllIlllllIlIllIIlIIIlI][lllllllllllllIlllllIlIllIIlIIIIl] != lllllllllllllIlllllIlIllIIIllllI.values[lllllllllllllIlllllIlIllIIlIIIlI][lllllllllllllIlllllIlIllIIlIIIIl]) {
                        return false;
                    }
                }
            }
            return true;
        }
        catch (NullPointerException lllllllllllllIlllllIlIllIIlIIIII) {
            return false;
        }
    }
    
    public final void mul(final GVector lllllllllllllIlllllIllIlIlIlIlll, final GVector lllllllllllllIlllllIllIlIlIllIll) {
        if (this.nRow < lllllllllllllIlllllIllIlIlIlIlll.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix2"));
        }
        if (this.nCol < lllllllllllllIlllllIllIlIlIllIll.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix3"));
        }
        for (int lllllllllllllIlllllIllIlIlIllIlI = 0; lllllllllllllIlllllIllIlIlIllIlI < lllllllllllllIlllllIllIlIlIlIlll.getSize(); ++lllllllllllllIlllllIllIlIlIllIlI) {
            for (int lllllllllllllIlllllIllIlIlIllIIl = 0; lllllllllllllIlllllIllIlIlIllIIl < lllllllllllllIlllllIllIlIlIllIll.getSize(); ++lllllllllllllIlllllIllIlIlIllIIl) {
                this.values[lllllllllllllIlllllIllIlIlIllIlI][lllllllllllllIlllllIllIlIlIllIIl] = lllllllllllllIlllllIllIlIlIlIlll.values[lllllllllllllIlllllIllIlIlIllIlI] * lllllllllllllIlllllIllIlIlIllIll.values[lllllllllllllIlllllIllIlIlIllIIl];
            }
        }
    }
    
    public Object clone() {
        GMatrix lllllllllllllIlllllIIlllIIlIllll = null;
        try {
            lllllllllllllIlllllIIlllIIlIllll = (GMatrix)super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIlllllIIlllIIlIlllI) {
            throw new InternalError();
        }
        lllllllllllllIlllllIIlllIIlIllll.values = new double[this.nRow][this.nCol];
        for (int lllllllllllllIlllllIIlllIIlIllIl = 0; lllllllllllllIlllllIIlllIIlIllIl < this.nRow; ++lllllllllllllIlllllIIlllIIlIllIl) {
            for (int lllllllllllllIlllllIIlllIIlIllII = 0; lllllllllllllIlllllIIlllIIlIllII < this.nCol; ++lllllllllllllIlllllIIlllIIlIllII) {
                lllllllllllllIlllllIIlllIIlIllll.values[lllllllllllllIlllllIIlllIIlIllIl][lllllllllllllIlllllIIlllIIlIllII] = this.values[lllllllllllllIlllllIIlllIIlIllIl][lllllllllllllIlllllIIlllIIlIllII];
            }
        }
        return lllllllllllllIlllllIIlllIIlIllll;
    }
    
    public final void getColumn(final int lllllllllllllIlllllIllIIIIIlIIIl, final GVector lllllllllllllIlllllIllIIIIIIllII) {
        if (lllllllllllllIlllllIllIIIIIIllII.getSize() < this.nRow) {
            lllllllllllllIlllllIllIIIIIIllII.setSize(this.nRow);
        }
        for (int lllllllllllllIlllllIllIIIIIIllll = 0; lllllllllllllIlllllIllIIIIIIllll < this.nRow; ++lllllllllllllIlllllIllIIIIIIllll) {
            lllllllllllllIlllllIllIIIIIIllII.values[lllllllllllllIlllllIllIIIIIIllll] = this.values[lllllllllllllIlllllIllIIIIIIllll][lllllllllllllIlllllIllIIIIIlIIIl];
        }
    }
    
    public final void invert(final GMatrix lllllllllllllIlllllIllIIllIlllIl) {
        this.invertGeneral(lllllllllllllIlllllIllIIllIlllIl);
    }
    
    @Deprecated
    public boolean epsilonEquals(final GMatrix lllllllllllllIlllllIlIllIIIIIllI, final float lllllllllllllIlllllIlIllIIIIIlIl) {
        return this.epsilonEquals(lllllllllllllIlllllIlIllIIIIIllI, (double)lllllllllllllIlllllIlIllIIIIIlIl);
    }
    
    public final void get(final Matrix3d lllllllllllllIlllllIllIIIIIIIlIl) {
        if (this.nRow < 3 || this.nCol < 3) {
            lllllllllllllIlllllIllIIIIIIIlIl.setZero();
            if (this.nCol > 0) {
                if (this.nRow > 0) {
                    lllllllllllllIlllllIllIIIIIIIlIl.m00 = this.values[0][0];
                    if (this.nRow > 1) {
                        lllllllllllllIlllllIllIIIIIIIlIl.m10 = this.values[1][0];
                        if (this.nRow > 2) {
                            lllllllllllllIlllllIllIIIIIIIlIl.m20 = this.values[2][0];
                        }
                    }
                }
                if (this.nCol > 1) {
                    if (this.nRow > 0) {
                        lllllllllllllIlllllIllIIIIIIIlIl.m01 = this.values[0][1];
                        if (this.nRow > 1) {
                            lllllllllllllIlllllIllIIIIIIIlIl.m11 = this.values[1][1];
                            if (this.nRow > 2) {
                                lllllllllllllIlllllIllIIIIIIIlIl.m21 = this.values[2][1];
                            }
                        }
                    }
                    if (this.nCol > 2 && this.nRow > 0) {
                        lllllllllllllIlllllIllIIIIIIIlIl.m02 = this.values[0][2];
                        if (this.nRow > 1) {
                            lllllllllllllIlllllIllIIIIIIIlIl.m12 = this.values[1][2];
                            if (this.nRow > 2) {
                                lllllllllllllIlllllIllIIIIIIIlIl.m22 = this.values[2][2];
                            }
                        }
                    }
                }
            }
        }
        else {
            lllllllllllllIlllllIllIIIIIIIlIl.m00 = this.values[0][0];
            lllllllllllllIlllllIllIIIIIIIlIl.m01 = this.values[0][1];
            lllllllllllllIlllllIllIIIIIIIlIl.m02 = this.values[0][2];
            lllllllllllllIlllllIllIIIIIIIlIl.m10 = this.values[1][0];
            lllllllllllllIlllllIllIIIIIIIlIl.m11 = this.values[1][1];
            lllllllllllllIlllllIllIIIIIIIlIl.m12 = this.values[1][2];
            lllllllllllllIlllllIllIIIIIIIlIl.m20 = this.values[2][0];
            lllllllllllllIlllllIllIIIIIIIlIl.m21 = this.values[2][1];
            lllllllllllllIlllllIllIIIIIIIlIl.m22 = this.values[2][2];
        }
    }
    
    public GMatrix(final GMatrix lllllllllllllIlllllIllIllIIIllII) {
        this.nRow = lllllllllllllIlllllIllIllIIIllII.nRow;
        this.nCol = lllllllllllllIlllllIllIllIIIllII.nCol;
        this.values = new double[this.nRow][this.nCol];
        for (int lllllllllllllIlllllIllIllIIIllll = 0; lllllllllllllIlllllIllIllIIIllll < this.nRow; ++lllllllllllllIlllllIllIllIIIllll) {
            for (int lllllllllllllIlllllIllIllIIIlllI = 0; lllllllllllllIlllllIllIllIIIlllI < this.nCol; ++lllllllllllllIlllllIllIllIIIlllI) {
                this.values[lllllllllllllIlllllIllIllIIIllll][lllllllllllllIlllllIllIllIIIlllI] = lllllllllllllIlllllIllIllIIIllII.values[lllllllllllllIlllllIllIllIIIllll][lllllllllllllIlllllIllIllIIIlllI];
            }
        }
    }
    
    public final void set(final Matrix4d lllllllllllllIlllllIllIIIllIIlIl) {
        if (this.nRow < 4 || this.nCol < 4) {
            this.values = new double[4][4];
            this.nRow = 4;
            this.nCol = 4;
        }
        this.values[0][0] = lllllllllllllIlllllIllIIIllIIlIl.m00;
        this.values[0][1] = lllllllllllllIlllllIllIIIllIIlIl.m01;
        this.values[0][2] = lllllllllllllIlllllIllIIIllIIlIl.m02;
        this.values[0][3] = lllllllllllllIlllllIllIIIllIIlIl.m03;
        this.values[1][0] = lllllllllllllIlllllIllIIIllIIlIl.m10;
        this.values[1][1] = lllllllllllllIlllllIllIIIllIIlIl.m11;
        this.values[1][2] = lllllllllllllIlllllIllIIIllIIlIl.m12;
        this.values[1][3] = lllllllllllllIlllllIllIIIllIIlIl.m13;
        this.values[2][0] = lllllllllllllIlllllIllIIIllIIlIl.m20;
        this.values[2][1] = lllllllllllllIlllllIllIIIllIIlIl.m21;
        this.values[2][2] = lllllllllllllIlllllIllIIIllIIlIl.m22;
        this.values[2][3] = lllllllllllllIlllllIllIIIllIIlIl.m23;
        this.values[3][0] = lllllllllllllIlllllIllIIIllIIlIl.m30;
        this.values[3][1] = lllllllllllllIlllllIllIIIllIIlIl.m31;
        this.values[3][2] = lllllllllllllIlllllIllIIIllIIlIl.m32;
        this.values[3][3] = lllllllllllllIlllllIllIIIllIIlIl.m33;
        for (int lllllllllllllIlllllIllIIIllIlIII = 4; lllllllllllllIlllllIllIIIllIlIII < this.nRow; ++lllllllllllllIlllllIllIIIllIlIII) {
            for (int lllllllllllllIlllllIllIIIllIIlll = 4; lllllllllllllIlllllIllIIIllIIlll < this.nCol; ++lllllllllllllIlllllIllIIIllIIlll) {
                this.values[lllllllllllllIlllllIllIIIllIlIII][lllllllllllllIlllllIllIIIllIIlll] = 0.0;
            }
        }
    }
    
    static double min(final double lllllllllllllIlllllIlIIIIIlIIlIl, final double lllllllllllllIlllllIlIIIIIlIIllI) {
        if (lllllllllllllIlllllIlIIIIIlIIlIl < lllllllllllllIlllllIlIIIIIlIIllI) {
            return lllllllllllllIlllllIlIIIIIlIIlIl;
        }
        return lllllllllllllIlllllIlIIIIIlIIllI;
    }
    
    public final void setRow(final int lllllllllllllIlllllIlIllllIIIlll, final GVector lllllllllllllIlllllIlIllllIIlIlI) {
        for (int lllllllllllllIlllllIlIllllIIlIIl = 0; lllllllllllllIlllllIlIllllIIlIIl < this.nCol; ++lllllllllllllIlllllIlIllllIIlIIl) {
            this.values[lllllllllllllIlllllIlIllllIIIlll][lllllllllllllIlllllIlIllllIIlIIl] = lllllllllllllIlllllIlIllllIIlIlI.values[lllllllllllllIlllllIlIllllIIlIIl];
        }
    }
    
    private static void update_v_split(final int lllllllllllllIlllllIlIIIlIIllIII, final int lllllllllllllIlllllIlIIIlIIIlllI, final GMatrix lllllllllllllIlllllIlIIIlIIlIllI, final double[] lllllllllllllIlllllIlIIIlIIlIlIl, final double[] lllllllllllllIlllllIlIIIlIIlIlII, final GMatrix lllllllllllllIlllllIlIIIlIIlIIll, final GMatrix lllllllllllllIlllllIlIIIlIIIlIIl) {
        for (int lllllllllllllIlllllIlIIIlIIlIIIl = 0; lllllllllllllIlllllIlIIIlIIlIIIl < lllllllllllllIlllllIlIIIlIIlIllI.nRow; ++lllllllllllllIlllllIlIIIlIIlIIIl) {
            final double lllllllllllllIlllllIlIIIlIIlIIII = lllllllllllllIlllllIlIIIlIIlIllI.values[lllllllllllllIlllllIlIIIlIIlIIIl][lllllllllllllIlllllIlIIIlIIllIII];
            lllllllllllllIlllllIlIIIlIIlIllI.values[lllllllllllllIlllllIlIIIlIIlIIIl][lllllllllllllIlllllIlIIIlIIllIII] = lllllllllllllIlllllIlIIIlIIlIlIl[0] * lllllllllllllIlllllIlIIIlIIlIIII - lllllllllllllIlllllIlIIIlIIlIlII[0] * lllllllllllllIlllllIlIIIlIIlIllI.values[lllllllllllllIlllllIlIIIlIIlIIIl][lllllllllllllIlllllIlIIIlIIIlllI];
            lllllllllllllIlllllIlIIIlIIlIllI.values[lllllllllllllIlllllIlIIIlIIlIIIl][lllllllllllllIlllllIlIIIlIIIlllI] = lllllllllllllIlllllIlIIIlIIlIlII[0] * lllllllllllllIlllllIlIIIlIIlIIII + lllllllllllllIlllllIlIIIlIIlIlIl[0] * lllllllllllllIlllllIlIIIlIIlIllI.values[lllllllllllllIlllllIlIIIlIIlIIIl][lllllllllllllIlllllIlIIIlIIIlllI];
        }
        System.out.println(String.valueOf(new StringBuilder("topr    =").append(lllllllllllllIlllllIlIIIlIIllIII)));
        System.out.println(String.valueOf(new StringBuilder("bottomr =").append(lllllllllllllIlllllIlIIIlIIIlllI)));
        System.out.println(String.valueOf(new StringBuilder("cosr =").append(lllllllllllllIlllllIlIIIlIIlIlIl[0])));
        System.out.println(String.valueOf(new StringBuilder("sinr =").append(lllllllllllllIlllllIlIIIlIIlIlII[0])));
        System.out.println("\nm =");
        checkMatrix(lllllllllllllIlllllIlIIIlIIIlIIl);
        System.out.println("\nv =");
        checkMatrix(lllllllllllllIlllllIlIIIlIIlIIll);
        lllllllllllllIlllllIlIIIlIIIlIIl.mul(lllllllllllllIlllllIlIIIlIIIlIIl, lllllllllllllIlllllIlIIIlIIlIIll);
        System.out.println("\nt*m =");
        checkMatrix(lllllllllllllIlllllIlIIIlIIIlIIl);
    }
    
    public final void mul(final GMatrix lllllllllllllIlllllIllIlIlllllII) {
        if (this.nCol != lllllllllllllIlllllIllIlIlllllII.nRow || this.nCol != lllllllllllllIlllllIllIlIlllllII.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix0"));
        }
        final double[][] lllllllllllllIlllllIllIlIllllllI = new double[this.nRow][this.nCol];
        for (int lllllllllllllIlllllIllIllIIIIIIl = 0; lllllllllllllIlllllIllIllIIIIIIl < this.nRow; ++lllllllllllllIlllllIllIllIIIIIIl) {
            for (int lllllllllllllIlllllIllIllIIIIIII = 0; lllllllllllllIlllllIllIllIIIIIII < this.nCol; ++lllllllllllllIlllllIllIllIIIIIII) {
                lllllllllllllIlllllIllIlIllllllI[lllllllllllllIlllllIllIllIIIIIIl][lllllllllllllIlllllIllIllIIIIIII] = 0.0;
                for (int lllllllllllllIlllllIllIlIlllllll = 0; lllllllllllllIlllllIllIlIlllllll < this.nCol; ++lllllllllllllIlllllIllIlIlllllll) {
                    final double[] array = lllllllllllllIlllllIllIlIllllllI[lllllllllllllIlllllIllIllIIIIIIl];
                    final int n = lllllllllllllIlllllIllIllIIIIIII;
                    array[n] += this.values[lllllllllllllIlllllIllIllIIIIIIl][lllllllllllllIlllllIllIlIlllllll] * lllllllllllllIlllllIllIlIlllllII.values[lllllllllllllIlllllIllIlIlllllll][lllllllllllllIlllllIllIllIIIIIII];
                }
            }
        }
        this.values = lllllllllllllIlllllIllIlIllllllI;
    }
    
    static void compute_qr(final int lllllllllllllIlllllIlIIlIllIIlll, int lllllllllllllIlllllIlIIlIlIIIlll, final double[] lllllllllllllIlllllIlIIlIlIIIlII, final double[] lllllllllllllIlllllIlIIlIllIIlII, final GMatrix lllllllllllllIlllllIlIIlIlIIIIIl, final GMatrix lllllllllllllIlllllIlIIlIlIIIIII) {
        final double[] lllllllllllllIlllllIlIIlIlIlIlIl = { 0.0 };
        final double[] lllllllllllllIlllllIlIIlIlIlIlII = { 0.0 };
        final double[] lllllllllllllIlllllIlIIlIlIlIIlI = { 0.0 };
        final double[] lllllllllllllIlllllIlIIlIlIlIIIl = { 0.0 };
        final GMatrix lllllllllllllIlllllIlIIlIlIlIIII = new GMatrix(lllllllllllllIlllllIlIIlIlIIIIIl.nCol, lllllllllllllIlllllIlIIlIlIIIIII.nRow);
        final int lllllllllllllIlllllIlIIlIlIIllll = 2;
        final double lllllllllllllIlllllIlIIlIlIIllIl = 4.89E-15;
        final double lllllllllllllIlllllIlIIlIlIIllII = 1.0;
        final double lllllllllllllIlllllIlIIlIlIIlIlI = -1.0;
        boolean lllllllllllllIlllllIlIIlIlIllIll = false;
        double lllllllllllllIlllllIlIIlIlIlIlll = 0.0;
        double lllllllllllllIlllllIlIIlIlIlIllI = 0.0;
        for (int lllllllllllllIlllllIlIIlIlIlllll = 0; lllllllllllllIlllllIlIIlIlIlllll < 2 && !lllllllllllllIlllllIlIIlIlIllIll; ++lllllllllllllIlllllIlIIlIlIlllll) {
            int lllllllllllllIlllllIlIIlIllIIIIl;
            for (lllllllllllllIlllllIlIIlIllIIIIl = lllllllllllllIlllllIlIIlIllIIlll; lllllllllllllIlllllIlIIlIllIIIIl <= lllllllllllllIlllllIlIIlIlIIIlll; ++lllllllllllllIlllllIlIIlIllIIIIl) {
                if (lllllllllllllIlllllIlIIlIllIIIIl == lllllllllllllIlllllIlIIlIllIIlll) {
                    int lllllllllllllIlllllIlIIlIlIlllII = 0;
                    if (lllllllllllllIlllllIlIIlIllIIlII.length == lllllllllllllIlllllIlIIlIlIIIlII.length) {
                        final int lllllllllllllIlllllIlIIlIlIlllIl = lllllllllllllIlllllIlIIlIlIIIlll;
                    }
                    else {
                        lllllllllllllIlllllIlIIlIlIlllII = lllllllllllllIlllllIlIIlIlIIIlll + 1;
                    }
                    final double lllllllllllllIlllllIlIIlIlIllIlI = compute_shift(lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIlIlllII - 1], lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIlIIIlll], lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIlIlllII]);
                    lllllllllllllIlllllIlIIlIlIlIlll = (Math.abs(lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl]) - lllllllllllllIlllllIlIIlIlIllIlI) * (d_sign(lllllllllllllIlllllIlIIlIlIIllII, lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl]) + lllllllllllllIlllllIlIIlIlIllIlI / lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl]);
                    lllllllllllllIlllllIlIIlIlIlIllI = lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl];
                }
                double lllllllllllllIlllllIlIIlIlIllIIl = compute_rot(lllllllllllllIlllllIlIIlIlIlIlll, lllllllllllllIlllllIlIIlIlIlIllI, lllllllllllllIlllllIlIIlIlIlIIIl, lllllllllllllIlllllIlIIlIlIlIlII);
                if (lllllllllllllIlllllIlIIlIllIIIIl != lllllllllllllIlllllIlIIlIllIIlll) {
                    lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl - 1] = lllllllllllllIlllllIlIIlIlIllIIl;
                }
                lllllllllllllIlllllIlIIlIlIlIlll = lllllllllllllIlllllIlIIlIlIlIlII[0] * lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl] + lllllllllllllIlllllIlIIlIlIlIIIl[0] * lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl];
                lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl] = lllllllllllllIlllllIlIIlIlIlIlII[0] * lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl] - lllllllllllllIlllllIlIIlIlIlIIIl[0] * lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl];
                lllllllllllllIlllllIlIIlIlIlIllI = lllllllllllllIlllllIlIIlIlIlIIIl[0] * lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl + 1];
                lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl + 1] *= lllllllllllllIlllllIlIIlIlIlIlII[0];
                update_v(lllllllllllllIlllllIlIIlIllIIIIl, lllllllllllllIlllllIlIIlIlIIIIII, lllllllllllllIlllllIlIIlIlIlIlII, lllllllllllllIlllllIlIIlIlIlIIIl);
                lllllllllllllIlllllIlIIlIlIllIIl = compute_rot(lllllllllllllIlllllIlIIlIlIlIlll, lllllllllllllIlllllIlIIlIlIlIllI, lllllllllllllIlllllIlIIlIlIlIIlI, lllllllllllllIlllllIlIIlIlIlIlIl);
                lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl] = lllllllllllllIlllllIlIIlIlIllIIl;
                lllllllllllllIlllllIlIIlIlIlIlll = lllllllllllllIlllllIlIIlIlIlIlIl[0] * lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl] + lllllllllllllIlllllIlIIlIlIlIIlI[0] * lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl + 1];
                lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl + 1] = lllllllllllllIlllllIlIIlIlIlIlIl[0] * lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl + 1] - lllllllllllllIlllllIlIIlIlIlIIlI[0] * lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl];
                if (lllllllllllllIlllllIlIIlIllIIIIl < lllllllllllllIlllllIlIIlIlIIIlll) {
                    lllllllllllllIlllllIlIIlIlIlIllI = lllllllllllllIlllllIlIIlIlIlIIlI[0] * lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl + 1];
                    lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl + 1] *= lllllllllllllIlllllIlIIlIlIlIlIl[0];
                }
                update_u(lllllllllllllIlllllIlIIlIllIIIIl, lllllllllllllIlllllIlIIlIlIIIIIl, lllllllllllllIlllllIlIIlIlIlIlIl, lllllllllllllIlllllIlIIlIlIlIIlI);
            }
            if (lllllllllllllIlllllIlIIlIlIIIlII.length == lllllllllllllIlllllIlIIlIllIIlII.length) {
                final double lllllllllllllIlllllIlIIlIlIllIII = compute_rot(lllllllllllllIlllllIlIIlIlIlIlll, lllllllllllllIlllllIlIIlIlIlIllI, lllllllllllllIlllllIlIIlIlIlIIIl, lllllllllllllIlllllIlIIlIlIlIlII);
                lllllllllllllIlllllIlIIlIlIlIlll = lllllllllllllIlllllIlIIlIlIlIlII[0] * lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl] + lllllllllllllIlllllIlIIlIlIlIIIl[0] * lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl];
                lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl] = lllllllllllllIlllllIlIIlIlIlIlII[0] * lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIIIl] - lllllllllllllIlllllIlIIlIlIlIIIl[0] * lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl];
                lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIIIl + 1] *= lllllllllllllIlllllIlIIlIlIlIlII[0];
                update_v(lllllllllllllIlllllIlIIlIllIIIIl, lllllllllllllIlllllIlIIlIlIIIIII, lllllllllllllIlllllIlIIlIlIlIlII, lllllllllllllIlllllIlIIlIlIlIIIl);
            }
            while (lllllllllllllIlllllIlIIlIlIIIlll - lllllllllllllIlllllIlIIlIllIIlll > 1 && Math.abs(lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIlIIIlll]) < 4.89E-15) {
                --lllllllllllllIlllllIlIIlIlIIIlll;
            }
            for (int lllllllllllllIlllllIlIIlIlIllllI = lllllllllllllIlllllIlIIlIlIIIlll - 2; lllllllllllllIlllllIlIIlIlIllllI > lllllllllllllIlllllIlIIlIllIIlll; --lllllllllllllIlllllIlIIlIlIllllI) {
                if (Math.abs(lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIlIllllI]) < 4.89E-15) {
                    compute_qr(lllllllllllllIlllllIlIIlIlIllllI + 1, lllllllllllllIlllllIlIIlIlIIIlll, lllllllllllllIlllllIlIIlIlIIIlII, lllllllllllllIlllllIlIIlIllIIlII, lllllllllllllIlllllIlIIlIlIIIIIl, lllllllllllllIlllllIlIIlIlIIIIII);
                    for (lllllllllllllIlllllIlIIlIlIIIlll = lllllllllllllIlllllIlIIlIlIllllI - 1; lllllllllllllIlllllIlIIlIlIIIlll - lllllllllllllIlllllIlIIlIllIIlll > 1 && Math.abs(lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIlIIIlll]) < 4.89E-15; --lllllllllllllIlllllIlIIlIlIIIlll) {}
                }
            }
            if (lllllllllllllIlllllIlIIlIlIIIlll - lllllllllllllIlllllIlIIlIllIIlll <= 1 && Math.abs(lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIlll + 1]) < 4.89E-15) {
                lllllllllllllIlllllIlIIlIlIllIll = true;
            }
        }
        if (Math.abs(lllllllllllllIlllllIlIIlIllIIlII[1]) < 4.89E-15) {
            compute_2X2(lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIlll], lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIlll], lllllllllllllIlllllIlIIlIlIIIlII[lllllllllllllIlllllIlIIlIllIIlll + 1], lllllllllllllIlllllIlIIlIlIIIlII, lllllllllllllIlllllIlIIlIlIlIIlI, lllllllllllllIlllllIlIIlIlIlIlIl, lllllllllllllIlllllIlIIlIlIlIIIl, lllllllllllllIlllllIlIIlIlIlIlII, 0);
            lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIlll + 1] = (lllllllllllllIlllllIlIIlIllIIlII[lllllllllllllIlllllIlIIlIllIIlll] = 0.0);
        }
        final int lllllllllllllIlllllIlIIlIllIIIII = lllllllllllllIlllllIlIIlIllIIlll;
        update_u(lllllllllllllIlllllIlIIlIllIIIII, lllllllllllllIlllllIlIIlIlIIIIIl, lllllllllllllIlllllIlIIlIlIlIlIl, lllllllllllllIlllllIlIIlIlIlIIlI);
        update_v(lllllllllllllIlllllIlIIlIllIIIII, lllllllllllllIlllllIlIIlIlIIIIII, lllllllllllllIlllllIlIIlIlIlIlII, lllllllllllllIlllllIlIIlIlIlIIIl);
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIlllllIlIllIIlIllll = 1L;
        lllllllllllllIlllllIlIllIIlIllll = VecMathUtil.hashLongBits(lllllllllllllIlllllIlIllIIlIllll, this.nRow);
        lllllllllllllIlllllIlIllIIlIllll = VecMathUtil.hashLongBits(lllllllllllllIlllllIlIllIIlIllll, this.nCol);
        for (int lllllllllllllIlllllIlIllIIlIlllI = 0; lllllllllllllIlllllIlIllIIlIlllI < this.nRow; ++lllllllllllllIlllllIlIllIIlIlllI) {
            for (int lllllllllllllIlllllIlIllIIlIllIl = 0; lllllllllllllIlllllIlIllIIlIllIl < this.nCol; ++lllllllllllllIlllllIlIllIIlIllIl) {
                lllllllllllllIlllllIlIllIIlIllll = VecMathUtil.hashDoubleBits(lllllllllllllIlllllIlIllIIlIllll, this.values[lllllllllllllIlllllIlIllIIlIlllI][lllllllllllllIlllllIlIllIIlIllIl]);
            }
        }
        return VecMathUtil.hashFinish(lllllllllllllIlllllIlIllIIlIllll);
    }
    
    public final double trace() {
        int lllllllllllllIlllllIlIlIlllIlIII = 0;
        if (this.nRow < this.nCol) {
            final int lllllllllllllIlllllIlIlIlllIlIIl = this.nRow;
        }
        else {
            lllllllllllllIlllllIlIlIlllIlIII = this.nCol;
        }
        double lllllllllllllIlllllIlIlIlllIIlll = 0.0;
        for (int lllllllllllllIlllllIlIlIlllIlIlI = 0; lllllllllllllIlllllIlIlIlllIlIlI < lllllllllllllIlllllIlIlIlllIlIII; ++lllllllllllllIlllllIlIlIlllIlIlI) {
            lllllllllllllIlllllIlIlIlllIIlll += this.values[lllllllllllllIlllllIlIlIlllIlIlI][lllllllllllllIlllllIlIlIlllIlIlI];
        }
        return lllllllllllllIlllllIlIlIlllIIlll;
    }
    
    public final int getNumCol() {
        return this.nCol;
    }
    
    static double max(final double lllllllllllllIlllllIlIIIIIlIlIll, final double lllllllllllllIlllllIlIIIIIlIllII) {
        if (lllllllllllllIlllllIlIIIIIlIlIll > lllllllllllllIlllllIlIIIIIlIllII) {
            return lllllllllllllIlllllIlIIIIIlIlIll;
        }
        return lllllllllllllIlllllIlIIIIIlIllII;
    }
    
    static void luBacksubstitution(final int lllllllllllllIlllllIlIlIIIlIllII, final double[] lllllllllllllIlllllIlIlIIIlIlIll, final int[] lllllllllllllIlllllIlIlIIIlIlIlI, final double[] lllllllllllllIlllllIlIlIIIlIlIIl) {
        final int lllllllllllllIlllllIlIlIIIlIIIlI = 0;
        for (int lllllllllllllIlllllIlIlIIIlIIIll = 0; lllllllllllllIlllllIlIlIIIlIIIll < lllllllllllllIlllllIlIlIIIlIllII; ++lllllllllllllIlllllIlIlIIIlIIIll) {
            final int lllllllllllllIlllllIlIlIIIlIIIIl = lllllllllllllIlllllIlIlIIIlIIIll;
            int lllllllllllllIlllllIlIlIIIlIIlll = -1;
            for (int lllllllllllllIlllllIlIlIIIlIlIII = 0; lllllllllllllIlllllIlIlIIIlIlIII < lllllllllllllIlllllIlIlIIIlIllII; ++lllllllllllllIlllllIlIlIIIlIlIII) {
                final int lllllllllllllIlllllIlIlIIIlIIllI = lllllllllllllIlllllIlIlIIIlIlIlI[lllllllllllllIlllllIlIlIIIlIIIlI + lllllllllllllIlllllIlIlIIIlIlIII];
                double lllllllllllllIlllllIlIlIIIIlllII = lllllllllllllIlllllIlIlIIIlIlIIl[lllllllllllllIlllllIlIlIIIlIIIIl + lllllllllllllIlllllIlIlIIIlIllII * lllllllllllllIlllllIlIlIIIlIIllI];
                lllllllllllllIlllllIlIlIIIlIlIIl[lllllllllllllIlllllIlIlIIIlIIIIl + lllllllllllllIlllllIlIlIIIlIllII * lllllllllllllIlllllIlIlIIIlIIllI] = lllllllllllllIlllllIlIlIIIlIlIIl[lllllllllllllIlllllIlIlIIIlIIIIl + lllllllllllllIlllllIlIlIIIlIllII * lllllllllllllIlllllIlIlIIIlIlIII];
                if (lllllllllllllIlllllIlIlIIIlIIlll >= 0) {
                    final int lllllllllllllIlllllIlIlIIIlIIIII = lllllllllllllIlllllIlIlIIIlIlIII * lllllllllllllIlllllIlIlIIIlIllII;
                    for (int lllllllllllllIlllllIlIlIIIlIIlIl = lllllllllllllIlllllIlIlIIIlIIlll; lllllllllllllIlllllIlIlIIIlIIlIl <= lllllllllllllIlllllIlIlIIIlIlIII - 1; ++lllllllllllllIlllllIlIlIIIlIIlIl) {
                        lllllllllllllIlllllIlIlIIIIlllII -= lllllllllllllIlllllIlIlIIIlIlIll[lllllllllllllIlllllIlIlIIIlIIIII + lllllllllllllIlllllIlIlIIIlIIlIl] * lllllllllllllIlllllIlIlIIIlIlIIl[lllllllllllllIlllllIlIlIIIlIIIIl + lllllllllllllIlllllIlIlIIIlIllII * lllllllllllllIlllllIlIlIIIlIIlIl];
                    }
                }
                else if (lllllllllllllIlllllIlIlIIIIlllII != 0.0) {
                    lllllllllllllIlllllIlIlIIIlIIlll = lllllllllllllIlllllIlIlIIIlIlIII;
                }
                lllllllllllllIlllllIlIlIIIlIlIIl[lllllllllllllIlllllIlIlIIIlIIIIl + lllllllllllllIlllllIlIlIIIlIllII * lllllllllllllIlllllIlIlIIIlIlIII] = lllllllllllllIlllllIlIlIIIIlllII;
            }
            for (int lllllllllllllIlllllIlIlIIIlIlIII = 0; lllllllllllllIlllllIlIlIIIlIlIII < lllllllllllllIlllllIlIlIIIlIllII; ++lllllllllllllIlllllIlIlIIIlIlIII) {
                final int lllllllllllllIlllllIlIlIIIIllllI = lllllllllllllIlllllIlIlIIIlIllII - 1 - lllllllllllllIlllllIlIlIIIlIlIII;
                final int lllllllllllllIlllllIlIlIIIIlllll = lllllllllllllIlllllIlIlIIIlIllII * lllllllllllllIlllllIlIlIIIIllllI;
                double lllllllllllllIlllllIlIlIIIIlllIl = 0.0;
                for (int lllllllllllllIlllllIlIlIIIlIIlII = 1; lllllllllllllIlllllIlIlIIIlIIlII <= lllllllllllllIlllllIlIlIIIlIlIII; ++lllllllllllllIlllllIlIlIIIlIIlII) {
                    lllllllllllllIlllllIlIlIIIIlllIl += lllllllllllllIlllllIlIlIIIlIlIll[lllllllllllllIlllllIlIlIIIIlllll + lllllllllllllIlllllIlIlIIIlIllII - lllllllllllllIlllllIlIlIIIlIIlII] * lllllllllllllIlllllIlIlIIIlIlIIl[lllllllllllllIlllllIlIlIIIlIIIIl + lllllllllllllIlllllIlIlIIIlIllII * (lllllllllllllIlllllIlIlIIIlIllII - lllllllllllllIlllllIlIlIIIlIIlII)];
                }
                lllllllllllllIlllllIlIlIIIlIlIIl[lllllllllllllIlllllIlIlIIIlIIIIl + lllllllllllllIlllllIlIlIIIlIllII * lllllllllllllIlllllIlIlIIIIllllI] = (lllllllllllllIlllllIlIlIIIlIlIIl[lllllllllllllIlllllIlIlIIIlIIIIl + lllllllllllllIlllllIlIlIIIlIllII * lllllllllllllIlllllIlIlIIIIllllI] - lllllllllllllIlllllIlIlIIIIlllIl) / lllllllllllllIlllllIlIlIIIlIlIll[lllllllllllllIlllllIlIlIIIIlllll + lllllllllllllIlllllIlIlIIIIllllI];
            }
        }
    }
    
    public final void mulTransposeRight(final GMatrix lllllllllllllIlllllIlIlllIIIIIlI, final GMatrix lllllllllllllIlllllIlIlllIIIlIll) {
        if (lllllllllllllIlllllIlIlllIIIIIlI.nCol != lllllllllllllIlllllIlIlllIIIlIll.nCol || this.nCol != lllllllllllllIlllllIlIlllIIIlIll.nRow || this.nRow != lllllllllllllIlllllIlIlllIIIIIlI.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix15"));
        }
        if (lllllllllllllIlllllIlIlllIIIIIlI == this || lllllllllllllIlllllIlIlllIIIlIll == this) {
            final double[][] lllllllllllllIlllllIlIlllIIIIlII = new double[this.nRow][this.nCol];
            for (int lllllllllllllIlllllIlIlllIIIlIlI = 0; lllllllllllllIlllllIlIlllIIIlIlI < this.nRow; ++lllllllllllllIlllllIlIlllIIIlIlI) {
                for (int lllllllllllllIlllllIlIlllIIIlIII = 0; lllllllllllllIlllllIlIlllIIIlIII < this.nCol; ++lllllllllllllIlllllIlIlllIIIlIII) {
                    lllllllllllllIlllllIlIlllIIIIlII[lllllllllllllIlllllIlIlllIIIlIlI][lllllllllllllIlllllIlIlllIIIlIII] = 0.0;
                    for (int lllllllllllllIlllllIlIlllIIIIllI = 0; lllllllllllllIlllllIlIlllIIIIllI < lllllllllllllIlllllIlIlllIIIIIlI.nCol; ++lllllllllllllIlllllIlIlllIIIIllI) {
                        final double[] array = lllllllllllllIlllllIlIlllIIIIlII[lllllllllllllIlllllIlIlllIIIlIlI];
                        final int n = lllllllllllllIlllllIlIlllIIIlIII;
                        array[n] += lllllllllllllIlllllIlIlllIIIIIlI.values[lllllllllllllIlllllIlIlllIIIlIlI][lllllllllllllIlllllIlIlllIIIIllI] * lllllllllllllIlllllIlIlllIIIlIll.values[lllllllllllllIlllllIlIlllIIIlIII][lllllllllllllIlllllIlIlllIIIIllI];
                    }
                }
            }
            this.values = lllllllllllllIlllllIlIlllIIIIlII;
        }
        else {
            for (int lllllllllllllIlllllIlIlllIIIlIIl = 0; lllllllllllllIlllllIlIlllIIIlIIl < this.nRow; ++lllllllllllllIlllllIlIlllIIIlIIl) {
                for (int lllllllllllllIlllllIlIlllIIIIlll = 0; lllllllllllllIlllllIlIlllIIIIlll < this.nCol; ++lllllllllllllIlllllIlIlllIIIIlll) {
                    this.values[lllllllllllllIlllllIlIlllIIIlIIl][lllllllllllllIlllllIlIlllIIIIlll] = 0.0;
                    for (int lllllllllllllIlllllIlIlllIIIIlIl = 0; lllllllllllllIlllllIlIlllIIIIlIl < lllllllllllllIlllllIlIlllIIIIIlI.nCol; ++lllllllllllllIlllllIlIlllIIIIlIl) {
                        final double[] array2 = this.values[lllllllllllllIlllllIlIlllIIIlIIl];
                        final int n2 = lllllllllllllIlllllIlIlllIIIIlll;
                        array2[n2] += lllllllllllllIlllllIlIlllIIIIIlI.values[lllllllllllllIlllllIlIlllIIIlIIl][lllllllllllllIlllllIlIlllIIIIlIl] * lllllllllllllIlllllIlIlllIIIlIll.values[lllllllllllllIlllllIlIlllIIIIlll][lllllllllllllIlllllIlIlllIIIIlIl];
                    }
                }
            }
        }
    }
    
    public final void transpose() {
        if (this.nRow != this.nCol) {
            int lllllllllllllIlllllIlIllIlIlllll = this.nRow;
            this.nRow = this.nCol;
            this.nCol = lllllllllllllIlllllIlIllIlIlllll;
            final double[][] lllllllllllllIlllllIlIllIlIllIll = new double[this.nRow][this.nCol];
            for (lllllllllllllIlllllIlIllIlIlllll = 0; lllllllllllllIlllllIlIllIlIlllll < this.nRow; ++lllllllllllllIlllllIlIllIlIlllll) {
                for (int lllllllllllllIlllllIlIllIlIlllIl = 0; lllllllllllllIlllllIlIllIlIlllIl < this.nCol; ++lllllllllllllIlllllIlIllIlIlllIl) {
                    lllllllllllllIlllllIlIllIlIllIll[lllllllllllllIlllllIlIllIlIlllll][lllllllllllllIlllllIlIllIlIlllIl] = this.values[lllllllllllllIlllllIlIllIlIlllIl][lllllllllllllIlllllIlIllIlIlllll];
                }
            }
            this.values = lllllllllllllIlllllIlIllIlIllIll;
        }
        else {
            for (int lllllllllllllIlllllIlIllIlIllllI = 0; lllllllllllllIlllllIlIllIlIllllI < this.nRow; ++lllllllllllllIlllllIlIllIlIllllI) {
                for (int lllllllllllllIlllllIlIllIlIlllII = 0; lllllllllllllIlllllIlIllIlIlllII < lllllllllllllIlllllIlIllIlIllllI; ++lllllllllllllIlllllIlIllIlIlllII) {
                    final double lllllllllllllIlllllIlIllIlIllIlI = this.values[lllllllllllllIlllllIlIllIlIllllI][lllllllllllllIlllllIlIllIlIlllII];
                    this.values[lllllllllllllIlllllIlIllIlIllllI][lllllllllllllIlllllIlIllIlIlllII] = this.values[lllllllllllllIlllllIlIllIlIlllII][lllllllllllllIlllllIlIllIlIllllI];
                    this.values[lllllllllllllIlllllIlIllIlIlllII][lllllllllllllIlllllIlIllIlIllllI] = lllllllllllllIlllllIlIllIlIllIlI;
                }
            }
        }
    }
    
    public final void set(final Matrix4f lllllllllllllIlllllIllIIIlllIIIl) {
        if (this.nRow < 4 || this.nCol < 4) {
            this.values = new double[4][4];
            this.nRow = 4;
            this.nCol = 4;
        }
        this.values[0][0] = lllllllllllllIlllllIllIIIlllIIIl.m00;
        this.values[0][1] = lllllllllllllIlllllIllIIIlllIIIl.m01;
        this.values[0][2] = lllllllllllllIlllllIllIIIlllIIIl.m02;
        this.values[0][3] = lllllllllllllIlllllIllIIIlllIIIl.m03;
        this.values[1][0] = lllllllllllllIlllllIllIIIlllIIIl.m10;
        this.values[1][1] = lllllllllllllIlllllIllIIIlllIIIl.m11;
        this.values[1][2] = lllllllllllllIlllllIllIIIlllIIIl.m12;
        this.values[1][3] = lllllllllllllIlllllIllIIIlllIIIl.m13;
        this.values[2][0] = lllllllllllllIlllllIllIIIlllIIIl.m20;
        this.values[2][1] = lllllllllllllIlllllIllIIIlllIIIl.m21;
        this.values[2][2] = lllllllllllllIlllllIllIIIlllIIIl.m22;
        this.values[2][3] = lllllllllllllIlllllIllIIIlllIIIl.m23;
        this.values[3][0] = lllllllllllllIlllllIllIIIlllIIIl.m30;
        this.values[3][1] = lllllllllllllIlllllIllIIIlllIIIl.m31;
        this.values[3][2] = lllllllllllllIlllllIllIIIlllIIIl.m32;
        this.values[3][3] = lllllllllllllIlllllIllIIIlllIIIl.m33;
        for (int lllllllllllllIlllllIllIIIlllIlII = 4; lllllllllllllIlllllIllIIIlllIlII < this.nRow; ++lllllllllllllIlllllIllIIIlllIlII) {
            for (int lllllllllllllIlllllIllIIIlllIIll = 4; lllllllllllllIlllllIllIIIlllIIll < this.nCol; ++lllllllllllllIlllllIllIIIlllIIll) {
                this.values[lllllllllllllIlllllIllIIIlllIlII][lllllllllllllIlllllIllIIIlllIIll] = 0.0;
            }
        }
    }
    
    private static void chase_up(final double[] lllllllllllllIlllllIlIIIlllIllIl, final double[] lllllllllllllIlllllIlIIIlllIllII, final int lllllllllllllIlllllIlIIIllIllIIl, final GMatrix lllllllllllllIlllllIlIIIlllIlIIl) {
        final double[] lllllllllllllIlllllIlIIIlllIIlII = { 0.0 };
        final double[] lllllllllllllIlllllIlIIIlllIIIll = { 0.0 };
        final GMatrix lllllllllllllIlllllIlIIIlllIIIII = new GMatrix(lllllllllllllIlllllIlIIIlllIlIIl.nRow, lllllllllllllIlllllIlIIIlllIlIIl.nCol);
        final GMatrix lllllllllllllIlllllIlIIIllIllllI = new GMatrix(lllllllllllllIlllllIlIIIlllIlIIl.nRow, lllllllllllllIlllllIlIIIlllIlIIl.nCol);
        double lllllllllllllIlllllIlIIIlllIlIII = lllllllllllllIlllllIlIIIlllIllII[lllllllllllllIlllllIlIIIllIllIIl];
        double lllllllllllllIlllllIlIIIlllIIlll = lllllllllllllIlllllIlIIIlllIllIl[lllllllllllllIlllllIlIIIllIllIIl];
        int lllllllllllllIlllllIlIIIlllIIIIl;
        for (lllllllllllllIlllllIlIIIlllIIIIl = lllllllllllllIlllllIlIIIllIllIIl; lllllllllllllIlllllIlIIIlllIIIIl > 0; --lllllllllllllIlllllIlIIIlllIIIIl) {
            final double lllllllllllllIlllllIlIIIlllIIllI = compute_rot(lllllllllllllIlllllIlIIIlllIlIII, lllllllllllllIlllllIlIIIlllIIlll, lllllllllllllIlllllIlIIIlllIIIll, lllllllllllllIlllllIlIIIlllIIlII);
            lllllllllllllIlllllIlIIIlllIlIII = -lllllllllllllIlllllIlIIIlllIllII[lllllllllllllIlllllIlIIIlllIIIIl - 1] * lllllllllllllIlllllIlIIIlllIIIll[0];
            lllllllllllllIlllllIlIIIlllIIlll = lllllllllllllIlllllIlIIIlllIllIl[lllllllllllllIlllllIlIIIlllIIIIl - 1];
            lllllllllllllIlllllIlIIIlllIllIl[lllllllllllllIlllllIlIIIlllIIIIl] = lllllllllllllIlllllIlIIIlllIIllI;
            lllllllllllllIlllllIlIIIlllIllII[lllllllllllllIlllllIlIIIlllIIIIl - 1] *= lllllllllllllIlllllIlIIIlllIIlII[0];
            update_v_split(lllllllllllllIlllllIlIIIlllIIIIl, lllllllllllllIlllllIlIIIllIllIIl + 1, lllllllllllllIlllllIlIIIlllIlIIl, lllllllllllllIlllllIlIIIlllIIlII, lllllllllllllIlllllIlIIIlllIIIll, lllllllllllllIlllllIlIIIlllIIIII, lllllllllllllIlllllIlIIIllIllllI);
        }
        lllllllllllllIlllllIlIIIlllIllIl[lllllllllllllIlllllIlIIIlllIIIIl + 1] = compute_rot(lllllllllllllIlllllIlIIIlllIlIII, lllllllllllllIlllllIlIIIlllIIlll, lllllllllllllIlllllIlIIIlllIIIll, lllllllllllllIlllllIlIIIlllIIlII);
        update_v_split(lllllllllllllIlllllIlIIIlllIIIIl, lllllllllllllIlllllIlIIIllIllIIl + 1, lllllllllllllIlllllIlIIIlllIlIIl, lllllllllllllIlllllIlIIIlllIIlII, lllllllllllllIlllllIlIIIlllIIIll, lllllllllllllIlllllIlIIIlllIIIII, lllllllllllllIlllllIlIIIllIllllI);
    }
    
    private static void update_v(final int lllllllllllllIlllllIlIIlIIIlIIIl, final GMatrix lllllllllllllIlllllIlIIlIIIllIII, final double[] lllllllllllllIlllllIlIIlIIIlIllI, final double[] lllllllllllllIlllllIlIIlIIIlIlIl) {
        for (int lllllllllllllIlllllIlIIlIIIlIlII = 0; lllllllllllllIlllllIlIIlIIIlIlII < lllllllllllllIlllllIlIIlIIIllIII.nRow; ++lllllllllllllIlllllIlIIlIIIlIlII) {
            final double lllllllllllllIlllllIlIIlIIIlIIll = lllllllllllllIlllllIlIIlIIIllIII.values[lllllllllllllIlllllIlIIlIIIlIlII][lllllllllllllIlllllIlIIlIIIlIIIl];
            lllllllllllllIlllllIlIIlIIIllIII.values[lllllllllllllIlllllIlIIlIIIlIlII][lllllllllllllIlllllIlIIlIIIlIIIl] = lllllllllllllIlllllIlIIlIIIlIllI[0] * lllllllllllllIlllllIlIIlIIIlIIll + lllllllllllllIlllllIlIIlIIIlIlIl[0] * lllllllllllllIlllllIlIIlIIIllIII.values[lllllllllllllIlllllIlIIlIIIlIlII][lllllllllllllIlllllIlIIlIIIlIIIl + 1];
            lllllllllllllIlllllIlIIlIIIllIII.values[lllllllllllllIlllllIlIIlIIIlIlII][lllllllllllllIlllllIlIIlIIIlIIIl + 1] = -lllllllllllllIlllllIlIIlIIIlIlIl[0] * lllllllllllllIlllllIlIIlIIIlIIll + lllllllllllllIlllllIlIIlIIIlIllI[0] * lllllllllllllIlllllIlIIlIIIllIII.values[lllllllllllllIlllllIlIIlIIIlIlII][lllllllllllllIlllllIlIIlIIIlIIIl + 1];
        }
    }
    
    private static String toString(final GMatrix lllllllllllllIlllllIlIIIIlIIIlIl) {
        final StringBuffer lllllllllllllIlllllIlIIIIlIIlIII = new StringBuffer(lllllllllllllIlllllIlIIIIlIIIlIl.nRow * lllllllllllllIlllllIlIIIIlIIIlIl.nCol * 8);
        for (int lllllllllllllIlllllIlIIIIlIIIlll = 0; lllllllllllllIlllllIlIIIIlIIIlll < lllllllllllllIlllllIlIIIIlIIIlIl.nRow; ++lllllllllllllIlllllIlIIIIlIIIlll) {
            for (int lllllllllllllIlllllIlIIIIlIIIllI = 0; lllllllllllllIlllllIlIIIIlIIIllI < lllllllllllllIlllllIlIIIIlIIIlIl.nCol; ++lllllllllllllIlllllIlIIIIlIIIllI) {
                if (Math.abs(lllllllllllllIlllllIlIIIIlIIIlIl.values[lllllllllllllIlllllIlIIIIlIIIlll][lllllllllllllIlllllIlIIIIlIIIllI]) < 1.0E-9) {
                    lllllllllllllIlllllIlIIIIlIIlIII.append("0.0000 ");
                }
                else {
                    lllllllllllllIlllllIlIIIIlIIlIII.append(lllllllllllllIlllllIlIIIIlIIIlIl.values[lllllllllllllIlllllIlIIIIlIIIlll][lllllllllllllIlllllIlIIIIlIIIllI]).append(" ");
                }
            }
            lllllllllllllIlllllIlIIIIlIIlIII.append("\n");
        }
        return lllllllllllllIlllllIlIIIIlIIlIII.toString();
    }
    
    private static void print_svd(final double[] lllllllllllllIlllllIlIIIIIllIlIl, final double[] lllllllllllllIlllllIlIIIIIllIlII, final GMatrix lllllllllllllIlllllIlIIIIIllIIll, final GMatrix lllllllllllllIlllllIlIIIIIllIIlI) {
        final GMatrix lllllllllllllIlllllIlIIIIIllIllI = new GMatrix(lllllllllllllIlllllIlIIIIIllIIll.nCol, lllllllllllllIlllllIlIIIIIllIIlI.nRow);
        System.out.println(" \ns = ");
        for (int lllllllllllllIlllllIlIIIIIllIlll = 0; lllllllllllllIlllllIlIIIIIllIlll < lllllllllllllIlllllIlIIIIIllIlIl.length; ++lllllllllllllIlllllIlIIIIIllIlll) {
            System.out.println(String.valueOf(new StringBuilder(" ").append(lllllllllllllIlllllIlIIIIIllIlIl[lllllllllllllIlllllIlIIIIIllIlll])));
        }
        System.out.println(" \ne = ");
        for (int lllllllllllllIlllllIlIIIIIllIlll = 0; lllllllllllllIlllllIlIIIIIllIlll < lllllllllllllIlllllIlIIIIIllIlII.length; ++lllllllllllllIlllllIlIIIIIllIlll) {
            System.out.println(String.valueOf(new StringBuilder(" ").append(lllllllllllllIlllllIlIIIIIllIlII[lllllllllllllIlllllIlIIIIIllIlll])));
        }
        System.out.println(String.valueOf(new StringBuilder(" \nu  = \n").append(lllllllllllllIlllllIlIIIIIllIIll.toString())));
        System.out.println(String.valueOf(new StringBuilder(" \nv  = \n").append(lllllllllllllIlllllIlIIIIIllIIlI.toString())));
        lllllllllllllIlllllIlIIIIIllIllI.setIdentity();
        for (int lllllllllllllIlllllIlIIIIIllIlll = 0; lllllllllllllIlllllIlIIIIIllIlll < lllllllllllllIlllllIlIIIIIllIlIl.length; ++lllllllllllllIlllllIlIIIIIllIlll) {
            lllllllllllllIlllllIlIIIIIllIllI.values[lllllllllllllIlllllIlIIIIIllIlll][lllllllllllllIlllllIlIIIIIllIlll] = lllllllllllllIlllllIlIIIIIllIlIl[lllllllllllllIlllllIlIIIIIllIlll];
        }
        for (int lllllllllllllIlllllIlIIIIIllIlll = 0; lllllllllllllIlllllIlIIIIIllIlll < lllllllllllllIlllllIlIIIIIllIlII.length; ++lllllllllllllIlllllIlIIIIIllIlll) {
            lllllllllllllIlllllIlIIIIIllIllI.values[lllllllllllllIlllllIlIIIIIllIlll][lllllllllllllIlllllIlIIIIIllIlll + 1] = lllllllllllllIlllllIlIIIIIllIlII[lllllllllllllIlllllIlIIIIIllIlll];
        }
        System.out.println(String.valueOf(new StringBuilder(" \nm  = \n").append(lllllllllllllIlllllIlIIIIIllIllI.toString())));
        lllllllllllllIlllllIlIIIIIllIllI.mulTransposeLeft(lllllllllllllIlllllIlIIIIIllIIll, lllllllllllllIlllllIlIIIIIllIllI);
        lllllllllllllIlllllIlIIIIIllIllI.mulTransposeRight(lllllllllllllIlllllIlIIIIIllIllI, lllllllllllllIlllllIlIIIIIllIIlI);
        System.out.println(String.valueOf(new StringBuilder(" \n u.transpose*m*v.transpose  = \n").append(lllllllllllllIlllllIlIIIIIllIllI.toString())));
    }
    
    private static void update_u_split(final int lllllllllllllIlllllIlIIIIlllIlII, final int lllllllllllllIlllllIlIIIIlllIIll, final GMatrix lllllllllllllIlllllIlIIIIlllIIlI, final double[] lllllllllllllIlllllIlIIIIlllIIIl, final double[] lllllllllllllIlllllIlIIIIllllIIl, final GMatrix lllllllllllllIlllllIlIIIIllllIII, final GMatrix lllllllllllllIlllllIlIIIIlllIlll) {
        for (int lllllllllllllIlllllIlIIIIlllIllI = 0; lllllllllllllIlllllIlIIIIlllIllI < lllllllllllllIlllllIlIIIIlllIIlI.nCol; ++lllllllllllllIlllllIlIIIIlllIllI) {
            final double lllllllllllllIlllllIlIIIIlllIlIl = lllllllllllllIlllllIlIIIIlllIIlI.values[lllllllllllllIlllllIlIIIIlllIlII][lllllllllllllIlllllIlIIIIlllIllI];
            lllllllllllllIlllllIlIIIIlllIIlI.values[lllllllllllllIlllllIlIIIIlllIlII][lllllllllllllIlllllIlIIIIlllIllI] = lllllllllllllIlllllIlIIIIlllIIIl[0] * lllllllllllllIlllllIlIIIIlllIlIl - lllllllllllllIlllllIlIIIIllllIIl[0] * lllllllllllllIlllllIlIIIIlllIIlI.values[lllllllllllllIlllllIlIIIIlllIIll][lllllllllllllIlllllIlIIIIlllIllI];
            lllllllllllllIlllllIlIIIIlllIIlI.values[lllllllllllllIlllllIlIIIIlllIIll][lllllllllllllIlllllIlIIIIlllIllI] = lllllllllllllIlllllIlIIIIllllIIl[0] * lllllllllllllIlllllIlIIIIlllIlIl + lllllllllllllIlllllIlIIIIlllIIIl[0] * lllllllllllllIlllllIlIIIIlllIIlI.values[lllllllllllllIlllllIlIIIIlllIIll][lllllllllllllIlllllIlIIIIlllIllI];
        }
        System.out.println("\nm=");
        checkMatrix(lllllllllllllIlllllIlIIIIlllIlll);
        System.out.println("\nu=");
        checkMatrix(lllllllllllllIlllllIlIIIIllllIII);
        lllllllllllllIlllllIlIIIIlllIlll.mul(lllllllllllllIlllllIlIIIIllllIII, lllllllllllllIlllllIlIIIIlllIlll);
        System.out.println("\nt*m=");
        checkMatrix(lllllllllllllIlllllIlIIIIlllIlll);
    }
    
    static boolean luDecomposition(final int lllllllllllllIlllllIlIlIIlIIllIl, final double[] lllllllllllllIlllllIlIlIIlIIllII, final int[] lllllllllllllIlllllIlIlIIllIlIll, final int[] lllllllllllllIlllllIlIlIIlIIlIlI) {
        final double[] lllllllllllllIlllllIlIlIIllIlIIl = new double[lllllllllllllIlllllIlIlIIlIIllIl];
        int lllllllllllllIlllllIlIlIIllIIlIl = 0;
        int lllllllllllllIlllllIlIlIIllIIlII = 0;
        lllllllllllllIlllllIlIlIIlIIlIlI[0] = 1;
        int lllllllllllllIlllllIlIlIIllIlIII = lllllllllllllIlllllIlIlIIlIIllIl;
        while (lllllllllllllIlllllIlIlIIllIlIII-- != 0) {
            double lllllllllllllIlllllIlIlIIllIIIlI = 0.0;
            int lllllllllllllIlllllIlIlIIllIIlll = lllllllllllllIlllllIlIlIIlIIllIl;
            while (lllllllllllllIlllllIlIlIIllIIlll-- != 0) {
                double lllllllllllllIlllllIlIlIIllIIIII = lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIllIIlIl++];
                lllllllllllllIlllllIlIlIIllIIIII = Math.abs(lllllllllllllIlllllIlIlIIllIIIII);
                if (lllllllllllllIlllllIlIlIIllIIIII > lllllllllllllIlllllIlIlIIllIIIlI) {
                    lllllllllllllIlllllIlIlIIllIIIlI = lllllllllllllIlllllIlIlIIllIIIII;
                }
            }
            if (lllllllllllllIlllllIlIlIIllIIIlI == 0.0) {
                return false;
            }
            lllllllllllllIlllllIlIlIIllIlIIl[lllllllllllllIlllllIlIlIIllIIlII++] = 1.0 / lllllllllllllIlllllIlIlIIllIIIlI;
        }
        final int lllllllllllllIlllllIlIlIIllIIIll = 0;
        for (int lllllllllllllIlllllIlIlIIllIIllI = 0; lllllllllllllIlllllIlIlIIllIIllI < lllllllllllllIlllllIlIlIIlIIllIl; ++lllllllllllllIlllllIlIlIIllIIllI) {
            for (lllllllllllllIlllllIlIlIIllIlIII = 0; lllllllllllllIlllllIlIlIIllIlIII < lllllllllllllIlllllIlIlIIllIIllI; ++lllllllllllllIlllllIlIlIIllIlIII) {
                final int lllllllllllllIlllllIlIlIIlIllIII = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * lllllllllllllIlllllIlIlIIllIlIII + lllllllllllllIlllllIlIlIIllIIllI;
                double lllllllllllllIlllllIlIlIIlIIllll = lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIllIII];
                int lllllllllllllIlllllIlIlIIlIllIll = lllllllllllllIlllllIlIlIIllIlIII;
                int lllllllllllllIlllllIlIlIIlIlIlIl = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * lllllllllllllIlllllIlIlIIllIlIII;
                int lllllllllllllIlllllIlIlIIlIlIIlI = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIllIIllI;
                while (lllllllllllllIlllllIlIlIIlIllIll-- != 0) {
                    lllllllllllllIlllllIlIlIIlIIllll -= lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIlIl] * lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIIlI];
                    ++lllllllllllllIlllllIlIlIIlIlIlIl;
                    lllllllllllllIlllllIlIlIIlIlIIlI += lllllllllllllIlllllIlIlIIlIIllIl;
                }
                lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIllIII] = lllllllllllllIlllllIlIlIIlIIllll;
            }
            double lllllllllllllIlllllIlIlIIllIIIIl = 0.0;
            int lllllllllllllIlllllIlIlIIlIlllII = -1;
            for (lllllllllllllIlllllIlIlIIllIlIII = lllllllllllllIlllllIlIlIIllIIllI; lllllllllllllIlllllIlIlIIllIlIII < lllllllllllllIlllllIlIlIIlIIllIl; ++lllllllllllllIlllllIlIlIIllIlIII) {
                final int lllllllllllllIlllllIlIlIIlIlIlll = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * lllllllllllllIlllllIlIlIIllIlIII + lllllllllllllIlllllIlIlIIllIIllI;
                double lllllllllllllIlllllIlIlIIlIIlllI = lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIlll];
                int lllllllllllllIlllllIlIlIIlIllIlI = lllllllllllllIlllllIlIlIIllIIllI;
                int lllllllllllllIlllllIlIlIIlIlIlII = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * lllllllllllllIlllllIlIlIIllIlIII;
                int lllllllllllllIlllllIlIlIIlIlIIIl = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIllIIllI;
                while (lllllllllllllIlllllIlIlIIlIllIlI-- != 0) {
                    lllllllllllllIlllllIlIlIIlIIlllI -= lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIlII] * lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIIIl];
                    ++lllllllllllllIlllllIlIlIIlIlIlII;
                    lllllllllllllIlllllIlIlIIlIlIIIl += lllllllllllllIlllllIlIlIIlIIllIl;
                }
                lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIlll] = lllllllllllllIlllllIlIlIIlIIlllI;
                final double lllllllllllllIlllllIlIlIIlIlllll;
                if ((lllllllllllllIlllllIlIlIIlIlllll = lllllllllllllIlllllIlIlIIllIlIIl[lllllllllllllIlllllIlIlIIllIlIII] * Math.abs(lllllllllllllIlllllIlIlIIlIIlllI)) >= lllllllllllllIlllllIlIlIIllIIIIl) {
                    lllllllllllllIlllllIlIlIIllIIIIl = lllllllllllllIlllllIlIlIIlIlllll;
                    lllllllllllllIlllllIlIlIIlIlllII = lllllllllllllIlllllIlIlIIllIlIII;
                }
            }
            if (lllllllllllllIlllllIlIlIIlIlllII < 0) {
                throw new RuntimeException(VecMathI18N.getString("GMatrix24"));
            }
            if (lllllllllllllIlllllIlIlIIllIIllI != lllllllllllllIlllllIlIlIIlIlllII) {
                int lllllllllllllIlllllIlIlIIlIllIIl = lllllllllllllIlllllIlIlIIlIIllIl;
                int lllllllllllllIlllllIlIlIIlIlIIll = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * lllllllllllllIlllllIlIlIIlIlllII;
                int lllllllllllllIlllllIlIlIIlIlIIII = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * lllllllllllllIlllllIlIlIIllIIllI;
                while (lllllllllllllIlllllIlIlIIlIllIIl-- != 0) {
                    final double lllllllllllllIlllllIlIlIIlIllllI = lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIIll];
                    lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIIll++] = lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIIII];
                    lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIlIlIIII++] = lllllllllllllIlllllIlIlIIlIllllI;
                }
                lllllllllllllIlllllIlIlIIllIlIIl[lllllllllllllIlllllIlIlIIlIlllII] = lllllllllllllIlllllIlIlIIllIlIIl[lllllllllllllIlllllIlIlIIllIIllI];
                lllllllllllllIlllllIlIlIIlIIlIlI[0] = -lllllllllllllIlllllIlIlIIlIIlIlI[0];
            }
            lllllllllllllIlllllIlIlIIllIlIll[lllllllllllllIlllllIlIlIIllIIllI] = lllllllllllllIlllllIlIlIIlIlllII;
            if (lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * lllllllllllllIlllllIlIlIIllIIllI + lllllllllllllIlllllIlIlIIllIIllI] == 0.0) {
                return false;
            }
            if (lllllllllllllIlllllIlIlIIllIIllI != lllllllllllllIlllllIlIlIIlIIllIl - 1) {
                final double lllllllllllllIlllllIlIlIIlIlllIl = 1.0 / lllllllllllllIlllllIlIlIIlIIllII[lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * lllllllllllllIlllllIlIlIIllIIllI + lllllllllllllIlllllIlIlIIllIIllI];
                int lllllllllllllIlllllIlIlIIlIlIllI = lllllllllllllIlllllIlIlIIllIIIll + lllllllllllllIlllllIlIlIIlIIllIl * (lllllllllllllIlllllIlIlIIllIIllI + 1) + lllllllllllllIlllllIlIlIIllIIllI;
                lllllllllllllIlllllIlIlIIllIlIII = lllllllllllllIlllllIlIlIIlIIllIl - 1 - lllllllllllllIlllllIlIlIIllIIllI;
                while (lllllllllllllIlllllIlIlIIllIlIII-- != 0) {
                    final int n = lllllllllllllIlllllIlIlIIlIlIllI;
                    lllllllllllllIlllllIlIlIIlIIllII[n] *= lllllllllllllIlllllIlIlIIlIlllIl;
                    lllllllllllllIlllllIlIlIIlIlIllI += lllllllllllllIlllllIlIlIIlIIllIl;
                }
            }
        }
        return true;
    }
    
    public final void transpose(final GMatrix lllllllllllllIlllllIlIllIlIlIIII) {
        if (this.nRow != lllllllllllllIlllllIlIllIlIlIIII.nCol || this.nCol != lllllllllllllIlllllIlIllIlIlIIII.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix17"));
        }
        if (lllllllllllllIlllllIlIllIlIlIIII != this) {
            for (int lllllllllllllIlllllIlIllIlIIllll = 0; lllllllllllllIlllllIlIllIlIIllll < this.nRow; ++lllllllllllllIlllllIlIllIlIIllll) {
                for (int lllllllllllllIlllllIlIllIlIIlllI = 0; lllllllllllllIlllllIlIllIlIIlllI < this.nCol; ++lllllllllllllIlllllIlIllIlIIlllI) {
                    this.values[lllllllllllllIlllllIlIllIlIIllll][lllllllllllllIlllllIlIllIlIIlllI] = lllllllllllllIlllllIlIllIlIlIIII.values[lllllllllllllIlllllIlIllIlIIlllI][lllllllllllllIlllllIlIllIlIIllll];
                }
            }
        }
        else {
            this.transpose();
        }
    }
    
    private static void checkMatrix(final GMatrix lllllllllllllIlllllIlIllIIllIlll) {
        for (int lllllllllllllIlllllIlIllIIlllIIl = 0; lllllllllllllIlllllIlIllIIlllIIl < lllllllllllllIlllllIlIllIIllIlll.nRow; ++lllllllllllllIlllllIlIllIIlllIIl) {
            for (int lllllllllllllIlllllIlIllIIlllIII = 0; lllllllllllllIlllllIlIllIIlllIII < lllllllllllllIlllllIlIllIIllIlll.nCol; ++lllllllllllllIlllllIlIllIIlllIII) {
                if (Math.abs(lllllllllllllIlllllIlIllIIllIlll.values[lllllllllllllIlllllIlIllIIlllIIl][lllllllllllllIlllllIlIllIIlllIII]) < 1.0E-10) {
                    System.out.print(" 0.0     ");
                }
                else {
                    System.out.print(String.valueOf(new StringBuilder(" ").append(lllllllllllllIlllllIlIllIIllIlll.values[lllllllllllllIlllllIlIllIIlllIIl][lllllllllllllIlllllIlIllIIlllIII])));
                }
            }
            System.out.print("\n");
        }
    }
    
    public final void add(final GMatrix lllllllllllllIlllllIllIlIlIIlIlI) {
        if (this.nRow != lllllllllllllIlllllIllIlIlIIlIlI.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix4"));
        }
        if (this.nCol != lllllllllllllIlllllIllIlIlIIlIlI.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix5"));
        }
        for (int lllllllllllllIlllllIllIlIlIIllIl = 0; lllllllllllllIlllllIllIlIlIIllIl < this.nRow; ++lllllllllllllIlllllIllIlIlIIllIl) {
            for (int lllllllllllllIlllllIllIlIlIIllII = 0; lllllllllllllIlllllIllIlIlIIllII < this.nCol; ++lllllllllllllIlllllIllIlIlIIllII) {
                this.values[lllllllllllllIlllllIllIlIlIIllIl][lllllllllllllIlllllIllIlIlIIllII] += lllllllllllllIlllllIllIlIlIIlIlI.values[lllllllllllllIlllllIllIlIlIIllIl][lllllllllllllIlllllIllIlIlIIllII];
            }
        }
    }
    
    public final void set(final double[] lllllllllllllIlllllIllIIlIIlIlIl) {
        for (int lllllllllllllIlllllIllIIlIIllIII = 0; lllllllllllllIlllllIllIIlIIllIII < this.nRow; ++lllllllllllllIlllllIllIIlIIllIII) {
            for (int lllllllllllllIlllllIllIIlIIlIlll = 0; lllllllllllllIlllllIllIIlIIlIlll < this.nCol; ++lllllllllllllIlllllIllIIlIIlIlll) {
                this.values[lllllllllllllIlllllIllIIlIIllIII][lllllllllllllIlllllIllIIlIIlIlll] = lllllllllllllIlllllIllIIlIIlIlIl[this.nCol * lllllllllllllIlllllIllIIlIIllIII + lllllllllllllIlllllIllIIlIIlIlll];
            }
        }
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIlllllIlIllIlIIIlII = new StringBuffer(this.nRow * this.nCol * 8);
        for (int lllllllllllllIlllllIlIllIlIIIIll = 0; lllllllllllllIlllllIlIllIlIIIIll < this.nRow; ++lllllllllllllIlllllIlIllIlIIIIll) {
            for (int lllllllllllllIlllllIlIllIlIIIIlI = 0; lllllllllllllIlllllIlIllIlIIIIlI < this.nCol; ++lllllllllllllIlllllIlIllIlIIIIlI) {
                lllllllllllllIlllllIlIllIlIIIlII.append(this.values[lllllllllllllIlllllIlIllIlIIIIll][lllllllllllllIlllllIlIllIlIIIIlI]).append(" ");
            }
            lllllllllllllIlllllIlIllIlIIIlII.append("\n");
        }
        return lllllllllllllIlllllIlIllIlIIIlII.toString();
    }
    
    public final void setSize(final int lllllllllllllIlllllIllIIlIlIllll, final int lllllllllllllIlllllIllIIlIlIlllI) {
        final double[][] lllllllllllllIlllllIllIIlIlIllIl = new double[lllllllllllllIlllllIllIIlIlIllll][lllllllllllllIlllllIllIIlIlIlllI];
        int lllllllllllllIlllllIllIIlIlIlIIl = 0;
        if (this.nRow < lllllllllllllIlllllIllIIlIlIllll) {
            final int lllllllllllllIlllllIllIIlIlIlIlI = this.nRow;
        }
        else {
            lllllllllllllIlllllIllIIlIlIlIIl = lllllllllllllIlllllIllIIlIlIllll;
        }
        int lllllllllllllIlllllIllIIlIlIIlll = 0;
        if (this.nCol < lllllllllllllIlllllIllIIlIlIlllI) {
            final int lllllllllllllIlllllIllIIlIlIlIII = this.nCol;
        }
        else {
            lllllllllllllIlllllIllIIlIlIIlll = lllllllllllllIlllllIllIIlIlIlllI;
        }
        for (int lllllllllllllIlllllIllIIlIlIllII = 0; lllllllllllllIlllllIllIIlIlIllII < lllllllllllllIlllllIllIIlIlIlIIl; ++lllllllllllllIlllllIllIIlIlIllII) {
            for (int lllllllllllllIlllllIllIIlIlIlIll = 0; lllllllllllllIlllllIllIIlIlIlIll < lllllllllllllIlllllIllIIlIlIIlll; ++lllllllllllllIlllllIllIIlIlIlIll) {
                lllllllllllllIlllllIllIIlIlIllIl[lllllllllllllIlllllIllIIlIlIllII][lllllllllllllIlllllIllIIlIlIlIll] = this.values[lllllllllllllIlllllIllIIlIlIllII][lllllllllllllIlllllIllIIlIlIlIll];
            }
        }
        this.nRow = lllllllllllllIlllllIllIIlIlIllll;
        this.nCol = lllllllllllllIlllllIllIIlIlIlllI;
        this.values = lllllllllllllIlllllIllIIlIlIllIl;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllllIlIllIIIlIlIl) {
        try {
            final GMatrix lllllllllllllIlllllIlIllIIIlIlII = (GMatrix)lllllllllllllIlllllIlIllIIIlIlIl;
            if (this.nRow != lllllllllllllIlllllIlIllIIIlIlII.nRow || this.nCol != lllllllllllllIlllllIlIllIIIlIlII.nCol) {
                return false;
            }
            for (int lllllllllllllIlllllIlIllIIIlIIll = 0; lllllllllllllIlllllIlIllIIIlIIll < this.nRow; ++lllllllllllllIlllllIlIllIIIlIIll) {
                for (int lllllllllllllIlllllIlIllIIIlIIlI = 0; lllllllllllllIlllllIlIllIIIlIIlI < this.nCol; ++lllllllllllllIlllllIlIllIIIlIIlI) {
                    if (this.values[lllllllllllllIlllllIlIllIIIlIIll][lllllllllllllIlllllIlIllIIIlIIlI] != lllllllllllllIlllllIlIllIIIlIlII.values[lllllllllllllIlllllIlIllIIIlIIll][lllllllllllllIlllllIlIllIIIlIIlI]) {
                        return false;
                    }
                }
            }
            return true;
        }
        catch (ClassCastException lllllllllllllIlllllIlIllIIIlIIIl) {
            return false;
        }
        catch (NullPointerException lllllllllllllIlllllIlIllIIIlIIII) {
            return false;
        }
    }
    
    public boolean epsilonEquals(final GMatrix lllllllllllllIlllllIlIlIllllIlII, final double lllllllllllllIlllllIlIlIlllllIIl) {
        if (this.nRow != lllllllllllllIlllllIlIlIllllIlII.nRow || this.nCol != lllllllllllllIlllllIlIlIllllIlII.nCol) {
            return false;
        }
        for (int lllllllllllllIlllllIlIlIlllllIII = 0; lllllllllllllIlllllIlIlIlllllIII < this.nRow; ++lllllllllllllIlllllIlIlIlllllIII) {
            for (int lllllllllllllIlllllIlIlIllllIlll = 0; lllllllllllllIlllllIlIlIllllIlll < this.nCol; ++lllllllllllllIlllllIlIlIllllIlll) {
                final double lllllllllllllIlllllIlIlIllllIllI = this.values[lllllllllllllIlllllIlIlIlllllIII][lllllllllllllIlllllIlIlIllllIlll] - lllllllllllllIlllllIlIlIllllIlII.values[lllllllllllllIlllllIlIlIlllllIII][lllllllllllllIlllllIlIlIllllIlll];
                if (((lllllllllllllIlllllIlIlIllllIllI < 0.0) ? (-lllllllllllllIlllllIlIlIllllIllI) : lllllllllllllIlllllIlIlIllllIllI) > lllllllllllllIlllllIlIlIlllllIIl) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public final void getRow(final int lllllllllllllIlllllIllIIIIlIIlIl, final GVector lllllllllllllIlllllIllIIIIlIlIII) {
        if (lllllllllllllIlllllIllIIIIlIlIII.getSize() < this.nCol) {
            lllllllllllllIlllllIllIIIIlIlIII.setSize(this.nCol);
        }
        for (int lllllllllllllIlllllIllIIIIlIIlll = 0; lllllllllllllIlllllIllIIIIlIIlll < this.nCol; ++lllllllllllllIlllllIllIIIIlIIlll) {
            lllllllllllllIlllllIllIIIIlIlIII.values[lllllllllllllIlllllIllIIIIlIIlll] = this.values[lllllllllllllIlllllIllIIIIlIIlIl][lllllllllllllIlllllIllIIIIlIIlll];
        }
    }
    
    public final void setElement(final int lllllllllllllIlllllIllIIIIllllIl, final int lllllllllllllIlllllIllIIIlIIIIII, final double lllllllllllllIlllllIllIIIIlllIll) {
        this.values[lllllllllllllIlllllIllIIIIllllIl][lllllllllllllIlllllIllIIIlIIIIII] = lllllllllllllIlllllIllIIIIlllIll;
    }
    
    public final void setZero() {
        for (int lllllllllllllIlllllIllIIllllIlll = 0; lllllllllllllIlllllIllIIllllIlll < this.nRow; ++lllllllllllllIlllllIllIIllllIlll) {
            for (int lllllllllllllIlllllIllIIllllIllI = 0; lllllllllllllIlllllIllIIllllIllI < this.nCol; ++lllllllllllllIlllllIllIIllllIllI) {
                this.values[lllllllllllllIlllllIllIIllllIlll][lllllllllllllIlllllIllIIllllIllI] = 0.0;
            }
        }
    }
    
    public final int LUD(final GMatrix lllllllllllllIlllllIlIlIlIllIIll, final GVector lllllllllllllIlllllIlIlIlIllIIlI) {
        final int lllllllllllllIlllllIlIlIlIlllIll = lllllllllllllIlllllIlIlIlIllIIll.nRow * lllllllllllllIlllllIlIlIlIllIIll.nCol;
        final double[] lllllllllllllIlllllIlIlIlIlllIlI = new double[lllllllllllllIlllllIlIlIlIlllIll];
        final int[] lllllllllllllIlllllIlIlIlIlllIIl = { 0 };
        final int[] lllllllllllllIlllllIlIlIlIlllIII = new int[lllllllllllllIlllllIlIlIlIllIIll.nRow];
        if (this.nRow != this.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix19"));
        }
        if (this.nRow != lllllllllllllIlllllIlIlIlIllIIll.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix27"));
        }
        if (this.nCol != lllllllllllllIlllllIlIlIlIllIIll.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix27"));
        }
        if (lllllllllllllIlllllIlIlIlIllIIll.nRow != lllllllllllllIlllllIlIlIlIllIIlI.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix20"));
        }
        for (int lllllllllllllIlllllIlIlIlIllIlll = 0; lllllllllllllIlllllIlIlIlIllIlll < this.nRow; ++lllllllllllllIlllllIlIlIlIllIlll) {
            for (int lllllllllllllIlllllIlIlIlIllIllI = 0; lllllllllllllIlllllIlIlIlIllIllI < this.nCol; ++lllllllllllllIlllllIlIlIlIllIllI) {
                lllllllllllllIlllllIlIlIlIlllIlI[lllllllllllllIlllllIlIlIlIllIlll * this.nCol + lllllllllllllIlllllIlIlIlIllIllI] = this.values[lllllllllllllIlllllIlIlIlIllIlll][lllllllllllllIlllllIlIlIlIllIllI];
            }
        }
        if (!luDecomposition(lllllllllllllIlllllIlIlIlIllIIll.nRow, lllllllllllllIlllllIlIlIlIlllIlI, lllllllllllllIlllllIlIlIlIlllIII, lllllllllllllIlllllIlIlIlIlllIIl)) {
            throw new SingularMatrixException(VecMathI18N.getString("GMatrix21"));
        }
        for (int lllllllllllllIlllllIlIlIlIllIlll = 0; lllllllllllllIlllllIlIlIlIllIlll < this.nRow; ++lllllllllllllIlllllIlIlIlIllIlll) {
            for (int lllllllllllllIlllllIlIlIlIllIlIl = 0; lllllllllllllIlllllIlIlIlIllIlIl < this.nCol; ++lllllllllllllIlllllIlIlIlIllIlIl) {
                lllllllllllllIlllllIlIlIlIllIIll.values[lllllllllllllIlllllIlIlIlIllIlll][lllllllllllllIlllllIlIlIlIllIlIl] = lllllllllllllIlllllIlIlIlIlllIlI[lllllllllllllIlllllIlIlIlIllIlll * this.nCol + lllllllllllllIlllllIlIlIlIllIlIl];
            }
        }
        for (int lllllllllllllIlllllIlIlIlIllIlll = 0; lllllllllllllIlllllIlIlIlIllIlll < lllllllllllllIlllllIlIlIlIllIIll.nRow; ++lllllllllllllIlllllIlIlIlIllIlll) {
            lllllllllllllIlllllIlIlIlIllIIlI.values[lllllllllllllIlllllIlIlIlIllIlll] = lllllllllllllIlllllIlIlIlIlllIII[lllllllllllllIlllllIlIlIlIllIlll];
        }
        return lllllllllllllIlllllIlIlIlIlllIIl[0];
    }
    
    private static void print_m(final GMatrix lllllllllllllIlllllIlIIIIlIlIlIl, final GMatrix lllllllllllllIlllllIlIIIIlIlIIII, final GMatrix lllllllllllllIlllllIlIIIIlIlIIll) {
        final GMatrix lllllllllllllIlllllIlIIIIlIlIIlI = new GMatrix(lllllllllllllIlllllIlIIIIlIlIlIl.nCol, lllllllllllllIlllllIlIIIIlIlIlIl.nRow);
        lllllllllllllIlllllIlIIIIlIlIIlI.mul(lllllllllllllIlllllIlIIIIlIlIIII, lllllllllllllIlllllIlIIIIlIlIIlI);
        lllllllllllllIlllllIlIIIIlIlIIlI.mul(lllllllllllllIlllllIlIIIIlIlIIlI, lllllllllllllIlllllIlIIIIlIlIIll);
        System.out.println(String.valueOf(new StringBuilder("\n m = \n").append(toString(lllllllllllllIlllllIlIIIIlIlIIlI))));
    }
    
    public final void getColumn(final int lllllllllllllIlllllIllIIIIIlllIl, final double[] lllllllllllllIlllllIllIIIIIllIII) {
        for (int lllllllllllllIlllllIllIIIIIllIll = 0; lllllllllllllIlllllIllIIIIIllIll < this.nRow; ++lllllllllllllIlllllIllIIIIIllIll) {
            lllllllllllllIlllllIllIIIIIllIII[lllllllllllllIlllllIllIIIIIllIll] = this.values[lllllllllllllIlllllIllIIIIIllIll][lllllllllllllIlllllIllIIIIIlllIl];
        }
    }
    
    public final void setScale(final double lllllllllllllIlllllIlIlIlIIlllll) {
        int lllllllllllllIlllllIlIlIlIlIIIIl = 0;
        if (this.nRow < this.nCol) {
            final int lllllllllllllIlllllIlIlIlIlIIIlI = this.nRow;
        }
        else {
            lllllllllllllIlllllIlIlIlIlIIIIl = this.nCol;
        }
        for (int lllllllllllllIlllllIlIlIlIlIIlII = 0; lllllllllllllIlllllIlIlIlIlIIlII < this.nRow; ++lllllllllllllIlllllIlIlIlIlIIlII) {
            for (int lllllllllllllIlllllIlIlIlIlIIIll = 0; lllllllllllllIlllllIlIlIlIlIIIll < this.nCol; ++lllllllllllllIlllllIlIlIlIlIIIll) {
                this.values[lllllllllllllIlllllIlIlIlIlIIlII][lllllllllllllIlllllIlIlIlIlIIIll] = 0.0;
            }
        }
        for (int lllllllllllllIlllllIlIlIlIlIIlII = 0; lllllllllllllIlllllIlIlIlIlIIlII < lllllllllllllIlllllIlIlIlIlIIIIl; ++lllllllllllllIlllllIlIlIlIlIIlII) {
            this.values[lllllllllllllIlllllIlIlIlIlIIlII][lllllllllllllIlllllIlIlIlIlIIlII] = lllllllllllllIlllllIlIlIlIIlllll;
        }
    }
    
    public final void copySubMatrix(final int lllllllllllllIlllllIllIIllIlIIII, final int lllllllllllllIlllllIllIIllIIIIIl, final int lllllllllllllIlllllIllIIllIIlllI, final int lllllllllllllIlllllIllIIlIllllll, final int lllllllllllllIlllllIllIIllIIllII, final int lllllllllllllIlllllIllIIlIllllIl, final GMatrix lllllllllllllIlllllIllIIlIllllII) {
        if (this != lllllllllllllIlllllIllIIlIllllII) {
            for (int lllllllllllllIlllllIllIIllIIlIIl = 0; lllllllllllllIlllllIllIIllIIlIIl < lllllllllllllIlllllIllIIllIIlllI; ++lllllllllllllIlllllIllIIllIIlIIl) {
                for (int lllllllllllllIlllllIllIIllIIIlll = 0; lllllllllllllIlllllIllIIllIIIlll < lllllllllllllIlllllIllIIlIllllll; ++lllllllllllllIlllllIllIIllIIIlll) {
                    lllllllllllllIlllllIllIIlIllllII.values[lllllllllllllIlllllIllIIllIIllII + lllllllllllllIlllllIllIIllIIlIIl][lllllllllllllIlllllIllIIlIllllIl + lllllllllllllIlllllIllIIllIIIlll] = this.values[lllllllllllllIlllllIllIIllIlIIII + lllllllllllllIlllllIllIIllIIlIIl][lllllllllllllIlllllIllIIllIIIIIl + lllllllllllllIlllllIllIIllIIIlll];
                }
            }
        }
        else {
            final double[][] lllllllllllllIlllllIllIIllIIIlII = new double[lllllllllllllIlllllIllIIllIIlllI][lllllllllllllIlllllIllIIlIllllll];
            for (int lllllllllllllIlllllIllIIllIIlIII = 0; lllllllllllllIlllllIllIIllIIlIII < lllllllllllllIlllllIllIIllIIlllI; ++lllllllllllllIlllllIllIIllIIlIII) {
                for (int lllllllllllllIlllllIllIIllIIIllI = 0; lllllllllllllIlllllIllIIllIIIllI < lllllllllllllIlllllIllIIlIllllll; ++lllllllllllllIlllllIllIIllIIIllI) {
                    lllllllllllllIlllllIllIIllIIIlII[lllllllllllllIlllllIllIIllIIlIII][lllllllllllllIlllllIllIIllIIIllI] = this.values[lllllllllllllIlllllIllIIllIlIIII + lllllllllllllIlllllIllIIllIIlIII][lllllllllllllIlllllIllIIllIIIIIl + lllllllllllllIlllllIllIIllIIIllI];
                }
            }
            for (int lllllllllllllIlllllIllIIllIIlIII = 0; lllllllllllllIlllllIllIIllIIlIII < lllllllllllllIlllllIllIIllIIlllI; ++lllllllllllllIlllllIllIIllIIlIII) {
                for (int lllllllllllllIlllllIllIIllIIIlIl = 0; lllllllllllllIlllllIllIIllIIIlIl < lllllllllllllIlllllIllIIlIllllll; ++lllllllllllllIlllllIllIIllIIIlIl) {
                    lllllllllllllIlllllIllIIlIllllII.values[lllllllllllllIlllllIllIIllIIllII + lllllllllllllIlllllIllIIllIIlIII][lllllllllllllIlllllIllIIlIllllIl + lllllllllllllIlllllIllIIllIIIlIl] = lllllllllllllIlllllIllIIllIIIlII[lllllllllllllIlllllIllIIllIIlIII][lllllllllllllIlllllIllIIllIIIlIl];
                }
            }
        }
    }
    
    public final void negate(final GMatrix lllllllllllllIlllllIllIlIIIIlIll) {
        if (this.nRow != lllllllllllllIlllllIllIlIIIIlIll.nRow || this.nCol != lllllllllllllIlllllIllIlIIIIlIll.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix13"));
        }
        for (int lllllllllllllIlllllIllIlIIIIlllI = 0; lllllllllllllIlllllIllIlIIIIlllI < this.nRow; ++lllllllllllllIlllllIllIlIIIIlllI) {
            for (int lllllllllllllIlllllIllIlIIIIllIl = 0; lllllllllllllIlllllIllIlIIIIllIl < this.nCol; ++lllllllllllllIlllllIllIlIIIIllIl) {
                this.values[lllllllllllllIlllllIllIlIIIIlllI][lllllllllllllIlllllIllIlIIIIllIl] = -lllllllllllllIlllllIllIlIIIIlIll.values[lllllllllllllIlllllIllIlIIIIlllI][lllllllllllllIlllllIllIlIIIIllIl];
            }
        }
    }
    
    public final void getRow(final int lllllllllllllIlllllIllIIIIllIlIl, final double[] lllllllllllllIlllllIllIIIIllIlII) {
        for (int lllllllllllllIlllllIllIIIIllIIll = 0; lllllllllllllIlllllIllIIIIllIIll < this.nCol; ++lllllllllllllIlllllIllIIIIllIIll) {
            lllllllllllllIlllllIllIIIIllIlII[lllllllllllllIlllllIllIIIIllIIll] = this.values[lllllllllllllIlllllIllIIIIllIlIl][lllllllllllllIlllllIllIIIIllIIll];
        }
    }
    
    public final void setRow(final int lllllllllllllIlllllIlIllllIlIIll, final double[] lllllllllllllIlllllIlIllllIlIllI) {
        for (int lllllllllllllIlllllIlIllllIlIlIl = 0; lllllllllllllIlllllIlIllllIlIlIl < this.nCol; ++lllllllllllllIlllllIlIllllIlIlIl) {
            this.values[lllllllllllllIlllllIlIllllIlIIll][lllllllllllllIlllllIlIllllIlIlIl] = lllllllllllllIlllllIlIllllIlIllI[lllllllllllllIlllllIlIllllIlIlIl];
        }
    }
    
    public GMatrix(final int lllllllllllllIlllllIllIllIlIIIII, final int lllllllllllllIlllllIllIllIIllIIl, final double[] lllllllllllllIlllllIllIllIIllIII) {
        this.values = new double[lllllllllllllIlllllIllIllIlIIIII][lllllllllllllIlllllIllIllIIllIIl];
        this.nRow = lllllllllllllIlllllIllIllIlIIIII;
        this.nCol = lllllllllllllIlllllIllIllIIllIIl;
        for (int lllllllllllllIlllllIllIllIIlllIl = 0; lllllllllllllIlllllIllIllIIlllIl < lllllllllllllIlllllIllIllIlIIIII; ++lllllllllllllIlllllIllIllIIlllIl) {
            for (int lllllllllllllIlllllIllIllIIlllII = 0; lllllllllllllIlllllIllIllIIlllII < lllllllllllllIlllllIllIllIIllIIl; ++lllllllllllllIlllllIllIllIIlllII) {
                this.values[lllllllllllllIlllllIllIllIIlllIl][lllllllllllllIlllllIllIllIIlllII] = lllllllllllllIlllllIllIllIIllIII[lllllllllllllIlllllIllIllIIlllIl * lllllllllllllIlllllIllIllIIllIIl + lllllllllllllIlllllIllIllIIlllII];
            }
        }
    }
    
    public final int SVD(final GMatrix lllllllllllllIlllllIlIlIllIIllll, final GMatrix lllllllllllllIlllllIlIlIllIlIlll, final GMatrix lllllllllllllIlllllIlIlIllIlIllI) {
        if (this.nCol != lllllllllllllIlllllIlIlIllIlIllI.nCol || this.nCol != lllllllllllllIlllllIlIlIllIlIllI.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix18"));
        }
        if (this.nRow != lllllllllllllIlllllIlIlIllIIllll.nRow || this.nRow != lllllllllllllIlllllIlIlIllIIllll.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix25"));
        }
        if (this.nRow != lllllllllllllIlllllIlIlIllIlIlll.nRow || this.nCol != lllllllllllllIlllllIlIlIllIlIlll.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix26"));
        }
        if (this.nRow != 2 || this.nCol != 2 || this.values[1][0] != 0.0) {
            return computeSVD(this, lllllllllllllIlllllIlIlIllIIllll, lllllllllllllIlllllIlIlIllIlIlll, lllllllllllllIlllllIlIlIllIlIllI);
        }
        lllllllllllllIlllllIlIlIllIIllll.setIdentity();
        lllllllllllllIlllllIlIlIllIlIllI.setIdentity();
        if (this.values[0][1] == 0.0) {
            return 2;
        }
        final double[] lllllllllllllIlllllIlIlIllIlIlIl = { 0.0 };
        final double[] lllllllllllllIlllllIlIlIllIlIlII = { 0.0 };
        final double[] lllllllllllllIlllllIlIlIllIlIIll = { 0.0 };
        final double[] lllllllllllllIlllllIlIlIllIlIIlI = { 0.0 };
        final double[] lllllllllllllIlllllIlIlIllIlIIIl = { this.values[0][0], this.values[1][1] };
        compute_2X2(this.values[0][0], this.values[0][1], this.values[1][1], lllllllllllllIlllllIlIlIllIlIIIl, lllllllllllllIlllllIlIlIllIlIlIl, lllllllllllllIlllllIlIlIllIlIIll, lllllllllllllIlllllIlIlIllIlIlII, lllllllllllllIlllllIlIlIllIlIIlI, 0);
        update_u(0, lllllllllllllIlllllIlIlIllIIllll, lllllllllllllIlllllIlIlIllIlIIll, lllllllllllllIlllllIlIlIllIlIlIl);
        update_v(0, lllllllllllllIlllllIlIlIllIlIllI, lllllllllllllIlllllIlIlIllIlIIlI, lllllllllllllIlllllIlIlIllIlIlII);
        return 2;
    }
    
    public final void sub(final GMatrix lllllllllllllIlllllIllIlIIllIIll) {
        if (this.nRow != lllllllllllllIlllllIllIlIIllIIll.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix9"));
        }
        if (this.nCol != lllllllllllllIlllllIllIlIIllIIll.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix28"));
        }
        for (int lllllllllllllIlllllIllIlIIllIIlI = 0; lllllllllllllIlllllIllIlIIllIIlI < this.nRow; ++lllllllllllllIlllllIllIlIIllIIlI) {
            for (int lllllllllllllIlllllIllIlIIllIIIl = 0; lllllllllllllIlllllIllIlIIllIIIl < this.nCol; ++lllllllllllllIlllllIllIlIIllIIIl) {
                this.values[lllllllllllllIlllllIllIlIIllIIlI][lllllllllllllIlllllIllIlIIllIIIl] -= lllllllllllllIlllllIllIlIIllIIll.values[lllllllllllllIlllllIllIlIIllIIlI][lllllllllllllIlllllIllIlIIllIIIl];
            }
        }
    }
    
    public final void negate() {
        for (int lllllllllllllIlllllIllIlIIIllIIl = 0; lllllllllllllIlllllIllIlIIIllIIl < this.nRow; ++lllllllllllllIlllllIllIlIIIllIIl) {
            for (int lllllllllllllIlllllIllIlIIIllIII = 0; lllllllllllllIlllllIllIlIIIllIII < this.nCol; ++lllllllllllllIlllllIllIlIIIllIII) {
                this.values[lllllllllllllIlllllIllIlIIIllIIl][lllllllllllllIlllllIllIlIIIllIII] = -this.values[lllllllllllllIlllllIllIlIIIllIIl][lllllllllllllIlllllIllIlIIIllIII];
            }
        }
    }
    
    public GMatrix(final int lllllllllllllIlllllIllIllIllIIll, final int lllllllllllllIlllllIllIllIllIIlI) {
        this.values = new double[lllllllllllllIlllllIllIllIllIIll][lllllllllllllIlllllIllIllIllIIlI];
        this.nRow = lllllllllllllIlllllIllIllIllIIll;
        this.nCol = lllllllllllllIlllllIllIllIllIIlI;
        for (int lllllllllllllIlllllIllIllIllIIIl = 0; lllllllllllllIlllllIllIllIllIIIl < lllllllllllllIlllllIllIllIllIIll; ++lllllllllllllIlllllIllIllIllIIIl) {
            for (int lllllllllllllIlllllIllIllIllIIII = 0; lllllllllllllIlllllIllIllIllIIII < lllllllllllllIlllllIllIllIllIIlI; ++lllllllllllllIlllllIllIllIllIIII) {
                this.values[lllllllllllllIlllllIllIllIllIIIl][lllllllllllllIlllllIllIllIllIIII] = 0.0;
            }
        }
        int lllllllllllllIlllllIllIllIlIlllI = 0;
        if (lllllllllllllIlllllIllIllIllIIll < lllllllllllllIlllllIllIllIllIIlI) {
            final int lllllllllllllIlllllIllIllIlIllll = lllllllllllllIlllllIllIllIllIIll;
        }
        else {
            lllllllllllllIlllllIllIllIlIlllI = lllllllllllllIlllllIllIllIllIIlI;
        }
        for (int lllllllllllllIlllllIllIllIllIIIl = 0; lllllllllllllIlllllIllIllIllIIIl < lllllllllllllIlllllIllIllIlIlllI; ++lllllllllllllIlllllIllIllIllIIIl) {
            this.values[lllllllllllllIlllllIllIllIllIIIl][lllllllllllllIlllllIllIllIllIIIl] = 1.0;
        }
    }
    
    private static void update_u(final int lllllllllllllIlllllIlIIIIlIlllll, final GMatrix lllllllllllllIlllllIlIIIIlIllllI, final double[] lllllllllllllIlllllIlIIIIlIlllIl, final double[] lllllllllllllIlllllIlIIIIlIlllII) {
        for (int lllllllllllllIlllllIlIIIIllIIIIl = 0; lllllllllllllIlllllIlIIIIllIIIIl < lllllllllllllIlllllIlIIIIlIllllI.nCol; ++lllllllllllllIlllllIlIIIIllIIIIl) {
            final double lllllllllllllIlllllIlIIIIllIIIII = lllllllllllllIlllllIlIIIIlIllllI.values[lllllllllllllIlllllIlIIIIlIlllll][lllllllllllllIlllllIlIIIIllIIIIl];
            lllllllllllllIlllllIlIIIIlIllllI.values[lllllllllllllIlllllIlIIIIlIlllll][lllllllllllllIlllllIlIIIIllIIIIl] = lllllllllllllIlllllIlIIIIlIlllIl[0] * lllllllllllllIlllllIlIIIIllIIIII + lllllllllllllIlllllIlIIIIlIlllII[0] * lllllllllllllIlllllIlIIIIlIllllI.values[lllllllllllllIlllllIlIIIIlIlllll + 1][lllllllllllllIlllllIlIIIIllIIIIl];
            lllllllllllllIlllllIlIIIIlIllllI.values[lllllllllllllIlllllIlIIIIlIlllll + 1][lllllllllllllIlllllIlIIIIllIIIIl] = -lllllllllllllIlllllIlIIIIlIlllII[0] * lllllllllllllIlllllIlIIIIllIIIII + lllllllllllllIlllllIlIIIIlIlllIl[0] * lllllllllllllIlllllIlIIIIlIllllI.values[lllllllllllllIlllllIlIIIIlIlllll + 1][lllllllllllllIlllllIlIIIIllIIIIl];
        }
    }
    
    public final void set(final GMatrix lllllllllllllIlllllIllIIIlIlllIl) {
        if (this.nRow < lllllllllllllIlllllIllIIIlIlllIl.nRow || this.nCol < lllllllllllllIlllllIllIIIlIlllIl.nCol) {
            this.nRow = lllllllllllllIlllllIllIIIlIlllIl.nRow;
            this.nCol = lllllllllllllIlllllIllIIIlIlllIl.nCol;
            this.values = new double[this.nRow][this.nCol];
        }
        for (int lllllllllllllIlllllIllIIIlIlllII = 0; lllllllllllllIlllllIllIIIlIlllII < Math.min(this.nRow, lllllllllllllIlllllIllIIIlIlllIl.nRow); ++lllllllllllllIlllllIllIIIlIlllII) {
            for (int lllllllllllllIlllllIllIIIlIllIll = 0; lllllllllllllIlllllIllIIIlIllIll < Math.min(this.nCol, lllllllllllllIlllllIllIIIlIlllIl.nCol); ++lllllllllllllIlllllIllIIIlIllIll) {
                this.values[lllllllllllllIlllllIllIIIlIlllII][lllllllllllllIlllllIllIIIlIllIll] = lllllllllllllIlllllIllIIIlIlllIl.values[lllllllllllllIlllllIllIIIlIlllII][lllllllllllllIlllllIllIIIlIllIll];
            }
        }
        for (int lllllllllllllIlllllIllIIIlIlllII = lllllllllllllIlllllIllIIIlIlllIl.nRow; lllllllllllllIlllllIllIIIlIlllII < this.nRow; ++lllllllllllllIlllllIllIIIlIlllII) {
            for (int lllllllllllllIlllllIllIIIlIllIlI = lllllllllllllIlllllIllIIIlIlllIl.nCol; lllllllllllllIlllllIllIIIlIllIlI < this.nCol; ++lllllllllllllIlllllIllIIIlIllIlI) {
                this.values[lllllllllllllIlllllIllIIIlIlllII][lllllllllllllIlllllIllIIIlIllIlI] = 0.0;
            }
        }
    }
    
    public final void setColumn(final int lllllllllllllIlllllIlIlllIlllIll, final double[] lllllllllllllIlllllIlIlllIlllIlI) {
        for (int lllllllllllllIlllllIlIlllIllllIl = 0; lllllllllllllIlllllIlIlllIllllIl < this.nRow; ++lllllllllllllIlllllIlIlllIllllIl) {
            this.values[lllllllllllllIlllllIlIlllIllllIl][lllllllllllllIlllllIlIlllIlllIll] = lllllllllllllIlllllIlIlllIlllIlI[lllllllllllllIlllllIlIlllIllllIl];
        }
    }
    
    public final void set(final Matrix3f lllllllllllllIlllllIllIIlIIIlIIl) {
        if (this.nCol < 3 || this.nRow < 3) {
            this.nCol = 3;
            this.nRow = 3;
            this.values = new double[this.nRow][this.nCol];
        }
        this.values[0][0] = lllllllllllllIlllllIllIIlIIIlIIl.m00;
        this.values[0][1] = lllllllllllllIlllllIllIIlIIIlIIl.m01;
        this.values[0][2] = lllllllllllllIlllllIllIIlIIIlIIl.m02;
        this.values[1][0] = lllllllllllllIlllllIllIIlIIIlIIl.m10;
        this.values[1][1] = lllllllllllllIlllllIllIIlIIIlIIl.m11;
        this.values[1][2] = lllllllllllllIlllllIllIIlIIIlIIl.m12;
        this.values[2][0] = lllllllllllllIlllllIllIIlIIIlIIl.m20;
        this.values[2][1] = lllllllllllllIlllllIllIIlIIIlIIl.m21;
        this.values[2][2] = lllllllllllllIlllllIllIIlIIIlIIl.m22;
        for (int lllllllllllllIlllllIllIIlIIIllII = 3; lllllllllllllIlllllIllIIlIIIllII < this.nRow; ++lllllllllllllIlllllIllIIlIIIllII) {
            for (int lllllllllllllIlllllIllIIlIIIlIll = 3; lllllllllllllIlllllIllIIlIIIlIll < this.nCol; ++lllllllllllllIlllllIllIIlIIIlIll) {
                this.values[lllllllllllllIlllllIllIIlIIIllII][lllllllllllllIlllllIllIIlIIIlIll] = 0.0;
            }
        }
    }
    
    public final void mulTransposeLeft(final GMatrix lllllllllllllIlllllIlIllIlllIlII, final GMatrix lllllllllllllIlllllIlIllIllIlIIl) {
        if (lllllllllllllIlllllIlIllIlllIlII.nRow != lllllllllllllIlllllIlIllIllIlIIl.nRow || this.nCol != lllllllllllllIlllllIlIllIllIlIIl.nCol || this.nRow != lllllllllllllIlllllIlIllIlllIlII.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GMatrix16"));
        }
        if (lllllllllllllIlllllIlIllIlllIlII == this || lllllllllllllIlllllIlIllIllIlIIl == this) {
            final double[][] lllllllllllllIlllllIlIllIllIllII = new double[this.nRow][this.nCol];
            for (int lllllllllllllIlllllIlIllIlllIIlI = 0; lllllllllllllIlllllIlIllIlllIIlI < this.nRow; ++lllllllllllllIlllllIlIllIlllIIlI) {
                for (int lllllllllllllIlllllIlIllIlllIIII = 0; lllllllllllllIlllllIlIllIlllIIII < this.nCol; ++lllllllllllllIlllllIlIllIlllIIII) {
                    lllllllllllllIlllllIlIllIllIllII[lllllllllllllIlllllIlIllIlllIIlI][lllllllllllllIlllllIlIllIlllIIII] = 0.0;
                    for (int lllllllllllllIlllllIlIllIllIlllI = 0; lllllllllllllIlllllIlIllIllIlllI < lllllllllllllIlllllIlIllIlllIlII.nRow; ++lllllllllllllIlllllIlIllIllIlllI) {
                        final double[] array = lllllllllllllIlllllIlIllIllIllII[lllllllllllllIlllllIlIllIlllIIlI];
                        final int n = lllllllllllllIlllllIlIllIlllIIII;
                        array[n] += lllllllllllllIlllllIlIllIlllIlII.values[lllllllllllllIlllllIlIllIllIlllI][lllllllllllllIlllllIlIllIlllIIlI] * lllllllllllllIlllllIlIllIllIlIIl.values[lllllllllllllIlllllIlIllIllIlllI][lllllllllllllIlllllIlIllIlllIIII];
                    }
                }
            }
            this.values = lllllllllllllIlllllIlIllIllIllII;
        }
        else {
            for (int lllllllllllllIlllllIlIllIlllIIIl = 0; lllllllllllllIlllllIlIllIlllIIIl < this.nRow; ++lllllllllllllIlllllIlIllIlllIIIl) {
                for (int lllllllllllllIlllllIlIllIllIllll = 0; lllllllllllllIlllllIlIllIllIllll < this.nCol; ++lllllllllllllIlllllIlIllIllIllll) {
                    this.values[lllllllllllllIlllllIlIllIlllIIIl][lllllllllllllIlllllIlIllIllIllll] = 0.0;
                    for (int lllllllllllllIlllllIlIllIllIllIl = 0; lllllllllllllIlllllIlIllIllIllIl < lllllllllllllIlllllIlIllIlllIlII.nRow; ++lllllllllllllIlllllIlIllIllIllIl) {
                        final double[] array2 = this.values[lllllllllllllIlllllIlIllIlllIIIl];
                        final int n2 = lllllllllllllIlllllIlIllIllIllll;
                        array2[n2] += lllllllllllllIlllllIlIllIlllIlII.values[lllllllllllllIlllllIlIllIllIllIl][lllllllllllllIlllllIlIllIlllIIIl] * lllllllllllllIlllllIlIllIllIlIIl.values[lllllllllllllIlllllIlIllIllIllIl][lllllllllllllIlllllIlIllIllIllll];
                    }
                }
            }
        }
    }
    
    static int compute_2X2(final double lllllllllllllIlllllIIllllIIlllll, final double lllllllllllllIlllllIIllllIIlllIl, final double lllllllllllllIlllllIIlllllIIIllI, final double[] lllllllllllllIlllllIIllllIIllIll, final double[] lllllllllllllIlllllIIlllllIIIlII, final double[] lllllllllllllIlllllIIlllllIIIIll, final double[] lllllllllllllIlllllIIllllIIllIII, final double[] lllllllllllllIlllllIIllllIIlIlll, final int lllllllllllllIlllllIIlllllIIIIII) {
        final double lllllllllllllIlllllIIllllIllllll = 2.0;
        final double lllllllllllllIlllllIIllllIlllllI = 1.0;
        double lllllllllllllIlllllIIllllIlIIIII = lllllllllllllIlllllIIllllIIllIll[0];
        double lllllllllllllIlllllIIllllIlIIIIl = lllllllllllllIlllllIIllllIIllIll[1];
        double lllllllllllllIlllllIIllllIlIIlIl = 0.0;
        double lllllllllllllIlllllIIllllIlIIlII = 0.0;
        double lllllllllllllIlllllIIllllIlIIIll = 0.0;
        double lllllllllllllIlllllIIllllIlIIIlI = 0.0;
        double lllllllllllllIlllllIIllllIlIllll = 0.0;
        double lllllllllllllIlllllIIllllIlIlIll = lllllllllllllIlllllIIllllIIlllll;
        double lllllllllllllIlllllIIllllIlIlllI = Math.abs(lllllllllllllIlllllIIllllIlIlIll);
        double lllllllllllllIlllllIIllllIlIlIIl = lllllllllllllIlllllIIlllllIIIllI;
        double lllllllllllllIlllllIIllllIlIllII = Math.abs(lllllllllllllIlllllIIlllllIIIllI);
        int lllllllllllllIlllllIIllllIllllII = 1;
        boolean lllllllllllllIlllllIIllllIlllIIl = false;
        if (lllllllllllllIlllllIIllllIlIllII > lllllllllllllIlllllIIllllIlIlllI) {
            final boolean lllllllllllllIlllllIIllllIlllIlI = true;
        }
        else {
            lllllllllllllIlllllIIllllIlllIIl = false;
        }
        if (lllllllllllllIlllllIIllllIlllIIl) {
            lllllllllllllIlllllIIllllIllllII = 3;
            double lllllllllllllIlllllIIllllIlllIll = lllllllllllllIlllllIIllllIlIlIll;
            lllllllllllllIlllllIIllllIlIlIll = lllllllllllllIlllllIIllllIlIlIIl;
            lllllllllllllIlllllIIllllIlIlIIl = lllllllllllllIlllllIIllllIlllIll;
            lllllllllllllIlllllIIllllIlllIll = lllllllllllllIlllllIIllllIlIlllI;
            lllllllllllllIlllllIIllllIlIlllI = lllllllllllllIlllllIIllllIlIllII;
            lllllllllllllIlllllIIllllIlIllII = lllllllllllllIlllllIIllllIlllIll;
        }
        final double lllllllllllllIlllllIIllllIlIlIlI = lllllllllllllIlllllIIllllIIlllIl;
        final double lllllllllllllIlllllIIllllIlIllIl = Math.abs(lllllllllllllIlllllIIllllIlIlIlI);
        if (lllllllllllllIlllllIIllllIlIllIl == 0.0) {
            lllllllllllllIlllllIIllllIIllIll[1] = lllllllllllllIlllllIIllllIlIllII;
            lllllllllllllIlllllIIllllIIllIll[0] = lllllllllllllIlllllIIllllIlIlllI;
            lllllllllllllIlllllIIllllIlIIlIl = 1.0;
            lllllllllllllIlllllIIllllIlIIlII = 1.0;
            lllllllllllllIlllllIIllllIlIIIll = 0.0;
            lllllllllllllIlllllIIllllIlIIIlI = 0.0;
        }
        else {
            boolean lllllllllllllIlllllIIllllIlIIlll = true;
            if (lllllllllllllIlllllIIllllIlIllIl > lllllllllllllIlllllIIllllIlIlllI) {
                lllllllllllllIlllllIIllllIllllII = 2;
                if (lllllllllllllIlllllIIllllIlIlllI / lllllllllllllIlllllIIllllIlIllIl < 1.0E-10) {
                    lllllllllllllIlllllIIllllIlIIlll = false;
                    lllllllllllllIlllllIIllllIlIIIII = lllllllllllllIlllllIIllllIlIllIl;
                    if (lllllllllllllIlllllIIllllIlIllII > 1.0) {
                        lllllllllllllIlllllIIllllIlIIIIl = lllllllllllllIlllllIIllllIlIlllI / (lllllllllllllIlllllIIllllIlIllIl / lllllllllllllIlllllIIllllIlIllII);
                    }
                    else {
                        lllllllllllllIlllllIIllllIlIIIIl = lllllllllllllIlllllIIllllIlIlllI / lllllllllllllIlllllIIllllIlIllIl * lllllllllllllIlllllIIllllIlIllII;
                    }
                    lllllllllllllIlllllIIllllIlIIlIl = 1.0;
                    lllllllllllllIlllllIIllllIlIIIll = lllllllllllllIlllllIIllllIlIlIIl / lllllllllllllIlllllIIllllIlIlIlI;
                    lllllllllllllIlllllIIllllIlIIIlI = 1.0;
                    lllllllllllllIlllllIIllllIlIIlII = lllllllllllllIlllllIIllllIlIlIll / lllllllllllllIlllllIIllllIlIlIlI;
                }
            }
            if (lllllllllllllIlllllIIllllIlIIlll) {
                double lllllllllllllIlllllIIllllIllIlll = lllllllllllllIlllllIIllllIlIlllI - lllllllllllllIlllllIIllllIlIllII;
                double lllllllllllllIlllllIIllllIllIlIl = 0.0;
                if (lllllllllllllIlllllIIllllIllIlll == lllllllllllllIlllllIIllllIlIlllI) {
                    final double lllllllllllllIlllllIIllllIllIllI = 1.0;
                }
                else {
                    lllllllllllllIlllllIIllllIllIlIl = lllllllllllllIlllllIIllllIllIlll / lllllllllllllIlllllIIllllIlIlllI;
                }
                double lllllllllllllIlllllIIllllIllIlII = lllllllllllllIlllllIIllllIlIlIlI / lllllllllllllIlllllIIllllIlIlIll;
                double lllllllllllllIlllllIIllllIllIIII = 2.0 - lllllllllllllIlllllIIllllIllIlIl;
                double lllllllllllllIlllllIIllllIlIlIII = lllllllllllllIlllllIIllllIllIlII * lllllllllllllIlllllIIllllIllIlII;
                double lllllllllllllIlllllIIllllIlIIllI = lllllllllllllIlllllIIllllIllIIII * lllllllllllllIlllllIIllllIllIIII;
                double lllllllllllllIlllllIIllllIllIIIl = Math.sqrt(lllllllllllllIlllllIIllllIlIIllI + lllllllllllllIlllllIIllllIlIlIII);
                double lllllllllllllIlllllIIllllIllIIlI = 0.0;
                if (lllllllllllllIlllllIIllllIllIlIl == 0.0) {
                    final double lllllllllllllIlllllIIllllIllIIll = Math.abs(lllllllllllllIlllllIIllllIllIlII);
                }
                else {
                    lllllllllllllIlllllIIllllIllIIlI = Math.sqrt(lllllllllllllIlllllIIllllIllIlIl * lllllllllllllIlllllIIllllIllIlIl + lllllllllllllIlllllIIllllIlIlIII);
                }
                double lllllllllllllIlllllIIllllIlllIII = (lllllllllllllIlllllIIllllIllIIIl + lllllllllllllIlllllIIllllIllIIlI) * 0.5;
                if (lllllllllllllIlllllIIllllIlIllIl > lllllllllllllIlllllIIllllIlIlllI) {
                    lllllllllllllIlllllIIllllIllllII = 2;
                    if (lllllllllllllIlllllIIllllIlIlllI / lllllllllllllIlllllIIllllIlIllIl < 1.0E-10) {
                        lllllllllllllIlllllIIllllIlIIlll = false;
                        lllllllllllllIlllllIIllllIlIIIII = lllllllllllllIlllllIIllllIlIllIl;
                        if (lllllllllllllIlllllIIllllIlIllII > 1.0) {
                            lllllllllllllIlllllIIllllIlIIIIl = lllllllllllllIlllllIIllllIlIlllI / (lllllllllllllIlllllIIllllIlIllIl / lllllllllllllIlllllIIllllIlIllII);
                        }
                        else {
                            lllllllllllllIlllllIIllllIlIIIIl = lllllllllllllIlllllIIllllIlIlllI / lllllllllllllIlllllIIllllIlIllIl * lllllllllllllIlllllIIllllIlIllII;
                        }
                        lllllllllllllIlllllIIllllIlIIlIl = 1.0;
                        lllllllllllllIlllllIIllllIlIIIll = lllllllllllllIlllllIIllllIlIlIIl / lllllllllllllIlllllIIllllIlIlIlI;
                        lllllllllllllIlllllIIllllIlIIIlI = 1.0;
                        lllllllllllllIlllllIIllllIlIIlII = lllllllllllllIlllllIIllllIlIlIll / lllllllllllllIlllllIIllllIlIlIlI;
                    }
                }
                if (lllllllllllllIlllllIIllllIlIIlll) {
                    lllllllllllllIlllllIIllllIllIlll = lllllllllllllIlllllIIllllIlIlllI - lllllllllllllIlllllIIllllIlIllII;
                    if (lllllllllllllIlllllIIllllIllIlll == lllllllllllllIlllllIIllllIlIlllI) {
                        lllllllllllllIlllllIIllllIllIlIl = 1.0;
                    }
                    else {
                        lllllllllllllIlllllIIllllIllIlIl = lllllllllllllIlllllIIllllIllIlll / lllllllllllllIlllllIIllllIlIlllI;
                    }
                    lllllllllllllIlllllIIllllIllIlII = lllllllllllllIlllllIIllllIlIlIlI / lllllllllllllIlllllIIllllIlIlIll;
                    lllllllllllllIlllllIIllllIllIIII = 2.0 - lllllllllllllIlllllIIllllIllIlIl;
                    lllllllllllllIlllllIIllllIlIlIII = lllllllllllllIlllllIIllllIllIlII * lllllllllllllIlllllIIllllIllIlII;
                    lllllllllllllIlllllIIllllIlIIllI = lllllllllllllIlllllIIllllIllIIII * lllllllllllllIlllllIIllllIllIIII;
                    lllllllllllllIlllllIIllllIllIIIl = Math.sqrt(lllllllllllllIlllllIIllllIlIIllI + lllllllllllllIlllllIIllllIlIlIII);
                    if (lllllllllllllIlllllIIllllIllIlIl == 0.0) {
                        lllllllllllllIlllllIIllllIllIIlI = Math.abs(lllllllllllllIlllllIIllllIllIlII);
                    }
                    else {
                        lllllllllllllIlllllIIllllIllIIlI = Math.sqrt(lllllllllllllIlllllIIllllIllIlIl * lllllllllllllIlllllIIllllIllIlIl + lllllllllllllIlllllIIllllIlIlIII);
                    }
                    lllllllllllllIlllllIIllllIlllIII = (lllllllllllllIlllllIIllllIllIIIl + lllllllllllllIlllllIIllllIllIIlI) * 0.5;
                    lllllllllllllIlllllIIllllIlIIIIl = lllllllllllllIlllllIIllllIlIllII / lllllllllllllIlllllIIllllIlllIII;
                    lllllllllllllIlllllIIllllIlIIIII = lllllllllllllIlllllIIllllIlIlllI * lllllllllllllIlllllIIllllIlllIII;
                    if (lllllllllllllIlllllIIllllIlIlIII == 0.0) {
                        if (lllllllllllllIlllllIIllllIllIlIl == 0.0) {
                            lllllllllllllIlllllIIllllIllIIII = d_sign(lllllllllllllIlllllIIllllIllllll, lllllllllllllIlllllIIllllIlIlIll) * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIllllIlIlIlI);
                        }
                        else {
                            lllllllllllllIlllllIIllllIllIIII = lllllllllllllIlllllIIllllIlIlIlI / d_sign(lllllllllllllIlllllIIllllIllIlll, lllllllllllllIlllllIIllllIlIlIll) + lllllllllllllIlllllIIllllIllIlII / lllllllllllllIlllllIIllllIllIIII;
                        }
                    }
                    else {
                        lllllllllllllIlllllIIllllIllIIII = (lllllllllllllIlllllIIllllIllIlII / (lllllllllllllIlllllIIllllIllIIIl + lllllllllllllIlllllIIllllIllIIII) + lllllllllllllIlllllIIllllIllIlII / (lllllllllllllIlllllIIllllIllIIlI + lllllllllllllIlllllIIllllIllIlIl)) * (lllllllllllllIlllllIIllllIlllIII + 1.0);
                    }
                    lllllllllllllIlllllIIllllIllIlIl = Math.sqrt(lllllllllllllIlllllIIllllIllIIII * lllllllllllllIlllllIIllllIllIIII + 4.0);
                    lllllllllllllIlllllIIllllIlIIlII = 2.0 / lllllllllllllIlllllIIllllIllIlIl;
                    lllllllllllllIlllllIIllllIlIIIlI = lllllllllllllIlllllIIllllIllIIII / lllllllllllllIlllllIIllllIllIlIl;
                    lllllllllllllIlllllIIllllIlIIlIl = (lllllllllllllIlllllIIllllIlIIlII + lllllllllllllIlllllIIllllIlIIIlI * lllllllllllllIlllllIIllllIllIlII) / lllllllllllllIlllllIIllllIlllIII;
                    lllllllllllllIlllllIIllllIlIIIll = lllllllllllllIlllllIIllllIlIlIIl / lllllllllllllIlllllIIllllIlIlIll * lllllllllllllIlllllIIllllIlIIIlI / lllllllllllllIlllllIIllllIlllIII;
                }
            }
            if (lllllllllllllIlllllIIllllIlllIIl) {
                lllllllllllllIlllllIIlllllIIIIll[0] = lllllllllllllIlllllIIllllIlIIIlI;
                lllllllllllllIlllllIIlllllIIIlII[0] = lllllllllllllIlllllIIllllIlIIlII;
                lllllllllllllIlllllIIllllIIlIlll[0] = lllllllllllllIlllllIIllllIlIIIll;
                lllllllllllllIlllllIIllllIIllIII[0] = lllllllllllllIlllllIIllllIlIIlIl;
            }
            else {
                lllllllllllllIlllllIIlllllIIIIll[0] = lllllllllllllIlllllIIllllIlIIlIl;
                lllllllllllllIlllllIIlllllIIIlII[0] = lllllllllllllIlllllIIllllIlIIIll;
                lllllllllllllIlllllIIllllIIlIlll[0] = lllllllllllllIlllllIIllllIlIIlII;
                lllllllllllllIlllllIIllllIIllIII[0] = lllllllllllllIlllllIIllllIlIIIlI;
            }
            if (lllllllllllllIlllllIIllllIllllII == 1) {
                lllllllllllllIlllllIIllllIlIllll = d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIllllIIlIlll[0]) * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIlllllIIIIll[0]) * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIllllIIlllll);
            }
            if (lllllllllllllIlllllIIllllIllllII == 2) {
                lllllllllllllIlllllIIllllIlIllll = d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIllllIIllIII[0]) * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIlllllIIIIll[0]) * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIllllIIlllIl);
            }
            if (lllllllllllllIlllllIIllllIllllII == 3) {
                lllllllllllllIlllllIIllllIlIllll = d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIllllIIllIII[0]) * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIlllllIIIlII[0]) * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIlllllIIIllI);
            }
            lllllllllllllIlllllIIllllIIllIll[lllllllllllllIlllllIIlllllIIIIII] = d_sign(lllllllllllllIlllllIIllllIlIIIII, lllllllllllllIlllllIIllllIlIllll);
            final double lllllllllllllIlllllIIllllIllllIl = lllllllllllllIlllllIIllllIlIllll * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIllllIIlllll) * d_sign(lllllllllllllIlllllIIllllIlllllI, lllllllllllllIlllllIIlllllIIIllI);
            lllllllllllllIlllllIIllllIIllIll[lllllllllllllIlllllIIlllllIIIIII + 1] = d_sign(lllllllllllllIlllllIIllllIlIIIIl, lllllllllllllIlllllIIllllIllllIl);
        }
        return 0;
    }
    
    static double d_sign(final double lllllllllllllIlllllIIlllIIllIlll, final double lllllllllllllIlllllIIlllIIllIllI) {
        final double lllllllllllllIlllllIIlllIIlllIII = (lllllllllllllIlllllIIlllIIllIlll >= 0.0) ? lllllllllllllIlllllIIlllIIllIlll : (-lllllllllllllIlllllIIlllIIllIlll);
        return (lllllllllllllIlllllIIlllIIllIllI >= 0.0) ? lllllllllllllIlllllIIlllIIlllIII : (-lllllllllllllIlllllIIlllIIlllIII);
    }
    
    private static void print_se(final double[] lllllllllllllIlllllIlIIlIIlIIllI, final double[] lllllllllllllIlllllIlIIlIIlIIIll) {
        System.out.println(String.valueOf(new StringBuilder("\ns =").append(lllllllllllllIlllllIlIIlIIlIIllI[0]).append(" ").append(lllllllllllllIlllllIlIIlIIlIIllI[1]).append(" ").append(lllllllllllllIlllllIlIIlIIlIIllI[2])));
        System.out.println(String.valueOf(new StringBuilder("e =").append(lllllllllllllIlllllIlIIlIIlIIIll[0]).append(" ").append(lllllllllllllIlllllIlIIlIIlIIIll[1])));
    }
    
    static {
        debug = false;
    }
}
