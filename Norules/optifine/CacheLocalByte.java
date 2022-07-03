package optifine;

public class CacheLocalByte
{
    private /* synthetic */ byte[] lastZs;
    private /* synthetic */ int maxY;
    private /* synthetic */ int offsetX;
    private /* synthetic */ int maxX;
    private /* synthetic */ int offsetY;
    private /* synthetic */ int lastDz;
    private /* synthetic */ int maxZ;
    private /* synthetic */ int offsetZ;
    private /* synthetic */ byte[][][] cache;
    
    public CacheLocalByte(final int llllllllllllllIllIIIllIIlIllIIIl, final int llllllllllllllIllIIIllIIlIllIIII, final int llllllllllllllIllIIIllIIlIlIllll) {
        this.maxX = 18;
        this.maxY = 128;
        this.maxZ = 18;
        this.offsetX = 0;
        this.offsetY = 0;
        this.offsetZ = 0;
        this.cache = null;
        this.lastZs = null;
        this.lastDz = 0;
        this.maxX = llllllllllllllIllIIIllIIlIllIIIl;
        this.maxY = llllllllllllllIllIIIllIIlIllIIII;
        this.maxZ = llllllllllllllIllIIIllIIlIlIllll;
        this.cache = new byte[llllllllllllllIllIIIllIIlIllIIIl][llllllllllllllIllIIIllIIlIllIIII][llllllllllllllIllIIIllIIlIlIllll];
        this.resetCache();
    }
    
    public void resetCache() {
        for (int llllllllllllllIllIIIllIIlIlIIlll = 0; llllllllllllllIllIIIllIIlIlIIlll < this.maxX; ++llllllllllllllIllIIIllIIlIlIIlll) {
            final byte[][] llllllllllllllIllIIIllIIlIlIIllI = this.cache[llllllllllllllIllIIIllIIlIlIIlll];
            for (int llllllllllllllIllIIIllIIlIlIIlIl = 0; llllllllllllllIllIIIllIIlIlIIlIl < this.maxY; ++llllllllllllllIllIIIllIIlIlIIlIl) {
                final byte[] llllllllllllllIllIIIllIIlIlIIlII = llllllllllllllIllIIIllIIlIlIIllI[llllllllllllllIllIIIllIIlIlIIlIl];
                for (int llllllllllllllIllIIIllIIlIlIIIll = 0; llllllllllllllIllIIIllIIlIlIIIll < this.maxZ; ++llllllllllllllIllIIIllIIlIlIIIll) {
                    llllllllllllllIllIIIllIIlIlIIlII[llllllllllllllIllIIIllIIlIlIIIll] = -1;
                }
            }
        }
    }
    
    public void setLast(final byte llllllllllllllIllIIIllIIIllllIlI) {
        try {
            this.lastZs[this.lastDz] = llllllllllllllIllIIIllIIIllllIlI;
        }
        catch (Exception llllllllllllllIllIIIllIIIlllllII) {
            llllllllllllllIllIIIllIIIlllllII.printStackTrace();
        }
    }
    
    public byte get(final int llllllllllllllIllIIIllIIlIIIIlIl, final int llllllllllllllIllIIIllIIlIIIIlII, final int llllllllllllllIllIIIllIIlIIIIIll) {
        try {
            this.lastZs = this.cache[llllllllllllllIllIIIllIIlIIIIlIl - this.offsetX][llllllllllllllIllIIIllIIlIIIIlII - this.offsetY];
            this.lastDz = llllllllllllllIllIIIllIIlIIIIIll - this.offsetZ;
            return this.lastZs[this.lastDz];
        }
        catch (ArrayIndexOutOfBoundsException llllllllllllllIllIIIllIIlIIIIlll) {
            llllllllllllllIllIIIllIIlIIIIlll.printStackTrace();
            return -1;
        }
    }
    
    public void setOffset(final int llllllllllllllIllIIIllIIlIIlIIll, final int llllllllllllllIllIIIllIIlIIlIllI, final int llllllllllllllIllIIIllIIlIIlIIIl) {
        this.offsetX = llllllllllllllIllIIIllIIlIIlIIll;
        this.offsetY = llllllllllllllIllIIIllIIlIIlIllI;
        this.offsetZ = llllllllllllllIllIIIllIIlIIlIIIl;
        this.resetCache();
    }
}
