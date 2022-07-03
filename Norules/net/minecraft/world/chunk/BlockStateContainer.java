package net.minecraft.world.chunk;

import net.minecraft.util.*;
import net.minecraft.block.state.*;
import net.minecraft.network.*;
import net.minecraft.block.*;
import javax.annotation.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;

public class BlockStateContainer implements IBlockStatePaletteResizer
{
    private static final /* synthetic */ IBlockStatePalette REGISTRY_BASED_PALETTE;
    protected /* synthetic */ BitArray storage;
    private /* synthetic */ int bits;
    protected static final /* synthetic */ IBlockState AIR_BLOCK_STATE;
    protected /* synthetic */ IBlockStatePalette palette;
    
    public void write(final PacketBuffer lllllllllllllllIlIlllllIllIIIIll) {
        lllllllllllllllIlIlllllIllIIIIll.writeByte(this.bits);
        this.palette.write(lllllllllllllllIlIlllllIllIIIIll);
        lllllllllllllllIlIlllllIllIIIIll.writeLongArray(this.storage.getBackingLongArray());
    }
    
    public int getSerializedSize() {
        return 1 + this.palette.getSerializedState() + PacketBuffer.getVarIntSize(this.storage.size()) + this.storage.getBackingLongArray().length * 8;
    }
    
    @Nullable
    public NibbleArray getDataForNBT(final byte[] lllllllllllllllIlIlllllIlIlIIIlI, final NibbleArray lllllllllllllllIlIlllllIlIIllIII) {
        NibbleArray lllllllllllllllIlIlllllIlIlIIIII = null;
        for (int lllllllllllllllIlIlllllIlIIlllll = 0; lllllllllllllllIlIlllllIlIIlllll < 4096; ++lllllllllllllllIlIlllllIlIIlllll) {
            final int lllllllllllllllIlIlllllIlIIllllI = Block.BLOCK_STATE_IDS.get(this.get(lllllllllllllllIlIlllllIlIIlllll));
            final int lllllllllllllllIlIlllllIlIIlllIl = lllllllllllllllIlIlllllIlIIlllll & 0xF;
            final int lllllllllllllllIlIlllllIlIIlllII = lllllllllllllllIlIlllllIlIIlllll >> 8 & 0xF;
            final int lllllllllllllllIlIlllllIlIIllIll = lllllllllllllllIlIlllllIlIIlllll >> 4 & 0xF;
            if ((lllllllllllllllIlIlllllIlIIllllI >> 12 & 0xF) != 0x0) {
                if (lllllllllllllllIlIlllllIlIlIIIII == null) {
                    lllllllllllllllIlIlllllIlIlIIIII = new NibbleArray();
                }
                lllllllllllllllIlIlllllIlIlIIIII.set(lllllllllllllllIlIlllllIlIIlllIl, lllllllllllllllIlIlllllIlIIlllII, lllllllllllllllIlIlllllIlIIllIll, lllllllllllllllIlIlllllIlIIllllI >> 12 & 0xF);
            }
            lllllllllllllllIlIlllllIlIlIIIlI[lllllllllllllllIlIlllllIlIIlllll] = (byte)(lllllllllllllllIlIlllllIlIIllllI >> 4 & 0xFF);
            lllllllllllllllIlIlllllIlIIllIII.set(lllllllllllllllIlIlllllIlIIlllIl, lllllllllllllllIlIlllllIlIIlllII, lllllllllllllllIlIlllllIlIIllIll, lllllllllllllllIlIlllllIlIIllllI & 0xF);
        }
        return lllllllllllllllIlIlllllIlIlIIIII;
    }
    
    protected IBlockState get(final int lllllllllllllllIlIlllllIlllIIIIl) {
        final IBlockState lllllllllllllllIlIlllllIlllIIlIl = this.palette.getBlockState(this.storage.getAt(lllllllllllllllIlIlllllIlllIIIIl));
        return (lllllllllllllllIlIlllllIlllIIlIl == null) ? BlockStateContainer.AIR_BLOCK_STATE : lllllllllllllllIlIlllllIlllIIlIl;
    }
    
    public void setDataFromNBT(final byte[] lllllllllllllllIlIlllllIIlllIlIl, final NibbleArray lllllllllllllllIlIlllllIIllllllI, @Nullable final NibbleArray lllllllllllllllIlIlllllIIlllIIll) {
        for (int lllllllllllllllIlIlllllIIlllllII = 0; lllllllllllllllIlIlllllIIlllllII < 4096; ++lllllllllllllllIlIlllllIIlllllII) {
            final int lllllllllllllllIlIlllllIIllllIll = lllllllllllllllIlIlllllIIlllllII & 0xF;
            final int lllllllllllllllIlIlllllIIllllIlI = lllllllllllllllIlIlllllIIlllllII >> 8 & 0xF;
            final int lllllllllllllllIlIlllllIIllllIIl = lllllllllllllllIlIlllllIIlllllII >> 4 & 0xF;
            final int lllllllllllllllIlIlllllIIllllIII = (lllllllllllllllIlIlllllIIlllIIll == null) ? 0 : lllllllllllllllIlIlllllIIlllIIll.get(lllllllllllllllIlIlllllIIllllIll, lllllllllllllllIlIlllllIIllllIlI, lllllllllllllllIlIlllllIIllllIIl);
            final int lllllllllllllllIlIlllllIIlllIlll = lllllllllllllllIlIlllllIIllllIII << 12 | (lllllllllllllllIlIlllllIIlllIlIl[lllllllllllllllIlIlllllIIlllllII] & 0xFF) << 4 | lllllllllllllllIlIlllllIIllllllI.get(lllllllllllllllIlIlllllIIllllIll, lllllllllllllllIlIlllllIIllllIlI, lllllllllllllllIlIlllllIIllllIIl);
            this.set(lllllllllllllllIlIlllllIIlllllII, Block.BLOCK_STATE_IDS.getByValue(lllllllllllllllIlIlllllIIlllIlll));
        }
    }
    
