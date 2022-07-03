package net.minecraft.client.gui;

import java.io.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.resources.*;

public class GuiYesNo extends GuiScreen
{
    private final /* synthetic */ String messageLine2;
    protected /* synthetic */ String cancelButtonText;
    protected /* synthetic */ String confirmButtonText;
    protected /* synthetic */ GuiYesNoCallback parentScreen;
    protected /* synthetic */ String messageLine1;
    protected /* synthetic */ int parentButtonClickedId;
    private /* synthetic */ int ticksUntilEnable;
    private final /* synthetic */ List<String> listLines;
    
    @Override
    protected void actionPerformed(final GuiButton llllllllllllllIIlllllIIIIIIIlIlI) throws IOException {
        this.parentScreen.confirmClicked(llllllllllllllIIlllllIIIIIIIlIlI.id == 0, this.parentButtonClickedId);
    }
    
    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(0, this.width / 2 - 155, this.height / 6 + 96, this.confirmButtonText));
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 - 155 + 160, this.height / 6 + 96, this.cancelButtonText));
        this.listLines.clear();
        this.listLines.addAll(this.fontRendererObj.listFormattedStringToWidth(this.messageLine2, this.width - 50));
    }
    
    public GuiYesNo(final GuiYesNoCallback llllllllllllllIIlllllIIIIIlllIlI, final String llllllllllllllIIlllllIIIIIlllIIl, final String llllllllllllllIIlllllIIIIIlllIII, final int llllllllllllllIIlllllIIIIIllllII) {
        this.listLines = (List<String>)Lists.newArrayList();
        this.parentScreen = llllllllllllllIIlllllIIIIIlllIlI;
        this.messageLine1 = llllllllllllllIIlllllIIIIIlllIIl;
        this.messageLine2 = llllllllllllllIIlllllIIIIIlllIII;
        this.parentButtonClickedId = llllllllllllllIIlllllIIIIIllllII;
        this.confirmButtonText = I18n.format("gui.yes", new Object[0]);
        this.cancelButtonText = I18n.format("gui.no", new Object[0]);
    }
    
    public void setButtonDelay(final int llllllllllllllIIllllIlllllIIlllI) {
        this.ticksUntilEnable = llllllllllllllIIllllIlllllIIlllI;
        for (final GuiButton llllllllllllllIIllllIlllllIlIIlI : this.buttonList) {
            llllllllllllllIIllllIlllllIlIIlI.enabled = false;
        }
    }
    
    public GuiYesNo(final GuiYesNoCallback llllllllllllllIIlllllIIIIIIlllII, final String llllllllllllllIIlllllIIIIIlIIlll, final String llllllllllllllIIlllllIIIIIlIIlIl, final String llllllllllllllIIlllllIIIIIIlIllI, final String llllllllllllllIIlllllIIIIIlIIIIl, final int llllllllllllllIIlllllIIIIIlIIIII) {
        this.listLines = (List<String>)Lists.newArrayList();
        this.parentScreen = llllllllllllllIIlllllIIIIIIlllII;
        this.messageLine1 = llllllllllllllIIlllllIIIIIlIIlll;
        this.messageLine2 = llllllllllllllIIlllllIIIIIlIIlIl;
        this.confirmButtonText = llllllllllllllIIlllllIIIIIIlIllI;
        this.cancelButtonText = llllllllllllllIIlllllIIIIIlIIIIl;
        this.parentButtonClickedId = llllllllllllllIIlllllIIIIIlIIIII;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIIllllIllllllIIlIl, final int llllllllllllllIIllllIllllllIIIll, final float llllllllllllllIIllllIllllllIIIIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.messageLine1, this.width / 2, 70, 16777215);
        int llllllllllllllIIllllIllllllIlIll = 90;
        for (final String llllllllllllllIIllllIllllllIlIIl : this.listLines) {
            this.drawCenteredString(this.fontRendererObj, llllllllllllllIIllllIllllllIlIIl, this.width / 2, llllllllllllllIIllllIllllllIlIll, 16777215);
            llllllllllllllIIllllIllllllIlIll += this.fontRendererObj.FONT_HEIGHT;
        }
        super.drawScreen(llllllllllllllIIllllIllllllIIlIl, llllllllllllllIIllllIllllllIIIll, llllllllllllllIIllllIllllllIIIIl);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final int ticksUntilEnable = this.ticksUntilEnable - 1;
        this.ticksUntilEnable = ticksUntilEnable;
        if (ticksUntilEnable == 0) {
            for (final GuiButton llllllllllllllIIllllIllllIlllIlI : this.buttonList) {
                llllllllllllllIIllllIllllIlllIlI.enabled = true;
            }
        }
    }
}
