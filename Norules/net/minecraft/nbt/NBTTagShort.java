package net.minecraft.nbt;

import java.io.*;

public class NBTTagShort extends NBTPrimitive
{
    private /* synthetic */ short data;
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    public NBTTagShort() {
    }
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFF);
    }
    
    @Override
    public short getShort() {
        return this.data;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIIlIIlllllIlIIll) {
        return super.equals(lllllllllllllIIlIIlIIlllllIlIIll) && this.data == ((NBTTagShort)lllllllllllllIIlIIlIIlllllIlIIll).data;
    }
    
    @Override
    public NBTTagShort copy() {
        return new NBTTagShort(this.data);
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    public byte getId() {
        return 2;
    }
    
    public NBTTagShort(final short lllllllllllllIIlIIlIIlllllllIIlI) {
        this.data = lllllllllllllIIlIIlIIlllllllIIlI;
    }
    
    @Override
    void write(final DataOutput lllllllllllllIIlIIlIIllllllIlIlI) throws IOException {
        lllllllllllllIIlIIlIIllllllIlIlI.writeShort(this.data);
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
    void read(final DataInput lllllllllllllIIlIIlIIllllllIIIIl, final int lllllllllllllIIlIIlIIllllllIIlII, final NBTSizeTracker lllllllllllllIIlIIlIIllllllIIIll) throws IOException {
        lllllllllllllIIlIIlIIllllllIIIll.read(80L);
        this.data = lllllllllllllIIlIIlIIllllllIIIIl.readShort();
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.data)).append("s"));
    }
}
