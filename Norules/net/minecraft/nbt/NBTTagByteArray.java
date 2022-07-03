package net.minecraft.nbt;

import java.util.*;
import java.io.*;

public class NBTTagByteArray extends NBTBase
{
    private /* synthetic */ byte[] data;
    
    @Override
    void write(final DataOutput lllllllllllllIlIIIllIllllIlIlIll) throws IOException {
        lllllllllllllIlIIIllIllllIlIlIll.writeInt(this.data.length);
        lllllllllllllIlIIIllIllllIlIlIll.write(this.data);
    }
    
    public NBTTagByteArray(final byte[] lllllllllllllIlIIIllIlllllIllIII) {
        this.data = lllllllllllllIlIIIllIlllllIllIII;
    }
    
    public byte[] getByteArray() {
        return this.data;
    }
    
    private static byte[] func_193589_a(final List<Byte> lllllllllllllIlIIIllIllllIlllIlI) {
        final byte[] lllllllllllllIlIIIllIlllllIIIIII = new byte[lllllllllllllIlIIIllIllllIlllIlI.size()];
        for (int lllllllllllllIlIIIllIllllIlllllI = 0; lllllllllllllIlIIIllIllllIlllllI < lllllllllllllIlIIIllIllllIlllIlI.size(); ++lllllllllllllIlIIIllIllllIlllllI) {
            final Byte lllllllllllllIlIIIllIllllIllllII = lllllllllllllIlIIIllIllllIlllIlI.get(lllllllllllllIlIIIllIllllIlllllI);
            lllllllllllllIlIIIllIlllllIIIIII[lllllllllllllIlIIIllIllllIlllllI] = (byte)((lllllllllllllIlIIIllIllllIllllII == null) ? 0 : ((byte)lllllllllllllIlIIIllIllllIllllII));
        }
        return lllllllllllllIlIIIllIlllllIIIIII;
    }
    
    public NBTTagByteArray(final List<Byte> lllllllllllllIlIIIllIlllllIIllll) {
        this(func_193589_a(lllllllllllllIlIIIllIlllllIIllll));
    }
    
    NBTTagByteArray() {
    }
    
    @Override
    public NBTBase copy() {
        final byte[] lllllllllllllIlIIIllIlllIlllIIll = new byte[this.data.length];
        System.arraycopy(this.data, 0, lllllllllllllIlIIIllIlllIlllIIll, 0, this.data.length);
        return new NBTTagByteArray(lllllllllllllIlIIIllIlllIlllIIll);
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.data);
    }
    
    @Override
    public String toString() {
        final StringBuilder lllllllllllllIlIIIllIlllIlllllll = new StringBuilder("[B;");
        for (int lllllllllllllIlIIIllIlllIlllllIl = 0; lllllllllllllIlIIIllIlllIlllllIl < this.data.length; ++lllllllllllllIlIIIllIlllIlllllIl) {
            if (lllllllllllllIlIIIllIlllIlllllIl != 0) {
                lllllllllllllIlIIIllIlllIlllllll.append(',');
            }
            lllllllllllllIlIIIllIlllIlllllll.append(this.data[lllllllllllllIlIIIllIlllIlllllIl]).append('B');
        }
        return String.valueOf(lllllllllllllIlIIIllIlllIlllllll.append(']'));
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIIIllIlllIlIlllll) {
        return super.equals(lllllllllllllIlIIIllIlllIlIlllll) && Arrays.equals(this.data, ((NBTTagByteArray)lllllllllllllIlIIIllIlllIlIlllll).data);
    }
    
    @Override
    public byte getId() {
        return 7;
    }
    
    @Override
    void read(final DataInput lllllllllllllIlIIIllIllllIIllIlI, final int lllllllllllllIlIIIllIllllIIllIIl, final NBTSizeTracker lllllllllllllIlIIIllIllllIIllIII) throws IOException {
        lllllllllllllIlIIIllIllllIIllIII.read(192L);
        final int lllllllllllllIlIIIllIllllIIlIlll = lllllllllllllIlIIIllIllllIIllIlI.readInt();
        lllllllllllllIlIIIllIllllIIllIII.read(8 * lllllllllllllIlIIIllIllllIIlIlll);
        this.data = new byte[lllllllllllllIlIIIllIllllIIlIlll];
        lllllllllllllIlIIIllIllllIIllIlI.readFully(this.data);
    }
}
