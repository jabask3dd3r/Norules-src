package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import me.nrules.*;

public class BlockSoulSand extends Block
{
    protected static final /* synthetic */ AxisAlignedBB SOUL_SAND_AABB;
    
    public BlockSoulSand() {
        super(Material.SAND, MapColor.BROWN);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(final IBlockState lllllllllllllllIlIllllIllllIlllI, final IBlockAccess lllllllllllllllIlIllllIllllIllIl, final BlockPos lllllllllllllllIlIllllIllllIllII) {
        return BlockSoulSand.SOUL_SAND_AABB;
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllllIlIllllIllllIlIIl, final BlockPos lllllllllllllllIlIllllIllllIlIII, final IBlockState lllllllllllllllIlIllllIllllIIlll, final Entity lllllllllllllllIlIllllIllllIIllI) {
        if (Main.moduleManager.getModuleByName("NoSlowDown").isToggled()) {
            lllllllllllllllIlIllllIllllIIllI.motionX *= 0.4;
            lllllllllllllllIlIllllIllllIIllI.motionZ *= 0.4;
        }
    }
    
    static {
        SOUL_SAND_AABB = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0);
    }
}
