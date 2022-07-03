package net.minecraft.util.math;

import javax.annotation.*;

public class Vec3d
{
    public final /* synthetic */ double zCoord;
    public final /* synthetic */ double yCoord;
    public static final /* synthetic */ Vec3d ZERO;
    public final /* synthetic */ double xCoord;
    
    public static Vec3d fromPitchYawVector(final Vec2f lllllllllllllIIIIIlIIIlIlllIIlII) {
        return fromPitchYaw(lllllllllllllIIIIIlIIIlIlllIIlII.x, lllllllllllllIIIIIlIIIlIlllIIlII.y);
    }
    
    public Vec3d(double lllllllllllllIIIIIlIIIlllllIlIII, double lllllllllllllIIIIIlIIIlllllIIlll, double lllllllllllllIIIIIlIIIlllllIIllI) {
        if (lllllllllllllIIIIIlIIIlllllIlIII == -0.0) {
            lllllllllllllIIIIIlIIIlllllIlIII = 0.0;
        }
        if (lllllllllllllIIIIIlIIIlllllIIlll == -0.0) {
            lllllllllllllIIIIIlIIIlllllIIlll = 0.0;
        }
        if (lllllllllllllIIIIIlIIIlllllIIllI == -0.0) {
            lllllllllllllIIIIIlIIIlllllIIllI = 0.0;
        }
        this.xCoord = lllllllllllllIIIIIlIIIlllllIlIII;
        this.yCoord = lllllllllllllIIIIIlIIIlllllIIlll;
        this.zCoord = lllllllllllllIIIIIlIIIlllllIIllI;
    }
    
    public static Vec3d fromPitchYaw(final float lllllllllllllIIIIIlIIIlIllIlllIl, final float lllllllllllllIIIIIlIIIlIllIlllII) {
        final float lllllllllllllIIIIIlIIIlIllIllIll = MathHelper.cos(-lllllllllllllIIIIIlIIIlIllIlllII * 0.017453292f - 3.1415927f);
        final float lllllllllllllIIIIIlIIIlIllIllIlI = MathHelper.sin(-lllllllllllllIIIIIlIIIlIllIlllII * 0.017453292f - 3.1415927f);
        final float lllllllllllllIIIIIlIIIlIllIllIIl = -MathHelper.cos(-lllllllllllllIIIIIlIIIlIllIlllIl * 0.017453292f);
        final float lllllllllllllIIIIIlIIIlIllIllIII = MathHelper.sin(-lllllllllllllIIIIIlIIIlIllIlllIl * 0.017453292f);
        return new Vec3d(lllllllllllllIIIIIlIIIlIllIllIlI * lllllllllllllIIIIIlIIIlIllIllIIl, lllllllllllllIIIIIlIIIlIllIllIII, lllllllllllllIIIIIlIIIlIllIllIll * lllllllllllllIIIIIlIIIlIllIllIIl);
    }
    
    public double dotProduct(final Vec3d lllllllllllllIIIIIlIIIllllIlIIII) {
        return this.xCoord * lllllllllllllIIIIIlIIIllllIlIIII.xCoord + this.yCoord * lllllllllllllIIIIIlIIIllllIlIIII.yCoord + this.zCoord * lllllllllllllIIIIIlIIIllllIlIIII.zCoord;
    }
    
