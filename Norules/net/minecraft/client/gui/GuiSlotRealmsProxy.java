package net.minecraft.client.gui;

import net.minecraft.realms.*;
import net.minecraft.client.*;

public class GuiSlotRealmsProxy extends GuiSlot
{
    private final /* synthetic */ RealmsScrolledSelectionList selectionList;
    
    @Override
    protected int getScrollBarX() {
        return this.selectionList.getScrollbarPosition();
    }
    
    @Override
    protected void drawBackground() {
        this.selectionList.renderBackground();
    }
    
    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
    }
    
    @Override
    protected int getContentHeight() {
        return this.selectionList.getMaxPosition();
    }
    
    @Override
    protected int getSize() {
        return this.selectionList.getItemCount();
    }
    
    @Override
    protected boolean isSelected(final int lllllllllllllIllIllIIIIlIIlIlIII) {
        return this.selectionList.isSelectedItem(lllllllllllllIllIllIIIIlIIlIlIII);
    }
    
    public int getWidth() {
        return this.width;
    }
    
    @Override
    protected void func_192637_a(final int lllllllllllllIllIllIIIIlIIIlIlII, final int lllllllllllllIllIllIIIIlIIIllIll, final int lllllllllllllIllIllIIIIlIIIllIlI, final int lllllllllllllIllIllIIIIlIIIlIIIl, final int lllllllllllllIllIllIIIIlIIIlIIII, final int lllllllllllllIllIllIIIIlIIIlIlll, final float lllllllllllllIllIllIIIIlIIIlIllI) {
        this.selectionList.renderItem(lllllllllllllIllIllIIIIlIIIlIlII, lllllllllllllIllIllIIIIlIIIllIll, lllllllllllllIllIllIIIIlIIIllIlI, lllllllllllllIllIllIIIIlIIIlIIIl, lllllllllllllIllIllIIIIlIIIlIIII, lllllllllllllIllIllIIIIlIIIlIlll);
    }
    
    @Override
    protected void elementClicked(final int lllllllllllllIllIllIIIIlIIllIIIl, final boolean lllllllllllllIllIllIIIIlIIllIlIl, final int lllllllllllllIllIllIIIIlIIlIllll, final int lllllllllllllIllIllIIIIlIIllIIll) {
        this.selectionList.selectItem(lllllllllllllIllIllIIIIlIIllIIIl, lllllllllllllIllIllIIIIlIIllIlIl, lllllllllllllIllIllIIIIlIIlIllll, lllllllllllllIllIllIIIIlIIllIIll);
    }
    
    public GuiSlotRealmsProxy(final RealmsScrolledSelectionList lllllllllllllIllIllIIIIlIlIIIlIl, final int lllllllllllllIllIllIIIIlIlIIIlII, final int lllllllllllllIllIllIIIIlIlIIIIll, final int lllllllllllllIllIllIIIIlIlIIIIlI, final int lllllllllllllIllIllIIIIlIlIIIIIl, final int lllllllllllllIllIllIIIIlIlIIIIII) {
        super(Minecraft.getMinecraft(), lllllllllllllIllIllIIIIlIlIIIlII, lllllllllllllIllIllIIIIlIlIIIIll, lllllllllllllIllIllIIIIlIlIIIIlI, lllllllllllllIllIllIIIIlIlIIIIIl, lllllllllllllIllIllIIIIlIlIIIIII);
        this.selectionList = lllllllllllllIllIllIIIIlIlIIIlIl;
    }
    
    public int getMouseY() {
        return this.mouseY;
    }
    
    public int getMouseX() {
        return this.mouseX;
    }
}
