package net.minecraft.block;

import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.init.*;
import net.minecraft.item.*;

public class BlockNetherWart extends BlockBush
{
    private static final /* synthetic */ AxisAlignedBB[] NETHER_WART_AABB;
    public static final /* synthetic */ PropertyInteger AGE;
    
    protected BlockNetherWart() {
        super(Material.PLANTS, MapColor.RED);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockNetherWart.AGE, 0));
        this.setTickRandomly(true);
        this.setCreativeTab(null);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llIIIlIIllIlllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockNetherWart.AGE, llIIIlIIllIlllI);
    }
    
    @Override
    public boolean canBlockStay(final World llIIIlIlIlIIlll, final BlockPos llIIIlIlIlIIIlI, final IBlockState llIIIlIlIlIIlIl) {
        return this.canSustainBush(llIIIlIlIlIIlll.getBlockState(llIIIlIlIlIIIlI.down()));
    }
    
    @Override
    public int quantityDropped(final Random llIIIlIIlllIllI) {
        return 0;
    }
    
    static {
        AGE = PropertyInteger.create("age", 0, 3);
        NETHER_WART_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.3125, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.5, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.6875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.875, 1.0) };
    }
    
    @Override
    public ItemStack getItem(final World llIIIlIIlllIlII, final BlockPos llIIIlIIlllIIll, final IBlockState llIIIlIIlllIIlI) {
        return new ItemStack(Items.NETHER_WART);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llIIIlIlIllIIII, final IBlockAccess llIIIlIlIllIIlI, final BlockPos llIIIlIlIllIIIl) {
        return BlockNetherWart.NETHER_WART_AABB[llIIIlIlIllIIII.getValue((IProperty<Integer>)BlockNetherWart.AGE)];
    }
    
    @Override
    public void updateTick(final World llIIIlIlIIllIlI, final BlockPos llIIIlIlIIlIIll, IBlockState llIIIlIlIIlIIlI, final Random llIIIlIlIIlIlll) {
        final int llIIIlIlIIlIllI = ((IBlockState)llIIIlIlIIlIIlI).getValue((IProperty<Integer>)BlockNetherWart.AGE);
        if (llIIIlIlIIlIllI < 3 && llIIIlIlIIlIlll.nextInt(10) == 0) {
            llIIIlIlIIlIIlI = ((IBlockState)llIIIlIlIIlIIlI).withProperty((IProperty<Comparable>)BlockNetherWart.AGE, Integer.valueOf(llIIIlIlIIlIllI + 1));
            llIIIlIlIIllIlI.setBlockState(llIIIlIlIIlIIll, (IBlockState)llIIIlIlIIlIIlI, 2);
        }
        super.updateTick(llIIIlIlIIllIlI, llIIIlIlIIlIIll, (IBlockState)llIIIlIlIIlIIlI, llIIIlIlIIlIlll);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockNetherWart.AGE });
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World llIIIlIlIIIIIIl, final BlockPos llIIIlIlIIIIlll, final IBlockState llIIIlIlIIIIllI, final float llIIIlIlIIIIlIl, final int llIIIlIIllllllI) {
        if (!llIIIlIlIIIIIIl.isRemote) {
            int llIIIlIlIIIIIll = 1;
            if (llIIIlIlIIIIllI.getValue((IProperty<Integer>)BlockNetherWart.AGE) >= 3) {
                llIIIlIlIIIIIll = 2 + llIIIlIlIIIIIIl.rand.nextInt(3);
                if (llIIIlIIllllllI > 0) {
                    llIIIlIlIIIIIll += llIIIlIlIIIIIIl.rand.nextInt(llIIIlIIllllllI + 1);
                }
            }
            for (int llIIIlIlIIIIIlI = 0; llIIIlIlIIIIIlI < llIIIlIlIIIIIll; ++llIIIlIlIIIIIlI) {
                Block.spawnAsEntity(llIIIlIlIIIIIIl, llIIIlIlIIIIlll, new ItemStack(Items.NETHER_WART));
            }
        }
    }
    
    @Override
    protected boolean canSustainBush(final IBlockState llIIIlIlIlIllIl) {
        return llIIIlIlIlIllIl.getBlock() == Blocks.SOUL_SAND;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llIIIlIIllllIlI, final Random llIIIlIIllllIIl, final int llIIIlIIllllIII) {
        return Items.field_190931_a;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llIIIlIIllIlIIl) {
        return llIIIlIIllIlIIl.getValue((IProperty<Integer>)BlockNetherWart.AGE);
    }
}
