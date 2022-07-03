package net.minecraft.block;

import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.init.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.*;

public class BlockSapling extends BlockBush implements IGrowable
{
    protected static final /* synthetic */ AxisAlignedBB SAPLING_AABB;
    public static final /* synthetic */ PropertyInteger STAGE;
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> TYPE;
    
    @Override
    public void updateTick(final World lllllllllllllIIlIlllIIIIlIIllIll, final BlockPos lllllllllllllIIlIlllIIIIlIIllIlI, final IBlockState lllllllllllllIIlIlllIIIIlIIllllI, final Random lllllllllllllIIlIlllIIIIlIIlllIl) {
        if (!lllllllllllllIIlIlllIIIIlIIllIll.isRemote) {
            super.updateTick(lllllllllllllIIlIlllIIIIlIIllIll, lllllllllllllIIlIlllIIIIlIIllIlI, lllllllllllllIIlIlllIIIIlIIllllI, lllllllllllllIIlIlllIIIIlIIlllIl);
            if (lllllllllllllIIlIlllIIIIlIIllIll.getLightFromNeighbors(lllllllllllllIIlIlllIIIIlIIllIlI.up()) >= 9 && lllllllllllllIIlIlllIIIIlIIlllIl.nextInt(7) == 0) {
                this.grow(lllllllllllllIIlIlllIIIIlIIllIll, lllllllllllllIIlIlllIIIIlIIllIlI, lllllllllllllIIlIlllIIIIlIIllllI, lllllllllllllIIlIlllIIIIlIIlllIl);
            }
        }
    }
    
