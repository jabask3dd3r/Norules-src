package com.viaversion.viaversion.protocols.protocol1_16to1_15_2.data;

import com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.*;

public class RecipeRewriter1_16 extends RecipeRewriter1_14
{
    public void handleSmithing(final PacketWrapper lllllllllllllllllllllllIllllllIl) throws Exception {
        final boolean lllllllllllllllllllllllIllllIlll;
        final Item[] lllllllllllllllllllllllIllllllII = (Object)(lllllllllllllllllllllllIllllIlll = (boolean)(Object)lllllllllllllllllllllllIllllllIl.passthrough(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
        short lllllllllllllllllllllllIllllIllI = (short)lllllllllllllllllllllllIllllIlll.length;
        for (final Item llllllllllllllllllllllllIIIIIIII : lllllllllllllllllllllllIllllIlll) {
            this.rewrite(llllllllllllllllllllllllIIIIIIII);
        }
        final Item[] lllllllllllllllllllllllIlllllIll = (Object)(lllllllllllllllllllllllIllllIllI = (short)(Object)lllllllllllllllllllllllIllllllIl.passthrough(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
        final int lllllllllllllllllllllllIllllIlIl = lllllllllllllllllllllllIllllIllI.length;
        for (float lllllllllllllllllllllllIllllIlII = 0; lllllllllllllllllllllllIllllIlII < lllllllllllllllllllllllIllllIlIl; ++lllllllllllllllllllllllIllllIlII) {
            final Item lllllllllllllllllllllllIllllllll = lllllllllllllllllllllllIllllIllI[lllllllllllllllllllllllIllllIlII];
            this.rewrite(lllllllllllllllllllllllIllllllll);
        }
        this.rewrite(lllllllllllllllllllllllIllllllIl.passthrough(Type.FLAT_VAR_INT_ITEM));
    }
    
    public RecipeRewriter1_16(final Protocol llllllllllllllllllllllllIIIIlIIl) {
        super(llllllllllllllllllllllllIIIIlIIl);
        this.recipeHandlers.put("smithing", this::handleSmithing);
    }
}
