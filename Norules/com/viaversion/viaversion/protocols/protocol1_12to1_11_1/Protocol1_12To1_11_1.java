package com.viaversion.viaversion.protocols.protocol1_12to1_11_1;

import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.packets.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.platform.providers.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.providers.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.rewriter.*;

public class Protocol1_12To1_11_1 extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_12, ServerboundPackets1_9_3, ServerboundPackets1_12>
{
    private final /* synthetic */ ItemRewriter itemRewriter;
    private final /* synthetic */ EntityRewriter metadataRewriter;
    
    public Protocol1_12To1_11_1() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_12.class, ServerboundPackets1_9_3.class, ServerboundPackets1_12.class);
        this.metadataRewriter = new MetadataRewriter1_12To1_11_1(this);
        this.itemRewriter = new InventoryPackets(this);
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    @Override
    public void init(final UserConnection llllllllllllllllIllllIlIlIlIllII) {
        llllllllllllllllIllllIlIlIlIllII.addEntityTracker(this.getClass(), new EntityTrackerBase(llllllllllllllllIllllIlIlIlIllII, Entity1_12Types.EntityType.PLAYER));
        if (!llllllllllllllllIllllIlIlIlIllII.has(ClientWorld.class)) {
            llllllllllllllllIllllIlIlIlIllII.put(new ClientWorld(llllllllllllllllIllllIlIlIlIllII));
        }
    }
    
    @Override
    public void register(final ViaProviders llllllllllllllllIllllIlIlIllIIIl) {
        llllllllllllllllIllllIlIlIllIIIl.register(InventoryQuickMoveProvider.class, new InventoryQuickMoveProvider());
    }
    
    private int getNewSoundId(final int llllllllllllllllIllllIlIlIllIlll) {
        int llllllllllllllllIllllIlIlIllIllI = llllllllllllllllIllllIlIlIllIlll;
        if (llllllllllllllllIllllIlIlIllIlll >= 26) {
            llllllllllllllllIllllIlIlIllIllI += 2;
        }
        if (llllllllllllllllIllllIlIlIllIlll >= 70) {
            llllllllllllllllIllllIlIlIllIllI += 4;
        }
        if (llllllllllllllllIllllIlIlIllIlll >= 74) {
            ++llllllllllllllllIllllIlIlIllIllI;
        }
        if (llllllllllllllllIllllIlIlIllIlll >= 143) {
            llllllllllllllllIllllIlIlIllIllI += 3;
        }
        if (llllllllllllllllIllllIlIlIllIlll >= 185) {
            ++llllllllllllllllIllllIlIlIllIllI;
        }
        if (llllllllllllllllIllllIlIlIllIlll >= 263) {
            llllllllllllllllIllllIlIlIllIllI += 7;
        }
        if (llllllllllllllllIllllIlIlIllIlll >= 301) {
            llllllllllllllllIllllIlIlIllIllI += 33;
        }
        if (llllllllllllllllIllllIlIlIllIlll >= 317) {
            llllllllllllllllIllllIlIlIllIllI += 2;
        }
        if (llllllllllllllllIllllIlIlIllIlll >= 491) {
            llllllllllllllllIllllIlIlIllIllI += 3;
        }
        return llllllllllllllllIllllIlIlIllIllI;
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.metadataRewriter;
    }
    
    @Override
    protected void registerPackets() {
        this.metadataRewriter.register();
        this.itemRewriter.register();
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.BYTE);
                this.handler(Protocol1_12To1_11_1.this.metadataRewriter.objectTrackerHandler());
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.SPAWN_MOB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_12.METADATA_LIST);
                this.handler(Protocol1_12To1_11_1.this.metadataRewriter.trackerAndRewriterHandler(Types1_12.METADATA_LIST));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIlIlllIIlllIlll) throws Exception {
                        if (!Via.getConfig().is1_12NBTArrayFix()) {
                            return;
                        }
                        try {
                            final JsonElement llllllllllllllIIIIlIlllIIllllIll = Protocol1_9To1_8.FIX_JSON.transform(null, llllllllllllllIIIIlIlllIIlllIlll.passthrough(Type.COMPONENT).toString());
                            TranslateRewriter.toClient(llllllllllllllIIIIlIlllIIllllIll, llllllllllllllIIIIlIlllIIlllIlll.user());
                            ChatItemRewriter.toClient(llllllllllllllIIIIlIlllIIllllIll, llllllllllllllIIIIlIlllIIlllIlll.user());
                            llllllllllllllIIIIlIlllIIlllIlll.set(Type.COMPONENT, 0, llllllllllllllIIIIlIlllIIllllIll);
                        }
                        catch (Exception llllllllllllllIIIIlIlllIIllllIlI) {
                            llllllllllllllIIIIlIlllIIllllIlI.printStackTrace();
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIlllllIlllllIlI) throws Exception {
                        final ClientWorld llllllllllllllIIIIlllllIllllllIl = llllllllllllllIIIIlllllIlllllIlI.user().get(ClientWorld.class);
                        final Chunk1_9_3_4Type llllllllllllllIIIIlllllIllllllII = new Chunk1_9_3_4Type(llllllllllllllIIIIlllllIllllllIl);
                        final Chunk llllllllllllllIIIIlllllIlllllIll = llllllllllllllIIIIlllllIlllllIlI.passthrough((Type<Chunk>)llllllllllllllIIIIlllllIllllllII);
                        for (int llllllllllllllIIIIllllllIIIIIIII = 0; llllllllllllllIIIIllllllIIIIIIII < llllllllllllllIIIIlllllIlllllIll.getSections().length; ++llllllllllllllIIIIllllllIIIIIIII) {
                            final ChunkSection llllllllllllllIIIIllllllIIIIIIIl = llllllllllllllIIIIlllllIlllllIll.getSections()[llllllllllllllIIIIllllllIIIIIIII];
                            if (llllllllllllllIIIIllllllIIIIIIIl != null) {
                                for (int llllllllllllllIIIIllllllIIIIIIlI = 0; llllllllllllllIIIIllllllIIIIIIlI < 16; ++llllllllllllllIIIIllllllIIIIIIlI) {
                                    for (int llllllllllllllIIIIllllllIIIIIIll = 0; llllllllllllllIIIIllllllIIIIIIll < 16; ++llllllllllllllIIIIllllllIIIIIIll) {
                                        for (int llllllllllllllIIIIllllllIIIIIlII = 0; llllllllllllllIIIIllllllIIIIIlII < 16; ++llllllllllllllIIIIllllllIIIIIlII) {
                                            final int llllllllllllllIIIIllllllIIIIIlIl = llllllllllllllIIIIllllllIIIIIIIl.getBlockWithoutData(llllllllllllllIIIIllllllIIIIIlII, llllllllllllllIIIIllllllIIIIIIlI, llllllllllllllIIIIllllllIIIIIIll);
                                            if (llllllllllllllIIIIllllllIIIIIlIl == 26) {
                                                final CompoundTag llllllllllllllIIIIllllllIIIIIllI = new CompoundTag();
                                                llllllllllllllIIIIllllllIIIIIllI.put("color", new IntTag(14));
                                                llllllllllllllIIIIllllllIIIIIllI.put("x", new IntTag(llllllllllllllIIIIllllllIIIIIlII + (llllllllllllllIIIIlllllIlllllIll.getX() << 4)));
                                                llllllllllllllIIIIllllllIIIIIllI.put("y", new IntTag(llllllllllllllIIIIllllllIIIIIIlI + (llllllllllllllIIIIllllllIIIIIIII << 4)));
                                                llllllllllllllIIIIllllllIIIIIllI.put("z", new IntTag(llllllllllllllIIIIllllllIIIIIIll + (llllllllllllllIIIIlllllIlllllIll.getZ() << 4)));
                                                llllllllllllllIIIIllllllIIIIIllI.put("id", new StringTag("minecraft:bed"));
                                                llllllllllllllIIIIlllllIlllllIll.getBlockEntities().add(llllllllllllllIIIIllllllIIIIIllI);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
        });
        this.metadataRewriter.registerRemoveEntities(ClientboundPackets1_9_3.DESTROY_ENTITIES);
        this.metadataRewriter.registerMetadataRewriter(ClientboundPackets1_9_3.ENTITY_METADATA, Types1_12.METADATA_LIST);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                final ClientWorld llllllllllllllIllIIlIIlllIIIIlII;
                final int llllllllllllllIllIIlIIlllIIIIIll;
                this.handler(llllllllllllllIllIIlIIlllIIIIIlI -> {
                    llllllllllllllIllIIlIIlllIIIIlII = llllllllllllllIllIIlIIlllIIIIIlI.user().get(ClientWorld.class);
                    llllllllllllllIllIIlIIlllIIIIIll = llllllllllllllIllIIlIIlllIIIIIlI.get((Type<Integer>)Type.INT, 1);
                    llllllllllllllIllIIlIIlllIIIIlII.setEnvironment(llllllllllllllIllIIlIIlllIIIIIll);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                final ClientWorld lllllllllllllIlIlIlllllIlIlllIlI;
                final int lllllllllllllIlIlIlllllIlIlllIIl;
                this.handler(lllllllllllllIlIlIlllllIlIlllIII -> {
                    lllllllllllllIlIlIlllllIlIlllIlI = lllllllllllllIlIlIlllllIlIlllIII.user().get(ClientWorld.class);
                    lllllllllllllIlIlIlllllIlIlllIIl = lllllllllllllIlIlIlllllIlIlllIII.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllIlIlIlllllIlIlllIlI.setEnvironment(lllllllllllllIlIlIlllllIlIlllIIl);
                });
            }
        });
        new SoundRewriter(this, this::getNewSoundId).registerSound(ClientboundPackets1_9_3.SOUND);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12>)this).cancelServerbound(ServerboundPackets1_12.PREPARE_CRAFTING_GRID);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12>)this).registerServerbound(ServerboundPackets1_12.CLIENT_SETTINGS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIlIllllIlllIllIl) throws Exception {
                        final String lllllllllllllIlIIlIllllIlllIllII = lllllllllllllIlIIlIllllIlllIllIl.get(Type.STRING, 0);
                        if (lllllllllllllIlIIlIllllIlllIllII.length() > 7) {
                            lllllllllllllIlIIlIllllIlllIllIl.set(Type.STRING, 0, lllllllllllllIlIIlIllllIlllIllII.substring(0, 7));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12>)this).cancelServerbound(ServerboundPackets1_12.RECIPE_BOOK_DATA);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12>)this).cancelServerbound(ServerboundPackets1_12.ADVANCEMENT_TAB);
    }
}
