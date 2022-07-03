package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;

public class SoundRewriter extends com.viaversion.viaversion.rewriter.SoundRewriter
{
    private final /* synthetic */ BackwardsProtocol protocol;
    
    public PacketHandler getNamedSoundHandler() {
        final String lllllllllllllIlIIIllIllllllllIIl;
        final String lllllllllllllIlIIIllIllllllllIII;
        return lllllllllllllIlIIIllIlllllllIllI -> {
            lllllllllllllIlIIIllIllllllllIIl = lllllllllllllIlIIIllIlllllllIllI.get(Type.STRING, 0);
            lllllllllllllIlIIIllIllllllllIII = this.protocol.getMappingData().getMappedNamedSound(lllllllllllllIlIIIllIllllllllIIl);
            if (lllllllllllllIlIIIllIllllllllIII != null) {
                if (!lllllllllllllIlIIIllIllllllllIII.isEmpty()) {
                    lllllllllllllIlIIIllIlllllllIllI.set(Type.STRING, 0, lllllllllllllIlIIIllIllllllllIII);
                }
                else {
                    lllllllllllllIlIIIllIlllllllIllI.cancel();
                }
            }
        };
    }
    
    public PacketHandler getStopSoundHandler() {
        final byte lllllllllllllIlIIIlllIIIIIIIIlll;
        String lllllllllllllIlIIIlllIIIIIIIIllI;
        String lllllllllllllIlIIIlllIIIIIIIIlIl;
        return lllllllllllllIlIIIlllIIIIIIIIIll -> {
            lllllllllllllIlIIIlllIIIIIIIIlll = lllllllllllllIlIIIlllIIIIIIIIIll.passthrough((Type<Byte>)Type.BYTE);
            if ((lllllllllllllIlIIIlllIIIIIIIIlll & 0x2) != 0x0) {
                if ((lllllllllllllIlIIIlllIIIIIIIIlll & 0x1) != 0x0) {
                    lllllllllllllIlIIIlllIIIIIIIIIll.passthrough((Type<Object>)Type.VAR_INT);
                }
                lllllllllllllIlIIIlllIIIIIIIIllI = lllllllllllllIlIIIlllIIIIIIIIIll.read(Type.STRING);
                lllllllllllllIlIIIlllIIIIIIIIlIl = this.protocol.getMappingData().getMappedNamedSound(lllllllllllllIlIIIlllIIIIIIIIllI);
                if (lllllllllllllIlIIIlllIIIIIIIIlIl == null) {
                    lllllllllllllIlIIIlllIIIIIIIIIll.write(Type.STRING, lllllllllllllIlIIIlllIIIIIIIIllI);
                }
                else if (!lllllllllllllIlIIIlllIIIIIIIIlIl.isEmpty()) {
                    lllllllllllllIlIIIlllIIIIIIIIIll.write(Type.STRING, lllllllllllllIlIIIlllIIIIIIIIlIl);
                }
                else {
                    lllllllllllllIlIIIlllIIIIIIIIIll.cancel();
                }
            }
        };
    }
    
    public SoundRewriter(final BackwardsProtocol lllllllllllllIlIIIlllIIIIIlIIIll) {
        super(lllllllllllllIlIIIlllIIIIIlIIIll);
        this.protocol = lllllllllllllIlIIIlllIIIIIlIIIll;
    }
    
    public void registerStopSound(final ClientboundPacketType lllllllllllllIlIIIlllIIIIIIlIlll) {
        this.protocol.registerClientbound(lllllllllllllIlIIIlllIIIIIIlIlll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(SoundRewriter.this.getStopSoundHandler());
            }
        });
    }
    
    public void registerNamedSound(final ClientboundPacketType lllllllllllllIlIIIlllIIIIIIllIll) {
        this.protocol.registerClientbound(lllllllllllllIlIIIlllIIIIIIllIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(SoundRewriter.this.getNamedSoundHandler());
            }
        });
    }
}
