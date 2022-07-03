package org.yaml.snakeyaml.events;

public class ImplicitTuple
{
    private final /* synthetic */ boolean plain;
    private final /* synthetic */ boolean nonPlain;
    
    public boolean bothFalse() {
        return !this.plain && !this.nonPlain;
    }
    
    public boolean canOmitTagInPlainScalar() {
        return this.plain;
    }
    
    public ImplicitTuple(final boolean lllllllllllllIllIIlllIIIIllIlIll, final boolean lllllllllllllIllIIlllIIIIllIllIl) {
        this.plain = lllllllllllllIllIIlllIIIIllIlIll;
        this.nonPlain = lllllllllllllIllIIlllIIIIllIllIl;
    }
    
    public boolean canOmitTagInNonPlainScalar() {
        return this.nonPlain;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("implicit=[").append(this.plain).append(", ").append(this.nonPlain).append("]"));
    }
}
