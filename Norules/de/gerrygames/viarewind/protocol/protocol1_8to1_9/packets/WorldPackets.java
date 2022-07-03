package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.type.types.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.items.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.types.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.minecraft.*;
import io.netty.buffer.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.*;
import de.gerrygames.viarewind.utils.*;
import com.viaversion.viaversion.api.connection.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.sound.*;
import de.gerrygames.viarewind.*;

public class WorldPackets
{
    public static void register(final Protocol<ClientboundPackets1_9, ClientboundPackets1_8, ServerboundPackets1_9, ServerboundPackets1_8> lllllllllllllIlIIlIIIlIIIlIIllII) {
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT);
                final CompoundTag lllllllllllllIlllIIIIIlIIIllIIll;
                String lllllllllllllIlllIIIIIlIIIllIlIl;
                this.handler(lllllllllllllIlllIIIIIlIIIllIIlI -> {
                    lllllllllllllIlllIIIIIlIIIllIIll = lllllllllllllIlllIIIIIlIIIllIIlI.get(Type.NBT, 0);
                    if (lllllllllllllIlllIIIIIlIIIllIIll != null && lllllllllllllIlllIIIIIlIIIllIIll.contains("SpawnData")) {
                        lllllllllllllIlllIIIIIlIIIllIlIl = (String)lllllllllllllIlllIIIIIlIIIllIIll.get("SpawnData").get("id").getValue();
                        lllllllllllllIlllIIIIIlIIIllIIll.remove("SpawnData");
                        lllllllllllllIlllIIIIIlIIIllIIll.put("entityId", new StringTag(lllllllllllllIlllIIIIIlIIIllIlIl));
                    }
                });
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.BLOCK_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                final int lllllllllllllIlIIIlIlIlllllIIIII;
                VarIntType var_INT;
                int lllllllllllllIlIIIlIlIlllllIIIII2;
                final int n;
                final int n2;
                this.handler(lllllllllllllIlIIIlIlIllllIlllll -> {
                    lllllllllllllIlIIIlIlIlllllIIIII = lllllllllllllIlIIIlIlIllllIlllll.get((Type<Integer>)Type.VAR_INT, 0);
                    if (lllllllllllllIlIIIlIlIlllllIIIII >= 219 && lllllllllllllIlIIIlIlIlllllIIIII <= 234) {
                        var_INT = Type.VAR_INT;
                        lllllllllllllIlIIIlIlIlllllIIIII2 = 130;
                        lllllllllllllIlIIIlIlIllllIlllll.set(var_INT, n, n2);
                    }
                });
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.VAR_INT);
                final int llllllllllllllIIllIIIIIlIlIlIIlI;
                final int llllllllllllllIIllIIIIIlIlIlIIIl;
                this.handler(llllllllllllllIIllIIIIIlIlIlIIII -> {
                    llllllllllllllIIllIIIIIlIlIlIIlI = llllllllllllllIIllIIIIIlIlIlIIII.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIIllIIIIIlIlIlIIIl = ReplacementRegistry1_8to1_9.replace(llllllllllllllIIllIIIIIlIlIlIIlI);
                    llllllllllllllIIllIIIIIlIlIlIIII.set(Type.VAR_INT, 0, llllllllllllllIIllIIIIIlIlIlIIIl);
                });
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BLOCK_CHANGE_RECORD_ARRAY);
                final short lllllllllllllllIIIIllIIlIIlIlIll;
                String lllllllllllllllIIIIllIIlIIlIlIlI;
                long lllllllllllllllIIIIllIIlIIlIlIIl;
                BlockChangeRecord lllllllllllllllIIIIllIIlIIlIlllI;
                int lllllllllllllllIIIIllIIlIIlIllll;
                this.handler(lllllllllllllllIIIIllIIlIIlIllIl -> {
                    lllllllllllllllIIIIllIIlIIlIlIll = lllllllllllllllIIIIllIIlIIlIllIl.get((Type<Short>)Type.BLOCK_CHANGE_RECORD_ARRAY, 0);
                    for (lllllllllllllllIIIIllIIlIIlIlIlI = (String)lllllllllllllllIIIIllIIlIIlIlIll.length, lllllllllllllllIIIIllIIlIIlIlIIl = 0; lllllllllllllllIIIIllIIlIIlIlIIl < lllllllllllllllIIIIllIIlIIlIlIlI; ++lllllllllllllllIIIIllIIlIIlIlIIl) {
                        lllllllllllllllIIIIllIIlIIlIlllI = lllllllllllllllIIIIllIIlIIlIlIll[lllllllllllllllIIIIllIIlIIlIlIIl];
                        lllllllllllllllIIIIllIIlIIlIllll = ReplacementRegistry1_8to1_9.replace(lllllllllllllllIIIIllIIlIIlIlllI.getBlockId());
                        lllllllllllllllIIIIllIIlIIlIlllI.setBlockId(lllllllllllllllIIIIllIIlIIlIllll);
                    }
                });
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.NAMED_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String lllllllllllllIIIIlIIllllIIIIIIII;
                final String lllllllllllllIIIIlIIllllIIIIIIII2;
                this.handler(lllllllllllllIIIIlIIlllIllllllll -> {
                    lllllllllllllIIIIlIIllllIIIIIIII = lllllllllllllIIIIlIIlllIllllllll.get(Type.STRING, 0);
                    lllllllllllllIIIIlIIllllIIIIIIII2 = SoundRemapper.getOldName(lllllllllllllIIIIlIIllllIIIIIIII);
                    if (lllllllllllllIIIIlIIllllIIIIIIII2 == null) {
                        lllllllllllllIIIIlIIlllIllllllll.cancel();
                    }
                    else {
                        lllllllllllllIIIIlIIlllIllllllll.set(Type.STRING, 0, lllllllllllllIIIIlIIllllIIIIIIII2);
                    }
                    return;
                });
                this.map(Type.VAR_INT, Type.NOTHING);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.FLOAT);
                this.map(Type.UNSIGNED_BYTE);
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.EXPLOSION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                final int lIlllllIllll;
                int lIllllllIIIl;
                this.handler(lIlllllIlllI -> {
                    lIlllllIllll = lIlllllIlllI.read((Type<Integer>)Type.INT);
                    lIlllllIlllI.write(Type.INT, lIlllllIllll);
                    for (lIllllllIIIl = 0; lIllllllIIIl < lIlllllIllll; ++lIllllllIIIl) {
                        lIlllllIlllI.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                        lIlllllIlllI.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                        lIlllllIlllI.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                    }
                    return;
                });
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.UNLOAD_CHUNK, ClientboundPackets1_8.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllllllllIlIlllllllIIl;
                final int lllllllllllllllllllIlIlllllllIII;
                final ClientWorld lllllllllllllllllllIlIllllllIlll;
                this.handler(lllllllllllllllllllIlIlllllllIlI -> {
                    lllllllllllllllllllIlIlllllllIIl = lllllllllllllllllllIlIlllllllIlI.read((Type<Integer>)Type.INT);
                    lllllllllllllllllllIlIlllllllIII = lllllllllllllllllllIlIlllllllIlI.read((Type<Integer>)Type.INT);
                    lllllllllllllllllllIlIllllllIlll = lllllllllllllllllllIlIlllllllIlI.user().get(ClientWorld.class);
                    lllllllllllllllllllIlIlllllllIlI.write((Type<Chunk1_8>)new Chunk1_8Type(lllllllllllllllllllIlIllllllIlll), new Chunk1_8(lllllllllllllllllllIlIlllllllIIl, lllllllllllllllllllIlIlllllllIII));
                });
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final ClientWorld lllllllllllllllIlIllllIllIllllIl;
                Chunk lllllllllllllllIlIllllIllIllllII;
                final float lllllllllllllllIlIllllIllIllIlll;
                int lllllllllllllllIlIllllIllIllIllI;
                int i = 0;
                ChunkSection lllllllllllllllIlIllllIlllIIIIlI;
                int lllllllllllllllIlIllllIlllIIIIll;
                int lllllllllllllllIlIllllIlllIIIlIl;
                int lllllllllllllllIlIllllIlllIIIlII;
                boolean lllllllllllllllIlIllllIlllIIIIIl;
                ChunkSection[] lllllllllllllllIlIllllIlllIIIIII;
                ChunkSection lllllllllllllllIlIllllIllIllllll;
                final UserConnection lllllllllllllllIlIllllIllIlllIll;
                Position lllllllllllllllIlIllllIllIlIIIIl;
                String s;
                String lllllllllllllllIlIllllIllIlIIIII;
                byte lllllllllllllllIlIllllIllIIlIlll;
                short lllllllllllllllIlIllllIllIlIlIIl;
                short lllllllllllllllIlIllllIllIlIlIII;
                short lllllllllllllllIlIllllIllIlIIlll;
                short lllllllllllllllIlIllllIllIlIIllI;
                short lllllllllllllllIlIllllIllIlIIlIl;
                short lllllllllllllllIlIllllIllIlIIlII;
                final UserConnection lllllllllllllIIlIllllllIlIllIllI;
                PacketWrapper lllllllllllllllIlIllllIllIIllllI;
                final short lllllllllllllllIlIllllIllIIlllll;
                this.handler(lllllllllllllllIlIllllIllIlllIlI -> {
                    lllllllllllllllIlIllllIllIllllIl = lllllllllllllllIlIllllIllIlllIlI.user().get(ClientWorld.class);
                    lllllllllllllllIlIllllIllIllllII = lllllllllllllllIlIllllIllIlllIlI.read((Type<Chunk>)new Chunk1_9_1_2Type(lllllllllllllllIlIllllIllIllllIl));
                    lllllllllllllllIlIllllIllIllIlll = (float)(Object)lllllllllllllllIlIllllIllIllllII.getSections();
                    for (lllllllllllllllIlIllllIllIllIllI = lllllllllllllllIlIllllIllIllIlll.length; i < lllllllllllllllIlIllllIllIllIllI; ++i) {
                        lllllllllllllllIlIllllIlllIIIIlI = lllllllllllllllIlIllllIllIllIlll[i];
                        if (lllllllllllllllIlIllllIlllIIIIlI != null) {
                            for (lllllllllllllllIlIllllIlllIIIIll = 0; lllllllllllllllIlIllllIlllIIIIll < lllllllllllllllIlIllllIlllIIIIlI.getPaletteSize(); ++lllllllllllllllIlIllllIlllIIIIll) {
                                lllllllllllllllIlIllllIlllIIIlIl = lllllllllllllllIlIllllIlllIIIIlI.getPaletteEntry(lllllllllllllllIlIllllIlllIIIIll);
                                lllllllllllllllIlIllllIlllIIIlII = ReplacementRegistry1_8to1_9.replace(lllllllllllllllIlIllllIlllIIIlIl);
                                lllllllllllllllIlIllllIlllIIIIlI.setPaletteEntry(lllllllllllllllIlIllllIlllIIIIll, lllllllllllllllIlIllllIlllIIIlII);
                            }
                        }
                    }
                    if (lllllllllllllllIlIllllIllIllllII.isFullChunk() && lllllllllllllllIlIllllIllIllllII.getBitmask() == 0) {
                        lllllllllllllllIlIllllIlllIIIIIl = (lllllllllllllllIlIllllIllIllllIl.getEnvironment() == Environment.NORMAL);
                        lllllllllllllllIlIllllIlllIIIIII = new ChunkSection[16];
                        lllllllllllllllIlIllllIllIllllll = new ChunkSectionImpl(true);
                        (lllllllllllllllIlIllllIlllIIIIII[0] = lllllllllllllllIlIllllIllIllllll).addPaletteEntry(0);
                        if (lllllllllllllllIlIllllIlllIIIIIl) {
                            lllllllllllllllIlIllllIllIllllll.getLight().setSkyLight(new byte[2048]);
                        }
                        lllllllllllllllIlIllllIllIllllII = new Chunk1_8(lllllllllllllllIlIllllIllIllllII.getX(), lllllllllllllllIlIllllIllIllllII.getZ(), true, 1, lllllllllllllllIlIllllIlllIIIIII, lllllllllllllllIlIllllIllIllllII.getBiomeData(), lllllllllllllllIlIllllIllIllllII.getBlockEntities());
                    }
                    lllllllllllllllIlIllllIllIlllIlI.write((Type<Chunk>)new Chunk1_8Type(lllllllllllllllIlIllllIllIllllIl), lllllllllllllllIlIllllIllIllllII);
                    lllllllllllllllIlIllllIllIlllIll = lllllllllllllllIlIllllIllIlllIlI.user();
                    lllllllllllllllIlIllllIllIllllII.getBlockEntities().forEach(lllllllllllllllIlIllllIllIlIIIlI -> {
                        if (lllllllllllllllIlIllllIllIlIIIlI.contains("x") && lllllllllllllllIlIllllIllIlIIIlI.contains("y") && lllllllllllllllIlIllllIllIlIIIlI.contains("z") && lllllllllllllllIlIllllIllIlIIIlI.contains("id")) {
                            lllllllllllllllIlIllllIllIlIIIIl = new Position((int)lllllllllllllllIlIllllIllIlIIIlI.get("x").getValue(), (short)(int)lllllllllllllllIlIllllIllIlIIIlI.get("y").getValue(), (int)lllllllllllllllIlIllllIllIlIIIlI.get("z").getValue());
                            lllllllllllllllIlIllllIllIlIIIII = (s = (String)lllllllllllllllIlIllllIllIlIIIlI.get("id").getValue());
                            lllllllllllllllIlIllllIllIIlIlll = -1;
                            switch (s.hashCode()) {
                                case -199249700: {
                                    if (s.equals("minecraft:mob_spawner")) {
                                        lllllllllllllllIlIllllIllIIlIlll = 0;
                                        break;
                                    }
                                    else {
                                        break;
                                    }
                                    break;
                                }
                                case 339138444: {
                                    if (s.equals("minecraft:command_block")) {
                                        lllllllllllllllIlIllllIllIIlIlll = 1;
                                        break;
                                    }
                                    else {
                                        break;
                                    }
                                    break;
                                }
                                case -1293651279: {
                                    if (s.equals("minecraft:beacon")) {
                                        lllllllllllllllIlIllllIllIIlIlll = 2;
                                        break;
                                    }
                                    else {
                                        break;
                                    }
                                    break;
                                }
                                case -1134211248: {
                                    if (s.equals("minecraft:skull")) {
                                        lllllllllllllllIlIllllIllIIlIlll = 3;
                                        break;
                                    }
                                    else {
                                        break;
                                    }
                                    break;
                                }
                                case -1883218338: {
                                    if (s.equals("minecraft:flower_pot")) {
                                        lllllllllllllllIlIllllIllIIlIlll = 4;
                                        break;
                                    }
                                    else {
                                        break;
                                    }
                                    break;
                                }
                                case -1296947815: {
                                    if (s.equals("minecraft:banner")) {
                                        lllllllllllllllIlIllllIllIIlIlll = 5;
                                        break;
                                    }
                                    else {
                                        break;
                                    }
                                    break;
                                }
                            }
                            switch (lllllllllllllllIlIllllIllIIlIlll) {
                                case 0: {
                                    lllllllllllllllIlIllllIllIlIlIIl = 1;
                                    break;
                                }
                                case 1: {
                                    lllllllllllllllIlIllllIllIlIlIII = 2;
                                    break;
                                }
                                case 2: {
                                    lllllllllllllllIlIllllIllIlIIlll = 3;
                                    break;
                                }
                                case 3: {
                                    lllllllllllllllIlIllllIllIlIIllI = 4;
                                    break;
                                }
                                case 4: {
                                    lllllllllllllllIlIllllIllIlIIlIl = 5;
                                    break;
                                }
                                case 5: {
                                    lllllllllllllllIlIllllIllIlIIlII = 6;
                                    break;
                                }
                                default: {
                                    return;
                                }
                            }
                            lllllllllllllllIlIllllIllIIllllI = PacketWrapper.create(9, null, lllllllllllllIIlIllllllIlIllIllI);
                            lllllllllllllllIlIllllIllIIllllI.write(Type.POSITION, lllllllllllllllIlIllllIllIlIIIIl);
                            lllllllllllllllIlIllllIllIIllllI.write(Type.UNSIGNED_BYTE, lllllllllllllllIlIllllIllIIlllll);
                            lllllllllllllllIlIllllIllIIllllI.write(Type.NBT, lllllllllllllllIlIllllIllIlIIIlI);
                            PacketUtil.sendPacket(lllllllllllllllIlIllllIllIIllllI, Protocol1_8TO1_9.class, false, false);
                        }
                    });
                });
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.POSITION);
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                final int lllllllllllllIIlllIllIIIIlIIIIll;
                final int lllllllllllllIIlllIllIIIIlIIIIll2;
                int lllllllllllllIIlllIllIIIIlIIIlIl;
                this.handler(lllllllllllllIIlllIllIIIIlIIIlII -> {
                    lllllllllllllIIlllIllIIIIlIIIIll = lllllllllllllIIlllIllIIIIlIIIlII.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIIlllIllIIIIlIIIIll2 = Effect.getOldId(lllllllllllllIIlllIllIIIIlIIIIll);
                    if (lllllllllllllIIlllIllIIIIlIIIIll2 == -1) {
                        lllllllllllllIIlllIllIIIIlIIIlII.cancel();
                    }
                    else {
                        lllllllllllllIIlllIllIIIIlIIIlII.set(Type.INT, 0, lllllllllllllIIlllIllIIIIlIIIIll2);
                        if (lllllllllllllIIlllIllIIIIlIIIIll2 == 2001) {
                            lllllllllllllIIlllIllIIIIlIIIlIl = ReplacementRegistry1_8to1_9.replace(lllllllllllllIIlllIllIIIIlIIIlII.get((Type<Integer>)Type.INT, 1));
                            lllllllllllllIIlllIllIIIIlIIIlII.set(Type.INT, 1, lllllllllllllIIlllIllIIIIlIIIlIl);
                        }
                    }
                });
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                final int llllllllllllllllIllllIlllIlIllll;
                this.handler(llllllllllllllllIllllIlllIlIlllI -> {
                    llllllllllllllllIllllIlllIlIllll = llllllllllllllllIllllIlllIlIlllI.get((Type<Integer>)Type.INT, 0);
                    if (llllllllllllllllIllllIlllIlIllll > 41 && !ViaRewind.getConfig().isReplaceParticles()) {
                        llllllllllllllllIllllIlllIlIlllI.cancel();
                    }
                    else if (llllllllllllllllIllllIlllIlIllll == 42) {
                        llllllllllllllllIllllIlllIlIlllI.set(Type.INT, 0, 24);
                    }
                    else if (llllllllllllllllIllllIlllIlIllll == 43) {
                        llllllllllllllllIllllIlllIlIlllI.set(Type.INT, 0, 3);
                    }
                    else if (llllllllllllllllIllllIlllIlIllll == 44) {
                        llllllllllllllllIllllIlllIlIlllI.set(Type.INT, 0, 34);
                    }
                    else if (llllllllllllllllIllllIlllIlIllll == 45) {
                        llllllllllllllllIllllIlllIlIlllI.set(Type.INT, 0, 1);
                    }
                });
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN, Type.NOTHING);
            }
        });
        lllllllllllllIlIIlIIIlIIIlIIllII.registerClientbound(ClientboundPackets1_9.SOUND, ClientboundPackets1_8.NAMED_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllIlIIlIIlllIllIIllI;
                final String llllllllllllllIlIIlIIlllIllIIlIl;
                this.handler(llllllllllllllIlIIlIIlllIllIIlII -> {
                    llllllllllllllIlIIlIIlllIllIIllI = llllllllllllllIlIIlIIlllIllIIlII.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIlIIlIIlllIllIIlIl = SoundRemapper.oldNameFromId(llllllllllllllIlIIlIIlllIllIIllI);
                    if (llllllllllllllIlIIlIIlllIllIIlIl == null) {
                        llllllllllllllIlIIlIIlllIllIIlII.cancel();
                    }
                    else {
                        llllllllllllllIlIIlIIlllIllIIlII.write(Type.STRING, llllllllllllllIlIIlIIlllIllIIlIl);
                    }
                    return;
                });
                this.handler(llllllllllllllIlIIlIIlllIllIlIll -> llllllllllllllIlIIlIIlllIllIlIll.read((Type<Object>)Type.VAR_INT));
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.FLOAT);
                this.map(Type.UNSIGNED_BYTE);
            }
        });
    }
}
