package com.viaversion.viaversion.velocity.command.subs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.velocity.service.*;
import com.viaversion.viaversion.velocity.platform.*;
import com.viaversion.viaversion.api.*;

public class ProbeSubCmd extends ViaSubCommand
{
    @Override
    public String name() {
        return "probe";
    }
    
    @Override
    public boolean execute(final ViaCommandSender llllllllllllllIllIIllIlIIIIIIIlI, final String[] llllllllllllllIllIIllIlIIIIIIIll) {
        ProtocolDetectorService.getInstance().run();
        ViaSubCommand.sendMessage(llllllllllllllIllIIllIlIIIIIIIlI, "&6Started searching for protocol versions", new Object[0]);
        return true;
    }
    
    @Override
    public String description() {
        return String.valueOf(new StringBuilder().append("Forces ViaVersion to scan server protocol versions ").append((((VelocityViaConfig)Via.getConfig()).getVelocityPingInterval() == -1) ? "" : "(Also happens at an interval)"));
    }
}
