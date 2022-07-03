package com.viaversion.viaversion.util;

import java.lang.reflect.*;
import java.util.concurrent.*;
import java.util.*;

public class ReflectionUtil
{
    public static <T> T get(final Object lllllllllllllIIIlIlIIIIIlIlllIlI, final Class<?> lllllllllllllIIIlIlIIIIIlIllIlII, final String lllllllllllllIIIlIlIIIIIlIllIIll, final Class<T> lllllllllllllIIIlIlIIIIIlIllIIlI) throws IllegalAccessException, NoSuchFieldException {
        final Field lllllllllllllIIIlIlIIIIIlIllIllI = lllllllllllllIIIlIlIIIIIlIllIlII.getDeclaredField(lllllllllllllIIIlIlIIIIIlIllIIll);
        lllllllllllllIIIlIlIIIIIlIllIllI.setAccessible(true);
        return lllllllllllllIIIlIlIIIIIlIllIIlI.cast(lllllllllllllIIIlIlIIIIIlIllIllI.get(lllllllllllllIIIlIlIIIIIlIlllIlI));
    }
    
    public static <T> T getSuper(final Object lllllllllllllIIIlIlIIIIIllIIIlll, final String lllllllllllllIIIlIlIIIIIllIIIllI, final Class<T> lllllllllllllIIIlIlIIIIIllIIIIIl) throws NoSuchFieldException, IllegalAccessException {
        final Field lllllllllllllIIIlIlIIIIIllIIIlII = lllllllllllllIIIlIlIIIIIllIIIlll.getClass().getSuperclass().getDeclaredField(lllllllllllllIIIlIlIIIIIllIIIllI);
        lllllllllllllIIIlIlIIIIIllIIIlII.setAccessible(true);
        return lllllllllllllIIIlIlIIIIIllIIIIIl.cast(lllllllllllllIIIlIlIIIIIllIIIlII.get(lllllllllllllIIIlIlIIIIIllIIIlll));
    }
    
    public static void set(final Object lllllllllllllIIIlIlIIIIIlIIIlIlI, final String lllllllllllllIIIlIlIIIIIlIIIIlll, final Object lllllllllllllIIIlIlIIIIIlIIIIllI) throws IllegalAccessException, NoSuchFieldException {
        final Field lllllllllllllIIIlIlIIIIIlIIIllII = lllllllllllllIIIlIlIIIIIlIIIlIlI.getClass().getDeclaredField(lllllllllllllIIIlIlIIIIIlIIIIlll);
        lllllllllllllIIIlIlIIIIIlIIIllII.setAccessible(true);
        lllllllllllllIIIlIlIIIIIlIIIllII.set(lllllllllllllIIIlIlIIIIIlIIIlIlI, lllllllllllllIIIlIlIIIIIlIIIIllI);
    }
    
    public static <T> T getStatic(final Class<?> lllllllllllllIIIlIlIIIIIllIllIll, final String lllllllllllllIIIlIlIIIIIllIllllI, final Class<T> lllllllllllllIIIlIlIIIIIllIlllIl) throws IllegalAccessException, NoSuchFieldException {
        final Field lllllllllllllIIIlIlIIIIIllIlllII = lllllllllllllIIIlIlIIIIIllIllIll.getDeclaredField(lllllllllllllIIIlIlIIIIIllIllllI);
        lllllllllllllIIIlIlIIIIIllIlllII.setAccessible(true);
        return lllllllllllllIIIlIlIIIIIllIlllIl.cast(lllllllllllllIIIlIlIIIIIllIlllII.get(null));
    }
    
    public static void setStatic(final Class<?> lllllllllllllIIIlIlIIIIIllIlIIll, final String lllllllllllllIIIlIlIIIIIllIlIIlI, final Object lllllllllllllIIIlIlIIIIIllIlIIIl) throws IllegalAccessException, NoSuchFieldException {
        final Field lllllllllllllIIIlIlIIIIIllIlIIII = lllllllllllllIIIlIlIIIIIllIlIIll.getDeclaredField(lllllllllllllIIIlIlIIIIIllIlIIlI);
        lllllllllllllIIIlIlIIIIIllIlIIII.setAccessible(true);
        lllllllllllllIIIlIlIIIIIllIlIIII.set(null, lllllllllllllIIIlIlIIIIIllIlIIIl);
    }
    