    @Nullable
    public Vec3d getIntermediateWithYValue(final Vec3d lllllllllllllIIIIIlIIIllIlIIIlll, final double lllllllllllllIIIIIlIIIllIlIIIllI) {
        final double lllllllllllllIIIIIlIIIllIlIIIlIl = lllllllllllllIIIIIlIIIllIlIIIlll.xCoord - this.xCoord;
        final double lllllllllllllIIIIIlIIIllIlIIIlII = lllllllllllllIIIIIlIIIllIlIIIlll.yCoord - this.yCoord;
        final double lllllllllllllIIIIIlIIIllIlIIIIll = lllllllllllllIIIIIlIIIllIlIIIlll.zCoord - this.zCoord;
        if (lllllllllllllIIIIIlIIIllIlIIIlII * lllllllllllllIIIIIlIIIllIlIIIlII < 1.0000000116860974E-7) {
            return null;
        }
        final double lllllllllllllIIIIIlIIIllIlIIIIlI = (lllllllllllllIIIIIlIIIllIlIIIllI - this.yCoord) / lllllllllllllIIIIIlIIIllIlIIIlII;
        return (lllllllllllllIIIIIlIIIllIlIIIIlI >= 0.0 && lllllllllllllIIIIIlIIIllIlIIIIlI <= 1.0) ? new Vec3d(this.xCoord + lllllllllllllIIIIIlIIIllIlIIIlIl * lllllllllllllIIIIIlIIIllIlIIIIlI, this.yCoord + lllllllllllllIIIIIlIIIllIlIIIlII * lllllllllllllIIIIIlIIIllIlIIIIlI, this.zCoord + lllllllllllllIIIIIlIIIllIlIIIIll * lllllllllllllIIIIIlIIIllIlIIIIlI) : null;
    }
    
    @Nullable
    public Vec3d getIntermediateWithZValue(final Vec3d lllllllllllllIIIIIlIIIllIIlIlIll, final double lllllllllllllIIIIIlIIIllIIlIlIlI) {
        final double lllllllllllllIIIIIlIIIllIIllIIII = lllllllllllllIIIIIlIIIllIIlIlIll.xCoord - this.xCoord;
        final double lllllllllllllIIIIIlIIIllIIlIllll = lllllllllllllIIIIIlIIIllIIlIlIll.yCoord - this.yCoord;
        final double lllllllllllllIIIIIlIIIllIIlIlllI = lllllllllllllIIIIIlIIIllIIlIlIll.zCoord - this.zCoord;
        if (lllllllllllllIIIIIlIIIllIIlIlllI * lllllllllllllIIIIIlIIIllIIlIlllI < 1.0000000116860974E-7) {
            return null;
        }
        final double lllllllllllllIIIIIlIIIllIIlIllIl = (lllllllllllllIIIIIlIIIllIIlIlIlI - this.zCoord) / lllllllllllllIIIIIlIIIllIIlIlllI;
        return (lllllllllllllIIIIIlIIIllIIlIllIl >= 0.0 && lllllllllllllIIIIIlIIIllIIlIllIl <= 1.0) ? new Vec3d(this.xCoord + lllllllllllllIIIIIlIIIllIIllIIII * lllllllllllllIIIIIlIIIllIIlIllIl, this.yCoord + lllllllllllllIIIIIlIIIllIIlIllll * lllllllllllllIIIIIlIIIllIIlIllIl, this.zCoord + lllllllllllllIIIIIlIIIllIIlIlllI * lllllllllllllIIIIIlIIIllIIlIllIl) : null;
    }
    
    @Override
    public int hashCode() {
        long lllllllllllllIIIIIlIIIllIIIllIII = Double.doubleToLongBits(this.xCoord);
        int lllllllllllllIIIIIlIIIllIIIlIlll = (int)(lllllllllllllIIIIIlIIIllIIIllIII ^ lllllllllllllIIIIIlIIIllIIIllIII >>> 32);
        lllllllllllllIIIIIlIIIllIIIllIII = Double.doubleToLongBits(this.yCoord);
        lllllllllllllIIIIIlIIIllIIIlIlll = 31 * lllllllllllllIIIIIlIIIllIIIlIlll + (int)(lllllllllllllIIIIIlIIIllIIIllIII ^ lllllllllllllIIIIIlIIIllIIIllIII >>> 32);
        lllllllllllllIIIIIlIIIllIIIllIII = Double.doubleToLongBits(this.zCoord);
        lllllllllllllIIIIIlIIIllIIIlIlll = 31 * lllllllllllllIIIIIlIIIllIIIlIlll + (int)(lllllllllllllIIIIIlIIIllIIIllIII ^ lllllllllllllIIIIIlIIIllIIIllIII >>> 32);
        return lllllllllllllIIIIIlIIIllIIIlIlll;
    }
    
