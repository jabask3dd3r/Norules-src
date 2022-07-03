package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;

public class StairConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Map<Short, Integer> connectedBlocks;
    private static final /* synthetic */ Map<Integer, StairData> stairDataMap;
    
    @Override
    public int connect(final UserConnection lllllllllllllIIlIIIlllIlllIllIlI, final Position lllllllllllllIIlIIIlllIlllIlIIlI, final int lllllllllllllIIlIIIlllIlllIllIII) {
        final StairData lllllllllllllIIlIIIlllIlllIlIlll = StairConnectionHandler.stairDataMap.get(lllllllllllllIIlIIIlllIlllIllIII);
        if (lllllllllllllIIlIIIlllIlllIlIlll == null) {
            return lllllllllllllIIlIIIlllIlllIllIII;
        }
        short lllllllllllllIIlIIIlllIlllIlIllI = 0;
        if (lllllllllllllIIlIIIlllIlllIlIlll.isBottom()) {
            lllllllllllllIIlIIIlllIlllIlIllI |= 0x1;
        }
        lllllllllllllIIlIIIlllIlllIlIllI |= (short)(this.getShape(lllllllllllllIIlIIIlllIlllIllIlI, lllllllllllllIIlIIIlllIlllIlIIlI, lllllllllllllIIlIIIlllIlllIlIlll) << 1);
        lllllllllllllIIlIIIlllIlllIlIllI |= (short)(lllllllllllllIIlIIIlllIlllIlIlll.getType() << 4);
        lllllllllllllIIlIIIlllIlllIlIllI |= (short)(lllllllllllllIIlIIIlllIlllIlIlll.getFacing().ordinal() << 9);
        final Integer lllllllllllllIIlIIIlllIlllIlIlIl = StairConnectionHandler.connectedBlocks.get(lllllllllllllIIlIIIlllIlllIlIllI);
        return (lllllllllllllIIlIIIlllIlllIlIlIl == null) ? lllllllllllllIIlIIIlllIlllIllIII : lllllllllllllIIlIIIlllIlllIlIlIl;
    }
    
    private BlockFace rotateAntiClockwise(final BlockFace lllllllllllllIIlIIIlllIllIlIIIll) {
        switch (lllllllllllllIIlIIIlllIllIlIIIll) {
            case NORTH: {
                return BlockFace.WEST;
            }
            case SOUTH: {
                return BlockFace.EAST;
            }
            case EAST: {
                return BlockFace.NORTH;
            }
            case WEST: {
                return BlockFace.SOUTH;
            }
            default: {
                return lllllllllllllIIlIIIlllIllIlIIIll;
            }
        }
    }
    
    static {
        stairDataMap = new HashMap<Integer, StairData>();
        connectedBlocks = new HashMap<Short, Integer>();
    }
    
    private static short getStates(final StairData lllllllllllllIIlIIIlllIllllIIllI) {
        short lllllllllllllIIlIIIlllIllllIIlIl = 0;
        if (lllllllllllllIIlIIIlllIllllIIllI.isBottom()) {
            lllllllllllllIIlIIIlllIllllIIlIl |= 0x1;
        }
        lllllllllllllIIlIIIlllIllllIIlIl |= (short)(lllllllllllllIIlIIIlllIllllIIllI.getShape() << 1);
        lllllllllllllIIlIIIlllIllllIIlIl |= (short)(lllllllllllllIIlIIIlllIllllIIllI.getType() << 4);
        lllllllllllllIIlIIIlllIllllIIlIl |= (short)(lllllllllllllIIlIIIlllIllllIIllI.getFacing().ordinal() << 9);
        return lllllllllllllIIlIIIlllIllllIIlIl;
    }
    
    private boolean checkOpposite(final UserConnection lllllllllllllIIlIIIlllIllIlIlIlI, final StairData lllllllllllllIIlIIIlllIllIlIllll, final Position lllllllllllllIIlIIIlllIllIlIlIII, final BlockFace lllllllllllllIIlIIIlllIllIlIllIl) {
        final StairData lllllllllllllIIlIIIlllIllIlIllII = StairConnectionHandler.stairDataMap.get(this.getBlockData(lllllllllllllIIlIIIlllIllIlIlIlI, lllllllllllllIIlIIIlllIllIlIlIII.getRelative(lllllllllllllIIlIIIlllIllIlIllIl)));
        return lllllllllllllIIlIIIlllIllIlIllII == null || lllllllllllllIIlIIIlllIllIlIllII.getFacing() != lllllllllllllIIlIIIlllIllIlIllll.getFacing() || lllllllllllllIIlIIIlllIllIlIllII.isBottom() != lllllllllllllIIlIIIlllIllIlIllll.isBottom();
    }
    
    private int getShape(final UserConnection lllllllllllllIIlIIIlllIlllIIIIll, final Position lllllllllllllIIlIIIlllIllIllllII, final StairData lllllllllllllIIlIIIlllIlllIIIIIl) {
        final BlockFace lllllllllllllIIlIIIlllIlllIIIIII = lllllllllllllIIlIIIlllIlllIIIIIl.getFacing();
        StairData lllllllllllllIIlIIIlllIllIllllll = StairConnectionHandler.stairDataMap.get(this.getBlockData(lllllllllllllIIlIIIlllIlllIIIIll, lllllllllllllIIlIIIlllIllIllllII.getRelative(lllllllllllllIIlIIIlllIlllIIIIII)));
        if (lllllllllllllIIlIIIlllIllIllllll != null && lllllllllllllIIlIIIlllIllIllllll.isBottom() == lllllllllllllIIlIIIlllIlllIIIIIl.isBottom()) {
            final BlockFace lllllllllllllIIlIIIlllIlllIIIllI = lllllllllllllIIlIIIlllIllIllllll.getFacing();
            if (lllllllllllllIIlIIIlllIlllIIIIII.getAxis() != lllllllllllllIIlIIIlllIlllIIIllI.getAxis() && this.checkOpposite(lllllllllllllIIlIIIlllIlllIIIIll, lllllllllllllIIlIIIlllIlllIIIIIl, lllllllllllllIIlIIIlllIllIllllII, lllllllllllllIIlIIIlllIlllIIIllI.opposite())) {
                return (lllllllllllllIIlIIIlllIlllIIIllI == this.rotateAntiClockwise(lllllllllllllIIlIIIlllIlllIIIIII)) ? 3 : 4;
            }
        }
        lllllllllllllIIlIIIlllIllIllllll = StairConnectionHandler.stairDataMap.get(this.getBlockData(lllllllllllllIIlIIIlllIlllIIIIll, lllllllllllllIIlIIIlllIllIllllII.getRelative(lllllllllllllIIlIIIlllIlllIIIIII.opposite())));
        if (lllllllllllllIIlIIIlllIllIllllll != null && lllllllllllllIIlIIIlllIllIllllll.isBottom() == lllllllllllllIIlIIIlllIlllIIIIIl.isBottom()) {
            final BlockFace lllllllllllllIIlIIIlllIlllIIIlIl = lllllllllllllIIlIIIlllIllIllllll.getFacing();
            if (lllllllllllllIIlIIIlllIlllIIIIII.getAxis() != lllllllllllllIIlIIIlllIlllIIIlIl.getAxis() && this.checkOpposite(lllllllllllllIIlIIIlllIlllIIIIll, lllllllllllllIIlIIIlllIlllIIIIIl, lllllllllllllIIlIIIlllIllIllllII, lllllllllllllIIlIIIlllIlllIIIlIl)) {
                return (lllllllllllllIIlIIIlllIlllIIIlIl == this.rotateAntiClockwise(lllllllllllllIIlIIIlllIlllIIIIII)) ? 1 : 2;
            }
        }
        return 0;
    }
    
    static ConnectionData.ConnectorInitAction init() {
        final List<String> lllllllllllllIIlIIIlllIllllIllII = new LinkedList<String>();
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:oak_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:cobblestone_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:brick_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:stone_brick_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:nether_brick_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:sandstone_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:spruce_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:birch_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:jungle_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:quartz_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:acacia_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:dark_oak_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:red_sandstone_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:purpur_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:prismarine_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:prismarine_brick_stairs");
        lllllllllllllIIlIIIlllIllllIllII.add("minecraft:dark_prismarine_stairs");
        final StairConnectionHandler lllllllllllllIIlIIIlllIllllIlIll = new StairConnectionHandler();
        final List list;
        final int lllllllllllllIIlIIIlllIllIIlIIlI;
        short lllllllllllllIIlIIIlllIllIIIlIlI;
        String lllllllllllllIIlIIIlllIllIIIlIIl;
        byte lllllllllllllIIlIIIlllIllIIllIlI;
        byte lllllllllllllIIlIIIlllIllIIllIIl;
        byte lllllllllllllIIlIIIlllIllIIllIII;
        byte lllllllllllllIIlIIIlllIllIIlIlll;
        byte lllllllllllllIIlIIIlllIllIIlIllI;
        final byte lllllllllllllIIlIIIlllIllIIlIIIl;
        StairData lllllllllllllIIlIIIlllIllIIlIIII;
        final StairConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return lllllllllllllIIlIIIlllIllIIlIIll -> {
            lllllllllllllIIlIIIlllIllIIlIIlI = list.indexOf(lllllllllllllIIlIIIlllIllIIlIIll.getMinecraftKey());
            if (lllllllllllllIIlIIIlllIllIIlIIlI != -1) {
                if (!lllllllllllllIIlIIIlllIllIIlIIll.getValue("waterlogged").equals("true")) {
                    lllllllllllllIIlIIIlllIllIIIlIlI = (short)lllllllllllllIIlIIIlllIllIIlIIll.getValue("shape");
                    lllllllllllllIIlIIIlllIllIIIlIIl = (String)(-1);
                    switch (((String)lllllllllllllIIlIIIlllIllIIIlIlI).hashCode()) {
                        case 1787472634: {
                            if (((String)lllllllllllllIIlIIIlllIllIIIlIlI).equals("straight")) {
                                lllllllllllllIIlIIIlllIllIIIlIIl = (String)0;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case 823365712: {
                            if (((String)lllllllllllllIIlIIIlllIllIIIlIlI).equals("inner_left")) {
                                lllllllllllllIIlIIIlllIllIIIlIIl = (String)1;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -239805709: {
                            if (((String)lllllllllllllIIlIIIlllIllIIIlIlI).equals("inner_right")) {
                                lllllllllllllIIlIIIlllIllIIIlIIl = (String)2;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case 1743932747: {
                            if (((String)lllllllllllllIIlIIIlllIllIIIlIlI).equals("outer_left")) {
                                lllllllllllllIIlIIIlllIllIIIlIIl = (String)3;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                        case -1766998696: {
                            if (((String)lllllllllllllIIlIIIlllIllIIIlIlI).equals("outer_right")) {
                                lllllllllllllIIlIIIlllIllIIIlIIl = (String)4;
                                break;
                            }
                            else {
                                break;
                            }
                            break;
                        }
                    }
                    switch (lllllllllllllIIlIIIlllIllIIIlIIl) {
                        case 0L: {
                            lllllllllllllIIlIIIlllIllIIllIlI = 0;
                            break;
                        }
                        case 1L: {
                            lllllllllllllIIlIIIlllIllIIllIIl = 1;
                            break;
                        }
                        case 2L: {
                            lllllllllllllIIlIIIlllIllIIllIII = 2;
                            break;
                        }
                        case 3L: {
                            lllllllllllllIIlIIIlllIllIIlIlll = 3;
                            break;
                        }
                        case 4L: {
                            lllllllllllllIIlIIIlllIllIIlIllI = 4;
                            break;
                        }
                        default: {
                            return;
                        }
                    }
                    lllllllllllllIIlIIIlllIllIIlIIII = new StairData(lllllllllllllIIlIIIlllIllIIlIIll.getValue("half").equals("bottom"), lllllllllllllIIlIIIlllIllIIlIIIl, (byte)lllllllllllllIIlIIIlllIllIIlIIlI, BlockFace.valueOf(lllllllllllllIIlIIIlllIllIIlIIll.getValue("facing").toUpperCase(Locale.ROOT)));
                    StairConnectionHandler.stairDataMap.put(lllllllllllllIIlIIIlllIllIIlIIll.getSavedBlockStateId(), lllllllllllllIIlIIIlllIllIIlIIII);
                    StairConnectionHandler.connectedBlocks.put(getStates(lllllllllllllIIlIIIlllIllIIlIIII), lllllllllllllIIlIIIlllIllIIlIIll.getSavedBlockStateId());
                    ConnectionData.connectionHandlerMap.put(lllllllllllllIIlIIIlllIllIIlIIll.getSavedBlockStateId(), llllllllllllllIlIIIIllIllIlIIllI);
                }
            }
        };
    }
    
    private static final class StairData
    {
        private final /* synthetic */ byte type;
        private final /* synthetic */ boolean bottom;
        private final /* synthetic */ byte shape;
        private final /* synthetic */ BlockFace facing;
        
        public byte getShape() {
            return this.shape;
        }
        
        public BlockFace getFacing() {
            return this.facing;
        }
        
        public byte getType() {
            return this.type;
        }
        
        private StairData(final boolean llllllllllllllIllllIIllIlIIlllII, final byte llllllllllllllIllllIIllIlIlIIIII, final byte llllllllllllllIllllIIllIlIIlllll, final BlockFace llllllllllllllIllllIIllIlIIllIIl) {
            this.bottom = llllllllllllllIllllIIllIlIIlllII;
            this.shape = llllllllllllllIllllIIllIlIlIIIII;
            this.type = llllllllllllllIllllIIllIlIIlllll;
            this.facing = llllllllllllllIllllIIllIlIIllIIl;
        }
        
        public boolean isBottom() {
            return this.bottom;
        }
    }
}
