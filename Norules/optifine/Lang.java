package optifine;

import com.google.common.base.*;
import java.util.regex.*;
import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.resources.*;
import java.util.*;
import org.apache.commons.io.*;
import com.google.common.collect.*;

public class Lang
{
    private static final /* synthetic */ Splitter splitter;
    private static final /* synthetic */ Pattern pattern;
    
    private static void loadResources(final IResourcePack llllllllllllllIIllllIIIllIlIlIII, final String[] llllllllllllllIIllllIIIllIlIllll, final Map llllllllllllllIIllllIIIllIlIIllI) {
        try {
            for (int llllllllllllllIIllllIIIllIlIllIl = 0; llllllllllllllIIllllIIIllIlIllIl < llllllllllllllIIllllIIIllIlIllll.length; ++llllllllllllllIIllllIIIllIlIllIl) {
                final String llllllllllllllIIllllIIIllIlIllII = llllllllllllllIIllllIIIllIlIllll[llllllllllllllIIllllIIIllIlIllIl];
                final ResourceLocation llllllllllllllIIllllIIIllIlIlIll = new ResourceLocation(llllllllllllllIIllllIIIllIlIllII);
                if (llllllllllllllIIllllIIIllIlIlIII.resourceExists(llllllllllllllIIllllIIIllIlIlIll)) {
                    final InputStream llllllllllllllIIllllIIIllIlIlIlI = llllllllllllllIIllllIIIllIlIlIII.getInputStream(llllllllllllllIIllllIIIllIlIlIll);
                    if (llllllllllllllIIllllIIIllIlIlIlI != null) {
                        loadLocaleData(llllllllllllllIIllllIIIllIlIlIlI, llllllllllllllIIllllIIIllIlIIllI);
                    }
                }
            }
        }
        catch (IOException llllllllllllllIIllllIIIllIlIlIIl) {
            llllllllllllllIIllllIIIllIlIlIIl.printStackTrace();
        }
    }
    
    public static void resourcesReloaded() {
        final Map llllllllllllllIIllllIIIlllIIlIIl = I18n.getLocaleProperties();
        final List<String> llllllllllllllIIllllIIIlllIIlIII = new ArrayList<String>();
        final String llllllllllllllIIllllIIIlllIIIlll = "optifine/lang/";
        final String llllllllllllllIIllllIIIlllIIIllI = "en_us";
        final String llllllllllllllIIllllIIIlllIIIlIl = ".lang";
        llllllllllllllIIllllIIIlllIIlIII.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllllIIIlllIIIlll)).append(llllllllllllllIIllllIIIlllIIIllI).append(llllllllllllllIIllllIIIlllIIIlIl)));
        if (!Config.getGameSettings().language.equals(llllllllllllllIIllllIIIlllIIIllI)) {
            llllllllllllllIIllllIIIlllIIlIII.add(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIllllIIIlllIIIlll)).append(Config.getGameSettings().language).append(llllllllllllllIIllllIIIlllIIIlIl)));
        }
        final String[] llllllllllllllIIllllIIIlllIIIlII = llllllllllllllIIllllIIIlllIIlIII.toArray(new String[llllllllllllllIIllllIIIlllIIlIII.size()]);
        loadResources(Config.getDefaultResourcePack(), llllllllllllllIIllllIIIlllIIIlII, llllllllllllllIIllllIIIlllIIlIIl);
        final IResourcePack[] llllllllllllllIIllllIIIlllIIIIll = Config.getResourcePacks();
        for (int llllllllllllllIIllllIIIlllIIIIlI = 0; llllllllllllllIIllllIIIlllIIIIlI < llllllllllllllIIllllIIIlllIIIIll.length; ++llllllllllllllIIllllIIIlllIIIIlI) {
            final IResourcePack llllllllllllllIIllllIIIlllIIIIIl = llllllllllllllIIllllIIIlllIIIIll[llllllllllllllIIllllIIIlllIIIIlI];
            loadResources(llllllllllllllIIllllIIIlllIIIIIl, llllllllllllllIIllllIIIlllIIIlII, llllllllllllllIIllllIIIlllIIlIIl);
        }
    }
    
    static {
        splitter = Splitter.on('=').limit(2);
        pattern = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
    }
    
    public static String getDefault() {
        return I18n.format("generator.default", new Object[0]);
    }
    
    public static String getOff() {
        return I18n.format("options.off", new Object[0]);
    }
    
    public static String getFancy() {
        return I18n.format("options.graphics.fancy", new Object[0]);
    }
    
    public static String getOn() {
        return I18n.format("options.on", new Object[0]);
    }
    
    public static String get(final String llllllllllllllIIllllIIIllIIIIlII, final String llllllllllllllIIllllIIIllIIIIllI) {
        final String llllllllllllllIIllllIIIllIIIIlIl = I18n.format(llllllllllllllIIllllIIIllIIIIlII, new Object[0]);
        return (llllllllllllllIIllllIIIllIIIIlIl != null && !llllllllllllllIIllllIIIllIIIIlIl.equals(llllllllllllllIIllllIIIllIIIIlII)) ? llllllllllllllIIllllIIIllIIIIlIl : llllllllllllllIIllllIIIllIIIIllI;
    }
    
    public static void loadLocaleData(final InputStream llllllllllllllIIllllIIIllIIllIlI, final Map llllllllllllllIIllllIIIllIIlIIll) throws IOException {
        for (final String llllllllllllllIIllllIIIllIIllIII : IOUtils.readLines(llllllllllllllIIllllIIIllIIllIlI, Charsets.UTF_8)) {
            if (!llllllllllllllIIllllIIIllIIllIII.isEmpty() && llllllllllllllIIllllIIIllIIllIII.charAt(0) != '#') {
                final String[] llllllllllllllIIllllIIIllIIlIlll = (String[])Iterables.toArray(Lang.splitter.split((CharSequence)llllllllllllllIIllllIIIllIIllIII), (Class)String.class);
                if (llllllllllllllIIllllIIIllIIlIlll == null || llllllllllllllIIllllIIIllIIlIlll.length != 2) {
                    continue;
                }
                final String llllllllllllllIIllllIIIllIIlIllI = llllllllllllllIIllllIIIllIIlIlll[0];
                final String llllllllllllllIIllllIIIllIIlIlIl = Lang.pattern.matcher(llllllllllllllIIllllIIIllIIlIlll[1]).replaceAll("%$1s");
                llllllllllllllIIllllIIIllIIlIIll.put(llllllllllllllIIllllIIIllIIlIllI, llllllllllllllIIllllIIIllIIlIlIl);
            }
        }
    }
    
    public static String getFast() {
        return I18n.format("options.graphics.fast", new Object[0]);
    }
    
    public static String get(final String llllllllllllllIIllllIIIllIIIllII) {
        return I18n.format(llllllllllllllIIllllIIIllIIIllII, new Object[0]);
    }
}
