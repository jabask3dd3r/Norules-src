package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;

public class BasicFenceConnectionHandler extends AbstractFenceConnectionHandler
{
    static List<ConnectionData.ConnectorInitAction> init() {
        final List<ConnectionData.ConnectorInitAction> lllllllllllllIIllllIIIIIIIIllIll = new ArrayList<ConnectionData.ConnectorInitAction>();
        lllllllllllllIIllllIIIIIIIIllIll.add(new BasicFenceConnectionHandler("fenceConnections").getInitAction("minecraft:oak_fence"));
        lllllllllllllIIllllIIIIIIIIllIll.add(new BasicFenceConnectionHandler("fenceConnections").getInitAction("minecraft:birch_fence"));
        lllllllllllllIIllllIIIIIIIIllIll.add(new BasicFenceConnectionHandler("fenceConnections").getInitAction("minecraft:jungle_fence"));
        lllllllllllllIIllllIIIIIIIIllIll.add(new BasicFenceConnectionHandler("fenceConnections").getInitAction("minecraft:dark_oak_fence"));
        lllllllllllllIIllllIIIIIIIIllIll.add(new BasicFenceConnectionHandler("fenceConnections").getInitAction("minecraft:acacia_fence"));
        lllllllllllllIIllllIIIIIIIIllIll.add(new BasicFenceConnectionHandler("fenceConnections").getInitAction("minecraft:spruce_fence"));
        return lllllllllllllIIllllIIIIIIIIllIll;
    }
    
    public BasicFenceConnectionHandler(final String lllllllllllllIIllllIIIIIIIIlIllI) {
        super(lllllllllllllIIllllIIIIIIIIlIllI);
    }
}
