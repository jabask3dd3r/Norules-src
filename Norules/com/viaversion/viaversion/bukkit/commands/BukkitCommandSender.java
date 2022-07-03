package com.viaversion.viaversion.bukkit.commands;

import com.viaversion.viaversion.api.command.*;
import org.bukkit.command.*;
import java.util.*;
import org.bukkit.entity.*;

public class BukkitCommandSender implements ViaCommandSender
{
    private final /* synthetic */ CommandSender sender;
    
    public BukkitCommandSender(final CommandSender llllllllllllllllIIlllllIIIllllIl) {
        this.sender = llllllllllllllllIIlllllIIIllllIl;
    }
    
    @Override
    public void sendMessage(final String llllllllllllllllIIlllllIIIlIIlll) {
        this.sender.sendMessage(llllllllllllllllIIlllllIIIlIIlll);
    }
    
    @Override
    public UUID getUUID() {
        if (this.sender instanceof Player) {
            return ((Player)this.sender).getUniqueId();
        }
        return UUID.fromString(this.getName());
    }
    
    @Override
    public boolean hasPermission(final String llllllllllllllllIIlllllIIIllIlII) {
        return this.sender.hasPermission(llllllllllllllllIIlllllIIIllIlII);
    }
    
    @Override
    public String getName() {
        return this.sender.getName();
    }
}
