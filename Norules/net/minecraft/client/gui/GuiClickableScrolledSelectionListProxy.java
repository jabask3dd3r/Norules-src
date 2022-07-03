package net.minecraft.client.gui;

import net.minecraft.client.*;
import org.lwjgl.input.*;
import net.minecraft.realms.*;

public class GuiClickableScrolledSelectionListProxy extends GuiSlot
{
    private final /* synthetic */ RealmsClickableScrolledSelectionList proxy;
    
    @Override
    protected int getScrollBarX() {
        return this.proxy.getScrollbarPosition();
    }
    
    @Override
    protected int getContentHeight() {
        return this.proxy.getMaxPosition();
    }
    
    @Override
    protected void func_192637_a(final int lIlIIIllIlIIIlI, final int lIlIIIllIlIlIIl, final int lIlIIIllIlIIIII, final int lIlIIIllIlIIlll, final int lIlIIIllIIllllI, final int lIlIIIllIlIIlIl, final float lIlIIIllIlIIlII) {
        this.proxy.renderItem(lIlIIIllIlIIIlI, lIlIIIllIlIlIIl, lIlIIIllIlIIIII, lIlIIIllIlIIlll, lIlIIIllIIllllI, lIlIIIllIlIIlIl);
    }
    
    public int width() {
        return this.width;
    }
    
    public int mouseY() {
        return this.mouseY;
    }
    
    public GuiClickableScrolledSelectionListProxy(final RealmsClickableScrolledSelectionList lIlIIIlllIllIlI, final int lIlIIIlllIlIIlI, final int lIlIIIlllIlIIIl, final int lIlIIIlllIlIIII, final int lIlIIIlllIlIllI, final int lIlIIIlllIIlllI) {
        super(Minecraft.getMinecraft(), lIlIIIlllIlIIlI, lIlIIIlllIlIIIl, lIlIIIlllIlIIII, lIlIIIlllIlIllI, lIlIIIlllIIlllI);
        this.proxy = lIlIIIlllIllIlI;
    }
    
    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
        if (this.scrollMultiplier > 0.0f && Mouse.getEventButtonState()) {
            this.proxy.customMouseEvent(this.top, this.bottom, this.headerPadding, this.amountScrolled, this.slotHeight);
        }
    }
    
    public void renderSelected(final int lIlIIIlIlllllll, final int lIlIIIlIllllllI, final int lIlIIIlIlllllIl, final Tezzelator lIlIIIlIlllllII) {
        this.proxy.renderSelected(lIlIIIlIlllllll, lIlIIIlIllllllI, lIlIIIlIlllllIl, lIlIIIlIlllllII);
    }
    
    @Override
    protected boolean isSelected(final int lIlIIIllIlllIII) {
        return this.proxy.isSelectedItem(lIlIIIllIlllIII);
    }
    
    @Override
    protected void drawBackground() {
        this.proxy.renderBackground();
    }
    
    @Override
    protected int getSize() {
        return this.proxy.getItemCount();
    }
    
    public int mouseX() {
        return this.mouseX;
    }
    
    @Override
    protected void func_192638_a(final int lIlIIIlIllIIllI, final int lIlIIIlIllIIlIl, final int lIlIIIlIllIIlII, final int lIlIIIlIllIllIl, final float lIlIIIlIllIIIlI) {
        for (int lIlIIIlIllIlIll = this.getSize(), lIlIIIlIllIlIlI = 0; lIlIIIlIllIlIlI < lIlIIIlIllIlIll; ++lIlIIIlIllIlIlI) {
            final int lIlIIIlIllIlIIl = lIlIIIlIllIIlIl + lIlIIIlIllIlIlI * this.slotHeight + this.headerPadding;
            final int lIlIIIlIllIlIII = this.slotHeight - 4;
            if (lIlIIIlIllIlIIl > this.bottom || lIlIIIlIllIlIIl + lIlIIIlIllIlIII < this.top) {
                this.func_192639_a(lIlIIIlIllIlIlI, lIlIIIlIllIIllI, lIlIIIlIllIlIIl, lIlIIIlIllIIIlI);
            }
            if (this.showSelectionBox && this.isSelected(lIlIIIlIllIlIlI)) {
                this.renderSelected(this.width, lIlIIIlIllIlIIl, lIlIIIlIllIlIII, Tezzelator.instance);
            }
            this.func_192637_a(lIlIIIlIllIlIlI, lIlIIIlIllIIllI, lIlIIIlIllIlIIl, lIlIIIlIllIlIII, lIlIIIlIllIIlII, lIlIIIlIllIllIl, lIlIIIlIllIIIlI);
        }
    }
    
    @Override
    protected void elementClicked(final int lIlIIIllIllllll, final boolean lIlIIIllIlllllI, final int lIlIIIlllIIIIlI, final int lIlIIIllIllllII) {
        this.proxy.selectItem(lIlIIIllIllllll, lIlIIIllIlllllI, lIlIIIlllIIIIlI, lIlIIIllIllllII);
    }
}
