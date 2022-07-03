package com.viaversion.viabackwards.api.entities.storage;

public abstract class EntityPositionStorage
{
    private /* synthetic */ double y;
    private /* synthetic */ double z;
    private /* synthetic */ double x;
    
    public double getY() {
        return this.y;
    }
    
    public void setCoordinates(final double llllllllllllllIIIIlIlllIIllIIIIl, final double llllllllllllllIIIIlIlllIIllIIIII, final double llllllllllllllIIIIlIlllIIlIllIlI, final boolean llllllllllllllIIIIlIlllIIlIllllI) {
        if (llllllllllllllIIIIlIlllIIlIllllI) {
            this.x += llllllllllllllIIIIlIlllIIllIIIIl;
            this.y += llllllllllllllIIIIlIlllIIllIIIII;
            this.z += llllllllllllllIIIIlIlllIIlIllIlI;
        }
        else {
            this.x = llllllllllllllIIIIlIlllIIllIIIIl;
            this.y = llllllllllllllIIIIlIlllIIllIIIII;
            this.z = llllllllllllllIIIIlIlllIIlIllIlI;
        }
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getZ() {
        return this.z;
    }
}
