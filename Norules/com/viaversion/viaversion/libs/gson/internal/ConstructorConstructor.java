package com.viaversion.viaversion.libs.gson.internal;

import com.viaversion.viaversion.libs.gson.internal.reflect.*;
import com.viaversion.viaversion.libs.gson.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.libs.gson.reflect.*;
import java.util.*;
import java.lang.reflect.*;

public final class ConstructorConstructor
{
    private final /* synthetic */ ReflectionAccessor accessor;
    private final /* synthetic */ Map<Type, InstanceCreator<?>> instanceCreators;
    
    public ConstructorConstructor(final Map<Type, InstanceCreator<?>> lllllllllllllllIIIIllIIIllIIlIIl) {
        this.accessor = ReflectionAccessor.getInstance();
        this.instanceCreators = lllllllllllllllIIIIllIIIllIIlIIl;
    }
    
    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type lllllllllllllllIIIIllIIIlIlIIIlI, final Class<? super T> lllllllllllllllIIIIllIIIlIIllllI) {
        if (Collection.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
            if (SortedSet.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
                return new ObjectConstructor<T>() {
                    @Override
                    public T construct() {
                        return (T)new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
                return new ObjectConstructor<T>() {
                    @Override
                    public T construct() {
                        if (!(lllllllllllllllIIIIllIIIlIlIIIlI instanceof ParameterizedType)) {
                            throw new JsonIOException(String.valueOf(new StringBuilder().append("Invalid EnumSet type: ").append(lllllllllllllllIIIIllIIIlIlIIIlI.toString())));
                        }
                        final Type lllllllllllllIIIllIIllIlIIIlllII = ((ParameterizedType)lllllllllllllllIIIIllIIIlIlIIIlI).getActualTypeArguments()[0];
                        if (lllllllllllllIIIllIIllIlIIIlllII instanceof Class) {
                            return (T)EnumSet.noneOf((Class<Enum>)lllllllllllllIIIllIIllIlIIIlllII);
                        }
                        throw new JsonIOException(String.valueOf(new StringBuilder().append("Invalid EnumSet type: ").append(lllllllllllllllIIIIllIIIlIlIIIlI.toString())));
                    }
                };
            }
            if (Set.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
                return new ObjectConstructor<T>() {
                    @Override
                    public T construct() {
                        return (T)new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
                return new ObjectConstructor<T>() {
                    @Override
                    public T construct() {
                        return (T)new ArrayDeque();
                    }
                };
            }
            return new ObjectConstructor<T>() {
                @Override
                public T construct() {
                    return (T)new ArrayList();
                }
            };
        }
        else {
            if (!Map.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
                return null;
            }
            if (ConcurrentNavigableMap.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
                return new ObjectConstructor<T>() {
                    @Override
                    public T construct() {
                        return (T)new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
                return new ObjectConstructor<T>() {
                    @Override
                    public T construct() {
                        return (T)new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(lllllllllllllllIIIIllIIIlIIllllI)) {
                return new ObjectConstructor<T>() {
                    @Override
                    public T construct() {
                        return (T)new TreeMap();
                    }
                };
            }
            if (lllllllllllllllIIIIllIIIlIlIIIlI instanceof ParameterizedType && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType)lllllllllllllllIIIIllIIIlIlIIIlI).getActualTypeArguments()[0]).getRawType())) {
                return new ObjectConstructor<T>() {
                    @Override
                    public T construct() {
                        return (T)new LinkedHashMap();
                    }
                };
            }
            return new ObjectConstructor<T>() {
                @Override
                public T construct() {
                    return (T)new LinkedTreeMap();
                }
            };
        }
    }
    
    @Override
    public String toString() {
        return this.instanceCreators.toString();
    }
    
    public <T> ObjectConstructor<T> get(final TypeToken<T> lllllllllllllllIIIIllIIIlIllllll) {
        final Type lllllllllllllllIIIIllIIIlIlllllI = lllllllllllllllIIIIllIIIlIllllll.getType();
        final Class<? super T> lllllllllllllllIIIIllIIIlIllllIl = lllllllllllllllIIIIllIIIlIllllll.getRawType();
        final InstanceCreator<T> lllllllllllllllIIIIllIIIlIllllII = (InstanceCreator<T>)this.instanceCreators.get(lllllllllllllllIIIIllIIIlIlllllI);
        if (lllllllllllllllIIIIllIIIlIllllII != null) {
            return new ObjectConstructor<T>() {
                @Override
                public T construct() {
                    return lllllllllllllllIIIIllIIIlIllllII.createInstance(lllllllllllllllIIIIllIIIlIlllllI);
                }
            };
        }
        final InstanceCreator<T> lllllllllllllllIIIIllIIIlIlllIll = (InstanceCreator<T>)this.instanceCreators.get(lllllllllllllllIIIIllIIIlIllllIl);
        if (lllllllllllllllIIIIllIIIlIlllIll != null) {
            return new ObjectConstructor<T>() {
                @Override
                public T construct() {
                    return lllllllllllllllIIIIllIIIlIlllIll.createInstance(lllllllllllllllIIIIllIIIlIlllllI);
                }
            };
        }
        final ObjectConstructor<T> lllllllllllllllIIIIllIIIlIlllIlI = this.newDefaultConstructor(lllllllllllllllIIIIllIIIlIllllIl);
        if (lllllllllllllllIIIIllIIIlIlllIlI != null) {
            return lllllllllllllllIIIIllIIIlIlllIlI;
        }
        final ObjectConstructor<T> lllllllllllllllIIIIllIIIlIlllIIl = this.newDefaultImplementationConstructor(lllllllllllllllIIIIllIIIlIlllllI, lllllllllllllllIIIIllIIIlIllllIl);
        if (lllllllllllllllIIIIllIIIlIlllIIl != null) {
            return lllllllllllllllIIIIllIIIlIlllIIl;
        }
        return this.newUnsafeAllocator(lllllllllllllllIIIIllIIIlIlllllI, lllllllllllllllIIIIllIIIlIllllIl);
    }
    
    private <T> ObjectConstructor<T> newDefaultConstructor(final Class<? super T> lllllllllllllllIIIIllIIIlIlIlIlI) {
        try {
            final Constructor<? super T> lllllllllllllllIIIIllIIIlIlIllIl = lllllllllllllllIIIIllIIIlIlIlIlI.getDeclaredConstructor((Class<?>[])new Class[0]);
            if (!lllllllllllllllIIIIllIIIlIlIllIl.isAccessible()) {
                this.accessor.makeAccessible(lllllllllllllllIIIIllIIIlIlIllIl);
            }
            return new ObjectConstructor<T>() {
                @Override
                public T construct() {
                    try {
                        final Object[] lllllllllllllIllIIIIlllIlIlllIll = null;
                        return lllllllllllllllIIIIllIIIlIlIllIl.newInstance(lllllllllllllIllIIIIlllIlIlllIll);
                    }
                    catch (InstantiationException lllllllllllllIllIIIIlllIlIlllIlI) {
                        throw new RuntimeException(String.valueOf(new StringBuilder().append("Failed to invoke ").append(lllllllllllllllIIIIllIIIlIlIllIl).append(" with no args")), lllllllllllllIllIIIIlllIlIlllIlI);
                    }
                    catch (InvocationTargetException lllllllllllllIllIIIIlllIlIlllIIl) {
                        throw new RuntimeException(String.valueOf(new StringBuilder().append("Failed to invoke ").append(lllllllllllllllIIIIllIIIlIlIllIl).append(" with no args")), lllllllllllllIllIIIIlllIlIlllIIl.getTargetException());
                    }
                    catch (IllegalAccessException lllllllllllllIllIIIIlllIlIlllIII) {
                        throw new AssertionError((Object)lllllllllllllIllIIIIlllIlIlllIII);
                    }
                }
            };
        }
        catch (NoSuchMethodException lllllllllllllllIIIIllIIIlIlIllII) {
            return null;
        }
    }
    
    private <T> ObjectConstructor<T> newUnsafeAllocator(final Type lllllllllllllllIIIIllIIIlIIllIIl, final Class<? super T> lllllllllllllllIIIIllIIIlIIlIlIl) {
        return new ObjectConstructor<T>() {
            private final /* synthetic */ UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
            
            @Override
            public T construct() {
                try {
                    final Object lllllllllllllIlllIlIlllIllIlIllI = this.unsafeAllocator.newInstance(lllllllllllllllIIIIllIIIlIIlIlIl);
                    return (T)lllllllllllllIlllIlIlllIllIlIllI;
                }
                catch (Exception lllllllllllllIlllIlIlllIllIlIlIl) {
                    throw new RuntimeException(String.valueOf(new StringBuilder().append("Unable to invoke no-args constructor for ").append(lllllllllllllllIIIIllIIIlIIllIIl).append(". Registering an InstanceCreator with Gson for this type may fix this problem.")), lllllllllllllIlllIlIlllIllIlIlIl);
                }
            }
        };
    }
}
