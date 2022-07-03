package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.passive.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class ItemDye extends Item
{
    @Override
    public void getSubItems(final CreativeTabs llllllllllllllllIIlIllIIIIIIIIII, final NonNullList<ItemStack> llllllllllllllllIIlIlIlllllllIll) {
        if (this.func_194125_a(llllllllllllllllIIlIllIIIIIIIIII)) {
            for (int llllllllllllllllIIlIlIlllllllllI = 0; llllllllllllllllIIlIlIlllllllllI < 16; ++llllllllllllllllIIlIlIlllllllllI) {
                llllllllllllllllIIlIlIlllllllIll.add(new ItemStack(this, 1, llllllllllllllllIIlIlIlllllllllI));
            }
        }
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer llllllllllllllllIIlIllIIIlIIllII, final World llllllllllllllllIIlIllIIIllIIIII, BlockPos llllllllllllllllIIlIllIIIlIIlIII, final EnumHand llllllllllllllllIIlIllIIIlIIIllI, final EnumFacing llllllllllllllllIIlIllIIIlIIIlII, final float llllllllllllllllIIlIllIIIlIllIIl, final float llllllllllllllllIIlIllIIIlIllIII, final float llllllllllllllllIIlIllIIIlIIIIIl) {
        final ItemStack llllllllllllllllIIlIllIIIlIlIllI = llllllllllllllllIIlIllIIIlIIllII.getHeldItem(llllllllllllllllIIlIllIIIlIIIllI);
        if (!llllllllllllllllIIlIllIIIlIIllII.canPlayerEdit(llllllllllllllllIIlIllIIIlIIlIII.offset(llllllllllllllllIIlIllIIIlIIIlII), llllllllllllllllIIlIllIIIlIIIlII, llllllllllllllllIIlIllIIIlIlIllI)) {
            return EnumActionResult.FAIL;
        }
        final EnumDyeColor llllllllllllllllIIlIllIIIlIlIlII = EnumDyeColor.byDyeDamage(llllllllllllllllIIlIllIIIlIlIllI.getMetadata());
        if (llllllllllllllllIIlIllIIIlIlIlII == EnumDyeColor.WHITE) {
            if (applyBonemeal(llllllllllllllllIIlIllIIIlIlIllI, llllllllllllllllIIlIllIIIllIIIII, llllllllllllllllIIlIllIIIlIIlIII)) {
                if (!llllllllllllllllIIlIllIIIllIIIII.isRemote) {
                    llllllllllllllllIIlIllIIIllIIIII.playEvent(2005, llllllllllllllllIIlIllIIIlIIlIII, 0);
                }
                return EnumActionResult.SUCCESS;
            }
        }
        else if (llllllllllllllllIIlIllIIIlIlIlII == EnumDyeColor.BROWN) {
            final IBlockState llllllllllllllllIIlIllIIIlIlIIlI = llllllllllllllllIIlIllIIIllIIIII.getBlockState(llllllllllllllllIIlIllIIIlIIlIII);
            final Block llllllllllllllllIIlIllIIIlIlIIII = llllllllllllllllIIlIllIIIlIlIIlI.getBlock();
            if (llllllllllllllllIIlIllIIIlIlIIII == Blocks.LOG && llllllllllllllllIIlIllIIIlIlIIlI.getValue(BlockOldLog.VARIANT) == BlockPlanks.EnumType.JUNGLE) {
                if (llllllllllllllllIIlIllIIIlIIIlII == EnumFacing.DOWN || llllllllllllllllIIlIllIIIlIIIlII == EnumFacing.UP) {
                    return EnumActionResult.FAIL;
                }
                llllllllllllllllIIlIllIIIlIIlIII = llllllllllllllllIIlIllIIIlIIlIII.offset(llllllllllllllllIIlIllIIIlIIIlII);
                if (llllllllllllllllIIlIllIIIllIIIII.isAirBlock(llllllllllllllllIIlIllIIIlIIlIII)) {
                    final IBlockState llllllllllllllllIIlIllIIIlIIlllI = Blocks.COCOA.onBlockPlaced(llllllllllllllllIIlIllIIIllIIIII, llllllllllllllllIIlIllIIIlIIlIII, llllllllllllllllIIlIllIIIlIIIlII, llllllllllllllllIIlIllIIIlIllIIl, llllllllllllllllIIlIllIIIlIllIII, llllllllllllllllIIlIllIIIlIIIIIl, 0, llllllllllllllllIIlIllIIIlIIllII);
                    llllllllllllllllIIlIllIIIllIIIII.setBlockState(llllllllllllllllIIlIllIIIlIIlIII, llllllllllllllllIIlIllIIIlIIlllI, 10);
                    if (!llllllllllllllllIIlIllIIIlIIllII.capabilities.isCreativeMode) {
                        llllllllllllllllIIlIllIIIlIlIllI.func_190918_g(1);
                    }
                    return EnumActionResult.SUCCESS;
                }
            }
            return EnumActionResult.FAIL;
        }
        return EnumActionResult.PASS;
    }
    
    @Override
    public boolean itemInteractionForEntity(final ItemStack llllllllllllllllIIlIllIIIIIIlIIl, final EntityPlayer llllllllllllllllIIlIllIIIIIIlllI, final EntityLivingBase llllllllllllllllIIlIllIIIIIIlIII, final EnumHand llllllllllllllllIIlIllIIIIIIllII) {
        if (llllllllllllllllIIlIllIIIIIIlIII instanceof EntitySheep) {
            final EntitySheep llllllllllllllllIIlIllIIIIIIlIll = (EntitySheep)llllllllllllllllIIlIllIIIIIIlIII;
            final EnumDyeColor llllllllllllllllIIlIllIIIIIIlIlI = EnumDyeColor.byDyeDamage(llllllllllllllllIIlIllIIIIIIlIIl.getMetadata());
            if (!llllllllllllllllIIlIllIIIIIIlIll.getSheared() && llllllllllllllllIIlIllIIIIIIlIll.getFleeceColor() != llllllllllllllllIIlIllIIIIIIlIlI) {
                llllllllllllllllIIlIllIIIIIIlIll.setFleeceColor(llllllllllllllllIIlIllIIIIIIlIlI);
                llllllllllllllllIIlIllIIIIIIlIIl.func_190918_g(1);
            }
            return true;
        }
        return false;
    }
    
    public ItemDye() {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(CreativeTabs.MATERIALS);
    }
    
    public static boolean applyBonemeal(final ItemStack llllllllllllllllIIlIllIIIIllIllI, final World llllllllllllllllIIlIllIIIIllIlIl, final BlockPos llllllllllllllllIIlIllIIIIllIlII) {
        final IBlockState llllllllllllllllIIlIllIIIIllIIll = llllllllllllllllIIlIllIIIIllIlIl.getBlockState(llllllllllllllllIIlIllIIIIllIlII);
        if (llllllllllllllllIIlIllIIIIllIIll.getBlock() instanceof IGrowable) {
            final IGrowable llllllllllllllllIIlIllIIIIllIIlI = (IGrowable)llllllllllllllllIIlIllIIIIllIIll.getBlock();
            if (llllllllllllllllIIlIllIIIIllIIlI.canGrow(llllllllllllllllIIlIllIIIIllIlIl, llllllllllllllllIIlIllIIIIllIlII, llllllllllllllllIIlIllIIIIllIIll, llllllllllllllllIIlIllIIIIllIlIl.isRemote)) {
                if (!llllllllllllllllIIlIllIIIIllIlIl.isRemote) {
                    if (llllllllllllllllIIlIllIIIIllIIlI.canUseBonemeal(llllllllllllllllIIlIllIIIIllIlIl, llllllllllllllllIIlIllIIIIllIlIl.rand, llllllllllllllllIIlIllIIIIllIlII, llllllllllllllllIIlIllIIIIllIIll)) {
                        llllllllllllllllIIlIllIIIIllIIlI.grow(llllllllllllllllIIlIllIIIIllIlIl, llllllllllllllllIIlIllIIIIllIlIl.rand, llllllllllllllllIIlIllIIIIllIlII, llllllllllllllllIIlIllIIIIllIIll);
                    }
                    llllllllllllllllIIlIllIIIIllIllI.func_190918_g(1);
                }
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String getUnlocalizedName(final ItemStack llllllllllllllllIIlIllIIIlllIlll) {
        final int llllllllllllllllIIlIllIIIllllIIl = llllllllllllllllIIlIllIIIlllIlll.getMetadata();
        return String.valueOf(new StringBuilder(String.valueOf(super.getUnlocalizedName())).append(".").append(EnumDyeColor.byDyeDamage(llllllllllllllllIIlIllIIIllllIIl).getUnlocalizedName()));
    }
    
    public static void spawnBonemealParticles(final World llllllllllllllllIIlIllIIIIlIIlII, final BlockPos llllllllllllllllIIlIllIIIIlIIIll, int llllllllllllllllIIlIllIIIIIllIlI) {
        if (llllllllllllllllIIlIllIIIIIllIlI == 0) {
            llllllllllllllllIIlIllIIIIIllIlI = 15;
        }
        final IBlockState llllllllllllllllIIlIllIIIIlIIIIl = llllllllllllllllIIlIllIIIIlIIlII.getBlockState(llllllllllllllllIIlIllIIIIlIIIll);
        if (llllllllllllllllIIlIllIIIIlIIIIl.getMaterial() != Material.AIR) {
            for (int llllllllllllllllIIlIllIIIIlIIIII = 0; llllllllllllllllIIlIllIIIIlIIIII < llllllllllllllllIIlIllIIIIIllIlI; ++llllllllllllllllIIlIllIIIIlIIIII) {
                final double llllllllllllllllIIlIllIIIIIlllll = ItemDye.itemRand.nextGaussian() * 0.02;
                final double llllllllllllllllIIlIllIIIIIllllI = ItemDye.itemRand.nextGaussian() * 0.02;
                final double llllllllllllllllIIlIllIIIIIlllIl = ItemDye.itemRand.nextGaussian() * 0.02;
                llllllllllllllllIIlIllIIIIlIIlII.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, llllllllllllllllIIlIllIIIIlIIIll.getX() + ItemDye.itemRand.nextFloat(), llllllllllllllllIIlIllIIIIlIIIll.getY() + ItemDye.itemRand.nextFloat() * llllllllllllllllIIlIllIIIIlIIIIl.getBoundingBox(llllllllllllllllIIlIllIIIIlIIlII, llllllllllllllllIIlIllIIIIlIIIll).maxY, llllllllllllllllIIlIllIIIIlIIIll.getZ() + ItemDye.itemRand.nextFloat(), llllllllllllllllIIlIllIIIIIlllll, llllllllllllllllIIlIllIIIIIllllI, llllllllllllllllIIlIllIIIIIlllIl, new int[0]);
            }
        }
    }
    
    static {
        DYE_COLORS = new int[] { 1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320 };
    }
}
