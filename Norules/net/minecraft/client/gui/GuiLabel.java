package net.minecraft.client.gui;

import java.util.*;
import net.minecraft.client.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;

public class GuiLabel extends Gui
{
    private final /* synthetic */ List<String> labels;
    private final /* synthetic */ int textColor;
    private final /* synthetic */ FontRenderer fontRenderer;
    protected /* synthetic */ int height;
    private /* synthetic */ boolean centered;
    private /* synthetic */ int backColor;
    public /* synthetic */ boolean visible;
    protected /* synthetic */ int width;
    public /* synthetic */ int y;
    private /* synthetic */ int brColor;
    public /* synthetic */ int x;
    public /* synthetic */ int id;
    private /* synthetic */ int border;
    private /* synthetic */ int ulColor;
    private /* synthetic */ boolean labelBgEnabled;
    
    protected void drawLabelBackground(final Minecraft llllllllllllIllllllIIIIlllIIllII, final int llllllllllllIllllllIIIIlllIIlIll, final int llllllllllllIllllllIIIIlllIIlIlI) {
        if (this.labelBgEnabled) {
            final int llllllllllllIllllllIIIIlllIIlIIl = this.width + this.border * 2;
            final int llllllllllllIllllllIIIIlllIIlIII = this.height + this.border * 2;
            final int llllllllllllIllllllIIIIlllIIIlll = this.x - this.border;
            final int llllllllllllIllllllIIIIlllIIIllI = this.y - this.border;
            Gui.drawRect(llllllllllllIllllllIIIIlllIIIlll, llllllllllllIllllllIIIIlllIIIllI, llllllllllllIllllllIIIIlllIIIlll + llllllllllllIllllllIIIIlllIIlIIl, llllllllllllIllllllIIIIlllIIIllI + llllllllllllIllllllIIIIlllIIlIII, this.backColor);
            this.drawHorizontalLine(llllllllllllIllllllIIIIlllIIIlll, llllllllllllIllllllIIIIlllIIIlll + llllllllllllIllllllIIIIlllIIlIIl, llllllllllllIllllllIIIIlllIIIllI, this.ulColor);
            this.drawHorizontalLine(llllllllllllIllllllIIIIlllIIIlll, llllllllllllIllllllIIIIlllIIIlll + llllllllllllIllllllIIIIlllIIlIIl, llllllllllllIllllllIIIIlllIIIllI + llllllllllllIllllllIIIIlllIIlIII, this.brColor);
            this.drawVerticalLine(llllllllllllIllllllIIIIlllIIIlll, llllllllllllIllllllIIIIlllIIIllI, llllllllllllIllllllIIIIlllIIIllI + llllllllllllIllllllIIIIlllIIlIII, this.ulColor);
            this.drawVerticalLine(llllllllllllIllllllIIIIlllIIIlll + llllllllllllIllllllIIIIlllIIlIIl, llllllllllllIllllllIIIIlllIIIllI, llllllllllllIllllllIIIIlllIIIllI + llllllllllllIllllllIIIIlllIIlIII, this.brColor);
        }
    }
    
    public GuiLabel(final FontRenderer llllllllllllIllllllIIIIlllllIlll, final int llllllllllllIllllllIIIIlllllIllI, final int llllllllllllIllllllIIIIlllllIlIl, final int llllllllllllIllllllIIIIlllllllII, final int llllllllllllIllllllIIIIllllllIll, final int llllllllllllIllllllIIIIllllllIlI, final int llllllllllllIllllllIIIIllllllIIl) {
        this.width = 200;
        this.height = 20;
        this.visible = true;
        this.fontRenderer = llllllllllllIllllllIIIIlllllIlll;
        this.id = llllllllllllIllllllIIIIlllllIllI;
        this.x = llllllllllllIllllllIIIIlllllIlIl;
        this.y = llllllllllllIllllllIIIIlllllllII;
        this.width = llllllllllllIllllllIIIIllllllIll;
        this.height = llllllllllllIllllllIIIIllllllIlI;
        this.labels = (List<String>)Lists.newArrayList();
        this.centered = false;
        this.labelBgEnabled = false;
        this.textColor = llllllllllllIllllllIIIIllllllIIl;
        this.backColor = -1;
        this.ulColor = -1;
        this.brColor = -1;
        this.border = 0;
    }
    
    public void drawLabel(final Minecraft llllllllllllIllllllIIIIlllIllIII, final int llllllllllllIllllllIIIIlllIlIlll, final int llllllllllllIllllllIIIIlllIlllIl) {
        if (this.visible) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            this.drawLabelBackground(llllllllllllIllllllIIIIlllIllIII, llllllllllllIllllllIIIIlllIlIlll, llllllllllllIllllllIIIIlllIlllIl);
            final int llllllllllllIllllllIIIIlllIlllII = this.y + this.height / 2 + this.border / 2;
            final int llllllllllllIllllllIIIIlllIllIll = llllllllllllIllllllIIIIlllIlllII - this.labels.size() * 10 / 2;
            for (int llllllllllllIllllllIIIIlllIllIlI = 0; llllllllllllIllllllIIIIlllIllIlI < this.labels.size(); ++llllllllllllIllllllIIIIlllIllIlI) {
                if (this.centered) {
                    this.drawCenteredString(this.fontRenderer, this.labels.get(llllllllllllIllllllIIIIlllIllIlI), this.x + this.width / 2, llllllllllllIllllllIIIIlllIllIll + llllllllllllIllllllIIIIlllIllIlI * 10, this.textColor);
                }
                else {
                    this.drawString(this.fontRenderer, this.labels.get(llllllllllllIllllllIIIIlllIllIlI), this.x, llllllllllllIllllllIIIIlllIllIll + llllllllllllIllllllIIIIlllIllIlI * 10, this.textColor);
                }
            }
        }
    }
    
    public GuiLabel setCentered() {
        this.centered = true;
        return this;
    }
    
    public void addLine(final String llllllllllllIllllllIIIIllllIllIl) {
        this.labels.add(I18n.format(llllllllllllIllllllIIIIllllIllIl, new Object[0]));
    }
}
