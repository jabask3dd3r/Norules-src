package optifine;

import net.minecraft.crash.*;
import net.minecraft.client.settings.*;
import java.util.*;
import shadersmod.client.*;

public class CrashReporter
{
    public static void onCrashReport(final CrashReport lllllllllllllIllIllIlIlllIIIIlIl, final CrashReportCategory lllllllllllllIllIllIlIllIllllIIl) {
        try {
            final GameSettings lllllllllllllIllIllIlIlllIIIIIll = Config.getGameSettings();
            if (lllllllllllllIllIllIlIlllIIIIIll == null) {
                return;
            }
            if (!lllllllllllllIllIllIlIlllIIIIIll.snooperEnabled) {
                return;
            }
            final Throwable lllllllllllllIllIllIlIlllIIIIIlI = lllllllllllllIllIllIlIlllIIIIlIl.getCrashCause();
            if (lllllllllllllIllIllIlIlllIIIIIlI == null) {
                return;
            }
            if (lllllllllllllIllIllIlIlllIIIIIlI.getClass() == Throwable.class) {
                return;
            }
            if (lllllllllllllIllIllIlIlllIIIIIlI.getClass().getName().contains(".fml.client.SplashProgress")) {
                return;
            }
            extendCrashReport(lllllllllllllIllIllIlIllIllllIIl);
            final String lllllllllllllIllIllIlIlllIIIIIIl = "http://optifine.net/crashReport";
            final String lllllllllllllIllIllIlIlllIIIIIII = makeReport(lllllllllllllIllIllIlIlllIIIIlIl);
            final byte[] lllllllllllllIllIllIlIllIlllllll = lllllllllllllIllIllIlIlllIIIIIII.getBytes("ASCII");
            final IFileUploadListener lllllllllllllIllIllIlIllIllllllI = new IFileUploadListener() {
                @Override
                public void fileUploadFinished(final String llllllllllllllIlIlIIIIIlllllIllI, final byte[] llllllllllllllIlIlIIIIIlllllIlIl, final Throwable llllllllllllllIlIlIIIIIlllllIlII) {
                }
            };
            final Map lllllllllllllIllIllIlIllIlllllIl = new HashMap();
            lllllllllllllIllIllIlIllIlllllIl.put("OF-Version", Config.getVersion());
            lllllllllllllIllIllIlIllIlllllIl.put("OF-Summary", makeSummary(lllllllllllllIllIllIlIlllIIIIlIl));
            final FileUploadThread lllllllllllllIllIllIlIllIlllllII = new FileUploadThread(lllllllllllllIllIllIlIlllIIIIIIl, lllllllllllllIllIllIlIllIlllllIl, lllllllllllllIllIllIlIllIlllllll, lllllllllllllIllIllIlIllIllllllI);
            lllllllllllllIllIllIlIllIlllllII.setPriority(10);
            lllllllllllllIllIllIlIllIlllllII.start();
            Thread.sleep(1000L);
        }
        catch (Exception lllllllllllllIllIllIlIllIllllIll) {
            Config.dbg(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIllIlIllIllllIll.getClass().getName())).append(": ").append(lllllllllllllIllIllIlIllIllllIll.getMessage())));
        }
    }
    
    private static String makeSummary(final CrashReport lllllllllllllIllIllIlIllIllIIIII) {
        final Throwable lllllllllllllIllIllIlIllIllIIlII = lllllllllllllIllIllIlIllIllIIIII.getCrashCause();
        if (lllllllllllllIllIllIlIllIllIIlII == null) {
            return "Unknown";
        }
        final StackTraceElement[] lllllllllllllIllIllIlIllIllIIIll = lllllllllllllIllIllIlIllIllIIlII.getStackTrace();
        String lllllllllllllIllIllIlIllIllIIIlI = "unknown";
        if (lllllllllllllIllIllIlIllIllIIIll.length > 0) {
            lllllllllllllIllIllIlIllIllIIIlI = lllllllllllllIllIllIlIllIllIIIll[0].toString().trim();
        }
        final String lllllllllllllIllIllIlIllIllIIIIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIllIllIlIllIllIIlII.getClass().getName())).append(": ").append(lllllllllllllIllIllIlIllIllIIlII.getMessage()).append(" (").append(lllllllllllllIllIllIlIllIllIIIII.getDescription()).append(") [").append(lllllllllllllIllIllIlIllIllIIIlI).append("]"));
        return lllllllllllllIllIllIlIllIllIIIIl;
    }
    
    private static String makeReport(final CrashReport lllllllllllllIllIllIlIllIllIlllI) {
        final StringBuffer lllllllllllllIllIllIlIllIllIllIl = new StringBuffer();
        lllllllllllllIllIllIlIllIllIllIl.append(String.valueOf(new StringBuilder("OptiFineVersion: ").append(Config.getVersion()).append("\n")));
        lllllllllllllIllIllIlIllIllIllIl.append(String.valueOf(new StringBuilder("Summary: ").append(makeSummary(lllllllllllllIllIllIlIllIllIlllI)).append("\n")));
        lllllllllllllIllIllIlIllIllIllIl.append("\n");
        lllllllllllllIllIllIlIllIllIllIl.append(lllllllllllllIllIllIlIllIllIlllI.getCompleteReport());
        lllllllllllllIllIllIlIllIllIllIl.append("\n");
        return lllllllllllllIllIllIlIllIllIllIl.toString();
    }
    
    public static void extendCrashReport(final CrashReportCategory lllllllllllllIllIllIlIllIlIllIIl) {
        lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("OptiFine Version", Config.getVersion());
        if (Config.getGameSettings() != null) {
            lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("Render Distance Chunks", String.valueOf(new StringBuilder().append(Config.getChunkViewDistance())));
            lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("Mipmaps", String.valueOf(new StringBuilder().append(Config.getMipmapLevels())));
            lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("Anisotropic Filtering", String.valueOf(new StringBuilder().append(Config.getAnisotropicFilterLevel())));
            lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("Antialiasing", String.valueOf(new StringBuilder().append(Config.getAntialiasingLevel())));
            lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("Multitexture", String.valueOf(new StringBuilder().append(Config.isMultiTexture())));
        }
        lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("Shaders", String.valueOf(new StringBuilder().append(Shaders.getShaderPackName())));
        lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("OpenGlVersion", String.valueOf(new StringBuilder().append(Config.openGlVersion)));
        lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("OpenGlRenderer", String.valueOf(new StringBuilder().append(Config.openGlRenderer)));
        lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("OpenGlVendor", String.valueOf(new StringBuilder().append(Config.openGlVendor)));
        lllllllllllllIllIllIlIllIlIllIIl.addCrashSection("CpuCount", String.valueOf(new StringBuilder().append(Config.getAvailableProcessors())));
    }
}
