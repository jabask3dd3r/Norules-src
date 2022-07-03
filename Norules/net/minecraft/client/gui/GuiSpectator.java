package net.minecraft.client.gui;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.spectator.categories.*;
import net.minecraft.client.gui.spectator.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.settings.*;
import net.minecraft.util.math.*;

public class GuiSpectator extends Gui implements ISpectatorMenuRecipient
{
    private static final /* synthetic */ ResourceLocation WIDGETS;
    public static final /* synthetic */ ResourceLocation SPECTATOR_WIDGETS;
    private /* synthetic */ long lastSelectionTime;
    private /* synthetic */ SpectatorMenu menu;
    private final /* synthetic */ Minecraft mc;
    
    public void renderTooltip(final ScaledResolution llllllllllllllIIlIIIllIlllllllII, final float llllllllllllllIIlIIIlllIIIIIIIll) {
        if (this.menu != null) {
            final float llllllllllllllIIlIIIlllIIIIIIIlI = this.getHotbarAlpha();
            if (llllllllllllllIIlIIIlllIIIIIIIlI <= 0.0f) {
                this.menu.exit();
            }
            else {
                final int llllllllllllllIIlIIIlllIIIIIIIIl = llllllllllllllIIlIIIllIlllllllII.getScaledWidth() / 2;
                final float llllllllllllllIIlIIIlllIIIIIIIII = this.zLevel;
                this.zLevel = -90.0f;
                final float llllllllllllllIIlIIIllIlllllllll = llllllllllllllIIlIIIllIlllllllII.getScaledHeight() - 22.0f * llllllllllllllIIlIIIlllIIIIIIIlI;
                final SpectatorDetails llllllllllllllIIlIIIllIllllllllI = this.menu.getCurrentPage();
                this.renderPage(llllllllllllllIIlIIIllIlllllllII, llllllllllllllIIlIIIlllIIIIIIIlI, llllllllllllllIIlIIIlllIIIIIIIIl, llllllllllllllIIlIIIllIlllllllll, llllllllllllllIIlIIIllIllllllllI);
                this.zLevel = llllllllllllllIIlIIIlllIIIIIIIII;
            }
        }
    }
    
    public void onMiddleClick() {
        this.lastSelectionTime = Minecraft.getSystemTime();
        if (this.isMenuActive()) {
            final int llllllllllllllIIlIIIllIllIIllllI = this.menu.getSelectedSlot();
            if (llllllllllllllIIlIIIllIllIIllllI != -1) {
                this.menu.selectSlot(llllllllllllllIIlIIIllIllIIllllI);
            }
        }
        else {
            this.menu = new SpectatorMenu(this);
        }
    }
    
    public void renderSelectedItem(final ScaledResolution llllllllllllllIIlIIIllIllIlllllI) {
        final int llllllllllllllIIlIIIllIllIllllIl = (int)(this.getHotbarAlpha() * 255.0f);
        if (llllllllllllllIIlIIIllIllIllllIl > 3 && this.menu != null) {
            final ISpectatorMenuObject llllllllllllllIIlIIIllIllIllllII = this.menu.getSelectedItem();
            final String llllllllllllllIIlIIIllIllIlllIll = (llllllllllllllIIlIIIllIllIllllII == SpectatorMenu.EMPTY_SLOT) ? this.menu.getSelectedCategory().getPrompt().getFormattedText() : llllllllllllllIIlIIIllIllIllllII.getSpectatorName().getFormattedText();
            if (llllllllllllllIIlIIIllIllIlllIll != null) {
                final int llllllllllllllIIlIIIllIllIlllIlI = (llllllllllllllIIlIIIllIllIlllllI.getScaledWidth() - this.mc.fontRendererObj.getStringWidth(llllllllllllllIIlIIIllIllIlllIll)) / 2;
                final int llllllllllllllIIlIIIllIllIlllIIl = llllllllllllllIIlIIIllIllIlllllI.getScaledHeight() - 35;
                GlStateManager.pushMatrix();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                this.mc.fontRendererObj.drawStringWithShadow(llllllllllllllIIlIIIllIllIlllIll, (float)llllllllllllllIIlIIIllIllIlllIlI, (float)llllllllllllllIIlIIIllIllIlllIIl, 16777215 + (llllllllllllllIIlIIIllIllIllllIl << 24));
                GlStateManager.disableBlend();
                GlStateManager.popMatrix();
            }
        }
    }
    
    static {
        WIDGETS = new ResourceLocation("textures/gui/widgets.png");
        SPECTATOR_WIDGETS = new ResourceLocation("textures/gui/spectator_widgets.png");
    }
    
    public void onHotbarSelected(final int llllllllllllllIIlIIIlllIIIIlIlIl) {
        this.lastSelectionTime = Minecraft.getSystemTime();
        if (this.menu != null) {
            this.menu.selectSlot(llllllllllllllIIlIIIlllIIIIlIlIl);
        }
        else {
            this.menu = new SpectatorMenu(this);
        }
    }
    
    public boolean isMenuActive() {
        return this.menu != null;
    }
    
