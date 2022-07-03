package net.minecraft.client.gui.recipebook;

import java.util.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.item.crafting.*;
import net.minecraft.util.math.*;

public class GhostRecipe
{
    private /* synthetic */ IRecipe field_192687_a;
    private final /* synthetic */ List<GhostIngredient> field_192688_b;
    private /* synthetic */ float field_194190_c;
    
    public GhostIngredient func_192681_a(final int llllllllllllIlllllIIIIIlllllIlll) {
        return this.field_192688_b.get(llllllllllllIlllllIIIIIlllllIlll);
    }
    
    public void func_194188_a(final Minecraft llllllllllllIlllllIIIIIlllIIllll, final int llllllllllllIlllllIIIIIlllIIlllI, final int llllllllllllIlllllIIIIIlllIIllIl, final boolean llllllllllllIlllllIIIIIlllIIllII, final float llllllllllllIlllllIIIIIlllIIlIll) {
        if (!GuiScreen.isCtrlKeyDown()) {
            this.field_194190_c += llllllllllllIlllllIIIIIlllIIlIll;
        }
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.disableLighting();
        for (int llllllllllllIlllllIIIIIlllIlIllI = 0; llllllllllllIlllllIIIIIlllIlIllI < this.field_192688_b.size(); ++llllllllllllIlllllIIIIIlllIlIllI) {
            final GhostIngredient llllllllllllIlllllIIIIIlllIlIlIl = this.field_192688_b.get(llllllllllllIlllllIIIIIlllIlIllI);
            final int llllllllllllIlllllIIIIIlllIlIlII = llllllllllllIlllllIIIIIlllIlIlIl.func_193713_b() + llllllllllllIlllllIIIIIlllIIlllI;
            final int llllllllllllIlllllIIIIIlllIlIIll = llllllllllllIlllllIIIIIlllIlIlIl.func_193712_c() + llllllllllllIlllllIIIIIlllIIllIl;
            if (llllllllllllIlllllIIIIIlllIlIllI == 0 && llllllllllllIlllllIIIIIlllIIllII) {
                Gui.drawRect(llllllllllllIlllllIIIIIlllIlIlII - 4, llllllllllllIlllllIIIIIlllIlIIll - 4, llllllllllllIlllllIIIIIlllIlIlII + 20, llllllllllllIlllllIIIIIlllIlIIll + 20, 822018048);
            }
            else {
                Gui.drawRect(llllllllllllIlllllIIIIIlllIlIlII, llllllllllllIlllllIIIIIlllIlIIll, llllllllllllIlllllIIIIIlllIlIlII + 16, llllllllllllIlllllIIIIIlllIlIIll + 16, 822018048);
            }
            GlStateManager.disableLighting();
            final ItemStack llllllllllllIlllllIIIIIlllIlIIlI = llllllllllllIlllllIIIIIlllIlIlIl.func_194184_c();
            final RenderItem llllllllllllIlllllIIIIIlllIlIIIl = llllllllllllIlllllIIIIIlllIIllll.getRenderItem();
            llllllllllllIlllllIIIIIlllIlIIIl.renderItemAndEffectIntoGUI(llllllllllllIlllllIIIIIlllIIllll.player, llllllllllllIlllllIIIIIlllIlIIlI, llllllllllllIlllllIIIIIlllIlIlII, llllllllllllIlllllIIIIIlllIlIIll);
            GlStateManager.depthFunc(516);
            Gui.drawRect(llllllllllllIlllllIIIIIlllIlIlII, llllllllllllIlllllIIIIIlllIlIIll, llllllllllllIlllllIIIIIlllIlIlII + 16, llllllllllllIlllllIIIIIlllIlIIll + 16, 822083583);
            GlStateManager.depthFunc(515);
            if (llllllllllllIlllllIIIIIlllIlIllI == 0) {
                llllllllllllIlllllIIIIIlllIlIIIl.renderItemOverlays(llllllllllllIlllllIIIIIlllIIllll.fontRendererObj, llllllllllllIlllllIIIIIlllIlIIlI, llllllllllllIlllllIIIIIlllIlIlII, llllllllllllIlllllIIIIIlllIlIIll);
            }
            GlStateManager.enableLighting();
        }
        RenderHelper.disableStandardItemLighting();
    }
    
    @Nullable
    public IRecipe func_192686_c() {
        return this.field_192687_a;
    }
    
    public GhostRecipe() {
        this.field_192688_b = (List<GhostIngredient>)Lists.newArrayList();
    }
    
    public void func_194187_a(final Ingredient llllllllllllIlllllIIIIlIIIIIIIIl, final int llllllllllllIlllllIIIIlIIIIIIIII, final int llllllllllllIlllllIIIIIllllllIll) {
        this.field_192688_b.add(new GhostIngredient(llllllllllllIlllllIIIIlIIIIIIIIl, llllllllllllIlllllIIIIlIIIIIIIII, llllllllllllIlllllIIIIIllllllIll));
    }
    
    public void func_192682_a() {
        this.field_192687_a = null;
        this.field_192688_b.clear();
        this.field_194190_c = 0.0f;
    }
    
    public void func_192685_a(final IRecipe llllllllllllIlllllIIIIIllllIlIIl) {
        this.field_192687_a = llllllllllllIlllllIIIIIllllIlIIl;
    }
    
    public int func_192684_b() {
        return this.field_192688_b.size();
    }
    
    public class GhostIngredient
    {
        private final /* synthetic */ int field_192678_b;
        private final /* synthetic */ int field_192679_c;
        private final /* synthetic */ Ingredient field_194186_b;
        
        public int func_193713_b() {
            return this.field_192678_b;
        }
        
        public ItemStack func_194184_c() {
            final ItemStack[] lllllllllllllIlIIlIIlIlllIIlIIIl = this.field_194186_b.func_193365_a();
            return lllllllllllllIlIIlIIlIlllIIlIIIl[MathHelper.floor(GhostRecipe.this.field_194190_c / 30.0f) % lllllllllllllIlIIlIIlIlllIIlIIIl.length];
        }
        
        public int func_193712_c() {
            return this.field_192679_c;
        }
        
        public GhostIngredient(final Ingredient lllllllllllllIlIIlIIlIlllIlIIIlI, final int lllllllllllllIlIIlIIlIlllIlIIIIl, final int lllllllllllllIlIIlIIlIlllIIllIll) {
            this.field_194186_b = lllllllllllllIlIIlIIlIlllIlIIIlI;
            this.field_192678_b = lllllllllllllIlIIlIIlIlllIlIIIIl;
            this.field_192679_c = lllllllllllllIlIIlIIlIlllIIllIll;
        }
    }
}
