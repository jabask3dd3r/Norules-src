package com.viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_13to1_13_1.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.type.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_13_1 extends LegacyEntityRewriter<Protocol1_13To1_13_1>
{
    public EntityPackets1_13_1(final Protocol1_13To1_13_1 llllllllllllllIIIIIlIlIIllllllII) {
        super(llllllllllllllIIIIIlIlIIllllllII);
    }
    
    @Override
    protected EntityType getObjectTypeFromId(final int llllllllllllllIIIIIlIlIIlllIllll) {
        return Entity1_13Types.getTypeFromId(llllllllllllllIIIIIlIlIIlllIllll, true);
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIIIIIlIlIIllllIIll) {
        return Entity1_13Types.getTypeFromId(llllllllllllllIIIIIlIlIIllllIIll, false);
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.BYTE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIIIlIllIIIIIIIl) throws Exception {
                        final int lllllllllllllIIIIIIIlIllIIIIIlIl = lllllllllllllIIIIIIIlIllIIIIIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        final byte lllllllllllllIIIIIIIlIllIIIIIlII = lllllllllllllIIIIIIIlIllIIIIIIIl.get((Type<Byte>)Type.BYTE, 0);
                        final Entity1_13Types.EntityType lllllllllllllIIIIIIIlIllIIIIIIll = Entity1_13Types.getTypeFromId(lllllllllllllIIIIIIIlIllIIIIIlII, true);
                        if (lllllllllllllIIIIIIIlIllIIIIIIll == null) {
                            ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Could not find 1.13 entity type ").append(lllllllllllllIIIIIIIlIllIIIIIlII)));
                            return;
                        }
                        if (lllllllllllllIIIIIIIlIllIIIIIIll.is(Entity1_13Types.EntityType.FALLING_BLOCK)) {
                            final int lllllllllllllIIIIIIIlIllIIIIlIII = lllllllllllllIIIIIIIlIllIIIIIIIl.get((Type<Integer>)Type.INT, 0);
                            lllllllllllllIIIIIIIlIllIIIIIIIl.set(Type.INT, 0, ((Protocol1_13To1_13_1)EntityPackets1_13_1.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIIIIIlIllIIIIlIII));
                        }
                        EntityPackets1_13_1.this.tracker(lllllllllllllIIIIIIIlIllIIIIIIIl.user()).addEntity(lllllllllllllIIIIIIIlIllIIIIIlIl, lllllllllllllIIIIIIIlIllIIIIIIll);
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_13.SPAWN_EXPERIENCE_ORB, Entity1_13Types.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_13.SPAWN_GLOBAL_ENTITY, Entity1_13Types.EntityType.LIGHTNING_BOLT);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.SPAWN_MOB, new PacketRemapper() {
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
                this.map(Types1_13.METADATA_LIST);
                this.handler(EntityRewriterBase.this.getTrackerHandler());
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIIlllIIIlIllII) throws Exception {
                        final List<Metadata> lllllllllllllIIIIlIIlllIIIlIlIll = lllllllllllllIIIIlIIlllIIIlIllII.get(Types1_13.METADATA_LIST, 0);
                        EntityPackets1_13_1.this.handleMetadata(lllllllllllllIIIIlIIlllIIIlIllII.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllIIIIlIIlllIIIlIlIll, lllllllllllllIIIIlIIlllIIIlIllII.user());
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_13.METADATA_LIST);
                this.handler(LegacyEntityRewriter.this.getTrackerAndMetaHandler(Types1_13.METADATA_LIST, Entity1_13Types.EntityType.PLAYER));
            }
        });
        this.registerTracker(ClientboundPackets1_13.SPAWN_PAINTING, Entity1_13Types.EntityType.PAINTING);
        this.registerJoinGame(ClientboundPackets1_13.JOIN_GAME, Entity1_13Types.EntityType.PLAYER);
        this.registerRespawn(ClientboundPackets1_13.RESPAWN);
        this.registerRemoveEntities(ClientboundPackets1_13.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_13.ENTITY_METADATA, Types1_13.METADATA_LIST);
    }
    
    @Override
    protected void registerRewrites() {
        int llllllllllllllIIIIIlIlIIlllIIIII;
        this.filter().handler((llllllllllllllIIIIIlIlIIllIllllI, llllllllllllllIIIIIlIlIIllIlllIl) -> {
            if (llllllllllllllIIIIIlIlIIllIlllIl.metaType() == MetaType1_13.Slot) {
                ((Protocol1_13To1_13_1)this.protocol).getItemRewriter().handleItemToClient((Item)llllllllllllllIIIIIlIlIIllIlllIl.getValue());
            }
            else if (llllllllllllllIIIIIlIlIIllIlllIl.metaType() == MetaType1_13.BlockID) {
                llllllllllllllIIIIIlIlIIlllIIIII = (int)llllllllllllllIIIIIlIlIIllIlllIl.getValue();
                llllllllllllllIIIIIlIlIIllIlllIl.setValue(((Protocol1_13To1_13_1)this.protocol).getMappingData().getNewBlockStateId(llllllllllllllIIIIIlIlIIlllIIIII));
            }
            else if (llllllllllllllIIIIIlIlIIllIlllIl.metaType() == MetaType1_13.PARTICLE) {
                this.rewriteParticle((Particle)llllllllllllllIIIIIlIlIIllIlllIl.getValue());
            }
            return;
        });
        this.filter().filterFamily(Entity1_13Types.EntityType.ABSTRACT_ARROW).cancel(7);
        this.filter().type(Entity1_13Types.EntityType.SPECTRAL_ARROW).index(8).toIndex(7);
        this.filter().type(Entity1_13Types.EntityType.TRIDENT).index(8).toIndex(7);
        final int llllllllllllllIIIIIlIlIIlllIIlll;
        this.filter().filterFamily(Entity1_13Types.EntityType.MINECART_ABSTRACT).index(9).handler((llllllllllllllIIIIIlIlIIlllIlIIl, llllllllllllllIIIIIlIlIIlllIIlIl) -> {
            llllllllllllllIIIIIlIlIIlllIIlll = (int)llllllllllllllIIIIIlIlIIlllIIlIl.getValue();
            llllllllllllllIIIIIlIlIIlllIIlIl.setValue(((Protocol1_13To1_13_1)this.protocol).getMappingData().getNewBlockStateId(llllllllllllllIIIIIlIlIIlllIIlll));
        });
    }
}
