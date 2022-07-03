package com.viaversion.viaversion.util;

import java.util.*;

@Deprecated
public abstract class ListWrapper implements List
{
    private final /* synthetic */ List list;
    
    @Override
    public ListIterator listIterator(final int lllllllllllllIlIlIlIIllIllIlIlll) {
        final String lllllllllllllIlIlIlIIllIllIlIllI = (String)this;
        synchronized (this) {
            return this.list.listIterator(lllllllllllllIlIlIlIIllIllIlIlll);
        }
    }
    
    @Override
    public boolean contains(final Object lllllllllllllIlIlIlIIlllIlllIIII) {
        final short lllllllllllllIlIlIlIIlllIllIllll = (short)this;
        synchronized (this) {
            return this.list.contains(lllllllllllllIlIlIlIIlllIlllIIII);
        }
    }
    
    @Override
    public ListIterator listIterator() {
        final boolean lllllllllllllIlIlIlIIllIlllIIIII = (boolean)this;
        synchronized (this) {
            return this.list.listIterator();
        }
    }
    
    @Override
    public List subList(final int lllllllllllllIlIlIlIIllIllIIlllI, final int lllllllllllllIlIlIlIIllIllIIllIl) {
        final int lllllllllllllIlIlIlIIllIllIIlIIl = (int)this;
        synchronized (this) {
            return this.list.subList(lllllllllllllIlIlIlIIllIllIIlllI, lllllllllllllIlIlIlIIllIllIIllIl);
        }
    }
    
    @Override
    public boolean removeAll(final Collection lllllllllllllIlIlIlIIllIlIlllIII) {
        final double lllllllllllllIlIlIlIIllIlIllIlIl = (double)this;
        synchronized (this) {
            return this.list.removeAll(lllllllllllllIlIlIlIIllIlIlllIII);
        }
    }
    
    @Override
    public Object[] toArray(final Object[] lllllllllllllIlIlIlIIllIlIlIIIlI) {
        final double lllllllllllllIlIlIlIIllIlIlIIIIl = (double)this;
        synchronized (this) {
            return this.list.toArray(lllllllllllllIlIlIlIIllIlIlIIIlI);
        }
    }
    
    public abstract void handleAdd(final Object p0);
    
    @Override
    public boolean remove(final Object lllllllllllllIlIlIlIIlllIlIIlllI) {
        final float lllllllllllllIlIlIlIIlllIlIIllIl = (float)this;
        synchronized (this) {
            return this.list.remove(lllllllllllllIlIlIlIIlllIlIIlllI);
        }
    }
    
    @Override
    public boolean addAll(final Collection lllllllllllllIlIlIlIIlllIlIIIlII) {
        for (final Object lllllllllllllIlIlIlIIlllIlIIIllI : lllllllllllllIlIlIlIIlllIlIIIlII) {
            this.handleAdd(lllllllllllllIlIlIlIIlllIlIIIllI);
        }
        final boolean lllllllllllllIlIlIlIIlllIlIIIIIl = (boolean)this;
        synchronized (this) {
            return this.list.addAll(lllllllllllllIlIlIlIIlllIlIIIlII);
        }
    }
    
    @Override
    public void add(final int lllllllllllllIlIlIlIIlllIIIIlIlI, final Object lllllllllllllIlIlIlIIlllIIIIlIIl) {
        final String lllllllllllllIlIlIlIIlllIIIIIlIl = (String)this;
        synchronized (this) {
            this.list.add(lllllllllllllIlIlIlIIlllIIIIlIlI, lllllllllllllIlIlIlIIlllIIIIlIIl);
        }
    }
    
    @Override
    public Iterator iterator() {
        final short lllllllllllllIlIlIlIIlllIllIlIII = (short)this;
        synchronized (this) {
            return this.listIterator();
        }
    }
    
    @Override
    public Object remove(final int lllllllllllllIlIlIlIIllIlllllllI) {
        final short lllllllllllllIlIlIlIIllIlllllIll = (short)this;
        synchronized (this) {
            return this.list.remove(lllllllllllllIlIlIlIIllIlllllllI);
        }
    }
    
