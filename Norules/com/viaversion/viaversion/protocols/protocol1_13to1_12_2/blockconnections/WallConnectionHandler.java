package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;

public class WallConnectionHandler extends AbstractFenceConnectionHandler
{
    private static final /* synthetic */ BlockFace[] BLOCK_FACES;
    private static final /* synthetic */ int[] OPPOSITES;
    
    @Override
    protected byte getStates(final WrappedBlockData lllllllllllllIIllIlIIIlIlIlIIIll) {
        byte lllllllllllllIIllIlIIIlIlIlIIlIl = super.getStates(lllllllllllllIIllIlIIIlIlIlIIIll);
        if (lllllllllllllIIllIlIIIlIlIlIIIll.getValue("up").equals("true")) {
            lllllllllllllIIllIlIIIlIlIlIIlIl |= 0x10;
        }
        return lllllllllllllIIllIlIIIlIlIlIIlIl;
    }
    
    static List<ConnectionData.ConnectorInitAction> init() {
        final List<ConnectionData.ConnectorInitAction> lllllllllllllIIllIlIIIlIlIllIIlI = new ArrayList<ConnectionData.ConnectorInitAction>(2);
        lllllllllllllIIllIlIIIlIlIllIIlI.add(new WallConnectionHandler("cobbleWallConnections").getInitAction("minecraft:cobblestone_wall"));
        lllllllllllllIIllIlIIIlIlIllIIlI.add(new WallConnectionHandler("cobbleWallConnections").getInitAction("minecraft:mossy_cobblestone_wall"));
        return lllllllllllllIIllIlIIIlIlIllIIlI;
    }
    
    private int getBlockFaces(final UserConnection lllllllllllllIIllIlIIIlIIlllllII, final Position lllllllllllllIIllIlIIIlIIlllIlll) {
        int lllllllllllllIIllIlIIIlIIllllIlI = 0;
        for (int lllllllllllllIIllIlIIIlIIllllllI = 0; lllllllllllllIIllIlIIIlIIllllllI < WallConnectionHandler.BLOCK_FACES.length; ++lllllllllllllIIllIlIIIlIIllllllI) {
            if (this.isWall(this.getBlockData(lllllllllllllIIllIlIIIlIIlllllII, lllllllllllllIIllIlIIIlIIlllIlll.getRelative(WallConnectionHandler.BLOCK_FACES[lllllllllllllIIllIlIIIlIIllllllI])))) {
                lllllllllllllIIllIlIIIlIIllllIlI |= 1 << lllllllllllllIIllIlIIIlIIllllllI;
            }
        }
        return lllllllllllllIIllIlIIIlIIllllIlI;
    }
    
    @Override
    protected byte getStates(final UserConnection lllllllllllllIIllIlIIIlIlIIllIll, final Position lllllllllllllIIllIlIIIlIlIIllIlI, final int lllllllllllllIIllIlIIIlIlIIlIlII) {
        byte lllllllllllllIIllIlIIIlIlIIllIII = super.getStates(lllllllllllllIIllIlIIIlIlIIllIll, lllllllllllllIIllIlIIIlIlIIllIlI, lllllllllllllIIllIlIIIlIlIIlIlII);
        if (this.up(lllllllllllllIIllIlIIIlIlIIllIll, lllllllllllllIIllIlIIIlIlIIllIlI)) {
            lllllllllllllIIllIlIIIlIlIIllIII |= 0x10;
        }
        return lllllllllllllIIllIlIIIlIlIIllIII;
    }
    
    private boolean isWall(final int lllllllllllllIIllIlIIIlIIlllIIIl) {
        return this.getBlockStates().contains(lllllllllllllIIllIlIIIlIIlllIIIl);
    }
    
    public WallConnectionHandler(final String lllllllllllllIIllIlIIIlIlIlIlIll) {
        super(lllllllllllllIIllIlIIIlIlIlIlIll);
    }
    
    public boolean up(final UserConnection lllllllllllllIIllIlIIIlIlIIIlIll, final Position lllllllllllllIIllIlIIIlIlIIIIllI) {
        if (this.isWall(this.getBlockData(lllllllllllllIIllIlIIIlIlIIIlIll, lllllllllllllIIllIlIIIlIlIIIIllI.getRelative(BlockFace.BOTTOM))) || this.isWall(this.getBlockData(lllllllllllllIIllIlIIIlIlIIIlIll, lllllllllllllIIllIlIIIlIlIIIIllI.getRelative(BlockFace.TOP)))) {
            return true;
        }
        final int lllllllllllllIIllIlIIIlIlIIIlIIl = this.getBlockFaces(lllllllllllllIIllIlIIIlIlIIIlIll, lllllllllllllIIllIlIIIlIlIIIIllI);
        if (lllllllllllllIIllIlIIIlIlIIIlIIl == 0 || lllllllllllllIIllIlIIIlIlIIIlIIl == 15) {
            return true;
        }
        for (int lllllllllllllIIllIlIIIlIlIIIllIl = 0; lllllllllllllIIllIlIIIlIlIIIllIl < WallConnectionHandler.BLOCK_FACES.length; ++lllllllllllllIIllIlIIIlIlIIIllIl) {
            if ((lllllllllllllIIllIlIIIlIlIIIlIIl & 1 << lllllllllllllIIllIlIIIlIlIIIllIl) != 0x0 && (lllllllllllllIIllIlIIIlIlIIIlIIl & 1 << WallConnectionHandler.OPPOSITES[lllllllllllllIIllIlIIIlIlIIIllIl]) == 0x0) {
                return true;
            }
        }
        return false;
    }
    
    static {
        BLOCK_FACES = new BlockFace[] { BlockFace.EAST, BlockFace.NORTH, BlockFace.SOUTH, BlockFace.WEST };
        OPPOSITES = new int[] { 3, 2, 1, 0 };
    }
}
