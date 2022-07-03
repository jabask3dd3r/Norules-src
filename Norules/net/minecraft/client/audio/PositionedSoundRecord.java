package net.minecraft.client.audio;

import net.minecraft.util.*;
import net.minecraft.util.math.*;

public class PositionedSoundRecord extends PositionedSound
{
    public PositionedSoundRecord(final ResourceLocation lllllllllllllIIllIIIlIIllIIllIll, final SoundCategory lllllllllllllIIllIIIlIIllIIllIlI, final float lllllllllllllIIllIIIlIIllIIllIIl, final float lllllllllllllIIllIIIlIIllIlIIIll, final boolean lllllllllllllIIllIIIlIIllIlIIIlI, final int lllllllllllllIIllIIIlIIllIIlIllI, final ISound.AttenuationType lllllllllllllIIllIIIlIIllIlIIIII, final float lllllllllllllIIllIIIlIIllIIlIlII, final float lllllllllllllIIllIIIlIIllIIllllI, final float lllllllllllllIIllIIIlIIllIIlllIl) {
        super(lllllllllllllIIllIIIlIIllIIllIll, lllllllllllllIIllIIIlIIllIIllIlI);
        this.volume = lllllllllllllIIllIIIlIIllIIllIIl;
        this.pitch = lllllllllllllIIllIIIlIIllIlIIIll;
        this.xPosF = lllllllllllllIIllIIIlIIllIIlIlII;
        this.yPosF = lllllllllllllIIllIIIlIIllIIllllI;
        this.zPosF = lllllllllllllIIllIIIlIIllIIlllIl;
        this.repeat = lllllllllllllIIllIIIlIIllIlIIIlI;
        this.repeatDelay = lllllllllllllIIllIIIlIIllIIlIllI;
        this.attenuationType = lllllllllllllIIllIIIlIIllIlIIIII;
    }
    
    public static PositionedSoundRecord func_194007_a(final SoundEvent lllllllllllllIIllIIIlIIlllllllIl, final float lllllllllllllIIllIIIlIIlllllllII, final float lllllllllllllIIllIIIlIIllllllIll) {
        return new PositionedSoundRecord(lllllllllllllIIllIIIlIIlllllllIl, SoundCategory.MASTER, lllllllllllllIIllIIIlIIllllllIll, lllllllllllllIIllIIIlIIlllllllII, false, 0, ISound.AttenuationType.NONE, 0.0f, 0.0f, 0.0f);
    }
    
    public static PositionedSoundRecord getMusicRecord(final SoundEvent lllllllllllllIIllIIIlIIllllllIIl) {
        return new PositionedSoundRecord(lllllllllllllIIllIIIlIIllllllIIl, SoundCategory.MUSIC, 1.0f, 1.0f, false, 0, ISound.AttenuationType.NONE, 0.0f, 0.0f, 0.0f);
    }
    
    private PositionedSoundRecord(final SoundEvent lllllllllllllIIllIIIlIIlllIIIlll, final SoundCategory lllllllllllllIIllIIIlIIlllIIIllI, final float lllllllllllllIIllIIIlIIllIlllIlI, final float lllllllllllllIIllIIIlIIllIlllIIl, final boolean lllllllllllllIIllIIIlIIllIlllIII, final int lllllllllllllIIllIIIlIIlllIIIIlI, final ISound.AttenuationType lllllllllllllIIllIIIlIIllIllIllI, final float lllllllllllllIIllIIIlIIllIllIlIl, final float lllllllllllllIIllIIIlIIllIllIlII, final float lllllllllllllIIllIIIlIIllIllIIll) {
        this(lllllllllllllIIllIIIlIIlllIIIlll.getSoundName(), lllllllllllllIIllIIIlIIlllIIIllI, lllllllllllllIIllIIIlIIllIlllIlI, lllllllllllllIIllIIIlIIllIlllIIl, lllllllllllllIIllIIIlIIllIlllIII, lllllllllllllIIllIIIlIIlllIIIIlI, lllllllllllllIIllIIIlIIllIllIllI, lllllllllllllIIllIIIlIIllIllIlIl, lllllllllllllIIllIIIlIIllIllIlII, lllllllllllllIIllIIIlIIllIllIIll);
    }
    
    public PositionedSoundRecord(final SoundEvent lllllllllllllIIllIIIlIlIIIIIlllI, final SoundCategory lllllllllllllIIllIIIlIlIIIIlIIll, final float lllllllllllllIIllIIIlIlIIIIlIIlI, final float lllllllllllllIIllIIIlIlIIIIlIIIl, final BlockPos lllllllllllllIIllIIIlIlIIIIlIIII) {
        this(lllllllllllllIIllIIIlIlIIIIIlllI, lllllllllllllIIllIIIlIlIIIIlIIll, lllllllllllllIIllIIIlIlIIIIlIIlI, lllllllllllllIIllIIIlIlIIIIlIIIl, lllllllllllllIIllIIIlIlIIIIlIIII.getX() + 0.5f, lllllllllllllIIllIIIlIlIIIIlIIII.getY() + 0.5f, lllllllllllllIIllIIIlIlIIIIlIIII.getZ() + 0.5f);
    }
    
    public PositionedSoundRecord(final SoundEvent lllllllllllllIIllIIIlIIlllIllIlI, final SoundCategory lllllllllllllIIllIIIlIIllllIIIIl, final float lllllllllllllIIllIIIlIIllllIIIII, final float lllllllllllllIIllIIIlIIlllIlIlll, final float lllllllllllllIIllIIIlIIlllIllllI, final float lllllllllllllIIllIIIlIIlllIlllIl, final float lllllllllllllIIllIIIlIIlllIlIlII) {
        this(lllllllllllllIIllIIIlIIlllIllIlI, lllllllllllllIIllIIIlIIllllIIIIl, lllllllllllllIIllIIIlIIllllIIIII, lllllllllllllIIllIIIlIIlllIlIlll, false, 0, ISound.AttenuationType.LINEAR, lllllllllllllIIllIIIlIIlllIllllI, lllllllllllllIIllIIIlIIlllIlllIl, lllllllllllllIIllIIIlIIlllIlIlII);
    }
    
    public static PositionedSoundRecord getMasterRecord(final SoundEvent lllllllllllllIIllIIIlIlIIIIIIlIl, final float lllllllllllllIIllIIIlIlIIIIIIlII) {
        return func_194007_a(lllllllllllllIIllIIIlIlIIIIIIlIl, lllllllllllllIIllIIIlIlIIIIIIlII, 0.25f);
    }
    
    public static PositionedSoundRecord getRecordSoundRecord(final SoundEvent lllllllllllllIIllIIIlIIllllIllll, final float lllllllllllllIIllIIIlIIlllllIIlI, final float lllllllllllllIIllIIIlIIllllIllIl, final float lllllllllllllIIllIIIlIIlllllIIII) {
        return new PositionedSoundRecord(lllllllllllllIIllIIIlIIllllIllll, SoundCategory.RECORDS, 4.0f, 1.0f, false, 0, ISound.AttenuationType.LINEAR, lllllllllllllIIllIIIlIIlllllIIlI, lllllllllllllIIllIIIlIIllllIllIl, lllllllllllllIIllIIIlIIlllllIIII);
    }
}
