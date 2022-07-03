package net.minecraft.block;

import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;

public class BlockStainedGlass extends BlockBreakable
{
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> COLOR;
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIlIIllIIIIllIllI, final IBlockAccess llllllllllllllIlIlIIllIIIIllIlIl, final BlockPos llllllllllllllIlIlIIllIIIIllIlII) {
        return MapColor.func_193558_a(llllllllllllllIlIlIIllIIIIllIllI.getValue(BlockStainedGlass.COLOR));
    }
    
    static {
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIlIlIIllIIIIlIllIl) {
        return false;
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIlIlIIllIIIIlIIIII, final BlockPos llllllllllllllIlIlIIllIIIIlIIIlI, final IBlockState llllllllllllllIlIlIIllIIIIlIIIIl) {
        if (!llllllllllllllIlIlIIllIIIIlIIIII.isRemote) {
            BlockBeacon.updateColorAsync(llllllllllllllIlIlIIllIIIIlIIIII, llllllllllllllIlIlIIllIIIIlIIIlI);
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStainedGlass.COLOR });
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIlIlIIllIIIIllIIII) {
        return 0;
    }
    
    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIlIlIIllIIIIIllIII, final BlockPos llllllllllllllIlIlIIllIIIIIlIlll, final IBlockState llllllllllllllIlIlIIllIIIIIllIIl) {
        if (!llllllllllllllIlIlIIllIIIIIllIII.isRemote) {
            BlockBeacon.updateColorAsync(llllllllllllllIlIlIIllIIIIIllIII, llllllllllllllIlIlIIllIIIIIlIlll);
        }
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllllIlIlIIllIIIlIIIIIl, final NonNullList<ItemStack> llllllllllllllIlIlIIllIIIIllllIl) {
        final double llllllllllllllIlIlIIllIIIIlllIIl;
        final byte llllllllllllllIlIlIIllIIIIlllIlI = (byte)((EnumDyeColor[])(Object)(llllllllllllllIlIlIIllIIIIlllIIl = (double)(Object)EnumDyeColor.values())).length;
        for (final EnumDyeColor llllllllllllllIlIlIIllIIIIllllll : llllllllllllllIlIlIIllIIIIlllIIl) {
            llllllllllllllIlIlIIllIIIIllllIl.add(new ItemStack(this, 1, llllllllllllllIlIlIIllIIIIllllll.getMetadata()));
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlIIllIIIIIlIIll) {
        return llllllllllllllIlIlIIllIIIIIlIIll.getValue(BlockStainedGlass.COLOR).getMetadata();
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIlIIllIIIlIIlIIl) {
        return llllllllllllllIlIlIIllIIIlIIlIIl.getValue(BlockStainedGlass.COLOR).getMetadata();
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIlIIllIIIIlIIlll) {
        return this.getDefaultState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.byMetadata(llllllllllllllIlIlIIllIIIIlIIlll));
    }
    
    public BlockStainedGlass(final Material llllllllllllllIlIlIIllIIIlIIllIl) {
        super(llllllllllllllIlIlIIllIIIlIIllIl, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockStainedGlass.COLOR, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
}
