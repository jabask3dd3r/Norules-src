package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.configuration.*;

public class AutoTeamSubCmd extends ViaSubCommand
{
    @Override
    public boolean execute(final ViaCommandSender lllllllllllllllllIIIlIlIIIlIIIII, final String[] lllllllllllllllllIIIlIlIIIIlllll) {
        final ConfigurationProvider lllllllllllllllllIIIlIlIIIIllllI = Via.getPlatform().getConfigurationProvider();
        final boolean lllllllllllllllllIIIlIlIIIIlllIl = !Via.getConfig().isAutoTeam();
        lllllllllllllllllIIIlIlIIIIllllI.set("auto-team", lllllllllllllllllIIIlIlIIIIlllIl);
        lllllllllllllllllIIIlIlIIIIllllI.saveConfig();
        ViaSubCommand.sendMessage(lllllllllllllllllIIIlIlIIIlIIIII, "&6We will %s", lllllllllllllllllIIIlIlIIIIlllIl ? "&aautomatically team players" : "&cno longer auto team players");
        ViaSubCommand.sendMessage(lllllllllllllllllIIIlIlIIIlIIIII, "&6All players will need to re-login for the change to take place.", new Object[0]);
        return true;
    }
    
    @Override
    public String description() {
        return "Toggle automatically teaming to prevent colliding.";
    }
    
    @Override
    public String name() {
        return "autoteam";
    }
}
