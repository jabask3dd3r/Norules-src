package net.minecraft.block.properties;

import com.google.common.collect.*;
import java.util.*;
import com.google.common.base.*;

public class PropertyBool extends PropertyHelper<Boolean>
{
    private final /* synthetic */ ImmutableSet<Boolean> allowedValues;
    
    @Override
    public Collection<Boolean> getAllowedValues() {
        return (Collection<Boolean>)this.allowedValues;
    }
    
    public static PropertyBool create(final String lllllllllllllIlIIlIIIlIIIIlllIlI) {
        return new PropertyBool(lllllllllllllIlIIlIIIlIIIIlllIlI);
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlIIlIIIlIIIIlIllII) {
        if (this == lllllllllllllIlIIlIIIlIIIIlIllII) {
            return true;
        }
        if (lllllllllllllIlIIlIIIlIIIIlIllII instanceof PropertyBool && super.equals(lllllllllllllIlIIlIIIlIIIIlIllII)) {
            final PropertyBool lllllllllllllIlIIlIIIlIIIIlIlIll = (PropertyBool)lllllllllllllIlIIlIIIlIIIIlIllII;
            return this.allowedValues.equals((Object)lllllllllllllIlIIlIIIlIIIIlIlIll.allowedValues);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + this.allowedValues.hashCode();
    }
    
    @Override
    public String getName(final Boolean lllllllllllllIlIIlIIIlIIIIllIIIl) {
        return lllllllllllllIlIIlIIIlIIIIllIIIl.toString();
    }
    
    protected PropertyBool(final String lllllllllllllIlIIlIIIlIIIIllllll) {
        super(lllllllllllllIlIIlIIIlIIIIllllll, Boolean.class);
        this.allowedValues = (ImmutableSet<Boolean>)ImmutableSet.of((Object)true, (Object)false);
    }
    
    @Override
    public Optional<Boolean> parseValue(final String lllllllllllllIlIIlIIIlIIIIllIlIl) {
        return (Optional<Boolean>)((!"true".equals(lllllllllllllIlIIlIIIlIIIIllIlIl) && !"false".equals(lllllllllllllIlIIlIIIlIIIIllIlIl)) ? Optional.absent() : Optional.of((Object)Boolean.valueOf(lllllllllllllIlIIlIIIlIIIIllIlIl)));
    }
}
