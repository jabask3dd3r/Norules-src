package com.viaversion.viaversion.libs.gson.reflect;

import java.util.*;
import java.lang.reflect.*;
import com.viaversion.viaversion.libs.gson.internal.*;

public class TypeToken<T>
{
    final /* synthetic */ Type type;
    final /* synthetic */ int hashCode;
    final /* synthetic */ Class<? super T> rawType;
    
    private static boolean typeEquals(final ParameterizedType lllllllllllllIIllIIIIIIlIIlIlIlI, final ParameterizedType lllllllllllllIIllIIIIIIlIIlIIllI, final Map<String, Type> lllllllllllllIIllIIIIIIlIIlIIlIl) {
        if (lllllllllllllIIllIIIIIIlIIlIlIlI.getRawType().equals(lllllllllllllIIllIIIIIIlIIlIIllI.getRawType())) {
            final Type[] lllllllllllllIIllIIIIIIlIIlIllII = lllllllllllllIIllIIIIIIlIIlIlIlI.getActualTypeArguments();
            final Type[] lllllllllllllIIllIIIIIIlIIlIlIll = lllllllllllllIIllIIIIIIlIIlIIllI.getActualTypeArguments();
            for (int lllllllllllllIIllIIIIIIlIIlIllIl = 0; lllllllllllllIIllIIIIIIlIIlIllIl < lllllllllllllIIllIIIIIIlIIlIllII.length; ++lllllllllllllIIllIIIIIIlIIlIllIl) {
                if (!matches(lllllllllllllIIllIIIIIIlIIlIllII[lllllllllllllIIllIIIIIIlIIlIllIl], lllllllllllllIIllIIIIIIlIIlIlIll[lllllllllllllIIllIIIIIIlIIlIllIl], lllllllllllllIIllIIIIIIlIIlIIlIl)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    static Type getSuperclassTypeParameter(final Class<?> lllllllllllllIIllIIIIIIllIIIIIII) {
        final Type lllllllllllllIIllIIIIIIllIIIIIlI = lllllllllllllIIllIIIIIIllIIIIIII.getGenericSuperclass();
        if (lllllllllllllIIllIIIIIIllIIIIIlI instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        final ParameterizedType lllllllllllllIIllIIIIIIllIIIIIIl = (ParameterizedType)lllllllllllllIIllIIIIIIllIIIIIlI;
        return $Gson$Types.canonicalize(lllllllllllllIIllIIIIIIllIIIIIIl.getActualTypeArguments()[0]);
    }
    
    @Override
    public final String toString() {
        return $Gson$Types.typeToString(this.type);
    }
    
    protected TypeToken() {
        this.type = getSuperclassTypeParameter(this.getClass());
        this.rawType = (Class<? super T>)$Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }
    
    private static boolean matches(final Type lllllllllllllIIllIIIIIIlIIIIllII, final Type lllllllllllllIIllIIIIIIlIIIIlIII, final Map<String, Type> lllllllllllllIIllIIIIIIlIIIIIlll) {
        return lllllllllllllIIllIIIIIIlIIIIlIII.equals(lllllllllllllIIllIIIIIIlIIIIllII) || (lllllllllllllIIllIIIIIIlIIIIllII instanceof TypeVariable && lllllllllllllIIllIIIIIIlIIIIlIII.equals(lllllllllllllIIllIIIIIIlIIIIIlll.get(((TypeVariable)lllllllllllllIIllIIIIIIlIIIIllII).getName())));
    }
    
    @Deprecated
    public boolean isAssignableFrom(final TypeToken<?> lllllllllllllIIllIIIIIIlIllIIllI) {
        return this.isAssignableFrom(lllllllllllllIIllIIIIIIlIllIIllI.getType());
    }
    
    public final Class<? super T> getRawType() {
        return this.rawType;
    }
    
    @Deprecated
    public boolean isAssignableFrom(final Class<?> lllllllllllllIIllIIIIIIlIlllIIlI) {
        return this.isAssignableFrom((Type)lllllllllllllIIllIIIIIIlIlllIIlI);
    }
    
    public static TypeToken<?> getParameterized(final Type lllllllllllllIIllIIIIIIIllllIIlI, final Type... lllllllllllllIIllIIIIIIIllllIIIl) {
        return new TypeToken<Object>($Gson$Types.newParameterizedTypeWithOwner(null, lllllllllllllIIllIIIIIIIllllIIlI, lllllllllllllIIllIIIIIIIllllIIIl));
    }
    
    private static AssertionError buildUnexpectedTypeError(final Type lllllllllllllIIllIIIIIIlIIIlIllI, final Class<?>... lllllllllllllIIllIIIIIIlIIIlIlIl) {
        final StringBuilder lllllllllllllIIllIIIIIIlIIIlIlll = new StringBuilder("Unexpected type. Expected one of: ");
        final byte lllllllllllllIIllIIIIIIlIIIlIIll = (Object)lllllllllllllIIllIIIIIIlIIIlIlIl;
        final byte lllllllllllllIIllIIIIIIlIIIlIIlI = (byte)lllllllllllllIIllIIIIIIlIIIlIIll.length;
        for (short lllllllllllllIIllIIIIIIlIIIlIIIl = 0; lllllllllllllIIllIIIIIIlIIIlIIIl < lllllllllllllIIllIIIIIIlIIIlIIlI; ++lllllllllllllIIllIIIIIIlIIIlIIIl) {
            final Class<?> lllllllllllllIIllIIIIIIlIIIllIlI = lllllllllllllIIllIIIIIIlIIIlIIll[lllllllllllllIIllIIIIIIlIIIlIIIl];
            lllllllllllllIIllIIIIIIlIIIlIlll.append(lllllllllllllIIllIIIIIIlIIIllIlI.getName()).append(", ");
        }
        lllllllllllllIIllIIIIIIlIIIlIlll.append("but got: ").append(lllllllllllllIIllIIIIIIlIIIlIllI.getClass().getName()).append(", for type token: ").append(lllllllllllllIIllIIIIIIlIIIlIllI.toString()).append('.');
        return new AssertionError((Object)String.valueOf(lllllllllllllIIllIIIIIIlIIIlIlll));
    }
    
    public final Type getType() {
        return this.type;
    }
    
    public static TypeToken<?> get(final Type lllllllllllllIIllIIIIIIIlllllIII) {
        return new TypeToken<Object>(lllllllllllllIIllIIIIIIIlllllIII);
    }
    
    public static TypeToken<?> getArray(final Type lllllllllllllIIllIIIIIIIlllIllII) {
        return new TypeToken<Object>($Gson$Types.arrayOf(lllllllllllllIIllIIIIIIIlllIllII));
    }
    
    @Deprecated
    public boolean isAssignableFrom(final Type lllllllllllllIIllIIIIIIlIllIllII) {
        if (lllllllllllllIIllIIIIIIlIllIllII == null) {
            return false;
        }
        if (this.type.equals(lllllllllllllIIllIIIIIIlIllIllII)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom($Gson$Types.getRawType(lllllllllllllIIllIIIIIIlIllIllII));
        }
        if (this.type instanceof ParameterizedType) {
            return isAssignableFrom(lllllllllllllIIllIIIIIIlIllIllII, (ParameterizedType)this.type, new HashMap<String, Type>());
        }
        if (this.type instanceof GenericArrayType) {
            return this.rawType.isAssignableFrom($Gson$Types.getRawType(lllllllllllllIIllIIIIIIlIllIllII)) && isAssignableFrom(lllllllllllllIIllIIIIIIlIllIllII, (GenericArrayType)this.type);
        }
        throw buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
    }
    
    public static <T> TypeToken<T> get(final Class<T> lllllllllllllIIllIIIIIIIllllIllI) {
        return new TypeToken<T>(lllllllllllllIIllIIIIIIIllllIllI);
    }
    
    private static boolean isAssignableFrom(final Type lllllllllllllIIllIIIIIIlIlIllllI, final GenericArrayType lllllllllllllIIllIIIIIIlIlIlllIl) {
        final Type lllllllllllllIIllIIIIIIlIlIlllII = lllllllllllllIIllIIIIIIlIlIlllIl.getGenericComponentType();
        if (lllllllllllllIIllIIIIIIlIlIlllII instanceof ParameterizedType) {
            Type lllllllllllllIIllIIIIIIlIlIlllll = lllllllllllllIIllIIIIIIlIlIllllI;
            if (lllllllllllllIIllIIIIIIlIlIllllI instanceof GenericArrayType) {
                lllllllllllllIIllIIIIIIlIlIlllll = ((GenericArrayType)lllllllllllllIIllIIIIIIlIlIllllI).getGenericComponentType();
            }
            else if (lllllllllllllIIllIIIIIIlIlIllllI instanceof Class) {
                Class<?> lllllllllllllIIllIIIIIIlIllIIIII;
                for (lllllllllllllIIllIIIIIIlIllIIIII = (Class<?>)lllllllllllllIIllIIIIIIlIlIllllI; lllllllllllllIIllIIIIIIlIllIIIII.isArray(); lllllllllllllIIllIIIIIIlIllIIIII = lllllllllllllIIllIIIIIIlIllIIIII.getComponentType()) {}
                lllllllllllllIIllIIIIIIlIlIlllll = lllllllllllllIIllIIIIIIlIllIIIII;
            }
            return isAssignableFrom(lllllllllllllIIllIIIIIIlIlIlllll, (ParameterizedType)lllllllllllllIIllIIIIIIlIlIlllII, new HashMap<String, Type>());
        }
        return true;
    }
    
    TypeToken(final Type lllllllllllllIIllIIIIIIllIIIIlll) {
        this.type = $Gson$Types.canonicalize($Gson$Preconditions.checkNotNull(lllllllllllllIIllIIIIIIllIIIIlll));
        this.rawType = (Class<? super T>)$Gson$Types.getRawType(this.type);
        this.hashCode = this.type.hashCode();
    }
    
    @Override
    public final boolean equals(final Object lllllllllllllIIllIIIIIIlIIIIIIII) {
        return lllllllllllllIIllIIIIIIlIIIIIIII instanceof TypeToken && $Gson$Types.equals(this.type, ((TypeToken)lllllllllllllIIllIIIIIIlIIIIIIII).type);
    }
    
    private static boolean isAssignableFrom(final Type lllllllllllllIIllIIIIIIlIIlllllI, final ParameterizedType lllllllllllllIIllIIIIIIlIlIIIIll, final Map<String, Type> lllllllllllllIIllIIIIIIlIlIIIIlI) {
        if (lllllllllllllIIllIIIIIIlIIlllllI == null) {
            return false;
        }
        if (lllllllllllllIIllIIIIIIlIlIIIIll.equals(lllllllllllllIIllIIIIIIlIIlllllI)) {
            return true;
        }
        final Class<?> lllllllllllllIIllIIIIIIlIlIIIIIl = $Gson$Types.getRawType(lllllllllllllIIllIIIIIIlIIlllllI);
        ParameterizedType lllllllllllllIIllIIIIIIlIlIIIIII = null;
        if (lllllllllllllIIllIIIIIIlIIlllllI instanceof ParameterizedType) {
            lllllllllllllIIllIIIIIIlIlIIIIII = (ParameterizedType)lllllllllllllIIllIIIIIIlIIlllllI;
        }
        if (lllllllllllllIIllIIIIIIlIlIIIIII != null) {
            final Type[] lllllllllllllIIllIIIIIIlIlIIIlll = lllllllllllllIIllIIIIIIlIlIIIIII.getActualTypeArguments();
            final TypeVariable<?>[] lllllllllllllIIllIIIIIIlIlIIIllI = lllllllllllllIIllIIIIIIlIlIIIIIl.getTypeParameters();
            for (int lllllllllllllIIllIIIIIIlIlIIlIII = 0; lllllllllllllIIllIIIIIIlIlIIlIII < lllllllllllllIIllIIIIIIlIlIIIlll.length; ++lllllllllllllIIllIIIIIIlIlIIlIII) {
                Type lllllllllllllIIllIIIIIIlIlIIlIlI = lllllllllllllIIllIIIIIIlIlIIIlll[lllllllllllllIIllIIIIIIlIlIIlIII];
                final TypeVariable<?> lllllllllllllIIllIIIIIIlIlIIlIIl = lllllllllllllIIllIIIIIIlIlIIIllI[lllllllllllllIIllIIIIIIlIlIIlIII];
                while (lllllllllllllIIllIIIIIIlIlIIlIlI instanceof TypeVariable) {
                    final TypeVariable<?> lllllllllllllIIllIIIIIIlIlIIlIll = (TypeVariable<?>)lllllllllllllIIllIIIIIIlIlIIlIlI;
                    lllllllllllllIIllIIIIIIlIlIIlIlI = lllllllllllllIIllIIIIIIlIlIIIIlI.get(lllllllllllllIIllIIIIIIlIlIIlIll.getName());
                }
                lllllllllllllIIllIIIIIIlIlIIIIlI.put(lllllllllllllIIllIIIIIIlIlIIlIIl.getName(), lllllllllllllIIllIIIIIIlIlIIlIlI);
            }
            if (typeEquals(lllllllllllllIIllIIIIIIlIlIIIIII, lllllllllllllIIllIIIIIIlIlIIIIll, lllllllllllllIIllIIIIIIlIlIIIIlI)) {
                return true;
            }
        }
        final Type[] genericInterfaces = lllllllllllllIIllIIIIIIlIlIIIIIl.getGenericInterfaces();
        final int length = genericInterfaces.length;
        for (byte lllllllllllllIIllIIIIIIlIIllIlll = 0; lllllllllllllIIllIIIIIIlIIllIlll < length; ++lllllllllllllIIllIIIIIIlIIllIlll) {
            final Type lllllllllllllIIllIIIIIIlIlIIIlIl = genericInterfaces[lllllllllllllIIllIIIIIIlIIllIlll];
            if (isAssignableFrom(lllllllllllllIIllIIIIIIlIlIIIlIl, lllllllllllllIIllIIIIIIlIlIIIIll, new HashMap<String, Type>(lllllllllllllIIllIIIIIIlIlIIIIlI))) {
                return true;
            }
        }
        final Type lllllllllllllIIllIIIIIIlIIllllll = lllllllllllllIIllIIIIIIlIlIIIIIl.getGenericSuperclass();
        return isAssignableFrom(lllllllllllllIIllIIIIIIlIIllllll, lllllllllllllIIllIIIIIIlIlIIIIll, new HashMap<String, Type>(lllllllllllllIIllIIIIIIlIlIIIIlI));
    }
    
    @Override
    public final int hashCode() {
        return this.hashCode;
    }
}
