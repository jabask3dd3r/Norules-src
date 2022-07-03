package net.minecraft.client.gui.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.inventory.*;

public class GuiBrewingStand extends GuiContainer
{
    private final /* synthetic */ InventoryPlayer playerInventory;
    private final /* synthetic */ IInventory tileBrewingStand;
    private static final /* synthetic */ ResourceLocation BREWING_STAND_GUI_TEXTURES;
    private static final /* synthetic */ int[] BUBBLELENGTHS;
    
    static {
        BREWING_STAND_GUI_TEXTURES = new ResourceLocation("textures/gui/container/brewing_stand.png");
        BUBBLELENGTHS = new int[] { 29, 24, 20, 16, 11, 6, 0 };
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIIllllIIlIlllIIIlII, final int lllllllllllllIIllllIIlIlllIIIIll, final int lllllllllllllIIllllIIlIlllIIIIlI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiBrewingStand.BREWING_STAND_GUI_TEXTURES);
        final int lllllllllllllIIllllIIlIlllIIIIIl = (this.width - this.xSize) / 2;
        final int lllllllllllllIIllllIIlIlllIIIIII = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllIIllllIIlIlllIIIIIl, lllllllllllllIIllllIIlIlllIIIIII, 0, 0, this.xSize, this.ySize);
        final int lllllllllllllIIllllIIlIllIllllll = this.tileBrewingStand.getField(1);
        final int lllllllllllllIIllllIIlIllIlllllI = MathHelper.clamp((18 * lllllllllllllIIllllIIlIllIllllll + 20 - 1) / 20, 0, 18);
        if (lllllllllllllIIllllIIlIllIlllllI > 0) {
            this.drawTexturedModalRect(lllllllllllllIIllllIIlIlllIIIIIl + 60, lllllllllllllIIllllIIlIlllIIIIII + 44, 176, 29, lllllllllllllIIllllIIlIllIlllllI, 4);
        }
        final int lllllllllllllIIllllIIlIllIllllIl = this.tileBrewingStand.getField(0);
        if (lllllllllllllIIllllIIlIllIllllIl > 0) {
            int lllllllllllllIIllllIIlIllIllllII = (int)(28.0f * (1.0f - lllllllllllllIIllllIIlIllIllllIl / 400.0f));
            if (lllllllllllllIIllllIIlIllIllllII > 0) {
                this.drawTexturedModalRect(lllllllllllllIIllllIIlIlllIIIIIl + 97, lllllllllllllIIllllIIlIlllIIIIII + 16, 176, 0, 9, lllllllllllllIIllllIIlIllIllllII);
            }
            lllllllllllllIIllllIIlIllIllllII = GuiBrewingStand.BUBBLELENGTHS[lllllllllllllIIllllIIlIllIllllIl / 2 % 7];
            if (lllllllllllllIIllllIIlIllIllllII > 0) {
                this.drawTexturedModalRect(lllllllllllllIIllllIIlIlllIIIIIl + 63, lllllllllllllIIllllIIlIlllIIIIII + 14 + 29 - lllllllllllllIIllllIIlIllIllllII, 185, 29 - lllllllllllllIIllllIIlIllIllllII, 12, lllllllllllllIIllllIIlIllIllllII);
            }
        }
    }
    
    public GuiBrewingStand(final InventoryPlayer lllllllllllllIIllllIIlIllllIIlIl, final IInventory lllllllllllllIIllllIIlIllllIIIIl) {
        super(new ContainerBrewingStand(lllllllllllllIIllllIIlIllllIIlIl, lllllllllllllIIllllIIlIllllIIIIl));
        this.playerInventory = lllllllllllllIIllllIIlIllllIIlIl;
        this.tileBrewingStand = lllllllllllllIIllllIIlIllllIIIIl;
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIllllIIlIlllIlIlll, final int lllllllllllllIIllllIIlIlllIllIlI, final float lllllllllllllIIllllIIlIlllIlIlIl) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllIIllllIIlIlllIlIlll, lllllllllllllIIllllIIlIlllIllIlI, lllllllllllllIIllllIIlIlllIlIlIl);
        this.func_191948_b(lllllllllllllIIllllIIlIlllIlIlll, lllllllllllllIIllllIIlIlllIllIlI);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIIllllIIlIlllIlIIIl, final int lllllllllllllIIllllIIlIlllIlIIII) {
        final String lllllllllllllIIllllIIlIlllIIllll = this.tileBrewingStand.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(lllllllllllllIIllllIIlIlllIIllll, this.xSize / 2 - this.fontRendererObj.getStringWidth(lllllllllllllIIllllIIlIlllIIllll) / 2, 6.0, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
}
