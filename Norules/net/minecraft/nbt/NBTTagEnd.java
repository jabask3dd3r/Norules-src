package net.minecraft.nbt;

import java.io.*;

public class NBTTagEnd extends NBTBase
{
    @Override
    public String toString() {
        return "END";
    }
    
    @Override
    void write(final DataOutput lllllllllllllIllIIllIlIIllllIIIl) throws IOException {
    }
    
    @Override
    public NBTTagEnd copy() {
        return new NBTTagEnd();
    }
    
    @Override
    public byte getId() {
        return 0;
    }
    
    @Override
    void read(final DataInput lllllllllllllIllIIllIlIIlllllIlI, final int lllllllllllllIllIIllIlIIlllllIIl, final NBTSizeTracker lllllllllllllIllIIllIlIIlllllIII) throws IOException {
        lllllllllllllIllIIllIlIIlllllIII.read(64L);
    }
}
