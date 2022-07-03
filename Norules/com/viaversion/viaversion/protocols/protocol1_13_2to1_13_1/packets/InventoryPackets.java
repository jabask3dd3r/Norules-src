package com.viaversion.viaversion.protocols.protocol1_13_2to1_13_1.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.*;

public class InventoryPackets
{
    public static void register(final Protocol llllllllllllllIIlllIIllIIIlIIIlI) {
        llllllllllllllIIlllIIllIIIlIIIlI.registerClientbound(ClientboundPackets1_13.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.FLAT_ITEM, Type.FLAT_VAR_INT_ITEM);
            }
        });
        llllllllllllllIIlllIIllIIIlIIIlI.registerClientbound(ClientboundPackets1_13.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.FLAT_ITEM_ARRAY, Type.FLAT_VAR_INT_ITEM_ARRAY);
            }
        });
        llllllllllllllIIlllIIllIIIlIIIlI.registerClientbound(ClientboundPackets1_13.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIlllIlIllIIIIlII) throws Exception {
                        final String lllllllllllllllIIlllIlIllIIIIIll = lllllllllllllllIIlllIlIllIIIIlII.get(Type.STRING, 0);
                        if (lllllllllllllllIIlllIlIllIIIIIll.equals("minecraft:trader_list") || lllllllllllllllIIlllIlIllIIIIIll.equals("trader_list")) {
                            lllllllllllllllIIlllIlIllIIIIlII.passthrough((Type<Object>)Type.INT);
                            for (int lllllllllllllllIIlllIlIllIIIIllI = lllllllllllllllIIlllIlIllIIIIlII.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllllIIlllIlIllIIIIlll = 0; lllllllllllllllIIlllIlIllIIIIlll < lllllllllllllllIIlllIlIllIIIIllI; ++lllllllllllllllIIlllIlIllIIIIlll) {
                                lllllllllllllllIIlllIlIllIIIIlII.write(Type.FLAT_VAR_INT_ITEM, (Item)lllllllllllllllIIlllIlIllIIIIlII.read((Type<T>)Type.FLAT_ITEM));
                                lllllllllllllllIIlllIlIllIIIIlII.write(Type.FLAT_VAR_INT_ITEM, (Item)lllllllllllllllIIlllIlIllIIIIlII.read((Type<T>)Type.FLAT_ITEM));
                                final boolean lllllllllllllllIIlllIlIllIIIlIII = lllllllllllllllIIlllIlIllIIIIlII.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllllIIlllIlIllIIIlIII) {
                                    lllllllllllllllIIlllIlIllIIIIlII.write(Type.FLAT_VAR_INT_ITEM, (Item)lllllllllllllllIIlllIlIllIIIIlII.read((Type<T>)Type.FLAT_ITEM));
                                }
                                lllllllllllllllIIlllIlIllIIIIlII.passthrough((Type<Object>)Type.BOOLEAN);
                                lllllllllllllllIIlllIlIllIIIIlII.passthrough((Type<Object>)Type.INT);
                                lllllllllllllllIIlllIlIllIIIIlII.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIIlllIIllIIIlIIIlI.registerClientbound(ClientboundPackets1_13.ENTITY_EQUIPMENT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.VAR_INT);
                this.map(Type.FLAT_ITEM, Type.FLAT_VAR_INT_ITEM);
            }
        });
        llllllllllllllIIlllIIllIIIlIIIlI.registerClientbound(ClientboundPackets1_13.DECLARE_RECIPES, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIllIIlIIIIlIllll) throws Exception {
                        for (int lllllllllllllIlIIllIIlIIIIllIIII = lllllllllllllIlIIllIIlIIIIlIllll.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIlIIllIIlIIIIllIIll = 0; lllllllllllllIlIIllIIlIIIIllIIll < lllllllllllllIlIIllIIlIIIIllIIII; ++lllllllllllllIlIIllIIlIIIIllIIll) {
                            lllllllllllllIlIIllIIlIIIIlIllll.passthrough(Type.STRING);
                            final String lllllllllllllIlIIllIIlIIIIllIlII = lllllllllllllIlIIllIIlIIIIlIllll.passthrough(Type.STRING);
                            if (lllllllllllllIlIIllIIlIIIIllIlII.equals("crafting_shapeless")) {
                                lllllllllllllIlIIllIIlIIIIlIllll.passthrough(Type.STRING);
                                for (int lllllllllllllIlIIllIIlIIIIllIlll = lllllllllllllIlIIllIIlIIIIlIllll.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIlIIllIIlIIIIlllIII = 0; lllllllllllllIlIIllIIlIIIIlllIII < lllllllllllllIlIIllIIlIIIIllIlll; ++lllllllllllllIlIIllIIlIIIIlllIII) {
                                    lllllllllllllIlIIllIIlIIIIlIllll.write(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT, (Item[])(Object)lllllllllllllIlIIllIIlIIIIlIllll.read((Type<T>)Type.FLAT_ITEM_ARRAY_VAR_INT));
                                }
                                lllllllllllllIlIIllIIlIIIIlIllll.write(Type.FLAT_VAR_INT_ITEM, (Item)lllllllllllllIlIIllIIlIIIIlIllll.read((Type<T>)Type.FLAT_ITEM));
                            }
                            else if (lllllllllllllIlIIllIIlIIIIllIlII.equals("crafting_shaped")) {
                                final int lllllllllllllIlIIllIIlIIIIllIlIl = lllllllllllllIlIIllIIlIIIIlIllll.passthrough((Type<Integer>)Type.VAR_INT) * lllllllllllllIlIIllIIlIIIIlIllll.passthrough((Type<Integer>)Type.VAR_INT);
                                lllllllllllllIlIIllIIlIIIIlIllll.passthrough(Type.STRING);
                                for (int lllllllllllllIlIIllIIlIIIIllIllI = 0; lllllllllllllIlIIllIIlIIIIllIllI < lllllllllllllIlIIllIIlIIIIllIlIl; ++lllllllllllllIlIIllIIlIIIIllIllI) {
                                    lllllllllllllIlIIllIIlIIIIlIllll.write(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT, (Item[])(Object)lllllllllllllIlIIllIIlIIIIlIllll.read((Type<T>)Type.FLAT_ITEM_ARRAY_VAR_INT));
                                }
                                lllllllllllllIlIIllIIlIIIIlIllll.write(Type.FLAT_VAR_INT_ITEM, (Item)lllllllllllllIlIIllIIlIIIIlIllll.read((Type<T>)Type.FLAT_ITEM));
                            }
                            else if (lllllllllllllIlIIllIIlIIIIllIlII.equals("smelting")) {
                                lllllllllllllIlIIllIIlIIIIlIllll.passthrough(Type.STRING);
                                lllllllllllllIlIIllIIlIIIIlIllll.write(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT, (Item[])(Object)lllllllllllllIlIIllIIlIIIIlIllll.read((Type<T>)Type.FLAT_ITEM_ARRAY_VAR_INT));
                                lllllllllllllIlIIllIIlIIIIlIllll.write(Type.FLAT_VAR_INT_ITEM, (Item)lllllllllllllIlIIllIIlIIIIlIllll.read((Type<T>)Type.FLAT_ITEM));
                                lllllllllllllIlIIllIIlIIIIlIllll.passthrough((Type<Object>)Type.FLOAT);
                                lllllllllllllIlIIllIIlIIIIlIllll.passthrough((Type<Object>)Type.VAR_INT);
                            }
                        }
                    }
                });
            }
        });
        llllllllllllllIIlllIIllIIIlIIIlI.registerServerbound(ServerboundPackets1_13.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.VAR_INT);
                this.map(Type.FLAT_VAR_INT_ITEM, Type.FLAT_ITEM);
            }
        });
        llllllllllllllIIlllIIllIIIlIIIlI.registerServerbound(ServerboundPackets1_13.CREATIVE_INVENTORY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.map(Type.FLAT_VAR_INT_ITEM, Type.FLAT_ITEM);
            }
        });
    }
}
