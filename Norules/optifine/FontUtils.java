package optifine;

import net.minecraft.util.*;
import java.io.*;
import java.util.*;

public class FontUtils
{
    public static float readFloat(final Properties lllllllllllllIIlllIIIlIIlIllllII, final String lllllllllllllIIlllIIIlIIlIlllIll, final float lllllllllllllIIlllIIIlIIlIlllIlI) {
        final String lllllllllllllIIlllIIIlIIlIlllIIl = lllllllllllllIIlllIIIlIIlIllllII.getProperty(lllllllllllllIIlllIIIlIIlIlllIll);
        if (lllllllllllllIIlllIIIlIIlIlllIIl == null) {
            return lllllllllllllIIlllIIIlIIlIlllIlI;
        }
        final float lllllllllllllIIlllIIIlIIlIlllIII = Config.parseFloat(lllllllllllllIIlllIIIlIIlIlllIIl, Float.MIN_VALUE);
        if (lllllllllllllIIlllIIIlIIlIlllIII == Float.MIN_VALUE) {
            Config.warn(String.valueOf(new StringBuilder("Invalid value for ").append(lllllllllllllIIlllIIIlIIlIlllIll).append(": ").append(lllllllllllllIIlllIIIlIIlIlllIIl)));
            return lllllllllllllIIlllIIIlIIlIlllIlI;
        }
        return lllllllllllllIIlllIIIlIIlIlllIII;
    }
    
