package me.nrules.module.combat;

import clickui.settings.*;
import me.nrules.module.*;
import me.nrules.*;
import me.nrules.notifications.*;

public class HitBox extends Module
{
    public static /* synthetic */ Setting size;
    
    public HitBox() {
        super("HitBox", 0, Category.COMBAT);
        Main.settingsManager.Property(HitBox.size = new Setting("Size", this, 0.2, 0.1, 1.0, false));
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
