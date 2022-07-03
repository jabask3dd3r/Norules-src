package net.minecraft.tileentity;

import net.minecraft.item.*;
import net.minecraft.nbt.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.block.*;
import net.minecraft.util.datafix.walkers.*;
import net.minecraft.util.datafix.*;

public class TileEntityChest extends TileEntityLockableLoot implements ITickable
{
    public /* synthetic */ boolean adjacentChestChecked;
    public /* synthetic */ TileEntityChest adjacentChestXPos;
    private /* synthetic */ BlockChest.Type cachedChestType;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    public /* synthetic */ float lidAngle;
    public /* synthetic */ float prevLidAngle;
    public /* synthetic */ int numPlayersUsing;
    public /* synthetic */ TileEntityChest adjacentChestZPos;
    public /* synthetic */ TileEntityChest adjacentChestZNeg;
    private /* synthetic */ int ticksSinceSync;
    public /* synthetic */ TileEntityChest adjacentChestXNeg;
    private /* synthetic */ NonNullList<ItemStack> chestContents;
    
    @Override
    protected NonNullList<ItemStack> func_190576_q() {
        return this.chestContents;
    }
    
    @Override
    public void closeInventory(final EntityPlayer llllllllllllIllllllIIIlIlllIlllI) {
        if (!llllllllllllIllllllIIIlIlllIlllI.isSpectator() && this.getBlockType() instanceof BlockChest) {
            --this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
            if (this.getChestType() == BlockChest.Type.TRAP) {
                this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
            }
        }
    }
    
