package net.minecraft.client.gui.advancements;

import net.minecraft.client.gui.*;
import net.minecraft.item.*;
import net.minecraft.advancements.*;
import net.minecraft.client.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;

public class GuiAdvancementTab extends Gui
{
    private /* synthetic */ boolean field_192992_s;
    private final /* synthetic */ Advancement field_191805_h;
    private final /* synthetic */ ItemStack field_191807_j;
    private final /* synthetic */ AdvancementTabType field_191803_f;
    private /* synthetic */ int field_193940_r;
    private /* synthetic */ float field_191815_r;
    private final /* synthetic */ GuiAdvancement field_191809_l;
    private final /* synthetic */ int field_191804_g;
    private final /* synthetic */ DisplayInfo field_191806_i;
    private final /* synthetic */ GuiScreenAdvancements field_193938_f;
    private final /* synthetic */ String field_191808_k;
    private /* synthetic */ int field_191811_n;
    private /* synthetic */ int field_193939_q;
    private /* synthetic */ int field_191812_o;
    private /* synthetic */ int field_191814_q;
    private /* synthetic */ int field_191813_p;
    private final /* synthetic */ Minecraft field_191802_a;
    private final /* synthetic */ Map<Advancement, GuiAdvancement> field_191810_m;
    
    public Advancement func_193935_c() {
        return this.field_191805_h;
    }
    
    private void func_193937_a(final GuiAdvancement lllllllllllllIIIIllIIIIIIllllIlI, final Advancement lllllllllllllIIIIllIIIIIIllllIIl) {
        this.field_191810_m.put(lllllllllllllIIIIllIIIIIIllllIIl, lllllllllllllIIIIllIIIIIIllllIlI);
        final int lllllllllllllIIIIllIIIIIlIIIIIII = lllllllllllllIIIIllIIIIIIllllIlI.func_191823_d();
        final int lllllllllllllIIIIllIIIIIIlllllll = lllllllllllllIIIIllIIIIIlIIIIIII + 28;
        final int lllllllllllllIIIIllIIIIIIllllllI = lllllllllllllIIIIllIIIIIIllllIlI.func_191820_c();
        final int lllllllllllllIIIIllIIIIIIlllllIl = lllllllllllllIIIIllIIIIIIllllllI + 27;
        this.field_193939_q = Math.min(this.field_193939_q, lllllllllllllIIIIllIIIIIlIIIIIII);
        this.field_191813_p = Math.max(this.field_191813_p, lllllllllllllIIIIllIIIIIIlllllll);
        this.field_193940_r = Math.min(this.field_193940_r, lllllllllllllIIIIllIIIIIIllllllI);
        this.field_191814_q = Math.max(this.field_191814_q, lllllllllllllIIIIllIIIIIIlllllIl);
        for (final GuiAdvancement lllllllllllllIIIIllIIIIIIlllllII : this.field_191810_m.values()) {
            lllllllllllllIIIIllIIIIIIlllllII.func_191825_b();
        }
    }
    
    public void func_191800_a(final Advancement lllllllllllllIIIIllIIIIIlIIIlllI) {
        if (lllllllllllllIIIIllIIIIIlIIIlllI.func_192068_c() != null) {
            final GuiAdvancement lllllllllllllIIIIllIIIIIlIIlIIII = new GuiAdvancement(this, this.field_191802_a, lllllllllllllIIIIllIIIIIlIIIlllI, lllllllllllllIIIIllIIIIIlIIIlllI.func_192068_c());
            this.func_193937_a(lllllllllllllIIIIllIIIIIlIIlIIII, lllllllllllllIIIIllIIIIIlIIIlllI);
        }
    }
    
    public GuiAdvancementTab(final Minecraft lllllllllllllIIIIllIIIIlIIIlIllI, final GuiScreenAdvancements lllllllllllllIIIIllIIIIlIIIlIlIl, final AdvancementTabType lllllllllllllIIIIllIIIIlIIIIllIl, final int lllllllllllllIIIIllIIIIlIIIlIIll, final Advancement lllllllllllllIIIIllIIIIlIIIlIIlI, final DisplayInfo lllllllllllllIIIIllIIIIlIIIlIIIl) {
        this.field_191810_m = (Map<Advancement, GuiAdvancement>)Maps.newLinkedHashMap();
        this.field_193939_q = Integer.MAX_VALUE;
        this.field_193940_r = Integer.MAX_VALUE;
        this.field_191813_p = Integer.MIN_VALUE;
        this.field_191814_q = Integer.MIN_VALUE;
        this.field_191802_a = lllllllllllllIIIIllIIIIlIIIlIllI;
        this.field_193938_f = lllllllllllllIIIIllIIIIlIIIlIlIl;
        this.field_191803_f = lllllllllllllIIIIllIIIIlIIIIllIl;
        this.field_191804_g = lllllllllllllIIIIllIIIIlIIIlIIll;
        this.field_191805_h = lllllllllllllIIIIllIIIIlIIIlIIlI;
        this.field_191806_i = lllllllllllllIIIIllIIIIlIIIlIIIl;
        this.field_191807_j = lllllllllllllIIIIllIIIIlIIIlIIIl.func_192298_b();
        this.field_191808_k = lllllllllllllIIIIllIIIIlIIIlIIIl.func_192297_a().getFormattedText();
        this.field_191809_l = new GuiAdvancement(this, lllllllllllllIIIIllIIIIlIIIlIllI, lllllllllllllIIIIllIIIIlIIIlIIlI, lllllllllllllIIIIllIIIIlIIIlIIIl);
        this.func_193937_a(this.field_191809_l, lllllllllllllIIIIllIIIIlIIIlIIlI);
    }
    
