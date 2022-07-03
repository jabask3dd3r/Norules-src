package com.viaversion.viaversion.sponge.commands;

import com.viaversion.viaversion.api.command.*;
import org.spongepowered.api.command.*;
import java.util.*;
import org.spongepowered.api.util.*;
import com.viaversion.viaversion.*;
import com.viaversion.viaversion.libs.kyori.adventure.text.*;
import org.spongepowered.api.text.serializer.*;

public class SpongeCommandSender implements ViaCommandSender
{
    private final /* synthetic */ CommandSource source;
    
    public SpongeCommandSender(final CommandSource llllllllllllllIIIIIlIlIlIIIllIll) {
        this.source = llllllllllllllIIIIIlIlIlIIIllIll;
    }
    
    @Override
    public String getName() {
        return this.source.getName();
    }
    
    @Override
    public UUID getUUID() {
        if (this.source instanceof Identifiable) {
            return ((Identifiable)this.source).getUniqueId();
        }
        return UUID.fromString(this.getName());
    }
    
    @Override
    public void sendMessage(final String llllllllllllllIIIIIlIlIlIIIIlllI) {
        final String llllllllllllllIIIIIlIlIlIIIIllIl = SpongePlugin.COMPONENT_SERIALIZER.serialize((Component)SpongePlugin.COMPONENT_SERIALIZER.deserialize(llllllllllllllIIIIIlIlIlIIIIlllI));
        this.source.sendMessage(TextSerializers.JSON.deserialize(llllllllllllllIIIIIlIlIlIIIIllIl));
    }
    
    @Override
    public boolean hasPermission(final String llllllllllllllIIIIIlIlIlIIIlIlIl) {
        return this.source.hasPermission(llllllllllllllIIIIIlIlIlIIIlIlIl);
    }
}
