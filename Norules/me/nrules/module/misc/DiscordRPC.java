package me.nrules.module.misc;

import me.nrules.notifications.*;
import me.nrules.module.*;

public class DiscordRPC extends Module
{
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public DiscordRPC() {
        super("DiscordRPC", 0, Category.MISC);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
}
