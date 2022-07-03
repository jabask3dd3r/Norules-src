package net.minecraft.util.math;

import javax.annotation.concurrent.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import java.util.*;
import com.google.common.collect.*;

@Immutable
public class BlockPos extends Vec3i
{
    private static final /* synthetic */ long X_MASK;
    private static final /* synthetic */ int NUM_Y_BITS;
    private static final /* synthetic */ long Z_MASK;
    private static final /* synthetic */ long Y_MASK;
    private static final /* synthetic */ int NUM_X_BITS;
    private static final /* synthetic */ int Y_SHIFT;
    private static final /* synthetic */ Logger LOGGER;
    private static final /* synthetic */ int NUM_Z_BITS;
    private static final /* synthetic */ int X_SHIFT;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation;
    
    @Override
    public BlockPos crossProduct(final Vec3i lllllllllllllIllIIIIllllllIIIlII) {
        return new BlockPos(this.getY() * lllllllllllllIllIIIIllllllIIIlII.getZ() - this.getZ() * lllllllllllllIllIIIIllllllIIIlII.getY(), this.getZ() * lllllllllllllIllIIIIllllllIIIlII.getX() - this.getX() * lllllllllllllIllIIIIllllllIIIlII.getZ(), this.getX() * lllllllllllllIllIIIIllllllIIIlII.getY() - this.getY() * lllllllllllllIllIIIIllllllIIIlII.getX());
    }
    
    public BlockPos down() {
        return this.down(1);
    }
    
    static {
        LOGGER = LogManager.getLogger();
        ORIGIN = new BlockPos(0, 0, 0);
        NUM_X_BITS = 1 + MathHelper.log2(MathHelper.smallestEncompassingPowerOfTwo(30000000));
        NUM_Z_BITS = BlockPos.NUM_X_BITS;
        NUM_Y_BITS = 64 - BlockPos.NUM_X_BITS - BlockPos.NUM_Z_BITS;
        Y_SHIFT = 0 + BlockPos.NUM_Z_BITS;
        X_SHIFT = BlockPos.Y_SHIFT + BlockPos.NUM_Y_BITS;
        X_MASK = (1L << BlockPos.NUM_X_BITS) - 1L;
        Y_MASK = (1L << BlockPos.NUM_Y_BITS) - 1L;
        Z_MASK = (1L << BlockPos.NUM_Z_BITS) - 1L;
    }
    
    public BlockPos(final double lllllllllllllIllIIIlIIIIIlIIllll, final double lllllllllllllIllIIIlIIIIIlIIlllI, final double lllllllllllllIllIIIlIIIIIlIIlIIl) {
        super(lllllllllllllIllIIIlIIIIIlIIllll, lllllllllllllIllIIIlIIIIIlIIlllI, lllllllllllllIllIIIlIIIIIlIIlIIl);
    }
    
    public BlockPos add(final int lllllllllllllIllIIIlIIIIIIlIIIIl, final int lllllllllllllIllIIIlIIIIIIlIIIII, final int lllllllllllllIllIIIlIIIIIIIlllll) {
        return (lllllllllllllIllIIIlIIIIIIlIIIIl == 0 && lllllllllllllIllIIIlIIIIIIlIIIII == 0 && lllllllllllllIllIIIlIIIIIIIlllll == 0) ? this : new BlockPos(this.getX() + lllllllllllllIllIIIlIIIIIIlIIIIl, this.getY() + lllllllllllllIllIIIlIIIIIIlIIIII, this.getZ() + lllllllllllllIllIIIlIIIIIIIlllll);
    }
    
    public BlockPos up() {
        return this.up(1);
    }
    
    public BlockPos func_190942_a(final Rotation lllllllllllllIllIIIIllllllIIlIlI) {
        switch ($SWITCH_TABLE$net$minecraft$util$Rotation()[lllllllllllllIllIIIIllllllIIlIlI.ordinal()]) {
            default: {
                return this;
            }
            case 2: {
                return new BlockPos(-this.getZ(), this.getY(), this.getX());
            }
            case 3: {
                return new BlockPos(-this.getX(), this.getY(), -this.getZ());
            }
            case 4: {
                return new BlockPos(this.getZ(), this.getY(), -this.getX());
            }
        }
    }
    
