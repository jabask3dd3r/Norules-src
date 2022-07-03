package net.minecraft.client.audio;

import javax.annotation.*;
import net.minecraft.util.*;

public abstract class PositionedSound implements ISound
{
    protected /* synthetic */ float yPosF;
    protected /* synthetic */ int repeatDelay;
    protected /* synthetic */ AttenuationType attenuationType;
    protected /* synthetic */ ResourceLocation positionedSoundLocation;
    protected /* synthetic */ float pitch;
    @Nullable
    private /* synthetic */ SoundEventAccessor soundEvent;
    protected /* synthetic */ float zPosF;
    protected /* synthetic */ SoundCategory category;
    protected /* synthetic */ float volume;
    protected /* synthetic */ Sound sound;
    protected /* synthetic */ boolean repeat;
    protected /* synthetic */ float xPosF;
    
    @Override
    public boolean canRepeat() {
        return this.repeat;
    }
    
    @Override
    public float getVolume() {
        return this.volume * this.sound.getVolume();
    }
    
    @Override
    public float getXPosF() {
        return this.xPosF;
    }
    
    @Override
    public AttenuationType getAttenuationType() {
        return this.attenuationType;
    }
    
    @Override
    public Sound getSound() {
        return this.sound;
    }
    
    protected PositionedSound(final SoundEvent lllllllllllllIlIlllIIIlIlllIllII, final SoundCategory lllllllllllllIlIlllIIIlIlllIlllI) {
        this(lllllllllllllIlIlllIIIlIlllIllII.getSoundName(), lllllllllllllIlIlllIIIlIlllIlllI);
    }
    
    @Override
    public int getRepeatDelay() {
        return this.repeatDelay;
    }
    
    @Override
    public ResourceLocation getSoundLocation() {
        return this.positionedSoundLocation;
    }
    
    @Override
    public float getZPosF() {
        return this.zPosF;
    }
    
    protected PositionedSound(final ResourceLocation lllllllllllllIlIlllIIIlIlllIIIll, final SoundCategory lllllllllllllIlIlllIIIlIlllIIlIl) {
        this.volume = 1.0f;
        this.pitch = 1.0f;
        this.attenuationType = AttenuationType.LINEAR;
        this.positionedSoundLocation = lllllllllllllIlIlllIIIlIlllIIIll;
        this.category = lllllllllllllIlIlllIIIlIlllIIlIl;
    }
    
    @Override
    public SoundEventAccessor createAccessor(final SoundHandler lllllllllllllIlIlllIIIlIllIllIIl) {
        this.soundEvent = lllllllllllllIlIlllIIIlIllIllIIl.getAccessor(this.positionedSoundLocation);
        if (this.soundEvent == null) {
            this.sound = SoundHandler.MISSING_SOUND;
        }
        else {
            this.sound = this.soundEvent.cloneEntry();
        }
        return this.soundEvent;
    }
    
    @Override
    public float getPitch() {
        return this.pitch * this.sound.getPitch();
    }
    
    @Override
    public float getYPosF() {
        return this.yPosF;
    }
    
    @Override
    public SoundCategory getCategory() {
        return this.category;
    }
}
