package org.yaml.snakeyaml.introspector;

import java.lang.reflect.*;
import java.util.*;
import java.lang.annotation.*;
import org.yaml.snakeyaml.util.*;
import org.yaml.snakeyaml.error.*;

public class FieldProperty extends GenericProperty
{
    private final /* synthetic */ Field field;
    
    @Override
    public void set(final Object lllllllllllllIlIIllllIllIIllllIl, final Object lllllllllllllIlIIllllIllIIllllII) throws Exception {
        this.field.set(lllllllllllllIlIIllllIllIIllllIl, lllllllllllllIlIIllllIllIIllllII);
    }
    
    @Override
    public List<Annotation> getAnnotations() {
        return ArrayUtils.toUnmodifiableList(this.field.getAnnotations());
    }
    
    @Override
    public <A extends Annotation> A getAnnotation(final Class<A> lllllllllllllIlIIllllIllIIlIlIlI) {
        return this.field.getAnnotation(lllllllllllllIlIIllllIllIIlIlIlI);
    }
    
    public FieldProperty(final Field lllllllllllllIlIIllllIllIlIIIlll) {
        super(lllllllllllllIlIIllllIllIlIIIlll.getName(), lllllllllllllIlIIllllIllIlIIIlll.getType(), lllllllllllllIlIIllllIllIlIIIlll.getGenericType());
        this.field = lllllllllllllIlIIllllIllIlIIIlll;
        lllllllllllllIlIIllllIllIlIIIlll.setAccessible(true);
    }
    
    @Override
    public Object get(final Object lllllllllllllIlIIllllIllIIllIllI) {
        try {
            return this.field.get(lllllllllllllIlIIllllIllIIllIllI);
        }
        catch (Exception lllllllllllllIlIIllllIllIIlllIII) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unable to access field ").append(this.field.getName()).append(" on object ").append(lllllllllllllIlIIllllIllIIllIllI).append(" : ").append(lllllllllllllIlIIllllIllIIlllIII)));
        }
    }
}
