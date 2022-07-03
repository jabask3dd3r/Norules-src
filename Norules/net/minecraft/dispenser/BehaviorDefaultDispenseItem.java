package net.minecraft.dispenser;

import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;

public class BehaviorDefaultDispenseItem implements IBehaviorDispenseItem
{
    @Override
    public final ItemStack dispense(final IBlockSource lllllllllllllIllIlIllIlIIIIlllIl, final ItemStack lllllllllllllIllIlIllIlIIIIlllII) {
        final ItemStack lllllllllllllIllIlIllIlIIIIllIll = this.dispenseStack(lllllllllllllIllIlIllIlIIIIlllIl, lllllllllllllIllIlIllIlIIIIlllII);
        this.playDispenseSound(lllllllllllllIllIlIllIlIIIIlllIl);
        this.spawnDispenseParticles(lllllllllllllIllIlIllIlIIIIlllIl, lllllllllllllIllIlIllIlIIIIlllIl.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING));
        return lllllllllllllIllIlIllIlIIIIllIll;
    }
    
    protected ItemStack dispenseStack(final IBlockSource lllllllllllllIllIlIllIlIIIIlIIII, final ItemStack lllllllllllllIllIlIllIlIIIIIlIlI) {
        final EnumFacing lllllllllllllIllIlIllIlIIIIIlllI = lllllllllllllIllIlIllIlIIIIlIIII.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
        final IPosition lllllllllllllIllIlIllIlIIIIIllIl = BlockDispenser.getDispensePosition(lllllllllllllIllIlIllIlIIIIlIIII);
        final ItemStack lllllllllllllIllIlIllIlIIIIIllII = lllllllllllllIllIlIllIlIIIIIlIlI.splitStack(1);
        doDispense(lllllllllllllIllIlIllIlIIIIlIIII.getWorld(), lllllllllllllIllIlIllIlIIIIIllII, 6, lllllllllllllIllIlIllIlIIIIIlllI, lllllllllllllIllIlIllIlIIIIIllIl);
        return lllllllllllllIllIlIllIlIIIIIlIlI;
    }
    
    private int getWorldEventDataFrom(final EnumFacing lllllllllllllIllIlIllIIlllIllIII) {
        return lllllllllllllIllIlIllIIlllIllIII.getFrontOffsetX() + 1 + (lllllllllllllIllIlIllIIlllIllIII.getFrontOffsetZ() + 1) * 3;
    }
    
    protected void spawnDispenseParticles(final IBlockSource lllllllllllllIllIlIllIIllllIIIII, final EnumFacing lllllllllllllIllIlIllIIlllIlllll) {
        lllllllllllllIllIlIllIIllllIIIII.getWorld().playEvent(2000, lllllllllllllIllIlIllIIllllIIIII.getBlockPos(), this.getWorldEventDataFrom(lllllllllllllIllIlIllIIlllIlllll));
    }
    
    public static void doDispense(final World lllllllllllllIllIlIllIIlllllIIlI, final ItemStack lllllllllllllIllIlIllIIllllllIll, final int lllllllllllllIllIlIllIIllllllIlI, final EnumFacing lllllllllllllIllIlIllIIllllllIIl, final IPosition lllllllllllllIllIlIllIIllllIlllI) {
        final double lllllllllllllIllIlIllIIlllllIlll = lllllllllllllIllIlIllIIllllIlllI.getX();
        double lllllllllllllIllIlIllIIlllllIllI = lllllllllllllIllIlIllIIllllIlllI.getY();
        final double lllllllllllllIllIlIllIIlllllIlIl = lllllllllllllIllIlIllIIllllIlllI.getZ();
        if (lllllllllllllIllIlIllIIllllllIIl.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllIllIlIllIIlllllIllI -= 0.125;
        }
        else {
            lllllllllllllIllIlIllIIlllllIllI -= 0.15625;
        }
        final EntityItem lllllllllllllIllIlIllIIlllllIlII = new EntityItem(lllllllllllllIllIlIllIIlllllIIlI, lllllllllllllIllIlIllIIlllllIlll, lllllllllllllIllIlIllIIlllllIllI, lllllllllllllIllIlIllIIlllllIlIl, lllllllllllllIllIlIllIIllllllIll);
        final double lllllllllllllIllIlIllIIlllllIIll = lllllllllllllIllIlIllIIlllllIIlI.rand.nextDouble() * 0.1 + 0.2;
        lllllllllllllIllIlIllIIlllllIlII.motionX = lllllllllllllIllIlIllIIllllllIIl.getFrontOffsetX() * lllllllllllllIllIlIllIIlllllIIll;
        lllllllllllllIllIlIllIIlllllIlII.motionY = 0.20000000298023224;
        lllllllllllllIllIlIllIIlllllIlII.motionZ = lllllllllllllIllIlIllIIllllllIIl.getFrontOffsetZ() * lllllllllllllIllIlIllIIlllllIIll;
        final EntityItem entityItem = lllllllllllllIllIlIllIIlllllIlII;
        entityItem.motionX += lllllllllllllIllIlIllIIlllllIIlI.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllIlIllIIllllllIlI;
        final EntityItem entityItem2 = lllllllllllllIllIlIllIIlllllIlII;
        entityItem2.motionY += lllllllllllllIllIlIllIIlllllIIlI.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllIlIllIIllllllIlI;
        final EntityItem entityItem3 = lllllllllllllIllIlIllIIlllllIlII;
        entityItem3.motionZ += lllllllllllllIllIlIllIIlllllIIlI.rand.nextGaussian() * 0.007499999832361937 * lllllllllllllIllIlIllIIllllllIlI;
        lllllllllllllIllIlIllIIlllllIIlI.spawnEntityInWorld(lllllllllllllIllIlIllIIlllllIlII);
    }
    
    protected void playDispenseSound(final IBlockSource lllllllllllllIllIlIllIIllllIIlIl) {
        lllllllllllllIllIlIllIIllllIIlIl.getWorld().playEvent(1000, lllllllllllllIllIlIllIIllllIIlIl.getBlockPos(), 0);
    }
}
