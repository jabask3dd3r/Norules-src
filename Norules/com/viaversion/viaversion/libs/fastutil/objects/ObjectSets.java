package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public final class ObjectSets
{
    public static final /* synthetic */ EmptySet EMPTY_SET;
    
    private ObjectSets() {
    }
    
    static {
        EMPTY_SET = new EmptySet();
    }
    
    public static <K> ObjectSet<K> singleton(final K llllllllllllllIIllIIIIIIIIIlIlII) {
        return new Singleton<K>(llllllllllllllIIllIIIIIIIIIlIlII);
    }
    
    public static <K> ObjectSet<K> unmodifiable(final ObjectSet<K> llllllllllllllIIllIIIIIIIIIIIlll) {
        return (ObjectSet<K>)new ObjectSets.UnmodifiableSet((ObjectSet)llllllllllllllIIllIIIIIIIIIIIlll);
    }
    
    public static <K> ObjectSet<K> synchronize(final ObjectSet<K> llllllllllllllIIllIIIIIIIIIIlIll, final Object llllllllllllllIIllIIIIIIIIIIlIlI) {
        return (ObjectSet<K>)new ObjectSets.SynchronizedSet((ObjectSet)llllllllllllllIIllIIIIIIIIIIlIll, llllllllllllllIIllIIIIIIIIIIlIlI);
    }
    
    public static <K> ObjectSet<K> emptySet() {
        return (ObjectSet<K>)ObjectSets.EMPTY_SET;
    }
    
    public static <K> ObjectSet<K> synchronize(final ObjectSet<K> llllllllllllllIIllIIIIIIIIIlIIII) {
        return (ObjectSet<K>)new ObjectSets.SynchronizedSet((ObjectSet)llllllllllllllIIllIIIIIIIIIlIIII);
    }
    
    public static class EmptySet<K> extends ObjectCollections.EmptyCollection<K> implements ObjectSet<K>, Serializable, Cloneable
    {
        @Override
        public boolean equals(final Object lllllllllllllllIlIIlllIIlIllIlII) {
            return lllllllllllllllIlIIlllIIlIllIlII instanceof Set && ((Set)lllllllllllllllIlIIlllIIlIllIlII).isEmpty();
        }
        
        public Object clone() {
            return ObjectSets.EMPTY_SET;
        }
        
        @Override
        public boolean remove(final Object lllllllllllllllIlIIlllIIlIlllIII) {
            throw new UnsupportedOperationException();
        }
        
        protected EmptySet() {
        }
        
        private Object readResolve() {
            return ObjectSets.EMPTY_SET;
        }
    }
    
    public static class Singleton<K> extends AbstractObjectSet<K> implements Serializable, Cloneable
    {
        protected final /* synthetic */ K element;
        
        @Override
        public int size() {
            return 1;
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIlIlIIIlllIIlIllIII) {
            throw new UnsupportedOperationException();
        }
        
        public Object clone() {
            return this;
        }
        
        protected Singleton(final K lllllllllllllIlIlIIIlllIIllIIIlI) {
            this.element = lllllllllllllIlIlIIIlllIIllIIIlI;
        }
        
        @Override
        public ObjectListIterator<K> iterator() {
            return ObjectIterators.singleton(this.element);
        }
        
        @Override
        public boolean removeAll(final Collection<?> lllllllllllllIlIlIIIlllIIlIlIIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean retainAll(final Collection<?> lllllllllllllIlIlIIIlllIIlIIlllI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final Collection<? extends K> lllllllllllllIlIlIIIlllIIlIlIIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIlIlIIIlllIIlIlllII) {
            return Objects.equals(lllllllllllllIlIlIIIlllIIlIlllII, this.element);
        }
    }
}
