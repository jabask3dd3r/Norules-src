package net.minecraft.world.chunk;

import net.minecraft.block.state.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import javax.annotation.*;

public class BlockStatePaletteLinear implements IBlockStatePalette
{
    private final /* synthetic */ IBlockStatePaletteResizer resizeHandler;
    private /* synthetic */ int arraySize;
    private final /* synthetic */ int bits;
    private final /* synthetic */ IBlockState[] states;
    
    @Override
    public void write(final PacketBuffer lllllllllllllIIIIIlIlIIlIlIlllIl) {
        lllllllllllllIIIIIlIlIIlIlIlllIl.writeVarIntToBuffer(this.arraySize);
        for (int lllllllllllllIIIIIlIlIIlIlIlllll = 0; lllllllllllllIIIIIlIlIIlIlIlllll < this.arraySize; ++lllllllllllllIIIIIlIlIIlIlIlllll) {
            lllllllllllllIIIIIlIlIIlIlIlllIl.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(this.states[lllllllllllllIIIIIlIlIIlIlIlllll]));
        }
    }
    
    @Override
    public void read(final PacketBuffer lllllllllllllIIIIIlIlIIlIllIlIIl) {
        this.arraySize = lllllllllllllIIIIIlIlIIlIllIlIIl.readVarIntFromBuffer();
        for (int lllllllllllllIIIIIlIlIIlIllIlIII = 0; lllllllllllllIIIIIlIlIIlIllIlIII < this.arraySize; ++lllllllllllllIIIIIlIlIIlIllIlIII) {
            this.states[lllllllllllllIIIIIlIlIIlIllIlIII] = Block.BLOCK_STATE_IDS.getByValue(lllllllllllllIIIIIlIlIIlIllIlIIl.readVarIntFromBuffer());
        }
    }
    
    @Override
    public int idFor(final IBlockState lllllllllllllIIIIIlIlIIlIlllIlIl) {
        for (int lllllllllllllIIIIIlIlIIlIllllIII = 0; lllllllllllllIIIIIlIlIIlIllllIII < this.arraySize; ++lllllllllllllIIIIIlIlIIlIllllIII) {
            if (this.states[lllllllllllllIIIIIlIlIIlIllllIII] == lllllllllllllIIIIIlIlIIlIlllIlIl) {
                return lllllllllllllIIIIIlIlIIlIllllIII;
            }
        }
        final int lllllllllllllIIIIIlIlIIlIlllIlll = this.arraySize;
        if (lllllllllllllIIIIIlIlIIlIlllIlll < this.states.length) {
            this.states[lllllllllllllIIIIIlIlIIlIlllIlll] = lllllllllllllIIIIIlIlIIlIlllIlIl;
            ++this.arraySize;
            return lllllllllllllIIIIIlIlIIlIlllIlll;
        }
        return this.resizeHandler.onResize(this.bits + 1, lllllllllllllIIIIIlIlIIlIlllIlIl);
    }
    
    @Override
    public int getSerializedState() {
        int lllllllllllllIIIIIlIlIIlIlIlIlll = PacketBuffer.getVarIntSize(this.arraySize);
        for (int lllllllllllllIIIIIlIlIIlIlIlIllI = 0; lllllllllllllIIIIIlIlIIlIlIlIllI < this.arraySize; ++lllllllllllllIIIIIlIlIIlIlIlIllI) {
            lllllllllllllIIIIIlIlIIlIlIlIlll += PacketBuffer.getVarIntSize(Block.BLOCK_STATE_IDS.get(this.states[lllllllllllllIIIIIlIlIIlIlIlIllI]));
        }
        return lllllllllllllIIIIIlIlIIlIlIlIlll;
    }
    
    @Nullable
    @Override
    public IBlockState getBlockState(final int lllllllllllllIIIIIlIlIIlIllIlllI) {
        return (lllllllllllllIIIIIlIlIIlIllIlllI >= 0 && lllllllllllllIIIIIlIlIIlIllIlllI < this.arraySize) ? this.states[lllllllllllllIIIIIlIlIIlIllIlllI] : null;
    }
    
    public BlockStatePaletteLinear(final int lllllllllllllIIIIIlIlIIllIIIIIlI, final IBlockStatePaletteResizer lllllllllllllIIIIIlIlIIllIIIIIIl) {
        this.states = new IBlockState[1 << lllllllllllllIIIIIlIlIIllIIIIIlI];
        this.bits = lllllllllllllIIIIIlIlIIllIIIIIlI;
        this.resizeHandler = lllllllllllllIIIIIlIlIIllIIIIIIl;
    }
}
