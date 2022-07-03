package net.minecraft.client.renderer.color;

import net.minecraft.util.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.biome.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.*;

public class BlockColors
{
    private final /* synthetic */ ObjectIntIdentityMap<IBlockColor> mapBlockColors;
    
    public BlockColors() {
        this.mapBlockColors = new ObjectIntIdentityMap<IBlockColor>(32);
    }
    
    public int colorMultiplier(final IBlockState lllllllllllllllIIlIlllIIlllIIIIl, @Nullable final IBlockAccess lllllllllllllllIIlIlllIIlllIIIII, @Nullable final BlockPos lllllllllllllllIIlIlllIIlllIIlIl, final int lllllllllllllllIIlIlllIIlllIIlII) {
        final IBlockColor lllllllllllllllIIlIlllIIlllIIIll = this.mapBlockColors.getByValue(Block.getIdFromBlock(lllllllllllllllIIlIlllIIlllIIIIl.getBlock()));
        return (lllllllllllllllIIlIlllIIlllIIIll == null) ? -1 : lllllllllllllllIIlIlllIIlllIIIll.colorMultiplier(lllllllllllllllIIlIlllIIlllIIIIl, lllllllllllllllIIlIlllIIlllIIIII, lllllllllllllllIIlIlllIIlllIIlIl, lllllllllllllllIIlIlllIIlllIIlII);
    }
    
    public void registerBlockColorHandler(final IBlockColor lllllllllllllllIIlIlllIIllIlIlII, final Block... lllllllllllllllIIlIlllIIllIlIIll) {
        final long lllllllllllllllIIlIlllIIllIIlIll = (Object)lllllllllllllllIIlIlllIIllIlIIll;
        final double lllllllllllllllIIlIlllIIllIIllII = lllllllllllllllIIlIlllIIllIlIIll.length;
        for (long lllllllllllllllIIlIlllIIllIIllIl = 0; lllllllllllllllIIlIlllIIllIIllIl < lllllllllllllllIIlIlllIIllIIllII; ++lllllllllllllllIIlIlllIIllIIllIl) {
            final Block lllllllllllllllIIlIlllIIllIlIIlI = lllllllllllllllIIlIlllIIllIIlIll[lllllllllllllllIIlIlllIIllIIllIl];
            this.mapBlockColors.put(lllllllllllllllIIlIlllIIllIlIlII, Block.getIdFromBlock(lllllllllllllllIIlIlllIIllIlIIlI));
        }
    }
    
    public int getColor(final IBlockState lllllllllllllllIIlIlllIIlllllIIl, final World lllllllllllllllIIlIlllIIlllllIII, final BlockPos lllllllllllllllIIlIlllIIllllIIIl) {
        final IBlockColor lllllllllllllllIIlIlllIIllllIllI = this.mapBlockColors.getByValue(Block.getIdFromBlock(lllllllllllllllIIlIlllIIlllllIIl.getBlock()));
        if (lllllllllllllllIIlIlllIIllllIllI != null) {
            return lllllllllllllllIIlIlllIIllllIllI.colorMultiplier(lllllllllllllllIIlIlllIIlllllIIl, null, null, 0);
        }
        final MapColor lllllllllllllllIIlIlllIIllllIlIl = lllllllllllllllIIlIlllIIlllllIIl.getMapColor(lllllllllllllllIIlIlllIIlllllIII, lllllllllllllllIIlIlllIIllllIIIl);
        return (lllllllllllllllIIlIlllIIllllIlIl != null) ? lllllllllllllllIIlIlllIIllllIlIl.colorValue : -1;
    }
    
