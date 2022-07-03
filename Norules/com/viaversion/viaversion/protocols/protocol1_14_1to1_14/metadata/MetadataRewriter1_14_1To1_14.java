package com.viaversion.viaversion.protocols.protocol1_14_1to1_14.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_14_1to1_14.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.entities.*;

public class MetadataRewriter1_14_1To1_14 extends EntityRewriter<Protocol1_14_1To1_14>
{
    public void handleMetadata(final int lllllllllllllIlllllIIlIlIIlIIIIl, final EntityType lllllllllllllIlllllIIlIlIIlIIIII, final Metadata lllllllllllllIlllllIIlIlIIIlllll, final List<Metadata> lllllllllllllIlllllIIlIlIIIllllI, final UserConnection lllllllllllllIlllllIIlIlIIIlllIl) {
        if (lllllllllllllIlllllIIlIlIIlIIIII == null) {
            return;
        }
        if ((lllllllllllllIlllllIIlIlIIlIIIII == Entity1_14Types.VILLAGER || lllllllllllllIlllllIIlIlIIlIIIII == Entity1_14Types.WANDERING_TRADER) && lllllllllllllIlllllIIlIlIIIlllll.id() >= 15) {
            lllllllllllllIlllllIIlIlIIIlllll.setId(lllllllllllllIlllllIIlIlIIIlllll.id() + 1);
        }
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIlllllIIlIlIIIllIII) {
        return Entity1_14Types.getTypeFromId(lllllllllllllIlllllIIlIlIIIllIII);
    }
    
    public MetadataRewriter1_14_1To1_14(final Protocol1_14_1To1_14 lllllllllllllIlllllIIlIlIIlIIlll) {
        super(lllllllllllllIlllllIIlIlIIlIIlll);
    }
}
