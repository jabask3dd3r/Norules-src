package com.viaversion.viaversion.bungee.commands.subs;

import com.viaversion.viaversion.bungee.platform.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.bungee.service.*;

public class ProbeSubCmd extends ViaSubCommand
{
    @Override
    public String name() {
        return "probe";
    }
    
    @Override
    public String description() {
        return String.valueOf(new StringBuilder().append("Forces ViaVersion to scan server protocol versions ").append((((BungeeViaConfig)Via.getConfig()).getBungeePingInterval() == -1) ? "" : "(Also happens at an interval)"));
    }
    
    @Override
    public boolean execute(final ViaCommandSender lllllllllllllIIllIIlIlllllIIlIIl, final String[] lllllllllllllIIllIIlIlllllIIlIlI) {
        ProtocolDetectorService.getInstance().run();
        ViaSubCommand.sendMessage(lllllllllllllIIllIIlIlllllIIlIIl, "&6Started searching for protocol versions", new Object[0]);
        return true;
    }
}
