package net.minecraft.client.gui;

import com.google.common.collect.*;
import java.util.*;
import java.io.*;
import net.minecraft.realms.*;
import net.minecraft.item.*;

public class GuiScreenRealmsProxy extends GuiScreen
{
    private final /* synthetic */ RealmsScreen proxy;
    
    public GuiScreenRealmsProxy(final RealmsScreen llllllllllllllllIIIIIIlIllIlIIII) {
        this.proxy = llllllllllllllllIIIIIIlIllIlIIII;
        this.buttonList = Collections.synchronizedList((List<GuiButton>)Lists.newArrayList());
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        this.proxy.mouseEvent();
        super.handleMouseInput();
    }
    
    @Override
    public void drawTexturedModalRect(final int llllllllllllllllIIIIIIlIlIIllIIl, final int llllllllllllllllIIIIIIlIlIIllIII, final int llllllllllllllllIIIIIIlIlIIlIlll, final int llllllllllllllllIIIIIIlIlIIlIllI, final int llllllllllllllllIIIIIIlIlIIlIlIl, final int llllllllllllllllIIIIIIlIlIIllIll) {
        this.proxy.blit(llllllllllllllllIIIIIIlIlIIllIIl, llllllllllllllllIIIIIIlIlIIllIII, llllllllllllllllIIIIIIlIlIIlIlll, llllllllllllllllIIIIIIlIlIIlIllI, llllllllllllllllIIIIIIlIlIIlIlIl, llllllllllllllllIIIIIIlIlIIllIll);
        super.drawTexturedModalRect(llllllllllllllllIIIIIIlIlIIllIIl, llllllllllllllllIIIIIIlIlIIllIII, llllllllllllllllIIIIIIlIlIIlIlll, llllllllllllllllIIIIIIlIlIIlIllI, llllllllllllllllIIIIIIlIlIIlIlIl, llllllllllllllllIIIIIIlIlIIllIll);
    }
    
    public void fontDrawShadow(final String llllllllllllllllIIIIIIlIIIlIlIll, final int llllllllllllllllIIIIIIlIIIlIllll, final int llllllllllllllllIIIIIIlIIIlIlllI, final int llllllllllllllllIIIIIIlIIIlIllIl) {
        this.fontRendererObj.drawStringWithShadow(llllllllllllllllIIIIIIlIIIlIlIll, (float)llllllllllllllllIIIIIIlIIIlIllll, (float)llllllllllllllllIIIIIIlIIIlIlllI, llllllllllllllllIIIIIIlIIIlIllIl);
    }
    
    public void buttonsAdd(final RealmsButton llllllllllllllllIIIIIIlIIIIlIIlI) {
        this.buttonList.add(llllllllllllllllIIIIIIlIIIIlIIlI.getProxy());
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return super.doesGuiPauseGame();
    }
    
    public RealmsScreen getProxy() {
        return this.proxy;
    }
    
    public void mouseClickMove(final int llllllllllllllllIIIIIIIlllIlIlIl, final int llllllllllllllllIIIIIIIlllIllIIl, final int llllllllllllllllIIIIIIIlllIllIII, final long llllllllllllllllIIIIIIIlllIlIIlI) {
        this.proxy.mouseDragged(llllllllllllllllIIIIIIIlllIlIlIl, llllllllllllllllIIIIIIIlllIllIIl, llllllllllllllllIIIIIIIlllIllIII, llllllllllllllllIIIIIIIlllIlIIlI);
    }
    
    public final void actionPerformed(final GuiButton llllllllllllllllIIIIIIlIIIIllIll) throws IOException {
        this.proxy.buttonClicked(((GuiButtonRealmsProxy)llllllllllllllllIIIIIIlIIIIllIll).getRealmsButton());
    }
    
    @Override
    public void drawWorldBackground(final int llllllllllllllllIIIIIIlIIlllIIll) {
        super.drawWorldBackground(llllllllllllllllIIIIIIlIIlllIIll);
    }
    
