package org.yaml.snakeyaml.constructor;

import org.yaml.snakeyaml.error.*;

public class ConstructorException extends MarkedYAMLException
{
    protected ConstructorException(final String lllllllllllllllIIIlIllllIIIIIlll, final Mark lllllllllllllllIIIlIllllIIIIIllI, final String lllllllllllllllIIIlIllllIIIIIlIl, final Mark lllllllllllllllIIIlIllllIIIIIlII, final Throwable lllllllllllllllIIIlIllllIIIIlIIl) {
        super(lllllllllllllllIIIlIllllIIIIIlll, lllllllllllllllIIIlIllllIIIIIllI, lllllllllllllllIIIlIllllIIIIIlIl, lllllllllllllllIIIlIllllIIIIIlII, lllllllllllllllIIIlIllllIIIIlIIl);
    }
    
    protected ConstructorException(final String lllllllllllllllIIIlIlllIllllIlll, final Mark lllllllllllllllIIIlIlllIllllIllI, final String lllllllllllllllIIIlIlllIllllIlIl, final Mark lllllllllllllllIIIlIlllIllllIlII) {
        this(lllllllllllllllIIIlIlllIllllIlll, lllllllllllllllIIIlIlllIllllIllI, lllllllllllllllIIIlIlllIllllIlIl, lllllllllllllllIIIlIlllIllllIlII, (Throwable)null);
    }
}
