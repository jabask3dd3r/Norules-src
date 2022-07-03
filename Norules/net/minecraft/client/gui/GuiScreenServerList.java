package net.minecraft.client.gui;

import net.minecraft.client.multiplayer.*;
import java.io.*;
import org.lwjgl.input.*;
import net.minecraft.client.resources.*;

public class GuiScreenServerList extends GuiScreen
{
    private /* synthetic */ GuiTextField ipEdit;
    private final /* synthetic */ GuiScreen lastScreen;
    private final /* synthetic */ ServerData serverData;
    
    @Override
    protected void keyTyped(final char lllllllllllllllIIlIIlIIlllIIIlII, final int lllllllllllllllIIlIIlIIlllIIIllI) throws IOException {
        if (this.ipEdit.textboxKeyTyped(lllllllllllllllIIlIIlIIlllIIIlII, lllllllllllllllIIlIIlIIlllIIIllI)) {
            this.buttonList.get(0).enabled = (!this.ipEdit.getText().isEmpty() && this.ipEdit.getText().split(":").length > 0);
        }
        else if (lllllllllllllllIIlIIlIIlllIIIllI == 28 || lllllllllllllllIIlIIlIIlllIIIllI == 156) {
            this.actionPerformed(this.buttonList.get(0));
        }
    }
    
    @Override
    public void initGui() {
        Keyboard.enableRepeatEvents(true);
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96 + 12, I18n.format("selectServer.select", new Object[0])));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 120 + 12, I18n.format("gui.cancel", new Object[0])));
        this.ipEdit = new GuiTextField(2, this.fontRendererObj, this.width / 2 - 100, 116, 200, 20);
        this.ipEdit.setMaxStringLength(128);
        this.ipEdit.setFocused(true);
        this.ipEdit.setText(this.mc.gameSettings.lastServer);
        this.buttonList.get(0).enabled = (!this.ipEdit.getText().isEmpty() && this.ipEdit.getText().split(":").length > 0);
    }
    
    public GuiScreenServerList(final GuiScreen lllllllllllllllIIlIIlIIlllIlllII, final ServerData lllllllllllllllIIlIIlIIlllIllIll) {
        this.lastScreen = lllllllllllllllIIlIIlIIlllIlllII;
        this.serverData = lllllllllllllllIIlIIlIIlllIllIll;
    }
    
    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);
        this.mc.gameSettings.lastServer = this.ipEdit.getText();
        this.mc.gameSettings.saveOptions();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIIlIIlIIllIlIllIl, final int lllllllllllllllIIlIIlIIllIlIllII, final float lllllllllllllllIIlIIlIIllIlIlIll) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("selectServer.direct", new Object[0]), this.width / 2, 20, 16777215);
        this.drawString(this.fontRendererObj, I18n.format("addServer.enterIp", new Object[0]), this.width / 2 - 100, 100, 10526880);
        this.ipEdit.drawTextBox();
        super.drawScreen(lllllllllllllllIIlIIlIIllIlIllIl, lllllllllllllllIIlIIlIIllIlIllII, lllllllllllllllIIlIIlIIllIlIlIll);
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIIlIIlIIllIllllIl, final int lllllllllllllllIIlIIlIIllIlllIII, final int lllllllllllllllIIlIIlIIllIllIlll) throws IOException {
        super.mouseClicked(lllllllllllllllIIlIIlIIllIllllIl, lllllllllllllllIIlIIlIIllIlllIII, lllllllllllllllIIlIIlIIllIllIlll);
        this.ipEdit.mouseClicked(lllllllllllllllIIlIIlIIllIllllIl, lllllllllllllllIIlIIlIIllIlllIII, lllllllllllllllIIlIIlIIllIllIlll);
    }
    
    @Override
    public void updateScreen() {
        this.ipEdit.updateCursorCounter();
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIIlIIlIIlllIIlllI) throws IOException {
        if (lllllllllllllllIIlIIlIIlllIIlllI.enabled) {
            if (lllllllllllllllIIlIIlIIlllIIlllI.id == 1) {
                this.lastScreen.confirmClicked(false, 0);
            }
            else if (lllllllllllllllIIlIIlIIlllIIlllI.id == 0) {
                this.serverData.serverIP = this.ipEdit.getText();
                this.lastScreen.confirmClicked(true, 0);
            }
        }
    }
}
