package me.nrules.module.render;

import clickui.settings.*;
import me.nrules.*;
import net.minecraft.client.gui.*;
import me.nrules.module.*;

public class ClickGUI extends Module
{
    public static /* synthetic */ Setting guiSaturation;
    public static /* synthetic */ Setting rainbow;
    
    @Override
    public void onEnable() {
        super.onEnable();
        ClickGUI.mc.displayGuiScreen(Main.clickGui1);
        this.toggle();
    }
    
    public ClickGUI() {
        super("ClickGUI", 54, Category.RENDER);
        Main.settingsManager.Property(ClickGUI.rainbow = new Setting("Rainbow", this, false));
        Main.settingsManager.Property(ClickGUI.guiSaturation = new Setting("Saturation", this, 1.0, 0.6000000238418579, 1.0, false, ClickGUI.rainbow::getValBoolean));
    }
}
