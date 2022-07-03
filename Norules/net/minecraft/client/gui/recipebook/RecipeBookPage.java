package net.minecraft.client.gui.recipebook;

import net.minecraft.stats.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.*;
import net.minecraft.item.crafting.*;
import javax.annotation.*;
import net.minecraft.client.renderer.*;
import java.util.*;
import com.google.common.collect.*;

public class RecipeBookPage
{
    private /* synthetic */ RecipeList field_194206_m;
    private /* synthetic */ RecipeBook field_194204_k;
    private /* synthetic */ GuiButtonRecipe field_194201_b;
    private /* synthetic */ GuiButtonToggle field_193740_e;
    private /* synthetic */ GuiRecipeOverlay field_194202_c;
    private /* synthetic */ GuiButtonToggle field_193741_f;
    private /* synthetic */ int field_193738_c;
    private /* synthetic */ Minecraft field_193754_s;
    private /* synthetic */ List<GuiButtonRecipe> field_193743_h;
    private /* synthetic */ int field_193737_b;
    private /* synthetic */ IRecipe field_194205_l;
    private /* synthetic */ List<IRecipeUpdateListener> field_193757_v;
    private /* synthetic */ List<RecipeList> field_194203_f;
    
    public void func_194200_c() {
        this.field_194202_c.func_192999_a(false);
    }
    
    public void func_194195_a(final List<IRecipe> lllllllllllllIlIIllIlllIlIllllIl) {
        for (final IRecipeUpdateListener lllllllllllllIlIIllIlllIlIllllII : this.field_193757_v) {
            lllllllllllllIlIIllIlllIlIllllII.func_193001_a(lllllllllllllIlIIllIlllIlIllllIl);
        }
    }
    
    @Nullable
    public RecipeList func_194199_b() {
        return this.field_194206_m;
    }
    
    public void func_194194_a(final Minecraft lllllllllllllIlIIllIllllIIlIllll, final int lllllllllllllIlIIllIllllIIllIIll, final int lllllllllllllIlIIllIllllIIllIIlI) {
        this.field_193754_s = lllllllllllllIlIIllIllllIIlIllll;
        this.field_194204_k = lllllllllllllIlIIllIllllIIlIllll.player.func_192035_E();
        for (int lllllllllllllIlIIllIllllIIllIIIl = 0; lllllllllllllIlIIllIllllIIllIIIl < this.field_193743_h.size(); ++lllllllllllllIlIIllIllllIIllIIIl) {
            this.field_193743_h.get(lllllllllllllIlIIllIllllIIllIIIl).func_191770_c(lllllllllllllIlIIllIllllIIllIIll + 11 + 25 * (lllllllllllllIlIIllIllllIIllIIIl % 5), lllllllllllllIlIIllIllllIIllIIlI + 31 + 25 * (lllllllllllllIlIIllIllllIIllIIIl / 5));
        }
        this.field_193740_e = new GuiButtonToggle(0, lllllllllllllIlIIllIllllIIllIIll + 93, lllllllllllllIlIIllIllllIIllIIlI + 137, 12, 17, false);
        this.field_193740_e.func_191751_a(1, 208, 13, 18, GuiRecipeBook.field_191894_a);
        this.field_193741_f = new GuiButtonToggle(0, lllllllllllllIlIIllIllllIIllIIll + 38, lllllllllllllIlIIllIllllIIllIIlI + 137, 12, 17, true);
        this.field_193741_f.func_191751_a(1, 208, 13, 18, GuiRecipeBook.field_191894_a);
    }
    
    private void func_194197_e() {
        this.field_193740_e.visible = (this.field_193737_b > 1 && this.field_193738_c < this.field_193737_b - 1);
        this.field_193741_f.visible = (this.field_193737_b > 1 && this.field_193738_c > 0);
    }
    
