package com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.*;

public class MetadataRewriter1_16_2To1_16_1 extends EntityRewriter<Protocol1_16_2To1_16_1>
{
    public MetadataRewriter1_16_2To1_16_1(final Protocol1_16_2To1_16_1 llllllllllllllllIlllIIIllllIlIII) {
        super(llllllllllllllllIlllIIIllllIlIII);
        this.mapTypes(Entity1_16Types.values(), Entity1_16_2Types.class);
    }
    
    public void handleMetadata(final int llllllllllllllllIlllIIIlllIllllI, final EntityType llllllllllllllllIlllIIIlllIlllIl, final Metadata llllllllllllllllIlllIIIlllIlIlll, final List<Metadata> llllllllllllllllIlllIIIlllIllIll, final UserConnection llllllllllllllllIlllIIIlllIllIlI) throws Exception {
        if (llllllllllllllllIlllIIIlllIlIlll.metaType() == MetaType1_16.ITEM) {
            ((Protocol1_16_2To1_16_1)this.protocol).getItemRewriter().handleItemToClient((Item)llllllllllllllllIlllIIIlllIlIlll.getValue());
        }
        else if (llllllllllllllllIlllIIIlllIlIlll.metaType() == MetaType1_16.BLOCK_STATE) {
            final int llllllllllllllllIlllIIIllllIIIIl = (int)llllllllllllllllIlllIIIlllIlIlll.getValue();
            llllllllllllllllIlllIIIlllIlIlll.setValue(((Protocol1_16_2To1_16_1)this.protocol).getMappingData().getNewBlockStateId(llllllllllllllllIlllIIIllllIIIIl));
        }
        else if (llllllllllllllllIlllIIIlllIlIlll.metaType() == MetaType1_16.PARTICLE) {
            this.rewriteParticle((Particle)llllllllllllllllIlllIIIlllIlIlll.getValue());
        }
        if (llllllllllllllllIlllIIIlllIlllIl == null) {
            return;
        }
        if (llllllllllllllllIlllIIIlllIlllIl.isOrHasParent(Entity1_16_2Types.MINECART_ABSTRACT) && llllllllllllllllIlllIIIlllIlIlll.id() == 10) {
            final int llllllllllllllllIlllIIIllllIIIII = (int)llllllllllllllllIlllIIIlllIlIlll.getValue();
            llllllllllllllllIlllIIIlllIlIlll.setValue(((Protocol1_16_2To1_16_1)this.protocol).getMappingData().getNewBlockStateId(llllllllllllllllIlllIIIllllIIIII));
        }
        if (llllllllllllllllIlllIIIlllIlllIl.isOrHasParent(Entity1_16_2Types.ABSTRACT_PIGLIN)) {
            if (llllllllllllllllIlllIIIlllIlIlll.id() == 15) {
                llllllllllllllllIlllIIIlllIlIlll.setId(16);
            }
            else if (llllllllllllllllIlllIIIlllIlIlll.id() == 16) {
                llllllllllllllllIlllIIIlllIlIlll.setId(15);
            }
        }
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllllIlllIIIlllIlIIll) {
        return Entity1_16_2Types.getTypeFromId(llllllllllllllllIlllIIIlllIlIIll);
    }
}
