package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.connection.*;

public class GlassConnectionHandler extends AbstractFenceConnectionHandler
{
    static List<ConnectionData.ConnectorInitAction> init() {
        final List<ConnectionData.ConnectorInitAction> lllllllllllllllIIlllllIIIlIlIlII = new ArrayList<ConnectionData.ConnectorInitAction>(18);
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:white_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:orange_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:magenta_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:light_blue_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:yellow_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:lime_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:pink_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:gray_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:light_gray_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:cyan_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:purple_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:blue_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:brown_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:green_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:red_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:black_stained_glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:glass_pane"));
        lllllllllllllllIIlllllIIIlIlIlII.add(new GlassConnectionHandler("paneConnections").getInitAction("minecraft:iron_bars"));
        return lllllllllllllllIIlllllIIIlIlIlII;
    }
    
    public GlassConnectionHandler(final String lllllllllllllllIIlllllIIIlIIllIl) {
        super(lllllllllllllllIIlllllIIIlIIllIl);
    }
    
    @Override
    protected byte getStates(final UserConnection lllllllllllllllIIlllllIIIIllllll, final Position lllllllllllllllIIlllllIIIlIIIlII, final int lllllllllllllllIIlllllIIIlIIIIll) {
        final byte lllllllllllllllIIlllllIIIlIIIIlI = super.getStates(lllllllllllllllIIlllllIIIIllllll, lllllllllllllllIIlllllIIIlIIIlII, lllllllllllllllIIlllllIIIlIIIIll);
        if (lllllllllllllllIIlllllIIIlIIIIlI != 0) {
            return lllllllllllllllIIlllllIIIlIIIIlI;
        }
        final ProtocolInfo lllllllllllllllIIlllllIIIlIIIIIl = lllllllllllllllIIlllllIIIIllllll.getProtocolInfo();
        return (byte)((lllllllllllllllIIlllllIIIlIIIIIl.getServerProtocolVersion() <= 47 && lllllllllllllllIIlllllIIIlIIIIIl.getServerProtocolVersion() != -1) ? 15 : lllllllllllllllIIlllllIIIlIIIIlI);
    }
}
