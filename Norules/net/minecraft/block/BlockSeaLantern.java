package net.minecraft.block;

import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockSeaLantern extends Block
{
    @Override
    public int quantityDropped(final Random lllllllllllllIlIIIIllIIlllIlIIll) {
        return 2 + lllllllllllllIlIIIIllIIlllIlIIll.nextInt(2);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public int quantityDroppedWithBonus(final int lllllllllllllIlIIIIllIIlllIIlllI, final Random lllllllllllllIlIIIIllIIlllIIlIlI) {
        return MathHelper.clamp(this.quantityDropped(lllllllllllllIlIIIIllIIlllIIlIlI) + lllllllllllllIlIIIIllIIlllIIlIlI.nextInt(lllllllllllllIlIIIIllIIlllIIlllI + 1), 1, 5);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlIIIIllIIlllIIlIII, final Random lllllllllllllIlIIIIllIIlllIIIlll, final int lllllllllllllIlIIIIllIIlllIIIllI) {
        return Items.PRISMARINE_CRYSTALS;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIlIIIIllIIlllIIIlII, final IBlockAccess lllllllllllllIlIIIIllIIlllIIIIll, final BlockPos lllllllllllllIlIIIIllIIlllIIIIlI) {
        return MapColor.QUARTZ;
    }
    
    public BlockSeaLantern(final Material lllllllllllllIlIIIIllIIlllIllIIl) {
        super(lllllllllllllIlIIIIllIIlllIllIIl);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
