package me.nrules.module.player;

import clickui.settings.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.*;

public class NoPush extends Module
{
    public static /* synthetic */ Setting blocks;
    public static /* synthetic */ Setting players;
    public static /* synthetic */ Setting water;
    
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
    
    public NoPush() {
        super("NoPush", 0, Category.PLAYER);
        Main.settingsManager.Property(NoPush.blocks = new Setting("Blocks", this, true));
        Main.settingsManager.Property(NoPush.players = new Setting("Players", this, true));
        Main.settingsManager.Property(NoPush.water = new Setting("Water", this, true));
    }
}
