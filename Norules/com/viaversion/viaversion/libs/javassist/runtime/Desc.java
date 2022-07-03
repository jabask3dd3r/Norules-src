package com.viaversion.viaversion.libs.javassist.runtime;

public class Desc
{
    private static final /* synthetic */ ThreadLocal<Boolean> USE_CONTEXT_CLASS_LOADER_LOCALLY;
    public static /* synthetic */ boolean useContextClassLoader;
    
    public static Class<?> getType(final String lllllllllllllIllIIIllllllIlIIlII) {
        final Class<?>[] lllllllllllllIllIIIllllllIlIIIll = getType(lllllllllllllIllIIIllllllIlIIlII, lllllllllllllIllIIIllllllIlIIlII.length(), 0, 0);
        if (lllllllllllllIllIIIllllllIlIIIll == null || lllllllllllllIllIIIllllllIlIIIll.length != 1) {
            throw new RuntimeException("$type: internal error");
        }
        return lllllllllllllIllIIIllllllIlIIIll[0];
    }
    
    public static void resetUseContextClassLoaderLocally() {
        Desc.USE_CONTEXT_CLASS_LOADER_LOCALLY.remove();
    }
    
    private static Class<?> getClassObject(final String lllllllllllllIllIIIllllllIllIIIl) throws ClassNotFoundException {
        if (Desc.useContextClassLoader || Desc.USE_CONTEXT_CLASS_LOADER_LOCALLY.get()) {
            return Class.forName(lllllllllllllIllIIIllllllIllIIIl, true, Thread.currentThread().getContextClassLoader());
        }
        return Class.forName(lllllllllllllIllIIIllllllIllIIIl);
    }
    
    static {
        Desc.useContextClassLoader = false;
        USE_CONTEXT_CLASS_LOADER_LOCALLY = new ThreadLocal<Boolean>() {
            @Override
            protected Boolean initialValue() {
                return false;
            }
        };
    }
    
    private static Class<?>[] getClassType(final String lllllllllllllIllIIIlllllIlllIIIl, final int lllllllllllllIllIIIlllllIlllIIII, final int lllllllllllllIllIIIlllllIllIllll, final int lllllllllllllIllIIIlllllIllIlllI) {
        int lllllllllllllIllIIIlllllIlllIlII;
        for (lllllllllllllIllIIIlllllIlllIlII = lllllllllllllIllIIIlllllIllIllll; lllllllllllllIllIIIlllllIlllIIIl.charAt(lllllllllllllIllIIIlllllIlllIlII) == '['; ++lllllllllllllIllIIIlllllIlllIlII) {}
        if (lllllllllllllIllIIIlllllIlllIIIl.charAt(lllllllllllllIllIIIlllllIlllIlII) == 'L') {
            lllllllllllllIllIIIlllllIlllIlII = lllllllllllllIllIIIlllllIlllIIIl.indexOf(59, lllllllllllllIllIIIlllllIlllIlII);
            if (lllllllllllllIllIIIlllllIlllIlII < 0) {
                throw new IndexOutOfBoundsException("bad descriptor");
            }
        }
        String lllllllllllllIllIIIlllllIlllIIll = null;
        if (lllllllllllllIllIIIlllllIlllIIIl.charAt(lllllllllllllIllIIIlllllIllIllll) == 'L') {
            final String lllllllllllllIllIIIlllllIllllIlI = lllllllllllllIllIIIlllllIlllIIIl.substring(lllllllllllllIllIIIlllllIllIllll + 1, lllllllllllllIllIIIlllllIlllIlII);
        }
        else {
            lllllllllllllIllIIIlllllIlllIIll = lllllllllllllIllIIIlllllIlllIIIl.substring(lllllllllllllIllIIIlllllIllIllll, lllllllllllllIllIIIlllllIlllIlII + 1);
        }
        final Class<?>[] lllllllllllllIllIIIlllllIlllIIlI = getType(lllllllllllllIllIIIlllllIlllIIIl, lllllllllllllIllIIIlllllIlllIIII, lllllllllllllIllIIIlllllIlllIlII + 1, lllllllllllllIllIIIlllllIllIlllI + 1);
        try {
            lllllllllllllIllIIIlllllIlllIIlI[lllllllllllllIllIIIlllllIllIlllI] = getClassObject(lllllllllllllIllIIIlllllIlllIIll.replace('/', '.'));
        }
        catch (ClassNotFoundException lllllllllllllIllIIIlllllIllllIIl) {
            throw new RuntimeException(lllllllllllllIllIIIlllllIllllIIl.getMessage());
        }
        return lllllllllllllIllIIIlllllIlllIIlI;
    }
    
