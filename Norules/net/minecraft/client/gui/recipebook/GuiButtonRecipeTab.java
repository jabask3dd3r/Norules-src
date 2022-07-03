package net.minecraft.client.gui.recipebook;

import net.minecraft.client.gui.*;
import net.minecraft.creativetab.*;
import net.minecraft.client.*;
import net.minecraft.client.util.*;
import net.minecraft.item.crafting.*;
import net.minecraft.stats.*;
import java.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.item.*;

public class GuiButtonRecipeTab extends GuiButtonToggle
{
    private final /* synthetic */ CreativeTabs field_193921_u;
    private /* synthetic */ float field_193922_v;
    
    public CreativeTabs func_191764_e() {
        return this.field_193921_u;
    }
    
    @Override
    public void func_191745_a(final Minecraft llllllllllllllllIlIIlllIllIlIIll, final int llllllllllllllllIlIIlllIllIlIIlI, final int llllllllllllllllIlIIlllIllIlIIIl, final float llllllllllllllllIlIIlllIllIlIIII) {
        if (this.visible) {
            if (this.field_193922_v > 0.0f) {
                final float llllllllllllllllIlIIlllIllIIllll = 1.0f + 0.1f * (float)Math.sin(this.field_193922_v / 15.0f * 3.1415927f);
                GlStateManager.pushMatrix();
                GlStateManager.translate((float)(this.xPosition + 8), (float)(this.yPosition + 12), 0.0f);
                GlStateManager.scale(1.0f, llllllllllllllllIlIIlllIllIIllll, 1.0f);
                GlStateManager.translate((float)(-(this.xPosition + 8)), (float)(-(this.yPosition + 12)), 0.0f);
            }
            this.hovered = (llllllllllllllllIlIIlllIllIlIIlI >= this.xPosition && llllllllllllllllIlIIlllIllIlIIIl >= this.yPosition && llllllllllllllllIlIIlllIllIlIIlI < this.xPosition + this.width && llllllllllllllllIlIIlllIllIlIIIl < this.yPosition + this.height);
            llllllllllllllllIlIIlllIllIlIIll.getTextureManager().bindTexture(this.field_191760_o);
            GlStateManager.disableDepth();
            int llllllllllllllllIlIIlllIllIIlllI = this.field_191756_q;
            int llllllllllllllllIlIIlllIllIIllIl = this.field_191757_r;
            if (this.field_191755_p) {
                llllllllllllllllIlIIlllIllIIlllI += this.field_191758_s;
            }
            if (this.hovered) {
                llllllllllllllllIlIIlllIllIIllIl += this.field_191759_t;
            }
            int llllllllllllllllIlIIlllIllIIllII = this.xPosition;
            if (this.field_191755_p) {
                llllllllllllllllIlIIlllIllIIllII -= 2;
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.drawTexturedModalRect(llllllllllllllllIlIIlllIllIIllII, this.yPosition, llllllllllllllllIlIIlllIllIIlllI, llllllllllllllllIlIIlllIllIIllIl, this.width, this.height);
            GlStateManager.enableDepth();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            this.func_193920_a(llllllllllllllllIlIIlllIllIlIIll.getRenderItem());
            GlStateManager.enableLighting();
            RenderHelper.disableStandardItemLighting();
            if (this.field_193922_v > 0.0f) {
                GlStateManager.popMatrix();
                this.field_193922_v -= llllllllllllllllIlIIlllIllIlIIII;
            }
        }
    }
    
    public GuiButtonRecipeTab(final int llllllllllllllllIlIIlllIllllIIlI, final CreativeTabs llllllllllllllllIlIIlllIllllIlII) {
        super(llllllllllllllllIlIIlllIllllIIlI, 0, 0, 35, 27, false);
        this.field_193921_u = llllllllllllllllIlIIlllIllllIlII;
        this.func_191751_a(153, 2, 35, 0, GuiRecipeBook.field_191894_a);
    }
    
    public void func_193918_a(final Minecraft llllllllllllllllIlIIlllIlllIIIlI) {
        final RecipeBook llllllllllllllllIlIIlllIlllIIlll = llllllllllllllllIlIIlllIlllIIIlI.player.func_192035_E();
        for (final RecipeList llllllllllllllllIlIIlllIlllIIllI : RecipeBookClient.field_194086_e.get(this.field_193921_u)) {
            for (final IRecipe llllllllllllllllIlIIlllIlllIIlII : llllllllllllllllIlIIlllIlllIIllI.func_194208_a(llllllllllllllllIlIIlllIlllIIlll.func_192815_c())) {
                if (llllllllllllllllIlIIlllIlllIIlll.func_194076_e(llllllllllllllllIlIIlllIlllIIlII)) {
                    this.field_193922_v = 15.0f;
                }
            }
        }
    }
    
    private void func_193920_a(final RenderItem llllllllllllllllIlIIlllIlIllllII) {
        final ItemStack llllllllllllllllIlIIlllIlIlllllI = this.field_193921_u.getIconItemStack();
        if (this.field_193921_u == CreativeTabs.TOOLS) {
            llllllllllllllllIlIIlllIlIllllII.renderItemAndEffectIntoGUI(llllllllllllllllIlIIlllIlIlllllI, this.xPosition + 3, this.yPosition + 5);
            llllllllllllllllIlIIlllIlIllllII.renderItemAndEffectIntoGUI(CreativeTabs.COMBAT.getIconItemStack(), this.xPosition + 14, this.yPosition + 5);
        }
        else if (this.field_193921_u == CreativeTabs.MISC) {
            llllllllllllllllIlIIlllIlIllllII.renderItemAndEffectIntoGUI(llllllllllllllllIlIIlllIlIlllllI, this.xPosition + 3, this.yPosition + 5);
            llllllllllllllllIlIIlllIlIllllII.renderItemAndEffectIntoGUI(CreativeTabs.FOOD.getIconItemStack(), this.xPosition + 14, this.yPosition + 5);
        }
        else {
            llllllllllllllllIlIIlllIlIllllII.renderItemAndEffectIntoGUI(llllllllllllllllIlIIlllIlIlllllI, this.xPosition + 9, this.yPosition + 5);
        }
    }
    
    public boolean func_193919_e() {
        final List<RecipeList> llllllllllllllllIlIIlllIlIllIIlI = RecipeBookClient.field_194086_e.get(this.field_193921_u);
        this.visible = false;
        for (final RecipeList llllllllllllllllIlIIlllIlIllIIIl : llllllllllllllllIlIIlllIlIllIIlI) {
            if (llllllllllllllllIlIIlllIlIllIIIl.func_194209_a() && llllllllllllllllIlIIlllIlIllIIIl.func_194212_c()) {
                this.visible = true;
                break;
            }
        }
        return this.visible;
    }
}
