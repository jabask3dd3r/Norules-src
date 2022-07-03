package net.minecraft.client;

import net.minecraft.client.shader.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class LoadingScreenRenderer implements IProgressUpdate
{
    private /* synthetic */ long systemTime;
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ ScaledResolution scaledResolution;
    private /* synthetic */ String message;
    private /* synthetic */ boolean loadingSuccess;
    private /* synthetic */ String currentlyDisplayedText;
    private final /* synthetic */ Framebuffer framebuffer;
    
    @Override
    public void resetProgressAndMessage(final String lllllllllllllIlIlllllIIllllIlllI) {
        this.loadingSuccess = false;
        this.displayString(lllllllllllllIlIlllllIIllllIlllI);
    }
    
    public LoadingScreenRenderer(final Minecraft lllllllllllllIlIlllllIIlllllIllI) {
        this.message = "";
        this.currentlyDisplayedText = "";
        this.systemTime = Minecraft.getSystemTime();
        this.mc = lllllllllllllIlIlllllIIlllllIllI;
        this.scaledResolution = new ScaledResolution(lllllllllllllIlIlllllIIlllllIllI);
        this.framebuffer = new Framebuffer(lllllllllllllIlIlllllIIlllllIllI.displayWidth, lllllllllllllIlIlllllIIlllllIllI.displayHeight, false);
        this.framebuffer.setFramebufferFilter(9728);
    }
    
    @Override
    public void setLoadingProgress(final int lllllllllllllIlIlllllIIllIlllIlI) {
        if (!this.mc.running) {
            if (!this.loadingSuccess) {
                throw new MinecraftError();
            }
        }
        else {
            final long lllllllllllllIlIlllllIIlllIIIlll = Minecraft.getSystemTime();
            if (lllllllllllllIlIlllllIIlllIIIlll - this.systemTime >= 100L) {
                this.systemTime = lllllllllllllIlIlllllIIlllIIIlll;
                final ScaledResolution lllllllllllllIlIlllllIIlllIIIllI = new ScaledResolution(this.mc);
                final int lllllllllllllIlIlllllIIlllIIIlIl = lllllllllllllIlIlllllIIlllIIIllI.getScaleFactor();
                final int lllllllllllllIlIlllllIIlllIIIlII = lllllllllllllIlIlllllIIlllIIIllI.getScaledWidth();
                final int lllllllllllllIlIlllllIIlllIIIIll = lllllllllllllIlIlllllIIlllIIIllI.getScaledHeight();
                if (OpenGlHelper.isFramebufferEnabled()) {
                    this.framebuffer.framebufferClear();
                }
                else {
                    GlStateManager.clear(256);
                }
                this.framebuffer.bindFramebuffer(false);
                GlStateManager.matrixMode(5889);
                GlStateManager.loadIdentity();
                GlStateManager.ortho(0.0, lllllllllllllIlIlllllIIlllIIIllI.getScaledWidth_double(), lllllllllllllIlIlllllIIlllIIIllI.getScaledHeight_double(), 0.0, 100.0, 300.0);
                GlStateManager.matrixMode(5888);
                GlStateManager.loadIdentity();
                GlStateManager.translate(0.0f, 0.0f, -200.0f);
                if (!OpenGlHelper.isFramebufferEnabled()) {
                    GlStateManager.clear(16640);
                }
                final Tessellator lllllllllllllIlIlllllIIlllIIIIlI = Tessellator.getInstance();
                final BufferBuilder lllllllllllllIlIlllllIIlllIIIIIl = lllllllllllllIlIlllllIIlllIIIIlI.getBuffer();
                this.mc.getTextureManager().bindTexture(Gui.OPTIONS_BACKGROUND);
                final float lllllllllllllIlIlllllIIlllIIIIII = 32.0f;
                lllllllllllllIlIlllllIIlllIIIIIl.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                lllllllllllllIlIlllllIIlllIIIIIl.pos(0.0, lllllllllllllIlIlllllIIlllIIIIll, 0.0).tex(0.0, lllllllllllllIlIlllllIIlllIIIIll / 32.0f).color(128, 64, 64, 255).endVertex();
                lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIlllIIIlII, lllllllllllllIlIlllllIIlllIIIIll, 0.0).tex(lllllllllllllIlIlllllIIlllIIIlII / 32.0f, lllllllllllllIlIlllllIIlllIIIIll / 32.0f).color(64, 64, 64, 255).endVertex();
                lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIlllIIIlII, 0.0, 0.0).tex(lllllllllllllIlIlllllIIlllIIIlII / 32.0f, 0.0).color(128, 64, 64, 255).endVertex();
                lllllllllllllIlIlllllIIlllIIIIIl.pos(0.0, 0.0, 0.0).tex(0.0, 0.0).color(64, 128, 64, 255).endVertex();
                lllllllllllllIlIlllllIIlllIIIIlI.draw();
                if (lllllllllllllIlIlllllIIllIlllIlI >= 0) {
                    final int lllllllllllllIlIlllllIIllIllllll = 100;
                    final int lllllllllllllIlIlllllIIllIlllllI = 2;
                    final int lllllllllllllIlIlllllIIllIllllIl = lllllllllllllIlIlllllIIlllIIIlII / 2 - 50;
                    final int lllllllllllllIlIlllllIIllIllllII = lllllllllllllIlIlllllIIlllIIIIll / 2 + 16;
                    GlStateManager.disableTexture2D();
                    lllllllllllllIlIlllllIIlllIIIIIl.begin(7, DefaultVertexFormats.POSITION_COLOR);
                    lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIllIllllIl, lllllllllllllIlIlllllIIllIllllII, 0.0).color(128, 128, 128, 255).endVertex();
                    lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIllIllllIl, lllllllllllllIlIlllllIIllIllllII + 2, 0.0).color(128, 128, 128, 255).endVertex();
                    lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIllIllllIl + 100, lllllllllllllIlIlllllIIllIllllII + 2, 0.0).color(128, 128, 128, 255).endVertex();
                    lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIllIllllIl + 100, lllllllllllllIlIlllllIIllIllllII, 0.0).color(128, 128, 128, 255).endVertex();
                    lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIllIllllIl, lllllllllllllIlIlllllIIllIllllII, 0.0).color(128, 255, 128, 255).endVertex();
                    lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIllIllllIl, lllllllllllllIlIlllllIIllIllllII + 2, 0.0).color(128, 255, 128, 255).endVertex();
                    lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIllIllllIl + lllllllllllllIlIlllllIIllIlllIlI, lllllllllllllIlIlllllIIllIllllII + 2, 0.0).color(128, 255, 128, 255).endVertex();
                    lllllllllllllIlIlllllIIlllIIIIIl.pos(lllllllllllllIlIlllllIIllIllllIl + lllllllllllllIlIlllllIIllIlllIlI, lllllllllllllIlIlllllIIllIllllII, 0.0).color(128, 255, 128, 255).endVertex();
                    lllllllllllllIlIlllllIIlllIIIIlI.draw();
                    GlStateManager.enableTexture2D();
                }
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                this.mc.fontRendererObj.drawStringWithShadow(this.currentlyDisplayedText, (float)((lllllllllllllIlIlllllIIlllIIIlII - this.mc.fontRendererObj.getStringWidth(this.currentlyDisplayedText)) / 2), (float)(lllllllllllllIlIlllllIIlllIIIIll / 2 - 4 - 16), 16777215);
                this.mc.fontRendererObj.drawStringWithShadow(this.message, (float)((lllllllllllllIlIlllllIIlllIIIlII - this.mc.fontRendererObj.getStringWidth(this.message)) / 2), (float)(lllllllllllllIlIlllllIIlllIIIIll / 2 - 4 + 8), 16777215);
                this.framebuffer.unbindFramebuffer();
                if (OpenGlHelper.isFramebufferEnabled()) {
                    this.framebuffer.framebufferRender(lllllllllllllIlIlllllIIlllIIIlII * lllllllllllllIlIlllllIIlllIIIlIl, lllllllllllllIlIlllllIIlllIIIIll * lllllllllllllIlIlllllIIlllIIIlIl);
                }
                this.mc.updateDisplay();
                try {
                    Thread.yield();
                }
                catch (Exception ex) {}
            }
        }
    }
    
    @Override
    public void displayLoadingString(final String lllllllllllllIlIlllllIIlllIllIlI) {
        if (!this.mc.running) {
            if (!this.loadingSuccess) {
                throw new MinecraftError();
            }
        }
        else {
            this.systemTime = 0L;
            this.message = lllllllllllllIlIlllllIIlllIllIlI;
            this.setLoadingProgress(-1);
            this.systemTime = 0L;
        }
    }
    
    @Override
    public void displaySavingString(final String lllllllllllllIlIlllllIIllllIlIlI) {
        this.loadingSuccess = true;
        this.displayString(lllllllllllllIlIlllllIIllllIlIlI);
    }
    
    @Override
    public void setDoneWorking() {
    }
    
    private void displayString(final String lllllllllllllIlIlllllIIlllIlllll) {
        this.currentlyDisplayedText = lllllllllllllIlIlllllIIlllIlllll;
        if (!this.mc.running) {
            if (!this.loadingSuccess) {
                throw new MinecraftError();
            }
        }
        else {
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            if (OpenGlHelper.isFramebufferEnabled()) {
                final int lllllllllllllIlIlllllIIllllIIIlI = this.scaledResolution.getScaleFactor();
                GlStateManager.ortho(0.0, this.scaledResolution.getScaledWidth() * lllllllllllllIlIlllllIIllllIIIlI, this.scaledResolution.getScaledHeight() * lllllllllllllIlIlllllIIllllIIIlI, 0.0, 100.0, 300.0);
            }
            else {
                final ScaledResolution lllllllllllllIlIlllllIIllllIIIIl = new ScaledResolution(this.mc);
                GlStateManager.ortho(0.0, lllllllllllllIlIlllllIIllllIIIIl.getScaledWidth_double(), lllllllllllllIlIlllllIIllllIIIIl.getScaledHeight_double(), 0.0, 100.0, 300.0);
            }
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -200.0f);
        }
    }
}
