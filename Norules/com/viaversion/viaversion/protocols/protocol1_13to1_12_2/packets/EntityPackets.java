package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets
{
    public static void register(final Protocol1_13To1_12_2 lllllllllllllIlllIlIIlIlIlllllIl) {
        final MetadataRewriter1_13To1_12_2 lllllllllllllIlllIlIIlIlIllllllI = lllllllllllllIlllIlIIlIlIlllllIl.get(MetadataRewriter1_13To1_12_2.class);
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)lllllllllllllIlllIlIIlIlIlllllIl).registerClientbound(ClientboundPackets1_12_1.SPAWN_ENTITY, new PacketRemapper() {
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
                    public void handle(final PacketWrapper lllllllllllllllIlllllIIIIIlllIIl) throws Exception {
                        final int lllllllllllllllIlllllIIIIIlllIII = lllllllllllllllIlllllIIIIIlllIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        final byte lllllllllllllllIlllllIIIIIllIlll = lllllllllllllllIlllllIIIIIlllIIl.get((Type<Byte>)Type.BYTE, 0);
                        final Entity1_13Types.EntityType lllllllllllllllIlllllIIIIIllIllI = Entity1_13Types.getTypeFromId(lllllllllllllllIlllllIIIIIllIlll, true);
                        if (lllllllllllllllIlllllIIIIIllIllI == null) {
                            return;
                        }
                        lllllllllllllllIlllllIIIIIlllIIl.user().getEntityTracker(Protocol1_13To1_12_2.class).addEntity(lllllllllllllllIlllllIIIIIlllIII, lllllllllllllllIlllllIIIIIllIllI);
                        if (lllllllllllllllIlllllIIIIIllIllI.is(Entity1_13Types.EntityType.FALLING_BLOCK)) {
                            final int lllllllllllllllIlllllIIIIIllllIl = lllllllllllllllIlllllIIIIIlllIIl.get((Type<Integer>)Type.INT, 0);
                            final int lllllllllllllllIlllllIIIIIllllII = (lllllllllllllllIlllllIIIIIllllIl & 0xFFF) << 4 | (lllllllllllllllIlllllIIIIIllllIl >> 12 & 0xF);
                            lllllllllllllllIlllllIIIIIlllIIl.set(Type.INT, 0, WorldPackets.toNewId(lllllllllllllllIlllllIIIIIllllII));
                        }
                        if (lllllllllllllllIlllllIIIIIllIllI.is(Entity1_13Types.EntityType.ITEM_FRAME)) {
                            int lllllllllllllllIlllllIIIIIlllIll = lllllllllllllllIlllllIIIIIlllIIl.get((Type<Integer>)Type.INT, 0);
                            switch (lllllllllllllllIlllllIIIIIlllIll) {
                                case 0: {
                                    lllllllllllllllIlllllIIIIIlllIll = 3;
                                    break;
                                }
                                case 1: {
                                    lllllllllllllllIlllllIIIIIlllIll = 4;
                                    break;
                                }
                                case 3: {
                                    lllllllllllllllIlllllIIIIIlllIll = 5;
                                    break;
                                }
                            }
                            lllllllllllllllIlllllIIIIIlllIIl.set(Type.INT, 0, lllllllllllllllIlllllIIIIIlllIll);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)lllllllllllllIlllIlIIlIlIlllllIl).registerClientbound(ClientboundPackets1_12_1.SPAWN_MOB, new PacketRemapper() {
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
                this.map(Types1_12.METADATA_LIST, Types1_13.METADATA_LIST);
                this.handler(lllllllllllllIlllIlIIlIlIllllllI.trackerAndRewriterHandler(Types1_13.METADATA_LIST));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)lllllllllllllIlllIlIIlIlIlllllIl).registerClientbound(ClientboundPackets1_12_1.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_12.METADATA_LIST, Types1_13.METADATA_LIST);
                this.handler(lllllllllllllIlllIlIIlIlIllllllI.trackerAndRewriterHandler(Types1_13.METADATA_LIST, Entity1_13Types.EntityType.PLAYER));
            }
        });
        lllllllllllllIlllIlIIlIlIllllllI.registerRemoveEntities(ClientboundPackets1_12_1.DESTROY_ENTITIES);
        lllllllllllllIlllIlIIlIlIllllllI.registerMetadataRewriter(ClientboundPackets1_12_1.ENTITY_METADATA, Types1_12.METADATA_LIST, Types1_13.METADATA_LIST);
    }
}
