package net.minecraft.client.gui.inventory;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.inventory.*;
import java.io.*;
import me.nrules.utils.render.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.texture.*;
import com.google.common.collect.*;

public abstract class GuiContainer extends GuiScreen
{
    protected final /* synthetic */ Set<Slot> dragSplittingSlots;
    public /* synthetic */ Container inventorySlots;
    private /* synthetic */ int touchUpX;
    private /* synthetic */ Slot lastClickSlot;
    private /* synthetic */ boolean isRightMouseClick;
    private /* synthetic */ boolean ignoreMouseUp;
    private /* synthetic */ Slot theSlot;
    private /* synthetic */ long returningStackTime;
    private /* synthetic */ boolean doubleClick;
    private /* synthetic */ int dragSplittingLimit;
    private /* synthetic */ long dragItemDropDelay;
    private /* synthetic */ int touchUpY;
    protected /* synthetic */ boolean dragSplitting;
    private /* synthetic */ ItemStack draggedStack;
    private /* synthetic */ int lastClickButton;
    protected /* synthetic */ int guiTop;
    protected /* synthetic */ int guiLeft;
    private /* synthetic */ int dragSplittingRemnant;
    protected /* synthetic */ int ySize;
    private /* synthetic */ Slot currentDragTargetSlot;
    private /* synthetic */ double scaleA;
    private /* synthetic */ ItemStack returningStack;
    private /* synthetic */ Slot clickedSlot;
    private /* synthetic */ Slot returningStackDestSlot;
    protected /* synthetic */ int xSize;
    private /* synthetic */ int dragSplittingButton;
    private /* synthetic */ ItemStack shiftClickedSlot;
    private /* synthetic */ long lastClickTime;
    
