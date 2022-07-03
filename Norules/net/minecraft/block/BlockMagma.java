package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import java.util.*;
import net.minecraft.init.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;

public class BlockMagma extends Block
{
    @Override
    public int getPackedLightmapCoords(final IBlockState lllllllllllllIIIIllIIllllIIIllIl, final IBlockAccess lllllllllllllIIIIllIIllllIIIllII, final BlockPos lllllllllllllIIIIllIIllllIIIlIll) {
        return 15728880;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIIIIllIIllllIIlllIl, final IBlockAccess lllllllllllllIIIIllIIllllIIlllII, final BlockPos lllllllllllllIIIIllIIllllIIllIll) {
        return MapColor.NETHERRACK;
    }
    
    @Override
    public boolean canEntitySpawn(final IBlockState lllllllllllllIIIIllIIlllIllllIIl, final Entity lllllllllllllIIIIllIIlllIlllIlll) {
        return lllllllllllllIIIIllIIlllIlllIlll.isImmuneToFire();
    }
    
    @Override
    public void onEntityWalk(final World lllllllllllllIIIIllIIllllIIlIIIl, final BlockPos lllllllllllllIIIIllIIllllIIlIlII, final Entity lllllllllllllIIIIllIIllllIIIllll) {
        if (!lllllllllllllIIIIllIIllllIIIllll.isImmuneToFire() && lllllllllllllIIIIllIIllllIIIllll instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)lllllllllllllIIIIllIIllllIIIllll)) {
            lllllllllllllIIIIllIIllllIIIllll.attackEntityFrom(DamageSource.hotFloor, 1.0f);
        }
        super.onEntityWalk(lllllllllllllIIIIllIIllllIIlIIIl, lllllllllllllIIIIllIIllllIIlIlII, lllllllllllllIIIIllIIllllIIIllll);
    }
    
    @Override
    public void updateTick(final World lllllllllllllIIIIllIIllllIIIIlIl, final BlockPos lllllllllllllIIIIllIIlllIllllllI, final IBlockState lllllllllllllIIIIllIIllllIIIIIll, final Random lllllllllllllIIIIllIIllllIIIIIlI) {
        final BlockPos lllllllllllllIIIIllIIllllIIIIIIl = lllllllllllllIIIIllIIlllIllllllI.up();
        final IBlockState lllllllllllllIIIIllIIllllIIIIIII = lllllllllllllIIIIllIIllllIIIIlIl.getBlockState(lllllllllllllIIIIllIIllllIIIIIIl);
        if (lllllllllllllIIIIllIIllllIIIIIII.getBlock() == Blocks.WATER || lllllllllllllIIIIllIIllllIIIIIII.getBlock() == Blocks.FLOWING_WATER) {
            lllllllllllllIIIIllIIllllIIIIlIl.setBlockToAir(lllllllllllllIIIIllIIllllIIIIIIl);
            lllllllllllllIIIIllIIllllIIIIlIl.playSound(null, lllllllllllllIIIIllIIlllIllllllI, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 2.6f + (lllllllllllllIIIIllIIllllIIIIlIl.rand.nextFloat() - lllllllllllllIIIIllIIllllIIIIlIl.rand.nextFloat()) * 0.8f);
            if (lllllllllllllIIIIllIIllllIIIIlIl instanceof WorldServer) {
                ((WorldServer)lllllllllllllIIIIllIIllllIIIIlIl).spawnParticle(EnumParticleTypes.SMOKE_LARGE, lllllllllllllIIIIllIIllllIIIIIIl.getX() + 0.5, lllllllllllllIIIIllIIllllIIIIIIl.getY() + 0.25, lllllllllllllIIIIllIIllllIIIIIIl.getZ() + 0.5, 8, 0.5, 0.25, 0.5, 0.0, new int[0]);
            }
        }
    }
    
    public BlockMagma() {
        super(Material.ROCK);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setLightLevel(0.2f);
        this.setTickRandomly(true);
    }
}
