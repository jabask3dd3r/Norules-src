package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import java.util.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import org.apache.logging.log4j.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;

public class BlockCommandBlock extends BlockContainer
{
    public static final /* synthetic */ PropertyBool CONDITIONAL;
    private static final /* synthetic */ Logger field_193388_c;
    public static final /* synthetic */ PropertyDirection FACING;
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockCommandBlock.FACING, BlockCommandBlock.CONDITIONAL });
    }
    
    @Override
    public void neighborChanged(final IBlockState lIIlIlllIIIIIII, final World lIIlIllIlllIllI, final BlockPos lIIlIllIllllllI, final Block lIIlIllIlllllIl, final BlockPos lIIlIllIlllllII) {
        if (!lIIlIllIlllIllI.isRemote) {
            final TileEntity lIIlIllIllllIll = lIIlIllIlllIllI.getTileEntity(lIIlIllIllllllI);
            if (lIIlIllIllllIll instanceof TileEntityCommandBlock) {
                final TileEntityCommandBlock lIIlIllIllllIlI = (TileEntityCommandBlock)lIIlIllIllllIll;
                final boolean lIIlIllIllllIIl = lIIlIllIlllIllI.isBlockPowered(lIIlIllIllllllI);
                final boolean lIIlIllIllllIII = lIIlIllIllllIlI.isPowered();
                lIIlIllIllllIlI.setPowered(lIIlIllIllllIIl);
                if (!lIIlIllIllllIII && !lIIlIllIllllIlI.isAuto() && lIIlIllIllllIlI.getMode() != TileEntityCommandBlock.Mode.SEQUENCE && lIIlIllIllllIIl) {
                    lIIlIllIllllIlI.setConditionMet();
                    lIIlIllIlllIllI.scheduleUpdate(lIIlIllIllllllI, this, this.tickRate(lIIlIllIlllIllI));
                }
            }
        }
    }
    
    @Override
    public void updateTick(final World lIIlIllIlIllIlI, final BlockPos lIIlIllIllIIlII, final IBlockState lIIlIllIlIllIII, final Random lIIlIllIllIIIlI) {
        if (!lIIlIllIlIllIlI.isRemote) {
            final TileEntity lIIlIllIllIIIIl = lIIlIllIlIllIlI.getTileEntity(lIIlIllIllIIlII);
            if (lIIlIllIllIIIIl instanceof TileEntityCommandBlock) {
                final TileEntityCommandBlock lIIlIllIllIIIII = (TileEntityCommandBlock)lIIlIllIllIIIIl;
                final CommandBlockBaseLogic lIIlIllIlIlllll = lIIlIllIllIIIII.getCommandBlockLogic();
                final boolean lIIlIllIlIllllI = !StringUtils.isNullOrEmpty(lIIlIllIlIlllll.getCommand());
                final TileEntityCommandBlock.Mode lIIlIllIlIlllIl = lIIlIllIllIIIII.getMode();
                final boolean lIIlIllIlIlllII = lIIlIllIllIIIII.isConditionMet();
                if (lIIlIllIlIlllIl == TileEntityCommandBlock.Mode.AUTO) {
                    lIIlIllIllIIIII.setConditionMet();
                    if (lIIlIllIlIlllII) {
                        this.func_193387_a(lIIlIllIlIllIII, lIIlIllIlIllIlI, lIIlIllIllIIlII, lIIlIllIlIlllll, lIIlIllIlIllllI);
                    }
                    else if (lIIlIllIllIIIII.isConditional()) {
                        lIIlIllIlIlllll.setSuccessCount(0);
                    }
                    if (lIIlIllIllIIIII.isPowered() || lIIlIllIllIIIII.isAuto()) {
                        lIIlIllIlIllIlI.scheduleUpdate(lIIlIllIllIIlII, this, this.tickRate(lIIlIllIlIllIlI));
                    }
                }
                else if (lIIlIllIlIlllIl == TileEntityCommandBlock.Mode.REDSTONE) {
                    if (lIIlIllIlIlllII) {
                        this.func_193387_a(lIIlIllIlIllIII, lIIlIllIlIllIlI, lIIlIllIllIIlII, lIIlIllIlIlllll, lIIlIllIlIllllI);
                    }
                    else if (lIIlIllIllIIIII.isConditional()) {
                        lIIlIllIlIlllll.setSuccessCount(0);
                    }
                }
                lIIlIllIlIllIlI.updateComparatorOutputLevel(lIIlIllIllIIlII, this);
            }
        }
    }
    
    @Override
    public int tickRate(final World lIIlIllIlIIIIII) {
        return 1;
    }
    
    public BlockCommandBlock(final MapColor lIIlIlllIIlIIIl) {
        super(Material.IRON, lIIlIlllIIlIIIl);
        this.setDefaultState(this.blockState.getBaseState().withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, EnumFacing.NORTH).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, false));
    }
    
    @Override
    public IBlockState getStateFromMeta(final int lIIlIlIlllllIll) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, EnumFacing.getFront(lIIlIlIlllllIll & 0x7)).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, (lIIlIlIlllllIll & 0x8) != 0x0);
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lIIlIlllIIIllIl, final int lIIlIlllIIIllII) {
        final TileEntityCommandBlock lIIlIlllIIIlIll = new TileEntityCommandBlock();
        lIIlIlllIIIlIll.setAuto(this == Blocks.CHAIN_COMMAND_BLOCK);
        return lIIlIlllIIIlIll;
    }
    
    @Override
    public int quantityDropped(final Random lIIlIllIIIIIIIl) {
        return 0;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lIIlIlIllllllll) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public IBlockState withMirror(final IBlockState lIIlIlIlllIlIlI, final Mirror lIIlIlIlllIIlll) {
        return lIIlIlIlllIlIlI.withRotation(lIIlIlIlllIIlll.toRotation(lIIlIlIlllIlIlI.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING)));
    }
    
    @Override
    public IBlockState withRotation(final IBlockState lIIlIlIlllIllll, final Rotation lIIlIlIlllIlllI) {
        return lIIlIlIlllIllll.withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, lIIlIlIlllIlllI.rotate(lIIlIlIlllIllll.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING)));
    }
    
    static {
        field_193388_c = LogManager.getLogger();
        FACING = BlockDirectional.FACING;
        CONDITIONAL = PropertyBool.create("conditional");
    }
    
    private static void func_193386_c(final World lIIlIlIlIllllIl, final BlockPos lIIlIlIllIIlIII, EnumFacing lIIlIlIlIlllIll) {
        final BlockPos.MutableBlockPos lIIlIlIllIIIllI = new BlockPos.MutableBlockPos(lIIlIlIllIIlIII);
        final GameRules lIIlIlIllIIIlIl = lIIlIlIlIllllIl.getGameRules();
        int lIIlIlIllIIIlII = lIIlIlIllIIIlIl.getInt("maxCommandChainLength");
        while (lIIlIlIllIIIlII-- > 0) {
            lIIlIlIllIIIllI.move(lIIlIlIlIlllIll);
            final IBlockState lIIlIlIllIIIIll = lIIlIlIlIllllIl.getBlockState(lIIlIlIllIIIllI);
            final Block lIIlIlIllIIIIlI = lIIlIlIllIIIIll.getBlock();
            if (lIIlIlIllIIIIlI != Blocks.CHAIN_COMMAND_BLOCK) {
                break;
            }
            final TileEntity lIIlIlIllIIIIIl = lIIlIlIlIllllIl.getTileEntity(lIIlIlIllIIIllI);
            if (!(lIIlIlIllIIIIIl instanceof TileEntityCommandBlock)) {
                break;
            }
            final TileEntityCommandBlock lIIlIlIllIIIIII = (TileEntityCommandBlock)lIIlIlIllIIIIIl;
            if (lIIlIlIllIIIIII.getMode() != TileEntityCommandBlock.Mode.SEQUENCE) {
                break;
            }
            if (lIIlIlIllIIIIII.isPowered() || lIIlIlIllIIIIII.isAuto()) {
                final CommandBlockBaseLogic lIIlIlIlIllllll = lIIlIlIllIIIIII.getCommandBlockLogic();
                if (lIIlIlIllIIIIII.setConditionMet()) {
                    if (!lIIlIlIlIllllll.trigger(lIIlIlIlIllllIl)) {
                        break;
                    }
                    lIIlIlIlIllllIl.updateComparatorOutputLevel(lIIlIlIllIIIllI, lIIlIlIllIIIIlI);
                }
                else if (lIIlIlIllIIIIII.isConditional()) {
                    lIIlIlIlIllllll.setSuccessCount(0);
                }
            }
            lIIlIlIlIlllIll = lIIlIlIllIIIIll.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING);
        }
        if (lIIlIlIllIIIlII <= 0) {
            final int lIIlIlIlIlllllI = Math.max(lIIlIlIllIIIlIl.getInt("maxCommandChainLength"), 0);
            BlockCommandBlock.field_193388_c.warn(String.valueOf(new StringBuilder("Commandblock chain tried to execure more than ").append(lIIlIlIlIlllllI).append(" steps!")));
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World lIIlIlIllIlllll, final BlockPos lIIlIlIllIlIllI, final EnumFacing lIIlIlIllIlllIl, final float lIIlIlIllIlllII, final float lIIlIlIllIllIll, final float lIIlIlIllIllIlI, final int lIIlIlIllIllIIl, final EntityLivingBase lIIlIlIllIlIlIl) {
        return this.getDefaultState().withProperty((IProperty<Comparable>)BlockCommandBlock.FACING, EnumFacing.func_190914_a(lIIlIlIllIlIllI, lIIlIlIllIlIlIl)).withProperty((IProperty<Comparable>)BlockCommandBlock.CONDITIONAL, false);
    }
    
    @Override
    public boolean onBlockActivated(final World lIIlIllIIlllIlI, final BlockPos lIIlIllIIlllIIl, final IBlockState lIIlIllIIlllIII, final EntityPlayer lIIlIllIIllIlll, final EnumHand lIIlIllIIllIllI, final EnumFacing lIIlIllIIllIlIl, final float lIIlIllIIllIlII, final float lIIlIllIIllIIll, final float lIIlIllIIllIIlI) {
        final TileEntity lIIlIllIIllIIIl = lIIlIllIIlllIlI.getTileEntity(lIIlIllIIlllIIl);
        if (lIIlIllIIllIIIl instanceof TileEntityCommandBlock && lIIlIllIIllIlll.canUseCommandBlock()) {
            lIIlIllIIllIlll.displayGuiCommandBlock((TileEntityCommandBlock)lIIlIllIIllIIIl);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean hasComparatorInputOverride(final IBlockState lIIlIllIIlIlIll) {
        return true;
    }
    
    @Override
    public int getComparatorInputOverride(final IBlockState lIIlIllIIlIIllI, final World lIIlIllIIlIIIlI, final BlockPos lIIlIllIIlIIIIl) {
        final TileEntity lIIlIllIIlIIIll = lIIlIllIIlIIIlI.getTileEntity(lIIlIllIIlIIIIl);
        return (lIIlIllIIlIIIll instanceof TileEntityCommandBlock) ? ((TileEntityCommandBlock)lIIlIllIIlIIIll).getCommandBlockLogic().getSuccessCount() : 0;
    }
    
    private void func_193387_a(final IBlockState lIIlIllIlIIlIll, final World lIIlIllIlIIIlIl, final BlockPos lIIlIllIlIIlIIl, final CommandBlockBaseLogic lIIlIllIlIIIIll, final boolean lIIlIllIlIIIIlI) {
        if (lIIlIllIlIIIIlI) {
            lIIlIllIlIIIIll.trigger(lIIlIllIlIIIlIl);
        }
        else {
            lIIlIllIlIIIIll.setSuccessCount(0);
        }
        func_193386_c(lIIlIllIlIIIlIl, lIIlIllIlIIlIIl, lIIlIllIlIIlIll.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING));
    }
    
    @Override
    public int getMetaFromState(final IBlockState lIIlIlIllllIlIl) {
        return lIIlIlIllllIlIl.getValue((IProperty<EnumFacing>)BlockCommandBlock.FACING).getIndex() | (lIIlIlIllllIlIl.getValue((IProperty<Boolean>)BlockCommandBlock.CONDITIONAL) ? 8 : 0);
    }
    
    @Override
    public void onBlockPlacedBy(final World lIIlIllIIIlIlIl, final BlockPos lIIlIllIIIlIlII, final IBlockState lIIlIllIIIlIIll, final EntityLivingBase lIIlIllIIIlIIlI, final ItemStack lIIlIllIIIIlIII) {
        final TileEntity lIIlIllIIIlIIII = lIIlIllIIIlIlIl.getTileEntity(lIIlIllIIIlIlII);
        if (lIIlIllIIIlIIII instanceof TileEntityCommandBlock) {
            final TileEntityCommandBlock lIIlIllIIIIllll = (TileEntityCommandBlock)lIIlIllIIIlIIII;
            final CommandBlockBaseLogic lIIlIllIIIIlllI = lIIlIllIIIIllll.getCommandBlockLogic();
            if (lIIlIllIIIIlIII.hasDisplayName()) {
                lIIlIllIIIIlllI.setName(lIIlIllIIIIlIII.getDisplayName());
            }
            if (!lIIlIllIIIlIlIl.isRemote) {
                final NBTTagCompound lIIlIllIIIIllIl = lIIlIllIIIIlIII.getTagCompound();
                if (lIIlIllIIIIllIl == null || !lIIlIllIIIIllIl.hasKey("BlockEntityTag", 10)) {
                    lIIlIllIIIIlllI.setTrackOutput(lIIlIllIIIlIlIl.getGameRules().getBoolean("sendCommandFeedback"));
                    lIIlIllIIIIllll.setAuto(this == Blocks.CHAIN_COMMAND_BLOCK);
                }
                if (lIIlIllIIIIllll.getMode() == TileEntityCommandBlock.Mode.SEQUENCE) {
                    final boolean lIIlIllIIIIllII = lIIlIllIIIlIlIl.isBlockPowered(lIIlIllIIIlIlII);
                    lIIlIllIIIIllll.setPowered(lIIlIllIIIIllII);
                }
            }
        }
    }
}
