package net.minecraft.server.network;

import net.minecraft.network.handshake.*;
import net.minecraft.server.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.util.text.*;
import net.minecraft.network.login.server.*;
import net.minecraft.network.*;

public class NetHandlerHandshakeTCP implements INetHandlerHandshakeServer
{
    private final /* synthetic */ MinecraftServer server;
    private final /* synthetic */ NetworkManager networkManager;
    
    @Override
    public void onDisconnect(final ITextComponent llllllllllllIllllllIIlIIlllllIll) {
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$network$EnumConnectionState() {
        final int[] $switch_TABLE$net$minecraft$network$EnumConnectionState = NetHandlerHandshakeTCP.$SWITCH_TABLE$net$minecraft$network$EnumConnectionState;
        if ($switch_TABLE$net$minecraft$network$EnumConnectionState != null) {
            return $switch_TABLE$net$minecraft$network$EnumConnectionState;
        }
        final char llllllllllllIllllllIIlIIlllllIIl = (Object)new int[EnumConnectionState.values().length];
        try {
            llllllllllllIllllllIIlIIlllllIIl[EnumConnectionState.HANDSHAKING.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllllllIIlIIlllllIIl[EnumConnectionState.LOGIN.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllllllIIlIIlllllIIl[EnumConnectionState.PLAY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIllllllIIlIIlllllIIl[EnumConnectionState.STATUS.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return NetHandlerHandshakeTCP.$SWITCH_TABLE$net$minecraft$network$EnumConnectionState = (int[])(Object)llllllllllllIllllllIIlIIlllllIIl;
    }
    
    public NetHandlerHandshakeTCP(final MinecraftServer llllllllllllIllllllIIlIlIIIIlIII, final NetworkManager llllllllllllIllllllIIlIlIIIIIlll) {
        this.server = llllllllllllIllllllIIlIlIIIIlIII;
        this.networkManager = llllllllllllIllllllIIlIlIIIIIlll;
    }
    
    @Override
    public void processHandshake(final C00Handshake llllllllllllIllllllIIlIIlllllllI) {
        switch ($SWITCH_TABLE$net$minecraft$network$EnumConnectionState()[llllllllllllIllllllIIlIIlllllllI.getRequestedState().ordinal()]) {
            case 4: {
                this.networkManager.setConnectionState(EnumConnectionState.LOGIN);
                if (llllllllllllIllllllIIlIIlllllllI.getProtocolVersion() > 340) {
                    final ITextComponent llllllllllllIllllllIIlIlIIIIIIIl = new TextComponentTranslation("multiplayer.disconnect.outdated_server", new Object[] { "1.12.2" });
                    this.networkManager.sendPacket(new SPacketDisconnect(llllllllllllIllllllIIlIlIIIIIIIl));
                    this.networkManager.closeChannel(llllllllllllIllllllIIlIlIIIIIIIl);
                    break;
                }
                if (llllllllllllIllllllIIlIIlllllllI.getProtocolVersion() < 340) {
                    final ITextComponent llllllllllllIllllllIIlIlIIIIIIII = new TextComponentTranslation("multiplayer.disconnect.outdated_client", new Object[] { "1.12.2" });
                    this.networkManager.sendPacket(new SPacketDisconnect(llllllllllllIllllllIIlIlIIIIIIII));
                    this.networkManager.closeChannel(llllllllllllIllllllIIlIlIIIIIIII);
                    break;
                }
                this.networkManager.setNetHandler(new NetHandlerLoginServer(this.server, this.networkManager));
                break;
            }
            case 3: {
                this.networkManager.setConnectionState(EnumConnectionState.STATUS);
                this.networkManager.setNetHandler(new NetHandlerStatusServer(this.server, this.networkManager));
                break;
            }
            default: {
                throw new UnsupportedOperationException(String.valueOf(new StringBuilder("Invalid intention ").append(llllllllllllIllllllIIlIIlllllllI.getRequestedState())));
            }
        }
    }
}
