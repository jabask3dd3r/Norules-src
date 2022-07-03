package net.minecraft.block;

import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import java.util.*;
import net.minecraft.block.state.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockEndGateway extends BlockContainer
{
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIllIIllIIIllllIIIl) {
        return false;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState llllllllllllllIllIIllIIIllllIlll, final IBlockAccess llllllllllllllIllIIllIIIllllIllI, final BlockPos llllllllllllllIllIIllIIIllllIlIl) {
        return BlockEndGateway.NULL_AABB;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIllIIllIIIllIIIlII, final BlockPos llllllllllllllIllIIllIIIllIIIIll, final IBlockState llllllllllllllIllIIllIIIllIIIIlI) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllIllIIllIIlIIIIIIll, final IBlockAccess llllllllllllllIllIIllIIIllllllIl, final BlockPos llllllllllllllIllIIllIIlIIIIIIIl, final EnumFacing llllllllllllllIllIIllIIlIIIIIIII) {
        final IBlockState llllllllllllllIllIIllIIIllllllll = llllllllllllllIllIIllIIIllllllIl.getBlockState(llllllllllllllIllIIllIIlIIIIIIIl.offset(llllllllllllllIllIIllIIlIIIIIIII));
        final Block llllllllllllllIllIIllIIIlllllllI = llllllllllllllIllIIllIIIllllllll.getBlock();
        return !llllllllllllllIllIIllIIIllllllll.isOpaqueCube() && llllllllllllllIllIIllIIIlllllllI != Blocks.END_GATEWAY;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIllIIllIIIlllIllll) {
        return 0;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIllIIllIIIlIllllII, final IBlockState llllllllllllllIllIIllIIIlIlllIll, final BlockPos llllllllllllllIllIIllIIIlIlllIlI, final EnumFacing llllllllllllllIllIIllIIIlIlllIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    protected BlockEndGateway(final Material llllllllllllllIllIIllIIlIIIIllIl) {
        super(llllllllllllllIllIIllIIlIIIIllIl);
        this.setLightLevel(1.0f);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIllIIllIIIllllIIll) {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIllIIllIIlIIIIlIll, final int llllllllllllllIllIIllIIlIIIIlIlI) {
        return new TileEntityEndGateway();
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllIllIIllIIIlllIIIII, final World llllllllllllllIllIIllIIIllIlIIlI, final BlockPos llllllllllllllIllIIllIIIllIllllI, final Random llllllllllllllIllIIllIIIllIlllIl) {
        final TileEntity llllllllllllllIllIIllIIIllIlllII = llllllllllllllIllIIllIIIllIlIIlI.getTileEntity(llllllllllllllIllIIllIIIllIllllI);
        if (llllllllllllllIllIIllIIIllIlllII instanceof TileEntityEndGateway) {
            for (int llllllllllllllIllIIllIIIllIllIll = ((TileEntityEndGateway)llllllllllllllIllIIllIIIllIlllII).getParticleAmount(), llllllllllllllIllIIllIIIllIllIlI = 0; llllllllllllllIllIIllIIIllIllIlI < llllllllllllllIllIIllIIIllIllIll; ++llllllllllllllIllIIllIIIllIllIlI) {
                double llllllllllllllIllIIllIIIllIllIIl = llllllllllllllIllIIllIIIllIllllI.getX() + llllllllllllllIllIIllIIIllIlllIl.nextFloat();
                final double llllllllllllllIllIIllIIIllIllIII = llllllllllllllIllIIllIIIllIllllI.getY() + llllllllllllllIllIIllIIIllIlllIl.nextFloat();
                double llllllllllllllIllIIllIIIllIlIlll = llllllllllllllIllIIllIIIllIllllI.getZ() + llllllllllllllIllIIllIIIllIlllIl.nextFloat();
                double llllllllllllllIllIIllIIIllIlIllI = (llllllllllllllIllIIllIIIllIlllIl.nextFloat() - 0.5) * 0.5;
                final double llllllllllllllIllIIllIIIllIlIlIl = (llllllllllllllIllIIllIIIllIlllIl.nextFloat() - 0.5) * 0.5;
                double llllllllllllllIllIIllIIIllIlIlII = (llllllllllllllIllIIllIIIllIlllIl.nextFloat() - 0.5) * 0.5;
                final int llllllllllllllIllIIllIIIllIlIIll = llllllllllllllIllIIllIIIllIlllIl.nextInt(2) * 2 - 1;
                if (llllllllllllllIllIIllIIIllIlllIl.nextBoolean()) {
                    llllllllllllllIllIIllIIIllIlIlll = llllllllllllllIllIIllIIIllIllllI.getZ() + 0.5 + 0.25 * llllllllllllllIllIIllIIIllIlIIll;
                    llllllllllllllIllIIllIIIllIlIlII = llllllllllllllIllIIllIIIllIlllIl.nextFloat() * 2.0f * llllllllllllllIllIIllIIIllIlIIll;
                }
                else {
                    llllllllllllllIllIIllIIIllIllIIl = llllllllllllllIllIIllIIIllIllllI.getX() + 0.5 + 0.25 * llllllllllllllIllIIllIIIllIlIIll;
                    llllllllllllllIllIIllIIIllIlIllI = llllllllllllllIllIIllIIIllIlllIl.nextFloat() * 2.0f * llllllllllllllIllIIllIIIllIlIIll;
                }
                llllllllllllllIllIIllIIIllIlIIlI.spawnParticle(EnumParticleTypes.PORTAL, llllllllllllllIllIIllIIIllIllIIl, llllllllllllllIllIIllIIIllIllIII, llllllllllllllIllIIllIIIllIlIlll, llllllllllllllIllIIllIIIllIlIllI, llllllllllllllIllIIllIIIllIlIlIl, llllllllllllllIllIIllIIIllIlIlII, new int[0]);
            }
        }
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIllIIllIIIllIIIIII, final IBlockAccess llllllllllllllIllIIllIIIlIllllll, final BlockPos llllllllllllllIllIIllIIIlIlllllI) {
        return MapColor.BLACK;
    }
}
