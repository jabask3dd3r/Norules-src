package net.minecraft.block;

import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import com.google.common.collect.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;

public class BlockRedstoneTorch extends BlockTorch
{
    private final /* synthetic */ boolean isOn;
    private static final /* synthetic */ Map<World, List<Toggle>> toggles;
    
    @Override
    public boolean isAssociatedBlock(final Block lllllllllllllIlllIIIlIIIllIlllll) {
        return lllllllllllllIlllIIIlIIIllIlllll == Blocks.UNLIT_REDSTONE_TORCH || lllllllllllllIlllIIIlIIIllIlllll == Blocks.REDSTONE_TORCH;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlllIIIlIIlIIIIlIll, final Random lllllllllllllIlllIIIlIIlIIIIlIlI, final int lllllllllllllIlllIIIlIIlIIIIlIIl) {
        return Item.getItemFromBlock(Blocks.REDSTONE_TORCH);
    }
    
    static {
        toggles = Maps.newHashMap();
    }
    
    @Override
    public int getWeakPower(final IBlockState lllllllllllllIlllIIIlIIlIlIlllII, final IBlockAccess lllllllllllllIlllIIIlIIlIllIIIII, final BlockPos lllllllllllllIlllIIIlIIlIlIlllll, final EnumFacing lllllllllllllIlllIIIlIIlIlIllllI) {
        return (this.isOn && lllllllllllllIlllIIIlIIlIlIlllII.getValue((IProperty<Comparable>)BlockRedstoneTorch.FACING) != lllllllllllllIlllIIIlIIlIlIllllI) ? 15 : 0;
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIlllIIIlIIlIllIlIll, final BlockPos lllllllllllllIlllIIIlIIlIllIllll, final IBlockState lllllllllllllIlllIIIlIIlIllIlllI) {
        if (this.isOn) {
            final Exception lllllllllllllIlllIIIlIIlIllIIllI;
            final long lllllllllllllIlllIIIlIIlIllIIlll = ((EnumFacing[])(Object)(lllllllllllllIlllIIIlIIlIllIIllI = (Exception)(Object)EnumFacing.values())).length;
            for (double lllllllllllllIlllIIIlIIlIllIlIII = 0; lllllllllllllIlllIIIlIIlIllIlIII < lllllllllllllIlllIIIlIIlIllIIlll; ++lllllllllllllIlllIIIlIIlIllIlIII) {
                final EnumFacing lllllllllllllIlllIIIlIIlIllIllIl = lllllllllllllIlllIIIlIIlIllIIllI[lllllllllllllIlllIIIlIIlIllIlIII];
                lllllllllllllIlllIIIlIIlIllIlIll.notifyNeighborsOfStateChange(lllllllllllllIlllIIIlIIlIllIllll.offset(lllllllllllllIlllIIIlIIlIllIllIl), this, false);
            }
        }
    }
    
