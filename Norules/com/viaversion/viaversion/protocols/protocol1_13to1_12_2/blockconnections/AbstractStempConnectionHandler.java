package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;

public abstract class AbstractStempConnectionHandler extends ConnectionHandler
{
    private final /* synthetic */ Set<Integer> blockId;
    private final /* synthetic */ Map<BlockFace, Integer> stemps;
    private final /* synthetic */ int baseStateId;
    private static final /* synthetic */ BlockFace[] BLOCK_FACES;
    
    public ConnectionData.ConnectorInitAction getInitAction(final String lllllllllllllIlIIIIlllIlIIIIIllI, final String lllllllllllllIlIIIIlllIlIIIIIIIl) {
        final AbstractStempConnectionHandler lllllllllllllIlIIIIlllIlIIIIIlII = this;
        final AbstractStempConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        String lllllllllllllIlIIIIlllIIlllIIlII;
        return lllllllllllllIlIIIIlllIIllIllIlI -> {
            if (lllllllllllllIlIIIIlllIIllIllIlI.getSavedBlockStateId() == this.baseStateId || lllllllllllllIlIIIIlllIlIIIIIllI.equals(lllllllllllllIlIIIIlllIIllIllIlI.getMinecraftKey())) {
                if (lllllllllllllIlIIIIlllIIllIllIlI.getSavedBlockStateId() != this.baseStateId) {
                    llllllllllllllIlIIIIllIllIlIIllI.blockId.add(lllllllllllllIlIIIIlllIIllIllIlI.getSavedBlockStateId());
                }
                ConnectionData.connectionHandlerMap.put(lllllllllllllIlIIIIlllIIllIllIlI.getSavedBlockStateId(), llllllllllllllIlIIIIllIllIlIIllI);
            }
            if (lllllllllllllIlIIIIlllIIllIllIlI.getMinecraftKey().equals(lllllllllllllIlIIIIlllIlIIIIIIIl)) {
                lllllllllllllIlIIIIlllIIlllIIlII = lllllllllllllIlIIIIlllIIllIllIlI.getValue("facing").toUpperCase(Locale.ROOT);
                this.stemps.put(BlockFace.valueOf(lllllllllllllIlIIIIlllIIlllIIlII), lllllllllllllIlIIIIlllIIllIllIlI.getSavedBlockStateId());
            }
        };
    }
    
    static {
        BLOCK_FACES = new BlockFace[] { BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.WEST };
    }
    
    protected AbstractStempConnectionHandler(final String lllllllllllllIlIIIIlllIlIIIIllII) {
        this.blockId = new HashSet<Integer>();
        this.stemps = new HashMap<BlockFace, Integer>();
        this.baseStateId = ConnectionData.getId(lllllllllllllIlIIIIlllIlIIIIllII);
    }
    
    @Override
    public int connect(final UserConnection lllllllllllllIlIIIIlllIIllllIIIl, final Position lllllllllllllIlIIIIlllIIllllIIII, final int lllllllllllllIlIIIIlllIIllllIIll) {
        if (lllllllllllllIlIIIIlllIIllllIIll != this.baseStateId) {
            return lllllllllllllIlIIIIlllIIllllIIll;
        }
        final int lllllllllllllIlIIIIlllIIlllIlllI = (Object)AbstractStempConnectionHandler.BLOCK_FACES;
        final long lllllllllllllIlIIIIlllIIlllIllIl = lllllllllllllIlIIIIlllIIlllIlllI.length;
        for (byte lllllllllllllIlIIIIlllIIlllIllII = 0; lllllllllllllIlIIIIlllIIlllIllII < lllllllllllllIlIIIIlllIIlllIllIl; ++lllllllllllllIlIIIIlllIIlllIllII) {
            final BlockFace lllllllllllllIlIIIIlllIIllllIlll = lllllllllllllIlIIIIlllIIlllIlllI[lllllllllllllIlIIIIlllIIlllIllII];
            if (this.blockId.contains(this.getBlockData(lllllllllllllIlIIIIlllIIllllIIIl, lllllllllllllIlIIIIlllIIllllIIII.getRelative(lllllllllllllIlIIIIlllIIllllIlll)))) {
                return this.stemps.get(lllllllllllllIlIIIIlllIIllllIlll);
            }
        }
        return this.baseStateId;
    }
}
