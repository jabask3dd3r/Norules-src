package net.minecraft.realms;

import net.minecraft.client.gui.*;

public class RealmsClickableScrolledSelectionList
{
    private final /* synthetic */ GuiClickableScrolledSelectionListProxy proxy;
    
    public int ym() {
        return this.proxy.mouseY();
    }
    
    public int getScrollbarPosition() {
        return this.proxy.width() / 2 + 124;
    }
    
    public int getItemCount() {
        return 0;
    }
    
    public int width() {
        return this.proxy.width();
    }
    
    public int getMaxPosition() {
        return 0;
    }
    
    public boolean isSelectedItem(final int lllllllllllllIIlIlIlIlIIlIIlIlll) {
        return false;
    }
    
    protected void renderItem(final int lllllllllllllIIlIlIlIlIIlIlllIlI, final int lllllllllllllIIlIlIlIlIIlIlllIIl, final int lllllllllllllIIlIlIlIlIIlIlllIII, final int lllllllllllllIIlIlIlIlIIlIllIlll, final Tezzelator lllllllllllllIIlIlIlIlIIlIllIllI, final int lllllllllllllIIlIlIlIlIIlIllIlIl, final int lllllllllllllIIlIlIlIlIIlIllIlII) {
    }
    
    public void setLeftPos(final int lllllllllllllIIlIlIlIlIIIllIllII) {
        this.proxy.setSlotXBoundsFromLeft(lllllllllllllIIlIlIlIlIIIllIllII);
    }
    
    public void selectItem(final int lllllllllllllIIlIlIlIlIIlIIlllII, final boolean lllllllllllllIIlIlIlIlIIlIIllIll, final int lllllllllllllIIlIlIlIlIIlIIllIlI, final int lllllllllllllIIlIlIlIlIIlIIllIIl) {
    }
    
    public void mouseEvent() {
        this.proxy.handleMouseInput();
    }
    
    public void scroll(final int lllllllllllllIIlIlIlIlIIlIIIIlIl) {
        this.proxy.scrollBy(lllllllllllllIIlIlIlIlIIlIIIIlIl);
    }
    
    public void renderItem(final int lllllllllllllIIlIlIlIlIIlIlIlIll, final int lllllllllllllIIlIlIlIlIIlIlIlIlI, final int lllllllllllllIIlIlIlIlIIlIlIIIlI, final int lllllllllllllIIlIlIlIlIIlIlIIIIl, final int lllllllllllllIIlIlIlIlIIlIlIIlll, final int lllllllllllllIIlIlIlIlIIlIIlllll) {
        this.renderItem(lllllllllllllIIlIlIlIlIIlIlIlIll, lllllllllllllIIlIlIlIlIIlIlIlIlI, lllllllllllllIIlIlIlIlIIlIlIIIlI, lllllllllllllIIlIlIlIlIIlIlIIIIl, Tezzelator.instance, lllllllllllllIIlIlIlIlIIlIlIIlll, lllllllllllllIIlIlIlIlIIlIIlllll);
    }
    
    public void renderSelected(final int lllllllllllllIIlIlIlIlIIIlllIIll, final int lllllllllllllIIlIlIlIlIIIlllIIlI, final int lllllllllllllIIlIlIlIlIIIlllIIIl, final Tezzelator lllllllllllllIIlIlIlIlIIIlllIIII) {
    }
    
    public RealmsClickableScrolledSelectionList(final int lllllllllllllIIlIlIlIlIIllIllIll, final int lllllllllllllIIlIlIlIlIIllIllIlI, final int lllllllllllllIIlIlIlIlIIllIllIIl, final int lllllllllllllIIlIlIlIlIIllIlIIlI, final int lllllllllllllIIlIlIlIlIIllIlIIIl) {
        this.proxy = new GuiClickableScrolledSelectionListProxy(this, lllllllllllllIIlIlIlIlIIllIllIll, lllllllllllllIIlIlIlIlIIllIllIlI, lllllllllllllIIlIlIlIlIIllIllIIl, lllllllllllllIIlIlIlIlIIllIlIIlI, lllllllllllllIIlIlIlIlIIllIlIIIl);
    }
    
    public void itemClicked(final int lllllllllllllIIlIlIlIlIIIllllIIl, final int lllllllllllllIIlIlIlIlIIIllllIII, final int lllllllllllllIIlIlIlIlIIIlllIlll, final int lllllllllllllIIlIlIlIlIIIlllIllI, final int lllllllllllllIIlIlIlIlIIIlllIlIl) {
    }
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    public void render(final int lllllllllllllIIlIlIlIlIIllIIlIll, final int lllllllllllllIIlIlIlIlIIllIIlIlI, final float lllllllllllllIIlIlIlIlIIllIIlIIl) {
        this.proxy.drawScreen(lllllllllllllIIlIlIlIlIIllIIlIll, lllllllllllllIIlIlIlIlIIllIIlIlI, lllllllllllllIIlIlIlIlIIllIIlIIl);
    }
    
    public int xm() {
        return this.proxy.mouseX();
    }
    
    public void customMouseEvent(final int lllllllllllllIIlIlIlIlIIlIIIllIl, final int lllllllllllllIIlIlIlIlIIlIIIllII, final int lllllllllllllIIlIlIlIlIIlIIIlIll, final float lllllllllllllIIlIlIlIlIIlIIIlIlI, final int lllllllllllllIIlIlIlIlIIlIIIlIIl) {
    }
    
    protected void renderList(final int lllllllllllllIIlIlIlIlIIIllllllI, final int lllllllllllllIIlIlIlIlIIIlllllIl, final int lllllllllllllIIlIlIlIlIIIlllllII, final int lllllllllllllIIlIlIlIlIIIllllIll) {
    }
    
    public void renderBackground() {
    }
}
