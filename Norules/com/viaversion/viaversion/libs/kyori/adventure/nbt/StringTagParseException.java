package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.io.*;

class StringTagParseException extends IOException
{
    private final /* synthetic */ int position;
    private final /* synthetic */ CharSequence buffer;
    
    @Override
    public String getMessage() {
        return String.valueOf(new StringBuilder().append(super.getMessage()).append("(at position ").append(this.position).append(")"));
    }
    
    StringTagParseException(final String lllllllllllllIIllllIlllIIIIIllll, final CharSequence lllllllllllllIIllllIlllIIIIIlllI, final int lllllllllllllIIllllIlllIIIIIllIl) {
        super(lllllllllllllIIllllIlllIIIIIllll);
        this.buffer = lllllllllllllIIllllIlllIIIIIlllI;
        this.position = lllllllllllllIIllllIlllIIIIIllIl;
    }
}