    public void func_191799_a() {
        if (!this.field_192992_s) {
            this.field_191811_n = 117 - (this.field_191813_p + this.field_193939_q) / 2;
            this.field_191812_o = 56 - (this.field_191814_q + this.field_193940_r) / 2;
            this.field_192992_s = true;
        }
        GlStateManager.depthFunc(518);
        Gui.drawRect(0.0, 0.0, 234.0, 113.0, -16777216);
        GlStateManager.depthFunc(515);
        final ResourceLocation lllllllllllllIIIIllIIIIIlllIIlII = this.field_191806_i.func_192293_c();
        if (lllllllllllllIIIIllIIIIIlllIIlII != null) {
            this.field_191802_a.getTextureManager().bindTexture(lllllllllllllIIIIllIIIIIlllIIlII);
        }
        else {
            this.field_191802_a.getTextureManager().bindTexture(TextureManager.field_194008_a);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllllllllllllIIIIllIIIIIlllIIIll = this.field_191811_n % 16;
        final int lllllllllllllIIIIllIIIIIlllIIIlI = this.field_191812_o % 16;
        for (int lllllllllllllIIIIllIIIIIlllIIIIl = -1; lllllllllllllIIIIllIIIIIlllIIIIl <= 15; ++lllllllllllllIIIIllIIIIIlllIIIIl) {
            for (int lllllllllllllIIIIllIIIIIlllIIIII = -1; lllllllllllllIIIIllIIIIIlllIIIII <= 8; ++lllllllllllllIIIIllIIIIIlllIIIII) {
                Gui.drawModalRectWithCustomSizedTexture(lllllllllllllIIIIllIIIIIlllIIIll + 16 * lllllllllllllIIIIllIIIIIlllIIIIl, lllllllllllllIIIIllIIIIIlllIIIlI + 16 * lllllllllllllIIIIllIIIIIlllIIIII, 0.0f, 0.0f, 16, 16, 16.0f, 16.0f);
            }
        }
        this.field_191809_l.func_191819_a(this.field_191811_n, this.field_191812_o, true);
        this.field_191809_l.func_191819_a(this.field_191811_n, this.field_191812_o, false);
        this.field_191809_l.func_191817_b(this.field_191811_n, this.field_191812_o);
    }
    
    public void func_192991_a(final int lllllllllllllIIIIllIIIIIllIIlIIl, final int lllllllllllllIIIIllIIIIIllIIllll, final int lllllllllllllIIIIllIIIIIllIIIlll, final int lllllllllllllIIIIllIIIIIllIIllIl) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0f, 0.0f, 200.0f);
        Gui.drawRect(0.0, 0.0, 234.0, 113.0, MathHelper.floor(this.field_191815_r * 255.0f) << 24);
        boolean lllllllllllllIIIIllIIIIIllIIllII = false;
        if (lllllllllllllIIIIllIIIIIllIIlIIl > 0 && lllllllllllllIIIIllIIIIIllIIlIIl < 234 && lllllllllllllIIIIllIIIIIllIIllll > 0 && lllllllllllllIIIIllIIIIIllIIllll < 113) {
            for (final GuiAdvancement lllllllllllllIIIIllIIIIIllIIlIll : this.field_191810_m.values()) {
                if (lllllllllllllIIIIllIIIIIllIIlIll.func_191816_c(this.field_191811_n, this.field_191812_o, lllllllllllllIIIIllIIIIIllIIlIIl, lllllllllllllIIIIllIIIIIllIIllll)) {
                    lllllllllllllIIIIllIIIIIllIIllII = true;
                    lllllllllllllIIIIllIIIIIllIIlIll.func_191821_a(this.field_191811_n, this.field_191812_o, this.field_191815_r, lllllllllllllIIIIllIIIIIllIIIlll, lllllllllllllIIIIllIIIIIllIIllIl);
                    break;
                }
            }
        }
        GlStateManager.popMatrix();
        if (lllllllllllllIIIIllIIIIIllIIllII) {
            this.field_191815_r = MathHelper.clamp(this.field_191815_r + 0.02f, 0.0f, 0.3f);
        }
        else {
            this.field_191815_r = MathHelper.clamp(this.field_191815_r - 0.04f, 0.0f, 1.0f);
        }
    }
    
    @Nullable
    public GuiAdvancement func_191794_b(final Advancement lllllllllllllIIIIllIIIIIIllIllll) {
        return this.field_191810_m.get(lllllllllllllIIIIllIIIIIIllIllll);
    }
    
    public void func_191797_b(final int lllllllllllllIIIIllIIIIIlIIlIlll, final int lllllllllllllIIIIllIIIIIlIIllIIl) {
        if (this.field_191813_p - this.field_193939_q > 234) {
            this.field_191811_n = MathHelper.clamp(this.field_191811_n + lllllllllllllIIIIllIIIIIlIIlIlll, -(this.field_191813_p - 234), 0);
        }
        if (this.field_191814_q - this.field_193940_r > 113) {
            this.field_191812_o = MathHelper.clamp(this.field_191812_o + lllllllllllllIIIIllIIIIIlIIllIIl, -(this.field_191814_q - 113), 0);
        }
    }
    
    public void func_191796_a(final int lllllllllllllIIIIllIIIIIllllIIlI, final int lllllllllllllIIIIllIIIIIlllIllIl, final RenderItem lllllllllllllIIIIllIIIIIlllIllII) {
        this.field_191803_f.func_192652_a(lllllllllllllIIIIllIIIIIllllIIlI, lllllllllllllIIIIllIIIIIlllIllIl, this.field_191804_g, lllllllllllllIIIIllIIIIIlllIllII, this.field_191807_j);
    }
    
    public boolean func_191793_c(final int lllllllllllllIIIIllIIIIIlIllllII, final int lllllllllllllIIIIllIIIIIlIllIllI, final int lllllllllllllIIIIllIIIIIlIllIlIl, final int lllllllllllllIIIIllIIIIIlIlllIIl) {
        return this.field_191803_f.func_192654_a(lllllllllllllIIIIllIIIIIlIllllII, lllllllllllllIIIIllIIIIIlIllIllI, this.field_191804_g, lllllllllllllIIIIllIIIIIlIllIlIl, lllllllllllllIIIIllIIIIIlIlllIIl);
    }
    
    public String func_191795_d() {
        return this.field_191808_k;
    }
    
    public void func_191798_a(final int lllllllllllllIIIIllIIIIIlllllllI, final int lllllllllllllIIIIllIIIIIllllllIl, final boolean lllllllllllllIIIIllIIIIIllllllII) {
        this.field_191803_f.func_192651_a(this, lllllllllllllIIIIllIIIIIlllllllI, lllllllllllllIIIIllIIIIIllllllIl, lllllllllllllIIIIllIIIIIllllllII, this.field_191804_g);
    }
    
    @Nullable
    public static GuiAdvancementTab func_193936_a(final Minecraft lllllllllllllIIIIllIIIIIlIlIIllI, final GuiScreenAdvancements lllllllllllllIIIIllIIIIIlIlIIlIl, int lllllllllllllIIIIllIIIIIlIlIIlII, final Advancement lllllllllllllIIIIllIIIIIlIlIIIll) {
        if (lllllllllllllIIIIllIIIIIlIlIIIll.func_192068_c() == null) {
            return null;
        }
        final int lllllllllllllIIIIllIIIIIlIIlllll;
        final char lllllllllllllIIIIllIIIIIlIlIIIII = (char)((AdvancementTabType[])(Object)(lllllllllllllIIIIllIIIIIlIIlllll = (int)(Object)AdvancementTabType.values())).length;
        for (String lllllllllllllIIIIllIIIIIlIlIIIIl = (String)0; lllllllllllllIIIIllIIIIIlIlIIIIl < lllllllllllllIIIIllIIIIIlIlIIIII; ++lllllllllllllIIIIllIIIIIlIlIIIIl) {
            final AdvancementTabType lllllllllllllIIIIllIIIIIlIlIIlll = lllllllllllllIIIIllIIIIIlIIlllll[lllllllllllllIIIIllIIIIIlIlIIIIl];
            if (lllllllllllllIIIIllIIIIIlIlIIlII < lllllllllllllIIIIllIIIIIlIlIIlll.func_192650_a()) {
                return new GuiAdvancementTab(lllllllllllllIIIIllIIIIIlIlIIllI, lllllllllllllIIIIllIIIIIlIlIIlIl, lllllllllllllIIIIllIIIIIlIlIIlll, lllllllllllllIIIIllIIIIIlIlIIlII, lllllllllllllIIIIllIIIIIlIlIIIll, lllllllllllllIIIIllIIIIIlIlIIIll.func_192068_c());
            }
            lllllllllllllIIIIllIIIIIlIlIIlII -= lllllllllllllIIIIllIIIIIlIlIIlll.func_192650_a();
        }
        return null;
    }
    
    public GuiScreenAdvancements func_193934_g() {
        return this.field_193938_f;
    }
}
