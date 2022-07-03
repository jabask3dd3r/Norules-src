package com.viaversion.viabackwards.protocol.protocol1_14_4to1_15.packets;

import com.viaversion.viabackwards.protocol.protocol1_14_4to1_15.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.types.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.protocol.*;

public class BlockItemPackets1_15 extends ItemRewriter<Protocol1_14_4To1_15>
{
    @Override
    protected void registerPackets() {
        final BlockRewriter llllllllllllllIlIlIIIIlIlllIIIlI = new BlockRewriter(this.protocol, Type.POSITION1_14);
        new RecipeRewriter1_14(this.protocol).registerDefaultHandler(ClientboundPackets1_15.DECLARE_RECIPES);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this.protocol).registerServerbound(ServerboundPackets1_14.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIlIIllIIlIIIlIIllIl -> BlockItemPackets1_15.this.handleItemToServer(lllllllllllllIlIIllIIlIIIlIIllIl.passthrough(Type.FLAT_VAR_INT_ITEM)));
            }
        });
        this.registerSetCooldown(ClientboundPackets1_15.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_15.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerSetSlot(ClientboundPackets1_15.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
        this.registerTradeList(ClientboundPackets1_15.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
        this.registerEntityEquipment(ClientboundPackets1_15.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
        this.registerAdvancements(ClientboundPackets1_15.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        this.registerClickWindow(ServerboundPackets1_14.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_14.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        llllllllllllllIlIlIIIIlIlllIIIlI.registerAcknowledgePlayerDigging(ClientboundPackets1_15.ACKNOWLEDGE_PLAYER_DIGGING);
        llllllllllllllIlIlIIIIlIlllIIIlI.registerBlockAction(ClientboundPackets1_15.BLOCK_ACTION);
        llllllllllllllIlIlIIIIlIlllIIIlI.registerBlockChange(ClientboundPackets1_15.BLOCK_CHANGE);
        llllllllllllllIlIlIIIIlIlllIIIlI.registerMultiBlockChange(ClientboundPackets1_15.MULTI_BLOCK_CHANGE);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lIIIlIIlIlIlIIl) throws Exception {
                        final Chunk lIIIlIIlIlIlIII = lIIIlIIlIlIlIIl.read((Type<Chunk>)new Chunk1_15Type());
                        lIIIlIIlIlIlIIl.write(new Chunk1_14Type(), lIIIlIIlIlIlIII);
                        if (lIIIlIIlIlIlIII.isFullChunk()) {
                            final int[] lIIIlIIlIllIIIl = lIIIlIIlIlIlIII.getBiomeData();
                            final int[] lIIIlIIlIllIIII = new int[256];
                            for (int lIIIlIIlIllIIlI = 0; lIIIlIIlIllIIlI < 4; ++lIIIlIIlIllIIlI) {
                                for (int lIIIlIIlIllIIll = 0; lIIIlIIlIllIIll < 4; ++lIIIlIIlIllIIll) {
                                    final int lIIIlIIlIlllIII = lIIIlIIlIllIIll << 2;
                                    final int lIIIlIIlIllIlll = lIIIlIIlIllIIlI << 2;
                                    final int lIIIlIIlIllIllI = lIIIlIIlIllIlll << 4 | lIIIlIIlIlllIII;
                                    final int lIIIlIIlIllIlIl = lIIIlIIlIllIIlI << 2 | lIIIlIIlIllIIll;
                                    final int lIIIlIIlIllIlII = lIIIlIIlIllIIIl[lIIIlIIlIllIlIl];
                                    for (int lIIIlIIlIlllIIl = 0; lIIIlIIlIlllIIl < 4; ++lIIIlIIlIlllIIl) {
                                        final int lIIIlIIlIlllIlI = lIIIlIIlIllIllI + (lIIIlIIlIlllIIl << 4);
                                        for (int lIIIlIIlIlllIll = 0; lIIIlIIlIlllIll < 4; ++lIIIlIIlIlllIll) {
                                            lIIIlIIlIllIIII[lIIIlIIlIlllIlI + lIIIlIIlIlllIll] = lIIIlIIlIllIlII;
                                        }
                                    }
                                }
                            }
                            lIIIlIIlIlIlIII.setBiomeData(lIIIlIIlIllIIII);
                        }
                        for (int lIIIlIIlIlIlIll = 0; lIIIlIIlIlIlIll < lIIIlIIlIlIlIII.getSections().length; ++lIIIlIIlIlIlIll) {
                            final ChunkSection lIIIlIIlIlIllII = lIIIlIIlIlIlIII.getSections()[lIIIlIIlIlIlIll];
                            if (lIIIlIIlIlIllII != null) {
                                for (int lIIIlIIlIlIllIl = 0; lIIIlIIlIlIllIl < lIIIlIIlIlIllII.getPaletteSize(); ++lIIIlIIlIlIllIl) {
                                    final int lIIIlIIlIlIllll = lIIIlIIlIlIllII.getPaletteEntry(lIIIlIIlIlIllIl);
                                    final int lIIIlIIlIlIlllI = ((Protocol1_14_4To1_15)BlockItemPackets1_15.this.protocol).getMappingData().getNewBlockStateId(lIIIlIIlIlIllll);
                                    lIIIlIIlIlIllII.setPaletteEntry(lIIIlIIlIlIllIl, lIIIlIIlIlIlllI);
                                }
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIlIlIIIIlIlllIIIlI.registerEffect(ClientboundPackets1_15.EFFECT, 1010, 2001);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.DOUBLE, Type.FLOAT);
                this.map(Type.DOUBLE, Type.FLOAT);
                this.map(Type.DOUBLE, Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlIIlIlIllIIlIIll) throws Exception {
                        final int lllllllllllllIlIlIIlIlIllIIlIllI = lllllllllllllIlIlIIlIlIllIIlIIll.get((Type<Integer>)Type.INT, 0);
                        if (lllllllllllllIlIlIIlIlIllIIlIllI == 3 || lllllllllllllIlIlIIlIlIllIIlIllI == 23) {
                            final int lllllllllllllIlIlIIlIlIllIIllIlI = lllllllllllllIlIlIIlIlIllIIlIIll.passthrough((Type<Integer>)Type.VAR_INT);
                            lllllllllllllIlIlIIlIlIllIIlIIll.set(Type.VAR_INT, 0, ((Protocol1_14_4To1_15)BlockItemPackets1_15.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIlIlIIlIlIllIIllIlI));
                        }
                        else if (lllllllllllllIlIlIIlIlIllIIlIllI == 32) {
                            final Item lllllllllllllIlIlIIlIlIllIIllIIl = BlockItemPackets1_15.this.handleItemToClient(lllllllllllllIlIlIIlIlIllIIlIIll.read(Type.FLAT_VAR_INT_ITEM));
                            lllllllllllllIlIlIIlIlIllIIlIIll.write(Type.FLAT_VAR_INT_ITEM, lllllllllllllIlIlIIlIlIllIIllIIl);
                        }
                        final int lllllllllllllIlIlIIlIlIllIIlIlIl = ((Protocol1_14_4To1_15)BlockItemPackets1_15.this.protocol).getMappingData().getNewParticleId(lllllllllllllIlIlIIlIlIllIIlIllI);
                        if (lllllllllllllIlIlIIlIlIllIIlIllI != lllllllllllllIlIlIIlIlIllIIlIlIl) {
                            lllllllllllllIlIlIIlIlIllIIlIIll.set(Type.INT, 0, lllllllllllllIlIlIIlIlIllIIlIlIl);
                        }
                    }
                });
            }
        });
    }
    
    public BlockItemPackets1_15(final Protocol1_14_4To1_15 llllllllllllllIlIlIIIIlIlllIIlll, final TranslatableRewriter llllllllllllllIlIlIIIIlIlllIIllI) {
        super(llllllllllllllIlIlIIIIlIlllIIlll, llllllllllllllIlIlIIIIlIlllIIllI);
    }
}
