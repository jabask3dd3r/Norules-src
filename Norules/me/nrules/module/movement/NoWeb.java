package me.nrules.module.movement;

import clickui.settings.*;
import me.nrules.event.events.*;
import me.nrules.utils.player.*;
import me.nrules.event.*;
import me.nrules.module.*;
import java.util.*;
import me.nrules.*;

public class NoWeb extends Module
{
    public static /* synthetic */ Setting modeType;
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIIllIIIIIIIIlIlIIlI) {
        final String lllllllllllllIIllIIIIIIIIlIlIIIl = NoWeb.modeType.getValString();
        if (lllllllllllllIIllIIIIIIIIlIlIIIl.equalsIgnoreCase("Vanilla") && NoWeb.mc.player.isInWeb) {
            NoWeb.mc.player.isInWeb = false;
        }
        if (lllllllllllllIIllIIIIIIIIlIlIIIl.equalsIgnoreCase("Matrix") && NoWeb.mc.player.isInWeb) {
            NoWeb.mc.player.isInWeb = false;
            Utils.setSpeed(0.05);
        }
    }
    
    public NoWeb() {
        super("NoWeb", 0, Category.MOVEMENT);
        final ArrayList<String> lllllllllllllIIllIIIIIIIIlIlIlll = new ArrayList<String>();
        lllllllllllllIIllIIIIIIIIlIlIlll.add("Vanilla");
        lllllllllllllIIllIIIIIIIIlIlIlll.add("Matrix");
        Main.settingsManager.Property(NoWeb.modeType = new Setting("Mode", this, "Matrix", lllllllllllllIIllIIIIIIIIlIlIlll));
    }
}
