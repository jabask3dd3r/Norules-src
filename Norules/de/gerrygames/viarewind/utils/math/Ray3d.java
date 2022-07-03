package de.gerrygames.viarewind.utils.math;

public class Ray3d
{
    /* synthetic */ Vector3d dir;
    /* synthetic */ Vector3d start;
    
    public Vector3d getDir() {
        return this.dir;
    }
    
    public Vector3d getStart() {
        return this.start;
    }
    
    public Ray3d(final Vector3d llllllllllllllIIlllIIlllIlIlllll, final Vector3d llllllllllllllIIlllIIlllIlIllllI) {
        this.start = llllllllllllllIIlllIIlllIlIlllll;
        this.dir = llllllllllllllIIlllIIlllIlIllllI;
    }
}
