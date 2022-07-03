package com.viaversion.viaversion.libs.fastutil.objects;

import java.util.*;
import java.io.*;

public final class ObjectComparators
{
    public static final /* synthetic */ Comparator NATURAL_COMPARATOR;
    public static final /* synthetic */ Comparator OPPOSITE_COMPARATOR;
    
    private ObjectComparators() {
    }
    
    static {
        NATURAL_COMPARATOR = new NaturalImplicitComparator();
        OPPOSITE_COMPARATOR = new OppositeImplicitComparator();
    }
    
    public static <K> Comparator<K> oppositeComparator(final Comparator<K> llIllllIIIIIllI) {
        if (llIllllIIIIIllI instanceof OppositeComparator) {
            return (Comparator<K>)((OppositeComparator)llIllllIIIIIllI).comparator;
        }
        return new OppositeComparator<K>(llIllllIIIIIllI);
    }
    
    protected static class NaturalImplicitComparator implements Serializable, Comparator
    {
        private Object readResolve() {
            return ObjectComparators.NATURAL_COMPARATOR;
        }
        
        @Override
        public Comparator reversed() {
            return ObjectComparators.OPPOSITE_COMPARATOR;
        }
        
        @Override
        public final int compare(final Object llllllllllllllIIIIIlllIlllIllIlI, final Object llllllllllllllIIIIIlllIlllIlllIl) {
            return ((Comparable)llllllllllllllIIIIIlllIlllIllIlI).compareTo(llllllllllllllIIIIIlllIlllIlllIl);
        }
    }
    
    protected static class OppositeComparator<K> implements Comparator<K>, Serializable
    {
        final /* synthetic */ Comparator<K> comparator;
        
        @Override
        public final Comparator<K> reversed() {
            return this.comparator;
        }
        
        @Override
        public final int compare(final K lllllllllllllIIllIlllIIIlIIlIlll, final K lllllllllllllIIllIlllIIIlIIllIIl) {
            return this.comparator.compare(lllllllllllllIIllIlllIIIlIIllIIl, lllllllllllllIIllIlllIIIlIIlIlll);
        }
        
        protected OppositeComparator(final Comparator<K> lllllllllllllIIllIlllIIIlIlIIIIl) {
            this.comparator = lllllllllllllIIllIlllIIIlIlIIIIl;
        }
    }
    
    protected static class OppositeImplicitComparator implements Serializable, Comparator
    {
        private Object readResolve() {
            return ObjectComparators.OPPOSITE_COMPARATOR;
        }
        
        @Override
        public Comparator reversed() {
            return ObjectComparators.NATURAL_COMPARATOR;
        }
        
        @Override
        public final int compare(final Object lllllllllllllllllIIIIIIIlIIIIIII, final Object lllllllllllllllllIIIIIIIlIIIIIIl) {
            return ((Comparable)lllllllllllllllllIIIIIIIlIIIIIIl).compareTo(lllllllllllllllllIIIIIIIlIIIIIII);
        }
    }
}
