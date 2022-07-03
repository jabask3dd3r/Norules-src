package me.nrules.module.misc;

import me.nrules.event.events.*;
import net.minecraft.network.play.client.*;
import me.nrules.event.*;
import me.nrules.notifications.*;
import me.nrules.module.*;
import net.minecraft.network.*;

public class XCarry extends Module
{
    @EventTarget
    public void sendPacket(final EventSendPacket llllllllllllllIIIllIIIlIIlIllIIl) {
        if (llllllllllllllIIIllIIIlIIlIllIIl.getPacket() instanceof CPacketCloseWindow && ((CPacketCloseWindow)llllllllllllllIIIllIIIlIIlIllIIl.getPacket()).windowId == XCarry.mc.player.inventoryContainer.windowId) {
            llllllllllllllIIIllIIIlIIlIllIIl.setCancelled(true);
        }
    }
    
    @Override
    public void onEnable() {
        super.onEnable();
        NotificationPublisher.queue(this.getName(), "Was enabled.", NotificationType.INFO);
    }
    
    public XCarry() {
        super("XCarry", 0, Category.MISC);
    }
    
    @Override
    public void onDisable() {
        if (XCarry.mc.world != null) {
            XCarry.mc.player.connection.sendPacket(new CPacketCloseWindow(XCarry.mc.player.inventoryContainer.windowId));
        }
        NotificationPublisher.queue(this.getName(), "Was disabled.", NotificationType.INFO);
        super.onDisable();
    }
}
