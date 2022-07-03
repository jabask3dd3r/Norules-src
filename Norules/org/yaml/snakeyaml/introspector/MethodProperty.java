package org.yaml.snakeyaml.introspector;

import java.beans.*;
import org.yaml.snakeyaml.error.*;
import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;
import org.yaml.snakeyaml.util.*;

public class MethodProperty extends GenericProperty
{
    private final /* synthetic */ boolean readable;
    private final /* synthetic */ PropertyDescriptor property;
    private final /* synthetic */ boolean writable;
    
    @Override
    public Object get(final Object lllllllllllllllllIIIlIllIIIIllIl) {
        try {
            this.property.getReadMethod().setAccessible(true);
            return this.property.getReadMethod().invoke(lllllllllllllllllIIIlIllIIIIllIl, new Object[0]);
        }
        catch (Exception lllllllllllllllllIIIlIllIIIlIIIl) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("Unable to find getter for property '").append(this.property.getName()).append("' on object ").append(lllllllllllllllllIIIlIllIIIIllIl).append(":").append(lllllllllllllllllIIIlIllIIIlIIIl)));
        }
    }
    
    private static Type discoverGenericType(final PropertyDescriptor lllllllllllllllllIIIlIllIIlIllIl) {
        final Method lllllllllllllllllIIIlIllIIllIIIl = lllllllllllllllllIIIlIllIIlIllIl.getReadMethod();
        if (lllllllllllllllllIIIlIllIIllIIIl != null) {
            return lllllllllllllllllIIIlIllIIllIIIl.getGenericReturnType();
        }
        final Method lllllllllllllllllIIIlIllIIlIllll = lllllllllllllllllIIIlIllIIlIllIl.getWriteMethod();
        if (lllllllllllllllllIIIlIllIIlIllll != null) {
            final Type[] lllllllllllllllllIIIlIllIIllIlII = lllllllllllllllllIIIlIllIIlIllll.getGenericParameterTypes();
            if (lllllllllllllllllIIIlIllIIllIlII.length > 0) {
                return lllllllllllllllllIIIlIllIIllIlII[0];
            }
        }
        return null;
    }
    
    @Override
    public void set(final Object lllllllllllllllllIIIlIllIIIllIIl, final Object lllllllllllllllllIIIlIllIIIllIII) throws Exception {
        if (!this.writable) {
            throw new YAMLException(String.valueOf(new StringBuilder().append("No writable property '").append(this.getName()).append("' on class: ").append(lllllllllllllllllIIIlIllIIIllIIl.getClass().getName())));
        }
        this.property.getWriteMethod().invoke(lllllllllllllllllIIIlIllIIIllIIl, lllllllllllllllllIIIlIllIIIllIII);
    }
    
    @Override
    public boolean isWritable() {
        return this.writable;
    }
    
    public MethodProperty(final PropertyDescriptor lllllllllllllllllIIIlIllIIlIIIII) {
        super(lllllllllllllllllIIIlIllIIlIIIII.getName(), lllllllllllllllllIIIlIllIIlIIIII.getPropertyType(), discoverGenericType(lllllllllllllllllIIIlIllIIlIIIII));
        this.property = lllllllllllllllllIIIlIllIIlIIIII;
        this.readable = (lllllllllllllllllIIIlIllIIlIIIII.getReadMethod() != null);
        this.writable = (lllllllllllllllllIIIlIllIIlIIIII.getWriteMethod() != null);
    }
    
    @Override
    public <A extends Annotation> A getAnnotation(final Class<A> lllllllllllllllllIIIlIlIllllllll) {
        A lllllllllllllllllIIIlIlIlllllllI = null;
        if (this.isReadable()) {
            lllllllllllllllllIIIlIlIlllllllI = this.property.getReadMethod().getAnnotation(lllllllllllllllllIIIlIlIllllllll);
        }
        if (lllllllllllllllllIIIlIlIlllllllI == null && this.isWritable()) {
            lllllllllllllllllIIIlIlIlllllllI = this.property.getWriteMethod().getAnnotation(lllllllllllllllllIIIlIlIllllllll);
        }
        return lllllllllllllllllIIIlIlIlllllllI;
    }
    
    @Override
    public List<Annotation> getAnnotations() {
        List<Annotation> lllllllllllllllllIIIlIllIIIIIllI = null;
        if (this.isReadable() && this.isWritable()) {
            final List<Annotation> lllllllllllllllllIIIlIllIIIIlIIl = ArrayUtils.toUnmodifiableCompositeList(this.property.getReadMethod().getAnnotations(), this.property.getWriteMethod().getAnnotations());
        }
        else if (this.isReadable()) {
            final List<Annotation> lllllllllllllllllIIIlIllIIIIlIII = ArrayUtils.toUnmodifiableList(this.property.getReadMethod().getAnnotations());
        }
        else {
            lllllllllllllllllIIIlIllIIIIIllI = ArrayUtils.toUnmodifiableList(this.property.getWriteMethod().getAnnotations());
        }
        return lllllllllllllllllIIIlIllIIIIIllI;
    }
    
    @Override
    public boolean isReadable() {
        return this.readable;
    }
}
