package net.minecraft.tileentity;

import net.minecraft.item.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import com.google.common.base.*;
import java.util.*;
import net.minecraft.nbt.*;
import net.minecraft.block.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import javax.annotation.*;

public class TileEntityHopper extends TileEntityLockableLoot implements ITickable, IHopper
{
    private /* synthetic */ NonNullList<ItemStack> inventory;
    private /* synthetic */ long field_190578_g;
    private /* synthetic */ int transferCooldown;
    
    @Override
    protected NonNullList<ItemStack> func_190576_q() {
        return this.inventory;
    }
    
    private static boolean pullItemFromSlot(final IHopper lllllllllllllllIIIIIIllIIllllIll, final IInventory lllllllllllllllIIIIIIllIIllllIlI, final int lllllllllllllllIIIIIIllIIlllIIlI, final EnumFacing lllllllllllllllIIIIIIllIIlllIIIl) {
        final ItemStack lllllllllllllllIIIIIIllIIlllIlll = lllllllllllllllIIIIIIllIIllllIlI.getStackInSlot(lllllllllllllllIIIIIIllIIlllIIlI);
        if (!lllllllllllllllIIIIIIllIIlllIlll.func_190926_b() && canExtractItemFromSlot(lllllllllllllllIIIIIIllIIllllIlI, lllllllllllllllIIIIIIllIIlllIlll, lllllllllllllllIIIIIIllIIlllIIlI, lllllllllllllllIIIIIIllIIlllIIIl)) {
            final ItemStack lllllllllllllllIIIIIIllIIlllIllI = lllllllllllllllIIIIIIllIIlllIlll.copy();
            final ItemStack lllllllllllllllIIIIIIllIIlllIlIl = putStackInInventoryAllSlots(lllllllllllllllIIIIIIllIIllllIlI, lllllllllllllllIIIIIIllIIllllIll, lllllllllllllllIIIIIIllIIllllIlI.decrStackSize(lllllllllllllllIIIIIIllIIlllIIlI, 1), null);
            if (lllllllllllllllIIIIIIllIIlllIlIl.func_190926_b()) {
                lllllllllllllllIIIIIIllIIllllIlI.markDirty();
                return true;
            }
            lllllllllllllllIIIIIIllIIllllIlI.setInventorySlotContents(lllllllllllllllIIIIIIllIIlllIIlI, lllllllllllllllIIIIIIllIIlllIllI);
        }
        return false;
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    private boolean isInventoryFull(final IInventory lllllllllllllllIIIIIIllIllIIIllI, final EnumFacing lllllllllllllllIIIIIIllIllIIIlIl) {
        if (lllllllllllllllIIIIIIllIllIIIllI instanceof ISidedInventory) {
            final ISidedInventory lllllllllllllllIIIIIIllIllIIIlII = (ISidedInventory)lllllllllllllllIIIIIIllIllIIIllI;
            final int[] lllllllllllllllIIIIIIllIllIIIIll = lllllllllllllllIIIIIIllIllIIIlII.getSlotsForFace(lllllllllllllllIIIIIIllIllIIIlIl);
            final long lllllllllllllllIIIIIIllIlIllIllI;
            final Exception lllllllllllllllIIIIIIllIlIllIlll = (Exception)((int[])(Object)(lllllllllllllllIIIIIIllIlIllIllI = (long)(Object)lllllllllllllllIIIIIIllIllIIIIll)).length;
            for (double lllllllllllllllIIIIIIllIlIlllIII = 0; lllllllllllllllIIIIIIllIlIlllIII < lllllllllllllllIIIIIIllIlIllIlll; ++lllllllllllllllIIIIIIllIlIlllIII) {
                final int lllllllllllllllIIIIIIllIllIIIIlI = lllllllllllllllIIIIIIllIlIllIllI[lllllllllllllllIIIIIIllIlIlllIII];
                final ItemStack lllllllllllllllIIIIIIllIllIIIIIl = lllllllllllllllIIIIIIllIllIIIlII.getStackInSlot(lllllllllllllllIIIIIIllIllIIIIlI);
                if (lllllllllllllllIIIIIIllIllIIIIIl.func_190926_b() || lllllllllllllllIIIIIIllIllIIIIIl.func_190916_E() != lllllllllllllllIIIIIIllIllIIIIIl.getMaxStackSize()) {
                    return false;
                }
            }
        }
        else {
            for (int lllllllllllllllIIIIIIllIllIIIIII = lllllllllllllllIIIIIIllIllIIIllI.getSizeInventory(), lllllllllllllllIIIIIIllIlIllllll = 0; lllllllllllllllIIIIIIllIlIllllll < lllllllllllllllIIIIIIllIllIIIIII; ++lllllllllllllllIIIIIIllIlIllllll) {
                final ItemStack lllllllllllllllIIIIIIllIlIlllllI = lllllllllllllllIIIIIIllIllIIIllI.getStackInSlot(lllllllllllllllIIIIIIllIlIllllll);
                if (lllllllllllllllIIIIIIllIlIlllllI.func_190926_b() || lllllllllllllllIIIIIIllIlIlllllI.func_190916_E() != lllllllllllllllIIIIIIllIlIlllllI.getMaxStackSize()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void registerFixesHopper(final DataFixer lllllllllllllllIIIIIIlllIIlIlIII) {
        lllllllllllllllIIIIIIlllIIlIlIII.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityHopper.class, new String[] { "Items" }));
    }
    
    @Override
    public double getYPos() {
        return this.pos.getY() + 0.5;
    }
    
    private static boolean isInventoryEmpty(final IInventory lllllllllllllllIIIIIIllIlIlIIlIl, final EnumFacing lllllllllllllllIIIIIIllIlIlIIlII) {
        if (lllllllllllllllIIIIIIllIlIlIIlIl instanceof ISidedInventory) {
            final ISidedInventory lllllllllllllllIIIIIIllIlIlIlIlI = (ISidedInventory)lllllllllllllllIIIIIIllIlIlIIlIl;
            final int[] lllllllllllllllIIIIIIllIlIlIlIIl = lllllllllllllllIIIIIIllIlIlIlIlI.getSlotsForFace(lllllllllllllllIIIIIIllIlIlIIlII);
            final int lllllllllllllllIIIIIIllIlIIllllI;
            final short lllllllllllllllIIIIIIllIlIIlllll = (short)((int[])(Object)(lllllllllllllllIIIIIIllIlIIllllI = (int)(Object)lllllllllllllllIIIIIIllIlIlIlIIl)).length;
            for (final int lllllllllllllllIIIIIIllIlIlIlIII : lllllllllllllllIIIIIIllIlIIllllI) {
                if (!lllllllllllllllIIIIIIllIlIlIlIlI.getStackInSlot(lllllllllllllllIIIIIIllIlIlIlIII).func_190926_b()) {
                    return false;
                }
            }
        }
        else {
            for (int lllllllllllllllIIIIIIllIlIlIIlll = lllllllllllllllIIIIIIllIlIlIIlIl.getSizeInventory(), lllllllllllllllIIIIIIllIlIlIIllI = 0; lllllllllllllllIIIIIIllIlIlIIllI < lllllllllllllllIIIIIIllIlIlIIlll; ++lllllllllllllllIIIIIIllIlIlIIllI) {
                if (!lllllllllllllllIIIIIIllIlIlIIlIl.getStackInSlot(lllllllllllllllIIIIIIllIlIlIIllI).func_190926_b()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @Override
    public int getSizeInventory() {
        return this.inventory.size();
    }
    
    @Override
    public double getXPos() {
        return this.pos.getX() + 0.5;
    }
    
    public static IInventory getInventoryAtPosition(final World lllllllllllllllIIIIIIlIllllIlIIl, final double lllllllllllllllIIIIIIlIlllIlllII, final double lllllllllllllllIIIIIIlIllllIIlll, final double lllllllllllllllIIIIIIlIllllIIllI) {
        IInventory lllllllllllllllIIIIIIlIllllIIlIl = null;
        final int lllllllllllllllIIIIIIlIllllIIlII = MathHelper.floor(lllllllllllllllIIIIIIlIlllIlllII);
        final int lllllllllllllllIIIIIIlIllllIIIll = MathHelper.floor(lllllllllllllllIIIIIIlIllllIIlll);
        final int lllllllllllllllIIIIIIlIllllIIIlI = MathHelper.floor(lllllllllllllllIIIIIIlIllllIIllI);
        final BlockPos lllllllllllllllIIIIIIlIllllIIIIl = new BlockPos(lllllllllllllllIIIIIIlIllllIIlII, lllllllllllllllIIIIIIlIllllIIIll, lllllllllllllllIIIIIIlIllllIIIlI);
        final Block lllllllllllllllIIIIIIlIllllIIIII = lllllllllllllllIIIIIIlIllllIlIIl.getBlockState(lllllllllllllllIIIIIIlIllllIIIIl).getBlock();
        if (lllllllllllllllIIIIIIlIllllIIIII.hasTileEntity()) {
            final TileEntity lllllllllllllllIIIIIIlIlllIlllll = lllllllllllllllIIIIIIlIllllIlIIl.getTileEntity(lllllllllllllllIIIIIIlIllllIIIIl);
            if (lllllllllllllllIIIIIIlIlllIlllll instanceof IInventory) {
                lllllllllllllllIIIIIIlIllllIIlIl = (IInventory)lllllllllllllllIIIIIIlIlllIlllll;
                if (lllllllllllllllIIIIIIlIllllIIlIl instanceof TileEntityChest && lllllllllllllllIIIIIIlIllllIIIII instanceof BlockChest) {
                    lllllllllllllllIIIIIIlIllllIIlIl = ((BlockChest)lllllllllllllllIIIIIIlIllllIIIII).getContainer(lllllllllllllllIIIIIIlIllllIlIIl, lllllllllllllllIIIIIIlIllllIIIIl, true);
                }
            }
        }
        if (lllllllllllllllIIIIIIlIllllIIlIl == null) {
            final List<Entity> lllllllllllllllIIIIIIlIlllIllllI = lllllllllllllllIIIIIIlIllllIlIIl.getEntitiesInAABBexcluding(null, new AxisAlignedBB(lllllllllllllllIIIIIIlIlllIlllII - 0.5, lllllllllllllllIIIIIIlIllllIIlll - 0.5, lllllllllllllllIIIIIIlIllllIIllI - 0.5, lllllllllllllllIIIIIIlIlllIlllII + 0.5, lllllllllllllllIIIIIIlIllllIIlll + 0.5, lllllllllllllllIIIIIIlIllllIIllI + 0.5), EntitySelectors.HAS_INVENTORY);
            if (!lllllllllllllllIIIIIIlIlllIllllI.isEmpty()) {
                lllllllllllllllIIIIIIlIllllIIlIl = (IInventory)lllllllllllllllIIIIIIlIlllIllllI.get(lllllllllllllllIIIIIIlIllllIlIIl.rand.nextInt(lllllllllllllllIIIIIIlIlllIllllI.size()));
            }
        }
        return lllllllllllllllIIIIIIlIllllIIlIl;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound lllllllllllllllIIIIIIlllIIIllIll) {
        super.writeToNBT(lllllllllllllllIIIIIIlllIIIllIll);
        if (!this.checkLootAndWrite(lllllllllllllllIIIIIIlllIIIllIll)) {
            ItemStackHelper.func_191282_a(lllllllllllllllIIIIIIlllIIIllIll, this.inventory);
        }
        lllllllllllllllIIIIIIlllIIIllIll.setInteger("TransferCooldown", this.transferCooldown);
        if (this.hasCustomName()) {
            lllllllllllllllIIIIIIlllIIIllIll.setString("CustomName", this.field_190577_o);
        }
        return lllllllllllllllIIIIIIlllIIIllIll;
    }
    
    private boolean isFull() {
        for (final ItemStack lllllllllllllllIIIIIIllIlllIIllI : this.inventory) {
            if (lllllllllllllllIIIIIIllIlllIIllI.func_190926_b() || lllllllllllllllIIIIIIllIlllIIllI.func_190916_E() != lllllllllllllllIIIIIIllIlllIIllI.getMaxStackSize()) {
                return false;
            }
        }
        return true;
    }
    
    public TileEntityHopper() {
        this.inventory = NonNullList.func_191197_a(5, ItemStack.field_190927_a);
        this.transferCooldown = -1;
    }
    
    private boolean updateHopper() {
        if (this.world != null && !this.world.isRemote) {
            if (!this.isOnTransferCooldown() && BlockHopper.isEnabled(this.getBlockMetadata())) {
                boolean lllllllllllllllIIIIIIllIlllllIII = false;
                if (!this.isEmpty()) {
                    lllllllllllllllIIIIIIllIlllllIII = this.transferItemsOut();
                }
                if (!this.isFull()) {
                    lllllllllllllllIIIIIIllIlllllIII = (captureDroppedItems(this) || lllllllllllllllIIIIIIllIlllllIII);
                }
                if (lllllllllllllllIIIIIIllIlllllIII) {
                    this.setTransferCooldown(8);
                    this.markDirty();
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    @Override
    public double getZPos() {
        return this.pos.getZ() + 0.5;
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound lllllllllllllllIIIIIIlllIIlIIIIl) {
        super.readFromNBT(lllllllllllllllIIIIIIlllIIlIIIIl);
        this.inventory = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (!this.checkLootAndRead(lllllllllllllllIIIIIIlllIIlIIIIl)) {
            ItemStackHelper.func_191283_b(lllllllllllllllIIIIIIlllIIlIIIIl, this.inventory);
        }
        if (lllllllllllllllIIIIIIlllIIlIIIIl.hasKey("CustomName", 8)) {
            this.field_190577_o = lllllllllllllllIIIIIIlllIIlIIIIl.getString("CustomName");
        }
        this.transferCooldown = lllllllllllllllIIIIIIlllIIlIIIIl.getInteger("TransferCooldown");
    }
    
    public static boolean putDropInInventoryAllSlots(final IInventory lllllllllllllllIIIIIIllIIllIIlll, final IInventory lllllllllllllllIIIIIIllIIllIIllI, final EntityItem lllllllllllllllIIIIIIllIIllIIlIl) {
        boolean lllllllllllllllIIIIIIllIIllIIlII = false;
        if (lllllllllllllllIIIIIIllIIllIIlIl == null) {
            return false;
        }
        final ItemStack lllllllllllllllIIIIIIllIIllIIIll = lllllllllllllllIIIIIIllIIllIIlIl.getEntityItem().copy();
        final ItemStack lllllllllllllllIIIIIIllIIllIIIlI = putStackInInventoryAllSlots(lllllllllllllllIIIIIIllIIllIIlll, lllllllllllllllIIIIIIllIIllIIllI, lllllllllllllllIIIIIIllIIllIIIll, null);
        if (lllllllllllllllIIIIIIllIIllIIIlI.func_190926_b()) {
            lllllllllllllllIIIIIIllIIllIIlII = true;
            lllllllllllllllIIIIIIllIIllIIlIl.setDead();
        }
        else {
            lllllllllllllllIIIIIIllIIllIIlIl.setEntityItemStack(lllllllllllllllIIIIIIllIIllIIIlI);
        }
        return lllllllllllllllIIIIIIllIIllIIlII;
    }
    
    private boolean mayTransfer() {
        return this.transferCooldown > 8;
    }
    
    private static boolean canInsertItemInSlot(final IInventory lllllllllllllllIIIIIIllIIlIIIIII, final ItemStack lllllllllllllllIIIIIIllIIIlllIll, final int lllllllllllllllIIIIIIllIIIlllllI, final EnumFacing lllllllllllllllIIIIIIllIIIllllIl) {
        return lllllllllllllllIIIIIIllIIlIIIIII.isItemValidForSlot(lllllllllllllllIIIIIIllIIIlllllI, lllllllllllllllIIIIIIllIIIlllIll) && (!(lllllllllllllllIIIIIIllIIlIIIIII instanceof ISidedInventory) || ((ISidedInventory)lllllllllllllllIIIIIIllIIlIIIIII).canInsertItem(lllllllllllllllIIIIIIllIIIlllllI, lllllllllllllllIIIIIIllIIIlllIll, lllllllllllllllIIIIIIllIIIllllIl));
    }
    
    @Override
    public ItemStack decrStackSize(final int lllllllllllllllIIIIIIlllIIIlIIlI, final int lllllllllllllllIIIIIIlllIIIlIIIl) {
        this.fillWithLoot(null);
        final ItemStack lllllllllllllllIIIIIIlllIIIlIIII = ItemStackHelper.getAndSplit(this.func_190576_q(), lllllllllllllllIIIIIIlllIIIlIIlI, lllllllllllllllIIIIIIlllIIIlIIIl);
        return lllllllllllllllIIIIIIlllIIIlIIII;
    }
    
    private boolean isOnTransferCooldown() {
        return this.transferCooldown > 0;
    }
    
    private static ItemStack insertStack(final IInventory lllllllllllllllIIIIIIllIIIIlIlII, final IInventory lllllllllllllllIIIIIIllIIIlIIIII, ItemStack lllllllllllllllIIIIIIllIIIIlIIlI, final int lllllllllllllllIIIIIIllIIIIlIIIl, final EnumFacing lllllllllllllllIIIIIIllIIIIlllIl) {
        final ItemStack lllllllllllllllIIIIIIllIIIIlllII = lllllllllllllllIIIIIIllIIIlIIIII.getStackInSlot(lllllllllllllllIIIIIIllIIIIlIIIl);
        if (canInsertItemInSlot(lllllllllllllllIIIIIIllIIIlIIIII, (ItemStack)lllllllllllllllIIIIIIllIIIIlIIlI, lllllllllllllllIIIIIIllIIIIlIIIl, lllllllllllllllIIIIIIllIIIIlllIl)) {
            boolean lllllllllllllllIIIIIIllIIIIllIll = false;
            final boolean lllllllllllllllIIIIIIllIIIIllIlI = lllllllllllllllIIIIIIllIIIlIIIII.func_191420_l();
            if (lllllllllllllllIIIIIIllIIIIlllII.func_190926_b()) {
                lllllllllllllllIIIIIIllIIIlIIIII.setInventorySlotContents(lllllllllllllllIIIIIIllIIIIlIIIl, (ItemStack)lllllllllllllllIIIIIIllIIIIlIIlI);
                lllllllllllllllIIIIIIllIIIIlIIlI = ItemStack.field_190927_a;
                lllllllllllllllIIIIIIllIIIIllIll = true;
            }
            else if (canCombine(lllllllllllllllIIIIIIllIIIIlllII, (ItemStack)lllllllllllllllIIIIIIllIIIIlIIlI)) {
                final int lllllllllllllllIIIIIIllIIIIllIIl = ((ItemStack)lllllllllllllllIIIIIIllIIIIlIIlI).getMaxStackSize() - lllllllllllllllIIIIIIllIIIIlllII.func_190916_E();
                final int lllllllllllllllIIIIIIllIIIIllIII = Math.min(((ItemStack)lllllllllllllllIIIIIIllIIIIlIIlI).func_190916_E(), lllllllllllllllIIIIIIllIIIIllIIl);
                ((ItemStack)lllllllllllllllIIIIIIllIIIIlIIlI).func_190918_g(lllllllllllllllIIIIIIllIIIIllIII);
                lllllllllllllllIIIIIIllIIIIlllII.func_190917_f(lllllllllllllllIIIIIIllIIIIllIII);
                lllllllllllllllIIIIIIllIIIIllIll = (lllllllllllllllIIIIIIllIIIIllIII > 0);
            }
            if (lllllllllllllllIIIIIIllIIIIllIll) {
                if (lllllllllllllllIIIIIIllIIIIllIlI && lllllllllllllllIIIIIIllIIIlIIIII instanceof TileEntityHopper) {
                    final TileEntityHopper lllllllllllllllIIIIIIllIIIIlIlll = (TileEntityHopper)lllllllllllllllIIIIIIllIIIlIIIII;
                    if (!lllllllllllllllIIIIIIllIIIIlIlll.mayTransfer()) {
                        int lllllllllllllllIIIIIIllIIIIlIllI = 0;
                        if (lllllllllllllllIIIIIIllIIIIlIlII != null && lllllllllllllllIIIIIIllIIIIlIlII instanceof TileEntityHopper) {
                            final TileEntityHopper lllllllllllllllIIIIIIllIIIIlIlIl = (TileEntityHopper)lllllllllllllllIIIIIIllIIIIlIlII;
                            if (lllllllllllllllIIIIIIllIIIIlIlll.field_190578_g >= lllllllllllllllIIIIIIllIIIIlIlIl.field_190578_g) {
                                lllllllllllllllIIIIIIllIIIIlIllI = 1;
                            }
                        }
                        lllllllllllllllIIIIIIllIIIIlIlll.setTransferCooldown(8 - lllllllllllllllIIIIIIllIIIIlIllI);
                    }
                }
                lllllllllllllllIIIIIIllIIIlIIIII.markDirty();
            }
        }
        return (ItemStack)lllllllllllllllIIIIIIllIIIIlIIlI;
    }
    
    private boolean isEmpty() {
        for (final ItemStack lllllllllllllllIIIIIIllIllllIIIl : this.inventory) {
            if (!lllllllllllllllIIIIIIllIllllIIIl.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.hopper";
    }
    
    private void setTransferCooldown(final int lllllllllllllllIIIIIIlIllIllllII) {
        this.transferCooldown = lllllllllllllllIIIIIIlIllIllllII;
    }
    
    private static boolean canCombine(final ItemStack lllllllllllllllIIIIIIlIlllIIlllI, final ItemStack lllllllllllllllIIIIIIlIlllIIllIl) {
        return lllllllllllllllIIIIIIlIlllIIlllI.getItem() == lllllllllllllllIIIIIIlIlllIIllIl.getItem() && lllllllllllllllIIIIIIlIlllIIlllI.getMetadata() == lllllllllllllllIIIIIIlIlllIIllIl.getMetadata() && lllllllllllllllIIIIIIlIlllIIlllI.func_190916_E() <= lllllllllllllllIIIIIIlIlllIIlllI.getMaxStackSize() && ItemStack.areItemStackTagsEqual(lllllllllllllllIIIIIIlIlllIIlllI, lllllllllllllllIIIIIIlIlllIIllIl);
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllllIIIIIIlIllIIlIlII, final EntityPlayer lllllllllllllllIIIIIIlIllIIlIlll) {
        this.fillWithLoot(lllllllllllllllIIIIIIlIllIIlIlll);
        return new ContainerHopper(lllllllllllllllIIIIIIlIllIIlIlII, this, lllllllllllllllIIIIIIlIllIIlIlll);
    }
    
    @Override
    public void update() {
        if (this.world != null && !this.world.isRemote) {
            --this.transferCooldown;
            this.field_190578_g = this.world.getTotalWorldTime();
            if (!this.isOnTransferCooldown()) {
                this.setTransferCooldown(0);
                this.updateHopper();
            }
        }
    }
    
    private IInventory getInventoryForHopperTransfer() {
        final EnumFacing lllllllllllllllIIIIIIllIIIIIIllI = BlockHopper.getFacing(this.getBlockMetadata());
        return getInventoryAtPosition(this.getWorld(), this.getXPos() + lllllllllllllllIIIIIIllIIIIIIllI.getFrontOffsetX(), this.getYPos() + lllllllllllllllIIIIIIllIIIIIIllI.getFrontOffsetY(), this.getZPos() + lllllllllllllllIIIIIIllIIIIIIllI.getFrontOffsetZ());
    }
    
    public static ItemStack putStackInInventoryAllSlots(final IInventory lllllllllllllllIIIIIIllIIlIlIlII, final IInventory lllllllllllllllIIIIIIllIIlIIlIlI, ItemStack lllllllllllllllIIIIIIllIIlIIlIIl, @Nullable final EnumFacing lllllllllllllllIIIIIIllIIlIIlIII) {
        if (lllllllllllllllIIIIIIllIIlIIlIlI instanceof ISidedInventory && lllllllllllllllIIIIIIllIIlIIlIII != null) {
            final ISidedInventory lllllllllllllllIIIIIIllIIlIlIIII = (ISidedInventory)lllllllllllllllIIIIIIllIIlIIlIlI;
            final int[] lllllllllllllllIIIIIIllIIlIIllll = lllllllllllllllIIIIIIllIIlIlIIII.getSlotsForFace(lllllllllllllllIIIIIIllIIlIIlIII);
            for (int lllllllllllllllIIIIIIllIIlIIlllI = 0; lllllllllllllllIIIIIIllIIlIIlllI < lllllllllllllllIIIIIIllIIlIIllll.length; ++lllllllllllllllIIIIIIllIIlIIlllI) {
                if (lllllllllllllllIIIIIIllIIlIIlIIl.func_190926_b()) {
                    break;
                }
                lllllllllllllllIIIIIIllIIlIIlIIl = insertStack(lllllllllllllllIIIIIIllIIlIlIlII, lllllllllllllllIIIIIIllIIlIIlIlI, lllllllllllllllIIIIIIllIIlIIlIIl, lllllllllllllllIIIIIIllIIlIIllll[lllllllllllllllIIIIIIllIIlIIlllI], lllllllllllllllIIIIIIllIIlIIlIII);
            }
        }
        else {
            for (int lllllllllllllllIIIIIIllIIlIIllIl = lllllllllllllllIIIIIIllIIlIIlIlI.getSizeInventory(), lllllllllllllllIIIIIIllIIlIIllII = 0; lllllllllllllllIIIIIIllIIlIIllII < lllllllllllllllIIIIIIllIIlIIllIl && !lllllllllllllllIIIIIIllIIlIIlIIl.func_190926_b(); lllllllllllllllIIIIIIllIIlIIlIIl = insertStack(lllllllllllllllIIIIIIllIIlIlIlII, lllllllllllllllIIIIIIllIIlIIlIlI, lllllllllllllllIIIIIIllIIlIIlIIl, lllllllllllllllIIIIIIllIIlIIllII, lllllllllllllllIIIIIIllIIlIIlIII), ++lllllllllllllllIIIIIIllIIlIIllII) {}
        }
        return lllllllllllllllIIIIIIllIIlIIlIIl;
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:hopper";
    }
    
    @Override
    public void setInventorySlotContents(final int lllllllllllllllIIIIIIlllIIIIIlll, final ItemStack lllllllllllllllIIIIIIlllIIIIIllI) {
        this.fillWithLoot(null);
        this.func_190576_q().set(lllllllllllllllIIIIIIlllIIIIIlll, lllllllllllllllIIIIIIlllIIIIIllI);
        if (lllllllllllllllIIIIIIlllIIIIIllI.func_190916_E() > this.getInventoryStackLimit()) {
            lllllllllllllllIIIIIIlllIIIIIllI.func_190920_e(this.getInventoryStackLimit());
        }
    }
    
    public static IInventory getHopperInventory(final IHopper lllllllllllllllIIIIIIllIIIIIIIIl) {
        return getInventoryAtPosition(lllllllllllllllIIIIIIllIIIIIIIIl.getWorld(), lllllllllllllllIIIIIIllIIIIIIIIl.getXPos(), lllllllllllllllIIIIIIllIIIIIIIIl.getYPos() + 1.0, lllllllllllllllIIIIIIllIIIIIIIIl.getZPos());
    }
    
    public static List<EntityItem> getCaptureItems(final World lllllllllllllllIIIIIIlIllllllIII, final double lllllllllllllllIIIIIIlIllllllIll, final double lllllllllllllllIIIIIIlIllllllIlI, final double lllllllllllllllIIIIIIlIlllllIlIl) {
        return lllllllllllllllIIIIIIlIllllllIII.getEntitiesWithinAABB((Class<? extends EntityItem>)EntityItem.class, new AxisAlignedBB(lllllllllllllllIIIIIIlIllllllIll - 0.5, lllllllllllllllIIIIIIlIllllllIlI, lllllllllllllllIIIIIIlIlllllIlIl - 0.5, lllllllllllllllIIIIIIlIllllllIll + 0.5, lllllllllllllllIIIIIIlIllllllIlI + 1.5, lllllllllllllllIIIIIIlIlllllIlIl + 0.5), (com.google.common.base.Predicate<? super EntityItem>)EntitySelectors.IS_ALIVE);
    }
    
    private static boolean canExtractItemFromSlot(final IInventory lllllllllllllllIIIIIIllIIIllIIII, final ItemStack lllllllllllllllIIIIIIllIIIlIllll, final int lllllllllllllllIIIIIIllIIIlIlllI, final EnumFacing lllllllllllllllIIIIIIllIIIlIllIl) {
        return !(lllllllllllllllIIIIIIllIIIllIIII instanceof ISidedInventory) || ((ISidedInventory)lllllllllllllllIIIIIIllIIIllIIII).canExtractItem(lllllllllllllllIIIIIIllIIIlIlllI, lllllllllllllllIIIIIIllIIIlIllll, lllllllllllllllIIIIIIllIIIlIllIl);
    }
    
    @Override
    public boolean func_191420_l() {
        return this.isEmpty();
    }
    
    public static boolean captureDroppedItems(final IHopper lllllllllllllllIIIIIIllIlIIlIlII) {
        final IInventory lllllllllllllllIIIIIIllIlIIlIIll = getHopperInventory(lllllllllllllllIIIIIIllIlIIlIlII);
        if (lllllllllllllllIIIIIIllIlIIlIIll != null) {
            final EnumFacing lllllllllllllllIIIIIIllIlIIlIIlI = EnumFacing.DOWN;
            if (isInventoryEmpty(lllllllllllllllIIIIIIllIlIIlIIll, lllllllllllllllIIIIIIllIlIIlIIlI)) {
                return false;
            }
            if (lllllllllllllllIIIIIIllIlIIlIIll instanceof ISidedInventory) {
                final ISidedInventory lllllllllllllllIIIIIIllIlIIlIIIl = (ISidedInventory)lllllllllllllllIIIIIIllIlIIlIIll;
                final int[] lllllllllllllllIIIIIIllIlIIlIIII = lllllllllllllllIIIIIIllIlIIlIIIl.getSlotsForFace(lllllllllllllllIIIIIIllIlIIlIIlI);
                final long lllllllllllllllIIIIIIllIlIIIIIll;
                final long lllllllllllllllIIIIIIllIlIIIIlII = ((int[])(Object)(lllllllllllllllIIIIIIllIlIIIIIll = (long)(Object)lllllllllllllllIIIIIIllIlIIlIIII)).length;
                for (String lllllllllllllllIIIIIIllIlIIIIlIl = (String)0; lllllllllllllllIIIIIIllIlIIIIlIl < lllllllllllllllIIIIIIllIlIIIIlII; ++lllllllllllllllIIIIIIllIlIIIIlIl) {
                    final int lllllllllllllllIIIIIIllIlIIIllll = lllllllllllllllIIIIIIllIlIIIIIll[lllllllllllllllIIIIIIllIlIIIIlIl];
                    if (pullItemFromSlot(lllllllllllllllIIIIIIllIlIIlIlII, lllllllllllllllIIIIIIllIlIIlIIll, lllllllllllllllIIIIIIllIlIIIllll, lllllllllllllllIIIIIIllIlIIlIIlI)) {
                        return true;
                    }
                }
            }
            else {
                for (int lllllllllllllllIIIIIIllIlIIIlllI = lllllllllllllllIIIIIIllIlIIlIIll.getSizeInventory(), lllllllllllllllIIIIIIllIlIIIllIl = 0; lllllllllllllllIIIIIIllIlIIIllIl < lllllllllllllllIIIIIIllIlIIIlllI; ++lllllllllllllllIIIIIIllIlIIIllIl) {
                    if (pullItemFromSlot(lllllllllllllllIIIIIIllIlIIlIlII, lllllllllllllllIIIIIIllIlIIlIIll, lllllllllllllllIIIIIIllIlIIIllIl, lllllllllllllllIIIIIIllIlIIlIIlI)) {
                        return true;
                    }
                }
            }
        }
        else {
            for (final EntityItem lllllllllllllllIIIIIIllIlIIIllII : getCaptureItems(lllllllllllllllIIIIIIllIlIIlIlII.getWorld(), lllllllllllllllIIIIIIllIlIIlIlII.getXPos(), lllllllllllllllIIIIIIllIlIIlIlII.getYPos(), lllllllllllllllIIIIIIllIlIIlIlII.getZPos())) {
                if (putDropInInventoryAllSlots(null, lllllllllllllllIIIIIIllIlIIlIlII, lllllllllllllllIIIIIIllIlIIIllII)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean transferItemsOut() {
        final IInventory lllllllllllllllIIIIIIllIllIllIll = this.getInventoryForHopperTransfer();
        if (lllllllllllllllIIIIIIllIllIllIll == null) {
            return false;
        }
        final EnumFacing lllllllllllllllIIIIIIllIllIllIlI = BlockHopper.getFacing(this.getBlockMetadata()).getOpposite();
        if (this.isInventoryFull(lllllllllllllllIIIIIIllIllIllIll, lllllllllllllllIIIIIIllIllIllIlI)) {
            return false;
        }
        for (int lllllllllllllllIIIIIIllIllIllIIl = 0; lllllllllllllllIIIIIIllIllIllIIl < this.getSizeInventory(); ++lllllllllllllllIIIIIIllIllIllIIl) {
            if (!this.getStackInSlot(lllllllllllllllIIIIIIllIllIllIIl).func_190926_b()) {
                final ItemStack lllllllllllllllIIIIIIllIllIllIII = this.getStackInSlot(lllllllllllllllIIIIIIllIllIllIIl).copy();
                final ItemStack lllllllllllllllIIIIIIllIllIlIlll = putStackInInventoryAllSlots(this, lllllllllllllllIIIIIIllIllIllIll, this.decrStackSize(lllllllllllllllIIIIIIllIllIllIIl, 1), lllllllllllllllIIIIIIllIllIllIlI);
                if (lllllllllllllllIIIIIIllIllIlIlll.func_190926_b()) {
                    lllllllllllllllIIIIIIllIllIllIll.markDirty();
                    return true;
                }
                this.setInventorySlotContents(lllllllllllllllIIIIIIllIllIllIIl, lllllllllllllllIIIIIIllIllIllIII);
            }
        }
        return false;
    }
}
