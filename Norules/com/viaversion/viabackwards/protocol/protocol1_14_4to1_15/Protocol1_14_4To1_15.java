package com.viaversion.viabackwards.protocol.protocol1_14_4to1_15;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import java.util.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_14_4to1_15.data.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_14_4To1_15 extends BackwardsProtocol<ClientboundPackets1_15, ClientboundPackets1_14, ServerboundPackets1_14, ServerboundPackets1_14>
{
    private /* synthetic */ BlockItemPackets1_15 blockItemPackets;
    private final /* synthetic */ EntityRewriter entityRewriter;
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    
    @Override
    protected void registerPackets() {
        final Class<Protocol1_15To1_14_4> llllllllllllllllllIIIlIlIllIllIl = Protocol1_15To1_14_4.class;
        final BackwardsMappings mappings = Protocol1_14_4To1_15.MAPPINGS;
        Objects.requireNonNull(mappings);
        this.executeAsyncAfterLoaded(llllllllllllllllllIIIlIlIllIllIl, mappings::load);
        final TranslatableRewriter lllllllllllllIIlllIlllIllIIlIllI = new TranslatableRewriter(this);
        lllllllllllllIIlllIlllIllIIlIllI.registerBossBar(ClientboundPackets1_15.BOSSBAR);
        lllllllllllllIIlllIlllIllIIlIllI.registerChatMessage(ClientboundPackets1_15.CHAT_MESSAGE);
        lllllllllllllIIlllIlllIllIIlIllI.registerCombatEvent(ClientboundPackets1_15.COMBAT_EVENT);
        lllllllllllllIIlllIlllIllIIlIllI.registerDisconnect(ClientboundPackets1_15.DISCONNECT);
        lllllllllllllIIlllIlllIllIIlIllI.registerOpenWindow(ClientboundPackets1_15.OPEN_WINDOW);
        lllllllllllllIIlllIlllIllIIlIllI.registerTabList(ClientboundPackets1_15.TAB_LIST);
        lllllllllllllIIlllIlllIllIIlIllI.registerTitle(ClientboundPackets1_15.TITLE);
        lllllllllllllIIlllIlllIllIIlIllI.registerPing();
        final BlockItemPackets1_15 blockItemPackets = new BlockItemPackets1_15(this, lllllllllllllIIlllIlllIllIIlIllI);
        this.blockItemPackets = blockItemPackets;
        blockItemPackets.register();
        this.entityRewriter.register();
        final SoundRewriter lllllllllllllIIlllIlllIllIIlIlIl = new SoundRewriter(this);
        lllllllllllllIIlllIlllIllIIlIlIl.registerSound(ClientboundPackets1_15.SOUND);
        lllllllllllllIIlllIlllIllIIlIlIl.registerSound(ClientboundPackets1_15.ENTITY_SOUND);
        lllllllllllllIIlllIlllIllIIlIlIl.registerNamedSound(ClientboundPackets1_15.NAMED_SOUND);
        lllllllllllllIIlllIlllIllIIlIlIl.registerStopSound(ClientboundPackets1_15.STOP_SOUND);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_15.EXPLOSION, new PacketRemapper() {
            private int toEffectCoordinate(final float lllllllllllllllIlIIIllllIlIIlIII) {
                return (int)(lllllllllllllllIlIIIllllIlIIlIII * 8.0f);
            }
            
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                final PacketWrapper lllllllllllllllIlIIIllllIlIIIIIl;
                this.handler(lllllllllllllllIlIIIllllIIllllll -> {
                    lllllllllllllllIlIIIllllIlIIIIIl = lllllllllllllllIlIIIllllIIllllll.create(ClientboundPackets1_14.SOUND);
                    lllllllllllllllIlIIIllllIlIIIIIl.write(Type.VAR_INT, 243);
                    lllllllllllllllIlIIIllllIlIIIIIl.write(Type.VAR_INT, 4);
                    lllllllllllllllIlIIIllllIlIIIIIl.write(Type.INT, this.toEffectCoordinate(lllllllllllllllIlIIIllllIIllllll.get((Type<Float>)Type.FLOAT, 0)));
                    lllllllllllllllIlIIIllllIlIIIIIl.write(Type.INT, this.toEffectCoordinate(lllllllllllllllIlIIIllllIIllllll.get((Type<Float>)Type.FLOAT, 1)));
                    lllllllllllllllIlIIIllllIlIIIIIl.write(Type.INT, this.toEffectCoordinate(lllllllllllllllIlIIIllllIIllllll.get((Type<Float>)Type.FLOAT, 2)));
                    lllllllllllllllIlIIIllllIlIIIIIl.write(Type.FLOAT, 4.0f);
                    lllllllllllllllIlIIIllllIlIIIIIl.write(Type.FLOAT, 1.0f);
                    lllllllllllllllIlIIIllllIlIIIIIl.send(Protocol1_14_4To1_15.class);
                });
            }
        });
        new TagRewriter(this).register(ClientboundPackets1_15.TAGS, RegistryType.ENTITY);
        new StatisticsRewriter(this).register(ClientboundPackets1_15.STATISTICS);
    }
    
    static {
        MAPPINGS = new BackwardsMappings("1.15", "1.14", Protocol1_15To1_14_4.class, true);
    }
    
    @Override
    public BlockItemPackets1_15 getItemRewriter() {
        return this.blockItemPackets;
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_14_4To1_15.MAPPINGS;
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIIlllIlllIllIIIllII) {
        lllllllllllllIIlllIlllIllIIIllII.put(new ImmediateRespawn());
        lllllllllllllIIlllIlllIllIIIllII.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllIIlllIlllIllIIIllII, Entity1_15Types.PLAYER));
    }
    
    public Protocol1_14_4To1_15() {
        super(ClientboundPackets1_15.class, ClientboundPackets1_14.class, ServerboundPackets1_14.class, ServerboundPackets1_14.class);
        this.entityRewriter = new EntityPackets1_15(this);
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
}
