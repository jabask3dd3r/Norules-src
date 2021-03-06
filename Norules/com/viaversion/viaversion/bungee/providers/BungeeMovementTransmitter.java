package com.viaversion.viaversion.bungee.providers;

import com.viaversion.viaversion.protocols.protocol1_9to1_8.providers.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.*;

public class BungeeMovementTransmitter extends MovementTransmitterProvider
{
    @Override
    public Object getGroundPacket() {
        return null;
    }
    
    @Override
    public void sendPlayer(final UserConnection llllllllllllllllllllllIlIIllIllI) {
        if (llllllllllllllllllllllIlIIllIllI.getProtocolInfo().getState() == State.PLAY) {
            final PacketWrapper llllllllllllllllllllllIlIIlllIIl = PacketWrapper.create(ServerboundPackets1_8.PLAYER_MOVEMENT, null, llllllllllllllllllllllIlIIllIllI);
            final MovementTracker llllllllllllllllllllllIlIIlllIII = llllllllllllllllllllllIlIIllIllI.get(MovementTracker.class);
            llllllllllllllllllllllIlIIlllIIl.write(Type.BOOLEAN, llllllllllllllllllllllIlIIlllIII.isGround());
            try {
                llllllllllllllllllllllIlIIlllIIl.scheduleSendToServer(Protocol1_9To1_8.class);
            }
            catch (Exception llllllllllllllllllllllIlIIlllIlI) {
                llllllllllllllllllllllIlIIlllIlI.printStackTrace();
            }
            llllllllllllllllllllllIlIIlllIII.incrementIdlePacket();
        }
    }
    
    @Override
    public Object getFlyingPacket() {
        return null;
    }
}
