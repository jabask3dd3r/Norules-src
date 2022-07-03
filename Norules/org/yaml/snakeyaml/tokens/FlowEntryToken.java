package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class FlowEntryToken extends Token
{
    public FlowEntryToken(final Mark lllllllllllllIIlIlllIlIlIIIllIll, final Mark lllllllllllllIIlIlllIlIlIIIlllIl) {
        super(lllllllllllllIIlIlllIlIlIIIllIll, lllllllllllllIIlIlllIlIlIIIlllIl);
    }
    
    @Override
    public ID getTokenId() {
        return ID.FlowEntry;
    }
}
