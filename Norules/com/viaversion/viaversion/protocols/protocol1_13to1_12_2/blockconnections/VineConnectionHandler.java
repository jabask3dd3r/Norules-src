package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;

class VineConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Set<Integer> vines;
    
    static ConnectionData.ConnectorInitAction init() {
        final VineConnectionHandler lllllllllllllIIlllIIlIllIIIIIlIl = new VineConnectionHandler();
        final VineConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return lllllllllllllIIlllIIlIlIllIllIIl -> {
            if (!(!lllllllllllllIIlllIIlIlIllIllIIl.getMinecraftKey().equals("minecraft:vine"))) {
                VineConnectionHandler.vines.add(lllllllllllllIIlllIIlIlIllIllIIl.getSavedBlockStateId());
                ConnectionData.connectionHandlerMap.put(lllllllllllllIIlllIIlIlIllIllIIl.getSavedBlockStateId(), llllllllllllllIlIIIIllIllIlIIllI);
            }
        };
    }
    
    static {
        vines = new HashSet<Integer>();
    }
    
    @Override
    public int connect(final UserConnection lllllllllllllIIlllIIlIlIllllllII, final Position lllllllllllllIIlllIIlIlIlllllIll, final int lllllllllllllIIlllIIlIlIlllllIlI) {
        if (this.isAttachedToBlock(lllllllllllllIIlllIIlIlIllllllII, lllllllllllllIIlllIIlIlIlllllIll)) {
            return lllllllllllllIIlllIIlIlIlllllIlI;
        }
        final Position lllllllllllllIIlllIIlIlIlllllIIl = lllllllllllllIIlllIIlIlIlllllIll.getRelative(BlockFace.TOP);
        final int lllllllllllllIIlllIIlIlIlllllIII = this.getBlockData(lllllllllllllIIlllIIlIlIllllllII, lllllllllllllIIlllIIlIlIlllllIIl);
        if (VineConnectionHandler.vines.contains(lllllllllllllIIlllIIlIlIlllllIII) && this.isAttachedToBlock(lllllllllllllIIlllIIlIlIllllllII, lllllllllllllIIlllIIlIlIlllllIIl)) {
            return lllllllllllllIIlllIIlIlIlllllIlI;
        }
        return 0;
    }
    
    private boolean isAttachedToBlock(final UserConnection lllllllllllllIIlllIIlIlIllIlllll, final Position lllllllllllllIIlllIIlIlIlllIIIlI, final BlockFace lllllllllllllIIlllIIlIlIllIlllIl) {
        return ConnectionData.occludingStates.contains(this.getBlockData(lllllllllllllIIlllIIlIlIllIlllll, lllllllllllllIIlllIIlIlIlllIIIlI.getRelative(lllllllllllllIIlllIIlIlIllIlllIl)));
    }
    
    private boolean isAttachedToBlock(final UserConnection lllllllllllllIIlllIIlIlIlllIlIlI, final Position lllllllllllllIIlllIIlIlIlllIllII) {
        return this.isAttachedToBlock(lllllllllllllIIlllIIlIlIlllIlIlI, lllllllllllllIIlllIIlIlIlllIllII, BlockFace.EAST) || this.isAttachedToBlock(lllllllllllllIIlllIIlIlIlllIlIlI, lllllllllllllIIlllIIlIlIlllIllII, BlockFace.WEST) || this.isAttachedToBlock(lllllllllllllIIlllIIlIlIlllIlIlI, lllllllllllllIIlllIIlIlIlllIllII, BlockFace.NORTH) || this.isAttachedToBlock(lllllllllllllIIlllIIlIlIlllIlIlI, lllllllllllllIIlllIIlIlIlllIllII, BlockFace.SOUTH);
    }
}
