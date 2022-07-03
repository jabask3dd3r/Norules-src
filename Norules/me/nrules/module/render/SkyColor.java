package me.nrules.module.render;

import clickui.settings.*;
import me.nrules.module.*;
import me.nrules.*;

public class SkyColor extends Module
{
    public static /* synthetic */ Setting green;
    public static /* synthetic */ Setting red;
    public static /* synthetic */ Setting blue;
    
    public SkyColor() {
        super("SkyColor", 0, Category.RENDER);
        Main.settingsManager.Property(SkyColor.red = new Setting("Red", this, 110.0, 1.0, 255.0, true));
        Main.settingsManager.Property(SkyColor.blue = new Setting("Blue", this, 9.0, 1.0, 255.0, true));
        Main.settingsManager.Property(SkyColor.green = new Setting("Green", this, 127.0, 1.0, 255.0, true));
    }
}
