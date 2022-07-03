package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.blockconnections;

import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.minecraft.*;

public class ChorusPlantConnectionHandler extends AbstractFenceConnectionHandler
{
    private final /* synthetic */ int endstone;
    
    static List<ConnectionData.ConnectorInitAction> init() {
        final List<ConnectionData.ConnectorInitAction> llllllllllllllllllIIlIIlIllIIlll = new ArrayList<ConnectionData.ConnectorInitAction>(2);
        final ChorusPlantConnectionHandler llllllllllllllllllIIlIIlIllIIllI = new ChorusPlantConnectionHandler();
        llllllllllllllllllIIlIIlIllIIlll.add(llllllllllllllllllIIlIIlIllIIllI.getInitAction("minecraft:chorus_plant"));
        llllllllllllllllllIIlIIlIllIIlll.add(llllllllllllllllllIIlIIlIllIIllI.getExtraAction());
        return llllllllllllllllllIIlIIlIllIIlll;
    }
    
    @Override
    protected boolean connects(final BlockFace llllllllllllllllllIIlIIlIlIIIIIl, final int llllllllllllllllllIIlIIlIlIIIIII, final boolean llllllllllllllllllIIlIIlIIllllll) {
        return this.getBlockStates().contains(llllllllllllllllllIIlIIlIlIIIIII) || (llllllllllllllllllIIlIIlIlIIIIIl == BlockFace.BOTTOM && llllllllllllllllllIIlIIlIlIIIIII == this.endstone);
    }
    
    @Override
    protected byte getStates(final WrappedBlockData llllllllllllllllllIIlIIlIlIllIIl) {
        byte llllllllllllllllllIIlIIlIlIllIII = super.getStates(llllllllllllllllllIIlIIlIlIllIIl);
        if (llllllllllllllllllIIlIIlIlIllIIl.getValue("up").equals("true")) {
            llllllllllllllllllIIlIIlIlIllIII |= 0x10;
        }
        if (llllllllllllllllllIIlIIlIlIllIIl.getValue("down").equals("true")) {
            llllllllllllllllllIIlIIlIlIllIII |= 0x20;
        }
        return llllllllllllllllllIIlIIlIlIllIII;
    }
    
    public ConnectionData.ConnectorInitAction getExtraAction() {
        return llllllllllllllllllIIlIIlIIllIllI -> {
            if (llllllllllllllllllIIlIIlIIllIllI.getMinecraftKey().equals("minecraft:chorus_flower")) {
                this.getBlockStates().add(llllllllllllllllllIIlIIlIIllIllI.getSavedBlockStateId());
            }
        };
    }
    
    @Override
    protected byte getStates(final UserConnection llllllllllllllllllIIlIIlIlIIlllI, final Position llllllllllllllllllIIlIIlIlIIlIII, final int llllllllllllllllllIIlIIlIlIIIlll) {
        byte llllllllllllllllllIIlIIlIlIIlIll = super.getStates(llllllllllllllllllIIlIIlIlIIlllI, llllllllllllllllllIIlIIlIlIIlIII, llllllllllllllllllIIlIIlIlIIIlll);
        if (this.connects(BlockFace.TOP, this.getBlockData(llllllllllllllllllIIlIIlIlIIlllI, llllllllllllllllllIIlIIlIlIIlIII.getRelative(BlockFace.TOP)), false)) {
            llllllllllllllllllIIlIIlIlIIlIll |= 0x10;
        }
        if (this.connects(BlockFace.BOTTOM, this.getBlockData(llllllllllllllllllIIlIIlIlIIlllI, llllllllllllllllllIIlIIlIlIIlIII.getRelative(BlockFace.BOTTOM)), false)) {
            llllllllllllllllllIIlIIlIlIIlIll |= 0x20;
        }
        return llllllllllllllllllIIlIIlIlIIlIll;
    }
    
    public ChorusPlantConnectionHandler() {
        super(null);
        this.endstone = ConnectionData.getId("minecraft:end_stone");
    }
}
