package javax.vecmath;

import java.util.*;

class VecMathI18N
{
    static String getString(final String lllllllllllllllIlllIIIIlIlIIIllI) {
        String lllllllllllllllIlllIIIIlIlIIIlII = null;
        try {
            final String lllllllllllllllIlllIIIIlIlIIIlIl = ResourceBundle.getBundle("javax.vecmath.ExceptionStrings").getString(lllllllllllllllIlllIIIIlIlIIIllI);
        }
        catch (MissingResourceException lllllllllllllllIlllIIIIlIlIIIIll) {
            System.err.println(String.valueOf(new StringBuilder("VecMathI18N: Error looking up: ").append(lllllllllllllllIlllIIIIlIlIIIllI)));
            lllllllllllllllIlllIIIIlIlIIIlII = lllllllllllllllIlllIIIIlIlIIIllI;
        }
        return lllllllllllllllIlllIIIIlIlIIIlII;
    }
}
