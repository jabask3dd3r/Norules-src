package net.minecraft.util;

public class FrameTimer
{
    private /* synthetic */ int index;
    private /* synthetic */ int lastIndex;
    private /* synthetic */ int counter;
    private final /* synthetic */ long[] frames;
    
    public FrameTimer() {
        this.frames = new long[240];
    }
    
    public int getLastIndex() {
        return this.lastIndex;
    }
    
    public long[] getFrames() {
        return this.frames;
    }
    
    public int parseIndex(final int lllllllllllllIIIlIIllIlllIIlIIII) {
        return lllllllllllllIIIlIIllIlllIIlIIII % 240;
    }
    
    public void addFrame(final long lllllllllllllIIIlIIllIlllIlIIIll) {
        this.frames[this.index] = lllllllllllllIIIlIIllIlllIlIIIll;
        ++this.index;
        if (this.index == 240) {
            this.index = 0;
        }
        if (this.counter < 240) {
            this.lastIndex = 0;
            ++this.counter;
        }
        else {
            this.lastIndex = this.parseIndex(this.index + 1);
        }
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public int getLagometerValue(final long lllllllllllllIIIlIIllIlllIIllllI, final int lllllllllllllIIIlIIllIlllIIlllIl) {
        final double lllllllllllllIIIlIIllIlllIIlllII = lllllllllllllIIIlIIllIlllIIllllI / 1.6666666E7;
        return (int)(lllllllllllllIIIlIIllIlllIIlllII * lllllllllllllIIIlIIllIlllIIlllIl);
    }
}
