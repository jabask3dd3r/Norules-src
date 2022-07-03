package me.nrules.module.player;

import me.nrules.event.events.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import me.nrules.module.*;

public class NoJumpDelay extends Module
{
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllllIIlIllIIllllllllI) {
        if (NoJumpDelay.mc.world != null && NoJumpDelay.mc.player != null) {
            NoJumpDelay.mc.player.jumpTicks = 0;
            NoJumpDelay.mc.player.nextStepDistance = 0;
        }
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    public NoJumpDelay() {
        super("NoJumpDelay", 0, Category.PLAYER);
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
