package net.minecraft.tileentity;

import net.minecraft.nbt.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.item.crafting.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.util.math.*;
import net.minecraft.block.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;

public class TileEntityFurnace extends TileEntityLockable implements ISidedInventory, ITickable
{
    private static final /* synthetic */ int[] SLOTS_BOTTOM;
    private /* synthetic */ int currentItemBurnTime;
    private /* synthetic */ int furnaceBurnTime;
    private static final /* synthetic */ int[] SLOTS_SIDES;
    private /* synthetic */ int totalCookTime;
    private /* synthetic */ String furnaceCustomName;
    private /* synthetic */ int cookTime;
    private static final /* synthetic */ int[] SLOTS_TOP;
    private /* synthetic */ NonNullList<ItemStack> furnaceItemStacks;
    
    @Override
    public String getGuiID() {
        return "minecraft:furnace";
    }
    
    @Override
    public int getFieldCount() {
        return 4;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.furnaceCustomName : "container.furnace";
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllIlllllIlllllIlllllII) {
        super.readFromNBT(llllllllllllIlllllIlllllIlllllII);
        this.furnaceItemStacks = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        ItemStackHelper.func_191283_b(llllllllllllIlllllIlllllIlllllII, this.furnaceItemStacks);
        this.furnaceBurnTime = llllllllllllIlllllIlllllIlllllII.getShort("BurnTime");
        this.cookTime = llllllllllllIlllllIlllllIlllllII.getShort("CookTime");
        this.totalCookTime = llllllllllllIlllllIlllllIlllllII.getShort("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(1));
        if (llllllllllllIlllllIlllllIlllllII.hasKey("CustomName", 8)) {
            this.furnaceCustomName = llllllllllllIlllllIlllllIlllllII.getString("CustomName");
        }
    }
    
    public static boolean isBurning(final IInventory llllllllllllIlllllIlllllIllIllIl) {
        return llllllllllllIlllllIlllllIllIllIl.getField(0) > 0;
    }
    
    public static int getItemBurnTime(final ItemStack llllllllllllIlllllIlllllIIllllll) {
        if (llllllllllllIlllllIlllllIIllllll.func_190926_b()) {
            return 0;
        }
        final Item llllllllllllIlllllIlllllIlIIIIII = llllllllllllIlllllIlllllIIllllll.getItem();
        if (llllllllllllIlllllIlllllIlIIIIII == Item.getItemFromBlock(Blocks.WOODEN_SLAB)) {
            return 150;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Item.getItemFromBlock(Blocks.WOOL)) {
            return 100;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Item.getItemFromBlock(Blocks.CARPET)) {
            return 67;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Item.getItemFromBlock(Blocks.LADDER)) {
            return 300;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Item.getItemFromBlock(Blocks.WOODEN_BUTTON)) {
            return 100;
        }
        if (Block.getBlockFromItem(llllllllllllIlllllIlllllIlIIIIII).getDefaultState().getMaterial() == Material.WOOD) {
            return 300;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Item.getItemFromBlock(Blocks.COAL_BLOCK)) {
            return 16000;
        }
        if (llllllllllllIlllllIlllllIlIIIIII instanceof ItemTool && "WOOD".equals(((ItemTool)llllllllllllIlllllIlllllIlIIIIII).getToolMaterialName())) {
            return 200;
        }
        if (llllllllllllIlllllIlllllIlIIIIII instanceof ItemSword && "WOOD".equals(((ItemSword)llllllllllllIlllllIlllllIlIIIIII).getToolMaterialName())) {
            return 200;
        }
        if (llllllllllllIlllllIlllllIlIIIIII instanceof ItemHoe && "WOOD".equals(((ItemHoe)llllllllllllIlllllIlllllIlIIIIII).getMaterialName())) {
            return 200;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Items.STICK) {
            return 100;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Items.BOW || llllllllllllIlllllIlllllIlIIIIII == Items.FISHING_ROD) {
            return 300;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Items.SIGN) {
            return 200;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Items.COAL) {
            return 1600;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Items.LAVA_BUCKET) {
            return 20000;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Item.getItemFromBlock(Blocks.SAPLING) || llllllllllllIlllllIlllllIlIIIIII == Items.BOWL) {
            return 100;
        }
        if (llllllllllllIlllllIlllllIlIIIIII == Items.BLAZE_ROD) {
            return 2400;
        }
        if (llllllllllllIlllllIlllllIlIIIIII instanceof ItemDoor && llllllllllllIlllllIlllllIlIIIIII != Items.IRON_DOOR) {
            return 200;
        }
        return (llllllllllllIlllllIlllllIlIIIIII instanceof ItemBoat) ? 400 : 0;
    }
    
    @Override
    public boolean canInsertItem(final int llllllllllllIlllllIlllllIIIllIII, final ItemStack llllllllllllIlllllIlllllIIIlIlll, final EnumFacing llllllllllllIlllllIlllllIIIllIlI) {
        return this.isItemValidForSlot(llllllllllllIlllllIlllllIIIllIII, llllllllllllIlllllIlllllIIIlIlll);
    }
    
    public boolean isBurning() {
        return this.furnaceBurnTime > 0;
    }
    
    public static boolean isItemFuel(final ItemStack llllllllllllIlllllIlllllIIllllII) {
        return getItemBurnTime(llllllllllllIlllllIlllllIIllllII) > 0;
    }
    
    @Override
    public ItemStack removeStackFromSlot(final int llllllllllllIlllllIllllllIIllllI) {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, llllllllllllIlllllIllllllIIllllI);
    }
    
