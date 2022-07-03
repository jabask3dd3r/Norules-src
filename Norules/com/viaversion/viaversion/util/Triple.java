package com.viaversion.viaversion.util;

import java.util.*;

public class Triple<A, B, C>
{
    private final /* synthetic */ C third;
    private final /* synthetic */ A first;
    private final /* synthetic */ B second;
    
    @Override
    public boolean equals(final Object lllllllllllllIIlIIIIlIIllIllIIIl) {
        if (this == lllllllllllllIIlIIIIlIIllIllIIIl) {
            return true;
        }
        if (lllllllllllllIIlIIIIlIIllIllIIIl == null || this.getClass() != lllllllllllllIIlIIIIlIIllIllIIIl.getClass()) {
            return false;
        }
        final Triple<?, ?, ?> lllllllllllllIIlIIIIlIIllIllIIII = (Triple<?, ?, ?>)lllllllllllllIIlIIIIlIIllIllIIIl;
        return Objects.equals(this.first, lllllllllllllIIlIIIIlIIllIllIIII.first) && Objects.equals(this.second, lllllllllllllIIlIIIIlIIllIllIIII.second) && Objects.equals(this.third, lllllllllllllIIlIIIIlIIllIllIIII.third);
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIlIIIIlIIllIlIlIIl = (this.first != null) ? this.first.hashCode() : 0;
        lllllllllllllIIlIIIIlIIllIlIlIIl = 31 * lllllllllllllIIlIIIIlIIllIlIlIIl + ((this.second != null) ? this.second.hashCode() : 0);
        lllllllllllllIIlIIIIlIIllIlIlIIl = 31 * lllllllllllllIIlIIIIlIIllIlIlIIl + ((this.third != null) ? this.third.hashCode() : 0);
        return lllllllllllllIIlIIIIlIIllIlIlIIl;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Triple{").append(this.first).append(", ").append(this.second).append(", ").append(this.third).append('}'));
    }
    
    public Triple(final A lllllllllllllIIlIIIIlIIlllIIlIII, final B lllllllllllllIIlIIIIlIIlllIIIlll, final C lllllllllllllIIlIIIIlIIlllIIIllI) {
        this.first = lllllllllllllIIlIIIIlIIlllIIlIII;
        this.second = lllllllllllllIIlIIIIlIIlllIIIlll;
        this.third = lllllllllllllIIlIIIIlIIlllIIIllI;
    }
    
    public A getFirst() {
        return this.first;
    }
    
    public C getThird() {
        return this.third;
    }
    
    public B getSecond() {
        return this.second;
    }
}