    public void func_194191_a(final int lllllllllllllIlIIllIlllIlllllIII, final int lllllllllllllIlIIllIlllIllllIlll, final int lllllllllllllIlIIllIlllIllllllll, final int lllllllllllllIlIIllIlllIllllIlIl, final float lllllllllllllIlIIllIlllIllllllIl) {
        if (this.field_193737_b > 1) {
            final String lllllllllllllIlIIllIlllIllllllII = String.valueOf(new StringBuilder(String.valueOf(this.field_193738_c + 1)).append("/").append(this.field_193737_b));
            final int lllllllllllllIlIIllIlllIlllllIll = this.field_193754_s.fontRendererObj.getStringWidth(lllllllllllllIlIIllIlllIllllllII);
            this.field_193754_s.fontRendererObj.drawString(lllllllllllllIlIIllIlllIllllllII, lllllllllllllIlIIllIlllIlllllIII - lllllllllllllIlIIllIlllIlllllIll / 2 + 73, lllllllllllllIlIIllIlllIllllIlll + 141, -1);
        }
        RenderHelper.disableStandardItemLighting();
        this.field_194201_b = null;
        for (final GuiButtonRecipe lllllllllllllIlIIllIlllIlllllIlI : this.field_193743_h) {
            lllllllllllllIlIIllIlllIlllllIlI.func_191745_a(this.field_193754_s, lllllllllllllIlIIllIlllIllllllll, lllllllllllllIlIIllIlllIllllIlIl, lllllllllllllIlIIllIlllIllllllIl);
            if (lllllllllllllIlIIllIlllIlllllIlI.visible && lllllllllllllIlIIllIlllIlllllIlI.isMouseOver()) {
                this.field_194201_b = lllllllllllllIlIIllIlllIlllllIlI;
            }
        }
        this.field_193741_f.func_191745_a(this.field_193754_s, lllllllllllllIlIIllIlllIllllllll, lllllllllllllIlIIllIlllIllllIlIl, lllllllllllllIlIIllIlllIllllllIl);
        this.field_193740_e.func_191745_a(this.field_193754_s, lllllllllllllIlIIllIlllIllllllll, lllllllllllllIlIIllIlllIllllIlIl, lllllllllllllIlIIllIlllIllllllIl);
        this.field_194202_c.func_191842_a(lllllllllllllIlIIllIlllIllllllll, lllllllllllllIlIIllIlllIllllIlIl, lllllllllllllIlIIllIlllIllllllIl);
    }
    
    @Nullable
    public IRecipe func_194193_a() {
        return this.field_194205_l;
    }
    
    private void func_194198_d() {
        final int lllllllllllllIlIIllIllllIIIlIllI = 20 * this.field_193738_c;
        for (int lllllllllllllIlIIllIllllIIIlIlIl = 0; lllllllllllllIlIIllIllllIIIlIlIl < this.field_193743_h.size(); ++lllllllllllllIlIIllIllllIIIlIlIl) {
            final GuiButtonRecipe lllllllllllllIlIIllIllllIIIlIlII = this.field_193743_h.get(lllllllllllllIlIIllIllllIIIlIlIl);
            if (lllllllllllllIlIIllIllllIIIlIllI + lllllllllllllIlIIllIllllIIIlIlIl < this.field_194203_f.size()) {
                final RecipeList lllllllllllllIlIIllIllllIIIlIIll = this.field_194203_f.get(lllllllllllllIlIIllIllllIIIlIllI + lllllllllllllIlIIllIllllIIIlIlIl);
                lllllllllllllIlIIllIllllIIIlIlII.func_193928_a(lllllllllllllIlIIllIllllIIIlIIll, this, this.field_194204_k);
                lllllllllllllIlIIllIllllIIIlIlII.visible = true;
            }
            else {
                lllllllllllllIlIIllIllllIIIlIlII.visible = false;
            }
        }
        this.func_194197_e();
    }
    
