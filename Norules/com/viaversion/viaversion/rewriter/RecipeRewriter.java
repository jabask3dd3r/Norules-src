package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import java.util.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;

public abstract class RecipeRewriter
{
    protected final /* synthetic */ Protocol protocol;
    protected final /* synthetic */ Map<String, RecipeConsumer> recipeHandlers;
    
    protected RecipeRewriter(final Protocol lllllllllllllIIIllIlIlIlllIlllIl) {
        this.recipeHandlers = new HashMap<String, RecipeConsumer>();
        this.protocol = lllllllllllllIIIllIlIlIlllIlllIl;
    }
    
    public void registerDefaultHandler(final ClientboundPacketType lllllllllllllIIIllIlIlIlllIIlIll) {
        this.protocol.registerClientbound(lllllllllllllIIIllIlIlIlllIIlIll, new PacketRemapper() {
            @Override
            public void registerMap() {
                int lllllllllllllIlIlllIIlIIlllllllI;
                int lllllllllllllIlIlllIIlIlIIIIIIIl;
                String lllllllllllllIlIlllIIlIlIIIIIIll;
                String lllllllllllllIlIlllIIlIlIIIIIIlI;
                this.handler(lllllllllllllIlIlllIIlIIllllllll -> {
                    for (lllllllllllllIlIlllIIlIIlllllllI = lllllllllllllIlIlllIIlIIllllllll.passthrough((Type<Integer>)Type.VAR_INT), lllllllllllllIlIlllIIlIlIIIIIIIl = 0; lllllllllllllIlIlllIIlIlIIIIIIIl < lllllllllllllIlIlllIIlIIlllllllI; ++lllllllllllllIlIlllIIlIlIIIIIIIl) {
                        lllllllllllllIlIlllIIlIlIIIIIIll = lllllllllllllIlIlllIIlIIllllllll.passthrough(Type.STRING).replace("minecraft:", "");
                        lllllllllllllIlIlllIIlIlIIIIIIlI = lllllllllllllIlIlllIIlIIllllllll.passthrough(Type.STRING);
                        RecipeRewriter.this.handle(lllllllllllllIlIlllIIlIIllllllll, lllllllllllllIlIlllIIlIlIIIIIIll);
                    }
                });
            }
        });
    }
    
    protected void rewrite(final Item lllllllllllllIIIllIlIlIlllIIIIll) {
        if (this.protocol.getItemRewriter() != null) {
            this.protocol.getItemRewriter().handleItemToClient(lllllllllllllIIIllIlIlIlllIIIIll);
        }
    }
    
    public void handle(final PacketWrapper lllllllllllllIIIllIlIlIlllIlIIIl, final String lllllllllllllIIIllIlIlIlllIlIlII) throws Exception {
        final RecipeConsumer lllllllllllllIIIllIlIlIlllIlIIll = this.recipeHandlers.get(lllllllllllllIIIllIlIlIlllIlIlII);
        if (lllllllllllllIIIllIlIlIlllIlIIll != null) {
            lllllllllllllIIIllIlIlIlllIlIIll.accept(lllllllllllllIIIllIlIlIlllIlIIIl);
        }
    }
    
    @FunctionalInterface
    public interface RecipeConsumer
    {
        void accept(final PacketWrapper p0) throws Exception;
    }
}
