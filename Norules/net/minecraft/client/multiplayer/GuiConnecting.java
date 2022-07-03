package net.minecraft.client.multiplayer;

import java.util.concurrent.atomic.*;
import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.*;
import java.io.*;
import net.minecraft.client.network.*;
import net.minecraft.network.handshake.client.*;
import net.minecraft.network.*;
import net.minecraft.network.login.client.*;
import net.minecraft.util.text.*;
import net.minecraft.client.gui.*;
import java.net.*;

public class GuiConnecting extends GuiScreen
{
    private /* synthetic */ boolean cancel;
    private /* synthetic */ NetworkManager networkManager;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ AtomicInteger CONNECTION_ID;
    private final /* synthetic */ GuiScreen previousGuiScreen;
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlllIIIIIlllIIlIII, final int llllllllllllllIlllIIIIIlllIIIlll, final float llllllllllllllIlllIIIIIlllIIIllI) {
        this.drawDefaultBackground();
        if (this.networkManager == null) {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.connecting", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        }
        else {
            this.drawCenteredString(this.fontRendererObj, I18n.format("connect.authorizing", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        }
        super.drawScreen(llllllllllllllIlllIIIIIlllIIlIII, llllllllllllllIlllIIIIIlllIIIlll, llllllllllllllIlllIIIIIlllIIIllI);
    }
    
    static {
        CONNECTION_ID = new AtomicInteger(0);
        LOGGER = LogManager.getLogger();
    }
    
    static /* synthetic */ void access$2(final GuiConnecting llllllllllllllIlllIIIIIllIllllll, final NetworkManager llllllllllllllIlllIIIIIllIlllllI) {
        llllllllllllllIlllIIIIIllIllllll.networkManager = llllllllllllllIlllIIIIIllIlllllI;
    }
    
    public GuiConnecting(final GuiScreen llllllllllllllIlllIIIIIlllllIIlI, final Minecraft llllllllllllllIlllIIIIIllllIllII, final String llllllllllllllIlllIIIIIllllIlIll, final int llllllllllllllIlllIIIIIllllIlIlI) {
        this.mc = llllllllllllllIlllIIIIIllllIllII;
        this.previousGuiScreen = llllllllllllllIlllIIIIIlllllIIlI;
        llllllllllllllIlllIIIIIllllIllII.loadWorld(null);
        this.connect(llllllllllllllIlllIIIIIllllIlIll, llllllllllllllIlllIIIIIllllIlIlI);
    }
    
    @Override
    public void updateScreen() {
        if (this.networkManager != null) {
            if (this.networkManager.isChannelOpen()) {
                this.networkManager.processReceivedPackets();
            }
            else {
                this.networkManager.checkDisconnected();
            }
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIlllIIIIIlllIlIlII) throws IOException {
        if (llllllllllllllIlllIIIIIlllIlIlII.id == 0) {
            this.cancel = true;
            if (this.networkManager != null) {
                this.networkManager.closeChannel(new TextComponentString("Aborted"));
            }
            this.mc.displayGuiScreen(this.previousGuiScreen);
        }
    }
    
    public GuiConnecting(final GuiScreen llllllllllllllIlllIIIIlIIIIIIIIl, final Minecraft llllllllllllllIlllIIIIIllllllIll, final ServerData llllllllllllllIlllIIIIIlllllllll) {
        this.mc = llllllllllllllIlllIIIIIllllllIll;
        this.previousGuiScreen = llllllllllllllIlllIIIIlIIIIIIIIl;
        final ServerAddress llllllllllllllIlllIIIIIllllllllI = ServerAddress.fromString(llllllllllllllIlllIIIIIlllllllll.serverIP);
        llllllllllllllIlllIIIIIllllllIll.loadWorld(null);
        llllllllllllllIlllIIIIIllllllIll.setServerData(llllllllllllllIlllIIIIIlllllllll);
        this.connect(llllllllllllllIlllIIIIIllllllllI.getIP(), llllllllllllllIlllIIIIIllllllllI.getPort());
    }
    
    private void connect(final String llllllllllllllIlllIIIIIllllIIIlI, final int llllllllllllllIlllIIIIIllllIIlII) {
        GuiConnecting.LOGGER.info("Connecting to {}, {}", (Object)llllllllllllllIlllIIIIIllllIIIlI, (Object)llllllllllllllIlllIIIIIllllIIlII);
        new Thread(String.valueOf(new StringBuilder("Server Connector #").append(GuiConnecting.CONNECTION_ID.incrementAndGet()))) {
            @Override
            public void run() {
                InetAddress llllllllllllllIllllIIIIlIlllIIlI = null;
                try {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    llllllllllllllIllllIIIIlIlllIIlI = InetAddress.getByName(llllllllllllllIlllIIIIIllllIIIlI);
                    GuiConnecting.access$2(GuiConnecting.this, NetworkManager.createNetworkManagerAndConnect(llllllllllllllIllllIIIIlIlllIIlI, llllllllllllllIlllIIIIIllllIIlII, GuiConnecting.this.mc.gameSettings.isUsingNativeTransport()));
                    GuiConnecting.this.networkManager.setNetHandler(new NetHandlerLoginClient(GuiConnecting.this.networkManager, GuiConnecting.this.mc, GuiConnecting.this.previousGuiScreen));
                    GuiConnecting.this.networkManager.sendPacket(new C00Handshake(llllllllllllllIlllIIIIIllllIIIlI, llllllllllllllIlllIIIIIllllIIlII, EnumConnectionState.LOGIN));
                    GuiConnecting.this.networkManager.sendPacket(new CPacketLoginStart(GuiConnecting.this.mc.getSession().getProfile()));
                }
                catch (UnknownHostException llllllllllllllIllllIIIIlIlllIIIl) {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    GuiConnecting.LOGGER.error("Couldn't connect to server", (Throwable)llllllllllllllIllllIIIIlIlllIIIl);
                    GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new TextComponentTranslation("disconnect.genericReason", new Object[] { "Unknown host" })));
                }
                catch (Exception llllllllllllllIllllIIIIlIlllIIII) {
                    if (GuiConnecting.this.cancel) {
                        return;
                    }
                    GuiConnecting.LOGGER.error("Couldn't connect to server", (Throwable)llllllllllllllIllllIIIIlIlllIIII);
                    String llllllllllllllIllllIIIIlIllIllll = llllllllllllllIllllIIIIlIlllIIII.toString();
                    if (llllllllllllllIllllIIIIlIlllIIlI != null) {
                        final String llllllllllllllIllllIIIIlIllIlllI = String.valueOf(new StringBuilder().append(llllllllllllllIllllIIIIlIlllIIlI).append(":").append(llllllllllllllIlllIIIIIllllIIlII));
                        llllllllllllllIllllIIIIlIllIllll = llllllllllllllIllllIIIIlIllIllll.replaceAll(llllllllllllllIllllIIIIlIllIlllI, "");
                    }
                    GuiConnecting.this.mc.displayGuiScreen(new GuiDisconnected(GuiConnecting.this.previousGuiScreen, "connect.failed", new TextComponentTranslation("disconnect.genericReason", new Object[] { llllllllllllllIllllIIIIlIllIllll })));
                }
            }
        }.start();
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIlllIIIIIlllIlllII, final int llllllllllllllIlllIIIIIlllIllIll) throws IOException {
    }
}
