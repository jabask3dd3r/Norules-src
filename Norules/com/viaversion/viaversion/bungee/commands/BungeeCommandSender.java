package com.viaversion.viaversion.bungee.commands;

import com.viaversion.viaversion.api.command.*;
import net.md_5.bungee.api.*;
import java.util.*;
import net.md_5.bungee.api.connection.*;

public class BungeeCommandSender implements ViaCommandSender
{
    private final /* synthetic */ CommandSender sender;
    
    public BungeeCommandSender(final CommandSender lllllllllllllIllIlIlIIlIlIIlIlIl) {
        this.sender = lllllllllllllIllIlIlIIlIlIIlIlIl;
    }
    
    @Override
    public boolean hasPermission(final String lllllllllllllIllIlIlIIlIlIIIllll) {
        return this.sender.hasPermission(lllllllllllllIllIlIlIIlIlIIIllll);
    }
    
    @Override
    public void sendMessage(final String lllllllllllllIllIlIlIIlIlIIIIlll) {
        this.sender.sendMessage(lllllllllllllIllIlIlIIlIlIIIIlll);
    }
    
    @Override
    public UUID getUUID() {
        if (this.sender instanceof ProxiedPlayer) {
            return ((ProxiedPlayer)this.sender).getUniqueId();
        }
        return UUID.fromString(this.getName());
    }
    
    @Override
    public String getName() {
        return this.sender.getName();
    }
}
