package com.viaversion.viaversion.bungee.commands;

import net.md_5.bungee.api.plugin.*;
import net.md_5.bungee.api.*;
import com.viaversion.viaversion.api.command.*;

public class BungeeCommand extends Command implements TabExecutor
{
    private final /* synthetic */ BungeeCommandHandler handler;
    
    public Iterable<String> onTabComplete(final CommandSender lllllllllllllIIIIIIlIIIlIlIllllI, final String[] lllllllllllllIIIIIIlIIIlIlIllIlI) {
        return this.handler.onTabComplete(new BungeeCommandSender(lllllllllllllIIIIIIlIIIlIlIllllI), lllllllllllllIIIIIIlIIIlIlIllIlI);
    }
    
    public BungeeCommand(final BungeeCommandHandler lllllllllllllIIIIIIlIIIlIllIlllI) {
        super("viaversion", "", new String[] { "viaver", "vvbungee" });
        this.handler = lllllllllllllIIIIIIlIIIlIllIlllI;
    }
    
    public void execute(final CommandSender lllllllllllllIIIIIIlIIIlIllIIlll, final String[] lllllllllllllIIIIIIlIIIlIllIIllI) {
        this.handler.onCommand(new BungeeCommandSender(lllllllllllllIIIIIIlIIIlIllIIlll), lllllllllllllIIIIIIlIIIlIllIIllI);
    }
}
