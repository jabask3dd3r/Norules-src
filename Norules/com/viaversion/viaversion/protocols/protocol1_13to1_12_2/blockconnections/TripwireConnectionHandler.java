package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;

public class TripwireConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Map<Integer, BlockFace> tripwireHooks;
    private static final /* synthetic */ Map<Byte, Integer> connectedBlocks;
    private static final /* synthetic */ Map<Integer, TripwireData> tripwireDataMap;
    
    static {
        tripwireDataMap = new HashMap<Integer, TripwireData>();
        connectedBlocks = new HashMap<Byte, Integer>();
        tripwireHooks = new HashMap<Integer, BlockFace>();
    }
    
    private static byte getStates(final WrappedBlockData lllllllllllllIlIIIIlIllIllIlIllI) {
        byte lllllllllllllIlIIIIlIllIllIlIlll = 0;
        if (lllllllllllllIlIIIIlIllIllIlIllI.getValue("attached").equals("true")) {
            lllllllllllllIlIIIIlIllIllIlIlll |= 0x1;
        }
        if (lllllllllllllIlIIIIlIllIllIlIllI.getValue("disarmed").equals("true")) {
            lllllllllllllIlIIIIlIllIllIlIlll |= 0x2;
        }
        if (lllllllllllllIlIIIIlIllIllIlIllI.getValue("powered").equals("true")) {
            lllllllllllllIlIIIIlIllIllIlIlll |= 0x4;
        }
        if (lllllllllllllIlIIIIlIllIllIlIllI.getValue("east").equals("true")) {
            lllllllllllllIlIIIIlIllIllIlIlll |= 0x8;
        }
        if (lllllllllllllIlIIIIlIllIllIlIllI.getValue("north").equals("true")) {
            lllllllllllllIlIIIIlIllIllIlIlll |= 0x10;
        }
        if (lllllllllllllIlIIIIlIllIllIlIllI.getValue("south").equals("true")) {
            lllllllllllllIlIIIIlIllIllIlIlll |= 0x20;
        }
        if (lllllllllllllIlIIIIlIllIllIlIllI.getValue("west").equals("true")) {
            lllllllllllllIlIIIIlIllIllIlIlll |= 0x40;
        }
        return lllllllllllllIlIIIIlIllIllIlIlll;
    }
    
    static ConnectionData.ConnectorInitAction init() {
        final TripwireConnectionHandler lllllllllllllIlIIIIlIllIllIlllII = new TripwireConnectionHandler();
        TripwireData lllllllllllllIlIIIIlIllIlIllIIII;
        final TripwireConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return lllllllllllllIlIIIIlIllIlIlIllII -> {
            if (lllllllllllllIlIIIIlIllIlIlIllII.getMinecraftKey().equals("minecraft:tripwire_hook")) {
                TripwireConnectionHandler.tripwireHooks.put(lllllllllllllIlIIIIlIllIlIlIllII.getSavedBlockStateId(), BlockFace.valueOf(lllllllllllllIlIIIIlIllIlIlIllII.getValue("facing").toUpperCase(Locale.ROOT)));
            }
            else if (lllllllllllllIlIIIIlIllIlIlIllII.getMinecraftKey().equals("minecraft:tripwire")) {
                lllllllllllllIlIIIIlIllIlIllIIII = new TripwireData(lllllllllllllIlIIIIlIllIlIlIllII.getValue("attached").equals("true"), lllllllllllllIlIIIIlIllIlIlIllII.getValue("disarmed").equals("true"), lllllllllllllIlIIIIlIllIlIlIllII.getValue("powered").equals("true"));
                TripwireConnectionHandler.tripwireDataMap.put(lllllllllllllIlIIIIlIllIlIlIllII.getSavedBlockStateId(), lllllllllllllIlIIIIlIllIlIllIIII);
                TripwireConnectionHandler.connectedBlocks.put(getStates(lllllllllllllIlIIIIlIllIlIlIllII), lllllllllllllIlIIIIlIllIlIlIllII.getSavedBlockStateId());
                ConnectionData.connectionHandlerMap.put(lllllllllllllIlIIIIlIllIlIlIllII.getSavedBlockStateId(), llllllllllllllIlIIIIllIllIlIIllI);
            }
        };
    }
    
    @Override
    public int connect(final UserConnection lllllllllllllIlIIIIlIllIlIllllIl, final Position lllllllllllllIlIIIIlIllIlIllllII, final int lllllllllllllIlIIIIlIllIllIIIllI) {
        final TripwireData lllllllllllllIlIIIIlIllIllIIIlIl = TripwireConnectionHandler.tripwireDataMap.get(lllllllllllllIlIIIIlIllIllIIIllI);
        if (lllllllllllllIlIIIIlIllIllIIIlIl == null) {
            return lllllllllllllIlIIIIlIllIllIIIllI;
        }
        byte lllllllllllllIlIIIIlIllIllIIIlII = 0;
        if (lllllllllllllIlIIIIlIllIllIIIlIl.isAttached()) {
            lllllllllllllIlIIIIlIllIllIIIlII |= 0x1;
        }
        if (lllllllllllllIlIIIIlIllIllIIIlIl.isDisarmed()) {
            lllllllllllllIlIIIIlIllIllIIIlII |= 0x2;
        }
        if (lllllllllllllIlIIIIlIllIllIIIlIl.isPowered()) {
            lllllllllllllIlIIIIlIllIllIIIlII |= 0x4;
        }
        final int lllllllllllllIlIIIIlIllIllIIIIll = this.getBlockData(lllllllllllllIlIIIIlIllIlIllllIl, lllllllllllllIlIIIIlIllIlIllllII.getRelative(BlockFace.EAST));
        final int lllllllllllllIlIIIIlIllIllIIIIlI = this.getBlockData(lllllllllllllIlIIIIlIllIlIllllIl, lllllllllllllIlIIIIlIllIlIllllII.getRelative(BlockFace.NORTH));
        final int lllllllllllllIlIIIIlIllIllIIIIIl = this.getBlockData(lllllllllllllIlIIIIlIllIlIllllIl, lllllllllllllIlIIIIlIllIlIllllII.getRelative(BlockFace.SOUTH));
        final int lllllllllllllIlIIIIlIllIllIIIIII = this.getBlockData(lllllllllllllIlIIIIlIllIlIllllIl, lllllllllllllIlIIIIlIllIlIllllII.getRelative(BlockFace.WEST));
        if (TripwireConnectionHandler.tripwireDataMap.containsKey(lllllllllllllIlIIIIlIllIllIIIIll) || TripwireConnectionHandler.tripwireHooks.get(lllllllllllllIlIIIIlIllIllIIIIll) == BlockFace.WEST) {
            lllllllllllllIlIIIIlIllIllIIIlII |= 0x8;
        }
        if (TripwireConnectionHandler.tripwireDataMap.containsKey(lllllllllllllIlIIIIlIllIllIIIIlI) || TripwireConnectionHandler.tripwireHooks.get(lllllllllllllIlIIIIlIllIllIIIIlI) == BlockFace.SOUTH) {
            lllllllllllllIlIIIIlIllIllIIIlII |= 0x10;
        }
        if (TripwireConnectionHandler.tripwireDataMap.containsKey(lllllllllllllIlIIIIlIllIllIIIIIl) || TripwireConnectionHandler.tripwireHooks.get(lllllllllllllIlIIIIlIllIllIIIIIl) == BlockFace.NORTH) {
            lllllllllllllIlIIIIlIllIllIIIlII |= 0x20;
        }
        if (TripwireConnectionHandler.tripwireDataMap.containsKey(lllllllllllllIlIIIIlIllIllIIIIII) || TripwireConnectionHandler.tripwireHooks.get(lllllllllllllIlIIIIlIllIllIIIIII) == BlockFace.EAST) {
            lllllllllllllIlIIIIlIllIllIIIlII |= 0x40;
        }
        final Integer lllllllllllllIlIIIIlIllIlIllllll = TripwireConnectionHandler.connectedBlocks.get(lllllllllllllIlIIIIlIllIllIIIlII);
        return (lllllllllllllIlIIIIlIllIlIllllll == null) ? lllllllllllllIlIIIIlIllIllIIIllI : lllllllllllllIlIIIIlIllIlIllllll;
    }
    
    private static final class TripwireData
    {
        private final /* synthetic */ boolean attached;
        private final /* synthetic */ boolean disarmed;
        private final /* synthetic */ boolean powered;
        
        private TripwireData(final boolean llllllllllllllIIIIlIlllIlIlIIIII, final boolean llllllllllllllIIIIlIlllIlIIlllll, final boolean llllllllllllllIIIIlIlllIlIIllIlI) {
            this.attached = llllllllllllllIIIIlIlllIlIlIIIII;
            this.disarmed = llllllllllllllIIIIlIlllIlIIlllll;
            this.powered = llllllllllllllIIIIlIlllIlIIllIlI;
        }
        
        public boolean isDisarmed() {
            return this.disarmed;
        }
        
        public boolean isAttached() {
            return this.attached;
        }
        
        public boolean isPowered() {
            return this.powered;
        }
    }
}
