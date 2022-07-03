package org.yaml.snakeyaml.introspector;

import java.lang.annotation.*;
import java.util.*;

public class MissingProperty extends Property
{
    @Override
    public List<Annotation> getAnnotations() {
        return Collections.emptyList();
    }
    
    @Override
    public Class<?>[] getActualTypeArguments() {
        return (Class<?>[])new Class[0];
    }
    
    @Override
    public void set(final Object llllllllllllllllllIIIlIlllIlIlll, final Object llllllllllllllllllIIIlIlllIlIllI) throws Exception {
    }
    
    @Override
    public <A extends Annotation> A getAnnotation(final Class<A> llllllllllllllllllIIIlIlllIIllll) {
        return null;
    }
    
    @Override
    public Object get(final Object llllllllllllllllllIIIlIlllIlIIll) {
        return llllllllllllllllllIIIlIlllIlIIll;
    }
    
    public MissingProperty(final String llllllllllllllllllIIIlIlllIllIlI) {
        super(llllllllllllllllllIIIlIlllIllIlI, Object.class);
    }
}
