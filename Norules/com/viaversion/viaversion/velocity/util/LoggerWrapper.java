package com.viaversion.viaversion.velocity.util;

import java.util.logging.*;
import java.text.*;

public class LoggerWrapper extends Logger
{
    private final /* synthetic */ org.slf4j.Logger base;
    
    public LoggerWrapper(final org.slf4j.Logger lllllllllllllIlIlIIlIlIIIIlIllll) {
        super("logger", null);
        this.base = lllllllllllllIlIlIIlIlIIIIlIllll;
    }
    
    @Override
    public void log(final Level lllllllllllllIlIlIIlIIllllllllII, final String lllllllllllllIlIlIIlIIllllllllll, final Throwable lllllllllllllIlIlIIlIIlllllllIlI) {
        if (lllllllllllllIlIlIIlIIllllllllII == Level.FINE) {
            this.base.debug(lllllllllllllIlIlIIlIIllllllllll, lllllllllllllIlIlIIlIIlllllllIlI);
        }
        else if (lllllllllllllIlIlIIlIIllllllllII == Level.WARNING) {
            this.base.warn(lllllllllllllIlIlIIlIIllllllllll, lllllllllllllIlIlIIlIIlllllllIlI);
        }
        else if (lllllllllllllIlIlIIlIIllllllllII == Level.SEVERE) {
            this.base.error(lllllllllllllIlIlIIlIIllllllllll, lllllllllllllIlIlIIlIIlllllllIlI);
        }
        else if (lllllllllllllIlIlIIlIIllllllllII == Level.INFO) {
            this.base.info(lllllllllllllIlIlIIlIIllllllllll, lllllllllllllIlIlIIlIIlllllllIlI);
        }
        else {
            this.base.trace(lllllllllllllIlIlIIlIIllllllllll, lllllllllllllIlIlIIlIIlllllllIlI);
        }
    }
    
    @Override
    public void log(final LogRecord lllllllllllllIlIlIIlIlIIIIlIlIIl) {
        this.log(lllllllllllllIlIlIIlIlIIIIlIlIIl.getLevel(), lllllllllllllIlIlIIlIlIIIIlIlIIl.getMessage());
    }
    
    @Override
    public void log(final Level lllllllllllllIlIlIIlIlIIIIIllIII, final String lllllllllllllIlIlIIlIlIIIIIlIIll, final Object lllllllllllllIlIlIIlIlIIIIIlIIlI) {
        if (lllllllllllllIlIlIIlIlIIIIIllIII == Level.FINE) {
            this.base.debug(lllllllllllllIlIlIIlIlIIIIIlIIll, lllllllllllllIlIlIIlIlIIIIIlIIlI);
        }
        else if (lllllllllllllIlIlIIlIlIIIIIllIII == Level.WARNING) {
            this.base.warn(lllllllllllllIlIlIIlIlIIIIIlIIll, lllllllllllllIlIlIIlIlIIIIIlIIlI);
        }
        else if (lllllllllllllIlIlIIlIlIIIIIllIII == Level.SEVERE) {
            this.base.error(lllllllllllllIlIlIIlIlIIIIIlIIll, lllllllllllllIlIlIIlIlIIIIIlIIlI);
        }
        else if (lllllllllllllIlIlIIlIlIIIIIllIII == Level.INFO) {
            this.base.info(lllllllllllllIlIlIIlIlIIIIIlIIll, lllllllllllllIlIlIIlIlIIIIIlIIlI);
        }
        else {
            this.base.trace(lllllllllllllIlIlIIlIlIIIIIlIIll, lllllllllllllIlIlIIlIlIIIIIlIIlI);
        }
    }
    
    @Override
    public void log(final Level lllllllllllllIlIlIIlIlIIIIlIIIlI, final String lllllllllllllIlIlIIlIlIIIIIllllI) {
        if (lllllllllllllIlIlIIlIlIIIIlIIIlI == Level.FINE) {
            this.base.debug(lllllllllllllIlIlIIlIlIIIIIllllI);
        }
        else if (lllllllllllllIlIlIIlIlIIIIlIIIlI == Level.WARNING) {
            this.base.warn(lllllllllllllIlIlIIlIlIIIIIllllI);
        }
        else if (lllllllllllllIlIlIIlIlIIIIlIIIlI == Level.SEVERE) {
            this.base.error(lllllllllllllIlIlIIlIlIIIIIllllI);
        }
        else if (lllllllllllllIlIlIIlIlIIIIlIIIlI == Level.INFO) {
            this.base.info(lllllllllllllIlIlIIlIlIIIIIllllI);
        }
        else {
            this.base.trace(lllllllllllllIlIlIIlIlIIIIIllllI);
        }
    }
    
    @Override
    public void log(final Level lllllllllllllIlIlIIlIlIIIIIIllII, final String lllllllllllllIlIlIIlIlIIIIIIlIll, final Object[] lllllllllllllIlIlIIlIlIIIIIIlIlI) {
        this.log(lllllllllllllIlIlIIlIlIIIIIIllII, MessageFormat.format(lllllllllllllIlIlIIlIlIIIIIIlIll, lllllllllllllIlIlIIlIlIIIIIIlIlI));
    }
}
