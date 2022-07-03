package net.minecraft.server;

import net.minecraft.util.*;
import java.io.*;

public class DebugLoggingPrintStream extends LoggingPrintStream
{
    public DebugLoggingPrintStream(final String lllllllllllllIlIIIlIlIlllIlIlIll, final OutputStream lllllllllllllIlIIIlIlIlllIlIlIlI) {
        super(lllllllllllllIlIIIlIlIlllIlIlIll, lllllllllllllIlIIIlIlIlllIlIlIlI);
    }
    
    @Override
    protected void logString(final String lllllllllllllIlIIIlIlIlllIlIIIIl) {
        final StackTraceElement[] lllllllllllllIlIIIlIlIlllIlIIIII = Thread.currentThread().getStackTrace();
        final StackTraceElement lllllllllllllIlIIIlIlIlllIIlllll = lllllllllllllIlIIIlIlIlllIlIIIII[Math.min(3, lllllllllllllIlIIIlIlIlllIlIIIII.length)];
        DebugLoggingPrintStream.LOGGER.info("[{}]@.({}:{}): {}", (Object)this.domain, (Object)lllllllllllllIlIIIlIlIlllIIlllll.getFileName(), (Object)lllllllllllllIlIIIlIlIlllIIlllll.getLineNumber(), (Object)lllllllllllllIlIIIlIlIlllIlIIIIl);
    }
}
