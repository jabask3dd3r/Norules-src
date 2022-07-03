package optifine;

import net.minecraft.util.*;
import net.minecraft.util.math.*;
import java.util.*;
import com.google.common.collect.*;

public class BlockPosM extends BlockPos
{
    private /* synthetic */ int my;
    private /* synthetic */ int mz;
    private /* synthetic */ int mx;
    private /* synthetic */ int level;
    private /* synthetic */ BlockPosM[] facings;
    private /* synthetic */ boolean needsUpdate;
    
    @Override
    public int getY() {
        return this.my;
    }
    
    private void update() {
        for (int lllllllllllllIIlIlIIllIIIIIlllII = 0; lllllllllllllIIlIlIIllIIIIIlllII < 6; ++lllllllllllllIIlIlIIllIIIIIlllII) {
            final BlockPosM lllllllllllllIIlIlIIllIIIIIllIll = this.facings[lllllllllllllIIlIlIIllIIIIIlllII];
            if (lllllllllllllIIlIlIIllIIIIIllIll != null) {
                final EnumFacing lllllllllllllIIlIlIIllIIIIIllIlI = EnumFacing.VALUES[lllllllllllllIIlIlIIllIIIIIlllII];
                final int lllllllllllllIIlIlIIllIIIIIllIIl = this.mx + lllllllllllllIIlIlIIllIIIIIllIlI.getFrontOffsetX();
                final int lllllllllllllIIlIlIIllIIIIIllIII = this.my + lllllllllllllIIlIlIIllIIIIIllIlI.getFrontOffsetY();
                final int lllllllllllllIIlIlIIllIIIIIlIlll = this.mz + lllllllllllllIIlIlIIllIIIIIllIlI.getFrontOffsetZ();
                lllllllllllllIIlIlIIllIIIIIllIll.setXyz(lllllllllllllIIlIlIIllIIIIIllIIl, lllllllllllllIIlIlIIllIIIIIllIII, lllllllllllllIIlIlIIllIIIIIlIlll);
            }
        }
        this.needsUpdate = false;
    }
    
    public void setXyz(final double lllllllllllllIIlIlIIllIIIlIIlIIl, final double lllllllllllllIIlIlIIllIIIlIIIlII, final double lllllllllllllIIlIlIIllIIIlIIIIll) {
        this.setXyz(MathHelper.floor(lllllllllllllIIlIlIIllIIIlIIlIIl), MathHelper.floor(lllllllllllllIIlIlIIllIIIlIIIlII), MathHelper.floor(lllllllllllllIIlIlIIllIIIlIIIIll));
    }
    
    public void setXyz(final int lllllllllllllIIlIlIIllIIIlIlIIIl, final int lllllllllllllIIlIlIIllIIIlIlIIII, final int lllllllllllllIIlIlIIllIIIlIIllll) {
        this.mx = lllllllllllllIIlIlIIllIIIlIlIIIl;
        this.my = lllllllllllllIIlIlIIllIIIlIlIIII;
        this.mz = lllllllllllllIIlIlIIllIIIlIIllll;
        this.needsUpdate = true;
    }
    
    @Override
    public BlockPos offset(final EnumFacing lllllllllllllIIlIlIIllIIIIllIIll) {
        if (this.level <= 0) {
            return super.offset(lllllllllllllIIlIlIIllIIIIllIIll, 1).toImmutable();
        }
        if (this.facings == null) {
            this.facings = new BlockPosM[EnumFacing.VALUES.length];
        }
        if (this.needsUpdate) {
            this.update();
        }
        final int lllllllllllllIIlIlIIllIIIIlllIIl = lllllllllllllIIlIlIIllIIIIllIIll.getIndex();
        BlockPosM lllllllllllllIIlIlIIllIIIIlllIII = this.facings[lllllllllllllIIlIlIIllIIIIlllIIl];
        if (lllllllllllllIIlIlIIllIIIIlllIII == null) {
            final int lllllllllllllIIlIlIIllIIIIllIlll = this.mx + lllllllllllllIIlIlIIllIIIIllIIll.getFrontOffsetX();
            final int lllllllllllllIIlIlIIllIIIIllIllI = this.my + lllllllllllllIIlIlIIllIIIIllIIll.getFrontOffsetY();
            final int lllllllllllllIIlIlIIllIIIIllIlIl = this.mz + lllllllllllllIIlIlIIllIIIIllIIll.getFrontOffsetZ();
            lllllllllllllIIlIlIIllIIIIlllIII = new BlockPosM(lllllllllllllIIlIlIIllIIIIllIlll, lllllllllllllIIlIlIIllIIIIllIllI, lllllllllllllIIlIlIIllIIIIllIlIl, this.level - 1);
            this.facings[lllllllllllllIIlIlIIllIIIIlllIIl] = lllllllllllllIIlIlIIllIIIIlllIII;
        }
        return lllllllllllllIIlIlIIllIIIIlllIII;
    }
    
    @Override
    public BlockPos offset(final EnumFacing lllllllllllllIIlIlIIllIIIIlIIllI, final int lllllllllllllIIlIlIIllIIIIlIIlIl) {
        return (lllllllllllllIIlIlIIllIIIIlIIlIl == 1) ? this.offset(lllllllllllllIIlIlIIllIIIIlIIllI) : super.offset(lllllllllllllIIlIlIIllIIIIlIIllI, lllllllllllllIIlIlIIllIIIIlIIlIl).toImmutable();
    }
    
    @Override
    public int getX() {
        return this.mx;
    }
    
