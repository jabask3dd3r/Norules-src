package me.nrules.module.movement;

import clickui.settings.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.*;
import me.nrules.event.events.*;
import me.nrules.event.*;

public class Sprint extends Module
{
    public static /* synthetic */ Setting keepsprint;
    
    @Override
    public void onDisable() {
        Sprint.mc.player.setSprinting(false);
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    public Sprint() {
        super("Sprint", 0, Category.MOVEMENT);
        Main.settingsManager.Property(Sprint.keepsprint = new Setting("KeepSprint", this, false));
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIlIIllllllIIIllIIIl) {
        if (Sprint.mc.gameSettings.keyBindForward.isKeyDown()) {
            Sprint.mc.player.setSprinting(true);
        }
    }
}
