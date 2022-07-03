package de.gerrygames.viarewind.fabric.util;

import java.util.logging.*;
import java.text.*;

public class LoggerWrapper extends Logger
{
    private final /* synthetic */ org.apache.logging.log4j.Logger base;
    
    public LoggerWrapper(final org.apache.logging.log4j.Logger llllllllllllllIIlIIIIllllllIllII) {
        super("logger", null);
        this.base = llllllllllllllIIlIIIIllllllIllII;
    }
    
    @Override
    public void log(final Level llllllllllllllIIlIIIIlllllIlllII, final String llllllllllllllIIlIIIIlllllIllllI) {
        if (llllllllllllllIIlIIIIlllllIlllII == Level.FINE) {
            this.base.debug(llllllllllllllIIlIIIIlllllIllllI);
        }
        else if (llllllllllllllIIlIIIIlllllIlllII == Level.WARNING) {
            this.base.warn(llllllllllllllIIlIIIIlllllIllllI);
        }
        else if (llllllllllllllIIlIIIIlllllIlllII == Level.SEVERE) {
            this.base.error(llllllllllllllIIlIIIIlllllIllllI);
        }
        else if (llllllllllllllIIlIIIIlllllIlllII == Level.INFO) {
            this.base.info(llllllllllllllIIlIIIIlllllIllllI);
        }
        else {
            this.base.trace(llllllllllllllIIlIIIIlllllIllllI);
        }
    }
    
    @Override
    public void log(final Level llllllllllllllIIlIIIIlllllIlIIIl, final String llllllllllllllIIlIIIIlllllIlIlII, final Object llllllllllllllIIlIIIIlllllIIllll) {
        if (llllllllllllllIIlIIIIlllllIlIIIl == Level.FINE) {
            this.base.debug(llllllllllllllIIlIIIIlllllIlIlII, llllllllllllllIIlIIIIlllllIIllll);
        }
        else if (llllllllllllllIIlIIIIlllllIlIIIl == Level.WARNING) {
            this.base.warn(llllllllllllllIIlIIIIlllllIlIlII, llllllllllllllIIlIIIIlllllIIllll);
        }
        else if (llllllllllllllIIlIIIIlllllIlIIIl == Level.SEVERE) {
            this.base.error(llllllllllllllIIlIIIIlllllIlIlII, llllllllllllllIIlIIIIlllllIIllll);
        }
        else if (llllllllllllllIIlIIIIlllllIlIIIl == Level.INFO) {
            this.base.info(llllllllllllllIIlIIIIlllllIlIlII, llllllllllllllIIlIIIIlllllIIllll);
        }
        else {
            this.base.trace(llllllllllllllIIlIIIIlllllIlIlII, llllllllllllllIIlIIIIlllllIIllll);
        }
    }
    
    @Override
    public void log(final LogRecord llllllllllllllIIlIIIIllllllIIllI) {
        this.log(llllllllllllllIIlIIIIllllllIIllI.getLevel(), llllllllllllllIIlIIIIllllllIIllI.getMessage());
    }
    
    @Override
    public void log(final Level llllllllllllllIIlIIIIlllllIIlIIl, final String llllllllllllllIIlIIIIlllllIIIlII, final Object[] llllllllllllllIIlIIIIlllllIIIIll) {
        this.log(llllllllllllllIIlIIIIlllllIIlIIl, MessageFormat.format(llllllllllllllIIlIIIIlllllIIIlII, llllllllllllllIIlIIIIlllllIIIIll));
    }
    
    @Override
    public void log(final Level llllllllllllllIIlIIIIllllIlllIIl, final String llllllllllllllIIlIIIIllllIlllIII, final Throwable llllllllllllllIIlIIIIllllIlllIll) {
        if (llllllllllllllIIlIIIIllllIlllIIl == Level.FINE) {
            this.base.debug(llllllllllllllIIlIIIIllllIlllIII, llllllllllllllIIlIIIIllllIlllIll);
        }
        else if (llllllllllllllIIlIIIIllllIlllIIl == Level.WARNING) {
            this.base.warn(llllllllllllllIIlIIIIllllIlllIII, llllllllllllllIIlIIIIllllIlllIll);
        }
        else if (llllllllllllllIIlIIIIllllIlllIIl == Level.SEVERE) {
            this.base.error(llllllllllllllIIlIIIIllllIlllIII, llllllllllllllIIlIIIIllllIlllIll);
        }
        else if (llllllllllllllIIlIIIIllllIlllIIl == Level.INFO) {
            this.base.info(llllllllllllllIIlIIIIllllIlllIII, llllllllllllllIIlIIIIllllIlllIll);
        }
        else {
            this.base.trace(llllllllllllllIIlIIIIllllIlllIII, llllllllllllllIIlIIIIllllIlllIll);
        }
    }
}
