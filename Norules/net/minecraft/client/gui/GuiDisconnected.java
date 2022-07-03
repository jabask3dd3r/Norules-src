package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.util.text.*;
import java.io.*;
import net.minecraft.client.resources.*;

public class GuiDisconnected extends GuiScreen
{
    private /* synthetic */ List<String> multilineMessage;
    private final /* synthetic */ String reason;
    private /* synthetic */ int textHeight;
    private final /* synthetic */ ITextComponent message;
    private final /* synthetic */ GuiScreen parentScreen;
    
    @Override
    public void drawScreen(final int lllllllllllllIIIIIIIIllIlIIIllIl, final int lllllllllllllIIIIIIIIllIlIIIllII, final float lllllllllllllIIIIIIIIllIlIIlIIIl) {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.reason, this.width / 2, this.height / 2 - this.textHeight / 2 - this.fontRendererObj.FONT_HEIGHT * 2, 11184810);
        int lllllllllllllIIIIIIIIllIlIIlIIII = this.height / 2 - this.textHeight / 2;
        if (this.multilineMessage != null) {
            for (final String lllllllllllllIIIIIIIIllIlIIIllll : this.multilineMessage) {
                this.drawCenteredString(this.fontRendererObj, lllllllllllllIIIIIIIIllIlIIIllll, this.width / 2, lllllllllllllIIIIIIIIllIlIIlIIII, 16777215);
                lllllllllllllIIIIIIIIllIlIIlIIII += this.fontRendererObj.FONT_HEIGHT;
            }
        }
        super.drawScreen(lllllllllllllIIIIIIIIllIlIIIllIl, lllllllllllllIIIIIIIIllIlIIIllII, lllllllllllllIIIIIIIIllIlIIlIIIl);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIIIIIIllIlIIllllI) throws IOException {
        if (lllllllllllllIIIIIIIIllIlIIllllI.id == 0) {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIIIIIIIIllIlIlIIllI, final int lllllllllllllIIIIIIIIllIlIlIIlIl) throws IOException {
    }
    
    @Override
    public void initGui() {
        this.buttonList.clear();
        this.multilineMessage = this.fontRendererObj.listFormattedStringToWidth(this.message.getFormattedText(), this.width - 50);
        this.textHeight = this.multilineMessage.size() * this.fontRendererObj.FONT_HEIGHT;
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, Math.min(this.height / 2 + this.textHeight / 2 + this.fontRendererObj.FONT_HEIGHT, this.height - 30), I18n.format("gui.toMenu", new Object[0])));
    }
    
    public GuiDisconnected(final GuiScreen lllllllllllllIIIIIIIIllIlIlIlIlI, final String lllllllllllllIIIIIIIIllIlIlIllIl, final ITextComponent lllllllllllllIIIIIIIIllIlIlIllII) {
        this.parentScreen = lllllllllllllIIIIIIIIllIlIlIlIlI;
        this.reason = I18n.format(lllllllllllllIIIIIIIIllIlIlIllIl, new Object[0]);
        this.message = lllllllllllllIIIIIIIIllIlIlIllII;
    }
}
