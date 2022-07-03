package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.model.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import java.io.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.enchantment.*;
import com.google.common.collect.*;
import net.minecraft.util.text.*;
import net.minecraft.client.resources.*;
import java.util.*;
import org.lwjgl.util.glu.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class GuiEnchantment extends GuiContainer
{
    public /* synthetic */ float flipT;
    private static final /* synthetic */ ResourceLocation ENCHANTMENT_TABLE_GUI_TEXTURE;
    public /* synthetic */ float flip;
    public /* synthetic */ float oFlip;
    public /* synthetic */ int ticks;
    private final /* synthetic */ InventoryPlayer playerInventory;
    private static final /* synthetic */ ModelBook MODEL_BOOK;
    public /* synthetic */ float open;
    private static final /* synthetic */ ResourceLocation ENCHANTMENT_TABLE_BOOK_TEXTURE;
    private /* synthetic */ ItemStack last;
    private final /* synthetic */ Random random;
    private final /* synthetic */ ContainerEnchantment container;
    private final /* synthetic */ IWorldNameable nameable;
    public /* synthetic */ float oOpen;
    public /* synthetic */ float flipA;
    
    @Override
    protected void mouseClicked(final int llllllllllllllIlIIIIllIIlIlIllII, final int llllllllllllllIlIIIIllIIlIllIlII, final int llllllllllllllIlIIIIllIIlIlIlIlI) throws IOException {
        super.mouseClicked(llllllllllllllIlIIIIllIIlIlIllII, llllllllllllllIlIIIIllIIlIllIlII, llllllllllllllIlIIIIllIIlIlIlIlI);
        final int llllllllllllllIlIIIIllIIlIllIIlI = (this.width - this.xSize) / 2;
        final int llllllllllllllIlIIIIllIIlIllIIIl = (this.height - this.ySize) / 2;
        for (int llllllllllllllIlIIIIllIIlIllIIII = 0; llllllllllllllIlIIIIllIIlIllIIII < 3; ++llllllllllllllIlIIIIllIIlIllIIII) {
            final int llllllllllllllIlIIIIllIIlIlIllll = llllllllllllllIlIIIIllIIlIlIllII - (llllllllllllllIlIIIIllIIlIllIIlI + 60);
            final int llllllllllllllIlIIIIllIIlIlIlllI = llllllllllllllIlIIIIllIIlIllIlII - (llllllllllllllIlIIIIllIIlIllIIIl + 14 + 19 * llllllllllllllIlIIIIllIIlIllIIII);
            if (llllllllllllllIlIIIIllIIlIlIllll >= 0 && llllllllllllllIlIIIIllIIlIlIlllI >= 0 && llllllllllllllIlIIIIllIIlIlIllll < 108 && llllllllllllllIlIIIIllIIlIlIlllI < 19 && this.container.enchantItem(this.mc.player, llllllllllllllIlIIIIllIIlIllIIII)) {
                this.mc.playerController.sendEnchantPacket(this.container.windowId, llllllllllllllIlIIIIllIIlIllIIII);
            }
        }
    }
    
    public GuiEnchantment(final InventoryPlayer llllllllllllllIlIIIIllIIllIIlllI, final World llllllllllllllIlIIIIllIIllIIlIIl, final IWorldNameable llllllllllllllIlIIIIllIIllIIlIII) {
        super(new ContainerEnchantment(llllllllllllllIlIIIIllIIllIIlllI, llllllllllllllIlIIIIllIIllIIlIIl));
        this.random = new Random();
        this.last = ItemStack.field_190927_a;
        this.playerInventory = llllllllllllllIlIIIIllIIllIIlllI;
        this.container = (ContainerEnchantment)this.inventorySlots;
        this.nameable = llllllllllllllIlIIIIllIIllIIlIII;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        this.tickBook();
    }
    
    @Override
    public void drawScreen(final int llllllllllllllIlIIIIllIIIlIIllIl, final int llllllllllllllIlIIIIllIIIlIIllII, float llllllllllllllIlIIIIllIIIIllllII) {
        llllllllllllllIlIIIIllIIIIllllII = this.mc.func_193989_ak();
        this.drawDefaultBackground();
        super.drawScreen(llllllllllllllIlIIIIllIIIlIIllIl, llllllllllllllIlIIIIllIIIlIIllII, llllllllllllllIlIIIIllIIIIllllII);
        this.func_191948_b(llllllllllllllIlIIIIllIIIlIIllIl, llllllllllllllIlIIIIllIIIlIIllII);
        final boolean llllllllllllllIlIIIIllIIIlIIlIlI = this.mc.player.capabilities.isCreativeMode;
        final int llllllllllllllIlIIIIllIIIlIIlIIl = this.container.getLapisAmount();
        for (int llllllllllllllIlIIIIllIIIlIIlIII = 0; llllllllllllllIlIIIIllIIIlIIlIII < 3; ++llllllllllllllIlIIIIllIIIlIIlIII) {
            final int llllllllllllllIlIIIIllIIIlIIIlll = this.container.enchantLevels[llllllllllllllIlIIIIllIIIlIIlIII];
            final Enchantment llllllllllllllIlIIIIllIIIlIIIllI = Enchantment.getEnchantmentByID(this.container.enchantClue[llllllllllllllIlIIIIllIIIlIIlIII]);
            final int llllllllllllllIlIIIIllIIIlIIIlIl = this.container.worldClue[llllllllllllllIlIIIIllIIIlIIlIII];
            final int llllllllllllllIlIIIIllIIIlIIIlII = llllllllllllllIlIIIIllIIIlIIlIII + 1;
            if (this.isPointInRegion(60, 14 + 19 * llllllllllllllIlIIIIllIIIlIIlIII, 108, 17, llllllllllllllIlIIIIllIIIlIIllIl, llllllllllllllIlIIIIllIIIlIIllII) && llllllllllllllIlIIIIllIIIlIIIlll > 0 && llllllllllllllIlIIIIllIIIlIIIlIl >= 0 && llllllllllllllIlIIIIllIIIlIIIllI != null) {
                final List<String> llllllllllllllIlIIIIllIIIlIIIIll = (List<String>)Lists.newArrayList();
                llllllllllllllIlIIIIllIIIlIIIIll.add(String.valueOf(new StringBuilder().append(TextFormatting.WHITE).append(TextFormatting.ITALIC).append(I18n.format("container.enchant.clue", llllllllllllllIlIIIIllIIIlIIIllI.getTranslatedName(llllllllllllllIlIIIIllIIIlIIIlIl)))));
                if (!llllllllllllllIlIIIIllIIIlIIlIlI) {
                    llllllllllllllIlIIIIllIIIlIIIIll.add("");
                    if (this.mc.player.experienceLevel < llllllllllllllIlIIIIllIIIlIIIlll) {
                        llllllllllllllIlIIIIllIIIlIIIIll.add(String.valueOf(new StringBuilder().append(TextFormatting.RED).append(I18n.format("container.enchant.level.requirement", this.container.enchantLevels[llllllllllllllIlIIIIllIIIlIIlIII]))));
                    }
                    else {
                        String llllllllllllllIlIIIIllIIIlIIIIIl = null;
                        if (llllllllllllllIlIIIIllIIIlIIIlII == 1) {
                            final String llllllllllllllIlIIIIllIIIlIIIIlI = I18n.format("container.enchant.lapis.one", new Object[0]);
                        }
                        else {
                            llllllllllllllIlIIIIllIIIlIIIIIl = I18n.format("container.enchant.lapis.many", llllllllllllllIlIIIIllIIIlIIIlII);
                        }
                        final TextFormatting llllllllllllllIlIIIIllIIIlIIIIII = (llllllllllllllIlIIIIllIIIlIIlIIl >= llllllllllllllIlIIIIllIIIlIIIlII) ? TextFormatting.GRAY : TextFormatting.RED;
                        llllllllllllllIlIIIIllIIIlIIIIll.add(String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIllIIIlIIIIII).append(llllllllllllllIlIIIIllIIIlIIIIIl)));
                        if (llllllllllllllIlIIIIllIIIlIIIlII == 1) {
                            llllllllllllllIlIIIIllIIIlIIIIIl = I18n.format("container.enchant.level.one", new Object[0]);
                        }
                        else {
                            llllllllllllllIlIIIIllIIIlIIIIIl = I18n.format("container.enchant.level.many", llllllllllllllIlIIIIllIIIlIIIlII);
                        }
                        llllllllllllllIlIIIIllIIIlIIIIll.add(String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(llllllllllllllIlIIIIllIIIlIIIIIl)));
                    }
                }
                this.drawHoveringText(llllllllllllllIlIIIIllIIIlIIIIll, llllllllllllllIlIIIIllIIIlIIllIl, llllllllllllllIlIIIIllIIIlIIllII);
                break;
            }
        }
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float llllllllllllllIlIIIIllIIIlllIIll, final int llllllllllllllIlIIIIllIIlIIIlIlI, final int llllllllllllllIlIIIIllIIIlllIIIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiEnchantment.ENCHANTMENT_TABLE_GUI_TEXTURE);
        final int llllllllllllllIlIIIIllIIlIIIlIII = (this.width - this.xSize) / 2;
        final int llllllllllllllIlIIIIllIIlIIIIlll = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(llllllllllllllIlIIIIllIIlIIIlIII, llllllllllllllIlIIIIllIIlIIIIlll, 0, 0, this.xSize, this.ySize);
        GlStateManager.pushMatrix();
        GlStateManager.matrixMode(5889);
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        final ScaledResolution llllllllllllllIlIIIIllIIlIIIIllI = new ScaledResolution(this.mc);
        GlStateManager.viewport((llllllllllllllIlIIIIllIIlIIIIllI.getScaledWidth() - 320) / 2 * llllllllllllllIlIIIIllIIlIIIIllI.getScaleFactor(), (llllllllllllllIlIIIIllIIlIIIIllI.getScaledHeight() - 240) / 2 * llllllllllllllIlIIIIllIIlIIIIllI.getScaleFactor(), 320 * llllllllllllllIlIIIIllIIlIIIIllI.getScaleFactor(), 240 * llllllllllllllIlIIIIllIIlIIIIllI.getScaleFactor());
        GlStateManager.translate(-0.34f, 0.23f, 0.0f);
        Project.gluPerspective(90.0f, 1.3333334f, 9.0f, 80.0f);
        final float llllllllllllllIlIIIIllIIlIIIIlIl = 1.0f;
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.translate(0.0f, 3.3f, -16.0f);
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        final float llllllllllllllIlIIIIllIIlIIIIlII = 5.0f;
        GlStateManager.scale(5.0f, 5.0f, 5.0f);
        GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiEnchantment.ENCHANTMENT_TABLE_BOOK_TEXTURE);
        GlStateManager.rotate(20.0f, 1.0f, 0.0f, 0.0f);
        final float llllllllllllllIlIIIIllIIlIIIIIll = this.oOpen + (this.open - this.oOpen) * llllllllllllllIlIIIIllIIIlllIIll;
        GlStateManager.translate((1.0f - llllllllllllllIlIIIIllIIlIIIIIll) * 0.2f, (1.0f - llllllllllllllIlIIIIllIIlIIIIIll) * 0.1f, (1.0f - llllllllllllllIlIIIIllIIlIIIIIll) * 0.25f);
        GlStateManager.rotate(-(1.0f - llllllllllllllIlIIIIllIIlIIIIIll) * 90.0f - 90.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
        float llllllllllllllIlIIIIllIIlIIIIIlI = this.oFlip + (this.flip - this.oFlip) * llllllllllllllIlIIIIllIIIlllIIll + 0.25f;
        float llllllllllllllIlIIIIllIIlIIIIIIl = this.oFlip + (this.flip - this.oFlip) * llllllllllllllIlIIIIllIIIlllIIll + 0.75f;
        llllllllllllllIlIIIIllIIlIIIIIlI = (llllllllllllllIlIIIIllIIlIIIIIlI - MathHelper.fastFloor(llllllllllllllIlIIIIllIIlIIIIIlI)) * 1.6f - 0.3f;
        llllllllllllllIlIIIIllIIlIIIIIIl = (llllllllllllllIlIIIIllIIlIIIIIIl - MathHelper.fastFloor(llllllllllllllIlIIIIllIIlIIIIIIl)) * 1.6f - 0.3f;
        if (llllllllllllllIlIIIIllIIlIIIIIlI < 0.0f) {
            llllllllllllllIlIIIIllIIlIIIIIlI = 0.0f;
        }
        if (llllllllllllllIlIIIIllIIlIIIIIIl < 0.0f) {
            llllllllllllllIlIIIIllIIlIIIIIIl = 0.0f;
        }
        if (llllllllllllllIlIIIIllIIlIIIIIlI > 1.0f) {
            llllllllllllllIlIIIIllIIlIIIIIlI = 1.0f;
        }
        if (llllllllllllllIlIIIIllIIlIIIIIIl > 1.0f) {
            llllllllllllllIlIIIIllIIlIIIIIIl = 1.0f;
        }
        GlStateManager.enableRescaleNormal();
        GuiEnchantment.MODEL_BOOK.render(null, 0.0f, llllllllllllllIlIIIIllIIlIIIIIlI, llllllllllllllIlIIIIllIIlIIIIIIl, llllllllllllllIlIIIIllIIlIIIIIll, 0.0f, 0.0625f);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.matrixMode(5889);
        GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        GlStateManager.popMatrix();
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        EnchantmentNameParts.getInstance().reseedRandomGenerator(this.container.xpSeed);
        final int llllllllllllllIlIIIIllIIlIIIIIII = this.container.getLapisAmount();
        for (int llllllllllllllIlIIIIllIIIlllllll = 0; llllllllllllllIlIIIIllIIIlllllll < 3; ++llllllllllllllIlIIIIllIIIlllllll) {
            final int llllllllllllllIlIIIIllIIIllllllI = llllllllllllllIlIIIIllIIlIIIlIII + 60;
            final int llllllllllllllIlIIIIllIIIlllllIl = llllllllllllllIlIIIIllIIIllllllI + 20;
            this.zLevel = 0.0f;
            this.mc.getTextureManager().bindTexture(GuiEnchantment.ENCHANTMENT_TABLE_GUI_TEXTURE);
            final int llllllllllllllIlIIIIllIIIlllllII = this.container.enchantLevels[llllllllllllllIlIIIIllIIIlllllll];
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            if (llllllllllllllIlIIIIllIIIlllllII == 0) {
                this.drawTexturedModalRect(llllllllllllllIlIIIIllIIIllllllI, llllllllllllllIlIIIIllIIlIIIIlll + 14 + 19 * llllllllllllllIlIIIIllIIIlllllll, 0, 185, 108, 19);
            }
            else {
                final String llllllllllllllIlIIIIllIIIllllIll = String.valueOf(new StringBuilder().append(llllllllllllllIlIIIIllIIIlllllII));
                final int llllllllllllllIlIIIIllIIIllllIlI = 86 - this.fontRendererObj.getStringWidth(llllllllllllllIlIIIIllIIIllllIll);
                final String llllllllllllllIlIIIIllIIIllllIIl = EnchantmentNameParts.getInstance().generateNewRandomName(this.fontRendererObj, llllllllllllllIlIIIIllIIIllllIlI);
                FontRenderer llllllllllllllIlIIIIllIIIllllIII = this.mc.standardGalacticFontRenderer;
                int llllllllllllllIlIIIIllIIIlllIlll = 6839882;
                if ((llllllllllllllIlIIIIllIIlIIIIIII < llllllllllllllIlIIIIllIIIlllllll + 1 || this.mc.player.experienceLevel < llllllllllllllIlIIIIllIIIlllllII) && !this.mc.player.capabilities.isCreativeMode) {
                    this.drawTexturedModalRect(llllllllllllllIlIIIIllIIIllllllI, llllllllllllllIlIIIIllIIlIIIIlll + 14 + 19 * llllllllllllllIlIIIIllIIIlllllll, 0, 185, 108, 19);
                    this.drawTexturedModalRect(llllllllllllllIlIIIIllIIIllllllI + 1, llllllllllllllIlIIIIllIIlIIIIlll + 15 + 19 * llllllllllllllIlIIIIllIIIlllllll, 16 * llllllllllllllIlIIIIllIIIlllllll, 239, 16, 16);
                    llllllllllllllIlIIIIllIIIllllIII.drawSplitString(llllllllllllllIlIIIIllIIIllllIIl, llllllllllllllIlIIIIllIIIlllllIl, llllllllllllllIlIIIIllIIlIIIIlll + 16 + 19 * llllllllllllllIlIIIIllIIIlllllll, llllllllllllllIlIIIIllIIIllllIlI, (llllllllllllllIlIIIIllIIIlllIlll & 0xFEFEFE) >> 1);
                    llllllllllllllIlIIIIllIIIlllIlll = 4226832;
                }
                else {
                    final int llllllllllllllIlIIIIllIIIlllIllI = llllllllllllllIlIIIIllIIlIIIlIlI - (llllllllllllllIlIIIIllIIlIIIlIII + 60);
                    final int llllllllllllllIlIIIIllIIIlllIlIl = llllllllllllllIlIIIIllIIIlllIIIl - (llllllllllllllIlIIIIllIIlIIIIlll + 14 + 19 * llllllllllllllIlIIIIllIIIlllllll);
                    if (llllllllllllllIlIIIIllIIIlllIllI >= 0 && llllllllllllllIlIIIIllIIIlllIlIl >= 0 && llllllllllllllIlIIIIllIIIlllIllI < 108 && llllllllllllllIlIIIIllIIIlllIlIl < 19) {
                        this.drawTexturedModalRect(llllllllllllllIlIIIIllIIIllllllI, llllllllllllllIlIIIIllIIlIIIIlll + 14 + 19 * llllllllllllllIlIIIIllIIIlllllll, 0, 204, 108, 19);
                        llllllllllllllIlIIIIllIIIlllIlll = 16777088;
                    }
                    else {
                        this.drawTexturedModalRect(llllllllllllllIlIIIIllIIIllllllI, llllllllllllllIlIIIIllIIlIIIIlll + 14 + 19 * llllllllllllllIlIIIIllIIIlllllll, 0, 166, 108, 19);
                    }
                    this.drawTexturedModalRect(llllllllllllllIlIIIIllIIIllllllI + 1, llllllllllllllIlIIIIllIIlIIIIlll + 15 + 19 * llllllllllllllIlIIIIllIIIlllllll, 16 * llllllllllllllIlIIIIllIIIlllllll, 223, 16, 16);
                    llllllllllllllIlIIIIllIIIllllIII.drawSplitString(llllllllllllllIlIIIIllIIIllllIIl, llllllllllllllIlIIIIllIIIlllllIl, llllllllllllllIlIIIIllIIlIIIIlll + 16 + 19 * llllllllllllllIlIIIIllIIIlllllll, llllllllllllllIlIIIIllIIIllllIlI, llllllllllllllIlIIIIllIIIlllIlll);
                    llllllllllllllIlIIIIllIIIlllIlll = 8453920;
                }
                llllllllllllllIlIIIIllIIIllllIII = this.mc.fontRendererObj;
                llllllllllllllIlIIIIllIIIllllIII.drawStringWithShadow(llllllllllllllIlIIIIllIIIllllIll, (float)(llllllllllllllIlIIIIllIIIlllllIl + 86 - llllllllllllllIlIIIIllIIIllllIII.getStringWidth(llllllllllllllIlIIIIllIIIllllIll)), (float)(llllllllllllllIlIIIIllIIlIIIIlll + 16 + 19 * llllllllllllllIlIIIIllIIIlllllll + 7), llllllllllllllIlIIIIllIIIlllIlll);
            }
        }
    }
    
    public void tickBook() {
        final ItemStack llllllllllllllIlIIIIllIIIIlIlIll = this.inventorySlots.getSlot(0).getStack();
        if (!ItemStack.areItemStacksEqual(llllllllllllllIlIIIIllIIIIlIlIll, this.last)) {
            this.last = llllllllllllllIlIIIIllIIIIlIlIll;
            do {
                this.flipT += this.random.nextInt(4) - this.random.nextInt(4);
            } while (this.flip <= this.flipT + 1.0f && this.flip >= this.flipT - 1.0f);
        }
        ++this.ticks;
        this.oFlip = this.flip;
        this.oOpen = this.open;
        boolean llllllllllllllIlIIIIllIIIIlIlIlI = false;
        for (int llllllllllllllIlIIIIllIIIIlIlIIl = 0; llllllllllllllIlIIIIllIIIIlIlIIl < 3; ++llllllllllllllIlIIIIllIIIIlIlIIl) {
            if (this.container.enchantLevels[llllllllllllllIlIIIIllIIIIlIlIIl] != 0) {
                llllllllllllllIlIIIIllIIIIlIlIlI = true;
            }
        }
        if (llllllllllllllIlIIIIllIIIIlIlIlI) {
            this.open += 0.2f;
        }
        else {
            this.open -= 0.2f;
        }
        this.open = MathHelper.clamp(this.open, 0.0f, 1.0f);
        float llllllllllllllIlIIIIllIIIIlIlIII = (this.flipT - this.flip) * 0.4f;
        final float llllllllllllllIlIIIIllIIIIlIIlll = 0.2f;
        llllllllllllllIlIIIIllIIIIlIlIII = MathHelper.clamp(llllllllllllllIlIIIIllIIIIlIlIII, -0.2f, 0.2f);
        this.flipA += (llllllllllllllIlIIIIllIIIIlIlIII - this.flipA) * 0.9f;
        this.flip += this.flipA;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int llllllllllllllIlIIIIllIIllIIIlIl, final int llllllllllllllIlIIIIllIIllIIIlII) {
        this.fontRendererObj.drawString(this.nameable.getDisplayName().getUnformattedText(), 12.0, 5.0, 4210752);
        this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8.0, this.ySize - 96 + 2, 4210752);
    }
    
    static {
        ENCHANTMENT_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/enchanting_table.png");
        ENCHANTMENT_TABLE_BOOK_TEXTURE = new ResourceLocation("textures/entity/enchanting_table_book.png");
        MODEL_BOOK = new ModelBook();
    }
}
