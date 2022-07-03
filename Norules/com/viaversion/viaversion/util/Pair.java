package com.viaversion.viaversion.util;

import java.util.*;

public class Pair<X, Y>
{
    private final /* synthetic */ X key;
    private /* synthetic */ Y value;
    
    public X getKey() {
        return this.key;
    }
    
    public void setValue(final Y lllllllllllllIIllllllIIIIIIlIlIl) {
        this.value = lllllllllllllIIllllllIIIIIIlIlIl;
    }
    
    public Pair(final X lllllllllllllIIllllllIIIIIlIIIll, final Y lllllllllllllIIllllllIIIIIIlllll) {
        this.key = lllllllllllllIIllllllIIIIIlIIIll;
        this.value = lllllllllllllIIllllllIIIIIIlllll;
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIIllllllIIIIIIIIIll = (this.key != null) ? this.key.hashCode() : 0;
        lllllllllllllIIllllllIIIIIIIIIll = 31 * lllllllllllllIIllllllIIIIIIIIIll + ((this.value != null) ? this.value.hashCode() : 0);
        return lllllllllllllIIllllllIIIIIIIIIll;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder().append("Pair{").append(this.key).append(", ").append(this.value).append('}'));
    }
    
    public Y getValue() {
        return this.value;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIIllllllIIIIIIIlIll) {
        if (this == lllllllllllllIIllllllIIIIIIIlIll) {
            return true;
        }
        if (lllllllllllllIIllllllIIIIIIIlIll == null || this.getClass() != lllllllllllllIIllllllIIIIIIIlIll.getClass()) {
            return false;
        }
        final Pair<?, ?> lllllllllllllIIllllllIIIIIIIlIlI = (Pair<?, ?>)lllllllllllllIIllllllIIIIIIIlIll;
        return Objects.equals(this.key, lllllllllllllIIllllllIIIIIIIlIlI.key) && Objects.equals(this.value, lllllllllllllIIllllllIIIIIIIlIlI.value);
    }
}
