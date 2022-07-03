package com.viaversion.viabackwards.protocol.protocol1_11to1_11_1.packets;

import com.viaversion.viabackwards.protocol.protocol1_11to1_11_1.*;
import com.viaversion.viabackwards.api.rewriters.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.rewriter.meta.*;
import com.viaversion.viaversion.api.minecraft.metadata.*;
import com.viaversion.viaversion.libs.opennbt.tag.builtin.*;
import com.viaversion.viaversion.api.protocol.*;

public class ItemPackets1_11_1 extends LegacyBlockItemRewriter<Protocol1_11To1_11_1>
{
    private /* synthetic */ LegacyEnchantmentRewriter enchantmentRewriter;
    
    @Override
    public Item handleItemToServer(final Item lllllllllllllIlIlIIlIIIIIIlIIllI) {
        if (lllllllllllllIlIlIIlIIIIIIlIIllI == null) {
            return null;
        }
        super.handleItemToServer(lllllllllllllIlIlIIlIIIIIIlIIllI);
        final CompoundTag lllllllllllllIlIlIIlIIIIIIlIlIII = lllllllllllllIlIlIIlIIIIIIlIIllI.tag();
        if (lllllllllllllIlIlIIlIIIIIIlIlIII == null) {
            return lllllllllllllIlIlIIlIIIIIIlIIllI;
        }
        if (lllllllllllllIlIlIIlIIIIIIlIlIII.contains(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|ench")))) {
            this.enchantmentRewriter.rewriteEnchantmentsToServer(lllllllllllllIlIlIIlIIIIIIlIlIII, false);
        }
        if (lllllllllllllIlIlIIlIIIIIIlIlIII.contains(String.valueOf(new StringBuilder().append(this.nbtTagName).append("|StoredEnchantments")))) {
            this.enchantmentRewriter.rewriteEnchantmentsToServer(lllllllllllllIlIlIIlIIIIIIlIlIII, true);
        }
        return lllllllllllllIlIlIIlIIIIIIlIIllI;
    }
    
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
                    public void handle(final PacketWrapper lllllllllllllIIllIIlIIllIlllIIlI) throws Exception {
                        if (lllllllllllllIIllIIlIIllIlllIIlI.get(Type.STRING, 0).equalsIgnoreCase("MC|TrList")) {
                            lllllllllllllIIllIIlIIllIlllIIlI.passthrough((Type<Object>)Type.INT);
                            for (int lllllllllllllIIllIIlIIllIlllIllI = lllllllllllllIIllIIlIIllIlllIIlI.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIIllIIlIIllIlllIlll = 0; lllllllllllllIIllIIlIIllIlllIlll < lllllllllllllIIllIIlIIllIlllIllI; ++lllllllllllllIIllIIlIIllIlllIlll) {
                                lllllllllllllIIllIIlIIllIlllIIlI.write(Type.ITEM, ItemPackets1_11_1.this.handleItemToClient(lllllllllllllIIllIIlIIllIlllIIlI.read(Type.ITEM)));
                                lllllllllllllIIllIIlIIllIlllIIlI.write(Type.ITEM, ItemPackets1_11_1.this.handleItemToClient(lllllllllllllIIllIIlIIllIlllIIlI.read(Type.ITEM)));
                                final boolean lllllllllllllIIllIIlIIllIllllIII = lllllllllllllIIllIIlIIllIlllIIlI.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllIIllIIlIIllIllllIII) {
                                    lllllllllllllIIllIIlIIllIlllIIlI.write(Type.ITEM, ItemPackets1_11_1.this.handleItemToClient(lllllllllllllIIllIIlIIllIlllIIlI.read(Type.ITEM)));
                                }
                                lllllllllllllIIllIIlIIllIlllIIlI.passthrough((Type<Object>)Type.BOOLEAN);
                                lllllllllllllIIllIIlIIllIlllIIlI.passthrough((Type<Object>)Type.INT);
                                lllllllllllllIIllIIlIIllIlllIIlI.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        this.registerClickWindow(ServerboundPackets1_9_3.CLICK_WINDOW, Type.ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_9_3.CREATIVE_INVENTORY_ACTION, Type.ITEM);
        ((Protocol1_11To1_11_1)this.protocol).getEntityRewriter().filter().handler((lllllllllllllIlIlIIlIIIIIIlIIIIl, lllllllllllllIlIlIIlIIIIIIlIIIII) -> {
            if (lllllllllllllIlIlIIlIIIIIIlIIIII.metaType().type().equals(Type.ITEM)) {
                lllllllllllllIlIlIIlIIIIIIlIIIII.setValue(this.handleItemToClient((Item)lllllllllllllIlIlIIlIIIIIIlIIIII.getValue()));
            }
        });
    }
    
    @Override
    public Item handleItemToClient(final Item lllllllllllllIlIlIIlIIIIIIlIllll) {
        if (lllllllllllllIlIlIIlIIIIIIlIllll == null) {
            return null;
        }
        super.handleItemToClient(lllllllllllllIlIlIIlIIIIIIlIllll);
        final CompoundTag lllllllllllllIlIlIIlIIIIIIllIIIl = lllllllllllllIlIlIIlIIIIIIlIllll.tag();
        if (lllllllllllllIlIlIIlIIIIIIllIIIl == null) {
            return lllllllllllllIlIlIIlIIIIIIlIllll;
        }
        if (lllllllllllllIlIlIIlIIIIIIllIIIl.get("ench") instanceof ListTag) {
            this.enchantmentRewriter.rewriteEnchantmentsToClient(lllllllllllllIlIlIIlIIIIIIllIIIl, false);
        }
        if (lllllllllllllIlIlIIlIIIIIIllIIIl.get("StoredEnchantments") instanceof ListTag) {
            this.enchantmentRewriter.rewriteEnchantmentsToClient(lllllllllllllIlIlIIlIIIIIIllIIIl, true);
        }
        return lllllllllllllIlIlIIlIIIIIIlIllll;
    }
    
    public ItemPackets1_11_1(final Protocol1_11To1_11_1 lllllllllllllIlIlIIlIIIIIIllllIl) {
        super(lllllllllllllIlIlIIlIIIIIIllllIl);
    }
    
    @Override
    protected void registerRewrites() {
        this.enchantmentRewriter = new LegacyEnchantmentRewriter(this.nbtTagName);
        this.enchantmentRewriter.registerEnchantment(22, "§7Sweeping Edge");
    }
}
