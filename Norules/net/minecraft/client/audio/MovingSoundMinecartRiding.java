package net.minecraft.client.audio;

import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import net.minecraft.util.*;

public class MovingSoundMinecartRiding extends MovingSound
{
    private final /* synthetic */ EntityMinecart minecart;
    private final /* synthetic */ EntityPlayer player;
    
    @Override
    public void update() {
        if (!this.minecart.isDead && this.player.isRiding() && this.player.getRidingEntity() == this.minecart) {
            final float lllllllllllllIIllIllIlIllIIllIII = MathHelper.sqrt(this.minecart.motionX * this.minecart.motionX + this.minecart.motionZ * this.minecart.motionZ);
            if (lllllllllllllIIllIllIlIllIIllIII >= 0.01) {
                this.volume = 0.0f + MathHelper.clamp(lllllllllllllIIllIllIlIllIIllIII, 0.0f, 1.0f) * 0.75f;
            }
            else {
                this.volume = 0.0f;
            }
        }
        else {
            this.donePlaying = true;
        }
    }
    
    public MovingSoundMinecartRiding(final EntityPlayer lllllllllllllIIllIllIlIllIlIIIII, final EntityMinecart lllllllllllllIIllIllIlIllIIlllII) {
        super(SoundEvents.ENTITY_MINECART_INSIDE, SoundCategory.NEUTRAL);
        this.player = lllllllllllllIIllIllIlIllIlIIIII;
        this.minecart = lllllllllllllIIllIllIlIllIIlllII;
        this.attenuationType = ISound.AttenuationType.NONE;
        this.repeat = true;
        this.repeatDelay = 0;
    }
}
