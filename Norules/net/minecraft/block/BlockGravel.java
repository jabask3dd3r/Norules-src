package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class BlockGravel extends BlockFalling
{
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIlIIllIlllllllll, final IBlockAccess llllllllllllllIlIlIIllIllllllllI, final BlockPos llllllllllllllIlIlIIllIlllllllIl) {
        return MapColor.STONE;
    }
    
    @Override
    public int getDustColor(final IBlockState llllllllllllllIlIlIIllIllllllIll) {
        return -8356741;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIlIlIIlllIIIIIIIll, final Random llllllllllllllIlIlIIlllIIIIIIllI, int llllllllllllllIlIlIIlllIIIIIIIIl) {
        if (llllllllllllllIlIlIIlllIIIIIIIIl > 3) {
            llllllllllllllIlIlIIlllIIIIIIIIl = 3;
        }
        return (llllllllllllllIlIlIIlllIIIIIIllI.nextInt((int)(10 - llllllllllllllIlIlIIlllIIIIIIIIl * 3)) == 0) ? Items.FLINT : super.getItemDropped(llllllllllllllIlIlIIlllIIIIIIIll, llllllllllllllIlIlIIlllIIIIIIllI, (int)llllllllllllllIlIlIIlllIIIIIIIIl);
    }
}
