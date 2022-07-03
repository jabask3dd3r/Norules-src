package com.viaversion.viaversion.protocols.protocol1_17to1_16_4.packets;

import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.types.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public final class WorldPackets
{
    private static void addNewDimensionData(final CompoundTag lllllllllllllIllIlIlIIlIIIIIIIIl) {
        lllllllllllllIllIlIlIIlIIIIIIIIl.put("min_y", new IntTag(0));
        lllllllllllllIllIlIlIIlIIIIIIIIl.put("height", new IntTag(256));
    }
    
    public static void register(final Protocol1_17To1_16_4 lllllllllllllIllIlIlIIlIIIlIllII) {
        final BlockRewriter lllllllllllllIllIlIlIIlIIIlIllIl = new BlockRewriter(lllllllllllllIllIlIlIIlIIIlIllII, Type.POSITION1_14);
        lllllllllllllIllIlIlIIlIIIlIllIl.registerBlockAction(ClientboundPackets1_16_2.BLOCK_ACTION);
        lllllllllllllIllIlIlIIlIIIlIllIl.registerBlockChange(ClientboundPackets1_16_2.BLOCK_CHANGE);
        lllllllllllllIllIlIlIIlIIIlIllIl.registerVarLongMultiBlockChange(ClientboundPackets1_16_2.MULTI_BLOCK_CHANGE);
        lllllllllllllIllIlIlIIlIIIlIllIl.registerAcknowledgePlayerDigging(ClientboundPackets1_16_2.ACKNOWLEDGE_PLAYER_DIGGING);
        ((Protocol<ClientboundPackets1_16_2, ClientboundPackets1_17, S1, S2>)lllllllllllllIllIlIlIIlIIIlIllII).registerClientbound(ClientboundPackets1_16_2.WORLD_BORDER, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllIlllIIIlIlIIlIIIII;
                final ClientboundPacketType llllllllllllllIlllIIIlIlIIlIIlll;
                final ClientboundPacketType llllllllllllllIlllIIIlIlIIlIIllI;
                final ClientboundPacketType llllllllllllllIlllIIIlIlIIlIIlIl;
                final ClientboundPacketType llllllllllllllIlllIIIlIlIIlIIlII;
                final ClientboundPacketType llllllllllllllIlllIIIlIlIIlIIIll;
                final ClientboundPacketType llllllllllllllIlllIIIlIlIIlIIIlI;
                final IllegalArgumentException ex;
                final ClientboundPacketType llllllllllllllIlllIIIlIlIIIlllll;
                this.handler(llllllllllllllIlllIIIlIlIIlIIIIl -> {
                    llllllllllllllIlllIIIlIlIIlIIIII = llllllllllllllIlllIIIlIlIIlIIIIl.read((Type<Integer>)Type.VAR_INT);
                    switch (llllllllllllllIlllIIIlIlIIlIIIII) {
                        case 0: {
                            llllllllllllllIlllIIIlIlIIlIIlll = ClientboundPackets1_17.WORLD_BORDER_SIZE;
                            break;
                        }
                        case 1: {
                            llllllllllllllIlllIIIlIlIIlIIllI = ClientboundPackets1_17.WORLD_BORDER_LERP_SIZE;
                            break;
                        }
                        case 2: {
                            llllllllllllllIlllIIIlIlIIlIIlIl = ClientboundPackets1_17.WORLD_BORDER_CENTER;
                            break;
                        }
                        case 3: {
                            llllllllllllllIlllIIIlIlIIlIIlII = ClientboundPackets1_17.WORLD_BORDER_INIT;
                            break;
                        }
                        case 4: {
                            llllllllllllllIlllIIIlIlIIlIIIll = ClientboundPackets1_17.WORLD_BORDER_WARNING_DELAY;
                            break;
                        }
                        case 5: {
                            llllllllllllllIlllIIIlIlIIlIIIlI = ClientboundPackets1_17.WORLD_BORDER_WARNING_DISTANCE;
                            break;
                        }
                        default: {
                            new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid world border type received: ").append(llllllllllllllIlllIIIlIlIIlIIIII)));
                            throw ex;
                        }
                    }
                    llllllllllllllIlllIIIlIlIIlIIIIl.setId(llllllllllllllIlllIIIlIlIIIlllll.getId());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)lllllllllllllIllIlIlIIlIIIlIllII).registerClientbound(ClientboundPackets1_16_2.UPDATE_LIGHT, new PacketRemapper() {
            private boolean isSet(final int llllllllllllllIIllIlIIlIllIlIlII, final int llllllllllllllIIllIlIIlIllIlIIll) {
                return (llllllllllllllIIllIlIIlIllIlIlII & 1 << llllllllllllllIIllIlIIlIllIlIIll) != 0x0;
            }
            
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                final int llllllllllllllIIllIlIIlIllIIlIlI;
                final int llllllllllllllIIllIlIIlIllIIlIIl;
                this.handler(llllllllllllllIIllIlIIlIllIIIlll -> {
                    llllllllllllllIIllIlIIlIllIIlIlI = llllllllllllllIIllIlIIlIllIIIlll.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIIllIlIIlIllIIlIIl = llllllllllllllIIllIlIIlIllIIIlll.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllIIllIlIIlIllIIIlll.write(Type.LONG_ARRAY_PRIMITIVE, this.toBitSetLongArray(llllllllllllllIIllIlIIlIllIIlIlI));
                    llllllllllllllIIllIlIIlIllIIIlll.write(Type.LONG_ARRAY_PRIMITIVE, this.toBitSetLongArray(llllllllllllllIIllIlIIlIllIIlIIl));
                    llllllllllllllIIllIlIIlIllIIIlll.write(Type.LONG_ARRAY_PRIMITIVE, this.toBitSetLongArray(llllllllllllllIIllIlIIlIllIIIlll.read((Type<Integer>)Type.VAR_INT)));
                    llllllllllllllIIllIlIIlIllIIIlll.write(Type.LONG_ARRAY_PRIMITIVE, this.toBitSetLongArray(llllllllllllllIIllIlIIlIllIIIlll.read((Type<Integer>)Type.VAR_INT)));
                    this.writeLightArrays(llllllllllllllIIllIlIIlIllIIIlll, llllllllllllllIIllIlIIlIllIIlIlI);
                    this.writeLightArrays(llllllllllllllIIllIlIIlIllIIIlll, llllllllllllllIIllIlIIlIllIIlIIl);
                });
            }
            
            private long[] toBitSetLongArray(final int llllllllllllllIIllIlIIlIlllIIIII) {
                return new long[] { llllllllllllllIIllIlIIlIlllIIIII };
            }
            
            private void writeLightArrays(final PacketWrapper llllllllllllllIIllIlIIlIllllIlIl, final int llllllllllllllIIllIlIIlIllllIIll) throws Exception {
                final List<byte[]> llllllllllllllIIllIlIIlIllllIIIl = new ArrayList<byte[]>();
                for (int llllllllllllllIIllIlIIlIlllllIIl = 0; llllllllllllllIIllIlIIlIlllllIIl < 18; ++llllllllllllllIIllIlIIlIlllllIIl) {
                    if (this.isSet(llllllllllllllIIllIlIIlIllllIIll, llllllllllllllIIllIlIIlIlllllIIl)) {
                        llllllllllllllIIllIlIIlIllllIIIl.add(llllllllllllllIIllIlIIlIllllIlIl.read(Type.BYTE_ARRAY_PRIMITIVE));
                    }
                }
                llllllllllllllIIllIlIIlIllllIlIl.write(Type.VAR_INT, llllllllllllllIIllIlIIlIllllIIIl.size());
                for (final byte[] llllllllllllllIIllIlIIlIlllllIII : llllllllllllllIIllIlIIlIllllIIIl) {
                    llllllllllllllIIllIlIIlIllllIlIl.write(Type.BYTE_ARRAY_PRIMITIVE, llllllllllllllIIllIlIIlIlllllIII);
                }
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)lllllllllllllIllIlIlIIlIIIlIllII).registerClientbound(ClientboundPackets1_16_2.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: aload_0         /* lIllIlIllIllllI */
                //     2: getfield        com/viaversion/viaversion/protocols/protocol1_17to1_16_4/packets/WorldPackets$3.val$protocol:Lcom/viaversion/viaversion/protocols/protocol1_17to1_16_4/Protocol1_17To1_16_4;
                //     5: invokedynamic   BootstrapMethod #0, handle:(Lcom/viaversion/viaversion/protocols/protocol1_17to1_16_4/Protocol1_17To1_16_4;)Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;
                //    10: invokevirtual   com/viaversion/viaversion/protocols/protocol1_17to1_16_4/packets/WorldPackets$3.handler:(Lcom/viaversion/viaversion/api/protocol/remapper/PacketHandler;)V
                //    13: return         
                // 
                // The error that occurred was:
                // 
                // java.lang.IllegalStateException: Could not infer any expression.
                //     at com.strobel.decompiler.ast.TypeAnalysis.runInference(TypeAnalysis.java:374)
                //     at com.strobel.decompiler.ast.TypeAnalysis.run(TypeAnalysis.java:96)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:344)
                //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
                //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)lllllllllllllIllIlIlIIlIIIlIllII).registerClientbound(ClientboundPackets1_16_2.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.BYTE);
                this.map(Type.STRING_ARRAY);
                this.map(Type.NBT);
                this.map(Type.NBT);
                final CompoundTag lllllllllllllIIIIIIlIlIIIlIIIlII;
                final ListTag lllllllllllllIIIIIIlIlIIIlIIIIll;
                final int lllllllllllllIIIIIIlIlIIIIllllIl;
                Tag lllllllllllllIIIIIIlIlIIIlIIIllI;
                CompoundTag lllllllllllllIIIIIIlIlIIIlIIIlll;
                final CompoundTag lllllllllllllIIIIIIlIlIIIlIIIIlI;
                final UserConnection lllllllllllllIIIIIIlIlIIIlIIIIIl;
                this.handler(lllllllllllllIIIIIIlIlIIIlIIIIII -> {
                    lllllllllllllIIIIIIlIlIIIlIIIlII = (CompoundTag)lllllllllllllIIIIIIlIlIIIlIIIIII.get(Type.NBT, 0).get("minecraft:dimension_type");
                    lllllllllllllIIIIIIlIlIIIlIIIIll = lllllllllllllIIIIIIlIlIIIlIIIlII.get("value");
                    lllllllllllllIIIIIIlIlIIIIllllIl = (int)lllllllllllllIIIIIIlIlIIIlIIIIll.iterator();
                    while (((Iterator)lllllllllllllIIIIIIlIlIIIIllllIl).hasNext()) {
                        lllllllllllllIIIIIIlIlIIIlIIIllI = ((Iterator<Tag>)lllllllllllllIIIIIIlIlIIIIllllIl).next();
                        lllllllllllllIIIIIIlIlIIIlIIIlll = ((CompoundTag)lllllllllllllIIIIIIlIlIIIlIIIllI).get("element");
                        addNewDimensionData(lllllllllllllIIIIIIlIlIIIlIIIlll);
                    }
                    lllllllllllllIIIIIIlIlIIIlIIIIlI = lllllllllllllIIIIIIlIlIIIlIIIIII.get(Type.NBT, 1);
                    addNewDimensionData(lllllllllllllIIIIIIlIlIIIlIIIIlI);
                    lllllllllllllIIIIIIlIlIIIlIIIIIl = lllllllllllllIIIIIIlIlIIIlIIIIII.user();
                    lllllllllllllIIIIIIlIlIIIlIIIIIl.getEntityTracker(Protocol1_17To1_16_4.class).addEntity(lllllllllllllIIIIIIlIlIIIlIIIIII.get((Type<Integer>)Type.INT, 0), Entity1_17Types.PLAYER);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)lllllllllllllIllIlIlIIlIIIlIllII).registerClientbound(ClientboundPackets1_16_2.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                final CompoundTag lllllllllllllllIIlllIIllIlllIIlI;
                this.handler(lllllllllllllllIIlllIIllIlllIIIl -> {
                    lllllllllllllllIIlllIIllIlllIIlI = lllllllllllllllIIlllIIllIlllIIIl.passthrough(Type.NBT);
                    addNewDimensionData(lllllllllllllllIIlllIIllIlllIIlI);
                });
            }
        });
        lllllllllllllIllIlIlIIlIIIlIllIl.registerEffect(ClientboundPackets1_16_2.EFFECT, 1010, 2001);
    }
    
    private static void writeMultiBlockChangePacket(final PacketWrapper lllllllllllllIllIlIlIIlIIIIlIIII, final Chunk lllllllllllllIllIlIlIIlIIIIIllll) throws Exception {
        long lllllllllllllIllIlIlIIlIIIIlIIlI = ((long)lllllllllllllIllIlIlIIlIIIIIllll.getX() & 0x3FFFFFL) << 42;
        lllllllllllllIllIlIlIIlIIIIlIIlI |= ((long)lllllllllllllIllIlIlIIlIIIIIllll.getZ() & 0x3FFFFFL) << 20;
        final ChunkSection[] lllllllllllllIllIlIlIIlIIIIlIIIl = lllllllllllllIllIlIlIIlIIIIIllll.getSections();
        for (int lllllllllllllIllIlIlIIlIIIIlIlIl = 0; lllllllllllllIllIlIlIIlIIIIlIlIl < lllllllllllllIllIlIlIIlIIIIlIIIl.length; ++lllllllllllllIllIlIlIIlIIIIlIlIl) {
            final ChunkSection lllllllllllllIllIlIlIIlIIIIllIIl = lllllllllllllIllIlIlIIlIIIIlIIIl[lllllllllllllIllIlIlIIlIIIIlIlIl];
            if (lllllllllllllIllIlIlIIlIIIIllIIl != null) {
                final PacketWrapper lllllllllllllIllIlIlIIlIIIIllIII = lllllllllllllIllIlIlIIlIIIIlIIII.create(ClientboundPackets1_17.MULTI_BLOCK_CHANGE);
                lllllllllllllIllIlIlIIlIIIIllIII.write(Type.LONG, lllllllllllllIllIlIlIIlIIIIlIIlI | ((long)lllllllllllllIllIlIlIIlIIIIlIlIl & 0xFFFFFL));
                lllllllllllllIllIlIlIIlIIIIllIII.write(Type.BOOLEAN, true);
                final BlockChangeRecord[] lllllllllllllIllIlIlIIlIIIIlIlll = new BlockChangeRecord[4096];
                int lllllllllllllIllIlIlIIlIIIIlIllI = 0;
                for (int lllllllllllllIllIlIlIIlIIIIllIlI = 0; lllllllllllllIllIlIlIIlIIIIllIlI < 16; ++lllllllllllllIllIlIlIIlIIIIllIlI) {
                    for (int lllllllllllllIllIlIlIIlIIIIllIll = 0; lllllllllllllIllIlIlIIlIIIIllIll < 16; ++lllllllllllllIllIlIlIIlIIIIllIll) {
                        for (int lllllllllllllIllIlIlIIlIIIIlllII = 0; lllllllllllllIllIlIlIIlIIIIlllII < 16; ++lllllllllllllIllIlIlIIlIIIIlllII) {
                            final int lllllllllllllIllIlIlIIlIIIIlllIl = Protocol1_17To1_16_4.MAPPINGS.getNewBlockStateId(lllllllllllllIllIlIlIIlIIIIllIIl.getFlatBlock(lllllllllllllIllIlIlIIlIIIIllIlI, lllllllllllllIllIlIlIIlIIIIllIll, lllllllllllllIllIlIlIIlIIIIlllII));
                            lllllllllllllIllIlIlIIlIIIIlIlll[lllllllllllllIllIlIlIIlIIIIlIllI++] = new BlockChangeRecord1_16_2(lllllllllllllIllIlIlIIlIIIIllIlI, lllllllllllllIllIlIlIIlIIIIllIll, lllllllllllllIllIlIlIIlIIIIlllII, lllllllllllllIllIlIlIIlIIIIlllIl);
                        }
                    }
                }
                lllllllllllllIllIlIlIIlIIIIllIII.write(Type.VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY, lllllllllllllIllIlIlIIlIIIIlIlll);
                lllllllllllllIllIlIlIIlIIIIllIII.send(Protocol1_17To1_16_4.class);
            }
        }
    }
}
