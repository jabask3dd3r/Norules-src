package com.viaversion.viaversion.api.minecraft.nbt;

final class CharBuffer
{
    private /* synthetic */ int index;
    private final /* synthetic */ CharSequence sequence;
    
    public char peek(final int lllllllllllllIIIIIIllIlllIllIIll) {
        return this.sequence.charAt(this.index + lllllllllllllIIIIIIllIlllIllIIll);
    }
    
    public char peek() {
        return this.sequence.charAt(this.index);
    }
    
    CharBuffer(final CharSequence lllllllllllllIIIIIIllIlllIllllII) {
        this.sequence = lllllllllllllIIIIIIllIlllIllllII;
    }
    
    public CharBuffer expect(final char lllllllllllllIIIIIIllIlllIIllIIl) throws StringTagParseException {
        this.skipWhitespace();
        if (!this.hasMore()) {
            throw this.makeError(String.valueOf(new StringBuilder().append("Expected character '").append(lllllllllllllIIIIIIllIlllIIllIIl).append("' but got EOF")));
        }
        if (this.peek() != lllllllllllllIIIIIIllIlllIIllIIl) {
            throw this.makeError(String.valueOf(new StringBuilder().append("Expected character '").append(lllllllllllllIIIIIIllIlllIIllIIl).append("' but got '").append(this.peek()).append("'")));
        }
        this.take();
        return this;
    }
    
    public boolean advance() {
        ++this.index;
        return this.hasMore();
    }
    
    public char take() {
        return this.sequence.charAt(this.index++);
    }
    
    public boolean hasMore() {
        return this.index < this.sequence.length();
    }
    
    public CharSequence takeUntil(char lllllllllllllIIIIIIllIlllIIlllll) throws StringTagParseException {
        lllllllllllllIIIIIIllIlllIIlllll = Character.toLowerCase(lllllllllllllIIIIIIllIlllIIlllll);
        int lllllllllllllIIIIIIllIlllIlIIIlI = -1;
        for (int lllllllllllllIIIIIIllIlllIlIIlIl = this.index; lllllllllllllIIIIIIllIlllIlIIlIl < this.sequence.length(); ++lllllllllllllIIIIIIllIlllIlIIlIl) {
            if (this.sequence.charAt(lllllllllllllIIIIIIllIlllIlIIlIl) == '\\') {
                ++lllllllllllllIIIIIIllIlllIlIIlIl;
            }
            else if (Character.toLowerCase(this.sequence.charAt(lllllllllllllIIIIIIllIlllIlIIlIl)) == lllllllllllllIIIIIIllIlllIIlllll) {
                lllllllllllllIIIIIIllIlllIlIIIlI = lllllllllllllIIIIIIllIlllIlIIlIl;
                break;
            }
        }
        if (lllllllllllllIIIIIIllIlllIlIIIlI == -1) {
            throw this.makeError(String.valueOf(new StringBuilder().append("No occurrence of ").append(lllllllllllllIIIIIIllIlllIIlllll).append(" was found")));
        }
        final CharSequence lllllllllllllIIIIIIllIlllIlIIIIl = this.sequence.subSequence(this.index, lllllllllllllIIIIIIllIlllIlIIIlI);
        this.index = lllllllllllllIIIIIIllIlllIlIIIlI + 1;
        return lllllllllllllIIIIIIllIlllIlIIIIl;
    }
    
    public StringTagParseException makeError(final String lllllllllllllIIIIIIllIlllIIIlllI) {
        return new StringTagParseException(lllllllllllllIIIIIIllIlllIIIlllI, this.sequence, this.index);
    }
    
    public CharBuffer skipWhitespace() {
        while (this.hasMore() && Character.isWhitespace(this.peek())) {
            this.advance();
        }
        return this;
    }
}
