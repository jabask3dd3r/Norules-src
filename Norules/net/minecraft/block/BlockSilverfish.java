package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import java.util.*;
import net.minecraft.util.*;

public class BlockSilverfish extends Block
{
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIllllIIllIllIIIIllI) {
        return this.getDefaultState().withProperty(BlockSilverfish.VARIANT, EnumType.byMetadata(lllllllllllllIllllIIllIllIIIIllI));
    }
    
    @Override
    public void dropBlockAsItemWithChance(final World lllllllllllllIllllIIllIllIlIIlII, final BlockPos lllllllllllllIllllIIllIllIlIIIll, final IBlockState lllllllllllllIllllIIllIllIlIlIII, final float lllllllllllllIllllIIllIllIlIIlll, final int lllllllllllllIllllIIllIllIlIIllI) {
        if (!lllllllllllllIllllIIllIllIlIIlII.isRemote && lllllllllllllIllllIIllIllIlIIlII.getGameRules().getBoolean("doTileDrops")) {
            final EntitySilverfish lllllllllllllIllllIIllIllIlIIlIl = new EntitySilverfish(lllllllllllllIllllIIllIllIlIIlII);
            lllllllllllllIllllIIllIllIlIIlIl.setLocationAndAngles(lllllllllllllIllllIIllIllIlIIIll.getX() + 0.5, lllllllllllllIllllIIllIllIlIIIll.getY(), lllllllllllllIllllIIllIllIlIIIll.getZ() + 0.5, 0.0f, 0.0f);
            lllllllllllllIllllIIllIllIlIIlII.spawnEntityInWorld(lllllllllllllIllllIIllIllIlIIlIl);
            lllllllllllllIllllIIllIllIlIIlIl.spawnExplosionParticle();
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType() {
        final int[] $switch_TABLE$net$minecraft$block$BlockSilverfish$EnumType = BlockSilverfish.$SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType;
        if ($switch_TABLE$net$minecraft$block$BlockSilverfish$EnumType != null) {
            return $switch_TABLE$net$minecraft$block$BlockSilverfish$EnumType;
        }
        final float lllllllllllllIllllIIllIlIllllIll = (Object)new int[EnumType.values().length];
        try {
            lllllllllllllIllllIIllIlIllllIll[EnumType.CHISELED_STONEBRICK.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllllIIllIlIllllIll[EnumType.COBBLESTONE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllllIIllIlIllllIll[EnumType.CRACKED_STONEBRICK.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllllIIllIlIllllIll[EnumType.MOSSY_STONEBRICK.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIllllIIllIlIllllIll[EnumType.STONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIllllIIllIlIllllIll[EnumType.STONEBRICK.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return BlockSilverfish.$SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType = (int[])(Object)lllllllllllllIllllIIllIlIllllIll;
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIllllIIllIllIIIIIII) {
        return lllllllllllllIllllIIllIllIIIIIII.getValue(BlockSilverfish.VARIANT).getMetadata();
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIllllIIllIllIIlIIlI, final NonNullList<ItemStack> lllllllllllllIllllIIllIllIIlIIIl) {
        final byte lllllllllllllIllllIIllIllIIIlIlI;
        final byte lllllllllllllIllllIIllIllIIIlIll = (byte)((EnumType[])(Object)(lllllllllllllIllllIIllIllIIIlIlI = (byte)(Object)EnumType.values())).length;
        for (boolean lllllllllllllIllllIIllIllIIIllII = false; (lllllllllllllIllllIIllIllIIIllII ? 1 : 0) < lllllllllllllIllllIIllIllIIIlIll; ++lllllllllllllIllllIIllIllIIIllII) {
            final EnumType lllllllllllllIllllIIllIllIIlIIII = lllllllllllllIllllIIllIllIIIlIlI[lllllllllllllIllllIIllIllIIIllII];
            lllllllllllllIllllIIllIllIIlIIIl.add(new ItemStack(this, 1, lllllllllllllIllllIIllIllIIlIIII.getMetadata()));
        }
    }
    
    static {
        VARIANT = PropertyEnum.create("variant", EnumType.class);
    }
    
    public BlockSilverfish() {
        super(Material.CLAY);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockSilverfish.VARIANT, EnumType.STONE));
        this.setHardness(0.0f);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIllllIIllIllIIllllI, final BlockPos lllllllllllllIllllIIllIllIIlllIl, final IBlockState lllllllllllllIllllIIllIllIIllIlI) {
        return new ItemStack(this, 1, lllllllllllllIllllIIllIllIIllIlI.getBlock().getMetaFromState(lllllllllllllIllllIIllIllIIllIlI));
    }
    
    @Override
    protected ItemStack getSilkTouchDrop(final IBlockState lllllllllllllIllllIIllIllIlIllll) {
        switch ($SWITCH_TABLE$net$minecraft$block$BlockSilverfish$EnumType()[lllllllllllllIllllIIllIllIlIllll.getValue(BlockSilverfish.VARIANT).ordinal()]) {
            case 2: {
                return new ItemStack(Blocks.COBBLESTONE);
            }
            case 3: {
                return new ItemStack(Blocks.STONEBRICK);
            }
            case 4: {
                return new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.EnumType.MOSSY.getMetadata());
            }
            case 5: {
                return new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.EnumType.CRACKED.getMetadata());
            }
            case 6: {
                return new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.EnumType.CHISELED.getMetadata());
            }
            default: {
                return new ItemStack(Blocks.STONE);
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockSilverfish.VARIANT });
    }
    
    @Override
    public int quantityDropped(final Random lllllllllllllIllllIIllIllIlllIIl) {
        return 0;
    }
    
    public static boolean canContainSilverfish(final IBlockState lllllllllllllIllllIIllIllIllIlII) {
        final Block lllllllllllllIllllIIllIllIllIlIl = lllllllllllllIllllIIllIllIllIlII.getBlock();
        return lllllllllllllIllllIIllIllIllIlII == Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE) || lllllllllllllIllllIIllIllIllIlIl == Blocks.COBBLESTONE || lllllllllllllIllllIIllIllIllIlIl == Blocks.STONEBRICK;
    }
    
    public enum EnumType implements IStringSerializable
    {
        CHISELED_STONEBRICK(5, 5, "chiseled_brick", "chiseledbrick") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CHISELED);
            }
        };
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ String name;
        
        CRACKED_STONEBRICK(4, 4, "cracked_brick", "crackedbrick") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.CRACKED);
            }
        }, 
        STONEBRICK(2, 2, "stone_brick", "brick") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.DEFAULT);
            }
        }, 
        MOSSY_STONEBRICK(3, 3, "mossy_brick", "mossybrick") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONEBRICK.getDefaultState().withProperty(BlockStoneBrick.VARIANT, BlockStoneBrick.EnumType.MOSSY);
            }
        }, 
        COBBLESTONE(1, 1, "cobblestone", "cobble") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.COBBLESTONE.getDefaultState();
            }
        }, 
        STONE(0, 0, "stone") {
            @Override
            public IBlockState getModelBlock() {
                return Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.STONE);
            }
        };
        
        private final /* synthetic */ int meta;
        private final /* synthetic */ String unlocalizedName;
        
        public static EnumType forModelBlock(final IBlockState llllllllllllllIlIIlIllIlllllIIII) {
            final boolean llllllllllllllIlIIlIllIllllIllII;
            final short llllllllllllllIlIIlIllIllllIllIl = (short)((EnumType[])(Object)(llllllllllllllIlIIlIllIllllIllII = (boolean)(Object)values())).length;
            for (long llllllllllllllIlIIlIllIllllIlllI = 0; llllllllllllllIlIIlIllIllllIlllI < llllllllllllllIlIIlIllIllllIllIl; ++llllllllllllllIlIIlIllIllllIlllI) {
                final EnumType llllllllllllllIlIIlIllIlllllIIIl = llllllllllllllIlIIlIllIllllIllII[llllllllllllllIlIIlIllIllllIlllI];
                if (llllllllllllllIlIIlIllIlllllIIII == llllllllllllllIlIIlIllIlllllIIIl.getModelBlock()) {
                    return llllllllllllllIlIIlIllIlllllIIIl;
                }
            }
            return EnumType.STONE;
        }
        
        public static EnumType byMetadata(int llllllllllllllIlIIlIllIllllllllI) {
            if (llllllllllllllIlIIlIllIllllllllI < 0 || llllllllllllllIlIIlIllIllllllllI >= EnumType.META_LOOKUP.length) {
                llllllllllllllIlIIlIllIllllllllI = 0;
            }
            return EnumType.META_LOOKUP[llllllllllllllIlIIlIllIllllllllI];
        }
        
        private EnumType(final String llllllllllllllIlIIlIlllIIIIllIlI, final int llllllllllllllIlIIlIlllIIIIllIIl, final int llllllllllllllIlIIlIlllIIIIlllIl, final String llllllllllllllIlIIlIlllIIIIlllII) {
            this(llllllllllllllIlIIlIlllIIIIllIlI, llllllllllllllIlIIlIlllIIIIllIIl, llllllllllllllIlIIlIlllIIIIlllIl, llllllllllllllIlIIlIlllIIIIlllII, llllllllllllllIlIIlIlllIIIIlllII);
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public abstract IBlockState getModelBlock();
        
        public int getMetadata() {
            return this.meta;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        private EnumType(final String llllllllllllllIlIIlIlllIIIIIlIll, final int llllllllllllllIlIIlIlllIIIIIlIlI, final int llllllllllllllIlIIlIlllIIIIIllll, final String llllllllllllllIlIIlIlllIIIIIlIII, final String llllllllllllllIlIIlIlllIIIIIllIl) {
            this.meta = llllllllllllllIlIIlIlllIIIIIllll;
            this.name = llllllllllllllIlIIlIlllIIIIIlIII;
            this.unlocalizedName = llllllllllllllIlIIlIlllIIIIIllIl;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final double llllllllllllllIlIIlIlllIIIlIIlII;
            final short llllllllllllllIlIIlIlllIIIlIIlIl = (short)((EnumType[])(Object)(llllllllllllllIlIIlIlllIIIlIIlII = (double)(Object)values())).length;
            for (boolean llllllllllllllIlIIlIlllIIIlIIllI = false; (llllllllllllllIlIIlIlllIIIlIIllI ? 1 : 0) < llllllllllllllIlIIlIlllIIIlIIlIl; ++llllllllllllllIlIIlIlllIIIlIIllI) {
                final EnumType llllllllllllllIlIIlIlllIIIlIlIII = llllllllllllllIlIIlIlllIIIlIIlII[llllllllllllllIlIIlIlllIIIlIIllI];
                EnumType.META_LOOKUP[llllllllllllllIlIIlIlllIIIlIlIII.getMetadata()] = llllllllllllllIlIIlIlllIIIlIlIII;
            }
        }
    }
}
