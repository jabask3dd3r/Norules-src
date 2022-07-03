package net.minecraft.client.gui;

import net.minecraft.realms.*;
import net.minecraft.client.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class GuiSimpleScrolledSelectionListProxy extends GuiSlot
{
    private final /* synthetic */ RealmsSimpleScrolledSelectionList realmsScrolledSelectionList;
    
    public GuiSimpleScrolledSelectionListProxy(final RealmsSimpleScrolledSelectionList lllllllllllllIllIllIlIlIllIIIIII, final int lllllllllllllIllIllIlIlIllIIIllI, final int lllllllllllllIllIllIlIlIlIlllllI, final int lllllllllllllIllIllIlIlIlIllllIl, final int lllllllllllllIllIllIlIlIllIIIIll, final int lllllllllllllIllIllIlIlIllIIIIlI) {
        super(Minecraft.getMinecraft(), lllllllllllllIllIllIlIlIllIIIllI, lllllllllllllIllIllIlIlIlIlllllI, lllllllllllllIllIllIlIlIlIllllIl, lllllllllllllIllIllIlIlIllIIIIll, lllllllllllllIllIllIlIlIllIIIIlI);
        this.realmsScrolledSelectionList = lllllllllllllIllIllIlIlIllIIIIII;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIllIllIlIlIIlIlllII, final int lllllllllllllIllIllIlIlIIllIlIII, final float lllllllllllllIllIllIlIlIIllIIlll) {
        if (this.visible) {
            this.mouseX = lllllllllllllIllIllIlIlIIlIlllII;
            this.mouseY = lllllllllllllIllIllIlIlIIllIlIII;
            this.drawBackground();
            final int lllllllllllllIllIllIlIlIIllIIllI = this.getScrollBarX();
            final int lllllllllllllIllIllIlIlIIllIIlIl = lllllllllllllIllIllIlIlIIllIIllI + 6;
            this.bindAmountScrolled();
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator lllllllllllllIllIllIlIlIIllIIlII = Tessellator.getInstance();
            final BufferBuilder lllllllllllllIllIllIlIlIIllIIIll = lllllllllllllIllIllIlIlIIllIIlII.getBuffer();
            final int lllllllllllllIllIllIlIlIIllIIIlI = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int lllllllllllllIllIllIlIlIIllIIIIl = this.top + 4 - (int)this.amountScrolled;
            if (this.hasListHeader) {
                this.drawListHeader(lllllllllllllIllIllIlIlIIllIIIlI, lllllllllllllIllIllIlIlIIllIIIIl, lllllllllllllIllIllIlIlIIllIIlII);
            }
            this.func_192638_a(lllllllllllllIllIllIlIlIIllIIIlI, lllllllllllllIllIllIlIlIIllIIIIl, lllllllllllllIllIllIlIlIIlIlllII, lllllllllllllIllIllIlIlIIllIlIII, lllllllllllllIllIllIlIlIIllIIlll);
            GlStateManager.disableDepth();
            this.overlayBackground(0, this.top, 255, 255);
            this.overlayBackground(this.bottom, this.height, 255, 255);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            GlStateManager.shadeModel(7425);
            GlStateManager.disableTexture2D();
            final int lllllllllllllIllIllIlIlIIllIIIII = this.getMaxScroll();
            if (lllllllllllllIllIllIlIlIIllIIIII > 0) {
                int lllllllllllllIllIllIlIlIIlIlllll = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
                lllllllllllllIllIllIlIlIIlIlllll = MathHelper.clamp(lllllllllllllIllIllIlIlIIlIlllll, 32, this.bottom - this.top - 8);
                int lllllllllllllIllIllIlIlIIlIllllI = (int)this.amountScrolled * (this.bottom - this.top - lllllllllllllIllIllIlIlIIlIlllll) / lllllllllllllIllIllIlIlIIllIIIII + this.top;
                if (lllllllllllllIllIllIlIlIIlIllllI < this.top) {
                    lllllllllllllIllIllIlIlIIlIllllI = this.top;
                }
                lllllllllllllIllIllIlIlIIllIIIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIllI, this.bottom, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIlIl, this.bottom, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIlIl, this.top, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIllI, this.top, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIlII.draw();
                lllllllllllllIllIllIlIlIIllIIIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIllI, lllllllllllllIllIllIlIlIIlIllllI + lllllllllllllIllIllIlIlIIlIlllll, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIlIl, lllllllllllllIllIllIlIlIIlIllllI + lllllllllllllIllIllIlIlIIlIlllll, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIlIl, lllllllllllllIllIllIlIlIIlIllllI, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIllI, lllllllllllllIllIllIlIlIIlIllllI, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIlII.draw();
                lllllllllllllIllIllIlIlIIllIIIll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIllI, lllllllllllllIllIllIlIlIIlIllllI + lllllllllllllIllIllIlIlIIlIlllll - 1, 0.0).tex(0.0, 1.0).color(192, 192, 192, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIlIl - 1, lllllllllllllIllIllIlIlIIlIllllI + lllllllllllllIllIllIlIlIIlIlllll - 1, 0.0).tex(1.0, 1.0).color(192, 192, 192, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIlIl - 1, lllllllllllllIllIllIlIlIIlIllllI, 0.0).tex(1.0, 0.0).color(192, 192, 192, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIIll.pos(lllllllllllllIllIllIlIlIIllIIllI, lllllllllllllIllIllIlIlIIlIllllI, 0.0).tex(0.0, 0.0).color(192, 192, 192, 255).endVertex();
                lllllllllllllIllIllIlIlIIllIIlII.draw();
            }
            this.renderDecorations(lllllllllllllIllIllIlIlIIlIlllII, lllllllllllllIllIllIlIlIIllIlIII);
            GlStateManager.enableTexture2D();
            GlStateManager.shadeModel(7424);
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }
    
    @Override
    protected void drawBackground() {
        this.realmsScrolledSelectionList.renderBackground();
    }
    
    @Override
    protected int getSize() {
        return this.realmsScrolledSelectionList.getItemCount();
    }
    
    @Override
    protected void elementClicked(final int lllllllllllllIllIllIlIlIlIllIIIl, final boolean lllllllllllllIllIllIlIlIlIllIIII, final int lllllllllllllIllIllIlIlIlIlIlIlI, final int lllllllllllllIllIllIlIlIlIlIlllI) {
        this.realmsScrolledSelectionList.selectItem(lllllllllllllIllIllIlIlIlIllIIIl, lllllllllllllIllIllIlIlIlIllIIII, lllllllllllllIllIllIlIlIlIlIlIlI, lllllllllllllIllIllIlIlIlIlIlllI);
    }
    
    @Override
    protected int getScrollBarX() {
        return this.realmsScrolledSelectionList.getScrollbarPosition();
    }
    
    @Override
    protected boolean isSelected(final int lllllllllllllIllIllIlIlIlIlIIIll) {
        return this.realmsScrolledSelectionList.isSelectedItem(lllllllllllllIllIllIlIlIlIlIIIll);
    }
    
    @Override
    protected void func_192637_a(final int lllllllllllllIllIllIlIlIlIIIllll, final int lllllllllllllIllIllIlIlIlIIlIllI, final int lllllllllllllIllIllIlIlIlIIlIlIl, final int lllllllllllllIllIllIlIlIlIIlIlII, final int lllllllllllllIllIllIlIlIlIIIlIll, final int lllllllllllllIllIllIlIlIlIIIlIlI, final float lllllllllllllIllIllIlIlIlIIlIIIl) {
        this.realmsScrolledSelectionList.renderItem(lllllllllllllIllIllIlIlIlIIIllll, lllllllllllllIllIllIlIlIlIIlIllI, lllllllllllllIllIllIlIlIlIIlIlIl, lllllllllllllIllIllIlIlIlIIlIlII, lllllllllllllIllIllIlIlIlIIIlIll, lllllllllllllIllIllIlIlIlIIIlIlI);
    }
    
    public int getWidth() {
        return this.width;
    }
    
    @Override
    protected int getContentHeight() {
        return this.realmsScrolledSelectionList.getMaxPosition();
    }
    
    @Override
    public void handleMouseInput() {
        super.handleMouseInput();
    }
    
    public int getMouseX() {
        return this.mouseX;
    }
    
    public int getMouseY() {
        return this.mouseY;
    }
}
