package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;

public class FireConnectionHandler extends ConnectionHandler
{
    private static final /* synthetic */ Map<Byte, Integer> connectedBlocks;
    private static final /* synthetic */ String[] WOOD_TYPES;
    private static final /* synthetic */ Set<Integer> flammableBlocks;
    
    @Override
    public int connect(final UserConnection lllllllllllllIllIlIlIllIIllIIIlI, final Position lllllllllllllIllIlIlIllIIllIIIIl, final int lllllllllllllIllIlIlIllIIllIIIII) {
        byte lllllllllllllIllIlIlIllIIlIlllll = 0;
        if (FireConnectionHandler.flammableBlocks.contains(this.getBlockData(lllllllllllllIllIlIlIllIIllIIIlI, lllllllllllllIllIlIlIllIIllIIIIl.getRelative(BlockFace.EAST)))) {
            lllllllllllllIllIlIlIllIIlIlllll |= 0x1;
        }
        if (FireConnectionHandler.flammableBlocks.contains(this.getBlockData(lllllllllllllIllIlIlIllIIllIIIlI, lllllllllllllIllIlIlIllIIllIIIIl.getRelative(BlockFace.NORTH)))) {
            lllllllllllllIllIlIlIllIIlIlllll |= 0x2;
        }
        if (FireConnectionHandler.flammableBlocks.contains(this.getBlockData(lllllllllllllIllIlIlIllIIllIIIlI, lllllllllllllIllIlIlIllIIllIIIIl.getRelative(BlockFace.SOUTH)))) {
            lllllllllllllIllIlIlIllIIlIlllll |= 0x4;
        }
        if (FireConnectionHandler.flammableBlocks.contains(this.getBlockData(lllllllllllllIllIlIlIllIIllIIIlI, lllllllllllllIllIlIlIllIIllIIIIl.getRelative(BlockFace.TOP)))) {
            lllllllllllllIllIlIlIllIIlIlllll |= 0x8;
        }
        if (FireConnectionHandler.flammableBlocks.contains(this.getBlockData(lllllllllllllIllIlIlIllIIllIIIlI, lllllllllllllIllIlIlIllIIllIIIIl.getRelative(BlockFace.WEST)))) {
            lllllllllllllIllIlIlIllIIlIlllll |= 0x10;
        }
        return FireConnectionHandler.connectedBlocks.get(lllllllllllllIllIlIlIllIIlIlllll);
    }
    
    static {
        WOOD_TYPES = new String[] { "oak", "spruce", "birch", "jungle", "acacia", "dark_oak" };
        connectedBlocks = new HashMap<Byte, Integer>();
        flammableBlocks = new HashSet<Integer>();
    }
    
