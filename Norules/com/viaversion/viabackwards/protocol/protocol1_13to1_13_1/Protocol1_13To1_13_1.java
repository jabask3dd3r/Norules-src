package com.viaversion.viabackwards.protocol.protocol1_13to1_13_1;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.protocols.protocol1_13_1to1_13.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import java.util.*;
import com.viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_13to1_13_1.data.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_13To1_13_1 extends BackwardsProtocol<ClientboundPackets1_13, ClientboundPackets1_13, ServerboundPackets1_13, ServerboundPackets1_13>
{
    private final /* synthetic */ EntityRewriter entityRewriter;
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    private final /* synthetic */ ItemRewriter itemRewriter;
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    static {
        MAPPINGS = new BackwardsMappings("1.13.2", "1.13", Protocol1_13_1To1_13.class, true);
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIlIIlIlIllIlIllIlIl) {
        lllllllllllllIlIIlIlIllIlIllIlIl.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllIlIIlIlIllIlIllIlIl, Entity1_13Types.EntityType.PLAYER));
        if (!lllllllllllllIlIIlIlIllIlIllIlIl.has(ClientWorld.class)) {
            lllllllllllllIlIIlIlIllIlIllIlIl.put(new ClientWorld(lllllllllllllIlIIlIlIllIlIllIlIl));
        }
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_13To1_13_1.MAPPINGS;
    }
    
    public Protocol1_13To1_13_1() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_13.class, ServerboundPackets1_13.class, ServerboundPackets1_13.class);
        this.entityRewriter = new EntityPackets1_13_1(this);
        this.itemRewriter = new InventoryPackets1_13_1(this);
    }
    
    @Override
    protected void registerPackets() {
        final Class<Protocol1_13_1To1_13> llllllllllllllllllIIIlIlIllIllIl = Protocol1_13_1To1_13.class;
        final BackwardsMappings mappings = Protocol1_13To1_13_1.MAPPINGS;
        Objects.requireNonNull(mappings);
        this.executeAsyncAfterLoaded(llllllllllllllllllIIIlIlIllIllIl, mappings::load);
        this.entityRewriter.register();
        this.itemRewriter.register();
        WorldPackets1_13_1.register(this);
        final TranslatableRewriter lllllllllllllIlIIlIlIllIlIlllIll = new TranslatableRewriter(this);
        lllllllllllllIlIIlIlIllIlIlllIll.registerChatMessage(ClientboundPackets1_13.CHAT_MESSAGE);
        lllllllllllllIlIIlIlIllIlIlllIll.registerCombatEvent(ClientboundPackets1_13.COMBAT_EVENT);
        lllllllllllllIlIIlIlIllIlIlllIll.registerDisconnect(ClientboundPackets1_13.DISCONNECT);
        lllllllllllllIlIIlIlIllIlIlllIll.registerTabList(ClientboundPackets1_13.TAB_LIST);
        lllllllllllllIlIIlIlIllIlIlllIll.registerTitle(ClientboundPackets1_13.TITLE);
        lllllllllllllIlIIlIlIllIlIlllIll.registerPing();
        new CommandRewriter1_13_1(this).registerDeclareCommands(ClientboundPackets1_13.DECLARE_COMMANDS);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.STRING, (ValueTransformer<String, Object>)new ValueTransformer<String, String>(Type.STRING) {
                    @Override
                    public String transform(final PacketWrapper lllllllllllllIlIIIIIllIIlIIlIlll, final String lllllllllllllIlIIIIIllIIlIIlIlIl) {
                        return lllllllllllllIlIIIIIllIIlIIlIlIl.startsWith("/") ? lllllllllllllIlIIIIIllIIlIIlIlIl : String.valueOf(new StringBuilder().append("/").append(lllllllllllllIlIIIIIllIIlIIlIlIl));
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLAT_ITEM);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIllIIIIlllIIll) throws Exception {
                        Protocol1_13To1_13_1.this.itemRewriter.handleItemToServer(llllllllllllllIllIIllIIIIlllIIll.get(Type.FLAT_ITEM, 0));
                        llllllllllllllIllIIllIIIIlllIIll.write(Type.VAR_INT, 0);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_13.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                final ComponentRewriter val$translatableRewriter;
                final JsonElement lllllllllllllIlIlIlIIIIlIllIIIIl;
                final JsonObject lllllllllllllIlIlIlIIIIlIllIIIII;
                this.handler(lllllllllllllIlIlIlIIIIlIllIIIlI -> {
                    val$translatableRewriter = lllllllllllllIlIIlIlIllIlIlllIll;
                    lllllllllllllIlIlIlIIIIlIllIIIIl = lllllllllllllIlIlIlIIIIlIllIIIlI.read(Type.COMPONENT);
                    val$translatableRewriter.processText(lllllllllllllIlIlIlIIIIlIllIIIIl);
                    lllllllllllllIlIlIlIIIIlIllIIIII = new JsonObject();
                    lllllllllllllIlIlIlIIIIlIllIIIII.addProperty("text", ChatRewriter.jsonToLegacyText(lllllllllllllIlIlIlIIIIlIllIIIIl.toString()));
                    lllllllllllllIlIlIlIIIIlIllIIIlI.write(Type.COMPONENT, lllllllllllllIlIlIlIIIIlIllIIIII);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_13.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIlIlllllllllllIII) throws Exception {
                        final int llllllllllllllIIlIllllllllllIlll = llllllllllllllIIlIlllllllllllIII.get((Type<Integer>)Type.VAR_INT, 1);
                        llllllllllllllIIlIlllllllllllIII.set(Type.VAR_INT, 1, llllllllllllllIIlIllllllllllIlll - 1);
                        for (int llllllllllllllIIlIllllllllllIllI = llllllllllllllIIlIlllllllllllIII.get((Type<Integer>)Type.VAR_INT, 3), llllllllllllllIIlIlllllllllllIlI = 0; llllllllllllllIIlIlllllllllllIlI < llllllllllllllIIlIllllllllllIllI; ++llllllllllllllIIlIlllllllllllIlI) {
                            llllllllllllllIIlIlllllllllllIII.passthrough(Type.STRING);
                            final boolean llllllllllllllIIlIlllllllllllIll = llllllllllllllIIlIlllllllllllIII.passthrough((Type<Boolean>)Type.BOOLEAN);
                            if (llllllllllllllIIlIlllllllllllIll) {
                                llllllllllllllIIlIlllllllllllIII.passthrough(Type.STRING);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_13.BOSSBAR, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lIllIIlIIIllIlI) throws Exception {
                        final int lIllIIlIIIlllII = lIllIIlIIIllIlI.get((Type<Integer>)Type.VAR_INT, 0);
                        if (lIllIIlIIIlllII == 0 || lIllIIlIIIlllII == 3) {
                            lllllllllllllIlIIlIlIllIlIlllIll.processText(lIllIIlIIIllIlI.passthrough(Type.COMPONENT));
                            if (lIllIIlIIIlllII == 0) {
                                lIllIIlIIIllIlI.passthrough((Type<Object>)Type.FLOAT);
                                lIllIIlIIIllIlI.passthrough((Type<Object>)Type.VAR_INT);
                                lIllIIlIIIllIlI.passthrough((Type<Object>)Type.VAR_INT);
                                short lIllIIlIIIlllll = lIllIIlIIIllIlI.read((Type<Short>)Type.UNSIGNED_BYTE);
                                if ((lIllIIlIIIlllll & 0x4) != 0x0) {
                                    lIllIIlIIIlllll |= 0x2;
                                }
                                lIllIIlIIIllIlI.write(Type.UNSIGNED_BYTE, lIllIIlIIIlllll);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_13.ADVANCEMENTS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIllIIIIlllllllII) throws Exception {
                        llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Object>)Type.BOOLEAN);
                        for (int llllllllllllllIIIllIIIIllllllllI = llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllIIIllIIIlIIIIIIIIl = 0; llllllllllllllIIIllIIIlIIIIIIIIl < llllllllllllllIIIllIIIIllllllllI; ++llllllllllllllIIIllIIIlIIIIIIIIl) {
                            llllllllllllllIIIllIIIIlllllllII.passthrough(Type.STRING);
                            if (llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIIIllIIIIlllllllII.passthrough(Type.STRING);
                            }
                            if (llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                                llllllllllllllIIIllIIIIlllllllII.passthrough(Type.COMPONENT);
                                llllllllllllllIIIllIIIIlllllllII.passthrough(Type.COMPONENT);
                                final Item llllllllllllllIIIllIIIlIIIIIIlIl = llllllllllllllIIIllIIIIlllllllII.passthrough(Type.FLAT_ITEM);
                                Protocol1_13To1_13_1.this.itemRewriter.handleItemToClient(llllllllllllllIIIllIIIlIIIIIIlIl);
                                llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Object>)Type.VAR_INT);
                                final int llllllllllllllIIIllIIIlIIIIIIlII = llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Integer>)Type.INT);
                                if ((llllllllllllllIIIllIIIlIIIIIIlII & 0x1) != 0x0) {
                                    llllllllllllllIIIllIIIIlllllllII.passthrough(Type.STRING);
                                }
                                llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Object>)Type.FLOAT);
                                llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Object>)Type.FLOAT);
                            }
                            llllllllllllllIIIllIIIIlllllllII.passthrough(Type.STRING_ARRAY);
                            for (int llllllllllllllIIIllIIIlIIIIIIIlI = llllllllllllllIIIllIIIIlllllllII.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllIIIllIIIlIIIIIIIll = 0; llllllllllllllIIIllIIIlIIIIIIIll < llllllllllllllIIIllIIIlIIIIIIIlI; ++llllllllllllllIIIllIIIlIIIIIIIll) {
                                llllllllllllllIIIllIIIIlllllllII.passthrough(Type.STRING_ARRAY);
                            }
                        }
                    }
                });
            }
        });
        new TagRewriter(this).register(ClientboundPackets1_13.TAGS, RegistryType.ITEM);
        new StatisticsRewriter(this).register(ClientboundPackets1_13.STATISTICS);
    }
}
