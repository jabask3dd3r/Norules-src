package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.packets;

import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import java.util.concurrent.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets extends ItemRewriter<Protocol1_14To1_13_2>
{
    private static final /* synthetic */ Set<String> REMOVED_RECIPE_TYPES;
    private static final /* synthetic */ ComponentRewriter COMPONENT_REWRITER;
    private static final /* synthetic */ String NBT_TAG_NAME;
    
    @Override
    public Item handleItemToServer(final Item llllllllllllllllIlIIllIIIIIllIll) {
        if (llllllllllllllllIlIIllIIIIIllIll == null) {
            return null;
        }
        llllllllllllllllIlIIllIIIIIllIll.setIdentifier(Protocol1_14To1_13_2.MAPPINGS.getOldItemId(llllllllllllllllIlIIllIIIIIllIll.identifier()));
        if (llllllllllllllllIlIIllIIIIIllIll.tag() == null) {
            return llllllllllllllllIlIIllIIIIIllIll;
        }
        final Tag llllllllllllllllIlIIllIIIIIlllIl = llllllllllllllllIlIIllIIIIIllIll.tag().get("display");
        if (llllllllllllllllIlIIllIIIIIlllIl instanceof CompoundTag) {
            final CompoundTag llllllllllllllllIlIIllIIIIlIIllI = (CompoundTag)llllllllllllllllIlIIllIIIIIlllIl;
            final Tag llllllllllllllllIlIIllIIIIlIIIll = llllllllllllllllIlIIllIIIIlIIllI.get("Lore");
            if (llllllllllllllllIlIIllIIIIlIIIll instanceof ListTag) {
                final ListTag llllllllllllllllIlIIllIIIIlIlIlI = (ListTag)llllllllllllllllIlIIllIIIIlIIIll;
                final ListTag llllllllllllllllIlIIllIIIIlIlIII = llllllllllllllllIlIIllIIIIlIIllI.remove(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|Lore")));
                if (llllllllllllllllIlIIllIIIIlIlIII != null) {
                    llllllllllllllllIlIIllIIIIlIIllI.put("Lore", new ListTag(llllllllllllllllIlIIllIIIIlIlIII.getValue()));
                }
                else {
                    for (final Tag llllllllllllllllIlIIllIIIIlIllII : llllllllllllllllIlIIllIIIIlIlIlI) {
                        if (llllllllllllllllIlIIllIIIIlIllII instanceof StringTag) {
                            ((StringTag)llllllllllllllllIlIIllIIIIlIllII).setValue(ChatRewriter.jsonToLegacyText(((StringTag)llllllllllllllllIlIIllIIIIlIllII).getValue()));
                        }
                    }
                }
            }
        }
        return llllllllllllllllIlIIllIIIIIllIll;
    }
    
    public void registerPackets() {
        this.registerSetCooldown(ClientboundPackets1_13.COOLDOWN);
        this.registerAdvancements(ClientboundPackets1_13.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        ((Protocol<ClientboundPackets1_13, ClientboundPackets1_14, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.OPEN_WINDOW, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIllIllIlIlIIIlllI) throws Exception {
                        final Short lllllllllllllIIIllIllIlIlIIlIIlI = lllllllllllllIIIllIllIlIlIIIlllI.read((Type<Short>)Type.UNSIGNED_BYTE);
                        final String lllllllllllllIIIllIllIlIlIIlIIIl = lllllllllllllIIIllIllIlIlIIIlllI.read(Type.STRING);
                        final JsonElement lllllllllllllIIIllIllIlIlIIlIIII = lllllllllllllIIIllIllIlIlIIIlllI.read(Type.COMPONENT);
                        InventoryPackets.COMPONENT_REWRITER.processText(lllllllllllllIIIllIllIlIlIIlIIII);
                        final Short lllllllllllllIIIllIllIlIlIIIllll = lllllllllllllIIIllIllIlIlIIIlllI.read((Type<Short>)Type.UNSIGNED_BYTE);
                        if (lllllllllllllIIIllIllIlIlIIlIIIl.equals("EntityHorse")) {
                            lllllllllllllIIIllIllIlIlIIIlllI.setId(31);
                            final int lllllllllllllIIIllIllIlIlIIlIllI = lllllllllllllIIIllIllIlIlIIIlllI.read((Type<Integer>)Type.INT);
                            lllllllllllllIIIllIllIlIlIIIlllI.write(Type.UNSIGNED_BYTE, lllllllllllllIIIllIllIlIlIIlIIlI);
                            lllllllllllllIIIllIllIlIlIIIlllI.write(Type.VAR_INT, (int)lllllllllllllIIIllIllIlIlIIIllll);
                            lllllllllllllIIIllIllIlIlIIIlllI.write(Type.INT, lllllllllllllIIIllIllIlIlIIlIllI);
                        }
                        else {
                            lllllllllllllIIIllIllIlIlIIIlllI.setId(46);
                            lllllllllllllIIIllIllIlIlIIIlllI.write(Type.VAR_INT, (int)lllllllllllllIIIllIllIlIlIIlIIlI);
                            int lllllllllllllIIIllIllIlIlIIlIlIl = -1;
                            final String lllllllllllllIIIllIllIlIlIIIlIII = lllllllllllllIIIllIllIlIlIIlIIIl;
                            long lllllllllllllIIIllIllIlIlIIIIlll = -1;
                            switch (lllllllllllllIIIllIllIlIlIIIlIII.hashCode()) {
                                case -1124126594: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:crafting_table")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 0;
                                        break;
                                    }
                                    break;
                                }
                                case -1719356277: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:furnace")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 1;
                                        break;
                                    }
                                    break;
                                }
                                case 712019713: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:dropper")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 2;
                                        break;
                                    }
                                    break;
                                }
                                case 2090881320: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:dispenser")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 3;
                                        break;
                                    }
                                    break;
                                }
                                case 319164197: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:enchanting_table")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 4;
                                        break;
                                    }
                                    break;
                                }
                                case 1649065834: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:brewing_stand")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 5;
                                        break;
                                    }
                                    break;
                                }
                                case -1879003021: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:villager")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 6;
                                        break;
                                    }
                                    break;
                                }
                                case -1293651279: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:beacon")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 7;
                                        break;
                                    }
                                    break;
                                }
                                case -1150744385: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:anvil")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 8;
                                        break;
                                    }
                                    break;
                                }
                                case -1112182111: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:hopper")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 9;
                                        break;
                                    }
                                    break;
                                }
                                case 1374330859: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:shulker_box")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 10;
                                        break;
                                    }
                                    break;
                                }
                                case 1438413556: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:container")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 11;
                                        break;
                                    }
                                    break;
                                }
                                case -1149092108: {
                                    if (lllllllllllllIIIllIllIlIlIIIlIII.equals("minecraft:chest")) {
                                        lllllllllllllIIIllIllIlIlIIIIlll = 12;
                                        break;
                                    }
                                    break;
                                }
                            }
                            switch (lllllllllllllIIIllIllIlIlIIIIlll) {
                                case 0L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 11;
                                    break;
                                }
                                case 1L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 13;
                                    break;
                                }
                                case 2L:
                                case 3L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 6;
                                    break;
                                }
                                case 4L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 12;
                                    break;
                                }
                                case 5L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 10;
                                    break;
                                }
                                case 6L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 18;
                                    break;
                                }
                                case 7L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 8;
                                    break;
                                }
                                case 8L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 7;
                                    break;
                                }
                                case 9L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 15;
                                    break;
                                }
                                case 10L: {
                                    lllllllllllllIIIllIllIlIlIIlIlIl = 19;
                                    break;
                                }
                                default: {
                                    if (lllllllllllllIIIllIllIlIlIIIllll > 0 && lllllllllllllIIIllIllIlIlIIIllll <= 54) {
                                        lllllllllllllIIIllIllIlIlIIlIlIl = lllllllllllllIIIllIllIlIlIIIllll / 9 - 1;
                                        break;
                                    }
                                    break;
                                }
                            }
                            if (lllllllllllllIIIllIllIlIlIIlIlIl == -1) {
                                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Can't open inventory for 1.14 player! Type: ").append(lllllllllllllIIIllIllIlIlIIlIIIl).append(" Size: ").append(lllllllllllllIIIllIllIlIlIIIllll)));
                            }
                            lllllllllllllIIIllIllIlIlIIIlllI.write(Type.VAR_INT, lllllllllllllIIIllIllIlIlIIlIlIl);
                            lllllllllllllIIIllIllIlIlIIIlllI.write(Type.COMPONENT, lllllllllllllIIIllIllIlIlIIlIIII);
                        }
                    }
                });
            }
        });
        this.registerWindowItems(ClientboundPackets1_13.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerSetSlot(ClientboundPackets1_13.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllIIIllllIlIllIlI) throws Exception {
                        final String lllllllllllllIIllIIIllllIlIllIIl = lllllllllllllIIllIIIllllIlIllIlI.get(Type.STRING, 0);
                        if (lllllllllllllIIllIIIllllIlIllIIl.equals("minecraft:trader_list") || lllllllllllllIIllIIIllllIlIllIIl.equals("trader_list")) {
                            lllllllllllllIIllIIIllllIlIllIlI.setId(39);
                            lllllllllllllIIllIIIllllIlIllIlI.resetReader();
                            lllllllllllllIIllIIIllllIlIllIlI.read(Type.STRING);
                            final int lllllllllllllIIllIIIllllIlIlllll = lllllllllllllIIllIIIllllIlIllIlI.read((Type<Integer>)Type.INT);
                            final EntityTracker1_14 lllllllllllllIIllIIIllllIlIllllI = lllllllllllllIIllIIIllllIlIllIlI.user().getEntityTracker(Protocol1_14To1_13_2.class);
                            lllllllllllllIIllIIIllllIlIllllI.setLatestTradeWindowId(lllllllllllllIIllIIIllllIlIlllll);
                            lllllllllllllIIllIIIllllIlIllIlI.write(Type.VAR_INT, lllllllllllllIIllIIIllllIlIlllll);
                            for (int lllllllllllllIIllIIIllllIlIlllIl = lllllllllllllIIllIIIllllIlIllIlI.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIIllIIIllllIllIIIII = 0; lllllllllllllIIllIIIllllIllIIIII < lllllllllllllIIllIIIllllIlIlllIl; ++lllllllllllllIIllIIIllllIllIIIII) {
                                InventoryPackets.this.handleItemToClient(lllllllllllllIIllIIIllllIlIllIlI.passthrough(Type.FLAT_VAR_INT_ITEM));
                                InventoryPackets.this.handleItemToClient(lllllllllllllIIllIIIllllIlIllIlI.passthrough(Type.FLAT_VAR_INT_ITEM));
                                final boolean lllllllllllllIIllIIIllllIllIIIIl = lllllllllllllIIllIIIllllIlIllIlI.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllIIllIIIllllIllIIIIl) {
                                    InventoryPackets.this.handleItemToClient(lllllllllllllIIllIIIllllIlIllIlI.passthrough(Type.FLAT_VAR_INT_ITEM));
                                }
                                lllllllllllllIIllIIIllllIlIllIlI.passthrough((Type<Object>)Type.BOOLEAN);
                                lllllllllllllIIllIIIllllIlIllIlI.passthrough((Type<Object>)Type.INT);
                                lllllllllllllIIllIIIllllIlIllIlI.passthrough((Type<Object>)Type.INT);
                                lllllllllllllIIllIIIllllIlIllIlI.write(Type.INT, 0);
                                lllllllllllllIIllIIIllllIlIllIlI.write(Type.INT, 0);
                                lllllllllllllIIllIIIllllIlIllIlI.write(Type.FLOAT, 0.0f);
                            }
                            lllllllllllllIIllIIIllllIlIllIlI.write(Type.VAR_INT, 0);
                            lllllllllllllIIllIIIllllIlIllIlI.write(Type.VAR_INT, 0);
                            lllllllllllllIIllIIIllllIlIllIlI.write(Type.BOOLEAN, false);
                        }
                        else if (lllllllllllllIIllIIIllllIlIllIIl.equals("minecraft:book_open") || lllllllllllllIIllIIIllllIlIllIIl.equals("book_open")) {
                            final int lllllllllllllIIllIIIllllIlIlllII = lllllllllllllIIllIIIllllIlIllIlI.read((Type<Integer>)Type.VAR_INT);
                            lllllllllllllIIllIIIllllIlIllIlI.clearPacket();
                            lllllllllllllIIllIIIllllIlIllIlI.setId(45);
                            lllllllllllllIIllIIIllllIlIllIlI.write(Type.VAR_INT, lllllllllllllIIllIIIllllIlIlllII);
                        }
                    }
                });
            }
        });
        this.registerEntityEquipment(ClientboundPackets1_13.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
        final RecipeRewriter llllllllllllllllIlIIllIIIllIlIll = new RecipeRewriter1_13_2(this.protocol);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.DECLARE_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                final RecipeRewriter val$recipeRewriter;
                final int lllllllllllllIIIIllIIlIlIlllIlII;
                int lllllllllllllIIIIllIIlIlIlllIIll;
                int lllllllllllllIIIIllIIlIlIlllIlll;
                String lllllllllllllIIIIllIIlIlIllllIIl;
                String lllllllllllllIIIIllIIlIlIllllIII;
                this.handler(lllllllllllllIIIIllIIlIlIlllIlIl -> {
                    val$recipeRewriter = llllllllllllllllIlIIllIIIllIlIll;
                    lllllllllllllIIIIllIIlIlIlllIlII = lllllllllllllIIIIllIIlIlIlllIlIl.passthrough((Type<Integer>)Type.VAR_INT);
                    lllllllllllllIIIIllIIlIlIlllIIll = 0;
                    for (lllllllllllllIIIIllIIlIlIlllIlll = 0; lllllllllllllIIIIllIIlIlIlllIlll < lllllllllllllIIIIllIIlIlIlllIlII; ++lllllllllllllIIIIllIIlIlIlllIlll) {
                        lllllllllllllIIIIllIIlIlIllllIIl = lllllllllllllIIIIllIIlIlIlllIlIl.read(Type.STRING);
                        lllllllllllllIIIIllIIlIlIllllIII = lllllllllllllIIIIllIIlIlIlllIlIl.read(Type.STRING);
                        if (InventoryPackets.REMOVED_RECIPE_TYPES.contains(lllllllllllllIIIIllIIlIlIllllIII)) {
                            ++lllllllllllllIIIIllIIlIlIlllIIll;
                        }
                        else {
                            lllllllllllllIIIIllIIlIlIlllIlIl.write(Type.STRING, lllllllllllllIIIIllIIlIlIllllIII);
                            lllllllllllllIIIIllIIlIlIlllIlIl.write(Type.STRING, lllllllllllllIIIIllIIlIlIllllIIl);
                            val$recipeRewriter.handle(lllllllllllllIIIIllIIlIlIlllIlIl, lllllllllllllIIIIllIIlIlIllllIII);
                        }
                    }
                    lllllllllllllIIIIllIIlIlIlllIlIl.set(Type.VAR_INT, 0, lllllllllllllIIIIllIIlIlIlllIlII - lllllllllllllIIIIllIIlIlIlllIIll);
                });
            }
        });
        this.registerClickWindow(ServerboundPackets1_14.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_14>)this.protocol).registerServerbound(ServerboundPackets1_14.SELECT_TRADE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIlIlIllIlIlllIllI) throws Exception {
                        final PacketWrapper lllllllllllllIlIlIlIllIlIlllIlIl = lllllllllllllIlIlIlIllIlIlllIllI.create(8);
                        final EntityTracker1_14 lllllllllllllIlIlIlIllIlIlllIlII = lllllllllllllIlIlIlIllIlIlllIllI.user().getEntityTracker(Protocol1_14To1_13_2.class);
                        lllllllllllllIlIlIlIllIlIlllIlIl.write(Type.UNSIGNED_BYTE, (short)lllllllllllllIlIlIlIllIlIlllIlII.getLatestTradeWindowId());
                        lllllllllllllIlIlIlIllIlIlllIlIl.write(Type.SHORT, (Short)(-999));
                        lllllllllllllIlIlIlIllIlIlllIlIl.write(Type.BYTE, (Byte)2);
                        lllllllllllllIlIlIlIllIlIlllIlIl.write(Type.SHORT, (short)ThreadLocalRandom.current().nextInt());
                        lllllllllllllIlIlIlIllIlIlllIlIl.write(Type.VAR_INT, 5);
                        final CompoundTag lllllllllllllIlIlIlIllIlIlllIIll = new CompoundTag();
                        lllllllllllllIlIlIlIllIlIlllIIll.put("force_resync", new DoubleTag(Double.NaN));
                        lllllllllllllIlIlIlIllIlIlllIlIl.write((Type<DataItem>)Type.FLAT_VAR_INT_ITEM, new DataItem(1, (byte)1, (short)0, lllllllllllllIlIlIlIllIlIlllIIll));
                        lllllllllllllIlIlIlIllIlIlllIlIl.scheduleSendToServer(Protocol1_14To1_13_2.class);
                    }
                });
            }
        });
        this.registerCreativeInvAction(ServerboundPackets1_14.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        this.registerSpawnParticle(ClientboundPackets1_13.SPAWN_PARTICLE, Type.FLAT_VAR_INT_ITEM, Type.FLOAT);
    }
    
    static {
        NBT_TAG_NAME = String.valueOf(new StringBuilder().append("ViaVersion|").append(Protocol1_14To1_13_2.class.getSimpleName()));
        REMOVED_RECIPE_TYPES = Sets.newHashSet((Object[])new String[] { "crafting_special_banneraddpattern", "crafting_special_repairitem" });
        COMPONENT_REWRITER = new ComponentRewriter() {
            @Override
            protected void handleTranslate(final JsonObject lllllllllllllIIllIIIllllllllIlIl, final String lllllllllllllIIllIIIllllllllIlII) {
                super.handleTranslate(lllllllllllllIIllIIIllllllllIlIl, lllllllllllllIIllIIIllllllllIlII);
                if (lllllllllllllIIllIIIllllllllIlII.startsWith("block.") && lllllllllllllIIllIIIllllllllIlII.endsWith(".name")) {
                    lllllllllllllIIllIIIllllllllIlIl.addProperty("translate", lllllllllllllIIllIIIllllllllIlII.substring(0, lllllllllllllIIllIIIllllllllIlII.length() - 5));
                }
            }
        };
    }
    
    @Override
    public Item handleItemToClient(final Item llllllllllllllllIlIIllIIIlIlIlll) {
        if (llllllllllllllllIlIIllIIIlIlIlll == null) {
            return null;
        }
        llllllllllllllllIlIIllIIIlIlIlll.setIdentifier(Protocol1_14To1_13_2.MAPPINGS.getNewItemId(llllllllllllllllIlIIllIIIlIlIlll.identifier()));
        if (llllllllllllllllIlIIllIIIlIlIlll.tag() == null) {
            return llllllllllllllllIlIIllIIIlIlIlll;
        }
        final Tag llllllllllllllllIlIIllIIIlIlIllI = llllllllllllllllIlIIllIIIlIlIlll.tag().get("display");
        if (llllllllllllllllIlIIllIIIlIlIllI instanceof CompoundTag) {
            final CompoundTag llllllllllllllllIlIIllIIIlIllIlI = (CompoundTag)llllllllllllllllIlIIllIIIlIlIllI;
            final Tag llllllllllllllllIlIIllIIIlIllIIl = llllllllllllllllIlIIllIIIlIllIlI.get("Lore");
            if (llllllllllllllllIlIIllIIIlIllIIl instanceof ListTag) {
                final ListTag llllllllllllllllIlIIllIIIlIllIll = (ListTag)llllllllllllllllIlIIllIIIlIllIIl;
                llllllllllllllllIlIIllIIIlIllIlI.put(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|Lore")), new ListTag(llllllllllllllllIlIIllIIIlIllIll.clone().getValue()));
                for (final Tag llllllllllllllllIlIIllIIIlIlllII : llllllllllllllllIlIIllIIIlIllIll) {
                    if (llllllllllllllllIlIIllIIIlIlllII instanceof StringTag) {
                        final String llllllllllllllllIlIIllIIIlIlllIl = ChatRewriter.legacyTextToJsonString(((StringTag)llllllllllllllllIlIIllIIIlIlllII).getValue(), true);
                        ((StringTag)llllllllllllllllIlIIllIIIlIlllII).setValue(llllllllllllllllIlIIllIIIlIlllIl);
                    }
                }
            }
        }
        return llllllllllllllllIlIIllIIIlIlIlll;
    }
    
    public InventoryPackets(final Protocol1_14To1_13_2 llllllllllllllllIlIIllIIIlllllIl) {
        super(llllllllllllllllIlIIllIIIlllllIl);
    }
}
