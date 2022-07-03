package de.gerrygames.viarewind.utils.math;

public class AABB
{
    /* synthetic */ Vector3d min;
    /* synthetic */ Vector3d max;
    
    public AABB(final Vector3d llllllllllllllIllIIllIllIIIlIlII, final Vector3d llllllllllllllIllIIllIllIIIlIIll) {
        this.min = llllllllllllllIllIIllIllIIIlIlII;
        this.max = llllllllllllllIllIIllIllIIIlIIll;
    }
    
    public Vector3d getMax() {
        return this.max;
    }
    
    public Vector3d getMin() {
        return this.min;
    }
}
