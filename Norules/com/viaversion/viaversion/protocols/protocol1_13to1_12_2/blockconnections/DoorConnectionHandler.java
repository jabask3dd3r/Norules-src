package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;

public class DoorConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Map<Integer, DoorData> doorDataMap;
    private static final /* synthetic */ Map<Short, Integer> connectedStates;
    
    @Override
    public int connect(final UserConnection lllllllllllllllIIIIIlllIlIIIlIlI, final Position lllllllllllllllIIIIIlllIlIIIlIIl, final int lllllllllllllllIIIIIlllIIllllllI) {
        final DoorData lllllllllllllllIIIIIlllIlIIIIlll = DoorConnectionHandler.doorDataMap.get(lllllllllllllllIIIIIlllIIllllllI);
        if (lllllllllllllllIIIIIlllIlIIIIlll == null) {
            return lllllllllllllllIIIIIlllIIllllllI;
        }
        short lllllllllllllllIIIIIlllIlIIIIllI = 0;
        lllllllllllllllIIIIIlllIlIIIIllI |= (short)((lllllllllllllllIIIIIlllIlIIIIlll.getType() & 0x7) << 6);
        if (lllllllllllllllIIIIIlllIlIIIIlll.isLower()) {
            final DoorData lllllllllllllllIIIIIlllIlIIIllIl = DoorConnectionHandler.doorDataMap.get(this.getBlockData(lllllllllllllllIIIIIlllIlIIIlIlI, lllllllllllllllIIIIIlllIlIIIlIIl.getRelative(BlockFace.TOP)));
            if (lllllllllllllllIIIIIlllIlIIIllIl == null) {
                return lllllllllllllllIIIIIlllIIllllllI;
            }
            lllllllllllllllIIIIIlllIlIIIIllI |= 0x1;
            if (lllllllllllllllIIIIIlllIlIIIIlll.isOpen()) {
                lllllllllllllllIIIIIlllIlIIIIllI |= 0x2;
            }
            if (lllllllllllllllIIIIIlllIlIIIllIl.isPowered()) {
                lllllllllllllllIIIIIlllIlIIIIllI |= 0x4;
            }
            if (lllllllllllllllIIIIIlllIlIIIllIl.isRightHinge()) {
                lllllllllllllllIIIIIlllIlIIIIllI |= 0x8;
            }
            lllllllllllllllIIIIIlllIlIIIIllI |= (short)(lllllllllllllllIIIIIlllIlIIIIlll.getFacing().ordinal() << 4);
        }
        else {
            final DoorData lllllllllllllllIIIIIlllIlIIIllII = DoorConnectionHandler.doorDataMap.get(this.getBlockData(lllllllllllllllIIIIIlllIlIIIlIlI, lllllllllllllllIIIIIlllIlIIIlIIl.getRelative(BlockFace.BOTTOM)));
            if (lllllllllllllllIIIIIlllIlIIIllII == null) {
                return lllllllllllllllIIIIIlllIIllllllI;
            }
            if (lllllllllllllllIIIIIlllIlIIIllII.isOpen()) {
                lllllllllllllllIIIIIlllIlIIIIllI |= 0x2;
            }
            if (lllllllllllllllIIIIIlllIlIIIIlll.isPowered()) {
                lllllllllllllllIIIIIlllIlIIIIllI |= 0x4;
            }
            if (lllllllllllllllIIIIIlllIlIIIIlll.isRightHinge()) {
                lllllllllllllllIIIIIlllIlIIIIllI |= 0x8;
            }
            lllllllllllllllIIIIIlllIlIIIIllI |= (short)(lllllllllllllllIIIIIlllIlIIIllII.getFacing().ordinal() << 4);
        }
        final Integer lllllllllllllllIIIIIlllIlIIIIlIl = DoorConnectionHandler.connectedStates.get(lllllllllllllllIIIIIlllIlIIIIllI);
        return (lllllllllllllllIIIIIlllIlIIIIlIl == null) ? lllllllllllllllIIIIIlllIIllllllI : lllllllllllllllIIIIIlllIlIIIIlIl;
    }
    
    static {
        doorDataMap = new HashMap<Integer, DoorData>();
        connectedStates = new HashMap<Short, Integer>();
    }
    
    private static short getStates(final DoorData lllllllllllllllIIIIIlllIlIlIllll) {
        short lllllllllllllllIIIIIlllIlIllIIIl = 0;
        if (lllllllllllllllIIIIIlllIlIlIllll.isLower()) {
            lllllllllllllllIIIIIlllIlIllIIIl |= 0x1;
        }
        if (lllllllllllllllIIIIIlllIlIlIllll.isOpen()) {
            lllllllllllllllIIIIIlllIlIllIIIl |= 0x2;
        }
        if (lllllllllllllllIIIIIlllIlIlIllll.isPowered()) {
            lllllllllllllllIIIIIlllIlIllIIIl |= 0x4;
        }
        if (lllllllllllllllIIIIIlllIlIlIllll.isRightHinge()) {
            lllllllllllllllIIIIIlllIlIllIIIl |= 0x8;
        }
        lllllllllllllllIIIIIlllIlIllIIIl |= (short)(lllllllllllllllIIIIIlllIlIlIllll.getFacing().ordinal() << 4);
        lllllllllllllllIIIIIlllIlIllIIIl |= (short)((lllllllllllllllIIIIIlllIlIlIllll.getType() & 0x7) << 6);
        return lllllllllllllllIIIIIlllIlIllIIIl;
    }
    
    static ConnectionData.ConnectorInitAction init() {
        final List<String> lllllllllllllllIIIIIlllIlIllllII = new LinkedList<String>();
        lllllllllllllllIIIIIlllIlIllllII.add("minecraft:oak_door");
        lllllllllllllllIIIIIlllIlIllllII.add("minecraft:birch_door");
        lllllllllllllllIIIIIlllIlIllllII.add("minecraft:jungle_door");
        lllllllllllllllIIIIIlllIlIllllII.add("minecraft:dark_oak_door");
        lllllllllllllllIIIIIlllIlIllllII.add("minecraft:acacia_door");
        lllllllllllllllIIIIIlllIlIllllII.add("minecraft:spruce_door");
        lllllllllllllllIIIIIlllIlIllllII.add("minecraft:iron_door");
        final DoorConnectionHandler lllllllllllllllIIIIIlllIlIlllIll = new DoorConnectionHandler();
        final List list;
        final int lllllllllllllllIIIIIlllIIllIIIll;
        int lllllllllllllllIIIIIlllIIllIIIIl;
        DoorData lllllllllllllllIIIIIlllIIlIlllll;
        final DoorConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return lllllllllllllllIIIIIlllIIlIllIlI -> {
            lllllllllllllllIIIIIlllIIllIIIll = list.indexOf(lllllllllllllllIIIIIlllIIlIllIlI.getMinecraftKey());
            if (lllllllllllllllIIIIIlllIIllIIIll != -1) {
                lllllllllllllllIIIIIlllIIllIIIIl = lllllllllllllllIIIIIlllIIlIllIlI.getSavedBlockStateId();
                lllllllllllllllIIIIIlllIIlIlllll = new DoorData(lllllllllllllllIIIIIlllIIlIllIlI.getValue("half").equals("lower"), lllllllllllllllIIIIIlllIIlIllIlI.getValue("hinge").equals("right"), lllllllllllllllIIIIIlllIIlIllIlI.getValue("powered").equals("true"), lllllllllllllllIIIIIlllIIlIllIlI.getValue("open").equals("true"), BlockFace.valueOf(lllllllllllllllIIIIIlllIIlIllIlI.getValue("facing").toUpperCase(Locale.ROOT)), lllllllllllllllIIIIIlllIIllIIIll);
                DoorConnectionHandler.doorDataMap.put(lllllllllllllllIIIIIlllIIllIIIIl, lllllllllllllllIIIIIlllIIlIlllll);
                DoorConnectionHandler.connectedStates.put(getStates(lllllllllllllllIIIIIlllIIlIlllll), lllllllllllllllIIIIIlllIIllIIIIl);
                ConnectionData.connectionHandlerMap.put(lllllllllllllllIIIIIlllIIllIIIIl, llllllllllllllIlIIIIllIllIlIIllI);
            }
        };
    }
    
    private static final class DoorData
    {
        private final /* synthetic */ BlockFace facing;
        private final /* synthetic */ boolean open;
        private final /* synthetic */ boolean powered;
        private final /* synthetic */ boolean rightHinge;
        private final /* synthetic */ int type;
        private final /* synthetic */ boolean lower;
        
        public int getType() {
            return this.type;
        }
        
        public boolean isLower() {
            return this.lower;
        }
        
        public boolean isPowered() {
            return this.powered;
        }
        
        public BlockFace getFacing() {
            return this.facing;
        }
        
        private DoorData(final boolean lllllllllllllIllIIIIIIllIlIlllll, final boolean lllllllllllllIllIIIIIIllIlIllllI, final boolean lllllllllllllIllIIIIIIllIlIlIllI, final boolean lllllllllllllIllIIIIIIllIlIlIlIl, final BlockFace lllllllllllllIllIIIIIIllIlIlIlII, final int lllllllllllllIllIIIIIIllIlIllIlI) {
            this.lower = lllllllllllllIllIIIIIIllIlIlllll;
            this.rightHinge = lllllllllllllIllIIIIIIllIlIllllI;
            this.powered = lllllllllllllIllIIIIIIllIlIlIllI;
            this.open = lllllllllllllIllIIIIIIllIlIlIlIl;
            this.facing = lllllllllllllIllIIIIIIllIlIlIlII;
            this.type = lllllllllllllIllIIIIIIllIlIllIlI;
        }
        
        public boolean isRightHinge() {
            return this.rightHinge;
        }
        
        public boolean isOpen() {
            return this.open;
        }
    }
}
