package net.minecraft.client.gui;

import net.minecraft.util.*;
import font.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import me.nrules.utils.render.*;
import java.awt.*;
import net.minecraft.init.*;
import net.minecraft.client.audio.*;

public class GuiButton extends Gui
{
    /* synthetic */ MinecraftFontRenderer font;
    public /* synthetic */ boolean enabled;
    public /* synthetic */ int xPosition;
    public /* synthetic */ int id;
    protected static final /* synthetic */ ResourceLocation BUTTON_TEXTURES;
    private static /* synthetic */ int fade;
    public /* synthetic */ String displayString;
    protected /* synthetic */ int height;
    public /* synthetic */ boolean visible;
    protected /* synthetic */ int width;
    protected /* synthetic */ boolean hovered;
    public /* synthetic */ int yPosition;
    
    public void drawButtonForegroundLayer(final int lllllllllllllIIIlllllIIlllllllII, final int lllllllllllllIIIlllllIIllllllIll) {
    }
    
    public GuiButton(final int lllllllllllllIIIlllllIlIIlIIIlII, final int lllllllllllllIIIlllllIlIIlIIlIlI, final int lllllllllllllIIIlllllIlIIlIIlIIl, final int lllllllllllllIIIlllllIlIIlIIIIIl, final int lllllllllllllIIIlllllIlIIlIIIIII, final String lllllllllllllIIIlllllIlIIlIIIllI) {
        this.font = FontLoader.INSTANCE.open_sans_20;
        this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = lllllllllllllIIIlllllIlIIlIIIlII;
        this.xPosition = lllllllllllllIIIlllllIlIIlIIlIlI;
        this.yPosition = lllllllllllllIIIlllllIlIIlIIlIIl;
        this.width = lllllllllllllIIIlllllIlIIlIIIIIl;
        this.height = lllllllllllllIIIlllllIlIIlIIIIII;
        this.displayString = lllllllllllllIIIlllllIlIIlIIIllI;
    }
    
    public boolean mousePressed(final Minecraft lllllllllllllIIIlllllIlIIIIIIllI, final int lllllllllllllIIIlllllIlIIIIIIlIl, final int lllllllllllllIIIlllllIlIIIIIIIIl) {
        return this.enabled && this.visible && lllllllllllllIIIlllllIlIIIIIIlIl >= this.xPosition && lllllllllllllIIIlllllIlIIIIIIIIl >= this.yPosition && lllllllllllllIIIlllllIlIIIIIIlIl < this.xPosition + this.width && lllllllllllllIIIlllllIlIIIIIIIIl < this.yPosition + this.height;
    }
    
    static {
        BUTTON_TEXTURES = new ResourceLocation("textures/gui/widgets.png");
        GuiButton.fade = 20;
    }
    
