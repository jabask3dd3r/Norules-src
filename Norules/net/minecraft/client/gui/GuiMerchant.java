package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.*;
import org.apache.logging.log4j.*;
import net.minecraft.village.*;
import net.minecraft.client.resources.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.item.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import java.io.*;
import net.minecraft.client.*;

public class GuiMerchant extends GuiContainer
{
    private static final /* synthetic */ ResourceLocation MERCHANT_GUI_TEXTURE;
    private final /* synthetic */ ITextComponent chatComponent;
    private /* synthetic */ MerchantButton nextButton;
    private final /* synthetic */ IMerchant merchant;
    private /* synthetic */ MerchantButton previousButton;
    private /* synthetic */ int selectedMerchantRecipe;
    
    @Override
    public void initGui() {
        super.initGui();
        final int lllllllllllllIIIIIllIIlIIIllIlll = (this.width - this.xSize) / 2;
        final int lllllllllllllIIIIIllIIlIIIllIllI = (this.height - this.ySize) / 2;
        this.nextButton = this.addButton(new MerchantButton(1, lllllllllllllIIIIIllIIlIIIllIlll + 120 + 27, lllllllllllllIIIIIllIIlIIIllIllI + 24 - 1, true));
        this.previousButton = this.addButton(new MerchantButton(2, lllllllllllllIIIIIllIIlIIIllIlll + 36 - 19, lllllllllllllIIIIIllIIlIIIllIllI + 24 - 1, false));
        this.nextButton.enabled = false;
        this.previousButton.enabled = false;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        MERCHANT_GUI_TEXTURE = new ResourceLocation("textures/gui/container/villager.png");
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        final MerchantRecipeList lllllllllllllIIIIIllIIlIIIlIIlll = this.merchant.getRecipes(this.mc.player);
        if (lllllllllllllIIIIIllIIlIIIlIIlll != null) {
            this.nextButton.enabled = (this.selectedMerchantRecipe < lllllllllllllIIIIIllIIlIIIlIIlll.size() - 1);
            this.previousButton.enabled = (this.selectedMerchantRecipe > 0);
        }
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIIIIIllIIlIIIIlIIII, final int lllllllllllllIIIIIllIIlIIIIIllll, final int lllllllllllllIIIIIllIIlIIIIIlllI) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiMerchant.MERCHANT_GUI_TEXTURE);
        final int lllllllllllllIIIIIllIIlIIIIIllIl = (this.width - this.xSize) / 2;
        final int lllllllllllllIIIIIllIIlIIIIIllII = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllIIIIIllIIlIIIIIllIl, lllllllllllllIIIIIllIIlIIIIIllII, 0, 0, this.xSize, this.ySize);
        final MerchantRecipeList lllllllllllllIIIIIllIIlIIIIIlIll = this.merchant.getRecipes(this.mc.player);
        if (lllllllllllllIIIIIllIIlIIIIIlIll != null && !lllllllllllllIIIIIllIIlIIIIIlIll.isEmpty()) {
            final int lllllllllllllIIIIIllIIlIIIIIlIlI = this.selectedMerchantRecipe;
            if (lllllllllllllIIIIIllIIlIIIIIlIlI < 0 || lllllllllllllIIIIIllIIlIIIIIlIlI >= lllllllllllllIIIIIllIIlIIIIIlIll.size()) {
                return;
            }
            final MerchantRecipe lllllllllllllIIIIIllIIlIIIIIlIIl = lllllllllllllIIIIIllIIlIIIIIlIll.get(lllllllllllllIIIIIllIIlIIIIIlIlI);
            if (lllllllllllllIIIIIllIIlIIIIIlIIl.isRecipeDisabled()) {
                this.mc.getTextureManager().bindTexture(GuiMerchant.MERCHANT_GUI_TEXTURE);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.disableLighting();
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 21, 212, 0, 28, 21);
                this.drawTexturedModalRect(this.guiLeft + 83, this.guiTop + 51, 212, 0, 28, 21);
            }
        }
    }
    
    public IMerchant getMerchant() {
        return this.merchant;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIIIIIllIIlIIIlIllll, final int lllllllllllllIIIIIllIIlIIIlIlllI) {
        final String lllllllllllllIIIIIllIIlIIIlIllIl = this.chatComponent.getUnformattedText();
        this.fontRendererObj.drawString(lllllllllllllIIIIIllIIlIIIlIllIl, this.xSize / 2 - this.fontRendererObj.getStringWidth(lllllllllllllIIIIIllIIlIIIlIllIl) / 2, 6.0, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    public GuiMerchant(final InventoryPlayer lllllllllllllIIIIIllIIlIIlIIIIlI, final IMerchant lllllllllllllIIIIIllIIlIIlIIIIIl, final World lllllllllllllIIIIIllIIlIIIllllII) {
        super(new ContainerMerchant(lllllllllllllIIIIIllIIlIIlIIIIlI, lllllllllllllIIIIIllIIlIIlIIIIIl, lllllllllllllIIIIIllIIlIIIllllII));
        this.merchant = lllllllllllllIIIIIllIIlIIlIIIIIl;
        this.chatComponent = lllllllllllllIIIIIllIIlIIlIIIIIl.getDisplayName();
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIIIIIllIIIllllIlIIl, final int lllllllllllllIIIIIllIIIlllllIlII, final float lllllllllllllIIIIIllIIIlllllIIll) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII, lllllllllllllIIIIIllIIIlllllIIll);
        final MerchantRecipeList lllllllllllllIIIIIllIIIlllllIIlI = this.merchant.getRecipes(this.mc.player);
        if (lllllllllllllIIIIIllIIIlllllIIlI != null && !lllllllllllllIIIIIllIIIlllllIIlI.isEmpty()) {
            final int lllllllllllllIIIIIllIIIlllllIIIl = (this.width - this.xSize) / 2;
            final int lllllllllllllIIIIIllIIIlllllIIII = (this.height - this.ySize) / 2;
            final int lllllllllllllIIIIIllIIIllllIllll = this.selectedMerchantRecipe;
            final MerchantRecipe lllllllllllllIIIIIllIIIllllIlllI = lllllllllllllIIIIIllIIIlllllIIlI.get(lllllllllllllIIIIIllIIIllllIllll);
            final ItemStack lllllllllllllIIIIIllIIIllllIllIl = lllllllllllllIIIIIllIIIllllIlllI.getItemToBuy();
            final ItemStack lllllllllllllIIIIIllIIIllllIllII = lllllllllllllIIIIIllIIIllllIlllI.getSecondItemToBuy();
            final ItemStack lllllllllllllIIIIIllIIIllllIlIll = lllllllllllllIIIIIllIIIllllIlllI.getItemToSell();
            GlStateManager.pushMatrix();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableColorMaterial();
            GlStateManager.enableLighting();
            this.itemRender.zLevel = 100.0f;
            this.itemRender.renderItemAndEffectIntoGUI(lllllllllllllIIIIIllIIIllllIllIl, lllllllllllllIIIIIllIIIlllllIIIl + 36, lllllllllllllIIIIIllIIIlllllIIII + 24);
            this.itemRender.renderItemOverlays(this.fontRendererObj, lllllllllllllIIIIIllIIIllllIllIl, lllllllllllllIIIIIllIIIlllllIIIl + 36, lllllllllllllIIIIIllIIIlllllIIII + 24);
            if (!lllllllllllllIIIIIllIIIllllIllII.func_190926_b()) {
                this.itemRender.renderItemAndEffectIntoGUI(lllllllllllllIIIIIllIIIllllIllII, lllllllllllllIIIIIllIIIlllllIIIl + 62, lllllllllllllIIIIIllIIIlllllIIII + 24);
                this.itemRender.renderItemOverlays(this.fontRendererObj, lllllllllllllIIIIIllIIIllllIllII, lllllllllllllIIIIIllIIIlllllIIIl + 62, lllllllllllllIIIIIllIIIlllllIIII + 24);
            }
            this.itemRender.renderItemAndEffectIntoGUI(lllllllllllllIIIIIllIIIllllIlIll, lllllllllllllIIIIIllIIIlllllIIIl + 120, lllllllllllllIIIIIllIIIlllllIIII + 24);
            this.itemRender.renderItemOverlays(this.fontRendererObj, lllllllllllllIIIIIllIIIllllIlIll, lllllllllllllIIIIIllIIIlllllIIIl + 120, lllllllllllllIIIIIllIIIlllllIIII + 24);
            this.itemRender.zLevel = 0.0f;
            GlStateManager.disableLighting();
            if (this.isPointInRegion(36, 24, 16, 16, lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII) && !lllllllllllllIIIIIllIIIllllIllIl.func_190926_b()) {
                this.renderToolTip(lllllllllllllIIIIIllIIIllllIllIl, lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII);
            }
            else if (!lllllllllllllIIIIIllIIIllllIllII.func_190926_b() && this.isPointInRegion(62, 24, 16, 16, lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII) && !lllllllllllllIIIIIllIIIllllIllII.func_190926_b()) {
                this.renderToolTip(lllllllllllllIIIIIllIIIllllIllII, lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII);
            }
            else if (!lllllllllllllIIIIIllIIIllllIlIll.func_190926_b() && this.isPointInRegion(120, 24, 16, 16, lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII) && !lllllllllllllIIIIIllIIIllllIlIll.func_190926_b()) {
                this.renderToolTip(lllllllllllllIIIIIllIIIllllIlIll, lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII);
            }
            else if (lllllllllllllIIIIIllIIIllllIlllI.isRecipeDisabled() && (this.isPointInRegion(83, 21, 28, 21, lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII) || this.isPointInRegion(83, 51, 28, 21, lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII))) {
                this.drawCreativeTabHoveringText(I18n.format("merchant.deprecated", new Object[0]), lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII);
            }
            GlStateManager.popMatrix();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
        }
        this.func_191948_b(lllllllllllllIIIIIllIIIllllIlIIl, lllllllllllllIIIIIllIIIlllllIlII);
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIIIIIllIIlIIIIllIlI) throws IOException {
        boolean lllllllllllllIIIIIllIIlIIIIllllI = false;
        if (lllllllllllllIIIIIllIIlIIIIllIlI == this.nextButton) {
            ++this.selectedMerchantRecipe;
            final MerchantRecipeList lllllllllllllIIIIIllIIlIIIIlllIl = this.merchant.getRecipes(this.mc.player);
            if (lllllllllllllIIIIIllIIlIIIIlllIl != null && this.selectedMerchantRecipe >= lllllllllllllIIIIIllIIlIIIIlllIl.size()) {
                this.selectedMerchantRecipe = lllllllllllllIIIIIllIIlIIIIlllIl.size() - 1;
            }
            lllllllllllllIIIIIllIIlIIIIllllI = true;
        }
        else if (lllllllllllllIIIIIllIIlIIIIllIlI == this.previousButton) {
            --this.selectedMerchantRecipe;
            if (this.selectedMerchantRecipe < 0) {
                this.selectedMerchantRecipe = 0;
            }
            lllllllllllllIIIIIllIIlIIIIllllI = true;
        }
        if (lllllllllllllIIIIIllIIlIIIIllllI) {
            ((ContainerMerchant)this.inventorySlots).setCurrentRecipeIndex(this.selectedMerchantRecipe);
            final PacketBuffer lllllllllllllIIIIIllIIlIIIIlllII = new PacketBuffer(Unpooled.buffer());
            lllllllllllllIIIIIllIIlIIIIlllII.writeInt(this.selectedMerchantRecipe);
            this.mc.getConnection().sendPacket(new CPacketCustomPayload("MC|TrSel", lllllllllllllIIIIIllIIlIIIIlllII));
        }
    }
    
    static class MerchantButton extends GuiButton
    {
        private final /* synthetic */ boolean forward;
        
        public void func_191745_a(final Minecraft llllllllllllllIllIlllIlIIIIlIllI, final int llllllllllllllIllIlllIlIIIIlIlIl, final int llllllllllllllIllIlllIlIIIIlllII, final float llllllllllllllIllIlllIlIIIIllIll) {
            if (this.visible) {
                llllllllllllllIllIlllIlIIIIlIllI.getTextureManager().bindTexture(GuiMerchant.MERCHANT_GUI_TEXTURE);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                final boolean llllllllllllllIllIlllIlIIIIllIlI = llllllllllllllIllIlllIlIIIIlIlIl >= this.xPosition && llllllllllllllIllIlllIlIIIIlllII >= this.yPosition && llllllllllllllIllIlllIlIIIIlIlIl < this.xPosition + this.width && llllllllllllllIllIlllIlIIIIlllII < this.yPosition + this.height;
                int llllllllllllllIllIlllIlIIIIllIIl = 0;
                int llllllllllllllIllIlllIlIIIIllIII = 176;
                if (!this.enabled) {
                    llllllllllllllIllIlllIlIIIIllIII += this.width * 2;
                }
                else if (llllllllllllllIllIlllIlIIIIllIlI) {
                    llllllllllllllIllIlllIlIIIIllIII += this.width;
                }
                if (!this.forward) {
                    llllllllllllllIllIlllIlIIIIllIIl += this.height;
                }
                this.drawTexturedModalRect(this.xPosition, this.yPosition, llllllllllllllIllIlllIlIIIIllIII, llllllllllllllIllIlllIlIIIIllIIl, this.width, this.height);
            }
        }
        
        public MerchantButton(final int llllllllllllllIllIlllIlIIIlIlIlI, final int llllllllllllllIllIlllIlIIIlIlllI, final int llllllllllllllIllIlllIlIIIlIllIl, final boolean llllllllllllllIllIlllIlIIIlIllII) {
            super(llllllllllllllIllIlllIlIIIlIlIlI, llllllllllllllIllIlllIlIIIlIlllI, llllllllllllllIllIlllIlIIIlIllIl, 12, 19, "");
            this.forward = llllllllllllllIllIlllIlIIIlIllII;
        }
    }
}
