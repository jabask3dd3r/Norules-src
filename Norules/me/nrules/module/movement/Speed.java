package me.nrules.module.movement;

import me.nrules.module.*;
import me.nrules.notifications.*;
import me.nrules.event.events.*;
import me.nrules.utils.player.*;
import me.nrules.event.*;

public class Speed extends Module
{
    private /* synthetic */ int ticks;
    
    public Speed() {
        super("Speed", 0, Category.MOVEMENT);
        this.ticks = 0;
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllIIllllIIlIIllIIIll) {
        final float llllllllllllllIIllllIIlIIllIIIlI = (float)MoveUtil.getDirection();
        if (MoveUtil.isMoving() && Speed.mc.player.onGround) {
            Speed.mc.player.jump();
            Speed.mc.player.speedInAir = ((this.ticks > 2) ? 0.02097f : 0.0203f);
            Speed.mc.player.onGround = false;
            Speed.mc.player.motionX = -Math.sin(llllllllllllllIIllllIIlIIllIIIlI) * MoveUtil.getSpeed() * 1.17;
            Speed.mc.player.motionZ = Math.cos(llllllllllllllIIllllIIlIIllIIIlI) * MoveUtil.getSpeed() * 1.17;
        }
    }
    
    @Override
    public void onDisable() {
        Speed.mc.timer.timerSpeed = 1.0f;
        Speed.mc.player.speedInAir = 0.02f;
        Speed.mc.player.jumpMovementFactor = 0.02f;
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
