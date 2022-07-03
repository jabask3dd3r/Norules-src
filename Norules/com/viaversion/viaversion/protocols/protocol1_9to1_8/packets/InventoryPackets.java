package com.viaversion.viaversion.protocols.protocol1_9to1_8.packets;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.protocols.protocol1_8.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.storage.*;
import com.viaversion.viaversion.protocols.protocol1_9to1_8.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public class InventoryPackets
{
    public static void register(final Protocol lllllllllllllllIIIIllIIIllIIllll) {
        lllllllllllllllIIIIllIIIllIIllll.registerClientbound(ClientboundPackets1_8.WINDOW_PROPERTY, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.SHORT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlIlllllllIlllIlll) throws Exception {
                        final short llllllllllllllIlIlllllllIlllllII = llllllllllllllIlIlllllllIlllIlll.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        final short llllllllllllllIlIlllllllIllllIll = llllllllllllllIlIlllllllIlllIlll.get((Type<Short>)Type.SHORT, 0);
                        final short llllllllllllllIlIlllllllIllllIlI = llllllllllllllIlIlllllllIlllIlll.get((Type<Short>)Type.SHORT, 1);
                        final InventoryTracker llllllllllllllIlIlllllllIllllIIl = llllllllllllllIlIlllllllIlllIlll.user().get(InventoryTracker.class);
                        if (llllllllllllllIlIlllllllIllllIIl.getInventory() != null && llllllllllllllIlIlllllllIllllIIl.getInventory().equalsIgnoreCase("minecraft:enchanting_table") && llllllllllllllIlIlllllllIllllIll > 3 && llllllllllllllIlIlllllllIllllIll < 7) {
                            final short llllllllllllllIlIllllllllIIIIIII = (short)(llllllllllllllIlIlllllllIllllIlI >> 8);
                            final short llllllllllllllIlIlllllllIlllllll = (short)(llllllllllllllIlIlllllllIllllIlI & 0xFF);
                            llllllllllllllIlIlllllllIlllIlll.create(llllllllllllllIlIlllllllIlllIlll.getId(), new PacketHandler() {
                                @Override
                                public void handle(final PacketWrapper lllllllllllllIIIIlIIIIIIlIlIlIll) throws Exception {
                                    lllllllllllllIIIIlIIIIIIlIlIlIll.write(Type.UNSIGNED_BYTE, llllllllllllllIlIlllllllIlllllII);
                                    lllllllllllllIIIIlIIIIIIlIlIlIll.write(Type.SHORT, llllllllllllllIlIlllllllIllllIll);
                                    lllllllllllllIIIIlIIIIIIlIlIlIll.write(Type.SHORT, llllllllllllllIlIlllllllIlllllll);
                                }
                            }).scheduleSend(Protocol1_9To1_8.class);
                            llllllllllllllIlIlllllllIlllIlll.set(Type.SHORT, 0, (short)(llllllllllllllIlIlllllllIllllIll + 3));
                            llllllllllllllIlIlllllllIlllIlll.set(Type.SHORT, 1, llllllllllllllIlIllllllllIIIIIII);
                        }
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerClientbound(ClientboundPackets1_8.OPEN_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.STRING);
                this.map(Type.STRING, Protocol1_9To1_8.FIX_JSON);
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIllllIIlIllllIlIll) throws Exception {
                        final String llllllllllllllIllllIIlIllllIllIl = llllllllllllllIllllIIlIllllIlIll.get(Type.STRING, 0);
                        final InventoryTracker llllllllllllllIllllIIlIllllIllII = llllllllllllllIllllIIlIllllIlIll.user().get(InventoryTracker.class);
                        llllllllllllllIllllIIlIllllIllII.setInventory(llllllllllllllIllllIIlIllllIllIl);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIIlllIIIIIIIIIlIl) throws Exception {
                        final String lllllllllllllllIIlllIIIIIIIIIllI = lllllllllllllllIIlllIIIIIIIIIlIl.get(Type.STRING, 0);
                        if (lllllllllllllllIIlllIIIIIIIIIllI.equals("minecraft:brewing_stand")) {
                            lllllllllllllllIIlllIIIIIIIIIlIl.set(Type.UNSIGNED_BYTE, 1, (short)(lllllllllllllllIIlllIIIIIIIIIlIl.get((Type<Short>)Type.UNSIGNED_BYTE, 1) + 1));
                        }
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerClientbound(ClientboundPackets1_8.SET_SLOT, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.ITEM);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIlIIllllIllIIll) throws Exception {
                        final Item llllllllllllllIIIIlIIllllIllIIlI = llllllllllllllIIIIlIIllllIllIIll.get(Type.ITEM, 0);
                        final boolean llllllllllllllIIIIlIIllllIllIIIl = Via.getConfig().isShowShieldWhenSwordInHand() && Via.getConfig().isShieldBlocking();
                        if (llllllllllllllIIIIlIIllllIllIIIl) {
                            final InventoryTracker llllllllllllllIIIIlIIllllIlllIII = llllllllllllllIIIIlIIllllIllIIll.user().get(InventoryTracker.class);
                            final EntityTracker1_9 llllllllllllllIIIIlIIllllIllIlll = llllllllllllllIIIIlIIllllIllIIll.user().getEntityTracker(Protocol1_9To1_8.class);
                            final short llllllllllllllIIIIlIIllllIllIllI = llllllllllllllIIIIlIIllllIllIIll.get((Type<Short>)Type.SHORT, 0);
                            final byte llllllllllllllIIIIlIIllllIllIlIl = llllllllllllllIIIIlIIllllIllIIll.get((Type<Short>)Type.UNSIGNED_BYTE, 0).byteValue();
                            llllllllllllllIIIIlIIllllIlllIII.setItemId(llllllllllllllIIIIlIIllllIllIlIl, llllllllllllllIIIIlIIllllIllIllI, (llllllllllllllIIIIlIIllllIllIIlI == null) ? 0 : llllllllllllllIIIIlIIllllIllIIlI.identifier());
                            llllllllllllllIIIIlIIllllIllIlll.syncShieldWithSword();
                        }
                        ItemRewriter.toClient(llllllllllllllIIIIlIIllllIllIIlI);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIlllIllIlIllllllIl) throws Exception {
                        final InventoryTracker llllllllllllllIlllIllIlIllllllll = llllllllllllllIlllIllIlIllllllIl.user().get(InventoryTracker.class);
                        final short llllllllllllllIlllIllIlIlllllllI = llllllllllllllIlllIllIlIllllllIl.get((Type<Short>)Type.SHORT, 0);
                        if (llllllllllllllIlllIllIlIllllllll.getInventory() != null && llllllllllllllIlllIllIlIllllllll.getInventory().equals("minecraft:brewing_stand") && llllllllllllllIlllIllIlIlllllllI >= 4) {
                            llllllllllllllIlllIllIlIllllllIl.set(Type.SHORT, 0, (short)(llllllllllllllIlllIllIlIlllllllI + 1));
                        }
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerClientbound(ClientboundPackets1_8.WINDOW_ITEMS, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.ITEM_ARRAY);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIlIIIlIIIIlIllIIl) throws Exception {
                        final Item[] llllllllllllllIIlIIIlIIIIlIllIII = llllllllllllllIIlIIIlIIIIlIllIIl.get(Type.ITEM_ARRAY, 0);
                        final Short llllllllllllllIIlIIIlIIIIlIlIllI = llllllllllllllIIlIIIlIIIIlIllIIl.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        final InventoryTracker llllllllllllllIIlIIIlIIIIlIlIlII = llllllllllllllIIlIIIlIIIIlIllIIl.user().get(InventoryTracker.class);
                        final EntityTracker1_9 llllllllllllllIIlIIIlIIIIlIlIIlI = llllllllllllllIIlIIIlIIIIlIllIIl.user().getEntityTracker(Protocol1_9To1_8.class);
                        final boolean llllllllllllllIIlIIIlIIIIlIlIIII = Via.getConfig().isShowShieldWhenSwordInHand() && Via.getConfig().isShieldBlocking();
                        for (short llllllllllllllIIlIIIlIIIIlIlllIl = 0; llllllllllllllIIlIIIlIIIIlIlllIl < llllllllllllllIIlIIIlIIIIlIllIII.length; ++llllllllllllllIIlIIIlIIIIlIlllIl) {
                            final Item llllllllllllllIIlIIIlIIIIlIlllll = llllllllllllllIIlIIIlIIIIlIllIII[llllllllllllllIIlIIIlIIIIlIlllIl];
                            if (llllllllllllllIIlIIIlIIIIlIlIIII) {
                                llllllllllllllIIlIIIlIIIIlIlIlII.setItemId(llllllllllllllIIlIIIlIIIIlIlIllI, llllllllllllllIIlIIIlIIIIlIlllIl, (llllllllllllllIIlIIIlIIIIlIlllll == null) ? 0 : llllllllllllllIIlIIIlIIIIlIlllll.identifier());
                            }
                            ItemRewriter.toClient(llllllllllllllIIlIIIlIIIIlIlllll);
                        }
                        if (llllllllllllllIIlIIIlIIIIlIlIIII) {
                            llllllllllllllIIlIIIlIIIIlIlIIlI.syncShieldWithSword();
                        }
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIllIIlIIllIIlIll) throws Exception {
                        final InventoryTracker lllllllllllllIlIIllIIlIIllIIlIlI = lllllllllllllIlIIllIIlIIllIIlIll.user().get(InventoryTracker.class);
                        if (lllllllllllllIlIIllIIlIIllIIlIlI.getInventory() != null && lllllllllllllIlIIllIIlIIllIIlIlI.getInventory().equals("minecraft:brewing_stand")) {
                            final Item[] lllllllllllllIlIIllIIlIIllIIlllI = lllllllllllllIlIIllIIlIIllIIlIll.get(Type.ITEM_ARRAY, 0);
                            final Item[] lllllllllllllIlIIllIIlIIllIIllIl = new Item[lllllllllllllIlIIllIIlIIllIIlllI.length + 1];
                            for (int lllllllllllllIlIIllIIlIIllIIllll = 0; lllllllllllllIlIIllIIlIIllIIllll < lllllllllllllIlIIllIIlIIllIIllIl.length; ++lllllllllllllIlIIllIIlIIllIIllll) {
                                if (lllllllllllllIlIIllIIlIIllIIllll > 4) {
                                    lllllllllllllIlIIllIIlIIllIIllIl[lllllllllllllIlIIllIIlIIllIIllll] = lllllllllllllIlIIllIIlIIllIIlllI[lllllllllllllIlIIllIIlIIllIIllll - 1];
                                }
                                else if (lllllllllllllIlIIllIIlIIllIIllll != 4) {
                                    lllllllllllllIlIIllIIlIIllIIllIl[lllllllllllllIlIIllIIlIIllIIllll] = lllllllllllllIlIIllIIlIIllIIlllI[lllllllllllllIlIIllIIlIIllIIllll];
                                }
                            }
                            lllllllllllllIlIIllIIlIIllIIlIll.set(Type.ITEM_ARRAY, 0, lllllllllllllIlIIllIIlIIllIIllIl);
                        }
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerClientbound(ClientboundPackets1_8.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIllIIlllIIlIlllI) throws Exception {
                        final InventoryTracker llllllllllllllllIllIIlllIIlIllIl = llllllllllllllllIllIIlllIIlIlllI.user().get(InventoryTracker.class);
                        llllllllllllllllIllIIlllIIlIllIl.setInventory(null);
                        llllllllllllllllIllIIlllIIlIllIl.resetInventory(llllllllllllllllIllIIlllIIlIlllI.get((Type<Short>)Type.UNSIGNED_BYTE, 0));
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerClientbound(ClientboundPackets1_8.MAP_DATA, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.VAR_INT);
                this.map(Type.BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIllIlIllIlllIlII) {
                        lllllllllllllIlIIllIlIllIlllIlII.write(Type.BOOLEAN, true);
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerServerbound(ServerboundPackets1_9.CREATIVE_INVENTORY_ACTION, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.map(Type.ITEM);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllllIlIIlIlIIlIlllIll) throws Exception {
                        final Item lllllllllllllllIlIIlIlIIlIlllIlI = lllllllllllllllIlIIlIlIIlIlllIll.get(Type.ITEM, 0);
                        final boolean lllllllllllllllIlIIlIlIIlIlllIIl = Via.getConfig().isShowShieldWhenSwordInHand() && Via.getConfig().isShieldBlocking();
                        if (lllllllllllllllIlIIlIlIIlIlllIIl) {
                            final InventoryTracker lllllllllllllllIlIIlIlIIlIllllll = lllllllllllllllIlIIlIlIIlIlllIll.user().get(InventoryTracker.class);
                            final EntityTracker1_9 lllllllllllllllIlIIlIlIIlIlllllI = lllllllllllllllIlIIlIlIIlIlllIll.user().getEntityTracker(Protocol1_9To1_8.class);
                            final short lllllllllllllllIlIIlIlIIlIllllIl = lllllllllllllllIlIIlIlIIlIlllIll.get((Type<Short>)Type.SHORT, 0);
                            lllllllllllllllIlIIlIlIIlIllllll.setItemId((short)0, lllllllllllllllIlIIlIlIIlIllllIl, (lllllllllllllllIlIIlIlIIlIlllIlI == null) ? 0 : lllllllllllllllIlIIlIlIIlIlllIlI.identifier());
                            lllllllllllllllIlIIlIlIIlIlllllI.syncShieldWithSword();
                        }
                        ItemRewriter.toServer(lllllllllllllllIlIIlIlIIlIlllIlI);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIlllllIIIIllIII) throws Exception {
                        final short llllllllllllllIIIIlllllIIIIlIlll = llllllllllllllIIIIlllllIIIIllIII.get((Type<Short>)Type.SHORT, 0);
                        final boolean llllllllllllllIIIIlllllIIIIlIllI = llllllllllllllIIIIlllllIIIIlIlll == 45;
                        if (llllllllllllllIIIIlllllIIIIlIllI) {
                            llllllllllllllIIIIlllllIIIIllIII.create(ClientboundPackets1_9.SET_SLOT, new PacketHandler() {
                                @Override
                                public void handle(final PacketWrapper lllllllllllllllIllIlIlllIllIlIlI) throws Exception {
                                    lllllllllllllllIllIlIlllIllIlIlI.write(Type.UNSIGNED_BYTE, (Short)0);
                                    lllllllllllllllIllIlIlllIllIlIlI.write(Type.SHORT, llllllllllllllIIIIlllllIIIIlIlll);
                                    lllllllllllllllIllIlIlllIllIlIlI.write(Type.ITEM, null);
                                }
                            }).send(Protocol1_9To1_8.class);
                            llllllllllllllIIIIlllllIIIIllIII.set(Type.SHORT, 0, (Short)(-999));
                        }
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerServerbound(ServerboundPackets1_9.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.VAR_INT, Type.BYTE);
                this.map(Type.ITEM);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlllIIlIIlllIIllII) throws Exception {
                        final Item lllllllllllllIIlllIIlIIlllIIlIll = lllllllllllllIIlllIIlIIlllIIllII.get(Type.ITEM, 0);
                        if (Via.getConfig().isShowShieldWhenSwordInHand()) {
                            final Short lllllllllllllIIlllIIlIIlllIlIIlI = lllllllllllllIIlllIIlIIlllIIllII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                            final byte lllllllllllllIIlllIIlIIlllIlIIIl = lllllllllllllIIlllIIlIIlllIIllII.get((Type<Byte>)Type.BYTE, 1);
                            final short lllllllllllllIIlllIIlIIlllIlIIII = lllllllllllllIIlllIIlIIlllIIllII.get((Type<Short>)Type.SHORT, 0);
                            final byte lllllllllllllIIlllIIlIIlllIIllll = lllllllllllllIIlllIIlIIlllIIllII.get((Type<Byte>)Type.BYTE, 0);
                            final InventoryTracker lllllllllllllIIlllIIlIIlllIIlllI = lllllllllllllIIlllIIlIIlllIIllII.user().get(InventoryTracker.class);
                            lllllllllllllIIlllIIlIIlllIIlllI.handleWindowClick(lllllllllllllIIlllIIlIIlllIIllII.user(), lllllllllllllIIlllIIlIIlllIlIIlI, lllllllllllllIIlllIIlIIlllIlIIIl, lllllllllllllIIlllIIlIIlllIlIIII, lllllllllllllIIlllIIlIIlllIIllll);
                        }
                        ItemRewriter.toServer(lllllllllllllIIlllIIlIIlllIIlIll);
                    }
                });
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllIIIIlIlIIlIlIlIIII) throws Exception {
                        final short llllllllllllllIIIIlIlIIlIlIlIlIl = llllllllllllllIIIIlIlIIlIlIlIIII.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                        final short llllllllllllllIIIIlIlIIlIlIlIlII = llllllllllllllIIIIlIlIIlIlIlIIII.get((Type<Short>)Type.SHORT, 0);
                        boolean llllllllllllllIIIIlIlIIlIlIlIIll = llllllllllllllIIIIlIlIIlIlIlIlII == 45 && llllllllllllllIIIIlIlIIlIlIlIlIl == 0;
                        final InventoryTracker llllllllllllllIIIIlIlIIlIlIlIIlI = llllllllllllllIIIIlIlIIlIlIlIIII.user().get(InventoryTracker.class);
                        if (llllllllllllllIIIIlIlIIlIlIlIIlI.getInventory() != null && llllllllllllllIIIIlIlIIlIlIlIIlI.getInventory().equals("minecraft:brewing_stand")) {
                            if (llllllllllllllIIIIlIlIIlIlIlIlII == 4) {
                                llllllllllllllIIIIlIlIIlIlIlIIll = true;
                            }
                            if (llllllllllllllIIIIlIlIIlIlIlIlII > 4) {
                                llllllllllllllIIIIlIlIIlIlIlIIII.set(Type.SHORT, 0, (short)(llllllllllllllIIIIlIlIIlIlIlIlII - 1));
                            }
                        }
                        if (llllllllllllllIIIIlIlIIlIlIlIIll) {
                            llllllllllllllIIIIlIlIIlIlIlIIII.create(ClientboundPackets1_9.SET_SLOT, new PacketHandler() {
                                @Override
                                public void handle(final PacketWrapper lllllllllllllIIIlIlllIllIIllllll) throws Exception {
                                    lllllllllllllIIIlIlllIllIIllllll.write(Type.UNSIGNED_BYTE, llllllllllllllIIIIlIlIIlIlIlIlIl);
                                    lllllllllllllIIIlIlllIllIIllllll.write(Type.SHORT, llllllllllllllIIIIlIlIIlIlIlIlII);
                                    lllllllllllllIIIlIlllIllIIllllll.write(Type.ITEM, null);
                                }
                            }).scheduleSend(Protocol1_9To1_8.class);
                            llllllllllllllIIIIlIlIIlIlIlIIII.set(Type.BYTE, 0, (Byte)0);
                            llllllllllllllIIIIlIlIIlIlIlIIII.set(Type.BYTE, 1, (Byte)0);
                            llllllllllllllIIIIlIlIIlIlIlIIII.set(Type.SHORT, 0, (Short)(-999));
                        }
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerServerbound(ServerboundPackets1_9.CLOSE_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIlIIlllIIlIllIIllII) throws Exception {
                        final InventoryTracker lllllllllllllIlIIlllIIlIllIIllIl = lllllllllllllIlIIlllIIlIllIIllII.user().get(InventoryTracker.class);
                        lllllllllllllIlIIlllIIlIllIIllIl.setInventory(null);
                        lllllllllllllIlIIlllIIlIllIIllIl.resetInventory(lllllllllllllIlIIlllIIlIllIIllII.get((Type<Short>)Type.UNSIGNED_BYTE, 0));
                    }
                });
            }
        });
        lllllllllllllllIIIIllIIIllIIllll.registerServerbound(ServerboundPackets1_9.HELD_ITEM_CHANGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.SHORT);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper llllllllllllllllIlllIlIlllIlIIII) throws Exception {
                        final boolean llllllllllllllllIlllIlIlllIIllll = Via.getConfig().isShowShieldWhenSwordInHand() && Via.getConfig().isShieldBlocking();
                        final EntityTracker1_9 llllllllllllllllIlllIlIlllIIlllI = llllllllllllllllIlllIlIlllIlIIII.user().getEntityTracker(Protocol1_9To1_8.class);
                        if (llllllllllllllllIlllIlIlllIIlllI.isBlocking()) {
                            llllllllllllllllIlllIlIlllIIlllI.setBlocking(false);
                            if (!llllllllllllllllIlllIlIlllIIllll) {
                                llllllllllllllllIlllIlIlllIIlllI.setSecondHand(null);
                            }
                        }
                        if (llllllllllllllllIlllIlIlllIIllll) {
                            llllllllllllllllIlllIlIlllIIlllI.setHeldItemSlot(llllllllllllllllIlllIlIlllIlIIII.get((Type<Short>)Type.SHORT, 0));
                            llllllllllllllllIlllIlIlllIIlllI.syncShieldWithSword();
                        }
                    }
                });
            }
        });
    }
}
