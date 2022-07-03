package net.minecraft.client.resources.data;

public class AnimationFrame
{
    private final /* synthetic */ int frameTime;
    private final /* synthetic */ int frameIndex;
    
    public AnimationFrame(final int llllllllllllllIllllIIIIIllIIIllI, final int llllllllllllllIllllIIIIIllIIIlIl) {
        this.frameIndex = llllllllllllllIllllIIIIIllIIIllI;
        this.frameTime = llllllllllllllIllllIIIIIllIIIlIl;
    }
    
    public int getFrameIndex() {
        return this.frameIndex;
    }
    
    public int getFrameTime() {
        return this.frameTime;
    }
    
    public AnimationFrame(final int llllllllllllllIllllIIIIIllIlIIII) {
        this(llllllllllllllIllllIIIIIllIlIIII, -1);
    }
    
    public boolean hasNoTime() {
        return this.frameTime == -1;
    }
}
