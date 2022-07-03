package com.viaversion.viaversion.protocols.protocol1_15to1_14_4.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.packets.*;

public class MetadataRewriter1_15To1_14_4 extends EntityRewriter<Protocol1_15To1_14_4>
{
    @Override
    public EntityType typeFromId(final int lllllllllllllIIIIIIIlIlIllIIllIl) {
        return Entity1_15Types.getTypeFromId(lllllllllllllIIIIIIIlIlIllIIllIl);
    }
    
    public MetadataRewriter1_15To1_14_4(final Protocol1_15To1_14_4 lllllllllllllIIIIIIIlIlIlllIlIII) {
        super(lllllllllllllIIIIIIIlIlIlllIlIII);
    }
    
    public void handleMetadata(final int lllllllllllllIIIIIIIlIlIllIlllIl, final EntityType lllllllllllllIIIIIIIlIlIllIlIlll, final Metadata lllllllllllllIIIIIIIlIlIllIllIll, final List<Metadata> lllllllllllllIIIIIIIlIlIllIlIlIl, final UserConnection lllllllllllllIIIIIIIlIlIllIllIIl) throws Exception {
        if (lllllllllllllIIIIIIIlIlIllIllIll.metaType() == MetaType1_14.Slot) {
            ((Protocol1_15To1_14_4)this.protocol).getItemRewriter().handleItemToClient((Item)lllllllllllllIIIIIIIlIlIllIllIll.getValue());
        }
        else if (lllllllllllllIIIIIIIlIlIllIllIll.metaType() == MetaType1_14.BlockID) {
            final int lllllllllllllIIIIIIIlIlIlllIIIII = (int)lllllllllllllIIIIIIIlIlIllIllIll.getValue();
            lllllllllllllIIIIIIIlIlIllIllIll.setValue(((Protocol1_15To1_14_4)this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIIIIIlIlIlllIIIII));
        }
        else if (lllllllllllllIIIIIIIlIlIllIllIll.metaType() == MetaType1_13.PARTICLE) {
            this.rewriteParticle((Particle)lllllllllllllIIIIIIIlIlIllIllIll.getValue());
        }
        if (lllllllllllllIIIIIIIlIlIllIlIlll == null) {
            return;
        }
        if (lllllllllllllIIIIIIIlIlIllIlIlll.isOrHasParent(Entity1_15Types.MINECART_ABSTRACT) && lllllllllllllIIIIIIIlIlIllIllIll.id() == 10) {
            final int lllllllllllllIIIIIIIlIlIllIlllll = (int)lllllllllllllIIIIIIIlIlIllIllIll.getValue();
            lllllllllllllIIIIIIIlIlIllIllIll.setValue(((Protocol1_15To1_14_4)this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIIIIIlIlIllIlllll));
        }
        if (lllllllllllllIIIIIIIlIlIllIllIll.id() > 11 && lllllllllllllIIIIIIIlIlIllIlIlll.isOrHasParent(Entity1_15Types.LIVINGENTITY)) {
            lllllllllllllIIIIIIIlIlIllIllIll.setId(lllllllllllllIIIIIIIlIlIllIllIll.id() + 1);
        }
        if (lllllllllllllIIIIIIIlIlIllIlIlll.isOrHasParent(Entity1_15Types.WOLF)) {
            if (lllllllllllllIIIIIIIlIlIllIllIll.id() == 18) {
                lllllllllllllIIIIIIIlIlIllIlIlIl.remove(lllllllllllllIIIIIIIlIlIllIllIll);
            }
            else if (lllllllllllllIIIIIIIlIlIllIllIll.id() > 18) {
                lllllllllllllIIIIIIIlIlIllIllIll.setId(lllllllllllllIIIIIIIlIlIllIllIll.id() - 1);
            }
        }
    }
    
    @Override
    public int newEntityId(final int lllllllllllllIIIIIIIlIlIllIlIIII) {
        return EntityPackets.getNewEntityId(lllllllllllllIIIIIIIlIlIllIlIIII);
    }
}
