package com.viaversion.viaversion.sponge.commands;

import com.viaversion.viaversion.commands.*;
import com.viaversion.viaversion.api.command.*;
import org.spongepowered.api.command.*;
import org.spongepowered.api.text.*;
import java.util.*;
import org.spongepowered.api.world.*;

public class SpongeCommandHandler extends ViaCommandHandler implements CommandCallable
{
    public CommandResult process(final CommandSource lllllllllllllIIlIllIIIlIIlIlIIlI, final String lllllllllllllIIlIllIIIlIIlIlIlIl) throws CommandException {
        final String[] lllllllllllllIIlIllIIIlIIlIlIlII = (lllllllllllllIIlIllIIIlIIlIlIlIl.length() > 0) ? lllllllllllllIIlIllIIIlIIlIlIlIl.split(" ") : new String[0];
        this.onCommand(new SpongeCommandSender(lllllllllllllIIlIllIIIlIIlIlIIlI), lllllllllllllIIlIllIIIlIIlIlIlII);
        return CommandResult.success();
    }
    
    public Optional<Text> getShortDescription(final CommandSource lllllllllllllIIlIllIIIlIIIllIlII) {
        return Optional.of((Text)Text.of("Shows ViaVersion Version and more."));
    }
    
    public Optional<Text> getHelp(final CommandSource lllllllllllllIIlIllIIIlIIIllIIlI) {
        return Optional.empty();
    }
    
    public boolean testPermission(final CommandSource lllllllllllllIIlIllIIIlIIIllIlll) {
        return lllllllllllllIIlIllIIIlIIIllIlll.hasPermission("viaversion.admin");
    }
    
    public List<String> getSuggestions(final CommandSource lllllllllllllIIlIllIIIlIIlIIIIII, final String lllllllllllllIIlIllIIIlIIIlllIll) throws CommandException {
        final String[] lllllllllllllIIlIllIIIlIIIlllllI = lllllllllllllIIlIllIIIlIIIlllIll.split(" ", -1);
        return this.onTabComplete(new SpongeCommandSender(lllllllllllllIIlIllIIIlIIlIIIIII), lllllllllllllIIlIllIIIlIIIlllllI);
    }
    
    public List<String> getSuggestions(final CommandSource lllllllllllllIIlIllIIIlIIlIIIlll, final String lllllllllllllIIlIllIIIlIIlIIlIlI, final Location<World> lllllllllllllIIlIllIIIlIIlIIlIIl) throws CommandException {
        return this.getSuggestions(lllllllllllllIIlIllIIIlIIlIIIlll, lllllllllllllIIlIllIIIlIIlIIlIlI);
    }
    
    public Text getUsage(final CommandSource lllllllllllllIIlIllIIIlIIIllIIII) {
        return (Text)Text.of("Usage /viaversion");
    }
}
