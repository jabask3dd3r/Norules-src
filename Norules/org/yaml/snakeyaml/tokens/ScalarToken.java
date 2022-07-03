package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.*;
import org.yaml.snakeyaml.error.*;

public final class ScalarToken extends Token
{
    private final /* synthetic */ DumperOptions.ScalarStyle style;
    private final /* synthetic */ boolean plain;
    private final /* synthetic */ String value;
    
    public String getValue() {
        return this.value;
    }
    
    public ScalarToken(final String llllllllllllllIlIIllIlIIlIlIIIlI, final Mark llllllllllllllIlIIllIlIIlIlIIllI, final Mark llllllllllllllIlIIllIlIIlIlIIlIl, final boolean llllllllllllllIlIIllIlIIlIIlllll) {
        this(llllllllllllllIlIIllIlIIlIlIIIlI, llllllllllllllIlIIllIlIIlIIlllll, llllllllllllllIlIIllIlIIlIlIIllI, llllllllllllllIlIIllIlIIlIlIIlIl, DumperOptions.ScalarStyle.PLAIN);
    }
    
    public DumperOptions.ScalarStyle getStyle() {
        return this.style;
    }
    
    @Override
    public ID getTokenId() {
        return ID.Scalar;
    }
    
    public boolean getPlain() {
        return this.plain;
    }
    
    public ScalarToken(final String llllllllllllllIlIIllIlIIlIIlIIIl, final boolean llllllllllllllIlIIllIlIIlIIlIIII, final Mark llllllllllllllIlIIllIlIIlIIlIlIl, final Mark llllllllllllllIlIIllIlIIlIIlIlII, final DumperOptions.ScalarStyle llllllllllllllIlIIllIlIIlIIlIIll) {
        super(llllllllllllllIlIIllIlIIlIIlIlIl, llllllllllllllIlIIllIlIIlIIlIlII);
        this.value = llllllllllllllIlIIllIlIIlIIlIIIl;
        this.plain = llllllllllllllIlIIllIlIIlIIlIIII;
        if (llllllllllllllIlIIllIlIIlIIlIIll == null) {
            throw new NullPointerException("Style must be provided.");
        }
        this.style = llllllllllllllIlIIllIlIIlIIlIIll;
    }
}
