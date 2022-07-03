package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;

public class DebugSubCmd extends ViaSubCommand
{
    @Override
    public String description() {
        return "Toggle debug mode";
    }
    
    @Override
    public boolean execute(final ViaCommandSender lllllllllllllIlIIIIlIlIllIIlIlII, final String[] lllllllllllllIlIIIIlIlIllIIlIIll) {
        Via.getManager().setDebug(!Via.getManager().isDebug());
        ViaSubCommand.sendMessage(lllllllllllllIlIIIIlIlIllIIlIlII, "&6Debug mode is now %s", Via.getManager().isDebug() ? "&aenabled" : "&cdisabled");
        return true;
    }
    
    @Override
    public String name() {
        return "debug";
    }
}
