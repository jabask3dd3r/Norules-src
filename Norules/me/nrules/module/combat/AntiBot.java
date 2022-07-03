package me.nrules.module.combat;

import me.nrules.notifications.*;
import me.nrules.module.*;
import java.util.*;
import me.nrules.*;
import clickui.settings.*;
import me.nrules.event.events.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import me.nrules.utils.player.*;
import net.minecraft.inventory.*;
import net.minecraft.init.*;
import com.kisman.nr.cc.util.*;
import me.nrules.event.*;

public class AntiBot extends Module
{
    private /* synthetic */ Setting modeType;
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public AntiBot() {
        super("AntiBot", 0, Category.COMBAT);
        final ArrayList<String> lllllllllllllIlIlllIIlIIIllIlIlI = new ArrayList<String>();
        lllllllllllllIlIlllIIlIIIllIlIlI.add("WellMore");
        lllllllllllllIlIlllIIlIIIllIlIlI.add("Matrix 6.3");
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("BotMode", this, "WellMore", lllllllllllllIlIlllIIlIIIllIlIlI);
        this.modeType = setting;
        settingsManager.Property(setting);
    }
    
    @EventTarget
    public void onUpdate(final EventUpdate lllllllllllllIlIlllIIlIIIllIIIII) {
        for (final EntityPlayer lllllllllllllIlIlllIIlIIIlIlllll : AntiBot.mc.world.playerEntities) {
            if (lllllllllllllIlIlllIIlIIIlIlllll != AntiBot.mc.player) {
                if (lllllllllllllIlIlllIIlIIIlIlllll.isDead) {
                    continue;
                }
                final String lllllllllllllIlIlllIIlIIIlIllllI = this.modeType.getValString();
                if (lllllllllllllIlIlllIIlIIIlIllllI.equalsIgnoreCase("WellMore")) {
                    if (lllllllllllllIlIlllIIlIIIlIlllll.isInvisible()) {
                        lllllllllllllIlIlllIIlIIIlIlllll.isDead = true;
                    }
                    if (lllllllllllllIlIlllIIlIIIlIlllll.getName().length() != 8 || AntiBot.mc.player.getDistanceToEntity(lllllllllllllIlIlllIIlIIIlIlllll) > 5.0f || Math.round(lllllllllllllIlIlllIIlIIIlIlllll.posY) != Math.round(AntiBot.mc.player.posY + 2.0)) {
                        continue;
                    }
                    lllllllllllllIlIlllIIlIIIlIlllll.isDead = true;
                    NotificationPublisher.queue(this.getName(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIlllIIlIIIlIlllll.getName())).append(" was deleted!")), NotificationType.INFO);
                }
                else {
                    final boolean lllllllllllllIlIlllIIlIIIlIlllIl = RotationUtils.isInFOV(lllllllllllllIlIlllIIlIIIlIlllll, AntiBot.mc.player, 100.0) && AntiBot.mc.player.getDistanceToEntity(lllllllllllllIlIlllIIlIIIlIlllll) <= 6.5 && lllllllllllllIlIlllIIlIIIlIlllll.canEntityBeSeen(AntiBot.mc.player);
                    final boolean lllllllllllllIlIlllIIlIIIlIlllII = lllllllllllllIlIlllIIlIIIlIlllll.getActivePotionEffect(MobEffects.SPEED) == null && lllllllllllllIlIlllIIlIIIlIlllll.getActivePotionEffect(MobEffects.JUMP_BOOST) == null && lllllllllllllIlIlllIIlIIIlIlllll.getActivePotionEffect(MobEffects.LEVITATION) == null && !lllllllllllllIlIlllIIlIIIlIlllll.isInWater() && lllllllllllllIlIlllIIlIIIlIlllll.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() != Items.ELYTRA && EntityUtil.getSpeedBPS(lllllllllllllIlIlllIIlIIIlIlllll) >= 11.9;
                    if (!lllllllllllllIlIlllIIlIIIlIlllIl || !lllllllllllllIlIlllIIlIIIlIlllII || lllllllllllllIlIlllIIlIIIlIlllll.isDead || AntiBot.mc.timer.timerSpeed > 1.0f) {
                        continue;
                    }
                    lllllllllllllIlIlllIIlIIIlIlllll.isDead = true;
                    NotificationPublisher.queue(this.getName(), String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIlIlllIIlIIIlIlllll.getName())).append(" was deleted!")), NotificationType.INFO);
                }
            }
        }
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
}
