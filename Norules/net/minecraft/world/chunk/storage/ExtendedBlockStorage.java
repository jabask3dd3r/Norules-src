package net.minecraft.world.chunk.storage;

import net.minecraft.world.chunk.*;
import net.minecraft.block.state.*;
import optifine.*;
import net.minecraft.init.*;
import net.minecraft.block.*;

public class ExtendedBlockStorage
{
    private /* synthetic */ NibbleArray skylightArray;
    private /* synthetic */ int tickRefCount;
    private /* synthetic */ int blockRefCount;
    private final /* synthetic */ BlockStateContainer data;
    private /* synthetic */ NibbleArray blocklightArray;
    private final /* synthetic */ int yBase;
    
    public int getYLocation() {
        return this.yBase;
    }
    
    public ExtendedBlockStorage(final int lllllllllllllIIllIlIIIIllIIlllIl, final boolean lllllllllllllIIllIlIIIIllIIlllII) {
        this.yBase = lllllllllllllIIllIlIIIIllIIlllIl;
        this.data = new BlockStateContainer();
        this.blocklightArray = new NibbleArray();
        if (lllllllllllllIIllIlIIIIllIIlllII) {
            this.skylightArray = new NibbleArray();
        }
    }
    
    public void set(final int lllllllllllllIIllIlIIIIlIllllIll, final int lllllllllllllIIllIlIIIIlIllllIlI, final int lllllllllllllIIllIlIIIIlIllllIIl, IBlockState lllllllllllllIIllIlIIIIlIllllIII) {
        if (Reflector.IExtendedBlockState.isInstance(lllllllllllllIIllIlIIIIlIllllIII)) {
            lllllllllllllIIllIlIIIIlIllllIII = Reflector.call(lllllllllllllIIllIlIIIIlIllllIII, Reflector.IExtendedBlockState_getClean, new Object[0]);
        }
        final IBlockState lllllllllllllIIllIlIIIIlIlllllll = this.get(lllllllllllllIIllIlIIIIlIllllIll, lllllllllllllIIllIlIIIIlIllllIlI, lllllllllllllIIllIlIIIIlIllllIIl);
        final Block lllllllllllllIIllIlIIIIlIllllllI = lllllllllllllIIllIlIIIIlIlllllll.getBlock();
        final Block lllllllllllllIIllIlIIIIlIlllllIl = ((IBlockState)lllllllllllllIIllIlIIIIlIllllIII).getBlock();
        if (lllllllllllllIIllIlIIIIlIllllllI != Blocks.AIR) {
            --this.blockRefCount;
            if (lllllllllllllIIllIlIIIIlIllllllI.getTickRandomly()) {
                --this.tickRefCount;
            }
        }
        if (lllllllllllllIIllIlIIIIlIlllllIl != Blocks.AIR) {
            ++this.blockRefCount;
            if (lllllllllllllIIllIlIIIIlIlllllIl.getTickRandomly()) {
                ++this.tickRefCount;
            }
        }
        this.data.set(lllllllllllllIIllIlIIIIlIllllIll, lllllllllllllIIllIlIIIIlIllllIlI, lllllllllllllIIllIlIIIIlIllllIIl, (IBlockState)lllllllllllllIIllIlIIIIlIllllIII);
    }
    
    public boolean getNeedsRandomTick() {
        return this.tickRefCount > 0;
    }
    
    public void setBlocklightArray(final NibbleArray lllllllllllllIIllIlIIIIlIIIIllII) {
        this.blocklightArray = lllllllllllllIIllIlIIIIlIIIIllII;
    }
    
    public BlockStateContainer getData() {
        return this.data;
    }
    
    public NibbleArray getBlocklightArray() {
        return this.blocklightArray;
    }
    
    public void setSkylightArray(final NibbleArray lllllllllllllIIllIlIIIIlIIIIlIII) {
        this.skylightArray = lllllllllllllIIllIlIIIIlIIIIlIII;
    }
    
    public boolean isEmpty() {
        return this.blockRefCount == 0;
    }
    
