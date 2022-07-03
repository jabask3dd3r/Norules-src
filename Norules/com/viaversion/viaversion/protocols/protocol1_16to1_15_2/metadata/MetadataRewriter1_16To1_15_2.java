package com.viaversion.viaversion.protocols.protocol1_16to1_15_2.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.minecraft.entities.*;

public class MetadataRewriter1_16To1_15_2 extends EntityRewriter<Protocol1_16To1_15_2>
{
    public void handleMetadata(final int lllllllllllllIIIlIIIllllIIlllllI, final EntityType lllllllllllllIIIlIIIllllIIllllIl, final Metadata lllllllllllllIIIlIIIllllIIllllII, final List<Metadata> lllllllllllllIIIlIIIllllIIllIllI, final UserConnection lllllllllllllIIIlIIIllllIIlllIlI) throws Exception {
        lllllllllllllIIIlIIIllllIIllllII.setMetaType(MetaType1_16.byId(lllllllllllllIIIlIIIllllIIllllII.metaType().typeId()));
        if (lllllllllllllIIIlIIIllllIIllllII.metaType() == MetaType1_16.ITEM) {
            ((Protocol1_16To1_15_2)this.protocol).getItemRewriter().handleItemToClient((Item)lllllllllllllIIIlIIIllllIIllllII.getValue());
        }
        else if (lllllllllllllIIIlIIIllllIIllllII.metaType() == MetaType1_16.BLOCK_STATE) {
            final int lllllllllllllIIIlIIIllllIlIIIIIl = (int)lllllllllllllIIIlIIIllllIIllllII.getValue();
            lllllllllllllIIIlIIIllllIIllllII.setValue(((Protocol1_16To1_15_2)this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIlIIIllllIlIIIIIl));
        }
        else if (lllllllllllllIIIlIIIllllIIllllII.metaType() == MetaType1_16.PARTICLE) {
            this.rewriteParticle((Particle)lllllllllllllIIIlIIIllllIIllllII.getValue());
        }
        if (lllllllllllllIIIlIIIllllIIllllIl == null) {
            return;
        }
        if (lllllllllllllIIIlIIIllllIIllllIl.isOrHasParent(Entity1_16Types.MINECART_ABSTRACT) && lllllllllllllIIIlIIIllllIIllllII.id() == 10) {
            final int lllllllllllllIIIlIIIllllIlIIIIII = (int)lllllllllllllIIIlIIIllllIIllllII.getValue();
            lllllllllllllIIIlIIIllllIIllllII.setValue(((Protocol1_16To1_15_2)this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIlIIIllllIlIIIIII));
        }
        if (lllllllllllllIIIlIIIllllIIllllIl.isOrHasParent(Entity1_16Types.ABSTRACT_ARROW)) {
            if (lllllllllllllIIIlIIIllllIIllllII.id() == 8) {
                lllllllllllllIIIlIIIllllIIllIllI.remove(lllllllllllllIIIlIIIllllIIllllII);
            }
            else if (lllllllllllllIIIlIIIllllIIllllII.id() > 8) {
                lllllllllllllIIIlIIIllllIIllllII.setId(lllllllllllllIIIlIIIllllIIllllII.id() - 1);
            }
        }
    }
    
    public MetadataRewriter1_16To1_15_2(final Protocol1_16To1_15_2 lllllllllllllIIIlIIIllllIlIIIlll) {
        super(lllllllllllllIIIlIIIllllIlIIIlll);
        this.mapEntityType(Entity1_15Types.ZOMBIE_PIGMAN, Entity1_16Types.ZOMBIFIED_PIGLIN);
        this.mapTypes(Entity1_15Types.values(), Entity1_16Types.class);
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIIIlIIIllllIIllIIlI) {
        return Entity1_16Types.getTypeFromId(lllllllllllllIIIlIIIllllIIllIIlI);
    }
}
