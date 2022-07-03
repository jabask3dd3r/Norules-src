package net.minecraft.tileentity;

import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.nbt.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.inventory.*;
import net.minecraft.world.storage.loot.*;

public abstract class TileEntityLockableLoot extends TileEntityLockable implements ILootContainer
{
    protected /* synthetic */ ResourceLocation lootTable;
    protected /* synthetic */ String field_190577_o;
    protected /* synthetic */ long lootTableSeed;
    
    @Override
    public ResourceLocation getLootTable() {
        return this.lootTable;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIlllIlllIlIlIllIIII, final ItemStack lllllllllllllIlllIlllIlIlIlIllll) {
        return true;
    }
    
    @Override
    public int getField(final int lllllllllllllIlllIlllIlIlIlIllIl) {
        return 0;
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIlllIlllIlIllIIllIl, final int lllllllllllllIlllIlllIlIllIlIIII) {
        this.fillWithLoot(null);
        final ItemStack lllllllllllllIlllIlllIlIllIIllll = ItemStackHelper.getAndSplit(this.func_190576_q(), lllllllllllllIlllIlllIlIllIIllIl, lllllllllllllIlllIlllIlIllIlIIII);
        if (!lllllllllllllIlllIlllIlIllIIllll.func_190926_b()) {
            this.markDirty();
        }
        return lllllllllllllIlllIlllIlIllIIllll;
    }
    
    protected abstract NonNullList<ItemStack> func_190576_q();
    
    protected boolean checkLootAndRead(final NBTTagCompound lllllllllllllIlllIlllIllIIIIlIII) {
        if (lllllllllllllIlllIlllIllIIIIlIII.hasKey("LootTable", 8)) {
            this.lootTable = new ResourceLocation(lllllllllllllIlllIlllIllIIIIlIII.getString("LootTable"));
            this.lootTableSeed = lllllllllllllIlllIlllIllIIIIlIII.getLong("LootTableSeed");
            return true;
        }
        return false;
    }
    
    public void setLootTable(final ResourceLocation lllllllllllllIlllIlllIlIlllIIlll, final long lllllllllllllIlllIlllIlIlllIlIIl) {
        this.lootTable = lllllllllllllIlllIlllIlIlllIIlll;
        this.lootTableSeed = lllllllllllllIlllIlllIlIlllIlIIl;
    }
    
    @Override
    public void setField(final int lllllllllllllIlllIlllIlIlIlIlIll, final int lllllllllllllIlllIlllIlIlIlIlIlI) {
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllIlllIlllIlIlIllllIl, @Nullable final ItemStack lllllllllllllIlllIlllIlIlIllllII) {
        this.fillWithLoot(null);
        this.func_190576_q().set(lllllllllllllIlllIlllIlIlIllllIl, lllllllllllllIlllIlllIlIlIllllII);
        if (lllllllllllllIlllIlllIlIlIllllII.func_190916_E() > this.getInventoryStackLimit()) {
            lllllllllllllIlllIlllIlIlIllllII.func_190920_e(this.getInventoryStackLimit());
        }
        this.markDirty();
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllllIlllIlllIlIllIIIlIl) {
        this.fillWithLoot(null);
        return ItemStackHelper.getAndRemove(this.func_190576_q(), lllllllllllllIlllIlllIlIllIIIlIl);
    }
    
    @Override
    public void clear() {
        this.fillWithLoot(null);
        this.func_190576_q().clear();
    }
    
    public void fillWithLoot(@Nullable final EntityPlayer lllllllllllllIlllIlllIlIlllllIll) {
        if (this.lootTable != null) {
            final LootTable lllllllllllllIlllIlllIlIlllllIlI = this.world.getLootTableManager().getLootTableFromLocation(this.lootTable);
            this.lootTable = null;
            Random lllllllllllllIlllIlllIlIlllllIII = null;
            if (this.lootTableSeed == 0L) {
                final Random lllllllllllllIlllIlllIlIlllllIIl = new Random();
            }
            else {
                lllllllllllllIlllIlllIlIlllllIII = new Random(this.lootTableSeed);
            }
            final LootContext.Builder lllllllllllllIlllIlllIlIllllIlll = new LootContext.Builder((WorldServer)this.world);
            if (lllllllllllllIlllIlllIlIlllllIll != null) {
                lllllllllllllIlllIlllIlIllllIlll.withLuck(lllllllllllllIlllIlllIlIlllllIll.getLuck());
            }
            lllllllllllllIlllIlllIlIlllllIlI.fillInventory(this, lllllllllllllIlllIlllIlIlllllIII, lllllllllllllIlllIlllIlIllllIlll.build());
        }
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllIlllIlllIlIllIllIIl) {
        this.fillWithLoot(null);
        return this.func_190576_q().get(lllllllllllllIlllIlllIlIllIllIIl);
    }
    
    public void func_190575_a(final String lllllllllllllIlllIlllIlIllIlllll) {
        this.field_190577_o = lllllllllllllIlllIlllIlIllIlllll;
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIlllIlllIlIlIllIlII) {
    }
    
    protected boolean checkLootAndWrite(final NBTTagCompound lllllllllllllIlllIlllIllIIIIIlII) {
        if (this.lootTable != null) {
            lllllllllllllIlllIlllIllIIIIIlII.setString("LootTable", this.lootTable.toString());
            if (this.lootTableSeed != 0L) {
                lllllllllllllIlllIlllIllIIIIIlII.setLong("LootTableSeed", this.lootTableSeed);
            }
            return true;
        }
        return false;
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIlllIlllIlIlIllIIlI) {
    }
    
    @Override
    public boolean hasCustomName() {
        return this.field_190577_o != null && !this.field_190577_o.isEmpty();
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIlllIlllIlIlIlllIII) {
        return this.world.getTileEntity(this.pos) == this && lllllllllllllIlllIlllIlIlIlllIII.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
}
