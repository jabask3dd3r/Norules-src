package net.minecraft.client.gui.inventory;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class GuiShulkerBox extends GuiContainer
{
    private final /* synthetic */ IInventory field_190779_v;
    private static final /* synthetic */ ResourceLocation field_190778_u;
    private final /* synthetic */ InventoryPlayer field_190780_w;
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllllIllIIIllllIIlll, final int lllllllllllllllllIllIIIllllIIllI) {
        this.fontRendererObj.drawString(this.field_190779_v.getDisplayName().getUnformattedText(), 8.0, 6.0, 4210752);
        this.fontRendererObj.drawString(this.field_190780_w.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllIllIIIllllIllII, final int lllllllllllllllllIllIIIllllIllll, final float lllllllllllllllllIllIIIllllIlIlI) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllllllIllIIIllllIllII, lllllllllllllllllIllIIIllllIllll, lllllllllllllllllIllIIIllllIlIlI);
        this.func_191948_b(lllllllllllllllllIllIIIllllIllII, lllllllllllllllllIllIIIllllIllll);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllllIllIIIllllIIIII, final int lllllllllllllllllIllIIIlllIlllll, final int lllllllllllllllllIllIIIlllIllllI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiShulkerBox.field_190778_u);
        final int lllllllllllllllllIllIIIlllIlllIl = (this.width - this.xSize) / 2;
        final int lllllllllllllllllIllIIIlllIlllII = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllllIllIIIlllIlllIl, lllllllllllllllllIllIIIlllIlllII, 0, 0, this.xSize, this.ySize);
    }
    
    static {
        field_190778_u = new ResourceLocation("textures/gui/container/shulker_box.png");
    }
    
    public GuiShulkerBox(final InventoryPlayer lllllllllllllllllIllIIIllllllIlI, final IInventory lllllllllllllllllIllIIIlllllIllI) {
        super(new ContainerShulkerBox(lllllllllllllllllIllIIIllllllIlI, lllllllllllllllllIllIIIlllllIllI, Minecraft.getMinecraft().player));
        this.field_190780_w = lllllllllllllllllIllIIIllllllIlI;
        this.field_190779_v = lllllllllllllllllIllIIIlllllIllI;
        ++this.ySize;
    }
}
