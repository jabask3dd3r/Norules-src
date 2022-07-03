package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public final class FlowSequenceStartToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.FlowSequenceStart;
    }
    
    public FlowSequenceStartToken(final Mark llllllllllllIlllllllIIlllIlllIll, final Mark llllllllllllIlllllllIIlllIlllIlI) {
        super(llllllllllllIlllllllIIlllIlllIll, llllllllllllIlllllllIIlllIlllIlI);
    }
}
