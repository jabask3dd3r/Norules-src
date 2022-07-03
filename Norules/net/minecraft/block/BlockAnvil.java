package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.util.math.*;
import org.apache.logging.log4j.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.entity.*;
import net.minecraft.util.text.*;
import net.minecraft.entity.item.*;
import net.minecraft.world.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;

public class BlockAnvil extends BlockFalling
{
    protected static final /* synthetic */ Logger LOGGER;
    public static final /* synthetic */ PropertyInteger DAMAGE;
    public static final /* synthetic */ PropertyDirection FACING;
    protected static final /* synthetic */ AxisAlignedBB Z_AXIS_AABB;
    protected static final /* synthetic */ AxisAlignedBB X_AXIS_AABB;
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIIIIIIIlIllllIIlIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockAnvil.FACING, EnumFacing.getHorizontal(lllllllllllllIIIIIIIlIllllIIlIll & 0x3)).withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, (lllllllllllllIIIIIIIlIllllIIlIll & 0xF) >> 2);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIIIIIIllIIIIIIIIII, final BlockPos lllllllllllllIIIIIIIllIIIIIIlIII, final IBlockState lllllllllllllIIIIIIIllIIIIIIIlll, final EntityPlayer lllllllllllllIIIIIIIllIIIIIIIllI, final EnumHand lllllllllllllIIIIIIIllIIIIIIIlIl, final EnumFacing lllllllllllllIIIIIIIllIIIIIIIlII, final float lllllllllllllIIIIIIIllIIIIIIIIll, final float lllllllllllllIIIIIIIllIIIIIIIIlI, final float lllllllllllllIIIIIIIllIIIIIIIIIl) {
        if (!lllllllllllllIIIIIIIllIIIIIIIIII.isRemote) {
            lllllllllllllIIIIIIIllIIIIIIIllI.displayGui(new Anvil(lllllllllllllIIIIIIIllIIIIIIIIII, lllllllllllllIIIIIIIllIIIIIIlIII));
        }
        return true;
    }
    
    @Override
    public int damageDropped(final IBlockState lllllllllllllIIIIIIIlIlllllllIlI) {
        return lllllllllllllIIIIIIIlIlllllllIlI.getValue((IProperty<Integer>)BlockAnvil.DAMAGE);
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIIIIIIIlIlllIllllII, final Rotation lllllllllllllIIIIIIIlIlllIlllIll) {
        return (lllllllllllllIIIIIIIlIlllIllllII.getBlock() != this) ? lllllllllllllIIIIIIIlIlllIllllII : lllllllllllllIIIIIIIlIlllIllllII.withProperty((IProperty<Comparable>)BlockAnvil.FACING, lllllllllllllIIIIIIIlIlllIlllIll.rotate(lllllllllllllIIIIIIIlIlllIllllII.getValue((IProperty<EnumFacing>)BlockAnvil.FACING)));
    }
    
    static {
        FACING = BlockHorizontal.FACING;
        DAMAGE = PropertyInteger.create("damage", 0, 2);
        X_AXIS_AABB = new AxisAlignedBB(0.0, 0.0, 0.125, 1.0, 1.0, 0.875);
        Z_AXIS_AABB = new AxisAlignedBB(0.125, 0.0, 0.0, 0.875, 1.0, 1.0);
        LOGGER = LogManager.getLogger();
    }
    
    protected BlockAnvil() {
        super(Material.ANVIL);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockAnvil.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, 0));
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIIIIIIIlIllllIIIlll) {
        int lllllllllllllIIIIIIIlIllllIIIllI = 0;
        lllllllllllllIIIIIIIlIllllIIIllI |= lllllllllllllIIIIIIIlIllllIIIlll.getValue((IProperty<EnumFacing>)BlockAnvil.FACING).getHorizontalIndex();
        lllllllllllllIIIIIIIlIllllIIIllI |= lllllllllllllIIIIIIIlIllllIIIlll.getValue((IProperty<Integer>)BlockAnvil.DAMAGE) << 2;
        return lllllllllllllIIIIIIIlIllllIIIllI;
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIIIIIIIllIIIIIlIlll, final BlockPos lllllllllllllIIIIIIIllIIIIlIIIIl, final EnumFacing lllllllllllllIIIIIIIllIIIIlIIIII, final float lllllllllllllIIIIIIIllIIIIIlIlII, final float lllllllllllllIIIIIIIllIIIIIlIIll, final float lllllllllllllIIIIIIIllIIIIIlIIlI, final int lllllllllllllIIIIIIIllIIIIIlIIIl, final EntityLivingBase lllllllllllllIIIIIIIllIIIIIllIll) {
        final EnumFacing lllllllllllllIIIIIIIllIIIIIllIlI = lllllllllllllIIIIIIIllIIIIIllIll.getHorizontalFacing().rotateY();
        try {
            return super.onBlockPlaced(lllllllllllllIIIIIIIllIIIIIlIlll, lllllllllllllIIIIIIIllIIIIlIIIIl, lllllllllllllIIIIIIIllIIIIlIIIII, lllllllllllllIIIIIIIllIIIIIlIlII, lllllllllllllIIIIIIIllIIIIIlIIll, lllllllllllllIIIIIIIllIIIIIlIIlI, lllllllllllllIIIIIIIllIIIIIlIIIl, lllllllllllllIIIIIIIllIIIIIllIll).withProperty((IProperty<Comparable>)BlockAnvil.FACING, lllllllllllllIIIIIIIllIIIIIllIlI).withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, lllllllllllllIIIIIIIllIIIIIlIIIl >> 2);
        }
        catch (IllegalArgumentException lllllllllllllIIIIIIIllIIIIIllIIl) {
            if (!lllllllllllllIIIIIIIllIIIIIlIlll.isRemote) {
                BlockAnvil.LOGGER.warn(String.format("Invalid damage property for anvil at %s. Found %d, must be in [0, 1, 2]", lllllllllllllIIIIIIIllIIIIlIIIIl, lllllllllllllIIIIIIIllIIIIIlIIIl >> 2));
                if (lllllllllllllIIIIIIIllIIIIIllIll instanceof EntityPlayer) {
                    lllllllllllllIIIIIIIllIIIIIllIll.addChatMessage(new TextComponentTranslation("Invalid damage property. Please pick in [0, 1, 2]", new Object[0]));
                }
            }
            return super.onBlockPlaced(lllllllllllllIIIIIIIllIIIIIlIlll, lllllllllllllIIIIIIIllIIIIlIIIIl, lllllllllllllIIIIIIIllIIIIlIIIII, lllllllllllllIIIIIIIllIIIIIlIlII, lllllllllllllIIIIIIIllIIIIIlIIll, lllllllllllllIIIIIIIllIIIIIlIIlI, 0, lllllllllllllIIIIIIIllIIIIIllIll).withProperty((IProperty<Comparable>)BlockAnvil.FACING, lllllllllllllIIIIIIIllIIIIIllIlI).withProperty((IProperty<Comparable>)BlockAnvil.DAMAGE, 0);
        }
    }
    
    @Override
    protected void onStartFalling(final EntityFallingBlock lllllllllllllIIIIIIIlIlllllIIllI) {
        lllllllllllllIIIIIIIlIlllllIIllI.setHurtEntities(true);
    }
    
    @Override
    public boolean shouldSideBeRendered(final IBlockState lllllllllllllIIIIIIIlIllllIlIlII, final IBlockAccess lllllllllllllIIIIIIIlIllllIlIIll, final BlockPos lllllllllllllIIIIIIIlIllllIlIIlI, final EnumFacing lllllllllllllIIIIIIIlIllllIlIIIl) {
        return true;
    }
    
    @Override
    public BlockFaceShape func_193383_a(final IBlockAccess lllllllllllllIIIIIIIllIIIIllIlII, final IBlockState lllllllllllllIIIIIIIllIIIIllIIll, final BlockPos lllllllllllllIIIIIIIllIIIIllIIlI, final EnumFacing lllllllllllllIIIIIIIllIIIIllIIIl) {
        return BlockFaceShape.UNDEFINED;
    }
    
    @Override
    public void onEndFalling(final World lllllllllllllIIIIIIIlIllllIllllI, final BlockPos lllllllllllllIIIIIIIlIlllllIIIIl, final IBlockState lllllllllllllIIIIIIIlIlllllIIIII, final IBlockState lllllllllllllIIIIIIIlIllllIlllll) {
        lllllllllllllIIIIIIIlIllllIllllI.playEvent(1031, lllllllllllllIIIIIIIlIlllllIIIIl, 0);
    }
    
    @Override
    public void getSubBlocks(final CreativeTabs lllllllllllllIIIIIIIlIlllllIllIl, final NonNullList<ItemStack> lllllllllllllIIIIIIIlIlllllIlIlI) {
        lllllllllllllIIIIIIIlIlllllIlIlI.add(new ItemStack(this));
        lllllllllllllIIIIIIIlIlllllIlIlI.add(new ItemStack(this, 1, 1));
        lllllllllllllIIIIIIIlIlllllIlIlI.add(new ItemStack(this, 1, 2));
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIIIIIllIIIIllIllI) {
        return false;
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(final IBlockState lllllllllllllIIIIIIIlIllllllIllI, final IBlockAccess lllllllllllllIIIIIIIlIllllllIlIl, final BlockPos lllllllllllllIIIIIIIlIllllllIlII) {
        final EnumFacing lllllllllllllIIIIIIIlIllllllIIll = lllllllllllllIIIIIIIlIllllllIllI.getValue((IProperty<EnumFacing>)BlockAnvil.FACING);
        return (lllllllllllllIIIIIIIlIllllllIIll.getAxis() == EnumFacing.Axis.X) ? BlockAnvil.X_AXIS_AABB : BlockAnvil.Z_AXIS_AABB;
    }
    
    @Override
    public void func_190974_b(final World lllllllllllllIIIIIIIlIllllIllIIl, final BlockPos lllllllllllllIIIIIIIlIllllIlIllI) {
        lllllllllllllIIIIIIIlIllllIllIIl.playEvent(1029, lllllllllllllIIIIIIIlIllllIlIllI, 0);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockAnvil.FACING, BlockAnvil.DAMAGE });
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIIIIIllIIIIlIllll) {
        return false;
    }
    
    public static class Anvil implements IInteractionObject
    {
        private final /* synthetic */ BlockPos position;
        private final /* synthetic */ World world;
        
        @Override
        public boolean hasCustomName() {
            return false;
        }
        
        @Override
        public String getGuiID() {
            return "minecraft:anvil";
        }
        
        @Override
        public Container createContainer(final InventoryPlayer lllllllllllllllllIlIllIIlllIIIII, final EntityPlayer lllllllllllllllllIlIllIIllIlllII) {
            return new ContainerRepair(lllllllllllllllllIlIllIIlllIIIII, this.world, this.position, lllllllllllllllllIlIllIIllIlllII);
        }
        
        public Anvil(final World lllllllllllllllllIlIllIIlllIllII, final BlockPos lllllllllllllllllIlIllIIlllIlIII) {
            this.world = lllllllllllllllllIlIllIIlllIllII;
            this.position = lllllllllllllllllIlIllIIlllIlIII;
        }
        
        @Override
        public String getName() {
            return "anvil";
        }
        
        @Override
        public ITextComponent getDisplayName() {
            return new TextComponentTranslation(String.valueOf(new StringBuilder(String.valueOf(Blocks.ANVIL.getUnlocalizedName())).append(".name")), new Object[0]);
        }
    }
}
