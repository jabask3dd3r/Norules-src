package com.viaversion.viaversion.protocols.protocol1_9to1_8;

import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.type.*;

public class PlayerMovementMapper implements PacketHandler
{
    @Override
    public void handle(final PacketWrapper lllllllllllllIIIIlIlllIIlIIIIlIl) throws Exception {
        final MovementTracker lllllllllllllIIIIlIlllIIlIIIIllI = lllllllllllllIIIIlIlllIIlIIIIlIl.user().get(MovementTracker.class);
        lllllllllllllIIIIlIlllIIlIIIIllI.incrementIdlePacket();
        if (lllllllllllllIIIIlIlllIIlIIIIlIl.is(Type.BOOLEAN, 0)) {
            lllllllllllllIIIIlIlllIIlIIIIllI.setGround(lllllllllllllIIIIlIlllIIlIIIIlIl.get((Type<Boolean>)Type.BOOLEAN, 0));
        }
    }
}
