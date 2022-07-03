package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import com.google.common.collect.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.util.text.translation.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockSponge extends Block
{
    public static final /* synthetic */ PropertyBool WET;
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlllllIlIlllIIIIlI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockSponge.WET, (llllllllllllllIlllllIlIlllIIIIlI & 0x1) == 0x1);
    }
    
    private boolean absorb(final World llllllllllllllIlllllIlIlllIllIll, final BlockPos llllllllllllllIlllllIlIlllIllIlI) {
        final Queue<Tuple<BlockPos, Integer>> llllllllllllllIlllllIlIllllIIlII = (Queue<Tuple<BlockPos, Integer>>)Lists.newLinkedList();
        final List<BlockPos> llllllllllllllIlllllIlIllllIIIll = (List<BlockPos>)Lists.newArrayList();
        llllllllllllllIlllllIlIllllIIlII.add(new Tuple<BlockPos, Integer>(llllllllllllllIlllllIlIlllIllIlI, 0));
        int llllllllllllllIlllllIlIllllIIIlI = 0;
        while (!llllllllllllllIlllllIlIllllIIlII.isEmpty()) {
            final Tuple<BlockPos, Integer> llllllllllllllIlllllIlIllllIIIIl = llllllllllllllIlllllIlIllllIIlII.poll();
            final BlockPos llllllllllllllIlllllIlIllllIIIII = llllllllllllllIlllllIlIllllIIIIl.getFirst();
            final int llllllllllllllIlllllIlIlllIlllll = llllllllllllllIlllllIlIllllIIIIl.getSecond();
            final float llllllllllllllIlllllIlIlllIlIIII;
            final String llllllllllllllIlllllIlIlllIlIIIl = (String)((EnumFacing[])(Object)(llllllllllllllIlllllIlIlllIlIIII = (float)(Object)EnumFacing.values())).length;
            for (short llllllllllllllIlllllIlIlllIlIIlI = 0; llllllllllllllIlllllIlIlllIlIIlI < llllllllllllllIlllllIlIlllIlIIIl; ++llllllllllllllIlllllIlIlllIlIIlI) {
                final EnumFacing llllllllllllllIlllllIlIlllIllllI = llllllllllllllIlllllIlIlllIlIIII[llllllllllllllIlllllIlIlllIlIIlI];
                final BlockPos llllllllllllllIlllllIlIlllIlllIl = llllllllllllllIlllllIlIllllIIIII.offset(llllllllllllllIlllllIlIlllIllllI);
                if (llllllllllllllIlllllIlIlllIllIll.getBlockState(llllllllllllllIlllllIlIlllIlllIl).getMaterial() == Material.WATER) {
                    llllllllllllllIlllllIlIlllIllIll.setBlockState(llllllllllllllIlllllIlIlllIlllIl, Blocks.AIR.getDefaultState(), 2);
                    llllllllllllllIlllllIlIllllIIIll.add(llllllllllllllIlllllIlIlllIlllIl);
                    ++llllllllllllllIlllllIlIllllIIIlI;
                    if (llllllllllllllIlllllIlIlllIlllll < 6) {
                        llllllllllllllIlllllIlIllllIIlII.add(new Tuple<BlockPos, Integer>(llllllllllllllIlllllIlIlllIlllIl, llllllllllllllIlllllIlIlllIlllll + 1));
                    }
                }
            }
            if (llllllllllllllIlllllIlIllllIIIlI > 64) {
                break;
            }
        }
        for (final BlockPos llllllllllllllIlllllIlIlllIlllII : llllllllllllllIlllllIlIllllIIIll) {
            llllllllllllllIlllllIlIlllIllIll.notifyNeighborsOfStateChange(llllllllllllllIlllllIlIlllIlllII, Blocks.AIR, false);
        }
        return llllllllllllllIlllllIlIllllIIIlI > 0;
    }
    
    protected void tryAbsorb(final World llllllllllllllIlllllIlIlllllIlll, final BlockPos llllllllllllllIlllllIlIlllllIllI, final IBlockState llllllllllllllIlllllIlIlllllIlIl) {
        if (!llllllllllllllIlllllIlIlllllIlIl.getValue((IProperty<Boolean>)BlockSponge.WET) && this.absorb(llllllllllllllIlllllIlIlllllIlll, llllllllllllllIlllllIlIlllllIllI)) {
            llllllllllllllIlllllIlIlllllIlll.setBlockState(llllllllllllllIlllllIlIlllllIllI, llllllllllllllIlllllIlIlllllIlIl.withProperty((IProperty<Comparable>)BlockSponge.WET, true), 2);
            llllllllllllllIlllllIlIlllllIlll.playEvent(2001, llllllllllllllIlllllIlIlllllIllI, Block.getIdFromBlock(Blocks.WATER));
        }
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllllIlllllIlIlllIIlIll, final NonNullList<ItemStack> llllllllllllllIlllllIlIlllIIlIlI) {
        llllllllllllllIlllllIlIlllIIlIlI.add(new ItemStack(this, 1, 0));
        llllllllllllllIlllllIlIlllIIlIlI.add(new ItemStack(this, 1, 1));
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIlllllIllIIIIIIlIl, final World llllllllllllllIlllllIllIIIIIIlII, final BlockPos llllllllllllllIlllllIllIIIIIIIll, final Block llllllllllllllIlllllIllIIIIIIIlI, final BlockPos llllllllllllllIlllllIllIIIIIIIIl) {
        this.tryAbsorb(llllllllllllllIlllllIllIIIIIIlII, llllllllllllllIlllllIllIIIIIIIll, llllllllllllllIlllllIllIIIIIIlIl);
        super.neighborChanged(llllllllllllllIlllllIllIIIIIIlIl, llllllllllllllIlllllIllIIIIIIlII, llllllllllllllIlllllIllIIIIIIIll, llllllllllllllIlllllIllIIIIIIIlI, llllllllllllllIlllllIllIIIIIIIIl);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlllllIlIllIllllll) {
        return ((boolean)llllllllllllllIlllllIlIllIllllll.getValue((IProperty<Boolean>)BlockSponge.WET)) ? 1 : 0;
    }
    
    protected BlockSponge() {
        super(Material.SPONGE);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockSponge.WET, false));
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSponge.WET });
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIlllllIllIIIIllIIl, final BlockPos llllllllllllllIlllllIllIIIIllIII, final IBlockState llllllllllllllIlllllIllIIIIlIlll) {
        this.tryAbsorb(llllllllllllllIlllllIllIIIIllIIl, llllllllllllllIlllllIllIIIIllIII, llllllllllllllIlllllIllIIIIlIlll);
    }
    
    static {
        WET = PropertyBool.create("wet");
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".dry.name")));
    }
    
    @Override
    public void randomDisplayTick(final IBlockState llllllllllllllIlllllIlIllIllIIIl, final World llllllllllllllIlllllIlIllIllIIII, final BlockPos llllllllllllllIlllllIlIllIlIllll, final Random llllllllllllllIlllllIlIllIlIIllI) {
        if (llllllllllllllIlllllIlIllIllIIIl.getValue((IProperty<Boolean>)BlockSponge.WET)) {
            final EnumFacing llllllllllllllIlllllIlIllIlIllIl = EnumFacing.random(llllllllllllllIlllllIlIllIlIIllI);
            if (llllllllllllllIlllllIlIllIlIllIl != EnumFacing.UP && !llllllllllllllIlllllIlIllIllIIII.getBlockState(llllllllllllllIlllllIlIllIlIllll.offset(llllllllllllllIlllllIlIllIlIllIl)).isFullyOpaque()) {
                double llllllllllllllIlllllIlIllIlIllII = llllllllllllllIlllllIlIllIlIllll.getX();
                double llllllllllllllIlllllIlIllIlIlIll = llllllllllllllIlllllIlIllIlIllll.getY();
                double llllllllllllllIlllllIlIllIlIlIlI = llllllllllllllIlllllIlIllIlIllll.getZ();
                if (llllllllllllllIlllllIlIllIlIllIl == EnumFacing.DOWN) {
                    llllllllllllllIlllllIlIllIlIlIll -= 0.05;
                    llllllllllllllIlllllIlIllIlIllII += llllllllllllllIlllllIlIllIlIIllI.nextDouble();
                    llllllllllllllIlllllIlIllIlIlIlI += llllllllllllllIlllllIlIllIlIIllI.nextDouble();
                }
                else {
                    llllllllllllllIlllllIlIllIlIlIll += llllllllllllllIlllllIlIllIlIIllI.nextDouble() * 0.8;
                    if (llllllllllllllIlllllIlIllIlIllIl.getAxis() == EnumFacing.Axis.X) {
                        llllllllllllllIlllllIlIllIlIlIlI += llllllllllllllIlllllIlIllIlIIllI.nextDouble();
                        if (llllllllllllllIlllllIlIllIlIllIl == EnumFacing.EAST) {
                            ++llllllllllllllIlllllIlIllIlIllII;
                        }
                        else {
                            llllllllllllllIlllllIlIllIlIllII += 0.05;
                        }
                    }
                    else {
                        llllllllllllllIlllllIlIllIlIllII += llllllllllllllIlllllIlIllIlIIllI.nextDouble();
                        if (llllllllllllllIlllllIlIllIlIllIl == EnumFacing.SOUTH) {
                            ++llllllllllllllIlllllIlIllIlIlIlI;
                        }
                        else {
                            llllllllllllllIlllllIlIllIlIlIlI += 0.05;
                        }
                    }
                }
                llllllllllllllIlllllIlIllIllIIII.spawnParticle(EnumParticleTypes.DRIP_WATER, llllllllllllllIlllllIlIllIlIllII, llllllllllllllIlllllIlIllIlIlIll, llllllllllllllIlllllIlIllIlIlIlI, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlllllIllIIIlIIIII) {
        return ((boolean)llllllllllllllIlllllIllIIIlIIIII.getValue((IProperty<Boolean>)BlockSponge.WET)) ? 1 : 0;
    }
}
