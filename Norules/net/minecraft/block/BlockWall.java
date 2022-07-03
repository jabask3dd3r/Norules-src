package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.creativetab.*;
import net.minecraft.item.*;
import net.minecraft.init.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.util.*;

public class BlockWall extends Block
{
    public static final /* synthetic */ PropertyBool SOUTH;
    protected static final /* synthetic */ AxisAlignedBB[] CLIP_AABB_BY_INDEX;
    protected static final /* synthetic */ AxisAlignedBB[] AABB_BY_INDEX;
    public static final /* synthetic */ PropertyBool UP;
    public static final /* synthetic */ PropertyEnum<EnumType> VARIANT;
    public static final /* synthetic */ PropertyBool NORTH;
    public static final /* synthetic */ PropertyBool WEST;
    public static final /* synthetic */ PropertyBool EAST;
    
    @Override
    public int damageDropped(final IBlockState llllllllllllllIIlllllIIIllIIIlIl) {
        return llllllllllllllIIlllllIIIllIIIlIl.getValue(BlockWall.VARIANT).getMetadata();
    }
    
    @Override
    public boolean isPassable(final IBlockAccess llllllllllllllIIlllllIIIllllIlIl, final BlockPos llllllllllllllIIlllllIIIllllIlII) {
        return false;
    }
    
    private boolean canConnectTo(final IBlockAccess llllllllllllllIIlllllIIIlllIIIlI, final BlockPos llllllllllllllIIlllllIIIlllIIIIl, final EnumFacing llllllllllllllIIlllllIIIlllIIIII) {
        final IBlockState llllllllllllllIIlllllIIIlllIIllI = llllllllllllllIIlllllIIIlllIIIlI.getBlockState(llllllllllllllIIlllllIIIlllIIIIl);
        final Block llllllllllllllIIlllllIIIlllIIlIl = llllllllllllllIIlllllIIIlllIIllI.getBlock();
        final BlockFaceShape llllllllllllllIIlllllIIIlllIIlII = llllllllllllllIIlllllIIIlllIIllI.func_193401_d(llllllllllllllIIlllllIIIlllIIIlI, llllllllllllllIIlllllIIIlllIIIIl, llllllllllllllIIlllllIIIlllIIIII);
        final boolean llllllllllllllIIlllllIIIlllIIIll = llllllllllllllIIlllllIIIlllIIlII == BlockFaceShape.MIDDLE_POLE_THICK || (llllllllllllllIIlllllIIIlllIIlII == BlockFaceShape.MIDDLE_POLE && llllllllllllllIIlllllIIIlllIIlIl instanceof BlockFenceGate);
        return (!func_194143_e(llllllllllllllIIlllllIIIlllIIlIl) && llllllllllllllIIlllllIIIlllIIlII == BlockFaceShape.SOLID) || llllllllllllllIIlllllIIIlllIIIll;
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIlllllIIIlIlIllII) {
        return llllllllllllllIIlllllIIIlIlIllII.getValue(BlockWall.VARIANT).getMetadata();
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState llllllllllllllIIlllllIIIlIlllllI, final IBlockAccess llllllllllllllIIlllllIIIlIlllIII, final BlockPos llllllllllllllIIlllllIIIlIllIlll, final EnumFacing llllllllllllllIIlllllIIIlIllIllI) {
        return llllllllllllllIIlllllIIIlIllIllI != EnumFacing.DOWN || super.shouldSideBeRendered(llllllllllllllIIlllllIIIlIlllllI, llllllllllllllIIlllllIIIlIlllIII, llllllllllllllIIlllllIIIlIllIlll, llllllllllllllIIlllllIIIlIllIllI);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs llllllllllllllIIlllllIIIllIlIIIl, final NonNullList<ItemStack> llllllllllllllIIlllllIIIllIlIIII) {
        final double llllllllllllllIIlllllIIIllIIlIIl;
        final Exception llllllllllllllIIlllllIIIllIIlIlI = (Exception)((EnumType[])(Object)(llllllllllllllIIlllllIIIllIIlIIl = (double)(Object)EnumType.values())).length;
        for (long llllllllllllllIIlllllIIIllIIlIll = 0; llllllllllllllIIlllllIIIllIIlIll < llllllllllllllIIlllllIIIllIIlIlI; ++llllllllllllllIIlllllIIIllIIlIll) {
            final EnumType llllllllllllllIIlllllIIIllIIllll = llllllllllllllIIlllllIIIllIIlIIl[llllllllllllllIIlllllIIIllIIlIll];
            llllllllllllllIIlllllIIIllIlIIII.add(new ItemStack(this, 1, llllllllllllllIIlllllIIIllIIllll.getMetadata()));
        }
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess llllllllllllllIIlllllIIIlIIIlIll, final IBlockState llllllllllllllIIlllllIIIlIIIlIlI, final BlockPos llllllllllllllIIlllllIIIlIIIlIIl, final EnumFacing llllllllllllllIIlllllIIIlIIIlIII) {
        return (llllllllllllllIIlllllIIIlIIIlIII != EnumFacing.UP && llllllllllllllIIlllllIIIlIIIlIII != EnumFacing.DOWN) ? BlockFaceShape.MIDDLE_POLE_THICK : BlockFaceShape.CENTER_BIG;
    }
    
