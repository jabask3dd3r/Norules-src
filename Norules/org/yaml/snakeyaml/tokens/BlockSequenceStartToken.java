package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class BlockSequenceStartToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.BlockSequenceStart;
    }
    
    public BlockSequenceStartToken(final Mark lllllllllllllIlIIIllllIlIllllIIl, final Mark lllllllllllllIlIIIllllIlIlllllIl) {
        super(lllllllllllllIlIIIllllIlIllllIIl, lllllllllllllIlIIIllllIlIlllllIl);
    }
}
