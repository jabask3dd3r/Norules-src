package net.minecraft.item;

import java.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import com.google.common.collect.*;

public class ItemSpade extends ItemTool
{
    private static final /* synthetic */ Set<Block> EFFECTIVE_ON;
    
    @Override
    public EnumActionResult onItemUse(final EntityPlayer lllllllllllllIIlIlllIllIlIlIIIII, final World lllllllllllllIIlIlllIllIlIIlllll, final BlockPos lllllllllllllIIlIlllIllIIlIIlIlI, final EnumHand lllllllllllllIIlIlllIllIIlIIlIIl, final EnumFacing lllllllllllllIIlIlllIllIIlIIlIII, final float lllllllllllllIIlIlllIllIlIIllIll, final float lllllllllllllIIlIlllIllIlIIllIlI, final float lllllllllllllIIlIlllIllIlIIllIIl) {
        final ItemStack lllllllllllllIIlIlllIllIlIIllIII = lllllllllllllIIlIlllIllIlIlIIIII.getHeldItem(lllllllllllllIIlIlllIllIIlIIlIIl);
        if (!lllllllllllllIIlIlllIllIlIlIIIII.canPlayerEdit(lllllllllllllIIlIlllIllIIlIIlIlI.offset(lllllllllllllIIlIlllIllIIlIIlIII), lllllllllllllIIlIlllIllIIlIIlIII, lllllllllllllIIlIlllIllIlIIllIII)) {
            return EnumActionResult.FAIL;
        }
        final IBlockState lllllllllllllIIlIlllIllIIlIIllll = lllllllllllllIIlIlllIllIlIIlllll.getBlockState(lllllllllllllIIlIlllIllIIlIIlIlI);
        final Block lllllllllllllIIlIlllIllIIlIIlllI = lllllllllllllIIlIlllIllIIlIIllll.getBlock();
        if (lllllllllllllIIlIlllIllIIlIIlIII != EnumFacing.DOWN && lllllllllllllIIlIlllIllIlIIlllll.getBlockState(lllllllllllllIIlIlllIllIIlIIlIlI.up()).getMaterial() == Material.AIR && lllllllllllllIIlIlllIllIIlIIlllI == Blocks.GRASS) {
            final IBlockState lllllllllllllIIlIlllIllIIlIIllIl = Blocks.GRASS_PATH.getDefaultState();
            lllllllllllllIIlIlllIllIlIIlllll.playSound(lllllllllllllIIlIlllIllIlIlIIIII, lllllllllllllIIlIlllIllIIlIIlIlI, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0f, 1.0f);
            if (!lllllllllllllIIlIlllIllIlIIlllll.isRemote) {
                lllllllllllllIIlIlllIllIlIIlllll.setBlockState(lllllllllllllIIlIlllIllIIlIIlIlI, lllllllllllllIIlIlllIllIIlIIllIl, 11);
                lllllllllllllIIlIlllIllIlIIllIII.damageItem(1, lllllllllllllIIlIlllIllIlIlIIIII);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }
    
    @Override
    public boolean canHarvestBlock(final IBlockState lllllllllllllIIlIlllIllIlIlIlllI) {
        final Block lllllllllllllIIlIlllIllIlIlIllIl = lllllllllllllIIlIlllIllIlIlIlllI.getBlock();
        return lllllllllllllIIlIlllIllIlIlIllIl == Blocks.SNOW_LAYER || lllllllllllllIIlIlllIllIlIlIllIl == Blocks.SNOW;
    }
    
    public ItemSpade(final ToolMaterial lllllllllllllIIlIlllIllIlIllIlII) {
        super(1.5f, -3.0f, lllllllllllllIIlIlllIllIlIllIlII, ItemSpade.EFFECTIVE_ON);
    }
    
    static {
        EFFECTIVE_ON = Sets.newHashSet((Object[])new Block[] { Blocks.CLAY, Blocks.DIRT, Blocks.FARMLAND, Blocks.GRASS, Blocks.GRAVEL, Blocks.MYCELIUM, Blocks.SAND, Blocks.SNOW, Blocks.SNOW_LAYER, Blocks.SOUL_SAND, Blocks.GRASS_PATH, Blocks.field_192444_dS });
    }
}
