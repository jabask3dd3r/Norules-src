package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;

public class BlockSlime extends BlockBreakable
{
    @Override
    public void onLanded(final World lllllllllllllIlIlIlllllIllIllllI, final Entity lllllllllllllIlIlIlllllIllIlllIl) {
        if (lllllllllllllIlIlIlllllIllIlllIl.isSneaking()) {
            super.onLanded(lllllllllllllIlIlIlllllIllIllllI, lllllllllllllIlIlIlllllIllIlllIl);
        }
        else if (lllllllllllllIlIlIlllllIllIlllIl.motionY < 0.0) {
            lllllllllllllIlIlIlllllIllIlllIl.motionY = -lllllllllllllIlIlIlllllIllIlllIl.motionY;
            if (!(lllllllllllllIlIlIlllllIllIlllIl instanceof EntityLivingBase)) {
                lllllllllllllIlIlIlllllIllIlllIl.motionY *= 0.8;
            }
        }
    }
    
    @Override
    public void onEntityWalk(final World lllllllllllllIlIlIlllllIllIlIllI, final BlockPos lllllllllllllIlIlIlllllIllIlIlIl, final Entity lllllllllllllIlIlIlllllIllIlIlII) {
        if (Math.abs(lllllllllllllIlIlIlllllIllIlIlII.motionY) < 0.1 && !lllllllllllllIlIlIlllllIllIlIlII.isSneaking()) {
            final double lllllllllllllIlIlIlllllIllIlIIll = 0.4 + Math.abs(lllllllllllllIlIlIlllllIllIlIlII.motionY) * 0.2;
            lllllllllllllIlIlIlllllIllIlIlII.motionX *= lllllllllllllIlIlIlllllIllIlIIll;
            lllllllllllllIlIlIlllllIllIlIlII.motionZ *= lllllllllllllIlIlIlllllIllIlIIll;
        }
        super.onEntityWalk(lllllllllllllIlIlIlllllIllIlIllI, lllllllllllllIlIlIlllllIllIlIlIl, lllllllllllllIlIlIlllllIllIlIlII);
    }
    
    @Override
    public void onFallenUpon(final World lllllllllllllIlIlIlllllIlllIlIIl, final BlockPos lllllllllllllIlIlIlllllIlllIllIl, final Entity lllllllllllllIlIlIlllllIlllIllII, final float lllllllllllllIlIlIlllllIlllIlIll) {
        if (lllllllllllllIlIlIlllllIlllIllII.isSneaking()) {
            super.onFallenUpon(lllllllllllllIlIlIlllllIlllIlIIl, lllllllllllllIlIlIlllllIlllIllIl, lllllllllllllIlIlIlllllIlllIllII, lllllllllllllIlIlIlllllIlllIlIll);
        }
        else {
            lllllllllllllIlIlIlllllIlllIllII.fall(lllllllllllllIlIlIlllllIlllIlIll, 0.0f);
        }
    }
    
    public BlockSlime() {
        super(Material.CLAY, false, MapColor.GRASS);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.slipperiness = 0.8f;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
