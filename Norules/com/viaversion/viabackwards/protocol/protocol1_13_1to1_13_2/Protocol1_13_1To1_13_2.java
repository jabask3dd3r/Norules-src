package com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2.packets.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_13_1To1_13_2 extends BackwardsProtocol<ClientboundPackets1_13, ClientboundPackets1_13, ServerboundPackets1_13, ServerboundPackets1_13>
{
    public Protocol1_13_1To1_13_2() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_13.class, ServerboundPackets1_13.class, ServerboundPackets1_13.class);
    }
    
    @Override
    protected void registerPackets() {
        InventoryPackets1_13_2.register(this);
        WorldPackets1_13_2.register(this);
        EntityPackets1_13_2.register(this);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLAT_ITEM, Type.FLAT_VAR_INT_ITEM);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_13.ADVANCEMENTS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIIIlIlllllIlIlII) throws Exception {
                        lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Object>)Type.BOOLEAN);
                        for (int lllllllllllllIIlIIIlIlllllIlIIll = lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIlIIIlIlllllIlIllI = 0; lllllllllllllIIlIIIlIlllllIlIllI < lllllllllllllIIlIIIlIlllllIlIIll; ++lllllllllllllIIlIIIlIlllllIlIllI) {
                            lllllllllllllIIlIIIlIlllllIlIlII.passthrough(Type.STRING);
                            if (lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                lllllllllllllIIlIIIlIlllllIlIlII.passthrough(Type.STRING);
                            }
                            if (lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                lllllllllllllIIlIIIlIlllllIlIlII.passthrough(Type.COMPONENT);
                                lllllllllllllIIlIIIlIlllllIlIlII.passthrough(Type.COMPONENT);
                                final Item lllllllllllllIIlIIIlIlllllIlllII = lllllllllllllIIlIIIlIlllllIlIlII.read(Type.FLAT_VAR_INT_ITEM);
                                lllllllllllllIIlIIIlIlllllIlIlII.write(Type.FLAT_ITEM, lllllllllllllIIlIIIlIlllllIlllII);
                                lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Object>)Type.VAR_INT);
                                final int lllllllllllllIIlIIIlIlllllIllIll = lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Integer>)Type.INT);
                                if ((lllllllllllllIIlIIIlIlllllIllIll & 0x1) != 0x0) {
                                    lllllllllllllIIlIIIlIlllllIlIlII.passthrough(Type.STRING);
                                }
                                lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Object>)Type.FLOAT);
                                lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Object>)Type.FLOAT);
                            }
                            lllllllllllllIIlIIIlIlllllIlIlII.passthrough(Type.STRING_ARRAY);
                            for (int lllllllllllllIIlIIIlIlllllIlIlll = lllllllllllllIIlIIIlIlllllIlIlII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIlIIIlIlllllIllIIl = 0; lllllllllllllIIlIIIlIlllllIllIIl < lllllllllllllIIlIIIlIlllllIlIlll; ++lllllllllllllIIlIIIlIlllllIllIIl) {
                                lllllllllllllIIlIIIlIlllllIlIlII.passthrough(Type.STRING_ARRAY);
                            }
                        }
                    }
                });
            }
        });
    }
}
