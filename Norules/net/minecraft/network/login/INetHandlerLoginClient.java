package net.minecraft.network.login;

import net.minecraft.network.*;
import net.minecraft.network.login.server.*;

public interface INetHandlerLoginClient extends INetHandler
{
    void handleDisconnect(final SPacketDisconnect p0);
    
    void handleLoginSuccess(final SPacketLoginSuccess p0);
    
    void handleEnableCompression(final SPacketEnableCompression p0);
    
    void handleEncryptionRequest(final SPacketEncryptionRequest p0);
}
