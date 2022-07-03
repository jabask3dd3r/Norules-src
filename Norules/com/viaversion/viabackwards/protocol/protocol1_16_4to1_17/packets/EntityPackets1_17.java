package com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public final class EntityPackets1_17 extends EntityRewriter<Protocol1_16_4To1_17>
{
    public EntityPackets1_17(final Protocol1_16_4To1_17 lllllllllllllIllIlIlllIIIlllIlll) {
        super(lllllllllllllIllIlIlllIIIlllIlll);
    }
    
    private void reduceExtendedHeight(final CompoundTag lllllllllllllIllIlIlllIIIlIIIllI, final boolean lllllllllllllIllIlIlllIIIlIIIIII) {
        final IntTag lllllllllllllIllIlIlllIIIlIIIlII = lllllllllllllIllIlIlllIIIlIIIllI.get("min_y");
        final IntTag lllllllllllllIllIlIlllIIIlIIIIll = lllllllllllllIllIlIlllIIIlIIIllI.get("height");
        final IntTag lllllllllllllIllIlIlllIIIlIIIIlI = lllllllllllllIllIlIlllIIIlIIIllI.get("logical_height");
        if (lllllllllllllIllIlIlllIIIlIIIlII.asInt() != 0 || lllllllllllllIllIlIlllIIIlIIIIll.asInt() > 256 || lllllllllllllIllIlIlllIIIlIIIIlI.asInt() > 256) {
            if (lllllllllllllIllIlIlllIIIlIIIIII) {
                ViaBackwards.getPlatform().getLogger().severe("Custom worlds heights are NOT SUPPORTED for 1.16 players and older and may lead to errors!");
                ViaBackwards.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("You have min/max set to ").append(lllllllllllllIllIlIlllIIIlIIIlII.asInt()).append("/").append(lllllllllllllIllIlIlllIIIlIIIIll.asInt())));
            }
            lllllllllllllIllIlIlllIIIlIIIIll.setValue(Math.min(256, lllllllllllllIllIlIlllIIIlIIIIll.asInt()));
            lllllllllllllIllIlIlllIIIlIIIIlI.setValue(Math.min(256, lllllllllllllIllIlIlllIIIlIIIIlI.asInt()));
        }
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIllIlIlllIIIlIlIllI) {
        return Entity1_17Types.getTypeFromId(lllllllllllllIllIlIlllIIIlIlIllI);
    }
    
    @Override
    protected void registerRewrites() {
        final MetaType lllllllllllllIllIlIlllIIIIlIIIlI;
        Particle lllllllllllllIllIlIlllIIIIlIIlll;
        int lllllllllllllIllIlIlllIIIIlIIllI;
        this.filter().handler((lllllllllllllIllIlIlllIIIIlIIlII, lllllllllllllIllIlIlllIIIIlIIIll) -> {
            lllllllllllllIllIlIlllIIIIlIIIll.setMetaType(MetaType1_16.byId(lllllllllllllIllIlIlllIIIIlIIIll.metaType().typeId()));
            lllllllllllllIllIlIlllIIIIlIIIlI = lllllllllllllIllIlIlllIIIIlIIIll.metaType();
            if (lllllllllllllIllIlIlllIIIIlIIIlI == MetaType1_16.PARTICLE) {
                lllllllllllllIllIlIlllIIIIlIIlll = (Particle)lllllllllllllIllIlIlllIIIIlIIIll.getValue();
                if (lllllllllllllIllIlIlllIIIIlIIlll.getId() == 15) {
                    lllllllllllllIllIlIlllIIIIlIIlll.getArguments().subList(4, 7).clear();
                }
                else if (lllllllllllllIllIlIlllIIIIlIIlll.getId() == 36) {
                    lllllllllllllIllIlIlllIIIIlIIlll.setId(0);
                    lllllllllllllIllIlIlllIIIIlIIlll.getArguments().clear();
                    return;
                }
                this.rewriteParticle(lllllllllllllIllIlIlllIIIIlIIlll);
            }
            else if (lllllllllllllIllIlIlllIIIIlIIIlI == MetaType1_16.POSE) {
                lllllllllllllIllIlIlllIIIIlIIllI = (int)lllllllllllllIllIlIlllIIIIlIIIll.value();
                if (lllllllllllllIllIlIlllIIIIlIIllI == 6) {
                    lllllllllllllIllIlIlllIIIIlIIIll.setValue(1);
                }
                else if (lllllllllllllIllIlIlllIIIIlIIllI > 6) {
                    lllllllllllllIllIlIlllIIIIlIIIll.setValue(lllllllllllllIllIlIlllIIIIlIIllI - 1);
                }
            }
            return;
        });
        this.registerMetaTypeHandler(MetaType1_16.ITEM, MetaType1_16.BLOCK_STATE, null, MetaType1_16.OPT_COMPONENT);
        this.mapTypes(Entity1_17Types.values(), Entity1_16_2Types.class);
        this.filter().type(Entity1_17Types.AXOLOTL).cancel(17);
        this.filter().type(Entity1_17Types.AXOLOTL).cancel(18);
        this.filter().type(Entity1_17Types.AXOLOTL).cancel(19);
        this.filter().type(Entity1_17Types.GLOW_SQUID).cancel(16);
        this.filter().type(Entity1_17Types.GOAT).cancel(17);
        this.mapEntityTypeWithData(Entity1_17Types.AXOLOTL, Entity1_17Types.TROPICAL_FISH).jsonName("Axolotl");
        this.mapEntityTypeWithData(Entity1_17Types.GOAT, Entity1_17Types.SHEEP).jsonName("Goat");
        this.mapEntityTypeWithData(Entity1_17Types.GLOW_SQUID, Entity1_17Types.SQUID).jsonName("Glow Squid");
        this.mapEntityTypeWithData(Entity1_17Types.GLOW_ITEM_FRAME, Entity1_17Types.ITEM_FRAME);
        this.filter().type(Entity1_17Types.SHULKER).addIndex(17);
        this.filter().removeIndex(7);
    }
    
    @Override
    protected void registerPackets() {
        this.registerTrackerWithData(ClientboundPackets1_17.SPAWN_ENTITY, Entity1_17Types.FALLING_BLOCK);
        this.registerSpawnTracker(ClientboundPackets1_17.SPAWN_MOB);
        this.registerTracker(ClientboundPackets1_17.SPAWN_EXPERIENCE_ORB, Entity1_17Types.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_17.SPAWN_PAINTING, Entity1_17Types.PAINTING);
        this.registerTracker(ClientboundPackets1_17.SPAWN_PLAYER, Entity1_17Types.PLAYER);
        this.registerMetadataRewriter(ClientboundPackets1_17.ENTITY_METADATA, Types1_17.METADATA_LIST, Types1_16.METADATA_LIST);
        ((Protocol<ClientboundPackets1_17, ClientboundPackets1_16_2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.REMOVE_ENTITY, ClientboundPackets1_16_2.DESTROY_ENTITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIlIIIIlIlIIlIIlllII;
                final int[] lllllllllllllIlIIIIlIlIIlIIllIll;
                this.handler(lllllllllllllIlIIIIlIlIIlIIllIIl -> {
                    lllllllllllllIlIIIIlIlIIlIIlllII = lllllllllllllIlIIIIlIlIIlIIllIIl.read((Type<Integer>)Type.VAR_INT);
                    ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)EntityPackets1_17.this).tracker(lllllllllllllIlIIIIlIlIIlIIllIIl.user()).removeEntity(lllllllllllllIlIIIIlIlIIlIIlllII);
                    lllllllllllllIlIIIIlIlIIlIIllIll = new int[] { lllllllllllllIlIIIIlIlIIlIIlllII };
                    lllllllllllllIlIIIIlIlIIlIIllIIl.write(Type.VAR_INT_ARRAY_PRIMITIVE, lllllllllllllIlIIIIlIlIIlIIllIll);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BYTE);
                this.map(Type.STRING_ARRAY);
                this.map(Type.NBT);
                this.map(Type.NBT);
                final byte lllllllllllllIIIIIIllIlIIlllIIIl;
                this.handler(lllllllllllllIIIIIIllIlIIlllIIII -> {
                    lllllllllllllIIIIIIllIlIIlllIIIl = lllllllllllllIIIIIIllIlIIlllIIII.get((Type<Byte>)Type.BYTE, 0);
                    if (lllllllllllllIIIIIIllIlIIlllIIIl == -1) {
                        lllllllllllllIIIIIIllIlIIlllIIII.set(Type.BYTE, 0, (Byte)0);
                    }
                    return;
                });
                this.handler(EntityRewriterBase.this.getTrackerHandler(Entity1_17Types.PLAYER, Type.INT));
                this.handler(com.viaversion.viaversion.rewriter.EntityRewriter.this.worldDataTrackerHandler(1));
                final CompoundTag lllllllllllllIIIIIIllIlIlIIIIIll;
                final CompoundTag lllllllllllllIIIIIIllIlIlIIIIIlI;
                final ListTag lllllllllllllIIIIIIllIlIlIIIIIIl;
                final short lllllllllllllIIIIIIllIlIIllllIIl;
                Tag lllllllllllllIIIIIIllIlIlIIIlIII;
                CompoundTag lllllllllllllIIIIIIllIlIlIIIlIlI;
                StringTag lllllllllllllIIIIIIllIlIlIIIlIIl;
                final CompoundTag lllllllllllllIIIIIIllIlIlIIIIIII;
                final ListTag lllllllllllllIIIIIIllIlIIlllllll;
                final boolean lllllllllllllIIIIIIllIlIIlllIlll;
                Tag lllllllllllllIIIIIIllIlIlIIIIllI;
                CompoundTag lllllllllllllIIIIIIllIlIlIIIIlll;
                this.handler(lllllllllllllIIIIIIllIlIIlllllIl -> {
                    lllllllllllllIIIIIIllIlIlIIIIIll = lllllllllllllIIIIIIllIlIIlllllIl.get(Type.NBT, 0);
                    lllllllllllllIIIIIIllIlIlIIIIIlI = lllllllllllllIIIIIIllIlIlIIIIIll.get("minecraft:worldgen/biome");
                    lllllllllllllIIIIIIllIlIlIIIIIIl = lllllllllllllIIIIIIllIlIlIIIIIlI.get("value");
                    lllllllllllllIIIIIIllIlIIllllIIl = (short)lllllllllllllIIIIIIllIlIlIIIIIIl.iterator();
                    while (((Iterator)lllllllllllllIIIIIIllIlIIllllIIl).hasNext()) {
                        lllllllllllllIIIIIIllIlIlIIIlIII = ((Iterator<Tag>)lllllllllllllIIIIIIllIlIIllllIIl).next();
                        lllllllllllllIIIIIIllIlIlIIIlIlI = ((CompoundTag)lllllllllllllIIIIIIllIlIlIIIlIII).get("element");
                        lllllllllllllIIIIIIllIlIlIIIlIIl = lllllllllllllIIIIIIllIlIlIIIlIlI.get("category");
                        if (lllllllllllllIIIIIIllIlIlIIIlIIl.getValue().equalsIgnoreCase("underground")) {
                            lllllllllllllIIIIIIllIlIlIIIlIIl.setValue("none");
                        }
                    }
                    lllllllllllllIIIIIIllIlIlIIIIIII = lllllllllllllIIIIIIllIlIlIIIIIll.get("minecraft:dimension_type");
                    lllllllllllllIIIIIIllIlIIlllllll = lllllllllllllIIIIIIllIlIlIIIIIII.get("value");
                    lllllllllllllIIIIIIllIlIIlllIlll = (boolean)lllllllllllllIIIIIIllIlIIlllllll.iterator();
                    while (((Iterator)lllllllllllllIIIIIIllIlIIlllIlll).hasNext()) {
                        lllllllllllllIIIIIIllIlIlIIIIllI = ((Iterator<Tag>)lllllllllllllIIIIIIllIlIIlllIlll).next();
                        lllllllllllllIIIIIIllIlIlIIIIlll = ((CompoundTag)lllllllllllllIIIIIIllIlIlIIIIllI).get("element");
                        EntityPackets1_17.this.reduceExtendedHeight(lllllllllllllIIIIIIllIlIlIIIIlll, false);
                    }
                    EntityPackets1_17.this.reduceExtendedHeight(lllllllllllllIIIIIIllIlIIlllllIl.get(Type.NBT, 1), true);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.NBT);
                this.handler(com.viaversion.viaversion.rewriter.EntityRewriter.this.worldDataTrackerHandler(0));
                this.handler(lllllllllllllIlIlIIIIIlIIIlIlIII -> EntityPackets1_17.this.reduceExtendedHeight(lllllllllllllIlIlIIIIIlIIIlIlIII.get(Type.NBT, 0), true));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.PLAYER_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllllIIIIlIlIIlllIllII -> lllllllllllllllIIIIlIlIIlllIllII.read((Type<Object>)Type.BOOLEAN));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllllIllIllIllIlIlIIll -> lllllllllllllllIllIllIllIlIlIIll.write(Type.INT, (Integer)lllllllllllllllIllIllIllIlIlIIll.read((Type<T>)Type.VAR_INT)));
            }
        });
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.COMBAT_ENTER, ClientboundPackets1_16_2.COMBAT_EVENT, 0);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.COMBAT_END, ClientboundPackets1_16_2.COMBAT_EVENT, 1);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.COMBAT_KILL, ClientboundPackets1_16_2.COMBAT_EVENT, 2);
    }
}
