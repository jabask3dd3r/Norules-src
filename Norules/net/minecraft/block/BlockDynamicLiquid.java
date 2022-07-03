package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import java.util.*;

public class BlockDynamicLiquid extends BlockLiquid
{
    /* synthetic */ int adjacentSourceBlocks;
    
    private Set<EnumFacing> getPossibleFlowDirections(final World llllllllllllllIIIIIllIIlllllllIl, final BlockPos llllllllllllllIIIIIllIIlllllllII) {
        int llllllllllllllIIIIIllIlIIIIIIlIl = 1000;
        final Set<EnumFacing> llllllllllllllIIIIIllIlIIIIIIlII = EnumSet.noneOf(EnumFacing.class);
        for (final EnumFacing llllllllllllllIIIIIllIlIIIIIIIll : EnumFacing.Plane.HORIZONTAL) {
            final BlockPos llllllllllllllIIIIIllIlIIIIIIIlI = llllllllllllllIIIIIllIIlllllllII.offset(llllllllllllllIIIIIllIlIIIIIIIll);
            final IBlockState llllllllllllllIIIIIllIlIIIIIIIIl = llllllllllllllIIIIIllIIlllllllIl.getBlockState(llllllllllllllIIIIIllIlIIIIIIIlI);
            if (!this.isBlocked(llllllllllllllIIIIIllIIlllllllIl, llllllllllllllIIIIIllIlIIIIIIIlI, llllllllllllllIIIIIllIlIIIIIIIIl) && (llllllllllllllIIIIIllIlIIIIIIIIl.getMaterial() != this.blockMaterial || llllllllllllllIIIIIllIlIIIIIIIIl.getValue((IProperty<Integer>)BlockDynamicLiquid.LEVEL) > 0)) {
                int llllllllllllllIIIIIllIIlllllllll = 0;
                if (this.isBlocked(llllllllllllllIIIIIllIIlllllllIl, llllllllllllllIIIIIllIlIIIIIIIlI.down(), llllllllllllllIIIIIllIIlllllllIl.getBlockState(llllllllllllllIIIIIllIlIIIIIIIlI.down()))) {
                    final int llllllllllllllIIIIIllIlIIIIIIIII = this.getSlopeDistance(llllllllllllllIIIIIllIIlllllllIl, llllllllllllllIIIIIllIlIIIIIIIlI, 1, llllllllllllllIIIIIllIlIIIIIIIll.getOpposite());
                }
                else {
                    llllllllllllllIIIIIllIIlllllllll = 0;
                }
                if (llllllllllllllIIIIIllIIlllllllll < llllllllllllllIIIIIllIlIIIIIIlIl) {
                    llllllllllllllIIIIIllIlIIIIIIlII.clear();
                }
                if (llllllllllllllIIIIIllIIlllllllll > llllllllllllllIIIIIllIlIIIIIIlIl) {
                    continue;
                }
                llllllllllllllIIIIIllIlIIIIIIlII.add(llllllllllllllIIIIIllIlIIIIIIIll);
                llllllllllllllIIIIIllIlIIIIIIlIl = llllllllllllllIIIIIllIIlllllllll;
            }
        }
        return llllllllllllllIIIIIllIlIIIIIIlII;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIIIIIllIIlllIIIIlI, final BlockPos llllllllllllllIIIIIllIIlllIIIIIl, final IBlockState llllllllllllllIIIIIllIIlllIIIlII) {
        if (!this.checkForMixing(llllllllllllllIIIIIllIIlllIIIIlI, llllllllllllllIIIIIllIIlllIIIIIl, llllllllllllllIIIIIllIIlllIIIlII)) {
            llllllllllllllIIIIIllIIlllIIIIlI.scheduleUpdate(llllllllllllllIIIIIllIIlllIIIIIl, this, this.tickRate(llllllllllllllIIIIIllIIlllIIIIlI));
        }
    }
    
