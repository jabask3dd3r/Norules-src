package net.minecraft.world.chunk;

public class NibbleArray
{
    private final /* synthetic */ byte[] data;
    
    private int getCoordinateIndex(final int lllllllllllllIIIllllllIlIIIllIlI, final int lllllllllllllIIIllllllIlIIIlllII, final int lllllllllllllIIIllllllIlIIIllIII) {
        return lllllllllllllIIIllllllIlIIIlllII << 8 | lllllllllllllIIIllllllIlIIIllIII << 4 | lllllllllllllIIIllllllIlIIIllIlI;
    }
    
    public NibbleArray() {
        this.data = new byte[2048];
    }
    
    public int get(final int lllllllllllllIIIllllllIlIIllIIll, final int lllllllllllllIIIllllllIlIIllIIlI, final int lllllllllllllIIIllllllIlIIllIlIl) {
        return this.getFromIndex(this.getCoordinateIndex(lllllllllllllIIIllllllIlIIllIIll, lllllllllllllIIIllllllIlIIllIIlI, lllllllllllllIIIllllllIlIIllIlIl));
    }
    
    public void set(final int lllllllllllllIIIllllllIlIIlIlIlI, final int lllllllllllllIIIllllllIlIIlIIlII, final int lllllllllllllIIIllllllIlIIlIIIll, final int lllllllllllllIIIllllllIlIIlIIIlI) {
        this.setIndex(this.getCoordinateIndex(lllllllllllllIIIllllllIlIIlIlIlI, lllllllllllllIIIllllllIlIIlIIlII, lllllllllllllIIIllllllIlIIlIIIll), lllllllllllllIIIllllllIlIIlIIIlI);
    }
    
    private boolean isLowerNibble(final int lllllllllllllIIIllllllIlIIIIIIII) {
        return (lllllllllllllIIIllllllIlIIIIIIII & 0x1) == 0x0;
    }
    
    private int getNibbleIndex(final int lllllllllllllIIIllllllIIlllllIll) {
        return lllllllllllllIIIllllllIIlllllIll >> 1;
    }
    
    public byte[] getData() {
        return this.data;
    }
    
    public int getFromIndex(final int lllllllllllllIIIllllllIlIIIlIIII) {
        final int lllllllllllllIIIllllllIlIIIlIIlI = this.getNibbleIndex(lllllllllllllIIIllllllIlIIIlIIII);
        return this.isLowerNibble(lllllllllllllIIIllllllIlIIIlIIII) ? (this.data[lllllllllllllIIIllllllIlIIIlIIlI] & 0xF) : (this.data[lllllllllllllIIIllllllIlIIIlIIlI] >> 4 & 0xF);
    }
    
    public void setIndex(final int lllllllllllllIIIllllllIlIIIIlIIl, final int lllllllllllllIIIllllllIlIIIIIlII) {
        final int lllllllllllllIIIllllllIlIIIIIlll = this.getNibbleIndex(lllllllllllllIIIllllllIlIIIIlIIl);
        if (this.isLowerNibble(lllllllllllllIIIllllllIlIIIIlIIl)) {
            this.data[lllllllllllllIIIllllllIlIIIIIlll] = (byte)((this.data[lllllllllllllIIIllllllIlIIIIIlll] & 0xF0) | (lllllllllllllIIIllllllIlIIIIIlII & 0xF));
        }
        else {
            this.data[lllllllllllllIIIllllllIlIIIIIlll] = (byte)((this.data[lllllllllllllIIIllllllIlIIIIIlll] & 0xF) | (lllllllllllllIIIllllllIlIIIIIlII & 0xF) << 4);
        }
    }
    
    public NibbleArray(final byte[] lllllllllllllIIIllllllIlIIllllIl) {
        this.data = lllllllllllllIIIllllllIlIIllllIl;
        if (lllllllllllllIIIllllllIlIIllllIl.length != 2048) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("ChunkNibbleArrays should be 2048 bytes not: ").append(lllllllllllllIIIllllllIlIIllllIl.length)));
        }
    }
}
