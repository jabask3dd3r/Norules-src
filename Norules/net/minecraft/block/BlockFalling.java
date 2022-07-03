package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;

public class BlockFalling extends Block
{
    public static /* synthetic */ boolean fallInstantly;
    
    @Override
    public void updateTick(final World lllllllllllllIlllIIIIlIllllIlIll, final BlockPos lllllllllllllIlllIIIIlIllllIlIlI, final IBlockState lllllllllllllIlllIIIIlIllllIlllI, final Random lllllllllllllIlllIIIIlIllllIllIl) {
        if (!lllllllllllllIlllIIIIlIllllIlIll.isRemote) {
            this.checkFallable(lllllllllllllIlllIIIIlIllllIlIll, lllllllllllllIlllIIIIlIllllIlIlI);
        }
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllIlllIIIIlIllIlllIll, final World lllllllllllllIlllIIIIlIllIllIIlI, final BlockPos lllllllllllllIlllIIIIlIllIlllIIl, final Random lllllllllllllIlllIIIIlIllIlllIII) {
        if (lllllllllllllIlllIIIIlIllIlllIII.nextInt(16) == 0) {
            final BlockPos lllllllllllllIlllIIIIlIllIllIlll = lllllllllllllIlllIIIIlIllIlllIIl.down();
            if (canFallThrough(lllllllllllllIlllIIIIlIllIllIIlI.getBlockState(lllllllllllllIlllIIIIlIllIllIlll))) {
                final double lllllllllllllIlllIIIIlIllIllIllI = lllllllllllllIlllIIIIlIllIlllIIl.getX() + lllllllllllllIlllIIIIlIllIlllIII.nextFloat();
                final double lllllllllllllIlllIIIIlIllIllIlIl = lllllllllllllIlllIIIIlIllIlllIIl.getY() - 0.05;
                final double lllllllllllllIlllIIIIlIllIllIlII = lllllllllllllIlllIIIIlIllIlllIIl.getZ() + lllllllllllllIlllIIIIlIllIlllIII.nextFloat();
                lllllllllllllIlllIIIIlIllIllIIlI.spawnParticle(EnumParticleTypes.FALLING_DUST, lllllllllllllIlllIIIIlIllIllIllI, lllllllllllllIlllIIIIlIllIllIlIl, lllllllllllllIlllIIIIlIllIllIlII, 0.0, 0.0, 0.0, Block.getStateId(lllllllllllllIlllIIIIlIllIlllIll));
            }
        }
    }
    
