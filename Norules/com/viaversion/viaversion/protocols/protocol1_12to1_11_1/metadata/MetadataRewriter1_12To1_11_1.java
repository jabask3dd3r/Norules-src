package com.viaversion.viaversion.protocols.protocol1_12to1_11_1.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.*;

public class MetadataRewriter1_12To1_11_1 extends EntityRewriter<Protocol1_12To1_11_1>
{
    @Override
    public EntityType typeFromId(final int lllllllllllllIlIIIIlllIIIlIlllll) {
        return Entity1_12Types.getTypeFromId(lllllllllllllIlIIIIlllIIIlIlllll, false);
    }
    
    @Override
    protected void handleMetadata(final int lllllllllllllIlIIIIlllIIIllIlIII, final EntityType lllllllllllllIlIIIIlllIIIllIIIll, final Metadata lllllllllllllIlIIIIlllIIIllIIIlI, final List<Metadata> lllllllllllllIlIIIIlllIIIllIIlIl, final UserConnection lllllllllllllIlIIIIlllIIIllIIlII) {
        if (lllllllllllllIlIIIIlllIIIllIIIlI.getValue() instanceof DataItem) {
            BedRewriter.toClientItem((Item)lllllllllllllIlIIIIlllIIIllIIIlI.getValue());
        }
        if (lllllllllllllIlIIIIlllIIIllIIIll == null) {
            return;
        }
        if (lllllllllllllIlIIIIlllIIIllIIIll == Entity1_12Types.EntityType.EVOCATION_ILLAGER && lllllllllllllIlIIIIlllIIIllIIIlI.id() == 12) {
            lllllllllllllIlIIIIlllIIIllIIIlI.setId(13);
        }
    }
    
    public MetadataRewriter1_12To1_11_1(final Protocol1_12To1_11_1 lllllllllllllIlIIIIlllIIIllIlllI) {
        super(lllllllllllllIlIIIIlllIIIllIlllI);
    }
    
    @Override
    public EntityType objectTypeFromId(final int lllllllllllllIlIIIIlllIIIlIllIll) {
        return Entity1_12Types.getTypeFromId(lllllllllllllIlIIIIlllIIIlIllIll, true);
    }
}
