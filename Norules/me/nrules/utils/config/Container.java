package me.nrules.utils.config;

import java.util.stream.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.util.*;

public class Container<T>
{
    private /* synthetic */ List<T> items;
    
    public void clear() {
        this.items.clear();
    }
    
    public T get(final int lllllllllllllIlIIIIIIllllIllllll) {
        try {
            return this.items.get(lllllllllllllIlIIIIIIllllIllllll);
        }
        catch (Exception lllllllllllllIlIIIIIIlllllIIIIIl) {
            return this.items.get(0);
        }
    }
    
    public void remove(final T lllllllllllllIlIIIIIIlllllIIlIIl) {
        this.items.remove(lllllllllllllIlIIIIIIlllllIIlIIl);
    }
    
    public boolean contains(final T lllllllllllllIlIIIIIIllllIlIllII) {
        return this.items.contains(lllllllllllllIlIIIIIIllllIlIllII);
    }
    
    public Stream<T> filter(final Predicate<? super T> lllllllllllllIlIIIIIIllllIIlIlll) {
        return this.stream().filter(lllllllllllllIlIIIIIIllllIIlIlll);
    }
    
    public T find(final Predicate<? super T> lllllllllllllIlIIIIIIllllIIlIIll) {
        return this.filter(lllllllllllllIlIIIIIIllllIIlIIll).findFirst().orElse(null);
    }
    
    public void forEach(final Consumer<? super T> lllllllllllllIlIIIIIIllllIlIIllI) {
        this.items.forEach(lllllllllllllIlIIIIIIllllIlIIllI);
    }
    
    public Stream<T> stream() {
        return this.items.stream();
    }
    
    public Container() {
        this.items = new CopyOnWriteArrayList<T>();
    }
    
    public Stream<T> reverseStream() {
        final List<T> lllllllllllllIlIIIIIIllllIlIIIlI = new CopyOnWriteArrayList<T>((Collection<? extends T>)this.items);
        Collections.reverse(lllllllllllllIlIIIIIIllllIlIIIlI);
        return lllllllllllllIlIIIIIIllllIlIIIlI.stream();
    }
    
    @SafeVarargs
    public final void add(final T... lllllllllllllIlIIIIIIlllllIIllIl) {
        Arrays.stream(lllllllllllllIlIIIIIIlllllIIllIl).forEach(this::add);
    }
    
    public <T> T findByClass(final Class<? extends T> lllllllllllllIlIIIIIIllllIIIllIl) {
        return this.stream().filter(lllllllllllllIlIIIIIIllllIIIIlIl -> lllllllllllllIlIIIIIIllllIIIIlIl.getClass().equals(lllllllllllllIlIIIIIIllllIIIllIl)).findFirst().orElse(null);
    }
    
    public int size() {
        return this.items.size();
    }
    
    public boolean isEmpty() {
        return this.items.isEmpty();
    }
    
    public int indexOf(final T lllllllllllllIlIIIIIIllllIlllIlI) {
        return this.items.indexOf(lllllllllllllIlIIIIIIllllIlllIlI);
    }
    
    public void add(final T lllllllllllllIlIIIIIIlllllIlIlIl) {
        this.items.add(lllllllllllllIlIIIIIIlllllIlIlIl);
    }
}
