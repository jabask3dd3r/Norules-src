package com.viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_14_4to1_15.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.types.version.*;
import java.util.*;
import com.viaversion.viabackwards.protocol.protocol1_14_4to1_15.data.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viabackwards.api.entities.storage.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_15 extends EntityRewriter<Protocol1_14_4To1_15>
{
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.UPDATE_HEALTH, new PacketRemapper() {
            @Override
            public void registerMap() {
                final float lllllllllllllIllIIllIllIIIIIllll;
                PacketWrapper lllllllllllllIllIIllIllIIIIIlllI;
                this.handler(lllllllllllllIllIIllIllIIIIIllIl -> {
                    lllllllllllllIllIIllIllIIIIIllll = lllllllllllllIllIIllIllIIIIIllIl.passthrough((Type<Float>)Type.FLOAT);
                    if (lllllllllllllIllIIllIllIIIIIllll <= 0.0f) {
                        if (!(!lllllllllllllIllIIllIllIIIIIllIl.user().get(ImmediateRespawn.class).isImmediateRespawn())) {
                            lllllllllllllIllIIllIllIIIIIlllI = lllllllllllllIllIIllIllIIIIIllIl.create(ServerboundPackets1_14.CLIENT_STATUS);
                            lllllllllllllIllIIllIllIIIIIlllI.write(Type.VAR_INT, 0);
                            lllllllllllllIllIIllIllIIIIIlllI.sendToServer(Protocol1_14_4To1_15.class);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.GAME_EVENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.FLOAT);
                this.handler(lllllllllllllIIIlIIllIIlIlllIIIl -> {
                    if (lllllllllllllIIIlIIllIIlIlllIIIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 11) {
                        lllllllllllllIIIlIIllIIlIlllIIIl.user().get(ImmediateRespawn.class).setImmediateRespawn(lllllllllllllIIIlIIllIIlIlllIIIl.get((Type<Float>)Type.FLOAT, 0) == 1.0f);
                    }
                });
            }
        });
        this.registerTrackerWithData(ClientboundPackets1_15.SPAWN_ENTITY, Entity1_15Types.FALLING_BLOCK);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.SPAWN_MOB, new PacketRemapper() {
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
                this.handler(lllllllllllllIIlllIIllIIIIIlIlIl -> lllllllllllllIIlllIIllIIIIIlIlIl.write((Type<ArrayList>)Types1_14.METADATA_LIST, new ArrayList()));
                final int lllllllllllllIIlllIIllIIIIIlllII;
                final EntityType lllllllllllllIIlllIIllIIIIIllIll;
                this.handler(lllllllllllllIIlllIIllIIIIIllIIl -> {
                    lllllllllllllIIlllIIllIIIIIlllII = lllllllllllllIIlllIIllIIIIIllIIl.get((Type<Integer>)Type.VAR_INT, 1);
                    lllllllllllllIIlllIIllIIIIIllIll = Entity1_15Types.getTypeFromId(lllllllllllllIIlllIIllIIIIIlllII);
                    ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)EntityPackets1_15.this).tracker(lllllllllllllIIlllIIllIIIIIllIIl.user()).addEntity(lllllllllllllIIlllIIllIIIIIllIIl.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllIIlllIIllIIIIIllIll);
                    lllllllllllllIIlllIIllIIIIIllIIl.set(Type.VAR_INT, 1, EntityTypeMapping.getOldEntityId(lllllllllllllIIlllIIllIIIIIlllII));
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.LONG, Type.NOTHING);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.map(Type.LONG, Type.NOTHING);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                this.handler(EntityRewriterBase.this.getTrackerHandler(Entity1_15Types.PLAYER, Type.INT));
                final boolean llllllllllllllllllIIlIIIlIIlIlII;
                this.handler(llllllllllllllllllIIlIIIlIIlIlIl -> {
                    llllllllllllllllllIIlIIIlIIlIlII = !llllllllllllllllllIIlIIIlIIlIlIl.read((Type<Boolean>)Type.BOOLEAN);
                    llllllllllllllllllIIlIIIlIIlIlIl.user().get(ImmediateRespawn.class).setImmediateRespawn(llllllllllllllllllIIlIIIlIIlIlII);
                });
            }
        });
        this.registerTracker(ClientboundPackets1_15.SPAWN_EXPERIENCE_ORB, Entity1_15Types.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_15.SPAWN_GLOBAL_ENTITY, Entity1_15Types.LIGHTNING_BOLT);
        this.registerTracker(ClientboundPackets1_15.SPAWN_PAINTING, Entity1_15Types.PAINTING);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.handler(llllllllllllllllIlllllllllIlIIII -> llllllllllllllllIlllllllllIlIIII.write((Type<ArrayList>)Types1_14.METADATA_LIST, new ArrayList()));
                this.handler(EntityRewriterBase.this.getTrackerHandler(Entity1_15Types.PLAYER, Type.VAR_INT));
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_15.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_15.ENTITY_METADATA, Types1_14.METADATA_LIST);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                final int lllllllllllllIIIlllIIIIllllIIIlI;
                final EntityType lllllllllllllIIIlllIIIIllllIIIIl;
                int lllllllllllllIIIlllIIIIlllIlllll;
                int lllllllllllllIIIlllIIIIllllIIIII;
                int lllllllllllllIIIlllIIIIllllIIlIl;
                String lllllllllllllIIIlllIIIIllllIIllI;
                int lllllllllllllIIIlllIIIIllllIlIIl;
                int lllllllllllllIIIlllIIIIllllIlIlI;
                int lllllllllllllIIIlllIIIIllllIIlll;
                int lllllllllllllIIIlllIIIIllllIlIII;
                this.handler(lllllllllllllIIIlllIIIIlllIlllIl -> {
                    lllllllllllllIIIlllIIIIllllIIIlI = lllllllllllllIIIlllIIIIlllIlllIl.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIIIlllIIIIllllIIIIl = ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)EntityPackets1_15.this).tracker(lllllllllllllIIIlllIIIIlllIlllIl.user()).entityType(lllllllllllllIIIlllIIIIllllIIIlI);
                    if (lllllllllllllIIIlllIIIIllllIIIIl == Entity1_15Types.BEE) {
                        for (lllllllllllllIIIlllIIIIllllIIIII = (lllllllllllllIIIlllIIIIlllIlllll = lllllllllllllIIIlllIIIIlllIlllIl.get((Type<Integer>)Type.INT, 0)), lllllllllllllIIIlllIIIIllllIIlIl = 0; lllllllllllllIIIlllIIIIllllIIlIl < lllllllllllllIIIlllIIIIllllIIIII; ++lllllllllllllIIIlllIIIIllllIIlIl) {
                            lllllllllllllIIIlllIIIIllllIIllI = lllllllllllllIIIlllIIIIlllIlllIl.read(Type.STRING);
                            if (lllllllllllllIIIlllIIIIllllIIllI.equals("generic.flyingSpeed")) {
                                --lllllllllllllIIIlllIIIIlllIlllll;
                                lllllllllllllIIIlllIIIIlllIlllIl.read((Type<Object>)Type.DOUBLE);
                                for (lllllllllllllIIIlllIIIIllllIlIIl = lllllllllllllIIIlllIIIIlllIlllIl.read((Type<Integer>)Type.VAR_INT), lllllllllllllIIIlllIIIIllllIlIlI = 0; lllllllllllllIIIlllIIIIllllIlIlI < lllllllllllllIIIlllIIIIllllIlIIl; ++lllllllllllllIIIlllIIIIllllIlIlI) {
                                    lllllllllllllIIIlllIIIIlllIlllIl.read(Type.UUID);
                                    lllllllllllllIIIlllIIIIlllIlllIl.read((Type<Object>)Type.DOUBLE);
                                    lllllllllllllIIIlllIIIIlllIlllIl.read((Type<Object>)Type.BYTE);
                                }
                            }
                            else {
                                lllllllllllllIIIlllIIIIlllIlllIl.write(Type.STRING, lllllllllllllIIIlllIIIIllllIIllI);
                                lllllllllllllIIIlllIIIIlllIlllIl.passthrough((Type<Object>)Type.DOUBLE);
                                for (lllllllllllllIIIlllIIIIllllIIlll = lllllllllllllIIIlllIIIIlllIlllIl.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIIlllIIIIllllIlIII = 0; lllllllllllllIIIlllIIIIllllIlIII < lllllllllllllIIIlllIIIIllllIIlll; ++lllllllllllllIIIlllIIIIllllIlIII) {
                                    lllllllllllllIIIlllIIIIlllIlllIl.passthrough(Type.UUID);
                                    lllllllllllllIIIlllIIIIlllIlllIl.passthrough((Type<Object>)Type.DOUBLE);
                                    lllllllllllllIIIlllIIIIlllIlllIl.passthrough((Type<Object>)Type.BYTE);
                                }
                            }
                        }
                        if (lllllllllllllIIIlllIIIIlllIlllll != lllllllllllllIIIlllIIIIllllIIIII) {
                            lllllllllllllIIIlllIIIIlllIlllIl.set(Type.INT, 0, lllllllllllllIIIlllIIIIlllIlllll);
                        }
                    }
                });
            }
        });
    }
    
    public EntityPackets1_15(final Protocol1_14_4To1_15 lllllllllllllIIIIIlllIIIlllIIlll) {
        super(lllllllllllllIIIIIlllIIIlllIIlll);
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIIIIIlllIIIllIlllII) {
        return Entity1_15Types.getTypeFromId(lllllllllllllIIIIIlllIIIllIlllII);
    }
    
    @Override
    protected void registerRewrites() {
        this.registerMetaTypeHandler(MetaType1_14.Slot, MetaType1_14.BlockID, MetaType1_14.PARTICLE, null);
        this.filter().filterFamily(Entity1_15Types.LIVINGENTITY).removeIndex(12);
        this.filter().type(Entity1_15Types.BEE).cancel(15);
        this.filter().type(Entity1_15Types.BEE).cancel(16);
        this.mapEntityTypeWithData(Entity1_15Types.BEE, Entity1_15Types.PUFFERFISH).jsonName("Bee").spawnMetadata(lllllllllllllIIIIIlllIIIllIlIIII -> {
            lllllllllllllIIIIIlllIIIllIlIIII.add(new Metadata(14, MetaType1_14.Boolean, false));
            lllllllllllllIIIIIlllIIIllIlIIII.add(new Metadata(15, MetaType1_14.VarInt, 2));
            return;
        });
        this.filter().type(Entity1_15Types.ENDERMAN).cancel(16);
        this.filter().type(Entity1_15Types.TRIDENT).cancel(10);
        this.filter().type(Entity1_15Types.WOLF).addIndex(17);
        this.filter().type(Entity1_15Types.WOLF).index(8).handler((lllllllllllllIIIIIlllIIIllIlIIll, lllllllllllllIIIIIlllIIIllIlIlII) -> lllllllllllllIIIIIlllIIIllIlIIll.createExtraMeta(new Metadata(17, MetaType1_14.Float, lllllllllllllIIIIIlllIIIllIlIIll.meta().value())));
    }
    
    @Override
    public int newEntityId(final int lllllllllllllIIIIIlllIIIllIlIlll) {
        return EntityTypeMapping.getOldEntityId(lllllllllllllIIIIIlllIIIllIlIlll);
    }
}
