package optifine;

import net.minecraft.util.*;
import java.util.*;
import java.io.*;

public class CustomPanorama
{
    private static /* synthetic */ CustomPanoramaProperties customPanoramaProperties;
    private static final /* synthetic */ Random random;
    
    public static void update() {
        CustomPanorama.customPanoramaProperties = null;
        final String[] lllllllllllllIlIIIllIllIIllIIlll = getPanoramaFolders();
        if (lllllllllllllIlIIIllIllIIllIIlll.length > 1) {
            final Properties[] lllllllllllllIlIIIllIllIIllIIllI = getPanoramaProperties(lllllllllllllIlIIIllIllIIllIIlll);
            final int[] lllllllllllllIlIIIllIllIIllIIlIl = getWeights(lllllllllllllIlIIIllIllIIllIIllI);
            final int lllllllllllllIlIIIllIllIIllIIlII = getRandomIndex(lllllllllllllIlIIIllIllIIllIIlIl);
            final String lllllllllllllIlIIIllIllIIllIIIll = lllllllllllllIlIIIllIllIIllIIlll[lllllllllllllIlIIIllIllIIllIIlII];
            Properties lllllllllllllIlIIIllIllIIllIIIlI = lllllllllllllIlIIIllIllIIllIIllI[lllllllllllllIlIIIllIllIIllIIlII];
            if (lllllllllllllIlIIIllIllIIllIIIlI == null) {
                lllllllllllllIlIIIllIllIIllIIIlI = lllllllllllllIlIIIllIllIIllIIllI[0];
            }
            if (lllllllllllllIlIIIllIllIIllIIIlI == null) {
                lllllllllllllIlIIIllIllIIllIIIlI = new Properties();
            }
            final CustomPanoramaProperties lllllllllllllIlIIIllIllIIllIIIIl = CustomPanorama.customPanoramaProperties = new CustomPanoramaProperties(lllllllllllllIlIIIllIllIIllIIIll, lllllllllllllIlIIIllIllIIllIIIlI);
        }
    }
    
    public static CustomPanoramaProperties getCustomPanoramaProperties() {
        return CustomPanorama.customPanoramaProperties;
    }
    
    static {
        CustomPanorama.customPanoramaProperties = null;
        random = new Random();
    }
    
    private static int[] getWeights(final Properties[] lllllllllllllIlIIIllIllIIIlIlIlI) {
        final int[] lllllllllllllIlIIIllIllIIIlIlllI = new int[lllllllllllllIlIIIllIllIIIlIlIlI.length];
        for (int lllllllllllllIlIIIllIllIIIlIllIl = 0; lllllllllllllIlIIIllIllIIIlIllIl < lllllllllllllIlIIIllIllIIIlIlllI.length; ++lllllllllllllIlIIIllIllIIIlIllIl) {
            Properties lllllllllllllIlIIIllIllIIIlIllII = lllllllllllllIlIIIllIllIIIlIlIlI[lllllllllllllIlIIIllIllIIIlIllIl];
            if (lllllllllllllIlIIIllIllIIIlIllII == null) {
                lllllllllllllIlIIIllIllIIIlIllII = lllllllllllllIlIIIllIllIIIlIlIlI[0];
            }
            if (lllllllllllllIlIIIllIllIIIlIllII == null) {
                lllllllllllllIlIIIllIllIIIlIlllI[lllllllllllllIlIIIllIllIIIlIllIl] = 1;
            }
            else {
                final String lllllllllllllIlIIIllIllIIIlIlIll = lllllllllllllIlIIIllIllIIIlIllII.getProperty("weight", null);
                lllllllllllllIlIIIllIllIIIlIlllI[lllllllllllllIlIIIllIllIIIlIllIl] = Config.parseInt(lllllllllllllIlIIIllIllIIIlIlIll, 1);
            }
        }
        return lllllllllllllIlIIIllIllIIIlIlllI;
    }
    
