package net.minecraft.tileentity;

import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.player.*;
import net.minecraft.potion.*;
import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import net.minecraft.inventory.*;
import java.util.*;

public class TileEntityBrewingStand extends TileEntityLockable implements ITickable, ISidedInventory
{
    private static final /* synthetic */ int[] OUTPUT_SLOTS;
    private /* synthetic */ int fuel;
    private static final /* synthetic */ int[] SLOTS_FOR_UP;
    private static final /* synthetic */ int[] SLOTS_FOR_DOWN;
    private /* synthetic */ Item ingredientID;
    private /* synthetic */ NonNullList<ItemStack> brewingItemStacks;
    private /* synthetic */ String customName;
    private /* synthetic */ int brewTime;
    private /* synthetic */ boolean[] filledSlots;
    
    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:brewing_stand";
    }
    
    @Override
    public ItemStack getStackInSlot(final int lllllllllllllIIlllllIIIIIIIIlIll) {
        return (lllllllllllllIIlllllIIIIIIIIlIll >= 0 && lllllllllllllIIlllllIIIIIIIIlIll < this.brewingItemStacks.size()) ? this.brewingItemStacks.get(lllllllllllllIIlllllIIIIIIIIlIll) : ItemStack.field_190927_a;
    }
    
    @Override
    public int getFieldCount() {
        return 2;
    }
    
    public void setName(final String lllllllllllllIIlllllIIIIIllIIlII) {
        this.customName = lllllllllllllIIlllllIIIIIllIIlII;
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack lllllllllllllIIlllllIIIIIlIlllII : this.brewingItemStacks) {
            if (!lllllllllllllIIlllllIIIIIlIlllII.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    static {
        SLOTS_FOR_UP = new int[] { 3 };
        SLOTS_FOR_DOWN = new int[] { 0, 1, 2, 3 };
        OUTPUT_SLOTS = new int[] { 0, 1, 2, 4 };
    }
    
    @Override
    public void setField(final int lllllllllllllIIllllIlllllIllIIIl, final int lllllllllllllIIllllIlllllIllIIII) {
        switch (lllllllllllllIIllllIlllllIllIIIl) {
            case 0: {
                this.brewTime = lllllllllllllIIllllIlllllIllIIII;
                break;
            }
            case 1: {
                this.fuel = lllllllllllllIIllllIlllllIllIIII;
                break;
            }
        }
    }
    
    @Override
    public void clear() {
        this.brewingItemStacks.clear();
    }
    
    @Override
    public void update() {
        final ItemStack lllllllllllllIIlllllIIIIIlIIllll = this.brewingItemStacks.get(4);
        if (this.fuel <= 0 && lllllllllllllIIlllllIIIIIlIIllll.getItem() == Items.BLAZE_POWDER) {
            this.fuel = 20;
            lllllllllllllIIlllllIIIIIlIIllll.func_190918_g(1);
            this.markDirty();
        }
        final boolean lllllllllllllIIlllllIIIIIlIIlllI = this.canBrew();
        final boolean lllllllllllllIIlllllIIIIIlIIllIl = this.brewTime > 0;
        final ItemStack lllllllllllllIIlllllIIIIIlIIllII = this.brewingItemStacks.get(3);
        if (lllllllllllllIIlllllIIIIIlIIllIl) {
            --this.brewTime;
            final boolean lllllllllllllIIlllllIIIIIlIIlIll = this.brewTime == 0;
            if (lllllllllllllIIlllllIIIIIlIIlIll && lllllllllllllIIlllllIIIIIlIIlllI) {
                this.brewPotions();
                this.markDirty();
            }
            else if (!lllllllllllllIIlllllIIIIIlIIlllI) {
                this.brewTime = 0;
                this.markDirty();
            }
            else if (this.ingredientID != lllllllllllllIIlllllIIIIIlIIllII.getItem()) {
                this.brewTime = 0;
                this.markDirty();
            }
        }
        else if (lllllllllllllIIlllllIIIIIlIIlllI && this.fuel > 0) {
            --this.fuel;
            this.brewTime = 400;
            this.ingredientID = lllllllllllllIIlllllIIIIIlIIllII.getItem();
            this.markDirty();
        }
        if (!this.world.isRemote) {
            final boolean[] lllllllllllllIIlllllIIIIIlIIlIlI = this.createFilledSlotsArray();
            if (!Arrays.equals(lllllllllllllIIlllllIIIIIlIIlIlI, this.filledSlots)) {
                this.filledSlots = lllllllllllllIIlllllIIIIIlIIlIlI;
                IBlockState lllllllllllllIIlllllIIIIIlIIlIIl = this.world.getBlockState(this.getPos());
                if (!(lllllllllllllIIlllllIIIIIlIIlIIl.getBlock() instanceof BlockBrewingStand)) {
                    return;
                }
                for (int lllllllllllllIIlllllIIIIIlIIlIII = 0; lllllllllllllIIlllllIIIIIlIIlIII < BlockBrewingStand.HAS_BOTTLE.length; ++lllllllllllllIIlllllIIIIIlIIlIII) {
                    lllllllllllllIIlllllIIIIIlIIlIIl = lllllllllllllIIlllllIIIIIlIIlIIl.withProperty((IProperty<Comparable>)BlockBrewingStand.HAS_BOTTLE[lllllllllllllIIlllllIIIIIlIIlIII], lllllllllllllIIlllllIIIIIlIIlIlI[lllllllllllllIIlllllIIIIIlIIlIII]);
                }
                this.world.setBlockState(this.pos, lllllllllllllIIlllllIIIIIlIIlIIl, 2);
            }
        }
    }
    
    @Override
    public int getSizeInventory() {
        return this.brewingItemStacks.size();
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllIIllllIllllllllIlIl, final ItemStack lllllllllllllIIllllIllllllllIIIl) {
        if (lllllllllllllIIllllIllllllllIlIl >= 0 && lllllllllllllIIllllIllllllllIlIl < this.brewingItemStacks.size()) {
            this.brewingItemStacks.set(lllllllllllllIIllllIllllllllIlIl, lllllllllllllIIllllIllllllllIIIl);
        }
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing lllllllllllllIIllllIllllllIlIlll) {
        if (lllllllllllllIIllllIllllllIlIlll == EnumFacing.UP) {
            return TileEntityBrewingStand.SLOTS_FOR_UP;
        }
        return (lllllllllllllIIllllIllllllIlIlll == EnumFacing.DOWN) ? TileEntityBrewingStand.SLOTS_FOR_DOWN : TileEntityBrewingStand.OUTPUT_SLOTS;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public static void registerFixesBrewingStand(final DataFixer lllllllllllllIIlllllIIIIIIIllIll) {
        lllllllllllllIIlllllIIIIIIIllIll.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityBrewingStand.class, new String[] { "Items" }));
    }
    
    @Override
    public void closeInventory(final EntityPlayer lllllllllllllIIllllIlllllllIIllI) {
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllIIllllIlllllIllllll, final EntityPlayer lllllllllllllIIllllIlllllIlllllI) {
        return new ContainerBrewingStand(lllllllllllllIIllllIlllllIllllll, this);
    }
    
    @Override
    public void openInventory(final EntityPlayer lllllllllllllIIllllIlllllllIlIII) {
    }
    
    @Override
    public int getField(final int lllllllllllllIIllllIlllllIllIllI) {
        switch (lllllllllllllIIllllIlllllIllIllI) {
            case 0: {
                return this.brewTime;
            }
            case 1: {
                return this.fuel;
            }
            default: {
                return 0;
            }
        }
    }
    
    public boolean[] createFilledSlotsArray() {
        final boolean[] lllllllllllllIIlllllIIIIIIlllIll = new boolean[3];
        for (int lllllllllllllIIlllllIIIIIIlllIlI = 0; lllllllllllllIIlllllIIIIIIlllIlI < 3; ++lllllllllllllIIlllllIIIIIIlllIlI) {
            if (!this.brewingItemStacks.get(lllllllllllllIIlllllIIIIIIlllIlI).func_190926_b()) {
                lllllllllllllIIlllllIIIIIIlllIll[lllllllllllllIIlllllIIIIIIlllIlI] = true;
            }
        }
        return lllllllllllllIIlllllIIIIIIlllIll;
    }
    
    private void brewPotions() {
        ItemStack lllllllllllllIIlllllIIIIIIlIIlIl = this.brewingItemStacks.get(3);
        for (int lllllllllllllIIlllllIIIIIIlIIlII = 0; lllllllllllllIIlllllIIIIIIlIIlII < 3; ++lllllllllllllIIlllllIIIIIIlIIlII) {
            this.brewingItemStacks.set(lllllllllllllIIlllllIIIIIIlIIlII, PotionHelper.doReaction(lllllllllllllIIlllllIIIIIIlIIlIl, this.brewingItemStacks.get(lllllllllllllIIlllllIIIIIIlIIlII)));
        }
        lllllllllllllIIlllllIIIIIIlIIlIl.func_190918_g(1);
        final BlockPos lllllllllllllIIlllllIIIIIIlIIIll = this.getPos();
        if (lllllllllllllIIlllllIIIIIIlIIlIl.getItem().hasContainerItem()) {
            final ItemStack lllllllllllllIIlllllIIIIIIlIIIlI = new ItemStack(lllllllllllllIIlllllIIIIIIlIIlIl.getItem().getContainerItem());
            if (lllllllllllllIIlllllIIIIIIlIIlIl.func_190926_b()) {
                lllllllllllllIIlllllIIIIIIlIIlIl = lllllllllllllIIlllllIIIIIIlIIIlI;
            }
            else {
                InventoryHelper.spawnItemStack(this.world, lllllllllllllIIlllllIIIIIIlIIIll.getX(), lllllllllllllIIlllllIIIIIIlIIIll.getY(), lllllllllllllIIlllllIIIIIIlIIIll.getZ(), lllllllllllllIIlllllIIIIIIlIIIlI);
            }
        }
        this.brewingItemStacks.set(3, lllllllllllllIIlllllIIIIIIlIIlIl);
        this.world.playEvent(1035, lllllllllllllIIlllllIIIIIIlIIIll, 0);
    }
    
    private boolean canBrew() {
        final ItemStack lllllllllllllIIlllllIIIIIIllIIIl = this.brewingItemStacks.get(3);
        if (lllllllllllllIIlllllIIIIIIllIIIl.func_190926_b()) {
            return false;
        }
        if (!PotionHelper.isReagent(lllllllllllllIIlllllIIIIIIllIIIl)) {
            return false;
        }
        for (int lllllllllllllIIlllllIIIIIIllIIII = 0; lllllllllllllIIlllllIIIIIIllIIII < 3; ++lllllllllllllIIlllllIIIIIIllIIII) {
            final ItemStack lllllllllllllIIlllllIIIIIIlIllll = this.brewingItemStacks.get(lllllllllllllIIlllllIIIIIIllIIII);
            if (!lllllllllllllIIlllllIIIIIIlIllll.func_190926_b() && PotionHelper.hasConversions(lllllllllllllIIlllllIIIIIIlIllll, lllllllllllllIIlllllIIIIIIllIIIl)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.brewing";
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllIIlllllIIIIIIIIllll) {
        super.writeToNBT(lllllllllllllIIlllllIIIIIIIIllll);
        lllllllllllllIIlllllIIIIIIIIllll.setShort("BrewTime", (short)this.brewTime);
        ItemStackHelper.func_191282_a(lllllllllllllIIlllllIIIIIIIIllll, this.brewingItemStacks);
        if (this.hasCustomName()) {
            lllllllllllllIIlllllIIIIIIIIllll.setString("CustomName", this.customName);
        }
        lllllllllllllIIlllllIIIIIIIIllll.setByte("Fuel", (byte)this.fuel);
        return lllllllllllllIIlllllIIIIIIIIllll;
    }
    
    public TileEntityBrewingStand() {
        this.brewingItemStacks = NonNullList.func_191197_a(5, ItemStack.field_190927_a);
    }
    
    @Override
    public boolean canInsertItem(final int lllllllllllllIIllllIllllllIlIIIl, final ItemStack lllllllllllllIIllllIllllllIIllII, final EnumFacing lllllllllllllIIllllIllllllIIllll) {
        return this.isItemValidForSlot(lllllllllllllIIllllIllllllIlIIIl, lllllllllllllIIllllIllllllIIllII);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllIIlllllIIIIIIIlIlll) {
        super.readFromNBT(lllllllllllllIIlllllIIIIIIIlIlll);
        this.brewingItemStacks = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b(lllllllllllllIIlllllIIIIIIIlIlll, this.brewingItemStacks);
        this.brewTime = lllllllllllllIIlllllIIIIIIIlIlll.getShort("BrewTime");
        if (lllllllllllllIIlllllIIIIIIIlIlll.hasKey("CustomName", 8)) {
            this.customName = lllllllllllllIIlllllIIIIIIIlIlll.getString("CustomName");
        }
        this.fuel = lllllllllllllIIlllllIIIIIIIlIlll.getByte("Fuel");
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllIIlllllIIIIIIIIIIIl, final int lllllllllllllIIlllllIIIIIIIIIIll) {
        return ItemStackHelper.getAndSplit(this.brewingItemStacks, lllllllllllllIIlllllIIIIIIIIIIIl, lllllllllllllIIlllllIIIIIIIIIIll);
    }
    
    @Override
    public boolean canExtractItem(final int lllllllllllllIIllllIllllllIIlIII, final ItemStack lllllllllllllIIllllIllllllIIIlII, final EnumFacing lllllllllllllIIllllIllllllIIIllI) {
        return lllllllllllllIIllllIllllllIIlIII != 3 || lllllllllllllIIllllIllllllIIIlII.getItem() == Items.GLASS_BOTTLE;
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int lllllllllllllIIllllIllllllllllII) {
        return ItemStackHelper.getAndRemove(this.brewingItemStacks, lllllllllllllIIllllIllllllllllII);
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer lllllllllllllIIllllIlllllllIlIlI) {
        return this.world.getTileEntity(this.pos) == this && lllllllllllllIIllllIlllllllIlIlI.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public boolean isItemValidForSlot(final int lllllllllllllIIllllIlllllllIIIII, final ItemStack lllllllllllllIIllllIllllllIlllll) {
        if (lllllllllllllIIllllIlllllllIIIII == 3) {
            return PotionHelper.isReagent(lllllllllllllIIllllIllllllIlllll);
        }
        final Item lllllllllllllIIllllIllllllIllllI = lllllllllllllIIllllIllllllIlllll.getItem();
        if (lllllllllllllIIllllIlllllllIIIII == 4) {
            return lllllllllllllIIllllIllllllIllllI == Items.BLAZE_POWDER;
        }
        return (lllllllllllllIIllllIllllllIllllI == Items.POTIONITEM || lllllllllllllIIllllIllllllIllllI == Items.SPLASH_POTION || lllllllllllllIIllllIllllllIllllI == Items.LINGERING_POTION || lllllllllllllIIllllIllllllIllllI == Items.GLASS_BOTTLE) && this.getStackInSlot(lllllllllllllIIllllIlllllllIIIII).func_190926_b();
    }
}
