package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.io.*;
import java.util.*;

final class TagStringWriter implements AutoCloseable
{
    private /* synthetic */ int level;
    private /* synthetic */ boolean legacy;
    private final /* synthetic */ String indent;
    private final /* synthetic */ Appendable out;
    private /* synthetic */ boolean needsSeparator;
    
    @Override
    public void close() throws IOException {
        if (this.level != 0) {
            throw new IllegalStateException("Document finished with unbalanced start and end objects");
        }
        if (this.out instanceof Writer) {
            ((Writer)this.out).flush();
        }
    }
    
    public TagStringWriter beginList() throws IOException {
        this.printAndResetSeparator(false);
        ++this.level;
        this.out.append('[');
        return this;
    }
    
    public TagStringWriter legacy(final boolean lllllllllllllIIlllIIIlIIIlIIlIIl) {
        this.legacy = lllllllllllllIIlllIIIlIIIlIIlIIl;
        return this;
    }
    
    private void printAndResetSeparator(final boolean lllllllllllllIIlllIIIIlllIIlllII) throws IOException {
        if (this.needsSeparator) {
            this.out.append(',');
            if (lllllllllllllIIlllIIIIlllIIlllII && this.prettyPrinting()) {
                this.out.append(' ');
            }
            this.needsSeparator = false;
        }
    }
    
    private TagStringWriter writeByteArray(final ByteArrayBinaryTag lllllllllllllIIlllIIIlIIIIIlIllI) throws IOException {
        if (this.legacy) {
            throw new IOException("Legacy Mojangson only supports integer arrays!");
        }
        this.beginArray('b');
        final char lllllllllllllIIlllIIIlIIIIIlIIIl = Character.toUpperCase('b');
        final byte[] lllllllllllllIIlllIIIlIIIIIlIIII = ByteArrayBinaryTagImpl.value(lllllllllllllIIlllIIIlIIIIIlIllI);
        for (int lllllllllllllIIlllIIIlIIIIIlIlIl = 0, lllllllllllllIIlllIIIlIIIIIlIlII = lllllllllllllIIlllIIIlIIIIIlIIII.length; lllllllllllllIIlllIIIlIIIIIlIlIl < lllllllllllllIIlllIIIlIIIIIlIlII; ++lllllllllllllIIlllIIIlIIIIIlIlIl) {
            this.printAndResetSeparator(true);
            this.value(Byte.toString(lllllllllllllIIlllIIIlIIIIIlIIII[lllllllllllllIIlllIIIlIIIIIlIlIl]), lllllllllllllIIlllIIIlIIIIIlIIIl);
        }
        this.endArray();
        return this;
    }
    
    private TagStringWriter endArray() throws IOException {
        return this.endList(false);
    }
    
    public TagStringWriter endCompound() throws IOException {
        --this.level;
        this.newlineIndent();
        this.out.append('}');
        this.needsSeparator = true;
        return this;
    }
    
    private void newlineIndent() throws IOException {
        if (this.prettyPrinting()) {
            this.out.append(Tokens.NEWLINE);
            for (int lllllllllllllIIlllIIIIlllIIIllIl = 0; lllllllllllllIIlllIIIIlllIIIllIl < this.level; ++lllllllllllllIIlllIIIIlllIIIllIl) {
                this.out.append(this.indent);
            }
        }
    }
    
    public TagStringWriter beginCompound() throws IOException {
        this.printAndResetSeparator(false);
        ++this.level;
        this.out.append('{');
        return this;
    }
    
    private TagStringWriter writeCompound(final CompoundBinaryTag lllllllllllllIIlllIIIlIIIIllIllI) throws IOException {
        this.beginCompound();
        for (final Map.Entry<String, ? extends BinaryTag> lllllllllllllIIlllIIIlIIIIllIlIl : lllllllllllllIIlllIIIlIIIIllIllI) {
            this.key(lllllllllllllIIlllIIIlIIIIllIlIl.getKey());
            this.writeTag((BinaryTag)lllllllllllllIIlllIIIlIIIIllIlIl.getValue());
        }
        this.endCompound();
        return this;
    }
    
    private Appendable appendSeparator(final char lllllllllllllIIlllIIIIlllIIIIlll) throws IOException {
        this.out.append(lllllllllllllIIlllIIIIlllIIIIlll);
        if (this.prettyPrinting()) {
            this.out.append(' ');
        }
        return this.out;
    }
    
