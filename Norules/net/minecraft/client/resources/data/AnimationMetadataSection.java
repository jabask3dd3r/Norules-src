package net.minecraft.client.resources.data;

import java.util.*;
import com.google.common.collect.*;

public class AnimationMetadataSection implements IMetadataSection
{
    private final /* synthetic */ List<AnimationFrame> animationFrames;
    private final /* synthetic */ int frameHeight;
    private final /* synthetic */ int frameTime;
    private final /* synthetic */ boolean interpolate;
    private final /* synthetic */ int frameWidth;
    
    public int getFrameTimeSingle(final int llllllllllllllIllIIIllllIllllIII) {
        final AnimationFrame llllllllllllllIllIIIllllIllllIlI = this.getAnimationFrame(llllllllllllllIllIIIllllIllllIII);
        return llllllllllllllIllIIIllllIllllIlI.hasNoTime() ? this.frameTime : llllllllllllllIllIIIllllIllllIlI.getFrameTime();
    }
    
    public AnimationMetadataSection(final List<AnimationFrame> llllllllllllllIllIIIlllllIIlllll, final int llllllllllllllIllIIIlllllIIllIII, final int llllllllllllllIllIIIlllllIIlIlll, final int llllllllllllllIllIIIlllllIIlllII, final boolean llllllllllllllIllIIIlllllIIllIll) {
        this.animationFrames = llllllllllllllIllIIIlllllIIlllll;
        this.frameWidth = llllllllllllllIllIIIlllllIIllIII;
        this.frameHeight = llllllllllllllIllIIIlllllIIlIlll;
        this.frameTime = llllllllllllllIllIIIlllllIIlllII;
        this.interpolate = llllllllllllllIllIIIlllllIIllIll;
    }
    
    public boolean isInterpolate() {
        return this.interpolate;
    }
    
    public int getFrameIndex(final int llllllllllllllIllIIIllllIllIllIl) {
        return this.animationFrames.get(llllllllllllllIllIIIllllIllIllIl).getFrameIndex();
    }
    
    public Set<Integer> getFrameIndexSet() {
        final Set<Integer> llllllllllllllIllIIIllllIllIIlIl = (Set<Integer>)Sets.newHashSet();
        for (final AnimationFrame llllllllllllllIllIIIllllIllIIlII : this.animationFrames) {
            llllllllllllllIllIIIllllIllIIlIl.add(llllllllllllllIllIIIllllIllIIlII.getFrameIndex());
        }
        return llllllllllllllIllIIIllllIllIIlIl;
    }
    
    public int getFrameCount() {
        return this.animationFrames.size();
    }
    
    public int getFrameTime() {
        return this.frameTime;
    }
    
    public int getFrameWidth() {
        return this.frameWidth;
    }
    
    public int getFrameHeight() {
        return this.frameHeight;
    }
    
    public boolean frameHasTime(final int llllllllllllllIllIIIllllIlllIIIl) {
        return !this.animationFrames.get(llllllllllllllIllIIIllllIlllIIIl).hasNoTime();
    }
    
    private AnimationFrame getAnimationFrame(final int llllllllllllllIllIIIlllllIIIIIII) {
        return this.animationFrames.get(llllllllllllllIllIIIlllllIIIIIII);
    }
}
