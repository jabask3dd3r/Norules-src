package com.viaversion.viaversion.protocols.protocol1_12to1_11_1;

import com.viaversion.viaversion.api.minecraft.item.*;

public class BedRewriter
{
    public static void toServerItem(final Item lllllllllllllIIlIlllllllllIlIlII) {
        if (lllllllllllllIIlIlllllllllIlIlII == null) {
            return;
        }
        if (lllllllllllllIIlIlllllllllIlIlII.identifier() == 355 && lllllllllllllIIlIlllllllllIlIlII.data() == 14) {
            lllllllllllllIIlIlllllllllIlIlII.setData((short)0);
        }
    }
    
    public static void toClientItem(final Item lllllllllllllIIlIlllllllllIlIlll) {
        if (lllllllllllllIIlIlllllllllIlIlll == null) {
            return;
        }
        if (lllllllllllllIIlIlllllllllIlIlll.identifier() == 355 && lllllllllllllIIlIlllllllllIlIlll.data() == 0) {
            lllllllllllllIIlIlllllllllIlIlll.setData((short)14);
        }
    }
}
