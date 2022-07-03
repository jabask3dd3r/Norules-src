package com.viaversion.viaversion.api.minecraft.nbt;

import java.util.*;
import java.util.stream.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;

final class TagStringReader
{
    private final /* synthetic */ CharBuffer buffer;
    
    public Tag tag() throws StringTagParseException {
        final char lllllllllllllIIIlIIIllIlIIlllIIl = this.buffer.skipWhitespace().peek();
        switch (lllllllllllllIIIlIIIllIlIIlllIIl) {
            case '{': {
                return this.compound();
            }
            case '[': {
                if (this.buffer.peek(2) == ';') {
                    return this.array(this.buffer.peek(1));
                }
                return this.list();
            }
            case '\"':
            case '\'': {
                this.buffer.advance();
                return new StringTag(unescape(this.buffer.takeUntil(lllllllllllllIIIlIIIllIlIIlllIIl).toString()));
            }
            default: {
                return this.scalar();
            }
        }
    }
    
    private long[] longArray() throws StringTagParseException {
        final List<Long> lllllllllllllIIIlIIIllIlIlllIIII = new ArrayList<Long>();
        while (this.buffer.hasMore()) {
            final CharSequence lllllllllllllIIIlIIIllIlIlllIIll = this.buffer.skipWhitespace().takeUntil('L');
            try {
                lllllllllllllIIIlIIIllIlIlllIIII.add(Long.valueOf(lllllllllllllIIIlIIIllIlIlllIIll.toString()));
            }
            catch (NumberFormatException lllllllllllllIIIlIIIllIlIlllIlll) {
                throw this.buffer.makeError("All elements of a long array must be longs!");
            }
            if (this.separatorOrCompleteWith(']')) {
                final long[] lllllllllllllIIIlIIIllIlIlllIlII = new long[lllllllllllllIIIlIIIllIlIlllIIII.size()];
                for (int lllllllllllllIIIlIIIllIlIlllIllI = 0; lllllllllllllIIIlIIIllIlIlllIllI < lllllllllllllIIIlIIIllIlIlllIIII.size(); ++lllllllllllllIIIlIIIllIlIlllIllI) {
                    lllllllllllllIIIlIIIllIlIlllIlII[lllllllllllllIIIlIIIllIlIlllIllI] = lllllllllllllIIIlIIIllIlIlllIIII.get(lllllllllllllIIIlIIIllIlIlllIllI);
                }
                return lllllllllllllIIIlIIIllIlIlllIlII;
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }
    
    public CompoundTag compound() throws StringTagParseException {
        this.buffer.expect('{');
        final CompoundTag lllllllllllllIIIlIIIllIlllIllIlI = new CompoundTag();
        if (this.buffer.peek() == '}') {
            this.buffer.take();
            return lllllllllllllIIIlIIIllIlllIllIlI;
        }
        while (this.buffer.hasMore()) {
            final String lllllllllllllIIIlIIIllIlllIlllll = this.key();
            final Tag lllllllllllllIIIlIIIllIlllIlllIl = this.tag();
            lllllllllllllIIIlIIIllIlllIllIlI.put(lllllllllllllIIIlIIIllIlllIlllll, lllllllllllllIIIlIIIllIlllIlllIl);
            if (this.separatorOrCompleteWith('}')) {
                return lllllllllllllIIIlIIIllIlllIllIlI;
            }
        }
        throw this.buffer.makeError("Unterminated compound tag!");
    }
    
    public ListTag list() throws StringTagParseException {
        final ListTag lllllllllllllIIIlIIIllIlllIIlIll = new ListTag();
        this.buffer.expect('[');
        final boolean lllllllllllllIIIlIIIllIlllIIlIIl = this.buffer.peek() == '0' && this.buffer.peek(1) == ':';
        while (this.buffer.hasMore()) {
            if (this.buffer.peek() == ']') {
                this.buffer.advance();
                return lllllllllllllIIIlIIIllIlllIIlIll;
            }
            if (lllllllllllllIIIlIIIllIlllIIlIIl) {
                this.buffer.takeUntil(':');
            }
            final Tag lllllllllllllIIIlIIIllIlllIIllIl = this.tag();
            lllllllllllllIIIlIIIllIlllIIlIll.add(lllllllllllllIIIlIIIllIlllIIllIl);
            if (this.separatorOrCompleteWith(']')) {
                return lllllllllllllIIIlIIIllIlllIIlIll;
            }
        }
        throw this.buffer.makeError("Reached end of file without end of list tag!");
    }
    
    private byte[] byteArray() throws StringTagParseException {
        final List<Byte> lllllllllllllIIIlIIIllIllIlIIIlI = new ArrayList<Byte>();
        while (this.buffer.hasMore()) {
            final CharSequence lllllllllllllIIIlIIIllIllIlIIlII = this.buffer.skipWhitespace().takeUntil('B');
            try {
                lllllllllllllIIIlIIIllIllIlIIIlI.add(Byte.valueOf(lllllllllllllIIIlIIIllIllIlIIlII.toString()));
            }
            catch (NumberFormatException lllllllllllllIIIlIIIllIllIlIIlll) {
                throw this.buffer.makeError("All elements of a byte array must be bytes!");
            }
            if (this.separatorOrCompleteWith(']')) {
                final byte[] lllllllllllllIIIlIIIllIllIlIIlIl = new byte[lllllllllllllIIIlIIIllIllIlIIIlI.size()];
                for (int lllllllllllllIIIlIIIllIllIlIIllI = 0; lllllllllllllIIIlIIIllIllIlIIllI < lllllllllllllIIIlIIIllIllIlIIIlI.size(); ++lllllllllllllIIIlIIIllIllIlIIllI) {
                    lllllllllllllIIIlIIIllIllIlIIlIl[lllllllllllllIIIlIIIllIllIlIIllI] = lllllllllllllIIIlIIIllIllIlIIIlI.get(lllllllllllllIIIlIIIllIllIlIIllI);
                }
                return lllllllllllllIIIlIIIllIllIlIIlIl;
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }
    
    private Tag scalar() {
        final StringBuilder lllllllllllllIIIlIIIllIlIIlIIIII = new StringBuilder();
        boolean lllllllllllllIIIlIIIllIlIIIlllll = true;
        while (this.buffer.hasMore()) {
            final char lllllllllllllIIIlIIIllIlIIlIIIlI = this.buffer.peek();
            if (lllllllllllllIIIlIIIllIlIIIlllll && !Tokens.numeric(lllllllllllllIIIlIIIllIlIIlIIIlI) && lllllllllllllIIIlIIIllIlIIlIIIII.length() != 0) {
                Tag lllllllllllllIIIlIIIllIlIIlIIIll = null;
                try {
                    switch (Character.toUpperCase(lllllllllllllIIIlIIIllIlIIlIIIlI)) {
                        case 'B': {
                            lllllllllllllIIIlIIIllIlIIlIIIll = new ByteTag(Byte.parseByte(String.valueOf(lllllllllllllIIIlIIIllIlIIlIIIII)));
                            break;
                        }
                        case 'S': {
                            lllllllllllllIIIlIIIllIlIIlIIIll = new ShortTag(Short.parseShort(String.valueOf(lllllllllllllIIIlIIIllIlIIlIIIII)));
                            break;
                        }
                        case 'L': {
                            lllllllllllllIIIlIIIllIlIIlIIIll = new LongTag(Long.parseLong(String.valueOf(lllllllllllllIIIlIIIllIlIIlIIIII)));
                            break;
                        }
                        case 'F': {
                            lllllllllllllIIIlIIIllIlIIlIIIll = new FloatTag(Float.parseFloat(String.valueOf(lllllllllllllIIIlIIIllIlIIlIIIII)));
                            break;
                        }
                        case 'D': {
                            lllllllllllllIIIlIIIllIlIIlIIIll = new DoubleTag(Double.parseDouble(String.valueOf(lllllllllllllIIIlIIIllIlIIlIIIII)));
                            break;
                        }
                    }
                }
                catch (NumberFormatException lllllllllllllIIIlIIIllIlIIlIIlII) {
                    lllllllllllllIIIlIIIllIlIIIlllll = false;
                }
                if (lllllllllllllIIIlIIIllIlIIlIIIll != null) {
                    this.buffer.take();
                    return lllllllllllllIIIlIIIllIlIIlIIIll;
                }
            }
            if (lllllllllllllIIIlIIIllIlIIlIIIlI == '\\') {
                this.buffer.advance();
                lllllllllllllIIIlIIIllIlIIlIIIII.append(this.buffer.take());
            }
            else {
                if (!Tokens.id(lllllllllllllIIIlIIIllIlIIlIIIlI)) {
                    break;
                }
                lllllllllllllIIIlIIIllIlIIlIIIII.append(this.buffer.take());
            }
        }
        final String lllllllllllllIIIlIIIllIlIIIlllIl = String.valueOf(lllllllllllllIIIlIIIllIlIIlIIIII);
        if (lllllllllllllIIIlIIIllIlIIIlllll) {
            try {
                return new IntTag(Integer.parseInt(lllllllllllllIIIlIIIllIlIIIlllIl));
            }
            catch (NumberFormatException ex) {}
        }
        return new StringTag(lllllllllllllIIIlIIIllIlIIIlllIl);
    }
    
    private boolean separatorOrCompleteWith(final char lllllllllllllIIIlIIIllIlIIIIIIll) throws StringTagParseException {
        if (this.buffer.skipWhitespace().peek() == lllllllllllllIIIlIIIllIlIIIIIIll) {
            this.buffer.take();
            return true;
        }
        this.buffer.expect(',');
        if (this.buffer.skipWhitespace().peek() == lllllllllllllIIIlIIIllIlIIIIIIll) {
            this.buffer.take();
            return true;
        }
        return false;
    }
    
    private static String unescape(final String lllllllllllllIIIlIIIllIIlllIlIlI) {
        int lllllllllllllIIIlIIIllIIllllIIIl = lllllllllllllIIIlIIIllIIlllIlIlI.indexOf(92);
        if (lllllllllllllIIIlIIIllIIllllIIIl == -1) {
            return lllllllllllllIIIlIIIllIIlllIlIlI;
        }
        int lllllllllllllIIIlIIIllIIlllIlllI = 0;
        final StringBuilder lllllllllllllIIIlIIIllIIlllIllII = new StringBuilder(lllllllllllllIIIlIIIllIIlllIlIlI.length());
        do {
            lllllllllllllIIIlIIIllIIlllIllII.append(lllllllllllllIIIlIIIllIIlllIlIlI, lllllllllllllIIIlIIIllIIlllIlllI, lllllllllllllIIIlIIIllIIllllIIIl);
            lllllllllllllIIIlIIIllIIlllIlllI = lllllllllllllIIIlIIIllIIllllIIIl + 1;
        } while ((lllllllllllllIIIlIIIllIIllllIIIl = lllllllllllllIIIlIIIllIIlllIlIlI.indexOf(92, lllllllllllllIIIlIIIllIIlllIlllI + 1)) != -1);
        lllllllllllllIIIlIIIllIIlllIllII.append(lllllllllllllIIIlIIIllIIlllIlIlI.substring(lllllllllllllIIIlIIIllIIlllIlllI));
        return String.valueOf(lllllllllllllIIIlIIIllIIlllIllII);
    }
    
    public Tag array(final char lllllllllllllIIIlIIIllIllIllIIll) throws StringTagParseException {
        this.buffer.expect('[').expect(lllllllllllllIIIlIIIllIllIllIIll).expect(';');
        if (lllllllllllllIIIlIIIllIllIllIIll == 'B') {
            return new ByteArrayTag(this.byteArray());
        }
        if (lllllllllllllIIIlIIIllIllIllIIll == 'I') {
            return new IntArrayTag(this.intArray());
        }
        if (lllllllllllllIIIlIIIllIllIllIIll == 'L') {
            return new LongArrayTag(this.longArray());
        }
        throw this.buffer.makeError(String.valueOf(new StringBuilder().append("Type ").append(lllllllllllllIIIlIIIllIllIllIIll).append(" is not a valid element type in an array!")));
    }
    
    public TagStringReader(final CharBuffer lllllllllllllIIIlIIIllIllllIIlll) {
        this.buffer = lllllllllllllIIIlIIIllIllllIIlll;
    }
    
    public String key() throws StringTagParseException {
        this.buffer.skipWhitespace();
        final char lllllllllllllIIIlIIIllIlIlIlIlIl = this.buffer.peek();
        try {
            if (lllllllllllllIIIlIIIllIlIlIlIlIl == '\'' || lllllllllllllIIIlIIIllIlIlIlIlIl == '\"') {
                return unescape(this.buffer.takeUntil(this.buffer.take()).toString());
            }
            final StringBuilder lllllllllllllIIIlIIIllIlIlIllIIl = new StringBuilder();
            while (this.buffer.peek() != ':') {
                lllllllllllllIIIlIIIllIlIlIllIIl.append(this.buffer.take());
            }
            final float lllllllllllllIIIlIIIllIlIlIIllll = (float)String.valueOf(lllllllllllllIIIlIIIllIlIlIllIIl);
            return (String)lllllllllllllIIIlIIIllIlIlIIllll;
        }
        finally {
            this.buffer.expect(':');
        }
    }
    
    private int[] intArray() throws StringTagParseException {
        final IntStream.Builder lllllllllllllIIIlIIIllIllIIIlIIl = IntStream.builder();
        while (this.buffer.hasMore()) {
            final Tag lllllllllllllIIIlIIIllIllIIIlIll = this.tag();
            if (!(lllllllllllllIIIlIIIllIllIIIlIll instanceof IntTag)) {
                throw this.buffer.makeError("All elements of an int array must be ints!");
            }
            lllllllllllllIIIlIIIllIllIIIlIIl.add(((NumberTag)lllllllllllllIIIlIIIllIllIIIlIll).asInt());
            if (this.separatorOrCompleteWith(']')) {
                return lllllllllllllIIIlIIIllIllIIIlIIl.build().toArray();
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }
}
