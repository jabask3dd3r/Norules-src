package com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.data.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.rewriter.meta.*;
import java.util.function.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viabackwards.api.entities.storage.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import java.util.*;
import com.viaversion.viabackwards.utils.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.types.version.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_12 extends LegacyEntityRewriter<Protocol1_11_1To1_12>
{
    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(Entity1_12Types.EntityType.PARROT, Entity1_12Types.EntityType.BAT).mobName("Parrot").spawnMetadata(llllllllllllllIIlIIllIllIIIlIIII -> llllllllllllllIIlIIllIllIIIlIIII.add(new Metadata(12, MetaType1_12.Byte, 0)));
        this.mapEntityTypeWithData(Entity1_12Types.EntityType.ILLUSION_ILLAGER, Entity1_12Types.EntityType.EVOCATION_ILLAGER).mobName("Illusioner");
        this.filter().filterFamily(Entity1_12Types.EntityType.EVOCATION_ILLAGER).cancel(12);
        this.filter().filterFamily(Entity1_12Types.EntityType.EVOCATION_ILLAGER).index(13).toIndex(12);
        byte llllllllllllllIIlIIllIllIIIlIlIl;
        this.filter().type(Entity1_12Types.EntityType.ILLUSION_ILLAGER).index(0).handler((llllllllllllllIIlIIllIllIIIlIlll, llllllllllllllIIlIIllIllIIIlIllI) -> {
            llllllllllllllIIlIIllIllIIIlIlIl = (byte)llllllllllllllIIlIIllIllIIIlIllI.getValue();
            if ((llllllllllllllIIlIIllIllIIIlIlIl & 0x20) == 0x20) {
                llllllllllllllIIlIIllIllIIIlIlIl &= 0xFFFFFFDF;
            }
            llllllllllllllIIlIIllIllIIIlIllI.setValue(llllllllllllllIIlIIllIllIIIlIlIl);
            return;
        });
        final StoredEntityData llllllllllllllIIlIIllIllIIIlllIl;
        this.filter().filterFamily(Entity1_12Types.EntityType.PARROT).handler((llllllllllllllIIlIIllIllIIIllIll, llllllllllllllIIlIIllIllIIIllllI) -> {
            llllllllllllllIIlIIllIllIIIlllIl = this.storedEntityData(llllllllllllllIIlIIllIllIIIllIll);
            if (!llllllllllllllIIlIIllIllIIIlllIl.has(ParrotStorage.class)) {
                llllllllllllllIIlIIllIllIIIlllIl.put(new ParrotStorage());
            }
            return;
        });
        this.filter().type(Entity1_12Types.EntityType.PARROT).cancel(12);
        final StoredEntityData llllllllllllllIIlIIllIllIIlIlllI;
        final ParrotStorage llllllllllllllIIlIIllIllIIlIllIl;
        final boolean llllllllllllllIIlIIllIllIIlIllII;
        final boolean llllllllllllllIIlIIllIllIIlIlIll;
        this.filter().type(Entity1_12Types.EntityType.PARROT).index(13).handler((llllllllllllllIIlIIllIllIIlIlIIl, llllllllllllllIIlIIllIllIIlIlIII) -> {
            llllllllllllllIIlIIllIllIIlIlllI = this.storedEntityData(llllllllllllllIIlIIllIllIIlIlIIl);
            llllllllllllllIIlIIllIllIIlIllIl = llllllllllllllIIlIIllIllIIlIlllI.get(ParrotStorage.class);
            llllllllllllllIIlIIllIllIIlIllII = (((byte)llllllllllllllIIlIIllIllIIlIlIII.getValue() & 0x1) == 0x1);
            llllllllllllllIIlIIllIllIIlIlIll = (((byte)llllllllllllllIIlIIllIllIIlIlIII.getValue() & 0x4) == 0x4);
            if (llllllllllllllIIlIIllIllIIlIllIl.isTamed() || llllllllllllllIIlIIllIllIIlIlIll) {}
            llllllllllllllIIlIIllIllIIlIllIl.setTamed(llllllllllllllIIlIIllIllIIlIlIll);
            if (llllllllllllllIIlIIllIllIIlIllII) {
                llllllllllllllIIlIIllIllIIlIlIIl.setIndex(12);
                llllllllllllllIIlIIllIllIIlIlIII.setValue(1);
                llllllllllllllIIlIIllIllIIlIllIl.setSitting(true);
            }
            else if (llllllllllllllIIlIIllIllIIlIllIl.isSitting()) {
                llllllllllllllIIlIIllIllIIlIlIIl.setIndex(12);
                llllllllllllllIIlIIllIllIIlIlIII.setValue(0);
                llllllllllllllIIlIIllIllIIlIllIl.setSitting(false);
            }
            else {
                llllllllllllllIIlIIllIllIIlIlIIl.cancel();
            }
            return;
        });
        this.filter().type(Entity1_12Types.EntityType.PARROT).cancel(14);
        this.filter().type(Entity1_12Types.EntityType.PARROT).cancel(15);
        final CompoundTag llllllllllllllIIlIIllIllIIllllll;
        final ShoulderTracker llllllllllllllIIlIIllIllIIlllllI;
        String llllllllllllllIIlIIllIllIlIIIIlI;
        this.filter().type(Entity1_12Types.EntityType.PLAYER).index(15).handler((llllllllllllllIIlIIllIllIIllllIl, llllllllllllllIIlIIllIllIIllllII) -> {
            llllllllllllllIIlIIllIllIIllllll = (CompoundTag)llllllllllllllIIlIIllIllIIllllII.getValue();
            llllllllllllllIIlIIllIllIIlllllI = llllllllllllllIIlIIllIllIIllllIl.user().get(ShoulderTracker.class);
            if (llllllllllllllIIlIIllIllIIllllll.isEmpty() && llllllllllllllIIlIIllIllIIlllllI.getLeftShoulder() != null) {
                llllllllllllllIIlIIllIllIIlllllI.setLeftShoulder(null);
                llllllllllllllIIlIIllIllIIlllllI.update();
            }
            else if (llllllllllllllIIlIIllIllIIllllll.contains("id") && llllllllllllllIIlIIllIllIIllllIl.entityId() == llllllllllllllIIlIIllIllIIlllllI.getEntityId()) {
                llllllllllllllIIlIIllIllIlIIIIlI = (String)llllllllllllllIIlIIllIllIIllllll.get("id").getValue();
                if (llllllllllllllIIlIIllIllIIlllllI.getLeftShoulder() == null || !llllllllllllllIIlIIllIllIIlllllI.getLeftShoulder().equals(llllllllllllllIIlIIllIllIlIIIIlI)) {
                    llllllllllllllIIlIIllIllIIlllllI.setLeftShoulder(llllllllllllllIIlIIllIllIlIIIIlI);
                    llllllllllllllIIlIIllIllIIlllllI.update();
                }
            }
            llllllllllllllIIlIIllIllIIllllIl.cancel();
            return;
        });
        final CompoundTag llllllllllllllIIlIIllIllIlIIllIl;
        final ShoulderTracker llllllllllllllIIlIIllIllIlIIllII;
        String llllllllllllllIIlIIllIllIlIlIIII;
        this.filter().type(Entity1_12Types.EntityType.PLAYER).index(16).handler((llllllllllllllIIlIIllIllIlIIlIll, llllllllllllllIIlIIllIllIlIIlllI) -> {
            llllllllllllllIIlIIllIllIlIIllIl = (CompoundTag)llllllllllllllIIlIIllIllIlIIlIll.meta().getValue();
            llllllllllllllIIlIIllIllIlIIllII = llllllllllllllIIlIIllIllIlIIlIll.user().get(ShoulderTracker.class);
            if (llllllllllllllIIlIIllIllIlIIllIl.isEmpty() && llllllllllllllIIlIIllIllIlIIllII.getRightShoulder() != null) {
                llllllllllllllIIlIIllIllIlIIllII.setRightShoulder(null);
                llllllllllllllIIlIIllIllIlIIllII.update();
            }
            else if (llllllllllllllIIlIIllIllIlIIllIl.contains("id") && llllllllllllllIIlIIllIllIlIIlIll.entityId() == llllllllllllllIIlIIllIllIlIIllII.getEntityId()) {
                llllllllllllllIIlIIllIllIlIlIIII = (String)llllllllllllllIIlIIllIllIlIIllIl.get("id").getValue();
                if (llllllllllllllIIlIIllIllIlIIllII.getRightShoulder() == null || !llllllllllllllIIlIIllIllIlIIllII.getRightShoulder().equals(llllllllllllllIIlIIllIllIlIlIIII)) {
                    llllllllllllllIIlIIllIllIlIIllII.setRightShoulder(llllllllllllllIIlIIllIllIlIlIIII);
                    llllllllllllllIIlIIllIllIlIIllII.update();
                }
            }
            llllllllllllllIIlIIllIllIlIIlIll.cancel();
        });
    }
    
    public EntityPackets1_12(final Protocol1_11_1To1_12 llllllllllllllIIlIIllIllIllIIIll) {
        super(llllllllllllllIIlIIllIllIllIIIll);
    }
    
    @Override
    protected EntityType getObjectTypeFromId(final int llllllllllllllIIlIIllIllIlIlIlIl) {
        return Entity1_12Types.getTypeFromId(llllllllllllllIIlIIllIllIlIlIlIl, true);
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.SPAWN_ENTITY, new PacketRemapper() {
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
                this.handler(LegacyEntityRewriter.this.getObjectRewriter(lllllllllllllIIllIIllIllIlIlIIII -> Entity1_12Types.ObjectType.findById(lllllllllllllIIllIIllIllIlIlIIII).orElse(null)));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIIIlIIIIIIlllIIl) throws Exception {
                        final Optional<Entity1_12Types.ObjectType> lllllllllllllIIlIIIlIIIIIIlllIII = Entity1_12Types.ObjectType.findById(lllllllllllllIIlIIIlIIIIIIlllIIl.get((Type<Byte>)Type.BYTE, 0));
                        if (lllllllllllllIIlIIIlIIIIIIlllIII.isPresent() && lllllllllllllIIlIIIlIIIIIIlllIII.get() == Entity1_12Types.ObjectType.FALLING_BLOCK) {
                            final int lllllllllllllIIlIIIlIIIIIIlllllI = lllllllllllllIIlIIIlIIIIIIlllIIl.get((Type<Integer>)Type.INT, 0);
                            final int lllllllllllllIIlIIIlIIIIIIllllIl = lllllllllllllIIlIIIlIIIIIIlllllI & 0xFFF;
                            final int lllllllllllllIIlIIIlIIIIIIllllII = lllllllllllllIIlIIIlIIIIIIlllllI >> 12 & 0xF;
                            final Block lllllllllllllIIlIIIlIIIIIIlllIll = ((Protocol1_11_1To1_12)EntityPackets1_12.this.protocol).getItemRewriter().handleBlock(lllllllllllllIIlIIIlIIIIIIllllIl, lllllllllllllIIlIIIlIIIIIIllllII);
                            if (lllllllllllllIIlIIIlIIIIIIlllIll == null) {
                                return;
                            }
                            lllllllllllllIIlIIIlIIIIIIlllIIl.set(Type.INT, 0, lllllllllllllIIlIIIlIIIIIIlllIll.getId() | lllllllllllllIIlIIIlIIIIIIlllIll.getData() << 12);
                        }
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_12.SPAWN_EXPERIENCE_ORB, Entity1_12Types.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_12.SPAWN_GLOBAL_ENTITY, Entity1_12Types.EntityType.WEATHER);
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.SPAWN_MOB, new PacketRemapper() {
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
                this.map(Types1_12.METADATA_LIST);
                this.handler(EntityRewriterBase.this.getTrackerHandler());
                this.handler(LegacyEntityRewriter.this.getMobSpawnRewriter(Types1_12.METADATA_LIST));
            }
        });
        this.registerTracker(ClientboundPackets1_12.SPAWN_PAINTING, Entity1_12Types.EntityType.PAINTING);
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_12.METADATA_LIST);
                this.handler(LegacyEntityRewriter.this.getTrackerAndMetaHandler(Types1_12.METADATA_LIST, Entity1_12Types.EntityType.PLAYER));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.handler(EntityRewriterBase.this.getTrackerHandler(Entity1_12Types.EntityType.PLAYER, Type.INT));
                this.handler(EntityRewriterBase.this.getDimensionHandler(1));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllIlllllIIIIlIIIlllllI) throws Exception {
                        final ShoulderTracker llllllllllllIlllllIIIIlIIIllllll = llllllllllllIlllllIIIIlIIIlllllI.user().get(ShoulderTracker.class);
                        llllllllllllIlllllIIIIlIIIllllll.setEntityId(llllllllllllIlllllIIIIlIIIlllllI.get((Type<Integer>)Type.INT, 0));
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIIlIllIlIIllIlIl) throws Exception {
                        final PacketWrapper lllllllllllllllIIIlIllIlIIllIlII = PacketWrapper.create(7, null, lllllllllllllllIIIlIllIlIIllIlIl.user());
                        lllllllllllllllIIIlIllIlIIllIlII.write(Type.VAR_INT, 1);
                        lllllllllllllllIIIlIllIlIIllIlII.write(Type.STRING, "achievement.openInventory");
                        lllllllllllllllIIIlIllIlIIllIlII.write(Type.VAR_INT, 1);
                        lllllllllllllllIIIlIllIlIIllIlII.scheduleSend(Protocol1_11_1To1_12.class);
                    }
                });
            }
        });
        this.registerRespawn(ClientboundPackets1_12.RESPAWN);
        this.registerRemoveEntities(ClientboundPackets1_12.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_12.ENTITY_METADATA, Types1_12.METADATA_LIST);
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                int lllllllllllllIIIllllllIIIIllIIII;
                int lllllllllllllIIIllllllIIIIllIIIl;
                int lllllllllllllIIIllllllIIIIllIIll;
                String lllllllllllllIIIllllllIIIIllIlII;
                int lllllllllllllIIIllllllIIIIllIlll;
                int lllllllllllllIIIllllllIIIIlllIII;
                int lllllllllllllIIIllllllIIIIllIlIl;
                int lllllllllllllIIIllllllIIIIllIllI;
                this.handler(lllllllllllllIIIllllllIIIIlIllll -> {
                    for (lllllllllllllIIIllllllIIIIllIIIl = (lllllllllllllIIIllllllIIIIllIIII = lllllllllllllIIIllllllIIIIlIllll.get((Type<Integer>)Type.INT, 0)), lllllllllllllIIIllllllIIIIllIIll = 0; lllllllllllllIIIllllllIIIIllIIll < lllllllllllllIIIllllllIIIIllIIIl; ++lllllllllllllIIIllllllIIIIllIIll) {
                        lllllllllllllIIIllllllIIIIllIlII = lllllllllllllIIIllllllIIIIlIllll.read(Type.STRING);
                        if (lllllllllllllIIIllllllIIIIllIlII.equals("generic.flyingSpeed")) {
                            --lllllllllllllIIIllllllIIIIllIIII;
                            lllllllllllllIIIllllllIIIIlIllll.read((Type<Object>)Type.DOUBLE);
                            for (lllllllllllllIIIllllllIIIIllIlll = lllllllllllllIIIllllllIIIIlIllll.read((Type<Integer>)Type.VAR_INT), lllllllllllllIIIllllllIIIIlllIII = 0; lllllllllllllIIIllllllIIIIlllIII < lllllllllllllIIIllllllIIIIllIlll; ++lllllllllllllIIIllllllIIIIlllIII) {
                                lllllllllllllIIIllllllIIIIlIllll.read(Type.UUID);
                                lllllllllllllIIIllllllIIIIlIllll.read((Type<Object>)Type.DOUBLE);
                                lllllllllllllIIIllllllIIIIlIllll.read((Type<Object>)Type.BYTE);
                            }
                        }
                        else {
                            lllllllllllllIIIllllllIIIIlIllll.write(Type.STRING, lllllllllllllIIIllllllIIIIllIlII);
                            lllllllllllllIIIllllllIIIIlIllll.passthrough((Type<Object>)Type.DOUBLE);
                            for (lllllllllllllIIIllllllIIIIllIlIl = lllllllllllllIIIllllllIIIIlIllll.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIIllllllIIIIllIllI = 0; lllllllllllllIIIllllllIIIIllIllI < lllllllllllllIIIllllllIIIIllIlIl; ++lllllllllllllIIIllllllIIIIllIllI) {
                                lllllllllllllIIIllllllIIIIlIllll.passthrough(Type.UUID);
                                lllllllllllllIIIllllllIIIIlIllll.passthrough((Type<Object>)Type.DOUBLE);
                                lllllllllllllIIIllllllIIIIlIllll.passthrough((Type<Object>)Type.BYTE);
                            }
                        }
                    }
                    if (lllllllllllllIIIllllllIIIIllIIII != lllllllllllllIIIllllllIIIIllIIIl) {
                        lllllllllllllIIIllllllIIIIlIllll.set(Type.INT, 0, lllllllllllllIIIllllllIIIIllIIII);
                    }
                });
            }
        });
    }
    
    @Override
    public EntityType typeFromId(final int llllllllllllllIIlIIllIllIlIllIlI) {
        return Entity1_12Types.getTypeFromId(llllllllllllllIIlIIllIllIlIllIlI, false);
    }
}