    public BlockPos offset(final EnumFacing lllllllllllllIllIIIIllllllIlIIlI, final int lllllllllllllIllIIIIllllllIlIIIl) {
        return (lllllllllllllIllIIIIllllllIlIIIl == 0) ? this : new BlockPos(this.getX() + lllllllllllllIllIIIIllllllIlIIlI.getFrontOffsetX() * lllllllllllllIllIIIIllllllIlIIIl, this.getY() + lllllllllllllIllIIIIllllllIlIIlI.getFrontOffsetY() * lllllllllllllIllIIIIllllllIlIIIl, this.getZ() + lllllllllllllIllIIIIllllllIlIIlI.getFrontOffsetZ() * lllllllllllllIllIIIIllllllIlIIIl);
    }
    
    public BlockPos(final Vec3d lllllllllllllIllIIIlIIIIIIllllIl) {
        this(lllllllllllllIllIIIlIIIIIIllllIl.xCoord, lllllllllllllIllIIIlIIIIIIllllIl.yCoord, lllllllllllllIllIIIlIIIIIIllllIl.zCoord);
    }
    
    public BlockPos west(final int lllllllllllllIllIIIIlllllllIlIII) {
        return this.offset(EnumFacing.WEST, lllllllllllllIllIIIIlllllllIlIII);
    }
    
    public static Iterable<BlockPos> getAllInBox(final BlockPos lllllllllllllIllIIIIlllllIllIIII, final BlockPos lllllllllllllIllIIIIlllllIlIllIl) {
        return func_191532_a(Math.min(lllllllllllllIllIIIIlllllIllIIII.getX(), lllllllllllllIllIIIIlllllIlIllIl.getX()), Math.min(lllllllllllllIllIIIIlllllIllIIII.getY(), lllllllllllllIllIIIIlllllIlIllIl.getY()), Math.min(lllllllllllllIllIIIIlllllIllIIII.getZ(), lllllllllllllIllIIIIlllllIlIllIl.getZ()), Math.max(lllllllllllllIllIIIIlllllIllIIII.getX(), lllllllllllllIllIIIIlllllIlIllIl.getX()), Math.max(lllllllllllllIllIIIIlllllIllIIII.getY(), lllllllllllllIllIIIIlllllIlIllIl.getY()), Math.max(lllllllllllllIllIIIIlllllIllIIII.getZ(), lllllllllllllIllIIIIlllllIlIllIl.getZ()));
    }
    
    public BlockPos east(final int lllllllllllllIllIIIIllllllIlllIl) {
        return this.offset(EnumFacing.EAST, lllllllllllllIllIIIIllllllIlllIl);
    }
    
    public static Iterable<BlockPos> func_191532_a(final int lllllllllllllIllIIIIlllllIlIIllI, final int lllllllllllllIllIIIIlllllIlIIlIl, final int lllllllllllllIllIIIIlllllIlIIlII, final int lllllllllllllIllIIIIlllllIIlllIl, final int lllllllllllllIllIIIIlllllIIlllII, final int lllllllllllllIllIIIIlllllIlIIIIl) {
        return new Iterable<BlockPos>() {
            @Override
            public Iterator<BlockPos> iterator() {
                return (Iterator<BlockPos>)new AbstractIterator<BlockPos>() {
                    private /* synthetic */ int field_191535_c;
                    private /* synthetic */ int field_191536_d;
                    private /* synthetic */ boolean field_191534_b = true;
                    private /* synthetic */ int field_191537_e;
                    
                    protected BlockPos computeNext() {
                        if (this.field_191534_b) {
                            this.field_191534_b = false;
                            this.field_191535_c = lllllllllllllIllIIIIlllllIlIIllI;
                            this.field_191536_d = lllllllllllllIllIIIIlllllIlIIlIl;
                            this.field_191537_e = lllllllllllllIllIIIIlllllIlIIlII;
                            return new BlockPos(lllllllllllllIllIIIIlllllIlIIllI, lllllllllllllIllIIIIlllllIlIIlIl, lllllllllllllIllIIIIlllllIlIIlII);
                        }
                        if (this.field_191535_c == lllllllllllllIllIIIIlllllIIlllIl && this.field_191536_d == lllllllllllllIllIIIIlllllIIlllII && this.field_191537_e == lllllllllllllIllIIIIlllllIlIIIIl) {
                            return (BlockPos)this.endOfData();
                        }
                        if (this.field_191535_c < lllllllllllllIllIIIIlllllIIlllIl) {
                            ++this.field_191535_c;
                        }
                        else if (this.field_191536_d < lllllllllllllIllIIIIlllllIIlllII) {
                            this.field_191535_c = lllllllllllllIllIIIIlllllIlIIllI;
                            ++this.field_191536_d;
                        }
                        else if (this.field_191537_e < lllllllllllllIllIIIIlllllIlIIIIl) {
                            this.field_191535_c = lllllllllllllIllIIIIlllllIlIIllI;
                            this.field_191536_d = lllllllllllllIllIIIIlllllIlIIlIl;
                            ++this.field_191537_e;
                        }
                        return new BlockPos(this.field_191535_c, this.field_191536_d, this.field_191537_e);
                    }
                };
            }
        };
    }
    
