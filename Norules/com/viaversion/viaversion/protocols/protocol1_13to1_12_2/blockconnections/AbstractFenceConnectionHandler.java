package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.version.*;

public abstract class AbstractFenceConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ StairConnectionHandler STAIR_CONNECTION_HANDLER;
    private final /* synthetic */ Map<Byte, Integer> connectedBlockStates;
    private final /* synthetic */ Set<Integer> blockStates;
    private final /* synthetic */ String blockConnections;
    
    public Set<Integer> getBlockStates() {
        return this.blockStates;
    }
    
    protected boolean connects(final BlockFace lllllllllllllIllIlIIllIIlIIIllll, final int lllllllllllllIllIlIIllIIlIIIlIIl, final boolean lllllllllllllIllIlIIllIIlIIIlIII) {
        if (this.blockStates.contains(lllllllllllllIllIlIIllIIlIIIlIIl)) {
            return true;
        }
        if (this.blockConnections == null) {
            return false;
        }
        final BlockData lllllllllllllIllIlIIllIIlIIIllII = ConnectionData.blockConnectionData.get(lllllllllllllIllIlIIllIIlIIIlIIl);
        return lllllllllllllIllIlIIllIIlIIIllII != null && lllllllllllllIllIlIIllIIlIIIllII.connectsTo(this.blockConnections, lllllllllllllIllIlIIllIIlIIIllll.opposite(), lllllllllllllIllIlIIllIIlIIIlIII);
    }
    
    @Override
    public int getBlockData(final UserConnection lllllllllllllIllIlIIllIIlIllIllI, final Position lllllllllllllIllIlIIllIIlIlllIII) {
        return AbstractFenceConnectionHandler.STAIR_CONNECTION_HANDLER.connect(lllllllllllllIllIlIIllIIlIllIllI, lllllllllllllIllIlIIllIIlIlllIII, super.getBlockData(lllllllllllllIllIlIIllIIlIllIllI, lllllllllllllIllIlIIllIIlIlllIII));
    }
    
    protected byte getStates(final WrappedBlockData lllllllllllllIllIlIIllIIllIIllll) {
        byte lllllllllllllIllIlIIllIIllIlIIII = 0;
        if (lllllllllllllIllIlIIllIIllIIllll.getValue("east").equals("true")) {
            lllllllllllllIllIlIIllIIllIlIIII |= 0x1;
        }
        if (lllllllllllllIllIlIIllIIllIIllll.getValue("north").equals("true")) {
            lllllllllllllIllIlIIllIIllIlIIII |= 0x2;
        }
        if (lllllllllllllIllIlIIllIIllIIllll.getValue("south").equals("true")) {
            lllllllllllllIllIlIIllIIllIlIIII |= 0x4;
        }
        if (lllllllllllllIllIlIIllIIllIIllll.getValue("west").equals("true")) {
            lllllllllllllIllIlIIllIIllIlIIII |= 0x8;
        }
        return lllllllllllllIllIlIIllIIllIlIIII;
    }
    
    @Override
    public int connect(final UserConnection lllllllllllllIllIlIIllIIlIlIIllI, final Position lllllllllllllIllIlIIllIIlIlIIlII, final int lllllllllllllIllIlIIllIIlIlIIIlI) {
        final Integer lllllllllllllIllIlIIllIIlIlIlIII = this.connectedBlockStates.get(this.getStates(lllllllllllllIllIlIIllIIlIlIIllI, lllllllllllllIllIlIIllIIlIlIIlII, lllllllllllllIllIlIIllIIlIlIIIlI));
        return (lllllllllllllIllIlIIllIIlIlIlIII == null) ? lllllllllllllIllIlIIllIIlIlIIIlI : lllllllllllllIllIlIIllIIlIlIlIII;
    }
    
    public ConnectionData.ConnectorInitAction getInitAction(final String lllllllllllllIllIlIIllIIllIllIIl) {
        final AbstractFenceConnectionHandler lllllllllllllIllIlIIllIIllIllIII = this;
        final AbstractFenceConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return lllllllllllllIllIlIIllIIIllIlllI -> {
            if (lllllllllllllIllIlIIllIIllIllIIl.equals(lllllllllllllIllIlIIllIIIllIlllI.getMinecraftKey())) {
                if (!lllllllllllllIllIlIIllIIIllIlllI.hasData("waterlogged") || !lllllllllllllIllIlIIllIIIllIlllI.getValue("waterlogged").equals("true")) {
                    this.blockStates.add(lllllllllllllIllIlIIllIIIllIlllI.getSavedBlockStateId());
                    ConnectionData.connectionHandlerMap.put(lllllllllllllIllIlIIllIIIllIlllI.getSavedBlockStateId(), llllllllllllllIlIIIIllIllIlIIllI);
                    this.connectedBlockStates.put(this.getStates(lllllllllllllIllIlIIllIIIllIlllI), lllllllllllllIllIlIIllIIIllIlllI.getSavedBlockStateId());
                }
            }
        };
    }
    
    static {
        STAIR_CONNECTION_HANDLER = new StairConnectionHandler();
    }
    
    protected AbstractFenceConnectionHandler(final String lllllllllllllIllIlIIllIIlllIIIII) {
        this.blockStates = new HashSet<Integer>();
        this.connectedBlockStates = new HashMap<Byte, Integer>();
        this.blockConnections = lllllllllllllIllIlIIllIIlllIIIII;
    }
    
    protected byte getStates(final UserConnection lllllllllllllIllIlIIllIIllIIIlll, final Position lllllllllllllIllIlIIllIIllIIIllI, final int lllllllllllllIllIlIIllIIllIIIlIl) {
        byte lllllllllllllIllIlIIllIIllIIIlII = 0;
        final boolean lllllllllllllIllIlIIllIIllIIIIll = lllllllllllllIllIlIIllIIllIIIlll.getProtocolInfo().getServerProtocolVersion() < ProtocolVersion.v1_12.getVersion();
        if (this.connects(BlockFace.EAST, this.getBlockData(lllllllllllllIllIlIIllIIllIIIlll, lllllllllllllIllIlIIllIIllIIIllI.getRelative(BlockFace.EAST)), lllllllllllllIllIlIIllIIllIIIIll)) {
            lllllllllllllIllIlIIllIIllIIIlII |= 0x1;
        }
        if (this.connects(BlockFace.NORTH, this.getBlockData(lllllllllllllIllIlIIllIIllIIIlll, lllllllllllllIllIlIIllIIllIIIllI.getRelative(BlockFace.NORTH)), lllllllllllllIllIlIIllIIllIIIIll)) {
            lllllllllllllIllIlIIllIIllIIIlII |= 0x2;
        }
        if (this.connects(BlockFace.SOUTH, this.getBlockData(lllllllllllllIllIlIIllIIllIIIlll, lllllllllllllIllIlIIllIIllIIIllI.getRelative(BlockFace.SOUTH)), lllllllllllllIllIlIIllIIllIIIIll)) {
            lllllllllllllIllIlIIllIIllIIIlII |= 0x4;
        }
        if (this.connects(BlockFace.WEST, this.getBlockData(lllllllllllllIllIlIIllIIllIIIlll, lllllllllllllIllIlIIllIIllIIIllI.getRelative(BlockFace.WEST)), lllllllllllllIllIlIIllIIllIIIIll)) {
            lllllllllllllIllIlIIllIIllIIIlII |= 0x8;
        }
        return lllllllllllllIllIlIIllIIllIIIlII;
    }
}
