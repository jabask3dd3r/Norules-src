package com.viaversion.viabackwards.protocol.protocol1_9_4to1_10;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viabackwards.protocol.protocol1_9_4to1_10.packets.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_9_4To1_10 extends BackwardsProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9_3, ServerboundPackets1_9_3, ServerboundPackets1_9_3>
{
    private final /* synthetic */ EntityPackets1_10 entityPackets;
    private static final /* synthetic */ ValueTransformer<Float, Short> TO_OLD_PITCH;
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    private final /* synthetic */ BlockItemPackets1_10 blockItemPackets;
    
    static {
        MAPPINGS = new BackwardsMappings("1.10", "1.9.4", null, true);
        TO_OLD_PITCH = new ValueTransformer<Float, Short>() {
            @Override
            public Short transform(final PacketWrapper llllllllllllllllIIlIlIIIllIIIIIl, final Float llllllllllllllllIIlIlIIIllIIIIII) throws Exception {
                return (short)Math.round(llllllllllllllllIIlIlIIIllIIIIII * 63.5f);
            }
        };
    }
    
    public Protocol1_9_4To1_10() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9_3.class);
        this.entityPackets = new EntityPackets1_10(this);
        this.blockItemPackets = new BlockItemPackets1_10(this);
    }
    
    @Override
    public void init(final UserConnection llllllllllllllIlIlIIlllIllllIIlI) {
        if (!llllllllllllllIlIlIIlllIllllIIlI.has(ClientWorld.class)) {
            llllllllllllllIlIlIIlllIllllIIlI.put(new ClientWorld(llllllllllllllIlIlIIlllIllllIIlI));
        }
        llllllllllllllIlIlIIlllIllllIIlI.addEntityTracker(this.getClass(), new EntityTrackerBase(llllllllllllllIlIlIIlllIllllIIlI, Entity1_10Types.EntityType.PLAYER));
    }
    
    @Override
    public BlockItemPackets1_10 getItemRewriter() {
        return this.blockItemPackets;
    }
    
    @Override
    public EntityPackets1_10 getEntityRewriter() {
        return this.entityPackets;
    }
    
    @Override
    protected void registerPackets() {
        this.entityPackets.register();
        this.blockItemPackets.register();
        final SoundRewriter llllllllllllllIlIlIIlllIlllllIII = new SoundRewriter(this);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.NAMED_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.FLOAT);
                this.map((Type<Object>)Type.FLOAT, (ValueTransformer<Object, Object>)Protocol1_9_4To1_10.TO_OLD_PITCH);
                this.handler(llllllllllllllIlIlIIlllIlllllIII.getNamedSoundHandler());
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.FLOAT);
                this.map((Type<Object>)Type.FLOAT, (ValueTransformer<Object, Object>)Protocol1_9_4To1_10.TO_OLD_PITCH);
                this.handler(llllllllllllllIlIlIIlllIlllllIII.getSoundHandler());
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9_3>)this).registerServerbound(ServerboundPackets1_9_3.RESOURCE_PACK_STATUS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING, Type.NOTHING);
                this.map(Type.VAR_INT);
            }
        });
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_9_4To1_10.MAPPINGS;
    }
    
    @Override
    public boolean hasMappingDataToLoad() {
        return true;
    }
}
