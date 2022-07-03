package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class AnchorToken extends Token
{
    private final /* synthetic */ String value;
    
    public AnchorToken(final String lllllllllllllllllllllllIIlllIIII, final Mark lllllllllllllllllllllllIIllIllll, final Mark lllllllllllllllllllllllIIlllIIlI) {
        super(lllllllllllllllllllllllIIllIllll, lllllllllllllllllllllllIIlllIIlI);
        this.value = lllllllllllllllllllllllIIlllIIII;
    }
    
    @Override
    public ID getTokenId() {
        return ID.Anchor;
    }
    
    public String getValue() {
        return this.value;
    }
}
