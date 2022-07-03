package net.minecraft.entity.player;

import net.minecraft.util.*;
import net.minecraft.crash.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.util.text.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.network.play.server.*;
import net.minecraft.network.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import java.util.*;

public class InventoryPlayer implements IInventory
{
    private /* synthetic */ ItemStack itemStack;
    public final /* synthetic */ NonNullList<ItemStack> mainInventory;
    public /* synthetic */ EntityPlayer player;
    public final /* synthetic */ NonNullList<ItemStack> offHandInventory;
    private final /* synthetic */ List<NonNullList<ItemStack>> allInventories;
    public /* synthetic */ int currentItem;
    private /* synthetic */ int field_194017_h;
    public final /* synthetic */ NonNullList<ItemStack> armorInventory;
    
    @Override
    public int getSizeInventory() {
        return this.mainInventory.size() + this.armorInventory.size() + this.offHandInventory.size();
    }
    
    public boolean func_191971_c(int lllllllllllllIIllllIIllllllIIIlI, final ItemStack lllllllllllllIIllllIIllllllIIIIl) {
        if (lllllllllllllIIllllIIllllllIIIIl.func_190926_b()) {
            return false;
        }
        try {
            if (lllllllllllllIIllllIIllllllIIIIl.isItemDamaged()) {
                if (lllllllllllllIIllllIIllllllIIIlI == -1) {
                    lllllllllllllIIllllIIllllllIIIlI = this.getFirstEmptyStack();
                }
                if (lllllllllllllIIllllIIllllllIIIlI >= 0) {
                    this.mainInventory.set(lllllllllllllIIllllIIllllllIIIlI, lllllllllllllIIllllIIllllllIIIIl.copy());
                    this.mainInventory.get(lllllllllllllIIllllIIllllllIIIlI).func_190915_d(5);
                    lllllllllllllIIllllIIllllllIIIIl.func_190920_e(0);
                    return true;
                }
                if (this.player.capabilities.isCreativeMode) {
                    lllllllllllllIIllllIIllllllIIIIl.func_190920_e(0);
                    return true;
                }
                return false;
            }
            else {
                int lllllllllllllIIllllIIllllllIIlll;
                do {
                    lllllllllllllIIllllIIllllllIIlll = lllllllllllllIIllllIIllllllIIIIl.func_190916_E();
                    if (lllllllllllllIIllllIIllllllIIIlI == -1) {
                        lllllllllllllIIllllIIllllllIIIIl.func_190920_e(this.storePartialItemStack(lllllllllllllIIllllIIllllllIIIIl));
                    }
                    else {
                        lllllllllllllIIllllIIllllllIIIIl.func_190920_e(this.func_191973_d(lllllllllllllIIllllIIllllllIIIlI, lllllllllllllIIllllIIllllllIIIIl));
                    }
                } while (!lllllllllllllIIllllIIllllllIIIIl.func_190926_b() && lllllllllllllIIllllIIllllllIIIIl.func_190916_E() < lllllllllllllIIllllIIllllllIIlll);
                if (lllllllllllllIIllllIIllllllIIIIl.func_190916_E() == lllllllllllllIIllllIIllllllIIlll && this.player.capabilities.isCreativeMode) {
                    lllllllllllllIIllllIIllllllIIIIl.func_190920_e(0);
                    return true;
                }
                return lllllllllllllIIllllIIllllllIIIIl.func_190916_E() < lllllllllllllIIllllIIllllllIIlll;
            }
        }
        catch (Throwable lllllllllllllIIllllIIllllllIIllI) {
            final CrashReport lllllllllllllIIllllIIllllllIIlIl = CrashReport.makeCrashReport(lllllllllllllIIllllIIllllllIIllI, "Adding item to inventory");
            final CrashReportCategory lllllllllllllIIllllIIllllllIIlII = lllllllllllllIIllllIIllllllIIlIl.makeCategory("Item being added");
            lllllllllllllIIllllIIllllllIIlII.addCrashSection("Item ID", Item.getIdFromItem(lllllllllllllIIllllIIllllllIIIIl.getItem()));
            lllllllllllllIIllllIIllllllIIlII.addCrashSection("Item data", lllllllllllllIIllllIIllllllIIIIl.getMetadata());
            lllllllllllllIIllllIIllllllIIlII.setDetail("Item name", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return lllllllllllllIIllllIIllllllIIIIl.getDisplayName();
                }
            });
            throw new ReportedException(lllllllllllllIIllllIIllllllIIlIl);
        }
    }
    
    private int storePartialItemStack(final ItemStack lllllllllllllIIllllIlIIIIIlIIIIl) {
        int lllllllllllllIIllllIlIIIIIlIIIll = this.storeItemStack(lllllllllllllIIllllIlIIIIIlIIIIl);
        if (lllllllllllllIIllllIlIIIIIlIIIll == -1) {
            lllllllllllllIIllllIlIIIIIlIIIll = this.getFirstEmptyStack();
        }
        return (lllllllllllllIIllllIlIIIIIlIIIll == -1) ? lllllllllllllIIllllIlIIIIIlIIIIl.func_190916_E() : this.func_191973_d(lllllllllllllIIllllIlIIIIIlIIIll, lllllllllllllIIllllIlIIIIIlIIIIl);
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    public boolean addItemStackToInventory(final ItemStack lllllllllllllIIllllIIlllllllIIIl) {
        return this.func_191971_c(-1, lllllllllllllIIllllIIlllllllIIIl);
    }
    
    public float getStrVsBlock(final IBlockState lllllllllllllIIllllIIllllIIIlIll) {
        float lllllllllllllIIllllIIllllIIIlIlI = 1.0f;
        if (!this.mainInventory.get(this.currentItem).func_190926_b()) {
            lllllllllllllIIllllIIllllIIIlIlI *= this.mainInventory.get(this.currentItem).getStrVsBlock(lllllllllllllIIllllIIllllIIIlIll);
        }
        return lllllllllllllIIllllIIllllIIIlIlI;
    }
    
    public int getSlotFor(final ItemStack lllllllllllllIIllllIlIIIIllIIIll) {
        for (int lllllllllllllIIllllIlIIIIllIIlIl = 0; lllllllllllllIIllllIlIIIIllIIlIl < this.mainInventory.size(); ++lllllllllllllIIllllIlIIIIllIIlIl) {
            if (!this.mainInventory.get(lllllllllllllIIllllIlIIIIllIIlIl).func_190926_b() && this.stackEqualExact(lllllllllllllIIllllIlIIIIllIIIll, this.mainInventory.get(lllllllllllllIIllllIlIIIIllIIlIl))) {
                return lllllllllllllIIllllIlIIIIllIIlIl;
            }
        }
        return -1;
    }
    
    public NBTTagList writeToNBT(final NBTTagList lllllllllllllIIllllIIllllIIIIIIl) {
        for (int lllllllllllllIIllllIIllllIIIIIII = 0; lllllllllllllIIllllIIllllIIIIIII < this.mainInventory.size(); ++lllllllllllllIIllllIIllllIIIIIII) {
            if (!this.mainInventory.get(lllllllllllllIIllllIIllllIIIIIII).func_190926_b()) {
                final NBTTagCompound lllllllllllllIIllllIIlllIlllllll = new NBTTagCompound();
                lllllllllllllIIllllIIlllIlllllll.setByte("Slot", (byte)lllllllllllllIIllllIIllllIIIIIII);
                this.mainInventory.get(lllllllllllllIIllllIIllllIIIIIII).writeToNBT(lllllllllllllIIllllIIlllIlllllll);
                lllllllllllllIIllllIIllllIIIIIIl.appendTag(lllllllllllllIIllllIIlllIlllllll);
            }
        }
        for (int lllllllllllllIIllllIIlllIllllllI = 0; lllllllllllllIIllllIIlllIllllllI < this.armorInventory.size(); ++lllllllllllllIIllllIIlllIllllllI) {
            if (!this.armorInventory.get(lllllllllllllIIllllIIlllIllllllI).func_190926_b()) {
                final NBTTagCompound lllllllllllllIIllllIIlllIlllllIl = new NBTTagCompound();
                lllllllllllllIIllllIIlllIlllllIl.setByte("Slot", (byte)(lllllllllllllIIllllIIlllIllllllI + 100));
                this.armorInventory.get(lllllllllllllIIllllIIlllIllllllI).writeToNBT(lllllllllllllIIllllIIlllIlllllIl);
                lllllllllllllIIllllIIllllIIIIIIl.appendTag(lllllllllllllIIllllIIlllIlllllIl);
            }
        }
        for (int lllllllllllllIIllllIIlllIlllllII = 0; lllllllllllllIIllllIIlllIlllllII < this.offHandInventory.size(); ++lllllllllllllIIllllIIlllIlllllII) {
            if (!this.offHandInventory.get(lllllllllllllIIllllIIlllIlllllII).func_190926_b()) {
                final NBTTagCompound lllllllllllllIIllllIIlllIllllIll = new NBTTagCompound();
                lllllllllllllIIllllIIlllIllllIll.setByte("Slot", (byte)(lllllllllllllIIllllIIlllIlllllII + 150));
                this.offHandInventory.get(lllllllllllllIIllllIIlllIlllllII).writeToNBT(lllllllllllllIIllllIIlllIllllIll);
                lllllllllllllIIllllIIllllIIIIIIl.appendTag(lllllllllllllIIllllIIlllIllllIll);
            }
        }
        return lllllllllllllIIllllIIllllIIIIIIl;
    }
    
    private boolean canMergeStacks(final ItemStack lllllllllllllIIllllIlIIIlIIlIIIl, final ItemStack lllllllllllllIIllllIlIIIlIIlIIll) {
        return !lllllllllllllIIllllIlIIIlIIlIIIl.func_190926_b() && this.stackEqualExact(lllllllllllllIIllllIlIIIlIIlIIIl, lllllllllllllIIllllIlIIIlIIlIIll) && lllllllllllllIIllllIlIIIlIIlIIIl.isStackable() && lllllllllllllIIllllIlIIIlIIlIIIl.func_190916_E() < lllllllllllllIIllllIlIIIlIIlIIIl.getMaxStackSize() && lllllllllllllIIllllIlIIIlIIlIIIl.func_190916_E() < this.getInventoryStackLimit();
    }
    
    @Override
    public ItemStack getStackInSlot(int lllllllllllllIIllllIIlllIlIIllIl) {
        List<ItemStack> lllllllllllllIIllllIIlllIlIlIIII = null;
        for (final NonNullList<ItemStack> lllllllllllllIIllllIIlllIlIIllll : this.allInventories) {
            if (lllllllllllllIIllllIIlllIlIIllIl < lllllllllllllIIllllIIlllIlIIllll.size()) {
                lllllllllllllIIllllIIlllIlIlIIII = lllllllllllllIIllllIIlllIlIIllll;
                break;
            }
            lllllllllllllIIllllIIlllIlIIllIl -= lllllllllllllIIllllIIlllIlIIllll.size();
        }
        return (lllllllllllllIIllllIIlllIlIlIIII == null) ? ItemStack.field_190927_a : lllllllllllllIIllllIIlllIlIlIIII.get(lllllllllllllIIllllIIlllIlIIllIl);
    }
    
    public void pickItem(final int lllllllllllllIIllllIlIIIIllIllll) {
        this.currentItem = this.getBestHotbarSlot();
        final ItemStack lllllllllllllIIllllIlIIIIlllIIIl = this.mainInventory.get(this.currentItem);
        this.mainInventory.set(this.currentItem, this.mainInventory.get(lllllllllllllIIllllIlIIIIllIllll));
        this.mainInventory.set(lllllllllllllIIllllIlIIIIllIllll, lllllllllllllIIllllIlIIIIlllIIIl);
    }
    
    private boolean stackEqualExact(final ItemStack lllllllllllllIIllllIlIIIlIIIllII, final ItemStack lllllllllllllIIllllIlIIIlIIIlIIl) {
        return lllllllllllllIIllllIlIIIlIIIllII.getItem() == lllllllllllllIIllllIlIIIlIIIlIIl.getItem() && (!lllllllllllllIIllllIlIIIlIIIllII.getHasSubtypes() || lllllllllllllIIllllIlIIIlIIIllII.getMetadata() == lllllllllllllIIllllIlIIIlIIIlIIl.getMetadata()) && ItemStack.areItemStackTagsEqual(lllllllllllllIIllllIlIIIlIIIllII, lllllllllllllIIllllIlIIIlIIIlIIl);
    }
    
    public int clearMatchingItems(@Nullable final Item lllllllllllllIIllllIlIIIIIllIIII, final int lllllllllllllIIllllIlIIIIIlllIIl, final int lllllllllllllIIllllIlIIIIIlllIII, @Nullable final NBTTagCompound lllllllllllllIIllllIlIIIIIlIllIl) {
        int lllllllllllllIIllllIlIIIIIllIllI = 0;
        for (int lllllllllllllIIllllIlIIIIIllIlIl = 0; lllllllllllllIIllllIlIIIIIllIlIl < this.getSizeInventory(); ++lllllllllllllIIllllIlIIIIIllIlIl) {
            final ItemStack lllllllllllllIIllllIlIIIIIllIlII = this.getStackInSlot(lllllllllllllIIllllIlIIIIIllIlIl);
            if (!lllllllllllllIIllllIlIIIIIllIlII.func_190926_b() && (lllllllllllllIIllllIlIIIIIllIIII == null || lllllllllllllIIllllIlIIIIIllIlII.getItem() == lllllllllllllIIllllIlIIIIIllIIII) && (lllllllllllllIIllllIlIIIIIlllIIl <= -1 || lllllllllllllIIllllIlIIIIIllIlII.getMetadata() == lllllllllllllIIllllIlIIIIIlllIIl) && (lllllllllllllIIllllIlIIIIIlIllIl == null || NBTUtil.areNBTEquals(lllllllllllllIIllllIlIIIIIlIllIl, lllllllllllllIIllllIlIIIIIllIlII.getTagCompound(), true))) {
                final int lllllllllllllIIllllIlIIIIIllIIll = (lllllllllllllIIllllIlIIIIIlllIII <= 0) ? lllllllllllllIIllllIlIIIIIllIlII.func_190916_E() : Math.min(lllllllllllllIIllllIlIIIIIlllIII - lllllllllllllIIllllIlIIIIIllIllI, lllllllllllllIIllllIlIIIIIllIlII.func_190916_E());
                lllllllllllllIIllllIlIIIIIllIllI += lllllllllllllIIllllIlIIIIIllIIll;
                if (lllllllllllllIIllllIlIIIIIlllIII != 0) {
                    lllllllllllllIIllllIlIIIIIllIlII.func_190918_g(lllllllllllllIIllllIlIIIIIllIIll);
                    if (lllllllllllllIIllllIlIIIIIllIlII.func_190926_b()) {
                        this.setInventorySlotContents(lllllllllllllIIllllIlIIIIIllIlIl, ItemStack.field_190927_a);
                    }
                    if (lllllllllllllIIllllIlIIIIIlllIII > 0 && lllllllllllllIIllllIlIIIIIllIllI >= lllllllllllllIIllllIlIIIIIlllIII) {
                        return lllllllllllllIIllllIlIIIIIllIllI;
                    }
                }
            }
        }
        if (!this.itemStack.func_190926_b()) {
            if (lllllllllllllIIllllIlIIIIIllIIII != null && this.itemStack.getItem() != lllllllllllllIIllllIlIIIIIllIIII) {
                return lllllllllllllIIllllIlIIIIIllIllI;
            }
            if (lllllllllllllIIllllIlIIIIIlllIIl > -1 && this.itemStack.getMetadata() != lllllllllllllIIllllIlIIIIIlllIIl) {
                return lllllllllllllIIllllIlIIIIIllIllI;
            }
            if (lllllllllllllIIllllIlIIIIIlIllIl != null && !NBTUtil.areNBTEquals(lllllllllllllIIllllIlIIIIIlIllIl, this.itemStack.getTagCompound(), true)) {
                return lllllllllllllIIllllIlIIIIIllIllI;
            }
            final int lllllllllllllIIllllIlIIIIIllIIlI = (lllllllllllllIIllllIlIIIIIlllIII <= 0) ? this.itemStack.func_190916_E() : Math.min(lllllllllllllIIllllIlIIIIIlllIII - lllllllllllllIIllllIlIIIIIllIllI, this.itemStack.func_190916_E());
            lllllllllllllIIllllIlIIIIIllIllI += lllllllllllllIIllllIlIIIIIllIIlI;
            if (lllllllllllllIIllllIlIIIIIlllIII != 0) {
                this.itemStack.func_190918_g(lllllllllllllIIllllIlIIIIIllIIlI);
                if (this.itemStack.func_190926_b()) {
                    this.itemStack = ItemStack.field_190927_a;
                }
                if (lllllllllllllIIllllIlIIIIIlllIII > 0 && lllllllllllllIIllllIlIIIIIllIllI >= lllllllllllllIIllllIlIIIIIlllIII) {
                    return lllllllllllllIIllllIlIIIIIllIllI;
                }
            }
        }
        return lllllllllllllIIllllIlIIIIIllIllI;
    }
    
    public void readFromNBT(final NBTTagList lllllllllllllIIllllIIlllIllIllll) {
        this.mainInventory.clear();
        this.armorInventory.clear();
        this.offHandInventory.clear();
        for (int lllllllllllllIIllllIIlllIllIlllI = 0; lllllllllllllIIllllIIlllIllIlllI < lllllllllllllIIllllIIlllIllIllll.tagCount(); ++lllllllllllllIIllllIIlllIllIlllI) {
            final NBTTagCompound lllllllllllllIIllllIIlllIllIllIl = lllllllllllllIIllllIIlllIllIllll.getCompoundTagAt(lllllllllllllIIllllIIlllIllIlllI);
            final int lllllllllllllIIllllIIlllIllIllII = lllllllllllllIIllllIIlllIllIllIl.getByte("Slot") & 0xFF;
            final ItemStack lllllllllllllIIllllIIlllIllIlIll = new ItemStack(lllllllllllllIIllllIIlllIllIllIl);
            if (!lllllllllllllIIllllIIlllIllIlIll.func_190926_b()) {
                if (lllllllllllllIIllllIIlllIllIllII >= 0 && lllllllllllllIIllllIIlllIllIllII < this.mainInventory.size()) {
                    this.mainInventory.set(lllllllllllllIIllllIIlllIllIllII, lllllllllllllIIllllIIlllIllIlIll);
                }
                else if (lllllllllllllIIllllIIlllIllIllII >= 100 && lllllllllllllIIllllIIlllIllIllII < this.armorInventory.size() + 100) {
                    this.armorInventory.set(lllllllllllllIIllllIIlllIllIllII - 100, lllllllllllllIIllllIIlllIllIlIll);
                }
                else if (lllllllllllllIIllllIIlllIllIllII >= 150 && lllllllllllllIIllllIIlllIllIllII < this.offHandInventory.size() + 150) {
                    this.offHandInventory.set(lllllllllllllIIllllIIlllIllIllII - 150, lllllllllllllIIllllIIlllIllIlIll);
                }
            }
        }
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public void deleteStack(final ItemStack lllllllllllllIIllllIIllllIllIlll) {
        for (final NonNullList<ItemStack> lllllllllllllIIllllIIllllIllIllI : this.allInventories) {
            for (int lllllllllllllIIllllIIllllIllIlIl = 0; lllllllllllllIIllllIIllllIllIlIl < lllllllllllllIIllllIIllllIllIllI.size(); ++lllllllllllllIIllllIIllllIllIlIl) {
                if (lllllllllllllIIllllIIllllIllIllI.get(lllllllllllllIIllllIIllllIllIlIl) == lllllllllllllIIllllIIllllIllIlll) {
                    lllllllllllllIIllllIIllllIllIllI.set(lllllllllllllIIllllIIllllIllIlIl, ItemStack.field_190927_a);
                    break;
                }
            }
        }
    }
    
    public ItemStack armorItemInSlot(final int lllllllllllllIIllllIIlllIIllIlIl) {
        return this.armorInventory.get(lllllllllllllIIllllIIlllIIllIlIl);
    }
    
    @Override
    public void markDirty() {
        ++this.field_194017_h;
    }
    
    @Override
    public ItemStack decrStackSize(int lllllllllllllIIllllIIlllllIIIIlI, final int lllllllllllllIIllllIIlllllIIIIIl) {
        List<ItemStack> lllllllllllllIIllllIIlllllIIIlIl = null;
        for (final NonNullList<ItemStack> lllllllllllllIIllllIIlllllIIIlII : this.allInventories) {
            if (lllllllllllllIIllllIIlllllIIIIlI < lllllllllllllIIllllIIlllllIIIlII.size()) {
                lllllllllllllIIllllIIlllllIIIlIl = lllllllllllllIIllllIIlllllIIIlII;
                break;
            }
            lllllllllllllIIllllIIlllllIIIIlI -= lllllllllllllIIllllIIlllllIIIlII.size();
        }
        return (lllllllllllllIIllllIIlllllIIIlIl != null && !lllllllllllllIIllllIIlllllIIIlIl.get((int)lllllllllllllIIllllIIlllllIIIIlI).func_190926_b()) ? ItemStackHelper.getAndSplit(lllllllllllllIIllllIIlllllIIIlIl, (int)lllllllllllllIIllllIIlllllIIIIlI, lllllllllllllIIllllIIlllllIIIIIl) : ItemStack.field_190927_a;
    }
    
    public void dropAllItems() {
        for (final List<ItemStack> lllllllllllllIIllllIIlllIIlIIIlI : this.allInventories) {
            for (int lllllllllllllIIllllIIlllIIlIIIIl = 0; lllllllllllllIIllllIIlllIIlIIIIl < lllllllllllllIIllllIIlllIIlIIIlI.size(); ++lllllllllllllIIllllIIlllIIlIIIIl) {
                final ItemStack lllllllllllllIIllllIIlllIIlIIIII = lllllllllllllIIllllIIlllIIlIIIlI.get(lllllllllllllIIllllIIlllIIlIIIIl);
                if (!lllllllllllllIIllllIIlllIIlIIIII.func_190926_b()) {
                    this.player.dropItem(lllllllllllllIIllllIIlllIIlIIIII, true, false);
                    lllllllllllllIIllllIIlllIIlIIIlI.set(lllllllllllllIIllllIIlllIIlIIIIl, ItemStack.field_190927_a);
                }
            }
        }
    }
    
    @Override
    public ItemStack removeStackFromSlot(int lllllllllllllIIllllIIllllIlIIlII) {
        NonNullList<ItemStack> lllllllllllllIIllllIIllllIlIlIII = null;
        for (final NonNullList<ItemStack> lllllllllllllIIllllIIllllIlIIlll : this.allInventories) {
            if (lllllllllllllIIllllIIllllIlIIlII < lllllllllllllIIllllIIllllIlIIlll.size()) {
                lllllllllllllIIllllIIllllIlIlIII = lllllllllllllIIllllIIllllIlIIlll;
                break;
            }
            lllllllllllllIIllllIIllllIlIIlII -= lllllllllllllIIllllIIllllIlIIlll.size();
        }
        if (lllllllllllllIIllllIIllllIlIlIII != null && !lllllllllllllIIllllIIllllIlIlIII.get(lllllllllllllIIllllIIllllIlIIlII).func_190926_b()) {
            final ItemStack lllllllllllllIIllllIIllllIlIIllI = lllllllllllllIIllllIIllllIlIlIII.get(lllllllllllllIIllllIIllllIlIIlII);
            lllllllllllllIIllllIIllllIlIlIII.set(lllllllllllllIIllllIIllllIlIIlII, ItemStack.field_190927_a);
            return lllllllllllllIIllllIIllllIlIIllI;
        }
        return ItemStack.field_190927_a;
    }
    
    @Override
    public void setField(final int lllllllllllllIIllllIIllIlllIIIIl, final int lllllllllllllIIllllIIllIlllIIIII) {
    }
    
    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName(), new Object[0]);
    }
    
    public void damageArmor(float lllllllllllllIIllllIIlllIIlIlIll) {
        lllllllllllllIIllllIIlllIIlIlIll /= 4.0f;
        if (lllllllllllllIIllllIIlllIIlIlIll < 1.0f) {
            lllllllllllllIIllllIIlllIIlIlIll = 1.0f;
        }
        for (int lllllllllllllIIllllIIlllIIlIlllI = 0; lllllllllllllIIllllIIlllIIlIlllI < this.armorInventory.size(); ++lllllllllllllIIllllIIlllIIlIlllI) {
            final ItemStack lllllllllllllIIllllIIlllIIlIllIl = this.armorInventory.get(lllllllllllllIIllllIIlllIIlIlllI);
            if (lllllllllllllIIllllIIlllIIlIllIl.getItem() instanceof ItemArmor) {
                lllllllllllllIIllllIIlllIIlIllIl.damageItem((int)lllllllllllllIIllllIIlllIIlIlIll, this.player);
            }
        }
    }
    
    public ItemStack getCurrentItem() {
        return isHotbar(this.currentItem) ? this.mainInventory.get(this.currentItem) : ItemStack.field_190927_a;
    }
    
    public void func_191975_a(final World lllllllllllllIIllllIIlllllIlIIlI, final ItemStack lllllllllllllIIllllIIlllllIlIllI) {
        if (!lllllllllllllIIllllIIlllllIlIIlI.isRemote) {
            while (!lllllllllllllIIllllIIlllllIlIllI.func_190926_b()) {
                int lllllllllllllIIllllIIlllllIlIlIl = this.storeItemStack(lllllllllllllIIllllIIlllllIlIllI);
                if (lllllllllllllIIllllIIlllllIlIlIl == -1) {
                    lllllllllllllIIllllIIlllllIlIlIl = this.getFirstEmptyStack();
                }
                if (lllllllllllllIIllllIIlllllIlIlIl == -1) {
                    this.player.dropItem(lllllllllllllIIllllIIlllllIlIllI, false);
                    break;
                }
                final int lllllllllllllIIllllIIlllllIlIlII = lllllllllllllIIllllIIlllllIlIllI.getMaxStackSize() - this.getStackInSlot(lllllllllllllIIllllIIlllllIlIlIl).func_190916_E();
                if (!this.func_191971_c(lllllllllllllIIllllIIlllllIlIlIl, lllllllllllllIIllllIIlllllIlIllI.splitStack(lllllllllllllIIllllIIlllllIlIlII))) {
                    continue;
                }
                ((EntityPlayerMP)this.player).connection.sendPacket(new SPacketSetSlot(-2, lllllllllllllIIllllIIlllllIlIlIl, this.getStackInSlot(lllllllllllllIIllllIIlllllIlIlIl)));
            }
        }
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIIllllIIllIlllIllll, final ItemStack lllllllllllllIIllllIIllIlllIlllI) {
        return true;
    }
    
    public void func_194016_a(final RecipeItemHelper lllllllllllllIIllllIIllIllIlIIII, final boolean lllllllllllllIIllllIIllIllIIllll) {
        for (final ItemStack lllllllllllllIIllllIIllIllIIlllI : this.mainInventory) {
            lllllllllllllIIllllIIllIllIlIIII.func_194112_a(lllllllllllllIIllllIIllIllIIlllI);
        }
        if (lllllllllllllIIllllIIllIllIIllll) {
            lllllllllllllIIllllIIllIllIlIIII.func_194112_a(this.offHandInventory.get(0));
        }
    }
    
    public int getBestHotbarSlot() {
        for (int lllllllllllllIIllllIlIIIIlIlIIIl = 0; lllllllllllllIIllllIlIIIIlIlIIIl < 9; ++lllllllllllllIIllllIlIIIIlIlIIIl) {
            final int lllllllllllllIIllllIlIIIIlIlIIII = (this.currentItem + lllllllllllllIIllllIlIIIIlIlIIIl) % 9;
            if (this.mainInventory.get(lllllllllllllIIllllIlIIIIlIlIIII).func_190926_b()) {
                return lllllllllllllIIllllIlIIIIlIlIIII;
            }
        }
        for (int lllllllllllllIIllllIlIIIIlIIllll = 0; lllllllllllllIIllllIlIIIIlIIllll < 9; ++lllllllllllllIIllllIlIIIIlIIllll) {
            final int lllllllllllllIIllllIlIIIIlIIlllI = (this.currentItem + lllllllllllllIIllllIlIIIIlIIllll) % 9;
            if (!this.mainInventory.get(lllllllllllllIIllllIlIIIIlIIlllI).isItemEnchanted()) {
                return lllllllllllllIIllllIlIIIIlIIlllI;
            }
        }
        return this.currentItem;
    }
    
    private int func_191973_d(final int lllllllllllllIIllllIlIIIIIIlIlll, final ItemStack lllllllllllllIIllllIlIIIIIIIllll) {
        final Item lllllllllllllIIllllIlIIIIIIlIlIl = lllllllllllllIIllllIlIIIIIIIllll.getItem();
        int lllllllllllllIIllllIlIIIIIIlIlII = lllllllllllllIIllllIlIIIIIIIllll.func_190916_E();
        ItemStack lllllllllllllIIllllIlIIIIIIlIIll = this.getStackInSlot(lllllllllllllIIllllIlIIIIIIlIlll);
        if (lllllllllllllIIllllIlIIIIIIlIIll.func_190926_b()) {
            lllllllllllllIIllllIlIIIIIIlIIll = new ItemStack(lllllllllllllIIllllIlIIIIIIlIlIl, 0, lllllllllllllIIllllIlIIIIIIIllll.getMetadata());
            if (lllllllllllllIIllllIlIIIIIIIllll.hasTagCompound()) {
                lllllllllllllIIllllIlIIIIIIlIIll.setTagCompound(lllllllllllllIIllllIlIIIIIIIllll.getTagCompound().copy());
            }
            this.setInventorySlotContents(lllllllllllllIIllllIlIIIIIIlIlll, lllllllllllllIIllllIlIIIIIIlIIll);
        }
        int lllllllllllllIIllllIlIIIIIIlIIlI;
        if ((lllllllllllllIIllllIlIIIIIIlIIlI = lllllllllllllIIllllIlIIIIIIlIlII) > lllllllllllllIIllllIlIIIIIIlIIll.getMaxStackSize() - lllllllllllllIIllllIlIIIIIIlIIll.func_190916_E()) {
            lllllllllllllIIllllIlIIIIIIlIIlI = lllllllllllllIIllllIlIIIIIIlIIll.getMaxStackSize() - lllllllllllllIIllllIlIIIIIIlIIll.func_190916_E();
        }
        if (lllllllllllllIIllllIlIIIIIIlIIlI > this.getInventoryStackLimit() - lllllllllllllIIllllIlIIIIIIlIIll.func_190916_E()) {
            lllllllllllllIIllllIlIIIIIIlIIlI = this.getInventoryStackLimit() - lllllllllllllIIllllIlIIIIIIlIIll.func_190916_E();
        }
        if (lllllllllllllIIllllIlIIIIIIlIIlI == 0) {
            return lllllllllllllIIllllIlIIIIIIlIlII;
        }
        lllllllllllllIIllllIlIIIIIIlIlII -= lllllllllllllIIllllIlIIIIIIlIIlI;
        lllllllllllllIIllllIlIIIIIIlIIll.func_190917_f(lllllllllllllIIllllIlIIIIIIlIIlI);
        lllllllllllllIIllllIlIIIIIIlIIll.func_190915_d(5);
        return lllllllllllllIIllllIlIIIIIIlIlII;
    }
    
    public int storeItemStack(final ItemStack lllllllllllllIIllllIlIIIIIIIIllI) {
        if (this.canMergeStacks(this.getStackInSlot(this.currentItem), lllllllllllllIIllllIlIIIIIIIIllI)) {
            return this.currentItem;
        }
        if (this.canMergeStacks(this.getStackInSlot(40), lllllllllllllIIllllIlIIIIIIIIllI)) {
            return 40;
        }
        for (int lllllllllllllIIllllIlIIIIIIIIlIl = 0; lllllllllllllIIllllIlIIIIIIIIlIl < this.mainInventory.size(); ++lllllllllllllIIllllIlIIIIIIIIlIl) {
            if (this.canMergeStacks(this.mainInventory.get(lllllllllllllIIllllIlIIIIIIIIlIl), lllllllllllllIIllllIlIIIIIIIIllI)) {
                return lllllllllllllIIllllIlIIIIIIIIlIl;
            }
        }
        return -1;
    }
    
    public void copyInventory(final InventoryPlayer lllllllllllllIIllllIIllIlllIIllI) {
        for (int lllllllllllllIIllllIIllIlllIlIII = 0; lllllllllllllIIllllIIllIlllIlIII < this.getSizeInventory(); ++lllllllllllllIIllllIIllIlllIlIII) {
            this.setInventorySlotContents(lllllllllllllIIllllIIllIlllIlIII, lllllllllllllIIllllIIllIlllIIllI.getStackInSlot(lllllllllllllIIllllIIllIlllIlIII));
        }
        this.currentItem = lllllllllllllIIllllIIllIlllIIllI.currentItem;
    }
    
    public int func_194015_p() {
        return this.field_194017_h;
    }
    
    public void setPickedItemStack(final ItemStack lllllllllllllIIllllIlIIIIllllIIl) {
        final int lllllllllllllIIllllIlIIIIlllllII = this.getSlotFor(lllllllllllllIIllllIlIIIIllllIIl);
        if (isHotbar(lllllllllllllIIllllIlIIIIlllllII)) {
            this.currentItem = lllllllllllllIIllllIlIIIIlllllII;
        }
        else if (lllllllllllllIIllllIlIIIIlllllII == -1) {
            this.currentItem = this.getBestHotbarSlot();
            if (!this.mainInventory.get(this.currentItem).func_190926_b()) {
                final int lllllllllllllIIllllIlIIIIllllIll = this.getFirstEmptyStack();
                if (lllllllllllllIIllllIlIIIIllllIll != -1) {
                    this.mainInventory.set(lllllllllllllIIllllIlIIIIllllIll, this.mainInventory.get(this.currentItem));
                }
            }
            this.mainInventory.set(this.currentItem, lllllllllllllIIllllIlIIIIllllIIl);
        }
        else {
            this.pickItem(lllllllllllllIIllllIlIIIIlllllII);
        }
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIIllllIIllIllllIIIl) {
    }
    
    public ItemStack getItemStack() {
        return this.itemStack;
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIIllllIIlllIIIIIllI) {
        return !this.player.isDead && lllllllllllllIIllllIIlllIIIIIllI.getDistanceSqToEntity(this.player) <= 64.0;
    }
    
    public int getFirstEmptyStack() {
        for (int lllllllllllllIIllllIlIIIlIIIIlIl = 0; lllllllllllllIIllllIlIIIlIIIIlIl < this.mainInventory.size(); ++lllllllllllllIIllllIlIIIlIIIIlIl) {
            if (this.mainInventory.get(lllllllllllllIIllllIlIIIlIIIIlIl).func_190926_b()) {
                return lllllllllllllIIllllIlIIIlIIIIlIl;
            }
        }
        return -1;
    }
    
    @Override
    public int getField(final int lllllllllllllIIllllIIllIlllIIIll) {
        return 0;
    }
    
    public void changeCurrentItem(int lllllllllllllIIllllIlIIIIlIIIlIl) {
        if (lllllllllllllIIllllIlIIIIlIIIlIl > 0) {
            lllllllllllllIIllllIlIIIIlIIIlIl = 1;
        }
        if (lllllllllllllIIllllIlIIIIlIIIlIl < 0) {
            lllllllllllllIIllllIlIIIIlIIIlIl = -1;
        }
        this.currentItem -= lllllllllllllIIllllIlIIIIlIIIlIl;
        while (this.currentItem < 0) {
            this.currentItem += 9;
        }
        while (this.currentItem >= 9) {
            this.currentItem -= 9;
        }
    }
    
    public static boolean isHotbar(final int lllllllllllllIIllllIlIIIIllIlIll) {
        return lllllllllllllIIllllIlIIIIllIlIll >= 0 && lllllllllllllIIllllIlIIIIllIlIll < 9;
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIIllllIIllIllllIIll) {
    }
    
    @Override
    public void clear() {
        for (final List<ItemStack> lllllllllllllIIllllIIllIllIllIlI : this.allInventories) {
            lllllllllllllIIllllIIllIllIllIlI.clear();
        }
    }
    
    public int func_194014_c(final ItemStack lllllllllllllIIllllIlIIIIlIllIII) {
        for (int lllllllllllllIIllllIlIIIIlIllIll = 0; lllllllllllllIIllllIlIIIIlIllIll < this.mainInventory.size(); ++lllllllllllllIIllllIlIIIIlIllIll) {
            final ItemStack lllllllllllllIIllllIlIIIIlIllIlI = this.mainInventory.get(lllllllllllllIIllllIlIIIIlIllIll);
            if (!this.mainInventory.get(lllllllllllllIIllllIlIIIIlIllIll).func_190926_b() && this.stackEqualExact(lllllllllllllIIllllIlIIIIlIllIII, this.mainInventory.get(lllllllllllllIIllllIlIIIIlIllIll)) && !this.mainInventory.get(lllllllllllllIIllllIlIIIIlIllIll).isItemDamaged() && !lllllllllllllIIllllIlIIIIlIllIlI.isItemEnchanted() && !lllllllllllllIIllllIlIIIIlIllIlI.hasDisplayName()) {
                return lllllllllllllIIllllIlIIIIlIllIll;
            }
        }
        return -1;
    }
    
    @Override
    public void setInventorySlotContents(int lllllllllllllIIllllIIllllIIlIlII, final ItemStack lllllllllllllIIllllIIllllIIllIII) {
        NonNullList<ItemStack> lllllllllllllIIllllIIllllIIlIlll = null;
        for (final NonNullList<ItemStack> lllllllllllllIIllllIIllllIIlIllI : this.allInventories) {
            if (lllllllllllllIIllllIIllllIIlIlII < lllllllllllllIIllllIIllllIIlIllI.size()) {
                lllllllllllllIIllllIIllllIIlIlll = lllllllllllllIIllllIIllllIIlIllI;
                break;
            }
            lllllllllllllIIllllIIllllIIlIlII -= lllllllllllllIIllllIIllllIIlIllI.size();
        }
        if (lllllllllllllIIllllIIllllIIlIlll != null) {
            lllllllllllllIIllllIIllllIIlIlll.set(lllllllllllllIIllllIIllllIIlIlII, lllllllllllllIIllllIIllllIIllIII);
        }
    }
    
    @Override
    public String getName() {
        return "container.inventory";
    }
    
    public InventoryPlayer(final EntityPlayer lllllllllllllIIllllIlIIIlIIllllI) {
        this.mainInventory = NonNullList.func_191197_a(36, ItemStack.field_190927_a);
        this.armorInventory = NonNullList.func_191197_a(4, ItemStack.field_190927_a);
        this.offHandInventory = NonNullList.func_191197_a(1, ItemStack.field_190927_a);
        this.allInventories = Arrays.asList(this.mainInventory, this.armorInventory, this.offHandInventory);
        this.itemStack = ItemStack.field_190927_a;
        this.player = lllllllllllllIIllllIlIIIlIIllllI;
    }
    
    @Override
    public boolean hasCustomName() {
        return false;
    }
    
    public boolean hasItemStack(final ItemStack lllllllllllllIIllllIIllIlllllIIl) {
        for (final List<ItemStack> lllllllllllllIIllllIIllIllllllIl : this.allInventories) {
            for (final ItemStack lllllllllllllIIllllIIllIlllllIll : lllllllllllllIIllllIIllIllllllIl) {
                if (!lllllllllllllIIllllIIllIlllllIll.func_190926_b() && lllllllllllllIIllllIIllIlllllIll.isItemEqual(lllllllllllllIIllllIIllIlllllIIl)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void setItemStack(final ItemStack lllllllllllllIIllllIIlllIIIIllll) {
        this.itemStack = lllllllllllllIIllllIIlllIIIIllll;
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllIIllllIIlllIlIlllIl : this.mainInventory) {
            if (!lllllllllllllIIllllIIlllIlIlllIl.func_190926_b()) {
                return false;
            }
        }
        for (final ItemStack lllllllllllllIIllllIIlllIlIlllII : this.armorInventory) {
            if (!lllllllllllllIIllllIIlllIlIlllII.func_190926_b()) {
                return false;
            }
        }
        for (final ItemStack lllllllllllllIIllllIIlllIlIllIll : this.offHandInventory) {
            if (!lllllllllllllIIllllIIlllIlIllIll.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public void decrementAnimations() {
        for (final NonNullList<ItemStack> lllllllllllllIIllllIIlllllllllII : this.allInventories) {
            for (int lllllllllllllIIllllIIllllllllIll = 0; lllllllllllllIIllllIIllllllllIll < lllllllllllllIIllllIIlllllllllII.size(); ++lllllllllllllIIllllIIllllllllIll) {
                if (!lllllllllllllIIllllIIlllllllllII.get(lllllllllllllIIllllIIllllllllIll).func_190926_b()) {
                    lllllllllllllIIllllIIlllllllllII.get(lllllllllllllIIllllIIllllllllIll).updateAnimation(this.player.world, this.player, lllllllllllllIIllllIIllllllllIll, this.currentItem == lllllllllllllIIllllIIllllllllIll);
                }
            }
        }
    }
    
    public boolean canHarvestBlock(final IBlockState lllllllllllllIIllllIIlllIIllllII) {
        if (lllllllllllllIIllllIIlllIIllllII.getMaterial().isToolNotRequired()) {
            return true;
        }
        final ItemStack lllllllllllllIIllllIIlllIIlllllI = this.getStackInSlot(this.currentItem);
        return !lllllllllllllIIllllIIlllIIlllllI.func_190926_b() && lllllllllllllIIllllIIlllIIlllllI.canHarvestBlock(lllllllllllllIIllllIIlllIIllllII);
    }
    
    public static int getHotbarSize() {
        return 9;
    }
}
