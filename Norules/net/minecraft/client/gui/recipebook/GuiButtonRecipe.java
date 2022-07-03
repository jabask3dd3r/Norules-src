package net.minecraft.client.gui.recipebook;

import net.minecraft.stats.*;
import net.minecraft.util.*;
import net.minecraft.client.gui.*;
import net.minecraft.item.crafting.*;
import net.minecraft.client.resources.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import java.util.*;

public class GuiButtonRecipe extends GuiButton
{
    private /* synthetic */ RecipeBook field_193930_p;
    private /* synthetic */ float field_191778_t;
    private /* synthetic */ RecipeList field_191774_p;
    private /* synthetic */ int field_193932_t;
    private static final /* synthetic */ ResourceLocation field_191780_o;
    private /* synthetic */ float field_193931_r;
    
    public List<String> func_191772_a(final GuiScreen llllllllllllllIIIlIIlllIlllIlIll) {
        final ItemStack llllllllllllllIIIlIIlllIlllIlIlI = this.func_193927_f().get(this.field_193932_t).getRecipeOutput();
        final List<String> llllllllllllllIIIlIIlllIlllIlIIl = llllllllllllllIIIlIIlllIlllIlIll.func_191927_a(llllllllllllllIIIlIIlllIlllIlIlI);
        if (this.field_191774_p.func_194208_a(this.field_193930_p.func_192815_c()).size() > 1) {
            llllllllllllllIIIlIIlllIlllIlIIl.add(I18n.format("gui.recipebook.moreRecipes", new Object[0]));
        }
        return llllllllllllllIIIlIIlllIlllIlIIl;
    }
    
    public GuiButtonRecipe() {
        super(0, 0, 0, 25, 25, "");
    }
    
    static {
        field_191780_o = new ResourceLocation("textures/gui/recipe_book.png");
    }
    
    public RecipeList func_191771_c() {
        return this.field_191774_p;
    }
    
    @Override
    public int getButtonWidth() {
        return 25;
    }
    
