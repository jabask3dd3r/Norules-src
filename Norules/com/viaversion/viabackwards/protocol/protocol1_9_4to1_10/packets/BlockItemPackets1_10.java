package com.viaversion.viabackwards.protocol.protocol1_9_4to1_10.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_9_4to1_10.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.protocol.*;

public class BlockItemPackets1_10 extends LegacyBlockItemRewriter<Protocol1_9_4To1_10>
{
    @Override
    protected void registerPackets() {
        this.registerSetSlot(ClientboundPackets1_9_3.SET_SLOT, Type.ITEM);
        this.registerWindowItems(ClientboundPackets1_9_3.WINDOW_ITEMS, Type.ITEM_ARRAY);
        this.registerEntityEquipment(ClientboundPackets1_9_3.ENTITY_EQUIPMENT, Type.ITEM);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIIlIIllllllIIII) throws Exception {
                        if (llllllllllllllIIIIIlIIllllllIIII.get(Type.STRING, 0).equalsIgnoreCase("MC|TrList")) {
                            llllllllllllllIIIIIlIIllllllIIII.passthrough((Type<Object>)Type.INT);
                            for (int llllllllllllllIIIIIlIIllllllIlII = llllllllllllllIIIIIlIIllllllIIII.passthrough((Type<Short>)Type.UNSIGNED_BYTE), llllllllllllllIIIIIlIIllllllIllI = 0; llllllllllllllIIIIIlIIllllllIllI < llllllllllllllIIIIIlIIllllllIlII; ++llllllllllllllIIIIIlIIllllllIllI) {
                                llllllllllllllIIIIIlIIllllllIIII.write(Type.ITEM, BlockItemPackets1_10.this.handleItemToClient(llllllllllllllIIIIIlIIllllllIIII.read(Type.ITEM)));
                                llllllllllllllIIIIIlIIllllllIIII.write(Type.ITEM, BlockItemPackets1_10.this.handleItemToClient(llllllllllllllIIIIIlIIllllllIIII.read(Type.ITEM)));
                                final boolean llllllllllllllIIIIIlIIlllllllIII = llllllllllllllIIIIIlIIllllllIIII.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (llllllllllllllIIIIIlIIlllllllIII) {
                                    llllllllllllllIIIIIlIIllllllIIII.write(Type.ITEM, BlockItemPackets1_10.this.handleItemToClient(llllllllllllllIIIIIlIIllllllIIII.read(Type.ITEM)));
                                }
                                llllllllllllllIIIIIlIIllllllIIII.passthrough((Type<Object>)Type.BOOLEAN);
                                llllllllllllllIIIIIlIIllllllIIII.passthrough((Type<Object>)Type.INT);
                                llllllllllllllIIIIIlIIllllllIIII.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        this.registerClickWindow(ServerboundPackets1_9_3.CLICK_WINDOW, Type.ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_9_3.CREATIVE_INVENTORY_ACTION, Type.ITEM);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIllIlIlIIlIIllllI) throws Exception {
                        final ClientWorld llllllllllllllIIllIlIlIIlIlIIIlI = llllllllllllllIIllIlIlIIlIIllllI.user().get(ClientWorld.class);
                        final Chunk1_9_3_4Type llllllllllllllIIllIlIlIIlIlIIIIl = new Chunk1_9_3_4Type(llllllllllllllIIllIlIlIIlIlIIIlI);
                        final Chunk llllllllllllllIIllIlIlIIlIlIIIII = llllllllllllllIIllIlIlIIlIIllllI.passthrough((Type<Chunk>)llllllllllllllIIllIlIlIIlIlIIIIl);
                        LegacyBlockItemRewriter.this.handleChunk(llllllllllllllIIllIlIlIIlIlIIIII);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIIIlIIIIlllIIl) throws Exception {
                        final int llllllllllllllIllIIIIlIIIIlllIII = llllllllllllllIllIIIIlIIIIlllIIl.get((Type<Integer>)Type.VAR_INT, 0);
                        llllllllllllllIllIIIIlIIIIlllIIl.set(Type.VAR_INT, 0, BlockItemPackets1_10.this.handleBlockID(llllllllllllllIllIIIIlIIIIlllIII));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BLOCK_CHANGE_RECORD_ARRAY);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIIlIlIlIIllIIIIl) throws Exception {
                        final String llllllllllllllIlIIlIlIlIIllIIIII = (Object)llllllllllllllIlIIlIlIlIIllIIIIl.get(Type.BLOCK_CHANGE_RECORD_ARRAY, 0);
                        final double llllllllllllllIlIIlIlIlIIlIlllll = llllllllllllllIlIIlIlIlIIllIIIII.length;
                        for (float llllllllllllllIlIIlIlIlIIlIllllI = 0; llllllllllllllIlIIlIlIlIIlIllllI < llllllllllllllIlIIlIlIlIIlIlllll; ++llllllllllllllIlIIlIlIlIIlIllllI) {
                            final BlockChangeRecord llllllllllllllIlIIlIlIlIIllIIlIl = llllllllllllllIlIIlIlIlIIllIIIII[llllllllllllllIlIIlIlIlIIlIllllI];
                            llllllllllllllIlIIlIlIlIIllIIlIl.setBlockId(BlockItemPackets1_10.this.handleBlockID(llllllllllllllIlIIlIlIlIIllIIlIl.getBlockId()));
                        }
                    }
                });
            }
        });
        ((Protocol1_9_4To1_10)this.protocol).getEntityRewriter().filter().handler((lllllllllllllIIllIIlIlIllIIIIlIl, lllllllllllllIIllIIlIlIllIIIIIlI) -> {
            if (lllllllllllllIIllIIlIlIllIIIIIlI.metaType().type().equals(Type.ITEM)) {
                lllllllllllllIIllIIlIlIllIIIIIlI.setValue(this.handleItemToClient((Item)lllllllllllllIIllIIlIlIllIIIIIlI.getValue()));
            }
            return;
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIlIIlIIIlllIlllI) throws Exception {
                        final int lllllllllllllIlIIlIIlIIIlllIllll = lllllllllllllIlIIlIIlIIIlllIlllI.get((Type<Integer>)Type.INT, 0);
                        if (lllllllllllllIlIIlIIlIIIlllIllll == 46) {
                            lllllllllllllIlIIlIIlIIIlllIlllI.set(Type.INT, 0, 38);
                        }
                    }
                });
            }
        });
    }
    
    public BlockItemPackets1_10(final Protocol1_9_4To1_10 lllllllllllllIIllIIlIlIllIIIlllI) {
        super(lllllllllllllIIllIIlIlIllIIIlllI);
    }
}
