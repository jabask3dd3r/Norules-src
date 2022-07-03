package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;

public class BlockIce extends BlockBreakable
{
    public BlockIce() {
        super(Material.ICE, false);
        this.slipperiness = 0.98f;
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    protected void turnIntoWater(final World lllllllllllllIllIIIlllIIlIIIIlll, final BlockPos lllllllllllllIllIIIlllIIlIIIlIIl) {
        if (lllllllllllllIllIIIlllIIlIIIIlll.provider.doesWaterVaporize()) {
            lllllllllllllIllIIIlllIIlIIIIlll.setBlockToAir(lllllllllllllIllIIIlllIIlIIIlIIl);
        }
        else {
            this.dropBlockAsItem(lllllllllllllIllIIIlllIIlIIIIlll, lllllllllllllIllIIIlllIIlIIIlIIl, lllllllllllllIllIIIlllIIlIIIIlll.getBlockState(lllllllllllllIllIIIlllIIlIIIlIIl), 0);
            lllllllllllllIllIIIlllIIlIIIIlll.setBlockState(lllllllllllllIllIIIlllIIlIIIlIIl, Blocks.WATER.getDefaultState());
            lllllllllllllIllIIIlllIIlIIIIlll.func_190524_a(lllllllllllllIllIIIlllIIlIIIlIIl, Blocks.WATER, lllllllllllllIllIIIlllIIlIIIlIIl);
        }
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllIllIIIlllIIlIlIIIlI, final EntityPlayer lllllllllllllIllIIIlllIIlIlIlIlI, final BlockPos lllllllllllllIllIIIlllIIlIlIIIII, final IBlockState lllllllllllllIllIIIlllIIlIIlllll, @Nullable final TileEntity lllllllllllllIllIIIlllIIlIlIIlll, final ItemStack lllllllllllllIllIIIlllIIlIIllllI) {
        lllllllllllllIllIIIlllIIlIlIlIlI.addStat(StatList.getBlockStats(this));
        lllllllllllllIllIIIlllIIlIlIlIlI.addExhaustion(0.005f);
        if (this.canSilkHarvest() && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, lllllllllllllIllIIIlllIIlIIllllI) > 0) {
            Block.spawnAsEntity(lllllllllllllIllIIIlllIIlIlIIIlI, lllllllllllllIllIIIlllIIlIlIIIII, this.getSilkTouchDrop(lllllllllllllIllIIIlllIIlIIlllll));
        }
        else {
            if (lllllllllllllIllIIIlllIIlIlIIIlI.provider.doesWaterVaporize()) {
                lllllllllllllIllIIIlllIIlIlIIIlI.setBlockToAir(lllllllllllllIllIIIlllIIlIlIIIII);
                return;
            }
            final int lllllllllllllIllIIIlllIIlIlIIlIl = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, lllllllllllllIllIIIlllIIlIIllllI);
            this.dropBlockAsItem(lllllllllllllIllIIIlllIIlIlIIIlI, lllllllllllllIllIIIlllIIlIlIIIII, lllllllllllllIllIIIlllIIlIIlllll, lllllllllllllIllIIIlllIIlIlIIlIl);
            final Material lllllllllllllIllIIIlllIIlIlIIlII = lllllllllllllIllIIIlllIIlIlIIIlI.getBlockState(lllllllllllllIllIIIlllIIlIlIIIII.down()).getMaterial();
            if (lllllllllllllIllIIIlllIIlIlIIlII.blocksMovement() || lllllllllllllIllIIIlllIIlIlIIlII.isLiquid()) {
                lllllllllllllIllIIIlllIIlIlIIIlI.setBlockState(lllllllllllllIllIIIlllIIlIlIIIII, Blocks.FLOWING_WATER.getDefaultState());
            }
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIllIIIlllIIlIIllIlI) {
        return 0;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllllIllIIIlllIIlIIIIlII) {
        return EnumPushReaction.NORMAL;
    }
    
    @Override
    public void updateTick(final World lllllllllllllIllIIIlllIIlIIlIlIl, final BlockPos lllllllllllllIllIIIlllIIlIIlIlII, final IBlockState lllllllllllllIllIIIlllIIlIIlIIll, final Random lllllllllllllIllIIIlllIIlIIlIIlI) {
        if (lllllllllllllIllIIIlllIIlIIlIlIl.getLightFor(EnumSkyBlock.BLOCK, lllllllllllllIllIIIlllIIlIIlIlII) > 11 - this.getDefaultState().getLightOpacity()) {
            this.turnIntoWater(lllllllllllllIllIIIlllIIlIIlIlIl, lllllllllllllIllIIIlllIIlIIlIlII);
        }
    }
}