    public static void drawRect(double lllllllllllllIIIlllllIIllllIlIII, double lllllllllllllIIIlllllIIlllIllIlI, double lllllllllllllIIIlllllIIlllIllIIl, double lllllllllllllIIIlllllIIlllIllIII, final int lllllllllllllIIIlllllIIlllIlIlll) {
        if (lllllllllllllIIIlllllIIllllIlIII < lllllllllllllIIIlllllIIlllIllIIl) {
            final double lllllllllllllIIIlllllIIllllIIIll = lllllllllllllIIIlllllIIllllIlIII;
            lllllllllllllIIIlllllIIllllIlIII = lllllllllllllIIIlllllIIlllIllIIl;
            lllllllllllllIIIlllllIIlllIllIIl = lllllllllllllIIIlllllIIllllIIIll;
        }
        if (lllllllllllllIIIlllllIIlllIllIlI < lllllllllllllIIIlllllIIlllIllIII) {
            final double lllllllllllllIIIlllllIIllllIIIlI = lllllllllllllIIIlllllIIlllIllIlI;
            lllllllllllllIIIlllllIIlllIllIlI = lllllllllllllIIIlllllIIlllIllIII;
            lllllllllllllIIIlllllIIlllIllIII = lllllllllllllIIIlllllIIllllIIIlI;
        }
        final float lllllllllllllIIIlllllIIllllIIIIl = (lllllllllllllIIIlllllIIlllIlIlll >> 24 & 0xFF) / 255.0f;
        final float lllllllllllllIIIlllllIIllllIIIII = (lllllllllllllIIIlllllIIlllIlIlll >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIIlllllIIlllIlllll = (lllllllllllllIIIlllllIIlllIlIlll >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIIlllllIIlllIllllI = (lllllllllllllIIIlllllIIlllIlIlll & 0xFF) / 255.0f;
        final Tessellator lllllllllllllIIIlllllIIlllIlllIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllIIIlllllIIlllIlllII = lllllllllllllIIIlllllIIlllIlllIl.getBuffer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(lllllllllllllIIIlllllIIllllIIIII, lllllllllllllIIIlllllIIlllIlllll, lllllllllllllIIIlllllIIlllIllllI, lllllllllllllIIIlllllIIllllIIIIl);
        lllllllllllllIIIlllllIIlllIlllII.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllIIIlllllIIlllIlllII.pos(lllllllllllllIIIlllllIIllllIlIII, lllllllllllllIIIlllllIIlllIllIII, 0.0).endVertex();
        lllllllllllllIIIlllllIIlllIlllII.pos(lllllllllllllIIIlllllIIlllIllIIl, lllllllllllllIIIlllllIIlllIllIII, 0.0).endVertex();
        lllllllllllllIIIlllllIIlllIlllII.pos(lllllllllllllIIIlllllIIlllIllIIl, lllllllllllllIIIlllllIIlllIllIlI, 0.0).endVertex();
        lllllllllllllIIIlllllIIlllIlllII.pos(lllllllllllllIIIlllllIIllllIlIII, lllllllllllllIIIlllllIIlllIllIlI, 0.0).endVertex();
        lllllllllllllIIIlllllIIlllIlllIl.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    public void func_191745_a(final Minecraft lllllllllllllIIIlllllIlIIIIlllII, final int lllllllllllllIIIlllllIlIIIIllIll, final int lllllllllllllIIIlllllIlIIIlIIllI) {
        if (this.visible) {
            final FontRenderer lllllllllllllIIIlllllIlIIIlIIlIl = lllllllllllllIIIlllllIlIIIIlllII.fontRendererObj;
            lllllllllllllIIIlllllIlIIIIlllII.getTextureManager().bindTexture(GuiButton.BUTTON_TEXTURES);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.hovered = (lllllllllllllIIIlllllIlIIIIllIll >= this.xPosition && lllllllllllllIIIlllllIlIIIlIIllI >= this.yPosition && lllllllllllllIIIlllllIlIIIIllIll < this.xPosition + this.width && lllllllllllllIIIlllllIlIIIlIIllI < this.yPosition + this.height);
            int lllllllllllllIIIlllllIlIIIlIIlII = ColorUtils.astolfoColors(0, 0);
            Color lllllllllllllIIIlllllIlIIIlIIIll = new Color(255, 255, 255, 255);
            final boolean lllllllllllllIIIlllllIlIIIlIIIlI = lllllllllllllIIIlllllIlIIIIllIll >= this.xPosition && lllllllllllllIIIlllllIlIIIlIIllI >= this.yPosition && lllllllllllllIIIlllllIlIIIIllIll < this.xPosition + this.width && lllllllllllllIIIlllllIlIIIlIIllI < this.yPosition + this.height;
            final int lllllllllllllIIIlllllIlIIIlIIIIl = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            if (!this.enabled) {
                lllllllllllllIIIlllllIlIIIlIIlII = ColorUtils.astolfoColors(0, 0);
                lllllllllllllIIIlllllIlIIIlIIIll = new Color(100, 100, 100, 255);
            }
            else if (this.hovered) {
                if (GuiButton.fade < 100) {
                    GuiButton.fade += 20;
                }
            }
            else if (GuiButton.fade > 20) {
                GuiButton.fade -= 20;
            }
            if (lllllllllllllIIIlllllIlIIIlIIIlI) {
                drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(94, 0, 255, 88).getRGB());
                drawRect(this.xPosition + 1, this.yPosition + 1, this.xPosition + this.width - 1, this.yPosition + this.height - 1, new Color(10, 10, 5, 105).getRGB());
                this.font.drawCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 1) / 2, new Color(255, 255, 255).getRGB());
            }
            else {
                final int lllllllllllllIIIlllllIlIIIlIIIII = 20;
                final int lllllllllllllIIIlllllIlIIIIlllll = 2;
                final int lllllllllllllIIIlllllIlIIIIllllI = 2;
                drawRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, new Color(94, 0, 255, 55).getRGB());
                drawRect(this.xPosition + 1, this.yPosition + 1, this.xPosition + this.width - 1, this.yPosition + this.height - 1, new Color(151, 94, 250, 110).getRGB());
                this.font.drawCenteredString(this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 1) / 2, new Color(255, 255, 255).getRGB());
            }
            this.mouseDragged(lllllllllllllIIIlllllIlIIIIlllII, lllllllllllllIIIlllllIlIIIIllIll, lllllllllllllIIIlllllIlIIIlIIllI);
        }
    }
    
    protected void mouseDragged(final Minecraft lllllllllllllIIIlllllIlIIIIlIIII, final int lllllllllllllIIIlllllIlIIIIIllll, final int lllllllllllllIIIlllllIlIIIIIlllI) {
    }
    
    public int getButtonWidth() {
        return this.width;
    }
    
    public boolean isMouseOver() {
        return this.hovered;
    }
    
    public void setWidth(final int lllllllllllllIIIlllllIIlllIIllIl) {
        this.width = lllllllllllllIIIlllllIIlllIIllIl;
    }
    
    protected int getHoverState(final boolean lllllllllllllIIIlllllIlIIIllIlll) {
        int lllllllllllllIIIlllllIlIIIlllIIl = 1;
        if (!this.enabled) {
            lllllllllllllIIIlllllIlIIIlllIIl = 0;
        }
        else if (lllllllllllllIIIlllllIlIIIllIlll) {
            lllllllllllllIIIlllllIlIIIlllIIl = 2;
        }
        return lllllllllllllIIIlllllIlIIIlllIIl;
    }
    
    public GuiButton(final int lllllllllllllIIIlllllIlIIlIlIlll, final int lllllllllllllIIIlllllIlIIlIllIll, final int lllllllllllllIIIlllllIlIIlIlIlIl, final String lllllllllllllIIIlllllIlIIlIlIlII) {
        this(lllllllllllllIIIlllllIlIIlIlIlll, lllllllllllllIIIlllllIlIIlIllIll, lllllllllllllIIIlllllIlIIlIlIlIl, 200, 20, lllllllllllllIIIlllllIlIIlIlIlII);
    }
    
    public void mouseReleased(final int lllllllllllllIIIlllllIlIIIIIllII, final int lllllllllllllIIIlllllIlIIIIIlIll) {
    }
    
    public void playPressSound(final SoundHandler lllllllllllllIIIlllllIIlllllIlll) {
        lllllllllllllIIIlllllIIlllllIlll.playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.UI_BUTTON_CLICK, 1.0f));
    }
}
