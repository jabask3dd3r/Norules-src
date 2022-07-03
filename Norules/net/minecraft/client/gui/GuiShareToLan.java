package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import net.minecraft.world.*;
import net.minecraft.util.text.*;
import java.io.*;

public class GuiShareToLan extends GuiScreen
{
    private /* synthetic */ GuiButton gameModeButton;
    private /* synthetic */ GuiButton allowCheatsButton;
    private final /* synthetic */ GuiScreen lastScreen;
    private /* synthetic */ boolean allowCheats;
    private /* synthetic */ String gameMode;
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(101, this.width / 2 - 155, this.height - 28, 150, 20, I18n.format("lanServer.start", new Object[0])));
        this.buttonList.add(new GuiButton(102, this.width / 2 + 5, this.height - 28, 150, 20, I18n.format("gui.cancel", new Object[0])));
        this.gameModeButton = this.addButton(new GuiButton(104, this.width / 2 - 155, 100, 150, 20, I18n.format("selectWorld.gameMode", new Object[0])));
        this.allowCheatsButton = this.addButton(new GuiButton(103, this.width / 2 + 5, 100, 150, 20, I18n.format("selectWorld.allowCommands", new Object[0])));
        this.updateDisplayNames();
    }
    
    private void updateDisplayNames() {
        this.gameModeButton.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.gameMode", new Object[0]))).append(": ").append(I18n.format(String.valueOf(new StringBuilder("selectWorld.gameMode.").append(this.gameMode)), new Object[0])));
        this.allowCheatsButton.displayString = String.valueOf(new StringBuilder(String.valueOf(I18n.format("selectWorld.allowCommands", new Object[0]))).append(" "));
        if (this.allowCheats) {
            this.allowCheatsButton.displayString = String.valueOf(new StringBuilder(String.valueOf(this.allowCheatsButton.displayString)).append(I18n.format("options.on", new Object[0])));
        }
        else {
            this.allowCheatsButton.displayString = String.valueOf(new StringBuilder(String.valueOf(this.allowCheatsButton.displayString)).append(I18n.format("options.off", new Object[0])));
        }
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIllIIIIllllllIlIlI, final int llllllllllllllIllIIIIllllllIIIII, final float llllllllllllllIllIIIIlllllIllllI) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, I18n.format("lanServer.title", new Object[0]), this.width / 2, 50, 16777215);
        this.drawCenteredString(this.fontRendererObj, I18n.format("lanServer.otherPlayers", new Object[0]), this.width / 2, 82, 16777215);
        super.drawScreen(llllllllllllllIllIIIIllllllIlIlI, llllllllllllllIllIIIIllllllIIIII, llllllllllllllIllIIIIlllllIllllI);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIllIIIIllllllllllI) throws IOException {
        if (llllllllllllllIllIIIIllllllllllI.id == 102) {
            this.mc.displayGuiScreen(this.lastScreen);
        }
        else if (llllllllllllllIllIIIIllllllllllI.id == 104) {
            if ("spectator".equals(this.gameMode)) {
                this.gameMode = "creative";
            }
            else if ("creative".equals(this.gameMode)) {
                this.gameMode = "adventure";
            }
            else if ("adventure".equals(this.gameMode)) {
                this.gameMode = "survival";
            }
            else {
                this.gameMode = "spectator";
            }
            this.updateDisplayNames();
        }
        else if (llllllllllllllIllIIIIllllllllllI.id == 103) {
            this.allowCheats = !this.allowCheats;
            this.updateDisplayNames();
        }
        else if (llllllllllllllIllIIIIllllllllllI.id == 101) {
            this.mc.displayGuiScreen(null);
            final String llllllllllllllIllIIIlIIIIIIIIIll = this.mc.getIntegratedServer().shareToLAN(GameType.getByName(this.gameMode), this.allowCheats);
            ITextComponent llllllllllllllIllIIIlIIIIIIIIIIl = null;
            if (llllllllllllllIllIIIlIIIIIIIIIll != null) {
                final ITextComponent llllllllllllllIllIIIlIIIIIIIIIlI = new TextComponentTranslation("commands.publish.started", new Object[] { llllllllllllllIllIIIlIIIIIIIIIll });
            }
            else {
                llllllllllllllIllIIIlIIIIIIIIIIl = new TextComponentString("commands.publish.failed");
            }
            this.mc.ingameGUI.getChatGUI().printChatMessage(llllllllllllllIllIIIlIIIIIIIIIIl);
        }
    }
    
    public GuiShareToLan(final GuiScreen llllllllllllllIllIIIlIIIIIlllIII) {
        this.gameMode = "survival";
        this.lastScreen = llllllllllllllIllIIIlIIIIIlllIII;
    }
}
