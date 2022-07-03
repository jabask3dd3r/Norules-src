package net.minecraft.inventory;

import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import javax.annotation.*;

public class ContainerPlayer extends Container
{
    public /* synthetic */ InventoryCraftResult craftResult;
    public /* synthetic */ InventoryCrafting craftMatrix;
    public /* synthetic */ boolean isLocalWorld;
    private static final /* synthetic */ EntityEquipmentSlot[] VALID_EQUIPMENT_SLOTS;
    private final /* synthetic */ EntityPlayer thePlayer;
    
    static {
        VALID_EQUIPMENT_SLOTS = new EntityEquipmentSlot[] { EntityEquipmentSlot.HEAD, EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET };
    }
    
    @Override
    public boolean canInteractWith(final EntityPlayer llllllllllllllllIllIIllllllIllll) {
        return true;
    }
    
    @Override
    public void onContainerClosed(final EntityPlayer llllllllllllllllIllIIlllllllIIll) {
        super.onContainerClosed(llllllllllllllllIllIIlllllllIIll);
        this.craftResult.clear();
        if (!llllllllllllllllIllIIlllllllIIll.world.isRemote) {
            this.func_193327_a(llllllllllllllllIllIIlllllllIIll, llllllllllllllllIllIIlllllllIIll.world, this.craftMatrix);
        }
    }
    
    public ContainerPlayer(final InventoryPlayer llllllllllllllllIllIIlllllllllll, final boolean llllllllllllllllIllIlIIIIIIIlIIl, final EntityPlayer llllllllllllllllIllIlIIIIIIIlIII) {
        this.craftMatrix = new InventoryCrafting(this, 2, 2);
        this.craftResult = new InventoryCraftResult();
        this.isLocalWorld = llllllllllllllllIllIlIIIIIIIlIIl;
        this.thePlayer = llllllllllllllllIllIlIIIIIIIlIII;
        this.addSlotToContainer(new SlotCrafting(llllllllllllllllIllIIlllllllllll.player, this.craftMatrix, this.craftResult, 0, 154, 28));
        for (int llllllllllllllllIllIlIIIIIIIIlll = 0; llllllllllllllllIllIlIIIIIIIIlll < 2; ++llllllllllllllllIllIlIIIIIIIIlll) {
            for (int llllllllllllllllIllIlIIIIIIIIllI = 0; llllllllllllllllIllIlIIIIIIIIllI < 2; ++llllllllllllllllIllIlIIIIIIIIllI) {
                this.addSlotToContainer(new Slot(this.craftMatrix, llllllllllllllllIllIlIIIIIIIIllI + llllllllllllllllIllIlIIIIIIIIlll * 2, 98 + llllllllllllllllIllIlIIIIIIIIllI * 18, 18 + llllllllllllllllIllIlIIIIIIIIlll * 18));
            }
        }
        for (int llllllllllllllllIllIlIIIIIIIIlIl = 0; llllllllllllllllIllIlIIIIIIIIlIl < 4; ++llllllllllllllllIllIlIIIIIIIIlIl) {
            final EntityEquipmentSlot llllllllllllllllIllIlIIIIIIIIlII = ContainerPlayer.VALID_EQUIPMENT_SLOTS[llllllllllllllllIllIlIIIIIIIIlIl];
            this.addSlotToContainer(new Slot(llllllllllllllllIllIIlllllllllll, 36 + (3 - llllllllllllllllIllIlIIIIIIIIlIl), 8, 8 + llllllllllllllllIllIlIIIIIIIIlIl * 18) {
                @Override
                public boolean isItemValid(final ItemStack llIIIIllIIIlllI) {
                    return llllllllllllllllIllIlIIIIIIIIlII == EntityLiving.getSlotForItemStack(llIIIIllIIIlllI);
                }
                
                @Override
                public boolean canTakeStack(final EntityPlayer llIIIIllIIIIllI) {
                    final ItemStack llIIIIllIIIlIII = this.getStack();
                    return (llIIIIllIIIlIII.func_190926_b() || llIIIIllIIIIllI.isCreative() || !EnchantmentHelper.func_190938_b(llIIIIllIIIlIII)) && super.canTakeStack(llIIIIllIIIIllI);
                }
                
                @Nullable
                @Override
                public String getSlotTexture() {
                    return ItemArmor.EMPTY_SLOT_NAMES[llllllllllllllllIllIlIIIIIIIIlII.getIndex()];
                }
                
                @Override
                public int getSlotStackLimit() {
                    return 1;
                }
            });
        }
        for (int llllllllllllllllIllIlIIIIIIIIIll = 0; llllllllllllllllIllIlIIIIIIIIIll < 3; ++llllllllllllllllIllIlIIIIIIIIIll) {
            for (int llllllllllllllllIllIlIIIIIIIIIlI = 0; llllllllllllllllIllIlIIIIIIIIIlI < 9; ++llllllllllllllllIllIlIIIIIIIIIlI) {
                this.addSlotToContainer(new Slot(llllllllllllllllIllIIlllllllllll, llllllllllllllllIllIlIIIIIIIIIlI + (llllllllllllllllIllIlIIIIIIIIIll + 1) * 9, 8 + llllllllllllllllIllIlIIIIIIIIIlI * 18, 84 + llllllllllllllllIllIlIIIIIIIIIll * 18));
            }
        }
        for (int llllllllllllllllIllIlIIIIIIIIIIl = 0; llllllllllllllllIllIlIIIIIIIIIIl < 9; ++llllllllllllllllIllIlIIIIIIIIIIl) {
            this.addSlotToContainer(new Slot(llllllllllllllllIllIIlllllllllll, llllllllllllllllIllIlIIIIIIIIIIl, 8 + llllllllllllllllIllIlIIIIIIIIIIl * 18, 142));
        }
        this.addSlotToContainer(new Slot(llllllllllllllllIllIIlllllllllll, 40, 77, 62) {
            @Nullable
            @Override
            public String getSlotTexture() {
                return "minecraft:items/empty_armor_slot_shield";
            }
        });
    }
    
