package com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.api.entities.storage.*;
import java.util.function.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.storage.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.rewriter.*;

public class EntityPackets1_14 extends LegacyEntityRewriter<Protocol1_13_2To1_14>
{
    private /* synthetic */ EntityPositionHandler positionHandler;
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIIIIlllIllIIIIIIII) {
        return Entity1_14Types.getTypeFromId(llllllllllllllIIIIlllIllIIIIIIII);
    }
    
    @Override
    protected void addTrackedEntity(final PacketWrapper llllllllllllllIIIIlllIllIIIlIlll, final int llllllllllllllIIIIlllIllIIIllIlI, final EntityType llllllllllllllIIIIlllIllIIIllIIl) throws Exception {
        super.addTrackedEntity(llllllllllllllIIIIlllIllIIIlIlll, llllllllllllllIIIIlllIllIIIllIlI, llllllllllllllIIIIlllIllIIIllIIl);
        if (llllllllllllllIIIIlllIllIIIllIIl == Entity1_14Types.PAINTING) {
            final Position llllllllllllllIIIIlllIllIIIlllIl = llllllllllllllIIIIlllIllIIIlIlll.get(Type.POSITION, 0);
            this.positionHandler.cacheEntityPosition(llllllllllllllIIIIlllIllIIIlIlll, llllllllllllllIIIIlllIllIIIlllIl.getX(), llllllllllllllIIIIlllIllIIIlllIl.getY(), llllllllllllllIIIIlllIllIIIlllIl.getZ(), true, false);
        }
        else if (llllllllllllllIIIIlllIllIIIlIlll.getId() != ClientboundPackets1_14.JOIN_GAME.getId()) {
            this.positionHandler.cacheEntityPosition(llllllllllllllIIIIlllIllIIIlIlll, true, false);
        }
    }
    
    public EntityPackets1_14(final Protocol1_13_2To1_14 llllllllllllllIIIIlllIllIIlIIlIl) {
        super(llllllllllllllIIIIlllIllIIlIIlIl, MetaType1_13_2.OptChat, MetaType1_13_2.Boolean);
    }
    
    public int villagerDataToProfession(final VillagerData llllllllllllllIIIIlllIllIIIIIlIl) {
        switch (llllllllllllllIIIIlllIllIIIIIlIl.getProfession()) {
            case 1:
            case 10:
            case 13:
            case 14: {
                return 3;
            }
            case 2:
            case 8: {
                return 4;
            }
            case 3:
            case 9: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5:
            case 6:
            case 7:
            case 12: {
                return 0;
            }
            default: {
                return 5;
            }
        }
    }
    
    @Override
    protected void registerPackets() {
        this.positionHandler = new EntityPositionHandler(this, EntityPositionStorage1_14.class, EntityPositionStorage1_14::new);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.ENTITY_STATUS, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIlIlIIllllIlIlIllIl;
                final byte lllllllllllllIlIlIIllllIlIlIllII;
                EntityTracker lllllllllllllIlIlIIllllIlIlIlIll;
                EntityType lllllllllllllIlIlIIllllIlIlIlIlI;
                int lllllllllllllIlIlIIllllIlIllIIII;
                PacketWrapper lllllllllllllIlIlIIllllIlIllIIIl;
                this.handler(lllllllllllllIlIlIIllllIlIlIlIII -> {
                    lllllllllllllIlIlIIllllIlIlIllIl = lllllllllllllIlIlIIllllIlIlIlIII.passthrough((Type<Integer>)Type.INT);
                    lllllllllllllIlIlIIllllIlIlIllII = lllllllllllllIlIlIIllllIlIlIlIII.passthrough((Type<Byte>)Type.BYTE);
                    if (lllllllllllllIlIlIIllllIlIlIllII == 3) {
                        lllllllllllllIlIlIIllllIlIlIlIll = ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)EntityPackets1_14.this).tracker(lllllllllllllIlIlIIllllIlIlIlIII.user());
                        lllllllllllllIlIlIIllllIlIlIlIlI = lllllllllllllIlIlIIllllIlIlIlIll.entityType(lllllllllllllIlIlIIllllIlIlIllIl);
                        if (lllllllllllllIlIlIIllllIlIlIlIlI == Entity1_14Types.PLAYER) {
                            for (lllllllllllllIlIlIIllllIlIllIIII = 0; lllllllllllllIlIlIIllllIlIllIIII <= 5; ++lllllllllllllIlIlIIllllIlIllIIII) {
                                lllllllllllllIlIlIIllllIlIllIIIl = lllllllllllllIlIlIIllllIlIlIlIII.create(ClientboundPackets1_13.ENTITY_EQUIPMENT);
                                lllllllllllllIlIlIIllllIlIllIIIl.write(Type.VAR_INT, lllllllllllllIlIlIIllllIlIlIllIl);
                                lllllllllllllIlIlIIllllIlIllIIIl.write(Type.VAR_INT, lllllllllllllIlIlIIllllIlIllIIII);
                                lllllllllllllIlIlIIllllIlIllIIIl.write(Type.FLAT_VAR_INT_ITEM, null);
                                lllllllllllllIlIlIIllllIlIllIIIl.send(Protocol1_13_2To1_14.class);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.ENTITY_TELEPORT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.handler(lllllllllllllllIIIIIlIlIlIIIlIIl -> EntityPackets1_14.this.positionHandler.cacheEntityPosition(lllllllllllllllIIIIIlIlIlIIIlIIl, false, false));
            }
        });
        final PacketRemapper llllllllllllllIIIIlllIllIIIlIIII = new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllIIIlllIlIlIIlII) throws Exception {
                        final double lllllllllllllllllIIIlllIlIlIlIII = lllllllllllllllllIIIlllIlIlIIlII.get((Type<Short>)Type.SHORT, 0) / 4096.0;
                        final double lllllllllllllllllIIIlllIlIlIIlll = lllllllllllllllllIIIlllIlIlIIlII.get((Type<Short>)Type.SHORT, 1) / 4096.0;
                        final double lllllllllllllllllIIIlllIlIlIIllI = lllllllllllllllllIIIlllIlIlIIlII.get((Type<Short>)Type.SHORT, 2) / 4096.0;
                        EntityPackets1_14.this.positionHandler.cacheEntityPosition(lllllllllllllllllIIIlllIlIlIIlII, lllllllllllllllllIIIlllIlIlIlIII, lllllllllllllllllIIIlllIlIlIIlll, lllllllllllllllllIIIlllIlIlIIllI, false, true);
                    }
                });
            }
        };
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.ENTITY_POSITION, llllllllllllllIIIIlllIllIIIlIIII);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.ENTITY_POSITION_AND_ROTATION, llllllllllllllIIIIlllIllIIIlIIII);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT, Type.BYTE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.handler(LegacyEntityRewriter.this.getObjectTrackerHandler());
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIlIIllIllIIlllll) throws Exception {
                        final int lllllllllllllIlIIlIIllIllIIllllI = lllllllllllllIlIIlIIllIllIIlllll.get((Type<Byte>)Type.BYTE, 0);
                        final int lllllllllllllIlIIlIIllIllIIlllIl = EntityPackets1_14.this.newEntityId(lllllllllllllIlIIlIIllIllIIllllI);
                        final Entity1_13Types.EntityType lllllllllllllIlIIlIIllIllIIlllII = Entity1_13Types.getTypeFromId(lllllllllllllIlIIlIIllIllIIlllIl, false);
                        Entity1_13Types.ObjectType lllllllllllllIlIIlIIllIllIIllIll = null;
                        if (lllllllllllllIlIIlIIllIllIIlllII.isOrHasParent(Entity1_13Types.EntityType.MINECART_ABSTRACT)) {
                            final Entity1_13Types.ObjectType lllllllllllllIlIIlIIllIllIlIIlll = Entity1_13Types.ObjectType.MINECART;
                            int lllllllllllllIlIIlIIllIllIlIlIIl = 0;
                            switch (lllllllllllllIlIIlIIllIllIIlllII) {
                                case CHEST_MINECART: {
                                    lllllllllllllIlIIlIIllIllIlIlIIl = 1;
                                    break;
                                }
                                case FURNACE_MINECART: {
                                    lllllllllllllIlIIlIIllIllIlIlIIl = 2;
                                    break;
                                }
                                case TNT_MINECART: {
                                    lllllllllllllIlIIlIIllIllIlIlIIl = 3;
                                    break;
                                }
                                case SPAWNER_MINECART: {
                                    lllllllllllllIlIIlIIllIllIlIlIIl = 4;
                                    break;
                                }
                                case HOPPER_MINECART: {
                                    lllllllllllllIlIIlIIllIllIlIlIIl = 5;
                                    break;
                                }
                                case COMMAND_BLOCK_MINECART: {
                                    lllllllllllllIlIIlIIllIllIlIlIIl = 6;
                                    break;
                                }
                            }
                            if (lllllllllllllIlIIlIIllIllIlIlIIl != 0) {
                                lllllllllllllIlIIlIIllIllIIlllll.set(Type.INT, 0, lllllllllllllIlIIlIIllIllIlIlIIl);
                            }
                        }
                        else {
                            lllllllllllllIlIIlIIllIllIIllIll = Entity1_13Types.ObjectType.fromEntityType(lllllllllllllIlIIlIIllIllIIlllII).orElse(null);
                        }
                        if (lllllllllllllIlIIlIIllIllIIllIll == null) {
                            return;
                        }
                        lllllllllllllIlIIlIIllIllIIlllll.set(Type.BYTE, 0, (byte)lllllllllllllIlIIlIIllIllIIllIll.getId());
                        final int lllllllllllllIlIIlIIllIllIIllIlI = lllllllllllllIlIIlIIllIllIIlllll.get((Type<Integer>)Type.INT, 0);
                        if (lllllllllllllIlIIlIIllIllIIllIll == Entity1_13Types.ObjectType.FALLING_BLOCK) {
                            final int lllllllllllllIlIIlIIllIllIlIIlIl = lllllllllllllIlIIlIIllIllIIlllll.get((Type<Integer>)Type.INT, 0);
                            final int lllllllllllllIlIIlIIllIllIlIIIll = ((Protocol1_13_2To1_14)EntityPackets1_14.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIlIIlIIllIllIlIIlIl);
                            lllllllllllllIlIIlIIllIllIIlllll.set(Type.INT, 0, lllllllllllllIlIIlIIllIllIlIIIll);
                        }
                        else if (lllllllllllllIlIIlIIllIllIIlllII.isOrHasParent(Entity1_13Types.EntityType.ABSTRACT_ARROW)) {
                            lllllllllllllIlIIlIIllIllIIlllll.set(Type.INT, 0, lllllllllllllIlIIlIIllIllIIllIlI + 1);
                        }
                    }
                });
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
                this.map(Types1_14.METADATA_LIST, Types1_13_2.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlIIlllIllIIllIlI) throws Exception {
                        final int lllllllllllllllIlIIlllIllIIllIIl = lllllllllllllllIlIIlllIllIIllIlI.get((Type<Integer>)Type.VAR_INT, 1);
                        final EntityType lllllllllllllllIlIIlllIllIIllIII = Entity1_14Types.getTypeFromId(lllllllllllllllIlIIlllIllIIllIIl);
                        EntityPackets1_14.this.addTrackedEntity(lllllllllllllllIlIIlllIllIIllIlI, lllllllllllllllIlIIlllIllIIllIlI.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllllIlIIlllIllIIllIII);
                        final int lllllllllllllllIlIIlllIllIIlIlll = EntityPackets1_14.this.newEntityId(lllllllllllllllIlIIlllIllIIllIIl);
                        if (lllllllllllllllIlIIlllIllIIlIlll == -1) {
                            final EntityData lllllllllllllllIlIIlllIllIIlllII = EntityRewriterBase.this.entityDataForType(lllllllllllllllIlIIlllIllIIllIII);
                            if (lllllllllllllllIlIIlllIllIIlllII == null) {
                                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Could not find 1.13.2 entity type for 1.14 entity type ").append(lllllllllllllllIlIIlllIllIIllIIl).append("/").append(lllllllllllllllIlIIlllIllIIllIII)));
                                lllllllllllllllIlIIlllIllIIllIlI.cancel();
                            }
                            else {
                                lllllllllllllllIlIIlllIllIIllIlI.set(Type.VAR_INT, 1, lllllllllllllllIlIIlllIllIIlllII.replacementId());
                            }
                        }
                        else {
                            lllllllllllllllIlIIlllIllIIllIlI.set(Type.VAR_INT, 1, lllllllllllllllIlIIlllIllIIlIlll);
                        }
                    }
                });
                this.handler(LegacyEntityRewriter.this.getMobSpawnRewriter(Types1_13_2.METADATA_LIST));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SPAWN_EXPERIENCE_ORB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.handler(llllllllllllllIIllIIIlllllIlllIl -> EntityPackets1_14.this.addTrackedEntity(llllllllllllllIIllIIIlllllIlllIl, llllllllllllllIIllIIIlllllIlllIl.get((Type<Integer>)Type.VAR_INT, 0), Entity1_14Types.EXPERIENCE_ORB));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SPAWN_GLOBAL_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.handler(lllllllllllllIIllIIlIlIlIllIlIll -> EntityPackets1_14.this.addTrackedEntity(lllllllllllllIIllIIlIlIlIllIlIll, lllllllllllllIIllIIlIlIlIllIlIll.get((Type<Integer>)Type.VAR_INT, 0), Entity1_14Types.LIGHTNING_BOLT));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SPAWN_PAINTING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.map(Type.POSITION1_14, Type.POSITION);
                this.map(Type.BYTE);
                this.handler(lllllllllllllIIlIIIlIIllIIIlllll -> EntityPackets1_14.this.addTrackedEntity(lllllllllllllIIlIIIlIIllIIIlllll, lllllllllllllIIlIIIlIIllIIIlllll.get((Type<Integer>)Type.VAR_INT, 0), Entity1_14Types.PAINTING));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_14.METADATA_LIST, Types1_13_2.METADATA_LIST);
                this.handler(LegacyEntityRewriter.this.getTrackerAndMetaHandler(Types1_13_2.METADATA_LIST, Entity1_14Types.PLAYER));
                this.handler(lllllllllllllIllIlIIlIlIlIlIllll -> EntityPackets1_14.this.positionHandler.cacheEntityPosition(lllllllllllllIllIlIIlIlIlIlIllll, true, false));
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_14.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_14.ENTITY_METADATA, Types1_14.METADATA_LIST, Types1_13_2.METADATA_LIST);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.handler(EntityRewriterBase.this.getTrackerHandler(Entity1_14Types.PLAYER, Type.INT));
                this.handler(EntityRewriterBase.this.getDimensionHandler(1));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllIlllllIllllllllIlIIl) throws Exception {
                        llllllllllllIlllllIllllllllIlIIl.write(Type.UNSIGNED_BYTE, (Short)0);
                        llllllllllllIlllllIllllllllIlIIl.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                        llllllllllllIlllllIllllllllIlIIl.passthrough(Type.STRING);
                        llllllllllllIlllllIllllllllIlIIl.read((Type<Object>)Type.VAR_INT);
                        final int llllllllllllIlllllIllllllllIlIII = llllllllllllIlllllIllllllllIlIIl.get((Type<Integer>)Type.INT, 0);
                        final StoredEntityData llllllllllllIlllllIllllllllIIlll = ((Protocol1_13_2To1_14)EntityPackets1_14.this.protocol).getEntityRewriter().tracker(llllllllllllIlllllIllllllllIlIIl.user()).entityData(llllllllllllIlllllIllllllllIlIII);
                        llllllllllllIlllllIllllllllIIlll.put(new EntityPositionStorage1_14());
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIllllllIIlIIIIl) throws Exception {
                        final ClientWorld lllllllllllllIIIIIllllllIIlIIIll = lllllllllllllIIIIIllllllIIlIIIIl.user().get(ClientWorld.class);
                        final int lllllllllllllIIIIIllllllIIlIIIlI = lllllllllllllIIIIIllllllIIlIIIIl.get((Type<Integer>)Type.INT, 0);
                        lllllllllllllIIIIIllllllIIlIIIll.setEnvironment(lllllllllllllIIIIIllllllIIlIIIlI);
                        lllllllllllllIIIIIllllllIIlIIIIl.write(Type.UNSIGNED_BYTE, (Short)0);
                        lllllllllllllIIIIIllllllIIlIIIIl.user().get(ChunkLightStorage.class).clear();
                    }
                });
            }
        });
    }
    
    @Override
    protected void registerRewrites() {
        this.mapTypes(Entity1_14Types.values(), Entity1_13Types.EntityType.class);
        this.mapEntityTypeWithData(Entity1_14Types.CAT, Entity1_14Types.OCELOT).jsonName("Cat");
        this.mapEntityTypeWithData(Entity1_14Types.TRADER_LLAMA, Entity1_14Types.LLAMA).jsonName("Trader Llama");
        this.mapEntityTypeWithData(Entity1_14Types.FOX, Entity1_14Types.WOLF).jsonName("Fox");
        this.mapEntityTypeWithData(Entity1_14Types.PANDA, Entity1_14Types.POLAR_BEAR).jsonName("Panda");
        this.mapEntityTypeWithData(Entity1_14Types.PILLAGER, Entity1_14Types.VILLAGER).jsonName("Pillager");
        this.mapEntityTypeWithData(Entity1_14Types.WANDERING_TRADER, Entity1_14Types.VILLAGER).jsonName("Wandering Trader");
        this.mapEntityTypeWithData(Entity1_14Types.RAVAGER, Entity1_14Types.COW).jsonName("Ravager");
        final int llllllllllllllIIIIlllIlIIllIllll;
        final MetaType llllllllllllllIIIIlllIlIIllIlllI;
        Item llllllllllllllIIIIlllIlIIlllIlll;
        int llllllllllllllIIIIlllIlIIlllIlIl;
        this.filter().handler((llllllllllllllIIIIlllIlIIlllIIIl, llllllllllllllIIIIlllIlIIllIllII) -> {
            llllllllllllllIIIIlllIlIIllIllll = llllllllllllllIIIIlllIlIIllIllII.metaType().typeId();
            if (llllllllllllllIIIIlllIlIIllIllll <= 15) {
                llllllllllllllIIIIlllIlIIllIllII.setMetaType(MetaType1_13_2.byId(llllllllllllllIIIIlllIlIIllIllll));
            }
            llllllllllllllIIIIlllIlIIllIlllI = llllllllllllllIIIIlllIlIIllIllII.metaType();
            if (llllllllllllllIIIIlllIlIIllIlllI == MetaType1_13_2.Slot) {
                llllllllllllllIIIIlllIlIIlllIlll = (Item)llllllllllllllIIIIlllIlIIllIllII.getValue();
                llllllllllllllIIIIlllIlIIllIllII.setValue(((Protocol1_13_2To1_14)this.protocol).getItemRewriter().handleItemToClient(llllllllllllllIIIIlllIlIIlllIlll));
            }
            else if (llllllllllllllIIIIlllIlIIllIlllI == MetaType1_13_2.BlockID) {
                llllllllllllllIIIIlllIlIIlllIlIl = (int)llllllllllllllIIIIlllIlIIllIllII.getValue();
                llllllllllllllIIIIlllIlIIllIllII.setValue(((Protocol1_13_2To1_14)this.protocol).getMappingData().getNewBlockStateId(llllllllllllllIIIIlllIlIIlllIlIl));
            }
            return;
        });
        this.filter().type(Entity1_14Types.PILLAGER).cancel(15);
        this.filter().type(Entity1_14Types.FOX).cancel(15);
        this.filter().type(Entity1_14Types.FOX).cancel(16);
        this.filter().type(Entity1_14Types.FOX).cancel(17);
        this.filter().type(Entity1_14Types.FOX).cancel(18);
        this.filter().type(Entity1_14Types.PANDA).cancel(15);
        this.filter().type(Entity1_14Types.PANDA).cancel(16);
        this.filter().type(Entity1_14Types.PANDA).cancel(17);
        this.filter().type(Entity1_14Types.PANDA).cancel(18);
        this.filter().type(Entity1_14Types.PANDA).cancel(19);
        this.filter().type(Entity1_14Types.PANDA).cancel(20);
        this.filter().type(Entity1_14Types.CAT).cancel(18);
        this.filter().type(Entity1_14Types.CAT).cancel(19);
        this.filter().type(Entity1_14Types.CAT).cancel(20);
        final EntityType llllllllllllllIIIIlllIlIlIIlIIll;
        int llllllllllllllIIIIlllIlIlIIllIIl;
        this.filter().handler((llllllllllllllIIIIlllIlIlIIlIIIl, llllllllllllllIIIIlllIlIlIIlIlIl) -> {
            llllllllllllllIIIIlllIlIlIIlIIll = llllllllllllllIIIIlllIlIlIIlIIIl.entityType();
            if (llllllllllllllIIIIlllIlIlIIlIIll == null) {
                return;
            }
            else {
                if (llllllllllllllIIIIlllIlIlIIlIIll.isOrHasParent(Entity1_14Types.ABSTRACT_ILLAGER_BASE) || llllllllllllllIIIIlllIlIlIIlIIll == Entity1_14Types.RAVAGER || llllllllllllllIIIIlllIlIlIIlIIll == Entity1_14Types.WITCH) {
                    llllllllllllllIIIIlllIlIlIIllIIl = llllllllllllllIIIIlllIlIlIIlIIIl.index();
                    if (llllllllllllllIIIIlllIlIlIIllIIl == 14) {
                        llllllllllllllIIIIlllIlIlIIlIIIl.cancel();
                    }
                    else if (llllllllllllllIIIIlllIlIlIIllIIl > 14) {
                        llllllllllllllIIIIlllIlIlIIlIIIl.setIndex(llllllllllllllIIIIlllIlIlIIllIIl - 1);
                    }
                }
                return;
            }
        });
        this.filter().type(Entity1_14Types.AREA_EFFECT_CLOUD).index(10).handler((llllllllllllllIIIIlllIlIlIllIllI, llllllllllllllIIIIlllIlIlIllIlII) -> this.rewriteParticle((Particle)llllllllllllllIIIIlllIlIlIllIlII.getValue()));
        final Integer llllllllllllllIIIIlllIlIlIllllll;
        this.filter().type(Entity1_14Types.FIREWORK_ROCKET).index(8).handler((llllllllllllllIIIIlllIlIllIIIIIl, llllllllllllllIIIIlllIlIllIIIIII) -> {
            llllllllllllllIIIIlllIlIllIIIIII.setMetaType(MetaType1_13_2.VarInt);
            llllllllllllllIIIIlllIlIlIllllll = (Integer)llllllllllllllIIIIlllIlIllIIIIII.getValue();
            if (llllllllllllllIIIIlllIlIlIllllll == null) {
                llllllllllllllIIIIlllIlIllIIIIII.setValue(0);
            }
            return;
        });
        this.filter().filterFamily(Entity1_14Types.ABSTRACT_ARROW).removeIndex(9);
        this.filter().type(Entity1_14Types.VILLAGER).cancel(15);
        final VillagerData llllllllllllllIIIIlllIlIllIIlIII;
        final MetaHandler llllllllllllllIIIIlllIllIIIIlIlI = (llllllllllllllIIIIlllIlIllIIIllI, llllllllllllllIIIIlllIlIllIIlIIl) -> {
            llllllllllllllIIIIlllIlIllIIlIII = (VillagerData)llllllllllllllIIIIlllIlIllIIlIIl.getValue();
            llllllllllllllIIIIlllIlIllIIlIIl.setTypeAndValue(MetaType1_13_2.VarInt, this.villagerDataToProfession(llllllllllllllIIIIlllIlIllIIlIII));
            if (llllllllllllllIIIIlllIlIllIIlIIl.id() == 16) {
                llllllllllllllIIIIlllIlIllIIIllI.setIndex(15);
            }
            return;
        };
        this.filter().type(Entity1_14Types.ZOMBIE_VILLAGER).index(18).handler(llllllllllllllIIIIlllIllIIIIlIlI);
        this.filter().type(Entity1_14Types.VILLAGER).index(16).handler(llllllllllllllIIIIlllIllIIIIlIlI);
        final byte llllllllllllllIIIIlllIlIllIlIIll;
        this.filter().filterFamily(Entity1_14Types.ABSTRACT_SKELETON).index(13).handler((llllllllllllllIIIIlllIlIllIlIlIl, llllllllllllllIIIIlllIlIllIlIlII) -> {
            llllllllllllllIIIIlllIlIllIlIIll = (byte)llllllllllllllIIIIlllIlIllIlIlII.getValue();
            if ((llllllllllllllIIIIlllIlIllIlIIll & 0x4) != 0x0) {
                llllllllllllllIIIIlllIlIllIlIlIl.createExtraMeta(new Metadata(14, MetaType1_13_2.Boolean, true));
            }
            return;
        });
        final byte llllllllllllllIIIIlllIlIllIlllII;
        this.filter().filterFamily(Entity1_14Types.ZOMBIE).index(13).handler((llllllllllllllIIIIlllIlIllIllIll, llllllllllllllIIIIlllIlIllIlllIl) -> {
            llllllllllllllIIIIlllIlIllIlllII = (byte)llllllllllllllIIIIlllIlIllIlllIl.getValue();
            if ((llllllllllllllIIIIlllIlIllIlllII & 0x4) != 0x0) {
                llllllllllllllIIIIlllIlIllIllIll.createExtraMeta(new Metadata(16, MetaType1_13_2.Boolean, true));
            }
            return;
        });
        this.filter().filterFamily(Entity1_14Types.ZOMBIE).addIndex(16);
        final int llllllllllllllIIIIlllIlIlllIlIII;
        Position llllllllllllllIIIIlllIlIlllIlIll;
        PacketWrapper llllllllllllllIIIIlllIlIlllIllII;
        this.filter().filterFamily(Entity1_14Types.LIVINGENTITY).handler((llllllllllllllIIIIlllIlIlllIlIlI, llllllllllllllIIIIlllIlIlllIlIIl) -> {
            llllllllllllllIIIIlllIlIlllIlIII = llllllllllllllIIIIlllIlIlllIlIlI.index();
            if (llllllllllllllIIIIlllIlIlllIlIII == 12) {
                llllllllllllllIIIIlllIlIlllIlIll = (Position)llllllllllllllIIIIlllIlIlllIlIIl.getValue();
                if (llllllllllllllIIIIlllIlIlllIlIll != null) {
                    llllllllllllllIIIIlllIlIlllIllII = PacketWrapper.create(ClientboundPackets1_13.USE_BED, null, llllllllllllllIIIIlllIlIlllIlIlI.user());
                    llllllllllllllIIIIlllIlIlllIllII.write(Type.VAR_INT, llllllllllllllIIIIlllIlIlllIlIlI.entityId());
                    llllllllllllllIIIIlllIlIlllIllII.write(Type.POSITION, llllllllllllllIIIIlllIlIlllIlIll);
                    try {
                        llllllllllllllIIIIlllIlIlllIllII.scheduleSend(Protocol1_13_2To1_14.class);
                    }
                    catch (Exception llllllllllllllIIIIlllIlIlllIllIl) {
                        llllllllllllllIIIIlllIlIlllIllIl.printStackTrace();
                    }
                }
                llllllllllllllIIIIlllIlIlllIlIlI.cancel();
            }
            else if (llllllllllllllIIIIlllIlIlllIlIII > 12) {
                llllllllllllllIIIIlllIlIlllIlIlI.setIndex(llllllllllllllIIIIlllIlIlllIlIII - 1);
            }
            return;
        });
        this.filter().removeIndex(6);
        this.filter().type(Entity1_14Types.OCELOT).index(13).handler((llllllllllllllIIIIlllIlIllllIlll, llllllllllllllIIIIlllIlIllllIlII) -> {
            llllllllllllllIIIIlllIlIllllIlll.setIndex(15);
            llllllllllllllIIIIlllIlIllllIlII.setTypeAndValue(MetaType1_13_2.VarInt, 0);
            return;
        });
        this.filter().type(Entity1_14Types.CAT).handler((llllllllllllllIIIIlllIlIlllllIll, llllllllllllllIIIIlllIlIllllllII) -> {
            if (llllllllllllllIIIIlllIlIlllllIll.index() == 15) {
                llllllllllllllIIIIlllIlIllllllII.setValue(1);
            }
            else if (llllllllllllllIIIIlllIlIlllllIll.index() == 13) {
                llllllllllllllIIIIlllIlIllllllII.setValue((byte)((byte)llllllllllllllIIIIlllIlIllllllII.getValue() & 0x4));
            }
        });
    }
}