    static ConnectionData.ConnectorInitAction init() {
        final Set<String> lllllllllllllIllIlIlIllIIlllIIIl = new HashSet<String>();
        lllllllllllllIllIlIlIllIIlllIIIl.add("minecraft:tnt");
        lllllllllllllIllIlIlIllIIlllIIIl.add("minecraft:vine");
        lllllllllllllIllIlIlIllIIlllIIIl.add("minecraft:bookshelf");
        lllllllllllllIllIlIlIllIIlllIIIl.add("minecraft:hay_block");
        lllllllllllllIllIlIlIllIIlllIIIl.add("minecraft:deadbush");
        addWoodTypes(lllllllllllllIllIlIlIllIIlllIIIl, "_slab");
        addWoodTypes(lllllllllllllIllIlIlIllIIlllIIIl, "_log");
        addWoodTypes(lllllllllllllIllIlIlIllIIlllIIIl, "_planks");
        addWoodTypes(lllllllllllllIllIlIlIllIIlllIIIl, "_leaves");
        addWoodTypes(lllllllllllllIllIlIlIllIIlllIIIl, "_fence");
        addWoodTypes(lllllllllllllIllIlIlIllIIlllIIIl, "_fence_gate");
        addWoodTypes(lllllllllllllIllIlIlIllIIlllIIIl, "_stairs");
        final FireConnectionHandler lllllllllllllIllIlIlIllIIlllIIII = new FireConnectionHandler();
        final String lllllllllllllIllIlIlIllIIlIlIIIl;
        final Set set;
        int lllllllllllllIllIlIlIllIIlIlIlIl;
        final FireConnectionHandler llllllllllllllIlIIIIllIllIlIIllI;
        return lllllllllllllIllIlIlIllIIlIlIIlI -> {
            lllllllllllllIllIlIlIllIIlIlIIIl = lllllllllllllIllIlIlIllIIlIlIIlI.getMinecraftKey();
            if (lllllllllllllIllIlIlIllIIlIlIIIl.contains("_wool") || lllllllllllllIllIlIlIllIIlIlIIIl.contains("_carpet") || set.contains(lllllllllllllIllIlIlIllIIlIlIIIl)) {
                FireConnectionHandler.flammableBlocks.add(lllllllllllllIllIlIlIllIIlIlIIlI.getSavedBlockStateId());
            }
            else if (lllllllllllllIllIlIlIllIIlIlIIIl.equals("minecraft:fire")) {
                lllllllllllllIllIlIlIllIIlIlIlIl = lllllllllllllIllIlIlIllIIlIlIIlI.getSavedBlockStateId();
                FireConnectionHandler.connectedBlocks.put(getStates(lllllllllllllIllIlIlIllIIlIlIIlI), lllllllllllllIllIlIlIllIIlIlIlIl);
                ConnectionData.connectionHandlerMap.put(lllllllllllllIllIlIlIllIIlIlIlIl, llllllllllllllIlIIIIllIllIlIIllI);
            }
        };
    }
    
    private static byte getStates(final WrappedBlockData lllllllllllllIllIlIlIllIIllIlIll) {
        byte lllllllllllllIllIlIlIllIIllIlIlI = 0;
        if (lllllllllllllIllIlIlIllIIllIlIll.getValue("east").equals("true")) {
            lllllllllllllIllIlIlIllIIllIlIlI |= 0x1;
        }
        if (lllllllllllllIllIlIlIllIIllIlIll.getValue("north").equals("true")) {
            lllllllllllllIllIlIlIllIIllIlIlI |= 0x2;
        }
        if (lllllllllllllIllIlIlIllIIllIlIll.getValue("south").equals("true")) {
            lllllllllllllIllIlIlIllIIllIlIlI |= 0x4;
        }
        if (lllllllllllllIllIlIlIllIIllIlIll.getValue("up").equals("true")) {
            lllllllllllllIllIlIlIllIIllIlIlI |= 0x8;
        }
        if (lllllllllllllIllIlIlIllIIllIlIll.getValue("west").equals("true")) {
            lllllllllllllIllIlIlIllIIllIlIlI |= 0x10;
        }
        return lllllllllllllIllIlIlIllIIllIlIlI;
    }
    
    private static void addWoodTypes(final Set<String> lllllllllllllIllIlIlIllIIllllIll, final String lllllllllllllIllIlIlIllIIllllIII) {
        final String lllllllllllllIllIlIlIllIIlllIlll = (Object)FireConnectionHandler.WOOD_TYPES;
        final long lllllllllllllIllIlIlIllIIlllIllI = lllllllllllllIllIlIlIllIIlllIlll.length;
        for (byte lllllllllllllIllIlIlIllIIlllIlIl = 0; lllllllllllllIllIlIlIllIIlllIlIl < lllllllllllllIllIlIlIllIIlllIllI; ++lllllllllllllIllIlIlIllIIlllIlIl) {
            final String lllllllllllllIllIlIlIllIIlllllII = lllllllllllllIllIlIlIllIIlllIlll[lllllllllllllIllIlIlIllIIlllIlIl];
            lllllllllllllIllIlIlIllIIllllIll.add(String.valueOf(new StringBuilder().append("minecraft:").append(lllllllllllllIllIlIlIllIIlllllII).append(lllllllllllllIllIlIlIllIIllllIII)));
        }
    }
}
