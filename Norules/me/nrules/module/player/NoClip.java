package me.nrules.module.player;

import me.nrules.event.events.*;
import me.nrules.utils.player.*;
import me.nrules.event.*;
import net.minecraft.entity.*;
import me.nrules.*;
import me.nrules.module.*;

public class NoClip extends Module
{
    @Override
    public void onDisable() {
        NoClip.mc.player.noClip = false;
        super.onDisable();
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllIlIIllIlIIIIlIllll) {
        NoClip.mc.player.noClip = false;
        NoClip.mc.player.onGround = (NoClip.mc.player.motionY >= 0.092);
        NoClip.mc.player.motionY = 1.0E-46;
        if (NoClip.mc.gameSettings.keyBindForward.isKeyDown()) {
            Utils.forward(0.2);
        }
        if (NoClip.mc.gameSettings.keyBindJump.isKeyDown()) {
            NoClip.mc.player.motionY = 0.2;
        }
        if (NoClip.mc.gameSettings.keyBindSneak.isKeyDown()) {
            NoClip.mc.player.motionY = -0.2;
        }
    }
    
    public static boolean isNoClip(final Entity llllllllllllllIlIIllIlIIIIlIllII) {
        return (Main.moduleManager.getModule(NoClip.class).isToggled() && NoClip.mc.player != null && (NoClip.mc.player.ridingEntity == null || llllllllllllllIlIIllIlIIIIlIllII == NoClip.mc.player.ridingEntity)) || llllllllllllllIlIIllIlIIIIlIllII.noClip;
    }
    
    public NoClip() {
        super("NoClip", 0, Category.PLAYER);
    }
}
