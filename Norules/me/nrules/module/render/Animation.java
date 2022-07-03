package me.nrules.module.render;

import clickui.settings.*;
import me.nrules.module.*;
import me.nrules.*;

public class Animation extends Module
{
    public static /* synthetic */ Setting animation;
    
    public Animation() {
        super("Animations", 0, Category.RENDER);
        Main.settingsManager.Property(Animation.animation = new Setting("Speed", this, 13.0, 1.0, 20.0, true));
    }
}
