package net.minecraft.realms;

import net.minecraft.util.text.*;
import net.minecraft.client.*;
import net.minecraft.client.network.*;
import net.minecraft.client.gui.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.*;
import net.minecraft.network.login.client.*;
import java.net.*;
import org.apache.logging.log4j.*;

public class RealmsConnect
{
    private /* synthetic */ NetworkManager connection;
    private final /* synthetic */ RealmsScreen onlineScreen;
    private static final /* synthetic */ Logger LOGGER;
    private volatile /* synthetic */ boolean aborted;
    
    public void abort() {
        this.aborted = true;
        if (this.connection != null && this.connection.isChannelOpen()) {
            this.connection.closeChannel(new TextComponentTranslation("disconnect.genericReason", new Object[0]));
            this.connection.checkDisconnected();
        }
    }
    
    public void connect(final String lllllllllllllIlIlIlllllIIIlIllIl, final int lllllllllllllIlIlIlllllIIIlIllII) {
        Realms.setConnectedToRealms(true);
        new Thread("Realms-connect-task") {
            @Override
            public void run() {
                InetAddress lllllllllllllIlIlIlllllIIllllIll = null;
                try {
                    lllllllllllllIlIlIlllllIIllllIll = InetAddress.getByName(lllllllllllllIlIlIlllllIIIlIllIl);
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.access$1(RealmsConnect.this, NetworkManager.createNetworkManagerAndConnect(lllllllllllllIlIlIlllllIIllllIll, lllllllllllllIlIlIlllllIIIlIllII, Minecraft.getMinecraft().gameSettings.isUsingNativeTransport()));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.setNetHandler(new NetHandlerLoginClient(RealmsConnect.this.connection, Minecraft.getMinecraft(), RealmsConnect.this.onlineScreen.getProxy()));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.sendPacket(new C00Handshake(lllllllllllllIlIlIlllllIIIlIllIl, lllllllllllllIlIlIlllllIIIlIllII, EnumConnectionState.LOGIN));
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.this.connection.sendPacket(new CPacketLoginStart(Minecraft.getMinecraft().getSession().getProfile()));
                }
                catch (UnknownHostException lllllllllllllIlIlIlllllIIllllIlI) {
                    Realms.clearResourcePack();
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.LOGGER.error("Couldn't connect to world", (Throwable)lllllllllllllIlIlIlllllIIllllIlI);
                    Realms.setScreen(new DisconnectedRealmsScreen(RealmsConnect.this.onlineScreen, "connect.failed", new TextComponentTranslation("disconnect.genericReason", new Object[] { String.valueOf(new StringBuilder("Unknown host '").append(lllllllllllllIlIlIlllllIIIlIllIl).append("'")) })));
                }
                catch (Exception lllllllllllllIlIlIlllllIIllllIIl) {
                    Realms.clearResourcePack();
                    if (RealmsConnect.this.aborted) {
                        return;
                    }
                    RealmsConnect.LOGGER.error("Couldn't connect to world", (Throwable)lllllllllllllIlIlIlllllIIllllIIl);
                    String lllllllllllllIlIlIlllllIIllllIII = lllllllllllllIlIlIlllllIIllllIIl.toString();
                    if (lllllllllllllIlIlIlllllIIllllIll != null) {
                        final String lllllllllllllIlIlIlllllIIlllIlll = String.valueOf(new StringBuilder().append(lllllllllllllIlIlIlllllIIllllIll).append(":").append(lllllllllllllIlIlIlllllIIIlIllII));
                        lllllllllllllIlIlIlllllIIllllIII = lllllllllllllIlIlIlllllIIllllIII.replaceAll(lllllllllllllIlIlIlllllIIlllIlll, "");
                    }
                    Realms.setScreen(new DisconnectedRealmsScreen(RealmsConnect.this.onlineScreen, "connect.failed", new TextComponentTranslation("disconnect.genericReason", new Object[] { lllllllllllllIlIlIlllllIIllllIII })));
                }
            }
        }.start();
    }
    
    public void tick() {
        if (this.connection != null) {
            if (this.connection.isChannelOpen()) {
                this.connection.processReceivedPackets();
            }
            else {
                this.connection.checkDisconnected();
            }
        }
    }
    
    public RealmsConnect(final RealmsScreen lllllllllllllIlIlIlllllIIIllIlII) {
        this.onlineScreen = lllllllllllllIlIlIlllllIIIllIlII;
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    static /* synthetic */ void access$1(final RealmsConnect lllllllllllllIlIlIlllllIIIIllllI, final NetworkManager lllllllllllllIlIlIlllllIIIIlllIl) {
        lllllllllllllIlIlIlllllIIIIllllI.connection = lllllllllllllIlIlIlllllIIIIlllIl;
    }
}
