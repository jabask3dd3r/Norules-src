package net.minecraft.util.text;

public class TextComponentString extends TextComponentBase
{
    private final /* synthetic */ String text;
    
    public TextComponentString(final String lllllllllllllIIlIIllIIIlIIIllIlI) {
        this.text = lllllllllllllIIlIIllIIIlIIIllIlI;
    }
    
    @Override
    public String getUnformattedComponentText() {
        return this.text;
    }
    
    public String getText() {
        return this.text;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIIllIIIlIIIIIIlI) {
        if (this == lllllllllllllIIlIIllIIIlIIIIIIlI) {
            return true;
        }
        if (!(lllllllllllllIIlIIllIIIlIIIIIIlI instanceof TextComponentString)) {
            return false;
        }
        final TextComponentString lllllllllllllIIlIIllIIIlIIIIIIIl = (TextComponentString)lllllllllllllIIlIIllIIIlIIIIIIlI;
        return this.text.equals(lllllllllllllIIlIIllIIIlIIIIIIIl.getText()) && super.equals(lllllllllllllIIlIIllIIIlIIIIIIlI);
    }
    
    @Override
    public TextComponentString createCopy() {
        final TextComponentString lllllllllllllIIlIIllIIIlIIIIllII = new TextComponentString(this.text);
        lllllllllllllIIlIIllIIIlIIIIllII.setStyle(this.getStyle().createShallowCopy());
        for (final ITextComponent lllllllllllllIIlIIllIIIlIIIIlIll : this.getSiblings()) {
            lllllllllllllIIlIIllIIIlIIIIllII.appendSibling(lllllllllllllIIlIIllIIIlIIIIlIll.createCopy());
        }
        return lllllllllllllIIlIIllIIIlIIIIllII;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("TextComponent{text='").append(this.text).append('\'').append(", siblings=").append(this.siblings).append(", style=").append(this.getStyle()).append('}'));
    }
}
