package net.minecraft.block;

import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.util.*;
import net.minecraft.init.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import net.minecraft.item.*;

public class BlockMycelium extends Block
{
    public static final /* synthetic */ PropertyBool SNOWY;
    
    static {
        SNOWY = PropertyBool.create("snowy");
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllIIlIIIIlllIIlIllll, final World llllllllllllllIIlIIIIlllIIlIlIIl, final BlockPos llllllllllllllIIlIIIIlllIIlIlIII, final Random llllllllllllllIIlIIIIlllIIlIIlll) {
        super.randomDisplayTick(llllllllllllllIIlIIIIlllIIlIllll, llllllllllllllIIlIIIIlllIIlIlIIl, llllllllllllllIIlIIIIlllIIlIlIII, llllllllllllllIIlIIIIlllIIlIIlll);
        if (llllllllllllllIIlIIIIlllIIlIIlll.nextInt(10) == 0) {
            llllllllllllllIIlIIIIlllIIlIlIIl.spawnParticle(EnumParticleTypes.TOWN_AURA, llllllllllllllIIlIIIIlllIIlIlIII.getX() + llllllllllllllIIlIIIIlllIIlIIlll.nextFloat(), llllllllllllllIIlIIIIlllIIlIlIII.getY() + 1.1f, llllllllllllllIIlIIIIlllIIlIlIII.getZ() + llllllllllllllIIlIIIIlllIIlIIlll.nextFloat(), 0.0, 0.0, 0.0, new int[0]);
        }
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIlIIIIlllIIllllII, final BlockPos llllllllllllllIIlIIIIlllIlIIIlII, final IBlockState llllllllllllllIIlIIIIlllIlIIIIll, final Random llllllllllllllIIlIIIIlllIIlllIlI) {
        if (!llllllllllllllIIlIIIIlllIIllllII.isRemote) {
            if (llllllllllllllIIlIIIIlllIIllllII.getLightFromNeighbors(llllllllllllllIIlIIIIlllIlIIIlII.up()) < 4 && llllllllllllllIIlIIIIlllIIllllII.getBlockState(llllllllllllllIIlIIIIlllIlIIIlII.up()).getLightOpacity() > 2) {
                llllllllllllllIIlIIIIlllIIllllII.setBlockState(llllllllllllllIIlIIIIlllIlIIIlII, Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT));
            }
            else if (llllllllllllllIIlIIIIlllIIllllII.getLightFromNeighbors(llllllllllllllIIlIIIIlllIlIIIlII.up()) >= 9) {
                for (int llllllllllllllIIlIIIIlllIlIIIIIl = 0; llllllllllllllIIlIIIIlllIlIIIIIl < 4; ++llllllllllllllIIlIIIIlllIlIIIIIl) {
                    final BlockPos llllllllllllllIIlIIIIlllIlIIIIII = llllllllllllllIIlIIIIlllIlIIIlII.add(llllllllllllllIIlIIIIlllIIlllIlI.nextInt(3) - 1, llllllllllllllIIlIIIIlllIIlllIlI.nextInt(5) - 3, llllllllllllllIIlIIIIlllIIlllIlI.nextInt(3) - 1);
                    final IBlockState llllllllllllllIIlIIIIlllIIllllll = llllllllllllllIIlIIIIlllIIllllII.getBlockState(llllllllllllllIIlIIIIlllIlIIIIII);
                    final IBlockState llllllllllllllIIlIIIIlllIIlllllI = llllllllllllllIIlIIIIlllIIllllII.getBlockState(llllllllllllllIIlIIIIlllIlIIIIII.up());
                    if (llllllllllllllIIlIIIIlllIIllllll.getBlock() == Blocks.DIRT && llllllllllllllIIlIIIIlllIIllllll.getValue(BlockDirt.VARIANT) == BlockDirt.DirtType.DIRT && llllllllllllllIIlIIIIlllIIllllII.getLightFromNeighbors(llllllllllllllIIlIIIIlllIlIIIIII.up()) >= 4 && llllllllllllllIIlIIIIlllIIlllllI.getLightOpacity() <= 2) {
                        llllllllllllllIIlIIIIlllIIllllII.setBlockState(llllllllllllllIIlIIIIlllIlIIIIII, this.getDefaultState());
                    }
                }
            }
        }
    }
    
    protected BlockMycelium() {
        super(Material.GRASS, MapColor.PURPLE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockMycelium.SNOWY, false));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockMycelium.SNOWY });
    }
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllllIIlIIIIlllIlIlIIlI, final IBlockAccess llllllllllllllIIlIIIIlllIlIlIlIl, final BlockPos llllllllllllllIIlIIIIlllIlIlIlII) {
        final Block llllllllllllllIIlIIIIlllIlIlIIll = llllllllllllllIIlIIIIlllIlIlIlIl.getBlockState(llllllllllllllIIlIIIIlllIlIlIlII.up()).getBlock();
        return llllllllllllllIIlIIIIlllIlIlIIlI.withProperty((IProperty<Comparable>)BlockMycelium.SNOWY, llllllllllllllIIlIIIIlllIlIlIIll == Blocks.SNOW || llllllllllllllIIlIIIIlllIlIlIIll == Blocks.SNOW_LAYER);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIlIIIIlllIIIlllIl) {
        return 0;
    }
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIIlIIIIlllIIlIIIll, final Random llllllllllllllIIlIIIIlllIIlIIIlI, final int llllllllllllllIIlIIIIlllIIIlllll) {
        return Blocks.DIRT.getItemDropped(Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.DIRT), llllllllllllllIIlIIIIlllIIlIIIlI, llllllllllllllIIlIIIIlllIIIlllll);
    }
}
