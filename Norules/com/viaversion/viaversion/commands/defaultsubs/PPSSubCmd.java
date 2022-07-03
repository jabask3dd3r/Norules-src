package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.protocol.version.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.*;

public class PPSSubCmd extends ViaSubCommand
{
    @Override
    public String usage() {
        return "pps";
    }
    
    @Override
    public String description() {
        return "Shows the packets per second of online players";
    }
    
    @Override
    public boolean execute(final ViaCommandSender lllllllllllllIIIIllIIIIIIIllIllI, final String[] lllllllllllllIIIIllIIIIIIIllllII) {
        final Map<Integer, Set<String>> lllllllllllllIIIIllIIIIIIIlllIll = new HashMap<Integer, Set<String>>();
        int lllllllllllllIIIIllIIIIIIIlllIlI = 0;
        int lllllllllllllIIIIllIIIIIIIlllIIl = 0;
        long lllllllllllllIIIIllIIIIIIIlllIII = 0L;
        final ViaCommandSender[] onlinePlayers = Via.getPlatform().getOnlinePlayers();
        long lllllllllllllIIIIllIIIIIIIllIIII = onlinePlayers.length;
        for (String lllllllllllllIIIIllIIIIIIIlIllll = (String)0; lllllllllllllIIIIllIIIIIIIlIllll < lllllllllllllIIIIllIIIIIIIllIIII; ++lllllllllllllIIIIllIIIIIIIlIllll) {
            final ViaCommandSender lllllllllllllIIIIllIIIIIIlIIIIII = onlinePlayers[lllllllllllllIIIIllIIIIIIIlIllll];
            final int lllllllllllllIIIIllIIIIIIlIIIIlI = Via.getAPI().getPlayerVersion(lllllllllllllIIIIllIIIIIIlIIIIII.getUUID());
            if (!lllllllllllllIIIIllIIIIIIIlllIll.containsKey(lllllllllllllIIIIllIIIIIIlIIIIlI)) {
                lllllllllllllIIIIllIIIIIIIlllIll.put(lllllllllllllIIIIllIIIIIIlIIIIlI, new HashSet<String>());
            }
            final UserConnection lllllllllllllIIIIllIIIIIIlIIIIIl = Via.getManager().getConnectionManager().getConnectedClient(lllllllllllllIIIIllIIIIIIlIIIIII.getUUID());
            if (lllllllllllllIIIIllIIIIIIlIIIIIl != null && lllllllllllllIIIIllIIIIIIlIIIIIl.getPacketTracker().getPacketsPerSecond() > -1L) {
                lllllllllllllIIIIllIIIIIIIlllIll.get(lllllllllllllIIIIllIIIIIIlIIIIlI).add(String.valueOf(new StringBuilder().append(lllllllllllllIIIIllIIIIIIlIIIIII.getName()).append(" (").append(lllllllllllllIIIIllIIIIIIlIIIIIl.getPacketTracker().getPacketsPerSecond()).append(" PPS)")));
                lllllllllllllIIIIllIIIIIIIlllIlI += (int)lllllllllllllIIIIllIIIIIIlIIIIIl.getPacketTracker().getPacketsPerSecond();
                if (lllllllllllllIIIIllIIIIIIlIIIIIl.getPacketTracker().getPacketsPerSecond() > lllllllllllllIIIIllIIIIIIIlllIII) {
                    lllllllllllllIIIIllIIIIIIIlllIII = lllllllllllllIIIIllIIIIIIlIIIIIl.getPacketTracker().getPacketsPerSecond();
                }
                ++lllllllllllllIIIIllIIIIIIIlllIIl;
            }
        }
        final Map<Integer, Set<String>> lllllllllllllIIIIllIIIIIIIllIlll = new TreeMap<Integer, Set<String>>(lllllllllllllIIIIllIIIIIIIlllIll);
        ViaSubCommand.sendMessage(lllllllllllllIIIIllIIIIIIIllIllI, "&4Live Packets Per Second", new Object[0]);
        if (lllllllllllllIIIIllIIIIIIIlllIIl > 1) {
            ViaSubCommand.sendMessage(lllllllllllllIIIIllIIIIIIIllIllI, String.valueOf(new StringBuilder().append("&cAverage: &f").append(lllllllllllllIIIIllIIIIIIIlllIlI / lllllllllllllIIIIllIIIIIIIlllIIl)), new Object[0]);
            ViaSubCommand.sendMessage(lllllllllllllIIIIllIIIIIIIllIllI, String.valueOf(new StringBuilder().append("&cHighest: &f").append(lllllllllllllIIIIllIIIIIIIlllIII)), new Object[0]);
        }
        if (lllllllllllllIIIIllIIIIIIIlllIIl == 0) {
            ViaSubCommand.sendMessage(lllllllllllllIIIIllIIIIIIIllIllI, "&cNo clients to display.", new Object[0]);
        }
        lllllllllllllIIIIllIIIIIIIllIIII = (long)lllllllllllllIIIIllIIIIIIIllIlll.entrySet().iterator();
        while (((Iterator)lllllllllllllIIIIllIIIIIIIllIIII).hasNext()) {
            final Map.Entry<Integer, Set<String>> lllllllllllllIIIIllIIIIIIIllllll = ((Iterator<Map.Entry<Integer, Set<String>>>)lllllllllllllIIIIllIIIIIIIllIIII).next();
            ViaSubCommand.sendMessage(lllllllllllllIIIIllIIIIIIIllIllI, "&8[&6%s&8]: &b%s", ProtocolVersion.getProtocol(lllllllllllllIIIIllIIIIIIIllllll.getKey()).getName(), lllllllllllllIIIIllIIIIIIIllllll.getValue());
        }
        lllllllllllllIIIIllIIIIIIIllIlll.clear();
        return true;
    }
    
    @Override
    public String name() {
        return "pps";
    }
}
