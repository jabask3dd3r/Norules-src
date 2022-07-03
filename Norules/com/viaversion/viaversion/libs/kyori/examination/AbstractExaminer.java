package com.viaversion.viaversion.libs.kyori.examination;

import java.util.function.*;
import java.util.stream.*;
import java.util.*;

public abstract class AbstractExaminer<R> implements Examiner<R>
{
    protected abstract R stream(final IntStream llllllllllllllIIlIllIlIlIlIllIll);
    
    protected abstract R stream(final LongStream llllllllllllllIIlIllIlIlIlIllIlI);
    
    protected abstract R nil();
    
    private <E> R collection(final Collection<E> llllllllllllllIIlIllIlIlIllllIll) {
        return this.collection(llllllllllllllIIlIllIlIlIllllIll, llllllllllllllIIlIllIlIlIllllIll.stream().map((Function<? super E, ? extends R>)this::examine));
    }
    
    protected abstract <T> R stream(final Stream<T> llllllllllllllIIlIllIlIlIlIlllIl);
    
    private <K, V> R map(final Map<K, V> llllllllllllllIIlIllIlIlIllIIlIl) {
        return this.map(llllllllllllllIIlIllIlIlIllIIlIl, llllllllllllllIIlIllIlIlIllIIlIl.entrySet().stream().map(llllllllllllllIIlIllIlIlIlIlIlII -> new AbstractMap.SimpleImmutableEntry(this.examine(llllllllllllllIIlIllIlIlIlIlIlII.getKey()), this.examine(llllllllllllllIIlIllIlIlIlIlIlII.getValue()))));
    }
    
