package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;

public class ReloadSubCmd extends ViaSubCommand
{
    @Override
    public String name() {
        return "reload";
    }
    
    @Override
    public boolean execute(final ViaCommandSender lllllllllllllIllIIllIlIllIIllIIl, final String[] lllllllllllllIllIIllIlIllIIllIll) {
        Via.getPlatform().getConfigurationProvider().reloadConfig();
        ViaSubCommand.sendMessage(lllllllllllllIllIIllIlIllIIllIIl, "&6Configuration successfully reloaded! Some features may need a restart.", new Object[0]);
        return true;
    }
    
    @Override
    public String description() {
        return "Reload the config from the disk";
    }
}
