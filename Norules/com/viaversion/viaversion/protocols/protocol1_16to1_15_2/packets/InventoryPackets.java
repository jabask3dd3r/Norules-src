package com.viaversion.viaversion.protocols.protocol1_16to1_15_2.packets;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_15to1_14_4.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.types.*;
import java.util.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets extends ItemRewriter<Protocol1_16To1_15_2>
{
    public void registerPackets() {
        final PacketWrapper llllllllllllllllIlllIIIIlIIIlIII;
        final PacketHandler llllllllllllllllIlllIIIlIlIllIII = llllllllllllllllIlllIIIIlIIIlIlI -> {
            llllllllllllllllIlllIIIIlIIIlIII = llllllllllllllllIlllIIIIlIIIlIlI.create(ClientboundPackets1_16.SET_SLOT);
            llllllllllllllllIlllIIIIlIIIlIII.write(Type.UNSIGNED_BYTE, (Short)(-1));
            llllllllllllllllIlllIIIIlIIIlIII.write(Type.SHORT, (Short)(-1));
            llllllllllllllllIlllIIIIlIIIlIII.write(Type.FLAT_VAR_INT_ITEM, null);
            llllllllllllllllIlllIIIIlIIIlIII.send(Protocol1_16To1_15_2.class);
            return;
        };
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.COMPONENT);
                int lllllllllllllIIIlllllIllIlllIIlI;
                this.handler(lllllllllllllIIIlllllIllIlllIIll -> {
                    lllllllllllllIIIlllllIllIlllIIlI = lllllllllllllIIIlllllIllIlllIIll.get((Type<Integer>)Type.VAR_INT, 1);
                    if (lllllllllllllIIIlllllIllIlllIIlI >= 20) {
                        lllllllllllllIIIlllllIllIlllIIll.set(Type.VAR_INT, 1, ++lllllllllllllIIIlllllIllIlllIIlI);
                    }
                    return;
                });
                this.handler(llllllllllllllllIlllIIIlIlIllIII);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(llllllllllllllllIlllIIIlIlIllIII);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.WINDOW_PROPERTY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                final short lllllllllllllllllIIIlIIIIlllIlIl;
                short lllllllllllllllllIIIlIIIIlllIlll;
                ShortType short1;
                short lllllllllllllllllIIIlIIIIlllIlll2;
                final int n;
                this.handler(lllllllllllllllllIIIlIIIIlllIllI -> {
                    lllllllllllllllllIIIlIIIIlllIlIl = lllllllllllllllllIIIlIIIIlllIllI.get((Type<Short>)Type.SHORT, 0);
                    if (lllllllllllllllllIIIlIIIIlllIlIl >= 4 && lllllllllllllllllIIIlIIIIlllIlIl <= 6) {
                        lllllllllllllllllIIIlIIIIlllIlll = lllllllllllllllllIIIlIIIIlllIllI.get((Type<Short>)Type.SHORT, 1);
                        if (lllllllllllllllllIIIlIIIIlllIlll >= 11) {
                            short1 = Type.SHORT;
                            lllllllllllllllllIIIlIIIIlllIlll2 = (short)(lllllllllllllllllIIIlIIIIlllIlll + 1);
                            lllllllllllllllllIIIlIIIIlllIllI.set(short1, n, lllllllllllllllllIIIlIIIIlllIlll2);
                        }
                    }
                });
            }
        });
        this.registerSetCooldown(ClientboundPackets1_15.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_15.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerTradeList(ClientboundPackets1_15.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
        this.registerSetSlot(ClientboundPackets1_15.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
        this.registerAdvancements(ClientboundPackets1_15.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<ClientboundPackets1_15, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_15.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                final int llllllllllllllllIIlIllIIIlIIlIll;
                this.handler(llllllllllllllllIIlIllIIIlIIllIl -> {
                    llllllllllllllllIIlIllIIIlIIlIll = llllllllllllllllIIlIllIIIlIIllIl.read((Type<Integer>)Type.VAR_INT);
                    llllllllllllllllIIlIllIIIlIIllIl.write(Type.BYTE, (byte)llllllllllllllllIIlIllIIIlIIlIll);
                    InventoryPackets.this.handleItemToClient(llllllllllllllllIIlIllIIIlIIllIl.passthrough(Type.FLAT_VAR_INT_ITEM));
                });
            }
        });
        new RecipeRewriter1_14(this.protocol).registerDefaultHandler(ClientboundPackets1_15.DECLARE_RECIPES);
        this.registerClickWindow(ServerboundPackets1_16.CLICK_WINDOW, Type.FLAT_VAR_INT_ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_16.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_16>)this.protocol).registerServerbound(ServerboundPackets1_16.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllIIllIlllIIlIlIllllI -> InventoryPackets.this.handleItemToServer(lllllllllllllIIllIlllIIlIlIllllI.passthrough(Type.FLAT_VAR_INT_ITEM)));
            }
        });
        this.registerSpawnParticle(ClientboundPackets1_15.SPAWN_PARTICLE, Type.FLAT_VAR_INT_ITEM, Type.DOUBLE);
    }
    
    public static void newToOldAttributes(final Item llllllllllllllllIlllIIIIllIIIllI) {
        if (llllllllllllllllIlllIIIIllIIIllI.tag() == null) {
            return;
        }
        final ListTag llllllllllllllllIlllIIIIllIIIlIl = llllllllllllllllIlllIIIIllIIIllI.tag().get("AttributeModifiers");
        if (llllllllllllllllIlllIIIIllIIIlIl == null) {
            return;
        }
        for (final Tag llllllllllllllllIlllIIIIllIIIlll : llllllllllllllllIlllIIIIllIIIlIl) {
            final CompoundTag llllllllllllllllIlllIIIIllIIlIIl = (CompoundTag)llllllllllllllllIlllIIIIllIIIlll;
            rewriteAttributeName(llllllllllllllllIlllIIIIllIIlIIl, "AttributeName", true);
            rewriteAttributeName(llllllllllllllllIlllIIIIllIIlIIl, "Name", true);
            final IntArrayTag llllllllllllllllIlllIIIIllIIlIII = llllllllllllllllIlllIIIIllIIlIIl.get("UUID");
            if (llllllllllllllllIlllIIIIllIIlIII != null && llllllllllllllllIlllIIIIllIIlIII.getValue().length == 4) {
                final UUID llllllllllllllllIlllIIIIllIIlIlI = UUIDIntArrayType.uuidFromIntArray(llllllllllllllllIlllIIIIllIIlIII.getValue());
                llllllllllllllllIlllIIIIllIIlIIl.put("UUIDLeast", new LongTag(llllllllllllllllIlllIIIIllIIlIlI.getLeastSignificantBits()));
                llllllllllllllllIlllIIIIllIIlIIl.put("UUIDMost", new LongTag(llllllllllllllllIlllIIIIllIIlIlI.getMostSignificantBits()));
            }
        }
    }
    
    @Override
    public Item handleItemToServer(final Item llllllllllllllllIlllIIIlIIIlIllI) {
        if (llllllllllllllllIlllIIIlIIIlIllI == null) {
            return null;
        }
        llllllllllllllllIlllIIIlIIIlIllI.setIdentifier(Protocol1_16To1_15_2.MAPPINGS.getOldItemId(llllllllllllllllIlllIIIlIIIlIllI.identifier()));
        if (llllllllllllllllIlllIIIlIIIlIllI.identifier() == 771 && llllllllllllllllIlllIIIlIIIlIllI.tag() != null) {
            final CompoundTag llllllllllllllllIlllIIIlIIIlllII = llllllllllllllllIlllIIIlIIIlIllI.tag();
            final Tag llllllllllllllllIlllIIIlIIIllIll = llllllllllllllllIlllIIIlIIIlllII.get("SkullOwner");
            if (llllllllllllllllIlllIIIlIIIllIll instanceof CompoundTag) {
                final CompoundTag llllllllllllllllIlllIIIlIIlIIIII = (CompoundTag)llllllllllllllllIlllIIIlIIIllIll;
                final Tag llllllllllllllllIlllIIIlIIIllllI = llllllllllllllllIlllIIIlIIlIIIII.get("Id");
                if (llllllllllllllllIlllIIIlIIIllllI instanceof IntArrayTag) {
                    final UUID llllllllllllllllIlllIIIlIIlIIIll = UUIDIntArrayType.uuidFromIntArray((int[])llllllllllllllllIlllIIIlIIIllllI.getValue());
                    llllllllllllllllIlllIIIlIIlIIIII.put("Id", new StringTag(llllllllllllllllIlllIIIlIIlIIIll.toString()));
                }
            }
        }
        newToOldAttributes(llllllllllllllllIlllIIIlIIIlIllI);
        return llllllllllllllllIlllIIIlIIIlIllI;
    }
    
    public static void oldToNewAttributes(final Item llllllllllllllllIlllIIIIllllIlII) {
        if (llllllllllllllllIlllIIIIllllIlII.tag() == null) {
            return;
        }
        final ListTag llllllllllllllllIlllIIIIllllIIlI = llllllllllllllllIlllIIIIllllIlII.tag().get("AttributeModifiers");
        if (llllllllllllllllIlllIIIIllllIIlI == null) {
            return;
        }
        for (final Tag llllllllllllllllIlllIIIIllllIllI : llllllllllllllllIlllIIIIllllIIlI) {
            final CompoundTag llllllllllllllllIlllIIIIlllllIII = (CompoundTag)llllllllllllllllIlllIIIIllllIllI;
            rewriteAttributeName(llllllllllllllllIlllIIIIlllllIII, "AttributeName", false);
            rewriteAttributeName(llllllllllllllllIlllIIIIlllllIII, "Name", false);
            final Tag llllllllllllllllIlllIIIIllllIlll = llllllllllllllllIlllIIIIlllllIII.get("UUIDLeast");
            if (llllllllllllllllIlllIIIIllllIlll != null) {
                final Tag llllllllllllllllIlllIIIIlllllIlI = llllllllllllllllIlllIIIIlllllIII.get("UUIDMost");
                final int[] llllllllllllllllIlllIIIIlllllIIl = UUIDIntArrayType.bitsToIntArray(((NumberTag)llllllllllllllllIlllIIIIllllIlll).asLong(), ((NumberTag)llllllllllllllllIlllIIIIlllllIlI).asLong());
                llllllllllllllllIlllIIIIlllllIII.put("UUID", new IntArrayTag(llllllllllllllllIlllIIIIlllllIIl));
            }
        }
    }
    
    public static void rewriteAttributeName(final CompoundTag llllllllllllllllIlllIIIIlIlIIIll, final String llllllllllllllllIlllIIIIlIIllIII, final boolean llllllllllllllllIlllIIIIlIIlIlll) {
        final StringTag llllllllllllllllIlllIIIIlIIlllIl = llllllllllllllllIlllIIIIlIlIIIll.get(llllllllllllllllIlllIIIIlIIllIII);
        if (llllllllllllllllIlllIIIIlIIlllIl == null) {
            return;
        }
        String llllllllllllllllIlllIIIIlIIllIll = llllllllllllllllIlllIIIIlIIlllIl.getValue();
        if (llllllllllllllllIlllIIIIlIIlIlll && !llllllllllllllllIlllIIIIlIIllIll.startsWith("minecraft:")) {
            llllllllllllllllIlllIIIIlIIllIll = String.valueOf(new StringBuilder().append("minecraft:").append(llllllllllllllllIlllIIIIlIIllIll));
        }
        final String llllllllllllllllIlllIIIIlIIllIlI = (String)(llllllllllllllllIlllIIIIlIIlIlll ? Protocol1_16To1_15_2.MAPPINGS.getAttributeMappings().inverse() : Protocol1_16To1_15_2.MAPPINGS.getAttributeMappings()).get((Object)llllllllllllllllIlllIIIIlIIllIll);
        if (llllllllllllllllIlllIIIIlIIllIlI == null) {
            return;
        }
        llllllllllllllllIlllIIIIlIIlllIl.setValue(llllllllllllllllIlllIIIIlIIllIlI);
    }
    
    public InventoryPackets(final Protocol1_16To1_15_2 llllllllllllllllIlllIIIlIlIlllII) {
        super(llllllllllllllllIlllIIIlIlIlllII);
    }
    
    @Override
    public Item handleItemToClient(final Item llllllllllllllllIlllIIIlIlIIIIIl) {
        if (llllllllllllllllIlllIIIlIlIIIIIl == null) {
            return null;
        }
        if (llllllllllllllllIlllIIIlIlIIIIIl.identifier() == 771 && llllllllllllllllIlllIIIlIlIIIIIl.tag() != null) {
            final CompoundTag llllllllllllllllIlllIIIlIlIIlIII = llllllllllllllllIlllIIIlIlIIIIIl.tag();
            final Tag llllllllllllllllIlllIIIlIlIIIllI = llllllllllllllllIlllIIIlIlIIlIII.get("SkullOwner");
            if (llllllllllllllllIlllIIIlIlIIIllI instanceof CompoundTag) {
                final CompoundTag llllllllllllllllIlllIIIlIlIIllII = (CompoundTag)llllllllllllllllIlllIIIlIlIIIllI;
                final Tag llllllllllllllllIlllIIIlIlIIlIlI = llllllllllllllllIlllIIIlIlIIllII.get("Id");
                if (llllllllllllllllIlllIIIlIlIIlIlI instanceof StringTag) {
                    final UUID llllllllllllllllIlllIIIlIlIIllIl = UUID.fromString((String)llllllllllllllllIlllIIIlIlIIlIlI.getValue());
                    llllllllllllllllIlllIIIlIlIIllII.put("Id", new IntArrayTag(UUIDIntArrayType.uuidToIntArray(llllllllllllllllIlllIIIlIlIIllIl)));
                }
            }
        }
        oldToNewAttributes(llllllllllllllllIlllIIIlIlIIIIIl);
        llllllllllllllllIlllIIIlIlIIIIIl.setIdentifier(Protocol1_16To1_15_2.MAPPINGS.getNewItemId(llllllllllllllllIlllIIIlIlIIIIIl.identifier()));
        return llllllllllllllllIlllIIIlIlIIIIIl;
    }
}