    public BlockChest.Type getChestType() {
        if (this.cachedChestType == null) {
            if (this.world == null || !(this.getBlockType() instanceof BlockChest)) {
                return BlockChest.Type.BASIC;
            }
            this.cachedChestType = ((BlockChest)this.getBlockType()).chestType;
        }
        return this.cachedChestType;
    }
    
    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        this.adjacentChestChecked = false;
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllIllllllIIIllIlIIlIIl) {
        super.writeToNBT(llllllllllllIllllllIIIllIlIIlIIl);
        if (!this.checkLootAndWrite(llllllllllllIllllllIIIllIlIIlIIl)) {
            ItemStackHelper.func_191282_a(llllllllllllIllllllIIIllIlIIlIIl, this.chestContents);
        }
        if (this.hasCustomName()) {
            llllllllllllIllllllIIIllIlIIlIIl.setString("CustomName", this.field_190577_o);
        }
        return llllllllllllIllllllIIIllIlIIlIIl;
    }
    
    @Nullable
    protected TileEntityChest getAdjacentChest(final EnumFacing llllllllllllIllllllIIIllIIllIIlI) {
        final BlockPos llllllllllllIllllllIIIllIIllIIIl = this.pos.offset(llllllllllllIllllllIIIllIIllIIlI);
        if (this.isChestAt(llllllllllllIllllllIIIllIIllIIIl)) {
            final TileEntity llllllllllllIllllllIIIllIIllIIII = this.world.getTileEntity(llllllllllllIllllllIIIllIIllIIIl);
            if (llllllllllllIllllllIIIllIIllIIII instanceof TileEntityChest) {
                final TileEntityChest llllllllllllIllllllIIIllIIlIllll = (TileEntityChest)llllllllllllIllllllIIIllIIllIIII;
                llllllllllllIllllllIIIllIIlIllll.setNeighbor(this, llllllllllllIllllllIIIllIIllIIlI.getOpposite());
                return llllllllllllIllllllIIIllIIlIllll;
            }
        }
        return null;
    }
    
    private void setNeighbor(final TileEntityChest llllllllllllIllllllIIIllIIllllIl, final EnumFacing llllllllllllIllllllIIIllIIllllll) {
        if (llllllllllllIllllllIIIllIIllllIl.isInvalid()) {
            this.adjacentChestChecked = false;
        }
        else if (this.adjacentChestChecked) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[llllllllllllIllllllIIIllIIllllll.ordinal()]) {
                case 3: {
                    if (this.adjacentChestZNeg != llllllllllllIllllllIIIllIIllllIl) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 4: {
                    if (this.adjacentChestZPos != llllllllllllIllllllIIIllIIllllIl) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 6: {
                    if (this.adjacentChestXPos != llllllllllllIllllllIIIllIIllllIl) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
                case 5: {
                    if (this.adjacentChestXNeg != llllllllllllIllllllIIIllIIllllIl) {
                        this.adjacentChestChecked = false;
                        break;
                    }
                    break;
                }
            }
        }
    }
    
    @Override
    public String getName() {
        return this.hasCustomName() ? this.field_190577_o : "container.chest";
    }
    
    public TileEntityChest() {
        this.chestContents = NonNullList.func_191197_a(27, ItemStack.field_190927_a);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = TileEntityChest.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final float llllllllllllIllllllIIIlIllIlIlll = (Object)new int[EnumFacing.values().length];
        try {
            llllllllllllIllllllIIIlIllIlIlll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllIllllllIIIlIllIlIlll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllIllllllIIIlIllIlIlll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllIllllllIIIlIllIlIlll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllIllllllIIIlIllIlIlll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllIllllllIIIlIllIlIlll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return TileEntityChest.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)llllllllllllIllllllIIIlIllIlIlll;
    }
    
    @Override
    public void update() {
        this.checkForAdjacentChests();
        final int llllllllllllIllllllIIIllIIIlIllI = this.pos.getX();
        final int llllllllllllIllllllIIIllIIIlIlIl = this.pos.getY();
        final int llllllllllllIllllllIIIllIIIlIlII = this.pos.getZ();
        ++this.ticksSinceSync;
        if (!this.world.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + llllllllllllIllllllIIIllIIIlIllI + llllllllllllIllllllIIIllIIIlIlIl + llllllllllllIllllllIIIllIIIlIlII) % 200 == 0) {
            this.numPlayersUsing = 0;
            final float llllllllllllIllllllIIIllIIIlIIll = 5.0f;
            for (final EntityPlayer llllllllllllIllllllIIIllIIIlIIlI : this.world.getEntitiesWithinAABB((Class<? extends Entity>)EntityPlayer.class, new AxisAlignedBB(llllllllllllIllllllIIIllIIIlIllI - 5.0f, llllllllllllIllllllIIIllIIIlIlIl - 5.0f, llllllllllllIllllllIIIllIIIlIlII - 5.0f, llllllllllllIllllllIIIllIIIlIllI + 1 + 5.0f, llllllllllllIllllllIIIllIIIlIlIl + 1 + 5.0f, llllllllllllIllllllIIIllIIIlIlII + 1 + 5.0f))) {
                if (llllllllllllIllllllIIIllIIIlIIlI.openContainer instanceof ContainerChest) {
                    final IInventory llllllllllllIllllllIIIllIIIlIIIl = ((ContainerChest)llllllllllllIllllllIIIllIIIlIIlI.openContainer).getLowerChestInventory();
                    if (llllllllllllIllllllIIIllIIIlIIIl != this && (!(llllllllllllIllllllIIIllIIIlIIIl instanceof InventoryLargeChest) || !((InventoryLargeChest)llllllllllllIllllllIIIllIIIlIIIl).isPartOfLargeChest(this))) {
                        continue;
                    }
                    ++this.numPlayersUsing;
                }
            }
        }
        this.prevLidAngle = this.lidAngle;
        final float llllllllllllIllllllIIIllIIIlIIII = 0.1f;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0f && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
            double llllllllllllIllllllIIIllIIIIllll = llllllllllllIllllllIIIllIIIlIllI + 0.5;
            double llllllllllllIllllllIIIllIIIIlllI = llllllllllllIllllllIIIllIIIlIlII + 0.5;
            if (this.adjacentChestZPos != null) {
                llllllllllllIllllllIIIllIIIIlllI += 0.5;
            }
            if (this.adjacentChestXPos != null) {
                llllllllllllIllllllIIIllIIIIllll += 0.5;
            }
            this.world.playSound(null, llllllllllllIllllllIIIllIIIIllll, llllllllllllIllllllIIIllIIIlIlIl + 0.5, llllllllllllIllllllIIIllIIIIlllI, SoundEvents.BLOCK_CHEST_OPEN, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
        }
        if ((this.numPlayersUsing == 0 && this.lidAngle > 0.0f) || (this.numPlayersUsing > 0 && this.lidAngle < 1.0f)) {
            final float llllllllllllIllllllIIIllIIIIllIl = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1f;
            }
            else {
                this.lidAngle -= 0.1f;
            }
            if (this.lidAngle > 1.0f) {
                this.lidAngle = 1.0f;
            }
            final float llllllllllllIllllllIIIllIIIIllII = 0.5f;
            if (this.lidAngle < 0.5f && llllllllllllIllllllIIIllIIIIllIl >= 0.5f && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
                double llllllllllllIllllllIIIllIIIIlIll = llllllllllllIllllllIIIllIIIlIllI + 0.5;
                double llllllllllllIllllllIIIllIIIIlIlI = llllllllllllIllllllIIIllIIIlIlII + 0.5;
                if (this.adjacentChestZPos != null) {
                    llllllllllllIllllllIIIllIIIIlIlI += 0.5;
                }
                if (this.adjacentChestXPos != null) {
                    llllllllllllIllllllIIIllIIIIlIll += 0.5;
                }
                this.world.playSound(null, llllllllllllIllllllIIIllIIIIlIll, llllllllllllIllllllIIIllIIIlIlIl + 0.5, llllllllllllIllllllIIIllIIIIlIlI, SoundEvents.BLOCK_CHEST_CLOSE, SoundCategory.BLOCKS, 0.5f, this.world.rand.nextFloat() * 0.1f + 0.9f);
            }
            if (this.lidAngle < 0.0f) {
                this.lidAngle = 0.0f;
            }
        }
    }
    
    @Override
    public boolean func_191420_l() {
        for (final ItemStack llllllllllllIllllllIIIllIlIllllI : this.chestContents) {
            if (!llllllllllllIllllllIIIllIlIllllI.func_190926_b()) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public int getSizeInventory() {
        return 27;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer llllllllllllIllllllIIIlIlllIIIII, final EntityPlayer llllllllllllIllllllIIIlIllIlllII) {
        this.fillWithLoot(llllllllllllIllllllIIIlIllIlllII);
        return new ContainerChest(llllllllllllIllllllIIIlIlllIIIII, this, llllllllllllIllllllIIIlIllIlllII);
    }
    
    private boolean isChestAt(final BlockPos llllllllllllIllllllIIIllIIlIIIlI) {
        if (this.world == null) {
            return false;
        }
        final Block llllllllllllIllllllIIIllIIlIIlII = this.world.getBlockState(llllllllllllIllllllIIIllIIlIIIlI).getBlock();
        return llllllllllllIllllllIIIllIIlIIlII instanceof BlockChest && ((BlockChest)llllllllllllIllllllIIIllIIlIIlII).chestType == this.getChestType();
    }
    
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    
    public TileEntityChest(final BlockChest.Type llllllllllllIllllllIIIllIllIIlII) {
        this.chestContents = NonNullList.func_191197_a(27, ItemStack.field_190927_a);
        this.cachedChestType = llllllllllllIllllllIIIllIllIIlII;
    }
    
    @Override
    public void openInventory(final EntityPlayer llllllllllllIllllllIIIlIllllIIlI) {
        if (!llllllllllllIllllllIIIlIllllIIlI.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.world.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, this.getBlockType(), false);
            if (this.getChestType() == BlockChest.Type.TRAP) {
                this.world.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType(), false);
            }
        }
    }
    
    public static void registerFixesChest(final DataFixer llllllllllllIllllllIIIllIlIlIlIl) {
        llllllllllllIllllllIIIllIlIlIlIl.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityChest.class, new String[] { "Items" }));
    }
    
    @Override
    public void invalidate() {
        super.invalidate();
        this.updateContainingBlockInfo();
        this.checkForAdjacentChests();
    }
    
    @Override
    public boolean receiveClientEvent(final int llllllllllllIllllllIIIlIlllllIIl, final int llllllllllllIllllllIIIlIlllllIll) {
        if (llllllllllllIllllllIIIlIlllllIIl == 1) {
            this.numPlayersUsing = llllllllllllIllllllIIIlIlllllIll;
            return true;
        }
        return super.receiveClientEvent(llllllllllllIllllllIIIlIlllllIIl, llllllllllllIllllllIIIlIlllllIll);
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllIllllllIIIllIlIIllll) {
        super.readFromNBT(llllllllllllIllllllIIIllIlIIllll);
        this.chestContents = NonNullList.func_191197_a(this.getSizeInventory(), ItemStack.field_190927_a);
        if (!this.checkLootAndRead(llllllllllllIllllllIIIllIlIIllll)) {
            ItemStackHelper.func_191283_b(llllllllllllIllllllIIIllIlIIllll, this.chestContents);
        }
        if (llllllllllllIllllllIIIllIlIIllll.hasKey("CustomName", 8)) {
            this.field_190577_o = llllllllllllIllllllIIIllIlIIllll.getString("CustomName");
        }
    }
    
    @Override
    public String getGuiID() {
        return "minecraft:chest";
    }
    
    public void checkForAdjacentChests() {
        if (!this.adjacentChestChecked) {
            this.adjacentChestChecked = true;
            this.adjacentChestXNeg = this.getAdjacentChest(EnumFacing.WEST);
            this.adjacentChestXPos = this.getAdjacentChest(EnumFacing.EAST);
            this.adjacentChestZNeg = this.getAdjacentChest(EnumFacing.NORTH);
            this.adjacentChestZPos = this.getAdjacentChest(EnumFacing.SOUTH);
        }
    }
}
