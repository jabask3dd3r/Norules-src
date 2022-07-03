package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import org.jetbrains.annotations.*;
import java.io.*;
import java.util.*;

public final class TagStringIO
{
    private final /* synthetic */ boolean emitLegacy;
    private static final /* synthetic */ TagStringIO INSTANCE;
    private final /* synthetic */ String indent;
    private final /* synthetic */ boolean acceptLegacy;
    
    public CompoundBinaryTag asCompound(final String lllllllllllllllIIllllIllIlIlIlIl) throws IOException {
        try {
            final CharBuffer lllllllllllllllIIllllIllIlIlIlII = new CharBuffer(lllllllllllllllIIllllIllIlIlIlIl);
            final TagStringReader lllllllllllllllIIllllIllIlIlIIll = new TagStringReader(lllllllllllllllIIllllIllIlIlIlII);
            lllllllllllllllIIllllIllIlIlIIll.legacy(this.acceptLegacy);
            final CompoundBinaryTag lllllllllllllllIIllllIllIlIlIIlI = lllllllllllllllIIllllIllIlIlIIll.compound();
            if (lllllllllllllllIIllllIllIlIlIlII.skipWhitespace().hasMore()) {
                throw new IOException("Document had trailing content after first CompoundTag");
            }
            return lllllllllllllllIIllllIllIlIlIIlI;
        }
        catch (StringTagParseException lllllllllllllllIIllllIllIlIlIIIl) {
            throw new IOException(lllllllllllllllIIllllIllIlIlIIIl);
        }
    }
    
    @NotNull
    public static Builder builder() {
        return new Builder();
    }
    
    public String asString(final CompoundBinaryTag lllllllllllllllIIllllIllIlIIIIll) throws IOException {
        final StringBuilder lllllllllllllllIIllllIllIIllllll = new StringBuilder();
        final TagStringWriter lllllllllllllllIIllllIllIlIIIIlI = new TagStringWriter(lllllllllllllllIIllllIllIIllllll, this.indent);
        try {
            lllllllllllllllIIllllIllIlIIIIlI.legacy(this.emitLegacy);
            lllllllllllllllIIllllIllIlIIIIlI.writeTag(lllllllllllllllIIllllIllIlIIIIll);
            lllllllllllllllIIllllIllIlIIIIlI.close();
        }
        catch (Throwable lllllllllllllllIIllllIllIIlllIlI) {
            try {
                lllllllllllllllIIllllIllIlIIIIlI.close();
            }
            catch (Throwable lllllllllllllllIIllllIllIIlllIIl) {
                ((Throwable)lllllllllllllllIIllllIllIIlllIlI).addSuppressed((Throwable)lllllllllllllllIIllllIllIIlllIIl);
            }
            throw lllllllllllllllIIllllIllIIlllIlI;
        }
        return String.valueOf(lllllllllllllllIIllllIllIIllllll);
    }
    
    public void toWriter(final CompoundBinaryTag lllllllllllllllIIllllIllIIllIIlI, final Writer lllllllllllllllIIllllIllIIllIIIl) throws IOException {
        final TagStringWriter lllllllllllllllIIllllIllIIllIIII = new TagStringWriter(lllllllllllllllIIllllIllIIllIIIl, this.indent);
        try {
            lllllllllllllllIIllllIllIIllIIII.legacy(this.emitLegacy);
            lllllllllllllllIIllllIllIIllIIII.writeTag(lllllllllllllllIIllllIllIIllIIlI);
            lllllllllllllllIIllllIllIIllIIII.close();
        }
        catch (Throwable lllllllllllllllIIllllIllIIlIlIII) {
            try {
                lllllllllllllllIIllllIllIIllIIII.close();
            }
            catch (Throwable lllllllllllllllIIllllIllIIlIIlll) {
                ((Throwable)lllllllllllllllIIllllIllIIlIlIII).addSuppressed((Throwable)lllllllllllllllIIllllIllIIlIIlll);
            }
            throw lllllllllllllllIIllllIllIIlIlIII;
        }
    }
    
    static {
        INSTANCE = new TagStringIO(new Builder());
    }
    
    private TagStringIO(@NotNull final Builder lllllllllllllllIIllllIllIlIlllll) {
        this.acceptLegacy = lllllllllllllllIIllllIllIlIlllll.acceptLegacy;
        this.emitLegacy = lllllllllllllllIIllllIllIlIlllll.emitLegacy;
        this.indent = lllllllllllllllIIllllIllIlIlllll.indent;
    }
    
    @NotNull
    public static TagStringIO get() {
        return TagStringIO.INSTANCE;
    }
    
    public static class Builder
    {
        private /* synthetic */ String indent;
        private /* synthetic */ boolean emitLegacy;
        private /* synthetic */ boolean acceptLegacy;
        
        @NotNull
        public TagStringIO build() {
            return new TagStringIO(this, null);
        }
        
        Builder() {
            this.acceptLegacy = true;
            this.emitLegacy = false;
            this.indent = "";
        }
        
        @NotNull
        public Builder acceptLegacy(final boolean llllllllllllllllIIIlIllIIllIllII) {
            this.acceptLegacy = llllllllllllllllIIIlIllIIllIllII;
            return this;
        }
        
        @NotNull
        public Builder indent(final int llllllllllllllllIIIlIllIIlllllll) {
            if (llllllllllllllllIIIlIllIIlllllll == 0) {
                this.indent = "";
            }
            else if ((this.indent.length() > 0 && this.indent.charAt(0) != ' ') || llllllllllllllllIIIlIllIIlllllll != this.indent.length()) {
                final char[] llllllllllllllllIIIlIllIIllllllI = new char[llllllllllllllllIIIlIllIIlllllll];
                Arrays.fill(llllllllllllllllIIIlIllIIllllllI, ' ');
                this.indent = String.copyValueOf(llllllllllllllllIIIlIllIIllllllI);
            }
            return this;
        }
        
        @NotNull
        public Builder emitLegacy(final boolean llllllllllllllllIIIlIllIIllIIlIl) {
            this.emitLegacy = llllllllllllllllIIIlIllIIllIIlIl;
            return this;
        }
        
        @NotNull
        public Builder indentTab(final int llllllllllllllllIIIlIllIIlllIlIl) {
            if (llllllllllllllllIIIlIllIIlllIlIl == 0) {
                this.indent = "";
            }
            else if ((this.indent.length() > 0 && this.indent.charAt(0) != '\t') || llllllllllllllllIIIlIllIIlllIlIl != this.indent.length()) {
                final char[] llllllllllllllllIIIlIllIIlllIlII = new char[llllllllllllllllIIIlIllIIlllIlIl];
                Arrays.fill(llllllllllllllllIIIlIllIIlllIlII, '\t');
                this.indent = String.copyValueOf(llllllllllllllllIIIlIllIIlllIlII);
            }
            return this;
        }
    }
}