    @Override
    public void grow(final World lllllllllllllIIlIlllIIIIIIIlllll, final Random lllllllllllllIIlIlllIIIIIIIllIIl, final BlockPos lllllllllllllIIlIlllIIIIIIIllIII, final IBlockState lllllllllllllIIlIlllIIIIIIIlIlll) {
        this.grow(lllllllllllllIIlIlllIIIIIIIlllll, lllllllllllllIIlIlllIIIIIIIllIII, lllllllllllllIIlIlllIIIIIIIlIlll, lllllllllllllIIlIlllIIIIIIIllIIl);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIlIlllIIIIIIIlIIIl) {
        return this.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.byMetadata(lllllllllllllIIlIlllIIIIIIIlIIIl & 0x7)).withProperty((IProperty<Comparable>)BlockSapling.STAGE, (lllllllllllllIIlIlllIIIIIIIlIIIl & 0x8) >> 3);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSapling.TYPE, BlockSapling.STAGE });
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIlIlllIIIIIIlllIlI, final NonNullList<ItemStack> lllllllllllllIIlIlllIIIIIIlllIIl) {
        final Exception lllllllllllllIIlIlllIIIIIIllIIlI;
        final boolean lllllllllllllIIlIlllIIIIIIllIIll = ((BlockPlanks.EnumType[])(Object)(lllllllllllllIIlIlllIIIIIIllIIlI = (Exception)(Object)BlockPlanks.EnumType.values())).length != 0;
        for (short lllllllllllllIIlIlllIIIIIIllIlII = 0; lllllllllllllIIlIlllIIIIIIllIlII < (lllllllllllllIIlIlllIIIIIIllIIll ? 1 : 0); ++lllllllllllllIIlIlllIIIIIIllIlII) {
            final BlockPlanks.EnumType lllllllllllllIIlIlllIIIIIIlllIII = lllllllllllllIIlIlllIIIIIIllIIlI[lllllllllllllIIlIlllIIIIIIllIlII];
            lllllllllllllIIlIlllIIIIIIlllIIl.add(new ItemStack(this, 1, lllllllllllllIIlIlllIIIIIIlllIII.getMetadata()));
        }
    }
    
    protected BlockSapling() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK).withProperty((IProperty<Comparable>)BlockSapling.STAGE, 0));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".").append(BlockPlanks.EnumType.OAK.getUnlocalizedName()).append(".name")));
    }
    
    @Override
    public boolean canGrow(final World lllllllllllllIIlIlllIIIIIIllIIII, final BlockPos lllllllllllllIIlIlllIIIIIIlIllll, final IBlockState lllllllllllllIIlIlllIIIIIIlIlllI, final boolean lllllllllllllIIlIlllIIIIIIlIllIl) {
        return true;
    }
    
    private boolean isTwoByTwoOfType(final World lllllllllllllIIlIlllIIIIIlIllIIl, final BlockPos lllllllllllllIIlIlllIIIIIlIllIII, final int lllllllllllllIIlIlllIIIIIlIlIlll, final int lllllllllllllIIlIlllIIIIIlIlIllI, final BlockPlanks.EnumType lllllllllllllIIlIlllIIIIIlIlIlIl) {
        return this.isTypeAt(lllllllllllllIIlIlllIIIIIlIllIIl, lllllllllllllIIlIlllIIIIIlIllIII.add(lllllllllllllIIlIlllIIIIIlIlIlll, 0, lllllllllllllIIlIlllIIIIIlIlIllI), lllllllllllllIIlIlllIIIIIlIlIlIl) && this.isTypeAt(lllllllllllllIIlIlllIIIIIlIllIIl, lllllllllllllIIlIlllIIIIIlIllIII.add(lllllllllllllIIlIlllIIIIIlIlIlll + 1, 0, lllllllllllllIIlIlllIIIIIlIlIllI), lllllllllllllIIlIlllIIIIIlIlIlIl) && this.isTypeAt(lllllllllllllIIlIlllIIIIIlIllIIl, lllllllllllllIIlIlllIIIIIlIllIII.add(lllllllllllllIIlIlllIIIIIlIlIlll, 0, lllllllllllllIIlIlllIIIIIlIlIllI + 1), lllllllllllllIIlIlllIIIIIlIlIlIl) && this.isTypeAt(lllllllllllllIIlIlllIIIIIlIllIIl, lllllllllllllIIlIlllIIIIIlIllIII.add(lllllllllllllIIlIlllIIIIIlIlIlll + 1, 0, lllllllllllllIIlIlllIIIIIlIlIllI + 1), lllllllllllllIIlIlllIIIIIlIlIlIl);
    }
    
    static {
        TYPE = PropertyEnum.create("type", BlockPlanks.EnumType.class);
        STAGE = PropertyInteger.create("stage", 0, 1);
        SAPLING_AABB = new AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421);
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllllIIlIlllIIIIIIlIIllI, final Random lllllllllllllIIlIlllIIIIIIlIlIIl, final BlockPos lllllllllllllIIlIlllIIIIIIlIlIII, final IBlockState lllllllllllllIIlIlllIIIIIIlIIlll) {
        return lllllllllllllIIlIlllIIIIIIlIIllI.rand.nextFloat() < 0.45;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType = BlockSapling.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockPlanks$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        }
        final byte lllllllllllllIIlIlllIIIIIIIIIlIl = (Object)new int[BlockPlanks.EnumType.values().length];
        try {
            lllllllllllllIIlIlllIIIIIIIIIlIl[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIIlIlllIIIIIIIIIlIl[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIIlIlllIIIIIIIIIlIl[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIIlIlllIIIIIIIIIlIl[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIIlIlllIIIIIIIIIlIl[BlockPlanks.EnumType.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIIlIlllIIIIIIIIIlIl[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockSapling.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = (int[])(Object)lllllllllllllIIlIlllIIIIIIIIIlIl;
    }
    
    public void generateTree(final World lllllllllllllIIlIlllIIIIIlllllII, final BlockPos lllllllllllllIIlIlllIIIIIllllIll, final IBlockState lllllllllllllIIlIlllIIIIIllIlllI, final Random lllllllllllllIIlIlllIIIIIllIllIl) {
        WorldGenerator lllllllllllllIIlIlllIIIIIllllIII = (lllllllllllllIIlIlllIIIIIllIllIl.nextInt(10) == 0) ? new WorldGenBigTree(true) : new WorldGenTrees(true);
        int lllllllllllllIIlIlllIIIIIlllIlll = 0;
        int lllllllllllllIIlIlllIIIIIlllIllI = 0;
        boolean lllllllllllllIIlIlllIIIIIlllIlIl = false;
        switch ($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[lllllllllllllIIlIlllIIIIIllIlllI.getValue(BlockSapling.TYPE).ordinal()]) {
            case 2: {
            Label_0163:
                for (lllllllllllllIIlIlllIIIIIlllIlll = 0; lllllllllllllIIlIlllIIIIIlllIlll >= -1; --lllllllllllllIIlIlllIIIIIlllIlll) {
                    for (lllllllllllllIIlIlllIIIIIlllIllI = 0; lllllllllllllIIlIlllIIIIIlllIllI >= -1; --lllllllllllllIIlIlllIIIIIlllIllI) {
                        if (this.isTwoByTwoOfType(lllllllllllllIIlIlllIIIIIlllllII, lllllllllllllIIlIlllIIIIIllllIll, lllllllllllllIIlIlllIIIIIlllIlll, lllllllllllllIIlIlllIIIIIlllIllI, BlockPlanks.EnumType.SPRUCE)) {
                            lllllllllllllIIlIlllIIIIIllllIII = new WorldGenMegaPineTree(false, lllllllllllllIIlIlllIIIIIllIllIl.nextBoolean());
                            lllllllllllllIIlIlllIIIIIlllIlIl = true;
                            break Label_0163;
                        }
                    }
                }
                if (!lllllllllllllIIlIlllIIIIIlllIlIl) {
                    lllllllllllllIIlIlllIIIIIlllIlll = 0;
                    lllllllllllllIIlIlllIIIIIlllIllI = 0;
                    lllllllllllllIIlIlllIIIIIllllIII = new WorldGenTaiga2(true);
                    break;
                }
                break;
            }
            case 3: {
                lllllllllllllIIlIlllIIIIIllllIII = new WorldGenBirchTree(true, false);
                break;
            }
            case 4: {
                final IBlockState lllllllllllllIIlIlllIIIIIlllIlII = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
                final IBlockState lllllllllllllIIlIlllIIIIIlllIIll = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, false);
            Label_0321:
                for (lllllllllllllIIlIlllIIIIIlllIlll = 0; lllllllllllllIIlIlllIIIIIlllIlll >= -1; --lllllllllllllIIlIlllIIIIIlllIlll) {
                    for (lllllllllllllIIlIlllIIIIIlllIllI = 0; lllllllllllllIIlIlllIIIIIlllIllI >= -1; --lllllllllllllIIlIlllIIIIIlllIllI) {
                        if (this.isTwoByTwoOfType(lllllllllllllIIlIlllIIIIIlllllII, lllllllllllllIIlIlllIIIIIllllIll, lllllllllllllIIlIlllIIIIIlllIlll, lllllllllllllIIlIlllIIIIIlllIllI, BlockPlanks.EnumType.JUNGLE)) {
                            lllllllllllllIIlIlllIIIIIllllIII = new WorldGenMegaJungle(true, 10, 20, lllllllllllllIIlIlllIIIIIlllIlII, lllllllllllllIIlIlllIIIIIlllIIll);
                            lllllllllllllIIlIlllIIIIIlllIlIl = true;
                            break Label_0321;
                        }
                    }
                }
                if (!lllllllllllllIIlIlllIIIIIlllIlIl) {
                    lllllllllllllIIlIlllIIIIIlllIlll = 0;
                    lllllllllllllIIlIlllIIIIIlllIllI = 0;
                    lllllllllllllIIlIlllIIIIIllllIII = new WorldGenTrees(true, 4 + lllllllllllllIIlIlllIIIIIllIllIl.nextInt(7), lllllllllllllIIlIlllIIIIIlllIlII, lllllllllllllIIlIlllIIIIIlllIIll, false);
                    break;
                }
                break;
            }
            case 5: {
                lllllllllllllIIlIlllIIIIIllllIII = new WorldGenSavannaTree(true);
                break;
            }
            case 6: {
            Label_0434:
                for (lllllllllllllIIlIlllIIIIIlllIlll = 0; lllllllllllllIIlIlllIIIIIlllIlll >= -1; --lllllllllllllIIlIlllIIIIIlllIlll) {
                    for (lllllllllllllIIlIlllIIIIIlllIllI = 0; lllllllllllllIIlIlllIIIIIlllIllI >= -1; --lllllllllllllIIlIlllIIIIIlllIllI) {
                        if (this.isTwoByTwoOfType(lllllllllllllIIlIlllIIIIIlllllII, lllllllllllllIIlIlllIIIIIllllIll, lllllllllllllIIlIlllIIIIIlllIlll, lllllllllllllIIlIlllIIIIIlllIllI, BlockPlanks.EnumType.DARK_OAK)) {
                            lllllllllllllIIlIlllIIIIIllllIII = new WorldGenCanopyTree(true);
                            lllllllllllllIIlIlllIIIIIlllIlIl = true;
                            break Label_0434;
                        }
                    }
                }
                if (!lllllllllllllIIlIlllIIIIIlllIlIl) {
                    return;
                }
                break;
            }
        }
        final IBlockState lllllllllllllIIlIlllIIIIIlllIIlI = Blocks.AIR.getDefaultState();
        if (lllllllllllllIIlIlllIIIIIlllIlIl) {
            lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll, 0, lllllllllllllIIlIlllIIIIIlllIllI), lllllllllllllIIlIlllIIIIIlllIIlI, 4);
            lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll + 1, 0, lllllllllllllIIlIlllIIIIIlllIllI), lllllllllllllIIlIlllIIIIIlllIIlI, 4);
            lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll, 0, lllllllllllllIIlIlllIIIIIlllIllI + 1), lllllllllllllIIlIlllIIIIIlllIIlI, 4);
            lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll + 1, 0, lllllllllllllIIlIlllIIIIIlllIllI + 1), lllllllllllllIIlIlllIIIIIlllIIlI, 4);
        }
        else {
            lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll, lllllllllllllIIlIlllIIIIIlllIIlI, 4);
        }
        if (!lllllllllllllIIlIlllIIIIIllllIII.generate(lllllllllllllIIlIlllIIIIIlllllII, lllllllllllllIIlIlllIIIIIllIllIl, lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll, 0, lllllllllllllIIlIlllIIIIIlllIllI))) {
            if (lllllllllllllIIlIlllIIIIIlllIlIl) {
                lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll, 0, lllllllllllllIIlIlllIIIIIlllIllI), lllllllllllllIIlIlllIIIIIllIlllI, 4);
                lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll + 1, 0, lllllllllllllIIlIlllIIIIIlllIllI), lllllllllllllIIlIlllIIIIIllIlllI, 4);
                lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll, 0, lllllllllllllIIlIlllIIIIIlllIllI + 1), lllllllllllllIIlIlllIIIIIllIlllI, 4);
                lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll.add(lllllllllllllIIlIlllIIIIIlllIlll + 1, 0, lllllllllllllIIlIlllIIIIIlllIllI + 1), lllllllllllllIIlIlllIIIIIllIlllI, 4);
            }
            else {
                lllllllllllllIIlIlllIIIIIlllllII.setBlockState(lllllllllllllIIlIlllIIIIIllllIll, lllllllllllllIIlIlllIIIIIllIlllI, 4);
            }
        }
    }
    
    public void grow(final World lllllllllllllIIlIlllIIIIlIIIllII, final BlockPos lllllllllllllIIlIlllIIIIlIIIlIll, final IBlockState lllllllllllllIIlIlllIIIIlIIIlIlI, final Random lllllllllllllIIlIlllIIIIlIIIlIIl) {
        if (lllllllllllllIIlIlllIIIIlIIIlIlI.getValue((IProperty<Integer>)BlockSapling.STAGE) == 0) {
            lllllllllllllIIlIlllIIIIlIIIllII.setBlockState(lllllllllllllIIlIlllIIIIlIIIlIll, lllllllllllllIIlIlllIIIIlIIIlIlI.cycleProperty((IProperty<Comparable>)BlockSapling.STAGE), 4);
        }
        else {
            this.generateTree(lllllllllllllIIlIlllIIIIlIIIllII, lllllllllllllIIlIlllIIIIlIIIlIll, lllllllllllllIIlIlllIIIIlIIIlIlI, lllllllllllllIIlIlllIIIIlIIIlIIl);
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIlIlllIIIIlIlIllII, final IBlockAccess lllllllllllllIIlIlllIIIIlIlIlIll, final BlockPos lllllllllllllIIlIlllIIIIlIlIlIlI) {
        return BlockSapling.SAPLING_AABB;
    }
    
    public boolean isTypeAt(final World lllllllllllllIIlIlllIIIIIlIIlIIl, final BlockPos lllllllllllllIIlIlllIIIIIlIIllIl, final BlockPlanks.EnumType lllllllllllllIIlIlllIIIIIlIIllII) {
        final IBlockState lllllllllllllIIlIlllIIIIIlIIlIll = lllllllllllllIIlIlllIIIIIlIIlIIl.getBlockState(lllllllllllllIIlIlllIIIIIlIIllIl);
        return lllllllllllllIIlIlllIIIIIlIIlIll.getBlock() == this && lllllllllllllIIlIlllIIIIIlIIlIll.getValue(BlockSapling.TYPE) == lllllllllllllIIlIlllIIIIIlIIllII;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIlIlllIIIIIlIIIIlI) {
        return lllllllllllllIIlIlllIIIIIlIIIIlI.getValue(BlockSapling.TYPE).getMetadata();
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIlIlllIIIIIIIIlIll) {
        int lllllllllllllIIlIlllIIIIIIIIllII = 0;
        lllllllllllllIIlIlllIIIIIIIIllII |= lllllllllllllIIlIlllIIIIIIIIlIll.getValue(BlockSapling.TYPE).getMetadata();
        lllllllllllllIIlIlllIIIIIIIIllII |= lllllllllllllIIlIlllIIIIIIIIlIll.getValue((IProperty<Integer>)BlockSapling.STAGE) << 3;
        return lllllllllllllIIlIlllIIIIIIIIllII;
    }
}
