package com.viaversion.viabackwards.protocol.protocol1_14_3to1_14_4;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_14_3To1_14_4 extends BackwardsProtocol<ClientboundPackets1_14, ClientboundPackets1_14, ServerboundPackets1_14, ServerboundPackets1_14>
{
    public Protocol1_14_3To1_14_4() {
        super(ClientboundPackets1_14.class, ClientboundPackets1_14.class, ServerboundPackets1_14.class, ServerboundPackets1_14.class);
    }
    
    @Override
    protected void registerPackets() {
        ((Protocol<ClientboundPackets1_14, ClientboundPackets1_14, S1, S2>)this).registerClientbound(ClientboundPackets1_14.ACKNOWLEDGE_PLAYER_DIGGING, ClientboundPackets1_14.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14);
                this.map(Type.VAR_INT);
                final int lllllllllllllllIllIIIIIIIIlIlIII;
                final boolean lllllllllllllllIllIIIIIIIIlIIlll;
                this.handler(lllllllllllllllIllIIIIIIIIlIlIIl -> {
                    lllllllllllllllIllIIIIIIIIlIlIII = lllllllllllllllIllIIIIIIIIlIlIIl.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllllIllIIIIIIIIlIIlll = lllllllllllllllIllIIIIIIIIlIlIIl.read((Type<Boolean>)Type.BOOLEAN);
                    if (lllllllllllllllIllIIIIIIIIlIIlll && lllllllllllllllIllIIIIIIIIlIlIII == 0) {
                        lllllllllllllllIllIIIIIIIIlIlIIl.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_14.TRADE_LIST, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIllllIlllIlllll) throws Exception {
                        lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Object>)Type.VAR_INT);
                        for (int lllllllllllllIIIIIllllIlllIllllI = lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIIIIIllllIllllIIIIl = 0; lllllllllllllIIIIIllllIllllIIIIl < lllllllllllllIIIIIllllIlllIllllI; ++lllllllllllllIIIIIllllIllllIIIIl) {
                            lllllllllllllIIIIIllllIlllIlllll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            lllllllllllllIIIIIllllIlllIlllll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            if (lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                lllllllllllllIIIIIllllIlllIlllll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            }
                            lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIIIIIllllIlllIlllll.passthrough((Type<Object>)Type.FLOAT);
                            lllllllllllllIIIIIllllIlllIlllll.read((Type<Object>)Type.INT);
                        }
                    }
                });
            }
        });
    }
}