    public List<RealmsButton> buttons() {
        final List<RealmsButton> llllllllllllllllIIIIIIlIIIIIlIlI = (List<RealmsButton>)Lists.newArrayListWithExpectedSize(this.buttonList.size());
        for (final GuiButton llllllllllllllllIIIIIIlIIIIIlIIl : this.buttonList) {
            llllllllllllllllIIIIIIlIIIIIlIlI.add(((GuiButtonRealmsProxy)llllllllllllllllIIIIIIlIIIIIlIIl).getRealmsButton());
        }
        return llllllllllllllllIIIIIIlIIIIIlIlI;
    }
    
    public void buttonsClear() {
        this.buttonList.clear();
    }
    
    @Override
    public void updateScreen() {
        this.proxy.tick();
        super.updateScreen();
    }
    
    public void mouseClicked(final int llllllllllllllllIIIIIIIllllllIIl, final int llllllllllllllllIIIIIIIllllllIII, final int llllllllllllllllIIIIIIIlllllIIll) throws IOException {
        this.proxy.mouseClicked(llllllllllllllllIIIIIIIllllllIIl, llllllllllllllllIIIIIIIllllllIII, llllllllllllllllIIIIIIIlllllIIll);
        super.mouseClicked(llllllllllllllllIIIIIIIllllllIIl, llllllllllllllllIIIIIIIllllllIII, llllllllllllllllIIIIIIIlllllIIll);
    }
    
    public void keyTyped(final char llllllllllllllllIIIIIIIlllIIllIl, final int llllllllllllllllIIIIIIIlllIIlIIl) throws IOException {
        this.proxy.keyPressed(llllllllllllllllIIIIIIIlllIIllIl, llllllllllllllllIIIIIIIlllIIlIIl);
    }
    
    public void renderToolTip(final ItemStack llllllllllllllllIIIIIIlIIllIIIIl, final int llllllllllllllllIIIIIIlIIlIlllII, final int llllllllllllllllIIIIIIlIIlIllIll) {
        super.renderToolTip(llllllllllllllllIIIIIIlIIllIIIIl, llllllllllllllllIIIIIIlIIlIlllII, llllllllllllllllIIIIIIlIIlIllIll);
    }
    
    @Override
    public void drawScreen(final int llllllllllllllllIIIIIIlIIllIlIIl, final int llllllllllllllllIIIIIIlIIllIllII, final float llllllllllllllllIIIIIIlIIllIIlll) {
        this.proxy.render(llllllllllllllllIIIIIIlIIllIlIIl, llllllllllllllllIIIIIIlIIllIllII, llllllllllllllllIIIIIIlIIllIIlll);
    }
    
    @Override
    public void drawHoveringText(final List<String> llllllllllllllllIIIIIIlIIlIIlIIl, final int llllllllllllllllIIIIIIlIIlIIlIII, final int llllllllllllllllIIIIIIlIIlIIIIll) {
        super.drawHoveringText(llllllllllllllllIIIIIIlIIlIIlIIl, llllllllllllllllIIIIIIlIIlIIlIII, llllllllllllllllIIIIIIlIIlIIIIll);
    }
    
    @Override
    public void drawDefaultBackground() {
        super.drawDefaultBackground();
    }
    
    public int getStringWidth(final String llllllllllllllllIIIIIIlIIIlllIIl) {
        return this.fontRendererObj.getStringWidth(llllllllllllllllIIIIIIlIIIlllIIl);
    }
    
    public List<String> fontSplit(final String llllllllllllllllIIIIIIlIIIlIIIll, final int llllllllllllllllIIIIIIlIIIlIIIlI) {
        return this.fontRendererObj.listFormattedStringToWidth(llllllllllllllllIIIIIIlIIIlIIIll, llllllllllllllllIIIIIIlIIIlIIIlI);
    }
    
    @Override
    public void confirmClicked(final boolean llllllllllllllllIIIIIIIlllIIIlII, final int llllllllllllllllIIIIIIIlllIIIIII) {
        this.proxy.confirmResult(llllllllllllllllIIIIIIIlllIIIlII, llllllllllllllllIIIIIIIlllIIIIII);
    }
    
