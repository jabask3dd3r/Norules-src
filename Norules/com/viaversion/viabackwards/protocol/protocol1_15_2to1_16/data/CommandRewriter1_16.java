package com.viaversion.viabackwards.protocol.protocol1_15_2to1_16.data;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.*;

public class CommandRewriter1_16 extends CommandRewriter
{
    @Override
    protected String handleArgumentType(final String llllllllllllllIIIIlIIIllllllIllI) {
        if (llllllllllllllIIIIlIIIllllllIllI.equals("minecraft:uuid")) {
            return "minecraft:game_profile";
        }
        return super.handleArgumentType(llllllllllllllIIIIlIIIllllllIllI);
    }
    
    public CommandRewriter1_16(final Protocol llllllllllllllIIIIlIIIllllllllII) {
        super(llllllllllllllIIIIlIIIllllllllII);
    }
}
