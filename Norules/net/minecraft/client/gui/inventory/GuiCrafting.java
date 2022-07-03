package net.minecraft.client.gui.inventory;

import net.minecraft.util.*;
import net.minecraft.client.gui.recipebook.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import java.io.*;
import net.minecraft.client.gui.*;
import net.minecraft.inventory.*;
import net.minecraft.client.resources.*;

public class GuiCrafting extends GuiContainer implements IRecipeShownListener
{
    private /* synthetic */ boolean field_193112_y;
    private /* synthetic */ GuiButtonImage field_192049_w;
    private static final /* synthetic */ ResourceLocation CRAFTING_TABLE_GUI_TEXTURES;
    private final /* synthetic */ GuiRecipeBook field_192050_x;
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllIllIllllIIIIIIIll, final int lllllllllllllllIllIllllIIIIIIIlI, final int lllllllllllllllIllIllllIIIIIIIIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiCrafting.CRAFTING_TABLE_GUI_TEXTURES);
        final int lllllllllllllllIllIllllIIIIIIIII = this.guiLeft;
        final int lllllllllllllllIllIlllIlllllllll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllIllIllllIIIIIIIII, lllllllllllllllIllIlllIlllllllll, 0, 0, this.xSize, this.ySize);
    }
    
    public GuiCrafting(final InventoryPlayer lllllllllllllllIllIllllIIIlIllII, final World lllllllllllllllIllIllllIIIlIlIll) {
        this(lllllllllllllllIllIllllIIIlIllII, lllllllllllllllIllIllllIIIlIlIll, BlockPos.ORIGIN);
    }
    
    @Override
    protected void handleMouseClick(final Slot lllllllllllllllIllIlllIllIllIIll, final int lllllllllllllllIllIlllIllIllIIlI, final int lllllllllllllllIllIlllIllIlIllII, final ClickType lllllllllllllllIllIlllIllIllIIII) {
        super.handleMouseClick(lllllllllllllllIllIlllIllIllIIll, lllllllllllllllIllIlllIllIllIIlI, lllllllllllllllIllIlllIllIlIllII, lllllllllllllllIllIlllIllIllIIII);
        this.field_192050_x.func_191874_a(lllllllllllllllIllIlllIllIllIIll);
    }
    
    @Override
    protected boolean isPointInRegion(final int lllllllllllllllIllIlllIllllIllII, final int lllllllllllllllIllIlllIllllIlIll, final int lllllllllllllllIllIlllIlllllIIIl, final int lllllllllllllllIllIlllIlllllIIII, final int lllllllllllllllIllIlllIllllIllll, final int lllllllllllllllIllIlllIllllIIlll) {
        return (!this.field_193112_y || !this.field_192050_x.func_191878_b()) && super.isPointInRegion(lllllllllllllllIllIlllIllllIllII, lllllllllllllllIllIlllIllllIlIll, lllllllllllllllIllIlllIlllllIIIl, lllllllllllllllIllIlllIlllllIIII, lllllllllllllllIllIlllIllllIllll, lllllllllllllllIllIlllIllllIIlll);
    }
    
    @Override
    public GuiRecipeBook func_194310_f() {
        return this.field_192050_x;
    }
    
    @Override
    public void onGuiClosed() {
        this.field_192050_x.func_191871_c();
        super.onGuiClosed();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllIllIllllIIIIlIIll, final int lllllllllllllllIllIllllIIIIlIIlI, final float lllllllllllllllIllIllllIIIIIllIl) {
        this.drawDefaultBackground();
        if (this.field_192050_x.func_191878_b() && this.field_193112_y) {
            this.drawGuiContainerBackgroundLayer(lllllllllllllllIllIllllIIIIIllIl, lllllllllllllllIllIllllIIIIlIIll, lllllllllllllllIllIllllIIIIlIIlI);
            this.field_192050_x.func_191861_a(lllllllllllllllIllIllllIIIIlIIll, lllllllllllllllIllIllllIIIIlIIlI, lllllllllllllllIllIllllIIIIIllIl);
        }
        else {
            this.field_192050_x.func_191861_a(lllllllllllllllIllIllllIIIIlIIll, lllllllllllllllIllIllllIIIIlIIlI, lllllllllllllllIllIllllIIIIIllIl);
            super.drawScreen(lllllllllllllllIllIllllIIIIlIIll, lllllllllllllllIllIllllIIIIlIIlI, lllllllllllllllIllIllllIIIIIllIl);
            this.field_192050_x.func_191864_a(this.guiLeft, this.guiTop, true, lllllllllllllllIllIllllIIIIIllIl);
        }
        this.func_191948_b(lllllllllllllllIllIllllIIIIlIIll, lllllllllllllllIllIllllIIIIlIIlI);
        this.field_192050_x.func_191876_c(this.guiLeft, this.guiTop, lllllllllllllllIllIllllIIIIlIIll, lllllllllllllllIllIllllIIIIlIIlI);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllllIllIlllIllIlllllI, final int lllllllllllllllIllIlllIllIlllIlI) throws IOException {
        if (!this.field_192050_x.func_191859_a(lllllllllllllllIllIlllIllIlllllI, lllllllllllllllIllIlllIllIlllIlI)) {
            super.keyTyped(lllllllllllllllIllIlllIllIlllllI, lllllllllllllllIllIlllIllIlllIlI);
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.field_193112_y = (this.width < 379);
        this.field_192050_x.func_194303_a(this.width, this.height, this.mc, this.field_193112_y, ((ContainerWorkbench)this.inventorySlots).craftMatrix);
        this.guiLeft = this.field_192050_x.func_193011_a(this.field_193112_y, this.width, this.xSize);
        this.field_192049_w = new GuiButtonImage(10, this.guiLeft + 5, this.height / 2 - 49, 20, 18, 0, 168, 19, GuiCrafting.CRAFTING_TABLE_GUI_TEXTURES);
        this.buttonList.add(this.field_192049_w);
    }
    
    @Override
    public void func_192043_J_() {
        this.field_192050_x.func_193948_e();
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllllIllIlllIlllIIIIll) throws IOException {
        if (lllllllllllllllIllIlllIlllIIIIll.id == 10) {
            this.field_192050_x.func_193014_a(this.field_193112_y, ((ContainerWorkbench)this.inventorySlots).craftMatrix);
            this.field_192050_x.func_191866_a();
            this.guiLeft = this.field_192050_x.func_193011_a(this.field_193112_y, this.width, this.xSize);
            this.field_192049_w.func_191746_c(this.guiLeft + 5, this.height / 2 - 49);
        }
    }
    
    static {
        CRAFTING_TABLE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/crafting_table.png");
    }
    
    public GuiCrafting(final InventoryPlayer lllllllllllllllIllIllllIIIlIIIIl, final World lllllllllllllllIllIllllIIIlIIIII, final BlockPos lllllllllllllllIllIllllIIIIlllll) {
        super(new ContainerWorkbench(lllllllllllllllIllIllllIIIlIIIIl, lllllllllllllllIllIllllIIIlIIIII, lllllllllllllllIllIllllIIIIlllll));
        this.field_192050_x = new GuiRecipeBook();
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllIllIllllIIIIIlIlI, final int lllllllllllllllIllIllllIIIIIlIIl) {
        this.fontRendererObj.drawString(I18n.format("container.crafting", new Object[0]), 28.0, 6.0, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        this.field_192050_x.func_193957_d();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllllIllIlllIllllIIIIl, final int lllllllllllllllIllIlllIllllIIIII, final int lllllllllllllllIllIlllIlllIllIll) throws IOException {
        if (!this.field_192050_x.func_191862_a(lllllllllllllllIllIlllIllllIIIIl, lllllllllllllllIllIlllIllllIIIII, lllllllllllllllIllIlllIlllIllIll) && (!this.field_193112_y || !this.field_192050_x.func_191878_b())) {
            super.mouseClicked(lllllllllllllllIllIlllIllllIIIIl, lllllllllllllllIllIlllIllllIIIII, lllllllllllllllIllIlllIlllIllIll);
        }
    }
    
    @Override
    protected boolean func_193983_c(final int lllllllllllllllIllIlllIlllIIllIl, final int lllllllllllllllIllIlllIlllIIllII, final int lllllllllllllllIllIlllIlllIIlIll, final int lllllllllllllllIllIlllIlllIIlIlI) {
        final boolean lllllllllllllllIllIlllIlllIIllll = lllllllllllllllIllIlllIlllIIllIl < lllllllllllllllIllIlllIlllIIlIll || lllllllllllllllIllIlllIlllIIllII < lllllllllllllllIllIlllIlllIIlIlI || lllllllllllllllIllIlllIlllIIllIl >= lllllllllllllllIllIlllIlllIIlIll + this.xSize || lllllllllllllllIllIlllIlllIIllII >= lllllllllllllllIllIlllIlllIIlIlI + this.ySize;
        return this.field_192050_x.func_193955_c(lllllllllllllllIllIlllIlllIIllIl, lllllllllllllllIllIlllIlllIIllII, this.guiLeft, this.guiTop, this.xSize, this.ySize) && lllllllllllllllIllIlllIlllIIllll;
    }
}
