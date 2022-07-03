package com.viaversion.viaversion.protocols.protocol1_13_1to1_13.packets;

import com.viaversion.viaversion.protocols.protocol1_13_1to1_13.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets extends ItemRewriter<Protocol1_13_1To1_13>
{
    public InventoryPackets(final Protocol1_13_1To1_13 lllllllllllllIIlIlllIlIlIIIlIIll) {
        super(lllllllllllllIIlIlllIlIlIIIlIIll);
    }
    
    public void registerPackets() {
        this.registerSetSlot(ClientboundPackets1_13.SET_SLOT, Type.FLAT_ITEM);
        this.registerWindowItems(ClientboundPackets1_13.WINDOW_ITEMS, Type.FLAT_ITEM_ARRAY);
        this.registerAdvancements(ClientboundPackets1_13.ADVANCEMENTS, Type.FLAT_ITEM);
        this.registerSetCooldown(ClientboundPackets1_13.COOLDOWN);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIlIIIlIIIIIlIIIIl) throws Exception {
                        final String llllllllllllllIIlIIIlIIIIIlIIIll = llllllllllllllIIlIIIlIIIIIlIIIIl.get(Type.STRING, 0);
                        if (llllllllllllllIIlIIIlIIIIIlIIIll.equals("minecraft:trader_list") || llllllllllllllIIlIIIlIIIIIlIIIll.equals("trader_list")) {
                            llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough((Type<Object>)Type.INT);
                            for (int llllllllllllllIIlIIIlIIIIIlIIllI = llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough((Type<Short>)Type.UNSIGNED_BYTE), llllllllllllllIIlIIIlIIIIIlIIlll = 0; llllllllllllllIIlIIIlIIIIIlIIlll < llllllllllllllIIlIIIlIIIIIlIIllI; ++llllllllllllllIIlIIIlIIIIIlIIlll) {
                                InventoryPackets.this.handleItemToClient(llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough(Type.FLAT_ITEM));
                                InventoryPackets.this.handleItemToClient(llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough(Type.FLAT_ITEM));
                                final boolean llllllllllllllIIlIIIlIIIIIlIlIII = llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (llllllllllllllIIlIIIlIIIIIlIlIII) {
                                    InventoryPackets.this.handleItemToClient(llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough(Type.FLAT_ITEM));
                                }
                                llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough((Type<Object>)Type.BOOLEAN);
                                llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough((Type<Object>)Type.INT);
                                llllllllllllllIIlIIIlIIIIIlIIIIl.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        this.registerEntityEquipment(ClientboundPackets1_13.ENTITY_EQUIPMENT, Type.FLAT_ITEM);
        final RecipeRewriter lllllllllllllIIlIlllIlIlIIIIllll = new RecipeRewriter1_13_2(this.protocol);
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_13.DECLARE_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                final RecipeRewriter val$recipeRewriter;
                int lIIIllllIlllll;
                int lIIIlllllIIIlI;
                String lIIIlllllIIlII;
                String lIIIlllllIIIll;
                this.handler(lIIIlllllIIIII -> {
                    val$recipeRewriter = lllllllllllllIIlIlllIlIlIIIIllll;
                    for (lIIIllllIlllll = lIIIlllllIIIII.passthrough((Type<Integer>)Type.VAR_INT), lIIIlllllIIIlI = 0; lIIIlllllIIIlI < lIIIllllIlllll; ++lIIIlllllIIIlI) {
                        lIIIlllllIIlII = lIIIlllllIIIII.passthrough(Type.STRING);
                        lIIIlllllIIIll = lIIIlllllIIIII.passthrough(Type.STRING).replace("minecraft:", "");
                        val$recipeRewriter.handle(lIIIlllllIIIII, lIIIlllllIIIll);
                    }
                });
            }
        });
        this.registerClickWindow(ServerboundPackets1_13.CLICK_WINDOW, Type.FLAT_ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_13.CREATIVE_INVENTORY_ACTION, Type.FLAT_ITEM);
        this.registerSpawnParticle(ClientboundPackets1_13.SPAWN_PARTICLE, Type.FLAT_ITEM, Type.FLOAT);
    }
}
