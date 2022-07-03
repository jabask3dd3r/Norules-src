package com.viaversion.viaversion.velocity.providers;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;

public class VelocityMovementTransmitter extends MovementTransmitterProvider
{
    @Override
    public void sendPlayer(final UserConnection llllllllllllllllllIIIlIIlIIlIIlI) {
        if (llllllllllllllllllIIIlIIlIIlIIlI.getProtocolInfo().getState() == State.PLAY) {
            final PacketWrapper llllllllllllllllllIIIlIIlIIlIlIl = PacketWrapper.create(ServerboundPackets1_8.PLAYER_MOVEMENT, null, llllllllllllllllllIIIlIIlIIlIIlI);
            final MovementTracker llllllllllllllllllIIIlIIlIIlIlII = llllllllllllllllllIIIlIIlIIlIIlI.get(MovementTracker.class);
            llllllllllllllllllIIIlIIlIIlIlIl.write(Type.BOOLEAN, llllllllllllllllllIIIlIIlIIlIlII.isGround());
            try {
                llllllllllllllllllIIIlIIlIIlIlIl.scheduleSendToServer(Protocol1_9To1_8.class);
            }
            catch (Exception llllllllllllllllllIIIlIIlIIlIllI) {
                llllllllllllllllllIIIlIIlIIlIllI.printStackTrace();
            }
            llllllllllllllllllIIIlIIlIIlIlII.incrementIdlePacket();
        }
    }
    
    @Override
    public Object getFlyingPacket() {
        return null;
    }
    
    @Override
    public Object getGroundPacket() {
        return null;
    }
}
