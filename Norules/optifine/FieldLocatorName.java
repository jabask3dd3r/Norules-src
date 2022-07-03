package optifine;

import java.lang.reflect.*;

public class FieldLocatorName implements IFieldLocator
{
    private /* synthetic */ ReflectorClass reflectorClass;
    private /* synthetic */ String targetFieldName;
    
    public FieldLocatorName(final ReflectorClass lllllllllllllIllllIIlIIlIIIlIlIl, final String lllllllllllllIllllIIlIIlIIIlIlll) {
        this.reflectorClass = null;
        this.targetFieldName = null;
        this.reflectorClass = lllllllllllllIllllIIlIIlIIIlIlIl;
        this.targetFieldName = lllllllllllllIllllIIlIIlIIIlIlll;
    }
    
    private Field getDeclaredField(final Class lllllllllllllIllllIIlIIlIIIIIIII, final String lllllllllllllIllllIIlIIIlllllIIl) throws NoSuchFieldException {
        final Field[] lllllllllllllIllllIIlIIIlllllllI = lllllllllllllIllllIIlIIlIIIIIIII.getDeclaredFields();
        for (int lllllllllllllIllllIIlIIIllllllIl = 0; lllllllllllllIllllIIlIIIllllllIl < lllllllllllllIllllIIlIIIlllllllI.length; ++lllllllllllllIllllIIlIIIllllllIl) {
            final Field lllllllllllllIllllIIlIIIllllllII = lllllllllllllIllllIIlIIIlllllllI[lllllllllllllIllllIIlIIIllllllIl];
            if (lllllllllllllIllllIIlIIIllllllII.getName().equals(lllllllllllllIllllIIlIIIlllllIIl)) {
                return lllllllllllllIllllIIlIIIllllllII;
            }
        }
        if (lllllllllllllIllllIIlIIlIIIIIIII == Object.class) {
            throw new NoSuchFieldException(lllllllllllllIllllIIlIIIlllllIIl);
        }
        return this.getDeclaredField(lllllllllllllIllllIIlIIlIIIIIIII.getSuperclass(), lllllllllllllIllllIIlIIIlllllIIl);
    }
    
    @Override
    public Field getField() {
        final Class lllllllllllllIllllIIlIIlIIIIllll = this.reflectorClass.getTargetClass();
        if (lllllllllllllIllllIIlIIlIIIIllll == null) {
            return null;
        }
        try {
            final Field lllllllllllllIllllIIlIIlIIIIlllI = this.getDeclaredField(lllllllllllllIllllIIlIIlIIIIllll, this.targetFieldName);
            lllllllllllllIllllIIlIIlIIIIlllI.setAccessible(true);
            return lllllllllllllIllllIIlIIlIIIIlllI;
        }
        catch (NoSuchFieldException lllllllllllllIllllIIlIIlIIIIllIl) {
            Config.log(String.valueOf(new StringBuilder("(Reflector) Field not present: ").append(lllllllllllllIllllIIlIIlIIIIllll.getName()).append(".").append(this.targetFieldName)));
            return null;
        }
        catch (SecurityException lllllllllllllIllllIIlIIlIIIIllII) {
            lllllllllllllIllllIIlIIlIIIIllII.printStackTrace();
            return null;
        }
        catch (Throwable lllllllllllllIllllIIlIIlIIIIlIll) {
            lllllllllllllIllllIIlIIlIIIIlIll.printStackTrace();
            return null;
        }
    }
}