    @Override
    public void onGuiClosed() {
        this.proxy.removed();
        super.onGuiClosed();
    }
    
    @Override
    public void drawCreativeTabHoveringText(final String llllllllllllllllIIIIIIlIIlIlIIIl, final int llllllllllllllllIIIIIIlIIlIlIlII, final int llllllllllllllllIIIIIIlIIlIlIIll) {
        super.drawCreativeTabHoveringText(llllllllllllllllIIIIIIlIIlIlIIIl, llllllllllllllllIIIIIIlIIlIlIlII, llllllllllllllllIIIIIIlIIlIlIIll);
    }
    
    @Override
    public void handleKeyboardInput() throws IOException {
        this.proxy.keyboardEvent();
        super.handleKeyboardInput();
    }
    
    public void mouseReleased(final int llllllllllllllllIIIIIIIllllIIIll, final int llllllllllllllllIIIIIIIllllIIllI, final int llllllllllllllllIIIIIIIllllIIlIl) {
        this.proxy.mouseReleased(llllllllllllllllIIIIIIIllllIIIll, llllllllllllllllIIIIIIIllllIIllI, llllllllllllllllIIIIIIIllllIIlIl);
    }
    
    public int getFontHeight() {
        return this.fontRendererObj.FONT_HEIGHT;
    }
    
    public void drawCenteredString(final String llllllllllllllllIIIIIIlIllIIIIll, final int llllllllllllllllIIIIIIlIlIllllIl, final int llllllllllllllllIIIIIIlIllIIIIIl, final int llllllllllllllllIIIIIIlIllIIIIII) {
        super.drawCenteredString(this.fontRendererObj, llllllllllllllllIIIIIIlIllIIIIll, llllllllllllllllIIIIIIlIlIllllIl, llllllllllllllllIIIIIIlIllIIIIIl, llllllllllllllllIIIIIIlIllIIIIII);
    }
    
    public void drawGradientRect(final int llllllllllllllllIIIIIIlIlIIIIlII, final int llllllllllllllllIIIIIIlIlIIIIIll, final int llllllllllllllllIIIIIIlIlIIIIIlI, final int llllllllllllllllIIIIIIlIlIIIlIII, final int llllllllllllllllIIIIIIlIlIIIIIII, final int llllllllllllllllIIIIIIlIIlllllll) {
        super.drawGradientRect(llllllllllllllllIIIIIIlIlIIIIlII, llllllllllllllllIIIIIIlIlIIIIIll, llllllllllllllllIIIIIIlIlIIIIIlI, llllllllllllllllIIIIIIlIlIIIlIII, llllllllllllllllIIIIIIlIlIIIIIII, llllllllllllllllIIIIIIlIIlllllll);
    }
    
    @Override
    public void initGui() {
        this.proxy.init();
        super.initGui();
    }
    
    public void drawString(final String llllllllllllllllIIIIIIlIlIlIllIl, final int llllllllllllllllIIIIIIlIlIlIllII, final int llllllllllllllllIIIIIIlIlIllIIIl, final int llllllllllllllllIIIIIIlIlIllIIII, final boolean llllllllllllllllIIIIIIlIlIlIllll) {
        if (llllllllllllllllIIIIIIlIlIlIllll) {
            super.drawString(this.fontRendererObj, llllllllllllllllIIIIIIlIlIlIllIl, llllllllllllllllIIIIIIlIlIlIllII, llllllllllllllllIIIIIIlIlIllIIIl, llllllllllllllllIIIIIIlIlIllIIII);
        }
        else {
            this.fontRendererObj.drawString(llllllllllllllllIIIIIIlIlIlIllIl, llllllllllllllllIIIIIIlIlIlIllII, llllllllllllllllIIIIIIlIlIllIIIl, llllllllllllllllIIIIIIlIlIllIIII);
        }
    }
    
    public void buttonsRemove(final RealmsButton llllllllllllllllIIIIIIIlllllllll) {
        this.buttonList.remove(llllllllllllllllIIIIIIIlllllllll.getProxy());
    }
}
