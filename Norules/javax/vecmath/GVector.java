package javax.vecmath;

import java.io.*;

public class GVector implements Serializable, Cloneable
{
    /* synthetic */ double[] values;
    private /* synthetic */ int length;
    
    public final void set(final Tuple3f lllllllllllllIlllIIllIIlllllIlII) {
        if (this.length < 3) {
            this.length = 3;
            this.values = new double[3];
        }
        this.values[0] = lllllllllllllIlllIIllIIlllllIlII.x;
        this.values[1] = lllllllllllllIlllIIllIIlllllIlII.y;
        this.values[2] = lllllllllllllIlllIIllIIlllllIlII.z;
        for (int lllllllllllllIlllIIllIIlllllIllI = 3; lllllllllllllIlllIIllIIlllllIllI < this.length; ++lllllllllllllIlllIIllIIlllllIllI) {
            this.values[lllllllllllllIlllIIllIIlllllIllI] = 0.0;
        }
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIlllIIllIIllIlllIII = 1L;
        for (int lllllllllllllIlllIIllIIllIllIlll = 0; lllllllllllllIlllIIllIIllIllIlll < this.length; ++lllllllllllllIlllIIllIIllIllIlll) {
            lllllllllllllIlllIIllIIllIlllIII = VecMathUtil.hashDoubleBits(lllllllllllllIlllIIllIIllIlllIII, this.values[lllllllllllllIlllIIllIIllIllIlll]);
        }
        return VecMathUtil.hashFinish(lllllllllllllIlllIIllIIllIlllIII);
    }
    
    public final void normalize() {
        double lllllllllllllIlllIIllIlIlIlIlllI = 0.0;
        for (int lllllllllllllIlllIIllIlIlIlIllIl = 0; lllllllllllllIlllIIllIlIlIlIllIl < this.length; ++lllllllllllllIlllIIllIlIlIlIllIl) {
            lllllllllllllIlllIIllIlIlIlIlllI += this.values[lllllllllllllIlllIIllIlIlIlIllIl] * this.values[lllllllllllllIlllIIllIlIlIlIllIl];
        }
        final double lllllllllllllIlllIIllIlIlIlIllII = 1.0 / Math.sqrt(lllllllllllllIlllIIllIlIlIlIlllI);
        for (int lllllllllllllIlllIIllIlIlIlIllIl = 0; lllllllllllllIlllIIllIlIlIlIllIl < this.length; ++lllllllllllllIlllIIllIlIlIlIllIl) {
            this.values[lllllllllllllIlllIIllIlIlIlIllIl] *= lllllllllllllIlllIIllIlIlIlIllII;
        }
    }
    
    public final void sub(final GVector lllllllllllllIlllIIllIlIIllIlIlI) {
        if (this.length != lllllllllllllIlllIIllIlIIllIlIlI.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector7"));
        }
        for (int lllllllllllllIlllIIllIlIIllIlIIl = 0; lllllllllllllIlllIIllIlIIllIlIIl < this.length; ++lllllllllllllIlllIIllIlIIllIlIIl) {
            final double[] values = this.values;
            final int n = lllllllllllllIlllIIllIlIIllIlIIl;
            values[n] -= lllllllllllllIlllIIllIlIIllIlIlI.values[lllllllllllllIlllIIllIlIIllIlIIl];
        }
    }
    
