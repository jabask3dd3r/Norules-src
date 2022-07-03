package net.minecraft.client.gui.advancements;

import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.advancements.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import java.util.*;
import java.util.regex.*;
import com.google.common.collect.*;

public class GuiAdvancement extends Gui
{
    private /* synthetic */ GuiAdvancement field_191834_l;
    private final /* synthetic */ GuiAdvancementTab field_191828_f;
    private final /* synthetic */ int field_191826_p;
    private final /* synthetic */ DisplayInfo field_191830_h;
    private static final /* synthetic */ ResourceLocation field_191827_a;
    private final /* synthetic */ Advancement field_191829_g;
    private final /* synthetic */ int field_191832_j;
    private final /* synthetic */ Minecraft field_191833_k;
    private final /* synthetic */ int field_191837_o;
    private /* synthetic */ AdvancementProgress field_191836_n;
    private final /* synthetic */ List<GuiAdvancement> field_191835_m;
    private final /* synthetic */ List<String> field_192997_l;
    private static final /* synthetic */ Pattern field_192996_f;
    private final /* synthetic */ String field_191831_i;
    
    public void func_191822_a(final GuiAdvancement llllllllllllllIIIlIllIllIlIlIIll) {
        this.field_191835_m.add(llllllllllllllIIIlIllIllIlIlIIll);
    }
    
    public int func_191820_c() {
        return this.field_191826_p;
    }
    
    protected void func_192993_a(final int llllllllllllllIIIlIllIlIllIlIIlI, final int llllllllllllllIIIlIllIlIllIlIIIl, final int llllllllllllllIIIlIllIlIllIlllll, final int llllllllllllllIIIlIllIlIllIllllI, final int llllllllllllllIIIlIllIlIllIlllIl, final int llllllllllllllIIIlIllIlIllIIllIl, final int llllllllllllllIIIlIllIlIllIIllII, final int llllllllllllllIIIlIllIlIllIIlIll) {
        for (int llllllllllllllIIIlIllIlIllIllIIl = 0; llllllllllllllIIIlIllIlIllIllIIl < llllllllllllllIIIlIllIlIllIlllll; llllllllllllllIIIlIllIlIllIllIIl += llllllllllllllIIIlIllIlIllIIllII) {
            final int llllllllllllllIIIlIllIlIllIllIII = llllllllllllllIIIlIllIlIllIlIIlI + llllllllllllllIIIlIllIlIllIllIIl;
            final int llllllllllllllIIIlIllIlIllIlIlll = Math.min(llllllllllllllIIIlIllIlIllIIllII, llllllllllllllIIIlIllIlIllIlllll - llllllllllllllIIIlIllIlIllIllIIl);
            for (int llllllllllllllIIIlIllIlIllIlIllI = 0; llllllllllllllIIIlIllIlIllIlIllI < llllllllllllllIIIlIllIlIllIllllI; llllllllllllllIIIlIllIlIllIlIllI += llllllllllllllIIIlIllIlIllIIlIll) {
                final int llllllllllllllIIIlIllIlIllIlIlIl = llllllllllllllIIIlIllIlIllIlIIIl + llllllllllllllIIIlIllIlIllIlIllI;
                final int llllllllllllllIIIlIllIlIllIlIlII = Math.min(llllllllllllllIIIlIllIlIllIIlIll, llllllllllllllIIIlIllIlIllIllllI - llllllllllllllIIIlIllIlIllIlIllI);
                this.drawTexturedModalRect(llllllllllllllIIIlIllIlIllIllIII, llllllllllllllIIIlIllIlIllIlIlIl, llllllllllllllIIIlIllIlIllIlllIl, llllllllllllllIIIlIllIlIllIIllIl, llllllllllllllIIIlIllIlIllIlIlll, llllllllllllllIIIlIllIlIllIlIlII);
            }
        }
    }
    
    public void func_191824_a(final AdvancementProgress llllllllllllllIIIlIllIllIlIllIIl) {
        this.field_191836_n = llllllllllllllIIIlIllIllIlIllIIl;
    }
    
