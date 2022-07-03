package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;

public class HelpSubCmd extends ViaSubCommand
{
    @Override
    public String name() {
        return "help";
    }
    
    @Override
    public String description() {
        return "You are looking at it right now!";
    }
    
    @Override
    public boolean execute(final ViaCommandSender lllllllllllllIIIIIIllIlIllllIIIl, final String[] lllllllllllllIIIIIIllIlIllllIIlI) {
        Via.getManager().getCommandHandler().showHelp(lllllllllllllIIIIIIllIlIllllIIIl);
        return true;
    }
}
