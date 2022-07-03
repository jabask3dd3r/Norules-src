package me.nrules.module.movement;

import me.nrules.module.*;
import me.nrules.notifications.*;
import me.nrules.event.events.*;
import me.nrules.event.*;

public class Fly extends Module
{
    public Fly() {
        super("Fly", 0, Category.MOVEMENT);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllIlIIlIlIlllllIllll) {
        if (Fly.mc.player.onGround) {
            Fly.mc.player.motionY = 1.0;
        }
        if (!Fly.mc.player.onGround) {
            Fly.mc.player.capabilities.isFlying = true;
            Fly.mc.player.capabilities.flySpeed = 1.3f;
            Fly.mc.player.motionX = 0.0;
            Fly.mc.player.motionY = -0.02;
            Fly.mc.player.motionZ = 0.0;
        }
    }
    
    @Override
    public void onDisable() {
        Fly.mc.player.capabilities.isFlying = false;
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
