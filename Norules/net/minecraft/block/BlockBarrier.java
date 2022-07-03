package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockBarrier extends Block
{
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllIIIIlIlllIIlIIllllI, final BlockPos lllllllllllllIIIIlIlllIIlIIlllIl, final IBlockState lllllllllllllIIIIlIlllIIlIIlllII, final float lllllllllllllIIIIlIlllIIlIIllIll, final int lllllllllllllIIIIlIlllIIlIIllIlI) {
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIIIIlIlllIIlIlIIlII) {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public float getAmbientOcclusionLightValue(final IBlockState lllllllllllllIIIIlIlllIIlIlIIIII) {
        return 1.0f;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIIlIlllIIlIlIIIlI) {
        return false;
    }
    
    protected BlockBarrier() {
        super(Material.BARRIER);
        this.setBlockUnbreakable();
        this.setResistance(6000001.0f);
        this.disableStats();
        this.translucent = true;
    }
}