    public Vec3d crossProduct(final Vec3d lllllllllllllIIIIIlIIIllllIIlIII) {
        return new Vec3d(this.yCoord * lllllllllllllIIIIIlIIIllllIIlIII.zCoord - this.zCoord * lllllllllllllIIIIIlIIIllllIIlIII.yCoord, this.zCoord * lllllllllllllIIIIIlIIIllllIIlIII.xCoord - this.xCoord * lllllllllllllIIIIIlIIIllllIIlIII.zCoord, this.xCoord * lllllllllllllIIIIIlIIIllllIIlIII.yCoord - this.yCoord * lllllllllllllIIIIIlIIIllllIIlIII.xCoord);
    }
    
    public Vec3d rotateYaw(final float lllllllllllllIIIIIlIIIlIllllIIll) {
        final float lllllllllllllIIIIIlIIIlIllllIIlI = MathHelper.cos(lllllllllllllIIIIIlIIIlIllllIIll);
        final float lllllllllllllIIIIIlIIIlIllllIIIl = MathHelper.sin(lllllllllllllIIIIIlIIIlIllllIIll);
        final double lllllllllllllIIIIIlIIIlIllllIIII = this.xCoord * lllllllllllllIIIIIlIIIlIllllIIlI + this.zCoord * lllllllllllllIIIIIlIIIlIllllIIIl;
        final double lllllllllllllIIIIIlIIIlIlllIllll = this.yCoord;
        final double lllllllllllllIIIIIlIIIlIlllIlllI = this.zCoord * lllllllllllllIIIIIlIIIlIllllIIlI - this.xCoord * lllllllllllllIIIIIlIIIlIllllIIIl;
        return new Vec3d(lllllllllllllIIIIIlIIIlIllllIIII, lllllllllllllIIIIIlIIIlIlllIllll, lllllllllllllIIIIIlIIIlIlllIlllI);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIIIIlIIIllIIIllllI) {
        if (this == lllllllllllllIIIIIlIIIllIIIllllI) {
            return true;
        }
        if (!(lllllllllllllIIIIIlIIIllIIIllllI instanceof Vec3d)) {
            return false;
        }
        final Vec3d lllllllllllllIIIIIlIIIllIIlIIIII = (Vec3d)lllllllllllllIIIIIlIIIllIIIllllI;
        return Double.compare(lllllllllllllIIIIIlIIIllIIlIIIII.xCoord, this.xCoord) == 0 && Double.compare(lllllllllllllIIIIIlIIIllIIlIIIII.yCoord, this.yCoord) == 0 && Double.compare(lllllllllllllIIIIIlIIIllIIlIIIII.zCoord, this.zCoord) == 0;
    }
    
    public double lengthVector() {
        return MathHelper.sqrt(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("(").append(this.xCoord).append(", ").append(this.yCoord).append(", ").append(this.zCoord).append(")"));
    }
    
    public Vec3d addVector(final double lllllllllllllIIIIIlIIIlllIlIlIlI, final double lllllllllllllIIIIIlIIIlllIlIlIIl, final double lllllllllllllIIIIIlIIIlllIlIIlII) {
        return new Vec3d(this.xCoord + lllllllllllllIIIIIlIIIlllIlIlIlI, this.yCoord + lllllllllllllIIIIIlIIIlllIlIlIIl, this.zCoord + lllllllllllllIIIIIlIIIlllIlIIlII);
    }
    
    public double squareDistanceTo(final Vec3d lllllllllllllIIIIIlIIIlllIIIlllI) {
        final double lllllllllllllIIIIIlIIIlllIIIllIl = lllllllllllllIIIIIlIIIlllIIIlllI.xCoord - this.xCoord;
        final double lllllllllllllIIIIIlIIIlllIIIllII = lllllllllllllIIIIIlIIIlllIIIlllI.yCoord - this.yCoord;
        final double lllllllllllllIIIIIlIIIlllIIIlIll = lllllllllllllIIIIIlIIIlllIIIlllI.zCoord - this.zCoord;
        return lllllllllllllIIIIIlIIIlllIIIllIl * lllllllllllllIIIIIlIIIlllIIIllIl + lllllllllllllIIIIIlIIIlllIIIllII * lllllllllllllIIIIIlIIIlllIIIllII + lllllllllllllIIIIIlIIIlllIIIlIll * lllllllllllllIIIIIlIIIlllIIIlIll;
    }
    
