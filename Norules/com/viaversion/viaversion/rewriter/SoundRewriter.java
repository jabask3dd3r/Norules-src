package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;

public class SoundRewriter
{
    protected final /* synthetic */ Protocol protocol;
    protected final /* synthetic */ IdRewriteFunction idRewriter;
    
    public PacketHandler getSoundHandler() {
        final int llllllllllllllIIIlIllIlllllIIllI;
        final int llllllllllllllIIIlIllIlllllIIlIl;
        return llllllllllllllIIIlIllIlllllIIIll -> {
            llllllllllllllIIIlIllIlllllIIllI = llllllllllllllIIIlIllIlllllIIIll.get((Type<Integer>)Type.VAR_INT, 0);
            llllllllllllllIIIlIllIlllllIIlIl = this.idRewriter.rewrite(llllllllllllllIIIlIllIlllllIIllI);
            if (llllllllllllllIIIlIllIlllllIIlIl == -1) {
                llllllllllllllIIIlIllIlllllIIIll.cancel();
            }
            else if (llllllllllllllIIIlIllIlllllIIllI != llllllllllllllIIIlIllIlllllIIlIl) {
                llllllllllllllIIIlIllIlllllIIIll.set(Type.VAR_INT, 0, llllllllllllllIIIlIllIlllllIIlIl);
            }
        };
    }
    
    public void registerSound(final ClientboundPacketType llllllllllllllIIIlIllIllllllIIII) {
        this.protocol.registerClientbound(llllllllllllllIIIlIllIllllllIIII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(SoundRewriter.this.getSoundHandler());
            }
        });
    }
    
    public SoundRewriter(final Protocol llllllllllllllIIIlIllIllllllIlll, final IdRewriteFunction llllllllllllllIIIlIllIllllllIllI) {
        this.protocol = llllllllllllllIIIlIllIllllllIlll;
        this.idRewriter = llllllllllllllIIIlIllIllllllIllI;
    }
    
    public SoundRewriter(final Protocol llllllllllllllIIIlIllIllllllllll) {
        this.protocol = llllllllllllllIIIlIllIllllllllll;
        this.idRewriter = (llllllllllllllIIIlIllIllllIlllIl -> llllllllllllllIIIlIllIllllllllll.getMappingData().getSoundMappings().getNewId(llllllllllllllIIIlIllIllllIlllIl));
    }
}
