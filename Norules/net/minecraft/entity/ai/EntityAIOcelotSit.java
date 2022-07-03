package net.minecraft.entity.ai;

import net.minecraft.entity.passive.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.*;

public class EntityAIOcelotSit extends EntityAIMoveToBlock
{
    private final /* synthetic */ EntityOcelot ocelot;
    
    @Override
    protected boolean shouldMoveTo(final World lllllllllllllIIlIlIIIIlIIIIllllI, final BlockPos lllllllllllllIIlIlIIIIlIIIIlllIl) {
        if (!lllllllllllllIIlIlIIIIlIIIIllllI.isAirBlock(lllllllllllllIIlIlIIIIlIIIIlllIl.up())) {
            return false;
        }
        final IBlockState lllllllllllllIIlIlIIIIlIIIIlllII = lllllllllllllIIlIlIIIIlIIIIllllI.getBlockState(lllllllllllllIIlIlIIIIlIIIIlllIl);
        final Block lllllllllllllIIlIlIIIIlIIIIllIll = lllllllllllllIIlIlIIIIlIIIIlllII.getBlock();
        if (lllllllllllllIIlIlIIIIlIIIIllIll == Blocks.CHEST) {
            final TileEntity lllllllllllllIIlIlIIIIlIIIIllIlI = lllllllllllllIIlIlIIIIlIIIIllllI.getTileEntity(lllllllllllllIIlIlIIIIlIIIIlllIl);
            if (lllllllllllllIIlIlIIIIlIIIIllIlI instanceof TileEntityChest && ((TileEntityChest)lllllllllllllIIlIlIIIIlIIIIllIlI).numPlayersUsing < 1) {
                return true;
            }
        }
        else {
            if (lllllllllllllIIlIlIIIIlIIIIllIll == Blocks.LIT_FURNACE) {
                return true;
            }
            if (lllllllllllllIIlIlIIIIlIIIIllIll == Blocks.BED && lllllllllllllIIlIlIIIIlIIIIlllII.getValue(BlockBed.PART) != BlockBed.EnumPartType.HEAD) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void resetTask() {
        super.resetTask();
        this.ocelot.setSitting(false);
    }
    
    @Override
    public void updateTask() {
        super.updateTask();
        this.ocelot.getAISit().setSitting(false);
        if (!this.getIsAboveDestination()) {
            this.ocelot.setSitting(false);
        }
        else if (!this.ocelot.isSitting()) {
            this.ocelot.setSitting(true);
        }
    }
    
    @Override
    public boolean shouldExecute() {
        return this.ocelot.isTamed() && !this.ocelot.isSitting() && super.shouldExecute();
    }
    
    @Override
    public void startExecuting() {
        super.startExecuting();
        this.ocelot.getAISit().setSitting(false);
    }
    
    public EntityAIOcelotSit(final EntityOcelot lllllllllllllIIlIlIIIIlIIIllIIlI, final double lllllllllllllIIlIlIIIIlIIIllIIIl) {
        super(lllllllllllllIIlIlIIIIlIIIllIIlI, lllllllllllllIIlIlIIIIlIIIllIIIl, 8);
        this.ocelot = lllllllllllllIIlIlIIIIlIIIllIIlI;
    }
}
