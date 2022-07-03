package net.minecraft.entity.item;

import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.world.storage.loot.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;

public abstract class EntityMinecartContainer extends EntityMinecart implements ILockableContainer, ILootContainer
{
    private /* synthetic */ NonNullList<ItemStack> minecartContainerItems;
    private /* synthetic */ long lootTableSeed;
    private /* synthetic */ boolean dropContentsWhenDead;
    private /* synthetic */ ResourceLocation lootTable;
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound llIIIlIllII) {
        super.readEntityFromNBT(llIIIlIllII);
        this.minecartContainerItems = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (llIIIlIllII.hasKey("LootTable", 8)) {
            this.lootTable = new ResourceLocation(llIIIlIllII.getString("LootTable"));
            this.lootTableSeed = llIIIlIllII.getLong("LootTableSeed");
        }
        else {
            ItemStackHelper.func_191283_b(llIIIlIllII, this.minecartContainerItems);
        }
    }
    
    public void addLoot(@Nullable final EntityPlayer llIIIIIlIIl) {
        if (this.lootTable != null) {
            final LootTable llIIIIIlIII = this.world.getLootTableManager().getLootTableFromLocation(this.lootTable);
            this.lootTable = null;
            Random llIIIIIIllI = null;
            if (this.lootTableSeed == 0L) {
                final Random llIIIIIIlll = new Random();
            }
            else {
                llIIIIIIllI = new Random(this.lootTableSeed);
            }
            final LootContext.Builder llIIIIIIlIl = new LootContext.Builder((WorldServer)this.world);
            if (llIIIIIlIIl != null) {
                llIIIIIIlIl.withLuck(llIIIIIlIIl.getLuck());
            }
            llIIIIIlIII.fillInventory(this, llIIIIIIllI, llIIIIIIlIl.build());
        }
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer llIIlIlIIll) {
        return !this.isDead && llIIlIlIIll.getDistanceSqToEntity(this) <= 64.0;
    }
    
    public EntityMinecartContainer(final World llIlIIIllII, final double llIlIIlIIII, final double llIlIIIllll, final double llIlIIIlllI) {
        super(llIlIIIllII, llIlIIlIIII, llIlIIIllll, llIlIIIlllI);
        this.minecartContainerItems = NonNullList.func_191197_a(36, ItemStack.field_190927_a);
        this.dropContentsWhenDead = true;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public void clear() {
        this.addLoot(null);
        this.minecartContainerItems.clear();
    }
    
    @Nullable
    @Override
    public Entity changeDimension(final int llIIlIIIlll) {
        this.dropContentsWhenDead = false;
        return super.changeDimension(llIIlIIIlll);
    }
    
    @Override
    public int getFieldCount() {
        return 0;
    }
    
    @Override
    public LockCode getLockCode() {
        return LockCode.EMPTY_CODE;
    }
    
    @Override
    public ItemStack getStackInSlot(final int llIIlllIlll) {
        this.addLoot(null);
        return this.minecartContainerItems.get(llIIlllIlll);
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound llIIIllIIII) {
        super.writeEntityToNBT(llIIIllIIII);
        if (this.lootTable != null) {
            llIIIllIIII.setString("LootTable", this.lootTable.toString());
            if (this.lootTableSeed != 0L) {
                llIIIllIIII.setLong("LootTableSeed", this.lootTableSeed);
            }
        }
        else {
            ItemStackHelper.func_191282_a(llIIIllIIII, this.minecartContainerItems);
        }
    }
    
    @Override
    public boolean processInitialInteract(final EntityPlayer llIIIlIIIll, final EnumHand llIIIlIIlIl) {
        if (!this.world.isRemote) {
            llIIIlIIIll.displayGUIChest(this);
        }
        return true;
    }
    
    @Override
    public void openInventory(final EntityPlayer llIIlIlIIIl) {
    }
    
    @Override
    public void setDead() {
        if (this.dropContentsWhenDead) {
            InventoryHelper.dropInventoryItems(this.world, this, this);
        }
        super.setDead();
    }
    
    @Override
    public void setLockCode(final LockCode llIIIIlIIIl) {
    }
    
    @Override
    public boolean isItemValidForSlot(final int llIIlIIllIl, final ItemStack llIIlIIllII) {
        return true;
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack llIIllllllI : this.minecartContainerItems) {
            if (!llIIllllllI.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    public EntityMinecartContainer(final World llIlIIllIII) {
        super(llIlIIllIII);
        this.minecartContainerItems = NonNullList.func_191197_a(36, ItemStack.field_190927_a);
        this.dropContentsWhenDead = true;
    }
    
    @Override
    public boolean isLocked() {
        return false;
    }
    
    @Override
    public void markDirty() {
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int llIIllIIlll) {
        this.addLoot(null);
        final ItemStack llIIllIIllI = this.minecartContainerItems.get(llIIllIIlll);
        if (llIIllIIllI.func_190926_b()) {
            return ItemStack.field_190927_a;
        }
        this.minecartContainerItems.set(llIIllIIlll, ItemStack.field_190927_a);
        return llIIllIIllI;
    }
    
    @Override
    public ResourceLocation getLootTable() {
        return this.lootTable;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llIIlIIllll) {
    }
    
    @Override
    public int getField(final int llIIIIllIII) {
        return 0;
    }
    
    @Override
    public void setInventorySlotContents(final int llIIlIllIll, final ItemStack llIIlIllIlI) {
        this.addLoot(null);
        this.minecartContainerItems.set(llIIlIllIll, llIIlIllIlI);
        if (!llIIlIllIlI.func_190926_b() && llIIlIllIlI.func_190916_E() > this.getInventoryStackLimit()) {
            llIIlIllIlI.func_190920_e(this.getInventoryStackLimit());
        }
    }
    
    @Override
    public void setDropItemsWhenDead(final boolean llIIIllllII) {
        this.dropContentsWhenDead = llIIIllllII;
    }
    
    public static void func_190574_b(final DataFixer llIIIllIlll, final Class<?> llIIIlllIII) {
        EntityMinecart.registerFixesMinecart(llIIIllIlll, llIIIlllIII);
        llIIIllIlll.registerWalker(FixTypes.ENTITY, new ItemStackDataLists(llIIIlllIII, new String[] { "Items" }));
    }
    
    @Override
    public ItemStack decrStackSize(final int llIIlllIIII, final int llIIllIllII) {
        this.addLoot(null);
        return ItemStackHelper.getAndSplit(this.minecartContainerItems, llIIlllIIII, llIIllIllII);
    }
    
    @Override
    public void killMinecart(final DamageSource llIlIIIIIll) {
        super.killMinecart(llIlIIIIIll);
        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
            InventoryHelper.dropInventoryItems(this.world, this, this);
        }
    }
    
    public void setLootTable(final ResourceLocation lIlllllIlIl, final long lIlllllIlII) {
        this.lootTable = lIlllllIlIl;
        this.lootTableSeed = lIlllllIlII;
    }
    
    @Override
    public void setField(final int llIIIIlIllI, final int llIIIIlIlIl) {
    }
    
    @Override
    protected void applyDrag() {
        float llIIIIllllI = 0.98f;
        if (this.lootTable == null) {
            final int llIIIIlllIl = 15 - Container.calcRedstoneFromInventory(this);
            llIIIIllllI += llIIIIlllIl * 0.001f;
        }
        this.motionX *= llIIIIllllI;
        this.motionY *= 0.0;
        this.motionZ *= llIIIIllllI;
    }
}
