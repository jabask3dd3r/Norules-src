package net.minecraft.client.gui.inventory;

import net.minecraft.creativetab.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.achievement.*;
import java.io.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.settings.*;
import org.lwjgl.input.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.text.*;
import net.minecraft.client.resources.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.client.util.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.inventory.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public class GuiContainerCreative extends InventoryEffectRenderer
{
    private static /* synthetic */ int selectedTabIndex;
    private /* synthetic */ List<Slot> originalSlots;
    private /* synthetic */ CreativeCrafting listener;
    private /* synthetic */ boolean wasClicking;
    private static final /* synthetic */ InventoryBasic basicInventory;
    private /* synthetic */ GuiTextField searchField;
    private static final /* synthetic */ ResourceLocation CREATIVE_INVENTORY_TABS;
    private /* synthetic */ float currentScroll;
    private /* synthetic */ boolean isScrolling;
    private /* synthetic */ Slot destroyItemSlot;
    private /* synthetic */ boolean clearSearch;
    
    @Override
    public void initGui() {
        if (this.mc.playerController.isInCreativeMode()) {
            super.initGui();
            this.buttonList.clear();
            Keyboard.enableRepeatEvents(true);
            this.searchField = new GuiTextField(0, this.fontRendererObj, this.guiLeft + 82, this.guiTop + 6, 80, this.fontRendererObj.FONT_HEIGHT);
            this.searchField.setMaxStringLength(50);
            this.searchField.setEnableBackgroundDrawing(false);
            this.searchField.setVisible(false);
            this.searchField.setTextColor(16777215);
            final int lllllllllllllIllIIIllIlIIlllllll = GuiContainerCreative.selectedTabIndex;
            GuiContainerCreative.selectedTabIndex = -1;
            this.setCurrentCreativeTab(CreativeTabs.CREATIVE_TAB_ARRAY[lllllllllllllIllIIIllIlIIlllllll]);
            this.listener = new CreativeCrafting(this.mc);
            this.mc.player.inventoryContainer.addListener(this.listener);
        }
        else {
            this.mc.displayGuiScreen(new GuiInventory(this.mc.player));
        }
    }
    
    @Override
    protected void actionPerformed(final GuiButton lllllllllllllIllIIIllIIlIlIIIIIl) throws IOException {
        if (lllllllllllllIllIIIllIIlIlIIIIIl.id == 1) {
            this.mc.displayGuiScreen(new GuiStats(this, this.mc.player.getStatFileWriter()));
        }
    }
    
    static {
        CREATIVE_INVENTORY_TABS = new ResourceLocation("textures/gui/container/creative_inventory/tabs.png");
        basicInventory = new InventoryBasic("tmp", true, 45);
        GuiContainerCreative.selectedTabIndex = CreativeTabs.BUILDING_BLOCKS.getTabIndex();
    }
    
    public static void func_192044_a(final Minecraft lllllllllllllIllIIIllIIlIIllIlII, final int lllllllllllllIllIIIllIIlIIlIIlll, final boolean lllllllllllllIllIIIllIIlIIllIIlI, final boolean lllllllllllllIllIIIllIIlIIlIIlIl) {
        final EntityPlayerSP lllllllllllllIllIIIllIIlIIllIIII = lllllllllllllIllIIIllIIlIIllIlII.player;
        final CreativeSettings lllllllllllllIllIIIllIIlIIlIllll = lllllllllllllIllIIIllIIlIIllIlII.field_191950_u;
        final HotbarSnapshot lllllllllllllIllIIIllIIlIIlIlllI = lllllllllllllIllIIIllIIlIIlIllll.func_192563_a(lllllllllllllIllIIIllIIlIIlIIlll);
        if (lllllllllllllIllIIIllIIlIIllIIlI) {
            for (int lllllllllllllIllIIIllIIlIIlIllIl = 0; lllllllllllllIllIIIllIIlIIlIllIl < InventoryPlayer.getHotbarSize(); ++lllllllllllllIllIIIllIIlIIlIllIl) {
                final ItemStack lllllllllllllIllIIIllIIlIIlIllII = lllllllllllllIllIIIllIIlIIlIlllI.get(lllllllllllllIllIIIllIIlIIlIllIl).copy();
                lllllllllllllIllIIIllIIlIIllIIII.inventory.setInventorySlotContents(lllllllllllllIllIIIllIIlIIlIllIl, lllllllllllllIllIIIllIIlIIlIllII);
                lllllllllllllIllIIIllIIlIIllIlII.playerController.sendSlotPacket(lllllllllllllIllIIIllIIlIIlIllII, 36 + lllllllllllllIllIIIllIIlIIlIllIl);
            }
            lllllllllllllIllIIIllIIlIIllIIII.inventoryContainer.detectAndSendChanges();
        }
        else if (lllllllllllllIllIIIllIIlIIlIIlIl) {
            for (int lllllllllllllIllIIIllIIlIIlIlIll = 0; lllllllllllllIllIIIllIIlIIlIlIll < InventoryPlayer.getHotbarSize(); ++lllllllllllllIllIIIllIIlIIlIlIll) {
                lllllllllllllIllIIIllIIlIIlIlllI.set(lllllllllllllIllIIIllIIlIIlIlIll, lllllllllllllIllIIIllIIlIIllIIII.inventory.getStackInSlot(lllllllllllllIllIIIllIIlIIlIlIll).copy());
            }
            final String lllllllllllllIllIIIllIIlIIlIlIlI = GameSettings.getKeyDisplayString(lllllllllllllIllIIIllIIlIIllIlII.gameSettings.keyBindsHotbar[lllllllllllllIllIIIllIIlIIlIIlll].getKeyCode());
            final String lllllllllllllIllIIIllIIlIIlIlIIl = GameSettings.getKeyDisplayString(lllllllllllllIllIIIllIIlIIllIlII.gameSettings.field_193630_aq.getKeyCode());
            lllllllllllllIllIIIllIIlIIllIlII.ingameGUI.setRecordPlaying(new TextComponentTranslation("inventory.hotbarSaved", new Object[] { lllllllllllllIllIIIllIIlIIlIlIIl, lllllllllllllIllIIIllIIlIIlIlIlI }), false);
            lllllllllllllIllIIIllIIlIIlIllll.func_192564_b();
        }
    }
    
    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int lllllllllllllIllIIIllIIllllllIIl = Mouse.getEventDWheel();
        if (lllllllllllllIllIIIllIIllllllIIl != 0 && this.needsScrollBars()) {
            final int lllllllllllllIllIIIllIIllllllIII = (((ContainerCreative)this.inventorySlots).itemList.size() + 9 - 1) / 9 - 5;
            if (lllllllllllllIllIIIllIIllllllIIl > 0) {
                lllllllllllllIllIIIllIIllllllIIl = 1;
            }
            if (lllllllllllllIllIIIllIIllllllIIl < 0) {
                lllllllllllllIllIIIllIIllllllIIl = -1;
            }
            this.currentScroll -= (float)(lllllllllllllIllIIIllIIllllllIIl / (double)lllllllllllllIllIIIllIIllllllIII);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0f, 1.0f);
            ((ContainerCreative)this.inventorySlots).scrollTo(this.currentScroll);
        }
    }
    
    public int getSelectedTabIndex() {
        return GuiContainerCreative.selectedTabIndex;
    }
    
    public GuiContainerCreative(final EntityPlayer lllllllllllllIllIIIllIlIlIlllIII) {
        super(new ContainerCreative(lllllllllllllIllIIIllIlIlIlllIII));
        lllllllllllllIllIIIllIlIlIlllIII.openContainer = this.inventorySlots;
        this.allowUserInput = true;
        this.ySize = 136;
        this.xSize = 195;
    }
    
    @Override
    protected void keyTyped(final char lllllllllllllIllIIIllIlIIlllIlIl, final int lllllllllllllIllIIIllIlIIlllIIIl) throws IOException {
        if (GuiContainerCreative.selectedTabIndex != CreativeTabs.SEARCH.getTabIndex()) {
            if (GameSettings.isKeyDown(this.mc.gameSettings.keyBindChat)) {
                this.setCurrentCreativeTab(CreativeTabs.SEARCH);
            }
            else {
                super.keyTyped(lllllllllllllIllIIIllIlIIlllIlIl, lllllllllllllIllIIIllIlIIlllIIIl);
            }
        }
        else {
            if (this.clearSearch) {
                this.clearSearch = false;
                this.searchField.setText("");
            }
            if (!this.checkHotbarKeys(lllllllllllllIllIIIllIlIIlllIIIl)) {
                if (this.searchField.textboxKeyTyped(lllllllllllllIllIIIllIlIIlllIlIl, lllllllllllllIllIIIllIlIIlllIIIl)) {
                    this.updateCreativeSearch();
                }
                else {
                    super.keyTyped(lllllllllllllIllIIIllIlIIlllIlIl, lllllllllllllIllIIIllIlIIlllIIIl);
                }
            }
        }
    }
    
    @Override
    protected void renderToolTip(final ItemStack lllllllllllllIllIIIllIIllIllllIl, final int lllllllllllllIllIIIllIIllIllIIlI, final int lllllllllllllIllIIIllIIllIlllIll) {
        if (GuiContainerCreative.selectedTabIndex == CreativeTabs.SEARCH.getTabIndex()) {
            final List<String> lllllllllllllIllIIIllIIllIlllIlI = lllllllllllllIllIIIllIIllIllllIl.getTooltip(this.mc.player, this.mc.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL);
            CreativeTabs lllllllllllllIllIIIllIIllIlllIIl = lllllllllllllIllIIIllIIllIllllIl.getItem().getCreativeTab();
            if (lllllllllllllIllIIIllIIllIlllIIl == null && lllllllllllllIllIIIllIIllIllllIl.getItem() == Items.ENCHANTED_BOOK) {
                final Map<Enchantment, Integer> lllllllllllllIllIIIllIIllIlllIII = EnchantmentHelper.getEnchantments(lllllllllllllIllIIIllIIllIllllIl);
                if (lllllllllllllIllIIIllIIllIlllIII.size() == 1) {
                    final Enchantment lllllllllllllIllIIIllIIllIllIlll = lllllllllllllIllIIIllIIllIlllIII.keySet().iterator().next();
                    final String lllllllllllllIllIIIllIIllIlIlIIl;
                    final int lllllllllllllIllIIIllIIllIlIlIlI = ((CreativeTabs[])(Object)(lllllllllllllIllIIIllIIllIlIlIIl = (String)(Object)CreativeTabs.CREATIVE_TAB_ARRAY)).length;
                    for (float lllllllllllllIllIIIllIIllIlIlIll = 0; lllllllllllllIllIIIllIIllIlIlIll < lllllllllllllIllIIIllIIllIlIlIlI; ++lllllllllllllIllIIIllIIllIlIlIll) {
                        final CreativeTabs lllllllllllllIllIIIllIIllIllIllI = lllllllllllllIllIIIllIIllIlIlIIl[lllllllllllllIllIIIllIIllIlIlIll];
                        if (lllllllllllllIllIIIllIIllIllIllI.hasRelevantEnchantmentType(lllllllllllllIllIIIllIIllIllIlll.type)) {
                            lllllllllllllIllIIIllIIllIlllIIl = lllllllllllllIllIIIllIIllIllIllI;
                            break;
                        }
                    }
                }
            }
            if (lllllllllllllIllIIIllIIllIlllIIl != null) {
                lllllllllllllIllIIIllIIllIlllIlI.add(1, String.valueOf(new StringBuilder().append(TextFormatting.BOLD).append(TextFormatting.BLUE).append(I18n.format(lllllllllllllIllIIIllIIllIlllIIl.getTranslatedTabLabel(), new Object[0]))));
            }
            for (int lllllllllllllIllIIIllIIllIllIlIl = 0; lllllllllllllIllIIIllIIllIllIlIl < lllllllllllllIllIIIllIIllIlllIlI.size(); ++lllllllllllllIllIIIllIIllIllIlIl) {
                if (lllllllllllllIllIIIllIIllIllIlIl == 0) {
                    lllllllllllllIllIIIllIIllIlllIlI.set(lllllllllllllIllIIIllIIllIllIlIl, String.valueOf(new StringBuilder().append(lllllllllllllIllIIIllIIllIllllIl.getRarity().rarityColor).append(lllllllllllllIllIIIllIIllIlllIlI.get(lllllllllllllIllIIIllIIllIllIlIl))));
                }
                else {
                    lllllllllllllIllIIIllIIllIlllIlI.set(lllllllllllllIllIIIllIIllIllIlIl, String.valueOf(new StringBuilder().append(TextFormatting.GRAY).append(lllllllllllllIllIIIllIIllIlllIlI.get(lllllllllllllIllIIIllIIllIllIlIl))));
                }
            }
            this.drawHoveringText(lllllllllllllIllIIIllIIllIlllIlI, lllllllllllllIllIIIllIIllIllIIlI, lllllllllllllIllIIIllIIllIlllIll);
        }
        else {
            super.renderToolTip(lllllllllllllIllIIIllIIllIllllIl, lllllllllllllIllIIIllIIllIllIIlI, lllllllllllllIllIIIllIIllIlllIll);
        }
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(final int lllllllllllllIllIIIllIlIIllIIIlI, final int lllllllllllllIllIIIllIlIIllIIIIl) {
        final CreativeTabs lllllllllllllIllIIIllIlIIllIIIII = CreativeTabs.CREATIVE_TAB_ARRAY[GuiContainerCreative.selectedTabIndex];
        if (lllllllllllllIllIIIllIlIIllIIIII.drawInForegroundOfTab()) {
            GlStateManager.disableBlend();
            this.fontRendererObj.drawString(I18n.format(lllllllllllllIllIIIllIlIIllIIIII.getTranslatedTabLabel(), new Object[0]), 8.0, 6.0, 4210752);
        }
    }
    
    @Override
    protected void handleMouseClick(@Nullable final Slot lllllllllllllIllIIIllIlIlIlIIlll, final int lllllllllllllIllIIIllIlIlIIlIIII, final int lllllllllllllIllIIIllIlIlIlIIlIl, ClickType lllllllllllllIllIIIllIlIlIIIlllI) {
        this.clearSearch = true;
        final boolean lllllllllllllIllIIIllIlIlIlIIIll = lllllllllllllIllIIIllIlIlIIIlllI == ClickType.QUICK_MOVE;
        lllllllllllllIllIIIllIlIlIIIlllI = ((lllllllllllllIllIIIllIlIlIIlIIII == -999 && lllllllllllllIllIIIllIlIlIIIlllI == ClickType.PICKUP) ? ClickType.THROW : lllllllllllllIllIIIllIlIlIIIlllI);
        if (lllllllllllllIllIIIllIlIlIlIIlll == null && GuiContainerCreative.selectedTabIndex != CreativeTabs.INVENTORY.getTabIndex() && lllllllllllllIllIIIllIlIlIIIlllI != ClickType.QUICK_CRAFT) {
            final InventoryPlayer lllllllllllllIllIIIllIlIlIlIIIlI = this.mc.player.inventory;
            if (!lllllllllllllIllIIIllIlIlIlIIIlI.getItemStack().func_190926_b()) {
                if (lllllllllllllIllIIIllIlIlIlIIlIl == 0) {
                    this.mc.player.dropItem(lllllllllllllIllIIIllIlIlIlIIIlI.getItemStack(), true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllllIllIIIllIlIlIlIIIlI.getItemStack());
                    lllllllllllllIllIIIllIlIlIlIIIlI.setItemStack(ItemStack.field_190927_a);
                }
                if (lllllllllllllIllIIIllIlIlIlIIlIl == 1) {
                    final ItemStack lllllllllllllIllIIIllIlIlIlIIIIl = lllllllllllllIllIIIllIlIlIlIIIlI.getItemStack().splitStack(1);
                    this.mc.player.dropItem(lllllllllllllIllIIIllIlIlIlIIIIl, true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllllIllIIIllIlIlIlIIIIl);
                }
            }
        }
        else {
            if (lllllllllllllIllIIIllIlIlIlIIlll != null && !lllllllllllllIllIIIllIlIlIlIIlll.canTakeStack(this.mc.player)) {
                return;
            }
            if (lllllllllllllIllIIIllIlIlIlIIlll == this.destroyItemSlot && lllllllllllllIllIIIllIlIlIlIIIll) {
                for (int lllllllllllllIllIIIllIlIlIlIIIII = 0; lllllllllllllIllIIIllIlIlIlIIIII < this.mc.player.inventoryContainer.getInventory().size(); ++lllllllllllllIllIIIllIlIlIlIIIII) {
                    this.mc.playerController.sendSlotPacket(ItemStack.field_190927_a, lllllllllllllIllIIIllIlIlIlIIIII);
                }
            }
            else if (GuiContainerCreative.selectedTabIndex == CreativeTabs.INVENTORY.getTabIndex()) {
                if (lllllllllllllIllIIIllIlIlIlIIlll == this.destroyItemSlot) {
                    this.mc.player.inventory.setItemStack(ItemStack.field_190927_a);
                }
                else if (lllllllllllllIllIIIllIlIlIIIlllI == ClickType.THROW && lllllllllllllIllIIIllIlIlIlIIlll != null && lllllllllllllIllIIIllIlIlIlIIlll.getHasStack()) {
                    final ItemStack lllllllllllllIllIIIllIlIlIIlllll = lllllllllllllIllIIIllIlIlIlIIlll.decrStackSize((lllllllllllllIllIIIllIlIlIlIIlIl == 0) ? 1 : lllllllllllllIllIIIllIlIlIlIIlll.getStack().getMaxStackSize());
                    final ItemStack lllllllllllllIllIIIllIlIlIIllllI = lllllllllllllIllIIIllIlIlIlIIlll.getStack();
                    this.mc.player.dropItem(lllllllllllllIllIIIllIlIlIIlllll, true);
                    this.mc.playerController.sendPacketDropItem(lllllllllllllIllIIIllIlIlIIlllll);
                    this.mc.playerController.sendSlotPacket(lllllllllllllIllIIIllIlIlIIllllI, ((CreativeSlot)lllllllllllllIllIIIllIlIlIlIIlll).slot.slotNumber);
                }
                else if (lllllllllllllIllIIIllIlIlIIIlllI == ClickType.THROW && !this.mc.player.inventory.getItemStack().func_190926_b()) {
                    this.mc.player.dropItem(this.mc.player.inventory.getItemStack(), true);
                    this.mc.playerController.sendPacketDropItem(this.mc.player.inventory.getItemStack());
                    this.mc.player.inventory.setItemStack(ItemStack.field_190927_a);
                }
                else {
                    this.mc.player.inventoryContainer.slotClick((lllllllllllllIllIIIllIlIlIlIIlll == null) ? lllllllllllllIllIIIllIlIlIIlIIII : ((CreativeSlot)lllllllllllllIllIIIllIlIlIlIIlll).slot.slotNumber, lllllllllllllIllIIIllIlIlIlIIlIl, lllllllllllllIllIIIllIlIlIIIlllI, this.mc.player);
                    this.mc.player.inventoryContainer.detectAndSendChanges();
                }
            }
            else if (lllllllllllllIllIIIllIlIlIIIlllI != ClickType.QUICK_CRAFT && lllllllllllllIllIIIllIlIlIlIIlll.inventory == GuiContainerCreative.basicInventory) {
                final InventoryPlayer lllllllllllllIllIIIllIlIlIIlllIl = this.mc.player.inventory;
                ItemStack lllllllllllllIllIIIllIlIlIIlllII = lllllllllllllIllIIIllIlIlIIlllIl.getItemStack();
                final ItemStack lllllllllllllIllIIIllIlIlIIllIll = lllllllllllllIllIIIllIlIlIlIIlll.getStack();
                if (lllllllllllllIllIIIllIlIlIIIlllI == ClickType.SWAP) {
                    if (!lllllllllllllIllIIIllIlIlIIllIll.func_190926_b() && lllllllllllllIllIIIllIlIlIlIIlIl >= 0 && lllllllllllllIllIIIllIlIlIlIIlIl < 9) {
                        final ItemStack lllllllllllllIllIIIllIlIlIIllIlI = lllllllllllllIllIIIllIlIlIIllIll.copy();
                        lllllllllllllIllIIIllIlIlIIllIlI.func_190920_e(lllllllllllllIllIIIllIlIlIIllIlI.getMaxStackSize());
                        this.mc.player.inventory.setInventorySlotContents(lllllllllllllIllIIIllIlIlIlIIlIl, lllllllllllllIllIIIllIlIlIIllIlI);
                        this.mc.player.inventoryContainer.detectAndSendChanges();
                    }
                    return;
                }
                if (lllllllllllllIllIIIllIlIlIIIlllI == ClickType.CLONE) {
                    if (lllllllllllllIllIIIllIlIlIIlllIl.getItemStack().func_190926_b() && lllllllllllllIllIIIllIlIlIlIIlll.getHasStack()) {
                        final ItemStack lllllllllllllIllIIIllIlIlIIllIIl = lllllllllllllIllIIIllIlIlIlIIlll.getStack().copy();
                        lllllllllllllIllIIIllIlIlIIllIIl.func_190920_e(lllllllllllllIllIIIllIlIlIIllIIl.getMaxStackSize());
                        lllllllllllllIllIIIllIlIlIIlllIl.setItemStack(lllllllllllllIllIIIllIlIlIIllIIl);
                    }
                    return;
                }
                if (lllllllllllllIllIIIllIlIlIIIlllI == ClickType.THROW) {
                    if (!lllllllllllllIllIIIllIlIlIIllIll.func_190926_b()) {
                        final ItemStack lllllllllllllIllIIIllIlIlIIllIII = lllllllllllllIllIIIllIlIlIIllIll.copy();
                        lllllllllllllIllIIIllIlIlIIllIII.func_190920_e((lllllllllllllIllIIIllIlIlIlIIlIl == 0) ? 1 : lllllllllllllIllIIIllIlIlIIllIII.getMaxStackSize());
                        this.mc.player.dropItem(lllllllllllllIllIIIllIlIlIIllIII, true);
                        this.mc.playerController.sendPacketDropItem(lllllllllllllIllIIIllIlIlIIllIII);
                    }
                    return;
                }
                if (!lllllllllllllIllIIIllIlIlIIlllII.func_190926_b() && !lllllllllllllIllIIIllIlIlIIllIll.func_190926_b() && lllllllllllllIllIIIllIlIlIIlllII.isItemEqual(lllllllllllllIllIIIllIlIlIIllIll) && ItemStack.areItemStackTagsEqual(lllllllllllllIllIIIllIlIlIIlllII, lllllllllllllIllIIIllIlIlIIllIll)) {
                    if (lllllllllllllIllIIIllIlIlIlIIlIl == 0) {
                        if (lllllllllllllIllIIIllIlIlIlIIIll) {
                            lllllllllllllIllIIIllIlIlIIlllII.func_190920_e(lllllllllllllIllIIIllIlIlIIlllII.getMaxStackSize());
                        }
                        else if (lllllllllllllIllIIIllIlIlIIlllII.func_190916_E() < lllllllllllllIllIIIllIlIlIIlllII.getMaxStackSize()) {
                            lllllllllllllIllIIIllIlIlIIlllII.func_190917_f(1);
                        }
                    }
                    else {
                        lllllllllllllIllIIIllIlIlIIlllII.func_190918_g(1);
                    }
                }
                else if (!lllllllllllllIllIIIllIlIlIIllIll.func_190926_b() && lllllllllllllIllIIIllIlIlIIlllII.func_190926_b()) {
                    lllllllllllllIllIIIllIlIlIIlllIl.setItemStack(lllllllllllllIllIIIllIlIlIIllIll.copy());
                    lllllllllllllIllIIIllIlIlIIlllII = lllllllllllllIllIIIllIlIlIIlllIl.getItemStack();
                    if (lllllllllllllIllIIIllIlIlIlIIIll) {
                        lllllllllllllIllIIIllIlIlIIlllII.func_190920_e(lllllllllllllIllIIIllIlIlIIlllII.getMaxStackSize());
                    }
                }
                else if (lllllllllllllIllIIIllIlIlIlIIlIl == 0) {
                    lllllllllllllIllIIIllIlIlIIlllIl.setItemStack(ItemStack.field_190927_a);
                }
                else {
                    lllllllllllllIllIIIllIlIlIIlllIl.getItemStack().func_190918_g(1);
                }
            }
            else if (this.inventorySlots != null) {
                final ItemStack lllllllllllllIllIIIllIlIlIIlIlll = (lllllllllllllIllIIIllIlIlIlIIlll == null) ? ItemStack.field_190927_a : this.inventorySlots.getSlot(lllllllllllllIllIIIllIlIlIlIIlll.slotNumber).getStack();
                this.inventorySlots.slotClick((lllllllllllllIllIIIllIlIlIlIIlll == null) ? lllllllllllllIllIIIllIlIlIIlIIII : lllllllllllllIllIIIllIlIlIlIIlll.slotNumber, lllllllllllllIllIIIllIlIlIlIIlIl, lllllllllllllIllIIIllIlIlIIIlllI, this.mc.player);
                if (Container.getDragEvent(lllllllllllllIllIIIllIlIlIlIIlIl) == 2) {
                    for (int lllllllllllllIllIIIllIlIlIIlIllI = 0; lllllllllllllIllIIIllIlIlIIlIllI < 9; ++lllllllllllllIllIIIllIlIlIIlIllI) {
                        this.mc.playerController.sendSlotPacket(this.inventorySlots.getSlot(45 + lllllllllllllIllIIIllIlIlIIlIllI).getStack(), 36 + lllllllllllllIllIIIllIlIlIIlIllI);
                    }
                }
                else if (lllllllllllllIllIIIllIlIlIlIIlll != null) {
                    final ItemStack lllllllllllllIllIIIllIlIlIIlIlIl = this.inventorySlots.getSlot(lllllllllllllIllIIIllIlIlIlIIlll.slotNumber).getStack();
                    this.mc.playerController.sendSlotPacket(lllllllllllllIllIIIllIlIlIIlIlIl, lllllllllllllIllIIIllIlIlIlIIlll.slotNumber - this.inventorySlots.inventorySlots.size() + 9 + 36);
                    final int lllllllllllllIllIIIllIlIlIIlIlII = 45 + lllllllllllllIllIIIllIlIlIlIIlIl;
                    if (lllllllllllllIllIIIllIlIlIIIlllI == ClickType.SWAP) {
                        this.mc.playerController.sendSlotPacket(lllllllllllllIllIIIllIlIlIIlIlll, lllllllllllllIllIIIllIlIlIIlIlII - this.inventorySlots.inventorySlots.size() + 9 + 36);
                    }
                    else if (lllllllllllllIllIIIllIlIlIIIlllI == ClickType.THROW && !lllllllllllllIllIIIllIlIlIIlIlll.func_190926_b()) {
                        final ItemStack lllllllllllllIllIIIllIlIlIIlIIll = lllllllllllllIllIIIllIlIlIIlIlll.copy();
                        lllllllllllllIllIIIllIlIlIIlIIll.func_190920_e((lllllllllllllIllIIIllIlIlIlIIlIl == 0) ? 1 : lllllllllllllIllIIIllIlIlIIlIIll.getMaxStackSize());
                        this.mc.player.dropItem(lllllllllllllIllIIIllIlIlIIlIIll, true);
                        this.mc.playerController.sendPacketDropItem(lllllllllllllIllIIIllIlIlIIlIIll);
                    }
                    this.mc.player.inventoryContainer.detectAndSendChanges();
                }
            }
        }
    }
    
    @Override
    public void drawScreen(final int lllllllllllllIllIIIllIIllllIIlII, final int lllllllllllllIllIIIllIIllllIIIll, final float lllllllllllllIllIIIllIIllllIIIlI) {
        this.drawDefaultBackground();
        final boolean lllllllllllllIllIIIllIIllllIIIIl = Mouse.isButtonDown(0);
        final int lllllllllllllIllIIIllIIllllIIIII = this.guiLeft;
        final int lllllllllllllIllIIIllIIlllIlllll = this.guiTop;
        final int lllllllllllllIllIIIllIIlllIllllI = lllllllllllllIllIIIllIIllllIIIII + 175;
        final int lllllllllllllIllIIIllIIlllIlllIl = lllllllllllllIllIIIllIIlllIlllll + 18;
        final int lllllllllllllIllIIIllIIlllIlllII = lllllllllllllIllIIIllIIlllIllllI + 14;
        final int lllllllllllllIllIIIllIIlllIllIll = lllllllllllllIllIIIllIIlllIlllIl + 112;
        if (!this.wasClicking && lllllllllllllIllIIIllIIllllIIIIl && lllllllllllllIllIIIllIIllllIIlII >= lllllllllllllIllIIIllIIlllIllllI && lllllllllllllIllIIIllIIllllIIIll >= lllllllllllllIllIIIllIIlllIlllIl && lllllllllllllIllIIIllIIllllIIlII < lllllllllllllIllIIIllIIlllIlllII && lllllllllllllIllIIIllIIllllIIIll < lllllllllllllIllIIIllIIlllIllIll) {
            this.isScrolling = this.needsScrollBars();
        }
        if (!lllllllllllllIllIIIllIIllllIIIIl) {
            this.isScrolling = false;
        }
        this.wasClicking = lllllllllllllIllIIIllIIllllIIIIl;
        if (this.isScrolling) {
            this.currentScroll = (lllllllllllllIllIIIllIIllllIIIll - lllllllllllllIllIIIllIIlllIlllIl - 7.5f) / (lllllllllllllIllIIIllIIlllIllIll - lllllllllllllIllIIIllIIlllIlllIl - 15.0f);
            this.currentScroll = MathHelper.clamp(this.currentScroll, 0.0f, 1.0f);
            ((ContainerCreative)this.inventorySlots).scrollTo(this.currentScroll);
        }
        super.drawScreen(lllllllllllllIllIIIllIIllllIIlII, lllllllllllllIllIIIllIIllllIIIll, lllllllllllllIllIIIllIIllllIIIlI);
        final byte lllllllllllllIllIIIllIIlllIIlIll;
        final int lllllllllllllIllIIIllIIlllIIllII = ((CreativeTabs[])(Object)(lllllllllllllIllIIIllIIlllIIlIll = (byte)(Object)CreativeTabs.CREATIVE_TAB_ARRAY)).length;
        for (Exception lllllllllllllIllIIIllIIlllIIllIl = (Exception)0; lllllllllllllIllIIIllIIlllIIllIl < lllllllllllllIllIIIllIIlllIIllII; ++lllllllllllllIllIIIllIIlllIIllIl) {
            final CreativeTabs lllllllllllllIllIIIllIIlllIllIlI = lllllllllllllIllIIIllIIlllIIlIll[lllllllllllllIllIIIllIIlllIIllIl];
            if (this.renderCreativeInventoryHoveringText(lllllllllllllIllIIIllIIlllIllIlI, lllllllllllllIllIIIllIIllllIIlII, lllllllllllllIllIIIllIIllllIIIll)) {
                break;
            }
        }
        if (this.destroyItemSlot != null && GuiContainerCreative.selectedTabIndex == CreativeTabs.INVENTORY.getTabIndex() && this.isPointInRegion(this.destroyItemSlot.xDisplayPosition, this.destroyItemSlot.yDisplayPosition, 16, 16, lllllllllllllIllIIIllIIllllIIlII, lllllllllllllIllIIIllIIllllIIIll)) {
            this.drawCreativeTabHoveringText(I18n.format("inventory.binSlot", new Object[0]), lllllllllllllIllIIIllIIllllIIlII, lllllllllllllIllIIIllIIllllIIIll);
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableLighting();
        this.func_191948_b(lllllllllllllIllIIIllIIllllIIlII, lllllllllllllIllIIIllIIllllIIIll);
    }
    
    @Override
    public void updateScreen() {
        if (!this.mc.playerController.isInCreativeMode()) {
            this.mc.displayGuiScreen(new GuiInventory(this.mc.player));
        }
    }
    
    @Override
    protected void mouseReleased(final int lllllllllllllIllIIIllIlIIIllIlll, final int lllllllllllllIllIIIllIlIIIllIllI, final int lllllllllllllIllIIIllIlIIIlIlllI) {
        if (lllllllllllllIllIIIllIlIIIlIlllI == 0) {
            final int lllllllllllllIllIIIllIlIIIllIlII = lllllllllllllIllIIIllIlIIIllIlll - this.guiLeft;
            final int lllllllllllllIllIIIllIlIIIllIIll = lllllllllllllIllIIIllIlIIIllIllI - this.guiTop;
            final long lllllllllllllIllIIIllIlIIIlIlIII;
            final short lllllllllllllIllIIIllIlIIIlIlIIl = (short)((CreativeTabs[])(Object)(lllllllllllllIllIIIllIlIIIlIlIII = (long)(Object)CreativeTabs.CREATIVE_TAB_ARRAY)).length;
            for (char lllllllllllllIllIIIllIlIIIlIlIlI = '\0'; lllllllllllllIllIIIllIlIIIlIlIlI < lllllllllllllIllIIIllIlIIIlIlIIl; ++lllllllllllllIllIIIllIlIIIlIlIlI) {
                final CreativeTabs lllllllllllllIllIIIllIlIIIllIIlI = lllllllllllllIllIIIllIlIIIlIlIII[lllllllllllllIllIIIllIlIIIlIlIlI];
                if (this.isMouseOverTab(lllllllllllllIllIIIllIlIIIllIIlI, lllllllllllllIllIIIllIlIIIllIlII, lllllllllllllIllIIIllIlIIIllIIll)) {
                    this.setCurrentCreativeTab(lllllllllllllIllIIIllIlIIIllIIlI);
                    return;
                }
            }
        }
        super.mouseReleased(lllllllllllllIllIIIllIlIIIllIlll, lllllllllllllIllIIIllIlIIIllIllI, lllllllllllllIllIIIllIlIIIlIlllI);
    }
    
    private void updateCreativeSearch() {
        final ContainerCreative lllllllllllllIllIIIllIlIIllIlIll = (ContainerCreative)this.inventorySlots;
        lllllllllllllIllIIIllIlIIllIlIll.itemList.clear();
        if (this.searchField.getText().isEmpty()) {
            for (final Item lllllllllllllIllIIIllIlIIllIlIlI : Item.REGISTRY) {
                lllllllllllllIllIIIllIlIIllIlIlI.getSubItems(CreativeTabs.SEARCH, lllllllllllllIllIIIllIlIIllIlIll.itemList);
            }
        }
        else {
            lllllllllllllIllIIIllIlIIllIlIll.itemList.addAll((Collection<?>)this.mc.func_193987_a(SearchTreeManager.field_194011_a).func_194038_a(this.searchField.getText().toLowerCase(Locale.ROOT)));
        }
        this.currentScroll = 0.0f;
        lllllllllllllIllIIIllIlIIllIlIll.scrollTo(0.0f);
    }
    
    @Override
    protected void updateActivePotionEffects() {
        final int lllllllllllllIllIIIllIlIlIIIIlIl = this.guiLeft;
        super.updateActivePotionEffects();
        if (this.searchField != null && this.guiLeft != lllllllllllllIllIIIllIlIlIIIIlIl) {
            this.searchField.xPosition = this.guiLeft + 82;
        }
    }
    
    protected boolean renderCreativeInventoryHoveringText(final CreativeTabs lllllllllllllIllIIIllIIlIllIlIll, final int lllllllllllllIllIIIllIIlIllIlIlI, final int lllllllllllllIllIIIllIIlIllIlIIl) {
        final int lllllllllllllIllIIIllIIlIllIllll = lllllllllllllIllIIIllIIlIllIlIll.getTabColumn();
        int lllllllllllllIllIIIllIIlIllIlllI = 28 * lllllllllllllIllIIIllIIlIllIllll;
        int lllllllllllllIllIIIllIIlIllIllIl = 0;
        if (lllllllllllllIllIIIllIIlIllIlIll.func_192394_m()) {
            lllllllllllllIllIIIllIIlIllIlllI = this.xSize - 28 * (6 - lllllllllllllIllIIIllIIlIllIllll) + 2;
        }
        else if (lllllllllllllIllIIIllIIlIllIllll > 0) {
            lllllllllllllIllIIIllIIlIllIlllI += lllllllllllllIllIIIllIIlIllIllll;
        }
        if (lllllllllllllIllIIIllIIlIllIlIll.isTabInFirstRow()) {
            lllllllllllllIllIIIllIIlIllIllIl -= 32;
        }
        else {
            lllllllllllllIllIIIllIIlIllIllIl += this.ySize;
        }
        if (this.isPointInRegion(lllllllllllllIllIIIllIIlIllIlllI + 3, lllllllllllllIllIIIllIIlIllIllIl + 3, 23, 27, lllllllllllllIllIIIllIIlIllIlIlI, lllllllllllllIllIIIllIIlIllIlIIl)) {
            this.drawCreativeTabHoveringText(I18n.format(lllllllllllllIllIIIllIIlIllIlIll.getTranslatedTabLabel(), new Object[0]), lllllllllllllIllIIIllIIlIllIlIlI, lllllllllllllIllIIIllIIlIllIlIIl);
            return true;
        }
        return false;
    }
    
    protected void drawTab(final CreativeTabs lllllllllllllIllIIIllIIlIlIllIIl) {
        final boolean lllllllllllllIllIIIllIIlIlIllIII = lllllllllllllIllIIIllIIlIlIllIIl.getTabIndex() == GuiContainerCreative.selectedTabIndex;
        final boolean lllllllllllllIllIIIllIIlIlIlIlll = lllllllllllllIllIIIllIIlIlIllIIl.isTabInFirstRow();
        final int lllllllllllllIllIIIllIIlIlIlIllI = lllllllllllllIllIIIllIIlIlIllIIl.getTabColumn();
        final int lllllllllllllIllIIIllIIlIlIlIlIl = lllllllllllllIllIIIllIIlIlIlIllI * 28;
        int lllllllllllllIllIIIllIIlIlIlIlII = 0;
        int lllllllllllllIllIIIllIIlIlIlIIll = this.guiLeft + 28 * lllllllllllllIllIIIllIIlIlIlIllI;
        int lllllllllllllIllIIIllIIlIlIlIIlI = this.guiTop;
        final int lllllllllllllIllIIIllIIlIlIlIIIl = 32;
        if (lllllllllllllIllIIIllIIlIlIllIII) {
            lllllllllllllIllIIIllIIlIlIlIlII += 32;
        }
        if (lllllllllllllIllIIIllIIlIlIllIIl.func_192394_m()) {
            lllllllllllllIllIIIllIIlIlIlIIll = this.guiLeft + this.xSize - 28 * (6 - lllllllllllllIllIIIllIIlIlIlIllI);
        }
        else if (lllllllllllllIllIIIllIIlIlIlIllI > 0) {
            lllllllllllllIllIIIllIIlIlIlIIll += lllllllllllllIllIIIllIIlIlIlIllI;
        }
        if (lllllllllllllIllIIIllIIlIlIlIlll) {
            lllllllllllllIllIIIllIIlIlIlIIlI -= 28;
        }
        else {
            lllllllllllllIllIIIllIIlIlIlIlII += 64;
            lllllllllllllIllIIIllIIlIlIlIIlI += this.ySize - 4;
        }
        GlStateManager.disableLighting();
        this.drawTexturedModalRect(lllllllllllllIllIIIllIIlIlIlIIll, lllllllllllllIllIIIllIIlIlIlIIlI, lllllllllllllIllIIIllIIlIlIlIlIl, lllllllllllllIllIIIllIIlIlIlIlII, 28, 32);
        this.zLevel = 100.0f;
        this.itemRender.zLevel = 100.0f;
        lllllllllllllIllIIIllIIlIlIlIIll += 6;
        lllllllllllllIllIIIllIIlIlIlIIlI = lllllllllllllIllIIIllIIlIlIlIIlI + 8 + (lllllllllllllIllIIIllIIlIlIlIlll ? 1 : -1);
        GlStateManager.enableLighting();
        GlStateManager.enableRescaleNormal();
        final ItemStack lllllllllllllIllIIIllIIlIlIlIIII = lllllllllllllIllIIIllIIlIlIllIIl.getIconItemStack();
        this.itemRender.renderItemAndEffectIntoGUI(lllllllllllllIllIIIllIIlIlIlIIII, lllllllllllllIllIIIllIIlIlIlIIll, lllllllllllllIllIIIllIIlIlIlIIlI);
        this.itemRender.renderItemOverlays(this.fontRendererObj, lllllllllllllIllIIIllIIlIlIlIIII, lllllllllllllIllIIIllIIlIlIlIIll, lllllllllllllIllIIIllIIlIlIlIIlI);
        GlStateManager.disableLighting();
        this.itemRender.zLevel = 0.0f;
        this.zLevel = 0.0f;
    }
    
    private void setCurrentCreativeTab(final CreativeTabs lllllllllllllIllIIIllIlIIIIllIIl) {
        final int lllllllllllllIllIIIllIlIIIIllIII = GuiContainerCreative.selectedTabIndex;
        GuiContainerCreative.selectedTabIndex = lllllllllllllIllIIIllIlIIIIllIIl.getTabIndex();
        final ContainerCreative lllllllllllllIllIIIllIlIIIIlIlll = (ContainerCreative)this.inventorySlots;
        this.dragSplittingSlots.clear();
        lllllllllllllIllIIIllIlIIIIlIlll.itemList.clear();
        if (lllllllllllllIllIIIllIlIIIIllIIl == CreativeTabs.field_192395_m) {
            for (int lllllllllllllIllIIIllIlIIIIlIllI = 0; lllllllllllllIllIIIllIlIIIIlIllI < 9; ++lllllllllllllIllIIIllIlIIIIlIllI) {
                final HotbarSnapshot lllllllllllllIllIIIllIlIIIIlIlIl = this.mc.field_191950_u.func_192563_a(lllllllllllllIllIIIllIlIIIIlIllI);
                if (lllllllllllllIllIIIllIlIIIIlIlIl.isEmpty()) {
                    for (int lllllllllllllIllIIIllIlIIIIlIlII = 0; lllllllllllllIllIIIllIlIIIIlIlII < 9; ++lllllllllllllIllIIIllIlIIIIlIlII) {
                        if (lllllllllllllIllIIIllIlIIIIlIlII == lllllllllllllIllIIIllIlIIIIlIllI) {
                            final ItemStack lllllllllllllIllIIIllIlIIIIlIIll = new ItemStack(Items.PAPER);
                            lllllllllllllIllIIIllIlIIIIlIIll.func_190925_c("CustomCreativeLock");
                            final String lllllllllllllIllIIIllIlIIIIlIIlI = GameSettings.getKeyDisplayString(this.mc.gameSettings.keyBindsHotbar[lllllllllllllIllIIIllIlIIIIlIllI].getKeyCode());
                            final String lllllllllllllIllIIIllIlIIIIlIIIl = GameSettings.getKeyDisplayString(this.mc.gameSettings.field_193629_ap.getKeyCode());
                            lllllllllllllIllIIIllIlIIIIlIIll.setStackDisplayName(new TextComponentTranslation("inventory.hotbarInfo", new Object[] { lllllllllllllIllIIIllIlIIIIlIIIl, lllllllllllllIllIIIllIlIIIIlIIlI }).getUnformattedText());
                            lllllllllllllIllIIIllIlIIIIlIlll.itemList.add(lllllllllllllIllIIIllIlIIIIlIIll);
                        }
                        else {
                            lllllllllllllIllIIIllIlIIIIlIlll.itemList.add(ItemStack.field_190927_a);
                        }
                    }
                }
                else {
                    lllllllllllllIllIIIllIlIIIIlIlll.itemList.addAll((Collection<?>)lllllllllllllIllIIIllIlIIIIlIlIl);
                }
            }
        }
        else if (lllllllllllllIllIIIllIlIIIIllIIl != CreativeTabs.SEARCH) {
            lllllllllllllIllIIIllIlIIIIllIIl.displayAllRelevantItems(lllllllllllllIllIIIllIlIIIIlIlll.itemList);
        }
        if (lllllllllllllIllIIIllIlIIIIllIIl == CreativeTabs.INVENTORY) {
            final Container lllllllllllllIllIIIllIlIIIIlIIII = this.mc.player.inventoryContainer;
            if (this.originalSlots == null) {
                this.originalSlots = lllllllllllllIllIIIllIlIIIIlIlll.inventorySlots;
            }
            lllllllllllllIllIIIllIlIIIIlIlll.inventorySlots = (List<Slot>)Lists.newArrayList();
            for (int lllllllllllllIllIIIllIlIIIIIllll = 0; lllllllllllllIllIIIllIlIIIIIllll < lllllllllllllIllIIIllIlIIIIlIIII.inventorySlots.size(); ++lllllllllllllIllIIIllIlIIIIIllll) {
                final Slot lllllllllllllIllIIIllIlIIIIIlllI = new CreativeSlot(lllllllllllllIllIIIllIlIIIIlIIII.inventorySlots.get(lllllllllllllIllIIIllIlIIIIIllll), lllllllllllllIllIIIllIlIIIIIllll);
                lllllllllllllIllIIIllIlIIIIlIlll.inventorySlots.add(lllllllllllllIllIIIllIlIIIIIlllI);
                if (lllllllllllllIllIIIllIlIIIIIllll >= 5 && lllllllllllllIllIIIllIlIIIIIllll < 9) {
                    final int lllllllllllllIllIIIllIlIIIIIllIl = lllllllllllllIllIIIllIlIIIIIllll - 5;
                    final int lllllllllllllIllIIIllIlIIIIIllII = lllllllllllllIllIIIllIlIIIIIllIl / 2;
                    final int lllllllllllllIllIIIllIlIIIIIlIll = lllllllllllllIllIIIllIlIIIIIllIl % 2;
                    lllllllllllllIllIIIllIlIIIIIlllI.xDisplayPosition = 54 + lllllllllllllIllIIIllIlIIIIIllII * 54;
                    lllllllllllllIllIIIllIlIIIIIlllI.yDisplayPosition = 6 + lllllllllllllIllIIIllIlIIIIIlIll * 27;
                }
                else if (lllllllllllllIllIIIllIlIIIIIllll >= 0 && lllllllllllllIllIIIllIlIIIIIllll < 5) {
                    lllllllllllllIllIIIllIlIIIIIlllI.xDisplayPosition = -2000;
                    lllllllllllllIllIIIllIlIIIIIlllI.yDisplayPosition = -2000;
                }
                else if (lllllllllllllIllIIIllIlIIIIIllll == 45) {
                    lllllllllllllIllIIIllIlIIIIIlllI.xDisplayPosition = 35;
                    lllllllllllllIllIIIllIlIIIIIlllI.yDisplayPosition = 20;
                }
                else if (lllllllllllllIllIIIllIlIIIIIllll < lllllllllllllIllIIIllIlIIIIlIIII.inventorySlots.size()) {
                    final int lllllllllllllIllIIIllIlIIIIIlIlI = lllllllllllllIllIIIllIlIIIIIllll - 9;
                    final int lllllllllllllIllIIIllIlIIIIIlIIl = lllllllllllllIllIIIllIlIIIIIlIlI % 9;
                    final int lllllllllllllIllIIIllIlIIIIIlIII = lllllllllllllIllIIIllIlIIIIIlIlI / 9;
                    lllllllllllllIllIIIllIlIIIIIlllI.xDisplayPosition = 9 + lllllllllllllIllIIIllIlIIIIIlIIl * 18;
                    if (lllllllllllllIllIIIllIlIIIIIllll >= 36) {
                        lllllllllllllIllIIIllIlIIIIIlllI.yDisplayPosition = 112;
                    }
                    else {
                        lllllllllllllIllIIIllIlIIIIIlllI.yDisplayPosition = 54 + lllllllllllllIllIIIllIlIIIIIlIII * 18;
                    }
                }
            }
            this.destroyItemSlot = new Slot(GuiContainerCreative.basicInventory, 0, 173, 112);
            lllllllllllllIllIIIllIlIIIIlIlll.inventorySlots.add(this.destroyItemSlot);
        }
        else if (lllllllllllllIllIIIllIlIIIIllIII == CreativeTabs.INVENTORY.getTabIndex()) {
            lllllllllllllIllIIIllIlIIIIlIlll.inventorySlots = this.originalSlots;
            this.originalSlots = null;
        }
        if (this.searchField != null) {
            if (lllllllllllllIllIIIllIlIIIIllIIl == CreativeTabs.SEARCH) {
                this.searchField.setVisible(true);
                this.searchField.setCanLoseFocus(false);
                this.searchField.setFocused(true);
                this.searchField.setText("");
                this.updateCreativeSearch();
            }
            else {
                this.searchField.setVisible(false);
                this.searchField.setCanLoseFocus(true);
                this.searchField.setFocused(false);
            }
        }
        this.currentScroll = 0.0f;
        lllllllllllllIllIIIllIlIIIIlIlll.scrollTo(0.0f);
    }
    
    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
        if (this.mc.player != null && this.mc.player.inventory != null) {
            this.mc.player.inventoryContainer.removeListener(this.listener);
        }
        Keyboard.enableRepeatEvents(false);
    }
    
    private boolean needsScrollBars() {
        return GuiContainerCreative.selectedTabIndex != CreativeTabs.INVENTORY.getTabIndex() && CreativeTabs.CREATIVE_TAB_ARRAY[GuiContainerCreative.selectedTabIndex].shouldHidePlayerInventory() && ((ContainerCreative)this.inventorySlots).canScroll();
    }
    
    @Override
    protected void mouseClicked(final int lllllllllllllIllIIIllIlIIlIlIIlI, final int lllllllllllllIllIIIllIlIIlIIlIlI, final int lllllllllllllIllIIIllIlIIlIlIIII) throws IOException {
        if (lllllllllllllIllIIIllIlIIlIlIIII == 0) {
            final int lllllllllllllIllIIIllIlIIlIIllll = lllllllllllllIllIIIllIlIIlIlIIlI - this.guiLeft;
            final int lllllllllllllIllIIIllIlIIlIIlllI = lllllllllllllIllIIIllIlIIlIIlIlI - this.guiTop;
            final Exception lllllllllllllIllIIIllIlIIlIIIIll;
            final boolean lllllllllllllIllIIIllIlIIlIIIlII = ((CreativeTabs[])(Object)(lllllllllllllIllIIIllIlIIlIIIIll = (Exception)(Object)CreativeTabs.CREATIVE_TAB_ARRAY)).length != 0;
            for (Exception lllllllllllllIllIIIllIlIIlIIIlIl = (Exception)0; lllllllllllllIllIIIllIlIIlIIIlIl < lllllllllllllIllIIIllIlIIlIIIlII; ++lllllllllllllIllIIIllIlIIlIIIlIl) {
                final CreativeTabs lllllllllllllIllIIIllIlIIlIIllIl = lllllllllllllIllIIIllIlIIlIIIIll[lllllllllllllIllIIIllIlIIlIIIlIl];
                if (this.isMouseOverTab(lllllllllllllIllIIIllIlIIlIIllIl, lllllllllllllIllIIIllIlIIlIIllll, lllllllllllllIllIIIllIlIIlIIlllI)) {
                    return;
                }
            }
        }
        super.mouseClicked(lllllllllllllIllIIIllIlIIlIlIIlI, lllllllllllllIllIIIllIlIIlIIlIlI, lllllllllllllIllIIIllIlIIlIlIIII);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(final float lllllllllllllIllIIIllIIllIIlllll, final int lllllllllllllIllIIIllIIllIIlIllI, final int lllllllllllllIllIIIllIIllIIlIlIl) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        RenderHelper.enableGUIStandardItemLighting();
        final CreativeTabs lllllllllllllIllIIIllIIllIIlllII = CreativeTabs.CREATIVE_TAB_ARRAY[GuiContainerCreative.selectedTabIndex];
        final short lllllllllllllIllIIIllIIllIIlIIII;
        final int length = (lllllllllllllIllIIIllIIllIIlIIII = (short)(Object)CreativeTabs.CREATIVE_TAB_ARRAY).length;
        for (String lllllllllllllIllIIIllIIllIIlIIlI = (String)0; lllllllllllllIllIIIllIIllIIlIIlI < length; ++lllllllllllllIllIIIllIIllIIlIIlI) {
            final CreativeTabs lllllllllllllIllIIIllIIllIIllIll = lllllllllllllIllIIIllIIllIIlIIII[lllllllllllllIllIIIllIIllIIlIIlI];
            this.mc.getTextureManager().bindTexture(GuiContainerCreative.CREATIVE_INVENTORY_TABS);
            if (lllllllllllllIllIIIllIIllIIllIll.getTabIndex() != GuiContainerCreative.selectedTabIndex) {
                this.drawTab(lllllllllllllIllIIIllIIllIIllIll);
            }
        }
        this.mc.getTextureManager().bindTexture(new ResourceLocation(String.valueOf(new StringBuilder("textures/gui/container/creative_inventory/tab_").append(lllllllllllllIllIIIllIIllIIlllII.getBackgroundImageName()))));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
        this.searchField.drawTextBox();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final int lllllllllllllIllIIIllIIllIIllIlI = this.guiLeft + 175;
        final int lllllllllllllIllIIIllIIllIIllIIl = this.guiTop + 18;
        final int lllllllllllllIllIIIllIIllIIllIII = lllllllllllllIllIIIllIIllIIllIIl + 112;
        this.mc.getTextureManager().bindTexture(GuiContainerCreative.CREATIVE_INVENTORY_TABS);
        if (lllllllllllllIllIIIllIIllIIlllII.shouldHidePlayerInventory()) {
            this.drawTexturedModalRect(lllllllllllllIllIIIllIIllIIllIlI, lllllllllllllIllIIIllIIllIIllIIl + (int)((lllllllllllllIllIIIllIIllIIllIII - lllllllllllllIllIIIllIIllIIllIIl - 17) * this.currentScroll), 232 + (this.needsScrollBars() ? 0 : 12), 0, 12, 15);
        }
        this.drawTab(lllllllllllllIllIIIllIIllIIlllII);
        if (lllllllllllllIllIIIllIIllIIlllII == CreativeTabs.INVENTORY) {
            GuiInventory.drawEntityOnScreen((float)(this.guiLeft + 88), this.guiTop + 45, 20, (float)(this.guiLeft + 88 - lllllllllllllIllIIIllIIllIIlIllI), (float)(this.guiTop + 45 - 30 - lllllllllllllIllIIIllIIllIIlIlIl), this.mc.player);
        }
    }
    
    protected boolean isMouseOverTab(final CreativeTabs lllllllllllllIllIIIllIIllIIIIlll, final int lllllllllllllIllIIIllIIllIIIIllI, final int lllllllllllllIllIIIllIIlIllllllI) {
        final int lllllllllllllIllIIIllIIllIIIIlII = lllllllllllllIllIIIllIIllIIIIlll.getTabColumn();
        int lllllllllllllIllIIIllIIllIIIIIll = 28 * lllllllllllllIllIIIllIIllIIIIlII;
        int lllllllllllllIllIIIllIIllIIIIIlI = 0;
        if (lllllllllllllIllIIIllIIllIIIIlll.func_192394_m()) {
            lllllllllllllIllIIIllIIllIIIIIll = this.xSize - 28 * (6 - lllllllllllllIllIIIllIIllIIIIlII) + 2;
        }
        else if (lllllllllllllIllIIIllIIllIIIIlII > 0) {
            lllllllllllllIllIIIllIIllIIIIIll += lllllllllllllIllIIIllIIllIIIIlII;
        }
        if (lllllllllllllIllIIIllIIllIIIIlll.isTabInFirstRow()) {
            lllllllllllllIllIIIllIIllIIIIIlI -= 32;
        }
        else {
            lllllllllllllIllIIIllIIllIIIIIlI += this.ySize;
        }
        return lllllllllllllIllIIIllIIllIIIIllI >= lllllllllllllIllIIIllIIllIIIIIll && lllllllllllllIllIIIllIIllIIIIllI <= lllllllllllllIllIIIllIIllIIIIIll + 28 && lllllllllllllIllIIIllIIlIllllllI >= lllllllllllllIllIIIllIIllIIIIIlI && lllllllllllllIllIIIllIIlIllllllI <= lllllllllllllIllIIIllIIllIIIIIlI + 32;
    }
    
    static class LockedSlot extends Slot
    {
        @Override
        public boolean canTakeStack(final EntityPlayer lllllllllllllIIIIlIIlIIIlllIllll) {
            if (super.canTakeStack(lllllllllllllIIIIlIIlIIIlllIllll) && this.getHasStack()) {
                return this.getStack().getSubCompound("CustomCreativeLock") == null;
            }
            return !this.getHasStack();
        }
        
        public LockedSlot(final IInventory lllllllllllllIIIIlIIlIIIllllllIl, final int lllllllllllllIIIIlIIlIIIllllIlll, final int lllllllllllllIIIIlIIlIIIllllIllI, final int lllllllllllllIIIIlIIlIIIllllIlIl) {
            super(lllllllllllllIIIIlIIlIIIllllllIl, lllllllllllllIIIIlIIlIIIllllIlll, lllllllllllllIIIIlIIlIIIllllIllI, lllllllllllllIIIIlIIlIIIllllIlIl);
        }
    }
    
    class CreativeSlot extends Slot
    {
        private final /* synthetic */ Slot slot;
        
        @Override
        public boolean isHere(final IInventory lllllllllllllIIIlIlIIIlIlIlIIllI, final int lllllllllllllIIIlIlIIIlIlIlIlIII) {
            return this.slot.isHere(lllllllllllllIIIlIlIIIlIlIlIIllI, lllllllllllllIIIlIlIIIlIlIlIlIII);
        }
        
        @Override
        public boolean canBeHovered() {
            return this.slot.canBeHovered();
        }
        
        @Override
        public ItemStack func_190901_a(final EntityPlayer lllllllllllllIIIlIlIIIlIllIlIllI, final ItemStack lllllllllllllIIIlIlIIIlIllIllIII) {
            this.slot.func_190901_a(lllllllllllllIIIlIlIIIlIllIlIllI, lllllllllllllIIIlIlIIIlIllIllIII);
            return lllllllllllllIIIlIlIIIlIllIllIII;
        }
        
        @Override
        public boolean isItemValid(final ItemStack lllllllllllllIIIlIlIIIlIllIlIIIl) {
            return this.slot.isItemValid(lllllllllllllIIIlIlIIIlIllIlIIIl);
        }
        
        @Override
        public int getSlotStackLimit() {
            return this.slot.getSlotStackLimit();
        }
        
        @Override
        public ItemStack getStack() {
            return this.slot.getStack();
        }
        
        public CreativeSlot(final Slot lllllllllllllIIIlIlIIIlIllIlllll, final int lllllllllllllIIIlIlIIIlIllIllllI) {
            super(lllllllllllllIIIlIlIIIlIllIlllll.inventory, lllllllllllllIIIlIlIIIlIllIllllI, 0, 0);
            this.slot = lllllllllllllIIIlIlIIIlIllIlllll;
        }
        
        @Nullable
        @Override
        public String getSlotTexture() {
            return this.slot.getSlotTexture();
        }
        
        @Override
        public boolean getHasStack() {
            return this.slot.getHasStack();
        }
        
        @Override
        public void putStack(final ItemStack lllllllllllllIIIlIlIIIlIllIIIlIl) {
            this.slot.putStack(lllllllllllllIIIlIlIIIlIllIIIlIl);
        }
        
        @Override
        public boolean canTakeStack(final EntityPlayer lllllllllllllIIIlIlIIIlIlIIllllI) {
            return this.slot.canTakeStack(lllllllllllllIIIlIlIIIlIlIIllllI);
        }
        
        @Override
        public int getItemStackLimit(final ItemStack lllllllllllllIIIlIlIIIlIlIlllIIl) {
            return this.slot.getItemStackLimit(lllllllllllllIIIlIlIIIlIlIlllIIl);
        }
        
        @Override
        public ItemStack decrStackSize(final int lllllllllllllIIIlIlIIIlIlIllIIII) {
            return this.slot.decrStackSize(lllllllllllllIIIlIlIIIlIlIllIIII);
        }
        
        @Override
        public void onSlotChanged() {
            this.slot.onSlotChanged();
        }
    }
    
    public static class ContainerCreative extends Container
    {
        public /* synthetic */ NonNullList<ItemStack> itemList;
        
        @Override
        public ItemStack transferStackInSlot(final EntityPlayer lllllllllllllIIIlIlIIIIlIlIIIIIl, final int lllllllllllllIIIlIlIIIIlIIllllIl) {
            if (lllllllllllllIIIlIlIIIIlIIllllIl >= this.inventorySlots.size() - 9 && lllllllllllllIIIlIlIIIIlIIllllIl < this.inventorySlots.size()) {
                final Slot lllllllllllllIIIlIlIIIIlIIllllll = this.inventorySlots.get(lllllllllllllIIIlIlIIIIlIIllllIl);
                if (lllllllllllllIIIlIlIIIIlIIllllll != null && lllllllllllllIIIlIlIIIIlIIllllll.getHasStack()) {
                    lllllllllllllIIIlIlIIIIlIIllllll.putStack(ItemStack.field_190927_a);
                }
            }
            return ItemStack.field_190927_a;
        }
        
        public void scrollTo(final float lllllllllllllIIIlIlIIIIlIlIIlllI) {
            final int lllllllllllllIIIlIlIIIIlIlIlIlII = (this.itemList.size() + 9 - 1) / 9 - 5;
            int lllllllllllllIIIlIlIIIIlIlIlIIll = (int)(lllllllllllllIIIlIlIIIIlIlIIlllI * lllllllllllllIIIlIlIIIIlIlIlIlII + 0.5);
            if (lllllllllllllIIIlIlIIIIlIlIlIIll < 0) {
                lllllllllllllIIIlIlIIIIlIlIlIIll = 0;
            }
            for (int lllllllllllllIIIlIlIIIIlIlIlIIlI = 0; lllllllllllllIIIlIlIIIIlIlIlIIlI < 5; ++lllllllllllllIIIlIlIIIIlIlIlIIlI) {
                for (int lllllllllllllIIIlIlIIIIlIlIlIIIl = 0; lllllllllllllIIIlIlIIIIlIlIlIIIl < 9; ++lllllllllllllIIIlIlIIIIlIlIlIIIl) {
                    final int lllllllllllllIIIlIlIIIIlIlIlIIII = lllllllllllllIIIlIlIIIIlIlIlIIIl + (lllllllllllllIIIlIlIIIIlIlIlIIlI + lllllllllllllIIIlIlIIIIlIlIlIIll) * 9;
                    if (lllllllllllllIIIlIlIIIIlIlIlIIII >= 0 && lllllllllllllIIIlIlIIIIlIlIlIIII < this.itemList.size()) {
                        GuiContainerCreative.basicInventory.setInventorySlotContents(lllllllllllllIIIlIlIIIIlIlIlIIIl + lllllllllllllIIIlIlIIIIlIlIlIIlI * 9, this.itemList.get(lllllllllllllIIIlIlIIIIlIlIlIIII));
                    }
                    else {
                        GuiContainerCreative.basicInventory.setInventorySlotContents(lllllllllllllIIIlIlIIIIlIlIlIIIl + lllllllllllllIIIlIlIIIIlIlIlIIlI * 9, ItemStack.field_190927_a);
                    }
                }
            }
        }
        
        public boolean canScroll() {
            return this.itemList.size() > 45;
        }
        
        @Override
        public boolean canDragIntoSlot(final Slot lllllllllllllIIIlIlIIIIlIIllIIll) {
            return lllllllllllllIIIlIlIIIIlIIllIIll.inventory instanceof InventoryPlayer || (lllllllllllllIIIlIlIIIIlIIllIIll.yDisplayPosition > 90 && lllllllllllllIIIlIlIIIIlIIllIIll.xDisplayPosition <= 162);
        }
        
        @Override
        public boolean canInteractWith(final EntityPlayer lllllllllllllIIIlIlIIIIlIlIllllI) {
            return true;
        }
        
        public ContainerCreative(final EntityPlayer lllllllllllllIIIlIlIIIIlIllIIIll) {
            this.itemList = NonNullList.func_191196_a();
            final InventoryPlayer lllllllllllllIIIlIlIIIIlIllIlIII = lllllllllllllIIIlIlIIIIlIllIIIll.inventory;
            for (int lllllllllllllIIIlIlIIIIlIllIIlll = 0; lllllllllllllIIIlIlIIIIlIllIIlll < 5; ++lllllllllllllIIIlIlIIIIlIllIIlll) {
                for (int lllllllllllllIIIlIlIIIIlIllIIllI = 0; lllllllllllllIIIlIlIIIIlIllIIllI < 9; ++lllllllllllllIIIlIlIIIIlIllIIllI) {
                    this.addSlotToContainer(new LockedSlot(GuiContainerCreative.basicInventory, lllllllllllllIIIlIlIIIIlIllIIlll * 9 + lllllllllllllIIIlIlIIIIlIllIIllI, 9 + lllllllllllllIIIlIlIIIIlIllIIllI * 18, 18 + lllllllllllllIIIlIlIIIIlIllIIlll * 18));
                }
            }
            for (int lllllllllllllIIIlIlIIIIlIllIIlIl = 0; lllllllllllllIIIlIlIIIIlIllIIlIl < 9; ++lllllllllllllIIIlIlIIIIlIllIIlIl) {
                this.addSlotToContainer(new Slot(lllllllllllllIIIlIlIIIIlIllIlIII, lllllllllllllIIIlIlIIIIlIllIIlIl, 9 + lllllllllllllIIIlIlIIIIlIllIIlIl * 18, 112));
            }
            this.scrollTo(0.0f);
        }
        
        @Override
        public boolean canMergeSlot(final ItemStack lllllllllllllIIIlIlIIIIlIIlllIIl, final Slot lllllllllllllIIIlIlIIIIlIIlllIII) {
            return lllllllllllllIIIlIlIIIIlIIlllIII.yDisplayPosition > 90;
        }
    }
}