    private static String escape(final String lllllllllllllIIlllIIIIlllIlIlIlI, final char lllllllllllllIIlllIIIIlllIlIlIIl) {
        final StringBuilder lllllllllllllIIlllIIIIlllIlIIlII = new StringBuilder(lllllllllllllIIlllIIIIlllIlIlIlI.length());
        for (int lllllllllllllIIlllIIIIlllIlIIlll = 0; lllllllllllllIIlllIIIIlllIlIIlll < lllllllllllllIIlllIIIIlllIlIlIlI.length(); ++lllllllllllllIIlllIIIIlllIlIIlll) {
            final char lllllllllllllIIlllIIIIlllIlIlIII = lllllllllllllIIlllIIIIlllIlIlIlI.charAt(lllllllllllllIIlllIIIIlllIlIIlll);
            if (lllllllllllllIIlllIIIIlllIlIlIII == lllllllllllllIIlllIIIIlllIlIlIIl || lllllllllllllIIlllIIIIlllIlIlIII == '\\') {
                lllllllllllllIIlllIIIIlllIlIIlII.append('\\');
            }
            lllllllllllllIIlllIIIIlllIlIIlII.append(lllllllllllllIIlllIIIIlllIlIlIII);
        }
        return String.valueOf(lllllllllllllIIlllIIIIlllIlIIlII);
    }
    
    private TagStringWriter writeList(final ListBinaryTag lllllllllllllIIlllIIIlIIIIlIlIII) throws IOException {
        this.beginList();
        int lllllllllllllIIlllIIIlIIIIlIIlII = 0;
        final boolean lllllllllllllIIlllIIIlIIIIlIIIll = this.prettyPrinting() && this.breakListElement(lllllllllllllIIlllIIIlIIIIlIlIII.elementType());
        for (final BinaryTag lllllllllllllIIlllIIIlIIIIlIIlll : lllllllllllllIIlllIIIlIIIIlIlIII) {
            this.printAndResetSeparator(!lllllllllllllIIlllIIIlIIIIlIIIll);
            if (lllllllllllllIIlllIIIlIIIIlIIIll) {
                this.newlineIndent();
            }
            if (this.legacy) {
                this.out.append(String.valueOf(lllllllllllllIIlllIIIlIIIIlIIlII++));
                this.appendSeparator(':');
            }
            this.writeTag(lllllllllllllIIlllIIIlIIIIlIIlll);
        }
        this.endList(lllllllllllllIIlllIIIlIIIIlIIIll);
        return this;
    }
    
    private TagStringWriter writeLongArray(final LongArrayBinaryTag lllllllllllllIIlllIIIIllllllIlII) throws IOException {
        if (this.legacy) {
            throw new IOException("Legacy Mojangson only supports integer arrays!");
        }
        this.beginArray('l');
        final long[] lllllllllllllIIlllIIIIlllllIllll = LongArrayBinaryTagImpl.value(lllllllllllllIIlllIIIIllllllIlII);
        for (int lllllllllllllIIlllIIIIllllllIIll = 0, lllllllllllllIIlllIIIIllllllIIlI = lllllllllllllIIlllIIIIlllllIllll.length; lllllllllllllIIlllIIIIllllllIIll < lllllllllllllIIlllIIIIllllllIIlI; ++lllllllllllllIIlllIIIIllllllIIll) {
            this.printAndResetSeparator(true);
            this.value(Long.toString(lllllllllllllIIlllIIIIlllllIllll[lllllllllllllIIlllIIIIllllllIIll]), 'l');
        }
        this.endArray();
        return this;
    }
    
    TagStringWriter(final Appendable lllllllllllllIIlllIIIlIIIlIlIIll, final String lllllllllllllIIlllIIIlIIIlIlIIlI) {
        this.out = lllllllllllllIIlllIIIlIIIlIlIIll;
        this.indent = lllllllllllllIIlllIIIlIIIlIlIIlI;
    }
    
    private TagStringWriter beginArray(final char lllllllllllllIIlllIIIIllllIIIlIl) throws IOException {
        this.beginList().out.append(Character.toUpperCase(lllllllllllllIIlllIIIIllllIIIlIl)).append(';');
        if (this.prettyPrinting()) {
            this.out.append(' ');
        }
        return this;
    }
    
    private TagStringWriter writeIntArray(final IntArrayBinaryTag lllllllllllllIIlllIIIlIIIIIIIlII) throws IOException {
        if (this.legacy) {
            this.beginList();
        }
        else {
            this.beginArray('i');
        }
        final int[] lllllllllllllIIlllIIIIllllllllll = IntArrayBinaryTagImpl.value(lllllllllllllIIlllIIIlIIIIIIIlII);
        for (int lllllllllllllIIlllIIIlIIIIIIIIll = 0, lllllllllllllIIlllIIIlIIIIIIIIlI = lllllllllllllIIlllIIIIllllllllll.length; lllllllllllllIIlllIIIlIIIIIIIIll < lllllllllllllIIlllIIIlIIIIIIIIlI; ++lllllllllllllIIlllIIIlIIIIIIIIll) {
            this.printAndResetSeparator(true);
            this.value(Integer.toString(lllllllllllllIIlllIIIIllllllllll[lllllllllllllIIlllIIIlIIIIIIIIll]), 'i');
        }
        this.endArray();
        return this;
    }
    
