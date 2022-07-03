package net.optifine.entity.model.anim;

public enum EnumTokenType
{
    IDENTIFIER("IDENTIFIER", 0, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz", "0123456789_:."), 
    BRACKET_OPEN("BRACKET_OPEN", 4, "(", 1), 
    COMMA("COMMA", 3, ",", 1), 
    BRACKET_CLOSE("BRACKET_CLOSE", 5, ")", 1);
    
    private /* synthetic */ String charsExt;
    private /* synthetic */ int maxLen;
    public static final /* synthetic */ EnumTokenType[] VALUES;
    private /* synthetic */ String charsFirst;
    
    OPERATOR("OPERATOR", 2, "+-*/%", 1), 
    CONSTANT("CONSTANT", 1, "0123456789", ".");
    
    private EnumTokenType(final String lllllllllllllllllIIIlIIIIIllIllI, final int lllllllllllllllllIIIlIIIIIllIlIl, final String lllllllllllllllllIIIlIIIIIlllIIl, final int lllllllllllllllllIIIlIIIIIllIIll) {
        this.charsFirst = lllllllllllllllllIIIlIIIIIlllIIl;
        this.charsExt = "";
        this.maxLen = lllllllllllllllllIIIlIIIIIllIIll;
    }
    
    public String getCharsFirst() {
        return this.charsFirst;
    }
    
    private EnumTokenType(final String lllllllllllllllllIIIlIIIIlIIIIlI, final int lllllllllllllllllIIIlIIIIlIIIIIl, final String lllllllllllllllllIIIlIIIIlIIIlII) {
        this.charsFirst = lllllllllllllllllIIIlIIIIlIIIlII;
        this.charsExt = "";
    }
    
    public int getMaxLen() {
        return this.maxLen;
    }
    
    public static EnumTokenType getTypeByFirstChar(final char lllllllllllllllllIIIlIIIIIIllIIl) {
        for (int lllllllllllllllllIIIlIIIIIIllIll = 0; lllllllllllllllllIIIlIIIIIIllIll < EnumTokenType.VALUES.length; ++lllllllllllllllllIIIlIIIIIIllIll) {
            final EnumTokenType lllllllllllllllllIIIlIIIIIIllIlI = EnumTokenType.VALUES[lllllllllllllllllIIIlIIIIIIllIll];
            if (lllllllllllllllllIIIlIIIIIIllIlI.getCharsFirst().indexOf(lllllllllllllllllIIIlIIIIIIllIIl) >= 0) {
                return lllllllllllllllllIIIlIIIIIIllIlI;
            }
        }
        return null;
    }
    
    public String getCharsExt() {
        return this.charsExt;
    }
    
    public boolean hasChar(final char lllllllllllllllllIIIlIIIIIIlIIll) {
        return this.getCharsFirst().indexOf(lllllllllllllllllIIIlIIIIIIlIIll) >= 0 || this.getCharsExt().indexOf(lllllllllllllllllIIIlIIIIIIlIIll) >= 0;
    }
    
    private EnumTokenType(final String lllllllllllllllllIIIlIIIIIlIlIIl, final int lllllllllllllllllIIIlIIIIIlIlIII, final String lllllllllllllllllIIIlIIIIIlIIlll, final String lllllllllllllllllIIIlIIIIIlIIllI) {
        this.charsFirst = lllllllllllllllllIIIlIIIIIlIIlll;
        this.charsExt = lllllllllllllllllIIIlIIIIIlIIllI;
    }
    
    static {
        VALUES = values();
    }
}
