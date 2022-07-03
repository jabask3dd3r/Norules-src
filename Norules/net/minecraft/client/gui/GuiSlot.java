package net.minecraft.client.gui;

import net.minecraft.client.*;
import org.lwjgl.input.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public abstract class GuiSlot
{
    protected /* synthetic */ boolean hasListHeader;
    protected /* synthetic */ int left;
    protected /* synthetic */ float amountScrolled;
    protected final /* synthetic */ Minecraft mc;
    protected /* synthetic */ int initialClickY;
    private /* synthetic */ boolean enabled;
    protected /* synthetic */ boolean centerListVertically;
    protected /* synthetic */ int height;
    protected /* synthetic */ long lastClicked;
    protected /* synthetic */ int width;
    protected /* synthetic */ boolean showSelectionBox;
    protected /* synthetic */ int right;
    protected /* synthetic */ int mouseY;
    protected /* synthetic */ int mouseX;
    private /* synthetic */ int scrollUpButtonID;
    private /* synthetic */ int scrollDownButtonID;
    protected /* synthetic */ boolean visible;
    protected final /* synthetic */ int slotHeight;
    protected /* synthetic */ int headerPadding;
    protected /* synthetic */ int top;
    protected /* synthetic */ int selectedElement;
    protected /* synthetic */ int bottom;
    protected /* synthetic */ float scrollMultiplier;
    
    public int getSlotHeight() {
        return this.slotHeight;
    }
    
    public int getAmountScrolled() {
        return (int)this.amountScrolled;
    }
    
    public void handleMouseInput() {
        if (this.isMouseYWithinSlotBounds(this.mouseY)) {
            if (Mouse.getEventButton() == 0 && Mouse.getEventButtonState() && this.mouseY >= this.top && this.mouseY <= this.bottom) {
                final int llllllllllllllIlIlIlIIIIIlllIllI = (this.width - this.getListWidth()) / 2;
                final int llllllllllllllIlIlIlIIIIIlllIlIl = (this.width + this.getListWidth()) / 2;
                final int llllllllllllllIlIlIlIIIIIlllIlII = this.mouseY - this.top - this.headerPadding + (int)this.amountScrolled - 4;
                final int llllllllllllllIlIlIlIIIIIlllIIll = llllllllllllllIlIlIlIIIIIlllIlII / this.slotHeight;
                if (llllllllllllllIlIlIlIIIIIlllIIll < this.getSize() && this.mouseX >= llllllllllllllIlIlIlIIIIIlllIllI && this.mouseX <= llllllllllllllIlIlIlIIIIIlllIlIl && llllllllllllllIlIlIlIIIIIlllIIll >= 0 && llllllllllllllIlIlIlIIIIIlllIlII >= 0) {
                    this.elementClicked(llllllllllllllIlIlIlIIIIIlllIIll, false, this.mouseX, this.mouseY);
                    this.selectedElement = llllllllllllllIlIlIlIIIIIlllIIll;
                }
                else if (this.mouseX >= llllllllllllllIlIlIlIIIIIlllIllI && this.mouseX <= llllllllllllllIlIlIlIIIIIlllIlIl && llllllllllllllIlIlIlIIIIIlllIlII < 0) {
                    this.clickedHeader(this.mouseX - llllllllllllllIlIlIlIIIIIlllIllI, this.mouseY - this.top + (int)this.amountScrolled - 4);
                }
            }
            if (Mouse.isButtonDown(0) && this.getEnabled()) {
                if (this.initialClickY != -1) {
                    if (this.initialClickY >= 0) {
                        this.amountScrolled -= (this.mouseY - this.initialClickY) * this.scrollMultiplier;
                        this.initialClickY = this.mouseY;
                    }
                }
                else {
                    boolean llllllllllllllIlIlIlIIIIIlllIIlI = true;
                    if (this.mouseY >= this.top && this.mouseY <= this.bottom) {
                        final int llllllllllllllIlIlIlIIIIIlllIIIl = (this.width - this.getListWidth()) / 2;
                        final int llllllllllllllIlIlIlIIIIIlllIIII = (this.width + this.getListWidth()) / 2;
                        final int llllllllllllllIlIlIlIIIIIllIllll = this.mouseY - this.top - this.headerPadding + (int)this.amountScrolled - 4;
                        final int llllllllllllllIlIlIlIIIIIllIlllI = llllllllllllllIlIlIlIIIIIllIllll / this.slotHeight;
                        if (llllllllllllllIlIlIlIIIIIllIlllI < this.getSize() && this.mouseX >= llllllllllllllIlIlIlIIIIIlllIIIl && this.mouseX <= llllllllllllllIlIlIlIIIIIlllIIII && llllllllllllllIlIlIlIIIIIllIlllI >= 0 && llllllllllllllIlIlIlIIIIIllIllll >= 0) {
                            final boolean llllllllllllllIlIlIlIIIIIllIllIl = llllllllllllllIlIlIlIIIIIllIlllI == this.selectedElement && Minecraft.getSystemTime() - this.lastClicked < 250L;
                            this.elementClicked(llllllllllllllIlIlIlIIIIIllIlllI, llllllllllllllIlIlIlIIIIIllIllIl, this.mouseX, this.mouseY);
                            this.selectedElement = llllllllllllllIlIlIlIIIIIllIlllI;
                            this.lastClicked = Minecraft.getSystemTime();
                        }
                        else if (this.mouseX >= llllllllllllllIlIlIlIIIIIlllIIIl && this.mouseX <= llllllllllllllIlIlIlIIIIIlllIIII && llllllllllllllIlIlIlIIIIIllIllll < 0) {
                            this.clickedHeader(this.mouseX - llllllllllllllIlIlIlIIIIIlllIIIl, this.mouseY - this.top + (int)this.amountScrolled - 4);
                            llllllllllllllIlIlIlIIIIIlllIIlI = false;
                        }
                        final int llllllllllllllIlIlIlIIIIIllIllII = this.getScrollBarX();
                        final int llllllllllllllIlIlIlIIIIIllIlIll = llllllllllllllIlIlIlIIIIIllIllII + 6;
                        if (this.mouseX >= llllllllllllllIlIlIlIIIIIllIllII && this.mouseX <= llllllllllllllIlIlIlIIIIIllIlIll) {
                            this.scrollMultiplier = -1.0f;
                            int llllllllllllllIlIlIlIIIIIllIlIlI = this.getMaxScroll();
                            if (llllllllllllllIlIlIlIIIIIllIlIlI < 1) {
                                llllllllllllllIlIlIlIIIIIllIlIlI = 1;
                            }
                            int llllllllllllllIlIlIlIIIIIllIlIIl = (int)((this.bottom - this.top) * (this.bottom - this.top) / (float)this.getContentHeight());
                            llllllllllllllIlIlIlIIIIIllIlIIl = MathHelper.clamp(llllllllllllllIlIlIlIIIIIllIlIIl, 32, this.bottom - this.top - 8);
                            this.scrollMultiplier /= (this.bottom - this.top - llllllllllllllIlIlIlIIIIIllIlIIl) / (float)llllllllllllllIlIlIlIIIIIllIlIlI;
                        }
                        else {
                            this.scrollMultiplier = 1.0f;
                        }
                        if (llllllllllllllIlIlIlIIIIIlllIIlI) {
                            this.initialClickY = this.mouseY;
                        }
                        else {
                            this.initialClickY = -2;
                        }
                    }
                    else {
                        this.initialClickY = -2;
                    }
                }
            }
            else {
                this.initialClickY = -1;
            }
            int llllllllllllllIlIlIlIIIIIllIlIII = Mouse.getEventDWheel();
            if (llllllllllllllIlIlIlIIIIIllIlIII != 0) {
                if (llllllllllllllIlIlIlIIIIIllIlIII > 0) {
                    llllllllllllllIlIlIlIIIIIllIlIII = -1;
                }
                else if (llllllllllllllIlIlIlIIIIIllIlIII < 0) {
                    llllllllllllllIlIlIlIIIIIllIlIII = 1;
                }
                this.amountScrolled += llllllllllllllIlIlIlIIIIIllIlIII * this.slotHeight / 2;
            }
        }
    }
    
    protected void bindAmountScrolled() {
        this.amountScrolled = MathHelper.clamp(this.amountScrolled, 0.0f, (float)this.getMaxScroll());
    }
    
    public void setEnabled(final boolean llllllllllllllIlIlIlIIIIIlIllIII) {
        this.enabled = llllllllllllllIlIlIlIIIIIlIllIII;
    }
    
    public void setDimensions(final int llllllllllllllIlIlIlIIIlIIIIlllI, final int llllllllllllllIlIlIlIIIlIIIIlIII, final int llllllllllllllIlIlIlIIIlIIIIllII, final int llllllllllllllIlIlIlIIIlIIIIIllI) {
        this.width = llllllllllllllIlIlIlIIIlIIIIlllI;
        this.height = llllllllllllllIlIlIlIIIlIIIIlIII;
        this.top = llllllllllllllIlIlIlIIIlIIIIllII;
        this.bottom = llllllllllllllIlIlIlIIIlIIIIIllI;
        this.left = 0;
        this.right = llllllllllllllIlIlIlIIIlIIIIlllI;
    }
    
    public void drawScreen(final int llllllllllllllIlIlIlIIIIlIIlllII, final int llllllllllllllIlIlIlIIIIlIIllIll, final float llllllllllllllIlIlIlIIIIlIIIllII) {
        if (this.visible) {
            this.mouseX = llllllllllllllIlIlIlIIIIlIIlllII;
            this.mouseY = llllllllllllllIlIlIlIIIIlIIllIll;
            this.drawBackground();
            final int llllllllllllllIlIlIlIIIIlIIllIIl = this.getScrollBarX();
            final int llllllllllllllIlIlIlIIIIlIIllIII = llllllllllllllIlIlIlIIIIlIIllIIl + 6;
            this.bindAmountScrolled();
            GlStateManager.disableLighting();
            GlStateManager.disableFog();
            final Tessellator llllllllllllllIlIlIlIIIIlIIlIlll = Tessellator.getInstance();
            final BufferBuilder llllllllllllllIlIlIlIIIIlIIlIllI = llllllllllllllIlIlIlIIIIlIIlIlll.getBuffer();
            this.drawContainerBackground(llllllllllllllIlIlIlIIIIlIIlIlll);
            final int llllllllllllllIlIlIlIIIIlIIlIlIl = this.left + this.width / 2 - this.getListWidth() / 2 + 2;
            final int llllllllllllllIlIlIlIIIIlIIlIlII = this.top + 4 - (int)this.amountScrolled;
            if (this.hasListHeader) {
                this.drawListHeader(llllllllllllllIlIlIlIIIIlIIlIlIl, llllllllllllllIlIlIlIIIIlIIlIlII, llllllllllllllIlIlIlIIIIlIIlIlll);
            }
            this.func_192638_a(llllllllllllllIlIlIlIIIIlIIlIlIl, llllllllllllllIlIlIlIIIIlIIlIlII, llllllllllllllIlIlIlIIIIlIIlllII, llllllllllllllIlIlIlIIIIlIIllIll, llllllllllllllIlIlIlIIIIlIIIllII);
            GlStateManager.disableDepth();
            this.overlayBackground(0, this.top, 255, 255);
            this.overlayBackground(this.bottom, this.height, 255, 255);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            GlStateManager.disableAlpha();
            GlStateManager.shadeModel(7425);
            GlStateManager.disableTexture2D();
            final int llllllllllllllIlIlIlIIIIlIIlIIll = 4;
            llllllllllllllIlIlIlIIIIlIIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            llllllllllllllIlIlIlIIIIlIIlIllI.pos(this.left, this.top + 4, 0.0).tex(0.0, 1.0).color(0, 0, 0, 0).endVertex();
            llllllllllllllIlIlIlIIIIlIIlIllI.pos(this.right, this.top + 4, 0.0).tex(1.0, 1.0).color(0, 0, 0, 0).endVertex();
            llllllllllllllIlIlIlIIIIlIIlIllI.pos(this.right, this.top, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
            llllllllllllllIlIlIlIIIIlIIlIllI.pos(this.left, this.top, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
            llllllllllllllIlIlIlIIIIlIIlIlll.draw();
            llllllllllllllIlIlIlIIIIlIIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            llllllllllllllIlIlIlIIIIlIIlIllI.pos(this.left, this.bottom, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
            llllllllllllllIlIlIlIIIIlIIlIllI.pos(this.right, this.bottom, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
            llllllllllllllIlIlIlIIIIlIIlIllI.pos(this.right, this.bottom - 4, 0.0).tex(1.0, 0.0).color(0, 0, 0, 0).endVertex();
            llllllllllllllIlIlIlIIIIlIIlIllI.pos(this.left, this.bottom - 4, 0.0).tex(0.0, 0.0).color(0, 0, 0, 0).endVertex();
            llllllllllllllIlIlIlIIIIlIIlIlll.draw();
            final int llllllllllllllIlIlIlIIIIlIIlIIlI = this.getMaxScroll();
            if (llllllllllllllIlIlIlIIIIlIIlIIlI > 0) {
                int llllllllllllllIlIlIlIIIIlIIlIIIl = (this.bottom - this.top) * (this.bottom - this.top) / this.getContentHeight();
                llllllllllllllIlIlIlIIIIlIIlIIIl = MathHelper.clamp(llllllllllllllIlIlIlIIIIlIIlIIIl, 32, this.bottom - this.top - 8);
                int llllllllllllllIlIlIlIIIIlIIlIIII = (int)this.amountScrolled * (this.bottom - this.top - llllllllllllllIlIlIlIIIIlIIlIIIl) / llllllllllllllIlIlIlIIIIlIIlIIlI + this.top;
                if (llllllllllllllIlIlIlIIIIlIIlIIII < this.top) {
                    llllllllllllllIlIlIlIIIIlIIlIIII = this.top;
                }
                llllllllllllllIlIlIlIIIIlIIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIIl, this.bottom, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIII, this.bottom, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIII, this.top, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIIl, this.top, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIlll.draw();
                llllllllllllllIlIlIlIIIIlIIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIIl, llllllllllllllIlIlIlIIIIlIIlIIII + llllllllllllllIlIlIlIIIIlIIlIIIl, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIII, llllllllllllllIlIlIlIIIIlIIlIIII + llllllllllllllIlIlIlIIIIlIIlIIIl, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIII, llllllllllllllIlIlIlIIIIlIIlIIII, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIIl, llllllllllllllIlIlIlIIIIlIIlIIII, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIlll.draw();
                llllllllllllllIlIlIlIIIIlIIlIllI.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIIl, llllllllllllllIlIlIlIIIIlIIlIIII + llllllllllllllIlIlIlIIIIlIIlIIIl - 1, 0.0).tex(0.0, 1.0).color(192, 192, 192, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIII - 1, llllllllllllllIlIlIlIIIIlIIlIIII + llllllllllllllIlIlIlIIIIlIIlIIIl - 1, 0.0).tex(1.0, 1.0).color(192, 192, 192, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIII - 1, llllllllllllllIlIlIlIIIIlIIlIIII, 0.0).tex(1.0, 0.0).color(192, 192, 192, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIllI.pos(llllllllllllllIlIlIlIIIIlIIllIIl, llllllllllllllIlIlIlIIIIlIIlIIII, 0.0).tex(0.0, 0.0).color(192, 192, 192, 255).endVertex();
                llllllllllllllIlIlIlIIIIlIIlIlll.draw();
            }
            this.renderDecorations(llllllllllllllIlIlIlIIIIlIIlllII, llllllllllllllIlIlIlIIIIlIIllIll);
            GlStateManager.enableTexture2D();
            GlStateManager.shadeModel(7424);
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }
    
    protected void func_192638_a(final int llllllllllllllIlIlIlIIIIIlIIIlII, final int llllllllllllllIlIlIlIIIIIIllIlIl, final int llllllllllllllIlIlIlIIIIIIllIlII, final int llllllllllllllIlIlIlIIIIIlIIIIIl, final float llllllllllllllIlIlIlIIIIIIllIIlI) {
        final int llllllllllllllIlIlIlIIIIIIllllll = this.getSize();
        final Tessellator llllllllllllllIlIlIlIIIIIIlllllI = Tessellator.getInstance();
        final BufferBuilder llllllllllllllIlIlIlIIIIIIllllIl = llllllllllllllIlIlIlIIIIIIlllllI.getBuffer();
        for (int llllllllllllllIlIlIlIIIIIIllllII = 0; llllllllllllllIlIlIlIIIIIIllllII < llllllllllllllIlIlIlIIIIIIllllll; ++llllllllllllllIlIlIlIIIIIIllllII) {
            final int llllllllllllllIlIlIlIIIIIIlllIll = llllllllllllllIlIlIlIIIIIIllIlIl + llllllllllllllIlIlIlIIIIIIllllII * this.slotHeight + this.headerPadding;
            final int llllllllllllllIlIlIlIIIIIIlllIlI = this.slotHeight - 4;
            if (llllllllllllllIlIlIlIIIIIIlllIll > this.bottom || llllllllllllllIlIlIlIIIIIIlllIll + llllllllllllllIlIlIlIIIIIIlllIlI < this.top) {
                this.func_192639_a(llllllllllllllIlIlIlIIIIIIllllII, llllllllllllllIlIlIlIIIIIlIIIlII, llllllllllllllIlIlIlIIIIIIlllIll, llllllllllllllIlIlIlIIIIIIllIIlI);
            }
            if (this.showSelectionBox && this.isSelected(llllllllllllllIlIlIlIIIIIIllllII)) {
                final int llllllllllllllIlIlIlIIIIIIlllIIl = this.left + (this.width / 2 - this.getListWidth() / 2);
                final int llllllllllllllIlIlIlIIIIIIlllIII = this.left + this.width / 2 + this.getListWidth() / 2;
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.disableTexture2D();
                llllllllllllllIlIlIlIIIIIIllllIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                llllllllllllllIlIlIlIIIIIIllllIl.pos(llllllllllllllIlIlIlIIIIIIlllIIl, llllllllllllllIlIlIlIIIIIIlllIll + llllllllllllllIlIlIlIIIIIIlllIlI + 2, 0.0).tex(0.0, 1.0).color(128, 128, 128, 255).endVertex();
                llllllllllllllIlIlIlIIIIIIllllIl.pos(llllllllllllllIlIlIlIIIIIIlllIII, llllllllllllllIlIlIlIIIIIIlllIll + llllllllllllllIlIlIlIIIIIIlllIlI + 2, 0.0).tex(1.0, 1.0).color(128, 128, 128, 255).endVertex();
                llllllllllllllIlIlIlIIIIIIllllIl.pos(llllllllllllllIlIlIlIIIIIIlllIII, llllllllllllllIlIlIlIIIIIIlllIll - 2, 0.0).tex(1.0, 0.0).color(128, 128, 128, 255).endVertex();
                llllllllllllllIlIlIlIIIIIIllllIl.pos(llllllllllllllIlIlIlIIIIIIlllIIl, llllllllllllllIlIlIlIIIIIIlllIll - 2, 0.0).tex(0.0, 0.0).color(128, 128, 128, 255).endVertex();
                llllllllllllllIlIlIlIIIIIIllllIl.pos(llllllllllllllIlIlIlIIIIIIlllIIl + 1, llllllllllllllIlIlIlIIIIIIlllIll + llllllllllllllIlIlIlIIIIIIlllIlI + 1, 0.0).tex(0.0, 1.0).color(0, 0, 0, 255).endVertex();
                llllllllllllllIlIlIlIIIIIIllllIl.pos(llllllllllllllIlIlIlIIIIIIlllIII - 1, llllllllllllllIlIlIlIIIIIIlllIll + llllllllllllllIlIlIlIIIIIIlllIlI + 1, 0.0).tex(1.0, 1.0).color(0, 0, 0, 255).endVertex();
                llllllllllllllIlIlIlIIIIIIllllIl.pos(llllllllllllllIlIlIlIIIIIIlllIII - 1, llllllllllllllIlIlIlIIIIIIlllIll - 1, 0.0).tex(1.0, 0.0).color(0, 0, 0, 255).endVertex();
                llllllllllllllIlIlIlIIIIIIllllIl.pos(llllllllllllllIlIlIlIIIIIIlllIIl + 1, llllllllllllllIlIlIlIIIIIIlllIll - 1, 0.0).tex(0.0, 0.0).color(0, 0, 0, 255).endVertex();
                llllllllllllllIlIlIlIIIIIIlllllI.draw();
                GlStateManager.enableTexture2D();
            }
            if (llllllllllllllIlIlIlIIIIIIlllIll >= this.top - this.slotHeight && llllllllllllllIlIlIlIIIIIIlllIll <= this.bottom) {
                this.func_192637_a(llllllllllllllIlIlIlIIIIIIllllII, llllllllllllllIlIlIlIIIIIlIIIlII, llllllllllllllIlIlIlIIIIIIlllIll, llllllllllllllIlIlIlIIIIIIlllIlI, llllllllllllllIlIlIlIIIIIIllIlII, llllllllllllllIlIlIlIIIIIlIIIIIl, llllllllllllllIlIlIlIIIIIIllIIlI);
            }
        }
    }
    
    protected abstract void func_192637_a(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5, final float p6);
    
    protected void clickedHeader(final int llllllllllllllIlIlIlIIIIlllIlIIl, final int llllllllllllllIlIlIlIIIIlllIlIII) {
    }
    
    public int getMaxScroll() {
        return Math.max(0, this.getContentHeight() - (this.bottom - this.top - 4));
    }
    
    public int getSlotIndexFromScreenCoords(final int llllllllllllllIlIlIlIIIIllIlllII, final int llllllllllllllIlIlIlIIIIllIlIlII) {
        final int llllllllllllllIlIlIlIIIIllIllIlI = this.left + this.width / 2 - this.getListWidth() / 2;
        final int llllllllllllllIlIlIlIIIIllIllIIl = this.left + this.width / 2 + this.getListWidth() / 2;
        final int llllllllllllllIlIlIlIIIIllIllIII = llllllllllllllIlIlIlIIIIllIlIlII - this.top - this.headerPadding + (int)this.amountScrolled - 4;
        final int llllllllllllllIlIlIlIIIIllIlIlll = llllllllllllllIlIlIlIIIIllIllIII / this.slotHeight;
        return (llllllllllllllIlIlIlIIIIllIlllII < this.getScrollBarX() && llllllllllllllIlIlIlIIIIllIlllII >= llllllllllllllIlIlIlIIIIllIllIlI && llllllllllllllIlIlIlIIIIllIlllII <= llllllllllllllIlIlIlIIIIllIllIIl && llllllllllllllIlIlIlIIIIllIlIlll >= 0 && llllllllllllllIlIlIlIIIIllIllIII >= 0 && llllllllllllllIlIlIlIIIIllIlIlll < this.getSize()) ? llllllllllllllIlIlIlIIIIllIlIlll : -1;
    }
    
    public void actionPerformed(final GuiButton llllllllllllllIlIlIlIIIIlIlIlllI) {
        if (llllllllllllllIlIlIlIIIIlIlIlllI.enabled) {
            if (llllllllllllllIlIlIlIIIIlIlIlllI.id == this.scrollUpButtonID) {
                this.amountScrolled -= this.slotHeight * 2 / 3;
                this.initialClickY = -2;
                this.bindAmountScrolled();
            }
            else if (llllllllllllllIlIlIlIIIIlIlIlllI.id == this.scrollDownButtonID) {
                this.amountScrolled += this.slotHeight * 2 / 3;
                this.initialClickY = -2;
                this.bindAmountScrolled();
            }
        }
    }
    
    protected abstract boolean isSelected(final int p0);
    
    protected void drawListHeader(final int llllllllllllllIlIlIlIIIIlllIllIl, final int llllllllllllllIlIlIlIIIIlllIllII, final Tessellator llllllllllllllIlIlIlIIIIlllIlIll) {
    }
    
    public GuiSlot(final Minecraft llllllllllllllIlIlIlIIIlIIIllIlI, final int llllllllllllllIlIlIlIIIlIIlIIIII, final int llllllllllllllIlIlIlIIIlIIIlllll, final int llllllllllllllIlIlIlIIIlIIIlIlll, final int llllllllllllllIlIlIlIIIlIIIlllIl, final int llllllllllllllIlIlIlIIIlIIIlIlIl) {
        this.centerListVertically = true;
        this.initialClickY = -2;
        this.selectedElement = -1;
        this.visible = true;
        this.showSelectionBox = true;
        this.enabled = true;
        this.mc = llllllllllllllIlIlIlIIIlIIIllIlI;
        this.width = llllllllllllllIlIlIlIIIlIIlIIIII;
        this.height = llllllllllllllIlIlIlIIIlIIIlllll;
        this.top = llllllllllllllIlIlIlIIIlIIIlIlll;
        this.bottom = llllllllllllllIlIlIlIIIlIIIlllIl;
        this.slotHeight = llllllllllllllIlIlIlIIIlIIIlIlIl;
        this.left = 0;
        this.right = llllllllllllllIlIlIlIIIlIIlIIIII;
    }
    
    public void func_193651_b(final boolean llllllllllllllIlIlIlIIIlIIIIIIlI) {
        this.showSelectionBox = llllllllllllllIlIlIlIIIlIIIIIIlI;
    }
    
    protected abstract int getSize();
    
    protected void setHasListHeader(final boolean llllllllllllllIlIlIlIIIIlllllIII, final int llllllllllllllIlIlIlIIIIlllllIlI) {
        this.hasListHeader = llllllllllllllIlIlIlIIIIlllllIII;
        this.headerPadding = llllllllllllllIlIlIlIIIIlllllIlI;
        if (!llllllllllllllIlIlIlIIIIlllllIII) {
            this.headerPadding = 0;
        }
    }
    
    protected abstract void elementClicked(final int p0, final boolean p1, final int p2, final int p3);
    
    public int getListWidth() {
        return 220;
    }
    
    protected void renderDecorations(final int llllllllllllllIlIlIlIIIIlllIIllI, final int llllllllllllllIlIlIlIIIIlllIIlIl) {
    }
    
    protected void drawContainerBackground(final Tessellator llllllllllllllIlIlIIllllllllllII) {
        final BufferBuilder llllllllllllllIlIlIIllllllllllll = llllllllllllllIlIlIIllllllllllII.getBuffer();
        this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float llllllllllllllIlIlIIlllllllllllI = 32.0f;
        llllllllllllllIlIlIIllllllllllll.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllllIlIlIIllllllllllll.pos(this.left, this.bottom, 0.0).tex(this.left / 32.0f, (this.bottom + (int)this.amountScrolled) / 32.0f).color(32, 32, 32, 255).endVertex();
        llllllllllllllIlIlIIllllllllllll.pos(this.right, this.bottom, 0.0).tex(this.right / 32.0f, (this.bottom + (int)this.amountScrolled) / 32.0f).color(32, 32, 32, 255).endVertex();
        llllllllllllllIlIlIIllllllllllll.pos(this.right, this.top, 0.0).tex(this.right / 32.0f, (this.top + (int)this.amountScrolled) / 32.0f).color(32, 32, 32, 255).endVertex();
        llllllllllllllIlIlIIllllllllllll.pos(this.left, this.top, 0.0).tex(this.left / 32.0f, (this.top + (int)this.amountScrolled) / 32.0f).color(32, 32, 32, 255).endVertex();
        llllllllllllllIlIlIIllllllllllII.draw();
    }
    
    protected int getContentHeight() {
        return this.getSize() * this.slotHeight + this.headerPadding;
    }
    
    protected abstract void drawBackground();
    
    protected void overlayBackground(final int llllllllllllllIlIlIlIIIIIIIlIlIl, final int llllllllllllllIlIlIlIIIIIIIlllII, final int llllllllllllllIlIlIlIIIIIIIllIll, final int llllllllllllllIlIlIlIIIIIIIlIIlI) {
        final Tessellator llllllllllllllIlIlIlIIIIIIIllIIl = Tessellator.getInstance();
        final BufferBuilder llllllllllllllIlIlIlIIIIIIIllIII = llllllllllllllIlIlIlIIIIIIIllIIl.getBuffer();
        this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final float llllllllllllllIlIlIlIIIIIIIlIlll = 32.0f;
        llllllllllllllIlIlIlIIIIIIIllIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        llllllllllllllIlIlIlIIIIIIIllIII.pos(this.left, llllllllllllllIlIlIlIIIIIIIlllII, 0.0).tex(0.0, llllllllllllllIlIlIlIIIIIIIlllII / 32.0f).color(64, 64, 64, llllllllllllllIlIlIlIIIIIIIlIIlI).endVertex();
        llllllllllllllIlIlIlIIIIIIIllIII.pos(this.left + this.width, llllllllllllllIlIlIlIIIIIIIlllII, 0.0).tex(this.width / 32.0f, llllllllllllllIlIlIlIIIIIIIlllII / 32.0f).color(64, 64, 64, llllllllllllllIlIlIlIIIIIIIlIIlI).endVertex();
        llllllllllllllIlIlIlIIIIIIIllIII.pos(this.left + this.width, llllllllllllllIlIlIlIIIIIIIlIlIl, 0.0).tex(this.width / 32.0f, llllllllllllllIlIlIlIIIIIIIlIlIl / 32.0f).color(64, 64, 64, llllllllllllllIlIlIlIIIIIIIllIll).endVertex();
        llllllllllllllIlIlIlIIIIIIIllIII.pos(this.left, llllllllllllllIlIlIlIIIIIIIlIlIl, 0.0).tex(0.0, llllllllllllllIlIlIlIIIIIIIlIlIl / 32.0f).color(64, 64, 64, llllllllllllllIlIlIlIIIIIIIllIll).endVertex();
        llllllllllllllIlIlIlIIIIIIIllIIl.draw();
    }
    
    public boolean getEnabled() {
        return this.enabled;
    }
    
    public boolean isMouseYWithinSlotBounds(final int llllllllllllllIlIlIlIIIIlIlllIlI) {
        return llllllllllllllIlIlIlIIIIlIlllIlI >= this.top && llllllllllllllIlIlIlIIIIlIlllIlI <= this.bottom && this.mouseX >= this.left && this.mouseX <= this.right;
    }
    
    protected int getScrollBarX() {
        return this.width / 2 + 124;
    }
    
    protected void func_192639_a(final int llllllllllllllIlIlIlIIIIllllIIlI, final int llllllllllllllIlIlIlIIIIllllIIIl, final int llllllllllllllIlIlIlIIIIllllIIII, final float llllllllllllllIlIlIlIIIIlllIllll) {
    }
    
    public void scrollBy(final int llllllllllllllIlIlIlIIIIlIllIIlI) {
        this.amountScrolled += llllllllllllllIlIlIlIIIIlIllIIlI;
        this.bindAmountScrolled();
        this.initialClickY = -2;
    }
    
    public void setSlotXBoundsFromLeft(final int llllllllllllllIlIlIlIIIIIIIIlIIl) {
        this.left = llllllllllllllIlIlIlIIIIIIIIlIIl;
        this.right = llllllllllllllIlIlIlIIIIIIIIlIIl + this.width;
    }
    
    public void registerScrollButtons(final int llllllllllllllIlIlIlIIIIllIIlIll, final int llllllllllllllIlIlIlIIIIllIIlIlI) {
        this.scrollUpButtonID = llllllllllllllIlIlIlIIIIllIIlIll;
        this.scrollDownButtonID = llllllllllllllIlIlIlIIIIllIIlIlI;
    }
}
