package net.minecraft.enchantment;

import net.minecraft.inventory.*;
import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;

public class EnchantmentFrostWalker extends Enchantment
{
    @Override
    public int getMaxLevel() {
        return 2;
    }
    
    public boolean canApplyTogether(final Enchantment lllllllllllllIlIlIIIlIllllllIIll) {
        return super.canApplyTogether(lllllllllllllIlIlIIIlIllllllIIll) && lllllllllllllIlIlIIIlIllllllIIll != Enchantments.DEPTH_STRIDER;
    }
    
    @Override
    public int getMinEnchantability(final int lllllllllllllIlIlIIIllIIIIIllllI) {
        return lllllllllllllIlIlIIIllIIIIIllllI * 10;
    }
    
    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }
    
    @Override
    public int getMaxEnchantability(final int lllllllllllllIlIlIIIllIIIIIllIlI) {
        return this.getMinEnchantability(lllllllllllllIlIlIIIllIIIIIllIlI) + 15;
    }
    
    public EnchantmentFrostWalker(final Rarity lllllllllllllIlIlIIIllIIIIlIIIll, final EntityEquipmentSlot... lllllllllllllIlIlIIIllIIIIlIIlIl) {
        super(lllllllllllllIlIlIIIllIIIIlIIIll, EnumEnchantmentType.ARMOR_FEET, lllllllllllllIlIlIIIllIIIIlIIlIl);
        this.setName("frostWalker");
    }
    
    public static void freezeNearby(final EntityLivingBase lllllllllllllIlIlIIIllIIIIIIIIlI, final World lllllllllllllIlIlIIIllIIIIIIIIIl, final BlockPos lllllllllllllIlIlIIIllIIIIIIlIIl, final int lllllllllllllIlIlIIIlIllllllllll) {
        if (lllllllllllllIlIlIIIllIIIIIIIIlI.onGround) {
            final float lllllllllllllIlIlIIIllIIIIIIIlll = (float)Math.min(16, 2 + lllllllllllllIlIlIIIlIllllllllll);
            final BlockPos.MutableBlockPos lllllllllllllIlIlIIIllIIIIIIIllI = new BlockPos.MutableBlockPos(0, 0, 0);
            for (final BlockPos.MutableBlockPos lllllllllllllIlIlIIIllIIIIIIIlIl : BlockPos.getAllInBoxMutable(lllllllllllllIlIlIIIllIIIIIIlIIl.add(-lllllllllllllIlIlIIIllIIIIIIIlll, -1.0, -lllllllllllllIlIlIIIllIIIIIIIlll), lllllllllllllIlIlIIIllIIIIIIlIIl.add(lllllllllllllIlIlIIIllIIIIIIIlll, -1.0, lllllllllllllIlIlIIIllIIIIIIIlll))) {
                if (lllllllllllllIlIlIIIllIIIIIIIlIl.distanceSqToCenter(lllllllllllllIlIlIIIllIIIIIIIIlI.posX, lllllllllllllIlIlIIIllIIIIIIIIlI.posY, lllllllllllllIlIlIIIllIIIIIIIIlI.posZ) <= lllllllllllllIlIlIIIllIIIIIIIlll * lllllllllllllIlIlIIIllIIIIIIIlll) {
                    lllllllllllllIlIlIIIllIIIIIIIllI.setPos(lllllllllllllIlIlIIIllIIIIIIIlIl.getX(), lllllllllllllIlIlIIIllIIIIIIIlIl.getY() + 1, lllllllllllllIlIlIIIllIIIIIIIlIl.getZ());
                    final IBlockState lllllllllllllIlIlIIIllIIIIIIIlII = lllllllllllllIlIlIIIllIIIIIIIIIl.getBlockState(lllllllllllllIlIlIIIllIIIIIIIllI);
                    if (lllllllllllllIlIlIIIllIIIIIIIlII.getMaterial() != Material.AIR) {
                        continue;
                    }
                    final IBlockState lllllllllllllIlIlIIIllIIIIIIIIll = lllllllllllllIlIlIIIllIIIIIIIIIl.getBlockState(lllllllllllllIlIlIIIllIIIIIIIlIl);
                    if (lllllllllllllIlIlIIIllIIIIIIIIll.getMaterial() != Material.WATER || lllllllllllllIlIlIIIllIIIIIIIIll.getValue((IProperty<Integer>)BlockLiquid.LEVEL) != 0 || !lllllllllllllIlIlIIIllIIIIIIIIIl.func_190527_a(Blocks.FROSTED_ICE, lllllllllllllIlIlIIIllIIIIIIIlIl, false, EnumFacing.DOWN, null)) {
                        continue;
                    }
                    lllllllllllllIlIlIIIllIIIIIIIIIl.setBlockState(lllllllllllllIlIlIIIllIIIIIIIlIl, Blocks.FROSTED_ICE.getDefaultState());
                    lllllllllllllIlIlIIIllIIIIIIIIIl.scheduleUpdate(lllllllllllllIlIlIIIllIIIIIIIlIl.toImmutable(), Blocks.FROSTED_ICE, MathHelper.getInt(lllllllllllllIlIlIIIllIIIIIIIIlI.getRNG(), 60, 120));
                }
            }
        }
    }
}