    @Nullable
    private GuiAdvancement func_191818_a(Advancement llllllllllllllIIIlIllIlllIIIllll) {
        do {
            llllllllllllllIIIlIllIlllIIIllll = ((Advancement)llllllllllllllIIIlIllIlllIIIllll).func_192070_b();
        } while (llllllllllllllIIIlIllIlllIIIllll != null && ((Advancement)llllllllllllllIIIlIllIlllIIIllll).func_192068_c() == null);
        if (llllllllllllllIIIlIllIlllIIIllll != null && ((Advancement)llllllllllllllIIIlIllIlllIIIllll).func_192068_c() != null) {
            return this.field_191828_f.func_191794_b((Advancement)llllllllllllllIIIlIllIlllIIIllll);
        }
        return null;
    }
    
    public void func_191819_a(final int llllllllllllllIIIlIllIlllIIIIIll, final int llllllllllllllIIIlIllIllIlllIlll, final boolean llllllllllllllIIIlIllIlllIIIIIIl) {
        if (this.field_191834_l != null) {
            final int llllllllllllllIIIlIllIlllIIIIIII = llllllllllllllIIIlIllIlllIIIIIll + this.field_191834_l.field_191837_o + 13;
            final int llllllllllllllIIIlIllIllIlllllll = llllllllllllllIIIlIllIlllIIIIIll + this.field_191834_l.field_191837_o + 26 + 4;
            final int llllllllllllllIIIlIllIllIllllllI = llllllllllllllIIIlIllIllIlllIlll + this.field_191834_l.field_191826_p + 13;
            final int llllllllllllllIIIlIllIllIlllllIl = llllllllllllllIIIlIllIlllIIIIIll + this.field_191837_o + 13;
            final int llllllllllllllIIIlIllIllIlllllII = llllllllllllllIIIlIllIllIlllIlll + this.field_191826_p + 13;
            final int llllllllllllllIIIlIllIllIllllIll = llllllllllllllIIIlIllIlllIIIIIIl ? -16777216 : -1;
            if (llllllllllllllIIIlIllIlllIIIIIIl) {
                this.drawHorizontalLine(llllllllllllllIIIlIllIllIlllllll, llllllllllllllIIIlIllIlllIIIIIII, llllllllllllllIIIlIllIllIllllllI - 1, llllllllllllllIIIlIllIllIllllIll);
                this.drawHorizontalLine(llllllllllllllIIIlIllIllIlllllll + 1, llllllllllllllIIIlIllIlllIIIIIII, llllllllllllllIIIlIllIllIllllllI, llllllllllllllIIIlIllIllIllllIll);
                this.drawHorizontalLine(llllllllllllllIIIlIllIllIlllllll, llllllllllllllIIIlIllIlllIIIIIII, llllllllllllllIIIlIllIllIllllllI + 1, llllllllllllllIIIlIllIllIllllIll);
                this.drawHorizontalLine(llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIlllllll - 1, llllllllllllllIIIlIllIllIlllllII - 1, llllllllllllllIIIlIllIllIllllIll);
                this.drawHorizontalLine(llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIlllllll - 1, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIllllIll);
                this.drawHorizontalLine(llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIlllllll - 1, llllllllllllllIIIlIllIllIlllllII + 1, llllllllllllllIIIlIllIllIllllIll);
                this.drawVerticalLine(llllllllllllllIIIlIllIllIlllllll - 1, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIllllllI, llllllllllllllIIIlIllIllIllllIll);
                this.drawVerticalLine(llllllllllllllIIIlIllIllIlllllll + 1, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIllllllI, llllllllllllllIIIlIllIllIllllIll);
            }
            else {
                this.drawHorizontalLine(llllllllllllllIIIlIllIllIlllllll, llllllllllllllIIIlIllIlllIIIIIII, llllllllllllllIIIlIllIllIllllllI, llllllllllllllIIIlIllIllIllllIll);
                this.drawHorizontalLine(llllllllllllllIIIlIllIllIlllllIl, llllllllllllllIIIlIllIllIlllllll, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIllllIll);
                this.drawVerticalLine(llllllllllllllIIIlIllIllIlllllll, llllllllllllllIIIlIllIllIlllllII, llllllllllllllIIIlIllIllIllllllI, llllllllllllllIIIlIllIllIllllIll);
            }
        }
        for (final GuiAdvancement llllllllllllllIIIlIllIllIllllIlI : this.field_191835_m) {
            llllllllllllllIIIlIllIllIllllIlI.func_191819_a(llllllllllllllIIIlIllIlllIIIIIll, llllllllllllllIIIlIllIllIlllIlll, llllllllllllllIIIlIllIlllIIIIIIl);
        }
    }
    
