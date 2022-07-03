package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data;

import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import java.lang.reflect.*;

public class EntityTypeMapping
{
    private static final /* synthetic */ Int2IntMap TYPES;
    
    static {
        (TYPES = new Int2IntOpenHashMap()).defaultReturnValue(-1);
        try {
            final Field lllllllllllllIlIllIlllllIllllIll = EntityTypeRewriter.class.getDeclaredField("ENTITY_TYPES");
            lllllllllllllIlIllIlllllIllllIll.setAccessible(true);
            final Int2IntMap lllllllllllllIlIllIlllllIllllIlI = (Int2IntMap)lllllllllllllIlIllIlllllIllllIll.get(null);
            for (final Int2IntMap.Entry lllllllllllllIlIllIlllllIlllllII : lllllllllllllIlIllIlllllIllllIlI.int2IntEntrySet()) {
                EntityTypeMapping.TYPES.put(lllllllllllllIlIllIlllllIlllllII.getIntValue(), lllllllllllllIlIllIlllllIlllllII.getIntKey());
            }
        }
        catch (NoSuchFieldException | IllegalAccessException ex2) {
            final ReflectiveOperationException ex;
            final ReflectiveOperationException lllllllllllllIlIllIlllllIllllIIl = ex;
            lllllllllllllIlIllIlllllIllllIIl.printStackTrace();
        }
    }
    
    public static int getOldId(final int lllllllllllllIlIllIllllllIIIIIlI) {
        return EntityTypeMapping.TYPES.get(lllllllllllllIlIllIllllllIIIIIlI);
    }
}
