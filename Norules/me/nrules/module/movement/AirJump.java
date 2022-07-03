package me.nrules.module.movement;

import clickui.settings.*;
import me.nrules.module.*;
import me.nrules.*;
import me.nrules.notifications.*;
import me.nrules.event.events.*;
import me.nrules.event.*;

public class AirJump extends Module
{
    public static /* synthetic */ Setting pos;
    
    public AirJump() {
        super("WebLeave", 0, Category.MOVEMENT);
        Main.settingsManager.Property(AirJump.pos = new Setting("Pos", this, 10.0, 1.0, 15.0, true));
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIllIllIlIlIIlIIIlII) {
        if (Main.moduleManager.getModule(NoWeb.class).isToggled()) {
            Main.moduleManager.getModule(NoWeb.class).setToggled(false);
        }
        if (AirJump.mc.player.isInWeb) {
            AirJump.mc.player.motionY = AirJump.pos.getValDouble();
        }
    }
}
