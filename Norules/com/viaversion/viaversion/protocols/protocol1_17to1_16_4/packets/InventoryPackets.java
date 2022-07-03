package com.viaversion.viaversion.protocols.protocol1_17to1_16_4.packets;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.protocols.protocol1_16to1_15_2.data.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.storage.*;
import com.viaversion.viaversion.protocols.protocol1_17to1_16_4.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.protocols.protocol1_16_2to1_16_1.*;
import com.viaversion.viaversion.api.protocol.*;

public final class InventoryPackets extends ItemRewriter<Protocol1_17To1_16_4>
{
    public InventoryPackets(final Protocol1_17To1_16_4 llllllllllllllIIIIIlIIIIlIIllIIl) {
        super(llllllllllllllIIIIIlIIIIlIIllIIl);
    }
    
    public void registerPackets() {
        this.registerSetCooldown(ClientboundPackets1_16_2.COOLDOWN);
        this.registerWindowItems(ClientboundPackets1_16_2.WINDOW_ITEMS, Type.FLAT_VAR_INT_ITEM_ARRAY);
        this.registerTradeList(ClientboundPackets1_16_2.TRADE_LIST, Type.FLAT_VAR_INT_ITEM);
        this.registerSetSlot(ClientboundPackets1_16_2.SET_SLOT, Type.FLAT_VAR_INT_ITEM);
        this.registerAdvancements(ClientboundPackets1_16_2.ADVANCEMENTS, Type.FLAT_VAR_INT_ITEM);
        this.registerEntityEquipmentArray(ClientboundPackets1_16_2.ENTITY_EQUIPMENT, Type.FLAT_VAR_INT_ITEM);
        this.registerSpawnParticle(ClientboundPackets1_16_2.SPAWN_PARTICLE, Type.FLAT_VAR_INT_ITEM, Type.DOUBLE);
        new RecipeRewriter1_16(this.protocol).registerDefaultHandler(ClientboundPackets1_16_2.DECLARE_RECIPES);
        this.registerCreativeInvAction(ServerboundPackets1_17.CREATIVE_INVENTORY_ACTION, Type.FLAT_VAR_INT_ITEM);
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_17>)this.protocol).registerServerbound(ServerboundPackets1_17.EDIT_BOOK, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.handler(lllllllllllllllIIlllllIIlllIIllI -> InventoryPackets.this.handleItemToServer(lllllllllllllllIIlllllIIlllIIllI.passthrough(Type.FLAT_VAR_INT_ITEM)));
            }
        });
        ((AbstractProtocol<C1, C2, S1, ServerboundPackets1_17>)this.protocol).registerServerbound(ServerboundPackets1_17.CLICK_WINDOW, new PacketRemapper() {
            @Override
            public void registerMap() {
                this.map(Type.UNSIGNED_BYTE);
                this.map(Type.SHORT);
                this.map(Type.BYTE);
                this.handler(llllllllllllllIIIllIllIlIIIlIIll -> llllllllllllllIIIllIllIlIIIlIIll.write(Type.SHORT, (Short)0));
                this.map(Type.VAR_INT);
                int llllllllllllllIIIllIllIlIIIlllIl;
                int llllllllllllllIIIllIllIlIIlIIIII;
                Item llllllllllllllIIIllIllIlIIIlllII;
                final int llllllllllllllIIIllIllIlIIIllIll;
                this.handler(llllllllllllllIIIllIllIlIIIllllI -> {
                    for (llllllllllllllIIIllIllIlIIIlllIl = llllllllllllllIIIllIllIlIIIllllI.read((Type<Integer>)Type.VAR_INT), llllllllllllllIIIllIllIlIIlIIIII = 0; llllllllllllllIIIllIllIlIIlIIIII < llllllllllllllIIIllIllIlIIIlllIl; ++llllllllllllllIIIllIllIlIIlIIIII) {
                        llllllllllllllIIIllIllIlIIIllllI.read((Type<Object>)Type.SHORT);
                        llllllllllllllIIIllIllIlIIIllllI.read(Type.FLAT_VAR_INT_ITEM);
                    }
                    llllllllllllllIIIllIllIlIIIlllII = llllllllllllllIIIllIllIlIIIllllI.read(Type.FLAT_VAR_INT_ITEM);
                    llllllllllllllIIIllIllIlIIIllIll = llllllllllllllIIIllIllIlIIIllllI.get((Type<Integer>)Type.VAR_INT, 0);
                    if (llllllllllllllIIIllIllIlIIIllIll == 5) {
                        llllllllllllllIIIllIllIlIIIlllII = null;
                    }
                    else {
                        InventoryPackets.this.handleItemToServer(llllllllllllllIIIllIllIlIIIlllII);
                    }
                    llllllllllllllIIIllIllIlIIIllllI.write(Type.FLAT_VAR_INT_ITEM, llllllllllllllIIIllIllIlIIIlllII);
                });
            }
        });
        ((Protocol<ClientboundPackets1_16_2, ClientboundPackets1_17, S1, S2>)this.protocol).registerClientbound(ClientboundPackets1_16_2.WINDOW_CONFIRMATION, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final short lIIlllllIIIllI;
                final short lIIlllllIIIlIl;
                final boolean lIIlllllIIIlII;
                int lIIlllllIIlIIl;
                PacketWrapper lIIlllllIIlIII;
                this.handler(lIIlllllIIIIll -> {
                    lIIlllllIIIllI = lIIlllllIIIIll.read((Type<Short>)Type.UNSIGNED_BYTE);
                    lIIlllllIIIlIl = lIIlllllIIIIll.read((Type<Short>)Type.SHORT);
                    lIIlllllIIIlII = lIIlllllIIIIll.read((Type<Boolean>)Type.BOOLEAN);
                    if (!lIIlllllIIIlII) {
                        lIIlllllIIlIIl = (0x40000000 | lIIlllllIIIllI << 16 | (lIIlllllIIIlIl & 0xFFFF));
                        lIIlllllIIIIll.user().get(InventoryAcknowledgements.class).addId(lIIlllllIIlIIl);
                        lIIlllllIIlIII = lIIlllllIIIIll.create(ClientboundPackets1_17.PING);
                        lIIlllllIIlIII.write(Type.INT, lIIlllllIIlIIl);
                        lIIlllllIIlIII.send(Protocol1_17To1_16_4.class);
                    }
                    lIIlllllIIIIll.cancel();
                });
            }
        });
        ((Protocol<C1, C2, ServerboundPackets1_16_2, ServerboundPackets1_17>)this.protocol).registerServerbound(ServerboundPackets1_17.PONG, null, new PacketRemapper() {
            @Override
            public void registerMap() {
                final int lllllllllllllIIIlIIllIlIlIllllII;
                short lllllllllllllIIIlIIllIlIllIIIIII;
                short lllllllllllllIIIlIIllIlIlIllllll;
                PacketWrapper lllllllllllllIIIlIIllIlIlIlllllI;
                this.handler(lllllllllllllIIIlIIllIlIlIlllIll -> {
                    lllllllllllllIIIlIIllIlIlIllllII = lllllllllllllIIIlIIllIlIlIlllIll.read((Type<Integer>)Type.INT);
                    if ((lllllllllllllIIIlIIllIlIlIllllII & 0x40000000) != 0x0 && lllllllllllllIIIlIIllIlIlIlllIll.user().get(InventoryAcknowledgements.class).removeId(lllllllllllllIIIlIIllIlIlIllllII)) {
                        lllllllllllllIIIlIIllIlIllIIIIII = (short)(lllllllllllllIIIlIIllIlIlIllllII >> 16 & 0xFF);
                        lllllllllllllIIIlIIllIlIlIllllll = (short)(lllllllllllllIIIlIIllIlIlIllllII & 0xFFFF);
                        lllllllllllllIIIlIIllIlIlIlllllI = lllllllllllllIIIlIIllIlIlIlllIll.create(ServerboundPackets1_16_2.WINDOW_CONFIRMATION);
                        lllllllllllllIIIlIIllIlIlIlllllI.write(Type.UNSIGNED_BYTE, lllllllllllllIIIlIIllIlIllIIIIII);
                        lllllllllllllIIIlIIllIlIlIlllllI.write(Type.SHORT, lllllllllllllIIIlIIllIlIlIllllll);
                        lllllllllllllIIIlIIllIlIlIlllllI.write(Type.BOOLEAN, true);
                        lllllllllllllIIIlIIllIlIlIlllllI.sendToServer(Protocol1_17To1_16_4.class);
                    }
                    lllllllllllllIIIlIIllIlIlIlllIll.cancel();
                });
            }
        });
    }
}
