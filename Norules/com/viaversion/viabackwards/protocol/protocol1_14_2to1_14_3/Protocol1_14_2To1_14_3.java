package com.viaversion.viabackwards.protocol.protocol1_14_2to1_14_3;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_14_2To1_14_3 extends BackwardsProtocol<ClientboundPackets1_14, ClientboundPackets1_14, ServerboundPackets1_14, ServerboundPackets1_14>
{
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_14.TRADE_LIST, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIllIIlIlIIIIllll) throws Exception {
                        lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.VAR_INT);
                        for (int lllllllllllllIlIIllIIlIlIIIIlllI = lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIlIIllIIlIlIIIlIIIl = 0; lllllllllllllIlIIllIIlIlIIIlIIIl < lllllllllllllIlIIllIIlIlIIIIlllI; ++lllllllllllllIlIIllIIlIlIIIlIIIl) {
                            lllllllllllllIlIIllIIlIlIIIIllll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            lllllllllllllIlIIllIIlIlIIIIllll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            if (lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                lllllllllllllIlIIllIIlIlIIIIllll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            }
                            lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.FLOAT);
                        }
                        lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.VAR_INT);
                        lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.VAR_INT);
                        lllllllllllllIlIIllIIlIlIIIIllll.passthrough((Type<Object>)Type.BOOLEAN);
                        lllllllllllllIlIIllIIlIlIIIIllll.read((Type<Object>)Type.BOOLEAN);
                    }
                });
            }
        });
        final RecipeRewriter llIllIlllllIIl = new RecipeRewriter1_14(this);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_14.DECLARE_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                final RecipeRewriter val$recipeHandler;
                final int lllllllllllllIIllIIIIlIIIllIllIl;
                int lllllllllllllIIllIIIIlIIIllIllII;
                int lllllllllllllIIllIIIIlIIIlllIIII;
                String lllllllllllllIIllIIIIlIIIlllIIll;
                String lllllllllllllIIllIIIIlIIIlllIIlI;
                String lllllllllllllIIllIIIIlIIIlllIIIl;
                this.handler(lllllllllllllIIllIIIIlIIIllIlllI -> {
                    val$recipeHandler = llIllIlllllIIl;
                    lllllllllllllIIllIIIIlIIIllIllIl = lllllllllllllIIllIIIIlIIIllIlllI.passthrough((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIllIIIIlIIIllIllII = 0;
                    for (lllllllllllllIIllIIIIlIIIlllIIII = 0; lllllllllllllIIllIIIIlIIIlllIIII < lllllllllllllIIllIIIIlIIIllIllIl; ++lllllllllllllIIllIIIIlIIIlllIIII) {
                        lllllllllllllIIllIIIIlIIIlllIIll = lllllllllllllIIllIIIIlIIIllIlllI.read(Type.STRING);
                        lllllllllllllIIllIIIIlIIIlllIIlI = lllllllllllllIIllIIIIlIIIlllIIll.replace("minecraft:", "");
                        lllllllllllllIIllIIIIlIIIlllIIIl = lllllllllllllIIllIIIIlIIIllIlllI.read(Type.STRING);
                        if (lllllllllllllIIllIIIIlIIIlllIIlI.equals("crafting_special_repairitem")) {
                            ++lllllllllllllIIllIIIIlIIIllIllII;
                        }
                        else {
                            lllllllllllllIIllIIIIlIIIllIlllI.write(Type.STRING, lllllllllllllIIllIIIIlIIIlllIIll);
                            lllllllllllllIIllIIIIlIIIllIlllI.write(Type.STRING, lllllllllllllIIllIIIIlIIIlllIIIl);
                            val$recipeHandler.handle(lllllllllllllIIllIIIIlIIIllIlllI, lllllllllllllIIllIIIIlIIIlllIIlI);
                        }
                    }
                    lllllllllllllIIllIIIIlIIIllIlllI.set(Type.VAR_INT, 0, lllllllllllllIIllIIIIlIIIllIllIl - lllllllllllllIIllIIIIlIIIllIllII);
                });
            }
        });
    }
    
    public Protocol1_14_2To1_14_3() {
        super(ClientboundPackets1_14.class, ClientboundPackets1_14.class, ServerboundPackets1_14.class, ServerboundPackets1_14.class);
    }
}
