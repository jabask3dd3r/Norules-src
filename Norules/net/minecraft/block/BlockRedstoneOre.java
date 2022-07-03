package net.minecraft.block;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;

public class BlockRedstoneOre extends Block
{
    private final /* synthetic */ boolean isOn;
    
    @Override
    public int quantityDropped(final Random llllllllllllIllllllIllIlIlIIllll) {
        return 4 + llllllllllllIllllllIllIlIlIIllll.nextInt(2);
    }
    
    @Override
    public void updateTick(final World llllllllllllIllllllIllIlIllIIllI, final BlockPos llllllllllllIllllllIllIlIllIIlIl, final IBlockState llllllllllllIllllllIllIlIllIIlII, final Random llllllllllllIllllllIllIlIllIIIll) {
        if (this == Blocks.LIT_REDSTONE_ORE) {
            llllllllllllIllllllIllIlIllIIllI.setBlockState(llllllllllllIllllllIllIlIllIIlIl, Blocks.REDSTONE_ORE.getDefaultState());
        }
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllllIllllllIllIlIIIlIlII) {
        return new ItemStack(Blocks.REDSTONE_ORE);
    }
    
    @Override
    public void onBlockClicked(final World llllllllllllIllllllIllIllIlIIlII, final BlockPos llllllllllllIllllllIllIllIlIIIll, final EntityPlayer llllllllllllIllllllIllIllIlIIIlI) {
        this.activate(llllllllllllIllllllIllIllIlIIlII, llllllllllllIllllllIllIllIlIIIll);
        super.onBlockClicked(llllllllllllIllllllIllIllIlIIlII, llllllllllllIllllllIllIllIlIIIll, llllllllllllIllllllIllIllIlIIIlI);
    }
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllllIllllllIllIlIlIlIlll, final Random llllllllllllIllllllIllIlIlIlIllI) {
        return this.quantityDropped(llllllllllllIllllllIllIlIlIlIllI) + llllllllllllIllllllIllIlIlIlIllI.nextInt(llllllllllllIllllllIllIlIlIlIlll + 1);
    }
    
    @Override
    public int tickRate(final World llllllllllllIllllllIllIllIlIlIlI) {
        return 30;
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllIllllllIllIlIIllIlIl, final World llllllllllllIllllllIllIlIIllIlII, final BlockPos llllllllllllIllllllIllIlIIlIllll, final Random llllllllllllIllllllIllIlIIllIIlI) {
        if (this.isOn) {
            this.spawnParticles(llllllllllllIllllllIllIlIIllIlII, llllllllllllIllllllIllIlIIlIllll);
        }
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllIllllllIllIlIlIIIllI, final BlockPos llllllllllllIllllllIllIlIIlllllI, final IBlockState llllllllllllIllllllIllIlIIllllIl, final float llllllllllllIllllllIllIlIlIIIIll, final int llllllllllllIllllllIllIlIIlllIll) {
        super.dropBlockAsItemWithChance(llllllllllllIllllllIllIlIlIIIllI, llllllllllllIllllllIllIlIIlllllI, llllllllllllIllllllIllIlIIllllIl, llllllllllllIllllllIllIlIlIIIIll, llllllllllllIllllllIllIlIIlllIll);
        if (this.getItemDropped(llllllllllllIllllllIllIlIIllllIl, llllllllllllIllllllIllIlIlIIIllI.rand, llllllllllllIllllllIllIlIIlllIll) != Item.getItemFromBlock(this)) {
            final int llllllllllllIllllllIllIlIlIIIIIl = 1 + llllllllllllIllllllIllIlIlIIIllI.rand.nextInt(5);
            this.dropXpOnBlockBreak(llllllllllllIllllllIllIlIlIIIllI, llllllllllllIllllllIllIlIIlllllI, llllllllllllIllllllIllIlIlIIIIIl);
        }
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllIllllllIllIlIlIllllI, final Random llllllllllllIllllllIllIlIlIlllIl, final int llllllllllllIllllllIllIlIlIlllII) {
        return Items.REDSTONE;
    }
    
    public BlockRedstoneOre(final boolean llllllllllllIllllllIllIllIlIlllI) {
        super(Material.ROCK);
        if (llllllllllllIllllllIllIllIlIlllI) {
            this.setTickRandomly(true);
        }
        this.isOn = llllllllllllIllllllIllIllIlIlllI;
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllIllllllIllIlIIIlIIII, final BlockPos llllllllllllIllllllIllIlIIIIllll, final IBlockState llllllllllllIllllllIllIlIIIIllII) {
        return new ItemStack(Item.getItemFromBlock(Blocks.REDSTONE_ORE), 1, this.damageDropped(llllllllllllIllllllIllIlIIIIllII));
    }
    
    private void spawnParticles(final World llllllllllllIllllllIllIlIIlIIlIl, final BlockPos llllllllllllIllllllIllIlIIIlllII) {
        final Random llllllllllllIllllllIllIlIIlIIIll = llllllllllllIllllllIllIlIIlIIlIl.rand;
        final double llllllllllllIllllllIllIlIIlIIIlI = 0.0625;
        for (int llllllllllllIllllllIllIlIIlIIIIl = 0; llllllllllllIllllllIllIlIIlIIIIl < 6; ++llllllllllllIllllllIllIlIIlIIIIl) {
            double llllllllllllIllllllIllIlIIlIIIII = llllllllllllIllllllIllIlIIIlllII.getX() + llllllllllllIllllllIllIlIIlIIIll.nextFloat();
            double llllllllllllIllllllIllIlIIIlllll = llllllllllllIllllllIllIlIIIlllII.getY() + llllllllllllIllllllIllIlIIlIIIll.nextFloat();
            double llllllllllllIllllllIllIlIIIllllI = llllllllllllIllllllIllIlIIIlllII.getZ() + llllllllllllIllllllIllIlIIlIIIll.nextFloat();
            if (llllllllllllIllllllIllIlIIlIIIIl == 0 && !llllllllllllIllllllIllIlIIlIIlIl.getBlockState(llllllllllllIllllllIllIlIIIlllII.up()).isOpaqueCube()) {
                llllllllllllIllllllIllIlIIIlllll = llllllllllllIllllllIllIlIIIlllII.getY() + 0.0625 + 1.0;
            }
            if (llllllllllllIllllllIllIlIIlIIIIl == 1 && !llllllllllllIllllllIllIlIIlIIlIl.getBlockState(llllllllllllIllllllIllIlIIIlllII.down()).isOpaqueCube()) {
                llllllllllllIllllllIllIlIIIlllll = llllllllllllIllllllIllIlIIIlllII.getY() - 0.0625;
            }
            if (llllllllllllIllllllIllIlIIlIIIIl == 2 && !llllllllllllIllllllIllIlIIlIIlIl.getBlockState(llllllllllllIllllllIllIlIIIlllII.south()).isOpaqueCube()) {
                llllllllllllIllllllIllIlIIIllllI = llllllllllllIllllllIllIlIIIlllII.getZ() + 0.0625 + 1.0;
            }
            if (llllllllllllIllllllIllIlIIlIIIIl == 3 && !llllllllllllIllllllIllIlIIlIIlIl.getBlockState(llllllllllllIllllllIllIlIIIlllII.north()).isOpaqueCube()) {
                llllllllllllIllllllIllIlIIIllllI = llllllllllllIllllllIllIlIIIlllII.getZ() - 0.0625;
            }
            if (llllllllllllIllllllIllIlIIlIIIIl == 4 && !llllllllllllIllllllIllIlIIlIIlIl.getBlockState(llllllllllllIllllllIllIlIIIlllII.east()).isOpaqueCube()) {
                llllllllllllIllllllIllIlIIlIIIII = llllllllllllIllllllIllIlIIIlllII.getX() + 0.0625 + 1.0;
            }
            if (llllllllllllIllllllIllIlIIlIIIIl == 5 && !llllllllllllIllllllIllIlIIlIIlIl.getBlockState(llllllllllllIllllllIllIlIIIlllII.west()).isOpaqueCube()) {
                llllllllllllIllllllIllIlIIlIIIII = llllllllllllIllllllIllIlIIIlllII.getX() - 0.0625;
            }
            if (llllllllllllIllllllIllIlIIlIIIII < llllllllllllIllllllIllIlIIIlllII.getX() || llllllllllllIllllllIllIlIIlIIIII > llllllllllllIllllllIllIlIIIlllII.getX() + 1 || llllllllllllIllllllIllIlIIIlllll < 0.0 || llllllllllllIllllllIllIlIIIlllll > llllllllllllIllllllIllIlIIIlllII.getY() + 1 || llllllllllllIllllllIllIlIIIllllI < llllllllllllIllllllIllIlIIIlllII.getZ() || llllllllllllIllllllIllIlIIIllllI > llllllllllllIllllllIllIlIIIlllII.getZ() + 1) {
                llllllllllllIllllllIllIlIIlIIlIl.spawnParticle(EnumParticleTypes.REDSTONE, llllllllllllIllllllIllIlIIlIIIII, llllllllllllIllllllIllIlIIIlllll, llllllllllllIllllllIllIlIIIllllI, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllIllllllIllIllIIIIllI, final BlockPos llllllllllllIllllllIllIlIllllIll, final IBlockState llllllllllllIllllllIllIlIllllIlI, final EntityPlayer llllllllllllIllllllIllIlIllllIIl, final EnumHand llllllllllllIllllllIllIlIllllIII, final EnumFacing llllllllllllIllllllIllIlIlllIlll, final float llllllllllllIllllllIllIllIIIIIII, final float llllllllllllIllllllIllIlIlllllll, final float llllllllllllIllllllIllIlIllllllI) {
        this.activate(llllllllllllIllllllIllIllIIIIllI, llllllllllllIllllllIllIlIllllIll);
        return super.onBlockActivated(llllllllllllIllllllIllIllIIIIllI, llllllllllllIllllllIllIlIllllIll, llllllllllllIllllllIllIlIllllIlI, llllllllllllIllllllIllIlIllllIIl, llllllllllllIllllllIllIlIllllIII, llllllllllllIllllllIllIlIlllIlll, llllllllllllIllllllIllIllIIIIIII, llllllllllllIllllllIllIlIlllllll, llllllllllllIllllllIllIlIllllllI);
    }
    
    @Override
    public void onEntityWalk(final World llllllllllllIllllllIllIllIIlIlII, final BlockPos llllllllllllIllllllIllIllIIlIlll, final Entity llllllllllllIllllllIllIllIIlIllI) {
        this.activate(llllllllllllIllllllIllIllIIlIlII, llllllllllllIllllllIllIllIIlIlll);
        super.onEntityWalk(llllllllllllIllllllIllIllIIlIlII, llllllllllllIllllllIllIllIIlIlll, llllllllllllIllllllIllIllIIlIllI);
    }
    
    private void activate(final World llllllllllllIllllllIllIlIllIllll, final BlockPos llllllllllllIllllllIllIlIllIlIll) {
        this.spawnParticles(llllllllllllIllllllIllIlIllIllll, llllllllllllIllllllIllIlIllIlIll);
        if (this == Blocks.REDSTONE_ORE) {
            llllllllllllIllllllIllIlIllIllll.setBlockState(llllllllllllIllllllIllIlIllIlIll, Blocks.LIT_REDSTONE_ORE.getDefaultState());
        }
    }
}
