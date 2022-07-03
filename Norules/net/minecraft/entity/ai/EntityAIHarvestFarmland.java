package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.inventory.*;

public class EntityAIHarvestFarmland extends EntityAIMoveToBlock
{
    private final /* synthetic */ EntityVillager theVillager;
    private /* synthetic */ int currentTask;
    private /* synthetic */ boolean hasFarmItem;
    private /* synthetic */ boolean wantsToReapStuff;
    
    @Override
    public boolean shouldExecute() {
        if (this.runDelay <= 0) {
            if (!this.theVillager.world.getGameRules().getBoolean("mobGriefing")) {
                return false;
            }
            this.currentTask = -1;
            this.hasFarmItem = this.theVillager.isFarmItemInInventory();
            this.wantsToReapStuff = this.theVillager.wantsMoreFood();
        }
        return super.shouldExecute();
    }
    
    public EntityAIHarvestFarmland(final EntityVillager llllllllllllllIIIIllIIllllIlllll, final double llllllllllllllIIIIllIIllllIllllI) {
        super(llllllllllllllIIIIllIIllllIlllll, llllllllllllllIIIIllIIllllIllllI, 16);
        this.theVillager = llllllllllllllIIIIllIIllllIlllll;
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
        this.theVillager.getLookHelper().setLookPosition(this.destinationBlock.getX() + 0.5, this.destinationBlock.getY() + 1, this.destinationBlock.getZ() + 0.5, 10.0f, (float)this.theVillager.getVerticalFaceSpeed());
        if (this.getIsAboveDestination()) {
            final World llllllllllllllIIIIllIIllllIIllIl = this.theVillager.world;
            final BlockPos llllllllllllllIIIIllIIllllIIllII = this.destinationBlock.up();
            final IBlockState llllllllllllllIIIIllIIllllIIlIll = llllllllllllllIIIIllIIllllIIllIl.getBlockState(llllllllllllllIIIIllIIllllIIllII);
            final Block llllllllllllllIIIIllIIllllIIlIlI = llllllllllllllIIIIllIIllllIIlIll.getBlock();
            if (this.currentTask == 0 && llllllllllllllIIIIllIIllllIIlIlI instanceof BlockCrops && ((BlockCrops)llllllllllllllIIIIllIIllllIIlIlI).isMaxAge(llllllllllllllIIIIllIIllllIIlIll)) {
                llllllllllllllIIIIllIIllllIIllIl.destroyBlock(llllllllllllllIIIIllIIllllIIllII, true);
            }
            else if (this.currentTask == 1 && llllllllllllllIIIIllIIllllIIlIll.getMaterial() == Material.AIR) {
                final InventoryBasic llllllllllllllIIIIllIIllllIIlIIl = this.theVillager.getVillagerInventory();
                int llllllllllllllIIIIllIIllllIIlIII = 0;
                while (llllllllllllllIIIIllIIllllIIlIII < llllllllllllllIIIIllIIllllIIlIIl.getSizeInventory()) {
                    final ItemStack llllllllllllllIIIIllIIllllIIIlll = llllllllllllllIIIIllIIllllIIlIIl.getStackInSlot(llllllllllllllIIIIllIIllllIIlIII);
                    boolean llllllllllllllIIIIllIIllllIIIllI = false;
                    if (!llllllllllllllIIIIllIIllllIIIlll.func_190926_b()) {
                        if (llllllllllllllIIIIllIIllllIIIlll.getItem() == Items.WHEAT_SEEDS) {
                            llllllllllllllIIIIllIIllllIIllIl.setBlockState(llllllllllllllIIIIllIIllllIIllII, Blocks.WHEAT.getDefaultState(), 3);
                            llllllllllllllIIIIllIIllllIIIllI = true;
                        }
                        else if (llllllllllllllIIIIllIIllllIIIlll.getItem() == Items.POTATO) {
                            llllllllllllllIIIIllIIllllIIllIl.setBlockState(llllllllllllllIIIIllIIllllIIllII, Blocks.POTATOES.getDefaultState(), 3);
                            llllllllllllllIIIIllIIllllIIIllI = true;
                        }
                        else if (llllllllllllllIIIIllIIllllIIIlll.getItem() == Items.CARROT) {
                            llllllllllllllIIIIllIIllllIIllIl.setBlockState(llllllllllllllIIIIllIIllllIIllII, Blocks.CARROTS.getDefaultState(), 3);
                            llllllllllllllIIIIllIIllllIIIllI = true;
                        }
                        else if (llllllllllllllIIIIllIIllllIIIlll.getItem() == Items.BEETROOT_SEEDS) {
                            llllllllllllllIIIIllIIllllIIllIl.setBlockState(llllllllllllllIIIIllIIllllIIllII, Blocks.BEETROOTS.getDefaultState(), 3);
                            llllllllllllllIIIIllIIllllIIIllI = true;
                        }
                    }
                    if (llllllllllllllIIIIllIIllllIIIllI) {
                        llllllllllllllIIIIllIIllllIIIlll.func_190918_g(1);
                        if (llllllllllllllIIIIllIIllllIIIlll.func_190926_b()) {
                            llllllllllllllIIIIllIIllllIIlIIl.setInventorySlotContents(llllllllllllllIIIIllIIllllIIlIII, ItemStack.field_190927_a);
                            break;
                        }
                        break;
                    }
                    else {
                        ++llllllllllllllIIIIllIIllllIIlIII;
                    }
                }
            }
            this.currentTask = -1;
            this.runDelay = 10;
        }
    }
    
    @Override
    protected boolean shouldMoveTo(final World llllllllllllllIIIIllIIlllIllIIIl, BlockPos llllllllllllllIIIIllIIlllIllIIII) {
        Block llllllllllllllIIIIllIIlllIllIlII = llllllllllllllIIIIllIIlllIllIIIl.getBlockState(llllllllllllllIIIIllIIlllIllIIII).getBlock();
        if (llllllllllllllIIIIllIIlllIllIlII == Blocks.FARMLAND) {
            llllllllllllllIIIIllIIlllIllIIII = llllllllllllllIIIIllIIlllIllIIII.up();
            final IBlockState llllllllllllllIIIIllIIlllIllIIll = llllllllllllllIIIIllIIlllIllIIIl.getBlockState(llllllllllllllIIIIllIIlllIllIIII);
            llllllllllllllIIIIllIIlllIllIlII = llllllllllllllIIIIllIIlllIllIIll.getBlock();
            if (llllllllllllllIIIIllIIlllIllIlII instanceof BlockCrops && ((BlockCrops)llllllllllllllIIIIllIIlllIllIlII).isMaxAge(llllllllllllllIIIIllIIlllIllIIll) && this.wantsToReapStuff && (this.currentTask == 0 || this.currentTask < 0)) {
                this.currentTask = 0;
                return true;
            }
            if (llllllllllllllIIIIllIIlllIllIIll.getMaterial() == Material.AIR && this.hasFarmItem && (this.currentTask == 1 || this.currentTask < 0)) {
                this.currentTask = 1;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean continueExecuting() {
        return this.currentTask >= 0 && super.continueExecuting();
    }
}
