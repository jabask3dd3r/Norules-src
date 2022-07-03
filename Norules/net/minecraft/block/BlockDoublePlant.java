package net.minecraft.block;

import net.minecraft.entity.player.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.stats.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockDoublePlant extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyEnum<EnumPlantType> VARIANT;
    public static final /* synthetic */ PropertyEnum<EnumBlockHalf> HALF;
    public static final /* synthetic */ PropertyEnum<EnumFacing> FACING;
    
    @Override
    public void onBlockHarvested(final World lllllllllllllIIIIIIlllIlIIlIllII, final BlockPos lllllllllllllIIIIIIlllIlIIlIIlII, final IBlockState lllllllllllllIIIIIIlllIlIIlIIIll, final EntityPlayer lllllllllllllIIIIIIlllIlIIlIIIlI) {
        if (lllllllllllllIIIIIIlllIlIIlIIIll.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) {
            if (lllllllllllllIIIIIIlllIlIIlIllII.getBlockState(lllllllllllllIIIIIIlllIlIIlIIlII.down()).getBlock() == this) {
                if (lllllllllllllIIIIIIlllIlIIlIIIlI.capabilities.isCreativeMode) {
                    lllllllllllllIIIIIIlllIlIIlIllII.setBlockToAir(lllllllllllllIIIIIIlllIlIIlIIlII.down());
                }
                else {
                    final IBlockState lllllllllllllIIIIIIlllIlIIlIlIII = lllllllllllllIIIIIIlllIlIIlIllII.getBlockState(lllllllllllllIIIIIIlllIlIIlIIlII.down());
                    final EnumPlantType lllllllllllllIIIIIIlllIlIIlIIlll = lllllllllllllIIIIIIlllIlIIlIlIII.getValue(BlockDoublePlant.VARIANT);
                    if (lllllllllllllIIIIIIlllIlIIlIIlll != EnumPlantType.FERN && lllllllllllllIIIIIIlllIlIIlIIlll != EnumPlantType.GRASS) {
                        lllllllllllllIIIIIIlllIlIIlIllII.destroyBlock(lllllllllllllIIIIIIlllIlIIlIIlII.down(), true);
                    }
                    else if (lllllllllllllIIIIIIlllIlIIlIllII.isRemote) {
                        lllllllllllllIIIIIIlllIlIIlIllII.setBlockToAir(lllllllllllllIIIIIIlllIlIIlIIlII.down());
                    }
                    else if (!lllllllllllllIIIIIIlllIlIIlIIIlI.getHeldItemMainhand().func_190926_b() && lllllllllllllIIIIIIlllIlIIlIIIlI.getHeldItemMainhand().getItem() == Items.SHEARS) {
                        this.onHarvest(lllllllllllllIIIIIIlllIlIIlIllII, lllllllllllllIIIIIIlllIlIIlIIlII, lllllllllllllIIIIIIlllIlIIlIlIII, lllllllllllllIIIIIIlllIlIIlIIIlI);
                        lllllllllllllIIIIIIlllIlIIlIllII.setBlockToAir(lllllllllllllIIIIIIlllIlIIlIIlII.down());
                    }
                    else {
                        lllllllllllllIIIIIIlllIlIIlIllII.destroyBlock(lllllllllllllIIIIIIlllIlIIlIIlII.down(), true);
                    }
                }
            }
        }
        else if (lllllllllllllIIIIIIlllIlIIlIllII.getBlockState(lllllllllllllIIIIIIlllIlIIlIIlII.up()).getBlock() == this) {
            lllllllllllllIIIIIIlllIlIIlIllII.setBlockState(lllllllllllllIIIIIIlllIlIIlIIlII.up(), Blocks.AIR.getDefaultState(), 2);
        }
        super.onBlockHarvested(lllllllllllllIIIIIIlllIlIIlIllII, lllllllllllllIIIIIIlllIlIIlIIlII, lllllllllllllIIIIIIlllIlIIlIIIll, lllllllllllllIIIIIIlllIlIIlIIIlI);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIIIIIlllIlIIIIIIll, final NonNullList<ItemStack> lllllllllllllIIIIIIlllIlIIIIIIlI) {
        char lllllllllllllIIIIIIlllIIlllllIll;
        for (String lllllllllllllIIIIIIlllIIllllllII = (String)((EnumPlantType[])(Object)(lllllllllllllIIIIIIlllIIlllllIll = (char)(Object)EnumPlantType.values())).length, lllllllllllllIIIIIIlllIIllllllIl = (String)0; lllllllllllllIIIIIIlllIIllllllIl < lllllllllllllIIIIIIlllIIllllllII; ++lllllllllllllIIIIIIlllIIllllllIl) {
            final EnumPlantType lllllllllllllIIIIIIlllIlIIIIIIIl = lllllllllllllIIIIIIlllIIlllllIll[lllllllllllllIIIIIIlllIIllllllIl];
            lllllllllllllIIIIIIlllIlIIIIIIlI.add(new ItemStack(this, 1, lllllllllllllIIIIIIlllIlIIIIIIIl.getMeta()));
        }
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess lllllllllllllIIIIIIlllIllIlIIlIl, final BlockPos lllllllllllllIIIIIIlllIllIlIIlII) {
        final IBlockState lllllllllllllIIIIIIlllIllIlIlIII = lllllllllllllIIIIIIlllIllIlIIlIl.getBlockState(lllllllllllllIIIIIIlllIllIlIIlII);
        if (lllllllllllllIIIIIIlllIllIlIlIII.getBlock() != this) {
            return true;
        }
        final EnumPlantType lllllllllllllIIIIIIlllIllIlIIlll = lllllllllllllIIIIIIlllIllIlIlIII.getActualState(lllllllllllllIIIIIIlllIllIlIIlIl, lllllllllllllIIIIIIlllIllIlIIlII).getValue(BlockDoublePlant.VARIANT);
        return lllllllllllllIIIIIIlllIllIlIIlll == EnumPlantType.FERN || lllllllllllllIIIIIIlllIllIlIIlll == EnumPlantType.GRASS;
    }
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XZ;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIIIIlllIIlIllIlII) {
        return (lllllllllllllIIIIIIlllIIlIllIlII.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) ? (0x8 | lllllllllllllIIIIIIlllIIlIllIlII.getValue(BlockDoublePlant.FACING).getHorizontalIndex()) : lllllllllllllIIIIIIlllIIlIllIlII.getValue(BlockDoublePlant.VARIANT).getMeta();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIIIIlllIlllIIlIII, final IBlockAccess lllllllllllllIIIIIIlllIlllIIIlll, final BlockPos lllllllllllllIIIIIIlllIlllIIIllI) {
        return BlockDoublePlant.FULL_BLOCK_AABB;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllIIIIIIlllIlIlIIlIll, final BlockPos lllllllllllllIIIIIIlllIlIlIlIIII, final IBlockState lllllllllllllIIIIIIlllIlIlIIllll, final EntityLivingBase lllllllllllllIIIIIIlllIlIlIIlllI, final ItemStack lllllllllllllIIIIIIlllIlIlIIllIl) {
        lllllllllllllIIIIIIlllIlIlIIlIll.setBlockState(lllllllllllllIIIIIIlllIlIlIlIIII.up(), this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.UPPER), 2);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDoublePlant.HALF, BlockDoublePlant.VARIANT, BlockDoublePlant.FACING });
    }
    
    @Override
    public boolean canBlockStay(final World lllllllllllllIIIIIIlllIlIllllIll, final BlockPos lllllllllllllIIIIIIlllIlIllllIlI, final IBlockState lllllllllllllIIIIIIlllIlIllllllI) {
        if (lllllllllllllIIIIIIlllIlIllllllI.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) {
            return lllllllllllllIIIIIIlllIlIllllIll.getBlockState(lllllllllllllIIIIIIlllIlIllllIlI.down()).getBlock() == this;
        }
        final IBlockState lllllllllllllIIIIIIlllIlIlllllIl = lllllllllllllIIIIIIlllIlIllllIll.getBlockState(lllllllllllllIIIIIIlllIlIllllIlI.up());
        return lllllllllllllIIIIIIlllIlIlllllIl.getBlock() == this && super.canBlockStay(lllllllllllllIIIIIIlllIlIllllIll, lllllllllllllIIIIIIlllIlIllllIlI, lllllllllllllIIIIIIlllIlIlllllIl);
    }
    
    public void placeAt(final World lllllllllllllIIIIIIlllIlIlIllllI, final BlockPos lllllllllllllIIIIIIlllIlIlIlllIl, final EnumPlantType lllllllllllllIIIIIIlllIlIlIlIlll, final int lllllllllllllIIIIIIlllIlIlIlIllI) {
        lllllllllllllIIIIIIlllIlIlIllllI.setBlockState(lllllllllllllIIIIIIlllIlIlIlllIl, this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.LOWER).withProperty(BlockDoublePlant.VARIANT, lllllllllllllIIIIIIlllIlIlIlIlll), lllllllllllllIIIIIIlllIlIlIlIllI);
        lllllllllllllIIIIIIlllIlIlIllllI.setBlockState(lllllllllllllIIIIIIlllIlIlIlllIl.up(), this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.UPPER), lllllllllllllIIIIIIlllIlIlIlIllI);
    }
    
    @Override
    protected void checkAndDropBlock(final World lllllllllllllIIIIIIlllIllIIIlllI, final BlockPos lllllllllllllIIIIIIlllIllIIIllIl, final IBlockState lllllllllllllIIIIIIlllIllIIIllII) {
        if (!this.canBlockStay(lllllllllllllIIIIIIlllIllIIIlllI, lllllllllllllIIIIIIlllIllIIIllIl, lllllllllllllIIIIIIlllIllIIIllII)) {
            final boolean lllllllllllllIIIIIIlllIllIIlIlII = lllllllllllllIIIIIIlllIllIIIllII.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER;
            final BlockPos lllllllllllllIIIIIIlllIllIIlIIll = lllllllllllllIIIIIIlllIllIIlIlII ? lllllllllllllIIIIIIlllIllIIIllIl : lllllllllllllIIIIIIlllIllIIIllIl.up();
            final BlockPos lllllllllllllIIIIIIlllIllIIlIIlI = lllllllllllllIIIIIIlllIllIIlIlII ? lllllllllllllIIIIIIlllIllIIIllIl.down() : lllllllllllllIIIIIIlllIllIIIllIl;
            final Block lllllllllllllIIIIIIlllIllIIlIIIl = lllllllllllllIIIIIIlllIllIIlIlII ? this : lllllllllllllIIIIIIlllIllIIIlllI.getBlockState(lllllllllllllIIIIIIlllIllIIlIIll).getBlock();
            final Block lllllllllllllIIIIIIlllIllIIlIIII = lllllllllllllIIIIIIlllIllIIlIlII ? lllllllllllllIIIIIIlllIllIIIlllI.getBlockState(lllllllllllllIIIIIIlllIllIIlIIlI).getBlock() : this;
            if (lllllllllllllIIIIIIlllIllIIlIIIl == this) {
                lllllllllllllIIIIIIlllIllIIIlllI.setBlockState(lllllllllllllIIIIIIlllIllIIlIIll, Blocks.AIR.getDefaultState(), 2);
            }
            if (lllllllllllllIIIIIIlllIllIIlIIII == this) {
                lllllllllllllIIIIIIlllIllIIIlllI.setBlockState(lllllllllllllIIIIIIlllIllIIlIIlI, Blocks.AIR.getDefaultState(), 3);
                if (!lllllllllllllIIIIIIlllIllIIlIlII) {
                    this.dropBlockAsItem(lllllllllllllIIIIIIlllIllIIIlllI, lllllllllllllIIIIIIlllIllIIlIIlI, lllllllllllllIIIIIIlllIllIIIllII, 0);
                }
            }
        }
    }
    
    private EnumPlantType getType(final IBlockAccess lllllllllllllIIIIIIlllIlllIIIIII, final BlockPos lllllllllllllIIIIIIlllIllIlllIll, IBlockState lllllllllllllIIIIIIlllIllIlllIlI) {
        if (lllllllllllllIIIIIIlllIllIlllIlI.getBlock() == this) {
            lllllllllllllIIIIIIlllIllIlllIlI = lllllllllllllIIIIIIlllIllIlllIlI.getActualState(lllllllllllllIIIIIIlllIlllIIIIII, lllllllllllllIIIIIIlllIllIlllIll);
            return lllllllllllllIIIIIIlllIllIlllIlI.getValue(BlockDoublePlant.VARIANT);
        }
        return EnumPlantType.FERN;
    }
    
    @Override
    public boolean canGrow(final World lllllllllllllIIIIIIlllIIlllIlIII, final BlockPos lllllllllllllIIIIIIlllIIlllIIIIl, final IBlockState lllllllllllllIIIIIIlllIIlllIIIII, final boolean lllllllllllllIIIIIIlllIIlllIIlIl) {
        final EnumPlantType lllllllllllllIIIIIIlllIIlllIIlII = this.getType(lllllllllllllIIIIIIlllIIlllIlIII, lllllllllllllIIIIIIlllIIlllIIIIl, lllllllllllllIIIIIIlllIIlllIIIII);
        return lllllllllllllIIIIIIlllIIlllIIlII != EnumPlantType.GRASS && lllllllllllllIIIIIIlllIIlllIIlII != EnumPlantType.FERN;
    }
    
    private boolean onHarvest(final World lllllllllllllIIIIIIlllIlIIIlIlll, final BlockPos lllllllllllllIIIIIIlllIlIIIlIllI, final IBlockState lllllllllllllIIIIIIlllIlIIIIlllI, final EntityPlayer lllllllllllllIIIIIIlllIlIIIIllIl) {
        final EnumPlantType lllllllllllllIIIIIIlllIlIIIlIIll = lllllllllllllIIIIIIlllIlIIIIlllI.getValue(BlockDoublePlant.VARIANT);
        if (lllllllllllllIIIIIIlllIlIIIlIIll != EnumPlantType.FERN && lllllllllllllIIIIIIlllIlIIIlIIll != EnumPlantType.GRASS) {
            return false;
        }
        lllllllllllllIIIIIIlllIlIIIIllIl.addStat(StatList.getBlockStats(this));
        final int lllllllllllllIIIIIIlllIlIIIlIIlI = ((lllllllllllllIIIIIIlllIlIIIlIIll == EnumPlantType.GRASS) ? BlockTallGrass.EnumType.GRASS : BlockTallGrass.EnumType.FERN).getMeta();
        Block.spawnAsEntity(lllllllllllllIIIIIIlllIlIIIlIlll, lllllllllllllIIIIIIlllIlIIIlIllI, new ItemStack(Blocks.TALLGRASS, 2, lllllllllllllIIIIIIlllIlIIIlIIlI));
        return true;
    }
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllIIIIIIlllIIlIlllIll, final IBlockAccess lllllllllllllIIIIIIlllIIlIllllll, final BlockPos lllllllllllllIIIIIIlllIIlIlllllI) {
        if (lllllllllllllIIIIIIlllIIlIlllIll.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) {
            final IBlockState lllllllllllllIIIIIIlllIIlIllllIl = lllllllllllllIIIIIIlllIIlIllllll.getBlockState(lllllllllllllIIIIIIlllIIlIlllllI.down());
            if (lllllllllllllIIIIIIlllIIlIllllIl.getBlock() == this) {
                lllllllllllllIIIIIIlllIIlIlllIll = lllllllllllllIIIIIIlllIIlIlllIll.withProperty(BlockDoublePlant.VARIANT, (EnumPlantType)lllllllllllllIIIIIIlllIIlIllllIl.getValue((IProperty<V>)BlockDoublePlant.VARIANT));
            }
        }
        return lllllllllllllIIIIIIlllIIlIlllIll;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIIIIIlllIlIllIllII, final Random lllllllllllllIIIIIIlllIlIlllIIII, final int lllllllllllllIIIIIIlllIlIllIllll) {
        if (lllllllllllllIIIIIIlllIlIllIllII.getValue(BlockDoublePlant.HALF) == EnumBlockHalf.UPPER) {
            return Items.field_190931_a;
        }
        final EnumPlantType lllllllllllllIIIIIIlllIlIllIlllI = lllllllllllllIIIIIIlllIlIllIllII.getValue(BlockDoublePlant.VARIANT);
        if (lllllllllllllIIIIIIlllIlIllIlllI == EnumPlantType.FERN) {
            return Items.field_190931_a;
        }
        if (lllllllllllllIIIIIIlllIlIllIlllI == EnumPlantType.GRASS) {
            return (lllllllllllllIIIIIIlllIlIlllIIII.nextInt(8) == 0) ? Items.WHEAT_SEEDS : Items.field_190931_a;
        }
        return super.getItemDropped(lllllllllllllIIIIIIlllIlIllIllII, lllllllllllllIIIIIIlllIlIlllIIII, lllllllllllllIIIIIIlllIlIllIllll);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIIIIlllIIllIIIlll) {
        return ((lllllllllllllIIIIIIlllIIllIIIlll & 0x8) > 0) ? this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.UPPER) : this.getDefaultState().withProperty(BlockDoublePlant.HALF, EnumBlockHalf.LOWER).withProperty(BlockDoublePlant.VARIANT, EnumPlantType.byMetadata(lllllllllllllIIIIIIlllIIllIIIlll & 0x7));
    }
    
    @Override
    public void grow(final World lllllllllllllIIIIIIlllIIllIlIlII, final Random lllllllllllllIIIIIIlllIIllIlIIll, final BlockPos lllllllllllllIIIIIIlllIIllIlIIlI, final IBlockState lllllllllllllIIIIIIlllIIllIlIIIl) {
        Block.spawnAsEntity(lllllllllllllIIIIIIlllIIllIlIlII, lllllllllllllIIIIIIlllIIllIlIIlI, new ItemStack(this, 1, this.getType(lllllllllllllIIIIIIlllIIllIlIlII, lllllllllllllIIIIIIlllIIllIlIIlI, lllllllllllllIIIIIIlllIIllIlIIIl).getMeta()));
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumPlantType.class);
        HALF = PropertyEnum.create("half", EnumBlockHalf.class);
        FACING = BlockHorizontal.FACING;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllIIIIIIlllIlIIlllIlI, final EntityPlayer lllllllllllllIIIIIIlllIlIIlllIIl, final BlockPos lllllllllllllIIIIIIlllIlIIlllIII, final IBlockState lllllllllllllIIIIIIlllIlIIllIlll, @Nullable final TileEntity lllllllllllllIIIIIIlllIlIIllllIl, final ItemStack lllllllllllllIIIIIIlllIlIIllllII) {
        if (lllllllllllllIIIIIIlllIlIIlllIlI.isRemote || lllllllllllllIIIIIIlllIlIIllllII.getItem() != Items.SHEARS || lllllllllllllIIIIIIlllIlIIllIlll.getValue(BlockDoublePlant.HALF) != EnumBlockHalf.LOWER || !this.onHarvest(lllllllllllllIIIIIIlllIlIIlllIlI, lllllllllllllIIIIIIlllIlIIlllIII, lllllllllllllIIIIIIlllIlIIllIlll, lllllllllllllIIIIIIlllIlIIlllIIl)) {
            super.harvestBlock(lllllllllllllIIIIIIlllIlIIlllIlI, lllllllllllllIIIIIIlllIlIIlllIIl, lllllllllllllIIIIIIlllIlIIlllIII, lllllllllllllIIIIIIlllIlIIllIlll, lllllllllllllIIIIIIlllIlIIllllIl, lllllllllllllIIIIIIlllIlIIllllII);
        }
    }
    
    @Override
    public boolean canUseBonemeal(final World lllllllllllllIIIIIIlllIIllIlllIl, final Random lllllllllllllIIIIIIlllIIllIlllII, final BlockPos lllllllllllllIIIIIIlllIIllIllIll, final IBlockState lllllllllllllIIIIIIlllIIllIllIlI) {
        return true;
    }
    
    public BlockDoublePlant() {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockDoublePlant.VARIANT, EnumPlantType.SUNFLOWER).withProperty(BlockDoublePlant.HALF, EnumBlockHalf.LOWER).withProperty(BlockDoublePlant.FACING, EnumFacing.NORTH));
        this.setHardness(0.0f);
        this.setSoundType(SoundType.PLANT);
        this.setUnlocalizedName("doublePlant");
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIIIIIlllIlIllIIllI) {
        return (lllllllllllllIIIIIIlllIlIllIIllI.getValue(BlockDoublePlant.HALF) != EnumBlockHalf.UPPER && lllllllllllllIIIIIIlllIlIllIIllI.getValue(BlockDoublePlant.VARIANT) != EnumPlantType.GRASS) ? lllllllllllllIIIIIIlllIlIllIIllI.getValue(BlockDoublePlant.VARIANT).getMeta() : 0;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIIIIIIlllIllIllIIlI, final BlockPos lllllllllllllIIIIIIlllIllIllIlII) {
        return super.canPlaceBlockAt(lllllllllllllIIIIIIlllIllIllIIlI, lllllllllllllIIIIIIlllIllIllIlII) && lllllllllllllIIIIIIlllIllIllIIlI.isAirBlock(lllllllllllllIIIIIIlllIllIllIlII.up());
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIIIIIlllIIllllIIIl, final BlockPos lllllllllllllIIIIIIlllIIllllIlII, final IBlockState lllllllllllllIIIIIIlllIIlllIllll) {
        return new ItemStack(this, 1, this.getType(lllllllllllllIIIIIIlllIIllllIIIl, lllllllllllllIIIIIIlllIIllllIlII, lllllllllllllIIIIIIlllIIlllIllll).getMeta());
    }
    
    public enum EnumPlantType implements IStringSerializable
    {
        ROSE("ROSE", 4, 4, "double_rose", "rose");
        
        private final /* synthetic */ String unlocalizedName;
        
        FERN("FERN", 3, 3, "double_fern", "fern"), 
        GRASS("GRASS", 2, 2, "double_grass", "grass");
        
        private final /* synthetic */ int meta;
        
        SYRINGA("SYRINGA", 1, 1, "syringa");
        
        private final /* synthetic */ String name;
        private static final /* synthetic */ EnumPlantType[] META_LOOKUP;
        
        SUNFLOWER("SUNFLOWER", 0, 0, "sunflower"), 
        PAEONIA("PAEONIA", 5, 5, "paeonia");
        
        public int getMeta() {
            return this.meta;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        private EnumPlantType(final String llllllllllllllIIllIlIllIllIIlIll, final int llllllllllllllIIllIlIllIllIIlIlI, final int llllllllllllllIIllIlIllIllIIlIIl, final String llllllllllllllIIllIlIllIllIIllIl) {
            this(llllllllllllllIIllIlIllIllIIlIll, llllllllllllllIIllIlIllIllIIlIlI, llllllllllllllIIllIlIllIllIIlIIl, llllllllllllllIIllIlIllIllIIllIl, llllllllllllllIIllIlIllIllIIllIl);
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        public static EnumPlantType byMetadata(int llllllllllllllIIllIlIllIlIlIllll) {
            if (llllllllllllllIIllIlIllIlIlIllll < 0 || llllllllllllllIIllIlIllIlIlIllll >= EnumPlantType.META_LOOKUP.length) {
                llllllllllllllIIllIlIllIlIlIllll = 0;
            }
            return EnumPlantType.META_LOOKUP[llllllllllllllIIllIlIllIlIlIllll];
        }
        
        private EnumPlantType(final String llllllllllllllIIllIlIllIlIllllII, final int llllllllllllllIIllIlIllIlIlllIll, final int llllllllllllllIIllIlIllIlIlllIlI, final String llllllllllllllIIllIlIllIlIlllIIl, final String llllllllllllllIIllIlIllIlIlllllI) {
            this.meta = llllllllllllllIIllIlIllIlIlllIlI;
            this.name = llllllllllllllIIllIlIllIlIlllIIl;
            this.unlocalizedName = llllllllllllllIIllIlIllIlIlllllI;
        }
        
        static {
            META_LOOKUP = new EnumPlantType[values().length];
            final Exception llllllllllllllIIllIlIllIllIlIlIl;
            final char llllllllllllllIIllIlIllIllIlIllI = (char)((EnumPlantType[])(Object)(llllllllllllllIIllIlIllIllIlIlIl = (Exception)(Object)values())).length;
            for (float llllllllllllllIIllIlIllIllIlIlll = 0; llllllllllllllIIllIlIllIllIlIlll < llllllllllllllIIllIlIllIllIlIllI; ++llllllllllllllIIllIlIllIllIlIlll) {
                final EnumPlantType llllllllllllllIIllIlIllIllIllIIl = llllllllllllllIIllIlIllIllIlIlIl[llllllllllllllIIllIlIllIllIlIlll];
                EnumPlantType.META_LOOKUP[llllllllllllllIIllIlIllIllIllIIl.getMeta()] = llllllllllllllIIllIlIllIllIllIIl;
            }
        }
    }
    
    public enum EnumBlockHalf implements IStringSerializable
    {
        LOWER("LOWER", 1), 
        UPPER("UPPER", 0);
        
        private EnumBlockHalf(final String llllllllllllllIlIIIllIIlIlllIIIl, final int llllllllllllllIlIIIllIIlIlllIIII) {
        }
        
        @Override
        public String getName() {
            return (this == EnumBlockHalf.UPPER) ? "upper" : "lower";
        }
        
        @Override
        public String toString() {
            return this.getName();
        }
    }
}
