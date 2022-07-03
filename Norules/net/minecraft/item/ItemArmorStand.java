package net.minecraft.item;

import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.creativetab.*;

public class ItemArmorStand extends Item
{
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIIIllIlIllIlllIlllI, final World lllllllllllllIIIllIlIllIlllIllIl, final BlockPos lllllllllllllIIIllIlIllIllIllIII, final EnumHand lllllllllllllIIIllIlIllIllIlIlll, final EnumFacing lllllllllllllIIIllIlIllIllIlIllI, final float lllllllllllllIIIllIlIllIlllIlIIl, final float lllllllllllllIIIllIlIllIlllIlIII, final float lllllllllllllIIIllIlIllIlllIIlll) {
        if (lllllllllllllIIIllIlIllIllIlIllI == EnumFacing.DOWN) {
            return EnumActionResult.FAIL;
        }
        final boolean lllllllllllllIIIllIlIllIlllIIllI = lllllllllllllIIIllIlIllIlllIllIl.getBlockState(lllllllllllllIIIllIlIllIllIllIII).getBlock().isReplaceable(lllllllllllllIIIllIlIllIlllIllIl, lllllllllllllIIIllIlIllIllIllIII);
        final BlockPos lllllllllllllIIIllIlIllIlllIIlIl = lllllllllllllIIIllIlIllIlllIIllI ? lllllllllllllIIIllIlIllIllIllIII : lllllllllllllIIIllIlIllIllIllIII.offset(lllllllllllllIIIllIlIllIllIlIllI);
        final ItemStack lllllllllllllIIIllIlIllIlllIIlII = lllllllllllllIIIllIlIllIlllIlllI.getHeldItem(lllllllllllllIIIllIlIllIllIlIlll);
        if (!lllllllllllllIIIllIlIllIlllIlllI.canPlayerEdit(lllllllllllllIIIllIlIllIlllIIlIl, lllllllllllllIIIllIlIllIllIlIllI, lllllllllllllIIIllIlIllIlllIIlII)) {
            return EnumActionResult.FAIL;
        }
        final BlockPos lllllllllllllIIIllIlIllIlllIIIll = lllllllllllllIIIllIlIllIlllIIlIl.up();
        boolean lllllllllllllIIIllIlIllIlllIIIlI = !lllllllllllllIIIllIlIllIlllIllIl.isAirBlock(lllllllllllllIIIllIlIllIlllIIlIl) && !lllllllllllllIIIllIlIllIlllIllIl.getBlockState(lllllllllllllIIIllIlIllIlllIIlIl).getBlock().isReplaceable(lllllllllllllIIIllIlIllIlllIllIl, lllllllllllllIIIllIlIllIlllIIlIl);
        lllllllllllllIIIllIlIllIlllIIIlI |= (!lllllllllllllIIIllIlIllIlllIllIl.isAirBlock(lllllllllllllIIIllIlIllIlllIIIll) && !lllllllllllllIIIllIlIllIlllIllIl.getBlockState(lllllllllllllIIIllIlIllIlllIIIll).getBlock().isReplaceable(lllllllllllllIIIllIlIllIlllIllIl, lllllllllllllIIIllIlIllIlllIIIll));
        if (lllllllllllllIIIllIlIllIlllIIIlI) {
            return EnumActionResult.FAIL;
        }
        final double lllllllllllllIIIllIlIllIlllIIIIl = lllllllllllllIIIllIlIllIlllIIlIl.getX();
        final double lllllllllllllIIIllIlIllIlllIIIII = lllllllllllllIIIllIlIllIlllIIlIl.getY();
        final double lllllllllllllIIIllIlIllIllIlllll = lllllllllllllIIIllIlIllIlllIIlIl.getZ();
        final List<Entity> lllllllllllllIIIllIlIllIllIllllI = lllllllllllllIIIllIlIllIlllIllIl.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(lllllllllllllIIIllIlIllIlllIIIIl, lllllllllllllIIIllIlIllIlllIIIII, lllllllllllllIIIllIlIllIllIlllll, lllllllllllllIIIllIlIllIlllIIIIl + 1.0, lllllllllllllIIIllIlIllIlllIIIII + 2.0, lllllllllllllIIIllIlIllIllIlllll + 1.0));
        if (!lllllllllllllIIIllIlIllIllIllllI.isEmpty()) {
            return EnumActionResult.FAIL;
        }
        if (!lllllllllllllIIIllIlIllIlllIllIl.isRemote) {
            lllllllllllllIIIllIlIllIlllIllIl.setBlockToAir(lllllllllllllIIIllIlIllIlllIIlIl);
            lllllllllllllIIIllIlIllIlllIllIl.setBlockToAir(lllllllllllllIIIllIlIllIlllIIIll);
            final EntityArmorStand lllllllllllllIIIllIlIllIllIlllIl = new EntityArmorStand(lllllllllllllIIIllIlIllIlllIllIl, lllllllllllllIIIllIlIllIlllIIIIl + 0.5, lllllllllllllIIIllIlIllIlllIIIII, lllllllllllllIIIllIlIllIllIlllll + 0.5);
            final float lllllllllllllIIIllIlIllIllIlllII = MathHelper.floor((MathHelper.wrapDegrees(lllllllllllllIIIllIlIllIlllIlllI.rotationYaw - 180.0f) + 22.5f) / 45.0f) * 45.0f;
            lllllllllllllIIIllIlIllIllIlllIl.setLocationAndAngles(lllllllllllllIIIllIlIllIlllIIIIl + 0.5, lllllllllllllIIIllIlIllIlllIIIII, lllllllllllllIIIllIlIllIllIlllll + 0.5, lllllllllllllIIIllIlIllIllIlllII, 0.0f);
            this.applyRandomRotations(lllllllllllllIIIllIlIllIllIlllIl, lllllllllllllIIIllIlIllIlllIllIl.rand);
            ItemMonsterPlacer.applyItemEntityDataToEntity(lllllllllllllIIIllIlIllIlllIllIl, lllllllllllllIIIllIlIllIlllIlllI, lllllllllllllIIIllIlIllIlllIIlII, lllllllllllllIIIllIlIllIllIlllIl);
            lllllllllllllIIIllIlIllIlllIllIl.spawnEntityInWorld(lllllllllllllIIIllIlIllIllIlllIl);
            lllllllllllllIIIllIlIllIlllIllIl.playSound(null, lllllllllllllIIIllIlIllIllIlllIl.posX, lllllllllllllIIIllIlIllIllIlllIl.posY, lllllllllllllIIIllIlIllIllIlllIl.posZ, SoundEvents.ENTITY_ARMORSTAND_PLACE, SoundCategory.BLOCKS, 0.75f, 0.8f);
        }
        lllllllllllllIIIllIlIllIlllIIlII.func_190918_g(1);
        return EnumActionResult.SUCCESS;
    }
    
    private void applyRandomRotations(final EntityArmorStand lllllllllllllIIIllIlIllIlIllllIl, final Random lllllllllllllIIIllIlIllIlIllllII) {
        Rotations lllllllllllllIIIllIlIllIllIIIIIl = lllllllllllllIIIllIlIllIlIllllIl.getHeadRotation();
        float lllllllllllllIIIllIlIllIllIIIIII = lllllllllllllIIIllIlIllIlIllllII.nextFloat() * 5.0f;
        final float lllllllllllllIIIllIlIllIlIllllll = lllllllllllllIIIllIlIllIlIllllII.nextFloat() * 20.0f - 10.0f;
        Rotations lllllllllllllIIIllIlIllIlIlllllI = new Rotations(lllllllllllllIIIllIlIllIllIIIIIl.getX() + lllllllllllllIIIllIlIllIllIIIIII, lllllllllllllIIIllIlIllIllIIIIIl.getY() + lllllllllllllIIIllIlIllIlIllllll, lllllllllllllIIIllIlIllIllIIIIIl.getZ());
        lllllllllllllIIIllIlIllIlIllllIl.setHeadRotation(lllllllllllllIIIllIlIllIlIlllllI);
        lllllllllllllIIIllIlIllIllIIIIIl = lllllllllllllIIIllIlIllIlIllllIl.getBodyRotation();
        lllllllllllllIIIllIlIllIllIIIIII = lllllllllllllIIIllIlIllIlIllllII.nextFloat() * 10.0f - 5.0f;
        lllllllllllllIIIllIlIllIlIlllllI = new Rotations(lllllllllllllIIIllIlIllIllIIIIIl.getX(), lllllllllllllIIIllIlIllIllIIIIIl.getY() + lllllllllllllIIIllIlIllIllIIIIII, lllllllllllllIIIllIlIllIllIIIIIl.getZ());
        lllllllllllllIIIllIlIllIlIllllIl.setBodyRotation(lllllllllllllIIIllIlIllIlIlllllI);
    }
    
    public ItemArmorStand() {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
