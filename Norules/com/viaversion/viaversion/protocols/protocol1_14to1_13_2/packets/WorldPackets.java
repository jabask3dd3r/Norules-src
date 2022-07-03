package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import com.viaversion.viaversion.api.connection.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.types.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.types.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.storage.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.util.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.*;

public class WorldPackets
{
    private static final /* synthetic */ byte[] FULL_LIGHT;
    public static /* synthetic */ int voidAir;
    public static /* synthetic */ int air;
    public static /* synthetic */ int caveAir;
    
    private static void sendViewDistancePacket(final UserConnection llllllllllllIlllllllIlIlIlIIllll) throws Exception {
        final PacketWrapper llllllllllllIlllllllIlIlIlIIlllI = PacketWrapper.create(ClientboundPackets1_14.UPDATE_VIEW_DISTANCE, null, llllllllllllIlllllllIlIlIlIIllll);
        llllllllllllIlllllllIlIlIlIIlllI.write(Type.VAR_INT, 64);
        llllllllllllIlllllllIlIlIlIIlllI.send(Protocol1_14To1_13_2.class);
    }
    
    public static void register(final Protocol1_14To1_13_2 llllllllllllIlllllllIlIlIlIlIlIl) {
        final BlockRewriter llllllllllllIlllllllIlIlIlIlIlII = new BlockRewriter(llllllllllllIlllllllIlIlIlIlIlIl, null);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.BLOCK_BREAK_ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.POSITION, Type.POSITION1_14);
                this.map(Type.BYTE);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION, Type.POSITION1_14);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.BLOCK_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION, Type.POSITION1_14);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIlIlIIIlIIlIIlll) throws Exception {
                        lllllllllllllIIlIlIlIIIlIIlIIlll.set(Type.VAR_INT, 0, llllllllllllIlllllllIlIlIlIlIlIl.getMappingData().getNewBlockId(lllllllllllllIIlIlIlIIIlIIlIIlll.get((Type<Integer>)Type.VAR_INT, 0)));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION, Type.POSITION1_14);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllllIllIIlIIllIl) throws Exception {
                        final int lllllllllllllIIIllllIllIIlIIllll = lllllllllllllIIIllllIllIIlIIllIl.get((Type<Integer>)Type.VAR_INT, 0);
                        lllllllllllllIIIllllIllIIlIIllIl.set(Type.VAR_INT, 0, llllllllllllIlllllllIlIlIlIlIlIl.getMappingData().getNewBlockStateId(lllllllllllllIIIllllIllIIlIIllll));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.SERVER_DIFFICULTY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlIIllIllIIIllIIl) throws Exception {
                        lllllllllllllIIIlIIllIllIIIllIIl.write(Type.BOOLEAN, false);
                    }
                });
            }
        });
        llllllllllllIlllllllIlIlIlIlIlII.registerMultiBlockChange(ClientboundPackets1_13.MULTI_BLOCK_CHANGE);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.EXPLOSION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIIIIIIlIIllIll) throws Exception {
                        for (int lllllllllllllIIIIlIIIIIIlIIllllI = 0; lllllllllllllIIIIlIIIIIIlIIllllI < 3; ++lllllllllllllIIIIlIIIIIIlIIllllI) {
                            float lllllllllllllIIIIlIIIIIIlIIlllll = lllllllllllllIIIIlIIIIIIlIIllIll.get((Type<Float>)Type.FLOAT, lllllllllllllIIIIlIIIIIIlIIllllI);
                            if (lllllllllllllIIIIlIIIIIIlIIlllll < 0.0f) {
                                lllllllllllllIIIIlIIIIIIlIIlllll = (float)(int)lllllllllllllIIIIlIIIIIIlIIlllll;
                                lllllllllllllIIIIlIIIIIIlIIllIll.set(Type.FLOAT, lllllllllllllIIIIlIIIIIIlIIllllI, lllllllllllllIIIIlIIIIIIlIIlllll);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllIllllllIIIIllIIIIlII) throws Exception {
                        final ClientWorld llllllllllllIllllllIIIIllIIlIIII = llllllllllllIllllllIIIIllIIIIlII.user().get(ClientWorld.class);
                        final Chunk llllllllllllIllllllIIIIllIIIllll = llllllllllllIllllllIIIIllIIIIlII.read((Type<Chunk>)new Chunk1_13Type(llllllllllllIllllllIIIIllIIlIIII));
                        llllllllllllIllllllIIIIllIIIIlII.write(new Chunk1_14Type(), llllllllllllIllllllIIIIllIIIllll);
                        final int[] llllllllllllIllllllIIIIllIIIlllI = new int[256];
                        final int[] llllllllllllIllllllIIIIllIIIllIl = new int[256];
                        for (int llllllllllllIllllllIIIIllIIllIIl = 0; llllllllllllIllllllIIIIllIIllIIl < llllllllllllIllllllIIIIllIIIllll.getSections().length; ++llllllllllllIllllllIIIIllIIllIIl) {
                            final ChunkSection llllllllllllIllllllIIIIllIIlllII = llllllllllllIllllllIIIIllIIIllll.getSections()[llllllllllllIllllllIIIIllIIllIIl];
                            if (llllllllllllIllllllIIIIllIIlllII != null) {
                                boolean llllllllllllIllllllIIIIllIIllIll = false;
                                for (int llllllllllllIllllllIIIIllIlIIIIl = 0; llllllllllllIllllllIIIIllIlIIIIl < llllllllllllIllllllIIIIllIIlllII.getPaletteSize(); ++llllllllllllIllllllIIIIllIlIIIIl) {
                                    final int llllllllllllIllllllIIIIllIlIIIll = llllllllllllIllllllIIIIllIIlllII.getPaletteEntry(llllllllllllIllllllIIIIllIlIIIIl);
                                    final int llllllllllllIllllllIIIIllIlIIIlI = llllllllllllIlllllllIlIlIlIlIlIl.getMappingData().getNewBlockStateId(llllllllllllIllllllIIIIllIlIIIll);
                                    if (!llllllllllllIllllllIIIIllIIllIll && llllllllllllIllllllIIIIllIlIIIlI != WorldPackets.air && llllllllllllIllllllIIIIllIlIIIlI != WorldPackets.voidAir && llllllllllllIllllllIIIIllIlIIIlI != WorldPackets.caveAir) {
                                        llllllllllllIllllllIIIIllIIllIll = true;
                                    }
                                    llllllllllllIllllllIIIIllIIlllII.setPaletteEntry(llllllllllllIllllllIIIIllIlIIIIl, llllllllllllIllllllIIIIllIlIIIlI);
                                }
                                if (!llllllllllllIllllllIIIIllIIllIll) {
                                    llllllllllllIllllllIIIIllIIlllII.setNonAirBlocksCount(0);
                                }
                                else {
                                    int llllllllllllIllllllIIIIllIIllIlI = 0;
                                    for (int llllllllllllIllllllIIIIllIIlllIl = 0; llllllllllllIllllllIIIIllIIlllIl < 16; ++llllllllllllIllllllIIIIllIIlllIl) {
                                        for (int llllllllllllIllllllIIIIllIIllllI = 0; llllllllllllIllllllIIIIllIIllllI < 16; ++llllllllllllIllllllIIIIllIIllllI) {
                                            for (int llllllllllllIllllllIIIIllIIlllll = 0; llllllllllllIllllllIIIIllIIlllll < 16; ++llllllllllllIllllllIIIIllIIlllll) {
                                                final int llllllllllllIllllllIIIIllIlIIIII = llllllllllllIllllllIIIIllIIlllII.getFlatBlock(llllllllllllIllllllIIIIllIIlllIl, llllllllllllIllllllIIIIllIIllllI, llllllllllllIllllllIIIIllIIlllll);
                                                if (llllllllllllIllllllIIIIllIlIIIII != WorldPackets.air && llllllllllllIllllllIIIIllIlIIIII != WorldPackets.voidAir && llllllllllllIllllllIIIIllIlIIIII != WorldPackets.caveAir) {
                                                    ++llllllllllllIllllllIIIIllIIllIlI;
                                                    llllllllllllIllllllIIIIllIIIllIl[llllllllllllIllllllIIIIllIIlllIl + llllllllllllIllllllIIIIllIIlllll * 16] = llllllllllllIllllllIIIIllIIllllI + llllllllllllIllllllIIIIllIIllIIl * 16 + 1;
                                                }
                                                if (llllllllllllIlllllllIlIlIlIlIlIl.getMappingData().getMotionBlocking().contains(llllllllllllIllllllIIIIllIlIIIII)) {
                                                    llllllllllllIllllllIIIIllIIIlllI[llllllllllllIllllllIIIIllIIlllIl + llllllllllllIllllllIIIIllIIlllll * 16] = llllllllllllIllllllIIIIllIIllllI + llllllllllllIllllllIIIIllIIllIIl * 16 + 1;
                                                }
                                                if (Via.getConfig().isNonFullBlockLightFix() && llllllllllllIlllllllIlIlIlIlIlIl.getMappingData().getNonFullBlocks().contains(llllllllllllIllllllIIIIllIlIIIII)) {
                                                    setNonFullLight(llllllllllllIllllllIIIIllIIIllll, llllllllllllIllllllIIIIllIIlllII, llllllllllllIllllllIIIIllIIllIIl, llllllllllllIllllllIIIIllIIlllIl, llllllllllllIllllllIIIIllIIllllI, llllllllllllIllllllIIIIllIIlllll);
                                                }
                                            }
                                        }
                                    }
                                    llllllllllllIllllllIIIIllIIlllII.setNonAirBlocksCount(llllllllllllIllllllIIIIllIIllIlI);
                                }
                            }
                        }
                        final CompoundTag llllllllllllIllllllIIIIllIIIllII = new CompoundTag();
                        llllllllllllIllllllIIIIllIIIllII.put("MOTION_BLOCKING", new LongArrayTag(encodeHeightMap(llllllllllllIllllllIIIIllIIIlllI)));
                        llllllllllllIllllllIIIIllIIIllII.put("WORLD_SURFACE", new LongArrayTag(encodeHeightMap(llllllllllllIllllllIIIIllIIIllIl)));
                        llllllllllllIllllllIIIIllIIIllll.setHeightMap(llllllllllllIllllllIIIIllIIIllII);
                        final PacketWrapper llllllllllllIllllllIIIIllIIIlIll = llllllllllllIllllllIIIIllIIIIlII.create(ClientboundPackets1_14.UPDATE_LIGHT);
                        llllllllllllIllllllIIIIllIIIlIll.write(Type.VAR_INT, llllllllllllIllllllIIIIllIIIllll.getX());
                        llllllllllllIllllllIIIIllIIIlIll.write(Type.VAR_INT, llllllllllllIllllllIIIIllIIIllll.getZ());
                        int llllllllllllIllllllIIIIllIIIlIlI = llllllllllllIllllllIIIIllIIIllll.isFullChunk() ? 262143 : 0;
                        int llllllllllllIllllllIIIIllIIIlIIl = 0;
                        for (int llllllllllllIllllllIIIIllIIlIlll = 0; llllllllllllIllllllIIIIllIIlIlll < llllllllllllIllllllIIIIllIIIllll.getSections().length; ++llllllllllllIllllllIIIIllIIlIlll) {
                            final ChunkSection llllllllllllIllllllIIIIllIIllIII = llllllllllllIllllllIIIIllIIIllll.getSections()[llllllllllllIllllllIIIIllIIlIlll];
                            if (llllllllllllIllllllIIIIllIIllIII != null) {
                                if (!llllllllllllIllllllIIIIllIIIllll.isFullChunk() && llllllllllllIllllllIIIIllIIllIII.getLight().hasSkyLight()) {
                                    llllllllllllIllllllIIIIllIIIlIlI |= 1 << llllllllllllIllllllIIIIllIIlIlll + 1;
                                }
                                llllllllllllIllllllIIIIllIIIlIIl |= 1 << llllllllllllIllllllIIIIllIIlIlll + 1;
                            }
                        }
                        llllllllllllIllllllIIIIllIIIlIll.write(Type.VAR_INT, llllllllllllIllllllIIIIllIIIlIlI);
                        llllllllllllIllllllIIIIllIIIlIll.write(Type.VAR_INT, llllllllllllIllllllIIIIllIIIlIIl);
                        llllllllllllIllllllIIIIllIIIlIll.write(Type.VAR_INT, 0);
                        llllllllllllIllllllIIIIllIIIlIll.write(Type.VAR_INT, 0);
                        if (llllllllllllIllllllIIIIllIIIllll.isFullChunk()) {
                            llllllllllllIllllllIIIIllIIIlIll.write(Type.BYTE_ARRAY_PRIMITIVE, WorldPackets.FULL_LIGHT);
                        }
                        float llllllllllllIllllllIIIIlIllllIll = (Object)llllllllllllIllllllIIIIllIIIllll.getSections();
                        final int length = llllllllllllIllllllIIIIlIllllIll.length;
                        for (long llllllllllllIllllllIIIIlIllllIIl = 0; llllllllllllIllllllIIIIlIllllIIl < length; ++llllllllllllIllllllIIIIlIllllIIl) {
                            final ChunkSection llllllllllllIllllllIIIIllIIlIllI = llllllllllllIllllllIIIIlIllllIll[llllllllllllIllllllIIIIlIllllIIl];
                            if (llllllllllllIllllllIIIIllIIlIllI == null || !llllllllllllIllllllIIIIllIIlIllI.getLight().hasSkyLight()) {
                                if (llllllllllllIllllllIIIIllIIIllll.isFullChunk()) {
                                    llllllllllllIllllllIIIIllIIIlIll.write(Type.BYTE_ARRAY_PRIMITIVE, WorldPackets.FULL_LIGHT);
                                }
                            }
                            else {
                                llllllllllllIllllllIIIIllIIIlIll.write(Type.BYTE_ARRAY_PRIMITIVE, llllllllllllIllllllIIIIllIIlIllI.getLight().getSkyLight());
                            }
                        }
                        if (llllllllllllIllllllIIIIllIIIllll.isFullChunk()) {
                            llllllllllllIllllllIIIIllIIIlIll.write(Type.BYTE_ARRAY_PRIMITIVE, WorldPackets.FULL_LIGHT);
                        }
                        llllllllllllIllllllIIIIlIllllIll = (float)(Object)llllllllllllIllllllIIIIllIIIllll.getSections();
                        final int length2 = llllllllllllIllllllIIIIlIllllIll.length;
                        for (long llllllllllllIllllllIIIIlIllllIIl = 0; llllllllllllIllllllIIIIlIllllIIl < length2; ++llllllllllllIllllllIIIIlIllllIIl) {
                            final ChunkSection llllllllllllIllllllIIIIllIIlIlIl = llllllllllllIllllllIIIIlIllllIll[llllllllllllIllllllIIIIlIllllIIl];
                            if (llllllllllllIllllllIIIIllIIlIlIl != null) {
                                llllllllllllIllllllIIIIllIIIlIll.write(Type.BYTE_ARRAY_PRIMITIVE, llllllllllllIllllllIIIIllIIlIlIl.getLight().getBlockLight());
                            }
                        }
                        final EntityTracker1_14 llllllllllllIllllllIIIIllIIIlIII = llllllllllllIllllllIIIIllIIIIlII.user().getEntityTracker(Protocol1_14To1_13_2.class);
                        final int llllllllllllIllllllIIIIllIIIIlll = Math.abs(llllllllllllIllllllIIIIllIIIlIII.getChunkCenterX() - llllllllllllIllllllIIIIllIIIllll.getX());
                        final int llllllllllllIllllllIIIIllIIIIllI = Math.abs(llllllllllllIllllllIIIIllIIIlIII.getChunkCenterZ() - llllllllllllIllllllIIIIllIIIllll.getZ());
                        if (llllllllllllIllllllIIIIllIIIlIII.isForceSendCenterChunk() || llllllllllllIllllllIIIIllIIIIlll >= 64 || llllllllllllIllllllIIIIllIIIIllI >= 64) {
                            final PacketWrapper llllllllllllIllllllIIIIllIIlIlII = llllllllllllIllllllIIIIllIIIIlII.create(ClientboundPackets1_14.UPDATE_VIEW_POSITION);
                            llllllllllllIllllllIIIIllIIlIlII.write(Type.VAR_INT, llllllllllllIllllllIIIIllIIIllll.getX());
                            llllllllllllIllllllIIIIllIIlIlII.write(Type.VAR_INT, llllllllllllIllllllIIIIllIIIllll.getZ());
                            llllllllllllIllllllIIIIllIIlIlII.send(Protocol1_14To1_13_2.class);
                            llllllllllllIllllllIIIIllIIIlIII.setChunkCenterX(llllllllllllIllllllIIIIllIIIllll.getX());
                            llllllllllllIllllllIIIIllIIIlIII.setChunkCenterZ(llllllllllllIllllllIIIIllIIIllll.getZ());
                        }
                        llllllllllllIllllllIIIIllIIIlIll.send(Protocol1_14To1_13_2.class);
                        final ChunkSection[] sections = llllllllllllIllllllIIIIllIIIllll.getSections();
                        for (boolean llllllllllllIllllllIIIIlIlllIlll = sections.length != 0, llllllllllllIllllllIIIIlIlllIllI = false; llllllllllllIllllllIIIIlIlllIllI < llllllllllllIllllllIIIIlIlllIlll; ++llllllllllllIllllllIIIIlIlllIllI) {
                            final ChunkSection llllllllllllIllllllIIIIllIIlIIll = sections[llllllllllllIllllllIIIIlIlllIllI];
                            if (llllllllllllIllllllIIIIllIIlIIll != null) {
                                llllllllllllIllllllIIIIllIIlIIll.setLight(null);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.POSITION, Type.POSITION1_14);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIlIIIlIllIIIll) throws Exception {
                        final int lllllllllllllIIIIlIlIIIlIllIIIlI = lllllllllllllIIIIlIlIIIlIllIIIll.get((Type<Integer>)Type.INT, 0);
                        final int lllllllllllllIIIIlIlIIIlIllIIIIl = lllllllllllllIIIIlIlIIIlIllIIIll.get((Type<Integer>)Type.INT, 1);
                        if (lllllllllllllIIIIlIlIIIlIllIIIlI == 1010) {
                            lllllllllllllIIIIlIlIIIlIllIIIll.set(Type.INT, 1, llllllllllllIlllllllIlIlIlIlIlIl.getMappingData().getNewItemId(lllllllllllllIIIIlIlIIIlIllIIIIl));
                        }
                        else if (lllllllllllllIIIIlIlIIIlIllIIIlI == 2001) {
                            lllllllllllllIIIIlIlIIIlIllIIIll.set(Type.INT, 1, llllllllllllIlllllllIlIlIlIlIlIl.getMappingData().getNewBlockStateId(lllllllllllllIIIIlIlIIIlIllIIIIl));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIlIIlIIIIlIIllll) throws Exception {
                        final ClientWorld lllllllllllllIIlIlIIlIIIIlIIlllI = lllllllllllllIIlIlIIlIIIIlIIllll.user().get(ClientWorld.class);
                        final int lllllllllllllIIlIlIIlIIIIlIIllIl = lllllllllllllIIlIlIIlIIIIlIIllll.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIIlIlIIlIIIIlIIlllI.setEnvironment(lllllllllllllIIlIlIIlIIIIlIIllIl);
                        final int lllllllllllllIIlIlIIlIIIIlIIllII = lllllllllllllIIlIlIIlIIIIlIIllll.get((Type<Integer>)Type.INT, 0);
                        final Entity1_14Types lllllllllllllIIlIlIIlIIIIlIIlIll = Entity1_14Types.PLAYER;
                        final EntityTracker1_14 lllllllllllllIIlIlIIlIIIIlIIlIlI = lllllllllllllIIlIlIIlIIIIlIIllll.user().getEntityTracker(Protocol1_14To1_13_2.class);
                        lllllllllllllIIlIlIIlIIIIlIIlIlI.addEntity(lllllllllllllIIlIlIIlIIIIlIIllII, lllllllllllllIIlIlIIlIIIIlIIlIll);
                        lllllllllllllIIlIlIIlIIIIlIIlIlI.setClientEntityId(lllllllllllllIIlIlIIlIIIIlIIllII);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIlIlllllIIlIlIll) throws Exception {
                        final short llllllllllllllllIlIlllllIIlIlllI = llllllllllllllllIlIlllllIIlIlIll.read((Type<Short>)Type.UNSIGNED_BYTE);
                        final PacketWrapper llllllllllllllllIlIlllllIIlIllIl = llllllllllllllllIlIlllllIIlIlIll.create(ClientboundPackets1_14.SERVER_DIFFICULTY);
                        llllllllllllllllIlIlllllIIlIllIl.write(Type.UNSIGNED_BYTE, llllllllllllllllIlIlllllIIlIlllI);
                        llllllllllllllllIlIlllllIIlIllIl.write(Type.BOOLEAN, false);
                        llllllllllllllllIlIlllllIIlIllIl.scheduleSend(llllllllllllIlllllllIlIlIlIlIlIl.getClass());
                        llllllllllllllllIlIlllllIIlIlIll.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                        llllllllllllllllIlIlllllIIlIlIll.passthrough(Type.STRING);
                        llllllllllllllllIlIlllllIIlIlIll.write(Type.VAR_INT, 64);
                    }
                });
                this.handler(lllllllllllllIIIIlIIlllIIIIllllI -> {
                    lllllllllllllIIIIlIIlllIIIIllllI.send(Protocol1_14To1_13_2.class);
                    lllllllllllllIIIIlIIlllIIIIllllI.cancel();
                    sendViewDistancePacket(lllllllllllllIIIIlIIlllIIIIllllI.user());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIlIIIIIllllIlIlI) throws Exception {
                        llllllllllllllIIIlIIIIIllllIlIlI.write(Type.BOOLEAN, false);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIllIIIllIlIlIllII) throws Exception {
                        final ClientWorld llllllllllllllIIllIIIllIlIlIlIll = llllllllllllllIIllIIIllIlIlIllII.user().get(ClientWorld.class);
                        final int llllllllllllllIIllIIIllIlIlIlIlI = llllllllllllllIIllIIIllIlIlIllII.get((Type<Integer>)Type.INT, 0);
                        llllllllllllllIIllIIIllIlIlIlIll.setEnvironment(llllllllllllllIIllIIIllIlIlIlIlI);
                        final EntityTracker1_14 llllllllllllllIIllIIIllIlIlIlIIl = llllllllllllllIIllIIIllIlIlIllII.user().getEntityTracker(Protocol1_14To1_13_2.class);
                        llllllllllllllIIllIIIllIlIlIlIIl.setForceSendCenterChunk(true);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllllIlIIlIIIIIllI) throws Exception {
                        final short llllllllllllllIllllIlIIlIIIIlIIl = llllllllllllllIllllIlIIlIIIIIllI.read((Type<Short>)Type.UNSIGNED_BYTE);
                        final PacketWrapper llllllllllllllIllllIlIIlIIIIlIII = llllllllllllllIllllIlIIlIIIIIllI.create(ClientboundPackets1_14.SERVER_DIFFICULTY);
                        llllllllllllllIllllIlIIlIIIIlIII.write(Type.UNSIGNED_BYTE, llllllllllllllIllllIlIIlIIIIlIIl);
                        llllllllllllllIllllIlIIlIIIIlIII.write(Type.BOOLEAN, false);
                        llllllllllllllIllllIlIIlIIIIlIII.scheduleSend(llllllllllllIlllllllIlIlIlIlIlIl.getClass());
                    }
                });
                this.handler(llllllllllllllIIIIlIIIlIlIIlIIlI -> {
                    llllllllllllllIIIIlIIIlIlIIlIIlI.send(Protocol1_14To1_13_2.class);
                    llllllllllllllIIIIlIIIlIlIIlIIlI.cancel();
                    sendViewDistancePacket(llllllllllllllIIIIlIIIlIlIIlIIlI.user());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllIlllllllIlIlIlIlIlIl).registerClientbound(ClientboundPackets1_13.SPAWN_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION, Type.POSITION1_14);
            }
        });
    }
    
    private static void setNonFullLight(final Chunk llllllllllllIlllllllIlIlIIlIllII, final ChunkSection llllllllllllIlllllllIlIlIIlIlIll, final int llllllllllllIlllllllIlIlIIlIIIlI, final int llllllllllllIlllllllIlIlIIlIIIIl, final int llllllllllllIlllllllIlIlIIlIIIII, final int llllllllllllIlllllllIlIlIIlIIlll) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore          llllllllllllIlllllllIlIlIIlIIllI
        //     3: iconst_0       
        //     4: istore          llllllllllllIlllllllIlIlIIlIIlIl
        //     6: invokestatic    com/viaversion/viaversion/api/minecraft/BlockFace.values:()[Lcom/viaversion/viaversion/api/minecraft/BlockFace;
        //     9: astore          llllllllllllIlllllllIlIlIIIlllII
        //    11: aload           llllllllllllIlllllllIlIlIIIlllII
        //    13: arraylength    
        //    14: istore          llllllllllllIlllllllIlIlIIIllIll
        //    16: iconst_0       
        //    17: istore          llllllllllllIlllllllIlIlIIIllIlI
        //    19: iload           llllllllllllIlllllllIlIlIIIllIlI
        //    21: iload           llllllllllllIlllllllIlIlIIIllIll
        //    23: if_icmpge       369
        //    26: aload           llllllllllllIlllllllIlIlIIIlllII
        //    28: iload           llllllllllllIlllllllIlIlIIIllIlI
        //    30: aaload         
        //    31: astore          llllllllllllIlllllllIlIlIIlIlllI
        //    33: aload_1         /* llllllllllllIlllllllIlIlIIlIIIll */
        //    34: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSection.getLight:()Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight;
        //    39: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight.getSkyLightNibbleArray:()Lcom/viaversion/viaversion/api/minecraft/chunks/NibbleArray;
        //    44: astore          llllllllllllIlllllllIlIlIIllIIll
        //    46: aload_1         /* llllllllllllIlllllllIlIlIIlIIIll */
        //    47: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSection.getLight:()Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight;
        //    52: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight.getBlockLightNibbleArray:()Lcom/viaversion/viaversion/api/minecraft/chunks/NibbleArray;
        //    57: astore          llllllllllllIlllllllIlIlIIllIIlI
        //    59: iload_3         /* llllllllllllIlllllllIlIlIIlIlIIl */
        //    60: aload           llllllllllllIlllllllIlIlIIlIlllI
        //    62: invokevirtual   com/viaversion/viaversion/api/minecraft/BlockFace.getModX:()B
        //    65: iadd           
        //    66: istore          llllllllllllIlllllllIlIlIIllIIIl
        //    68: iload           llllllllllllIlllllllIlIlIIlIlIII
        //    70: aload           llllllllllllIlllllllIlIlIIlIlllI
        //    72: invokevirtual   com/viaversion/viaversion/api/minecraft/BlockFace.getModY:()B
        //    75: iadd           
        //    76: istore          llllllllllllIlllllllIlIlIIllIIII
        //    78: iload           llllllllllllIlllllllIlIlIIIlllll
        //    80: aload           llllllllllllIlllllllIlIlIIlIlllI
        //    82: invokevirtual   com/viaversion/viaversion/api/minecraft/BlockFace.getModZ:()B
        //    85: iadd           
        //    86: istore          llllllllllllIlllllllIlIlIIlIllll
        //    88: aload           llllllllllllIlllllllIlIlIIlIlllI
        //    90: invokevirtual   com/viaversion/viaversion/api/minecraft/BlockFace.getModX:()B
        //    93: ifeq            112
        //    96: iload           llllllllllllIlllllllIlIlIIllIIIl
        //    98: bipush          16
        //   100: if_icmpeq       363
        //   103: iload           llllllllllllIlllllllIlIlIIllIIIl
        //   105: iconst_m1      
        //   106: if_icmpne       243
        //   109: goto            363
        //   112: aload           llllllllllllIlllllllIlIlIIlIlllI
        //   114: invokevirtual   com/viaversion/viaversion/api/minecraft/BlockFace.getModY:()B
        //   117: ifeq            219
        //   120: iload           llllllllllllIlllllllIlIlIIllIIII
        //   122: bipush          16
        //   124: if_icmpeq       133
        //   127: iload           llllllllllllIlllllllIlIlIIllIIII
        //   129: iconst_m1      
        //   130: if_icmpne       243
        //   133: iload           llllllllllllIlllllllIlIlIIllIIII
        //   135: bipush          16
        //   137: if_icmpne       149
        //   140: iinc            llllllllllllIlllllllIlIlIIlIlIlI, 1
        //   143: iconst_0       
        //   144: istore          llllllllllllIlllllllIlIlIIllIIII
        //   146: goto            156
        //   149: iinc            llllllllllllIlllllllIlIlIIlIlIlI, -1
        //   152: bipush          15
        //   154: istore          llllllllllllIlllllllIlIlIIllIIII
        //   156: iload_2         /* llllllllllllIlllllllIlIlIIlIlIlI */
        //   157: bipush          16
        //   159: if_icmpeq       363
        //   162: iload_2         /* llllllllllllIlllllllIlIlIIlIlIlI */
        //   163: iconst_m1      
        //   164: if_icmpne       170
        //   167: goto            363
        //   170: aload_0         /* llllllllllllIlllllllIlIlIIlIIlII */
        //   171: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/Chunk.getSections:()[Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSection;
        //   176: iload_2         /* llllllllllllIlllllllIlIlIIlIlIlI */
        //   177: aaload         
        //   178: astore          llllllllllllIlllllllIlIlIIllIllI
        //   180: aload           llllllllllllIlllllllIlIlIIllIllI
        //   182: ifnonnull       188
        //   185: goto            363
        //   188: aload           llllllllllllIlllllllIlIlIIllIllI
        //   190: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSection.getLight:()Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight;
        //   195: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight.getSkyLightNibbleArray:()Lcom/viaversion/viaversion/api/minecraft/chunks/NibbleArray;
        //   200: astore          llllllllllllIlllllllIlIlIIllIIll
        //   202: aload           llllllllllllIlllllllIlIlIIllIllI
        //   204: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSection.getLight:()Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight;
        //   209: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight.getBlockLightNibbleArray:()Lcom/viaversion/viaversion/api/minecraft/chunks/NibbleArray;
        //   214: astore          llllllllllllIlllllllIlIlIIllIIlI
        //   216: goto            243
        //   219: aload           llllllllllllIlllllllIlIlIIlIlllI
        //   221: invokevirtual   com/viaversion/viaversion/api/minecraft/BlockFace.getModZ:()B
        //   224: ifeq            243
        //   227: iload           llllllllllllIlllllllIlIlIIlIllll
        //   229: bipush          16
        //   231: if_icmpeq       363
        //   234: iload           llllllllllllIlllllllIlIlIIlIllll
        //   236: iconst_m1      
        //   237: if_icmpne       243
        //   240: goto            363
        //   243: aload           llllllllllllIlllllllIlIlIIllIIlI
        //   245: ifnull          295
        //   248: iload           llllllllllllIlllllllIlIlIIlIIlIl
        //   250: bipush          15
        //   252: if_icmpeq       295
        //   255: aload           llllllllllllIlllllllIlIlIIllIIlI
        //   257: iload           llllllllllllIlllllllIlIlIIllIIIl
        //   259: iload           llllllllllllIlllllllIlIlIIllIIII
        //   261: iload           llllllllllllIlllllllIlIlIIlIllll
        //   263: invokevirtual   com/viaversion/viaversion/api/minecraft/chunks/NibbleArray.get:(III)B
        //   266: istore          llllllllllllIlllllllIlIlIIllIlIl
        //   268: iload           llllllllllllIlllllllIlIlIIllIlIl
        //   270: bipush          15
        //   272: if_icmpne       282
        //   275: bipush          14
        //   277: istore          llllllllllllIlllllllIlIlIIlIIlIl
        //   279: goto            295
        //   282: iload           llllllllllllIlllllllIlIlIIllIlIl
        //   284: iload           llllllllllllIlllllllIlIlIIlIIlIl
        //   286: if_icmple       295
        //   289: iload           llllllllllllIlllllllIlIlIIllIlIl
        //   291: iconst_1       
        //   292: isub           
        //   293: istore          llllllllllllIlllllllIlIlIIlIIlIl
        //   295: aload           llllllllllllIlllllllIlIlIIllIIll
        //   297: ifnull          363
        //   300: iload           llllllllllllIlllllllIlIlIIlIIllI
        //   302: bipush          15
        //   304: if_icmpeq       363
        //   307: aload           llllllllllllIlllllllIlIlIIllIIll
        //   309: iload           llllllllllllIlllllllIlIlIIllIIIl
        //   311: iload           llllllllllllIlllllllIlIlIIllIIII
        //   313: iload           llllllllllllIlllllllIlIlIIlIllll
        //   315: invokevirtual   com/viaversion/viaversion/api/minecraft/chunks/NibbleArray.get:(III)B
        //   318: istore          llllllllllllIlllllllIlIlIIllIlII
        //   320: iload           llllllllllllIlllllllIlIlIIllIlII
        //   322: bipush          15
        //   324: if_icmpne       350
        //   327: aload           llllllllllllIlllllllIlIlIIlIlllI
        //   329: invokevirtual   com/viaversion/viaversion/api/minecraft/BlockFace.getModY:()B
        //   332: iconst_1       
        //   333: if_icmpne       343
        //   336: bipush          15
        //   338: istore          llllllllllllIlllllllIlIlIIlIIllI
        //   340: goto            363
        //   343: bipush          14
        //   345: istore          llllllllllllIlllllllIlIlIIlIIllI
        //   347: goto            363
        //   350: iload           llllllllllllIlllllllIlIlIIllIlII
        //   352: iload           llllllllllllIlllllllIlIlIIlIIllI
        //   354: if_icmple       363
        //   357: iload           llllllllllllIlllllllIlIlIIllIlII
        //   359: iconst_1       
        //   360: isub           
        //   361: istore          llllllllllllIlllllllIlIlIIlIIllI
        //   363: iinc            llllllllllllIlllllllIlIlIIIllIlI, 1
        //   366: goto            19
        //   369: iload           llllllllllllIlllllllIlIlIIlIIllI
        //   371: ifeq            429
        //   374: aload_1         /* llllllllllllIlllllllIlIlIIlIIIll */
        //   375: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSection.getLight:()Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight;
        //   380: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight.hasSkyLight:()Z
        //   385: ifne            408
        //   388: sipush          2028
        //   391: newarray        B
        //   393: astore          llllllllllllIlllllllIlIlIIlIllIl
        //   395: aload_1         /* llllllllllllIlllllllIlIlIIlIIIll */
        //   396: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSection.getLight:()Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight;
        //   401: aload           llllllllllllIlllllllIlIlIIlIllIl
        //   403: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight.setSkyLight:([B)V
        //   408: aload_1         /* llllllllllllIlllllllIlIlIIlIIIll */
        //   409: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSection.getLight:()Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight;
        //   414: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight.getSkyLightNibbleArray:()Lcom/viaversion/viaversion/api/minecraft/chunks/NibbleArray;
        //   419: iload_3         /* llllllllllllIlllllllIlIlIIlIlIIl */
        //   420: iload           llllllllllllIlllllllIlIlIIlIlIII
        //   422: iload           llllllllllllIlllllllIlIlIIIlllll
        //   424: iload           llllllllllllIlllllllIlIlIIlIIllI
        //   426: invokevirtual   com/viaversion/viaversion/api/minecraft/chunks/NibbleArray.set:(IIII)V
        //   429: iload           llllllllllllIlllllllIlIlIIlIIlIl
        //   431: ifeq            455
        //   434: aload_1         /* llllllllllllIlllllllIlIlIIlIIIll */
        //   435: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSection.getLight:()Lcom/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight;
        //   440: invokeinterface com/viaversion/viaversion/api/minecraft/chunks/ChunkSectionLight.getBlockLightNibbleArray:()Lcom/viaversion/viaversion/api/minecraft/chunks/NibbleArray;
        //   445: iload_3         /* llllllllllllIlllllllIlIlIIlIlIIl */
        //   446: iload           llllllllllllIlllllllIlIlIIlIlIII
        //   448: iload           llllllllllllIlllllllIlIlIIIlllll
        //   450: iload           llllllllllllIlllllllIlIlIIlIIlIl
        //   452: invokevirtual   com/viaversion/viaversion/api/minecraft/chunks/NibbleArray.set:(IIII)V
        //   455: return         
        //    StackMapTable: 00 12 FF 00 13 00 0B 07 00 E8 07 00 CF 01 01 01 01 01 01 07 01 29 01 01 00 00 FF 00 5C 00 11 07 00 E8 07 00 CF 01 01 01 01 01 01 07 01 29 01 01 07 00 C9 07 00 EE 07 00 EE 01 01 01 00 00 14 0F 06 0D FC 00 11 07 00 CF FA 00 1E 17 FC 00 26 01 FA 00 0C FC 00 2F 01 06 FA 00 0C FF 00 05 00 0B 07 00 E8 07 00 CF 01 01 01 01 01 01 07 01 29 01 01 00 00 FF 00 26 00 0B 07 00 E8 07 00 CF 01 01 01 01 01 01 07 00 04 01 01 00 00 14 19
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static long getChunkIndex(final int llllllllllllIlllllllIlIlIIIlIIII, final int llllllllllllIlllllllIlIlIIIIllll) {
        return ((long)llllllllllllIlllllllIlIlIIIlIIII & 0x3FFFFFFL) << 38 | ((long)llllllllllllIlllllllIlIlIIIIllll & 0x3FFFFFFL);
    }
    
    private static long[] encodeHeightMap(final int[] llllllllllllIlllllllIlIlIlIIlIlI) {
        return CompactArrayUtil.createCompactArray(9, llllllllllllIlllllllIlIlIlIIlIlI.length, llllllllllllIlllllllIlIlIIIIlIIl -> llllllllllllIlllllllIlIlIlIIlIlI[llllllllllllIlllllllIlIlIIIIlIIl]);
    }
    
    static {
        SERVERSIDE_VIEW_DISTANCE = 64;
        Arrays.fill(FULL_LIGHT = new byte[2048], (byte)(-1));
    }
}
