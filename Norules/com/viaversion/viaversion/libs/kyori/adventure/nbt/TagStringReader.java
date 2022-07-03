package com.viaversion.viaversion.libs.kyori.adventure.nbt;

import java.util.stream.*;
import java.util.*;

final class TagStringReader
{
    private static final /* synthetic */ byte[] EMPTY_BYTE_ARRAY;
    private static final /* synthetic */ int[] EMPTY_INT_ARRAY;
    private final /* synthetic */ CharBuffer buffer;
    private /* synthetic */ boolean acceptLegacy;
    private /* synthetic */ int depth;
    private static final /* synthetic */ long[] EMPTY_LONG_ARRAY;
    
    static {
        MAX_DEPTH = 512;
        EMPTY_BYTE_ARRAY = new byte[0];
        EMPTY_INT_ARRAY = new int[0];
        EMPTY_LONG_ARRAY = new long[0];
    }
    
    private static String unescape(final String lllllllllllllllIIlIllIllIllIIIll) {
        int lllllllllllllllIIlIllIllIllIIIIl = lllllllllllllllIIlIllIllIllIIIll.indexOf(92);
        if (lllllllllllllllIIlIllIllIllIIIIl == -1) {
            return lllllllllllllllIIlIllIllIllIIIll;
        }
        int lllllllllllllllIIlIllIllIllIIIII = 0;
        final StringBuilder lllllllllllllllIIlIllIllIlIlllll = new StringBuilder(lllllllllllllllIIlIllIllIllIIIll.length());
        do {
            lllllllllllllllIIlIllIllIlIlllll.append(lllllllllllllllIIlIllIllIllIIIll, lllllllllllllllIIlIllIllIllIIIII, lllllllllllllllIIlIllIllIllIIIIl);
            lllllllllllllllIIlIllIllIllIIIII = lllllllllllllllIIlIllIllIllIIIIl + 1;
        } while ((lllllllllllllllIIlIllIllIllIIIIl = lllllllllllllllIIlIllIllIllIIIll.indexOf(92, lllllllllllllllIIlIllIllIllIIIII + 1)) != -1);
        lllllllllllllllIIlIllIllIlIlllll.append(lllllllllllllllIIlIllIllIllIIIll.substring(lllllllllllllllIIlIllIllIllIIIII));
        return String.valueOf(lllllllllllllllIIlIllIllIlIlllll);
    }
    
    public ListBinaryTag list() throws StringTagParseException {
        final ListBinaryTag.Builder<BinaryTag> lllllllllllllllIIlIllIllllllIIII = ListBinaryTag.builder();
        this.buffer.expect('[');
        final boolean lllllllllllllllIIlIllIlllllIllll = this.acceptLegacy && this.buffer.peek() == '0' && this.buffer.peek(1) == ':';
        if (!lllllllllllllllIIlIllIlllllIllll && this.buffer.takeIf(']')) {
            return ListBinaryTag.empty();
        }
        while (this.buffer.hasMore()) {
            if (lllllllllllllllIIlIllIlllllIllll) {
                this.buffer.takeUntil(':');
            }
            final BinaryTag lllllllllllllllIIlIllIllllllIIlI = this.tag();
            lllllllllllllllIIlIllIllllllIIII.add(lllllllllllllllIIlIllIllllllIIlI);
            if (this.separatorOrCompleteWith(']')) {
                return lllllllllllllllIIlIllIllllllIIII.build();
            }
        }
        throw this.buffer.makeError("Reached end of file without end of list tag!");
    }
    
