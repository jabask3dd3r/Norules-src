package com.viaversion.viaversion.protocols.protocol1_13_1to1_13.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_13_1to1_13.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.minecraft.entities.*;

public class MetadataRewriter1_13_1To1_13 extends EntityRewriter<Protocol1_13_1To1_13>
{
    @Override
    protected void handleMetadata(final int llllllllllllllIIIIIIIlIIIllIlIIl, final EntityType llllllllllllllIIIIIIIlIIIllIIIll, final Metadata llllllllllllllIIIIIIIlIIIllIIlll, final List<Metadata> llllllllllllllIIIIIIIlIIIllIIllI, final UserConnection llllllllllllllIIIIIIIlIIIllIIlIl) {
        if (llllllllllllllIIIIIIIlIIIllIIlll.metaType() == MetaType1_13.Slot) {
            ((Protocol1_13_1To1_13)this.protocol).getItemRewriter().handleItemToClient((Item)llllllllllllllIIIIIIIlIIIllIIlll.getValue());
        }
        else if (llllllllllllllIIIIIIIlIIIllIIlll.metaType() == MetaType1_13.BlockID) {
            final int llllllllllllllIIIIIIIlIIIllIllII = (int)llllllllllllllIIIIIIIlIIIllIIlll.getValue();
            llllllllllllllIIIIIIIlIIIllIIlll.setValue(((Protocol1_13_1To1_13)this.protocol).getMappingData().getNewBlockStateId(llllllllllllllIIIIIIIlIIIllIllII));
        }
        else if (llllllllllllllIIIIIIIlIIIllIIlll.metaType() == MetaType1_13.PARTICLE) {
            this.rewriteParticle((Particle)llllllllllllllIIIIIIIlIIIllIIlll.getValue());
        }
        if (llllllllllllllIIIIIIIlIIIllIIIll == null) {
            return;
        }
        if (llllllllllllllIIIIIIIlIIIllIIIll.isOrHasParent(Entity1_13Types.EntityType.MINECART_ABSTRACT) && llllllllllllllIIIIIIIlIIIllIIlll.id() == 9) {
            final int llllllllllllllIIIIIIIlIIIllIlIll = (int)llllllllllllllIIIIIIIlIIIllIIlll.getValue();
            llllllllllllllIIIIIIIlIIIllIIlll.setValue(((Protocol1_13_1To1_13)this.protocol).getMappingData().getNewBlockStateId(llllllllllllllIIIIIIIlIIIllIlIll));
        }
        else if (llllllllllllllIIIIIIIlIIIllIIIll.isOrHasParent(Entity1_13Types.EntityType.ABSTRACT_ARROW) && llllllllllllllIIIIIIIlIIIllIIlll.id() >= 7) {
            llllllllllllllIIIIIIIlIIIllIIlll.setId(llllllllllllllIIIIIIIlIIIllIIlll.id() + 1);
        }
    }
    
    @Override
    public EntityType objectTypeFromId(final int llllllllllllllIIIIIIIlIIIlIllIlI) {
        return Entity1_13Types.getTypeFromId(llllllllllllllIIIIIIIlIIIlIllIlI, true);
    }
    
    public MetadataRewriter1_13_1To1_13(final Protocol1_13_1To1_13 llllllllllllllIIIIIIIlIIIllllIIl) {
        super(llllllllllllllIIIIIIIlIIIllllIIl);
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIIIIIIIlIIIlIlllIl) {
        return Entity1_13Types.getTypeFromId(llllllllllllllIIIIIIIlIIIlIlllIl, false);
    }
}
