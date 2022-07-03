package net.minecraft.client.network;

import net.minecraft.network.handshake.*;
import net.minecraft.server.*;
import net.minecraft.util.text.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.server.network.*;
import net.minecraft.network.*;

public class NetHandlerHandshakeMemory implements INetHandlerHandshakeServer
{
    private final /* synthetic */ NetworkManager networkManager;
    private final /* synthetic */ MinecraftServer mcServer;
    
    @Override
    public void onDisconnect(final ITextComponent lllllllllllllIIIIIIllllIllIlllIl) {
    }
    
    public NetHandlerHandshakeMemory(final MinecraftServer lllllllllllllIIIIIIllllIlllIlIIl, final NetworkManager lllllllllllllIIIIIIllllIlllIIlIl) {
        this.mcServer = lllllllllllllIIIIIIllllIlllIlIIl;
        this.networkManager = lllllllllllllIIIIIIllllIlllIIlIl;
    }
    
    @Override
    public void processHandshake(final C00Handshake lllllllllllllIIIIIIllllIllIlllll) {
        this.networkManager.setConnectionState(lllllllllllllIIIIIIllllIllIlllll.getRequestedState());
        this.networkManager.setNetHandler(new NetHandlerLoginServer(this.mcServer, this.networkManager));
    }
}
