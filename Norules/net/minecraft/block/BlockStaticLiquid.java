package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import java.util.*;
import net.minecraft.init.*;

public class BlockStaticLiquid extends BlockLiquid
{
    private void updateLiquid(final World lllllllllllllIIIlIlIllIIIIlIlIII, final BlockPos lllllllllllllIIIlIlIllIIIIlIIlll, final IBlockState lllllllllllllIIIlIlIllIIIIlIIllI) {
        final BlockDynamicLiquid lllllllllllllIIIlIlIllIIIIlIlIlI = BlockLiquid.getFlowingBlock(this.blockMaterial);
        lllllllllllllIIIlIlIllIIIIlIlIII.setBlockState(lllllllllllllIIIlIlIllIIIIlIIlll, lllllllllllllIIIlIlIllIIIIlIlIlI.getDefaultState().withProperty((IProperty<Comparable>)BlockStaticLiquid.LEVEL, (Integer)lllllllllllllIIIlIlIllIIIIlIIllI.getValue((IProperty<V>)BlockStaticLiquid.LEVEL)), 2);
        lllllllllllllIIIlIlIllIIIIlIlIII.scheduleUpdate(lllllllllllllIIIlIlIllIIIIlIIlll, lllllllllllllIIIlIlIllIIIIlIlIlI, this.tickRate(lllllllllllllIIIlIlIllIIIIlIlIII));
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIIlIlIllIIIIllIllI, final World lllllllllllllIIIlIlIllIIIIlllIll, final BlockPos lllllllllllllIIIlIlIllIIIIllIlII, final Block lllllllllllllIIIlIlIllIIIIlllIIl, final BlockPos lllllllllllllIIIlIlIllIIIIlllIII) {
        if (!this.checkForMixing(lllllllllllllIIIlIlIllIIIIlllIll, lllllllllllllIIIlIlIllIIIIllIlII, lllllllllllllIIIlIlIllIIIIllIllI)) {
            this.updateLiquid(lllllllllllllIIIlIlIllIIIIlllIll, lllllllllllllIIIlIlIllIIIIllIlII, lllllllllllllIIIlIlIllIIIIllIllI);
        }
    }
    
    protected BlockStaticLiquid(final Material lllllllllllllIIIlIlIllIIIlIIIIlI) {
        super(lllllllllllllIIIlIlIllIIIlIIIIlI);
        this.setTickRandomly(false);
        if (lllllllllllllIIIlIlIllIIIlIIIIlI == Material.LAVA) {
            this.setTickRandomly(true);
        }
    }
    
    protected boolean isSurroundingBlockFlammable(final World lllllllllllllIIIlIlIllIIIIIIIIIl, final BlockPos lllllllllllllIIIlIlIllIIIIIIIIII) {
        final byte lllllllllllllIIIlIlIlIlllllllIII;
        final String lllllllllllllIIIlIlIlIlllllllIIl = (String)((EnumFacing[])(Object)(lllllllllllllIIIlIlIlIlllllllIII = (byte)(Object)EnumFacing.values())).length;
        for (double lllllllllllllIIIlIlIlIlllllllIlI = 0; lllllllllllllIIIlIlIlIlllllllIlI < lllllllllllllIIIlIlIlIlllllllIIl; ++lllllllllllllIIIlIlIlIlllllllIlI) {
            final EnumFacing lllllllllllllIIIlIlIlIllllllllll = lllllllllllllIIIlIlIlIlllllllIII[lllllllllllllIIIlIlIlIlllllllIlI];
            if (this.getCanBlockBurn(lllllllllllllIIIlIlIllIIIIIIIIIl, lllllllllllllIIIlIlIllIIIIIIIIII.offset(lllllllllllllIIIlIlIlIllllllllll))) {
                return true;
            }
        }
        return false;
    }
    
    private boolean getCanBlockBurn(final World lllllllllllllIIIlIlIlIllllllIlII, final BlockPos lllllllllllllIIIlIlIlIllllllIIIl) {
        return (lllllllllllllIIIlIlIlIllllllIIIl.getY() < 0 || lllllllllllllIIIlIlIlIllllllIIIl.getY() >= 256 || lllllllllllllIIIlIlIlIllllllIlII.isBlockLoaded(lllllllllllllIIIlIlIlIllllllIIIl)) && lllllllllllllIIIlIlIlIllllllIlII.getBlockState(lllllllllllllIIIlIlIlIllllllIIIl).getMaterial().getCanBurn();
    }
    
