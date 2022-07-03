package net.minecraft.nbt;

import java.io.*;

public class NBTTagByte extends NBTPrimitive
{
    private /* synthetic */ byte data;
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIIllIIllIIIlIIlI) {
        return super.equals(lllllllllllllIIlIIllIIllIIIlIIlI) && this.data == ((NBTTagByte)lllllllllllllIIlIIllIIllIIIlIIlI).data;
    }
    
    public NBTTagByte(final byte lllllllllllllIIlIIllIIllIIllIIIl) {
        this.data = lllllllllllllIIlIIllIIllIIllIIIl;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    public int getInt() {
        return this.data;
    }
    
    @Override
    public byte getByte() {
        return this.data;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public byte getId() {
        return 1;
    }
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.data)).append("b"));
    }
    
    @Override
    void read(final DataInput lllllllllllllIIlIIllIIllIIlIIlII, final int lllllllllllllIIlIIllIIllIIlIIIll, final NBTSizeTracker lllllllllllllIIlIIllIIllIIIlllll) throws IOException {
        lllllllllllllIIlIIllIIllIIIlllll.read(72L);
        this.data = lllllllllllllIIlIIllIIllIIlIIlII.readByte();
    }
    
    @Override
    void write(final DataOutput lllllllllllllIIlIIllIIllIIlIlIll) throws IOException {
        lllllllllllllIIlIIllIIllIIlIlIll.writeByte(this.data);
    }
    
    @Override
    public short getShort() {
        return this.data;
    }
    
    @Override
    public NBTTagByte copy() {
        return new NBTTagByte(this.data);
    }
    
    NBTTagByte() {
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
}