    protected void func_192994_a(final int llllllllllllllIIIlIllIlIlllllIlI, final int llllllllllllllIIIlIllIllIIIIIIll, final int llllllllllllllIIIlIllIlIlllllIII, final int llllllllllllllIIIlIllIlIllllIlll, final int llllllllllllllIIIlIllIlIllllIllI, final int llllllllllllllIIIlIllIlIllllIlIl, final int llllllllllllllIIIlIllIlIllllIlII, final int llllllllllllllIIIlIllIlIllllIIll, final int llllllllllllllIIIlIllIlIllllIIlI) {
        this.drawTexturedModalRect(llllllllllllllIIIlIllIlIlllllIlI, llllllllllllllIIIlIllIllIIIIIIll, llllllllllllllIIIlIllIlIllllIIll, llllllllllllllIIIlIllIlIllllIIlI, llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI);
        this.func_192993_a(llllllllllllllIIIlIllIlIlllllIlI + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIllIIIIIIll, llllllllllllllIIIlIllIlIlllllIII - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIll + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIlI, llllllllllllllIIIlIllIlIllllIlIl - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlII);
        this.drawTexturedModalRect(llllllllllllllIIIlIllIlIlllllIlI + llllllllllllllIIIlIllIlIlllllIII - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIllIIIIIIll, llllllllllllllIIIlIllIlIllllIIll + llllllllllllllIIIlIllIlIllllIlIl - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIlI, llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI);
        this.drawTexturedModalRect(llllllllllllllIIIlIllIlIlllllIlI, llllllllllllllIIIlIllIllIIIIIIll + llllllllllllllIIIlIllIlIllllIlll - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIll, llllllllllllllIIIlIllIlIllllIIlI + llllllllllllllIIIlIllIlIllllIlII - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI);
        this.func_192993_a(llllllllllllllIIIlIllIlIlllllIlI + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIllIIIIIIll + llllllllllllllIIIlIllIlIllllIlll - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIlllllIII - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIll + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIlI + llllllllllllllIIIlIllIlIllllIlII - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlIl - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlII);
        this.drawTexturedModalRect(llllllllllllllIIIlIllIlIlllllIlI + llllllllllllllIIIlIllIlIlllllIII - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIllIIIIIIll + llllllllllllllIIIlIllIlIllllIlll - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIll + llllllllllllllIIIlIllIlIllllIlIl - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIlI + llllllllllllllIIIlIllIlIllllIlII - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI);
        this.func_192993_a(llllllllllllllIIIlIllIlIlllllIlI, llllllllllllllIIIlIllIllIIIIIIll + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlll - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIll, llllllllllllllIIIlIllIlIllllIIlI + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlIl, llllllllllllllIIIlIllIlIllllIlII - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI);
        this.func_192993_a(llllllllllllllIIIlIllIlIlllllIlI + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIllIIIIIIll + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIlllllIII - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlll - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIll + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIlI + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlIl - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlII - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI);
        this.func_192993_a(llllllllllllllIIIlIllIlIlllllIlI + llllllllllllllIIIlIllIlIlllllIII - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIllIIIIIIll + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlll - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIll + llllllllllllllIIIlIllIlIllllIlIl - llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIIlI + llllllllllllllIIIlIllIlIllllIllI, llllllllllllllIIIlIllIlIllllIlIl, llllllllllllllIIIlIllIlIllllIlII - llllllllllllllIIIlIllIlIllllIllI - llllllllllllllIIIlIllIlIllllIllI);
    }
    
