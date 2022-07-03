package org.yaml.snakeyaml.introspector;

import java.util.*;
import java.lang.annotation.*;

public abstract class Property implements Comparable<Property>
{
    private final /* synthetic */ String name;
    private final /* synthetic */ Class<?> type;
    
    public boolean isReadable() {
        return true;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append(this.getName()).append(" of ").append(this.getType()));
    }
    
    public abstract Class<?>[] getActualTypeArguments();
    
    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getType().hashCode();
    }
    
    public abstract List<Annotation> getAnnotations();
    
    public Property(final String lllllllllllllIIllIlIIIlIIIllIllI, final Class<?> lllllllllllllIIllIlIIIlIIIlllIII) {
        this.name = lllllllllllllIIllIlIIIlIIIllIllI;
        this.type = lllllllllllllIIllIlIIIlIIIlllIII;
    }
    
    public Class<?> getType() {
        return this.type;
    }
    
    public boolean isWritable() {
        return true;
    }
    
    public abstract <A extends Annotation> A getAnnotation(final Class<A> p0);
    
    @Override
    public boolean equals(final Object lllllllllllllIIllIlIIIlIIIIllIll) {
        if (lllllllllllllIIllIlIIIlIIIIllIll instanceof Property) {
            final Property lllllllllllllIIllIlIIIlIIIIlllIl = (Property)lllllllllllllIIllIlIIIlIIIIllIll;
            return this.getName().equals(lllllllllllllIIllIlIIIlIIIIlllIl.getName()) && this.getType().equals(lllllllllllllIIllIlIIIlIIIIlllIl.getType());
        }
        return false;
    }
    
    @Override
    public int compareTo(final Property lllllllllllllIIllIlIIIlIIIlIIllI) {
        return this.getName().compareTo(lllllllllllllIIllIlIIIlIIIlIIllI.getName());
    }
    
    public String getName() {
        return this.name;
    }
    
    public abstract void set(final Object p0, final Object p1) throws Exception;
    
    public abstract Object get(final Object p0);
}
