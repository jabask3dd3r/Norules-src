package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;

public abstract class PlayerPositionStorage implements StorableObject
{
    private /* synthetic */ double x;
    private /* synthetic */ double y;
    private /* synthetic */ double z;
    
    public void setY(final double lllllllllllllllIllllIIIllIIIIIlI) {
        this.y = lllllllllllllllIllllIIIllIIIIIlI;
    }
    
    public void setX(final double lllllllllllllllIllllIIIllIIIlIII) {
        this.x = lllllllllllllllIllllIIIllIIIlIII;
    }
    
    public void setZ(final double lllllllllllllllIllllIIIlIllllllI) {
        this.z = lllllllllllllllIllllIIIlIllllllI;
    }
    
    protected PlayerPositionStorage() {
    }
    
    public void setCoordinates(final PacketWrapper lllllllllllllllIllllIIIlIlllIlII, final boolean lllllllllllllllIllllIIIlIlllIllI) throws Exception {
        this.setCoordinates(lllllllllllllllIllllIIIlIlllIlII.get((Type<Double>)Type.DOUBLE, 0), lllllllllllllllIllllIIIlIlllIlII.get((Type<Double>)Type.DOUBLE, 1), lllllllllllllllIllllIIIlIlllIlII.get((Type<Double>)Type.DOUBLE, 2), lllllllllllllllIllllIIIlIlllIllI);
    }
    
    public double getY() {
        return this.y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void setCoordinates(final double lllllllllllllllIllllIIIlIllIllII, final double lllllllllllllllIllllIIIlIllIlIll, final double lllllllllllllllIllllIIIlIllIIlIl, final boolean lllllllllllllllIllllIIIlIllIIlII) {
        if (lllllllllllllllIllllIIIlIllIIlII) {
            this.x += lllllllllllllllIllllIIIlIllIllII;
            this.y += lllllllllllllllIllllIIIlIllIlIll;
            this.z += lllllllllllllllIllllIIIlIllIIlIl;
        }
        else {
            this.x = lllllllllllllllIllllIIIlIllIllII;
            this.y = lllllllllllllllIllllIIIlIllIlIll;
            this.z = lllllllllllllllIllllIIIlIllIIlIl;
        }
    }
}
