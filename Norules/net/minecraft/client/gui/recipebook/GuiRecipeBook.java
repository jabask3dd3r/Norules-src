package net.minecraft.client.gui.recipebook;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.stats.*;
import com.google.common.collect.*;
import net.minecraft.client.util.*;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.creativetab.*;
import org.lwjgl.input.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.*;
import java.util.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import javax.annotation.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;

public class GuiRecipeBook extends Gui implements IRecipeUpdateListener
{
    private final /* synthetic */ RecipeBookPage field_193022_s;
    private /* synthetic */ int field_191903_n;
    private /* synthetic */ String field_193963_r;
    private final /* synthetic */ List<GuiButtonRecipeTab> field_193018_j;
    private /* synthetic */ InventoryCrafting field_193961_o;
    protected static final /* synthetic */ ResourceLocation field_191894_a;
    private /* synthetic */ GuiTextField field_193962_q;
    private /* synthetic */ GuiButtonToggle field_193960_m;
    private /* synthetic */ int field_191905_p;
    private /* synthetic */ Minecraft field_191888_F;
    private /* synthetic */ RecipeItemHelper field_193965_u;
    private /* synthetic */ int field_193966_v;
    private /* synthetic */ GuiButtonRecipeTab field_191913_x;
    private final /* synthetic */ GhostRecipe field_191915_z;
    private /* synthetic */ int field_191904_o;
    private /* synthetic */ RecipeBook field_193964_s;
    
    private void func_193003_g(final boolean llllllllllllllIIllllIIllllIllIIl) {
        final List<RecipeList> llllllllllllllIIllllIIllllIllllI = RecipeBookClient.field_194086_e.get(this.field_191913_x.func_191764_e());
        llllllllllllllIIllllIIllllIllllI.forEach(llllllllllllllIIllllIIlIllIllIlI -> llllllllllllllIIllllIIlIllIllIlI.func_194210_a(this.field_193965_u, this.field_193961_o.getWidth(), this.field_193961_o.getHeight(), this.field_193964_s));
        final List<RecipeList> llllllllllllllIIllllIIllllIlllIl = (List<RecipeList>)Lists.newArrayList((Iterable)llllllllllllllIIllllIIllllIllllI);
        llllllllllllllIIllllIIllllIlllIl.removeIf(llllllllllllllIIllllIIlIllIllIII -> !llllllllllllllIIllllIIlIllIllIII.func_194209_a());
        llllllllllllllIIllllIIllllIlllIl.removeIf(llllllllllllllIIllllIIlIllIlIlIl -> !llllllllllllllIIllllIIlIllIlIlIl.func_194212_c());
        final String llllllllllllllIIllllIIllllIlllII = this.field_193962_q.getText();
        if (!llllllllllllllIIllllIIllllIlllII.isEmpty()) {
            final ObjectSet<RecipeList> llllllllllllllIIllllIIllllIllIll = (ObjectSet<RecipeList>)new ObjectLinkedOpenHashSet((Collection)this.field_191888_F.func_193987_a(SearchTreeManager.field_194012_b).func_194038_a(llllllllllllllIIllllIIllllIlllII.toLowerCase(Locale.ROOT)));
            llllllllllllllIIllllIIllllIlllIl.removeIf(llllllllllllllIIllllIIlIllIlIIIl -> !llllllllllllllIIllllIIllllIllIll.contains((Object)llllllllllllllIIllllIIlIllIlIIIl));
        }
        if (this.field_193964_s.func_192815_c()) {
            llllllllllllllIIllllIIllllIlllIl.removeIf(llllllllllllllIIllllIIlIllIIllIl -> !llllllllllllllIIllllIIlIllIIllIl.func_192708_c());
        }
        this.field_193022_s.func_194192_a(llllllllllllllIIllllIIllllIlllIl, llllllllllllllIIllllIIllllIllIIl);
    }
    
