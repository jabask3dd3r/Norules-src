package net.minecraft.block.state.pattern;

import net.minecraft.block.state.*;
import net.minecraft.util.*;
import javax.annotation.*;
import net.minecraft.world.*;
import com.google.common.cache.*;
import net.minecraft.util.math.*;
import com.google.common.base.*;

public class BlockPattern
{
    private final /* synthetic */ Predicate<BlockWorldState>[][][] blockMatches;
    private final /* synthetic */ int thumbLength;
    private final /* synthetic */ int fingerLength;
    private final /* synthetic */ int palmLength;
    
    @Nullable
    private PatternHelper checkPatternAt(final BlockPos llllllllllllllllIllIlllIIIlllIIl, final EnumFacing llllllllllllllllIllIlllIIIlllIII, final EnumFacing llllllllllllllllIllIlllIIIlIIlll, final LoadingCache<BlockPos, BlockWorldState> llllllllllllllllIllIlllIIIllIlII) {
        for (int llllllllllllllllIllIlllIIIllIIlI = 0; llllllllllllllllIllIlllIIIllIIlI < this.palmLength; ++llllllllllllllllIllIlllIIIllIIlI) {
            for (int llllllllllllllllIllIlllIIIllIIII = 0; llllllllllllllllIllIlllIIIllIIII < this.thumbLength; ++llllllllllllllllIllIlllIIIllIIII) {
                for (int llllllllllllllllIllIlllIIIlIllll = 0; llllllllllllllllIllIlllIIIlIllll < this.fingerLength; ++llllllllllllllllIllIlllIIIlIllll) {
                    if (!this.blockMatches[llllllllllllllllIllIlllIIIlIllll][llllllllllllllllIllIlllIIIllIIII][llllllllllllllllIllIlllIIIllIIlI].apply((Object)llllllllllllllllIllIlllIIIllIlII.getUnchecked((Object)translateOffset(llllllllllllllllIllIlllIIIlllIIl, llllllllllllllllIllIlllIIIlllIII, llllllllllllllllIllIlllIIIlIIlll, llllllllllllllllIllIlllIIIllIIlI, llllllllllllllllIllIlllIIIllIIII, llllllllllllllllIllIlllIIIlIllll)))) {
                        return null;
                    }
                }
            }
        }
        return new PatternHelper(llllllllllllllllIllIlllIIIlllIIl, llllllllllllllllIllIlllIIIlllIII, llllllllllllllllIllIlllIIIlIIlll, llllllllllllllllIllIlllIIIllIlII, this.palmLength, this.thumbLength, this.fingerLength);
    }
    
    public static LoadingCache<BlockPos, BlockWorldState> createLoadingCache(final World llllllllllllllllIllIllIlllIIllIl, final boolean llllllllllllllllIllIllIlllIIlIII) {
        return (LoadingCache<BlockPos, BlockWorldState>)CacheBuilder.newBuilder().build((com.google.common.cache.CacheLoader)new CacheLoader(llllllllllllllllIllIllIlllIIllIl, llllllllllllllllIllIllIlllIIlIII));
    }
    
