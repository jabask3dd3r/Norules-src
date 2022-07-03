package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;

public class FlowerConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Int2IntMap flowers;
    
    static ConnectionData.ConnectorInitAction init() {
        final Set<String> lllllllllllllIllIllIlIIIllllIllI = new HashSet<String>();
        lllllllllllllIllIllIlIIIllllIllI.add("minecraft:rose_bush");
        lllllllllllllIllIllIlIIIllllIllI.add("minecraft:sunflower");
        lllllllllllllIllIllIlIIIllllIllI.add("minecraft:peony");
        lllllllllllllIllIllIlIIIllllIllI.add("minecraft:tall_grass");
        lllllllllllllIllIllIlIIIllllIllI.add("minecraft:large_fern");
        lllllllllllllIllIllIlIIIllllIllI.add("minecraft:lilac");
        final FlowerConnectionHandler lllllllllllllIllIllIlIIIllllIlIl = new FlowerConnectionHandler();
        final Set set;
        final FlowerConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return lllllllllllllIllIllIlIIIllIllIII -> {
            if (set.contains(lllllllllllllIllIllIlIIIllIllIII.getMinecraftKey())) {
                ConnectionData.connectionHandlerMap.put(lllllllllllllIllIllIlIIIllIllIII.getSavedBlockStateId(), llllllllllllllIlIIIIllIllIlIIllI);
                if (lllllllllllllIllIllIlIIIllIllIII.getValue("half").equals("lower")) {
                    lllllllllllllIllIllIlIIIllIllIII.set("half", "upper");
                    FlowerConnectionHandler.flowers.put(lllllllllllllIllIllIlIIIllIllIII.getSavedBlockStateId(), lllllllllllllIllIllIlIIIllIllIII.getBlockStateId());
                }
            }
        };
    }
    
    static {
        flowers = new Int2IntOpenHashMap();
    }
    
    @Override
    public int connect(final UserConnection lllllllllllllIllIllIlIIIlllIlIIl, final Position lllllllllllllIllIllIlIIIlllIIIlI, final int lllllllllllllIllIllIlIIIlllIIIIl) {
        final int lllllllllllllIllIllIlIIIlllIIllI = this.getBlockData(lllllllllllllIllIllIlIIIlllIlIIl, lllllllllllllIllIllIlIIIlllIIIlI.getRelative(BlockFace.BOTTOM));
        final int lllllllllllllIllIllIlIIIlllIIlIl = FlowerConnectionHandler.flowers.get(lllllllllllllIllIllIlIIIlllIIllI);
        if (lllllllllllllIllIllIlIIIlllIIlIl != 0) {
            final int lllllllllllllIllIllIlIIIlllIlIll = this.getBlockData(lllllllllllllIllIllIlIIIlllIlIIl, lllllllllllllIllIllIlIIIlllIIIlI.getRelative(BlockFace.TOP));
            if (Via.getConfig().isStemWhenBlockAbove()) {
                if (lllllllllllllIllIllIlIIIlllIlIll == 0) {
                    return lllllllllllllIllIllIlIIIlllIIlIl;
                }
            }
            else if (!FlowerConnectionHandler.flowers.containsKey(lllllllllllllIllIllIlIIIlllIlIll)) {
                return lllllllllllllIllIllIlIIIlllIIlIl;
            }
        }
        return lllllllllllllIllIllIlIIIlllIIIIl;
    }
}
