package me.nrules.module.render;

import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.event.events.*;
import me.nrules.event.*;

public class FullBright extends Module
{
    private /* synthetic */ float oldBrightness;
    
    @Override
    public void onEnable() {
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
        super.onEnable();
        this.oldBrightness = FullBright.mc.gameSettings.gammaSetting;
    }
    
    public FullBright() {
        super("FullBright", 0, Category.RENDER);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIlIIlIlIIlIlllIIIl) {
        FullBright.mc.gameSettings.gammaSetting = 10.0f;
    }
    
    @Override
    public void onDisable() {
        FullBright.mc.gameSettings.gammaSetting = this.oldBrightness;
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
