package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;

class ChestConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Set<Integer> trappedChests;
    private static final /* synthetic */ Map<Byte, Integer> connectedStates;
    private static final /* synthetic */ Map<Integer, BlockFace> chestFacings;
    
    @Override
    public int connect(final UserConnection llllllllllllllIIIllIIIIIllllllIl, final Position llllllllllllllIIIllIIIIIllllllII, final int llllllllllllllIIIllIIIIIlllllIll) {
        final BlockFace llllllllllllllIIIllIIIIlIIIIIIll = ChestConnectionHandler.chestFacings.get(llllllllllllllIIIllIIIIIlllllIll);
        byte llllllllllllllIIIllIIIIlIIIIIIlI = 0;
        llllllllllllllIIIllIIIIlIIIIIIlI |= (byte)(llllllllllllllIIIllIIIIlIIIIIIll.ordinal() << 2);
        final boolean llllllllllllllIIIllIIIIlIIIIIIIl = ChestConnectionHandler.trappedChests.contains(llllllllllllllIIIllIIIIIlllllIll);
        if (llllllllllllllIIIllIIIIlIIIIIIIl) {
            llllllllllllllIIIllIIIIlIIIIIIlI |= 0x10;
        }
        int llllllllllllllIIIllIIIIlIIIIIIII;
        if (ChestConnectionHandler.chestFacings.containsKey(llllllllllllllIIIllIIIIlIIIIIIII = this.getBlockData(llllllllllllllIIIllIIIIIllllllIl, llllllllllllllIIIllIIIIIllllllII.getRelative(BlockFace.NORTH))) && llllllllllllllIIIllIIIIlIIIIIIIl == ChestConnectionHandler.trappedChests.contains(llllllllllllllIIIllIIIIlIIIIIIII)) {
            llllllllllllllIIIllIIIIlIIIIIIlI |= (byte)((llllllllllllllIIIllIIIIlIIIIIIll == BlockFace.WEST) ? 1 : 2);
        }
        else if (ChestConnectionHandler.chestFacings.containsKey(llllllllllllllIIIllIIIIlIIIIIIII = this.getBlockData(llllllllllllllIIIllIIIIIllllllIl, llllllllllllllIIIllIIIIIllllllII.getRelative(BlockFace.SOUTH))) && llllllllllllllIIIllIIIIlIIIIIIIl == ChestConnectionHandler.trappedChests.contains(llllllllllllllIIIllIIIIlIIIIIIII)) {
            llllllllllllllIIIllIIIIlIIIIIIlI |= (byte)((llllllllllllllIIIllIIIIlIIIIIIll == BlockFace.EAST) ? 1 : 2);
        }
        else if (ChestConnectionHandler.chestFacings.containsKey(llllllllllllllIIIllIIIIlIIIIIIII = this.getBlockData(llllllllllllllIIIllIIIIIllllllIl, llllllllllllllIIIllIIIIIllllllII.getRelative(BlockFace.WEST))) && llllllllllllllIIIllIIIIlIIIIIIIl == ChestConnectionHandler.trappedChests.contains(llllllllllllllIIIllIIIIlIIIIIIII)) {
            llllllllllllllIIIllIIIIlIIIIIIlI |= (byte)((llllllllllllllIIIllIIIIlIIIIIIll == BlockFace.NORTH) ? 2 : 1);
        }
        else if (ChestConnectionHandler.chestFacings.containsKey(llllllllllllllIIIllIIIIlIIIIIIII = this.getBlockData(llllllllllllllIIIllIIIIIllllllIl, llllllllllllllIIIllIIIIIllllllII.getRelative(BlockFace.EAST))) && llllllllllllllIIIllIIIIlIIIIIIIl == ChestConnectionHandler.trappedChests.contains(llllllllllllllIIIllIIIIlIIIIIIII)) {
            llllllllllllllIIIllIIIIlIIIIIIlI |= (byte)((llllllllllllllIIIllIIIIlIIIIIIll == BlockFace.SOUTH) ? 2 : 1);
        }
        final Integer llllllllllllllIIIllIIIIIllllllll = ChestConnectionHandler.connectedStates.get(llllllllllllllIIIllIIIIlIIIIIIlI);
        return (llllllllllllllIIIllIIIIIllllllll == null) ? llllllllllllllIIIllIIIIIlllllIll : llllllllllllllIIIllIIIIIllllllll;
    }
    
    static ConnectionData.ConnectorInitAction init() {
        final ChestConnectionHandler llllllllllllllIIIllIIIIlIIIllIll = new ChestConnectionHandler();
        final ChestConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return llllllllllllllIIIllIIIIIllllIIII -> {
            if (llllllllllllllIIIllIIIIIllllIIII.getMinecraftKey().equals("minecraft:chest") || llllllllllllllIIIllIIIIIllllIIII.getMinecraftKey().equals("minecraft:trapped_chest")) {
                if (!llllllllllllllIIIllIIIIIllllIIII.getValue("waterlogged").equals("true")) {
                    ChestConnectionHandler.chestFacings.put(llllllllllllllIIIllIIIIIllllIIII.getSavedBlockStateId(), BlockFace.valueOf(llllllllllllllIIIllIIIIIllllIIII.getValue("facing").toUpperCase(Locale.ROOT)));
                    if (llllllllllllllIIIllIIIIIllllIIII.getMinecraftKey().equalsIgnoreCase("minecraft:trapped_chest")) {
                        ChestConnectionHandler.trappedChests.add(llllllllllllllIIIllIIIIIllllIIII.getSavedBlockStateId());
                    }
                    ChestConnectionHandler.connectedStates.put(getStates(llllllllllllllIIIllIIIIIllllIIII), llllllllllllllIIIllIIIIIllllIIII.getSavedBlockStateId());
                    ConnectionData.connectionHandlerMap.put(llllllllllllllIIIllIIIIIllllIIII.getSavedBlockStateId(), llllllllllllllIlIIIIllIllIlIIllI);
                }
            }
        };
    }
    
    private static Byte getStates(final WrappedBlockData llllllllllllllIIIllIIIIlIIIlIIll) {
        byte llllllllllllllIIIllIIIIlIIIlIlIl = 0;
        final String llllllllllllllIIIllIIIIlIIIlIlII = llllllllllllllIIIllIIIIlIIIlIIll.getValue("type");
        if (llllllllllllllIIIllIIIIlIIIlIlII.equals("left")) {
            llllllllllllllIIIllIIIIlIIIlIlIl |= 0x1;
        }
        if (llllllllllllllIIIllIIIIlIIIlIlII.equals("right")) {
            llllllllllllllIIIllIIIIlIIIlIlIl |= 0x2;
        }
        llllllllllllllIIIllIIIIlIIIlIlIl |= (byte)(BlockFace.valueOf(llllllllllllllIIIllIIIIlIIIlIIll.getValue("facing").toUpperCase(Locale.ROOT)).ordinal() << 2);
        if (llllllllllllllIIIllIIIIlIIIlIIll.getMinecraftKey().equals("minecraft:trapped_chest")) {
            llllllllllllllIIIllIIIIlIIIlIlIl |= 0x10;
        }
        return llllllllllllllIIIllIIIIlIIIlIlIl;
    }
    
    static {
        chestFacings = new HashMap<Integer, BlockFace>();
        connectedStates = new HashMap<Byte, Integer>();
        trappedChests = new HashSet<Integer>();
    }
}
