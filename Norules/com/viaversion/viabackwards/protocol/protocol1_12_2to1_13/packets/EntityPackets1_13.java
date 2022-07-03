package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.storage.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viabackwards.api.entities.storage.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.rewriter.meta.*;
import java.util.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_13 extends LegacyEntityRewriter<Protocol1_12_2To1_13>
{
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    private double toSet(final int lllllllllllllllllIlIllllllIlIlIl, final int lllllllllllllllllIlIllllllIllIII, final double lllllllllllllllllIlIllllllIlIlll, final double lllllllllllllllllIlIllllllIlIllI) {
                        return ((lllllllllllllllllIlIllllllIlIlIl & 1 << lllllllllllllllllIlIllllllIllIII) != 0x0) ? (lllllllllllllllllIlIllllllIlIlll + lllllllllllllllllIlIllllllIlIllI) : lllllllllllllllllIlIllllllIlIllI;
                    }
                    
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllIlIlllllllIIlIl) throws Exception {
                        if (!ViaBackwards.getConfig().isFix1_13FacePlayer()) {
                            return;
                        }
                        final PlayerPositionStorage1_13 lllllllllllllllllIlIlllllllIIlII = lllllllllllllllllIlIlllllllIIlIl.user().get(PlayerPositionStorage1_13.class);
                        final byte lllllllllllllllllIlIlllllllIIIll = lllllllllllllllllIlIlllllllIIlIl.get((Type<Byte>)Type.BYTE, 0);
                        lllllllllllllllllIlIlllllllIIlII.setX(this.toSet(lllllllllllllllllIlIlllllllIIIll, 0, lllllllllllllllllIlIlllllllIIlII.getX(), lllllllllllllllllIlIlllllllIIlIl.get((Type<Double>)Type.DOUBLE, 0)));
                        lllllllllllllllllIlIlllllllIIlII.setY(this.toSet(lllllllllllllllllIlIlllllllIIIll, 1, lllllllllllllllllIlIlllllllIIlII.getY(), lllllllllllllllllIlIlllllllIIlIl.get((Type<Double>)Type.DOUBLE, 1)));
                        lllllllllllllllllIlIlllllllIIlII.setZ(this.toSet(lllllllllllllllllIlIlllllllIIIll, 2, lllllllllllllllllIlIlllllllIIlII.getZ(), lllllllllllllllllIlIlllllllIIlIl.get((Type<Double>)Type.DOUBLE, 2)));
                    }
                });
            }
        });
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
                this.handler(LegacyEntityRewriter.this.getObjectTrackerHandler());
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIllllIlIlIIIlIIlI) throws Exception {
                        final Optional<Entity1_13Types.ObjectType> lllllllllllllIlIllllIlIlIIIlIlII = Entity1_13Types.ObjectType.findById(lllllllllllllIlIllllIlIlIIIlIIlI.get((Type<Byte>)Type.BYTE, 0));
                        if (!lllllllllllllIlIllllIlIlIIIlIlII.isPresent()) {
                            return;
                        }
                        final Entity1_13Types.ObjectType lllllllllllllIlIllllIlIlIIIlIIll = lllllllllllllIlIllllIlIlIIIlIlII.get();
                        if (lllllllllllllIlIllllIlIlIIIlIIll == Entity1_13Types.ObjectType.FALLING_BLOCK) {
                            final int lllllllllllllIlIllllIlIlIIIllIIl = lllllllllllllIlIllllIlIlIIIlIIlI.get((Type<Integer>)Type.INT, 0);
                            int lllllllllllllIlIllllIlIlIIIllIII = Protocol1_12_2To1_13.MAPPINGS.getNewBlockStateId(lllllllllllllIlIllllIlIlIIIllIIl);
                            lllllllllllllIlIllllIlIlIIIllIII = ((lllllllllllllIlIllllIlIlIIIllIII >> 4 & 0xFFF) | (lllllllllllllIlIllllIlIlIIIllIII & 0xF) << 12);
                            lllllllllllllIlIllllIlIlIIIlIIlI.set(Type.INT, 0, lllllllllllllIlIllllIlIlIIIllIII);
                        }
                        else if (lllllllllllllIlIllllIlIlIIIlIIll == Entity1_13Types.ObjectType.ITEM_FRAME) {
                            int lllllllllllllIlIllllIlIlIIIlIlll = lllllllllllllIlIllllIlIlIIIlIIlI.get((Type<Integer>)Type.INT, 0);
                            switch (lllllllllllllIlIllllIlIlIIIlIlll) {
                                case 3: {
                                    lllllllllllllIlIllllIlIlIIIlIlll = 0;
                                    break;
                                }
                                case 4: {
                                    lllllllllllllIlIllllIlIlIIIlIlll = 1;
                                    break;
                                }
                                case 5: {
                                    lllllllllllllIlIllllIlIlIIIlIlll = 3;
                                    break;
                                }
                            }
                            lllllllllllllIlIllllIlIlIIIlIIlI.set(Type.INT, 0, lllllllllllllIlIllllIlIlIIIlIlll);
                        }
                        else if (lllllllllllllIlIllllIlIlIIIlIIll == Entity1_13Types.ObjectType.TRIDENT) {
                            lllllllllllllIlIllllIlIlIIIlIIlI.set(Type.BYTE, 0, (byte)Entity1_13Types.ObjectType.TIPPED_ARROW.getId());
                        }
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
                this.map(Types1_13.METADATA_LIST, Types1_12.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIIIIIllIIlIlIllI) throws Exception {
                        final int llllllllllllllIlIIIIIllIIlIlIlIl = llllllllllllllIlIIIIIllIIlIlIllI.get((Type<Integer>)Type.VAR_INT, 1);
                        final EntityType llllllllllllllIlIIIIIllIIlIlIlII = Entity1_13Types.getTypeFromId(llllllllllllllIlIIIIIllIIlIlIlIl, false);
                        EntityPackets1_13.this.tracker(llllllllllllllIlIIIIIllIIlIlIllI.user()).addEntity(llllllllllllllIlIIIIIllIIlIlIllI.get((Type<Integer>)Type.VAR_INT, 0), llllllllllllllIlIIIIIllIIlIlIlII);
                        final int llllllllllllllIlIIIIIllIIlIlIIll = EntityTypeMapping.getOldId(llllllllllllllIlIIIIIllIIlIlIlIl);
                        if (llllllllllllllIlIIIIIllIIlIlIIll == -1) {
                            if (!EntityRewriterBase.this.hasData(llllllllllllllIlIIIIIllIIlIlIlII)) {
                                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Could not find 1.12 entity type for 1.13 entity type ").append(llllllllllllllIlIIIIIllIIlIlIlIl).append("/").append(llllllllllllllIlIIIIIllIIlIlIlII)));
                            }
                        }
                        else {
                            llllllllllllllIlIIIIIllIIlIlIllI.set(Type.VAR_INT, 1, llllllllllllllIlIIIIIllIIlIlIIll);
                        }
                    }
                });
                this.handler(LegacyEntityRewriter.this.getMobSpawnRewriter(Types1_12.METADATA_LIST));
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
                this.map(Types1_13.METADATA_LIST, Types1_12.METADATA_LIST);
                this.handler(LegacyEntityRewriter.this.getTrackerAndMetaHandler(Types1_12.METADATA_LIST, Entity1_13Types.EntityType.PLAYER));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.SPAWN_PAINTING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.handler(EntityRewriterBase.this.getTrackerHandler(Entity1_13Types.EntityType.PAINTING, Type.VAR_INT));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIllllllIlIlIIlI) throws Exception {
                        final int llllllllllllllIllIllllllIlIlIIIl = llllllllllllllIllIllllllIlIlIIlI.read((Type<Integer>)Type.VAR_INT);
                        final String llllllllllllllIllIllllllIlIlIIII = PaintingMapping.getStringId(llllllllllllllIllIllllllIlIlIIIl);
                        llllllllllllllIllIllllllIlIlIIlI.write(Type.STRING, llllllllllllllIllIllllllIlIlIIII);
                    }
                });
            }
        });
        this.registerJoinGame(ClientboundPackets1_13.JOIN_GAME, Entity1_13Types.EntityType.PLAYER);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.handler(EntityRewriterBase.this.getDimensionHandler(0));
                this.handler(llllllllllllllIIIlllIllIllIIlIlI -> llllllllllllllIIIlllIllIllIIlIlI.user().get(BackwardsBlockStorage.class).clear());
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_13.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_13.ENTITY_METADATA, Types1_13.METADATA_LIST, Types1_12.METADATA_LIST);
        ((Protocol<ClientboundPackets1_13, ClientboundPackets1_12_1, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.FACE_PLAYER, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIIlIllllllIIIlll) throws Exception {
                        lllllllllllllIllIIlIllllllIIIlll.cancel();
                        if (!ViaBackwards.getConfig().isFix1_13FacePlayer()) {
                            return;
                        }
                        final int lllllllllllllIllIIlIllllllIIIllI = lllllllllllllIllIIlIllllllIIIlll.read((Type<Integer>)Type.VAR_INT);
                        final double lllllllllllllIllIIlIllllllIIIlIl = lllllllllllllIllIIlIllllllIIIlll.read((Type<Double>)Type.DOUBLE);
                        final double lllllllllllllIllIIlIllllllIIIlII = lllllllllllllIllIIlIllllllIIIlll.read((Type<Double>)Type.DOUBLE);
                        final double lllllllllllllIllIIlIllllllIIIIll = lllllllllllllIllIIlIllllllIIIlll.read((Type<Double>)Type.DOUBLE);
                        final PlayerPositionStorage1_13 lllllllllllllIllIIlIllllllIIIIlI = lllllllllllllIllIIlIllllllIIIlll.user().get(PlayerPositionStorage1_13.class);
                        final PacketWrapper lllllllllllllIllIIlIllllllIIIIIl = lllllllllllllIllIIlIllllllIIIlll.create(ClientboundPackets1_12_1.PLAYER_POSITION);
                        lllllllllllllIllIIlIllllllIIIIIl.write(Type.DOUBLE, 0.0);
                        lllllllllllllIllIIlIllllllIIIIIl.write(Type.DOUBLE, 0.0);
                        lllllllllllllIllIIlIllllllIIIIIl.write(Type.DOUBLE, 0.0);
                        EntityPositionHandler.writeFacingDegrees(lllllllllllllIllIIlIllllllIIIIIl, lllllllllllllIllIIlIllllllIIIIlI.getX(), (lllllllllllllIllIIlIllllllIIIllI == 1) ? (lllllllllllllIllIIlIllllllIIIIlI.getY() + 1.62) : lllllllllllllIllIIlIllllllIIIIlI.getY(), lllllllllllllIllIIlIllllllIIIIlI.getZ(), lllllllllllllIllIIlIllllllIIIlIl, lllllllllllllIllIIlIllllllIIIlII, lllllllllllllIllIIlIllllllIIIIll);
                        lllllllllllllIllIIlIllllllIIIIIl.write(Type.BYTE, (Byte)7);
                        lllllllllllllIllIIlIllllllIIIIIl.write(Type.VAR_INT, -1);
                        lllllllllllllIllIIlIllllllIIIIIl.send(Protocol1_12_2To1_13.class);
                    }
                });
            }
        });
        if (ViaBackwards.getConfig().isFix1_13FacePlayer()) {
            final PacketRemapper lllllllllllllIIIIllIllllIlIIIIII = new PacketRemapper() {
                @Override
                public void registerMap() {
                    this.map(Type.DOUBLE);
                    this.map(Type.DOUBLE);
                    this.map(Type.DOUBLE);
                    this.handler(lllllllllllllIIIIlIllIIIllllIIll -> lllllllllllllIIIIlIllIIIllllIIll.user().get(PlayerPositionStorage1_13.class).setCoordinates(lllllllllllllIIIIlIllIIIllllIIll, false));
                }
            };
            ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this.protocol).registerServerbound(ServerboundPackets1_12_1.PLAYER_POSITION, lllllllllllllIIIIllIllllIlIIIIII);
            ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this.protocol).registerServerbound(ServerboundPackets1_12_1.PLAYER_POSITION_AND_ROTATION, lllllllllllllIIIIllIllllIlIIIIII);
            ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this.protocol).registerServerbound(ServerboundPackets1_12_1.VEHICLE_MOVE, lllllllllllllIIIIllIllllIlIIIIII);
        }
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIIIIllIllllIIllIlll) {
        return Entity1_13Types.getTypeFromId(lllllllllllllIIIIllIllllIIllIlll, false);
    }
    
    @Override
    protected EntityType getObjectTypeFromId(final int lllllllllllllIIIIllIllllIIllIIll) {
        return Entity1_13Types.getTypeFromId(lllllllllllllIIIIllIllllIIllIIll, true);
    }
    
    @Override
    public int newEntityId(final int lllllllllllllIIIIllIllllIIlIllll) {
        return EntityTypeMapping.getOldId(lllllllllllllIIIIllIllllIIlIllll);
    }
    
    public EntityPackets1_13(final Protocol1_12_2To1_13 lllllllllllllIIIIllIllllIlIIIIll) {
        super(lllllllllllllIIIIllIllllIlIIIIll);
    }
    
    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(Entity1_13Types.EntityType.DROWNED, Entity1_13Types.EntityType.ZOMBIE_VILLAGER).mobName("Drowned");
        this.mapEntityTypeWithData(Entity1_13Types.EntityType.COD, Entity1_13Types.EntityType.SQUID).mobName("Cod");
        this.mapEntityTypeWithData(Entity1_13Types.EntityType.SALMON, Entity1_13Types.EntityType.SQUID).mobName("Salmon");
        this.mapEntityTypeWithData(Entity1_13Types.EntityType.PUFFERFISH, Entity1_13Types.EntityType.SQUID).mobName("Puffer Fish");
        this.mapEntityTypeWithData(Entity1_13Types.EntityType.TROPICAL_FISH, Entity1_13Types.EntityType.SQUID).mobName("Tropical Fish");
        this.mapEntityTypeWithData(Entity1_13Types.EntityType.PHANTOM, Entity1_13Types.EntityType.PARROT).mobName("Phantom").spawnMetadata(lllllllllllllIIIIllIlllIlllllIIl -> lllllllllllllIIIIllIlllIlllllIIl.add(new Metadata(15, MetaType1_12.VarInt, 3)));
        this.mapEntityTypeWithData(Entity1_13Types.EntityType.DOLPHIN, Entity1_13Types.EntityType.SQUID).mobName("Dolphin");
        this.mapEntityTypeWithData(Entity1_13Types.EntityType.TURTLE, Entity1_13Types.EntityType.OCELOT).mobName("Turtle");
        final int lllllllllllllIIIIllIllllIIIIIIIl;
        Item lllllllllllllIIIIllIllllIIIIIlIl;
        this.filter().handler((lllllllllllllIIIIllIllllIIIIIIll, lllllllllllllIIIIllIllllIIIIIIlI) -> {
            lllllllllllllIIIIllIllllIIIIIIIl = lllllllllllllIIIIllIllllIIIIIIlI.metaType().typeId();
            if (lllllllllllllIIIIllIllllIIIIIIIl == 5) {
                lllllllllllllIIIIllIllllIIIIIIlI.setTypeAndValue(MetaType1_12.String, (lllllllllllllIIIIllIllllIIIIIIlI.getValue() != null) ? lllllllllllllIIIIllIllllIIIIIIlI.getValue().toString() : "");
            }
            else if (lllllllllllllIIIIllIllllIIIIIIIl == 6) {
                lllllllllllllIIIIllIllllIIIIIlIl = (Item)lllllllllllllIIIIllIllllIIIIIIlI.getValue();
                lllllllllllllIIIIllIllllIIIIIIlI.setTypeAndValue(MetaType1_12.Slot, ((Protocol1_12_2To1_13)this.protocol).getItemRewriter().handleItemToClient(lllllllllllllIIIIllIllllIIIIIlIl));
            }
            else if (lllllllllllllIIIIllIllllIIIIIIIl == 15) {
                lllllllllllllIIIIllIllllIIIIIIll.cancel();
            }
            else if (lllllllllllllIIIIllIllllIIIIIIIl > 5) {
                lllllllllllllIIIIllIllllIIIIIIlI.setMetaType(MetaType1_12.byId(lllllllllllllIIIIllIllllIIIIIIIl - 1));
            }
            return;
        });
        final String lllllllllllllIIIIllIllllIIIIllIl;
        this.filter().filterFamily(Entity1_13Types.EntityType.ENTITY).index(2).handler((lllllllllllllIIIIllIllllIIIIllll, lllllllllllllIIIIllIllllIIIIllII) -> {
            lllllllllllllIIIIllIllllIIIIllIl = lllllllllllllIIIIllIllllIIIIllII.getValue().toString();
            if (!lllllllllllllIIIIllIllllIIIIllIl.isEmpty()) {
                lllllllllllllIIIIllIllllIIIIllII.setValue(ChatRewriter.jsonToLegacyText(lllllllllllllIIIIllIllllIIIIllIl));
            }
            return;
        });
        this.filter().filterFamily(Entity1_13Types.EntityType.ZOMBIE).removeIndex(15);
        this.filter().type(Entity1_13Types.EntityType.TURTLE).cancel(13);
        this.filter().type(Entity1_13Types.EntityType.TURTLE).cancel(14);
        this.filter().type(Entity1_13Types.EntityType.TURTLE).cancel(15);
        this.filter().type(Entity1_13Types.EntityType.TURTLE).cancel(16);
        this.filter().type(Entity1_13Types.EntityType.TURTLE).cancel(17);
        this.filter().type(Entity1_13Types.EntityType.TURTLE).cancel(18);
        this.filter().filterFamily(Entity1_13Types.EntityType.ABSTRACT_FISHES).cancel(12);
        this.filter().filterFamily(Entity1_13Types.EntityType.ABSTRACT_FISHES).cancel(13);
        this.filter().type(Entity1_13Types.EntityType.PHANTOM).cancel(12);
        this.filter().type(Entity1_13Types.EntityType.BOAT).cancel(12);
        this.filter().type(Entity1_13Types.EntityType.TRIDENT).cancel(7);
        this.filter().type(Entity1_13Types.EntityType.WOLF).index(17).handler((lllllllllllllIIIIllIllllIIIlIlII, lllllllllllllIIIIllIllllIIIlIIlI) -> lllllllllllllIIIIllIllllIIIlIIlI.setValue(15 - (int)lllllllllllllIIIIllIllllIIIlIIlI.getValue()));
        final Particle lllllllllllllIIIIllIllllIIlIIIlI;
        final ParticleMapping.ParticleData lllllllllllllIIIIllIllllIIlIIIIl;
        int lllllllllllllIIIIllIllllIIlIIIII;
        int lllllllllllllIIIIllIllllIIIlllll;
        final int[] lllllllllllllIIIIllIllllIIIllllI;
        this.filter().type(Entity1_13Types.EntityType.AREA_EFFECT_CLOUD).index(9).handler((lllllllllllllIIIIllIllllIIlIIlII, lllllllllllllIIIIllIllllIIIllIll) -> {
            lllllllllllllIIIIllIllllIIlIIIlI = (Particle)lllllllllllllIIIIllIllllIIIllIll.getValue();
            lllllllllllllIIIIllIllllIIlIIIIl = ParticleMapping.getMapping(lllllllllllllIIIIllIllllIIlIIIlI.getId());
            lllllllllllllIIIIllIllllIIlIIIII = 0;
            lllllllllllllIIIIllIllllIIIlllll = 0;
            lllllllllllllIIIIllIllllIIIllllI = lllllllllllllIIIIllIllllIIlIIIIl.rewriteMeta((Protocol1_12_2To1_13)this.protocol, lllllllllllllIIIIllIllllIIlIIIlI.getArguments());
            if (lllllllllllllIIIIllIllllIIIllllI != null && lllllllllllllIIIIllIllllIIIllllI.length != 0) {
                if (lllllllllllllIIIIllIllllIIlIIIIl.getHandler().isBlockHandler() && lllllllllllllIIIIllIllllIIIllllI[0] == 0) {
                    lllllllllllllIIIIllIllllIIIllllI[0] = 102;
                }
                lllllllllllllIIIIllIllllIIlIIIII = lllllllllllllIIIIllIllllIIIllllI[0];
                lllllllllllllIIIIllIllllIIIlllll = ((lllllllllllllIIIIllIllllIIIllllI.length == 2) ? lllllllllllllIIIIllIllllIIIllllI[1] : 0);
            }
            lllllllllllllIIIIllIllllIIlIIlII.createExtraMeta(new Metadata(9, MetaType1_12.VarInt, lllllllllllllIIIIllIllllIIlIIIIl.getHistoryId()));
            lllllllllllllIIIIllIllllIIlIIlII.createExtraMeta(new Metadata(10, MetaType1_12.VarInt, lllllllllllllIIIIllIllllIIlIIIII));
            lllllllllllllIIIIllIllllIIlIIlII.createExtraMeta(new Metadata(11, MetaType1_12.VarInt, lllllllllllllIIIIllIllllIIIlllll));
            lllllllllllllIIIIllIllllIIlIIlII.cancel();
        });
    }
}
