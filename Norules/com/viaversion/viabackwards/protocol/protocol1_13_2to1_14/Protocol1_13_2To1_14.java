package com.viaversion.viabackwards.protocol.protocol1_13_2to1_14;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import java.util.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.data.*;
import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.storage.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_13_2To1_14 extends BackwardsProtocol<ClientboundPackets1_14, ClientboundPackets1_13, ServerboundPackets1_14, ServerboundPackets1_13>
{
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    private /* synthetic */ BlockItemPackets1_14 blockItemPackets;
    private final /* synthetic */ EntityRewriter entityRewriter;
    
    public Protocol1_13_2To1_14() {
        super(ClientboundPackets1_14.class, ClientboundPackets1_13.class, ServerboundPackets1_14.class, ServerboundPackets1_13.class);
        this.entityRewriter = new EntityPackets1_14(this);
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_13_2To1_14.MAPPINGS;
    }
    
    @Override
    protected void registerPackets() {
        final Class<Protocol1_14To1_13_2> llllllllllllllllllIIIlIlIllIllIl = Protocol1_14To1_13_2.class;
        final BackwardsMappings mappings = Protocol1_13_2To1_14.MAPPINGS;
        Objects.requireNonNull(mappings);
        this.executeAsyncAfterLoaded(llllllllllllllllllIIIlIlIllIllIl, mappings::load);
        final TranslatableRewriter lllllllllllllIlIlIIlIlIlIIIlllII = new TranslatableRewriter(this);
        lllllllllllllIlIlIIlIlIlIIIlllII.registerBossBar(ClientboundPackets1_14.BOSSBAR);
        lllllllllllllIlIlIIlIlIlIIIlllII.registerChatMessage(ClientboundPackets1_14.CHAT_MESSAGE);
        lllllllllllllIlIlIIlIlIlIIIlllII.registerCombatEvent(ClientboundPackets1_14.COMBAT_EVENT);
        lllllllllllllIlIlIIlIlIlIIIlllII.registerDisconnect(ClientboundPackets1_14.DISCONNECT);
        lllllllllllllIlIlIIlIlIlIIIlllII.registerTabList(ClientboundPackets1_14.TAB_LIST);
        lllllllllllllIlIlIIlIlIlIIIlllII.registerTitle(ClientboundPackets1_14.TITLE);
        lllllllllllllIlIlIIlIlIlIIIlllII.registerPing();
        new CommandRewriter1_14(this).registerDeclareCommands(ClientboundPackets1_14.DECLARE_COMMANDS);
        this.blockItemPackets = new BlockItemPackets1_14(this, lllllllllllllIlIlIIlIlIlIIIlllII);
        this.blockItemPackets.register();
        this.entityRewriter.register();
        new PlayerPackets1_14(this).register();
        new SoundPackets1_14(this).register();
        new StatisticsRewriter(this).register(ClientboundPackets1_14.STATISTICS);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_14.UPDATE_VIEW_POSITION);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_14.UPDATE_VIEW_DISTANCE);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this).cancelClientbound(ClientboundPackets1_14.ACKNOWLEDGE_PLAYER_DIGGING);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_14.TAGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlllllIIlllIlIIlII) throws Exception {
                        for (int lllllllllllllIIlllllIIlllIlIIIll = lllllllllllllIIlllllIIlllIlIIlII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIlllllIIlllIlIllIl = 0; lllllllllllllIIlllllIIlllIlIllIl < lllllllllllllIIlllllIIlllIlIIIll; ++lllllllllllllIIlllllIIlllIlIllIl) {
                            lllllllllllllIIlllllIIlllIlIIlII.passthrough(Type.STRING);
                            final int[] lllllllllllllIIlllllIIlllIlIlllI = lllllllllllllIIlllllIIlllIlIIlII.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                            for (int lllllllllllllIIlllllIIlllIlIllll = 0; lllllllllllllIIlllllIIlllIlIllll < lllllllllllllIIlllllIIlllIlIlllI.length; ++lllllllllllllIIlllllIIlllIlIllll) {
                                final int lllllllllllllIIlllllIIlllIllIIIl = lllllllllllllIIlllllIIlllIlIlllI[lllllllllllllIIlllllIIlllIlIllll];
                                final int lllllllllllllIIlllllIIlllIllIIII = Protocol1_13_2To1_14.this.getMappingData().getNewBlockId(lllllllllllllIIlllllIIlllIllIIIl);
                                lllllllllllllIIlllllIIlllIlIlllI[lllllllllllllIIlllllIIlllIlIllll] = lllllllllllllIIlllllIIlllIllIIII;
                            }
                        }
                        for (int lllllllllllllIIlllllIIlllIlIIIlI = lllllllllllllIIlllllIIlllIlIIlII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIlllllIIlllIlIlIII = 0; lllllllllllllIIlllllIIlllIlIlIII < lllllllllllllIIlllllIIlllIlIIIlI; ++lllllllllllllIIlllllIIlllIlIlIII) {
                            lllllllllllllIIlllllIIlllIlIIlII.passthrough(Type.STRING);
                            final int[] lllllllllllllIIlllllIIlllIlIlIIl = lllllllllllllIIlllllIIlllIlIIlII.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                            for (int lllllllllllllIIlllllIIlllIlIlIlI = 0; lllllllllllllIIlllllIIlllIlIlIlI < lllllllllllllIIlllllIIlllIlIlIIl.length; ++lllllllllllllIIlllllIIlllIlIlIlI) {
                                final int lllllllllllllIIlllllIIlllIlIllII = lllllllllllllIIlllllIIlllIlIlIIl[lllllllllllllIIlllllIIlllIlIlIlI];
                                final int lllllllllllllIIlllllIIlllIlIlIll = Protocol1_13_2To1_14.this.getMappingData().getItemMappings().get(lllllllllllllIIlllllIIlllIlIllII);
                                lllllllllllllIIlllllIIlllIlIlIIl[lllllllllllllIIlllllIIlllIlIlIlI] = lllllllllllllIIlllllIIlllIlIlIll;
                            }
                        }
                        for (int lllllllllllllIIlllllIIlllIlIIIIl = lllllllllllllIIlllllIIlllIlIIlII.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIIlllllIIlllIlIIlll = 0; lllllllllllllIIlllllIIlllIlIIlll < lllllllllllllIIlllllIIlllIlIIIIl; ++lllllllllllllIIlllllIIlllIlIIlll) {
                            lllllllllllllIIlllllIIlllIlIIlII.passthrough(Type.STRING);
                            lllllllllllllIIlllllIIlllIlIIlII.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                        }
                        for (int lllllllllllllIIlllllIIlllIlIIIII = lllllllllllllIIlllllIIlllIlIIlII.read((Type<Integer>)Type.VAR_INT), lllllllllllllIIlllllIIlllIlIIllI = 0; lllllllllllllIIlllllIIlllIlIIllI < lllllllllllllIIlllllIIlllIlIIIII; ++lllllllllllllIIlllllIIlllIlIIllI) {
                            lllllllllllllIIlllllIIlllIlIIlII.read(Type.STRING);
                            lllllllllllllIIlllllIIlllIlIIlII.read(Type.VAR_INT_ARRAY_PRIMITIVE);
                        }
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_14, ClientboundPackets1_13, S1, S2>)this).registerClientbound(ClientboundPackets1_14.UPDATE_LIGHT, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIIlIlIIllIIIIIIl) throws Exception {
                        final int lllllllllllllIlIIIlIlIIllIIIIIII = lllllllllllllIlIIIlIlIIllIIIIIIl.read((Type<Integer>)Type.VAR_INT);
                        final int lllllllllllllIlIIIlIlIIlIlllllll = lllllllllllllIlIIIlIlIIllIIIIIIl.read((Type<Integer>)Type.VAR_INT);
                        final int lllllllllllllIlIIIlIlIIlIllllllI = lllllllllllllIlIIIlIlIIllIIIIIIl.read((Type<Integer>)Type.VAR_INT);
                        final int lllllllllllllIlIIIlIlIIlIlllllIl = lllllllllllllIlIIIlIlIIllIIIIIIl.read((Type<Integer>)Type.VAR_INT);
                        final int lllllllllllllIlIIIlIlIIlIlllllII = lllllllllllllIlIIIlIlIIllIIIIIIl.read((Type<Integer>)Type.VAR_INT);
                        final int lllllllllllllIlIIIlIlIIlIllllIll = lllllllllllllIlIIIlIlIIllIIIIIIl.read((Type<Integer>)Type.VAR_INT);
                        final byte[][] lllllllllllllIlIIIlIlIIlIllllIlI = new byte[16][];
                        if (this.isSet(lllllllllllllIlIIIlIlIIlIllllllI, 0)) {
                            lllllllllllllIlIIIlIlIIllIIIIIIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                        }
                        for (int lllllllllllllIlIIIlIlIIllIIIIlII = 0; lllllllllllllIlIIIlIlIIllIIIIlII < 16; ++lllllllllllllIlIIIlIlIIllIIIIlII) {
                            if (this.isSet(lllllllllllllIlIIIlIlIIlIllllllI, lllllllllllllIlIIIlIlIIllIIIIlII + 1)) {
                                lllllllllllllIlIIIlIlIIlIllllIlI[lllllllllllllIlIIIlIlIIllIIIIlII] = lllllllllllllIlIIIlIlIIllIIIIIIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                            }
                            else if (this.isSet(lllllllllllllIlIIIlIlIIlIlllllII, lllllllllllllIlIIIlIlIIllIIIIlII + 1)) {
                                lllllllllllllIlIIIlIlIIlIllllIlI[lllllllllllllIlIIIlIlIIllIIIIlII] = ChunkLightStorage.EMPTY_LIGHT;
                            }
                        }
                        if (this.isSet(lllllllllllllIlIIIlIlIIlIllllllI, 17)) {
                            lllllllllllllIlIIIlIlIIllIIIIIIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                        }
                        final byte[][] lllllllllllllIlIIIlIlIIlIllllIIl = new byte[16][];
                        if (this.isSet(lllllllllllllIlIIIlIlIIlIlllllIl, 0)) {
                            lllllllllllllIlIIIlIlIIllIIIIIIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                        }
                        for (int lllllllllllllIlIIIlIlIIllIIIIIll = 0; lllllllllllllIlIIIlIlIIllIIIIIll < 16; ++lllllllllllllIlIIIlIlIIllIIIIIll) {
                            if (this.isSet(lllllllllllllIlIIIlIlIIlIlllllIl, lllllllllllllIlIIIlIlIIllIIIIIll + 1)) {
                                lllllllllllllIlIIIlIlIIlIllllIIl[lllllllllllllIlIIIlIlIIllIIIIIll] = lllllllllllllIlIIIlIlIIllIIIIIIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                            }
                            else if (this.isSet(lllllllllllllIlIIIlIlIIlIllllIll, lllllllllllllIlIIIlIlIIllIIIIIll + 1)) {
                                lllllllllllllIlIIIlIlIIlIllllIIl[lllllllllllllIlIIIlIlIIllIIIIIll] = ChunkLightStorage.EMPTY_LIGHT;
                            }
                        }
                        if (this.isSet(lllllllllllllIlIIIlIlIIlIlllllIl, 17)) {
                            lllllllllllllIlIIIlIlIIllIIIIIIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                        }
                        lllllllllllllIlIIIlIlIIllIIIIIIl.user().get(ChunkLightStorage.class).setStoredLight(lllllllllllllIlIIIlIlIIlIllllIlI, lllllllllllllIlIIIlIlIIlIllllIIl, lllllllllllllIlIIIlIlIIllIIIIIII, lllllllllllllIlIIIlIlIIlIlllllll);
                        lllllllllllllIlIIIlIlIIllIIIIIIl.cancel();
                    }
                    
                    private boolean isSet(final int lllllllllllllIlIIIlIlIIlIllIlIlI, final int lllllllllllllIlIIIlIlIIlIllIIlll) {
                        return (lllllllllllllIlIIIlIlIIlIllIlIlI & 1 << lllllllllllllIlIIIlIlIIlIllIIlll) != 0x0;
                    }
                });
            }
        });
    }
    
    static {
        MAPPINGS = new BackwardsMappings("1.14", "1.13.2", Protocol1_14To1_13_2.class, true);
    }
    
    @Override
    public BlockItemPackets1_14 getItemRewriter() {
        return this.blockItemPackets;
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIlIlIIlIlIlIIIlIlII) {
        if (!lllllllllllllIlIlIIlIlIlIIIlIlII.has(ClientWorld.class)) {
            lllllllllllllIlIlIIlIlIlIIIlIlII.put(new ClientWorld(lllllllllllllIlIlIIlIlIlIIIlIlII));
        }
        lllllllllllllIlIlIIlIlIlIIIlIlII.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllIlIlIIlIlIlIIIlIlII, Entity1_14Types.PLAYER, true));
        if (!lllllllllllllIlIlIIlIlIlIIIlIlII.has(ChunkLightStorage.class)) {
            lllllllllllllIlIlIIlIlIlIIIlIlII.put(new ChunkLightStorage(lllllllllllllIlIlIIlIlIlIIIlIlII));
        }
    }
}
