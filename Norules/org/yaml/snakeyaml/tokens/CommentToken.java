package org.yaml.snakeyaml.tokens;

import org.yaml.snakeyaml.error.*;

public class CommentToken extends Token
{
    @Override
    public ID getTokenId() {
        return ID.Comment;
    }
    
    public CommentToken(final Mark lllllllllllllIllIlIlIIlIIllllIlI, final Mark lllllllllllllIllIlIlIIlIIllllIIl) {
        super(lllllllllllllIllIlIlIIlIIllllIlI, lllllllllllllIllIlIlIIlIIllllIIl);
    }
}