    public Vec3d subtract(final double lllllllllllllIIIIIlIIIlllIlllIII, final double lllllllllllllIIIIIlIIIlllIlllIll, final double lllllllllllllIIIIIlIIIlllIlllIlI) {
        return this.addVector(-lllllllllllllIIIIIlIIIlllIlllIII, -lllllllllllllIIIIIlIIIlllIlllIll, -lllllllllllllIIIIIlIIIlllIlllIlI);
    }
    
    public Vec3d scale(final double lllllllllllllIIIIIlIIIllIllIlIll) {
        return new Vec3d(this.xCoord * lllllllllllllIIIIIlIIIllIllIlIll, this.yCoord * lllllllllllllIIIIIlIIIllIllIlIll, this.zCoord * lllllllllllllIIIIIlIIIllIllIlIll);
    }
    
    public Vec3d subtractReverse(final Vec3d lllllllllllllIIIIIlIIIllllIllIlI) {
        return new Vec3d(lllllllllllllIIIIIlIIIllllIllIlI.xCoord - this.xCoord, lllllllllllllIIIIIlIIIllllIllIlI.yCoord - this.yCoord, lllllllllllllIIIIIlIIIllllIllIlI.zCoord - this.zCoord);
    }
    
    public double lengthSquared() {
        return this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord;
    }
    
    public Vec3d add(final Vec3d lllllllllllllIIIIIlIIIlllIllIIlI) {
        return this.addVector(lllllllllllllIIIIIlIIIlllIllIIlI.xCoord, lllllllllllllIIIIIlIIIlllIllIIlI.yCoord, lllllllllllllIIIIIlIIIlllIllIIlI.zCoord);
    }
    
    static {
        ZERO = new Vec3d(0.0, 0.0, 0.0);
    }
    
    @Nullable
    public Vec3d getIntermediateWithXValue(final Vec3d lllllllllllllIIIIIlIIIllIlIlIlIl, final double lllllllllllllIIIIIlIIIllIlIlIlII) {
        final double lllllllllllllIIIIIlIIIllIlIllIlI = lllllllllllllIIIIIlIIIllIlIlIlIl.xCoord - this.xCoord;
        final double lllllllllllllIIIIIlIIIllIlIllIIl = lllllllllllllIIIIIlIIIllIlIlIlIl.yCoord - this.yCoord;
        final double lllllllllllllIIIIIlIIIllIlIllIII = lllllllllllllIIIIIlIIIllIlIlIlIl.zCoord - this.zCoord;
        if (lllllllllllllIIIIIlIIIllIlIllIlI * lllllllllllllIIIIIlIIIllIlIllIlI < 1.0000000116860974E-7) {
            return null;
        }
        final double lllllllllllllIIIIIlIIIllIlIlIlll = (lllllllllllllIIIIIlIIIllIlIlIlII - this.xCoord) / lllllllllllllIIIIIlIIIllIlIllIlI;
        return (lllllllllllllIIIIIlIIIllIlIlIlll >= 0.0 && lllllllllllllIIIIIlIIIllIlIlIlll <= 1.0) ? new Vec3d(this.xCoord + lllllllllllllIIIIIlIIIllIlIllIlI * lllllllllllllIIIIIlIIIllIlIlIlll, this.yCoord + lllllllllllllIIIIIlIIIllIlIllIIl * lllllllllllllIIIIIlIIIllIlIlIlll, this.zCoord + lllllllllllllIIIIIlIIIllIlIllIII * lllllllllllllIIIIIlIIIllIlIlIlll) : null;
    }
    
