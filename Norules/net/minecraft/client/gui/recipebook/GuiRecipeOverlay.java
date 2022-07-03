package net.minecraft.client.gui.recipebook;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.stats.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.*;
import com.google.common.collect.*;
import net.minecraft.client.gui.*;
import net.minecraft.item.crafting.*;
import java.util.*;
import net.minecraft.item.*;

public class GuiRecipeOverlay extends Gui
{
    private /* synthetic */ IRecipe field_193973_l;
    private static final /* synthetic */ ResourceLocation field_191847_a;
    private final /* synthetic */ List<Button> field_193972_f;
    private /* synthetic */ int field_191852_j;
    private /* synthetic */ float field_193974_m;
    private /* synthetic */ Minecraft field_191853_k;
    private /* synthetic */ int field_191851_i;
    private /* synthetic */ RecipeList field_191848_f;
    private /* synthetic */ boolean field_191850_h;
    
    public RecipeList func_193971_a() {
        return this.field_191848_f;
    }
    
    public void func_191845_a(final Minecraft lllllllllllllIIIlIIIIlIllIlIIlIl, final RecipeList lllllllllllllIIIlIIIIlIllIlIIlII, final int lllllllllllllIIIlIIIIlIllIlIIIll, final int lllllllllllllIIIlIIIIlIllIlIIIlI, final int lllllllllllllIIIlIIIIlIllIlIIIIl, final int lllllllllllllIIIlIIIIlIllIIIIlll, final float lllllllllllllIIIlIIIIlIllIIIIllI, final RecipeBook lllllllllllllIIIlIIIIlIllIIllllI) {
        this.field_191853_k = lllllllllllllIIIlIIIIlIllIlIIlIl;
        this.field_191848_f = lllllllllllllIIIlIIIIlIllIlIIlII;
        final boolean lllllllllllllIIIlIIIIlIllIIlllIl = lllllllllllllIIIlIIIIlIllIIllllI.func_192815_c();
        final List<IRecipe> lllllllllllllIIIlIIIIlIllIIlllII = lllllllllllllIIIlIIIIlIllIlIIlII.func_194207_b(true);
        final List<IRecipe> lllllllllllllIIIlIIIIlIllIIllIll = lllllllllllllIIIlIIIIlIllIIlllIl ? Collections.emptyList() : lllllllllllllIIIlIIIIlIllIlIIlII.func_194207_b(false);
        final int lllllllllllllIIIlIIIIlIllIIllIlI = lllllllllllllIIIlIIIIlIllIIlllII.size();
        final int lllllllllllllIIIlIIIIlIllIIllIIl = lllllllllllllIIIlIIIIlIllIIllIlI + lllllllllllllIIIlIIIIlIllIIllIll.size();
        final int lllllllllllllIIIlIIIIlIllIIllIII = (lllllllllllllIIIlIIIIlIllIIllIIl <= 16) ? 4 : 5;
        final int lllllllllllllIIIlIIIIlIllIIlIlll = (int)Math.ceil(lllllllllllllIIIlIIIIlIllIIllIIl / (float)lllllllllllllIIIlIIIIlIllIIllIII);
        this.field_191851_i = lllllllllllllIIIlIIIIlIllIlIIIll;
        this.field_191852_j = lllllllllllllIIIlIIIIlIllIlIIIlI;
        final int lllllllllllllIIIlIIIIlIllIIlIllI = 25;
        final float lllllllllllllIIIlIIIIlIllIIlIlIl = (float)(this.field_191851_i + Math.min(lllllllllllllIIIlIIIIlIllIIllIIl, lllllllllllllIIIlIIIIlIllIIllIII) * 25);
        final float lllllllllllllIIIlIIIIlIllIIlIlII = (float)(lllllllllllllIIIlIIIIlIllIlIIIIl + 50);
        if (lllllllllllllIIIlIIIIlIllIIlIlIl > lllllllllllllIIIlIIIIlIllIIlIlII) {
            this.field_191851_i -= (int)(lllllllllllllIIIlIIIIlIllIIIIllI * (int)((lllllllllllllIIIlIIIIlIllIIlIlIl - lllllllllllllIIIlIIIIlIllIIlIlII) / lllllllllllllIIIlIIIIlIllIIIIllI));
        }
        final float lllllllllllllIIIlIIIIlIllIIlIIll = (float)(this.field_191852_j + lllllllllllllIIIlIIIIlIllIIlIlll * 25);
        final float lllllllllllllIIIlIIIIlIllIIlIIlI = (float)(lllllllllllllIIIlIIIIlIllIIIIlll + 50);
        if (lllllllllllllIIIlIIIIlIllIIlIIll > lllllllllllllIIIlIIIIlIllIIlIIlI) {
            this.field_191852_j -= (int)(lllllllllllllIIIlIIIIlIllIIIIllI * MathHelper.ceil((lllllllllllllIIIlIIIIlIllIIlIIll - lllllllllllllIIIlIIIIlIllIIlIIlI) / lllllllllllllIIIlIIIIlIllIIIIllI));
        }
        final float lllllllllllllIIIlIIIIlIllIIlIIIl = (float)this.field_191852_j;
        final float lllllllllllllIIIlIIIIlIllIIlIIII = (float)(lllllllllllllIIIlIIIIlIllIIIIlll - 100);
        if (lllllllllllllIIIlIIIIlIllIIlIIIl < lllllllllllllIIIlIIIIlIllIIlIIII) {
            this.field_191852_j -= (int)(lllllllllllllIIIlIIIIlIllIIIIllI * MathHelper.ceil((lllllllllllllIIIlIIIIlIllIIlIIIl - lllllllllllllIIIlIIIIlIllIIlIIII) / lllllllllllllIIIlIIIIlIllIIIIllI));
        }
        this.field_191850_h = true;
        this.field_193972_f.clear();
        for (int lllllllllllllIIIlIIIIlIllIIIllll = 0; lllllllllllllIIIlIIIIlIllIIIllll < lllllllllllllIIIlIIIIlIllIIllIIl; ++lllllllllllllIIIlIIIIlIllIIIllll) {
            final boolean lllllllllllllIIIlIIIIlIllIIIlllI = lllllllllllllIIIlIIIIlIllIIIllll < lllllllllllllIIIlIIIIlIllIIllIlI;
            this.field_193972_f.add(new Button(this.field_191851_i + 4 + 25 * (lllllllllllllIIIlIIIIlIllIIIllll % lllllllllllllIIIlIIIIlIllIIllIII), this.field_191852_j + 5 + 25 * (lllllllllllllIIIlIIIIlIllIIIllll / lllllllllllllIIIlIIIIlIllIIllIII), lllllllllllllIIIlIIIIlIllIIIlllI ? lllllllllllllIIIlIIIIlIllIIlllII.get(lllllllllllllIIIlIIIIlIllIIIllll) : lllllllllllllIIIlIIIIlIllIIllIll.get(lllllllllllllIIIlIIIIlIllIIIllll - lllllllllllllIIIlIIIIlIllIIllIlI), lllllllllllllIIIlIIIIlIllIIIlllI));
        }
        this.field_193973_l = null;
    }
    
