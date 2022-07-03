package com.viaversion.viaversion.libs.gson.internal;

import java.io.*;
import java.util.*;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable
{
    private static final /* synthetic */ Comparator<Comparable> NATURAL_ORDER;
    final /* synthetic */ Node<K, V> header;
    /* synthetic */ Comparator<? super K> comparator;
    /* synthetic */ Node<K, V>[] table;
    /* synthetic */ int threshold;
    /* synthetic */ int size;
    /* synthetic */ int modCount;
    private /* synthetic */ KeySet keySet;
    private /* synthetic */ EntrySet entrySet;
    
    Node<K, V> findByObject(final Object llllllllllllllIllIIIIlIllIlllIII) {
        try {
            return (Node<K, V>)((llllllllllllllIllIIIIlIllIlllIII != null) ? this.find(llllllllllllllIllIIIIlIllIlllIII, false) : null);
        }
        catch (ClassCastException llllllllllllllIllIIIIlIllIlllIlI) {
            return null;
        }
    }
    
    @Override
    public boolean containsKey(final Object llllllllllllllIllIIIIllIIIIIIllI) {
        return this.findByObject(llllllllllllllIllIIIIllIIIIIIllI) != null;
    }
    
    public LinkedHashTreeMap() {
        this((Comparator)LinkedHashTreeMap.NATURAL_ORDER);
    }
    
    static <K, V> Node<K, V>[] doubleCapacity(final Node<K, V>[] llllllllllllllIllIIIIlIIllllIIlI) {
        final int llllllllllllllIllIIIIlIIllllIlll = llllllllllllllIllIIIIlIIllllIIlI.length;
        final Node<K, V>[] llllllllllllllIllIIIIlIIllllIllI = (Node<K, V>[])new Node[llllllllllllllIllIIIIlIIllllIlll * 2];
        final AvlIterator<K, V> llllllllllllllIllIIIIlIIllllIlIl = new AvlIterator<K, V>();
        final AvlBuilder<K, V> llllllllllllllIllIIIIlIIllllIlII = new AvlBuilder<K, V>();
        final AvlBuilder<K, V> llllllllllllllIllIIIIlIIllllIIll = new AvlBuilder<K, V>();
        for (int llllllllllllllIllIIIIlIIlllllIIl = 0; llllllllllllllIllIIIIlIIlllllIIl < llllllllllllllIllIIIIlIIllllIlll; ++llllllllllllllIllIIIIlIIlllllIIl) {
            final Node<K, V> llllllllllllllIllIIIIlIIllllllII = llllllllllllllIllIIIIlIIllllIIlI[llllllllllllllIllIIIIlIIlllllIIl];
            if (llllllllllllllIllIIIIlIIllllllII != null) {
                llllllllllllllIllIIIIlIIllllIlIl.reset(llllllllllllllIllIIIIlIIllllllII);
                int llllllllllllllIllIIIIlIIlllllIll = 0;
                int llllllllllllllIllIIIIlIIlllllIlI = 0;
                Node<K, V> llllllllllllllIllIIIIlIIlllllllI;
                while ((llllllllllllllIllIIIIlIIlllllllI = llllllllllllllIllIIIIlIIllllIlIl.next()) != null) {
                    if ((llllllllllllllIllIIIIlIIlllllllI.hash & llllllllllllllIllIIIIlIIllllIlll) == 0x0) {
                        ++llllllllllllllIllIIIIlIIlllllIll;
                    }
                    else {
                        ++llllllllllllllIllIIIIlIIlllllIlI;
                    }
                }
                llllllllllllllIllIIIIlIIllllIlII.reset(llllllllllllllIllIIIIlIIlllllIll);
                llllllllllllllIllIIIIlIIllllIIll.reset(llllllllllllllIllIIIIlIIlllllIlI);
                llllllllllllllIllIIIIlIIllllIlIl.reset(llllllllllllllIllIIIIlIIllllllII);
                Node<K, V> llllllllllllllIllIIIIlIIllllllIl;
                while ((llllllllllllllIllIIIIlIIllllllIl = llllllllllllllIllIIIIlIIllllIlIl.next()) != null) {
                    if ((llllllllllllllIllIIIIlIIllllllIl.hash & llllllllllllllIllIIIIlIIllllIlll) == 0x0) {
                        llllllllllllllIllIIIIlIIllllIlII.add(llllllllllllllIllIIIIlIIllllllIl);
                    }
                    else {
                        llllllllllllllIllIIIIlIIllllIIll.add(llllllllllllllIllIIIIlIIllllllIl);
                    }
                }
                llllllllllllllIllIIIIlIIllllIllI[llllllllllllllIllIIIIlIIlllllIIl] = ((llllllllllllllIllIIIIlIIlllllIll > 0) ? llllllllllllllIllIIIIlIIllllIlII.root() : null);
                llllllllllllllIllIIIIlIIllllIllI[llllllllllllllIllIIIIlIIlllllIIl + llllllllllllllIllIIIIlIIllllIlll] = ((llllllllllllllIllIIIIlIIlllllIlI > 0) ? llllllllllllllIllIIIIlIIllllIIll.root() : null);
            }
        }
        return llllllllllllllIllIIIIlIIllllIllI;
    }
    
    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        this.threshold = this.table.length / 2 + this.table.length / 4;
    }
    
    @Override
    public V get(final Object llllllllllllllIllIIIIllIIIIlIIII) {
        final Node<K, V> llllllllllllllIllIIIIllIIIIIllll = this.findByObject(llllllllllllllIllIIIIllIIIIlIIII);
        return (llllllllllllllIllIIIIllIIIIIllll != null) ? llllllllllllllIllIIIIllIIIIIllll.value : null;
    }
    
    @Override
    public void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        ++this.modCount;
        final Node<K, V> llllllllllllllIllIIIIlIllllIllll = this.header;
        Node<K, V> llllllllllllllIllIIIIlIlllllIIlI;
        for (Node<K, V> llllllllllllllIllIIIIlIlllllIIIl = llllllllllllllIllIIIIlIllllIllll.next; llllllllllllllIllIIIIlIlllllIIIl != llllllllllllllIllIIIIlIllllIllll; llllllllllllllIllIIIIlIlllllIIIl = llllllllllllllIllIIIIlIlllllIIlI) {
            llllllllllllllIllIIIIlIlllllIIlI = llllllllllllllIllIIIIlIlllllIIIl.next;
            final Node<K, V> node = llllllllllllllIllIIIIlIlllllIIIl;
            final Node<K, V> node2 = llllllllllllllIllIIIIlIlllllIIIl;
            final Node<K, V> node3 = null;
            node2.prev = (Node<K, V>)node3;
            node.next = (Node<K, V>)node3;
        }
        final Node<K, V> node4 = llllllllllllllIllIIIIlIllllIllll;
        final Node<K, V> node5 = llllllllllllllIllIIIIlIllllIllll;
        final Node<K, V> node6 = llllllllllllllIllIIIIlIllllIllll;
        node5.prev = node6;
        node4.next = node6;
    }
    
    @Override
    public V put(final K llllllllllllllIllIIIIlIllllllIlI, final V llllllllllllllIllIIIIlIllllllllI) {
        if (llllllllllllllIllIIIIlIllllllIlI == null) {
            throw new NullPointerException("key == null");
        }
        final Node<K, V> llllllllllllllIllIIIIlIlllllllIl = this.find(llllllllllllllIllIIIIlIllllllIlI, true);
        final V llllllllllllllIllIIIIlIlllllllII = llllllllllllllIllIIIIlIlllllllIl.value;
        llllllllllllllIllIIIIlIlllllllIl.value = llllllllllllllIllIIIIlIllllllllI;
        return llllllllllllllIllIIIIlIlllllllII;
    }
    
    private void rotateRight(final Node<K, V> llllllllllllllIllIIIIlIlIIlIIIll) {
        final Node<K, V> llllllllllllllIllIIIIlIlIIlIIIlI = llllllllllllllIllIIIIlIlIIlIIIll.left;
        final Node<K, V> llllllllllllllIllIIIIlIlIIlIIIIl = llllllllllllllIllIIIIlIlIIlIIIll.right;
        final Node<K, V> llllllllllllllIllIIIIlIlIIlIIIII = llllllllllllllIllIIIIlIlIIlIIIlI.left;
        final Node<K, V> llllllllllllllIllIIIIlIlIIIlllll = llllllllllllllIllIIIIlIlIIlIIIlI.right;
        llllllllllllllIllIIIIlIlIIlIIIll.left = llllllllllllllIllIIIIlIlIIIlllll;
        if (llllllllllllllIllIIIIlIlIIIlllll != null) {
            llllllllllllllIllIIIIlIlIIIlllll.parent = llllllllllllllIllIIIIlIlIIlIIIll;
        }
        this.replaceInParent(llllllllllllllIllIIIIlIlIIlIIIll, llllllllllllllIllIIIIlIlIIlIIIlI);
        llllllllllllllIllIIIIlIlIIlIIIlI.right = llllllllllllllIllIIIIlIlIIlIIIll;
        llllllllllllllIllIIIIlIlIIlIIIll.parent = llllllllllllllIllIIIIlIlIIlIIIlI;
        llllllllllllllIllIIIIlIlIIlIIIll.height = Math.max((llllllllllllllIllIIIIlIlIIlIIIIl != null) ? llllllllllllllIllIIIIlIlIIlIIIIl.height : 0, (llllllllllllllIllIIIIlIlIIIlllll != null) ? llllllllllllllIllIIIIlIlIIIlllll.height : 0) + 1;
        llllllllllllllIllIIIIlIlIIlIIIlI.height = Math.max(llllllllllllllIllIIIIlIlIIlIIIll.height, (llllllllllllllIllIIIIlIlIIlIIIII != null) ? llllllllllllllIllIIIIlIlIIlIIIII.height : 0) + 1;
    }
    
    Node<K, V> removeInternalByKey(final Object llllllllllllllIllIIIIlIlIlllllII) {
        final Node<K, V> llllllllllllllIllIIIIlIlIllllllI = this.findByObject(llllllllllllllIllIIIIlIlIlllllII);
        if (llllllllllllllIllIIIIlIlIllllllI != null) {
            this.removeInternal(llllllllllllllIllIIIIlIlIllllllI, true);
        }
        return llllllllllllllIllIIIIlIlIllllllI;
    }
    
    private void replaceInParent(final Node<K, V> llllllllllllllIllIIIIlIlIllIllll, final Node<K, V> llllllllllllllIllIIIIlIlIlllIIlI) {
        final Node<K, V> llllllllllllllIllIIIIlIlIlllIIIl = llllllllllllllIllIIIIlIlIllIllll.parent;
        llllllllllllllIllIIIIlIlIllIllll.parent = null;
        if (llllllllllllllIllIIIIlIlIlllIIlI != null) {
            llllllllllllllIllIIIIlIlIlllIIlI.parent = llllllllllllllIllIIIIlIlIlllIIIl;
        }
        if (llllllllllllllIllIIIIlIlIlllIIIl != null) {
            if (llllllllllllllIllIIIIlIlIlllIIIl.left == llllllllllllllIllIIIIlIlIllIllll) {
                llllllllllllllIllIIIIlIlIlllIIIl.left = llllllllllllllIllIIIIlIlIlllIIlI;
            }
            else {
                assert llllllllllllllIllIIIIlIlIlllIIIl.right == llllllllllllllIllIIIIlIlIllIllll;
                llllllllllllllIllIIIIlIlIlllIIIl.right = llllllllllllllIllIIIIlIlIlllIIlI;
            }
        }
        else {
            final int llllllllllllllIllIIIIlIlIlllIlIl = llllllllllllllIllIIIIlIlIllIllll.hash & this.table.length - 1;
            this.table[llllllllllllllIllIIIIlIlIlllIlIl] = llllllllllllllIllIIIIlIlIlllIIlI;
        }
    }
    
    static {
        NATURAL_ORDER = new Comparator<Comparable>() {
            @Override
            public int compare(final Comparable lllllllllllllIlIIlllllIllIlIIlIl, final Comparable lllllllllllllIlIIlllllIllIlIIIlI) {
                return lllllllllllllIlIIlllllIllIlIIlIl.compareTo(lllllllllllllIlIIlllllIllIlIIIlI);
            }
        };
    }
    
    public LinkedHashTreeMap(final Comparator<? super K> llllllllllllllIllIIIIllIIIIllIII) {
        this.size = 0;
        this.modCount = 0;
        this.comparator = (Comparator<? super K>)((llllllllllllllIllIIIIllIIIIllIII != null) ? llllllllllllllIllIIIIllIIIIllIII : LinkedHashTreeMap.NATURAL_ORDER);
        this.header = new Node<K, V>();
        this.table = (Node<K, V>[])new Node[16];
        this.threshold = this.table.length / 2 + this.table.length / 4;
    }
    
    private void rotateLeft(final Node<K, V> llllllllllllllIllIIIIlIlIIlIllll) {
        final Node<K, V> llllllllllllllIllIIIIlIlIIllIlII = llllllllllllllIllIIIIlIlIIlIllll.left;
        final Node<K, V> llllllllllllllIllIIIIlIlIIllIIll = llllllllllllllIllIIIIlIlIIlIllll.right;
        final Node<K, V> llllllllllllllIllIIIIlIlIIllIIlI = llllllllllllllIllIIIIlIlIIllIIll.left;
        final Node<K, V> llllllllllllllIllIIIIlIlIIllIIIl = llllllllllllllIllIIIIlIlIIllIIll.right;
        llllllllllllllIllIIIIlIlIIlIllll.right = llllllllllllllIllIIIIlIlIIllIIlI;
        if (llllllllllllllIllIIIIlIlIIllIIlI != null) {
            llllllllllllllIllIIIIlIlIIllIIlI.parent = llllllllllllllIllIIIIlIlIIlIllll;
        }
        this.replaceInParent(llllllllllllllIllIIIIlIlIIlIllll, llllllllllllllIllIIIIlIlIIllIIll);
        llllllllllllllIllIIIIlIlIIllIIll.left = llllllllllllllIllIIIIlIlIIlIllll;
        llllllllllllllIllIIIIlIlIIlIllll.parent = llllllllllllllIllIIIIlIlIIllIIll;
        llllllllllllllIllIIIIlIlIIlIllll.height = Math.max((llllllllllllllIllIIIIlIlIIllIlII != null) ? llllllllllllllIllIIIIlIlIIllIlII.height : 0, (llllllllllllllIllIIIIlIlIIllIIlI != null) ? llllllllllllllIllIIIIlIlIIllIIlI.height : 0) + 1;
        llllllllllllllIllIIIIlIlIIllIIll.height = Math.max(llllllllllllllIllIIIIlIlIIlIllll.height, (llllllllllllllIllIIIIlIlIIllIIIl != null) ? llllllllllllllIllIIIIlIlIIllIIIl.height : 0) + 1;
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    private boolean equal(final Object llllllllllllllIllIIIIlIllIlIIlIl, final Object llllllllllllllIllIIIIlIllIlIIlII) {
        return llllllllllllllIllIIIIlIllIlIIlIl == llllllllllllllIllIIIIlIllIlIIlII || (llllllllllllllIllIIIIlIllIlIIlIl != null && llllllllllllllIllIIIIlIllIlIIlIl.equals(llllllllllllllIllIIIIlIllIlIIlII));
    }
    
    @Override
    public Set<K> keySet() {
        final KeySet llllllllllllllIllIIIIlIlIIIIllll = this.keySet;
        return (llllllllllllllIllIIIIlIlIIIIllll != null) ? llllllllllllllIllIIIIlIlIIIIllll : (this.keySet = new KeySet());
    }
    
    @Override
    public V remove(final Object llllllllllllllIllIIIIlIllllIIIll) {
        final Node<K, V> llllllllllllllIllIIIIlIllllIIlIl = this.removeInternalByKey(llllllllllllllIllIIIIlIllllIIIll);
        return (llllllllllllllIllIIIIlIllllIIlIl != null) ? llllllllllllllIllIIIIlIllllIIlIl.value : null;
    }
    
    void removeInternal(final Node<K, V> llllllllllllllIllIIIIlIllIIlIIIl, final boolean llllllllllllllIllIIIIlIllIIlIIII) {
        if (llllllllllllllIllIIIIlIllIIlIIII) {
            llllllllllllllIllIIIIlIllIIlIIIl.prev.next = llllllllllllllIllIIIIlIllIIlIIIl.next;
            llllllllllllllIllIIIIlIllIIlIIIl.next.prev = llllllllllllllIllIIIIlIllIIlIIIl.prev;
            final Node<K, V> node = null;
            llllllllllllllIllIIIIlIllIIlIIIl.prev = (Node<K, V>)node;
            llllllllllllllIllIIIIlIllIIlIIIl.next = (Node<K, V>)node;
        }
        Node<K, V> llllllllllllllIllIIIIlIllIIIllll = llllllllllllllIllIIIIlIllIIlIIIl.left;
        Node<K, V> llllllllllllllIllIIIIlIllIIIlllI = llllllllllllllIllIIIIlIllIIlIIIl.right;
        final Node<K, V> llllllllllllllIllIIIIlIllIIIllIl = llllllllllllllIllIIIIlIllIIlIIIl.parent;
        if (llllllllllllllIllIIIIlIllIIIllll != null && llllllllllllllIllIIIIlIllIIIlllI != null) {
            final Node<K, V> llllllllllllllIllIIIIlIllIIlIlIl = (llllllllllllllIllIIIIlIllIIIllll.height > llllllllllllllIllIIIIlIllIIIlllI.height) ? llllllllllllllIllIIIIlIllIIIllll.last() : llllllllllllllIllIIIIlIllIIIlllI.first();
            this.removeInternal(llllllllllllllIllIIIIlIllIIlIlIl, false);
            int llllllllllllllIllIIIIlIllIIlIlII = 0;
            llllllllllllllIllIIIIlIllIIIllll = llllllllllllllIllIIIIlIllIIlIIIl.left;
            if (llllllllllllllIllIIIIlIllIIIllll != null) {
                llllllllllllllIllIIIIlIllIIlIlII = llllllllllllllIllIIIIlIllIIIllll.height;
                llllllllllllllIllIIIIlIllIIlIlIl.left = llllllllllllllIllIIIIlIllIIIllll;
                llllllllllllllIllIIIIlIllIIIllll.parent = llllllllllllllIllIIIIlIllIIlIlIl;
                llllllllllllllIllIIIIlIllIIlIIIl.left = null;
            }
            int llllllllllllllIllIIIIlIllIIlIIll = 0;
            llllllllllllllIllIIIIlIllIIIlllI = llllllllllllllIllIIIIlIllIIlIIIl.right;
            if (llllllllllllllIllIIIIlIllIIIlllI != null) {
                llllllllllllllIllIIIIlIllIIlIIll = llllllllllllllIllIIIIlIllIIIlllI.height;
                llllllllllllllIllIIIIlIllIIlIlIl.right = llllllllllllllIllIIIIlIllIIIlllI;
                llllllllllllllIllIIIIlIllIIIlllI.parent = llllllllllllllIllIIIIlIllIIlIlIl;
                llllllllllllllIllIIIIlIllIIlIIIl.right = null;
            }
            llllllllllllllIllIIIIlIllIIlIlIl.height = Math.max(llllllllllllllIllIIIIlIllIIlIlII, llllllllllllllIllIIIIlIllIIlIIll) + 1;
            this.replaceInParent(llllllllllllllIllIIIIlIllIIlIIIl, llllllllllllllIllIIIIlIllIIlIlIl);
            return;
        }
        if (llllllllllllllIllIIIIlIllIIIllll != null) {
            this.replaceInParent(llllllllllllllIllIIIIlIllIIlIIIl, llllllllllllllIllIIIIlIllIIIllll);
            llllllllllllllIllIIIIlIllIIlIIIl.left = null;
        }
        else if (llllllllllllllIllIIIIlIllIIIlllI != null) {
            this.replaceInParent(llllllllllllllIllIIIIlIllIIlIIIl, llllllllllllllIllIIIIlIllIIIlllI);
            llllllllllllllIllIIIIlIllIIlIIIl.right = null;
        }
        else {
            this.replaceInParent(llllllllllllllIllIIIIlIllIIlIIIl, null);
        }
        this.rebalance(llllllllllllllIllIIIIlIllIIIllIl, false);
        --this.size;
        ++this.modCount;
    }
    
    private static int secondaryHash(int llllllllllllllIllIIIIlIllIIlllll) {
        llllllllllllllIllIIIIlIllIIlllll ^= (llllllllllllllIllIIIIlIllIIlllll >>> 20 ^ llllllllllllllIllIIIIlIllIIlllll >>> 12);
        return llllllllllllllIllIIIIlIllIIlllll ^ llllllllllllllIllIIIIlIllIIlllll >>> 7 ^ llllllllllllllIllIIIIlIllIIlllll >>> 4;
    }
    
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        final EntrySet llllllllllllllIllIIIIlIlIIIlIlIl = this.entrySet;
        return (llllllllllllllIllIIIIlIlIIIlIlIl != null) ? llllllllllllllIllIIIIlIlIIIlIlIl : (this.entrySet = new EntrySet());
    }
    
    Node<K, V> find(final K llllllllllllllIllIIIIlIlllIIIlll, final boolean llllllllllllllIllIIIIlIlllIIIllI) {
        final Comparator<? super K> llllllllllllllIllIIIIlIlllIlIIII = this.comparator;
        final Node<K, V>[] llllllllllllllIllIIIIlIlllIIllll = this.table;
        final int llllllllllllllIllIIIIlIlllIIlllI = secondaryHash(llllllllllllllIllIIIIlIlllIIIlll.hashCode());
        final int llllllllllllllIllIIIIlIlllIIllIl = llllllllllllllIllIIIIlIlllIIlllI & llllllllllllllIllIIIIlIlllIIllll.length - 1;
        Node<K, V> llllllllllllllIllIIIIlIlllIIllII = llllllllllllllIllIIIIlIlllIIllll[llllllllllllllIllIIIIlIlllIIllIl];
        int llllllllllllllIllIIIIlIlllIIlIll = 0;
        if (llllllllllllllIllIIIIlIlllIIllII != null) {
            final Comparable<Object> llllllllllllllIllIIIIlIlllIlIlIl = (Comparable<Object>)((llllllllllllllIllIIIIlIlllIlIIII == LinkedHashTreeMap.NATURAL_ORDER) ? ((Comparable)llllllllllllllIllIIIIlIlllIIIlll) : null);
            while (true) {
                llllllllllllllIllIIIIlIlllIIlIll = ((llllllllllllllIllIIIIlIlllIlIlIl != null) ? llllllllllllllIllIIIIlIlllIlIlIl.compareTo(llllllllllllllIllIIIIlIlllIIllII.key) : llllllllllllllIllIIIIlIlllIlIIII.compare((Object)llllllllllllllIllIIIIlIlllIIIlll, (Object)llllllllllllllIllIIIIlIlllIIllII.key));
                if (llllllllllllllIllIIIIlIlllIIlIll == 0) {
                    return llllllllllllllIllIIIIlIlllIIllII;
                }
                final Node<K, V> llllllllllllllIllIIIIlIlllIlIllI = (llllllllllllllIllIIIIlIlllIIlIll < 0) ? llllllllllllllIllIIIIlIlllIIllII.left : llllllllllllllIllIIIIlIlllIIllII.right;
                if (llllllllllllllIllIIIIlIlllIlIllI == null) {
                    break;
                }
                llllllllllllllIllIIIIlIlllIIllII = llllllllllllllIllIIIIlIlllIlIllI;
            }
        }
        if (!llllllllllllllIllIIIIlIlllIIIllI) {
            return null;
        }
        final Node<K, V> llllllllllllllIllIIIIlIlllIIlIlI = this.header;
        Node<K, V> llllllllllllllIllIIIIlIlllIIlIIl = null;
        if (llllllllllllllIllIIIIlIlllIIllII == null) {
            if (llllllllllllllIllIIIIlIlllIlIIII == LinkedHashTreeMap.NATURAL_ORDER && !(llllllllllllllIllIIIIlIlllIIIlll instanceof Comparable)) {
                throw new ClassCastException(String.valueOf(new StringBuilder().append(llllllllllllllIllIIIIlIlllIIIlll.getClass().getName()).append(" is not Comparable")));
            }
            final Node<K, V> llllllllllllllIllIIIIlIlllIlIlII = new Node<K, V>(llllllllllllllIllIIIIlIlllIIllII, llllllllllllllIllIIIIlIlllIIIlll, llllllllllllllIllIIIIlIlllIIlllI, llllllllllllllIllIIIIlIlllIIlIlI, llllllllllllllIllIIIIlIlllIIlIlI.prev);
            llllllllllllllIllIIIIlIlllIIllll[llllllllllllllIllIIIIlIlllIIllIl] = llllllllllllllIllIIIIlIlllIlIlII;
        }
        else {
            llllllllllllllIllIIIIlIlllIIlIIl = new Node<K, V>(llllllllllllllIllIIIIlIlllIIllII, llllllllllllllIllIIIIlIlllIIIlll, llllllllllllllIllIIIIlIlllIIlllI, llllllllllllllIllIIIIlIlllIIlIlI, llllllllllllllIllIIIIlIlllIIlIlI.prev);
            if (llllllllllllllIllIIIIlIlllIIlIll < 0) {
                llllllllllllllIllIIIIlIlllIIllII.left = llllllllllllllIllIIIIlIlllIIlIIl;
            }
            else {
                llllllllllllllIllIIIIlIlllIIllII.right = llllllllllllllIllIIIIlIlllIIlIIl;
            }
            this.rebalance(llllllllllllllIllIIIIlIlllIIllII, true);
        }
        if (this.size++ > this.threshold) {
            this.doubleCapacity();
        }
        ++this.modCount;
        return llllllllllllllIllIIIIlIlllIIlIIl;
    }
    
    private void rebalance(final Node<K, V> llllllllllllllIllIIIIlIlIlIIlIIl, final boolean llllllllllllllIllIIIIlIlIlIIlIII) {
        for (Node<K, V> llllllllllllllIllIIIIlIlIlIIlllI = llllllllllllllIllIIIIlIlIlIIlIIl; llllllllllllllIllIIIIlIlIlIIlllI != null; llllllllllllllIllIIIIlIlIlIIlllI = llllllllllllllIllIIIIlIlIlIIlllI.parent) {
            final Node<K, V> llllllllllllllIllIIIIlIlIlIlIIll = llllllllllllllIllIIIIlIlIlIIlllI.left;
            final Node<K, V> llllllllllllllIllIIIIlIlIlIlIIlI = llllllllllllllIllIIIIlIlIlIIlllI.right;
            final int llllllllllllllIllIIIIlIlIlIlIIIl = (llllllllllllllIllIIIIlIlIlIlIIll != null) ? llllllllllllllIllIIIIlIlIlIlIIll.height : 0;
            final int llllllllllllllIllIIIIlIlIlIlIIII = (llllllllllllllIllIIIIlIlIlIlIIlI != null) ? llllllllllllllIllIIIIlIlIlIlIIlI.height : 0;
            final int llllllllllllllIllIIIIlIlIlIIllll = llllllllllllllIllIIIIlIlIlIlIIIl - llllllllllllllIllIIIIlIlIlIlIIII;
            if (llllllllllllllIllIIIIlIlIlIIllll == -2) {
                final Node<K, V> llllllllllllllIllIIIIlIlIlIlllIl = llllllllllllllIllIIIIlIlIlIlIIlI.left;
                final Node<K, V> llllllllllllllIllIIIIlIlIlIlllII = llllllllllllllIllIIIIlIlIlIlIIlI.right;
                final int llllllllllllllIllIIIIlIlIlIllIll = (llllllllllllllIllIIIIlIlIlIlllII != null) ? llllllllllllllIllIIIIlIlIlIlllII.height : 0;
                final int llllllllllllllIllIIIIlIlIlIllIlI = (llllllllllllllIllIIIIlIlIlIlllIl != null) ? llllllllllllllIllIIIIlIlIlIlllIl.height : 0;
                final int llllllllllllllIllIIIIlIlIlIllIIl = llllllllllllllIllIIIIlIlIlIllIlI - llllllllllllllIllIIIIlIlIlIllIll;
                if (llllllllllllllIllIIIIlIlIlIllIIl == -1 || (llllllllllllllIllIIIIlIlIlIllIIl == 0 && !llllllllllllllIllIIIIlIlIlIIlIII)) {
                    this.rotateLeft(llllllllllllllIllIIIIlIlIlIIlllI);
                }
                else {
                    assert llllllllllllllIllIIIIlIlIlIllIIl == 1;
                    this.rotateRight(llllllllllllllIllIIIIlIlIlIlIIlI);
                    this.rotateLeft(llllllllllllllIllIIIIlIlIlIIlllI);
                }
                if (llllllllllllllIllIIIIlIlIlIIlIII) {
                    break;
                }
            }
            else if (llllllllllllllIllIIIIlIlIlIIllll == 2) {
                final Node<K, V> llllllllllllllIllIIIIlIlIlIllIII = llllllllllllllIllIIIIlIlIlIlIIll.left;
                final Node<K, V> llllllllllllllIllIIIIlIlIlIlIlll = llllllllllllllIllIIIIlIlIlIlIIll.right;
                final int llllllllllllllIllIIIIlIlIlIlIllI = (llllllllllllllIllIIIIlIlIlIlIlll != null) ? llllllllllllllIllIIIIlIlIlIlIlll.height : 0;
                final int llllllllllllllIllIIIIlIlIlIlIlIl = (llllllllllllllIllIIIIlIlIlIllIII != null) ? llllllllllllllIllIIIIlIlIlIllIII.height : 0;
                final int llllllllllllllIllIIIIlIlIlIlIlII = llllllllllllllIllIIIIlIlIlIlIlIl - llllllllllllllIllIIIIlIlIlIlIllI;
                if (llllllllllllllIllIIIIlIlIlIlIlII == 1 || (llllllllllllllIllIIIIlIlIlIlIlII == 0 && !llllllllllllllIllIIIIlIlIlIIlIII)) {
                    this.rotateRight(llllllllllllllIllIIIIlIlIlIIlllI);
                }
                else {
                    assert llllllllllllllIllIIIIlIlIlIlIlII == -1;
                    this.rotateLeft(llllllllllllllIllIIIIlIlIlIlIIll);
                    this.rotateRight(llllllllllllllIllIIIIlIlIlIIlllI);
                }
                if (llllllllllllllIllIIIIlIlIlIIlIII) {
                    break;
                }
            }
            else if (llllllllllllllIllIIIIlIlIlIIllll == 0) {
                llllllllllllllIllIIIIlIlIlIIlllI.height = llllllllllllllIllIIIIlIlIlIlIIIl + 1;
                if (llllllllllllllIllIIIIlIlIlIIlIII) {
                    break;
                }
            }
            else {
                assert llllllllllllllIllIIIIlIlIlIIllll == 1;
                llllllllllllllIllIIIIlIlIlIIlllI.height = Math.max(llllllllllllllIllIIIIlIlIlIlIIIl, llllllllllllllIllIIIIlIlIlIlIIII) + 1;
                if (!llllllllllllllIllIIIIlIlIlIIlIII) {
                    break;
                }
            }
        }
    }
    
    Node<K, V> findByEntry(final Map.Entry<?, ?> llllllllllllllIllIIIIlIllIlIlIll) {
        final Node<K, V> llllllllllllllIllIIIIlIllIlIlllI = this.findByObject(llllllllllllllIllIIIIlIllIlIlIll.getKey());
        final boolean llllllllllllllIllIIIIlIllIlIllIl = llllllllllllllIllIIIIlIllIlIlllI != null && this.equal(llllllllllllllIllIIIIlIllIlIlllI.value, llllllllllllllIllIIIIlIllIlIlIll.getValue());
        return llllllllllllllIllIIIIlIllIlIllIl ? llllllllllllllIllIIIIlIllIlIlllI : null;
    }
    
    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
    
    private abstract class LinkedTreeMapIterator<T> implements Iterator<T>
    {
        /* synthetic */ int expectedModCount;
        /* synthetic */ Node<K, V> lastReturned;
        /* synthetic */ Node<K, V> next;
        
        @Override
        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }
        
        @Override
        public final boolean hasNext() {
            return this.next != LinkedHashTreeMap.this.header;
        }
        
        final Node<K, V> nextNode() {
            final Node<K, V> lllllllllllllllllIIllIIIlIIIIIIl = this.next;
            if (lllllllllllllllllIIllIIIlIIIIIIl == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedHashTreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.next = lllllllllllllllllIIllIIIlIIIIIIl.next;
            final Node<K, V> lastReturned = lllllllllllllllllIIllIIIlIIIIIIl;
            this.lastReturned = lastReturned;
            return lastReturned;
        }
        
        LinkedTreeMapIterator() {
            this.next = LinkedHashTreeMap.this.header.next;
            this.lastReturned = null;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }
    }
    
    static final class Node<K, V> implements Map.Entry<K, V>
    {
        /* synthetic */ Node<K, V> prev;
        final /* synthetic */ int hash;
        final /* synthetic */ K key;
        /* synthetic */ Node<K, V> next;
        /* synthetic */ Node<K, V> parent;
        /* synthetic */ int height;
        /* synthetic */ Node<K, V> left;
        /* synthetic */ Node<K, V> right;
        /* synthetic */ V value;
        
        public Node<K, V> first() {
            Node<K, V> lllllllllllllIlIlIIllIllIIllIIll = this;
            for (Node<K, V> lllllllllllllIlIlIIllIllIIllIIlI = lllllllllllllIlIlIIllIllIIllIIll.left; lllllllllllllIlIlIIllIllIIllIIlI != null; lllllllllllllIlIlIIllIllIIllIIlI = lllllllllllllIlIlIIllIllIIllIIll.left) {
                lllllllllllllIlIlIIllIllIIllIIll = lllllllllllllIlIlIIllIllIIllIIlI;
            }
            return lllllllllllllIlIlIIllIllIIllIIll;
        }
        
        Node(final Node<K, V> lllllllllllllIlIlIIllIllIlIllIlI, final K lllllllllllllIlIlIIllIllIlIllIIl, final int lllllllllllllIlIlIIllIllIlIllllI, final Node<K, V> lllllllllllllIlIlIIllIllIlIlIlll, final Node<K, V> lllllllllllllIlIlIIllIllIlIlllII) {
            this.parent = lllllllllllllIlIlIIllIllIlIllIlI;
            this.key = lllllllllllllIlIlIIllIllIlIllIIl;
            this.hash = lllllllllllllIlIlIIllIllIlIllllI;
            this.height = 1;
            this.next = lllllllllllllIlIlIIllIllIlIlIlll;
            this.prev = lllllllllllllIlIlIIllIllIlIlllII;
            lllllllllllllIlIlIIllIllIlIlllII.next = this;
            lllllllllllllIlIlIIllIllIlIlIlll.prev = this;
        }
        
        @Override
        public K getKey() {
            return this.key;
        }
        
        @Override
        public boolean equals(final Object lllllllllllllIlIlIIllIllIlIIIIIl) {
            if (lllllllllllllIlIlIIllIllIlIIIIIl instanceof Map.Entry) {
                final Map.Entry lllllllllllllIlIlIIllIllIlIIIIll = (Map.Entry)lllllllllllllIlIlIIllIllIlIIIIIl;
                if (this.key == null) {
                    if (lllllllllllllIlIlIIllIllIlIIIIll.getKey() != null) {
                        return false;
                    }
                }
                else if (!this.key.equals(lllllllllllllIlIlIIllIllIlIIIIll.getKey())) {
                    return false;
                }
                if ((this.value != null) ? this.value.equals(lllllllllllllIlIlIIllIllIlIIIIll.getValue()) : (lllllllllllllIlIlIIllIllIlIIIIll.getValue() == null)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        
        public Node<K, V> last() {
            Node<K, V> lllllllllllllIlIlIIllIllIIlIlIlI = this;
            for (Node<K, V> lllllllllllllIlIlIIllIllIIlIlIIl = lllllllllllllIlIlIIllIllIIlIlIlI.right; lllllllllllllIlIlIIllIllIIlIlIIl != null; lllllllllllllIlIlIIllIllIIlIlIIl = lllllllllllllIlIlIIllIllIIlIlIlI.right) {
                lllllllllllllIlIlIIllIllIIlIlIlI = lllllllllllllIlIlIIllIllIIlIlIIl;
            }
            return lllllllllllllIlIlIIllIllIIlIlIlI;
        }
        
        @Override
        public V setValue(final V lllllllllllllIlIlIIllIllIlIIlIll) {
            final V lllllllllllllIlIlIIllIllIlIIlIlI = this.value;
            this.value = lllllllllllllIlIlIIllIllIlIIlIll;
            return lllllllllllllIlIlIIllIllIlIIlIlI;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(this.key).append("=").append(this.value));
        }
        
        @Override
        public V getValue() {
            return this.value;
        }
        
        @Override
        public int hashCode() {
            return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
        }
        
        Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }
    }
    
    final class EntrySet extends AbstractSet<Map.Entry<K, V>>
    {
        @Override
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
        
        @Override
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
        
        @Override
        public boolean remove(final Object lllllllllllllIIllllIIIlllllllIlI) {
            if (!(lllllllllllllIIllllIIIlllllllIlI instanceof Map.Entry)) {
                return false;
            }
            final Node<K, V> lllllllllllllIIllllIIIllllllllII = LinkedHashTreeMap.this.findByEntry((Map.Entry<?, ?>)lllllllllllllIIllllIIIlllllllIlI);
            if (lllllllllllllIIllllIIIllllllllII == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(lllllllllllllIIllllIIIllllllllII, true);
            return true;
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIIllllIIlIIIIIIIIlI) {
            return lllllllllllllIIllllIIlIIIIIIIIlI instanceof Map.Entry && LinkedHashTreeMap.this.findByEntry((Map.Entry<?, ?>)lllllllllllllIIllllIIlIIIIIIIIlI) != null;
        }
        
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMapIterator<Map.Entry<K, V>>() {
                @Override
                public Map.Entry<K, V> next() {
                    return this.nextNode();
                }
            };
        }
    }
    
    final class KeySet extends AbstractSet<K>
    {
        @Override
        public void clear() {
            LinkedHashTreeMap.this.clear();
        }
        
        @Override
        public boolean contains(final Object lllllllllllllllIlIIlIlIIIllIIlll) {
            return LinkedHashTreeMap.this.containsKey(lllllllllllllllIlIIlIlIIIllIIlll);
        }
        
        @Override
        public boolean remove(final Object lllllllllllllllIlIIlIlIIIllIIIll) {
            return LinkedHashTreeMap.this.removeInternalByKey(lllllllllllllllIlIIlIlIIIllIIIll) != null;
        }
        
        @Override
        public int size() {
            return LinkedHashTreeMap.this.size;
        }
        
        @Override
        public Iterator<K> iterator() {
            return new LinkedTreeMapIterator<K>() {
                @Override
                public K next() {
                    return this.nextNode().key;
                }
            };
        }
    }
    
    static final class AvlBuilder<K, V>
    {
        private /* synthetic */ int leavesSkipped;
        private /* synthetic */ Node<K, V> stack;
        private /* synthetic */ int leavesToSkip;
        private /* synthetic */ int size;
        
        void reset(final int llllllllllllIlllllIIlIIIllIlIIll) {
            final int llllllllllllIlllllIIlIIIllIlIlIl = Integer.highestOneBit(llllllllllllIlllllIIlIIIllIlIIll) * 2 - 1;
            this.leavesToSkip = llllllllllllIlllllIIlIIIllIlIlIl - llllllllllllIlllllIIlIIIllIlIIll;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = null;
        }
        
        void add(final Node<K, V> llllllllllllIlllllIIlIIIllIIIlII) {
            final Node<K, V> left = null;
            llllllllllllIlllllIIlIIIllIIIlII.right = (Node<K, V>)left;
            llllllllllllIlllllIIlIIIllIIIlII.parent = (Node<K, V>)left;
            llllllllllllIlllllIIlIIIllIIIlII.left = (Node<K, V>)left;
            llllllllllllIlllllIIlIIIllIIIlII.height = 1;
            if (this.leavesToSkip > 0 && (this.size & 0x1) == 0x0) {
                ++this.size;
                --this.leavesToSkip;
                ++this.leavesSkipped;
            }
            llllllllllllIlllllIIlIIIllIIIlII.parent = this.stack;
            this.stack = llllllllllllIlllllIIlIIIllIIIlII;
            ++this.size;
            if (this.leavesToSkip > 0 && (this.size & 0x1) == 0x0) {
                ++this.size;
                --this.leavesToSkip;
                ++this.leavesSkipped;
            }
            for (int llllllllllllIlllllIIlIIIllIIIllI = 4; (this.size & llllllllllllIlllllIIlIIIllIIIllI - 1) == llllllllllllIlllllIIlIIIllIIIllI - 1; llllllllllllIlllllIIlIIIllIIIllI *= 2) {
                if (this.leavesSkipped == 0) {
                    final Node<K, V> llllllllllllIlllllIIlIIIllIIlIll = this.stack;
                    final Node<K, V> llllllllllllIlllllIIlIIIllIIlIlI = llllllllllllIlllllIIlIIIllIIlIll.parent;
                    final Node<K, V> llllllllllllIlllllIIlIIIllIIlIIl = llllllllllllIlllllIIlIIIllIIlIlI.parent;
                    llllllllllllIlllllIIlIIIllIIlIlI.parent = llllllllllllIlllllIIlIIIllIIlIIl.parent;
                    this.stack = llllllllllllIlllllIIlIIIllIIlIlI;
                    llllllllllllIlllllIIlIIIllIIlIlI.left = llllllllllllIlllllIIlIIIllIIlIIl;
                    llllllllllllIlllllIIlIIIllIIlIlI.right = llllllllllllIlllllIIlIIIllIIlIll;
                    llllllllllllIlllllIIlIIIllIIlIlI.height = llllllllllllIlllllIIlIIIllIIlIll.height + 1;
                    llllllllllllIlllllIIlIIIllIIlIIl.parent = llllllllllllIlllllIIlIIIllIIlIlI;
                    llllllllllllIlllllIIlIIIllIIlIll.parent = llllllllllllIlllllIIlIIIllIIlIlI;
                }
                else if (this.leavesSkipped == 1) {
                    final Node<K, V> llllllllllllIlllllIIlIIIllIIlIII = this.stack;
                    final Node<K, V> llllllllllllIlllllIIlIIIllIIIlll = llllllllllllIlllllIIlIIIllIIlIII.parent;
                    this.stack = llllllllllllIlllllIIlIIIllIIIlll;
                    llllllllllllIlllllIIlIIIllIIIlll.right = llllllllllllIlllllIIlIIIllIIlIII;
                    llllllllllllIlllllIIlIIIllIIIlll.height = llllllllllllIlllllIIlIIIllIIlIII.height + 1;
                    llllllllllllIlllllIIlIIIllIIlIII.parent = llllllllllllIlllllIIlIIIllIIIlll;
                    this.leavesSkipped = 0;
                }
                else if (this.leavesSkipped == 2) {
                    this.leavesSkipped = 0;
                }
            }
        }
        
        Node<K, V> root() {
            final Node<K, V> llllllllllllIlllllIIlIIIlIlllIlI = this.stack;
            if (llllllllllllIlllllIIlIIIlIlllIlI.parent != null) {
                throw new IllegalStateException();
            }
            return llllllllllllIlllllIIlIIIlIlllIlI;
        }
    }
    
    static class AvlIterator<K, V>
    {
        private /* synthetic */ Node<K, V> stackTop;
        
        public Node<K, V> next() {
            Node<K, V> lllllllllllllIlIIlIIlllIllIIIIIl = this.stackTop;
            if (lllllllllllllIlIIlIIlllIllIIIIIl == null) {
                return null;
            }
            final Node<K, V> lllllllllllllIlIIlIIlllIllIIIIII = lllllllllllllIlIIlIIlllIllIIIIIl;
            lllllllllllllIlIIlIIlllIllIIIIIl = lllllllllllllIlIIlIIlllIllIIIIII.parent;
            lllllllllllllIlIIlIIlllIllIIIIII.parent = null;
            for (Node<K, V> lllllllllllllIlIIlIIlllIllIIIIll = lllllllllllllIlIIlIIlllIllIIIIII.right; lllllllllllllIlIIlIIlllIllIIIIll != null; lllllllllllllIlIIlIIlllIllIIIIll = lllllllllllllIlIIlIIlllIllIIIIll.left) {
                lllllllllllllIlIIlIIlllIllIIIIll.parent = lllllllllllllIlIIlIIlllIllIIIIIl;
                lllllllllllllIlIIlIIlllIllIIIIIl = lllllllllllllIlIIlIIlllIllIIIIll;
            }
            this.stackTop = lllllllllllllIlIIlIIlllIllIIIIIl;
            return lllllllllllllIlIIlIIlllIllIIIIII;
        }
        
        void reset(final Node<K, V> lllllllllllllIlIIlIIlllIllIIllIl) {
            Node<K, V> lllllllllllllIlIIlIIlllIllIIllII = null;
            for (Node<K, V> lllllllllllllIlIIlIIlllIllIIllll = lllllllllllllIlIIlIIlllIllIIllIl; lllllllllllllIlIIlIIlllIllIIllll != null; lllllllllllllIlIIlIIlllIllIIllll = lllllllllllllIlIIlIIlllIllIIllll.left) {
                lllllllllllllIlIIlIIlllIllIIllll.parent = lllllllllllllIlIIlIIlllIllIIllII;
                lllllllllllllIlIIlIIlllIllIIllII = lllllllllllllIlIIlIIlllIllIIllll;
            }
            this.stackTop = lllllllllllllIlIIlIIlllIllIIllII;
        }
    }
}