    public double squareDistanceTo(final double lllllllllllllIIIIIlIIIllIlllIllI, final double lllllllllllllIIIIIlIIIllIlllllII, final double lllllllllllllIIIIIlIIIllIllllIll) {
        final double lllllllllllllIIIIIlIIIllIllllIlI = lllllllllllllIIIIIlIIIllIlllIllI - this.xCoord;
        final double lllllllllllllIIIIIlIIIllIllllIIl = lllllllllllllIIIIIlIIIllIlllllII - this.yCoord;
        final double lllllllllllllIIIIIlIIIllIllllIII = lllllllllllllIIIIIlIIIllIllllIll - this.zCoord;
        return lllllllllllllIIIIIlIIIllIllllIlI * lllllllllllllIIIIIlIIIllIllllIlI + lllllllllllllIIIIIlIIIllIllllIIl * lllllllllllllIIIIIlIIIllIllllIIl + lllllllllllllIIIIIlIIIllIllllIII * lllllllllllllIIIIIlIIIllIllllIII;
    }
    
    public double distanceTo(final Vec3d lllllllllllllIIIIIlIIIlllIIlllIl) {
        final double lllllllllllllIIIIIlIIIlllIIlllII = lllllllllllllIIIIIlIIIlllIIlllIl.xCoord - this.xCoord;
        final double lllllllllllllIIIIIlIIIlllIIllIll = lllllllllllllIIIIIlIIIlllIIlllIl.yCoord - this.yCoord;
        final double lllllllllllllIIIIIlIIIlllIIllIlI = lllllllllllllIIIIIlIIIlllIIlllIl.zCoord - this.zCoord;
        return MathHelper.sqrt(lllllllllllllIIIIIlIIIlllIIlllII * lllllllllllllIIIIIlIIIlllIIlllII + lllllllllllllIIIIIlIIIlllIIllIll * lllllllllllllIIIIIlIIIlllIIllIll + lllllllllllllIIIIIlIIIlllIIllIlI * lllllllllllllIIIIIlIIIlllIIllIlI);
    }
    
    public Vec3d normalize() {
        final double lllllllllllllIIIIIlIIIllllIlIllI = MathHelper.sqrt(this.xCoord * this.xCoord + this.yCoord * this.yCoord + this.zCoord * this.zCoord);
        return (lllllllllllllIIIIIlIIIllllIlIllI < 1.0E-4) ? Vec3d.ZERO : new Vec3d(this.xCoord / lllllllllllllIIIIIlIIIllllIlIllI, this.yCoord / lllllllllllllIIIIIlIIIllllIlIllI, this.zCoord / lllllllllllllIIIIIlIIIllllIlIllI);
    }
    
    public Vec3d(final Vec3i lllllllllllllIIIIIlIIIlllllIIIII) {
        this(lllllllllllllIIIIIlIIIlllllIIIII.getX(), lllllllllllllIIIIIlIIIlllllIIIII.getY(), lllllllllllllIIIIIlIIIlllllIIIII.getZ());
    }
    
    public Vec3d subtract(final Vec3d lllllllllllllIIIIIlIIIllllIIIlII) {
        return this.subtract(lllllllllllllIIIIIlIIIllllIIIlII.xCoord, lllllllllllllIIIIIlIIIllllIIIlII.yCoord, lllllllllllllIIIIIlIIIllllIIIlII.zCoord);
    }
    
    public Vec3d rotatePitch(final float lllllllllllllIIIIIlIIIllIIIIlIII) {
        final float lllllllllllllIIIIIlIIIllIIIIIlll = MathHelper.cos(lllllllllllllIIIIIlIIIllIIIIlIII);
        final float lllllllllllllIIIIIlIIIllIIIIIllI = MathHelper.sin(lllllllllllllIIIIIlIIIllIIIIlIII);
        final double lllllllllllllIIIIIlIIIllIIIIIlIl = this.xCoord;
        final double lllllllllllllIIIIIlIIIllIIIIIlII = this.yCoord * lllllllllllllIIIIIlIIIllIIIIIlll + this.zCoord * lllllllllllllIIIIIlIIIllIIIIIllI;
        final double lllllllllllllIIIIIlIIIllIIIIIIll = this.zCoord * lllllllllllllIIIIIlIIIllIIIIIlll - this.yCoord * lllllllllllllIIIIIlIIIllIIIIIllI;
        return new Vec3d(lllllllllllllIIIIIlIIIllIIIIIlIl, lllllllllllllIIIIIlIIIllIIIIIlII, lllllllllllllIIIIIlIIIllIIIIIIll);
    }
}
