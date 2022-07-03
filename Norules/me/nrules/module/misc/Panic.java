package me.nrules.module.misc;

import me.nrules.module.*;

public class Panic extends Module
{
    public Panic() {
        super("Panic", 0, Category.MISC);
    }
    
    @Override
    public void onEnable() {
        for (final Module llllllllllllllIIllIIlIIIIIIIlIIl : ModuleManager.getModules()) {
            llllllllllllllIIllIIlIIIIIIIlIIl.setToggled(false);
            llllllllllllllIIllIIlIIIIIIIlIIl.setKey(0);
        }
        super.onEnable();
    }
}
