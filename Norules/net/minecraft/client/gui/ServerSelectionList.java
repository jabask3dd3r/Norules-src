package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.network.*;
import net.minecraft.client.*;
import com.google.common.collect.*;

public class ServerSelectionList extends GuiListExtended
{
    private /* synthetic */ int selectedSlotIndex;
    private final /* synthetic */ IGuiListEntry lanScanEntry;
    private final /* synthetic */ List<ServerListEntryLanDetected> serverListLan;
    private final /* synthetic */ GuiMultiplayer owner;
    private final /* synthetic */ List<ServerListEntryNormal> serverListInternet;
    
    public void updateOnlineServers(final ServerList llllllllllllllIIIIIIllllIlIllIll) {
        this.serverListInternet.clear();
        for (int llllllllllllllIIIIIIllllIlIlllIl = 0; llllllllllllllIIIIIIllllIlIlllIl < llllllllllllllIIIIIIllllIlIllIll.countServers(); ++llllllllllllllIIIIIIllllIlIlllIl) {
            this.serverListInternet.add(new ServerListEntryNormal(this.owner, llllllllllllllIIIIIIllllIlIllIll.getServerData(llllllllllllllIIIIIIllllIlIlllIl)));
        }
    }
    
    public int getSelected() {
        return this.selectedSlotIndex;
    }
    
    public void updateNetworkServers(final List<LanServerInfo> llllllllllllllIIIIIIllllIlIlIIIl) {
        this.serverListLan.clear();
        for (final LanServerInfo llllllllllllllIIIIIIllllIlIlIIll : llllllllllllllIIIIIIllllIlIlIIIl) {
            this.serverListLan.add(new ServerListEntryLanDetected(this.owner, llllllllllllllIIIIIIllllIlIlIIll));
        }
    }
    
    @Override
    public int getListWidth() {
        return super.getListWidth() + 85;
    }
    
    public void setSelectedSlotIndex(final int llllllllllllllIIIIIIllllIllIlllI) {
        this.selectedSlotIndex = llllllllllllllIIIIIIllllIllIlllI;
    }
    
    @Override
    protected boolean isSelected(final int llllllllllllllIIIIIIllllIllIlIII) {
        return llllllllllllllIIIIIIllllIllIlIII == this.selectedSlotIndex;
    }
    
    @Override
    protected int getSize() {
        return this.serverListInternet.size() + 1 + this.serverListLan.size();
    }
    
    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 30;
    }
    
    @Override
    public IGuiListEntry getListEntry(int llllllllllllllIIIIIIllllIlllIlIl) {
        if (llllllllllllllIIIIIIllllIlllIlIl < this.serverListInternet.size()) {
            return this.serverListInternet.get(llllllllllllllIIIIIIllllIlllIlIl);
        }
        llllllllllllllIIIIIIllllIlllIlIl -= this.serverListInternet.size();
        if (llllllllllllllIIIIIIllllIlllIlIl == 0) {
            return this.lanScanEntry;
        }
        --llllllllllllllIIIIIIllllIlllIlIl;
        return this.serverListLan.get(llllllllllllllIIIIIIllllIlllIlIl);
    }
    
    public ServerSelectionList(final GuiMultiplayer llllllllllllllIIIIIIlllllIIIIIIl, final Minecraft llllllllllllllIIIIIIlllllIIIIIII, final int llllllllllllllIIIIIIlllllIIIIlll, final int llllllllllllllIIIIIIlllllIIIIllI, final int llllllllllllllIIIIIIllllIlllllIl, final int llllllllllllllIIIIIIlllllIIIIlII, final int llllllllllllllIIIIIIlllllIIIIIll) {
        super(llllllllllllllIIIIIIlllllIIIIIII, llllllllllllllIIIIIIlllllIIIIlll, llllllllllllllIIIIIIlllllIIIIllI, llllllllllllllIIIIIIllllIlllllIl, llllllllllllllIIIIIIlllllIIIIlII, llllllllllllllIIIIIIlllllIIIIIll);
        this.serverListInternet = (List<ServerListEntryNormal>)Lists.newArrayList();
        this.serverListLan = (List<ServerListEntryLanDetected>)Lists.newArrayList();
        this.lanScanEntry = new ServerListEntryLanScan();
        this.selectedSlotIndex = -1;
        this.owner = llllllllllllllIIIIIIlllllIIIIIIl;
    }
}
