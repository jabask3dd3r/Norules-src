package com.viaversion.viaversion.velocity.command;

import com.viaversion.viaversion.api.command.*;
import com.velocitypowered.api.command.*;
import com.velocitypowered.api.proxy.*;
import java.util.*;
import com.viaversion.viaversion.*;
import net.kyori.adventure.text.*;

public class VelocityCommandSender implements ViaCommandSender
{
    private final /* synthetic */ CommandSource source;
    
    @Override
    public boolean hasPermission(final String lllllllllllllIlllIlIIlllllIIIIIl) {
        return this.source.hasPermission(lllllllllllllIlllIlIIlllllIIIIIl);
    }
    
    @Override
    public String getName() {
        if (this.source instanceof Player) {
            return ((Player)this.source).getUsername();
        }
        return "?";
    }
    
    @Override
    public UUID getUUID() {
        if (this.source instanceof Player) {
            return ((Player)this.source).getUniqueId();
        }
        return UUID.fromString(this.getName());
    }
    
    public VelocityCommandSender(final CommandSource lllllllllllllIlllIlIIlllllIIIlll) {
        this.source = lllllllllllllIlllIlIIlllllIIIlll;
    }
    
    @Override
    public void sendMessage(final String lllllllllllllIlllIlIIllllIlllIll) {
        this.source.sendMessage((Component)VelocityPlugin.COMPONENT_SERIALIZER.deserialize(lllllllllllllIlllIlIIllllIlllIll));
    }
}
