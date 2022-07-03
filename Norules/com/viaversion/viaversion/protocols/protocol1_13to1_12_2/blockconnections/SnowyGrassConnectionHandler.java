package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.util.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;

public class SnowyGrassConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Map<Pair<Integer, Boolean>, Integer> grassBlocks;
    private static final /* synthetic */ Set<Integer> snows;
    
    static ConnectionData.ConnectorInitAction init() {
        final Set<String> lllllllllllllllIIIIIIlIllIlllIII = new HashSet<String>();
        lllllllllllllllIIIIIIlIllIlllIII.add("minecraft:grass_block");
        lllllllllllllllIIIIIIlIllIlllIII.add("minecraft:podzol");
        lllllllllllllllIIIIIIlIllIlllIII.add("minecraft:mycelium");
        final SnowyGrassConnectionHandler lllllllllllllllIIIIIIlIllIllIlll = new SnowyGrassConnectionHandler();
        final Set set;
        final SnowyGrassConnectionHandler snowyGrassConnectionHandler;
        return lllllllllllllllIIIIIIlIllIIIlIlI -> {
            if (set.contains(lllllllllllllllIIIIIIlIllIIIlIlI.getMinecraftKey())) {
                ConnectionData.connectionHandlerMap.put(lllllllllllllllIIIIIIlIllIIIlIlI.getSavedBlockStateId(), snowyGrassConnectionHandler);
                lllllllllllllllIIIIIIlIllIIIlIlI.set("snowy", "true");
                SnowyGrassConnectionHandler.grassBlocks.put(new Pair<Integer, Boolean>(lllllllllllllllIIIIIIlIllIIIlIlI.getSavedBlockStateId(), true), lllllllllllllllIIIIIIlIllIIIlIlI.getBlockStateId());
                lllllllllllllllIIIIIIlIllIIIlIlI.set("snowy", "false");
                SnowyGrassConnectionHandler.grassBlocks.put(new Pair<Integer, Boolean>(lllllllllllllllIIIIIIlIllIIIlIlI.getSavedBlockStateId(), false), lllllllllllllllIIIIIIlIllIIIlIlI.getBlockStateId());
            }
            if (lllllllllllllllIIIIIIlIllIIIlIlI.getMinecraftKey().equals("minecraft:snow") || lllllllllllllllIIIIIIlIllIIIlIlI.getMinecraftKey().equals("minecraft:snow_block")) {
                ConnectionData.connectionHandlerMap.put(lllllllllllllllIIIIIIlIllIIIlIlI.getSavedBlockStateId(), snowyGrassConnectionHandler);
                SnowyGrassConnectionHandler.snows.add(lllllllllllllllIIIIIIlIllIIIlIlI.getSavedBlockStateId());
            }
        };
    }
    
    static {
        grassBlocks = new HashMap<Pair<Integer, Boolean>, Integer>();
        snows = new HashSet<Integer>();
    }
    
    @Override
    public int connect(final UserConnection lllllllllllllllIIIIIIlIllIIllllI, final Position lllllllllllllllIIIIIIlIllIIlllII, final int lllllllllllllllIIIIIIlIllIlIIlII) {
        final int lllllllllllllllIIIIIIlIllIlIIIll = this.getBlockData(lllllllllllllllIIIIIIlIllIIllllI, lllllllllllllllIIIIIIlIllIIlllII.getRelative(BlockFace.TOP));
        final Integer lllllllllllllllIIIIIIlIllIlIIIIl = SnowyGrassConnectionHandler.grassBlocks.get(new Pair(lllllllllllllllIIIIIIlIllIlIIlII, SnowyGrassConnectionHandler.snows.contains(lllllllllllllllIIIIIIlIllIlIIIll)));
        if (lllllllllllllllIIIIIIlIllIlIIIIl != null) {
            return lllllllllllllllIIIIIIlIllIlIIIIl;
        }
        return lllllllllllllllIIIIIIlIllIlIIlII;
    }
}
