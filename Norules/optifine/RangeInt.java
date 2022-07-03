package optifine;

public class RangeInt
{
    private /* synthetic */ int min;
    private /* synthetic */ int max;
    
    public RangeInt(final int lllllllllllllllIIIIIIlIIlIlIIIll, final int lllllllllllllllIIIIIIlIIlIlIIlIl) {
        this.min = Math.min(lllllllllllllllIIIIIIlIIlIlIIIll, lllllllllllllllIIIIIIlIIlIlIIlIl);
        this.max = Math.max(lllllllllllllllIIIIIIlIIlIlIIIll, lllllllllllllllIIIIIIlIIlIlIIlIl);
    }
    
    public int getMax() {
        return this.max;
    }
    
    public int getMin() {
        return this.min;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("min: ").append(this.min).append(", max: ").append(this.max));
    }
    
    public boolean isInRange(final int lllllllllllllllIIIIIIlIIlIIlllII) {
        return lllllllllllllllIIIIIIlIIlIIlllII >= this.min && lllllllllllllllIIIIIIlIIlIIlllII <= this.max;
    }
}
