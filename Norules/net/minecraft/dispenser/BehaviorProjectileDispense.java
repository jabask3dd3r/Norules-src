package net.minecraft.dispenser;

import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;

public abstract class BehaviorProjectileDispense extends BehaviorDefaultDispenseItem
{
    protected abstract IProjectile getProjectileEntity(final World p0, final IPosition p1, final ItemStack p2);
    
    protected float getProjectileVelocity() {
        return 1.1f;
    }
    
    @Override
    protected void playDispenseSound(final IBlockSource lllllllllllllIIlIlIlIIlIllIIlIlI) {
        lllllllllllllIIlIlIlIIlIllIIlIlI.getWorld().playEvent(1002, lllllllllllllIIlIlIlIIlIllIIlIlI.getBlockPos(), 0);
    }
    
    protected float getProjectileInaccuracy() {
        return 6.0f;
    }
    
    public ItemStack dispenseStack(final IBlockSource lllllllllllllIIlIlIlIIlIllIllIlI, final ItemStack lllllllllllllIIlIlIlIIlIllIllIIl) {
        final World lllllllllllllIIlIlIlIIlIllIllIII = lllllllllllllIIlIlIlIIlIllIllIlI.getWorld();
        final IPosition lllllllllllllIIlIlIlIIlIllIlIlll = BlockDispenser.getDispensePosition(lllllllllllllIIlIlIlIIlIllIllIlI);
        final EnumFacing lllllllllllllIIlIlIlIIlIllIlIllI = lllllllllllllIIlIlIlIIlIllIllIlI.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
        final IProjectile lllllllllllllIIlIlIlIIlIllIlIlIl = this.getProjectileEntity(lllllllllllllIIlIlIlIIlIllIllIII, lllllllllllllIIlIlIlIIlIllIlIlll, lllllllllllllIIlIlIlIIlIllIllIIl);
        lllllllllllllIIlIlIlIIlIllIlIlIl.setThrowableHeading(lllllllllllllIIlIlIlIIlIllIlIllI.getFrontOffsetX(), lllllllllllllIIlIlIlIIlIllIlIllI.getFrontOffsetY() + 0.1f, lllllllllllllIIlIlIlIIlIllIlIllI.getFrontOffsetZ(), this.getProjectileVelocity(), this.getProjectileInaccuracy());
        lllllllllllllIIlIlIlIIlIllIllIII.spawnEntityInWorld((Entity)lllllllllllllIIlIlIlIIlIllIlIlIl);
        lllllllllllllIIlIlIlIIlIllIllIIl.func_190918_g(1);
        return lllllllllllllIIlIlIlIIlIllIllIIl;
    }
}
