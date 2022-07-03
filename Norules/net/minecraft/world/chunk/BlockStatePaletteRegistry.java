package net.minecraft.world.chunk;

import net.minecraft.network.*;
import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.init.*;

public class BlockStatePaletteRegistry implements IBlockStatePalette
{
    @Override
    public void read(final PacketBuffer llllllllllllllIllIIIllIIlllIIIIl) {
        llllllllllllllIllIIIllIIlllIIIIl.readVarIntFromBuffer();
    }
    
    @Override
    public void write(final PacketBuffer llllllllllllllIllIIIllIIllIlllII) {
        llllllllllllllIllIIIllIIllIlllII.writeVarIntToBuffer(0);
    }
    
    @Override
    public int getSerializedState() {
        return PacketBuffer.getVarIntSize(0);
    }
    
    @Override
    public int idFor(final IBlockState llllllllllllllIllIIIllIIlllIlllI) {
        final int llllllllllllllIllIIIllIIlllIllIl = Block.BLOCK_STATE_IDS.get(llllllllllllllIllIIIllIIlllIlllI);
        return (llllllllllllllIllIIIllIIlllIllIl == -1) ? 0 : llllllllllllllIllIIIllIIlllIllIl;
    }
    
    @Override
    public IBlockState getBlockState(final int llllllllllllllIllIIIllIIlllIIlIl) {
        final IBlockState llllllllllllllIllIIIllIIlllIIllI = Block.BLOCK_STATE_IDS.getByValue(llllllllllllllIllIIIllIIlllIIlIl);
        return (llllllllllllllIllIIIllIIlllIIllI == null) ? Blocks.AIR.getDefaultState() : llllllllllllllIllIIIllIIlllIIllI;
    }
}
