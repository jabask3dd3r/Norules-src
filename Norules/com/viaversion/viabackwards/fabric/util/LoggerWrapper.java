package com.viaversion.viabackwards.fabric.util;

import java.util.logging.*;
import java.text.*;

public class LoggerWrapper extends Logger
{
    private final /* synthetic */ org.apache.logging.log4j.Logger base;
    
    @Override
    public void log(final Level lllllllllllllIIIllllllIllllIIIlI, final String lllllllllllllIIIllllllIllllIIlIl, final Throwable lllllllllllllIIIllllllIllllIIlII) {
        if (lllllllllllllIIIllllllIllllIIIlI == Level.FINE) {
            this.base.debug(lllllllllllllIIIllllllIllllIIlIl, lllllllllllllIIIllllllIllllIIlII);
        }
        else if (lllllllllllllIIIllllllIllllIIIlI == Level.WARNING) {
            this.base.warn(lllllllllllllIIIllllllIllllIIlIl, lllllllllllllIIIllllllIllllIIlII);
        }
        else if (lllllllllllllIIIllllllIllllIIIlI == Level.SEVERE) {
            this.base.error(lllllllllllllIIIllllllIllllIIlIl, lllllllllllllIIIllllllIllllIIlII);
        }
        else if (lllllllllllllIIIllllllIllllIIIlI == Level.INFO) {
            this.base.info(lllllllllllllIIIllllllIllllIIlIl, lllllllllllllIIIllllllIllllIIlII);
        }
        else {
            this.base.trace(lllllllllllllIIIllllllIllllIIlIl, lllllllllllllIIIllllllIllllIIlII);
        }
    }
    
    public LoggerWrapper(final org.apache.logging.log4j.Logger lllllllllllllIIIlllllllIIIIlIIll) {
        super("logger", null);
        this.base = lllllllllllllIIIlllllllIIIIlIIll;
    }
    
    @Override
    public void log(final Level lllllllllllllIIIlllllllIIIIIlIII, final String lllllllllllllIIIlllllllIIIIIIlll) {
        if (lllllllllllllIIIlllllllIIIIIlIII == Level.FINE) {
            this.base.debug(lllllllllllllIIIlllllllIIIIIIlll);
        }
        else if (lllllllllllllIIIlllllllIIIIIlIII == Level.WARNING) {
            this.base.warn(lllllllllllllIIIlllllllIIIIIIlll);
        }
        else if (lllllllllllllIIIlllllllIIIIIlIII == Level.SEVERE) {
            this.base.error(lllllllllllllIIIlllllllIIIIIIlll);
        }
        else if (lllllllllllllIIIlllllllIIIIIlIII == Level.INFO) {
            this.base.info(lllllllllllllIIIlllllllIIIIIIlll);
        }
        else {
            this.base.trace(lllllllllllllIIIlllllllIIIIIIlll);
        }
    }
    
    @Override
    public void log(final LogRecord lllllllllllllIIIlllllllIIIIIllIl) {
        this.log(lllllllllllllIIIlllllllIIIIIllIl.getLevel(), lllllllllllllIIIlllllllIIIIIllIl.getMessage());
    }
    
    @Override
    public void log(final Level lllllllllllllIIIllllllIllllIlllI, final String lllllllllllllIIIllllllIllllIllIl, final Object[] lllllllllllllIIIllllllIllllIllII) {
        this.log(lllllllllllllIIIllllllIllllIlllI, MessageFormat.format(lllllllllllllIIIllllllIllllIllIl, lllllllllllllIIIllllllIllllIllII));
    }
    
    @Override
    public void log(final Level lllllllllllllIIIllllllIllllllIlI, final String lllllllllllllIIIllllllIlllllllIl, final Object lllllllllllllIIIllllllIllllllIII) {
        if (lllllllllllllIIIllllllIllllllIlI == Level.FINE) {
            this.base.debug(lllllllllllllIIIllllllIlllllllIl, lllllllllllllIIIllllllIllllllIII);
        }
        else if (lllllllllllllIIIllllllIllllllIlI == Level.WARNING) {
            this.base.warn(lllllllllllllIIIllllllIlllllllIl, lllllllllllllIIIllllllIllllllIII);
        }
        else if (lllllllllllllIIIllllllIllllllIlI == Level.SEVERE) {
            this.base.error(lllllllllllllIIIllllllIlllllllIl, lllllllllllllIIIllllllIllllllIII);
        }
        else if (lllllllllllllIIIllllllIllllllIlI == Level.INFO) {
            this.base.info(lllllllllllllIIIllllllIlllllllIl, lllllllllllllIIIllllllIllllllIII);
        }
        else {
            this.base.trace(lllllllllllllIIIllllllIlllllllIl, lllllllllllllIIIllllllIllllllIII);
        }
    }
}
