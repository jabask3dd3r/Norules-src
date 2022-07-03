package net.minecraft.client.audio;

import net.minecraft.util.*;
import javax.annotation.*;

public interface ISound
{
    int getRepeatDelay();
    
    ResourceLocation getSoundLocation();
    
    SoundCategory getCategory();
    
    boolean canRepeat();
    
    float getPitch();
    
    Sound getSound();
    
    float getVolume();
    
    float getXPosF();
    
    float getYPosF();
    
    @Nullable
    SoundEventAccessor createAccessor(final SoundHandler p0);
    
    AttenuationType getAttenuationType();
    
    float getZPosF();
    
    public enum AttenuationType
    {
        LINEAR("LINEAR", 1, 2), 
        NONE("NONE", 0, 0);
        
        private final /* synthetic */ int type;
        
        public int getTypeInt() {
            return this.type;
        }
        
        private AttenuationType(final String lllllllllllllllIlllIllIIIIIlllll, final int lllllllllllllllIlllIllIIIIIllllI, final int lllllllllllllllIlllIllIIIIIlllIl) {
            this.type = lllllllllllllllIlllIllIIIIIlllIl;
        }
    }
}