    private void func_193716_a(final String llllllllllllllIIllllIIllIIlIIIIl) {
        if ("excitedze".equals(llllllllllllllIIllllIIllIIlIIIIl)) {
            final LanguageManager llllllllllllllIIllllIIllIIlIIIII = this.field_191888_F.getLanguageManager();
            final Language llllllllllllllIIllllIIllIIIlllll = llllllllllllllIIllllIIllIIlIIIII.func_191960_a("en_pt");
            if (llllllllllllllIIllllIIllIIlIIIII.getCurrentLanguage().compareTo(llllllllllllllIIllllIIllIIIlllll) == 0) {
                return;
            }
            llllllllllllllIIllllIIllIIlIIIII.setCurrentLanguage(llllllllllllllIIllllIIllIIIlllll);
            this.field_191888_F.gameSettings.language = llllllllllllllIIllllIIllIIIlllll.getLanguageCode();
            this.field_191888_F.refreshResources();
            this.field_191888_F.fontRendererObj.setUnicodeFlag(this.field_191888_F.getLanguageManager().isCurrentLocaleUnicode() || this.field_191888_F.gameSettings.forceUnicodeFont);
            this.field_191888_F.fontRendererObj.setBidiFlag(llllllllllllllIIllllIIllIIlIIIII.isCurrentLanguageBidirectional());
            this.field_191888_F.gameSettings.saveOptions();
        }
    }
    
    public boolean func_193955_c(final int llllllllllllllIIllllIIllIlIIIIll, final int llllllllllllllIIllllIIllIIlllIIl, final int llllllllllllllIIllllIIllIIlllIII, final int llllllllllllllIIllllIIllIlIIIIII, final int llllllllllllllIIllllIIllIIllllll, final int llllllllllllllIIllllIIllIIllIlIl) {
        if (!this.func_191878_b()) {
            return true;
        }
        final boolean llllllllllllllIIllllIIllIIllllIl = llllllllllllllIIllllIIllIlIIIIll < llllllllllllllIIllllIIllIIlllIII || llllllllllllllIIllllIIllIIlllIIl < llllllllllllllIIllllIIllIlIIIIII || llllllllllllllIIllllIIllIlIIIIll >= llllllllllllllIIllllIIllIIlllIII + llllllllllllllIIllllIIllIIllllll || llllllllllllllIIllllIIllIIlllIIl >= llllllllllllllIIllllIIllIlIIIIII + llllllllllllllIIllllIIllIIllIlIl;
        final boolean llllllllllllllIIllllIIllIIllllII = llllllllllllllIIllllIIllIIlllIII - 147 < llllllllllllllIIllllIIllIlIIIIll && llllllllllllllIIllllIIllIlIIIIll < llllllllllllllIIllllIIllIIlllIII && llllllllllllllIIllllIIllIlIIIIII < llllllllllllllIIllllIIllIIlllIIl && llllllllllllllIIllllIIllIIlllIIl < llllllllllllllIIllllIIllIlIIIIII + llllllllllllllIIllllIIllIIllIlIl;
        return llllllllllllllIIllllIIllIIllllIl && !llllllllllllllIIllllIIllIIllllII && !this.field_191913_x.mousePressed(this.field_191888_F, llllllllllllllIIllllIIllIlIIIIll, llllllllllllllIIllllIIllIIlllIIl);
    }
    
    public void func_191876_c(final int llllllllllllllIIllllIIlllIIlIIll, final int llllllllllllllIIllllIIlllIIlIIlI, final int llllllllllllllIIllllIIlllIIlIlll, final int llllllllllllllIIllllIIlllIIlIIII) {
        if (this.func_191878_b()) {
            this.field_193022_s.func_193721_a(llllllllllllllIIllllIIlllIIlIlll, llllllllllllllIIllllIIlllIIlIIII);
            if (this.field_193960_m.isMouseOver()) {
                final String llllllllllllllIIllllIIlllIIlIlIl = I18n.format(this.field_193960_m.func_191754_c() ? "gui.recipebook.toggleRecipes.craftable" : "gui.recipebook.toggleRecipes.all", new Object[0]);
                if (this.field_191888_F.currentScreen != null) {
                    this.field_191888_F.currentScreen.drawCreativeTabHoveringText(llllllllllllllIIllllIIlllIIlIlIl, llllllllllllllIIllllIIlllIIlIlll, llllllllllllllIIllllIIlllIIlIIII);
                }
            }
            this.func_193015_d(llllllllllllllIIllllIIlllIIlIIll, llllllllllllllIIllllIIlllIIlIIlI, llllllllllllllIIllllIIlllIIlIlll, llllllllllllllIIllllIIlllIIlIIII);
        }
    }
    
