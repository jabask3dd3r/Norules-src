package net.minecraft.network.status;

import net.minecraft.network.*;
import net.minecraft.network.status.client.*;

public interface INetHandlerStatusServer extends INetHandler
{
    void processPing(final CPacketPing p0);
    
    void processServerQuery(final CPacketServerQuery p0);
}