    private static String[] getPanoramaFolders() {
        final List<String> lllllllllllllIlIIIllIllIIlIlIlII = new ArrayList<String>();
        lllllllllllllIlIIIllIllIIlIlIlII.add("textures/gui/title/background");
        for (int lllllllllllllIlIIIllIllIIlIlIIll = 0; lllllllllllllIlIIIllIllIIlIlIIll < 100; ++lllllllllllllIlIIIllIllIIlIlIIll) {
            final String lllllllllllllIlIIIllIllIIlIlIIlI = String.valueOf(new StringBuilder("optifine/gui/background").append(lllllllllllllIlIIIllIllIIlIlIIll));
            final String lllllllllllllIlIIIllIllIIlIlIIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIllIllIIlIlIIlI)).append("/panorama_0.png"));
            final ResourceLocation lllllllllllllIlIIIllIllIIlIlIIII = new ResourceLocation(lllllllllllllIlIIIllIllIIlIlIIIl);
            if (Config.hasResource(lllllllllllllIlIIIllIllIIlIlIIII)) {
                lllllllllllllIlIIIllIllIIlIlIlII.add(lllllllllllllIlIIIllIllIIlIlIIlI);
            }
        }
        final String[] lllllllllllllIlIIIllIllIIlIIllll = lllllllllllllIlIIIllIllIIlIlIlII.toArray(new String[lllllllllllllIlIIIllIllIIlIlIlII.size()]);
        return lllllllllllllIlIIIllIllIIlIIllll;
    }
    
    private static Properties[] getPanoramaProperties(final String[] lllllllllllllIlIIIllIllIIIlllIll) {
        final Properties[] lllllllllllllIlIIIllIllIIlIIIIIl = new Properties[lllllllllllllIlIIIllIllIIIlllIll.length];
        for (int lllllllllllllIlIIIllIllIIlIIIIII = 0; lllllllllllllIlIIIllIllIIlIIIIII < lllllllllllllIlIIIllIllIIIlllIll.length; ++lllllllllllllIlIIIllIllIIlIIIIII) {
            String lllllllllllllIlIIIllIllIIIllllll = lllllllllllllIlIIIllIllIIIlllIll[lllllllllllllIlIIIllIllIIlIIIIII];
            if (lllllllllllllIlIIIllIllIIlIIIIII == 0) {
                lllllllllllllIlIIIllIllIIIllllll = "optifine/gui";
            }
            else {
                Config.dbg(String.valueOf(new StringBuilder("CustomPanorama: ").append(lllllllllllllIlIIIllIllIIIllllll)));
            }
            final ResourceLocation lllllllllllllIlIIIllIllIIIlllllI = new ResourceLocation(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIIIllIllIIIllllll)).append("/background.properties")));
            try {
                final InputStream lllllllllllllIlIIIllIllIIIllllIl = Config.getResourceStream(lllllllllllllIlIIIllIllIIIlllllI);
                if (lllllllllllllIlIIIllIllIIIllllIl != null) {
                    final Properties lllllllllllllIlIIIllIllIIIllllII = new Properties();
                    lllllllllllllIlIIIllIllIIIllllII.load(lllllllllllllIlIIIllIllIIIllllIl);
                    Config.dbg(String.valueOf(new StringBuilder("CustomPanorama: ").append(lllllllllllllIlIIIllIllIIIlllllI.getResourcePath())));
                    lllllllllllllIlIIIllIllIIlIIIIIl[lllllllllllllIlIIIllIllIIlIIIIII] = lllllllllllllIlIIIllIllIIIllllII;
                    lllllllllllllIlIIIllIllIIIllllIl.close();
                }
            }
            catch (IOException ex) {}
        }
        return lllllllllllllIlIIIllIllIIlIIIIIl;
    }
    
    private static int getRandomIndex(final int[] lllllllllllllIlIIIllIllIIIlIIIII) {
        final int lllllllllllllIlIIIllIllIIIIlllll = MathUtils.getSum(lllllllllllllIlIIIllIllIIIlIIIII);
        final int lllllllllllllIlIIIllIllIIIIllllI = CustomPanorama.random.nextInt(lllllllllllllIlIIIllIllIIIIlllll);
        int lllllllllllllIlIIIllIllIIIIlllIl = 0;
        for (int lllllllllllllIlIIIllIllIIIIlllII = 0; lllllllllllllIlIIIllIllIIIIlllII < lllllllllllllIlIIIllIllIIIlIIIII.length; ++lllllllllllllIlIIIllIllIIIIlllII) {
            lllllllllllllIlIIIllIllIIIIlllIl += lllllllllllllIlIIIllIllIIIlIIIII[lllllllllllllIlIIIllIllIIIIlllII];
            if (lllllllllllllIlIIIllIllIIIIlllIl > lllllllllllllIlIIIllIllIIIIllllI) {
                return lllllllllllllIlIIIllIllIIIIlllII;
            }
        }
        return lllllllllllllIlIIIllIllIIIlIIIII.length - 1;
    }
}
