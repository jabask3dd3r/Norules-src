package com.viaversion.viabackwards.protocol.protocol1_10to1_11;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viabackwards.protocol.protocol1_10to1_11.storage.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_10to1_11.packets.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.data.*;

public class Protocol1_10To1_11 extends BackwardsProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9_3, ServerboundPackets1_9_3, ServerboundPackets1_9_3>
{
    private final /* synthetic */ EntityPackets1_11 entityPackets;
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    private /* synthetic */ BlockItemPackets1_11 blockItemPackets;
    
    static {
        MAPPINGS = new BackwardsMappings("1.11", "1.10", null, true);
    }
    
    @Override
    public void init(final UserConnection lllllllllllllllIllIlIllIIIIlIlll) {
        if (!lllllllllllllllIllIlIllIIIIlIlll.has(ClientWorld.class)) {
            lllllllllllllllIllIlIllIIIIlIlll.put(new ClientWorld(lllllllllllllllIllIlIllIIIIlIlll));
        }
        lllllllllllllllIllIlIllIIIIlIlll.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllllIllIlIllIIIIlIlll, Entity1_11Types.EntityType.PLAYER, true));
        if (!lllllllllllllllIllIlIllIIIIlIlll.has(WindowTracker.class)) {
            lllllllllllllllIllIlIllIIIIlIlll.put(new WindowTracker());
        }
    }
    
    public Protocol1_10To1_11() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9_3.class);
        this.entityPackets = new EntityPackets1_11(this);
    }
    
    @Override
    public boolean hasMappingDataToLoad() {
        return true;
    }
    
    @Override
    public BlockItemPackets1_11 getItemRewriter() {
        return this.blockItemPackets;
    }
    
    @Override
    protected void registerPackets() {
        final BlockItemPackets1_11 blockItemPackets = new BlockItemPackets1_11(this);
        this.blockItemPackets = blockItemPackets;
        blockItemPackets.register();
        this.entityPackets.register();
        new PlayerPackets1_11().register(this);
        final SoundRewriter lllllllllllllllIllIlIllIIIIlllll = new SoundRewriter(this);
        lllllllllllllllIllIlIllIIIIlllll.registerNamedSound(ClientboundPackets1_9_3.NAMED_SOUND);
        lllllllllllllllIllIlIllIIIIlllll.registerSound(ClientboundPackets1_9_3.SOUND);
    }
    
    @Override
    public EntityPackets1_11 getEntityRewriter() {
        return this.entityPackets;
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_10To1_11.MAPPINGS;
    }
}
