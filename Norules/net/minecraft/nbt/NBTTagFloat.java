package net.minecraft.nbt;

import net.minecraft.util.math.*;
import java.io.*;

public class NBTTagFloat extends NBTPrimitive
{
    private /* synthetic */ float data;
    
    NBTTagFloat() {
    }
    
    @Override
    public NBTTagFloat copy() {
        return new NBTTagFloat(this.data);
    }
    
    @Override
    void write(final DataOutput llllllllllllllIlIIllIIllIlIlIllI) throws IOException {
        llllllllllllllIlIIllIIllIlIlIllI.writeFloat(this.data);
    }
    
    @Override
    public long getLong() {
        return (long)this.data;
    }
    
    @Override
    public short getShort() {
        return (short)(MathHelper.floor(this.data) & 0xFFFF);
    }
    
    @Override
    void read(final DataInput llllllllllllllIlIIllIIllIlIIlIll, final int llllllllllllllIlIIllIIllIlIIlllI, final NBTSizeTracker llllllllllllllIlIIllIIllIlIIlIlI) throws IOException {
        llllllllllllllIlIIllIIllIlIIlIlI.read(96L);
        this.data = llllllllllllllIlIIllIIllIlIIlIll.readFloat();
    }
    
    @Override
    public int getInt() {
        return MathHelper.floor(this.data);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Float.floatToIntBits(this.data);
    }
    
    @Override
    public byte getByte() {
        return (byte)(MathHelper.floor(this.data) & 0xFF);
    }
    
    @Override
    public byte getId() {
        return 5;
    }
    
    public NBTTagFloat(final float llllllllllllllIlIIllIIllIlIlllII) {
        this.data = llllllllllllllIlIIllIIllIlIlllII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.data)).append("f"));
    }
    
    @Override
    public float getFloat() {
        return this.data;
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIlIIllIIllIIllllll) {
        return super.equals(llllllllllllllIlIIllIIllIIllllll) && this.data == ((NBTTagFloat)llllllllllllllIlIIllIIllIIllllll).data;
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
}