    @Override
    public Object set(final int lllllllllllllIlIlIlIIlllIIIlIlll, final Object lllllllllllllIlIlIlIIlllIIIlIIll) {
        final String lllllllllllllIlIlIlIIlllIIIlIIlI = (String)this;
        synchronized (this) {
            return this.list.set(lllllllllllllIlIlIlIIlllIIIlIlll, lllllllllllllIlIlIlIIlllIIIlIIll);
        }
    }
    
    @Override
    public void clear() {
        final boolean lllllllllllllIlIlIlIIlllIIlIlIIl = (boolean)this;
        synchronized (this) {
            this.list.clear();
        }
    }
    
    @Override
    public boolean isEmpty() {
        final String lllllllllllllIlIlIlIIlllIllllIIl = (String)this;
        synchronized (this) {
            return this.list.isEmpty();
        }
    }
    
    @Override
    public Object get(final int lllllllllllllIlIlIlIIlllIIlIIIlI) {
        final Exception lllllllllllllIlIlIlIIlllIIIlllll = (Exception)this;
        synchronized (this) {
            return this.list.get(lllllllllllllIlIlIlIIlllIIlIIIlI);
        }
    }
    
    @Override
    public int size() {
        final String lllllllllllllIlIlIlIIllllIIIIIII = (String)this;
        synchronized (this) {
            return this.list.size();
        }
    }
    
    @Override
    public boolean add(final Object lllllllllllllIlIlIlIIlllIlIllIII) {
        this.handleAdd(lllllllllllllIlIlIlIIlllIlIllIII);
        final boolean lllllllllllllIlIlIlIIlllIlIlIlll = (boolean)this;
        synchronized (this) {
            return this.list.add(lllllllllllllIlIlIlIIlllIlIllIII);
        }
    }
    
    public ListWrapper(final List lllllllllllllIlIlIlIIllllIIIlIll) {
        this.list = lllllllllllllIlIlIlIIllllIIIlIll;
    }
    
    @Override
    public int indexOf(final Object lllllllllllllIlIlIlIIllIllllIlII) {
        final String lllllllllllllIlIlIlIIllIllllIIIl = (String)this;
        synchronized (this) {
            return this.list.indexOf(lllllllllllllIlIlIlIIllIllllIlII);
        }
    }
    
    @Override
    public boolean addAll(final int lllllllllllllIlIlIlIIlllIIllIllI, final Collection lllllllllllllIlIlIlIIlllIIllIlIl) {
        for (final Object lllllllllllllIlIlIlIIlllIIlllIII : lllllllllllllIlIlIlIIlllIIllIlIl) {
            this.handleAdd(lllllllllllllIlIlIlIIlllIIlllIII);
        }
        final float lllllllllllllIlIlIlIIlllIIllIIIl = (float)this;
        synchronized (this) {
            return this.list.addAll(lllllllllllllIlIlIlIIlllIIllIllI, lllllllllllllIlIlIlIIlllIIllIlIl);
        }
    }
    
    public List getOriginalList() {
        return this.list;
    }
    
    @Override
    public int lastIndexOf(final Object lllllllllllllIlIlIlIIllIlllIlIII) {
        final String lllllllllllllIlIlIlIIllIlllIIlll = (String)this;
        synchronized (this) {
            return this.list.lastIndexOf(lllllllllllllIlIlIlIIllIlllIlIII);
        }
    }
    
    @Override
    public boolean retainAll(final Collection lllllllllllllIlIlIlIIllIllIIIIlI) {
        final byte lllllllllllllIlIlIlIIllIlIllllll = (byte)this;
        synchronized (this) {
            return this.list.retainAll(lllllllllllllIlIlIlIIllIllIIIIlI);
        }
    }
    
    @Override
    public Object[] toArray() {
        final double lllllllllllllIlIlIlIIlllIllIIIIl = (double)this;
        synchronized (this) {
            return this.list.toArray();
        }
    }
    
    @Override
    public boolean containsAll(final Collection lllllllllllllIlIlIlIIllIlIlIllII) {
        final long lllllllllllllIlIlIlIIllIlIlIlIll = (long)this;
        synchronized (this) {
            return this.list.containsAll(lllllllllllllIlIlIlIIllIlIlIllII);
        }
    }
}
