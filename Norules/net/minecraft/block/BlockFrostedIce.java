package net.minecraft.block;

import net.minecraft.world.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;

public class BlockFrostedIce extends BlockIce
{
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    public void updateTick(final World lllllllllllllIlIlIllIIllIllllIll, final BlockPos lllllllllllllIlIlIllIIllIllllIlI, final IBlockState lllllllllllllIlIlIllIIllIlllIlII, final Random lllllllllllllIlIlIllIIllIlllIIll) {
        if ((lllllllllllllIlIlIllIIllIlllIIll.nextInt(3) == 0 || this.countNeighbors(lllllllllllllIlIlIllIIllIllllIll, lllllllllllllIlIlIllIIllIllllIlI) < 4) && lllllllllllllIlIlIllIIllIllllIll.getLightFromNeighbors(lllllllllllllIlIlIllIIllIllllIlI) > 11 - lllllllllllllIlIlIllIIllIlllIlII.getValue((IProperty<Integer>)BlockFrostedIce.AGE) - lllllllllllllIlIlIllIIllIlllIlII.getLightOpacity()) {
            this.slightlyMelt(lllllllllllllIlIlIllIIllIllllIll, lllllllllllllIlIlIllIIllIllllIlI, lllllllllllllIlIlIllIIllIlllIlII, lllllllllllllIlIlIllIIllIlllIIll, true);
        }
        else {
            lllllllllllllIlIlIllIIllIllllIll.scheduleUpdate(lllllllllllllIlIlIllIIllIllllIlI, this, MathHelper.getInt(lllllllllllllIlIlIllIIllIlllIIll, 20, 40));
        }
    }
    
    private int countNeighbors(final World lllllllllllllIlIlIllIIllIlIlIIll, final BlockPos lllllllllllllIlIlIllIIllIlIlIIlI) {
        int lllllllllllllIlIlIllIIllIlIlIllI = 0;
        final String lllllllllllllIlIlIllIIllIlIIllIl;
        final String lllllllllllllIlIlIllIIllIlIIlllI = (String)((EnumFacing[])(Object)(lllllllllllllIlIlIllIIllIlIIllIl = (String)(Object)EnumFacing.values())).length;
        for (double lllllllllllllIlIlIllIIllIlIIllll = 0; lllllllllllllIlIlIllIIllIlIIllll < lllllllllllllIlIlIllIIllIlIIlllI; ++lllllllllllllIlIlIllIIllIlIIllll) {
            final EnumFacing lllllllllllllIlIlIllIIllIlIlIlIl = lllllllllllllIlIlIllIIllIlIIllIl[lllllllllllllIlIlIllIIllIlIIllll];
            if (lllllllllllllIlIlIllIIllIlIlIIll.getBlockState(lllllllllllllIlIlIllIIllIlIlIIlI.offset(lllllllllllllIlIlIllIIllIlIlIlIl)).getBlock() == this && ++lllllllllllllIlIlIllIIllIlIlIllI >= 4) {
                return lllllllllllllIlIlIllIIllIlIlIllI;
            }
        }
        return lllllllllllllIlIlIllIIllIlIlIllI;
    }
    
