package net.minecraft.item;

import net.minecraft.block.material.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.util.*;
import net.minecraft.creativetab.*;

public class ItemBucket extends Item
{
    private final /* synthetic */ Block containedBlock;
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllllIIlllIIIlIIIIllIl, final EntityPlayer lllllllllllllllIIlllIIIlIIIIIIII, final EnumHand lllllllllllllllIIlllIIIIllllllll) {
        final boolean lllllllllllllllIIlllIIIlIIIIlIlI = this.containedBlock == Blocks.AIR;
        final ItemStack lllllllllllllllIIlllIIIlIIIIlIIl = lllllllllllllllIIlllIIIlIIIIIIII.getHeldItem(lllllllllllllllIIlllIIIIllllllll);
        final RayTraceResult lllllllllllllllIIlllIIIlIIIIlIII = this.rayTrace(lllllllllllllllIIlllIIIlIIIIllIl, lllllllllllllllIIlllIIIlIIIIIIII, lllllllllllllllIIlllIIIlIIIIlIlI);
        if (lllllllllllllllIIlllIIIlIIIIlIII == null) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllllIIlllIIIlIIIIlIIl);
        }
        if (lllllllllllllllIIlllIIIlIIIIlIII.typeOfHit != RayTraceResult.Type.BLOCK) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllllIIlllIIIlIIIIlIIl);
        }
        final BlockPos lllllllllllllllIIlllIIIlIIIIIlll = lllllllllllllllIIlllIIIlIIIIlIII.getBlockPos();
        if (!lllllllllllllllIIlllIIIlIIIIllIl.isBlockModifiable(lllllllllllllllIIlllIIIlIIIIIIII, lllllllllllllllIIlllIIIlIIIIIlll)) {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllllIIlllIIIlIIIIlIIl);
        }
        if (lllllllllllllllIIlllIIIlIIIIlIlI) {
            if (!lllllllllllllllIIlllIIIlIIIIIIII.canPlayerEdit(lllllllllllllllIIlllIIIlIIIIIlll.offset(lllllllllllllllIIlllIIIlIIIIlIII.sideHit), lllllllllllllllIIlllIIIlIIIIlIII.sideHit, lllllllllllllllIIlllIIIlIIIIlIIl)) {
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllllIIlllIIIlIIIIlIIl);
            }
            final IBlockState lllllllllllllllIIlllIIIlIIIIIllI = lllllllllllllllIIlllIIIlIIIIllIl.getBlockState(lllllllllllllllIIlllIIIlIIIIIlll);
            final Material lllllllllllllllIIlllIIIlIIIIIlIl = lllllllllllllllIIlllIIIlIIIIIllI.getMaterial();
            if (lllllllllllllllIIlllIIIlIIIIIlIl == Material.WATER && lllllllllllllllIIlllIIIlIIIIIllI.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0) {
                lllllllllllllllIIlllIIIlIIIIllIl.setBlockState(lllllllllllllllIIlllIIIlIIIIIlll, Blocks.AIR.getDefaultState(), 11);
                lllllllllllllllIIlllIIIlIIIIIIII.addStat(StatList.getObjectUseStats(this));
                lllllllllllllllIIlllIIIlIIIIIIII.playSound(SoundEvents.ITEM_BUCKET_FILL, 1.0f, 1.0f);
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.fillBucket(lllllllllllllllIIlllIIIlIIIIlIIl, lllllllllllllllIIlllIIIlIIIIIIII, Items.WATER_BUCKET));
            }
            if (lllllllllllllllIIlllIIIlIIIIIlIl == Material.LAVA && lllllllllllllllIIlllIIIlIIIIIllI.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0) {
                lllllllllllllllIIlllIIIlIIIIIIII.playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA, 1.0f, 1.0f);
                lllllllllllllllIIlllIIIlIIIIllIl.setBlockState(lllllllllllllllIIlllIIIlIIIIIlll, Blocks.AIR.getDefaultState(), 11);
                lllllllllllllllIIlllIIIlIIIIIIII.addStat(StatList.getObjectUseStats(this));
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, this.fillBucket(lllllllllllllllIIlllIIIlIIIIlIIl, lllllllllllllllIIlllIIIlIIIIIIII, Items.LAVA_BUCKET));
            }
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllllIIlllIIIlIIIIlIIl);
        }
        else {
            final boolean lllllllllllllllIIlllIIIlIIIIIlII = lllllllllllllllIIlllIIIlIIIIllIl.getBlockState(lllllllllllllllIIlllIIIlIIIIIlll).getBlock().isReplaceable(lllllllllllllllIIlllIIIlIIIIllIl, lllllllllllllllIIlllIIIlIIIIIlll);
            final BlockPos lllllllllllllllIIlllIIIlIIIIIIll = (lllllllllllllllIIlllIIIlIIIIIlII && lllllllllllllllIIlllIIIlIIIIlIII.sideHit == EnumFacing.UP) ? lllllllllllllllIIlllIIIlIIIIIlll : lllllllllllllllIIlllIIIlIIIIIlll.offset(lllllllllllllllIIlllIIIlIIIIlIII.sideHit);
            if (!lllllllllllllllIIlllIIIlIIIIIIII.canPlayerEdit(lllllllllllllllIIlllIIIlIIIIIIll, lllllllllllllllIIlllIIIlIIIIlIII.sideHit, lllllllllllllllIIlllIIIlIIIIlIIl)) {
                return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllllIIlllIIIlIIIIlIIl);
            }
            if (this.tryPlaceContainedLiquid(lllllllllllllllIIlllIIIlIIIIIIII, lllllllllllllllIIlllIIIlIIIIllIl, lllllllllllllllIIlllIIIlIIIIIIll)) {
                if (lllllllllllllllIIlllIIIlIIIIIIII instanceof EntityPlayerMP) {
                    CriteriaTriggers.field_193137_x.func_193173_a((EntityPlayerMP)lllllllllllllllIIlllIIIlIIIIIIII, lllllllllllllllIIlllIIIlIIIIIIll, lllllllllllllllIIlllIIIlIIIIlIIl);
                }
                lllllllllllllllIIlllIIIlIIIIIIII.addStat(StatList.getObjectUseStats(this));
                return lllllllllllllllIIlllIIIlIIIIIIII.capabilities.isCreativeMode ? new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllllIIlllIIIlIIIIlIIl) : new ActionResult<ItemStack>(EnumActionResult.SUCCESS, new ItemStack(Items.BUCKET));
            }
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, lllllllllllllllIIlllIIIlIIIIlIIl);
        }
    }
    
    public boolean tryPlaceContainedLiquid(@Nullable final EntityPlayer lllllllllllllllIIlllIIIIllIlIlII, final World lllllllllllllllIIlllIIIIllIlIIll, final BlockPos lllllllllllllllIIlllIIIIllIlllll) {
        if (this.containedBlock == Blocks.AIR) {
            return false;
        }
        final IBlockState lllllllllllllllIIlllIIIIllIllllI = lllllllllllllllIIlllIIIIllIlIIll.getBlockState(lllllllllllllllIIlllIIIIllIlllll);
        final Material lllllllllllllllIIlllIIIIllIlllIl = lllllllllllllllIIlllIIIIllIllllI.getMaterial();
        final boolean lllllllllllllllIIlllIIIIllIlllII = !lllllllllllllllIIlllIIIIllIlllIl.isSolid();
        final boolean lllllllllllllllIIlllIIIIllIllIll = lllllllllllllllIIlllIIIIllIllllI.getBlock().isReplaceable(lllllllllllllllIIlllIIIIllIlIIll, lllllllllllllllIIlllIIIIllIlllll);
        if (!lllllllllllllllIIlllIIIIllIlIIll.isAirBlock(lllllllllllllllIIlllIIIIllIlllll) && !lllllllllllllllIIlllIIIIllIlllII && !lllllllllllllllIIlllIIIIllIllIll) {
            return false;
        }
        if (lllllllllllllllIIlllIIIIllIlIIll.provider.doesWaterVaporize() && this.containedBlock == Blocks.FLOWING_WATER) {
            final int lllllllllllllllIIlllIIIIllIllIlI = lllllllllllllllIIlllIIIIllIlllll.getX();
            final int lllllllllllllllIIlllIIIIllIllIIl = lllllllllllllllIIlllIIIIllIlllll.getY();
            final int lllllllllllllllIIlllIIIIllIllIII = lllllllllllllllIIlllIIIIllIlllll.getZ();
            lllllllllllllllIIlllIIIIllIlIIll.playSound(lllllllllllllllIIlllIIIIllIlIlII, lllllllllllllllIIlllIIIIllIlllll, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 2.6f + (lllllllllllllllIIlllIIIIllIlIIll.rand.nextFloat() - lllllllllllllllIIlllIIIIllIlIIll.rand.nextFloat()) * 0.8f);
            for (int lllllllllllllllIIlllIIIIllIlIlll = 0; lllllllllllllllIIlllIIIIllIlIlll < 8; ++lllllllllllllllIIlllIIIIllIlIlll) {
                lllllllllllllllIIlllIIIIllIlIIll.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllllIIlllIIIIllIllIlI + Math.random(), lllllllllllllllIIlllIIIIllIllIIl + Math.random(), lllllllllllllllIIlllIIIIllIllIII + Math.random(), 0.0, 0.0, 0.0, new int[0]);
            }
        }
        else {
            if (!lllllllllllllllIIlllIIIIllIlIIll.isRemote && (lllllllllllllllIIlllIIIIllIlllII || lllllllllllllllIIlllIIIIllIllIll) && !lllllllllllllllIIlllIIIIllIlllIl.isLiquid()) {
                lllllllllllllllIIlllIIIIllIlIIll.destroyBlock(lllllllllllllllIIlllIIIIllIlllll, true);
            }
            final SoundEvent lllllllllllllllIIlllIIIIllIlIllI = (this.containedBlock == Blocks.FLOWING_LAVA) ? SoundEvents.ITEM_BUCKET_EMPTY_LAVA : SoundEvents.ITEM_BUCKET_EMPTY;
            lllllllllllllllIIlllIIIIllIlIIll.playSound(lllllllllllllllIIlllIIIIllIlIlII, lllllllllllllllIIlllIIIIllIlllll, lllllllllllllllIIlllIIIIllIlIllI, SoundCategory.BLOCKS, 1.0f, 1.0f);
            lllllllllllllllIIlllIIIIllIlIIll.setBlockState(lllllllllllllllIIlllIIIIllIlllll, this.containedBlock.getDefaultState(), 11);
        }
        return true;
    }
    
    private ItemStack fillBucket(final ItemStack lllllllllllllllIIlllIIIIllllIIIl, final EntityPlayer lllllllllllllllIIlllIIIIllllIIII, final Item lllllllllllllllIIlllIIIIlllIllll) {
        if (lllllllllllllllIIlllIIIIllllIIII.capabilities.isCreativeMode) {
            return lllllllllllllllIIlllIIIIllllIIIl;
        }
        lllllllllllllllIIlllIIIIllllIIIl.func_190918_g(1);
        if (lllllllllllllllIIlllIIIIllllIIIl.func_190926_b()) {
            return new ItemStack(lllllllllllllllIIlllIIIIlllIllll);
        }
        if (!lllllllllllllllIIlllIIIIllllIIII.inventory.addItemStackToInventory(new ItemStack(lllllllllllllllIIlllIIIIlllIllll))) {
            lllllllllllllllIIlllIIIIllllIIII.dropItem(new ItemStack(lllllllllllllllIIlllIIIIlllIllll), false);
        }
        return lllllllllllllllIIlllIIIIllllIIIl;
    }
    
    public ItemBucket(final Block lllllllllllllllIIlllIIIlIIIllIll) {
        this.maxStackSize = 1;
        this.containedBlock = lllllllllllllllIIlllIIIlIIIllIll;
        this.setCreativeTab(CreativeTabs.MISC);
    }
}