    public static <T> T get(final Object lllllllllllllIIIlIlIIIIIlIlIllII, final String lllllllllllllIIIlIlIIIIIlIlIlIll, final Class<T> lllllllllllllIIIlIlIIIIIlIlIIllI) throws NoSuchFieldException, IllegalAccessException {
        final Field lllllllllllllIIIlIlIIIIIlIlIlIIl = lllllllllllllIIIlIlIIIIIlIlIllII.getClass().getDeclaredField(lllllllllllllIIIlIlIIIIIlIlIlIll);
        lllllllllllllIIIlIlIIIIIlIlIlIIl.setAccessible(true);
        return lllllllllllllIIIlIlIIIIIlIlIIllI.cast(lllllllllllllIIIlIlIIIIIlIlIlIIl.get(lllllllllllllIIIlIlIIIIIlIlIllII));
    }
    
    public static Object invokeStatic(final Class<?> lllllllllllllIIIlIlIIIIIllllIIlI, final String lllllllllllllIIIlIlIIIIIlllIlllI) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        final Method lllllllllllllIIIlIlIIIIIllllIIII = lllllllllllllIIIlIlIIIIIllllIIlI.getDeclaredMethod(lllllllllllllIIIlIlIIIIIlllIlllI, (Class<?>[])new Class[0]);
        return lllllllllllllIIIlIlIIIIIllllIIII.invoke(null, new Object[0]);
    }
    
    public static <T> T getPublic(final Object lllllllllllllIIIlIlIIIIIlIIlllII, final String lllllllllllllIIIlIlIIIIIlIIllIll, final Class<T> lllllllllllllIIIlIlIIIIIlIIllIIl) throws IllegalAccessException, NoSuchFieldException {
        final Field lllllllllllllIIIlIlIIIIIlIIlllIl = lllllllllllllIIIlIlIIIIIlIIlllII.getClass().getField(lllllllllllllIIIlIlIIIIIlIIllIll);
        lllllllllllllIIIlIlIIIIIlIIlllIl.setAccessible(true);
        return lllllllllllllIIIlIlIIIIIlIIllIIl.cast(lllllllllllllIIIlIlIIIIIlIIlllIl.get(lllllllllllllIIIlIlIIIIIlIIlllII));
    }
    
    public static Object invoke(final Object lllllllllllllIIIlIlIIIIIlllIlIIl, final String lllllllllllllIIIlIlIIIIIlllIlIII) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final Method lllllllllllllIIIlIlIIIIIlllIIlll = lllllllllllllIIIlIlIIIIIlllIlIIl.getClass().getDeclaredMethod(lllllllllllllIIIlIlIIIIIlllIlIII, (Class<?>[])new Class[0]);
        return lllllllllllllIIIlIlIIIIIlllIIlll.invoke(lllllllllllllIIIlIlIIIIIlllIlIIl, new Object[0]);
    }
    
    public static final class ClassReflection
    {
        private final /* synthetic */ Map<String, Method> methods;
        private final /* synthetic */ Map<String, Field> fields;
        private final /* synthetic */ Class<?> handle;
        
        private void scanMethods(final Class<?> llllllllllllllIIlIllllIlIIIIIllI, final boolean llllllllllllllIIlIllllIlIIIIIlIl) {
            if (llllllllllllllIIlIllllIlIIIIIlIl && llllllllllllllIIlIllllIlIIIIIllI.getSuperclass() != null && llllllllllllllIIlIllllIlIIIIIllI.getSuperclass() != Object.class) {
                this.scanMethods(llllllllllllllIIlIllllIlIIIIIllI.getSuperclass(), true);
            }
            final char llllllllllllllIIlIllllIlIIIIIIIl = (Object)llllllllllllllIIlIllllIlIIIIIllI.getDeclaredMethods();
            final int llllllllllllllIIlIllllIlIIIIIIII = llllllllllllllIIlIllllIlIIIIIIIl.length;
            for (String llllllllllllllIIlIllllIIllllllll = (String)0; llllllllllllllIIlIllllIIllllllll < llllllllllllllIIlIllllIlIIIIIIII; ++llllllllllllllIIlIllllIIllllllll) {
                final Method llllllllllllllIIlIllllIlIIIIlIII = llllllllllllllIIlIllllIlIIIIIIIl[llllllllllllllIIlIllllIIllllllll];
                llllllllllllllIIlIllllIlIIIIlIII.setAccessible(true);
                this.methods.put(llllllllllllllIIlIllllIlIIIIlIII.getName(), llllllllllllllIIlIllllIlIIIIlIII);
            }
        }
        
        public <T> T invokeMethod(final Class<T> llllllllllllllIIlIllllIIllIlIIIl, final String llllllllllllllIIlIllllIIllIlIlIl, final Object llllllllllllllIIlIllllIIllIlIlII, final Object... llllllllllllllIIlIllllIIllIlIIll) throws IllegalAccessException, InvocationTargetException {
            return llllllllllllllIIlIllllIIllIlIIIl.cast(this.getMethod(llllllllllllllIIlIllllIIllIlIlIl).invoke(llllllllllllllIIlIllllIIllIlIlII, llllllllllllllIIlIllllIIllIlIIll));
        }
        
        public ClassReflection(final Class<?> llllllllllllllIIlIllllIlIIlIllIl) {
            this(llllllllllllllIIlIllllIlIIlIllIl, true);
        }
        
        public ClassReflection(final Class<?> llllllllllllllIIlIllllIlIIlIIllI, final boolean llllllllllllllIIlIllllIlIIlIIlIl) {
            this.fields = new ConcurrentHashMap<String, Field>();
            this.methods = new ConcurrentHashMap<String, Method>();
            this.handle = llllllllllllllIIlIllllIlIIlIIllI;
            this.scanFields(llllllllllllllIIlIllllIlIIlIIllI, llllllllllllllIIlIllllIlIIlIIlIl);
            this.scanMethods(llllllllllllllIIlIllllIlIIlIIllI, llllllllllllllIIlIllllIlIIlIIlIl);
        }
        
        public Collection<Field> getFields() {
            return Collections.unmodifiableCollection((Collection<? extends Field>)this.fields.values());
        }
        
        private void scanFields(final Class<?> llllllllllllllIIlIllllIlIIIllIII, final boolean llllllllllllllIIlIllllIlIIIlIlll) {
            if (llllllllllllllIIlIllllIlIIIlIlll && llllllllllllllIIlIllllIlIIIllIII.getSuperclass() != null && llllllllllllllIIlIllllIlIIIllIII.getSuperclass() != Object.class) {
                this.scanFields(llllllllllllllIIlIllllIlIIIllIII.getSuperclass(), true);
            }
            final boolean llllllllllllllIIlIllllIlIIIlIIll = (Object)llllllllllllllIIlIllllIlIIIllIII.getDeclaredFields();
            final char llllllllllllllIIlIllllIlIIIlIIlI = (char)llllllllllllllIIlIllllIlIIIlIIll.length;
            for (double llllllllllllllIIlIllllIlIIIlIIIl = 0; llllllllllllllIIlIllllIlIIIlIIIl < llllllllllllllIIlIllllIlIIIlIIlI; ++llllllllllllllIIlIllllIlIIIlIIIl) {
                final Field llllllllllllllIIlIllllIlIIIllIlI = llllllllllllllIIlIllllIlIIIlIIll[llllllllllllllIIlIllllIlIIIlIIIl];
                llllllllllllllIIlIllllIlIIIllIlI.setAccessible(true);
                this.fields.put(llllllllllllllIIlIllllIlIIIllIlI.getName(), llllllllllllllIIlIllllIlIIIllIlI);
            }
        }
        
        public Object newInstance() throws ReflectiveOperationException {
            return this.handle.getConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
        }
        
        public Collection<Method> getMethods() {
            return Collections.unmodifiableCollection((Collection<? extends Method>)this.methods.values());
        }
        
        public void setFieldValue(final String llllllllllllllIIlIllllIIlllIllll, final Object llllllllllllllIIlIllllIIlllIlIlI, final Object llllllllllllllIIlIllllIIlllIllIl) throws IllegalAccessException {
            this.getField(llllllllllllllIIlIllllIIlllIllll).set(llllllllllllllIIlIllllIIlllIlIlI, llllllllllllllIIlIllllIIlllIllIl);
        }
        
        public <T> T getFieldValue(final String llllllllllllllIIlIllllIIllIlllll, final Object llllllllllllllIIlIllllIIllIllllI, final Class<T> llllllllllllllIIlIllllIIlllIIIIl) throws IllegalAccessException {
            return llllllllllllllIIlIllllIIlllIIIIl.cast(this.getField(llllllllllllllIIlIllllIIllIlllll).get(llllllllllllllIIlIllllIIllIllllI));
        }
        
        public Field getField(final String llllllllllllllIIlIllllIIllllIlIl) {
            return this.fields.get(llllllllllllllIIlIllllIIllllIlIl);
        }
        
        public Method getMethod(final String llllllllllllllIIlIllllIIllIIlIII) {
            return this.methods.get(llllllllllllllIIlIllllIIllIIlIII);
        }
    }
}
