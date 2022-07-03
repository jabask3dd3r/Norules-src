package com.viaversion.viabackwards.protocol.protocol1_16_1to1_16_2;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.packets.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.rewriter.*;
import java.util.*;
import com.viaversion.viabackwards.protocol.protocol1_16_1to1_16_2.data.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_16_1To1_16_2 extends BackwardsProtocol<ClientboundPackets1_16_2, ClientboundPackets1_16, ServerboundPackets1_16_2, ServerboundPackets1_16>
{
    private final /* synthetic */ EntityRewriter entityRewriter;
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    private /* synthetic */ TranslatableRewriter translatableRewriter;
    private /* synthetic */ BlockItemPackets1_16_2 blockItemPackets;
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    public Protocol1_16_1To1_16_2() {
        super(ClientboundPackets1_16_2.class, ClientboundPackets1_16.class, ServerboundPackets1_16_2.class, ServerboundPackets1_16.class);
        this.entityRewriter = new EntityPackets1_16_2(this);
    }
    
    static {
        MAPPINGS = new BackwardsMappings("1.16.2", "1.16", Protocol1_16_2To1_16_1.class, true);
    }
    
    @Override
    public void init(final UserConnection llllllllllllllllIlIlIIllIlIIlIIl) {
        llllllllllllllllIlIlIIllIlIIlIIl.addEntityTracker(this.getClass(), new EntityTrackerBase(llllllllllllllllIlIlIIllIlIIlIIl, Entity1_16_2Types.PLAYER));
    }
    
    @Override
    public BlockItemPackets1_16_2 getItemRewriter() {
        return this.blockItemPackets;
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_16_1To1_16_2.MAPPINGS;
    }
    
    @Override
    public TranslatableRewriter getTranslatableRewriter() {
        return this.translatableRewriter;
    }
    
    @Override
    protected void registerPackets() {
        final Class<Protocol1_16_2To1_16_1> llllllllllllllllllIIIlIlIllIllIl = Protocol1_16_2To1_16_1.class;
        final BackwardsMappings mappings = Protocol1_16_1To1_16_2.MAPPINGS;
        Objects.requireNonNull(mappings);
        this.executeAsyncAfterLoaded(llllllllllllllllllIIIlIlIllIllIl, mappings::load);
        this.translatableRewriter = new TranslatableRewriter(this);
        this.translatableRewriter.registerBossBar(ClientboundPackets1_16_2.BOSSBAR);
        this.translatableRewriter.registerCombatEvent(ClientboundPackets1_16_2.COMBAT_EVENT);
        this.translatableRewriter.registerDisconnect(ClientboundPackets1_16_2.DISCONNECT);
        this.translatableRewriter.registerTabList(ClientboundPackets1_16_2.TAB_LIST);
        this.translatableRewriter.registerTitle(ClientboundPackets1_16_2.TITLE);
        this.translatableRewriter.registerOpenWindow(ClientboundPackets1_16_2.OPEN_WINDOW);
        this.translatableRewriter.registerPing();
        new CommandRewriter1_16_2(this).registerDeclareCommands(ClientboundPackets1_16_2.DECLARE_COMMANDS);
        final BlockItemPackets1_16_2 blockItemPackets = new BlockItemPackets1_16_2(this, this.translatableRewriter);
        this.blockItemPackets = blockItemPackets;
        blockItemPackets.register();
        this.entityRewriter.register();
        final SoundRewriter llllllllllllllllIlIlIIllIlIIllll = new SoundRewriter(this);
        llllllllllllllllIlIlIIllIlIIllll.registerSound(ClientboundPackets1_16_2.SOUND);
        llllllllllllllllIlIlIIllIlIIllll.registerSound(ClientboundPackets1_16_2.ENTITY_SOUND);
        llllllllllllllllIlIlIIllIlIIllll.registerNamedSound(ClientboundPackets1_16_2.NAMED_SOUND);
        llllllllllllllllIlIlIIllIlIIllll.registerStopSound(ClientboundPackets1_16_2.STOP_SOUND);
        ((AbstractProtocol<ClientboundPackets1_16_2, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_16_2.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                final JsonElement lllllllllllllIlllIlIlIlIIlIlllll;
                final byte lllllllllllllIlllIlIlIlIIlIllllI;
                this.handler(lllllllllllllIlllIlIlIlIIllIIIII -> {
                    lllllllllllllIlllIlIlIlIIlIlllll = lllllllllllllIlllIlIlIlIIllIIIII.passthrough(Type.COMPONENT);
                    Protocol1_16_1To1_16_2.this.translatableRewriter.processText(lllllllllllllIlllIlIlIlIIlIlllll);
                    lllllllllllllIlllIlIlIlIIlIllllI = lllllllllllllIlllIlIlIlIIllIIIII.passthrough((Type<Byte>)Type.BYTE);
                    if (lllllllllllllIlllIlIlIlIIlIllllI == 2) {
                        lllllllllllllIlllIlIlIlIIllIIIII.clearPacket();
                        lllllllllllllIlllIlIlIlIIllIIIII.setId(ClientboundPackets1_16.TITLE.ordinal());
                        lllllllllllllIlllIlIlIlIIllIIIII.write(Type.VAR_INT, 2);
                        lllllllllllllIlllIlIlIlIIllIIIII.write(Type.COMPONENT, lllllllllllllIlllIlIlIlIIlIlllll);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16>)this).registerServerbound(ServerboundPackets1_16.RECIPE_BOOK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    private void sendSeenRecipePacket(final int lllllllllllllIIlIIIIlIIIIIlIIlll, final PacketWrapper lllllllllllllIIlIIIIlIIIIIlIIIIl) throws Exception {
                        final boolean lllllllllllllIIlIIIIlIIIIIlIIlIl = lllllllllllllIIlIIIIlIIIIIlIIIIl.read((Type<Boolean>)Type.BOOLEAN);
                        final boolean lllllllllllllIIlIIIIlIIIIIlIIlII = lllllllllllllIIlIIIIlIIIIIlIIIIl.read((Type<Boolean>)Type.BOOLEAN);
                        final PacketWrapper lllllllllllllIIlIIIIlIIIIIlIIIll = lllllllllllllIIlIIIIlIIIIIlIIIIl.create(ServerboundPackets1_16_2.RECIPE_BOOK_DATA);
                        lllllllllllllIIlIIIIlIIIIIlIIIll.write(Type.VAR_INT, lllllllllllllIIlIIIIlIIIIIlIIlll);
                        lllllllllllllIIlIIIIlIIIIIlIIIll.write(Type.BOOLEAN, lllllllllllllIIlIIIIlIIIIIlIIlIl);
                        lllllllllllllIIlIIIIlIIIIIlIIIll.write(Type.BOOLEAN, lllllllllllllIIlIIIIlIIIIIlIIlII);
                        lllllllllllllIIlIIIIlIIIIIlIIIll.sendToServer(Protocol1_16_1To1_16_2.class);
                    }
                    
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIIIIlIIIIIllIIII) throws Exception {
                        final int lllllllllllllIIlIIIIlIIIIIllIIlI = lllllllllllllIIlIIIIlIIIIIllIIII.read((Type<Integer>)Type.VAR_INT);
                        if (lllllllllllllIIlIIIIlIIIIIllIIlI == 0) {
                            lllllllllllllIIlIIIIlIIIIIllIIII.passthrough(Type.STRING);
                            lllllllllllllIIlIIIIlIIIIIllIIII.setId(ServerboundPackets1_16_2.SEEN_RECIPE.ordinal());
                        }
                        else {
                            lllllllllllllIIlIIIIlIIIIIllIIII.cancel();
                            for (int lllllllllllllIIlIIIIlIIIIIllIlIl = 0; lllllllllllllIIlIIIIlIIIIIllIlIl < 3; ++lllllllllllllIIlIIIIlIIIIIllIlIl) {
                                this.sendSeenRecipePacket(lllllllllllllIIlIIIIlIIIIIllIlIl, lllllllllllllIIlIIIIlIIIIIllIIII);
                            }
                        }
                    }
                });
            }
        });
        new TagRewriter(this).register(ClientboundPackets1_16_2.TAGS, RegistryType.ENTITY);
        new StatisticsRewriter(this).register(ClientboundPackets1_16_2.STATISTICS);
    }
}
