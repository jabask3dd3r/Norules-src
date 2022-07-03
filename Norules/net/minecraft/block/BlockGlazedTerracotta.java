package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;

public class BlockGlazedTerracotta extends BlockHorizontal
{
    @Override
    public IBlockState withRotation(final IBlockState lIIlIIlIIllIlIl, final Rotation lIIlIIlIIllIIlI) {
        return lIIlIIlIIllIlIl.withProperty((IProperty<Comparable>)BlockGlazedTerracotta.FACING, lIIlIIlIIllIIlI.rotate(lIIlIIlIIllIlIl.getValue((IProperty<EnumFacing>)BlockGlazedTerracotta.FACING)));
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lIIlIIlIIlIIlll, final BlockPos lIIlIIlIIlIIllI, final EnumFacing lIIlIIlIIlIIlIl, final float lIIlIIlIIlIIlII, final float lIIlIIlIIlIIIll, final float lIIlIIlIIlIIIlI, final int lIIlIIlIIlIIIIl, final EntityLivingBase lIIlIIlIIIllllI) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockGlazedTerracotta.FACING, lIIlIIlIIIllllI.getHorizontalFacing().getOpposite());
    }
    
    public BlockGlazedTerracotta(final EnumDyeColor lIIlIIlIlIIIIlI) {
        super(Material.ROCK, MapColor.func_193558_a(lIIlIIlIlIIIIlI));
        this.setHardness(1.4f);
        this.setSoundType(SoundType.STONE);
        final String lIIlIIlIlIIIIIl = lIIlIIlIlIIIIlI.getUnlocalizedName();
        if (lIIlIIlIlIIIIIl.length() > 1) {
            final String lIIlIIlIlIIIIII = String.valueOf(new StringBuilder(String.valueOf(lIIlIIlIlIIIIIl.substring(0, 1).toUpperCase())).append(lIIlIIlIlIIIIIl.substring(1, lIIlIIlIlIIIIIl.length())));
            this.setUnlocalizedName(String.valueOf(new StringBuilder("glazedTerracotta").append(lIIlIIlIlIIIIII)));
        }
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lIIlIIlIIlIlllI, final Mirror lIIlIIlIIlIlIll) {
        return lIIlIIlIIlIlllI.withRotation(lIIlIIlIIlIlIll.toRotation(lIIlIIlIIlIlllI.getValue((IProperty<EnumFacing>)BlockGlazedTerracotta.FACING)));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIIlIIlIIIllIlI) {
        int lIIlIIlIIIllIIl = 0;
        lIIlIIlIIIllIIl |= lIIlIIlIIIllIlI.getValue((IProperty<EnumFacing>)BlockGlazedTerracotta.FACING).getHorizontalIndex();
        return lIIlIIlIIIllIIl;
    }
    
    @Override
    public EnumPushReaction getMobilityFlag(final IBlockState lIIlIIlIIIIllll) {
        return EnumPushReaction.PUSH_ONLY;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockGlazedTerracotta.FACING });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIlIIlIIIlIIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockGlazedTerracotta.FACING, EnumFacing.getHorizontal(lIIlIIlIIIlIIll));
    }
}
