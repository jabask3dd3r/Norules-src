package com.viaversion.viaversion.protocols.protocol1_11to1_10;

import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.storage.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.metadata.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.data.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.packets.*;

public class Protocol1_11To1_10 extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9_3, ServerboundPackets1_9_3, ServerboundPackets1_9_3>
{
    private final /* synthetic */ ItemRewriter itemRewriter;
    private final /* synthetic */ EntityRewriter entityRewriter;
    private static final /* synthetic */ ValueTransformer<Float, Short> toOldByte;
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    @Override
    public void init(final UserConnection llllllllllllllIlllIIIlIllIIlllIl) {
        llllllllllllllIlllIIIlIllIIlllIl.addEntityTracker(this.getClass(), new EntityTracker1_11(llllllllllllllIlllIIIlIllIIlllIl));
        if (!llllllllllllllIlllIIIlIllIIlllIl.has(ClientWorld.class)) {
            llllllllllllllIlllIIIlIllIIlllIl.put(new ClientWorld(llllllllllllllIlllIIIlIllIIlllIl));
        }
    }
    
    @Override
    protected void registerPackets() {
        this.entityRewriter.register();
        this.itemRewriter.register();
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.SPAWN_ENTITY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.BYTE);
                this.handler(Protocol1_11To1_10.this.entityRewriter.objectTrackerHandler());
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.SPAWN_MOB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.UNSIGNED_BYTE, Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_9.METADATA_LIST);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIIIlIlIllIlIIIIl) throws Exception {
                        final int lllllllllllllIlIIIIlIlIllIlIIlIl = lllllllllllllIlIIIIlIlIllIlIIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        final int lllllllllllllIlIIIIlIlIllIlIIlII = lllllllllllllIlIIIIlIlIllIlIIIIl.get((Type<Integer>)Type.VAR_INT, 1);
                        final Entity1_11Types.EntityType lllllllllllllIlIIIIlIlIllIlIIIll = MetadataRewriter1_11To1_10.rewriteEntityType(lllllllllllllIlIIIIlIlIllIlIIlII, lllllllllllllIlIIIIlIlIllIlIIIIl.get(Types1_9.METADATA_LIST, 0));
                        if (lllllllllllllIlIIIIlIlIllIlIIIll != null) {
                            lllllllllllllIlIIIIlIlIllIlIIIIl.set(Type.VAR_INT, 1, lllllllllllllIlIIIIlIlIllIlIIIll.getId());
                            lllllllllllllIlIIIIlIlIllIlIIIIl.user().getEntityTracker(Protocol1_11To1_10.class).addEntity(lllllllllllllIlIIIIlIlIllIlIIlIl, lllllllllllllIlIIIIlIlIllIlIIIll);
                            Protocol1_11To1_10.this.entityRewriter.handleMetadata(lllllllllllllIlIIIIlIlIllIlIIlIl, lllllllllllllIlIIIIlIlIllIlIIIIl.get(Types1_9.METADATA_LIST, 0), lllllllllllllIlIIIIlIlIllIlIIIIl.user());
                        }
                    }
                });
            }
        });
        new SoundRewriter(this, this::getNewSoundId).registerSound(ClientboundPackets1_9_3.SOUND);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.COLLECT_ITEM, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlllIlIlllIlIllll) throws Exception {
                        lllllllllllllllIlllIlIlllIlIllll.write(Type.VAR_INT, 1);
                    }
                });
            }
        });
        this.entityRewriter.registerMetadataRewriter(ClientboundPackets1_9_3.ENTITY_METADATA, Types1_9.METADATA_LIST);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.ENTITY_TELEPORT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlllIIIIlIlllllIl) throws Exception {
                        final int lllllllllllllIlIlllIIIIlIllllllI = lllllllllllllIlIlllIIIIlIlllllIl.get((Type<Integer>)Type.VAR_INT, 0);
                        if (Via.getConfig().isHologramPatch()) {
                            final EntityTracker1_11 lllllllllllllIlIlllIIIIllIIIIIIl = lllllllllllllIlIlllIIIIlIlllllIl.user().getEntityTracker(Protocol1_11To1_10.class);
                            if (lllllllllllllIlIlllIIIIllIIIIIIl.isHologram(lllllllllllllIlIlllIIIIlIllllllI)) {
                                Double lllllllllllllIlIlllIIIIllIIIIIlI = lllllllllllllIlIlllIIIIlIlllllIl.get((Type<Double>)Type.DOUBLE, 1);
                                lllllllllllllIlIlllIIIIllIIIIIlI -= Via.getConfig().getHologramYOffset();
                                lllllllllllllIlIlllIIIIlIlllllIl.set(Type.DOUBLE, 1, lllllllllllllIlIlllIIIIllIIIIIlI);
                            }
                        }
                    }
                });
            }
        });
        this.entityRewriter.registerRemoveEntities(ClientboundPackets1_9_3.DESTROY_ENTITIES);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.TITLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIIlIIIlIlIlIlI) throws Exception {
                        final int lllllllllllllIIIIlIIlIIIlIlIlIIl = lllllllllllllIIIIlIIlIIIlIlIlIlI.get((Type<Integer>)Type.VAR_INT, 0);
                        if (lllllllllllllIIIIlIIlIIIlIlIlIIl >= 2) {
                            lllllllllllllIIIIlIIlIIIlIlIlIlI.set(Type.VAR_INT, 0, lllllllllllllIIIIlIIlIIIlIlIlIIl + 1);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.BLOCK_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllIlllllllIlIlllIIllll) throws Exception {
                        if (Via.getConfig().isPistonAnimationPatch()) {
                            final int llllllllllllIlllllllIlIlllIlIIlI = llllllllllllIlllllllIlIlllIIllll.get((Type<Integer>)Type.VAR_INT, 0);
                            if (llllllllllllIlllllllIlIlllIlIIlI == 33 || llllllllllllIlllllllIlIlllIlIIlI == 29) {
                                llllllllllllIlllllllIlIlllIIllll.cancel();
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllIlIlIlIlllIIIlI) throws Exception {
                        final CompoundTag lllllllllllllIIllIlIlIlIlllIIIll = lllllllllllllIIllIlIlIlIlllIIIlI.get(Type.NBT, 0);
                        if (lllllllllllllIIllIlIlIlIlllIIIlI.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 1) {
                            EntityIdRewriter.toClientSpawner(lllllllllllllIIllIlIlIlIlllIIIll);
                        }
                        if (lllllllllllllIIllIlIlIlIlllIIIll.contains("id")) {
                            lllllllllllllIIllIlIlIlIlllIIIll.get("id").setValue(BlockEntityRewriter.toNewIdentifier((String)lllllllllllllIIllIlIlIlIlllIIIll.get("id").getValue()));
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
                    public void handle(final PacketWrapper lllllllllllllIIlIlIIllIIllllllIl) throws Exception {
                        final ClientWorld lllllllllllllIIlIlIIllIlIIIIIIII = lllllllllllllIIlIlIIllIIllllllIl.user().get(ClientWorld.class);
                        final Chunk1_9_3_4Type lllllllllllllIIlIlIIllIIllllllll = new Chunk1_9_3_4Type(lllllllllllllIIlIlIIllIlIIIIIIII);
                        final Chunk lllllllllllllIIlIlIIllIIlllllllI = lllllllllllllIIlIlIIllIIllllllIl.passthrough((Type<Chunk>)lllllllllllllIIlIlIIllIIllllllll);
                        lllllllllllllIIlIlIIllIIllllllIl.clearInputBuffer();
                        if (lllllllllllllIIlIlIIllIIlllllllI.getBlockEntities() == null) {
                            return;
                        }
                        for (final CompoundTag lllllllllllllIIlIlIIllIlIIIIIIll : lllllllllllllIIlIlIIllIIlllllllI.getBlockEntities()) {
                            if (lllllllllllllIIlIlIIllIlIIIIIIll.contains("id")) {
                                final String lllllllllllllIIlIlIIllIlIIIIIlII = lllllllllllllIIlIlIIllIlIIIIIIll.get("id").getValue();
                                if (lllllllllllllIIlIlIIllIlIIIIIlII.equals("MobSpawner")) {
                                    EntityIdRewriter.toClientSpawner(lllllllllllllIIlIlIIllIlIIIIIIll);
                                }
                                lllllllllllllIIlIlIIllIlIIIIIIll.get("id").setValue(BlockEntityRewriter.toNewIdentifier(lllllllllllllIIlIlIIllIlIIIIIlII));
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.JOIN_GAME, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.INT);
                final ClientWorld lIIIIllIIIIlIlI;
                final int lIIIIllIIIIlIIl;
                this.handler(lIIIIllIIIIlIII -> {
                    lIIIIllIIIIlIlI = lIIIIllIIIIlIII.user().get(ClientWorld.class);
                    lIIIIllIIIIlIIl = lIIIIllIIIIlIII.get((Type<Integer>)Type.INT, 1);
                    lIIIIllIIIIlIlI.setEnvironment(lIIIIllIIIIlIIl);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.RESPAWN, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                final ClientWorld lllllllllllllllllIIlllIIIllIIllI;
                final int lllllllllllllllllIIlllIIIllIIlIl;
                this.handler(lllllllllllllllllIIlllIIIllIIlll -> {
                    lllllllllllllllllIIlllIIIllIIllI = lllllllllllllllllIIlllIIIllIIlll.user().get(ClientWorld.class);
                    lllllllllllllllllIIlllIIIllIIlIl = lllllllllllllllllIIlllIIIllIIlll.get((Type<Integer>)Type.INT, 0);
                    lllllllllllllllllIIlllIIIllIIllI.setEnvironment(lllllllllllllllllIIlllIIIllIIlIl);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.POSITION);
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                final int lllllllllllllIIlIlIIIlIIIIlIlllI;
                int lllllllllllllIIlIlIIIlIIIIllIIlI;
                boolean lllllllllllllIIlIlIIIlIIIIllIIIl;
                Pair<Integer, Boolean> lllllllllllllIIlIlIIIlIIIIllIIII;
                int lllllllllllllIIlIlIIIlIIIIllIIlI2;
                this.handler(lllllllllllllIIlIlIIIlIIIIlIllIl -> {
                    lllllllllllllIIlIlIIIlIIIIlIlllI = lllllllllllllIIlIlIIIlIIIIlIllIl.get((Type<Integer>)Type.INT, 0);
                    if (lllllllllllllIIlIlIIIlIIIIlIlllI == 2002) {
                        lllllllllllllIIlIlIIIlIIIIllIIlI = lllllllllllllIIlIlIIIlIIIIlIllIl.get((Type<Integer>)Type.INT, 1);
                        lllllllllllllIIlIlIIIlIIIIllIIIl = false;
                        lllllllllllllIIlIlIIIlIIIIllIIII = PotionColorMapping.getNewData(lllllllllllllIIlIlIIIlIIIIllIIlI);
                        if (lllllllllllllIIlIlIIIlIIIIllIIII == null) {
                            Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Received unknown 1.11 -> 1.10.2 potion data (").append(lllllllllllllIIlIlIIIlIIIIllIIlI).append(")")));
                            lllllllllllllIIlIlIIIlIIIIllIIlI2 = 0;
                        }
                        else {
                            lllllllllllllIIlIlIIIlIIIIllIIlI2 = lllllllllllllIIlIlIIIlIIIIllIIII.getKey();
                            lllllllllllllIIlIlIIIlIIIIllIIIl = lllllllllllllIIlIlIIIlIIIIllIIII.getValue();
                        }
                        if (lllllllllllllIIlIlIIIlIIIIllIIIl) {
                            lllllllllllllIIlIlIIIlIIIIlIllIl.set(Type.INT, 0, 2007);
                        }
                        lllllllllllllIIlIlIIIlIIIIlIllIl.set(Type.INT, 1, lllllllllllllIIlIlIIIlIIIIllIIlI2);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9_3>)this).registerServerbound(ServerboundPackets1_9_3.PLAYER_BLOCK_PLACEMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map((Type<Object>)Type.FLOAT, (ValueTransformer<Object, Object>)Protocol1_11To1_10.toOldByte);
                this.map((Type<Object>)Type.FLOAT, (ValueTransformer<Object, Object>)Protocol1_11To1_10.toOldByte);
                this.map((Type<Object>)Type.FLOAT, (ValueTransformer<Object, Object>)Protocol1_11To1_10.toOldByte);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9_3>)this).registerServerbound(ServerboundPackets1_9_3.CHAT_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIlIlllllIIIIllIl) throws Exception {
                        final String llllllllllllllllIlIlllllIIIIlllI = llllllllllllllllIlIlllllIIIIllIl.get(Type.STRING, 0);
                        if (llllllllllllllllIlIlllllIIIIlllI.length() > 100) {
                            llllllllllllllllIlIlllllIIIIllIl.set(Type.STRING, 0, llllllllllllllllIlIlllllIIIIlllI.substring(0, 100));
                        }
                    }
                });
            }
        });
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    public Protocol1_11To1_10() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9_3.class);
        this.entityRewriter = new MetadataRewriter1_11To1_10(this);
        this.itemRewriter = new InventoryPackets(this);
    }
    
    static {
        toOldByte = new ValueTransformer<Float, Short>() {
            @Override
            public Short transform(final PacketWrapper llllllllllllllIlIIIlIlIIIlllIlII, final Float llllllllllllllIlIIIlIlIIIlllIIlI) throws Exception {
                return (short)(llllllllllllllIlIIIlIlIIIlllIIlI * 16.0f);
            }
        };
    }
    
    private int getNewSoundId(int llllllllllllllIlllIIIlIllIlIIIlI) {
        if (llllllllllllllIlllIIIlIllIlIIIlI == 196) {
            return -1;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 85) {
            llllllllllllllIlllIIIlIllIlIIIlI += 2;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 176) {
            ++llllllllllllllIlllIIIlIllIlIIIlI;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 197) {
            llllllllllllllIlllIIIlIllIlIIIlI += 8;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 207) {
            --llllllllllllllIlllIIIlIllIlIIIlI;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 279) {
            llllllllllllllIlllIIIlIllIlIIIlI += 9;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 296) {
            ++llllllllllllllIlllIIIlIllIlIIIlI;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 390) {
            llllllllllllllIlllIIIlIllIlIIIlI += 4;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 400) {
            llllllllllllllIlllIIIlIllIlIIIlI += 3;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 450) {
            ++llllllllllllllIlllIIIlIllIlIIIlI;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 455) {
            ++llllllllllllllIlllIIIlIllIlIIIlI;
        }
        if (llllllllllllllIlllIIIlIllIlIIIlI >= 470) {
            ++llllllllllllllIlllIIIlIllIlIIIlI;
        }
        return llllllllllllllIlllIIIlIllIlIIIlI;
    }
}
