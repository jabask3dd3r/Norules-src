package optifine;

import java.lang.reflect.*;

public class FieldLocatorType implements IFieldLocator
{
    private /* synthetic */ int targetFieldIndex;
    private /* synthetic */ Class targetFieldType;
    private /* synthetic */ ReflectorClass reflectorClass;
    
    public FieldLocatorType(final ReflectorClass lllllllllllllIllIIIIIIIllllIIIlI, final Class lllllllllllllIllIIIIIIIllllIIIIl, final int lllllllllllllIllIIIIIIIllllIIIII) {
        this.reflectorClass = null;
        this.targetFieldType = null;
        this.reflectorClass = lllllllllllllIllIIIIIIIllllIIIlI;
        this.targetFieldType = lllllllllllllIllIIIIIIIllllIIIIl;
        this.targetFieldIndex = lllllllllllllIllIIIIIIIllllIIIII;
    }
    
    public FieldLocatorType(final ReflectorClass lllllllllllllIllIIIIIIIlllllIIII, final Class lllllllllllllIllIIIIIIIllllIllll) {
        this(lllllllllllllIllIIIIIIIlllllIIII, lllllllllllllIllIIIIIIIllllIllll, 0);
    }
    
    @Override
    public Field getField() {
        final Class lllllllllllllIllIIIIIIIlllIIllll = this.reflectorClass.getTargetClass();
        if (lllllllllllllIllIIIIIIIlllIIllll == null) {
            return null;
        }
        try {
            final Field[] lllllllllllllIllIIIIIIIlllIIllIl = lllllllllllllIllIIIIIIIlllIIllll.getDeclaredFields();
            int lllllllllllllIllIIIIIIIlllIIllII = 0;
            for (int lllllllllllllIllIIIIIIIlllIIlIlI = 0; lllllllllllllIllIIIIIIIlllIIlIlI < lllllllllllllIllIIIIIIIlllIIllIl.length; ++lllllllllllllIllIIIIIIIlllIIlIlI) {
                final Field lllllllllllllIllIIIIIIIlllIIlIII = lllllllllllllIllIIIIIIIlllIIllIl[lllllllllllllIllIIIIIIIlllIIlIlI];
                if (lllllllllllllIllIIIIIIIlllIIlIII.getType() == this.targetFieldType) {
                    if (lllllllllllllIllIIIIIIIlllIIllII == this.targetFieldIndex) {
                        lllllllllllllIllIIIIIIIlllIIlIII.setAccessible(true);
                        return lllllllllllllIllIIIIIIIlllIIlIII;
                    }
                    ++lllllllllllllIllIIIIIIIlllIIllII;
                }
            }
            Config.log(String.valueOf(new StringBuilder("(Reflector) Field not present: ").append(lllllllllllllIllIIIIIIIlllIIllll.getName()).append(".(type: ").append(this.targetFieldType).append(", index: ").append(this.targetFieldIndex).append(")")));
            return null;
        }
        catch (SecurityException lllllllllllllIllIIIIIIIlllIIIlll) {
            lllllllllllllIllIIIIIIIlllIIIlll.printStackTrace();
            return null;
        }
        catch (Throwable lllllllllllllIllIIIIIIIlllIIIlIl) {
            lllllllllllllIllIIIIIIIlllIIIlIl.printStackTrace();
            return null;
        }
    }
}
