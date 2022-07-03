package com.viaversion.viaversion.bukkit.commands;

import com.viaversion.viaversion.commands.*;
import org.bukkit.command.*;
import com.viaversion.viaversion.api.command.*;
import java.util.*;

public class BukkitCommandHandler extends ViaCommandHandler implements CommandExecutor, TabExecutor
{
    public boolean onCommand(final CommandSender lIllIIIIIIIIIIl, final Command lIllIIIIIIIIIII, final String lIlIlllllllllll, final String[] lIlIllllllllllI) {
        return this.onCommand(new BukkitCommandSender(lIllIIIIIIIIIIl), lIlIllllllllllI);
    }
    
    public List<String> onTabComplete(final CommandSender lIlIlllllllIIIl, final Command lIlIlllllllIlIl, final String lIlIlllllllIlII, final String[] lIlIlllllllIIll) {
        return this.onTabComplete(new BukkitCommandSender(lIlIlllllllIIIl), lIlIlllllllIIll);
    }
}
