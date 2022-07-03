package optifine;

public class CacheLocal
{
    private /* synthetic */ int lastDz;
    private /* synthetic */ int maxZ;
    private /* synthetic */ int[] lastZs;
    private /* synthetic */ int maxX;
    private /* synthetic */ int offsetX;
    private /* synthetic */ int maxY;
    private /* synthetic */ int offsetZ;
    private /* synthetic */ int[][][] cache;
    private /* synthetic */ int offsetY;
    
    public void setOffset(final int llllllllllllllIIlIlIIlIllllIIlll, final int llllllllllllllIIlIlIIlIllllIIllI, final int llllllllllllllIIlIlIIlIllllIIIIl) {
        this.offsetX = llllllllllllllIIlIlIIlIllllIIlll;
        this.offsetY = llllllllllllllIIlIlIIlIllllIIllI;
        this.offsetZ = llllllllllllllIIlIlIIlIllllIIIIl;
        this.resetCache();
    }
    
    public int get(final int llllllllllllllIIlIlIIlIlllIllIlI, final int llllllllllllllIIlIlIIlIlllIllIIl, final int llllllllllllllIIlIlIIlIlllIllIII) {
        try {
            this.lastZs = this.cache[llllllllllllllIIlIlIIlIlllIllIlI - this.offsetX][llllllllllllllIIlIlIIlIlllIllIIl - this.offsetY];
            this.lastDz = llllllllllllllIIlIlIIlIlllIllIII - this.offsetZ;
            return this.lastZs[this.lastDz];
        }
        catch (ArrayIndexOutOfBoundsException llllllllllllllIIlIlIIlIlllIlIlll) {
            llllllllllllllIIlIlIIlIlllIlIlll.printStackTrace();
            return -1;
        }
    }
    
    public void setLast(final int llllllllllllllIIlIlIIlIlllIIllIl) {
        try {
            this.lastZs[this.lastDz] = llllllllllllllIIlIlIIlIlllIIllIl;
        }
        catch (Exception llllllllllllllIIlIlIIlIlllIIllII) {
            llllllllllllllIIlIlIIlIlllIIllII.printStackTrace();
        }
    }
    
    public CacheLocal(final int llllllllllllllIIlIlIIllIIIIIIlIl, final int llllllllllllllIIlIlIIllIIIIIIIII, final int llllllllllllllIIlIlIIlIlllllllll) {
        this.maxX = 18;
        this.maxY = 128;
        this.maxZ = 18;
        this.offsetX = 0;
        this.offsetY = 0;
        this.offsetZ = 0;
        this.cache = null;
        this.lastZs = null;
        this.lastDz = 0;
        this.maxX = llllllllllllllIIlIlIIllIIIIIIlIl;
        this.maxY = llllllllllllllIIlIlIIllIIIIIIIII;
        this.maxZ = llllllllllllllIIlIlIIlIlllllllll;
        this.cache = new int[llllllllllllllIIlIlIIllIIIIIIlIl][llllllllllllllIIlIlIIllIIIIIIIII][llllllllllllllIIlIlIIlIlllllllll];
        this.resetCache();
    }
    
    public void resetCache() {
        for (int llllllllllllllIIlIlIIlIlllllIlll = 0; llllllllllllllIIlIlIIlIlllllIlll < this.maxX; ++llllllllllllllIIlIlIIlIlllllIlll) {
            final int[][] llllllllllllllIIlIlIIlIlllllIllI = this.cache[llllllllllllllIIlIlIIlIlllllIlll];
            for (int llllllllllllllIIlIlIIlIlllllIlIl = 0; llllllllllllllIIlIlIIlIlllllIlIl < this.maxY; ++llllllllllllllIIlIlIIlIlllllIlIl) {
                final int[] llllllllllllllIIlIlIIlIlllllIlII = llllllllllllllIIlIlIIlIlllllIllI[llllllllllllllIIlIlIIlIlllllIlIl];
                for (int llllllllllllllIIlIlIIlIlllllIIll = 0; llllllllllllllIIlIlIIlIlllllIIll < this.maxZ; ++llllllllllllllIIlIlIIlIlllllIIll) {
                    llllllllllllllIIlIlIIlIlllllIlII[llllllllllllllIIlIlIIlIlllllIIll] = -1;
                }
            }
        }
    }
}