    @Override
    public void randomDisplayTick(final IBlockState lllllllllllllIlllIIIlIIIlllIllll, final World lllllllllllllIlllIIIlIIIlllIlllI, final BlockPos lllllllllllllIlllIIIlIIIlllllIII, final Random lllllllllllllIlllIIIlIIIlllIllII) {
        if (this.isOn) {
            double lllllllllllllIlllIIIlIIIllllIllI = lllllllllllllIlllIIIlIIIlllllIII.getX() + 0.5 + (lllllllllllllIlllIIIlIIIlllIllII.nextDouble() - 0.5) * 0.2;
            double lllllllllllllIlllIIIlIIIllllIlIl = lllllllllllllIlllIIIlIIIlllllIII.getY() + 0.7 + (lllllllllllllIlllIIIlIIIlllIllII.nextDouble() - 0.5) * 0.2;
            double lllllllllllllIlllIIIlIIIllllIlII = lllllllllllllIlllIIIlIIIlllllIII.getZ() + 0.5 + (lllllllllllllIlllIIIlIIIlllIllII.nextDouble() - 0.5) * 0.2;
            final EnumFacing lllllllllllllIlllIIIlIIIllllIIll = lllllllllllllIlllIIIlIIIlllIllll.getValue((IProperty<EnumFacing>)BlockRedstoneTorch.FACING);
            if (lllllllllllllIlllIIIlIIIllllIIll.getAxis().isHorizontal()) {
                final EnumFacing lllllllllllllIlllIIIlIIIllllIIlI = lllllllllllllIlllIIIlIIIllllIIll.getOpposite();
                final double lllllllllllllIlllIIIlIIIllllIIIl = 0.27;
                lllllllllllllIlllIIIlIIIllllIllI += 0.27 * lllllllllllllIlllIIIlIIIllllIIlI.getFrontOffsetX();
                lllllllllllllIlllIIIlIIIllllIlIl += 0.22;
                lllllllllllllIlllIIIlIIIllllIlII += 0.27 * lllllllllllllIlllIIIlIIIllllIIlI.getFrontOffsetZ();
            }
            lllllllllllllIlllIIIlIIIlllIlllI.spawnParticle(EnumParticleTypes.REDSTONE, lllllllllllllIlllIIIlIIIllllIllI, lllllllllllllIlllIIIlIIIllllIlIl, lllllllllllllIlllIIIlIIIllllIlII, 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public void updateTick(final World lllllllllllllIlllIIIlIIlIIllllII, final BlockPos lllllllllllllIlllIIIlIIlIIlllIll, final IBlockState lllllllllllllIlllIIIlIIlIIlIllll, final Random lllllllllllllIlllIIIlIIlIIlllIIl) {
        final boolean lllllllllllllIlllIIIlIIlIIlllIII = this.shouldBeOff(lllllllllllllIlllIIIlIIlIIllllII, lllllllllllllIlllIIIlIIlIIlllIll, lllllllllllllIlllIIIlIIlIIlIllll);
        final List<Toggle> lllllllllllllIlllIIIlIIlIIllIlll = BlockRedstoneTorch.toggles.get(lllllllllllllIlllIIIlIIlIIllllII);
        while (lllllllllllllIlllIIIlIIlIIllIlll != null && !lllllllllllllIlllIIIlIIlIIllIlll.isEmpty() && lllllllllllllIlllIIIlIIlIIllllII.getTotalWorldTime() - lllllllllllllIlllIIIlIIlIIllIlll.get(0).time > 60L) {
            lllllllllllllIlllIIIlIIlIIllIlll.remove(0);
        }
        if (this.isOn) {
            if (lllllllllllllIlllIIIlIIlIIlllIII) {
                lllllllllllllIlllIIIlIIlIIllllII.setBlockState(lllllllllllllIlllIIIlIIlIIlllIll, Blocks.UNLIT_REDSTONE_TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneTorch.FACING, (EnumFacing)lllllllllllllIlllIIIlIIlIIlIllll.getValue((IProperty<V>)BlockRedstoneTorch.FACING)), 3);
                if (this.isBurnedOut(lllllllllllllIlllIIIlIIlIIllllII, lllllllllllllIlllIIIlIIlIIlllIll, true)) {
                    lllllllllllllIlllIIIlIIlIIllllII.playSound(null, lllllllllllllIlllIIIlIIlIIlllIll, SoundEvents.BLOCK_REDSTONE_TORCH_BURNOUT, SoundCategory.BLOCKS, 0.5f, 2.6f + (lllllllllllllIlllIIIlIIlIIllllII.rand.nextFloat() - lllllllllllllIlllIIIlIIlIIllllII.rand.nextFloat()) * 0.8f);
                    for (int lllllllllllllIlllIIIlIIlIIllIllI = 0; lllllllllllllIlllIIIlIIlIIllIllI < 5; ++lllllllllllllIlllIIIlIIlIIllIllI) {
                        final double lllllllllllllIlllIIIlIIlIIllIlIl = lllllllllllllIlllIIIlIIlIIlllIll.getX() + lllllllllllllIlllIIIlIIlIIlllIIl.nextDouble() * 0.6 + 0.2;
                        final double lllllllllllllIlllIIIlIIlIIllIlII = lllllllllllllIlllIIIlIIlIIlllIll.getY() + lllllllllllllIlllIIIlIIlIIlllIIl.nextDouble() * 0.6 + 0.2;
                        final double lllllllllllllIlllIIIlIIlIIllIIll = lllllllllllllIlllIIIlIIlIIlllIll.getZ() + lllllllllllllIlllIIIlIIlIIlllIIl.nextDouble() * 0.6 + 0.2;
                        lllllllllllllIlllIIIlIIlIIllllII.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllIlllIIIlIIlIIllIlIl, lllllllllllllIlllIIIlIIlIIllIlII, lllllllllllllIlllIIIlIIlIIllIIll, 0.0, 0.0, 0.0, new int[0]);
                    }
                    lllllllllllllIlllIIIlIIlIIllllII.scheduleUpdate(lllllllllllllIlllIIIlIIlIIlllIll, lllllllllllllIlllIIIlIIlIIllllII.getBlockState(lllllllllllllIlllIIIlIIlIIlllIll).getBlock(), 160);
                }
            }
        }
        else if (!lllllllllllllIlllIIIlIIlIIlllIII && !this.isBurnedOut(lllllllllllllIlllIIIlIIlIIllllII, lllllllllllllIlllIIIlIIlIIlllIll, false)) {
            lllllllllllllIlllIIIlIIlIIllllII.setBlockState(lllllllllllllIlllIIIlIIlIIlllIll, Blocks.REDSTONE_TORCH.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneTorch.FACING, (EnumFacing)lllllllllllllIlllIIIlIIlIIlIllll.getValue((IProperty<V>)BlockRedstoneTorch.FACING)), 3);
        }
    }
    
