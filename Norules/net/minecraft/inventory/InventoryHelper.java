package net.minecraft.inventory;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.entity.item.*;

public class InventoryHelper
{
    private static final /* synthetic */ Random RANDOM;
    
    public static void dropInventoryItems(final World lllllllllllllIlIIIlIIllIIIIIllII, final Entity lllllllllllllIlIIIlIIllIIIIIlIll, final IInventory lllllllllllllIlIIIlIIllIIIIIIlll) {
        dropInventoryItems(lllllllllllllIlIIIlIIllIIIIIllII, lllllllllllllIlIIIlIIllIIIIIlIll.posX, lllllllllllllIlIIIlIIllIIIIIlIll.posY, lllllllllllllIlIIIlIIllIIIIIlIll.posZ, lllllllllllllIlIIIlIIllIIIIIIlll);
    }
    
    public static void dropInventoryItems(final World lllllllllllllIlIIIlIIllIIIIlIlIl, final BlockPos lllllllllllllIlIIIlIIllIIIIlIlII, final IInventory lllllllllllllIlIIIlIIllIIIIlIIll) {
        dropInventoryItems(lllllllllllllIlIIIlIIllIIIIlIlIl, lllllllllllllIlIIIlIIllIIIIlIlII.getX(), lllllllllllllIlIIIlIIllIIIIlIlII.getY(), lllllllllllllIlIIIlIIllIIIIlIlII.getZ(), lllllllllllllIlIIIlIIllIIIIlIIll);
    }
    
    public static void spawnItemStack(final World lllllllllllllIlIIIlIIlIllllIIlll, final double lllllllllllllIlIIIlIIlIlllIlllII, final double lllllllllllllIlIIIlIIlIlllIllIll, final double lllllllllllllIlIIIlIIlIlllIllIlI, final ItemStack lllllllllllllIlIIIlIIlIlllIllIIl) {
        final float lllllllllllllIlIIIlIIlIllllIIIlI = InventoryHelper.RANDOM.nextFloat() * 0.8f + 0.1f;
        final float lllllllllllllIlIIIlIIlIllllIIIIl = InventoryHelper.RANDOM.nextFloat() * 0.8f + 0.1f;
        final float lllllllllllllIlIIIlIIlIllllIIIII = InventoryHelper.RANDOM.nextFloat() * 0.8f + 0.1f;
        while (!lllllllllllllIlIIIlIIlIlllIllIIl.func_190926_b()) {
            final EntityItem lllllllllllllIlIIIlIIlIlllIlllll = new EntityItem(lllllllllllllIlIIIlIIlIllllIIlll, lllllllllllllIlIIIlIIlIlllIlllII + lllllllllllllIlIIIlIIlIllllIIIlI, lllllllllllllIlIIIlIIlIlllIllIll + lllllllllllllIlIIIlIIlIllllIIIIl, lllllllllllllIlIIIlIIlIlllIllIlI + lllllllllllllIlIIIlIIlIllllIIIII, lllllllllllllIlIIIlIIlIlllIllIIl.splitStack(InventoryHelper.RANDOM.nextInt(21) + 10));
            final float lllllllllllllIlIIIlIIlIlllIllllI = 0.05f;
            lllllllllllllIlIIIlIIlIlllIlllll.motionX = InventoryHelper.RANDOM.nextGaussian() * 0.05000000074505806;
            lllllllllllllIlIIIlIIlIlllIlllll.motionY = InventoryHelper.RANDOM.nextGaussian() * 0.05000000074505806 + 0.20000000298023224;
            lllllllllllllIlIIIlIIlIlllIlllll.motionZ = InventoryHelper.RANDOM.nextGaussian() * 0.05000000074505806;
            lllllllllllllIlIIIlIIlIllllIIlll.spawnEntityInWorld(lllllllllllllIlIIIlIIlIlllIlllll);
        }
    }
    
    private static void dropInventoryItems(final World lllllllllllllIlIIIlIIlIllllllIII, final double lllllllllllllIlIIIlIIlIllllllllI, final double lllllllllllllIlIIIlIIlIlllllIllI, final double lllllllllllllIlIIIlIIlIlllllIlIl, final IInventory lllllllllllllIlIIIlIIlIlllllIlII) {
        for (int lllllllllllllIlIIIlIIlIllllllIlI = 0; lllllllllllllIlIIIlIIlIllllllIlI < lllllllllllllIlIIIlIIlIlllllIlII.getSizeInventory(); ++lllllllllllllIlIIIlIIlIllllllIlI) {
            final ItemStack lllllllllllllIlIIIlIIlIllllllIIl = lllllllllllllIlIIIlIIlIlllllIlII.getStackInSlot(lllllllllllllIlIIIlIIlIllllllIlI);
            if (!lllllllllllllIlIIIlIIlIllllllIIl.func_190926_b()) {
                spawnItemStack(lllllllllllllIlIIIlIIlIllllllIII, lllllllllllllIlIIIlIIlIllllllllI, lllllllllllllIlIIIlIIlIlllllIllI, lllllllllllllIlIIIlIIlIlllllIlIl, lllllllllllllIlIIIlIIlIllllllIIl);
            }
        }
    }
    
    static {
        RANDOM = new Random();
    }
}