    public void func_191745_a(final Minecraft llllllllllllllIIIlIIllllIIIIlIIl, final int llllllllllllllIIIlIIllllIIIIlIII, final int llllllllllllllIIIlIIllllIIIlIIll, final float llllllllllllllIIIlIIllllIIIlIIlI) {
        if (this.visible) {
            if (!GuiScreen.isCtrlKeyDown()) {
                this.field_193931_r += llllllllllllllIIIlIIllllIIIlIIlI;
            }
            this.hovered = (llllllllllllllIIIlIIllllIIIIlIII >= this.xPosition && llllllllllllllIIIlIIllllIIIlIIll >= this.yPosition && llllllllllllllIIIlIIllllIIIIlIII < this.xPosition + this.width && llllllllllllllIIIlIIllllIIIlIIll < this.yPosition + this.height);
            RenderHelper.enableGUIStandardItemLighting();
            llllllllllllllIIIlIIllllIIIIlIIl.getTextureManager().bindTexture(GuiButtonRecipe.field_191780_o);
            GlStateManager.disableLighting();
            int llllllllllllllIIIlIIllllIIIlIIIl = 29;
            if (!this.field_191774_p.func_192708_c()) {
                llllllllllllllIIIlIIllllIIIlIIIl += 25;
            }
            int llllllllllllllIIIlIIllllIIIlIIII = 206;
            if (this.field_191774_p.func_194208_a(this.field_193930_p.func_192815_c()).size() > 1) {
                llllllllllllllIIIlIIllllIIIlIIII += 25;
            }
            final boolean llllllllllllllIIIlIIllllIIIIllll = this.field_191778_t > 0.0f;
            if (llllllllllllllIIIlIIllllIIIIllll) {
                final float llllllllllllllIIIlIIllllIIIIlllI = 1.0f + 0.1f * (float)Math.sin(this.field_191778_t / 15.0f * 3.1415927f);
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(this.xPosition + 8), (float)(this.yPosition + 12), 0.0f);
                GlStateManager.scale(llllllllllllllIIIlIIllllIIIIlllI, llllllllllllllIIIlIIllllIIIIlllI, 1.0f);
                GlStateManager.translate((float)(-(this.xPosition + 8)), (float)(-(this.yPosition + 12)), 0.0f);
                this.field_191778_t -= llllllllllllllIIIlIIllllIIIlIIlI;
            }
            this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllllIIIlIIllllIIIlIIIl, llllllllllllllIIIlIIllllIIIlIIII, this.width, this.height);
            final List<IRecipe> llllllllllllllIIIlIIllllIIIIllIl = this.func_193927_f();
            this.field_193932_t = MathHelper.floor(this.field_193931_r / 30.0f) % llllllllllllllIIIlIIllllIIIIllIl.size();
            final ItemStack llllllllllllllIIIlIIllllIIIIllII = llllllllllllllIIIlIIllllIIIIllIl.get(this.field_193932_t).getRecipeOutput();
            int llllllllllllllIIIlIIllllIIIIlIll = 4;
            if (this.field_191774_p.func_194211_e() && this.func_193927_f().size() > 1) {
                llllllllllllllIIIlIIllllIIIIlIIl.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllIIIlIIllllIIIIllII, this.xPosition + llllllllllllllIIIlIIllllIIIIlIll + 1, this.yPosition + llllllllllllllIIIlIIllllIIIIlIll + 1);
                --llllllllllllllIIIlIIllllIIIIlIll;
            }
            llllllllllllllIIIlIIllllIIIIlIIl.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllIIIlIIllllIIIIllII, this.xPosition + llllllllllllllIIIlIIllllIIIIlIll, this.yPosition + llllllllllllllIIIlIIllllIIIIlIll);
            if (llllllllllllllIIIlIIllllIIIIllll) {
                GlStateManager.popMatrix();
            }
            GlStateManager.enableLighting();
            RenderHelper.disableStandardItemLighting();
        }
    }
    
    public IRecipe func_193760_e() {
        final List<IRecipe> llllllllllllllIIIlIIlllIllllIIll = this.func_193927_f();
        return llllllllllllllIIIlIIlllIllllIIll.get(this.field_193932_t);
    }
    
    public void func_191770_c(final int llllllllllllllIIIlIIllllIIlIIllI, final int llllllllllllllIIIlIIllllIIlIIlIl) {
        this.xPosition = llllllllllllllIIIlIIllllIIlIIllI;
        this.yPosition = llllllllllllllIIIlIIllllIIlIIlIl;
    }
    
    public void func_193928_a(final RecipeList llllllllllllllIIIlIIllllIIlllIIl, final RecipeBookPage llllllllllllllIIIlIIllllIIllIIlI, final RecipeBook llllllllllllllIIIlIIllllIIllIIIl) {
        this.field_191774_p = llllllllllllllIIIlIIllllIIlllIIl;
        this.field_193930_p = llllllllllllllIIIlIIllllIIllIIIl;
        final List<IRecipe> llllllllllllllIIIlIIllllIIllIllI = llllllllllllllIIIlIIllllIIlllIIl.func_194208_a(llllllllllllllIIIlIIllllIIllIIIl.func_192815_c());
        for (final IRecipe llllllllllllllIIIlIIllllIIllIlIl : llllllllllllllIIIlIIllllIIllIllI) {
            if (llllllllllllllIIIlIIllllIIllIIIl.func_194076_e(llllllllllllllIIIlIIllllIIllIlIl)) {
                llllllllllllllIIIlIIllllIIllIIlI.func_194195_a(llllllllllllllIIIlIIllllIIllIllI);
                this.field_191778_t = 15.0f;
                break;
            }
        }
    }
    
    private List<IRecipe> func_193927_f() {
        final List<IRecipe> llllllllllllllIIIlIIlllIllllllII = this.field_191774_p.func_194207_b(true);
        if (!this.field_193930_p.func_192815_c()) {
            llllllllllllllIIIlIIlllIllllllII.addAll(this.field_191774_p.func_194207_b(false));
        }
        return llllllllllllllIIIlIIlllIllllllII;
    }
    
    public boolean func_193929_d() {
        return this.func_193927_f().size() == 1;
    }
}
