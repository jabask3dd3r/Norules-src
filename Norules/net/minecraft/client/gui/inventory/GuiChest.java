package net.minecraft.client.gui.inventory;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class GuiChest extends GuiContainer
{
    private final /* synthetic */ IInventory upperChestInventory;
    private final /* synthetic */ IInventory lowerChestInventory;
    private static final /* synthetic */ ResourceLocation CHEST_GUI_TEXTURE;
    private final /* synthetic */ int inventoryRows;
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllllIIllIIIlIlIlIll, final int lllllllllllllllllIIllIIIlIlIlIlI, final int lllllllllllllllllIIllIIIlIlIlIIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiChest.CHEST_GUI_TEXTURE);
        final int lllllllllllllllllIIllIIIlIlIlIII = (this.width - this.xSize) / 2;
        final int lllllllllllllllllIIllIIIlIlIIlll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllllIIllIIIlIlIlIII, lllllllllllllllllIIllIIIlIlIIlll, 0, 0, this.xSize, this.inventoryRows * 18 + 17);
        this.drawTexturedModalRect(lllllllllllllllllIIllIIIlIlIlIII, lllllllllllllllllIIllIIIlIlIIlll + this.inventoryRows * 18 + 17, 0, 126, this.xSize, 96);
    }
    
    public GuiChest(final IInventory lllllllllllllllllIIllIIIllIIlIIl, final IInventory lllllllllllllllllIIllIIIllIIIIll) {
        super(new ContainerChest(lllllllllllllllllIIllIIIllIIlIIl, lllllllllllllllllIIllIIIllIIIIll, Minecraft.getMinecraft().player));
        this.upperChestInventory = lllllllllllllllllIIllIIIllIIlIIl;
        this.lowerChestInventory = lllllllllllllllllIIllIIIllIIIIll;
        this.allowUserInput = false;
        final int lllllllllllllllllIIllIIIllIIIlll = 222;
        final int lllllllllllllllllIIllIIIllIIIllI = 114;
        this.inventoryRows = lllllllllllllllllIIllIIIllIIIIll.getSizeInventory() / 9;
        this.ySize = 114 + this.inventoryRows * 18;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllllIIllIIIlIllIIlI, final int lllllllllllllllllIIllIIIlIllIIIl) {
        this.fontRendererObj.drawString(this.lowerChestInventory.getDisplayName().getUnformattedText(), 8.0, 6.0, 4210752);
        this.fontRendererObj.drawString(this.upperChestInventory.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    static {
        CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllIIllIIIlIllIlll, final int lllllllllllllllllIIllIIIlIllIllI, final float lllllllllllllllllIIllIIIlIllIlIl) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllllllIIllIIIlIllIlll, lllllllllllllllllIIllIIIlIllIllI, lllllllllllllllllIIllIIIlIllIlIl);
        this.func_191948_b(lllllllllllllllllIIllIIIlIllIlll, lllllllllllllllllIIllIIIlIllIllI);
    }
}
