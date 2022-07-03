package shadersmod.common;

import org.apache.logging.log4j.*;

public abstract class SMCLog
{
    private static final /* synthetic */ Logger LOGGER;
    
    static {
        PREFIX = "[Shaders] ";
        LOGGER = LogManager.getLogger();
    }
    
    public static void fine(final String llllllllllllIlllllIIllIIIIIIIIIl, final Object... llllllllllllIlllllIIllIIIIIIIIll) {
        final String llllllllllllIlllllIIllIIIIIIIIlI = String.format(llllllllllllIlllllIIllIIIIIIIIIl, llllllllllllIlllllIIllIIIIIIIIll);
        SMCLog.LOGGER.debug(String.valueOf(new StringBuilder("[Shaders] ").append(llllllllllllIlllllIIllIIIIIIIIlI)));
    }
    
    public static void warning(final String llllllllllllIlllllIIllIIIIlIlIIl) {
        SMCLog.LOGGER.warn(String.valueOf(new StringBuilder("[Shaders] ").append(llllllllllllIlllllIIllIIIIlIlIIl)));
    }
    
    public static void severe(final String llllllllllllIlllllIIllIIIIIlllII, final Object... llllllllllllIlllllIIllIIIIIllIll) {
        final String llllllllllllIlllllIIllIIIIIlllIl = String.format(llllllllllllIlllllIIllIIIIIlllII, llllllllllllIlllllIIllIIIIIllIll);
        SMCLog.LOGGER.error(String.valueOf(new StringBuilder("[Shaders] ").append(llllllllllllIlllllIIllIIIIIlllIl)));
    }
    
    public static void fine(final String llllllllllllIlllllIIllIIIIlIIIll) {
        SMCLog.LOGGER.debug(String.valueOf(new StringBuilder("[Shaders] ").append(llllllllllllIlllllIIllIIIIlIIIll)));
    }
    
    public static void warning(final String llllllllllllIlllllIIllIIIIIlIIll, final Object... llllllllllllIlllllIIllIIIIIlIIlI) {
        final String llllllllllllIlllllIIllIIIIIlIlII = String.format(llllllllllllIlllllIIllIIIIIlIIll, llllllllllllIlllllIIllIIIIIlIIlI);
        SMCLog.LOGGER.warn(String.valueOf(new StringBuilder("[Shaders] ").append(llllllllllllIlllllIIllIIIIIlIlII)));
    }
    
    public static void severe(final String llllllllllllIlllllIIllIIIIlIllII) {
        SMCLog.LOGGER.error(String.valueOf(new StringBuilder("[Shaders] ").append(llllllllllllIlllllIIllIIIIlIllII)));
    }
    
    public static void info(final String llllllllllllIlllllIIllIIIIIIlIlI, final Object... llllllllllllIlllllIIllIIIIIIllII) {
        final String llllllllllllIlllllIIllIIIIIIlIll = String.format(llllllllllllIlllllIIllIIIIIIlIlI, llllllllllllIlllllIIllIIIIIIllII);
        SMCLog.LOGGER.info(String.valueOf(new StringBuilder("[Shaders] ").append(llllllllllllIlllllIIllIIIIIIlIll)));
    }
    
    public static void info(final String llllllllllllIlllllIIllIIIIlIIllI) {
        SMCLog.LOGGER.info(String.valueOf(new StringBuilder("[Shaders] ").append(llllllllllllIlllllIIllIIIIlIIllI)));
    }
}
