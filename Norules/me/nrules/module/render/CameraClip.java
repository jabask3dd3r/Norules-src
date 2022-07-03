package me.nrules.module.render;

import clickui.settings.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.*;

public class CameraClip extends Module
{
    public static /* synthetic */ Setting fortnite;
    public static /* synthetic */ Setting hurtEffect;
    public static /* synthetic */ Setting cameraFov;
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public CameraClip() {
        super("CameraClip", 0, Category.RENDER);
        Main.settingsManager.Property(CameraClip.fortnite = new Setting("Fortnite", this, false));
        Main.settingsManager.Property(CameraClip.cameraFov = new Setting("ThirdDistance", this, 0.0, 0.0, 50.0, true));
        Main.settingsManager.Property(CameraClip.hurtEffect = new Setting("HurtEffect", this, 2.0, 0.0, 20.0, true));
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
}
