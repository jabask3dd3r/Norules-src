package de.gerrygames.viarewind.protocol.protocol1_8to1_9.metadata;

import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata.*;
import java.util.*;

public class MetaIndex1_8to1_9
{
    private static final /* synthetic */ HashMap<Pair<Entity1_10Types.EntityType, Integer>, MetaIndex> metadataRewrites;
    
    private static Optional<MetaIndex> getIndex(final Entity1_10Types.EntityType llllllllllllllIIIIlIlIIlIIIIlllI, final int llllllllllllllIIIIlIlIIlIIIIllIl) {
        final Pair llllllllllllllIIIIlIlIIlIIIIllll = new Pair((X)llllllllllllllIIIIlIlIIlIIIIlllI, (Y)llllllllllllllIIIIlIlIIlIIIIllIl);
        if (MetaIndex1_8to1_9.metadataRewrites.containsKey(llllllllllllllIIIIlIlIIlIIIIllll)) {
            return Optional.of(MetaIndex1_8to1_9.metadataRewrites.get(llllllllllllllIIIIlIlIIlIIIIllll));
        }
        return Optional.empty();
    }
    
    public static MetaIndex searchIndex(final Entity1_10Types.EntityType llllllllllllllIIIIlIlIIlIIIIIllI, final int llllllllllllllIIIIlIlIIlIIIIIlIl) {
        Entity1_10Types.EntityType llllllllllllllIIIIlIlIIlIIIIIlII = llllllllllllllIIIIlIlIIlIIIIIllI;
        do {
            final Optional<MetaIndex> llllllllllllllIIIIlIlIIlIIIIIlll = getIndex(llllllllllllllIIIIlIlIIlIIIIIlII, llllllllllllllIIIIlIlIIlIIIIIlIl);
            if (llllllllllllllIIIIlIlIIlIIIIIlll.isPresent()) {
                return llllllllllllllIIIIlIlIIlIIIIIlll.get();
            }
            llllllllllllllIIIIlIlIIlIIIIIlII = llllllllllllllIIIIlIlIIlIIIIIlII.getParent();
        } while (llllllllllllllIIIIlIlIIlIIIIIlII != null);
        return null;
    }
    
    static {
        metadataRewrites = new HashMap<Pair<Entity1_10Types.EntityType, Integer>, MetaIndex>();
        final boolean llllllllllllllIIIIlIlIIIlllllIlI = (Object)MetaIndex.values();
        final short llllllllllllllIIIIlIlIIIlllllIIl = (short)llllllllllllllIIIIlIlIIIlllllIlI.length;
        for (Exception llllllllllllllIIIIlIlIIIlllllIII = (Exception)0; llllllllllllllIIIIlIlIIIlllllIII < llllllllllllllIIIIlIlIIIlllllIIl; ++llllllllllllllIIIIlIlIIIlllllIII) {
            final MetaIndex llllllllllllllIIIIlIlIIIlllllIll = llllllllllllllIIIIlIlIIIlllllIlI[llllllllllllllIIIIlIlIIIlllllIII];
            MetaIndex1_8to1_9.metadataRewrites.put(new Pair<Entity1_10Types.EntityType, Integer>(llllllllllllllIIIIlIlIIIlllllIll.getClazz(), llllllllllllllIIIIlIlIIIlllllIll.getNewIndex()), llllllllllllllIIIIlIlIIIlllllIll);
        }
    }
}
