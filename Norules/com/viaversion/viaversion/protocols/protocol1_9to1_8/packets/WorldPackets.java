package com.viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.sounds.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.type.types.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import java.util.*;
import com.viaversion.viaversion.api.type.*;

public class WorldPackets
{
    public static void register(final Protocol llllllllllllllIIIllllIIIIlIlIlll) {
        llllllllllllllIIIllllIIIIlIlIlll.registerClientbound(ClientboundPackets1_8.UPDATE_SIGN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerClientbound(ClientboundPackets1_8.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.POSITION);
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllllIIIlllIlllIII) throws Exception {
                        int llllllllllllllIllllIIIlllIlllIIl = llllllllllllllIllllIIIlllIlllIII.get((Type<Integer>)Type.INT, 0);
                        llllllllllllllIllllIIIlllIlllIIl = Effect.getNewId(llllllllllllllIllllIIIlllIlllIIl);
                        llllllllllllllIllllIIIlllIlllIII.set(Type.INT, 0, llllllllllllllIllllIIIlllIlllIIl);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlIIlIIlIlIllIIII) throws Exception {
                        final int lllllllllllllIlIlIIlIIlIlIlIllll = lllllllllllllIlIlIIlIIlIlIllIIII.get((Type<Integer>)Type.INT, 0);
                        if (lllllllllllllIlIlIIlIIlIlIlIllll == 2002) {
                            final int lllllllllllllIlIlIIlIIlIlIllIIll = lllllllllllllIlIlIIlIIlIlIllIIII.get((Type<Integer>)Type.INT, 1);
                            final int lllllllllllllIlIlIIlIIlIlIllIIlI = ItemRewriter.getNewEffectID(lllllllllllllIlIlIIlIIlIlIllIIll);
                            lllllllllllllIlIlIIlIIlIlIllIIII.set(Type.INT, 1, lllllllllllllIlIlIIlIIlIlIllIIlI);
                        }
                    }
                });
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerClientbound(ClientboundPackets1_8.NAMED_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIIlIllIIIIlllI) throws Exception {
                        final String llllllllllllllIllIIIlIllIIIIllIl = llllllllllllllIllIIIlIllIIIIlllI.get(Type.STRING, 0);
                        final SoundEffect llllllllllllllIllIIIlIllIIIIllII = SoundEffect.getByName(llllllllllllllIllIIIlIllIIIIllIl);
                        int llllllllllllllIllIIIlIllIIIIlIll = 0;
                        String llllllllllllllIllIIIlIllIIIIlIlI = llllllllllllllIllIIIlIllIIIIllIl;
                        if (llllllllllllllIllIIIlIllIIIIllII != null) {
                            llllllllllllllIllIIIlIllIIIIlIll = llllllllllllllIllIIIlIllIIIIllII.getCategory().getId();
                            llllllllllllllIllIIIlIllIIIIlIlI = llllllllllllllIllIIIlIllIIIIllII.getNewName();
                        }
                        llllllllllllllIllIIIlIllIIIIlllI.set(Type.STRING, 0, llllllllllllllIllIIIlIllIIIIlIlI);
                        llllllllllllllIllIIIlIllIIIIlllI.write(Type.VAR_INT, llllllllllllllIllIIIlIllIIIIlIll);
                        if (llllllllllllllIllIIIlIllIIIIllII != null && llllllllllllllIllIIIlIllIIIIllII.isBreaksound()) {
                            final EntityTracker1_9 llllllllllllllIllIIIlIllIIIlIIll = llllllllllllllIllIIIlIllIIIIlllI.user().getEntityTracker(Protocol1_9To1_8.class);
                            final int llllllllllllllIllIIIlIllIIIlIIlI = llllllllllllllIllIIIlIllIIIIlllI.passthrough((Type<Integer>)Type.INT);
                            final int llllllllllllllIllIIIlIllIIIlIIIl = llllllllllllllIllIIIlIllIIIIlllI.passthrough((Type<Integer>)Type.INT);
                            final int llllllllllllllIllIIIlIllIIIlIIII = llllllllllllllIllIIIlIllIIIIlllI.passthrough((Type<Integer>)Type.INT);
                            if (llllllllllllllIllIIIlIllIIIlIIll.interactedBlockRecently((int)Math.floor(llllllllllllllIllIIIlIllIIIlIIlI / 8.0), (int)Math.floor(llllllllllllllIllIIIlIllIIIlIIIl / 8.0), (int)Math.floor(llllllllllllllIllIIIlIllIIIlIIII / 8.0))) {
                                llllllllllllllIllIIIlIllIIIIlllI.cancel();
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerClientbound(ClientboundPackets1_8.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIllIllIIIIIlllII) throws Exception {
                        final ClientChunks llllllllllllllllIllIllIIIIIllIll = llllllllllllllllIllIllIIIIIlllII.user().get(ClientChunks.class);
                        final Chunk1_9to1_8Type llllllllllllllllIllIllIIIIIllIlI = new Chunk1_9to1_8Type(llllllllllllllllIllIllIIIIIllIll);
                        final Chunk1_8 llllllllllllllllIllIllIIIIIllIIl = llllllllllllllllIllIllIIIIIlllII.read((Type<Chunk1_8>)llllllllllllllllIllIllIIIIIllIlI);
                        if (llllllllllllllllIllIllIIIIIllIIl.isUnloadPacket()) {
                            llllllllllllllllIllIllIIIIIlllII.setPacketType(ClientboundPackets1_9.UNLOAD_CHUNK);
                            llllllllllllllllIllIllIIIIIlllII.write(Type.INT, llllllllllllllllIllIllIIIIIllIIl.getX());
                            llllllllllllllllIllIllIIIIIlllII.write(Type.INT, llllllllllllllllIllIllIIIIIllIIl.getZ());
                            final CommandBlockProvider llllllllllllllllIllIllIIIIIllllI = Via.getManager().getProviders().get(CommandBlockProvider.class);
                            llllllllllllllllIllIllIIIIIllllI.unloadChunk(llllllllllllllllIllIllIIIIIlllII.user(), llllllllllllllllIllIllIIIIIllIIl.getX(), llllllllllllllllIllIllIIIIIllIIl.getZ());
                        }
                        else {
                            llllllllllllllllIllIllIIIIIlllII.write((Type<Chunk1_8>)llllllllllllllllIllIllIIIIIllIlI, llllllllllllllllIllIllIIIIIllIIl);
                        }
                        llllllllllllllllIllIllIIIIIlllII.read(Type.REMAINING_BYTES);
                    }
                });
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerClientbound(ClientboundPackets1_8.MAP_BULK_CHUNK, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final boolean lllllllllllllllIIIIlllIllIIlIIll;
                final int lllllllllllllllIIIIlllIllIIlIIlI;
                final ChunkBulkSection[] lllllllllllllllIIIIlllIllIIlIIIl;
                int lllllllllllllllIIIIlllIllIIllIIl;
                final ClientChunks lllllllllllllllIIIIlllIllIIlIIII;
                final boolean lllllllllllllllIIIIlllIllIIIlIlI;
                String lllllllllllllllIIIIlllIllIIIlIIl;
                int lllllllllllllllIIIIlllIllIIIlIII;
                ChunkBulkSection lllllllllllllllIIIIlllIllIIlIlIl;
                CustomByteType lllllllllllllllIIIIlllIllIIlIlll;
                ByteBuf lllllllllllllllIIIIlllIllIIlIllI;
                PacketWrapper lllllllllllllllIIIIlllIllIIllIII;
                this.handler(lllllllllllllllIIIIlllIllIIIllll -> {
                    lllllllllllllllIIIIlllIllIIIllll.cancel();
                    lllllllllllllllIIIIlllIllIIlIIll = lllllllllllllllIIIIlllIllIIIllll.read((Type<Boolean>)Type.BOOLEAN);
                    lllllllllllllllIIIIlllIllIIlIIlI = lllllllllllllllIIIIlllIllIIIllll.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllllIIIIlllIllIIlIIIl = new ChunkBulkSection[lllllllllllllllIIIIlllIllIIlIIlI];
                    for (lllllllllllllllIIIIlllIllIIllIIl = 0; lllllllllllllllIIIIlllIllIIllIIl < lllllllllllllllIIIIlllIllIIlIIlI; ++lllllllllllllllIIIIlllIllIIllIIl) {
                        lllllllllllllllIIIIlllIllIIlIIIl[lllllllllllllllIIIIlllIllIIllIIl] = new ChunkBulkSection(lllllllllllllllIIIIlllIllIIIllll, lllllllllllllllIIIIlllIllIIlIIll);
                    }
                    lllllllllllllllIIIIlllIllIIlIIII = lllllllllllllllIIIIlllIllIIIllll.user().get(ClientChunks.class);
                    lllllllllllllllIIIIlllIllIIIlIlI = (boolean)(Object)lllllllllllllllIIIIlllIllIIlIIIl;
                    for (lllllllllllllllIIIIlllIllIIIlIIl = (String)lllllllllllllllIIIIlllIllIIIlIlI.length, lllllllllllllllIIIIlllIllIIIlIII = 0; lllllllllllllllIIIIlllIllIIIlIII < lllllllllllllllIIIIlllIllIIIlIIl; ++lllllllllllllllIIIIlllIllIIIlIII) {
                        lllllllllllllllIIIIlllIllIIlIlIl = lllllllllllllllIIIIlllIllIIIlIlI[lllllllllllllllIIIIlllIllIIIlIII];
                        lllllllllllllllIIIIlllIllIIlIlll = new CustomByteType(lllllllllllllllIIIIlllIllIIlIlIl.getLength());
                        lllllllllllllllIIIIlllIllIIlIlIl.setData(lllllllllllllllIIIIlllIllIIIllll.read((Type<byte[]>)lllllllllllllllIIIIlllIllIIlIlll));
                        lllllllllllllllIIIIlllIllIIlIIII.getBulkChunks().add(ClientChunks.toLong(lllllllllllllllIIIIlllIllIIlIlIl.getX(), lllllllllllllllIIIIlllIllIIlIlIl.getZ()));
                        lllllllllllllllIIIIlllIllIIlIllI = null;
                        try {
                            lllllllllllllllIIIIlllIllIIlIllI = lllllllllllllllIIIIlllIllIIIllll.user().getChannel().alloc().buffer();
                            Type.INT.write(lllllllllllllllIIIIlllIllIIlIllI, lllllllllllllllIIIIlllIllIIlIlIl.getX());
                            Type.INT.write(lllllllllllllllIIIIlllIllIIlIllI, lllllllllllllllIIIIlllIllIIlIlIl.getZ());
                            Type.BOOLEAN.write(lllllllllllllllIIIIlllIllIIlIllI, true);
                            Type.UNSIGNED_SHORT.write(lllllllllllllllIIIIlllIllIIlIllI, lllllllllllllllIIIIlllIllIIlIlIl.getBitMask());
                            Type.VAR_INT.writePrimitive(lllllllllllllllIIIIlllIllIIlIllI, lllllllllllllllIIIIlllIllIIlIlIl.getLength());
                            ((PartialType<byte[], X>)lllllllllllllllIIIIlllIllIIlIlll).write(lllllllllllllllIIIIlllIllIIlIllI, lllllllllllllllIIIIlllIllIIlIlIl.getData());
                            lllllllllllllllIIIIlllIllIIllIII = PacketWrapper.create(ClientboundPackets1_8.CHUNK_DATA, lllllllllllllllIIIIlllIllIIlIllI, lllllllllllllllIIIIlllIllIIIllll.user());
                            lllllllllllllllIIIIlllIllIIllIII.send(Protocol1_9To1_8.class, false);
                        }
                        finally {
                            if (lllllllllllllllIIIIlllIllIIlIllI != null) {
                                lllllllllllllllIIIIlllIllIIlIllI.release();
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerClientbound(ClientboundPackets1_8.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlIllIlIIIIIllllI) throws Exception {
                        final int lllllllllllllllIlIllIlIIIIIlllll = lllllllllllllllIlIllIlIIIIIllllI.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        if (lllllllllllllllIlIllIlIIIIIlllll == 1) {
                            final CompoundTag lllllllllllllllIlIllIlIIIIlIIIll = lllllllllllllllIlIllIlIIIIIllllI.get(Type.NBT, 0);
                            if (lllllllllllllllIlIllIlIIIIlIIIll != null) {
                                if (lllllllllllllllIlIllIlIIIIlIIIll.contains("EntityId")) {
                                    final String lllllllllllllllIlIllIlIIIIlIIllI = (String)lllllllllllllllIlIllIlIIIIlIIIll.get("EntityId").getValue();
                                    final CompoundTag lllllllllllllllIlIllIlIIIIlIIlIl = new CompoundTag();
                                    lllllllllllllllIlIllIlIIIIlIIlIl.put("id", new StringTag(lllllllllllllllIlIllIlIIIIlIIllI));
                                    lllllllllllllllIlIllIlIIIIlIIIll.put("SpawnData", lllllllllllllllIlIllIlIIIIlIIlIl);
                                }
                                else {
                                    final CompoundTag lllllllllllllllIlIllIlIIIIlIIlII = new CompoundTag();
                                    lllllllllllllllIlIllIlIIIIlIIlII.put("id", new StringTag("AreaEffectCloud"));
                                    lllllllllllllllIlIllIlIIIIlIIIll.put("SpawnData", lllllllllllllllIlIllIlIIIIlIIlII);
                                }
                            }
                        }
                        if (lllllllllllllllIlIllIlIIIIIlllll == 2) {
                            final CommandBlockProvider lllllllllllllllIlIllIlIIIIlIIIlI = Via.getManager().getProviders().get(CommandBlockProvider.class);
                            lllllllllllllllIlIllIlIIIIlIIIlI.addOrUpdateBlock(lllllllllllllllIlIllIlIIIIIllllI.user(), lllllllllllllllIlIllIlIIIIIllllI.get(Type.POSITION, 0), lllllllllllllllIlIllIlIIIIIllllI.get(Type.NBT, 0));
                            lllllllllllllllIlIllIlIIIIIllllI.cancel();
                        }
                    }
                });
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerClientbound(ClientboundPackets1_8.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.VAR_INT);
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerServerbound(ServerboundPackets1_9.UPDATE_SIGN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerServerbound(ServerboundPackets1_9.PLAYER_DIGGING, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT, Type.UNSIGNED_BYTE);
                this.map(Type.POSITION);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIIllIIIIlIllllII) throws Exception {
                        final int lllllllllllllIIlIIllIIIIlIllllIl = lllllllllllllIIlIIllIIIIlIllllII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        if (lllllllllllllIIlIIllIIIIlIllllIl == 6) {
                            lllllllllllllIIlIIllIIIIlIllllII.cancel();
                        }
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIIlIlllIllIlIlIl) throws Exception {
                        final int llllllllllllllIlIIlIlllIllIlIlII = llllllllllllllIlIIlIlllIllIlIlIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        if (llllllllllllllIlIIlIlllIllIlIlII == 5 || llllllllllllllIlIIlIlllIllIlIlII == 4 || llllllllllllllIlIIlIlllIllIlIlII == 3) {
                            final EntityTracker1_9 llllllllllllllIlIIlIlllIllIlIlll = llllllllllllllIlIIlIlllIllIlIlIl.user().getEntityTracker(Protocol1_9To1_8.class);
                            if (llllllllllllllIlIIlIlllIllIlIlll.isBlocking()) {
                                llllllllllllllIlIIlIlllIllIlIlll.setBlocking(false);
                                if (!Via.getConfig().isShowShieldWhenSwordInHand()) {
                                    llllllllllllllIlIIlIlllIllIlIlll.setSecondHand(null);
                                }
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerServerbound(ServerboundPackets1_9.USE_ITEM, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIllllllllllllllI) throws Exception {
                        final int llllllllllllllIllIIIIIIIIIIIIIII = llllllllllllllIlIllllllllllllllI.read((Type<Integer>)Type.VAR_INT);
                        llllllllllllllIlIllllllllllllllI.clearInputBuffer();
                        llllllllllllllIlIllllllllllllllI.setId(8);
                        llllllllllllllIlIllllllllllllllI.write(Type.POSITION, new Position(-1, (short)(-1), -1));
                        llllllllllllllIlIllllllllllllllI.write(Type.UNSIGNED_BYTE, (Short)255);
                        final Item llllllllllllllIlIlllllllllllllll = Protocol1_9To1_8.getHandItem(llllllllllllllIlIllllllllllllllI.user());
                        if (Via.getConfig().isShieldBlocking()) {
                            final EntityTracker1_9 llllllllllllllIllIIIIIIIIIIIlIIl = llllllllllllllIlIllllllllllllllI.user().getEntityTracker(Protocol1_9To1_8.class);
                            final boolean llllllllllllllIllIIIIIIIIIIIIlll = Via.getConfig().isShowShieldWhenSwordInHand();
                            final boolean llllllllllllllIllIIIIIIIIIIIIllI = llllllllllllllIllIIIIIIIIIIIIlll ? llllllllllllllIllIIIIIIIIIIIlIIl.hasSwordInHand() : (llllllllllllllIlIlllllllllllllll != null && Protocol1_9To1_8.isSword(llllllllllllllIlIlllllllllllllll.identifier()));
                            if (llllllllllllllIllIIIIIIIIIIIIllI) {
                                if (llllllllllllllIllIIIIIIIIIIIIIII == 0 && !llllllllllllllIllIIIIIIIIIIIlIIl.isBlocking()) {
                                    llllllllllllllIllIIIIIIIIIIIlIIl.setBlocking(true);
                                    if (!llllllllllllllIllIIIIIIIIIIIIlll && llllllllllllllIllIIIIIIIIIIIlIIl.getItemInSecondHand() == null) {
                                        final Item llllllllllllllIllIIIIIIIIIIIllII = new DataItem(442, (byte)1, (short)0, null);
                                        llllllllllllllIllIIIIIIIIIIIlIIl.setSecondHand(llllllllllllllIllIIIIIIIIIIIllII);
                                    }
                                }
                                final boolean llllllllllllllIllIIIIIIIIIIIlIll = Via.getConfig().isNoDelayShieldBlocking() && !llllllllllllllIllIIIIIIIIIIIIlll;
                                if ((llllllllllllllIllIIIIIIIIIIIlIll && llllllllllllllIllIIIIIIIIIIIIIII == 1) || (!llllllllllllllIllIIIIIIIIIIIlIll && llllllllllllllIllIIIIIIIIIIIIIII == 0)) {
                                    llllllllllllllIlIllllllllllllllI.cancel();
                                }
                            }
                            else {
                                if (!llllllllllllllIllIIIIIIIIIIIIlll) {
                                    llllllllllllllIllIIIIIIIIIIIlIIl.setSecondHand(null);
                                }
                                llllllllllllllIllIIIIIIIIIIIlIIl.setBlocking(false);
                            }
                        }
                        llllllllllllllIlIllllllllllllllI.write(Type.ITEM, llllllllllllllIlIlllllllllllllll);
                        llllllllllllllIlIllllllllllllllI.write(Type.UNSIGNED_BYTE, (Short)0);
                        llllllllllllllIlIllllllllllllllI.write(Type.UNSIGNED_BYTE, (Short)0);
                        llllllllllllllIlIllllllllllllllI.write(Type.UNSIGNED_BYTE, (Short)0);
                    }
                });
            }
        });
        llllllllllllllIIIllllIIIIlIlIlll.registerServerbound(ServerboundPackets1_9.PLAYER_BLOCK_PLACEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.VAR_INT, Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIlIIlIlIIlIIII) throws Exception {
                        final int llllllllllllllIllIIlIIlIlIIlIIIl = llllllllllllllIllIIlIIlIlIIlIIII.read((Type<Integer>)Type.VAR_INT);
                        if (llllllllllllllIllIIlIIlIlIIlIIIl != 0) {
                            llllllllllllllIllIIlIIlIlIIlIIII.cancel();
                        }
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIllIIIIIIIIIlIllI) throws Exception {
                        final Item lllllllllllllllIllIIIIIIIIIlIlIl = Protocol1_9To1_8.getHandItem(lllllllllllllllIllIIIIIIIIIlIllI.user());
                        lllllllllllllllIllIIIIIIIIIlIllI.write(Type.ITEM, lllllllllllllllIllIIIIIIIIIlIlIl);
                    }
                });
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIIIlIIIlIllIll) throws Exception {
                        final int lllllllllllllIIIIlIIIlIIIllIIIIl = lllllllllllllIIIIlIIIlIIIlIllIll.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        if (lllllllllllllIIIIlIIIlIIIllIIIIl == 255) {
                            return;
                        }
                        final Position lllllllllllllIIIIlIIIlIIIllIIIII = lllllllllllllIIIIlIIIlIIIlIllIll.get(Type.POSITION, 0);
                        int lllllllllllllIIIIlIIIlIIIlIlllll = lllllllllllllIIIIlIIIlIIIllIIIII.getX();
                        int lllllllllllllIIIIlIIIlIIIlIllllI = lllllllllllllIIIIlIIIlIIIllIIIII.getY();
                        int lllllllllllllIIIIlIIIlIIIlIlllIl = lllllllllllllIIIIlIIIlIIIllIIIII.getZ();
                        switch (lllllllllllllIIIIlIIIlIIIllIIIIl) {
                            case 0: {
                                --lllllllllllllIIIIlIIIlIIIlIllllI;
                                break;
                            }
                            case 1: {
                                ++lllllllllllllIIIIlIIIlIIIlIllllI;
                                break;
                            }
                            case 2: {
                                --lllllllllllllIIIIlIIIlIIIlIlllIl;
                                break;
                            }
                            case 3: {
                                ++lllllllllllllIIIIlIIIlIIIlIlllIl;
                                break;
                            }
                            case 4: {
                                --lllllllllllllIIIIlIIIlIIIlIlllll;
                                break;
                            }
                            case 5: {
                                ++lllllllllllllIIIIlIIIlIIIlIlllll;
                                break;
                            }
                        }
                        final EntityTracker1_9 lllllllllllllIIIIlIIIlIIIlIlllII = lllllllllllllIIIIlIIIlIIIlIllIll.user().getEntityTracker(Protocol1_9To1_8.class);
                        lllllllllllllIIIIlIIIlIIIlIlllII.addBlockInteraction(new Position(lllllllllllllIIIIlIIIlIIIlIlllll, lllllllllllllIIIIlIIIlIIIlIllllI, lllllllllllllIIIIlIIIlIIIlIlllIl));
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lIlIlIlllllIlI) throws Exception {
                        final CommandBlockProvider lIlIlIllllllIl = Via.getManager().getProviders().get(CommandBlockProvider.class);
                        final Position lIlIlIllllllII = lIlIlIlllllIlI.get(Type.POSITION, 0);
                        final Optional<CompoundTag> lIlIlIlllllIll = lIlIlIllllllIl.get(lIlIlIlllllIlI.user(), lIlIlIllllllII);
                        if (lIlIlIlllllIll.isPresent()) {
                            final PacketWrapper lIlIllIIIIIIII = PacketWrapper.create(ClientboundPackets1_9.BLOCK_ENTITY_DATA, null, lIlIlIlllllIlI.user());
                            lIlIllIIIIIIII.write(Type.POSITION, lIlIlIllllllII);
                            lIlIllIIIIIIII.write(Type.UNSIGNED_BYTE, (Short)2);
                            lIlIllIIIIIIII.write(Type.NBT, lIlIlIlllllIll.get());
                            lIlIllIIIIIIII.scheduleSend(Protocol1_9To1_8.class);
                        }
                    }
                });
            }
        });
    }
    
    public static final class ChunkBulkSection
    {
        private final /* synthetic */ int z;
        private final /* synthetic */ int x;
        private /* synthetic */ byte[] data;
        private final /* synthetic */ int length;
        private final /* synthetic */ int bitMask;
        
        public int getBitMask() {
            return this.bitMask;
        }
        
        public int getZ() {
            return this.z;
        }
        
        public int getX() {
            return this.x;
        }
        
        public ChunkBulkSection(final PacketWrapper lllllllllllllIlIlIIllIIllIlIIIll, final boolean lllllllllllllIlIlIIllIIllIlIIllI) throws Exception {
            this.x = lllllllllllllIlIlIIllIIllIlIIIll.read((Type<Integer>)Type.INT);
            this.z = lllllllllllllIlIlIIllIIllIlIIIll.read((Type<Integer>)Type.INT);
            this.bitMask = lllllllllllllIlIlIIllIIllIlIIIll.read((Type<Integer>)Type.UNSIGNED_SHORT);
            final int lllllllllllllIlIlIIllIIllIlIIlIl = Integer.bitCount(this.bitMask);
            this.length = lllllllllllllIlIlIIllIIllIlIIlIl * 10240 + (lllllllllllllIlIlIIllIIllIlIIllI ? (lllllllllllllIlIlIIllIIllIlIIlIl * 2048) : 0) + 256;
        }
        
        public int getLength() {
            return this.length;
        }
        
        public byte[] getData() {
            return this.data;
        }
        
        public void setData(final byte[] lllllllllllllIlIlIIllIIllIIIllII) {
            this.data = lllllllllllllIlIlIIllIIllIIIllII;
        }
    }
}
