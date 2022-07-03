package net.minecraft.tileentity;

import net.minecraft.world.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.math.*;

public class TileEntityNote extends TileEntity
{
    public /* synthetic */ boolean previousRedstoneState;
    public /* synthetic */ byte note;
    
    public void triggerNote(final World llllllllllllllIIIIlIIlIlIlIllIll, final BlockPos llllllllllllllIIIIlIIlIlIlIllIlI) {
        if (llllllllllllllIIIIlIIlIlIlIllIll.getBlockState(llllllllllllllIIIIlIIlIlIlIllIlI.up()).getMaterial() == Material.AIR) {
            final IBlockState llllllllllllllIIIIlIIlIlIllIIIII = llllllllllllllIIIIlIIlIlIlIllIll.getBlockState(llllllllllllllIIIIlIIlIlIlIllIlI.down());
            final Material llllllllllllllIIIIlIIlIlIlIlllll = llllllllllllllIIIIlIIlIlIllIIIII.getMaterial();
            int llllllllllllllIIIIlIIlIlIlIllllI = 0;
            if (llllllllllllllIIIIlIIlIlIlIlllll == Material.ROCK) {
                llllllllllllllIIIIlIIlIlIlIllllI = 1;
            }
            if (llllllllllllllIIIIlIIlIlIlIlllll == Material.SAND) {
                llllllllllllllIIIIlIIlIlIlIllllI = 2;
            }
            if (llllllllllllllIIIIlIIlIlIlIlllll == Material.GLASS) {
                llllllllllllllIIIIlIIlIlIlIllllI = 3;
            }
            if (llllllllllllllIIIIlIIlIlIlIlllll == Material.WOOD) {
                llllllllllllllIIIIlIIlIlIlIllllI = 4;
            }
            final Block llllllllllllllIIIIlIIlIlIlIlllIl = llllllllllllllIIIIlIIlIlIllIIIII.getBlock();
            if (llllllllllllllIIIIlIIlIlIlIlllIl == Blocks.CLAY) {
                llllllllllllllIIIIlIIlIlIlIllllI = 5;
            }
            if (llllllllllllllIIIIlIIlIlIlIlllIl == Blocks.GOLD_BLOCK) {
                llllllllllllllIIIIlIIlIlIlIllllI = 6;
            }
            if (llllllllllllllIIIIlIIlIlIlIlllIl == Blocks.WOOL) {
                llllllllllllllIIIIlIIlIlIlIllllI = 7;
            }
            if (llllllllllllllIIIIlIIlIlIlIlllIl == Blocks.PACKED_ICE) {
                llllllllllllllIIIIlIIlIlIlIllllI = 8;
            }
            if (llllllllllllllIIIIlIIlIlIlIlllIl == Blocks.BONE_BLOCK) {
                llllllllllllllIIIIlIIlIlIlIllllI = 9;
            }
            llllllllllllllIIIIlIIlIlIlIllIll.addBlockEvent(llllllllllllllIIIIlIIlIlIlIllIlI, Blocks.NOTEBLOCK, llllllllllllllIIIIlIIlIlIlIllllI, this.note);
        }
    }
    
    public void changePitch() {
        this.note = (byte)((this.note + 1) % 25);
        this.markDirty();
    }
    
    @Override
    public void readFromNBT(final NBTTagCompound llllllllllllllIIIIlIIlIlIllIlllI) {
        super.readFromNBT(llllllllllllllIIIIlIIlIlIllIlllI);
        this.note = llllllllllllllIIIIlIIlIlIllIlllI.getByte("note");
        this.note = (byte)MathHelper.clamp(this.note, 0, 24);
        this.previousRedstoneState = llllllllllllllIIIIlIIlIlIllIlllI.getBoolean("powered");
    }
    
    @Override
    public NBTTagCompound writeToNBT(final NBTTagCompound llllllllllllllIIIIlIIlIlIlllIllI) {
        super.writeToNBT(llllllllllllllIIIIlIIlIlIlllIllI);
        llllllllllllllIIIIlIIlIlIlllIllI.setByte("note", this.note);
        llllllllllllllIIIIlIIlIlIlllIllI.setBoolean("powered", this.previousRedstoneState);
        return llllllllllllllIIIIlIIlIlIlllIllI;
    }
}
