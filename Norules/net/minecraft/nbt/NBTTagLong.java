package net.minecraft.nbt;

import java.io.*;

public class NBTTagLong extends NBTPrimitive
{
    private /* synthetic */ long data;
    
    @Override
    public int getInt() {
        return (int)(this.data & -1L);
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFFL);
    }
    
    @Override
    public double getDouble() {
        return (double)this.data;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.data)).append("L"));
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ (int)(this.data ^ this.data >>> 32);
    }
    
    @Override
    void write(final DataOutput lllllllllllllIIlllIIlIIllIlIlIll) throws IOException {
        lllllllllllllIIlllIIlIIllIlIlIll.writeLong(this.data);
    }
    
    @Override
    public NBTTagLong copy() {
        return new NBTTagLong(this.data);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlllIIlIIllIIlIlII) {
        return super.equals(lllllllllllllIIlllIIlIIllIIlIlII) && this.data == ((NBTTagLong)lllllllllllllIIlllIIlIIllIIlIlII).data;
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    public short getShort() {
        return (short)(this.data & 0xFFFFL);
    }
    
    @Override
    public byte getId() {
        return 4;
    }
    
    public NBTTagLong(final long lllllllllllllIIlllIIlIIllIllIIIl) {
        this.data = lllllllllllllIIlllIIlIIllIllIIIl;
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    NBTTagLong() {
    }
    
    @Override
    void read(final DataInput lllllllllllllIIlllIIlIIllIlIIlII, final int lllllllllllllIIlllIIlIIllIlIIIll, final NBTSizeTracker lllllllllllllIIlllIIlIIllIlIIIlI) throws IOException {
        lllllllllllllIIlllIIlIIllIlIIIlI.read(128L);
        this.data = lllllllllllllIIlllIIlIIllIlIIlII.readLong();
    }
}