    public int func_191823_d() {
        return this.field_191837_o;
    }
    
    public void func_191817_b(final int llllllllllllllIIIlIllIllIllIlIIl, final int llllllllllllllIIIlIllIllIllIIIIl) {
        if (!this.field_191830_h.func_193224_j() || (this.field_191836_n != null && this.field_191836_n.func_192105_a())) {
            final float llllllllllllllIIIlIllIllIllIIlll = (this.field_191836_n == null) ? 0.0f : this.field_191836_n.func_192103_c();
            AdvancementState llllllllllllllIIIlIllIllIllIIlIl = null;
            if (llllllllllllllIIIlIllIllIllIIlll >= 1.0f) {
                final AdvancementState llllllllllllllIIIlIllIllIllIIllI = AdvancementState.OBTAINED;
            }
            else {
                llllllllllllllIIIlIllIllIllIIlIl = AdvancementState.UNOBTAINED;
            }
            this.field_191833_k.getTextureManager().bindTexture(GuiAdvancement.field_191827_a);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.enableBlend();
            this.drawTexturedModalRect(llllllllllllllIIIlIllIllIllIlIIl + this.field_191837_o + 3, llllllllllllllIIIlIllIllIllIIIIl + this.field_191826_p, this.field_191830_h.func_192291_d().func_192309_b(), 128 + llllllllllllllIIIlIllIllIllIIlIl.func_192667_a() * 26, 26, 26);
            RenderHelper.enableGUIStandardItemLighting();
            this.field_191833_k.getRenderItem().renderItemAndEffectIntoGUI(null, this.field_191830_h.func_192298_b(), llllllllllllllIIIlIllIllIllIlIIl + this.field_191837_o + 8, llllllllllllllIIIlIllIllIllIIIIl + this.field_191826_p + 5);
        }
        for (final GuiAdvancement llllllllllllllIIIlIllIllIllIIlII : this.field_191835_m) {
            llllllllllllllIIIlIllIllIllIIlII.func_191817_b(llllllllllllllIIIlIllIllIllIlIIl, llllllllllllllIIIlIllIllIllIIIIl);
        }
    }
    
