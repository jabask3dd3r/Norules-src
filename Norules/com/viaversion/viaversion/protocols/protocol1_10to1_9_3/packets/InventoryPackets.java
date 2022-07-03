package com.viaversion.viaversion.protocols.protocol1_10to1_9_3.packets;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.protocols.protocol1_10to1_9_3.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.protocols.protocol1_9_3to1_9_1_2.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;

public class InventoryPackets extends ItemRewriter<Protocol1_10To1_9_3_4>
{
    @Override
    public Item handleItemToServer(final Item lIIllllllIIllI) {
        if (lIIllllllIIllI == null) {
            return null;
        }
        final boolean lIIllllllIIlll = lIIllllllIIllI.identifier() >= 213 && lIIllllllIIllI.identifier() <= 217;
        if (lIIllllllIIlll) {
            lIIllllllIIllI.setIdentifier(1);
            lIIllllllIIllI.setData((short)0);
        }
        return lIIllllllIIllI;
    }
    
    public InventoryPackets(final Protocol1_10To1_9_3_4 lIIlllllllIIIl) {
        super(lIIlllllllIIIl);
    }
    
    public void registerPackets() {
        this.registerCreativeInvAction(ServerboundPackets1_9_3.CREATIVE_INVENTORY_ACTION, Type.ITEM);
    }
}