    public static Class<?> getClazz(final String lllllllllllllIllIIIllllllIlIlIll) {
        try {
            return getClassObject(lllllllllllllIllIIIllllllIlIlIll);
        }
        catch (ClassNotFoundException lllllllllllllIllIIIllllllIlIllIl) {
            throw new RuntimeException(String.valueOf(new StringBuilder().append("$class: internal error, could not find class '").append(lllllllllllllIllIIIllllllIlIlIll).append("' (Desc.useContextClassLoader: ").append(Boolean.toString(Desc.useContextClassLoader)).append(")")), lllllllllllllIllIIIllllllIlIllIl);
        }
    }
    
    public static Class<?>[] getParams(final String lllllllllllllIllIIIllllllIlIIlll) {
        if (lllllllllllllIllIIIllllllIlIIlll.charAt(0) != '(') {
            throw new RuntimeException("$sig: internal error");
        }
        return getType(lllllllllllllIllIIIllllllIlIIlll, lllllllllllllIllIIIllllllIlIIlll.length(), 1, 0);
    }
    
    public static void setUseContextClassLoaderLocally() {
        Desc.USE_CONTEXT_CLASS_LOADER_LOCALLY.set(true);
    }
    
    private static Class<?>[] getType(final String lllllllllllllIllIIIllllllIIlIIII, final int lllllllllllllIllIIIllllllIIIlIII, final int lllllllllllllIllIIIllllllIIIIlll, final int lllllllllllllIllIIIllllllIIIllIl) {
        if (lllllllllllllIllIIIllllllIIIIlll >= lllllllllllllIllIIIllllllIIIlIII) {
            return (Class<?>[])new Class[lllllllllllllIllIIIllllllIIIllIl];
        }
        final char lllllllllllllIllIIIllllllIIIlIll = lllllllllllllIllIIIllllllIIlIIII.charAt(lllllllllllllIllIIIllllllIIIIlll);
        switch (lllllllllllllIllIIIllllllIIIlIll) {
            case 'Z': {
                final Class<?> lllllllllllllIllIIIllllllIIllIIl = Boolean.TYPE;
                break;
            }
            case 'C': {
                final Class<?> lllllllllllllIllIIIllllllIIllIII = Character.TYPE;
                break;
            }
            case 'B': {
                final Class<?> lllllllllllllIllIIIllllllIIlIlll = Byte.TYPE;
                break;
            }
            case 'S': {
                final Class<?> lllllllllllllIllIIIllllllIIlIllI = Short.TYPE;
                break;
            }
            case 'I': {
                final Class<?> lllllllllllllIllIIIllllllIIlIlIl = Integer.TYPE;
                break;
            }
            case 'J': {
                final Class<?> lllllllllllllIllIIIllllllIIlIlII = Long.TYPE;
                break;
            }
            case 'F': {
                final Class<?> lllllllllllllIllIIIllllllIIlIIll = Float.TYPE;
                break;
            }
            case 'D': {
                final Class<?> lllllllllllllIllIIIllllllIIlIIlI = Double.TYPE;
                break;
            }
            case 'V': {
                final Class<?> lllllllllllllIllIIIllllllIIlIIIl = Void.TYPE;
                break;
            }
            case 'L':
            case '[': {
                return getClassType(lllllllllllllIllIIIllllllIIlIIII, lllllllllllllIllIIIllllllIIIlIII, lllllllllllllIllIIIllllllIIIIlll, lllllllllllllIllIIIllllllIIIllIl);
            }
            default: {
                return (Class<?>[])new Class[lllllllllllllIllIIIllllllIIIllIl];
            }
        }
        final Class<?>[] lllllllllllllIllIIIllllllIIIlIlI = getType(lllllllllllllIllIIIllllllIIlIIII, lllllllllllllIllIIIllllllIIIlIII, lllllllllllllIllIIIllllllIIIIlll + 1, lllllllllllllIllIIIllllllIIIllIl + 1);
        final Class<?> lllllllllllllIllIIIllllllIIIllII;
        lllllllllllllIllIIIllllllIIIlIlI[lllllllllllllIllIIIllllllIIIllIl] = lllllllllllllIllIIIllllllIIIllII;
        return lllllllllllllIllIIIllllllIIIlIlI;
    }
}
