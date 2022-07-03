package com.viaversion.viaversion.api.minecraft.chunks;

import java.util.*;

public class NibbleArray
{
    private final /* synthetic */ byte[] handle;
    
    public int size() {
        return this.handle.length * 2;
    }
    
    public int actualSize() {
        return this.handle.length;
    }
    
    public void set(final int lllllllllllllIIlIllIIIlllIlIIlII, final int lllllllllllllIIlIllIIIlllIlIIIll, final int lllllllllllllIIlIllIIIlllIlIIIlI, final int lllllllllllllIIlIllIIIlllIlIIIIl) {
        this.set(ChunkSection.index(lllllllllllllIIlIllIIIlllIlIIlII, lllllllllllllIIlIllIIIlllIlIIIll, lllllllllllllIIlIllIIIlllIlIIIlI), lllllllllllllIIlIllIIIlllIlIIIIl);
    }
    
    public byte[] getHandle() {
        return this.handle;
    }
    
    public void setHandle(final byte[] lllllllllllllIIlIllIIIllIllllllI) {
        if (lllllllllllllIIlIllIIIllIllllllI.length != this.handle.length) {
            throw new IllegalArgumentException("Length of handle must equal to size of nibble array!");
        }
        System.arraycopy(lllllllllllllIIlIllIIIllIllllllI, 0, this.handle, 0, lllllllllllllIIlIllIIIllIllllllI.length);
    }
    
    public NibbleArray(final int lllllllllllllIIlIllIIIllllIIIllI) {
        if (lllllllllllllIIlIllIIIllllIIIllI == 0 || lllllllllllllIIlIllIIIllllIIIllI % 2 != 0) {
            throw new IllegalArgumentException("Length of nibble array must be a positive number dividable by 2!");
        }
        this.handle = new byte[lllllllllllllIIlIllIIIllllIIIllI / 2];
    }
    
    public byte get(final int lllllllllllllIIlIllIIIlllIlllIlI, final int lllllllllllllIIlIllIIIlllIllIlIl, final int lllllllllllllIIlIllIIIlllIllIlII) {
        return this.get(ChunkSection.index(lllllllllllllIIlIllIIIlllIlllIlI, lllllllllllllIIlIllIIIlllIllIlIl, lllllllllllllIIlIllIIIlllIllIlII));
    }
    
    public void set(int lllllllllllllIIlIllIIIlllIIlIlII, final int lllllllllllllIIlIllIIIlllIIlIIll) {
        if (lllllllllllllIIlIllIIIlllIIlIlII % 2 == 0) {
            lllllllllllllIIlIllIIIlllIIlIlII /= 2;
            this.handle[lllllllllllllIIlIllIIIlllIIlIlII] = (byte)((this.handle[lllllllllllllIIlIllIIIlllIIlIlII] & 0xF0) | (lllllllllllllIIlIllIIIlllIIlIIll & 0xF));
        }
        else {
            lllllllllllllIIlIllIIIlllIIlIlII /= 2;
            this.handle[lllllllllllllIIlIllIIIlllIIlIlII] = (byte)((this.handle[lllllllllllllIIlIllIIIlllIIlIlII] & 0xF) | (lllllllllllllIIlIllIIIlllIIlIIll & 0xF) << 4);
        }
    }
    
    public void fill(byte lllllllllllllIIlIllIIIlllIIIIlll) {
        lllllllllllllIIlIllIIIlllIIIIlll = (byte)(lllllllllllllIIlIllIIIlllIIIIlll & 0xF);
        Arrays.fill(this.handle, (byte)(lllllllllllllIIlIllIIIlllIIIIlll << 4 | lllllllllllllIIlIllIIIlllIIIIlll));
    }
    
    public byte get(final int lllllllllllllIIlIllIIIlllIlIllll) {
        final byte lllllllllllllIIlIllIIIlllIlIlllI = this.handle[lllllllllllllIIlIllIIIlllIlIllll / 2];
        if (lllllllllllllIIlIllIIIlllIlIllll % 2 == 0) {
            return (byte)(lllllllllllllIIlIllIIIlllIlIlllI & 0xF);
        }
        return (byte)(lllllllllllllIIlIllIIIlllIlIlllI >> 4 & 0xF);
    }
    
    public NibbleArray(final byte[] lllllllllllllIIlIllIIIllllIIIIII) {
        if (lllllllllllllIIlIllIIIllllIIIIII.length == 0 || lllllllllllllIIlIllIIIllllIIIIII.length % 2 != 0) {
            throw new IllegalArgumentException("Length of nibble array must be a positive number dividable by 2!");
        }
        this.handle = lllllllllllllIIlIllIIIllllIIIIII;
    }
}
