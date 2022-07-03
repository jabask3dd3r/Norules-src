package com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.packets;

import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viabackwards.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.minecraft.entities.*;
import com.viaversion.viaversion.api.minecraft.metadata.types.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.api.type.types.version.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.rewriter.*;
import java.util.*;
import com.google.common.collect.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.storage.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.types.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.types.*;
import com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.storage.*;
import com.viaversion.viaversion.api.minecraft.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.*;
import com.viaversion.viaversion.api.minecraft.chunks.*;
import com.viaversion.viaversion.api.protocol.*;

public class BlockItemPackets1_14 extends ItemRewriter<Protocol1_13_2To1_14>
{
    private /* synthetic */ EnchantmentRewriter enchantmentRewriter;
    
    public BlockItemPackets1_14(final Protocol1_13_2To1_14 lllllllllllllIllIIlIIlIlIIlIlIlI, final TranslatableRewriter lllllllllllllIllIIlIIlIlIIlIlIIl) {
        super(lllllllllllllIllIIlIIlIlIIlIlIlI, lllllllllllllIllIIlIIlIlIIlIlIIl);
    }
    
    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter = new EnchantmentRewriter(this, false);
        this.enchantmentRewriter.registerEnchantment("minecraft:multishot", "§7Multishot");
        this.enchantmentRewriter.registerEnchantment("minecraft:quick_charge", "§7Quick Charge");
        this.enchantmentRewriter.registerEnchantment("minecraft:piercing", "§7Piercing");
    }
    
    @Override
    public Item handleItemToClient(final Item lllllllllllllIllIIlIIlIlIIIIllIl) {
        if (lllllllllllllIllIIlIIlIlIIIIllIl == null) {
            return null;
        }
        super.handleItemToClient(lllllllllllllIllIIlIIlIlIIIIllIl);
        final CompoundTag lllllllllllllIllIIlIIlIlIIIIllII = lllllllllllllIllIIlIIlIlIIIIllIl.tag();
        final CompoundTag lllllllllllllIllIIlIIlIlIIIIllll;
        if (lllllllllllllIllIIlIIlIlIIIIllII != null && (lllllllllllllIllIIlIIlIlIIIIllll = lllllllllllllIllIIlIIlIlIIIIllII.get("display")) != null) {
            final ListTag lllllllllllllIllIIlIIlIlIIIlIIII = lllllllllllllIllIIlIIlIlIIIIllll.get("Lore");
            if (lllllllllllllIllIIlIIlIlIIIlIIII != null) {
                this.saveListTag(lllllllllllllIllIIlIIlIlIIIIllll, lllllllllllllIllIIlIIlIlIIIlIIII, "Lore");
                for (final Tag lllllllllllllIllIIlIIlIlIIIlIIIl : lllllllllllllIllIIlIIlIlIIIlIIII) {
                    if (!(lllllllllllllIllIIlIIlIlIIIlIIIl instanceof StringTag)) {
                        continue;
                    }
                    final StringTag lllllllllllllIllIIlIIlIlIIIlIIll = (StringTag)lllllllllllllIllIIlIIlIlIIIlIIIl;
                    final String lllllllllllllIllIIlIIlIlIIIlIIlI = lllllllllllllIllIIlIIlIlIIIlIIll.getValue();
                    if (lllllllllllllIllIIlIIlIlIIIlIIlI == null || lllllllllllllIllIIlIIlIlIIIlIIlI.isEmpty()) {
                        continue;
                    }
                    lllllllllllllIllIIlIIlIlIIIlIIll.setValue(ChatRewriter.jsonToLegacyText(lllllllllllllIllIIlIIlIlIIIlIIlI));
                }
            }
        }
        this.enchantmentRewriter.handleToClient(lllllllllllllIllIIlIIlIlIIIIllIl);
        return lllllllllllllIllIIlIIlIlIIIIllIl;
    }
    
    @Override
    public Item handleItemToServer(final Item lllllllllllllIllIIlIIlIIllllIlIl) {
        if (lllllllllllllIllIIlIIlIIllllIlIl == null) {
            return null;
        }
        final CompoundTag lllllllllllllIllIIlIIlIIllllIlII = lllllllllllllIllIIlIIlIIllllIlIl.tag();
        final CompoundTag lllllllllllllIllIIlIIlIIllllIlll;
        if (lllllllllllllIllIIlIIlIIllllIlII != null && (lllllllllllllIllIIlIIlIIllllIlll = lllllllllllllIllIIlIIlIIllllIlII.get("display")) != null) {
            final ListTag lllllllllllllIllIIlIIlIIlllllIII = lllllllllllllIllIIlIIlIIllllIlll.get("Lore");
            if (lllllllllllllIllIIlIIlIIlllllIII != null && !this.hasBackupTag(lllllllllllllIllIIlIIlIIllllIlll, "Lore")) {
                for (final Tag lllllllllllllIllIIlIIlIIlllllIIl : lllllllllllllIllIIlIIlIIlllllIII) {
                    if (lllllllllllllIllIIlIIlIIlllllIIl instanceof StringTag) {
                        final StringTag lllllllllllllIllIIlIIlIIlllllIlI = (StringTag)lllllllllllllIllIIlIIlIIlllllIIl;
                        lllllllllllllIllIIlIIlIIlllllIlI.setValue(ChatRewriter.legacyTextToJsonString(lllllllllllllIllIIlIIlIIlllllIlI.getValue()));
                    }
                }
            }
        }
        this.enchantmentRewriter.handleToServer(lllllllllllllIllIIlIIlIIllllIlIl);
        super.handleItemToServer(lllllllllllllIllIIlIIlIIllllIlIl);
        return lllllllllllllIllIIlIIlIIllllIlIl;
    }
    
    @Override
    protected void registerPackets() {
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIllIIIlIllIIllIIlI -> BlockItemPackets1_14.this.handleItemToServer(lllllllllllllIIllIIIlIllIIllIIlI.passthrough(Type.FLAT_VAR_INT_ITEM)));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIlIllIIIIllIllII) throws Exception {
                        final int lllllllllllllllIIlIllIIIIlllIIlI = lllllllllllllllIIlIllIIIIllIllII.read((Type<Integer>)Type.VAR_INT);
                        lllllllllllllllIIlIllIIIIllIllII.write(Type.UNSIGNED_BYTE, (short)lllllllllllllllIIlIllIIIIlllIIlI);
                        final int lllllllllllllllIIlIllIIIIlllIIIl = lllllllllllllllIIlIllIIIIllIllII.read((Type<Integer>)Type.VAR_INT);
                        String lllllllllllllllIIlIllIIIIlllIIII = null;
                        String lllllllllllllllIIlIllIIIIllIllll = null;
                        int lllllllllllllllIIlIllIIIIllIlllI = 0;
                        if (lllllllllllllllIIlIllIIIIlllIIIl < 6) {
                            if (lllllllllllllllIIlIllIIIIlllIIIl == 2) {
                                lllllllllllllllIIlIllIIIIllIllll = "Barrel";
                            }
                            lllllllllllllllIIlIllIIIIlllIIII = "minecraft:container";
                            lllllllllllllllIIlIllIIIIllIlllI = (lllllllllllllllIIlIllIIIIlllIIIl + 1) * 9;
                        }
                        else {
                            switch (lllllllllllllllIIlIllIIIIlllIIIl) {
                                case 11: {
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:crafting_table";
                                    break;
                                }
                                case 9:
                                case 13:
                                case 14:
                                case 20: {
                                    if (lllllllllllllllIIlIllIIIIlllIIIl == 9) {
                                        lllllllllllllllIIlIllIIIIllIllll = "Blast Furnace";
                                    }
                                    else if (lllllllllllllllIIlIllIIIIlllIIIl == 20) {
                                        lllllllllllllllIIlIllIIIIllIllll = "Smoker";
                                    }
                                    else if (lllllllllllllllIIlIllIIIIlllIIIl == 14) {
                                        lllllllllllllllIIlIllIIIIllIllll = "Grindstone";
                                    }
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:furnace";
                                    lllllllllllllllIIlIllIIIIllIlllI = 3;
                                    break;
                                }
                                case 6: {
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:dropper";
                                    lllllllllllllllIIlIllIIIIllIlllI = 9;
                                    break;
                                }
                                case 12: {
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:enchanting_table";
                                    break;
                                }
                                case 10: {
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:brewing_stand";
                                    lllllllllllllllIIlIllIIIIllIlllI = 5;
                                    break;
                                }
                                case 18: {
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:villager";
                                    break;
                                }
                                case 8: {
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:beacon";
                                    lllllllllllllllIIlIllIIIIllIlllI = 1;
                                    break;
                                }
                                case 7:
                                case 21: {
                                    if (lllllllllllllllIIlIllIIIIlllIIIl == 21) {
                                        lllllllllllllllIIlIllIIIIllIllll = "Cartography Table";
                                    }
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:anvil";
                                    break;
                                }
                                case 15: {
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:hopper";
                                    lllllllllllllllIIlIllIIIIllIlllI = 5;
                                    break;
                                }
                                case 19: {
                                    lllllllllllllllIIlIllIIIIlllIIII = "minecraft:shulker_box";
                                    lllllllllllllllIIlIllIIIIllIlllI = 27;
                                    break;
                                }
                            }
                        }
                        if (lllllllllllllllIIlIllIIIIlllIIII == null) {
                            ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Can't open inventory for 1.13 player! Type: ").append(lllllllllllllllIIlIllIIIIlllIIIl)));
                            lllllllllllllllIIlIllIIIIllIllII.cancel();
                            return;
                        }
                        lllllllllllllllIIlIllIIIIllIllII.write(Type.STRING, lllllllllllllllIIlIllIIIIlllIIII);
                        JsonElement lllllllllllllllIIlIllIIIIllIllIl = lllllllllllllllIIlIllIIIIllIllII.read(Type.COMPONENT);
                        final JsonObject lllllllllllllllIIlIllIIIIlllIlIl;
                        if (lllllllllllllllIIlIllIIIIllIllll != null && lllllllllllllllIIlIllIIIIllIllIl.isJsonObject() && (lllllllllllllllIIlIllIIIIlllIlIl = lllllllllllllllIIlIllIIIIllIllIl.getAsJsonObject()).has("translate") && (lllllllllllllllIIlIllIIIIlllIIIl != 2 || lllllllllllllllIIlIllIIIIlllIlIl.getAsJsonPrimitive("translate").getAsString().equals("container.barrel"))) {
                            lllllllllllllllIIlIllIIIIllIllIl = ChatRewriter.legacyTextToJson(lllllllllllllllIIlIllIIIIllIllll);
                        }
                        lllllllllllllllIIlIllIIIIllIllII.write(Type.COMPONENT, lllllllllllllllIIlIllIIIIllIllIl);
                        lllllllllllllllIIlIllIIIIllIllII.write(Type.UNSIGNED_BYTE, (short)lllllllllllllllIIlIllIIIIllIlllI);
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_14, ClientboundPackets1_13, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.OPEN_HORSE_WINDOW, ClientboundPackets1_13.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIIllIllllIlIII) throws Exception {
                        llllllllllllllIllIIIllIllllIlIII.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                        llllllllllllllIllIIIllIllllIlIII.write(Type.STRING, "EntityHorse");
                        final JsonObject llllllllllllllIllIIIllIllllIlIIl = new JsonObject();
                        llllllllllllllIllIIIllIllllIlIIl.addProperty("translate", "minecraft.horse");
                        llllllllllllllIllIIIllIllllIlIII.write(Type.COMPONENT, llllllllllllllIllIIIllIllllIlIIl);
                        llllllllllllllIllIIIllIllllIlIII.write(Type.UNSIGNED_BYTE, llllllllllllllIllIIIllIllllIlIII.read((Type<Integer>)Type.VAR_INT).shortValue());
                        llllllllllllllIllIIIllIllllIlIII.passthrough((Type<Object>)Type.INT);
                    }
                });
            }
        });
        final BlockRewriter lllllllllllllIllIIlIIlIlIIlIIlII = new BlockRewriter(this.protocol, Type.POSITION);
        this.registerSetCooldown(ClientboundPackets1_14.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_14.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerSetSlot(ClientboundPackets1_14.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
        this.registerAdvancements(ClientboundPackets1_14.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        ((Protocol<ClientboundPackets1_14, ClientboundPackets1_13, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.TRADE_LIST, ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllIIIIlllIllIlllI) throws Exception {
                        llllllllllllllIllIIIIlllIllIlllI.write(Type.STRING, "minecraft:trader_list");
                        final int llllllllllllllIllIIIIlllIllIllIl = llllllllllllllIllIIIIlllIllIlllI.read((Type<Integer>)Type.VAR_INT);
                        llllllllllllllIllIIIIlllIllIlllI.write(Type.INT, llllllllllllllIllIIIIlllIllIllIl);
                        for (int llllllllllllllIllIIIIlllIllIllII = llllllllllllllIllIIIIlllIllIlllI.passthrough((Type<Short>)Type.UNSIGNED_BYTE), llllllllllllllIllIIIIlllIlllIIII = 0; llllllllllllllIllIIIIlllIlllIIII < llllllllllllllIllIIIIlllIllIllII; ++llllllllllllllIllIIIIlllIlllIIII) {
                            Item llllllllllllllIllIIIIlllIlllIIll = llllllllllllllIllIIIIlllIllIlllI.read(Type.FLAT_VAR_INT_ITEM);
                            llllllllllllllIllIIIIlllIlllIIll = BlockItemPackets1_14.this.handleItemToClient(llllllllllllllIllIIIIlllIlllIIll);
                            llllllllllllllIllIIIIlllIllIlllI.write(Type.FLAT_VAR_INT_ITEM, llllllllllllllIllIIIIlllIlllIIll);
                            Item llllllllllllllIllIIIIlllIlllIIlI = llllllllllllllIllIIIIlllIllIlllI.read(Type.FLAT_VAR_INT_ITEM);
                            llllllllllllllIllIIIIlllIlllIIlI = BlockItemPackets1_14.this.handleItemToClient(llllllllllllllIllIIIIlllIlllIIlI);
                            llllllllllllllIllIIIIlllIllIlllI.write(Type.FLAT_VAR_INT_ITEM, llllllllllllllIllIIIIlllIlllIIlI);
                            final boolean llllllllllllllIllIIIIlllIlllIIIl = llllllllllllllIllIIIIlllIllIlllI.passthrough((Type<Boolean>)Type.BOOLEAN);
                            if (llllllllllllllIllIIIIlllIlllIIIl) {
                                Item llllllllllllllIllIIIIlllIlllIlII = llllllllllllllIllIIIIlllIllIlllI.read(Type.FLAT_VAR_INT_ITEM);
                                llllllllllllllIllIIIIlllIlllIlII = BlockItemPackets1_14.this.handleItemToClient(llllllllllllllIllIIIIlllIlllIlII);
                                llllllllllllllIllIIIIlllIllIlllI.write(Type.FLAT_VAR_INT_ITEM, llllllllllllllIllIIIIlllIlllIlII);
                            }
                            llllllllllllllIllIIIIlllIllIlllI.passthrough((Type<Object>)Type.BOOLEAN);
                            llllllllllllllIllIIIIlllIllIlllI.passthrough((Type<Object>)Type.INT);
                            llllllllllllllIllIIIIlllIllIlllI.passthrough((Type<Object>)Type.INT);
                            llllllllllllllIllIIIIlllIllIlllI.read((Type<Object>)Type.INT);
                            llllllllllllllIllIIIIlllIllIlllI.read((Type<Object>)Type.INT);
                            llllllllllllllIllIIIIlllIllIlllI.read((Type<Object>)Type.FLOAT);
                        }
                        llllllllllllllIllIIIIlllIllIlllI.read((Type<Object>)Type.VAR_INT);
                        llllllllllllllIllIIIIlllIllIlllI.read((Type<Object>)Type.VAR_INT);
                        llllllllllllllIllIIIIlllIllIlllI.read((Type<Object>)Type.BOOLEAN);
                    }
                });
            }
        });
        ((Protocol<ClientboundPackets1_14, ClientboundPackets1_13, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.OPEN_BOOK, ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIllIlIlllIllllIII) throws Exception {
                        llllllllllllllIIllIlIlllIllllIII.write(Type.STRING, "minecraft:book_open");
                        llllllllllllllIIllIlIlllIllllIII.passthrough((Type<Object>)Type.VAR_INT);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.FLAT_VAR_INT_ITEM);
                this.handler(BlockItemPackets1_14.this.itemToClientHandler(Type.FLAT_VAR_INT_ITEM));
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlllIllIIIllIIIIlIl) throws Exception {
                        final int lllllllllllllIlllIllIIIllIIIIlll = lllllllllllllIlllIllIIIllIIIIlIl.get((Type<Integer>)Type.VAR_INT, 0);
                        final EntityType lllllllllllllIlllIllIIIllIIIIllI = lllllllllllllIlllIllIIIllIIIIlIl.user().getEntityTracker(Protocol1_13_2To1_14.class).entityType(lllllllllllllIlllIllIIIllIIIIlll);
                        if (lllllllllllllIlllIllIIIllIIIIllI == null) {
                            return;
                        }
                        if (lllllllllllllIlllIllIIIllIIIIllI.isOrHasParent(Entity1_14Types.ABSTRACT_HORSE)) {
                            lllllllllllllIlllIllIIIllIIIIlIl.setId(63);
                            lllllllllllllIlllIllIIIllIIIIlIl.resetReader();
                            lllllllllllllIlllIllIIIllIIIIlIl.passthrough((Type<Object>)Type.VAR_INT);
                            lllllllllllllIlllIllIIIllIIIIlIl.read((Type<Object>)Type.VAR_INT);
                            final Item lllllllllllllIlllIllIIIllIIIllII = lllllllllllllIlllIllIIIllIIIIlIl.read(Type.FLAT_VAR_INT_ITEM);
                            final int lllllllllllllIlllIllIIIllIIIlIll = (lllllllllllllIlllIllIIIllIIIllII == null || lllllllllllllIlllIllIIIllIIIllII.identifier() == 0) ? 0 : (lllllllllllllIlllIllIIIllIIIllII.identifier() - 726);
                            if (lllllllllllllIlllIllIIIllIIIlIll < 0 || lllllllllllllIlllIllIIIllIIIlIll > 3) {
                                ViaBackwards.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Received invalid horse armor: ").append(lllllllllllllIlllIllIIIllIIIllII)));
                                lllllllllllllIlllIllIIIllIIIIlIl.cancel();
                                return;
                            }
                            final List<Metadata> lllllllllllllIlllIllIIIllIIIlIlI = new ArrayList<Metadata>();
                            lllllllllllllIlllIllIIIllIIIlIlI.add(new Metadata(16, MetaType1_13_2.VarInt, lllllllllllllIlllIllIIIllIIIlIll));
                            lllllllllllllIlllIllIIIllIIIIlIl.write(Types1_13.METADATA_LIST, lllllllllllllIlllIllIIIllIIIlIlI);
                        }
                    }
                });
            }
        });
        final RecipeRewriter lllllllllllllIllIIlIIlIlIIlIIIll = new RecipeRewriter1_13_2(this.protocol);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.DECLARE_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    private final /* synthetic */ Set<String> removedTypes = ImmutableSet.of((Object)"crafting_special_suspiciousstew", (Object)"blasting", (Object)"smoking", (Object)"campfire_cooking", (Object)"stonecutting");
                    
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIlIIlllIlIIlllII) throws Exception {
                        final int llllllllllllllIIIlIIlllIlIIlllll = llllllllllllllIIIlIIlllIlIIlllII.passthrough((Type<Integer>)Type.VAR_INT);
                        int llllllllllllllIIIlIIlllIlIIllllI = 0;
                        for (int llllllllllllllIIIlIIlllIlIlIIIlI = 0; llllllllllllllIIIlIIlllIlIlIIIlI < llllllllllllllIIIlIIlllIlIIlllll; ++llllllllllllllIIIlIIlllIlIlIIIlI) {
                            String llllllllllllllIIIlIIlllIlIlIIlII = llllllllllllllIIIlIIlllIlIIlllII.read(Type.STRING);
                            final String llllllllllllllIIIlIIlllIlIlIIIll = llllllllllllllIIIlIIlllIlIIlllII.read(Type.STRING);
                            llllllllllllllIIIlIIlllIlIlIIlII = llllllllllllllIIIlIIlllIlIlIIlII.replace("minecraft:", "");
                            if (this.removedTypes.contains(llllllllllllllIIIlIIlllIlIlIIlII)) {
                                final byte llllllllllllllIIIlIIlllIlIIlIllI = (byte)llllllllllllllIIIlIIlllIlIlIIlII;
                                float llllllllllllllIIIlIIlllIlIIlIlIl = -1;
                                switch (((String)llllllllllllllIIIlIIlllIlIIlIllI).hashCode()) {
                                    case -1050336534: {
                                        if (((String)llllllllllllllIIIlIIlllIlIIlIllI).equals("blasting")) {
                                            llllllllllllllIIIlIIlllIlIIlIlIl = 0;
                                            break;
                                        }
                                        break;
                                    }
                                    case -2084878740: {
                                        if (((String)llllllllllllllIIIlIIlllIlIIlIllI).equals("smoking")) {
                                            llllllllllllllIIIlIIlllIlIIlIlIl = 1;
                                            break;
                                        }
                                        break;
                                    }
                                    case -68678766: {
                                        if (((String)llllllllllllllIIIlIIlllIlIIlIllI).equals("campfire_cooking")) {
                                            llllllllllllllIIIlIIlllIlIIlIlIl = 2;
                                            break;
                                        }
                                        break;
                                    }
                                    case -858939349: {
                                        if (((String)llllllllllllllIIIlIIlllIlIIlIllI).equals("stonecutting")) {
                                            llllllllllllllIIIlIIlllIlIIlIlIl = 3;
                                            break;
                                        }
                                        break;
                                    }
                                }
                                switch (llllllllllllllIIIlIIlllIlIIlIlIl) {
                                    case 0.0f:
                                    case 1.0f:
                                    case 2.0f: {
                                        llllllllllllllIIIlIIlllIlIIlllII.read(Type.STRING);
                                        llllllllllllllIIIlIIlllIlIIlllII.read(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT);
                                        llllllllllllllIIIlIIlllIlIIlllII.read(Type.FLAT_VAR_INT_ITEM);
                                        llllllllllllllIIIlIIlllIlIIlllII.read((Type<Object>)Type.FLOAT);
                                        llllllllllllllIIIlIIlllIlIIlllII.read((Type<Object>)Type.VAR_INT);
                                        break;
                                    }
                                    case 3.0f: {
                                        llllllllllllllIIIlIIlllIlIIlllII.read(Type.STRING);
                                        llllllllllllllIIIlIIlllIlIIlllII.read(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT);
                                        llllllllllllllIIIlIIlllIlIIlllII.read(Type.FLAT_VAR_INT_ITEM);
                                        break;
                                    }
                                }
                                ++llllllllllllllIIIlIIlllIlIIllllI;
                            }
                            else {
                                llllllllllllllIIIlIIlllIlIIlllII.write(Type.STRING, llllllllllllllIIIlIIlllIlIlIIIll);
                                llllllllllllllIIIlIIlllIlIIlllII.write(Type.STRING, llllllllllllllIIIlIIlllIlIlIIlII);
                                lllllllllllllIllIIlIIlIlIIlIIIll.handle(llllllllllllllIIIlIIlllIlIIlllII, llllllllllllllIIIlIIlllIlIlIIlII);
                            }
                        }
                        llllllllllllllIIIlIIlllIlIIlllII.set(Type.VAR_INT, 0, llllllllllllllIIIlIIlllIlIIlllll - llllllllllllllIIIlIIlllIlIIllllI);
                    }
                });
            }
        });
        this.registerClickWindow(ServerboundPackets1_13.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_13.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.BLOCK_BREAK_ANIMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.POSITION1_14, Type.POSITION);
                this.map(Type.BYTE);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.BLOCK_ENTITY_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14, Type.POSITION);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.BLOCK_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14, Type.POSITION);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.VAR_INT);
                final int llllllllllllllllllIIIIllllllIlIl;
                this.handler(llllllllllllllllllIIIIllllllIIll -> {
                    llllllllllllllllllIIIIllllllIlIl = ((Protocol1_13_2To1_14)BlockItemPackets1_14.this.protocol).getMappingData().getNewBlockId(llllllllllllllllllIIIIllllllIIll.get((Type<Integer>)Type.VAR_INT, 0));
                    if (llllllllllllllllllIIIIllllllIlIl == -1) {
                        llllllllllllllllllIIIIllllllIIll.cancel();
                    }
                    else {
                        llllllllllllllllllIIIIllllllIIll.set(Type.VAR_INT, 0, llllllllllllllllllIIIIllllllIlIl);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.BLOCK_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14, Type.POSITION);
                this.map(Type.VAR_INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIlIIIIIlIIIIIIIlI) throws Exception {
                        final int lllllllllllllIIIlIIIIIlIIIIIIIIl = lllllllllllllIIIlIIIIIlIIIIIIIlI.get((Type<Integer>)Type.VAR_INT, 0);
                        lllllllllllllIIIlIIIIIlIIIIIIIlI.set(Type.VAR_INT, 0, ((Protocol1_13_2To1_14)BlockItemPackets1_14.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIIlIIIIIlIIIIIIIIl));
                    }
                });
            }
        });
        lllllllllllllIllIIlIIlIlIIlIIlII.registerMultiBlockChange(ClientboundPackets1_14.MULTI_BLOCK_CHANGE);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.EXPLOSION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.map(Type.FLOAT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlIIlIllIlIIIIIIll) throws Exception {
                        for (int lllllllllllllIIlIIlIllIlIIIIIlIl = 0; lllllllllllllIIlIIlIllIlIIIIIlIl < 3; ++lllllllllllllIIlIIlIllIlIIIIIlIl) {
                            float lllllllllllllIIlIIlIllIlIIIIIllI = lllllllllllllIIlIIlIllIlIIIIIIll.get((Type<Float>)Type.FLOAT, lllllllllllllIIlIIlIllIlIIIIIlIl);
                            if (lllllllllllllIIlIIlIllIlIIIIIllI < 0.0f) {
                                lllllllllllllIIlIIlIllIlIIIIIllI = (float)Math.floor(lllllllllllllIIlIIlIllIlIIIIIllI);
                                lllllllllllllIIlIIlIllIlIIIIIIll.set(Type.FLOAT, lllllllllllllIIlIIlIllIlIIIIIlIl, lllllllllllllIIlIIlIllIlIIIIIllI);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.CHUNK_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIllIllIIIIIIIIIlIl) throws Exception {
                        final ClientWorld lllllllllllllIIllIllIIIIIIIIIlII = lllllllllllllIIllIllIIIIIIIIIlIl.user().get(ClientWorld.class);
                        final Chunk lllllllllllllIIllIllIIIIIIIIIIll = lllllllllllllIIllIllIIIIIIIIIlIl.read((Type<Chunk>)new Chunk1_14Type());
                        lllllllllllllIIllIllIIIIIIIIIlIl.write((Type<Chunk>)new Chunk1_13Type(lllllllllllllIIllIllIIIIIIIIIlII), lllllllllllllIIllIllIIIIIIIIIIll);
                        final ChunkLightStorage.ChunkLight lllllllllllllIIllIllIIIIIIIIIIlI = lllllllllllllIIllIllIIIIIIIIIlIl.user().get(ChunkLightStorage.class).getStoredLight(lllllllllllllIIllIllIIIIIIIIIIll.getX(), lllllllllllllIIllIllIIIIIIIIIIll.getZ());
                        for (int lllllllllllllIIllIllIIIIIIIIIlll = 0; lllllllllllllIIllIllIIIIIIIIIlll < lllllllllllllIIllIllIIIIIIIIIIll.getSections().length; ++lllllllllllllIIllIllIIIIIIIIIlll) {
                            final ChunkSection lllllllllllllIIllIllIIIIIIIIlIIl = lllllllllllllIIllIllIIIIIIIIIIll.getSections()[lllllllllllllIIllIllIIIIIIIIIlll];
                            if (lllllllllllllIIllIllIIIIIIIIlIIl != null) {
                                final ChunkSectionLight lllllllllllllIIllIllIIIIIIIIlIII = new ChunkSectionLightImpl();
                                lllllllllllllIIllIllIIIIIIIIlIIl.setLight(lllllllllllllIIllIllIIIIIIIIlIII);
                                if (lllllllllllllIIllIllIIIIIIIIIIlI == null) {
                                    lllllllllllllIIllIllIIIIIIIIlIII.setBlockLight(ChunkLightStorage.FULL_LIGHT);
                                    if (lllllllllllllIIllIllIIIIIIIIIlII.getEnvironment() == Environment.NORMAL) {
                                        lllllllllllllIIllIllIIIIIIIIlIII.setSkyLight(ChunkLightStorage.FULL_LIGHT);
                                    }
                                }
                                else {
                                    final byte[] lllllllllllllIIllIllIIIIIIIlIIIl = lllllllllllllIIllIllIIIIIIIIIIlI.getBlockLight()[lllllllllllllIIllIllIIIIIIIIIlll];
                                    lllllllllllllIIllIllIIIIIIIIlIII.setBlockLight((lllllllllllllIIllIllIIIIIIIlIIIl != null) ? lllllllllllllIIllIllIIIIIIIlIIIl : ChunkLightStorage.FULL_LIGHT);
                                    if (lllllllllllllIIllIllIIIIIIIIIlII.getEnvironment() == Environment.NORMAL) {
                                        final byte[] lllllllllllllIIllIllIIIIIIIlIIlI = lllllllllllllIIllIllIIIIIIIIIIlI.getSkyLight()[lllllllllllllIIllIllIIIIIIIIIlll];
                                        lllllllllllllIIllIllIIIIIIIIlIII.setSkyLight((lllllllllllllIIllIllIIIIIIIlIIlI != null) ? lllllllllllllIIllIllIIIIIIIlIIlI : ChunkLightStorage.FULL_LIGHT);
                                    }
                                }
                                if (Via.getConfig().isNonFullBlockLightFix() && lllllllllllllIIllIllIIIIIIIIlIIl.getNonAirBlocksCount() != 0 && lllllllllllllIIllIllIIIIIIIIlIII.hasBlockLight()) {
                                    for (int lllllllllllllIIllIllIIIIIIIIllIl = 0; lllllllllllllIIllIllIIIIIIIIllIl < 16; ++lllllllllllllIIllIllIIIIIIIIllIl) {
                                        for (int lllllllllllllIIllIllIIIIIIIIlllI = 0; lllllllllllllIIllIllIIIIIIIIlllI < 16; ++lllllllllllllIIllIllIIIIIIIIlllI) {
                                            for (int lllllllllllllIIllIllIIIIIIIIllll = 0; lllllllllllllIIllIllIIIIIIIIllll < 16; ++lllllllllllllIIllIllIIIIIIIIllll) {
                                                final int lllllllllllllIIllIllIIIIIIIlIIII = lllllllllllllIIllIllIIIIIIIIlIIl.getFlatBlock(lllllllllllllIIllIllIIIIIIIIllIl, lllllllllllllIIllIllIIIIIIIIlllI, lllllllllllllIIllIllIIIIIIIIllll);
                                                if (Protocol1_14To1_13_2.MAPPINGS.getNonFullBlocks().contains(lllllllllllllIIllIllIIIIIIIlIIII)) {
                                                    lllllllllllllIIllIllIIIIIIIIlIII.getBlockLightNibbleArray().set(lllllllllllllIIllIllIIIIIIIIllIl, lllllllllllllIIllIllIIIIIIIIlllI, lllllllllllllIIllIllIIIIIIIIllll, 0);
                                                }
                                            }
                                        }
                                    }
                                }
                                for (int lllllllllllllIIllIllIIIIIIIIlIlI = 0; lllllllllllllIIllIllIIIIIIIIlIlI < lllllllllllllIIllIllIIIIIIIIlIIl.getPaletteSize(); ++lllllllllllllIIllIllIIIIIIIIlIlI) {
                                    final int lllllllllllllIIllIllIIIIIIIIllII = lllllllllllllIIllIllIIIIIIIIlIIl.getPaletteEntry(lllllllllllllIIllIllIIIIIIIIlIlI);
                                    final int lllllllllllllIIllIllIIIIIIIIlIll = ((Protocol1_13_2To1_14)BlockItemPackets1_14.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIIllIllIIIIIIIIllII);
                                    lllllllllllllIIllIllIIIIIIIIlIIl.setPaletteEntry(lllllllllllllIIllIllIIIIIIIIlIlI, lllllllllllllIIllIllIIIIIIIIlIll);
                                }
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.UNLOAD_CHUNK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlllIIllIIlIllIlI) throws Exception {
                        final int lllllllllllllllIlllIIllIIlIlIlll = lllllllllllllllIlllIIllIIlIllIlI.passthrough((Type<Integer>)Type.INT);
                        final int lllllllllllllllIlllIIllIIlIlIlIl = lllllllllllllllIlllIIllIIlIllIlI.passthrough((Type<Integer>)Type.INT);
                        lllllllllllllllIlllIIllIIlIllIlI.user().get(ChunkLightStorage.class).unloadChunk(lllllllllllllllIlllIIllIIlIlIlll, lllllllllllllllIlllIIllIIlIlIlIl);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.EFFECT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.INT);
                this.map(Type.POSITION1_14, Type.POSITION);
                this.map(Type.INT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIIlIlIlIIlIllIIl) throws Exception {
                        final int lllllllllllllIlIIIlIlIlIIlIlllII = lllllllllllllIlIIIlIlIlIIlIllIIl.get((Type<Integer>)Type.INT, 0);
                        final int lllllllllllllIlIIIlIlIlIIlIllIll = lllllllllllllIlIIIlIlIlIIlIllIIl.get((Type<Integer>)Type.INT, 1);
                        if (lllllllllllllIlIIIlIlIlIIlIlllII == 1010) {
                            lllllllllllllIlIIIlIlIlIIlIllIIl.set(Type.INT, 1, ((Protocol1_13_2To1_14)BlockItemPackets1_14.this.protocol).getMappingData().getNewItemId(lllllllllllllIlIIIlIlIlIIlIllIll));
                        }
                        else if (lllllllllllllIlIIIlIlIlIIlIlllII == 2001) {
                            lllllllllllllIlIIIlIlIlIIlIllIIl.set(Type.INT, 1, ((Protocol1_13_2To1_14)BlockItemPackets1_14.this.protocol).getMappingData().getNewBlockStateId(lllllllllllllIlIIIlIlIlIIlIllIll));
                        }
                    }
                });
            }
        });
        this.registerSpawnParticle(ClientboundPackets1_14.SPAWN_PARTICLE, Type.FLAT_VAR_INT_ITEM, Type.FLOAT);
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.map(Type.BOOLEAN);
                this.map(Type.BOOLEAN, Type.NOTHING);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_14, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_14.SPAWN_POSITION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.POSITION1_14, Type.POSITION);
            }
        });
    }
}
