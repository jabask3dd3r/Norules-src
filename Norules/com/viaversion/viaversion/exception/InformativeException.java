package com.viaversion.viaversion.exception;

import java.util.*;

public class InformativeException extends Exception
{
    private /* synthetic */ int sources;
    private final /* synthetic */ Map<String, Object> info;
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
    
    public InformativeException addSource(final Class<?> lllllllllllllIIIlIllIIIIlIlIllIl) {
        return this.set(String.valueOf(new StringBuilder().append("Source ").append(this.sources++)), this.getSource(lllllllllllllIIIlIllIIIIlIlIllIl));
    }
    
    public InformativeException set(final String lllllllllllllIIIlIllIIIIlIllIlIl, final Object lllllllllllllIIIlIllIIIIlIllIlII) {
        this.info.put(lllllllllllllIIIlIllIIIIlIllIlIl, lllllllllllllIIIlIllIIIIlIllIlII);
        return this;
    }
    
    @Override
    public String getMessage() {
        final StringBuilder lllllllllllllIIIlIllIIIIlIIlllll = new StringBuilder();
        lllllllllllllIIIlIllIIIIlIIlllll.append("Please post this error to https://github.com/ViaVersion/ViaVersion/issues and follow the issue template\n{");
        int lllllllllllllIIIlIllIIIIlIIllllI = 0;
        for (final Map.Entry<String, Object> lllllllllllllIIIlIllIIIIlIlIIIIl : this.info.entrySet()) {
            lllllllllllllIIIlIllIIIIlIIlllll.append((lllllllllllllIIIlIllIIIIlIIllllI == 0) ? "" : ", ").append(lllllllllllllIIIlIllIIIIlIlIIIIl.getKey()).append(": ").append(lllllllllllllIIIlIllIIIIlIlIIIIl.getValue().toString());
            ++lllllllllllllIIIlIllIIIIlIIllllI;
        }
        lllllllllllllIIIlIllIIIIlIIlllll.append("}\nActual Error: ");
        return String.valueOf(lllllllllllllIIIlIllIIIIlIIlllll);
    }
    
    public InformativeException(final Throwable lllllllllllllIIIlIllIIIIlIllllII) {
        super(lllllllllllllIIIlIllIIIIlIllllII);
        this.info = new HashMap<String, Object>();
    }
    
    private String getSource(final Class<?> lllllllllllllIIIlIllIIIIlIlIlIII) {
        if (lllllllllllllIIIlIllIIIIlIlIlIII.isAnonymousClass()) {
            return String.valueOf(new StringBuilder().append(lllllllllllllIIIlIllIIIIlIlIlIII.getName()).append(" (Anonymous)"));
        }
        return lllllllllllllIIIlIllIIIIlIlIlIII.getName();
    }
}
