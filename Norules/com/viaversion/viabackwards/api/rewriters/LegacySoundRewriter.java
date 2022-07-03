package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

@Deprecated
public abstract class LegacySoundRewriter<T extends BackwardsProtocol> extends RewriterBase<T>
{
    protected final /* synthetic */ Int2ObjectMap<SoundData> soundRewrites;
    
    public SoundData removed(final int lllllllllllllllllIllIIIllIIIlllI) {
        final SoundData lllllllllllllllllIllIIIllIIIllIl = new SoundData(-1, false, -1.0f, false);
        this.soundRewrites.put(lllllllllllllllllIllIIIllIIIlllI, lllllllllllllllllIllIIIllIIIllIl);
        return lllllllllllllllllIllIIIllIIIllIl;
    }
    
    public SoundData added(final int lllllllllllllllllIllIIIllIlIIIll, final int lllllllllllllllllIllIIIllIlIIIlI) {
        return this.added(lllllllllllllllllIllIIIllIlIIIll, lllllllllllllllllIllIIIllIlIIIlI, -1.0f);
    }
    
    public int handleSounds(final int lllllllllllllllllIllIIIllIIIIIIl) {
        int lllllllllllllllllIllIIIllIIIIIII = lllllllllllllllllIllIIIllIIIIIIl;
        final SoundData lllllllllllllllllIllIIIlIlllllll = this.soundRewrites.get(lllllllllllllllllIllIIIllIIIIIIl);
        if (lllllllllllllllllIllIIIlIlllllll != null) {
            return lllllllllllllllllIllIIIlIlllllll.getReplacementSound();
        }
        for (final Int2ObjectMap.Entry<SoundData> lllllllllllllllllIllIIIllIIIIIll : this.soundRewrites.int2ObjectEntrySet()) {
            if (lllllllllllllllllIllIIIllIIIIIIl > lllllllllllllllllIllIIIllIIIIIll.getIntKey()) {
                if (lllllllllllllllllIllIIIllIIIIIll.getValue().isAdded()) {
                    --lllllllllllllllllIllIIIllIIIIIII;
                }
                else {
                    ++lllllllllllllllllIllIIIllIIIIIII;
                }
            }
        }
        return lllllllllllllllllIllIIIllIIIIIII;
    }
    
    protected LegacySoundRewriter(final T lllllllllllllllllIllIIIllIlIllIl) {
        super(lllllllllllllllllIllIIIllIlIllIl);
        this.soundRewrites = new Int2ObjectOpenHashMap<SoundData>(64);
    }
    
    public boolean hasPitch(final int lllllllllllllllllIllIIIlIlllIlII) {
        final SoundData lllllllllllllllllIllIIIlIlllIIll = this.soundRewrites.get(lllllllllllllllllIllIIIlIlllIlII);
        return lllllllllllllllllIllIIIlIlllIIll != null && lllllllllllllllllIllIIIlIlllIIll.isChangePitch();
    }
    
    public float handlePitch(final int lllllllllllllllllIllIIIlIllIlIll) {
        final SoundData lllllllllllllllllIllIIIlIllIlIlI = this.soundRewrites.get(lllllllllllllllllIllIIIlIllIlIll);
        return (lllllllllllllllllIllIIIlIllIlIlI != null) ? lllllllllllllllllIllIIIlIllIlIlI.getNewPitch() : 1.0f;
    }
    
    public SoundData added(final int lllllllllllllllllIllIIIllIIlIllI, final int lllllllllllllllllIllIIIllIIlIlIl, final float lllllllllllllllllIllIIIllIIlIlII) {
        final SoundData lllllllllllllllllIllIIIllIIllIII = new SoundData(lllllllllllllllllIllIIIllIIlIlIl, true, lllllllllllllllllIllIIIllIIlIlII, true);
        this.soundRewrites.put(lllllllllllllllllIllIIIllIIlIllI, lllllllllllllllllIllIIIllIIllIII);
        return lllllllllllllllllIllIIIllIIllIII;
    }
    
    public static final class SoundData
    {
        private final /* synthetic */ int replacementSound;
        private final /* synthetic */ boolean changePitch;
        private final /* synthetic */ boolean added;
        private final /* synthetic */ float newPitch;
        
        public SoundData(final int lllllllllllllIIIlIlIIIIlIIIlIIIl, final boolean lllllllllllllIIIlIlIIIIlIIIlIIII, final float lllllllllllllIIIlIlIIIIlIIIlIlII, final boolean lllllllllllllIIIlIlIIIIlIIIIlllI) {
            this.replacementSound = lllllllllllllIIIlIlIIIIlIIIlIIIl;
            this.changePitch = lllllllllllllIIIlIlIIIIlIIIlIIII;
            this.newPitch = lllllllllllllIIIlIlIIIIlIIIlIlII;
            this.added = lllllllllllllIIIlIlIIIIlIIIIlllI;
        }
        
        public boolean isChangePitch() {
            return this.changePitch;
        }
        
        public float getNewPitch() {
            return this.newPitch;
        }
        
        public int getReplacementSound() {
            return this.replacementSound;
        }
        
        public boolean isAdded() {
            return this.added;
        }
    }
}