    @Override
    public void randomTick(final World lllllllllllllIlllIIIlIIlIlIIllII, final BlockPos lllllllllllllIlllIIIlIIlIlIIlIll, final IBlockState lllllllllllllIlllIIIlIIlIlIIlIlI, final Random lllllllllllllIlllIIIlIIlIlIIlIIl) {
    }
    
    private boolean shouldBeOff(final World lllllllllllllIlllIIIlIIlIlIlIIIl, final BlockPos lllllllllllllIlllIIIlIIlIlIlIlII, final IBlockState lllllllllllllIlllIIIlIIlIlIIllll) {
        final EnumFacing lllllllllllllIlllIIIlIIlIlIlIIlI = lllllllllllllIlllIIIlIIlIlIIllll.getValue((IProperty<EnumFacing>)BlockRedstoneTorch.FACING).getOpposite();
        return lllllllllllllIlllIIIlIIlIlIlIIIl.isSidePowered(lllllllllllllIlllIIIlIIlIlIlIlII.offset(lllllllllllllIlllIIIlIIlIlIlIIlI), lllllllllllllIlllIIIlIIlIlIlIIlI);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIlllIIIlIIlIIIlllII, final World lllllllllllllIlllIIIlIIlIIlIIIIl, final BlockPos lllllllllllllIlllIIIlIIlIIlIIIII, final Block lllllllllllllIlllIIIlIIlIIIlllll, final BlockPos lllllllllllllIlllIIIlIIlIIIllllI) {
        if (!this.onNeighborChangeInternal(lllllllllllllIlllIIIlIIlIIlIIIIl, lllllllllllllIlllIIIlIIlIIlIIIII, lllllllllllllIlllIIIlIIlIIIlllII) && this.isOn == this.shouldBeOff(lllllllllllllIlllIIIlIIlIIlIIIIl, lllllllllllllIlllIIIlIIlIIlIIIII, lllllllllllllIlllIIIlIIlIIIlllII)) {
            lllllllllllllIlllIIIlIIlIIlIIIIl.scheduleUpdate(lllllllllllllIlllIIIlIIlIIlIIIII, this, this.tickRate(lllllllllllllIlllIIIlIIlIIlIIIIl));
        }
    }
    
