package me.nrules.module.render;

import me.nrules.module.*;
import me.nrules.event.events.*;
import net.minecraft.network.play.server.*;
import me.nrules.event.*;

public class WorldTime extends Module
{
    public WorldTime() {
        super("WorldTime", 0, Category.RENDER);
    }
    
    @EventTarget
    public void onUpdate(final EventReceivePacket lllllllllllllIIIlIlIlIlIllllIIlI) {
        if (lllllllllllllIIIlIlIlIlIllllIIlI.getPacket() instanceof SPacketTimeUpdate) {
            final SPacketTimeUpdate lllllllllllllIIIlIlIlIlIllllIIIl = (SPacketTimeUpdate)lllllllllllllIIIlIlIlIlIllllIIlI.getPacket();
            WorldTime.mc.world.setWorldTime(20000L);
            lllllllllllllIIIlIlIlIlIllllIIlI.setCancelled(true);
        }
    }
}
