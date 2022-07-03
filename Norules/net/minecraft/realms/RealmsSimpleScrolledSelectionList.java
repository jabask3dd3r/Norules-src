package net.minecraft.realms;

import net.minecraft.client.gui.*;

public class RealmsSimpleScrolledSelectionList
{
    private final /* synthetic */ GuiSimpleScrolledSelectionListProxy proxy;
    
    public void mouseEvent() {
        this.proxy.handleMouseInput();
    }
    
    public void selectItem(final int lllllllllllllIllIlIIllIllIlIIIIl, final boolean lllllllllllllIllIlIIllIllIlIIIII, final int lllllllllllllIllIlIIllIllIIlllll, final int lllllllllllllIllIlIIllIllIIllllI) {
    }
    
    public int getScrollbarPosition() {
        return this.proxy.getWidth() / 2 + 124;
    }
    
    public boolean isSelectedItem(final int lllllllllllllIllIlIIllIllIIlllII) {
        return false;
    }
    
    public void renderBackground() {
    }
    
    public RealmsSimpleScrolledSelectionList(final int lllllllllllllIllIlIIllIlllIllIlI, final int lllllllllllllIllIlIIllIlllIlllll, final int lllllllllllllIllIlIIllIlllIllllI, final int lllllllllllllIllIlIIllIlllIlIlll, final int lllllllllllllIllIlIIllIlllIlllII) {
        this.proxy = new GuiSimpleScrolledSelectionListProxy(this, lllllllllllllIllIlIIllIlllIllIlI, lllllllllllllIllIlIIllIlllIlllll, lllllllllllllIllIlIIllIlllIllllI, lllllllllllllIllIlIIllIlllIlIlll, lllllllllllllIllIlIIllIlllIlllII);
    }
    
    public int getMaxPosition() {
        return 0;
    }
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    public void renderItem(final int lllllllllllllIllIlIIllIllIllIIII, final int lllllllllllllIllIlIIllIllIlIllll, final int lllllllllllllIllIlIIllIllIlIIlll, final int lllllllllllllIllIlIIllIllIlIllIl, final int lllllllllllllIllIlIIllIllIlIllII, final int lllllllllllllIllIlIIllIllIlIlIll) {
        this.renderItem(lllllllllllllIllIlIIllIllIllIIII, lllllllllllllIllIlIIllIllIlIllll, lllllllllllllIllIlIIllIllIlIIlll, lllllllllllllIllIlIIllIllIlIllIl, Tezzelator.instance, lllllllllllllIllIlIIllIllIlIllII, lllllllllllllIllIlIIllIllIlIlIll);
    }
    
    public int width() {
        return this.proxy.getWidth();
    }
    
    protected void renderList(final int lllllllllllllIllIlIIllIllIIIlIIl, final int lllllllllllllIllIlIIllIllIIIlIII, final int lllllllllllllIllIlIIllIllIIIIlll, final int lllllllllllllIllIlIIllIllIIIIllI) {
    }
    
    public void scroll(final int lllllllllllllIllIlIIllIllIIlIIII) {
        this.proxy.scrollBy(lllllllllllllIllIlIIllIllIIlIIII);
    }
    
    public void render(final int lllllllllllllIllIlIIllIlllIlIIII, final int lllllllllllllIllIlIIllIlllIIllll, final float lllllllllllllIllIlIIllIlllIIlIlI) {
        this.proxy.drawScreen(lllllllllllllIllIlIIllIlllIlIIII, lllllllllllllIllIlIIllIlllIIllll, lllllllllllllIllIlIIllIlllIIlIlI);
    }
    
    public int getItemCount() {
        return 0;
    }
    
    protected void renderItem(final int lllllllllllllIllIlIIllIllIllllll, final int lllllllllllllIllIlIIllIllIlllllI, final int lllllllllllllIllIlIIllIllIllllIl, final int lllllllllllllIllIlIIllIllIllllII, final Tezzelator lllllllllllllIllIlIIllIllIlllIll, final int lllllllllllllIllIlIIllIllIlllIlI, final int lllllllllllllIllIlIIllIllIlllIIl) {
    }
    
    public int xm() {
        return this.proxy.getMouseX();
    }
    
    public int ym() {
        return this.proxy.getMouseY();
    }
}
