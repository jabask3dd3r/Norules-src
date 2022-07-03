package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockEmptyDrops extends Block
{
    public BlockEmptyDrops(final Material llllllllllllllIIIIIlIlIIIlIIIIIl) {
        super(llllllllllllllIIIIIlIlIIIlIIIIIl);
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIIIIlIlIIIIlllIll, final Random llllllllllllllIIIIIlIlIIIIlllIlI, final int llllllllllllllIIIIIlIlIIIIlllIIl) {
        return Items.field_190931_a;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIIIIIlIlIIIIllllIl) {
        return 0;
    }
}
