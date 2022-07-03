package net.minecraft.client.gui;

import javax.annotation.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.text.*;
import java.io.*;
import net.minecraft.client.multiplayer.*;

public class GuiGameOver extends GuiScreen
{
    private final /* synthetic */ ITextComponent causeOfDeath;
    private /* synthetic */ int enableButtonsTimer;
    
    public GuiGameOver(@Nullable final ITextComponent llllllllllllllIllIIIlIlIIlllllII) {
        this.causeOfDeath = llllllllllllllIllIIIlIlIIlllllII;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        ++this.enableButtonsTimer;
        if (this.enableButtonsTimer == 20) {
            for (final GuiButton llllllllllllllIllIIIlIIlllllIlII : this.buttonList) {
                llllllllllllllIllIIIlIIlllllIlII.enabled = true;
            }
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIllIIIlIlIIIIlIlIl, final int llllllllllllllIllIIIlIlIIIIllIlI, final float llllllllllllllIllIIIlIlIIIIlIIll) {
        final boolean llllllllllllllIllIIIlIlIIIIllIII = this.mc.world.getWorldInfo().isHardcoreModeEnabled();
        this.drawGradientRect(0.0, 0.0, this.width, this.height, 1615855616, -1602211792);
        GlStateManager.pushMatrix();
        GlStateManager.scale(2.0f, 2.0f, 2.0f);
        this.drawCenteredString(this.fontRendererObj, I18n.format(llllllllllllllIllIIIlIlIIIIllIII ? "deathScreen.title.hardcore" : "deathScreen.title", new Object[0]), this.width / 2 / 2, 30, 16777215);
        GlStateManager.popMatrix();
        if (this.causeOfDeath != null) {
            this.drawCenteredString(this.fontRendererObj, this.causeOfDeath.getFormattedText(), this.width / 2, 85, 16777215);
        }
        this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder(String.valueOf(I18n.format("deathScreen.score", new Object[0]))).append(": ").append(TextFormatting.YELLOW).append(this.mc.player.getScore())), this.width / 2, 100, 16777215);
        if (this.causeOfDeath != null && llllllllllllllIllIIIlIlIIIIllIlI > 85 && llllllllllllllIllIIIlIlIIIIllIlI < 85 + this.fontRendererObj.FONT_HEIGHT) {
            final ITextComponent llllllllllllllIllIIIlIlIIIIlIlll = this.getClickedComponentAt(llllllllllllllIllIIIlIlIIIIlIlIl);
            if (llllllllllllllIllIIIlIlIIIIlIlll != null && llllllllllllllIllIIIlIlIIIIlIlll.getStyle().getHoverEvent() != null) {
                this.handleComponentHover(llllllllllllllIllIIIlIlIIIIlIlll, llllllllllllllIllIIIlIlIIIIlIlIl, llllllllllllllIllIIIlIlIIIIllIlI);
            }
        }
        super.drawScreen(llllllllllllllIllIIIlIlIIIIlIlIl, llllllllllllllIllIIIlIlIIIIllIlI, llllllllllllllIllIIIlIlIIIIlIIll);
    }
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIllIIIlIlIIlIIIIlI) throws IOException {
        switch (llllllllllllllIllIIIlIlIIlIIIIlI.id) {
            case 0: {
                this.mc.player.respawnPlayer();
                this.mc.displayGuiScreen(null);
                break;
            }
            case 1: {
                if (this.mc.world.getWorldInfo().isHardcoreModeEnabled()) {
                    this.mc.displayGuiScreen(new GuiMainMenu());
                    break;
                }
                final GuiYesNo llllllllllllllIllIIIlIlIIlIIIllI = new GuiYesNo(this, I18n.format("deathScreen.quit.confirm", new Object[0]), "", I18n.format("deathScreen.titleScreen", new Object[0]), I18n.format("deathScreen.respawn", new Object[0]), 0);
                this.mc.displayGuiScreen(llllllllllllllIllIIIlIlIIlIIIllI);
                llllllllllllllIllIIIlIlIIlIIIllI.setButtonDelay(20);
                break;
            }
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIllIIIlIlIIlIlIllI, final int llllllllllllllIllIIIlIlIIlIlIlIl) throws IOException {
    }
    
    @Nullable
    public ITextComponent getClickedComponentAt(final int llllllllllllllIllIIIlIlIIIIIIIII) {
        if (this.causeOfDeath == null) {
            return null;
        }
        final int llllllllllllllIllIIIlIlIIIIIIllI = this.mc.fontRendererObj.getStringWidth(this.causeOfDeath.getFormattedText());
        final int llllllllllllllIllIIIlIlIIIIIIlIl = this.width / 2 - llllllllllllllIllIIIlIlIIIIIIllI / 2;
        final int llllllllllllllIllIIIlIlIIIIIIlII = this.width / 2 + llllllllllllllIllIIIlIlIIIIIIllI / 2;
        int llllllllllllllIllIIIlIlIIIIIIIll = llllllllllllllIllIIIlIlIIIIIIlIl;
        if (llllllllllllllIllIIIlIlIIIIIIIII >= llllllllllllllIllIIIlIlIIIIIIlIl && llllllllllllllIllIIIlIlIIIIIIIII <= llllllllllllllIllIIIlIlIIIIIIlII) {
            for (final ITextComponent llllllllllllllIllIIIlIlIIIIIIIlI : this.causeOfDeath) {
                llllllllllllllIllIIIlIlIIIIIIIll += this.mc.fontRendererObj.getStringWidth(GuiUtilRenderComponents.removeTextColorsIfConfigured(llllllllllllllIllIIIlIlIIIIIIIlI.getUnformattedComponentText(), false));
                if (llllllllllllllIllIIIlIlIIIIIIIll > llllllllllllllIllIIIlIlIIIIIIIII) {
                    return llllllllllllllIllIIIlIlIIIIIIIlI;
                }
            }
            return null;
        }
        return null;
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllIllIIIlIlIIIlIllIl, final int llllllllllllllIllIIIlIlIIIlIllll) {
        if (llllllllllllllIllIIIlIlIIIlIllIl) {
            if (this.mc.world != null) {
                this.mc.world.sendQuittingDisconnectingPacket();
            }
            this.mc.loadWorld(null);
            this.mc.displayGuiScreen(new GuiMainMenu());
        }
        else {
            this.mc.player.respawnPlayer();
            this.mc.displayGuiScreen(null);
        }
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.enableButtonsTimer = 0;
        if (this.mc.world.getWorldInfo().isHardcoreModeEnabled()) {
            this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 72, I18n.format("deathScreen.spectate", new Object[0])));
            this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.format(String.valueOf(new StringBuilder("deathScreen.").append(this.mc.isIntegratedServerRunning() ? "deleteWorld" : "leaveServer")), new Object[0])));
        }
        else {
            this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 72, I18n.format("deathScreen.respawn", new Object[0])));
            this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.format("deathScreen.titleScreen", new Object[0])));
            if (this.mc.getSession() == null) {
                this.buttonList.get(1).enabled = false;
            }
        }
        for (final GuiButton llllllllllllllIllIIIlIlIIllIIIIl : this.buttonList) {
            llllllllllllllIllIIIlIlIIllIIIIl.enabled = false;
        }
    }
}
