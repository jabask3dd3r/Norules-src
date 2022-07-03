package com.viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.protocol.*;

public class SpawnPackets
{
    public static final /* synthetic */ ValueTransformer<Integer, Double> toNewDouble;
    
    public static void register(final Protocol1_9To1_8 lllllllllllllllllIIIlllIIlIlllll) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIIIlllIIlIlllll).registerClientbound(ClientboundPackets1_8.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIIIlIIlllIlIIIIl) throws Exception {
                        final int lllllllllllllIlIIIIlIIlllIlIIIll = lllllllllllllIlIIIIlIIlllIlIIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllIlIIIIlIIlllIlIIIlI = lllllllllllllIlIIIIlIIlllIlIIIIl.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIlIIIIlIIlllIlIIIIl.write(Type.UUID, lllllllllllllIlIIIIlIIlllIlIIIlI.getEntityUUID(lllllllllllllIlIIIIlIIlllIlIIIll));
                    }
                });
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIIIIllIIllIlIll) throws Exception {
                        final int lllllllllllllIIIIIIIIllIIllIlIlI = lllllllllllllIIIIIIIIllIIllIlIll.get((Type<Integer>)Type.VAR_INT, 0);
                        final int lllllllllllllIIIIIIIIllIIllIlIIl = lllllllllllllIIIIIIIIllIIllIlIll.get((Type<Byte>)Type.BYTE, 0);
                        final EntityTracker1_9 lllllllllllllIIIIIIIIllIIllIlIII = lllllllllllllIIIIIIIIllIIllIlIll.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIIIIIIIIllIIllIlIII.addEntity(lllllllllllllIIIIIIIIllIIllIlIlI, Entity1_10Types.getTypeFromId(lllllllllllllIIIIIIIIllIIllIlIIl, true));
                        lllllllllllllIIIIIIIIllIIllIlIII.sendMetadataBuffer(lllllllllllllIIIIIIIIllIIllIlIlI);
                    }
                });
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllllIlllllllIIIIll) throws Exception {
                        final int lllllllllllllIllllIlllllllIIIlll = lllllllllllllIllllIlllllllIIIIll.get((Type<Integer>)Type.INT, 0);
                        short lllllllllllllIllllIlllllllIIIllI = 0;
                        short lllllllllllllIllllIlllllllIIIlIl = 0;
                        short lllllllllllllIllllIlllllllIIIlII = 0;
                        if (lllllllllllllIllllIlllllllIIIlll > 0) {
                            lllllllllllllIllllIlllllllIIIllI = lllllllllllllIllllIlllllllIIIIll.read((Type<Short>)Type.SHORT);
                            lllllllllllllIllllIlllllllIIIlIl = lllllllllllllIllllIlllllllIIIIll.read((Type<Short>)Type.SHORT);
                            lllllllllllllIllllIlllllllIIIlII = lllllllllllllIllllIlllllllIIIIll.read((Type<Short>)Type.SHORT);
                        }
                        lllllllllllllIllllIlllllllIIIIll.write(Type.SHORT, lllllllllllllIllllIlllllllIIIllI);
                        lllllllllllllIllllIlllllllIIIIll.write(Type.SHORT, lllllllllllllIllllIlllllllIIIlIl);
                        lllllllllllllIllllIlllllllIIIIll.write(Type.SHORT, lllllllllllllIllllIlllllllIIIlII);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIllIlllIlIIIlIllI) throws Exception {
                        final int llllllllllllllIIllIlllIlIIIlIlIl = llllllllllllllIIllIlllIlIIIlIllI.get((Type<Integer>)Type.VAR_INT, 0);
                        final int llllllllllllllIIllIlllIlIIIlIlII = llllllllllllllIIllIlllIlIIIlIllI.get((Type<Integer>)Type.INT, 0);
                        final int llllllllllllllIIllIlllIlIIIlIIll = llllllllllllllIIllIlllIlIIIlIllI.get((Type<Byte>)Type.BYTE, 0);
                        if (Entity1_10Types.getTypeFromId(llllllllllllllIIllIlllIlIIIlIIll, true) == Entity1_10Types.EntityType.SPLASH_POTION) {
                            final PacketWrapper llllllllllllllIIllIlllIlIIIllIII = llllllllllllllIIllIlllIlIIIlIllI.create(57, new PacketHandler() {
                                @Override
                                public void handle(final PacketWrapper llllllllllllllIIIllIlIlIlllIllIl) throws Exception {
                                    llllllllllllllIIIllIlIlIlllIllIl.write(Type.VAR_INT, llllllllllllllIIllIlllIlIIIlIlIl);
                                    final List<Metadata> llllllllllllllIIIllIlIlIlllIllII = new ArrayList<Metadata>();
                                    final Item llllllllllllllIIIllIlIlIlllIlIll = new DataItem(373, (byte)1, (short)llllllllllllllIIllIlllIlIIIlIlII, null);
                                    ItemRewriter.toClient(llllllllllllllIIIllIlIlIlllIlIll);
                                    final Metadata llllllllllllllIIIllIlIlIlllIlIlI = new Metadata(5, MetaType1_9.Slot, llllllllllllllIIIllIlIlIlllIlIll);
                                    llllllllllllllIIIllIlIlIlllIllII.add(llllllllllllllIIIllIlIlIlllIlIlI);
                                    llllllllllllllIIIllIlIlIlllIllIl.write(Types1_9.METADATA_LIST, llllllllllllllIIIllIlIlIlllIllII);
                                }
                            });
                            llllllllllllllIIllIlllIlIIIllIII.scheduleSend(Protocol1_9To1_8.class);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIIIlllIIlIlllll).registerClientbound(ClientboundPackets1_8.SPAWN_EXPERIENCE_ORB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllllllllIlIllIIII) throws Exception {
                        final int lllllllllllllIIllllllllIlIlIllll = lllllllllllllIIllllllllIlIllIIII.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllIIllllllllIlIlIlllI = lllllllllllllIIllllllllIlIllIIII.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIIllllllllIlIlIlllI.addEntity(lllllllllllllIIllllllllIlIlIllll, Entity1_10Types.EntityType.EXPERIENCE_ORB);
                        lllllllllllllIIllllllllIlIlIlllI.sendMetadataBuffer(lllllllllllllIIllllllllIlIlIllll);
                    }
                });
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.SHORT);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIIIlllIIlIlllll).registerClientbound(ClientboundPackets1_8.SPAWN_GLOBAL_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIllIlIIIIIlIIIlll) throws Exception {
                        final int lllllllllllllllIllIlIIIIIlIIIlIl = lllllllllllllllIllIlIIIIIlIIIlll.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllllIllIlIIIIIlIIIIll = lllllllllllllllIllIlIIIIIlIIIlll.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllllIllIlIIIIIlIIIIll.addEntity(lllllllllllllllIllIlIIIIIlIIIlIl, Entity1_10Types.EntityType.LIGHTNING);
                        lllllllllllllllIllIlIIIIIlIIIIll.sendMetadataBuffer(lllllllllllllllIllIlIIIIIlIIIlIl);
                    }
                });
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIIIlllIIlIlllll).registerClientbound(ClientboundPackets1_8.SPAWN_MOB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIllIlIIllIIllIIIl) throws Exception {
                        final int lllllllllllllIlIllIlIIllIIllIIII = lllllllllllllIlIllIlIIllIIllIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllIlIllIlIIllIIlIlllI = lllllllllllllIlIllIlIIllIIllIIIl.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIlIllIlIIllIIllIIIl.write(Type.UUID, lllllllllllllIlIllIlIIllIIlIlllI.getEntityUUID(lllllllllllllIlIllIlIIllIIllIIII));
                    }
                });
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllIIllIlllIlllll) throws Exception {
                        final int lllllllllllllIIIllIIllIlllIllllI = lllllllllllllIIIllIIllIlllIlllll.get((Type<Integer>)Type.VAR_INT, 0);
                        final int lllllllllllllIIIllIIllIlllIlllIl = lllllllllllllIIIllIIllIlllIlllll.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        final EntityTracker1_9 lllllllllllllIIIllIIllIlllIlllII = lllllllllllllIIIllIIllIlllIlllll.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIIIllIIllIlllIlllII.addEntity(lllllllllllllIIIllIIllIlllIllllI, Entity1_10Types.getTypeFromId(lllllllllllllIIIllIIllIlllIlllIl, false));
                        lllllllllllllIIIllIIllIlllIlllII.sendMetadataBuffer(lllllllllllllIIIllIIllIlllIllllI);
                    }
                });
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_8.METADATA_LIST, Types1_9.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllIlIIIIIlllllII) throws Exception {
                        final List<Metadata> lllllllllllllIIIllIlIIIIIllllIll = lllllllllllllIIIllIlIIIIIlllllII.get(Types1_9.METADATA_LIST, 0);
                        final int lllllllllllllIIIllIlIIIIIllllIlI = lllllllllllllIIIllIlIIIIIlllllII.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllIIIllIlIIIIIllllIIl = lllllllllllllIIIllIlIIIIIlllllII.user().getEntityTracker(Protocol1_9To1_8.class);
                        if (lllllllllllllIIIllIlIIIIIllllIIl.hasEntity(lllllllllllllIIIllIlIIIIIllllIlI)) {
                            lllllllllllllllllIIIlllIIlIlllll.get(MetadataRewriter1_9To1_8.class).handleMetadata(lllllllllllllIIIllIlIIIIIllllIlI, lllllllllllllIIIllIlIIIIIllllIll, lllllllllllllIIIllIlIIIIIlllllII.user());
                        }
                        else {
                            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Unable to find entity for metadata, entity ID: ").append(lllllllllllllIIIllIlIIIIIllllIlI)));
                            lllllllllllllIIIllIlIIIIIllllIll.clear();
                        }
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIIlIIlIllIIIllII) throws Exception {
                        final List<Metadata> llllllllllllllIlIIlIIlIllIIIlIll = llllllllllllllIlIIlIIlIllIIIllII.get(Types1_9.METADATA_LIST, 0);
                        final int llllllllllllllIlIIlIIlIllIIIlIlI = llllllllllllllIlIIlIIlIllIIIllII.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 llllllllllllllIlIIlIIlIllIIIlIIl = llllllllllllllIlIIlIIlIllIIIllII.user().getEntityTracker(Protocol1_9To1_8.class);
                        llllllllllllllIlIIlIIlIllIIIlIIl.handleMetadata(llllllllllllllIlIIlIIlIllIIIlIlI, llllllllllllllIlIIlIIlIllIIIlIll);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIIIlllIIlIlllll).registerClientbound(ClientboundPackets1_8.SPAWN_PAINTING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lIIIlllIlIIIlI) throws Exception {
                        final int lIIIlllIlIIlII = lIIIlllIlIIIlI.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lIIIlllIlIIIll = lIIIlllIlIIIlI.user().getEntityTracker(Protocol1_9To1_8.class);
                        lIIIlllIlIIIll.addEntity(lIIIlllIlIIlII, Entity1_10Types.EntityType.PAINTING);
                        lIIIlllIlIIIll.sendMetadataBuffer(lIIIlllIlIIlII);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIllIIllIlIlIllllI) throws Exception {
                        final int lllllllllllllllIllIIllIlIlIlllIl = lllllllllllllllIllIIllIlIlIllllI.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllllIllIIllIlIlIlllII = lllllllllllllllIllIIllIlIlIllllI.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllllIllIIllIlIlIllllI.write(Type.UUID, lllllllllllllllIllIIllIlIlIlllII.getEntityUUID(lllllllllllllllIllIIllIlIlIlllIl));
                    }
                });
                this.map(Type.STRING);
                this.map(Type.POSITION);
                this.map(Type.BYTE);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIIIlllIIlIlllll).registerClientbound(ClientboundPackets1_8.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIllIlllIlIlIllllI) throws Exception {
                        final int llllllllllllllIIllIlllIlIllIIIII = llllllllllllllIIllIlllIlIlIllllI.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 llllllllllllllIIllIlllIlIlIlllll = llllllllllllllIIllIlllIlIlIllllI.user().getEntityTracker(Protocol1_9To1_8.class);
                        llllllllllllllIIllIlllIlIlIlllll.addEntity(llllllllllllllIIllIlllIlIllIIIII, Entity1_10Types.EntityType.PLAYER);
                        llllllllllllllIIllIlllIlIlIlllll.sendMetadataBuffer(llllllllllllllIIllIlllIlIllIIIII);
                    }
                });
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllllIllIllIllllIII) throws Exception {
                        final short lllllllllllllIllllIllIllIlllIlll = lllllllllllllIllllIllIllIllllIII.read((Type<Short>)Type.SHORT);
                        if (lllllllllllllIllllIllIllIlllIlll != 0) {
                            final PacketWrapper lllllllllllllIllllIllIllIllllIlI = PacketWrapper.create(ClientboundPackets1_9.ENTITY_EQUIPMENT, null, lllllllllllllIllllIllIllIllllIII.user());
                            lllllllllllllIllllIllIllIllllIlI.write(Type.VAR_INT, (Integer)lllllllllllllIllllIllIllIllllIII.get((Type<T>)Type.VAR_INT, 0));
                            lllllllllllllIllllIllIllIllllIlI.write(Type.VAR_INT, 0);
                            lllllllllllllIllllIllIllIllllIlI.write((Type<DataItem>)Type.ITEM, new DataItem(lllllllllllllIllllIllIllIlllIlll, (byte)1, (short)0, null));
                            try {
                                lllllllllllllIllllIllIllIllllIlI.send(Protocol1_9To1_8.class);
                            }
                            catch (Exception lllllllllllllIllllIllIllIllllIll) {
                                lllllllllllllIllllIllIllIllllIll.printStackTrace();
                            }
                        }
                    }
                });
                this.map(Types1_8.METADATA_LIST, Types1_9.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIIIlIllIlIllllI) throws Exception {
                        final List<Metadata> lllllllllllllIIIIIIIlIllIlIlllIl = lllllllllllllIIIIIIIlIllIlIllllI.get(Types1_9.METADATA_LIST, 0);
                        final int lllllllllllllIIIIIIIlIllIlIlllII = lllllllllllllIIIIIIIlIllIlIllllI.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllIIIIIIIlIllIlIllIll = lllllllllllllIIIIIIIlIllIlIllllI.user().getEntityTracker(Protocol1_9To1_8.class);
                        if (lllllllllllllIIIIIIIlIllIlIllIll.hasEntity(lllllllllllllIIIIIIIlIllIlIlllII)) {
                            lllllllllllllllllIIIlllIIlIlllll.get(MetadataRewriter1_9To1_8.class).handleMetadata(lllllllllllllIIIIIIIlIllIlIlllII, lllllllllllllIIIIIIIlIllIlIlllIl, lllllllllllllIIIIIIIlIllIlIllllI.user());
                        }
                        else {
                            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Unable to find entity for metadata, entity ID: ").append(lllllllllllllIIIIIIIlIllIlIlllII)));
                            lllllllllllllIIIIIIIlIllIlIlllIl.clear();
                        }
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIIlIlIIlIlIlIlIl) throws Exception {
                        final List<Metadata> lllllllllllllIlIIIlIlIIlIlIlIlII = lllllllllllllIlIIIlIlIIlIlIlIlIl.get(Types1_9.METADATA_LIST, 0);
                        final int lllllllllllllIlIIIlIlIIlIlIlIIll = lllllllllllllIlIIIlIlIIlIlIlIlIl.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllIlIIIlIlIIlIlIlIIlI = lllllllllllllIlIIIlIlIIlIlIlIlIl.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIlIIIlIlIIlIlIlIIlI.handleMetadata(lllllllllllllIlIIIlIlIIlIlIlIIll, lllllllllllllIlIIIlIlIIlIlIlIlII);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllllllIIIlllIIlIlllll).registerClientbound(ClientboundPackets1_8.DESTROY_ENTITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT_ARRAY_PRIMITIVE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIllIllllIIIlIlIl) throws Exception {
                        final char llllllllllllllIIIllIllllIIIlIIIl;
                        final int[] llllllllllllllIIIllIllllIIIlIlII = (Object)(llllllllllllllIIIllIllllIIIlIIIl = (char)(Object)llllllllllllllIIIllIllllIIIlIlIl.get(Type.VAR_INT_ARRAY_PRIMITIVE, 0));
                        final long llllllllllllllIIIllIllllIIIlIIII = llllllllllllllIIIllIllllIIIlIIIl.length;
                        for (boolean llllllllllllllIIIllIllllIIIIllll = false; (llllllllllllllIIIllIllllIIIIllll ? 1 : 0) < llllllllllllllIIIllIllllIIIlIIII; ++llllllllllllllIIIllIllllIIIIllll) {
                            final int llllllllllllllIIIllIllllIIIlIlll = llllllllllllllIIIllIllllIIIlIIIl[llllllllllllllIIIllIllllIIIIllll];
                            llllllllllllllIIIllIllllIIIlIlIl.user().getEntityTracker(Protocol1_9To1_8.class).removeEntity(llllllllllllllIIIllIllllIIIlIlll);
                        }
                    }
                });
            }
        });
    }
    
    static {
        toNewDouble = new ValueTransformer<Integer, Double>() {
            @Override
            public Double transform(final PacketWrapper lllllllllllllIlIlllIIIIllIlIIIlI, final Integer lllllllllllllIlIlllIIIIllIlIIIIl) {
                return lllllllllllllIlIlllIIIIllIlIIIIl / 32.0;
            }
        };
    }
}