    public void removeInvalidBlocks() {
        final IBlockState lllllllllllllIIllIlIIIIlIIlIlIll = Blocks.AIR.getDefaultState();
        int lllllllllllllIIllIlIIIIlIIlIlIlI = 0;
        int lllllllllllllIIllIlIIIIlIIlIlIIl = 0;
        for (int lllllllllllllIIllIlIIIIlIIlIlIII = 0; lllllllllllllIIllIlIIIIlIIlIlIII < 16; ++lllllllllllllIIllIlIIIIlIIlIlIII) {
            for (int lllllllllllllIIllIlIIIIlIIlIIlll = 0; lllllllllllllIIllIlIIIIlIIlIIlll < 16; ++lllllllllllllIIllIlIIIIlIIlIIlll) {
                for (int lllllllllllllIIllIlIIIIlIIlIIllI = 0; lllllllllllllIIllIlIIIIlIIlIIllI < 16; ++lllllllllllllIIllIlIIIIlIIlIIllI) {
                    final IBlockState lllllllllllllIIllIlIIIIlIIlIIlIl = this.data.get(lllllllllllllIIllIlIIIIlIIlIIllI, lllllllllllllIIllIlIIIIlIIlIlIII, lllllllllllllIIllIlIIIIlIIlIIlll);
                    if (lllllllllllllIIllIlIIIIlIIlIIlIl != lllllllllllllIIllIlIIIIlIIlIlIll) {
                        ++lllllllllllllIIllIlIIIIlIIlIlIlI;
                        final Block lllllllllllllIIllIlIIIIlIIlIIlII = lllllllllllllIIllIlIIIIlIIlIIlIl.getBlock();
                        if (lllllllllllllIIllIlIIIIlIIlIIlII.getTickRandomly()) {
                            ++lllllllllllllIIllIlIIIIlIIlIlIIl;
                        }
                    }
                }
            }
        }
        this.blockRefCount = lllllllllllllIIllIlIIIIlIIlIlIlI;
        this.tickRefCount = lllllllllllllIIllIlIIIIlIIlIlIIl;
    }
    
    public NibbleArray getSkylightArray() {
        return this.skylightArray;
    }
    
    public void setExtBlocklightValue(final int lllllllllllllIIllIlIIIIlIlIIIlIl, final int lllllllllllllIIllIlIIIIlIlIIlIIl, final int lllllllllllllIIllIlIIIIlIlIIlIII, final int lllllllllllllIIllIlIIIIlIlIIIIlI) {
        this.blocklightArray.set(lllllllllllllIIllIlIIIIlIlIIIlIl, lllllllllllllIIllIlIIIIlIlIIlIIl, lllllllllllllIIllIlIIIIlIlIIlIII, lllllllllllllIIllIlIIIIlIlIIIIlI);
    }
    
    public IBlockState get(final int lllllllllllllIIllIlIIIIllIIIllll, final int lllllllllllllIIllIlIIIIllIIIlllI, final int lllllllllllllIIllIlIIIIllIIIllIl) {
        return this.data.get(lllllllllllllIIllIlIIIIllIIIllll, lllllllllllllIIllIlIIIIllIIIlllI, lllllllllllllIIllIlIIIIllIIIllIl);
    }
    
    public int getExtSkylightValue(final int lllllllllllllIIllIlIIIIlIlIlIIll, final int lllllllllllllIIllIlIIIIlIlIlIllI, final int lllllllllllllIIllIlIIIIlIlIlIIIl) {
        return this.skylightArray.get(lllllllllllllIIllIlIIIIlIlIlIIll, lllllllllllllIIllIlIIIIlIlIlIllI, lllllllllllllIIllIlIIIIlIlIlIIIl);
    }
    
    public void setExtSkylightValue(final int lllllllllllllIIllIlIIIIlIllIIlIl, final int lllllllllllllIIllIlIIIIlIllIIlII, final int lllllllllllllIIllIlIIIIlIlIllllI, final int lllllllllllllIIllIlIIIIlIlIlllIl) {
        this.skylightArray.set(lllllllllllllIIllIlIIIIlIllIIlIl, lllllllllllllIIllIlIIIIlIllIIlII, lllllllllllllIIllIlIIIIlIlIllllI, lllllllllllllIIllIlIIIIlIlIlllIl);
    }
    
    public int getExtBlocklightValue(final int lllllllllllllIIllIlIIIIlIIllllII, final int lllllllllllllIIllIlIIIIlIIllIlll, final int lllllllllllllIIllIlIIIIlIIlllIlI) {
        return this.blocklightArray.get(lllllllllllllIIllIlIIIIlIIllllII, lllllllllllllIIllIlIIIIlIIllIlll, lllllllllllllIIllIlIIIIlIIlllIlI);
    }
}