    protected static boolean func_194143_e(final Block llllllllllllllIIlllllIIIllIllIIl) {
        return Block.func_193382_c(llllllllllllllIIlllllIIIllIllIIl) || llllllllllllllIIlllllIIIllIllIIl == Blocks.BARRIER || llllllllllllllIIlllllIIIllIllIIl == Blocks.MELON_BLOCK || llllllllllllllIIlllllIIIllIllIIl == Blocks.PUMPKIN || llllllllllllllIIlllllIIIllIllIIl == Blocks.LIT_PUMPKIN;
    }
    
    private static int getAABBIndex(final IBlockState llllllllllllllIIlllllIIIllllllIl) {
        int llllllllllllllIIlllllIIIlllllllI = 0;
        if (llllllllllllllIIlllllIIIllllllIl.getValue((IProperty<Boolean>)BlockWall.NORTH)) {
            llllllllllllllIIlllllIIIlllllllI |= 1 << EnumFacing.NORTH.getHorizontalIndex();
        }
        if (llllllllllllllIIlllllIIIllllllIl.getValue((IProperty<Boolean>)BlockWall.EAST)) {
            llllllllllllllIIlllllIIIlllllllI |= 1 << EnumFacing.EAST.getHorizontalIndex();
        }
        if (llllllllllllllIIlllllIIIllllllIl.getValue((IProperty<Boolean>)BlockWall.SOUTH)) {
            llllllllllllllIIlllllIIIlllllllI |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
        }
        if (llllllllllllllIIlllllIIIllllllIl.getValue((IProperty<Boolean>)BlockWall.WEST)) {
            llllllllllllllIIlllllIIIlllllllI |= 1 << EnumFacing.WEST.getHorizontalIndex();
        }
        return llllllllllllllIIlllllIIIlllllllI;
    }
    
