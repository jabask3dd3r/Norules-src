package net.minecraft.network.status;

import net.minecraft.network.*;
import net.minecraft.network.status.server.*;

public interface INetHandlerStatusClient extends INetHandler
{
    void handlePong(final SPacketPong p0);
    
    void handleServerInfo(final SPacketServerInfo p0);
}
