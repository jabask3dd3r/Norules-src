package com.viaversion.viaversion.protocols.protocol1_15to1_14_4.packets;

import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.types.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.*;

public class WorldPackets
{
    public static void register(final Protocol1_15To1_14_4 lllllllllllllllllIlIlIlIlIIIIlIl) {
        final BlockRewriter lllllllllllllllllIlIlIlIlIIIIllI = new BlockRewriter(lllllllllllllllllIlIlIlIlIIIIlIl, Type.POSITION1_14);
        lllllllllllllllllIlIlIlIlIIIIllI.registerBlockAction(ClientboundPackets1_14.BLOCK_ACTION);
        lllllllllllllllllIlIlIlIlIIIIllI.registerBlockChange(ClientboundPackets1_14.BLOCK_CHANGE);
        lllllllllllllllllIlIlIlIlIIIIllI.registerMultiBlockChange(ClientboundPackets1_14.MULTI_BLOCK_CHANGE);
        lllllllllllllllllIlIlIlIlIIIIllI.registerAcknowledgePlayerDigging(ClientboundPackets1_14.ACKNOWLEDGE_PLAYER_DIGGING);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)lllllllllllllllllIlIlIlIlIIIIlIl).registerClientbound(ClientboundPackets1_14.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlllIlllIIIIlIlII) throws Exception {
                        final Chunk lllllllllllllIIIlllIlllIIIIlIIll = lllllllllllllIIIlllIlllIIIIlIlII.read((Type<Chunk>)new Chunk1_14Type());
                        lllllllllllllIIIlllIlllIIIIlIlII.write(new Chunk1_15Type(), lllllllllllllIIIlllIlllIIIIlIIll);
                        if (lllllllllllllIIIlllIlllIIIIlIIll.isFullChunk()) {
                            final int[] lllllllllllllIIIlllIlllIIIIlllII = lllllllllllllIIIlllIlllIIIIlIIll.getBiomeData();
                            final int[] lllllllllllllIIIlllIlllIIIIllIll = new int[1024];
                            if (lllllllllllllIIIlllIlllIIIIlllII != null) {
                                for (int lllllllllllllIIIlllIlllIIIIllllI = 0; lllllllllllllIIIlllIlllIIIIllllI < 4; ++lllllllllllllIIIlllIlllIIIIllllI) {
                                    for (int lllllllllllllIIIlllIlllIIIIlllll = 0; lllllllllllllIIIlllIlllIIIIlllll < 4; ++lllllllllllllIIIlllIlllIIIIlllll) {
                                        final int lllllllllllllIIIlllIlllIIIlIIIlI = (lllllllllllllIIIlllIlllIIIIlllll << 2) + 2;
                                        final int lllllllllllllIIIlllIlllIIIlIIIIl = (lllllllllllllIIIlllIlllIIIIllllI << 2) + 2;
                                        final int lllllllllllllIIIlllIlllIIIlIIIII = lllllllllllllIIIlllIlllIIIlIIIIl << 4 | lllllllllllllIIIlllIlllIIIlIIIlI;
                                        lllllllllllllIIIlllIlllIIIIllIll[lllllllllllllIIIlllIlllIIIIllllI << 2 | lllllllllllllIIIlllIlllIIIIlllll] = lllllllllllllIIIlllIlllIIIIlllII[lllllllllllllIIIlllIlllIIIlIIIII];
                                    }
                                }
                                for (int lllllllllllllIIIlllIlllIIIIlllIl = 1; lllllllllllllIIIlllIlllIIIIlllIl < 64; ++lllllllllllllIIIlllIlllIIIIlllIl) {
                                    System.arraycopy(lllllllllllllIIIlllIlllIIIIllIll, 0, lllllllllllllIIIlllIlllIIIIllIll, lllllllllllllIIIlllIlllIIIIlllIl * 16, 16);
                                }
                            }
                            lllllllllllllIIIlllIlllIIIIlIIll.setBiomeData(lllllllllllllIIIlllIlllIIIIllIll);
                        }
                        for (int lllllllllllllIIIlllIlllIIIIlIllI = 0; lllllllllllllIIIlllIlllIIIIlIllI < lllllllllllllIIIlllIlllIIIIlIIll.getSections().length; ++lllllllllllllIIIlllIlllIIIIlIllI) {
                            final ChunkSection lllllllllllllIIIlllIlllIIIIlIlll = lllllllllllllIIIlllIlllIIIIlIIll.getSections()[lllllllllllllIIIlllIlllIIIIlIllI];
                            if (lllllllllllllIIIlllIlllIIIIlIlll != null) {
                                for (int lllllllllllllIIIlllIlllIIIIllIII = 0; lllllllllllllIIIlllIlllIIIIllIII < lllllllllllllIIIlllIlllIIIIlIlll.getPaletteSize(); ++lllllllllllllIIIlllIlllIIIIllIII) {
                                    final int lllllllllllllIIIlllIlllIIIIllIlI = lllllllllllllIIIlllIlllIIIIlIlll.getPaletteEntry(lllllllllllllIIIlllIlllIIIIllIII);
                                    final int lllllllllllllIIIlllIlllIIIIllIIl = lllllllllllllllllIlIlIlIlIIIIlIl.getMappingData().getNewBlockStateId(lllllllllllllIIIlllIlllIIIIllIlI);
                                    lllllllllllllIIIlllIlllIIIIlIlll.setPaletteEntry(lllllllllllllIIIlllIlllIIIIllIII, lllllllllllllIIIlllIlllIIIIllIIl);
                                }
                            }
                        }
                    }
                });
            }
        });
        lllllllllllllllllIlIlIlIlIIIIllI.registerEffect(ClientboundPackets1_14.EFFECT, 1010, 2001);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)lllllllllllllllllIlIlIlIlIIIIlIl).registerClientbound(ClientboundPackets1_14.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.FLOAT, Type.DOUBLE);
                this.map(Type.FLOAT, Type.DOUBLE);
                this.map(Type.FLOAT, Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIIIIIllIIlIIIllI) throws Exception {
                        final int llllllllllllllllIIIIIllIIlIIIlIl = llllllllllllllllIIIIIllIIlIIIllI.get((Type<Integer>)Type.INT, 0);
                        if (llllllllllllllllIIIIIllIIlIIIlIl == 3 || llllllllllllllllIIIIIllIIlIIIlIl == 23) {
                            final int llllllllllllllllIIIIIllIIlIIlIII = llllllllllllllllIIIIIllIIlIIIllI.passthrough((Type<Integer>)Type.VAR_INT);
                            llllllllllllllllIIIIIllIIlIIIllI.set(Type.VAR_INT, 0, lllllllllllllllllIlIlIlIlIIIIlIl.getMappingData().getNewBlockStateId(llllllllllllllllIIIIIllIIlIIlIII));
                        }
                        else if (llllllllllllllllIIIIIllIIlIIIlIl == 32) {
                            lllllllllllllllllIlIlIlIlIIIIlIl.getItemRewriter().handleItemToClient(llllllllllllllllIIIIIllIIlIIIllI.passthrough(Type.FLAT_VAR_INT_ITEM));
                        }
                    }
                });
            }
        });
    }
}
