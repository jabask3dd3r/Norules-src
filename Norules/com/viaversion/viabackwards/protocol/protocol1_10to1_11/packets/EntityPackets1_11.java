package com.viaversion.viabackwards.protocol.protocol1_10to1_11.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viabackwards.protocol.protocol1_10to1_11.storage.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viabackwards.protocol.protocol1_10to1_11.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viabackwards.utils.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.types.version.*;
import java.util.*;
import com.viaversion.viabackwards.api.entities.storage.*;
import java.util.function.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.rewriter.*;

public class EntityPackets1_11 extends LegacyEntityRewriter<Protocol1_10To1_11>
{
    private Metadata getSkeletonTypeMeta(final int llllllllllllllllIIIIIIIIllllIllI) {
        return new Metadata(12, MetaType1_9.VarInt, llllllllllllllllIIIIIIIIllllIllI);
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllllIIIIIIIIllIllllI) {
        return Entity1_11Types.getTypeFromId(llllllllllllllllIIIIIIIIllIllllI, false);
    }
    
    public EntityPackets1_11(final Protocol1_10To1_11 llllllllllllllllIIIIIIIlIIIIIIlI) {
        super(llllllllllllllllIIIIIIIlIIIIIIlI);
    }
    
    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.ELDER_GUARDIAN, Entity1_11Types.EntityType.GUARDIAN);
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.WITHER_SKELETON, Entity1_11Types.EntityType.SKELETON).mobName("Wither Skeleton").spawnMetadata(llllllllllllllllIIIIIIIIIIlllIlI -> llllllllllllllllIIIIIIIIIIlllIlI.add(this.getSkeletonTypeMeta(1)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.STRAY, Entity1_11Types.EntityType.SKELETON).mobName("Stray").spawnMetadata(llllllllllllllllIIIIIIIIIlIIIIII -> llllllllllllllllIIIIIIIIIlIIIIII.add(this.getSkeletonTypeMeta(2)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.HUSK, Entity1_11Types.EntityType.ZOMBIE).mobName("Husk").spawnMetadata(llllllllllllllllIIIIIIIIIlIIIllI -> this.handleZombieType(llllllllllllllllIIIIIIIIIlIIIllI, 6));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.ZOMBIE_VILLAGER, Entity1_11Types.EntityType.ZOMBIE).spawnMetadata(llllllllllllllllIIIIIIIIIlIIlIlI -> this.handleZombieType(llllllllllllllllIIIIIIIIIlIIlIlI, 1));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.HORSE, Entity1_11Types.EntityType.HORSE).spawnMetadata(llllllllllllllllIIIIIIIIIlIlIIlI -> llllllllllllllllIIIIIIIIIlIlIIlI.add(this.getHorseMetaType(0)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.DONKEY, Entity1_11Types.EntityType.HORSE).spawnMetadata(llllllllllllllllIIIIIIIIIlIlIllI -> llllllllllllllllIIIIIIIIIlIlIllI.add(this.getHorseMetaType(1)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.MULE, Entity1_11Types.EntityType.HORSE).spawnMetadata(llllllllllllllllIIIIIIIIIlIllllI -> llllllllllllllllIIIIIIIIIlIllllI.add(this.getHorseMetaType(2)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.SKELETON_HORSE, Entity1_11Types.EntityType.HORSE).spawnMetadata(llllllllllllllllIIIIIIIIIllIIlII -> llllllllllllllllIIIIIIIIIllIIlII.add(this.getHorseMetaType(4)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.ZOMBIE_HORSE, Entity1_11Types.EntityType.HORSE).spawnMetadata(llllllllllllllllIIIIIIIIIllIlIII -> llllllllllllllllIIIIIIIIIllIlIII.add(this.getHorseMetaType(3)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.EVOCATION_FANGS, Entity1_11Types.EntityType.SHULKER);
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.EVOCATION_ILLAGER, Entity1_11Types.EntityType.VILLAGER).mobName("Evoker");
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.VEX, Entity1_11Types.EntityType.BAT).mobName("Vex");
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.VINDICATION_ILLAGER, Entity1_11Types.EntityType.VILLAGER).mobName("Vindicator").spawnMetadata(llllllllllllllllIIIIIIIIIllIllll -> llllllllllllllllIIIIIIIIIllIllll.add(new Metadata(13, MetaType1_9.VarInt, 4)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.LIAMA, Entity1_11Types.EntityType.HORSE).mobName("Llama").spawnMetadata(llllllllllllllllIIIIIIIIIlllIIIl -> llllllllllllllllIIIIIIIIIlllIIIl.add(this.getHorseMetaType(1)));
        this.mapEntityTypeWithData(Entity1_11Types.EntityType.LIAMA_SPIT, Entity1_11Types.EntityType.SNOWBALL);
        this.mapObjectType(Entity1_11Types.ObjectType.LIAMA_SPIT, Entity1_11Types.ObjectType.SNOWBALL, -1);
        this.mapObjectType(Entity1_11Types.ObjectType.EVOCATION_FANGS, Entity1_11Types.ObjectType.FALLING_BLOCK, 4294);
        final boolean llllllllllllllllIIIIIIIIIlllllII;
        int llllllllllllllllIIIIIIIIIllllIll;
        this.filter().filterFamily(Entity1_11Types.EntityType.GUARDIAN).index(12).handler((llllllllllllllllIIIIIIIIIllllllI, llllllllllllllllIIIIIIIIIlllllIl) -> {
            llllllllllllllllIIIIIIIIIlllllII = (boolean)llllllllllllllllIIIIIIIIIlllllIl.getValue();
            llllllllllllllllIIIIIIIIIllllIll = (llllllllllllllllIIIIIIIIIlllllII ? 2 : 0);
            if (llllllllllllllllIIIIIIIIIllllllI.entityType() == Entity1_11Types.EntityType.ELDER_GUARDIAN) {
                llllllllllllllllIIIIIIIIIllllIll |= 0x4;
            }
            llllllllllllllllIIIIIIIIIlllllIl.setTypeAndValue(MetaType1_9.Byte, (byte)llllllllllllllllIIIIIIIIIllllIll);
            return;
        });
        this.filter().filterFamily(Entity1_11Types.EntityType.ABSTRACT_SKELETON).index(12).toIndex(13);
        this.filter().filterFamily(Entity1_11Types.EntityType.ZOMBIE).handler((llllllllllllllllIIIIIIIIlIIIIlII, llllllllllllllllIIIIIIIIlIIIIIll) -> {
            switch (llllllllllllllllIIIIIIIIlIIIIIll.id()) {
                case 13: {
                    llllllllllllllllIIIIIIIIlIIIIlII.cancel();
                }
                case 14: {
                    llllllllllllllllIIIIIIIIlIIIIlII.setIndex(15);
                    break;
                }
                case 15: {
                    llllllllllllllllIIIIIIIIlIIIIlII.setIndex(14);
                    break;
                }
                case 16: {
                    llllllllllllllllIIIIIIIIlIIIIlII.setIndex(13);
                    llllllllllllllllIIIIIIIIlIIIIIll.setValue(1 + (int)llllllllllllllllIIIIIIIIlIIIIIll.getValue());
                    break;
                }
            }
            return;
        });
        this.filter().type(Entity1_11Types.EntityType.EVOCATION_ILLAGER).index(12).handler((llllllllllllllllIIIIIIIIlIIIlIlI, llllllllllllllllIIIIIIIIlIIIlIll) -> {
            llllllllllllllllIIIIIIIIlIIIlIlI.setIndex(13);
            llllllllllllllllIIIIIIIIlIIIlIll.setTypeAndValue(MetaType1_9.VarInt, (int)llllllllllllllllIIIIIIIIlIIIlIll.getValue());
            return;
        });
        this.filter().type(Entity1_11Types.EntityType.VEX).index(12).handler((llllllllllllllllIIIIIIIIlIIlIIIl, llllllllllllllllIIIIIIIIlIIIllll) -> llllllllllllllllIIIIIIIIlIIIllll.setValue(0));
        this.filter().type(Entity1_11Types.EntityType.VINDICATION_ILLAGER).index(12).handler((llllllllllllllllIIIIIIIIlIIlIlII, llllllllllllllllIIIIIIIIlIIlIIll) -> {
            llllllllllllllllIIIIIIIIlIIlIlII.setIndex(13);
            llllllllllllllllIIIIIIIIlIIlIIll.setTypeAndValue(MetaType1_9.VarInt, (((Number)llllllllllllllllIIIIIIIIlIIlIIll.getValue()).intValue() == 1) ? 2 : 4);
            return;
        });
        final StoredEntityData llllllllllllllllIIIIIIIIlIIlllll;
        final byte llllllllllllllllIIIIIIIIlIIllllI;
        byte llllllllllllllllIIIIIIIIlIIllllI2;
        this.filter().filterFamily(Entity1_11Types.EntityType.ABSTRACT_HORSE).index(13).handler((llllllllllllllllIIIIIIIIlIlIIIIl, llllllllllllllllIIIIIIIIlIlIIIII) -> {
            llllllllllllllllIIIIIIIIlIIlllll = this.storedEntityData(llllllllllllllllIIIIIIIIlIlIIIIl);
            llllllllllllllllIIIIIIIIlIIllllI = (byte)llllllllllllllllIIIIIIIIlIlIIIII.getValue();
            if (llllllllllllllllIIIIIIIIlIIlllll.has(ChestedHorseStorage.class) && llllllllllllllllIIIIIIIIlIIlllll.get(ChestedHorseStorage.class).isChested()) {
                llllllllllllllllIIIIIIIIlIIllllI2 = (byte)(llllllllllllllllIIIIIIIIlIIllllI | 0x8);
                llllllllllllllllIIIIIIIIlIlIIIII.setValue(llllllllllllllllIIIIIIIIlIIllllI2);
            }
            return;
        });
        final StoredEntityData llllllllllllllllIIIIIIIIlIlIlIll;
        this.filter().filterFamily(Entity1_11Types.EntityType.CHESTED_HORSE).handler((llllllllllllllllIIIIIIIIlIlIllIl, llllllllllllllllIIIIIIIIlIlIllII) -> {
            llllllllllllllllIIIIIIIIlIlIlIll = this.storedEntityData(llllllllllllllllIIIIIIIIlIlIllIl);
            if (!llllllllllllllllIIIIIIIIlIlIlIll.has(ChestedHorseStorage.class)) {
                llllllllllllllllIIIIIIIIlIlIlIll.put(new ChestedHorseStorage());
            }
            return;
        });
        this.filter().type(Entity1_11Types.EntityType.HORSE).index(16).toIndex(17);
        final StoredEntityData llllllllllllllllIIIIIIIIlIlllIlI;
        final ChestedHorseStorage llllllllllllllllIIIIIIIIlIlllIIl;
        final boolean llllllllllllllllIIIIIIIIlIlllIII;
        this.filter().filterFamily(Entity1_11Types.EntityType.CHESTED_HORSE).index(15).handler((llllllllllllllllIIIIIIIIlIllllII, llllllllllllllllIIIIIIIIlIllIlIl) -> {
            llllllllllllllllIIIIIIIIlIlllIlI = this.storedEntityData(llllllllllllllllIIIIIIIIlIllllII);
            llllllllllllllllIIIIIIIIlIlllIIl = llllllllllllllllIIIIIIIIlIlllIlI.get(ChestedHorseStorage.class);
            llllllllllllllllIIIIIIIIlIlllIII = (boolean)llllllllllllllllIIIIIIIIlIllIlIl.getValue();
            llllllllllllllllIIIIIIIIlIlllIIl.setChested(llllllllllllllllIIIIIIIIlIlllIII);
            llllllllllllllllIIIIIIIIlIllllII.cancel();
            return;
        });
        final StoredEntityData llllllllllllllllIIIIIIIIllIIllII;
        final ChestedHorseStorage llllllllllllllllIIIIIIIIllIIlIll;
        final int llllllllllllllllIIIIIIIIllIIlIlI;
        this.filter().type(Entity1_11Types.EntityType.LIAMA).handler((llllllllllllllllIIIIIIIIllIIlllI, llllllllllllllllIIIIIIIIllIIIlll) -> {
            llllllllllllllllIIIIIIIIllIIllII = this.storedEntityData(llllllllllllllllIIIIIIIIllIIlllI);
            llllllllllllllllIIIIIIIIllIIlIll = llllllllllllllllIIIIIIIIllIIllII.get(ChestedHorseStorage.class);
            llllllllllllllllIIIIIIIIllIIlIlI = llllllllllllllllIIIIIIIIllIIlllI.index();
            switch (llllllllllllllllIIIIIIIIllIIlIlI) {
                case 16: {
                    llllllllllllllllIIIIIIIIllIIlIll.setLiamaStrength((int)llllllllllllllllIIIIIIIIllIIIlll.getValue());
                    llllllllllllllllIIIIIIIIllIIlllI.cancel();
                    break;
                }
                case 17: {
                    llllllllllllllllIIIIIIIIllIIlIll.setLiamaCarpetColor((int)llllllllllllllllIIIIIIIIllIIIlll.getValue());
                    llllllllllllllllIIIIIIIIllIIlllI.cancel();
                    break;
                }
                case 18: {
                    llllllllllllllllIIIIIIIIllIIlIll.setLiamaVariant((int)llllllllllllllllIIIIIIIIllIIIlll.getValue());
                    llllllllllllllllIIIIIIIIllIIlllI.cancel();
                    break;
                }
            }
            return;
        });
        this.filter().filterFamily(Entity1_11Types.EntityType.ABSTRACT_HORSE).index(14).toIndex(16);
        this.filter().type(Entity1_11Types.EntityType.VILLAGER).index(13).handler((llllllllllllllllIIIIIIIIllIllIII, llllllllllllllllIIIIIIIIllIlIlll) -> {
            if ((int)llllllllllllllllIIIIIIIIllIlIlll.getValue() == 5) {
                llllllllllllllllIIIIIIIIllIlIlll.setValue(0);
            }
            return;
        });
        this.filter().type(Entity1_11Types.EntityType.SHULKER).cancel(15);
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.POSITION);
                this.map(Type.INT);
                final int llllllllllllllIlIlIlIIIlIIllIlIl;
                int llllllllllllllIlIlIlIIIlIIllIlll;
                this.handler(llllllllllllllIlIlIlIIIlIIllIlII -> {
                    llllllllllllllIlIlIlIIIlIIllIlIl = llllllllllllllIlIlIlIIIlIIllIlII.get((Type<Integer>)Type.INT, 0);
                    if (llllllllllllllIlIlIlIIIlIIllIlIl == 2002 || llllllllllllllIlIlIlIIIlIIllIlIl == 2007) {
                        if (llllllllllllllIlIlIlIIIlIIllIlIl == 2007) {
                            llllllllllllllIlIlIlIIIlIIllIlII.set(Type.INT, 0, 2002);
                        }
                        llllllllllllllIlIlIlIIIlIIllIlll = PotionSplashHandler.getOldData(llllllllllllllIlIlIlIIIlIIllIlII.get((Type<Integer>)Type.INT, 1));
                        if (llllllllllllllIlIlIlIIIlIIllIlll != -1) {
                            llllllllllllllIlIlIlIIIlIIllIlII.set(Type.INT, 1, llllllllllllllIlIlIlIIIlIIllIlll);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.SPAWN_ENTITY, new PacketRemapper() {
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
                this.handler(LegacyEntityRewriter.this.getObjectRewriter(lllllllllllllIllIIllIlIlIlIlIlII -> Entity1_11Types.ObjectType.findById(lllllllllllllIllIIllIlIlIlIlIlII).orElse(null)));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllIllllllIIlllIlllllII) throws Exception {
                        final Optional<Entity1_12Types.ObjectType> llllllllllllIllllllIIlllIllllIll = Entity1_12Types.ObjectType.findById(llllllllllllIllllllIIlllIlllllII.get((Type<Byte>)Type.BYTE, 0));
                        if (llllllllllllIllllllIIlllIllllIll.isPresent() && llllllllllllIllllllIIlllIllllIll.get() == Entity1_12Types.ObjectType.FALLING_BLOCK) {
                            final int llllllllllllIllllllIIllllIIIIIIl = llllllllllllIllllllIIlllIlllllII.get((Type<Integer>)Type.INT, 0);
                            final int llllllllllllIllllllIIllllIIIIIII = llllllllllllIllllllIIllllIIIIIIl & 0xFFF;
                            final int llllllllllllIllllllIIlllIlllllll = llllllllllllIllllllIIllllIIIIIIl >> 12 & 0xF;
                            final Block llllllllllllIllllllIIlllIllllllI = ((Protocol1_10To1_11)EntityPackets1_11.this.protocol).getItemRewriter().handleBlock(llllllllllllIllllllIIllllIIIIIII, llllllllllllIllllllIIlllIlllllll);
                            if (llllllllllllIllllllIIlllIllllllI == null) {
                                return;
                            }
                            llllllllllllIllllllIIlllIlllllII.set(Type.INT, 0, llllllllllllIllllllIIlllIllllllI.getId() | llllllllllllIllllllIIlllIllllllI.getData() << 12);
                        }
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_9_3.SPAWN_EXPERIENCE_ORB, Entity1_11Types.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_9_3.SPAWN_GLOBAL_ENTITY, Entity1_11Types.EntityType.WEATHER);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.SPAWN_MOB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT, Type.UNSIGNED_BYTE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_9.METADATA_LIST);
                this.handler(EntityRewriterBase.this.getTrackerHandler(Type.UNSIGNED_BYTE, 0));
                final int lllllllllllllIlllIllllIIIIIlIlIl;
                final EntityType lllllllllllllIlllIllllIIIIIlIlII;
                final List<Metadata> lllllllllllllIlllIllllIIIIIlIIll;
                final EntityData lllllllllllllIlllIllllIIIIIlIIlI;
                this.handler(lllllllllllllIlllIllllIIIIIlIIII -> {
                    lllllllllllllIlllIllllIIIIIlIlIl = lllllllllllllIlllIllllIIIIIlIIII.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllIlllIllllIIIIIlIlII = ((com.viaversion.viaversion.api.rewriter.EntityRewriter<Protocol>)EntityPackets1_11.this).tracker(lllllllllllllIlllIllllIIIIIlIIII.user()).entityType(lllllllllllllIlllIllllIIIIIlIlIl);
                    lllllllllllllIlllIllllIIIIIlIIll = lllllllllllllIlllIllllIIIIIlIIII.get(Types1_9.METADATA_LIST, 0);
                    EntityPackets1_11.this.handleMetadata(lllllllllllllIlllIllllIIIIIlIIII.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllIlllIllllIIIIIlIIll, lllllllllllllIlllIllllIIIIIlIIII.user());
                    lllllllllllllIlllIllllIIIIIlIIlI = EntityRewriterBase.this.entityDataForType(lllllllllllllIlllIllllIIIIIlIlII);
                    if (lllllllllllllIlllIllllIIIIIlIIlI != null) {
                        lllllllllllllIlllIllllIIIIIlIIII.set(Type.UNSIGNED_BYTE, 0, (short)lllllllllllllIlllIllllIIIIIlIIlI.replacementId());
                        if (lllllllllllllIlllIllllIIIIIlIIlI.hasBaseMeta()) {
                            lllllllllllllIlllIllllIIIIIlIIlI.defaultMeta().createMeta(new WrappedMetadata(lllllllllllllIlllIllllIIIIIlIIll));
                        }
                    }
                    if (lllllllllllllIlllIllllIIIIIlIIll.isEmpty()) {
                        lllllllllllllIlllIllllIIIIIlIIll.add(new Metadata(0, MetaType1_9.Byte, 0));
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_9_3.SPAWN_PAINTING, Entity1_11Types.EntityType.PAINTING);
        this.registerJoinGame(ClientboundPackets1_9_3.JOIN_GAME, Entity1_11Types.EntityType.PLAYER);
        this.registerRespawn(ClientboundPackets1_9_3.RESPAWN);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_9.METADATA_LIST);
                this.handler(LegacyEntityRewriter.this.getTrackerAndMetaHandler(Types1_9.METADATA_LIST, Entity1_11Types.EntityType.PLAYER));
                final List<Metadata> lllllllllllllIlIlIlIlllIIIlIlIlI;
                this.handler(lllllllllllllIlIlIlIlllIIIlIlIIl -> {
                    lllllllllllllIlIlIlIlllIIIlIlIlI = lllllllllllllIlIlIlIlllIIIlIlIIl.get(Types1_9.METADATA_LIST, 0);
                    if (lllllllllllllIlIlIlIlllIIIlIlIlI.isEmpty()) {
                        lllllllllllllIlIlIlIlllIIIlIlIlI.add(new Metadata(0, MetaType1_9.Byte, 0));
                    }
                });
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_9_3.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_9_3.ENTITY_METADATA, Types1_9.METADATA_LIST);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.ENTITY_STATUS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llIlIlIIIlIIIl) throws Exception {
                        final byte llIlIlIIIlIIII = llIlIlIIIlIIIl.get((Type<Byte>)Type.BYTE, 0);
                        if (llIlIlIIIlIIII == 35) {
                            llIlIlIIIlIIIl.clearPacket();
                            llIlIlIIIlIIIl.setId(30);
                            llIlIlIIIlIIIl.write(Type.UNSIGNED_BYTE, (Short)10);
                            llIlIlIIIlIIIl.write(Type.FLOAT, 0.0f);
                        }
                    }
                });
            }
        });
    }
    
    private Metadata getHorseMetaType(final int llllllllllllllllIIIIIIIIlllIIIlI) {
        return new Metadata(14, MetaType1_9.VarInt, llllllllllllllllIIIIIIIIlllIIIlI);
    }
    
    private Metadata getZombieTypeMeta(final int llllllllllllllllIIIIIIIIllllIIlI) {
        return new Metadata(13, MetaType1_9.VarInt, llllllllllllllllIIIIIIIIllllIIlI);
    }
    
    private void handleZombieType(final WrappedMetadata llllllllllllllllIIIIIIIIlllIllII, final int llllllllllllllllIIIIIIIIlllIlIll) {
        final Metadata llllllllllllllllIIIIIIIIlllIlIlI = llllllllllllllllIIIIIIIIlllIllII.get(13);
        if (llllllllllllllllIIIIIIIIlllIlIlI == null) {
            llllllllllllllllIIIIIIIIlllIllII.add(this.getZombieTypeMeta(llllllllllllllllIIIIIIIIlllIlIll));
        }
    }
    
    @Override
    protected EntityType getObjectTypeFromId(final int llllllllllllllllIIIIIIIIllIllIll) {
        return Entity1_11Types.getTypeFromId(llllllllllllllllIIIIIIIIllIllIll, true);
    }
}
