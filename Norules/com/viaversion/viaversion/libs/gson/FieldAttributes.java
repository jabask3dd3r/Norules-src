package com.viaversion.viaversion.libs.gson;

import java.lang.annotation.*;
import java.util.*;
import com.viaversion.viaversion.libs.gson.internal.*;
import java.lang.reflect.*;

public final class FieldAttributes
{
    private final /* synthetic */ Field field;
    
    public boolean hasModifier(final int lllllllllllllIlIIlllIllllllllllI) {
        return (this.field.getModifiers() & lllllllllllllIlIIlllIllllllllllI) != 0x0;
    }
    
    boolean isSynthetic() {
        return this.field.isSynthetic();
    }
    
    public String getName() {
        return this.field.getName();
    }
    
    Object get(final Object lllllllllllllIlIIlllIllllllllIII) throws IllegalAccessException {
        return this.field.get(lllllllllllllIlIIlllIllllllllIII);
    }
    
    public <T extends Annotation> T getAnnotation(final Class<T> lllllllllllllIlIIllllIIIIIIIIlIl) {
        return this.field.getAnnotation(lllllllllllllIlIIllllIIIIIIIIlIl);
    }
    
    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }
    
    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }
    
    public Class<?> getDeclaredClass() {
        return this.field.getType();
    }
    
    public FieldAttributes(final Field lllllllllllllIlIIllllIIIIIIlIlll) {
        $Gson$Preconditions.checkNotNull(lllllllllllllIlIIllllIIIIIIlIlll);
        this.field = lllllllllllllIlIIllllIIIIIIlIlll;
    }
    
    public Type getDeclaredType() {
        return this.field.getGenericType();
    }
}
