package net.minecraft.block;

import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.state.*;

public class BlockBush extends Block
{
    protected static final /* synthetic */ AxisAlignedBB BUSH_AABB;
    
    protected boolean canSustainBush(final IBlockState llllllllllllllIlIIlIIlIllllIlIII) {
        return llllllllllllllIlIIlIIlIllllIlIII.getBlock() == Blocks.GRASS || llllllllllllllIlIIlIIlIllllIlIII.getBlock() == Blocks.DIRT || llllllllllllllIlIIlIIlIllllIlIII.getBlock() == Blocks.FARMLAND;
    }
    
    protected void checkAndDropBlock(final World llllllllllllllIlIIlIIlIllIlllllI, final BlockPos llllllllllllllIlIIlIIlIlllIIIIIl, final IBlockState llllllllllllllIlIIlIIlIlllIIIIII) {
        if (!this.canBlockStay(llllllllllllllIlIIlIIlIllIlllllI, llllllllllllllIlIIlIIlIlllIIIIIl, llllllllllllllIlIIlIIlIlllIIIIII)) {
            this.dropBlockAsItem(llllllllllllllIlIIlIIlIllIlllllI, llllllllllllllIlIIlIIlIlllIIIIIl, llllllllllllllIlIIlIIlIlllIIIIII, 0);
            llllllllllllllIlIIlIIlIllIlllllI.setBlockState(llllllllllllllIlIIlIIlIlllIIIIIl, Blocks.AIR.getDefaultState(), 3);
        }
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllIlIIlIIlIllIlIllII, final IBlockAccess llllllllllllllIlIIlIIlIllIlIlIll, final BlockPos llllllllllllllIlIIlIIlIllIlIlIlI) {
        return BlockBush.NULL_AABB;
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIlIIlIIlIllIlIIllI) {
        return false;
    }
    
    protected BlockBush(final Material llllllllllllllIlIIlIIlIlllllIlIl, final MapColor llllllllllllllIlIIlIIlIlllllIlII) {
        super(llllllllllllllIlIIlIIlIlllllIlIl, llllllllllllllIlIIlIIlIlllllIlII);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    static {
        BUSH_AABB = new AxisAlignedBB(0.30000001192092896, 0.0, 0.30000001192092896, 0.699999988079071, 0.6000000238418579, 0.699999988079071);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIlIIlIIlIlllIllIIl, final World llllllllllllllIlIIlIIlIlllIllllI, final BlockPos llllllllllllllIlIIlIIlIlllIlIlll, final Block llllllllllllllIlIIlIIlIlllIlIllI, final BlockPos llllllllllllllIlIIlIIlIlllIlIlIl) {
        super.neighborChanged(llllllllllllllIlIIlIIlIlllIllIIl, llllllllllllllIlIIlIIlIlllIllllI, llllllllllllllIlIIlIIlIlllIlIlll, llllllllllllllIlIIlIIlIlllIlIllI, llllllllllllllIlIIlIIlIlllIlIlIl);
        this.checkAndDropBlock(llllllllllllllIlIIlIIlIlllIllllI, llllllllllllllIlIIlIIlIlllIlIlll, llllllllllllllIlIIlIIlIlllIllIIl);
    }
    
    @Override
    public void updateTick(final World llllllllllllllIlIIlIIlIlllIIlIlI, final BlockPos llllllllllllllIlIIlIIlIlllIIlllI, final IBlockState llllllllllllllIlIIlIIlIlllIIllIl, final Random llllllllllllllIlIIlIIlIlllIIllII) {
        this.checkAndDropBlock(llllllllllllllIlIIlIIlIlllIIlIlI, llllllllllllllIlIIlIIlIlllIIlllI, llllllllllllllIlIIlIIlIlllIIllIl);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIlIIlIIlIllIllIIII, final IBlockAccess llllllllllllllIlIIlIIlIllIlIllll, final BlockPos llllllllllllllIlIIlIIlIllIlIlllI) {
        return BlockBush.BUSH_AABB;
    }
    
    public boolean canBlockStay(final World llllllllllllllIlIIlIIlIllIllIlll, final BlockPos llllllllllllllIlIIlIIlIllIllIIlI, final IBlockState llllllllllllllIlIIlIIlIllIllIlIl) {
        return this.canSustainBush(llllllllllllllIlIIlIIlIllIllIlll.getBlockState(llllllllllllllIlIIlIIlIllIllIIlI.down()));
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIlIIlIIlIllIlIlIII) {
        return false;
    }
    
    protected BlockBush() {
        this(Material.PLANTS);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIlIIlIIlIllIlIIIll, final IBlockState llllllllllllllIlIIlIIlIllIlIIIlI, final BlockPos llllllllllllllIlIIlIIlIllIlIIIIl, final EnumFacing llllllllllllllIlIIlIIlIllIlIIIII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    protected BlockBush(final Material llllllllllllllIlIIlIIlIlllllllll) {
        this(llllllllllllllIlIIlIIlIlllllllll, llllllllllllllIlIIlIIlIlllllllll.getMaterialMapColor());
    }
    
    @Override
    public boolean canPlaceBlockAt(final World llllllllllllllIlIIlIIlIllllIllll, final BlockPos llllllllllllllIlIIlIIlIllllIlllI) {
        return super.canPlaceBlockAt(llllllllllllllIlIIlIIlIllllIllll, llllllllllllllIlIIlIIlIllllIlllI) && this.canSustainBush(llllllllllllllIlIIlIIlIllllIllll.getBlockState(llllllllllllllIlIIlIIlIllllIlllI.down()));
    }
}
