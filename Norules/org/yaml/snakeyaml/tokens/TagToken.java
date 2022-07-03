package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class TagToken extends Token
{
    private final /* synthetic */ TagTuple value;
    
    public TagToken(final TagTuple lllllllllllllIIIlllIlIIIllIlIlIl, final Mark lllllllllllllIIIlllIlIIIllIlIIII, final Mark lllllllllllllIIIlllIlIIIllIlIIll) {
        super(lllllllllllllIIIlllIlIIIllIlIIII, lllllllllllllIIIlllIlIIIllIlIIll);
        this.value = lllllllllllllIIIlllIlIIIllIlIlIl;
    }
    
    public TagTuple getValue() {
        return this.value;
    }
    
    @Override
    public ID getTokenId() {
        return ID.Tag;
    }
}
