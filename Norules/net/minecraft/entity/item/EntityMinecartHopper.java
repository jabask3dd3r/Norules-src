package net.minecraft.entity.item;

import net.minecraft.util.math.*;
import net.minecraft.nbt.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import com.google.common.base.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.util.datafix.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;

public class EntityMinecartHopper extends EntityMinecartContainer implements IHopper
{
    private final /* synthetic */ BlockPos lastPosition;
    private /* synthetic */ int transferTicker;
    private /* synthetic */ boolean isBlocked;
    
    @Override
    public String getGuiID() {
        return "minecraft:hopper";
    }
    
    @Override
    protected void readEntityFromNBT(final NBTTagCompound lllllllllllllIlIIIlIIlllIIIlIllI) {
        super.readEntityFromNBT(lllllllllllllIlIIIlIIlllIIIlIllI);
        this.transferTicker = lllllllllllllIlIIIlIIlllIIIlIllI.getInteger("TransferCooldown");
        this.isBlocked = (!lllllllllllllIlIIIlIIlllIIIlIllI.hasKey("Enabled") || lllllllllllllIlIIIlIIlllIIIlIllI.getBoolean("Enabled"));
    }
    
    @Override
    public Type getType() {
        return Type.HOPPER;
    }
    
    @Override
    public double getYPos() {
        return this.posY + 0.5;
    }
    
    @Override
    public int getDefaultDisplayTileOffset() {
        return 1;
    }
    
    @Override
    public void onActivatorRailPass(final int lllllllllllllIlIIIlIIlllIlIlIIIl, final int lllllllllllllIlIIIlIIlllIlIlIIII, final int lllllllllllllIlIIIlIIlllIlIIllll, final boolean lllllllllllllIlIIIlIIlllIlIIlllI) {
        final boolean lllllllllllllIlIIIlIIlllIlIIllIl = !lllllllllllllIlIIIlIIlllIlIIlllI;
        if (lllllllllllllIlIIIlIIlllIlIIllIl != this.getBlocked()) {
            this.setBlocked(lllllllllllllIlIIIlIIlllIlIIllIl);
        }
    }
    
    @Override
    public IBlockState getDefaultDisplayTile() {
        return Blocks.HOPPER.getDefaultState();
    }
    
    @Override
    public void killMinecart(final DamageSource lllllllllllllIlIIIlIIlllIIlIIIll) {
        super.killMinecart(lllllllllllllIlIIIlIIlllIIlIIIll);
        if (this.world.getGameRules().getBoolean("doEntityDrops")) {
            this.dropItemWithOffset(Item.getItemFromBlock(Blocks.HOPPER), 1, 0.0f);
        }
    }
    
    @Override
    public double getXPos() {
        return this.posX;
    }
    
    public boolean canTransfer() {
        return this.transferTicker > 0;
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!this.world.isRemote && this.isEntityAlive() && this.getBlocked()) {
            final BlockPos lllllllllllllIlIIIlIIlllIIllIIIl = new BlockPos(this);
            if (lllllllllllllIlIIIlIIlllIIllIIIl.equals(this.lastPosition)) {
                --this.transferTicker;
            }
            else {
                this.setTransferTicker(0);
            }
            if (!this.canTransfer()) {
                this.setTransferTicker(0);
                if (this.captureDroppedItems()) {
                    this.setTransferTicker(4);
                    this.markDirty();
                }
            }
        }
    }
    
    @Override
    protected void writeEntityToNBT(final NBTTagCompound lllllllllllllIlIIIlIIlllIIIllIlI) {
        super.writeEntityToNBT(lllllllllllllIlIIIlIIlllIIIllIlI);
        lllllllllllllIlIIIlIIlllIIIllIlI.setInteger("TransferCooldown", this.transferTicker);
        lllllllllllllIlIIIlIIlllIIIllIlI.setBoolean("Enabled", this.isBlocked);
    }
    
    @Override
    public double getZPos() {
        return this.posZ;
    }
    
    public boolean captureDroppedItems() {
        if (TileEntityHopper.captureDroppedItems(this)) {
            return true;
        }
        final List<EntityItem> lllllllllllllIlIIIlIIlllIIlIlIll = this.world.getEntitiesWithinAABB((Class<? extends EntityItem>)EntityItem.class, this.getEntityBoundingBox().expand(0.25, 0.0, 0.25), (com.google.common.base.Predicate<? super EntityItem>)EntitySelectors.IS_ALIVE);
        if (!lllllllllllllIlIIIlIIlllIIlIlIll.isEmpty()) {
            TileEntityHopper.putDropInInventoryAllSlots(null, this, lllllllllllllIlIIIlIIlllIIlIlIll.get(0));
        }
        return false;
    }
    
    @Override
    public boolean processInitialInteract(final EntityPlayer lllllllllllllIlIIIlIIlllIlIllIIl, final EnumHand lllllllllllllIlIIIlIIlllIlIllIII) {
        if (!this.world.isRemote) {
            lllllllllllllIlIIIlIIlllIlIllIIl.displayGUIChest(this);
        }
        return true;
    }
    
    public EntityMinecartHopper(final World lllllllllllllIlIIIlIIlllIlllIIII) {
        super(lllllllllllllIlIIIlIIlllIlllIIII);
        this.isBlocked = true;
        this.transferTicker = -1;
        this.lastPosition = BlockPos.ORIGIN;
    }
    
    public static void registerFixesMinecartHopper(final DataFixer lllllllllllllIlIIIlIIlllIIlIIIII) {
        EntityMinecartContainer.func_190574_b(lllllllllllllIlIIIlIIlllIIlIIIII, EntityMinecartHopper.class);
    }
    
    @Override
    public int getSizeInventory() {
        return 5;
    }
    
    @Override
    public Container createContainer(final InventoryPlayer lllllllllllllIlIIIlIIlllIIIIIlIl, final EntityPlayer lllllllllllllIlIIIlIIlllIIIIIIIl) {
        return new ContainerHopper(lllllllllllllIlIIIlIIlllIIIIIlIl, this, lllllllllllllIlIIIlIIlllIIIIIIIl);
    }
    
    public void setTransferTicker(final int lllllllllllllIlIIIlIIlllIIIlIIII) {
        this.transferTicker = lllllllllllllIlIIIlIIlllIIIlIIII;
    }
    
    @Override
    public World getWorld() {
        return this.world;
    }
    
    public boolean getBlocked() {
        return this.isBlocked;
    }
    
    public EntityMinecartHopper(final World lllllllllllllIlIIIlIIlllIllIIlII, final double lllllllllllllIlIIIlIIlllIllIIIll, final double lllllllllllllIlIIIlIIlllIllIIlll, final double lllllllllllllIlIIIlIIlllIllIIllI) {
        super(lllllllllllllIlIIIlIIlllIllIIlII, lllllllllllllIlIIIlIIlllIllIIIll, lllllllllllllIlIIIlIIlllIllIIlll, lllllllllllllIlIIIlIIlllIllIIllI);
        this.isBlocked = true;
        this.transferTicker = -1;
        this.lastPosition = BlockPos.ORIGIN;
    }
    
    public void setBlocked(final boolean lllllllllllllIlIIIlIIlllIlIIIIIl) {
        this.isBlocked = lllllllllllllIlIIIlIIlllIlIIIIIl;
    }
}
