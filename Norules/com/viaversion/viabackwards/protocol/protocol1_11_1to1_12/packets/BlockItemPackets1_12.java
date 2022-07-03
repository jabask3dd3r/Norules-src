package com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.packets;

import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viabackwards.protocol.protocol1_11_1to1_12.data.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.*;
import com.viaversion.viaversion.api.minecraft.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.*;

public class BlockItemPackets1_12 extends LegacyBlockItemRewriter<Protocol1_11_1To1_12>
{
    @Override
    public Item handleItemToServer(final Item llllllllllllllIlIIlllIlIlIIIllIl) {
        if (llllllllllllllIlIIlllIlIlIIIllIl == null) {
            return null;
        }
        super.handleItemToServer(llllllllllllllIlIIlllIlIlIIIllIl);
        if (llllllllllllllIlIIlllIlIlIIIllIl.tag() != null) {
            final Tag llllllllllllllIlIIlllIlIlIIIllll = llllllllllllllIlIIlllIlIlIIIllIl.tag().remove("Via|LongArrayTags");
            if (llllllllllllllIlIIlllIlIlIIIllll instanceof CompoundTag) {
                this.handleNbtToServer(llllllllllllllIlIIlllIlIlIIIllIl.tag(), (CompoundTag)llllllllllllllIlIIlllIlIlIIIllll);
            }
        }
        return llllllllllllllIlIIlllIlIlIIIllIl;
    }
    
    private void handleNbtToServer(final CompoundTag llllllllllllllIlIIlllIlIIlllllIl, final CompoundTag llllllllllllllIlIIlllIlIIlllllII) {
        for (final Map.Entry<String, Tag> llllllllllllllIlIIlllIlIlIIIIIlI : llllllllllllllIlIIlllIlIIlllllII) {
            if (llllllllllllllIlIIlllIlIlIIIIIlI.getValue() instanceof CompoundTag) {
                final CompoundTag llllllllllllllIlIIlllIlIlIIIIIll = llllllllllllllIlIIlllIlIIlllllIl.get(llllllllllllllIlIIlllIlIlIIIIIlI.getKey());
                this.handleNbtToServer(llllllllllllllIlIIlllIlIlIIIIIll, llllllllllllllIlIIlllIlIlIIIIIlI.getValue());
            }
            else {
                llllllllllllllIlIIlllIlIIlllllIl.put(llllllllllllllIlIIlllIlIlIIIIIlI.getKey(), this.fromIntArrayTag(llllllllllllllIlIIlllIlIlIIIIIlI.getValue()));
            }
        }
    }
    
    private LongArrayTag fromIntArrayTag(final IntArrayTag llllllllllllllIlIIlllIlIIlIllIlI) {
        final long[] llllllllllllllIlIIlllIlIIlIllIIl = new long[llllllllllllllIlIIlllIlIIlIllIlI.length() / 2];
        final int[] llllllllllllllIlIIlllIlIIlIllIII = llllllllllllllIlIIlllIlIIlIllIlI.getValue();
        for (int llllllllllllllIlIIlllIlIIlIlllIl = 0, llllllllllllllIlIIlllIlIIlIlllII = 0; llllllllllllllIlIIlllIlIIlIlllIl < llllllllllllllIlIIlllIlIIlIllIII.length; llllllllllllllIlIIlllIlIIlIlllIl += 2, ++llllllllllllllIlIIlllIlIIlIlllII) {
            llllllllllllllIlIIlllIlIIlIllIIl[llllllllllllllIlIIlllIlIIlIlllII] = ((long)llllllllllllllIlIIlllIlIIlIllIII[llllllllllllllIlIIlllIlIIlIlllIl] << 32 | ((long)llllllllllllllIlIIlllIlIIlIllIII[llllllllllllllIlIIlllIlIIlIlllIl + 1] & 0xFFFFFFFFL));
        }
        return new LongArrayTag(llllllllllllllIlIIlllIlIIlIllIIl);
    }
    
    public BlockItemPackets1_12(final Protocol1_11_1To1_12 llllllllllllllIlIIlllIlIlIllIlII) {
        super(llllllllllllllIlIIlllIlIlIllIlII);
    }
    
