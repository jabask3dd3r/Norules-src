package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class FlowMappingStartToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.FlowMappingStart;
    }
    
    public FlowMappingStartToken(final Mark lllllllllllllIlIlIIlIIlllllIIlII, final Mark lllllllllllllIlIlIIlIIlllllIIIll) {
        super(lllllllllllllIlIlIIlIIlllllIIlII, lllllllllllllIlIlIIlIIlllllIIIll);
    }
}
