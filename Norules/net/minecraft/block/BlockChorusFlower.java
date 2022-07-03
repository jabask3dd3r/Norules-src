package net.minecraft.block;

import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;

public class BlockChorusFlower extends Block
{
    public static final /* synthetic */ PropertyInteger AGE;
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIlllIIIllIIIIIIlII) {
        return false;
    }
    
    @Override
    public void updateTick(final World lllllllllllllIIlllIIIllIIIllIlll, final BlockPos lllllllllllllIIlllIIIllIIlIIlIlI, final IBlockState lllllllllllllIIlllIIIllIIlIIlIIl, final Random lllllllllllllIIlllIIIllIIIllIlII) {
        if (!this.canSurvive(lllllllllllllIIlllIIIllIIIllIlll, lllllllllllllIIlllIIIllIIlIIlIlI)) {
            lllllllllllllIIlllIIIllIIIllIlll.destroyBlock(lllllllllllllIIlllIIIllIIlIIlIlI, true);
        }
        else {
            final BlockPos lllllllllllllIIlllIIIllIIlIIIlll = lllllllllllllIIlllIIIllIIlIIlIlI.up();
            if (lllllllllllllIIlllIIIllIIIllIlll.isAirBlock(lllllllllllllIIlllIIIllIIlIIIlll) && lllllllllllllIIlllIIIllIIlIIIlll.getY() < 256) {
                final int lllllllllllllIIlllIIIllIIlIIIllI = lllllllllllllIIlllIIIllIIlIIlIIl.getValue((IProperty<Integer>)BlockChorusFlower.AGE);
                if (lllllllllllllIIlllIIIllIIlIIIllI < 5 && lllllllllllllIIlllIIIllIIIllIlII.nextInt(1) == 0) {
                    boolean lllllllllllllIIlllIIIllIIlIIIlIl = false;
                    boolean lllllllllllllIIlllIIIllIIlIIIlII = false;
                    final IBlockState lllllllllllllIIlllIIIllIIlIIIIll = lllllllllllllIIlllIIIllIIIllIlll.getBlockState(lllllllllllllIIlllIIIllIIlIIlIlI.down());
                    final Block lllllllllllllIIlllIIIllIIlIIIIlI = lllllllllllllIIlllIIIllIIlIIIIll.getBlock();
                    if (lllllllllllllIIlllIIIllIIlIIIIlI == Blocks.END_STONE) {
                        lllllllllllllIIlllIIIllIIlIIIlIl = true;
                    }
                    else if (lllllllllllllIIlllIIIllIIlIIIIlI == Blocks.CHORUS_PLANT) {
                        int lllllllllllllIIlllIIIllIIlIIIIIl = 1;
                        int lllllllllllllIIlllIIIllIIlIIIIII = 0;
                        while (lllllllllllllIIlllIIIllIIlIIIIII < 4) {
                            final Block lllllllllllllIIlllIIIllIIIllllll = lllllllllllllIIlllIIIllIIIllIlll.getBlockState(lllllllllllllIIlllIIIllIIlIIlIlI.down(lllllllllllllIIlllIIIllIIlIIIIIl + 1)).getBlock();
                            if (lllllllllllllIIlllIIIllIIIllllll != Blocks.CHORUS_PLANT) {
                                if (lllllllllllllIIlllIIIllIIIllllll == Blocks.END_STONE) {
                                    lllllllllllllIIlllIIIllIIlIIIlII = true;
                                    break;
                                }
                                break;
                            }
                            else {
                                ++lllllllllllllIIlllIIIllIIlIIIIIl;
                                ++lllllllllllllIIlllIIIllIIlIIIIII;
                            }
                        }
                        int lllllllllllllIIlllIIIllIIIlllllI = 4;
                        if (lllllllllllllIIlllIIIllIIlIIIlII) {
                            ++lllllllllllllIIlllIIIllIIIlllllI;
                        }
                        if (lllllllllllllIIlllIIIllIIlIIIIIl < 2 || lllllllllllllIIlllIIIllIIIllIlII.nextInt(lllllllllllllIIlllIIIllIIIlllllI) >= lllllllllllllIIlllIIIllIIlIIIIIl) {
                            lllllllllllllIIlllIIIllIIlIIIlIl = true;
                        }
                    }
                    else if (lllllllllllllIIlllIIIllIIlIIIIll.getMaterial() == Material.AIR) {
                        lllllllllllllIIlllIIIllIIlIIIlIl = true;
                    }
                    if (lllllllllllllIIlllIIIllIIlIIIlIl && areAllNeighborsEmpty(lllllllllllllIIlllIIIllIIIllIlll, lllllllllllllIIlllIIIllIIlIIIlll, null) && lllllllllllllIIlllIIIllIIIllIlll.isAirBlock(lllllllllllllIIlllIIIllIIlIIlIlI.up(2))) {
                        lllllllllllllIIlllIIIllIIIllIlll.setBlockState(lllllllllllllIIlllIIIllIIlIIlIlI, Blocks.CHORUS_PLANT.getDefaultState(), 2);
                        this.placeGrownFlower(lllllllllllllIIlllIIIllIIIllIlll, lllllllllllllIIlllIIIllIIlIIIlll, lllllllllllllIIlllIIIllIIlIIIllI);
                    }
                    else if (lllllllllllllIIlllIIIllIIlIIIllI < 4) {
                        int lllllllllllllIIlllIIIllIIIllllIl = lllllllllllllIIlllIIIllIIIllIlII.nextInt(4);
                        boolean lllllllllllllIIlllIIIllIIIllllII = false;
                        if (lllllllllllllIIlllIIIllIIlIIIlII) {
                            ++lllllllllllllIIlllIIIllIIIllllIl;
                        }
                        for (int lllllllllllllIIlllIIIllIIIlllIll = 0; lllllllllllllIIlllIIIllIIIlllIll < lllllllllllllIIlllIIIllIIIllllIl; ++lllllllllllllIIlllIIIllIIIlllIll) {
                            final EnumFacing lllllllllllllIIlllIIIllIIIlllIlI = EnumFacing.Plane.HORIZONTAL.random(lllllllllllllIIlllIIIllIIIllIlII);
                            final BlockPos lllllllllllllIIlllIIIllIIIlllIIl = lllllllllllllIIlllIIIllIIlIIlIlI.offset(lllllllllllllIIlllIIIllIIIlllIlI);
                            if (lllllllllllllIIlllIIIllIIIllIlll.isAirBlock(lllllllllllllIIlllIIIllIIIlllIIl) && lllllllllllllIIlllIIIllIIIllIlll.isAirBlock(lllllllllllllIIlllIIIllIIIlllIIl.down()) && areAllNeighborsEmpty(lllllllllllllIIlllIIIllIIIllIlll, lllllllllllllIIlllIIIllIIIlllIIl, lllllllllllllIIlllIIIllIIIlllIlI.getOpposite())) {
                                this.placeGrownFlower(lllllllllllllIIlllIIIllIIIllIlll, lllllllllllllIIlllIIIllIIIlllIIl, lllllllllllllIIlllIIIllIIlIIIllI + 1);
                                lllllllllllllIIlllIIIllIIIllllII = true;
                            }
                        }
                        if (lllllllllllllIIlllIIIllIIIllllII) {
                            lllllllllllllIIlllIIIllIIIllIlll.setBlockState(lllllllllllllIIlllIIIllIIlIIlIlI, Blocks.CHORUS_PLANT.getDefaultState(), 2);
                        }
                        else {
                            this.placeDeadFlower(lllllllllllllIIlllIIIllIIIllIlll, lllllllllllllIIlllIIIllIIlIIlIlI);
                        }
                    }
                    else if (lllllllllllllIIlllIIIllIIlIIIllI == 4) {
                        this.placeDeadFlower(lllllllllllllIIlllIIIllIIIllIlll, lllllllllllllIIlllIIIllIIlIIlIlI);
                    }
                }
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIlllIIIlIllIllIIII) {
        return lllllllllllllIIlllIIIlIllIllIIII.getValue((IProperty<Integer>)BlockChorusFlower.AGE);
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    private void placeDeadFlower(final World lllllllllllllIIlllIIIllIIIIllIII, final BlockPos lllllllllllllIIlllIIIllIIIIlIlII) {
        lllllllllllllIIlllIIIllIIIIllIII.setBlockState(lllllllllllllIIlllIIIllIIIIlIlII, this.getDefaultState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, 5), 2);
        lllllllllllllIIlllIIIllIIIIllIII.playEvent(1034, lllllllllllllIIlllIIIllIIIIlIlII, 0);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIlllIIIlIllIllIllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, lllllllllllllIIlllIIIlIllIllIllI);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIlllIIIlIlllllIlII, final World lllllllllllllIIlllIIIlIllllIlllI, final BlockPos lllllllllllllIIlllIIIlIllllIllIl, final Block lllllllllllllIIlllIIIlIlllllIIIl, final BlockPos lllllllllllllIIlllIIIlIlllllIIII) {
        if (!this.canSurvive(lllllllllllllIIlllIIIlIllllIlllI, lllllllllllllIIlllIIIlIllllIllIl)) {
            lllllllllllllIIlllIIIlIllllIlllI.scheduleUpdate(lllllllllllllIIlllIIIlIllllIllIl, this, 1);
        }
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllIIlllIIIlIlllIIIIlI, final EntityPlayer lllllllllllllIIlllIIIlIlllIIlIII, final BlockPos lllllllllllllIIlllIIIlIlllIIIlll, final IBlockState lllllllllllllIIlllIIIlIlllIIIllI, @Nullable final TileEntity lllllllllllllIIlllIIIlIlllIIIlIl, final ItemStack lllllllllllllIIlllIIIlIlllIIIlII) {
        super.harvestBlock(lllllllllllllIIlllIIIlIlllIIIIlI, lllllllllllllIIlllIIIlIlllIIlIII, lllllllllllllIIlllIIIlIlllIIIlll, lllllllllllllIIlllIIIlIlllIIIllI, lllllllllllllIIlllIIIlIlllIIIlIl, lllllllllllllIIlllIIIlIlllIIIlII);
        Block.spawnAsEntity(lllllllllllllIIlllIIIlIlllIIIIlI, lllllllllllllIIlllIIIlIlllIIIlll, new ItemStack(Item.getItemFromBlock(this)));
    }
    
    protected BlockChorusFlower() {
        super(Material.PLANTS, MapColor.PURPLE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, 0));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setTickRandomly(true);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockChorusFlower.AGE });
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIlllIIIllIIlIlllll, final Random lllllllllllllIIlllIIIllIIlIllllI, final int lllllllllllllIIlllIIIllIIlIlllIl) {
        return Items.field_190931_a;
    }
    
    private static void growTreeRecursive(final World lllllllllllllIIlllIIIlIllIIlIlII, final BlockPos lllllllllllllIIlllIIIlIllIIlIIll, final Random lllllllllllllIIlllIIIlIllIIIIlII, final BlockPos lllllllllllllIIlllIIIlIllIIIIIll, final int lllllllllllllIIlllIIIlIllIIlIIII, final int lllllllllllllIIlllIIIlIllIIIIIIl) {
        int lllllllllllllIIlllIIIlIllIIIlllI = lllllllllllllIIlllIIIlIllIIIIlII.nextInt(4) + 1;
        if (lllllllllllllIIlllIIIlIllIIIIIIl == 0) {
            ++lllllllllllllIIlllIIIlIllIIIlllI;
        }
        for (int lllllllllllllIIlllIIIlIllIIIllIl = 0; lllllllllllllIIlllIIIlIllIIIllIl < lllllllllllllIIlllIIIlIllIIIlllI; ++lllllllllllllIIlllIIIlIllIIIllIl) {
            final BlockPos lllllllllllllIIlllIIIlIllIIIllII = lllllllllllllIIlllIIIlIllIIlIIll.up(lllllllllllllIIlllIIIlIllIIIllIl + 1);
            if (!areAllNeighborsEmpty(lllllllllllllIIlllIIIlIllIIlIlII, lllllllllllllIIlllIIIlIllIIIllII, null)) {
                return;
            }
            lllllllllllllIIlllIIIlIllIIlIlII.setBlockState(lllllllllllllIIlllIIIlIllIIIllII, Blocks.CHORUS_PLANT.getDefaultState(), 2);
        }
        boolean lllllllllllllIIlllIIIlIllIIIlIll = false;
        if (lllllllllllllIIlllIIIlIllIIIIIIl < 4) {
            int lllllllllllllIIlllIIIlIllIIIlIlI = lllllllllllllIIlllIIIlIllIIIIlII.nextInt(4);
            if (lllllllllllllIIlllIIIlIllIIIIIIl == 0) {
                ++lllllllllllllIIlllIIIlIllIIIlIlI;
            }
            for (int lllllllllllllIIlllIIIlIllIIIlIIl = 0; lllllllllllllIIlllIIIlIllIIIlIIl < lllllllllllllIIlllIIIlIllIIIlIlI; ++lllllllllllllIIlllIIIlIllIIIlIIl) {
                final EnumFacing lllllllllllllIIlllIIIlIllIIIlIII = EnumFacing.Plane.HORIZONTAL.random(lllllllllllllIIlllIIIlIllIIIIlII);
                final BlockPos lllllllllllllIIlllIIIlIllIIIIlll = lllllllllllllIIlllIIIlIllIIlIIll.up(lllllllllllllIIlllIIIlIllIIIlllI).offset(lllllllllllllIIlllIIIlIllIIIlIII);
                if (Math.abs(lllllllllllllIIlllIIIlIllIIIIlll.getX() - lllllllllllllIIlllIIIlIllIIIIIll.getX()) < lllllllllllllIIlllIIIlIllIIlIIII && Math.abs(lllllllllllllIIlllIIIlIllIIIIlll.getZ() - lllllllllllllIIlllIIIlIllIIIIIll.getZ()) < lllllllllllllIIlllIIIlIllIIlIIII && lllllllllllllIIlllIIIlIllIIlIlII.isAirBlock(lllllllllllllIIlllIIIlIllIIIIlll) && lllllllllllllIIlllIIIlIllIIlIlII.isAirBlock(lllllllllllllIIlllIIIlIllIIIIlll.down()) && areAllNeighborsEmpty(lllllllllllllIIlllIIIlIllIIlIlII, lllllllllllllIIlllIIIlIllIIIIlll, lllllllllllllIIlllIIIlIllIIIlIII.getOpposite())) {
                    lllllllllllllIIlllIIIlIllIIIlIll = true;
                    lllllllllllllIIlllIIIlIllIIlIlII.setBlockState(lllllllllllllIIlllIIIlIllIIIIlll, Blocks.CHORUS_PLANT.getDefaultState(), 2);
                    growTreeRecursive(lllllllllllllIIlllIIIlIllIIlIlII, lllllllllllllIIlllIIIlIllIIIIlll, lllllllllllllIIlllIIIlIllIIIIlII, lllllllllllllIIlllIIIlIllIIIIIll, lllllllllllllIIlllIIIlIllIIlIIII, lllllllllllllIIlllIIIlIllIIIIIIl + 1);
                }
            }
        }
        if (!lllllllllllllIIlllIIIlIllIIIlIll) {
            lllllllllllllIIlllIIIlIllIIlIlII.setBlockState(lllllllllllllIIlllIIIlIllIIlIIll.up(lllllllllllllIIlllIIIlIllIIIlllI), Blocks.CHORUS_FLOWER.getDefaultState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, 5), 2);
        }
    }
    
    private static boolean areAllNeighborsEmpty(final World lllllllllllllIIlllIIIllIIIIIlllI, final BlockPos lllllllllllllIIlllIIIllIIIIIlIIl, final EnumFacing lllllllllllllIIlllIIIllIIIIIllII) {
        for (final EnumFacing lllllllllllllIIlllIIIllIIIIIlIll : EnumFacing.Plane.HORIZONTAL) {
            if (lllllllllllllIIlllIIIllIIIIIlIll != lllllllllllllIIlllIIIllIIIIIllII && !lllllllllllllIIlllIIIllIIIIIlllI.isAirBlock(lllllllllllllIIlllIIIllIIIIIlIIl.offset(lllllllllllllIIlllIIIllIIIIIlIll))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIIlllIIIlIlllllllIl, final BlockPos lllllllllllllIIlllIIIlIllllllIIl) {
        return super.canPlaceBlockAt(lllllllllllllIIlllIIIlIlllllllIl, lllllllllllllIIlllIIIlIllllllIIl) && this.canSurvive(lllllllllllllIIlllIIIlIlllllllIl, lllllllllllllIIlllIIIlIllllllIIl);
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState lllllllllllllIIlllIIIlIllIlllIll) {
        return ItemStack.field_190927_a;
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 5);
    }
    
    private void placeGrownFlower(final World lllllllllllllIIlllIIIllIIIlIIIll, final BlockPos lllllllllllllIIlllIIIllIIIlIIIlI, final int lllllllllllllIIlllIIIllIIIlIIIIl) {
        lllllllllllllIIlllIIIllIIIlIIIll.setBlockState(lllllllllllllIIlllIIIllIIIlIIIlI, this.getDefaultState().withProperty((IProperty<Comparable>)BlockChorusFlower.AGE, lllllllllllllIIlllIIIllIIIlIIIIl), 2);
        lllllllllllllIIlllIIIllIIIlIIIll.playEvent(1033, lllllllllllllIIlllIIIllIIIlIIIlI, 0);
    }
    
    public boolean canSurvive(final World lllllllllllllIIlllIIIlIllllIIIlI, final BlockPos lllllllllllllIIlllIIIlIllllIIIIl) {
        final IBlockState lllllllllllllIIlllIIIlIllllIIIII = lllllllllllllIIlllIIIlIllllIIIlI.getBlockState(lllllllllllllIIlllIIIlIllllIIIIl.down());
        final Block lllllllllllllIIlllIIIlIlllIlllll = lllllllllllllIIlllIIIlIllllIIIII.getBlock();
        if (lllllllllllllIIlllIIIlIlllIlllll == Blocks.CHORUS_PLANT || lllllllllllllIIlllIIIlIlllIlllll == Blocks.END_STONE) {
            return true;
        }
        if (lllllllllllllIIlllIIIlIllllIIIII.getMaterial() == Material.AIR) {
            int lllllllllllllIIlllIIIlIlllIllllI = 0;
            for (final EnumFacing lllllllllllllIIlllIIIlIlllIlllIl : EnumFacing.Plane.HORIZONTAL) {
                final IBlockState lllllllllllllIIlllIIIlIlllIlllII = lllllllllllllIIlllIIIlIllllIIIlI.getBlockState(lllllllllllllIIlllIIIlIllllIIIIl.offset(lllllllllllllIIlllIIIlIlllIlllIl));
                final Block lllllllllllllIIlllIIIlIlllIllIll = lllllllllllllIIlllIIIlIlllIlllII.getBlock();
                if (lllllllllllllIIlllIIIlIlllIllIll == Blocks.CHORUS_PLANT) {
                    ++lllllllllllllIIlllIIIlIlllIllllI;
                }
                else {
                    if (lllllllllllllIIlllIIIlIlllIlllII.getMaterial() != Material.AIR) {
                        return false;
                    }
                    continue;
                }
            }
            return lllllllllllllIIlllIIIlIlllIllllI == 1;
        }
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIlllIIIllIIIIIIIlI) {
        return false;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIlllIIIlIlIllllIIl, final IBlockState lllllllllllllIIlllIIIlIlIllllIII, final BlockPos lllllllllllllIIlllIIIlIlIlllIlll, final EnumFacing lllllllllllllIIlllIIIlIlIlllIllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public static void generatePlant(final World lllllllllllllIIlllIIIlIllIlIlIII, final BlockPos lllllllllllllIIlllIIIlIllIlIIIll, final Random lllllllllllllIIlllIIIlIllIlIIIlI, final int lllllllllllllIIlllIIIlIllIlIIIIl) {
        lllllllllllllIIlllIIIlIllIlIlIII.setBlockState(lllllllllllllIIlllIIIlIllIlIIIll, Blocks.CHORUS_PLANT.getDefaultState(), 2);
        growTreeRecursive(lllllllllllllIIlllIIIlIllIlIlIII, lllllllllllllIIlllIIIlIllIlIIIll, lllllllllllllIIlllIIIlIllIlIIIlI, lllllllllllllIIlllIIIlIllIlIIIll, lllllllllllllIIlllIIIlIllIlIIIIl, 0);
    }
}
