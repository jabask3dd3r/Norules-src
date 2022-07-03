package shadersmod.client;

import java.util.*;
import optifine.*;
import net.minecraft.util.math.*;

public class Iterator3d implements Iterator<BlockPos>
{
    private /* synthetic */ int axis;
    private /* synthetic */ int kZ;
    private /* synthetic */ BlockPosM blockPos;
    private /* synthetic */ int kY;
    private /* synthetic */ IteratorAxis iteratorAxis;
    private /* synthetic */ int kX;
    
    @Override
    public BlockPos next() {
        final BlockPos lllllllllllllIIIIIllllIIIllIlIlI = this.iteratorAxis.next();
        switch (this.axis) {
            case 0: {
                this.blockPos.setXyz(lllllllllllllIIIIIllllIIIllIlIlI.getX() * this.kX, lllllllllllllIIIIIllllIIIllIlIlI.getY() * this.kY, lllllllllllllIIIIIllllIIIllIlIlI.getZ() * this.kZ);
                return this.blockPos;
            }
            case 1: {
                this.blockPos.setXyz(lllllllllllllIIIIIllllIIIllIlIlI.getY() * this.kX, lllllllllllllIIIIIllllIIIllIlIlI.getX() * this.kY, lllllllllllllIIIIIllllIIIllIlIlI.getZ() * this.kZ);
                return this.blockPos;
            }
            case 2: {
                this.blockPos.setXyz(lllllllllllllIIIIIllllIIIllIlIlI.getZ() * this.kX, lllllllllllllIIIIIllllIIIllIlIlI.getY() * this.kY, lllllllllllllIIIIIllllIIIllIlIlI.getX() * this.kZ);
                return this.blockPos;
            }
            default: {
                this.blockPos.setXyz(lllllllllllllIIIIIllllIIIllIlIlI.getX() * this.kX, lllllllllllllIIIIIllllIIIllIlIlI.getY() * this.kY, lllllllllllllIIIIIllllIIIllIlIlI.getZ() * this.kZ);
                return this.blockPos;
            }
        }
    }
    
    static {
        AXIS_X = 0;
        AXIS_Y = 1;
        AXIS_Z = 2;
    }
    
    @Override
    public boolean hasNext() {
        return this.iteratorAxis.hasNext();
    }
    
    @Override
    public void remove() {
        throw new RuntimeException("Not supported");
    }
    
    public static void main(final String[] lllllllllllllIIIIIllllIIIllIIIlI) {
        final BlockPos lllllllllllllIIIIIllllIIIllIIIIl = new BlockPos(10, 20, 30);
        final BlockPos lllllllllllllIIIIIllllIIIllIIIII = new BlockPos(30, 40, 20);
        final Iterator3d lllllllllllllIIIIIllllIIIlIlllll = new Iterator3d(lllllllllllllIIIIIllllIIIllIIIIl, lllllllllllllIIIIIllllIIIllIIIII, 1, 1);
        while (lllllllllllllIIIIIllllIIIlIlllll.hasNext()) {
            final BlockPos lllllllllllllIIIIIllllIIIlIllllI = lllllllllllllIIIIIllllIIIlIlllll.next();
            System.out.println(String.valueOf(new StringBuilder().append(lllllllllllllIIIIIllllIIIlIllllI)));
        }
    }
    
