package com.viaversion.viaversion.protocols.protocol1_11to1_10.packets;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_11to1_10.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.*;

public class InventoryPackets extends ItemRewriter<Protocol1_11To1_10>
{
    @Override
    public Item handleItemToClient(final Item llllllllllllllIlIlIIllIIIllIlllI) {
        EntityIdRewriter.toClientItem(llllllllllllllIlIlIIllIIIllIlllI);
        return llllllllllllllIlIlIIllIIIllIlllI;
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
                    public void handle(final PacketWrapper lllllllllllllllIlIllllIIIIIlIlll) throws Exception {
                        if (lllllllllllllllIlIllllIIIIIlIlll.get(Type.STRING, 0).equalsIgnoreCase("MC|TrList")) {
                            lllllllllllllllIlIllllIIIIIlIlll.passthrough((Type<Object>)Type.INT);
                            for (int lllllllllllllllIlIllllIIIIIllIlI = lllllllllllllllIlIllllIIIIIlIlll.passthrough((Type<Short>)Type.UNSIGNED_BYTE), lllllllllllllllIlIllllIIIIIllIll = 0; lllllllllllllllIlIllllIIIIIllIll < lllllllllllllllIlIllllIIIIIllIlI; ++lllllllllllllllIlIllllIIIIIllIll) {
                                EntityIdRewriter.toClientItem(lllllllllllllllIlIllllIIIIIlIlll.passthrough(Type.ITEM));
                                EntityIdRewriter.toClientItem(lllllllllllllllIlIllllIIIIIlIlll.passthrough(Type.ITEM));
                                final boolean lllllllllllllllIlIllllIIIIIlllII = lllllllllllllllIlIllllIIIIIlIlll.passthrough((Type<Boolean>)Type.BOOLEAN);
                                if (lllllllllllllllIlIllllIIIIIlllII) {
                                    EntityIdRewriter.toClientItem(lllllllllllllllIlIllllIIIIIlIlll.passthrough(Type.ITEM));
                                }
                                lllllllllllllllIlIllllIIIIIlIlll.passthrough((Type<Object>)Type.BOOLEAN);
                                lllllllllllllllIlIllllIIIIIlIlll.passthrough((Type<Object>)Type.INT);
                                lllllllllllllllIlIllllIIIIIlIlll.passthrough((Type<Object>)Type.INT);
                            }
                        }
                    }
                });
            }
        });
        this.registerClickWindow(ServerboundPackets1_9_3.CLICK_WINDOW, Type.ITEM);
        this.registerCreativeInvAction(ServerboundPackets1_9_3.CREATIVE_INVENTORY_ACTION, Type.ITEM);
    }
    
    @Override
    public Item handleItemToServer(final Item llllllllllllllIlIlIIllIIIllIlIII) {
        EntityIdRewriter.toServerItem(llllllllllllllIlIlIIllIIIllIlIII);
        if (llllllllllllllIlIlIIllIIIllIlIII == null) {
            return null;
        }
        boolean llllllllllllllIlIlIIllIIIllIlIIl = llllllllllllllIlIlIIllIIIllIlIII.identifier() >= 218 && llllllllllllllIlIlIIllIIIllIlIII.identifier() <= 234;
        llllllllllllllIlIlIIllIIIllIlIIl |= (llllllllllllllIlIlIIllIIIllIlIII.identifier() == 449 || llllllllllllllIlIlIIllIIIllIlIII.identifier() == 450);
        if (llllllllllllllIlIlIIllIIIllIlIIl) {
            llllllllllllllIlIlIIllIIIllIlIII.setIdentifier(1);
            llllllllllllllIlIlIIllIIIllIlIII.setData((short)0);
        }
        return llllllllllllllIlIlIIllIIIllIlIII;
    }
    
    public InventoryPackets(final Protocol1_11To1_10 llllllllllllllIlIlIIllIIIlllIlll) {
        super(llllllllllllllIlIlIIllIIIlllIlll);
    }
}