    public boolean func_194196_a(final int lllllllllllllIlIIllIlllIllIIlIll, final int lllllllllllllIlIIllIlllIllIlIIll, final int lllllllllllllIlIIllIlllIllIIlIIl, final int lllllllllllllIlIIllIlllIllIIlIII, final int lllllllllllllIlIIllIlllIllIlIIII, final int lllllllllllllIlIIllIlllIllIIIllI, final int lllllllllllllIlIIllIlllIllIIlllI) {
        this.field_194205_l = null;
        this.field_194206_m = null;
        if (this.field_194202_c.func_191839_a()) {
            if (this.field_194202_c.func_193968_a(lllllllllllllIlIIllIlllIllIIlIll, lllllllllllllIlIIllIlllIllIlIIll, lllllllllllllIlIIllIlllIllIIlIIl)) {
                this.field_194205_l = this.field_194202_c.func_193967_b();
                this.field_194206_m = this.field_194202_c.func_193971_a();
            }
            else {
                this.field_194202_c.func_192999_a(false);
            }
            return true;
        }
        if (this.field_193740_e.mousePressed(this.field_193754_s, lllllllllllllIlIIllIlllIllIIlIll, lllllllllllllIlIIllIlllIllIlIIll) && lllllllllllllIlIIllIlllIllIIlIIl == 0) {
            this.field_193740_e.playPressSound(this.field_193754_s.getSoundHandler());
            ++this.field_193738_c;
            this.func_194198_d();
            return true;
        }
        if (this.field_193741_f.mousePressed(this.field_193754_s, lllllllllllllIlIIllIlllIllIIlIll, lllllllllllllIlIIllIlllIllIlIIll) && lllllllllllllIlIIllIlllIllIIlIIl == 0) {
            this.field_193741_f.playPressSound(this.field_193754_s.getSoundHandler());
            --this.field_193738_c;
            this.func_194198_d();
            return true;
        }
        for (final GuiButtonRecipe lllllllllllllIlIIllIlllIllIIllIl : this.field_193743_h) {
            if (lllllllllllllIlIIllIlllIllIIllIl.mousePressed(this.field_193754_s, lllllllllllllIlIIllIlllIllIIlIll, lllllllllllllIlIIllIlllIllIlIIll)) {
                lllllllllllllIlIIllIlllIllIIllIl.playPressSound(this.field_193754_s.getSoundHandler());
                if (lllllllllllllIlIIllIlllIllIIlIIl == 0) {
                    this.field_194205_l = lllllllllllllIlIIllIlllIllIIllIl.func_193760_e();
                    this.field_194206_m = lllllllllllllIlIIllIlllIllIIllIl.func_191771_c();
                }
                else if (!this.field_194202_c.func_191839_a() && !lllllllllllllIlIIllIlllIllIIllIl.func_193929_d()) {
                    this.field_194202_c.func_191845_a(this.field_193754_s, lllllllllllllIlIIllIlllIllIIllIl.func_191771_c(), lllllllllllllIlIIllIlllIllIIllIl.xPosition, lllllllllllllIlIIllIlllIllIIllIl.yPosition, lllllllllllllIlIIllIlllIllIIlIII + lllllllllllllIlIIllIlllIllIIIllI / 2, lllllllllllllIlIIllIlllIllIlIIII + 13 + lllllllllllllIlIIllIlllIllIIlllI / 2, (float)lllllllllllllIlIIllIlllIllIIllIl.getButtonWidth(), this.field_194204_k);
                }
                return true;
            }
        }
        return false;
    }
    
    public RecipeBookPage() {
        this.field_193743_h = (List<GuiButtonRecipe>)Lists.newArrayListWithCapacity(20);
        this.field_194202_c = new GuiRecipeOverlay();
        this.field_193757_v = (List<IRecipeUpdateListener>)Lists.newArrayList();
        for (int lllllllllllllIlIIllIllllIIllllIl = 0; lllllllllllllIlIIllIllllIIllllIl < 20; ++lllllllllllllIlIIllIllllIIllllIl) {
            this.field_193743_h.add(new GuiButtonRecipe());
        }
    }
    
    public void func_193721_a(final int lllllllllllllIlIIllIlllIlllIlIlI, final int lllllllllllllIlIIllIlllIlllIllII) {
        if (this.field_193754_s.currentScreen != null && this.field_194201_b != null && !this.field_194202_c.func_191839_a()) {
            this.field_193754_s.currentScreen.drawHoveringText(this.field_194201_b.func_191772_a(this.field_193754_s.currentScreen), lllllllllllllIlIIllIlllIlllIlIlI, lllllllllllllIlIIllIlllIlllIllII);
        }
    }
    
    public void func_193732_a(final GuiRecipeBook lllllllllllllIlIIllIllllIIlIIllI) {
        this.field_193757_v.remove(lllllllllllllIlIIllIllllIIlIIllI);
        this.field_193757_v.add(lllllllllllllIlIIllIllllIIlIIllI);
    }
    
    public void func_194192_a(final List<RecipeList> lllllllllllllIlIIllIllllIIlIIIIl, final boolean lllllllllllllIlIIllIllllIIIlllIl) {
        this.field_194203_f = lllllllllllllIlIIllIllllIIlIIIIl;
        this.field_193737_b = (int)Math.ceil(lllllllllllllIlIIllIllllIIlIIIIl.size() / 20.0);
        if (this.field_193737_b <= this.field_193738_c || lllllllllllllIlIIllIllllIIIlllIl) {
            this.field_193738_c = 0;
        }
        this.func_194198_d();
    }
}
