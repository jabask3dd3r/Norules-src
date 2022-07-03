package me.nrules.module.render;

import clickui.settings.*;
import me.nrules.module.*;
import java.util.*;
import me.nrules.*;

public class Cosmetics extends Module
{
    public static /* synthetic */ Setting capes;
    public static /* synthetic */ Setting scaleS;
    public static /* synthetic */ Setting wings;
    public static /* synthetic */ Setting modeType1;
    public static /* synthetic */ Setting modeType;
    
    public Cosmetics() {
        super("Cosmetics", 0, Category.RENDER);
        final ArrayList<String> lllllllllllllllIIIlllIIIIIIIllIl = new ArrayList<String>();
        final ArrayList<String> lllllllllllllllIIIlllIIIIIIIllII = new ArrayList<String>();
        lllllllllllllllIIIlllIIIIIIIllII.add("Xoma");
        lllllllllllllllIIIlllIIIIIIIllII.add("Kitty");
        lllllllllllllllIIIlllIIIIIIIllIl.add("Day");
        lllllllllllllllIIIlllIIIIIIIllIl.add("Night");
        Main.settingsManager.Property(Cosmetics.modeType = new Setting("CapeMod", this, "Xoma", lllllllllllllllIIIlllIIIIIIIllII));
        Main.settingsManager.Property(Cosmetics.modeType1 = new Setting("WingMod", this, "Day", lllllllllllllllIIIlllIIIIIIIllIl));
        Main.settingsManager.Property(Cosmetics.wings = new Setting("Wing", this, false));
        Main.settingsManager.Property(Cosmetics.capes = new Setting("Cape", this, true));
        Main.settingsManager.Property(Cosmetics.scaleS = new Setting("Scale", this, 1.0, 0.5, 2.0, false));
    }
}
