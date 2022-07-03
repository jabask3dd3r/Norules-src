package net.minecraft.util.text;

public class TextComponentTranslationFormatException extends IllegalArgumentException
{
    public TextComponentTranslationFormatException(final TextComponentTranslation llllllllllllllllIIIllllIIlllllll, final Throwable llllllllllllllllIIIllllIIllllIIl) {
        super(String.format("Error while parsing: %s", llllllllllllllllIIIllllIIlllllll), llllllllllllllllIIIllllIIllllIIl);
    }
    
    public TextComponentTranslationFormatException(final TextComponentTranslation llllllllllllllllIIIllllIlIIIIllI, final int llllllllllllllllIIIllllIlIIIlIII) {
        super(String.format("Invalid index %d requested for %s", llllllllllllllllIIIllllIlIIIlIII, llllllllllllllllIIIllllIlIIIIllI));
    }
    
    public TextComponentTranslationFormatException(final TextComponentTranslation llllllllllllllllIIIllllIlIIllIll, final String llllllllllllllllIIIllllIlIIlIIll) {
        super(String.format("Error parsing: %s: %s", llllllllllllllllIIIllllIlIIllIll, llllllllllllllllIIIllllIlIIlIIll));
    }
}
