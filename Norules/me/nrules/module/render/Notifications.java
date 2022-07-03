package me.nrules.module.render;

import me.nrules.module.*;
import me.nrules.notifications.*;

public class Notifications extends Module
{
    public Notifications() {
        super("Notifications", 0, Category.RENDER);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
}
