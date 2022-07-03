package net.minecraft.block;

import net.minecraft.block.properties.*;
import net.minecraft.world.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.material.*;
import net.minecraft.util.*;
import java.util.*;

public class BlockStructure extends BlockContainer
{
    public static final /* synthetic */ PropertyEnum<TileEntityStructure.Mode> MODE;
    
    @Override
    public IBlockState getStateFromMeta(final int llllllllllllllIIllllIllIlIIlllII) {
        return this.getDefaultState().withProperty(BlockStructure.MODE, TileEntityStructure.Mode.getById(llllllllllllllIIllllIllIlIIlllII));
    }
    
    @Override
    public void onBlockPlacedBy(final World llllllllllllllIIllllIllIlIllllII, final BlockPos llllllllllllllIIllllIllIlIlllIll, final IBlockState llllllllllllllIIllllIllIlIlllIlI, final EntityLivingBase llllllllllllllIIllllIllIlIllIIll, final ItemStack llllllllllllllIIllllIllIlIlllIII) {
        if (!llllllllllllllIIllllIllIlIllllII.isRemote) {
            final TileEntity llllllllllllllIIllllIllIlIllIlll = llllllllllllllIIllllIllIlIllllII.getTileEntity(llllllllllllllIIllllIllIlIlllIll);
            if (llllllllllllllIIllllIllIlIllIlll instanceof TileEntityStructure) {
                final TileEntityStructure llllllllllllllIIllllIllIlIllIllI = (TileEntityStructure)llllllllllllllIIllllIllIlIllIlll;
                llllllllllllllIIllllIllIlIllIllI.createdBy(llllllllllllllIIllllIllIlIllIIll);
            }
        }
    }
    
    @Override
    public int getMetaFromState(final IBlockState llllllllllllllIIllllIllIlIIllIIl) {
        return llllllllllllllIIllllIllIlIIllIIl.getValue(BlockStructure.MODE).getModeId();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, (IProperty<?>[])new IProperty[] { BlockStructure.MODE });
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIIllllIllIllIlIIII, final BlockPos llllllllllllllIIllllIllIllIIllll, final IBlockState llllllllllllllIIllllIllIllIIlllI, final EntityPlayer llllllllllllllIIllllIllIllIIIlII, final EnumHand llllllllllllllIIllllIllIllIIllII, final EnumFacing llllllllllllllIIllllIllIllIIlIll, final float llllllllllllllIIllllIllIllIIlIlI, final float llllllllllllllIIllllIllIllIIlIIl, final float llllllllllllllIIllllIllIllIIlIII) {
        final TileEntity llllllllllllllIIllllIllIllIIIlll = llllllllllllllIIllllIllIllIlIIII.getTileEntity(llllllllllllllIIllllIllIllIIllll);
        return llllllllllllllIIllllIllIllIIIlll instanceof TileEntityStructure && ((TileEntityStructure)llllllllllllllIIllllIllIllIIIlll).usedBy(llllllllllllllIIllllIllIllIIIlII);
    }
    
    public BlockStructure() {
        super(Material.IRON, MapColor.SILVER);
        this.setDefaultState(this.blockState.getBaseState());
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllllIIllllIllIlIlIllIl) {
        return EnumBlockRenderType.MODEL;
    }
    
    @Override
    public int quantityDropped(final Random llllllllllllllIIllllIllIlIlIllll) {
        return 0;
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode() {
        final int[] $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = BlockStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        if ($switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode != null) {
            return $switch_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode;
        }
        final double llllllllllllllIIllllIllIIlllIlll = (Object)new int[TileEntityStructure.Mode.values().length];
        try {
            llllllllllllllIIllllIllIIlllIlll[TileEntityStructure.Mode.CORNER.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            llllllllllllllIIllllIllIIlllIlll[TileEntityStructure.Mode.DATA.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            llllllllllllllIIllllIllIIlllIlll[TileEntityStructure.Mode.LOAD.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            llllllllllllllIIllllIllIIlllIlll[TileEntityStructure.Mode.SAVE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockStructure.$SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode = (int[])(Object)llllllllllllllIIllllIllIIlllIlll;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIIllllIllIllIlIlll, final int llllllllllllllIIllllIllIllIlIllI) {
        return new TileEntityStructure();
    }
    
    static {
        MODE = PropertyEnum.create("mode", TileEntityStructure.Mode.class);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIIllllIllIlIIIllII, final World llllllllllllllIIllllIllIlIIIlIll, final BlockPos llllllllllllllIIllllIllIlIIIlIlI, final Block llllllllllllllIIllllIllIlIIIlIIl, final BlockPos llllllllllllllIIllllIllIlIIIlIII) {
        if (!llllllllllllllIIllllIllIlIIIlIll.isRemote) {
            final TileEntity llllllllllllllIIllllIllIlIIIIlll = llllllllllllllIIllllIllIlIIIlIll.getTileEntity(llllllllllllllIIllllIllIlIIIlIlI);
            if (llllllllllllllIIllllIllIlIIIIlll instanceof TileEntityStructure) {
                final TileEntityStructure llllllllllllllIIllllIllIlIIIIllI = (TileEntityStructure)llllllllllllllIIllllIllIlIIIIlll;
                final boolean llllllllllllllIIllllIllIlIIIIlIl = llllllllllllllIIllllIllIlIIIlIll.isBlockPowered(llllllllllllllIIllllIllIlIIIlIlI);
                final boolean llllllllllllllIIllllIllIlIIIIlII = llllllllllllllIIllllIllIlIIIIllI.isPowered();
                if (llllllllllllllIIllllIllIlIIIIlIl && !llllllllllllllIIllllIllIlIIIIlII) {
                    llllllllllllllIIllllIllIlIIIIllI.setPowered(true);
                    this.trigger(llllllllllllllIIllllIllIlIIIIllI);
                }
                else if (!llllllllllllllIIllllIllIlIIIIlIl && llllllllllllllIIllllIllIlIIIIlII) {
                    llllllllllllllIIllllIllIlIIIIllI.setPowered(false);
                }
            }
        }
    }
    
    @Override
    public IBlockState onBlockPlaced(final World llllllllllllllIIllllIllIlIlIlIlI, final BlockPos llllllllllllllIIllllIllIlIlIlIIl, final EnumFacing llllllllllllllIIllllIllIlIlIlIII, final float llllllllllllllIIllllIllIlIlIIlll, final float llllllllllllllIIllllIllIlIlIIllI, final float llllllllllllllIIllllIllIlIlIIlIl, final int llllllllllllllIIllllIllIlIlIIlII, final EntityLivingBase llllllllllllllIIllllIllIlIlIIIll) {
        return this.getDefaultState().withProperty(BlockStructure.MODE, TileEntityStructure.Mode.DATA);
    }
    
    private void trigger(final TileEntityStructure llllllllllllllIIllllIllIIllllIlI) {
        switch ($SWITCH_TABLE$net$minecraft$tileentity$TileEntityStructure$Mode()[llllllllllllllIIllllIllIIllllIlI.getMode().ordinal()]) {
            case 1: {
                llllllllllllllIIllllIllIIllllIlI.save(false);
                break;
            }
            case 2: {
                llllllllllllllIIllllIllIIllllIlI.load(false);
                break;
            }
            case 3: {
                llllllllllllllIIllllIllIIllllIlI.unloadStructure();
                break;
            }
        }
    }
}