    @Override
    public Item handleItemToClient(final Item llllllllllllllIlIIlllIlIlIlIlIIl) {
        if (llllllllllllllIlIIlllIlIlIlIlIIl == null) {
            return null;
        }
        super.handleItemToClient(llllllllllllllIlIIlllIlIlIlIlIIl);
        if (llllllllllllllIlIIlllIlIlIlIlIIl.tag() != null) {
            final CompoundTag llllllllllllllIlIIlllIlIlIlIllIl = new CompoundTag();
            if (this.handleNbtToClient(llllllllllllllIlIIlllIlIlIlIlIIl.tag(), llllllllllllllIlIIlllIlIlIlIllIl)) {
                llllllllllllllIlIIlllIlIlIlIlIIl.tag().put("Via|LongArrayTags", llllllllllllllIlIIlllIlIlIlIllIl);
            }
        }
        return llllllllllllllIlIIlllIlIlIlIlIIl;
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIIlIlllllIlIIIlI) throws Exception {
                        for (int lllllllllllllllIIIlIlllllIlIIIll = lllllllllllllllIIIlIlllllIlIIIlI.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllllIIIlIlllllIlIIllI = 0; lllllllllllllllIIIlIlllllIlIIllI < lllllllllllllllIIIlIlllllIlIIIll * 3; ++lllllllllllllllIIIlIlllllIlIIllI) {
                            lllllllllllllllIIIlIlllllIlIIIlI.passthrough((Type<Object>)Type.BYTE);
                        }
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllllllIIIlllllIlll) throws Exception {
                        final short lllllllllllllIllllllIIIllllllIlI = lllllllllllllIllllllIIIlllllIlll.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                        if (lllllllllllllIllllllIIIllllllIlI <= 0) {
                            return;
                        }
                        final short lllllllllllllIllllllIIIllllllIIl = lllllllllllllIllllllIIIlllllIlll.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                        lllllllllllllIllllllIIIlllllIlll.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                        lllllllllllllIllllllIIIlllllIlll.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                        final byte[] lllllllllllllIllllllIIIllllllIII = lllllllllllllIllllllIIIlllllIlll.read(Type.BYTE_ARRAY_PRIMITIVE);
                        for (int lllllllllllllIllllllIIIlllllllIl = 0; lllllllllllllIllllllIIIlllllllIl < lllllllllllllIllllllIIIllllllIII.length; ++lllllllllllllIllllllIIIlllllllIl) {
                            short lllllllllllllIllllllIIIllllllllI = (short)(lllllllllllllIllllllIIIllllllIII[lllllllllllllIllllllIIIlllllllIl] & 0xFF);
                            if (lllllllllllllIllllllIIIllllllllI > 143) {
                                lllllllllllllIllllllIIIllllllllI = (short)MapColorMapping.getNearestOldColor(lllllllllllllIllllllIIIllllllllI);
                                lllllllllllllIllllllIIIllllllIII[lllllllllllllIllllllIIIlllllllIl] = (byte)lllllllllllllIllllllIIIllllllllI;
                            }
                        }
                        lllllllllllllIllllllIIIlllllIlll.write(Type.BYTE_ARRAY_PRIMITIVE, lllllllllllllIllllllIIIllllllIII);
                    }
                });
            }
        });
        this.registerSetSlot(ClientboundPackets1_12.SET_SLOT, Type.ITEM);
        this.registerWindowItems(ClientboundPackets1_12.WINDOW_ITEMS, Type.ITEM_ARRAY);
        this.registerEntityEquipment(ClientboundPackets1_12.ENTITY_EQUIPMENT, Type.ITEM);
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIIlIIllIIIllllIl) throws Exception {
                        if (lllllllllllllIlIIIlIIllIIIllllIl.get(Type.STRING, 0).equalsIgnoreCase("MC|TrList")) {
                            lllllllllllllIlIIIlIIllIIIllllIl.passthrough((Type<Object>)Type.INT);
                            for (int lllllllllllllIlIIIlIIllIIlIIIIIl = lllllllllllllIlIIIlIIllIIIllllIl.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIlIIIlIIllIIlIIIIlI = 0; lllllllllllllIlIIIlIIllIIlIIIIlI < lllllllllllllIlIIIlIIllIIlIIIIIl; ++lllllllllllllIlIIIlIIllIIlIIIIlI) {
                                lllllllllllllIlIIIlIIllIIIllllIl.write(Type.ITEM, BlockItemPackets1_12.this.handleItemToClient(lllllllllllllIlIIIlIIllIIIllllIl.read(Type.ITEM)));
                                lllllllllllllIlIIIlIIllIIIllllIl.write(Type.ITEM, BlockItemPackets1_12.this.handleItemToClient(lllllllllllllIlIIIlIIllIIIllllIl.read(Type.ITEM)));
                                final boolean lllllllllllllIlIIIlIIllIIlIIIIll = lllllllllllllIlIIIlIIllIIIllllIl.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllIlIIIlIIllIIlIIIIll) {
                                    lllllllllllllIlIIIlIIllIIIllllIl.write(Type.ITEM, BlockItemPackets1_12.this.handleItemToClient(lllllllllllllIlIIIlIIllIIIllllIl.read(Type.ITEM)));
                                }
                                lllllllllllllIlIIIlIIllIIIllllIl.passthrough((Type<Object>)Type.BOOLEAN);
                                lllllllllllllIlIIIlIIllIIIllllIl.passthrough((Type<Object>)Type.INT);
                                lllllllllllllIlIIIlIIllIIIllllIl.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9_3>)this.protocol).registerServerbound(ServerboundPackets1_9_3.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.VAR_INT);
                this.map(Type.ITEM);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllIIllIlIIIIlIIlI) throws Exception {
                        if (lllllllllllllllllIIllIlIIIIlIIlI.get((Type<Integer>)Type.VAR_INT, 0) == 1) {
                            lllllllllllllllllIIllIlIIIIlIIlI.set(Type.ITEM, 0, null);
                            final PacketWrapper lllllllllllllllllIIllIlIIIIlIlll = lllllllllllllllllIIllIlIIIIlIIlI.create(ServerboundPackets1_12.WINDOW_CONFIRMATION);
                            lllllllllllllllllIIllIlIIIIlIlll.write(Type.UNSIGNED_BYTE, (Short)lllllllllllllllllIIllIlIIIIlIIlI.get((Type<T>)Type.UNSIGNED_BYTE, 0));
                            lllllllllllllllllIIllIlIIIIlIlll.write(Type.SHORT, (Short)lllllllllllllllllIIllIlIIIIlIIlI.get((Type<T>)Type.SHORT, 1));
                            lllllllllllllllllIIllIlIIIIlIlll.write(Type.BOOLEAN, false);
                            lllllllllllllllllIIllIlIIIIlIIlI.sendToServer(Protocol1_11_1To1_12.class);
                            lllllllllllllllllIIllIlIIIIlIIlI.cancel();
                            lllllllllllllllllIIllIlIIIIlIlll.sendToServer(Protocol1_11_1To1_12.class);
                            return;
                        }
                        final Item lllllllllllllllllIIllIlIIIIlIlII = lllllllllllllllllIIllIlIIIIlIIlI.get(Type.ITEM, 0);
                        BlockItemPackets1_12.this.handleItemToServer(lllllllllllllllllIIllIlIIIIlIlII);
                    }
                });
            }
        });
        this.registerCreativeInvAction(ServerboundPackets1_9_3.CREATIVE_INVENTORY_ACTION, Type.ITEM);
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlIIlIllllIlllIlI) throws Exception {
                        final ClientWorld lllllllllllllIIIlIIlIllllIlllIIl = lllllllllllllIIIlIIlIllllIlllIlI.user().get(ClientWorld.class);
                        final Chunk1_9_3_4Type lllllllllllllIIIlIIlIllllIlllIII = new Chunk1_9_3_4Type(lllllllllllllIIIlIIlIllllIlllIIl);
                        final Chunk lllllllllllllIIIlIIlIllllIllIlll = lllllllllllllIIIlIIlIllllIlllIlI.passthrough((Type<Chunk>)lllllllllllllIIIlIIlIllllIlllIII);
                        LegacyBlockItemRewriter.this.handleChunk(lllllllllllllIIIlIIlIllllIllIlll);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIllIIIIIIIlIIII) throws Exception {
                        final int lllllllllllllIIIIIllIIIIIIIlIIlI = lllllllllllllIIIIIllIIIIIIIlIIII.get((Type<Integer>)Type.VAR_INT, 0);
                        lllllllllllllIIIIIllIIIIIIIlIIII.set(Type.VAR_INT, 0, BlockItemPackets1_12.this.handleBlockID(lllllllllllllIIIIIllIIIIIIIlIIlI));
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.MULTI_BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.INT);
                this.map(Type.BLOCK_CHANGE_RECORD_ARRAY);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIIIIlIIlllIIlllI) throws Exception {
                        final short lllllllllllllIIIIIIIlIIlllIIlIII = lllllllllllllIIIIIIIlIIlllIIlllI.get((Type<Short>)Type.BLOCK_CHANGE_RECORD_ARRAY, 0);
                        final byte lllllllllllllIIIIIIIlIIlllIIIllI = (byte)lllllllllllllIIIIIIIlIIlllIIlIII.length;
                        for (short lllllllllllllIIIIIIIlIIlllIIIlII = 0; lllllllllllllIIIIIIIlIIlllIIIlII < lllllllllllllIIIIIIIlIIlllIIIllI; ++lllllllllllllIIIIIIIlIIlllIIIlII) {
                            final BlockChangeRecord lllllllllllllIIIIIIIlIIlllIlIIlI = lllllllllllllIIIIIIIlIIlllIIlIII[lllllllllllllIIIIIIIlIIlllIIIlII];
                            lllllllllllllIIIIIIIlIIlllIlIIlI.setBlockId(BlockItemPackets1_12.this.handleBlockID(lllllllllllllIIIIIIIlIIlllIlIIlI.getBlockId()));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIlIllllllllIIlII) throws Exception {
                        if (lllllllllllllIIIIlIllllllllIIlII.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 11) {
                            lllllllllllllIIIIlIllllllllIIlII.cancel();
                        }
                    }
                });
            }
        });
        ((Protocol1_11_1To1_12)this.protocol).getEntityRewriter().filter().handler((llllllllllllllIlIIlllIlIIlIIllll, llllllllllllllIlIIlllIlIIlIIlllI) -> {
            if (llllllllllllllIlIIlllIlIIlIIlllI.metaType().type().equals(Type.ITEM)) {
                llllllllllllllIlIIlllIlIIlIIlllI.setValue(this.handleItemToClient((Item)llllllllllllllIlIIlllIlIIlIIlllI.getValue()));
            }
            return;
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9_3>)this.protocol).registerServerbound(ServerboundPackets1_9_3.CLIENT_STATUS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllllIlllIlIlllllIl) throws Exception {
                        if (llllllllllllllllllIlllIlIlllllIl.get((Type<Integer>)Type.VAR_INT, 0) == 2) {
                            llllllllllllllllllIlllIlIlllllIl.cancel();
                        }
                    }
                });
            }
        });
    }
    
    private IntArrayTag fromLongArrayTag(final LongArrayTag llllllllllllllIlIIlllIlIIllIlIlI) {
        final int[] llllllllllllllIlIIlllIlIIllIllIl = new int[llllllllllllllIlIIlllIlIIllIlIlI.length() * 2];
        final long[] llllllllllllllIlIIlllIlIIllIllII = llllllllllllllIlIIlllIlIIllIlIlI.getValue();
        int llllllllllllllIlIIlllIlIIllIlIll = 0;
        final float llllllllllllllIlIIlllIlIIllIIllI = (Object)llllllllllllllIlIIlllIlIIllIllII;
        final Exception llllllllllllllIlIIlllIlIIllIIlIl = (Exception)llllllllllllllIlIIlllIlIIllIIllI.length;
        for (long llllllllllllllIlIIlllIlIIllIIlII = 0; llllllllllllllIlIIlllIlIIllIIlII < llllllllllllllIlIIlllIlIIllIIlIl; ++llllllllllllllIlIIlllIlIIllIIlII) {
            final long llllllllllllllIlIIlllIlIIlllIIII = llllllllllllllIlIIlllIlIIllIIllI[llllllllllllllIlIIlllIlIIllIIlII];
            llllllllllllllIlIIlllIlIIllIllIl[llllllllllllllIlIIlllIlIIllIlIll++] = (int)(llllllllllllllIlIIlllIlIIlllIIII >> 32);
            llllllllllllllIlIIlllIlIIllIllIl[llllllllllllllIlIIlllIlIIllIlIll++] = (int)llllllllllllllIlIIlllIlIIlllIIII;
        }
        return new IntArrayTag(llllllllllllllIlIIlllIlIIllIllIl);
    }
    
    private boolean handleNbtToClient(final CompoundTag llllllllllllllIlIIlllIlIlIIllIII, final CompoundTag llllllllllllllIlIIlllIlIlIIlIlll) {
        final Iterator<Map.Entry<String, Tag>> llllllllllllllIlIIlllIlIlIIllIll = llllllllllllllIlIIlllIlIlIIllIII.iterator();
        boolean llllllllllllllIlIIlllIlIlIIllIlI = false;
        while (llllllllllllllIlIIlllIlIlIIllIll.hasNext()) {
            final Map.Entry<String, Tag> llllllllllllllIlIIlllIlIlIIlllll = llllllllllllllIlIIlllIlIlIIllIll.next();
            if (llllllllllllllIlIIlllIlIlIIlllll.getValue() instanceof CompoundTag) {
                final CompoundTag llllllllllllllIlIIlllIlIlIlIIIII = new CompoundTag();
                llllllllllllllIlIIlllIlIlIIlIlll.put(llllllllllllllIlIIlllIlIlIIlllll.getKey(), llllllllllllllIlIIlllIlIlIlIIIII);
                llllllllllllllIlIIlllIlIlIIllIlI |= this.handleNbtToClient(llllllllllllllIlIIlllIlIlIIlllll.getValue(), llllllllllllllIlIIlllIlIlIlIIIII);
            }
            else {
                if (!(llllllllllllllIlIIlllIlIlIIlllll.getValue() instanceof LongArrayTag)) {
                    continue;
                }
                llllllllllllllIlIIlllIlIlIIlIlll.put(llllllllllllllIlIIlllIlIlIIlllll.getKey(), this.fromLongArrayTag(llllllllllllllIlIIlllIlIlIIlllll.getValue()));
                llllllllllllllIlIIlllIlIlIIllIll.remove();
                llllllllllllllIlIIlllIlIlIIllIlI = true;
            }
        }
        return llllllllllllllIlIIlllIlIlIIllIlI;
    }
}
