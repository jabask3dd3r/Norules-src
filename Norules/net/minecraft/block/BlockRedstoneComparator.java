package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.entity.item.*;
import net.minecraft.util.math.*;
import com.google.common.base.*;
import javax.annotation.*;
import net.minecraft.entity.*;
import java.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.init.*;
import net.minecraft.block.material.*;
import net.minecraft.util.text.translation.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;

public class BlockRedstoneComparator extends BlockRedstoneDiode implements ITileEntityProvider
{
    public static final /* synthetic */ PropertyEnum<Mode> MODE;
    public static final /* synthetic */ PropertyBool POWERED;
    
    @Override
    protected int getDelay(final IBlockState lllllllllllllIlllIIllllIlIIIlIlI) {
        return 2;
    }
    
    static {
        POWERED = PropertyBool.create("powered");
        MODE = PropertyEnum.create("mode", Mode.class);
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lllllllllllllIlllIIlllIllIIIllII) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, EnumFacing.getHorizontal(lllllllllllllIlllIIlllIllIIIllII)).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, (lllllllllllllIlllIIlllIllIIIllII & 0x8) > 0).withProperty(BlockRedstoneComparator.MODE, ((lllllllllllllIlllIIlllIllIIIllII & 0x4) > 0) ? Mode.SUBTRACT : Mode.COMPARE);
    }
    
    @Override
    public int getMetaFromState(final IBlockState lllllllllllllIlllIIlllIllIIIIllI) {
        int lllllllllllllIlllIIlllIllIIIIlll = 0;
        lllllllllllllIlllIIlllIllIIIIlll |= lllllllllllllIlllIIlllIllIIIIllI.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING).getHorizontalIndex();
        if (lllllllllllllIlllIIlllIllIIIIllI.getValue((IProperty<Boolean>)BlockRedstoneComparator.POWERED)) {
            lllllllllllllIlllIIlllIllIIIIlll |= 0x8;
        }
        if (lllllllllllllIlllIIlllIllIIIIllI.getValue(BlockRedstoneComparator.MODE) == Mode.SUBTRACT) {
            lllllllllllllIlllIIlllIllIIIIlll |= 0x4;
        }
        return lllllllllllllIlllIIlllIllIIIIlll;
    }
    
    @Override
    protected IBlockState getPoweredState(final IBlockState lllllllllllllIlllIIllllIlIIIIlII) {
        final Boolean lllllllllllllIlllIIllllIlIIIIIll = lllllllllllllIlllIIllllIlIIIIlII.getValue((IProperty<Boolean>)BlockRedstoneComparator.POWERED);
        final Mode lllllllllllllIlllIIllllIlIIIIIlI = lllllllllllllIlllIIllllIlIIIIlII.getValue(BlockRedstoneComparator.MODE);
        final EnumFacing lllllllllllllIlllIIllllIlIIIIIIl = lllllllllllllIlllIIllllIlIIIIlII.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING);
        return Blocks.POWERED_COMPARATOR.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, lllllllllllllIlllIIllllIlIIIIIIl).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, lllllllllllllIlllIIllllIlIIIIIll).withProperty(BlockRedstoneComparator.MODE, lllllllllllllIlllIIllllIlIIIIIlI);
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lllllllllllllIlllIIlllIlIllllIlI, final Mirror lllllllllllllIlllIIlllIlIlllIlll) {
        return lllllllllllllIlllIIlllIlIllllIlI.withRotation(lllllllllllllIlllIIlllIlIlllIlll.toRotation(lllllllllllllIlllIIlllIlIllllIlI.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING)));
    }
    
    @Override
    public void breakBlock(final World lllllllllllllIlllIIlllIllIllIIII, final BlockPos lllllllllllllIlllIIlllIllIlIlIll, final IBlockState lllllllllllllIlllIIlllIllIlIlIlI) {
        super.breakBlock(lllllllllllllIlllIIlllIllIllIIII, lllllllllllllIlllIIlllIllIlIlIll, lllllllllllllIlllIIlllIllIlIlIlI);
        lllllllllllllIlllIIlllIllIllIIII.removeTileEntity(lllllllllllllIlllIIlllIllIlIlIll);
        this.notifyNeighbors(lllllllllllllIlllIIlllIllIllIIII, lllllllllllllIlllIIlllIllIlIlIll, lllllllllllllIlllIIlllIllIlIlIlI);
    }
    
    private int calculateOutput(final World lllllllllllllIlllIIllllIIlIllIIl, final BlockPos lllllllllllllIlllIIllllIIlIlIlII, final IBlockState lllllllllllllIlllIIllllIIlIlIlll) {
        return (lllllllllllllIlllIIllllIIlIlIlll.getValue(BlockRedstoneComparator.MODE) == Mode.SUBTRACT) ? Math.max(this.calculateInputStrength(lllllllllllllIlllIIllllIIlIllIIl, lllllllllllllIlllIIllllIIlIlIlII, lllllllllllllIlllIIllllIIlIlIlll) - this.getPowerOnSides(lllllllllllllIlllIIllllIIlIllIIl, lllllllllllllIlllIIllllIIlIlIlII, lllllllllllllIlllIIllllIIlIlIlll), 0) : this.calculateInputStrength(lllllllllllllIlllIIllllIIlIllIIl, lllllllllllllIlllIIllllIIlIlIlII, lllllllllllllIlllIIllllIIlIlIlll);
    }
    
    @Override
    protected void updateState(final World lllllllllllllIlllIIlllIlllllIlll, final BlockPos lllllllllllllIlllIIlllIlllllIllI, final IBlockState lllllllllllllIlllIIlllIllllIlllI) {
        if (!lllllllllllllIlllIIlllIlllllIlll.isBlockTickPending(lllllllllllllIlllIIlllIlllllIllI, this)) {
            final int lllllllllllllIlllIIlllIlllllIlII = this.calculateOutput(lllllllllllllIlllIIlllIlllllIlll, lllllllllllllIlllIIlllIlllllIllI, lllllllllllllIlllIIlllIllllIlllI);
            final TileEntity lllllllllllllIlllIIlllIlllllIIll = lllllllllllllIlllIIlllIlllllIlll.getTileEntity(lllllllllllllIlllIIlllIlllllIllI);
            final int lllllllllllllIlllIIlllIlllllIIlI = (lllllllllllllIlllIIlllIlllllIIll instanceof TileEntityComparator) ? ((TileEntityComparator)lllllllllllllIlllIIlllIlllllIIll).getOutputSignal() : 0;
            if (lllllllllllllIlllIIlllIlllllIlII != lllllllllllllIlllIIlllIlllllIIlI || this.isPowered(lllllllllllllIlllIIlllIllllIlllI) != this.shouldBePowered(lllllllllllllIlllIIlllIlllllIlll, lllllllllllllIlllIIlllIlllllIllI, lllllllllllllIlllIIlllIllllIlllI)) {
                if (this.isFacingTowardsRepeater(lllllllllllllIlllIIlllIlllllIlll, lllllllllllllIlllIIlllIlllllIllI, lllllllllllllIlllIIlllIllllIlllI)) {
                    lllllllllllllIlllIIlllIlllllIlll.updateBlockTick(lllllllllllllIlllIIlllIlllllIllI, this, 2, -1);
                }
                else {
                    lllllllllllllIlllIIlllIlllllIlll.updateBlockTick(lllllllllllllIlllIIlllIlllllIllI, this, 2, 0);
                }
            }
        }
    }
    
    @Nullable
    private EntityItemFrame findItemFrame(final World lllllllllllllIlllIIllllIIIIlllll, final EnumFacing lllllllllllllIlllIIllllIIIIllllI, final BlockPos lllllllllllllIlllIIllllIIIIlllIl) {
        final List<EntityItemFrame> lllllllllllllIlllIIllllIIIIlllII = lllllllllllllIlllIIllllIIIIlllll.getEntitiesWithinAABB((Class<? extends EntityItemFrame>)EntityItemFrame.class, new AxisAlignedBB(lllllllllllllIlllIIllllIIIIlllIl.getX(), lllllllllllllIlllIIllllIIIIlllIl.getY(), lllllllllllllIlllIIllllIIIIlllIl.getZ(), lllllllllllllIlllIIllllIIIIlllIl.getX() + 1, lllllllllllllIlllIIllllIIIIlllIl.getY() + 1, lllllllllllllIlllIIllllIIIIlllIl.getZ() + 1), (com.google.common.base.Predicate<? super EntityItemFrame>)new Predicate<Entity>() {
            public boolean apply(@Nullable final Entity lllllllllllllIIlIIIIlllIlllIllIl) {
                return lllllllllllllIIlIIIIlllIlllIllIl != null && lllllllllllllIIlIIIIlllIlllIllIl.getHorizontalFacing() == lllllllllllllIlllIIllllIIIIllllI;
            }
        });
        return (lllllllllllllIlllIIllllIIIIlllII.size() == 1) ? lllllllllllllIlllIIllllIIIIlllII.get(0) : null;
    }
    
    @Override
    protected boolean shouldBePowered(final World lllllllllllllIlllIIllllIIlIIlIll, final BlockPos lllllllllllllIlllIIllllIIlIIIlII, final IBlockState lllllllllllllIlllIIllllIIlIIIIll) {
        final int lllllllllllllIlllIIllllIIlIIlIII = this.calculateInputStrength(lllllllllllllIlllIIllllIIlIIlIll, lllllllllllllIlllIIllllIIlIIIlII, lllllllllllllIlllIIllllIIlIIIIll);
        if (lllllllllllllIlllIIllllIIlIIlIII >= 15) {
            return true;
        }
        if (lllllllllllllIlllIIllllIIlIIlIII == 0) {
            return false;
        }
        final int lllllllllllllIlllIIllllIIlIIIlll = this.getPowerOnSides(lllllllllllllIlllIIllllIIlIIlIll, lllllllllllllIlllIIllllIIlIIIlII, lllllllllllllIlllIIllllIIlIIIIll);
        return lllllllllllllIlllIIllllIIlIIIlll == 0 || lllllllllllllIlllIIllllIIlIIlIII >= lllllllllllllIlllIIllllIIlIIIlll;
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lllllllllllllIlllIIlllIllIIIIIIl, final Rotation lllllllllllllIlllIIlllIllIIIIIII) {
        return lllllllllllllIlllIIlllIllIIIIIIl.withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, lllllllllllllIlllIIlllIllIIIIIII.rotate(lllllllllllllIlllIIlllIllIIIIIIl.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING)));
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIlllIIlllIllIIlIIll, final int lllllllllllllIlllIIlllIllIIlIIlI) {
        return new TileEntityComparator();
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lllllllllllllIlllIIlllIlIlllIIII, final BlockPos lllllllllllllIlllIIlllIlIllIllll, final EnumFacing lllllllllllllIlllIIlllIlIllIlllI, final float lllllllllllllIlllIIlllIlIllIllIl, final float lllllllllllllIlllIIlllIlIllIllII, final float lllllllllllllIlllIIlllIlIllIlIll, final int lllllllllllllIlllIIlllIlIllIlIlI, final EntityLivingBase lllllllllllllIlllIIlllIlIllIIlll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, lllllllllllllIlllIIlllIlIllIIlll.getHorizontalFacing().getOpposite()).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, false).withProperty(BlockRedstoneComparator.MODE, Mode.COMPARE);
    }
    
    @Override
    public ItemStack getItem(final World lllllllllllllIlllIIllllIlIIIlllI, final BlockPos lllllllllllllIlllIIllllIlIIIllIl, final IBlockState lllllllllllllIlllIIllllIlIIIllII) {
        return new ItemStack(Items.COMPARATOR);
    }
    
    @Override
    public boolean eventReceived(final IBlockState lllllllllllllIlllIIlllIllIIllIlI, final World lllllllllllllIlllIIlllIllIIllIIl, final BlockPos lllllllllllllIlllIIlllIllIIllIII, final int lllllllllllllIlllIIlllIllIIllllI, final int lllllllllllllIlllIIlllIllIIlIllI) {
        super.eventReceived(lllllllllllllIlllIIlllIllIIllIlI, lllllllllllllIlllIIlllIllIIllIIl, lllllllllllllIlllIIlllIllIIllIII, lllllllllllllIlllIIlllIllIIllllI, lllllllllllllIlllIIlllIllIIlIllI);
        final TileEntity lllllllllllllIlllIIlllIllIIlllII = lllllllllllllIlllIIlllIllIIllIIl.getTileEntity(lllllllllllllIlllIIlllIllIIllIII);
        return lllllllllllllIlllIIlllIllIIlllII != null && lllllllllllllIlllIIlllIllIIlllII.receiveClientEvent(lllllllllllllIlllIIlllIllIIllllI, lllllllllllllIlllIIlllIllIIlIllI);
    }
    
    @Override
    protected IBlockState getUnpoweredState(final IBlockState lllllllllllllIlllIIllllIIlllIIll) {
        final Boolean lllllllllllllIlllIIllllIIlllIllI = lllllllllllllIlllIIllllIIlllIIll.getValue((IProperty<Boolean>)BlockRedstoneComparator.POWERED);
        final Mode lllllllllllllIlllIIllllIIlllIlIl = lllllllllllllIlllIIllllIIlllIIll.getValue(BlockRedstoneComparator.MODE);
        final EnumFacing lllllllllllllIlllIIllllIIlllIlII = lllllllllllllIlllIIllllIIlllIIll.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING);
        return Blocks.UNPOWERED_COMPARATOR.getDefaultState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, lllllllllllllIlllIIllllIIlllIlII).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, lllllllllllllIlllIIllllIIlllIllI).withProperty(BlockRedstoneComparator.MODE, lllllllllllllIlllIIllllIIlllIlIl);
    }
    
    private void onStateChange(final World lllllllllllllIlllIIlllIllllIIIII, final BlockPos lllllllllllllIlllIIlllIlllIlllll, final IBlockState lllllllllllllIlllIIlllIlllIlIlII) {
        final int lllllllllllllIlllIIlllIlllIlllIl = this.calculateOutput(lllllllllllllIlllIIlllIllllIIIII, lllllllllllllIlllIIlllIlllIlllll, lllllllllllllIlllIIlllIlllIlIlII);
        final TileEntity lllllllllllllIlllIIlllIlllIlllII = lllllllllllllIlllIIlllIllllIIIII.getTileEntity(lllllllllllllIlllIIlllIlllIlllll);
        int lllllllllllllIlllIIlllIlllIllIll = 0;
        if (lllllllllllllIlllIIlllIlllIlllII instanceof TileEntityComparator) {
            final TileEntityComparator lllllllllllllIlllIIlllIlllIllIlI = (TileEntityComparator)lllllllllllllIlllIIlllIlllIlllII;
            lllllllllllllIlllIIlllIlllIllIll = lllllllllllllIlllIIlllIlllIllIlI.getOutputSignal();
            lllllllllllllIlllIIlllIlllIllIlI.setOutputSignal(lllllllllllllIlllIIlllIlllIlllIl);
        }
        if (lllllllllllllIlllIIlllIlllIllIll != lllllllllllllIlllIIlllIlllIlllIl || lllllllllllllIlllIIlllIlllIlIlII.getValue(BlockRedstoneComparator.MODE) == Mode.COMPARE) {
            final boolean lllllllllllllIlllIIlllIlllIllIIl = this.shouldBePowered(lllllllllllllIlllIIlllIllllIIIII, lllllllllllllIlllIIlllIlllIlllll, lllllllllllllIlllIIlllIlllIlIlII);
            final boolean lllllllllllllIlllIIlllIlllIllIII = this.isPowered(lllllllllllllIlllIIlllIlllIlIlII);
            if (lllllllllllllIlllIIlllIlllIllIII && !lllllllllllllIlllIIlllIlllIllIIl) {
                lllllllllllllIlllIIlllIllllIIIII.setBlockState(lllllllllllllIlllIIlllIlllIlllll, lllllllllllllIlllIIlllIlllIlIlII.withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, false), 2);
            }
            else if (!lllllllllllllIlllIIlllIlllIllIII && lllllllllllllIlllIIlllIlllIllIIl) {
                lllllllllllllIlllIIlllIllllIIIII.setBlockState(lllllllllllllIlllIIlllIlllIlllll, lllllllllllllIlllIIlllIlllIlIlII.withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, true), 2);
            }
            this.notifyNeighbors(lllllllllllllIlllIIlllIllllIIIII, lllllllllllllIlllIIlllIlllIlllll, lllllllllllllIlllIIlllIlllIlIlII);
        }
    }
    
    public BlockRedstoneComparator(final boolean lllllllllllllIlllIIllllIlIIlIlll) {
        super(lllllllllllllIlllIIllllIlIIlIlll);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockRedstoneComparator.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, false).withProperty(BlockRedstoneComparator.MODE, Mode.COMPARE));
        this.isBlockContainer = true;
    }
    
    @Override
    public Item getItemDropped(final IBlockState lllllllllllllIlllIIllllIlIIlIIlI, final Random lllllllllllllIlllIIllllIlIIlIIIl, final int lllllllllllllIlllIIllllIlIIlIIII) {
        return Items.COMPARATOR;
    }
    
    @Override
    protected boolean isPowered(final IBlockState lllllllllllllIlllIIllllIIllIlIlI) {
        return this.isRepeaterPowered || lllllllllllllIlllIIllllIIllIlIlI.getValue((IProperty<Boolean>)BlockRedstoneComparator.POWERED);
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIlllIIllllIIIIIllll, final BlockPos lllllllllllllIlllIIllllIIIIIIIll, IBlockState lllllllllllllIlllIIllllIIIIIIIlI, final EntityPlayer lllllllllllllIlllIIllllIIIIIIIIl, final EnumHand lllllllllllllIlllIIllllIIIIIlIll, final EnumFacing lllllllllllllIlllIIllllIIIIIlIlI, final float lllllllllllllIlllIIllllIIIIIlIIl, final float lllllllllllllIlllIIllllIIIIIlIII, final float lllllllllllllIlllIIllllIIIIIIlll) {
        if (!lllllllllllllIlllIIllllIIIIIIIIl.capabilities.allowEdit) {
            return false;
        }
        lllllllllllllIlllIIllllIIIIIIIlI = lllllllllllllIlllIIllllIIIIIIIlI.cycleProperty(BlockRedstoneComparator.MODE);
        final float lllllllllllllIlllIIllllIIIIIIllI = (lllllllllllllIlllIIllllIIIIIIIlI.getValue(BlockRedstoneComparator.MODE) == Mode.SUBTRACT) ? 0.55f : 0.5f;
        lllllllllllllIlllIIllllIIIIIllll.playSound(lllllllllllllIlllIIllllIIIIIIIIl, lllllllllllllIlllIIllllIIIIIIIll, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 0.3f, lllllllllllllIlllIIllllIIIIIIllI);
        lllllllllllllIlllIIllllIIIIIllll.setBlockState(lllllllllllllIlllIIllllIIIIIIIll, lllllllllllllIlllIIllllIIIIIIIlI, 2);
        this.onStateChange(lllllllllllllIlllIIllllIIIIIllll, lllllllllllllIlllIIllllIIIIIIIll, lllllllllllllIlllIIllllIIIIIIIlI);
        return true;
    }
    
    @Override
    public void onBlockAdded(final World lllllllllllllIlllIIlllIllIlllIII, final BlockPos lllllllllllllIlllIIlllIllIllIlll, final IBlockState lllllllllllllIlllIIlllIllIlllIlI) {
        super.onBlockAdded(lllllllllllllIlllIIlllIllIlllIII, lllllllllllllIlllIIlllIllIllIlll, lllllllllllllIlllIIlllIllIlllIlI);
        lllllllllllllIlllIIlllIllIlllIII.setTileEntity(lllllllllllllIlllIIlllIllIllIlll, this.createNewTileEntity(lllllllllllllIlllIIlllIllIlllIII, 0));
    }
    
    @Override
    protected int calculateInputStrength(final World lllllllllllllIlllIIllllIIIlIllIl, final BlockPos lllllllllllllIlllIIllllIIIllIlIl, final IBlockState lllllllllllllIlllIIllllIIIllIlII) {
        int lllllllllllllIlllIIllllIIIllIIll = super.calculateInputStrength(lllllllllllllIlllIIllllIIIlIllIl, lllllllllllllIlllIIllllIIIllIlIl, lllllllllllllIlllIIllllIIIllIlII);
        final EnumFacing lllllllllllllIlllIIllllIIIllIIlI = lllllllllllllIlllIIllllIIIllIlII.getValue((IProperty<EnumFacing>)BlockRedstoneComparator.FACING);
        BlockPos lllllllllllllIlllIIllllIIIllIIIl = lllllllllllllIlllIIllllIIIllIlIl.offset(lllllllllllllIlllIIllllIIIllIIlI);
        IBlockState lllllllllllllIlllIIllllIIIllIIII = lllllllllllllIlllIIllllIIIlIllIl.getBlockState(lllllllllllllIlllIIllllIIIllIIIl);
        if (lllllllllllllIlllIIllllIIIllIIII.hasComparatorInputOverride()) {
            lllllllllllllIlllIIllllIIIllIIll = lllllllllllllIlllIIllllIIIllIIII.getComparatorInputOverride(lllllllllllllIlllIIllllIIIlIllIl, lllllllllllllIlllIIllllIIIllIIIl);
        }
        else if (lllllllllllllIlllIIllllIIIllIIll < 15 && lllllllllllllIlllIIllllIIIllIIII.isNormalCube()) {
            lllllllllllllIlllIIllllIIIllIIIl = lllllllllllllIlllIIllllIIIllIIIl.offset(lllllllllllllIlllIIllllIIIllIIlI);
            lllllllllllllIlllIIllllIIIllIIII = lllllllllllllIlllIIllllIIIlIllIl.getBlockState(lllllllllllllIlllIIllllIIIllIIIl);
            if (lllllllllllllIlllIIllllIIIllIIII.hasComparatorInputOverride()) {
                lllllllllllllIlllIIllllIIIllIIll = lllllllllllllIlllIIllllIIIllIIII.getComparatorInputOverride(lllllllllllllIlllIIllllIIIlIllIl, lllllllllllllIlllIIllllIIIllIIIl);
            }
            else if (lllllllllllllIlllIIllllIIIllIIII.getMaterial() == Material.AIR) {
                final EntityItemFrame lllllllllllllIlllIIllllIIIlIllll = this.findItemFrame(lllllllllllllIlllIIllllIIIlIllIl, lllllllllllllIlllIIllllIIIllIIlI, lllllllllllllIlllIIllllIIIllIIIl);
                if (lllllllllllllIlllIIllllIIIlIllll != null) {
                    lllllllllllllIlllIIllllIIIllIIll = lllllllllllllIlllIIllllIIIlIllll.getAnalogOutput();
                }
            }
        }
        return lllllllllllllIlllIIllllIIIllIIll;
    }
    
    @Override
    protected int getActiveSignal(final IBlockAccess lllllllllllllIlllIIllllIIllIIIIl, final BlockPos lllllllllllllIlllIIllllIIllIIlII, final IBlockState lllllllllllllIlllIIllllIIllIIIll) {
        final TileEntity lllllllllllllIlllIIllllIIllIIIlI = lllllllllllllIlllIIllllIIllIIIIl.getTileEntity(lllllllllllllIlllIIllllIIllIIlII);
        return (lllllllllllllIlllIIllllIIllIIIlI instanceof TileEntityComparator) ? ((TileEntityComparator)lllllllllllllIlllIIllllIIllIIIlI).getOutputSignal() : 0;
    }
    
    @Override
    public String getLocalizedName() {
        return I18n.translateToLocal("item.comparator.name");
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockRedstoneComparator.FACING, BlockRedstoneComparator.MODE, BlockRedstoneComparator.POWERED });
    }
    
    @Override
    public void updateTick(final World lllllllllllllIlllIIlllIlllIIlIIl, final BlockPos lllllllllllllIlllIIlllIlllIIIIll, final IBlockState lllllllllllllIlllIIlllIlllIIIlll, final Random lllllllllllllIlllIIlllIlllIIIllI) {
        if (this.isRepeaterPowered) {
            lllllllllllllIlllIIlllIlllIIlIIl.setBlockState(lllllllllllllIlllIIlllIlllIIIIll, this.getUnpoweredState(lllllllllllllIlllIIlllIlllIIIlll).withProperty((IProperty<Comparable>)BlockRedstoneComparator.POWERED, true), 4);
        }
        this.onStateChange(lllllllllllllIlllIIlllIlllIIlIIl, lllllllllllllIlllIIlllIlllIIIIll, lllllllllllllIlllIIlllIlllIIIlll);
    }
    
    public enum Mode implements IStringSerializable
    {
        COMPARE("COMPARE", 0, "compare");
        
        private final /* synthetic */ String name;
        
        SUBTRACT("SUBTRACT", 1, "subtract");
        
        @Override
        public String getName() {
            return this.name;
        }
        
        private Mode(final String lllllllllllllIlllIllIlIlllIlllII, final int lllllllllllllIlllIllIlIlllIllIll, final String lllllllllllllIlllIllIlIlllIllIlI) {
            this.name = lllllllllllllIlllIllIlIlllIllIlI;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }
}
