package com.viaversion.viabackwards.protocol.protocol1_12_1to1_12_2;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_12_1To1_12_2 extends BackwardsProtocol<ClientboundPackets1_12_1, ClientboundPackets1_12_1, ServerboundPackets1_12_1, ServerboundPackets1_12_1>
{
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12_1.KEEP_ALIVE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIIIlllIIIIlIIlIl) throws Exception {
                        final Long lllllllllllllIIlIIIlllIIIIlIIlII = lllllllllllllIIlIIIlllIIIIlIIlIl.read((Type<Long>)Type.LONG);
                        lllllllllllllIIlIIIlllIIIIlIIlIl.user().get(KeepAliveTracker.class).setKeepAlive(lllllllllllllIIlIIIlllIIIIlIIlII);
                        lllllllllllllIIlIIIlllIIIIlIIlIl.write(Type.VAR_INT, lllllllllllllIIlIIIlllIIIIlIIlII.hashCode());
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12_1>)this).registerServerbound(ServerboundPackets1_12_1.KEEP_ALIVE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllIIlIlIIllIIIll) throws Exception {
                        final int lllllllllllllIIIllIIlIlIIllIIlIl = lllllllllllllIIIllIIlIlIIllIIIll.read((Type<Integer>)Type.VAR_INT);
                        final long lllllllllllllIIIllIIlIlIIllIIlII = lllllllllllllIIIllIIlIlIIllIIIll.user().get(KeepAliveTracker.class).getKeepAlive();
                        if (lllllllllllllIIIllIIlIlIIllIIlIl != Long.hashCode(lllllllllllllIIIllIIlIlIIllIIlII)) {
                            lllllllllllllIIIllIIlIlIIllIIIll.cancel();
                            return;
                        }
                        lllllllllllllIIIllIIlIlIIllIIIll.write(Type.LONG, lllllllllllllIIIllIIlIlIIllIIlII);
                        lllllllllllllIIIllIIlIlIIllIIIll.user().get(KeepAliveTracker.class).setKeepAlive(2147483647L);
                    }
                });
            }
        });
    }
    
    @Override
    public void init(final UserConnection llllllllllllllIlllIllllIllIlllIl) {
        llllllllllllllIlllIllllIllIlllIl.put(new KeepAliveTracker());
    }
    
    public Protocol1_12_1To1_12_2() {
        super(ClientboundPackets1_12_1.class, ClientboundPackets1_12_1.class, ServerboundPackets1_12_1.class, ServerboundPackets1_12_1.class);
    }
}
