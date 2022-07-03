package org.yaml.snakeyaml.scanner;

import org.yaml.snakeyaml.error.*;

public class ScannerException extends MarkedYAMLException
{
    public ScannerException(final String lllllllllllllIIIlIllIlIllllIIlII, final Mark lllllllllllllIIIlIllIlIllllIIIll, final String lllllllllllllIIIlIllIlIllllIIIlI, final Mark lllllllllllllIIIlIllIlIllllIIIIl, final String lllllllllllllIIIlIllIlIllllIIllI) {
        super(lllllllllllllIIIlIllIlIllllIIlII, lllllllllllllIIIlIllIlIllllIIIll, lllllllllllllIIIlIllIlIllllIIIlI, lllllllllllllIIIlIllIlIllllIIIIl, lllllllllllllIIIlIllIlIllllIIllI);
    }
    
    public ScannerException(final String lllllllllllllIIIlIllIlIlllIlIlII, final Mark lllllllllllllIIIlIllIlIlllIllIII, final String lllllllllllllIIIlIllIlIlllIlIIlI, final Mark lllllllllllllIIIlIllIlIlllIlIllI) {
        this(lllllllllllllIIIlIllIlIlllIlIlII, lllllllllllllIIIlIllIlIlllIllIII, lllllllllllllIIIlIllIlIlllIlIIlI, lllllllllllllIIIlIllIlIlllIlIllI, (String)null);
    }
}
