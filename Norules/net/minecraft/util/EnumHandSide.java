package net.minecraft.util;

import net.minecraft.util.text.*;

public enum EnumHandSide
{
    private final /* synthetic */ ITextComponent handName;
    
    LEFT("LEFT", 0, (ITextComponent)new TextComponentTranslation("options.mainHand.left", new Object[0])), 
    RIGHT("RIGHT", 1, (ITextComponent)new TextComponentTranslation("options.mainHand.right", new Object[0]));
    
    @Override
    public String toString() {
        return this.handName.getUnformattedText();
    }
    
    private EnumHandSide(final String lllllllllllllIIIIIIllIllIlIIlllI, final int lllllllllllllIIIIIIllIllIlIIllIl, final ITextComponent lllllllllllllIIIIIIllIllIlIIllII) {
        this.handName = lllllllllllllIIIIIIllIllIlIIllII;
    }
    
    public EnumHandSide opposite() {
        return (this == EnumHandSide.LEFT) ? EnumHandSide.RIGHT : EnumHandSide.LEFT;
    }
}
