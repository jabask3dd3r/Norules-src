package com.viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public class WorldPackets1_13_1
{
    public static void register(final Protocol lllllllllllllllllIIlllIlIlIIIlll) {
        final BlockRewriter lllllllllllllllllIIlllIlIlIIIllI = new BlockRewriter(lllllllllllllllllIIlllIlIlIIIlll, Type.POSITION);
        lllllllllllllllllIIlllIlIlIIIlll.registerClientbound(ClientboundPackets1_13.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIllllllIIlIlIlll) throws Exception {
                        final ClientWorld llllllllllllllllIllllllIIlIllIlI = llllllllllllllllIllllllIIlIlIlll.user().get(ClientWorld.class);
                        final Chunk llllllllllllllllIllllllIIlIllIIl = llllllllllllllllIllllllIIlIlIlll.passthrough((Type<Chunk>)new Chunk1_13Type(llllllllllllllllIllllllIIlIllIlI));
                        final long llllllllllllllllIllllllIIlIlIlII = (Object)llllllllllllllllIllllllIIlIllIIl.getSections();
                        for (boolean llllllllllllllllIllllllIIlIlIIll = llllllllllllllllIllllllIIlIlIlII.length != 0, llllllllllllllllIllllllIIlIlIIlI = false; llllllllllllllllIllllllIIlIlIIlI < llllllllllllllllIllllllIIlIlIIll; ++llllllllllllllllIllllllIIlIlIIlI) {
                            final ChunkSection llllllllllllllllIllllllIIlIlllIl = llllllllllllllllIllllllIIlIlIlII[llllllllllllllllIllllllIIlIlIIlI];
                            if (llllllllllllllllIllllllIIlIlllIl != null) {
                                for (int llllllllllllllllIllllllIIlIllllI = 0; llllllllllllllllIllllllIIlIllllI < llllllllllllllllIllllllIIlIlllIl.getPaletteSize(); ++llllllllllllllllIllllllIIlIllllI) {
                                    llllllllllllllllIllllllIIlIlllIl.setPaletteEntry(llllllllllllllllIllllllIIlIllllI, lllllllllllllllllIIlllIlIlIIIlll.getMappingData().getNewBlockStateId(llllllllllllllllIllllllIIlIlllIl.getPaletteEntry(llllllllllllllllIllllllIIlIllllI)));
                                }
                            }
                        }
                    }
                });
            }
        });
        lllllllllllllllllIIlllIlIlIIIllI.registerBlockAction(ClientboundPackets1_13.BLOCK_ACTION);
        lllllllllllllllllIIlllIlIlIIIllI.registerBlockChange(ClientboundPackets1_13.BLOCK_CHANGE);
        lllllllllllllllllIIlllIlIlIIIllI.registerMultiBlockChange(ClientboundPackets1_13.MULTI_BLOCK_CHANGE);
        lllllllllllllllllIIlllIlIlIIIllI.registerEffect(ClientboundPackets1_13.EFFECT, 1010, 2001);
    }
}
