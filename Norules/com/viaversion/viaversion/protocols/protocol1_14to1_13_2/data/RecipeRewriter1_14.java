package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data;

import com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data.*;
import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public class RecipeRewriter1_14 extends RecipeRewriter1_13_2
{
    public RecipeRewriter1_14(final Protocol lllllllllllllIllIlIIIllIIIlIIIll) {
        super(lllllllllllllIllIlIIIllIIIlIIIll);
        this.recipeHandlers.put("stonecutting", this::handleStonecutting);
        this.recipeHandlers.put("blasting", this::handleSmelting);
        this.recipeHandlers.put("smoking", this::handleSmelting);
        this.recipeHandlers.put("campfire_cooking", this::handleSmelting);
    }
    
    public void handleStonecutting(final PacketWrapper lllllllllllllIllIlIIIllIIIIlIlII) throws Exception {
        lllllllllllllIllIlIIIllIIIIlIlII.passthrough(Type.STRING);
        final float lllllllllllllIllIlIIIllIIIIlIIlI;
        final Item[] lllllllllllllIllIlIIIllIIIIlIllI = (Object)(lllllllllllllIllIlIIIllIIIIlIIlI = (float)(Object)lllllllllllllIllIlIIIllIIIIlIlII.passthrough(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
        final byte lllllllllllllIllIlIIIllIIIIlIIIl = (byte)lllllllllllllIllIlIIIllIIIIlIIlI.length;
        for (long lllllllllllllIllIlIIIllIIIIlIIII = 0; lllllllllllllIllIlIIIllIIIIlIIII < lllllllllllllIllIlIIIllIIIIlIIIl; ++lllllllllllllIllIlIIIllIIIIlIIII) {
            final Item lllllllllllllIllIlIIIllIIIIllIIl = lllllllllllllIllIlIIIllIIIIlIIlI[lllllllllllllIllIlIIIllIIIIlIIII];
            this.rewrite(lllllllllllllIllIlIIIllIIIIllIIl);
        }
        this.rewrite(lllllllllllllIllIlIIIllIIIIlIlII.passthrough(Type.FLAT_VAR_INT_ITEM));
    }
}
