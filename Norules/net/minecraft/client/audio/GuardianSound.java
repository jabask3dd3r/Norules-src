package net.minecraft.client.audio;

import net.minecraft.entity.monster.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class GuardianSound extends MovingSound
{
    private final /* synthetic */ EntityGuardian guardian;
    
    public GuardianSound(final EntityGuardian lllllllllllllIllIllIIIIIIIIIlIII) {
        super(SoundEvents.ENTITY_GUARDIAN_ATTACK, SoundCategory.HOSTILE);
        this.guardian = lllllllllllllIllIllIIIIIIIIIlIII;
        this.attenuationType = ISound.AttenuationType.NONE;
        this.repeat = true;
        this.repeatDelay = 0;
    }
    
    @Override
    public void update() {
        if (!this.guardian.isDead && this.guardian.hasTargetedEntity()) {
            this.xPosF = (float)this.guardian.posX;
            this.yPosF = (float)this.guardian.posY;
            this.zPosF = (float)this.guardian.posZ;
            final float lllllllllllllIllIllIIIIIIIIIIIlI = this.guardian.getAttackAnimationScale(0.0f);
            this.volume = 0.0f + 1.0f * lllllllllllllIllIllIIIIIIIIIIIlI * lllllllllllllIllIllIIIIIIIIIIIlI;
            this.pitch = 0.7f + 0.5f * lllllllllllllIllIllIIIIIIIIIIIlI;
        }
        else {
            this.donePlaying = true;
        }
    }
}
