package com.viaversion.viabackwards.protocol.protocol1_10to1_11.packets;

import com.viaversion.viabackwards.protocol.protocol1_10to1_11.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9_1_2to1_9_3_4.types.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.*;
import com.viaversion.viabackwards.protocol.protocol1_10to1_11.storage.*;
import com.viaversion.viabackwards.api.data.*;
import com.viaversion.viaversion.api.connection.*;
import com.viaversion.viaversion.api.data.entity.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.*;

public class BlockItemPackets1_11 extends LegacyBlockItemRewriter<Protocol1_10To1_11>
{
    private /* synthetic */ LegacyEnchantmentRewriter enchantmentRewriter;
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.ITEM);
                this.handler(BlockItemPackets1_11.this.itemToClientHandler(Type.ITEM));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIlIIllIlIlIIllIl) throws Exception {
                        if (BlockItemPackets1_11.this.isLlama(lllllllllllllllIIlIIllIlIlIIllIl.user())) {
                            final Optional<ChestedHorseStorage> lllllllllllllllIIlIIllIlIlIlIIIl = BlockItemPackets1_11.this.getChestedHorse(lllllllllllllllIIlIIllIlIlIIllIl.user());
                            if (!lllllllllllllllIIlIIllIlIlIlIIIl.isPresent()) {
                                return;
                            }
                            final ChestedHorseStorage lllllllllllllllIIlIIllIlIlIlIIII = lllllllllllllllIIlIIllIlIlIlIIIl.get();
                            int lllllllllllllllIIlIIllIlIlIIllll = lllllllllllllllIIlIIllIlIlIIllIl.get((Type<Short>)Type.SHORT, 0);
                            lllllllllllllllIIlIIllIlIlIIllIl.set(Type.SHORT, 0, (lllllllllllllllIIlIIllIlIlIIllll = BlockItemPackets1_11.this.getNewSlotId(lllllllllllllllIIlIIllIlIlIlIIII, lllllllllllllllIIlIIllIlIlIIllll)).shortValue());
                            lllllllllllllllIIlIIllIlIlIIllIl.set(Type.ITEM, 0, BlockItemPackets1_11.this.getNewItem(lllllllllllllllIIlIIllIlIlIlIIII, lllllllllllllllIIlIIllIlIlIIllll, lllllllllllllllIIlIIllIlIlIIllIl.get(Type.ITEM, 0)));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.ITEM_ARRAY);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIlIllllIllIlIlII) throws Exception {
                        Item[] lllllllllllllIlIIlIllllIllIlIIll = lllllllllllllIlIIlIllllIllIlIlII.get(Type.ITEM_ARRAY, 0);
                        for (int lllllllllllllIlIIlIllllIllIllIIl = 0; lllllllllllllIlIIlIllllIllIllIIl < lllllllllllllIlIIlIllllIllIlIIll.length; ++lllllllllllllIlIIlIllllIllIllIIl) {
                            lllllllllllllIlIIlIllllIllIlIIll[lllllllllllllIlIIlIllllIllIllIIl] = BlockItemPackets1_11.this.handleItemToClient(lllllllllllllIlIIlIllllIllIlIIll[lllllllllllllIlIIlIllllIllIllIIl]);
                        }
                        if (BlockItemPackets1_11.this.isLlama(lllllllllllllIlIIlIllllIllIlIlII.user())) {
                            final Optional<ChestedHorseStorage> lllllllllllllIlIIlIllllIllIlIlll = BlockItemPackets1_11.this.getChestedHorse(lllllllllllllIlIIlIllllIllIlIlII.user());
                            if (!lllllllllllllIlIIlIllllIllIlIlll.isPresent()) {
                                return;
                            }
                            final ChestedHorseStorage lllllllllllllIlIIlIllllIllIlIllI = lllllllllllllIlIIlIllllIllIlIlll.get();
                            lllllllllllllIlIIlIllllIllIlIIll = Arrays.copyOf(lllllllllllllIlIIlIllllIllIlIIll, lllllllllllllIlIIlIllllIllIlIllI.isChested() ? 53 : 38);
                            for (int lllllllllllllIlIIlIllllIllIllIII = lllllllllllllIlIIlIllllIllIlIIll.length - 1; lllllllllllllIlIIlIllllIllIllIII >= 0; --lllllllllllllIlIIlIllllIllIllIII) {
                                lllllllllllllIlIIlIllllIllIlIIll[BlockItemPackets1_11.this.getNewSlotId(lllllllllllllIlIIlIllllIllIlIllI, lllllllllllllIlIIlIllllIllIllIII)] = lllllllllllllIlIIlIllllIllIlIIll[lllllllllllllIlIIlIllllIllIllIII];
                                lllllllllllllIlIIlIllllIllIlIIll[lllllllllllllIlIIlIllllIllIllIII] = BlockItemPackets1_11.this.getNewItem(lllllllllllllIlIIlIllllIllIlIllI, lllllllllllllIlIIlIllllIllIllIII, lllllllllllllIlIIlIllllIllIlIIll[lllllllllllllIlIIlIllllIllIllIII]);
                            }
                            lllllllllllllIlIIlIllllIllIlIlII.set(Type.ITEM_ARRAY, 0, lllllllllllllIlIIlIllllIllIlIIll);
                        }
                    }
                });
            }
        });
        this.registerEntityEquipment(ClientboundPackets1_9_3.ENTITY_EQUIPMENT, Type.ITEM);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIllIIlllIllllllI) throws Exception {
                        if (llllllllllllllllIllIIlllIllllllI.get(Type.STRING, 0).equalsIgnoreCase("MC|TrList")) {
                            llllllllllllllllIllIIlllIllllllI.passthrough((Type<Object>)Type.INT);
                            for (int llllllllllllllllIllIIllllIIIIIlI = llllllllllllllllIllIIlllIllllllI.passthrough((Type<Short>)Type.UNSIGNED_BYTE), llllllllllllllllIllIIllllIIIIIll = 0; llllllllllllllllIllIIllllIIIIIll < llllllllllllllllIllIIllllIIIIIlI; ++llllllllllllllllIllIIllllIIIIIll) {
                                llllllllllllllllIllIIlllIllllllI.write(Type.ITEM, BlockItemPackets1_11.this.handleItemToClient(llllllllllllllllIllIIlllIllllllI.read(Type.ITEM)));
                                llllllllllllllllIllIIlllIllllllI.write(Type.ITEM, BlockItemPackets1_11.this.handleItemToClient(llllllllllllllllIllIIlllIllllllI.read(Type.ITEM)));
                                final boolean llllllllllllllllIllIIllllIIIIlII = llllllllllllllllIllIIlllIllllllI.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (llllllllllllllllIllIIllllIIIIlII) {
                                    llllllllllllllllIllIIlllIllllllI.write(Type.ITEM, BlockItemPackets1_11.this.handleItemToClient(llllllllllllllllIllIIlllIllllllI.read(Type.ITEM)));
                                }
                                llllllllllllllllIllIIlllIllllllI.passthrough((Type<Object>)Type.BOOLEAN);
                                llllllllllllllllIllIIlllIllllllI.passthrough((Type<Object>)Type.INT);
                                llllllllllllllllIllIIlllIllllllI.passthrough((Type<Object>)Type.INT);
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
                this.handler(BlockItemPackets1_11.this.itemToServerHandler(Type.ITEM));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlllIIIIlIlIIIllIII) throws Exception {
                        if (BlockItemPackets1_11.this.isLlama(lllllllllllllIlllIIIIlIlIIIllIII.user())) {
                            final Optional<ChestedHorseStorage> lllllllllllllIlllIIIIlIlIIIlllll = BlockItemPackets1_11.this.getChestedHorse(lllllllllllllIlllIIIIlIlIIIllIII.user());
                            if (!lllllllllllllIlllIIIIlIlIIIlllll.isPresent()) {
                                return;
                            }
                            final ChestedHorseStorage lllllllllllllIlllIIIIlIlIIIllllI = lllllllllllllIlllIIIIlIlIIIlllll.get();
                            final int lllllllllllllIlllIIIIlIlIIIlllIl = lllllllllllllIlllIIIIlIlIIIllIII.get((Type<Short>)Type.SHORT, 0);
                            final int lllllllllllllIlllIIIIlIlIIIlllII = BlockItemPackets1_11.this.getOldSlotId(lllllllllllllIlllIIIIlIlIIIllllI, lllllllllllllIlllIIIIlIlIIIlllIl);
                            lllllllllllllIlllIIIIlIlIIIllIII.set(Type.SHORT, 0, lllllllllllllIlllIIIIlIlIIIlllII.shortValue());
                        }
                    }
                });
            }
        });
        this.registerCreativeInvAction(ServerboundPackets1_9_3.CREATIVE_INVENTORY_ACTION, Type.ITEM);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIlllIIlIllIllIlIl) throws Exception {
                        final ClientWorld llllllllllllllIIlllIIlIllIlllIIl = llllllllllllllIIlllIIlIllIllIlIl.user().get(ClientWorld.class);
                        final Chunk1_9_3_4Type llllllllllllllIIlllIIlIllIlllIII = new Chunk1_9_3_4Type(llllllllllllllIIlllIIlIllIlllIIl);
                        final Chunk llllllllllllllIIlllIIlIllIllIlll = llllllllllllllIIlllIIlIllIllIlIl.passthrough((Type<Chunk>)llllllllllllllIIlllIIlIllIlllIII);
                        LegacyBlockItemRewriter.this.handleChunk(llllllllllllllIIlllIIlIllIllIlll);
                        for (final CompoundTag llllllllllllllIIlllIIlIllIllllII : llllllllllllllIIlllIIlIllIllIlll.getBlockEntities()) {
                            final Tag llllllllllllllIIlllIIlIllIlllllI = llllllllllllllIIlllIIlIllIllllII.get("id");
                            if (!(llllllllllllllIIlllIIlIllIlllllI instanceof StringTag)) {
                                continue;
                            }
                            final String llllllllllllllIIlllIIlIllIllllIl = (String)llllllllllllllIIlllIIlIllIlllllI.getValue();
                            if (!llllllllllllllIIlllIIlIllIllllIl.equals("minecraft:sign")) {
                                continue;
                            }
                            ((StringTag)llllllllllllllIIlllIIlIllIlllllI).setValue("Sign");
                        }
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
                    public void handle(final PacketWrapper llllllllllllllIIIllIlIIllIIIllIl) throws Exception {
                        final int llllllllllllllIIIllIlIIllIIIllII = llllllllllllllIIIllIlIIllIIIllIl.get((Type<Integer>)Type.VAR_INT, 0);
                        llllllllllllllIIIllIlIIllIIIllIl.set(Type.VAR_INT, 0, BlockItemPackets1_11.this.handleBlockID(llllllllllllllIIIllIlIIllIIIllII));
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
                    public void handle(final PacketWrapper llllllllllllllIlllIIlIIIllIIllII) throws Exception {
                        final boolean llllllllllllllIlllIIlIIIllIIlIIl = llllllllllllllIlllIIlIIIllIIllII.get((Type<Boolean>)Type.BLOCK_CHANGE_RECORD_ARRAY, 0);
                        final short llllllllllllllIlllIIlIIIllIIlIII = (short)llllllllllllllIlllIIlIIIllIIlIIl.length;
                        for (final BlockChangeRecord llllllllllllllIlllIIlIIIllIIlllI : llllllllllllllIlllIIlIIIllIIlIIl) {
                            llllllllllllllIlllIIlIIIllIIlllI.setBlockId(BlockItemPackets1_11.this.handleBlockID(llllllllllllllIlllIIlIIIllIIlllI.getBlockId()));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.NBT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIIIlIIIIIIlIIlII) throws Exception {
                        if (llllllllllllllIlIIIlIIIIIIlIIlII.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 10) {
                            llllllllllllllIlIIIlIIIIIIlIIlII.cancel();
                        }
                        if (llllllllllllllIlIIIlIIIIIIlIIlII.get((Type<Short>)Type.UNSIGNED_BYTE, 0) == 1) {
                            final CompoundTag llllllllllllllIlIIIlIIIIIIlIlIII = llllllllllllllIlIIIlIIIIIIlIIlII.get(Type.NBT, 0);
                            EntityIdRewriter.toClientSpawner(llllllllllllllIlIIIlIIIIIIlIlIII, true);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.map(Type.COMPONENT);
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIlIlIlIlIIIIlllI) throws Exception {
                        int lllllllllllllIllIlIlIlIlIIIIllIl = -1;
                        if (lllllllllllllIllIlIlIlIlIIIIlllI.get(Type.STRING, 0).equals("EntityHorse")) {
                            lllllllllllllIllIlIlIlIlIIIIllIl = lllllllllllllIllIlIlIlIlIIIIlllI.passthrough((Type<Integer>)Type.INT);
                        }
                        final String lllllllllllllIllIlIlIlIlIIIIllII = lllllllllllllIllIlIlIlIlIIIIlllI.get(Type.STRING, 0);
                        final WindowTracker lllllllllllllIllIlIlIlIlIIIIlIll = lllllllllllllIllIlIlIlIlIIIIlllI.user().get(WindowTracker.class);
                        lllllllllllllIllIlIlIlIlIIIIlIll.setInventory(lllllllllllllIllIlIlIlIlIIIIllII);
                        lllllllllllllIllIlIlIlIlIIIIlIll.setEntityId(lllllllllllllIllIlIlIlIlIIIIllIl);
                        if (BlockItemPackets1_11.this.isLlama(lllllllllllllIllIlIlIlIlIIIIlllI.user())) {
                            lllllllllllllIllIlIlIlIlIIIIlllI.set(Type.UNSIGNED_BYTE, 1, (Short)17);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllllIlIlIlIIIIllI) throws Exception {
                        final WindowTracker llllllllllllllIllllIlIlIlIIIIlll = llllllllllllllIllllIlIlIlIIIIllI.user().get(WindowTracker.class);
                        llllllllllllllIllllIlIlIlIIIIlll.setInventory(null);
                        llllllllllllllIllllIlIlIlIIIIlll.setEntityId(-1);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_9_3>)this.protocol).registerServerbound(ServerboundPackets1_9_3.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlIIllIllllIlIIll) throws Exception {
                        final WindowTracker lllllllllllllllIlIIllIllllIlIIlI = lllllllllllllllIlIIllIllllIlIIll.user().get(WindowTracker.class);
                        lllllllllllllllIlIIllIllllIlIIlI.setInventory(null);
                        lllllllllllllllIlIIllIllllIlIIlI.setEntityId(-1);
                    }
                });
            }
        });
        ((Protocol1_10To1_11)this.protocol).getEntityRewriter().filter().handler((lllllllllllllllllIlIlIIllIIllIll, lllllllllllllllllIlIlIIllIIllIlI) -> {
            if (lllllllllllllllllIlIlIIllIIllIlI.metaType().type().equals(Type.ITEM)) {
                lllllllllllllllllIlIlIIllIIllIlI.setValue(this.handleItemToClient((Item)lllllllllllllllllIlIlIIllIIllIlI.getValue()));
            }
        });
    }
    
    @Override
    protected void registerRewrites() {
        final MappedLegacyBlockItem lllllllllllllllllIlIlIlIIIIIllIl = this.replacementData.computeIfAbsent(52, lllllllllllllllllIlIlIIllIIlllll -> new MappedLegacyBlockItem(52, (short)(-1), null, false));
        lllllllllllllllllIlIlIlIIIIIllIl.setBlockEntityHandler((lllllllllllllllllIlIlIIllIlIIIlI, lllllllllllllllllIlIlIIllIlIIIIl) -> {
            EntityIdRewriter.toClientSpawner(lllllllllllllllllIlIlIIllIlIIIIl, true);
            return lllllllllllllllllIlIlIIllIlIIIIl;
        });
        this.enchantmentRewriter = new LegacyEnchantmentRewriter(this.nbtTagName);
        this.enchantmentRewriter.registerEnchantment(71, "§cCurse of Vanishing");
        this.enchantmentRewriter.registerEnchantment(10, "§cCurse of Binding");
        this.enchantmentRewriter.setHideLevelForEnchants(71, 10);
    }
    
    private Optional<ChestedHorseStorage> getChestedHorse(final UserConnection lllllllllllllllllIlIlIIllllIIIlI) {
        final WindowTracker lllllllllllllllllIlIlIIllllIIIll = lllllllllllllllllIlIlIIllllIIIlI.get(WindowTracker.class);
        if (lllllllllllllllllIlIlIIllllIIIll.getInventory() != null && lllllllllllllllllIlIlIIllllIIIll.getInventory().equals("EntityHorse")) {
            final EntityTracker lllllllllllllllllIlIlIIllllIIlll = lllllllllllllllllIlIlIIllllIIIlI.getEntityTracker(Protocol1_10To1_11.class);
            final StoredEntityData lllllllllllllllllIlIlIIllllIIllI = lllllllllllllllllIlIlIIllllIIlll.entityData(lllllllllllllllllIlIlIIllllIIIll.getEntityId());
            if (lllllllllllllllllIlIlIIllllIIllI != null) {
                return Optional.of((ChestedHorseStorage)lllllllllllllllllIlIlIIllllIIllI.get((Class<T>)ChestedHorseStorage.class));
            }
        }
        return Optional.empty();
    }
    
    private int getOldSlotId(final ChestedHorseStorage lllllllllllllllllIlIlIIlllIIIlII, final int lllllllllllllllllIlIlIIllIllllIl) {
        final int lllllllllllllllllIlIlIIlllIIIIlI = lllllllllllllllllIlIlIIlllIIIlII.isChested() ? lllllllllllllllllIlIlIIlllIIIlII.getLiamaStrength() : 0;
        final int lllllllllllllllllIlIlIIlllIIIIIl = 2 + 3 * lllllllllllllllllIlIlIIlllIIIIlI;
        final int lllllllllllllllllIlIlIIlllIIIIII = 2 + 3 * (lllllllllllllllllIlIlIIlllIIIlII.isChested() ? 5 : 0);
        final int lllllllllllllllllIlIlIIllIllllll = lllllllllllllllllIlIlIIlllIIIIII - lllllllllllllllllIlIlIIlllIIIIIl;
        if (lllllllllllllllllIlIlIIllIllllIl == 1 || (lllllllllllllllllIlIlIIllIllllIl >= lllllllllllllllllIlIlIIlllIIIIIl && lllllllllllllllllIlIlIIllIllllIl < lllllllllllllllllIlIlIIlllIIIIII)) {
            return 0;
        }
        if (lllllllllllllllllIlIlIIllIllllIl >= lllllllllllllllllIlIlIIlllIIIIII) {
            return lllllllllllllllllIlIlIIllIllllIl - lllllllllllllllllIlIlIIllIllllll;
        }
        if (lllllllllllllllllIlIlIIllIllllIl == 0) {
            return 1;
        }
        return lllllllllllllllllIlIlIIllIllllIl;
    }
    
    private boolean isLlama(final UserConnection lllllllllllllllllIlIlIIllllIllll) {
        final WindowTracker lllllllllllllllllIlIlIIlllllIIII = lllllllllllllllllIlIlIIllllIllll.get(WindowTracker.class);
        if (lllllllllllllllllIlIlIIlllllIIII.getInventory() != null && lllllllllllllllllIlIlIIlllllIIII.getInventory().equals("EntityHorse")) {
            final EntityTracker lllllllllllllllllIlIlIIlllllIlII = lllllllllllllllllIlIlIIllllIllll.getEntityTracker(Protocol1_10To1_11.class);
            final StoredEntityData lllllllllllllllllIlIlIIlllllIIll = lllllllllllllllllIlIlIIlllllIlII.entityData(lllllllllllllllllIlIlIIlllllIIII.getEntityId());
            return lllllllllllllllllIlIlIIlllllIIll != null && lllllllllllllllllIlIlIIlllllIIll.type().is(Entity1_11Types.EntityType.LIAMA);
        }
        return false;
    }
    
    @Override
    public Item handleItemToClient(final Item lllllllllllllllllIlIlIlIIIIIIllI) {
        if (lllllllllllllllllIlIlIlIIIIIIllI == null) {
            return null;
        }
        super.handleItemToClient(lllllllllllllllllIlIlIlIIIIIIllI);
        final CompoundTag lllllllllllllllllIlIlIlIIIIIIlIl = lllllllllllllllllIlIlIlIIIIIIllI.tag();
        if (lllllllllllllllllIlIlIlIIIIIIlIl == null) {
            return lllllllllllllllllIlIlIlIIIIIIllI;
        }
        EntityIdRewriter.toClientItem(lllllllllllllllllIlIlIlIIIIIIllI, true);
        if (lllllllllllllllllIlIlIlIIIIIIlIl.get("ench") instanceof ListTag) {
            this.enchantmentRewriter.rewriteEnchantmentsToClient(lllllllllllllllllIlIlIlIIIIIIlIl, false);
        }
        if (lllllllllllllllllIlIlIlIIIIIIlIl.get("StoredEnchantments") instanceof ListTag) {
            this.enchantmentRewriter.rewriteEnchantmentsToClient(lllllllllllllllllIlIlIlIIIIIIlIl, true);
        }
        return lllllllllllllllllIlIlIlIIIIIIllI;
    }
    
    private int getNewSlotId(final ChestedHorseStorage lllllllllllllllllIlIlIIlllIlIlll, final int lllllllllllllllllIlIlIIlllIlIIII) {
        final int lllllllllllllllllIlIlIIlllIlIlIl = lllllllllllllllllIlIlIIlllIlIlll.isChested() ? 53 : 38;
        final int lllllllllllllllllIlIlIIlllIlIlII = lllllllllllllllllIlIlIIlllIlIlll.isChested() ? lllllllllllllllllIlIlIIlllIlIlll.getLiamaStrength() : 0;
        final int lllllllllllllllllIlIlIIlllIlIIll = 2 + 3 * lllllllllllllllllIlIlIIlllIlIlII;
        final int lllllllllllllllllIlIlIIlllIlIIlI = 15 - 3 * lllllllllllllllllIlIlIIlllIlIlII;
        if (lllllllllllllllllIlIlIIlllIlIIII >= lllllllllllllllllIlIlIIlllIlIIll && lllllllllllllllllIlIlIIlllIlIlIl > lllllllllllllllllIlIlIIlllIlIIII + lllllllllllllllllIlIlIIlllIlIIlI) {
            return lllllllllllllllllIlIlIIlllIlIIlI + lllllllllllllllllIlIlIIlllIlIIII;
        }
        if (lllllllllllllllllIlIlIIlllIlIIII == 1) {
            return 0;
        }
        return lllllllllllllllllIlIlIIlllIlIIII;
    }
    
    @Override
    public Item handleItemToServer(final Item lllllllllllllllllIlIlIIlllllllIl) {
        if (lllllllllllllllllIlIlIIlllllllIl == null) {
            return null;
        }
        super.handleItemToServer(lllllllllllllllllIlIlIIlllllllIl);
        final CompoundTag lllllllllllllllllIlIlIIlllllllII = lllllllllllllllllIlIlIIlllllllIl.tag();
        if (lllllllllllllllllIlIlIIlllllllII == null) {
            return lllllllllllllllllIlIlIIlllllllIl;
        }
        EntityIdRewriter.toServerItem(lllllllllllllllllIlIlIIlllllllIl, true);
        if (lllllllllllllllllIlIlIIlllllllII.contains(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|ench")))) {
            this.enchantmentRewriter.rewriteEnchantmentsToServer(lllllllllllllllllIlIlIIlllllllII, false);
        }
        if (lllllllllllllllllIlIlIIlllllllII.contains(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|StoredEnchantments")))) {
            this.enchantmentRewriter.rewriteEnchantmentsToServer(lllllllllllllllllIlIlIIlllllllII, true);
        }
        return lllllllllllllllllIlIlIIlllllllIl;
    }
    
    private Item getNewItem(final ChestedHorseStorage lllllllllllllllllIlIlIIllIlIlIIl, final int lllllllllllllllllIlIlIIllIlIllll, final Item lllllllllllllllllIlIlIIllIlIIlll) {
        final int lllllllllllllllllIlIlIIllIlIllIl = lllllllllllllllllIlIlIIllIlIlIIl.isChested() ? lllllllllllllllllIlIlIIllIlIlIIl.getLiamaStrength() : 0;
        final int lllllllllllllllllIlIlIIllIlIllII = 2 + 3 * lllllllllllllllllIlIlIIllIlIllIl;
        final int lllllllllllllllllIlIlIIllIlIlIll = 2 + 3 * (lllllllllllllllllIlIlIIllIlIlIIl.isChested() ? 5 : 0);
        if (lllllllllllllllllIlIlIIllIlIllll >= lllllllllllllllllIlIlIIllIlIllII && lllllllllllllllllIlIlIIllIlIllll < lllllllllllllllllIlIlIIllIlIlIll) {
            return new DataItem(166, (byte)1, (short)0, this.getNamedTag("§4SLOT DISABLED"));
        }
        if (lllllllllllllllllIlIlIIllIlIllll == 1) {
            return null;
        }
        return lllllllllllllllllIlIlIIllIlIIlll;
    }
    
    public BlockItemPackets1_11(final Protocol1_10To1_11 lllllllllllllllllIlIlIlIIIIlIlII) {
        super(lllllllllllllllllIlIlIlIIIIlIlII);
    }
}
