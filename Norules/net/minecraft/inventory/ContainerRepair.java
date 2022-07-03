package net.minecraft.inventory;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import org.apache.commons.lang3.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.enchantment.*;
import java.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import org.apache.logging.log4j.*;

public class ContainerRepair extends Container
{
    private final /* synthetic */ BlockPos selfPosition;
    private final /* synthetic */ World theWorld;
    public /* synthetic */ int maximumCost;
    private final /* synthetic */ IInventory outputSlot;
    private final /* synthetic */ EntityPlayer thePlayer;
    private /* synthetic */ int materialCost;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity;
    private final /* synthetic */ IInventory inputSlots;
    private /* synthetic */ String repairedItemName;
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllIIlIlIllllIlIIlIII, final int llllllllllllllIIlIlIllllIlIIIIIl) {
        ItemStack llllllllllllllIIlIlIllllIlIIIllI = ItemStack.field_190927_a;
        final Slot llllllllllllllIIlIlIllllIlIIIlIl = this.inventorySlots.get(llllllllllllllIIlIlIllllIlIIIIIl);
        if (llllllllllllllIIlIlIllllIlIIIlIl != null && llllllllllllllIIlIlIllllIlIIIlIl.getHasStack()) {
            final ItemStack llllllllllllllIIlIlIllllIlIIIlII = llllllllllllllIIlIlIllllIlIIIlIl.getStack();
            llllllllllllllIIlIlIllllIlIIIllI = llllllllllllllIIlIlIllllIlIIIlII.copy();
            if (llllllllllllllIIlIlIllllIlIIIIIl == 2) {
                if (!this.mergeItemStack(llllllllllllllIIlIlIllllIlIIIlII, 3, 39, true)) {
                    return ItemStack.field_190927_a;
                }
                llllllllllllllIIlIlIllllIlIIIlIl.onSlotChange(llllllllllllllIIlIlIllllIlIIIlII, llllllllllllllIIlIlIllllIlIIIllI);
            }
            else if (llllllllllllllIIlIlIllllIlIIIIIl != 0 && llllllllllllllIIlIlIllllIlIIIIIl != 1) {
                if (llllllllllllllIIlIlIllllIlIIIIIl >= 3 && llllllllllllllIIlIlIllllIlIIIIIl < 39 && !this.mergeItemStack(llllllllllllllIIlIlIllllIlIIIlII, 0, 2, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllIIlIlIllllIlIIIlII, 3, 39, false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllllIIlIlIllllIlIIIlII.func_190926_b()) {
                llllllllllllllIIlIlIllllIlIIIlIl.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllllIIlIlIllllIlIIIlIl.onSlotChanged();
            }
            if (llllllllllllllIIlIlIllllIlIIIlII.func_190916_E() == llllllllllllllIIlIlIllllIlIIIllI.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            llllllllllllllIIlIlIllllIlIIIlIl.func_190901_a(llllllllllllllIIlIlIllllIlIIlIII, llllllllllllllIIlIlIllllIlIIIlII);
        }
        return llllllllllllllIIlIlIllllIlIIIllI;
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllIIlIlIllllIlIlIIII) {
        return this.theWorld.getBlockState(this.selfPosition).getBlock() == Blocks.ANVIL && llllllllllllllIIlIlIllllIlIlIIII.getDistanceSq(this.selfPosition.getX() + 0.5, this.selfPosition.getY() + 0.5, this.selfPosition.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory llllllllllllllIIlIlIlllllIlIllII) {
        super.onCraftMatrixChanged(llllllllllllllIIlIlIlllllIlIllII);
        if (llllllllllllllIIlIlIlllllIlIllII == this.inputSlots) {
            this.updateRepairOutput();
        }
    }
    
    public void updateItemName(final String llllllllllllllIIlIlIllllIIlllIIl) {
        this.repairedItemName = llllllllllllllIIlIlIllllIIlllIIl;
        if (this.getSlot(2).getHasStack()) {
            final ItemStack llllllllllllllIIlIlIllllIIlllIII = this.getSlot(2).getStack();
            if (StringUtils.isBlank((CharSequence)llllllllllllllIIlIlIllllIIlllIIl)) {
                llllllllllllllIIlIlIllllIIlllIII.clearCustomName();
            }
            else {
                llllllllllllllIIlIlIllllIIlllIII.setStackDisplayName(this.repairedItemName);
            }
        }
        this.updateRepairOutput();
    }
    
    public void updateRepairOutput() {
        final ItemStack llllllllllllllIIlIlIlllllIIlIlll = this.inputSlots.getStackInSlot(0);
        this.maximumCost = 1;
        int llllllllllllllIIlIlIlllllIIlIllI = 0;
        int llllllllllllllIIlIlIlllllIIlIlIl = 0;
        int llllllllllllllIIlIlIlllllIIlIlII = 0;
        if (llllllllllllllIIlIlIlllllIIlIlll.func_190926_b()) {
            this.outputSlot.setInventorySlotContents(0, ItemStack.field_190927_a);
            this.maximumCost = 0;
        }
        else {
            ItemStack llllllllllllllIIlIlIlllllIIlIIll = llllllllllllllIIlIlIlllllIIlIlll.copy();
            final ItemStack llllllllllllllIIlIlIlllllIIlIIlI = this.inputSlots.getStackInSlot(1);
            final Map<Enchantment, Integer> llllllllllllllIIlIlIlllllIIlIIIl = EnchantmentHelper.getEnchantments(llllllllllllllIIlIlIlllllIIlIIll);
            llllllllllllllIIlIlIlllllIIlIlIl = llllllllllllllIIlIlIlllllIIlIlIl + llllllllllllllIIlIlIlllllIIlIlll.getRepairCost() + (llllllllllllllIIlIlIlllllIIlIIlI.func_190926_b() ? 0 : llllllllllllllIIlIlIlllllIIlIIlI.getRepairCost());
            this.materialCost = 0;
            if (!llllllllllllllIIlIlIlllllIIlIIlI.func_190926_b()) {
                final boolean llllllllllllllIIlIlIlllllIIlIIII = llllllllllllllIIlIlIlllllIIlIIlI.getItem() == Items.ENCHANTED_BOOK && !ItemEnchantedBook.getEnchantments(llllllllllllllIIlIlIlllllIIlIIlI).hasNoTags();
                if (llllllllllllllIIlIlIlllllIIlIIll.isItemStackDamageable() && llllllllllllllIIlIlIlllllIIlIIll.getItem().getIsRepairable(llllllllllllllIIlIlIlllllIIlIlll, llllllllllllllIIlIlIlllllIIlIIlI)) {
                    int llllllllllllllIIlIlIlllllIIIllll = Math.min(llllllllllllllIIlIlIlllllIIlIIll.getItemDamage(), llllllllllllllIIlIlIlllllIIlIIll.getMaxDamage() / 4);
                    if (llllllllllllllIIlIlIlllllIIIllll <= 0) {
                        this.outputSlot.setInventorySlotContents(0, ItemStack.field_190927_a);
                        this.maximumCost = 0;
                        return;
                    }
                    int llllllllllllllIIlIlIlllllIIIlllI;
                    for (llllllllllllllIIlIlIlllllIIIlllI = 0; llllllllllllllIIlIlIlllllIIIllll > 0 && llllllllllllllIIlIlIlllllIIIlllI < llllllllllllllIIlIlIlllllIIlIIlI.func_190916_E(); llllllllllllllIIlIlIlllllIIIllll = Math.min(llllllllllllllIIlIlIlllllIIlIIll.getItemDamage(), llllllllllllllIIlIlIlllllIIlIIll.getMaxDamage() / 4), ++llllllllllllllIIlIlIlllllIIIlllI) {
                        final int llllllllllllllIIlIlIlllllIIIllIl = llllllllllllllIIlIlIlllllIIlIIll.getItemDamage() - llllllllllllllIIlIlIlllllIIIllll;
                        llllllllllllllIIlIlIlllllIIlIIll.setItemDamage(llllllllllllllIIlIlIlllllIIIllIl);
                        ++llllllllllllllIIlIlIlllllIIlIllI;
                    }
                    this.materialCost = llllllllllllllIIlIlIlllllIIIlllI;
                }
                else {
                    if (!llllllllllllllIIlIlIlllllIIlIIII && (llllllllllllllIIlIlIlllllIIlIIll.getItem() != llllllllllllllIIlIlIlllllIIlIIlI.getItem() || !llllllllllllllIIlIlIlllllIIlIIll.isItemStackDamageable())) {
                        this.outputSlot.setInventorySlotContents(0, ItemStack.field_190927_a);
                        this.maximumCost = 0;
                        return;
                    }
                    if (llllllllllllllIIlIlIlllllIIlIIll.isItemStackDamageable() && !llllllllllllllIIlIlIlllllIIlIIII) {
                        final int llllllllllllllIIlIlIlllllIIIllII = llllllllllllllIIlIlIlllllIIlIlll.getMaxDamage() - llllllllllllllIIlIlIlllllIIlIlll.getItemDamage();
                        final int llllllllllllllIIlIlIlllllIIIlIll = llllllllllllllIIlIlIlllllIIlIIlI.getMaxDamage() - llllllllllllllIIlIlIlllllIIlIIlI.getItemDamage();
                        final int llllllllllllllIIlIlIlllllIIIlIlI = llllllllllllllIIlIlIlllllIIIlIll + llllllllllllllIIlIlIlllllIIlIIll.getMaxDamage() * 12 / 100;
                        final int llllllllllllllIIlIlIlllllIIIlIIl = llllllllllllllIIlIlIlllllIIIllII + llllllllllllllIIlIlIlllllIIIlIlI;
                        int llllllllllllllIIlIlIlllllIIIlIII = llllllllllllllIIlIlIlllllIIlIIll.getMaxDamage() - llllllllllllllIIlIlIlllllIIIlIIl;
                        if (llllllllllllllIIlIlIlllllIIIlIII < 0) {
                            llllllllllllllIIlIlIlllllIIIlIII = 0;
                        }
                        if (llllllllllllllIIlIlIlllllIIIlIII < llllllllllllllIIlIlIlllllIIlIIll.getMetadata()) {
                            llllllllllllllIIlIlIlllllIIlIIll.setItemDamage(llllllllllllllIIlIlIlllllIIIlIII);
                            llllllllllllllIIlIlIlllllIIlIllI += 2;
                        }
                    }
                    final Map<Enchantment, Integer> llllllllllllllIIlIlIlllllIIIIlll = EnchantmentHelper.getEnchantments(llllllllllllllIIlIlIlllllIIlIIlI);
                    boolean llllllllllllllIIlIlIlllllIIIIllI = false;
                    boolean llllllllllllllIIlIlIlllllIIIIlIl = false;
                    for (final Enchantment llllllllllllllIIlIlIlllllIIIIlII : llllllllllllllIIlIlIlllllIIIIlll.keySet()) {
                        if (llllllllllllllIIlIlIlllllIIIIlII != null) {
                            final int llllllllllllllIIlIlIlllllIIIIIll = llllllllllllllIIlIlIlllllIIlIIIl.containsKey(llllllllllllllIIlIlIlllllIIIIlII) ? llllllllllllllIIlIlIlllllIIlIIIl.get(llllllllllllllIIlIlIlllllIIIIlII) : 0;
                            int llllllllllllllIIlIlIlllllIIIIIlI = llllllllllllllIIlIlIlllllIIIIlll.get(llllllllllllllIIlIlIlllllIIIIlII);
                            llllllllllllllIIlIlIlllllIIIIIlI = ((llllllllllllllIIlIlIlllllIIIIIll == llllllllllllllIIlIlIlllllIIIIIlI) ? (llllllllllllllIIlIlIlllllIIIIIlI + 1) : Math.max(llllllllllllllIIlIlIlllllIIIIIlI, llllllllllllllIIlIlIlllllIIIIIll));
                            boolean llllllllllllllIIlIlIlllllIIIIIIl = llllllllllllllIIlIlIlllllIIIIlII.canApply(llllllllllllllIIlIlIlllllIIlIlll);
                            if (this.thePlayer.capabilities.isCreativeMode || llllllllllllllIIlIlIlllllIIlIlll.getItem() == Items.ENCHANTED_BOOK) {
                                llllllllllllllIIlIlIlllllIIIIIIl = true;
                            }
                            for (final Enchantment llllllllllllllIIlIlIlllllIIIIIII : llllllllllllllIIlIlIlllllIIlIIIl.keySet()) {
                                if (llllllllllllllIIlIlIlllllIIIIIII != llllllllllllllIIlIlIlllllIIIIlII && !llllllllllllllIIlIlIlllllIIIIlII.func_191560_c(llllllllllllllIIlIlIlllllIIIIIII)) {
                                    llllllllllllllIIlIlIlllllIIIIIIl = false;
                                    ++llllllllllllllIIlIlIlllllIIlIllI;
                                }
                            }
                            if (!llllllllllllllIIlIlIlllllIIIIIIl) {
                                llllllllllllllIIlIlIlllllIIIIlIl = true;
                            }
                            else {
                                llllllllllllllIIlIlIlllllIIIIllI = true;
                                if (llllllllllllllIIlIlIlllllIIIIIlI > llllllllllllllIIlIlIlllllIIIIlII.getMaxLevel()) {
                                    llllllllllllllIIlIlIlllllIIIIIlI = llllllllllllllIIlIlIlllllIIIIlII.getMaxLevel();
                                }
                                llllllllllllllIIlIlIlllllIIlIIIl.put(llllllllllllllIIlIlIlllllIIIIlII, llllllllllllllIIlIlIlllllIIIIIlI);
                                int llllllllllllllIIlIlIllllIlllllll = 0;
                                switch ($SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity()[llllllllllllllIIlIlIlllllIIIIlII.getRarity().ordinal()]) {
                                    case 1: {
                                        llllllllllllllIIlIlIllllIlllllll = 1;
                                        break;
                                    }
                                    case 2: {
                                        llllllllllllllIIlIlIllllIlllllll = 2;
                                        break;
                                    }
                                    case 3: {
                                        llllllllllllllIIlIlIllllIlllllll = 4;
                                        break;
                                    }
                                    case 4: {
                                        llllllllllllllIIlIlIllllIlllllll = 8;
                                        break;
                                    }
                                }
                                if (llllllllllllllIIlIlIlllllIIlIIII) {
                                    llllllllllllllIIlIlIllllIlllllll = Math.max(1, llllllllllllllIIlIlIllllIlllllll / 2);
                                }
                                llllllllllllllIIlIlIlllllIIlIllI += llllllllllllllIIlIlIllllIlllllll * llllllllllllllIIlIlIlllllIIIIIlI;
                                if (llllllllllllllIIlIlIlllllIIlIlll.func_190916_E() <= 1) {
                                    continue;
                                }
                                llllllllllllllIIlIlIlllllIIlIllI = 40;
                            }
                        }
                    }
                    if (llllllllllllllIIlIlIlllllIIIIlIl && !llllllllllllllIIlIlIlllllIIIIllI) {
                        this.outputSlot.setInventorySlotContents(0, ItemStack.field_190927_a);
                        this.maximumCost = 0;
                        return;
                    }
                }
            }
            if (StringUtils.isBlank((CharSequence)this.repairedItemName)) {
                if (llllllllllllllIIlIlIlllllIIlIlll.hasDisplayName()) {
                    llllllllllllllIIlIlIlllllIIlIlII = 1;
                    llllllllllllllIIlIlIlllllIIlIllI += llllllllllllllIIlIlIlllllIIlIlII;
                    llllllllllllllIIlIlIlllllIIlIIll.clearCustomName();
                }
            }
            else if (!this.repairedItemName.equals(llllllllllllllIIlIlIlllllIIlIlll.getDisplayName())) {
                llllllllllllllIIlIlIlllllIIlIlII = 1;
                llllllllllllllIIlIlIlllllIIlIllI += llllllllllllllIIlIlIlllllIIlIlII;
                llllllllllllllIIlIlIlllllIIlIIll.setStackDisplayName(this.repairedItemName);
            }
            this.maximumCost = llllllllllllllIIlIlIlllllIIlIlIl + llllllllllllllIIlIlIlllllIIlIllI;
            if (llllllllllllllIIlIlIlllllIIlIllI <= 0) {
                llllllllllllllIIlIlIlllllIIlIIll = ItemStack.field_190927_a;
            }
            if (llllllllllllllIIlIlIlllllIIlIlII == llllllllllllllIIlIlIlllllIIlIllI && llllllllllllllIIlIlIlllllIIlIlII > 0 && this.maximumCost >= 40) {
                this.maximumCost = 39;
            }
            if (this.maximumCost >= 40 && !this.thePlayer.capabilities.isCreativeMode) {
                llllllllllllllIIlIlIlllllIIlIIll = ItemStack.field_190927_a;
            }
            if (!llllllllllllllIIlIlIlllllIIlIIll.func_190926_b()) {
                int llllllllllllllIIlIlIllllIllllllI = llllllllllllllIIlIlIlllllIIlIIll.getRepairCost();
                if (!llllllllllllllIIlIlIlllllIIlIIlI.func_190926_b() && llllllllllllllIIlIlIllllIllllllI < llllllllllllllIIlIlIlllllIIlIIlI.getRepairCost()) {
                    llllllllllllllIIlIlIllllIllllllI = llllllllllllllIIlIlIlllllIIlIIlI.getRepairCost();
                }
                if (llllllllllllllIIlIlIlllllIIlIlII != llllllllllllllIIlIlIlllllIIlIllI || llllllllllllllIIlIlIlllllIIlIlII == 0) {
                    llllllllllllllIIlIlIllllIllllllI = llllllllllllllIIlIlIllllIllllllI * 2 + 1;
                }
                llllllllllllllIIlIlIlllllIIlIIll.setRepairCost(llllllllllllllIIlIlIllllIllllllI);
                EnchantmentHelper.setEnchantments(llllllllllllllIIlIlIlllllIIlIIIl, llllllllllllllIIlIlIlllllIIlIIll);
            }
            this.outputSlot.setInventorySlotContents(0, llllllllllllllIIlIlIlllllIIlIIll);
            this.detectAndSendChanges();
        }
    }
    
    @Override
    public void addListener(final IContainerListener llllllllllllllIIlIlIllllIllIIlll) {
        super.addListener(llllllllllllllIIlIlIllllIllIIlll);
        llllllllllllllIIlIlIllllIllIIlll.sendProgressBarUpdate(this, 0, this.maximumCost);
    }
    
    @Override
    public void updateProgressBar(final int llllllllllllllIIlIlIllllIllIIIII, final int llllllllllllllIIlIlIllllIlIlllII) {
        if (llllllllllllllIIlIlIllllIllIIIII == 0) {
            this.maximumCost = llllllllllllllIIlIlIllllIlIlllII;
        }
    }
    
    public ContainerRepair(final InventoryPlayer llllllllllllllIIlIlIlllllIllIlll, final World llllllllllllllIIlIlIlllllIllIllI, final BlockPos llllllllllllllIIlIlIlllllIllllIl, final EntityPlayer llllllllllllllIIlIlIlllllIllIlII) {
        this.outputSlot = new InventoryCraftResult();
        this.inputSlots = new InventoryBasic("Repair", true, 2) {
            @Override
            public void markDirty() {
                super.markDirty();
                ContainerRepair.this.onCraftMatrixChanged(this);
            }
        };
        this.selfPosition = llllllllllllllIIlIlIlllllIllllIl;
        this.theWorld = llllllllllllllIIlIlIlllllIllIllI;
        this.thePlayer = llllllllllllllIIlIlIlllllIllIlII;
        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47));
        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47));
        this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47) {
            @Override
            public boolean isItemValid(final ItemStack lllllllllllllIlIIIIIIIIllIIIIlll) {
                return false;
            }
            
            @Override
            public boolean canTakeStack(final EntityPlayer lllllllllllllIlIIIIIIIIllIIIIIll) {
                return (lllllllllllllIlIIIIIIIIllIIIIIll.capabilities.isCreativeMode || lllllllllllllIlIIIIIIIIllIIIIIll.experienceLevel >= ContainerRepair.this.maximumCost) && ContainerRepair.this.maximumCost > 0 && this.getHasStack();
            }
            
            @Override
            public ItemStack func_190901_a(final EntityPlayer lllllllllllllIlIIIIIIIIlIllllIlI, final ItemStack lllllllllllllIlIIIIIIIIlIllllIIl) {
                if (!lllllllllllllIlIIIIIIIIlIllllIlI.capabilities.isCreativeMode) {
                    lllllllllllllIlIIIIIIIIlIllllIlI.addExperienceLevel(-ContainerRepair.this.maximumCost);
                }
                ContainerRepair.this.inputSlots.setInventorySlotContents(0, ItemStack.field_190927_a);
                if (ContainerRepair.this.materialCost > 0) {
                    final ItemStack lllllllllllllIlIIIIIIIIlIllllIII = ContainerRepair.this.inputSlots.getStackInSlot(1);
                    if (!lllllllllllllIlIIIIIIIIlIllllIII.func_190926_b() && lllllllllllllIlIIIIIIIIlIllllIII.func_190916_E() > ContainerRepair.this.materialCost) {
                        lllllllllllllIlIIIIIIIIlIllllIII.func_190918_g(ContainerRepair.this.materialCost);
                        ContainerRepair.this.inputSlots.setInventorySlotContents(1, lllllllllllllIlIIIIIIIIlIllllIII);
                    }
                    else {
                        ContainerRepair.this.inputSlots.setInventorySlotContents(1, ItemStack.field_190927_a);
                    }
                }
                else {
                    ContainerRepair.this.inputSlots.setInventorySlotContents(1, ItemStack.field_190927_a);
                }
                ContainerRepair.this.maximumCost = 0;
                final IBlockState lllllllllllllIlIIIIIIIIlIlllIlll = llllllllllllllIIlIlIlllllIllIllI.getBlockState(llllllllllllllIIlIlIlllllIllllIl);
                if (!lllllllllllllIlIIIIIIIIlIllllIlI.capabilities.isCreativeMode && !llllllllllllllIIlIlIlllllIllIllI.isRemote && lllllllllllllIlIIIIIIIIlIlllIlll.getBlock() == Blocks.ANVIL && lllllllllllllIlIIIIIIIIlIllllIlI.getRNG().nextFloat() < 0.12f) {
                    int lllllllllllllIlIIIIIIIIlIlllIllI = lllllllllllllIlIIIIIIIIlIlllIlll.getValue((IProperty<Integer>)BlockAnvil.DAMAGE);
                    if (++lllllllllllllIlIIIIIIIIlIlllIllI > 2) {
                        llllllllllllllIIlIlIlllllIllIllI.setBlockToAir(llllllllllllllIIlIlIlllllIllllIl);
                        llllllllllllllIIlIlIlllllIllIllI.playEvent(1029, llllllllllllllIIlIlIlllllIllllIl, 0);
                    }
                    else {
                        llllllllllllllIIlIlIlllllIllIllI.setBlockState(llllllllllllllIIlIlIlllllIllllIl, lllllllllllllIlIIIIIIIIlIlllIlll.withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, lllllllllllllIlIIIIIIIIlIlllIllI), 2);
                        llllllllllllllIIlIlIlllllIllIllI.playEvent(1030, llllllllllllllIIlIlIlllllIllllIl, 0);
                    }
                }
                else if (!llllllllllllllIIlIlIlllllIllIllI.isRemote) {
                    llllllllllllllIIlIlIlllllIllIllI.playEvent(1030, llllllllllllllIIlIlIlllllIllllIl, 0);
                }
                return lllllllllllllIlIIIIIIIIlIllllIIl;
            }
        });
        for (int llllllllllllllIIlIlIlllllIlllIll = 0; llllllllllllllIIlIlIlllllIlllIll < 3; ++llllllllllllllIIlIlIlllllIlllIll) {
            for (int llllllllllllllIIlIlIlllllIlllIlI = 0; llllllllllllllIIlIlIlllllIlllIlI < 9; ++llllllllllllllIIlIlIlllllIlllIlI) {
                this.addSlotToContainer(new Slot(llllllllllllllIIlIlIlllllIllIlll, llllllllllllllIIlIlIlllllIlllIlI + llllllllllllllIIlIlIlllllIlllIll * 9 + 9, 8 + llllllllllllllIIlIlIlllllIlllIlI * 18, 84 + llllllllllllllIIlIlIlllllIlllIll * 18));
            }
        }
        for (int llllllllllllllIIlIlIlllllIlllIIl = 0; llllllllllllllIIlIlIlllllIlllIIl < 9; ++llllllllllllllIIlIlIlllllIlllIIl) {
            this.addSlotToContainer(new Slot(llllllllllllllIIlIlIlllllIllIlll, llllllllllllllIIlIlIlllllIlllIIl, 8 + llllllllllllllIIlIlIlllllIlllIIl * 18, 142));
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity() {
        final int[] $switch_TABLE$net$minecraft$enchantment$Enchantment$Rarity = ContainerRepair.$SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity;
        if ($switch_TABLE$net$minecraft$enchantment$Enchantment$Rarity != null) {
            return $switch_TABLE$net$minecraft$enchantment$Enchantment$Rarity;
        }
        final Exception llllllllllllllIIlIlIllllIIlIllll = (Object)new int[Enchantment.Rarity.values().length];
        try {
            llllllllllllllIIlIlIllllIIlIllll[Enchantment.Rarity.COMMON.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIlIlIllllIIlIllll[Enchantment.Rarity.RARE.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIlIlIllllIIlIllll[Enchantment.Rarity.UNCOMMON.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIlIlIllllIIlIllll[Enchantment.Rarity.VERY_RARE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return ContainerRepair.$SWITCH_TABLE$net$minecraft$enchantment$Enchantment$Rarity = (int[])(Object)llllllllllllllIIlIlIllllIIlIllll;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllIIlIlIllllIlIlIllI) {
        super.onContainerClosed(llllllllllllllIIlIlIllllIlIlIllI);
        if (!this.theWorld.isRemote) {
            this.func_193327_a(llllllllllllllIIlIlIllllIlIlIllI, this.theWorld, this.inputSlots);
        }
    }
    
    public ContainerRepair(final InventoryPlayer llllllllllllllIIlIlIllllllIllllI, final World llllllllllllllIIlIlIllllllIllIIl, final EntityPlayer llllllllllllllIIlIlIllllllIlllII) {
        this(llllllllllllllIIlIlIllllllIllllI, llllllllllllllIIlIlIllllllIllIIl, BlockPos.ORIGIN, llllllllllllllIIlIlIllllllIlllII);
    }
}