    public Iterator3d(BlockPos lllllllllllllIIIIIllllIIlIllIllI, BlockPos lllllllllllllIIIIIllllIIlIllIlIl, final int lllllllllllllIIIIIllllIIlIllIlII, final int lllllllllllllIIIIIllllIIlIllIIll) {
        this.blockPos = new BlockPosM(0, 0, 0);
        this.axis = 0;
        final boolean lllllllllllllIIIIIllllIIlIllIIlI = lllllllllllllIIIIIllllIIlIllIllI.getX() > lllllllllllllIIIIIllllIIlIllIlIl.getX();
        final boolean lllllllllllllIIIIIllllIIlIllIIIl = lllllllllllllIIIIIllllIIlIllIllI.getY() > lllllllllllllIIIIIllllIIlIllIlIl.getY();
        final boolean lllllllllllllIIIIIllllIIlIllIIII = lllllllllllllIIIIIllllIIlIllIllI.getZ() > lllllllllllllIIIIIllllIIlIllIlIl.getZ();
        lllllllllllllIIIIIllllIIlIllIllI = this.reverseCoord(lllllllllllllIIIIIllllIIlIllIllI, lllllllllllllIIIIIllllIIlIllIIlI, lllllllllllllIIIIIllllIIlIllIIIl, lllllllllllllIIIIIllllIIlIllIIII);
        lllllllllllllIIIIIllllIIlIllIlIl = this.reverseCoord(lllllllllllllIIIIIllllIIlIllIlIl, lllllllllllllIIIIIllllIIlIllIIlI, lllllllllllllIIIIIllllIIlIllIIIl, lllllllllllllIIIIIllllIIlIllIIII);
        this.kX = (lllllllllllllIIIIIllllIIlIllIIlI ? -1 : 1);
        this.kY = (lllllllllllllIIIIIllllIIlIllIIIl ? -1 : 1);
        this.kZ = (lllllllllllllIIIIIllllIIlIllIIII ? -1 : 1);
        final Vec3d lllllllllllllIIIIIllllIIlIlIllll = new Vec3d(lllllllllllllIIIIIllllIIlIllIlIl.getX() - lllllllllllllIIIIIllllIIlIllIllI.getX(), lllllllllllllIIIIIllllIIlIllIlIl.getY() - lllllllllllllIIIIIllllIIlIllIllI.getY(), lllllllllllllIIIIIllllIIlIllIlIl.getZ() - lllllllllllllIIIIIllllIIlIllIllI.getZ());
        final Vec3d lllllllllllllIIIIIllllIIlIlIlllI = lllllllllllllIIIIIllllIIlIlIllll.normalize();
        final Vec3d lllllllllllllIIIIIllllIIlIlIllIl = new Vec3d(1.0, 0.0, 0.0);
        final double lllllllllllllIIIIIllllIIlIlIllII = lllllllllllllIIIIIllllIIlIlIlllI.dotProduct(lllllllllllllIIIIIllllIIlIlIllIl);
        final double lllllllllllllIIIIIllllIIlIlIlIll = Math.abs(lllllllllllllIIIIIllllIIlIlIllII);
        final Vec3d lllllllllllllIIIIIllllIIlIlIlIlI = new Vec3d(0.0, 1.0, 0.0);
        final double lllllllllllllIIIIIllllIIlIlIlIIl = lllllllllllllIIIIIllllIIlIlIlllI.dotProduct(lllllllllllllIIIIIllllIIlIlIlIlI);
        final double lllllllllllllIIIIIllllIIlIlIlIII = Math.abs(lllllllllllllIIIIIllllIIlIlIlIIl);
        final Vec3d lllllllllllllIIIIIllllIIlIlIIlll = new Vec3d(0.0, 0.0, 1.0);
        final double lllllllllllllIIIIIllllIIlIlIIllI = lllllllllllllIIIIIllllIIlIlIlllI.dotProduct(lllllllllllllIIIIIllllIIlIlIIlll);
        final double lllllllllllllIIIIIllllIIlIlIIlIl = Math.abs(lllllllllllllIIIIIllllIIlIlIIllI);
        if (lllllllllllllIIIIIllllIIlIlIIlIl >= lllllllllllllIIIIIllllIIlIlIlIII && lllllllllllllIIIIIllllIIlIlIIlIl >= lllllllllllllIIIIIllllIIlIlIlIll) {
            this.axis = 2;
            final BlockPos lllllllllllllIIIIIllllIIlIlIIlII = new BlockPos(lllllllllllllIIIIIllllIIlIllIllI.getZ(), lllllllllllllIIIIIllllIIlIllIllI.getY() - lllllllllllllIIIIIllllIIlIllIlII, lllllllllllllIIIIIllllIIlIllIllI.getX() - lllllllllllllIIIIIllllIIlIllIIll);
            final BlockPos lllllllllllllIIIIIllllIIlIlIIIll = new BlockPos(lllllllllllllIIIIIllllIIlIllIlIl.getZ(), lllllllllllllIIIIIllllIIlIllIllI.getY() + lllllllllllllIIIIIllllIIlIllIlII + 1, lllllllllllllIIIIIllllIIlIllIllI.getX() + lllllllllllllIIIIIllllIIlIllIIll + 1);
            final int lllllllllllllIIIIIllllIIlIlIIIlI = lllllllllllllIIIIIllllIIlIllIlIl.getZ() - lllllllllllllIIIIIllllIIlIllIllI.getZ();
            final double lllllllllllllIIIIIllllIIlIlIIIIl = (lllllllllllllIIIIIllllIIlIllIlIl.getY() - lllllllllllllIIIIIllllIIlIllIllI.getY()) / (1.0 * lllllllllllllIIIIIllllIIlIlIIIlI);
            final double lllllllllllllIIIIIllllIIlIlIIIII = (lllllllllllllIIIIIllllIIlIllIlIl.getX() - lllllllllllllIIIIIllllIIlIllIllI.getX()) / (1.0 * lllllllllllllIIIIIllllIIlIlIIIlI);
            this.iteratorAxis = new IteratorAxis(lllllllllllllIIIIIllllIIlIlIIlII, lllllllllllllIIIIIllllIIlIlIIIll, lllllllllllllIIIIIllllIIlIlIIIIl, lllllllllllllIIIIIllllIIlIlIIIII);
        }
        else if (lllllllllllllIIIIIllllIIlIlIlIII >= lllllllllllllIIIIIllllIIlIlIlIll && lllllllllllllIIIIIllllIIlIlIlIII >= lllllllllllllIIIIIllllIIlIlIIlIl) {
            this.axis = 1;
            final BlockPos lllllllllllllIIIIIllllIIlIIlllll = new BlockPos(lllllllllllllIIIIIllllIIlIllIllI.getY(), lllllllllllllIIIIIllllIIlIllIllI.getX() - lllllllllllllIIIIIllllIIlIllIlII, lllllllllllllIIIIIllllIIlIllIllI.getZ() - lllllllllllllIIIIIllllIIlIllIIll);
            final BlockPos lllllllllllllIIIIIllllIIlIIllllI = new BlockPos(lllllllllllllIIIIIllllIIlIllIlIl.getY(), lllllllllllllIIIIIllllIIlIllIllI.getX() + lllllllllllllIIIIIllllIIlIllIlII + 1, lllllllllllllIIIIIllllIIlIllIllI.getZ() + lllllllllllllIIIIIllllIIlIllIIll + 1);
            final int lllllllllllllIIIIIllllIIlIIlllIl = lllllllllllllIIIIIllllIIlIllIlIl.getY() - lllllllllllllIIIIIllllIIlIllIllI.getY();
            final double lllllllllllllIIIIIllllIIlIIlllII = (lllllllllllllIIIIIllllIIlIllIlIl.getX() - lllllllllllllIIIIIllllIIlIllIllI.getX()) / (1.0 * lllllllllllllIIIIIllllIIlIIlllIl);
            final double lllllllllllllIIIIIllllIIlIIllIll = (lllllllllllllIIIIIllllIIlIllIlIl.getZ() - lllllllllllllIIIIIllllIIlIllIllI.getZ()) / (1.0 * lllllllllllllIIIIIllllIIlIIlllIl);
            this.iteratorAxis = new IteratorAxis(lllllllllllllIIIIIllllIIlIIlllll, lllllllllllllIIIIIllllIIlIIllllI, lllllllllllllIIIIIllllIIlIIlllII, lllllllllllllIIIIIllllIIlIIllIll);
        }
        else {
            this.axis = 0;
            final BlockPos lllllllllllllIIIIIllllIIlIIllIlI = new BlockPos(lllllllllllllIIIIIllllIIlIllIllI.getX(), lllllllllllllIIIIIllllIIlIllIllI.getY() - lllllllllllllIIIIIllllIIlIllIlII, lllllllllllllIIIIIllllIIlIllIllI.getZ() - lllllllllllllIIIIIllllIIlIllIIll);
            final BlockPos lllllllllllllIIIIIllllIIlIIllIIl = new BlockPos(lllllllllllllIIIIIllllIIlIllIlIl.getX(), lllllllllllllIIIIIllllIIlIllIllI.getY() + lllllllllllllIIIIIllllIIlIllIlII + 1, lllllllllllllIIIIIllllIIlIllIllI.getZ() + lllllllllllllIIIIIllllIIlIllIIll + 1);
            final int lllllllllllllIIIIIllllIIlIIllIII = lllllllllllllIIIIIllllIIlIllIlIl.getX() - lllllllllllllIIIIIllllIIlIllIllI.getX();
            final double lllllllllllllIIIIIllllIIlIIlIlll = (lllllllllllllIIIIIllllIIlIllIlIl.getY() - lllllllllllllIIIIIllllIIlIllIllI.getY()) / (1.0 * lllllllllllllIIIIIllllIIlIIllIII);
            final double lllllllllllllIIIIIllllIIlIIlIllI = (lllllllllllllIIIIIllllIIlIllIlIl.getZ() - lllllllllllllIIIIIllllIIlIllIllI.getZ()) / (1.0 * lllllllllllllIIIIIllllIIlIIllIII);
            this.iteratorAxis = new IteratorAxis(lllllllllllllIIIIIllllIIlIIllIlI, lllllllllllllIIIIIllllIIlIIllIIl, lllllllllllllIIIIIllllIIlIIlIlll, lllllllllllllIIIIIllllIIlIIlIllI);
        }
    }
    
