package net.minecraft.util.math;

import net.minecraft.entity.*;

public class ChunkPos
{
    public final /* synthetic */ int chunkXPos;
    public final /* synthetic */ int chunkZPos;
    private /* synthetic */ int cachedHashCode;
    
    public static long asLong(final int lllllllllllllIlllllIIIIllIllIlll, final int lllllllllllllIlllllIIIIllIllIllI) {
        return ((long)lllllllllllllIlllllIIIIllIllIlll & 0xFFFFFFFFL) | ((long)lllllllllllllIlllllIIIIllIllIllI & 0xFFFFFFFFL) << 32;
    }
    
    public ChunkPos(final BlockPos lllllllllllllIlllllIIIIllIllllII) {
        this.cachedHashCode = 0;
        this.chunkXPos = lllllllllllllIlllllIIIIllIllllII.getX() >> 4;
        this.chunkZPos = lllllllllllllIlllllIIIIllIllllII.getZ() >> 4;
    }
    
    public int getXEnd() {
        return (this.chunkXPos << 4) + 15;
    }
    
    public int getXStart() {
        return this.chunkXPos << 4;
    }
    
    public int getZStart() {
        return this.chunkZPos << 4;
    }
    
    public BlockPos getBlock(final int lllllllllllllIlllllIIIIlIllllllI, final int lllllllllllllIlllllIIIIlIllllIIl, final int lllllllllllllIlllllIIIIlIllllIII) {
        return new BlockPos((this.chunkXPos << 4) + lllllllllllllIlllllIIIIlIllllllI, lllllllllllllIlllllIIIIlIllllIIl, (this.chunkZPos << 4) + lllllllllllllIlllllIIIIlIllllIII);
    }
    
    public int getZEnd() {
        return (this.chunkZPos << 4) + 15;
    }
    
    public ChunkPos(final int lllllllllllllIlllllIIIIlllIIIIIl, final int lllllllllllllIlllllIIIIlllIIIIll) {
        this.cachedHashCode = 0;
        this.chunkXPos = lllllllllllllIlllllIIIIlllIIIIIl;
        this.chunkZPos = lllllllllllllIlllllIIIIlllIIIIll;
    }
    
    @Override
    public boolean equals(final Object lllllllllllllIlllllIIIIllIlIIllI) {
        if (this == lllllllllllllIlllllIIIIllIlIIllI) {
            return true;
        }
        if (!(lllllllllllllIlllllIIIIllIlIIllI instanceof ChunkPos)) {
            return false;
        }
        final ChunkPos lllllllllllllIlllllIIIIllIlIIlIl = (ChunkPos)lllllllllllllIlllllIIIIllIlIIllI;
        return this.chunkXPos == lllllllllllllIlllllIIIIllIlIIlIl.chunkXPos && this.chunkZPos == lllllllllllllIlllllIIIIllIlIIlIl.chunkZPos;
    }
    
    @Override
    public int hashCode() {
        if (this.cachedHashCode != 0) {
            return this.cachedHashCode;
        }
        final int lllllllllllllIlllllIIIIllIlIllll = 1664525 * this.chunkXPos + 1013904223;
        final int lllllllllllllIlllllIIIIllIlIlllI = 1664525 * (this.chunkZPos ^ 0xDEADBEEF) + 1013904223;
        this.cachedHashCode = (lllllllllllllIlllllIIIIllIlIllll ^ lllllllllllllIlllllIIIIllIlIlllI);
        return this.cachedHashCode;
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("[").append(this.chunkXPos).append(", ").append(this.chunkZPos).append("]"));
    }
    
    public double getDistanceSq(final Entity lllllllllllllIlllllIIIIllIIlIlII) {
        final double lllllllllllllIlllllIIIIllIIllIIl = this.chunkXPos * 16 + 8;
        final double lllllllllllllIlllllIIIIllIIllIII = this.chunkZPos * 16 + 8;
        final double lllllllllllllIlllllIIIIllIIlIlll = lllllllllllllIlllllIIIIllIIllIIl - lllllllllllllIlllllIIIIllIIlIlII.posX;
        final double lllllllllllllIlllllIIIIllIIlIllI = lllllllllllllIlllllIIIIllIIllIII - lllllllllllllIlllllIIIIllIIlIlII.posZ;
        return lllllllllllllIlllllIIIIllIIlIlll * lllllllllllllIlllllIIIIllIIlIlll + lllllllllllllIlllllIIIIllIIlIllI * lllllllllllllIlllllIIIIllIIlIllI;
    }
}
