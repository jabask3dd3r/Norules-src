package com.viaversion.viaversion.unsupported;

import java.util.*;
import java.lang.reflect.*;

public final class UnsupportedMethods
{
    private final /* synthetic */ Set<String> methodNames;
    private final /* synthetic */ String className;
    
    public UnsupportedMethods(final String llllllllllllllllIllllllIllllIIIl, final Set<String> llllllllllllllllIllllllIllllIIII) {
        this.className = llllllllllllllllIllllllIllllIIIl;
        this.methodNames = Collections.unmodifiableSet((Set<? extends String>)llllllllllllllllIllllllIllllIIII);
    }
    
    public final boolean findMatch() {
        try {
            final char llllllllllllllllIllllllIlllIIlII = (Object)Class.forName(this.className).getDeclaredMethods();
            final short llllllllllllllllIllllllIlllIIIll = (short)llllllllllllllllIllllllIlllIIlII.length;
            for (double llllllllllllllllIllllllIlllIIIlI = 0; llllllllllllllllIllllllIlllIIIlI < llllllllllllllllIllllllIlllIIIll; ++llllllllllllllllIllllllIlllIIIlI) {
                final Method llllllllllllllllIllllllIlllIIlll = llllllllllllllllIllllllIlllIIlII[llllllllllllllllIllllllIlllIIIlI];
                if (this.methodNames.contains(llllllllllllllllIllllllIlllIIlll.getName())) {
                    return true;
                }
            }
        }
        catch (ClassNotFoundException ex) {}
        return false;
    }
    
    public String getClassName() {
        return this.className;
    }
}