    public BlockPos subtract(final Vec3i lllllllllllllIllIIIlIIIIIIIlIlIl) {
        return this.add(-lllllllllllllIllIIIlIIIIIIIlIlIl.getX(), -lllllllllllllIllIIIlIIIIIIIlIlIl.getY(), -lllllllllllllIllIIIlIIIIIIIlIlIl.getZ());
    }
    
    public BlockPos add(final Vec3i lllllllllllllIllIIIlIIIIIIIllIIl) {
        return this.add(lllllllllllllIllIIIlIIIIIIIllIIl.getX(), lllllllllllllIllIIIlIIIIIIIllIIl.getY(), lllllllllllllIllIIIlIIIIIIIllIIl.getZ());
    }
    
    public static BlockPos fromLong(final long lllllllllllllIllIIIIlllllIlllIlI) {
        final int lllllllllllllIllIIIIlllllIlllIIl = (int)(lllllllllllllIllIIIIlllllIlllIlI << 64 - BlockPos.X_SHIFT - BlockPos.NUM_X_BITS >> 64 - BlockPos.NUM_X_BITS);
        final int lllllllllllllIllIIIIlllllIlllIII = (int)(lllllllllllllIllIIIIlllllIlllIlI << 64 - BlockPos.Y_SHIFT - BlockPos.NUM_Y_BITS >> 64 - BlockPos.NUM_Y_BITS);
        final int lllllllllllllIllIIIIlllllIllIlll = (int)(lllllllllllllIllIIIIlllllIlllIlI << 64 - BlockPos.NUM_Z_BITS >> 64 - BlockPos.NUM_Z_BITS);
        return new BlockPos(lllllllllllllIllIIIIlllllIlllIIl, lllllllllllllIllIIIIlllllIlllIII, lllllllllllllIllIIIIlllllIllIlll);
    }
    
    public BlockPos offset(final EnumFacing lllllllllllllIllIIIIllllllIlIlll) {
        return this.offset(lllllllllllllIllIIIIllllllIlIlll, 1);
    }
    
    public BlockPos(final Entity lllllllllllllIllIIIlIIIIIlIIIIll) {
        this(lllllllllllllIllIIIlIIIIIlIIIIll.posX, lllllllllllllIllIIIlIIIIIlIIIIll.posY, lllllllllllllIllIIIlIIIIIlIIIIll.posZ);
    }
    
    public long toLong() {
        return ((long)this.getX() & BlockPos.X_MASK) << BlockPos.X_SHIFT | ((long)this.getY() & BlockPos.Y_MASK) << BlockPos.Y_SHIFT | ((long)this.getZ() & BlockPos.Z_MASK) << 0;
    }
    
