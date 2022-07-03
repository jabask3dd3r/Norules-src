package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;
import com.viaversion.viaversion.libs.fastutil.ints.*;

public class RedstoneConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Int2IntMap powerMappings;
    private static final /* synthetic */ Int2IntMap connectedBlockStates;
    private static final /* synthetic */ Set<Integer> redstone;
    
    @Override
    public int connect(final UserConnection lllllllllllllIlIIIIlIIlIllIIIIlI, final Position lllllllllllllIlIIIIlIIlIllIIIllI, final int lllllllllllllIlIIIIlIIlIllIIIIII) {
        short lllllllllllllIlIIIIlIIlIllIIIlII = 0;
        lllllllllllllIlIIIIlIIlIllIIIlII |= (short)this.connects(lllllllllllllIlIIIIlIIlIllIIIIlI, lllllllllllllIlIIIIlIIlIllIIIllI, BlockFace.EAST);
        lllllllllllllIlIIIIlIIlIllIIIlII |= (short)(this.connects(lllllllllllllIlIIIIlIIlIllIIIIlI, lllllllllllllIlIIIIlIIlIllIIIllI, BlockFace.NORTH) << 2);
        lllllllllllllIlIIIIlIIlIllIIIlII |= (short)(this.connects(lllllllllllllIlIIIIlIIlIllIIIIlI, lllllllllllllIlIIIIlIIlIllIIIllI, BlockFace.SOUTH) << 4);
        lllllllllllllIlIIIIlIIlIllIIIlII |= (short)(this.connects(lllllllllllllIlIIIIlIIlIllIIIIlI, lllllllllllllIlIIIIlIIlIllIIIllI, BlockFace.WEST) << 6);
        lllllllllllllIlIIIIlIIlIllIIIlII |= (short)(RedstoneConnectionHandler.powerMappings.get(lllllllllllllIlIIIIlIIlIllIIIIII) << 8);
        return RedstoneConnectionHandler.connectedBlockStates.getOrDefault(lllllllllllllIlIIIIlIIlIllIIIlII, lllllllllllllIlIIIIlIIlIllIIIIII);
    }
    
    static ConnectionData.ConnectorInitAction init() {
        final RedstoneConnectionHandler lllllllllllllIlIIIIlIIlIllIllllI = new RedstoneConnectionHandler();
        final String lllllllllllllIlIIIIlIIlIllIlllIl = "minecraft:redstone_wire";
        final RedstoneConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return lllllllllllllIlIIIIlIIlIlIIlIlll -> {
            if (!(!"minecraft:redstone_wire".equals(lllllllllllllIlIIIIlIIlIlIIlIlll.getMinecraftKey()))) {
                RedstoneConnectionHandler.redstone.add(lllllllllllllIlIIIIlIIlIlIIlIlll.getSavedBlockStateId());
                ConnectionData.connectionHandlerMap.put(lllllllllllllIlIIIIlIIlIlIIlIlll.getSavedBlockStateId(), llllllllllllllIlIIIIllIllIlIIllI);
                RedstoneConnectionHandler.connectedBlockStates.put(getStates(lllllllllllllIlIIIIlIIlIlIIlIlll), lllllllllllllIlIIIIlIIlIlIIlIlll.getSavedBlockStateId());
                RedstoneConnectionHandler.powerMappings.put(lllllllllllllIlIIIIlIIlIlIIlIlll.getSavedBlockStateId(), Integer.parseInt(lllllllllllllIlIIIIlIIlIlIIlIlll.getValue("power")));
            }
        };
    }
    
    private static int getState(final String lllllllllllllIlIIIIlIIlIllIlIIII) {
        final double lllllllllllllIlIIIIlIIlIllIIllll = (double)lllllllllllllIlIIIIlIIlIllIlIIII;
        boolean lllllllllllllIlIIIIlIIlIllIIlllI = -1 != 0;
        switch (((String)lllllllllllllIlIIIIlIIlIllIIllll).hashCode()) {
            case 3387192: {
                if (((String)lllllllllllllIlIIIIlIIlIllIIllll).equals("none")) {
                    lllllllllllllIlIIIIlIIlIllIIlllI = false;
                    break;
                }
                break;
            }
            case 3530071: {
                if (((String)lllllllllllllIlIIIIlIIlIllIIllll).equals("side")) {
                    lllllllllllllIlIIIIlIIlIllIIlllI = true;
                    break;
                }
                break;
            }
            case 3739: {
                if (((String)lllllllllllllIlIIIIlIIlIllIIllll).equals("up")) {
                    lllllllllllllIlIIIIlIIlIllIIlllI = (2 != 0);
                    break;
                }
                break;
            }
        }
        switch (lllllllllllllIlIIIIlIIlIllIIlllI) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            default: {
                return 0;
            }
        }
    }
    
    private static short getStates(final WrappedBlockData lllllllllllllIlIIIIlIIlIllIlIllI) {
        short lllllllllllllIlIIIIlIIlIllIlIlll = 0;
        lllllllllllllIlIIIIlIIlIllIlIlll |= (short)getState(lllllllllllllIlIIIIlIIlIllIlIllI.getValue("east"));
        lllllllllllllIlIIIIlIIlIllIlIlll |= (short)(getState(lllllllllllllIlIIIIlIIlIllIlIllI.getValue("north")) << 2);
        lllllllllllllIlIIIIlIIlIllIlIlll |= (short)(getState(lllllllllllllIlIIIIlIIlIllIlIllI.getValue("south")) << 4);
        lllllllllllllIlIIIIlIIlIllIlIlll |= (short)(getState(lllllllllllllIlIIIIlIIlIllIlIllI.getValue("west")) << 6);
        lllllllllllllIlIIIIlIIlIllIlIlll |= (short)(Integer.parseInt(lllllllllllllIlIIIIlIIlIllIlIllI.getValue("power")) << 8);
        return lllllllllllllIlIIIIlIIlIllIlIlll;
    }
    
    private int connects(final UserConnection lllllllllllllIlIIIIlIIlIlIlIllIl, final Position lllllllllllllIlIIIIlIIlIlIllIlII, final BlockFace lllllllllllllIlIIIIlIIlIlIllIIll) {
        final Position lllllllllllllIlIIIIlIIlIlIllIIlI = lllllllllllllIlIIIIlIIlIlIllIlII.getRelative(lllllllllllllIlIIIIlIIlIlIllIIll);
        final int lllllllllllllIlIIIIlIIlIlIllIIIl = this.getBlockData(lllllllllllllIlIIIIlIIlIlIlIllIl, lllllllllllllIlIIIIlIIlIlIllIIlI);
        if (this.connects(lllllllllllllIlIIIIlIIlIlIllIIll, lllllllllllllIlIIIIlIIlIlIllIIIl)) {
            return 1;
        }
        final int lllllllllllllIlIIIIlIIlIlIllIIII = this.getBlockData(lllllllllllllIlIIIIlIIlIlIlIllIl, lllllllllllllIlIIIIlIIlIlIllIIlI.getRelative(BlockFace.TOP));
        if (RedstoneConnectionHandler.redstone.contains(lllllllllllllIlIIIIlIIlIlIllIIII) && !ConnectionData.occludingStates.contains(this.getBlockData(lllllllllllllIlIIIIlIIlIlIlIllIl, lllllllllllllIlIIIIlIIlIlIllIlII.getRelative(BlockFace.TOP)))) {
            return 2;
        }
        final int lllllllllllllIlIIIIlIIlIlIlIllll = this.getBlockData(lllllllllllllIlIIIIlIIlIlIlIllIl, lllllllllllllIlIIIIlIIlIlIllIIlI.getRelative(BlockFace.BOTTOM));
        if (RedstoneConnectionHandler.redstone.contains(lllllllllllllIlIIIIlIIlIlIlIllll) && !ConnectionData.occludingStates.contains(this.getBlockData(lllllllllllllIlIIIIlIIlIlIlIllIl, lllllllllllllIlIIIIlIIlIlIllIIlI))) {
            return 1;
        }
        return 0;
    }
    
    private boolean connects(final BlockFace lllllllllllllIlIIIIlIIlIlIlIIIlI, final int lllllllllllllIlIIIIlIIlIlIIllllI) {
        final BlockData lllllllllllllIlIIIIlIIlIlIlIIIII = ConnectionData.blockConnectionData.get(lllllllllllllIlIIIIlIIlIlIIllllI);
        return lllllllllllllIlIIIIlIIlIlIlIIIII != null && lllllllllllllIlIIIIlIIlIlIlIIIII.connectsTo("redstoneConnections", lllllllllllllIlIIIIlIIlIlIlIIIlI.opposite(), false);
    }
    
    static {
        redstone = new HashSet<Integer>();
        connectedBlockStates = new Int2IntOpenHashMap(1296);
        powerMappings = new Int2IntOpenHashMap(1296);
    }
}
