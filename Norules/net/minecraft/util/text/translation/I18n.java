package net.minecraft.util.text.translation;

@Deprecated
public class I18n
{
    private static final /* synthetic */ LanguageMap localizedName;
    private static final /* synthetic */ LanguageMap fallbackTranslator;
    
    @Deprecated
    public static String translateToLocalFormatted(final String llllllllllllllIIIlIlllIIIIllIlII, final Object... llllllllllllllIIIlIlllIIIIllIIIl) {
        return I18n.localizedName.translateKeyFormat(llllllllllllllIIIlIlllIIIIllIlII, llllllllllllllIIIlIlllIIIIllIIIl);
    }
    
    @Deprecated
    public static String translateToLocal(final String llllllllllllllIIIlIlllIIIIlllIII) {
        return I18n.localizedName.translateKey(llllllllllllllIIIlIlllIIIIlllIII);
    }
    
    @Deprecated
    public static String translateToFallback(final String llllllllllllllIIIlIlllIIIIlIllll) {
        return I18n.fallbackTranslator.translateKey(llllllllllllllIIIlIlllIIIIlIllll);
    }
    
    static {
        localizedName = LanguageMap.getInstance();
        fallbackTranslator = new LanguageMap();
    }
    
    public static long getLastTranslationUpdateTimeInMilliseconds() {
        return I18n.localizedName.getLastUpdateTimeInMilliseconds();
    }
    
    @Deprecated
    public static boolean canTranslate(final String llllllllllllllIIIlIlllIIIIlIlIll) {
        return I18n.localizedName.isKeyTranslated(llllllllllllllIIIlIlllIIIIlIlIll);
    }
}
