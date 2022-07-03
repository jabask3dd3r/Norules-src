package de.gerrygames.viarewind.protocol.protocol1_7_6to1_7_2;

import com.viaversion.viaversion.api.protocol.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;

public class Protocol1_7_6to1_7_2 extends AbstractProtocol<ClientboundPackets1_7, ClientboundPackets1_7, ServerboundPackets1_7, ServerboundPackets1_7>
{
    public static /* synthetic */ ValueTransformer<String, String> INSERT_DASHES;
    
    static {
        Protocol1_7_6to1_7_2.INSERT_DASHES = new ValueTransformer<String, String>() {
            @Override
            public String transform(final PacketWrapper lllllllllllllIlIIIIllIIIlIlIllII, final String lllllllllllllIlIIIIllIIIlIlIlIll) throws Exception {
                final StringBuilder lllllllllllllIlIIIIllIIIlIlIlIlI = new StringBuilder(lllllllllllllIlIIIIllIIIlIlIlIll);
                lllllllllllllIlIIIIllIIIlIlIlIlI.insert(20, "-");
                lllllllllllllIlIIIIllIIIlIlIlIlI.insert(16, "-");
                lllllllllllllIlIIIIllIIIlIlIlIlI.insert(12, "-");
                lllllllllllllIlIIIIllIIIlIlIlIlI.insert(8, "-");
                return String.valueOf(lllllllllllllIlIIIIllIIIlIlIlIlI);
            }
        };
    }
    
    @Override
    protected void registerPackets() {
        this.registerClientbound(State.LOGIN, 2, 2, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING, Protocol1_7_6to1_7_2.INSERT_DASHES);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_7, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_7.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.STRING, Protocol1_7_6to1_7_2.INSERT_DASHES);
                this.map(Type.STRING);
                this.create(Type.VAR_INT, 0);
            }
        });
    }
    
    public Protocol1_7_6to1_7_2() {
        super(ClientboundPackets1_7.class, ClientboundPackets1_7.class, ServerboundPackets1_7.class, ServerboundPackets1_7.class);
    }
}
