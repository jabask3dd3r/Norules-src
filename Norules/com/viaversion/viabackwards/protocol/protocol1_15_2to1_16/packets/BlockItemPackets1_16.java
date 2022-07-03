package com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.packets;

import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.types.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.types.*;
import com.viaversion.viaversion.util.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.data.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.type.types.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.packets.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.protocol.*;
import java.util.*;

public class BlockItemPackets1_16 extends ItemRewriter<Protocol1_15_2To1_16>
{
    private /* synthetic */ EnchantmentRewriter enchantmentRewriter;
    
    @Override
    protected void registerPackets() {
        final BlockRewriter llllllllllllllllIllIIIIIIIIlllII = new BlockRewriter(this.protocol, Type.POSITION1_14);
        final RecipeRewriter1_14 llllllllllllllllIllIIIIIIIIllIll = new RecipeRewriter1_14(this.protocol);
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.DECLARE_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                final RecipeRewriter val$recipeRewriter;
                int lllllllllllllIIIlIIIIIIIllIlIlll;
                int lllllllllllllIIIlIIIIIIIllIllIII;
                int lllllllllllllIIIlIIIIIIIllIllIll;
                String lllllllllllllIIIlIIIIIIIllIllllI;
                String lllllllllllllIIIlIIIIIIIllIlllIl;
                String lllllllllllllIIIlIIIIIIIllIlllII;
                this.handler(lllllllllllllIIIlIIIIIIIllIllIIl -> {
                    val$recipeRewriter = llllllllllllllllIllIIIIIIIIllIll;
                    for (lllllllllllllIIIlIIIIIIIllIllIII = (lllllllllllllIIIlIIIIIIIllIlIlll = lllllllllllllIIIlIIIIIIIllIllIIl.passthrough((Type<Integer>)Type.VAR_INT)), lllllllllllllIIIlIIIIIIIllIllIll = 0; lllllllllllllIIIlIIIIIIIllIllIll < lllllllllllllIIIlIIIIIIIllIllIII; ++lllllllllllllIIIlIIIIIIIllIllIll) {
                        lllllllllllllIIIlIIIIIIIllIllllI = lllllllllllllIIIlIIIIIIIllIllIIl.read(Type.STRING);
                        lllllllllllllIIIlIIIIIIIllIlllIl = lllllllllllllIIIlIIIIIIIllIllllI.replace("minecraft:", "");
                        if (lllllllllllllIIIlIIIIIIIllIlllIl.equals("smithing")) {
                            --lllllllllllllIIIlIIIIIIIllIlIlll;
                            lllllllllllllIIIlIIIIIIIllIllIIl.read(Type.STRING);
                            lllllllllllllIIIlIIIIIIIllIllIIl.read(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT);
                            lllllllllllllIIIlIIIIIIIllIllIIl.read(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT);
                            lllllllllllllIIIlIIIIIIIllIllIIl.read(Type.FLAT_VAR_INT_ITEM);
                        }
                        else {
                            lllllllllllllIIIlIIIIIIIllIllIIl.write(Type.STRING, lllllllllllllIIIlIIIIIIIllIllllI);
                            lllllllllllllIIIlIIIIIIIllIlllII = lllllllllllllIIIlIIIIIIIllIllIIl.passthrough(Type.STRING);
                            val$recipeRewriter.handle(lllllllllllllIIIlIIIIIIIllIllIIl, lllllllllllllIIIlIIIIIIIllIlllIl);
                        }
                    }
                    lllllllllllllIIIlIIIIIIIllIllIIl.set(Type.VAR_INT, 0, lllllllllllllIIIlIIIIIIIllIlIlll);
                });
            }
        });
        this.registerSetCooldown(ClientboundPackets1_16.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_16.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerSetSlot(ClientboundPackets1_16.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
        this.registerTradeList(ClientboundPackets1_16.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
        this.registerAdvancements(ClientboundPackets1_16.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        llllllllllllllllIllIIIIIIIIlllII.registerAcknowledgePlayerDigging(ClientboundPackets1_16.ACKNOWLEDGE_PLAYER_DIGGING);
        llllllllllllllllIllIIIIIIIIlllII.registerBlockAction(ClientboundPackets1_16.BLOCK_ACTION);
        llllllllllllllllIllIIIIIIIIlllII.registerBlockChange(ClientboundPackets1_16.BLOCK_CHANGE);
        llllllllllllllllIllIIIIIIIIlllII.registerMultiBlockChange(ClientboundPackets1_16.MULTI_BLOCK_CHANGE);
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIIlIllIIIllIIIlIIlI;
                final ArrayList<EquipmentData> lllllllllllllIIlIllIIIllIIIlIIIl;
                byte lllllllllllllIIlIllIIIllIIIlIIII;
                Item lllllllllllllIIlIllIIIllIIIllIIl;
                int lllllllllllllIIlIllIIIllIIIllIII;
                final EquipmentData lllllllllllllIIlIllIIIllIIIIllll;
                int lllllllllllllIIlIllIIIllIIIlIlIl;
                PacketWrapper lllllllllllllIIlIllIIIllIIIlIlll;
                EquipmentData lllllllllllllIIlIllIIIllIIIlIllI;
                this.handler(lllllllllllllIIlIllIIIllIIIlIIll -> {
                    lllllllllllllIIlIllIIIllIIIlIIlI = lllllllllllllIIlIllIIIllIIIlIIll.passthrough((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIlIllIIIllIIIlIIIl = new ArrayList<EquipmentData>();
                    do {
                        lllllllllllllIIlIllIIIllIIIlIIII = lllllllllllllIIlIllIIIllIIIlIIll.read((Type<Byte>)Type.BYTE);
                        lllllllllllllIIlIllIIIllIIIllIIl = BlockItemPackets1_16.this.handleItemToClient(lllllllllllllIIlIllIIIllIIIlIIll.read(Type.FLAT_VAR_INT_ITEM));
                        lllllllllllllIIlIllIIIllIIIllIII = (lllllllllllllIIlIllIIIllIIIlIIII & 0x7F);
                        lllllllllllllIIlIllIIIllIIIlIIIl.add(new EquipmentData(lllllllllllllIIlIllIIIllIIIllIII, lllllllllllllIIlIllIIIllIIIllIIl));
                    } while ((lllllllllllllIIlIllIIIllIIIlIIII & 0xFFFFFF80) != 0x0);
                    lllllllllllllIIlIllIIIllIIIIllll = (EquipmentData)lllllllllllllIIlIllIIIllIIIlIIIl.get(0);
                    lllllllllllllIIlIllIIIllIIIlIIll.write(Type.VAR_INT, lllllllllllllIIlIllIIIllIIIIllll.slot);
                    lllllllllllllIIlIllIIIllIIIlIIll.write(Type.FLAT_VAR_INT_ITEM, lllllllllllllIIlIllIIIllIIIIllll.item);
                    for (lllllllllllllIIlIllIIIllIIIlIlIl = 1; lllllllllllllIIlIllIIIllIIIlIlIl < lllllllllllllIIlIllIIIllIIIlIIIl.size(); ++lllllllllllllIIlIllIIIllIIIlIlIl) {
                        lllllllllllllIIlIllIIIllIIIlIlll = lllllllllllllIIlIllIIIllIIIlIIll.create(ClientboundPackets1_15.ENTITY_EQUIPMENT);
                        lllllllllllllIIlIllIIIllIIIlIllI = (EquipmentData)lllllllllllllIIlIllIIIllIIIlIIIl.get(lllllllllllllIIlIllIIIllIIIlIlIl);
                        lllllllllllllIIlIllIIIllIIIlIlll.write(Type.VAR_INT, lllllllllllllIIlIllIIIllIIIlIIlI);
                        lllllllllllllIIlIllIIIllIIIlIlll.write(Type.VAR_INT, lllllllllllllIIlIllIIIllIIIlIllI.slot);
                        lllllllllllllIIlIllIIIllIIIlIlll.write(Type.FLAT_VAR_INT_ITEM, lllllllllllllIIlIllIIIllIIIlIllI.item);
                        lllllllllllllIIlIllIIIllIIIlIlll.send(Protocol1_15_2To1_16.class);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.UPDATE_LIGHT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.BOOLEAN, Type.NOTHING);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Chunk lllllllllllllIlIIlllIIIlllIlIlII;
                int lllllllllllllIlIIlllIIIlllIlllIl;
                ChunkSection lllllllllllllIlIIlllIIIlllIllllI;
                int lllllllllllllIlIIlllIIIlllIlllll;
                int lllllllllllllIlIIlllIIIllllIIIII;
                final CompoundTag lllllllllllllIlIIlllIIIlllIlIIll;
                final char lllllllllllllIlIIlllIIIlllIIlllI;
                Tag lllllllllllllIlIIlllIIIlllIllIlI;
                LongArrayTag lllllllllllllIlIIlllIIIlllIlllII;
                int[] lllllllllllllIlIIlllIIIlllIllIll;
                int lllllllllllllIlIIlllIIIlllIllIII;
                int lllllllllllllIlIIlllIIIlllIllIIl;
                char lllllllllllllIlIIlllIIIlllIIlllI2;
                CompoundTag lllllllllllllIlIIlllIIIlllIlIlll;
                this.handler(lllllllllllllIlIIlllIIIlllIlIlIl -> {
                    lllllllllllllIlIIlllIIIlllIlIlII = lllllllllllllIlIIlllIIIlllIlIlIl.read((Type<Chunk>)new Chunk1_16Type());
                    lllllllllllllIlIIlllIIIlllIlIlIl.write(new Chunk1_15Type(), lllllllllllllIlIIlllIIIlllIlIlII);
                    for (lllllllllllllIlIIlllIIIlllIlllIl = 0; lllllllllllllIlIIlllIIIlllIlllIl < lllllllllllllIlIIlllIIIlllIlIlII.getSections().length; ++lllllllllllllIlIIlllIIIlllIlllIl) {
                        lllllllllllllIlIIlllIIIlllIllllI = lllllllllllllIlIIlllIIIlllIlIlII.getSections()[lllllllllllllIlIIlllIIIlllIlllIl];
                        if (lllllllllllllIlIIlllIIIlllIllllI != null) {
                            for (lllllllllllllIlIIlllIIIlllIlllll = 0; lllllllllllllIlIIlllIIIlllIlllll < lllllllllllllIlIIlllIIIlllIllllI.getPaletteSize(); ++lllllllllllllIlIIlllIIIlllIlllll) {
                                lllllllllllllIlIIlllIIIllllIIIII = lllllllllllllIlIIlllIIIlllIllllI.getPaletteEntry(lllllllllllllIlIIlllIIIlllIlllll);
                                lllllllllllllIlIIlllIIIlllIllllI.setPaletteEntry(lllllllllllllIlIIlllIIIlllIlllll, ((Protocol1_15_2To1_16)BlockItemPackets1_16.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIlIIlllIIIllllIIIII));
                            }
                        }
                    }
                    lllllllllllllIlIIlllIIIlllIlIIll = lllllllllllllIlIIlllIIIlllIlIlII.getHeightMap();
                    lllllllllllllIlIIlllIIIlllIIlllI = (char)lllllllllllllIlIIlllIIIlllIlIIll.values().iterator();
                    while (((Iterator)lllllllllllllIlIIlllIIIlllIIlllI).hasNext()) {
                        lllllllllllllIlIIlllIIIlllIllIlI = ((Iterator<Tag>)lllllllllllllIlIIlllIIIlllIIlllI).next();
                        lllllllllllllIlIIlllIIIlllIlllII = (LongArrayTag)lllllllllllllIlIIlllIIIlllIllIlI;
                        lllllllllllllIlIIlllIIIlllIllIll = new int[256];
                        CompactArrayUtil.iterateCompactArrayWithPadding(9, lllllllllllllIlIIlllIIIlllIllIll.length, lllllllllllllIlIIlllIIIlllIlllII.getValue(), (lllllllllllllIlIIlllIIIlllIIIIII, lllllllllllllIlIIlllIIIllIllllII) -> lllllllllllllIlIIlllIIIlllIllIll[lllllllllllllIlIIlllIIIlllIIIIII] = lllllllllllllIlIIlllIIIllIllllII);
                        lllllllllllllIlIIlllIIIlllIlllII.setValue(CompactArrayUtil.createCompactArray(9, lllllllllllllIlIIlllIIIlllIllIll.length, lllllllllllllIlIIlllIIIlllIIIlIl -> lllllllllllllIlIIlllIIIlllIllIll[lllllllllllllIlIIlllIIIlllIIIlIl]));
                    }
                    if (lllllllllllllIlIIlllIIIlllIlIlII.isBiomeData()) {
                        for (lllllllllllllIlIIlllIIIlllIllIII = 0; lllllllllllllIlIIlllIIIlllIllIII < 1024; ++lllllllllllllIlIIlllIIIlllIllIII) {
                            lllllllllllllIlIIlllIIIlllIllIIl = lllllllllllllIlIIlllIIIlllIlIlII.getBiomeData()[lllllllllllllIlIIlllIIIlllIllIII];
                            switch (lllllllllllllIlIIlllIIIlllIllIIl) {
                                case 170:
                                case 171:
                                case 172:
                                case 173: {
                                    lllllllllllllIlIIlllIIIlllIlIlII.getBiomeData()[lllllllllllllIlIIlllIIIlllIllIII] = 8;
                                    break;
                                }
                            }
                        }
                    }
                    if (lllllllllllllIlIIlllIIIlllIlIlII.getBlockEntities() != null) {
                        lllllllllllllIlIIlllIIIlllIIlllI2 = (char)lllllllllllllIlIIlllIIIlllIlIlII.getBlockEntities().iterator();
                        while (((Iterator)lllllllllllllIlIIlllIIIlllIIlllI2).hasNext()) {
                            lllllllllllllIlIIlllIIIlllIlIlll = ((Iterator<CompoundTag>)lllllllllllllIlIIlllIIIlllIIlllI2).next();
                            BlockItemPackets1_16.this.handleBlockEntity(lllllllllllllIlIIlllIIIlllIlIlll);
                        }
                    }
                });
            }
        });
        llllllllllllllllIllIIIIIIIIlllII.registerEffect(ClientboundPackets1_16.EFFECT, 1010, 2001);
        this.registerSpawnParticle(ClientboundPackets1_16.SPAWN_PARTICLE, Type.FLAT_VAR_INT_ITEM, Type.DOUBLE);
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.WINDOW_PROPERTY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                final short lllllllllllllIllllIIlIIlIIllIIII;
                short lllllllllllllIllllIIlIIlIIllIIlI;
                ShortType short1;
                short lllllllllllllIllllIIlIIlIIllIIlI2;
                final int n;
                this.handler(lllllllllllllIllllIIlIIlIIllIIIl -> {
                    lllllllllllllIllllIIlIIlIIllIIII = lllllllllllllIllllIIlIIlIIllIIIl.get((Type<Short>)Type.SHORT, 0);
                    if (lllllllllllllIllllIIlIIlIIllIIII >= 4 && lllllllllllllIllllIIlIIlIIllIIII <= 6) {
                        lllllllllllllIllllIIlIIlIIllIIlI = lllllllllllllIllllIIlIIlIIllIIIl.get((Type<Short>)Type.SHORT, 1);
                        if (lllllllllllllIllllIIlIIlIIllIIlI > 11) {
                            short1 = Type.SHORT;
                            lllllllllllllIllllIIlIIlIIllIIlI2 = (short)(lllllllllllllIllllIIlIIlIIllIIlI - 1);
                            lllllllllllllIllllIIlIIlIIllIIIl.set(short1, n, lllllllllllllIllllIIlIIlIIllIIlI2);
                        }
                        else if (lllllllllllllIllllIIlIIlIIllIIlI == 11) {
                            lllllllllllllIllllIIlIIlIIllIIIl.set(Type.SHORT, 1, (Short)9);
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.map(Type.BOOLEAN);
                this.handler(MapColorRewriter.getRewriteHandler(MapColorRewrites::getMappedColor));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_16, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                final Position llllllllllllllIlIlllllllIIllllII;
                final short llllllllllllllIlIlllllllIIlllIll;
                final CompoundTag llllllllllllllIlIlllllllIIlllIlI;
                this.handler(llllllllllllllIlIlllllllIIlllIII -> {
                    llllllllllllllIlIlllllllIIllllII = llllllllllllllIlIlllllllIIlllIII.passthrough(Type.POSITION1_14);
                    llllllllllllllIlIlllllllIIlllIll = llllllllllllllIlIlllllllIIlllIII.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    llllllllllllllIlIlllllllIIlllIlI = llllllllllllllIlIlllllllIIlllIII.passthrough(Type.NBT);
                    BlockItemPackets1_16.this.handleBlockEntity(llllllllllllllIlIlllllllIIlllIlI);
                });
            }
        });
        this.registerClickWindow(ServerboundPackets1_14.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_14.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this.protocol).registerServerbound(ServerboundPackets1_14.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllllIlIlIllIlIlIlIlIII -> BlockItemPackets1_16.this.handleItemToServer(llllllllllllllIlIlIllIlIlIlIlIII.passthrough(Type.FLAT_VAR_INT_ITEM)));
            }
        });
    }
    
    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter = new EnchantmentRewriter(this);
        this.enchantmentRewriter.registerEnchantment("minecraft:soul_speed", "§7Soul Speed");
    }
    
    private void handleBlockEntity(final CompoundTag llllllllllllllllIllIIIIIIIIIIlIl) {
        final StringTag llllllllllllllllIllIIIIIIIIIIlII = llllllllllllllllIllIIIIIIIIIIlIl.get("id");
        if (llllllllllllllllIllIIIIIIIIIIlII == null) {
            return;
        }
        final String llllllllllllllllIllIIIIIIIIIIIll = llllllllllllllllIllIIIIIIIIIIlII.getValue();
        if (llllllllllllllllIllIIIIIIIIIIIll.equals("minecraft:conduit")) {
            final Tag llllllllllllllllIllIIIIIIIIIlllI = llllllllllllllllIllIIIIIIIIIIlIl.remove("Target");
            if (!(llllllllllllllllIllIIIIIIIIIlllI instanceof IntArrayTag)) {
                return;
            }
            final UUID llllllllllllllllIllIIIIIIIIIllIl = UUIDIntArrayType.uuidFromIntArray((int[])llllllllllllllllIllIIIIIIIIIlllI.getValue());
            llllllllllllllllIllIIIIIIIIIIlIl.put("target_uuid", new StringTag(llllllllllllllllIllIIIIIIIIIllIl.toString()));
        }
        else if (llllllllllllllllIllIIIIIIIIIIIll.equals("minecraft:skull")) {
            final Tag llllllllllllllllIllIIIIIIIIIlIlI = llllllllllllllllIllIIIIIIIIIIlIl.remove("SkullOwner");
            if (!(llllllllllllllllIllIIIIIIIIIlIlI instanceof CompoundTag)) {
                return;
            }
            final CompoundTag llllllllllllllllIllIIIIIIIIIlIIl = (CompoundTag)llllllllllllllllIllIIIIIIIIIlIlI;
            final Tag llllllllllllllllIllIIIIIIIIIlIII = llllllllllllllllIllIIIIIIIIIlIIl.remove("Id");
            if (llllllllllllllllIllIIIIIIIIIlIII instanceof IntArrayTag) {
                final UUID llllllllllllllllIllIIIIIIIIIllII = UUIDIntArrayType.uuidFromIntArray((int[])llllllllllllllllIllIIIIIIIIIlIII.getValue());
                llllllllllllllllIllIIIIIIIIIlIIl.put("Id", new StringTag(llllllllllllllllIllIIIIIIIIIllII.toString()));
            }
            final CompoundTag llllllllllllllllIllIIIIIIIIIIlll = new CompoundTag();
            for (final Map.Entry<String, Tag> llllllllllllllllIllIIIIIIIIIlIll : llllllllllllllllIllIIIIIIIIIlIIl) {
                llllllllllllllllIllIIIIIIIIIIlll.put(llllllllllllllllIllIIIIIIIIIlIll.getKey(), llllllllllllllllIllIIIIIIIIIlIll.getValue());
            }
            llllllllllllllllIllIIIIIIIIIIlIl.put("Owner", llllllllllllllllIllIIIIIIIIIIlll);
        }
    }
    
    @Override
    public Item handleItemToClient(final Item llllllllllllllllIlIllllllllIlIlI) {
        if (llllllllllllllllIlIllllllllIlIlI == null) {
            return null;
        }
        super.handleItemToClient(llllllllllllllllIlIllllllllIlIlI);
        final CompoundTag llllllllllllllllIlIllllllllIlIIl = llllllllllllllllIlIllllllllIlIlI.tag();
        if (llllllllllllllllIlIllllllllIlIlI.identifier() == 771 && llllllllllllllllIlIllllllllIlIIl != null) {
            final Tag llllllllllllllllIlIllllllllIllII = llllllllllllllllIlIllllllllIlIIl.get("SkullOwner");
            if (llllllllllllllllIlIllllllllIllII instanceof CompoundTag) {
                final CompoundTag llllllllllllllllIlIllllllllIlllI = (CompoundTag)llllllllllllllllIlIllllllllIllII;
                final Tag llllllllllllllllIlIllllllllIllIl = llllllllllllllllIlIllllllllIlllI.get("Id");
                if (llllllllllllllllIlIllllllllIllIl instanceof IntArrayTag) {
                    final UUID llllllllllllllllIlIllllllllIllll = UUIDIntArrayType.uuidFromIntArray((int[])llllllllllllllllIlIllllllllIllIl.getValue());
                    llllllllllllllllIlIllllllllIlllI.put("Id", new StringTag(llllllllllllllllIlIllllllllIllll.toString()));
                }
            }
        }
        InventoryPackets.newToOldAttributes(llllllllllllllllIlIllllllllIlIlI);
        this.enchantmentRewriter.handleToClient(llllllllllllllllIlIllllllllIlIlI);
        return llllllllllllllllIlIllllllllIlIlI;
    }
    
    @Override
    public Item handleItemToServer(final Item llllllllllllllllIlIlllllllIlIlII) {
        if (llllllllllllllllIlIlllllllIlIlII == null) {
            return null;
        }
        final int llllllllllllllllIlIlllllllIlIIll = llllllllllllllllIlIlllllllIlIlII.identifier();
        super.handleItemToServer(llllllllllllllllIlIlllllllIlIlII);
        final CompoundTag llllllllllllllllIlIlllllllIlIIlI = llllllllllllllllIlIlllllllIlIlII.tag();
        if (llllllllllllllllIlIlllllllIlIIll == 771 && llllllllllllllllIlIlllllllIlIIlI != null) {
            final Tag llllllllllllllllIlIlllllllIlIllI = llllllllllllllllIlIlllllllIlIIlI.get("SkullOwner");
            if (llllllllllllllllIlIlllllllIlIllI instanceof CompoundTag) {
                final CompoundTag llllllllllllllllIlIlllllllIllIII = (CompoundTag)llllllllllllllllIlIlllllllIlIllI;
                final Tag llllllllllllllllIlIlllllllIlIlll = llllllllllllllllIlIlllllllIllIII.get("Id");
                if (llllllllllllllllIlIlllllllIlIlll instanceof StringTag) {
                    final UUID llllllllllllllllIlIlllllllIllIIl = UUID.fromString((String)llllllllllllllllIlIlllllllIlIlll.getValue());
                    llllllllllllllllIlIlllllllIllIII.put("Id", new IntArrayTag(UUIDIntArrayType.uuidToIntArray(llllllllllllllllIlIlllllllIllIIl)));
                }
            }
        }
        InventoryPackets.oldToNewAttributes(llllllllllllllllIlIlllllllIlIlII);
        this.enchantmentRewriter.handleToServer(llllllllllllllllIlIlllllllIlIlII);
        return llllllllllllllllIlIlllllllIlIlII;
    }
    
    public BlockItemPackets1_16(final Protocol1_15_2To1_16 llllllllllllllllIllIIIIIIIlIIlIl, final TranslatableRewriter llllllllllllllllIllIIIIIIIlIIIIl) {
        super(llllllllllllllllIllIIIIIIIlIIlIl, llllllllllllllllIllIIIIIIIlIIIIl);
    }
    
    private static final class EquipmentData
    {
        private final /* synthetic */ Item item;
        private final /* synthetic */ int slot;
        
        private EquipmentData(final int lllllllllllllIIIIlllllllllIlllII, final Item lllllllllllllIIIIlllllllllIllllI) {
            this.slot = lllllllllllllIIIIlllllllllIlllII;
            this.item = lllllllllllllIIIIlllllllllIllllI;
        }
    }
}
