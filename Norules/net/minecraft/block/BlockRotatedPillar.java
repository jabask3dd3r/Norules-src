package net.minecraft.block;

import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;

public class BlockRotatedPillar extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumFacing.Axis> AXIS;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockRotatedPillar.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final byte lllllllllllllllllIIllIlIlIIlIlll = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllllllIIllIlIlIIlIlll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIIllIlIlIIlIlll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIIllIlIlIIlIlll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllllIIllIlIlIIlIlll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockRotatedPillar.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllllllIIllIlIlIIlIlll;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRotatedPillar.AXIS });
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllllllIIllIlIlIllllll) {
        int lllllllllllllllllIIllIlIllIIIIIl = 0;
        final EnumFacing.Axis lllllllllllllllllIIllIlIllIIIIII = lllllllllllllllllIIllIlIlIllllll.getValue(BlockRotatedPillar.AXIS);
        if (lllllllllllllllllIIllIlIllIIIIII == EnumFacing.Axis.X) {
            lllllllllllllllllIIllIlIllIIIIIl |= 0x4;
        }
        else if (lllllllllllllllllIIllIlIllIIIIII == EnumFacing.Axis.Z) {
            lllllllllllllllllIIllIlIllIIIIIl |= 0x8;
        }
        return lllllllllllllllllIIllIlIllIIIIIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = BlockRotatedPillar.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
        }
        final char lllllllllllllllllIIllIlIlIIllIIl = (Object)new int[EnumFacing.Axis.values().length];
        try {
            lllllllllllllllllIIllIlIlIIllIIl[EnumFacing.Axis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllllIIllIlIlIIllIIl[EnumFacing.Axis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllllIIllIlIlIIllIIl[EnumFacing.Axis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        return BlockRotatedPillar.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllllllllIIllIlIlIIllIIl;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllllllIIllIlIllIlIllI, final Rotation lllllllllllllllllIIllIlIllIlIIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllllllIIllIlIllIlIIll.ordinal()]) {
            case 2:
            case 4: {
                switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllllllIIllIlIllIlIllI.getValue(BlockRotatedPillar.AXIS).ordinal()]) {
                    case 1: {
                        return lllllllllllllllllIIllIlIllIlIllI.withProperty(BlockRotatedPillar.AXIS, EnumFacing.Axis.Z);
                    }
                    case 3: {
                        return lllllllllllllllllIIllIlIllIlIllI.withProperty(BlockRotatedPillar.AXIS, EnumFacing.Axis.X);
                    }
                    default: {
                        return lllllllllllllllllIIllIlIllIlIllI;
                    }
                }
                break;
            }
            default: {
                return lllllllllllllllllIIllIlIllIlIllI;
            }
        }
    }
    
    protected BlockRotatedPillar(final Material lllllllllllllllllIIllIlIllIllIll, final MapColor lllllllllllllllllIIllIlIllIlllIl) {
        super(lllllllllllllllllIIllIlIllIllIll, lllllllllllllllllIIllIlIllIlllIl);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllllllIIllIlIllIIllIl) {
        EnumFacing.Axis lllllllllllllllllIIllIlIllIIllII = EnumFacing.Axis.Y;
        final int lllllllllllllllllIIllIlIllIIlIll = lllllllllllllllllIIllIlIllIIllIl & 0xC;
        if (lllllllllllllllllIIllIlIllIIlIll == 4) {
            lllllllllllllllllIIllIlIllIIllII = EnumFacing.Axis.X;
        }
        else if (lllllllllllllllllIIllIlIllIIlIll == 8) {
            lllllllllllllllllIIllIlIllIIllII = EnumFacing.Axis.Z;
        }
        return this.getDefaultState().withProperty(BlockRotatedPillar.AXIS, lllllllllllllllllIIllIlIllIIllII);
    }
    
    protected BlockRotatedPillar(final Material lllllllllllllllllIIllIlIlllIIIll) {
        super(lllllllllllllllllIIllIlIlllIIIll, lllllllllllllllllIIllIlIlllIIIll.getMaterialMapColor());
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState lllllllllllllllllIIllIlIlIllIlll) {
        return new ItemStack(Item.getItemFromBlock(this));
    }
    
    static {
        AXIS = PropertyEnum.create("axis", EnumFacing.Axis.class);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllllllIIllIlIlIlIIIlI, final BlockPos lllllllllllllllllIIllIlIlIlIIIIl, final EnumFacing lllllllllllllllllIIllIlIlIlIlIIl, final float lllllllllllllllllIIllIlIlIIlllll, final float lllllllllllllllllIIllIlIlIIllllI, final float lllllllllllllllllIIllIlIlIlIIllI, final int lllllllllllllllllIIllIlIlIIlllII, final EntityLivingBase lllllllllllllllllIIllIlIlIIllIll) {
        return super.onBlockPlaced(lllllllllllllllllIIllIlIlIlIIIlI, lllllllllllllllllIIllIlIlIlIIIIl, lllllllllllllllllIIllIlIlIlIlIIl, lllllllllllllllllIIllIlIlIIlllll, lllllllllllllllllIIllIlIlIIllllI, lllllllllllllllllIIllIlIlIlIIllI, lllllllllllllllllIIllIlIlIIlllII, lllllllllllllllllIIllIlIlIIllIll).withProperty(BlockRotatedPillar.AXIS, lllllllllllllllllIIllIlIlIlIlIIl.getAxis());
    }
}
