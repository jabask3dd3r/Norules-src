package optifine;

import java.util.*;
import java.lang.reflect.*;

public class ReflectorRaw
{
    public static ReflectorField getReflectorField(final Class lllllllllllllIIllIlllIIllIIllIIl, final Class lllllllllllllIIllIlllIIllIIllIII) {
        final Field lllllllllllllIIllIlllIIllIIlIlll = getField(lllllllllllllIIllIlllIIllIIllIIl, lllllllllllllIIllIlllIIllIIllIII);
        if (lllllllllllllIIllIlllIIllIIlIlll == null) {
            return null;
        }
        final ReflectorClass lllllllllllllIIllIlllIIllIIlIllI = new ReflectorClass(lllllllllllllIIllIlllIIllIIllIIl);
        return new ReflectorField(lllllllllllllIIllIlllIIllIIlIllI, lllllllllllllIIllIlllIIllIIlIlll.getName());
    }
    
    public static Field[] getFields(final Class lllllllllllllIIllIlllIlIIIlllllI, final Class lllllllllllllIIllIlllIlIIIllllIl) {
        try {
            final Field[] lllllllllllllIIllIlllIlIIlIIIIII = lllllllllllllIIllIlllIlIIIlllllI.getDeclaredFields();
            return getFields(lllllllllllllIIllIlllIlIIlIIIIII, lllllllllllllIIllIlllIlIIIllllIl);
        }
        catch (Exception lllllllllllllIIllIlllIlIIIllllll) {
            return null;
        }
    }
    
    public static Field[] getFieldsAfter(final Class lllllllllllllIIllIlllIlIIIlIIIlI, final Field lllllllllllllIIllIlllIlIIIIllIII, final Class lllllllllllllIIllIlllIlIIIlIIIII) {
        try {
            final Field[] lllllllllllllIIllIlllIlIIIIlllll = lllllllllllllIIllIlllIlIIIlIIIlI.getDeclaredFields();
            final List<Field> lllllllllllllIIllIlllIlIIIIllllI = Arrays.asList(lllllllllllllIIllIlllIlIIIIlllll);
            final int lllllllllllllIIllIlllIlIIIIlllIl = lllllllllllllIIllIlllIlIIIIllllI.indexOf(lllllllllllllIIllIlllIlIIIIllIII);
            if (lllllllllllllIIllIlllIlIIIIlllIl < 0) {
                return new Field[0];
            }
            final List<Field> lllllllllllllIIllIlllIlIIIIlllII = lllllllllllllIIllIlllIlIIIIllllI.subList(lllllllllllllIIllIlllIlIIIIlllIl + 1, lllllllllllllIIllIlllIlIIIIllllI.size());
            final Field[] lllllllllllllIIllIlllIlIIIIllIll = lllllllllllllIIllIlllIlIIIIlllII.toArray(new Field[lllllllllllllIIllIlllIlIIIIlllII.size()]);
            return getFields(lllllllllllllIIllIlllIlIIIIllIll, lllllllllllllIIllIlllIlIIIlIIIII);
        }
        catch (Exception lllllllllllllIIllIlllIlIIIIllIlI) {
            return null;
        }
    }
    
    public static boolean setFieldValue(final Object lllllllllllllIIllIlllIIllIllIlII, final Class lllllllllllllIIllIlllIIllIllIIll, final Class lllllllllllllIIllIlllIIllIllIlll, final Object lllllllllllllIIllIlllIIllIllIIIl) {
        final ReflectorField lllllllllllllIIllIlllIIllIllIlIl = getReflectorField(lllllllllllllIIllIlllIIllIllIIll, lllllllllllllIIllIlllIIllIllIlll);
        return lllllllllllllIIllIlllIIllIllIlIl != null && lllllllllllllIIllIlllIIllIllIlIl.exists() && Reflector.setFieldValue(lllllllllllllIIllIlllIIllIllIlII, lllllllllllllIIllIlllIIllIllIlIl, lllllllllllllIIllIlllIIllIllIIIl);
    }
    
    public static boolean setFieldValue(final Object lllllllllllllIIllIlllIIllIlIIIll, final Class lllllllllllllIIllIlllIIllIlIIIlI, final Class lllllllllllllIIllIlllIIllIlIIIIl, final int lllllllllllllIIllIlllIIllIlIIIII, final Object lllllllllllllIIllIlllIIllIlIIlIl) {
        final ReflectorField lllllllllllllIIllIlllIIllIlIIlII = getReflectorField(lllllllllllllIIllIlllIIllIlIIIlI, lllllllllllllIIllIlllIIllIlIIIIl, lllllllllllllIIllIlllIIllIlIIIII);
        return lllllllllllllIIllIlllIIllIlIIlII != null && lllllllllllllIIllIlllIIllIlIIlII.exists() && Reflector.setFieldValue(lllllllllllllIIllIlllIIllIlIIIll, lllllllllllllIIllIlllIIllIlIIlII, lllllllllllllIIllIlllIIllIlIIlIl);
    }
    
