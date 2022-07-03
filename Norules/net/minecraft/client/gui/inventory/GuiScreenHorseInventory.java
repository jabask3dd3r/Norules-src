package net.minecraft.client.gui.inventory;

import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;

public class GuiScreenHorseInventory extends GuiContainer
{
    private /* synthetic */ float mousePosY;
    private final /* synthetic */ IInventory horseInventory;
    private final /* synthetic */ IInventory playerInventory;
    private final /* synthetic */ AbstractHorse horseEntity;
    private /* synthetic */ float mousePosx;
    private static final /* synthetic */ ResourceLocation HORSE_GUI_TEXTURES;
    
    public GuiScreenHorseInventory(final IInventory lllllllllllllllllllllllIllIlIIlI, final IInventory lllllllllllllllllllllllIllIlIIIl, final AbstractHorse lllllllllllllllllllllllIllIlIlII) {
        super(new ContainerHorseInventory(lllllllllllllllllllllllIllIlIIlI, lllllllllllllllllllllllIllIlIIIl, lllllllllllllllllllllllIllIlIlII, Minecraft.getMinecraft().player));
        this.playerInventory = lllllllllllllllllllllllIllIlIIlI;
        this.horseInventory = lllllllllllllllllllllllIllIlIIIl;
        this.horseEntity = lllllllllllllllllllllllIllIlIlII;
        this.allowUserInput = false;
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllllllllllllIllIIIlIl, final int lllllllllllllllllllllllIllIIIlII, final int lllllllllllllllllllllllIllIIIIll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiScreenHorseInventory.HORSE_GUI_TEXTURES);
        final int lllllllllllllllllllllllIllIIIIlI = (this.width - this.xSize) / 2;
        final int lllllllllllllllllllllllIllIIIIIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllllllllllllIllIIIIlI, lllllllllllllllllllllllIllIIIIIl, 0, 0, this.xSize, this.ySize);
        if (this.horseEntity instanceof AbstractChestHorse) {
            final AbstractChestHorse lllllllllllllllllllllllIllIIIIII = (AbstractChestHorse)this.horseEntity;
            if (lllllllllllllllllllllllIllIIIIII.func_190695_dh()) {
                this.drawTexturedModalRect(lllllllllllllllllllllllIllIIIIlI + 79, lllllllllllllllllllllllIllIIIIIl + 17, 0, this.ySize, lllllllllllllllllllllllIllIIIIII.func_190696_dl() * 18, 54);
            }
        }
        if (this.horseEntity.func_190685_dA()) {
            this.drawTexturedModalRect(lllllllllllllllllllllllIllIIIIlI + 7, lllllllllllllllllllllllIllIIIIIl + 35 - 18, 18, this.ySize + 54, 18, 18);
        }
        if (this.horseEntity.func_190677_dK()) {
            if (this.horseEntity instanceof EntityLlama) {
                this.drawTexturedModalRect(lllllllllllllllllllllllIllIIIIlI + 7, lllllllllllllllllllllllIllIIIIIl + 35, 36, this.ySize + 54, 18, 18);
            }
            else {
                this.drawTexturedModalRect(lllllllllllllllllllllllIllIIIIlI + 7, lllllllllllllllllllllllIllIIIIIl + 35, 0, this.ySize + 54, 18, 18);
            }
        }
        GuiInventory.drawEntityOnScreen((float)(lllllllllllllllllllllllIllIIIIlI + 51), lllllllllllllllllllllllIllIIIIIl + 60, 17, lllllllllllllllllllllllIllIIIIlI + 51 - this.mousePosx, lllllllllllllllllllllllIllIIIIIl + 75 - 50 - this.mousePosY, this.horseEntity);
    }
    
    @Override
    public void drawScreen(final int lllllllllllllllllllllllIlIllIIlI, final int lllllllllllllllllllllllIlIllIlIl, final float lllllllllllllllllllllllIlIllIIII) {
        this.drawDefaultBackground();
        this.mousePosx = (float)lllllllllllllllllllllllIlIllIIlI;
        this.mousePosY = (float)lllllllllllllllllllllllIlIllIlIl;
        super.drawScreen(lllllllllllllllllllllllIlIllIIlI, lllllllllllllllllllllllIlIllIlIl, lllllllllllllllllllllllIlIllIIII);
        this.func_191948_b(lllllllllllllllllllllllIlIllIIlI, lllllllllllllllllllllllIlIllIlIl);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllllllllllllIllIIllIl, final int lllllllllllllllllllllllIllIIllII) {
        this.fontRendererObj.drawString(this.horseInventory.getDisplayName().getUnformattedText(), 8.0, 6.0, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    static {
        HORSE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/horse.png");
    }
}