    private void placeStaticBlock(final World llllllllllllllIIIIIllIlIlIlIIIII, final BlockPos llllllllllllllIIIIIllIlIlIIlllll, final IBlockState llllllllllllllIIIIIllIlIlIIllllI) {
        llllllllllllllIIIIIllIlIlIlIIIII.setBlockState(llllllllllllllIIIIIllIlIlIIlllll, BlockLiquid.getStaticBlock(this.blockMaterial).getDefaultState().withProperty((IProperty<Comparable>)BlockDynamicLiquid.LEVEL, (Integer)llllllllllllllIIIIIllIlIlIIllllI.getValue((IProperty<V>)BlockDynamicLiquid.LEVEL)), 2);
    }
    
    private boolean canFlowInto(final World llllllllllllllIIIIIllIIlllIIllll, final BlockPos llllllllllllllIIIIIllIIlllIlIIll, final IBlockState llllllllllllllIIIIIllIIlllIIllIl) {
        final Material llllllllllllllIIIIIllIIlllIlIIIl = llllllllllllllIIIIIllIIlllIIllIl.getMaterial();
        return llllllllllllllIIIIIllIIlllIlIIIl != this.blockMaterial && llllllllllllllIIIIIllIIlllIlIIIl != Material.LAVA && !this.isBlocked(llllllllllllllIIIIIllIIlllIIllll, llllllllllllllIIIIIllIIlllIlIIll, llllllllllllllIIIIIllIIlllIIllIl);
    }
    
