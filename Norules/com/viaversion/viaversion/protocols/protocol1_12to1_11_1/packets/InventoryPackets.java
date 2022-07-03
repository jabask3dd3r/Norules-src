package com.viaversion.viaversion.protocols.protocol1_12to1_11_1.packets;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.*;
import com.viaversion.viaversion.api.*;
import com.viaversion.viaversion.protocols.protocol1_12to1_11_1.providers.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets extends ItemRewriter<Protocol1_12To1_11_1>
{
    @Override
    public Item handleItemToServer(final Item llIIIlllIlIIl) {
        if (llIIIlllIlIIl == null) {
            return null;
        }
        BedRewriter.toServerItem(llIIIlllIlIIl);
        boolean llIIIlllIlIlI = llIIIlllIlIIl.identifier() >= 235 && llIIIlllIlIIl.identifier() <= 252;
        llIIIlllIlIlI |= (llIIIlllIlIIl.identifier() == 453);
        if (llIIIlllIlIlI) {
            llIIIlllIlIIl.setIdentifier(1);
            llIIIlllIlIIl.setData((short)0);
        }
        return llIIIlllIlIIl;
    }
    
    public void registerPackets() {
        this.registerSetSlot(ClientboundPackets1_9_3.SET_SLOT, Type.ITEM);
        this.registerWindowItems(ClientboundPackets1_9_3.WINDOW_ITEMS, Type.ITEM_ARRAY);
        this.registerEntityEquipment(ClientboundPackets1_9_3.ENTITY_EQUIPMENT, Type.ITEM);
        ((AbstractProtocol<ClientboundPackets1_9_3, C2, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_9_3.PLUGIN_MESSAGE, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.STRING);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIIIllIIllIIlIlllII) throws Exception {
                        if (lllllllllllllIIIIllIIllIIlIlllII.get(Type.STRING, 0).equalsIgnoreCase("MC|TrList")) {
                            lllllllllllllIIIIllIIllIIlIlllII.passthrough((Type<Object>)Type.INT);
                            for (int lllllllllllllIIIIllIIllIIlIlllll = lllllllllllllIIIIllIIllIIlIlllII.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllIIIIllIIllIIllIIIII = 0; lllllllllllllIIIIllIIllIIllIIIII < lllllllllllllIIIIllIIllIIlIlllll; ++lllllllllllllIIIIllIIllIIllIIIII) {
                                BedRewriter.toClientItem(lllllllllllllIIIIllIIllIIlIlllII.passthrough(Type.ITEM));
                                BedRewriter.toClientItem(lllllllllllllIIIIllIIllIIlIlllII.passthrough(Type.ITEM));
                                final boolean lllllllllllllIIIIllIIllIIllIIIIl = lllllllllllllIIIIllIIllIIlIlllII.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllIIIIllIIllIIllIIIIl) {
                                    BedRewriter.toClientItem(lllllllllllllIIIIllIIllIIlIlllII.passthrough(Type.ITEM));
                                }
                                lllllllllllllIIIIllIIllIIlIlllII.passthrough((Type<Object>)Type.BOOLEAN);
                                lllllllllllllIIIIllIIllIIlIlllII.passthrough((Type<Object>)Type.INT);
                                lllllllllllllIIIIllIIllIIlIlllII.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_12>)this.protocol).registerServerbound(ServerboundPackets1_12.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.map(Type.SHORT);
                this.map(Type.VAR_INT);
                this.map(Type.ITEM);
                this.handler(new PacketHandler() {
                    @Override
                    public void handle(final PacketWrapper lllllllllllllIIlllIIlllIIlIlIIll) throws Exception {
                        final Item lllllllllllllIIlllIIlllIIlIlIIlI = lllllllllllllIIlllIIlllIIlIlIIll.get(Type.ITEM, 0);
                        if (!Via.getConfig().is1_12QuickMoveActionFix()) {
                            BedRewriter.toServerItem(lllllllllllllIIlllIIlllIIlIlIIlI);
                            return;
                        }
                        final byte lllllllllllllIIlllIIlllIIlIlIIIl = lllllllllllllIIlllIIlllIIlIlIIll.get((Type<Byte>)Type.BYTE, 0);
                        final int lllllllllllllIIlllIIlllIIlIlIIII = lllllllllllllIIlllIIlllIIlIlIIll.get((Type<Integer>)Type.VAR_INT, 0);
                        if (lllllllllllllIIlllIIlllIIlIlIIII == 1 && lllllllllllllIIlllIIlllIIlIlIIIl == 0 && lllllllllllllIIlllIIlllIIlIlIIlI == null) {
                            final short lllllllllllllIIlllIIlllIIlIllIIl = lllllllllllllIIlllIIlllIIlIlIIll.get((Type<Short>)Type.UNSIGNED_BYTE, 0);
                            final short lllllllllllllIIlllIIlllIIlIllIII = lllllllllllllIIlllIIlllIIlIlIIll.get((Type<Short>)Type.SHORT, 0);
                            final short lllllllllllllIIlllIIlllIIlIlIlll = lllllllllllllIIlllIIlllIIlIlIIll.get((Type<Short>)Type.SHORT, 1);
                            final InventoryQuickMoveProvider lllllllllllllIIlllIIlllIIlIlIllI = Via.getManager().getProviders().get(InventoryQuickMoveProvider.class);
                            final boolean lllllllllllllIIlllIIlllIIlIlIlIl = lllllllllllllIIlllIIlllIIlIlIllI.registerQuickMoveAction(lllllllllllllIIlllIIlllIIlIllIIl, lllllllllllllIIlllIIlllIIlIllIII, lllllllllllllIIlllIIlllIIlIlIlll, lllllllllllllIIlllIIlllIIlIlIIll.user());
                            if (lllllllllllllIIlllIIlllIIlIlIlIl) {
                                lllllllllllllIIlllIIlllIIlIlIIll.cancel();
                            }
                        }
                        else {
                            BedRewriter.toServerItem(lllllllllllllIIlllIIlllIIlIlIIlI);
                        }
                    }
                });
            }
        });
        this.registerCreativeInvAction(ServerboundPackets1_12.CREATIVE_INVENTORY_ACTION, Type.ITEM);
    }
    
    public InventoryPackets(final Protocol1_12To1_11_1 llIIIllllIlII) {
        super(llIIIllllIlII);
    }
}
