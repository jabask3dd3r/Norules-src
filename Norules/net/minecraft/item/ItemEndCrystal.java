package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.world.end.*;

public class ItemEndCrystal extends Item
{
    public ItemEndCrystal() {
        this.setUnlocalizedName("end_crystal");
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIIllllIlIlIIIIIIIlI, final World lllllllllllllIIllllIlIlIIIIlIlII, final BlockPos lllllllllllllIIllllIlIlIIIIIIIII, final EnumHand lllllllllllllIIllllIlIIlllllllll, final EnumFacing lllllllllllllIIllllIlIIllllllllI, final float lllllllllllllIIllllIlIlIIIIlIIII, final float lllllllllllllIIllllIlIlIIIIIllll, final float lllllllllllllIIllllIlIlIIIIIlllI) {
        final IBlockState lllllllllllllIIllllIlIlIIIIIllIl = lllllllllllllIIllllIlIlIIIIlIlII.getBlockState(lllllllllllllIIllllIlIlIIIIIIIII);
        if (lllllllllllllIIllllIlIlIIIIIllIl.getBlock() != Blocks.OBSIDIAN && lllllllllllllIIllllIlIlIIIIIllIl.getBlock() != Blocks.BEDROCK) {
            return EnumActionResult.FAIL;
        }
        final BlockPos lllllllllllllIIllllIlIlIIIIIllII = lllllllllllllIIllllIlIlIIIIIIIII.up();
        final ItemStack lllllllllllllIIllllIlIlIIIIIlIll = lllllllllllllIIllllIlIlIIIIIIIlI.getHeldItem(lllllllllllllIIllllIlIIlllllllll);
        if (!lllllllllllllIIllllIlIlIIIIIIIlI.canPlayerEdit(lllllllllllllIIllllIlIlIIIIIllII, lllllllllllllIIllllIlIIllllllllI, lllllllllllllIIllllIlIlIIIIIlIll)) {
            return EnumActionResult.FAIL;
        }
        final BlockPos lllllllllllllIIllllIlIlIIIIIlIlI = lllllllllllllIIllllIlIlIIIIIllII.up();
        boolean lllllllllllllIIllllIlIlIIIIIlIIl = !lllllllllllllIIllllIlIlIIIIlIlII.isAirBlock(lllllllllllllIIllllIlIlIIIIIllII) && !lllllllllllllIIllllIlIlIIIIlIlII.getBlockState(lllllllllllllIIllllIlIlIIIIIllII).getBlock().isReplaceable(lllllllllllllIIllllIlIlIIIIlIlII, lllllllllllllIIllllIlIlIIIIIllII);
        lllllllllllllIIllllIlIlIIIIIlIIl |= (!lllllllllllllIIllllIlIlIIIIlIlII.isAirBlock(lllllllllllllIIllllIlIlIIIIIlIlI) && !lllllllllllllIIllllIlIlIIIIlIlII.getBlockState(lllllllllllllIIllllIlIlIIIIIlIlI).getBlock().isReplaceable(lllllllllllllIIllllIlIlIIIIlIlII, lllllllllllllIIllllIlIlIIIIIlIlI));
        if (lllllllllllllIIllllIlIlIIIIIlIIl) {
            return EnumActionResult.FAIL;
        }
        final double lllllllllllllIIllllIlIlIIIIIlIII = lllllllllllllIIllllIlIlIIIIIllII.getX();
        final double lllllllllllllIIllllIlIlIIIIIIlll = lllllllllllllIIllllIlIlIIIIIllII.getY();
        final double lllllllllllllIIllllIlIlIIIIIIllI = lllllllllllllIIllllIlIlIIIIIllII.getZ();
        final List<Entity> lllllllllllllIIllllIlIlIIIIIIlIl = lllllllllllllIIllllIlIlIIIIlIlII.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(lllllllllllllIIllllIlIlIIIIIlIII, lllllllllllllIIllllIlIlIIIIIIlll, lllllllllllllIIllllIlIlIIIIIIllI, lllllllllllllIIllllIlIlIIIIIlIII + 1.0, lllllllllllllIIllllIlIlIIIIIIlll + 2.0, lllllllllllllIIllllIlIlIIIIIIllI + 1.0));
        if (!lllllllllllllIIllllIlIlIIIIIIlIl.isEmpty()) {
            return EnumActionResult.FAIL;
        }
        if (!lllllllllllllIIllllIlIlIIIIlIlII.isRemote) {
            final EntityEnderCrystal lllllllllllllIIllllIlIlIIIIIIlII = new EntityEnderCrystal(lllllllllllllIIllllIlIlIIIIlIlII, lllllllllllllIIllllIlIlIIIIIIIII.getX() + 0.5f, lllllllllllllIIllllIlIlIIIIIIIII.getY() + 1, lllllllllllllIIllllIlIlIIIIIIIII.getZ() + 0.5f);
            lllllllllllllIIllllIlIlIIIIIIlII.setShowBottom(false);
            lllllllllllllIIllllIlIlIIIIlIlII.spawnEntityInWorld(lllllllllllllIIllllIlIlIIIIIIlII);
            if (lllllllllllllIIllllIlIlIIIIlIlII.provider instanceof WorldProviderEnd) {
                final DragonFightManager lllllllllllllIIllllIlIlIIIIIIIll = ((WorldProviderEnd)lllllllllllllIIllllIlIlIIIIlIlII.provider).getDragonFightManager();
                lllllllllllllIIllllIlIlIIIIIIIll.respawnDragon();
            }
        }
        lllllllllllllIIllllIlIlIIIIIlIll.func_190918_g(1);
        return EnumActionResult.SUCCESS;
    }
    
    @Override
    public boolean hasEffect(final ItemStack lllllllllllllIIllllIlIIlllllIIIl) {
        return true;
    }
}