    protected int checkAdjacentBlock(final World llllllllllllllIIIIIllIIlllIllllI, final BlockPos llllllllllllllIIIIIllIIllllIIIlI, final int llllllllllllllIIIIIllIIlllIlllII) {
        int llllllllllllllIIIIIllIIllllIIIII = this.getDepth(llllllllllllllIIIIIllIIlllIllllI.getBlockState(llllllllllllllIIIIIllIIllllIIIlI));
        if (llllllllllllllIIIIIllIIllllIIIII < 0) {
            return llllllllllllllIIIIIllIIlllIlllII;
        }
        if (llllllllllllllIIIIIllIIllllIIIII == 0) {
            ++this.adjacentSourceBlocks;
        }
        if (llllllllllllllIIIIIllIIllllIIIII >= 8) {
            llllllllllllllIIIIIllIIllllIIIII = 0;
        }
        return (llllllllllllllIIIIIllIIlllIlllII >= 0 && llllllllllllllIIIIIllIIllllIIIII >= llllllllllllllIIIIIllIIlllIlllII) ? llllllllllllllIIIIIllIIlllIlllII : llllllllllllllIIIIIllIIllllIIIII;
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIIIIllIlIIllIIlII, final BlockPos llllllllllllllIIIIIllIlIIlllllII, IBlockState llllllllllllllIIIIIllIlIIllIIIII, final Random llllllllllllllIIIIIllIlIIlIlllll) {
        int llllllllllllllIIIIIllIlIIlllIllI = llllllllllllllIIIIIllIlIIllIIIII.getValue((IProperty<Integer>)BlockDynamicLiquid.LEVEL);
        int llllllllllllllIIIIIllIlIIlllIlIl = 1;
        if (this.blockMaterial == Material.LAVA && !llllllllllllllIIIIIllIlIIllIIlII.provider.doesWaterVaporize()) {
            llllllllllllllIIIIIllIlIIlllIlIl = 2;
        }
        int llllllllllllllIIIIIllIlIIlllIIll = this.tickRate(llllllllllllllIIIIIllIlIIllIIlII);
        if (llllllllllllllIIIIIllIlIIlllIllI > 0) {
            int llllllllllllllIIIIIllIlIIlllIIlI = -100;
            this.adjacentSourceBlocks = 0;
            for (final EnumFacing llllllllllllllIIIIIllIlIIlllIIIl : EnumFacing.Plane.HORIZONTAL) {
                llllllllllllllIIIIIllIlIIlllIIlI = this.checkAdjacentBlock(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII.offset(llllllllllllllIIIIIllIlIIlllIIIl), llllllllllllllIIIIIllIlIIlllIIlI);
            }
            int llllllllllllllIIIIIllIlIIlllIIII = llllllllllllllIIIIIllIlIIlllIIlI + llllllllllllllIIIIIllIlIIlllIlIl;
            if (llllllllllllllIIIIIllIlIIlllIIII >= 8 || llllllllllllllIIIIIllIlIIlllIIlI < 0) {
                llllllllllllllIIIIIllIlIIlllIIII = -1;
            }
            final int llllllllllllllIIIIIllIlIIllIllll = this.getDepth(llllllllllllllIIIIIllIlIIllIIlII.getBlockState(llllllllllllllIIIIIllIlIIlllllII.up()));
            if (llllllllllllllIIIIIllIlIIllIllll >= 0) {
                if (llllllllllllllIIIIIllIlIIllIllll >= 8) {
                    llllllllllllllIIIIIllIlIIlllIIII = llllllllllllllIIIIIllIlIIllIllll;
                }
                else {
                    llllllllllllllIIIIIllIlIIlllIIII = llllllllllllllIIIIIllIlIIllIllll + 8;
                }
            }
            if (this.adjacentSourceBlocks >= 2 && this.blockMaterial == Material.WATER) {
                final IBlockState llllllllllllllIIIIIllIlIIllIlllI = llllllllllllllIIIIIllIlIIllIIlII.getBlockState(llllllllllllllIIIIIllIlIIlllllII.down());
                if (llllllllllllllIIIIIllIlIIllIlllI.getMaterial().isSolid()) {
                    llllllllllllllIIIIIllIlIIlllIIII = 0;
                }
                else if (llllllllllllllIIIIIllIlIIllIlllI.getMaterial() == this.blockMaterial && llllllllllllllIIIIIllIlIIllIlllI.getValue((IProperty<Integer>)BlockDynamicLiquid.LEVEL) == 0) {
                    llllllllllllllIIIIIllIlIIlllIIII = 0;
                }
            }
            if (this.blockMaterial == Material.LAVA && llllllllllllllIIIIIllIlIIlllIllI < 8 && llllllllllllllIIIIIllIlIIlllIIII < 8 && llllllllllllllIIIIIllIlIIlllIIII > llllllllllllllIIIIIllIlIIlllIllI && llllllllllllllIIIIIllIlIIlIlllll.nextInt(4) != 0) {
                llllllllllllllIIIIIllIlIIlllIIll *= 4;
            }
            if (llllllllllllllIIIIIllIlIIlllIIII == llllllllllllllIIIIIllIlIIlllIllI) {
                this.placeStaticBlock(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII, llllllllllllllIIIIIllIlIIllIIIII);
            }
            else if ((llllllllllllllIIIIIllIlIIlllIllI = llllllllllllllIIIIIllIlIIlllIIII) < 0) {
                llllllllllllllIIIIIllIlIIllIIlII.setBlockToAir(llllllllllllllIIIIIllIlIIlllllII);
            }
            else {
                llllllllllllllIIIIIllIlIIllIIIII = llllllllllllllIIIIIllIlIIllIIIII.withProperty((IProperty<Comparable>)BlockDynamicLiquid.LEVEL, llllllllllllllIIIIIllIlIIlllIIII);
                llllllllllllllIIIIIllIlIIllIIlII.setBlockState(llllllllllllllIIIIIllIlIIlllllII, llllllllllllllIIIIIllIlIIllIIIII, 2);
                llllllllllllllIIIIIllIlIIllIIlII.scheduleUpdate(llllllllllllllIIIIIllIlIIlllllII, this, llllllllllllllIIIIIllIlIIlllIIll);
                llllllllllllllIIIIIllIlIIllIIlII.notifyNeighborsOfStateChange(llllllllllllllIIIIIllIlIIlllllII, this, false);
            }
        }
        else {
            this.placeStaticBlock(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII, llllllllllllllIIIIIllIlIIllIIIII);
        }
        final IBlockState llllllllllllllIIIIIllIlIIllIllIl = llllllllllllllIIIIIllIlIIllIIlII.getBlockState(llllllllllllllIIIIIllIlIIlllllII.down());
        if (this.canFlowInto(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII.down(), llllllllllllllIIIIIllIlIIllIllIl)) {
            if (this.blockMaterial == Material.LAVA && llllllllllllllIIIIIllIlIIllIIlII.getBlockState(llllllllllllllIIIIIllIlIIlllllII.down()).getMaterial() == Material.WATER) {
                llllllllllllllIIIIIllIlIIllIIlII.setBlockState(llllllllllllllIIIIIllIlIIlllllII.down(), Blocks.STONE.getDefaultState());
                this.triggerMixEffects(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII.down());
                return;
            }
            if (llllllllllllllIIIIIllIlIIlllIllI >= 8) {
                this.tryFlowInto(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII.down(), llllllllllllllIIIIIllIlIIllIllIl, llllllllllllllIIIIIllIlIIlllIllI);
            }
            else {
                this.tryFlowInto(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII.down(), llllllllllllllIIIIIllIlIIllIllIl, llllllllllllllIIIIIllIlIIlllIllI + 8);
            }
        }
        else if (llllllllllllllIIIIIllIlIIlllIllI >= 0 && (llllllllllllllIIIIIllIlIIlllIllI == 0 || this.isBlocked(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII.down(), llllllllllllllIIIIIllIlIIllIllIl))) {
            final Set<EnumFacing> llllllllllllllIIIIIllIlIIllIllII = this.getPossibleFlowDirections(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII);
            int llllllllllllllIIIIIllIlIIllIlIlI = llllllllllllllIIIIIllIlIIlllIllI + llllllllllllllIIIIIllIlIIlllIlIl;
            if (llllllllllllllIIIIIllIlIIlllIllI >= 8) {
                llllllllllllllIIIIIllIlIIllIlIlI = 1;
            }
            if (llllllllllllllIIIIIllIlIIllIlIlI >= 8) {
                return;
            }
            for (final EnumFacing llllllllllllllIIIIIllIlIIllIlIII : llllllllllllllIIIIIllIlIIllIllII) {
                this.tryFlowInto(llllllllllllllIIIIIllIlIIllIIlII, llllllllllllllIIIIIllIlIIlllllII.offset(llllllllllllllIIIIIllIlIIllIlIII), llllllllllllllIIIIIllIlIIllIIlII.getBlockState(llllllllllllllIIIIIllIlIIlllllII.offset(llllllllllllllIIIIIllIlIIllIlIII)), llllllllllllllIIIIIllIlIIllIlIlI);
            }
        }
    }
    
