package net.minecraft.util;

import java.util.*;
import org.apache.logging.log4j.*;
import java.util.concurrent.*;
import javax.annotation.*;

public class Util
{
    public static EnumOS getOSType() {
        final String lllllllllllllIIIllIllIllIIIIlIIl = System.getProperty("os.name").toLowerCase(Locale.ROOT);
        if (lllllllllllllIIIllIllIllIIIIlIIl.contains("win")) {
            return EnumOS.WINDOWS;
        }
        if (lllllllllllllIIIllIllIllIIIIlIIl.contains("mac")) {
            return EnumOS.OSX;
        }
        if (lllllllllllllIIIllIllIllIIIIlIIl.contains("solaris")) {
            return EnumOS.SOLARIS;
        }
        if (lllllllllllllIIIllIllIllIIIIlIIl.contains("sunos")) {
            return EnumOS.SOLARIS;
        }
        if (lllllllllllllIIIllIllIllIIIIlIIl.contains("linux")) {
            return EnumOS.LINUX;
        }
        return lllllllllllllIIIllIllIllIIIIlIIl.contains("unix") ? EnumOS.LINUX : EnumOS.UNKNOWN;
    }
    
    public static <T> T getLastElement(final List<T> lllllllllllllIIIllIllIlIllllllII) {
        return lllllllllllllIIIllIllIlIllllllII.get(lllllllllllllIIIllIllIlIllllllII.size() - 1);
    }
    
    @Nullable
    public static <V> V runTask(final FutureTask<V> lllllllllllllIIIllIllIllIIIIIIII, final Logger lllllllllllllIIIllIllIllIIIIIIll) {
        try {
            lllllllllllllIIIllIllIllIIIIIIII.run();
            return lllllllllllllIIIllIllIllIIIIIIII.get();
        }
        catch (ExecutionException lllllllllllllIIIllIllIllIIIIIIlI) {
            lllllllllllllIIIllIllIllIIIIIIll.fatal("Error executing task", (Throwable)lllllllllllllIIIllIllIllIIIIIIlI);
        }
        catch (InterruptedException lllllllllllllIIIllIllIllIIIIIIIl) {
            lllllllllllllIIIllIllIllIIIIIIll.fatal("Error executing task", (Throwable)lllllllllllllIIIllIllIllIIIIIIIl);
        }
        return null;
    }
    
    public enum EnumOS
    {
        SOLARIS("SOLARIS", 1), 
        WINDOWS("WINDOWS", 2), 
        UNKNOWN("UNKNOWN", 4), 
        OSX("OSX", 3), 
        LINUX("LINUX", 0);
        
        private EnumOS(final String lllllllllllllIIIIIlllIIIIlIllIII, final int lllllllllllllIIIIIlllIIIIlIlIlll) {
        }
    }
}
