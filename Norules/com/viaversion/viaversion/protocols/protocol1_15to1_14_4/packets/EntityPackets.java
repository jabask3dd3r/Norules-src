package com.viaversion.viaversion.protocols.protocol1_15to1_14_4.packets;

import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.type.types.version.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets
{
    public static void register(final Protocol1_15To1_14_4 lllllllllllllllllIllIIIIlIIlIIII) {
        final MetadataRewriter1_15To1_14_4 lllllllllllllllllIllIIIIlIIlIIIl = lllllllllllllllllIllIIIIlIIlIIII.get(MetadataRewriter1_15To1_14_4.class);
        lllllllllllllllllIllIIIIlIIlIIIl.registerTrackerWithData(ClientboundPackets1_14.SPAWN_ENTITY, Entity1_15Types.FALLING_BLOCK);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)lllllllllllllllllIllIIIIlIIlIIII).registerClientbound(ClientboundPackets1_14.SPAWN_MOB, new PacketRemapper() {
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
                this.handler(lllllllllllllllllIllIIIIlIIlIIIl.trackerHandler());
                this.handler(lllIIlIllIlIIII -> sendMetadataPacket(lllIIlIllIlIIII, lllIIlIllIlIIII.get((Type<Integer>)Type.VAR_INT, 0), lllllllllllllllllIllIIIIlIIlIIIl));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)lllllllllllllllllIllIIIIlIIlIIII).registerClientbound(ClientboundPackets1_14.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                final EntityRewriter val$metadataRewriter;
                final int lllllllllllllllIIllIllIIIlIlIIll;
                this.handler(lllllllllllllllIIllIllIIIlIlIlIl -> {
                    val$metadataRewriter = lllllllllllllllllIllIIIIlIIlIIIl;
                    lllllllllllllllIIllIllIIIlIlIIll = lllllllllllllllIIllIllIIIlIlIlIl.get((Type<Integer>)Type.VAR_INT, 0);
                    lllllllllllllllIIllIllIIIlIlIlIl.user().getEntityTracker(Protocol1_15To1_14_4.class).addEntity(lllllllllllllllIIllIllIIIlIlIIll, Entity1_15Types.PLAYER);
                    sendMetadataPacket(lllllllllllllllIIllIllIIIlIlIlIl, lllllllllllllllIIllIllIIIlIlIIll, val$metadataRewriter);
                });
            }
        });
        lllllllllllllllllIllIIIIlIIlIIIl.registerMetadataRewriter(ClientboundPackets1_14.ENTITY_METADATA, Types1_14.METADATA_LIST);
        lllllllllllllllllIllIIIIlIIlIIIl.registerRemoveEntities(ClientboundPackets1_14.DESTROY_ENTITIES);
    }
    
    public static int getNewEntityId(final int lllllllllllllllllIllIIIIIllllllI) {
        return (lllllllllllllllllIllIIIIIllllllI >= 4) ? (lllllllllllllllllIllIIIIIllllllI + 1) : lllllllllllllllllIllIIIIIllllllI;
    }
    
    private static void sendMetadataPacket(final PacketWrapper lllllllllllllllllIllIIIIlIIIlIIl, final int lllllllllllllllllIllIIIIlIIIIIll, final EntityRewriter lllllllllllllllllIllIIIIlIIIIlll) throws Exception {
        final List<Metadata> lllllllllllllllllIllIIIIlIIIIllI = lllllllllllllllllIllIIIIlIIIlIIl.read(Types1_14.METADATA_LIST);
        lllllllllllllllllIllIIIIlIIIlIIl.send(Protocol1_15To1_14_4.class);
        lllllllllllllllllIllIIIIlIIIlIIl.cancel();
        lllllllllllllllllIllIIIIlIIIIlll.handleMetadata(lllllllllllllllllIllIIIIlIIIIIll, lllllllllllllllllIllIIIIlIIIIllI, lllllllllllllllllIllIIIIlIIIlIIl.user());
        final PacketWrapper lllllllllllllllllIllIIIIlIIIIlIl = PacketWrapper.create(ClientboundPackets1_15.ENTITY_METADATA, lllllllllllllllllIllIIIIlIIIlIIl.user());
        lllllllllllllllllIllIIIIlIIIIlIl.write(Type.VAR_INT, lllllllllllllllllIllIIIIlIIIIIll);
        lllllllllllllllllIllIIIIlIIIIlIl.write(Types1_14.METADATA_LIST, lllllllllllllllllIllIIIIlIIIIllI);
        lllllllllllllllllIllIIIIlIIIIlIl.send(Protocol1_15To1_14_4.class);
    }
}
