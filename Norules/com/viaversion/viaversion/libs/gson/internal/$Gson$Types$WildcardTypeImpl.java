package com.viaversion.viaversion.libs.gson.internal;

import java.io.*;
import java.lang.reflect.*;

private static final class WildcardTypeImpl implements WildcardType, Serializable
{
    private final /* synthetic */ Type lowerBound;
    private final /* synthetic */ Type upperBound;
    
    @Override
    public int hashCode() {
        return ((this.lowerBound != null) ? (31 + this.lowerBound.hashCode()) : 1) ^ 31 + this.upperBound.hashCode();
    }
    
    @Override
    public Type[] getUpperBounds() {
        return new Type[] { this.upperBound };
    }
    
    @Override
    public String toString() {
        if (this.lowerBound != null) {
            return String.valueOf(new StringBuilder().append("? super ").append($Gson$Types.typeToString(this.lowerBound)));
        }
        if (this.upperBound == Object.class) {
            return "?";
        }
        return String.valueOf(new StringBuilder().append("? extends ").append($Gson$Types.typeToString(this.upperBound)));
    }
    
    @Override
    public boolean equals(final Object llllllllllllllIIlllIlllllllIIIII) {
        return llllllllllllllIIlllIlllllllIIIII instanceof WildcardType && $Gson$Types.equals(this, (Type)llllllllllllllIIlllIlllllllIIIII);
    }
    
    @Override
    public Type[] getLowerBounds() {
        return (this.lowerBound != null) ? new Type[] { this.lowerBound } : $Gson$Types.EMPTY_TYPE_ARRAY;
    }
    
    public WildcardTypeImpl(final Type[] llllllllllllllIIlllIlllllllIllIl, final Type[] llllllllllllllIIlllIlllllllIllll) {
        $Gson$Preconditions.checkArgument(llllllllllllllIIlllIlllllllIllll.length <= 1);
        $Gson$Preconditions.checkArgument(llllllllllllllIIlllIlllllllIllIl.length == 1);
        if (llllllllllllllIIlllIlllllllIllll.length == 1) {
            $Gson$Preconditions.checkNotNull(llllllllllllllIIlllIlllllllIllll[0]);
            $Gson$Types.checkNotPrimitive(llllllllllllllIIlllIlllllllIllll[0]);
            $Gson$Preconditions.checkArgument(llllllllllllllIIlllIlllllllIllIl[0] == Object.class);
            this.lowerBound = $Gson$Types.canonicalize(llllllllllllllIIlllIlllllllIllll[0]);
            this.upperBound = Object.class;
        }
        else {
            $Gson$Preconditions.checkNotNull(llllllllllllllIIlllIlllllllIllIl[0]);
            $Gson$Types.checkNotPrimitive(llllllllllllllIIlllIlllllllIllIl[0]);
            this.lowerBound = null;
            this.upperBound = $Gson$Types.canonicalize(llllllllllllllIIlllIlllllllIllIl[0]);
        }
    }
}
