package net.minecraft.block;

import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import net.minecraft.inventory.*;
import net.minecraft.dispenser.*;

public class BlockDropper extends BlockDispenser
{
    private final /* synthetic */ IBehaviorDispenseItem dropBehavior;
    
    @Override
    protected IBehaviorDispenseItem getBehavior(final ItemStack llllllllllllllIIllIIllIlllllIIII) {
        return this.dropBehavior;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIllIIllIllllIllIl, final int llllllllllllllIIllIIllIllllIllII) {
        return new TileEntityDropper();
    }
    
    @Override
    protected void dispense(final World llllllllllllllIIllIIllIlllIlllll, final BlockPos llllllllllllllIIllIIllIlllIllllI) {
        final BlockSourceImpl llllllllllllllIIllIIllIlllIlllIl = new BlockSourceImpl(llllllllllllllIIllIIllIlllIlllll, llllllllllllllIIllIIllIlllIllllI);
        final TileEntityDispenser llllllllllllllIIllIIllIlllIlllII = llllllllllllllIIllIIllIlllIlllIl.getBlockTileEntity();
        if (llllllllllllllIIllIIllIlllIlllII != null) {
            final int llllllllllllllIIllIIllIlllIllIll = llllllllllllllIIllIIllIlllIlllII.getDispenseSlot();
            if (llllllllllllllIIllIIllIlllIllIll < 0) {
                llllllllllllllIIllIIllIlllIlllll.playEvent(1001, llllllllllllllIIllIIllIlllIllllI, 0);
            }
            else {
                final ItemStack llllllllllllllIIllIIllIlllIllIlI = llllllllllllllIIllIIllIlllIlllII.getStackInSlot(llllllllllllllIIllIIllIlllIllIll);
                if (!llllllllllllllIIllIIllIlllIllIlI.func_190926_b()) {
                    final EnumFacing llllllllllllllIIllIIllIlllIllIIl = llllllllllllllIIllIIllIlllIlllll.getBlockState(llllllllllllllIIllIIllIlllIllllI).getValue((IProperty<EnumFacing>)BlockDropper.FACING);
                    final BlockPos llllllllllllllIIllIIllIlllIllIII = llllllllllllllIIllIIllIlllIllllI.offset(llllllllllllllIIllIIllIlllIllIIl);
                    final IInventory llllllllllllllIIllIIllIlllIlIlll = TileEntityHopper.getInventoryAtPosition(llllllllllllllIIllIIllIlllIlllll, llllllllllllllIIllIIllIlllIllIII.getX(), llllllllllllllIIllIIllIlllIllIII.getY(), llllllllllllllIIllIIllIlllIllIII.getZ());
                    ItemStack llllllllllllllIIllIIllIlllIlIlIl = null;
                    if (llllllllllllllIIllIIllIlllIlIlll == null) {
                        final ItemStack llllllllllllllIIllIIllIlllIlIllI = this.dropBehavior.dispense(llllllllllllllIIllIIllIlllIlllIl, llllllllllllllIIllIIllIlllIllIlI);
                    }
                    else {
                        llllllllllllllIIllIIllIlllIlIlIl = TileEntityHopper.putStackInInventoryAllSlots(llllllllllllllIIllIIllIlllIlllII, llllllllllllllIIllIIllIlllIlIlll, llllllllllllllIIllIIllIlllIllIlI.copy().splitStack(1), llllllllllllllIIllIIllIlllIllIIl.getOpposite());
                        if (llllllllllllllIIllIIllIlllIlIlIl.func_190926_b()) {
                            llllllllllllllIIllIIllIlllIlIlIl = llllllllllllllIIllIIllIlllIllIlI.copy();
                            llllllllllllllIIllIIllIlllIlIlIl.func_190918_g(1);
                        }
                        else {
                            llllllllllllllIIllIIllIlllIlIlIl = llllllllllllllIIllIIllIlllIllIlI.copy();
                        }
                    }
                    llllllllllllllIIllIIllIlllIlllII.setInventorySlotContents(llllllllllllllIIllIIllIlllIllIll, llllllllllllllIIllIIllIlllIlIlIl);
                }
            }
        }
    }
    
    public BlockDropper() {
        this.dropBehavior = new BehaviorDefaultDispenseItem();
    }
}
