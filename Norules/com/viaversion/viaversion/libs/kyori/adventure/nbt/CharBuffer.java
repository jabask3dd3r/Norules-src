package com.viaversion.viaversion.libs.kyori.adventure.nbt;

final class CharBuffer
{
    private final /* synthetic */ CharSequence sequence;
    private /* synthetic */ int index;
    
    public char take() {
        return this.sequence.charAt(this.index++);
    }
    
    public CharBuffer expect(final char llllllllllllIlllllIlIIlIIIllIIII) throws StringTagParseException {
        this.skipWhitespace();
        if (!this.hasMore()) {
            throw this.makeError(String.valueOf(new StringBuilder().append("Expected character '").append(llllllllllllIlllllIlIIlIIIllIIII).append("' but got EOF")));
        }
        if (this.peek() != llllllllllllIlllllIlIIlIIIllIIII) {
            throw this.makeError(String.valueOf(new StringBuilder().append("Expected character '").append(llllllllllllIlllllIlIIlIIIllIIII).append("' but got '").append(this.peek()).append("'")));
        }
        this.take();
        return this;
    }
    
    public boolean hasMore() {
        return this.index < this.sequence.length();
    }
    
    public char peek() {
        return this.sequence.charAt(this.index);
    }
    
    public boolean hasMore(final int llllllllllllIlllllIlIIlIIlIIIlIl) {
        return this.index + llllllllllllIlllllIlIIlIIlIIIlIl < this.sequence.length();
    }
    
    public StringTagParseException makeError(final String llllllllllllIlllllIlIIlIIIIlllll) {
        return new StringTagParseException(llllllllllllIlllllIlIIlIIIIlllll, this.sequence, this.index);
    }
    
    CharBuffer(final CharSequence llllllllllllIlllllIlIIlIIlIlllll) {
        this.sequence = llllllllllllIlllllIlIIlIIlIlllll;
    }
    
    public boolean takeIf(final char llllllllllllIlllllIlIIlIIIlIlIIl) {
        this.skipWhitespace();
        if (this.hasMore() && this.peek() == llllllllllllIlllllIlIIlIIIlIlIIl) {
            this.advance();
            return true;
        }
        return false;
    }
    
    public CharBuffer skipWhitespace() {
        while (this.hasMore() && Character.isWhitespace(this.peek())) {
            this.advance();
        }
        return this;
    }
    
    public boolean advance() {
        ++this.index;
        return this.hasMore();
    }
    
    public CharSequence takeUntil(char llllllllllllIlllllIlIIlIIIllllII) throws StringTagParseException {
        llllllllllllIlllllIlIIlIIIllllII = Character.toLowerCase(llllllllllllIlllllIlIIlIIIllllII);
        int llllllllllllIlllllIlIIlIIIlllIII = -1;
        for (int llllllllllllIlllllIlIIlIIIlllIll = this.index; llllllllllllIlllllIlIIlIIIlllIll < this.sequence.length(); ++llllllllllllIlllllIlIIlIIIlllIll) {
            if (this.sequence.charAt(llllllllllllIlllllIlIIlIIIlllIll) == '\\') {
                ++llllllllllllIlllllIlIIlIIIlllIll;
            }
            else if (Character.toLowerCase(this.sequence.charAt(llllllllllllIlllllIlIIlIIIlllIll)) == llllllllllllIlllllIlIIlIIIllllII) {
                llllllllllllIlllllIlIIlIIIlllIII = llllllllllllIlllllIlIIlIIIlllIll;
                break;
            }
        }
        if (llllllllllllIlllllIlIIlIIIlllIII == -1) {
            throw this.makeError(String.valueOf(new StringBuilder().append("No occurrence of ").append(llllllllllllIlllllIlIIlIIIllllII).append(" was found")));
        }
        final CharSequence llllllllllllIlllllIlIIlIIIllIlll = this.sequence.subSequence(this.index, llllllllllllIlllllIlIIlIIIlllIII);
        this.index = llllllllllllIlllllIlIIlIIIlllIII + 1;
        return llllllllllllIlllllIlIIlIIIllIlll;
    }
    
    public char peek(final int llllllllllllIlllllIlIIlIIlIlIlIl) {
        return this.sequence.charAt(this.index + llllllllllllIlllllIlIIlIIlIlIlIl);
    }
}
