package net.minecraft.nbt;

import java.io.*;

public class NBTTagInt extends NBTPrimitive
{
    private /* synthetic */ int data;
    
    @Override
    public short getShort() {
        return (short)(this.data & 0xFFFF);
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
    
    @Override
    public byte getByte() {
        return (byte)(this.data & 0xFF);
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    void read(final DataInput lllllllllllllIIlIIllIlIllIlIllll, final int lllllllllllllIIlIIllIlIllIllIIlI, final NBTSizeTracker lllllllllllllIIlIIllIlIllIlIlllI) throws IOException {
        lllllllllllllIIlIIllIlIllIlIlllI.read(96L);
        this.data = lllllllllllllIIlIIllIlIllIlIllll.readInt();
    }
    
    public NBTTagInt(final int lllllllllllllIIlIIllIlIlllIIIIII) {
        this.data = lllllllllllllIIlIIllIlIlllIIIIII;
    }
    
    @Override
    public int getInt() {
        return this.data;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    public byte getId() {
        return 3;
    }
    
    @Override
    public long getLong() {
        return this.data;
    }
    
    @Override
    void write(final DataOutput lllllllllllllIIlIIllIlIllIlllIII) throws IOException {
        lllllllllllllIIlIIllIlIllIlllIII.writeInt(this.data);
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    @Override
    public NBTTagInt copy() {
        return new NBTTagInt(this.data);
    }
    
    NBTTagInt() {
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIIllIlIllIlIIIll) {
        return super.equals(lllllllllllllIIlIIllIlIllIlIIIll) && this.data == ((NBTTagInt)lllllllllllllIIlIIllIlIllIlIIIll).data;
    }
}
