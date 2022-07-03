package shadersmod.client;

import net.minecraft.util.math.*;
import optifine.*;
import java.util.*;

public class IteratorAxis implements Iterator<BlockPos>
{
    private /* synthetic */ double yEnd;
    private /* synthetic */ double yDelta;
    private /* synthetic */ int xNext;
    private /* synthetic */ double zStart;
    private /* synthetic */ int xStart;
    private /* synthetic */ int xEnd;
    private /* synthetic */ double zNext;
    private /* synthetic */ double yStart;
    private /* synthetic */ double zEnd;
    private /* synthetic */ double zDelta;
    private /* synthetic */ BlockPosM pos;
    private /* synthetic */ boolean hasNext;
    private /* synthetic */ double yNext;
    
    @Override
    public BlockPos next() {
        if (!this.hasNext) {
            throw new NoSuchElementException();
        }
        this.pos.setXyz(this.xNext, this.yNext, this.zNext);
        this.nextPos();
        this.hasNext = (this.xNext < this.xEnd && this.yNext < this.yEnd && this.zNext < this.zEnd);
        return this.pos;
    }
    
    @Override
    public void remove() {
        throw new RuntimeException("Not implemented");
    }
    
    private void nextPos() {
        ++this.zNext;
        if (this.zNext >= this.zEnd) {
            this.zNext = this.zStart;
            ++this.yNext;
            if (this.yNext >= this.yEnd) {
                this.yNext = this.yStart;
                this.yStart += this.yDelta;
                this.yEnd += this.yDelta;
                this.yNext = this.yStart;
                this.zStart += this.zDelta;
                this.zEnd += this.zDelta;
                this.zNext = this.zStart;
                ++this.xNext;
                if (this.xNext >= this.xEnd) {}
            }
        }
    }
    
    public IteratorAxis(final BlockPos llllllllllllllIllIIlIIlllllllIIl, final BlockPos llllllllllllllIllIIlIIllllllIIll, final double llllllllllllllIllIIlIIllllllIlll, final double llllllllllllllIllIIlIIllllllIIIl) {
        this.pos = new BlockPosM(0, 0, 0);
        this.hasNext = false;
        this.yDelta = llllllllllllllIllIIlIIllllllIlll;
        this.zDelta = llllllllllllllIllIIlIIllllllIIIl;
        this.xStart = llllllllllllllIllIIlIIlllllllIIl.getX();
        this.xEnd = llllllllllllllIllIIlIIllllllIIll.getX();
        this.yStart = llllllllllllllIllIIlIIlllllllIIl.getY();
        this.yEnd = llllllllllllllIllIIlIIllllllIIll.getY() - 0.5;
        this.zStart = llllllllllllllIllIIlIIlllllllIIl.getZ();
        this.zEnd = llllllllllllllIllIIlIIllllllIIll.getZ() - 0.5;
        this.xNext = this.xStart;
        this.yNext = this.yStart;
        this.zNext = this.zStart;
        this.hasNext = (this.xNext < this.xEnd && this.yNext < this.yEnd && this.zNext < this.zEnd);
    }
    
    public static void main(final String[] llllllllllllllIllIIlIIlllllIIIII) throws Exception {
        final BlockPos llllllllllllllIllIIlIIllllIlllll = new BlockPos(-2, 10, 20);
        final BlockPos llllllllllllllIllIIlIIllllIllllI = new BlockPos(2, 12, 22);
        final double llllllllllllllIllIIlIIllllIlllIl = -0.5;
        final double llllllllllllllIllIIlIIllllIlllII = 0.5;
        final IteratorAxis llllllllllllllIllIIlIIllllIllIll = new IteratorAxis(llllllllllllllIllIIlIIllllIlllll, llllllllllllllIllIIlIIllllIllllI, llllllllllllllIllIIlIIllllIlllIl, llllllllllllllIllIIlIIllllIlllII);
        System.out.println(String.valueOf(new StringBuilder("Start: ").append(llllllllllllllIllIIlIIllllIlllll).append(", end: ").append(llllllllllllllIllIIlIIllllIllllI).append(", yDelta: ").append(llllllllllllllIllIIlIIllllIlllIl).append(", zDelta: ").append(llllllllllllllIllIIlIIllllIlllII)));
        while (llllllllllllllIllIIlIIllllIllIll.hasNext()) {
            final BlockPos llllllllllllllIllIIlIIllllIllIlI = llllllllllllllIllIIlIIllllIllIll.next();
            System.out.println(String.valueOf(new StringBuilder().append(llllllllllllllIllIIlIIllllIllIlI)));
        }
    }
    
    @Override
    public boolean hasNext() {
        return this.hasNext;
    }
}
