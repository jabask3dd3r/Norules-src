package de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.packets;

import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.libs.gson.*;
import de.gerrygames.viarewind.utils.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.types.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.items.*;
import java.util.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.storage.*;
import de.gerrygames.viarewind.protocol.protocol1_7_6_10to1_8.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets
{
    public static void register(final Protocol1_7_6_10TO1_8 llllllllllllllllIllIllIIllllllIl) {
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllllIllIllIIllllllIl).registerClientbound(ClientboundPackets1_8.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lllllllllllllIlIIlIIllIIIllIIIII;
                final String lllllllllllllIlIIlIIllIIIlIlllll;
                final short lllllllllllllIlIIlIIllIIIlIllllI;
                final JsonElement lllllllllllllIlIIlIIllIIIlIlllIl;
                final String lllllllllllllIlIIlIIllIIIlIlllII;
                String lllllllllllllIlIIlIIllIIIlIlllII2;
                this.handler(lllllllllllllIlIIlIIllIIIllIIIIl -> {
                    lllllllllllllIlIIlIIllIIIllIIIII = lllllllllllllIlIIlIIllIIIllIIIIl.passthrough((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllIlIIlIIllIIIlIlllll = lllllllllllllIlIIlIIllIIIllIIIIl.read(Type.STRING);
                    lllllllllllllIlIIlIIllIIIlIllllI = (short)Windows.getInventoryType(lllllllllllllIlIIlIIllIIIlIlllll);
                    lllllllllllllIlIIlIIllIIIllIIIIl.user().get(Windows.class).types.put(lllllllllllllIlIIlIIllIIIllIIIII, lllllllllllllIlIIlIIllIIIlIllllI);
                    lllllllllllllIlIIlIIllIIIllIIIIl.write(Type.UNSIGNED_BYTE, lllllllllllllIlIIlIIllIIIlIllllI);
                    lllllllllllllIlIIlIIllIIIlIlllIl = lllllllllllllIlIIlIIllIIIllIIIIl.read(Type.COMPONENT);
                    lllllllllllllIlIIlIIllIIIlIlllII = ChatUtil.jsonToLegacy(lllllllllllllIlIIlIIllIIIlIlllIl);
                    lllllllllllllIlIIlIIllIIIlIlllII2 = ChatUtil.removeUnusedColor(lllllllllllllIlIIlIIllIIIlIlllII, '8');
                    if (lllllllllllllIlIIlIIllIIIlIlllII2.length() > 32) {
                        lllllllllllllIlIIlIIllIIIlIlllII2 = lllllllllllllIlIIlIIllIIIlIlllII2.substring(0, 32);
                    }
                    lllllllllllllIlIIlIIllIIIllIIIIl.write(Type.STRING, lllllllllllllIlIIlIIllIIIlIlllII2);
                    lllllllllllllIlIIlIIllIIIllIIIIl.passthrough((Type<Object>)Type.UNSIGNED_BYTE);
                    lllllllllllllIlIIlIIllIIIllIIIIl.write(Type.BOOLEAN, true);
                    if (lllllllllllllIlIIlIIllIIIlIllllI == 11) {
                        lllllllllllllIlIIlIIllIIIllIIIIl.passthrough((Type<Object>)Type.INT);
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllllIllIllIIllllllIl).registerClientbound(ClientboundPackets1_8.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                final short lllllllllllllIllIlIllIlIlIIlIIll;
                this.handler(lllllllllllllIllIlIllIlIlIIlIlII -> {
                    lllllllllllllIllIlIllIlIlIIlIIll = lllllllllllllIllIlIllIlIlIIlIlII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lllllllllllllIllIlIllIlIlIIlIlII.user().get(Windows.class).remove(lllllllllllllIllIlIllIlIlIIlIIll);
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllllIllIllIIllllllIl).registerClientbound(ClientboundPackets1_8.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lllllllllllllIlIllIIIIllIIIlllII;
                final short lllllllllllllIlIllIIIIllIIIllIll;
                short lllllllllllllIlIllIIIIllIIIllIlI;
                this.handler(lllllllllllllIlIllIIIIllIIIllIIl -> {
                    lllllllllllllIlIllIIIIllIIIlllII = lllllllllllllIlIllIIIIllIIIllIIl.read((Type<Short>)Type.UNSIGNED_BYTE);
                    lllllllllllllIlIllIIIIllIIIllIll = lllllllllllllIlIllIIIIllIIIllIIl.user().get(Windows.class).get(lllllllllllllIlIllIIIIllIIIlllII);
                    lllllllllllllIlIllIIIIllIIIllIIl.write(Type.UNSIGNED_BYTE, lllllllllllllIlIllIIIIllIIIlllII);
                    lllllllllllllIlIllIIIIllIIIllIlI = lllllllllllllIlIllIIIIllIIIllIIl.read((Type<Short>)Type.SHORT);
                    if (lllllllllllllIlIllIIIIllIIIllIll == 4) {
                        if (lllllllllllllIlIllIIIIllIIIllIlI == 1) {
                            lllllllllllllIlIllIIIIllIIIllIIl.cancel();
                            return;
                        }
                        else if (lllllllllllllIlIllIIIIllIIIllIlI >= 2) {
                            --lllllllllllllIlIllIIIIllIIIllIlI;
                        }
                    }
                    lllllllllllllIlIllIIIIllIIIllIIl.write(Type.SHORT, lllllllllllllIlIllIIIIllIIIllIlI);
                    return;
                });
                this.map(Type.ITEM, Types1_7_6_10.COMPRESSED_NBT_ITEM);
                final Item lllllllllllllIlIllIIIIllIIlIIlII;
                this.handler(lllllllllllllIlIllIIIIllIIlIIIll -> {
                    lllllllllllllIlIllIIIIllIIlIIlII = lllllllllllllIlIllIIIIllIIlIIIll.get(Types1_7_6_10.COMPRESSED_NBT_ITEM, 0);
                    ItemRewriter.toClient(lllllllllllllIlIllIIIIllIIlIIlII);
                    lllllllllllllIlIllIIIIllIIlIIIll.set(Types1_7_6_10.COMPRESSED_NBT_ITEM, 0, lllllllllllllIlIllIIIIllIIlIIlII);
                    return;
                });
                final short lllllllllllllIlIllIIIIllIIllIlII;
                short lllllllllllllIlIllIIIIllIIllIIll;
                Item lllllllllllllIlIllIIIIllIIllIIlI;
                EntityTracker lllllllllllllIlIllIIIIllIIllIIIl;
                UUID lllllllllllllIlIllIIIIllIIllIIII;
                Item[] lllllllllllllIlIllIIIIllIIlIllll;
                final EntityTracker entityTracker;
                final UUID lllllllllllllIllllIlIIllIIllIllI;
                final Item[] lllllllllllllIllllIlIIllIIllIlIl;
                this.handler(lllllllllllllIlIllIIIIllIIlIlllI -> {
                    lllllllllllllIlIllIIIIllIIllIlII = lllllllllllllIlIllIIIIllIIlIlllI.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    if (lllllllllllllIlIllIIIIllIIllIlII == 0) {
                        lllllllllllllIlIllIIIIllIIllIIll = lllllllllllllIlIllIIIIllIIlIlllI.get((Type<Short>)Type.SHORT, 0);
                        if (lllllllllllllIlIllIIIIllIIllIIll >= 5 && lllllllllllllIlIllIIIIllIIllIIll <= 8) {
                            lllllllllllllIlIllIIIIllIIllIIlI = lllllllllllllIlIllIIIIllIIlIlllI.get(Types1_7_6_10.COMPRESSED_NBT_ITEM, 0);
                            lllllllllllllIlIllIIIIllIIllIIIl = lllllllllllllIlIllIIIIllIIlIlllI.user().get(EntityTracker.class);
                            lllllllllllllIlIllIIIIllIIllIIII = lllllllllllllIlIllIIIIllIIlIlllI.user().getProtocolInfo().getUuid();
                            lllllllllllllIlIllIIIIllIIlIllll = lllllllllllllIlIllIIIIllIIllIIIl.getPlayerEquipment(lllllllllllllIlIllIIIIllIIllIIII);
                            if (lllllllllllllIlIllIIIIllIIlIllll == null) {
                                lllllllllllllIlIllIIIIllIIlIllll = new Item[5];
                                entityTracker.setPlayerEquipment(lllllllllllllIllllIlIIllIIllIllI, lllllllllllllIllllIlIIllIIllIlIl);
                            }
                            lllllllllllllIlIllIIIIllIIlIllll[9 - lllllllllllllIlIllIIIIllIIllIIll] = lllllllllllllIlIllIIIIllIIllIIlI;
                            if (lllllllllllllIlIllIIIIllIIllIIIl.getGamemode() == 3) {
                                lllllllllllllIlIllIIIIllIIlIlllI.cancel();
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllllIllIllIIllllllIl).registerClientbound(ClientboundPackets1_8.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short llllllllllllllIllIIlIlIIlIIlllll;
                final short llllllllllllllIllIIlIlIIlIIllllI;
                Item[] llllllllllllllIllIIlIlIIlIIlllIl;
                Item[] llllllllllllllIllIIlIlIIlIlIIIlI;
                int llllllllllllllIllIIlIlIIlIlIIIIl;
                this.handler(llllllllllllllIllIIlIlIIlIlIIIII -> {
                    llllllllllllllIllIIlIlIIlIIlllll = llllllllllllllIllIIlIlIIlIlIIIII.read((Type<Short>)Type.UNSIGNED_BYTE);
                    llllllllllllllIllIIlIlIIlIIllllI = llllllllllllllIllIIlIlIIlIlIIIII.user().get(Windows.class).get(llllllllllllllIllIIlIlIIlIIlllll);
                    llllllllllllllIllIIlIlIIlIlIIIII.write(Type.UNSIGNED_BYTE, llllllllllllllIllIIlIlIIlIIlllll);
                    llllllllllllllIllIIlIlIIlIIlllIl = llllllllllllllIllIIlIlIIlIlIIIII.read(Type.ITEM_ARRAY);
                    if (llllllllllllllIllIIlIlIIlIIllllI == 4) {
                        llllllllllllllIllIIlIlIIlIlIIIlI = llllllllllllllIllIIlIlIIlIIlllIl;
                        llllllllllllllIllIIlIlIIlIIlllIl = new Item[llllllllllllllIllIIlIlIIlIlIIIlI.length - 1];
                        llllllllllllllIllIIlIlIIlIIlllIl[0] = llllllllllllllIllIIlIlIIlIlIIIlI[0];
                        System.arraycopy(llllllllllllllIllIIlIlIIlIlIIIlI, 2, llllllllllllllIllIIlIlIIlIIlllIl, 1, llllllllllllllIllIIlIlIIlIlIIIlI.length - 3);
                    }
                    for (llllllllllllllIllIIlIlIIlIlIIIIl = 0; llllllllllllllIllIIlIlIIlIlIIIIl < llllllllllllllIllIIlIlIIlIIlllIl.length; ++llllllllllllllIllIIlIlIIlIlIIIIl) {
                        llllllllllllllIllIIlIlIIlIIlllIl[llllllllllllllIllIIlIlIIlIlIIIIl] = ItemRewriter.toClient(llllllllllllllIllIIlIlIIlIIlllIl[llllllllllllllIllIIlIlIIlIlIIIIl]);
                    }
                    llllllllllllllIllIIlIlIIlIlIIIII.write(Types1_7_6_10.COMPRESSED_NBT_ITEM_ARRAY, llllllllllllllIllIIlIlIIlIIlllIl);
                    return;
                });
                final short llllllllllllllIllIIlIlIIlIllIIll;
                Item[] llllllllllllllIllIIlIlIIlIllIIlI;
                EntityTracker llllllllllllllIllIIlIlIIlIllIIIl;
                UUID llllllllllllllIllIIlIlIIlIllIIII;
                Item[] llllllllllllllIllIIlIlIIlIlIllll;
                final EntityTracker entityTracker;
                final UUID lllllllllllllIllllIlIIllIIllIllI;
                final Item[] lllllllllllllIllllIlIIllIIllIlIl;
                int llllllllllllllIllIIlIlIIlIllIllI;
                GameProfileStorage.GameProfile llllllllllllllIllIIlIlIIlIllIlIl;
                this.handler(llllllllllllllIllIIlIlIIlIlIlllI -> {
                    llllllllllllllIllIIlIlIIlIllIIll = llllllllllllllIllIIlIlIIlIlIlllI.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    if (llllllllllllllIllIIlIlIIlIllIIll == 0) {
                        llllllllllllllIllIIlIlIIlIllIIlI = llllllllllllllIllIIlIlIIlIlIlllI.get(Types1_7_6_10.COMPRESSED_NBT_ITEM_ARRAY, 0);
                        llllllllllllllIllIIlIlIIlIllIIIl = llllllllllllllIllIIlIlIIlIlIlllI.user().get(EntityTracker.class);
                        llllllllllllllIllIIlIlIIlIllIIII = llllllllllllllIllIIlIlIIlIlIlllI.user().getProtocolInfo().getUuid();
                        llllllllllllllIllIIlIlIIlIlIllll = llllllllllllllIllIIlIlIIlIllIIIl.getPlayerEquipment(llllllllllllllIllIIlIlIIlIllIIII);
                        if (llllllllllllllIllIIlIlIIlIlIllll == null) {
                            llllllllllllllIllIIlIlIIlIlIllll = new Item[5];
                            entityTracker.setPlayerEquipment(lllllllllllllIllllIlIIllIIllIllI, lllllllllllllIllllIlIIllIIllIlIl);
                        }
                        for (llllllllllllllIllIIlIlIIlIllIllI = 5; llllllllllllllIllIIlIlIIlIllIllI < 9; ++llllllllllllllIllIIlIlIIlIllIllI) {
                            llllllllllllllIllIIlIlIIlIlIllll[9 - llllllllllllllIllIIlIlIIlIllIllI] = llllllllllllllIllIIlIlIIlIllIIlI[llllllllllllllIllIIlIlIIlIllIllI];
                            if (llllllllllllllIllIIlIlIIlIllIIIl.getGamemode() == 3) {
                                llllllllllllllIllIIlIlIIlIllIIlI[llllllllllllllIllIIlIlIIlIllIllI] = null;
                            }
                        }
                        if (llllllllllllllIllIIlIlIIlIllIIIl.getGamemode() == 3) {
                            llllllllllllllIllIIlIlIIlIllIlIl = llllllllllllllIllIIlIlIIlIlIlllI.user().get(GameProfileStorage.class).get(llllllllllllllIllIIlIlIIlIllIIII);
                            if (llllllllllllllIllIIlIlIIlIllIlIl != null) {
                                llllllllllllllIllIIlIlIIlIllIIlI[5] = llllllllllllllIllIIlIlIIlIllIlIl.getSkull();
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<ClientboundPackets1_8, C2, S1, S2>)llllllllllllllllIllIllIIllllllIl).registerClientbound(ClientboundPackets1_8.WINDOW_PROPERTY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                final short lllllllllllllllIllIIllIIlIlIIIll;
                final Windows lllllllllllllllIllIIllIIlIlIIIlI;
                final short lllllllllllllllIllIIllIIlIlIIIIl;
                final short lllllllllllllllIllIIllIIlIlIIIII;
                final short lllllllllllllllIllIIllIIlIIlllll;
                Windows.Furnace lllllllllllllllIllIIllIIlIlIIlIl;
                short lllllllllllllllIllIIllIIlIIlllll2;
                short lllllllllllllllIllIIllIIlIIlllll3;
                this.handler(lllllllllllllllIllIIllIIlIlIIlII -> {
                    lllllllllllllllIllIIllIIlIlIIIll = lllllllllllllllIllIIllIIlIlIIlII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lllllllllllllllIllIIllIIlIlIIIlI = lllllllllllllllIllIIllIIlIlIIlII.user().get(Windows.class);
                    lllllllllllllllIllIIllIIlIlIIIIl = lllllllllllllllIllIIllIIlIlIIIlI.get(lllllllllllllllIllIIllIIlIlIIIll);
                    lllllllllllllllIllIIllIIlIlIIIII = lllllllllllllllIllIIllIIlIlIIlII.get((Type<Short>)Type.SHORT, 0);
                    lllllllllllllllIllIIllIIlIIlllll = lllllllllllllllIllIIllIIlIlIIlII.get((Type<Short>)Type.SHORT, 1);
                    if (lllllllllllllllIllIIllIIlIlIIIIl != -1) {
                        if (lllllllllllllllIllIIllIIlIlIIIIl == 2) {
                            lllllllllllllllIllIIllIIlIlIIlIl = lllllllllllllllIllIIllIIlIlIIIlI.furnace.computeIfAbsent(lllllllllllllllIllIIllIIlIlIIIll, lllllllllllllllIllIIllIIlIIlIlll -> new Windows.Furnace());
                            if (lllllllllllllllIllIIllIIlIlIIIII == 0 || lllllllllllllllIllIIllIIlIlIIIII == 1) {
                                if (lllllllllllllllIllIIllIIlIlIIIII == 0) {
                                    lllllllllllllllIllIIllIIlIlIIlIl.setFuelLeft(lllllllllllllllIllIIllIIlIIlllll);
                                }
                                else {
                                    lllllllllllllllIllIIllIIlIlIIlIl.setMaxFuel(lllllllllllllllIllIIllIIlIIlllll);
                                }
                                if (lllllllllllllllIllIIllIIlIlIIlIl.getMaxFuel() == 0) {
                                    lllllllllllllllIllIIllIIlIlIIlII.cancel();
                                }
                                else {
                                    lllllllllllllllIllIIllIIlIIlllll2 = (short)(200 * lllllllllllllllIllIIllIIlIlIIlIl.getFuelLeft() / lllllllllllllllIllIIllIIlIlIIlIl.getMaxFuel());
                                    lllllllllllllllIllIIllIIlIlIIlII.set(Type.SHORT, 0, (Short)1);
                                    lllllllllllllllIllIIllIIlIlIIlII.set(Type.SHORT, 1, lllllllllllllllIllIIllIIlIIlllll2);
                                }
                            }
                            else if (lllllllllllllllIllIIllIIlIlIIIII == 2 || lllllllllllllllIllIIllIIlIlIIIII == 3) {
                                if (lllllllllllllllIllIIllIIlIlIIIII == 2) {
                                    lllllllllllllllIllIIllIIlIlIIlIl.setProgress(lllllllllllllllIllIIllIIlIIlllll);
                                }
                                else {
                                    lllllllllllllllIllIIllIIlIlIIlIl.setMaxProgress(lllllllllllllllIllIIllIIlIIlllll);
                                }
                                if (lllllllllllllllIllIIllIIlIlIIlIl.getMaxProgress() == 0) {
                                    lllllllllllllllIllIIllIIlIlIIlII.cancel();
                                }
                                else {
                                    lllllllllllllllIllIIllIIlIIlllll3 = (short)(200 * lllllllllllllllIllIIllIIlIlIIlIl.getProgress() / lllllllllllllllIllIIllIIlIlIIlIl.getMaxProgress());
                                    lllllllllllllllIllIIllIIlIlIIlII.set(Type.SHORT, 0, (Short)0);
                                    lllllllllllllllIllIIllIIlIlIIlII.set(Type.SHORT, 1, lllllllllllllllIllIIllIIlIIlllll3);
                                }
                            }
                        }
                        else if (lllllllllllllllIllIIllIIlIlIIIIl == 4) {
                            if (lllllllllllllllIllIIllIIlIlIIIII > 2) {
                                lllllllllllllllIllIIllIIlIlIIlII.cancel();
                            }
                        }
                        else if (lllllllllllllllIllIIllIIlIlIIIIl == 8) {
                            lllllllllllllllIllIIllIIlIlIIIlI.levelCost = lllllllllllllllIllIIllIIlIIlllll;
                            lllllllllllllllIllIIllIIlIlIIIlI.anvilId = lllllllllllllllIllIIllIIlIlIIIll;
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)llllllllllllllllIllIllIIllllllIl).registerServerbound(ServerboundPackets1_7.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                final short lllllllllllllIIIIlIlllIIlIIlIIII;
                this.handler(lllllllllllllIIIIlIlllIIlIIlIIIl -> {
                    lllllllllllllIIIIlIlllIIlIIlIIII = lllllllllllllIIIIlIlllIIlIIlIIIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                    lllllllllllllIIIIlIlllIIlIIlIIIl.user().get(Windows.class).remove(lllllllllllllIIIIlIlllIIlIIlIIII);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)llllllllllllllllIllIllIIllllllIl).registerServerbound(ServerboundPackets1_7.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lIIIllIllIIIll;
                final short lIIIllIllIIIlI;
                short lIIIllIllIIIIl;
                this.handler(lIIIllIllIIIII -> {
                    lIIIllIllIIIll = lIIIllIllIIIII.read((Type<Byte>)Type.BYTE);
                    lIIIllIllIIIII.write(Type.UNSIGNED_BYTE, lIIIllIllIIIll);
                    lIIIllIllIIIlI = lIIIllIllIIIII.user().get(Windows.class).get(lIIIllIllIIIll);
                    lIIIllIllIIIIl = lIIIllIllIIIII.read((Type<Short>)Type.SHORT);
                    if (lIIIllIllIIIlI == 4 && lIIIllIllIIIIl > 0) {
                        ++lIIIllIllIIIIl;
                    }
                    lIIIllIllIIIII.write(Type.SHORT, lIIIllIllIIIIl);
                    return;
                });
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Types1_7_6_10.COMPRESSED_NBT_ITEM, Type.ITEM);
                final Item lIIIllIllIlIll;
                this.handler(lIIIllIllIlIlI -> {
                    lIIIllIllIlIll = lIIIllIllIlIlI.get(Type.ITEM, 0);
                    ItemRewriter.toServer(lIIIllIllIlIll);
                    lIIIllIllIlIlI.set(Type.ITEM, 0, lIIIllIllIlIll);
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)llllllllllllllllIllIllIIllllllIl).registerServerbound(ServerboundPackets1_7.WINDOW_CONFIRMATION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.BOOLEAN);
                final int llllllllllllllIIlllIllIIllIIIIll;
                this.handler(llllllllllllllIIlllIllIIllIIIlII -> {
                    llllllllllllllIIlllIllIIllIIIIll = llllllllllllllIIlllIllIIllIIIlII.get((Type<Short>)Type.SHORT, 0);
                    if (llllllllllllllIIlllIllIIllIIIIll == -89) {
                        llllllllllllllIIlllIllIIllIIIlII.cancel();
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_7>)llllllllllllllllIllIllIIllllllIl).registerServerbound(ServerboundPackets1_7.CREATIVE_INVENTORY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.map(Types1_7_6_10.COMPRESSED_NBT_ITEM, Type.ITEM);
                final Item llllllllllllllIllIllllIIlIIlIIll;
                this.handler(llllllllllllllIllIllllIIlIIlIIlI -> {
                    llllllllllllllIllIllllIIlIIlIIll = llllllllllllllIllIllllIIlIIlIIlI.get(Type.ITEM, 0);
                    ItemRewriter.toServer(llllllllllllllIllIllllIIlIIlIIll);
                    llllllllllllllIllIllllIIlIIlIIlI.set(Type.ITEM, 0, llllllllllllllIllIllllIIlIIlIIll);
                });
            }
        });
    }
}
