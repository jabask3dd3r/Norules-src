package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;

public class BlockEndPortal extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB END_PORTAL_AABB;
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIllIIllIIlIlIIIllll, final IBlockAccess lllllllllllllIllIIllIIlIlIIIlllI, final BlockPos lllllllllllllIllIIllIIlIlIIIllIl) {
        return MapColor.BLACK;
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllllIllIIllIIlIllIllIlI, final World lllllllllllllIllIIllIIlIllIllIIl, final BlockPos lllllllllllllIllIIllIIlIllIllIII, final AxisAlignedBB lllllllllllllIllIIllIIlIllIlIlll, final List<AxisAlignedBB> lllllllllllllIllIIllIIlIllIlIllI, @Nullable final Entity lllllllllllllIllIIllIIlIllIlIlIl, final boolean lllllllllllllIllIIllIIlIllIlIlII) {
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllIllIIllIIlIlllIIlII, final IBlockAccess lllllllllllllIllIIllIIlIlllIIIll, final BlockPos lllllllllllllIllIIllIIlIlllIIIlI, final EnumFacing lllllllllllllIllIIllIIlIlllIIIIl) {
        return lllllllllllllIllIIllIIlIlllIIIIl == EnumFacing.DOWN && super.shouldSideBeRendered(lllllllllllllIllIIllIIlIlllIIlII, lllllllllllllIllIIllIIlIlllIIIll, lllllllllllllIllIIllIIlIlllIIIlI, lllllllllllllIllIIllIIlIlllIIIIl);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIllIIllIIlIllIlIIlI) {
        return false;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllIllIIllIIlIlIllIIlI, final World lllllllllllllIllIIllIIlIlIlIIIll, final BlockPos lllllllllllllIllIIllIIlIlIlIlllI, final Random lllllllllllllIllIIllIIlIlIlIIIII) {
        final double lllllllllllllIllIIllIIlIlIlIlIlI = lllllllllllllIllIIllIIlIlIlIlllI.getX() + lllllllllllllIllIIllIIlIlIlIIIII.nextFloat();
        final double lllllllllllllIllIIllIIlIlIlIlIII = lllllllllllllIllIIllIIlIlIlIlllI.getY() + 0.8f;
        final double lllllllllllllIllIIllIIlIlIlIIlll = lllllllllllllIllIIllIIlIlIlIlllI.getZ() + lllllllllllllIllIIllIIlIlIlIIIII.nextFloat();
        final double lllllllllllllIllIIllIIlIlIlIIllI = 0.0;
        final double lllllllllllllIllIIllIIlIlIlIIlIl = 0.0;
        final double lllllllllllllIllIIllIIlIlIlIIlII = 0.0;
        lllllllllllllIllIIllIIlIlIlIIIll.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllIllIIllIIlIlIlIlIlI, lllllllllllllIllIIllIIlIlIlIlIII, lllllllllllllIllIIllIIlIlIlIIlll, 0.0, 0.0, 0.0, new int[0]);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIllIIllIIlIlIIlIIll, final BlockPos lllllllllllllIllIIllIIlIlIIlIIlI, final IBlockState lllllllllllllIllIIllIIlIlIIlIIIl) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIllIIllIIlIlllIllIl, final IBlockAccess lllllllllllllIllIIllIIlIlllIllII, final BlockPos lllllllllllllIllIIllIIlIlllIlIll) {
        return BlockEndPortal.END_PORTAL_AABB;
    }
    
    protected BlockEndPortal(final Material lllllllllllllIllIIllIIlIllllIlII) {
        super(lllllllllllllIllIIllIIlIllllIlII);
        this.setLightLevel(1.0f);
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIllIIllIIlIllIIlllI) {
        return 0;
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIllIIllIIlIllIlIIII) {
        return false;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIllIIllIIlIllllIIII, final int lllllllllllllIllIIllIIlIlllIllll) {
        return new TileEntityEndPortal();
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllIllIIllIIlIllIIIlII, final BlockPos lllllllllllllIllIIllIIlIllIIIlll, final IBlockState lllllllllllllIllIIllIIlIllIIIllI, final Entity lllllllllllllIllIIllIIlIllIIIlIl) {
        if (!lllllllllllllIllIIllIIlIllIIIlII.isRemote && !lllllllllllllIllIIllIIlIllIIIlIl.isRiding() && !lllllllllllllIllIIllIIlIllIIIlIl.isBeingRidden() && lllllllllllllIllIIllIIlIllIIIlIl.isNonBoss() && lllllllllllllIllIIllIIlIllIIIlIl.getEntityBoundingBox().intersectsWith(lllllllllllllIllIIllIIlIllIIIllI.getBoundingBox(lllllllllllllIllIIllIIlIllIIIlII, lllllllllllllIllIIllIIlIllIIIlll).offset(lllllllllllllIllIIllIIlIllIIIlll))) {
            lllllllllllllIllIIllIIlIllIIIlIl.changeDimension(1);
        }
    }
    
    static {
        END_PORTAL_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.75, 1.0);
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIllIIllIIlIlIIIlIIl, final IBlockState lllllllllllllIllIIllIIlIlIIIIlll, final BlockPos lllllllllllllIllIIllIIlIlIIIIlIl, final EnumFacing lllllllllllllIllIIllIIlIlIIIIIll) {
        return BlockFaceShape.UNDEFINED;
    }
}
