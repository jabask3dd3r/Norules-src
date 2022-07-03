package com.viaversion.viaversion.protocols.protocol1_13to1_12_2;

import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.storage.*;

public class TabCompleteThread implements Runnable
{
    @Override
    public void run() {
        for (final UserConnection lllllllllllllllIIIIlllIIlIIIIIIl : Via.getManager().getConnectionManager().getConnections()) {
            if (lllllllllllllllIIIIlllIIlIIIIIIl.getProtocolInfo() == null) {
                continue;
            }
            if (!lllllllllllllllIIIIlllIIlIIIIIIl.getProtocolInfo().getPipeline().contains(Protocol1_13To1_12_2.class) || !lllllllllllllllIIIIlllIIlIIIIIIl.getChannel().isOpen()) {
                continue;
            }
            lllllllllllllllIIIIlllIIlIIIIIIl.get(TabCompleteTracker.class).sendPacketToServer(lllllllllllllllIIIIlllIIlIIIIIIl);
        }
    }
}
