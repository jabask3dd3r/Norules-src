package net.minecraft.client.gui;

import net.minecraft.client.resources.*;

public class GuiDownloadTerrain extends GuiScreen
{
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlIIIllIllIlIIlIIIl, final int lllllllllllllIlIIIllIllIlIIlIIII, final float lllllllllllllIlIIIllIllIlIIIllll) {
        this.drawBackground(0);
        this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingTerrain", new Object[0]), this.width / 2, this.height / 2 - 50, 16777215);
        super.drawScreen(lllllllllllllIlIIIllIllIlIIlIIIl, lllllllllllllIlIIIllIllIlIIlIIII, lllllllllllllIlIIIllIllIlIIIllll);
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
    }
}