    protected static BlockPos translateOffset(final BlockPos llllllllllllllllIllIllIllIlIlIll, final EnumFacing llllllllllllllllIllIllIllIlIIIIl, final EnumFacing llllllllllllllllIllIllIllIlIlIIl, final int llllllllllllllllIllIllIllIIllllI, final int llllllllllllllllIllIllIllIlIIlll, final int llllllllllllllllIllIllIllIIllIlI) {
        if (llllllllllllllllIllIllIllIlIIIIl != llllllllllllllllIllIllIllIlIlIIl && llllllllllllllllIllIllIllIlIIIIl != llllllllllllllllIllIllIllIlIlIIl.getOpposite()) {
            final Vec3i llllllllllllllllIllIllIllIlIIlIl = new Vec3i(llllllllllllllllIllIllIllIlIIIIl.getFrontOffsetX(), llllllllllllllllIllIllIllIlIIIIl.getFrontOffsetY(), llllllllllllllllIllIllIllIlIIIIl.getFrontOffsetZ());
            final Vec3i llllllllllllllllIllIllIllIlIIlII = new Vec3i(llllllllllllllllIllIllIllIlIlIIl.getFrontOffsetX(), llllllllllllllllIllIllIllIlIlIIl.getFrontOffsetY(), llllllllllllllllIllIllIllIlIlIIl.getFrontOffsetZ());
            final Vec3i llllllllllllllllIllIllIllIlIIIll = llllllllllllllllIllIllIllIlIIlIl.crossProduct(llllllllllllllllIllIllIllIlIIlII);
            return llllllllllllllllIllIllIllIlIlIll.add(llllllllllllllllIllIllIllIlIIlII.getX() * -llllllllllllllllIllIllIllIlIIlll + llllllllllllllllIllIllIllIlIIIll.getX() * llllllllllllllllIllIllIllIIllllI + llllllllllllllllIllIllIllIlIIlIl.getX() * llllllllllllllllIllIllIllIIllIlI, llllllllllllllllIllIllIllIlIIlII.getY() * -llllllllllllllllIllIllIllIlIIlll + llllllllllllllllIllIllIllIlIIIll.getY() * llllllllllllllllIllIllIllIIllllI + llllllllllllllllIllIllIllIlIIlIl.getY() * llllllllllllllllIllIllIllIIllIlI, llllllllllllllllIllIllIllIlIIlII.getZ() * -llllllllllllllllIllIllIllIlIIlll + llllllllllllllllIllIllIllIlIIIll.getZ() * llllllllllllllllIllIllIllIIllllI + llllllllllllllllIllIllIllIlIIlIl.getZ() * llllllllllllllllIllIllIllIIllIlI);
        }
        throw new IllegalArgumentException("Invalid forwards & up combination");
    }
    
    public int getFingerLength() {
        return this.fingerLength;
    }
    
    public BlockPattern(final Predicate<BlockWorldState>[][][] llllllllllllllllIllIlllIIllIIlII) {
        this.blockMatches = llllllllllllllllIllIlllIIllIIlII;
        this.fingerLength = llllllllllllllllIllIlllIIllIIlII.length;
        if (this.fingerLength > 0) {
            this.thumbLength = llllllllllllllllIllIlllIIllIIlII[0].length;
            if (this.thumbLength > 0) {
                this.palmLength = llllllllllllllllIllIlllIIllIIlII[0][0].length;
            }
            else {
                this.palmLength = 0;
            }
        }
        else {
            this.thumbLength = 0;
            this.palmLength = 0;
        }
    }
    
    public int getPalmLength() {
        return this.palmLength;
    }
    
    public int getThumbLength() {
        return this.thumbLength;
    }
    
