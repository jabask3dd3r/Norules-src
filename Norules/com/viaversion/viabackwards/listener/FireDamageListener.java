package com.viaversion.viabackwards.listener;

import com.viaversion.viaversion.bukkit.listeners.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.*;
import org.bukkit.plugin.*;
import com.viaversion.viaversion.api.protocol.*;

public class FireDamageListener extends ViaBukkitListener
{
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onFireDamage(final EntityDamageEvent lllllllllllllIlIIIlIlIIllllIlIIl) {
        if (lllllllllllllIlIIIlIlIIllllIlIIl.getEntityType() != EntityType.PLAYER) {
            return;
        }
        final EntityDamageEvent.DamageCause lllllllllllllIlIIIlIlIIllllIllII = lllllllllllllIlIIIlIlIIllllIlIIl.getCause();
        if (lllllllllllllIlIIIlIlIIllllIllII != EntityDamageEvent.DamageCause.FIRE && lllllllllllllIlIIIlIlIIllllIllII != EntityDamageEvent.DamageCause.FIRE_TICK && lllllllllllllIlIIIlIlIIllllIllII != EntityDamageEvent.DamageCause.LAVA && lllllllllllllIlIIIlIlIIllllIllII != EntityDamageEvent.DamageCause.DROWNING) {
            return;
        }
        final Player lllllllllllllIlIIIlIlIIllllIlIll = (Player)lllllllllllllIlIIIlIlIIllllIlIIl.getEntity();
        if (this.isOnPipe(lllllllllllllIlIIIlIlIIllllIlIll)) {
            lllllllllllllIlIIIlIlIIllllIlIll.playSound(lllllllllllllIlIIIlIlIIllllIlIll.getLocation(), Sound.ENTITY_PLAYER_HURT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
    }
    
    public FireDamageListener(final BukkitPlugin lllllllllllllIlIIIlIlIIlllllIlIl) {
        super((Plugin)lllllllllllllIlIIIlIlIIlllllIlIl, Protocol1_11_1To1_12.class);
    }
}
