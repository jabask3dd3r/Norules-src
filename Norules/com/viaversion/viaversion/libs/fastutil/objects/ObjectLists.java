package com.viaversion.viaversion.libs.fastutil.objects;

import java.io.*;
import java.util.*;

public final class ObjectLists
{
    public static final /* synthetic */ EmptyList EMPTY_LIST;
    
    public static <K> ObjectList<K> unmodifiable(final ObjectList<K> lllllllllllllIIIllIlIIIIllIIIllI) {
        return (ObjectList<K>)((lllllllllllllIIIllIlIIIIllIIIllI instanceof RandomAccess) ? new ObjectLists.UnmodifiableRandomAccessList((ObjectList)lllllllllllllIIIllIlIIIIllIIIllI) : new ObjectLists.UnmodifiableList((ObjectList)lllllllllllllIIIllIlIIIIllIIIllI));
    }
    
    private ObjectLists() {
    }
    
    public static <K> ObjectList<K> synchronize(final ObjectList<K> lllllllllllllIIIllIlIIIIllIIlllI) {
        return (ObjectList<K>)((lllllllllllllIIIllIlIIIIllIIlllI instanceof RandomAccess) ? new ObjectLists.SynchronizedRandomAccessList((ObjectList)lllllllllllllIIIllIlIIIIllIIlllI) : new ObjectLists.SynchronizedList((ObjectList)lllllllllllllIIIllIlIIIIllIIlllI));
    }
    
    public static <K> ObjectList<K> singleton(final K lllllllllllllIIIllIlIIIIllIlIIIl) {
        return new Singleton<K>(lllllllllllllIIIllIlIIIIllIlIIIl);
    }
    
    static {
        EMPTY_LIST = new EmptyList();
    }
    
    public static <K> ObjectList<K> emptyList() {
        return (ObjectList<K>)ObjectLists.EMPTY_LIST;
    }
    
    public static <K> ObjectList<K> shuffle(final ObjectList<K> lllllllllllllIIIllIlIIIIllIllIlI, final Random lllllllllllllIIIllIlIIIIllIllIIl) {
        int lllllllllllllIIIllIlIIIIllIllIll = lllllllllllllIIIllIlIIIIllIllIlI.size();
        while (lllllllllllllIIIllIlIIIIllIllIll-- != 0) {
            final int lllllllllllllIIIllIlIIIIllIlllIl = lllllllllllllIIIllIlIIIIllIllIIl.nextInt(lllllllllllllIIIllIlIIIIllIllIll + 1);
            final K lllllllllllllIIIllIlIIIIllIlllII = lllllllllllllIIIllIlIIIIllIllIlI.get(lllllllllllllIIIllIlIIIIllIllIll);
            lllllllllllllIIIllIlIIIIllIllIlI.set(lllllllllllllIIIllIlIIIIllIllIll, lllllllllllllIIIllIlIIIIllIllIlI.get(lllllllllllllIIIllIlIIIIllIlllIl));
            lllllllllllllIIIllIlIIIIllIllIlI.set(lllllllllllllIIIllIlIIIIllIlllIl, lllllllllllllIIIllIlIIIIllIlllII);
        }
        return lllllllllllllIIIllIlIIIIllIllIlI;
    }
    
    public static <K> ObjectList<K> synchronize(final ObjectList<K> lllllllllllllIIIllIlIIIIllIIlIIl, final Object lllllllllllllIIIllIlIIIIllIIlIlI) {
        return (ObjectList<K>)((lllllllllllllIIIllIlIIIIllIIlIIl instanceof RandomAccess) ? new ObjectLists.SynchronizedRandomAccessList((ObjectList)lllllllllllllIIIllIlIIIIllIIlIIl, lllllllllllllIIIllIlIIIIllIIlIlI) : new ObjectLists.SynchronizedList((ObjectList)lllllllllllllIIIllIlIIIIllIIlIIl, lllllllllllllIIIllIlIIIIllIIlIlI));
    }
    
    public static class EmptyList<K> extends ObjectCollections.EmptyCollection<K> implements ObjectList<K>, RandomAccess, Serializable, Cloneable
    {
        @Override
        public void sort(final Comparator<? super K> lllllllllllllIIllIIIlllIlIlIlIII) {
        }
        
        @Override
        public void getElements(final int lllllllllllllIIllIIIlllIlIIlIIIl, final Object[] lllllllllllllIIllIIIlllIlIIIllII, final int lllllllllllllIIllIIIlllIlIIIlIll, final int lllllllllllllIIllIIIlllIlIIIlllI) {
            if (lllllllllllllIIllIIIlllIlIIlIIIl == 0 && lllllllllllllIIllIIIlllIlIIIlllI == 0 && lllllllllllllIIllIIIlllIlIIIlIll >= 0 && lllllllllllllIIllIIIlllIlIIIlIll <= lllllllllllllIIllIIIlllIlIIIllII.length) {
                return;
            }
            throw new IndexOutOfBoundsException();
        }
        
