package com.viaversion.viabackwards.protocol.protocol1_13to1_13_1.packets;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viabackwards.protocol.protocol1_13to1_13_1.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets1_13_1 extends ItemRewriter<Protocol1_13To1_13_1>
{
    public InventoryPackets1_13_1(final Protocol1_13To1_13_1 lllllllllllllIIIIIlllIlIIllIllII) {
        super(lllllllllllllIIIIIlllIlIIllIllII);
    }
    
    public void registerPackets() {
        this.registerSetCooldown(ClientboundPackets1_13.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_13.WINDOW_ITEMS, Type.FLAT_ITEM_ARRAY);
        this.registerSetSlot(ClientboundPackets1_13.SET_SLOT, Type.FLAT_ITEM);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllllIIIlllIIllllllI) throws Exception {
                        final String lllllllllllllllllIIIlllIlIIIIIII = lllllllllllllllllIIIlllIIllllllI.passthrough(Type.STRING);
                        if (lllllllllllllllllIIIlllIlIIIIIII.equals("minecraft:trader_list")) {
                            lllllllllllllllllIIIlllIIllllllI.passthrough((Type<Object>)Type.INT);
                            for (int lllllllllllllllllIIIlllIlIIIIIll = lllllllllllllllllIIIlllIIllllllI.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllllllIIIlllIlIIIIlII = 0; lllllllllllllllllIIIlllIlIIIIlII < lllllllllllllllllIIIlllIlIIIIIll; ++lllllllllllllllllIIIlllIlIIIIlII) {
                                final Item lllllllllllllllllIIIlllIlIIIIlll = lllllllllllllllllIIIlllIIllllllI.passthrough(Type.FLAT_ITEM);
                                InventoryPackets1_13_1.this.handleItemToClient(lllllllllllllllllIIIlllIlIIIIlll);
                                final Item lllllllllllllllllIIIlllIlIIIIllI = lllllllllllllllllIIIlllIIllllllI.passthrough(Type.FLAT_ITEM);
                                InventoryPackets1_13_1.this.handleItemToClient(lllllllllllllllllIIIlllIlIIIIllI);
                                final boolean lllllllllllllllllIIIlllIlIIIIlIl = lllllllllllllllllIIIlllIIllllllI.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllllllIIIlllIlIIIIlIl) {
                                    final Item lllllllllllllllllIIIlllIlIIIlIII = lllllllllllllllllIIIlllIIllllllI.passthrough(Type.FLAT_ITEM);
                                    InventoryPackets1_13_1.this.handleItemToClient(lllllllllllllllllIIIlllIlIIIlIII);
                                }
                                lllllllllllllllllIIIlllIIllllllI.passthrough((Type<Object>)Type.BOOLEAN);
                                lllllllllllllllllIIIlllIIllllllI.passthrough((Type<Object>)Type.INT);
                                lllllllllllllllllIIIlllIIllllllI.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        this.registerEntityEquipment(ClientboundPackets1_13.ENTITY_EQUIPMENT, Type.FLAT_ITEM);
        this.registerClickWindow(ServerboundPackets1_13.CLICK_WINDOW, Type.FLAT_ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_13.CREATIVE_INVENTORY_ACTION, Type.FLAT_ITEM);
        this.registerSpawnParticle(ClientboundPackets1_13.SPAWN_PARTICLE, Type.FLAT_ITEM, Type.FLOAT);
    }
}
