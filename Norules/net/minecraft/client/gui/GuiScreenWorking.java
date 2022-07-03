package net.minecraft.client.gui;

import net.minecraft.util.*;

public class GuiScreenWorking extends GuiScreen implements IProgressUpdate
{
    private /* synthetic */ String stage;
    private /* synthetic */ boolean doneWorking;
    private /* synthetic */ String title;
    private /* synthetic */ int progress;
    
    @Override
    public void setDoneWorking() {
        this.doneWorking = true;
    }
    
    @Override
    public void resetProgressAndMessage(final String lllllllllllllIIllIIIllIlIIIIIlIl) {
        this.title = lllllllllllllIIllIIIllIlIIIIIlIl;
        this.displayLoadingString("Working...");
    }
    
    @Override
    public void displayLoadingString(final String lllllllllllllIIllIIIllIIllllllll) {
        this.stage = lllllllllllllIIllIIIllIIllllllll;
        this.setLoadingProgress(0);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIllIIIllIIlllIlIlI, final int lllllllllllllIIllIIIllIIlllIllIl, final float lllllllllllllIIllIIIllIIlllIllII) {
        if (this.doneWorking) {
            if (!this.mc.isConnectedToRealms()) {
                this.mc.displayGuiScreen(null);
            }
        }
        else {
            this.drawDefaultBackground();
            this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 70, 16777215);
            this.drawCenteredString(this.fontRendererObj, String.valueOf(new StringBuilder(String.valueOf(this.stage)).append(" ").append(this.progress).append("%")), this.width / 2, 90, 16777215);
            super.drawScreen(lllllllllllllIIllIIIllIIlllIlIlI, lllllllllllllIIllIIIllIIlllIllIl, lllllllllllllIIllIIIllIIlllIllII);
        }
    }
    
    @Override
    public void setLoadingProgress(final int lllllllllllllIIllIIIllIIllllIlll) {
        this.progress = lllllllllllllIIllIIIllIIllllIlll;
    }
    
    @Override
    public void displaySavingString(final String lllllllllllllIIllIIIllIlIIIIlIll) {
        this.resetProgressAndMessage(lllllllllllllIIllIIIllIlIIIIlIll);
    }
    
    public GuiScreenWorking() {
        this.title = "";
        this.stage = "";
    }
}
