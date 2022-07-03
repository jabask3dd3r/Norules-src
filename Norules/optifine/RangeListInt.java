package optifine;

public class RangeListInt
{
    private /* synthetic */ RangeInt[] ranges;
    
    public boolean isInRange(final int lllllllllllllIlIIlIlIlIlllIllIll) {
        for (int lllllllllllllIlIIlIlIlIlllIllllI = 0; lllllllllllllIlIIlIlIlIlllIllllI < this.ranges.length; ++lllllllllllllIlIIlIlIlIlllIllllI) {
            final RangeInt lllllllllllllIlIIlIlIlIlllIlllIl = this.ranges[lllllllllllllIlIIlIlIlIlllIllllI];
            if (lllllllllllllIlIIlIlIlIlllIlllIl.isInRange(lllllllllllllIlIIlIlIlIlllIllIll)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        final StringBuffer lllllllllllllIlIIlIlIlIlllIIlIlI = new StringBuffer();
        lllllllllllllIlIIlIlIlIlllIIlIlI.append("[");
        for (int lllllllllllllIlIIlIlIlIlllIIlIIl = 0; lllllllllllllIlIIlIlIlIlllIIlIIl < this.ranges.length; ++lllllllllllllIlIIlIlIlIlllIIlIIl) {
            final RangeInt lllllllllllllIlIIlIlIlIlllIIlIII = this.ranges[lllllllllllllIlIIlIlIlIlllIIlIIl];
            if (lllllllllllllIlIIlIlIlIlllIIlIIl > 0) {
                lllllllllllllIlIIlIlIlIlllIIlIlI.append(", ");
            }
            lllllllllllllIlIIlIlIlIlllIIlIlI.append(lllllllllllllIlIIlIlIlIlllIIlIII.toString());
        }
        lllllllllllllIlIIlIlIlIlllIIlIlI.append("]");
        return lllllllllllllIlIIlIlIlIlllIIlIlI.toString();
    }
    
    public int getCountRanges() {
        return this.ranges.length;
    }
    
    public RangeInt getRange(final int lllllllllllllIlIIlIlIlIlllIlIIlI) {
        return this.ranges[lllllllllllllIlIIlIlIlIlllIlIIlI];
    }
    
    public RangeListInt() {
        this.ranges = new RangeInt[0];
    }
    
    public void addRange(final RangeInt lllllllllllllIlIIlIlIlIllllIIlll) {
        this.ranges = (RangeInt[])Config.addObjectToArray(this.ranges, lllllllllllllIlIIlIlIlIllllIIlll);
    }
}
