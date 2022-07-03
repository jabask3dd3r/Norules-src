package net.minecraft.client.gui.advancements;

import net.minecraft.client.multiplayer.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.network.*;
import net.minecraft.advancements.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.gui.*;
import javax.annotation.*;
import com.google.common.collect.*;
import org.lwjgl.input.*;

public class GuiScreenAdvancements extends GuiScreen implements ClientAdvancementManager.IListener
{
    private /* synthetic */ GuiAdvancementTab field_191940_s;
    private final /* synthetic */ ClientAdvancementManager field_191946_h;
    private static final /* synthetic */ ResourceLocation field_191945_g;
    private static final /* synthetic */ ResourceLocation field_191943_f;
    private /* synthetic */ boolean field_191944_v;
    private /* synthetic */ int field_191941_t;
    private final /* synthetic */ Map<Advancement, GuiAdvancementTab> field_191947_i;
    private /* synthetic */ int field_191942_u;
    
    @Override
    public void func_191928_b(final Advancement llllllllllllllIlIllIlllIllIlllIl) {
    }
    
    @Override
    public void onGuiClosed() {
        this.field_191946_h.func_192798_a(null);
        final NetHandlerPlayClient llllllllllllllIlIllIllllIlIlIIIl = this.mc.getConnection();
        if (llllllllllllllIlIllIllllIlIlIIIl != null) {
            llllllllllllllIlIllIllllIlIlIIIl.sendPacket(CPacketSeenAdvancements.func_194164_a());
        }
    }
    
    @Override
    public void func_191933_a(final Advancement llllllllllllllIlIllIlllIllIIlIII, final AdvancementProgress llllllllllllllIlIllIlllIllIIIlll) {
        final GuiAdvancement llllllllllllllIlIllIlllIllIIlIlI = this.func_191938_e(llllllllllllllIlIllIlllIllIIlIII);
        if (llllllllllllllIlIllIlllIllIIlIlI != null) {
            llllllllllllllIlIllIlllIllIIlIlI.func_191824_a(llllllllllllllIlIllIlllIllIIIlll);
        }
    }
    
    @Override
    public void func_191930_a() {
        this.field_191947_i.clear();
        this.field_191940_s = null;
    }
    
    @Override
    public void initGui() {
        this.field_191947_i.clear();
        this.field_191940_s = null;
        this.field_191946_h.func_192798_a(this);
        if (this.field_191940_s == null && !this.field_191947_i.isEmpty()) {
            this.field_191946_h.func_194230_a(this.field_191947_i.values().iterator().next().func_193935_c(), true);
        }
        else {
            this.field_191946_h.func_194230_a((this.field_191940_s == null) ? null : this.field_191940_s.func_193935_c(), true);
        }
    }
    
    @Override
    protected void mouseClicked(final int llllllllllllllIlIllIllllIIlllllI, final int llllllllllllllIlIllIllllIIllllIl, final int llllllllllllllIlIllIllllIIllllII) throws IOException {
        if (llllllllllllllIlIllIllllIIllllII == 0) {
            final int llllllllllllllIlIllIllllIlIIIIlI = (this.width - 252) / 2;
            final int llllllllllllllIlIllIllllIlIIIIIl = (this.height - 140) / 2;
            for (final GuiAdvancementTab llllllllllllllIlIllIllllIlIIIIII : this.field_191947_i.values()) {
                if (llllllllllllllIlIllIllllIlIIIIII.func_191793_c(llllllllllllllIlIllIllllIlIIIIlI, llllllllllllllIlIllIllllIlIIIIIl, llllllllllllllIlIllIllllIIlllllI, llllllllllllllIlIllIllllIIllllIl)) {
                    this.field_191946_h.func_194230_a(llllllllllllllIlIllIllllIlIIIIII.func_193935_c(), true);
                    break;
                }
            }
        }
        super.mouseClicked(llllllllllllllIlIllIllllIIlllllI, llllllllllllllIlIllIllllIIllllIl, llllllllllllllIlIllIllllIIllllII);
    }
    
    public void func_191934_b(final int llllllllllllllIlIllIllllIIIIIlII, final int llllllllllllllIlIllIlllIlllllllI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        RenderHelper.disableStandardItemLighting();
        this.mc.getTextureManager().bindTexture(GuiScreenAdvancements.field_191943_f);
        this.drawTexturedModalRect(llllllllllllllIlIllIllllIIIIIlII, llllllllllllllIlIllIlllIlllllllI, 0, 0, 252, 140);
        if (this.field_191947_i.size() > 1) {
            this.mc.getTextureManager().bindTexture(GuiScreenAdvancements.field_191945_g);
            for (final GuiAdvancementTab llllllllllllllIlIllIllllIIIIIIlI : this.field_191947_i.values()) {
                llllllllllllllIlIllIllllIIIIIIlI.func_191798_a(llllllllllllllIlIllIllllIIIIIlII, llllllllllllllIlIllIlllIlllllllI, llllllllllllllIlIllIllllIIIIIIlI == this.field_191940_s);
            }
            GlStateManager.enableRescaleNormal();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderHelper.enableGUIStandardItemLighting();
            for (final GuiAdvancementTab llllllllllllllIlIllIllllIIIIIIIl : this.field_191947_i.values()) {
                llllllllllllllIlIllIllllIIIIIIIl.func_191796_a(llllllllllllllIlIllIllllIIIIIlII, llllllllllllllIlIllIlllIlllllllI, this.itemRender);
            }
            GlStateManager.disableBlend();
        }
        this.fontRendererObj.drawString(I18n.format("gui.advancements", new Object[0]), llllllllllllllIlIllIllllIIIIIlII + 8, llllllllllllllIlIllIlllIlllllllI + 6, 4210752);
    }
    
