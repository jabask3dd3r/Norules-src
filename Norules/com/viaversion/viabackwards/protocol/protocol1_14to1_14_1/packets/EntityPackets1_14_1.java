package com.viaversion.viabackwards.protocol.protocol1_14to1_14_1.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_14to1_14_1.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_14_1 extends LegacyEntityRewriter<Protocol1_14To1_14_1>
{
    @Override
    protected void registerRewrites() {
        this.filter().type(Entity1_14Types.VILLAGER).cancel(15);
        this.filter().type(Entity1_14Types.VILLAGER).index(16).toIndex(15);
        this.filter().type(Entity1_14Types.WANDERING_TRADER).cancel(15);
    }
    
    @Override
    protected void registerPackets() {
        this.registerTracker(ClientboundPackets1_14.SPAWN_EXPERIENCE_ORB, Entity1_14Types.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_14.SPAWN_GLOBAL_ENTITY, Entity1_14Types.LIGHTNING_BOLT);
        this.registerTracker(ClientboundPackets1_14.SPAWN_PAINTING, Entity1_14Types.PAINTING);
        this.registerTracker(ClientboundPackets1_14.SPAWN_PLAYER, Entity1_14Types.PLAYER);
        this.registerTracker(ClientboundPackets1_14.JOIN_GAME, Entity1_14Types.PLAYER, Type.INT);
        this.registerRemoveEntities(ClientboundPackets1_14.DESTROY_ENTITIES);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.handler(EntityRewriterBase.this.getTrackerHandler());
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SPAWN_MOB, new PacketRemapper() {
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
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_14.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlIlIlIllllIIIIlI) throws Exception {
                        final int lllllllllllllllIlIlIlIllllIIIllI = lllllllllllllllIlIlIlIllllIIIIlI.get((Type<Integer>)Type.VAR_INT, 0);
                        final int lllllllllllllllIlIlIlIllllIIIlIl = lllllllllllllllIlIlIlIllllIIIIlI.get((Type<Integer>)Type.VAR_INT, 1);
                        EntityPackets1_14_1.this.tracker(lllllllllllllllIlIlIlIllllIIIIlI.user()).addEntity(lllllllllllllllIlIlIlIllllIIIllI, Entity1_14Types.getTypeFromId(lllllllllllllllIlIlIlIllllIIIlIl));
                        final List<Metadata> lllllllllllllllIlIlIlIllllIIIlII = lllllllllllllllIlIlIlIllllIIIIlI.get(Types1_14.METADATA_LIST, 0);
                        EntityPackets1_14_1.this.handleMetadata(lllllllllllllllIlIlIlIllllIIIllI, lllllllllllllllIlIlIlIllllIIIlII, lllllllllllllllIlIlIlIllllIIIIlI.user());
                    }
                });
            }
        });
        this.registerMetadataRewriter(ClientboundPackets1_14.ENTITY_METADATA, Types1_14.METADATA_LIST);
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIIIIIlIlllIIlIllII) {
        return Entity1_14Types.getTypeFromId(llllllllllllllIIIIIlIlllIIlIllII);
    }
    
    public EntityPackets1_14_1(final Protocol1_14To1_14_1 llllllllllllllIIIIIlIlllIIllIlIl) {
        super(llllllllllllllIIIIIlIlllIIllIlIl);
    }
}
