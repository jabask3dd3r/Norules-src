package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.util.text.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public class BlockBed extends BlockHorizontal implements ITileEntityProvider
{
    public static final /* synthetic */ PropertyEnum<EnumPartType> PART;
    protected static final /* synthetic */ AxisAlignedBB BED_AABB;
    public static final /* synthetic */ PropertyBool OCCUPIED;
    
    @Override
    public IBlockState getActualState(IBlockState lllllllllllllIIIlllllllllIlIIIIl, final IBlockAccess lllllllllllllIIIlllllllllIlIIlIl, final BlockPos lllllllllllllIIIlllllllllIIlllll) {
        if (lllllllllllllIIIlllllllllIlIIIIl.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            final IBlockState lllllllllllllIIIlllllllllIlIIIll = lllllllllllllIIIlllllllllIlIIlIl.getBlockState(lllllllllllllIIIlllllllllIIlllll.offset(lllllllllllllIIIlllllllllIlIIIIl.getValue((IProperty<EnumFacing>)BlockBed.FACING)));
            if (lllllllllllllIIIlllllllllIlIIIll.getBlock() == this) {
                lllllllllllllIIIlllllllllIlIIIIl = lllllllllllllIIIlllllllllIlIIIIl.withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, (Boolean)lllllllllllllIIIlllllllllIlIIIll.getValue((IProperty<V>)BlockBed.OCCUPIED));
            }
        }
        return lllllllllllllIIIlllllllllIlIIIIl;
    }
    
    @Nullable
    private EntityPlayer getPlayerInBed(final World lllllllllllllIIlIIIIIIIIlIIIlIII, final BlockPos lllllllllllllIIlIIIIIIIIlIIIIlll) {
        for (final EntityPlayer lllllllllllllIIlIIIIIIIIlIIIlIIl : lllllllllllllIIlIIIIIIIIlIIIlIII.playerEntities) {
            if (lllllllllllllIIlIIIIIIIIlIIIlIIl.isPlayerSleeping() && lllllllllllllIIlIIIIIIIIlIIIlIIl.bedLocation.equals(lllllllllllllIIlIIIIIIIIlIIIIlll)) {
                return lllllllllllllIIlIIIIIIIIlIIIlIIl;
            }
        }
        return null;
    }
    
    @Override
    public void onLanded(final World lllllllllllllIIlIIIIIIIIIllIlIlI, final Entity lllllllllllllIIlIIIIIIIIIllIlIIl) {
        if (lllllllllllllIIlIIIIIIIIIllIlIIl.isSneaking()) {
            super.onLanded(lllllllllllllIIlIIIIIIIIIllIlIlI, lllllllllllllIIlIIIIIIIIIllIlIIl);
        }
        else if (lllllllllllllIIlIIIIIIIIIllIlIIl.motionY < 0.0) {
            lllllllllllllIIlIIIIIIIIIllIlIIl.motionY = -lllllllllllllIIlIIIIIIIIIllIlIIl.motionY * 0.6600000262260437;
            if (!(lllllllllllllIIlIIIIIIIIIllIlIIl instanceof EntityLivingBase)) {
                lllllllllllllIIlIIIIIIIIIllIlIIl.motionY *= 0.8;
            }
        }
    }
    
    static {
        PART = PropertyEnum.create("part", EnumPartType.class);
        OCCUPIED = PropertyBool.create("occupied");
        BED_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5625, 1.0);
    }
    
    @Nullable
    public static BlockPos getSafeExitLocation(final World lllllllllllllIIlIIIIIIIIIIlIllIl, final BlockPos lllllllllllllIIlIIIIIIIIIIlllIll, int lllllllllllllIIlIIIIIIIIIIlIlIll) {
        final EnumFacing lllllllllllllIIlIIIIIIIIIIlllIIl = lllllllllllllIIlIIIIIIIIIIlIllIl.getBlockState(lllllllllllllIIlIIIIIIIIIIlllIll).getValue((IProperty<EnumFacing>)BlockBed.FACING);
        final int lllllllllllllIIlIIIIIIIIIIlllIII = lllllllllllllIIlIIIIIIIIIIlllIll.getX();
        final int lllllllllllllIIlIIIIIIIIIIllIlll = lllllllllllllIIlIIIIIIIIIIlllIll.getY();
        final int lllllllllllllIIlIIIIIIIIIIllIllI = lllllllllllllIIlIIIIIIIIIIlllIll.getZ();
        for (int lllllllllllllIIlIIIIIIIIIIllIlIl = 0; lllllllllllllIIlIIIIIIIIIIllIlIl <= 1; ++lllllllllllllIIlIIIIIIIIIIllIlIl) {
            final int lllllllllllllIIlIIIIIIIIIIllIlII = lllllllllllllIIlIIIIIIIIIIlllIII - lllllllllllllIIlIIIIIIIIIIlllIIl.getFrontOffsetX() * lllllllllllllIIlIIIIIIIIIIllIlIl - 1;
            final int lllllllllllllIIlIIIIIIIIIIllIIll = lllllllllllllIIlIIIIIIIIIIllIllI - lllllllllllllIIlIIIIIIIIIIlllIIl.getFrontOffsetZ() * lllllllllllllIIlIIIIIIIIIIllIlIl - 1;
            final int lllllllllllllIIlIIIIIIIIIIllIIlI = lllllllllllllIIlIIIIIIIIIIllIlII + 2;
            final int lllllllllllllIIlIIIIIIIIIIllIIIl = lllllllllllllIIlIIIIIIIIIIllIIll + 2;
            for (int lllllllllllllIIlIIIIIIIIIIllIIII = lllllllllllllIIlIIIIIIIIIIllIlII; lllllllllllllIIlIIIIIIIIIIllIIII <= lllllllllllllIIlIIIIIIIIIIllIIlI; ++lllllllllllllIIlIIIIIIIIIIllIIII) {
                for (int lllllllllllllIIlIIIIIIIIIIlIllll = lllllllllllllIIlIIIIIIIIIIllIIll; lllllllllllllIIlIIIIIIIIIIlIllll <= lllllllllllllIIlIIIIIIIIIIllIIIl; ++lllllllllllllIIlIIIIIIIIIIlIllll) {
                    final BlockPos lllllllllllllIIlIIIIIIIIIIlIlllI = new BlockPos(lllllllllllllIIlIIIIIIIIIIllIIII, lllllllllllllIIlIIIIIIIIIIllIlll, lllllllllllllIIlIIIIIIIIIIlIllll);
                    if (hasRoomForPlayer(lllllllllllllIIlIIIIIIIIIIlIllIl, lllllllllllllIIlIIIIIIIIIIlIlllI)) {
                        if (lllllllllllllIIlIIIIIIIIIIlIlIll <= 0) {
                            return lllllllllllllIIlIIIIIIIIIIlIlllI;
                        }
                        --lllllllllllllIIlIIIIIIIIIIlIlIll;
                    }
                }
            }
        }
        return null;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockBed.FACING, BlockBed.PART, BlockBed.OCCUPIED });
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllIIlIIIIIIIIIIIIlIll, final BlockPos lllllllllllllIIlIIIIIIIIIIIIlIlI, final IBlockState lllllllllllllIIlIIIIIIIIIIIlIIII, final float lllllllllllllIIlIIIIIIIIIIIIllll, final int lllllllllllllIIlIIIIIIIIIIIIlllI) {
        if (lllllllllllllIIlIIIIIIIIIIIlIIII.getValue(BlockBed.PART) == EnumPartType.HEAD) {
            final TileEntity lllllllllllllIIlIIIIIIIIIIIIllIl = lllllllllllllIIlIIIIIIIIIIIIlIll.getTileEntity(lllllllllllllIIlIIIIIIIIIIIIlIlI);
            final EnumDyeColor lllllllllllllIIlIIIIIIIIIIIIllII = (lllllllllllllIIlIIIIIIIIIIIIllIl instanceof TileEntityBed) ? ((TileEntityBed)lllllllllllllIIlIIIIIIIIIIIIllIl).func_193048_a() : EnumDyeColor.RED;
            Block.spawnAsEntity(lllllllllllllIIlIIIIIIIIIIIIlIll, lllllllllllllIIlIIIIIIIIIIIIlIlI, new ItemStack(Items.BED, 1, lllllllllllllIIlIIIIIIIIIIIIllII.getMetadata()));
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIlIIIIIIIIlIIIIIll) {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIIlIIIIIIIIIIIIIIlI) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIlllllllllIIIllII) {
        int lllllllllllllIIIlllllllllIIIlIll = 0;
        lllllllllllllIIIlllllllllIIIlIll |= lllllllllllllIIIlllllllllIIIllII.getValue((IProperty<EnumFacing>)BlockBed.FACING).getHorizontalIndex();
        if (lllllllllllllIIIlllllllllIIIllII.getValue(BlockBed.PART) == EnumPartType.HEAD) {
            lllllllllllllIIIlllllllllIIIlIll |= 0x8;
            if (lllllllllllllIIIlllllllllIIIllII.getValue((IProperty<Boolean>)BlockBed.OCCUPIED)) {
                lllllllllllllIIIlllllllllIIIlIll |= 0x4;
            }
        }
        return lllllllllllllIIIlllllllllIIIlIll;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIIIlllllllllIllllII, final BlockPos lllllllllllllIIIlllllllllIlllIll, final IBlockState lllllllllllllIIIlllllllllIlllIlI) {
        super.breakBlock(lllllllllllllIIIlllllllllIllllII, lllllllllllllIIIlllllllllIlllIll, lllllllllllllIIIlllllllllIlllIlI);
        lllllllllllllIIIlllllllllIllllII.removeTileEntity(lllllllllllllIIIlllllllllIlllIll);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIlllllllllIIIIlll, final IBlockState lllllllllllllIIIlllllllllIIIIllI, final BlockPos lllllllllllllIIIlllllllllIIIIlIl, final EnumFacing lllllllllllllIIIlllllllllIIIIlII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void onBlockHarvested(final World lllllllllllllIIIlllllllllllIIlll, final BlockPos lllllllllllllIIIlllllllllllIIIII, final IBlockState lllllllllllllIIIllllllllllIlllll, final EntityPlayer lllllllllllllIIIllllllllllIllllI) {
        if (lllllllllllllIIIllllllllllIllllI.capabilities.isCreativeMode && lllllllllllllIIIllllllllllIlllll.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            final BlockPos lllllllllllllIIIlllllllllllIIIll = lllllllllllllIIIlllllllllllIIIII.offset(lllllllllllllIIIllllllllllIlllll.getValue((IProperty<EnumFacing>)BlockBed.FACING));
            if (lllllllllllllIIIlllllllllllIIlll.getBlockState(lllllllllllllIIIlllllllllllIIIll).getBlock() == this) {
                lllllllllllllIIIlllllllllllIIlll.setBlockToAir(lllllllllllllIIIlllllllllllIIIll);
            }
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIIlIIIIIIIIIlIlIlIl, final Random lllllllllllllIIlIIIIIIIIIlIlIlII, final int lllllllllllllIIlIIIIIIIIIlIlIIll) {
        return (lllllllllllllIIlIIIIIIIIIlIlIlIl.getValue(BlockBed.PART) == EnumPartType.FOOT) ? Items.field_190931_a : Items.BED;
    }
    
    @Override
    public void harvestBlock(final World lllllllllllllIIIllllllllllIIlIIl, final EntityPlayer lllllllllllllIIIllllllllllIlIIIl, final BlockPos lllllllllllllIIIllllllllllIlIIII, final IBlockState lllllllllllllIIIllllllllllIIIllI, final TileEntity lllllllllllllIIIllllllllllIIIlIl, final ItemStack lllllllllllllIIIllllllllllIIIlII) {
        if (lllllllllllllIIIllllllllllIIIllI.getValue(BlockBed.PART) == EnumPartType.HEAD && lllllllllllllIIIllllllllllIIIlIl instanceof TileEntityBed) {
            final TileEntityBed lllllllllllllIIIllllllllllIIllII = (TileEntityBed)lllllllllllllIIIllllllllllIIIlIl;
            final ItemStack lllllllllllllIIIllllllllllIIlIll = lllllllllllllIIIllllllllllIIllII.func_193049_f();
            Block.spawnAsEntity(lllllllllllllIIIllllllllllIIlIIl, lllllllllllllIIIllllllllllIlIIII, lllllllllllllIIIllllllllllIIlIll);
        }
        else {
            super.harvestBlock(lllllllllllllIIIllllllllllIIlIIl, lllllllllllllIIIllllllllllIlIIIl, lllllllllllllIIIllllllllllIlIIII, lllllllllllllIIIllllllllllIIIllI, null, lllllllllllllIIIllllllllllIIIlII);
        }
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIlIIIIIIIIIlIlIIII, final IBlockAccess lllllllllllllIIlIIIIIIIIIlIIllll, final BlockPos lllllllllllllIIlIIIIIIIIIlIIlllI) {
        return BlockBed.BED_AABB;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIlIIIIIIIIIllIIIlI, final World lllllllllllllIIlIIIIIIIIIlIllIlI, final BlockPos lllllllllllllIIlIIIIIIIIIllIIIII, final Block lllllllllllllIIlIIIIIIIIIlIlllll, final BlockPos lllllllllllllIIlIIIIIIIIIlIllllI) {
        final EnumFacing lllllllllllllIIlIIIIIIIIIlIlllIl = lllllllllllllIIlIIIIIIIIIllIIIlI.getValue((IProperty<EnumFacing>)BlockBed.FACING);
        if (lllllllllllllIIlIIIIIIIIIllIIIlI.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            if (lllllllllllllIIlIIIIIIIIIlIllIlI.getBlockState(lllllllllllllIIlIIIIIIIIIllIIIII.offset(lllllllllllllIIlIIIIIIIIIlIlllIl)).getBlock() != this) {
                lllllllllllllIIlIIIIIIIIIlIllIlI.setBlockToAir(lllllllllllllIIlIIIIIIIIIllIIIII);
            }
        }
        else if (lllllllllllllIIlIIIIIIIIIlIllIlI.getBlockState(lllllllllllllIIlIIIIIIIIIllIIIII.offset(lllllllllllllIIlIIIIIIIIIlIlllIl.getOpposite())).getBlock() != this) {
            if (!lllllllllllllIIlIIIIIIIIIlIllIlI.isRemote) {
                this.dropBlockAsItem(lllllllllllllIIlIIIIIIIIIlIllIlI, lllllllllllllIIlIIIIIIIIIllIIIII, lllllllllllllIIlIIIIIIIIIllIIIlI, 0);
            }
            lllllllllllllIIlIIIIIIIIIlIllIlI.setBlockToAir(lllllllllllllIIlIIIIIIIIIllIIIII);
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public void onFallenUpon(final World lllllllllllllIIlIIIIIIIIIlllIlIl, final BlockPos lllllllllllllIIlIIIIIIIIIllllIIl, final Entity lllllllllllllIIlIIIIIIIIIllllIII, final float lllllllllllllIIlIIIIIIIIIlllIIlI) {
        super.onFallenUpon(lllllllllllllIIlIIIIIIIIIlllIlIl, lllllllllllllIIlIIIIIIIIIllllIIl, lllllllllllllIIlIIIIIIIIIllllIII, lllllllllllllIIlIIIIIIIIIlllIIlI * 0.5f);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIIIlllllllllIIlIIIl, final Mirror lllllllllllllIIIlllllllllIIlIIII) {
        return lllllllllllllIIIlllllllllIIlIIIl.withRotation(lllllllllllllIIIlllllllllIIlIIII.toRotation(lllllllllllllIIIlllllllllIIlIIIl.getValue((IProperty<EnumFacing>)BlockBed.FACING)));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIlllllllllIllIIIl) {
        final EnumFacing lllllllllllllIIIlllllllllIllIIII = EnumFacing.getHorizontal(lllllllllllllIIIlllllllllIllIIIl);
        return ((lllllllllllllIIIlllllllllIllIIIl & 0x8) > 0) ? this.getDefaultState().withProperty(BlockBed.PART, EnumPartType.HEAD).withProperty((IProperty<Comparable>)BlockBed.FACING, lllllllllllllIIIlllllllllIllIIII).withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, (lllllllllllllIIIlllllllllIllIIIl & 0x4) > 0) : this.getDefaultState().withProperty(BlockBed.PART, EnumPartType.FOOT).withProperty((IProperty<Comparable>)BlockBed.FACING, lllllllllllllIIIlllllllllIllIIII);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIIIllllllllllllIlII, final BlockPos lllllllllllllIIIllllllllllllIIll, final IBlockState lllllllllllllIIIllllllllllllIIlI) {
        BlockPos lllllllllllllIIIllllllllllllIlll = lllllllllllllIIIllllllllllllIIll;
        if (lllllllllllllIIIllllllllllllIIlI.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            lllllllllllllIIIllllllllllllIlll = lllllllllllllIIIllllllllllllIIll.offset(lllllllllllllIIIllllllllllllIIlI.getValue((IProperty<EnumFacing>)BlockBed.FACING));
        }
        final TileEntity lllllllllllllIIIllllllllllllIllI = lllllllllllllIIIllllllllllllIlII.getTileEntity(lllllllllllllIIIllllllllllllIlll);
        final EnumDyeColor lllllllllllllIIIllllllllllllIlIl = (lllllllllllllIIIllllllllllllIllI instanceof TileEntityBed) ? ((TileEntityBed)lllllllllllllIIIllllllllllllIllI).func_193048_a() : EnumDyeColor.RED;
        return new ItemStack(Items.BED, 1, lllllllllllllIIIllllllllllllIlIl.getMetadata());
    }
    
    protected static boolean hasRoomForPlayer(final World lllllllllllllIIlIIIIIIIIIIIllIlI, final BlockPos lllllllllllllIIlIIIIIIIIIIIllIIl) {
        return lllllllllllllIIlIIIIIIIIIIIllIlI.getBlockState(lllllllllllllIIlIIIIIIIIIIIllIIl.down()).isFullyOpaque() && !lllllllllllllIIlIIIIIIIIIIIllIlI.getBlockState(lllllllllllllIIlIIIIIIIIIIIllIIl).getMaterial().isSolid() && !lllllllllllllIIlIIIIIIIIIIIllIlI.getBlockState(lllllllllllllIIlIIIIIIIIIIIllIIl.up()).getMaterial().isSolid();
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIlIIIIIIIIlIlIIIlI, BlockPos lllllllllllllIIlIIIIIIIIlIIlIlII, IBlockState lllllllllllllIIlIIIIIIIIlIIlIIll, final EntityPlayer lllllllllllllIIlIIIIIIIIlIIlllll, final EnumHand lllllllllllllIIlIIIIIIIIlIIllllI, final EnumFacing lllllllllllllIIlIIIIIIIIlIIlllIl, final float lllllllllllllIIlIIIIIIIIlIIlllII, final float lllllllllllllIIlIIIIIIIIlIIllIll, final float lllllllllllllIIlIIIIIIIIlIIllIlI) {
        if (lllllllllllllIIlIIIIIIIIlIlIIIlI.isRemote) {
            return true;
        }
        if (((IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll).getValue(BlockBed.PART) != EnumPartType.HEAD) {
            lllllllllllllIIlIIIIIIIIlIIlIlII = lllllllllllllIIlIIIIIIIIlIIlIlII.offset(((IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll).getValue((IProperty<EnumFacing>)BlockBed.FACING));
            lllllllllllllIIlIIIIIIIIlIIlIIll = lllllllllllllIIlIIIIIIIIlIlIIIlI.getBlockState(lllllllllllllIIlIIIIIIIIlIIlIlII);
            if (((IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll).getBlock() != this) {
                return true;
            }
        }
        if (!lllllllllllllIIlIIIIIIIIlIlIIIlI.provider.canRespawnHere() || lllllllllllllIIlIIIIIIIIlIlIIIlI.getBiome(lllllllllllllIIlIIIIIIIIlIIlIlII) == Biomes.HELL) {
            lllllllllllllIIlIIIIIIIIlIlIIIlI.setBlockToAir(lllllllllllllIIlIIIIIIIIlIIlIlII);
            final BlockPos lllllllllllllIIlIIIIIIIIlIIlIlll = lllllllllllllIIlIIIIIIIIlIIlIlII.offset(((IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll).getValue((IProperty<EnumFacing>)BlockBed.FACING).getOpposite());
            if (lllllllllllllIIlIIIIIIIIlIlIIIlI.getBlockState(lllllllllllllIIlIIIIIIIIlIIlIlll).getBlock() == this) {
                lllllllllllllIIlIIIIIIIIlIlIIIlI.setBlockToAir(lllllllllllllIIlIIIIIIIIlIIlIlll);
            }
            lllllllllllllIIlIIIIIIIIlIlIIIlI.newExplosion(null, lllllllllllllIIlIIIIIIIIlIIlIlII.getX() + 0.5, lllllllllllllIIlIIIIIIIIlIIlIlII.getY() + 0.5, lllllllllllllIIlIIIIIIIIlIIlIlII.getZ() + 0.5, 5.0f, true, true);
            return true;
        }
        if (((IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll).getValue((IProperty<Boolean>)BlockBed.OCCUPIED)) {
            final EntityPlayer lllllllllllllIIlIIIIIIIIlIIllIIl = this.getPlayerInBed(lllllllllllllIIlIIIIIIIIlIlIIIlI, lllllllllllllIIlIIIIIIIIlIIlIlII);
            if (lllllllllllllIIlIIIIIIIIlIIllIIl != null) {
                lllllllllllllIIlIIIIIIIIlIIlllll.addChatComponentMessage(new TextComponentTranslation("tile.bed.occupied", new Object[0]), true);
                return true;
            }
            lllllllllllllIIlIIIIIIIIlIIlIIll = ((IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll).withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, Boolean.valueOf(false));
            lllllllllllllIIlIIIIIIIIlIlIIIlI.setBlockState(lllllllllllllIIlIIIIIIIIlIIlIlII, (IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll, 4);
        }
        final EntityPlayer.SleepResult lllllllllllllIIlIIIIIIIIlIIllIII = lllllllllllllIIlIIIIIIIIlIIlllll.trySleep(lllllllllllllIIlIIIIIIIIlIIlIlII);
        if (lllllllllllllIIlIIIIIIIIlIIllIII == EntityPlayer.SleepResult.OK) {
            lllllllllllllIIlIIIIIIIIlIIlIIll = ((IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll).withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, Boolean.valueOf(true));
            lllllllllllllIIlIIIIIIIIlIlIIIlI.setBlockState(lllllllllllllIIlIIIIIIIIlIIlIlII, (IBlockState)lllllllllllllIIlIIIIIIIIlIIlIIll, 4);
            return true;
        }
        if (lllllllllllllIIlIIIIIIIIlIIllIII == EntityPlayer.SleepResult.NOT_POSSIBLE_NOW) {
            lllllllllllllIIlIIIIIIIIlIIlllll.addChatComponentMessage(new TextComponentTranslation("tile.bed.noSleep", new Object[0]), true);
        }
        else if (lllllllllllllIIlIIIIIIIIlIIllIII == EntityPlayer.SleepResult.NOT_SAFE) {
            lllllllllllllIIlIIIIIIIIlIIlllll.addChatComponentMessage(new TextComponentTranslation("tile.bed.notSafe", new Object[0]), true);
        }
        else if (lllllllllllllIIlIIIIIIIIlIIllIII == EntityPlayer.SleepResult.TOO_FAR_AWAY) {
            lllllllllllllIIlIIIIIIIIlIIlllll.addChatComponentMessage(new TextComponentTranslation("tile.bed.tooFarAway", new Object[0]), true);
        }
        return true;
    }
    
    public static boolean func_193385_b(final int lllllllllllllIIIllllllllIlllllII) {
        return (lllllllllllllIIIllllllllIlllllII & 0x8) != 0x0;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIlIIIIIIIIlIlIlllI, final IBlockAccess lllllllllllllIIlIIIIIIIIlIlIllIl, final BlockPos lllllllllllllIIlIIIIIIIIlIlIllII) {
        if (lllllllllllllIIlIIIIIIIIlIlIlllI.getValue(BlockBed.PART) == EnumPartType.FOOT) {
            final TileEntity lllllllllllllIIlIIIIIIIIlIllIIII = lllllllllllllIIlIIIIIIIIlIlIllIl.getTileEntity(lllllllllllllIIlIIIIIIIIlIlIllII);
            if (lllllllllllllIIlIIIIIIIIlIllIIII instanceof TileEntityBed) {
                final EnumDyeColor lllllllllllllIIlIIIIIIIIlIlIllll = ((TileEntityBed)lllllllllllllIIlIIIIIIIIlIllIIII).func_193048_a();
                return MapColor.func_193558_a(lllllllllllllIIlIIIIIIIIlIlIllll);
            }
        }
        return MapColor.CLOTH;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIlIIIIIIIIlIIIIIIl) {
        return false;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIlllllllllIIllIII, final Rotation lllllllllllllIIIlllllllllIIllIIl) {
        return lllllllllllllIIIlllllllllIIllIII.withProperty((IProperty<Comparable>)BlockBed.FACING, lllllllllllllIIIlllllllllIIllIIl.rotate(lllllllllllllIIIlllllllllIIllIII.getValue((IProperty<EnumFacing>)BlockBed.FACING)));
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllllIIlIIIIIIIIIlIIllII) {
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIIIllllllllIlllllll, final int lllllllllllllIIIllllllllIllllllI) {
        return new TileEntityBed();
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lllllllllllllIIlIIIIIIIIIIIIIlIl) {
        return EnumPushReaction.DESTROY;
    }
    
    public BlockBed() {
        super(Material.CLOTH);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockBed.PART, EnumPartType.FOOT).withProperty((IProperty<Comparable>)BlockBed.OCCUPIED, false));
        this.isBlockContainer = true;
    }
    
    public enum EnumPartType implements IStringSerializable
    {
        private final /* synthetic */ String name;
        
        HEAD("HEAD", 0, "head"), 
        FOOT("FOOT", 1, "foot");
        
        @Override
        public String toString() {
            return this.name;
        }
        
        private EnumPartType(final String lllllllllllllllIllIllllIIllIIIII, final int lllllllllllllllIllIllllIIlIlllll, final String lllllllllllllllIllIllllIIllIIIlI) {
            this.name = lllllllllllllllIllIllllIIllIIIlI;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
    }
}
