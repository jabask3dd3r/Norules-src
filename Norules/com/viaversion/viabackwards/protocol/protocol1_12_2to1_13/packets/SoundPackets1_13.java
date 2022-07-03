package com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.packets;

import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viabackwards.protocol.protocol1_12_2to1_13.data.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.api.protocol.*;

public class SoundPackets1_13 extends RewriterBase<Protocol1_12_2To1_13>
{
    private static final /* synthetic */ String[] SOUND_SOURCES;
    
    static {
        SOUND_SOURCES = new String[] { "master", "music", "record", "weather", "block", "hostile", "neutral", "player", "ambient", "voice" };
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.NAMED_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                final String llIlIIIIIIlIIlI;
                String llIlIIIIIIlIIIl;
                this.handler(llIlIIIIIIlIIll -> {
                    llIlIIIIIIlIIlI = llIlIIIIIIlIIll.get(Type.STRING, 0);
                    llIlIIIIIIlIIIl = NamedSoundMapping.getOldId(llIlIIIIIIlIIlI);
                    if (llIlIIIIIIlIIIl != null || (llIlIIIIIIlIIIl = ((Protocol1_12_2To1_13)SoundPackets1_13.this.protocol).getMappingData().getMappedNamedSound(llIlIIIIIIlIIlI)) != null) {
                        llIlIIIIIIlIIll.set(Type.STRING, 0, llIlIIIIIIlIIIl);
                    }
                    else if (!Via.getConfig().isSuppressConversionWarnings()) {
                        ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Unknown named sound in 1.13->1.12 protocol: ").append(llIlIIIIIIlIIlI)));
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_13, ClientboundPackets1_12_1, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.STOP_SOUND, ClientboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final byte llllllllllllllllIllllIIIIlIllIIl;
                String llllllllllllllllIllllIIIIlIllllI;
                String llllllllllllllllIllllIIIIlIllIII = null;
                String llllllllllllllllIllllIIIIlIlllIl;
                String llllllllllllllllIllllIIIIlIlllII;
                String llllllllllllllllIllllIIIIlIlllII2;
                String llllllllllllllllIllllIIIIlIlIlll;
                this.handler(llllllllllllllllIllllIIIIlIllIlI -> {
                    llllllllllllllllIllllIIIIlIllIlI.write(Type.STRING, "MC|StopSound");
                    llllllllllllllllIllllIIIIlIllIIl = llllllllllllllllIllllIIIIlIllIlI.read((Type<Byte>)Type.BYTE);
                    if ((llllllllllllllllIllllIIIIlIllIIl & 0x1) != 0x0) {
                        llllllllllllllllIllllIIIIlIllllI = SoundPackets1_13.SOUND_SOURCES[llllllllllllllllIllllIIIIlIllIlI.read((Type<Integer>)Type.VAR_INT)];
                    }
                    else {
                        llllllllllllllllIllllIIIIlIllIII = "";
                    }
                    if ((llllllllllllllllIllllIIIIlIllIIl & 0x2) != 0x0) {
                        llllllllllllllllIllllIIIIlIlllIl = llllllllllllllllIllllIIIIlIllIlI.read(Type.STRING);
                        llllllllllllllllIllllIIIIlIlllII = ((Protocol1_12_2To1_13)SoundPackets1_13.this.protocol).getMappingData().getMappedNamedSound(llllllllllllllllIllllIIIIlIlllIl);
                        if (llllllllllllllllIllllIIIIlIlllII == null) {
                            llllllllllllllllIllllIIIIlIlllII2 = "";
                        }
                    }
                    else {
                        llllllllllllllllIllllIIIIlIlIlll = "";
                    }
                    llllllllllllllllIllllIIIIlIllIlI.write(Type.STRING, llllllllllllllllIllllIIIIlIllIII);
                    llllllllllllllllIllllIIIIlIllIlI.write(Type.STRING, llllllllllllllllIllllIIIIlIlIlll);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final int llllllllllllllIlIIIllIllIIIlIIII;
                final int llllllllllllllIlIIIllIllIIIIllll;
                this.handler(llllllllllllllIlIIIllIllIIIIllIl -> {
                    llllllllllllllIlIIIllIllIIIlIIII = llllllllllllllIlIIIllIllIIIIllIl.get((Type<Integer>)Type.VAR_INT, 0);
                    llllllllllllllIlIIIllIllIIIIllll = ((Protocol1_12_2To1_13)SoundPackets1_13.this.protocol).getMappingData().getSoundMappings().getNewId(llllllllllllllIlIIIllIllIIIlIIII);
                    if (llllllllllllllIlIIIllIllIIIIllll == -1) {
                        llllllllllllllIlIIIllIllIIIIllIl.cancel();
                    }
                    else {
                        llllllllllllllIlIIIllIllIIIIllIl.set(Type.VAR_INT, 0, llllllllllllllIlIIIllIllIIIIllll);
                    }
                });
            }
        });
    }
    
    public SoundPackets1_13(final Protocol1_12_2To1_13 llIllIIllIlIll) {
        super(llIllIIllIlIll);
    }
}
