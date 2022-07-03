package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;

public interface ObjectList<K> extends List<K>, Comparable<List<? extends K>>, ObjectCollection<K>
{
    ObjectListIterator<K> iterator();
    
    void addElements(final int p0, final K[] p1, final int p2, final int p3);
    
    default void unstableSort(final Comparator<? super K> llllllllllllllllIIlllllIIlIlIIlI) {
        final K[] llllllllllllllllIIlllllIIlIlIIIl = (K[])this.toArray();
        if (llllllllllllllllIIlllllIIlIlIIlI == null) {
            ObjectArrays.unstableSort(llllllllllllllllIIlllllIIlIlIIIl);
        }
        else {
            ObjectArrays.unstableSort(llllllllllllllllIIlllllIIlIlIIIl, (Comparator<K>)llllllllllllllllIIlllllIIlIlIIlI);
        }
        this.setElements(llllllllllllllllIIlllllIIlIlIIIl);
    }
    
    ObjectListIterator<K> listIterator(final int p0);
    
    ObjectListIterator<K> listIterator();
    
    void getElements(final int p0, final Object[] p1, final int p2, final int p3);
    
    default void setElements(final K[] llllllllllllllllIIlllllIIlllIlll) {
        this.setElements(0, llllllllllllllllIIlllllIIlllIlll);
    }
    
    ObjectList<K> subList(final int p0, final int p1);
    
    void removeElements(final int p0, final int p1);
    
    void addElements(final int p0, final K[] p1);
    
    default void setElements(final int llllllllllllllllIIlllllIIlIlllII, final K[] llllllllllllllllIIlllllIIlIllIll, final int llllllllllllllllIIlllllIIlIllIlI, final int llllllllllllllllIIlllllIIllIIIII) {
        if (llllllllllllllllIIlllllIIlIlllII < 0) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llllllllllllllllIIlllllIIlIlllII).append(") is negative")));
        }
        if (llllllllllllllllIIlllllIIlIlllII > this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("Index (").append(llllllllllllllllIIlllllIIlIlllII).append(") is greater than list size (").append(this.size()).append(")")));
        }
        ObjectArrays.ensureOffsetLength(llllllllllllllllIIlllllIIlIllIll, llllllllllllllllIIlllllIIlIllIlI, llllllllllllllllIIlllllIIllIIIII);
        if (llllllllllllllllIIlllllIIlIlllII + llllllllllllllllIIlllllIIllIIIII > this.size()) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append("End index (").append(llllllllllllllllIIlllllIIlIlllII + llllllllllllllllIIlllllIIllIIIII).append(") is greater than list size (").append(this.size()).append(")")));
        }
        final ObjectListIterator<K> llllllllllllllllIIlllllIIlIlllll = this.listIterator(llllllllllllllllIIlllllIIlIlllII);
        int llllllllllllllllIIlllllIIlIllllI = 0;
        while (llllllllllllllllIIlllllIIlIllllI < llllllllllllllllIIlllllIIllIIIII) {
            llllllllllllllllIIlllllIIlIlllll.next();
            llllllllllllllllIIlllllIIlIlllll.set(llllllllllllllllIIlllllIIlIllIll[llllllllllllllllIIlllllIIlIllIlI + llllllllllllllllIIlllllIIlIllllI++]);
        }
    }
    
    default void setElements(final int llllllllllllllllIIlllllIIllIllIl, final K[] llllllllllllllllIIlllllIIllIllll) {
        this.setElements(llllllllllllllllIIlllllIIllIllIl, llllllllllllllllIIlllllIIllIllll, 0, llllllllllllllllIIlllllIIllIllll.length);
    }
    
    void size(final int p0);
}
