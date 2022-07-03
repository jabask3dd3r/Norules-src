package net.minecraft.client.gui.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.tileentity.*;

public class GuiFurnace extends GuiContainer
{
    private final /* synthetic */ IInventory tileFurnace;
    private final /* synthetic */ InventoryPlayer playerInventory;
    private static final /* synthetic */ ResourceLocation FURNACE_GUI_TEXTURES;
    
    public GuiFurnace(final InventoryPlayer lllllllllllllIIllIIIIIIIlIlIIllI, final IInventory lllllllllllllIIllIIIIIIIlIlIIlIl) {
        super(new ContainerFurnace(lllllllllllllIIllIIIIIIIlIlIIllI, lllllllllllllIIllIIIIIIIlIlIIlIl));
        this.playerInventory = lllllllllllllIIllIIIIIIIlIlIIllI;
        this.tileFurnace = lllllllllllllIIllIIIIIIIlIlIIlIl;
    }
    
    static {
        FURNACE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/furnace.png");
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIIllIIIIIIIlIIIlIll, final int lllllllllllllIIllIIIIIIIlIIIlIlI, final int lllllllllllllIIllIIIIIIIlIIIlIIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiFurnace.FURNACE_GUI_TEXTURES);
        final int lllllllllllllIIllIIIIIIIlIIIlIII = (this.width - this.xSize) / 2;
        final int lllllllllllllIIllIIIIIIIlIIIIlll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllIIllIIIIIIIlIIIlIII, lllllllllllllIIllIIIIIIIlIIIIlll, 0, 0, this.xSize, this.ySize);
        if (TileEntityFurnace.isBurning(this.tileFurnace)) {
            final int lllllllllllllIIllIIIIIIIlIIIIllI = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(lllllllllllllIIllIIIIIIIlIIIlIII + 56, lllllllllllllIIllIIIIIIIlIIIIlll + 36 + 12 - lllllllllllllIIllIIIIIIIlIIIIllI, 176, 12 - lllllllllllllIIllIIIIIIIlIIIIllI, 14, lllllllllllllIIllIIIIIIIlIIIIllI + 1);
        }
        final int lllllllllllllIIllIIIIIIIlIIIIlIl = this.getCookProgressScaled(24);
        this.drawTexturedModalRect(lllllllllllllIIllIIIIIIIlIIIlIII + 79, lllllllllllllIIllIIIIIIIlIIIIlll + 34, 176, 14, lllllllllllllIIllIIIIIIIlIIIIlIl + 1, 16);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIllIIIIIIIlIIlllll, final int lllllllllllllIIllIIIIIIIlIIllllI, final float lllllllllllllIIllIIIIIIIlIIlllIl) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllIIllIIIIIIIlIIlllll, lllllllllllllIIllIIIIIIIlIIllllI, lllllllllllllIIllIIIIIIIlIIlllIl);
        this.func_191948_b(lllllllllllllIIllIIIIIIIlIIlllll, lllllllllllllIIllIIIIIIIlIIllllI);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIIllIIIIIIIlIIlIlIl, final int lllllllllllllIIllIIIIIIIlIIlIlII) {
        final String lllllllllllllIIllIIIIIIIlIIlIIll = this.tileFurnace.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(lllllllllllllIIllIIIIIIIlIIlIIll, this.xSize / 2 - this.fontRendererObj.getStringWidth(lllllllllllllIIllIIIIIIIlIIlIIll) / 2, 6.0, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    private int getBurnLeftScaled(final int lllllllllllllIIllIIIIIIIIllIllIl) {
        int lllllllllllllIIllIIIIIIIIllIllll = this.tileFurnace.getField(1);
        if (lllllllllllllIIllIIIIIIIIllIllll == 0) {
            lllllllllllllIIllIIIIIIIIllIllll = 200;
        }
        return this.tileFurnace.getField(0) * lllllllllllllIIllIIIIIIIIllIllIl / lllllllllllllIIllIIIIIIIIllIllll;
    }
    
    private int getCookProgressScaled(final int lllllllllllllIIllIIIIIIIIlllIlll) {
        final int lllllllllllllIIllIIIIIIIIllllIlI = this.tileFurnace.getField(2);
        final int lllllllllllllIIllIIIIIIIIllllIIl = this.tileFurnace.getField(3);
        return (lllllllllllllIIllIIIIIIIIllllIIl != 0 && lllllllllllllIIllIIIIIIIIllllIlI != 0) ? (lllllllllllllIIllIIIIIIIIllllIlI * lllllllllllllIIllIIIIIIIIlllIlll / lllllllllllllIIllIIIIIIIIllllIIl) : 0;
    }
}