    private boolean isBlocked(final World llllllllllllllIIIIIllIIlllllIIII, final BlockPos llllllllllllllIIIIIllIIllllIlIll, final IBlockState llllllllllllllIIIIIllIIllllIlllI) {
        final Block llllllllllllllIIIIIllIIllllIllIl = llllllllllllllIIIIIllIIlllllIIII.getBlockState(llllllllllllllIIIIIllIIllllIlIll).getBlock();
        return llllllllllllllIIIIIllIIllllIllIl instanceof BlockDoor || llllllllllllllIIIIIllIIllllIllIl == Blocks.STANDING_SIGN || llllllllllllllIIIIIllIIllllIllIl == Blocks.LADDER || llllllllllllllIIIIIllIIllllIllIl == Blocks.REEDS || llllllllllllllIIIIIllIIllllIllIl.blockMaterial == Material.PORTAL || llllllllllllllIIIIIllIIllllIllIl.blockMaterial == Material.STRUCTURE_VOID || llllllllllllllIIIIIllIIllllIllIl.blockMaterial.blocksMovement();
    }
    
    protected BlockDynamicLiquid(final Material llllllllllllllIIIIIllIlIlIlIllII) {
        super(llllllllllllllIIIIIllIlIlIlIllII);
    }
    
    private int getSlopeFindDistance(final World llllllllllllllIIIIIllIlIIIIlIlIl) {
        return (this.blockMaterial == Material.LAVA && !llllllllllllllIIIIIllIlIIIIlIlIl.provider.doesWaterVaporize()) ? 2 : 4;
    }
    
