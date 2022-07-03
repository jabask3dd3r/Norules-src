package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.rewriter.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.data.*;

public abstract class ItemRewriter<T extends Protocol> extends RewriterBase<T> implements com.viaversion.viaversion.api.rewriter.ItemRewriter<T>
{
    public void registerClickWindow1_17(final ServerboundPacketType lIllIIIlIIlllll, final Type<Item> lIllIIIlIIllIll) {
        this.protocol.registerServerbound(lIllIIIlIIlllll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.VAR_INT);
                final Type<Item> val$type;
                int llllllllllllllllIlIIllllIIIIllll;
                int llllllllllllllllIlIIllllIIIlIIll;
                this.handler(llllllllllllllllIlIIllllIIIIllII -> {
                    val$type = lIllIIIlIIllIll;
                    for (llllllllllllllllIlIIllllIIIIllll = llllllllllllllllIlIIllllIIIIllII.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllllIlIIllllIIIlIIll = 0; llllllllllllllllIlIIllllIIIlIIll < llllllllllllllllIlIIllllIIIIllll; ++llllllllllllllllIlIIllllIIIlIIll) {
                        llllllllllllllllIlIIllllIIIIllII.passthrough((Type<Object>)Type.SHORT);
                        ItemRewriter.this.handleItemToServer(llllllllllllllllIlIIllllIIIIllII.passthrough(val$type));
                    }
                    ItemRewriter.this.handleItemToServer(llllllllllllllllIlIIllllIIIIllII.passthrough(val$type));
                });
            }
        });
    }
    
    public PacketHandler itemToServerHandler(final Type<Item> lIllIIIIllIIIIl) {
        return lIllIIIIlIllIIl -> this.handleItemToServer(lIllIIIIlIllIIl.get(lIllIIIIllIIIIl, 0));
    }
    
    public void registerSetSlot(final ClientboundPacketType lIllIIIllIIlIIl, final Type<Item> lIllIIIllIIlIll) {
        this.protocol.registerClientbound(lIllIIIllIIlIIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(lIllIIIllIIlIll);
                this.handler(ItemRewriter.this.itemToClientHandler(lIllIIIllIIlIll));
            }
        });
    }
    
    public void registerCreativeInvAction(final ServerboundPacketType lIllIIIlIlIlllI, final Type<Item> lIllIIIlIlIllIl) {
        this.protocol.registerServerbound(lIllIIIlIlIlllI, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.map(lIllIIIlIlIllIl);
                this.handler(ItemRewriter.this.itemToServerHandler(lIllIIIlIlIllIl));
            }
        });
    }
    
    public PacketHandler itemArrayHandler(final Type<Item[]> lIllIIIIllIllIl) {
        final char lIllIIIIIlllIll;
        final Item[] lIllIIIIlIIIIII;
        byte lIllIIIIIlllIlI;
        int lIllIIIIIlllIIl;
        Item lIllIIIIlIIIlII;
        return lIllIIIIIllllIl -> {
            lIllIIIIlIIIIII = (Item[])(Object)(lIllIIIIIlllIll = (char)(Object)lIllIIIIIllllIl.get(lIllIIIIllIllIl, 0));
            for (lIllIIIIIlllIlI = (byte)lIllIIIIIlllIll.length, lIllIIIIIlllIIl = 0; lIllIIIIIlllIIl < lIllIIIIIlllIlI; ++lIllIIIIIlllIIl) {
                lIllIIIIlIIIlII = lIllIIIIIlllIll[lIllIIIIIlllIIl];
                this.handleItemToClient(lIllIIIIlIIIlII);
            }
        };
    }
    
    public void registerSpawnParticle(final ClientboundPacketType lIllIIIIllllIIl, final Type<Item> lIllIIIIllllIII, final Type<?> lIllIIIIlllIlll) {
        this.protocol.registerClientbound(lIllIIIIllllIIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(lIllIIIIlllIlll);
                this.map(lIllIIIIlllIlll);
                this.map(lIllIIIIlllIlll);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                this.handler(ItemRewriter.this.getSpawnParticleHandler(lIllIIIIllllIII));
            }
        });
    }
    
    public PacketHandler getSpawnParticleHandler(final Type<Item> lIllIIIIlllIIIl) {
        final int lIllIIIIIlIllIl;
        ParticleMappings lIllIIIIIlIllII;
        int lIllIIIIIllIIIl;
        int lIllIIIIIlIlIll;
        return lIllIIIIIlIlllI -> {
            lIllIIIIIlIllIl = lIllIIIIIlIlllI.get((Type<Integer>)Type.INT, 0);
            if (lIllIIIIIlIllIl != -1) {
                lIllIIIIIlIllII = this.protocol.getMappingData().getParticleMappings();
                if (lIllIIIIIlIllIl == lIllIIIIIlIllII.getBlockId() || lIllIIIIIlIllIl == lIllIIIIIlIllII.getFallingDustId()) {
                    lIllIIIIIllIIIl = lIllIIIIIlIlllI.passthrough((Type<Integer>)Type.VAR_INT);
                    lIllIIIIIlIlllI.set(Type.VAR_INT, 0, this.protocol.getMappingData().getNewBlockStateId(lIllIIIIIllIIIl));
                }
                else if (lIllIIIIIlIllIl == lIllIIIIIlIllII.getItemId()) {
                    this.handleItemToClient(lIllIIIIIlIlllI.passthrough(lIllIIIIlllIIIl));
                }
                lIllIIIIIlIlIll = this.protocol.getMappingData().getNewParticleId(lIllIIIIIlIllIl);
                if (lIllIIIIIlIlIll != lIllIIIIIlIllIl) {
                    lIllIIIIIlIlllI.set(Type.INT, 0, lIllIIIIIlIlIll);
                }
            }
        };
    }
    
    public void registerSetCooldown(final ClientboundPacketType lIllIIIlIIlIlll) {
        this.protocol.registerClientbound(lIllIIIlIIlIlll, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIIlIllllllIllIIlllI;
                this.handler(lllllllllllllIIlIllllllIllIIllll -> {
                    lllllllllllllIIlIllllllIllIIlllI = lllllllllllllIIlIllllllIllIIllll.read((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIlIllllllIllIIllll.write(Type.VAR_INT, ItemRewriter.this.protocol.getMappingData().getNewItemId(lllllllllllllIIlIllllllIllIIlllI));
                });
            }
        });
    }
    
    @Override
    public Item handleItemToClient(final Item lIllIIIlllIIIlI) {
        if (lIllIIIlllIIIlI == null) {
            return null;
        }
        if (this.protocol.getMappingData() != null && this.protocol.getMappingData().getItemMappings() != null) {
            lIllIIIlllIIIlI.setIdentifier(this.protocol.getMappingData().getNewItemId(lIllIIIlllIIIlI.identifier()));
        }
        return lIllIIIlllIIIlI;
    }
    
    public void registerEntityEquipment(final ClientboundPacketType lIllIIIllIIIIll, final Type<Item> lIllIIIlIllllll) {
        this.protocol.registerClientbound(lIllIIIllIIIIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(lIllIIIlIllllll);
                this.handler(ItemRewriter.this.itemToClientHandler(lIllIIIlIllllll));
            }
        });
    }
    
    public void registerClickWindow(final ServerboundPacketType lIllIIIlIlIlIII, final Type<Item> lIllIIIlIlIIlII) {
        this.protocol.registerServerbound(lIllIIIlIlIlIII, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.VAR_INT);
                this.map(lIllIIIlIlIIlII);
                this.handler(ItemRewriter.this.itemToServerHandler(lIllIIIlIlIIlII));
            }
        });
    }
    
    public void registerEntityEquipmentArray(final ClientboundPacketType lIllIIIlIllIlll, final Type<Item> lIllIIIlIlllIIl) {
        this.protocol.registerClientbound(lIllIIIlIllIlll, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final Type<Item> val$type;
                byte lllllllllllllIIIIIlIIllIlllllllI;
                this.handler(lllllllllllllIIIIIlIIllIllllllll -> {
                    val$type = lIllIIIlIlllIIl;
                    do {
                        lllllllllllllIIIIIlIIllIlllllllI = lllllllllllllIIIIIlIIllIllllllll.passthrough((Type<Byte>)Type.BYTE);
                        ItemRewriter.this.handleItemToClient(lllllllllllllIIIIIlIIllIllllllll.passthrough(val$type));
                    } while ((lllllllllllllIIIIIlIIllIlllllllI & 0xFFFFFF80) != 0x0);
                });
            }
        });
    }
    
    protected ItemRewriter(final T lIllIIIlllIlIII) {
        super(lIllIIIlllIlIII);
    }
    
    public void registerWindowItems(final ClientboundPacketType lIllIIIllIlIIlI, final Type<Item[]> lIllIIIllIlIIIl) {
        this.protocol.registerClientbound(lIllIIIllIlIIlI, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(lIllIIIllIlIIIl);
                this.handler(ItemRewriter.this.itemArrayHandler(lIllIIIllIlIIIl));
            }
        });
    }
    
    public PacketHandler itemToClientHandler(final Type<Item> lIllIIIIllIIlIl) {
        return lIllIIIIlIIllIl -> this.handleItemToClient(lIllIIIIlIIllIl.get(lIllIIIIllIIlIl, 0));
    }
    
    public void registerTradeList(final ClientboundPacketType lIllIIIlIIIllIl, final Type<Item> lIllIIIlIIIllII) {
        this.protocol.registerClientbound(lIllIIIlIIIllIl, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Type<Item> val$type;
                int lllllllllllllIlIIlIlIllllIIIIIII;
                int lllllllllllllIlIIlIlIllllIIIIlII;
                this.handler(lllllllllllllIlIIlIlIlllIlllllIl -> {
                    val$type = lIllIIIlIIIllII;
                    lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Object>)Type.VAR_INT);
                    for (lllllllllllllIlIIlIlIllllIIIIIII = lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIlIIlIlIllllIIIIlII = 0; lllllllllllllIlIIlIlIllllIIIIlII < lllllllllllllIlIIlIlIllllIIIIIII; ++lllllllllllllIlIIlIlIllllIIIIlII) {
                        ItemRewriter.this.handleItemToClient(lllllllllllllIlIIlIlIlllIlllllIl.passthrough(val$type));
                        ItemRewriter.this.handleItemToClient(lllllllllllllIlIIlIlIlllIlllllIl.passthrough(val$type));
                        if (lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                            ItemRewriter.this.handleItemToClient(lllllllllllllIlIIlIlIlllIlllllIl.passthrough(val$type));
                        }
                        lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Object>)Type.BOOLEAN);
                        lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Object>)Type.INT);
                        lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Object>)Type.INT);
                        lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Object>)Type.INT);
                        lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Object>)Type.INT);
                        lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Object>)Type.FLOAT);
                        lllllllllllllIlIIlIlIlllIlllllIl.passthrough((Type<Object>)Type.INT);
                    }
                });
            }
        });
    }
    
    public void registerAdvancements(final ClientboundPacketType lIllIIIlIIIIlII, final Type<Item> lIllIIIlIIIIllI) {
        this.protocol.registerClientbound(lIllIIIlIIIIlII, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Type<Item> val$type;
                int lllllllllllllIlIlIIlIlIIIlIllllI;
                int lllllllllllllIlIlIIlIlIIIllIIIlI;
                int lllllllllllllIlIlIIlIlIIIllIIlIl;
                int lllllllllllllIlIlIIlIlIIIllIIIll;
                int lllllllllllllIlIlIIlIlIIIllIIlII;
                this.handler(lllllllllllllIlIlIIlIlIIIlIlllll -> {
                    val$type = lIllIIIlIIIIllI;
                    lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Object>)Type.BOOLEAN);
                    for (lllllllllllllIlIlIIlIlIIIlIllllI = lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIlIlIIlIlIIIllIIIlI = 0; lllllllllllllIlIlIIlIlIIIllIIIlI < lllllllllllllIlIlIIlIlIIIlIllllI; ++lllllllllllllIlIlIIlIlIIIllIIIlI) {
                        lllllllllllllIlIlIIlIlIIIlIlllll.passthrough(Type.STRING);
                        if (lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                            lllllllllllllIlIlIIlIlIIIlIlllll.passthrough(Type.STRING);
                        }
                        if (lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Boolean>)Type.BOOLEAN)) {
                            lllllllllllllIlIlIIlIlIIIlIlllll.passthrough(Type.COMPONENT);
                            lllllllllllllIlIlIIlIlIIIlIlllll.passthrough(Type.COMPONENT);
                            ItemRewriter.this.handleItemToClient(lllllllllllllIlIlIIlIlIIIlIlllll.passthrough(val$type));
                            lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Object>)Type.VAR_INT);
                            lllllllllllllIlIlIIlIlIIIllIIlIl = lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Integer>)Type.INT);
                            if ((lllllllllllllIlIlIIlIlIIIllIIlIl & 0x1) != 0x0) {
                                lllllllllllllIlIlIIlIlIIIlIlllll.passthrough(Type.STRING);
                            }
                            lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Object>)Type.FLOAT);
                            lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Object>)Type.FLOAT);
                        }
                        lllllllllllllIlIlIIlIlIIIlIlllll.passthrough(Type.STRING_ARRAY);
                        for (lllllllllllllIlIlIIlIlIIIllIIIll = lllllllllllllIlIlIIlIlIIIlIlllll.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIlIlIIlIlIIIllIIlII = 0; lllllllllllllIlIlIIlIlIIIllIIlII < lllllllllllllIlIlIIlIlIIIllIIIll; ++lllllllllllllIlIlIIlIlIIIllIIlII) {
                            lllllllllllllIlIlIIlIlIIIlIlllll.passthrough(Type.STRING_ARRAY);
                        }
                    }
                });
            }
        });
    }
    
    @Override
    public Item handleItemToServer(final Item lIllIIIllIlllII) {
        if (lIllIIIllIlllII == null) {
            return null;
        }
        if (this.protocol.getMappingData() != null && this.protocol.getMappingData().getItemMappings() != null) {
            lIllIIIllIlllII.setIdentifier(this.protocol.getMappingData().getOldItemId(lIllIIIllIlllII.identifier()));
        }
        return lIllIIIllIlllII;
    }
}
