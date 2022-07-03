package net.minecraft.client.gui.toasts;

import java.util.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.item.crafting.*;

public class RecipeToast implements IToast
{
    private /* synthetic */ boolean field_193668_e;
    private final /* synthetic */ List<ItemStack> field_193666_c;
    private /* synthetic */ long field_193667_d;
    
    public RecipeToast(final ItemStack llllllllllllllIIIlIlIlllIlIlIIII) {
        this.field_193666_c = (List<ItemStack>)Lists.newArrayList();
        this.field_193666_c.add(llllllllllllllIIIlIlIlllIlIlIIII);
    }
    
    @Override
    public Visibility func_193653_a(final GuiToast llllllllllllllIIIlIlIlllIlIIlIII, final long llllllllllllllIIIlIlIlllIlIIIlll) {
        if (this.field_193668_e) {
            this.field_193667_d = llllllllllllllIIIlIlIlllIlIIIlll;
            this.field_193668_e = false;
        }
        if (this.field_193666_c.isEmpty()) {
            return Visibility.HIDE;
        }
        llllllllllllllIIIlIlIlllIlIIlIII.func_192989_b().getTextureManager().bindTexture(RecipeToast.field_193654_a);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        llllllllllllllIIIlIlIlllIlIIlIII.drawTexturedModalRect(0, 0, 0, 32, 160, 32);
        llllllllllllllIIIlIlIlllIlIIlIII.func_192989_b().fontRendererObj.drawString(I18n.format("recipe.toast.title", new Object[0]), 30.0, 7.0, -11534256);
        llllllllllllllIIIlIlIlllIlIIlIII.func_192989_b().fontRendererObj.drawString(I18n.format("recipe.toast.description", new Object[0]), 30.0, 18.0, -16777216);
        RenderHelper.enableGUIStandardItemLighting();
        llllllllllllllIIIlIlIlllIlIIlIII.func_192989_b().getRenderItem().renderItemAndEffectIntoGUI(null, this.field_193666_c.get((int)(llllllllllllllIIIlIlIlllIlIIIlll / (5000L / this.field_193666_c.size()) % this.field_193666_c.size())), 8, 8);
        return (llllllllllllllIIIlIlIlllIlIIIlll - this.field_193667_d >= 5000L) ? Visibility.HIDE : Visibility.SHOW;
    }
    
    public void func_193664_a(final ItemStack llllllllllllllIIIlIlIlllIlIIIIIl) {
        if (this.field_193666_c.add(llllllllllllllIIIlIlIlllIlIIIIIl)) {
            this.field_193668_e = true;
        }
    }
    
    public static void func_193665_a(final GuiToast llllllllllllllIIIlIlIlllIIllllIl, final IRecipe llllllllllllllIIIlIlIlllIIllllII) {
        final RecipeToast llllllllllllllIIIlIlIlllIIlllIll = llllllllllllllIIIlIlIlllIIllllIl.func_192990_a((Class<? extends RecipeToast>)RecipeToast.class, RecipeToast.field_193655_b);
        if (llllllllllllllIIIlIlIlllIIlllIll == null) {
            llllllllllllllIIIlIlIlllIIllllIl.func_192988_a(new RecipeToast(llllllllllllllIIIlIlIlllIIllllII.getRecipeOutput()));
        }
        else {
            llllllllllllllIIIlIlIlllIIlllIll.func_193664_a(llllllllllllllIIIlIlIlllIIllllII.getRecipeOutput());
        }
    }
}
