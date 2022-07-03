package net.minecraft.client.gui;

import net.minecraft.client.gui.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.resources.*;
import java.io.*;
import org.lwjgl.input.*;
import net.minecraft.world.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import io.netty.buffer.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.*;

public class GuiRepair extends GuiContainer implements IContainerListener
{
    private /* synthetic */ GuiTextField nameField;
    private final /* synthetic */ ContainerRepair anvil;
    private static final /* synthetic */ ResourceLocation ANVIL_RESOURCE;
    private final /* synthetic */ InventoryPlayer playerInventory;
    
    static {
        ANVIL_RESOURCE = new ResourceLocation("textures/gui/container/anvil.png");
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIlllIllIlllIlIIIllI, final int lllllllllllllIlllIllIlllIlIIIlIl) {
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        this.fontRendererObj.drawString(I18n.format("container.repair", new Object[0]), 60.0, 6.0, 4210752);
        if (this.anvil.maximumCost > 0) {
            int lllllllllllllIlllIllIlllIlIIIlII = 8453920;
            boolean lllllllllllllIlllIllIlllIlIIIIll = true;
            String lllllllllllllIlllIllIlllIlIIIIlI = I18n.format("container.repair.cost", this.anvil.maximumCost);
            if (this.anvil.maximumCost >= 40 && !this.mc.player.capabilities.isCreativeMode) {
                lllllllllllllIlllIllIlllIlIIIIlI = I18n.format("container.repair.expensive", new Object[0]);
                lllllllllllllIlllIllIlllIlIIIlII = 16736352;
            }
            else if (!this.anvil.getSlot(2).getHasStack()) {
                lllllllllllllIlllIllIlllIlIIIIll = false;
            }
            else if (!this.anvil.getSlot(2).canTakeStack(this.playerInventory.player)) {
                lllllllllllllIlllIllIlllIlIIIlII = 16736352;
            }
            if (lllllllllllllIlllIllIlllIlIIIIll) {
                final int lllllllllllllIlllIllIlllIlIIIIIl = 0xFF000000 | (lllllllllllllIlllIllIlllIlIIIlII & 0xFCFCFC) >> 2 | (lllllllllllllIlllIllIlllIlIIIlII & 0xFF000000);
                final int lllllllllllllIlllIllIlllIlIIIIII = this.xSize - 8 - this.fontRendererObj.getStringWidth(lllllllllllllIlllIllIlllIlIIIIlI);
                final int lllllllllllllIlllIllIlllIIllllll = 67;
                if (this.fontRendererObj.getUnicodeFlag()) {
                    Gui.drawRect(lllllllllllllIlllIllIlllIlIIIIII - 3, 65.0, this.xSize - 7, 77.0, -16777216);
                    Gui.drawRect(lllllllllllllIlllIllIlllIlIIIIII - 2, 66.0, this.xSize - 8, 76.0, -12895429);
                }
                else {
                    this.fontRendererObj.drawString(lllllllllllllIlllIllIlllIlIIIIlI, lllllllllllllIlllIllIlllIlIIIIII, 68.0, lllllllllllllIlllIllIlllIlIIIIIl);
                    this.fontRendererObj.drawString(lllllllllllllIlllIllIlllIlIIIIlI, lllllllllllllIlllIllIlllIlIIIIII + 1, 67.0, lllllllllllllIlllIllIlllIlIIIIIl);
                    this.fontRendererObj.drawString(lllllllllllllIlllIllIlllIlIIIIlI, lllllllllllllIlllIllIlllIlIIIIII + 1, 68.0, lllllllllllllIlllIllIlllIlIIIIIl);
                }
                this.fontRendererObj.drawString(lllllllllllllIlllIllIlllIlIIIIlI, lllllllllllllIlllIllIlllIlIIIIII, 67.0, lllllllllllllIlllIllIlllIlIIIlII);
            }
        }
        GlStateManager.enableLighting();
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIlllIllIlllIIllIIll, final int lllllllllllllIlllIllIlllIIllIIlI) throws IOException {
        if (this.nameField.textboxKeyTyped(lllllllllllllIlllIllIlllIIllIIll, lllllllllllllIlllIllIlllIIllIIlI)) {
            this.renameItem();
        }
        else {
            super.keyTyped(lllllllllllllIlllIllIlllIIllIIll, lllllllllllllIlllIllIlllIIllIIlI);
        }
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIlllIllIlllIIlIIIII, final int lllllllllllllIlllIllIlllIIIlllll, final int lllllllllllllIlllIllIlllIIIllIlI) throws IOException {
        super.mouseClicked(lllllllllllllIlllIllIlllIIlIIIII, lllllllllllllIlllIllIlllIIIlllll, lllllllllllllIlllIllIlllIIIllIlI);
        this.nameField.mouseClicked(lllllllllllllIlllIllIlllIIlIIIII, lllllllllllllIlllIllIlllIIIlllll, lllllllllllllIlllIllIlllIIIllIlI);
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
        this.inventorySlots.removeListener(this);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIlllIllIlllIIIIlIIl, final int lllllllllllllIlllIllIlllIIIIlIII, final int lllllllllllllIlllIllIlllIIIIIlll) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GuiRepair.ANVIL_RESOURCE);
        final int lllllllllllllIlllIllIlllIIIIIllI = (this.width - this.xSize) / 2;
        final int lllllllllllllIlllIllIlllIIIIIlIl = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(lllllllllllllIlllIllIlllIIIIIllI, lllllllllllllIlllIllIlllIIIIIlIl, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(lllllllllllllIlllIllIlllIIIIIllI + 59, lllllllllllllIlllIllIlllIIIIIlIl + 20, 0, this.ySize + (this.anvil.getSlot(0).getHasStack() ? 0 : 16), 110, 16);
        if ((this.anvil.getSlot(0).getHasStack() || this.anvil.getSlot(1).getHasStack()) && !this.anvil.getSlot(2).getHasStack()) {
            this.drawTexturedModalRect(lllllllllllllIlllIllIlllIIIIIllI + 99, lllllllllllllIlllIllIlllIIIIIlIl + 45, this.xSize, 0, 28, 21);
        }
    }
    
    @Override
    public void initGui() {
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        final int lllllllllllllIlllIllIlllIlIlIllI = (this.width - this.xSize) / 2;
        final int lllllllllllllIlllIllIlllIlIlIlIl = (this.height - this.ySize) / 2;
        this.nameField = new GuiTextField(0, this.fontRendererObj, lllllllllllllIlllIllIlllIlIlIllI + 62, lllllllllllllIlllIllIlllIlIlIlIl + 24, 103, 12);
        this.nameField.setTextColor(-1);
        this.nameField.setDisabledTextColour(-1);
        this.nameField.setEnableBackgroundDrawing(false);
        this.nameField.setMaxStringLength(35);
        this.inventorySlots.removeListener(this);
        this.inventorySlots.addListener(this);
    }
    
    @Override
    public void sendAllWindowProperties(final Container lllllllllllllIlllIllIllIlllIlIll, final IInventory lllllllllllllIlllIllIllIlllIlIlI) {
    }
    
    public GuiRepair(final InventoryPlayer lllllllllllllIlllIllIlllIlIlllII, final World lllllllllllllIlllIllIlllIlIllIll) {
        super(new ContainerRepair(lllllllllllllIlllIllIlllIlIlllII, lllllllllllllIlllIllIlllIlIllIll, Minecraft.getMinecraft().player));
        this.playerInventory = lllllllllllllIlllIllIlllIlIlllII;
        this.anvil = (ContainerRepair)this.inventorySlots;
    }
    
    private void renameItem() {
        String lllllllllllllIlllIllIlllIIlIlIlI = this.nameField.getText();
        final Slot lllllllllllllIlllIllIlllIIlIlIIl = this.anvil.getSlot(0);
        if (lllllllllllllIlllIllIlllIIlIlIIl != null && lllllllllllllIlllIllIlllIIlIlIIl.getHasStack() && !lllllllllllllIlllIllIlllIIlIlIIl.getStack().hasDisplayName() && lllllllllllllIlllIllIlllIIlIlIlI.equals(lllllllllllllIlllIllIlllIIlIlIIl.getStack().getDisplayName())) {
            lllllllllllllIlllIllIlllIIlIlIlI = "";
        }
        this.anvil.updateItemName(lllllllllllllIlllIllIlllIIlIlIlI);
        this.mc.player.connection.sendPacket(new CPacketCustomPayload("MC|ItemName", new PacketBuffer(Unpooled.buffer()).writeString(lllllllllllllIlllIllIlllIIlIlIlI)));
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIlllIllIlllIIIlIlII, final int lllllllllllllIlllIllIlllIIIlIIll, final float lllllllllllllIlllIllIlllIIIlIIlI) {
        this.drawDefaultBackground();
        super.drawScreen(lllllllllllllIlllIllIlllIIIlIlII, lllllllllllllIlllIllIlllIIIlIIll, lllllllllllllIlllIllIlllIIIlIIlI);
        this.func_191948_b(lllllllllllllIlllIllIlllIIIlIlII, lllllllllllllIlllIllIlllIIIlIIll);
        GlStateManager.disableLighting();
        GlStateManager.disableBlend();
        this.nameField.drawTextBox();
    }
    
    @Override
    public void sendSlotContents(final Container lllllllllllllIlllIllIllIllllIllI, final int lllllllllllllIlllIllIllIllllIlIl, final ItemStack lllllllllllllIlllIllIllIllllIlII) {
        if (lllllllllllllIlllIllIllIllllIlIl == 0) {
            this.nameField.setText(lllllllllllllIlllIllIllIllllIlII.func_190926_b() ? "" : lllllllllllllIlllIllIllIllllIlII.getDisplayName());
            this.nameField.setEnabled(!lllllllllllllIlllIllIllIllllIlII.func_190926_b());
            if (!lllllllllllllIlllIllIllIllllIlII.func_190926_b()) {
                this.renameItem();
            }
        }
    }
    
    @Override
    public void updateCraftingInventory(final Container lllllllllllllIlllIllIllIlllllllI, final NonNullList<ItemStack> lllllllllllllIlllIllIllIllllllIl) {
        this.sendSlotContents(lllllllllllllIlllIllIllIlllllllI, 0, lllllllllllllIlllIllIllIlllllllI.getSlot(0).getStack());
    }
    
    @Override
    public void sendProgressBarUpdate(final Container lllllllllllllIlllIllIllIlllIllll, final int lllllllllllllIlllIllIllIlllIlllI, final int lllllllllllllIlllIllIllIlllIllIl) {
    }
}