    protected void renderPage(final ScaledResolution llllllllllllllIIlIIIllIllllIIlll, final float llllllllllllllIIlIIIllIllllIllIl, final int llllllllllllllIIlIIIllIllllIllII, final float llllllllllllllIIlIIIllIllllIIlII, final SpectatorDetails llllllllllllllIIlIIIllIllllIlIlI) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.color(1.0f, 1.0f, 1.0f, llllllllllllllIIlIIIllIllllIllIl);
        this.mc.getTextureManager().bindTexture(GuiSpectator.WIDGETS);
        this.drawTexturedModalRect((float)(llllllllllllllIIlIIIllIllllIllII - 91), llllllllllllllIIlIIIllIllllIIlII, 0, 0, 182, 22);
        if (llllllllllllllIIlIIIllIllllIlIlI.getSelectedSlot() >= 0) {
            this.drawTexturedModalRect((float)(llllllllllllllIIlIIIllIllllIllII - 91 - 1 + llllllllllllllIIlIIIllIllllIlIlI.getSelectedSlot() * 20), llllllllllllllIIlIIIllIllllIIlII - 1.0f, 0, 22, 24, 22);
        }
        RenderHelper.enableGUIStandardItemLighting();
        for (int llllllllllllllIIlIIIllIllllIlIIl = 0; llllllllllllllIIlIIIllIllllIlIIl < 9; ++llllllllllllllIIlIIIllIllllIlIIl) {
            this.renderSlot(llllllllllllllIIlIIIllIllllIlIIl, llllllllllllllIIlIIIllIllllIIlll.getScaledWidth() / 2 - 90 + llllllllllllllIIlIIIllIllllIlIIl * 20 + 2, llllllllllllllIIlIIIllIllllIIlII + 3.0f, llllllllllllllIIlIIIllIllllIllIl, llllllllllllllIIlIIIllIllllIlIlI.getObject(llllllllllllllIIlIIIllIllllIlIIl));
        }
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.disableBlend();
    }
    
    public void onMouseScroll(final int llllllllllllllIIlIIIllIllIlIIIll) {
        int llllllllllllllIIlIIIllIllIlIIlIl;
        for (llllllllllllllIIlIIIllIllIlIIlIl = this.menu.getSelectedSlot() + llllllllllllllIIlIIIllIllIlIIIll; llllllllllllllIIlIIIllIllIlIIlIl >= 0 && llllllllllllllIIlIIIllIllIlIIlIl <= 8 && (this.menu.getItem(llllllllllllllIIlIIIllIllIlIIlIl) == SpectatorMenu.EMPTY_SLOT || !this.menu.getItem(llllllllllllllIIlIIIllIllIlIIlIl).isEnabled()); llllllllllllllIIlIIIllIllIlIIlIl += llllllllllllllIIlIIIllIllIlIIIll) {}
        if (llllllllllllllIIlIIIllIllIlIIlIl >= 0 && llllllllllllllIIlIIIllIllIlIIlIl <= 8) {
            this.menu.selectSlot(llllllllllllllIIlIIIllIllIlIIlIl);
            this.lastSelectionTime = Minecraft.getSystemTime();
        }
    }
    
    private void renderSlot(final int llllllllllllllIIlIIIllIlllIIlllI, final int llllllllllllllIIlIIIllIlllIlIllI, final float llllllllllllllIIlIIIllIlllIIllII, final float llllllllllllllIIlIIIllIlllIlIlII, final ISpectatorMenuObject llllllllllllllIIlIIIllIlllIlIIll) {
        this.mc.getTextureManager().bindTexture(GuiSpectator.SPECTATOR_WIDGETS);
        if (llllllllllllllIIlIIIllIlllIlIIll != SpectatorMenu.EMPTY_SLOT) {
            final int llllllllllllllIIlIIIllIlllIlIIlI = (int)(llllllllllllllIIlIIIllIlllIlIlII * 255.0f);
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)llllllllllllllIIlIIIllIlllIlIllI, llllllllllllllIIlIIIllIlllIIllII, 0.0f);
            final float llllllllllllllIIlIIIllIlllIlIIIl = llllllllllllllIIlIIIllIlllIlIIll.isEnabled() ? 1.0f : 0.25f;
            GlStateManager.color(llllllllllllllIIlIIIllIlllIlIIIl, llllllllllllllIIlIIIllIlllIlIIIl, llllllllllllllIIlIIIllIlllIlIIIl, llllllllllllllIIlIIIllIlllIlIlII);
            llllllllllllllIIlIIIllIlllIlIIll.renderIcon(llllllllllllllIIlIIIllIlllIlIIIl, llllllllllllllIIlIIIllIlllIlIIlI);
            GlStateManager.popMatrix();
            final String llllllllllllllIIlIIIllIlllIlIIII = String.valueOf(GameSettings.getKeyDisplayString(this.mc.gameSettings.keyBindsHotbar[llllllllllllllIIlIIIllIlllIIlllI].getKeyCode()));
            if (llllllllllllllIIlIIIllIlllIlIIlI > 3 && llllllllllllllIIlIIIllIlllIlIIll.isEnabled()) {
                this.mc.fontRendererObj.drawStringWithShadow(llllllllllllllIIlIIIllIlllIlIIII, (float)(llllllllllllllIIlIIIllIlllIlIllI + 19 - 2 - this.mc.fontRendererObj.getStringWidth(llllllllllllllIIlIIIllIlllIlIIII)), llllllllllllllIIlIIIllIlllIIllII + 6.0f + 3.0f, 16777215 + (llllllllllllllIIlIIIllIlllIlIIlI << 24));
            }
        }
    }
    
    @Override
    public void onSpectatorMenuClosed(final SpectatorMenu llllllllllllllIIlIIIllIllIlIllll) {
        this.menu = null;
        this.lastSelectionTime = 0L;
    }
    
    private float getHotbarAlpha() {
        final long llllllllllllllIIlIIIlllIIIIIllll = this.lastSelectionTime - Minecraft.getSystemTime() + 5000L;
        return MathHelper.clamp(llllllllllllllIIlIIIlllIIIIIllll / 2000.0f, 0.0f, 1.0f);
    }
    
    public GuiSpectator(final Minecraft llllllllllllllIIlIIIlllIIIIllIll) {
        this.mc = llllllllllllllIIlIIIlllIIIIllIll;
    }
}
