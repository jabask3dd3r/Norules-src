package com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.packets;

import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.data.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.storage.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.types.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.types.*;
import java.util.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viabackwards.protocol.protocol1_16_4to1_17.data.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.protocol.*;

public final class BlockItemPackets1_17 extends ItemRewriter<Protocol1_16_4To1_17>
{
    @Override
    protected void registerPackets() {
        final BlockRewriter lllllllllllllIIlIlIIIlllllIllIIl = new BlockRewriter(this.protocol, Type.POSITION1_14);
        new RecipeRewriter1_16(this.protocol).registerDefaultHandler(ClientboundPackets1_17.DECLARE_RECIPES);
        this.registerSetCooldown(ClientboundPackets1_17.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_17.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerSetSlot(ClientboundPackets1_17.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
        this.registerEntityEquipmentArray(ClientboundPackets1_17.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
        this.registerTradeList(ClientboundPackets1_17.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
        this.registerAdvancements(ClientboundPackets1_17.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        lllllllllllllIIlIlIIIlllllIllIIl.registerAcknowledgePlayerDigging(ClientboundPackets1_17.ACKNOWLEDGE_PLAYER_DIGGING);
        lllllllllllllIIlIlIIIlllllIllIIl.registerBlockAction(ClientboundPackets1_17.BLOCK_ACTION);
        lllllllllllllIIlIlIIIlllllIllIIl.registerEffect(ClientboundPackets1_17.EFFECT, 1010, 2001);
        this.registerCreativeInvAction(ServerboundPackets1_16_2.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this.protocol).registerServerbound(ServerboundPackets1_16_2.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lIllIIIIIIIII -> BlockItemPackets1_17.this.handleItemToServer(lIllIIIIIIIII.passthrough(Type.FLAT_VAR_INT_ITEM)));
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16_2>)this.protocol).registerServerbound(ServerboundPackets1_16_2.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT, Type.NOTHING);
                this.map(Type.VAR_INT);
                this.handler(lllllllllllllllllllIIIIIIIlIllll -> {
                    lllllllllllllllllllIIIIIIIlIllll.write(Type.VAR_INT, 0);
                    BlockItemPackets1_17.this.handleItemToServer(lllllllllllllllllllIIIIIIIlIllll.passthrough(Type.FLAT_VAR_INT_ITEM));
                });
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_17, ServerboundPackets1_16_2>)this.protocol).registerServerbound(ServerboundPackets1_16_2.WINDOW_CONFIRMATION, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                short lllllllllllllIIIIllllllllIIIIIIl;
                short lllllllllllllIIIIllllllllIIIIIII;
                boolean lllllllllllllIIIIlllllllIlllllll;
                PacketWrapper lllllllllllllIIIIllllllllIIIIIll;
                this.handler(lllllllllllllIIIIlllllllIllllllI -> {
                    lllllllllllllIIIIlllllllIllllllI.cancel();
                    if (!(!ViaBackwards.getConfig().handlePingsAsInvAcknowledgements())) {
                        lllllllllllllIIIIllllllllIIIIIIl = lllllllllllllIIIIlllllllIllllllI.read((Type<Short>)Type.UNSIGNED_BYTE);
                        lllllllllllllIIIIllllllllIIIIIII = lllllllllllllIIIIlllllllIllllllI.read((Type<Short>)Type.SHORT);
                        lllllllllllllIIIIlllllllIlllllll = lllllllllllllIIIIlllllllIllllllI.read((Type<Boolean>)Type.BOOLEAN);
                        if (lllllllllllllIIIIllllllllIIIIIIl == 0 && lllllllllllllIIIIlllllllIlllllll && lllllllllllllIIIIlllllllIllllllI.user().get(PingRequests.class).removeId(lllllllllllllIIIIllllllllIIIIIII)) {
                            lllllllllllllIIIIllllllllIIIIIll = lllllllllllllIIIIlllllllIllllllI.create(ServerboundPackets1_17.PONG);
                            lllllllllllllIIIIllllllllIIIIIll.write(Type.INT, (int)lllllllllllllIIIIllllllllIIIIIII);
                            lllllllllllllIIIIllllllllIIIIIll.sendToServer(Protocol1_16_4To1_17.class);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.SPAWN_PARTICLE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.BOOLEAN);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.DOUBLE);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.INT);
                final int lllllllllllllIIllIIllllllIIIllll;
                this.handler(lllllllllllllIIllIIllllllIIIlllI -> {
                    lllllllllllllIIllIIllllllIIIllll = lllllllllllllIIllIIllllllIIIlllI.get((Type<Integer>)Type.INT, 0);
                    if (lllllllllllllIIllIIllllllIIIllll == 16) {
                        lllllllllllllIIllIIllllllIIIlllI.passthrough((Type<Object>)Type.FLOAT);
                        lllllllllllllIIllIIllllllIIIlllI.passthrough((Type<Object>)Type.FLOAT);
                        lllllllllllllIIllIIllllllIIIlllI.passthrough((Type<Object>)Type.FLOAT);
                        lllllllllllllIIllIIllllllIIIlllI.passthrough((Type<Object>)Type.FLOAT);
                        lllllllllllllIIllIIllllllIIIlllI.read((Type<Object>)Type.FLOAT);
                        lllllllllllllIIllIIllllllIIIlllI.read((Type<Object>)Type.FLOAT);
                        lllllllllllllIIllIIllllllIIIlllI.read((Type<Object>)Type.FLOAT);
                    }
                    else if (lllllllllllllIIllIIllllllIIIllll == 37) {
                        lllllllllllllIIllIIllllllIIIlllI.cancel();
                    }
                    return;
                });
                this.handler(BlockItemPackets1_17.this.getSpawnParticleHandler(Type.FLAT_VAR_INT_ITEM));
            }
        });
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_SIZE, ClientboundPackets1_16_2.WORLD_BORDER, 0);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_LERP_SIZE, ClientboundPackets1_16_2.WORLD_BORDER, 1);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_CENTER, ClientboundPackets1_16_2.WORLD_BORDER, 2);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_INIT, ClientboundPackets1_16_2.WORLD_BORDER, 3);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_WARNING_DELAY, ClientboundPackets1_16_2.WORLD_BORDER, 4);
        ((Protocol1_16_4To1_17)this.protocol).mergePacket(ClientboundPackets1_17.WORLD_BORDER_WARNING_DISTANCE, ClientboundPackets1_16_2.WORLD_BORDER, 5);
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.UPDATE_LIGHT, new PacketRemapper() {
            private void writeLightArrays(final PacketWrapper llllllllllllllIIllIIlIIIlIIlIIIl, final BitSet llllllllllllllIIllIIlIIIlIIlIIII, final int llllllllllllllIIllIIlIIIlIIIllll, final int llllllllllllllIIllIIlIIIlIIIlllI, final int llllllllllllllIIllIIlIIIlIIIIllI) throws Exception {
                llllllllllllllIIllIIlIIIlIIlIIIl.read((Type<Object>)Type.VAR_INT);
                final List<byte[]> llllllllllllllIIllIIlIIIlIIIllII = new ArrayList<byte[]>();
                for (int llllllllllllllIIllIIlIIIlIIlIllI = 0; llllllllllllllIIllIIlIIIlIIlIllI < llllllllllllllIIllIIlIIIlIIIlllI; ++llllllllllllllIIllIIlIIIlIIlIllI) {
                    if (llllllllllllllIIllIIlIIIlIIlIIII.get(llllllllllllllIIllIIlIIIlIIlIllI)) {
                        llllllllllllllIIllIIlIIIlIIlIIIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                    }
                }
                for (int llllllllllllllIIllIIlIIIlIIlIlIl = 0; llllllllllllllIIllIIlIIIlIIlIlIl < 18; ++llllllllllllllIIllIIlIIIlIIlIlIl) {
                    if (this.isSet(llllllllllllllIIllIIlIIIlIIIllll, llllllllllllllIIllIIlIIIlIIlIlIl)) {
                        llllllllllllllIIllIIlIIIlIIIllII.add(llllllllllllllIIllIIlIIIlIIlIIIl.read(Type.BYTE_ARRAY_PRIMITIVE));
                    }
                }
                for (int llllllllllllllIIllIIlIIIlIIlIlII = llllllllllllllIIllIIlIIIlIIIlllI + 18; llllllllllllllIIllIIlIIIlIIlIlII < llllllllllllllIIllIIlIIIlIIIIllI + 2; ++llllllllllllllIIllIIlIIIlIIlIlII) {
                    if (llllllllllllllIIllIIlIIIlIIlIIII.get(llllllllllllllIIllIIlIIIlIIlIlII)) {
                        llllllllllllllIIllIIlIIIlIIlIIIl.read(Type.BYTE_ARRAY_PRIMITIVE);
                    }
                }
                for (final byte[] llllllllllllllIIllIIlIIIlIIlIIll : llllllllllllllIIllIIlIIIlIIIllII) {
                    llllllllllllllIIllIIlIIIlIIlIIIl.write(Type.BYTE_ARRAY_PRIMITIVE, llllllllllllllIIllIIlIIIlIIlIIll);
                }
            }
            
            private boolean isSet(final int llllllllllllllIIllIIlIIIIlllllll, final int llllllllllllllIIllIIlIIIIlllllII) {
                return (llllllllllllllIIllIIlIIIIlllllll & 1 << llllllllllllllIIllIIlIIIIlllllII) != 0x0;
            }
            
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN);
                final EntityTracker llllllllllllllIIllIIlIIIIllIllll;
                final int llllllllllllllIIllIIlIIIIllIlllI;
                final long[] llllllllllllllIIllIIlIIIIllIllIl;
                final long[] llllllllllllllIIllIIlIIIIllIllII;
                final int llllllllllllllIIllIIlIIIIllIlIll;
                final int llllllllllllllIIllIIlIIIIllIlIlI;
                final long[] llllllllllllllIIllIIlIIIIllIlIIl;
                final long[] llllllllllllllIIllIIlIIIIllIlIII;
                this.handler(llllllllllllllIIllIIlIIIIlllIIII -> {
                    llllllllllllllIIllIIlIIIIllIllll = llllllllllllllIIllIIlIIIIlllIIII.user().getEntityTracker(Protocol1_16_4To1_17.class);
                    llllllllllllllIIllIIlIIIIllIlllI = Math.max(0, -(llllllllllllllIIllIIlIIIIllIllll.currentMinY() >> 4));
                    llllllllllllllIIllIIlIIIIllIllIl = llllllllllllllIIllIIlIIIIlllIIII.read(Type.LONG_ARRAY_PRIMITIVE);
                    llllllllllllllIIllIIlIIIIllIllII = llllllllllllllIIllIIlIIIIlllIIII.read(Type.LONG_ARRAY_PRIMITIVE);
                    llllllllllllllIIllIIlIIIIllIlIll = BlockItemPackets1_17.this.cutLightMask(llllllllllllllIIllIIlIIIIllIllIl, llllllllllllllIIllIIlIIIIllIlllI);
                    llllllllllllllIIllIIlIIIIllIlIlI = BlockItemPackets1_17.this.cutLightMask(llllllllllllllIIllIIlIIIIllIllII, llllllllllllllIIllIIlIIIIllIlllI);
                    llllllllllllllIIllIIlIIIIlllIIII.write(Type.VAR_INT, llllllllllllllIIllIIlIIIIllIlIll);
                    llllllllllllllIIllIIlIIIIlllIIII.write(Type.VAR_INT, llllllllllllllIIllIIlIIIIllIlIlI);
                    llllllllllllllIIllIIlIIIIllIlIIl = llllllllllllllIIllIIlIIIIlllIIII.read(Type.LONG_ARRAY_PRIMITIVE);
                    llllllllllllllIIllIIlIIIIllIlIII = llllllllllllllIIllIIlIIIIlllIIII.read(Type.LONG_ARRAY_PRIMITIVE);
                    llllllllllllllIIllIIlIIIIlllIIII.write(Type.VAR_INT, BlockItemPackets1_17.this.cutLightMask(llllllllllllllIIllIIlIIIIllIlIIl, llllllllllllllIIllIIlIIIIllIlllI));
                    llllllllllllllIIllIIlIIIIlllIIII.write(Type.VAR_INT, BlockItemPackets1_17.this.cutLightMask(llllllllllllllIIllIIlIIIIllIlIII, llllllllllllllIIllIIlIIIIllIlllI));
                    this.writeLightArrays(llllllllllllllIIllIIlIIIIlllIIII, BitSet.valueOf(llllllllllllllIIllIIlIIIIllIllIl), llllllllllllllIIllIIlIIIIllIlIll, llllllllllllllIIllIIlIIIIllIlllI, llllllllllllllIIllIIlIIIIllIllll.currentWorldSectionHeight());
                    this.writeLightArrays(llllllllllllllIIllIIlIIIIlllIIII, BitSet.valueOf(llllllllllllllIIllIIlIIIIllIllII), llllllllllllllIIllIIlIIIIllIlIlI, llllllllllllllIIllIIlIIIIllIlllI, llllllllllllllIIllIIlIIIIllIllll.currentWorldSectionHeight());
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.LONG);
                this.map(Type.BOOLEAN);
                final long lllllllllllllIllIIIlIlIIIlIlIlIl;
                final int lllllllllllllIllIIIlIlIIIlIlIlII;
                long lllllllllllllIllIIIlIlIIIlIIllIl;
                BlockChangeRecord[] lllllllllllllIllIIIlIlIIIlIlIIll;
                String lllllllllllllIllIIIlIlIIIlIIllII;
                byte lllllllllllllIllIIIlIlIIIlIIlIll;
                BlockChangeRecord lllllllllllllIllIIIlIlIIIlIllIII;
                this.handler(lllllllllllllIllIIIlIlIIIlIlIllI -> {
                    lllllllllllllIllIIIlIlIIIlIlIlIl = lllllllllllllIllIIIlIlIIIlIlIllI.get((Type<Long>)Type.LONG, 0);
                    lllllllllllllIllIIIlIlIIIlIlIlII = (int)(lllllllllllllIllIIIlIlIIIlIlIlIl << 44 >> 44);
                    if (lllllllllllllIllIIIlIlIIIlIlIlII < 0 || lllllllllllllIllIIIlIlIIIlIlIlII > 15) {
                        lllllllllllllIllIIIlIlIIIlIlIllI.cancel();
                    }
                    else {
                        lllllllllllllIllIIIlIlIIIlIlIIll = (BlockChangeRecord[])(Object)(lllllllllllllIllIIIlIlIIIlIIllIl = (long)(Object)lllllllllllllIllIIIlIlIIIlIlIllI.passthrough(Type.VAR_LONG_BLOCK_CHANGE_RECORD_ARRAY));
                        for (lllllllllllllIllIIIlIlIIIlIIllII = (String)lllllllllllllIllIIIlIlIIIlIIllIl.length, lllllllllllllIllIIIlIlIIIlIIlIll = 0; lllllllllllllIllIIIlIlIIIlIIlIll < lllllllllllllIllIIIlIlIIIlIIllII; ++lllllllllllllIllIIIlIlIIIlIIlIll) {
                            lllllllllllllIllIIIlIlIIIlIllIII = lllllllllllllIllIIIlIlIIIlIIllIl[lllllllllllllIllIIIlIlIIIlIIlIll];
                            lllllllllllllIllIIIlIlIIIlIllIII.setBlockId(((Protocol1_16_4To1_17)BlockItemPackets1_17.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIllIIIlIlIIIlIllIII.getBlockId()));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14);
                this.map(Type.VAR_INT);
                final int lllllllllllllIllIIlIIlIIlIIlIIII;
                this.handler(lllllllllllllIllIIlIIlIIlIIlIIIl -> {
                    lllllllllllllIllIIlIIlIIlIIlIIII = lllllllllllllIllIIlIIlIIlIIlIIIl.get(Type.POSITION1_14, 0).getY();
                    if (lllllllllllllIllIIlIIlIIlIIlIIII < 0 || lllllllllllllIllIIlIIlIIlIIlIIII > 255) {
                        lllllllllllllIllIIlIIlIIlIIlIIIl.cancel();
                    }
                    else {
                        lllllllllllllIllIIlIIlIIlIIlIIIl.set(Type.VAR_INT, 0, ((Protocol1_16_4To1_17)BlockItemPackets1_17.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIllIIlIIlIIlIIlIIIl.get((Type<Integer>)Type.VAR_INT, 0)));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final EntityTracker lllllllllllllIIlIIIIIIllIllIIllI;
                final int lllllllllllllIIlIIIIIIllIllIIlIl;
                final Chunk lllllllllllllIIlIIIIIIllIllIIlII;
                final int lllllllllllllIIlIIIIIIllIllIIIll;
                final ChunkSection[] lllllllllllllIIlIIIIIIllIllIIIlI;
                int lllllllllllllIIlIIIIIIllIllIlIIl;
                ChunkSection lllllllllllllIIlIIIIIIllIllIlIlI;
                int lllllllllllllIIlIIIIIIllIllIlIll;
                int lllllllllllllIIlIIIIIIllIllIllII;
                this.handler(lllllllllllllIIlIIIIIIllIllIIIII -> {
                    lllllllllllllIIlIIIIIIllIllIIllI = lllllllllllllIIlIIIIIIllIllIIIII.user().getEntityTracker(Protocol1_16_4To1_17.class);
                    lllllllllllllIIlIIIIIIllIllIIlIl = lllllllllllllIIlIIIIIIllIllIIllI.currentWorldSectionHeight();
                    lllllllllllllIIlIIIIIIllIllIIlII = lllllllllllllIIlIIIIIIllIllIIIII.read((Type<Chunk>)new Chunk1_17Type(lllllllllllllIIlIIIIIIllIllIIlIl));
                    lllllllllllllIIlIIIIIIllIllIIIII.write(new Chunk1_16_2Type(), lllllllllllllIIlIIIIIIllIllIIlII);
                    lllllllllllllIIlIIIIIIllIllIIIll = Math.max(0, -(lllllllllllllIIlIIIIIIllIllIIllI.currentMinY() >> 4));
                    lllllllllllllIIlIIIIIIllIllIIlII.setBiomeData(Arrays.copyOfRange(lllllllllllllIIlIIIIIIllIllIIlII.getBiomeData(), lllllllllllllIIlIIIIIIllIllIIIll * 64, lllllllllllllIIlIIIIIIllIllIIIll * 64 + 1024));
                    lllllllllllllIIlIIIIIIllIllIIlII.setBitmask(BlockItemPackets1_17.this.cutMask(lllllllllllllIIlIIIIIIllIllIIlII.getChunkMask(), lllllllllllllIIlIIIIIIllIllIIIll, false));
                    lllllllllllllIIlIIIIIIllIllIIlII.setChunkMask(null);
                    lllllllllllllIIlIIIIIIllIllIIIlI = Arrays.copyOfRange(lllllllllllllIIlIIIIIIllIllIIlII.getSections(), lllllllllllllIIlIIIIIIllIllIIIll, lllllllllllllIIlIIIIIIllIllIIIll + 16);
                    lllllllllllllIIlIIIIIIllIllIIlII.setSections(lllllllllllllIIlIIIIIIllIllIIIlI);
                    for (lllllllllllllIIlIIIIIIllIllIlIIl = 0; lllllllllllllIIlIIIIIIllIllIlIIl < 16; ++lllllllllllllIIlIIIIIIllIllIlIIl) {
                        lllllllllllllIIlIIIIIIllIllIlIlI = lllllllllllllIIlIIIIIIllIllIIIlI[lllllllllllllIIlIIIIIIllIllIlIIl];
                        if (lllllllllllllIIlIIIIIIllIllIlIlI != null) {
                            for (lllllllllllllIIlIIIIIIllIllIlIll = 0; lllllllllllllIIlIIIIIIllIllIlIll < lllllllllllllIIlIIIIIIllIllIlIlI.getPaletteSize(); ++lllllllllllllIIlIIIIIIllIllIlIll) {
                                lllllllllllllIIlIIIIIIllIllIllII = lllllllllllllIIlIIIIIIllIllIlIlI.getPaletteEntry(lllllllllllllIIlIIIIIIllIllIlIll);
                                lllllllllllllIIlIIIIIIllIllIlIlI.setPaletteEntry(lllllllllllllIIlIIIIIIllIllIlIll, ((Protocol1_16_4To1_17)BlockItemPackets1_17.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIlIIIIIIllIllIllII));
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllllIIIIIlllllIIIIlll;
                this.handler(lllllllllllllllIIIIIlllllIIIIllI -> {
                    lllllllllllllllIIIIIlllllIIIIlll = lllllllllllllllIIIIIlllllIIIIllI.passthrough(Type.POSITION1_14).getY();
                    if (lllllllllllllllIIIIIlllllIIIIlll < 0 || lllllllllllllllIIIIIlllllIIIIlll > 255) {
                        lllllllllllllllIIIIIlllllIIIIllI.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.BLOCK_BREAK_ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final int llllllllllllllIlIIIIIllIIIIlIIlI;
                this.handler(llllllllllllllIlIIIIIllIIIIlIIll -> {
                    llllllllllllllIlIIIIIllIIIIlIIlI = llllllllllllllIlIIIIIllIIIIlIIll.passthrough(Type.POSITION1_14).getY();
                    if (llllllllllllllIlIIIIIllIIIIlIIlI < 0 || llllllllllllllIlIIIIIllIIIIlIIlI > 255) {
                        llllllllllllllIlIIIIIllIIIIlIIll.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_17, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_17.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.handler(lllllllllllllIIllIlIlIlIIllIIIIl -> lllllllllllllIIllIlIlIlIIllIIIIl.write(Type.BOOLEAN, true));
                this.map(Type.BOOLEAN);
                final boolean lllllllllllllIIllIlIlIlIIllIIllI;
                this.handler(lllllllllllllIIllIlIlIlIIllIIlll -> {
                    lllllllllllllIIllIlIlIlIIllIIllI = lllllllllllllIIllIlIlIlIIllIIlll.read((Type<Boolean>)Type.BOOLEAN);
                    if (!lllllllllllllIIllIlIlIlIIllIIllI) {
                        lllllllllllllIIllIlIlIlIIllIIlll.write(Type.VAR_INT, 0);
                    }
                    else {
                        MapColorRewriter.getRewriteHandler(MapColorRewrites::getMappedColor).handle(lllllllllllllIIllIlIlIlIIllIIlll);
                    }
                });
            }
        });
    }
    
    private int cutMask(final BitSet lllllllllllllIIlIlIIIlllllIIIIll, final int lllllllllllllIIlIlIIIlllllIIIIlI, final boolean lllllllllllllIIlIlIIIlllllIIIIIl) {
        int lllllllllllllIIlIlIIIlllllIIIIII = 0;
        for (int lllllllllllllIIlIlIIIllllIllllll = lllllllllllllIIlIlIIIlllllIIIIlI + (lllllllllllllIIlIlIIIlllllIIIIIl ? 18 : 16), lllllllllllllIIlIlIIIlllllIIIllI = lllllllllllllIIlIlIIIlllllIIIIlI, lllllllllllllIIlIlIIIlllllIIIlIl = 0; lllllllllllllIIlIlIIIlllllIIIllI < lllllllllllllIIlIlIIIllllIllllll; ++lllllllllllllIIlIlIIIlllllIIIllI, ++lllllllllllllIIlIlIIIlllllIIIlIl) {
            if (lllllllllllllIIlIlIIIlllllIIIIll.get(lllllllllllllIIlIlIIIlllllIIIllI)) {
                lllllllllllllIIlIlIIIlllllIIIIII |= 1 << lllllllllllllIIlIlIIIlllllIIIlIl;
            }
        }
        return lllllllllllllIIlIlIIIlllllIIIIII;
    }
    
    private int cutLightMask(final long[] lllllllllllllIIlIlIIIlllllIIllll, final int lllllllllllllIIlIlIIIlllllIIlllI) {
        if (lllllllllllllIIlIlIIIlllllIIllll.length == 0) {
            return 0;
        }
        return this.cutMask(BitSet.valueOf(lllllllllllllIIlIlIIIlllllIIllll), lllllllllllllIIlIlIIIlllllIIlllI, true);
    }
    
    public BlockItemPackets1_17(final Protocol1_16_4To1_17 lllllllllllllIIlIlIIIllllllIIIIl, final TranslatableRewriter lllllllllllllIIlIlIIIlllllIlllIl) {
        super(lllllllllllllIIlIlIIIllllllIIIIl, lllllllllllllIIlIlIIIlllllIlllIl);
    }
}
