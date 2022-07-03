package optifine;

import java.lang.reflect.*;
import java.util.*;

public class ReflectorMethod
{
    private /* synthetic */ ReflectorClass reflectorClass;
    private /* synthetic */ boolean checked;
    private /* synthetic */ Method targetMethod;
    private /* synthetic */ String targetMethodName;
    private /* synthetic */ Class[] targetMethodParameterTypes;
    
    public static Method[] getMethods(final Class lllllllllllllllIIlIllIIlIIIlllIl, final String lllllllllllllllIIlIllIIlIIIlllII) {
        final List lllllllllllllllIIlIllIIlIIIllIll = new ArrayList();
        final Method[] lllllllllllllllIIlIllIIlIIIllIlI = lllllllllllllllIIlIllIIlIIIlllIl.getDeclaredMethods();
        for (int lllllllllllllllIIlIllIIlIIIllIIl = 0; lllllllllllllllIIlIllIIlIIIllIIl < lllllllllllllllIIlIllIIlIIIllIlI.length; ++lllllllllllllllIIlIllIIlIIIllIIl) {
            final Method lllllllllllllllIIlIllIIlIIIllIII = lllllllllllllllIIlIllIIlIIIllIlI[lllllllllllllllIIlIllIIlIIIllIIl];
            if (lllllllllllllllIIlIllIIlIIIllIII.getName().equals(lllllllllllllllIIlIllIIlIIIlllII)) {
                lllllllllllllllIIlIllIIlIIIllIll.add(lllllllllllllllIIlIllIIlIIIllIII);
            }
        }
        final Method[] lllllllllllllllIIlIllIIlIIIlIlll = lllllllllllllllIIlIllIIlIIIllIll.toArray(new Method[lllllllllllllllIIlIllIIlIIIllIll.size()]);
        return lllllllllllllllIIlIllIIlIIIlIlll;
    }
    
    public void deactivate() {
        this.checked = true;
        this.targetMethod = null;
    }
    
    public Class getReturnType() {
        final Method lllllllllllllllIIlIllIIlIIlllllI = this.getTargetMethod();
        return (lllllllllllllllIIlIllIIlIIlllllI == null) ? null : lllllllllllllllIIlIllIIlIIlllllI.getReturnType();
    }
    
    public ReflectorMethod(final ReflectorClass lllllllllllllllIIlIllIIlIlllIIll, final String lllllllllllllllIIlIllIIlIlllIIlI) {
        this(lllllllllllllllIIlIllIIlIlllIIll, lllllllllllllllIIlIllIIlIlllIIlI, null, false);
    }
    
    public ReflectorMethod(final ReflectorClass lllllllllllllllIIlIllIIlIlIllllI, final String lllllllllllllllIIlIllIIlIlIlllIl, final Class[] lllllllllllllllIIlIllIIlIlIlllII, final boolean lllllllllllllllIIlIllIIlIlIlIllI) {
        this.reflectorClass = null;
        this.targetMethodName = null;
        this.targetMethodParameterTypes = null;
        this.checked = false;
        this.targetMethod = null;
        this.reflectorClass = lllllllllllllllIIlIllIIlIlIllllI;
        this.targetMethodName = lllllllllllllllIIlIllIIlIlIlllIl;
        this.targetMethodParameterTypes = lllllllllllllllIIlIllIIlIlIlllII;
        if (!lllllllllllllllIIlIllIIlIlIlIllI) {
            final byte lllllllllllllllIIlIllIIlIlIlIlIl = (byte)this.getTargetMethod();
        }
    }
    
    public boolean exists() {
        if (this.checked) {
            return this.targetMethod != null;
        }
        return this.getTargetMethod() != null;
    }
    
