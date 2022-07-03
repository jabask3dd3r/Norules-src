package net.minecraft.util.text;

public class TextComponentSelector extends TextComponentBase
{
    private final /* synthetic */ String selector;
    
    @Override
    public boolean equals(final Object lllllllllllllIIIlIIlllIIllIIlllI) {
        if (this == lllllllllllllIIIlIIlllIIllIIlllI) {
            return true;
        }
        if (!(lllllllllllllIIIlIIlllIIllIIlllI instanceof TextComponentSelector)) {
            return false;
        }
        final TextComponentSelector lllllllllllllIIIlIIlllIIllIIllIl = (TextComponentSelector)lllllllllllllIIIlIIlllIIllIIlllI;
        return this.selector.equals(lllllllllllllIIIlIIlllIIllIIllIl.selector) && super.equals(lllllllllllllIIIlIIlllIIllIIlllI);
    }
    
    public TextComponentSelector(final String lllllllllllllIIIlIIlllIIlllIIlII) {
        this.selector = lllllllllllllIIIlIIlllIIlllIIlII;
    }
    
    @Override
    public String getUnformattedComponentText() {
        return this.selector;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("SelectorComponent{pattern='").append(this.selector).append('\'').append(", siblings=").append(this.siblings).append(", style=").append(this.getStyle()).append('}'));
    }
    
    @Override
    public TextComponentSelector createCopy() {
        final TextComponentSelector lllllllllllllIIIlIIlllIIllIllIII = new TextComponentSelector(this.selector);
        lllllllllllllIIIlIIlllIIllIllIII.setStyle(this.getStyle().createShallowCopy());
        for (final ITextComponent lllllllllllllIIIlIIlllIIllIlIlll : this.getSiblings()) {
            lllllllllllllIIIlIIlllIIllIllIII.appendSibling(lllllllllllllIIIlIIlllIIllIlIlll.createCopy());
        }
        return lllllllllllllIIIlIIlllIIllIllIII;
    }
    
    public String getSelector() {
        return this.selector;
    }
}
