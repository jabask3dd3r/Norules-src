package net.minecraft.util;

import java.util.*;
import com.google.common.collect.*;

public class ClassInheritanceMultiMap<T> extends AbstractSet<T>
{
    private final /* synthetic */ Set<Class<?>> knownKeys;
    private final /* synthetic */ Class<T> baseClass;
    private final /* synthetic */ Map<Class<?>, List<T>> map;
    private final /* synthetic */ List<T> values;
    private static final /* synthetic */ Set<Class<?>> ALL_KNOWN;
    
    public ClassInheritanceMultiMap(final Class<T> lllllllllllllIIIlllIlIIlIlIlIlIl) {
        this.map = (Map<Class<?>, List<T>>)Maps.newHashMap();
        this.knownKeys = (Set<Class<?>>)Sets.newIdentityHashSet();
        this.values = (List<T>)Lists.newArrayList();
        this.baseClass = lllllllllllllIIIlllIlIIlIlIlIlIl;
        this.knownKeys.add(lllllllllllllIIIlllIlIIlIlIlIlIl);
        this.map.put((Class<?>)lllllllllllllIIIlllIlIIlIlIlIlIl, (List<?>)this.values);
        for (final Class<?> lllllllllllllIIIlllIlIIlIlIlIlll : ClassInheritanceMultiMap.ALL_KNOWN) {
            this.createLookup(lllllllllllllIIIlllIlIIlIlIlIlll);
        }
    }
    
    @Override
    public boolean remove(final Object lllllllllllllIIIlllIlIIlIIlIIIlI) {
        final T lllllllllllllIIIlllIlIIlIIlIIIIl = (T)lllllllllllllIIIlllIlIIlIIlIIIlI;
        boolean lllllllllllllIIIlllIlIIlIIlIIIII = false;
        for (final Class<?> lllllllllllllIIIlllIlIIlIIIlllll : this.knownKeys) {
            if (lllllllllllllIIIlllIlIIlIIIlllll.isAssignableFrom(lllllllllllllIIIlllIlIIlIIlIIIIl.getClass())) {
                final List<T> lllllllllllllIIIlllIlIIlIIIllllI = this.map.get(lllllllllllllIIIlllIlIIlIIIlllll);
                if (lllllllllllllIIIlllIlIIlIIIllllI == null || !lllllllllllllIIIlllIlIIlIIIllllI.remove(lllllllllllllIIIlllIlIIlIIlIIIIl)) {
                    continue;
                }
                lllllllllllllIIIlllIlIIlIIlIIIII = true;
            }
        }
        return lllllllllllllIIIlllIlIIlIIlIIIII;
    }
    
    private void addForClass(final T lllllllllllllIIIlllIlIIlIIllIIIl, final Class<?> lllllllllllllIIIlllIlIIlIIllIIII) {
        final List<T> lllllllllllllIIIlllIlIIlIIlIllll = this.map.get(lllllllllllllIIIlllIlIIlIIllIIII);
        if (lllllllllllllIIIlllIlIIlIIlIllll == null) {
            this.map.put(lllllllllllllIIIlllIlIIlIIllIIII, Lists.newArrayList(new Object[] { lllllllllllllIIIlllIlIIlIIllIIIl }));
        }
        else {
            lllllllllllllIIIlllIlIIlIIlIllll.add(lllllllllllllIIIlllIlIIlIIllIIIl);
        }
    }
    
    @Override
    public boolean add(final T lllllllllllllIIIlllIlIIlIIlllIIl) {
        for (final Class<?> lllllllllllllIIIlllIlIIlIIlllIll : this.knownKeys) {
            if (lllllllllllllIIIlllIlIIlIIlllIll.isAssignableFrom(lllllllllllllIIIlllIlIIlIIlllIIl.getClass())) {
                this.addForClass(lllllllllllllIIIlllIlIIlIIlllIIl, lllllllllllllIIIlllIlIIlIIlllIll);
            }
        }
        return true;
    }
    
    @Override
    public int size() {
        return this.values.size();
    }
    
    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>)(this.values.isEmpty() ? Collections.emptyIterator() : Iterators.unmodifiableIterator((Iterator)this.values.iterator()));
    }
    
    protected Class<?> initializeClassLookup(final Class<?> lllllllllllllIIIlllIlIIlIlIIIlII) {
        if (this.baseClass.isAssignableFrom(lllllllllllllIIIlllIlIIlIlIIIlII)) {
            if (!this.knownKeys.contains(lllllllllllllIIIlllIlIIlIlIIIlII)) {
                this.createLookup(lllllllllllllIIIlllIlIIlIlIIIlII);
            }
            return lllllllllllllIIIlllIlIIlIlIIIlII;
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder("Don't know how to search for ").append(lllllllllllllIIIlllIlIIlIlIIIlII)));
    }
    
    public <S> Iterable<S> getByClass(final Class<S> lllllllllllllIIIlllIlIIlIIIIllIl) {
        return new Iterable<S>() {
            @Override
            public Iterator<S> iterator() {
                final List<T> llllllllllllllIlIIIIIlllIlIIIIIl = ClassInheritanceMultiMap.this.map.get(ClassInheritanceMultiMap.this.initializeClassLookup(lllllllllllllIIIlllIlIIlIIIIllIl));
                if (llllllllllllllIlIIIIIlllIlIIIIIl == null) {
                    return Collections.emptyIterator();
                }
                final Iterator<T> llllllllllllllIlIIIIIlllIlIIIIII = llllllllllllllIlIIIIIlllIlIIIIIl.iterator();
                return (Iterator<S>)Iterators.filter((Iterator)llllllllllllllIlIIIIIlllIlIIIIII, lllllllllllllIIIlllIlIIlIIIIllIl);
            }
        };
    }
    
    @Override
    public boolean contains(final Object lllllllllllllIIIlllIlIIlIIIlIIll) {
        return Iterators.contains((Iterator)this.getByClass(lllllllllllllIIIlllIlIIlIIIlIIll.getClass()).iterator(), lllllllllllllIIIlllIlIIlIIIlIIll);
    }
    
    static {
        ALL_KNOWN = Sets.newHashSet();
    }
    
    protected void createLookup(final Class<?> lllllllllllllIIIlllIlIIlIlIIlIlI) {
        ClassInheritanceMultiMap.ALL_KNOWN.add(lllllllllllllIIIlllIlIIlIlIIlIlI);
        for (final T lllllllllllllIIIlllIlIIlIlIIllII : this.values) {
            if (lllllllllllllIIIlllIlIIlIlIIlIlI.isAssignableFrom(lllllllllllllIIIlllIlIIlIlIIllII.getClass())) {
                this.addForClass(lllllllllllllIIIlllIlIIlIlIIllII, lllllllllllllIIIlllIlIIlIlIIlIlI);
            }
        }
        this.knownKeys.add(lllllllllllllIIIlllIlIIlIlIIlIlI);
    }
}