    public final void SVDBackSolve(final GMatrix lllllllllllllIlllIIllIIlIlIIIIll, final GMatrix lllllllllllllIlllIIllIIlIlIIlIII, final GMatrix lllllllllllllIlllIIllIIlIlIIIlll, final GVector lllllllllllllIlllIIllIIlIlIIIllI) {
        if (lllllllllllllIlllIIllIIlIlIIIIll.nRow != lllllllllllllIlllIIllIIlIlIIIllI.getSize() || lllllllllllllIlllIIllIIlIlIIIIll.nRow != lllllllllllllIlllIIllIIlIlIIIIll.nCol || lllllllllllllIlllIIllIIlIlIIIIll.nRow != lllllllllllllIlllIIllIIlIlIIlIII.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector15"));
        }
        if (lllllllllllllIlllIIllIIlIlIIlIII.nCol != this.values.length || lllllllllllllIlllIIllIIlIlIIlIII.nCol != lllllllllllllIlllIIllIIlIlIIIlll.nCol || lllllllllllllIlllIIllIIlIlIIlIII.nCol != lllllllllllllIlllIIllIIlIlIIIlll.nRow) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector23"));
        }
        final GMatrix lllllllllllllIlllIIllIIlIlIIIlIl = new GMatrix(lllllllllllllIlllIIllIIlIlIIIIll.nRow, lllllllllllllIlllIIllIIlIlIIlIII.nCol);
        lllllllllllllIlllIIllIIlIlIIIlIl.mul(lllllllllllllIlllIIllIIlIlIIIIll, lllllllllllllIlllIIllIIlIlIIIlll);
        lllllllllllllIlllIIllIIlIlIIIlIl.mulTransposeRight(lllllllllllllIlllIIllIIlIlIIIIll, lllllllllllllIlllIIllIIlIlIIlIII);
        lllllllllllllIlllIIllIIlIlIIIlIl.invert();
        this.mul(lllllllllllllIlllIIllIIlIlIIIlIl, lllllllllllllIlllIIllIIlIlIIIllI);
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIlllIIllIIlllIIIIIl = new StringBuffer(this.length * 8);
        for (int lllllllllllllIlllIIllIIlllIIIIII = 0; lllllllllllllIlllIIllIIlllIIIIII < this.length; ++lllllllllllllIlllIIllIIlllIIIIII) {
            lllllllllllllIlllIIllIIlllIIIIIl.append(this.values[lllllllllllllIlllIIllIIlllIIIIII]).append(" ");
        }
        return lllllllllllllIlllIIllIIlllIIIIIl.toString();
    }
    
    public final void normalize(final GVector lllllllllllllIlllIIllIlIlIllllII) {
        double lllllllllllllIlllIIllIlIlIlllIll = 0.0;
        if (this.length != lllllllllllllIlllIIllIlIlIllllII.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector0"));
        }
        for (int lllllllllllllIlllIIllIlIlIlllIlI = 0; lllllllllllllIlllIIllIlIlIlllIlI < this.length; ++lllllllllllllIlllIIllIlIlIlllIlI) {
            lllllllllllllIlllIIllIlIlIlllIll += lllllllllllllIlllIIllIlIlIllllII.values[lllllllllllllIlllIIllIlIlIlllIlI] * lllllllllllllIlllIIllIlIlIllllII.values[lllllllllllllIlllIIllIlIlIlllIlI];
        }
        final double lllllllllllllIlllIIllIlIlIlllIIl = 1.0 / Math.sqrt(lllllllllllllIlllIIllIlIlIlllIll);
        for (int lllllllllllllIlllIIllIlIlIlllIlI = 0; lllllllllllllIlllIIllIlIlIlllIlI < this.length; ++lllllllllllllIlllIIllIlIlIlllIlI) {
            this.values[lllllllllllllIlllIIllIlIlIlllIlI] = lllllllllllllIlllIIllIlIlIllllII.values[lllllllllllllIlllIIllIlIlIlllIlI] * lllllllllllllIlllIIllIlIlIlllIIl;
        }
    }
    
    public final void add(final GVector lllllllllllllIlllIIllIlIIlllllII) {
        if (this.length != lllllllllllllIlllIIllIlIIlllllII.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector4"));
        }
        for (int lllllllllllllIlllIIllIlIIllllllI = 0; lllllllllllllIlllIIllIlIIllllllI < this.length; ++lllllllllllllIlllIIllIlIIllllllI) {
            final double[] values = this.values;
            final int n = lllllllllllllIlllIIllIlIIllllllI;
            values[n] += lllllllllllllIlllIIllIlIIlllllII.values[lllllllllllllIlllIIllIlIIllllllI];
        }
    }
    
    public final double dot(final GVector lllllllllllllIlllIIllIIlIllIllll) {
        if (this.length != lllllllllllllIlllIIllIIlIllIllll.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector14"));
        }
        double lllllllllllllIlllIIllIIlIllIllII = 0.0;
        for (int lllllllllllllIlllIIllIIlIllIlIlI = 0; lllllllllllllIlllIIllIIlIllIlIlI < this.length; ++lllllllllllllIlllIIllIIlIllIlIlI) {
            lllllllllllllIlllIIllIIlIllIllII += this.values[lllllllllllllIlllIIllIIlIllIlIlI] * lllllllllllllIlllIIllIIlIllIllll.values[lllllllllllllIlllIIllIIlIllIlIlI];
        }
        return lllllllllllllIlllIIllIIlIllIllII;
    }
    
    public final void set(final double[] lllllllllllllIlllIIllIlIIIIlIIll) {
        for (int lllllllllllllIlllIIllIlIIIIlIIlI = this.length - 1; lllllllllllllIlllIIllIlIIIIlIIlI >= 0; --lllllllllllllIlllIIllIlIIIIlIIlI) {
            this.values[lllllllllllllIlllIIllIlIIIIlIIlI] = lllllllllllllIlllIIllIlIIIIlIIll[lllllllllllllIlllIIllIlIIIIlIIlI];
        }
    }
    
    public GVector(final GVector lllllllllllllIlllIIllIllIIIIIIII) {
        this.values = new double[lllllllllllllIlllIIllIllIIIIIIII.length];
        this.length = lllllllllllllIlllIIllIllIIIIIIII.length;
        for (int lllllllllllllIlllIIllIllIIIIIIlI = 0; lllllllllllllIlllIIllIllIIIIIIlI < this.length; ++lllllllllllllIlllIIllIllIIIIIIlI) {
            this.values[lllllllllllllIlllIIllIllIIIIIIlI] = lllllllllllllIlllIIllIllIIIIIIII.values[lllllllllllllIlllIIllIllIIIIIIlI];
        }
    }
    
    public Object clone() {
        GVector lllllllllllllIlllIIllIIIlIllIllI = null;
        try {
            lllllllllllllIlllIIllIIIlIllIllI = (GVector)super.clone();
        }
        catch (CloneNotSupportedException lllllllllllllIlllIIllIIIlIllIlIl) {
            throw new InternalError();
        }
        lllllllllllllIlllIIllIIIlIllIllI.values = new double[this.length];
        for (int lllllllllllllIlllIIllIIIlIllIIll = 0; lllllllllllllIlllIIllIIIlIllIIll < this.length; ++lllllllllllllIlllIIllIIIlIllIIll) {
            lllllllllllllIlllIIllIIIlIllIllI.values[lllllllllllllIlllIIllIIIlIllIIll] = this.values[lllllllllllllIlllIIllIIIlIllIIll];
        }
        return lllllllllllllIlllIIllIIIlIllIllI;
    }
    
    public GVector(final int lllllllllllllIlllIIllIllIIIlIlIl) {
        this.length = lllllllllllllIlllIIllIllIIIlIlIl;
        this.values = new double[lllllllllllllIlllIIllIllIIIlIlIl];
        for (int lllllllllllllIlllIIllIllIIIlIlII = 0; lllllllllllllIlllIIllIllIIIlIlII < lllllllllllllIlllIIllIllIIIlIlIl; ++lllllllllllllIlllIIllIllIIIlIlII) {
            this.values[lllllllllllllIlllIIllIllIIIlIlII] = 0.0;
        }
    }
    
    public final void set(final Tuple4f lllllllllllllIlllIIllIIllllIIIlI) {
        if (this.length < 4) {
            this.length = 4;
            this.values = new double[4];
        }
        this.values[0] = lllllllllllllIlllIIllIIllllIIIlI.x;
        this.values[1] = lllllllllllllIlllIIllIIllllIIIlI.y;
        this.values[2] = lllllllllllllIlllIIllIIllllIIIlI.z;
        this.values[3] = lllllllllllllIlllIIllIIllllIIIlI.w;
        for (int lllllllllllllIlllIIllIIllllIIlII = 4; lllllllllllllIlllIIllIIllllIIlII < this.length; ++lllllllllllllIlllIIllIIllllIIlII) {
            this.values[lllllllllllllIlllIIllIIllllIIlII] = 0.0;
        }
    }
    
    public final void setSize(final int lllllllllllllIlllIIllIlIIIlIIIIl) {
        final double[] lllllllllllllIlllIIllIlIIIlIIIII = new double[lllllllllllllIlllIIllIlIIIlIIIIl];
        int lllllllllllllIlllIIllIlIIIIlllIl = 0;
        if (this.length < lllllllllllllIlllIIllIlIIIlIIIIl) {
            final int lllllllllllllIlllIIllIlIIIIllllI = this.length;
        }
        else {
            lllllllllllllIlllIIllIlIIIIlllIl = lllllllllllllIlllIIllIlIIIlIIIIl;
        }
        for (int lllllllllllllIlllIIllIlIIIIlllll = 0; lllllllllllllIlllIIllIlIIIIlllll < lllllllllllllIlllIIllIlIIIIlllIl; ++lllllllllllllIlllIIllIlIIIIlllll) {
            lllllllllllllIlllIIllIlIIIlIIIII[lllllllllllllIlllIIllIlIIIIlllll] = this.values[lllllllllllllIlllIIllIlIIIIlllll];
        }
        this.length = lllllllllllllIlllIIllIlIIIlIIIIl;
        this.values = lllllllllllllIlllIIllIlIIIlIIIII;
    }
    
    public GVector(final Tuple2f lllllllllllllIlllIIllIlIlllllIIl) {
        this.values = new double[2];
        this.values[0] = lllllllllllllIlllIIllIlIlllllIIl.x;
        this.values[1] = lllllllllllllIlllIIllIlIlllllIIl.y;
        this.length = 2;
    }
    
    public GVector(final Tuple4f lllllllllllllIlllIIllIlIlllIlIIl) {
        this.values = new double[4];
        this.values[0] = lllllllllllllIlllIIllIlIlllIlIIl.x;
        this.values[1] = lllllllllllllIlllIIllIlIlllIlIIl.y;
        this.values[2] = lllllllllllllIlllIIllIlIlllIlIIl.z;
        this.values[3] = lllllllllllllIlllIIllIlIlllIlIIl.w;
        this.length = 4;
    }
    
    public final double norm() {
        double lllllllllllllIlllIIllIlIllIlIIII = 0.0;
        for (int lllllllllllllIlllIIllIlIllIIllll = 0; lllllllllllllIlllIIllIlIllIIllll < this.length; ++lllllllllllllIlllIIllIlIllIIllll) {
            lllllllllllllIlllIIllIlIllIlIIII += this.values[lllllllllllllIlllIIllIlIllIIllll] * this.values[lllllllllllllIlllIIllIlIllIIllll];
        }
        return Math.sqrt(lllllllllllllIlllIIllIlIllIlIIII);
    }
    
    public final void scaleAdd(final double lllllllllllllIlllIIllIlIlIIIllII, final GVector lllllllllllllIlllIIllIlIlIIIIllI, final GVector lllllllllllllIlllIIllIlIlIIIIlIl) {
        if (lllllllllllllIlllIIllIlIlIIIIlIl.length != lllllllllllllIlllIIllIlIlIIIIllI.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector2"));
        }
        if (this.length != lllllllllllllIlllIIllIlIlIIIIllI.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector3"));
        }
        for (int lllllllllllllIlllIIllIlIlIIIlIIl = 0; lllllllllllllIlllIIllIlIlIIIlIIl < this.length; ++lllllllllllllIlllIIllIlIlIIIlIIl) {
            this.values[lllllllllllllIlllIIllIlIlIIIlIIl] = lllllllllllllIlllIIllIlIlIIIIllI.values[lllllllllllllIlllIIllIlIlIIIlIIl] * lllllllllllllIlllIIllIlIlIIIllII + lllllllllllllIlllIIllIlIlIIIIlIl.values[lllllllllllllIlllIIllIlIlIIIlIIl];
        }
    }
    
    public final void mul(final GMatrix lllllllllllllIlllIIllIlIIlIIlIll, final GVector lllllllllllllIlllIIllIlIIlIlIIIl) {
        if (lllllllllllllIlllIIllIlIIlIIlIll.getNumCol() != lllllllllllllIlllIIllIlIIlIlIIIl.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector10"));
        }
        if (this.length != lllllllllllllIlllIIllIlIIlIIlIll.getNumRow()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector11"));
        }
        double[] lllllllllllllIlllIIllIlIIlIIllll = null;
        if (lllllllllllllIlllIIllIlIIlIlIIIl != this) {
            final double[] lllllllllllllIlllIIllIlIIlIlIIII = lllllllllllllIlllIIllIlIIlIlIIIl.values;
        }
        else {
            lllllllllllllIlllIIllIlIIlIIllll = this.values.clone();
        }
        for (int lllllllllllllIlllIIllIlIIlIIlllI = this.length - 1; lllllllllllllIlllIIllIlIIlIIlllI >= 0; --lllllllllllllIlllIIllIlIIlIIlllI) {
            this.values[lllllllllllllIlllIIllIlIIlIIlllI] = 0.0;
            for (int lllllllllllllIlllIIllIlIIlIIllIl = lllllllllllllIlllIIllIlIIlIlIIIl.length - 1; lllllllllllllIlllIIllIlIIlIIllIl >= 0; --lllllllllllllIlllIIllIlIIlIIllIl) {
                final double[] values = this.values;
                final int n = lllllllllllllIlllIIllIlIIlIIlllI;
                values[n] += lllllllllllllIlllIIllIlIIlIIlIll.values[lllllllllllllIlllIIllIlIIlIIlllI][lllllllllllllIlllIIllIlIIlIIllIl] * lllllllllllllIlllIIllIlIIlIIllll[lllllllllllllIlllIIllIlIIlIIllIl];
            }
        }
    }
    
    public final void scale(final double lllllllllllllIlllIIllIlIlIlIIIlI, final GVector lllllllllllllIlllIIllIlIlIlIIIIl) {
        if (this.length != lllllllllllllIlllIIllIlIlIlIIIIl.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector1"));
        }
        for (int lllllllllllllIlllIIllIlIlIlIIIII = 0; lllllllllllllIlllIIllIlIlIlIIIII < this.length; ++lllllllllllllIlllIIllIlIlIlIIIII) {
            this.values[lllllllllllllIlllIIllIlIlIlIIIII] = lllllllllllllIlllIIllIlIlIlIIIIl.values[lllllllllllllIlllIIllIlIlIlIIIII] * lllllllllllllIlllIIllIlIlIlIIIlI;
        }
    }
    
    public GVector(final Tuple3f lllllllllllllIlllIIllIlIllllIIll) {
        this.values = new double[3];
        this.values[0] = lllllllllllllIlllIIllIlIllllIIll.x;
        this.values[1] = lllllllllllllIlllIIllIlIllllIIll.y;
        this.values[2] = lllllllllllllIlllIIllIlIllllIIll.z;
        this.length = 3;
    }
    
    @Deprecated
    public final void interpolate(final GVector lllllllllllllIlllIIllIIlIIIIlIIl, final GVector lllllllllllllIlllIIllIIlIIIIIlII, final float lllllllllllllIlllIIllIIlIIIIIlll) {
        this.interpolate(lllllllllllllIlllIIllIIlIIIIlIIl, lllllllllllllIlllIIllIIlIIIIIlII, (double)lllllllllllllIlllIIllIIlIIIIIlll);
    }
    
    @Deprecated
    public final void interpolate(final GVector lllllllllllllIlllIIllIIIlllllIIl, final float lllllllllllllIlllIIllIIIllllllIl) {
        this.interpolate(lllllllllllllIlllIIllIIIlllllIIl, (double)lllllllllllllIlllIIllIIIllllllIl);
    }
    
    public final void LUDBackSolve(final GMatrix lllllllllllllIlllIIllIIlIIlIIlIl, final GVector lllllllllllllIlllIIllIIlIIllIIlI, final GVector lllllllllllllIlllIIllIIlIIllIIIl) {
        final int lllllllllllllIlllIIllIIlIIllIIII = lllllllllllllIlllIIllIIlIIlIIlIl.nRow * lllllllllllllIlllIIllIIlIIlIIlIl.nCol;
        final double[] lllllllllllllIlllIIllIIlIIlIlllI = new double[lllllllllllllIlllIIllIIlIIllIIII];
        final double[] lllllllllllllIlllIIllIIlIIlIllIl = new double[lllllllllllllIlllIIllIIlIIllIIII];
        final int[] lllllllllllllIlllIIllIIlIIlIlIll = new int[lllllllllllllIlllIIllIIlIIllIIlI.getSize()];
        if (lllllllllllllIlllIIllIIlIIlIIlIl.nRow != lllllllllllllIlllIIllIIlIIllIIlI.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector16"));
        }
        if (lllllllllllllIlllIIllIIlIIlIIlIl.nRow != lllllllllllllIlllIIllIIlIIllIIIl.getSize()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector24"));
        }
        if (lllllllllllllIlllIIllIIlIIlIIlIl.nRow != lllllllllllllIlllIIllIIlIIlIIlIl.nCol) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector25"));
        }
        for (int lllllllllllllIlllIIllIIlIIlIlIlI = 0; lllllllllllllIlllIIllIIlIIlIlIlI < lllllllllllllIlllIIllIIlIIlIIlIl.nRow; ++lllllllllllllIlllIIllIIlIIlIlIlI) {
            for (int lllllllllllllIlllIIllIIlIIlIlIII = 0; lllllllllllllIlllIIllIIlIIlIlIII < lllllllllllllIlllIIllIIlIIlIIlIl.nCol; ++lllllllllllllIlllIIllIIlIIlIlIII) {
                lllllllllllllIlllIIllIIlIIlIlllI[lllllllllllllIlllIIllIIlIIlIlIlI * lllllllllllllIlllIIllIIlIIlIIlIl.nCol + lllllllllllllIlllIIllIIlIIlIlIII] = lllllllllllllIlllIIllIIlIIlIIlIl.values[lllllllllllllIlllIIllIIlIIlIlIlI][lllllllllllllIlllIIllIIlIIlIlIII];
            }
        }
        for (int lllllllllllllIlllIIllIIlIIlIlIlI = 0; lllllllllllllIlllIIllIIlIIlIlIlI < lllllllllllllIlllIIllIIlIIllIIII; ++lllllllllllllIlllIIllIIlIIlIlIlI) {
            lllllllllllllIlllIIllIIlIIlIllIl[lllllllllllllIlllIIllIIlIIlIlIlI] = 0.0;
        }
        for (int lllllllllllllIlllIIllIIlIIlIlIlI = 0; lllllllllllllIlllIIllIIlIIlIlIlI < lllllllllllllIlllIIllIIlIIlIIlIl.nRow; ++lllllllllllllIlllIIllIIlIIlIlIlI) {
            lllllllllllllIlllIIllIIlIIlIllIl[lllllllllllllIlllIIllIIlIIlIlIlI * lllllllllllllIlllIIllIIlIIlIIlIl.nCol] = lllllllllllllIlllIIllIIlIIllIIlI.values[lllllllllllllIlllIIllIIlIIlIlIlI];
        }
        for (int lllllllllllllIlllIIllIIlIIlIlIlI = 0; lllllllllllllIlllIIllIIlIIlIlIlI < lllllllllllllIlllIIllIIlIIlIIlIl.nCol; ++lllllllllllllIlllIIllIIlIIlIlIlI) {
            lllllllllllllIlllIIllIIlIIlIlIll[lllllllllllllIlllIIllIIlIIlIlIlI] = (int)lllllllllllllIlllIIllIIlIIllIIIl.values[lllllllllllllIlllIIllIIlIIlIlIlI];
        }
        GMatrix.luBacksubstitution(lllllllllllllIlllIIllIIlIIlIIlIl.nRow, lllllllllllllIlllIIllIIlIIlIlllI, lllllllllllllIlllIIllIIlIIlIlIll, lllllllllllllIlllIIllIIlIIlIllIl);
        for (int lllllllllllllIlllIIllIIlIIlIlIlI = 0; lllllllllllllIlllIIllIIlIIlIlIlI < lllllllllllllIlllIIllIIlIIlIIlIl.nRow; ++lllllllllllllIlllIIllIIlIIlIlIlI) {
            this.values[lllllllllllllIlllIIllIIlIIlIlIlI] = lllllllllllllIlllIIllIIlIIlIllIl[lllllllllllllIlllIIllIIlIIlIlIlI * lllllllllllllIlllIIllIIlIIlIIlIl.nCol];
        }
    }
    
    public final void mul(final GVector lllllllllllllIlllIIllIlIIIlllIII, final GMatrix lllllllllllllIlllIIllIlIIIlllllI) {
        if (lllllllllllllIlllIIllIlIIIlllllI.getNumRow() != lllllllllllllIlllIIllIlIIIlllIII.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector12"));
        }
        if (this.length != lllllllllllllIlllIIllIlIIIlllllI.getNumCol()) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector13"));
        }
        double[] lllllllllllllIlllIIllIlIIIllllII = null;
        if (lllllllllllllIlllIIllIlIIIlllIII != this) {
            final double[] lllllllllllllIlllIIllIlIIIllllIl = lllllllllllllIlllIIllIlIIIlllIII.values;
        }
        else {
            lllllllllllllIlllIIllIlIIIllllII = this.values.clone();
        }
        for (int lllllllllllllIlllIIllIlIIIlllIll = this.length - 1; lllllllllllllIlllIIllIlIIIlllIll >= 0; --lllllllllllllIlllIIllIlIIIlllIll) {
            this.values[lllllllllllllIlllIIllIlIIIlllIll] = 0.0;
            for (int lllllllllllllIlllIIllIlIIIlllIlI = lllllllllllllIlllIIllIlIIIlllIII.length - 1; lllllllllllllIlllIIllIlIIIlllIlI >= 0; --lllllllllllllIlllIIllIlIIIlllIlI) {
                final double[] values = this.values;
                final int n = lllllllllllllIlllIIllIlIIIlllIll;
                values[n] += lllllllllllllIlllIIllIlIIIlllllI.values[lllllllllllllIlllIIllIlIIIlllIlI][lllllllllllllIlllIIllIlIIIlllIll] * lllllllllllllIlllIIllIlIIIllllII[lllllllllllllIlllIIllIlIIIlllIlI];
            }
        }
    }
    
    public final void add(final GVector lllllllllllllIlllIIllIlIIlllIIIl, final GVector lllllllllllllIlllIIllIlIIlllIlII) {
        if (lllllllllllllIlllIIllIlIIlllIIIl.length != lllllllllllllIlllIIllIlIIlllIlII.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector5"));
        }
        if (this.length != lllllllllllllIlllIIllIlIIlllIIIl.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector6"));
        }
        for (int lllllllllllllIlllIIllIlIIlllIIll = 0; lllllllllllllIlllIIllIlIIlllIIll < this.length; ++lllllllllllllIlllIIllIlIIlllIIll) {
            this.values[lllllllllllllIlllIIllIlIIlllIIll] = lllllllllllllIlllIIllIlIIlllIIIl.values[lllllllllllllIlllIIllIlIIlllIIll] + lllllllllllllIlllIIllIlIIlllIlII.values[lllllllllllllIlllIIllIlIIlllIIll];
        }
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIIllIIllIIllllI) {
        try {
            final GVector lllllllllllllIlllIIllIIllIlIIIll = (GVector)lllllllllllllIlllIIllIIllIIllllI;
            if (this.length != lllllllllllllIlllIIllIIllIlIIIll.length) {
                return false;
            }
            for (int lllllllllllllIlllIIllIIllIlIIIlI = 0; lllllllllllllIlllIIllIIllIlIIIlI < this.length; ++lllllllllllllIlllIIllIIllIlIIIlI) {
                if (this.values[lllllllllllllIlllIIllIIllIlIIIlI] != lllllllllllllIlllIIllIIllIlIIIll.values[lllllllllllllIlllIIllIIllIlIIIlI]) {
                    return false;
                }
            }
            return true;
        }
        catch (ClassCastException lllllllllllllIlllIIllIIllIlIIIIl) {
            return false;
        }
        catch (NullPointerException lllllllllllllIlllIIllIIllIlIIIII) {
            return false;
        }
    }
    
    public GVector(final double[] lllllllllllllIlllIIllIllIIIIllII) {
        this.length = lllllllllllllIlllIIllIllIIIIllII.length;
        this.values = new double[lllllllllllllIlllIIllIllIIIIllII.length];
        for (int lllllllllllllIlllIIllIllIIIIlIll = 0; lllllllllllllIlllIIllIllIIIIlIll < this.length; ++lllllllllllllIlllIIllIllIIIIlIll) {
            this.values[lllllllllllllIlllIIllIllIIIIlIll] = lllllllllllllIlllIIllIllIIIIllII[lllllllllllllIlllIIllIllIIIIlIll];
        }
    }
    
    public final double getElement(final int lllllllllllllIlllIIllIIlllIIllll) {
        return this.values[lllllllllllllIlllIIllIIlllIIllll];
    }
    
    public final void set(final GVector lllllllllllllIlllIIllIlIIIIIlIlI) {
        if (this.length < lllllllllllllIlllIIllIlIIIIIlIlI.length) {
            this.length = lllllllllllllIlllIIllIlIIIIIlIlI.length;
            this.values = new double[this.length];
            for (int lllllllllllllIlllIIllIlIIIIIlIIl = 0; lllllllllllllIlllIIllIlIIIIIlIIl < this.length; ++lllllllllllllIlllIIllIlIIIIIlIIl) {
                this.values[lllllllllllllIlllIIllIlIIIIIlIIl] = lllllllllllllIlllIIllIlIIIIIlIlI.values[lllllllllllllIlllIIllIlIIIIIlIIl];
            }
        }
        else {
            for (int lllllllllllllIlllIIllIlIIIIIlIII = 0; lllllllllllllIlllIIllIlIIIIIlIII < lllllllllllllIlllIIllIlIIIIIlIlI.length; ++lllllllllllllIlllIIllIlIIIIIlIII) {
                this.values[lllllllllllllIlllIIllIlIIIIIlIII] = lllllllllllllIlllIIllIlIIIIIlIlI.values[lllllllllllllIlllIIllIlIIIIIlIII];
            }
            for (int lllllllllllllIlllIIllIlIIIIIlIII = lllllllllllllIlllIIllIlIIIIIlIlI.length; lllllllllllllIlllIIllIlIIIIIlIII < this.length; ++lllllllllllllIlllIIllIlIIIIIlIII) {
                this.values[lllllllllllllIlllIIllIlIIIIIlIII] = 0.0;
            }
        }
    }
    
    public final void scale(final double lllllllllllllIlllIIllIlIlIIlIlII) {
        for (int lllllllllllllIlllIIllIlIlIIlIllI = 0; lllllllllllllIlllIIllIlIlIIlIllI < this.length; ++lllllllllllllIlllIIllIlIlIIlIllI) {
            this.values[lllllllllllllIlllIIllIlIlIIlIllI] *= lllllllllllllIlllIIllIlIlIIlIlII;
        }
    }
    
    public boolean epsilonEquals(final GVector lllllllllllllIlllIIllIIllIIIllIl, final double lllllllllllllIlllIIllIIllIIIllII) {
        if (this.length != lllllllllllllIlllIIllIIllIIIllIl.length) {
            return false;
        }
        for (int lllllllllllllIlllIIllIIllIIlIIIl = 0; lllllllllllllIlllIIllIIllIIlIIIl < this.length; ++lllllllllllllIlllIIllIIllIIlIIIl) {
            final double lllllllllllllIlllIIllIIllIIlIIlI = this.values[lllllllllllllIlllIIllIIllIIlIIIl] - lllllllllllllIlllIIllIIllIIIllIl.values[lllllllllllllIlllIIllIIllIIlIIIl];
            if (((lllllllllllllIlllIIllIIllIIlIIlI < 0.0) ? (-lllllllllllllIlllIIllIIllIIlIIlI) : lllllllllllllIlllIIllIIllIIlIIlI) > lllllllllllllIlllIIllIIllIIIllII) {
                return false;
            }
        }
        return true;
    }
    
    public final int getSize() {
        return this.values.length;
    }
    
    public GVector(final Tuple4d lllllllllllllIlllIIllIlIlllIIIll) {
        this.values = new double[4];
        this.values[0] = lllllllllllllIlllIIllIlIlllIIIll.x;
        this.values[1] = lllllllllllllIlllIIllIlIlllIIIll.y;
        this.values[2] = lllllllllllllIlllIIllIlIlllIIIll.z;
        this.values[3] = lllllllllllllIlllIIllIlIlllIIIll.w;
        this.length = 4;
    }
    
    public final void sub(final GVector lllllllllllllIlllIIllIlIIlIlllII, final GVector lllllllllllllIlllIIllIlIIlIlllll) {
        if (lllllllllllllIlllIIllIlIIlIlllII.length != lllllllllllllIlllIIllIlIIlIlllll.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector8"));
        }
        if (this.length != lllllllllllllIlllIIllIlIIlIlllII.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector9"));
        }
        for (int lllllllllllllIlllIIllIlIIlIllllI = 0; lllllllllllllIlllIIllIlIIlIllllI < this.length; ++lllllllllllllIlllIIllIlIIlIllllI) {
            this.values[lllllllllllllIlllIIllIlIIlIllllI] = lllllllllllllIlllIIllIlIIlIlllII.values[lllllllllllllIlllIIllIlIIlIllllI] - lllllllllllllIlllIIllIlIIlIlllll.values[lllllllllllllIlllIIllIlIIlIllllI];
        }
    }
    
    public final void setElement(final int lllllllllllllIlllIIllIIlllIIIlll, final double lllllllllllllIlllIIllIIlllIIIllI) {
        this.values[lllllllllllllIlllIIllIIlllIIIlll] = lllllllllllllIlllIIllIIlllIIIllI;
    }
    
    public GVector(final double[] lllllllllllllIlllIIllIlIllIlIlll, final int lllllllllllllIlllIIllIlIllIllIlI) {
        this.length = lllllllllllllIlllIIllIlIllIllIlI;
        this.values = new double[lllllllllllllIlllIIllIlIllIllIlI];
        for (int lllllllllllllIlllIIllIlIllIllIIl = 0; lllllllllllllIlllIIllIlIllIllIIl < lllllllllllllIlllIIllIlIllIllIlI; ++lllllllllllllIlllIIllIlIllIllIIl) {
            this.values[lllllllllllllIlllIIllIlIllIllIIl] = lllllllllllllIlllIIllIlIllIlIlll[lllllllllllllIlllIIllIlIllIllIIl];
        }
    }
    
    public final void negate() {
        for (int lllllllllllllIlllIIllIlIIIllIIII = this.length - 1; lllllllllllllIlllIIllIlIIIllIIII >= 0; --lllllllllllllIlllIIllIlIIIllIIII) {
            final double[] values = this.values;
            final int n = lllllllllllllIlllIIllIlIIIllIIII;
            values[n] *= -1.0;
        }
    }
    
    public final double angle(final GVector lllllllllllllIlllIIllIIlIIIIllll) {
        return Math.acos(this.dot(lllllllllllllIlllIIllIIlIIIIllll) / (this.norm() * lllllllllllllIlllIIllIIlIIIIllll.norm()));
    }
    
    public final void zero() {
        for (int lllllllllllllIlllIIllIlIIIlIlIlI = 0; lllllllllllllIlllIIllIlIIIlIlIlI < this.length; ++lllllllllllllIlllIIllIlIIIlIlIlI) {
            this.values[lllllllllllllIlllIIllIlIIIlIlIlI] = 0.0;
        }
    }
    
    public final void set(final Tuple4d lllllllllllllIlllIIllIIlllIllIIl) {
        if (this.length < 4) {
            this.length = 4;
            this.values = new double[4];
        }
        this.values[0] = lllllllllllllIlllIIllIIlllIllIIl.x;
        this.values[1] = lllllllllllllIlllIIllIIlllIllIIl.y;
        this.values[2] = lllllllllllllIlllIIllIIlllIllIIl.z;
        this.values[3] = lllllllllllllIlllIIllIIlllIllIIl.w;
        for (int lllllllllllllIlllIIllIIlllIllIll = 4; lllllllllllllIlllIIllIIlllIllIll < this.length; ++lllllllllllllIlllIIllIIlllIllIll) {
            this.values[lllllllllllllIlllIIllIIlllIllIll] = 0.0;
        }
    }
    
    public final void set(final Tuple3d lllllllllllllIlllIIllIIllllIlIll) {
        if (this.length < 3) {
            this.length = 3;
            this.values = new double[3];
        }
        this.values[0] = lllllllllllllIlllIIllIIllllIlIll.x;
        this.values[1] = lllllllllllllIlllIIllIIllllIlIll.y;
        this.values[2] = lllllllllllllIlllIIllIIllllIlIll.z;
        for (int lllllllllllllIlllIIllIIllllIllIl = 3; lllllllllllllIlllIIllIIllllIllIl < this.length; ++lllllllllllllIlllIIllIIllllIllIl) {
            this.values[lllllllllllllIlllIIllIIllllIllIl] = 0.0;
        }
    }
    
    public GVector(final Tuple3d lllllllllllllIlllIIllIlIlllIllIl) {
        this.values = new double[3];
        this.values[0] = lllllllllllllIlllIIllIlIlllIllIl.x;
        this.values[1] = lllllllllllllIlllIIllIlIlllIllIl.y;
        this.values[2] = lllllllllllllIlllIIllIlIlllIllIl.z;
        this.length = 3;
    }
    
    public final void interpolate(final GVector lllllllllllllIlllIIllIIIlllIIIll, final GVector lllllllllllllIlllIIllIIIlllIIIIl, final double lllllllllllllIlllIIllIIIllIllIII) {
        if (lllllllllllllIlllIIllIIIlllIIIIl.length != lllllllllllllIlllIIllIIIlllIIIll.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector20"));
        }
        if (this.length != lllllllllllllIlllIIllIIIlllIIIll.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector21"));
        }
        for (int lllllllllllllIlllIIllIIIllIllllI = 0; lllllllllllllIlllIIllIIIllIllllI < this.length; ++lllllllllllllIlllIIllIIIllIllllI) {
            this.values[lllllllllllllIlllIIllIIIllIllllI] = (1.0 - lllllllllllllIlllIIllIIIllIllIII) * lllllllllllllIlllIIllIIIlllIIIll.values[lllllllllllllIlllIIllIIIllIllllI] + lllllllllllllIlllIIllIIIllIllIII * lllllllllllllIlllIIllIIIlllIIIIl.values[lllllllllllllIlllIIllIIIllIllllI];
        }
    }
    
    public final void interpolate(final GVector lllllllllllllIlllIIllIIIllIIIllI, final double lllllllllllllIlllIIllIIIllIIIlII) {
        if (lllllllllllllIlllIIllIIIllIIIllI.length != this.length) {
            throw new MismatchedSizeException(VecMathI18N.getString("GVector22"));
        }
        for (int lllllllllllllIlllIIllIIIllIIlIIl = 0; lllllllllllllIlllIIllIIIllIIlIIl < this.length; ++lllllllllllllIlllIIllIIIllIIlIIl) {
            this.values[lllllllllllllIlllIIllIIIllIIlIIl] = (1.0 - lllllllllllllIlllIIllIIIllIIIlII) * this.values[lllllllllllllIlllIIllIIIllIIlIIl] + lllllllllllllIlllIIllIIIllIIIlII * lllllllllllllIlllIIllIIIllIIIllI.values[lllllllllllllIlllIIllIIIllIIlIIl];
        }
    }
    
    public final double normSquared() {
        double lllllllllllllIlllIIllIlIllIIIlll = 0.0;
        for (int lllllllllllllIlllIIllIlIllIIIllI = 0; lllllllllllllIlllIIllIlIllIIIllI < this.length; ++lllllllllllllIlllIIllIlIllIIIllI) {
            lllllllllllllIlllIIllIlIllIIIlll += this.values[lllllllllllllIlllIIllIlIllIIIllI] * this.values[lllllllllllllIlllIIllIlIllIIIllI];
        }
        return lllllllllllllIlllIIllIlIllIIIlll;
    }
    
    public boolean equals(final GVector lllllllllllllIlllIIllIIllIlIlIll) {
        try {
            if (this.length != lllllllllllllIlllIIllIIllIlIlIll.length) {
                return false;
            }
            for (int lllllllllllllIlllIIllIIllIlIlllI = 0; lllllllllllllIlllIIllIIllIlIlllI < this.length; ++lllllllllllllIlllIIllIIllIlIlllI) {
                if (this.values[lllllllllllllIlllIIllIIllIlIlllI] != lllllllllllllIlllIIllIIllIlIlIll.values[lllllllllllllIlllIIllIIllIlIlllI]) {
                    return false;
                }
            }
            return true;
        }
        catch (NullPointerException lllllllllllllIlllIIllIIllIlIllIl) {
            return false;
        }
    }
    
    public final void set(final Tuple2f lllllllllllllIlllIIllIlIIIIIIIII) {
        if (this.length < 2) {
            this.length = 2;
            this.values = new double[2];
        }
        this.values[0] = lllllllllllllIlllIIllIlIIIIIIIII.x;
        this.values[1] = lllllllllllllIlllIIllIlIIIIIIIII.y;
        for (int lllllllllllllIlllIIllIIlllllllll = 2; lllllllllllllIlllIIllIIlllllllll < this.length; ++lllllllllllllIlllIIllIIlllllllll) {
            this.values[lllllllllllllIlllIIllIIlllllllll] = 0.0;
        }
    }
}
