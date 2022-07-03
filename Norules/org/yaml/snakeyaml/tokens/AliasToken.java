package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class AliasToken extends Token
{
    private final /* synthetic */ String value;
    
    public AliasToken(final String lllllllllllllllllIlIlIlIIIllIlIl, final Mark lllllllllllllllllIlIlIlIIIllIlII, final Mark lllllllllllllllllIlIlIlIIIllIIll) {
        super(lllllllllllllllllIlIlIlIIIllIlII, lllllllllllllllllIlIlIlIIIllIIll);
        this.value = lllllllllllllllllIlIlIlIIIllIlIl;
    }
    
    public String getValue() {
        return this.value;
    }
    
    @Override
    public ID getTokenId() {
        return ID.Alias;
    }
}
