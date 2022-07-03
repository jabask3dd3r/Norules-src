package com.viaversion.viaversion.libs.fastutil.ints;

import com.viaversion.viaversion.libs.fastutil.*;

public interface IntStack extends Stack<Integer>
{
    int peekInt(final int p0);
    
    int popInt();
    
    void push(final int p0);
    
    @Deprecated
    default Integer top() {
        return this.topInt();
    }
    
    @Deprecated
    default void push(final Integer lllllllllllllIllllllIllIlllIIllI) {
        this.push((int)lllllllllllllIllllllIllIlllIIllI);
    }
    
    int topInt();
    
    @Deprecated
    default Integer pop() {
        return this.popInt();
    }
    
    @Deprecated
    default Integer peek(final int lllllllllllllIllllllIllIllIllIlI) {
        return this.peekInt(lllllllllllllIllllllIllIllIllIlI);
    }
}
