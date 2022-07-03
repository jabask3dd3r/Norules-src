package de.gerrygames.viarewind.utils.math;

import java.util.*;

public class Vector3d
{
    /* synthetic */ double x;
    /* synthetic */ double z;
    /* synthetic */ double y;
    
    public Vector3d set(final double lllllllllllllllIllIIlIIlIlIIllll, final double lllllllllllllllIllIIlIIlIlIIlllI, final double lllllllllllllllIllIIlIIlIlIIllIl) {
        this.x = lllllllllllllllIllIIlIIlIlIIllll;
        this.y = lllllllllllllllIllIIlIIlIlIIlllI;
        this.z = lllllllllllllllIllIIlIIlIlIIllIl;
        return this;
    }
    
    public void setZ(final double lllllllllllllllIllIIlIIlIIIIIIlI) {
        this.z = lllllllllllllllIllIIlIIlIIIIIIlI;
    }
    
    public Vector3d() {
    }
    
    public Vector3d clone() {
        return new Vector3d(this.x, this.y, this.z);
    }
    
    public void setX(final double lllllllllllllllIllIIlIIlIIIIlllI) {
        this.x = lllllllllllllllIllIIlIIlIIIIlllI;
    }
    
    public Vector3d add(final Vector3d lllllllllllllllIllIIlIIlIlIIIIIl) {
        this.x += lllllllllllllllIllIIlIIlIlIIIIIl.x;
        this.y += lllllllllllllllIllIIlIIlIlIIIIIl.y;
        this.z += lllllllllllllllIllIIlIIlIlIIIIIl.z;
        return this;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y, this.z);
    }
    
    public Vector3d(final double lllllllllllllllIllIIlIIlIllIlIII, final double lllllllllllllllIllIIlIIlIllIIlll, final double lllllllllllllllIllIIlIIlIllIIllI) {
        this.x = lllllllllllllllIllIIlIIlIllIlIII;
        this.y = lllllllllllllllIllIIlIIlIllIIlll;
        this.z = lllllllllllllllIllIIlIIlIllIIllI;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Vector3d{x=").append(this.x).append(", y=").append(this.y).append(", z=").append(this.z).append('}'));
    }
    
    public void setY(final double lllllllllllllllIllIIlIIlIIIIlIlI) {
        this.y = lllllllllllllllIllIIlIIlIIIIlIlI;
    }
    
    public Vector3d substract(final Vector3d lllllllllllllllIllIIlIIlIIllllIl) {
        this.x -= lllllllllllllllIllIIlIIlIIllllIl.x;
        this.y -= lllllllllllllllIllIIlIIlIIllllIl.y;
        this.z -= lllllllllllllllIllIIlIIlIIllllIl.z;
        return this;
    }
    
    public void set(final Vector3d lllllllllllllllIllIIlIIlIlIllIll) {
        this.x = lllllllllllllllIllIIlIIlIlIllIll.x;
        this.y = lllllllllllllllIllIIlIIlIlIllIll.y;
        this.z = lllllllllllllllIllIIlIIlIlIllIll.z;
    }
    
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }
    
    public double getZ() {
        return this.z;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIllIIlIIlIIlIIlII) {
        if (this == lllllllllllllllIllIIlIIlIIlIIlII) {
            return true;
        }
        if (lllllllllllllllIllIIlIIlIIlIIlII == null || this.getClass() != lllllllllllllllIllIIlIIlIIlIIlII.getClass()) {
            return false;
        }
        final Vector3d lllllllllllllllIllIIlIIlIIlIIllI = (Vector3d)lllllllllllllllIllIIlIIlIIlIIlII;
        return Double.compare(lllllllllllllllIllIIlIIlIIlIIllI.x, this.x) == 0 && Double.compare(lllllllllllllllIllIIlIIlIIlIIllI.y, this.y) == 0 && Double.compare(lllllllllllllllIllIIlIIlIIlIIllI.z, this.z) == 0;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public Vector3d normalize() {
        final double lllllllllllllllIllIIlIIlIIllIIIl = this.length();
        this.multiply(1.0 / lllllllllllllllIllIIlIIlIIllIIIl);
        return this;
    }
    
    public Vector3d multiply(final double lllllllllllllllIllIIlIIlIlIIlIIl) {
        this.x *= lllllllllllllllIllIIlIIlIlIIlIIl;
        this.y *= lllllllllllllllIllIIlIIlIlIIlIIl;
        this.z *= lllllllllllllllIllIIlIIlIlIIlIIl;
        return this;
    }
    
    public double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }
}
