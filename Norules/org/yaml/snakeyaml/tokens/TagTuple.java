package org.yaml.snakeyaml.tokens;

public final class TagTuple
{
    private final /* synthetic */ String suffix;
    private final /* synthetic */ String handle;
    
    public String getSuffix() {
        return this.suffix;
    }
    
    public String getHandle() {
        return this.handle;
    }
    
    public TagTuple(final String lllllllllllllIIlIIIIIIlIIIllllII, final String lllllllllllllIIlIIIIIIlIIIlllllI) {
        if (lllllllllllllIIlIIIIIIlIIIlllllI == null) {
            throw new NullPointerException("Suffix must be provided.");
        }
        this.handle = lllllllllllllIIlIIIIIIlIIIllllII;
        this.suffix = lllllllllllllIIlIIIIIIlIIIlllllI;
    }
}
