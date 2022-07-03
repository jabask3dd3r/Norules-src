package net.minecraft.client.gui.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;

public class GuiDispenser extends GuiContainer
{
    private final /* synthetic */ InventoryPlayer playerInventory;
    private static final /* synthetic */ ResourceLocation DISPENSER_GUI_TEXTURES;
    public /* synthetic */ IInventory dispenserInventory;
    
    public GuiDispenser(final InventoryPlayer lllllllllllllIIIllIllIlIIIIllIll, final IInventory lllllllllllllIIIllIllIlIIIIlIlII) {
        super(new ContainerDispenser(lllllllllllllIIIllIllIlIIIIllIll, lllllllllllllIIIllIllIlIIIIlIlII));
        this.playerInventory = lllllllllllllIIIllIllIlIIIIllIll;
        this.dispenserInventory = lllllllllllllIIIllIllIlIIIIlIlII;
    }
    
    static {
        DISPENSER_GUI_TEXTURES = new ResourceLocation("textures/gui/container/dispenser.png");
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIIIllIllIIlllllIlIl, final int lllllllllllllIIIllIllIIlllllIIll, final int lllllllllllllIIIllIllIIlllllIIIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiDispenser.DISPENSER_GUI_TEXTURES);
        final int lllllllllllllIIIllIllIIllllIllll = (this.width - this.xSize) / 2;
        final int lllllllllllllIIIllIllIIllllIllIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllIIIllIllIIllllIllll, lllllllllllllIIIllIllIIllllIllIl, 0, 0, this.xSize, this.ySize);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIIIllIllIlIIIIIIIIl, final int lllllllllllllIIIllIllIlIIIIIIIII) {
        final String lllllllllllllIIIllIllIIlllllllll = this.dispenserInventory.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(lllllllllllllIIIllIllIIlllllllll, this.xSize / 2 - this.fontRendererObj.getStringWidth(lllllllllllllIIIllIllIIlllllllll) / 2, 6.0, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIllIllIlIIIIIIlll, final int lllllllllllllIIIllIllIlIIIIIlIlI, final float lllllllllllllIIIllIllIlIIIIIlIIl) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllIIIllIllIlIIIIIIlll, lllllllllllllIIIllIllIlIIIIIlIlI, lllllllllllllIIIllIllIlIIIIIlIIl);
        this.func_191948_b(lllllllllllllIIIllIllIlIIIIIIlll, lllllllllllllIIIllIllIlIIIIIlIlI);
    }
}
