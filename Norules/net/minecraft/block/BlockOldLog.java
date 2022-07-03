package net.minecraft.block;

import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import net.minecraft.block.properties.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.item.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;

public class BlockOldLog extends BlockLog
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllllIlIlIIlIIllIIlllII, final NonNullList<ItemStack> llllllllllllllIlIlIIlIIllIIllIIl) {
        llllllllllllllIlIlIIlIIllIIllIIl.add(new ItemStack(this, 1, BlockPlanks.EnumType.OAK.getMetadata()));
        llllllllllllllIlIlIIlIIllIIllIIl.add(new ItemStack(this, 1, BlockPlanks.EnumType.SPRUCE.getMetadata()));
        llllllllllllllIlIlIIlIIllIIllIIl.add(new ItemStack(this, 1, BlockPlanks.EnumType.BIRCH.getMetadata()));
        llllllllllllllIlIlIIlIIllIIllIIl.add(new ItemStack(this, 1, BlockPlanks.EnumType.JUNGLE.getMetadata()));
    }
    
    public BlockOldLog() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Y));
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockOldLog.VARIANT, BlockOldLog.LOG_AXIS });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis() {
        final int[] $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis = BlockOldLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        if ($switch_TABLE$net$minecraft$block$BlockLog$EnumAxis != null) {
            return $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        }
        final float llllllllllllllIlIlIIlIIlIllllIII = (Object)new int[EnumAxis.values().length];
        try {
            llllllllllllllIlIlIIlIIlIllllIII[EnumAxis.NONE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIlIIlIIlIllllIII[EnumAxis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIlIIlIIlIllllIII[EnumAxis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlIlIIlIIlIllllIII[EnumAxis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockOldLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis = (int[])(Object)llllllllllllllIlIlIIlIIlIllllIII;
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (com.google.common.base.Predicate<BlockPlanks.EnumType>)new Predicate<BlockPlanks.EnumType>() {
            public boolean apply(@Nullable final BlockPlanks.EnumType llllllllllllllllIlllIIIllIllllll) {
                return llllllllllllllllIlllIIIllIllllll.getMetadata() < 4;
            }
        });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType = BlockOldLog.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockPlanks$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        }
        final Exception llllllllllllllIlIlIIlIIlIllllIlI = (Object)new int[BlockPlanks.EnumType.values().length];
        try {
            llllllllllllllIlIlIIlIIlIllllIlI[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIlIlIIlIIlIllllIlI[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIlIlIIlIIlIllllIlI[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIlIlIIlIIlIllllIlI[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            llllllllllllllIlIlIIlIIlIllllIlI[BlockPlanks.EnumType.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            llllllllllllllIlIlIIlIIlIllllIlI[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockOldLog.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = (int[])(Object)llllllllllllllIlIlIIlIIlIllllIlI;
    }
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIlIlIIlIIlIlllllII) {
        return llllllllllllllIlIlIIlIIlIlllllII.getValue(BlockOldLog.VARIANT).getMetadata();
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState llllllllllllllIlIlIIlIIllIIIIIII) {
        return new ItemStack(Item.getItemFromBlock(this), 1, llllllllllllllIlIlIIlIIllIIIIIII.getValue(BlockOldLog.VARIANT).getMetadata());
    }
    
    @Override
    public MapColor getMapColor(final IBlockState llllllllllllllIlIlIIlIIllIlIIIIl, final IBlockAccess llllllllllllllIlIlIIlIIllIlIIlII, final BlockPos llllllllllllllIlIlIIlIIllIlIIIll) {
        final BlockPlanks.EnumType llllllllllllllIlIlIIlIIllIlIIIlI = llllllllllllllIlIlIIlIIllIlIIIIl.getValue(BlockOldLog.VARIANT);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[llllllllllllllIlIlIIlIIllIlIIIIl.getValue(BlockOldLog.LOG_AXIS).ordinal()]) {
            default: {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[llllllllllllllIlIlIIlIIllIlIIIlI.ordinal()]) {
                    default: {
                        return BlockPlanks.EnumType.SPRUCE.getMapColor();
                    }
                    case 2: {
                        return BlockPlanks.EnumType.DARK_OAK.getMapColor();
                    }
                    case 3: {
                        return MapColor.QUARTZ;
                    }
                    case 4: {
                        return BlockPlanks.EnumType.SPRUCE.getMapColor();
                    }
                }
                break;
            }
            case 2: {
                return llllllllllllllIlIlIIlIIllIlIIIlI.getMapColor();
            }
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIlIlIIlIIllIIlIlII) {
        IBlockState llllllllllllllIlIlIIlIIllIIlIIll = this.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.byMetadata((llllllllllllllIlIlIIlIIllIIlIlII & 0x3) % 4));
        switch (llllllllllllllIlIlIIlIIllIIlIlII & 0xC) {
            case 0: {
                llllllllllllllIlIlIIlIIllIIlIIll = llllllllllllllIlIlIIlIIllIIlIIll.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Y);
                break;
            }
            case 4: {
                llllllllllllllIlIlIIlIIllIIlIIll = llllllllllllllIlIlIIlIIllIIlIIll.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.X);
                break;
            }
            case 8: {
                llllllllllllllIlIlIIlIIllIIlIIll = llllllllllllllIlIlIIlIIllIIlIIll.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.Z);
                break;
            }
            default: {
                llllllllllllllIlIlIIlIIllIIlIIll = llllllllllllllIlIlIIlIIllIIlIIll.withProperty(BlockOldLog.LOG_AXIS, EnumAxis.NONE);
                break;
            }
        }
        return llllllllllllllIlIlIIlIIllIIlIIll;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIlIlIIlIIllIIIllII) {
        int llllllllllllllIlIlIIlIIllIIIlIll = 0;
        llllllllllllllIlIlIIlIIllIIIlIll |= llllllllllllllIlIlIIlIIllIIIllII.getValue(BlockOldLog.VARIANT).getMetadata();
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[llllllllllllllIlIlIIlIIllIIIllII.getValue(BlockOldLog.LOG_AXIS).ordinal()]) {
            case 1: {
                llllllllllllllIlIlIIlIIllIIIlIll |= 0x4;
                break;
            }
            case 3: {
                llllllllllllllIlIlIIlIIllIIIlIll |= 0x8;
                break;
            }
            case 4: {
                llllllllllllllIlIlIIlIIllIIIlIll |= 0xC;
                break;
            }
        }
        return llllllllllllllIlIlIIlIIllIIIlIll;
    }
}
