package com.viaversion.viaversion.libs.fastutil.ints;

import java.util.*;
import java.io.*;

public final class IntComparators
{
    public static final /* synthetic */ IntComparator NATURAL_COMPARATOR;
    public static final /* synthetic */ IntComparator OPPOSITE_COMPARATOR;
    
    static {
        NATURAL_COMPARATOR = new NaturalImplicitComparator();
        OPPOSITE_COMPARATOR = new OppositeImplicitComparator();
    }
    
    public static IntComparator asIntComparator(final Comparator<? super Integer> llllllllllllllIIlIIIIIlllIIIIIII) {
        if (llllllllllllllIIlIIIIIlllIIIIIII == null || llllllllllllllIIlIIIIIlllIIIIIII instanceof IntComparator) {
            return (IntComparator)llllllllllllllIIlIIIIIlllIIIIIII;
        }
        return new IntComparator() {
            @Override
            public int compare(final int lllllllllllllIlIlllIIlIIllIIIlIl, final int lllllllllllllIlIlllIIlIIllIIIIIl) {
                return llllllllllllllIIlIIIIIlllIIIIIII.compare(lllllllllllllIlIlllIIlIIllIIIlIl, lllllllllllllIlIlllIIlIIllIIIIIl);
            }
            
            @Override
            public int compare(final Integer lllllllllllllIlIlllIIlIIlIllllII, final Integer lllllllllllllIlIlllIIlIIlIlllIll) {
                return llllllllllllllIIlIIIIIlllIIIIIII.compare(lllllllllllllIlIlllIIlIIlIllllII, lllllllllllllIlIlllIIlIIlIlllIll);
            }
        };
    }
    
    private IntComparators() {
    }
    
    public static IntComparator oppositeComparator(final IntComparator llllllllllllllIIlIIIIIlllIIIIIlI) {
        if (llllllllllllllIIlIIIIIlllIIIIIlI instanceof OppositeComparator) {
            return ((OppositeComparator)llllllllllllllIIlIIIIIlllIIIIIlI).comparator;
        }
        return new OppositeComparator(llllllllllllllIIlIIIIIlllIIIIIlI);
    }
    
    protected static class NaturalImplicitComparator implements IntComparator, Serializable
    {
        @Override
        public final int compare(final int lllllllllllllIIlIIIIlllllIIIlIlI, final int lllllllllllllIIlIIIIlllllIIIlIll) {
            return Integer.compare(lllllllllllllIIlIIIIlllllIIIlIlI, lllllllllllllIIlIIIIlllllIIIlIll);
        }
        
        @Override
        public IntComparator reversed() {
            return IntComparators.OPPOSITE_COMPARATOR;
        }
        
        private Object readResolve() {
            return IntComparators.NATURAL_COMPARATOR;
        }
    }
    
    protected static class OppositeComparator implements IntComparator, Serializable
    {
        final /* synthetic */ IntComparator comparator;
        
        protected OppositeComparator(final IntComparator lllllllllllllIIIIIllllIIlllIllll) {
            this.comparator = lllllllllllllIIIIIllllIIlllIllll;
        }
        
        @Override
        public final IntComparator reversed() {
            return this.comparator;
        }
        
        @Override
        public final int compare(final int lllllllllllllIIIIIllllIIlllIIlIl, final int lllllllllllllIIIIIllllIIlllIIlII) {
            return this.comparator.compare(lllllllllllllIIIIIllllIIlllIIlII, lllllllllllllIIIIIllllIIlllIIlIl);
        }
    }
    
    protected static class OppositeImplicitComparator implements IntComparator, Serializable
    {
        @Override
        public final int compare(final int lllllllllllllllIlIllIIlIlIIIllII, final int lllllllllllllllIlIllIIlIlIIIlIIl) {
            return -Integer.compare(lllllllllllllllIlIllIIlIlIIIllII, lllllllllllllllIlIllIIlIlIIIlIIl);
        }
        
        @Override
        public IntComparator reversed() {
            return IntComparators.NATURAL_COMPARATOR;
        }
        
        private Object readResolve() {
            return IntComparators.OPPOSITE_COMPARATOR;
        }
    }
}
