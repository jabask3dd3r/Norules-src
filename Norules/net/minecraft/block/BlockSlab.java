package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;

public abstract class BlockSlab extends Block
{
    protected static final /* synthetic */ AxisAlignedBB AABB_TOP_HALF;
    protected static final /* synthetic */ AxisAlignedBB AABB_BOTTOM_HALF;
    public static final /* synthetic */ PropertyEnum<EnumBlockHalf> HALF;
    
    public abstract String getUnlocalizedName(final int p0);
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIIIllIIIIIIlIIlII, final IBlockAccess lllllllllllllllIIIllIIIIIIlIIIll, final BlockPos lllllllllllllllIIIllIIIIIIlIIIlI) {
        if (this.isDouble()) {
            return BlockSlab.FULL_BLOCK_AABB;
        }
        return (lllllllllllllllIIIllIIIIIIlIIlII.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP) ? BlockSlab.AABB_TOP_HALF : BlockSlab.AABB_BOTTOM_HALF;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllllIIIlIlllllllIlIlI) {
        return this.isDouble();
    }
    
    static {
        HALF = PropertyEnum.create("half", EnumBlockHalf.class);
        AABB_BOTTOM_HALF = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0);
        AABB_TOP_HALF = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 1.0, 1.0);
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return false;
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllllIIIlIlllllllIlllI) {
        return this.isDouble() ? 2 : 1;
    }
    
    public BlockSlab(final Material lllllllllllllllIIIllIIIIIIllIIlI) {
        this(lllllllllllllllIIIllIIIIIIllIIlI, lllllllllllllllIIIllIIIIIIllIIlI.getMaterialMapColor());
    }
    
    public abstract IProperty<?> getVariantProperty();
    
    protected static boolean isHalfSlab(final IBlockState lllllllllllllllIIIlIllllllIIllII) {
        final Block lllllllllllllllIIIlIllllllIIllIl = lllllllllllllllIIIlIllllllIIllII.getBlock();
        return lllllllllllllllIIIlIllllllIIllIl == Blocks.STONE_SLAB || lllllllllllllllIIIlIllllllIIllIl == Blocks.WOODEN_SLAB || lllllllllllllllIIIlIllllllIIllIl == Blocks.STONE_SLAB2 || lllllllllllllllIIIlIllllllIIllIl == Blocks.PURPUR_SLAB;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllllIIIllIIIIIIIllIII, final IBlockState lllllllllllllllIIIllIIIIIIIlIlll, final BlockPos lllllllllllllllIIIllIIIIIIIlIllI, final EnumFacing lllllllllllllllIIIllIIIIIIIlIlIl) {
        if (((BlockSlab)lllllllllllllllIIIllIIIIIIIlIlll.getBlock()).isDouble()) {
            return BlockFaceShape.SOLID;
        }
        if (lllllllllllllllIIIllIIIIIIIlIlIl == EnumFacing.UP && lllllllllllllllIIIllIIIIIIIlIlll.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP) {
            return BlockFaceShape.SOLID;
        }
        return (lllllllllllllllIIIllIIIIIIIlIlIl == EnumFacing.DOWN && lllllllllllllllIIIllIIIIIIIlIlll.getValue(BlockSlab.HALF) == EnumBlockHalf.BOTTOM) ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
    }
    
    public abstract boolean isDouble();
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllllIIIllIIIIIIIlIIII) {
        return this.isDouble();
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllllIIIlIllllllIlIlll, final IBlockAccess lllllllllllllllIIIlIllllllIlIllI, final BlockPos lllllllllllllllIIIlIllllllIlllIl, final EnumFacing lllllllllllllllIIIlIllllllIlllII) {
        if (this.isDouble()) {
            return super.shouldSideBeRendered(lllllllllllllllIIIlIllllllIlIlll, lllllllllllllllIIIlIllllllIlIllI, lllllllllllllllIIIlIllllllIlllIl, lllllllllllllllIIIlIllllllIlllII);
        }
        if (lllllllllllllllIIIlIllllllIlllII != EnumFacing.UP && lllllllllllllllIIIlIllllllIlllII != EnumFacing.DOWN && !super.shouldSideBeRendered(lllllllllllllllIIIlIllllllIlIlll, lllllllllllllllIIIlIllllllIlIllI, lllllllllllllllIIIlIllllllIlllIl, lllllllllllllllIIIlIllllllIlllII)) {
            return false;
        }
        final IBlockState lllllllllllllllIIIlIllllllIllIll = lllllllllllllllIIIlIllllllIlIllI.getBlockState(lllllllllllllllIIIlIllllllIlllIl.offset(lllllllllllllllIIIlIllllllIlllII));
        final boolean lllllllllllllllIIIlIllllllIllIlI = isHalfSlab(lllllllllllllllIIIlIllllllIllIll) && lllllllllllllllIIIlIllllllIllIll.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP;
        final boolean lllllllllllllllIIIlIllllllIllIIl = isHalfSlab(lllllllllllllllIIIlIllllllIlIlll) && lllllllllllllllIIIlIllllllIlIlll.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP;
        if (lllllllllllllllIIIlIllllllIllIIl) {
            return lllllllllllllllIIIlIllllllIlllII == EnumFacing.DOWN || (lllllllllllllllIIIlIllllllIlllII == EnumFacing.UP && super.shouldSideBeRendered(lllllllllllllllIIIlIllllllIlIlll, lllllllllllllllIIIlIllllllIlIllI, lllllllllllllllIIIlIllllllIlllIl, lllllllllllllllIIIlIllllllIlllII)) || !isHalfSlab(lllllllllllllllIIIlIllllllIllIll) || !lllllllllllllllIIIlIllllllIllIlI;
        }
        return lllllllllllllllIIIlIllllllIlllII == EnumFacing.UP || (lllllllllllllllIIIlIllllllIlllII == EnumFacing.DOWN && super.shouldSideBeRendered(lllllllllllllllIIIlIllllllIlIlll, lllllllllllllllIIIlIllllllIlIllI, lllllllllllllllIIIlIllllllIlllIl, lllllllllllllllIIIlIllllllIlllII)) || !isHalfSlab(lllllllllllllllIIIlIllllllIllIll) || lllllllllllllllIIIlIllllllIllIlI;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllIIIllIIIIIIIIIIll, final BlockPos lllllllllllllllIIIlIlllllllllIII, final EnumFacing lllllllllllllllIIIlIllllllllIlll, final float lllllllllllllllIIIlIllllllllIllI, final float lllllllllllllllIIIlIllllllllllll, final float lllllllllllllllIIIlIlllllllllllI, final int lllllllllllllllIIIlIllllllllllIl, final EntityLivingBase lllllllllllllllIIIlIllllllllllII) {
        final IBlockState lllllllllllllllIIIlIlllllllllIll = super.onBlockPlaced(lllllllllllllllIIIllIIIIIIIIIIll, lllllllllllllllIIIlIlllllllllIII, lllllllllllllllIIIlIllllllllIlll, lllllllllllllllIIIlIllllllllIllI, lllllllllllllllIIIlIllllllllllll, lllllllllllllllIIIlIlllllllllllI, lllllllllllllllIIIlIllllllllllIl, lllllllllllllllIIIlIllllllllllII).withProperty(BlockSlab.HALF, EnumBlockHalf.BOTTOM);
        if (this.isDouble()) {
            return lllllllllllllllIIIlIlllllllllIll;
        }
        return (lllllllllllllllIIIlIllllllllIlll != EnumFacing.DOWN && (lllllllllllllllIIIlIllllllllIlll == EnumFacing.UP || lllllllllllllllIIIlIllllllllllll <= 0.5)) ? lllllllllllllllIIIlIlllllllllIll : lllllllllllllllIIIlIlllllllllIll.withProperty(BlockSlab.HALF, EnumBlockHalf.TOP);
    }
    
    public abstract Comparable<?> getTypeForItem(final ItemStack p0);
    
    @Override
    public boolean isFullyOpaque(final IBlockState lllllllllllllllIIIllIIIIIIIlllII) {
        return ((BlockSlab)lllllllllllllllIIIllIIIIIIIlllII.getBlock()).isDouble() || lllllllllllllllIIIllIIIIIIIlllII.getValue(BlockSlab.HALF) == EnumBlockHalf.TOP;
    }
    
    public BlockSlab(final Material lllllllllllllllIIIllIIIIIIlIlIlI, final MapColor lllllllllllllllIIIllIIIIIIlIlIIl) {
        super(lllllllllllllllIIIllIIIIIIlIlIlI, lllllllllllllllIIIllIIIIIIlIlIIl);
        this.fullBlock = this.isDouble();
        this.setLightOpacity(255);
    }
    
    public enum EnumBlockHalf implements IStringSerializable
    {
        private final /* synthetic */ String name;
        
        TOP("TOP", 0, "top"), 
        BOTTOM("BOTTOM", 1, "bottom");
        
        private EnumBlockHalf(final String lllllllllllllIlIlllIIIllIIlllIll, final int lllllllllllllIlIlllIIIllIIlllIlI, final String lllllllllllllIlIlllIIIllIIlllIIl) {
            this.name = lllllllllllllIlIlllIIIllIIlllIIl;
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