    private void drawItemStack(final ItemStack lllllllllllllIlllIIIlIIIIlIlllIl, final int lllllllllllllIlllIIIlIIIIlIlllII, final int lllllllllllllIlllIIIlIIIIllIIIII, final String lllllllllllllIlllIIIlIIIIlIllIlI) {
        GlStateManager.translate(0.0f, 0.0f, 32.0f);
        this.zLevel = 200.0f;
        this.itemRender.zLevel = 200.0f;
        this.itemRender.renderItemAndEffectIntoGUI(lllllllllllllIlllIIIlIIIIlIlllIl, lllllllllllllIlllIIIlIIIIlIlllII, lllllllllllllIlllIIIlIIIIllIIIII);
        this.itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, lllllllllllllIlllIIIlIIIIlIlllIl, lllllllllllllIlllIIIlIIIIlIlllII, lllllllllllllIlllIIIlIIIIllIIIII - (this.draggedStack.func_190926_b() ? 0 : 8), lllllllllllllIlllIIIlIIIIlIllIlI);
        this.zLevel = 0.0f;
        this.itemRender.zLevel = 0.0f;
    }
    
    private boolean isMouseOverSlot(final Slot lllllllllllllIlllIIIIllllIIlIllI, final int lllllllllllllIlllIIIIllllIIlIlIl, final int lllllllllllllIlllIIIIllllIIlIlII) {
        return this.isPointInRegion(lllllllllllllIlllIIIIllllIIlIllI.xDisplayPosition, lllllllllllllIlllIIIIllllIIlIllI.yDisplayPosition, 16, 16, lllllllllllllIlllIIIIllllIIlIlIl, lllllllllllllIlllIIIIllllIIlIlII);
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIlllIIIIlllIllIIllI, final int lllllllllllllIlllIIIIlllIllIIIll) throws IOException {
        if (lllllllllllllIlllIIIIlllIllIIIll == 1 || lllllllllllllIlllIIIIlllIllIIIll == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
            this.mc.player.closeScreen();
        }
        this.checkHotbarKeys(lllllllllllllIlllIIIIlllIllIIIll);
        if (this.theSlot != null && this.theSlot.getHasStack()) {
            if (lllllllllllllIlllIIIIlllIllIIIll == this.mc.gameSettings.keyBindPickBlock.getKeyCode()) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, 0, ClickType.CLONE);
            }
            else if (lllllllllllllIlllIIIIlllIllIIIll == this.mc.gameSettings.keyBindDrop.getKeyCode()) {
                this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, GuiScreen.isCtrlKeyDown() ? 1 : 0, ClickType.THROW);
            }
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    static {
        INVENTORY_BACKGROUND = new ResourceLocation("textures/gui/container/inventory.png");
    }
    
    private void updateDragSplitting() {
        final ItemStack lllllllllllllIlllIIIlIIIIIlIlIll = this.mc.player.inventory.getItemStack();
        if (!lllllllllllllIlllIIIlIIIIIlIlIll.func_190926_b() && this.dragSplitting) {
            if (this.dragSplittingLimit == 2) {
                this.dragSplittingRemnant = lllllllllllllIlllIIIlIIIIIlIlIll.getMaxStackSize();
            }
            else {
                this.dragSplittingRemnant = lllllllllllllIlllIIIlIIIIIlIlIll.func_190916_E();
                for (final Slot lllllllllllllIlllIIIlIIIIIlIlIlI : this.dragSplittingSlots) {
                    final ItemStack lllllllllllllIlllIIIlIIIIIlIlIIl = lllllllllllllIlllIIIlIIIIIlIlIll.copy();
                    final ItemStack lllllllllllllIlllIIIlIIIIIlIlIII = lllllllllllllIlllIIIlIIIIIlIlIlI.getStack();
                    final int lllllllllllllIlllIIIlIIIIIlIIlll = lllllllllllllIlllIIIlIIIIIlIlIII.func_190926_b() ? 0 : lllllllllllllIlllIIIlIIIIIlIlIII.func_190916_E();
                    Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, lllllllllllllIlllIIIlIIIIIlIlIIl, lllllllllllllIlllIIIlIIIIIlIIlll);
                    final int lllllllllllllIlllIIIlIIIIIlIIllI = Math.min(lllllllllllllIlllIIIlIIIIIlIlIIl.getMaxStackSize(), lllllllllllllIlllIIIlIIIIIlIlIlI.getItemStackLimit(lllllllllllllIlllIIIlIIIIIlIlIIl));
                    if (lllllllllllllIlllIIIlIIIIIlIlIIl.func_190916_E() > lllllllllllllIlllIIIlIIIIIlIIllI) {
                        lllllllllllllIlllIIIlIIIIIlIlIIl.func_190920_e(lllllllllllllIlllIIIlIIIIIlIIllI);
                    }
                    this.dragSplittingRemnant -= lllllllllllllIlllIIIlIIIIIlIlIIl.func_190916_E() - lllllllllllllIlllIIIlIIIIIlIIlll;
                }
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlllIIIlIIIlIIlIlIl, final int lllllllllllllIlllIIIlIIIlIIlIlII, final float lllllllllllllIlllIIIlIIIlIIlIIll) {
        this.scaleA = RenderUtils.animate(this.scaleA, 1.0);
        final int lllllllllllllIlllIIIlIIIlIIlIIlI = this.guiLeft;
        final int lllllllllllllIlllIIIlIIIlIIlIIIl = this.guiTop;
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)(this.width / 2), (float)(this.height / 2), 0.0f);
        GlStateManager.scale(this.scaleA, this.scaleA, 1.0);
        GlStateManager.translate((float)(-(this.width / 2)), (float)(-(this.height / 2)), 0.0f);
        this.drawGuiContainerBackgroundLayer(lllllllllllllIlllIIIlIIIlIIlIIll, lllllllllllllIlllIIIlIIIlIIlIlIl, lllllllllllllIlllIIIlIIIlIIlIlII);
        GlStateManager.disableRescaleNormal();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        super.drawScreen(lllllllllllllIlllIIIlIIIlIIlIlIl, lllllllllllllIlllIIIlIIIlIIlIlII, lllllllllllllIlllIIIlIIIlIIlIIll);
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)lllllllllllllIlllIIIlIIIlIIlIIlI, (float)lllllllllllllIlllIIIlIIIlIIlIIIl, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableRescaleNormal();
        this.theSlot = null;
        final int lllllllllllllIlllIIIlIIIlIIlIIII = 240;
        final int lllllllllllllIlllIIIlIIIlIIIllll = 240;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        for (int lllllllllllllIlllIIIlIIIlIIIlllI = 0; lllllllllllllIlllIIIlIIIlIIIlllI < this.inventorySlots.inventorySlots.size(); ++lllllllllllllIlllIIIlIIIlIIIlllI) {
            final Slot lllllllllllllIlllIIIlIIIlIIIllIl = this.inventorySlots.inventorySlots.get(lllllllllllllIlllIIIlIIIlIIIlllI);
            if (lllllllllllllIlllIIIlIIIlIIIllIl.canBeHovered()) {
                this.drawSlot(lllllllllllllIlllIIIlIIIlIIIllIl);
            }
            if (this.isMouseOverSlot(lllllllllllllIlllIIIlIIIlIIIllIl, lllllllllllllIlllIIIlIIIlIIlIlIl, lllllllllllllIlllIIIlIIIlIIlIlII) && lllllllllllllIlllIIIlIIIlIIIllIl.canBeHovered()) {
                this.theSlot = lllllllllllllIlllIIIlIIIlIIIllIl;
                GlStateManager.disableLighting();
                GlStateManager.disableDepth();
                final int lllllllllllllIlllIIIlIIIlIIIllII = lllllllllllllIlllIIIlIIIlIIIllIl.xDisplayPosition;
                final int lllllllllllllIlllIIIlIIIlIIIlIll = lllllllllllllIlllIIIlIIIlIIIllIl.yDisplayPosition;
                GlStateManager.colorMask(true, true, true, false);
                this.drawGradientRect(lllllllllllllIlllIIIlIIIlIIIllII, lllllllllllllIlllIIIlIIIlIIIlIll, lllllllllllllIlllIIIlIIIlIIIllII + 16, lllllllllllllIlllIIIlIIIlIIIlIll + 16, -2130706433, -2130706433);
                GlStateManager.colorMask(true, true, true, true);
                GlStateManager.enableLighting();
                GlStateManager.enableDepth();
            }
        }
        RenderHelper.disableStandardItemLighting();
        this.drawGuiContainerForegroundLayer(lllllllllllllIlllIIIlIIIlIIlIlIl, lllllllllllllIlllIIIlIIIlIIlIlII);
        RenderHelper.enableGUIStandardItemLighting();
        final InventoryPlayer lllllllllllllIlllIIIlIIIlIIIlIlI = this.mc.player.inventory;
        ItemStack lllllllllllllIlllIIIlIIIlIIIlIIl = this.draggedStack.func_190926_b() ? lllllllllllllIlllIIIlIIIlIIIlIlI.getItemStack() : this.draggedStack;
        if (!lllllllllllllIlllIIIlIIIlIIIlIIl.func_190926_b()) {
            final int lllllllllllllIlllIIIlIIIlIIIlIII = 8;
            final int lllllllllllllIlllIIIlIIIlIIIIlll = this.draggedStack.func_190926_b() ? 8 : 16;
            String lllllllllllllIlllIIIlIIIlIIIIllI = null;
            if (!this.draggedStack.func_190926_b() && this.isRightMouseClick) {
                lllllllllllllIlllIIIlIIIlIIIlIIl = lllllllllllllIlllIIIlIIIlIIIlIIl.copy();
                lllllllllllllIlllIIIlIIIlIIIlIIl.func_190920_e(MathHelper.ceil(lllllllllllllIlllIIIlIIIlIIIlIIl.func_190916_E() / 2.0f));
            }
            else if (this.dragSplitting && this.dragSplittingSlots.size() > 1) {
                lllllllllllllIlllIIIlIIIlIIIlIIl = lllllllllllllIlllIIIlIIIlIIIlIIl.copy();
                lllllllllllllIlllIIIlIIIlIIIlIIl.func_190920_e(this.dragSplittingRemnant);
                if (lllllllllllllIlllIIIlIIIlIIIlIIl.func_190926_b()) {
                    lllllllllllllIlllIIIlIIIlIIIIllI = String.valueOf(new StringBuilder().append(TextFormatting.YELLOW).append("0"));
                }
            }
            this.drawItemStack(lllllllllllllIlllIIIlIIIlIIIlIIl, lllllllllllllIlllIIIlIIIlIIlIlIl - lllllllllllllIlllIIIlIIIlIIlIIlI - 8, lllllllllllllIlllIIIlIIIlIIlIlII - lllllllllllllIlllIIIlIIIlIIlIIIl - lllllllllllllIlllIIIlIIIlIIIIlll, lllllllllllllIlllIIIlIIIlIIIIllI);
        }
        if (!this.returningStack.func_190926_b()) {
            float lllllllllllllIlllIIIlIIIlIIIIlIl = (Minecraft.getSystemTime() - this.returningStackTime) / 100.0f;
            if (lllllllllllllIlllIIIlIIIlIIIIlIl >= 1.0f) {
                lllllllllllllIlllIIIlIIIlIIIIlIl = 1.0f;
                this.returningStack = ItemStack.field_190927_a;
            }
            final int lllllllllllllIlllIIIlIIIlIIIIlII = this.returningStackDestSlot.xDisplayPosition - this.touchUpX;
            final int lllllllllllllIlllIIIlIIIlIIIIIll = this.returningStackDestSlot.yDisplayPosition - this.touchUpY;
            final int lllllllllllllIlllIIIlIIIlIIIIIlI = this.touchUpX + (int)(lllllllllllllIlllIIIlIIIlIIIIlII * lllllllllllllIlllIIIlIIIlIIIIlIl);
            final int lllllllllllllIlllIIIlIIIlIIIIIIl = this.touchUpY + (int)(lllllllllllllIlllIIIlIIIlIIIIIll * lllllllllllllIlllIIIlIIIlIIIIlIl);
            this.drawItemStack(this.returningStack, lllllllllllllIlllIIIlIIIlIIIIIlI, lllllllllllllIlllIIIlIIIlIIIIIIl, null);
        }
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIlllIIIlIIIIIIIIIII, final int lllllllllllllIlllIIIIlllllllIIlI, final int lllllllllllllIlllIIIIlllllllIIIl) throws IOException {
        super.mouseClicked(lllllllllllllIlllIIIlIIIIIIIIIII, lllllllllllllIlllIIIIlllllllIIlI, lllllllllllllIlllIIIIlllllllIIIl);
        final boolean lllllllllllllIlllIIIIlllllllllIl = lllllllllllllIlllIIIIlllllllIIIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100;
        final Slot lllllllllllllIlllIIIIlllllllllII = this.getSlotAtPosition(lllllllllllllIlllIIIlIIIIIIIIIII, lllllllllllllIlllIIIIlllllllIIlI);
        final long lllllllllllllIlllIIIIllllllllIll = Minecraft.getSystemTime();
        this.doubleClick = (this.lastClickSlot == lllllllllllllIlllIIIIlllllllllII && lllllllllllllIlllIIIIllllllllIll - this.lastClickTime < 250L && this.lastClickButton == lllllllllllllIlllIIIIlllllllIIIl);
        this.ignoreMouseUp = false;
        if (lllllllllllllIlllIIIIlllllllIIIl == 0 || lllllllllllllIlllIIIIlllllllIIIl == 1 || lllllllllllllIlllIIIIlllllllllIl) {
            final int lllllllllllllIlllIIIIllllllllIlI = this.guiLeft;
            final int lllllllllllllIlllIIIIllllllllIIl = this.guiTop;
            final boolean lllllllllllllIlllIIIIllllllllIII = this.func_193983_c(lllllllllllllIlllIIIlIIIIIIIIIII, lllllllllllllIlllIIIIlllllllIIlI, lllllllllllllIlllIIIIllllllllIlI, lllllllllllllIlllIIIIllllllllIIl);
            int lllllllllllllIlllIIIIlllllllIlll = -1;
            if (lllllllllllllIlllIIIIlllllllllII != null) {
                lllllllllllllIlllIIIIlllllllIlll = lllllllllllllIlllIIIIlllllllllII.slotNumber;
            }
            if (lllllllllllllIlllIIIIllllllllIII) {
                lllllllllllllIlllIIIIlllllllIlll = -999;
            }
            if (this.mc.gameSettings.touchscreen && lllllllllllllIlllIIIIllllllllIII && this.mc.player.inventory.getItemStack().func_190926_b()) {
                this.mc.displayGuiScreen(null);
                return;
            }
            if (lllllllllllllIlllIIIIlllllllIlll != -1) {
                if (this.mc.gameSettings.touchscreen) {
                    if (lllllllllllllIlllIIIIlllllllllII != null && lllllllllllllIlllIIIIlllllllllII.getHasStack()) {
                        this.clickedSlot = lllllllllllllIlllIIIIlllllllllII;
                        this.draggedStack = ItemStack.field_190927_a;
                        this.isRightMouseClick = (lllllllllllllIlllIIIIlllllllIIIl == 1);
                    }
                    else {
                        this.clickedSlot = null;
                    }
                }
                else if (!this.dragSplitting) {
                    if (this.mc.player.inventory.getItemStack().func_190926_b()) {
                        if (lllllllllllllIlllIIIIlllllllIIIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                            this.handleMouseClick(lllllllllllllIlllIIIIlllllllllII, lllllllllllllIlllIIIIlllllllIlll, lllllllllllllIlllIIIIlllllllIIIl, ClickType.CLONE);
                        }
                        else {
                            final boolean lllllllllllllIlllIIIIlllllllIllI = lllllllllllllIlllIIIIlllllllIlll != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                            ClickType lllllllllllllIlllIIIIlllllllIlIl = ClickType.PICKUP;
                            if (lllllllllllllIlllIIIIlllllllIllI) {
                                this.shiftClickedSlot = ((lllllllllllllIlllIIIIlllllllllII != null && lllllllllllllIlllIIIIlllllllllII.getHasStack()) ? lllllllllllllIlllIIIIlllllllllII.getStack().copy() : ItemStack.field_190927_a);
                                lllllllllllllIlllIIIIlllllllIlIl = ClickType.QUICK_MOVE;
                            }
                            else if (lllllllllllllIlllIIIIlllllllIlll == -999) {
                                lllllllllllllIlllIIIIlllllllIlIl = ClickType.THROW;
                            }
                            this.handleMouseClick(lllllllllllllIlllIIIIlllllllllII, lllllllllllllIlllIIIIlllllllIlll, lllllllllllllIlllIIIIlllllllIIIl, lllllllllllllIlllIIIIlllllllIlIl);
                        }
                        this.ignoreMouseUp = true;
                    }
                    else {
                        this.dragSplitting = true;
                        this.dragSplittingButton = lllllllllllllIlllIIIIlllllllIIIl;
                        this.dragSplittingSlots.clear();
                        if (lllllllllllllIlllIIIIlllllllIIIl == 0) {
                            this.dragSplittingLimit = 0;
                        }
                        else if (lllllllllllllIlllIIIIlllllllIIIl == 1) {
                            this.dragSplittingLimit = 1;
                        }
                        else if (lllllllllllllIlllIIIIlllllllIIIl == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                            this.dragSplittingLimit = 2;
                        }
                    }
                }
            }
        }
        this.lastClickSlot = lllllllllllllIlllIIIIlllllllllII;
        this.lastClickTime = lllllllllllllIlllIIIIllllllllIll;
        this.lastClickButton = lllllllllllllIlllIIIIlllllllIIIl;
    }
    
    protected void func_191948_b(final int lllllllllllllIlllIIIlIIIIllIllIl, final int lllllllllllllIlllIIIlIIIIllIllII) {
        if (this.mc.player.inventory.getItemStack().func_190926_b() && this.theSlot != null && this.theSlot.getHasStack()) {
            this.renderToolTip(this.theSlot.getStack(), lllllllllllllIlllIIIlIIIIllIllIl, lllllllllllllIlllIIIlIIIIllIllII);
        }
    }
    
    protected boolean isPointInRegion(final int lllllllllllllIlllIIIIllllIIIIIII, final int lllllllllllllIlllIIIIlllIlllllll, final int lllllllllllllIlllIIIIllllIIIIlll, final int lllllllllllllIlllIIIIllllIIIIllI, int lllllllllllllIlllIIIIlllIlllllII, int lllllllllllllIlllIIIIlllIllllIll) {
        final int lllllllllllllIlllIIIIllllIIIIIll = this.guiLeft;
        final int lllllllllllllIlllIIIIllllIIIIIlI = this.guiTop;
        lllllllllllllIlllIIIIlllIlllllII -= (char)lllllllllllllIlllIIIIllllIIIIIll;
        lllllllllllllIlllIIIIlllIllllIll -= lllllllllllllIlllIIIIllllIIIIIlI;
        return lllllllllllllIlllIIIIlllIlllllII >= lllllllllllllIlllIIIIllllIIIIIII - 1 && lllllllllllllIlllIIIIlllIlllllII < lllllllllllllIlllIIIIllllIIIIIII + lllllllllllllIlllIIIIllllIIIIlll + 1 && lllllllllllllIlllIIIIlllIllllIll >= lllllllllllllIlllIIIIlllIlllllll - 1 && lllllllllllllIlllIIIIlllIllllIll < lllllllllllllIlllIIIIlllIlllllll + lllllllllllllIlllIIIIllllIIIIllI + 1;
    }
    
    @Override
    public void updateScreen() {
        super.updateScreen();
        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead) {
            this.mc.player.closeScreen();
        }
    }
    
    protected abstract void drawGuiContainerBackgroundLayer(final float p0, final int p1, final int p2);
    
    private Slot getSlotAtPosition(final int lllllllllllllIlllIIIlIIIIIIlIIlI, final int lllllllllllllIlllIIIlIIIIIIlIllI) {
        for (int lllllllllllllIlllIIIlIIIIIIlIlIl = 0; lllllllllllllIlllIIIlIIIIIIlIlIl < this.inventorySlots.inventorySlots.size(); ++lllllllllllllIlllIIIlIIIIIIlIlIl) {
            final Slot lllllllllllllIlllIIIlIIIIIIlIlII = this.inventorySlots.inventorySlots.get(lllllllllllllIlllIIIlIIIIIIlIlIl);
            if (this.isMouseOverSlot(lllllllllllllIlllIIIlIIIIIIlIlII, lllllllllllllIlllIIIlIIIIIIlIIlI, lllllllllllllIlllIIIlIIIIIIlIllI) && lllllllllllllIlllIIIlIIIIIIlIlII.canBeHovered()) {
                return lllllllllllllIlllIIIlIIIIIIlIlII;
            }
        }
        return null;
    }
    
    @Override
    public void onGuiClosed() {
        if (this.mc.player != null) {
            this.inventorySlots.onContainerClosed(this.mc.player);
        }
    }
    
    protected boolean checkHotbarKeys(final int lllllllllllllIlllIIIIlllIlIllIll) {
        if (this.mc.player.inventory.getItemStack().func_190926_b() && this.theSlot != null) {
            for (int lllllllllllllIlllIIIIlllIlIlllIl = 0; lllllllllllllIlllIIIIlllIlIlllIl < 9; ++lllllllllllllIlllIIIIlllIlIlllIl) {
                if (lllllllllllllIlllIIIIlllIlIllIll == this.mc.gameSettings.keyBindsHotbar[lllllllllllllIlllIIIIlllIlIlllIl].getKeyCode()) {
                    this.handleMouseClick(this.theSlot, this.theSlot.slotNumber, lllllllllllllIlllIIIIlllIlIlllIl, ClickType.SWAP);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public void initGui() {
        super.initGui();
        this.mc.player.openContainer = this.inventorySlots;
        this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        this.scaleA = 0.0;
    }
    
    private void drawSlot(final Slot lllllllllllllIlllIIIlIIIIlIIlIlI) {
        final int lllllllllllllIlllIIIlIIIIlIIlIIl = lllllllllllllIlllIIIlIIIIlIIlIlI.xDisplayPosition;
        final int lllllllllllllIlllIIIlIIIIlIIlIII = lllllllllllllIlllIIIlIIIIlIIlIlI.yDisplayPosition;
        ItemStack lllllllllllllIlllIIIlIIIIlIIIlll = lllllllllllllIlllIIIlIIIIlIIlIlI.getStack();
        boolean lllllllllllllIlllIIIlIIIIlIIIllI = false;
        boolean lllllllllllllIlllIIIlIIIIlIIIlIl = lllllllllllllIlllIIIlIIIIlIIlIlI == this.clickedSlot && !this.draggedStack.func_190926_b() && !this.isRightMouseClick;
        final ItemStack lllllllllllllIlllIIIlIIIIlIIIlII = this.mc.player.inventory.getItemStack();
        String lllllllllllllIlllIIIlIIIIlIIIIll = null;
        if (lllllllllllllIlllIIIlIIIIlIIlIlI == this.clickedSlot && !this.draggedStack.func_190926_b() && this.isRightMouseClick && !lllllllllllllIlllIIIlIIIIlIIIlll.func_190926_b()) {
            lllllllllllllIlllIIIlIIIIlIIIlll = lllllllllllllIlllIIIlIIIIlIIIlll.copy();
            lllllllllllllIlllIIIlIIIIlIIIlll.func_190920_e(lllllllllllllIlllIIIlIIIIlIIIlll.func_190916_E() / 2);
        }
        else if (this.dragSplitting && this.dragSplittingSlots.contains(lllllllllllllIlllIIIlIIIIlIIlIlI) && !lllllllllllllIlllIIIlIIIIlIIIlII.func_190926_b()) {
            if (this.dragSplittingSlots.size() == 1) {
                return;
            }
            if (Container.canAddItemToSlot(lllllllllllllIlllIIIlIIIIlIIlIlI, lllllllllllllIlllIIIlIIIIlIIIlII, true) && this.inventorySlots.canDragIntoSlot(lllllllllllllIlllIIIlIIIIlIIlIlI)) {
                lllllllllllllIlllIIIlIIIIlIIIlll = lllllllllllllIlllIIIlIIIIlIIIlII.copy();
                lllllllllllllIlllIIIlIIIIlIIIllI = true;
                Container.computeStackSize(this.dragSplittingSlots, this.dragSplittingLimit, lllllllllllllIlllIIIlIIIIlIIIlll, lllllllllllllIlllIIIlIIIIlIIlIlI.getStack().func_190926_b() ? 0 : lllllllllllllIlllIIIlIIIIlIIlIlI.getStack().func_190916_E());
                final int lllllllllllllIlllIIIlIIIIlIIIIlI = Math.min(lllllllllllllIlllIIIlIIIIlIIIlll.getMaxStackSize(), lllllllllllllIlllIIIlIIIIlIIlIlI.getItemStackLimit(lllllllllllllIlllIIIlIIIIlIIIlll));
                if (lllllllllllllIlllIIIlIIIIlIIIlll.func_190916_E() > lllllllllllllIlllIIIlIIIIlIIIIlI) {
                    lllllllllllllIlllIIIlIIIIlIIIIll = String.valueOf(new StringBuilder(String.valueOf(TextFormatting.YELLOW.toString())).append(lllllllllllllIlllIIIlIIIIlIIIIlI));
                    lllllllllllllIlllIIIlIIIIlIIIlll.func_190920_e(lllllllllllllIlllIIIlIIIIlIIIIlI);
                }
            }
            else {
                this.dragSplittingSlots.remove(lllllllllllllIlllIIIlIIIIlIIlIlI);
                this.updateDragSplitting();
            }
        }
        this.zLevel = 100.0f;
        this.itemRender.zLevel = 100.0f;
        if (lllllllllllllIlllIIIlIIIIlIIIlll.func_190926_b() && lllllllllllllIlllIIIlIIIIlIIlIlI.canBeHovered()) {
            final String lllllllllllllIlllIIIlIIIIlIIIIIl = lllllllllllllIlllIIIlIIIIlIIlIlI.getSlotTexture();
            if (lllllllllllllIlllIIIlIIIIlIIIIIl != null) {
                final TextureAtlasSprite lllllllllllllIlllIIIlIIIIlIIIIII = this.mc.getTextureMapBlocks().getAtlasSprite(lllllllllllllIlllIIIlIIIIlIIIIIl);
                GlStateManager.disableLighting();
                this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
                this.drawTexturedModalRect(lllllllllllllIlllIIIlIIIIlIIlIIl, lllllllllllllIlllIIIlIIIIlIIlIII, lllllllllllllIlllIIIlIIIIlIIIIII, 16, 16);
                GlStateManager.enableLighting();
                lllllllllllllIlllIIIlIIIIlIIIlIl = true;
            }
        }
        if (!lllllllllllllIlllIIIlIIIIlIIIlIl) {
            if (lllllllllllllIlllIIIlIIIIlIIIllI) {
                Gui.drawRect(lllllllllllllIlllIIIlIIIIlIIlIIl, lllllllllllllIlllIIIlIIIIlIIlIII, lllllllllllllIlllIIIlIIIIlIIlIIl + 16, lllllllllllllIlllIIIlIIIIlIIlIII + 16, -2130706433);
            }
            GlStateManager.enableDepth();
            this.itemRender.renderItemAndEffectIntoGUI(this.mc.player, lllllllllllllIlllIIIlIIIIlIIIlll, lllllllllllllIlllIIIlIIIIlIIlIIl, lllllllllllllIlllIIIlIIIIlIIlIII);
            this.itemRender.renderItemOverlayIntoGUI(this.fontRendererObj, lllllllllllllIlllIIIlIIIIlIIIlll, lllllllllllllIlllIIIlIIIIlIIlIIl, lllllllllllllIlllIIIlIIIIlIIlIII, lllllllllllllIlllIIIlIIIIlIIIIll);
        }
        this.itemRender.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }
    
    protected void handleMouseClick(final Slot lllllllllllllIlllIIIIlllIlllIIlI, int lllllllllllllIlllIIIIlllIllIllII, final int lllllllllllllIlllIIIIlllIllIlIll, final ClickType lllllllllllllIlllIIIIlllIllIllll) {
        if (lllllllllllllIlllIIIIlllIlllIIlI != null) {
            lllllllllllllIlllIIIIlllIllIllII = lllllllllllllIlllIIIIlllIlllIIlI.slotNumber;
        }
        this.mc.playerController.windowClick(this.inventorySlots.windowId, lllllllllllllIlllIIIIlllIllIllII, lllllllllllllIlllIIIIlllIllIlIll, lllllllllllllIlllIIIIlllIllIllll, this.mc.player);
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllllIlllIIIIllllIllIllI, final int lllllllllllllIlllIIIIllllIlIlIII, final int lllllllllllllIlllIIIIllllIlIIlll) {
        final Slot lllllllllllllIlllIIIIllllIllIIll = this.getSlotAtPosition(lllllllllllllIlllIIIIllllIllIllI, lllllllllllllIlllIIIIllllIlIlIII);
        final int lllllllllllllIlllIIIIllllIllIIlI = this.guiLeft;
        final int lllllllllllllIlllIIIIllllIllIIIl = this.guiTop;
        final boolean lllllllllllllIlllIIIIllllIllIIII = this.func_193983_c(lllllllllllllIlllIIIIllllIllIllI, lllllllllllllIlllIIIIllllIlIlIII, lllllllllllllIlllIIIIllllIllIIlI, lllllllllllllIlllIIIIllllIllIIIl);
        int lllllllllllllIlllIIIIllllIlIllll = -1;
        if (lllllllllllllIlllIIIIllllIllIIll != null) {
            lllllllllllllIlllIIIIllllIlIllll = lllllllllllllIlllIIIIllllIllIIll.slotNumber;
        }
        if (lllllllllllllIlllIIIIllllIllIIII) {
            lllllllllllllIlllIIIIllllIlIllll = -999;
        }
        if (this.doubleClick && lllllllllllllIlllIIIIllllIllIIll != null && lllllllllllllIlllIIIIllllIlIIlll == 0 && this.inventorySlots.canMergeSlot(ItemStack.field_190927_a, lllllllllllllIlllIIIIllllIllIIll)) {
            if (isShiftKeyDown()) {
                if (!this.shiftClickedSlot.func_190926_b()) {
                    for (final Slot lllllllllllllIlllIIIIllllIlIlllI : this.inventorySlots.inventorySlots) {
                        if (lllllllllllllIlllIIIIllllIlIlllI != null && lllllllllllllIlllIIIIllllIlIlllI.canTakeStack(this.mc.player) && lllllllllllllIlllIIIIllllIlIlllI.getHasStack() && lllllllllllllIlllIIIIllllIlIlllI.inventory == lllllllllllllIlllIIIIllllIllIIll.inventory && Container.canAddItemToSlot(lllllllllllllIlllIIIIllllIlIlllI, this.shiftClickedSlot, true)) {
                            this.handleMouseClick(lllllllllllllIlllIIIIllllIlIlllI, lllllllllllllIlllIIIIllllIlIlllI.slotNumber, lllllllllllllIlllIIIIllllIlIIlll, ClickType.QUICK_MOVE);
                        }
                    }
                }
            }
            else {
                this.handleMouseClick(lllllllllllllIlllIIIIllllIllIIll, lllllllllllllIlllIIIIllllIlIllll, lllllllllllllIlllIIIIllllIlIIlll, ClickType.PICKUP_ALL);
            }
            this.doubleClick = false;
            this.lastClickTime = 0L;
        }
        else {
            if (this.dragSplitting && this.dragSplittingButton != lllllllllllllIlllIIIIllllIlIIlll) {
                this.dragSplitting = false;
                this.dragSplittingSlots.clear();
                this.ignoreMouseUp = true;
                return;
            }
            if (this.ignoreMouseUp) {
                this.ignoreMouseUp = false;
                return;
            }
            if (this.clickedSlot != null && this.mc.gameSettings.touchscreen) {
                if (lllllllllllllIlllIIIIllllIlIIlll == 0 || lllllllllllllIlllIIIIllllIlIIlll == 1) {
                    if (this.draggedStack.func_190926_b() && lllllllllllllIlllIIIIllllIllIIll != this.clickedSlot) {
                        this.draggedStack = this.clickedSlot.getStack();
                    }
                    final boolean lllllllllllllIlllIIIIllllIlIllIl = Container.canAddItemToSlot(lllllllllllllIlllIIIIllllIllIIll, this.draggedStack, false);
                    if (lllllllllllllIlllIIIIllllIlIllll != -1 && !this.draggedStack.func_190926_b() && lllllllllllllIlllIIIIllllIlIllIl) {
                        this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, lllllllllllllIlllIIIIllllIlIIlll, ClickType.PICKUP);
                        this.handleMouseClick(lllllllllllllIlllIIIIllllIllIIll, lllllllllllllIlllIIIIllllIlIllll, 0, ClickType.PICKUP);
                        if (this.mc.player.inventory.getItemStack().func_190926_b()) {
                            this.returningStack = ItemStack.field_190927_a;
                        }
                        else {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, lllllllllllllIlllIIIIllllIlIIlll, ClickType.PICKUP);
                            this.touchUpX = lllllllllllllIlllIIIIllllIllIllI - lllllllllllllIlllIIIIllllIllIIlI;
                            this.touchUpY = lllllllllllllIlllIIIIllllIlIlIII - lllllllllllllIlllIIIIllllIllIIIl;
                            this.returningStackDestSlot = this.clickedSlot;
                            this.returningStack = this.draggedStack;
                            this.returningStackTime = Minecraft.getSystemTime();
                        }
                    }
                    else if (!this.draggedStack.func_190926_b()) {
                        this.touchUpX = lllllllllllllIlllIIIIllllIllIllI - lllllllllllllIlllIIIIllllIllIIlI;
                        this.touchUpY = lllllllllllllIlllIIIIllllIlIlIII - lllllllllllllIlllIIIIllllIllIIIl;
                        this.returningStackDestSlot = this.clickedSlot;
                        this.returningStack = this.draggedStack;
                        this.returningStackTime = Minecraft.getSystemTime();
                    }
                    this.draggedStack = ItemStack.field_190927_a;
                    this.clickedSlot = null;
                }
            }
            else if (this.dragSplitting && !this.dragSplittingSlots.isEmpty()) {
                this.handleMouseClick(null, -999, Container.getQuickcraftMask(0, this.dragSplittingLimit), ClickType.QUICK_CRAFT);
                for (final Slot lllllllllllllIlllIIIIllllIlIllII : this.dragSplittingSlots) {
                    this.handleMouseClick(lllllllllllllIlllIIIIllllIlIllII, lllllllllllllIlllIIIIllllIlIllII.slotNumber, Container.getQuickcraftMask(1, this.dragSplittingLimit), ClickType.QUICK_CRAFT);
                }
                this.handleMouseClick(null, -999, Container.getQuickcraftMask(2, this.dragSplittingLimit), ClickType.QUICK_CRAFT);
            }
            else if (!this.mc.player.inventory.getItemStack().func_190926_b()) {
                if (lllllllllllllIlllIIIIllllIlIIlll == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100) {
                    this.handleMouseClick(lllllllllllllIlllIIIIllllIllIIll, lllllllllllllIlllIIIIllllIlIllll, lllllllllllllIlllIIIIllllIlIIlll, ClickType.CLONE);
                }
                else {
                    final boolean lllllllllllllIlllIIIIllllIlIlIll = lllllllllllllIlllIIIIllllIlIllll != -999 && (Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54));
                    if (lllllllllllllIlllIIIIllllIlIlIll) {
                        this.shiftClickedSlot = ((lllllllllllllIlllIIIIllllIllIIll != null && lllllllllllllIlllIIIIllllIllIIll.getHasStack()) ? lllllllllllllIlllIIIIllllIllIIll.getStack().copy() : ItemStack.field_190927_a);
                    }
                    this.handleMouseClick(lllllllllllllIlllIIIIllllIllIIll, lllllllllllllIlllIIIIllllIlIllll, lllllllllllllIlllIIIIllllIlIIlll, lllllllllllllIlllIIIIllllIlIlIll ? ClickType.QUICK_MOVE : ClickType.PICKUP);
                }
            }
        }
        if (this.mc.player.inventory.getItemStack().func_190926_b()) {
            this.lastClickTime = 0L;
        }
        this.dragSplitting = false;
    }
    
    protected boolean func_193983_c(final int lllllllllllllIlllIIIIllllllIIIIl, final int lllllllllllllIlllIIIIlllllIllIll, final int lllllllllllllIlllIIIIlllllIlllll, final int lllllllllllllIlllIIIIlllllIllllI) {
        return lllllllllllllIlllIIIIllllllIIIIl < lllllllllllllIlllIIIIlllllIlllll || lllllllllllllIlllIIIIlllllIllIll < lllllllllllllIlllIIIIlllllIllllI || lllllllllllllIlllIIIIllllllIIIIl >= lllllllllllllIlllIIIIlllllIlllll + this.xSize || lllllllllllllIlllIIIIlllllIllIll >= lllllllllllllIlllIIIIlllllIllllI + this.ySize;
    }
    
    @Override
    protected void mouseClickMove(final int lllllllllllllIlllIIIIlllllIIlIII, final int lllllllllllllIlllIIIIlllllIIllll, final int lllllllllllllIlllIIIIlllllIIIllI, final long lllllllllllllIlllIIIIlllllIIllIl) {
        final Slot lllllllllllllIlllIIIIlllllIIllII = this.getSlotAtPosition(lllllllllllllIlllIIIIlllllIIlIII, lllllllllllllIlllIIIIlllllIIllll);
        final ItemStack lllllllllllllIlllIIIIlllllIIlIll = this.mc.player.inventory.getItemStack();
        if (this.clickedSlot != null && this.mc.gameSettings.touchscreen) {
            if (lllllllllllllIlllIIIIlllllIIIllI == 0 || lllllllllllllIlllIIIIlllllIIIllI == 1) {
                if (this.draggedStack.func_190926_b()) {
                    if (lllllllllllllIlllIIIIlllllIIllII != this.clickedSlot && !this.clickedSlot.getStack().func_190926_b()) {
                        this.draggedStack = this.clickedSlot.getStack().copy();
                    }
                }
                else if (this.draggedStack.func_190916_E() > 1 && lllllllllllllIlllIIIIlllllIIllII != null && Container.canAddItemToSlot(lllllllllllllIlllIIIIlllllIIllII, this.draggedStack, false)) {
                    final long lllllllllllllIlllIIIIlllllIIlIlI = Minecraft.getSystemTime();
                    if (this.currentDragTargetSlot == lllllllllllllIlllIIIIlllllIIllII) {
                        if (lllllllllllllIlllIIIIlllllIIlIlI - this.dragItemDropDelay > 500L) {
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, ClickType.PICKUP);
                            this.handleMouseClick(lllllllllllllIlllIIIIlllllIIllII, lllllllllllllIlllIIIIlllllIIllII.slotNumber, 1, ClickType.PICKUP);
                            this.handleMouseClick(this.clickedSlot, this.clickedSlot.slotNumber, 0, ClickType.PICKUP);
                            this.dragItemDropDelay = lllllllllllllIlllIIIIlllllIIlIlI + 750L;
                            this.draggedStack.func_190918_g(1);
                        }
                    }
                    else {
                        this.currentDragTargetSlot = lllllllllllllIlllIIIIlllllIIllII;
                        this.dragItemDropDelay = lllllllllllllIlllIIIIlllllIIlIlI;
                    }
                }
            }
        }
        else if (this.dragSplitting && lllllllllllllIlllIIIIlllllIIllII != null && !lllllllllllllIlllIIIIlllllIIlIll.func_190926_b() && (lllllllllllllIlllIIIIlllllIIlIll.func_190916_E() > this.dragSplittingSlots.size() || this.dragSplittingLimit == 2) && Container.canAddItemToSlot(lllllllllllllIlllIIIIlllllIIllII, lllllllllllllIlllIIIIlllllIIlIll, true) && lllllllllllllIlllIIIIlllllIIllII.isItemValid(lllllllllllllIlllIIIIlllllIIlIll) && this.inventorySlots.canDragIntoSlot(lllllllllllllIlllIIIIlllllIIllII)) {
            this.dragSplittingSlots.add(lllllllllllllIlllIIIIlllllIIllII);
            this.updateDragSplitting();
        }
    }
    
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIlllIIIlIIIIlIllIII, final int lllllllllllllIlllIIIlIIIIlIlIlll) {
    }
    
    public GuiContainer(final Container lllllllllllllIlllIIIlIIIlIlIlIIl) {
        this.xSize = 176;
        this.ySize = 166;
        this.draggedStack = ItemStack.field_190927_a;
        this.returningStack = ItemStack.field_190927_a;
        this.dragSplittingSlots = (Set<Slot>)Sets.newHashSet();
        this.shiftClickedSlot = ItemStack.field_190927_a;
        this.inventorySlots = lllllllllllllIlllIIIlIIIlIlIlIIl;
        this.ignoreMouseUp = true;
    }
}
