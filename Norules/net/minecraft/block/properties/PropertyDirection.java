package net.minecraft.block.properties;

import net.minecraft.util.*;
import com.google.common.collect.*;
import java.util.*;
import com.google.common.base.*;

public class PropertyDirection extends PropertyEnum<EnumFacing>
{
    public static PropertyDirection create(final String lllllllllllllIlIlllIIIllIIIIlIIl, final Predicate<EnumFacing> lllllllllllllIlIlllIIIllIIIIIllI) {
        return create(lllllllllllllIlIlllIIIllIIIIlIIl, Collections2.filter((Collection)Lists.newArrayList((Object[])EnumFacing.values()), (Predicate)lllllllllllllIlIlllIIIllIIIIIllI));
    }
    
    protected PropertyDirection(final String lllllllllllllIlIlllIIIllIIIlIIII, final Collection<EnumFacing> lllllllllllllIlIlllIIIllIIIIllll) {
        super(lllllllllllllIlIlllIIIllIIIlIIII, EnumFacing.class, lllllllllllllIlIlllIIIllIIIIllll);
    }
    
    public static PropertyDirection create(final String lllllllllllllIlIlllIIIllIIIIllII) {
        return create(lllllllllllllIlIlllIIIllIIIIllII, (Predicate<EnumFacing>)Predicates.alwaysTrue());
    }
    
    public static PropertyDirection create(final String lllllllllllllIlIlllIIIllIIIIIIll, final Collection<EnumFacing> lllllllllllllIlIlllIIIllIIIIIIlI) {
        return new PropertyDirection(lllllllllllllIlIlllIIIllIIIIIIll, lllllllllllllIlIlllIIIllIIIIIIlI);
    }
}