    public TagStringWriter writeTag(final BinaryTag lllllllllllllIIlllIIIlIIIlIIIIIl) throws IOException {
        final BinaryTagType<?> lllllllllllllIIlllIIIlIIIIlllllI = lllllllllllllIIlllIIIlIIIlIIIIIl.type();
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.COMPOUND) {
            return this.writeCompound((CompoundBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl);
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.LIST) {
            return this.writeList((ListBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl);
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.BYTE_ARRAY) {
            return this.writeByteArray((ByteArrayBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl);
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.INT_ARRAY) {
            return this.writeIntArray((IntArrayBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl);
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.LONG_ARRAY) {
            return this.writeLongArray((LongArrayBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl);
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.STRING) {
            return this.value(((StringBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl).value(), '\0');
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.BYTE) {
            return this.value(Byte.toString(((ByteBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl).value()), 'b');
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.SHORT) {
            return this.value(Short.toString(((ShortBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl).value()), 's');
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.INT) {
            return this.value(Integer.toString(((IntBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl).value()), 'i');
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.LONG) {
            return this.value(Long.toString(((LongBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl).value()), Character.toUpperCase('l'));
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.FLOAT) {
            return this.value(Float.toString(((FloatBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl).value()), 'f');
        }
        if (lllllllllllllIIlllIIIlIIIIlllllI == BinaryTagTypes.DOUBLE) {
            return this.value(Double.toString(((DoubleBinaryTag)lllllllllllllIIlllIIIlIIIlIIIIIl).value()), 'd');
        }
        throw new IOException(String.valueOf(new StringBuilder().append("Unknown tag type: ").append(lllllllllllllIIlllIIIlIIIIlllllI)));
    }
    
    private boolean breakListElement(final BinaryTagType<?> lllllllllllllIIlllIIIIlllIIlIllI) {
        return lllllllllllllIIlllIIIIlllIIlIllI == BinaryTagTypes.COMPOUND || lllllllllllllIIlllIIIIlllIIlIllI == BinaryTagTypes.LIST || lllllllllllllIIlllIIIIlllIIlIllI == BinaryTagTypes.BYTE_ARRAY || lllllllllllllIIlllIIIIlllIIlIllI == BinaryTagTypes.INT_ARRAY || lllllllllllllIIlllIIIIlllIIlIllI == BinaryTagTypes.LONG_ARRAY;
    }
    
    public TagStringWriter endList(final boolean lllllllllllllIIlllIIIIllllIIllII) throws IOException {
        --this.level;
        if (lllllllllllllIIlllIIIIllllIIllII) {
            this.newlineIndent();
        }
        this.out.append(']');
        this.needsSeparator = true;
        return this;
    }
    
    private boolean prettyPrinting() {
        return this.indent.length() > 0;
    }
    
    public TagStringWriter key(final String lllllllllllllIIlllIIIIlllllIIIIl) throws IOException {
        this.printAndResetSeparator(false);
        this.newlineIndent();
        this.writeMaybeQuoted(lllllllllllllIIlllIIIIlllllIIIIl, false);
        this.appendSeparator(':');
        return this;
    }
    
    public TagStringWriter value(final String lllllllllllllIIlllIIIIllllIllIII, final char lllllllllllllIIlllIIIIllllIllIIl) throws IOException {
        if (lllllllllllllIIlllIIIIllllIllIIl == '\0') {
            this.writeMaybeQuoted(lllllllllllllIIlllIIIIllllIllIII, true);
        }
        else {
            this.out.append(lllllllllllllIIlllIIIIllllIllIII);
            if (lllllllllllllIIlllIIIIllllIllIIl != 'i') {
                this.out.append(lllllllllllllIIlllIIIIllllIllIIl);
            }
        }
        this.needsSeparator = true;
        return this;
    }
    
    private void writeMaybeQuoted(final String lllllllllllllIIlllIIIIlllIlllIII, final boolean lllllllllllllIIlllIIIIlllIlllIIl) throws IOException {
        if (!lllllllllllllIIlllIIIIlllIlllIIl) {
            for (int lllllllllllllIIlllIIIIlllIllIlll = 0; lllllllllllllIIlllIIIIlllIllIlll < lllllllllllllIIlllIIIIlllIlllIII.length(); ++lllllllllllllIIlllIIIIlllIllIlll) {
                if (!Tokens.id(lllllllllllllIIlllIIIIlllIlllIII.charAt(lllllllllllllIIlllIIIIlllIllIlll))) {
                    lllllllllllllIIlllIIIIlllIlllIIl = true;
                    break;
                }
            }
        }
        if (lllllllllllllIIlllIIIIlllIlllIIl) {
            this.out.append('\"');
            this.out.append(escape(lllllllllllllIIlllIIIIlllIlllIII, '\"'));
            this.out.append('\"');
        }
        else {
            this.out.append(lllllllllllllIIlllIIIIlllIlllIII);
        }
    }
}
