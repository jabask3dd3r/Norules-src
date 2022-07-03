package com.viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.metadata.*;
import com.viaversion.viaversion.util.*;
import com.google.common.collect.*;
import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;

public class EntityPackets
{
    public static final /* synthetic */ ValueTransformer<Byte, Short> toNewShort;
    
    public static void register(final Protocol1_9To1_8 lllllllllllllIllIlllIIIIllIIllll) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ATTACH_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                this.map((Type<Object>)Type.BOOLEAN, (ValueTransformer<Object, Object>)new ValueTransformer<Boolean, Void>(Type.NOTHING) {
                    @Override
                    public Void transform(final PacketWrapper lllllllllllllllIIIIIIIlllIIllllI, final Boolean lllllllllllllllIIIIIIIlllIIlllIl) throws Exception {
                        final EntityTracker1_9 lllllllllllllllIIIIIIIlllIIlllll = lllllllllllllllIIIIIIIlllIIllllI.user().getEntityTracker(Protocol1_9To1_8.class);
                        if (!lllllllllllllllIIIIIIIlllIIlllIl) {
                            final int lllllllllllllllIIIIIIIlllIlIIlIl = lllllllllllllllIIIIIIIlllIIllllI.get((Type<Integer>)Type.INT, 0);
                            final int lllllllllllllllIIIIIIIlllIlIIlII = lllllllllllllllIIIIIIIlllIIllllI.get((Type<Integer>)Type.INT, 1);
                            lllllllllllllllIIIIIIIlllIIllllI.cancel();
                            final PacketWrapper lllllllllllllllIIIIIIIlllIlIIIll = lllllllllllllllIIIIIIIlllIIllllI.create(ClientboundPackets1_9.SET_PASSENGERS);
                            if (lllllllllllllllIIIIIIIlllIlIIlII == -1) {
                                if (!lllllllllllllllIIIIIIIlllIIlllll.getVehicleMap().containsKey(lllllllllllllllIIIIIIIlllIlIIlIl)) {
                                    return null;
                                }
                                lllllllllllllllIIIIIIIlllIlIIIll.write(Type.VAR_INT, lllllllllllllllIIIIIIIlllIIlllll.getVehicleMap().remove(lllllllllllllllIIIIIIIlllIlIIlIl));
                                lllllllllllllllIIIIIIIlllIlIIIll.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[0]);
                            }
                            else {
                                lllllllllllllllIIIIIIIlllIlIIIll.write(Type.VAR_INT, lllllllllllllllIIIIIIIlllIlIIlII);
                                lllllllllllllllIIIIIIIlllIlIIIll.write(Type.VAR_INT_ARRAY_PRIMITIVE, new int[] { lllllllllllllllIIIIIIIlllIlIIlIl });
                                lllllllllllllllIIIIIIIlllIIlllll.getVehicleMap().put(lllllllllllllllIIIIIIIlllIlIIlIl, lllllllllllllllIIIIIIIlllIlIIlII);
                            }
                            lllllllllllllllIIIIIIIlllIlIIIll.send(Protocol1_9To1_8.class);
                        }
                        return null;
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ENTITY_TELEPORT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.INT, SpawnPackets.toNewDouble);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlllllIIIIIIllllI) throws Exception {
                        final int lllllllllllllllIlllllIIIIIIlllIl = lllllllllllllllIlllllIIIIIIllllI.get((Type<Integer>)Type.VAR_INT, 0);
                        if (Via.getConfig().isHologramPatch()) {
                            final EntityTracker1_9 lllllllllllllllIlllllIIIIIlIIIII = lllllllllllllllIlllllIIIIIIllllI.user().getEntityTracker(Protocol1_9To1_8.class);
                            if (lllllllllllllllIlllllIIIIIlIIIII.getKnownHolograms().contains(lllllllllllllllIlllllIIIIIIlllIl)) {
                                Double lllllllllllllllIlllllIIIIIlIIIIl = lllllllllllllllIlllllIIIIIIllllI.get((Type<Double>)Type.DOUBLE, 1);
                                lllllllllllllllIlllllIIIIIlIIIIl += Via.getConfig().getHologramYOffset();
                                lllllllllllllllIlllllIIIIIIllllI.set(Type.DOUBLE, 1, lllllllllllllllIlllllIIIIIlIIIIl);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ENTITY_POSITION_AND_ROTATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE, EntityPackets.toNewShort);
                this.map(Type.BYTE, EntityPackets.toNewShort);
                this.map(Type.BYTE, EntityPackets.toNewShort);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ENTITY_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE, EntityPackets.toNewShort);
                this.map(Type.BYTE, EntityPackets.toNewShort);
                this.map(Type.BYTE, EntityPackets.toNewShort);
                this.map(Type.BOOLEAN);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map((Type<Object>)Type.SHORT, (ValueTransformer<Object, Object>)new ValueTransformer<Short, Integer>(Type.VAR_INT) {
                    @Override
                    public Integer transform(final PacketWrapper lllllllllllllIlIIlIIlIlIllIllIlI, final Short lllllllllllllIlIIlIIlIlIllIlllIl) throws Exception {
                        final int lllllllllllllIlIIlIIlIlIllIlllII = lllllllllllllIlIIlIIlIlIllIllIlI.get((Type<Integer>)Type.VAR_INT, 0);
                        final int lllllllllllllIlIIlIIlIlIllIllIll = lllllllllllllIlIIlIIlIlIllIllIlI.user().getEntityTracker(Protocol1_9To1_8.class).clientEntityId();
                        if (lllllllllllllIlIIlIIlIlIllIlllII == lllllllllllllIlIIlIIlIlIllIllIll) {
                            return lllllllllllllIlIIlIIlIlIllIlllIl + 2;
                        }
                        return (Integer)((lllllllllllllIlIIlIIlIlIllIlllIl > 0) ? (lllllllllllllIlIIlIIlIlIllIlllIl + 1) : lllllllllllllIlIIlIIlIlIllIlllIl);
                    }
                });
                this.map(Type.ITEM);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIllIlIlIllIlIIIl) throws Exception {
                        final Item lllllllllllllIllIllIlIlIllIlIIlI = lllllllllllllIllIllIlIlIllIlIIIl.get(Type.ITEM, 0);
                        ItemRewriter.toClient(lllllllllllllIllIllIlIlIllIlIIlI);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIllIIIIIllllIIIl) throws Exception {
                        final EntityTracker1_9 lllllllllllllIlIIllIIIIIllllIlII = lllllllllllllIlIIllIIIIIllllIIIl.user().getEntityTracker(Protocol1_9To1_8.class);
                        final int lllllllllllllIlIIllIIIIIllllIIll = lllllllllllllIlIIllIIIIIllllIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        final Item lllllllllllllIlIIllIIIIIllllIIlI = lllllllllllllIlIIllIIIIIllllIIIl.get(Type.ITEM, 0);
                        if (lllllllllllllIlIIllIIIIIllllIIlI != null && Protocol1_9To1_8.isSword(lllllllllllllIlIIllIIIIIllllIIlI.identifier())) {
                            lllllllllllllIlIIllIIIIIllllIlII.getValidBlocking().add(lllllllllllllIlIIllIIIIIllllIIll);
                            return;
                        }
                        lllllllllllllIlIIllIIIIIllllIlII.getValidBlocking().remove(lllllllllllllIlIIllIIIIIllllIIll);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ENTITY_METADATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Types1_8.METADATA_LIST, Types1_9.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllIlllIIIIIIlllI) throws Exception {
                        final List<Metadata> lllllllllllllIIIllIlllIIIIIlIIlI = lllllllllllllIIIllIlllIIIIIIlllI.get(Types1_9.METADATA_LIST, 0);
                        final int lllllllllllllIIIllIlllIIIIIlIIIl = lllllllllllllIIIllIlllIIIIIIlllI.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 lllllllllllllIIIllIlllIIIIIlIIII = lllllllllllllIIIllIlllIIIIIIlllI.user().getEntityTracker(Protocol1_9To1_8.class);
                        if (lllllllllllllIIIllIlllIIIIIlIIII.hasEntity(lllllllllllllIIIllIlllIIIIIlIIIl)) {
                            lllllllllllllIllIlllIIIIllIIllll.get(MetadataRewriter1_9To1_8.class).handleMetadata(lllllllllllllIIIllIlllIIIIIlIIIl, lllllllllllllIIIllIlllIIIIIlIIlI, lllllllllllllIIIllIlllIIIIIIlllI.user());
                        }
                        else {
                            lllllllllllllIIIllIlllIIIIIlIIII.addMetadataToBuffer(lllllllllllllIIIllIlllIIIIIlIIIl, lllllllllllllIIIllIlllIIIIIlIIlI);
                            lllllllllllllIIIllIlllIIIIIIlllI.cancel();
                        }
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIllIlllIlIlIIIII) throws Exception {
                        final List<Metadata> llllllllllllllllIllIlllIlIIllllI = llllllllllllllllIllIlllIlIlIIIII.get(Types1_9.METADATA_LIST, 0);
                        final int llllllllllllllllIllIlllIlIIlllII = llllllllllllllllIllIlllIlIlIIIII.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityTracker1_9 llllllllllllllllIllIlllIlIIllIlI = llllllllllllllllIllIlllIlIlIIIII.user().getEntityTracker(Protocol1_9To1_8.class);
                        llllllllllllllllIllIlllIlIIllIlI.handleMetadata(llllllllllllllllIllIlllIlIIlllII, llllllllllllllllIllIlllIlIIllllI);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllIIIlIlllIIlllll) throws Exception {
                        final List<Metadata> lllllllllllllllllIIIlIlllIIlllIl = lllllllllllllllllIIIlIlllIIlllll.get(Types1_9.METADATA_LIST, 0);
                        if (lllllllllllllllllIIIlIlllIIlllIl.isEmpty()) {
                            lllllllllllllllllIIIlIlllIIlllll.cancel();
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ENTITY_EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlllIIlIIIlIIllIlI) throws Exception {
                        final boolean lllllllllllllIIlllIIlIIIlIIlllII = lllllllllllllIIlllIIlIIIlIIllIlI.read((Type<Boolean>)Type.BOOLEAN);
                        final boolean lllllllllllllIIlllIIlIIIlIIllIll = Via.getConfig().isNewEffectIndicator();
                        lllllllllllllIIlllIIlIIIlIIllIlI.write(Type.BYTE, (byte)(lllllllllllllIIlllIIlIIIlIIlllII ? (lllllllllllllIIlllIIlIIIlIIllIll ? 2 : 1) : 0));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).cancelClientbound(ClientboundPackets1_8.UPDATE_ENTITY_NBT);
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.COMBAT_EVENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIIlIlIllIllllll) throws Exception {
                        if (lllllllllllllIIIIIIlIlIllIllllll.get((Type<Integer>)Type.VAR_INT, 0) == 2) {
                            lllllllllllllIIIIIIlIlIllIllllll.passthrough((Type<Object>)Type.VAR_INT);
                            lllllllllllllIIIIIIlIlIllIllllll.passthrough((Type<Object>)Type.INT);
                            Protocol1_9To1_8.FIX_JSON.write(lllllllllllllIIIIIIlIlIllIllllll, lllllllllllllIIIIIIlIlIllIllllll.read(Type.STRING));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ENTITY_PROPERTIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlIllIIlIIllIIllI) throws Exception {
                        if (!Via.getConfig().isMinimizeCooldown()) {
                            return;
                        }
                        final EntityTracker1_9 lllllllllllllllIlIllIIlIIllIlIIl = lllllllllllllllIlIllIIlIIllIIllI.user().getEntityTracker(Protocol1_9To1_8.class);
                        if (lllllllllllllllIlIllIIlIIllIIllI.get((Type<Integer>)Type.VAR_INT, 0) != lllllllllllllllIlIllIIlIIllIlIIl.getProvidedEntityId()) {
                            return;
                        }
                        final int lllllllllllllllIlIllIIlIIllIlIII = lllllllllllllllIlIllIIlIIllIIllI.read((Type<Integer>)Type.INT);
                        final Map<String, Pair<Double, List<Triple<UUID, Double, Byte>>>> lllllllllllllllIlIllIIlIIllIIlll = new HashMap<String, Pair<Double, List<Triple<UUID, Double, Byte>>>>(lllllllllllllllIlIllIIlIIllIlIII);
                        for (int lllllllllllllllIlIllIIlIIllIlllI = 0; lllllllllllllllIlIllIIlIIllIlllI < lllllllllllllllIlIllIIlIIllIlIII; ++lllllllllllllllIlIllIIlIIllIlllI) {
                            final String lllllllllllllllIlIllIIlIIlllIIlI = lllllllllllllllIlIllIIlIIllIIllI.read(Type.STRING);
                            final Double lllllllllllllllIlIllIIlIIlllIIIl = lllllllllllllllIlIllIIlIIllIIllI.read((Type<Double>)Type.DOUBLE);
                            final int lllllllllllllllIlIllIIlIIlllIIII = lllllllllllllllIlIllIIlIIllIIllI.read((Type<Integer>)Type.VAR_INT);
                            final List<Triple<UUID, Double, Byte>> lllllllllllllllIlIllIIlIIllIllll = new ArrayList<Triple<UUID, Double, Byte>>(lllllllllllllllIlIllIIlIIlllIIII);
                            for (int lllllllllllllllIlIllIIlIIlllIIll = 0; lllllllllllllllIlIllIIlIIlllIIll < lllllllllllllllIlIllIIlIIlllIIII; ++lllllllllllllllIlIllIIlIIlllIIll) {
                                lllllllllllllllIlIllIIlIIllIllll.add(new Triple<UUID, Double, Byte>(lllllllllllllllIlIllIIlIIllIIllI.read(Type.UUID), lllllllllllllllIlIllIIlIIllIIllI.read((Type<Double>)Type.DOUBLE), lllllllllllllllIlIllIIlIIllIIllI.read((Type<Byte>)Type.BYTE)));
                            }
                            lllllllllllllllIlIllIIlIIllIIlll.put(lllllllllllllllIlIllIIlIIlllIIlI, new Pair<Double, List<Triple<UUID, Double, Byte>>>(lllllllllllllllIlIllIIlIIlllIIIl, lllllllllllllllIlIllIIlIIllIllll));
                        }
                        lllllllllllllllIlIllIIlIIllIIlll.put("generic.attackSpeed", new Pair<Double, List<Triple<UUID, Double, Byte>>>(15.9, (List<Triple<UUID, Double, Byte>>)ImmutableList.of((Object)new Triple(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), 0.0, 0), (Object)new Triple(UUID.fromString("AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3"), 0.0, 2), (Object)new Triple(UUID.fromString("55FCED67-E92A-486E-9800-B47F202C4386"), 0.0, 2))));
                        lllllllllllllllIlIllIIlIIllIIllI.write(Type.INT, lllllllllllllllIlIllIIlIIllIIlll.size());
                        for (final Map.Entry<String, Pair<Double, List<Triple<UUID, Double, Byte>>>> lllllllllllllllIlIllIIlIIllIllII : lllllllllllllllIlIllIIlIIllIIlll.entrySet()) {
                            lllllllllllllllIlIllIIlIIllIIllI.write(Type.STRING, lllllllllllllllIlIllIIlIIllIllII.getKey());
                            lllllllllllllllIlIllIIlIIllIIllI.write(Type.DOUBLE, lllllllllllllllIlIllIIlIIllIllII.getValue().getKey());
                            lllllllllllllllIlIllIIlIIllIIllI.write(Type.VAR_INT, lllllllllllllllIlIllIIlIIllIllII.getValue().getValue().size());
                            for (final Triple<UUID, Double, Byte> lllllllllllllllIlIllIIlIIllIllIl : lllllllllllllllIlIllIIlIIllIllII.getValue().getValue()) {
                                lllllllllllllllIlIllIIlIIllIIllI.write(Type.UUID, lllllllllllllllIlIllIIlIIllIllIl.getFirst());
                                lllllllllllllllIlIllIIlIIllIIllI.write(Type.DOUBLE, lllllllllllllllIlIllIIlIIllIllIl.getSecond());
                                lllllllllllllllIlIllIIlIIllIIllI.write(Type.BYTE, lllllllllllllllIlIllIIlIIllIllIl.getThird());
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)lllllllllllllIllIlllIIIIllIIllll).registerClientbound(ClientboundPackets1_8.ENTITY_ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIllIlIlIlIIlIlII) throws Exception {
                        if (lllllllllllllIlIIllIlIlIlIIlIlII.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 3) {
                            lllllllllllllIlIIllIlIlIlIIlIlII.cancel();
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)lllllllllllllIllIlllIIIIllIIllll).registerServerbound(ServerboundPackets1_9.ENTITY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllIIllIllllllllIl) throws Exception {
                        final int lllllllllllllIIllIIllIlllllllllI = lllllllllllllIIllIIllIllllllllIl.get((Type<Integer>)Type.VAR_INT, 1);
                        if (lllllllllllllIIllIIllIlllllllllI == 6 || lllllllllllllIIllIIllIlllllllllI == 8) {
                            lllllllllllllIIllIIllIllllllllIl.cancel();
                        }
                        if (lllllllllllllIIllIIllIlllllllllI == 7) {
                            lllllllllllllIIllIIllIllllllllIl.set(Type.VAR_INT, 1, 6);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9>)lllllllllllllIllIlllIIIIllIIllll).registerServerbound(ServerboundPackets1_9.INTERACT_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIlIIIllIIIlIIllI) throws Exception {
                        final int lllllllllllllIIlIlIIIllIIIlIIlIl = lllllllllllllIIlIlIIIllIIIlIIllI.get((Type<Integer>)Type.VAR_INT, 1);
                        if (lllllllllllllIIlIlIIIllIIIlIIlIl == 2) {
                            lllllllllllllIIlIlIIIllIIIlIIllI.passthrough((Type<Object>)Type.FLOAT);
                            lllllllllllllIIlIlIIIllIIIlIIllI.passthrough((Type<Object>)Type.FLOAT);
                            lllllllllllllIIlIlIIIllIIIlIIllI.passthrough((Type<Object>)Type.FLOAT);
                        }
                        if (lllllllllllllIIlIlIIIllIIIlIIlIl == 0 || lllllllllllllIIlIlIIIllIIIlIIlIl == 2) {
                            final int lllllllllllllIIlIlIIIllIIIlIlIII = lllllllllllllIIlIlIIIllIIIlIIllI.read((Type<Integer>)Type.VAR_INT);
                            if (lllllllllllllIIlIlIIIllIIIlIlIII == 1) {
                                lllllllllllllIIlIlIIIllIIIlIIllI.cancel();
                            }
                        }
                    }
                });
            }
        });
    }
    
    static {
        toNewShort = new ValueTransformer<Byte, Short>() {
            @Override
            public Short transform(final PacketWrapper llIlIIIlIIIIIl, final Byte llIlIIIIllllll) {
                return (short)(llIlIIIIllllll * 128);
            }
        };
    }
}
