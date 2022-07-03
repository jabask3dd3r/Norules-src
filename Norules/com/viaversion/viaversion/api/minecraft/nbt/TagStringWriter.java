package com.viaversion.viaversion.api.minecraft.nbt;

import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import java.io.*;

final class TagStringWriter implements AutoCloseable
{
    private /* synthetic */ int level;
    private final /* synthetic */ Appendable out;
    private /* synthetic */ boolean needsSeparator;
    
    private TagStringWriter writeCompound(final CompoundTag lllllllllllllllllIlIIIllIIIIllIl) throws IOException {
        this.beginCompound();
        for (final Map.Entry<String, Tag> lllllllllllllllllIlIIIllIIIlIIIl : lllllllllllllllllIlIIIllIIIIllIl.entrySet()) {
            this.key(lllllllllllllllllIlIIIllIIIlIIIl.getKey());
            this.writeTag(lllllllllllllllllIlIIIllIIIlIIIl.getValue());
        }
        this.endCompound();
        return this;
    }
    
    private void writeMaybeQuoted(final String lllllllllllllllllIlIIIlIlIlIIlIl, boolean lllllllllllllllllIlIIIlIlIlIIlII) throws IOException {
        if (lllllllllllllllllIlIIIlIlIlIIlII == 0) {
            for (int lllllllllllllllllIlIIIlIlIlIlIlI = 0; lllllllllllllllllIlIIIlIlIlIlIlI < lllllllllllllllllIlIIIlIlIlIIlIl.length(); ++lllllllllllllllllIlIIIlIlIlIlIlI) {
                if (!Tokens.id(lllllllllllllllllIlIIIlIlIlIIlIl.charAt(lllllllllllllllllIlIIIlIlIlIlIlI))) {
                    lllllllllllllllllIlIIIlIlIlIIlII = 1;
                    break;
                }
            }
        }
        if (lllllllllllllllllIlIIIlIlIlIIlII != 0) {
            this.out.append('\"');
            this.out.append(escape(lllllllllllllllllIlIIIlIlIlIIlIl, '\"'));
            this.out.append('\"');
        }
        else {
            this.out.append(lllllllllllllllllIlIIIlIlIlIIlIl);
        }
    }
    
    private TagStringWriter writeLongArray(final LongArrayTag lllllllllllllllllIlIIIlIllIlIllI) throws IOException {
        this.beginArray('L');
        final long[] lllllllllllllllllIlIIIlIllIllIII = lllllllllllllllllIlIIIlIllIlIllI.getValue();
        for (int lllllllllllllllllIlIIIlIllIlllII = 0, lllllllllllllllllIlIIIlIllIllIll = lllllllllllllllllIlIIIlIllIllIII.length; lllllllllllllllllIlIIIlIllIlllII < lllllllllllllllllIlIIIlIllIllIll; ++lllllllllllllllllIlIIIlIllIlllII) {
            this.printAndResetSeparator();
            this.value(Long.toString(lllllllllllllllllIlIIIlIllIllIII[lllllllllllllllllIlIIIlIllIlllII]), 'L');
        }
        this.endArray();
        return this;
    }
    
    private TagStringWriter endArray() throws IOException {
        return this.endList();
    }
    
    private static String escape(final String lllllllllllllllllIlIIIlIlIIllIII, final char lllllllllllllllllIlIIIlIlIIllIlI) {
        final StringBuilder lllllllllllllllllIlIIIlIlIIllIIl = new StringBuilder(lllllllllllllllllIlIIIlIlIIllIII.length());
        for (int lllllllllllllllllIlIIIlIlIIlllII = 0; lllllllllllllllllIlIIIlIlIIlllII < lllllllllllllllllIlIIIlIlIIllIII.length(); ++lllllllllllllllllIlIIIlIlIIlllII) {
            final char lllllllllllllllllIlIIIlIlIIlllIl = lllllllllllllllllIlIIIlIlIIllIII.charAt(lllllllllllllllllIlIIIlIlIIlllII);
            if (lllllllllllllllllIlIIIlIlIIlllIl == lllllllllllllllllIlIIIlIlIIllIlI || lllllllllllllllllIlIIIlIlIIlllIl == '\\') {
                lllllllllllllllllIlIIIlIlIIllIIl.append('\\');
            }
            lllllllllllllllllIlIIIlIlIIllIIl.append(lllllllllllllllllIlIIIlIlIIlllIl);
        }
        return String.valueOf(lllllllllllllllllIlIIIlIlIIllIIl);
    }
    
    private void printAndResetSeparator() throws IOException {
        if (this.needsSeparator) {
            this.out.append(',');
            this.needsSeparator = false;
        }
    }
    
    private TagStringWriter writeIntArray(final IntArrayTag lllllllllllllllllIlIIIlIlllIlIII) throws IOException {
        this.beginArray('I');
        final int[] lllllllllllllllllIlIIIlIlllIIlll = lllllllllllllllllIlIIIlIlllIlIII.getValue();
        for (int lllllllllllllllllIlIIIlIlllIlIll = 0, lllllllllllllllllIlIIIlIlllIlIlI = lllllllllllllllllIlIIIlIlllIIlll.length; lllllllllllllllllIlIIIlIlllIlIll < lllllllllllllllllIlIIIlIlllIlIlI; ++lllllllllllllllllIlIIIlIlllIlIll) {
            this.printAndResetSeparator();
            this.value(Integer.toString(lllllllllllllllllIlIIIlIlllIIlll[lllllllllllllllllIlIIIlIlllIlIll]), 'I');
        }
        this.endArray();
        return this;
    }
    
