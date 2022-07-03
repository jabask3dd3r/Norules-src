package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;

public class ScoreboardPackets
{
    public static void register(final Protocol<ClientboundPackets1_9, ClientboundPackets1_8, ServerboundPackets1_9, ServerboundPackets1_8> lllllllllllllIlIIlIIllIllIIIIIIl) {
        lllllllllllllIlIIlIIllIllIIIIIIl.registerClientbound(ClientboundPackets1_9.TEAMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                final byte llllllllllllllIlIlIIIlIlIlIllIll;
                this.handler(llllllllllllllIlIlIIIlIlIlIlllII -> {
                    llllllllllllllIlIlIIIlIlIlIllIll = llllllllllllllIlIlIIIlIlIlIlllII.get((Type<Byte>)Type.BYTE, 0);
                    if (llllllllllllllIlIlIIIlIlIlIllIll == 0 || llllllllllllllIlIlIIIlIlIlIllIll == 2) {
                        llllllllllllllIlIlIIIlIlIlIlllII.passthrough(Type.STRING);
                        llllllllllllllIlIlIIIlIlIlIlllII.passthrough(Type.STRING);
                        llllllllllllllIlIlIIIlIlIlIlllII.passthrough(Type.STRING);
                        llllllllllllllIlIlIIIlIlIlIlllII.passthrough((Type<Object>)Type.BYTE);
                        llllllllllllllIlIlIIIlIlIlIlllII.passthrough(Type.STRING);
                        llllllllllllllIlIlIIIlIlIlIlllII.read(Type.STRING);
                        llllllllllllllIlIlIIIlIlIlIlllII.passthrough((Type<Object>)Type.BYTE);
                    }
                    if (llllllllllllllIlIlIIIlIlIlIllIll == 0 || llllllllllllllIlIlIIIlIlIlIllIll == 3 || llllllllllllllIlIlIIIlIlIlIllIll == 4) {
                        llllllllllllllIlIlIIIlIlIlIlllII.passthrough(Type.STRING_ARRAY);
                    }
                });
            }
        });
    }
}
