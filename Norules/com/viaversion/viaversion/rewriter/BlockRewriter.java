package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.*;

public class BlockRewriter
{
    private final /* synthetic */ Protocol protocol;
    private final /* synthetic */ Type<Position> positionType;
    
    public void registerEffect(final ClientboundPacketType lllllllllllllllllllIllIIllIIllII, final int lllllllllllllllllllIllIIllIIllll, final int lllllllllllllllllllIllIIllIIlIlI) {
        this.protocol.registerClientbound(lllllllllllllllllllIllIIllIIllII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(BlockRewriter.this.positionType);
                this.map(Type.INT);
                final int val$playRecordId;
                final int val$blockBreakId;
                final int lllllllllllllIlIIllIllIlIIIlIIlI;
                final int lllllllllllllIlIIllIllIlIIIlIIIl;
                this.handler(lllllllllllllIlIIllIllIlIIIlIIll -> {
                    val$playRecordId = lllllllllllllllllllIllIIllIIllll;
                    val$blockBreakId = lllllllllllllllllllIllIIllIIlIlI;
                    lllllllllllllIlIIllIllIlIIIlIIlI = lllllllllllllIlIIllIllIlIIIlIIll.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIlIIllIllIlIIIlIIIl = lllllllllllllIlIIllIllIlIIIlIIll.get((Type<Integer>)Type.INT, 1);
                    if (lllllllllllllIlIIllIllIlIIIlIIlI == val$playRecordId) {
                        lllllllllllllIlIIllIllIlIIIlIIll.set(Type.INT, 1, BlockRewriter.this.protocol.getMappingData().getNewItemId(lllllllllllllIlIIllIllIlIIIlIIIl));
                    }
                    else if (lllllllllllllIlIIllIllIlIIIlIIlI == val$blockBreakId) {
                        lllllllllllllIlIIllIllIlIIIlIIll.set(Type.INT, 1, BlockRewriter.this.protocol.getMappingData().getNewBlockStateId(lllllllllllllIlIIllIllIlIIIlIIIl));
                    }
                });
            }
        });
    }
    
    public void registerBlockChange(final ClientboundPacketType lllllllllllllllllllIllIIlllIlIlI) {
        this.protocol.registerClientbound(lllllllllllllllllllIllIIlllIlIlI, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(BlockRewriter.this.positionType);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllllllIllllllIIlIllll -> lllllllllllllllllIllllllIIlIllll.set(Type.VAR_INT, 0, BlockRewriter.this.protocol.getMappingData().getNewBlockStateId(lllllllllllllllllIllllllIIlIllll.get((Type<Integer>)Type.VAR_INT, 0))));
            }
        });
    }
    
    public void registerVarLongMultiBlockChange(final ClientboundPacketType lllllllllllllllllllIllIIllIllllI) {
        this.protocol.registerClientbound(lllllllllllllllllllIllIIllIllllI, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.LONG);
                this.map(Type.BOOLEAN);
                final double lllllllllllllllIIIIlllIIlIIIlllI;
                short lllllllllllllllIIIIlllIIlIIIllIl;
                char lllllllllllllllIIIIlllIIlIIIllII;
                BlockChangeRecord lllllllllllllllIIIIlllIIlIIlIIll;
                this.handler(lllllllllllllllIIIIlllIIlIIIllll -> {
                    lllllllllllllllIIIIlllIIlIIIlllI = lllllllllllllllIIIIlllIIlIIIllll.passthrough((Type<Double>)Type.VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY);
                    for (lllllllllllllllIIIIlllIIlIIIllIl = (short)lllllllllllllllIIIIlllIIlIIIlllI.length, lllllllllllllllIIIIlllIIlIIIllII = '\0'; lllllllllllllllIIIIlllIIlIIIllII < lllllllllllllllIIIIlllIIlIIIllIl; ++lllllllllllllllIIIIlllIIlIIIllII) {
                        lllllllllllllllIIIIlllIIlIIlIIll = lllllllllllllllIIIIlllIIlIIIlllI[lllllllllllllllIIIIlllIIlIIIllII];
                        lllllllllllllllIIIIlllIIlIIlIIll.setBlockId(BlockRewriter.this.protocol.getMappingData().getNewBlockStateId(lllllllllllllllIIIIlllIIlIIlIIll.getBlockId()));
                    }
                });
            }
        });
    }
    
    public void registerAcknowledgePlayerDigging(final ClientboundPacketType lllllllllllllllllllIllIIllIllIII) {
        this.registerBlockChange(lllllllllllllllllllIllIIllIllIII);
    }
    
    public BlockRewriter(final Protocol lllllllllllllllllllIllIIllllIlIl, final Type<Position> lllllllllllllllllllIllIIllllIlll) {
        this.protocol = lllllllllllllllllllIllIIllllIlIl;
        this.positionType = lllllllllllllllllllIllIIllllIlll;
    }
    
    public void registerBlockAction(final ClientboundPacketType lllllllllllllllllllIllIIlllIlllI) {
        this.protocol.registerClientbound(lllllllllllllllllllIllIIlllIlllI, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(BlockRewriter.this.positionType);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                final int llllllllllllllllllIIIIlIlllllIIl;
                final int llllllllllllllllllIIIIlIlllllIII;
                this.handler(llllllllllllllllllIIIIlIllllIllI -> {
                    llllllllllllllllllIIIIlIlllllIIl = llllllllllllllllllIIIIlIllllIllI.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllllllIIIIlIlllllIII = BlockRewriter.this.protocol.getMappingData().getNewBlockId(llllllllllllllllllIIIIlIlllllIIl);
                    if (llllllllllllllllllIIIIlIlllllIII == -1) {
                        llllllllllllllllllIIIIlIllllIllI.cancel();
                    }
                    else {
                        llllllllllllllllllIIIIlIllllIllI.set(Type.VAR_INT, 0, llllllllllllllllllIIIIlIlllllIII);
                    }
                });
            }
        });
    }
    
    public void registerMultiBlockChange(final ClientboundPacketType lllllllllllllllllllIllIIlllIIlII) {
        this.protocol.registerClientbound(lllllllllllllllllllIllIIlllIIlII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                final char lllllllllllllllIlllIlIlllIIllIlI;
                boolean lllllllllllllllIlllIlIlllIIllIIl;
                int lllllllllllllllIlllIlIlllIIllIII;
                BlockChangeRecord lllllllllllllllIlllIlIlllIIlllll;
                this.handler(lllllllllllllllIlllIlIlllIIllIll -> {
                    lllllllllllllllIlllIlIlllIIllIlI = lllllllllllllllIlllIlIlllIIllIll.passthrough((Type<Character>)Type.BLOCK_CHANGE_RECORD_ARRAY);
                    for (lllllllllllllllIlllIlIlllIIllIIl = (lllllllllllllllIlllIlIlllIIllIlI.length != 0), lllllllllllllllIlllIlIlllIIllIII = 0; lllllllllllllllIlllIlIlllIIllIII < (lllllllllllllllIlllIlIlllIIllIIl ? 1 : 0); ++lllllllllllllllIlllIlIlllIIllIII) {
                        lllllllllllllllIlllIlIlllIIlllll = lllllllllllllllIlllIlIlllIIllIlI[lllllllllllllllIlllIlIlllIIllIII];
                        lllllllllllllllIlllIlIlllIIlllll.setBlockId(BlockRewriter.this.protocol.getMappingData().getNewBlockStateId(lllllllllllllllIlllIlIlllIIlllll.getBlockId()));
                    }
                });
            }
        });
    }
}
