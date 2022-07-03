package com.viaversion.viaversion.libs.javassist.bytecode.analysis;

import java.util.*;

class IntQueue
{
    private /* synthetic */ Entry head;
    private /* synthetic */ Entry tail;
    
    int take() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        final int lllllllllllllIIIIIlIllIlIIlIlIll = this.head.value;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        return lllllllllllllIIIIIlIllIlIIlIlIll;
    }
    
    void add(final int lllllllllllllIIIIIlIllIlIIllIllI) {
        final Entry lllllllllllllIIIIIlIllIlIIllIlIl = new Entry(lllllllllllllIIIIIlIllIlIIllIllI);
        if (this.tail != null) {
            this.tail.next = lllllllllllllIIIIIlIllIlIIllIlIl;
        }
        this.tail = lllllllllllllIIIIIlIllIlIIllIlIl;
        if (this.head == null) {
            this.head = lllllllllllllIIIIIlIllIlIIllIlIl;
        }
    }
    
    boolean isEmpty() {
        return this.head == null;
    }
    
    private static class Entry
    {
        private /* synthetic */ int value;
        private /* synthetic */ Entry next;
        
        private Entry(final int lllIIlllIlIII) {
            this.value = lllIIlllIlIII;
        }
    }
}
