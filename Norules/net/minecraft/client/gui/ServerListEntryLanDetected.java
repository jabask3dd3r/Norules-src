package net.minecraft.client.gui;

import net.minecraft.client.network.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;

public class ServerListEntryLanDetected implements GuiListExtended.IGuiListEntry
{
    private final /* synthetic */ GuiMultiplayer screen;
    private /* synthetic */ long lastClickTime;
    protected final /* synthetic */ LanServerInfo serverData;
    protected final /* synthetic */ Minecraft mc;
    
    @Override
    public boolean mousePressed(final int lllllllllllllIIlIIIIlIllIIlIlIIl, final int lllllllllllllIIlIIIIlIllIIlIlIII, final int lllllllllllllIIlIIIIlIllIIlIIlll, final int lllllllllllllIIlIIIIlIllIIlIIllI, final int lllllllllllllIIlIIIIlIllIIlIIlIl, final int lllllllllllllIIlIIIIlIllIIlIIlII) {
        this.screen.selectServer(lllllllllllllIIlIIIIlIllIIlIlIIl);
        if (Minecraft.getSystemTime() - this.lastClickTime < 250L) {
            this.screen.connectToSelected();
        }
        this.lastClickTime = Minecraft.getSystemTime();
        return false;
    }
    
    public LanServerInfo getServerData() {
        return this.serverData;
    }
    
    @Override
    public void func_192634_a(final int lllllllllllllIIlIIIIlIllIIlllIII, final int lllllllllllllIIlIIIIlIllIIllIlll, final int lllllllllllllIIlIIIIlIllIIlIllIl, final int lllllllllllllIIlIIIIlIllIIllIlIl, final int lllllllllllllIIlIIIIlIllIIllIlII, final int lllllllllllllIIlIIIIlIllIIllIIll, final int lllllllllllllIIlIIIIlIllIIllIIlI, final boolean lllllllllllllIIlIIIIlIllIIllIIIl, final float lllllllllllllIIlIIIIlIllIIllIIII) {
        this.mc.fontRendererObj.drawString(I18n.format("lanServer.title", new Object[0]), lllllllllllllIIlIIIIlIllIIllIlll + 32 + 3, lllllllllllllIIlIIIIlIllIIlIllIl + 1, 16777215);
        this.mc.fontRendererObj.drawString(this.serverData.getServerMotd(), lllllllllllllIIlIIIIlIllIIllIlll + 32 + 3, lllllllllllllIIlIIIIlIllIIlIllIl + 12, 8421504);
        if (this.mc.gameSettings.hideServerAddress) {
            this.mc.fontRendererObj.drawString(I18n.format("selectServer.hiddenAddress", new Object[0]), lllllllllllllIIlIIIIlIllIIllIlll + 32 + 3, lllllllllllllIIlIIIIlIllIIlIllIl + 12 + 11, 3158064);
        }
        else {
            this.mc.fontRendererObj.drawString(this.serverData.getServerIpPort(), lllllllllllllIIlIIIIlIllIIllIlll + 32 + 3, lllllllllllllIIlIIIIlIllIIlIllIl + 12 + 11, 3158064);
        }
    }
    
    protected ServerListEntryLanDetected(final GuiMultiplayer lllllllllllllIIlIIIIlIllIIlllllI, final LanServerInfo lllllllllllllIIlIIIIlIllIlIIIIII) {
        this.screen = lllllllllllllIIlIIIIlIllIIlllllI;
        this.serverData = lllllllllllllIIlIIIIlIllIlIIIIII;
        this.mc = Minecraft.getMinecraft();
    }
    
    @Override
    public void mouseReleased(final int lllllllllllllIIlIIIIlIllIIIllIll, final int lllllllllllllIIlIIIIlIllIIIllIlI, final int lllllllllllllIIlIIIIlIllIIIllIIl, final int lllllllllllllIIlIIIIlIllIIIllIII, final int lllllllllllllIIlIIIIlIllIIIlIlll, final int lllllllllllllIIlIIIIlIllIIIlIllI) {
    }
    
    @Override
    public void func_192633_a(final int lllllllllllllIIlIIIIlIllIIlIIIII, final int lllllllllllllIIlIIIIlIllIIIlllll, final int lllllllllllllIIlIIIIlIllIIIllllI, final float lllllllllllllIIlIIIIlIllIIIlllIl) {
    }
}
