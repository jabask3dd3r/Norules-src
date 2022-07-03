package com.viaversion.viabackwards.protocol.protocol1_11to1_11_1;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viabackwards.protocol.protocol1_11to1_11_1.packets.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.rewriter.*;

public class Protocol1_11To1_11_1 extends BackwardsProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9_3, ServerboundPackets1_9_3, ServerboundPackets1_9_3>
{
    private final /* synthetic */ ItemRewriter itemRewriter;
    private final /* synthetic */ EntityPackets1_11_1 entityPackets;
    
    public Protocol1_11To1_11_1() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9_3.class);
        this.entityPackets = new EntityPackets1_11_1(this);
        this.itemRewriter = new ItemPackets1_11_1(this);
    }
    
    @Override
    public EntityPackets1_11_1 getEntityRewriter() {
        return this.entityPackets;
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    @Override
    public void init(final UserConnection lllllllllllllllIllIIIlIllIIllIll) {
        if (!lllllllllllllllIllIIIlIllIIllIll.has(ClientWorld.class)) {
            lllllllllllllllIllIIIlIllIIllIll.put(new ClientWorld(lllllllllllllllIllIIIlIllIIllIll));
        }
        lllllllllllllllIllIIIlIllIIllIll.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllllIllIIIlIllIIllIll, Entity1_11Types.EntityType.PLAYER));
    }
    
    @Override
    protected void registerPackets() {
        this.entityPackets.register();
        this.itemRewriter.register();
    }
}
