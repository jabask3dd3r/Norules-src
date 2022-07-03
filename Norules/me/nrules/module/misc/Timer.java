package me.nrules.module.misc;

import me.nrules.event.events.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.*;
import clickui.settings.*;

public class Timer extends Module
{
    private /* synthetic */ Setting timerspeed;
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllIlIIIlIlIIIIllIIII) {
        Timer.mc.timer.timerSpeed = this.timerspeed.getValFloat();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @Override
    public void onDisable() {
        Timer.mc.timer.timerSpeed = 1.0f;
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public Timer() {
        super("Timer", 0, Category.MISC);
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("TimerSpeed", this, 1.0, 0.1, 10.0, false);
        this.timerspeed = setting;
        settingsManager.Property(setting);
    }
}