    public void func_191821_a(final int llllllllllllllIIIlIllIllIIllllll, final int llllllllllllllIIIlIllIllIIIlllll, final float llllllllllllllIIIlIllIllIIllllIl, final int llllllllllllllIIIlIllIllIIllllII, final int llllllllllllllIIIlIllIllIIlllIll) {
        final boolean llllllllllllllIIIlIllIllIIlllIlI = llllllllllllllIIIlIllIllIIllllII + llllllllllllllIIIlIllIllIIllllll + this.field_191837_o + this.field_191832_j + 26 >= this.field_191828_f.func_193934_g().width;
        final String llllllllllllllIIIlIllIllIIlllIIl = (this.field_191836_n == null) ? null : this.field_191836_n.func_193126_d();
        final int llllllllllllllIIIlIllIllIIlllIII = (llllllllllllllIIIlIllIllIIlllIIl == null) ? 0 : this.field_191833_k.fontRendererObj.getStringWidth(llllllllllllllIIIlIllIllIIlllIIl);
        final boolean llllllllllllllIIIlIllIllIIllIlll = 113 - llllllllllllllIIIlIllIllIIIlllll - this.field_191826_p - 26 <= 6 + this.field_192997_l.size() * this.field_191833_k.fontRendererObj.FONT_HEIGHT;
        final float llllllllllllllIIIlIllIllIIllIllI = (this.field_191836_n == null) ? 0.0f : this.field_191836_n.func_192103_c();
        int llllllllllllllIIIlIllIllIIllIlIl = MathHelper.floor(llllllllllllllIIIlIllIllIIllIllI * this.field_191832_j);
        AdvancementState llllllllllllllIIIlIllIllIIllIIIl = null;
        AdvancementState llllllllllllllIIIlIllIllIIlIllIl = null;
        AdvancementState llllllllllllllIIIlIllIllIIlIlIIl = null;
        if (llllllllllllllIIIlIllIllIIllIllI >= 1.0f) {
            llllllllllllllIIIlIllIllIIllIlIl = this.field_191832_j / 2;
            final AdvancementState llllllllllllllIIIlIllIllIIllIlII = AdvancementState.OBTAINED;
            final AdvancementState llllllllllllllIIIlIllIllIIllIIII = AdvancementState.OBTAINED;
            final AdvancementState llllllllllllllIIIlIllIllIIlIllII = AdvancementState.OBTAINED;
        }
        else if (llllllllllllllIIIlIllIllIIllIlIl < 2) {
            llllllllllllllIIIlIllIllIIllIlIl = this.field_191832_j / 2;
            final AdvancementState llllllllllllllIIIlIllIllIIllIIll = AdvancementState.UNOBTAINED;
            final AdvancementState llllllllllllllIIIlIllIllIIlIllll = AdvancementState.UNOBTAINED;
            final AdvancementState llllllllllllllIIIlIllIllIIlIlIll = AdvancementState.UNOBTAINED;
        }
        else if (llllllllllllllIIIlIllIllIIllIlIl > this.field_191832_j - 2) {
            llllllllllllllIIIlIllIllIIllIlIl = this.field_191832_j / 2;
            final AdvancementState llllllllllllllIIIlIllIllIIllIIlI = AdvancementState.OBTAINED;
            final AdvancementState llllllllllllllIIIlIllIllIIlIlllI = AdvancementState.OBTAINED;
            final AdvancementState llllllllllllllIIIlIllIllIIlIlIlI = AdvancementState.UNOBTAINED;
        }
        else {
            llllllllllllllIIIlIllIllIIllIIIl = AdvancementState.OBTAINED;
            llllllllllllllIIIlIllIllIIlIllIl = AdvancementState.UNOBTAINED;
            llllllllllllllIIIlIllIllIIlIlIIl = AdvancementState.UNOBTAINED;
        }
        final int llllllllllllllIIIlIllIllIIlIlIII = this.field_191832_j - llllllllllllllIIIlIllIllIIllIlIl;
        this.field_191833_k.getTextureManager().bindTexture(GuiAdvancement.field_191827_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableBlend();
        final int llllllllllllllIIIlIllIllIIlIIlll = llllllllllllllIIIlIllIllIIIlllll + this.field_191826_p;
        int llllllllllllllIIIlIllIllIIlIIlIl = 0;
        if (llllllllllllllIIIlIllIllIIlllIlI) {
            final int llllllllllllllIIIlIllIllIIlIIllI = llllllllllllllIIIlIllIllIIllllll + this.field_191837_o - this.field_191832_j + 26 + 6;
        }
        else {
            llllllllllllllIIIlIllIllIIlIIlIl = llllllllllllllIIIlIllIllIIllllll + this.field_191837_o;
        }
        final int llllllllllllllIIIlIllIllIIlIIlII = 32 + this.field_192997_l.size() * this.field_191833_k.fontRendererObj.FONT_HEIGHT;
        if (!this.field_192997_l.isEmpty()) {
            if (llllllllllllllIIIlIllIllIIllIlll) {
                this.func_192994_a(llllllllllllllIIIlIllIllIIlIIlIl, llllllllllllllIIIlIllIllIIlIIlll + 26 - llllllllllllllIIIlIllIllIIlIIlII, this.field_191832_j, llllllllllllllIIIlIllIllIIlIIlII, 10, 200, 26, 0, 52);
            }
            else {
                this.func_192994_a(llllllllllllllIIIlIllIllIIlIIlIl, llllllllllllllIIIlIllIllIIlIIlll, this.field_191832_j, llllllllllllllIIIlIllIllIIlIIlII, 10, 200, 26, 0, 52);
            }
        }
        this.drawTexturedModalRect(llllllllllllllIIIlIllIllIIlIIlIl, llllllllllllllIIIlIllIllIIlIIlll, 0, llllllllllllllIIIlIllIllIIllIIIl.func_192667_a() * 26, llllllllllllllIIIlIllIllIIllIlIl, 26);
        this.drawTexturedModalRect(llllllllllllllIIIlIllIllIIlIIlIl + llllllllllllllIIIlIllIllIIllIlIl, llllllllllllllIIIlIllIllIIlIIlll, 200 - llllllllllllllIIIlIllIllIIlIlIII, llllllllllllllIIIlIllIllIIlIllIl.func_192667_a() * 26, llllllllllllllIIIlIllIllIIlIlIII, 26);
        this.drawTexturedModalRect(llllllllllllllIIIlIllIllIIllllll + this.field_191837_o + 3, llllllllllllllIIIlIllIllIIIlllll + this.field_191826_p, this.field_191830_h.func_192291_d().func_192309_b(), 128 + llllllllllllllIIIlIllIllIIlIlIIl.func_192667_a() * 26, 26, 26);
        if (llllllllllllllIIIlIllIllIIlllIlI) {
            this.field_191833_k.fontRendererObj.drawString(this.field_191831_i, (float)(llllllllllllllIIIlIllIllIIlIIlIl + 5), (float)(llllllllllllllIIIlIllIllIIIlllll + this.field_191826_p + 9), -1, true);
            if (llllllllllllllIIIlIllIllIIlllIIl != null) {
                this.field_191833_k.fontRendererObj.drawString(llllllllllllllIIIlIllIllIIlllIIl, (float)(llllllllllllllIIIlIllIllIIllllll + this.field_191837_o - llllllllllllllIIIlIllIllIIlllIII), (float)(llllllllllllllIIIlIllIllIIIlllll + this.field_191826_p + 9), -1, true);
            }
        }
        else {
            this.field_191833_k.fontRendererObj.drawString(this.field_191831_i, (float)(llllllllllllllIIIlIllIllIIllllll + this.field_191837_o + 32), (float)(llllllllllllllIIIlIllIllIIIlllll + this.field_191826_p + 9), -1, true);
            if (llllllllllllllIIIlIllIllIIlllIIl != null) {
                this.field_191833_k.fontRendererObj.drawString(llllllllllllllIIIlIllIllIIlllIIl, (float)(llllllllllllllIIIlIllIllIIllllll + this.field_191837_o + this.field_191832_j - llllllllllllllIIIlIllIllIIlllIII - 5), (float)(llllllllllllllIIIlIllIllIIIlllll + this.field_191826_p + 9), -1, true);
            }
        }
        if (llllllllllllllIIIlIllIllIIllIlll) {
            for (int llllllllllllllIIIlIllIllIIlIIIll = 0; llllllllllllllIIIlIllIllIIlIIIll < this.field_192997_l.size(); ++llllllllllllllIIIlIllIllIIlIIIll) {
                this.field_191833_k.fontRendererObj.drawString(this.field_192997_l.get(llllllllllllllIIIlIllIllIIlIIIll), (float)(llllllllllllllIIIlIllIllIIlIIlIl + 5), (float)(llllllllllllllIIIlIllIllIIlIIlll + 26 - llllllllllllllIIIlIllIllIIlIIlII + 7 + llllllllllllllIIIlIllIllIIlIIIll * this.field_191833_k.fontRendererObj.FONT_HEIGHT), -5592406, false);
            }
        }
        else {
            for (int llllllllllllllIIIlIllIllIIlIIIlI = 0; llllllllllllllIIIlIllIllIIlIIIlI < this.field_192997_l.size(); ++llllllllllllllIIIlIllIllIIlIIIlI) {
                this.field_191833_k.fontRendererObj.drawString(this.field_192997_l.get(llllllllllllllIIIlIllIllIIlIIIlI), (float)(llllllllllllllIIIlIllIllIIlIIlIl + 5), (float)(llllllllllllllIIIlIllIllIIIlllll + this.field_191826_p + 9 + 17 + llllllllllllllIIIlIllIllIIlIIIlI * this.field_191833_k.fontRendererObj.FONT_HEIGHT), -5592406, false);
            }
        }
        RenderHelper.enableGUIStandardItemLighting();
        this.field_191833_k.getRenderItem().renderItemAndEffectIntoGUI(null, this.field_191830_h.func_192298_b(), llllllllllllllIIIlIllIllIIllllll + this.field_191837_o + 8, llllllllllllllIIIlIllIllIIIlllll + this.field_191826_p + 5);
    }
    
    static {
        field_191827_a = new ResourceLocation("textures/gui/advancements/widgets.png");
        field_192996_f = Pattern.compile("(.+) \\S+");
    }
    
    private List<String> func_192995_a(final String llllllllllllllIIIlIllIlllIlIIlIl, final int llllllllllllllIIIlIllIlllIIllIll) {
        if (llllllllllllllIIIlIllIlllIlIIlIl.isEmpty()) {
            return Collections.emptyList();
        }
        final List<String> llllllllllllllIIIlIllIlllIlIIIll = this.field_191833_k.fontRendererObj.listFormattedStringToWidth(llllllllllllllIIIlIllIlllIlIIlIl, llllllllllllllIIIlIllIlllIIllIll);
        if (llllllllllllllIIIlIllIlllIlIIIll.size() < 2) {
            return llllllllllllllIIIlIllIlllIlIIIll;
        }
        final String llllllllllllllIIIlIllIlllIlIIIlI = llllllllllllllIIIlIllIlllIlIIIll.get(0);
        final String llllllllllllllIIIlIllIlllIlIIIIl = llllllllllllllIIIlIllIlllIlIIIll.get(1);
        final int llllllllllllllIIIlIllIlllIlIIIII = this.field_191833_k.fontRendererObj.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIIIlIllIlllIlIIIlI)).append(' ').append(llllllllllllllIIIlIllIlllIlIIIIl.split(" ")[0])));
        if (llllllllllllllIIIlIllIlllIlIIIII - llllllllllllllIIIlIllIlllIIllIll <= 10) {
            return this.field_191833_k.fontRendererObj.listFormattedStringToWidth(llllllllllllllIIIlIllIlllIlIIlIl, llllllllllllllIIIlIllIlllIlIIIII);
        }
        final Matcher llllllllllllllIIIlIllIlllIIlllll = GuiAdvancement.field_192996_f.matcher(llllllllllllllIIIlIllIlllIlIIIlI);
        if (llllllllllllllIIIlIllIlllIIlllll.matches()) {
            final int llllllllllllllIIIlIllIlllIIllllI = this.field_191833_k.fontRendererObj.getStringWidth(llllllllllllllIIIlIllIlllIIlllll.group(1));
            if (llllllllllllllIIIlIllIlllIIllIll - llllllllllllllIIIlIllIlllIIllllI <= 10) {
                return this.field_191833_k.fontRendererObj.listFormattedStringToWidth(llllllllllllllIIIlIllIlllIlIIlIl, llllllllllllllIIIlIllIlllIIllllI);
            }
        }
        return llllllllllllllIIIlIllIlllIlIIIll;
    }
    
    public void func_191825_b() {
        if (this.field_191834_l == null && this.field_191829_g.func_192070_b() != null) {
            this.field_191834_l = this.func_191818_a(this.field_191829_g);
            if (this.field_191834_l != null) {
                this.field_191834_l.func_191822_a(this);
            }
        }
    }
    
    public GuiAdvancement(final GuiAdvancementTab llllllllllllllIIIlIllIllllIIIlIl, final Minecraft llllllllllllllIIIlIllIlllIlllIIl, final Advancement llllllllllllllIIIlIllIlllIlllIII, final DisplayInfo llllllllllllllIIIlIllIlllIllIlll) {
        this.field_191835_m = (List<GuiAdvancement>)Lists.newArrayList();
        this.field_191828_f = llllllllllllllIIIlIllIllllIIIlIl;
        this.field_191829_g = llllllllllllllIIIlIllIlllIlllIII;
        this.field_191830_h = llllllllllllllIIIlIllIlllIllIlll;
        this.field_191833_k = llllllllllllllIIIlIllIlllIlllIIl;
        this.field_191831_i = llllllllllllllIIIlIllIlllIlllIIl.fontRendererObj.trimStringToWidth(llllllllllllllIIIlIllIlllIllIlll.func_192297_a().getFormattedText(), 163);
        this.field_191837_o = MathHelper.floor(llllllllllllllIIIlIllIlllIllIlll.func_192299_e() * 28.0f);
        this.field_191826_p = MathHelper.floor(llllllllllllllIIIlIllIlllIllIlll.func_192296_f() * 27.0f);
        final int llllllllllllllIIIlIllIllllIIIIIl = llllllllllllllIIIlIllIlllIlllIII.func_193124_g();
        final int llllllllllllllIIIlIllIllllIIIIII = String.valueOf(llllllllllllllIIIlIllIllllIIIIIl).length();
        final int llllllllllllllIIIlIllIlllIllllll = (llllllllllllllIIIlIllIllllIIIIIl > 1) ? (llllllllllllllIIIlIllIlllIlllIIl.fontRendererObj.getStringWidth("  ") + llllllllllllllIIIlIllIlllIlllIIl.fontRendererObj.getStringWidth("0") * llllllllllllllIIIlIllIllllIIIIII * 2 + llllllllllllllIIIlIllIlllIlllIIl.fontRendererObj.getStringWidth("/")) : 0;
        int llllllllllllllIIIlIllIlllIlllllI = 29 + llllllllllllllIIIlIllIlllIlllIIl.fontRendererObj.getStringWidth(this.field_191831_i) + llllllllllllllIIIlIllIlllIllllll;
        final String llllllllllllllIIIlIllIlllIllllIl = llllllllllllllIIIlIllIlllIllIlll.func_193222_b().getFormattedText();
        this.field_192997_l = this.func_192995_a(llllllllllllllIIIlIllIlllIllllIl, llllllllllllllIIIlIllIlllIlllllI);
        for (final String llllllllllllllIIIlIllIlllIllllII : this.field_192997_l) {
            llllllllllllllIIIlIllIlllIlllllI = Math.max(llllllllllllllIIIlIllIlllIlllllI, llllllllllllllIIIlIllIlllIlllIIl.fontRendererObj.getStringWidth(llllllllllllllIIIlIllIlllIllllII));
        }
        this.field_191832_j = llllllllllllllIIIlIllIlllIlllllI + 3 + 5;
    }
    
    public boolean func_191816_c(final int llllllllllllllIIIlIllIlIlIlllIlI, final int llllllllllllllIIIlIllIlIlIllIIII, final int llllllllllllllIIIlIllIlIlIlIllll, final int llllllllllllllIIIlIllIlIlIllIlll) {
        if (!this.field_191830_h.func_193224_j() || (this.field_191836_n != null && this.field_191836_n.func_192105_a())) {
            final int llllllllllllllIIIlIllIlIlIllIllI = llllllllllllllIIIlIllIlIlIlllIlI + this.field_191837_o;
            final int llllllllllllllIIIlIllIlIlIllIlIl = llllllllllllllIIIlIllIlIlIllIllI + 26;
            final int llllllllllllllIIIlIllIlIlIllIlII = llllllllllllllIIIlIllIlIlIllIIII + this.field_191826_p;
            final int llllllllllllllIIIlIllIlIlIllIIll = llllllllllllllIIIlIllIlIlIllIlII + 26;
            return llllllllllllllIIIlIllIlIlIlIllll >= llllllllllllllIIIlIllIlIlIllIllI && llllllllllllllIIIlIllIlIlIlIllll <= llllllllllllllIIIlIllIlIlIllIlIl && llllllllllllllIIIlIllIlIlIllIlll >= llllllllllllllIIIlIllIlIlIllIlII && llllllllllllllIIIlIllIlIlIllIlll <= llllllllllllllIIIlIllIlIlIllIIll;
        }
        return false;
    }
}