    @Override
    public IBlockState getActualState(final IBlockState llllllllllllllIIlllllIIIlIlIIIIl, final IBlockAccess llllllllllllllIIlllllIIIlIlIIIII, final BlockPos llllllllllllllIIlllllIIIlIIlllll) {
        final boolean llllllllllllllIIlllllIIIlIIllllI = this.canConnectTo(llllllllllllllIIlllllIIIlIlIIIII, llllllllllllllIIlllllIIIlIIlllll.north(), EnumFacing.SOUTH);
        final boolean llllllllllllllIIlllllIIIlIIlllIl = this.canConnectTo(llllllllllllllIIlllllIIIlIlIIIII, llllllllllllllIIlllllIIIlIIlllll.east(), EnumFacing.WEST);
        final boolean llllllllllllllIIlllllIIIlIIlllII = this.canConnectTo(llllllllllllllIIlllllIIIlIlIIIII, llllllllllllllIIlllllIIIlIIlllll.south(), EnumFacing.NORTH);
        final boolean llllllllllllllIIlllllIIIlIIllIll = this.canConnectTo(llllllllllllllIIlllllIIIlIlIIIII, llllllllllllllIIlllllIIIlIIlllll.west(), EnumFacing.EAST);
        final boolean llllllllllllllIIlllllIIIlIIllIlI = (llllllllllllllIIlllllIIIlIIllllI && !llllllllllllllIIlllllIIIlIIlllIl && llllllllllllllIIlllllIIIlIIlllII && !llllllllllllllIIlllllIIIlIIllIll) || (!llllllllllllllIIlllllIIIlIIllllI && llllllllllllllIIlllllIIIlIIlllIl && !llllllllllllllIIlllllIIIlIIlllII && llllllllllllllIIlllllIIIlIIllIll);
        return llllllllllllllIIlllllIIIlIlIIIIl.withProperty((IProperty<Comparable>)BlockWall.UP, !llllllllllllllIIlllllIIIlIIllIlI || !llllllllllllllIIlllllIIIlIlIIIII.isAirBlock(llllllllllllllIIlllllIIIlIIlllll.up())).withProperty((IProperty<Comparable>)BlockWall.NORTH, llllllllllllllIIlllllIIIlIIllllI).withProperty((IProperty<Comparable>)BlockWall.EAST, llllllllllllllIIlllllIIIlIIlllIl).withProperty((IProperty<Comparable>)BlockWall.SOUTH, llllllllllllllIIlllllIIIlIIlllII).withProperty((IProperty<Comparable>)BlockWall.WEST, llllllllllllllIIlllllIIIlIIllIll);
    }
    
    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState llllllllllllllIIlllllIIlIIIIIlII, final IBlockAccess llllllllllllllIIlllllIIlIIIIIlll, final BlockPos llllllllllllllIIlllllIIlIIIIIllI) {
        llllllllllllllIIlllllIIlIIIIIlII = (byte)this.getActualState((IBlockState)llllllllllllllIIlllllIIlIIIIIlII, llllllllllllllIIlllllIIlIIIIIlll, llllllllllllllIIlllllIIlIIIIIllI);
        return BlockWall.CLIP_AABB_BY_INDEX[getAABBIndex((IBlockState)llllllllllllllIIlllllIIlIIIIIlII)];
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState llllllllllllllIIlllllIIIllllIIlI) {
        return false;
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockWall.UP, BlockWall.NORTH, BlockWall.EAST, BlockWall.WEST, BlockWall.SOUTH, BlockWall.VARIANT });
    }
    
    static {
        UP = PropertyBool.create("up");
        NORTH = PropertyBool.create("north");
        EAST = PropertyBool.create("east");
        SOUTH = PropertyBool.create("south");
        WEST = PropertyBool.create("west");
        VARIANT = PropertyEnum.create("variant", EnumType.class);
        AABB_BY_INDEX = new AxisAlignedBB[] { new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 0.75), new AxisAlignedBB(0.25, 0.0, 0.25, 0.75, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.25, 0.75, 1.0, 0.75), new AxisAlignedBB(0.0, 0.0, 0.25, 0.75, 1.0, 1.0), new AxisAlignedBB(0.25, 0.0, 0.0, 0.75, 1.0, 0.75), new AxisAlignedBB(0.3125, 0.0, 0.0, 0.6875, 0.875, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 0.75, 1.0, 0.75), new AxisAlignedBB(0.0, 0.0, 0.0, 0.75, 1.0, 1.0), new AxisAlignedBB(0.25, 0.0, 0.25, 1.0, 1.0, 0.75), new AxisAlignedBB(0.25, 0.0, 0.25, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.3125, 1.0, 0.875, 0.6875), new AxisAlignedBB(0.0, 0.0, 0.25, 1.0, 1.0, 1.0), new AxisAlignedBB(0.25, 0.0, 0.0, 1.0, 1.0, 0.75), new AxisAlignedBB(0.25, 0.0, 0.0, 1.0, 1.0, 1.0), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 0.75), new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0) };
        CLIP_AABB_BY_INDEX = new AxisAlignedBB[] { BlockWall.AABB_BY_INDEX[0].setMaxY(1.5), BlockWall.AABB_BY_INDEX[1].setMaxY(1.5), BlockWall.AABB_BY_INDEX[2].setMaxY(1.5), BlockWall.AABB_BY_INDEX[3].setMaxY(1.5), BlockWall.AABB_BY_INDEX[4].setMaxY(1.5), BlockWall.AABB_BY_INDEX[5].setMaxY(1.5), BlockWall.AABB_BY_INDEX[6].setMaxY(1.5), BlockWall.AABB_BY_INDEX[7].setMaxY(1.5), BlockWall.AABB_BY_INDEX[8].setMaxY(1.5), BlockWall.AABB_BY_INDEX[9].setMaxY(1.5), BlockWall.AABB_BY_INDEX[10].setMaxY(1.5), BlockWall.AABB_BY_INDEX[11].setMaxY(1.5), BlockWall.AABB_BY_INDEX[12].setMaxY(1.5), BlockWall.AABB_BY_INDEX[13].setMaxY(1.5), BlockWall.AABB_BY_INDEX[14].setMaxY(1.5), BlockWall.AABB_BY_INDEX[15].setMaxY(1.5) };
    }
    
    @Override
    public void addCollisionBoxToList(IBlockState llllllllllllllIIlllllIIlIIIlIIll, final World llllllllllllllIIlllllIIlIIIlIIlI, final BlockPos llllllllllllllIIlllllIIlIIIllIIl, final AxisAlignedBB llllllllllllllIIlllllIIlIIIlIIII, final List<AxisAlignedBB> llllllllllllllIIlllllIIlIIIlIlll, @Nullable final Entity llllllllllllllIIlllllIIlIIIlIllI, final boolean llllllllllllllIIlllllIIlIIIIlllI) {
        if (!llllllllllllllIIlllllIIlIIIIlllI) {
            llllllllllllllIIlllllIIlIIIlIIll = this.getActualState((IBlockState)llllllllllllllIIlllllIIlIIIlIIll, llllllllllllllIIlllllIIlIIIlIIlI, llllllllllllllIIlllllIIlIIIllIIl);
        }
        Block.addCollisionBoxToList(llllllllllllllIIlllllIIlIIIllIIl, llllllllllllllIIlllllIIlIIIlIIII, llllllllllllllIIlllllIIlIIIlIlll, BlockWall.CLIP_AABB_BY_INDEX[getAABBIndex((IBlockState)llllllllllllllIIlllllIIlIIIlIIll)]);
    }
    
    public BlockWall(final Block llllllllllllllIIlllllIIlIIllIIII) {
        super(llllllllllllllIIlllllIIlIIllIIII.blockMaterial);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockWall.UP, false).withProperty((IProperty<Comparable>)BlockWall.NORTH, false).withProperty((IProperty<Comparable>)BlockWall.EAST, false).withProperty((IProperty<Comparable>)BlockWall.SOUTH, false).withProperty((IProperty<Comparable>)BlockWall.WEST, false).withProperty(BlockWall.VARIANT, EnumType.NORMAL));
        this.setHardness(llllllllllllllIIlllllIIlIIllIIII.blockHardness);
        this.setResistance(llllllllllllllIIlllllIIlIIllIIII.blockResistance / 3.0f);
        this.setSoundType(llllllllllllllIIlllllIIlIIllIIII.blockSoundType);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState llllllllllllllIIlllllIIlIIlIIllI, final IBlockAccess llllllllllllllIIlllllIIlIIlIlIIl, final BlockPos llllllllllllllIIlllllIIlIIlIlIII) {
        llllllllllllllIIlllllIIlIIlIIllI = this.getActualState(llllllllllllllIIlllllIIlIIlIIllI, llllllllllllllIIlllllIIlIIlIlIIl, llllllllllllllIIlllllIIlIIlIlIII);
        return BlockWall.AABB_BY_INDEX[getAABBIndex(llllllllllllllIIlllllIIlIIlIIllI)];
    }
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIlllllIIIlIllIIlI) {
        return this.getDefaultState().withProperty(BlockWall.VARIANT, EnumType.byMetadata(llllllllllllllIIlllllIIIlIllIIlI));
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal(String.valueOf(new StringBuilder(String.valueOf(this.getUnlocalizedName())).append(".").append(EnumType.NORMAL.getUnlocalizedName()).append(".name")));
    }
    
    @Override
    public boolean isFullCube(final IBlockState llllllllllllllIIlllllIIIllllIlll) {
        return false;
    }
    
    public enum EnumType implements IStringSerializable
    {
        private static final /* synthetic */ EnumType[] META_LOOKUP;
        private final /* synthetic */ String name;
        
        MOSSY("MOSSY", 1, 1, "mossy_cobblestone", "mossy");
        
        private final /* synthetic */ int meta;
        
        NORMAL("NORMAL", 0, 0, "cobblestone", "normal");
        
        private final /* synthetic */ String unlocalizedName;
        
        @Override
        public String toString() {
            return this.name;
        }
        
        @Override
        public String getName() {
            return this.name;
        }
        
        public static EnumType byMetadata(int lllllllllllllIIllIlIllllllIIIllI) {
            if (lllllllllllllIIllIlIllllllIIIllI < 0 || lllllllllllllIIllIlIllllllIIIllI >= EnumType.META_LOOKUP.length) {
                lllllllllllllIIllIlIllllllIIIllI = 0;
            }
            return EnumType.META_LOOKUP[lllllllllllllIIllIlIllllllIIIllI];
        }
        
        static {
            META_LOOKUP = new EnumType[values().length];
            final boolean lllllllllllllIIllIlIllllllIlllll;
            final boolean lllllllllllllIIllIlIlllllllIIIII = ((EnumType[])(Object)(lllllllllllllIIllIlIllllllIlllll = (boolean)(Object)values())).length != 0;
            for (String lllllllllllllIIllIlIlllllllIIIIl = (String)0; lllllllllllllIIllIlIlllllllIIIIl < lllllllllllllIIllIlIlllllllIIIII; ++lllllllllllllIIllIlIlllllllIIIIl) {
                final EnumType lllllllllllllIIllIlIlllllllIIIll = lllllllllllllIIllIlIllllllIlllll[lllllllllllllIIllIlIlllllllIIIIl];
                EnumType.META_LOOKUP[lllllllllllllIIllIlIlllllllIIIll.getMetadata()] = lllllllllllllIIllIlIlllllllIIIll;
            }
        }
        
        public int getMetadata() {
            return this.meta;
        }
        
        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }
        
        private EnumType(final String lllllllllllllIIllIlIllllllIlIIll, final int lllllllllllllIIllIlIllllllIlIIlI, final int lllllllllllllIIllIlIllllllIlIIIl, final String lllllllllllllIIllIlIllllllIlIllI, final String lllllllllllllIIllIlIllllllIlIlIl) {
            this.meta = lllllllllllllIIllIlIllllllIlIIIl;
            this.name = lllllllllllllIIllIlIllllllIlIllI;
            this.unlocalizedName = lllllllllllllIIllIlIllllllIlIlIl;
        }
    }
}