    @Override
    public void updateTick(final World lllllllllllllIIIlIlIllIIIIIllIll, final BlockPos lllllllllllllIIIlIlIllIIIIIIllll, final IBlockState lllllllllllllIIIlIlIllIIIIIllIIl, final Random lllllllllllllIIIlIlIllIIIIIIlllI) {
        if (this.blockMaterial == Material.LAVA && lllllllllllllIIIlIlIllIIIIIllIll.getGameRules().getBoolean("doFireTick")) {
            final int lllllllllllllIIIlIlIllIIIIIlIlll = lllllllllllllIIIlIlIllIIIIIIlllI.nextInt(3);
            if (lllllllllllllIIIlIlIllIIIIIlIlll > 0) {
                BlockPos lllllllllllllIIIlIlIllIIIIIlIllI = lllllllllllllIIIlIlIllIIIIIIllll;
                for (int lllllllllllllIIIlIlIllIIIIIlIlIl = 0; lllllllllllllIIIlIlIllIIIIIlIlIl < lllllllllllllIIIlIlIllIIIIIlIlll; ++lllllllllllllIIIlIlIllIIIIIlIlIl) {
                    lllllllllllllIIIlIlIllIIIIIlIllI = lllllllllllllIIIlIlIllIIIIIlIllI.add(lllllllllllllIIIlIlIllIIIIIIlllI.nextInt(3) - 1, 1, lllllllllllllIIIlIlIllIIIIIIlllI.nextInt(3) - 1);
                    if (lllllllllllllIIIlIlIllIIIIIlIllI.getY() >= 0 && lllllllllllllIIIlIlIllIIIIIlIllI.getY() < 256 && !lllllllllllllIIIlIlIllIIIIIllIll.isBlockLoaded(lllllllllllllIIIlIlIllIIIIIlIllI)) {
                        return;
                    }
                    final Block lllllllllllllIIIlIlIllIIIIIlIlII = lllllllllllllIIIlIlIllIIIIIllIll.getBlockState(lllllllllllllIIIlIlIllIIIIIlIllI).getBlock();
                    if (lllllllllllllIIIlIlIllIIIIIlIlII.blockMaterial == Material.AIR) {
                        if (this.isSurroundingBlockFlammable(lllllllllllllIIIlIlIllIIIIIllIll, lllllllllllllIIIlIlIllIIIIIlIllI)) {
                            lllllllllllllIIIlIlIllIIIIIllIll.setBlockState(lllllllllllllIIIlIlIllIIIIIlIllI, Blocks.FIRE.getDefaultState());
                            return;
                        }
                    }
                    else if (lllllllllllllIIIlIlIllIIIIIlIlII.blockMaterial.blocksMovement()) {
                        return;
                    }
                }
            }
            else {
                for (int lllllllllllllIIIlIlIllIIIIIlIIll = 0; lllllllllllllIIIlIlIllIIIIIlIIll < 3; ++lllllllllllllIIIlIlIllIIIIIlIIll) {
                    final BlockPos lllllllllllllIIIlIlIllIIIIIlIIlI = lllllllllllllIIIlIlIllIIIIIIllll.add(lllllllllllllIIIlIlIllIIIIIIlllI.nextInt(3) - 1, 0, lllllllllllllIIIlIlIllIIIIIIlllI.nextInt(3) - 1);
                    if (lllllllllllllIIIlIlIllIIIIIlIIlI.getY() >= 0 && lllllllllllllIIIlIlIllIIIIIlIIlI.getY() < 256 && !lllllllllllllIIIlIlIllIIIIIllIll.isBlockLoaded(lllllllllllllIIIlIlIllIIIIIlIIlI)) {
                        return;
                    }
                    if (lllllllllllllIIIlIlIllIIIIIllIll.isAirBlock(lllllllllllllIIIlIlIllIIIIIlIIlI.up()) && this.getCanBlockBurn(lllllllllllllIIIlIlIllIIIIIllIll, lllllllllllllIIIlIlIllIIIIIlIIlI)) {
                        lllllllllllllIIIlIlIllIIIIIllIll.setBlockState(lllllllllllllIIIlIlIllIIIIIlIIlI.up(), Blocks.FIRE.getDefaultState());
                    }
                }
            }
        }
    }
}
