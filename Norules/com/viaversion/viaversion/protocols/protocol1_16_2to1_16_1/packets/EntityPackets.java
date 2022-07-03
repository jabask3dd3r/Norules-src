package com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.packets;

import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets
{
    public static void register(final Protocol1_16_2To1_16_1 lllllllllllllIIIlllIIllIllIlIlll) {
        final MetadataRewriter1_16_2To1_16_1 lllllllllllllIIIlllIIllIllIlIllI = lllllllllllllIIIlllIIllIllIlIlll.get(MetadataRewriter1_16_2To1_16_1.class);
        lllllllllllllIIIlllIIllIllIlIllI.registerTrackerWithData(ClientboundPackets1_16.SPAWN_ENTITY, Entity1_16_2Types.FALLING_BLOCK);
        lllllllllllllIIIlllIIllIllIlIllI.registerTracker(ClientboundPackets1_16.SPAWN_MOB);
        lllllllllllllIIIlllIIllIllIlIllI.registerTracker(ClientboundPackets1_16.SPAWN_PLAYER, Entity1_16_2Types.PLAYER);
        lllllllllllllIIIlllIIllIllIlIllI.registerMetadataRewriter(ClientboundPackets1_16.ENTITY_METADATA, Types1_16.METADATA_LIST);
        lllllllllllllIIIlllIIllIllIlIllI.registerRemoveEntities(ClientboundPackets1_16.DESTROY_ENTITIES);
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)lllllllllllllIIIlllIIllIllIlIlll).registerClientbound(ClientboundPackets1_16.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                final short lllllllllllllIlllIlllIlIIlIIIIIl;
                final short lllllllllllllIlllIlllIlIIlIIIIIl2;
                this.handler(lllllllllllllIlllIlllIlIIlIIIIII -> {
                    lllllllllllllIlllIlllIlIIlIIIIIl = lllllllllllllIlllIlllIlIIlIIIIII.read((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllIlllIlllIlIIlIIIIII.write(Type.BOOLEAN, (lllllllllllllIlllIlllIlIIlIIIIIl & 0x8) != 0x0);
                    lllllllllllllIlllIlllIlIIlIIIIIl2 = (short)(lllllllllllllIlllIlllIlIIlIIIIIl & 0xFFFFFFF7);
                    lllllllllllllIlllIlllIlIIlIIIIII.write(Type.UNSIGNED_BYTE, lllllllllllllIlllIlllIlIIlIIIIIl2);
                    return;
                });
                this.map(Type.BYTE);
                this.map(Type.STRING_ARRAY);
                final Protocol1_16_2To1_16_1 val$protocol;
                final String lllllllllllllIlllIlllIlIIlIIlIII;
                this.handler(lllllllllllllIlllIlllIlIIlIIIllI -> {
                    val$protocol = lllllllllllllIIIlllIIllIllIlIlll;
                    lllllllllllllIlllIlllIlIIlIIIllI.read(Type.NBT);
                    lllllllllllllIlllIlllIlIIlIIIllI.write(Type.NBT, val$protocol.getMappingData().getDimensionRegistry());
                    lllllllllllllIlllIlllIlIIlIIlIII = lllllllllllllIlllIlllIlIIlIIIllI.read(Type.STRING);
                    lllllllllllllIlllIlllIlIIlIIIllI.write(Type.NBT, EntityPackets.getDimensionData(lllllllllllllIlllIlllIlIIlIIlIII));
                    return;
                });
                this.map(Type.STRING);
                this.map(Type.LONG);
                this.map(Type.UNSIGNED_BYTE, Type.VAR_INT);
                this.handler(lllllllllllllIlllIlllIlIIlIIllll -> lllllllllllllIlllIlllIlIIlIIllll.user().getEntityTracker(Protocol1_16_2To1_16_1.class).addEntity(lllllllllllllIlllIlllIlIIlIIllll.get((Type<Integer>)Type.INT, 0), Entity1_16_2Types.PLAYER));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)lllllllllllllIIIlllIIllIllIlIlll).registerClientbound(ClientboundPackets1_16.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                final String lllllllllllllIIIlIlllIllIlIlIIIl;
                this.handler(lllllllllllllIIIlIlllIllIlIlIIII -> {
                    lllllllllllllIIIlIlllIllIlIlIIIl = lllllllllllllIIIlIlllIllIlIlIIII.read(Type.STRING);
                    lllllllllllllIIIlIlllIllIlIlIIII.write(Type.NBT, EntityPackets.getDimensionData(lllllllllllllIIIlIlllIllIlIlIIIl));
                });
            }
        });
    }
    
    public static CompoundTag getDimensionData(final String lllllllllllllIIIlllIIllIllIIllll) {
        final CompoundTag lllllllllllllIIIlllIIllIllIlIIII = Protocol1_16_2To1_16_1.MAPPINGS.getDimensionDataMap().get(lllllllllllllIIIlllIIllIllIIllll);
        if (lllllllllllllIIIlllIIllIllIlIIII == null) {
            Via.getPlatform().getLogger().severe(String.valueOf(new StringBuilder().append("Could not get dimension data of ").append(lllllllllllllIIIlllIIllIllIIllll)));
            throw new NullPointerException(String.valueOf(new StringBuilder().append("Dimension data for ").append(lllllllllllllIIIlllIIllIllIIllll).append(" is null!")));
        }
        return lllllllllllllIIIlllIIllIllIlIIII;
    }
}
