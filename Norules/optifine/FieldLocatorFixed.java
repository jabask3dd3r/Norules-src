package optifine;

import java.lang.reflect.*;

public class FieldLocatorFixed implements IFieldLocator
{
    private /* synthetic */ Field field;
    
    public FieldLocatorFixed(final Field lllllllllllllIlIIIllIlIllIIIllIl) {
        this.field = lllllllllllllIlIIIllIlIllIIIllIl;
    }
    
    @Override
    public Field getField() {
        return this.field;
    }
}
