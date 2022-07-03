package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.entity.*;
import javax.annotation.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.properties.*;

public class BlockLilyPad extends BlockBush
{
    protected static final /* synthetic */ AxisAlignedBB LILY_PAD_AABB;
    
    static {
        LILY_PAD_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 0.09375, 0.9375);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIIIlllIIIllIllllI) {
        return 0;
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState lllllllllllllllIIIlllIIIlllIllll) {
        return lllllllllllllllIIIlllIIIlllIllll.getBlock() == Blocks.WATER || lllllllllllllllIIIlllIIIlllIllll.getMaterial() == Material.ICE;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllllIIIlllIIIllllIlII, final IBlockAccess lllllllllllllllIIIlllIIIllllIIll, final BlockPos lllllllllllllllIIIlllIIIllllIIlI) {
        return BlockLilyPad.LILY_PAD_AABB;
    }
    
    @Override
    public void addCollisionBoxToList(final IBlockState lllllllllllllllIIIlllIIlIIIIllll, final World lllllllllllllllIIIlllIIlIIIIlllI, final BlockPos lllllllllllllllIIIlllIIlIIIIllIl, final AxisAlignedBB lllllllllllllllIIIlllIIlIIIIllII, final List<AxisAlignedBB> lllllllllllllllIIIlllIIlIIIIlIll, @Nullable final Entity lllllllllllllllIIIlllIIlIIIIlIlI, final boolean lllllllllllllllIIIlllIIlIIIIlIIl) {
        if (!(lllllllllllllllIIIlllIIlIIIIlIlI instanceof EntityBoat)) {
            Block.addCollisionBoxToList(lllllllllllllllIIIlllIIlIIIIllIl, lllllllllllllllIIIlllIIlIIIIllII, lllllllllllllllIIIlllIIlIIIIlIll, BlockLilyPad.LILY_PAD_AABB);
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllllIIIlllIIIlllllIIl, final BlockPos lllllllllllllllIIIlllIIIllllllIl, final IBlockState lllllllllllllllIIIlllIIIllllllII, final Entity lllllllllllllllIIIlllIIIlllllIll) {
        super.onEntityCollidedWithBlock(lllllllllllllllIIIlllIIIlllllIIl, lllllllllllllllIIIlllIIIllllllIl, lllllllllllllllIIIlllIIIllllllII, lllllllllllllllIIIlllIIIlllllIll);
        if (lllllllllllllllIIIlllIIIlllllIll instanceof EntityBoat) {
            lllllllllllllllIIIlllIIIlllllIIl.destroyBlock(new BlockPos(lllllllllllllllIIIlllIIIllllllIl), true);
        }
    }
    
    protected BlockLilyPad() {
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public boolean canBlockStay(final World lllllllllllllllIIIlllIIIlllIIIll, final BlockPos lllllllllllllllIIIlllIIIlllIIlll, final IBlockState lllllllllllllllIIIlllIIIlllIIllI) {
        if (lllllllllllllllIIIlllIIIlllIIlll.getY() >= 0 && lllllllllllllllIIIlllIIIlllIIlll.getY() < 256) {
            final IBlockState lllllllllllllllIIIlllIIIlllIIlIl = lllllllllllllllIIIlllIIIlllIIIll.getBlockState(lllllllllllllllIIIlllIIIlllIIlll.down());
            final Material lllllllllllllllIIIlllIIIlllIIlII = lllllllllllllllIIIlllIIIlllIIlIl.getMaterial();
            return (lllllllllllllllIIIlllIIIlllIIlII == Material.WATER && lllllllllllllllIIIlllIIIlllIIlIl.getValue((IProperty<Integer>)BlockLiquid.LEVEL) == 0) || lllllllllllllllIIIlllIIIlllIIlII == Material.ICE;
        }
        return false;
    }
}