    public TagStringWriter key(final String lllllllllllllllllIlIIIlIllIIlIIl) throws IOException {
        this.printAndResetSeparator();
        this.writeMaybeQuoted(lllllllllllllllllIlIIIlIllIIlIIl, false);
        this.out.append(':');
        return this;
    }
    
    private TagStringWriter writeList(final ListTag lllllllllllllllllIlIIIllIIIIIlII) throws IOException {
        this.beginList();
        for (final Tag lllllllllllllllllIlIIIllIIIIIllI : lllllllllllllllllIlIIIllIIIIIlII) {
            this.printAndResetSeparator();
            this.writeTag(lllllllllllllllllIlIIIllIIIIIllI);
        }
        this.endList();
        return this;
    }
    
    private TagStringWriter beginArray(final char lllllllllllllllllIlIIIlIlIllIIlI) throws IOException {
        this.beginList().out.append(lllllllllllllllllIlIIIlIlIllIIlI).append(';');
        return this;
    }
    
    public TagStringWriter endCompound() throws IOException {
        this.out.append('}');
        --this.level;
        this.needsSeparator = true;
        return this;
    }
    
    public TagStringWriter value(final String lllllllllllllllllIlIIIlIlIllllll, final char lllllllllllllllllIlIIIlIlIlllllI) throws IOException {
        if (lllllllllllllllllIlIIIlIlIlllllI == '\0') {
            this.writeMaybeQuoted(lllllllllllllllllIlIIIlIlIllllll, true);
        }
        else {
            this.out.append(lllllllllllllllllIlIIIlIlIllllll);
            if (lllllllllllllllllIlIIIlIlIlllllI != 'I') {
                this.out.append(lllllllllllllllllIlIIIlIlIlllllI);
            }
        }
        this.needsSeparator = true;
        return this;
    }
    
    private TagStringWriter writeByteArray(final ByteArrayTag lllllllllllllllllIlIIIlIllllIlll) throws IOException {
        this.beginArray('B');
        final byte[] lllllllllllllllllIlIIIlIllllIllI = lllllllllllllllllIlIIIlIllllIlll.getValue();
        for (int lllllllllllllllllIlIIIlIlllllIlI = 0, lllllllllllllllllIlIIIlIlllllIIl = lllllllllllllllllIlIIIlIllllIllI.length; lllllllllllllllllIlIIIlIlllllIlI < lllllllllllllllllIlIIIlIlllllIIl; ++lllllllllllllllllIlIIIlIlllllIlI) {
            this.printAndResetSeparator();
            this.value(Byte.toString(lllllllllllllllllIlIIIlIllllIllI[lllllllllllllllllIlIIIlIlllllIlI]), 'B');
        }
        this.endArray();
        return this;
    }
    
    public TagStringWriter writeTag(final Tag lllllllllllllllllIlIIIllIIIlIllI) throws IOException {
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof CompoundTag) {
            return this.writeCompound((CompoundTag)lllllllllllllllllIlIIIllIIIlIllI);
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof ListTag) {
            return this.writeList((ListTag)lllllllllllllllllIlIIIllIIIlIllI);
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof ByteArrayTag) {
            return this.writeByteArray((ByteArrayTag)lllllllllllllllllIlIIIllIIIlIllI);
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof IntArrayTag) {
            return this.writeIntArray((IntArrayTag)lllllllllllllllllIlIIIllIIIlIllI);
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof LongArrayTag) {
            return this.writeLongArray((LongArrayTag)lllllllllllllllllIlIIIllIIIlIllI);
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof StringTag) {
            return this.value(((StringTag)lllllllllllllllllIlIIIllIIIlIllI).getValue(), '\0');
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof ByteTag) {
            return this.value(Byte.toString(((ByteTag)lllllllllllllllllIlIIIllIIIlIllI).asByte()), 'B');
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof ShortTag) {
            return this.value(Short.toString(((ShortTag)lllllllllllllllllIlIIIllIIIlIllI).asShort()), 'S');
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof IntTag) {
            return this.value(Integer.toString(((IntTag)lllllllllllllllllIlIIIllIIIlIllI).asInt()), 'I');
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof LongTag) {
            return this.value(Long.toString(((LongTag)lllllllllllllllllIlIIIllIIIlIllI).asLong()), 'L');
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof FloatTag) {
            return this.value(Float.toString(((FloatTag)lllllllllllllllllIlIIIllIIIlIllI).asFloat()), 'F');
        }
        if (lllllllllllllllllIlIIIllIIIlIllI instanceof DoubleTag) {
            return this.value(Double.toString(((DoubleTag)lllllllllllllllllIlIIIllIIIlIllI).asDouble()), 'D');
        }
        throw new IOException(String.valueOf(new StringBuilder().append("Unknown tag type: ").append(lllllllllllllllllIlIIIllIIIlIllI.getClass().getSimpleName())));
    }
    
    public TagStringWriter beginList() throws IOException {
        this.printAndResetSeparator();
        ++this.level;
        this.out.append('[');
        return this;
    }
    
    public TagStringWriter beginCompound() throws IOException {
        this.printAndResetSeparator();
        ++this.level;
        this.out.append('{');
        return this;
    }
    
    public TagStringWriter endList() throws IOException {
        this.out.append(']');
        --this.level;
        this.needsSeparator = true;
        return this;
    }
    
    @Override
    public void close() throws IOException {
        if (this.level != 0) {
            throw new IllegalStateException("Document finished with unbalanced start and end objects");
        }
        if (this.out instanceof Writer) {
            ((Writer)this.out).flush();
        }
    }
    
    public TagStringWriter(final Appendable lllllllllllllllllIlIIIllIIIlllII) {
        this.out = lllllllllllllllllIlIIIllIIIlllII;
    }
}
