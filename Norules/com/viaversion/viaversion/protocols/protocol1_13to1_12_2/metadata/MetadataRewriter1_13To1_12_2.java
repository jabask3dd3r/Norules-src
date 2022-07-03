package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.metadata;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.api.type.types.*;

public class MetadataRewriter1_13To1_12_2 extends EntityRewriter<Protocol1_13To1_12_2>
{
    @Override
    public int newEntityId(final int llllllllllllllIIIIIIIlIIIIlIIIII) {
        return EntityTypeRewriter.getNewId(llllllllllllllIIIIIIIlIIIIlIIIII);
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIIIIIIIlIIIIIlllII) {
        return Entity1_13Types.getTypeFromId(llllllllllllllIIIIIIIlIIIIIlllII, false);
    }
    
    @Override
    public EntityType objectTypeFromId(final int llllllllllllllIIIIIIIlIIIIIllIII) {
        return Entity1_13Types.getTypeFromId(llllllllllllllIIIIIIIlIIIIIllIII, true);
    }
    
    @Override
    protected void handleMetadata(final int llllllllllllllIIIIIIIlIIIIllIIlI, final EntityType llllllllllllllIIIIIIIlIIIIllIIIl, final Metadata llllllllllllllIIIIIIIlIIIIllIIII, final List<Metadata> llllllllllllllIIIIIIIlIIIIlIlIlI, final UserConnection llllllllllllllIIIIIIIlIIIIlIlllI) throws Exception {
        if (llllllllllllllIIIIIIIlIIIIllIIII.metaType().typeId() > 4) {
            llllllllllllllIIIIIIIlIIIIllIIII.setMetaType(MetaType1_13.byId(llllllllllllllIIIIIIIlIIIIllIIII.metaType().typeId() + 1));
        }
        else {
            llllllllllllllIIIIIIIlIIIIllIIII.setMetaType(MetaType1_13.byId(llllllllllllllIIIIIIIlIIIIllIIII.metaType().typeId()));
        }
        if (llllllllllllllIIIIIIIlIIIIllIIII.id() == 2) {
            if (llllllllllllllIIIIIIIlIIIIllIIII.getValue() != null && !((String)llllllllllllllIIIIIIIlIIIIllIIII.getValue()).isEmpty()) {
                llllllllllllllIIIIIIIlIIIIllIIII.setTypeAndValue(MetaType1_13.OptChat, ChatRewriter.legacyTextToJson((String)llllllllllllllIIIIIIIlIIIIllIIII.getValue()));
            }
            else {
                llllllllllllllIIIIIIIlIIIIllIIII.setTypeAndValue(MetaType1_13.OptChat, null);
            }
        }
        if (llllllllllllllIIIIIIIlIIIIllIIIl == Entity1_13Types.EntityType.ENDERMAN && llllllllllllllIIIIIIIlIIIIllIIII.id() == 12) {
            final int llllllllllllllIIIIIIIlIIIlIIIlIl = (int)llllllllllllllIIIIIIIlIIIIllIIII.getValue();
            final int llllllllllllllIIIIIIIlIIIlIIIlII = llllllllllllllIIIIIIIlIIIlIIIlIl & 0xFFF;
            final int llllllllllllllIIIIIIIlIIIlIIIIll = llllllllllllllIIIIIIIlIIIlIIIlIl >> 12 & 0xF;
            llllllllllllllIIIIIIIlIIIIllIIII.setValue(llllllllllllllIIIIIIIlIIIlIIIlII << 4 | (llllllllllllllIIIIIIIlIIIlIIIIll & 0xF));
        }
        if (llllllllllllllIIIIIIIlIIIIllIIII.metaType() == MetaType1_13.Slot) {
            llllllllllllllIIIIIIIlIIIIllIIII.setMetaType(MetaType1_13.Slot);
            ((Protocol1_13To1_12_2)this.protocol).getItemRewriter().handleItemToClient((Item)llllllllllllllIIIIIIIlIIIIllIIII.getValue());
        }
        else if (llllllllllllllIIIIIIIlIIIIllIIII.metaType() == MetaType1_13.BlockID) {
            llllllllllllllIIIIIIIlIIIIllIIII.setValue(WorldPackets.toNewId((int)llllllllllllllIIIIIIIlIIIIllIIII.getValue()));
        }
        if (llllllllllllllIIIIIIIlIIIIllIIIl == null) {
            return;
        }
        if (llllllllllllllIIIIIIIlIIIIllIIIl == Entity1_13Types.EntityType.WOLF && llllllllllllllIIIIIIIlIIIIllIIII.id() == 17) {
            llllllllllllllIIIIIIIlIIIIllIIII.setValue(15 - (int)llllllllllllllIIIIIIIlIIIIllIIII.getValue());
        }
        if (llllllllllllllIIIIIIIlIIIIllIIIl.isOrHasParent(Entity1_13Types.EntityType.ZOMBIE) && llllllllllllllIIIIIIIlIIIIllIIII.id() > 14) {
            llllllllllllllIIIIIIIlIIIIllIIII.setId(llllllllllllllIIIIIIIlIIIIllIIII.id() + 1);
        }
        if (llllllllllllllIIIIIIIlIIIIllIIIl.isOrHasParent(Entity1_13Types.EntityType.MINECART_ABSTRACT) && llllllllllllllIIIIIIIlIIIIllIIII.id() == 9) {
            final int llllllllllllllIIIIIIIlIIIlIIIIIl = (int)llllllllllllllIIIIIIIlIIIIllIIII.getValue();
            final int llllllllllllllIIIIIIIlIIIIllllll = (llllllllllllllIIIIIIIlIIIlIIIIIl & 0xFFF) << 4 | (llllllllllllllIIIIIIIlIIIlIIIIIl >> 12 & 0xF);
            final int llllllllllllllIIIIIIIlIIIIlllllI = WorldPackets.toNewId(llllllllllllllIIIIIIIlIIIIllllll);
            llllllllllllllIIIIIIIlIIIIllIIII.setValue(llllllllllllllIIIIIIIlIIIIlllllI);
        }
        if (llllllllllllllIIIIIIIlIIIIllIIIl == Entity1_13Types.EntityType.AREA_EFFECT_CLOUD) {
            if (llllllllllllllIIIIIIIlIIIIllIIII.id() == 9) {
                final int llllllllllllllIIIIIIIlIIIIllllIl = (int)llllllllllllllIIIIIIIlIIIIllIIII.getValue();
                final Metadata llllllllllllllIIIIIIIlIIIIlllIll = this.metaByIndex(10, llllllllllllllIIIIIIIlIIIIlIlIlI);
                final Metadata llllllllllllllIIIIIIIlIIIIlllIlI = this.metaByIndex(11, llllllllllllllIIIIIIIlIIIIlIlIlI);
                final int llllllllllllllIIIIIIIlIIIIlllIII = (int)((llllllllllllllIIIIIIIlIIIIlllIll != null) ? llllllllllllllIIIIIIIlIIIIlllIll.getValue() : 0);
                final int llllllllllllllIIIIIIIlIIIIllIlll = (int)((llllllllllllllIIIIIIIlIIIIlllIlI != null) ? llllllllllllllIIIIIIIlIIIIlllIlI.getValue() : 0);
                final Particle llllllllllllllIIIIIIIlIIIIllIllI = ParticleRewriter.rewriteParticle(llllllllllllllIIIIIIIlIIIIllllIl, new Integer[] { llllllllllllllIIIIIIIlIIIIlllIII, llllllllllllllIIIIIIIlIIIIllIlll });
                if (llllllllllllllIIIIIIIlIIIIllIllI != null && llllllllllllllIIIIIIIlIIIIllIllI.getId() != -1) {
                    llllllllllllllIIIIIIIlIIIIlIlIlI.add(new Metadata(9, MetaType1_13.PARTICLE, llllllllllllllIIIIIIIlIIIIllIllI));
                }
            }
            if (llllllllllllllIIIIIIIlIIIIllIIII.id() >= 9) {
                llllllllllllllIIIIIIIlIIIIlIlIlI.remove(llllllllllllllIIIIIIIlIIIIllIIII);
            }
        }
        if (llllllllllllllIIIIIIIlIIIIllIIII.id() == 0) {
            llllllllllllllIIIIIIIlIIIIllIIII.setValue((byte)((byte)llllllllllllllIIIIIIIlIIIIllIIII.getValue() & 0xFFFFFFEF));
        }
    }
    
    public MetadataRewriter1_13To1_12_2(final Protocol1_13To1_12_2 llllllllllllllIIIIIIIlIIIlllIIIl) {
        super(llllllllllllllIIIIIIIlIIIlllIIIl);
    }
}
