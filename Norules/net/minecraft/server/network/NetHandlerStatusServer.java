package net.minecraft.server.network;

import net.minecraft.network.status.*;
import net.minecraft.server.*;
import net.minecraft.network.*;
import net.minecraft.network.status.client.*;
import net.minecraft.network.status.server.*;
import net.minecraft.util.text.*;

public class NetHandlerStatusServer implements INetHandlerStatusServer
{
    private static final /* synthetic */ ITextComponent EXIT_MESSAGE;
    private final /* synthetic */ MinecraftServer server;
    private final /* synthetic */ NetworkManager networkManager;
    private /* synthetic */ boolean handled;
    
    @Override
    public void processServerQuery(final CPacketServerQuery llllllllllllllIIIIlIlllIIlIIlIIl) {
        if (this.handled) {
            this.networkManager.closeChannel(NetHandlerStatusServer.EXIT_MESSAGE);
        }
        else {
            this.handled = true;
            this.networkManager.sendPacket(new SPacketServerInfo(this.server.getServerStatusResponse()));
        }
    }
    
    @Override
    public void processPing(final CPacketPing llllllllllllllIIIIlIlllIIlIIIIlI) {
        this.networkManager.sendPacket(new SPacketPong(llllllllllllllIIIIlIlllIIlIIIIlI.getClientTime()));
        this.networkManager.closeChannel(NetHandlerStatusServer.EXIT_MESSAGE);
    }
    
    @Override
    public void onDisconnect(final ITextComponent llllllllllllllIIIIlIlllIIlIIllII) {
    }
    
    static {
        EXIT_MESSAGE = new TextComponentString("Status request has been handled.");
    }
    
    public NetHandlerStatusServer(final MinecraftServer llllllllllllllIIIIlIlllIIlIIllll, final NetworkManager llllllllllllllIIIIlIlllIIlIIlllI) {
        this.server = llllllllllllllIIIIlIlllIIlIIllll;
        this.networkManager = llllllllllllllIIIIlIlllIIlIIlllI;
    }
}
