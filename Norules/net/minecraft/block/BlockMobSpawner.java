package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import net.minecraft.tileentity.*;

public class BlockMobSpawner extends BlockContainer
{
    @Override
    public void dropBlockAsItemWithChance(final World llllllllllllllIIllIIlllIlIlIIlll, final BlockPos llllllllllllllIIllIIlllIlIlIllIl, final IBlockState llllllllllllllIIllIIlllIlIlIIlIl, final float llllllllllllllIIllIIlllIlIlIlIll, final int llllllllllllllIIllIIlllIlIlIIIll) {
        super.dropBlockAsItemWithChance(llllllllllllllIIllIIlllIlIlIIlll, llllllllllllllIIllIIlllIlIlIllIl, llllllllllllllIIllIIlllIlIlIIlIl, llllllllllllllIIllIIlllIlIlIlIll, llllllllllllllIIllIIlllIlIlIIIll);
        final int llllllllllllllIIllIIlllIlIlIlIIl = 15 + llllllllllllllIIllIIlllIlIlIIlll.rand.nextInt(15) + llllllllllllllIIllIIlllIlIlIIlll.rand.nextInt(15);
        this.dropXpOnBlockBreak(llllllllllllllIIllIIlllIlIlIIlll, llllllllllllllIIllIIlllIlIlIllIl, llllllllllllllIIllIIlllIlIlIlIIl);
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIIllIIlllIlIIllIll, final BlockPos llllllllllllllIIllIIlllIlIIllIlI, final IBlockState llllllllllllllIIllIIlllIlIIllIIl) {
        return ItemStack.field_190927_a;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllllIIllIIlllIlIIllllI) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIIllIIlllIlIllIlll) {
        return 0;
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    protected BlockMobSpawner() {
        super(Material.ROCK);
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIIllIIlllIlIlIIIII) {
        return false;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIllIIlllIlIlllIll, final Random llllllllllllllIIllIIlllIlIlllIlI, final int llllllllllllllIIllIIlllIlIlllIIl) {
        return Items.field_190931_a;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIllIIlllIlIlllllI, final int llllllllllllllIIllIIlllIlIllllIl) {
        return new TileEntityMobSpawner();
    }
}
