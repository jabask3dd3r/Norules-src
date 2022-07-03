package com.viaversion.viaversion.api.minecraft.nbt;

import java.io.*;

class StringTagParseException extends IOException
{
    private final /* synthetic */ CharSequence buffer;
    private final /* synthetic */ int position;
    
    @Override
    public String getMessage() {
        return String.valueOf(new StringBuilder().append(super.getMessage()).append("(at position ").append(this.position).append(")"));
    }
    
    public StringTagParseException(final String lllIllllllIII, final CharSequence lllIlllllIlll, final int lllIllllllIlI) {
        super(lllIllllllIII);
        this.buffer = lllIlllllIlll;
        this.position = lllIllllllIlI;
    }
}
