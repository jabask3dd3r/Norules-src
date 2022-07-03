package com.viaversion.viaversion.protocols.protocol1_10to1_9_3;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.protocols.protocol1_10to1_9_3.storage.*;
import java.util.concurrent.*;
import java.util.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.protocols.protocol1_10to1_9_3.packets.*;

public class Protocol1_10To1_9_3_4 extends AbstractProtocol<ClientboundPackets1_9_3, ClientboundPackets1_9_3, ServerboundPackets1_9_3, ServerboundPackets1_9_3>
{
    public static final /* synthetic */ ValueTransformer<List<Metadata>, List<Metadata>> TRANSFORM_METADATA;
    public static final /* synthetic */ ValueTransformer<Short, Float> TO_NEW_PITCH;
    private final /* synthetic */ ItemRewriter itemRewriter;
    
    public int getNewSoundId(final int lllllllllllllIllIIIIIlIlIIIllIII) {
        int lllllllllllllIllIIIIIlIlIIIlIlll = lllllllllllllIllIIIIIlIlIIIllIII;
        if (lllllllllllllIllIIIIIlIlIIIllIII >= 24) {
            ++lllllllllllllIllIIIIIlIlIIIlIlll;
        }
        if (lllllllllllllIllIIIIIlIlIIIllIII >= 248) {
            lllllllllllllIllIIIIIlIlIIIlIlll += 4;
        }
        if (lllllllllllllIllIIIIIlIlIIIllIII >= 296) {
            lllllllllllllIllIIIIIlIlIIIlIlll += 6;
        }
        if (lllllllllllllIllIIIIIlIlIIIllIII >= 354) {
            lllllllllllllIllIIIIIlIlIIIlIlll += 4;
        }
        if (lllllllllllllIllIIIIIlIlIIIllIII >= 372) {
            lllllllllllllIllIIIIIlIlIIIlIlll += 4;
        }
        return lllllllllllllIllIIIIIlIlIIIlIlll;
    }
    
    @Override
    protected void registerPackets() {
        this.itemRewriter.register();
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.NAMED_SOUND, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.VAR_INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.FLOAT);
                this.map(Type.UNSIGNED_BYTE, Protocol1_10To1_9_3_4.TO_NEW_PITCH);
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
                this.map(Type.UNSIGNED_BYTE, Protocol1_10To1_9_3_4.TO_NEW_PITCH);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIllIlIIIIllIIIIIl) throws Exception {
                        final int lllllllllllllllIllIlIIIIllIIIIll = lllllllllllllllIllIlIIIIllIIIIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        lllllllllllllllIllIlIIIIllIIIIIl.set(Type.VAR_INT, 0, Protocol1_10To1_9_3_4.this.getNewSoundId(lllllllllllllllIllIlIIIIllIIIIll));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.ENTITY_METADATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Types1_9.METADATA_LIST, Protocol1_10To1_9_3_4.TRANSFORM_METADATA);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.SPAWN_MOB, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.map(Types1_9.METADATA_LIST, Protocol1_10To1_9_3_4.TRANSFORM_METADATA);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.SPAWN_PLAYER, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.UUID);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.BYTE);
                this.map(Type.BYTE);
                this.map(Types1_9.METADATA_LIST, Protocol1_10To1_9_3_4.TRANSFORM_METADATA);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this).registerClientbound(ClientboundPackets1_9_3.RESOURCE_PACK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIlIlIIllIllIlIlI) throws Exception {
                        final ResourcePackTracker lllllllllllllIllIlIlIIllIllIlIll = lllllllllllllIllIlIlIIllIllIlIlI.user().get(ResourcePackTracker.class);
                        lllllllllllllIllIlIlIIllIllIlIll.setLastHash(lllllllllllllIllIlIlIIllIllIlIlI.get(Type.STRING, 1));
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9_3>)this).registerServerbound(ServerboundPackets1_9_3.RESOURCE_PACK_STATUS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllIllIl) throws Exception {
                        final ResourcePackTracker lllllIlllI = lllllIllIl.user().get(ResourcePackTracker.class);
                        lllllIllIl.write(Type.STRING, lllllIlllI.getLastHash());
                        lllllIllIl.write(Type.VAR_INT, (Integer)lllllIllIl.read((Type<T>)Type.VAR_INT));
                    }
                });
            }
        });
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    static {
        TO_NEW_PITCH = new ValueTransformer<Short, Float>() {
            @Override
            public Float transform(final PacketWrapper lllllllllllllIllIlIIlIlIllIIIlIl, final Short lllllllllllllIllIlIIlIlIllIIIIll) throws Exception {
                return lllllllllllllIllIlIIlIlIllIIIIll / 63.0f;
            }
        };
        TRANSFORM_METADATA = new ValueTransformer<List<Metadata>, List<Metadata>>() {
            @Override
            public List<Metadata> transform(final PacketWrapper llllllllllllllIlIlIIIllllIllIlll, final List<Metadata> llllllllllllllIlIlIIIllllIllIllI) throws Exception {
                final List<Metadata> llllllllllllllIlIlIIIllllIllIlIl = new CopyOnWriteArrayList<Metadata>(llllllllllllllIlIlIIIllllIllIllI);
                for (final Metadata llllllllllllllIlIlIIIllllIlllIIl : llllllllllllllIlIlIIIllllIllIlIl) {
                    if (llllllllllllllIlIlIIIllllIlllIIl.id() >= 5) {
                        llllllllllllllIlIlIIIllllIlllIIl.setId(llllllllllllllIlIlIIIllllIlllIIl.id() + 1);
                    }
                }
                return llllllllllllllIlIlIIIllllIllIlIl;
            }
        };
    }
    
    @Override
    public void init(final UserConnection lllllllllllllIllIIIIIlIlIIIlIIIl) {
        lllllllllllllIllIIIIIlIlIIIlIIIl.put(new ResourcePackTracker());
    }
    
    public Protocol1_10To1_9_3_4() {
        super(ClientboundPackets1_9_3.class, ClientboundPackets1_9_3.class, ServerboundPackets1_9_3.class, ServerboundPackets1_9_3.class);
        this.itemRewriter = new InventoryPackets(this);
    }
}
