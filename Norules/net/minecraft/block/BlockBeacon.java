package net.minecraft.block;

import net.minecraft.block.state.*;
import net.minecraft.util.math.*;
import net.minecraft.tileentity.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.world.*;
import net.minecraft.world.chunk.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.stats.*;
import net.minecraft.util.*;

public class BlockBeacon extends BlockContainer
{
    @Override
    public void neighborChanged(final IBlockState lllllllllllllIIIlIllIIlIIlIIIIlI, final World lllllllllllllIIIlIllIIlIIlIIIIIl, final BlockPos lllllllllllllIIIlIllIIlIIIlllIlI, final Block lllllllllllllIIIlIllIIlIIIllllll, final BlockPos lllllllllllllIIIlIllIIlIIIlllllI) {
        final TileEntity lllllllllllllIIIlIllIIlIIIllllIl = lllllllllllllIIIlIllIIlIIlIIIIIl.getTileEntity(lllllllllllllIIIlIllIIlIIIlllIlI);
        if (lllllllllllllIIIlIllIIlIIIllllIl instanceof TileEntityBeacon) {
            ((TileEntityBeacon)lllllllllllllIIIlIllIIlIIIllllIl).updateBeacon();
            lllllllllllllIIIlIllIIlIIlIIIIIl.addBlockEvent(lllllllllllllIIIlIllIIlIIIlllIlI, this, 1, 0);
        }
    }
    
    public BlockBeacon() {
        super(Material.GLASS, MapColor.DIAMOND);
        this.setHardness(3.0f);
        this.setCreativeTab(CreativeTabs.MISC);
    }
    
    public static void updateColorAsync(final World lllllllllllllIIIlIllIIlIIIllIlIl, final BlockPos lllllllllllllIIIlIllIIlIIIllIIlI) {
        HttpUtil.DOWNLOADER_EXECUTOR.submit((Runnable)new Runnable() {
            @Override
            public void run() {
                final Chunk llllllllllllllIIIlIlIlllIIIlIlll = lllllllllllllIIIlIllIIlIIIllIlIl.getChunkFromBlockCoords(lllllllllllllIIIlIllIIlIIIllIIlI);
                for (int llllllllllllllIIIlIlIlllIIIlIllI = lllllllllllllIIIlIllIIlIIIllIIlI.getY() - 1; llllllllllllllIIIlIlIlllIIIlIllI >= 0; --llllllllllllllIIIlIlIlllIIIlIllI) {
                    final BlockPos llllllllllllllIIIlIlIlllIIIlIlIl = new BlockPos(lllllllllllllIIIlIllIIlIIIllIIlI.getX(), llllllllllllllIIIlIlIlllIIIlIllI, lllllllllllllIIIlIllIIlIIIllIIlI.getZ());
                    if (!llllllllllllllIIIlIlIlllIIIlIlll.canSeeSky(llllllllllllllIIIlIlIlllIIIlIlIl)) {
                        break;
                    }
                    final IBlockState llllllllllllllIIIlIlIlllIIIlIlII = lllllllllllllIIIlIllIIlIIIllIlIl.getBlockState(llllllllllllllIIIlIlIlllIIIlIlIl);
                    if (llllllllllllllIIIlIlIlllIIIlIlII.getBlock() == Blocks.BEACON) {
                        ((WorldServer)lllllllllllllIIIlIllIIlIIIllIlIl).addScheduledTask(new Runnable() {
                            @Override
                            public void run() {
                                final TileEntity lllllllllllllIllllIIlIIIIlIIllII = lllllllllllllIIIlIllIIlIIIllIlIl.getTileEntity(llllllllllllllIIIlIlIlllIIIlIlIl);
                                if (lllllllllllllIllllIIlIIIIlIIllII instanceof TileEntityBeacon) {
                                    ((TileEntityBeacon)lllllllllllllIllllIIlIIIIlIIllII).updateBeacon();
                                    lllllllllllllIIIlIllIIlIIIllIlIl.addBlockEvent(llllllllllllllIIIlIlIlllIIIlIlIl, Blocks.BEACON, 1, 0);
                                }
                            }
                        });
                    }
                }
            }
        });
    }
    
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public boolean isOpaqueCube(final IBlockState lllllllllllllIIIlIllIIlIIllIIIIl) {
        return false;
    }
    
    @Override
    public void onBlockPlacedBy(final World lllllllllllllIIIlIllIIlIIlIIllIl, final BlockPos lllllllllllllIIIlIllIIlIIlIlIIll, final IBlockState lllllllllllllIIIlIllIIlIIlIlIIlI, final EntityLivingBase lllllllllllllIIIlIllIIlIIlIIlIlI, final ItemStack lllllllllllllIIIlIllIIlIIlIlIIII) {
        super.onBlockPlacedBy(lllllllllllllIIIlIllIIlIIlIIllIl, lllllllllllllIIIlIllIIlIIlIlIIll, lllllllllllllIIIlIllIIlIIlIlIIlI, lllllllllllllIIIlIllIIlIIlIIlIlI, lllllllllllllIIIlIllIIlIIlIlIIII);
        if (lllllllllllllIIIlIllIIlIIlIlIIII.hasDisplayName()) {
            final TileEntity lllllllllllllIIIlIllIIlIIlIIllll = lllllllllllllIIIlIllIIlIIlIIllIl.getTileEntity(lllllllllllllIIIlIllIIlIIlIlIIll);
            if (lllllllllllllIIIlIllIIlIIlIIllll instanceof TileEntityBeacon) {
                ((TileEntityBeacon)lllllllllllllIIIlIllIIlIIlIIllll).setName(lllllllllllllIIIlIllIIlIIlIlIIII.getDisplayName());
            }
        }
    }
    
    @Override
    public boolean isFullCube(final IBlockState lllllllllllllIIIlIllIIlIIlIlllll) {
        return false;
    }
    
    @Override
    public boolean onBlockActivated(final World lllllllllllllIIIlIllIIlIIlllIIII, final BlockPos lllllllllllllIIIlIllIIlIIllIllll, final IBlockState lllllllllllllIIIlIllIIlIIllIlllI, final EntityPlayer lllllllllllllIIIlIllIIlIIllIIlII, final EnumHand lllllllllllllIIIlIllIIlIIllIllII, final EnumFacing lllllllllllllIIIlIllIIlIIllIlIll, final float lllllllllllllIIIlIllIIlIIllIlIlI, final float lllllllllllllIIIlIllIIlIIllIlIIl, final float lllllllllllllIIIlIllIIlIIllIlIII) {
        if (lllllllllllllIIIlIllIIlIIlllIIII.isRemote) {
            return true;
        }
        final TileEntity lllllllllllllIIIlIllIIlIIllIIlll = lllllllllllllIIIlIllIIlIIlllIIII.getTileEntity(lllllllllllllIIIlIllIIlIIllIllll);
        if (lllllllllllllIIIlIllIIlIIllIIlll instanceof TileEntityBeacon) {
            lllllllllllllIIIlIllIIlIIllIIlII.displayGUIChest((IInventory)lllllllllllllIIIlIllIIlIIllIIlll);
            lllllllllllllIIIlIllIIlIIllIIlII.addStat(StatList.BEACON_INTERACTION);
        }
        return true;
    }
    
    @Override
    public TileEntity createNewTileEntity(final World lllllllllllllIIIlIllIIlIIlllIlll, final int lllllllllllllIIIlIllIIlIIlllIllI) {
        return new TileEntityBeacon();
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState lllllllllllllIIIlIllIIlIIlIlllIl) {
        return EnumBlockRenderType.MODEL;
    }
}
