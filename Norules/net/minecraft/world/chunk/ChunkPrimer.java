package net.minecraft.world.chunk;

import net.minecraft.block.state.*;
import net.minecraft.block.*;
import net.minecraft.init.*;

public class ChunkPrimer
{
    private static final /* synthetic */ IBlockState DEFAULT_STATE;
    private final /* synthetic */ char[] data;
    
    public IBlockState getBlockState(final int lllllllllllllIIlllllIlIlllIIlIII, final int lllllllllllllIIlllllIlIlllIIIlll, final int lllllllllllllIIlllllIlIlllIIlIll) {
        final IBlockState lllllllllllllIIlllllIlIlllIIlIlI = Block.BLOCK_STATE_IDS.getByValue(this.data[getBlockIndex(lllllllllllllIIlllllIlIlllIIlIII, lllllllllllllIIlllllIlIlllIIIlll, lllllllllllllIIlllllIlIlllIIlIll)]);
        return (lllllllllllllIIlllllIlIlllIIlIlI == null) ? ChunkPrimer.DEFAULT_STATE : lllllllllllllIIlllllIlIlllIIlIlI;
    }
    
    private static int getBlockIndex(final int lllllllllllllIIlllllIlIllIlIllll, final int lllllllllllllIIlllllIlIllIlIlllI, final int lllllllllllllIIlllllIlIllIllIIII) {
        return lllllllllllllIIlllllIlIllIlIllll << 12 | lllllllllllllIIlllllIlIllIllIIII << 8 | lllllllllllllIIlllllIlIllIlIlllI;
    }
    
    public ChunkPrimer() {
        this.data = new char[65536];
    }
    
    public int findGroundBlockIdx(final int lllllllllllllIIlllllIlIllIlIIlIl, final int lllllllllllllIIlllllIlIllIlIIlII) {
        final int lllllllllllllIIlllllIlIllIlIIIll = (lllllllllllllIIlllllIlIllIlIIlIl << 12 | lllllllllllllIIlllllIlIllIlIIlII << 8) + 256 - 1;
        for (int lllllllllllllIIlllllIlIllIlIIIlI = 255; lllllllllllllIIlllllIlIllIlIIIlI >= 0; --lllllllllllllIIlllllIlIllIlIIIlI) {
            final IBlockState lllllllllllllIIlllllIlIllIlIIIIl = Block.BLOCK_STATE_IDS.getByValue(this.data[lllllllllllllIIlllllIlIllIlIIIll + lllllllllllllIIlllllIlIllIlIIIlI]);
            if (lllllllllllllIIlllllIlIllIlIIIIl != null && lllllllllllllIIlllllIlIllIlIIIIl != ChunkPrimer.DEFAULT_STATE) {
                return lllllllllllllIIlllllIlIllIlIIIlI;
            }
        }
        return 0;
    }
    
    public void setBlockState(final int lllllllllllllIIlllllIlIllIlllllI, final int lllllllllllllIIlllllIlIllIlllIII, final int lllllllllllllIIlllllIlIllIllIlll, final IBlockState lllllllllllllIIlllllIlIllIlllIll) {
        this.data[getBlockIndex(lllllllllllllIIlllllIlIllIlllllI, lllllllllllllIIlllllIlIllIlllIII, lllllllllllllIIlllllIlIllIllIlll)] = (char)Block.BLOCK_STATE_IDS.get(lllllllllllllIIlllllIlIllIlllIll);
    }
    
    static {
        DEFAULT_STATE = Blocks.AIR.getDefaultState();
    }
}
