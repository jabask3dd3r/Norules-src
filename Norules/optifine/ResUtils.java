package optifine;

import net.minecraft.client.resources.*;
import net.minecraft.util.*;
import java.util.zip.*;
import java.io.*;
import java.util.*;

public class ResUtils
{
    private static String[] collectFilesFolder(final File lllllllllllllIlllIIIIIlIlIlIlIll, final String lllllllllllllIlllIIIIIlIlIlllIIl, final String[] lllllllllllllIlllIIIIIlIlIlllIII, final String[] lllllllllllllIlllIIIIIlIlIllIlll) {
        final List lllllllllllllIlllIIIIIlIlIllIllI = new ArrayList();
        final String lllllllllllllIlllIIIIIlIlIllIlIl = "assets/minecraft/";
        final File[] lllllllllllllIlllIIIIIlIlIllIlII = lllllllllllllIlllIIIIIlIlIlIlIll.listFiles();
        if (lllllllllllllIlllIIIIIlIlIllIlII == null) {
            return new String[0];
        }
        for (int lllllllllllllIlllIIIIIlIlIllIIll = 0; lllllllllllllIlllIIIIIlIlIllIIll < lllllllllllllIlllIIIIIlIlIllIlII.length; ++lllllllllllllIlllIIIIIlIlIllIIll) {
            final File lllllllllllllIlllIIIIIlIlIllIIlI = lllllllllllllIlllIIIIIlIlIllIlII[lllllllllllllIlllIIIIIlIlIllIIll];
            if (lllllllllllllIlllIIIIIlIlIllIIlI.isFile()) {
                String lllllllllllllIlllIIIIIlIlIllIIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIIIIlIlIlllIIl)).append(lllllllllllllIlllIIIIIlIlIllIIlI.getName()));
                if (lllllllllllllIlllIIIIIlIlIllIIIl.startsWith(lllllllllllllIlllIIIIIlIlIllIlIl)) {
                    lllllllllllllIlllIIIIIlIlIllIIIl = lllllllllllllIlllIIIIIlIlIllIIIl.substring(lllllllllllllIlllIIIIIlIlIllIlIl.length());
                    if (StrUtils.startsWith(lllllllllllllIlllIIIIIlIlIllIIIl, lllllllllllllIlllIIIIIlIlIlllIII) && StrUtils.endsWith(lllllllllllllIlllIIIIIlIlIllIIIl, lllllllllllllIlllIIIIIlIlIllIlll)) {
                        if (!isLowercase(lllllllllllllIlllIIIIIlIlIllIIIl)) {
                            Config.warn(String.valueOf(new StringBuilder("Skipping non-lowercase path: ").append(lllllllllllllIlllIIIIIlIlIllIIIl)));
                        }
                        else {
                            lllllllllllllIlllIIIIIlIlIllIllI.add(lllllllllllllIlllIIIIIlIlIllIIIl);
                        }
                    }
                }
            }
            else if (lllllllllllllIlllIIIIIlIlIllIIlI.isDirectory()) {
                final String lllllllllllllIlllIIIIIlIlIllIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlllIIIIIlIlIlllIIl)).append(lllllllllllllIlllIIIIIlIlIllIIlI.getName()).append("/"));
                final String[] lllllllllllllIlllIIIIIlIlIlIllll = collectFilesFolder(lllllllllllllIlllIIIIIlIlIllIIlI, lllllllllllllIlllIIIIIlIlIllIIII, lllllllllllllIlllIIIIIlIlIlllIII, lllllllllllllIlllIIIIIlIlIllIlll);
                for (int lllllllllllllIlllIIIIIlIlIlIlllI = 0; lllllllllllllIlllIIIIIlIlIlIlllI < lllllllllllllIlllIIIIIlIlIlIllll.length; ++lllllllllllllIlllIIIIIlIlIlIlllI) {
                    final String lllllllllllllIlllIIIIIlIlIlIllIl = lllllllllllllIlllIIIIIlIlIlIllll[lllllllllllllIlllIIIIIlIlIlIlllI];
                    lllllllllllllIlllIIIIIlIlIllIllI.add(lllllllllllllIlllIIIIIlIlIlIllIl);
                }
            }
        }
        final String[] lllllllllllllIlllIIIIIlIlIlIllII = lllllllllllllIlllIIIIIlIlIllIllI.toArray(new String[lllllllllllllIlllIIIIIlIlIllIllI.size()]);
        return lllllllllllllIlllIIIIIlIlIlIllII;
    }
    
    public static String[] collectFiles(final IResourcePack lllllllllllllIlllIIIIIlIllllIIII, final String[] lllllllllllllIlllIIIIIlIllllIIlI, final String[] lllllllllllllIlllIIIIIlIlllIlllI) {
        return collectFiles(lllllllllllllIlllIIIIIlIllllIIII, lllllllllllllIlllIIIIIlIllllIIlI, lllllllllllllIlllIIIIIlIlllIlllI, null);
    }
    
    private static boolean isLowercase(final String lllllllllllllIlllIIIIIlIlIIIIIII) {
        return lllllllllllllIlllIIIIIlIlIIIIIII.equals(lllllllllllllIlllIIIIIlIlIIIIIII.toLowerCase(Locale.ROOT));
    }
    
    public static String[] collectFiles(final String[] lllllllllllllIlllIIIIIllIIIlIIIl, final String[] lllllllllllllIlllIIIIIllIIIlIIII) {
        final Set<String> lllllllllllllIlllIIIIIllIIIIllll = new LinkedHashSet<String>();
        final IResourcePack[] lllllllllllllIlllIIIIIllIIIIlllI = Config.getResourcePacks();
        for (int lllllllllllllIlllIIIIIllIIIIllIl = 0; lllllllllllllIlllIIIIIllIIIIllIl < lllllllllllllIlllIIIIIllIIIIlllI.length; ++lllllllllllllIlllIIIIIllIIIIllIl) {
            final IResourcePack lllllllllllllIlllIIIIIllIIIIllII = lllllllllllllIlllIIIIIllIIIIlllI[lllllllllllllIlllIIIIIllIIIIllIl];
            final String[] lllllllllllllIlllIIIIIllIIIIlIll = collectFiles(lllllllllllllIlllIIIIIllIIIIllII, lllllllllllllIlllIIIIIllIIIlIIIl, lllllllllllllIlllIIIIIllIIIlIIII, null);
            lllllllllllllIlllIIIIIllIIIIllll.addAll(Arrays.asList(lllllllllllllIlllIIIIIllIIIIlIll));
        }
        final String[] lllllllllllllIlllIIIIIllIIIIlIlI = lllllllllllllIlllIIIIIllIIIIllll.toArray(new String[lllllllllllllIlllIIIIIllIIIIllll.size()]);
        return lllllllllllllIlllIIIIIllIIIIlIlI;
    }
    
    public static String[] collectFiles(final String lllllllllllllIlllIIIIIllIIIllIlI, final String lllllllllllllIlllIIIIIllIIIllIll) {
        return collectFiles(new String[] { lllllllllllllIlllIIIIIllIIIllIlI }, new String[] { lllllllllllllIlllIIIIIllIIIllIll });
    }
    
    public static String[] collectFiles(IResourcePack lllllllllllllIlllIIIIIlIlllIIIII, final String[] lllllllllllllIlllIIIIIlIlllIIllI, final String[] lllllllllllllIlllIIIIIlIlllIIlIl, final String[] lllllllllllllIlllIIIIIlIlllIIlII) {
        if (lllllllllllllIlllIIIIIlIlllIIIII instanceof DefaultResourcePack) {
            return collectFilesFixed((IResourcePack)lllllllllllllIlllIIIIIlIlllIIIII, lllllllllllllIlllIIIIIlIlllIIlII);
        }
        if (lllllllllllllIlllIIIIIlIlllIIIII instanceof LegacyV2Adapter) {
            final IResourcePack lllllllllllllIlllIIIIIlIlllIIIll = (IResourcePack)Reflector.getFieldValue(lllllllllllllIlllIIIIIlIlllIIIII, Reflector.LegacyV2Adapter_pack);
            if (lllllllllllllIlllIIIIIlIlllIIIll == null) {
                Config.warn(String.valueOf(new StringBuilder("LegacyV2Adapter base resource pack not found: ").append(lllllllllllllIlllIIIIIlIlllIIIII)));
                return new String[0];
            }
            lllllllllllllIlllIIIIIlIlllIIIII = lllllllllllllIlllIIIIIlIlllIIIll;
        }
        if (!(lllllllllllllIlllIIIIIlIlllIIIII instanceof AbstractResourcePack)) {
            Config.warn(String.valueOf(new StringBuilder("Unknown resource pack type: ").append(lllllllllllllIlllIIIIIlIlllIIIII)));
            return new String[0];
        }
        final AbstractResourcePack lllllllllllllIlllIIIIIlIlllIIIlI = (AbstractResourcePack)lllllllllllllIlllIIIIIlIlllIIIII;
        final File lllllllllllllIlllIIIIIlIlllIIIIl = lllllllllllllIlllIIIIIlIlllIIIlI.resourcePackFile;
        if (lllllllllllllIlllIIIIIlIlllIIIIl == null) {
            return new String[0];
        }
        if (lllllllllllllIlllIIIIIlIlllIIIIl.isDirectory()) {
            return collectFilesFolder(lllllllllllllIlllIIIIIlIlllIIIIl, "", lllllllllllllIlllIIIIIlIlllIIllI, lllllllllllllIlllIIIIIlIlllIIlIl);
        }
        if (lllllllllllllIlllIIIIIlIlllIIIIl.isFile()) {
            return collectFilesZIP(lllllllllllllIlllIIIIIlIlllIIIIl, lllllllllllllIlllIIIIIlIlllIIllI, lllllllllllllIlllIIIIIlIlllIIlIl);
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown resource pack file: ").append(lllllllllllllIlllIIIIIlIlllIIIIl)));
        return new String[0];
    }
    
    private static String[] collectFilesFixed(final IResourcePack lllllllllllllIlllIIIIIlIllIIllIl, final String[] lllllllllllllIlllIIIIIlIllIIllII) {
        if (lllllllllllllIlllIIIIIlIllIIllII == null) {
            return new String[0];
        }
        final List lllllllllllllIlllIIIIIlIllIlIIlI = new ArrayList();
        for (int lllllllllllllIlllIIIIIlIllIlIIIl = 0; lllllllllllllIlllIIIIIlIllIlIIIl < lllllllllllllIlllIIIIIlIllIIllII.length; ++lllllllllllllIlllIIIIIlIllIlIIIl) {
            final String lllllllllllllIlllIIIIIlIllIlIIII = lllllllllllllIlllIIIIIlIllIIllII[lllllllllllllIlllIIIIIlIllIlIIIl];
            if (!isLowercase(lllllllllllllIlllIIIIIlIllIlIIII)) {
                Config.warn(String.valueOf(new StringBuilder("Skipping non-lowercase path: ").append(lllllllllllllIlllIIIIIlIllIlIIII)));
            }
            else {
                final ResourceLocation lllllllllllllIlllIIIIIlIllIIllll = new ResourceLocation(lllllllllllllIlllIIIIIlIllIlIIII);
                if (lllllllllllllIlllIIIIIlIllIIllIl.resourceExists(lllllllllllllIlllIIIIIlIllIIllll)) {
                    lllllllllllllIlllIIIIIlIllIlIIlI.add(lllllllllllllIlllIIIIIlIllIlIIII);
                }
            }
        }
        final String[] lllllllllllllIlllIIIIIlIllIIlllI = lllllllllllllIlllIIIIIlIllIlIIlI.toArray(new String[lllllllllllllIlllIIIIIlIllIlIIlI.size()]);
        return lllllllllllllIlllIIIIIlIllIIlllI;
    }
    
    public static String[] collectFiles(final IResourcePack lllllllllllllIlllIIIIIlIlllllIlI, final String lllllllllllllIlllIIIIIlIlllllIIl, final String lllllllllllllIlllIIIIIlIlllllIII, final String[] lllllllllllllIlllIIIIIlIlllllIll) {
        return collectFiles(lllllllllllllIlllIIIIIlIlllllIlI, new String[] { lllllllllllllIlllIIIIIlIlllllIIl }, new String[] { lllllllllllllIlllIIIIIlIlllllIII }, lllllllllllllIlllIIIIIlIlllllIll);
    }
    
    private static String[] collectFilesZIP(final File lllllllllllllIlllIIIIIlIlIIlIlIl, final String[] lllllllllllllIlllIIIIIlIlIIIlIIl, final String[] lllllllllllllIlllIIIIIlIlIIlIIll) {
        final List lllllllllllllIlllIIIIIlIlIIlIIlI = new ArrayList();
        final String lllllllllllllIlllIIIIIlIlIIlIIIl = "assets/minecraft/";
        try {
            final ZipFile lllllllllllllIlllIIIIIlIlIIlIIII = new ZipFile(lllllllllllllIlllIIIIIlIlIIlIlIl);
            final Enumeration lllllllllllllIlllIIIIIlIlIIIllll = lllllllllllllIlllIIIIIlIlIIlIIII.entries();
            while (lllllllllllllIlllIIIIIlIlIIIllll.hasMoreElements()) {
                final ZipEntry lllllllllllllIlllIIIIIlIlIIIlllI = lllllllllllllIlllIIIIIlIlIIIllll.nextElement();
                String lllllllllllllIlllIIIIIlIlIIIllIl = lllllllllllllIlllIIIIIlIlIIIlllI.getName();
                if (lllllllllllllIlllIIIIIlIlIIIllIl.startsWith(lllllllllllllIlllIIIIIlIlIIlIIIl)) {
                    lllllllllllllIlllIIIIIlIlIIIllIl = lllllllllllllIlllIIIIIlIlIIIllIl.substring(lllllllllllllIlllIIIIIlIlIIlIIIl.length());
                    if (!StrUtils.startsWith(lllllllllllllIlllIIIIIlIlIIIllIl, lllllllllllllIlllIIIIIlIlIIIlIIl) || !StrUtils.endsWith(lllllllllllllIlllIIIIIlIlIIIllIl, lllllllllllllIlllIIIIIlIlIIlIIll)) {
                        continue;
                    }
                    if (!isLowercase(lllllllllllllIlllIIIIIlIlIIIllIl)) {
                        Config.warn(String.valueOf(new StringBuilder("Skipping non-lowercase path: ").append(lllllllllllllIlllIIIIIlIlIIIllIl)));
                    }
                    else {
                        lllllllllllllIlllIIIIIlIlIIlIIlI.add(lllllllllllllIlllIIIIIlIlIIIllIl);
                    }
                }
            }
            lllllllllllllIlllIIIIIlIlIIlIIII.close();
            final String[] lllllllllllllIlllIIIIIlIlIIIllII = lllllllllllllIlllIIIIIlIlIIlIIlI.toArray(new String[lllllllllllllIlllIIIIIlIlIIlIIlI.size()]);
            return lllllllllllllIlllIIIIIlIlIIIllII;
        }
        catch (IOException lllllllllllllIlllIIIIIlIlIIIlIll) {
            lllllllllllllIlllIIIIIlIlIIIlIll.printStackTrace();
            return new String[0];
        }
    }
}
