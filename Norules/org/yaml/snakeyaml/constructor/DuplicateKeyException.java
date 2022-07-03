package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.*;

public class DuplicateKeyException extends ConstructorException
{
    protected DuplicateKeyException(final Mark lllllllllllllIlllllllllIIlIIIlII, final Object lllllllllllllIlllllllllIIlIIIIll, final Mark lllllllllllllIlllllllllIIlIIIIlI) {
        super("while constructing a mapping", lllllllllllllIlllllllllIIlIIIlII, String.valueOf(new StringBuilder().append("found duplicate key ").append(String.valueOf(lllllllllllllIlllllllllIIlIIIIll))), lllllllllllllIlllllllllIIlIIIIlI);
    }
}
