package me.nrules.module.combat;

import me.nrules.notifications.*;
import me.nrules.event.events.*;
import net.minecraft.item.*;
import net.minecraft.util.math.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import me.nrules.event.*;
import me.nrules.module.*;
import me.nrules.*;
import clickui.settings.*;

public class FastBow extends Module
{
    public /* synthetic */ Setting ticks;
    
    @Override
    public void onDisable() {
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        FastBow.mc.rightClickDelayTimer = 6;
        super.onDisable();
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    @EventTarget
    public void onUpdate(final EventPreMotionUpdate llllllllllllllIIlIlIlllIlllIlIIl) {
        if (this.isToggled() && FastBow.mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow) {
            FastBow.mc.rightClickDelayTimer = 0;
            if (FastBow.mc.player.inventory.getCurrentItem().getItem() instanceof ItemBow && FastBow.mc.player.isHandActive() && FastBow.mc.player.getItemInUseMaxCount() >= this.ticks.getValDouble()) {
                FastBow.mc.player.connection.sendPacket(new CPacketPlayerDigging(CPacketPlayerDigging.Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, FastBow.mc.player.getHorizontalFacing()));
                FastBow.mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
                FastBow.mc.player.stopActiveHand();
            }
        }
    }
    
    public FastBow() {
        super("FastBow", 0, Category.COMBAT);
        final SM settingsManager = Main.settingsManager;
        final Setting setting = new Setting("Ticks", this, 4.0, 2.0, 20.0, false);
        this.ticks = setting;
        settingsManager.Property(setting);
    }
}
