package com.viaversion.viabackwards.protocol.protocol1_15_2to1_16;

import com.viaversion.viabackwards.api.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.chat.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viabackwards.api.rewriters.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.storage.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.packets.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.data.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.api.protocol.*;

public class Protocol1_15_2To1_16 extends BackwardsProtocol<ClientboundPackets1_16, ClientboundPackets1_15, ServerboundPackets1_16, ServerboundPackets1_14>
{
    private /* synthetic */ BlockItemPackets1_16 blockItemPackets;
    private /* synthetic */ TranslatableRewriter translatableRewriter;
    private final /* synthetic */ EntityRewriter entityRewriter;
    public static final /* synthetic */ BackwardsMappings MAPPINGS;
    
    @Override
    public BlockItemPackets1_16 getItemRewriter() {
        return this.blockItemPackets;
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    @Override
    public TranslatableRewriter getTranslatableRewriter() {
        return this.translatableRewriter;
    }
    
    @Override
    protected void registerPackets() {
        final Class<Protocol1_16To1_15_2> llllllllllllllllllIIIlIlIllIllIl = Protocol1_16To1_15_2.class;
        final BackwardsMappings mappings = Protocol1_15_2To1_16.MAPPINGS;
        Objects.requireNonNull(mappings);
        this.executeAsyncAfterLoaded(llllllllllllllllllIIIlIlIllIllIl, mappings::load);
        this.translatableRewriter = new TranslatableRewriter1_16(this);
        this.translatableRewriter.registerBossBar(ClientboundPackets1_16.BOSSBAR);
        this.translatableRewriter.registerCombatEvent(ClientboundPackets1_16.COMBAT_EVENT);
        this.translatableRewriter.registerDisconnect(ClientboundPackets1_16.DISCONNECT);
        this.translatableRewriter.registerTabList(ClientboundPackets1_16.TAB_LIST);
        this.translatableRewriter.registerTitle(ClientboundPackets1_16.TITLE);
        this.translatableRewriter.registerPing();
        new CommandRewriter1_16(this).registerDeclareCommands(ClientboundPackets1_16.DECLARE_COMMANDS);
        final BlockItemPackets1_16 blockItemPackets = new BlockItemPackets1_16(this, this.translatableRewriter);
        this.blockItemPackets = blockItemPackets;
        blockItemPackets.register();
        this.entityRewriter.register();
        this.registerClientbound(State.STATUS, 0, 0, new PacketRemapper() {
            @Override
            public void registerMap() {
                final String lllllllllllllIllllIlIIlIlIIlIlII;
                final JsonObject lllllllllllllIllllIlIIlIlIIlIIll;
                final JsonElement lllllllllllllIllllIlIIlIlIIlIIlI;
                this.handler(lllllllllllllIllllIlIIlIlIIlIIII -> {
                    lllllllllllllIllllIlIIlIlIIlIlII = lllllllllllllIllllIlIIlIlIIlIIII.passthrough(Type.STRING);
                    lllllllllllllIllllIlIIlIlIIlIIll = GsonUtil.getGson().fromJson(lllllllllllllIllllIlIIlIlIIlIlII, JsonObject.class);
                    lllllllllllllIllllIlIIlIlIIlIIlI = lllllllllllllIllllIlIIlIlIIlIIll.get("description");
                    if (lllllllllllllIllllIlIIlIlIIlIIlI != null) {
                        Protocol1_15_2To1_16.this.translatableRewriter.processText(lllllllllllllIllllIlIIlIlIIlIIlI);
                        lllllllllllllIllllIlIIlIlIIlIIII.set(Type.STRING, 0, lllllllllllllIllllIlIIlIlIIlIIll.toString());
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_16.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIIlIIlllIIIlIIlIIl -> Protocol1_15_2To1_16.this.translatableRewriter.processText(lllllllllllllIIIlIIlllIIIlIIlIIl.passthrough(Type.COMPONENT)));
                this.map(Type.BYTE);
                this.map(Type.UUID, Type.NOTHING);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_16.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllIlIIIIllIIllIlIIlll -> Protocol1_15_2To1_16.this.translatableRewriter.processText(lllllllllllllIlIIIIllIIllIlIIlll.passthrough(Type.COMPONENT)));
                int lllllllllllllIlIIIIllIIllIlIllIl;
                this.handler(lllllllllllllIlIIIIllIIllIlIllII -> {
                    lllllllllllllIlIIIIllIIllIlIllIl = lllllllllllllIlIIIIllIIllIlIllII.get((Type<Integer>)Type.VAR_INT, 1);
                    if (lllllllllllllIlIIIIllIIllIlIllIl == 20) {
                        lllllllllllllIlIIIIllIIllIlIllII.set(Type.VAR_INT, 1, 7);
                    }
                    else if (lllllllllllllIlIIIIllIIllIlIllIl > 20) {
                        lllllllllllllIlIIIIllIIllIlIllII.set(Type.VAR_INT, 1, --lllllllllllllIlIIIIllIIllIlIllIl);
                    }
                });
            }
        });
        final SoundRewriter llllllllllllllIIlIllIllIIIIIIIII = new SoundRewriter(this);
        llllllllllllllIIlIllIllIIIIIIIII.registerSound(ClientboundPackets1_16.SOUND);
        llllllllllllllIIlIllIllIIIIIIIII.registerSound(ClientboundPackets1_16.ENTITY_SOUND);
        llllllllllllllIIlIllIllIIIIIIIII.registerNamedSound(ClientboundPackets1_16.NAMED_SOUND);
        llllllllllllllIIlIllIllIIIIIIIII.registerStopSound(ClientboundPackets1_16.STOP_SOUND);
        this.registerClientbound(State.LOGIN, 2, 2, new PacketRemapper() {
            @Override
            public void registerMap() {
                final UUID llllllllllllllIIIIllIllIIlllIIIl;
                this.handler(llllllllllllllIIIIllIllIIlllIIII -> {
                    llllllllllllllIIIIllIllIIlllIIIl = llllllllllllllIIIIllIllIIlllIIII.read(Type.UUID_INT_ARRAY);
                    llllllllllllllIIIIllIllIIlllIIII.write(Type.STRING, llllllllllllllIIIIllIllIIlllIIIl.toString());
                });
            }
        });
        new TagRewriter(this).register(ClientboundPackets1_16.TAGS, RegistryType.ENTITY);
        new StatisticsRewriter(this).register(ClientboundPackets1_16.STATISTICS);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this).registerServerbound(ServerboundPackets1_14.ENTITY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllllIllllIIllIlllIIII;
                this.handler(lllllllllllllllIllllIIllIlllIIIl -> {
                    lllllllllllllllIllllIIllIlllIIIl.passthrough((Type<Object>)Type.VAR_INT);
                    lllllllllllllllIllllIIllIlllIIII = lllllllllllllllIllllIIllIlllIIIl.passthrough((Type<Integer>)Type.VAR_INT);
                    if (lllllllllllllllIllllIIllIlllIIII == 0) {
                        lllllllllllllllIllllIIllIlllIIIl.user().get(PlayerSneakStorage.class).setSneaking(true);
                    }
                    else if (lllllllllllllllIllllIIllIlllIIII == 1) {
                        lllllllllllllllIllllIIllIlllIIIl.user().get(PlayerSneakStorage.class).setSneaking(false);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this).registerServerbound(ServerboundPackets1_14.INTERACT_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int llllIIIlllIIIl;
                this.handler(llllIIIlllIIlI -> {
                    llllIIIlllIIlI.passthrough((Type<Object>)Type.VAR_INT);
                    llllIIIlllIIIl = llllIIIlllIIlI.passthrough((Type<Integer>)Type.VAR_INT);
                    if (llllIIIlllIIIl == 0 || llllIIIlllIIIl == 2) {
                        if (llllIIIlllIIIl == 2) {
                            llllIIIlllIIlI.passthrough((Type<Object>)Type.FLOAT);
                            llllIIIlllIIlI.passthrough((Type<Object>)Type.FLOAT);
                            llllIIIlllIIlI.passthrough((Type<Object>)Type.FLOAT);
                        }
                        llllIIIlllIIlI.passthrough((Type<Object>)Type.VAR_INT);
                    }
                    llllIIIlllIIlI.write(Type.BOOLEAN, llllIIIlllIIlI.user().get(PlayerSneakStorage.class).isSneaking());
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this).registerServerbound(ServerboundPackets1_14.PLAYER_ABILITIES, new PacketRemapper() {
            @Override
            public void registerMap() {
                final byte llllllllllllllllIIIlIlllllIlIllI;
                final byte llllllllllllllllIIIlIlllllIlIllI2;
                this.handler(llllllllllllllllIIIlIlllllIlIlll -> {
                    llllllllllllllllIIIlIlllllIlIllI = llllllllllllllllIIIlIlllllIlIlll.read((Type<Byte>)Type.BYTE);
                    llllllllllllllllIIIlIlllllIlIllI2 = (byte)(llllllllllllllllIIIlIlllllIlIllI & 0x2);
                    llllllllllllllllIIIlIlllllIlIlll.write(Type.BYTE, llllllllllllllllIIIlIlllllIlIllI2);
                    llllllllllllllllIIIlIlllllIlIlll.read((Type<Object>)Type.FLOAT);
                    llllllllllllllllIIIlIlllllIlIlll.read((Type<Object>)Type.FLOAT);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this).cancelServerbound(ServerboundPackets1_14.UPDATE_JIGSAW_BLOCK);
    }
    
    static {
        MAPPINGS = new BackwardsMappings();
    }
    
    public Protocol1_15_2To1_16() {
        super(ClientboundPackets1_16.class, ClientboundPackets1_15.class, ServerboundPackets1_16.class, ServerboundPackets1_14.class);
        this.entityRewriter = new EntityPackets1_16(this);
    }
    
    @Override
    public BackwardsMappings getMappingData() {
        return Protocol1_15_2To1_16.MAPPINGS;
    }
    
    @Override
    public void init(final UserConnection llllllllllllllIIlIllIlIllllllIlI) {
        if (!llllllllllllllIIlIllIlIllllllIlI.has(ClientWorld.class)) {
            llllllllllllllIIlIllIlIllllllIlI.put(new ClientWorld(llllllllllllllIIlIllIlIllllllIlI));
        }
        llllllllllllllIIlIllIlIllllllIlI.put(new PlayerSneakStorage());
        llllllllllllllIIlIllIlIllllllIlI.put(new WorldNameTracker());
        llllllllllllllIIlIllIlIllllllIlI.addEntityTracker(this.getClass(), new EntityTrackerBase(llllllllllllllIIlIllIlIllllllIlI, Entity1_16Types.PLAYER));
    }
}
