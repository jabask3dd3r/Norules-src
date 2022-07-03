package com.viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public class WorldPackets
{
    public static void register(final Protocol lllllllllllllIIIIIIllllIIlIIllIl) {
        lllllllllllllIIIIIIllllIIlIIllIl.registerClientbound(ClientboundPackets1_13.SPAWN_PARTICLE, new PacketRemapper() {
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
                    public void handle(final PacketWrapper lllllllllllllIllllIllllIIllIlIII) throws Exception {
                        final int lllllllllllllIllllIllllIIllIIlll = lllllllllllllIllllIllllIIllIlIII.get((Type<Integer>)Type.INT, 0);
                        if (lllllllllllllIllllIllllIIllIIlll == 27) {
                            lllllllllllllIllllIllllIIllIlIII.write(Type.FLAT_VAR_INT_ITEM, (Item)lllllllllllllIllllIllllIIllIlIII.read((Type<T>)Type.FLAT_ITEM));
                        }
                    }
                });
            }
        });
    }
}