    @Override
    public void onCraftMatrixChanged(final IInventory llllllllllllllllIllIIllllllllIII) {
        this.func_192389_a(this.thePlayer.world, this.thePlayer, this.craftMatrix, this.craftResult);
    }
    
    @Override
    public ItemStack transferStackInSlot(final EntityPlayer llllllllllllllllIllIIllllllIIlIl, final int llllllllllllllllIllIIllllllIIlII) {
        ItemStack llllllllllllllllIllIIllllllIIIll = ItemStack.field_190927_a;
        final Slot llllllllllllllllIllIIllllllIIIlI = this.inventorySlots.get(llllllllllllllllIllIIllllllIIlII);
        if (llllllllllllllllIllIIllllllIIIlI != null && llllllllllllllllIllIIllllllIIIlI.getHasStack()) {
            final ItemStack llllllllllllllllIllIIllllllIIIIl = llllllllllllllllIllIIllllllIIIlI.getStack();
            llllllllllllllllIllIIllllllIIIll = llllllllllllllllIllIIllllllIIIIl.copy();
            final EntityEquipmentSlot llllllllllllllllIllIIllllllIIIII = EntityLiving.getSlotForItemStack(llllllllllllllllIllIIllllllIIIll);
            if (llllllllllllllllIllIIllllllIIlII == 0) {
                if (!this.mergeItemStack(llllllllllllllllIllIIllllllIIIIl, 9, 45, true)) {
                    return ItemStack.field_190927_a;
                }
                llllllllllllllllIllIIllllllIIIlI.onSlotChange(llllllllllllllllIllIIllllllIIIIl, llllllllllllllllIllIIllllllIIIll);
            }
            else if (llllllllllllllllIllIIllllllIIlII >= 1 && llllllllllllllllIllIIllllllIIlII < 5) {
                if (!this.mergeItemStack(llllllllllllllllIllIIllllllIIIIl, 9, 45, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (llllllllllllllllIllIIllllllIIlII >= 5 && llllllllllllllllIllIIllllllIIlII < 9) {
                if (!this.mergeItemStack(llllllllllllllllIllIIllllllIIIIl, 9, 45, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (llllllllllllllllIllIIllllllIIIII.getSlotType() == EntityEquipmentSlot.Type.ARMOR && !this.inventorySlots.get(8 - llllllllllllllllIllIIllllllIIIII.getIndex()).getHasStack()) {
                final int llllllllllllllllIllIIlllllIlllll = 8 - llllllllllllllllIllIIllllllIIIII.getIndex();
                if (!this.mergeItemStack(llllllllllllllllIllIIllllllIIIIl, llllllllllllllllIllIIlllllIlllll, llllllllllllllllIllIIlllllIlllll + 1, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (llllllllllllllllIllIIllllllIIIII == EntityEquipmentSlot.OFFHAND && !this.inventorySlots.get(45).getHasStack()) {
                if (!this.mergeItemStack(llllllllllllllllIllIIllllllIIIIl, 45, 46, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (llllllllllllllllIllIIllllllIIlII >= 9 && llllllllllllllllIllIIllllllIIlII < 36) {
                if (!this.mergeItemStack(llllllllllllllllIllIIllllllIIIIl, 36, 45, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (llllllllllllllllIllIIllllllIIlII >= 36 && llllllllllllllllIllIIllllllIIlII < 45) {
                if (!this.mergeItemStack(llllllllllllllllIllIIllllllIIIIl, 9, 36, false)) {
                    return ItemStack.field_190927_a;
                }
            }
            else if (!this.mergeItemStack(llllllllllllllllIllIIllllllIIIIl, 9, 45, false)) {
                return ItemStack.field_190927_a;
            }
            if (llllllllllllllllIllIIllllllIIIIl.func_190926_b()) {
                llllllllllllllllIllIIllllllIIIlI.putStack(ItemStack.field_190927_a);
            }
            else {
                llllllllllllllllIllIIllllllIIIlI.onSlotChanged();
            }
            if (llllllllllllllllIllIIllllllIIIIl.func_190916_E() == llllllllllllllllIllIIllllllIIIll.func_190916_E()) {
                return ItemStack.field_190927_a;
            }
            final ItemStack llllllllllllllllIllIIlllllIllllI = llllllllllllllllIllIIllllllIIIlI.func_190901_a(llllllllllllllllIllIIllllllIIlIl, llllllllllllllllIllIIllllllIIIIl);
            if (llllllllllllllllIllIIllllllIIlII == 0) {
                llllllllllllllllIllIIllllllIIlIl.dropItem(llllllllllllllllIllIIlllllIllllI, false);
            }
        }
        return llllllllllllllllIllIIllllllIIIll;
    }
    
    @Override
    public boolean canMergeSlot(final ItemStack llllllllllllllllIllIIlllllIlIIIl, final Slot llllllllllllllllIllIIlllllIIllIl) {
        return llllllllllllllllIllIIlllllIIllIl.inventory != this.craftResult && super.canMergeSlot(llllllllllllllllIllIIlllllIlIIIl, llllllllllllllllIllIIlllllIIllIl);
    }
}
