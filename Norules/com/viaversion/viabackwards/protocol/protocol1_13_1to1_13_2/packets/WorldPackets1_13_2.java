package com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2.packets;

import com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.*;

public class WorldPackets1_13_2
{
    public static void register(final Protocol1_13_1To1_13_2 llllllllllllllllIIlIIIllIlIllIll) {
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllllllIIlIIIllIlIllIll).registerClientbound(ClientboundPackets1_13.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIIIIlIIIIlIlIIlI) throws Exception {
                        final int lllllllllllllIlIIIIIlIIIIlIlIIIl = lllllllllllllIlIIIIIlIIIIlIlIIlI.get((Type<Integer>)Type.INT, 0);
                        if (lllllllllllllIlIIIIIlIIIIlIlIIIl == 27) {
                            lllllllllllllIlIIIIIlIIIIlIlIIlI.write(Type.FLAT_ITEM, (Item)lllllllllllllIlIIIIIlIIIIlIlIIlI.read((Type<T>)Type.FLAT_VAR_INT_ITEM));
                        }
                    }
                });
            }
        });
    }
}
