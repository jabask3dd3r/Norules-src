package com.viaversion.viaversion.bukkit.listeners;

import com.viaversion.viaversion.bukkit.platform.*;
import com.viaversion.viaversion.api.*;
import org.bukkit.event.*;
import org.bukkit.event.server.*;

public class ProtocolLibEnableListener implements Listener
{
    @EventHandler
    public void onPluginDisable(final PluginDisableEvent llllllllllllllIlllIIIIIlIllIlIII) {
        if (llllllllllllllIlllIIIIIlIllIlIII.getPlugin().getName().equals("ProtocolLib")) {
            ((BukkitViaInjector)Via.getManager().getInjector()).setProtocolLib(false);
        }
    }
    
    @EventHandler
    public void onPluginEnable(final PluginEnableEvent llllllllllllllIlllIIIIIlIllIllII) {
        if (llllllllllllllIlllIIIIIlIllIllII.getPlugin().getName().equals("ProtocolLib")) {
            ((BukkitViaInjector)Via.getManager().getInjector()).setProtocolLib(true);
        }
    }
}