    @Override
    public boolean isItemValidForSlot(final int llllllllllllIlllllIlllllIIlIlIll, final ItemStack llllllllllllIlllllIlllllIIlIIllI) {
        if (llllllllllllIlllllIlllllIIlIlIll == 2) {
            return false;
        }
        if (llllllllllllIlllllIlllllIIlIlIll != 1) {
            return true;
        }
        final ItemStack llllllllllllIlllllIlllllIIlIlIIl = this.furnaceItemStacks.get(1);
        return isItemFuel(llllllllllllIlllllIlllllIIlIIllI) || (SlotFurnaceFuel.isBucket(llllllllllllIlllllIlllllIIlIIllI) && llllllllllllIlllllIlllllIIlIlIIl.getItem() != Items.BUCKET);
    }
    
    public TileEntityFurnace() {
        this.furnaceItemStacks = NonNullList.func_191197_a(3, ItemStack.field_190927_a);
    }
    
    private boolean canSmelt() {
        if (this.furnaceItemStacks.get(0).func_190926_b()) {
            return false;
        }
        final ItemStack llllllllllllIlllllIlllllIlIlIlII = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks.get(0));
        if (llllllllllllIlllllIlllllIlIlIlII.func_190926_b()) {
            return false;
        }
        final ItemStack llllllllllllIlllllIlllllIlIlIIll = this.furnaceItemStacks.get(2);
        return llllllllllllIlllllIlllllIlIlIIll.func_190926_b() || (llllllllllllIlllllIlllllIlIlIIll.isItemEqual(llllllllllllIlllllIlllllIlIlIlII) && ((llllllllllllIlllllIlllllIlIlIIll.func_190916_E() < this.getInventoryStackLimit() && llllllllllllIlllllIlllllIlIlIIll.func_190916_E() < llllllllllllIlllllIlllllIlIlIIll.getMaxStackSize()) || llllllllllllIlllllIlllllIlIlIIll.func_190916_E() < llllllllllllIlllllIlllllIlIlIlII.getMaxStackSize()));
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    @Override
    public boolean hasCustomName() {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllIlllllIlllllIIllIIll) {
    }
    
    public void smeltItem() {
        if (this.canSmelt()) {
            final ItemStack llllllllllllIlllllIlllllIlIIlIlI = this.furnaceItemStacks.get(0);
            final ItemStack llllllllllllIlllllIlllllIlIIlIIl = FurnaceRecipes.instance().getSmeltingResult(llllllllllllIlllllIlllllIlIIlIlI);
            final ItemStack llllllllllllIlllllIlllllIlIIlIII = this.furnaceItemStacks.get(2);
            if (llllllllllllIlllllIlllllIlIIlIII.func_190926_b()) {
                this.furnaceItemStacks.set(2, llllllllllllIlllllIlllllIlIIlIIl.copy());
            }
            else if (llllllllllllIlllllIlllllIlIIlIII.getItem() == llllllllllllIlllllIlllllIlIIlIIl.getItem()) {
                llllllllllllIlllllIlllllIlIIlIII.func_190917_f(1);
            }
            if (llllllllllllIlllllIlllllIlIIlIlI.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && llllllllllllIlllllIlllllIlIIlIlI.getMetadata() == 1 && !this.furnaceItemStacks.get(1).func_190926_b() && this.furnaceItemStacks.get(1).getItem() == Items.BUCKET) {
                this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
            }
            llllllllllllIlllllIlllllIlIIlIlI.func_190918_g(1);
        }
    }
    
