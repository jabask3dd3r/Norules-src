package net.minecraft.world.storage;

import net.minecraft.nbt.*;

public abstract class WorldSavedData
{
    private /* synthetic */ boolean dirty;
    public final /* synthetic */ String mapName;
    
    public abstract NBTTagCompound writeToNBT(final NBTTagCompound p0);
    
    public void markDirty() {
        this.setDirty(true);
    }
    
    public WorldSavedData(final String lllllllllllllIIlIllIIIlIlIIIIIIl) {
        this.mapName = lllllllllllllIIlIllIIIlIlIIIIIIl;
    }
    
    public void setDirty(final boolean lllllllllllllIIlIllIIIlIIlllIllI) {
        this.dirty = lllllllllllllIIlIllIIIlIIlllIllI;
    }
    
    public abstract void readFromNBT(final NBTTagCompound p0);
    
    public boolean isDirty() {
        return this.dirty;
    }
}
