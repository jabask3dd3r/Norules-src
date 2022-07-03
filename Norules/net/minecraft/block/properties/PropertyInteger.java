package net.minecraft.block.properties;

import com.google.common.collect.*;
import java.util.*;
import com.google.common.base.*;

public class PropertyInteger extends PropertyHelper<Integer>
{
    private final /* synthetic */ ImmutableSet<Integer> allowedValues;
    
    @Override
    public String getName(final Integer lllllllllllllllIlIlIllllllIlIIll) {
        return lllllllllllllllIlIlIllllllIlIIll.toString();
    }
    
    @Override
    public boolean equals(final Object lllllllllllllllIlIlIllllllllIIIl) {
        if (this == lllllllllllllllIlIlIllllllllIIIl) {
            return true;
        }
        if (lllllllllllllllIlIlIllllllllIIIl instanceof PropertyInteger && super.equals(lllllllllllllllIlIlIllllllllIIIl)) {
            final PropertyInteger lllllllllllllllIlIlIllllllllIIII = (PropertyInteger)lllllllllllllllIlIlIllllllllIIIl;
            return this.allowedValues.equals((Object)lllllllllllllllIlIlIllllllllIIII.allowedValues);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.allowedValues.hashCode();
    }
    
    protected PropertyInteger(final String lllllllllllllllIlIllIIIIIIIIIIll, final int lllllllllllllllIlIllIIIIIIIIIIlI, final int lllllllllllllllIlIllIIIIIIIIIIIl) {
        super(lllllllllllllllIlIllIIIIIIIIIIll, Integer.class);
        if (lllllllllllllllIlIllIIIIIIIIIIlI < 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Min value of ").append(lllllllllllllllIlIllIIIIIIIIIIll).append(" must be 0 or greater")));
        }
        if (lllllllllllllllIlIllIIIIIIIIIIIl <= lllllllllllllllIlIllIIIIIIIIIIlI) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder("Max value of ").append(lllllllllllllllIlIllIIIIIIIIIIll).append(" must be greater than min (").append(lllllllllllllllIlIllIIIIIIIIIIlI).append(")")));
        }
        final Set<Integer> lllllllllllllllIlIllIIIIIIIIIIII = (Set<Integer>)Sets.newHashSet();
        for (int lllllllllllllllIlIlIllllllllllll = lllllllllllllllIlIllIIIIIIIIIIlI; lllllllllllllllIlIlIllllllllllll <= lllllllllllllllIlIllIIIIIIIIIIIl; ++lllllllllllllllIlIlIllllllllllll) {
            lllllllllllllllIlIllIIIIIIIIIIII.add(lllllllllllllllIlIlIllllllllllll);
        }
        this.allowedValues = (ImmutableSet<Integer>)ImmutableSet.copyOf((Collection)lllllllllllllllIlIllIIIIIIIIIIII);
    }
    
    @Override
    public Collection<Integer> getAllowedValues() {
        return (Collection<Integer>)this.allowedValues;
    }
    
    @Override
    public Optional<Integer> parseValue(final String lllllllllllllllIlIlIllllllIllIII) {
        try {
            final Integer lllllllllllllllIlIlIllllllIllIll = Integer.valueOf(lllllllllllllllIlIlIllllllIllIII);
            return (Optional<Integer>)(this.allowedValues.contains((Object)lllllllllllllllIlIlIllllllIllIll) ? Optional.of((Object)lllllllllllllllIlIlIllllllIllIll) : Optional.absent());
        }
        catch (NumberFormatException lllllllllllllllIlIlIllllllIllIlI) {
            return (Optional<Integer>)Optional.absent();
        }
    }
    
    public static PropertyInteger create(final String lllllllllllllllIlIlIlllllllIIllI, final int lllllllllllllllIlIlIlllllllIIlIl, final int lllllllllllllllIlIlIlllllllIIIIl) {
        return new PropertyInteger(lllllllllllllllIlIlIlllllllIIllI, lllllllllllllllIlIlIlllllllIIlIl, lllllllllllllllIlIlIlllllllIIIIl);
    }
}
