package net.minecraft.world.chunk;

import net.minecraft.util.*;
import net.minecraft.block.state.*;
import javax.annotation.*;
import net.minecraft.network.*;
import net.minecraft.block.*;

public class BlockStatePaletteHashMap implements IBlockStatePalette
{
    private final /* synthetic */ IntIdentityHashBiMap<IBlockState> statePaletteMap;
    private final /* synthetic */ IBlockStatePaletteResizer paletteResizer;
    private final /* synthetic */ int bits;
    
    @Nullable
    @Override
    public IBlockState getBlockState(final int llllllllllllllllIlIIllIlIIIlIIll) {
        return this.statePaletteMap.get(llllllllllllllllIlIIllIlIIIlIIll);
    }
    
    @Override
    public int getSerializedState() {
        int llllllllllllllllIlIIllIIllIIIIlI = PacketBuffer.getVarIntSize(this.statePaletteMap.size());
        for (int llllllllllllllllIlIIllIIllIIIIII = 0; llllllllllllllllIlIIllIIllIIIIII < this.statePaletteMap.size(); ++llllllllllllllllIlIIllIIllIIIIII) {
            llllllllllllllllIlIIllIIllIIIIlI += PacketBuffer.getVarIntSize(Block.BLOCK_STATE_IDS.get(this.statePaletteMap.get(llllllllllllllllIlIIllIIllIIIIII)));
        }
        return llllllllllllllllIlIIllIIllIIIIlI;
    }
    
    @Override
    public void read(final PacketBuffer llllllllllllllllIlIIllIIlllllIll) {
        this.statePaletteMap.clear();
        for (int llllllllllllllllIlIIllIIlllllIIl = llllllllllllllllIlIIllIIlllllIll.readVarIntFromBuffer(), llllllllllllllllIlIIllIIllllIlll = 0; llllllllllllllllIlIIllIIllllIlll < llllllllllllllllIlIIllIIlllllIIl; ++llllllllllllllllIlIIllIIllllIlll) {
            this.statePaletteMap.add(Block.BLOCK_STATE_IDS.getByValue(llllllllllllllllIlIIllIIlllllIll.readVarIntFromBuffer()));
        }
    }
    
    @Override
    public void write(final PacketBuffer llllllllllllllllIlIIllIIllIlllII) {
        final int llllllllllllllllIlIIllIIllIllIlI = this.statePaletteMap.size();
        llllllllllllllllIlIIllIIllIlllII.writeVarIntToBuffer(llllllllllllllllIlIIllIIllIllIlI);
        for (int llllllllllllllllIlIIllIIllIllIIl = 0; llllllllllllllllIlIIllIIllIllIIl < llllllllllllllllIlIIllIIllIllIlI; ++llllllllllllllllIlIIllIIllIllIIl) {
            llllllllllllllllIlIIllIIllIlllII.writeVarIntToBuffer(Block.BLOCK_STATE_IDS.get(this.statePaletteMap.get(llllllllllllllllIlIIllIIllIllIIl)));
        }
    }
    
    public BlockStatePaletteHashMap(final int llllllllllllllllIlIIllIlIIllIIlI, final IBlockStatePaletteResizer llllllllllllllllIlIIllIlIIllIIII) {
        this.bits = llllllllllllllllIlIIllIlIIllIIlI;
        this.paletteResizer = llllllllllllllllIlIIllIlIIllIIII;
        this.statePaletteMap = new IntIdentityHashBiMap<IBlockState>(1 << llllllllllllllllIlIIllIlIIllIIlI);
    }
    
    @Override
    public int idFor(final IBlockState llllllllllllllllIlIIllIlIIlIIlII) {
        int llllllllllllllllIlIIllIlIIlIIIlI = this.statePaletteMap.getId(llllllllllllllllIlIIllIlIIlIIlII);
        if (llllllllllllllllIlIIllIlIIlIIIlI == -1) {
            llllllllllllllllIlIIllIlIIlIIIlI = this.statePaletteMap.add(llllllllllllllllIlIIllIlIIlIIlII);
            if (llllllllllllllllIlIIllIlIIlIIIlI >= 1 << this.bits) {
                llllllllllllllllIlIIllIlIIlIIIlI = this.paletteResizer.onResize(this.bits + 1, llllllllllllllllIlIIllIlIIlIIlII);
            }
        }
        return llllllllllllllllIlIIllIlIIlIIIlI;
    }
}
