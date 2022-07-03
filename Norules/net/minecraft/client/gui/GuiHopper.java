package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;

public class GuiHopper extends GuiContainer
{
    private final /* synthetic */ IInventory hopperInventory;
    private final /* synthetic */ IInventory playerInventory;
    private static final /* synthetic */ ResourceLocation HOPPER_GUI_TEXTURE;
    
    static {
        HOPPER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/hopper.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIlllIlIIIIIllIIllll, final int lllllllllllllIlllIlIIIIIllIIlllI) {
        this.fontRendererObj.drawString(this.hopperInventory.getDisplayName().getUnformattedText(), 8.0, 6.0, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    public GuiHopper(final InventoryPlayer lllllllllllllIlllIlIIIIIllIlllll, final IInventory lllllllllllllIlllIlIIIIIllIllllI) {
        super(new ContainerHopper(lllllllllllllIlllIlIIIIIllIlllll, lllllllllllllIlllIlIIIIIllIllllI, Minecraft.getMinecraft().player));
        this.playerInventory = lllllllllllllIlllIlIIIIIllIlllll;
        this.hopperInventory = lllllllllllllIlllIlIIIIIllIllllI;
        this.allowUserInput = false;
        this.ySize = 133;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIlllIlIIIIIllIIlIII, final int lllllllllllllIlllIlIIIIIllIIIlll, final int lllllllllllllIlllIlIIIIIllIIIllI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiHopper.HOPPER_GUI_TEXTURE);
        final int lllllllllllllIlllIlIIIIIllIIIlIl = (this.width - this.xSize) / 2;
        final int lllllllllllllIlllIlIIIIIllIIIlII = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllIlllIlIIIIIllIIIlIl, lllllllllllllIlllIlIIIIIllIIIlII, 0, 0, this.xSize, this.ySize);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlllIlIIIIIllIllIII, final int lllllllllllllIlllIlIIIIIllIlIIll, final float lllllllllllllIlllIlIIIIIllIlIIlI) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllIlllIlIIIIIllIllIII, lllllllllllllIlllIlIIIIIllIlIIll, lllllllllllllIlllIlIIIIIllIlIIlI);
        this.func_191948_b(lllllllllllllIlllIlIIIIIllIllIII, lllllllllllllIlllIlIIIIIllIlIIll);
    }
}