    private void checkFallable(final World lllllllllllllIlllIIIIlIllllIIIll, final BlockPos lllllllllllllIlllIIIIlIlllIlllII) {
        if (canFallThrough(lllllllllllllIlllIIIIlIllllIIIll.getBlockState(lllllllllllllIlllIIIIlIlllIlllII.down())) && lllllllllllllIlllIIIIlIlllIlllII.getY() >= 0) {
            final int lllllllllllllIlllIIIIlIllllIIIIl = 32;
            if (!BlockFalling.fallInstantly && lllllllllllllIlllIIIIlIllllIIIll.isAreaLoaded(lllllllllllllIlllIIIIlIlllIlllII.add(-32, -32, -32), lllllllllllllIlllIIIIlIlllIlllII.add(32, 32, 32))) {
                if (!lllllllllllllIlllIIIIlIllllIIIll.isRemote) {
                    final EntityFallingBlock lllllllllllllIlllIIIIlIllllIIIII = new EntityFallingBlock(lllllllllllllIlllIIIIlIllllIIIll, lllllllllllllIlllIIIIlIlllIlllII.getX() + 0.5, lllllllllllllIlllIIIIlIlllIlllII.getY(), lllllllllllllIlllIIIIlIlllIlllII.getZ() + 0.5, lllllllllllllIlllIIIIlIllllIIIll.getBlockState(lllllllllllllIlllIIIIlIlllIlllII));
                    this.onStartFalling(lllllllllllllIlllIIIIlIllllIIIII);
                    lllllllllllllIlllIIIIlIllllIIIll.spawnEntityInWorld(lllllllllllllIlllIIIIlIllllIIIII);
                }
            }
            else {
                lllllllllllllIlllIIIIlIllllIIIll.setBlockToAir(lllllllllllllIlllIIIIlIlllIlllII);
                BlockPos lllllllllllllIlllIIIIlIlllIlllll;
                for (lllllllllllllIlllIIIIlIlllIlllll = lllllllllllllIlllIIIIlIlllIlllII.down(); canFallThrough(lllllllllllllIlllIIIIlIllllIIIll.getBlockState(lllllllllllllIlllIIIIlIlllIlllll)) && lllllllllllllIlllIIIIlIlllIlllll.getY() > 0; lllllllllllllIlllIIIIlIlllIlllll = lllllllllllllIlllIIIIlIlllIlllll.down()) {}
                if (lllllllllllllIlllIIIIlIlllIlllll.getY() > 0) {
                    lllllllllllllIlllIIIIlIllllIIIll.setBlockState(lllllllllllllIlllIIIIlIlllIlllll.up(), this.getDefaultState());
                }
            }
        }
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIlllIIIIllIIIIIIIlI, final BlockPos lllllllllllllIlllIIIIllIIIIIIIIl, final IBlockState lllllllllllllIlllIIIIllIIIIIIlII) {
        lllllllllllllIlllIIIIllIIIIIIIlI.scheduleUpdate(lllllllllllllIlllIIIIllIIIIIIIIl, this, this.tickRate(lllllllllllllIlllIIIIllIIIIIIIlI));
    }
    
    public int getDustColor(final IBlockState lllllllllllllIlllIIIIlIllIlIlIlI) {
        return -16777216;
    }
    
    public void func_190974_b(final World lllllllllllllIlllIIIIlIlllIIIllI, final BlockPos lllllllllllllIlllIIIIlIlllIIIlIl) {
    }
    
    public BlockFalling() {
        super(Material.SAND);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    public void onEndFalling(final World lllllllllllllIlllIIIIlIlllIIlIll, final BlockPos lllllllllllllIlllIIIIlIlllIIlIlI, final IBlockState lllllllllllllIlllIIIIlIlllIIlIIl, final IBlockState lllllllllllllIlllIIIIlIlllIIlIII) {
    }
    
    @Override
    public int tickRate(final World lllllllllllllIlllIIIIlIlllIlIllI) {
        return 2;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlllIIIIlIlllllllII, final World lllllllllllllIlllIIIIlIllllllIll, final BlockPos lllllllllllllIlllIIIIlIlllllIlIl, final Block lllllllllllllIlllIIIIlIllllllIIl, final BlockPos lllllllllllllIlllIIIIlIllllllIII) {
        lllllllllllllIlllIIIIlIllllllIll.scheduleUpdate(lllllllllllllIlllIIIIlIlllllIlIl, this, this.tickRate(lllllllllllllIlllIIIIlIllllllIll));
    }
    
    public BlockFalling(final Material lllllllllllllIlllIIIIllIIIIIlIll) {
        super(lllllllllllllIlllIIIIllIIIIIlIll);
    }
    
    protected void onStartFalling(final EntityFallingBlock lllllllllllllIlllIIIIlIlllIllIII) {
    }
    
    public static boolean canFallThrough(final IBlockState lllllllllllllIlllIIIIlIlllIlIIlI) {
        final Block lllllllllllllIlllIIIIlIlllIlIIIl = lllllllllllllIlllIIIIlIlllIlIIlI.getBlock();
        final Material lllllllllllllIlllIIIIlIlllIlIIII = lllllllllllllIlllIIIIlIlllIlIIlI.getMaterial();
        return lllllllllllllIlllIIIIlIlllIlIIIl == Blocks.FIRE || lllllllllllllIlllIIIIlIlllIlIIII == Material.AIR || lllllllllllllIlllIIIIlIlllIlIIII == Material.WATER || lllllllllllllIlllIIIIlIlllIlIIII == Material.LAVA;
    }
}
