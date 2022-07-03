package net.minecraft.client.gui;

import java.io.*;
import net.minecraft.client.resources.*;
import org.lwjgl.input.*;
import net.minecraft.client.network.*;
import net.minecraft.client.multiplayer.*;
import java.util.*;
import com.google.common.base.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;

public class GuiMultiplayer extends GuiScreen
{
    private /* synthetic */ GuiButton btnSelectServer;
    private /* synthetic */ boolean initialized;
    private /* synthetic */ ServerList savedServerList;
    private /* synthetic */ ServerSelectionList serverListSelector;
    private /* synthetic */ LanServerDetector.LanServerList lanServerList;
    private static final /* synthetic */ Logger LOGGER;
    private final /* synthetic */ GuiScreen parentScreen;
    private /* synthetic */ boolean editingServer;
    private final /* synthetic */ ServerPinger oldServerPinger;
    private /* synthetic */ GuiButton btnDeleteServer;
    private /* synthetic */ boolean directConnect;
    private /* synthetic */ boolean deletingServer;
    private /* synthetic */ LanServerDetector.ThreadLanServerFind lanServerDetector;
    private /* synthetic */ GuiButton btnEditServer;
    private /* synthetic */ boolean addingServer;
    private /* synthetic */ String hoveringText;
    private /* synthetic */ ServerData selectedServer;
    