    @Nullable
    public PatternHelper match(final World llllllllllllllllIllIllIlllllIllI, final BlockPos llllllllllllllllIllIllIllllIIllI) {
        final LoadingCache<BlockPos, BlockWorldState> llllllllllllllllIllIllIlllllIIIl = createLoadingCache(llllllllllllllllIllIllIlllllIllI, false);
        final int llllllllllllllllIllIllIllllIlllI = Math.max(Math.max(this.palmLength, this.thumbLength), this.fingerLength);
        for (final BlockPos llllllllllllllllIllIllIllllIllII : BlockPos.getAllInBox(llllllllllllllllIllIllIllllIIllI, llllllllllllllllIllIllIllllIIllI.add(llllllllllllllllIllIllIllllIlllI - 1, llllllllllllllllIllIllIllllIlllI - 1, llllllllllllllllIllIllIllllIlllI - 1))) {
            final float llllllllllllllllIllIllIlllIllllI;
            final short llllllllllllllllIllIllIlllIlllll = (short)((EnumFacing[])(Object)(llllllllllllllllIllIllIlllIllllI = (float)(Object)EnumFacing.values())).length;
            for (float llllllllllllllllIllIllIllllIIIII = 0; llllllllllllllllIllIllIllllIIIII < llllllllllllllllIllIllIlllIlllll; ++llllllllllllllllIllIllIllllIIIII) {
                final EnumFacing llllllllllllllllIllIllIllllIlIll = llllllllllllllllIllIllIlllIllllI[llllllllllllllllIllIllIllllIIIII];
                final boolean llllllllllllllllIllIllIlllIlIlll;
                final String llllllllllllllllIllIllIlllIllIIl = (String)((EnumFacing[])(Object)(llllllllllllllllIllIllIlllIlIlll = (boolean)(Object)EnumFacing.values())).length;
                for (final EnumFacing llllllllllllllllIllIllIllllIlIlI : llllllllllllllllIllIllIlllIlIlll) {
                    if (llllllllllllllllIllIllIllllIlIlI != llllllllllllllllIllIllIllllIlIll && llllllllllllllllIllIllIllllIlIlI != llllllllllllllllIllIllIllllIlIll.getOpposite()) {
                        final PatternHelper llllllllllllllllIllIllIllllIlIIl = this.checkPatternAt(llllllllllllllllIllIllIllllIllII, llllllllllllllllIllIllIllllIlIll, llllllllllllllllIllIllIllllIlIlI, llllllllllllllllIllIllIlllllIIIl);
                        if (llllllllllllllllIllIllIllllIlIIl != null) {
                            return llllllllllllllllIllIllIllllIlIIl;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public static class PatternHelper
    {
        private final /* synthetic */ EnumFacing forwards;
        private final /* synthetic */ int width;
        private final /* synthetic */ int height;
        private final /* synthetic */ LoadingCache<BlockPos, BlockWorldState> lcache;
        private final /* synthetic */ int depth;
        private final /* synthetic */ BlockPos frontTopLeft;
        private final /* synthetic */ EnumFacing up;
        
        public int getWidth() {
            return this.width;
        }
        
        public BlockPos getFrontTopLeft() {
            return this.frontTopLeft;
        }
        
        public EnumFacing getForwards() {
            return this.forwards;
        }
        
        public EnumFacing getUp() {
            return this.up;
        }
        
        public int getHeight() {
            return this.height;
        }
        
        @Override
        public String toString() {
            return MoreObjects.toStringHelper((Object)this).add("up", (Object)this.up).add("forwards", (Object)this.forwards).add("frontTopLeft", (Object)this.frontTopLeft).toString();
        }
        
        public PatternHelper(final BlockPos lllllllllllllIllIllIIIlIIIlIlllI, final EnumFacing lllllllllllllIllIllIIIlIIIlIllIl, final EnumFacing lllllllllllllIllIllIIIlIIIlIllII, final LoadingCache<BlockPos, BlockWorldState> lllllllllllllIllIllIIIlIIIlIlIll, final int lllllllllllllIllIllIIIlIIIlIIIlI, final int lllllllllllllIllIllIIIlIIIlIlIIl, final int lllllllllllllIllIllIIIlIIIlIlIII) {
            this.frontTopLeft = lllllllllllllIllIllIIIlIIIlIlllI;
            this.forwards = lllllllllllllIllIllIIIlIIIlIllIl;
            this.up = lllllllllllllIllIllIIIlIIIlIllII;
            this.lcache = lllllllllllllIllIllIIIlIIIlIlIll;
            this.width = lllllllllllllIllIllIIIlIIIlIIIlI;
            this.height = lllllllllllllIllIllIIIlIIIlIlIIl;
            this.depth = lllllllllllllIllIllIIIlIIIlIlIII;
        }
        
        public BlockWorldState translateOffset(final int lllllllllllllIllIllIIIlIIIIIIlll, final int lllllllllllllIllIllIIIlIIIIIlIlI, final int lllllllllllllIllIllIIIlIIIIIlIIl) {
            return (BlockWorldState)this.lcache.getUnchecked((Object)BlockPattern.translateOffset(this.frontTopLeft, this.getForwards(), this.getUp(), lllllllllllllIllIllIIIlIIIIIIlll, lllllllllllllIllIllIIIlIIIIIlIlI, lllllllllllllIllIllIIIlIIIIIlIIl));
        }
    }
    
    static class CacheLoader extends com.google.common.cache.CacheLoader<BlockPos, BlockWorldState>
    {
        private final /* synthetic */ boolean forceLoad;
        private final /* synthetic */ World world;
        
        public BlockWorldState load(final BlockPos lllllllllllllIIllIIlIIllIlIIllIl) throws Exception {
            return new BlockWorldState(this.world, lllllllllllllIIllIIlIIllIlIIllIl, this.forceLoad);
        }
        
        public CacheLoader(final World lllllllllllllIIllIIlIIllIlIlIlll, final boolean lllllllllllllIIllIIlIIllIlIlIllI) {
            this.world = lllllllllllllIIllIIlIIllIlIlIlll;
            this.forceLoad = lllllllllllllIIllIIlIIllIlIlIllI;
        }
    }
}