    public static Object getFieldValue(final Object lllllllllllllIIllIlllIIlllIIIIll, final Class lllllllllllllIIllIlllIIlllIIIIlI, final Class lllllllllllllIIllIlllIIlllIIIllI, final int lllllllllllllIIllIlllIIlllIIIIII) {
        final ReflectorField lllllllllllllIIllIlllIIlllIIIlII = getReflectorField(lllllllllllllIIllIlllIIlllIIIIlI, lllllllllllllIIllIlllIIlllIIIllI, lllllllllllllIIllIlllIIlllIIIIII);
        if (lllllllllllllIIllIlllIIlllIIIlII == null) {
            return null;
        }
        return lllllllllllllIIllIlllIIlllIIIlII.exists() ? Reflector.getFieldValue(lllllllllllllIIllIlllIIlllIIIIll, lllllllllllllIIllIlllIIlllIIIlII) : null;
    }
    
    public static Field getField(final Class lllllllllllllIIllIlllIlIIlIIlIlI, final Class lllllllllllllIIllIlllIlIIlIIlIIl) {
        try {
            final Field[] lllllllllllllIIllIlllIlIIlIIlllI = lllllllllllllIIllIlllIlIIlIIlIlI.getDeclaredFields();
            for (int lllllllllllllIIllIlllIlIIlIIllIl = 0; lllllllllllllIIllIlllIlIIlIIllIl < lllllllllllllIIllIlllIlIIlIIlllI.length; ++lllllllllllllIIllIlllIlIIlIIllIl) {
                final Field lllllllllllllIIllIlllIlIIlIIllII = lllllllllllllIIllIlllIlIIlIIlllI[lllllllllllllIIllIlllIlIIlIIllIl];
                if (lllllllllllllIIllIlllIlIIlIIllII.getType() == lllllllllllllIIllIlllIlIIlIIlIIl) {
                    lllllllllllllIIllIlllIlIIlIIllII.setAccessible(true);
                    return lllllllllllllIIllIlllIlIIlIIllII;
                }
            }
            return null;
        }
        catch (Exception lllllllllllllIIllIlllIlIIlIIlIll) {
            return null;
        }
    }
    
    public static Field getFieldAfter(final Class lllllllllllllIIllIlllIIllllIIIll, final Field lllllllllllllIIllIlllIIlllIlllIl, final Class lllllllllllllIIllIlllIIllllIIIIl, final int lllllllllllllIIllIlllIIllllIIIII) {
        final Field[] lllllllllllllIIllIlllIIlllIlllll = getFieldsAfter(lllllllllllllIIllIlllIIllllIIIll, lllllllllllllIIllIlllIIlllIlllIl, lllllllllllllIIllIlllIIllllIIIIl);
        return (lllllllllllllIIllIlllIIllllIIIII >= 0 && lllllllllllllIIllIlllIIllllIIIII < lllllllllllllIIllIlllIIlllIlllll.length) ? lllllllllllllIIllIlllIIlllIlllll[lllllllllllllIIllIlllIIllllIIIII] : null;
    }
    
    public static ReflectorField getReflectorField(final Class lllllllllllllIIllIlllIIllIIIllII, final Class lllllllllllllIIllIlllIIllIIIlIll, final int lllllllllllllIIllIlllIIllIIIIlIl) {
        final Field lllllllllllllIIllIlllIIllIIIlIIl = getField(lllllllllllllIIllIlllIIllIIIllII, lllllllllllllIIllIlllIIllIIIlIll, lllllllllllllIIllIlllIIllIIIIlIl);
        if (lllllllllllllIIllIlllIIllIIIlIIl == null) {
            return null;
        }
        final ReflectorClass lllllllllllllIIllIlllIIllIIIlIII = new ReflectorClass(lllllllllllllIIllIlllIIllIIIllII);
        return new ReflectorField(lllllllllllllIIllIlllIIllIIIlIII, lllllllllllllIIllIlllIIllIIIlIIl.getName());
    }
    
    public static Field getField(final Class lllllllllllllIIllIlllIIlllllIIII, final Class lllllllllllllIIllIlllIIllllIllll, final int lllllllllllllIIllIlllIIllllIlllI) {
        final Field[] lllllllllllllIIllIlllIIllllIllIl = getFields(lllllllllllllIIllIlllIIlllllIIII, lllllllllllllIIllIlllIIllllIllll);
        return (lllllllllllllIIllIlllIIllllIlllI >= 0 && lllllllllllllIIllIlllIIllllIlllI < lllllllllllllIIllIlllIIllllIllIl.length) ? lllllllllllllIIllIlllIIllllIllIl[lllllllllllllIIllIlllIIllllIlllI] : null;
    }
    
