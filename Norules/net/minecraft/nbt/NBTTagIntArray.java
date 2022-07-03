package net.minecraft.nbt;

import java.io.*;
import java.util.*;

public class NBTTagIntArray extends NBTBase
{
    private /* synthetic */ int[] intArray;
    
    @Override
    void read(final DataInput llllllllllllIlllllIlIlIIIlIllIlI, final int llllllllllllIlllllIlIlIIIlIllIIl, final NBTSizeTracker llllllllllllIlllllIlIlIIIlIllIII) throws IOException {
        llllllllllllIlllllIlIlIIIlIllIII.read(192L);
        final int llllllllllllIlllllIlIlIIIlIlIlll = llllllllllllIlllllIlIlIIIlIllIlI.readInt();
        llllllllllllIlllllIlIlIIIlIllIII.read(32 * llllllllllllIlllllIlIlIIIlIlIlll);
        this.intArray = new int[llllllllllllIlllllIlIlIIIlIlIlll];
        for (int llllllllllllIlllllIlIlIIIlIlIllI = 0; llllllllllllIlllllIlIlIIIlIlIllI < llllllllllllIlllllIlIlIIIlIlIlll; ++llllllllllllIlllllIlIlIIIlIlIllI) {
            this.intArray[llllllllllllIlllllIlIlIIIlIlIllI] = llllllllllllIlllllIlIlIIIlIllIlI.readInt();
        }
    }
    
    public NBTTagIntArray(final List<Integer> llllllllllllIlllllIlIlIIIlllllII) {
        this(func_193584_a(llllllllllllIlllllIlIlIIIlllllII));
    }
    
    private static int[] func_193584_a(final List<Integer> llllllllllllIlllllIlIlIIIlllIIll) {
        final int[] llllllllllllIlllllIlIlIIIlllIllI = new int[llllllllllllIlllllIlIlIIIlllIIll.size()];
        for (int llllllllllllIlllllIlIlIIIlllIlIl = 0; llllllllllllIlllllIlIlIIIlllIlIl < llllllllllllIlllllIlIlIIIlllIIll.size(); ++llllllllllllIlllllIlIlIIIlllIlIl) {
            final Integer llllllllllllIlllllIlIlIIIlllIlII = llllllllllllIlllllIlIlIIIlllIIll.get(llllllllllllIlllllIlIlIIIlllIlIl);
            llllllllllllIlllllIlIlIIIlllIllI[llllllllllllIlllllIlIlIIIlllIlIl] = ((llllllllllllIlllllIlIlIIIlllIlII == null) ? 0 : llllllllllllIlllllIlIlIIIlllIlII);
        }
        return llllllllllllIlllllIlIlIIIlllIllI;
    }
    
    public int[] getIntArray() {
        return this.intArray;
    }
    
    @Override
    public String toString() {
        final StringBuilder llllllllllllIlllllIlIlIIIlIIlIll = new StringBuilder("[I;");
        for (int llllllllllllIlllllIlIlIIIlIIlIlI = 0; llllllllllllIlllllIlIlIIIlIIlIlI < this.intArray.length; ++llllllllllllIlllllIlIlIIIlIIlIlI) {
            if (llllllllllllIlllllIlIlIIIlIIlIlI != 0) {
                llllllllllllIlllllIlIlIIIlIIlIll.append(',');
            }
            llllllllllllIlllllIlIlIIIlIIlIll.append(this.intArray[llllllllllllIlllllIlIlIIIlIIlIlI]);
        }
        return String.valueOf(llllllllllllIlllllIlIlIIIlIIlIll.append(']'));
    }
    
    @Override
    void write(final DataOutput llllllllllllIlllllIlIlIIIllIlIII) throws IOException {
        llllllllllllIlllllIlIlIIIllIlIII.writeInt(this.intArray.length);
        final short llllllllllllIlllllIlIlIIIllIIIIl;
        final double llllllllllllIlllllIlIlIIIllIIIlI = ((int[])(Object)(llllllllllllIlllllIlIlIIIllIIIIl = (short)(Object)this.intArray)).length;
        for (byte llllllllllllIlllllIlIlIIIllIIIll = 0; llllllllllllIlllllIlIlIIIllIIIll < llllllllllllIlllllIlIlIIIllIIIlI; ++llllllllllllIlllllIlIlIIIllIIIll) {
            final int llllllllllllIlllllIlIlIIIllIIlll = llllllllllllIlllllIlIlIIIllIIIIl[llllllllllllIlllllIlIlIIIllIIIll];
            llllllllllllIlllllIlIlIIIllIlIII.writeInt(llllllllllllIlllllIlIlIIIllIIlll);
        }
    }
    
    @Override
    public byte getId() {
        return 11;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.intArray);
    }
    
    @Override
    public boolean equals(final Object llllllllllllIlllllIlIlIIIIlllIll) {
        return super.equals(llllllllllllIlllllIlIlIIIIlllIll) && Arrays.equals(this.intArray, ((NBTTagIntArray)llllllllllllIlllllIlIlIIIIlllIll).intArray);
    }
    
    NBTTagIntArray() {
    }
    
    @Override
    public NBTTagIntArray copy() {
        final int[] llllllllllllIlllllIlIlIIIlIIIIll = new int[this.intArray.length];
        System.arraycopy(this.intArray, 0, llllllllllllIlllllIlIlIIIlIIIIll, 0, this.intArray.length);
        return new NBTTagIntArray(llllllllllllIlllllIlIlIIIlIIIIll);
    }
    
    public NBTTagIntArray(final int[] llllllllllllIlllllIlIlIIlIIIIIlI) {
        this.intArray = llllllllllllIlllllIlIlIIlIIIIIlI;
    }
}
