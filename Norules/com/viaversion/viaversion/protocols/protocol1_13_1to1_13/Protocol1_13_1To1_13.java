package com.viaversion.viaversion.protocols.protocol1_13_1to1_13;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.data.*;
import com.viaversion.viaversion.protocols.protocol1_13_1to1_13.metadata.*;
import com.viaversion.viaversion.protocols.protocol1_13_1to1_13.packets.*;

public class Protocol1_13_1To1_13 extends AbstractProtocol<ClientboundPackets1_13, ClientboundPackets1_13, ServerboundPackets1_13, ServerboundPackets1_13>
{
    public static final /* synthetic */ MappingData MAPPINGS;
    private final /* synthetic */ ItemRewriter itemRewriter;
    private final /* synthetic */ EntityRewriter entityRewriter;
    
    @Override
    public void init(final UserConnection lllllllllllllIllIIIIlllIIIIllIll) {
        lllllllllllllIllIIIIlllIIIIllIll.addEntityTracker(this.getClass(), new EntityTrackerBase(lllllllllllllIllIIIIlllIIIIllIll, Entity1_13Types.EntityType.PLAYER));
        if (!lllllllllllllIllIIIIlllIIIIllIll.has(ClientWorld.class)) {
            lllllllllllllIllIIIIlllIIIIllIll.put(new ClientWorld(lllllllllllllIllIIIIlllIIIIllIll));
        }
    }
    
    @Override
    public EntityRewriter getEntityRewriter() {
        return this.entityRewriter;
    }
    
    @Override
    protected void registerPackets() {
        this.entityRewriter.register();
        this.itemRewriter.register();
        EntityPackets.register(this);
        WorldPackets.register(this);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.TAB_COMPLETE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.STRING, (ValueTransformer<String, Object>)new ValueTransformer<String, String>(Type.STRING) {
                    @Override
                    public String transform(final PacketWrapper llllllllllllIlllllllIlIllIlllIII, final String llllllllllllIlllllllIlIllIllIlll) {
                        return llllllllllllIlllllllIlIllIllIlll.startsWith("/") ? llllllllllllIlllllllIlIllIllIlll.substring(1) : llllllllllllIlllllllIlIllIllIlll;
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this).registerServerbound(ServerboundPackets1_13.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLAT_ITEM);
                this.map(Type.BOOLEAN);
                final Item lllllllllllllllIIIIllIIIIllIIlIl;
                this.handler(lllllllllllllllIIIIllIIIIllIIIll -> {
                    lllllllllllllllIIIIllIIIIllIIlIl = lllllllllllllllIIIIllIIIIllIIIll.get(Type.FLAT_ITEM, 0);
                    Protocol1_13_1To1_13.this.itemRewriter.handleItemToServer(lllllllllllllllIIIIllIIIIllIIlIl);
                    return;
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlIIIlllllIlIIlIl) throws Exception {
                        final int lllllllllllllIIIlIIIlllllIlIIlII = lllllllllllllIIIlIIIlllllIlIIlIl.read((Type<Integer>)Type.VAR_INT);
                        if (lllllllllllllIIIlIIIlllllIlIIlII == 1) {
                            lllllllllllllIIIlIIIlllllIlIIlIl.cancel();
                        }
                    }
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
                    public void handle(final PacketWrapper lllllllllllllIIlIIlIIlIllIIIIIII) throws Exception {
                        final int lllllllllllllIIlIIlIIlIllIIIIIlI = lllllllllllllIIlIIlIIlIllIIIIIII.get((Type<Integer>)Type.VAR_INT, 1);
                        lllllllllllllIIlIIlIIlIllIIIIIII.set(Type.VAR_INT, 1, lllllllllllllIIlIIlIIlIllIIIIIlI + 1);
                        for (int lllllllllllllIIlIIlIIlIllIIIIIIl = lllllllllllllIIlIIlIIlIllIIIIIII.get((Type<Integer>)Type.VAR_INT, 3), lllllllllllllIIlIIlIIlIllIIIIlIl = 0; lllllllllllllIIlIIlIIlIllIIIIlIl < lllllllllllllIIlIIlIIlIllIIIIIIl; ++lllllllllllllIIlIIlIIlIllIIIIlIl) {
                            lllllllllllllIIlIIlIIlIllIIIIIII.passthrough(Type.STRING);
                            final boolean lllllllllllllIIlIIlIIlIllIIIIllI = lllllllllllllIIlIIlIIlIllIIIIIII.passthrough((Type<Boolean>)Type.BOOLEAN);
                            if (lllllllllllllIIlIIlIIlIllIIIIllI) {
                                lllllllllllllIIlIIlIIlIllIIIIIII.passthrough(Type.STRING);
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
                    public void handle(final PacketWrapper lllllllllllllIIlIIIIIIIIllIIllII) throws Exception {
                        final int lllllllllllllIIlIIIIIIIIllIIllIl = lllllllllllllIIlIIIIIIIIllIIllII.get((Type<Integer>)Type.VAR_INT, 0);
                        if (lllllllllllllIIlIIIIIIIIllIIllIl == 0) {
                            lllllllllllllIIlIIIIIIIIllIIllII.passthrough(Type.COMPONENT);
                            lllllllllllllIIlIIIIIIIIllIIllII.passthrough((Type<Object>)Type.FLOAT);
                            lllllllllllllIIlIIIIIIIIllIIllII.passthrough((Type<Object>)Type.VAR_INT);
                            lllllllllllllIIlIIIIIIIIllIIllII.passthrough((Type<Object>)Type.VAR_INT);
                            short lllllllllllllIIlIIIIIIIIllIlIIII = lllllllllllllIIlIIIIIIIIllIIllII.read((Type<Byte>)Type.BYTE);
                            if ((lllllllllllllIIlIIIIIIIIllIlIIII & 0x2) != 0x0) {
                                lllllllllllllIIlIIIIIIIIllIlIIII |= 0x4;
                            }
                            lllllllllllllIIlIIIIIIIIllIIllII.write(Type.UNSIGNED_BYTE, lllllllllllllIIlIIIIIIIIllIlIIII);
                        }
                    }
                });
            }
        });
        new TagRewriter(this).register(ClientboundPackets1_13.TAGS, RegistryType.ITEM);
        new StatisticsRewriter(this).register(ClientboundPackets1_13.STATISTICS);
    }
    
    @Override
    public ItemRewriter getItemRewriter() {
        return this.itemRewriter;
    }
    
    @Override
    public MappingData getMappingData() {
        return Protocol1_13_1To1_13.MAPPINGS;
    }
    
    static {
        MAPPINGS = new MappingDataBase("1.13", "1.13.2", true);
    }
    
    public Protocol1_13_1To1_13() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_13.class, ServerboundPackets1_13.class, ServerboundPackets1_13.class);
        this.entityRewriter = new MetadataRewriter1_13_1To1_13(this);
        this.itemRewriter = new InventoryPackets(this);
    }
}
