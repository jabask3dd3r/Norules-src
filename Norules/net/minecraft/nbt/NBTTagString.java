package net.minecraft.nbt;

import java.util.*;
import java.io.*;

public class NBTTagString extends NBTBase
{
    private /* synthetic */ String data;
    
    @Override
    public NBTTagString copy() {
        return new NBTTagString(this.data);
    }
    
    public static String func_193588_a(final String llllllllllllllIllIllIllIllllIIII) {
        final StringBuilder llllllllllllllIllIllIllIlllIllll = new StringBuilder("\"");
        for (int llllllllllllllIllIllIllIlllIlllI = 0; llllllllllllllIllIllIllIlllIlllI < llllllllllllllIllIllIllIllllIIII.length(); ++llllllllllllllIllIllIllIlllIlllI) {
            final char llllllllllllllIllIllIllIlllIllIl = llllllllllllllIllIllIllIllllIIII.charAt(llllllllllllllIllIllIllIlllIlllI);
            if (llllllllllllllIllIllIllIlllIllIl == '\\' || llllllllllllllIllIllIllIlllIllIl == '\"') {
                llllllllllllllIllIllIllIlllIllll.append('\\');
            }
            llllllllllllllIllIllIllIlllIllll.append(llllllllllllllIllIllIllIlllIllIl);
        }
        return String.valueOf(llllllllllllllIllIllIllIlllIllll.append('\"'));
    }
    
    @Override
    public String toString() {
        return func_193588_a(this.data);
    }
    
    public NBTTagString() {
        this("");
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data.hashCode();
    }
    
    public NBTTagString(final String llllllllllllllIllIllIlllIIIllllI) {
        Objects.requireNonNull(llllllllllllllIllIllIlllIIIllllI, "Null string not allowed");
        this.data = llllllllllllllIllIllIlllIIIllllI;
    }
    
    @Override
    public boolean hasNoTags() {
        return this.data.isEmpty();
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllIllIllIllllllII) {
        if (!super.equals(llllllllllllllIllIllIllIllllllII)) {
            return false;
        }
        final NBTTagString llllllllllllllIllIllIllIlllllllI = (NBTTagString)llllllllllllllIllIllIllIllllllII;
        return (this.data == null && llllllllllllllIllIllIllIlllllllI.data == null) || Objects.equals(this.data, llllllllllllllIllIllIllIlllllllI.data);
    }
    
    @Override
    void read(final DataInput llllllllllllllIllIllIlllIIIIllll, final int llllllllllllllIllIllIlllIIIlIIlI, final NBTSizeTracker llllllllllllllIllIllIlllIIIlIIIl) throws IOException {
        llllllllllllllIllIllIlllIIIlIIIl.read(288L);
        this.data = llllllllllllllIllIllIlllIIIIllll.readUTF();
        llllllllllllllIllIllIlllIIIlIIIl.read(16 * this.data.length());
    }
    
    @Override
    public byte getId() {
        return 8;
    }
    
    public String getString() {
        return this.data;
    }
    
    @Override
    void write(final DataOutput llllllllllllllIllIllIlllIIIllIII) throws IOException {
        llllllllllllllIllIllIlllIIIllIII.writeUTF(this.data);
    }
}
