package com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.data.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_16 extends EntityRewriter<Protocol1_15_2To1_16>
{
    private final /* synthetic */ ValueTransformer<String, Integer> dimensionTransformer;
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIIIlIIIIIIlIllIIlI) {
        return Entity1_16Types.getTypeFromId(llllllllllllllIIIlIIIIIIlIllIIlI);
    }
    
    @Override
    protected void registerRewrites() {
        final MetaType llllllllllllllIIIlIIIIIIlIIlllIl;
        JsonElement llllllllllllllIIIlIIIIIIlIlIIIIl;
        this.filter().handler((llllllllllllllIIIlIIIIIIlIIlllll, llllllllllllllIIIlIIIIIIlIIllIll) -> {
            llllllllllllllIIIlIIIIIIlIIllIll.setMetaType(MetaType1_14.byId(llllllllllllllIIIlIIIIIIlIIllIll.metaType().typeId()));
            llllllllllllllIIIlIIIIIIlIIlllIl = llllllllllllllIIIlIIIIIIlIIllIll.metaType();
            if (llllllllllllllIIIlIIIIIIlIIlllIl == MetaType1_14.Slot) {
                llllllllllllllIIIlIIIIIIlIIllIll.setValue(((Protocol1_15_2To1_16)this.protocol).getItemRewriter().handleItemToClient((Item)llllllllllllllIIIlIIIIIIlIIllIll.getValue()));
            }
            else if (llllllllllllllIIIlIIIIIIlIIlllIl == MetaType1_14.BlockID) {
                llllllllllllllIIIlIIIIIIlIIllIll.setValue(((Protocol1_15_2To1_16)this.protocol).getMappingData().getNewBlockStateId((int)llllllllllllllIIIlIIIIIIlIIllIll.getValue()));
            }
            else if (llllllllllllllIIIlIIIIIIlIIlllIl == MetaType1_14.PARTICLE) {
                this.rewriteParticle((Particle)llllllllllllllIIIlIIIIIIlIIllIll.getValue());
            }
            else if (llllllllllllllIIIlIIIIIIlIIlllIl == MetaType1_14.OptChat) {
                llllllllllllllIIIlIIIIIIlIlIIIIl = (JsonElement)llllllllllllllIIIlIIIIIIlIIllIll.value();
                if (llllllllllllllIIIlIIIIIIlIlIIIIl != null) {
                    ((Protocol1_15_2To1_16)this.protocol).getTranslatableRewriter().processText(llllllllllllllIIIlIIIIIIlIlIIIIl);
                }
            }
            return;
        });
        this.mapEntityType(Entity1_16Types.ZOMBIFIED_PIGLIN, Entity1_15Types.ZOMBIE_PIGMAN);
        this.mapTypes(Entity1_16Types.values(), Entity1_15Types.class);
        this.mapEntityTypeWithData(Entity1_16Types.HOGLIN, Entity1_16Types.COW).jsonName("Hoglin");
        this.mapEntityTypeWithData(Entity1_16Types.ZOGLIN, Entity1_16Types.COW).jsonName("Zoglin");
        this.mapEntityTypeWithData(Entity1_16Types.PIGLIN, Entity1_16Types.ZOMBIFIED_PIGLIN).jsonName("Piglin");
        this.mapEntityTypeWithData(Entity1_16Types.STRIDER, Entity1_16Types.MAGMA_CUBE).jsonName("Strider");
        this.filter().type(Entity1_16Types.ZOGLIN).cancel(16);
        this.filter().type(Entity1_16Types.HOGLIN).cancel(15);
        this.filter().type(Entity1_16Types.PIGLIN).cancel(16);
        this.filter().type(Entity1_16Types.PIGLIN).cancel(17);
        this.filter().type(Entity1_16Types.PIGLIN).cancel(18);
        final boolean llllllllllllllIIIlIIIIIIlIlIlIII;
        this.filter().type(Entity1_16Types.STRIDER).index(15).handler((llllllllllllllIIIlIIIIIIlIlIlIlI, llllllllllllllIIIlIIIIIIlIlIlIIl) -> {
            llllllllllllllIIIlIIIIIIlIlIlIII = (boolean)llllllllllllllIIIlIIIIIIlIlIlIIl.value();
            llllllllllllllIIIlIIIIIIlIlIlIIl.setTypeAndValue(MetaType1_14.VarInt, llllllllllllllIIIlIIIIIIlIlIlIII ? 1 : 3);
            return;
        });
        this.filter().type(Entity1_16Types.STRIDER).cancel(16);
        this.filter().type(Entity1_16Types.STRIDER).cancel(17);
        this.filter().type(Entity1_16Types.STRIDER).cancel(18);
        this.filter().type(Entity1_16Types.FISHING_BOBBER).cancel(8);
        this.filter().filterFamily(Entity1_16Types.ABSTRACT_ARROW).cancel(8);
        this.filter().filterFamily(Entity1_16Types.ABSTRACT_ARROW).handler((llllllllllllllIIIlIIIIIIlIlIllIl, llllllllllllllIIIlIIIIIIlIlIlllI) -> {
            if (llllllllllllllIIIlIIIIIIlIlIllIl.index() >= 8) {
                llllllllllllllIIIlIIIIIIlIlIllIl.setIndex(llllllllllllllIIIlIIIIIIlIlIllIl.index() + 1);
            }
        });
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.SPAWN_ENTITY, new PacketRemapper() {
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
                final EntityType lllllllllllllIlIIllIlIllllllIlll;
                PacketWrapper lllllllllllllIlIIllIlIlllllllIlI;
                this.handler(lllllllllllllIlIIllIlIllllllIlIl -> {
                    lllllllllllllIlIIllIlIllllllIlll = EntityPackets1_16.this.typeFromId(lllllllllllllIlIIllIlIllllllIlIl.get((Type<Integer>)Type.VAR_INT, 1));
                    if (lllllllllllllIlIIllIlIllllllIlll == Entity1_16Types.LIGHTNING_BOLT) {
                        lllllllllllllIlIIllIlIllllllIlIl.cancel();
                        lllllllllllllIlIIllIlIlllllllIlI = lllllllllllllIlIIllIlIllllllIlIl.create(ClientboundPackets1_15.SPAWN_GLOBAL_ENTITY);
                        lllllllllllllIlIIllIlIlllllllIlI.write(Type.VAR_INT, (Integer)lllllllllllllIlIIllIlIllllllIlIl.get((Type<T>)Type.VAR_INT, 0));
                        lllllllllllllIlIIllIlIlllllllIlI.write(Type.BYTE, (Byte)1);
                        lllllllllllllIlIIllIlIlllllllIlI.write(Type.DOUBLE, (Double)lllllllllllllIlIIllIlIllllllIlIl.get((Type<T>)Type.DOUBLE, 0));
                        lllllllllllllIlIIllIlIlllllllIlI.write(Type.DOUBLE, (Double)lllllllllllllIlIIllIlIllllllIlIl.get((Type<T>)Type.DOUBLE, 1));
                        lllllllllllllIlIIllIlIlllllllIlI.write(Type.DOUBLE, (Double)lllllllllllllIlIIllIlIllllllIlIl.get((Type<T>)Type.DOUBLE, 2));
                        lllllllllllllIlIIllIlIlllllllIlI.send(Protocol1_15_2To1_16.class);
                    }
                    return;
                });
                this.handler(EntityPackets1_16.this.getSpawnTrackerWithDataHandler(Entity1_16Types.FALLING_BLOCK));
            }
        });
        this.registerSpawnTracker(ClientboundPackets1_16.SPAWN_MOB);
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map((ValueTransformer<Object, Object>)EntityPackets1_16.this.dimensionTransformer);
                final WorldNameTracker lllllllllllllIIlllIlIlIIIIlIlIll;
                final String lllllllllllllIIlllIlIlIIIIlIlIlI;
                final ClientWorld lllllllllllllIIlllIlIlIIIIlIlIIl;
                final int lllllllllllllIIlllIlIlIIIIlIlIII;
                PacketWrapper lllllllllllllIIlllIlIlIIIIlIllIl;
                this.handler(lllllllllllllIIlllIlIlIIIIlIIlll -> {
                    lllllllllllllIIlllIlIlIIIIlIlIll = lllllllllllllIIlllIlIlIIIIlIIlll.user().get(WorldNameTracker.class);
                    lllllllllllllIIlllIlIlIIIIlIlIlI = lllllllllllllIIlllIlIlIIIIlIIlll.read(Type.STRING);
                    lllllllllllllIIlllIlIlIIIIlIIlll.passthrough((Type<Object>)Type.LONG);
                    lllllllllllllIIlllIlIlIIIIlIIlll.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                    lllllllllllllIIlllIlIlIIIIlIIlll.read((Type<Object>)Type.BYTE);
                    lllllllllllllIIlllIlIlIIIIlIlIIl = lllllllllllllIIlllIlIlIIIIlIIlll.user().get(ClientWorld.class);
                    lllllllllllllIIlllIlIlIIIIlIlIII = lllllllllllllIIlllIlIlIIIIlIIlll.get((Type<Integer>)Type.INT, 0);
                    if (lllllllllllllIIlllIlIlIIIIlIlIIl.getEnvironment() != null && lllllllllllllIIlllIlIlIIIIlIlIII == lllllllllllllIIlllIlIlIIIIlIlIIl.getEnvironment().getId() && (lllllllllllllIIlllIlIlIIIIlIIlll.user().isClientSide() || Via.getPlatform().isProxy() || lllllllllllllIIlllIlIlIIIIlIIlll.user().getProtocolInfo().getProtocolVersion() <= ProtocolVersion.v1_12_2.getVersion() || !lllllllllllllIIlllIlIlIIIIlIlIlI.equals(lllllllllllllIIlllIlIlIIIIlIlIll.getWorldName()))) {
                        lllllllllllllIIlllIlIlIIIIlIllIl = lllllllllllllIIlllIlIlIIIIlIIlll.create(ClientboundPackets1_15.RESPAWN);
                        lllllllllllllIIlllIlIlIIIIlIllIl.write(Type.INT, (lllllllllllllIIlllIlIlIIIIlIlIII == 0) ? -1 : 0);
                        lllllllllllllIIlllIlIlIIIIlIllIl.write(Type.LONG, 0L);
                        lllllllllllllIIlllIlIlIIIIlIllIl.write(Type.UNSIGNED_BYTE, (Short)0);
                        lllllllllllllIIlllIlIlIIIIlIllIl.write(Type.STRING, "default");
                        lllllllllllllIIlllIlIlIIIIlIllIl.send(Protocol1_15_2To1_16.class);
                    }
                    lllllllllllllIIlllIlIlIIIIlIlIIl.setEnvironment(lllllllllllllIIlllIlIlIIIIlIlIII);
                    lllllllllllllIIlllIlIlIIIIlIIlll.write(Type.STRING, "default");
                    lllllllllllllIIlllIlIlIIIIlIIlll.read((Type<Object>)Type.BOOLEAN);
                    if (lllllllllllllIIlllIlIlIIIIlIIlll.read((Type<Boolean>)Type.BOOLEAN)) {
                        lllllllllllllIIlllIlIlIIIIlIIlll.set(Type.STRING, 0, "flat");
                    }
                    lllllllllllllIIlllIlIlIIIIlIIlll.read((Type<Object>)Type.BOOLEAN);
                    lllllllllllllIIlllIlIlIIIIlIlIll.setWorldName(lllllllllllllIIlllIlIlIIIIlIlIlI);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BYTE, Type.NOTHING);
                this.map(Type.STRING_ARRAY, Type.NOTHING);
                this.map(Type.NBT, Type.NOTHING);
                this.map((ValueTransformer<Object, Object>)EntityPackets1_16.this.dimensionTransformer);
                final WorldNameTracker lllllllllllllllIlllIIIIIIllIIlIl;
                this.handler(lllllllllllllllIlllIIIIIIllIIllI -> {
                    lllllllllllllllIlllIIIIIIllIIlIl = lllllllllllllllIlllIIIIIIllIIllI.user().get(WorldNameTracker.class);
                    lllllllllllllllIlllIIIIIIllIIlIl.setWorldName(lllllllllllllllIlllIIIIIIllIIllI.read(Type.STRING));
                    return;
                });
                this.map(Type.LONG);
                this.map(Type.UNSIGNED_BYTE);
                final ClientWorld lllllllllllllllIlllIIIIIIllIllII;
                this.handler(lllllllllllllllIlllIIIIIIllIllIl -> {
                    lllllllllllllllIlllIIIIIIllIllII = lllllllllllllllIlllIIIIIIllIllIl.user().get(ClientWorld.class);
                    lllllllllllllllIlllIIIIIIllIllII.setEnvironment(lllllllllllllllIlllIIIIIIllIllIl.get((Type<Integer>)Type.INT, 1));
                    ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)EntityPackets1_16.this).tracker(lllllllllllllllIlllIIIIIIllIllIl.user()).addEntity(lllllllllllllllIlllIIIIIIllIllIl.get((Type<Integer>)Type.INT, 0), Entity1_16Types.PLAYER);
                    lllllllllllllllIlllIIIIIIllIllIl.write(Type.STRING, "default");
                    lllllllllllllllIlllIIIIIIllIllIl.passthrough((Type<Object>)Type.VAR_INT);
                    lllllllllllllllIlllIIIIIIllIllIl.passthrough((Type<Object>)Type.BOOLEAN);
                    lllllllllllllllIlllIIIIIIllIllIl.passthrough((Type<Object>)Type.BOOLEAN);
                    lllllllllllllllIlllIIIIIIllIllIl.read((Type<Object>)Type.BOOLEAN);
                    if (lllllllllllllllIlllIIIIIIllIllIl.read((Type<Boolean>)Type.BOOLEAN)) {
                        lllllllllllllllIlllIIIIIIllIllIl.set(Type.STRING, 0, "flat");
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_16.SPAWN_EXPERIENCE_ORB, Entity1_16Types.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_16.SPAWN_PAINTING, Entity1_16Types.PAINTING);
        this.registerTracker(ClientboundPackets1_16.SPAWN_PLAYER, Entity1_16Types.PLAYER);
        this.registerRemoveEntities(ClientboundPackets1_16.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_16.ENTITY_METADATA, Types1_16.METADATA_LIST, Types1_14.METADATA_LIST);
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                int lllllllllllllllllIlllllIllIllIlI;
                int lllllllllllllllllIlllllIllIlllIl;
                String lllllllllllllllllIlllllIlllIIIII;
                String lllllllllllllllllIlllllIllIlllll;
                int lllllllllllllllllIlllllIllIllllI;
                int lllllllllllllllllIlllllIlllIIIIl;
                this.handler(lllllllllllllllllIlllllIllIllIII -> {
                    lllllllllllllllllIlllllIllIllIII.passthrough((Type<Object>)Type.VAR_INT);
                    for (lllllllllllllllllIlllllIllIllIlI = lllllllllllllllllIlllllIllIllIII.passthrough((Type<Integer>)Type.INT), lllllllllllllllllIlllllIllIlllIl = 0; lllllllllllllllllIlllllIllIlllIl < lllllllllllllllllIlllllIllIllIlI; ++lllllllllllllllllIlllllIllIlllIl) {
                        lllllllllllllllllIlllllIlllIIIII = lllllllllllllllllIlllllIllIllIII.read(Type.STRING);
                        lllllllllllllllllIlllllIllIlllll = ((Protocol1_15_2To1_16)EntityPackets1_16.this.protocol).getMappingData().getAttributeMappings().get(lllllllllllllllllIlllllIlllIIIII);
                        lllllllllllllllllIlllllIllIllIII.write(Type.STRING, (lllllllllllllllllIlllllIllIlllll != null) ? lllllllllllllllllIlllllIllIlllll : lllllllllllllllllIlllllIlllIIIII.replace("minecraft:", ""));
                        lllllllllllllllllIlllllIllIllIII.passthrough((Type<Object>)Type.DOUBLE);
                        for (lllllllllllllllllIlllllIllIllllI = lllllllllllllllllIlllllIllIllIII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllllllIlllllIlllIIIIl = 0; lllllllllllllllllIlllllIlllIIIIl < lllllllllllllllllIlllllIllIllllI; ++lllllllllllllllllIlllllIlllIIIIl) {
                            lllllllllllllllllIlllllIllIllIII.passthrough(Type.UUID);
                            lllllllllllllllllIlllllIllIllIII.passthrough((Type<Object>)Type.DOUBLE);
                            lllllllllllllllllIlllllIllIllIII.passthrough((Type<Object>)Type.BYTE);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.PLAYER_INFO, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllllllIIIIIIlIlIIIll;
                int llllllllllllllllllIIIIIIlIlIIIlI;
                int llllllllllllllllllIIIIIIlIlIIllI;
                int llllllllllllllllllIIIIIIlIlIIlll;
                int llllllllllllllllllIIIIIIlIlIlIII;
                this.handler(llllllllllllllllllIIIIIIlIlIIIII -> {
                    llllllllllllllllllIIIIIIlIlIIIll = llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Integer>)Type.VAR_INT);
                    for (llllllllllllllllllIIIIIIlIlIIIlI = llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllllllIIIIIIlIlIIllI = 0; llllllllllllllllllIIIIIIlIlIIllI < llllllllllllllllllIIIIIIlIlIIIlI; ++llllllllllllllllllIIIIIIlIlIIllI) {
                        llllllllllllllllllIIIIIIlIlIIIII.passthrough(Type.UUID);
                        if (llllllllllllllllllIIIIIIlIlIIIll == 0) {
                            llllllllllllllllllIIIIIIlIlIIIII.passthrough(Type.STRING);
                            for (llllllllllllllllllIIIIIIlIlIIlll = llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllllllIIIIIIlIlIlIII = 0; llllllllllllllllllIIIIIIlIlIlIII < llllllllllllllllllIIIIIIlIlIIlll; ++llllllllllllllllllIIIIIIlIlIlIII) {
                                llllllllllllllllllIIIIIIlIlIIIII.passthrough(Type.STRING);
                                llllllllllllllllllIIIIIIlIlIIIII.passthrough(Type.STRING);
                                if (llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                    llllllllllllllllllIIIIIIlIlIIIII.passthrough(Type.STRING);
                                }
                            }
                            llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Object>)Type.VAR_INT);
                            llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Object>)Type.VAR_INT);
                            if (llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                ((Protocol1_15_2To1_16)EntityPackets1_16.this.protocol).getTranslatableRewriter().processText(llllllllllllllllllIIIIIIlIlIIIII.passthrough(Type.COMPONENT));
                            }
                        }
                        else if (llllllllllllllllllIIIIIIlIlIIIll == 1) {
                            llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Object>)Type.VAR_INT);
                        }
                        else if (llllllllllllllllllIIIIIIlIlIIIll == 2) {
                            llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Object>)Type.VAR_INT);
                        }
                        else if (llllllllllllllllllIIIIIIlIlIIIll == 3 && llllllllllllllllllIIIIIIlIlIIIII.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                            ((Protocol1_15_2To1_16)EntityPackets1_16.this.protocol).getTranslatableRewriter().processText(llllllllllllllllllIIIIIIlIlIIIII.passthrough(Type.COMPONENT));
                        }
                    }
                });
            }
        });
    }
    
    public EntityPackets1_16(final Protocol1_15_2To1_16 llllllllllllllIIIlIIIIIIllIIIllI) {
        super(llllllllllllllIIIlIIIIIIllIIIllI);
        this.dimensionTransformer = new ValueTransformer<String, Integer>((Type)Type.STRING, (Type)Type.INT) {
            @Override
            public Integer transform(final PacketWrapper lllllllllllllIllIIlllIIIlIllIlll, final String lllllllllllllIllIIlllIIIlIllIllI) throws Exception {
                final long lllllllllllllIllIIlllIIIlIllIlII = (long)lllllllllllllIllIIlllIIIlIllIllI;
                double lllllllllllllIllIIlllIIIlIllIIll = -1;
                switch (((String)lllllllllllllIllIIlllIIIlIllIlII).hashCode()) {
                    case -1526768685: {
                        if (((String)lllllllllllllIllIIlllIIIlIllIlII).equals("minecraft:the_nether")) {
                            lllllllllllllIllIIlllIIIlIllIIll = 0;
                            break;
                        }
                        break;
                    }
                    case 1104210353: {
                        if (((String)lllllllllllllIllIIlllIIIlIllIlII).equals("minecraft:overworld")) {
                            lllllllllllllIllIIlllIIIlIllIIll = 2;
                            break;
                        }
                        break;
                    }
                    case 1731133248: {
                        if (((String)lllllllllllllIllIIlllIIIlIllIlII).equals("minecraft:the_end")) {
                            lllllllllllllIllIIlllIIIlIllIIll = 3;
                            break;
                        }
                        break;
                    }
                }
                switch (lllllllllllllIllIIlllIIIlIllIIll) {
                    case 0.0: {
                        return -1;
                    }
                    default: {
                        return 0;
                    }
                    case 3.0: {
                        return 1;
                    }
                }
            }
        };
    }
}
