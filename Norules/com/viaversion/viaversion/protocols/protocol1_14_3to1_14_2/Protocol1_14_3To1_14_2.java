package com.viaversion.viaversion.protocols.protocol1_14_3to1_14_2;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public class Protocol1_14_3To1_14_2 extends AbstractProtocol<ClientboundPackets1_14, ClientboundPackets1_14, ServerboundPackets1_14, ServerboundPackets1_14>
{
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_14.TRADE_LIST, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlllIllIlllllIIll) throws Exception {
                        lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.VAR_INT);
                        for (int lllllllllllllIIIlllIllIlllllIIlI = lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIIIlllIllIlllllIlIl = 0; lllllllllllllIIIlllIllIlllllIlIl < lllllllllllllIIIlllIllIlllllIIlI; ++lllllllllllllIIIlllIllIlllllIlIl) {
                            lllllllllllllIIIlllIllIlllllIIll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            lllllllllllllIIIlllIllIlllllIIll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            if (lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                lllllllllllllIIIlllIllIlllllIIll.passthrough(Type.FLAT_VAR_INT_ITEM);
                            }
                            lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.BOOLEAN);
                            lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.INT);
                            lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.FLOAT);
                        }
                        lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.VAR_INT);
                        lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Object>)Type.VAR_INT);
                        final boolean lllllllllllllIIIlllIllIlllllIIIl = lllllllllllllIIIlllIllIlllllIIll.passthrough((Type<Boolean>)Type.BOOLEAN);
                        lllllllllllllIIIlllIllIlllllIIll.write(Type.BOOLEAN, lllllllllllllIIIlllIllIlllllIIIl);
                    }
                });
            }
        });
    }
    
    public Protocol1_14_3To1_14_2() {
        super(ClientboundPackets1_14.class, ClientboundPackets1_14.class, null, null);
    }
}
