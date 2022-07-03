package com.viaversion.viaversion.sponge.util;

import java.text.*;
import java.util.logging.*;

public class LoggerWrapper extends Logger
{
    private final /* synthetic */ org.slf4j.Logger base;
    
    @Override
    public void log(final Level lllllllllllllllIIllIlIlIlIlIIlll, final String lllllllllllllllIIllIlIlIlIlIIllI, final Object[] lllllllllllllllIIllIlIlIlIlIIIIl) {
        this.log(lllllllllllllllIIllIlIlIlIlIIlll, MessageFormat.format(lllllllllllllllIIllIlIlIlIlIIllI, lllllllllllllllIIllIlIlIlIlIIIIl));
    }
    
    @Override
    public void log(final Level lllllllllllllllIIllIlIlIlIllIIll, final String lllllllllllllllIIllIlIlIlIlIlllI, final Object lllllllllllllllIIllIlIlIlIllIIIl) {
        if (lllllllllllllllIIllIlIlIlIllIIll == Level.FINE) {
            this.base.debug(lllllllllllllllIIllIlIlIlIlIlllI, lllllllllllllllIIllIlIlIlIllIIIl);
        }
        else if (lllllllllllllllIIllIlIlIlIllIIll == Level.WARNING) {
            this.base.warn(lllllllllllllllIIllIlIlIlIlIlllI, lllllllllllllllIIllIlIlIlIllIIIl);
        }
        else if (lllllllllllllllIIllIlIlIlIllIIll == Level.SEVERE) {
            this.base.error(lllllllllllllllIIllIlIlIlIlIlllI, lllllllllllllllIIllIlIlIlIllIIIl);
        }
        else if (lllllllllllllllIIllIlIlIlIllIIll == Level.INFO) {
            this.base.info(lllllllllllllllIIllIlIlIlIlIlllI, lllllllllllllllIIllIlIlIlIllIIIl);
        }
        else {
            this.base.trace(lllllllllllllllIIllIlIlIlIlIlllI, lllllllllllllllIIllIlIlIlIllIIIl);
        }
    }
    
    public LoggerWrapper(final org.slf4j.Logger lllllllllllllllIIllIlIlIllIIlIlI) {
        super("logger", null);
        this.base = lllllllllllllllIIllIlIlIllIIlIlI;
    }
    
    @Override
    public void log(final Level lllllllllllllllIIllIlIlIlIlllIlI, final String lllllllllllllllIIllIlIlIlIlllIIl) {
        if (lllllllllllllllIIllIlIlIlIlllIlI == Level.FINE) {
            this.base.debug(lllllllllllllllIIllIlIlIlIlllIIl);
        }
        else if (lllllllllllllllIIllIlIlIlIlllIlI == Level.WARNING) {
            this.base.warn(lllllllllllllllIIllIlIlIlIlllIIl);
        }
        else if (lllllllllllllllIIllIlIlIlIlllIlI == Level.SEVERE) {
            this.base.error(lllllllllllllllIIllIlIlIlIlllIIl);
        }
        else if (lllllllllllllllIIllIlIlIlIlllIlI == Level.INFO) {
            this.base.info(lllllllllllllllIIllIlIlIlIlllIIl);
        }
        else {
            this.base.trace(lllllllllllllllIIllIlIlIlIlllIIl);
        }
    }
    
    @Override
    public void log(final Level lllllllllllllllIIllIlIlIlIIlIlll, final String lllllllllllllllIIllIlIlIlIIllIlI, final Throwable lllllllllllllllIIllIlIlIlIIlIlIl) {
        if (lllllllllllllllIIllIlIlIlIIlIlll == Level.FINE) {
            this.base.debug(lllllllllllllllIIllIlIlIlIIllIlI, lllllllllllllllIIllIlIlIlIIlIlIl);
        }
        else if (lllllllllllllllIIllIlIlIlIIlIlll == Level.WARNING) {
            this.base.warn(lllllllllllllllIIllIlIlIlIIllIlI, lllllllllllllllIIllIlIlIlIIlIlIl);
        }
        else if (lllllllllllllllIIllIlIlIlIIlIlll == Level.SEVERE) {
            this.base.error(lllllllllllllllIIllIlIlIlIIllIlI, lllllllllllllllIIllIlIlIlIIlIlIl);
        }
        else if (lllllllllllllllIIllIlIlIlIIlIlll == Level.INFO) {
            this.base.info(lllllllllllllllIIllIlIlIlIIllIlI, lllllllllllllllIIllIlIlIlIIlIlIl);
        }
        else {
            this.base.trace(lllllllllllllllIIllIlIlIlIIllIlI, lllllllllllllllIIllIlIlIlIIlIlIl);
        }
    }
    
    @Override
    public void log(final LogRecord lllllllllllllllIIllIlIlIllIIIIlI) {
        this.log(lllllllllllllllIIllIlIlIllIIIIlI.getLevel(), lllllllllllllllIIllIlIlIllIIIIlI.getMessage());
    }
}
