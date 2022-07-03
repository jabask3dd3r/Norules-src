package me.nrules.module.render;

import me.nrules.event.events.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.item.*;
import me.nrules.event.*;
import me.nrules.module.*;

public class NoOverlay extends Module
{
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllllIlIIlllllIllllll) {
        if (NoOverlay.mc.effectRenderer.equals(EnumParticleTypes.TOTEM)) {
            NoOverlay.mc.effectRenderer.clearEffects(NoOverlay.mc.world);
        }
        if (NoOverlay.mc.player.isPotionActive(Objects.requireNonNull(Potion.getPotionById(15)))) {
            NoOverlay.mc.player.removePotionEffect(Objects.requireNonNull(Potion.getPotionById(15)));
        }
        if (NoOverlay.mc.player.isPotionActive(Objects.requireNonNull(Potion.getPotionById(9)))) {
            NoOverlay.mc.player.removePotionEffect(Objects.requireNonNull(Potion.getPotionById(9)));
        }
        NoOverlay.mc.entityRenderer.func_190565_a(null);
        if (NoOverlay.mc.world != null) {
            NoOverlay.mc.world.setRainStrength(0.0f);
        }
    }
    
    public NoOverlay() {
        super("NoOverlay", 0, Category.RENDER);
    }
}