    private void func_193942_g() {
        this.field_193965_u.func_194119_a();
        this.field_191888_F.player.inventory.func_194016_a(this.field_193965_u, false);
        this.field_193961_o.func_194018_a(this.field_193965_u);
        this.func_193003_g(false);
    }
    
    public void func_191866_a() {
        this.func_193006_a(!this.func_191878_b());
    }
    
    public void func_191861_a(final int llllllllllllllIIllllIIlllIlIIlll, final int llllllllllllllIIllllIIlllIlIllIl, final float llllllllllllllIIllllIIlllIlIIlIl) {
        if (this.func_191878_b()) {
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f, 100.0f);
            this.field_191888_F.getTextureManager().bindTexture(GuiRecipeBook.field_191894_a);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            final int llllllllllllllIIllllIIlllIlIlIll = (this.field_191904_o - 147) / 2 - this.field_191903_n;
            final int llllllllllllllIIllllIIlllIlIlIlI = (this.field_191905_p - 166) / 2;
            this.drawTexturedModalRect(llllllllllllllIIllllIIlllIlIlIll, llllllllllllllIIllllIIlllIlIlIlI, 1, 1, 147, 166);
            this.field_193962_q.drawTextBox();
            RenderHelper.disableStandardItemLighting();
            for (final GuiButtonRecipeTab llllllllllllllIIllllIIlllIlIlIIl : this.field_193018_j) {
                llllllllllllllIIllllIIlllIlIlIIl.func_191745_a(this.field_191888_F, llllllllllllllIIllllIIlllIlIIlll, llllllllllllllIIllllIIlllIlIllIl, llllllllllllllIIllllIIlllIlIIlIl);
            }
            this.field_193960_m.func_191745_a(this.field_191888_F, llllllllllllllIIllllIIlllIlIIlll, llllllllllllllIIllllIIlllIlIllIl, llllllllllllllIIllllIIlllIlIIlIl);
            this.field_193022_s.func_194191_a(llllllllllllllIIllllIIlllIlIlIll, llllllllllllllIIllllIIlllIlIlIlI, llllllllllllllIIllllIIlllIlIIlll, llllllllllllllIIllllIIlllIlIllIl, llllllllllllllIIllllIIlllIlIIlIl);
            GlStateManager.popMatrix();
        }
    }
    
    public void func_193014_a(final boolean llllllllllllllIIllllIlIIIIIIllIl, final InventoryCrafting llllllllllllllIIllllIlIIIIIlIIIl) {
        this.field_191903_n = (llllllllllllllIIllllIlIIIIIIllIl ? 0 : 86);
        final int llllllllllllllIIllllIlIIIIIlIIII = (this.field_191904_o - 147) / 2 - this.field_191903_n;
        final int llllllllllllllIIllllIlIIIIIIllll = (this.field_191905_p - 166) / 2;
        this.field_193965_u.func_194119_a();
        this.field_191888_F.player.inventory.func_194016_a(this.field_193965_u, false);
        llllllllllllllIIllllIlIIIIIlIIIl.func_194018_a(this.field_193965_u);
        this.field_193962_q = new GuiTextField(0, this.field_191888_F.fontRendererObj, llllllllllllllIIllllIlIIIIIlIIII + 25, llllllllllllllIIllllIlIIIIIIllll + 14, 80, this.field_191888_F.fontRendererObj.FONT_HEIGHT + 5);
        this.field_193962_q.setMaxStringLength(50);
        this.field_193962_q.setEnableBackgroundDrawing(false);
        this.field_193962_q.setVisible(true);
        this.field_193962_q.setTextColor(16777215);
        this.field_193022_s.func_194194_a(this.field_191888_F, llllllllllllllIIllllIlIIIIIlIIII, llllllllllllllIIllllIlIIIIIIllll);
        this.field_193022_s.func_193732_a(this);
        this.field_193960_m = new GuiButtonToggle(0, llllllllllllllIIllllIlIIIIIlIIII + 110, llllllllllllllIIllllIlIIIIIIllll + 12, 26, 16, this.field_193964_s.func_192815_c());
        this.field_193960_m.func_191751_a(152, 41, 28, 18, GuiRecipeBook.field_191894_a);
        this.func_193003_g(false);
        this.func_193949_f();
    }
    
    private void func_193949_f() {
        final int llllllllllllllIIllllIIllllIIlIll = (this.field_191904_o - 147) / 2 - this.field_191903_n - 30;
        final int llllllllllllllIIllllIIllllIIlIlI = (this.field_191905_p - 166) / 2 + 3;
        final int llllllllllllllIIllllIIllllIIlIIl = 27;
        int llllllllllllllIIllllIIllllIIlIII = 0;
        for (final GuiButtonRecipeTab llllllllllllllIIllllIIllllIIIlll : this.field_193018_j) {
            final CreativeTabs llllllllllllllIIllllIIllllIIIllI = llllllllllllllIIllllIIllllIIIlll.func_191764_e();
            if (llllllllllllllIIllllIIllllIIIllI == CreativeTabs.SEARCH) {
                llllllllllllllIIllllIIllllIIIlll.visible = true;
                llllllllllllllIIllllIIllllIIIlll.func_191752_c(llllllllllllllIIllllIIllllIIlIll, llllllllllllllIIllllIIllllIIlIlI + 27 * llllllllllllllIIllllIIllllIIlIII++);
            }
            else {
                if (!llllllllllllllIIllllIIllllIIIlll.func_193919_e()) {
                    continue;
                }
                llllllllllllllIIllllIIllllIIIlll.func_191752_c(llllllllllllllIIllllIIllllIIlIll, llllllllllllllIIllllIIllllIIlIlI + 27 * llllllllllllllIIllllIIllllIIlIII++);
                llllllllllllllIIllllIIllllIIIlll.func_193918_a(this.field_191888_F);
            }
        }
    }
    
    public void func_193957_d() {
        if (this.func_191878_b() && this.field_193966_v != this.field_191888_F.player.inventory.func_194015_p()) {
            this.func_193942_g();
            this.field_193966_v = this.field_191888_F.player.inventory.func_194015_p();
        }
    }
    
    public void func_194303_a(final int llllllllllllllIIllllIlIIIIlIIIll, final int llllllllllllllIIllllIlIIIIlIIIlI, final Minecraft llllllllllllllIIllllIlIIIIlIIIIl, final boolean llllllllllllllIIllllIlIIIIIllIlI, final InventoryCrafting llllllllllllllIIllllIlIIIIIllIIl) {
        this.field_191888_F = llllllllllllllIIllllIlIIIIlIIIIl;
        this.field_191904_o = llllllllllllllIIllllIlIIIIlIIIll;
        this.field_191905_p = llllllllllllllIIllllIlIIIIlIIIlI;
        this.field_193961_o = llllllllllllllIIllllIlIIIIIllIIl;
        this.field_193964_s = llllllllllllllIIllllIlIIIIlIIIIl.player.func_192035_E();
        this.field_193966_v = llllllllllllllIIllllIlIIIIlIIIIl.player.inventory.func_194015_p();
        this.field_191913_x = this.field_193018_j.get(0);
        this.field_191913_x.func_191753_b(true);
        if (this.func_191878_b()) {
            this.func_193014_a(llllllllllllllIIllllIlIIIIIllIlI, llllllllllllllIIllllIlIIIIIllIIl);
        }
        Keyboard.enableRepeatEvents(true);
    }
    
    public boolean func_191859_a(final char llllllllllllllIIllllIIllIIlIlIIl, final int llllllllllllllIIllllIIllIIlIllII) {
        if (!this.func_191878_b() || this.field_191888_F.player.isSpectator()) {
            return false;
        }
        if (llllllllllllllIIllllIIllIIlIllII == 1 && !this.func_191880_f()) {
            this.func_193006_a(false);
            return true;
        }
        if (GameSettings.isKeyDown(this.field_191888_F.gameSettings.keyBindChat) && !this.field_193962_q.isFocused()) {
            this.field_193962_q.setFocused(true);
        }
        else if (this.field_193962_q.textboxKeyTyped(llllllllllllllIIllllIIllIIlIlIIl, llllllllllllllIIllllIIllIIlIllII)) {
            final String llllllllllllllIIllllIIllIIlIlIll = this.field_193962_q.getText().toLowerCase(Locale.ROOT);
            this.func_193716_a(llllllllllllllIIllllIIllIIlIlIll);
            if (!llllllllllllllIIllllIIllIIlIlIll.equals(this.field_193963_r)) {
                this.func_193003_g(false);
                this.field_193963_r = llllllllllllllIIllllIIllIIlIlIll;
            }
            return true;
        }
        return false;
    }
    
    static {
        field_191894_a = new ResourceLocation("textures/gui/recipe_book.png");
    }
    
    public void func_193948_e() {
        this.func_193949_f();
        if (this.func_191878_b()) {
            this.func_193003_g(false);
        }
    }
    
    private void func_193006_a(final boolean llllllllllllllIIllllIIlllllIllIl) {
        this.field_193964_s.func_192813_a(llllllllllllllIIllllIIlllllIllIl);
        if (!llllllllllllllIIllllIIlllllIllIl) {
            this.field_193022_s.func_194200_c();
        }
        this.func_193956_j();
    }
    
    public boolean func_191862_a(final int llllllllllllllIIllllIIllIlIllIlI, final int llllllllllllllIIllllIIllIlIlIIIl, final int llllllllllllllIIllllIIllIlIlIIII) {
        if (!this.func_191878_b() || this.field_191888_F.player.isSpectator()) {
            return false;
        }
        if (this.field_193022_s.func_194196_a(llllllllllllllIIllllIIllIlIllIlI, llllllllllllllIIllllIIllIlIlIIIl, llllllllllllllIIllllIIllIlIlIIII, (this.field_191904_o - 147) / 2 - this.field_191903_n, (this.field_191905_p - 166) / 2, 147, 166)) {
            final IRecipe llllllllllllllIIllllIIllIlIlIlll = this.field_193022_s.func_194193_a();
            final RecipeList llllllllllllllIIllllIIllIlIlIllI = this.field_193022_s.func_194199_b();
            if (llllllllllllllIIllllIIllIlIlIlll != null && llllllllllllllIIllllIIllIlIlIllI != null) {
                if (!llllllllllllllIIllllIIllIlIlIllI.func_194213_a(llllllllllllllIIllllIIllIlIlIlll) && this.field_191915_z.func_192686_c() == llllllllllllllIIllllIIllIlIlIlll) {
                    return false;
                }
                this.field_191915_z.func_192682_a();
                this.field_191888_F.playerController.func_194338_a(this.field_191888_F.player.openContainer.windowId, llllllllllllllIIllllIIllIlIlIlll, GuiScreen.isShiftKeyDown(), this.field_191888_F.player);
                if (!this.func_191880_f() && llllllllllllllIIllllIIllIlIlIIII == 0) {
                    this.func_193006_a(false);
                }
            }
            return true;
        }
        if (llllllllllllllIIllllIIllIlIlIIII != 0) {
            return false;
        }
        if (this.field_193962_q.mouseClicked(llllllllllllllIIllllIIllIlIllIlI, llllllllllllllIIllllIIllIlIlIIIl, llllllllllllllIIllllIIllIlIlIIII)) {
            return true;
        }
        if (this.field_193960_m.mousePressed(this.field_191888_F, llllllllllllllIIllllIIllIlIllIlI, llllllllllllllIIllllIIllIlIlIIIl)) {
            final boolean llllllllllllllIIllllIIllIlIlIlIl = !this.field_193964_s.func_192815_c();
            this.field_193964_s.func_192810_b(llllllllllllllIIllllIIllIlIlIlIl);
            this.field_193960_m.func_191753_b(llllllllllllllIIllllIIllIlIlIlIl);
            this.field_193960_m.playPressSound(this.field_191888_F.getSoundHandler());
            this.func_193956_j();
            this.func_193003_g(false);
            return true;
        }
        for (final GuiButtonRecipeTab llllllllllllllIIllllIIllIlIlIlII : this.field_193018_j) {
            if (llllllllllllllIIllllIIllIlIlIlII.mousePressed(this.field_191888_F, llllllllllllllIIllllIIllIlIllIlI, llllllllllllllIIllllIIllIlIlIIIl)) {
                if (this.field_191913_x != llllllllllllllIIllllIIllIlIlIlII) {
                    llllllllllllllIIllllIIllIlIlIlII.playPressSound(this.field_191888_F.getSoundHandler());
                    this.field_191913_x.func_191753_b(false);
                    this.field_191913_x = llllllllllllllIIllllIIllIlIlIlII;
                    this.field_191913_x.func_191753_b(true);
                    this.func_193003_g(true);
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void func_193001_a(final List<IRecipe> llllllllllllllIIllllIIllIIIIllII) {
        for (final IRecipe llllllllllllllIIllllIIllIIIIlllI : llllllllllllllIIllllIIllIIIIllII) {
            this.field_191888_F.player.func_193103_a(llllllllllllllIIllllIIllIIIIlllI);
        }
    }
    
    private boolean func_191880_f() {
        return this.field_191903_n == 86;
    }
    
    public void func_193951_a(final IRecipe llllllllllllllIIllllIIlIlllllIll, final List<Slot> llllllllllllllIIllllIIlIlllllIlI) {
        final ItemStack llllllllllllllIIllllIIlIlllllIIl = llllllllllllllIIllllIIlIlllllIll.getRecipeOutput();
        this.field_191915_z.func_192685_a(llllllllllllllIIllllIIlIlllllIll);
        this.field_191915_z.func_194187_a(Ingredient.func_193369_a(llllllllllllllIIllllIIlIlllllIIl), llllllllllllllIIllllIIlIlllllIlI.get(0).xDisplayPosition, llllllllllllllIIllllIIlIlllllIlI.get(0).yDisplayPosition);
        final int llllllllllllllIIllllIIlIlllllIII = this.field_193961_o.getWidth();
        final int llllllllllllllIIllllIIlIllllIlll = this.field_193961_o.getHeight();
        final int llllllllllllllIIllllIIlIllllIllI = (llllllllllllllIIllllIIlIlllllIll instanceof ShapedRecipes) ? ((ShapedRecipes)llllllllllllllIIllllIIlIlllllIll).func_192403_f() : llllllllllllllIIllllIIlIlllllIII;
        int llllllllllllllIIllllIIlIllllIlIl = 1;
        final Iterator<Ingredient> llllllllllllllIIllllIIlIllllIlII = llllllllllllllIIllllIIlIlllllIll.func_192400_c().iterator();
        for (int llllllllllllllIIllllIIlIllllIIll = 0; llllllllllllllIIllllIIlIllllIIll < llllllllllllllIIllllIIlIllllIlll; ++llllllllllllllIIllllIIlIllllIIll) {
            for (int llllllllllllllIIllllIIlIllllIIlI = 0; llllllllllllllIIllllIIlIllllIIlI < llllllllllllllIIllllIIlIllllIllI; ++llllllllllllllIIllllIIlIllllIIlI) {
                if (!llllllllllllllIIllllIIlIllllIlII.hasNext()) {
                    return;
                }
                final Ingredient llllllllllllllIIllllIIlIllllIIIl = llllllllllllllIIllllIIlIllllIlII.next();
                if (llllllllllllllIIllllIIlIllllIIIl != Ingredient.field_193370_a) {
                    final Slot llllllllllllllIIllllIIlIllllIIII = llllllllllllllIIllllIIlIlllllIlI.get(llllllllllllllIIllllIIlIllllIlIl);
                    this.field_191915_z.func_194187_a(llllllllllllllIIllllIIlIllllIIIl, llllllllllllllIIllllIIlIllllIIII.xDisplayPosition, llllllllllllllIIllllIIlIllllIIII.yDisplayPosition);
                }
                ++llllllllllllllIIllllIIlIllllIlIl;
            }
            if (llllllllllllllIIllllIIlIllllIllI < llllllllllllllIIllllIIlIlllllIII) {
                llllllllllllllIIllllIIlIllllIlIl += llllllllllllllIIllllIIlIlllllIII - llllllllllllllIIllllIIlIllllIllI;
            }
        }
    }
    
    public GuiRecipeBook() {
        this.field_191915_z = new GhostRecipe();
        this.field_193018_j = (List<GuiButtonRecipeTab>)Lists.newArrayList((Object[])new GuiButtonRecipeTab[] { new GuiButtonRecipeTab(0, CreativeTabs.SEARCH), new GuiButtonRecipeTab(0, CreativeTabs.TOOLS), new GuiButtonRecipeTab(0, CreativeTabs.BUILDING_BLOCKS), new GuiButtonRecipeTab(0, CreativeTabs.MISC), new GuiButtonRecipeTab(0, CreativeTabs.REDSTONE) });
        this.field_193963_r = "";
        this.field_193022_s = new RecipeBookPage();
        this.field_193965_u = new RecipeItemHelper();
    }
    
    public void func_191874_a(@Nullable final Slot llllllllllllllIIllllIIlllllIIlll) {
        if (llllllllllllllIIllllIIlllllIIlll != null && llllllllllllllIIllllIIlllllIIlll.slotNumber <= 9) {
            this.field_191915_z.func_192682_a();
            if (this.func_191878_b()) {
                this.func_193942_g();
            }
        }
    }
    
    private void func_193015_d(final int llllllllllllllIIllllIIllIllllIIl, final int llllllllllllllIIllllIIlllIIIIIlI, final int llllllllllllllIIllllIIllIlllIlll, final int llllllllllllllIIllllIIlllIIIIIII) {
        ItemStack llllllllllllllIIllllIIllIlllllll = null;
        for (int llllllllllllllIIllllIIllIllllllI = 0; llllllllllllllIIllllIIllIllllllI < this.field_191915_z.func_192684_b(); ++llllllllllllllIIllllIIllIllllllI) {
            final GhostRecipe.GhostIngredient llllllllllllllIIllllIIllIlllllIl = this.field_191915_z.func_192681_a(llllllllllllllIIllllIIllIllllllI);
            final int llllllllllllllIIllllIIllIlllllII = llllllllllllllIIllllIIllIlllllIl.func_193713_b() + llllllllllllllIIllllIIllIllllIIl;
            final int llllllllllllllIIllllIIllIllllIll = llllllllllllllIIllllIIllIlllllIl.func_193712_c() + llllllllllllllIIllllIIlllIIIIIlI;
            if (llllllllllllllIIllllIIllIlllIlll >= llllllllllllllIIllllIIllIlllllII && llllllllllllllIIllllIIlllIIIIIII >= llllllllllllllIIllllIIllIllllIll && llllllllllllllIIllllIIllIlllIlll < llllllllllllllIIllllIIllIlllllII + 16 && llllllllllllllIIllllIIlllIIIIIII < llllllllllllllIIllllIIllIllllIll + 16) {
                llllllllllllllIIllllIIllIlllllll = llllllllllllllIIllllIIllIlllllIl.func_194184_c();
            }
        }
        if (llllllllllllllIIllllIIllIlllllll != null && this.field_191888_F.currentScreen != null) {
            this.field_191888_F.currentScreen.drawHoveringText(this.field_191888_F.currentScreen.func_191927_a(llllllllllllllIIllllIIllIlllllll), llllllllllllllIIllllIIllIlllIlll, llllllllllllllIIllllIIlllIIIIIII);
        }
    }
    
    public void func_191871_c() {
        Keyboard.enableRepeatEvents(false);
    }
    
    private void func_193956_j() {
        if (this.field_191888_F.getConnection() != null) {
            this.field_191888_F.getConnection().sendPacket(new CPacketRecipeInfo(this.func_191878_b(), this.field_193964_s.func_192815_c()));
        }
    }
    
    public int func_193011_a(final boolean llllllllllllllIIllllIlIIIIIIIIlI, final int llllllllllllllIIllllIIlllllllIll, final int llllllllllllllIIllllIIlllllllIlI) {
        int llllllllllllllIIllllIIlllllllllI = 0;
        if (this.func_191878_b() && !llllllllllllllIIllllIlIIIIIIIIlI) {
            final int llllllllllllllIIllllIIllllllllll = 177 + (llllllllllllllIIllllIIlllllllIll - llllllllllllllIIllllIIlllllllIlI - 200) / 2;
        }
        else {
            llllllllllllllIIllllIIlllllllllI = (llllllllllllllIIllllIIlllllllIll - llllllllllllllIIllllIIlllllllIlI) / 2;
        }
        return llllllllllllllIIllllIIlllllllllI;
    }
    
    public boolean func_191878_b() {
        return this.field_193964_s.func_192812_b();
    }
    
    public void func_191864_a(final int llllllllllllllIIllllIIllIllIlIlI, final int llllllllllllllIIllllIIllIllIIlII, final boolean llllllllllllllIIllllIIllIllIlIII, final float llllllllllllllIIllllIIllIllIIlll) {
        this.field_191915_z.func_194188_a(this.field_191888_F, llllllllllllllIIllllIIllIllIlIlI, llllllllllllllIIllllIIllIllIIlII, llllllllllllllIIllllIIllIllIlIII, llllllllllllllIIllllIIllIllIIlll);
    }
}
