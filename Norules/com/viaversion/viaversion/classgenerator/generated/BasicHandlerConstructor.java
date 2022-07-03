package com.viaversion.viaversion.classgenerator.generated;

import com.viaversion.viaversion.api.connection.*;
import io.netty.handler.codec.*;
import com.viaversion.viaversion.bukkit.handlers.*;

public class BasicHandlerConstructor implements HandlerConstructor
{
    @Override
    public BukkitDecodeHandler newDecodeHandler(final UserConnection lllllllllllllIlIllllIIIIIlIlIIII, final ByteToMessageDecoder lllllllllllllIlIllllIIIIIlIIllIl) {
        return new BukkitDecodeHandler(lllllllllllllIlIllllIIIIIlIlIIII, lllllllllllllIlIllllIIIIIlIIllIl);
    }
    
    @Override
    public BukkitEncodeHandler newEncodeHandler(final UserConnection lllllllllllllIlIllllIIIIIlIlIlIl, final MessageToByteEncoder lllllllllllllIlIllllIIIIIlIlIlII) {
        return new BukkitEncodeHandler(lllllllllllllIlIllllIIIIIlIlIlIl, lllllllllllllIlIllllIIIIIlIlIlII);
    }
}