    @Override
    public boolean canExtractItem(final int llllllllllllIlllllIlllllIIIIllIl, final ItemStack llllllllllllIlllllIlllllIIIIllII, final EnumFacing llllllllllllIlllllIlllllIIIIllll) {
        if (llllllllllllIlllllIlllllIIIIllll == EnumFacing.DOWN && llllllllllllIlllllIlllllIIIIllIl == 1) {
            final Item llllllllllllIlllllIlllllIIIIlllI = llllllllllllIlllllIlllllIIIIllII.getItem();
            if (llllllllllllIlllllIlllllIIIIlllI != Items.WATER_BUCKET && llllllllllllIlllllIlllllIIIIlllI != Items.BUCKET) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllIlllllIlllllIIllIIIl) {
    }
    
    @Override
    public void clear() {
        this.furnaceItemStacks.clear();
    }
    
    public int getCookTime(final ItemStack llllllllllllIlllllIlllllIlIllIIl) {
        return 200;
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack llllllllllllIlllllIllllllIllIllI : this.furnaceItemStacks) {
            if (!llllllllllllIlllllIllllllIllIllI.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public ItemStack decrStackSize(final int llllllllllllIlllllIllllllIlIlIII, final int llllllllllllIlllllIllllllIlIIlII) {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, llllllllllllIlllllIllllllIlIlIII, llllllllllllIlllllIllllllIlIIlII);
    }
    
    @Override
    public void setInventorySlotContents(final int llllllllllllIlllllIllllllIIlIIlI, final ItemStack llllllllllllIlllllIllllllIIlIllI) {
        final ItemStack llllllllllllIlllllIllllllIIlIlIl = this.furnaceItemStacks.get(llllllllllllIlllllIllllllIIlIIlI);
        final boolean llllllllllllIlllllIllllllIIlIlII = !llllllllllllIlllllIllllllIIlIllI.func_190926_b() && llllllllllllIlllllIllllllIIlIllI.isItemEqual(llllllllllllIlllllIllllllIIlIlIl) && ItemStack.areItemStackTagsEqual(llllllllllllIlllllIllllllIIlIllI, llllllllllllIlllllIllllllIIlIlIl);
        this.furnaceItemStacks.set(llllllllllllIlllllIllllllIIlIIlI, llllllllllllIlllllIllllllIIlIllI);
        if (llllllllllllIlllllIllllllIIlIllI.func_190916_E() > this.getInventoryStackLimit()) {
            llllllllllllIlllllIllllllIIlIllI.func_190920_e(this.getInventoryStackLimit());
        }
        if (llllllllllllIlllllIllllllIIlIIlI == 0 && !llllllllllllIlllllIllllllIIlIlII) {
            this.totalCookTime = this.getCookTime(llllllllllllIlllllIllllllIIlIllI);
            this.cookTime = 0;
            this.markDirty();
        }
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllIlllllIlllllIIIIIIlI, final EntityPlayer llllllllllllIlllllIlllllIIIIIlII) {
        return new ContainerFurnace(llllllllllllIlllllIlllllIIIIIIlI, this);
    }
    
    @Override
    public int getField(final int llllllllllllIlllllIllllIllllllII) {
        switch (llllllllllllIlllllIllllIllllllII) {
            case 0: {
                return this.furnaceBurnTime;
            }
            case 1: {
                return this.currentItemBurnTime;
            }
            case 2: {
                return this.cookTime;
            }
            case 3: {
                return this.totalCookTime;
            }
            default: {
                return 0;
            }
        }
    }
    
    @Override
    public ItemStack getStackInSlot(final int llllllllllllIlllllIllllllIlIllIl) {
        return this.furnaceItemStacks.get(llllllllllllIlllllIllllllIlIllIl);
    }
    
    @Override
    public void setField(final int llllllllllllIlllllIllllIllllIlII, final int llllllllllllIlllllIllllIllllIIll) {
        switch (llllllllllllIlllllIllllIllllIlII) {
            case 0: {
                this.furnaceBurnTime = llllllllllllIlllllIllllIllllIIll;
                break;
            }
            case 1: {
                this.currentItemBurnTime = llllllllllllIlllllIllllIllllIIll;
                break;
            }
            case 2: {
                this.cookTime = llllllllllllIlllllIllllIllllIIll;
                break;
            }
            case 3: {
                this.totalCookTime = llllllllllllIlllllIllllIllllIIll;
                break;
            }
        }
    }
    
    public void setCustomInventoryName(final String llllllllllllIlllllIllllllIIIIlIl) {
        this.furnaceCustomName = llllllllllllIlllllIllllllIIIIlIl;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIlllllIlllllIlllIllI) {
        super.writeToNBT(llllllllllllIlllllIlllllIlllIllI);
        llllllllllllIlllllIlllllIlllIllI.setShort("BurnTime", (short)this.furnaceBurnTime);
        llllllllllllIlllllIlllllIlllIllI.setShort("CookTime", (short)this.cookTime);
        llllllllllllIlllllIlllllIlllIllI.setShort("CookTimeTotal", (short)this.totalCookTime);
        ItemStackHelper.func_191282_a(llllllllllllIlllllIlllllIlllIllI, this.furnaceItemStacks);
        if (this.hasCustomName()) {
            llllllllllllIlllllIlllllIlllIllI.setString("CustomName", this.furnaceCustomName);
        }
        return llllllllllllIlllllIlllllIlllIllI;
    }
    
    @Override
    public void update() {
        final boolean llllllllllllIlllllIlllllIllIIlIl = this.isBurning();
        boolean llllllllllllIlllllIlllllIllIIlII = false;
        if (this.isBurning()) {
            --this.furnaceBurnTime;
        }
        if (!this.world.isRemote) {
            final ItemStack llllllllllllIlllllIlllllIllIIIll = this.furnaceItemStacks.get(1);
            if (this.isBurning() || (!llllllllllllIlllllIlllllIllIIIll.func_190926_b() && !this.furnaceItemStacks.get(0).func_190926_b())) {
                if (!this.isBurning() && this.canSmelt()) {
                    this.furnaceBurnTime = getItemBurnTime(llllllllllllIlllllIlllllIllIIIll);
                    this.currentItemBurnTime = this.furnaceBurnTime;
                    if (this.isBurning()) {
                        llllllllllllIlllllIlllllIllIIlII = true;
                        if (!llllllllllllIlllllIlllllIllIIIll.func_190926_b()) {
                            final Item llllllllllllIlllllIlllllIllIIIlI = llllllllllllIlllllIlllllIllIIIll.getItem();
                            llllllllllllIlllllIlllllIllIIIll.func_190918_g(1);
                            if (llllllllllllIlllllIlllllIllIIIll.func_190926_b()) {
                                final Item llllllllllllIlllllIlllllIllIIIIl = llllllllllllIlllllIlllllIllIIIlI.getContainerItem();
                                this.furnaceItemStacks.set(1, (llllllllllllIlllllIlllllIllIIIIl == null) ? ItemStack.field_190927_a : new ItemStack(llllllllllllIlllllIlllllIllIIIIl));
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt()) {
                    ++this.cookTime;
                    if (this.cookTime == this.totalCookTime) {
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.furnaceItemStacks.get(0));
                        this.smeltItem();
                        llllllllllllIlllllIlllllIllIIlII = true;
                    }
                }
                else {
                    this.cookTime = 0;
                }
            }
            else if (!this.isBurning() && this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
            if (llllllllllllIlllllIlllllIllIIlIl != this.isBurning()) {
                llllllllllllIlllllIlllllIllIIlII = true;
                BlockFurnace.setState(this.isBurning(), this.world, this.pos);
            }
        }
        if (llllllllllllIlllllIlllllIllIIlII) {
            this.markDirty();
        }
    }
    
    public static void registerFixesFurnace(final DataFixer llllllllllllIlllllIllllllIIIIIIl) {
        llllllllllllIlllllIllllllIIIIIIl.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityFurnace.class, new String[] { "Items" }));
    }
    
    static {
        SLOTS_TOP = new int[1];
        SLOTS_BOTTOM = new int[] { 2, 1 };
        SLOTS_SIDES = new int[] { 1 };
    }
    
    @Override
    public boolean isUsableByPlayer(final EntityPlayer llllllllllllIlllllIlllllIIllIlll) {
        return this.world.getTileEntity(this.pos) == this && llllllllllllIlllllIlllllIIllIlll.getDistanceSq(this.pos.getX() + 0.5, this.pos.getY() + 0.5, this.pos.getZ() + 0.5) <= 64.0;
    }
    
    @Override
    public int getSizeInventory() {
        return this.furnaceItemStacks.size();
    }
    
    @Override
    public int[] getSlotsForFace(final EnumFacing llllllllllllIlllllIlllllIIlIIIlI) {
        if (llllllllllllIlllllIlllllIIlIIIlI == EnumFacing.DOWN) {
            return TileEntityFurnace.SLOTS_BOTTOM;
        }
        return (llllllllllllIlllllIlllllIIlIIIlI == EnumFacing.UP) ? TileEntityFurnace.SLOTS_TOP : TileEntityFurnace.SLOTS_SIDES;
    }
}
