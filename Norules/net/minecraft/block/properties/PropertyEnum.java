package net.minecraft.block.properties;

import net.minecraft.util.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;

public class PropertyEnum<T extends Enum> extends PropertyHelper<T>
{
    private final /* synthetic */ ImmutableSet<T> allowedValues;
    private final /* synthetic */ Map<String, T> nameToValue;
    
    @Override
    public String getName(final T lllllllllllllIlIlIIlIlllIllIIlll) {
        return ((IStringSerializable)lllllllllllllIlIlIIlIlllIllIIlll).getName();
    }
    
    public static <T extends java.lang.Enum> PropertyEnum<T> create(final String lllllllllllllIlIlIIlIlllIlIIIIIl, final Class<T> lllllllllllllIlIlIIlIlllIlIIIIII, final T... lllllllllllllIlIlIIlIlllIIllllll) {
        return create(lllllllllllllIlIlIIlIlllIlIIIIIl, lllllllllllllIlIlIIlIlllIlIIIIII, Lists.newArrayList((Object[])lllllllllllllIlIlIIlIlllIIllllll));
    }
    
    public static <T extends java.lang.Enum> PropertyEnum<T> create(final String lllllllllllllIlIlIIlIlllIlIlIlII, final Class<T> lllllllllllllIlIlIIlIlllIlIlIIll) {
        return create(lllllllllllllIlIlIIlIlllIlIlIlII, lllllllllllllIlIlIIlIlllIlIlIIll, (com.google.common.base.Predicate<T>)Predicates.alwaysTrue());
    }
    
    @Override
    public Optional<T> parseValue(final String lllllllllllllIlIlIIlIlllIllIlIlI) {
        return (Optional<T>)Optional.fromNullable((Object)this.nameToValue.get(lllllllllllllIlIlIIlIlllIllIlIlI));
    }
    
    public static <T extends java.lang.Enum> PropertyEnum<T> create(final String lllllllllllllIlIlIIlIlllIIlllIII, final Class<T> lllllllllllllIlIlIIlIlllIIllIlll, final Collection<T> lllllllllllllIlIlIIlIlllIIlllIIl) {
        return new PropertyEnum<T>(lllllllllllllIlIlIIlIlllIIlllIII, lllllllllllllIlIlIIlIlllIIllIlll, lllllllllllllIlIlIIlIlllIIlllIIl);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIlIIlIlllIlIllllI) {
        if (this == lllllllllllllIlIlIIlIlllIlIllllI) {
            return true;
        }
        if (lllllllllllllIlIlIIlIlllIlIllllI instanceof PropertyEnum && super.equals(lllllllllllllIlIlIIlIlllIlIllllI)) {
            final PropertyEnum<?> lllllllllllllIlIlIIlIlllIllIIIII = (PropertyEnum<?>)lllllllllllllIlIlIIlIlllIlIllllI;
            return this.allowedValues.equals((Object)lllllllllllllIlIlIIlIlllIllIIIII.allowedValues) && this.nameToValue.equals(lllllllllllllIlIlIIlIlllIllIIIII.nameToValue);
        }
        return false;
    }
    
    protected PropertyEnum(final String lllllllllllllIlIlIIlIlllIllllIII, final Class<T> lllllllllllllIlIlIIlIlllIlllllIl, final Collection<T> lllllllllllllIlIlIIlIlllIlllllII) {
        super(lllllllllllllIlIlIIlIlllIllllIII, lllllllllllllIlIlIIlIlllIlllllIl);
        this.nameToValue = (Map<String, T>)Maps.newHashMap();
        this.allowedValues = (ImmutableSet<T>)ImmutableSet.copyOf((Collection)lllllllllllllIlIlIIlIlllIlllllII);
        for (final T lllllllllllllIlIlIIlIlllIllllIll : lllllllllllllIlIlIIlIlllIlllllII) {
            final String lllllllllllllIlIlIIlIlllIllllIlI = ((IStringSerializable)lllllllllllllIlIlIIlIlllIllllIll).getName();
            if (this.nameToValue.containsKey(lllllllllllllIlIlIIlIlllIllllIlI)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Multiple values have the same name '").append(lllllllllllllIlIlIIlIlllIllllIlI).append("'")));
            }
            this.nameToValue.put(lllllllllllllIlIlIIlIlllIllllIlI, lllllllllllllIlIlIIlIlllIllllIll);
        }
    }
    
    @Override
    public int hashCode() {
        int lllllllllllllIlIlIIlIlllIlIllIIl = super.hashCode();
        lllllllllllllIlIlIIlIlllIlIllIIl = 31 * lllllllllllllIlIlIIlIlllIlIllIIl + this.allowedValues.hashCode();
        lllllllllllllIlIlIIlIlllIlIllIIl = 31 * lllllllllllllIlIlIIlIlllIlIllIIl + this.nameToValue.hashCode();
        return lllllllllllllIlIlIIlIlllIlIllIIl;
    }
    
    @Override
    public Collection<T> getAllowedValues() {
        return (Collection<T>)this.allowedValues;
    }
    
    public static <T extends java.lang.Enum> PropertyEnum<T> create(final String lllllllllllllIlIlIIlIlllIlIIllIl, final Class<T> lllllllllllllIlIlIIlIlllIlIIlIIl, final Predicate<T> lllllllllllllIlIlIIlIlllIlIIlIII) {
        return create(lllllllllllllIlIlIIlIlllIlIIllIl, lllllllllllllIlIlIIlIlllIlIIlIIl, Collections2.filter((Collection)Lists.newArrayList((Object[])lllllllllllllIlIlIIlIlllIlIIlIIl.getEnumConstants()), (Predicate)lllllllllllllIlIlIIlIlllIlIIlIII));
    }
}
