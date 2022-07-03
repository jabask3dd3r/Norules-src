package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.world.*;

public class BlockTNT extends Block
{
    public static final /* synthetic */ PropertyBool EXPLODE;
    
    public void explode(final World lllllllllllllllIllIlIIlllllllIIl, final BlockPos lllllllllllllllIllIlIIllllllllIl, final IBlockState lllllllllllllllIllIlIIllllllIlll, final EntityLivingBase lllllllllllllllIllIlIIlllllllIll) {
        if (!lllllllllllllllIllIlIIlllllllIIl.isRemote && lllllllllllllllIllIlIIllllllIlll.getValue((IProperty<Boolean>)BlockTNT.EXPLODE)) {
            final EntityTNTPrimed lllllllllllllllIllIlIIlllllllIlI = new EntityTNTPrimed(lllllllllllllllIllIlIIlllllllIIl, lllllllllllllllIllIlIIllllllllIl.getX() + 0.5f, lllllllllllllllIllIlIIllllllllIl.getY(), lllllllllllllllIllIlIIllllllllIl.getZ() + 0.5f, lllllllllllllllIllIlIIlllllllIll);
            lllllllllllllllIllIlIIlllllllIIl.spawnEntityInWorld(lllllllllllllllIllIlIIlllllllIlI);
            lllllllllllllllIllIlIIlllllllIIl.playSound(null, lllllllllllllllIllIlIIlllllllIlI.posX, lllllllllllllllIllIlIIlllllllIlI.posY, lllllllllllllllIllIlIIlllllllIlI.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }
    
    @Override
    public void onEntityCollidedWithBlock(final World lllllllllllllllIllIlIIllllIIIlll, final BlockPos lllllllllllllllIllIlIIllllIIllII, final IBlockState lllllllllllllllIllIlIIllllIIlIll, final Entity lllllllllllllllIllIlIIllllIIlIlI) {
        if (!lllllllllllllllIllIlIIllllIIIlll.isRemote && lllllllllllllllIllIlIIllllIIlIlI instanceof EntityArrow) {
            final EntityArrow lllllllllllllllIllIlIIllllIIlIIl = (EntityArrow)lllllllllllllllIllIlIIllllIIlIlI;
            if (lllllllllllllllIllIlIIllllIIlIIl.isBurning()) {
                this.explode(lllllllllllllllIllIlIIllllIIIlll, lllllllllllllllIllIlIIllllIIllII, lllllllllllllllIllIlIIllllIIIlll.getBlockState(lllllllllllllllIllIlIIllllIIllII).withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true), (lllllllllllllllIllIlIIllllIIlIIl.shootingEntity instanceof EntityLivingBase) ? ((EntityLivingBase)lllllllllllllllIllIlIIllllIIlIIl.shootingEntity) : null);
                lllllllllllllllIllIlIIllllIIIlll.setBlockToAir(lllllllllllllllIllIlIIllllIIllII);
            }
        }
    }
    
    static {
        EXPLODE = PropertyBool.create("explode");
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllllIllIlIIllllIlllIl, final BlockPos lllllllllllllllIllIlIIllllIlllII, final IBlockState lllllllllllllllIllIlIIllllIllIll, final EntityPlayer lllllllllllllllIllIlIIllllIllIlI, final EnumHand lllllllllllllllIllIlIIlllllIIlII, final EnumFacing lllllllllllllllIllIlIIllllIllIII, final float lllllllllllllllIllIlIIlllllIIIlI, final float lllllllllllllllIllIlIIllllIlIllI, final float lllllllllllllllIllIlIIlllllIIIII) {
        final ItemStack lllllllllllllllIllIlIIllllIlllll = lllllllllllllllIllIlIIllllIllIlI.getHeldItem(lllllllllllllllIllIlIIlllllIIlII);
        if (!lllllllllllllllIllIlIIllllIlllll.func_190926_b() && (lllllllllllllllIllIlIIllllIlllll.getItem() == Items.FLINT_AND_STEEL || lllllllllllllllIllIlIIllllIlllll.getItem() == Items.FIRE_CHARGE)) {
            this.explode(lllllllllllllllIllIlIIllllIlllIl, lllllllllllllllIllIlIIllllIlllII, lllllllllllllllIllIlIIllllIllIll.withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true), lllllllllllllllIllIlIIllllIllIlI);
            lllllllllllllllIllIlIIllllIlllIl.setBlockState(lllllllllllllllIllIlIIllllIlllII, Blocks.AIR.getDefaultState(), 11);
            if (lllllllllllllllIllIlIIllllIlllll.getItem() == Items.FLINT_AND_STEEL) {
                lllllllllllllllIllIlIIllllIlllll.damageItem(1, lllllllllllllllIllIlIIllllIllIlI);
            }
            else if (!lllllllllllllllIllIlIIllllIllIlI.capabilities.isCreativeMode) {
                lllllllllllllllIllIlIIllllIlllll.func_190918_g(1);
            }
            return true;
        }
        return super.onBlockActivated(lllllllllllllllIllIlIIllllIlllIl, lllllllllllllllIllIlIIllllIlllII, lllllllllllllllIllIlIIllllIllIll, lllllllllllllllIllIlIIllllIllIlI, lllllllllllllllIllIlIIlllllIIlII, lllllllllllllllIllIlIIllllIllIII, lllllllllllllllIllIlIIlllllIIIlI, lllllllllllllllIllIlIIllllIlIllI, lllllllllllllllIllIlIIlllllIIIII);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTNT.EXPLODE });
    }
    
    @Override
    public void onBlockDestroyedByPlayer(final World lllllllllllllllIllIlIlIIIIIIIlll, final BlockPos lllllllllllllllIllIlIlIIIIIIIllI, final IBlockState lllllllllllllllIllIlIlIIIIIIIlIl) {
        this.explode(lllllllllllllllIllIlIlIIIIIIIlll, lllllllllllllllIllIlIlIIIIIIIllI, lllllllllllllllIllIlIlIIIIIIIlIl, null);
    }
    
    public BlockTNT() {
        super(Material.TNT);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllIllIlIIlllIlllIII) {
        return ((boolean)lllllllllllllllIllIlIIlllIlllIII.getValue((IProperty<Boolean>)BlockTNT.EXPLODE)) ? 1 : 0;
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllllIllIlIlIIIIlIIllI, final World lllllllllllllllIllIlIlIIIIIlllll, final BlockPos lllllllllllllllIllIlIlIIIIlIIlII, final Block lllllllllllllllIllIlIlIIIIlIIIll, final BlockPos lllllllllllllllIllIlIlIIIIlIIIlI) {
        if (lllllllllllllllIllIlIlIIIIIlllll.isBlockPowered(lllllllllllllllIllIlIlIIIIlIIlII)) {
            this.onBlockDestroyedByPlayer(lllllllllllllllIllIlIlIIIIIlllll, lllllllllllllllIllIlIlIIIIlIIlII, lllllllllllllllIllIlIlIIIIlIIllI.withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true));
            lllllllllllllllIllIlIlIIIIIlllll.setBlockToAir(lllllllllllllllIllIlIlIIIIlIIlII);
        }
    }
    
    @Override
    public void onBlockDestroyedByExplosion(final World lllllllllllllllIllIlIlIIIIIllIII, final BlockPos lllllllllllllllIllIlIlIIIIIlIlll, final Explosion lllllllllllllllIllIlIlIIIIIlIIlI) {
        if (!lllllllllllllllIllIlIlIIIIIllIII.isRemote) {
            final EntityTNTPrimed lllllllllllllllIllIlIlIIIIIlIlIl = new EntityTNTPrimed(lllllllllllllllIllIlIlIIIIIllIII, lllllllllllllllIllIlIlIIIIIlIlll.getX() + 0.5f, lllllllllllllllIllIlIlIIIIIlIlll.getY(), lllllllllllllllIllIlIlIIIIIlIlll.getZ() + 0.5f, lllllllllllllllIllIlIlIIIIIlIIlI.getExplosivePlacedBy());
            lllllllllllllllIllIlIlIIIIIlIlIl.setFuse((short)(lllllllllllllllIllIlIlIIIIIllIII.rand.nextInt(lllllllllllllllIllIlIlIIIIIlIlIl.getFuse() / 4) + lllllllllllllllIllIlIlIIIIIlIlIl.getFuse() / 8));
            lllllllllllllllIllIlIlIIIIIllIII.spawnEntityInWorld(lllllllllllllllIllIlIlIIIIIlIlIl);
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllIllIlIIlllIllllII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, (lllllllllllllllIllIlIIlllIllllII & 0x1) > 0);
    }
    
    @Override
    public boolean canDropFromExplosion(final Explosion lllllllllllllllIllIlIIllllIIIIlI) {
        return false;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllllIllIlIlIIIIlIlllI, final BlockPos lllllllllllllllIllIlIlIIIIlIllIl, final IBlockState lllllllllllllllIllIlIlIIIIllIIII) {
        super.onBlockAdded(lllllllllllllllIllIlIlIIIIlIlllI, lllllllllllllllIllIlIlIIIIlIllIl, lllllllllllllllIllIlIlIIIIllIIII);
        if (lllllllllllllllIllIlIlIIIIlIlllI.isBlockPowered(lllllllllllllllIllIlIlIIIIlIllIl)) {
            this.onBlockDestroyedByPlayer(lllllllllllllllIllIlIlIIIIlIlllI, lllllllllllllllIllIlIlIIIIlIllIl, lllllllllllllllIllIlIlIIIIllIIII.withProperty((IProperty<Comparable>)BlockTNT.EXPLODE, true));
            lllllllllllllllIllIlIlIIIIlIlllI.setBlockToAir(lllllllllllllllIllIlIlIIIIlIllIl);
        }
    }
}
