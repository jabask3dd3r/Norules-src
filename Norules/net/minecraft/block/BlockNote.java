package net.minecraft.block;

import java.util.*;
import net.minecraft.world.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.math.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.player.*;
import net.minecraft.stats.*;
import net.minecraft.block.material.*;
import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import com.google.common.collect.*;
import net.minecraft.util.*;

public class BlockNote extends BlockContainer
{
    private static final /* synthetic */ List<SoundEvent> INSTRUMENTS;
    
    @Override
    public TileEntity createNewTileEntity(final World llllllllllllllIlIIllIIlIllIllIlI, final int llllllllllllllIlIIllIIlIllIllIIl) {
        return new TileEntityNote();
    }
    
    @Override
    public boolean onBlockActivated(final World llllllllllllllIlIIllIIlIlllIllIl, final BlockPos llllllllllllllIlIIllIIlIllllIlll, final IBlockState llllllllllllllIlIIllIIlIllllIllI, final EntityPlayer llllllllllllllIlIIllIIlIllllIlIl, final EnumHand llllllllllllllIlIIllIIlIllllIlII, final EnumFacing llllllllllllllIlIIllIIlIllllIIll, final float llllllllllllllIlIIllIIlIllllIIlI, final float llllllllllllllIlIIllIIlIllllIIIl, final float llllllllllllllIlIIllIIlIllllIIII) {
        if (llllllllllllllIlIIllIIlIlllIllIl.isRemote) {
            return true;
        }
        final TileEntity llllllllllllllIlIIllIIlIlllIllll = llllllllllllllIlIIllIIlIlllIllIl.getTileEntity(llllllllllllllIlIIllIIlIllllIlll);
        if (llllllllllllllIlIIllIIlIlllIllll instanceof TileEntityNote) {
            final TileEntityNote llllllllllllllIlIIllIIlIlllIlllI = (TileEntityNote)llllllllllllllIlIIllIIlIlllIllll;
            llllllllllllllIlIIllIIlIlllIlllI.changePitch();
            llllllllllllllIlIIllIIlIlllIlllI.triggerNote(llllllllllllllIlIIllIIlIlllIllIl, llllllllllllllIlIIllIIlIllllIlll);
            llllllllllllllIlIIllIIlIllllIlIl.addStat(StatList.NOTEBLOCK_TUNED);
        }
        return true;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(final IBlockState llllllllllllllIlIIllIIlIllIIIIII) {
        return EnumBlockRenderType.MODEL;
    }
    
    public BlockNote() {
        super(Material.WOOD);
        this.setCreativeTab(CreativeTabs.REDSTONE);
    }
    
    @Override
    public void onBlockClicked(final World llllllllllllllIlIIllIIlIllIlllll, final BlockPos llllllllllllllIlIIllIIlIllIllllI, final EntityPlayer llllllllllllllIlIIllIIlIlllIIIIl) {
        if (!llllllllllllllIlIIllIIlIllIlllll.isRemote) {
            final TileEntity llllllllllllllIlIIllIIlIlllIIIII = llllllllllllllIlIIllIIlIllIlllll.getTileEntity(llllllllllllllIlIIllIIlIllIllllI);
            if (llllllllllllllIlIIllIIlIlllIIIII instanceof TileEntityNote) {
                ((TileEntityNote)llllllllllllllIlIIllIIlIlllIIIII).triggerNote(llllllllllllllIlIIllIIlIllIlllll, llllllllllllllIlIIllIIlIllIllllI);
                llllllllllllllIlIIllIIlIlllIIIIl.addStat(StatList.NOTEBLOCK_PLAYED);
            }
        }
    }
    
    private SoundEvent getInstrument(int llllllllllllllIlIIllIIlIllIlIlIl) {
        if (llllllllllllllIlIIllIIlIllIlIlIl < 0 || llllllllllllllIlIIllIIlIllIlIlIl >= BlockNote.INSTRUMENTS.size()) {
            llllllllllllllIlIIllIIlIllIlIlIl = 0;
        }
        return BlockNote.INSTRUMENTS.get(llllllllllllllIlIIllIIlIllIlIlIl);
    }
    
    @Override
    public void neighborChanged(final IBlockState llllllllllllllIlIIllIIllIIIIlIll, final World llllllllllllllIlIIllIIllIIIIIIll, final BlockPos llllllllllllllIlIIllIIllIIIIlIIl, final Block llllllllllllllIlIIllIIllIIIIlIII, final BlockPos llllllllllllllIlIIllIIllIIIIIlll) {
        final boolean llllllllllllllIlIIllIIllIIIIIllI = llllllllllllllIlIIllIIllIIIIIIll.isBlockPowered(llllllllllllllIlIIllIIllIIIIlIIl);
        final TileEntity llllllllllllllIlIIllIIllIIIIIlIl = llllllllllllllIlIIllIIllIIIIIIll.getTileEntity(llllllllllllllIlIIllIIllIIIIlIIl);
        if (llllllllllllllIlIIllIIllIIIIIlIl instanceof TileEntityNote) {
            final TileEntityNote llllllllllllllIlIIllIIllIIIIIlII = (TileEntityNote)llllllllllllllIlIIllIIllIIIIIlIl;
            if (llllllllllllllIlIIllIIllIIIIIlII.previousRedstoneState != llllllllllllllIlIIllIIllIIIIIllI) {
                if (llllllllllllllIlIIllIIllIIIIIllI) {
                    llllllllllllllIlIIllIIllIIIIIlII.triggerNote(llllllllllllllIlIIllIIllIIIIIIll, llllllllllllllIlIIllIIllIIIIlIIl);
                }
                llllllllllllllIlIIllIIllIIIIIlII.previousRedstoneState = llllllllllllllIlIIllIIllIIIIIllI;
            }
        }
    }
    
    static {
        INSTRUMENTS = Lists.newArrayList((Object[])new SoundEvent[] { SoundEvents.BLOCK_NOTE_HARP, SoundEvents.BLOCK_NOTE_BASEDRUM, SoundEvents.BLOCK_NOTE_SNARE, SoundEvents.BLOCK_NOTE_HAT, SoundEvents.BLOCK_NOTE_BASS, SoundEvents.field_193809_ey, SoundEvents.field_193807_ew, SoundEvents.field_193810_ez, SoundEvents.field_193808_ex, SoundEvents.field_193785_eE });
    }
    
    @Override
    public boolean eventReceived(final IBlockState llllllllllllllIlIIllIIlIllIIllIl, final World llllllllllllllIlIIllIIlIllIIllII, final BlockPos llllllllllllllIlIIllIIlIllIIlIll, final int llllllllllllllIlIIllIIlIllIIIlII, final int llllllllllllllIlIIllIIlIllIIlIIl) {
        final float llllllllllllllIlIIllIIlIllIIlIII = (float)Math.pow(2.0, (llllllllllllllIlIIllIIlIllIIlIIl - 12) / 12.0);
        llllllllllllllIlIIllIIlIllIIllII.playSound(null, llllllllllllllIlIIllIIlIllIIlIll, this.getInstrument(llllllllllllllIlIIllIIlIllIIIlII), SoundCategory.RECORDS, 3.0f, llllllllllllllIlIIllIIlIllIIlIII);
        llllllllllllllIlIIllIIlIllIIllII.spawnParticle(EnumParticleTypes.NOTE, llllllllllllllIlIIllIIlIllIIlIll.getX() + 0.5, llllllllllllllIlIIllIIlIllIIlIll.getY() + 1.2, llllllllllllllIlIIllIIlIllIIlIll.getZ() + 0.5, llllllllllllllIlIIllIIlIllIIlIIl / 24.0, 0.0, 0.0, new int[0]);
        return true;
    }
}
