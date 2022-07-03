package net.minecraft.client.gui;

import net.minecraft.client.resources.*;
import java.io.*;

public class GuiErrorScreen extends GuiScreen
{
    private final /* synthetic */ String message;
    private final /* synthetic */ String title;
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, 140, I18n.format("gui.cancel", new Object[0])));
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlllIlIlllIIllIIIIl, final int lllllllllllllIlllIlIlllIIllIIlII, final float lllllllllllllIlllIlIlllIIlIlllll) {
        this.drawGradientRect(0.0, 0.0, this.width, this.height, -12574688, -11530224);
        this.drawCenteredString(this.fontRendererObj, this.title, this.width / 2, 90, 16777215);
        this.drawCenteredString(this.fontRendererObj, this.message, this.width / 2, 110, 16777215);
        super.drawScreen(lllllllllllllIlllIlIlllIIllIIIIl, lllllllllllllIlllIlIlllIIllIIlII, lllllllllllllIlllIlIlllIIlIlllll);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIlllIlIlllIIlIlllIl, final int lllllllllllllIlllIlIlllIIlIlllII) throws IOException {
    }
    
    public GuiErrorScreen(final String lllllllllllllIlllIlIlllIIllIllll, final String lllllllllllllIlllIlIlllIIllIlllI) {
        this.title = lllllllllllllIlllIlIlllIIllIllll;
        this.message = lllllllllllllIlllIlIlllIIllIlllI;
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIlllIlIlllIIlIllIIl) throws IOException {
        this.mc.displayGuiScreen(null);
    }
}
