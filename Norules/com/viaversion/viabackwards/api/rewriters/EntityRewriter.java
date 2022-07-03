package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;

public abstract class EntityRewriter<T extends BackwardsProtocol> extends EntityRewriterBase<T>
{
    public PacketHandler getSpawnTrackerWithDataHandler(final EntityType lllllllllllllIlIlIIIllIIlIIllllI) {
        final EntityType lllllllllllllIlIlIIIllIIIllIlIII;
        int lllllllllllllIlIlIIIllIIIllIllII;
        return lllllllllllllIlIlIIIllIIIllIlIIl -> {
            lllllllllllllIlIlIIIllIIIllIlIII = this.setOldEntityId(lllllllllllllIlIlIIIllIIIllIlIIl);
            if (lllllllllllllIlIlIIIllIIIllIlIII == lllllllllllllIlIlIIIllIIlIIllllI) {
                lllllllllllllIlIlIIIllIIIllIllII = lllllllllllllIlIlIIIllIIIllIlIIl.get((Type<Integer>)Type.INT, 0);
                lllllllllllllIlIlIIIllIIIllIlIIl.set(Type.INT, 0, this.protocol.getMappingData().getNewBlockStateId(lllllllllllllIlIlIIIllIIIllIllII));
            }
        };
    }
    
    private EntityType setOldEntityId(final PacketWrapper lllllllllllllIlIlIIIllIIIllllllI) throws Exception {
        final int lllllllllllllIlIlIIIllIIIlllllII = lllllllllllllIlIlIIIllIIIllllllI.get((Type<Integer>)Type.VAR_INT, 1);
        final EntityType lllllllllllllIlIlIIIllIIIllllIlI = this.typeFromId(lllllllllllllIlIlIIIllIIIlllllII);
        this.tracker(lllllllllllllIlIlIIIllIIIllllllI.user()).addEntity(lllllllllllllIlIlIIIllIIIllllllI.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllIlIlIIIllIIIllllIlI);
        final int lllllllllllllIlIlIIIllIIIllllIIl = this.newEntityId(lllllllllllllIlIlIIIllIIIllllIlI.getId());
        if (lllllllllllllIlIlIIIllIIIlllllII != lllllllllllllIlIlIIIllIIIllllIIl) {
            lllllllllllllIlIlIIIllIIIllllllI.set(Type.VAR_INT, 1, lllllllllllllIlIlIIIllIIIllllIIl);
        }
        return lllllllllllllIlIlIIIllIIIllllIlI;
    }
    
    protected EntityRewriter(final T lllllllllllllIlIlIIIllIIllIIIllI) {
        this(lllllllllllllIlIlIIIllIIllIIIllI, MetaType1_14.OptChat, MetaType1_14.Boolean);
    }
    
    public void registerSpawnTracker(final ClientboundPacketType lllllllllllllIlIlIIIllIIlIIIllII) {
        this.protocol.registerClientbound(lllllllllllllIlIlIIIllIIlIIIllII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllIIlIIIIlIllIlIllIlI -> EntityRewriter.this.setOldEntityId(lllllllllllllIIlIIIIlIllIlIllIlI));
            }
        });
    }
    
    protected EntityRewriter(final T lllllllllllllIlIlIIIllIIlIllllII, final MetaType lllllllllllllIlIlIIIllIIlIlllIll, final MetaType lllllllllllllIlIlIIIllIIlIlllllI) {
        super(lllllllllllllIlIlIIIllIIlIllllII, lllllllllllllIlIlIIIllIIlIlllIll, 2, lllllllllllllIlIlIIIllIIlIlllllI, 3);
    }
    
    @Override
    public void registerTrackerWithData(final ClientboundPacketType lllllllllllllIlIlIIIllIIlIlIllll, final EntityType lllllllllllllIlIlIIIllIIlIlIIlll) {
        this.protocol.registerClientbound(lllllllllllllIlIlIIIllIIlIlIllll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.handler(EntityRewriter.this.getSpawnTrackerWithDataHandler(lllllllllllllIlIlIIIllIIlIlIIlll));
            }
        });
    }
}
