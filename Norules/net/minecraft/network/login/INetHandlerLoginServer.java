package net.minecraft.network.login;

import net.minecraft.network.*;
import net.minecraft.network.login.client.*;

public interface INetHandlerLoginServer extends INetHandler
{
    void processEncryptionResponse(final CPacketEncryptionResponse p0);
    
    void processLoginStart(final CPacketLoginStart p0);
}
