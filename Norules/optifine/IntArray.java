package optifine;

public class IntArray
{
    private /* synthetic */ int limit;
    private /* synthetic */ int position;
    private /* synthetic */ int[] array;
    
    public void position(final int lllllllllllllllllllllIlIIIIIlIIl) {
        this.position = lllllllllllllllllllllIlIIIIIlIIl;
    }
    
    public void clear() {
        this.position = 0;
        this.limit = 0;
    }
    
    public void put(final int lllllllllllllllllllllIlIIIIllIII) {
        this.array[this.position] = lllllllllllllllllllllIlIIIIllIII;
        ++this.position;
        if (this.limit < this.position) {
            this.limit = this.position;
        }
    }
    
    public int[] getArray() {
        return this.array;
    }
    
    public void put(final int lllllllllllllllllllllIlIIIIlIIIl, final int lllllllllllllllllllllIlIIIIlIIII) {
        this.array[lllllllllllllllllllllIlIIIIlIIIl] = lllllllllllllllllllllIlIIIIlIIII;
        if (this.limit < lllllllllllllllllllllIlIIIIlIIIl) {
            this.limit = lllllllllllllllllllllIlIIIIlIIIl;
        }
    }
    
    public IntArray(final int lllllllllllllllllllllIlIIIIllllI) {
        this.array = null;
        this.position = 0;
        this.limit = 0;
        this.array = new int[lllllllllllllllllllllIlIIIIllllI];
    }
    
    public void put(final int[] lllllllllllllllllllllIlIIIIIIIIl) {
        for (int lllllllllllllllllllllIlIIIIIIIII = lllllllllllllllllllllIlIIIIIIIIl.length, lllllllllllllllllllllIIlllllllll = 0; lllllllllllllllllllllIIlllllllll < lllllllllllllllllllllIlIIIIIIIII; ++lllllllllllllllllllllIIlllllllll) {
            this.array[this.position] = lllllllllllllllllllllIlIIIIIIIIl[lllllllllllllllllllllIIlllllllll];
            ++this.position;
        }
        if (this.limit < this.position) {
            this.limit = this.position;
        }
    }
    
    public int get(final int lllllllllllllllllllllIIlllllIlll) {
        return this.array[lllllllllllllllllllllIIlllllIlll];
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public int getLimit() {
        return this.limit;
    }
}