    public BlockPosM(final int lllllllllllllIIlIlIIllIIIllIllII, final int lllllllllllllIIlIlIIllIIIllIlIll, final int lllllllllllllIIlIlIIllIIIllIlIlI, final int lllllllllllllIIlIlIIllIIIllIlIIl) {
        super(0, 0, 0);
        this.mx = lllllllllllllIIlIlIIllIIIllIllII;
        this.my = lllllllllllllIIlIlIIllIIIllIlIll;
        this.mz = lllllllllllllIIlIlIIllIIIllIlIlI;
        this.level = lllllllllllllIIlIlIIllIIIllIlIIl;
    }
    
    @Override
    public BlockPos toImmutable() {
        return new BlockPos(this.mx, this.my, this.mz);
    }
    
    public static Iterable getAllInBoxMutable(final BlockPos lllllllllllllIIlIlIIllIIIIIIlIII, final BlockPos lllllllllllllIIlIlIIllIIIIIIIlll) {
        final BlockPos lllllllllllllIIlIlIIllIIIIIIIllI = new BlockPos(Math.min(lllllllllllllIIlIlIIllIIIIIIlIII.getX(), lllllllllllllIIlIlIIllIIIIIIIlll.getX()), Math.min(lllllllllllllIIlIlIIllIIIIIIlIII.getY(), lllllllllllllIIlIlIIllIIIIIIIlll.getY()), Math.min(lllllllllllllIIlIlIIllIIIIIIlIII.getZ(), lllllllllllllIIlIlIIllIIIIIIIlll.getZ()));
        final BlockPos lllllllllllllIIlIlIIllIIIIIIIlIl = new BlockPos(Math.max(lllllllllllllIIlIlIIllIIIIIIlIII.getX(), lllllllllllllIIlIlIIllIIIIIIIlll.getX()), Math.max(lllllllllllllIIlIlIIllIIIIIIlIII.getY(), lllllllllllllIIlIlIIllIIIIIIIlll.getY()), Math.max(lllllllllllllIIlIlIIllIIIIIIlIII.getZ(), lllllllllllllIIlIlIIllIIIIIIIlll.getZ()));
        return new Iterable() {
            @Override
            public Iterator iterator() {
                return (Iterator)new AbstractIterator() {
                    private /* synthetic */ BlockPosM theBlockPosM = null;
                    
                    protected Object computeNext() {
                        return this.computeNext0();
                    }
                    
                    protected BlockPosM computeNext0() {
                        if (this.theBlockPosM == null) {
                            this.theBlockPosM = new BlockPosM(lllllllllllllIIlIlIIllIIIIIIIllI.getX(), lllllllllllllIIlIlIIllIIIIIIIllI.getY(), lllllllllllllIIlIlIIllIIIIIIIllI.getZ(), 3);
                            return this.theBlockPosM;
                        }
                        if (this.theBlockPosM.equals(lllllllllllllIIlIlIIllIIIIIIIlIl)) {
                            return (BlockPosM)this.endOfData();
                        }
                        int lllllllllllllIIIIIIllllIIllIlIII = this.theBlockPosM.getX();
                        int lllllllllllllIIIIIIllllIIllIIlll = this.theBlockPosM.getY();
                        int lllllllllllllIIIIIIllllIIllIIllI = this.theBlockPosM.getZ();
                        if (lllllllllllllIIIIIIllllIIllIlIII < lllllllllllllIIlIlIIllIIIIIIIlIl.getX()) {
                            ++lllllllllllllIIIIIIllllIIllIlIII;
                        }
                        else if (lllllllllllllIIIIIIllllIIllIIlll < lllllllllllllIIlIlIIllIIIIIIIlIl.getY()) {
                            lllllllllllllIIIIIIllllIIllIlIII = lllllllllllllIIlIlIIllIIIIIIIllI.getX();
                            ++lllllllllllllIIIIIIllllIIllIIlll;
                        }
                        else if (lllllllllllllIIIIIIllllIIllIIllI < lllllllllllllIIlIlIIllIIIIIIIlIl.getZ()) {
                            lllllllllllllIIIIIIllllIIllIlIII = lllllllllllllIIlIlIIllIIIIIIIllI.getX();
                            lllllllllllllIIIIIIllllIIllIIlll = lllllllllllllIIlIlIIllIIIIIIIllI.getY();
                            ++lllllllllllllIIIIIIllllIIllIIllI;
                        }
                        this.theBlockPosM.setXyz(lllllllllllllIIIIIIllllIIllIlIII, lllllllllllllIIIIIIllllIIllIIlll, lllllllllllllIIIIIIllllIIllIIllI);
                        return this.theBlockPosM;
                    }
                };
            }
        };
    }
    
    @Override
    public int getZ() {
        return this.mz;
    }
    
    public BlockPosM(final int lllllllllllllIIlIlIIllIIlIIIIIIl, final int lllllllllllllIIlIlIIllIIlIIIIIII, final int lllllllllllllIIlIlIIllIIIlllllll) {
        this(lllllllllllllIIlIlIIllIIlIIIIIIl, lllllllllllllIIlIlIIllIIlIIIIIII, lllllllllllllIIlIlIIllIIIlllllll, 0);
    }
    
    public BlockPosM(final double lllllllllllllIIlIlIIllIIIlllIlIl, final double lllllllllllllIIlIlIIllIIIlllIlII, final double lllllllllllllIIlIlIIllIIIlllIlll) {
        this(MathHelper.floor(lllllllllllllIIlIlIIllIIIlllIlIl), MathHelper.floor(lllllllllllllIIlIlIIllIIIlllIlII), MathHelper.floor(lllllllllllllIIlIlIIllIIIlllIlll));
    }
}
