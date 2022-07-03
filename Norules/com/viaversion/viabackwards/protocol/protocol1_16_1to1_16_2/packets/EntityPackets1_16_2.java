package com.viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.*;
import java.util.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets1_16_2 extends EntityRewriter<Protocol1_16_1To1_16_2>
{
    private final /* synthetic */ Set<String> oldDimensions;
    
    public EntityPackets1_16_2(final Protocol1_16_1To1_16_2 lllllllllllllIlIlIIIIIIIlllIlIIl) {
        super(lllllllllllllIlIlIIIIIIIlllIlIIl);
        this.oldDimensions = (Set<String>)Sets.newHashSet((Object[])new String[] { "minecraft:overworld", "minecraft:the_nether", "minecraft:the_end" });
    }
    
    private String getDimensionFromData(final CompoundTag lllllllllllllIlIlIIIIIIIllIllllI) {
        final StringTag lllllllllllllIlIlIIIIIIIlllIIIII = lllllllllllllIlIlIIIIIIIllIllllI.get("effects");
        return (lllllllllllllIlIlIIIIIIIlllIIIII != null && this.oldDimensions.contains(lllllllllllllIlIlIIIIIIIlllIIIII.getValue())) ? lllllllllllllIlIlIIIIIIIlllIIIII.getValue() : "minecraft:overworld";
    }
    
    @Override
    protected void registerRewrites() {
        this.registerMetaTypeHandler(MetaType1_16.ITEM, MetaType1_16.BLOCK_STATE, MetaType1_16.PARTICLE, MetaType1_16.OPT_COMPONENT);
        this.mapTypes(Entity1_16_2Types.values(), Entity1_16Types.class);
        this.mapEntityTypeWithData(Entity1_16_2Types.PIGLIN_BRUTE, Entity1_16_2Types.PIGLIN).jsonName("Piglin Brute");
        this.filter().filterFamily(Entity1_16_2Types.ABSTRACT_PIGLIN).index(15).toIndex(16);
        this.filter().filterFamily(Entity1_16_2Types.ABSTRACT_PIGLIN).index(16).toIndex(15);
    }
    
    @Override
    protected void registerPackets() {
        this.registerTrackerWithData(ClientboundPackets1_16_2.SPAWN_ENTITY, Entity1_16_2Types.FALLING_BLOCK);
        this.registerSpawnTracker(ClientboundPackets1_16_2.SPAWN_MOB);
        this.registerTracker(ClientboundPackets1_16_2.SPAWN_EXPERIENCE_ORB, Entity1_16_2Types.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_16_2.SPAWN_PAINTING, Entity1_16_2Types.PAINTING);
        this.registerTracker(ClientboundPackets1_16_2.SPAWN_PLAYER, Entity1_16_2Types.PLAYER);
        this.registerRemoveEntities(ClientboundPackets1_16_2.DESTROY_ENTITIES);
        this.registerMetadataRewriter(ClientboundPackets1_16_2.ENTITY_METADATA, Types1_16.METADATA_LIST);
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                final boolean lllllllllllllllllIIllIlllIlIllII;
                short lllllllllllllllllIIllIlllIlIlIll;
                this.handler(lllllllllllllllllIIllIlllIlIlIlI -> {
                    lllllllllllllllllIIllIlllIlIllII = lllllllllllllllllIIllIlllIlIlIlI.read((Type<Boolean>)Type.BOOLEAN);
                    lllllllllllllllllIIllIlllIlIlIll = lllllllllllllllllIIllIlllIlIlIlI.read((Type<Short>)Type.UNSIGNED_BYTE);
                    if (lllllllllllllllllIIllIlllIlIllII) {
                        lllllllllllllllllIIllIlllIlIlIll |= 0x8;
                    }
                    lllllllllllllllllIIllIlllIlIlIlI.write(Type.UNSIGNED_BYTE, lllllllllllllllllIIllIlllIlIlIll);
                    return;
                });
                this.map(Type.BYTE);
                this.map(Type.STRING_ARRAY);
                final CompoundTag lllllllllllllllllIIllIlllIllIlII;
                this.handler(lllllllllllllllllIIllIlllIllIlIl -> {
                    lllllllllllllllllIIllIlllIllIlIl.read(Type.NBT);
                    lllllllllllllllllIIllIlllIllIlIl.write(Type.NBT, EntityPackets.DIMENSIONS_TAG);
                    lllllllllllllllllIIllIlllIllIlII = lllllllllllllllllIIllIlllIllIlIl.read(Type.NBT);
                    lllllllllllllllllIIllIlllIllIlIl.write(Type.STRING, EntityPackets1_16_2.this.getDimensionFromData(lllllllllllllllllIIllIlllIllIlII));
                    return;
                });
                this.map(Type.STRING);
                this.map(Type.LONG);
                final int lllllllllllllllllIIllIlllIllllII;
                this.handler(lllllllllllllllllIIllIlllIllllIl -> {
                    lllllllllllllllllIIllIlllIllllII = lllllllllllllllllIIllIlllIllllIl.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllllllIIllIlllIllllIl.write(Type.UNSIGNED_BYTE, (short)Math.max(lllllllllllllllllIIllIlllIllllII, 255));
                    return;
                });
                this.handler(EntityRewriterBase.this.getTrackerHandler(Entity1_16_2Types.PLAYER, Type.INT));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                final CompoundTag lllllllllllllIIIllIlIIlIIlllIIll;
                this.handler(lllllllllllllIIIllIlIIlIIlllIIIl -> {
                    lllllllllllllIIIllIlIIlIIlllIIll = lllllllllllllIIIllIlIIlIIlllIIIl.read(Type.NBT);
                    lllllllllllllIIIllIlIIlIIlllIIIl.write(Type.STRING, EntityPackets1_16_2.this.getDimensionFromData(lllllllllllllIIIllIlIIlIIlllIIll));
                });
            }
        });
    }
    
    @Override
    public EntityType typeFromId(final int lllllllllllllIlIlIIIIIIIllIlIllI) {
        return Entity1_16_2Types.getTypeFromId(lllllllllllllIlIlIIIIIIIllIlIllI);
    }
}
