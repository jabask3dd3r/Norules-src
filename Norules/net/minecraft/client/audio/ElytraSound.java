package net.minecraft.client.audio;

import net.minecraft.client.entity.*;
import net.minecraft.init.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;

public class ElytraSound extends MovingSound
{
    private /* synthetic */ int time;
    private final /* synthetic */ EntityPlayerSP player;
    
    public ElytraSound(final EntityPlayerSP lllllllllllllIIIIIlIlIlIlIlIlIll) {
        super(SoundEvents.ITEM_ELYTRA_FLYING, SoundCategory.PLAYERS);
        this.player = lllllllllllllIIIIIlIlIlIlIlIlIll;
        this.repeat = true;
        this.repeatDelay = 0;
        this.volume = 0.1f;
    }
    
    @Override
    public void update() {
        ++this.time;
        if (!this.player.isDead && (this.time <= 20 || this.player.isElytraFlying())) {
            this.xPosF = (float)this.player.posX;
            this.yPosF = (float)this.player.posY;
            this.zPosF = (float)this.player.posZ;
            final float lllllllllllllIIIIIlIlIlIlIlIIIll = MathHelper.sqrt(this.player.motionX * this.player.motionX + this.player.motionZ * this.player.motionZ + this.player.motionY * this.player.motionY);
            final float lllllllllllllIIIIIlIlIlIlIlIIIlI = lllllllllllllIIIIIlIlIlIlIlIIIll / 2.0f;
            if (lllllllllllllIIIIIlIlIlIlIlIIIll >= 0.01) {
                this.volume = MathHelper.clamp(lllllllllllllIIIIIlIlIlIlIlIIIlI * lllllllllllllIIIIIlIlIlIlIlIIIlI, 0.0f, 1.0f);
            }
            else {
                this.volume = 0.0f;
            }
            if (this.time < 20) {
                this.volume = 0.0f;
            }
            else if (this.time < 40) {
                this.volume *= (float)((this.time - 20) / 20.0);
            }
            final float lllllllllllllIIIIIlIlIlIlIlIIIIl = 0.8f;
            if (this.volume > 0.8f) {
                this.pitch = 1.0f + (this.volume - 0.8f);
            }
            else {
                this.pitch = 1.0f;
            }
        }
        else {
            this.donePlaying = true;
        }
    }
}
