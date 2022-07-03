package net.minecraft.block;

import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;

public abstract class BlockLog extends BlockRotatedPillar
{
    public static final /* synthetic */ PropertyEnum<EnumAxis> LOG_AXIS;
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis() {
        final int[] $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis = BlockLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        if ($switch_TABLE$net$minecraft$block$BlockLog$EnumAxis != null) {
            return $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        }
        final byte llllllllllllllllIllllllIIIIllIIl = (Object)new int[EnumAxis.values().length];
        try {
            llllllllllllllllIllllllIIIIllIIl[EnumAxis.NONE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIllllllIIIIllIIl[EnumAxis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIllllllIIIIllIIl[EnumAxis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIllllllIIIIllIIl[EnumAxis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis = (int[])(Object)llllllllllllllllIllllllIIIIllIIl;
    }
    
    static {
        LOG_AXIS = PropertyEnum.create("axis", EnumAxis.class);
    }
    
    @Override
    public void breakBlock(final World llllllllllllllllIllllllIIIllIlll, final BlockPos llllllllllllllllIllllllIIIllllIl, final IBlockState llllllllllllllllIllllllIIIllllII) {
        final int llllllllllllllllIllllllIIIlllIll = 4;
        final int llllllllllllllllIllllllIIIlllIlI = 5;
        if (llllllllllllllllIllllllIIIllIlll.isAreaLoaded(llllllllllllllllIllllllIIIllllIl.add(-5, -5, -5), llllllllllllllllIllllllIIIllllIl.add(5, 5, 5))) {
            for (final BlockPos llllllllllllllllIllllllIIIlllIIl : BlockPos.getAllInBox(llllllllllllllllIllllllIIIllllIl.add(-4, -4, -4), llllllllllllllllIllllllIIIllllIl.add(4, 4, 4))) {
                final IBlockState llllllllllllllllIllllllIIIlllIII = llllllllllllllllIllllllIIIllIlll.getBlockState(llllllllllllllllIllllllIIIlllIIl);
                if (llllllllllllllllIllllllIIIlllIII.getMaterial() == Material.LEAVES && !llllllllllllllllIllllllIIIlllIII.getValue((IProperty<Boolean>)BlockLeaves.CHECK_DECAY)) {
                    llllllllllllllllIllllllIIIllIlll.setBlockState(llllllllllllllllIllllllIIIlllIIl, llllllllllllllllIllllllIIIlllIII.withProperty((IProperty<Comparable>)BlockLeaves.CHECK_DECAY, true), 4);
                }
            }
        }
    }
    
    public BlockLog() {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        this.setHardness(2.0f);
        this.setSoundType(SoundType.WOOD);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockLog.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final float llllllllllllllllIllllllIIIIlIlll = (Object)new int[Rotation.values().length];
        try {
            llllllllllllllllIllllllIIIIlIlll[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllllIllllllIIIIlIlll[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllllIllllllIIIIlIlll[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllllIllllllIIIIlIlll[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockLog.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)llllllllllllllllIllllllIIIIlIlll;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllllIllllllIIIIlllII, final Rotation llllllllllllllllIllllllIIIIllIll) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[llllllllllllllllIllllllIIIIllIll.ordinal()]) {
            case 2:
            case 4: {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[llllllllllllllllIllllllIIIIlllII.getValue(BlockLog.LOG_AXIS).ordinal()]) {
                    case 1: {
                        return llllllllllllllllIllllllIIIIlllII.withProperty(BlockLog.LOG_AXIS, EnumAxis.Z);
                    }
                    case 3: {
                        return llllllllllllllllIllllllIIIIlllII.withProperty(BlockLog.LOG_AXIS, EnumAxis.X);
                    }
                    default: {
                        return llllllllllllllllIllllllIIIIlllII;
                    }
                }
                break;
            }
            default: {
                return llllllllllllllllIllllllIIIIlllII;
            }
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllllIllllllIIIlIllII, final BlockPos llllllllllllllllIllllllIIIlIlIll, final EnumFacing llllllllllllllllIllllllIIIlIIIll, final float llllllllllllllllIllllllIIIlIlIIl, final float llllllllllllllllIllllllIIIlIlIII, final float llllllllllllllllIllllllIIIlIIlll, final int llllllllllllllllIllllllIIIlIIIlI, final EntityLivingBase llllllllllllllllIllllllIIIlIIlIl) {
        return this.getStateFromMeta(llllllllllllllllIllllllIIIlIIIlI).withProperty(BlockLog.LOG_AXIS, EnumAxis.fromFacingAxis(llllllllllllllllIllllllIIIlIIIll.getAxis()));
    }
    
    public enum EnumAxis implements IStringSerializable
    {
        Z("Z", 2, "z");
        
        private final /* synthetic */ String name;
        
        X("X", 0, "x"), 
        Y("Y", 1, "y"), 
        NONE("NONE", 3, "none");
        
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
        
        private EnumAxis(final String lllllllllllllIllllIIlIIllIlIlIIl, final int lllllllllllllIllllIIlIIllIlIlIII, final String lllllllllllllIllllIIlIIllIlIlIll) {
            this.name = lllllllllllllIllllIIlIIllIlIlIll;
        }
        
        public static EnumAxis fromFacingAxis(final EnumFacing.Axis lllllllllllllIllllIIlIIllIlIIIIl) {
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[lllllllllllllIllllIIlIIllIlIIIIl.ordinal()]) {
                case 1: {
                    return EnumAxis.X;
                }
                case 2: {
                    return EnumAxis.Y;
                }
                case 3: {
                    return EnumAxis.Z;
                }
                default: {
                    return EnumAxis.NONE;
                }
            }
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing$Axis = EnumAxis.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
            if ($switch_TABLE$net$minecraft$util$EnumFacing$Axis != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing$Axis;
            }
            final float lllllllllllllIllllIIlIIllIIlIlII = (Object)new int[EnumFacing.Axis.values().length];
            try {
                lllllllllllllIllllIIlIIllIIlIlII[EnumFacing.Axis.X.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIllllIIlIIllIIlIlII[EnumFacing.Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIllllIIlIIllIIlIlII[EnumFacing.Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            return EnumAxis.$SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = (int[])(Object)lllllllllllllIllllIIlIIllIIlIlII;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