    private int getSlopeDistance(final World llllllllllllllIIIIIllIlIIIlIIIlI, final BlockPos llllllllllllllIIIIIllIlIIIlIIIIl, final int llllllllllllllIIIIIllIlIIIlIIIII, final EnumFacing llllllllllllllIIIIIllIlIIIIlllll) {
        int llllllllllllllIIIIIllIlIIIlIlIII = 1000;
        for (final EnumFacing llllllllllllllIIIIIllIlIIIlIIlll : EnumFacing.Plane.HORIZONTAL) {
            if (llllllllllllllIIIIIllIlIIIlIIlll != llllllllllllllIIIIIllIlIIIIlllll) {
                final BlockPos llllllllllllllIIIIIllIlIIIlIIllI = llllllllllllllIIIIIllIlIIIlIIIIl.offset(llllllllllllllIIIIIllIlIIIlIIlll);
                final IBlockState llllllllllllllIIIIIllIlIIIlIIlIl = llllllllllllllIIIIIllIlIIIlIIIlI.getBlockState(llllllllllllllIIIIIllIlIIIlIIllI);
                if (this.isBlocked(llllllllllllllIIIIIllIlIIIlIIIlI, llllllllllllllIIIIIllIlIIIlIIllI, llllllllllllllIIIIIllIlIIIlIIlIl) || (llllllllllllllIIIIIllIlIIIlIIlIl.getMaterial() == this.blockMaterial && llllllllllllllIIIIIllIlIIIlIIlIl.getValue((IProperty<Integer>)BlockDynamicLiquid.LEVEL) <= 0)) {
                    continue;
                }
                if (!this.isBlocked(llllllllllllllIIIIIllIlIIIlIIIlI, llllllllllllllIIIIIllIlIIIlIIllI.down(), llllllllllllllIIIIIllIlIIIlIIlIl)) {
                    return llllllllllllllIIIIIllIlIIIlIIIII;
                }
                if (llllllllllllllIIIIIllIlIIIlIIIII >= this.getSlopeFindDistance(llllllllllllllIIIIIllIlIIIlIIIlI)) {
                    continue;
                }
                final int llllllllllllllIIIIIllIlIIIlIIlII = this.getSlopeDistance(llllllllllllllIIIIIllIlIIIlIIIlI, llllllllllllllIIIIIllIlIIIlIIllI, llllllllllllllIIIIIllIlIIIlIIIII + 1, llllllllllllllIIIIIllIlIIIlIIlll.getOpposite());
                if (llllllllllllllIIIIIllIlIIIlIIlII >= llllllllllllllIIIIIllIlIIIlIlIII) {
                    continue;
                }
                llllllllllllllIIIIIllIlIIIlIlIII = llllllllllllllIIIIIllIlIIIlIIlII;
            }
        }
        return llllllllllllllIIIIIllIlIIIlIlIII;
    }
    
    private void tryFlowInto(final World llllllllllllllIIIIIllIlIIIllllII, final BlockPos llllllllllllllIIIIIllIlIIlIIIIII, final IBlockState llllllllllllllIIIIIllIlIIIlllIlI, final int llllllllllllllIIIIIllIlIIIlllIIl) {
        if (this.canFlowInto(llllllllllllllIIIIIllIlIIIllllII, llllllllllllllIIIIIllIlIIlIIIIII, llllllllllllllIIIIIllIlIIIlllIlI)) {
            if (llllllllllllllIIIIIllIlIIIlllIlI.getMaterial() != Material.AIR) {
                if (this.blockMaterial == Material.LAVA) {
                    this.triggerMixEffects(llllllllllllllIIIIIllIlIIIllllII, llllllllllllllIIIIIllIlIIlIIIIII);
                }
                else {
                    llllllllllllllIIIIIllIlIIIlllIlI.getBlock().dropBlockAsItem(llllllllllllllIIIIIllIlIIIllllII, llllllllllllllIIIIIllIlIIlIIIIII, llllllllllllllIIIIIllIlIIIlllIlI, 0);
                }
            }
            llllllllllllllIIIIIllIlIIIllllII.setBlockState(llllllllllllllIIIIIllIlIIlIIIIII, this.getDefaultState().withProperty((IProperty<Comparable>)BlockDynamicLiquid.LEVEL, llllllllllllllIIIIIllIlIIIlllIIl), 3);
        }
    }
}
