package net.minecraft.item;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class ItemShears extends Item
{
    @Override
    public boolean canHarvestBlock(final IBlockState lllllllllllllIIllIIlIIIIIIIlIllI) {
        final Block lllllllllllllIIllIIlIIIIIIIlIlIl = lllllllllllllIIllIIlIIIIIIIlIllI.getBlock();
        return lllllllllllllIIllIIlIIIIIIIlIlIl == Blocks.WEB || lllllllllllllIIllIIlIIIIIIIlIlIl == Blocks.REDSTONE_WIRE || lllllllllllllIIllIIlIIIIIIIlIlIl == Blocks.TRIPWIRE;
    }
    
    @Override
    public boolean onBlockDestroyed(final ItemStack lllllllllllllIIllIIlIIIIIIlIIllI, final World lllllllllllllIIllIIlIIIIIIlIIlIl, final IBlockState lllllllllllllIIllIIlIIIIIIlIIlII, final BlockPos lllllllllllllIIllIIlIIIIIIIlllII, final EntityLivingBase lllllllllllllIIllIIlIIIIIIlIIIlI) {
        if (!lllllllllllllIIllIIlIIIIIIlIIlIl.isRemote) {
            lllllllllllllIIllIIlIIIIIIlIIllI.damageItem(1, lllllllllllllIIllIIlIIIIIIlIIIlI);
        }
        final Block lllllllllllllIIllIIlIIIIIIlIIIIl = lllllllllllllIIllIIlIIIIIIlIIlII.getBlock();
        return lllllllllllllIIllIIlIIIIIIlIIlII.getMaterial() == Material.LEAVES || lllllllllllllIIllIIlIIIIIIlIIIIl == Blocks.WEB || lllllllllllllIIllIIlIIIIIIlIIIIl == Blocks.TALLGRASS || lllllllllllllIIllIIlIIIIIIlIIIIl == Blocks.VINE || lllllllllllllIIllIIlIIIIIIlIIIIl == Blocks.TRIPWIRE || lllllllllllllIIllIIlIIIIIIlIIIIl == Blocks.WOOL || super.onBlockDestroyed(lllllllllllllIIllIIlIIIIIIlIIllI, lllllllllllllIIllIIlIIIIIIlIIlIl, lllllllllllllIIllIIlIIIIIIlIIlII, lllllllllllllIIllIIlIIIIIIIlllII, lllllllllllllIIllIIlIIIIIIlIIIlI);
    }
    
    @Override
    public float getStrVsBlock(final ItemStack lllllllllllllIIllIIlIIIIIIIIllIl, final IBlockState lllllllllllllIIllIIlIIIIIIIIlIII) {
        final Block lllllllllllllIIllIIlIIIIIIIIlIll = lllllllllllllIIllIIlIIIIIIIIlIII.getBlock();
        if (lllllllllllllIIllIIlIIIIIIIIlIll != Blocks.WEB && lllllllllllllIIllIIlIIIIIIIIlIII.getMaterial() != Material.LEAVES) {
            return (lllllllllllllIIllIIlIIIIIIIIlIll == Blocks.WOOL) ? 5.0f : super.getStrVsBlock(lllllllllllllIIllIIlIIIIIIIIllIl, lllllllllllllIIllIIlIIIIIIIIlIII);
        }
        return 15.0f;
    }
    
    public ItemShears() {
        this.setMaxStackSize(1);
        this.setMaxDamage(238);
        this.setCreativeTab(CreativeTabs.TOOLS);
    }
}
