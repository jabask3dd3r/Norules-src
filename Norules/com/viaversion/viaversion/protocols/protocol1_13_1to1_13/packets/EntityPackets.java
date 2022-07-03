package com.viaversion.viaversion.protocols.protocol1_13_1to1_13.packets;

import com.viaversion.viaversion.protocols.protocol1_13_1to1_13.*;
import com.viaversion.viaversion.protocols.protocol1_13_1to1_13.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets
{
    public static void register(final Protocol1_13_1To1_13 lIllIIIIIIIllII) {
        final MetadataRewriter1_13_1To1_13 lIllIIIIIIIlIll = lIllIIIIIIIllII.get(MetadataRewriter1_13_1To1_13.class);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lIllIIIIIIIllII).registerClientbound(ClientboundPackets1_13.SPAWN_ENTITY, new PacketRemapper() {
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
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllIlIIIlllIllIIll) throws Exception {
                        final int lllllllllllllllllIlIIIlllIllIIlI = lllllllllllllllllIlIIIlllIllIIll.get((Type<Integer>)Type.VAR_INT, 0);
                        final byte lllllllllllllllllIlIIIlllIllIIIl = lllllllllllllllllIlIIIlllIllIIll.get((Type<Byte>)Type.BYTE, 0);
                        final Entity1_13Types.EntityType lllllllllllllllllIlIIIlllIllIIII = Entity1_13Types.getTypeFromId(lllllllllllllllllIlIIIlllIllIIIl, true);
                        if (lllllllllllllllllIlIIIlllIllIIII != null) {
                            if (lllllllllllllllllIlIIIlllIllIIII.is(Entity1_13Types.EntityType.FALLING_BLOCK)) {
                                final int lllllllllllllllllIlIIIlllIllIlIl = lllllllllllllllllIlIIIlllIllIIll.get((Type<Integer>)Type.INT, 0);
                                lllllllllllllllllIlIIIlllIllIIll.set(Type.INT, 0, lIllIIIIIIIllII.getMappingData().getNewBlockStateId(lllllllllllllllllIlIIIlllIllIlIl));
                            }
                            lllllllllllllllllIlIIIlllIllIIll.user().getEntityTracker(Protocol1_13_1To1_13.class).addEntity(lllllllllllllllllIlIIIlllIllIIlI, lllllllllllllllllIlIIIlllIllIIII);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lIllIIIIIIIllII).registerClientbound(ClientboundPackets1_13.SPAWN_MOB, new PacketRemapper() {
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
                this.map(Types1_13.METADATA_LIST);
                this.handler(lIllIIIIIIIlIll.trackerAndRewriterHandler(Types1_13.METADATA_LIST));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lIllIIIIIIIllII).registerClientbound(ClientboundPackets1_13.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_13.METADATA_LIST);
                this.handler(lIllIIIIIIIlIll.trackerAndRewriterHandler(Types1_13.METADATA_LIST, Entity1_13Types.EntityType.PLAYER));
            }
        });
        lIllIIIIIIIlIll.registerRemoveEntities(ClientboundPackets1_13.DESTROY_ENTITIES);
        lIllIIIIIIIlIll.registerMetadataRewriter(ClientboundPackets1_13.ENTITY_METADATA, Types1_13.METADATA_LIST);
    }
}
