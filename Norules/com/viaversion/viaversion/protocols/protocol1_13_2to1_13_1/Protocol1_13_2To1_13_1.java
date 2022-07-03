package com.viaversion.viaversion.protocols.protocol1_13_2to1_13_1;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public class Protocol1_13_2To1_13_1 extends AbstractProtocol<ClientboundPackets1_13, ClientboundPackets1_13, ServerboundPackets1_13, ServerboundPackets1_13>
{
    public Protocol1_13_2To1_13_1() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_13.class, ServerboundPackets1_13.class, ServerboundPackets1_13.class);
    }
    
    @Override
    protected void registerPackets() {
        InventoryPackets.register(this);
        WorldPackets.register(this);
        EntityPackets.register(this);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLAT_VAR_INT_ITEM, Type.FLAT_ITEM);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_13.ADVANCEMENTS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lIIllllIlIllllI) throws Exception {
                        lIIllllIlIllllI.passthrough((Type<Object>)Type.BOOLEAN);
                        for (int lIIllllIlIlllIl = lIIllllIlIllllI.passthrough((Type<Integer>)Type.VAR_INT), lIIllllIllIIIII = 0; lIIllllIllIIIII < lIIllllIlIlllIl; ++lIIllllIllIIIII) {
                            lIIllllIlIllllI.passthrough(Type.STRING);
                            if (lIIllllIlIllllI.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                lIIllllIlIllllI.passthrough(Type.STRING);
                            }
                            if (lIIllllIlIllllI.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                lIIllllIlIllllI.passthrough(Type.COMPONENT);
                                lIIllllIlIllllI.passthrough(Type.COMPONENT);
                                final Item lIIllllIllIIlII = lIIllllIlIllllI.read(Type.FLAT_ITEM);
                                lIIllllIlIllllI.write(Type.FLAT_VAR_INT_ITEM, lIIllllIllIIlII);
                                lIIllllIlIllllI.passthrough((Type<Object>)Type.VAR_INT);
                                final int lIIllllIllIIIll = lIIllllIlIllllI.passthrough((Type<Integer>)Type.INT);
                                if ((lIIllllIllIIIll & 0x1) != 0x0) {
                                    lIIllllIlIllllI.passthrough(Type.STRING);
                                }
                                lIIllllIlIllllI.passthrough((Type<Object>)Type.FLOAT);
                                lIIllllIlIllllI.passthrough((Type<Object>)Type.FLOAT);
                            }
                            lIIllllIlIllllI.passthrough(Type.STRING_ARRAY);
                            for (int lIIllllIllIIIIl = lIIllllIlIllllI.passthrough((Type<Integer>)Type.VAR_INT), lIIllllIllIIIlI = 0; lIIllllIllIIIlI < lIIllllIllIIIIl; ++lIIllllIllIIIlI) {
                                lIIllllIlIllllI.passthrough(Type.STRING_ARRAY);
                            }
                        }
                    }
                });
            }
        });
    }
}
