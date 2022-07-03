package net.minecraft.block;

import net.minecraft.tileentity.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;

public class BlockSign extends BlockContainer
{
    protected static final /* synthetic */ AxisAlignedBB SIGN_AABB;
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIllIllIIIlllllllllI, final int lllllllllllllIllIllIIIllllllllIl) {
        return new TileEntitySign();
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIllIllIIIlllllllIll, final Random lllllllllllllIllIllIIIlllllllIlI, final int lllllllllllllIllIllIIIlllllllIIl) {
        return Items.SIGN;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIllIllIIIllllllIlll, final BlockPos lllllllllllllIllIllIIIllllllIllI, final IBlockState lllllllllllllIllIllIIIllllllIlIl) {
        return new ItemStack(Items.SIGN);
    }
    
    @Override
    public boolean canSpawnInBlock() {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIllIllIIIllllIlIlll, final IBlockState lllllllllllllIllIllIIIllllIlIllI, final BlockPos lllllllllllllIllIllIIIllllIlIlIl, final EnumFacing lllllllllllllIllIllIIIllllIlIlII) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public boolean isPassable(final IBlockAccess lllllllllllllIllIllIIlIIIIIIIlII, final BlockPos lllllllllllllIllIllIIlIIIIIIIIll) {
        return true;
    }
    
    @Override
    public boolean canPlaceBlockAt(final World lllllllllllllIllIllIIIllllIllIlI, final BlockPos lllllllllllllIllIllIIIllllIllIIl) {
        return !this.hasInvalidNeighbor(lllllllllllllIllIllIIIllllIllIlI, lllllllllllllIllIllIIIllllIllIIl) && super.canPlaceBlockAt(lllllllllllllIllIllIIIllllIllIlI, lllllllllllllIllIllIIIllllIllIIl);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIllIllIIlIIIIIlIIII, final IBlockAccess lllllllllllllIllIllIIlIIIIIIllll, final BlockPos lllllllllllllIllIllIIlIIIIIIlllI) {
        return BlockSign.SIGN_AABB;
    }
    
    static {
        SIGN_AABB = new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 0.75);
    }
    
    @Override
    public boolean func_190946_v(final IBlockState lllllllllllllIllIllIIlIIIIIIIllI) {
        return true;
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllIllIllIIlIIIIIIllII, final IBlockAccess lllllllllllllIllIllIIlIIIIIIlIll, final BlockPos lllllllllllllIllIllIIlIIIIIIlIlI) {
        return BlockSign.NULL_AABB;
    }
    
    protected BlockSign() {
        super(Material.WOOD);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIllIllIIIlllllIllll, final BlockPos lllllllllllllIllIllIIIlllllIlllI, final IBlockState lllllllllllllIllIllIIIlllllIllIl, final EntityPlayer lllllllllllllIllIllIIIlllllIIIll, final EnumHand lllllllllllllIllIllIIIlllllIlIll, final EnumFacing lllllllllllllIllIllIIIlllllIlIlI, final float lllllllllllllIllIllIIIlllllIlIIl, final float lllllllllllllIllIllIIIlllllIlIII, final float lllllllllllllIllIllIIIlllllIIlll) {
        if (lllllllllllllIllIllIIIlllllIllll.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllIllIllIIIlllllIIllI = lllllllllllllIllIllIIIlllllIllll.getTileEntity(lllllllllllllIllIllIIIlllllIlllI);
        return lllllllllllllIllIllIIIlllllIIllI instanceof TileEntitySign && ((TileEntitySign)lllllllllllllIllIllIIIlllllIIllI).executeCommand(lllllllllllllIllIllIIIlllllIIIll);
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIllIllIIlIIIIIIlIII) {
        return false;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIllIllIIlIIIIIIIIIl) {
        return false;
    }
}