    private boolean isBurnedOut(final World lllllllllllllIlllIIIlIIllIIllIlI, final BlockPos lllllllllllllIlllIIIlIIllIIllIIl, final boolean lllllllllllllIlllIIIlIIllIIllIII) {
        if (!BlockRedstoneTorch.toggles.containsKey(lllllllllllllIlllIIIlIIllIIllIlI)) {
            BlockRedstoneTorch.toggles.put(lllllllllllllIlllIIIlIIllIIllIlI, Lists.newArrayList());
        }
        final List<Toggle> lllllllllllllIlllIIIlIIllIIllllI = BlockRedstoneTorch.toggles.get(lllllllllllllIlllIIIlIIllIIllIlI);
        if (lllllllllllllIlllIIIlIIllIIllIII) {
            lllllllllllllIlllIIIlIIllIIllllI.add(new Toggle(lllllllllllllIlllIIIlIIllIIllIIl, lllllllllllllIlllIIIlIIllIIllIlI.getTotalWorldTime()));
        }
        int lllllllllllllIlllIIIlIIllIIlllIl = 0;
        for (int lllllllllllllIlllIIIlIIllIIlllII = 0; lllllllllllllIlllIIIlIIllIIlllII < lllllllllllllIlllIIIlIIllIIllllI.size(); ++lllllllllllllIlllIIIlIIllIIlllII) {
            final Toggle lllllllllllllIlllIIIlIIllIIllIll = lllllllllllllIlllIIIlIIllIIllllI.get(lllllllllllllIlllIIIlIIllIIlllII);
            if (lllllllllllllIlllIIIlIIllIIllIll.pos.equals(lllllllllllllIlllIIIlIIllIIllIIl) && ++lllllllllllllIlllIIIlIIllIIlllIl >= 8) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int getStrongPower(final IBlockState lllllllllllllIlllIIIlIIlIIIlIlII, final IBlockAccess lllllllllllllIlllIIIlIIlIIIIllll, final BlockPos lllllllllllllIlllIIIlIIlIIIlIIlI, final EnumFacing lllllllllllllIlllIIIlIIlIIIIllIl) {
        return (lllllllllllllIlllIIIlIIlIIIIllIl == EnumFacing.DOWN) ? lllllllllllllIlllIIIlIIlIIIlIlII.getWeakPower(lllllllllllllIlllIIIlIIlIIIIllll, lllllllllllllIlllIIIlIIlIIIlIIlI, lllllllllllllIlllIIIlIIlIIIIllIl) : 0;
    }
    
    @Override
    public boolean canProvidePower(final IBlockState lllllllllllllIlllIIIlIIlIIIIIlll) {
        return true;
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlllIIIlIIIlllIIlII, final BlockPos lllllllllllllIlllIIIlIIIlllIIIll, final IBlockState lllllllllllllIlllIIIlIIIlllIIIlI) {
        return new ItemStack(Blocks.REDSTONE_TORCH);
    }
    
    @Override
    public int tickRate(final World lllllllllllllIlllIIIlIIllIIIllII) {
        return 2;
    }
    
    protected BlockRedstoneTorch(final boolean lllllllllllllIlllIIIlIIllIIlIIII) {
        this.isOn = lllllllllllllIlllIIIlIIllIIlIIII;
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIlllIIIlIIlIllllllI, final BlockPos lllllllllllllIlllIIIlIIlIlllllIl, final IBlockState lllllllllllllIlllIIIlIIllIIIIIIl) {
        if (this.isOn) {
            final short lllllllllllllIlllIIIlIIlIllllIIl;
            final float lllllllllllllIlllIIIlIIlIllllIlI = ((EnumFacing[])(Object)(lllllllllllllIlllIIIlIIlIllllIIl = (short)(Object)EnumFacing.values())).length;
            for (long lllllllllllllIlllIIIlIIlIllllIll = 0; lllllllllllllIlllIIIlIIlIllllIll < lllllllllllllIlllIIIlIIlIllllIlI; ++lllllllllllllIlllIIIlIIlIllllIll) {
                final EnumFacing lllllllllllllIlllIIIlIIllIIIIIII = lllllllllllllIlllIIIlIIlIllllIIl[lllllllllllllIlllIIIlIIlIllllIll];
                lllllllllllllIlllIIIlIIlIllllllI.notifyNeighborsOfStateChange(lllllllllllllIlllIIIlIIlIlllllIl.offset(lllllllllllllIlllIIIlIIllIIIIIII), this, false);
            }
        }
    }
    
    static class Toggle
    {
        /* synthetic */ BlockPos pos;
        /* synthetic */ long time;
        
        public Toggle(final BlockPos lllllllllllllllIllIIlIIlllIlllIl, final long lllllllllllllllIllIIlIIlllIlllII) {
            this.pos = lllllllllllllllIllIIlIIlllIlllIl;
            this.time = lllllllllllllllIllIIlIIlllIlllII;
        }
    }
}
