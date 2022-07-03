package optifine;

import java.net.*;
import net.minecraft.client.*;
import java.io.*;

public class VersionCheckThread extends Thread
{
    @Override
    public void run() {
        HttpURLConnection lllllllllllllIIIlIlIIIlllIlIIlll = null;
        try {
            Config.dbg("Checking for new version");
            final URL lllllllllllllIIIlIlIIIlllIlIIllI = new URL("http://optifine.net/version/1.12.2/HD_U.txt");
            lllllllllllllIIIlIlIIIlllIlIIlll = (HttpURLConnection)lllllllllllllIIIlIlIIIlllIlIIllI.openConnection();
            if (Config.getGameSettings().snooperEnabled) {
                lllllllllllllIIIlIlIIIlllIlIIlll.setRequestProperty("OF-MC-Version", "1.12.2");
                lllllllllllllIIIlIlIIIlllIlIIlll.setRequestProperty("OF-MC-Brand", String.valueOf(new StringBuilder().append(ClientBrandRetriever.getClientModName())));
                lllllllllllllIIIlIlIIIlllIlIIlll.setRequestProperty("OF-Edition", "HD_U");
                lllllllllllllIIIlIlIIIlllIlIIlll.setRequestProperty("OF-Release", "C6");
                lllllllllllllIIIlIlIIIlllIlIIlll.setRequestProperty("OF-Java-Version", String.valueOf(new StringBuilder().append(System.getProperty("java.version"))));
                lllllllllllllIIIlIlIIIlllIlIIlll.setRequestProperty("OF-CpuCount", String.valueOf(new StringBuilder().append(Config.getAvailableProcessors())));
                lllllllllllllIIIlIlIIIlllIlIIlll.setRequestProperty("OF-OpenGL-Version", String.valueOf(new StringBuilder().append(Config.openGlVersion)));
                lllllllllllllIIIlIlIIIlllIlIIlll.setRequestProperty("OF-OpenGL-Vendor", String.valueOf(new StringBuilder().append(Config.openGlVendor)));
            }
            lllllllllllllIIIlIlIIIlllIlIIlll.setDoInput(true);
            lllllllllllllIIIlIlIIIlllIlIIlll.setDoOutput(false);
            lllllllllllllIIIlIlIIIlllIlIIlll.connect();
            try {
                final InputStream lllllllllllllIIIlIlIIIlllIlIIlIl = lllllllllllllIIIlIlIIIlllIlIIlll.getInputStream();
                final String lllllllllllllIIIlIlIIIlllIlIIlII = Config.readInputStream(lllllllllllllIIIlIlIIIlllIlIIlIl);
                lllllllllllllIIIlIlIIIlllIlIIlIl.close();
                final String[] lllllllllllllIIIlIlIIIlllIlIIIll = Config.tokenize(lllllllllllllIIIlIlIIIlllIlIIlII, "\n\r");
                if (lllllllllllllIIIlIlIIIlllIlIIIll.length >= 1) {
                    final String lllllllllllllIIIlIlIIIlllIlIIIlI = lllllllllllllIIIlIlIIIlllIlIIIll[0].trim();
                    Config.dbg(String.valueOf(new StringBuilder("Version found: ").append(lllllllllllllIIIlIlIIIlllIlIIIlI)));
                    if (Config.compareRelease(lllllllllllllIIIlIlIIIlllIlIIIlI, "C6") <= 0) {
                        return;
                    }
                    Config.setNewRelease(lllllllllllllIIIlIlIIIlllIlIIIlI);
                    return;
                }
            }
            finally {
                if (lllllllllllllIIIlIlIIIlllIlIIlll != null) {
                    lllllllllllllIIIlIlIIIlllIlIIlll.disconnect();
                }
            }
            if (lllllllllllllIIIlIlIIIlllIlIIlll != null) {
                lllllllllllllIIIlIlIIIlllIlIIlll.disconnect();
            }
        }
        catch (Exception lllllllllllllIIIlIlIIIlllIlIIIIl) {
            Config.dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIlIlIIIlllIlIIIIl.getClass().getName())).append(": ").append(lllllllllllllIIIlIlIIIlllIlIIIIl.getMessage())));
        }
    }
}
