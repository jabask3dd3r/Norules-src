package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockStandingSign extends BlockSign
{
    public static final /* synthetic */ PropertyInteger ROTATION;
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllllllllIIIIIIIIII) {
        return lllllllllllllIllllllllIIIIIIIIII.getValue((IProperty<Integer>)BlockStandingSign.ROTATION);
    }
    
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIllllllllIIIIIlIIll, final World lllllllllllllIllllllllIIIIIlIIlI, final BlockPos lllllllllllllIllllllllIIIIIIlIll, final Block lllllllllllllIllllllllIIIIIlIIII, final BlockPos lllllllllllllIllllllllIIIIIIllll) {
        if (!lllllllllllllIllllllllIIIIIlIIlI.getBlockState(lllllllllllllIllllllllIIIIIIlIll.down()).getMaterial().isSolid()) {
            this.dropBlockAsItem(lllllllllllllIllllllllIIIIIlIIlI, lllllllllllllIllllllllIIIIIIlIll, lllllllllllllIllllllllIIIIIlIIll, 0);
            lllllllllllllIllllllllIIIIIlIIlI.setBlockToAir(lllllllllllllIllllllllIIIIIIlIll);
        }
        super.neighborChanged(lllllllllllllIllllllllIIIIIlIIll, lllllllllllllIllllllllIIIIIlIIlI, lllllllllllllIllllllllIIIIIIlIll, lllllllllllllIllllllllIIIIIlIIII, lllllllllllllIllllllllIIIIIIllll);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIlllllllIlllllllIll, final Rotation lllllllllllllIlllllllIlllllllIlI) {
        return lllllllllllllIlllllllIlllllllIll.withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, lllllllllllllIlllllllIlllllllIlI.rotate(lllllllllllllIlllllllIlllllllIll.getValue((IProperty<Integer>)BlockStandingSign.ROTATION), 16));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllllllllIIIIIIIIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, lllllllllllllIllllllllIIIIIIIIll);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStandingSign.ROTATION });
    }
    
    public BlockStandingSign() {
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, 0));
    }
    
    static {
        ROTATION = PropertyInteger.create("rotation", 0, 15);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIlllllllIllllllIIlI, final Mirror lllllllllllllIlllllllIllllllIIIl) {
        return lllllllllllllIlllllllIllllllIIlI.withProperty((IProperty<Comparable>)BlockStandingSign.ROTATION, lllllllllllllIlllllllIllllllIIIl.mirrorRotation(lllllllllllllIlllllllIllllllIIlI.getValue((IProperty<Integer>)BlockStandingSign.ROTATION), 16));
    }
}
