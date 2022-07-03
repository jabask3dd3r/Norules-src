package net.minecraft.item;

import net.minecraft.creativetab.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.state.pattern.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.advancements.*;
import net.minecraft.stats.*;

public class ItemEnderEye extends Item
{
    public ItemEnderEye() {
        this.setCreativeTab(CreativeTabs.MISC);
    }
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIIIIIlllIlllIlIIIlI, final World lllllllllllllIIIIIlllIlllIllIllI, final BlockPos lllllllllllllIIIIIlllIlllIllIlIl, final EnumHand lllllllllllllIIIIIlllIlllIIlllll, final EnumFacing lllllllllllllIIIIIlllIlllIIllllI, final float lllllllllllllIIIIIlllIlllIllIIlI, final float lllllllllllllIIIIIlllIlllIllIIIl, final float lllllllllllllIIIIIlllIlllIllIIII) {
        final IBlockState lllllllllllllIIIIIlllIlllIlIllll = lllllllllllllIIIIIlllIlllIllIllI.getBlockState(lllllllllllllIIIIIlllIlllIllIlIl);
        final ItemStack lllllllllllllIIIIIlllIlllIlIlllI = lllllllllllllIIIIIlllIlllIlIIIlI.getHeldItem(lllllllllllllIIIIIlllIlllIIlllll);
        if (!lllllllllllllIIIIIlllIlllIlIIIlI.canPlayerEdit(lllllllllllllIIIIIlllIlllIllIlIl.offset(lllllllllllllIIIIIlllIlllIIllllI), lllllllllllllIIIIIlllIlllIIllllI, lllllllllllllIIIIIlllIlllIlIlllI) || lllllllllllllIIIIIlllIlllIlIllll.getBlock() != Blocks.END_PORTAL_FRAME || lllllllllllllIIIIIlllIlllIlIllll.getValue((IProperty<Boolean>)BlockEndPortalFrame.EYE)) {
            return EnumActionResult.FAIL;
        }
        if (lllllllllllllIIIIIlllIlllIllIllI.isRemote) {
            return EnumActionResult.SUCCESS;
        }
        lllllllllllllIIIIIlllIlllIllIllI.setBlockState(lllllllllllllIIIIIlllIlllIllIlIl, lllllllllllllIIIIIlllIlllIlIllll.withProperty((IProperty<Comparable>)BlockEndPortalFrame.EYE, true), 2);
        lllllllllllllIIIIIlllIlllIllIllI.updateComparatorOutputLevel(lllllllllllllIIIIIlllIlllIllIlIl, Blocks.END_PORTAL_FRAME);
        lllllllllllllIIIIIlllIlllIlIlllI.func_190918_g(1);
        for (int lllllllllllllIIIIIlllIlllIlIllIl = 0; lllllllllllllIIIIIlllIlllIlIllIl < 16; ++lllllllllllllIIIIIlllIlllIlIllIl) {
            final double lllllllllllllIIIIIlllIlllIlIllII = lllllllllllllIIIIIlllIlllIllIlIl.getX() + (5.0f + ItemEnderEye.itemRand.nextFloat() * 6.0f) / 16.0f;
            final double lllllllllllllIIIIIlllIlllIlIlIll = lllllllllllllIIIIIlllIlllIllIlIl.getY() + 0.8125f;
            final double lllllllllllllIIIIIlllIlllIlIlIlI = lllllllllllllIIIIIlllIlllIllIlIl.getZ() + (5.0f + ItemEnderEye.itemRand.nextFloat() * 6.0f) / 16.0f;
            final double lllllllllllllIIIIIlllIlllIlIlIIl = 0.0;
            final double lllllllllllllIIIIIlllIlllIlIlIII = 0.0;
            final double lllllllllllllIIIIIlllIlllIlIIlll = 0.0;
            lllllllllllllIIIIIlllIlllIllIllI.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllIIIIIlllIlllIlIllII, lllllllllllllIIIIIlllIlllIlIlIll, lllllllllllllIIIIIlllIlllIlIlIlI, 0.0, 0.0, 0.0, new int[0]);
        }
        lllllllllllllIIIIIlllIlllIllIllI.playSound(null, lllllllllllllIIIIIlllIlllIllIlIl, SoundEvents.field_193781_bp, SoundCategory.BLOCKS, 1.0f, 1.0f);
        final BlockPattern.PatternHelper lllllllllllllIIIIIlllIlllIlIIllI = BlockEndPortalFrame.getOrCreatePortalShape().match(lllllllllllllIIIIIlllIlllIllIllI, lllllllllllllIIIIIlllIlllIllIlIl);
        if (lllllllllllllIIIIIlllIlllIlIIllI != null) {
            final BlockPos lllllllllllllIIIIIlllIlllIlIIlIl = lllllllllllllIIIIIlllIlllIlIIllI.getFrontTopLeft().add(-3, 0, -3);
            for (int lllllllllllllIIIIIlllIlllIlIIlII = 0; lllllllllllllIIIIIlllIlllIlIIlII < 3; ++lllllllllllllIIIIIlllIlllIlIIlII) {
                for (int lllllllllllllIIIIIlllIlllIlIIIll = 0; lllllllllllllIIIIIlllIlllIlIIIll < 3; ++lllllllllllllIIIIIlllIlllIlIIIll) {
                    lllllllllllllIIIIIlllIlllIllIllI.setBlockState(lllllllllllllIIIIIlllIlllIlIIlIl.add(lllllllllllllIIIIIlllIlllIlIIlII, 0, lllllllllllllIIIIIlllIlllIlIIIll), Blocks.END_PORTAL.getDefaultState(), 2);
                }
            }
            lllllllllllllIIIIIlllIlllIllIllI.playBroadcastSound(1038, lllllllllllllIIIIIlllIlllIlIIlIl.add(1, 0, 1), 0);
        }
        return EnumActionResult.SUCCESS;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(final World lllllllllllllIIIIIlllIlllIIIIIlI, final EntityPlayer lllllllllllllIIIIIlllIlllIIIlIIl, final EnumHand lllllllllllllIIIIIlllIlllIIIIIII) {
        final ItemStack lllllllllllllIIIIIlllIlllIIIIlll = lllllllllllllIIIIIlllIlllIIIlIIl.getHeldItem(lllllllllllllIIIIIlllIlllIIIIIII);
        final RayTraceResult lllllllllllllIIIIIlllIlllIIIIllI = this.rayTrace(lllllllllllllIIIIIlllIlllIIIIIlI, lllllllllllllIIIIIlllIlllIIIlIIl, false);
        if (lllllllllllllIIIIIlllIlllIIIIllI != null && lllllllllllllIIIIIlllIlllIIIIllI.typeOfHit == RayTraceResult.Type.BLOCK && lllllllllllllIIIIIlllIlllIIIIIlI.getBlockState(lllllllllllllIIIIIlllIlllIIIIllI.getBlockPos()).getBlock() == Blocks.END_PORTAL_FRAME) {
            return new ActionResult<ItemStack>(EnumActionResult.PASS, lllllllllllllIIIIIlllIlllIIIIlll);
        }
        lllllllllllllIIIIIlllIlllIIIlIIl.setActiveHand(lllllllllllllIIIIIlllIlllIIIIIII);
        if (!lllllllllllllIIIIIlllIlllIIIIIlI.isRemote) {
            final BlockPos lllllllllllllIIIIIlllIlllIIIIlIl = ((WorldServer)lllllllllllllIIIIIlllIlllIIIIIlI).getChunkProvider().getStrongholdGen(lllllllllllllIIIIIlllIlllIIIIIlI, "Stronghold", new BlockPos(lllllllllllllIIIIIlllIlllIIIlIIl), false);
            if (lllllllllllllIIIIIlllIlllIIIIlIl != null) {
                final EntityEnderEye lllllllllllllIIIIIlllIlllIIIIlII = new EntityEnderEye(lllllllllllllIIIIIlllIlllIIIIIlI, lllllllllllllIIIIIlllIlllIIIlIIl.posX, lllllllllllllIIIIIlllIlllIIIlIIl.posY + lllllllllllllIIIIIlllIlllIIIlIIl.height / 2.0f, lllllllllllllIIIIIlllIlllIIIlIIl.posZ);
                lllllllllllllIIIIIlllIlllIIIIlII.moveTowards(lllllllllllllIIIIIlllIlllIIIIlIl);
                lllllllllllllIIIIIlllIlllIIIIIlI.spawnEntityInWorld(lllllllllllllIIIIIlllIlllIIIIlII);
                if (lllllllllllllIIIIIlllIlllIIIlIIl instanceof EntityPlayerMP) {
                    CriteriaTriggers.field_192132_l.func_192239_a((EntityPlayerMP)lllllllllllllIIIIIlllIlllIIIlIIl, lllllllllllllIIIIIlllIlllIIIIlIl);
                }
                lllllllllllllIIIIIlllIlllIIIIIlI.playSound(null, lllllllllllllIIIIIlllIlllIIIlIIl.posX, lllllllllllllIIIIIlllIlllIIIlIIl.posY, lllllllllllllIIIIIlllIlllIIIlIIl.posZ, SoundEvents.ENTITY_ENDEREYE_LAUNCH, SoundCategory.NEUTRAL, 0.5f, 0.4f / (ItemEnderEye.itemRand.nextFloat() * 0.4f + 0.8f));
                lllllllllllllIIIIIlllIlllIIIIIlI.playEvent(null, 1003, new BlockPos(lllllllllllllIIIIIlllIlllIIIlIIl), 0);
                if (!lllllllllllllIIIIIlllIlllIIIlIIl.capabilities.isCreativeMode) {
                    lllllllllllllIIIIIlllIlllIIIIlll.func_190918_g(1);
                }
                lllllllllllllIIIIIlllIlllIIIlIIl.addStat(StatList.getObjectUseStats(this));
                return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIIIIlllIlllIIIIlll);
            }
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, lllllllllllllIIIIIlllIlllIIIIlll);
    }
}
