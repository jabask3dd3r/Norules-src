package com.viaversion.viaversion.libs.gson.internal;

import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public final class $Gson$Types
{
    static final /* synthetic */ Type[] EMPTY_TYPE_ARRAY;
    
    public static Type getCollectionElementType(final Type lllllllllllllIlIlIlIlIIIIIlIllll, final Class<?> lllllllllllllIlIlIlIlIIIIIlIlllI) {
        Type lllllllllllllIlIlIlIlIIIIIllIIII = getSupertype(lllllllllllllIlIlIlIlIIIIIlIllll, lllllllllllllIlIlIlIlIIIIIlIlllI, Collection.class);
        if (lllllllllllllIlIlIlIlIIIIIllIIII instanceof WildcardType) {
            lllllllllllllIlIlIlIlIIIIIllIIII = ((WildcardType)lllllllllllllIlIlIlIlIIIIIllIIII).getUpperBounds()[0];
        }
        if (lllllllllllllIlIlIlIlIIIIIllIIII instanceof ParameterizedType) {
            return ((ParameterizedType)lllllllllllllIlIlIlIlIIIIIllIIII).getActualTypeArguments()[0];
        }
        return Object.class;
    }
    
    static boolean equal(final Object lllllllllllllIlIlIlIlIIIIlllIIII, final Object lllllllllllllIlIlIlIlIIIIllIllll) {
        return lllllllllllllIlIlIlIlIIIIlllIIII == lllllllllllllIlIlIlIlIIIIllIllll || (lllllllllllllIlIlIlIlIIIIlllIIII != null && lllllllllllllIlIlIlIlIIIIlllIIII.equals(lllllllllllllIlIlIlIlIIIIllIllll));
    }
    
    static Type getGenericSupertype(final Type lllllllllllllIlIlIlIlIIIIlIIIlll, Class<?> lllllllllllllIlIlIlIlIIIIlIIIllI, final Class<?> lllllllllllllIlIlIlIlIIIIlIIlIII) {
        if (lllllllllllllIlIlIlIlIIIIlIIlIII == lllllllllllllIlIlIlIlIIIIlIIIllI) {
            return lllllllllllllIlIlIlIlIIIIlIIIlll;
        }
        if (lllllllllllllIlIlIlIlIIIIlIIlIII.isInterface()) {
            final Class<?>[] lllllllllllllIlIlIlIlIIIIlIIllII = lllllllllllllIlIlIlIlIIIIlIIIllI.getInterfaces();
            for (int lllllllllllllIlIlIlIlIIIIlIIlllI = 0, lllllllllllllIlIlIlIlIIIIlIIllIl = lllllllllllllIlIlIlIlIIIIlIIllII.length; lllllllllllllIlIlIlIlIIIIlIIlllI < lllllllllllllIlIlIlIlIIIIlIIllIl; ++lllllllllllllIlIlIlIlIIIIlIIlllI) {
                if (lllllllllllllIlIlIlIlIIIIlIIllII[lllllllllllllIlIlIlIlIIIIlIIlllI] == lllllllllllllIlIlIlIlIIIIlIIlIII) {
                    return lllllllllllllIlIlIlIlIIIIlIIIllI.getGenericInterfaces()[lllllllllllllIlIlIlIlIIIIlIIlllI];
                }
                if (lllllllllllllIlIlIlIlIIIIlIIlIII.isAssignableFrom(lllllllllllllIlIlIlIlIIIIlIIllII[lllllllllllllIlIlIlIlIIIIlIIlllI])) {
                    return getGenericSupertype(lllllllllllllIlIlIlIlIIIIlIIIllI.getGenericInterfaces()[lllllllllllllIlIlIlIlIIIIlIIlllI], lllllllllllllIlIlIlIlIIIIlIIllII[lllllllllllllIlIlIlIlIIIIlIIlllI], lllllllllllllIlIlIlIlIIIIlIIlIII);
                }
            }
        }
        if (!lllllllllllllIlIlIlIlIIIIlIIIllI.isInterface()) {
            while (lllllllllllllIlIlIlIlIIIIlIIIllI != Object.class) {
                final Class<?> lllllllllllllIlIlIlIlIIIIlIIlIll = lllllllllllllIlIlIlIlIIIIlIIIllI.getSuperclass();
                if (lllllllllllllIlIlIlIlIIIIlIIlIll == lllllllllllllIlIlIlIlIIIIlIIlIII) {
                    return lllllllllllllIlIlIlIlIIIIlIIIllI.getGenericSuperclass();
                }
                if (lllllllllllllIlIlIlIlIIIIlIIlIII.isAssignableFrom(lllllllllllllIlIlIlIlIIIIlIIlIll)) {
                    return getGenericSupertype(lllllllllllllIlIlIlIlIIIIlIIIllI.getGenericSuperclass(), lllllllllllllIlIlIlIlIIIIlIIlIll, lllllllllllllIlIlIlIlIIIIlIIlIII);
                }
                lllllllllllllIlIlIlIlIIIIlIIIllI = lllllllllllllIlIlIlIlIIIIlIIlIll;
            }
        }
        return lllllllllllllIlIlIlIlIIIIlIIlIII;
    }
    
    private static Type resolve(final Type lllllllllllllIlIlIlIIlllllllIIll, final Class<?> lllllllllllllIlIlIlIIlllllllIIlI, Type lllllllllllllIlIlIlIIlllllllIIIl, final Collection<TypeVariable> lllllllllllllIlIlIlIIlllllllIlII) {
        while (lllllllllllllIlIlIlIIlllllllIIIl instanceof TypeVariable) {
            final TypeVariable<?> lllllllllllllIlIlIlIlIIIIIIIlIll = (TypeVariable<?>)lllllllllllllIlIlIlIIlllllllIIIl;
            if (lllllllllllllIlIlIlIIlllllllIlII.contains(lllllllllllllIlIlIlIlIIIIIIIlIll)) {
                return lllllllllllllIlIlIlIIlllllllIIIl;
            }
            lllllllllllllIlIlIlIIlllllllIlII.add(lllllllllllllIlIlIlIlIIIIIIIlIll);
            lllllllllllllIlIlIlIIlllllllIIIl = resolveTypeVariable(lllllllllllllIlIlIlIIlllllllIIll, lllllllllllllIlIlIlIIlllllllIIlI, lllllllllllllIlIlIlIlIIIIIIIlIll);
            if (lllllllllllllIlIlIlIIlllllllIIIl == lllllllllllllIlIlIlIlIIIIIIIlIll) {
                return lllllllllllllIlIlIlIIlllllllIIIl;
            }
        }
        if (lllllllllllllIlIlIlIIlllllllIIIl instanceof Class && ((Class)lllllllllllllIlIlIlIIlllllllIIIl).isArray()) {
            final Class<?> lllllllllllllIlIlIlIlIIIIIIIlIlI = (Class<?>)lllllllllllllIlIlIlIIlllllllIIIl;
            final Type lllllllllllllIlIlIlIlIIIIIIIlIIl = lllllllllllllIlIlIlIlIIIIIIIlIlI.getComponentType();
            final Type lllllllllllllIlIlIlIlIIIIIIIlIII = resolve(lllllllllllllIlIlIlIIlllllllIIll, lllllllllllllIlIlIlIIlllllllIIlI, lllllllllllllIlIlIlIlIIIIIIIlIIl, lllllllllllllIlIlIlIIlllllllIlII);
            return (Type)((lllllllllllllIlIlIlIlIIIIIIIlIIl == lllllllllllllIlIlIlIlIIIIIIIlIII) ? lllllllllllllIlIlIlIlIIIIIIIlIlI : arrayOf(lllllllllllllIlIlIlIlIIIIIIIlIII));
        }
        if (lllllllllllllIlIlIlIIlllllllIIIl instanceof GenericArrayType) {
            final GenericArrayType lllllllllllllIlIlIlIlIIIIIIIIlll = (GenericArrayType)lllllllllllllIlIlIlIIlllllllIIIl;
            final Type lllllllllllllIlIlIlIlIIIIIIIIllI = lllllllllllllIlIlIlIlIIIIIIIIlll.getGenericComponentType();
            final Type lllllllllllllIlIlIlIlIIIIIIIIlIl = resolve(lllllllllllllIlIlIlIIlllllllIIll, lllllllllllllIlIlIlIIlllllllIIlI, lllllllllllllIlIlIlIlIIIIIIIIllI, lllllllllllllIlIlIlIIlllllllIlII);
            return (lllllllllllllIlIlIlIlIIIIIIIIllI == lllllllllllllIlIlIlIlIIIIIIIIlIl) ? lllllllllllllIlIlIlIlIIIIIIIIlll : arrayOf(lllllllllllllIlIlIlIlIIIIIIIIlIl);
        }
        if (lllllllllllllIlIlIlIIlllllllIIIl instanceof ParameterizedType) {
            final ParameterizedType lllllllllllllIlIlIlIlIIIIIIIIIIl = (ParameterizedType)lllllllllllllIlIlIlIIlllllllIIIl;
            final Type lllllllllllllIlIlIlIlIIIIIIIIIII = lllllllllllllIlIlIlIlIIIIIIIIIIl.getOwnerType();
            final Type lllllllllllllIlIlIlIIlllllllllll = resolve(lllllllllllllIlIlIlIIlllllllIIll, lllllllllllllIlIlIlIIlllllllIIlI, lllllllllllllIlIlIlIlIIIIIIIIIII, lllllllllllllIlIlIlIIlllllllIlII);
            boolean lllllllllllllIlIlIlIIllllllllllI = lllllllllllllIlIlIlIIlllllllllll != lllllllllllllIlIlIlIlIIIIIIIIIII;
            Type[] lllllllllllllIlIlIlIIlllllllllIl = lllllllllllllIlIlIlIlIIIIIIIIIIl.getActualTypeArguments();
            for (int lllllllllllllIlIlIlIlIIIIIIIIIll = 0, lllllllllllllIlIlIlIlIIIIIIIIIlI = lllllllllllllIlIlIlIIlllllllllIl.length; lllllllllllllIlIlIlIlIIIIIIIIIll < lllllllllllllIlIlIlIlIIIIIIIIIlI; ++lllllllllllllIlIlIlIlIIIIIIIIIll) {
                final Type lllllllllllllIlIlIlIlIIIIIIIIlII = resolve(lllllllllllllIlIlIlIIlllllllIIll, lllllllllllllIlIlIlIIlllllllIIlI, lllllllllllllIlIlIlIIlllllllllIl[lllllllllllllIlIlIlIlIIIIIIIIIll], lllllllllllllIlIlIlIIlllllllIlII);
                if (lllllllllllllIlIlIlIlIIIIIIIIlII != lllllllllllllIlIlIlIIlllllllllIl[lllllllllllllIlIlIlIlIIIIIIIIIll]) {
                    if (!lllllllllllllIlIlIlIIllllllllllI) {
                        lllllllllllllIlIlIlIIlllllllllIl = lllllllllllllIlIlIlIIlllllllllIl.clone();
                        lllllllllllllIlIlIlIIllllllllllI = true;
                    }
                    lllllllllllllIlIlIlIIlllllllllIl[lllllllllllllIlIlIlIlIIIIIIIIIll] = lllllllllllllIlIlIlIlIIIIIIIIlII;
                }
            }
            return lllllllllllllIlIlIlIIllllllllllI ? newParameterizedTypeWithOwner(lllllllllllllIlIlIlIIlllllllllll, lllllllllllllIlIlIlIlIIIIIIIIIIl.getRawType(), lllllllllllllIlIlIlIIlllllllllIl) : lllllllllllllIlIlIlIlIIIIIIIIIIl;
        }
        if (lllllllllllllIlIlIlIIlllllllIIIl instanceof WildcardType) {
            final WildcardType lllllllllllllIlIlIlIIllllllllIlI = (WildcardType)lllllllllllllIlIlIlIIlllllllIIIl;
            final Type[] lllllllllllllIlIlIlIIllllllllIIl = lllllllllllllIlIlIlIIllllllllIlI.getLowerBounds();
            final Type[] lllllllllllllIlIlIlIIllllllllIII = lllllllllllllIlIlIlIIllllllllIlI.getUpperBounds();
            if (lllllllllllllIlIlIlIIllllllllIIl.length == 1) {
                final Type lllllllllllllIlIlIlIIlllllllllII = resolve(lllllllllllllIlIlIlIIlllllllIIll, lllllllllllllIlIlIlIIlllllllIIlI, lllllllllllllIlIlIlIIllllllllIIl[0], lllllllllllllIlIlIlIIlllllllIlII);
                if (lllllllllllllIlIlIlIIlllllllllII != lllllllllllllIlIlIlIIllllllllIIl[0]) {
                    return supertypeOf(lllllllllllllIlIlIlIIlllllllllII);
                }
            }
            else if (lllllllllllllIlIlIlIIllllllllIII.length == 1) {
                final Type lllllllllllllIlIlIlIIllllllllIll = resolve(lllllllllllllIlIlIlIIlllllllIIll, lllllllllllllIlIlIlIIlllllllIIlI, lllllllllllllIlIlIlIIllllllllIII[0], lllllllllllllIlIlIlIIlllllllIlII);
                if (lllllllllllllIlIlIlIIllllllllIll != lllllllllllllIlIlIlIIllllllllIII[0]) {
                    return subtypeOf(lllllllllllllIlIlIlIIllllllllIll);
                }
            }
            return lllllllllllllIlIlIlIIllllllllIlI;
        }
        return lllllllllllllIlIlIlIIlllllllIIIl;
    }
    
    public static Type[] getMapKeyAndValueTypes(final Type lllllllllllllIlIlIlIlIIIIIlIIlll, final Class<?> lllllllllllllIlIlIlIlIIIIIlIIllI) {
        if (lllllllllllllIlIlIlIlIIIIIlIIlll == Properties.class) {
            return new Type[] { String.class, String.class };
        }
        final Type lllllllllllllIlIlIlIlIIIIIlIIlIl = getSupertype(lllllllllllllIlIlIlIlIIIIIlIIlll, lllllllllllllIlIlIlIlIIIIIlIIllI, Map.class);
        if (lllllllllllllIlIlIlIlIIIIIlIIlIl instanceof ParameterizedType) {
            final ParameterizedType lllllllllllllIlIlIlIlIIIIIlIlIII = (ParameterizedType)lllllllllllllIlIlIlIlIIIIIlIIlIl;
            return lllllllllllllIlIlIlIlIIIIIlIlIII.getActualTypeArguments();
        }
        return new Type[] { Object.class, Object.class };
    }
    
    static {
        EMPTY_TYPE_ARRAY = new Type[0];
    }
    
    static Type resolveTypeVariable(final Type lllllllllllllIlIlIlIIllllllIIIII, final Class<?> lllllllllllllIlIlIlIIlllllIlllll, final TypeVariable<?> lllllllllllllIlIlIlIIlllllIllIIl) {
        final Class<?> lllllllllllllIlIlIlIIlllllIlllIl = declaringClassOf(lllllllllllllIlIlIlIIlllllIllIIl);
        if (lllllllllllllIlIlIlIIlllllIlllIl == null) {
            return lllllllllllllIlIlIlIIlllllIllIIl;
        }
        final Type lllllllllllllIlIlIlIIlllllIlllII = getGenericSupertype(lllllllllllllIlIlIlIIllllllIIIII, lllllllllllllIlIlIlIIlllllIlllll, lllllllllllllIlIlIlIIlllllIlllIl);
        if (lllllllllllllIlIlIlIIlllllIlllII instanceof ParameterizedType) {
            final int lllllllllllllIlIlIlIIllllllIIIIl = indexOf(lllllllllllllIlIlIlIIlllllIlllIl.getTypeParameters(), lllllllllllllIlIlIlIIlllllIllIIl);
            return ((ParameterizedType)lllllllllllllIlIlIlIIlllllIlllII).getActualTypeArguments()[lllllllllllllIlIlIlIIllllllIIIIl];
        }
        return lllllllllllllIlIlIlIIlllllIllIIl;
    }
    
    public static Type resolve(final Type lllllllllllllIlIlIlIlIIIIIIlllIl, final Class<?> lllllllllllllIlIlIlIlIIIIIIllIIl, final Type lllllllllllllIlIlIlIlIIIIIIllIll) {
        return resolve(lllllllllllllIlIlIlIlIIIIIIlllIl, lllllllllllllIlIlIlIlIIIIIIllIIl, lllllllllllllIlIlIlIlIIIIIIllIll, new HashSet<TypeVariable>());
    }
    
    static Type getSupertype(Type lllllllllllllIlIlIlIlIIIIIlllIll, final Class<?> lllllllllllllIlIlIlIlIIIIIllllIl, final Class<?> lllllllllllllIlIlIlIlIIIIIlllIIl) {
        if (lllllllllllllIlIlIlIlIIIIIlllIll instanceof WildcardType) {
            lllllllllllllIlIlIlIlIIIIIlllIll = ((WildcardType)lllllllllllllIlIlIlIlIIIIIlllIll).getUpperBounds()[0];
        }
        $Gson$Preconditions.checkArgument(lllllllllllllIlIlIlIlIIIIIlllIIl.isAssignableFrom(lllllllllllllIlIlIlIlIIIIIllllIl));
        return resolve(lllllllllllllIlIlIlIlIIIIIlllIll, lllllllllllllIlIlIlIlIIIIIllllIl, getGenericSupertype(lllllllllllllIlIlIlIlIIIIIlllIll, lllllllllllllIlIlIlIlIIIIIllllIl, lllllllllllllIlIlIlIlIIIIIlllIIl));
    }
    
    public static GenericArrayType arrayOf(final Type lllllllllllllIlIlIlIlIIIlIIlIllI) {
        return new GenericArrayTypeImpl(lllllllllllllIlIlIlIlIIIlIIlIllI);
    }
    
    public static String typeToString(final Type lllllllllllllIlIlIlIlIIIIlIlIllI) {
        return (lllllllllllllIlIlIlIlIIIIlIlIllI instanceof Class) ? ((Class)lllllllllllllIlIlIlIlIIIIlIlIllI).getName() : lllllllllllllIlIlIlIlIIIIlIlIllI.toString();
    }
    
    public static Type getArrayComponentType(final Type lllllllllllllIlIlIlIlIIIIIllIllI) {
        return (lllllllllllllIlIlIlIlIIIIIllIllI instanceof GenericArrayType) ? ((GenericArrayType)lllllllllllllIlIlIlIlIIIIIllIllI).getGenericComponentType() : ((Class)lllllllllllllIlIlIlIlIIIIIllIllI).getComponentType();
    }
    
    public static ParameterizedType newParameterizedTypeWithOwner(final Type lllllllllllllIlIlIlIlIIIlIIllIlI, final Type lllllllllllllIlIlIlIlIIIlIIllIIl, final Type... lllllllllllllIlIlIlIlIIIlIIllIll) {
        return new ParameterizedTypeImpl(lllllllllllllIlIlIlIlIIIlIIllIlI, lllllllllllllIlIlIlIlIIIlIIllIIl, lllllllllllllIlIlIlIlIIIlIIllIll);
    }
    
    public static boolean equals(final Type lllllllllllllIlIlIlIlIIIIlIllllI, final Type lllllllllllllIlIlIlIlIIIIlIlllIl) {
        if (lllllllllllllIlIlIlIlIIIIlIllllI == lllllllllllllIlIlIlIlIIIIlIlllIl) {
            return true;
        }
        if (lllllllllllllIlIlIlIlIIIIlIllllI instanceof Class) {
            return lllllllllllllIlIlIlIlIIIIlIllllI.equals(lllllllllllllIlIlIlIlIIIIlIlllIl);
        }
        if (lllllllllllllIlIlIlIlIIIIlIllllI instanceof ParameterizedType) {
            if (!(lllllllllllllIlIlIlIlIIIIlIlllIl instanceof ParameterizedType)) {
                return false;
            }
            final ParameterizedType lllllllllllllIlIlIlIlIIIIllIlIII = (ParameterizedType)lllllllllllllIlIlIlIlIIIIlIllllI;
            final ParameterizedType lllllllllllllIlIlIlIlIIIIllIIlll = (ParameterizedType)lllllllllllllIlIlIlIlIIIIlIlllIl;
            return equal(lllllllllllllIlIlIlIlIIIIllIlIII.getOwnerType(), lllllllllllllIlIlIlIlIIIIllIIlll.getOwnerType()) && lllllllllllllIlIlIlIlIIIIllIlIII.getRawType().equals(lllllllllllllIlIlIlIlIIIIllIIlll.getRawType()) && Arrays.equals(lllllllllllllIlIlIlIlIIIIllIlIII.getActualTypeArguments(), lllllllllllllIlIlIlIlIIIIllIIlll.getActualTypeArguments());
        }
        else if (lllllllllllllIlIlIlIlIIIIlIllllI instanceof GenericArrayType) {
            if (!(lllllllllllllIlIlIlIlIIIIlIlllIl instanceof GenericArrayType)) {
                return false;
            }
            final GenericArrayType lllllllllllllIlIlIlIlIIIIllIIllI = (GenericArrayType)lllllllllllllIlIlIlIlIIIIlIllllI;
            final GenericArrayType lllllllllllllIlIlIlIlIIIIllIIlIl = (GenericArrayType)lllllllllllllIlIlIlIlIIIIlIlllIl;
            return equals(lllllllllllllIlIlIlIlIIIIllIIllI.getGenericComponentType(), lllllllllllllIlIlIlIlIIIIllIIlIl.getGenericComponentType());
        }
        else if (lllllllllllllIlIlIlIlIIIIlIllllI instanceof WildcardType) {
            if (!(lllllllllllllIlIlIlIlIIIIlIlllIl instanceof WildcardType)) {
                return false;
            }
            final WildcardType lllllllllllllIlIlIlIlIIIIllIIlII = (WildcardType)lllllllllllllIlIlIlIlIIIIlIllllI;
            final WildcardType lllllllllllllIlIlIlIlIIIIllIIIll = (WildcardType)lllllllllllllIlIlIlIlIIIIlIlllIl;
            return Arrays.equals(lllllllllllllIlIlIlIlIIIIllIIlII.getUpperBounds(), lllllllllllllIlIlIlIlIIIIllIIIll.getUpperBounds()) && Arrays.equals(lllllllllllllIlIlIlIlIIIIllIIlII.getLowerBounds(), lllllllllllllIlIlIlIlIIIIllIIIll.getLowerBounds());
        }
        else {
            if (!(lllllllllllllIlIlIlIlIIIIlIllllI instanceof TypeVariable)) {
                return false;
            }
            if (!(lllllllllllllIlIlIlIlIIIIlIlllIl instanceof TypeVariable)) {
                return false;
            }
            final TypeVariable<?> lllllllllllllIlIlIlIlIIIIllIIIlI = (TypeVariable<?>)lllllllllllllIlIlIlIlIIIIlIllllI;
            final TypeVariable<?> lllllllllllllIlIlIlIlIIIIllIIIIl = (TypeVariable<?>)lllllllllllllIlIlIlIlIIIIlIlllIl;
            return lllllllllllllIlIlIlIlIIIIllIIIlI.getGenericDeclaration() == lllllllllllllIlIlIlIlIIIIllIIIIl.getGenericDeclaration() && lllllllllllllIlIlIlIlIIIIllIIIlI.getName().equals(lllllllllllllIlIlIlIlIIIIllIIIIl.getName());
        }
    }
    
    private static int indexOf(final Object[] lllllllllllllIlIlIlIIlllllIIllll, final Object lllllllllllllIlIlIlIIlllllIIlllI) {
        for (int lllllllllllllIlIlIlIIlllllIlIIIl = 0, lllllllllllllIlIlIlIIlllllIlIIII = lllllllllllllIlIlIlIIlllllIIllll.length; lllllllllllllIlIlIlIIlllllIlIIIl < lllllllllllllIlIlIlIIlllllIlIIII; ++lllllllllllllIlIlIlIIlllllIlIIIl) {
            if (lllllllllllllIlIlIlIIlllllIIlllI.equals(lllllllllllllIlIlIlIIlllllIIllll[lllllllllllllIlIlIlIIlllllIlIIIl])) {
                return lllllllllllllIlIlIlIIlllllIlIIIl;
            }
        }
        throw new NoSuchElementException();
    }
    
    private static Class<?> declaringClassOf(final TypeVariable<?> lllllllllllllIlIlIlIIlllllIIIlIl) {
        final GenericDeclaration lllllllllllllIlIlIlIIlllllIIIllI = (GenericDeclaration)lllllllllllllIlIlIlIIlllllIIIlIl.getGenericDeclaration();
        return (Class<?>)((lllllllllllllIlIlIlIIlllllIIIllI instanceof Class) ? ((Class)lllllllllllllIlIlIlIIlllllIIIllI) : null);
    }
    
    public static WildcardType supertypeOf(final Type lllllllllllllIlIlIlIlIIIlIIIlIlI) {
        Type[] lllllllllllllIlIlIlIlIIIlIIIlIIl = null;
        if (lllllllllllllIlIlIlIlIIIlIIIlIlI instanceof WildcardType) {
            final Type[] lllllllllllllIlIlIlIlIIIlIIIlIll = ((WildcardType)lllllllllllllIlIlIlIlIIIlIIIlIlI).getLowerBounds();
        }
        else {
            lllllllllllllIlIlIlIlIIIlIIIlIIl = new Type[] { lllllllllllllIlIlIlIlIIIlIIIlIlI };
        }
        return new WildcardTypeImpl(new Type[] { Object.class }, lllllllllllllIlIlIlIlIIIlIIIlIIl);
    }
    
    static void checkNotPrimitive(final Type lllllllllllllIlIlIlIIlllllIIIIlI) {
        $Gson$Preconditions.checkArgument(!(lllllllllllllIlIlIlIIlllllIIIIlI instanceof Class) || !((Class)lllllllllllllIlIlIlIIlllllIIIIlI).isPrimitive());
    }
    
    static int hashCodeOrZero(final Object lllllllllllllIlIlIlIlIIIIlIllIII) {
        return (lllllllllllllIlIlIlIlIIIIlIllIII != null) ? lllllllllllllIlIlIlIlIIIIlIllIII.hashCode() : 0;
    }
    
    private $Gson$Types() {
        throw new UnsupportedOperationException();
    }
    
    public static WildcardType subtypeOf(final Type lllllllllllllIlIlIlIlIIIlIIIllll) {
        Type[] lllllllllllllIlIlIlIlIIIlIIlIIII = null;
        if (lllllllllllllIlIlIlIlIIIlIIIllll instanceof WildcardType) {
            final Type[] lllllllllllllIlIlIlIlIIIlIIlIIlI = ((WildcardType)lllllllllllllIlIlIlIlIIIlIIIllll).getUpperBounds();
        }
        else {
            lllllllllllllIlIlIlIlIIIlIIlIIII = new Type[] { lllllllllllllIlIlIlIlIIIlIIIllll };
        }
        return new WildcardTypeImpl(lllllllllllllIlIlIlIlIIIlIIlIIII, $Gson$Types.EMPTY_TYPE_ARRAY);
    }
    
    public static Class<?> getRawType(final Type lllllllllllllIlIlIlIlIIIIlllIllI) {
        if (lllllllllllllIlIlIlIlIIIIlllIllI instanceof Class) {
            return (Class<?>)lllllllllllllIlIlIlIlIIIIlllIllI;
        }
        if (lllllllllllllIlIlIlIlIIIIlllIllI instanceof ParameterizedType) {
            final ParameterizedType lllllllllllllIlIlIlIlIIIIllllIlI = (ParameterizedType)lllllllllllllIlIlIlIlIIIIlllIllI;
            final Type lllllllllllllIlIlIlIlIIIIllllIIl = lllllllllllllIlIlIlIlIIIIllllIlI.getRawType();
            $Gson$Preconditions.checkArgument(lllllllllllllIlIlIlIlIIIIllllIIl instanceof Class);
            return (Class<?>)lllllllllllllIlIlIlIlIIIIllllIIl;
        }
        if (lllllllllllllIlIlIlIlIIIIlllIllI instanceof GenericArrayType) {
            final Type lllllllllllllIlIlIlIlIIIIllllIII = ((GenericArrayType)lllllllllllllIlIlIlIlIIIIlllIllI).getGenericComponentType();
            return Array.newInstance(getRawType(lllllllllllllIlIlIlIlIIIIllllIII), 0).getClass();
        }
        if (lllllllllllllIlIlIlIlIIIIlllIllI instanceof TypeVariable) {
            return Object.class;
        }
        if (lllllllllllllIlIlIlIlIIIIlllIllI instanceof WildcardType) {
            return getRawType(((WildcardType)lllllllllllllIlIlIlIlIIIIlllIllI).getUpperBounds()[0]);
        }
        final String lllllllllllllIlIlIlIlIIIIlllIlll = (lllllllllllllIlIlIlIlIIIIlllIllI == null) ? "null" : lllllllllllllIlIlIlIlIIIIlllIllI.getClass().getName();
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Expected a Class, ParameterizedType, or GenericArrayType, but <").append(lllllllllllllIlIlIlIlIIIIlllIllI).append("> is of type ").append(lllllllllllllIlIlIlIlIIIIlllIlll)));
    }
    
    public static Type canonicalize(final Type lllllllllllllIlIlIlIlIIIIlllllll) {
        if (lllllllllllllIlIlIlIlIIIIlllllll instanceof Class) {
            final Class<?> lllllllllllllIlIlIlIlIIIlIIIIlII = (Class<?>)lllllllllllllIlIlIlIlIIIIlllllll;
            return (Type)(lllllllllllllIlIlIlIlIIIlIIIIlII.isArray() ? new GenericArrayTypeImpl(canonicalize(lllllllllllllIlIlIlIlIIIlIIIIlII.getComponentType())) : lllllllllllllIlIlIlIlIIIlIIIIlII);
        }
        if (lllllllllllllIlIlIlIlIIIIlllllll instanceof ParameterizedType) {
            final ParameterizedType lllllllllllllIlIlIlIlIIIlIIIIIll = (ParameterizedType)lllllllllllllIlIlIlIlIIIIlllllll;
            return new ParameterizedTypeImpl(lllllllllllllIlIlIlIlIIIlIIIIIll.getOwnerType(), lllllllllllllIlIlIlIlIIIlIIIIIll.getRawType(), lllllllllllllIlIlIlIlIIIlIIIIIll.getActualTypeArguments());
        }
        if (lllllllllllllIlIlIlIlIIIIlllllll instanceof GenericArrayType) {
            final GenericArrayType lllllllllllllIlIlIlIlIIIlIIIIIlI = (GenericArrayType)lllllllllllllIlIlIlIlIIIIlllllll;
            return new GenericArrayTypeImpl(lllllllllllllIlIlIlIlIIIlIIIIIlI.getGenericComponentType());
        }
        if (lllllllllllllIlIlIlIlIIIIlllllll instanceof WildcardType) {
            final WildcardType lllllllllllllIlIlIlIlIIIlIIIIIIl = (WildcardType)lllllllllllllIlIlIlIlIIIIlllllll;
            return new WildcardTypeImpl(lllllllllllllIlIlIlIlIIIlIIIIIIl.getUpperBounds(), lllllllllllllIlIlIlIlIIIlIIIIIIl.getLowerBounds());
        }
        return lllllllllllllIlIlIlIlIIIIlllllll;
    }
    
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
}
