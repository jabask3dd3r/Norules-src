package net.minecraft.util;

import java.io.*;
import org.apache.logging.log4j.*;

public class LoggingPrintStream extends PrintStream
{
    protected final /* synthetic */ String domain;
    protected static final /* synthetic */ Logger LOGGER;
    
    @Override
    public void println(final Object lllllllllllllIIlIIlIIIIlIIIIlIll) {
        this.logString(String.valueOf(lllllllllllllIIlIIlIIIIlIIIIlIll));
    }
    
    public LoggingPrintStream(final String lllllllllllllIIlIIlIIIIlIIIllIII, final OutputStream lllllllllllllIIlIIlIIIIlIIIlIlll) {
        super(lllllllllllllIIlIIlIIIIlIIIlIlll);
        this.domain = lllllllllllllIIlIIlIIIIlIIIllIII;
    }
    
    protected void logString(final String lllllllllllllIIlIIlIIIIlIIIIIlll) {
        LoggingPrintStream.LOGGER.info("[{}]: {}", (Object)this.domain, (Object)lllllllllllllIIlIIlIIIIlIIIIIlll);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    @Override
    public void println(final String lllllllllllllIIlIIlIIIIlIIIlIIll) {
        this.logString(lllllllllllllIIlIIlIIIIlIIIlIIll);
    }
}
