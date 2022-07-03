package optifine;

public class GlVersion
{
    private /* synthetic */ int release;
    private /* synthetic */ String suffix;
    private /* synthetic */ int minor;
    private /* synthetic */ int major;
    
    public GlVersion(final int lllllllllllllIllIllllIIIlIIIIlIl, final int lllllllllllllIllIllllIIIlIIIIlII, final int lllllllllllllIllIllllIIIlIIIIIll, final String lllllllllllllIllIllllIIIlIIIIIlI) {
        this.major = lllllllllllllIllIllllIIIlIIIIlIl;
        this.minor = lllllllllllllIllIllllIIIlIIIIlII;
        this.release = lllllllllllllIllIllllIIIlIIIIIll;
        this.suffix = lllllllllllllIllIllllIIIlIIIIIlI;
    }
    
    public int toInt() {
        if (this.minor > 9) {
            return this.major * 100 + this.minor;
        }
        return (this.release > 9) ? (this.major * 100 + this.minor * 10 + 9) : (this.major * 100 + this.minor * 10 + this.release);
    }
    
    public GlVersion(final int lllllllllllllIllIllllIIIlIIllllI, final int lllllllllllllIllIllllIIIlIIlllIl) {
        this(lllllllllllllIllIllllIIIlIIllllI, lllllllllllllIllIllllIIIlIIlllIl, 0);
    }
    
    @Override
    public String toString() {
        return (this.suffix == null) ? String.valueOf(new StringBuilder().append(this.major).append(".").append(this.minor).append(".").append(this.release)) : String.valueOf(new StringBuilder().append(this.major).append(".").append(this.minor).append(".").append(this.release).append(this.suffix));
    }
    
    public int getMinor() {
        return this.minor;
    }
    
    public GlVersion(final int lllllllllllllIllIllllIIIlIIlIIll, final int lllllllllllllIllIllllIIIlIIlIllI, final int lllllllllllllIllIllllIIIlIIlIlIl) {
        this(lllllllllllllIllIllllIIIlIIlIIll, lllllllllllllIllIllllIIIlIIlIllI, lllllllllllllIllIllllIIIlIIlIlIl, null);
    }
    
    public int getRelease() {
        return this.release;
    }
    
    public int getMajor() {
        return this.major;
    }
}
