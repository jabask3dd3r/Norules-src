package optifine;

import java.lang.reflect.*;

public class ReflectorField
{
    private /* synthetic */ boolean checked;
    private /* synthetic */ Field targetField;
    private /* synthetic */ IFieldLocator fieldLocator;
    
    public ReflectorField(final ReflectorClass lllllllllllllIllllllllllIlIIllII, final String lllllllllllllIllllllllllIlIIlIll, final boolean lllllllllllllIllllllllllIlIIIllI) {
        this(new FieldLocatorName(lllllllllllllIllllllllllIlIIllII, lllllllllllllIllllllllllIlIIlIll), lllllllllllllIllllllllllIlIIIllI);
    }
    
    public Object getValue() {
        return Reflector.getFieldValue(null, this);
    }
    
    public ReflectorField(final ReflectorClass lllllllllllllIllllllllllIIllIlll, final Class lllllllllllllIllllllllllIIllIllI, final int lllllllllllllIllllllllllIIllIIIl) {
        this(new FieldLocatorType(lllllllllllllIllllllllllIIllIlll, lllllllllllllIllllllllllIIllIllI, lllllllllllllIllllllllllIIllIIIl));
    }
    
    public ReflectorField(final IFieldLocator lllllllllllllIllllllllllIIIlllIl, final boolean lllllllllllllIllllllllllIIIlllII) {
        this.fieldLocator = null;
        this.checked = false;
        this.targetField = null;
        this.fieldLocator = lllllllllllllIllllllllllIIIlllIl;
        if (!lllllllllllllIllllllllllIIIlllII) {
            this.getTargetField();
        }
    }
    
    public boolean exists() {
        return this.getTargetField() != null;
    }
    
    public ReflectorField(final Field lllllllllllllIllllllllllIIlIlIll) {
        this(new FieldLocatorFixed(lllllllllllllIllllllllllIIlIlIll));
    }
    
    public ReflectorField(final ReflectorClass lllllllllllllIllllllllllIlIIIIIl, final Class lllllllllllllIllllllllllIlIIIIII) {
        this(lllllllllllllIllllllllllIlIIIIIl, lllllllllllllIllllllllllIlIIIIII, 0);
    }
    
    public Field getTargetField() {
        if (this.checked) {
            return this.targetField;
        }
        this.checked = true;
        this.targetField = this.fieldLocator.getField();
        if (this.targetField != null) {
            this.targetField.setAccessible(true);
        }
        return this.targetField;
    }
    
    public ReflectorField(final ReflectorClass lllllllllllllIllllllllllIlIlIIll, final String lllllllllllllIllllllllllIlIlIIlI) {
        this(new FieldLocatorName(lllllllllllllIllllllllllIlIlIIll, lllllllllllllIllllllllllIlIlIIlI));
    }
    
    public ReflectorField(final IFieldLocator lllllllllllllIllllllllllIIlIIlll) {
        this(lllllllllllllIllllllllllIIlIIlll, false);
    }
    
    public void setValue(final Object lllllllllllllIllllllllllIIIIlIll, final Object lllllllllllllIllllllllllIIIIlIlI) {
        Reflector.setFieldValue(lllllllllllllIllllllllllIIIIlIll, this, lllllllllllllIllllllllllIIIIlIlI);
    }
    
    public void setValue(final Object lllllllllllllIllllllllllIIIlIIII) {
        Reflector.setFieldValue(null, this, lllllllllllllIllllllllllIIIlIIII);
    }
}
