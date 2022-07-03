package net.minecraft.block;

import net.minecraft.util.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;

public class BlockGrass extends Block implements IGrowable
{
    public static final /* synthetic */ PropertyBool SNOWY;
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
    
    static {
        SNOWY = PropertyBool.create("snowy");
    }
    
    @Override
    public void grow(final World lllllllllllllllIIIlIlIIlllIlllIl, final Random lllllllllllllllIIIlIlIIlllIllIll, final BlockPos lllllllllllllllIIIlIlIIlllIIlIIl, final IBlockState lllllllllllllllIIIlIlIIlllIlIlll) {
        final BlockPos lllllllllllllllIIIlIlIIlllIlIlIl = lllllllllllllllIIIlIlIIlllIIlIIl.up();
        int lllllllllllllllIIIlIlIIlllIlIIll = 0;
    Label_0252_Outer:
        while (lllllllllllllllIIIlIlIIlllIlIIll < 128) {
            BlockPos lllllllllllllllIIIlIlIIlllIlIIIl = lllllllllllllllIIIlIlIIlllIlIlIl;
            int lllllllllllllllIIIlIlIIlllIlIIII = 0;
            while (true) {
                while (lllllllllllllllIIIlIlIIlllIlIIII < lllllllllllllllIIIlIlIIlllIlIIll / 16) {
                    lllllllllllllllIIIlIlIIlllIlIIIl = lllllllllllllllIIIlIlIIlllIlIIIl.add(lllllllllllllllIIIlIlIIlllIllIll.nextInt(3) - 1, (lllllllllllllllIIIlIlIIlllIllIll.nextInt(3) - 1) * lllllllllllllllIIIlIlIIlllIllIll.nextInt(3) / 2, lllllllllllllllIIIlIlIIlllIllIll.nextInt(3) - 1);
                    if (lllllllllllllllIIIlIlIIlllIlllIl.getBlockState(lllllllllllllllIIIlIlIIlllIlIIIl.down()).getBlock() == Blocks.GRASS) {
                        if (!lllllllllllllllIIIlIlIIlllIlllIl.getBlockState(lllllllllllllllIIIlIlIIlllIlIIIl).isNormalCube()) {
                            ++lllllllllllllllIIIlIlIIlllIlIIII;
                            continue Label_0252_Outer;
                        }
                    }
                    ++lllllllllllllllIIIlIlIIlllIlIIll;
                    continue Label_0252_Outer;
                }
                if (lllllllllllllllIIIlIlIIlllIlllIl.getBlockState(lllllllllllllllIIIlIlIIlllIlIIIl).getBlock().blockMaterial != Material.AIR) {
                    continue;
                }
                if (lllllllllllllllIIIlIlIIlllIllIll.nextInt(8) == 0) {
                    final BlockFlower.EnumFlowerType lllllllllllllllIIIlIlIIlllIIllll = lllllllllllllllIIIlIlIIlllIlllIl.getBiome(lllllllllllllllIIIlIlIIlllIlIIIl).pickRandomFlower(lllllllllllllllIIIlIlIIlllIllIll, lllllllllllllllIIIlIlIIlllIlIIIl);
                    final BlockFlower lllllllllllllllIIIlIlIIlllIIlllI = lllllllllllllllIIIlIlIIlllIIllll.getBlockType().getBlock();
                    final IBlockState lllllllllllllllIIIlIlIIlllIIllIl = lllllllllllllllIIIlIlIIlllIIlllI.getDefaultState().withProperty(lllllllllllllllIIIlIlIIlllIIlllI.getTypeProperty(), lllllllllllllllIIIlIlIIlllIIllll);
                    if (lllllllllllllllIIIlIlIIlllIIlllI.canBlockStay(lllllllllllllllIIIlIlIIlllIlllIl, lllllllllllllllIIIlIlIIlllIlIIIl, lllllllllllllllIIIlIlIIlllIIllIl)) {
                        lllllllllllllllIIIlIlIIlllIlllIl.setBlockState(lllllllllllllllIIIlIlIIlllIlIIIl, lllllllllllllllIIIlIlIIlllIIllIl, 3);
                    }
                    continue;
                }
                else {
                    final IBlockState lllllllllllllllIIIlIlIIlllIIllII = Blocks.TALLGRASS.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS);
                    if (Blocks.TALLGRASS.canBlockStay(lllllllllllllllIIIlIlIIlllIlllIl, lllllllllllllllIIIlIlIIlllIlIIIl, lllllllllllllllIIIlIlIIlllIIllII)) {
                        lllllllllllllllIIIlIlIIlllIlllIl.setBlockState(lllllllllllllllIIIlIlIIlllIlIIIl, lllllllllllllllIIIlIlIIlllIIllII, 3);
                    }
                    continue;
                }
                break;
            }
        }
    }
    
    protected BlockGrass() {
        super(Material.GRASS);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockGrass.SNOWY, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIIIlIlIlIIIIIllll, final Random lllllllllllllllIIIlIlIlIIIIIllIl, final int lllllllllllllllIIIlIlIlIIIIIlIll) {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), lllllllllllllllIIIlIlIlIIIIIllIl, lllllllllllllllIIIlIlIlIIIIIlIll);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIlIlIIllIllIIll) {
        return 0;
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllllllIIIlIlIlIIIIIIIlI, final Random lllllllllllllllIIIlIlIlIIIIIIIIl, final BlockPos lllllllllllllllIIIlIlIlIIIIIIIII, final IBlockState lllllllllllllllIIIlIlIIlllllllll) {
        return true;
    }
    
    @Override
    public void updateTick(final World lllllllllllllllIIIlIlIlIIIllIIIl, final BlockPos lllllllllllllllIIIlIlIlIIIlIllll, final IBlockState lllllllllllllllIIIlIlIlIIIlIllIl, final Random lllllllllllllllIIIlIlIlIIIlIlIll) {
        if (!lllllllllllllllIIIlIlIlIIIllIIIl.isRemote) {
            if (lllllllllllllllIIIlIlIlIIIllIIIl.getLightFromNeighbors(lllllllllllllllIIIlIlIlIIIlIllll.up()) < 4 && lllllllllllllllIIIlIlIlIIIllIIIl.getBlockState(lllllllllllllllIIIlIlIlIIIlIllll.up()).getLightOpacity() > 2) {
                lllllllllllllllIIIlIlIlIIIllIIIl.setBlockState(lllllllllllllllIIIlIlIlIIIlIllll, Blocks.DIRT.getDefaultState());
            }
            else if (lllllllllllllllIIIlIlIlIIIllIIIl.getLightFromNeighbors(lllllllllllllllIIIlIlIlIIIlIllll.up()) >= 9) {
                for (int lllllllllllllllIIIlIlIlIIIlIlIIl = 0; lllllllllllllllIIIlIlIlIIIlIlIIl < 4; ++lllllllllllllllIIIlIlIlIIIlIlIIl) {
                    final BlockPos lllllllllllllllIIIlIlIlIIIlIIlll = lllllllllllllllIIIlIlIlIIIlIllll.add(lllllllllllllllIIIlIlIlIIIlIlIll.nextInt(3) - 1, lllllllllllllllIIIlIlIlIIIlIlIll.nextInt(5) - 3, lllllllllllllllIIIlIlIlIIIlIlIll.nextInt(3) - 1);
                    if (lllllllllllllllIIIlIlIlIIIlIIlll.getY() >= 0 && lllllllllllllllIIIlIlIlIIIlIIlll.getY() < 256 && !lllllllllllllllIIIlIlIlIIIllIIIl.isBlockLoaded(lllllllllllllllIIIlIlIlIIIlIIlll)) {
                        return;
                    }
                    final IBlockState lllllllllllllllIIIlIlIlIIIlIIlIl = lllllllllllllllIIIlIlIlIIIllIIIl.getBlockState(lllllllllllllllIIIlIlIlIIIlIIlll.up());
                    final IBlockState lllllllllllllllIIIlIlIlIIIlIIIll = lllllllllllllllIIIlIlIlIIIllIIIl.getBlockState(lllllllllllllllIIIlIlIlIIIlIIlll);
                    if (lllllllllllllllIIIlIlIlIIIlIIIll.getBlock() == Blocks.DIRT && lllllllllllllllIIIlIlIlIIIlIIIll.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && lllllllllllllllIIIlIlIlIIIllIIIl.getLightFromNeighbors(lllllllllllllllIIIlIlIlIIIlIIlll.up()) >= 4 && lllllllllllllllIIIlIlIlIIIlIIlIl.getLightOpacity() <= 2) {
                        lllllllllllllllIIIlIlIlIIIllIIIl.setBlockState(lllllllllllllllIIIlIlIlIIIlIIlll, Blocks.GRASS.getDefaultState());
                    }
                }
            }
        }
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllIIIlIlIlIIlIlIIIl, final IBlockAccess lllllllllllllllIIIlIlIlIIlIlIlII, final BlockPos lllllllllllllllIIIlIlIlIIlIIllll) {
        final Block lllllllllllllllIIIlIlIlIIlIlIIlI = lllllllllllllllIIIlIlIlIIlIlIlII.getBlockState(lllllllllllllllIIIlIlIlIIlIIllll.up()).getBlock();
        return lllllllllllllllIIIlIlIlIIlIlIIIl.withProperty((IProperty<Comparable>)BlockGrass.SNOWY, lllllllllllllllIIIlIlIlIIlIlIIlI == Blocks.SNOW || lllllllllllllllIIIlIlIlIIlIlIIlI == Blocks.SNOW_LAYER);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockGrass.SNOWY });
    }
    
    @Override
    public boolean canGrow(final World lllllllllllllllIIIlIlIlIIIIIIlll, final BlockPos lllllllllllllllIIIlIlIlIIIIIIllI, final IBlockState lllllllllllllllIIIlIlIlIIIIIIlIl, final boolean lllllllllllllllIIIlIlIlIIIIIIlII) {
        return true;
    }
}
