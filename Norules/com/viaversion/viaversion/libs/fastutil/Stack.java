package com.viaversion.viaversion.libs.fastutil;

public interface Stack<K>
{
    K pop();
    
    boolean isEmpty();
    
    void push(final K p0);
    
    default K peek(final int llllllllllllllllIIlIIlIlIIIIllII) {
        throw new UnsupportedOperationException();
    }
    
    default K top() {
        return this.peek(0);
    }
}
