package me.nrules.module.combat;

import me.nrules.event.events.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import me.nrules.module.*;

public class TriggerBot extends Module
{
    @EventTarget
    public void onEventUpdate(final EventUpdate lllllllllllllIlIlllIlllllIlIIIII) {
        final Entity lllllllllllllIlIlllIlllllIIlllll = TriggerBot.mc.objectMouseOver.entityHit;
        if (lllllllllllllIlIlllIlllllIIlllll == null) {
            return;
        }
        if (TriggerBot.mc.player.getDistanceToEntity(lllllllllllllIlIlllIlllllIIlllll) <= 3.5 && !(lllllllllllllIlIlllIlllllIIlllll instanceof EntityEnderCrystal) && !lllllllllllllIlIlllIlllllIIlllll.isDead && ((EntityLivingBase)lllllllllllllIlIlllIlllllIIlllll).getHealth() > 0.0f && lllllllllllllIlIlllIlllllIIlllll instanceof EntityPlayer && TriggerBot.mc.player.getCooledAttackStrength(0.0f) == 1.0f) {
            TriggerBot.mc.playerController.attackEntity(TriggerBot.mc.player, lllllllllllllIlIlllIlllllIIlllll);
            TriggerBot.mc.player.swingArm(EnumHand.MAIN_HAND);
        }
    }
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public TriggerBot() {
        super("TriggerBot", 0, Category.COMBAT);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
}
