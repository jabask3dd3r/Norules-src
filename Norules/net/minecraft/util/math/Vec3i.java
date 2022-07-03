package net.minecraft.util.math;

import javax.annotation.concurrent.*;
import com.google.common.base.*;

@Immutable
public class Vec3i implements Comparable<Vec3i>
{
    private final /* synthetic */ int z;
    private final /* synthetic */ int x;
    private final /* synthetic */ int y;
    
    public int getX() {
        return this.x;
    }
    
    public Vec3i(final double lllllllllllllllIIlIIlIIIlIIIIlIl, final double lllllllllllllllIIlIIlIIIlIIIIlII, final double lllllllllllllllIIlIIlIIIlIIIIIll) {
        this(MathHelper.floor(lllllllllllllllIIlIIlIIIlIIIIlIl), MathHelper.floor(lllllllllllllllIIlIIlIIIlIIIIlII), MathHelper.floor(lllllllllllllllIIlIIlIIIlIIIIIll));
    }
    
    public Vec3i crossProduct(final Vec3i lllllllllllllllIIlIIlIIIIllIIIlI) {
        return new Vec3i(this.getY() * lllllllllllllllIIlIIlIIIIllIIIlI.getZ() - this.getZ() * lllllllllllllllIIlIIlIIIIllIIIlI.getY(), this.getZ() * lllllllllllllllIIlIIlIIIIllIIIlI.getX() - this.getX() * lllllllllllllllIIlIIlIIIIllIIIlI.getZ(), this.getX() * lllllllllllllllIIlIIlIIIIllIIIlI.getY() - this.getY() * lllllllllllllllIIlIIlIIIIllIIIlI.getX());
    }
    
    public double distanceSq(final Vec3i lllllllllllllllIIlIIlIIIIIIlIlII) {
        return this.distanceSq(lllllllllllllllIIlIIlIIIIIIlIlII.getX(), lllllllllllllllIIlIIlIIIIIIlIlII.getY(), lllllllllllllllIIlIIlIIIIIIlIlII.getZ());
    }
    
    public double distanceSq(final double lllllllllllllllIIlIIlIIIIIlllIll, final double lllllllllllllllIIlIIlIIIIIllIIll, final double lllllllllllllllIIlIIlIIIIIllIIlI) {
        final double lllllllllllllllIIlIIlIIIIIlllIII = this.getX() - lllllllllllllllIIlIIlIIIIIlllIll;
        final double lllllllllllllllIIlIIlIIIIIllIlll = this.getY() - lllllllllllllllIIlIIlIIIIIllIIll;
        final double lllllllllllllllIIlIIlIIIIIllIllI = this.getZ() - lllllllllllllllIIlIIlIIIIIllIIlI;
        return lllllllllllllllIIlIIlIIIIIlllIII * lllllllllllllllIIlIIlIIIIIlllIII + lllllllllllllllIIlIIlIIIIIllIlll * lllllllllllllllIIlIIlIIIIIllIlll + lllllllllllllllIIlIIlIIIIIllIllI * lllllllllllllllIIlIIlIIIIIllIllI;
    }
    
    public int getY() {
        return this.y;
    }
    
    public double getDistance(final int lllllllllllllllIIlIIlIIIIlIIllII, final int lllllllllllllllIIlIIlIIIIlIIlIlI, final int lllllllllllllllIIlIIlIIIIlIIlIIl) {
        final double lllllllllllllllIIlIIlIIIIlIlIIlI = this.getX() - lllllllllllllllIIlIIlIIIIlIIllII;
        final double lllllllllllllllIIlIIlIIIIlIlIIII = this.getY() - lllllllllllllllIIlIIlIIIIlIIlIlI;
        final double lllllllllllllllIIlIIlIIIIlIIllll = this.getZ() - lllllllllllllllIIlIIlIIIIlIIlIIl;
        return Math.sqrt(lllllllllllllllIIlIIlIIIIlIlIIlI * lllllllllllllllIIlIIlIIIIlIlIIlI + lllllllllllllllIIlIIlIIIIlIlIIII * lllllllllllllllIIlIIlIIIIlIlIIII + lllllllllllllllIIlIIlIIIIlIIllll * lllllllllllllllIIlIIlIIIIlIIllll);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIIlIIlIIIIllllIll) {
        if (this == lllllllllllllllIIlIIlIIIIllllIll) {
            return true;
        }
        if (!(lllllllllllllllIIlIIlIIIIllllIll instanceof Vec3i)) {
            return false;
        }
        final Vec3i lllllllllllllllIIlIIlIIIIlllllIl = (Vec3i)lllllllllllllllIIlIIlIIIIllllIll;
        return this.getX() == lllllllllllllllIIlIIlIIIIlllllIl.getX() && this.getY() == lllllllllllllllIIlIIlIIIIlllllIl.getY() && this.getZ() == lllllllllllllllIIlIIlIIIIlllllIl.getZ();
    }
    
    public double distanceSqToCenter(final double lllllllllllllllIIlIIlIIIIIlIIllI, final double lllllllllllllllIIlIIlIIIIIlIIlIl, final double lllllllllllllllIIlIIlIIIIIIlllIl) {
        final double lllllllllllllllIIlIIlIIIIIlIIIll = this.getX() + 0.5 - lllllllllllllllIIlIIlIIIIIlIIllI;
        final double lllllllllllllllIIlIIlIIIIIlIIIlI = this.getY() + 0.5 - lllllllllllllllIIlIIlIIIIIlIIlIl;
        final double lllllllllllllllIIlIIlIIIIIlIIIIl = this.getZ() + 0.5 - lllllllllllllllIIlIIlIIIIIIlllIl;
        return lllllllllllllllIIlIIlIIIIIlIIIll * lllllllllllllllIIlIIlIIIIIlIIIll + lllllllllllllllIIlIIlIIIIIlIIIlI * lllllllllllllllIIlIIlIIIIIlIIIlI + lllllllllllllllIIlIIlIIIIIlIIIIl * lllllllllllllllIIlIIlIIIIIlIIIIl;
    }
    
    @Override
    public String toString() {
        return MoreObjects.toStringHelper((Object)this).add("x", this.getX()).add("y", this.getY()).add("z", this.getZ()).toString();
    }
    
    static {
        NULL_VECTOR = new Vec3i(0, 0, 0);
    }
    
    @Override
    public int hashCode() {
        return (this.getY() + this.getZ() * 31) * 31 + this.getX();
    }
    
    @Override
    public int compareTo(final Vec3i lllllllllllllllIIlIIlIIIIlllIIll) {
        if (this.getY() == lllllllllllllllIIlIIlIIIIlllIIll.getY()) {
            return (this.getZ() == lllllllllllllllIIlIIlIIIIlllIIll.getZ()) ? (this.getX() - lllllllllllllllIIlIIlIIIIlllIIll.getX()) : (this.getZ() - lllllllllllllllIIlIIlIIIIlllIIll.getZ());
        }
        return this.getY() - lllllllllllllllIIlIIlIIIIlllIIll.getY();
    }
    
    public Vec3i(final int lllllllllllllllIIlIIlIIIlIIlIIIl, final int lllllllllllllllIIlIIlIIIlIIlIIII, final int lllllllllllllllIIlIIlIIIlIIlIIll) {
        this.x = lllllllllllllllIIlIIlIIIlIIlIIIl;
        this.y = lllllllllllllllIIlIIlIIIlIIlIIII;
        this.z = lllllllllllllllIIlIIlIIIlIIlIIll;
    }
    
    public int getZ() {
        return this.z;
    }
}
