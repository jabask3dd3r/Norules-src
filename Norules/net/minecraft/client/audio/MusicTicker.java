package net.minecraft.client.audio;

import net.minecraft.client.*;
import java.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.init.*;

public class MusicTicker implements ITickable
{
    private /* synthetic */ ISound currentMusic;
    private final /* synthetic */ Minecraft mc;
    private /* synthetic */ int timeUntilNextMusic;
    private final /* synthetic */ Random rand;
    
    @Override
    public void update() {
        final MusicType lllllllllllllIIlIIllIIIlIIlIlllI = this.mc.getAmbientMusicType();
        if (this.currentMusic != null) {
            if (!lllllllllllllIIlIIllIIIlIIlIlllI.getMusicLocation().getSoundName().equals(this.currentMusic.getSoundLocation())) {
                this.mc.getSoundHandler().stopSound(this.currentMusic);
                this.timeUntilNextMusic = MathHelper.getInt(this.rand, 0, lllllllllllllIIlIIllIIIlIIlIlllI.getMinDelay() / 2);
            }
            if (!this.mc.getSoundHandler().isSoundPlaying(this.currentMusic)) {
                this.currentMusic = null;
                this.timeUntilNextMusic = Math.min(MathHelper.getInt(this.rand, lllllllllllllIIlIIllIIIlIIlIlllI.getMinDelay(), lllllllllllllIIlIIllIIIlIIlIlllI.getMaxDelay()), this.timeUntilNextMusic);
            }
        }
        this.timeUntilNextMusic = Math.min(this.timeUntilNextMusic, lllllllllllllIIlIIllIIIlIIlIlllI.getMaxDelay());
        if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0) {
            this.playMusic(lllllllllllllIIlIIllIIIlIIlIlllI);
        }
    }
    
    public MusicTicker(final Minecraft lllllllllllllIIlIIllIIIlIIllIlII) {
        this.rand = new Random();
        this.timeUntilNextMusic = 100;
        this.mc = lllllllllllllIIlIIllIIIlIIllIlII;
    }
    
    public void playMusic(final MusicType lllllllllllllIIlIIllIIIlIIlIIllI) {
        this.currentMusic = PositionedSoundRecord.getMusicRecord(lllllllllllllIIlIIllIIIlIIlIIllI.getMusicLocation());
        this.mc.getSoundHandler().playSound(this.currentMusic);
        this.timeUntilNextMusic = Integer.MAX_VALUE;
    }
    
    public enum MusicType
    {
        private final /* synthetic */ int minDelay;
        private final /* synthetic */ SoundEvent musicLocation;
        
        CREDITS("CREDITS", 3, SoundEvents.MUSIC_CREDITS, 0, 0), 
        END_BOSS("END_BOSS", 5, SoundEvents.MUSIC_DRAGON, 0, 0), 
        GAME("GAME", 1, SoundEvents.MUSIC_GAME, 12000, 24000);
        
        private final /* synthetic */ int maxDelay;
        
        MENU("MENU", 0, SoundEvents.MUSIC_MENU, 20, 600), 
        NETHER("NETHER", 4, SoundEvents.MUSIC_NETHER, 1200, 3600), 
        CREATIVE("CREATIVE", 2, SoundEvents.MUSIC_CREATIVE, 1200, 3600), 
        END("END", 6, SoundEvents.MUSIC_END, 6000, 24000);
        
        public int getMaxDelay() {
            return this.maxDelay;
        }
        
        private MusicType(final String lllllllllllllllIIIIIlIIIIIlIIlIl, final int lllllllllllllllIIIIIlIIIIIlIIlII, final SoundEvent lllllllllllllllIIIIIlIIIIIlIIIll, final int lllllllllllllllIIIIIlIIIIIlIlIII, final int lllllllllllllllIIIIIlIIIIIlIIIIl) {
            this.musicLocation = lllllllllllllllIIIIIlIIIIIlIIIll;
            this.minDelay = lllllllllllllllIIIIIlIIIIIlIlIII;
            this.maxDelay = lllllllllllllllIIIIIlIIIIIlIIIIl;
        }
        
        public int getMinDelay() {
            return this.minDelay;
        }
        
        public SoundEvent getMusicLocation() {
            return this.musicLocation;
        }
    }
}
