package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class FlowMappingEndToken extends Token
{
    public FlowMappingEndToken(final Mark lllllllllllllIlIlIllIllIlllllIlI, final Mark lllllllllllllIlIlIllIllIlllllIIl) {
        super(lllllllllllllIlIlIllIllIlllllIlI, lllllllllllllIlIlIllIllIlllllIIl);
    }
    
    @Override
    public ID getTokenId() {
        return ID.FlowMappingEnd;
    }
}
