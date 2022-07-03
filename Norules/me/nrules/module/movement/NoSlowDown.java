package me.nrules.module.movement;

import clickui.settings.*;
import me.nrules.module.*;
import me.nrules.notifications.*;
import me.nrules.event.events.*;
import me.nrules.utils.player.*;
import net.minecraft.client.entity.*;
import me.nrules.event.*;

public class NoSlowDown extends Module
{
    public NoSlowDown() {
        super("NoSlowDown", 0, Category.MOVEMENT);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllIllllIIllllIllIlIl) {
        if (NoSlowDown.mc.player.isHandActive() && !NoSlowDown.mc.player.isRiding() && NoSlowDown.mc.player.fallDistance > 0.7 && MoveUtil.isMoving()) {
            final EntityPlayerSP player = NoSlowDown.mc.player;
            player.motionX *= 0.9;
            final EntityPlayerSP player2 = NoSlowDown.mc.player;
            player2.motionZ *= 0.9;
        }
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
