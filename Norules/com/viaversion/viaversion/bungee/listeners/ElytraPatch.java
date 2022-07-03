package com.viaversion.viaversion.bungee.listeners;

import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.api.event.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import io.netty.buffer.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import net.md_5.bungee.event.*;

public class ElytraPatch implements Listener
{
    @EventHandler(priority = 32)
    public void onServerConnected(final ServerConnectedEvent lllllllllllllIIlIlIIllIIlIIlIIll) {
        final UserConnection lllllllllllllIIlIlIIllIIlIIlIlII = Via.getManager().getConnectionManager().getConnectedClient(lllllllllllllIIlIlIIllIIlIIlIIll.getPlayer().getUniqueId());
        if (lllllllllllllIIlIlIIllIIlIIlIlII == null) {
            return;
        }
        try {
            if (lllllllllllllIIlIlIIllIIlIIlIlII.getProtocolInfo().getPipeline().contains(Protocol1_9To1_8.class)) {
                final EntityTracker1_9 lllllllllllllIIlIlIIllIIlIIllIlI = lllllllllllllIIlIlIIllIIlIIlIlII.getEntityTracker(Protocol1_9To1_8.class);
                final int lllllllllllllIIlIlIIllIIlIIllIIl = lllllllllllllIIlIlIIllIIlIIllIlI.getProvidedEntityId();
                final PacketWrapper lllllllllllllIIlIlIIllIIlIIllIII = PacketWrapper.create(ClientboundPackets1_9.ENTITY_METADATA, null, lllllllllllllIIlIlIIllIIlIIlIlII);
                lllllllllllllIIlIlIIllIIlIIllIII.write(Type.VAR_INT, lllllllllllllIIlIlIIllIIlIIllIIl);
                lllllllllllllIIlIlIIllIIlIIllIII.write(Types1_9.METADATA_LIST, Collections.singletonList(new Metadata(0, MetaType1_9.Byte, 0)));
                lllllllllllllIIlIlIIllIIlIIllIII.scheduleSend(Protocol1_9To1_8.class);
            }
        }
        catch (Exception lllllllllllllIIlIlIIllIIlIIlIlll) {
            lllllllllllllIIlIlIIllIIlIIlIlll.printStackTrace();
        }
    }
}