    public boolean func_193968_a(final int lllllllllllllIIIlIIIIlIlIllIIIlI, final int lllllllllllllIIIlIIIIlIlIllIIllI, final int lllllllllllllIIIlIIIIlIlIllIIIII) {
        if (lllllllllllllIIIlIIIIlIlIllIIIII != 0) {
            return false;
        }
        for (final Button lllllllllllllIIIlIIIIlIlIllIIlII : this.field_193972_f) {
            if (lllllllllllllIIIlIIIIlIlIllIIlII.mousePressed(this.field_191853_k, lllllllllllllIIIlIIIIlIlIllIIIlI, lllllllllllllIIIlIIIIlIlIllIIllI)) {
                this.field_193973_l = lllllllllllllIIIlIIIIlIlIllIIlII.field_193924_p;
                return true;
            }
        }
        return false;
    }
    
    public boolean func_191839_a() {
        return this.field_191850_h;
    }
    
    public void func_192999_a(final boolean lllllllllllllIIIlIIIIlIlIIIlIlll) {
        this.field_191850_h = lllllllllllllIIIlIIIIlIlIIIlIlll;
    }
    
    private void func_191846_c(final int lllllllllllllIIIlIIIIlIlIIlIllIl, final int lllllllllllllIIIlIIIIlIlIIlIllII, final int lllllllllllllIIIlIIIIlIlIIlIIIlI, final int lllllllllllllIIIlIIIIlIlIIlIlIlI, final int lllllllllllllIIIlIIIIlIlIIlIlIIl, final int lllllllllllllIIIlIIIIlIlIIlIlIII) {
        this.drawTexturedModalRect(this.field_191851_i, this.field_191852_j, lllllllllllllIIIlIIIIlIlIIlIlIIl, lllllllllllllIIIlIIIIlIlIIlIlIII, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
        this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI * 2 + lllllllllllllIIIlIIIIlIlIIlIllIl * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIIIlI + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
        this.drawTexturedModalRect(this.field_191851_i, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI * 2 + lllllllllllllIIIlIIIIlIlIIlIllII * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIIIlI + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
        this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI * 2 + lllllllllllllIIIlIIIIlIlIIlIllIl * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI * 2 + lllllllllllllIIIlIIIIlIlIIlIllII * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIIIlI + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIIIlI + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
        for (int lllllllllllllIIIlIIIIlIlIIlIIlll = 0; lllllllllllllIIIlIIIIlIlIIlIIlll < lllllllllllllIIIlIIIIlIlIIlIllIl; ++lllllllllllllIIIlIIIIlIlIIlIIlll) {
            this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI + lllllllllllllIIIlIIIIlIlIIlIIlll * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII, lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
            this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI + (lllllllllllllIIIlIIIIlIlIIlIIlll + 1) * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
            for (int lllllllllllllIIIlIIIIlIlIIlIIllI = 0; lllllllllllllIIIlIIIIlIlIIlIIllI < lllllllllllllIIIlIIIIlIlIIlIllII; ++lllllllllllllIIIlIIIIlIlIIlIIllI) {
                if (lllllllllllllIIIlIIIIlIlIIlIIlll == 0) {
                    this.drawTexturedModalRect(this.field_191851_i, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI + lllllllllllllIIIlIIIIlIlIIlIIllI * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIIIlI);
                    this.drawTexturedModalRect(this.field_191851_i, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI + (lllllllllllllIIIlIIIIlIlIIlIIllI + 1) * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
                }
                this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI + lllllllllllllIIIlIIIIlIlIIlIIlll * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI + lllllllllllllIIIlIIIIlIlIIlIIllI * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIIIlI);
                this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI + (lllllllllllllIIIlIIIIlIlIIlIIlll + 1) * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI + lllllllllllllIIIlIIIIlIlIIlIIllI * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIIIlI);
                this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI + lllllllllllllIIIlIIIIlIlIIlIIlll * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI + (lllllllllllllIIIlIIIIlIlIIlIIllI + 1) * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
                this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI + (lllllllllllllIIIlIIIIlIlIIlIIlll + 1) * lllllllllllllIIIlIIIIlIlIIlIIIlI - 1, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI + (lllllllllllllIIIlIIIIlIlIIlIIllI + 1) * lllllllllllllIIIlIIIIlIlIIlIIIlI - 1, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI + 1, lllllllllllllIIIlIIIIlIlIIlIlIlI + 1);
                if (lllllllllllllIIIlIIIIlIlIIlIIlll == lllllllllllllIIIlIIIIlIlIIlIllIl - 1) {
                    this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI * 2 + lllllllllllllIIIlIIIIlIlIIlIllIl * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI + lllllllllllllIIIlIIIIlIlIIlIIllI * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIIIlI + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIIIlI);
                    this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI * 2 + lllllllllllllIIIlIIIIlIlIIlIllIl * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI + (lllllllllllllIIIlIIIIlIlIIlIIllI + 1) * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIIIlI + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
                }
            }
            this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI + lllllllllllllIIIlIIIIlIlIIlIIlll * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI * 2 + lllllllllllllIIIlIIIIlIlIIlIllII * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIIIlI + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
            this.drawTexturedModalRect(this.field_191851_i + lllllllllllllIIIlIIIIlIlIIlIlIlI + (lllllllllllllIIIlIIIIlIlIIlIIlll + 1) * lllllllllllllIIIlIIIIlIlIIlIIIlI, this.field_191852_j + lllllllllllllIIIlIIIIlIlIIlIlIlI * 2 + lllllllllllllIIIlIIIIlIlIIlIllII * lllllllllllllIIIlIIIIlIlIIlIIIlI, lllllllllllllIIIlIIIIlIlIIlIlIIl + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIII + lllllllllllllIIIlIIIIlIlIIlIIIlI + lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI, lllllllllllllIIIlIIIIlIlIIlIlIlI);
        }
    }
    
    public void func_191842_a(final int lllllllllllllIIIlIIIIlIlIlIIllll, final int lllllllllllllIIIlIIIIlIlIlIIIIlI, final float lllllllllllllIIIlIIIIlIlIlIIllIl) {
        if (this.field_191850_h) {
            this.field_193974_m += lllllllllllllIIIlIIIIlIlIlIIllIl;
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.enableBlend();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.field_191853_k.getTextureManager().bindTexture(GuiRecipeOverlay.field_191847_a);
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, 170.0f);
            final int lllllllllllllIIIlIIIIlIlIlIIllII = (this.field_193972_f.size() <= 16) ? 4 : 5;
            final int lllllllllllllIIIlIIIIlIlIlIIlIll = Math.min(this.field_193972_f.size(), lllllllllllllIIIlIIIIlIlIlIIllII);
            final int lllllllllllllIIIlIIIIlIlIlIIlIlI = MathHelper.ceil(this.field_193972_f.size() / (float)lllllllllllllIIIlIIIIlIlIlIIllII);
            final int lllllllllllllIIIlIIIIlIlIlIIlIIl = 24;
            final int lllllllllllllIIIlIIIIlIlIlIIlIII = 4;
            final int lllllllllllllIIIlIIIIlIlIlIIIlll = 82;
            final int lllllllllllllIIIlIIIIlIlIlIIIllI = 208;
            this.func_191846_c(lllllllllllllIIIlIIIIlIlIlIIlIll, lllllllllllllIIIlIIIIlIlIlIIlIlI, 24, 4, 82, 208);
            GlStateManager.disableBlend();
            RenderHelper.disableStandardItemLighting();
            for (final Button lllllllllllllIIIlIIIIlIlIlIIIlIl : this.field_193972_f) {
                lllllllllllllIIIlIIIIlIlIlIIIlIl.func_191745_a(this.field_191853_k, lllllllllllllIIIlIIIIlIlIlIIllll, lllllllllllllIIIlIIIIlIlIlIIIIlI, lllllllllllllIIIlIIIIlIlIlIIllIl);
            }
            GlStateManager.popMatrix();
        }
    }
    
    static {
        field_191847_a = new ResourceLocation("textures/gui/recipe_book.png");
    }
    
    public IRecipe func_193967_b() {
        return this.field_193973_l;
    }
    
    public GuiRecipeOverlay() {
        this.field_193972_f = (List<Button>)Lists.newArrayList();
    }
    
    class Button extends GuiButton
    {
        private final /* synthetic */ IRecipe field_193924_p;
        private final /* synthetic */ boolean field_193925_q;
        
        public Button(final int lllllllllllllIllllllllIIllIIllll, final int lllllllllllllIllllllllIIllIlIlII, final IRecipe lllllllllllllIllllllllIIllIIllIl, final boolean lllllllllllllIllllllllIIllIlIIlI) {
            super(0, lllllllllllllIllllllllIIllIIllll, lllllllllllllIllllllllIIllIlIlII, "");
            this.width = 24;
            this.height = 24;
            this.field_193924_p = lllllllllllllIllllllllIIllIIllIl;
            this.field_193925_q = lllllllllllllIllllllllIIllIlIIlI;
        }
        
        public void func_191745_a(final Minecraft lllllllllllllIllllllllIIlIlllIIl, final int lllllllllllllIllllllllIIlIlllIII, final int lllllllllllllIllllllllIIlIlIIlII, final float lllllllllllllIllllllllIIlIllIllI) {
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.enableAlpha();
            lllllllllllllIllllllllIIlIlllIIl.getTextureManager().bindTexture(GuiRecipeOverlay.field_191847_a);
            this.hovered = (lllllllllllllIllllllllIIlIlllIII >= this.xPosition && lllllllllllllIllllllllIIlIlIIlII >= this.yPosition && lllllllllllllIllllllllIIlIlllIII < this.xPosition + this.width && lllllllllllllIllllllllIIlIlIIlII < this.yPosition + this.height);
            int lllllllllllllIllllllllIIlIllIlIl = 152;
            if (!this.field_193925_q) {
                lllllllllllllIllllllllIIlIllIlIl += 26;
            }
            int lllllllllllllIllllllllIIlIllIlII = 78;
            if (this.hovered) {
                lllllllllllllIllllllllIIlIllIlII += 26;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, lllllllllllllIllllllllIIlIllIlIl, lllllllllllllIllllllllIIlIllIlII, this.width, this.height);
            int lllllllllllllIllllllllIIlIllIIll = 3;
            int lllllllllllllIllllllllIIlIllIIlI = 3;
            if (this.field_193924_p instanceof ShapedRecipes) {
                final ShapedRecipes lllllllllllllIllllllllIIlIllIIIl = (ShapedRecipes)this.field_193924_p;
                lllllllllllllIllllllllIIlIllIIll = lllllllllllllIllllllllIIlIllIIIl.func_192403_f();
                lllllllllllllIllllllllIIlIllIIlI = lllllllllllllIllllllllIIlIllIIIl.func_192404_g();
            }
            final Iterator<Ingredient> lllllllllllllIllllllllIIlIllIIII = this.field_193924_p.func_192400_c().iterator();
            for (int lllllllllllllIllllllllIIlIlIllll = 0; lllllllllllllIllllllllIIlIlIllll < lllllllllllllIllllllllIIlIllIIlI; ++lllllllllllllIllllllllIIlIlIllll) {
                final int lllllllllllllIllllllllIIlIlIlllI = 3 + lllllllllllllIllllllllIIlIlIllll * 7;
                for (int lllllllllllllIllllllllIIlIlIllIl = 0; lllllllllllllIllllllllIIlIlIllIl < lllllllllllllIllllllllIIlIllIIll; ++lllllllllllllIllllllllIIlIlIllIl) {
                    if (lllllllllllllIllllllllIIlIllIIII.hasNext()) {
                        final ItemStack[] lllllllllllllIllllllllIIlIlIllII = lllllllllllllIllllllllIIlIllIIII.next().func_193365_a();
                        if (lllllllllllllIllllllllIIlIlIllII.length != 0) {
                            final int lllllllllllllIllllllllIIlIlIlIll = 3 + lllllllllllllIllllllllIIlIlIllIl * 7;
                            GlStateManager.pushMatrix();
                            final float lllllllllllllIllllllllIIlIlIlIlI = 0.42f;
                            final int lllllllllllllIllllllllIIlIlIlIIl = (int)((this.xPosition + lllllllllllllIllllllllIIlIlIlIll) / 0.42f - 3.0f);
                            final int lllllllllllllIllllllllIIlIlIlIII = (int)((this.yPosition + lllllllllllllIllllllllIIlIlIlllI) / 0.42f - 3.0f);
                            GlStateManager.scale(0.42f, 0.42f, 1.0f);
                            GlStateManager.enableLighting();
                            lllllllllllllIllllllllIIlIlllIIl.getRenderItem().renderItemAndEffectIntoGUI(lllllllllllllIllllllllIIlIlIllII[MathHelper.floor(GuiRecipeOverlay.this.field_193974_m / 30.0f) % lllllllllllllIllllllllIIlIlIllII.length], lllllllllllllIllllllllIIlIlIlIIl, lllllllllllllIllllllllIIlIlIlIII);
                            GlStateManager.disableLighting();
                            GlStateManager.popMatrix();
                        }
                    }
                }
            }
            GlStateManager.disableAlpha();
            RenderHelper.disableStandardItemLighting();
        }
    }
}
