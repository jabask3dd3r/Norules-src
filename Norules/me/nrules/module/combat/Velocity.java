package me.nrules.module.combat;

import clickui.settings.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import me.nrules.event.events.*;
import net.minecraft.network.play.server.*;
import net.minecraft.world.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.entity.*;
import me.nrules.event.*;

public class Velocity extends Module
{
    private /* synthetic */ Setting exp;
    private /* synthetic */ Setting bobbers;
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
    
    public Velocity() {
        super("Velocity", 0, Category.COMBAT);
        this.exp = new Setting("Explotion", this, true);
        this.bobbers = new Setting("Bobbers", this, true);
        Velocity.sm.Property(this.exp);
        Velocity.sm.Property(this.bobbers);
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void onPacket(final EventReceivePacket lllllllllllllllIlIIlIIIIIllIIIlI) {
        if (lllllllllllllllIlIIlIIIIIllIIIlI.getPacket() instanceof SPacketEntityVelocity && ((SPacketEntityVelocity)lllllllllllllllIlIIlIIIIIllIIIlI.getPacket()).getEntityID() == Velocity.mc.player.getEntityId()) {
            lllllllllllllllIlIIlIIIIIllIIIlI.setCancelled(true);
        }
        if (lllllllllllllllIlIIlIIIIIllIIIlI.getPacket() instanceof SPacketExplosion && this.exp.getValBoolean()) {
            lllllllllllllllIlIIlIIIIIllIIIlI.setCancelled(true);
        }
        if (lllllllllllllllIlIIlIIIIIllIIIlI.getPacket() instanceof SPacketEntityStatus && this.bobbers.getValBoolean()) {
            final SPacketEntityStatus lllllllllllllllIlIIlIIIIIllIIIIl = (SPacketEntityStatus)lllllllllllllllIlIIlIIIIIllIIIlI.getPacket();
            if (lllllllllllllllIlIIlIIIIIllIIIIl.getOpCode() == 31) {
                final Entity lllllllllllllllIlIIlIIIIIllIIIII = lllllllllllllllIlIIlIIIIIllIIIIl.getEntity(Velocity.mc.world);
                if (lllllllllllllllIlIIlIIIIIllIIIII != null && lllllllllllllllIlIIlIIIIIllIIIII instanceof EntityFishHook) {
                    final EntityFishHook lllllllllllllllIlIIlIIIIIlIlllll = (EntityFishHook)lllllllllllllllIlIIlIIIIIllIIIII;
                    if (lllllllllllllllIlIIlIIIIIlIlllll.caughtEntity == Velocity.mc.player) {
                        lllllllllllllllIlIIlIIIIIllIIIlI.setCancelled(true);
                    }
                }
            }
        }
    }
}