    static {
        REGISTRY_BASED_PALETTE = new BlockStatePaletteRegistry();
        AIR_BLOCK_STATE = Blocks.AIR.getDefaultState();
    }
    
    public void read(final PacketBuffer lllllllllllllllIlIlllllIllIlIIII) {
        final int lllllllllllllllIlIlllllIllIIlllI = lllllllllllllllIlIlllllIllIlIIII.readByte();
        if (this.bits != lllllllllllllllIlIlllllIllIIlllI) {
            this.setBits(lllllllllllllllIlIlllllIllIIlllI);
        }
        this.palette.read(lllllllllllllllIlIlllllIllIlIIII);
        lllllllllllllllIlIlllllIllIlIIII.readLongArray(this.storage.getBackingLongArray());
    }
    
    private static int getIndex(final int lllllllllllllllIlIllllllIllIlIll, final int lllllllllllllllIlIllllllIllIIlIl, final int lllllllllllllllIlIllllllIllIlIII) {
        return lllllllllllllllIlIllllllIllIIlIl << 8 | lllllllllllllllIlIllllllIllIlIII << 4 | lllllllllllllllIlIllllllIllIlIll;
    }
    
    @Override
    public int onResize(final int lllllllllllllllIlIllllllIIllIIlI, final IBlockState lllllllllllllllIlIllllllIIllllIl) {
        final BitArray lllllllllllllllIlIllllllIIlllIll = this.storage;
        final IBlockStatePalette lllllllllllllllIlIllllllIIlllIIl = this.palette;
        this.setBits(lllllllllllllllIlIllllllIIllIIlI);
        for (int lllllllllllllllIlIllllllIIllIlll = 0; lllllllllllllllIlIllllllIIllIlll < lllllllllllllllIlIllllllIIlllIll.size(); ++lllllllllllllllIlIllllllIIllIlll) {
            final IBlockState lllllllllllllllIlIllllllIIllIlIl = lllllllllllllllIlIllllllIIlllIIl.getBlockState(lllllllllllllllIlIllllllIIlllIll.getAt(lllllllllllllllIlIllllllIIllIlll));
            if (lllllllllllllllIlIllllllIIllIlIl != null) {
                this.set(lllllllllllllllIlIllllllIIllIlll, lllllllllllllllIlIllllllIIllIlIl);
            }
        }
        return this.palette.idFor(lllllllllllllllIlIllllllIIllllIl);
    }
    
    private void setBits(final int lllllllllllllllIlIllllllIlIllIlI) {
        if (lllllllllllllllIlIllllllIlIllIlI != this.bits) {
            this.bits = lllllllllllllllIlIllllllIlIllIlI;
            if (this.bits <= 4) {
                this.bits = 4;
                this.palette = new BlockStatePaletteLinear(this.bits, this);
            }
            else if (this.bits <= 8) {
                this.palette = new BlockStatePaletteHashMap(this.bits, this);
            }
            else {
                this.palette = BlockStateContainer.REGISTRY_BASED_PALETTE;
                this.bits = MathHelper.log2DeBruijn(Block.BLOCK_STATE_IDS.size());
            }
            this.palette.idFor(BlockStateContainer.AIR_BLOCK_STATE);
            this.storage = new BitArray(this.bits, 4096);
        }
    }
    
    public void set(final int lllllllllllllllIlIllllllIIIllIlI, final int lllllllllllllllIlIllllllIIIllIIl, final int lllllllllllllllIlIllllllIIIlIIII, final IBlockState lllllllllllllllIlIllllllIIIlIlll) {
        this.set(getIndex(lllllllllllllllIlIllllllIIIllIlI, lllllllllllllllIlIllllllIIIllIIl, lllllllllllllllIlIllllllIIIlIIII), lllllllllllllllIlIllllllIIIlIlll);
    }
    
    public BlockStateContainer() {
        this.setBits(4);
    }
    
    public IBlockState get(final int lllllllllllllllIlIlllllIlllllIIl, final int lllllllllllllllIlIlllllIlllllIII, final int lllllllllllllllIlIlllllIllllIIll) {
        return this.get(getIndex(lllllllllllllllIlIlllllIlllllIIl, lllllllllllllllIlIlllllIlllllIII, lllllllllllllllIlIlllllIllllIIll));
    }
    
    protected void set(final int lllllllllllllllIlIllllllIIIIIIIl, final IBlockState lllllllllllllllIlIllllllIIIIIlII) {
        final int lllllllllllllllIlIllllllIIIIIIll = this.palette.idFor(lllllllllllllllIlIllllllIIIIIlII);
        this.storage.setAt(lllllllllllllllIlIllllllIIIIIIIl, lllllllllllllllIlIllllllIIIIIIll);
    }
}
