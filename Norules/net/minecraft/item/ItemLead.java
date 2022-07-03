package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class ItemLead extends Item
{
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lIllIllllIIlII, final World lIllIllllIIIll, final BlockPos lIllIllllIlIll, final EnumHand lIllIllllIlIlI, final EnumFacing lIllIllllIlIIl, final float lIllIllllIlIII, final float lIllIllllIIlll, final float lIllIllllIIllI) {
        final Block lIllIllllIIlIl = lIllIllllIIIll.getBlockState(lIllIllllIlIll).getBlock();
        if (!(lIllIllllIIlIl instanceof BlockFence)) {
            return EnumActionResult.PASS;
        }
        if (!lIllIllllIIIll.isRemote) {
            attachToFence(lIllIllllIIlII, lIllIllllIIIll, lIllIllllIlIll);
        }
        return EnumActionResult.SUCCESS;
    }
    
    public ItemLead() {
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
    
    public static boolean attachToFence(final EntityPlayer lIllIlllIlIlIl, final World lIllIlllIIlIlI, final BlockPos lIllIlllIIlIIl) {
        EntityLeashKnot lIllIlllIlIIlI = EntityLeashKnot.getKnotForPosition(lIllIlllIIlIlI, lIllIlllIIlIIl);
        boolean lIllIlllIlIIIl = false;
        final double lIllIlllIlIIII = 7.0;
        final int lIllIlllIIllll = lIllIlllIIlIIl.getX();
        final int lIllIlllIIlllI = lIllIlllIIlIIl.getY();
        final int lIllIlllIIllIl = lIllIlllIIlIIl.getZ();
        for (final EntityLiving lIllIlllIIllII : lIllIlllIIlIlI.getEntitiesWithinAABB((Class<? extends Entity>)EntityLiving.class, new AxisAlignedBB(lIllIlllIIllll - 7.0, lIllIlllIIlllI - 7.0, lIllIlllIIllIl - 7.0, lIllIlllIIllll + 7.0, lIllIlllIIlllI + 7.0, lIllIlllIIllIl + 7.0))) {
            if (lIllIlllIIllII.getLeashed() && lIllIlllIIllII.getLeashedToEntity() == lIllIlllIlIlIl) {
                if (lIllIlllIlIIlI == null) {
                    lIllIlllIlIIlI = EntityLeashKnot.createKnot(lIllIlllIIlIlI, lIllIlllIIlIIl);
                }
                lIllIlllIIllII.setLeashedToEntity(lIllIlllIlIIlI, true);
                lIllIlllIlIIIl = true;
            }
        }
        return lIllIlllIlIIIl;
    }
}