    private int[] intArray() throws StringTagParseException {
        if (this.buffer.takeIf(']')) {
            return TagStringReader.EMPTY_INT_ARRAY;
        }
        final IntStream.Builder lllllllllllllllIIlIllIllllIIlIlI = IntStream.builder();
        while (this.buffer.hasMore()) {
            final BinaryTag lllllllllllllllIIlIllIllllIIllIl = this.tag();
            if (!(lllllllllllllllIIlIllIllllIIllIl instanceof IntBinaryTag)) {
                throw this.buffer.makeError("All elements of an int array must be ints!");
            }
            lllllllllllllllIIlIllIllllIIlIlI.add(((IntBinaryTag)lllllllllllllllIIlIllIllllIIllIl).intValue());
            if (this.separatorOrCompleteWith(']')) {
                return lllllllllllllllIIlIllIllllIIlIlI.build().toArray();
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }
    
    private long[] longArray() throws StringTagParseException {
        if (this.buffer.takeIf(']')) {
            return TagStringReader.EMPTY_LONG_ARRAY;
        }
        final LongStream.Builder lllllllllllllllIIlIllIlllIllIlll = LongStream.builder();
        while (this.buffer.hasMore()) {
            final CharSequence lllllllllllllllIIlIllIlllIlllIll = this.buffer.skipWhitespace().takeUntil('l');
            try {
                lllllllllllllllIIlIllIlllIllIlll.add(Long.parseLong(lllllllllllllllIIlIllIlllIlllIll.toString()));
            }
            catch (NumberFormatException lllllllllllllllIIlIllIlllIllllII) {
                throw this.buffer.makeError("All elements of a long array must be longs!");
            }
            if (this.separatorOrCompleteWith(']')) {
                return lllllllllllllllIIlIllIlllIllIlll.build().toArray();
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }
    
    public BinaryTag array(char lllllllllllllllIIlIllIlllllIlIII) throws StringTagParseException {
        this.buffer.expect('[').expect(lllllllllllllllIIlIllIlllllIlIII).expect(';');
        lllllllllllllllIIlIllIlllllIlIII = Character.toLowerCase(lllllllllllllllIIlIllIlllllIlIII);
        if (lllllllllllllllIIlIllIlllllIlIII == 'b') {
            return ByteArrayBinaryTag.of(this.byteArray());
        }
        if (lllllllllllllllIIlIllIlllllIlIII == 'i') {
            return IntArrayBinaryTag.of(this.intArray());
        }
        if (lllllllllllllllIIlIllIlllllIlIII == 'l') {
            return LongArrayBinaryTag.of(this.longArray());
        }
        throw this.buffer.makeError(String.valueOf(new StringBuilder().append("Type ").append(lllllllllllllllIIlIllIlllllIlIII).append(" is not a valid element type in an array!")));
    }
    
    public String key() throws StringTagParseException {
        this.buffer.skipWhitespace();
        final char lllllllllllllllIIlIllIlllIIlIIlI = this.buffer.peek();
        try {
            if (lllllllllllllllIIlIllIlllIIlIIlI == '\'' || lllllllllllllllIIlIllIlllIIlIIlI == '\"') {
                return unescape(this.buffer.takeUntil(this.buffer.take()).toString());
            }
            final StringBuilder lllllllllllllllIIlIllIlllIIlIlII = new StringBuilder();
            while (this.buffer.hasMore()) {
                final char lllllllllllllllIIlIllIlllIIlIlIl = this.buffer.peek();
                if (!Tokens.id(lllllllllllllllIIlIllIlllIIlIlIl)) {
                    if (!this.acceptLegacy) {
                        break;
                    }
                    if (lllllllllllllllIIlIllIlllIIlIlIl == '\\') {
                        this.buffer.take();
                    }
                    else {
                        if (lllllllllllllllIIlIllIlllIIlIlIl == ':') {
                            break;
                        }
                        lllllllllllllllIIlIllIlllIIlIlII.append(this.buffer.take());
                    }
                }
                else {
                    lllllllllllllllIIlIllIlllIIlIlII.append(this.buffer.take());
                }
            }
            final Exception lllllllllllllllIIlIllIlllIIIlllI = (Exception)String.valueOf(lllllllllllllllIIlIllIlllIIlIlII);
            return (String)lllllllllllllllIIlIllIlllIIIlllI;
        }
        finally {
            this.buffer.expect(':');
        }
    }
    
    private BinaryTag scalar() {
        final StringBuilder lllllllllllllllIIlIllIllIlllIlll = new StringBuilder();
        boolean lllllllllllllllIIlIllIllIlllIllI = true;
        while (this.buffer.hasMore()) {
            final char lllllllllllllllIIlIllIllIllllIlI = this.buffer.peek();
            if (lllllllllllllllIIlIllIllIlllIllI && !Tokens.numeric(lllllllllllllllIIlIllIllIllllIlI) && lllllllllllllllIIlIllIllIlllIlll.length() != 0) {
                BinaryTag lllllllllllllllIIlIllIllIllllIll = null;
                try {
                    switch (Character.toLowerCase(lllllllllllllllIIlIllIllIllllIlI)) {
                        case 'b': {
                            lllllllllllllllIIlIllIllIllllIll = ByteBinaryTag.of(Byte.parseByte(String.valueOf(lllllllllllllllIIlIllIllIlllIlll)));
                            break;
                        }
                        case 's': {
                            lllllllllllllllIIlIllIllIllllIll = ShortBinaryTag.of(Short.parseShort(String.valueOf(lllllllllllllllIIlIllIllIlllIlll)));
                            break;
                        }
                        case 'l': {
                            lllllllllllllllIIlIllIllIllllIll = LongBinaryTag.of(Long.parseLong(String.valueOf(lllllllllllllllIIlIllIllIlllIlll)));
                            break;
                        }
                        case 'f': {
                            lllllllllllllllIIlIllIllIllllIll = FloatBinaryTag.of(Float.parseFloat(String.valueOf(lllllllllllllllIIlIllIllIlllIlll)));
                            break;
                        }
                        case 'd': {
                            lllllllllllllllIIlIllIllIllllIll = DoubleBinaryTag.of(Double.parseDouble(String.valueOf(lllllllllllllllIIlIllIllIlllIlll)));
                            break;
                        }
                    }
                }
                catch (NumberFormatException lllllllllllllllIIlIllIllIlllllII) {
                    lllllllllllllllIIlIllIllIlllIllI = false;
                }
                if (lllllllllllllllIIlIllIllIllllIll != null) {
                    this.buffer.take();
                    return lllllllllllllllIIlIllIllIllllIll;
                }
            }
            if (lllllllllllllllIIlIllIllIllllIlI == '\\') {
                this.buffer.advance();
                lllllllllllllllIIlIllIllIlllIlll.append(this.buffer.take());
            }
            else {
                if (!Tokens.id(lllllllllllllllIIlIllIllIllllIlI)) {
                    break;
                }
                lllllllllllllllIIlIllIllIlllIlll.append(this.buffer.take());
            }
        }
        final String lllllllllllllllIIlIllIllIlllIlIl = String.valueOf(lllllllllllllllIIlIllIllIlllIlll);
        if (lllllllllllllllIIlIllIllIlllIllI) {
            try {
                return IntBinaryTag.of(Integer.parseInt(lllllllllllllllIIlIllIllIlllIlIl));
            }
            catch (NumberFormatException lllllllllllllllIIlIllIllIllllIIl) {
                try {
                    return DoubleBinaryTag.of(Double.parseDouble(lllllllllllllllIIlIllIllIlllIlIl));
                }
                catch (NumberFormatException ex) {}
            }
        }
        if (lllllllllllllllIIlIllIllIlllIlIl.equalsIgnoreCase("true")) {
            return ByteBinaryTag.ONE;
        }
        if (lllllllllllllllIIlIllIllIlllIlIl.equalsIgnoreCase("false")) {
            return ByteBinaryTag.ZERO;
        }
        return StringBinaryTag.of(lllllllllllllllIIlIllIllIlllIlIl);
    }
    
    public BinaryTag tag() throws StringTagParseException {
        if (this.depth++ > 512) {
            throw this.buffer.makeError("Exceeded maximum allowed depth of 512 when reading tag");
        }
        try {
            final char lllllllllllllllIIlIllIlllIIIlIII = this.buffer.skipWhitespace().peek();
            switch (lllllllllllllllIIlIllIlllIIIlIII) {
                case '{': {
                    final Exception lllllllllllllllIIlIllIlllIIIIlII = (Exception)this.compound();
                    return (BinaryTag)lllllllllllllllIIlIllIlllIIIIlII;
                }
                case '[': {
                    if (this.buffer.hasMore(2) && this.buffer.peek(2) == ';') {
                        final Exception lllllllllllllllIIlIllIlllIIIIlII = (Exception)this.array(this.buffer.peek(1));
                        return (BinaryTag)lllllllllllllllIIlIllIlllIIIIlII;
                    }
                    final Exception lllllllllllllllIIlIllIlllIIIIlII = (Exception)this.list();
                    return (BinaryTag)lllllllllllllllIIlIllIlllIIIIlII;
                }
                case '\"':
                case '\'': {
                    this.buffer.advance();
                    final Exception lllllllllllllllIIlIllIlllIIIIlII = (Exception)StringBinaryTag.of(unescape(this.buffer.takeUntil(lllllllllllllllIIlIllIlllIIIlIII).toString()));
                    return (BinaryTag)lllllllllllllllIIlIllIlllIIIIlII;
                }
                default: {
                    final Exception lllllllllllllllIIlIllIlllIIIIlII = (Exception)this.scalar();
                    return (BinaryTag)lllllllllllllllIIlIllIlllIIIIlII;
                }
            }
        }
        finally {
            --this.depth;
        }
    }
    
    private boolean separatorOrCompleteWith(final char lllllllllllllllIIlIllIllIllIllII) throws StringTagParseException {
        if (this.buffer.takeIf(lllllllllllllllIIlIllIllIllIllII)) {
            return true;
        }
        this.buffer.expect(',');
        return false;
    }
    
    public CompoundBinaryTag compound() throws StringTagParseException {
        this.buffer.expect('{');
        if (this.buffer.takeIf('}')) {
            return CompoundBinaryTag.empty();
        }
        final CompoundBinaryTag.Builder lllllllllllllllIIlIllIlllllllIIl = CompoundBinaryTag.builder();
        while (this.buffer.hasMore()) {
            lllllllllllllllIIlIllIlllllllIIl.put(this.key(), this.tag());
            if (this.separatorOrCompleteWith('}')) {
                return lllllllllllllllIIlIllIlllllllIIl.build();
            }
        }
        throw this.buffer.makeError("Unterminated compound tag!");
    }
    
    public void legacy(final boolean lllllllllllllllIIlIllIllIlIllIII) {
        this.acceptLegacy = lllllllllllllllIIlIllIllIlIllIII;
    }
    
    TagStringReader(final CharBuffer lllllllllllllllIIlIlllIIIIIIIIIl) {
        this.buffer = lllllllllllllllIIlIlllIIIIIIIIIl;
    }
    
    private byte[] byteArray() throws StringTagParseException {
        if (this.buffer.takeIf(']')) {
            return TagStringReader.EMPTY_BYTE_ARRAY;
        }
        final List<Byte> lllllllllllllllIIlIllIllllIllIIl = new ArrayList<Byte>();
        while (this.buffer.hasMore()) {
            final CharSequence lllllllllllllllIIlIllIllllIllIll = this.buffer.skipWhitespace().takeUntil('b');
            try {
                lllllllllllllllIIlIllIllllIllIIl.add(Byte.valueOf(lllllllllllllllIIlIllIllllIllIll.toString()));
            }
            catch (NumberFormatException lllllllllllllllIIlIllIllllIllllI) {
                throw this.buffer.makeError("All elements of a byte array must be bytes!");
            }
            if (this.separatorOrCompleteWith(']')) {
                final byte[] lllllllllllllllIIlIllIllllIlllII = new byte[lllllllllllllllIIlIllIllllIllIIl.size()];
                for (int lllllllllllllllIIlIllIllllIlllIl = 0; lllllllllllllllIIlIllIllllIlllIl < lllllllllllllllIIlIllIllllIllIIl.size(); ++lllllllllllllllIIlIllIllllIlllIl) {
                    lllllllllllllllIIlIllIllllIlllII[lllllllllllllllIIlIllIllllIlllIl] = lllllllllllllllIIlIllIllllIllIIl.get(lllllllllllllllIIlIllIllllIlllIl);
                }
                return lllllllllllllllIIlIllIllllIlllII;
            }
        }
        throw this.buffer.makeError("Reached end of document without array close");
    }
}
