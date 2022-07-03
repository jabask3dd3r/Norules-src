package com.viaversion.viaversion.protocols.protocol1_13_1to1_13.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public class WorldPackets
{
    public static void register(final Protocol llllllllllllllIIlIlIllIIIIllIlII) {
        final BlockRewriter llllllllllllllIIlIlIllIIIIllIIll = new BlockRewriter(llllllllllllllIIlIlIllIIIIllIlII, Type.POSITION);
        llllllllllllllIIlIlIllIIIIllIlII.registerClientbound(ClientboundPackets1_13.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIlIllIlIIIlIIlI) throws Exception {
                        final ClientWorld lllllllllllllIIIIIlIllIlIIIlIIIl = lllllllllllllIIIIIlIllIlIIIlIIlI.user().get(ClientWorld.class);
                        final Chunk lllllllllllllIIIIIlIllIlIIIlIIII = lllllllllllllIIIIIlIllIlIIIlIIlI.passthrough((Type<Chunk>)new Chunk1_13Type(lllllllllllllIIIIIlIllIlIIIlIIIl));
                        final char lllllllllllllIIIIIlIllIlIIIIlIll = (Object)lllllllllllllIIIIIlIllIlIIIlIIII.getSections();
                        final Exception lllllllllllllIIIIIlIllIlIIIIlIlI = (Exception)lllllllllllllIIIIIlIllIlIIIIlIll.length;
                        for (byte lllllllllllllIIIIIlIllIlIIIIlIIl = 0; lllllllllllllIIIIIlIllIlIIIIlIIl < lllllllllllllIIIIIlIllIlIIIIlIlI; ++lllllllllllllIIIIIlIllIlIIIIlIIl) {
                            final ChunkSection lllllllllllllIIIIIlIllIlIIIlIlII = lllllllllllllIIIIIlIllIlIIIIlIll[lllllllllllllIIIIIlIllIlIIIIlIIl];
                            if (lllllllllllllIIIIIlIllIlIIIlIlII != null) {
                                for (int lllllllllllllIIIIIlIllIlIIIlIlIl = 0; lllllllllllllIIIIIlIllIlIIIlIlIl < lllllllllllllIIIIIlIllIlIIIlIlII.getPaletteSize(); ++lllllllllllllIIIIIlIllIlIIIlIlIl) {
                                    lllllllllllllIIIIIlIllIlIIIlIlII.setPaletteEntry(lllllllllllllIIIIIlIllIlIIIlIlIl, llllllllllllllIIlIlIllIIIIllIlII.getMappingData().getNewBlockStateId(lllllllllllllIIIIIlIllIlIIIlIlII.getPaletteEntry(lllllllllllllIIIIIlIllIlIIIlIlIl)));
                                }
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIIlIlIllIIIIllIIll.registerBlockAction(ClientboundPackets1_13.BLOCK_ACTION);
        llllllllllllllIIlIlIllIIIIllIIll.registerBlockChange(ClientboundPackets1_13.BLOCK_CHANGE);
        llllllllllllllIIlIlIllIIIIllIIll.registerMultiBlockChange(ClientboundPackets1_13.MULTI_BLOCK_CHANGE);
        llllllllllllllIIlIlIllIIIIllIIll.registerEffect(ClientboundPackets1_13.EFFECT, 1010, 2001);
        llllllllllllllIIlIlIllIIIIllIlII.registerClientbound(ClientboundPackets1_13.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllIIllIIIIlllIIll) throws Exception {
                        final ClientWorld lllllllllllllIIllIIllIIIIlllIIlI = lllllllllllllIIllIIllIIIIlllIIll.user().get(ClientWorld.class);
                        final int lllllllllllllIIllIIllIIIIlllIIIl = lllllllllllllIIllIIllIIIIlllIIll.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIIllIIllIIIIlllIIlI.setEnvironment(lllllllllllllIIllIIllIIIIlllIIIl);
                    }
                });
            }
        });
        llllllllllllllIIlIlIllIIIIllIlII.registerClientbound(ClientboundPackets1_13.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllllIllllllIlIII) throws Exception {
                        final ClientWorld lllllllllllllIIIllllIllllllIlIlI = lllllllllllllIIIllllIllllllIlIII.user().get(ClientWorld.class);
                        final int lllllllllllllIIIllllIllllllIlIIl = lllllllllllllIIIllllIllllllIlIII.get((Type<Integer>)Type.INT, 0);
                        lllllllllllllIIIllllIllllllIlIlI.setEnvironment(lllllllllllllIIIllllIllllllIlIIl);
                    }
                });
            }
        });
    }
}
