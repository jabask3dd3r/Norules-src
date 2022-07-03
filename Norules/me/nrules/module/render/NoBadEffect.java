package me.nrules.module.render;

import me.nrules.module.*;
import me.nrules.event.events.*;
import net.minecraft.potion.*;
import java.util.*;
import net.minecraft.item.*;
import me.nrules.event.*;

public class NoBadEffect extends Module
{
    public NoBadEffect() {
        super("NoBadEffect", 0, Category.RENDER);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate llllllllllllllIlIlllIIlllIllIIIl) {
        if (NoBadEffect.mc.player.isPotionActive(Objects.requireNonNull(Potion.getPotionById(15)))) {
            NoBadEffect.mc.player.removePotionEffect(Objects.requireNonNull(Potion.getPotionById(15)));
        }
        if (NoBadEffect.mc.player.isPotionActive(Objects.requireNonNull(Potion.getPotionById(9)))) {
            NoBadEffect.mc.player.removePotionEffect(Objects.requireNonNull(Potion.getPotionById(9)));
        }
        NoBadEffect.mc.entityRenderer.func_190565_a(null);
    }
}
