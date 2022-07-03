package com.viaversion.viaversion.velocity.listeners;

import com.velocitypowered.api.event.connection.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.update.*;
import com.velocitypowered.api.event.*;

public class UpdateListener
{
    @Subscribe
    public void onJoin(final PostLoginEvent lllllllllllllIllIIllIlIllIIllIlI) {
        if (lllllllllllllIllIIllIlIllIIllIlI.getPlayer().hasPermission("viaversion.update") && Via.getConfig().isCheckForUpdates()) {
            UpdateUtil.sendUpdateMessage(lllllllllllllIllIIllIlIllIIllIlI.getPlayer().getUniqueId());
        }
    }
}
