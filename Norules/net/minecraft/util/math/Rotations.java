package net.minecraft.util.math;

import net.minecraft.nbt.*;

public class Rotations
{
    protected final /* synthetic */ float x;
    protected final /* synthetic */ float y;
    protected final /* synthetic */ float z;
    
    public NBTTagList writeToNBT() {
        final NBTTagList lllllllllllllIlllIlIllIIIIIlllIl = new NBTTagList();
        lllllllllllllIlllIlIllIIIIIlllIl.appendTag(new NBTTagFloat(this.x));
        lllllllllllllIlllIlIllIIIIIlllIl.appendTag(new NBTTagFloat(this.y));
        lllllllllllllIlllIlIllIIIIIlllIl.appendTag(new NBTTagFloat(this.z));
        return lllllllllllllIlllIlIllIIIIIlllIl;
    }
    
    public float getZ() {
        return this.z;
    }
    
    public float getX() {
        return this.x;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllIlIllIIIIIlIllI) {
        if (!(lllllllllllllIlllIlIllIIIIIlIllI instanceof Rotations)) {
            return false;
        }
        final Rotations lllllllllllllIlllIlIllIIIIIlIlIl = (Rotations)lllllllllllllIlllIlIllIIIIIlIllI;
        return this.x == lllllllllllllIlllIlIllIIIIIlIlIl.x && this.y == lllllllllllllIlllIlIllIIIIIlIlIl.y && this.z == lllllllllllllIlllIlIllIIIIIlIlIl.z;
    }
    
    public Rotations(final NBTTagList lllllllllllllIlllIlIllIIIIlIIIIl) {
        this(lllllllllllllIlllIlIllIIIIlIIIIl.getFloatAt(0), lllllllllllllIlllIlIllIIIIlIIIIl.getFloatAt(1), lllllllllllllIlllIlIllIIIIlIIIIl.getFloatAt(2));
    }
    
    public Rotations(final float lllllllllllllIlllIlIllIIIIlIlIIl, final float lllllllllllllIlllIlIllIIIIlIllII, final float lllllllllllllIlllIlIllIIIIlIIlll) {
        this.x = ((!Float.isInfinite(lllllllllllllIlllIlIllIIIIlIlIIl) && !Float.isNaN(lllllllllllllIlllIlIllIIIIlIlIIl)) ? (lllllllllllllIlllIlIllIIIIlIlIIl % 360.0f) : 0.0f);
        this.y = ((!Float.isInfinite(lllllllllllllIlllIlIllIIIIlIllII) && !Float.isNaN(lllllllllllllIlllIlIllIIIIlIllII)) ? (lllllllllllllIlllIlIllIIIIlIllII % 360.0f) : 0.0f);
        this.z = ((!Float.isInfinite(lllllllllllllIlllIlIllIIIIlIIlll) && !Float.isNaN(lllllllllllllIlllIlIllIIIIlIIlll)) ? (lllllllllllllIlllIlIllIIIIlIIlll % 360.0f) : 0.0f);
    }
    
    public float getY() {
        return this.y;
    }
}