    protected void slightlyMelt(final World lllllllllllllIlIlIllIIllIIlllllI, final BlockPos lllllllllllllIlIlIllIIllIIllllIl, final IBlockState lllllllllllllIlIlIllIIllIIllllII, final Random lllllllllllllIlIlIllIIllIIlllIll, final boolean lllllllllllllIlIlIllIIllIIllIIII) {
        final int lllllllllllllIlIlIllIIllIIlllIIl = lllllllllllllIlIlIllIIllIIllllII.getValue((IProperty<Integer>)BlockFrostedIce.AGE);
        if (lllllllllllllIlIlIllIIllIIlllIIl < 3) {
            lllllllllllllIlIlIllIIllIIlllllI.setBlockState(lllllllllllllIlIlIllIIllIIllllIl, lllllllllllllIlIlIllIIllIIllllII.withProperty((IProperty<Comparable>)BlockFrostedIce.AGE, lllllllllllllIlIlIllIIllIIlllIIl + 1), 2);
            lllllllllllllIlIlIllIIllIIlllllI.scheduleUpdate(lllllllllllllIlIlIllIIllIIllllIl, this, MathHelper.getInt(lllllllllllllIlIlIllIIllIIlllIll, 20, 40));
        }
        else {
            this.turnIntoWater(lllllllllllllIlIlIllIIllIIlllllI, lllllllllllllIlIlIllIIllIIllllIl);
            if (lllllllllllllIlIlIllIIllIIllIIII) {
                final double lllllllllllllIlIlIllIIllIIlIlIll;
                final short lllllllllllllIlIlIllIIllIIlIllII = (short)((EnumFacing[])(Object)(lllllllllllllIlIlIllIIllIIlIlIll = (double)(Object)EnumFacing.values())).length;
                for (boolean lllllllllllllIlIlIllIIllIIlIllIl = false; (lllllllllllllIlIlIllIIllIIlIllIl ? 1 : 0) < lllllllllllllIlIlIllIIllIIlIllII; ++lllllllllllllIlIlIllIIllIIlIllIl) {
                    final EnumFacing lllllllllllllIlIlIllIIllIIlllIII = lllllllllllllIlIlIllIIllIIlIlIll[lllllllllllllIlIlIllIIllIIlIllIl];
                    final BlockPos lllllllllllllIlIlIllIIllIIllIlll = lllllllllllllIlIlIllIIllIIllllIl.offset(lllllllllllllIlIlIllIIllIIlllIII);
                    final IBlockState lllllllllllllIlIlIllIIllIIllIllI = lllllllllllllIlIlIllIIllIIlllllI.getBlockState(lllllllllllllIlIlIllIIllIIllIlll);
                    if (lllllllllllllIlIlIllIIllIIllIllI.getBlock() == this) {
                        this.slightlyMelt(lllllllllllllIlIlIllIIllIIlllllI, lllllllllllllIlIlIllIIllIIllIlll, lllllllllllllIlIlIllIIllIIllIllI, lllllllllllllIlIlIllIIllIIlllIll, false);
                    }
                }
            }
        }
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlIlIllIIllIllIllII, final World lllllllllllllIlIlIllIIllIllIIlIl, final BlockPos lllllllllllllIlIlIllIIllIllIlIlI, final Block lllllllllllllIlIlIllIIllIllIlIIl, final BlockPos lllllllllllllIlIlIllIIllIllIlIII) {
        if (lllllllllllllIlIlIllIIllIllIlIIl == this) {
            final int lllllllllllllIlIlIllIIllIllIIlll = this.countNeighbors(lllllllllllllIlIlIllIIllIllIIlIl, lllllllllllllIlIlIllIIllIllIlIlI);
            if (lllllllllllllIlIlIllIIllIllIIlll < 2) {
                this.turnIntoWater(lllllllllllllIlIlIllIIllIllIIlIl, lllllllllllllIlIlIllIIllIllIlIlI);
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlIlIllIIlllIIIIIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFrostedIce.AGE, MathHelper.clamp(lllllllllllllIlIlIllIIlllIIIIIlI, 0, 3));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFrostedIce.AGE });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlIlIllIIlllIIIlIII) {
        return lllllllllllllIlIlIllIIlllIIIlIII.getValue((IProperty<Integer>)BlockFrostedIce.AGE);
    }
    
    public BlockFrostedIce() {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFrostedIce.AGE, 0));
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlIlIllIIllIIlIIlII, final BlockPos lllllllllllllIlIlIllIIllIIlIIIll, final IBlockState lllllllllllllIlIlIllIIllIIlIIIlI) {
        return ItemStack.field_190927_a;
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 3);
    }
}
