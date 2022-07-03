package com.viaversion.viabackwards.protocol.protocol1_11_1to1_12;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.data.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_11_1To1_12 extends BackwardsProtocol<ClientboundPackets1_12, ClientboundPackets1_9_3, ServerboundPackets1_12, ServerboundPackets1_9_3>
{
    private final /* synthetic */ BlockItemPackets1_12 blockItemPackets;
    private final /* synthetic */ EntityPackets1_12 entityPackets;
    
    @Override
    public EntityPackets1_12 getEntityRewriter() {
        return this.entityPackets;
    }
    
    @Override
    public BlockItemPackets1_12 getItemRewriter() {
        return this.blockItemPackets;
    }
    
    @Override
    protected void registerPackets() {
        this.blockItemPackets.register();
        this.entityPackets.register();
        new SoundPackets1_12(this).register();
        new ChatPackets1_12(this).register();
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_12.TITLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllllllllllllIllIIlIlIIIlIIlIIl;
                JsonElement llllllllllllllIllIIlIlIIIlIIlIll;
                this.handler(llllllllllllllIllIIlIlIIIlIIlIII -> {
                    llllllllllllllIllIIlIlIIIlIIlIIl = llllllllllllllIllIIlIlIIIlIIlIII.passthrough((Type<Integer>)Type.VAR_INT);
                    if (llllllllllllllIllIIlIlIIIlIIlIIl >= 0 && llllllllllllllIllIIlIlIIIlIIlIIl <= 2) {
                        llllllllllllllIllIIlIlIIIlIIlIll = llllllllllllllIllIIlIlIIIlIIlIII.read(Type.COMPONENT);
                        llllllllllllllIllIIlIlIIIlIIlIII.write(Type.COMPONENT, Protocol1_9To1_8.fixJson(llllllllllllllIllIIlIlIIIlIIlIll.toString()));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_12.ADVANCEMENTS);
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_12.UNLOCK_RECIPES);
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_12.SELECT_ADVANCEMENTS_TAB);
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIIIIIIllllIllIlIIIl) {
        if (!lllllllllllllIIIIIIllllIllIlIIIl.has(ClientWorld.class)) {
            lllllllllllllIIIIIIllllIllIlIIIl.put(new ClientWorld(lllllllllllllIIIIIIllllIllIlIIIl));
        }
        lllllllllllllIIIIIIllllIllIlIIIl.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllIIIIIIllllIllIlIIIl, Entity1_12Types.EntityType.PLAYER, true));
        lllllllllllllIIIIIIllllIllIlIIIl.put(new ShoulderTracker(lllllllllllllIIIIIIllllIllIlIIIl));
    }
    
    public Protocol1_11_1To1_12() {
        super(ClientboundPackets1_12.class, ClientboundPackets1_9_3.class, ServerboundPackets1_12.class, ServerboundPackets1_9_3.class);
        this.entityPackets = new EntityPackets1_12(this);
        this.blockItemPackets = new BlockItemPackets1_12(this);
    }
}
