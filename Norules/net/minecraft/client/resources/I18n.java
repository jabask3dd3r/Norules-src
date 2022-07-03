package net.minecraft.client.resources;

import java.util.*;

public class I18n
{
    private static /* synthetic */ Locale i18nLocale;
    
    public static boolean hasKey(final String llllllllllllllIIIIIlIIllIlIlllII) {
        return I18n.i18nLocale.hasKey(llllllllllllllIIIIIlIIllIlIlllII);
    }
    
    public static Map getLocaleProperties() {
        return I18n.i18nLocale.properties;
    }
    
    public static String format(final String llllllllllllllIIIIIlIIllIlIlllll, final Object... llllllllllllllIIIIIlIIllIlIllllI) {
        return I18n.i18nLocale.formatMessage(llllllllllllllIIIIIlIIllIlIlllll, llllllllllllllIIIIIlIIllIlIllllI);
    }
    
    static void setLocale(final Locale llllllllllllllIIIIIlIIllIllIIlIl) {
        I18n.i18nLocale = llllllllllllllIIIIIlIIllIllIIlIl;
    }
}