    @Override
    public R examine(final Object llllllllllllllIIlIllIlIllIIIllIl) {
        if (llllllllllllllIIlIllIlIllIIIllIl == null) {
            return this.nil();
        }
        if (llllllllllllllIIlIllIlIllIIIllIl instanceof String) {
            return this.examine((String)llllllllllllllIIlIllIlIllIIIllIl);
        }
        if (llllllllllllllIIlIllIlIllIIIllIl instanceof Examinable) {
            return this.examine((Examinable)llllllllllllllIIlIllIlIllIIIllIl);
        }
        if (llllllllllllllIIlIllIlIllIIIllIl instanceof Collection) {
            return this.collection((Collection<Object>)llllllllllllllIIlIllIlIllIIIllIl);
        }
        if (llllllllllllllIIlIllIlIllIIIllIl instanceof Map) {
            return this.map((Map<Object, Object>)llllllllllllllIIlIllIlIllIIIllIl);
        }
        if (llllllllllllllIIlIllIlIllIIIllIl.getClass().isArray()) {
            final Class<?> llllllllllllllIIlIllIlIllIIIllII = llllllllllllllIIlIllIlIllIIIllIl.getClass().getComponentType();
            if (llllllllllllllIIlIllIlIllIIIllII.isPrimitive()) {
                if (llllllllllllllIIlIllIlIllIIIllII == Boolean.TYPE) {
                    return this.examine((boolean[])llllllllllllllIIlIllIlIllIIIllIl);
                }
                if (llllllllllllllIIlIllIlIllIIIllII == Byte.TYPE) {
                    return this.examine((byte[])llllllllllllllIIlIllIlIllIIIllIl);
                }
                if (llllllllllllllIIlIllIlIllIIIllII == Character.TYPE) {
                    return this.examine((char[])llllllllllllllIIlIllIlIllIIIllIl);
                }
                if (llllllllllllllIIlIllIlIllIIIllII == Double.TYPE) {
                    return this.examine((double[])llllllllllllllIIlIllIlIllIIIllIl);
                }
                if (llllllllllllllIIlIllIlIllIIIllII == Float.TYPE) {
                    return this.examine((float[])llllllllllllllIIlIllIlIllIIIllIl);
                }
                if (llllllllllllllIIlIllIlIllIIIllII == Integer.TYPE) {
                    return this.examine((int[])llllllllllllllIIlIllIlIllIIIllIl);
                }
                if (llllllllllllllIIlIllIlIllIIIllII == Long.TYPE) {
                    return this.examine((long[])llllllllllllllIIlIllIlIllIIIllIl);
                }
                if (llllllllllllllIIlIllIlIllIIIllII == Short.TYPE) {
                    return this.examine((short[])llllllllllllllIIlIllIlIllIIIllIl);
                }
            }
            return this.array((Object[])llllllllllllllIIlIllIlIllIIIllIl);
        }
        if (llllllllllllllIIlIllIlIllIIIllIl instanceof Boolean) {
            return this.examine((boolean)llllllllllllllIIlIllIlIllIIIllIl);
        }
        if (llllllllllllllIIlIllIlIllIIIllIl instanceof Character) {
            return this.examine((char)llllllllllllllIIlIllIlIllIIIllIl);
        }
        if (llllllllllllllIIlIllIlIllIIIllIl instanceof Number) {
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof Byte) {
                return this.examine((byte)llllllllllllllIIlIllIlIllIIIllIl);
            }
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof Double) {
                return this.examine((double)llllllllllllllIIlIllIlIllIIIllIl);
            }
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof Float) {
                return this.examine((float)llllllllllllllIIlIllIlIllIIIllIl);
            }
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof Integer) {
                return this.examine((int)llllllllllllllIIlIllIlIllIIIllIl);
            }
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof Long) {
                return this.examine((long)llllllllllllllIIlIllIlIllIIIllIl);
            }
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof Short) {
                return this.examine((short)llllllllllllllIIlIllIlIllIIIllIl);
            }
        }
        else if (llllllllllllllIIlIllIlIllIIIllIl instanceof BaseStream) {
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof Stream) {
                return this.stream((Stream<Object>)llllllllllllllIIlIllIlIllIIIllIl);
            }
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof DoubleStream) {
                return this.stream((DoubleStream)llllllllllllllIIlIllIlIllIIIllIl);
            }
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof IntStream) {
                return this.stream((IntStream)llllllllllllllIIlIllIlIllIIIllIl);
            }
            if (llllllllllllllIIlIllIlIllIIIllIl instanceof LongStream) {
                return this.stream((LongStream)llllllllllllllIIlIllIlIllIIIllIl);
            }
        }
        return this.scalar(llllllllllllllIIlIllIlIllIIIllIl);
    }
    
    protected abstract <K, V> R map(final Map<K, V> llllllllllllllIIlIllIlIlIlIlllll, final Stream<Map.Entry<R, R>> llllllllllllllIIlIllIlIlIllIIIII);
    
    protected abstract R scalar(final Object llllllllllllllIIlIllIlIlIlIllllI);
    
    protected abstract R stream(final DoubleStream llllllllllllllIIlIllIlIlIlIlllII);
    
    protected abstract <E> R array(final E[] llllllllllllllIIlIllIlIlIlllllll, final Stream<R> llllllllllllllIIlIllIlIlIllllllI);
    
    protected abstract R examinable(final String llllllllllllllIIlIllIlIlIllIlIII, final Stream<Map.Entry<String, R>> llllllllllllllIIlIllIlIlIllIlIIl);
    
    @Override
    public R examine(final String llllllllllllllIIlIllIlIlIlllIIIl, final Stream<? extends ExaminableProperty> llllllllllllllIIlIllIlIlIlllIIII) {
        return this.examinable(llllllllllllllIIlIllIlIlIlllIIIl, llllllllllllllIIlIllIlIlIlllIIII.map(llllllllllllllIIlIllIlIlIlIIlllI -> new AbstractMap.SimpleImmutableEntry(llllllllllllllIIlIllIlIlIlIIlllI.name(), llllllllllllllIIlIllIlIlIlIIlllI.examine((Examiner<?>)this))));
    }
    
    private <E> R array(final E[] llllllllllllllIIlIllIlIllIIIIlII) {
        return this.array(llllllllllllllIIlIllIlIllIIIIlII, Arrays.stream(llllllllllllllIIlIllIlIllIIIIlII).map((Function<? super E, ? extends R>)this::examine));
    }
    
    protected abstract <E> R collection(final Collection<E> llllllllllllllIIlIllIlIlIlllIllI, final Stream<R> llllllllllllllIIlIllIlIlIlllIlIl);
}
