package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public final class MapColorRewriter
{
    public static PacketHandler getRewriteHandler(final IdRewriteFunction lllllllllllllIIIIlIIIlIlllllIlll) {
        int lllllllllllllIIIIlIIIlIllllIIlll;
        int lllllllllllllIIIIlIIIlIllllIllIl;
        final short lllllllllllllIIIIlIIIlIllllIIllI;
        byte[] lllllllllllllIIIIlIIIlIllllIIlIl;
        int lllllllllllllIIIIlIIIlIllllIlIlI;
        int lllllllllllllIIIIlIIIlIllllIllII;
        int lllllllllllllIIIIlIIIlIllllIlIll;
        return lllllllllllllIIIIlIIIlIllllIlIII -> {
            for (lllllllllllllIIIIlIIIlIllllIIlll = lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIIIlIIIlIllllIllIl = 0; lllllllllllllIIIIlIIIlIllllIllIl < lllllllllllllIIIIlIIIlIllllIIlll; ++lllllllllllllIIIIlIIIlIllllIllIl) {
                lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Object>)Type.VAR_INT);
                lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Object>)Type.BYTE);
                lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Object>)Type.BYTE);
                lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Object>)Type.BYTE);
                if (lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                    lllllllllllllIIIIlIIIlIllllIlIII.passthrough(Type.COMPONENT);
                }
            }
            lllllllllllllIIIIlIIIlIllllIIllI = lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
            if (lllllllllllllIIIIlIIIlIllllIIllI >= 1) {
                lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                lllllllllllllIIIIlIIIlIllllIlIII.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                for (lllllllllllllIIIIlIIIlIllllIIlIl = lllllllllllllIIIIlIIIlIllllIlIII.passthrough(Type.BYTE_ARRAY_PRIMITIVE), lllllllllllllIIIIlIIIlIllllIlIlI = 0; lllllllllllllIIIIlIIIlIllllIlIlI < lllllllllllllIIIIlIIIlIllllIIlIl.length; ++lllllllllllllIIIIlIIIlIllllIlIlI) {
                    lllllllllllllIIIIlIIIlIllllIllII = (lllllllllllllIIIIlIIIlIllllIIlIl[lllllllllllllIIIIlIIIlIllllIlIlI] & 0xFF);
                    lllllllllllllIIIIlIIIlIllllIlIll = lllllllllllllIIIIlIIIlIlllllIlll.rewrite(lllllllllllllIIIIlIIIlIllllIllII);
                    if (lllllllllllllIIIIlIIIlIllllIlIll != -1) {
                        lllllllllllllIIIIlIIIlIllllIIlIl[lllllllllllllIIIIlIIIlIllllIlIlI] = (byte)lllllllllllllIIIIlIIIlIllllIlIll;
                    }
                }
            }
        };
    }
}