    public static Object getFieldValue(final Object lllllllllllllIIllIlllIIlllIlIIIl, final Class lllllllllllllIIllIlllIIlllIlIIII, final Class lllllllllllllIIllIlllIIlllIIllll) {
        final ReflectorField lllllllllllllIIllIlllIIlllIlIIlI = getReflectorField(lllllllllllllIIllIlllIIlllIlIIII, lllllllllllllIIllIlllIIlllIIllll);
        if (lllllllllllllIIllIlllIIlllIlIIlI == null) {
            return null;
        }
        return lllllllllllllIIllIlllIIlllIlIIlI.exists() ? Reflector.getFieldValue(lllllllllllllIIllIlllIIlllIlIIIl, lllllllllllllIIllIlllIIlllIlIIlI) : null;
    }
    
    public static Field[] getFields(final Field[] lllllllllllllIIllIlllIlIIIlIllll, final Class lllllllllllllIIllIlllIlIIIllIlIl) {
        try {
            final List lllllllllllllIIllIlllIlIIIllIlII = new ArrayList();
            for (int lllllllllllllIIllIlllIlIIIllIIll = 0; lllllllllllllIIllIlllIlIIIllIIll < lllllllllllllIIllIlllIlIIIlIllll.length; ++lllllllllllllIIllIlllIlIIIllIIll) {
                final Field lllllllllllllIIllIlllIlIIIllIIlI = lllllllllllllIIllIlllIlIIIlIllll[lllllllllllllIIllIlllIlIIIllIIll];
                if (lllllllllllllIIllIlllIlIIIllIIlI.getType() == lllllllllllllIIllIlllIlIIIllIlIl) {
                    lllllllllllllIIllIlllIlIIIllIIlI.setAccessible(true);
                    lllllllllllllIIllIlllIlIIIllIlII.add(lllllllllllllIIllIlllIlIIIllIIlI);
                }
            }
            final Field[] lllllllllllllIIllIlllIlIIIllIIIl = lllllllllllllIIllIlllIlIIIllIlII.toArray(new Field[lllllllllllllIIllIlllIlIIIllIlII.size()]);
            return lllllllllllllIIllIlllIlIIIllIIIl;
        }
        catch (Exception lllllllllllllIIllIlllIlIIIllIIII) {
            return null;
        }
    }
    
    public static Field[] getFields(final Object lllllllllllllIIllIlllIlIIIIIlIII, final Field[] lllllllllllllIIllIlllIlIIIIIIlll, final Class lllllllllllllIIllIlllIlIIIIIIllI, final Object lllllllllllllIIllIlllIlIIIIIIlIl) {
        try {
            final List<Field> lllllllllllllIIllIlllIlIIIIIIlII = new ArrayList<Field>();
            for (int lllllllllllllIIllIlllIlIIIIIIIll = 0; lllllllllllllIIllIlllIlIIIIIIIll < lllllllllllllIIllIlllIlIIIIIIlll.length; ++lllllllllllllIIllIlllIlIIIIIIIll) {
                final Field lllllllllllllIIllIlllIlIIIIIIIlI = lllllllllllllIIllIlllIlIIIIIIlll[lllllllllllllIIllIlllIlIIIIIIIll];
                if (lllllllllllllIIllIlllIlIIIIIIIlI.getType() == lllllllllllllIIllIlllIlIIIIIIllI) {
                    final boolean lllllllllllllIIllIlllIlIIIIIIIIl = Modifier.isStatic(lllllllllllllIIllIlllIlIIIIIIIlI.getModifiers());
                    if ((lllllllllllllIIllIlllIlIIIIIlIII != null || lllllllllllllIIllIlllIlIIIIIIIIl) && (lllllllllllllIIllIlllIlIIIIIlIII == null || !lllllllllllllIIllIlllIlIIIIIIIIl)) {
                        lllllllllllllIIllIlllIlIIIIIIIlI.setAccessible(true);
                        final Object lllllllllllllIIllIlllIlIIIIIIIII = lllllllllllllIIllIlllIlIIIIIIIlI.get(lllllllllllllIIllIlllIlIIIIIlIII);
                        if (lllllllllllllIIllIlllIlIIIIIIIII == lllllllllllllIIllIlllIlIIIIIIlIl) {
                            lllllllllllllIIllIlllIlIIIIIIlII.add(lllllllllllllIIllIlllIlIIIIIIIlI);
                        }
                        else if (lllllllllllllIIllIlllIlIIIIIIIII != null && lllllllllllllIIllIlllIlIIIIIIlIl != null && lllllllllllllIIllIlllIlIIIIIIIII.equals(lllllllllllllIIllIlllIlIIIIIIlIl)) {
                            lllllllllllllIIllIlllIlIIIIIIlII.add(lllllllllllllIIllIlllIlIIIIIIIlI);
                        }
                    }
                }
            }
            final Field[] lllllllllllllIIllIlllIIlllllllll = lllllllllllllIIllIlllIlIIIIIIlII.toArray(new Field[lllllllllllllIIllIlllIlIIIIIIlII.size()]);
            return lllllllllllllIIllIlllIIlllllllll;
        }
        catch (Exception lllllllllllllIIllIlllIIllllllllI) {
            return null;
        }
    }
}
