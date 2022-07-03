package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.block.state.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;

public class BlockStainedGlassPane extends BlockPane
{
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror;
    public static final /* synthetic */ PropertyEnum<EnumDyeColor> COLOR;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockStainedGlassPane.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final boolean lllllllllllllIllllIIIIIIIIIIllll = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIllllIIIIIIIIIIllll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIIIIIIIllll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIIIIIIIllll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIIIIIIIIIllll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockStainedGlassPane.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIllllIIIIIIIIIIllll;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIllllIIIIIIIIlIlIII, final Mirror lllllllllllllIllllIIIIIIIIlIIlll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Mirror()[lllllllllllllIllllIIIIIIIIlIIlll.ordinal()]) {
            case 2: {
                return lllllllllllllIllllIIIIIIIIlIlIII.withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, (Boolean)lllllllllllllIllllIIIIIIIIlIlIII.getValue((IProperty<V>)BlockStainedGlassPane.SOUTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, (Boolean)lllllllllllllIllllIIIIIIIIlIlIII.getValue((IProperty<V>)BlockStainedGlassPane.NORTH));
            }
            case 3: {
                return lllllllllllllIllllIIIIIIIIlIlIII.withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, (Boolean)lllllllllllllIllllIIIIIIIIlIlIII.getValue((IProperty<V>)BlockStainedGlassPane.WEST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, (Boolean)lllllllllllllIllllIIIIIIIIlIlIII.getValue((IProperty<V>)BlockStainedGlassPane.EAST));
            }
            default: {
                return super.withMirror(lllllllllllllIllllIIIIIIIIlIlIII, lllllllllllllIllllIIIIIIIIlIIlll);
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllllIIIIIIIIlllIII) {
        return this.getDefaultState().withProperty(BlockStainedGlassPane.COLOR, EnumDyeColor.byMetadata(lllllllllllllIllllIIIIIIIIlllIII));
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIllllIIIIIIIIIlIlIl, final BlockPos lllllllllllllIllllIIIIIIIIIlIIIl, final IBlockState lllllllllllllIllllIIIIIIIIIlIIll) {
        if (!lllllllllllllIllllIIIIIIIIIlIlIl.isRemote) {
            BlockBeacon.updateColorAsync(lllllllllllllIllllIIIIIIIIIlIlIl, lllllllllllllIllllIIIIIIIIIlIIIl);
        }
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIllllIIIIIIIlIIllll) {
        return lllllllllllllIllllIIIIIIIlIIllll.getValue(BlockStainedGlassPane.COLOR).getMetadata();
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIllllIIIIIIIIllllll, final IBlockAccess lllllllllllllIllllIIIIIIIlIIIIIl, final BlockPos lllllllllllllIllllIIIIIIIlIIIIII) {
        return MapColor.func_193558_a(lllllllllllllIllllIIIIIIIIllllll.getValue(BlockStainedGlassPane.COLOR));
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIllllIIIIIIIIIllIlI, final BlockPos lllllllllllllIllllIIIIIIIIIlllII, final IBlockState lllllllllllllIllllIIIIIIIIIllIll) {
        if (!lllllllllllllIllllIIIIIIIIIllIlI.isRemote) {
            BlockBeacon.updateColorAsync(lllllllllllllIllllIIIIIIIIIllIlI, lllllllllllllIllllIIIIIIIIIlllII);
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllllIIIIIIIIllIlII) {
        return lllllllllllllIllllIIIIIIIIllIlII.getValue(BlockStainedGlassPane.COLOR).getMetadata();
    }
    
    static {
        COLOR = PropertyEnum.create("color", EnumDyeColor.class);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStainedGlassPane.NORTH, BlockStainedGlassPane.EAST, BlockStainedGlassPane.WEST, BlockStainedGlassPane.SOUTH, BlockStainedGlassPane.COLOR });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Mirror() {
        final int[] $switch_TABLE$net$minecraft$util$Mirror = BlockStainedGlassPane.$SWITCH_TABLE$net$minecraft$util$Mirror;
        if ($switch_TABLE$net$minecraft$util$Mirror != null) {
            return $switch_TABLE$net$minecraft$util$Mirror;
        }
        final Exception lllllllllllllIllllIIIIIIIIIIllIl = (Object)new int[Mirror.values().length];
        try {
            lllllllllllllIllllIIIIIIIIIIllIl[Mirror.FRONT_BACK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIIIIIIIIIllIl[Mirror.LEFT_RIGHT.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIIIIIIIIIllIl[Mirror.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockStainedGlassPane.$SWITCH_TABLE$net$minecraft$util$Mirror = (int[])(Object)lllllllllllllIllllIIIIIIIIIIllIl;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIllllIIIIIIIlIIlIlI, final NonNullList<ItemStack> lllllllllllllIllllIIIIIIIlIIlIIl) {
        for (int lllllllllllllIllllIIIIIIIlIIlIII = 0; lllllllllllllIllllIIIIIIIlIIlIII < EnumDyeColor.values().length; ++lllllllllllllIllllIIIIIIIlIIlIII) {
            lllllllllllllIllllIIIIIIIlIIlIIl.add(new ItemStack(this, 1, lllllllllllllIllllIIIIIIIlIIlIII));
        }
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIllllIIIIIIIIllIIII, final Rotation lllllllllllllIllllIIIIIIIIlIllll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIllllIIIIIIIIlIllll.ordinal()]) {
            case 3: {
                return lllllllllllllIllllIIIIIIIIllIIII.withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.SOUTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.WEST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.NORTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.EAST));
            }
            case 4: {
                return lllllllllllllIllllIIIIIIIIllIIII.withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.EAST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.SOUTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.WEST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.NORTH));
            }
            case 2: {
                return lllllllllllllIllllIIIIIIIIllIIII.withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.WEST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.NORTH)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.EAST)).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, (Boolean)lllllllllllllIllllIIIIIIIIllIIII.getValue((IProperty<V>)BlockStainedGlassPane.SOUTH));
            }
            default: {
                return lllllllllllllIllllIIIIIIIIllIIII;
            }
        }
    }
    
    public BlockStainedGlassPane() {
        super(Material.GLASS, false);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockStainedGlassPane.NORTH, false).withProperty((IProperty<Comparable>)BlockStainedGlassPane.EAST, false).withProperty((IProperty<Comparable>)BlockStainedGlassPane.SOUTH, false).withProperty((IProperty<Comparable>)BlockStainedGlassPane.WEST, false).withProperty(BlockStainedGlassPane.COLOR, EnumDyeColor.WHITE));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
}