    public static BlockColors init() {
        final BlockColors lllllllllllllllIIlIlllIlIIIIIIlI = new BlockColors();
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllllllllllllllIIlIIll, @Nullable final IBlockAccess lllllllllllllllllllllllllIIlIlll, @Nullable final BlockPos lllllllllllllllllllllllllIIlIllI, final int lllllllllllllllllllllllllIIlIlIl) {
                final BlockDoublePlant.EnumPlantType lllllllllllllllllllllllllIIlIlII = lllllllllllllllllllllllllIIlIIll.getValue(BlockDoublePlant.VARIANT);
                return (lllllllllllllllllllllllllIIlIlll != null && lllllllllllllllllllllllllIIlIllI != null && (lllllllllllllllllllllllllIIlIlII == BlockDoublePlant.EnumPlantType.GRASS || lllllllllllllllllllllllllIIlIlII == BlockDoublePlant.EnumPlantType.FERN)) ? BiomeColorHelper.getGrassColorAtPos(lllllllllllllllllllllllllIIlIlll, (lllllllllllllllllllllllllIIlIIll.getValue(BlockDoublePlant.HALF) == BlockDoublePlant.EnumBlockHalf.UPPER) ? lllllllllllllllllllllllllIIlIllI.down() : lllllllllllllllllllllllllIIlIllI) : -1;
            }
        }, Blocks.DOUBLE_PLANT);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lIlIIIIIlIII, @Nullable final IBlockAccess lIlIIIIIIlll, @Nullable final BlockPos lIlIIIIIIllI, final int lIIllllllllI) {
                if (lIlIIIIIIlll == null || lIlIIIIIIllI == null) {
                    return -1;
                }
                final TileEntity lIlIIIIIIlII = lIlIIIIIIlll.getTileEntity(lIlIIIIIIllI);
                if (lIlIIIIIIlII instanceof TileEntityFlowerPot) {
                    final Item lIlIIIIIIIll = ((TileEntityFlowerPot)lIlIIIIIIlII).getFlowerPotItem();
                    final IBlockState lIlIIIIIIIlI = Block.getBlockFromItem(lIlIIIIIIIll).getDefaultState();
                    return lllllllllllllllIIlIlllIlIIIIIIlI.colorMultiplier(lIlIIIIIIIlI, lIlIIIIIIlll, lIlIIIIIIllI, lIIllllllllI);
                }
                return -1;
            }
        }, Blocks.FLOWER_POT);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllIIIIllIlllllIIIIlll, @Nullable final IBlockAccess lllllllllllllIIIIllIlllllIIIIIll, @Nullable final BlockPos lllllllllllllIIIIllIlllllIIIIIlI, final int lllllllllllllIIIIllIlllllIIIIlII) {
                return (lllllllllllllIIIIllIlllllIIIIIll != null && lllllllllllllIIIIllIlllllIIIIIlI != null) ? BiomeColorHelper.getGrassColorAtPos(lllllllllllllIIIIllIlllllIIIIIll, lllllllllllllIIIIllIlllllIIIIIlI) : ColorizerGrass.getGrassColor(0.5, 1.0);
            }
        }, Blocks.GRASS);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllllIIIIIIIlIIIIlIllI, @Nullable final IBlockAccess lllllllllllllllIIIIIIIlIIIIlIlIl, @Nullable final BlockPos lllllllllllllllIIIIIIIlIIIIIllll, final int lllllllllllllllIIIIIIIlIIIIlIIll) {
                final BlockPlanks.EnumType lllllllllllllllIIIIIIIlIIIIlIIlI = lllllllllllllllIIIIIIIlIIIIlIllI.getValue(BlockOldLeaf.VARIANT);
                if (lllllllllllllllIIIIIIIlIIIIlIIlI == BlockPlanks.EnumType.SPRUCE) {
                    return ColorizerFoliage.getFoliageColorPine();
                }
                if (lllllllllllllllIIIIIIIlIIIIlIIlI == BlockPlanks.EnumType.BIRCH) {
                    return ColorizerFoliage.getFoliageColorBirch();
                }
                return (lllllllllllllllIIIIIIIlIIIIlIlIl != null && lllllllllllllllIIIIIIIlIIIIIllll != null) ? BiomeColorHelper.getFoliageColorAtPos(lllllllllllllllIIIIIIIlIIIIlIlIl, lllllllllllllllIIIIIIIlIIIIIllll) : ColorizerFoliage.getFoliageColorBasic();
            }
        }, Blocks.LEAVES);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState llllllllllllllIIllIIIIlllIlllIlI, @Nullable final IBlockAccess llllllllllllllIIllIIIIlllIlllIIl, @Nullable final BlockPos llllllllllllllIIllIIIIlllIlllIII, final int llllllllllllllIIllIIIIlllIllIlll) {
                return (llllllllllllllIIllIIIIlllIlllIIl != null && llllllllllllllIIllIIIIlllIlllIII != null) ? BiomeColorHelper.getFoliageColorAtPos(llllllllllllllIIllIIIIlllIlllIIl, llllllllllllllIIllIIIIlllIlllIII) : ColorizerFoliage.getFoliageColorBasic();
            }
        }, Blocks.LEAVES2);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllIlIIIlIllIIIllIllIl, @Nullable final IBlockAccess lllllllllllllIlIIIlIllIIIllIllII, @Nullable final BlockPos lllllllllllllIlIIIlIllIIIllIlIll, final int lllllllllllllIlIIIlIllIIIllIlIlI) {
                return (lllllllllllllIlIIIlIllIIIllIllII != null && lllllllllllllIlIIIlIllIIIllIlIll != null) ? BiomeColorHelper.getWaterColorAtPos(lllllllllllllIlIIIlIllIIIllIllII, lllllllllllllIlIIIlIllIIIllIlIll) : -1;
            }
        }, Blocks.WATER, Blocks.FLOWING_WATER);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllIIIIIlIIlIIIlIIIIII, @Nullable final IBlockAccess lllllllllllllIIIIIlIIlIIIIllllll, @Nullable final BlockPos lllllllllllllIIIIIlIIlIIIIlllllI, final int lllllllllllllIIIIIlIIlIIIIllllIl) {
                return BlockRedstoneWire.colorMultiplier(lllllllllllllIIIIIlIIlIIIlIIIIII.getValue((IProperty<Integer>)BlockRedstoneWire.POWER));
            }
        }, Blocks.REDSTONE_WIRE);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllIlIlIIlllllllllIIII, @Nullable final IBlockAccess lllllllllllllIlIlIIllllllllIllII, @Nullable final BlockPos lllllllllllllIlIlIIllllllllIlIll, final int lllllllllllllIlIlIIllllllllIllIl) {
                return (lllllllllllllIlIlIIllllllllIllII != null && lllllllllllllIlIlIIllllllllIlIll != null) ? BiomeColorHelper.getGrassColorAtPos(lllllllllllllIlIlIIllllllllIllII, lllllllllllllIlIlIIllllllllIlIll) : -1;
            }
        }, Blocks.REEDS);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState llllllllllllllIllllIlIIlIlIIlIll, @Nullable final IBlockAccess llllllllllllllIllllIlIIlIlIlIIlI, @Nullable final BlockPos llllllllllllllIllllIlIIlIlIlIIIl, final int llllllllllllllIllllIlIIlIlIlIIII) {
                final int llllllllllllllIllllIlIIlIlIIllll = llllllllllllllIllllIlIIlIlIIlIll.getValue((IProperty<Integer>)BlockStem.AGE);
                final int llllllllllllllIllllIlIIlIlIIlllI = llllllllllllllIllllIlIIlIlIIllll * 32;
                final int llllllllllllllIllllIlIIlIlIIllIl = 255 - llllllllllllllIllllIlIIlIlIIllll * 8;
                final int llllllllllllllIllllIlIIlIlIIllII = llllllllllllllIllllIlIIlIlIIllll * 4;
                return llllllllllllllIllllIlIIlIlIIlllI << 16 | llllllllllllllIllllIlIIlIlIIllIl << 8 | llllllllllllllIllllIlIIlIlIIllII;
            }
        }, Blocks.MELON_STEM, Blocks.PUMPKIN_STEM);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllIIlIIIIIIlllIIIllIl, @Nullable final IBlockAccess lllllllllllllIIlIIIIIIlllIIIlIII, @Nullable final BlockPos lllllllllllllIIlIIIIIIlllIIIIlll, final int lllllllllllllIIlIIIIIIlllIIIlIlI) {
                if (lllllllllllllIIlIIIIIIlllIIIlIII != null && lllllllllllllIIlIIIIIIlllIIIIlll != null) {
                    return BiomeColorHelper.getGrassColorAtPos(lllllllllllllIIlIIIIIIlllIIIlIII, lllllllllllllIIlIIIIIIlllIIIIlll);
                }
                return (lllllllllllllIIlIIIIIIlllIIIllIl.getValue(BlockTallGrass.TYPE) == BlockTallGrass.EnumType.DEAD_BUSH) ? 16777215 : ColorizerGrass.getGrassColor(0.5, 1.0);
            }
        }, Blocks.TALLGRASS);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllIIlIIIIllllIlllllIl, @Nullable final IBlockAccess lllllllllllllIIlIIIIllllIllllIIl, @Nullable final BlockPos lllllllllllllIIlIIIIllllIllllIII, final int lllllllllllllIIlIIIIllllIllllIlI) {
                return (lllllllllllllIIlIIIIllllIllllIIl != null && lllllllllllllIIlIIIIllllIllllIII != null) ? BiomeColorHelper.getFoliageColorAtPos(lllllllllllllIIlIIIIllllIllllIIl, lllllllllllllIIlIIIIllllIllllIII) : ColorizerFoliage.getFoliageColorBasic();
            }
        }, Blocks.VINE);
        lllllllllllllllIIlIlllIlIIIIIIlI.registerBlockColorHandler(new IBlockColor() {
            @Override
            public int colorMultiplier(final IBlockState lllllllllllllIllIIIlllIlIlIIlIll, @Nullable final IBlockAccess lllllllllllllIllIIIlllIlIlIIIlll, @Nullable final BlockPos lllllllllllllIllIIIlllIlIlIIIllI, final int lllllllllllllIllIIIlllIlIlIIlIII) {
                return (lllllllllllllIllIIIlllIlIlIIIlll != null && lllllllllllllIllIIIlllIlIlIIIllI != null) ? 2129968 : 7455580;
            }
        }, Blocks.WATERLILY);
        return lllllllllllllllIIlIlllIlIIIIIIlI;
    }
}
