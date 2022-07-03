package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;

public class StatisticsRewriter
{
    private final /* synthetic */ Protocol protocol;
    
    public RegistryType getRegistryTypeForStatistic(final int llllllllllllllllIllllIlIIlllIlll) {
        switch (llllllllllllllllIllllIlIIlllIlll) {
            case 0: {
                return RegistryType.BLOCK;
            }
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                return RegistryType.ITEM;
            }
            case 6:
            case 7: {
                return RegistryType.ENTITY;
            }
            default: {
                return null;
            }
        }
    }
    
    public void register(final ClientboundPacketType llllllllllllllllIllllIlIlIIIIIll) {
        this.protocol.registerClientbound(llllllllllllllllIllllIlIlIIIIIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                int lllllllllllllIlIlIlIIIIllIIIlIll;
                int lllllllllllllIlIlIlIIIIllIIIllII;
                int lllllllllllllIlIlIlIIIIllIIIllll;
                int lllllllllllllIlIlIlIIIIllIIlIIlI;
                int lllllllllllllIlIlIlIIIIllIIlIIIl;
                int lllllllllllllIlIlIlIIIIllIIlIIII;
                RegistryType lllllllllllllIlIlIlIIIIllIIlIlII;
                IdRewriteFunction lllllllllllllIlIlIlIIIIllIIlIIll;
                this.handler(lllllllllllllIlIlIlIIIIllIIIlIIl -> {
                    for (lllllllllllllIlIlIlIIIIllIIIllII = (lllllllllllllIlIlIlIIIIllIIIlIll = lllllllllllllIlIlIlIIIIllIIIlIIl.passthrough((Type<Integer>)Type.VAR_INT)), lllllllllllllIlIlIlIIIIllIIIllll = 0; lllllllllllllIlIlIlIIIIllIIIllll < lllllllllllllIlIlIlIIIIllIIIllII; ++lllllllllllllIlIlIlIIIIllIIIllll) {
                        lllllllllllllIlIlIlIIIIllIIlIIlI = lllllllllllllIlIlIlIIIIllIIIlIIl.read((Type<Integer>)Type.VAR_INT);
                        lllllllllllllIlIlIlIIIIllIIlIIIl = lllllllllllllIlIlIlIIIIllIIIlIIl.read((Type<Integer>)Type.VAR_INT);
                        lllllllllllllIlIlIlIIIIllIIlIIII = lllllllllllllIlIlIlIIIIllIIIlIIl.read((Type<Integer>)Type.VAR_INT);
                        if (lllllllllllllIlIlIlIIIIllIIlIIlI == 8 && StatisticsRewriter.this.protocol.getMappingData().getStatisticsMappings() != null) {
                            lllllllllllllIlIlIlIIIIllIIlIIIl = StatisticsRewriter.this.protocol.getMappingData().getStatisticsMappings().getNewId(lllllllllllllIlIlIlIIIIllIIlIIIl);
                            if (lllllllllllllIlIlIlIIIIllIIlIIIl == -1) {
                                --lllllllllllllIlIlIlIIIIllIIIlIll;
                                continue;
                            }
                        }
                        else {
                            lllllllllllllIlIlIlIIIIllIIlIlII = StatisticsRewriter.this.getRegistryTypeForStatistic(lllllllllllllIlIlIlIIIIllIIlIIlI);
                            if (lllllllllllllIlIlIlIIIIllIIlIlII != null && (lllllllllllllIlIlIlIIIIllIIlIIll = StatisticsRewriter.this.getRewriter(lllllllllllllIlIlIlIIIIllIIlIlII)) != null) {
                                lllllllllllllIlIlIlIIIIllIIlIIIl = lllllllllllllIlIlIlIIIIllIIlIIll.rewrite(lllllllllllllIlIlIlIIIIllIIlIIIl);
                            }
                        }
                        lllllllllllllIlIlIlIIIIllIIIlIIl.write(Type.VAR_INT, lllllllllllllIlIlIlIIIIllIIlIIlI);
                        lllllllllllllIlIlIlIIIIllIIIlIIl.write(Type.VAR_INT, lllllllllllllIlIlIlIIIIllIIlIIIl);
                        lllllllllllllIlIlIlIIIIllIIIlIIl.write(Type.VAR_INT, lllllllllllllIlIlIlIIIIllIIlIIII);
                    }
                    if (lllllllllllllIlIlIlIIIIllIIIlIll != lllllllllllllIlIlIlIIIIllIIIllII) {
                        lllllllllllllIlIlIlIIIIllIIIlIIl.set(Type.VAR_INT, 0, lllllllllllllIlIlIlIIIIllIIIlIll);
                    }
                });
            }
        });
    }
    
    public StatisticsRewriter(final Protocol llllllllllllllllIllllIlIlIIIlIIl) {
        this.protocol = llllllllllllllllIllllIlIlIIIlIIl;
    }
    
    protected IdRewriteFunction getRewriter(final RegistryType llllllllllllllllIllllIlIIlllllIl) {
        switch (llllllllllllllllIllllIlIIlllllIl) {
            case BLOCK: {
                return (this.protocol.getMappingData().getBlockMappings() != null) ? (llllllllllllllllIllllIlIIllIIlll -> this.protocol.getMappingData().getNewBlockId(llllllllllllllllIllllIlIIllIIlll)) : null;
            }
            case ITEM: {
                return (this.protocol.getMappingData().getItemMappings() != null) ? (llllllllllllllllIllllIlIIllIllIl -> this.protocol.getMappingData().getNewItemId(llllllllllllllllIllllIlIIllIllIl)) : null;
            }
            case ENTITY: {
                return (this.protocol.getEntityRewriter() != null) ? (llllllllllllllllIllllIlIIlllIIIl -> this.protocol.getEntityRewriter().newEntityId(llllllllllllllllIllllIlIIlllIIIl)) : null;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Unknown registry type in statistics packet: ").append(llllllllllllllllIllllIlIIlllllIl)));
            }
        }
    }
}
