package net.minecraft.block;

import java.util.*;
import net.minecraft.util.registry.*;
import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.player.*;
import net.minecraft.tileentity.*;
import net.minecraft.stats.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.inventory.*;
import net.minecraft.dispenser.*;

public class BlockDispenser extends BlockContainer
{
    protected /* synthetic */ Random rand;
    public static final /* synthetic */ RegistryDefaulted<Item, IBehaviorDispenseItem> DISPENSE_BEHAVIOR_REGISTRY;
    public static final /* synthetic */ PropertyBool TRIGGERED;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIlIIlllIIIllIIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockDispenser.FACING, EnumFacing.getFront(llllllllllllllIIlIIlllIIIllIIlll & 0x7)).withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, (llllllllllllllIIlIIlllIIIllIIlll & 0x8) > 0);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState llllllllllllllIIlIIlllIIIlIlIIll, final Mirror llllllllllllllIIlIIlllIIIlIlIIII) {
        return llllllllllllllIIlIIlllIIIlIlIIll.withRotation(llllllllllllllIIlIIlllIIIlIlIIII.toRotation(llllllllllllllIIlIIlllIIIlIlIIll.getValue((IProperty<EnumFacing>)BlockDispenser.FACING)));
    }
    
    @Override
    public void breakBlock(final World llllllllllllllIIlIIlllIIlIIIlllI, final BlockPos llllllllllllllIIlIIlllIIlIIIllIl, final IBlockState llllllllllllllIIlIIlllIIlIIIIlll) {
        final TileEntity llllllllllllllIIlIIlllIIlIIIlIll = llllllllllllllIIlIIlllIIlIIIlllI.getTileEntity(llllllllllllllIIlIIlllIIlIIIllIl);
        if (llllllllllllllIIlIIlllIIlIIIlIll instanceof TileEntityDispenser) {
            InventoryHelper.dropInventoryItems(llllllllllllllIIlIIlllIIlIIIlllI, llllllllllllllIIlIIlllIIlIIIllIl, (IInventory)llllllllllllllIIlIIlllIIlIIIlIll);
            llllllllllllllIIlIIlllIIlIIIlllI.updateComparatorOutputLevel(llllllllllllllIIlIIlllIIlIIIllIl, this);
        }
        super.breakBlock(llllllllllllllIIlIIlllIIlIIIlllI, llllllllllllllIIlIIlllIIlIIIllIl, llllllllllllllIIlIIlllIIlIIIIlll);
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIlIIlllIIIllIIIIl) {
        int llllllllllllllIIlIIlllIIIllIIIII = 0;
        llllllllllllllIIlIIlllIIIllIIIII |= llllllllllllllIIlIIlllIIIllIIIIl.getValue((IProperty<EnumFacing>)BlockDispenser.FACING).getIndex();
        if (llllllllllllllIIlIIlllIIIllIIIIl.getValue((IProperty<Boolean>)BlockDispenser.TRIGGERED)) {
            llllllllllllllIIlIIlllIIIllIIIII |= 0x8;
        }
        return llllllllllllllIIlIIlllIIIllIIIII;
    }
    
    public static IPosition getDispensePosition(final IBlockSource llllllllllllllIIlIIlllIIlIIIIIII) {
        final EnumFacing llllllllllllllIIlIIlllIIIlllllll = llllllllllllllIIlIIlllIIlIIIIIII.getBlockState().getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
        final double llllllllllllllIIlIIlllIIIllllllI = llllllllllllllIIlIIlllIIlIIIIIII.getX() + 0.7 * llllllllllllllIIlIIlllIIIlllllll.getFrontOffsetX();
        final double llllllllllllllIIlIIlllIIIlllllIl = llllllllllllllIIlIIlllIIlIIIIIII.getY() + 0.7 * llllllllllllllIIlIIlllIIIlllllll.getFrontOffsetY();
        final double llllllllllllllIIlIIlllIIIlllllII = llllllllllllllIIlIIlllIIlIIIIIII.getZ() + 0.7 * llllllllllllllIIlIIlllIIIlllllll.getFrontOffsetZ();
        return new PositionImpl(llllllllllllllIIlIIlllIIIllllllI, llllllllllllllIIlIIlllIIIlllllIl, llllllllllllllIIlIIlllIIIlllllII);
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState llllllllllllllIIlIIlllIIIlllIlIl) {
        return true;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllllIIlIIlllIIIllIlIll) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIlIIlllIIlllllIII, final BlockPos llllllllllllllIIlIIlllIlIIIIIIIl, final IBlockState llllllllllllllIIlIIlllIlIIIIIIII, final EntityPlayer llllllllllllllIIlIIlllIIllllllll, final EnumHand llllllllllllllIIlIIlllIIlllllllI, final EnumFacing llllllllllllllIIlIIlllIIllllllIl, final float llllllllllllllIIlIIlllIIllllllII, final float llllllllllllllIIlIIlllIIlllllIll, final float llllllllllllllIIlIIlllIIlllllIlI) {
        if (llllllllllllllIIlIIlllIIlllllIII.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllIIlIIlllIIlllllIIl = llllllllllllllIIlIIlllIIlllllIII.getTileEntity(llllllllllllllIIlIIlllIlIIIIIIIl);
        if (llllllllllllllIIlIIlllIIlllllIIl instanceof TileEntityDispenser) {
            llllllllllllllIIlIIlllIIllllllll.displayGUIChest((IInventory)llllllllllllllIIlIIlllIIlllllIIl);
            if (llllllllllllllIIlIIlllIIlllllIIl instanceof TileEntityDropper) {
                llllllllllllllIIlIIlllIIllllllll.addStat(StatList.DROPPER_INSPECTED);
            }
            else {
                llllllllllllllIIlIIlllIIllllllll.addStat(StatList.DISPENSER_INSPECTED);
            }
        }
        return true;
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIIlIIlllIIllIlIIIl, final World llllllllllllllIIlIIlllIIllIlIIII, final BlockPos llllllllllllllIIlIIlllIIllIIIlll, final Block llllllllllllllIIlIIlllIIllIIlllI, final BlockPos llllllllllllllIIlIIlllIIllIIllIl) {
        final boolean llllllllllllllIIlIIlllIIllIIllII = llllllllllllllIIlIIlllIIllIlIIII.isBlockPowered(llllllllllllllIIlIIlllIIllIIIlll) || llllllllllllllIIlIIlllIIllIlIIII.isBlockPowered(llllllllllllllIIlIIlllIIllIIIlll.up());
        final boolean llllllllllllllIIlIIlllIIllIIlIll = llllllllllllllIIlIIlllIIllIlIIIl.getValue((IProperty<Boolean>)BlockDispenser.TRIGGERED);
        if (llllllllllllllIIlIIlllIIllIIllII && !llllllllllllllIIlIIlllIIllIIlIll) {
            llllllllllllllIIlIIlllIIllIlIIII.scheduleUpdate(llllllllllllllIIlIIlllIIllIIIlll, this, this.tickRate(llllllllllllllIIlIIlllIIllIlIIII));
            llllllllllllllIIlIIlllIIllIlIIII.setBlockState(llllllllllllllIIlIIlllIIllIIIlll, llllllllllllllIIlIIlllIIllIlIIIl.withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, true), 4);
        }
        else if (!llllllllllllllIIlIIlllIIllIIllII && llllllllllllllIIlIIlllIIllIIlIll) {
            llllllllllllllIIlIIlllIIllIlIIII.setBlockState(llllllllllllllIIlIIlllIIllIIIlll, llllllllllllllIIlIIlllIIllIlIIIl.withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, false), 4);
        }
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIIlIIlllIIlIIllIlI, final BlockPos llllllllllllllIIlIIlllIIlIIllIIl, final IBlockState llllllllllllllIIlIIlllIIlIIllIII, final EntityLivingBase llllllllllllllIIlIIlllIIlIIlIlll, final ItemStack llllllllllllllIIlIIlllIIlIIlIllI) {
        llllllllllllllIIlIIlllIIlIIllIlI.setBlockState(llllllllllllllIIlIIlllIIlIIllIIl, llllllllllllllIIlIIlllIIlIIllIII.withProperty((IProperty<Comparable>)BlockDispenser.FACING, EnumFacing.func_190914_a(llllllllllllllIIlIIlllIIlIIllIIl, llllllllllllllIIlIIlllIIlIIlIlll)), 2);
        if (llllllllllllllIIlIIlllIIlIIlIllI.hasDisplayName()) {
            final TileEntity llllllllllllllIIlIIlllIIlIIllIll = llllllllllllllIIlIIlllIIlIIllIlI.getTileEntity(llllllllllllllIIlIIlllIIlIIllIIl);
            if (llllllllllllllIIlIIlllIIlIIllIll instanceof TileEntityDispenser) {
                ((TileEntityDispenser)llllllllllllllIIlIIlllIIlIIllIll).func_190575_a(llllllllllllllIIlIIlllIIlIIlIllI.getDisplayName());
            }
        }
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockDispenser.FACING, BlockDispenser.TRIGGERED });
    }
    
    @Override
    public IBlockState withRotation(final IBlockState llllllllllllllIIlIIlllIIIlIllIlI, final Rotation llllllllllllllIIlIIlllIIIlIllIIl) {
        return llllllllllllllIIlIIlllIIIlIllIlI.withProperty((IProperty<Comparable>)BlockDispenser.FACING, llllllllllllllIIlIIlllIIIlIllIIl.rotate(llllllllllllllIIlIIlllIIIlIllIlI.getValue((IProperty<EnumFacing>)BlockDispenser.FACING)));
    }
    
    protected BlockDispenser() {
        super(Material.ROCK);
        this.rand = new Random();
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockDispenser.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, false));
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    private void setDefaultDirection(final World llllllllllllllIIlIIlllIlIIIIllll, final BlockPos llllllllllllllIIlIIlllIlIIIIlllI, final IBlockState llllllllllllllIIlIIlllIlIIIIllIl) {
        if (!llllllllllllllIIlIIlllIlIIIIllll.isRemote) {
            EnumFacing llllllllllllllIIlIIlllIlIIIlIlII = llllllllllllllIIlIIlllIlIIIIllIl.getValue((IProperty<EnumFacing>)BlockDispenser.FACING);
            final boolean llllllllllllllIIlIIlllIlIIIlIIll = llllllllllllllIIlIIlllIlIIIIllll.getBlockState(llllllllllllllIIlIIlllIlIIIIlllI.north()).isFullBlock();
            final boolean llllllllllllllIIlIIlllIlIIIlIIlI = llllllllllllllIIlIIlllIlIIIIllll.getBlockState(llllllllllllllIIlIIlllIlIIIIlllI.south()).isFullBlock();
            if (llllllllllllllIIlIIlllIlIIIlIlII == EnumFacing.NORTH && llllllllllllllIIlIIlllIlIIIlIIll && !llllllllllllllIIlIIlllIlIIIlIIlI) {
                llllllllllllllIIlIIlllIlIIIlIlII = EnumFacing.SOUTH;
            }
            else if (llllllllllllllIIlIIlllIlIIIlIlII == EnumFacing.SOUTH && llllllllllllllIIlIIlllIlIIIlIIlI && !llllllllllllllIIlIIlllIlIIIlIIll) {
                llllllllllllllIIlIIlllIlIIIlIlII = EnumFacing.NORTH;
            }
            else {
                final boolean llllllllllllllIIlIIlllIlIIIlIIIl = llllllllllllllIIlIIlllIlIIIIllll.getBlockState(llllllllllllllIIlIIlllIlIIIIlllI.west()).isFullBlock();
                final boolean llllllllllllllIIlIIlllIlIIIlIIII = llllllllllllllIIlIIlllIlIIIIllll.getBlockState(llllllllllllllIIlIIlllIlIIIIlllI.east()).isFullBlock();
                if (llllllllllllllIIlIIlllIlIIIlIlII == EnumFacing.WEST && llllllllllllllIIlIIlllIlIIIlIIIl && !llllllllllllllIIlIIlllIlIIIlIIII) {
                    llllllllllllllIIlIIlllIlIIIlIlII = EnumFacing.EAST;
                }
                else if (llllllllllllllIIlIIlllIlIIIlIlII == EnumFacing.EAST && llllllllllllllIIlIIlllIlIIIlIIII && !llllllllllllllIIlIIlllIlIIIlIIIl) {
                    llllllllllllllIIlIIlllIlIIIlIlII = EnumFacing.WEST;
                }
            }
            llllllllllllllIIlIIlllIlIIIIllll.setBlockState(llllllllllllllIIlIIlllIlIIIIlllI, llllllllllllllIIlIIlllIlIIIIllIl.withProperty((IProperty<Comparable>)BlockDispenser.FACING, llllllllllllllIIlIIlllIlIIIlIlII).withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, false), 2);
        }
    }
    
    @Override
    public void onBlockAdded(final World llllllllllllllIIlIIlllIlIIlIIlll, final BlockPos llllllllllllllIIlIIlllIlIIlIIllI, final IBlockState llllllllllllllIIlIIlllIlIIlIIlIl) {
        super.onBlockAdded(llllllllllllllIIlIIlllIlIIlIIlll, llllllllllllllIIlIIlllIlIIlIIllI, llllllllllllllIIlIIlllIlIIlIIlIl);
        this.setDefaultDirection(llllllllllllllIIlIIlllIlIIlIIlll, llllllllllllllIIlIIlllIlIIlIIllI, llllllllllllllIIlIIlllIlIIlIIlIl);
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIlIIlllIIlIllIIlI, final BlockPos llllllllllllllIIlIIlllIIlIllIIIl, final EnumFacing llllllllllllllIIlIIlllIIlIllIIII, final float llllllllllllllIIlIIlllIIlIlIllll, final float llllllllllllllIIlIIlllIIlIlIlllI, final float llllllllllllllIIlIIlllIIlIlIllIl, final int llllllllllllllIIlIIlllIIlIlIllII, final EntityLivingBase llllllllllllllIIlIIlllIIlIlIlIII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockDispenser.FACING, EnumFacing.func_190914_a(llllllllllllllIIlIIlllIIlIllIIIl, llllllllllllllIIlIIlllIIlIlIlIII)).withProperty((IProperty<Comparable>)BlockDispenser.TRIGGERED, false);
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState llllllllllllllIIlIIlllIIIlllIIIl, final World llllllllllllllIIlIIlllIIIllIlllI, final BlockPos llllllllllllllIIlIIlllIIIllIllll) {
        return Container.calcRedstone(llllllllllllllIIlIIlllIIIllIlllI.getTileEntity(llllllllllllllIIlIIlllIIIllIllll));
    }
    
    protected void dispense(final World llllllllllllllIIlIIlllIIlllIIIll, final BlockPos llllllllllllllIIlIIlllIIlllIIIlI) {
        final BlockSourceImpl llllllllllllllIIlIIlllIIlllIlIIl = new BlockSourceImpl(llllllllllllllIIlIIlllIIlllIIIll, llllllllllllllIIlIIlllIIlllIIIlI);
        final TileEntityDispenser llllllllllllllIIlIIlllIIlllIlIII = llllllllllllllIIlIIlllIIlllIlIIl.getBlockTileEntity();
        if (llllllllllllllIIlIIlllIIlllIlIII != null) {
            final int llllllllllllllIIlIIlllIIlllIIlll = llllllllllllllIIlIIlllIIlllIlIII.getDispenseSlot();
            if (llllllllllllllIIlIIlllIIlllIIlll < 0) {
                llllllllllllllIIlIIlllIIlllIIIll.playEvent(1001, llllllllllllllIIlIIlllIIlllIIIlI, 0);
            }
            else {
                final ItemStack llllllllllllllIIlIIlllIIlllIIllI = llllllllllllllIIlIIlllIIlllIlIII.getStackInSlot(llllllllllllllIIlIIlllIIlllIIlll);
                final IBehaviorDispenseItem llllllllllllllIIlIIlllIIlllIIlIl = this.getBehavior(llllllllllllllIIlIIlllIIlllIIllI);
                if (llllllllllllllIIlIIlllIIlllIIlIl != IBehaviorDispenseItem.DEFAULT_BEHAVIOR) {
                    llllllllllllllIIlIIlllIIlllIlIII.setInventorySlotContents(llllllllllllllIIlIIlllIIlllIIlll, llllllllllllllIIlIIlllIIlllIIlIl.dispense(llllllllllllllIIlIIlllIIlllIlIIl, llllllllllllllIIlIIlllIIlllIIllI));
                }
            }
        }
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIlIIlllIIlIlllIII, final int llllllllllllllIIlIIlllIIlIllIlll) {
        return new TileEntityDispenser();
    }
    
    @Override
    public int tickRate(final World llllllllllllllIIlIIlllIlIIlIllIl) {
        return 4;
    }
    
    @Override
    public void updateTick(final World llllllllllllllIIlIIlllIIllIIIIII, final BlockPos llllllllllllllIIlIIlllIIlIllllll, final IBlockState llllllllllllllIIlIIlllIIlIlllllI, final Random llllllllllllllIIlIIlllIIlIllllIl) {
        if (!llllllllllllllIIlIIlllIIllIIIIII.isRemote) {
            this.dispense(llllllllllllllIIlIIlllIIllIIIIII, llllllllllllllIIlIIlllIIlIllllll);
        }
    }
    
    static {
        FACING = BlockDirectional.FACING;
        TRIGGERED = PropertyBool.create("triggered");
        DISPENSE_BEHAVIOR_REGISTRY = new RegistryDefaulted<Item, IBehaviorDispenseItem>(new BehaviorDefaultDispenseItem());
    }
    
    protected IBehaviorDispenseItem getBehavior(final ItemStack llllllllllllllIIlIIlllIIllIllIlI) {
        return BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.getObject(llllllllllllllIIlIIlllIIllIllIlI.getItem());
    }
}
