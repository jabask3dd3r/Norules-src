package net.minecraft.client.gui;

import java.io.*;
import net.minecraft.client.resources.*;

public class GuiConfirmOpenLink extends GuiYesNo
{
    private final /* synthetic */ String copyLinkButtonText;
    private final /* synthetic */ String linkText;
    private /* synthetic */ boolean showSecurityWarning;
    private final /* synthetic */ String openLinkWarning;
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIllllIIllIIlIlIIll) throws IOException {
        if (lllllllllllllIIllllIIllIIlIlIIll.id == 2) {
            this.copyLinkToClipboard();
        }
        this.parentScreen.confirmClicked(lllllllllllllIIllllIIllIIlIlIIll.id == 0, this.parentButtonClickedId);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIllllIIllIIlIIIllI, final int lllllllllllllIIllllIIllIIlIIlIIl, final float lllllllllllllIIllllIIllIIlIIIlII) {
        super.drawScreen(lllllllllllllIIllllIIllIIlIIIllI, lllllllllllllIIllllIIllIIlIIlIIl, lllllllllllllIIllllIIllIIlIIIlII);
        if (this.showSecurityWarning) {
            this.drawCenteredString(this.fontRendererObj, this.openLinkWarning, this.width / 2, 110, 16764108);
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 50 - 105, this.height / 6 + 96, 100, 20, this.confirmButtonText));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 50, this.height / 6 + 96, 100, 20, this.copyLinkButtonText));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50 + 105, this.height / 6 + 96, 100, 20, this.cancelButtonText));
    }
    
    public void disableSecurityWarning() {
        this.showSecurityWarning = false;
    }
    
    public GuiConfirmOpenLink(final GuiYesNoCallback lllllllllllllIIllllIIllIIlIlllll, final String lllllllllllllIIllllIIllIIllIIIll, final int lllllllllllllIIllllIIllIIlIlllIl, final boolean lllllllllllllIIllllIIllIIllIIIIl) {
        super(lllllllllllllIIllllIIllIIlIlllll, I18n.format(lllllllllllllIIllllIIllIIllIIIIl ? "chat.link.confirmTrusted" : "chat.link.confirm", new Object[0]), lllllllllllllIIllllIIllIIllIIIll, lllllllllllllIIllllIIllIIlIlllIl);
        this.showSecurityWarning = true;
        this.confirmButtonText = I18n.format(lllllllllllllIIllllIIllIIllIIIIl ? "chat.link.open" : "gui.yes", new Object[0]);
        this.cancelButtonText = I18n.format(lllllllllllllIIllllIIllIIllIIIIl ? "gui.cancel" : "gui.no", new Object[0]);
        this.copyLinkButtonText = I18n.format("chat.copy", new Object[0]);
        this.openLinkWarning = I18n.format("chat.link.warning", new Object[0]);
        this.linkText = lllllllllllllIIllllIIllIIllIIIll;
    }
    
    public void copyLinkToClipboard() {
        GuiScreen.setClipboardString(this.linkText);
    }
}
