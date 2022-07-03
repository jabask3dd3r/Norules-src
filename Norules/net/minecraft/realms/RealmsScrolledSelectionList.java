package net.minecraft.realms;

import net.minecraft.client.gui.*;

public class RealmsScrolledSelectionList
{
    private final /* synthetic */ GuiSlotRealmsProxy proxy;
    
    public void selectItem(final int lllllllllllllIIIIIllllIlIllllIIl, final boolean lllllllllllllIIIIIllllIlIllllIII, final int lllllllllllllIIIIIllllIlIlllIlll, final int lllllllllllllIIIIIllllIlIlllIllI) {
    }
    
    protected void renderItem(final int lllllllllllllIIIIIllllIllIIlIlll, final int lllllllllllllIIIIIllllIllIIlIllI, final int lllllllllllllIIIIIllllIllIIlIlIl, final int lllllllllllllIIIIIllllIllIIlIlII, final Tezzelator lllllllllllllIIIIIllllIllIIlIIll, final int lllllllllllllIIIIIllllIllIIlIIlI, final int lllllllllllllIIIIIllllIllIIlIIIl) {
    }
    
    public void renderItem(final int lllllllllllllIIIIIllllIllIIIIIIl, final int lllllllllllllIIIIIllllIllIIIIlll, final int lllllllllllllIIIIIllllIllIIIIllI, final int lllllllllllllIIIIIllllIlIllllllI, final int lllllllllllllIIIIIllllIllIIIIlII, final int lllllllllllllIIIIIllllIllIIIIIll) {
        this.renderItem(lllllllllllllIIIIIllllIllIIIIIIl, lllllllllllllIIIIIllllIllIIIIlll, lllllllllllllIIIIIllllIllIIIIllI, lllllllllllllIIIIIllllIlIllllllI, Tezzelator.instance, lllllllllllllIIIIIllllIllIIIIlII, lllllllllllllIIIIIllllIllIIIIIll);
    }
    
    public void scroll(final int lllllllllllllIIIIIllllIlIllIlIII) {
        this.proxy.scrollBy(lllllllllllllIIIIIllllIlIllIlIII);
    }
    
    public int width() {
        return this.proxy.getWidth();
    }
    
    public int ym() {
        return this.proxy.getMouseY();
    }
    
    public int getScroll() {
        return this.proxy.getAmountScrolled();
    }
    
    public int xm() {
        return this.proxy.getMouseX();
    }
    
    public void mouseEvent() {
        this.proxy.handleMouseInput();
    }
    
    public void render(final int lllllllllllllIIIIIllllIllIlIIlII, final int lllllllllllllIIIIIllllIllIlIIlll, final float lllllllllllllIIIIIllllIllIlIIIlI) {
        this.proxy.drawScreen(lllllllllllllIIIIIllllIllIlIIlII, lllllllllllllIIIIIllllIllIlIIlll, lllllllllllllIIIIIllllIllIlIIIlI);
    }
    
    public boolean isSelectedItem(final int lllllllllllllIIIIIllllIlIlllIlII) {
        return false;
    }
    
    public int getItemCount() {
        return 0;
    }
    
    protected void renderList(final int lllllllllllllIIIIIllllIlIllIIIIl, final int lllllllllllllIIIIIllllIlIllIIIII, final int lllllllllllllIIIIIllllIlIlIlllll, final int lllllllllllllIIIIIllllIlIlIllllI) {
    }
    
    public int getMaxPosition() {
        return 0;
    }
    
    public RealmsScrolledSelectionList(final int lllllllllllllIIIIIllllIllIllIIlI, final int lllllllllllllIIIIIllllIllIllIlll, final int lllllllllllllIIIIIllllIllIllIIII, final int lllllllllllllIIIIIllllIllIllIlIl, final int lllllllllllllIIIIIllllIllIlIlllI) {
        this.proxy = new GuiSlotRealmsProxy(this, lllllllllllllIIIIIllllIllIllIIlI, lllllllllllllIIIIIllllIllIllIlll, lllllllllllllIIIIIllllIllIllIIII, lllllllllllllIIIIIllllIllIllIlIl, lllllllllllllIIIIIllllIllIlIlllI);
    }
    
    public int getScrollbarPosition() {
        return this.proxy.getWidth() / 2 + 124;
    }
    
    public void renderBackground() {
    }
}
