package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockMelon extends Block
{
    protected BlockMelon() {
        super(Material.GOURD, MapColor.LIME);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIlllIIIIllIllIIIlII) {
        return 3 + lllllllllllllIlllIIIIllIllIIIlII.nextInt(5);
    }
    
    @Override
    public int quantityDroppedWithBonus(final int lllllllllllllIlllIIIIllIlIlllIll, final Random lllllllllllllIlllIIIIllIlIllllIl) {
        return Math.min(9, this.quantityDropped(lllllllllllllIlllIIIIllIlIllllIl) + lllllllllllllIlllIIIIllIlIllllIl.nextInt(1 + lllllllllllllIlllIIIIllIlIlllIll));
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlllIIIIllIllIIlIIl, final Random lllllllllllllIlllIIIIllIllIIlIII, final int lllllllllllllIlllIIIIllIllIIIlll) {
        return Items.MELON;
    }
}
