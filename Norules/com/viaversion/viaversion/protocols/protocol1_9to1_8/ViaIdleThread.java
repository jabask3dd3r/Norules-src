package com.viaversion.viaversion.protocols.protocol1_9to1_8;

import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.api.connection.*;

public class ViaIdleThread implements Runnable
{
    @Override
    public void run() {
        for (final UserConnection llllllllllllIllllllIIIIIIlllllll : Via.getManager().getConnectionManager().getConnections()) {
            final ProtocolInfo llllllllllllIllllllIIIIIlIIIIIlI = llllllllllllIllllllIIIIIIlllllll.getProtocolInfo();
            if (llllllllllllIllllllIIIIIlIIIIIlI != null) {
                if (!llllllllllllIllllllIIIIIlIIIIIlI.getPipeline().contains(Protocol1_9To1_8.class)) {
                    continue;
                }
                final MovementTracker llllllllllllIllllllIIIIIlIIIIIIl = llllllllllllIllllllIIIIIIlllllll.get(MovementTracker.class);
                if (llllllllllllIllllllIIIIIlIIIIIIl == null) {
                    continue;
                }
                final long llllllllllllIllllllIIIIIlIIIIIII = llllllllllllIllllllIIIIIlIIIIIIl.getNextIdlePacket();
                if (llllllllllllIllllllIIIIIlIIIIIII > System.currentTimeMillis() || !llllllllllllIllllllIIIIIIlllllll.getChannel().isOpen()) {
                    continue;
                }
                Via.getManager().getProviders().get(MovementTransmitterProvider.class).sendPlayer(llllllllllllIllllllIIIIIIlllllll);
            }
        }
    }
}