    private BlockPos reverseCoord(BlockPos lllllllllllllIIIIIllllIIIlllIlII, final boolean lllllllllllllIIIIIllllIIIlllIIll, final boolean lllllllllllllIIIIIllllIIIlllIIlI, final boolean lllllllllllllIIIIIllllIIIlllIIIl) {
        if (lllllllllllllIIIIIllllIIIlllIIll) {
            lllllllllllllIIIIIllllIIIlllIlII = new BlockPos(-lllllllllllllIIIIIllllIIIlllIlII.getX(), lllllllllllllIIIIIllllIIIlllIlII.getY(), lllllllllllllIIIIIllllIIIlllIlII.getZ());
        }
        if (lllllllllllllIIIIIllllIIIlllIIlI) {
            lllllllllllllIIIIIllllIIIlllIlII = new BlockPos(lllllllllllllIIIIIllllIIIlllIlII.getX(), -lllllllllllllIIIIIllllIIIlllIlII.getY(), lllllllllllllIIIIIllllIIIlllIlII.getZ());
        }
        if (lllllllllllllIIIIIllllIIIlllIIIl) {
            lllllllllllllIIIIIllllIIIlllIlII = new BlockPos(lllllllllllllIIIIIllllIIIlllIlII.getX(), lllllllllllllIIIIIllllIIIlllIlII.getY(), -lllllllllllllIIIIIllllIIIlllIlII.getZ());
        }
        return lllllllllllllIIIIIllllIIIlllIlII;
    }
}
