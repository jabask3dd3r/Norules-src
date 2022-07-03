package me.nrules.module.movement;

import me.nrules.module.*;
import me.nrules.notifications.*;
import me.nrules.event.events.*;
import net.minecraft.network.play.client.*;
import me.nrules.event.*;

public class Spider extends Module
{
    public Spider() {
        super("Spider", 0, Category.MOVEMENT);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void EventSendPacket(final EventSendPacket lllllllllllllllIIlIIlIIlIllIlIll) {
        if (Spider.mc.player.isCollidedHorizontally && lllllllllllllllIIlIIlIIlIllIlIll.getPacket() instanceof CPacketPlayer) {
            final CPacketPlayer lllllllllllllllIIlIIlIIlIllIllII = (CPacketPlayer)lllllllllllllllIIlIIlIIlIllIlIll.getPacket();
            if (Spider.timerHelper.hasReached(200.0)) {
                Spider.timerHelper.reset();
                Spider.mc.player.motionY = 0.41999998688697815;
                Spider.mc.player.jump();
                lllllllllllllllIIlIIlIIlIllIllII.onGround = true;
                lllllllllllllllIIlIIlIIlIllIllII.moving = false;
            }
        }
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
