package com.viaversion.viaversion.protocols.protocol1_13to1_12_2.data;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import com.viaversion.viaversion.api.protocol.*;

public class RecipeRewriter1_13_2 extends RecipeRewriter
{
    public void handleCraftingShaped(final PacketWrapper llllllllllllllIIIlllIlIllIlIlIIl) throws Exception {
        final int llllllllllllllIIIlllIlIllIlIlIll = llllllllllllllIIIlllIlIllIlIlIIl.passthrough((Type<Integer>)Type.VAR_INT) * llllllllllllllIIIlllIlIllIlIlIIl.passthrough((Type<Integer>)Type.VAR_INT);
        llllllllllllllIIIlllIlIllIlIlIIl.passthrough(Type.STRING);
        for (int llllllllllllllIIIlllIlIllIlIlllI = 0; llllllllllllllIIIlllIlIllIlIlllI < llllllllllllllIIIlllIlIllIlIlIll; ++llllllllllllllIIIlllIlIllIlIlllI) {
            final short llllllllllllllIIIlllIlIllIlIIlIl;
            final Item[] llllllllllllllIIIlllIlIllIlIllll = (Object)(llllllllllllllIIIlllIlIllIlIIlIl = (short)(Object)llllllllllllllIIIlllIlIllIlIlIIl.passthrough(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
            final Exception llllllllllllllIIIlllIlIllIlIIlII = (Exception)llllllllllllllIIIlllIlIllIlIIlIl.length;
            for (char llllllllllllllIIIlllIlIllIlIIIll = '\0'; llllllllllllllIIIlllIlIllIlIIIll < llllllllllllllIIIlllIlIllIlIIlII; ++llllllllllllllIIIlllIlIllIlIIIll) {
                final Item llllllllllllllIIIlllIlIllIllIIII = llllllllllllllIIIlllIlIllIlIIlIl[llllllllllllllIIIlllIlIllIlIIIll];
                this.rewrite(llllllllllllllIIIlllIlIllIllIIII);
            }
        }
        this.rewrite(llllllllllllllIIIlllIlIllIlIlIIl.passthrough(Type.FLAT_VAR_INT_ITEM));
    }
    
    public void handleCraftingShapeless(final PacketWrapper llllllllllllllIIIlllIlIllIIlIlII) throws Exception {
        llllllllllllllIIIlllIlIllIIlIlII.passthrough(Type.STRING);
        for (int llllllllllllllIIIlllIlIllIIlIIll = llllllllllllllIIIlllIlIllIIlIlII.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllIIIlllIlIllIIlIllI = 0; llllllllllllllIIIlllIlIllIIlIllI < llllllllllllllIIIlllIlIllIIlIIll; ++llllllllllllllIIIlllIlIllIIlIllI) {
            final long llllllllllllllIIIlllIlIllIIIllIl;
            final Item[] llllllllllllllIIIlllIlIllIIlIlll = (Object)(llllllllllllllIIIlllIlIllIIIllIl = (long)(Object)llllllllllllllIIIlllIlIllIIlIlII.passthrough(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
            final char llllllllllllllIIIlllIlIllIIIllII = (char)llllllllllllllIIIlllIlIllIIIllIl.length;
            for (double llllllllllllllIIIlllIlIllIIIlIll = 0; llllllllllllllIIIlllIlIllIIIlIll < llllllllllllllIIIlllIlIllIIIllII; ++llllllllllllllIIIlllIlIllIIIlIll) {
                final Item llllllllllllllIIIlllIlIllIIllIII = llllllllllllllIIIlllIlIllIIIllIl[llllllllllllllIIIlllIlIllIIIlIll];
                this.rewrite(llllllllllllllIIIlllIlIllIIllIII);
            }
        }
        this.rewrite(llllllllllllllIIIlllIlIllIIlIlII.passthrough(Type.FLAT_VAR_INT_ITEM));
    }
    
    public void handleSmelting(final PacketWrapper llllllllllllllIIIlllIlIllIllllll) throws Exception {
        llllllllllllllIIIlllIlIllIllllll.passthrough(Type.STRING);
        final boolean llllllllllllllIIIlllIlIllIllllIl;
        final Item[] llllllllllllllIIIlllIlIlllIIIIIl = (Object)(llllllllllllllIIIlllIlIllIllllIl = (boolean)(Object)llllllllllllllIIIlllIlIllIllllll.passthrough(Type.FLAT_VAR_INT_ITEM_ARRAY_VAR_INT));
        final float llllllllllllllIIIlllIlIllIllllII = llllllllllllllIIIlllIlIllIllllIl.length;
        for (boolean llllllllllllllIIIlllIlIllIlllIll = false; (llllllllllllllIIIlllIlIllIlllIll ? 1 : 0) < llllllllllllllIIIlllIlIllIllllII; ++llllllllllllllIIIlllIlIllIlllIll) {
            final Item llllllllllllllIIIlllIlIlllIIIlII = llllllllllllllIIIlllIlIllIllllIl[llllllllllllllIIIlllIlIllIlllIll];
            this.rewrite(llllllllllllllIIIlllIlIlllIIIlII);
        }
        this.rewrite(llllllllllllllIIIlllIlIllIllllll.passthrough(Type.FLAT_VAR_INT_ITEM));
        llllllllllllllIIIlllIlIllIllllll.passthrough((Type<Object>)Type.FLOAT);
        llllllllllllllIIIlllIlIllIllllll.passthrough((Type<Object>)Type.VAR_INT);
    }
    
    public RecipeRewriter1_13_2(final Protocol llllllllllllllIIIlllIlIlllIIllII) {
        super(llllllllllllllIIIlllIlIlllIIllII);
        this.recipeHandlers.put("crafting_shapeless", this::handleCraftingShapeless);
        this.recipeHandlers.put("crafting_shaped", this::handleCraftingShaped);
        this.recipeHandlers.put("smelting", this::handleSmelting);
    }
}
