package de.gerrygames.viarewind.protocol.protocol1_8to1_9.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.storage.*;
import com.viaversion.viaversion.libs.gson.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_8to1_9.items.*;
import com.viaversion.viaversion.api.type.types.*;

public class InventoryPackets
{
    public static void register(final Protocol<ClientboundPackets1_9, ClientboundPackets1_8, ServerboundPackets1_9, ServerboundPackets1_8> llllllllllllIllllIllllIllllIIIll) {
        llllllllllllIllllIllllIllllIIIll.registerClientbound(ClientboundPackets1_9.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                final short lllllllllllllllIIllIllllllIIIIll;
                this.handler(lllllllllllllllIIllIllllllIIIlII -> {
                    lllllllllllllllIIllIllllllIIIIll = lllllllllllllllIIllIllllllIIIlII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lllllllllllllllIIllIllllllIIIlII.user().get(Windows.class).remove(lllllllllllllllIIllIllllllIIIIll);
                });
            }
        });
        llllllllllllIllllIllllIllllIIIll.registerClientbound(ClientboundPackets1_9.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.map(Type.COMPONENT);
                this.map(Type.UNSIGNED_BYTE);
                final String lllllllllllllllIIIIlIlIIllIIllll;
                this.handler(lllllllllllllllIIIIlIlIIllIlIIII -> {
                    lllllllllllllllIIIIlIlIIllIIllll = lllllllllllllllIIIIlIlIIllIlIIII.get(Type.STRING, 0);
                    if (lllllllllllllllIIIIlIlIIllIIllll.equals("EntityHorse")) {
                        lllllllllllllllIIIIlIlIIllIlIIII.passthrough((Type<Object>)Type.INT);
                    }
                    return;
                });
                final short lllllllllllllllIIIIlIlIIllIlIlll;
                final String lllllllllllllllIIIIlIlIIllIlIllI;
                this.handler(lllllllllllllllIIIIlIlIIllIllIII -> {
                    lllllllllllllllIIIIlIlIIllIlIlll = lllllllllllllllIIIIlIlIIllIllIII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lllllllllllllllIIIIlIlIIllIlIllI = lllllllllllllllIIIIlIlIIllIllIII.get(Type.STRING, 0);
                    lllllllllllllllIIIIlIlIIllIllIII.user().get(Windows.class).put(lllllllllllllllIIIIlIlIIllIlIlll, lllllllllllllllIIIIlIlIIllIlIllI);
                    return;
                });
                final String lllllllllllllllIIIIlIlIIlllIIIII;
                Type<String> string;
                String lllllllllllllllIIIIlIlIIlllIIIII2;
                final int n;
                final T t;
                final String lllllllllllllllIIIIlIlIIllIlllll;
                this.handler(lllllllllllllllIIIIlIlIIlllIIIIl -> {
                    lllllllllllllllIIIIlIlIIlllIIIII = lllllllllllllllIIIIlIlIIlllIIIIl.get(Type.STRING, 0);
                    if (lllllllllllllllIIIIlIlIIlllIIIII.equalsIgnoreCase("minecraft:shulker_box")) {
                        string = Type.STRING;
                        lllllllllllllllIIIIlIlIIlllIIIII2 = "minecraft:container";
                        lllllllllllllllIIIIlIlIIlllIIIIl.set(string, n, (String)t);
                    }
                    lllllllllllllllIIIIlIlIIllIlllll = lllllllllllllllIIIIlIlIIlllIIIIl.get(Type.COMPONENT, 0).toString();
                    if (lllllllllllllllIIIIlIlIIllIlllll.equalsIgnoreCase("{\"translate\":\"container.shulkerBox\"}")) {
                        lllllllllllllllIIIIlIlIIlllIIIIl.set(Type.COMPONENT, 0, JsonParser.parseString("{\"text\":\"Shulker Box\"}"));
                    }
                });
            }
        });
        llllllllllllIllllIllllIllllIIIll.registerClientbound(ClientboundPackets1_9.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                final short lllllllllllllIlIlIIlIllllIllIIll;
                Item[] lllllllllllllIlIlIIlIllllIllIIlI;
                int lllllllllllllIlIlIIlIllllIlllIII;
                Item[] lllllllllllllIlIlIIlIllllIllIlll;
                String lllllllllllllIlIlIIlIllllIllIlIl;
                Item[] lllllllllllllIlIlIIlIllllIllIllI;
                this.handler(lllllllllllllIlIlIIlIllllIllIIIl -> {
                    lllllllllllllIlIlIIlIllllIllIIll = lllllllllllllIlIlIIlIllllIllIIIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    for (lllllllllllllIlIlIIlIllllIllIIlI = lllllllllllllIlIlIIlIllllIllIIIl.read(Type.ITEM_ARRAY), lllllllllllllIlIlIIlIllllIlllIII = 0; lllllllllllllIlIlIIlIllllIlllIII < lllllllllllllIlIlIIlIllllIllIIlI.length; ++lllllllllllllIlIlIIlIllllIlllIII) {
                        lllllllllllllIlIlIIlIllllIllIIlI[lllllllllllllIlIlIIlIllllIlllIII] = ItemRewriter.toClient(lllllllllllllIlIlIIlIllllIllIIlI[lllllllllllllIlIlIIlIllllIlllIII]);
                    }
                    if (lllllllllllllIlIlIIlIllllIllIIll == 0 && lllllllllllllIlIlIIlIllllIllIIlI.length == 46) {
                        lllllllllllllIlIlIIlIllllIllIlll = lllllllllllllIlIlIIlIllllIllIIlI;
                        lllllllllllllIlIlIIlIllllIllIIlI = new Item[45];
                        System.arraycopy(lllllllllllllIlIlIIlIllllIllIlll, 0, lllllllllllllIlIlIIlIllllIllIIlI, 0, 45);
                    }
                    else {
                        lllllllllllllIlIlIIlIllllIllIlIl = lllllllllllllIlIlIIlIllllIllIIIl.user().get(Windows.class).get(lllllllllllllIlIlIIlIllllIllIIll);
                        if (lllllllllllllIlIlIIlIllllIllIlIl != null && lllllllllllllIlIlIIlIllllIllIlIl.equalsIgnoreCase("minecraft:brewing_stand")) {
                            System.arraycopy(lllllllllllllIlIlIIlIllllIllIIlI, 0, lllllllllllllIlIlIIlIllllIllIIIl.user().get(Windows.class).getBrewingItems(lllllllllllllIlIlIIlIllllIllIIll), 0, 4);
                            Windows.updateBrewingStand(lllllllllllllIlIlIIlIllllIllIIIl.user(), lllllllllllllIlIlIIlIllllIllIIlI[4], lllllllllllllIlIlIIlIllllIllIIll);
                            lllllllllllllIlIlIIlIllllIllIllI = lllllllllllllIlIlIIlIllllIllIIlI;
                            lllllllllllllIlIlIIlIllllIllIIlI = new Item[lllllllllllllIlIlIIlIllllIllIllI.length - 1];
                            System.arraycopy(lllllllllllllIlIlIIlIllllIllIllI, 0, lllllllllllllIlIlIIlIllllIllIIlI, 0, 4);
                            System.arraycopy(lllllllllllllIlIlIIlIllllIllIllI, 5, lllllllllllllIlIlIIlIllllIllIIlI, 4, lllllllllllllIlIlIIlIllllIllIllI.length - 5);
                        }
                    }
                    lllllllllllllIlIlIIlIllllIllIIIl.write(Type.ITEM_ARRAY, lllllllllllllIlIlIIlIllllIllIIlI);
                });
            }
        });
        llllllllllllIllllIllllIllllIIIll.registerClientbound(ClientboundPackets1_9.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.ITEM);
                final byte lllllllllllllIIIIIlIIllIlIIIIlII;
                final short lllllllllllllIIIIIlIIllIlIIIIIll;
                String lllllllllllllIIIIIlIIllIlIIIIIlI;
                ShortType short1;
                short lllllllllllllIIIIIlIIllIlIIIIIll2;
                final int n;
                this.handler(lllllllllllllIIIIIlIIllIlIIIIlIl -> {
                    lllllllllllllIIIIIlIIllIlIIIIlIl.set(Type.ITEM, 0, ItemRewriter.toClient(lllllllllllllIIIIIlIIllIlIIIIlIl.get(Type.ITEM, 0)));
                    lllllllllllllIIIIIlIIllIlIIIIlII = lllllllllllllIIIIIlIIllIlIIIIlIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0).byteValue();
                    lllllllllllllIIIIIlIIllIlIIIIIll = lllllllllllllIIIIIlIIllIlIIIIlIl.get((Type<Short>)Type.SHORT, 0);
                    if (lllllllllllllIIIIIlIIllIlIIIIlII == 0 && lllllllllllllIIIIIlIIllIlIIIIIll == 45) {
                        lllllllllllllIIIIIlIIllIlIIIIlIl.cancel();
                    }
                    else {
                        lllllllllllllIIIIIlIIllIlIIIIIlI = lllllllllllllIIIIIlIIllIlIIIIlIl.user().get(Windows.class).get(lllllllllllllIIIIIlIIllIlIIIIlII);
                        if (lllllllllllllIIIIIlIIllIlIIIIIlI != null) {
                            if (lllllllllllllIIIIIlIIllIlIIIIIlI.equalsIgnoreCase("minecraft:brewing_stand")) {
                                if (lllllllllllllIIIIIlIIllIlIIIIIll > 4) {
                                    short1 = Type.SHORT;
                                    lllllllllllllIIIIIlIIllIlIIIIIll2 = (short)(lllllllllllllIIIIIlIIllIlIIIIIll - 1);
                                    lllllllllllllIIIIIlIIllIlIIIIlIl.set(short1, n, lllllllllllllIIIIIlIIllIlIIIIIll2);
                                }
                                else if (lllllllllllllIIIIIlIIllIlIIIIIll == 4) {
                                    lllllllllllllIIIIIlIIllIlIIIIlIl.cancel();
                                    Windows.updateBrewingStand(lllllllllllllIIIIIlIIllIlIIIIlIl.user(), lllllllllllllIIIIIlIIllIlIIIIlIl.get(Type.ITEM, 0), lllllllllllllIIIIIlIIllIlIIIIlII);
                                }
                                else {
                                    lllllllllllllIIIIIlIIllIlIIIIlIl.user().get(Windows.class).getBrewingItems(lllllllllllllIIIIIlIIllIlIIIIlII)[lllllllllllllIIIIIlIIllIlIIIIIll] = lllllllllllllIIIIIlIIllIlIIIIlIl.get(Type.ITEM, 0);
                                }
                            }
                        }
                    }
                });
            }
        });
        llllllllllllIllllIllllIllllIIIll.registerServerbound(ServerboundPackets1_8.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                final short lllllllllllllIlIIIIlIlllIlIlllll;
                this.handler(lllllllllllllIlIIIIlIlllIlIllllI -> {
                    lllllllllllllIlIIIIlIlllIlIlllll = lllllllllllllIlIIIIlIlllIlIllllI.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lllllllllllllIlIIIIlIlllIlIllllI.user().get(Windows.class).remove(lllllllllllllIlIIIIlIlllIlIlllll);
                });
            }
        });
        llllllllllllIllllIllllIllllIIIll.registerServerbound(ServerboundPackets1_8.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE, Type.VAR_INT);
                this.map(Type.ITEM);
                this.handler(llllllllllllllIIllIIlIlIllIIlIlI -> llllllllllllllIIllIIlIlIllIIlIlI.set(Type.ITEM, 0, ItemRewriter.toServer(llllllllllllllIIllIIlIlIllIIlIlI.get(Type.ITEM, 0))));
                final short llllllllllllllIIllIIlIlIllIlIIll;
                final Windows llllllllllllllIIllIIlIlIllIlIIlI;
                final String llllllllllllllIIllIIlIlIllIlIIIl;
                short llllllllllllllIIllIIlIlIllIlIlIl;
                ShortType short1;
                short llllllllllllllIIllIIlIlIllIlIlIl2;
                final int n;
                this.handler(llllllllllllllIIllIIlIlIllIlIlII -> {
                    llllllllllllllIIllIIlIlIllIlIIll = llllllllllllllIIllIIlIlIllIlIlII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    llllllllllllllIIllIIlIlIllIlIIlI = llllllllllllllIIllIIlIlIllIlIlII.user().get(Windows.class);
                    llllllllllllllIIllIIlIlIllIlIIIl = llllllllllllllIIllIIlIlIllIlIIlI.get(llllllllllllllIIllIIlIlIllIlIIll);
                    if (llllllllllllllIIllIIlIlIllIlIIIl != null) {
                        if (llllllllllllllIIllIIlIlIllIlIIIl.equalsIgnoreCase("minecraft:brewing_stand")) {
                            llllllllllllllIIllIIlIlIllIlIlIl = llllllllllllllIIllIIlIlIllIlIlII.get((Type<Short>)Type.SHORT, 0);
                            if (llllllllllllllIIllIIlIlIllIlIlIl > 3) {
                                short1 = Type.SHORT;
                                llllllllllllllIIllIIlIlIllIlIlIl2 = (short)(llllllllllllllIIllIIlIlIllIlIlIl + 1);
                                llllllllllllllIIllIIlIlIllIlIlII.set(short1, n, llllllllllllllIIllIIlIlIllIlIlIl2);
                            }
                        }
                    }
                });
            }
        });
        llllllllllllIllllIllllIllllIIIll.registerServerbound(ServerboundPackets1_8.CREATIVE_INVENTORY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.map(Type.ITEM);
                this.handler(lllllllllllllllIIIlIIIlIIIIllllI -> lllllllllllllllIIIlIIIlIIIIllllI.set(Type.ITEM, 0, ItemRewriter.toServer(lllllllllllllllIIIlIIIlIIIIllllI.get(Type.ITEM, 0))));
            }
        });
    }
}
