package com.viaversion.viaversion.protocols.protocol1_9to1_8.providers;

import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import io.netty.channel.*;

public abstract class MovementTransmitterProvider implements Provider
{
    public void sendPlayer(final UserConnection lllllllllllllllIIlllIIIIIIllIlIl) {
        final ChannelHandlerContext lllllllllllllllIIlllIIIIIIllIlII = PipelineUtil.getContextBefore("decoder", lllllllllllllllIIlllIIIIIIllIlIl.getChannel().pipeline());
        if (lllllllllllllllIIlllIIIIIIllIlII != null) {
            if (lllllllllllllllIIlllIIIIIIllIlIl.get(MovementTracker.class).isGround()) {
                lllllllllllllllIIlllIIIIIIllIlII.fireChannelRead(this.getGroundPacket());
            }
            else {
                lllllllllllllllIIlllIIIIIIllIlII.fireChannelRead(this.getFlyingPacket());
            }
            lllllllllllllllIIlllIIIIIIllIlIl.get(MovementTracker.class).incrementIdlePacket();
        }
    }
    
    public abstract Object getGroundPacket();
    
    public abstract Object getFlyingPacket();
}
