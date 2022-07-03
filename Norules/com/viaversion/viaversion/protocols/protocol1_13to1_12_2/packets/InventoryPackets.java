package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.packets;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_12_1to1_12.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import java.nio.charset.*;
import com.google.common.base.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.libs.opennbt.conversion.*;
import com.google.common.primitives.*;
import java.util.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets extends ItemRewriter<Protocol1_13To1_12_2>
{
    private static final /* synthetic */ String NBT_TAG_NAME;
    
    static {
        NBT_TAG_NAME = String.valueOf(new StringBuilder().append("ViaVersion|").append(Protocol1_13To1_12_2.class.getSimpleName()));
    }
    
    public InventoryPackets(final Protocol1_13To1_12_2 lllllllllllllIlIIllIIIlIllIlIllI) {
        super(lllllllllllllIlIIllIIIlIllIlIllI);
    }
    
    public void registerPackets() {
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12_1.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.ITEM, Type.FLAT_ITEM);
                this.handler(InventoryPackets.this.itemToClientHandler(Type.FLAT_ITEM));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12_1.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.ITEM_ARRAY, Type.FLAT_ITEM_ARRAY);
                this.handler(InventoryPackets.this.itemArrayHandler(Type.FLAT_ITEM_ARRAY));
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12_1.WINDOW_PROPERTY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIIIlIlIIlIIlIlll) throws Exception {
                        final short lllllllllllllllIIIIlIlIIlIIlIllI = lllllllllllllllIIIIlIlIIlIIlIlll.get((Type<Short>)Type.SHORT, 0);
                        if (lllllllllllllllIIIIlIlIIlIIlIllI >= 4 && lllllllllllllllIIIIlIlIIlIIlIllI <= 6) {
                            lllllllllllllllIIIIlIlIIlIIlIlll.set(Type.SHORT, 1, (short)((Protocol1_13To1_12_2)InventoryPackets.this.protocol).getMappingData().getEnchantmentMappings().getNewId(lllllllllllllllIIIIlIlIIlIIlIlll.get((Type<Short>)Type.SHORT, 1)));
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12_1.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIlIIIlllIIllIIlll) throws Exception {
                        String llllllllllllllIIlIIIlllIIllIIllI = llllllllllllllIIlIIIlllIIllIIlll.get(Type.STRING, 0);
                        if (llllllllllllllIIlIIIlllIIllIIllI.equalsIgnoreCase("MC|StopSound")) {
                            final String llllllllllllllIIlIIIlllIIlllIllI = llllllllllllllIIlIIIlllIIllIIlll.read(Type.STRING);
                            final String llllllllllllllIIlIIIlllIIlllIlIl = llllllllllllllIIlIIIlllIIllIIlll.read(Type.STRING);
                            llllllllllllllIIlIIIlllIIllIIlll.clearPacket();
                            llllllllllllllIIlIIIlllIIllIIlll.setId(76);
                            byte llllllllllllllIIlIIIlllIIlllIlII = 0;
                            llllllllllllllIIlIIIlllIIllIIlll.write(Type.BYTE, llllllllllllllIIlIIIlllIIlllIlII);
                            if (!llllllllllllllIIlIIIlllIIlllIllI.isEmpty()) {
                                llllllllllllllIIlIIIlllIIlllIlII |= 0x1;
                                Optional<SoundSource> llllllllllllllIIlIIIlllIIlllIlll = SoundSource.findBySource(llllllllllllllIIlIIIlllIIlllIllI);
                                if (!llllllllllllllIIlIIIlllIIlllIlll.isPresent()) {
                                    if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                        Via.getPlatform().getLogger().info(String.valueOf(new StringBuilder().append("Could not handle unknown sound source ").append(llllllllllllllIIlIIIlllIIlllIllI).append(" falling back to default: master")));
                                    }
                                    llllllllllllllIIlIIIlllIIlllIlll = Optional.of(SoundSource.MASTER);
                                }
                                llllllllllllllIIlIIIlllIIllIIlll.write(Type.VAR_INT, llllllllllllllIIlIIIlllIIlllIlll.get().getId());
                            }
                            if (!llllllllllllllIIlIIIlllIIlllIlIl.isEmpty()) {
                                llllllllllllllIIlIIIlllIIlllIlII |= 0x2;
                                llllllllllllllIIlIIIlllIIllIIlll.write(Type.STRING, llllllllllllllIIlIIIlllIIlllIlIl);
                            }
                            llllllllllllllIIlIIIlllIIllIIlll.set(Type.BYTE, 0, llllllllllllllIIlIIIlllIIlllIlII);
                            return;
                        }
                        if (llllllllllllllIIlIIIlllIIllIIllI.equalsIgnoreCase("MC|TrList")) {
                            llllllllllllllIIlIIIlllIIllIIllI = "minecraft:trader_list";
                            llllllllllllllIIlIIIlllIIllIIlll.passthrough((Type<Object>)Type.INT);
                            for (int llllllllllllllIIlIIIlllIIllIlllI = llllllllllllllIIlIIIlllIIllIIlll.passthrough((Type<Short>)Type.UNSIGNED_BYTE), llllllllllllllIIlIIIlllIIllIllll = 0; llllllllllllllIIlIIIlllIIllIllll < llllllllllllllIIlIIIlllIIllIlllI; ++llllllllllllllIIlIIIlllIIllIllll) {
                                final Item llllllllllllllIIlIIIlllIIlllIIlI = llllllllllllllIIlIIIlllIIllIIlll.read(Type.ITEM);
                                InventoryPackets.this.handleItemToClient(llllllllllllllIIlIIIlllIIlllIIlI);
                                llllllllllllllIIlIIIlllIIllIIlll.write(Type.FLAT_ITEM, llllllllllllllIIlIIIlllIIlllIIlI);
                                final Item llllllllllllllIIlIIIlllIIlllIIIl = llllllllllllllIIlIIIlllIIllIIlll.read(Type.ITEM);
                                InventoryPackets.this.handleItemToClient(llllllllllllllIIlIIIlllIIlllIIIl);
                                llllllllllllllIIlIIIlllIIllIIlll.write(Type.FLAT_ITEM, llllllllllllllIIlIIIlllIIlllIIIl);
                                final boolean llllllllllllllIIlIIIlllIIlllIIII = llllllllllllllIIlIIIlllIIllIIlll.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (llllllllllllllIIlIIIlllIIlllIIII) {
                                    final Item llllllllllllllIIlIIIlllIIlllIIll = llllllllllllllIIlIIIlllIIllIIlll.read(Type.ITEM);
                                    InventoryPackets.this.handleItemToClient(llllllllllllllIIlIIIlllIIlllIIll);
                                    llllllllllllllIIlIIIlllIIllIIlll.write(Type.FLAT_ITEM, llllllllllllllIIlIIIlllIIlllIIll);
                                }
                                llllllllllllllIIlIIIlllIIllIIlll.passthrough((Type<Object>)Type.BOOLEAN);
                                llllllllllllllIIlIIIlllIIllIIlll.passthrough((Type<Object>)Type.INT);
                                llllllllllllllIIlIIIlllIIllIIlll.passthrough((Type<Object>)Type.INT);
                            }
                        }
                        else {
                            final String llllllllllllllIIlIIIlllIIllIlIIl = llllllllllllllIIlIIIlllIIllIIllI;
                            llllllllllllllIIlIIIlllIIllIIllI = InventoryPackets.getNewPluginChannelId(llllllllllllllIIlIIIlllIIllIIllI);
                            if (llllllllllllllIIlIIIlllIIllIIllI == null) {
                                if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                    Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring outgoing plugin message with channel: ").append(llllllllllllllIIlIIIlllIIllIlIIl)));
                                }
                                llllllllllllllIIlIIIlllIIllIIlll.cancel();
                                return;
                            }
                            if (llllllllllllllIIlIIIlllIIllIIllI.equals("minecraft:register") || llllllllllllllIIlIIIlllIIllIIllI.equals("minecraft:unregister")) {
                                final String[] llllllllllllllIIlIIIlllIIllIlIll = new String(llllllllllllllIIlIIIlllIIllIIlll.read(Type.REMAINING_BYTES), StandardCharsets.UTF_8).split("\u0000");
                                final List<String> llllllllllllllIIlIIIlllIIllIlIlI = new ArrayList<String>();
                                for (int llllllllllllllIIlIIIlllIIllIllII = 0; llllllllllllllIIlIIIlllIIllIllII < llllllllllllllIIlIIIlllIIllIlIll.length; ++llllllllllllllIIlIIIlllIIllIllII) {
                                    final String llllllllllllllIIlIIIlllIIllIllIl = InventoryPackets.getNewPluginChannelId(llllllllllllllIIlIIIlllIIllIlIll[llllllllllllllIIlIIIlllIIllIllII]);
                                    if (llllllllllllllIIlIIIlllIIllIllIl != null) {
                                        llllllllllllllIIlIIIlllIIllIlIlI.add(llllllllllllllIIlIIIlllIIllIllIl);
                                    }
                                    else if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                        Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring plugin channel in outgoing REGISTER: ").append(llllllllllllllIIlIIIlllIIllIlIll[llllllllllllllIIlIIIlllIIllIllII])));
                                    }
                                }
                                if (llllllllllllllIIlIIIlllIIllIlIlI.isEmpty()) {
                                    llllllllllllllIIlIIIlllIIllIIlll.cancel();
                                    return;
                                }
                                llllllllllllllIIlIIIlllIIllIIlll.write(Type.REMAINING_BYTES, Joiner.on('\0').join((Iterable)llllllllllllllIIlIIIlllIIllIlIlI).getBytes(StandardCharsets.UTF_8));
                            }
                        }
                        llllllllllllllIIlIIIlllIIllIIlll.set(Type.STRING, 0, llllllllllllllIIlIIIlllIIllIIllI);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_12_1, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_12_1.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.ITEM, Type.FLAT_ITEM);
                this.handler(InventoryPackets.this.itemToClientHandler(Type.FLAT_ITEM));
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.VAR_INT);
                this.map(Type.FLAT_ITEM, Type.ITEM);
                this.handler(InventoryPackets.this.itemToServerHandler(Type.ITEM));
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlIIlIIlIlIIIIlIl) throws Exception {
                        final String lllllllllllllllIlIIlIIlIlIIIIllI;
                        String lllllllllllllllIlIIlIIlIlIIIIlll = lllllllllllllllIlIIlIIlIlIIIIllI = lllllllllllllllIlIIlIIlIlIIIIlIl.get(Type.STRING, 0);
                        lllllllllllllllIlIIlIIlIlIIIIlll = InventoryPackets.getOldPluginChannelId(lllllllllllllllIlIIlIIlIlIIIIlll);
                        if (lllllllllllllllIlIIlIIlIlIIIIlll == null) {
                            if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring incoming plugin message with channel: ").append(lllllllllllllllIlIIlIIlIlIIIIllI)));
                            }
                            lllllllllllllllIlIIlIIlIlIIIIlIl.cancel();
                            return;
                        }
                        if (lllllllllllllllIlIIlIIlIlIIIIlll.equals("REGISTER") || lllllllllllllllIlIIlIIlIlIIIIlll.equals("UNREGISTER")) {
                            final String[] lllllllllllllllIlIIlIIlIlIIIlIll = new String(lllllllllllllllIlIIlIIlIlIIIIlIl.read(Type.REMAINING_BYTES), StandardCharsets.UTF_8).split("\u0000");
                            final List<String> lllllllllllllllIlIIlIIlIlIIIlIlI = new ArrayList<String>();
                            for (int lllllllllllllllIlIIlIIlIlIIIllII = 0; lllllllllllllllIlIIlIIlIlIIIllII < lllllllllllllllIlIIlIIlIlIIIlIll.length; ++lllllllllllllllIlIIlIIlIlIIIllII) {
                                final String lllllllllllllllIlIIlIIlIlIIIllIl = InventoryPackets.getOldPluginChannelId(lllllllllllllllIlIIlIIlIlIIIlIll[lllllllllllllllIlIIlIIlIlIIIllII]);
                                if (lllllllllllllllIlIIlIIlIlIIIllIl != null) {
                                    lllllllllllllllIlIIlIIlIlIIIlIlI.add(lllllllllllllllIlIIlIIlIlIIIllIl);
                                }
                                else if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                                    Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Ignoring plugin channel in incoming REGISTER: ").append(lllllllllllllllIlIIlIIlIlIIIlIll[lllllllllllllllIlIIlIIlIlIIIllII])));
                                }
                            }
                            lllllllllllllllIlIIlIIlIlIIIIlIl.write(Type.REMAINING_BYTES, Joiner.on('\0').join((Iterable)lllllllllllllllIlIIlIIlIlIIIlIlI).getBytes(StandardCharsets.UTF_8));
                        }
                        lllllllllllllllIlIIlIIlIlIIIIlIl.set(Type.STRING, 0, lllllllllllllllIlIIlIIlIlIIIIlll);
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)this.protocol).registerServerbound(ServerboundPackets1_13.CREATIVE_INVENTORY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.map(Type.FLAT_ITEM, Type.ITEM);
                this.handler(InventoryPackets.this.itemToServerHandler(Type.ITEM));
            }
        });
    }
    
    public static boolean isDamageable(final int lllllllllllllIlIIllIIIlIIIlIIlII) {
        return (lllllllllllllIlIIllIIIlIIIlIIlII >= 256 && lllllllllllllIlIIllIIIlIIIlIIlII <= 259) || lllllllllllllIlIIllIIIlIIIlIIlII == 261 || (lllllllllllllIlIIllIIIlIIIlIIlII >= 267 && lllllllllllllIlIIllIIIlIIIlIIlII <= 279) || (lllllllllllllIlIIllIIIlIIIlIIlII >= 283 && lllllllllllllIlIIllIIIlIIIlIIlII <= 286) || (lllllllllllllIlIIllIIIlIIIlIIlII >= 290 && lllllllllllllIlIIllIIIlIIIlIIlII <= 294) || (lllllllllllllIlIIllIIIlIIIlIIlII >= 298 && lllllllllllllIlIIllIIIlIIIlIIlII <= 317) || lllllllllllllIlIIllIIIlIIIlIIlII == 346 || lllllllllllllIlIIllIIIlIIIlIIlII == 359 || lllllllllllllIlIIllIIIlIIIlIIlII == 398 || lllllllllllllIlIIllIIIlIIIlIIlII == 442 || lllllllllllllIlIIllIIIlIIIlIIlII == 443;
    }
    
    @Override
    public Item handleItemToClient(final Item lllllllllllllIlIIllIIIlIlIIlIllI) {
        if (lllllllllllllIlIIllIIIlIlIIlIllI == null) {
            return null;
        }
        CompoundTag lllllllllllllIlIIllIIIlIlIIllIIl = lllllllllllllIlIIllIIIlIlIIlIllI.tag();
        final int lllllllllllllIlIIllIIIlIlIIllIII = lllllllllllllIlIIllIIIlIlIIlIllI.identifier() << 16 | (lllllllllllllIlIIllIIIlIlIIlIllI.data() & 0xFFFF);
        int lllllllllllllIlIIllIIIlIlIIlIlll = lllllllllllllIlIIllIIIlIlIIlIllI.identifier() << 4 | (lllllllllllllIlIIllIIIlIlIIlIllI.data() & 0xF);
        if (isDamageable(lllllllllllllIlIIllIIIlIlIIlIllI.identifier())) {
            if (lllllllllllllIlIIllIIIlIlIIllIIl == null) {
                lllllllllllllIlIIllIIIlIlIIlIllI.setTag(lllllllllllllIlIIllIIIlIlIIllIIl = new CompoundTag());
            }
            lllllllllllllIlIIllIIIlIlIIllIIl.put("Damage", new IntTag(lllllllllllllIlIIllIIIlIlIIlIllI.data()));
        }
        if (lllllllllllllIlIIllIIIlIlIIlIllI.identifier() == 358) {
            if (lllllllllllllIlIIllIIIlIlIIllIIl == null) {
                lllllllllllllIlIIllIIIlIlIIlIllI.setTag(lllllllllllllIlIIllIIIlIlIIllIIl = new CompoundTag());
            }
            lllllllllllllIlIIllIIIlIlIIllIIl.put("map", new IntTag(lllllllllllllIlIIllIIIlIlIIlIllI.data()));
        }
        if (lllllllllllllIlIIllIIIlIlIIllIIl != null) {
            final boolean lllllllllllllIlIIllIIIlIlIIlllII = lllllllllllllIlIIllIIIlIlIIlIllI.identifier() == 425;
            if ((lllllllllllllIlIIllIIIlIlIIlllII || lllllllllllllIlIIllIIIlIlIIlIllI.identifier() == 442) && lllllllllllllIlIIllIIIlIlIIllIIl.get("BlockEntityTag") instanceof CompoundTag) {
                final CompoundTag lllllllllllllIlIIllIIIlIlIlllllI = lllllllllllllIlIIllIIIlIlIIllIIl.get("BlockEntityTag");
                if (lllllllllllllIlIIllIIIlIlIlllllI.get("Base") instanceof IntTag) {
                    final IntTag lllllllllllllIlIIllIIIlIllIIIIIl = lllllllllllllIlIIllIIIlIlIlllllI.get("Base");
                    if (lllllllllllllIlIIllIIIlIlIIlllII) {
                        lllllllllllllIlIIllIIIlIlIIlIlll = 6800 + lllllllllllllIlIIllIIIlIllIIIIIl.asInt();
                    }
                    lllllllllllllIlIIllIIIlIllIIIIIl.setValue(15 - lllllllllllllIlIIllIIIlIllIIIIIl.asInt());
                }
                if (lllllllllllllIlIIllIIIlIlIlllllI.get("Patterns") instanceof ListTag) {
                    for (final Tag lllllllllllllIlIIllIIIlIlIllllll : lllllllllllllIlIIllIIIlIlIlllllI.get("Patterns")) {
                        if (lllllllllllllIlIIllIIIlIlIllllll instanceof CompoundTag) {
                            final IntTag lllllllllllllIlIIllIIIlIllIIIIII = ((CompoundTag)lllllllllllllIlIIllIIIlIlIllllll).get("Color");
                            lllllllllllllIlIIllIIIlIllIIIIII.setValue(15 - lllllllllllllIlIIllIIIlIllIIIIII.asInt());
                        }
                    }
                }
            }
            if (lllllllllllllIlIIllIIIlIlIIllIIl.get("display") instanceof CompoundTag) {
                final CompoundTag lllllllllllllIlIIllIIIlIlIllllII = lllllllllllllIlIIllIIIlIlIIllIIl.get("display");
                if (lllllllllllllIlIIllIIIlIlIllllII.get("Name") instanceof StringTag) {
                    final StringTag lllllllllllllIlIIllIIIlIlIllllIl = lllllllllllllIlIIllIIIlIlIllllII.get("Name");
                    lllllllllllllIlIIllIIIlIlIllllII.put(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|Name")), new StringTag(lllllllllllllIlIIllIIIlIlIllllIl.getValue()));
                    lllllllllllllIlIIllIIIlIlIllllIl.setValue(ChatRewriter.legacyTextToJsonString(lllllllllllllIlIIllIIIlIlIllllIl.getValue(), true));
                }
            }
            if (lllllllllllllIlIIllIIIlIlIIllIIl.get("ench") instanceof ListTag) {
                final ListTag lllllllllllllIlIIllIIIlIlIllIllI = lllllllllllllIlIIllIIIlIlIIllIIl.get("ench");
                final ListTag lllllllllllllIlIIllIIIlIlIllIlIl = new ListTag(CompoundTag.class);
                for (final Tag lllllllllllllIlIIllIIIlIlIllIlll : lllllllllllllIlIIllIIIlIlIllIllI) {
                    final NumberTag lllllllllllllIlIIllIIIlIlIlllIII;
                    if (lllllllllllllIlIIllIIIlIlIllIlll instanceof CompoundTag && (lllllllllllllIlIIllIIIlIlIlllIII = ((CompoundTag)lllllllllllllIlIIllIIIlIlIllIlll).get("id")) != null) {
                        final CompoundTag lllllllllllllIlIIllIIIlIlIlllIll = new CompoundTag();
                        final short lllllllllllllIlIIllIIIlIlIlllIlI = lllllllllllllIlIIllIIIlIlIlllIII.asShort();
                        String lllllllllllllIlIIllIIIlIlIlllIIl = (String)Protocol1_13To1_12_2.MAPPINGS.getOldEnchantmentsIds().get((Object)lllllllllllllIlIIllIIIlIlIlllIlI);
                        if (lllllllllllllIlIIllIIIlIlIlllIIl == null) {
                            lllllllllllllIlIIllIIIlIlIlllIIl = String.valueOf(new StringBuilder().append("viaversion:legacy/").append(lllllllllllllIlIIllIIIlIlIlllIlI));
                        }
                        lllllllllllllIlIIllIIIlIlIlllIll.put("id", new StringTag(lllllllllllllIlIIllIIIlIlIlllIIl));
                        lllllllllllllIlIIllIIIlIlIlllIll.put("lvl", new ShortTag(((CompoundTag)lllllllllllllIlIIllIIIlIlIllIlll).get("lvl").asShort()));
                        lllllllllllllIlIIllIIIlIlIllIlIl.add(lllllllllllllIlIIllIIIlIlIlllIll);
                    }
                }
                lllllllllllllIlIIllIIIlIlIIllIIl.remove("ench");
                lllllllllllllIlIIllIIIlIlIIllIIl.put("Enchantments", lllllllllllllIlIIllIIIlIlIllIlIl);
            }
            if (lllllllllllllIlIIllIIIlIlIIllIIl.get("StoredEnchantments") instanceof ListTag) {
                final ListTag lllllllllllllIlIIllIIIlIlIllIIII = lllllllllllllIlIIllIIIlIlIIllIIl.get("StoredEnchantments");
                final ListTag lllllllllllllIlIIllIIIlIlIlIllll = new ListTag(CompoundTag.class);
                for (final Tag lllllllllllllIlIIllIIIlIlIllIIIl : lllllllllllllIlIIllIIIlIlIllIIII) {
                    if (lllllllllllllIlIIllIIIlIlIllIIIl instanceof CompoundTag) {
                        final CompoundTag lllllllllllllIlIIllIIIlIlIllIlII = new CompoundTag();
                        final short lllllllllllllIlIIllIIIlIlIllIIll = ((CompoundTag)lllllllllllllIlIIllIIIlIlIllIIIl).get("id").asShort();
                        String lllllllllllllIlIIllIIIlIlIllIIlI = (String)Protocol1_13To1_12_2.MAPPINGS.getOldEnchantmentsIds().get((Object)lllllllllllllIlIIllIIIlIlIllIIll);
                        if (lllllllllllllIlIIllIIIlIlIllIIlI == null) {
                            lllllllllllllIlIIllIIIlIlIllIIlI = String.valueOf(new StringBuilder().append("viaversion:legacy/").append(lllllllllllllIlIIllIIIlIlIllIIll));
                        }
                        lllllllllllllIlIIllIIIlIlIllIlII.put("id", new StringTag(lllllllllllllIlIIllIIIlIlIllIIlI));
                        lllllllllllllIlIIllIIIlIlIllIlII.put("lvl", new ShortTag(((CompoundTag)lllllllllllllIlIIllIIIlIlIllIIIl).get("lvl").asShort()));
                        lllllllllllllIlIIllIIIlIlIlIllll.add(lllllllllllllIlIIllIIIlIlIllIlII);
                    }
                }
                lllllllllllllIlIIllIIIlIlIIllIIl.remove("StoredEnchantments");
                lllllllllllllIlIIllIIIlIlIIllIIl.put("StoredEnchantments", lllllllllllllIlIIllIIIlIlIlIllll);
            }
            if (lllllllllllllIlIIllIIIlIlIIllIIl.get("CanPlaceOn") instanceof ListTag) {
                final ListTag lllllllllllllIlIIllIIIlIlIlIlIII = lllllllllllllIlIIllIIIlIlIIllIIl.get("CanPlaceOn");
                final ListTag lllllllllllllIlIIllIIIlIlIlIIlll = new ListTag(StringTag.class);
                lllllllllllllIlIIllIIIlIlIIllIIl.put(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|CanPlaceOn")), ConverterRegistry.convertToTag(ConverterRegistry.convertToValue(lllllllllllllIlIIllIIIlIlIlIlIII)));
                for (final Tag lllllllllllllIlIIllIIIlIlIlIlIIl : lllllllllllllIlIIllIIIlIlIlIlIII) {
                    final Object lllllllllllllIlIIllIIIlIlIlIllIl = lllllllllllllIlIIllIIIlIlIlIlIIl.getValue();
                    String lllllllllllllIlIIllIIIlIlIlIllII = lllllllllllllIlIIllIIIlIlIlIllIl.toString().replace("minecraft:", "");
                    final String lllllllllllllIlIIllIIIlIlIlIlIll = BlockIdData.numberIdToString.get(Ints.tryParse(lllllllllllllIlIIllIIIlIlIlIllII));
                    if (lllllllllllllIlIIllIIIlIlIlIlIll != null) {
                        lllllllllllllIlIIllIIIlIlIlIllII = lllllllllllllIlIIllIIIlIlIlIlIll;
                    }
                    final String[] lllllllllllllIlIIllIIIlIlIlIlIlI = BlockIdData.blockIdMapping.get(lllllllllllllIlIIllIIIlIlIlIllII.toLowerCase(Locale.ROOT));
                    if (lllllllllllllIlIIllIIIlIlIlIlIlI != null) {
                        final long lllllllllllllIlIIllIIIlIlIIIlIIl = (Object)lllllllllllllIlIIllIIIlIlIlIlIlI;
                        final long lllllllllllllIlIIllIIIlIlIIIlIII = lllllllllllllIlIIllIIIlIlIIIlIIl.length;
                        for (Exception lllllllllllllIlIIllIIIlIlIIIIlll = (Exception)0; lllllllllllllIlIIllIIIlIlIIIIlll < lllllllllllllIlIIllIIIlIlIIIlIII; ++lllllllllllllIlIIllIIIlIlIIIIlll) {
                            final String lllllllllllllIlIIllIIIlIlIlIlllI = lllllllllllllIlIIllIIIlIlIIIlIIl[lllllllllllllIlIIllIIIlIlIIIIlll];
                            lllllllllllllIlIIllIIIlIlIlIIlll.add(new StringTag(lllllllllllllIlIIllIIIlIlIlIlllI));
                        }
                    }
                    else {
                        lllllllllllllIlIIllIIIlIlIlIIlll.add(new StringTag(lllllllllllllIlIIllIIIlIlIlIllII.toLowerCase(Locale.ROOT)));
                    }
                }
                lllllllllllllIlIIllIIIlIlIIllIIl.put("CanPlaceOn", lllllllllllllIlIIllIIIlIlIlIIlll);
            }
            if (lllllllllllllIlIIllIIIlIlIIllIIl.get("CanDestroy") instanceof ListTag) {
                final ListTag lllllllllllllIlIIllIIIlIlIlIIIII = lllllllllllllIlIIllIIIlIlIIllIIl.get("CanDestroy");
                final ListTag lllllllllllllIlIIllIIIlIlIIlllll = new ListTag(StringTag.class);
                lllllllllllllIlIIllIIIlIlIIllIIl.put(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|CanDestroy")), ConverterRegistry.convertToTag(ConverterRegistry.convertToValue(lllllllllllllIlIIllIIIlIlIlIIIII)));
                for (final Tag lllllllllllllIlIIllIIIlIlIlIIIIl : lllllllllllllIlIIllIIIlIlIlIIIII) {
                    final Object lllllllllllllIlIIllIIIlIlIlIIlIl = lllllllllllllIlIIllIIIlIlIlIIIIl.getValue();
                    String lllllllllllllIlIIllIIIlIlIlIIlII = lllllllllllllIlIIllIIIlIlIlIIlIl.toString().replace("minecraft:", "");
                    final String lllllllllllllIlIIllIIIlIlIlIIIll = BlockIdData.numberIdToString.get(Ints.tryParse(lllllllllllllIlIIllIIIlIlIlIIlII));
                    if (lllllllllllllIlIIllIIIlIlIlIIIll != null) {
                        lllllllllllllIlIIllIIIlIlIlIIlII = lllllllllllllIlIIllIIIlIlIlIIIll;
                    }
                    final String[] lllllllllllllIlIIllIIIlIlIlIIIlI = BlockIdData.blockIdMapping.get(lllllllllllllIlIIllIIIlIlIlIIlII.toLowerCase(Locale.ROOT));
                    if (lllllllllllllIlIIllIIIlIlIlIIIlI != null) {
                        final long lllllllllllllIlIIllIIIlIlIIIlIIl = (Object)lllllllllllllIlIIllIIIlIlIlIIIlI;
                        final long lllllllllllllIlIIllIIIlIlIIIlIII = lllllllllllllIlIIllIIIlIlIIIlIIl.length;
                        for (Exception lllllllllllllIlIIllIIIlIlIIIIlll = (Exception)0; lllllllllllllIlIIllIIIlIlIIIIlll < lllllllllllllIlIIllIIIlIlIIIlIII; ++lllllllllllllIlIIllIIIlIlIIIIlll) {
                            final String lllllllllllllIlIIllIIIlIlIlIIllI = lllllllllllllIlIIllIIIlIlIIIlIIl[lllllllllllllIlIIllIIIlIlIIIIlll];
                            lllllllllllllIlIIllIIIlIlIIlllll.add(new StringTag(lllllllllllllIlIIllIIIlIlIlIIllI));
                        }
                    }
                    else {
                        lllllllllllllIlIIllIIIlIlIIlllll.add(new StringTag(lllllllllllllIlIIllIIIlIlIlIIlII.toLowerCase(Locale.ROOT)));
                    }
                }
                lllllllllllllIlIIllIIIlIlIIllIIl.put("CanDestroy", lllllllllllllIlIIllIIIlIlIIlllll);
            }
            if (lllllllllllllIlIIllIIIlIlIIlIllI.identifier() == 383) {
                if (lllllllllllllIlIIllIIIlIlIIllIIl.get("EntityTag") instanceof CompoundTag) {
                    final CompoundTag lllllllllllllIlIIllIIIlIlIIlllIl = lllllllllllllIlIIllIIIlIlIIllIIl.get("EntityTag");
                    if (lllllllllllllIlIIllIIIlIlIIlllIl.get("id") instanceof StringTag) {
                        final StringTag lllllllllllllIlIIllIIIlIlIIllllI = lllllllllllllIlIIllIIIlIlIIlllIl.get("id");
                        lllllllllllllIlIIllIIIlIlIIlIlll = SpawnEggRewriter.getSpawnEggId(lllllllllllllIlIIllIIIlIlIIllllI.getValue());
                        if (lllllllllllllIlIIllIIIlIlIIlIlll == -1) {
                            lllllllllllllIlIIllIIIlIlIIlIlll = 25100288;
                        }
                        else {
                            lllllllllllllIlIIllIIIlIlIIlllIl.remove("id");
                            if (lllllllllllllIlIIllIIIlIlIIlllIl.isEmpty()) {
                                lllllllllllllIlIIllIIIlIlIIllIIl.remove("EntityTag");
                            }
                        }
                    }
                    else {
                        lllllllllllllIlIIllIIIlIlIIlIlll = 25100288;
                    }
                }
                else {
                    lllllllllllllIlIIllIIIlIlIIlIlll = 25100288;
                }
            }
            if (lllllllllllllIlIIllIIIlIlIIllIIl.isEmpty()) {
                lllllllllllllIlIIllIIIlIlIIlIllI.setTag(lllllllllllllIlIIllIIIlIlIIllIIl = null);
            }
        }
        if (!Protocol1_13To1_12_2.MAPPINGS.getItemMappings().containsKey(lllllllllllllIlIIllIIIlIlIIlIlll)) {
            if (!isDamageable(lllllllllllllIlIIllIIIlIlIIlIllI.identifier()) && lllllllllllllIlIIllIIIlIlIIlIllI.identifier() != 358) {
                if (lllllllllllllIlIIllIIIlIlIIllIIl == null) {
                    lllllllllllllIlIIllIIIlIlIIlIllI.setTag(lllllllllllllIlIIllIIIlIlIIllIIl = new CompoundTag());
                }
                lllllllllllllIlIIllIIIlIlIIllIIl.put(InventoryPackets.NBT_TAG_NAME, new IntTag(lllllllllllllIlIIllIIIlIlIIllIII));
            }
            if (lllllllllllllIlIIllIIIlIlIIlIllI.identifier() == 31 && lllllllllllllIlIIllIIIlIlIIlIllI.data() == 0) {
                lllllllllllllIlIIllIIIlIlIIlIlll = 512;
            }
            else if (Protocol1_13To1_12_2.MAPPINGS.getItemMappings().containsKey(lllllllllllllIlIIllIIIlIlIIlIlll & 0xFFFFFFF0)) {
                lllllllllllllIlIIllIIIlIlIIlIlll &= 0xFFFFFFF0;
            }
            else {
                if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                    Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Failed to get 1.13 item for ").append(lllllllllllllIlIIllIIIlIlIIlIllI.identifier())));
                }
                lllllllllllllIlIIllIIIlIlIIlIlll = 16;
            }
        }
        lllllllllllllIlIIllIIIlIlIIlIllI.setIdentifier(Protocol1_13To1_12_2.MAPPINGS.getItemMappings().get(lllllllllllllIlIIllIIIlIlIIlIlll));
        lllllllllllllIlIIllIIIlIlIIlIllI.setData((short)0);
        return lllllllllllllIlIIllIIIlIlIIlIllI;
    }
    
    @Override
    public Item handleItemToServer(final Item lllllllllllllIlIIllIIIlIIlIIIllI) {
        if (lllllllllllllIlIIllIIIlIIlIIIllI == null) {
            return null;
        }
        Integer lllllllllllllIlIIllIIIlIIlIIlIIl = null;
        boolean lllllllllllllIlIIllIIIlIIlIIlIII = false;
        CompoundTag lllllllllllllIlIIllIIIlIIlIIIlll = lllllllllllllIlIIllIIIlIIlIIIllI.tag();
        if (lllllllllllllIlIIllIIIlIIlIIIlll != null && lllllllllllllIlIIllIIIlIIlIIIlll.get(InventoryPackets.NBT_TAG_NAME) instanceof IntTag) {
            lllllllllllllIlIIllIIIlIIlIIlIIl = lllllllllllllIlIIllIIIlIIlIIIlll.get(InventoryPackets.NBT_TAG_NAME).asInt();
            lllllllllllllIlIIllIIIlIIlIIIlll.remove(InventoryPackets.NBT_TAG_NAME);
            lllllllllllllIlIIllIIIlIIlIIlIII = true;
        }
        if (lllllllllllllIlIIllIIIlIIlIIlIIl == null) {
            final int lllllllllllllIlIIllIIIlIIllIlIll = Protocol1_13To1_12_2.MAPPINGS.getItemMappings().inverse().get(lllllllllllllIlIIllIIIlIIlIIIllI.identifier());
            if (lllllllllllllIlIIllIIIlIIllIlIll != -1) {
                final Optional<String> lllllllllllllIlIIllIIIlIIllIllII = SpawnEggRewriter.getEntityId(lllllllllllllIlIIllIIIlIIllIlIll);
                if (lllllllllllllIlIIllIIIlIIllIllII.isPresent()) {
                    lllllllllllllIlIIllIIIlIIlIIlIIl = 25100288;
                    if (lllllllllllllIlIIllIIIlIIlIIIlll == null) {
                        lllllllllllllIlIIllIIIlIIlIIIllI.setTag(lllllllllllllIlIIllIIIlIIlIIIlll = new CompoundTag());
                    }
                    if (!lllllllllllllIlIIllIIIlIIlIIIlll.contains("EntityTag")) {
                        final CompoundTag lllllllllllllIlIIllIIIlIIllIllIl = new CompoundTag();
                        lllllllllllllIlIIllIIIlIIllIllIl.put("id", new StringTag(lllllllllllllIlIIllIIIlIIllIllII.get()));
                        lllllllllllllIlIIllIIIlIIlIIIlll.put("EntityTag", lllllllllllllIlIIllIIIlIIllIllIl);
                    }
                }
                else {
                    lllllllllllllIlIIllIIIlIIlIIlIIl = (lllllllllllllIlIIllIIIlIIllIlIll >> 4 << 16 | (lllllllllllllIlIIllIIIlIIllIlIll & 0xF));
                }
            }
        }
        if (lllllllllllllIlIIllIIIlIIlIIlIIl == null) {
            if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                Via.getPlatform().getLogger().warning(String.valueOf(new StringBuilder().append("Failed to get 1.12 item for ").append(lllllllllllllIlIIllIIIlIIlIIIllI.identifier())));
            }
            lllllllllllllIlIIllIIIlIIlIIlIIl = 65536;
        }
        lllllllllllllIlIIllIIIlIIlIIIllI.setIdentifier((short)(lllllllllllllIlIIllIIIlIIlIIlIIl >> 16));
        lllllllllllllIlIIllIIIlIIlIIIllI.setData((short)(lllllllllllllIlIIllIIIlIIlIIlIIl & 0xFFFF));
        if (lllllllllllllIlIIllIIIlIIlIIIlll != null) {
            if (isDamageable(lllllllllllllIlIIllIIIlIIlIIIllI.identifier()) && lllllllllllllIlIIllIIIlIIlIIIlll.get("Damage") instanceof IntTag) {
                if (!lllllllllllllIlIIllIIIlIIlIIlIII) {
                    lllllllllllllIlIIllIIIlIIlIIIllI.setData((short)(int)lllllllllllllIlIIllIIIlIIlIIIlll.get("Damage").getValue());
                }
                lllllllllllllIlIIllIIIlIIlIIIlll.remove("Damage");
            }
            if (lllllllllllllIlIIllIIIlIIlIIIllI.identifier() == 358 && lllllllllllllIlIIllIIIlIIlIIIlll.get("map") instanceof IntTag) {
                if (!lllllllllllllIlIIllIIIlIIlIIlIII) {
                    lllllllllllllIlIIllIIIlIIlIIIllI.setData((short)(int)lllllllllllllIlIIllIIIlIIlIIIlll.get("map").getValue());
                }
                lllllllllllllIlIIllIIIlIIlIIIlll.remove("map");
            }
            if ((lllllllllllllIlIIllIIIlIIlIIIllI.identifier() == 442 || lllllllllllllIlIIllIIIlIIlIIIllI.identifier() == 425) && lllllllllllllIlIIllIIIlIIlIIIlll.get("BlockEntityTag") instanceof CompoundTag) {
                final CompoundTag lllllllllllllIlIIllIIIlIIllIIlll = lllllllllllllIlIIllIIIlIIlIIIlll.get("BlockEntityTag");
                if (lllllllllllllIlIIllIIIlIIllIIlll.get("Base") instanceof IntTag) {
                    final IntTag lllllllllllllIlIIllIIIlIIllIlIlI = lllllllllllllIlIIllIIIlIIllIIlll.get("Base");
                    lllllllllllllIlIIllIIIlIIllIlIlI.setValue(15 - lllllllllllllIlIIllIIIlIIllIlIlI.asInt());
                }
                if (lllllllllllllIlIIllIIIlIIllIIlll.get("Patterns") instanceof ListTag) {
                    for (final Tag lllllllllllllIlIIllIIIlIIllIlIII : lllllllllllllIlIIllIIIlIIllIIlll.get("Patterns")) {
                        if (lllllllllllllIlIIllIIIlIIllIlIII instanceof CompoundTag) {
                            final IntTag lllllllllllllIlIIllIIIlIIllIlIIl = ((CompoundTag)lllllllllllllIlIIllIIIlIIllIlIII).get("Color");
                            lllllllllllllIlIIllIIIlIIllIlIIl.setValue(15 - lllllllllllllIlIIllIIIlIIllIlIIl.asInt());
                        }
                    }
                }
            }
            if (lllllllllllllIlIIllIIIlIIlIIIlll.get("display") instanceof CompoundTag) {
                final CompoundTag lllllllllllllIlIIllIIIlIIllIIlII = lllllllllllllIlIIllIIIlIIlIIIlll.get("display");
                if (lllllllllllllIlIIllIIIlIIllIIlII.get("Name") instanceof StringTag) {
                    final StringTag lllllllllllllIlIIllIIIlIIllIIllI = lllllllllllllIlIIllIIIlIIllIIlII.get("Name");
                    final StringTag lllllllllllllIlIIllIIIlIIllIIlIl = lllllllllllllIlIIllIIIlIIllIIlII.remove(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|Name")));
                    lllllllllllllIlIIllIIIlIIllIIllI.setValue((lllllllllllllIlIIllIIIlIIllIIlIl != null) ? lllllllllllllIlIIllIIIlIIllIIlIl.getValue() : ChatRewriter.jsonToLegacyText(lllllllllllllIlIIllIIIlIIllIIllI.getValue()));
                }
            }
            if (lllllllllllllIlIIllIIIlIIlIIIlll.get("Enchantments") instanceof ListTag) {
                final ListTag lllllllllllllIlIIllIIIlIIlIlllll = lllllllllllllIlIIllIIIlIIlIIIlll.get("Enchantments");
                final ListTag lllllllllllllIlIIllIIIlIIlIllllI = new ListTag(CompoundTag.class);
                for (final Tag lllllllllllllIlIIllIIIlIIllIIIII : lllllllllllllIlIIllIIIlIIlIlllll) {
                    if (lllllllllllllIlIIllIIIlIIllIIIII instanceof CompoundTag) {
                        final CompoundTag lllllllllllllIlIIllIIIlIIllIIIll = new CompoundTag();
                        final String lllllllllllllIlIIllIIIlIIllIIIlI = (String)((CompoundTag)lllllllllllllIlIIllIIIlIIllIIIII).get("id").getValue();
                        Short lllllllllllllIlIIllIIIlIIllIIIIl = (Short)Protocol1_13To1_12_2.MAPPINGS.getOldEnchantmentsIds().inverse().get((Object)lllllllllllllIlIIllIIIlIIllIIIlI);
                        if (lllllllllllllIlIIllIIIlIIllIIIIl == null && lllllllllllllIlIIllIIIlIIllIIIlI.startsWith("viaversion:legacy/")) {
                            lllllllllllllIlIIllIIIlIIllIIIIl = Short.valueOf(lllllllllllllIlIIllIIIlIIllIIIlI.substring(18));
                        }
                        if (lllllllllllllIlIIllIIIlIIllIIIIl == null) {
                            continue;
                        }
                        lllllllllllllIlIIllIIIlIIllIIIll.put("id", new ShortTag(lllllllllllllIlIIllIIIlIIllIIIIl));
                        lllllllllllllIlIIllIIIlIIllIIIll.put("lvl", new ShortTag(((CompoundTag)lllllllllllllIlIIllIIIlIIllIIIII).get("lvl").asShort()));
                        lllllllllllllIlIIllIIIlIIlIllllI.add(lllllllllllllIlIIllIIIlIIllIIIll);
                    }
                }
                lllllllllllllIlIIllIIIlIIlIIIlll.remove("Enchantments");
                lllllllllllllIlIIllIIIlIIlIIIlll.put("ench", lllllllllllllIlIIllIIIlIIlIllllI);
            }
            if (lllllllllllllIlIIllIIIlIIlIIIlll.get("StoredEnchantments") instanceof ListTag) {
                final ListTag lllllllllllllIlIIllIIIlIIlIllIIl = lllllllllllllIlIIllIIIlIIlIIIlll.get("StoredEnchantments");
                final ListTag lllllllllllllIlIIllIIIlIIlIllIII = new ListTag(CompoundTag.class);
                for (final Tag lllllllllllllIlIIllIIIlIIlIllIlI : lllllllllllllIlIIllIIIlIIlIllIIl) {
                    if (lllllllllllllIlIIllIIIlIIlIllIlI instanceof CompoundTag) {
                        final CompoundTag lllllllllllllIlIIllIIIlIIlIlllIl = new CompoundTag();
                        final String lllllllllllllIlIIllIIIlIIlIlllII = (String)((CompoundTag)lllllllllllllIlIIllIIIlIIlIllIlI).get("id").getValue();
                        Short lllllllllllllIlIIllIIIlIIlIllIll = (Short)Protocol1_13To1_12_2.MAPPINGS.getOldEnchantmentsIds().inverse().get((Object)lllllllllllllIlIIllIIIlIIlIlllII);
                        if (lllllllllllllIlIIllIIIlIIlIllIll == null && lllllllllllllIlIIllIIIlIIlIlllII.startsWith("viaversion:legacy/")) {
                            lllllllllllllIlIIllIIIlIIlIllIll = Short.valueOf(lllllllllllllIlIIllIIIlIIlIlllII.substring(18));
                        }
                        if (lllllllllllllIlIIllIIIlIIlIllIll == null) {
                            continue;
                        }
                        lllllllllllllIlIIllIIIlIIlIlllIl.put("id", new ShortTag(lllllllllllllIlIIllIIIlIIlIllIll));
                        lllllllllllllIlIIllIIIlIIlIlllIl.put("lvl", new ShortTag(((CompoundTag)lllllllllllllIlIIllIIIlIIlIllIlI).get("lvl").asShort()));
                        lllllllllllllIlIIllIIIlIIlIllIII.add(lllllllllllllIlIIllIIIlIIlIlllIl);
                    }
                }
                lllllllllllllIlIIllIIIlIIlIIIlll.remove("StoredEnchantments");
                lllllllllllllIlIIllIIIlIIlIIIlll.put("StoredEnchantments", lllllllllllllIlIIllIIIlIIlIllIII);
            }
            if (lllllllllllllIlIIllIIIlIIlIIIlll.get(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|CanPlaceOn"))) instanceof ListTag) {
                lllllllllllllIlIIllIIIlIIlIIIlll.put("CanPlaceOn", ConverterRegistry.convertToTag(ConverterRegistry.convertToValue(lllllllllllllIlIIllIIIlIIlIIIlll.get(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|CanPlaceOn"))))));
                lllllllllllllIlIIllIIIlIIlIIIlll.remove(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|CanPlaceOn")));
            }
            else if (lllllllllllllIlIIllIIIlIIlIIIlll.get("CanPlaceOn") instanceof ListTag) {
                final ListTag lllllllllllllIlIIllIIIlIIlIlIIll = lllllllllllllIlIIllIIIlIIlIIIlll.get("CanPlaceOn");
                final ListTag lllllllllllllIlIIllIIIlIIlIlIIlI = new ListTag(StringTag.class);
                for (final Tag lllllllllllllIlIIllIIIlIIlIlIlII : lllllllllllllIlIIllIIIlIIlIlIIll) {
                    final Object lllllllllllllIlIIllIIIlIIlIlIllI = lllllllllllllIlIIllIIIlIIlIlIlII.getValue();
                    final String[] lllllllllllllIlIIllIIIlIIlIlIlIl = BlockIdData.fallbackReverseMapping.get((lllllllllllllIlIIllIIIlIIlIlIllI instanceof String) ? ((String)lllllllllllllIlIIllIIIlIIlIlIllI).replace("minecraft:", "") : null);
                    if (lllllllllllllIlIIllIIIlIIlIlIlIl != null) {
                        final Exception lllllllllllllIlIIllIIIlIIIllllII = (Object)lllllllllllllIlIIllIIIlIIlIlIlIl;
                        final double lllllllllllllIlIIllIIIlIIIlllIll = lllllllllllllIlIIllIIIlIIIllllII.length;
                        for (byte lllllllllllllIlIIllIIIlIIIlllIlI = 0; lllllllllllllIlIIllIIIlIIIlllIlI < lllllllllllllIlIIllIIIlIIIlllIll; ++lllllllllllllIlIIllIIIlIIIlllIlI) {
                            final String lllllllllllllIlIIllIIIlIIlIlIlll = lllllllllllllIlIIllIIIlIIIllllII[lllllllllllllIlIIllIIIlIIIlllIlI];
                            lllllllllllllIlIIllIIIlIIlIlIIlI.add(new StringTag(lllllllllllllIlIIllIIIlIIlIlIlll));
                        }
                    }
                    else {
                        lllllllllllllIlIIllIIIlIIlIlIIlI.add(lllllllllllllIlIIllIIIlIIlIlIlII);
                    }
                }
                lllllllllllllIlIIllIIIlIIlIIIlll.put("CanPlaceOn", lllllllllllllIlIIllIIIlIIlIlIIlI);
            }
            if (lllllllllllllIlIIllIIIlIIlIIIlll.get(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|CanDestroy"))) instanceof ListTag) {
                lllllllllllllIlIIllIIIlIIlIIIlll.put("CanDestroy", ConverterRegistry.convertToTag(ConverterRegistry.convertToValue(lllllllllllllIlIIllIIIlIIlIIIlll.get(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|CanDestroy"))))));
                lllllllllllllIlIIllIIIlIIlIIIlll.remove(String.valueOf(new StringBuilder().append(InventoryPackets.NBT_TAG_NAME).append("|CanDestroy")));
            }
            else if (lllllllllllllIlIIllIIIlIIlIIIlll.get("CanDestroy") instanceof ListTag) {
                final ListTag lllllllllllllIlIIllIIIlIIlIIllIl = lllllllllllllIlIIllIIIlIIlIIIlll.get("CanDestroy");
                final ListTag lllllllllllllIlIIllIIIlIIlIIllII = new ListTag(StringTag.class);
                for (final Tag lllllllllllllIlIIllIIIlIIlIIlllI : lllllllllllllIlIIllIIIlIIlIIllIl) {
                    final Object lllllllllllllIlIIllIIIlIIlIlIIII = lllllllllllllIlIIllIIIlIIlIIlllI.getValue();
                    final String[] lllllllllllllIlIIllIIIlIIlIIllll = BlockIdData.fallbackReverseMapping.get((lllllllllllllIlIIllIIIlIIlIlIIII instanceof String) ? ((String)lllllllllllllIlIIllIIIlIIlIlIIII).replace("minecraft:", "") : null);
                    if (lllllllllllllIlIIllIIIlIIlIIllll != null) {
                        final Exception lllllllllllllIlIIllIIIlIIIllllII = (Object)lllllllllllllIlIIllIIIlIIlIIllll;
                        final double lllllllllllllIlIIllIIIlIIIlllIll = lllllllllllllIlIIllIIIlIIIllllII.length;
                        for (byte lllllllllllllIlIIllIIIlIIIlllIlI = 0; lllllllllllllIlIIllIIIlIIIlllIlI < lllllllllllllIlIIllIIIlIIIlllIll; ++lllllllllllllIlIIllIIIlIIIlllIlI) {
                            final String lllllllllllllIlIIllIIIlIIlIlIIIl = lllllllllllllIlIIllIIIlIIIllllII[lllllllllllllIlIIllIIIlIIIlllIlI];
                            lllllllllllllIlIIllIIIlIIlIIllII.add(new StringTag(lllllllllllllIlIIllIIIlIIlIlIIIl));
                        }
                    }
                    else {
                        lllllllllllllIlIIllIIIlIIlIIllII.add(lllllllllllllIlIIllIIIlIIlIIlllI);
                    }
                }
                lllllllllllllIlIIllIIIlIIlIIIlll.put("CanDestroy", lllllllllllllIlIIllIIIlIIlIIllII);
            }
        }
        return lllllllllllllIlIIllIIIlIIlIIIllI;
    }
    
    public static String getOldPluginChannelId(String lllllllllllllIlIIllIIIlIIIllIIlI) {
        lllllllllllllIlIIllIIIlIIIllIIlI = (char)MappingData.validateNewChannel((String)lllllllllllllIlIIllIIIlIIIllIIlI);
        if (lllllllllllllIlIIllIIIlIIIllIIlI == null) {
            return null;
        }
        final boolean lllllllllllllIlIIllIIIlIIIllIIIl = lllllllllllllIlIIllIIIlIIIllIIlI != '\0';
        byte lllllllllllllIlIIllIIIlIIIllIIII = -1;
        switch (((String)lllllllllllllIlIIllIIIlIIIllIIIl).hashCode()) {
            case 1963953250: {
                if (((String)lllllllllllllIlIIllIIIlIIIllIIIl).equals("minecraft:trader_list")) {
                    lllllllllllllIlIIllIIIlIIIllIIII = 0;
                    break;
                }
                break;
            }
            case -420924333: {
                if (((String)lllllllllllllIlIIllIIIlIIIllIIIl).equals("minecraft:book_open")) {
                    lllllllllllllIlIIllIIIlIIIllIIII = 1;
                    break;
                }
                break;
            }
            case 832866277: {
                if (((String)lllllllllllllIlIIllIIIlIIIllIIIl).equals("minecraft:debug/paths")) {
                    lllllllllllllIlIIllIIIlIIIllIIII = 2;
                    break;
                }
                break;
            }
            case 1745645488: {
                if (((String)lllllllllllllIlIIllIIIlIIIllIIIl).equals("minecraft:debug/neighbors_update")) {
                    lllllllllllllIlIIllIIIlIIIllIIII = 3;
                    break;
                }
                break;
            }
            case 339275216: {
                if (((String)lllllllllllllIlIIllIIIlIIIllIIIl).equals("minecraft:register")) {
                    lllllllllllllIlIIllIIIlIIIllIIII = 4;
                    break;
                }
                break;
            }
            case -1963049943: {
                if (((String)lllllllllllllIlIIllIIIlIIIllIIIl).equals("minecraft:unregister")) {
                    lllllllllllllIlIIllIIIlIIIllIIII = 5;
                    break;
                }
                break;
            }
            case -1149721734: {
                if (((String)lllllllllllllIlIIllIIIlIIIllIIIl).equals("minecraft:brand")) {
                    lllllllllllllIlIIllIIIlIIIllIIII = 6;
                    break;
                }
                break;
            }
            case -234943831: {
                if (((String)lllllllllllllIlIIllIIIlIIIllIIIl).equals("bungeecord:main")) {
                    lllllllllllllIlIIllIIIlIIIllIIII = 7;
                    break;
                }
                break;
            }
        }
        switch (lllllllllllllIlIIllIIIlIIIllIIII) {
            case 0: {
                return "MC|TrList";
            }
            case 1: {
                return "MC|BOpen";
            }
            case 2: {
                return "MC|DebugPath";
            }
            case 3: {
                return "MC|DebugNeighborsUpdate";
            }
            case 4: {
                return "REGISTER";
            }
            case 5: {
                return "UNREGISTER";
            }
            case 6: {
                return "MC|Brand";
            }
            case 7: {
                return "BungeeCord";
            }
            default: {
                final String lllllllllllllIlIIllIIIlIIIllIlII = (String)Protocol1_13To1_12_2.MAPPINGS.getChannelMappings().inverse().get((Object)lllllllllllllIlIIllIIIlIIIllIIlI);
                if (lllllllllllllIlIIllIIIlIIIllIlII != null) {
                    return lllllllllllllIlIIllIIIlIIIllIlII;
                }
                return (String)((((String)lllllllllllllIlIIllIIIlIIIllIIlI).length() > 20) ? ((String)lllllllllllllIlIIllIIIlIIIllIIlI).substring(0, 20) : lllllllllllllIlIIllIIIlIIIllIIlI);
            }
        }
    }
    
    public static String getNewPluginChannelId(final String lllllllllllllIlIIllIIIlIlIIIIIII) {
        final char lllllllllllllIlIIllIIIlIIllllllI = (char)lllllllllllllIlIIllIIIlIlIIIIIII;
        int lllllllllllllIlIIllIIIlIIlllllIl = -1;
        switch (((String)lllllllllllllIlIIllIIIlIIllllllI).hashCode()) {
            case -37059198: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("MC|TrList")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 0;
                    break;
                }
                break;
            }
            case -294893183: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("MC|Brand")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 1;
                    break;
                }
                break;
            }
            case -295921722: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("MC|BOpen")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 2;
                    break;
                }
                break;
            }
            case 125533714: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("MC|DebugPath")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 3;
                    break;
                }
                break;
            }
            case 2076087261: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("MC|DebugNeighborsUpdate")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 4;
                    break;
                }
                break;
            }
            case 92413603: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("REGISTER")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 5;
                    break;
                }
                break;
            }
            case 1321107516: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("UNREGISTER")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 6;
                    break;
                }
                break;
            }
            case 1537336522: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("BungeeCord")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 7;
                    break;
                }
                break;
            }
            case -234943831: {
                if (((String)lllllllllllllIlIIllIIIlIIllllllI).equals("bungeecord:main")) {
                    lllllllllllllIlIIllIIIlIIlllllIl = 8;
                    break;
                }
                break;
            }
        }
        switch (lllllllllllllIlIIllIIIlIIlllllIl) {
            case 0: {
                return "minecraft:trader_list";
            }
            case 1: {
                return "minecraft:brand";
            }
            case 2: {
                return "minecraft:book_open";
            }
            case 3: {
                return "minecraft:debug/paths";
            }
            case 4: {
                return "minecraft:debug/neighbors_update";
            }
            case 5: {
                return "minecraft:register";
            }
            case 6: {
                return "minecraft:unregister";
            }
            case 7: {
                return "bungeecord:main";
            }
            case 8: {
                return null;
            }
            default: {
                final String lllllllllllllIlIIllIIIlIlIIIIIIl = (String)Protocol1_13To1_12_2.MAPPINGS.getChannelMappings().get((Object)lllllllllllllIlIIllIIIlIlIIIIIII);
                if (lllllllllllllIlIIllIIIlIlIIIIIIl != null) {
                    return lllllllllllllIlIIllIIIlIlIIIIIIl;
                }
                return MappingData.isValid1_13Channel(lllllllllllllIlIIllIIIlIlIIIIIII) ? lllllllllllllIlIIllIIIlIlIIIIIII : null;
            }
        }
    }
}
