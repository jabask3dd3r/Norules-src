package com.viaversion.viaversion.protocols.protocol1_16_4to1_16_3;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;

public class Protocol1_16_4To1_16_3 extends AbstractProtocol<ClientboundPackets1_16_2, ClientboundPackets1_16_2, ServerboundPackets1_16_2, ServerboundPackets1_16_2>
{
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this).registerServerbound(ServerboundPackets1_16_2.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLAT_VAR_INT_ITEM);
                this.map(Type.BOOLEAN);
                final int llIlIIlIllllIl;
                this.handler(llIlIIlIlllllI -> {
                    llIlIIlIllllIl = llIlIIlIlllllI.read((Type<Integer>)Type.VAR_INT);
                    llIlIIlIlllllI.write(Type.VAR_INT, (llIlIIlIllllIl == 40) ? 1 : 0);
                });
            }
        });
    }
    
    public Protocol1_16_4To1_16_3() {
        super(ClientboundPackets1_16_2.class, ClientboundPackets1_16_2.class, ServerboundPackets1_16_2.class, ServerboundPackets1_16_2.class);
    }
}
