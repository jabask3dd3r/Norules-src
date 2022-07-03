package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class BlockMappingStartToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.BlockMappingStart;
    }
    
    public BlockMappingStartToken(final Mark llllllllllllllIIIIIIIlllIIIlIllI, final Mark llllllllllllllIIIIIIIlllIIIllIII) {
        super(llllllllllllllIIIIIIIlllIIIlIllI, llllllllllllllIIIIIIIlllIIIllIII);
    }
}
