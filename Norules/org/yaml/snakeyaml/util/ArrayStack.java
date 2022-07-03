package org.yaml.snakeyaml.util;

import java.util.*;

public class ArrayStack<T>
{
    private /* synthetic */ ArrayList<T> stack;
    
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }
    
    public T pop() {
        return this.stack.remove(this.stack.size() - 1);
    }
    
    public void clear() {
        this.stack.clear();
    }
    
    public void push(final T lllllllllllllIIlllllIllIIlIllllI) {
        this.stack.add(lllllllllllllIIlllllIllIIlIllllI);
    }
    
    public ArrayStack(final int lllllllllllllIIlllllIllIIllIIlII) {
        this.stack = new ArrayList<T>(lllllllllllllIIlllllIllIIllIIlII);
    }
}
