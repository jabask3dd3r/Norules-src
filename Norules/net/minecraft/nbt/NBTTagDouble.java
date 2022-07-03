package net.minecraft.nbt;

import net.minecraft.util.math.*;
import java.io.*;

public class NBTTagDouble extends NBTPrimitive
{
    private /* synthetic */ double data;
    
    public NBTTagDouble(final double lllllllllllllllllIlIllIllIllIlIl) {
        this.data = lllllllllllllllllIlIllIllIllIlIl;
    }
    
    NBTTagDouble() {
    }
    
    @Override
    public byte getId() {
        return 6;
    }
    
    @Override
    public byte getByte() {
        return (byte)(MathHelper.floor(this.data) & 0xFF);
    }
    
    @Override
    public int hashCode() {
        final long lllllllllllllllllIlIllIllIIlIlII = Double.doubleToLongBits(this.data);
        return super.hashCode() ^ (int)(lllllllllllllllllIlIllIllIIlIlII ^ lllllllllllllllllIlIllIllIIlIlII >>> 32);
    }
    
    @Override
    public long getLong() {
        return (long)Math.floor(this.data);
    }
    
    @Override
    void read(final DataInput lllllllllllllllllIlIllIllIlIIllI, final int lllllllllllllllllIlIllIllIlIlIIl, final NBTSizeTracker lllllllllllllllllIlIllIllIlIlIII) throws IOException {
        lllllllllllllllllIlIllIllIlIlIII.read(128L);
        this.data = lllllllllllllllllIlIllIllIlIIllI.readDouble();
    }
    
    @Override
    public short getShort() {
        return (short)(MathHelper.floor(this.data) & 0xFFFF);
    }
    
    @Override
    void write(final DataOutput lllllllllllllllllIlIllIllIlIllll) throws IOException {
        lllllllllllllllllIlIllIllIlIllll.writeDouble(this.data);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder(String.valueOf(this.data)).append("d"));
    }
    
    @Override
    public double getDouble() {
        return this.data;
    }
    
    @Override
    public float getFloat() {
        return (float)this.data;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllllIlIllIllIIllIII) {
        return super.equals(lllllllllllllllllIlIllIllIIllIII) && this.data == ((NBTTagDouble)lllllllllllllllllIlIllIllIIllIII).data;
    }
    
    @Override
    public int getInt() {
        return MathHelper.floor(this.data);
    }
    
    @Override
    public NBTTagDouble copy() {
        return new NBTTagDouble(this.data);
    }
}
