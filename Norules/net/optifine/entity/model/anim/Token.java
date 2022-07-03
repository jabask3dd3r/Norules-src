package net.optifine.entity.model.anim;

public class Token
{
    private /* synthetic */ EnumTokenType type;
    private /* synthetic */ String text;
    
    public Token(final EnumTokenType lllllllllllllllllIlIIIlllIlIIIIl, final String lllllllllllllllllIlIIIlllIIlllIl) {
        this.type = lllllllllllllllllIlIIIlllIlIIIIl;
        this.text = lllllllllllllllllIlIIIlllIIlllIl;
    }
    
    @Override
    public String toString() {
        return this.text;
    }
    
    public EnumTokenType getType() {
        return this.type;
    }
    
    public String getText() {
        return this.text;
    }
}
