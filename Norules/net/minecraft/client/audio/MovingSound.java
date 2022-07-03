package net.minecraft.client.audio;

import net.minecraft.util.*;

public abstract class MovingSound extends PositionedSound implements ITickableSound
{
    protected /* synthetic */ boolean donePlaying;
    
    @Override
    public boolean isDonePlaying() {
        return this.donePlaying;
    }
    
    protected MovingSound(final SoundEvent lllllllllllllIlllIlIIlIllIIIllII, final SoundCategory lllllllllllllIlllIlIIlIllIIIlIll) {
        super(lllllllllllllIlllIlIIlIllIIIllII, lllllllllllllIlllIlIIlIllIIIlIll);
    }
}
