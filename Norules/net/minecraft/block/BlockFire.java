package net.minecraft.block;

import net.minecraft.util.math.*;
import javax.annotation.*;
import com.google.common.collect.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class BlockFire extends Block
{
    public static final /* synthetic */ PropertyInteger AGE;
    public static final /* synthetic */ PropertyBool EAST;
    private final /* synthetic */ Map<Block, Integer> encouragements;
    public static final /* synthetic */ PropertyBool SOUTH;
    public static final /* synthetic */ PropertyBool UPPER;
    public static final /* synthetic */ PropertyBool WEST;
    private final /* synthetic */ Map<Block, Integer> flammabilities;
    public static final /* synthetic */ PropertyBool NORTH;
    
    protected boolean canDie(final World lllllllllllllllIIlIlIlllIIIIIlII, final BlockPos lllllllllllllllIIlIlIlllIIIIIIll) {
        return lllllllllllllllIIlIlIlllIIIIIlII.isRainingAt(lllllllllllllllIIlIlIlllIIIIIIll) || lllllllllllllllIIlIlIlllIIIIIlII.isRainingAt(lllllllllllllllIIlIlIlllIIIIIIll.west()) || lllllllllllllllIIlIlIlllIIIIIlII.isRainingAt(lllllllllllllllIIlIlIlllIIIIIIll.east()) || lllllllllllllllIIlIlIlllIIIIIlII.isRainingAt(lllllllllllllllIIlIlIlllIIIIIIll.north()) || lllllllllllllllIIlIlIlllIIIIIlII.isRainingAt(lllllllllllllllIIlIlIlllIIIIIIll.south());
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllllIIlIlIlllIlIIlIlI, final IBlockAccess lllllllllllllllIIlIlIlllIlIIlIIl, final BlockPos lllllllllllllllIIlIlIlllIlIIlIII) {
        return BlockFire.NULL_AABB;
    }
    
    protected BlockFire() {
        super(Material.FIRE);
        this.encouragements = (Map<Block, Integer>)Maps.newIdentityHashMap();
        this.flammabilities = (Map<Block, Integer>)Maps.newIdentityHashMap();
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFire.AGE, 0).withProperty((IProperty<Comparable>)BlockFire.NORTH, false).withProperty((IProperty<Comparable>)BlockFire.EAST, false).withProperty((IProperty<Comparable>)BlockFire.SOUTH, false).withProperty((IProperty<Comparable>)BlockFire.WEST, false).withProperty((IProperty<Comparable>)BlockFire.UPPER, false));
        this.setTickRandomly(true);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFire.AGE, BlockFire.NORTH, BlockFire.EAST, BlockFire.SOUTH, BlockFire.WEST, BlockFire.UPPER });
    }
    
    public boolean canCatchFire(final IBlockAccess lllllllllllllllIIlIlIllIlIIlllll, final BlockPos lllllllllllllllIIlIlIllIlIIllllI) {
        return this.getEncouragement(lllllllllllllllIIlIlIllIlIIlllll.getBlockState(lllllllllllllllIIlIlIllIlIIllllI).getBlock()) > 0;
    }
    
    private void catchOnFire(final World lllllllllllllllIIlIlIllIlllIIlII, final BlockPos lllllllllllllllIIlIlIllIlllIIIll, final int lllllllllllllllIIlIlIllIllIlIlII, final Random lllllllllllllllIIlIlIllIllIlIIll, final int lllllllllllllllIIlIlIllIllIlllIl) {
        final int lllllllllllllllIIlIlIllIllIlllII = this.getFlammability(lllllllllllllllIIlIlIllIlllIIlII.getBlockState(lllllllllllllllIIlIlIllIlllIIIll).getBlock());
        if (lllllllllllllllIIlIlIllIllIlIIll.nextInt(lllllllllllllllIIlIlIllIllIlIlII) < lllllllllllllllIIlIlIllIllIlllII) {
            final IBlockState lllllllllllllllIIlIlIllIllIllIlI = lllllllllllllllIIlIlIllIlllIIlII.getBlockState(lllllllllllllllIIlIlIllIlllIIIll);
            if (lllllllllllllllIIlIlIllIllIlIIll.nextInt(lllllllllllllllIIlIlIllIllIlllIl + 10) < 5 && !lllllllllllllllIIlIlIllIlllIIlII.isRainingAt(lllllllllllllllIIlIlIllIlllIIIll)) {
                int lllllllllllllllIIlIlIllIllIllIIl = lllllllllllllllIIlIlIllIllIlllIl + lllllllllllllllIIlIlIllIllIlIIll.nextInt(5) / 4;
                if (lllllllllllllllIIlIlIllIllIllIIl > 15) {
                    lllllllllllllllIIlIlIllIllIllIIl = 15;
                }
                lllllllllllllllIIlIlIllIlllIIlII.setBlockState(lllllllllllllllIIlIlIllIlllIIIll, this.getDefaultState().withProperty((IProperty<Comparable>)BlockFire.AGE, lllllllllllllllIIlIlIllIllIllIIl), 3);
            }
            else {
                lllllllllllllllIIlIlIllIlllIIlII.setBlockToAir(lllllllllllllllIIlIlIllIlllIIIll);
            }
            if (lllllllllllllllIIlIlIllIllIllIlI.getBlock() == Blocks.TNT) {
                Blocks.TNT.onBlockDestroyedByPlayer(lllllllllllllllIIlIlIllIlllIIlII, lllllllllllllllIIlIlIllIlllIIIll, lllllllllllllllIIlIlIllIllIllIlI.withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true));
            }
        }
    }
    
    private int getEncouragement(final Block lllllllllllllllIIlIlIllIllllIlII) {
        final Integer lllllllllllllllIIlIlIllIllllIIll = this.encouragements.get(lllllllllllllllIIlIlIllIllllIlII);
        return (lllllllllllllllIIlIlIllIllllIIll == null) ? 0 : lllllllllllllllIIlIlIllIllllIIll;
    }
    
    @Override
    public int tickRate(final World lllllllllllllllIIlIlIlllIlIIIIII) {
        return 30;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIIlIlIlllIlIIIlII) {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIIlIlIlllIlIIIIlI) {
        return 0;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllllIIlIlIllIIlIlIIlI, final IBlockAccess lllllllllllllllIIlIlIllIIlIlIIIl, final BlockPos lllllllllllllllIIlIlIllIIlIlIIII) {
        return MapColor.TNT;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIlIlIllIIlIIIlIl) {
        return lllllllllllllllIIlIlIllIIlIIIlIl.getValue((IProperty<Integer>)BlockFire.AGE);
    }
    
    private int getNeighborEncouragement(final World lllllllllllllllIIlIlIllIlIlIlllI, final BlockPos lllllllllllllllIIlIlIllIlIlIllIl) {
        if (!lllllllllllllllIIlIlIllIlIlIlllI.isAirBlock(lllllllllllllllIIlIlIllIlIlIllIl)) {
            return 0;
        }
        int lllllllllllllllIIlIlIllIlIllIIIl = 0;
        final float lllllllllllllllIIlIlIllIlIlIlIII;
        final short lllllllllllllllIIlIlIllIlIlIlIIl = (short)((EnumFacing[])(Object)(lllllllllllllllIIlIlIllIlIlIlIII = (float)(Object)EnumFacing.values())).length;
        for (char lllllllllllllllIIlIlIllIlIlIlIlI = '\0'; lllllllllllllllIIlIlIllIlIlIlIlI < lllllllllllllllIIlIlIllIlIlIlIIl; ++lllllllllllllllIIlIlIllIlIlIlIlI) {
            final EnumFacing lllllllllllllllIIlIlIllIlIllIIII = lllllllllllllllIIlIlIllIlIlIlIII[lllllllllllllllIIlIlIllIlIlIlIlI];
            lllllllllllllllIIlIlIllIlIllIIIl = Math.max(this.getEncouragement(lllllllllllllllIIlIlIllIlIlIlllI.getBlockState(lllllllllllllllIIlIlIllIlIlIllIl.offset(lllllllllllllllIIlIlIllIlIllIIII)).getBlock()), lllllllllllllllIIlIlIllIlIllIIIl);
        }
        return lllllllllllllllIIlIlIllIlIllIIIl;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIIlIlIllIIlIIIIII, final IBlockState lllllllllllllllIIlIlIllIIIllllll, final BlockPos lllllllllllllllIIlIlIllIIIlllllI, final EnumFacing lllllllllllllllIIlIlIllIIIllllIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllIIlIlIlllIllIIIIl, final IBlockAccess lllllllllllllllIIlIlIlllIllIIIII, final BlockPos lllllllllllllllIIlIlIlllIlIlllll) {
        return (!lllllllllllllllIIlIlIlllIllIIIII.getBlockState(lllllllllllllllIIlIlIlllIlIlllll.down()).isFullyOpaque() && !Blocks.FIRE.canCatchFire(lllllllllllllllIIlIlIlllIllIIIII, lllllllllllllllIIlIlIlllIlIlllll.down())) ? lllllllllllllllIIlIlIlllIllIIIIl.withProperty((IProperty<Comparable>)BlockFire.NORTH, this.canCatchFire(lllllllllllllllIIlIlIlllIllIIIII, lllllllllllllllIIlIlIlllIlIlllll.north())).withProperty((IProperty<Comparable>)BlockFire.EAST, this.canCatchFire(lllllllllllllllIIlIlIlllIllIIIII, lllllllllllllllIIlIlIlllIlIlllll.east())).withProperty((IProperty<Comparable>)BlockFire.SOUTH, this.canCatchFire(lllllllllllllllIIlIlIlllIllIIIII, lllllllllllllllIIlIlIlllIlIlllll.south())).withProperty((IProperty<Comparable>)BlockFire.WEST, this.canCatchFire(lllllllllllllllIIlIlIlllIllIIIII, lllllllllllllllIIlIlIlllIlIlllll.west())).withProperty((IProperty<Comparable>)BlockFire.UPPER, this.canCatchFire(lllllllllllllllIIlIlIlllIllIIIII, lllllllllllllllIIlIlIlllIlIlllll.up())) : this.getDefaultState();
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllIIlIlIllIlIIllIIl, final BlockPos lllllllllllllllIIlIlIllIlIIllIII) {
        return lllllllllllllllIIlIlIllIlIIllIIl.getBlockState(lllllllllllllllIIlIlIllIlIIllIII.down()).isFullyOpaque() || this.canNeighborCatchFire(lllllllllllllllIIlIlIllIlIIllIIl, lllllllllllllllIIlIlIllIlIIllIII);
    }
    
    @Override
    public void updateTick(final World lllllllllllllllIIlIlIlllIIlIllII, final BlockPos lllllllllllllllIIlIlIlllIIlIlIll, IBlockState lllllllllllllllIIlIlIlllIIIllIII, final Random lllllllllllllllIIlIlIlllIIIlIlll) {
        if (lllllllllllllllIIlIlIlllIIlIllII.getGameRules().getBoolean("doFireTick")) {
            if (!this.canPlaceBlockAt(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll)) {
                lllllllllllllllIIlIlIlllIIlIllII.setBlockToAir(lllllllllllllllIIlIlIlllIIlIlIll);
            }
            final Block lllllllllllllllIIlIlIlllIIlIlIII = lllllllllllllllIIlIlIlllIIlIllII.getBlockState(lllllllllllllllIIlIlIlllIIlIlIll.down()).getBlock();
            boolean lllllllllllllllIIlIlIlllIIlIIlll = lllllllllllllllIIlIlIlllIIlIlIII == Blocks.NETHERRACK || lllllllllllllllIIlIlIlllIIlIlIII == Blocks.MAGMA;
            if (lllllllllllllllIIlIlIlllIIlIllII.provider instanceof WorldProviderEnd && lllllllllllllllIIlIlIlllIIlIlIII == Blocks.BEDROCK) {
                lllllllllllllllIIlIlIlllIIlIIlll = true;
            }
            final int lllllllllllllllIIlIlIlllIIlIIllI = lllllllllllllllIIlIlIlllIIIllIII.getValue((IProperty<Integer>)BlockFire.AGE);
            if (!lllllllllllllllIIlIlIlllIIlIIlll && lllllllllllllllIIlIlIlllIIlIllII.isRaining() && this.canDie(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll) && lllllllllllllllIIlIlIlllIIIlIlll.nextFloat() < 0.2f + lllllllllllllllIIlIlIlllIIlIIllI * 0.03f) {
                lllllllllllllllIIlIlIlllIIlIllII.setBlockToAir(lllllllllllllllIIlIlIlllIIlIlIll);
            }
            else {
                if (lllllllllllllllIIlIlIlllIIlIIllI < 15) {
                    lllllllllllllllIIlIlIlllIIIllIII = lllllllllllllllIIlIlIlllIIIllIII.withProperty((IProperty<Comparable>)BlockFire.AGE, lllllllllllllllIIlIlIlllIIlIIllI + lllllllllllllllIIlIlIlllIIIlIlll.nextInt(3) / 2);
                    lllllllllllllllIIlIlIlllIIlIllII.setBlockState(lllllllllllllllIIlIlIlllIIlIlIll, lllllllllllllllIIlIlIlllIIIllIII, 4);
                }
                lllllllllllllllIIlIlIlllIIlIllII.scheduleUpdate(lllllllllllllllIIlIlIlllIIlIlIll, this, this.tickRate(lllllllllllllllIIlIlIlllIIlIllII) + lllllllllllllllIIlIlIlllIIIlIlll.nextInt(10));
                if (!lllllllllllllllIIlIlIlllIIlIIlll) {
                    if (!this.canNeighborCatchFire(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll)) {
                        if (!lllllllllllllllIIlIlIlllIIlIllII.getBlockState(lllllllllllllllIIlIlIlllIIlIlIll.down()).isFullyOpaque() || lllllllllllllllIIlIlIlllIIlIIllI > 3) {
                            lllllllllllllllIIlIlIlllIIlIllII.setBlockToAir(lllllllllllllllIIlIlIlllIIlIlIll);
                        }
                        return;
                    }
                    if (!this.canCatchFire(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll.down()) && lllllllllllllllIIlIlIlllIIlIIllI == 15 && lllllllllllllllIIlIlIlllIIIlIlll.nextInt(4) == 0) {
                        lllllllllllllllIIlIlIlllIIlIllII.setBlockToAir(lllllllllllllllIIlIlIlllIIlIlIll);
                        return;
                    }
                }
                final boolean lllllllllllllllIIlIlIlllIIlIIlIl = lllllllllllllllIIlIlIlllIIlIllII.isBlockinHighHumidity(lllllllllllllllIIlIlIlllIIlIlIll);
                int lllllllllllllllIIlIlIlllIIlIIlII = 0;
                if (lllllllllllllllIIlIlIlllIIlIIlIl) {
                    lllllllllllllllIIlIlIlllIIlIIlII = -50;
                }
                this.catchOnFire(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll.east(), 300 + lllllllllllllllIIlIlIlllIIlIIlII, lllllllllllllllIIlIlIlllIIIlIlll, lllllllllllllllIIlIlIlllIIlIIllI);
                this.catchOnFire(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll.west(), 300 + lllllllllllllllIIlIlIlllIIlIIlII, lllllllllllllllIIlIlIlllIIIlIlll, lllllllllllllllIIlIlIlllIIlIIllI);
                this.catchOnFire(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll.down(), 250 + lllllllllllllllIIlIlIlllIIlIIlII, lllllllllllllllIIlIlIlllIIIlIlll, lllllllllllllllIIlIlIlllIIlIIllI);
                this.catchOnFire(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll.up(), 250 + lllllllllllllllIIlIlIlllIIlIIlII, lllllllllllllllIIlIlIlllIIIlIlll, lllllllllllllllIIlIlIlllIIlIIllI);
                this.catchOnFire(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll.north(), 300 + lllllllllllllllIIlIlIlllIIlIIlII, lllllllllllllllIIlIlIlllIIIlIlll, lllllllllllllllIIlIlIlllIIlIIllI);
                this.catchOnFire(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIlIlIll.south(), 300 + lllllllllllllllIIlIlIlllIIlIIlII, lllllllllllllllIIlIlIlllIIIlIlll, lllllllllllllllIIlIlIlllIIlIIllI);
                for (int lllllllllllllllIIlIlIlllIIlIIIll = -1; lllllllllllllllIIlIlIlllIIlIIIll <= 1; ++lllllllllllllllIIlIlIlllIIlIIIll) {
                    for (int lllllllllllllllIIlIlIlllIIlIIIlI = -1; lllllllllllllllIIlIlIlllIIlIIIlI <= 1; ++lllllllllllllllIIlIlIlllIIlIIIlI) {
                        for (int lllllllllllllllIIlIlIlllIIlIIIIl = -1; lllllllllllllllIIlIlIlllIIlIIIIl <= 4; ++lllllllllllllllIIlIlIlllIIlIIIIl) {
                            if (lllllllllllllllIIlIlIlllIIlIIIll != 0 || lllllllllllllllIIlIlIlllIIlIIIIl != 0 || lllllllllllllllIIlIlIlllIIlIIIlI != 0) {
                                int lllllllllllllllIIlIlIlllIIlIIIII = 100;
                                if (lllllllllllllllIIlIlIlllIIlIIIIl > 1) {
                                    lllllllllllllllIIlIlIlllIIlIIIII += (lllllllllllllllIIlIlIlllIIlIIIIl - 1) * 100;
                                }
                                final BlockPos lllllllllllllllIIlIlIlllIIIlllll = lllllllllllllllIIlIlIlllIIlIlIll.add(lllllllllllllllIIlIlIlllIIlIIIll, lllllllllllllllIIlIlIlllIIlIIIIl, lllllllllllllllIIlIlIlllIIlIIIlI);
                                final int lllllllllllllllIIlIlIlllIIIllllI = this.getNeighborEncouragement(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIIlllll);
                                if (lllllllllllllllIIlIlIlllIIIllllI > 0) {
                                    int lllllllllllllllIIlIlIlllIIIlllIl = (lllllllllllllllIIlIlIlllIIIllllI + 40 + lllllllllllllllIIlIlIlllIIlIllII.getDifficulty().getDifficultyId() * 7) / (lllllllllllllllIIlIlIlllIIlIIllI + 30);
                                    if (lllllllllllllllIIlIlIlllIIlIIlIl) {
                                        lllllllllllllllIIlIlIlllIIIlllIl /= 2;
                                    }
                                    if (lllllllllllllllIIlIlIlllIIIlllIl > 0 && lllllllllllllllIIlIlIlllIIIlIlll.nextInt(lllllllllllllllIIlIlIlllIIlIIIII) <= lllllllllllllllIIlIlIlllIIIlllIl && (!lllllllllllllllIIlIlIlllIIlIllII.isRaining() || !this.canDie(lllllllllllllllIIlIlIlllIIlIllII, lllllllllllllllIIlIlIlllIIIlllll))) {
                                        int lllllllllllllllIIlIlIlllIIIlllII = lllllllllllllllIIlIlIlllIIlIIllI + lllllllllllllllIIlIlIlllIIIlIlll.nextInt(5) / 4;
                                        if (lllllllllllllllIIlIlIlllIIIlllII > 15) {
                                            lllllllllllllllIIlIlIlllIIIlllII = 15;
                                        }
                                        lllllllllllllllIIlIlIlllIIlIllII.setBlockState(lllllllllllllllIIlIlIlllIIIlllll, lllllllllllllllIIlIlIlllIIIllIII.withProperty((IProperty<Comparable>)BlockFire.AGE, lllllllllllllllIIlIlIlllIIIlllII), 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 15);
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        UPPER = PropertyBool.create("up");
    }
    
    public void setFireInfo(final Block lllllllllllllllIIlIlIlllIlIIlllI, final int lllllllllllllllIIlIlIlllIlIIllIl, final int lllllllllllllllIIlIlIlllIlIlIIII) {
        this.encouragements.put(lllllllllllllllIIlIlIlllIlIIlllI, lllllllllllllllIIlIlIlllIlIIllIl);
        this.flammabilities.put(lllllllllllllllIIlIlIlllIlIIlllI, lllllllllllllllIIlIlIlllIlIlIIII);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllIIlIlIllIlIIlIIII, final World lllllllllllllllIIlIlIllIlIIIllll, final BlockPos lllllllllllllllIIlIlIllIlIIIlIIl, final Block lllllllllllllllIIlIlIllIlIIIllIl, final BlockPos lllllllllllllllIIlIlIllIlIIIllII) {
        if (!lllllllllllllllIIlIlIllIlIIIllll.getBlockState(lllllllllllllllIIlIlIllIlIIIlIIl.down()).isFullyOpaque() && !this.canNeighborCatchFire(lllllllllllllllIIlIlIllIlIIIllll, lllllllllllllllIIlIlIllIlIIIlIIl)) {
            lllllllllllllllIIlIlIllIlIIIllll.setBlockToAir(lllllllllllllllIIlIlIllIlIIIlIIl);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIIlIlIllIIlIIlIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFire.AGE, lllllllllllllllIIlIlIllIIlIIlIll);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIIlIlIlllIlIIIllI) {
        return false;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIIlIlIllIlIIIIIII, final BlockPos lllllllllllllllIIlIlIllIIlllllll, final IBlockState lllllllllllllllIIlIlIllIlIIIIIlI) {
        if (lllllllllllllllIIlIlIllIlIIIIIII.provider.getDimensionType().getId() > 0 || !Blocks.PORTAL.trySpawnPortal(lllllllllllllllIIlIlIllIlIIIIIII, lllllllllllllllIIlIlIllIIlllllll)) {
            if (!lllllllllllllllIIlIlIllIlIIIIIII.getBlockState(lllllllllllllllIIlIlIllIIlllllll.down()).isFullyOpaque() && !this.canNeighborCatchFire(lllllllllllllllIIlIlIllIlIIIIIII, lllllllllllllllIIlIlIllIIlllllll)) {
                lllllllllllllllIIlIlIllIlIIIIIII.setBlockToAir(lllllllllllllllIIlIlIllIIlllllll);
            }
            else {
                lllllllllllllllIIlIlIllIlIIIIIII.scheduleUpdate(lllllllllllllllIIlIlIllIIlllllll, this, this.tickRate(lllllllllllllllIIlIlIllIlIIIIIII) + lllllllllllllllIIlIlIllIlIIIIIII.rand.nextInt(10));
            }
        }
    }
    
    @Override
    public boolean isCollidable() {
        return false;
    }
    
    private boolean canNeighborCatchFire(final World lllllllllllllllIIlIlIllIllIIIllI, final BlockPos lllllllllllllllIIlIlIllIllIIIIIl) {
        long lllllllllllllllIIlIlIllIlIllllIl;
        for (short lllllllllllllllIIlIlIllIlIlllllI = (short)((EnumFacing[])(Object)(lllllllllllllllIIlIlIllIlIllllIl = (long)(Object)EnumFacing.values())).length, lllllllllllllllIIlIlIllIlIllllll = 0; lllllllllllllllIIlIlIllIlIllllll < lllllllllllllllIIlIlIllIlIlllllI; ++lllllllllllllllIIlIlIllIlIllllll) {
            final EnumFacing lllllllllllllllIIlIlIllIllIIIlII = lllllllllllllllIIlIlIllIlIllllIl[lllllllllllllllIIlIlIllIlIllllll];
            if (this.canCatchFire(lllllllllllllllIIlIlIllIllIIIllI, lllllllllllllllIIlIlIllIllIIIIIl.offset(lllllllllllllllIIlIlIllIllIIIlII))) {
                return true;
            }
        }
        return false;
    }
    
    private int getFlammability(final Block lllllllllllllllIIlIlIllIllllllIl) {
        final Integer lllllllllllllllIIlIlIllIllllllII = this.flammabilities.get(lllllllllllllllIIlIlIllIllllllIl);
        return (lllllllllllllllIIlIlIllIllllllII == null) ? 0 : lllllllllllllllIIlIlIllIllllllII;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllllIIlIlIllIIlllIllI, final World lllllllllllllllIIlIlIllIIlllIlIl, final BlockPos lllllllllllllllIIlIlIllIIlIllIIl, final Random lllllllllllllllIIlIlIllIIlIllIII) {
        if (lllllllllllllllIIlIlIllIIlIllIII.nextInt(24) == 0) {
            lllllllllllllllIIlIlIllIIlllIlIl.playSound(lllllllllllllllIIlIlIllIIlIllIIl.getX() + 0.5f, lllllllllllllllIIlIlIllIIlIllIIl.getY() + 0.5f, lllllllllllllllIIlIlIllIIlIllIIl.getZ() + 0.5f, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0f + lllllllllllllllIIlIlIllIIlIllIII.nextFloat(), lllllllllllllllIIlIlIllIIlIllIII.nextFloat() * 0.7f + 0.3f, false);
        }
        if (!lllllllllllllllIIlIlIllIIlllIlIl.getBlockState(lllllllllllllllIIlIlIllIIlIllIIl.down()).isFullyOpaque() && !Blocks.FIRE.canCatchFire(lllllllllllllllIIlIlIllIIlllIlIl, lllllllllllllllIIlIlIllIIlIllIIl.down())) {
            if (Blocks.FIRE.canCatchFire(lllllllllllllllIIlIlIllIIlllIlIl, lllllllllllllllIIlIlIllIIlIllIIl.west())) {
                for (int lllllllllllllllIIlIlIllIIlllIIlI = 0; lllllllllllllllIIlIlIllIIlllIIlI < 2; ++lllllllllllllllIIlIlIllIIlllIIlI) {
                    final double lllllllllllllllIIlIlIllIIlllIIIl = lllllllllllllllIIlIlIllIIlIllIIl.getX() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble() * 0.10000000149011612;
                    final double lllllllllllllllIIlIlIllIIlllIIII = lllllllllllllllIIlIlIllIIlIllIIl.getY() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    final double lllllllllllllllIIlIlIllIIllIllll = lllllllllllllllIIlIlIllIIlIllIIl.getZ() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    lllllllllllllllIIlIlIllIIlllIlIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllllIIlIlIllIIlllIIIl, lllllllllllllllIIlIlIllIIlllIIII, lllllllllllllllIIlIlIllIIllIllll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.FIRE.canCatchFire(lllllllllllllllIIlIlIllIIlllIlIl, lllllllllllllllIIlIlIllIIlIllIIl.east())) {
                for (int lllllllllllllllIIlIlIllIIllIlllI = 0; lllllllllllllllIIlIlIllIIllIlllI < 2; ++lllllllllllllllIIlIlIllIIllIlllI) {
                    final double lllllllllllllllIIlIlIllIIllIllIl = lllllllllllllllIIlIlIllIIlIllIIl.getX() + 1 - lllllllllllllllIIlIlIllIIlIllIII.nextDouble() * 0.10000000149011612;
                    final double lllllllllllllllIIlIlIllIIllIllII = lllllllllllllllIIlIlIllIIlIllIIl.getY() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    final double lllllllllllllllIIlIlIllIIllIlIll = lllllllllllllllIIlIlIllIIlIllIIl.getZ() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    lllllllllllllllIIlIlIllIIlllIlIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllllIIlIlIllIIllIllIl, lllllllllllllllIIlIlIllIIllIllII, lllllllllllllllIIlIlIllIIllIlIll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.FIRE.canCatchFire(lllllllllllllllIIlIlIllIIlllIlIl, lllllllllllllllIIlIlIllIIlIllIIl.north())) {
                for (int lllllllllllllllIIlIlIllIIllIlIlI = 0; lllllllllllllllIIlIlIllIIllIlIlI < 2; ++lllllllllllllllIIlIlIllIIllIlIlI) {
                    final double lllllllllllllllIIlIlIllIIllIlIIl = lllllllllllllllIIlIlIllIIlIllIIl.getX() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    final double lllllllllllllllIIlIlIllIIllIlIII = lllllllllllllllIIlIlIllIIlIllIIl.getY() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    final double lllllllllllllllIIlIlIllIIllIIlll = lllllllllllllllIIlIlIllIIlIllIIl.getZ() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble() * 0.10000000149011612;
                    lllllllllllllllIIlIlIllIIlllIlIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllllIIlIlIllIIllIlIIl, lllllllllllllllIIlIlIllIIllIlIII, lllllllllllllllIIlIlIllIIllIIlll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.FIRE.canCatchFire(lllllllllllllllIIlIlIllIIlllIlIl, lllllllllllllllIIlIlIllIIlIllIIl.south())) {
                for (int lllllllllllllllIIlIlIllIIllIIllI = 0; lllllllllllllllIIlIlIllIIllIIllI < 2; ++lllllllllllllllIIlIlIllIIllIIllI) {
                    final double lllllllllllllllIIlIlIllIIllIIlIl = lllllllllllllllIIlIlIllIIlIllIIl.getX() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    final double lllllllllllllllIIlIlIllIIllIIlII = lllllllllllllllIIlIlIllIIlIllIIl.getY() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    final double lllllllllllllllIIlIlIllIIllIIIll = lllllllllllllllIIlIlIllIIlIllIIl.getZ() + 1 - lllllllllllllllIIlIlIllIIlIllIII.nextDouble() * 0.10000000149011612;
                    lllllllllllllllIIlIlIllIIlllIlIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllllIIlIlIllIIllIIlIl, lllllllllllllllIIlIlIllIIllIIlII, lllllllllllllllIIlIlIllIIllIIIll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            if (Blocks.FIRE.canCatchFire(lllllllllllllllIIlIlIllIIlllIlIl, lllllllllllllllIIlIlIllIIlIllIIl.up())) {
                for (int lllllllllllllllIIlIlIllIIllIIIlI = 0; lllllllllllllllIIlIlIllIIllIIIlI < 2; ++lllllllllllllllIIlIlIllIIllIIIlI) {
                    final double lllllllllllllllIIlIlIllIIllIIIIl = lllllllllllllllIIlIlIllIIlIllIIl.getX() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    final double lllllllllllllllIIlIlIllIIllIIIII = lllllllllllllllIIlIlIllIIlIllIIl.getY() + 1 - lllllllllllllllIIlIlIllIIlIllIII.nextDouble() * 0.10000000149011612;
                    final double lllllllllllllllIIlIlIllIIlIlllll = lllllllllllllllIIlIlIllIIlIllIIl.getZ() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                    lllllllllllllllIIlIlIllIIlllIlIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllllIIlIlIllIIllIIIIl, lllllllllllllllIIlIlIllIIllIIIII, lllllllllllllllIIlIlIllIIlIlllll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
        }
        else {
            for (int lllllllllllllllIIlIlIllIIlIllllI = 0; lllllllllllllllIIlIlIllIIlIllllI < 3; ++lllllllllllllllIIlIlIllIIlIllllI) {
                final double lllllllllllllllIIlIlIllIIlIlllIl = lllllllllllllllIIlIlIllIIlIllIIl.getX() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                final double lllllllllllllllIIlIlIllIIlIlllII = lllllllllllllllIIlIlIllIIlIllIIl.getY() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble() * 0.5 + 0.5;
                final double lllllllllllllllIIlIlIllIIlIllIll = lllllllllllllllIIlIlIllIIlIllIIl.getZ() + lllllllllllllllIIlIlIllIIlIllIII.nextDouble();
                lllllllllllllllIIlIlIllIIlllIlIl.spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllllIIlIlIllIIlIlllIl, lllllllllllllllIIlIlIllIIlIlllII, lllllllllllllllIIlIlIllIIlIllIll, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    public static void init() {
        Blocks.FIRE.setFireInfo(Blocks.PLANKS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.DOUBLE_WOODEN_SLAB, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.WOODEN_SLAB, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.OAK_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.SPRUCE_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.BIRCH_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.JUNGLE_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.DARK_OAK_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.ACACIA_FENCE_GATE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.OAK_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.SPRUCE_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.BIRCH_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.JUNGLE_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.DARK_OAK_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.ACACIA_FENCE, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.OAK_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.BIRCH_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.SPRUCE_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.JUNGLE_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.ACACIA_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.DARK_OAK_STAIRS, 5, 20);
        Blocks.FIRE.setFireInfo(Blocks.LOG, 5, 5);
        Blocks.FIRE.setFireInfo(Blocks.LOG2, 5, 5);
        Blocks.FIRE.setFireInfo(Blocks.LEAVES, 30, 60);
        Blocks.FIRE.setFireInfo(Blocks.LEAVES2, 30, 60);
        Blocks.FIRE.setFireInfo(Blocks.BOOKSHELF, 30, 20);
        Blocks.FIRE.setFireInfo(Blocks.TNT, 15, 100);
        Blocks.FIRE.setFireInfo(Blocks.TALLGRASS, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.DOUBLE_PLANT, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.YELLOW_FLOWER, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.RED_FLOWER, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.DEADBUSH, 60, 100);
        Blocks.FIRE.setFireInfo(Blocks.WOOL, 30, 60);
        Blocks.FIRE.setFireInfo(Blocks.VINE, 15, 100);
        Blocks.FIRE.setFireInfo(Blocks.COAL_BLOCK, 5, 5);
        Blocks.FIRE.setFireInfo(Blocks.HAY_BLOCK, 60, 20);
        Blocks.FIRE.setFireInfo(Blocks.CARPET, 60, 20);
    }
    
    @Override
    public boolean requiresUpdates() {
        return false;
    }
}