    private void func_191936_c(final int llllllllllllllIlIllIllllIIIlIlll, final int llllllllllllllIlIllIllllIIIlIllI, final int llllllllllllllIlIllIllllIIIlIlIl, final int llllllllllllllIlIllIllllIIIIlllI) {
        final GuiAdvancementTab llllllllllllllIlIllIllllIIIlIIll = this.field_191940_s;
        if (llllllllllllllIlIllIllllIIIlIIll == null) {
            Gui.drawRect(llllllllllllllIlIllIllllIIIlIlIl + 9, llllllllllllllIlIllIllllIIIIlllI + 18, llllllllllllllIlIllIllllIIIlIlIl + 9 + 234, llllllllllllllIlIllIllllIIIIlllI + 18 + 113, -16777216);
            final String llllllllllllllIlIllIllllIIIlIIlI = I18n.format("advancements.empty", new Object[0]);
            final int llllllllllllllIlIllIllllIIIlIIIl = this.fontRendererObj.getStringWidth(llllllllllllllIlIllIllllIIIlIIlI);
            this.fontRendererObj.drawString(llllllllllllllIlIllIllllIIIlIIlI, llllllllllllllIlIllIllllIIIlIlIl + 9 + 117 - llllllllllllllIlIllIllllIIIlIIIl / 2, llllllllllllllIlIllIllllIIIIlllI + 18 + 56 - this.fontRendererObj.FONT_HEIGHT / 2, -1);
            this.fontRendererObj.drawString(":(", llllllllllllllIlIllIllllIIIlIlIl + 9 + 117 - this.fontRendererObj.getStringWidth(":(") / 2, llllllllllllllIlIllIllllIIIIlllI + 18 + 113 - this.fontRendererObj.FONT_HEIGHT, -1);
        }
        else {
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)(llllllllllllllIlIllIllllIIIlIlIl + 9), (float)(llllllllllllllIlIllIllllIIIIlllI + 18), -400.0f);
            GlStateManager.enableDepth();
            llllllllllllllIlIllIllllIIIlIIll.func_191799_a();
            GlStateManager.popMatrix();
            GlStateManager.depthFunc(515);
            GlStateManager.disableDepth();
        }
    }
    
    @Override
    protected void keyTyped(final char llllllllllllllIlIllIllllIIllIIII, final int llllllllllllllIlIllIllllIIllIIlI) throws IOException {
        if (llllllllllllllIlIllIllllIIllIIlI == this.mc.gameSettings.field_194146_ao.getKeyCode()) {
            this.mc.displayGuiScreen(null);
            this.mc.setIngameFocus();
        }
        else {
            super.keyTyped(llllllllllllllIlIllIllllIIllIIII, llllllllllllllIlIllIllllIIllIIlI);
        }
    }
    
    @Nullable
    private GuiAdvancementTab func_191935_f(Advancement llllllllllllllIlIllIlllIlIlIlllI) {
        while (llllllllllllllIlIllIlllIlIlIlllI.func_192070_b() != null) {
            llllllllllllllIlIllIlllIlIlIlllI = llllllllllllllIlIllIlllIlIlIlllI.func_192070_b();
        }
        return this.field_191947_i.get(llllllllllllllIlIllIlllIlIlIlllI);
    }
    
    private void func_191937_d(final int llllllllllllllIlIllIlllIlllIllIl, final int llllllllllllllIlIllIlllIlllIllII, final int llllllllllllllIlIllIlllIlllIlIll, final int llllllllllllllIlIllIlllIlllIlIlI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        if (this.field_191940_s != null) {
            GlStateManager.pushMatrix();
            GlStateManager.enableDepth();
            GlStateManager.translate((float)(llllllllllllllIlIllIlllIlllIlIll + 9), (float)(llllllllllllllIlIllIlllIlllIlIlI + 18), 400.0f);
            this.field_191940_s.func_192991_a(llllllllllllllIlIllIlllIlllIllIl - llllllllllllllIlIllIlllIlllIlIll - 9, llllllllllllllIlIllIlllIlllIllII - llllllllllllllIlIllIlllIlllIlIlI - 18, llllllllllllllIlIllIlllIlllIlIll, llllllllllllllIlIllIlllIlllIlIlI);
            GlStateManager.disableDepth();
            GlStateManager.popMatrix();
        }
        if (this.field_191947_i.size() > 1) {
            for (final GuiAdvancementTab llllllllllllllIlIllIlllIlllIllll : this.field_191947_i.values()) {
                if (llllllllllllllIlIllIlllIlllIllll.func_191793_c(llllllllllllllIlIllIlllIlllIlIll, llllllllllllllIlIllIlllIlllIlIlI, llllllllllllllIlIllIlllIlllIllIl, llllllllllllllIlIllIlllIlllIllII)) {
                    this.drawCreativeTabHoveringText(llllllllllllllIlIllIlllIlllIllll.func_191795_d(), llllllllllllllIlIllIlllIlllIllIl, llllllllllllllIlIllIlllIlllIllII);
                }
            }
        }
    }
    
    static {
        field_191943_f = new ResourceLocation("textures/gui/advancements/window.png");
        field_191945_g = new ResourceLocation("textures/gui/advancements/tabs.png");
    }
    
    @Override
    public void func_191929_d(final Advancement llllllllllllllIlIllIlllIllIlIIlI) {
    }
    
    @Nullable
    public GuiAdvancement func_191938_e(final Advancement llllllllllllllIlIllIlllIlIlllIII) {
        final GuiAdvancementTab llllllllllllllIlIllIlllIlIllIlll = this.func_191935_f(llllllllllllllIlIllIlllIlIlllIII);
        return (llllllllllllllIlIllIlllIlIllIlll == null) ? null : llllllllllllllIlIllIlllIlIllIlll.func_191794_b(llllllllllllllIlIllIlllIlIlllIII);
    }
    
    @Override
    public void func_193982_e(@Nullable final Advancement llllllllllllllIlIllIlllIllIIIIlI) {
        this.field_191940_s = this.field_191947_i.get(llllllllllllllIlIllIlllIllIIIIlI);
    }
    
    @Override
    public void func_191931_a(final Advancement llllllllllllllIlIllIlllIlllIIIll) {
        final GuiAdvancementTab llllllllllllllIlIllIlllIlllIIIlI = GuiAdvancementTab.func_193936_a(this.mc, this, this.field_191947_i.size(), llllllllllllllIlIllIlllIlllIIIll);
        if (llllllllllllllIlIllIlllIlllIIIlI != null) {
            this.field_191947_i.put(llllllllllllllIlIllIlllIlllIIIll, llllllllllllllIlIllIlllIlllIIIlI);
        }
    }
    
    @Override
    public void func_191932_c(final Advancement llllllllllllllIlIllIlllIllIllIII) {
        final GuiAdvancementTab llllllllllllllIlIllIlllIllIlIlll = this.func_191935_f(llllllllllllllIlIllIlllIllIllIII);
        if (llllllllllllllIlIllIlllIllIlIlll != null) {
            llllllllllllllIlIllIlllIllIlIlll.func_191800_a(llllllllllllllIlIllIlllIllIllIII);
        }
    }
    
    public GuiScreenAdvancements(final ClientAdvancementManager llllllllllllllIlIllIllllIlIllIII) {
        this.field_191947_i = (Map<Advancement, GuiAdvancementTab>)Maps.newLinkedHashMap();
        this.field_191946_h = llllllllllllllIlIllIllllIlIllIII;
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIllIllllIIlIlIII, final int llllllllllllllIlIllIllllIIlIIIIl, final float llllllllllllllIlIllIllllIIlIIllI) {
        final int llllllllllllllIlIllIllllIIlIIlIl = (this.width - 252) / 2;
        final int llllllllllllllIlIllIllllIIlIIlII = (this.height - 140) / 2;
        if (Mouse.isButtonDown(0)) {
            if (!this.field_191944_v) {
                this.field_191944_v = true;
            }
            else if (this.field_191940_s != null) {
                this.field_191940_s.func_191797_b(llllllllllllllIlIllIllllIIlIlIII - this.field_191941_t, llllllllllllllIlIllIllllIIlIIIIl - this.field_191942_u);
            }
            this.field_191941_t = llllllllllllllIlIllIllllIIlIlIII;
            this.field_191942_u = llllllllllllllIlIllIllllIIlIIIIl;
        }
        else {
            this.field_191944_v = false;
        }
        this.drawDefaultBackground();
        this.func_191936_c(llllllllllllllIlIllIllllIIlIlIII, llllllllllllllIlIllIllllIIlIIIIl, llllllllllllllIlIllIllllIIlIIlIl, llllllllllllllIlIllIllllIIlIIlII);
        this.func_191934_b(llllllllllllllIlIllIllllIIlIIlIl, llllllllllllllIlIllIllllIIlIIlII);
        this.func_191937_d(llllllllllllllIlIllIllllIIlIlIII, llllllllllllllIlIllIllllIIlIIIIl, llllllllllllllIlIllIllllIIlIIlIl, llllllllllllllIlIllIllllIIlIIlII);
    }
}
