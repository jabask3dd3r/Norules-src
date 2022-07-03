package net.minecraft.tileentity;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;

public class TileEntityDispenser extends TileEntityLockableLoot
{
    private static final /* synthetic */ Random RNG;
    private /* synthetic */ NonNullList<ItemStack> stacks;
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.dispenser";
    }
    
    public TileEntityDispenser() {
        this.stacks = NonNullList.func_191197_a(9, ItemStack.field_190927_a);
    }
    
    static {
        RNG = new Random();
    }
    
    public int getDispenseSlot() {
        this.fillWithLoot(null);
        int lllllllllllllIIllllIllllIlIlIIlI = -1;
        int lllllllllllllIIllllIllllIlIlIIIl = 1;
        for (int lllllllllllllIIllllIllllIlIlIIII = 0; lllllllllllllIIllllIllllIlIlIIII < this.stacks.size(); ++lllllllllllllIIllllIllllIlIlIIII) {
            if (!this.stacks.get(lllllllllllllIIllllIllllIlIlIIII).func_190926_b() && TileEntityDispenser.RNG.nextInt(lllllllllllllIIllllIllllIlIlIIIl++) == 0) {
                lllllllllllllIIllllIllllIlIlIIlI = lllllllllllllIIllllIllllIlIlIIII;
            }
        }
        return lllllllllllllIIllllIllllIlIlIIlI;
    }
    
    @Override
    public int getSizeInventory() {
        return 9;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllIIllllIllllIIlIlIlI, final EntityPlayer lllllllllllllIIllllIllllIIlIlIIl) {
        this.fillWithLoot(lllllllllllllIIllllIllllIIlIlIIl);
        return new ContainerDispenser(lllllllllllllIIllllIllllIIlIlIlI, this);
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIIllllIllllIIllIIll) {
        super.writeToNBT(lllllllllllllIIllllIllllIIllIIll);
        if (!this.checkLootAndWrite(lllllllllllllIIllllIllllIIllIIll)) {
            ItemStackHelper.func_191282_a(lllllllllllllIIllllIllllIIllIIll, this.stacks);
        }
        if (this.hasCustomName()) {
            lllllllllllllIIllllIllllIIllIIll.setString("CustomName", this.field_190577_o);
        }
        return lllllllllllllIIllllIllllIIllIIll;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIIllllIllllIIllIlll) {
        super.readFromNBT(lllllllllllllIIllllIllllIIllIlll);
        this.stacks = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (!this.checkLootAndRead(lllllllllllllIIllllIllllIIllIlll)) {
            ItemStackHelper.func_191283_b(lllllllllllllIIllllIllllIIllIlll, this.stacks);
        }
        if (lllllllllllllIIllllIllllIIllIlll.hasKey("CustomName", 8)) {
            this.field_190577_o = lllllllllllllIIllllIllllIIllIlll.getString("CustomName");
        }
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllIIllllIllllIlIllIll : this.stacks) {
            if (!lllllllllllllIIllllIllllIlIllIll.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public int addItemStack(final ItemStack lllllllllllllIIllllIllllIlIIIlll) {
        for (int lllllllllllllIIllllIllllIlIIIllI = 0; lllllllllllllIIllllIllllIlIIIllI < this.stacks.size(); ++lllllllllllllIIllllIllllIlIIIllI) {
            if (this.stacks.get(lllllllllllllIIllllIllllIlIIIllI).func_190926_b()) {
                this.setInventorySlotContents(lllllllllllllIIllllIllllIlIIIllI, lllllllllllllIIllllIllllIlIIIlll);
                return lllllllllllllIIllllIllllIlIIIllI;
            }
        }
        return -1;
    }
    
    @Override
    protected NonNullList<ItemStack> func_190576_q() {
        return this.stacks;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:dispenser";
    }
    
    public static void registerFixes(final DataFixer lllllllllllllIIllllIllllIIllllIl) {
        lllllllllllllIIllllIllllIIllllIl.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityDispenser.class, new String[] { "Items" }));
    }
}
