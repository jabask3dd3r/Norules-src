package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.util.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;

public class BlockNewLog extends BlockLog
{
    public static final /* synthetic */ PropertyEnum<BlockPlanks.EnumType> VARIANT;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis;
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIllIIlIIIIlIIlIIIII) {
        return lllllllllllllIllIIlIIIIlIIlIIIII.getValue(BlockNewLog.VARIANT).getMetadata() - 4;
    }
    
    public BlockNewLog() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockNewLog.LOG_AXIS, EnumAxis.Y));
    }
    
    @Override
    public MapColor getMapColor(final IBlockState lllllllllllllIllIIlIIIIlIlIIllll, final IBlockAccess lllllllllllllIllIIlIIIIlIlIIlllI, final BlockPos lllllllllllllIllIIlIIIIlIlIIllIl) {
        final BlockPlanks.EnumType lllllllllllllIllIIlIIIIlIlIIllII = lllllllllllllIllIIlIIIIlIlIIllll.getValue(BlockNewLog.VARIANT);
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[lllllllllllllIllIIlIIIIlIlIIllll.getValue(BlockNewLog.LOG_AXIS).ordinal()]) {
            default: {
                switch ($SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType()[lllllllllllllIllIIlIIIIlIlIIllII.ordinal()]) {
                    default: {
                        return MapColor.STONE;
                    }
                    case 6: {
                        return BlockPlanks.EnumType.DARK_OAK.getMapColor();
                    }
                }
                break;
            }
            case 2: {
                return lllllllllllllIllIIlIIIIlIlIIllII.getMapColor();
            }
        }
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIllIIlIIIIlIlIIIllI, final NonNullList<ItemStack> lllllllllllllIllIIlIIIIlIlIIIlIl) {
        lllllllllllllIllIIlIIIIlIlIIIlIl.add(new ItemStack(this, 1, BlockPlanks.EnumType.ACACIA.getMetadata() - 4));
        lllllllllllllIllIIlIIIIlIlIIIlIl.add(new ItemStack(this, 1, BlockPlanks.EnumType.DARK_OAK.getMetadata() - 4));
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", BlockPlanks.EnumType.class, (com.google.common.base.Predicate<BlockPlanks.EnumType>)new Predicate<BlockPlanks.EnumType>() {
            public boolean apply(@Nullable final BlockPlanks.EnumType lllllllllllllIIIIIlIIlIllIlIlIll) {
                return lllllllllllllIIIIIlIIlIllIlIlIll.getMetadata() >= 4;
            }
        });
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType = BlockNewLog.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockPlanks$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockPlanks$EnumType;
        }
        final int lllllllllllllIllIIlIIIIlIIIIlllI = (Object)new int[BlockPlanks.EnumType.values().length];
        try {
            lllllllllllllIllIIlIIIIlIIIIlllI[BlockPlanks.EnumType.ACACIA.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllIIlIIIIlIIIIlllI[BlockPlanks.EnumType.BIRCH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllIIlIIIIlIIIIlllI[BlockPlanks.EnumType.DARK_OAK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllIIlIIIIlIIIIlllI[BlockPlanks.EnumType.JUNGLE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIllIIlIIIIlIIIIlllI[BlockPlanks.EnumType.OAK.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIllIIlIIIIlIIIIlllI[BlockPlanks.EnumType.SPRUCE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockNewLog.$SWITCH_TABLE$net$minecraft$block$BlockPlanks$EnumType = (int[])(Object)lllllllllllllIllIIlIIIIlIIIIlllI;
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState lllllllllllllIllIIlIIIIlIIlIIlll) {
        return new ItemStack(Item.getItemFromBlock(this), 1, lllllllllllllIllIIlIIIIlIIlIIlll.getValue(BlockNewLog.VARIANT).getMetadata() - 4);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockNewLog.VARIANT, BlockNewLog.LOG_AXIS });
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllIIlIIIIlIIlllllI) {
        IBlockState lllllllllllllIllIIlIIIIlIIllllIl = this.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.byMetadata((lllllllllllllIllIIlIIIIlIIlllllI & 0x3) + 4));
        switch (lllllllllllllIllIIlIIIIlIIlllllI & 0xC) {
            case 0: {
                lllllllllllllIllIIlIIIIlIIllllIl = lllllllllllllIllIIlIIIIlIIllllIl.withProperty(BlockNewLog.LOG_AXIS, EnumAxis.Y);
                break;
            }
            case 4: {
                lllllllllllllIllIIlIIIIlIIllllIl = lllllllllllllIllIIlIIIIlIIllllIl.withProperty(BlockNewLog.LOG_AXIS, EnumAxis.X);
                break;
            }
            case 8: {
                lllllllllllllIllIIlIIIIlIIllllIl = lllllllllllllIllIIlIIIIlIIllllIl.withProperty(BlockNewLog.LOG_AXIS, EnumAxis.Z);
                break;
            }
            default: {
                lllllllllllllIllIIlIIIIlIIllllIl = lllllllllllllIllIIlIIIIlIIllllIl.withProperty(BlockNewLog.LOG_AXIS, EnumAxis.NONE);
                break;
            }
        }
        return lllllllllllllIllIIlIIIIlIIllllIl;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis() {
        final int[] $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis = BlockNewLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        if ($switch_TABLE$net$minecraft$block$BlockLog$EnumAxis != null) {
            return $switch_TABLE$net$minecraft$block$BlockLog$EnumAxis;
        }
        final short lllllllllllllIllIIlIIIIIlllllIlI = (Object)new int[EnumAxis.values().length];
        try {
            lllllllllllllIllIIlIIIIIlllllIlI[EnumAxis.NONE.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllIIlIIIIIlllllIlI[EnumAxis.X.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllIIlIIIIIlllllIlI[EnumAxis.Y.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllIIlIIIIIlllllIlI[EnumAxis.Z.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockNewLog.$SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis = (int[])(Object)lllllllllllllIllIIlIIIIIlllllIlI;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllIIlIIIIlIIllIllI) {
        int lllllllllllllIllIIlIIIIlIIllIlIl = 0;
        lllllllllllllIllIIlIIIIlIIllIlIl |= lllllllllllllIllIIlIIIIlIIllIllI.getValue(BlockNewLog.VARIANT).getMetadata() - 4;
        switch ($SWITCH_TABLE$net$minecraft$block$BlockLog$EnumAxis()[lllllllllllllIllIIlIIIIlIIllIllI.getValue(BlockNewLog.LOG_AXIS).ordinal()]) {
            case 1: {
                lllllllllllllIllIIlIIIIlIIllIlIl |= 0x4;
                break;
            }
            case 3: {
                lllllllllllllIllIIlIIIIlIIllIlIl |= 0x8;
                break;
            }
            case 4: {
                lllllllllllllIllIIlIIIIlIIllIlIl |= 0xC;
                break;
            }
        }
        return lllllllllllllIllIIlIIIIlIIllIlIl;
    }
}