        @Override
        public void add(final int lllllllllllllIIllIIIlllIlIllIlIl, final K lllllllllllllIIllIIIlllIlIllIlII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIIllIIIlllIIllIIlll) {
            return lllllllllllllIIllIIIlllIIllIIlll instanceof List && ((List)lllllllllllllIIllIIIlllIIllIIlll).isEmpty();
        }
        
        @Override
        public ObjectListIterator<K> iterator() {
            return (ObjectListIterator<K>)ObjectIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public void removeElements(final int lllllllllllllIIllIIIlllIlIIIlIII, final int lllllllllllllIIllIIIlllIlIIIIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int hashCode() {
            return 1;
        }
        
        @Override
        public void addElements(final int lllllllllllllIIllIIIlllIlIIIIIII, final K[] lllllllllllllIIllIIIlllIIlllllll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int indexOf(final Object lllllllllllllIIllIIIlllIlIlIllll) {
            return -1;
        }
        
        @Override
        public boolean addAll(final int lllllllllllllIIllIIIlllIlIlIlIll, final Collection<? extends K> lllllllllllllIIllIIIlllIlIlIlIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void setElements(final K[] lllllllllllllIIllIIIlllIIlllllIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public K remove(final int lllllllllllllIIllIIIlllIlIllIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void addElements(final int lllllllllllllIIllIIIlllIlIIIIlIl, final K[] lllllllllllllIIllIIIlllIlIIIIlII, final int lllllllllllllIIllIIIlllIlIIIIIll, final int lllllllllllllIIllIIIlllIlIIIIIlI) {
            throw new UnsupportedOperationException();
        }
        
        public Object clone() {
            return ObjectLists.EMPTY_LIST;
        }
        
        @Override
        public void setElements(final int lllllllllllllIIllIIIlllIIllllIll, final K[] lllllllllllllIIllIIIlllIIllllIlI) {
            throw new UnsupportedOperationException();
        }
        
        protected EmptyList() {
        }
        
        private Object readResolve() {
            return ObjectLists.EMPTY_LIST;
        }
        
        @Override
        public ObjectListIterator<K> listIterator(final int lllllllllllllIIllIIIlllIlIlIIIII) {
            if (lllllllllllllIIllIIIlllIlIlIIIII == 0) {
                return (ObjectListIterator<K>)ObjectIterators.EMPTY_ITERATOR;
            }
            throw new IndexOutOfBoundsException(String.valueOf(lllllllllllllIIllIIIlllIlIlIIIII));
        }
        
        @Override
        public ObjectList<K> subList(final int lllllllllllllIIllIIIlllIlIIllIll, final int lllllllllllllIIllIIIlllIlIIllIlI) {
            if (lllllllllllllIIllIIIlllIlIIllIll == 0 && lllllllllllllIIllIIIlllIlIIllIlI == 0) {
                return this;
            }
            throw new IndexOutOfBoundsException();
        }
        
        @Override
        public K set(final int lllllllllllllIIllIIIlllIlIllIIlI, final K lllllllllllllIIllIIIlllIlIllIIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void size(final int lllllllllllllIIllIIIlllIIlllIIll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int lastIndexOf(final Object lllllllllllllIIllIIIlllIlIlIllIl) {
            return -1;
        }
        
        @Override
        public String toString() {
            return "[]";
        }
        
        @Override
        public ObjectListIterator<K> listIterator() {
            return (ObjectListIterator<K>)ObjectIterators.EMPTY_ITERATOR;
        }
        
        @Override
        public void unstableSort(final Comparator<? super K> lllllllllllllIIllIIIlllIlIlIIllI) {
        }
        
        @Override
        public void setElements(final int lllllllllllllIIllIIIlllIIllllIII, final K[] lllllllllllllIIllIIIlllIIlllIlll, final int lllllllllllllIIllIIIlllIIlllIllI, final int lllllllllllllIIllIIIlllIIlllIlIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public K get(final int lllllllllllllIIllIIIlllIlIlllIll) {
            throw new IndexOutOfBoundsException();
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIIllIIIlllIlIlllIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int compareTo(final List<? extends K> lllllllllllllIIllIIIlllIIllIllIl) {
            if (lllllllllllllIIllIIIlllIIllIllIl == this) {
                return 0;
            }
            return lllllllllllllIIllIIIlllIIllIllIl.isEmpty() ? 0 : -1;
        }
    }
    
    public static class Singleton<K> extends AbstractObjectList<K> implements RandomAccess, Serializable, Cloneable
    {
        private final /* synthetic */ K element;
        
        @Override
        public boolean remove(final Object lllllllllllllllIIIlllllIIlIlIIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void clear() {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void setElements(final int lllllllllllllllIIIlllllIIIIlIIII, final K[] lllllllllllllllIIIlllllIIIIIllll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void removeElements(final int lllllllllllllllIIIlllllIIIIlllIl, final int lllllllllllllllIIIlllllIIIIlllII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public K remove(final int lllllllllllllllIIIlllllIIlIlIIII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void setElements(final K[] lllllllllllllllIIIlllllIIIIlIIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public ObjectListIterator<K> iterator() {
            return this.listIterator();
        }
        
        @Override
        public ObjectList<K> subList(final int lllllllllllllllIIIlllllIIIllIIII, final int lllllllllllllllIIIlllllIIIlIllII) {
            this.ensureIndex(lllllllllllllllIIIlllllIIIllIIII);
            this.ensureIndex(lllllllllllllllIIIlllllIIIlIllII);
            if (lllllllllllllllIIIlllllIIIllIIII > lllllllllllllllIIIlllllIIIlIllII) {
                throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Start index (").append(lllllllllllllllIIIlllllIIIllIIII).append(") is greater than end index (").append(lllllllllllllllIIIlllllIIIlIllII).append(")")));
            }
            if (lllllllllllllllIIIlllllIIIllIIII != 0 || lllllllllllllllIIIlllllIIIlIllII != 1) {
                return (ObjectList<K>)ObjectLists.EMPTY_LIST;
            }
            return this;
        }
        
        @Override
        public boolean retainAll(final Collection<?> lllllllllllllllIIIlllllIIIlIIIll) {
            throw new UnsupportedOperationException();
        }
        
        public Object clone() {
            return this;
        }
        
        @Override
        public boolean contains(final Object lllllllllllllllIIIlllllIIlIIlIlI) {
            return Objects.equals(lllllllllllllllIIIlllllIIlIIlIlI, this.element);
        }
        
        protected Singleton(final K lllllllllllllllIIIlllllIIlIllIlI) {
            this.element = lllllllllllllllIIIlllllIIlIllIlI;
        }
        
        @Override
        public void unstableSort(final Comparator<? super K> lllllllllllllllIIIlllllIIIIlllll) {
        }
        
        @Override
        public void sort(final Comparator<? super K> lllllllllllllllIIIlllllIIIlIIIIl) {
        }
        
        @Override
        public void addElements(final int lllllllllllllllIIIlllllIIIIlIlll, final K[] lllllllllllllllIIIlllllIIIIlIllI, final int lllllllllllllllIIIlllllIIIIlIlIl, final int lllllllllllllllIIIlllllIIIIlIlII) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void setElements(final int lllllllllllllllIIIlllllIIIIIllIl, final K[] lllllllllllllllIIIlllllIIIIIllII, final int lllllllllllllllIIIlllllIIIIIlIll, final int lllllllllllllllIIIlllllIIIIIlIlI) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public ObjectListIterator<K> listIterator(final int lllllllllllllllIIIlllllIIIllIllI) {
            if (lllllllllllllllIIIlllllIIIllIllI > 1 || lllllllllllllllIIIlllllIIIllIllI < 0) {
                throw new IndexOutOfBoundsException();
            }
            final ObjectListIterator<K> lllllllllllllllIIIlllllIIIlllIII = this.listIterator();
            if (lllllllllllllllIIIlllllIIIllIllI == 1) {
                lllllllllllllllIIIlllllIIIlllIII.next();
            }
            return lllllllllllllllIIIlllllIIIlllIII;
        }
        
        @Override
        public Object[] toArray() {
            final Object[] lllllllllllllllIIIlllllIIlIIIllI = { this.element };
            return lllllllllllllllIIIlllllIIlIIIllI;
        }
        
        @Override
        public K get(final int lllllllllllllllIIIlllllIIlIlIlII) {
            if (lllllllllllllllIIIlllllIIlIlIlII == 0) {
                return this.element;
            }
            throw new IndexOutOfBoundsException();
        }
        
        @Override
        public ObjectListIterator<K> listIterator() {
            return ObjectIterators.singleton(this.element);
        }
        
        @Override
        public boolean addAll(final Collection<? extends K> lllllllllllllllIIIlllllIIIlIIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void size(final int lllllllllllllllIIIlllllIIIIIIlll) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public boolean addAll(final int lllllllllllllllIIIlllllIIIlIlIlI, final Collection<? extends K> lllllllllllllllIIIlllllIIIlIlIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public void addElements(final int lllllllllllllllIIIlllllIIIIllIlI, final K[] lllllllllllllllIIIlllllIIIIllIIl) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int size() {
            return 1;
        }
        
        @Override
        public boolean removeAll(final Collection<?> lllllllllllllllIIIlllllIIIlIIlIl) {
            throw new UnsupportedOperationException();
        }
    }
}