    public static ResourceLocation getHdFontLocation(final ResourceLocation lllllllllllllIIlllIIIlIIlIIllIIl) {
        if (!Config.isCustomFonts()) {
            return lllllllllllllIIlllIIIlIIlIIllIIl;
        }
        if (lllllllllllllIIlllIIIlIIlIIllIIl == null) {
            return lllllllllllllIIlllIIIlIIlIIllIIl;
        }
        if (!Config.isMinecraftThread()) {
            return lllllllllllllIIlllIIIlIIlIIllIIl;
        }
        String lllllllllllllIIlllIIIlIIlIIlllIl = lllllllllllllIIlllIIIlIIlIIllIIl.getResourcePath();
        final String lllllllllllllIIlllIIIlIIlIIlllII = "textures/";
        final String lllllllllllllIIlllIIIlIIlIIllIll = "mcpatcher/";
        if (!lllllllllllllIIlllIIIlIIlIIlllIl.startsWith(lllllllllllllIIlllIIIlIIlIIlllII)) {
            return lllllllllllllIIlllIIIlIIlIIllIIl;
        }
        lllllllllllllIIlllIIIlIIlIIlllIl = lllllllllllllIIlllIIIlIIlIIlllIl.substring(lllllllllllllIIlllIIIlIIlIIlllII.length());
        lllllllllllllIIlllIIIlIIlIIlllIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlllIIIlIIlIIllIll)).append(lllllllllllllIIlllIIIlIIlIIlllIl));
        final ResourceLocation lllllllllllllIIlllIIIlIIlIIllIlI = new ResourceLocation(lllllllllllllIIlllIIIlIIlIIllIIl.getResourceDomain(), lllllllllllllIIlllIIIlIIlIIlllIl);
        return Config.hasResource(Config.getResourceManager(), lllllllllllllIIlllIIIlIIlIIllIlI) ? lllllllllllllIIlllIIIlIIlIIllIlI : lllllllllllllIIlllIIIlIIlIIllIIl;
    }
    
    public static void readCustomCharWidths(final Properties lllllllllllllIIlllIIIlIIllIIlIlI, final float[] lllllllllllllIIlllIIIlIIllIlIIIl) {
        for (final Object lllllllllllllIIlllIIIlIIllIlIIII : ((Hashtable<Object, V>)lllllllllllllIIlllIIIlIIllIIlIlI).keySet()) {
            final String lllllllllllllIIlllIIIlIIllIIllll = "width.";
            if (((String)lllllllllllllIIlllIIIlIIllIlIIII).startsWith(lllllllllllllIIlllIIIlIIllIIllll)) {
                final String lllllllllllllIIlllIIIlIIllIIlllI = ((String)lllllllllllllIIlllIIIlIIllIlIIII).substring(lllllllllllllIIlllIIIlIIllIIllll.length());
                final int lllllllllllllIIlllIIIlIIllIIllIl = Config.parseInt(lllllllllllllIIlllIIIlIIllIIlllI, -1);
                if (lllllllllllllIIlllIIIlIIllIIllIl < 0 || lllllllllllllIIlllIIIlIIllIIllIl >= lllllllllllllIIlllIIIlIIllIlIIIl.length) {
                    continue;
                }
                final String lllllllllllllIIlllIIIlIIllIIllII = lllllllllllllIIlllIIIlIIllIIlIlI.getProperty((String)lllllllllllllIIlllIIIlIIllIlIIII);
                final float lllllllllllllIIlllIIIlIIllIIlIll = Config.parseFloat(lllllllllllllIIlllIIIlIIllIIllII, -1.0f);
                if (lllllllllllllIIlllIIIlIIllIIlIll < 0.0f) {
                    continue;
                }
                lllllllllllllIIlllIIIlIIllIlIIIl[lllllllllllllIIlllIIIlIIllIIllIl] = lllllllllllllIIlllIIIlIIllIIlIll;
            }
        }
    }
    
    public static Properties readFontProperties(final ResourceLocation lllllllllllllIIlllIIIlIIlllIIIlI) {
        final String lllllllllllllIIlllIIIlIIlllIlIIl = lllllllllllllIIlllIIIlIIlllIIIlI.getResourcePath();
        final Properties lllllllllllllIIlllIIIlIIlllIlIII = new Properties();
        final String lllllllllllllIIlllIIIlIIlllIIlll = ".png";
        if (!lllllllllllllIIlllIIIlIIlllIlIIl.endsWith(lllllllllllllIIlllIIIlIIlllIIlll)) {
            return lllllllllllllIIlllIIIlIIlllIlIII;
        }
        final String lllllllllllllIIlllIIIlIIlllIIllI = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlllIIIlIIlllIlIIl.substring(0, lllllllllllllIIlllIIIlIIlllIlIIl.length() - lllllllllllllIIlllIIIlIIlllIIlll.length()))).append(".properties"));
        try {
            final ResourceLocation lllllllllllllIIlllIIIlIIlllIIlIl = new ResourceLocation(lllllllllllllIIlllIIIlIIlllIIIlI.getResourceDomain(), lllllllllllllIIlllIIIlIIlllIIllI);
            final InputStream lllllllllllllIIlllIIIlIIlllIIlII = Config.getResourceStream(Config.getResourceManager(), lllllllllllllIIlllIIIlIIlllIIlIl);
            if (lllllllllllllIIlllIIIlIIlllIIlII == null) {
                return lllllllllllllIIlllIIIlIIlllIlIII;
            }
            Config.log(String.valueOf(new StringBuilder("Loading ").append(lllllllllllllIIlllIIIlIIlllIIllI)));
            lllllllllllllIIlllIIIlIIlllIlIII.load(lllllllllllllIIlllIIIlIIlllIIlII);
        }
        catch (FileNotFoundException ex) {}
        catch (IOException lllllllllllllIIlllIIIlIIlllIIIll) {
            lllllllllllllIIlllIIIlIIlllIIIll.printStackTrace();
        }
        return lllllllllllllIIlllIIIlIIlllIlIII;
    }
    
    public static boolean readBoolean(final Properties lllllllllllllIIlllIIIlIIlIlIlIII, final String lllllllllllllIIlllIIIlIIlIlIIlll, final boolean lllllllllllllIIlllIIIlIIlIlIIllI) {
        final String lllllllllllllIIlllIIIlIIlIlIlIlI = lllllllllllllIIlllIIIlIIlIlIlIII.getProperty(lllllllllllllIIlllIIIlIIlIlIIlll);
        if (lllllllllllllIIlllIIIlIIlIlIlIlI == null) {
            return lllllllllllllIIlllIIIlIIlIlIIllI;
        }
        final String lllllllllllllIIlllIIIlIIlIlIlIIl = lllllllllllllIIlllIIIlIIlIlIlIlI.toLowerCase().trim();
        if (lllllllllllllIIlllIIIlIIlIlIlIIl.equals("true") || lllllllllllllIIlllIIIlIIlIlIlIIl.equals("on")) {
            return true;
        }
        if (!lllllllllllllIIlllIIIlIIlIlIlIIl.equals("false") && !lllllllllllllIIlllIIIlIIlIlIlIIl.equals("off")) {
            Config.warn(String.valueOf(new StringBuilder("Invalid value for ").append(lllllllllllllIIlllIIIlIIlIlIIlll).append(": ").append(lllllllllllllIIlllIIIlIIlIlIlIlI)));
            return lllllllllllllIIlllIIIlIIlIlIIllI;
        }
        return false;
    }
}
