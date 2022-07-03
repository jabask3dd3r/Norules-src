package me.nrules.module.movement;

import me.nrules.event.events.*;
import net.minecraft.util.math.*;
import net.minecraft.init.*;
import me.nrules.utils.player.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.*;
import clickui.settings.*;

public class WaterFeatures extends Module
{
    private /* synthetic */ Setting timer;
    private /* synthetic */ Setting waterLeave;
    private /* synthetic */ Setting jumpVal;
    private /* synthetic */ Setting motion;
    
    @EventTarget
    public void Update(final EventUpdate llllllllllllllllllIIIlIIlIIIIIll) {
        if (this.waterLeave.getValBoolean()) {
            if (WaterFeatures.mc.world.getBlockState(new BlockPos(WaterFeatures.mc.player.posX, WaterFeatures.mc.player.posY - 0.95, WaterFeatures.mc.player.posZ)).getBlock() == Blocks.WATER) {
                WaterFeatures.mc.player.motionY = 10.0;
                WaterFeatures.mc.player.onGround = true;
            }
            if (WaterFeatures.mc.player.isInWater() || WaterFeatures.mc.player.isInLava()) {
                WaterFeatures.mc.player.onGround = true;
            }
        }
        final double llllllllllllllllllIIIlIIlIIIIIlI = this.motion.getValDouble();
        if (WaterFeatures.mc.player.isInWater() || WaterFeatures.mc.player.isInLava()) {
            WaterFeatures.mc.player.motionY = this.jumpVal.getValDouble();
            Utils.setSpeed(llllllllllllllllllIIIlIIlIIIIIlI);
            if (this.timer.getValBoolean()) {
                WaterFeatures.mc.timer.timerSpeed = 2.0f;
            }
        }
        else {
            WaterFeatures.mc.timer.timerSpeed = 1.0f;
        }
    }
    
    @Override
    public void onDisable() {
        WaterFeatures.mc.timer.timerSpeed = 1.0f;
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        WaterFeatures.mc.player.capabilities.isFlying = false;
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    public WaterFeatures() {
        super("WaterFeatures", 0, Category.MOVEMENT);
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("WaterLeave", this, false);
        this.waterLeave = setting;
        settingsManager.Property(setting);
        final SM settingsManager2 = Main.settingsManager;
        final Setting setting2 = new Setting("UseTimer", this, false);
        this.timer = setting2;
        settingsManager2.Property(setting2);
        final SM settingsManager3 = Main.settingsManager;
        final Setting setting3 = new Setting("MotionVal", this, 1.2, 0.5, 3.0, false);
        this.motion = setting3;
        settingsManager3.Property(setting3);
        final SM settingsManager4 = Main.settingsManager;
        final Setting setting4 = new Setting("JumpVal", this, 0.45, 0.2, 0.6, false);
        this.jumpVal = setting4;
        settingsManager4.Property(setting4);
    }
}
