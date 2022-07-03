package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public class BlockDragonEgg extends Block
{
    protected static final /* synthetic */ AxisAlignedBB DRAGON_EGG_AABB;
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllllIIIlIlllIIIIllIl, final World llllllllllllllllIIIlIlllIIIIllII, final BlockPos llllllllllllllllIIIlIlllIIIIIllI, final Block llllllllllllllllIIIlIlllIIIIlIlI, final BlockPos llllllllllllllllIIIlIlllIIIIlIIl) {
        llllllllllllllllIIIlIlllIIIIllII.scheduleUpdate(llllllllllllllllIIIlIlllIIIIIllI, this, this.tickRate(llllllllllllllllIIIlIlllIIIIllII));
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllllIIIlIllIlIlIIlII) {
        return false;
    }
    
    static {
        DRAGON_EGG_AABB = new AxisAlignedBB(0.0625, 0.0, 0.0625, 0.9375, 1.0, 0.9375);
    }
    
    private void teleport(final World llllllllllllllllIIIlIllIlIllIlII, final BlockPos llllllllllllllllIIIlIllIllIIIIIl) {
        final IBlockState llllllllllllllllIIIlIllIllIIIIII = llllllllllllllllIIIlIllIlIllIlII.getBlockState(llllllllllllllllIIIlIllIllIIIIIl);
        if (llllllllllllllllIIIlIllIllIIIIII.getBlock() == this) {
            for (int llllllllllllllllIIIlIllIlIllllll = 0; llllllllllllllllIIIlIllIlIllllll < 1000; ++llllllllllllllllIIIlIllIlIllllll) {
                final BlockPos llllllllllllllllIIIlIllIlIlllllI = llllllllllllllllIIIlIllIllIIIIIl.add(llllllllllllllllIIIlIllIlIllIlII.rand.nextInt(16) - llllllllllllllllIIIlIllIlIllIlII.rand.nextInt(16), llllllllllllllllIIIlIllIlIllIlII.rand.nextInt(8) - llllllllllllllllIIIlIllIlIllIlII.rand.nextInt(8), llllllllllllllllIIIlIllIlIllIlII.rand.nextInt(16) - llllllllllllllllIIIlIllIlIllIlII.rand.nextInt(16));
                if (llllllllllllllllIIIlIllIlIllIlII.getBlockState(llllllllllllllllIIIlIllIlIlllllI).getBlock().blockMaterial == Material.AIR) {
                    if (llllllllllllllllIIIlIllIlIllIlII.isRemote) {
                        for (int llllllllllllllllIIIlIllIlIllllIl = 0; llllllllllllllllIIIlIllIlIllllIl < 128; ++llllllllllllllllIIIlIllIlIllllIl) {
                            final double llllllllllllllllIIIlIllIlIllllII = llllllllllllllllIIIlIllIlIllIlII.rand.nextDouble();
                            final float llllllllllllllllIIIlIllIlIlllIll = (llllllllllllllllIIIlIllIlIllIlII.rand.nextFloat() - 0.5f) * 0.2f;
                            final float llllllllllllllllIIIlIllIlIlllIlI = (llllllllllllllllIIIlIllIlIllIlII.rand.nextFloat() - 0.5f) * 0.2f;
                            final float llllllllllllllllIIIlIllIlIlllIIl = (llllllllllllllllIIIlIllIlIllIlII.rand.nextFloat() - 0.5f) * 0.2f;
                            final double llllllllllllllllIIIlIllIlIlllIII = llllllllllllllllIIIlIllIlIlllllI.getX() + (llllllllllllllllIIIlIllIllIIIIIl.getX() - llllllllllllllllIIIlIllIlIlllllI.getX()) * llllllllllllllllIIIlIllIlIllllII + (llllllllllllllllIIIlIllIlIllIlII.rand.nextDouble() - 0.5) + 0.5;
                            final double llllllllllllllllIIIlIllIlIllIlll = llllllllllllllllIIIlIllIlIlllllI.getY() + (llllllllllllllllIIIlIllIllIIIIIl.getY() - llllllllllllllllIIIlIllIlIlllllI.getY()) * llllllllllllllllIIIlIllIlIllllII + llllllllllllllllIIIlIllIlIllIlII.rand.nextDouble() - 0.5;
                            final double llllllllllllllllIIIlIllIlIllIllI = llllllllllllllllIIIlIllIlIlllllI.getZ() + (llllllllllllllllIIIlIllIllIIIIIl.getZ() - llllllllllllllllIIIlIllIlIlllllI.getZ()) * llllllllllllllllIIIlIllIlIllllII + (llllllllllllllllIIIlIllIlIllIlII.rand.nextDouble() - 0.5) + 0.5;
                            llllllllllllllllIIIlIllIlIllIlII.spawnParticle(EnumParticleTypes.PORTAL, llllllllllllllllIIIlIllIlIlllIII, llllllllllllllllIIIlIllIlIllIlll, llllllllllllllllIIIlIllIlIllIllI, llllllllllllllllIIIlIllIlIlllIll, llllllllllllllllIIIlIllIlIlllIlI, llllllllllllllllIIIlIllIlIlllIIl, new int[0]);
                        }
                    }
                    else {
                        llllllllllllllllIIIlIllIlIllIlII.setBlockState(llllllllllllllllIIIlIllIlIlllllI, llllllllllllllllIIIlIllIllIIIIII, 2);
                        llllllllllllllllIIIlIllIlIllIlII.setBlockToAir(llllllllllllllllIIIlIllIllIIIIIl);
                    }
                    return;
                }
            }
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllllIIIlIllIlIlIIIlI) {
        return false;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllllIIIlIlllIIIlIIll, final BlockPos llllllllllllllllIIIlIlllIIIlIllI, final IBlockState llllllllllllllllIIIlIlllIIIlIlIl) {
        llllllllllllllllIIIlIlllIIIlIIll.scheduleUpdate(llllllllllllllllIIIlIlllIIIlIllI, this, this.tickRate(llllllllllllllllIIIlIlllIIIlIIll));
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllllIIIlIllIlIlIIIII, final IBlockAccess llllllllllllllllIIIlIllIlIIlllll, final BlockPos llllllllllllllllIIIlIllIlIIllllI, final EnumFacing llllllllllllllllIIIlIllIlIIlllIl) {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllllIIIlIllIllIlllIl, final BlockPos llllllllllllllllIIIlIllIlllIIllI, final IBlockState llllllllllllllllIIIlIllIlllIIlIl, final EntityPlayer llllllllllllllllIIIlIllIlllIIlII, final EnumHand llllllllllllllllIIIlIllIlllIIIll, final EnumFacing llllllllllllllllIIIlIllIlllIIIlI, final float llllllllllllllllIIIlIllIlllIIIIl, final float llllllllllllllllIIIlIllIlllIIIII, final float llllllllllllllllIIIlIllIllIlllll) {
        this.teleport(llllllllllllllllIIIlIllIllIlllIl, llllllllllllllllIIIlIllIlllIIllI);
        return true;
    }
    
    private void checkFall(final World llllllllllllllllIIIlIllIlllIllll, final BlockPos llllllllllllllllIIIlIllIllllIIll) {
        if (BlockFalling.canFallThrough(llllllllllllllllIIIlIllIlllIllll.getBlockState(llllllllllllllllIIIlIllIllllIIll.down())) && llllllllllllllllIIIlIllIllllIIll.getY() >= 0) {
            final int llllllllllllllllIIIlIllIllllIIlI = 32;
            if (!BlockFalling.fallInstantly && llllllllllllllllIIIlIllIlllIllll.isAreaLoaded(llllllllllllllllIIIlIllIllllIIll.add(-32, -32, -32), llllllllllllllllIIIlIllIllllIIll.add(32, 32, 32))) {
                llllllllllllllllIIIlIllIlllIllll.spawnEntityInWorld(new EntityFallingBlock(llllllllllllllllIIIlIllIlllIllll, llllllllllllllllIIIlIllIllllIIll.getX() + 0.5f, llllllllllllllllIIIlIllIllllIIll.getY(), llllllllllllllllIIIlIllIllllIIll.getZ() + 0.5f, this.getDefaultState()));
            }
            else {
                llllllllllllllllIIIlIllIlllIllll.setBlockToAir(llllllllllllllllIIIlIllIllllIIll);
                BlockPos llllllllllllllllIIIlIllIllllIIIl;
                for (llllllllllllllllIIIlIllIllllIIIl = llllllllllllllllIIIlIllIllllIIll; BlockFalling.canFallThrough(llllllllllllllllIIIlIllIlllIllll.getBlockState(llllllllllllllllIIIlIllIllllIIIl)) && llllllllllllllllIIIlIllIllllIIIl.getY() > 0; llllllllllllllllIIIlIllIllllIIIl = llllllllllllllllIIIlIllIllllIIIl.down()) {}
                if (llllllllllllllllIIIlIllIllllIIIl.getY() > 0) {
                    llllllllllllllllIIIlIllIlllIllll.setBlockState(llllllllllllllllIIIlIllIllllIIIl, this.getDefaultState(), 2);
                }
            }
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllllllIIIlIlllIIIIIIIl, final BlockPos llllllllllllllllIIIlIllIlllllIll, final IBlockState llllllllllllllllIIIlIllIllllllll, final Random llllllllllllllllIIIlIllIlllllllI) {
        this.checkFall(llllllllllllllllIIIlIlllIIIIIIIl, llllllllllllllllIIIlIllIlllllIll);
    }
    
    @Override
    public void onBlockClicked(final World llllllllllllllllIIIlIllIllIlIIll, final BlockPos llllllllllllllllIIIlIllIllIlIllI, final EntityPlayer llllllllllllllllIIIlIllIllIlIlIl) {
        this.teleport(llllllllllllllllIIIlIllIllIlIIll, llllllllllllllllIIIlIllIllIlIllI);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllllIIIlIlllIIIllllI, final IBlockAccess llllllllllllllllIIIlIlllIIIlllIl, final BlockPos llllllllllllllllIIIlIlllIIIlllII) {
        return BlockDragonEgg.DRAGON_EGG_AABB;
    }
    
    public BlockDragonEgg() {
        super(Material.DRAGON_EGG, MapColor.BLACK);
    }
    
    @Override
    public int tickRate(final World llllllllllllllllIIIlIllIlIlIIllI) {
        return 5;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllllIIIlIllIlIIllIll, final IBlockState llllllllllllllllIIIlIllIlIIllIlI, final BlockPos llllllllllllllllIIIlIllIlIIllIIl, final EnumFacing llllllllllllllllIIIlIllIlIIllIII) {
        return BlockFaceShape.UNDEFINED;
    }
}