    public BlockPos(final Vec3i lllllllllllllIllIIIlIIIIIIllIlll) {
        this(lllllllllllllIllIIIlIIIIIIllIlll.getX(), lllllllllllllIllIIIlIIIIIIllIlll.getY(), lllllllllllllIllIIIlIIIIIIllIlll.getZ());
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$Rotation() {
        final int[] $switch_TABLE$net$minecraft$util$Rotation = BlockPos.$SWITCH_TABLE$net$minecraft$util$Rotation;
        if ($switch_TABLE$net$minecraft$util$Rotation != null) {
            return $switch_TABLE$net$minecraft$util$Rotation;
        }
        final float lllllllllllllIllIIIIllllIllllIlI = (Object)new int[Rotation.values().length];
        try {
            lllllllllllllIllIIIIllllIllllIlI[Rotation.CLOCKWISE_180.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIllIIIIllllIllllIlI[Rotation.CLOCKWISE_90.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIllIIIIllllIllllIlI[Rotation.COUNTERCLOCKWISE_90.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIllIIIIllllIllllIlI[Rotation.NONE.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return BlockPos.$SWITCH_TABLE$net$minecraft$util$Rotation = (int[])(Object)lllllllllllllIllIIIIllllIllllIlI;
    }
    
    public BlockPos north() {
        return this.north(1);
    }
    
    public BlockPos(final int lllllllllllllIllIIIlIIIIIlIllIll, final int lllllllllllllIllIIIlIIIIIlIlIllI, final int lllllllllllllIllIIIlIIIIIlIlIlIl) {
        super(lllllllllllllIllIIIlIIIIIlIllIll, lllllllllllllIllIIIlIIIIIlIlIllI, lllllllllllllIllIIIlIIIIIlIlIlIl);
    }
    
    public BlockPos west() {
        return this.west(1);
    }
    
    public BlockPos east() {
        return this.east(1);
    }
    
    public static Iterable<MutableBlockPos> getAllInBoxMutable(final BlockPos lllllllllllllIllIIIIlllllIIlIlIl, final BlockPos lllllllllllllIllIIIIlllllIIlIlII) {
        return func_191531_b(Math.min(lllllllllllllIllIIIIlllllIIlIlIl.getX(), lllllllllllllIllIIIIlllllIIlIlII.getX()), Math.min(lllllllllllllIllIIIIlllllIIlIlIl.getY(), lllllllllllllIllIIIIlllllIIlIlII.getY()), Math.min(lllllllllllllIllIIIIlllllIIlIlIl.getZ(), lllllllllllllIllIIIIlllllIIlIlII.getZ()), Math.max(lllllllllllllIllIIIIlllllIIlIlIl.getX(), lllllllllllllIllIIIIlllllIIlIlII.getX()), Math.max(lllllllllllllIllIIIIlllllIIlIlIl.getY(), lllllllllllllIllIIIIlllllIIlIlII.getY()), Math.max(lllllllllllllIllIIIIlllllIIlIlIl.getZ(), lllllllllllllIllIIIIlllllIIlIlII.getZ()));
    }
    
    public static Iterable<MutableBlockPos> func_191531_b(final int lllllllllllllIllIIIIlllllIIIlIll, final int lllllllllllllIllIIIIlllllIIIlIlI, final int lllllllllllllIllIIIIlllllIIIlIIl, final int lllllllllllllIllIIIIlllllIIIlIII, final int lllllllllllllIllIIIIlllllIIIIIIl, final int lllllllllllllIllIIIIlllllIIIIIII) {
        return new Iterable<MutableBlockPos>() {
            @Override
            public Iterator<MutableBlockPos> iterator() {
                return (Iterator<MutableBlockPos>)new AbstractIterator<MutableBlockPos>() {
                    private /* synthetic */ MutableBlockPos theBlockPos;
                    
                    protected MutableBlockPos computeNext() {
                        if (this.theBlockPos == null) {
                            this.theBlockPos = new MutableBlockPos(lllllllllllllIllIIIIlllllIIIlIll, lllllllllllllIllIIIIlllllIIIlIlI, lllllllllllllIllIIIIlllllIIIlIIl);
                            return this.theBlockPos;
                        }
                        if (this.theBlockPos.x == lllllllllllllIllIIIIlllllIIIlIII && this.theBlockPos.y == lllllllllllllIllIIIIlllllIIIIIIl && this.theBlockPos.z == lllllllllllllIllIIIIlllllIIIIIII) {
                            return (MutableBlockPos)this.endOfData();
                        }
                        if (this.theBlockPos.x < lllllllllllllIllIIIIlllllIIIlIII) {
                            final MutableBlockPos theBlockPos = this.theBlockPos;
                            ++theBlockPos.x;
                        }
                        else if (this.theBlockPos.y < lllllllllllllIllIIIIlllllIIIIIIl) {
                            this.theBlockPos.x = lllllllllllllIllIIIIlllllIIIlIll;
                            final MutableBlockPos theBlockPos2 = this.theBlockPos;
                            ++theBlockPos2.y;
                        }
                        else if (this.theBlockPos.z < lllllllllllllIllIIIIlllllIIIIIII) {
                            this.theBlockPos.x = lllllllllllllIllIIIIlllllIIIlIll;
                            this.theBlockPos.y = lllllllllllllIllIIIIlllllIIIlIlI;
                            final MutableBlockPos theBlockPos3 = this.theBlockPos;
                            ++theBlockPos3.z;
                        }
                        return this.theBlockPos;
                    }
                };
            }
        };
    }
    
    public BlockPos add(final double lllllllllllllIllIIIlIIIIIIllIIIl, final double lllllllllllllIllIIIlIIIIIIlIllII, final double lllllllllllllIllIIIlIIIIIIlIlIll) {
        return (lllllllllllllIllIIIlIIIIIIllIIIl == 0.0 && lllllllllllllIllIIIlIIIIIIlIllII == 0.0 && lllllllllllllIllIIIlIIIIIIlIlIll == 0.0) ? this : new BlockPos(this.getX() + lllllllllllllIllIIIlIIIIIIllIIIl, this.getY() + lllllllllllllIllIIIlIIIIIIlIllII, this.getZ() + lllllllllllllIllIIIlIIIIIIlIlIll);
    }
    
    public BlockPos down(final int lllllllllllllIllIIIlIIIIIIIIIIIl) {
        return this.offset(EnumFacing.DOWN, lllllllllllllIllIIIlIIIIIIIIIIIl);
    }
    
    public BlockPos south() {
        return this.south(1);
    }
    
    public BlockPos south(final int lllllllllllllIllIIIIllllllllIIIl) {
        return this.offset(EnumFacing.SOUTH, lllllllllllllIllIIIIllllllllIIIl);
    }
    
    public BlockPos toImmutable() {
        return this;
    }
    
    public BlockPos north(final int lllllllllllllIllIIIIlllllllllIII) {
        return this.offset(EnumFacing.NORTH, lllllllllllllIllIIIIlllllllllIII);
    }
    
    public BlockPos up(final int lllllllllllllIllIIIlIIIIIIIIlIlI) {
        return this.offset(EnumFacing.UP, lllllllllllllIllIIIlIIIIIIIIlIlI);
    }
    
    public static final class PooledMutableBlockPos extends MutableBlockPos
    {
        private /* synthetic */ boolean released;
        private static final /* synthetic */ List<PooledMutableBlockPos> POOL;
        
        @Override
        public PooledMutableBlockPos setPos(final int llllllllllllllIlIIIlllIllllIlIII, final int llllllllllllllIlIIIlllIllllIIlll, final int llllllllllllllIlIIIlllIllllIIllI) {
            if (this.released) {
                BlockPos.LOGGER.error("PooledMutableBlockPosition modified after it was released.", new Throwable());
                this.released = false;
            }
            return (PooledMutableBlockPos)super.setPos(llllllllllllllIlIIIlllIllllIlIII, llllllllllllllIlIIIlllIllllIIlll, llllllllllllllIlIIIlllIllllIIllI);
        }
        
        public static PooledMutableBlockPos retain() {
            return retain(0, 0, 0);
        }
        
        public void release() {
            synchronized (PooledMutableBlockPos.POOL) {
                if (PooledMutableBlockPos.POOL.size() < 100) {
                    PooledMutableBlockPos.POOL.add(this);
                }
                this.released = true;
            }
            // monitorexit(PooledMutableBlockPos.POOL)
        }
        
        public static PooledMutableBlockPos retain(final Vec3i llllllllllllllIlIIIllllIIIIIIIIl) {
            return retain(llllllllllllllIlIIIllllIIIIIIIIl.getX(), llllllllllllllIlIIIllllIIIIIIIIl.getY(), llllllllllllllIlIIIllllIIIIIIIIl.getZ());
        }
        
        @Override
        public PooledMutableBlockPos move(final EnumFacing llllllllllllllIlIIIlllIlllIIIlII) {
            return (PooledMutableBlockPos)super.move(llllllllllllllIlIIIlllIlllIIIlII);
        }
        
        @Override
        public PooledMutableBlockPos setPos(final Vec3i llllllllllllllIlIIIlllIlllIIllII) {
            return (PooledMutableBlockPos)super.setPos(llllllllllllllIlIIIlllIlllIIllII);
        }
        
        @Override
        public PooledMutableBlockPos setPos(final Entity llllllllllllllIlIIIlllIlllIllllI) {
            return (PooledMutableBlockPos)super.setPos(llllllllllllllIlIIIlllIlllIllllI);
        }
        
        @Override
        public PooledMutableBlockPos setPos(final double llllllllllllllIlIIIlllIlllIlIIlI, final double llllllllllllllIlIIIlllIlllIlIIIl, final double llllllllllllllIlIIIlllIlllIlIlII) {
            return (PooledMutableBlockPos)super.setPos(llllllllllllllIlIIIlllIlllIlIIlI, llllllllllllllIlIIIlllIlllIlIIIl, llllllllllllllIlIIIlllIlllIlIlII);
        }
        
        public static PooledMutableBlockPos retain(final double llllllllllllllIlIIIllllIIIIIlIIl, final double llllllllllllllIlIIIllllIIIIIlIII, final double llllllllllllllIlIIIllllIIIIIIlII) {
            return retain(MathHelper.floor(llllllllllllllIlIIIllllIIIIIlIIl), MathHelper.floor(llllllllllllllIlIIIllllIIIIIlIII), MathHelper.floor(llllllllllllllIlIIIllllIIIIIIlII));
        }
        
        static {
            POOL = Lists.newArrayList();
        }
        
        private PooledMutableBlockPos(final int llllllllllllllIlIIIllllIIIIIllll, final int llllllllllllllIlIIIllllIIIIlIIlI, final int llllllllllllllIlIIIllllIIIIlIIIl) {
            super(llllllllllllllIlIIIllllIIIIIllll, llllllllllllllIlIIIllllIIIIlIIlI, llllllllllllllIlIIIllllIIIIlIIIl);
        }
        
        @Override
        public PooledMutableBlockPos move(final EnumFacing llllllllllllllIlIIIlllIllIllllll, final int llllllllllllllIlIIIlllIllIlllllI) {
            return (PooledMutableBlockPos)super.move(llllllllllllllIlIIIlllIllIllllll, llllllllllllllIlIIIlllIllIlllllI);
        }
        
        public static PooledMutableBlockPos retain(final int llllllllllllllIlIIIlllIllllllIll, final int llllllllllllllIlIIIlllIllllllIlI, final int llllllllllllllIlIIIlllIllllllIIl) {
            synchronized (PooledMutableBlockPos.POOL) {
                if (!PooledMutableBlockPos.POOL.isEmpty()) {
                    final PooledMutableBlockPos llllllllllllllIlIIIlllIllllllIII = PooledMutableBlockPos.POOL.remove(PooledMutableBlockPos.POOL.size() - 1);
                    if (llllllllllllllIlIIIlllIllllllIII != null && llllllllllllllIlIIIlllIllllllIII.released) {
                        llllllllllllllIlIIIlllIllllllIII.released = false;
                        llllllllllllllIlIIIlllIllllllIII.setPos(llllllllllllllIlIIIlllIllllllIll, llllllllllllllIlIIIlllIllllllIlI, llllllllllllllIlIIIlllIllllllIIl);
                        // monitorexit(PooledMutableBlockPos.POOL)
                        return llllllllllllllIlIIIlllIllllllIII;
                    }
                }
            }
            // monitorexit(PooledMutableBlockPos.POOL)
            return new PooledMutableBlockPos(llllllllllllllIlIIIlllIllllllIll, llllllllllllllIlIIIlllIllllllIlI, llllllllllllllIlIIIlllIllllllIIl);
        }
    }
    
    public static class MutableBlockPos extends BlockPos
    {
        protected /* synthetic */ int x;
        protected /* synthetic */ int y;
        protected /* synthetic */ int z;
        
        @Override
        public BlockPos toImmutable() {
            return new BlockPos(this);
        }
        
        public MutableBlockPos move(final EnumFacing lllllllllllllllllllIIllllIlIlIIl) {
            return this.move(lllllllllllllllllllIIllllIlIlIIl, 1);
        }
        
        public MutableBlockPos setPos(final Entity lllllllllllllllllllIIllllIllllll) {
            return this.setPos(lllllllllllllllllllIIllllIllllll.posX, lllllllllllllllllllIIllllIllllll.posY, lllllllllllllllllllIIllllIllllll.posZ);
        }
        
        public MutableBlockPos setPos(final int lllllllllllllllllllIIlllllIIIlll, final int lllllllllllllllllllIIlllllIIIllI, final int lllllllllllllllllllIIlllllIIIlIl) {
            this.x = lllllllllllllllllllIIlllllIIIlll;
            this.y = lllllllllllllllllllIIlllllIIIllI;
            this.z = lllllllllllllllllllIIlllllIIIlIl;
            return this;
        }
        
        @Override
        public BlockPos add(final int lllllllllllllllllllIIllllllIllll, final int lllllllllllllllllllIIllllllIlllI, final int lllllllllllllllllllIIllllllIlIIl) {
            return super.add(lllllllllllllllllllIIllllllIllll, lllllllllllllllllllIIllllllIlllI, lllllllllllllllllllIIllllllIlIIl).toImmutable();
        }
        
        public MutableBlockPos(final int lllllllllllllllllllIlIIIIIIIIlll, final int lllllllllllllllllllIlIIIIIIIIllI, final int lllllllllllllllllllIlIIIIIIIIIIl) {
            super(0, 0, 0);
            this.x = lllllllllllllllllllIlIIIIIIIIlll;
            this.y = lllllllllllllllllllIlIIIIIIIIllI;
            this.z = lllllllllllllllllllIlIIIIIIIIIIl;
        }
        
        public MutableBlockPos setPos(final double lllllllllllllllllllIIllllIllIlIl, final double lllllllllllllllllllIIllllIllIlII, final double lllllllllllllllllllIIllllIllIlll) {
            return this.setPos(MathHelper.floor(lllllllllllllllllllIIllllIllIlIl), MathHelper.floor(lllllllllllllllllllIIllllIllIlII), MathHelper.floor(lllllllllllllllllllIIllllIllIlll));
        }
        
        @Override
        public BlockPos add(final double lllllllllllllllllllIIlllllllIlll, final double lllllllllllllllllllIIllllllllIlI, final double lllllllllllllllllllIIllllllllIIl) {
            return super.add(lllllllllllllllllllIIlllllllIlll, lllllllllllllllllllIIllllllllIlI, lllllllllllllllllllIIllllllllIIl).toImmutable();
        }
        
        public MutableBlockPos(final BlockPos lllllllllllllllllllIlIIIIIIIllll) {
            this(lllllllllllllllllllIlIIIIIIIllll.getX(), lllllllllllllllllllIlIIIIIIIllll.getY(), lllllllllllllllllllIlIIIIIIIllll.getZ());
        }
        
        @Override
        public int getY() {
            return this.y;
        }
        
        @Override
        public int getX() {
            return this.x;
        }
        
        @Override
        public int getZ() {
            return this.z;
        }
        
        public void setY(final int lllllllllllllllllllIIllllIIllIlI) {
            this.y = lllllllllllllllllllIIllllIIllIlI;
        }
        
        @Override
        public BlockPos offset(final EnumFacing lllllllllllllllllllIIllllllIIlII, final int lllllllllllllllllllIIllllllIIIII) {
            return super.offset(lllllllllllllllllllIIllllllIIlII, lllllllllllllllllllIIllllllIIIII).toImmutable();
        }
        
        public MutableBlockPos() {
            this(0, 0, 0);
        }
        
        public MutableBlockPos setPos(final Vec3i lllllllllllllllllllIIllllIlIllll) {
            return this.setPos(lllllllllllllllllllIIllllIlIllll.getX(), lllllllllllllllllllIIllllIlIllll.getY(), lllllllllllllllllllIIllllIlIllll.getZ());
        }
        
        @Override
        public BlockPos func_190942_a(final Rotation lllllllllllllllllllIIlllllIllIlI) {
            return super.func_190942_a(lllllllllllllllllllIIlllllIllIlI).toImmutable();
        }
        
        public MutableBlockPos move(final EnumFacing lllllllllllllllllllIIllllIlIIIlI, final int lllllllllllllllllllIIllllIIllllI) {
            return this.setPos(this.x + lllllllllllllllllllIIllllIlIIIlI.getFrontOffsetX() * lllllllllllllllllllIIllllIIllllI, this.y + lllllllllllllllllllIIllllIlIIIlI.getFrontOffsetY() * lllllllllllllllllllIIllllIIllllI, this.z + lllllllllllllllllllIIllllIlIIIlI.getFrontOffsetZ() * lllllllllllllllllllIIllllIIllllI);
        }
    }
}
