package com.viaversion.viaversion.libs.gson.internal;

import java.io.*;
import java.lang.reflect.*;

private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable
{
    private final /* synthetic */ Type componentType;
    
    @Override
    public Type getGenericComponentType() {
        return this.componentType;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIlllIllllllIllIIll) {
        return lllllllllllllIIlllIllllllIllIIll instanceof GenericArrayType && $Gson$Types.equals(this, (Type)lllllllllllllIIlllIllllllIllIIll);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append($Gson$Types.typeToString(this.componentType)).append("[]"));
    }
    
    public GenericArrayTypeImpl(final Type lllllllllllllIIlllIllllllIllllII) {
        this.componentType = $Gson$Types.canonicalize(lllllllllllllIIlllIllllllIllllII);
    }
    
    @Override
    public int hashCode() {
        return this.componentType.hashCode();
    }
}