    public Method getTargetMethod() {
        if (this.checked) {
            return this.targetMethod;
        }
        this.checked = true;
        final Class lllllllllllllllIIlIllIIlIlIIlllI = this.reflectorClass.getTargetClass();
        if (lllllllllllllllIIlIllIIlIlIIlllI == null) {
            return null;
        }
        try {
            if (this.targetMethodParameterTypes == null) {
                final Method[] lllllllllllllllIIlIllIIlIlIIllIl = getMethods(lllllllllllllllIIlIllIIlIlIIlllI, this.targetMethodName);
                if (lllllllllllllllIIlIllIIlIlIIllIl.length <= 0) {
                    Config.log(String.valueOf(new StringBuilder("(Reflector) Method not present: ").append(lllllllllllllllIIlIllIIlIlIIlllI.getName()).append(".").append(this.targetMethodName)));
                    return null;
                }
                if (lllllllllllllllIIlIllIIlIlIIllIl.length > 1) {
                    Config.warn(String.valueOf(new StringBuilder("(Reflector) More than one method found: ").append(lllllllllllllllIIlIllIIlIlIIlllI.getName()).append(".").append(this.targetMethodName)));
                    for (int lllllllllllllllIIlIllIIlIlIIllII = 0; lllllllllllllllIIlIllIIlIlIIllII < lllllllllllllllIIlIllIIlIlIIllIl.length; ++lllllllllllllllIIlIllIIlIlIIllII) {
                        final Method lllllllllllllllIIlIllIIlIlIIlIll = lllllllllllllllIIlIllIIlIlIIllIl[lllllllllllllllIIlIllIIlIlIIllII];
                        Config.warn(String.valueOf(new StringBuilder("(Reflector)  - ").append(lllllllllllllllIIlIllIIlIlIIlIll)));
                    }
                    return null;
                }
                this.targetMethod = lllllllllllllllIIlIllIIlIlIIllIl[0];
            }
            else {
                this.targetMethod = getMethod(lllllllllllllllIIlIllIIlIlIIlllI, this.targetMethodName, this.targetMethodParameterTypes);
            }
            if (this.targetMethod == null) {
                Config.log(String.valueOf(new StringBuilder("(Reflector) Method not present: ").append(lllllllllllllllIIlIllIIlIlIIlllI.getName()).append(".").append(this.targetMethodName)));
                return null;
            }
            this.targetMethod.setAccessible(true);
            return this.targetMethod;
        }
        catch (Throwable lllllllllllllllIIlIllIIlIlIIlIlI) {
            lllllllllllllllIIlIllIIlIlIIlIlI.printStackTrace();
            return null;
        }
    }
    
    public static Method getMethod(final Class lllllllllllllllIIlIllIIlIIlIlIlI, final String lllllllllllllllIIlIllIIlIIllIIII, final Class[] lllllllllllllllIIlIllIIlIIlIllll) {
        final Method[] lllllllllllllllIIlIllIIlIIlIlllI = lllllllllllllllIIlIllIIlIIlIlIlI.getDeclaredMethods();
        for (int lllllllllllllllIIlIllIIlIIlIllIl = 0; lllllllllllllllIIlIllIIlIIlIllIl < lllllllllllllllIIlIllIIlIIlIlllI.length; ++lllllllllllllllIIlIllIIlIIlIllIl) {
            final Method lllllllllllllllIIlIllIIlIIlIllII = lllllllllllllllIIlIllIIlIIlIlllI[lllllllllllllllIIlIllIIlIIlIllIl];
            if (lllllllllllllllIIlIllIIlIIlIllII.getName().equals(lllllllllllllllIIlIllIIlIIllIIII)) {
                final Class[] lllllllllllllllIIlIllIIlIIlIlIll = lllllllllllllllIIlIllIIlIIlIllII.getParameterTypes();
                if (Reflector.matchesTypes(lllllllllllllllIIlIllIIlIIlIllll, lllllllllllllllIIlIllIIlIIlIlIll)) {
                    return lllllllllllllllIIlIllIIlIIlIllII;
                }
            }
        }
        return null;
    }
    
    public ReflectorMethod(final ReflectorClass lllllllllllllllIIlIllIIlIllIlIII, final String lllllllllllllllIIlIllIIlIllIlIll, final Class[] lllllllllllllllIIlIllIIlIllIlIlI) {
        this(lllllllllllllllIIlIllIIlIllIlIII, lllllllllllllllIIlIllIIlIllIlIll, lllllllllllllllIIlIllIIlIllIlIlI, false);
    }
}
