package com.viaversion.viabackwards.protocol.protocol1_16_3to1_16_4;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viabackwards.protocol.protocol1_16_3to1_16_4.storage.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_16_3To1_16_4 extends BackwardsProtocol<ClientboundPackets1_16_2, ClientboundPackets1_16_2, ServerboundPackets1_16_2, ServerboundPackets1_16_2>
{
    public Protocol1_16_3To1_16_4() {
        super(ClientboundPackets1_16_2.class, ClientboundPackets1_16_2.class, ServerboundPackets1_16_2.class, ServerboundPackets1_16_2.class);
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this).registerServerbound(ServerboundPackets1_16_2.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLAT_VAR_INT_ITEM);
                this.map(Type.BOOLEAN);
                final int lllllllllllllIIIIIIlIIIIIllIllII;
                this.handler(lllllllllllllIIIIIIlIIIIIllIlIll -> {
                    lllllllllllllIIIIIIlIIIIIllIllII = lllllllllllllIIIIIIlIIIIIllIlIll.read((Type<Integer>)Type.VAR_INT);
                    if (lllllllllllllIIIIIIlIIIIIllIllII == 1) {
                        lllllllllllllIIIIIIlIIIIIllIlIll.write(Type.VAR_INT, 40);
                    }
                    else {
                        lllllllllllllIIIIIIlIIIIIllIlIll.write(Type.VAR_INT, lllllllllllllIIIIIIlIIIIIllIlIll.user().get(PlayerHandStorage.class).getCurrentHand());
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this).registerServerbound(ServerboundPackets1_16_2.HELD_ITEM_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lllllllllllllIlIlIIIlIllllIIlIll;
                this.handler(lllllllllllllIlIlIIIlIllllIIllII -> {
                    lllllllllllllIlIlIIIlIllllIIlIll = lllllllllllllIlIlIIIlIllllIIllII.passthrough((Type<Short>)Type.SHORT);
                    lllllllllllllIlIlIIIlIllllIIllII.user().get(PlayerHandStorage.class).setCurrentHand(lllllllllllllIlIlIIIlIllllIIlIll);
                });
            }
        });
    }
    
    @Override
    public void init(final UserConnection llllllllllllllIlIlIIIlllllIIlllI) {
        llllllllllllllIlIlIIIlllllIIlllI.put(new PlayerHandStorage());
    }
}
