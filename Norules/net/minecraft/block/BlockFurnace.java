package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.inventory.*;

public class BlockFurnace extends BlockContainer
{
    private final /* synthetic */ boolean isBurning;
    private static /* synthetic */ boolean keepInventory;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIlIIIIIIIllIlIlll, final BlockPos lllllllllllllllIlIIIIIIIllIlIllI, final IBlockState lllllllllllllllIlIIIIIIIllIlllll, final EntityPlayer lllllllllllllllIlIIIIIIIllIlIlIl, final EnumHand lllllllllllllllIlIIIIIIIllIlllIl, final EnumFacing lllllllllllllllIlIIIIIIIllIlllII, final float lllllllllllllllIlIIIIIIIllIllIll, final float lllllllllllllllIlIIIIIIIllIllIlI, final float lllllllllllllllIlIIIIIIIllIllIIl) {
        if (lllllllllllllllIlIIIIIIIllIlIlll.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllllIlIIIIIIIllIllIII = lllllllllllllllIlIIIIIIIllIlIlll.getTileEntity(lllllllllllllllIlIIIIIIIllIlIllI);
        if (lllllllllllllllIlIIIIIIIllIllIII instanceof TileEntityFurnace) {
            lllllllllllllllIlIIIIIIIllIlIlIl.displayGUIChest((IInventory)lllllllllllllllIlIIIIIIIllIllIII);
            lllllllllllllllIlIIIIIIIllIlIlIl.addStat(StatList.FURNACE_INTERACTION);
        }
        return true;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllllIlIIIIIIIlIIlIllI, final BlockPos lllllllllllllllIlIIIIIIIlIIlIlIl, final IBlockState lllllllllllllllIlIIIIIIIlIIlIlII) {
        if (!BlockFurnace.keepInventory) {
            final TileEntity lllllllllllllllIlIIIIIIIlIIllIII = lllllllllllllllIlIIIIIIIlIIlIllI.getTileEntity(lllllllllllllllIlIIIIIIIlIIlIlIl);
            if (lllllllllllllllIlIIIIIIIlIIllIII instanceof TileEntityFurnace) {
                InventoryHelper.dropInventoryItems(lllllllllllllllIlIIIIIIIlIIlIllI, lllllllllllllllIlIIIIIIIlIIlIlIl, (IInventory)lllllllllllllllIlIIIIIIIlIIllIII);
                lllllllllllllllIlIIIIIIIlIIlIllI.updateComparatorOutputLevel(lllllllllllllllIlIIIIIIIlIIlIlIl, this);
            }
        }
        super.breakBlock(lllllllllllllllIlIIIIIIIlIIlIllI, lllllllllllllllIlIIIIIIIlIIlIlIl, lllllllllllllllIlIIIIIIIlIIlIlII);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIlIIIIIIlIIlIIIll, final BlockPos lllllllllllllllIlIIIIIIlIIlIIllI, final IBlockState lllllllllllllllIlIIIIIIlIIlIIlIl) {
        this.setDefaultFacing(lllllllllllllllIlIIIIIIlIIlIIIll, lllllllllllllllIlIIIIIIlIIlIIllI, lllllllllllllllIlIIIIIIlIIlIIlIl);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockFurnace.FACING });
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllllIlIIIIIIIIllIlIIl, final Mirror lllllllllllllllIlIIIIIIIIllIlIlI) {
        return lllllllllllllllIlIIIIIIIIllIlIIl.withRotation(lllllllllllllllIlIIIIIIIIllIlIlI.toRotation(lllllllllllllllIlIIIIIIIIllIlIIl.getValue((IProperty<EnumFacing>)BlockFurnace.FACING)));
    }
    
    protected BlockFurnace(final boolean lllllllllllllllIlIIIIIIlIIllIIIl) {
        super(Material.ROCK);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, EnumFacing.NORTH));
        this.isBurning = lllllllllllllllIlIIIIIIlIIllIIIl;
    }
    
    public static void setState(final boolean lllllllllllllllIlIIIIIIIllIIlllI, final World lllllllllllllllIlIIIIIIIllIIllIl, final BlockPos lllllllllllllllIlIIIIIIIllIIllII) {
        final IBlockState lllllllllllllllIlIIIIIIIllIIlIll = lllllllllllllllIlIIIIIIIllIIllIl.getBlockState(lllllllllllllllIlIIIIIIIllIIllII);
        final TileEntity lllllllllllllllIlIIIIIIIllIIlIlI = lllllllllllllllIlIIIIIIIllIIllIl.getTileEntity(lllllllllllllllIlIIIIIIIllIIllII);
        BlockFurnace.keepInventory = true;
        if (lllllllllllllllIlIIIIIIIllIIlllI) {
            lllllllllllllllIlIIIIIIIllIIllIl.setBlockState(lllllllllllllllIlIIIIIIIllIIllII, Blocks.LIT_FURNACE.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, (EnumFacing)lllllllllllllllIlIIIIIIIllIIlIll.getValue((IProperty<V>)BlockFurnace.FACING)), 3);
            lllllllllllllllIlIIIIIIIllIIllIl.setBlockState(lllllllllllllllIlIIIIIIIllIIllII, Blocks.LIT_FURNACE.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, (EnumFacing)lllllllllllllllIlIIIIIIIllIIlIll.getValue((IProperty<V>)BlockFurnace.FACING)), 3);
        }
        else {
            lllllllllllllllIlIIIIIIIllIIllIl.setBlockState(lllllllllllllllIlIIIIIIIllIIllII, Blocks.FURNACE.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, (EnumFacing)lllllllllllllllIlIIIIIIIllIIlIll.getValue((IProperty<V>)BlockFurnace.FACING)), 3);
            lllllllllllllllIlIIIIIIIllIIllIl.setBlockState(lllllllllllllllIlIIIIIIIllIIllII, Blocks.FURNACE.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, (EnumFacing)lllllllllllllllIlIIIIIIIllIIlIll.getValue((IProperty<V>)BlockFurnace.FACING)), 3);
        }
        BlockFurnace.keepInventory = false;
        if (lllllllllllllllIlIIIIIIIllIIlIlI != null) {
            lllllllllllllllIlIIIIIIIllIIlIlI.validate();
            lllllllllllllllIlIIIIIIIllIIllIl.setTileEntity(lllllllllllllllIlIIIIIIIllIIllII, lllllllllllllllIlIIIIIIIllIIlIlI);
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = BlockFurnace.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final char lllllllllllllllIlIIIIIIIIllIIIll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllllIlIIIIIIIIllIIIll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIlIIIIIIIIllIIIll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIlIIIIIIIIllIIIll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIlIIIIIIIIllIIIll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIlIIIIIIIIllIIIll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIlIIIIIIIIllIIIll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockFurnace.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllllIlIIIIIIIIllIIIll;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllllIlIIIIIIIlIlIllIl, final BlockPos lllllllllllllllIlIIIIIIIlIlIllII, final IBlockState lllllllllllllllIlIIIIIIIlIlIlIll, final EntityLivingBase lllllllllllllllIlIIIIIIIlIlIlIlI, final ItemStack lllllllllllllllIlIIIIIIIlIlIIIll) {
        lllllllllllllllIlIIIIIIIlIlIllIl.setBlockState(lllllllllllllllIlIIIIIIIlIlIllII, lllllllllllllllIlIIIIIIIlIlIlIll.withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIIIIIlIlIlIlI.getHorizontalFacing().getOpposite()), 2);
        if (lllllllllllllllIlIIIIIIIlIlIIIll.hasDisplayName()) {
            final TileEntity lllllllllllllllIlIIIIIIIlIlIlIII = lllllllllllllllIlIIIIIIIlIlIllIl.getTileEntity(lllllllllllllllIlIIIIIIIlIlIllII);
            if (lllllllllllllllIlIIIIIIIlIlIlIII instanceof TileEntityFurnace) {
                ((TileEntityFurnace)lllllllllllllllIlIIIIIIIlIlIlIII).setCustomInventoryName(lllllllllllllllIlIIIIIIIlIlIIIll.getDisplayName());
            }
        }
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllllIlIIIIIIIlIIIIlll, final BlockPos lllllllllllllllIlIIIIIIIlIIIIllI, final IBlockState lllllllllllllllIlIIIIIIIlIIIIlIl) {
        return new ItemStack(Blocks.FURNACE);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllIlIIIIIIIlIlllllI, final BlockPos lllllllllllllllIlIIIIIIIlIllllIl, final EnumFacing lllllllllllllllIlIIIIIIIlIllllII, final float lllllllllllllllIlIIIIIIIlIlllIll, final float lllllllllllllllIlIIIIIIIlIlllIlI, final float lllllllllllllllIlIIIIIIIlIlllIIl, final int lllllllllllllllIlIIIIIIIlIlllIII, final EntityLivingBase lllllllllllllllIlIIIIIIIlIllIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIIIIIlIllIlll.getHorizontalFacing().getOpposite());
    }
    
    private void setDefaultFacing(final World lllllllllllllllIlIIIIIIlIIIlIlll, final BlockPos lllllllllllllllIlIIIIIIlIIIIlllI, final IBlockState lllllllllllllllIlIIIIIIlIIIIllIl) {
        if (!lllllllllllllllIlIIIIIIlIIIlIlll.isRemote) {
            final IBlockState lllllllllllllllIlIIIIIIlIIIlIlII = lllllllllllllllIlIIIIIIlIIIlIlll.getBlockState(lllllllllllllllIlIIIIIIlIIIIlllI.north());
            final IBlockState lllllllllllllllIlIIIIIIlIIIlIIll = lllllllllllllllIlIIIIIIlIIIlIlll.getBlockState(lllllllllllllllIlIIIIIIlIIIIlllI.south());
            final IBlockState lllllllllllllllIlIIIIIIlIIIlIIlI = lllllllllllllllIlIIIIIIlIIIlIlll.getBlockState(lllllllllllllllIlIIIIIIlIIIIlllI.west());
            final IBlockState lllllllllllllllIlIIIIIIlIIIlIIIl = lllllllllllllllIlIIIIIIlIIIlIlll.getBlockState(lllllllllllllllIlIIIIIIlIIIIlllI.east());
            EnumFacing lllllllllllllllIlIIIIIIlIIIlIIII = lllllllllllllllIlIIIIIIlIIIIllIl.getValue((IProperty<EnumFacing>)BlockFurnace.FACING);
            if (lllllllllllllllIlIIIIIIlIIIlIIII == EnumFacing.NORTH && lllllllllllllllIlIIIIIIlIIIlIlII.isFullBlock() && !lllllllllllllllIlIIIIIIlIIIlIIll.isFullBlock()) {
                lllllllllllllllIlIIIIIIlIIIlIIII = EnumFacing.SOUTH;
            }
            else if (lllllllllllllllIlIIIIIIlIIIlIIII == EnumFacing.SOUTH && lllllllllllllllIlIIIIIIlIIIlIIll.isFullBlock() && !lllllllllllllllIlIIIIIIlIIIlIlII.isFullBlock()) {
                lllllllllllllllIlIIIIIIlIIIlIIII = EnumFacing.NORTH;
            }
            else if (lllllllllllllllIlIIIIIIlIIIlIIII == EnumFacing.WEST && lllllllllllllllIlIIIIIIlIIIlIIlI.isFullBlock() && !lllllllllllllllIlIIIIIIlIIIlIIIl.isFullBlock()) {
                lllllllllllllllIlIIIIIIlIIIlIIII = EnumFacing.EAST;
            }
            else if (lllllllllllllllIlIIIIIIlIIIlIIII == EnumFacing.EAST && lllllllllllllllIlIIIIIIlIIIlIIIl.isFullBlock() && !lllllllllllllllIlIIIIIIlIIIlIIlI.isFullBlock()) {
                lllllllllllllllIlIIIIIIlIIIlIIII = EnumFacing.WEST;
            }
            lllllllllllllllIlIIIIIIlIIIlIlll.setBlockState(lllllllllllllllIlIIIIIIlIIIIlllI, lllllllllllllllIlIIIIIIlIIIIllIl.withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIIIIlIIIlIIII), 2);
        }
    }
    
    static {
        FACING = BlockHorizontal.FACING;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lllllllllllllllIlIIIIIIIlIIlIIIl) {
        return true;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllllIlIIIIIIlIIlIllll, final Random lllllllllllllllIlIIIIIIlIIlIlllI, final int lllllllllllllllIlIIIIIIlIIlIllIl) {
        return Item.getItemFromBlock(Blocks.FURNACE);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIlIIIIIIIIlllIllI) {
        return lllllllllllllllIlIIIIIIIIlllIllI.getValue((IProperty<EnumFacing>)BlockFurnace.FACING).getIndex();
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllIlIIIIIIIIlllIIII, final Rotation lllllllllllllllIlIIIIIIIIlllIIIl) {
        return lllllllllllllllIlIIIIIIIIlllIIII.withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIIIIIIlllIIIl.rotate(lllllllllllllllIlIIIIIIIIlllIIII.getValue((IProperty<EnumFacing>)BlockFurnace.FACING)));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIlIIIIIIIIllllIll) {
        EnumFacing lllllllllllllllIlIIIIIIIIlllllIl = EnumFacing.getFront(lllllllllllllllIlIIIIIIIIllllIll);
        if (lllllllllllllllIlIIIIIIIIlllllIl.getAxis() == EnumFacing.Axis.Y) {
            lllllllllllllllIlIIIIIIIIlllllIl = EnumFacing.NORTH;
        }
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockFurnace.FACING, lllllllllllllllIlIIIIIIIIlllllIl);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllllIlIIIIIIIllIIIIll, final int lllllllllllllllIlIIIIIIIllIIIIlI) {
        return new TileEntityFurnace();
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllllIlIIIIIIIllllIIII, final World lllllllllllllllIlIIIIIIIlllIllll, final BlockPos lllllllllllllllIlIIIIIIIlllllIIl, final Random lllllllllllllllIlIIIIIIIlllllIII) {
        if (this.isBurning) {
            final EnumFacing lllllllllllllllIlIIIIIIIllllIlll = lllllllllllllllIlIIIIIIIllllIIII.getValue((IProperty<EnumFacing>)BlockFurnace.FACING);
            final double lllllllllllllllIlIIIIIIIllllIllI = lllllllllllllllIlIIIIIIIlllllIIl.getX() + 0.5;
            final double lllllllllllllllIlIIIIIIIllllIlIl = lllllllllllllllIlIIIIIIIlllllIIl.getY() + lllllllllllllllIlIIIIIIIlllllIII.nextDouble() * 6.0 / 16.0;
            final double lllllllllllllllIlIIIIIIIllllIlII = lllllllllllllllIlIIIIIIIlllllIIl.getZ() + 0.5;
            final double lllllllllllllllIlIIIIIIIllllIIll = 0.52;
            final double lllllllllllllllIlIIIIIIIllllIIlI = lllllllllllllllIlIIIIIIIlllllIII.nextDouble() * 0.6 - 0.3;
            if (lllllllllllllllIlIIIIIIIlllllIII.nextDouble() < 0.1) {
                lllllllllllllllIlIIIIIIIlllIllll.playSound(lllllllllllllllIlIIIIIIIlllllIIl.getX() + 0.5, lllllllllllllllIlIIIIIIIlllllIIl.getY(), lllllllllllllllIlIIIIIIIlllllIIl.getZ() + 0.5, SoundEvents.BLOCK_FURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
            }
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllllIlIIIIIIIllllIlll.ordinal()]) {
                case 5: {
                    lllllllllllllllIlIIIIIIIlllIllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlIIIIIIIllllIllI - 0.52, lllllllllllllllIlIIIIIIIllllIlIl, lllllllllllllllIlIIIIIIIllllIlII + lllllllllllllllIlIIIIIIIllllIIlI, 0.0, 0.0, 0.0, new int[0]);
                    lllllllllllllllIlIIIIIIIlllIllll.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlIIIIIIIllllIllI - 0.52, lllllllllllllllIlIIIIIIIllllIlIl, lllllllllllllllIlIIIIIIIllllIlII + lllllllllllllllIlIIIIIIIllllIIlI, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 6: {
                    lllllllllllllllIlIIIIIIIlllIllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlIIIIIIIllllIllI + 0.52, lllllllllllllllIlIIIIIIIllllIlIl, lllllllllllllllIlIIIIIIIllllIlII + lllllllllllllllIlIIIIIIIllllIIlI, 0.0, 0.0, 0.0, new int[0]);
                    lllllllllllllllIlIIIIIIIlllIllll.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlIIIIIIIllllIllI + 0.52, lllllllllllllllIlIIIIIIIllllIlIl, lllllllllllllllIlIIIIIIIllllIlII + lllllllllllllllIlIIIIIIIllllIIlI, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 3: {
                    lllllllllllllllIlIIIIIIIlllIllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlIIIIIIIllllIllI + lllllllllllllllIlIIIIIIIllllIIlI, lllllllllllllllIlIIIIIIIllllIlIl, lllllllllllllllIlIIIIIIIllllIlII - 0.52, 0.0, 0.0, 0.0, new int[0]);
                    lllllllllllllllIlIIIIIIIlllIllll.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlIIIIIIIllllIllI + lllllllllllllllIlIIIIIIIllllIIlI, lllllllllllllllIlIIIIIIIllllIlIl, lllllllllllllllIlIIIIIIIllllIlII - 0.52, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
                case 4: {
                    lllllllllllllllIlIIIIIIIlllIllll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlIIIIIIIllllIllI + lllllllllllllllIlIIIIIIIllllIIlI, lllllllllllllllIlIIIIIIIllllIlIl, lllllllllllllllIlIIIIIIIllllIlII + 0.52, 0.0, 0.0, 0.0, new int[0]);
                    lllllllllllllllIlIIIIIIIlllIllll.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlIIIIIIIllllIllI + lllllllllllllllIlIIIIIIIllllIIlI, lllllllllllllllIlIIIIIIIllllIlIl, lllllllllllllllIlIIIIIIIllllIlII + 0.52, 0.0, 0.0, 0.0, new int[0]);
                    break;
                }
            }
        }
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllllIlIIIIIIIlIIIIIll) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lllllllllllllllIlIIIIIIIlIIIllIl, final World lllllllllllllllIlIIIIIIIlIIIllII, final BlockPos lllllllllllllllIlIIIIIIIlIIIlIll) {
        return Container.calcRedstone(lllllllllllllllIlIIIIIIIlIIIllII.getTileEntity(lllllllllllllllIlIIIIIIIlIIIlIll));
    }
}
