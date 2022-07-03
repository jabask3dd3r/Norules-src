package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.block.properties.*;
import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.util.text.translation.*;
import javax.annotation.*;
import net.minecraft.util.*;

public class BlockFlowerPot extends BlockContainer
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType;
    protected static final /* synthetic */ AxisAlignedBB FLOWER_POT_AABB;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
    public static final /* synthetic */ PropertyInteger LEGACY_DATA;
    public static final /* synthetic */ PropertyEnum<EnumFlowerType> CONTENTS;
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllllllIlIlIIIlIIIIIII, final BlockPos lllllllllllllllllIlIlIIIlIIIIIlI) {
        return super.canPlaceBlockAt(lllllllllllllllllIlIlIIIlIIIIIII, lllllllllllllllllIlIlIIIlIIIIIlI) && lllllllllllllllllIlIlIIIlIIIIIII.getBlockState(lllllllllllllllllIlIlIIIlIIIIIlI.down()).isFullyOpaque();
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllllIlIlIIIllIIIIIl) {
        return false;
    }
    
    static {
        LEGACY_DATA = PropertyInteger.create("legacy_data", 0, 15);
        CONTENTS = PropertyEnum.create("contents", EnumFlowerType.class);
        FLOWER_POT_AABB = new AxisAlignedBB(0.3125, 0.0, 0.3125, 0.6875, 0.375, 0.6875);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllllIlIlIIIllIIIlIl) {
        return false;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState lllllllllllllllllIlIlIIIIIIlllII, final IBlockAccess lllllllllllllllllIlIlIIIIIlIIlII, final BlockPos lllllllllllllllllIlIlIIIIIIllIlI) {
        EnumFlowerType lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.EMPTY;
        final TileEntity lllllllllllllllllIlIlIIIIIlIIIIl = (lllllllllllllllllIlIlIIIIIlIIlII instanceof ChunkCache) ? ((ChunkCache)lllllllllllllllllIlIlIIIIIlIIlII).getTileEntity(lllllllllllllllllIlIlIIIIIIllIlI, Chunk.EnumCreateEntityType.CHECK) : lllllllllllllllllIlIlIIIIIlIIlII.getTileEntity(lllllllllllllllllIlIlIIIIIIllIlI);
        if (lllllllllllllllllIlIlIIIIIlIIIIl instanceof TileEntityFlowerPot) {
            final TileEntityFlowerPot lllllllllllllllllIlIlIIIIIlIIIII = (TileEntityFlowerPot)lllllllllllllllllIlIlIIIIIlIIIIl;
            final Item lllllllllllllllllIlIlIIIIIIlllll = lllllllllllllllllIlIlIIIIIlIIIII.getFlowerPotItem();
            if (lllllllllllllllllIlIlIIIIIIlllll instanceof ItemBlock) {
                final int lllllllllllllllllIlIlIIIIIIllllI = lllllllllllllllllIlIlIIIIIlIIIII.getFlowerPotData();
                final Block lllllllllllllllllIlIlIIIIIIlllIl = Block.getBlockFromItem(lllllllllllllllllIlIlIIIIIIlllll);
                if (lllllllllllllllllIlIlIIIIIIlllIl == Blocks.SAPLING) {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[BlockPlanks.EnumType.byMetadata(lllllllllllllllllIlIlIIIIIIllllI).ordinal()]) {
                        case 1: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.OAK_SAPLING;
                            break;
                        }
                        case 2: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.SPRUCE_SAPLING;
                            break;
                        }
                        case 3: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.BIRCH_SAPLING;
                            break;
                        }
                        case 4: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.JUNGLE_SAPLING;
                            break;
                        }
                        case 5: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.ACACIA_SAPLING;
                            break;
                        }
                        case 6: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.DARK_OAK_SAPLING;
                            break;
                        }
                        default: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllllllllIlIlIIIIIIlllIl == Blocks.TALLGRASS) {
                    switch (lllllllllllllllllIlIlIIIIIIllllI) {
                        case 0: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.DEAD_BUSH;
                            break;
                        }
                        case 2: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.FERN;
                            break;
                        }
                        default: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllllllllIlIlIIIIIIlllIl == Blocks.YELLOW_FLOWER) {
                    lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.DANDELION;
                }
                else if (lllllllllllllllllIlIlIIIIIIlllIl == Blocks.RED_FLOWER) {
                    switch ($SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType()[BlockFlower.EnumFlowerType.getType(BlockFlower.EnumFlowerColor.RED, lllllllllllllllllIlIlIIIIIIllllI).ordinal()]) {
                        case 2: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.POPPY;
                            break;
                        }
                        case 3: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.BLUE_ORCHID;
                            break;
                        }
                        case 4: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.ALLIUM;
                            break;
                        }
                        case 5: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.HOUSTONIA;
                            break;
                        }
                        case 6: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.RED_TULIP;
                            break;
                        }
                        case 7: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.ORANGE_TULIP;
                            break;
                        }
                        case 8: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.WHITE_TULIP;
                            break;
                        }
                        case 9: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.PINK_TULIP;
                            break;
                        }
                        case 10: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.OXEYE_DAISY;
                            break;
                        }
                        default: {
                            lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.EMPTY;
                            break;
                        }
                    }
                }
                else if (lllllllllllllllllIlIlIIIIIIlllIl == Blocks.RED_MUSHROOM) {
                    lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.MUSHROOM_RED;
                }
                else if (lllllllllllllllllIlIlIIIIIIlllIl == Blocks.BROWN_MUSHROOM) {
                    lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.MUSHROOM_BROWN;
                }
                else if (lllllllllllllllllIlIlIIIIIIlllIl == Blocks.DEADBUSH) {
                    lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.DEAD_BUSH;
                }
                else if (lllllllllllllllllIlIlIIIIIIlllIl == Blocks.CACTUS) {
                    lllllllllllllllllIlIlIIIIIlIIIlI = EnumFlowerType.CACTUS;
                }
            }
        }
        return lllllllllllllllllIlIlIIIIIIlllII.withProperty(BlockFlowerPot.CONTENTS, lllllllllllllllllIlIlIIIIIlIIIlI);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIlIlIIIIIllIIIl) {
        return lllllllllllllllllIlIlIIIIIllIIIl.getValue((IProperty<Integer>)BlockFlowerPot.LEGACY_DATA);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllllIlIlIIIllIIlIIl, final IBlockAccess lllllllllllllllllIlIlIIIllIIlIII, final BlockPos lllllllllllllllllIlIlIIIllIIIlll) {
        return BlockFlowerPot.FLOWER_POT_AABB;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllllIlIlIIIIlIIlllI, final Random lllllllllllllllllIlIlIIIIlIIllIl, final int lllllllllllllllllIlIlIIIIlIIllII) {
        return Items.FLOWER_POT;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllllIlIlIIIIIllllIl, final int lllllllllllllllllIlIlIIIIIllllII) {
        Block lllllllllllllllllIlIlIIIIIlllIll = null;
        int lllllllllllllllllIlIlIIIIIlllIlI = 0;
        switch (lllllllllllllllllIlIlIIIIIllllII) {
            case 1: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.RED_FLOWER;
                lllllllllllllllllIlIlIIIIIlllIlI = BlockFlower.EnumFlowerType.POPPY.getMeta();
                break;
            }
            case 2: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.YELLOW_FLOWER;
                break;
            }
            case 3: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.SAPLING;
                lllllllllllllllllIlIlIIIIIlllIlI = BlockPlanks.EnumType.OAK.getMetadata();
                break;
            }
            case 4: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.SAPLING;
                lllllllllllllllllIlIlIIIIIlllIlI = BlockPlanks.EnumType.SPRUCE.getMetadata();
                break;
            }
            case 5: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.SAPLING;
                lllllllllllllllllIlIlIIIIIlllIlI = BlockPlanks.EnumType.BIRCH.getMetadata();
                break;
            }
            case 6: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.SAPLING;
                lllllllllllllllllIlIlIIIIIlllIlI = BlockPlanks.EnumType.JUNGLE.getMetadata();
                break;
            }
            case 7: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.RED_MUSHROOM;
                break;
            }
            case 8: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.BROWN_MUSHROOM;
                break;
            }
            case 9: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.CACTUS;
                break;
            }
            case 10: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.DEADBUSH;
                break;
            }
            case 11: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.TALLGRASS;
                lllllllllllllllllIlIlIIIIIlllIlI = BlockTallGrass.EnumType.FERN.getMeta();
                break;
            }
            case 12: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.SAPLING;
                lllllllllllllllllIlIlIIIIIlllIlI = BlockPlanks.EnumType.ACACIA.getMetadata();
                break;
            }
            case 13: {
                lllllllllllllllllIlIlIIIIIlllIll = Blocks.SAPLING;
                lllllllllllllllllIlIlIIIIIlllIlI = BlockPlanks.EnumType.DARK_OAK.getMetadata();
                break;
            }
        }
        return new TileEntityFlowerPot(Item.getItemFromBlock(lllllllllllllllllIlIlIIIIIlllIll), lllllllllllllllllIlIlIIIIIlllIlI);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType = BlockFlowerPot.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockPlanks$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        }
        final byte lllllllllllllllllIlIlIIIIIIIllII = (Object)new int[BlockPlanks.EnumType.values().length];
        try {
            lllllllllllllllllIlIlIIIIIIIllII[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlIlIIIIIIIllII[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlIlIIIIIIIllII[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllIlIlIIIIIIIllII[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllllIlIlIIIIIIIllII[BlockPlanks.EnumType.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllllIlIlIIIIIIIllII[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockFlowerPot.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = (int[])(Object)lllllllllllllllllIlIlIIIIIIIllII;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllllIlIlIIIIIIlIIIl, final IBlockState lllllllllllllllllIlIlIIIIIIlIIII, final BlockPos lllllllllllllllllIlIlIIIIIIIllll, final EnumFacing lllllllllllllllllIlIlIIIIIIIlllI) {
        return BlockFaceShape.UNDEFINED;
    }
    
    public BlockFlowerPot() {
        super(Material.CIRCUITS);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFlowerPot.CONTENTS, EnumFlowerType.EMPTY).withProperty((IProperty<Comparable>)BlockFlowerPot.LEGACY_DATA, 0));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType = BlockFlowerPot.$SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType;
        if ($switch_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType != null) {
            return $switch_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType;
        }
        final float lllllllllllllllllIlIlIIIIIIIlIlI = (Object)new int[BlockFlower.EnumFlowerType.values().length];
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.ALLIUM.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.BLUE_ORCHID.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.DANDELION.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.HOUSTONIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.ORANGE_TULIP.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.OXEYE_DAISY.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.PINK_TULIP.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.POPPY.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError8) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.RED_TULIP.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError9) {}
        try {
            lllllllllllllllllIlIlIIIIIIIlIlI[BlockFlower.EnumFlowerType.WHITE_TULIP.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError10) {}
        return BlockFlowerPot.$SWITCH_TABLE$net$minecraft$block$BlockFlower$EnumFlowerType = (int[])(Object)lllllllllllllllllIlIlIIIIIIIlIlI;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllllllIlIlIIIllIIIIll) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllllIlIlIIIlIlIlIIl, final BlockPos lllllllllllllllllIlIlIIIlIllIlIl, final IBlockState lllllllllllllllllIlIlIIIlIlIIlll, final EntityPlayer lllllllllllllllllIlIlIIIlIllIIll, final EnumHand lllllllllllllllllIlIlIIIlIlIIlIl, final EnumFacing lllllllllllllllllIlIlIIIlIllIIIl, final float lllllllllllllllllIlIlIIIlIllIIII, final float lllllllllllllllllIlIlIIIlIlIllll, final float lllllllllllllllllIlIlIIIlIlIlllI) {
        final ItemStack lllllllllllllllllIlIlIIIlIlIllIl = lllllllllllllllllIlIlIIIlIllIIll.getHeldItem(lllllllllllllllllIlIlIIIlIlIIlIl);
        final TileEntityFlowerPot lllllllllllllllllIlIlIIIlIlIllII = this.getTileEntity(lllllllllllllllllIlIlIIIlIlIlIIl, lllllllllllllllllIlIlIIIlIllIlIl);
        if (lllllllllllllllllIlIlIIIlIlIllII == null) {
            return false;
        }
        final ItemStack lllllllllllllllllIlIlIIIlIlIlIll = lllllllllllllllllIlIlIIIlIlIllII.getFlowerItemStack();
        if (lllllllllllllllllIlIlIIIlIlIlIll.func_190926_b()) {
            if (!this.func_190951_a(lllllllllllllllllIlIlIIIlIlIllIl)) {
                return false;
            }
            lllllllllllllllllIlIlIIIlIlIllII.func_190614_a(lllllllllllllllllIlIlIIIlIlIllIl);
            lllllllllllllllllIlIlIIIlIllIIll.addStat(StatList.FLOWER_POTTED);
            if (!lllllllllllllllllIlIlIIIlIllIIll.capabilities.isCreativeMode) {
                lllllllllllllllllIlIlIIIlIlIllIl.func_190918_g(1);
            }
        }
        else {
            if (lllllllllllllllllIlIlIIIlIlIllIl.func_190926_b()) {
                lllllllllllllllllIlIlIIIlIllIIll.setHeldItem(lllllllllllllllllIlIlIIIlIlIIlIl, lllllllllllllllllIlIlIIIlIlIlIll);
            }
            else if (!lllllllllllllllllIlIlIIIlIllIIll.func_191521_c(lllllllllllllllllIlIlIIIlIlIlIll)) {
                lllllllllllllllllIlIlIIIlIllIIll.dropItem(lllllllllllllllllIlIlIIIlIlIlIll, false);
            }
            lllllllllllllllllIlIlIIIlIlIllII.func_190614_a(ItemStack.field_190927_a);
        }
        lllllllllllllllllIlIlIIIlIlIllII.markDirty();
        lllllllllllllllllIlIlIIIlIlIlIIl.notifyBlockUpdate(lllllllllllllllllIlIlIIIlIllIlIl, lllllllllllllllllIlIlIIIlIlIIlll, lllllllllllllllllIlIlIIIlIlIIlll, 3);
        return true;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllllIlIlIIIIllIlIlI, final BlockPos lllllllllllllllllIlIlIIIIllIlIIl, final IBlockState lllllllllllllllllIlIlIIIIllIIIll) {
        final TileEntityFlowerPot lllllllllllllllllIlIlIIIIllIIlll = this.getTileEntity(lllllllllllllllllIlIlIIIIllIlIlI, lllllllllllllllllIlIlIIIIllIlIIl);
        if (lllllllllllllllllIlIlIIIIllIIlll != null && lllllllllllllllllIlIlIIIIllIIlll.getFlowerPotItem() != null) {
            Block.spawnAsEntity(lllllllllllllllllIlIlIIIIllIlIlI, lllllllllllllllllIlIlIIIIllIlIIl, new ItemStack(lllllllllllllllllIlIlIIIIllIIlll.getFlowerPotItem(), 1, lllllllllllllllllIlIlIIIIllIIlll.getFlowerPotData()));
        }
        super.breakBlock(lllllllllllllllllIlIlIIIIllIlIlI, lllllllllllllllllIlIlIIIIllIlIIl, lllllllllllllllllIlIlIIIIllIIIll);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFlowerPot.CONTENTS, BlockFlowerPot.LEGACY_DATA });
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllllllIlIlIIIIlIlIlII, final BlockPos lllllllllllllllllIlIlIIIIlIllIIl, final IBlockState lllllllllllllllllIlIlIIIIlIllIII, final EntityPlayer lllllllllllllllllIlIlIIIIlIlIIIl) {
        super.onBlockHarvested(lllllllllllllllllIlIlIIIIlIlIlII, lllllllllllllllllIlIlIIIIlIllIIl, lllllllllllllllllIlIlIIIIlIllIII, lllllllllllllllllIlIlIIIIlIlIIIl);
        if (lllllllllllllllllIlIlIIIIlIlIIIl.capabilities.isCreativeMode) {
            final TileEntityFlowerPot lllllllllllllllllIlIlIIIIlIlIllI = this.getTileEntity(lllllllllllllllllIlIlIIIIlIlIlII, lllllllllllllllllIlIlIIIIlIllIIl);
            if (lllllllllllllllllIlIlIIIIlIlIllI != null) {
                lllllllllllllllllIlIlIIIIlIlIllI.func_190614_a(ItemStack.field_190927_a);
            }
        }
    }
    
    private boolean func_190951_a(final ItemStack lllllllllllllllllIlIlIIIlIIlllIl) {
        final Block lllllllllllllllllIlIlIIIlIIlllII = Block.getBlockFromItem(lllllllllllllllllIlIlIIIlIIlllIl.getItem());
        if (lllllllllllllllllIlIlIIIlIIlllII != Blocks.YELLOW_FLOWER && lllllllllllllllllIlIlIIIlIIlllII != Blocks.RED_FLOWER && lllllllllllllllllIlIlIIIlIIlllII != Blocks.CACTUS && lllllllllllllllllIlIlIIIlIIlllII != Blocks.BROWN_MUSHROOM && lllllllllllllllllIlIlIIIlIIlllII != Blocks.RED_MUSHROOM && lllllllllllllllllIlIlIIIlIIlllII != Blocks.SAPLING && lllllllllllllllllIlIlIIIlIIlllII != Blocks.DEADBUSH) {
            final int lllllllllllllllllIlIlIIIlIIllIll = lllllllllllllllllIlIlIIIlIIlllIl.getMetadata();
            return lllllllllllllllllIlIlIIIlIIlllII == Blocks.TALLGRASS && lllllllllllllllllIlIlIIIlIIllIll == BlockTallGrass.EnumType.FERN.getMeta();
        }
        return true;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllllIlIlIIIlIIIlIll, final BlockPos lllllllllllllllllIlIlIIIlIIIlIlI, final IBlockState lllllllllllllllllIlIlIIIlIIIllll) {
        final TileEntityFlowerPot lllllllllllllllllIlIlIIIlIIIlllI = this.getTileEntity(lllllllllllllllllIlIlIIIlIIIlIll, lllllllllllllllllIlIlIIIlIIIlIlI);
        if (lllllllllllllllllIlIlIIIlIIIlllI != null) {
            final ItemStack lllllllllllllllllIlIlIIIlIIIllIl = lllllllllllllllllIlIlIIIlIIIlllI.getFlowerItemStack();
            if (!lllllllllllllllllIlIlIIIlIIIllIl.func_190926_b()) {
                return lllllllllllllllllIlIlIIIlIIIllIl;
            }
        }
        return new ItemStack(Items.FLOWER_POT);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllllIlIlIIIIlllIIll, final World lllllllllllllllllIlIlIIIIlllIIlI, final BlockPos lllllllllllllllllIlIlIIIIlllIIIl, final Block lllllllllllllllllIlIlIIIIlllIllI, final BlockPos lllllllllllllllllIlIlIIIIlllIlIl) {
        if (!lllllllllllllllllIlIlIIIIlllIIlI.getBlockState(lllllllllllllllllIlIlIIIIlllIIIl.down()).isFullyOpaque()) {
            this.dropBlockAsItem(lllllllllllllllllIlIlIIIIlllIIlI, lllllllllllllllllIlIlIIIIlllIIIl, lllllllllllllllllIlIlIIIIlllIIll, 0);
            lllllllllllllllllIlIlIIIIlllIIlI.setBlockToAir(lllllllllllllllllIlIlIIIIlllIIIl);
        }
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.flowerPot.name");
    }
    
    @Nullable
    private TileEntityFlowerPot getTileEntity(final World lllllllllllllllllIlIlIIIIlIIIlII, final BlockPos lllllllllllllllllIlIlIIIIlIIIIll) {
        final TileEntity lllllllllllllllllIlIlIIIIlIIIlIl = lllllllllllllllllIlIlIIIIlIIIlII.getTileEntity(lllllllllllllllllIlIlIIIIlIIIIll);
        return (lllllllllllllllllIlIlIIIIlIIIlIl instanceof TileEntityFlowerPot) ? ((TileEntityFlowerPot)lllllllllllllllllIlIlIIIIlIIIlIl) : null;
    }
    
    public enum EnumFlowerType implements IStringSerializable
    {
        ACACIA_SAPLING("ACACIA_SAPLING", 15, "acacia_sapling"), 
        EMPTY("EMPTY", 0, "empty"), 
        BLUE_ORCHID("BLUE_ORCHID", 2, "blue_orchid"), 
        HOUSTONIA("HOUSTONIA", 4, "houstonia"), 
        RED_TULIP("RED_TULIP", 5, "red_tulip"), 
        ALLIUM("ALLIUM", 3, "allium");
        
        private final /* synthetic */ String name;
        
        PINK_TULIP("PINK_TULIP", 8, "pink_tulip"), 
        FERN("FERN", 20, "fern"), 
        DANDELION("DANDELION", 10, "dandelion"), 
        DEAD_BUSH("DEAD_BUSH", 19, "dead_bush"), 
        OXEYE_DAISY("OXEYE_DAISY", 9, "oxeye_daisy"), 
        MUSHROOM_BROWN("MUSHROOM_BROWN", 18, "mushroom_brown"), 
        BIRCH_SAPLING("BIRCH_SAPLING", 13, "birch_sapling"), 
        POPPY("POPPY", 1, "rose"), 
        WHITE_TULIP("WHITE_TULIP", 7, "white_tulip"), 
        OAK_SAPLING("OAK_SAPLING", 11, "oak_sapling"), 
        CACTUS("CACTUS", 21, "cactus"), 
        MUSHROOM_RED("MUSHROOM_RED", 17, "mushroom_red"), 
        ORANGE_TULIP("ORANGE_TULIP", 6, "orange_tulip"), 
        SPRUCE_SAPLING("SPRUCE_SAPLING", 12, "spruce_sapling"), 
        JUNGLE_SAPLING("JUNGLE_SAPLING", 14, "jungle_sapling"), 
        DARK_OAK_SAPLING("DARK_OAK_SAPLING", 16, "dark_oak_sapling");
        
        private EnumFlowerType(final String lllllllllllllIllIIllIlllIlllIIlI, final int lllllllllllllIllIIllIlllIlllIIIl, final String lllllllllllllIllIIllIlllIlllIllI) {
            this.name = lllllllllllllIllIIllIlllIlllIllI;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
