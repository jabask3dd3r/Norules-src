package net.minecraft.block;

import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import javax.annotation.*;
import net.minecraft.item.*;
import net.minecraft.stats.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.creativetab.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockTallGrass extends BlockBush implements IGrowable
{
    public static final /* synthetic */ PropertyEnum<EnumType> TYPE;
    protected static final /* synthetic */ AxisAlignedBB TALL_GRASS_AABB;
    
    @Override
    public Item getItemDropped(final IBlockState llllllllllllllIllIlllIIllllIIIIl, final Random llllllllllllllIllIlllIIllllIIIII, final int llllllllllllllIllIlllIIlllIlllll) {
        return (llllllllllllllIllIlllIIllllIIIII.nextInt(8) == 0) ? Items.WHEAT_SEEDS : Items.field_190931_a;
    }
    
    static {
        TYPE = PropertyEnum.create("type", EnumType.class);
        TALL_GRASS_AABB = new AxisAlignedBB(0.09999999403953552, 0.0, 0.09999999403953552, 0.8999999761581421, 0.800000011920929, 0.8999999761581421);
    }
    
    @Override
    public boolean canGrow(final World llllllllllllllIllIlllIIllIlIllIl, final BlockPos llllllllllllllIllIlllIIllIlIllII, final IBlockState llllllllllllllIllIlllIIllIlIlIIl, final boolean llllllllllllllIllIlllIIllIlIlIlI) {
        return llllllllllllllIllIlllIIllIlIlIIl.getValue(BlockTallGrass.TYPE) != EnumType.DEAD_BUSH;
    }
    
    @Override
    public void harvestBlock(final World llllllllllllllIllIlllIIlllIIIlll, final EntityPlayer llllllllllllllIllIlllIIlllIIllIl, final BlockPos llllllllllllllIllIlllIIlllIIIlIl, final IBlockState llllllllllllllIllIlllIIlllIIIlII, @Nullable final TileEntity llllllllllllllIllIlllIIlllIIIIll, final ItemStack llllllllllllllIllIlllIIlllIIlIIl) {
        if (!llllllllllllllIllIlllIIlllIIIlll.isRemote && llllllllllllllIllIlllIIlllIIlIIl.getItem() == Items.SHEARS) {
            llllllllllllllIllIlllIIlllIIllIl.addStat(StatList.getBlockStats(this));
            Block.spawnAsEntity(llllllllllllllIllIlllIIlllIIIlll, llllllllllllllIllIlllIIlllIIIlIl, new ItemStack(Blocks.TALLGRASS, 1, llllllllllllllIllIlllIIlllIIIlII.getValue(BlockTallGrass.TYPE).getMeta()));
        }
        else {
            super.harvestBlock(llllllllllllllIllIlllIIlllIIIlll, llllllllllllllIllIlllIIlllIIllIl, llllllllllllllIllIlllIIlllIIIlIl, llllllllllllllIllIlllIIlllIIIlII, llllllllllllllIllIlllIIlllIIIIll, llllllllllllllIllIlllIIlllIIlIIl);
        }
    }
    
    @Override
    public int quantityDroppedWithBonus(final int llllllllllllllIllIlllIIlllIllIlI, final Random llllllllllllllIllIlllIIlllIlIlll) {
        return 1 + llllllllllllllIllIlllIIlllIlIlll.nextInt(llllllllllllllIllIlllIIlllIllIlI * 2 + 1);
    }
    
    @Override
    public boolean canBlockStay(final World llllllllllllllIllIlllIIllllIllII, final BlockPos llllllllllllllIllIlllIIllllIlIll, final IBlockState llllllllllllllIllIlllIIllllIlIlI) {
        return this.canSustainBush(llllllllllllllIllIlllIIllllIllII.getBlockState(llllllllllllllIllIlllIIllllIlIll.down()));
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState llllllllllllllIllIlllIIlllllIIll, final IBlockAccess llllllllllllllIllIlllIIlllllIIlI, final BlockPos llllllllllllllIllIlllIIlllllIIIl) {
        return BlockTallGrass.TALL_GRASS_AABB;
    }
    
    @Override
    public boolean isReplaceable(final IBlockAccess llllllllllllllIllIlllIIllllIIlIl, final BlockPos llllllllllllllIllIlllIIllllIIlII) {
        return true;
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllllIllIlllIIllIllIlIl, final NonNullList<ItemStack> llllllllllllllIllIlllIIllIllIlII) {
        for (int llllllllllllllIllIlllIIllIllIIll = 1; llllllllllllllIllIlllIIllIllIIll < 3; ++llllllllllllllIllIlllIIllIllIIll) {
            llllllllllllllIllIlllIIllIllIlII.add(new ItemStack(this, 1, llllllllllllllIllIlllIIllIllIIll));
        }
    }
    
    @Override
    public boolean canUseBonemeal(final World llllllllllllllIllIlllIIllIlIIlll, final Random llllllllllllllIllIlllIIllIlIIllI, final BlockPos llllllllllllllIllIlllIIllIlIIlIl, final IBlockState llllllllllllllIllIlllIIllIlIIlII) {
        return true;
    }
    
    @Override
    public void grow(final World llllllllllllllIllIlllIIllIIllIIl, final Random llllllllllllllIllIlllIIllIIlllIl, final BlockPos llllllllllllllIllIlllIIllIIlllII, final IBlockState llllllllllllllIllIlllIIllIIllIll) {
        BlockDoublePlant.EnumPlantType llllllllllllllIllIlllIIllIIllIlI = BlockDoublePlant.EnumPlantType.GRASS;
        if (llllllllllllllIllIlllIIllIIllIll.getValue(BlockTallGrass.TYPE) == EnumType.FERN) {
            llllllllllllllIllIlllIIllIIllIlI = BlockDoublePlant.EnumPlantType.FERN;
        }
        if (Blocks.DOUBLE_PLANT.canPlaceBlockAt(llllllllllllllIllIlllIIllIIllIIl, llllllllllllllIllIlllIIllIIlllII)) {
            Blocks.DOUBLE_PLANT.placeAt(llllllllllllllIllIlllIIllIIllIIl, llllllllllllllIllIlllIIllIIlllII, llllllllllllllIllIlllIIllIIllIlI, 2);
        }
    }
    
    @Override
    public EnumOffsetType getOffsetType() {
        return EnumOffsetType.XYZ;
    }
    
    protected BlockTallGrass() {
        super(Material.VINE);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BlockTallGrass.TYPE, EnumType.DEAD_BUSH));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIllIlllIIllIIlIIII) {
        return this.getDefaultState().withProperty(BlockTallGrass.TYPE, EnumType.byMetadata(llllllllllllllIllIlllIIllIIlIIII));
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIllIlllIIllIIIllIl) {
        return llllllllllllllIllIlllIIllIIIllIl.getValue(BlockTallGrass.TYPE).getMeta();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockTallGrass.TYPE });
    }
    
    @Override
    public ItemStack getItem(final World llllllllllllllIllIlllIIllIlllllI, final BlockPos llllllllllllllIllIlllIIllIllllIl, final IBlockState llllllllllllllIllIlllIIllIlllIlI) {
        return new ItemStack(this, 1, llllllllllllllIllIlllIIllIlllIlI.getBlock().getMetaFromState(llllllllllllllIllIlllIIllIlllIlI));
    }
    
    public enum EnumType implements IStringSerializable
    {
        private final /* synthetic */ int meta;
        
        GRASS("GRASS", 1, 1, "tall_grass");
        
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ String name;
        
        FERN("FERN", 2, 2, "fern"), 
        DEAD_BUSH("DEAD_BUSH", 0, 0, "dead_bush");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public int getMeta() {
            return this.meta;
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final short lIIIlIIIIlIIlII;
            final char lIIIlIIIIlIIlIl = (char)((EnumType[])(Object)(lIIIlIIIIlIIlII = (short)(Object)values())).length;
            for (String lIIIlIIIIlIIllI = (String)0; lIIIlIIIIlIIllI < lIIIlIIIIlIIlIl; ++lIIIlIIIIlIIllI) {
                final EnumType lIIIlIIIIlIlIII = lIIIlIIIIlIIlII[lIIIlIIIIlIIllI];
                EnumType.META_LOOKUP[lIIIlIIIIlIlIII.getMeta()] = lIIIlIIIIlIlIII;
            }
        }
        
        @Override
        public String toString() {
            return this.name;
        }
        
        private EnumType(final String lIIIlIIIIIllIlI, final int lIIIlIIIIIllIIl, final int lIIIlIIIIIlllIl, final String lIIIlIIIIIlIlll) {
            this.meta = lIIIlIIIIIlllIl;
            this.name = lIIIlIIIIIlIlll;
        }
        
        public static EnumType byMetadata(int lIIIlIIIIIIlllI) {
            if (lIIIlIIIIIIlllI < 0 || lIIIlIIIIIIlllI >= EnumType.META_LOOKUP.length) {
                lIIIlIIIIIIlllI = 0;
            }
            return EnumType.META_LOOKUP[lIIIlIIIIIIlllI];
        }
    }
}
