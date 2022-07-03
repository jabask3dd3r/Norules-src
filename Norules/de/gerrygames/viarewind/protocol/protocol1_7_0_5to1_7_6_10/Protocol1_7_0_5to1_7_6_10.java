package de.gerrygames.viarewind.protocol.protocol1_7_0_5to1_7_6_10;

import com.viaversion.viaversion.api.protocol.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import java.util.stream.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;

public class Protocol1_7_0_5to1_7_6_10 extends AbstractProtocol<ClientboundPackets1_7, ClientboundPackets1_7, ServerboundPackets1_7, ServerboundPackets1_7>
{
    public static final /* synthetic */ ValueTransformer<String, String> REMOVE_DASHES;
    
    @Override
    protected void registerPackets() {
        this.registerClientbound(State.LOGIN, 2, 2, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING, Protocol1_7_0_5to1_7_6_10.REMOVE_DASHES);
                this.map(Type.STRING);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_7, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_7.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.STRING, Protocol1_7_0_5to1_7_6_10.REMOVE_DASHES);
                this.map(Type.STRING);
                int lIIIIIIIIlI;
                int lIIIIIIIlII;
                this.handler(lIIIIIIIIll -> {
                    for (lIIIIIIIIlI = lIIIIIIIIll.read((Type<Integer>)Type.VAR_INT), lIIIIIIIlII = 0; lIIIIIIIlII < lIIIIIIIIlI * 3; ++lIIIIIIIlII) {
                        lIIIIIIIIll.read(Type.STRING);
                    }
                    return;
                });
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Types1_7_6_10.METADATA_LIST);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_7, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_7.TEAMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                final byte lllllllllllllllIlIlllllllllllIll;
                ArrayList<String> lllllllllllllllIlIlllllllllllllI;
                int lllllllllllllllIlIllllllllllllIl;
                int lllllllllllllllIllIIIIIIIIIIIIII;
                List<String> lllllllllllllllIlIlllllllllllllI2;
                final Iterator<String> iterator;
                String lllllllllllllllIlIllllllllllllll;
                this.handler(lllllllllllllllIlIllllllllllllII -> {
                    lllllllllllllllIlIlllllllllllIll = lllllllllllllllIlIllllllllllllII.get((Type<Byte>)Type.BYTE, 0);
                    if (lllllllllllllllIlIlllllllllllIll == 0 || lllllllllllllllIlIlllllllllllIll == 2) {
                        lllllllllllllllIlIllllllllllllII.passthrough(Type.STRING);
                        lllllllllllllllIlIllllllllllllII.passthrough(Type.STRING);
                        lllllllllllllllIlIllllllllllllII.passthrough(Type.STRING);
                        lllllllllllllllIlIllllllllllllII.passthrough((Type<Object>)Type.BYTE);
                    }
                    if (lllllllllllllllIlIlllllllllllIll == 0 || lllllllllllllllIlIlllllllllllIll == 3 || lllllllllllllllIlIlllllllllllIll == 4) {
                        lllllllllllllllIlIlllllllllllllI = new ArrayList<String>();
                        for (lllllllllllllllIlIllllllllllllIl = lllllllllllllllIlIllllllllllllII.read((Type<Short>)Type.SHORT), lllllllllllllllIllIIIIIIIIIIIIII = 0; lllllllllllllllIllIIIIIIIIIIIIII < lllllllllllllllIlIllllllllllllIl; ++lllllllllllllllIllIIIIIIIIIIIIII) {
                            lllllllllllllllIlIlllllllllllllI.add(lllllllllllllllIlIllllllllllllII.read(Type.STRING));
                        }
                        lllllllllllllllIlIlllllllllllllI2 = lllllllllllllllIlIlllllllllllllI.stream().map(lllllllllllllllIlIllllllllllIIll -> (lllllllllllllllIlIllllllllllIIll.length() > 16) ? lllllllllllllllIlIllllllllllIIll.substring(0, 16) : lllllllllllllllIlIllllllllllIIll).distinct().collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
                        lllllllllllllllIlIllllllllllllII.write(Type.SHORT, (short)lllllllllllllllIlIlllllllllllllI2.size());
                        lllllllllllllllIlIlllllllllllllI2.iterator();
                        while (iterator.hasNext()) {
                            lllllllllllllllIlIllllllllllllll = iterator.next();
                            lllllllllllllllIlIllllllllllllII.write(Type.STRING, lllllllllllllllIlIllllllllllllll);
                        }
                    }
                });
            }
        });
    }
    
    @Override
    public void init(final UserConnection llllllllllllllIlllIIllIlIIlllIlI) {
    }
    
    public Protocol1_7_0_5to1_7_6_10() {
        super(ClientboundPackets1_7.class, ClientboundPackets1_7.class, ServerboundPackets1_7.class, ServerboundPackets1_7.class);
    }
    
    static {
        REMOVE_DASHES = new ValueTransformer<String, String>() {
            @Override
            public String transform(final PacketWrapper lllllllllllllIIlIIllIlIIIIlllIII, final String lllllllllllllIIlIIllIlIIIIllIlll) {
                return lllllllllllllIIlIIllIlIIIIllIlll.replace("-", "");
            }
        };
    }
}
