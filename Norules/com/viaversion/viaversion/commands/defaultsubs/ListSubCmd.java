package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.api.*;
import java.util.*;

public class ListSubCmd extends ViaSubCommand
{
    @Override
    public boolean execute(final ViaCommandSender lllllllllllllllIllIlIlIIlllIIIIl, final String[] lllllllllllllllIllIlIlIIlllIIIII) {
        final Map<ProtocolVersion, Set<String>> lllllllllllllllIllIlIlIIllIlllll = new TreeMap<ProtocolVersion, Set<String>>((lllllllllllllllIllIlIlIIllIlIIIl, lllllllllllllllIllIlIlIIllIlIIII) -> ProtocolVersion.getIndex(lllllllllllllllIllIlIlIIllIlIIII) - ProtocolVersion.getIndex(lllllllllllllllIllIlIlIIllIlIIIl));
        short lllllllllllllllIllIlIlIIllIlllII = (Object)Via.getPlatform().getOnlinePlayers();
        final float lllllllllllllllIllIlIlIIllIllIll = lllllllllllllllIllIlIlIIllIlllII.length;
        for (byte lllllllllllllllIllIlIlIIllIllIlI = 0; lllllllllllllllIllIlIlIIllIllIlI < lllllllllllllllIllIlIlIIllIllIll; ++lllllllllllllllIllIlIlIIllIllIlI) {
            final ViaCommandSender lllllllllllllllIllIlIlIIlllIIlII = lllllllllllllllIllIlIlIIllIlllII[lllllllllllllllIllIlIlIIllIllIlI];
            final int lllllllllllllllIllIlIlIIlllIIllI = Via.getAPI().getPlayerVersion(lllllllllllllllIllIlIlIIlllIIlII.getUUID());
            final ProtocolVersion lllllllllllllllIllIlIlIIlllIIlIl = ProtocolVersion.getProtocol(lllllllllllllllIllIlIlIIlllIIllI);
            lllllllllllllllIllIlIlIIllIlllll.computeIfAbsent(lllllllllllllllIllIlIlIIlllIIlIl, lllllllllllllllIllIlIlIIllIlIllI -> new HashSet()).add(lllllllllllllllIllIlIlIIlllIIlII.getName());
        }
        lllllllllllllllIllIlIlIIllIlllII = (short)lllllllllllllllIllIlIlIIllIlllll.entrySet().iterator();
        while (((Iterator)lllllllllllllllIllIlIlIIllIlllII).hasNext()) {
            final Map.Entry<ProtocolVersion, Set<String>> lllllllllllllllIllIlIlIIlllIIIll = ((Iterator<Map.Entry<ProtocolVersion, Set<String>>>)lllllllllllllllIllIlIlIIllIlllII).next();
            ViaSubCommand.sendMessage(lllllllllllllllIllIlIlIIlllIIIIl, "&8[&6%s&8] (&7%d&8): &b%s", lllllllllllllllIllIlIlIIlllIIIll.getKey().getName(), lllllllllllllllIllIlIlIIlllIIIll.getValue().size(), lllllllllllllllIllIlIlIIlllIIIll.getValue());
        }
        lllllllllllllllIllIlIlIIllIlllll.clear();
        return true;
    }
    
    @Override
    public String name() {
        return "list";
    }
    
    @Override
    public String description() {
        return "Shows lists of the versions from logged in players";
    }
    
    @Override
    public String usage() {
        return "list";
    }
}
