package com.viaversion.viaversion.libs.gson.internal;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable
{
    private final /* synthetic */ Type ownerType;
    private final /* synthetic */ Type[] typeArguments;
    private final /* synthetic */ Type rawType;
    
    @Override
    public Type[] getActualTypeArguments() {
        return this.typeArguments.clone();
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIllllllllIlIlIIIlI) {
        return llllllllllllllIllllllllIlIlIIIlI instanceof ParameterizedType && $Gson$Types.equals(this, (Type)llllllllllllllIllllllllIlIlIIIlI);
    }
    
    public ParameterizedTypeImpl(final Type llllllllllllllIllllllllIllIllIll, final Type llllllllllllllIllllllllIllIlIIII, final Type... llllllllllllllIllllllllIllIlIllI) {
        if (llllllllllllllIllllllllIllIlIIII instanceof Class) {
            final Class<?> llllllllllllllIllllllllIlllIIlll = (Class<?>)llllllllllllllIllllllllIllIlIIII;
            final boolean llllllllllllllIllllllllIlllIIlII = Modifier.isStatic(llllllllllllllIllllllllIlllIIlll.getModifiers()) || llllllllllllllIllllllllIlllIIlll.getEnclosingClass() == null;
            $Gson$Preconditions.checkArgument(llllllllllllllIllllllllIllIllIll != null || llllllllllllllIllllllllIlllIIlII);
        }
        this.ownerType = ((llllllllllllllIllllllllIllIllIll == null) ? null : $Gson$Types.canonicalize(llllllllllllllIllllllllIllIllIll));
        this.rawType = $Gson$Types.canonicalize(llllllllllllllIllllllllIllIlIIII);
        this.typeArguments = llllllllllllllIllllllllIllIlIllI.clone();
        for (int llllllllllllllIllllllllIlllIIIIl = 0, llllllllllllllIllllllllIllIlllll = this.typeArguments.length; llllllllllllllIllllllllIlllIIIIl < llllllllllllllIllllllllIllIlllll; ++llllllllllllllIllllllllIlllIIIIl) {
            $Gson$Preconditions.checkNotNull(this.typeArguments[llllllllllllllIllllllllIlllIIIIl]);
            $Gson$Types.checkNotPrimitive(this.typeArguments[llllllllllllllIllllllllIlllIIIIl]);
            this.typeArguments[llllllllllllllIllllllllIlllIIIIl] = $Gson$Types.canonicalize(this.typeArguments[llllllllllllllIllllllllIlllIIIIl]);
        }
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode() ^ $Gson$Types.hashCodeOrZero(this.ownerType);
    }
    
    @Override
    public String toString() {
        final int llllllllllllllIllllllllIIlllIIll = this.typeArguments.length;
        if (llllllllllllllIllllllllIIlllIIll == 0) {
            return $Gson$Types.typeToString(this.rawType);
        }
        final StringBuilder llllllllllllllIllllllllIIlllIIII = new StringBuilder(30 * (llllllllllllllIllllllllIIlllIIll + 1));
        llllllllllllllIllllllllIIlllIIII.append($Gson$Types.typeToString(this.rawType)).append("<").append($Gson$Types.typeToString(this.typeArguments[0]));
        for (int llllllllllllllIllllllllIIlllIlll = 1; llllllllllllllIllllllllIIlllIlll < llllllllllllllIllllllllIIlllIIll; ++llllllllllllllIllllllllIIlllIlll) {
            llllllllllllllIllllllllIIlllIIII.append(", ").append($Gson$Types.typeToString(this.typeArguments[llllllllllllllIllllllllIIlllIlll]));
        }
        return String.valueOf(llllllllllllllIllllllllIIlllIIII.append(">"));
    }
    
    @Override
    public Type getOwnerType() {
        return this.ownerType;
    }
    
    @Override
    public Type getRawType() {
        return this.rawType;
    }
}
