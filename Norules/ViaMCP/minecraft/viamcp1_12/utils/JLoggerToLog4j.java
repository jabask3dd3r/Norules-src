package ViaMCP.minecraft.viamcp1_12.utils;

import java.text.*;
import java.util.logging.*;

public class JLoggerToLog4j extends Logger
{
    private final /* synthetic */ org.apache.logging.log4j.Logger base;
    
    public JLoggerToLog4j(final org.apache.logging.log4j.Logger lllllllllllllIlIIIlIllIIIllIIIlI) {
        super("logger", null);
        this.base = lllllllllllllIlIIIlIllIIIllIIIlI;
    }
    
    @Override
    public void log(final Level lllllllllllllIlIIIlIllIIIIllllll, final String lllllllllllllIlIIIlIllIIIIlllIlI, final Object[] lllllllllllllIlIIIlIllIIIIlllIIl) {
        this.log(lllllllllllllIlIIIlIllIIIIllllll, MessageFormat.format(lllllllllllllIlIIIlIllIIIIlllIlI, lllllllllllllIlIIIlIllIIIIlllIIl));
    }
    
    @Override
    public void log(final Level lllllllllllllIlIIIlIllIIIlIIIlll, final String lllllllllllllIlIIIlIllIIIlIIIllI, final Object lllllllllllllIlIIIlIllIIIlIIlIIl) {
        if (lllllllllllllIlIIIlIllIIIlIIIlll == Level.FINE) {
            this.base.debug(lllllllllllllIlIIIlIllIIIlIIIllI, lllllllllllllIlIIIlIllIIIlIIlIIl);
        }
        else if (lllllllllllllIlIIIlIllIIIlIIIlll == Level.WARNING) {
            this.base.warn(lllllllllllllIlIIIlIllIIIlIIIllI, lllllllllllllIlIIIlIllIIIlIIlIIl);
        }
        else if (lllllllllllllIlIIIlIllIIIlIIIlll == Level.SEVERE) {
            this.base.error(lllllllllllllIlIIIlIllIIIlIIIllI, lllllllllllllIlIIIlIllIIIlIIlIIl);
        }
        else if (lllllllllllllIlIIIlIllIIIlIIIlll == Level.INFO) {
            this.base.info(lllllllllllllIlIIIlIllIIIlIIIllI, lllllllllllllIlIIIlIllIIIlIIlIIl);
        }
        else {
            this.base.trace(lllllllllllllIlIIIlIllIIIlIIIllI, lllllllllllllIlIIIlIllIIIlIIlIIl);
        }
    }
    
    @Override
    public void log(final Level lllllllllllllIlIIIlIllIIIIlIllll, final String lllllllllllllIlIIIlIllIIIIllIIlI, final Throwable lllllllllllllIlIIIlIllIIIIlIllIl) {
        if (lllllllllllllIlIIIlIllIIIIlIllll == Level.FINE) {
            this.base.debug(lllllllllllllIlIIIlIllIIIIllIIlI, lllllllllllllIlIIIlIllIIIIlIllIl);
        }
        else if (lllllllllllllIlIIIlIllIIIIlIllll == Level.WARNING) {
            this.base.warn(lllllllllllllIlIIIlIllIIIIllIIlI, lllllllllllllIlIIIlIllIIIIlIllIl);
        }
        else if (lllllllllllllIlIIIlIllIIIIlIllll == Level.SEVERE) {
            this.base.error(lllllllllllllIlIIIlIllIIIIllIIlI, lllllllllllllIlIIIlIllIIIIlIllIl);
        }
        else if (lllllllllllllIlIIIlIllIIIIlIllll == Level.INFO) {
            this.base.info(lllllllllllllIlIIIlIllIIIIllIIlI, lllllllllllllIlIIIlIllIIIIlIllIl);
        }
        else {
            this.base.trace(lllllllllllllIlIIIlIllIIIIllIIlI, lllllllllllllIlIIIlIllIIIIlIllIl);
        }
    }
    
    @Override
    public void log(final Level lllllllllllllIlIIIlIllIIIlIlIlIl, final String lllllllllllllIlIIIlIllIIIlIlIlII) {
        if (lllllllllllllIlIIIlIllIIIlIlIlIl == Level.FINE) {
            this.base.debug(lllllllllllllIlIIIlIllIIIlIlIlII);
        }
        else if (lllllllllllllIlIIIlIllIIIlIlIlIl == Level.WARNING) {
            this.base.warn(lllllllllllllIlIIIlIllIIIlIlIlII);
        }
        else if (lllllllllllllIlIIIlIllIIIlIlIlIl == Level.SEVERE) {
            this.base.error(lllllllllllllIlIIIlIllIIIlIlIlII);
        }
        else if (lllllllllllllIlIIIlIllIIIlIlIlIl == Level.INFO) {
            this.base.info(lllllllllllllIlIIIlIllIIIlIlIlII);
        }
        else {
            this.base.trace(lllllllllllllIlIIIlIllIIIlIlIlII);
        }
    }
    
    @Override
    public void log(final LogRecord lllllllllllllIlIIIlIllIIIlIlllII) {
        this.log(lllllllllllllIlIIIlIllIIIlIlllII.getLevel(), lllllllllllllIlIIIlIllIIIlIlllII.getMessage());
    }
}
