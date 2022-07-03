package me.nrules.module.player;

import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.event.events.*;
import me.nrules.event.*;

public class FastPlace extends Module
{
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        FastPlace.mc.rightClickDelayTimer = 4;
        super.onDisable();
    }
    
    public FastPlace() {
        super("FastPlace", 0, Category.PLAYER);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllllllIIIlIIIlIllIIll) {
        FastPlace.mc.rightClickDelayTimer = 0;
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
}
