package com.viaversion.viaversion.libs.gson.internal;

import java.io.*;
import java.util.*;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable
{
    private /* synthetic */ KeySet keySet;
    /* synthetic */ Comparator<? super K> comparator;
    /* synthetic */ int size;
    /* synthetic */ Node<K, V> root;
    final /* synthetic */ Node<K, V> header;
    /* synthetic */ int modCount;
    private static final /* synthetic */ Comparator<Comparable> NATURAL_ORDER;
    private /* synthetic */ EntrySet entrySet;
    
    @Override
    public boolean containsKey(final Object llllllllllllllIIIlIIIlIIllIIlIlI) {
        return this.findByObject(llllllllllllllIIIlIIIlIIllIIlIlI) != null;
    }
    
    private void replaceInParent(final Node<K, V> llllllllllllllIIIlIIIlIIIIllllll, final Node<K, V> llllllllllllllIIIlIIIlIIIlIIIIlI) {
        final Node<K, V> llllllllllllllIIIlIIIlIIIlIIIIIl = llllllllllllllIIIlIIIlIIIIllllll.parent;
        llllllllllllllIIIlIIIlIIIIllllll.parent = null;
        if (llllllllllllllIIIlIIIlIIIlIIIIlI != null) {
            llllllllllllllIIIlIIIlIIIlIIIIlI.parent = llllllllllllllIIIlIIIlIIIlIIIIIl;
        }
        if (llllllllllllllIIIlIIIlIIIlIIIIIl != null) {
            if (llllllllllllllIIIlIIIlIIIlIIIIIl.left == llllllllllllllIIIlIIIlIIIIllllll) {
                llllllllllllllIIIlIIIlIIIlIIIIIl.left = llllllllllllllIIIlIIIlIIIlIIIIlI;
            }
            else {
                assert llllllllllllllIIIlIIIlIIIlIIIIIl.right == llllllllllllllIIIlIIIlIIIIllllll;
                llllllllllllllIIIlIIIlIIIlIIIIIl.right = llllllllllllllIIIlIIIlIIIlIIIIlI;
            }
        }
        else {
            this.root = llllllllllllllIIIlIIIlIIIlIIIIlI;
        }
    }
    
    Node<K, V> findByObject(final Object llllllllllllllIIIlIIIlIIlIIIlIIl) {
        try {
            return (Node<K, V>)((llllllllllllllIIIlIIIlIIlIIIlIIl != null) ? this.find(llllllllllllllIIIlIIIlIIlIIIlIIl, false) : null);
        }
        catch (ClassCastException llllllllllllllIIIlIIIlIIlIIIlIll) {
            return null;
        }
    }
    
    static {
        NATURAL_ORDER = new Comparator<Comparable>() {
            @Override
            public int compare(final Comparable lllllllllllllIIlIllIlllIllIIIlII, final Comparable lllllllllllllIIlIllIlllIllIIIIIl) {
                return lllllllllllllIIlIllIlllIllIIIlII.compareTo(lllllllllllllIIlIllIlllIllIIIIIl);
            }
        };
    }
    
    void removeInternal(final Node<K, V> llllllllllllllIIIlIIIlIIIlIlllll, final boolean llllllllllllllIIIlIIIlIIIlIllIII) {
        if (llllllllllllllIIIlIIIlIIIlIllIII) {
            llllllllllllllIIIlIIIlIIIlIlllll.prev.next = llllllllllllllIIIlIIIlIIIlIlllll.next;
            llllllllllllllIIIlIIIlIIIlIlllll.next.prev = llllllllllllllIIIlIIIlIIIlIlllll.prev;
        }
        Node<K, V> llllllllllllllIIIlIIIlIIIlIlllIl = llllllllllllllIIIlIIIlIIIlIlllll.left;
        Node<K, V> llllllllllllllIIIlIIIlIIIlIlllII = llllllllllllllIIIlIIIlIIIlIlllll.right;
        final Node<K, V> llllllllllllllIIIlIIIlIIIlIllIll = llllllllllllllIIIlIIIlIIIlIlllll.parent;
        if (llllllllllllllIIIlIIIlIIIlIlllIl != null && llllllllllllllIIIlIIIlIIIlIlllII != null) {
            final Node<K, V> llllllllllllllIIIlIIIlIIIllIIIll = (llllllllllllllIIIlIIIlIIIlIlllIl.height > llllllllllllllIIIlIIIlIIIlIlllII.height) ? llllllllllllllIIIlIIIlIIIlIlllIl.last() : llllllllllllllIIIlIIIlIIIlIlllII.first();
            this.removeInternal(llllllllllllllIIIlIIIlIIIllIIIll, false);
            int llllllllllllllIIIlIIIlIIIllIIIlI = 0;
            llllllllllllllIIIlIIIlIIIlIlllIl = llllllllllllllIIIlIIIlIIIlIlllll.left;
            if (llllllllllllllIIIlIIIlIIIlIlllIl != null) {
                llllllllllllllIIIlIIIlIIIllIIIlI = llllllllllllllIIIlIIIlIIIlIlllIl.height;
                llllllllllllllIIIlIIIlIIIllIIIll.left = llllllllllllllIIIlIIIlIIIlIlllIl;
                llllllllllllllIIIlIIIlIIIlIlllIl.parent = llllllllllllllIIIlIIIlIIIllIIIll;
                llllllllllllllIIIlIIIlIIIlIlllll.left = null;
            }
            int llllllllllllllIIIlIIIlIIIllIIIIl = 0;
            llllllllllllllIIIlIIIlIIIlIlllII = llllllllllllllIIIlIIIlIIIlIlllll.right;
            if (llllllllllllllIIIlIIIlIIIlIlllII != null) {
                llllllllllllllIIIlIIIlIIIllIIIIl = llllllllllllllIIIlIIIlIIIlIlllII.height;
                llllllllllllllIIIlIIIlIIIllIIIll.right = llllllllllllllIIIlIIIlIIIlIlllII;
                llllllllllllllIIIlIIIlIIIlIlllII.parent = llllllllllllllIIIlIIIlIIIllIIIll;
                llllllllllllllIIIlIIIlIIIlIlllll.right = null;
            }
            llllllllllllllIIIlIIIlIIIllIIIll.height = Math.max(llllllllllllllIIIlIIIlIIIllIIIlI, llllllllllllllIIIlIIIlIIIllIIIIl) + 1;
            this.replaceInParent(llllllllllllllIIIlIIIlIIIlIlllll, llllllllllllllIIIlIIIlIIIllIIIll);
            return;
        }
        if (llllllllllllllIIIlIIIlIIIlIlllIl != null) {
            this.replaceInParent(llllllllllllllIIIlIIIlIIIlIlllll, llllllllllllllIIIlIIIlIIIlIlllIl);
            llllllllllllllIIIlIIIlIIIlIlllll.left = null;
        }
        else if (llllllllllllllIIIlIIIlIIIlIlllII != null) {
            this.replaceInParent(llllllllllllllIIIlIIIlIIIlIlllll, llllllllllllllIIIlIIIlIIIlIlllII);
            llllllllllllllIIIlIIIlIIIlIlllll.right = null;
        }
        else {
            this.replaceInParent(llllllllllllllIIIlIIIlIIIlIlllll, null);
        }
        this.rebalance(llllllllllllllIIIlIIIlIIIlIllIll, false);
        --this.size;
        ++this.modCount;
    }
    
    Node<K, V> findByEntry(final Map.Entry<?, ?> llllllllllllllIIIlIIIlIIlIIIIIII) {
        final Node<K, V> llllllllllllllIIIlIIIlIIIlllllll = this.findByObject(llllllllllllllIIIlIIIlIIlIIIIIII.getKey());
        final boolean llllllllllllllIIIlIIIlIIIllllllI = llllllllllllllIIIlIIIlIIIlllllll != null && this.equal(llllllllllllllIIIlIIIlIIIlllllll.value, llllllllllllllIIIlIIIlIIlIIIIIII.getValue());
        return llllllllllllllIIIlIIIlIIIllllllI ? llllllllllllllIIIlIIIlIIIlllllll : null;
    }
    
    private void rotateRight(final Node<K, V> llllllllllllllIIIlIIIIllllllIlII) {
        final Node<K, V> llllllllllllllIIIlIIIIllllllIIll = llllllllllllllIIIlIIIIllllllIlII.left;
        final Node<K, V> llllllllllllllIIIlIIIIllllllIIlI = llllllllllllllIIIlIIIIllllllIlII.right;
        final Node<K, V> llllllllllllllIIIlIIIIllllllIIIl = llllllllllllllIIIlIIIIllllllIIll.left;
        final Node<K, V> llllllllllllllIIIlIIIIllllllIIII = llllllllllllllIIIlIIIIllllllIIll.right;
        llllllllllllllIIIlIIIIllllllIlII.left = llllllllllllllIIIlIIIIllllllIIII;
        if (llllllllllllllIIIlIIIIllllllIIII != null) {
            llllllllllllllIIIlIIIIllllllIIII.parent = llllllllllllllIIIlIIIIllllllIlII;
        }
        this.replaceInParent(llllllllllllllIIIlIIIIllllllIlII, llllllllllllllIIIlIIIIllllllIIll);
        llllllllllllllIIIlIIIIllllllIIll.right = llllllllllllllIIIlIIIIllllllIlII;
        llllllllllllllIIIlIIIIllllllIlII.parent = llllllllllllllIIIlIIIIllllllIIll;
        llllllllllllllIIIlIIIIllllllIlII.height = Math.max((llllllllllllllIIIlIIIIllllllIIlI != null) ? llllllllllllllIIIlIIIIllllllIIlI.height : 0, (llllllllllllllIIIlIIIIllllllIIII != null) ? llllllllllllllIIIlIIIIllllllIIII.height : 0) + 1;
        llllllllllllllIIIlIIIIllllllIIll.height = Math.max(llllllllllllllIIIlIIIIllllllIlII.height, (llllllllllllllIIIlIIIIllllllIIIl != null) ? llllllllllllllIIIlIIIIllllllIIIl.height : 0) + 1;
    }
    
    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
    
    @Override
    public Set<K> keySet() {
        final KeySet llllllllllllllIIIlIIIIlllllIIIII = this.keySet;
        return (llllllllllllllIIIlIIIIlllllIIIII != null) ? llllllllllllllIIIlIIIIlllllIIIII : (this.keySet = new KeySet());
    }
    
    private boolean equal(final Object llllllllllllllIIIlIIIlIIIlllIlII, final Object llllllllllllllIIIlIIIlIIIlllIlIl) {
        return llllllllllllllIIIlIIIlIIIlllIlII == llllllllllllllIIIlIIIlIIIlllIlIl || (llllllllllllllIIIlIIIlIIIlllIlII != null && llllllllllllllIIIlIIIlIIIlllIlII.equals(llllllllllllllIIIlIIIlIIIlllIlIl));
    }
    
    @Override
    public int size() {
        return this.size;
    }
    
    public LinkedTreeMap() {
        this((Comparator)LinkedTreeMap.NATURAL_ORDER);
    }
    
    Node<K, V> removeInternalByKey(final Object llllllllllllllIIIlIIIlIIIlIIllIl) {
        final Node<K, V> llllllllllllllIIIlIIIlIIIlIIllII = this.findByObject(llllllllllllllIIIlIIIlIIIlIIllIl);
        if (llllllllllllllIIIlIIIlIIIlIIllII != null) {
            this.removeInternal(llllllllllllllIIIlIIIlIIIlIIllII, true);
        }
        return llllllllllllllIIIlIIIlIIIlIIllII;
    }
    
    @Override
    public void clear() {
        this.root = null;
        this.size = 0;
        ++this.modCount;
        final Node<K, V> header;
        final Node<K, V> node2;
        final Node<K, V> node = node2 = (header = this.header);
        node.prev = node2;
        header.next = node2;
    }
    
    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        final EntrySet llllllllllllllIIIlIIIIlllllIIllI = this.entrySet;
        return (llllllllllllllIIIlIIIIlllllIIllI != null) ? llllllllllllllIIIlIIIIlllllIIllI : (this.entrySet = new EntrySet());
    }
    
    private void rotateLeft(final Node<K, V> llllllllllllllIIIlIIIlIIIIIIIIII) {
        final Node<K, V> llllllllllllllIIIlIIIlIIIIIIIlIl = llllllllllllllIIIlIIIlIIIIIIIIII.left;
        final Node<K, V> llllllllllllllIIIlIIIlIIIIIIIlII = llllllllllllllIIIlIIIlIIIIIIIIII.right;
        final Node<K, V> llllllllllllllIIIlIIIlIIIIIIIIll = llllllllllllllIIIlIIIlIIIIIIIlII.left;
        final Node<K, V> llllllllllllllIIIlIIIlIIIIIIIIlI = llllllllllllllIIIlIIIlIIIIIIIlII.right;
        llllllllllllllIIIlIIIlIIIIIIIIII.right = llllllllllllllIIIlIIIlIIIIIIIIll;
        if (llllllllllllllIIIlIIIlIIIIIIIIll != null) {
            llllllllllllllIIIlIIIlIIIIIIIIll.parent = llllllllllllllIIIlIIIlIIIIIIIIII;
        }
        this.replaceInParent(llllllllllllllIIIlIIIlIIIIIIIIII, llllllllllllllIIIlIIIlIIIIIIIlII);
        llllllllllllllIIIlIIIlIIIIIIIlII.left = llllllllllllllIIIlIIIlIIIIIIIIII;
        llllllllllllllIIIlIIIlIIIIIIIIII.parent = llllllllllllllIIIlIIIlIIIIIIIlII;
        llllllllllllllIIIlIIIlIIIIIIIIII.height = Math.max((llllllllllllllIIIlIIIlIIIIIIIlIl != null) ? llllllllllllllIIIlIIIlIIIIIIIlIl.height : 0, (llllllllllllllIIIlIIIlIIIIIIIIll != null) ? llllllllllllllIIIlIIIlIIIIIIIIll.height : 0) + 1;
        llllllllllllllIIIlIIIlIIIIIIIlII.height = Math.max(llllllllllllllIIIlIIIlIIIIIIIIII.height, (llllllllllllllIIIlIIIlIIIIIIIIlI != null) ? llllllllllllllIIIlIIIlIIIIIIIIlI.height : 0) + 1;
    }
    
    @Override
    public V put(final K llllllllllllllIIIlIIIlIIllIIIIIl, final V llllllllllllllIIIlIIIlIIllIIIIII) {
        if (llllllllllllllIIIlIIIlIIllIIIIIl == null) {
            throw new NullPointerException("key == null");
        }
        final Node<K, V> llllllllllllllIIIlIIIlIIlIllllll = this.find(llllllllllllllIIIlIIIlIIllIIIIIl, true);
        final V llllllllllllllIIIlIIIlIIlIlllllI = llllllllllllllIIIlIIIlIIlIllllll.value;
        llllllllllllllIIIlIIIlIIlIllllll.value = llllllllllllllIIIlIIIlIIllIIIIII;
        return llllllllllllllIIIlIIIlIIlIlllllI;
    }
    
    private void rebalance(final Node<K, V> llllllllllllllIIIlIIIlIIIIIllIlI, final boolean llllllllllllllIIIlIIIlIIIIIllIIl) {
        for (Node<K, V> llllllllllllllIIIlIIIlIIIIIlllll = llllllllllllllIIIlIIIlIIIIIllIlI; llllllllllllllIIIlIIIlIIIIIlllll != null; llllllllllllllIIIlIIIlIIIIIlllll = llllllllllllllIIIlIIIlIIIIIlllll.parent) {
            final Node<K, V> llllllllllllllIIIlIIIlIIIIlIIlII = llllllllllllllIIIlIIIlIIIIIlllll.left;
            final Node<K, V> llllllllllllllIIIlIIIlIIIIlIIIll = llllllllllllllIIIlIIIlIIIIIlllll.right;
            final int llllllllllllllIIIlIIIlIIIIlIIIlI = (llllllllllllllIIIlIIIlIIIIlIIlII != null) ? llllllllllllllIIIlIIIlIIIIlIIlII.height : 0;
            final int llllllllllllllIIIlIIIlIIIIlIIIIl = (llllllllllllllIIIlIIIlIIIIlIIIll != null) ? llllllllllllllIIIlIIIlIIIIlIIIll.height : 0;
            final int llllllllllllllIIIlIIIlIIIIlIIIII = llllllllllllllIIIlIIIlIIIIlIIIlI - llllllllllllllIIIlIIIlIIIIlIIIIl;
            if (llllllllllllllIIIlIIIlIIIIlIIIII == -2) {
                final Node<K, V> llllllllllllllIIIlIIIlIIIIlIlllI = llllllllllllllIIIlIIIlIIIIlIIIll.left;
                final Node<K, V> llllllllllllllIIIlIIIlIIIIlIllIl = llllllllllllllIIIlIIIlIIIIlIIIll.right;
                final int llllllllllllllIIIlIIIlIIIIlIllII = (llllllllllllllIIIlIIIlIIIIlIllIl != null) ? llllllllllllllIIIlIIIlIIIIlIllIl.height : 0;
                final int llllllllllllllIIIlIIIlIIIIlIlIll = (llllllllllllllIIIlIIIlIIIIlIlllI != null) ? llllllllllllllIIIlIIIlIIIIlIlllI.height : 0;
                final int llllllllllllllIIIlIIIlIIIIlIlIlI = llllllllllllllIIIlIIIlIIIIlIlIll - llllllllllllllIIIlIIIlIIIIlIllII;
                if (llllllllllllllIIIlIIIlIIIIlIlIlI == -1 || (llllllllllllllIIIlIIIlIIIIlIlIlI == 0 && !llllllllllllllIIIlIIIlIIIIIllIIl)) {
                    this.rotateLeft(llllllllllllllIIIlIIIlIIIIIlllll);
                }
                else {
                    assert llllllllllllllIIIlIIIlIIIIlIlIlI == 1;
                    this.rotateRight(llllllllllllllIIIlIIIlIIIIlIIIll);
                    this.rotateLeft(llllllllllllllIIIlIIIlIIIIIlllll);
                }
                if (llllllllllllllIIIlIIIlIIIIIllIIl) {
                    break;
                }
            }
            else if (llllllllllllllIIIlIIIlIIIIlIIIII == 2) {
                final Node<K, V> llllllllllllllIIIlIIIlIIIIlIlIIl = llllllllllllllIIIlIIIlIIIIlIIlII.left;
                final Node<K, V> llllllllllllllIIIlIIIlIIIIlIlIII = llllllllllllllIIIlIIIlIIIIlIIlII.right;
                final int llllllllllllllIIIlIIIlIIIIlIIlll = (llllllllllllllIIIlIIIlIIIIlIlIII != null) ? llllllllllllllIIIlIIIlIIIIlIlIII.height : 0;
                final int llllllllllllllIIIlIIIlIIIIlIIllI = (llllllllllllllIIIlIIIlIIIIlIlIIl != null) ? llllllllllllllIIIlIIIlIIIIlIlIIl.height : 0;
                final int llllllllllllllIIIlIIIlIIIIlIIlIl = llllllllllllllIIIlIIIlIIIIlIIllI - llllllllllllllIIIlIIIlIIIIlIIlll;
                if (llllllllllllllIIIlIIIlIIIIlIIlIl == 1 || (llllllllllllllIIIlIIIlIIIIlIIlIl == 0 && !llllllllllllllIIIlIIIlIIIIIllIIl)) {
                    this.rotateRight(llllllllllllllIIIlIIIlIIIIIlllll);
                }
                else {
                    assert llllllllllllllIIIlIIIlIIIIlIIlIl == -1;
                    this.rotateLeft(llllllllllllllIIIlIIIlIIIIlIIlII);
                    this.rotateRight(llllllllllllllIIIlIIIlIIIIIlllll);
                }
                if (llllllllllllllIIIlIIIlIIIIIllIIl) {
                    break;
                }
            }
            else if (llllllllllllllIIIlIIIlIIIIlIIIII == 0) {
                llllllllllllllIIIlIIIlIIIIIlllll.height = llllllllllllllIIIlIIIlIIIIlIIIlI + 1;
                if (llllllllllllllIIIlIIIlIIIIIllIIl) {
                    break;
                }
            }
            else {
                assert llllllllllllllIIIlIIIlIIIIlIIIII == 1;
                llllllllllllllIIIlIIIlIIIIIlllll.height = Math.max(llllllllllllllIIIlIIIlIIIIlIIIlI, llllllllllllllIIIlIIIlIIIIlIIIIl) + 1;
                if (!llllllllllllllIIIlIIIlIIIIIllIIl) {
                    break;
                }
            }
        }
    }
    
    @Override
    public V get(final Object llllllllllllllIIIlIIIlIIllIIllll) {
        final Node<K, V> llllllllllllllIIIlIIIlIIllIlIIIl = this.findByObject(llllllllllllllIIIlIIIlIIllIIllll);
        return (llllllllllllllIIIlIIIlIIllIlIIIl != null) ? llllllllllllllIIIlIIIlIIllIlIIIl.value : null;
    }
    
    public LinkedTreeMap(final Comparator<? super K> llllllllllllllIIIlIIIlIIllIllIlI) {
        this.size = 0;
        this.modCount = 0;
        this.header = new Node<K, V>();
        this.comparator = (Comparator<? super K>)((llllllllllllllIIIlIIIlIIllIllIlI != null) ? llllllllllllllIIIlIIIlIIllIllIlI : LinkedTreeMap.NATURAL_ORDER);
    }
    
    Node<K, V> find(final K llllllllllllllIIIlIIIlIIlIIlIlIl, final boolean llllllllllllllIIIlIIIlIIlIIlllII) {
        final Comparator<? super K> llllllllllllllIIIlIIIlIIlIIllIll = this.comparator;
        Node<K, V> llllllllllllllIIIlIIIlIIlIIllIlI = this.root;
        int llllllllllllllIIIlIIIlIIlIIllIIl = 0;
        if (llllllllllllllIIIlIIIlIIlIIllIlI != null) {
            final Comparable<Object> llllllllllllllIIIlIIIlIIlIlIIIII = (Comparable<Object>)((llllllllllllllIIIlIIIlIIlIIllIll == LinkedTreeMap.NATURAL_ORDER) ? ((Comparable)llllllllllllllIIIlIIIlIIlIIlIlIl) : null);
            while (true) {
                llllllllllllllIIIlIIIlIIlIIllIIl = ((llllllllllllllIIIlIIIlIIlIlIIIII != null) ? llllllllllllllIIIlIIIlIIlIlIIIII.compareTo(llllllllllllllIIIlIIIlIIlIIllIlI.key) : llllllllllllllIIIlIIIlIIlIIllIll.compare((Object)llllllllllllllIIIlIIIlIIlIIlIlIl, (Object)llllllllllllllIIIlIIIlIIlIIllIlI.key));
                if (llllllllllllllIIIlIIIlIIlIIllIIl == 0) {
                    return llllllllllllllIIIlIIIlIIlIIllIlI;
                }
                final Node<K, V> llllllllllllllIIIlIIIlIIlIlIIIIl = (llllllllllllllIIIlIIIlIIlIIllIIl < 0) ? llllllllllllllIIIlIIIlIIlIIllIlI.left : llllllllllllllIIIlIIIlIIlIIllIlI.right;
                if (llllllllllllllIIIlIIIlIIlIlIIIIl == null) {
                    break;
                }
                llllllllllllllIIIlIIIlIIlIIllIlI = llllllllllllllIIIlIIIlIIlIlIIIIl;
            }
        }
        if (!llllllllllllllIIIlIIIlIIlIIlllII) {
            return null;
        }
        final Node<K, V> llllllllllllllIIIlIIIlIIlIIllIII = this.header;
        Node<K, V> llllllllllllllIIIlIIIlIIlIIlIlll = null;
        if (llllllllllllllIIIlIIIlIIlIIllIlI == null) {
            if (llllllllllllllIIIlIIIlIIlIIllIll == LinkedTreeMap.NATURAL_ORDER && !(llllllllllllllIIIlIIIlIIlIIlIlIl instanceof Comparable)) {
                throw new ClassCastException(String.valueOf(new StringBuilder().append(llllllllllllllIIIlIIIlIIlIIlIlIl.getClass().getName()).append(" is not Comparable")));
            }
            final Node<K, V> llllllllllllllIIIlIIIlIIlIIlllll = new Node<K, V>(llllllllllllllIIIlIIIlIIlIIllIlI, llllllllllllllIIIlIIIlIIlIIlIlIl, llllllllllllllIIIlIIIlIIlIIllIII, llllllllllllllIIIlIIIlIIlIIllIII.prev);
            this.root = llllllllllllllIIIlIIIlIIlIIlllll;
        }
        else {
            llllllllllllllIIIlIIIlIIlIIlIlll = new Node<K, V>(llllllllllllllIIIlIIIlIIlIIllIlI, llllllllllllllIIIlIIIlIIlIIlIlIl, llllllllllllllIIIlIIIlIIlIIllIII, llllllllllllllIIIlIIIlIIlIIllIII.prev);
            if (llllllllllllllIIIlIIIlIIlIIllIIl < 0) {
                llllllllllllllIIIlIIIlIIlIIllIlI.left = llllllllllllllIIIlIIIlIIlIIlIlll;
            }
            else {
                llllllllllllllIIIlIIIlIIlIIllIlI.right = llllllllllllllIIIlIIIlIIlIIlIlll;
            }
            this.rebalance(llllllllllllllIIIlIIIlIIlIIllIlI, true);
        }
        ++this.size;
        ++this.modCount;
        return llllllllllllllIIIlIIIlIIlIIlIlll;
    }
    
    @Override
    public V remove(final Object llllllllllllllIIIlIIIlIIlIlIlIll) {
        final Node<K, V> llllllllllllllIIIlIIIlIIlIlIllIl = this.removeInternalByKey(llllllllllllllIIIlIIIlIIlIlIlIll);
        return (llllllllllllllIIIlIIIlIIlIlIllIl != null) ? llllllllllllllIIIlIIIlIIlIlIllIl.value : null;
    }
    
    static final class Node<K, V> implements Map.Entry<K, V>
    {
        /* synthetic */ V value;
        /* synthetic */ Node<K, V> left;
        /* synthetic */ Node<K, V> next;
        /* synthetic */ Node<K, V> prev;
        /* synthetic */ int height;
        /* synthetic */ Node<K, V> right;
        /* synthetic */ Node<K, V> parent;
        final /* synthetic */ K key;
        
        Node() {
            this.key = null;
            this.prev = this;
            this.next = this;
        }
        
        @Override
        public String toString() {
            return String.valueOf(new StringBuilder().append(this.key).append("=").append(this.value));
        }
        
        @Override
        public boolean equals(final Object lllllllllllllllIllllllIlllIllIlI) {
            if (lllllllllllllllIllllllIlllIllIlI instanceof Map.Entry) {
                final Map.Entry lllllllllllllllIllllllIlllIlllII = (Map.Entry)lllllllllllllllIllllllIlllIllIlI;
                if (this.key == null) {
                    if (lllllllllllllllIllllllIlllIlllII.getKey() != null) {
                        return false;
                    }
                }
                else if (!this.key.equals(lllllllllllllllIllllllIlllIlllII.getKey())) {
                    return false;
                }
                if ((this.value != null) ? this.value.equals(lllllllllllllllIllllllIlllIlllII.getValue()) : (lllllllllllllllIllllllIlllIlllII.getValue() == null)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        
        @Override
        public K getKey() {
            return this.key;
        }
        
        @Override
        public V getValue() {
            return this.value;
        }
        
        public Node<K, V> first() {
            Node<K, V> lllllllllllllllIllllllIlllIIllII = this;
            for (Node<K, V> lllllllllllllllIllllllIlllIIlIll = lllllllllllllllIllllllIlllIIllII.left; lllllllllllllllIllllllIlllIIlIll != null; lllllllllllllllIllllllIlllIIlIll = lllllllllllllllIllllllIlllIIllII.left) {
                lllllllllllllllIllllllIlllIIllII = lllllllllllllllIllllllIlllIIlIll;
            }
            return lllllllllllllllIllllllIlllIIllII;
        }
        
        @Override
        public V setValue(final V lllllllllllllllIllllllIllllIIlII) {
            final V lllllllllllllllIllllllIllllIIIll = this.value;
            this.value = lllllllllllllllIllllllIllllIIlII;
            return lllllllllllllllIllllllIllllIIIll;
        }
        
        public Node<K, V> last() {
            Node<K, V> lllllllllllllllIllllllIlllIIIIll = this;
            for (Node<K, V> lllllllllllllllIllllllIlllIIIIlI = lllllllllllllllIllllllIlllIIIIll.right; lllllllllllllllIllllllIlllIIIIlI != null; lllllllllllllllIllllllIlllIIIIlI = lllllllllllllllIllllllIlllIIIIll.right) {
                lllllllllllllllIllllllIlllIIIIll = lllllllllllllllIllllllIlllIIIIlI;
            }
            return lllllllllllllllIllllllIlllIIIIll;
        }
        
        @Override
        public int hashCode() {
            return ((this.key == null) ? 0 : this.key.hashCode()) ^ ((this.value == null) ? 0 : this.value.hashCode());
        }
        
        Node(final Node<K, V> lllllllllllllllIllllllIlllllIlll, final K lllllllllllllllIllllllIlllllIIIl, final Node<K, V> lllllllllllllllIllllllIlllllIlIl, final Node<K, V> lllllllllllllllIllllllIllllIllll) {
            this.parent = lllllllllllllllIllllllIlllllIlll;
            this.key = lllllllllllllllIllllllIlllllIIIl;
            this.height = 1;
            this.next = lllllllllllllllIllllllIlllllIlIl;
            this.prev = lllllllllllllllIllllllIllllIllll;
            lllllllllllllllIllllllIllllIllll.next = this;
            lllllllllllllllIllllllIlllllIlIl.prev = this;
        }
    }
    
    final class KeySet extends AbstractSet<K>
    {
        @Override
        public boolean remove(final Object lllllllllllllIIllIIllIIlIIlIIllI) {
            return LinkedTreeMap.this.removeInternalByKey(lllllllllllllIIllIIllIIlIIlIIllI) != null;
        }
        
        @Override
        public int size() {
            return LinkedTreeMap.this.size;
        }
        
        @Override
        public boolean contains(final Object lllllllllllllIIllIIllIIlIIlIllII) {
            return LinkedTreeMap.this.containsKey(lllllllllllllIIllIIllIIlIIlIllII);
        }
        
        @Override
        public void clear() {
            LinkedTreeMap.this.clear();
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
    
    private abstract class LinkedTreeMapIterator<T> implements Iterator<T>
    {
        /* synthetic */ Node<K, V> next;
        /* synthetic */ int expectedModCount;
        /* synthetic */ Node<K, V> lastReturned;
        
        @Override
        public final boolean hasNext() {
            return this.next != LinkedTreeMap.this.header;
        }
        
        LinkedTreeMapIterator() {
            this.next = LinkedTreeMap.this.header.next;
            this.lastReturned = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }
        
        final Node<K, V> nextNode() {
            final Node<K, V> llllllllllllllIlIIlIIllIllIIlIII = this.next;
            if (llllllllllllllIlIIlIIllIllIIlIII == LinkedTreeMap.this.header) {
                throw new NoSuchElementException();
            }
            if (LinkedTreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            this.next = llllllllllllllIlIIlIIllIllIIlIII.next;
            final Node<K, V> lastReturned = llllllllllllllIlIIlIIllIllIIlIII;
            this.lastReturned = lastReturned;
            return lastReturned;
        }
        
        @Override
        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            LinkedTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }
    }
    
    class EntrySet extends AbstractSet<Map.Entry<K, V>>
    {
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMapIterator<Map.Entry<K, V>>() {
                @Override
                public Map.Entry<K, V> next() {
                    return this.nextNode();
                }
            };
        }
        
        @Override
        public boolean remove(final Object llllllllllllllllllIllllIIlIllIlI) {
            if (!(llllllllllllllllllIllllIIlIllIlI instanceof Map.Entry)) {
                return false;
            }
            final Node<K, V> llllllllllllllllllIllllIIlIllIIl = LinkedTreeMap.this.findByEntry((Map.Entry<?, ?>)llllllllllllllllllIllllIIlIllIlI);
            if (llllllllllllllllllIllllIIlIllIIl == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(llllllllllllllllllIllllIIlIllIIl, true);
            return true;
        }
        
        @Override
        public int size() {
            return LinkedTreeMap.this.size;
        }
        
        @Override
        public void clear() {
            LinkedTreeMap.this.clear();
        }
        
        @Override
        public boolean contains(final Object llllllllllllllllllIllllIIllIIIIl) {
            return llllllllllllllllllIllllIIllIIIIl instanceof Map.Entry && LinkedTreeMap.this.findByEntry((Map.Entry<?, ?>)llllllllllllllllllIllllIIllIIIIl) != null;
        }
    }
}
