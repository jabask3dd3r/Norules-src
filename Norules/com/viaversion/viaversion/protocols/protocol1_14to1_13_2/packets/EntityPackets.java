package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets
{
    public static void register(final Protocol1_14To1_13_2 lllllllllllllIIlIIIIIIIlIIIllIll) {
        final MetadataRewriter1_14To1_13_2 lllllllllllllIIlIIIIIIIlIIIlllII = lllllllllllllIIlIIIIIIIlIIIllIll.get(MetadataRewriter1_14To1_13_2.class);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lllllllllllllIIlIIIIIIIlIIIllIll).registerClientbound(ClientboundPackets1_13.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.BYTE, Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIlIllllIIlllIIII) throws Exception {
                        final int llllllllllllllIlIlIllllIIllllIII = llllllllllllllIlIlIllllIIlllIIII.get((Type<Integer>)Type.VAR_INT, 0);
                        int llllllllllllllIlIlIllllIIlllIlll = llllllllllllllIlIlIllllIIlllIIII.get((Type<Integer>)Type.VAR_INT, 1);
                        final Entity1_13Types.EntityType llllllllllllllIlIlIllllIIlllIlIl = Entity1_13Types.getTypeFromId(llllllllllllllIlIlIllllIIlllIlll, true);
                        llllllllllllllIlIlIllllIIlllIlll = lllllllllllllIIlIIIIIIIlIIIlllII.newEntityId(llllllllllllllIlIlIllllIIlllIlIl.getId());
                        final EntityType llllllllllllllIlIlIllllIIlllIIll = Entity1_14Types.getTypeFromId(llllllllllllllIlIlIllllIIlllIlll);
                        if (llllllllllllllIlIlIllllIIlllIIll != null) {
                            final int llllllllllllllIlIlIllllIIlllllII = llllllllllllllIlIlIllllIIlllIIII.get((Type<Integer>)Type.INT, 0);
                            if (llllllllllllllIlIlIllllIIlllIIll.is(Entity1_14Types.FALLING_BLOCK)) {
                                llllllllllllllIlIlIllllIIlllIIII.set(Type.INT, 0, lllllllllllllIIlIIIIIIIlIIIllIll.getMappingData().getNewBlockStateId(llllllllllllllIlIlIllllIIlllllII));
                            }
                            else if (llllllllllllllIlIlIllllIIlllIIll.is(Entity1_14Types.MINECART)) {
                                switch (llllllllllllllIlIlIllllIIlllllII) {
                                    case 1: {
                                        llllllllllllllIlIlIllllIIlllIlll = Entity1_14Types.CHEST_MINECART.getId();
                                        break;
                                    }
                                    case 2: {
                                        llllllllllllllIlIlIllllIIlllIlll = Entity1_14Types.FURNACE_MINECART.getId();
                                        break;
                                    }
                                    case 3: {
                                        llllllllllllllIlIlIllllIIlllIlll = Entity1_14Types.TNT_MINECART.getId();
                                        break;
                                    }
                                    case 4: {
                                        llllllllllllllIlIlIllllIIlllIlll = Entity1_14Types.SPAWNER_MINECART.getId();
                                        break;
                                    }
                                    case 5: {
                                        llllllllllllllIlIlIllllIIlllIlll = Entity1_14Types.HOPPER_MINECART.getId();
                                        break;
                                    }
                                    case 6: {
                                        llllllllllllllIlIlIllllIIlllIlll = Entity1_14Types.COMMAND_BLOCK_MINECART.getId();
                                        break;
                                    }
                                }
                            }
                            else if ((llllllllllllllIlIlIllllIIlllIIll.is(Entity1_14Types.ITEM) && llllllllllllllIlIlIllllIIlllllII > 0) || llllllllllllllIlIlIllllIIlllIIll.isOrHasParent(Entity1_14Types.ABSTRACT_ARROW)) {
                                if (llllllllllllllIlIlIllllIIlllIIll.isOrHasParent(Entity1_14Types.ABSTRACT_ARROW)) {
                                    llllllllllllllIlIlIllllIIlllIIII.set(Type.INT, 0, llllllllllllllIlIlIllllIIlllllII - 1);
                                }
                                final PacketWrapper llllllllllllllIlIlIllllIIllllllI = llllllllllllllIlIlIllllIIlllIIII.create(69);
                                llllllllllllllIlIlIllllIIllllllI.write(Type.VAR_INT, llllllllllllllIlIlIllllIIllllIII);
                                llllllllllllllIlIlIllllIIllllllI.write(Type.SHORT, (Short)llllllllllllllIlIlIllllIIlllIIII.get((Type<T>)Type.SHORT, 0));
                                llllllllllllllIlIlIllllIIllllllI.write(Type.SHORT, (Short)llllllllllllllIlIlIllllIIlllIIII.get((Type<T>)Type.SHORT, 1));
                                llllllllllllllIlIlIllllIIllllllI.write(Type.SHORT, (Short)llllllllllllllIlIlIllllIIlllIIII.get((Type<T>)Type.SHORT, 2));
                                llllllllllllllIlIlIllllIIllllllI.scheduleSend(Protocol1_14To1_13_2.class);
                            }
                            llllllllllllllIlIlIllllIIlllIIII.user().getEntityTracker(Protocol1_14To1_13_2.class).addEntity(llllllllllllllIlIlIllllIIllllIII, llllllllllllllIlIlIllllIIlllIIll);
                        }
                        llllllllllllllIlIlIllllIIlllIIII.set(Type.VAR_INT, 1, llllllllllllllIlIlIllllIIlllIlll);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lllllllllllllIIlIIIIIIIlIIIllIll).registerClientbound(ClientboundPackets1_13.SPAWN_MOB, new PacketRemapper() {
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
                this.map(Types1_13_2.METADATA_LIST, Types1_14.METADATA_LIST);
                this.handler(lllllllllllllIIlIIIIIIIlIIIlllII.trackerAndRewriterHandler(Types1_14.METADATA_LIST));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lllllllllllllIIlIIIIIIIlIIIllIll).registerClientbound(ClientboundPackets1_13.SPAWN_PAINTING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.map(Type.POSITION, Type.POSITION1_14);
                this.map(Type.BYTE);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lllllllllllllIIlIIIIIIIlIIIllIll).registerClientbound(ClientboundPackets1_13.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_13_2.METADATA_LIST, Types1_14.METADATA_LIST);
                this.handler(lllllllllllllIIlIIIIIIIlIIIlllII.trackerAndRewriterHandler(Types1_14.METADATA_LIST, Entity1_14Types.PLAYER));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)lllllllllllllIIlIIIIIIIlIIIllIll).registerClientbound(ClientboundPackets1_13.ENTITY_ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlIlllIIIIllIllIl) throws Exception {
                        final short lllllllllllllIlIlIlllIIIIllIlllI = lllllllllllllIlIlIlllIIIIllIllIl.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                        if (lllllllllllllIlIlIlllIIIIllIlllI == 2) {
                            final EntityTracker1_14 lllllllllllllIlIlIlllIIIIlllIlII = lllllllllllllIlIlIlllIIIIllIllIl.user().getEntityTracker(Protocol1_14To1_13_2.class);
                            final int lllllllllllllIlIlIlllIIIIlllIIll = lllllllllllllIlIlIlllIIIIllIllIl.get((Type<Integer>)Type.VAR_INT, 0);
                            lllllllllllllIlIlIlllIIIIlllIlII.setSleeping(lllllllllllllIlIlIlllIIIIlllIIll, false);
                            final PacketWrapper lllllllllllllIlIlIlllIIIIlllIIlI = lllllllllllllIlIlIlllIIIIllIllIl.create(ClientboundPackets1_14.ENTITY_METADATA);
                            lllllllllllllIlIlIlllIIIIlllIIlI.write(Type.VAR_INT, lllllllllllllIlIlIlllIIIIlllIIll);
                            final List<Metadata> lllllllllllllIlIlIlllIIIIlllIIIl = new LinkedList<Metadata>();
                            if (lllllllllllllIlIlIlllIIIIlllIlII.clientEntityId() != lllllllllllllIlIlIlllIIIIlllIIll) {
                                lllllllllllllIlIlIlllIIIIlllIIIl.add(new Metadata(6, MetaType1_14.Pose, MetadataRewriter1_14To1_13_2.recalculatePlayerPose(lllllllllllllIlIlIlllIIIIlllIIll, lllllllllllllIlIlIlllIIIIlllIlII)));
                            }
                            lllllllllllllIlIlIlllIIIIlllIIIl.add(new Metadata(12, MetaType1_14.OptPosition, null));
                            lllllllllllllIlIlIlllIIIIlllIIlI.write(Types1_14.METADATA_LIST, lllllllllllllIlIlIlllIIIIlllIIIl);
                            lllllllllllllIlIlIlllIIIIlllIIlI.scheduleSend(Protocol1_14To1_13_2.class);
                        }
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_13, ClientboundPackets1_14, S1, S2>)lllllllllllllIIlIIIIIIIlIIIllIll).registerClientbound(ClientboundPackets1_13.USE_BED, ClientboundPackets1_14.ENTITY_METADATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIIIIlllIlIllIIIl) throws Exception {
                        final EntityTracker1_14 lllllllllllllIIlIIIIlllIlIllIIII = lllllllllllllIIlIIIIlllIlIllIIIl.user().getEntityTracker(Protocol1_14To1_13_2.class);
                        final int lllllllllllllIIlIIIIlllIlIlIllll = lllllllllllllIIlIIIIlllIlIllIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        lllllllllllllIIlIIIIlllIlIllIIII.setSleeping(lllllllllllllIIlIIIIlllIlIlIllll, true);
                        final Position lllllllllllllIIlIIIIlllIlIlIlllI = lllllllllllllIIlIIIIlllIlIllIIIl.read(Type.POSITION);
                        final List<Metadata> lllllllllllllIIlIIIIlllIlIlIllIl = new LinkedList<Metadata>();
                        lllllllllllllIIlIIIIlllIlIlIllIl.add(new Metadata(12, MetaType1_14.OptPosition, lllllllllllllIIlIIIIlllIlIlIlllI));
                        if (lllllllllllllIIlIIIIlllIlIllIIII.clientEntityId() != lllllllllllllIIlIIIIlllIlIlIllll) {
                            lllllllllllllIIlIIIIlllIlIlIllIl.add(new Metadata(6, MetaType1_14.Pose, MetadataRewriter1_14To1_13_2.recalculatePlayerPose(lllllllllllllIIlIIIIlllIlIlIllll, lllllllllllllIIlIIIIlllIlIllIIII)));
                        }
                        lllllllllllllIIlIIIIlllIlIllIIIl.write(Types1_14.METADATA_LIST, lllllllllllllIIlIIIIlllIlIlIllIl);
                    }
                });
            }
        });
        lllllllllllllIIlIIIIIIIlIIIlllII.registerRemoveEntities(ClientboundPackets1_13.DESTROY_ENTITIES);
        lllllllllllllIIlIIIIIIIlIIIlllII.registerMetadataRewriter(ClientboundPackets1_13.ENTITY_METADATA, Types1_13_2.METADATA_LIST, Types1_14.METADATA_LIST);
    }
}
