package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.configuration.*;

public class DontBugMeSubCmd extends ViaSubCommand
{
    @Override
    public String name() {
        return "dontbugme";
    }
    
    @Override
    public String description() {
        return "Toggle checking for updates";
    }
    
    @Override
    public boolean execute(final ViaCommandSender llllllllllllIlllllIIIlIllIIlIllI, final String[] llllllllllllIlllllIIIlIllIIllIIl) {
        final ConfigurationProvider llllllllllllIlllllIIIlIllIIllIII = Via.getPlatform().getConfigurationProvider();
        final boolean llllllllllllIlllllIIIlIllIIlIlll = !Via.getConfig().isCheckForUpdates();
        Via.getConfig().setCheckForUpdates(llllllllllllIlllllIIIlIllIIlIlll);
        llllllllllllIlllllIIIlIllIIllIII.saveConfig();
        ViaSubCommand.sendMessage(llllllllllllIlllllIIIlIllIIlIllI, "&6We will %snotify you about updates.", llllllllllllIlllllIIIlIllIIlIlll ? "&a" : "&cnot ");
        return true;
    }
}
