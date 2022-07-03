package me.nrules.module.movement;

import clickui.settings.*;
import me.nrules.module.*;
import me.nrules.event.events.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.network.play.client.*;
import me.nrules.event.*;
import me.nrules.notifications.*;

public class HighJump extends Module
{
    public HighJump() {
        super("HighJump", 0, Category.MOVEMENT);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllllIIllIlIIlIIIIIlIl) {
        if (HighJump.mc.player.isInWater()) {
            return;
        }
        if (HighJump.mc.player.hurtTime > 8) {
            HighJump.mc.player.motionX = 0.0;
            HighJump.mc.player.motionZ = 0.0;
            HighJump.mc.timer.timerSpeed = 0.2f;
        }
        if (HighJump.mc.player.hurtTime == 5) {
            HighJump.mc.getConnection().sendPacket(new CPacketEntityAction(HighJump.mc.player, CPacketEntityAction.Action.START_FALL_FLYING));
            HighJump.mc.timer.timerSpeed = 0.5f;
        }
        if (HighJump.mc.player.hurtTime == 2) {
            HighJump.mc.timer.timerSpeed = 0.9f;
            HighJump.mc.player.connection.sendPacket(new CPacketPlayer.Position(HighJump.mc.player.posX, HighJump.mc.player.posY + 5.0, HighJump.mc.player.posZ, true));
            HighJump.mc.getConnection().sendPacket(new CPacketEntityAction(HighJump.mc.player, CPacketEntityAction.Action.START_RIDING_JUMP));
            HighJump.mc.player.motionY = 5.0;
        }
    }
    
    @Override
    public void onDisable() {
        HighJump.mc.timer.timerSpeed = 1.0f;
        HighJump.mc.player.speedInAir = 0.02f;
        HighJump.mc.player.jumpMovementFactor = 0.02f;
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
}
