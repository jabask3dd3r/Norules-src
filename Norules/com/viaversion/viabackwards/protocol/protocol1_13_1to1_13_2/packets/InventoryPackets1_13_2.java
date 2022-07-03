package com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2.packets;

import com.viaversion.viabackwards.protocol.protocol1_13_1to1_13_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets1_13_2
{
    public static void register(final Protocol1_13_1To1_13_2 llllllllllllllIIIlIllllIllIIIllI) {
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllllIIIlIllllIllIIIllI).registerClientbound(ClientboundPackets1_13.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.FLAT_VAR_INT_ITEM, Type.FLAT_ITEM);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllllIIIlIllllIllIIIllI).registerClientbound(ClientboundPackets1_13.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.FLAT_VAR_INT_ITEM_ARRAY, Type.FLAT_ITEM_ARRAY);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllllIIIlIllllIllIIIllI).registerClientbound(ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllllIlllIIlIIllIl) throws Exception {
                        final String llllllllllllllIllllIlllIIlIIlllI = llllllllllllllIllllIlllIIlIIllIl.get(Type.STRING, 0);
                        if (llllllllllllllIllllIlllIIlIIlllI.equals("minecraft:trader_list") || llllllllllllllIllllIlllIIlIIlllI.equals("trader_list")) {
                            llllllllllllllIllllIlllIIlIIllIl.passthrough((Type<Object>)Type.INT);
                            for (int llllllllllllllIllllIlllIIlIlIIIl = llllllllllllllIllllIlllIIlIIllIl.passthrough((Type<Short>)Type.UNSIGNED_BYTE), llllllllllllllIllllIlllIIlIlIIlI = 0; llllllllllllllIllllIlllIIlIlIIlI < llllllllllllllIllllIlllIIlIlIIIl; ++llllllllllllllIllllIlllIIlIlIIlI) {
                                llllllllllllllIllllIlllIIlIIllIl.write(Type.FLAT_ITEM, (Item)llllllllllllllIllllIlllIIlIIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM));
                                llllllllllllllIllllIlllIIlIIllIl.write(Type.FLAT_ITEM, (Item)llllllllllllllIllllIlllIIlIIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM));
                                final boolean llllllllllllllIllllIlllIIlIlIIll = llllllllllllllIllllIlllIIlIIllIl.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (llllllllllllllIllllIlllIIlIlIIll) {
                                    llllllllllllllIllllIlllIIlIIllIl.write(Type.FLAT_ITEM, (Item)llllllllllllllIllllIlllIIlIIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM));
                                }
                                llllllllllllllIllllIlllIIlIIllIl.passthrough((Type<Object>)Type.BOOLEAN);
                                llllllllllllllIllllIlllIIlIIllIl.passthrough((Type<Object>)Type.INT);
                                llllllllllllllIllllIlllIIlIIllIl.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllllIIIlIllllIllIIIllI).registerClientbound(ClientboundPackets1_13.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.FLAT_VAR_INT_ITEM, Type.FLAT_ITEM);
            }
        });
        ((AbstractProtocol<ClientboundPackets1_13, C2, S1, S2>)llllllllllllllIIIlIllllIllIIIllI).registerClientbound(ClientboundPackets1_13.DECLARE_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIllIIlllIIllllIllIl) throws Exception {
                        for (int lllllllllllllIllIIlllIIllllIllII = lllllllllllllIllIIlllIIllllIllIl.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIllIIlllIIllllIllll = 0; lllllllllllllIllIIlllIIllllIllll < lllllllllllllIllIIlllIIllllIllII; ++lllllllllllllIllIIlllIIllllIllll) {
                            lllllllllllllIllIIlllIIllllIllIl.passthrough(Type.STRING);
                            final String lllllllllllllIllIIlllIIlllllIIII = lllllllllllllIllIIlllIIllllIllIl.passthrough(Type.STRING);
                            if (lllllllllllllIllIIlllIIlllllIIII.equals("crafting_shapeless")) {
                                lllllllllllllIllIIlllIIllllIllIl.passthrough(Type.STRING);
                                for (int lllllllllllllIllIIlllIIlllllIIll = lllllllllllllIllIIlllIIllllIllIl.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIllIIlllIIlllllIlII = 0; lllllllllllllIllIIlllIIlllllIlII < lllllllllllllIllIIlllIIlllllIIll; ++lllllllllllllIllIIlllIIlllllIlII) {
                                    lllllllllllllIllIIlllIIllllIllIl.write(Type.FLAT_ITEM_ARRAY_VAR_INT, (Item[])(Object)lllllllllllllIllIIlllIIllllIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
                                }
                                lllllllllllllIllIIlllIIllllIllIl.write(Type.FLAT_ITEM, (Item)lllllllllllllIllIIlllIIllllIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM));
                            }
                            else if (lllllllllllllIllIIlllIIlllllIIII.equals("crafting_shaped")) {
                                final int lllllllllllllIllIIlllIIlllllIIIl = lllllllllllllIllIIlllIIllllIllIl.passthrough((Type<Integer>)Type.VAR_INT) * lllllllllllllIllIIlllIIllllIllIl.passthrough((Type<Integer>)Type.VAR_INT);
                                lllllllllllllIllIIlllIIllllIllIl.passthrough(Type.STRING);
                                for (int lllllllllllllIllIIlllIIlllllIIlI = 0; lllllllllllllIllIIlllIIlllllIIlI < lllllllllllllIllIIlllIIlllllIIIl; ++lllllllllllllIllIIlllIIlllllIIlI) {
                                    lllllllllllllIllIIlllIIllllIllIl.write(Type.FLAT_ITEM_ARRAY_VAR_INT, (Item[])(Object)lllllllllllllIllIIlllIIllllIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
                                }
                                lllllllllllllIllIIlllIIllllIllIl.write(Type.FLAT_ITEM, (Item)lllllllllllllIllIIlllIIllllIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM));
                            }
                            else if (lllllllllllllIllIIlllIIlllllIIII.equals("smelting")) {
                                lllllllllllllIllIIlllIIllllIllIl.passthrough(Type.STRING);
                                lllllllllllllIllIIlllIIllllIllIl.write(Type.FLAT_ITEM_ARRAY_VAR_INT, (Item[])(Object)lllllllllllllIllIIlllIIllllIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
                                lllllllllllllIllIIlllIIllllIllIl.write(Type.FLAT_ITEM, (Item)lllllllllllllIllIIlllIIllllIllIl.read((Type<T>)Type.FLAT_VAR_INT_ITEM));
                                lllllllllllllIllIIlllIIllllIllIl.passthrough((Type<Object>)Type.FLOAT);
                                lllllllllllllIllIIlllIIllllIllIl.passthrough((Type<Object>)Type.VAR_INT);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)llllllllllllllIIIlIllllIllIIIllI).registerServerbound(ServerboundPackets1_13.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.VAR_INT);
                this.map(Type.FLAT_ITEM, Type.FLAT_VAR_INT_ITEM);
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_13>)llllllllllllllIIIlIllllIllIIIllI).registerServerbound(ServerboundPackets1_13.CREATIVE_INVENTORY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.map(Type.FLAT_ITEM, Type.FLAT_VAR_INT_ITEM);
            }
        });
    }
}
