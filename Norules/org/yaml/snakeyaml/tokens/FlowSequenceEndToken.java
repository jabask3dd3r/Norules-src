package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class FlowSequenceEndToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.FlowSequenceEnd;
    }
    
    public FlowSequenceEndToken(final Mark lllllllllllllllIIIIllIlIIIlIIlIl, final Mark lllllllllllllllIIIIllIlIIIlIIlII) {
        super(lllllllllllllllIIIIllIlIIIlIIlIl, lllllllllllllllIIIIllIlIIIlIIlII);
    }
}