    public void moveServerDown(final ServerListEntryNormal llllllllllllllIIIlIlIlIIllIlIllI, final int llllllllllllllIIIlIlIlIIllIlIlIl, final boolean llllllllllllllIIIlIlIlIIllIlIlII) {
        final int llllllllllllllIIIlIlIlIIllIlIIll = llllllllllllllIIIlIlIlIIllIlIlII ? (this.savedServerList.countServers() - 1) : (llllllllllllllIIIlIlIlIIllIlIlIl + 1);
        this.savedServerList.swapServers(llllllllllllllIIIlIlIlIIllIlIlIl, llllllllllllllIIIlIlIlIIllIlIIll);
        if (this.serverListSelector.getSelected() == llllllllllllllIIIlIlIlIIllIlIlIl) {
            this.selectServer(llllllllllllllIIIlIlIlIIllIlIIll);
        }
        this.serverListSelector.updateOnlineServers(this.savedServerList);
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllIIIlIlIlIlIlIIlllI, final int llllllllllllllIIIlIlIlIlIlIlIIlI) {
        final GuiListExtended.IGuiListEntry llllllllllllllIIIlIlIlIlIlIlIIIl = (this.serverListSelector.getSelected() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.getSelected());
        if (this.deletingServer) {
            this.deletingServer = false;
            if (llllllllllllllIIIlIlIlIlIlIIlllI && llllllllllllllIIIlIlIlIlIlIlIIIl instanceof ServerListEntryNormal) {
                this.savedServerList.removeServerData(this.serverListSelector.getSelected());
                this.savedServerList.saveServerList();
                this.serverListSelector.setSelectedSlotIndex(-1);
                this.serverListSelector.updateOnlineServers(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
        else if (this.directConnect) {
            this.directConnect = false;
            if (llllllllllllllIIIlIlIlIlIlIIlllI) {
                this.connectToServer(this.selectedServer);
            }
            else {
                this.mc.displayGuiScreen(this);
            }
        }
        else if (this.addingServer) {
            this.addingServer = false;
            if (llllllllllllllIIIlIlIlIlIlIIlllI) {
                this.savedServerList.addServerData(this.selectedServer);
                this.savedServerList.saveServerList();
                this.serverListSelector.setSelectedSlotIndex(-1);
                this.serverListSelector.updateOnlineServers(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
        else if (this.editingServer) {
            this.editingServer = false;
            if (llllllllllllllIIIlIlIlIlIlIIlllI && llllllllllllllIIIlIlIlIlIlIlIIIl instanceof ServerListEntryNormal) {
                final ServerData llllllllllllllIIIlIlIlIlIlIlIIII = ((ServerListEntryNormal)llllllllllllllIIIlIlIlIlIlIlIIIl).getServerData();
                llllllllllllllIIIlIlIlIlIlIlIIII.serverName = this.selectedServer.serverName;
                llllllllllllllIIIlIlIlIlIlIlIIII.serverIP = this.selectedServer.serverIP;
                llllllllllllllIIIlIlIlIlIlIlIIII.copyFrom(this.selectedServer);
                this.savedServerList.saveServerList();
                this.serverListSelector.updateOnlineServers(this.savedServerList);
            }
            this.mc.displayGuiScreen(this);
        }
    }
    
    public GuiMultiplayer(final GuiScreen llllllllllllllIIIlIlIlIllIIIllll) {
        this.oldServerPinger = new ServerPinger();
        this.parentScreen = llllllllllllllIIIlIlIlIllIIIllll;
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.serverListSelector.handleMouseInput();
    }
    
    public void setHoveringText(final String llllllllllllllIIIlIlIlIlIIIlIIlI) {
        this.hoveringText = llllllllllllllIIIlIlIlIlIIIlIIlI;
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIIlIlIlIlIllIIIll) throws IOException {
        if (llllllllllllllIIIlIlIlIlIllIIIll.enabled) {
            final GuiListExtended.IGuiListEntry llllllllllllllIIIlIlIlIlIllIllII = (this.serverListSelector.getSelected() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.getSelected());
            if (llllllllllllllIIIlIlIlIlIllIIIll.id == 2 && llllllllllllllIIIlIlIlIlIllIllII instanceof ServerListEntryNormal) {
                final String llllllllllllllIIIlIlIlIlIllIlIll = ((ServerListEntryNormal)llllllllllllllIIIlIlIlIlIllIllII).getServerData().serverName;
                if (llllllllllllllIIIlIlIlIlIllIlIll != null) {
                    this.deletingServer = true;
                    final String llllllllllllllIIIlIlIlIlIllIlIlI = I18n.format("selectServer.deleteQuestion", new Object[0]);
                    final String llllllllllllllIIIlIlIlIlIllIlIIl = String.valueOf(new StringBuilder("'").append(llllllllllllllIIIlIlIlIlIllIlIll).append("' ").append(I18n.format("selectServer.deleteWarning", new Object[0])));
                    final String llllllllllllllIIIlIlIlIlIllIlIII = I18n.format("selectServer.deleteButton", new Object[0]);
                    final String llllllllllllllIIIlIlIlIlIllIIlll = I18n.format("gui.cancel", new Object[0]);
                    final GuiYesNo llllllllllllllIIIlIlIlIlIllIIllI = new GuiYesNo(this, llllllllllllllIIIlIlIlIlIllIlIlI, llllllllllllllIIIlIlIlIlIllIlIIl, llllllllllllllIIIlIlIlIlIllIlIII, llllllllllllllIIIlIlIlIlIllIIlll, this.serverListSelector.getSelected());
                    this.mc.displayGuiScreen(llllllllllllllIIIlIlIlIlIllIIllI);
                }
            }
            else if (llllllllllllllIIIlIlIlIlIllIIIll.id == 1) {
                this.connectToSelected();
            }
            else if (llllllllllllllIIIlIlIlIlIllIIIll.id == 4) {
                this.directConnect = true;
                this.selectedServer = new ServerData(I18n.format("selectServer.defaultName", new Object[0]), "", false);
                this.mc.displayGuiScreen(new GuiScreenServerList(this, this.selectedServer));
            }
            else if (llllllllllllllIIIlIlIlIlIllIIIll.id == 3) {
                this.addingServer = true;
                this.selectedServer = new ServerData(I18n.format("selectServer.defaultName", new Object[0]), "", false);
                this.mc.displayGuiScreen(new GuiScreenAddServer(this, this.selectedServer));
            }
            else if (llllllllllllllIIIlIlIlIlIllIIIll.id == 7 && llllllllllllllIIIlIlIlIlIllIllII instanceof ServerListEntryNormal) {
                this.editingServer = true;
                final ServerData llllllllllllllIIIlIlIlIlIllIIlIl = ((ServerListEntryNormal)llllllllllllllIIIlIlIlIlIllIllII).getServerData();
                this.selectedServer = new ServerData(llllllllllllllIIIlIlIlIlIllIIlIl.serverName, llllllllllllllIIIlIlIlIlIllIIlIl.serverIP, false);
                this.selectedServer.copyFrom(llllllllllllllIIIlIlIlIlIllIIlIl);
                this.mc.displayGuiScreen(new GuiScreenAddServer(this, this.selectedServer));
            }
            else if (llllllllllllllIIIlIlIlIlIllIIIll.id == 0) {
                this.mc.displayGuiScreen(this.parentScreen);
            }
            else if (llllllllllllllIIIlIlIlIlIllIIIll.id == 8) {
                this.refreshServerList();
            }
        }
    }
    
    public void moveServerUp(final ServerListEntryNormal llllllllllllllIIIlIlIlIIlllIIIll, final int llllllllllllllIIIlIlIlIIllIllllI, final boolean llllllllllllllIIIlIlIlIIlllIIIIl) {
        final int llllllllllllllIIIlIlIlIIlllIIIII = llllllllllllllIIIlIlIlIIlllIIIIl ? 0 : (llllllllllllllIIIlIlIlIIllIllllI - 1);
        this.savedServerList.swapServers(llllllllllllllIIIlIlIlIIllIllllI, llllllllllllllIIIlIlIlIIlllIIIII);
        if (this.serverListSelector.getSelected() == llllllllllllllIIIlIlIlIIllIllllI) {
            this.selectServer(llllllllllllllIIIlIlIlIIlllIIIII);
        }
        this.serverListSelector.updateOnlineServers(this.savedServerList);
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        if (this.lanServerDetector != null) {
            this.lanServerDetector.interrupt();
            this.lanServerDetector = null;
        }
        this.oldServerPinger.clearPendingNetworks();
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIIIlIlIlIlIlIIIIII, final int llllllllllllllIIIlIlIlIlIlIIIlII) throws IOException {
        final int llllllllllllllIIIlIlIlIlIlIIIIll = this.serverListSelector.getSelected();
        final GuiListExtended.IGuiListEntry llllllllllllllIIIlIlIlIlIlIIIIlI = (llllllllllllllIIIlIlIlIlIlIIIIll < 0) ? null : this.serverListSelector.getListEntry(llllllllllllllIIIlIlIlIlIlIIIIll);
        if (llllllllllllllIIIlIlIlIlIlIIIlII == 63) {
            this.refreshServerList();
        }
        else if (llllllllllllllIIIlIlIlIlIlIIIIll >= 0) {
            if (llllllllllllllIIIlIlIlIlIlIIIlII == 200) {
                if (isShiftKeyDown()) {
                    if (llllllllllllllIIIlIlIlIlIlIIIIll > 0 && llllllllllllllIIIlIlIlIlIlIIIIlI instanceof ServerListEntryNormal) {
                        this.savedServerList.swapServers(llllllllllllllIIIlIlIlIlIlIIIIll, llllllllllllllIIIlIlIlIlIlIIIIll - 1);
                        this.selectServer(this.serverListSelector.getSelected() - 1);
                        this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                        this.serverListSelector.updateOnlineServers(this.savedServerList);
                    }
                }
                else if (llllllllllllllIIIlIlIlIlIlIIIIll > 0) {
                    this.selectServer(this.serverListSelector.getSelected() - 1);
                    this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                    if (this.serverListSelector.getListEntry(this.serverListSelector.getSelected()) instanceof ServerListEntryLanScan) {
                        if (this.serverListSelector.getSelected() > 0) {
                            this.selectServer(this.serverListSelector.getSize() - 1);
                            this.serverListSelector.scrollBy(-this.serverListSelector.getSlotHeight());
                        }
                        else {
                            this.selectServer(-1);
                        }
                    }
                }
                else {
                    this.selectServer(-1);
                }
            }
            else if (llllllllllllllIIIlIlIlIlIlIIIlII == 208) {
                if (isShiftKeyDown()) {
                    if (llllllllllllllIIIlIlIlIlIlIIIIll < this.savedServerList.countServers() - 1) {
                        this.savedServerList.swapServers(llllllllllllllIIIlIlIlIlIlIIIIll, llllllllllllllIIIlIlIlIlIlIIIIll + 1);
                        this.selectServer(llllllllllllllIIIlIlIlIlIlIIIIll + 1);
                        this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                        this.serverListSelector.updateOnlineServers(this.savedServerList);
                    }
                }
                else if (llllllllllllllIIIlIlIlIlIlIIIIll < this.serverListSelector.getSize()) {
                    this.selectServer(this.serverListSelector.getSelected() + 1);
                    this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                    if (this.serverListSelector.getListEntry(this.serverListSelector.getSelected()) instanceof ServerListEntryLanScan) {
                        if (this.serverListSelector.getSelected() < this.serverListSelector.getSize() - 1) {
                            this.selectServer(this.serverListSelector.getSize() + 1);
                            this.serverListSelector.scrollBy(this.serverListSelector.getSlotHeight());
                        }
                        else {
                            this.selectServer(-1);
                        }
                    }
                }
                else {
                    this.selectServer(-1);
                }
            }
            else if (llllllllllllllIIIlIlIlIlIlIIIlII != 28 && llllllllllllllIIIlIlIlIlIlIIIlII != 156) {
                super.keyTyped(llllllllllllllIIIlIlIlIlIlIIIIII, llllllllllllllIIIlIlIlIlIlIIIlII);
            }
            else {
                this.actionPerformed(this.buttonList.get(2));
            }
        }
        else {
            super.keyTyped(llllllllllllllIIIlIlIlIlIlIIIIII, llllllllllllllIIIlIlIlIlIlIIIlII);
        }
    }
    
    public boolean canMoveDown(final ServerListEntryNormal llllllllllllllIIIlIlIlIIlllIllII, final int llllllllllllllIIIlIlIlIIlllIlIIl) {
        return llllllllllllllIIIlIlIlIIlllIlIIl < this.savedServerList.countServers() - 1;
    }
    
    public void connectToSelected() {
        final GuiListExtended.IGuiListEntry llllllllllllllIIIlIlIlIlIIlIllII = (this.serverListSelector.getSelected() < 0) ? null : this.serverListSelector.getListEntry(this.serverListSelector.getSelected());
        if (llllllllllllllIIIlIlIlIlIIlIllII instanceof ServerListEntryNormal) {
            this.connectToServer(((ServerListEntryNormal)llllllllllllllIIIlIlIlIlIIlIllII).getServerData());
        }
        else if (llllllllllllllIIIlIlIlIlIIlIllII instanceof ServerListEntryLanDetected) {
            final LanServerInfo llllllllllllllIIIlIlIlIlIIlIlIll = ((ServerListEntryLanDetected)llllllllllllllIIIlIlIlIlIIlIllII).getServerData();
            this.connectToServer(new ServerData(llllllllllllllIIIlIlIlIlIIlIlIll.getServerMotd(), llllllllllllllIIIlIlIlIlIIlIlIll.getServerIpPort(), true));
        }
    }
    
    private void connectToServer(final ServerData llllllllllllllIIIlIlIlIlIIlIIIlI) {
        this.mc.displayGuiScreen(new GuiConnecting(this, this.mc, llllllllllllllIIIlIlIlIlIIlIIIlI));
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        if (this.lanServerList.getWasUpdated()) {
            final List<LanServerInfo> llllllllllllllIIIlIlIlIlIlllllIl = this.lanServerList.getLanServers();
            this.lanServerList.setWasNotUpdated();
            this.serverListSelector.updateNetworkServers(llllllllllllllIIIlIlIlIlIlllllIl);
        }
        this.oldServerPinger.pingPendingNetworks();
    }
    
    public boolean canMoveUp(final ServerListEntryNormal llllllllllllllIIIlIlIlIIllllIIlI, final int llllllllllllllIIIlIlIlIIllllIIIl) {
        return llllllllllllllIIIlIlIlIIllllIIIl > 0;
    }
    
    public void selectServer(final int llllllllllllllIIIlIlIlIlIIIllIlI) {
        this.serverListSelector.setSelectedSlotIndex(llllllllllllllIIIlIlIlIlIIIllIlI);
        final GuiListExtended.IGuiListEntry llllllllllllllIIIlIlIlIlIIIlllII = (llllllllllllllIIIlIlIlIlIIIllIlI < 0) ? null : this.serverListSelector.getListEntry(llllllllllllllIIIlIlIlIlIIIllIlI);
        this.btnSelectServer.enabled = false;
        this.btnEditServer.enabled = false;
        this.btnDeleteServer.enabled = false;
        if (llllllllllllllIIIlIlIlIlIIIlllII != null && !(llllllllllllllIIIlIlIlIlIIIlllII instanceof ServerListEntryLanScan)) {
            this.btnSelectServer.enabled = true;
            if (llllllllllllllIIIlIlIlIlIIIlllII instanceof ServerListEntryNormal) {
                this.btnEditServer.enabled = true;
                this.btnDeleteServer.enabled = true;
            }
        }
    }
    
    public ServerPinger getOldServerPinger() {
        return this.oldServerPinger;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIIlIlIlIlIIllIIll, final int llllllllllllllIIIlIlIlIlIIllIIlI, final float llllllllllllllIIIlIlIlIlIIllIIIl) {
        this.hoveringText = null;
        this.drawDefaultBackground();
        this.serverListSelector.drawScreen(llllllllllllllIIIlIlIlIlIIllIIll, llllllllllllllIIIlIlIlIlIIllIIlI, llllllllllllllIIIlIlIlIlIIllIIIl);
        this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.title", new Object[0]), this.width / 2, 20, 16777215);
        super.drawScreen(llllllllllllllIIIlIlIlIlIIllIIll, llllllllllllllIIIlIlIlIlIIllIIlI, llllllllllllllIIIlIlIlIlIIllIIIl);
        if (this.hoveringText != null) {
            this.drawHoveringText(Lists.newArrayList(Splitter.on("\n").split((CharSequence)this.hoveringText)), llllllllllllllIIIlIlIlIlIIllIIll, llllllllllllllIIIlIlIlIlIIllIIlI);
        }
    }
    
    private void refreshServerList() {
        this.mc.displayGuiScreen(new GuiMultiplayer(this.parentScreen));
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIIIlIlIlIlIIIIlIlI, final int llllllllllllllIIIlIlIlIlIIIIIlIl, final int llllllllllllllIIIlIlIlIlIIIIlIII) throws IOException {
        super.mouseClicked(llllllllllllllIIIlIlIlIlIIIIlIlI, llllllllllllllIIIlIlIlIlIIIIIlIl, llllllllllllllIIIlIlIlIlIIIIlIII);
        this.serverListSelector.mouseClicked(llllllllllllllIIIlIlIlIlIIIIlIlI, llllllllllllllIIIlIlIlIlIIIIIlIl, llllllllllllllIIIlIlIlIlIIIIlIII);
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        if (this.initialized) {
            this.serverListSelector.setDimensions(this.width, this.height, 32, this.height - 64);
        }
        else {
            this.initialized = true;
            this.savedServerList = new ServerList(this.mc);
            this.savedServerList.loadServerList();
            this.lanServerList = new LanServerDetector.LanServerList();
            try {
                this.lanServerDetector = new LanServerDetector.ThreadLanServerFind(this.lanServerList);
                this.lanServerDetector.start();
            }
            catch (Exception llllllllllllllIIIlIlIlIllIIIlIIl) {
                GuiMultiplayer.LOGGER.warn("Unable to start LAN server detection: {}", (Object)llllllllllllllIIIlIlIlIllIIIlIIl.getMessage());
            }
            this.serverListSelector = new ServerSelectionList(this, this.mc, this.width, this.height, 32, this.height - 64, 36);
            this.serverListSelector.updateOnlineServers(this.savedServerList);
        }
        this.createButtons();
    }
    
    @Override
    protected void mouseReleased(final int llllllllllllllIIIlIlIlIIlllllllI, final int llllllllllllllIIIlIlIlIIlllllIIl, final int llllllllllllllIIIlIlIlIIlllllIII) {
        super.mouseReleased(llllllllllllllIIIlIlIlIIlllllllI, llllllllllllllIIIlIlIlIIlllllIIl, llllllllllllllIIIlIlIlIIlllllIII);
        this.serverListSelector.mouseReleased(llllllllllllllIIIlIlIlIIlllllllI, llllllllllllllIIIlIlIlIIlllllIIl, llllllllllllllIIIlIlIlIIlllllIII);
    }
    
    public void createButtons() {
        this.btnEditServer = this.addButton(new GuiButton(7, this.width / 2 - 154, this.height - 28, 70, 20, I18n.format("selectServer.edit", new Object[0])));
        this.btnDeleteServer = this.addButton(new GuiButton(2, this.width / 2 - 74, this.height - 28, 70, 20, I18n.format("selectServer.delete", new Object[0])));
        this.btnSelectServer = this.addButton(new GuiButton(1, this.width / 2 - 154, this.height - 52, 100, 20, I18n.format("selectServer.select", new Object[0])));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 50, this.height - 52, 100, 20, I18n.format("selectServer.direct", new Object[0])));
        this.buttonList.add(new GuiButton(3, this.width / 2 + 4 + 50, this.height - 52, 100, 20, I18n.format("selectServer.add", new Object[0])));
        this.buttonList.add(new GuiButton(8, this.width / 2 + 4, this.height - 28, 70, 20, I18n.format("selectServer.refresh", new Object[0])));
        this.buttonList.add(new GuiButton(0, this.width / 2 + 4 + 76, this.height - 28, 75, 20, I18n.format("gui.cancel", new Object[0])));
        this.selectServer(this.serverListSelector.getSelected());
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    public ServerList getServerList() {
        return this.savedServerList;
    }
}
