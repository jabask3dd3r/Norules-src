package com.viaversion.viaversion.protocols.protocol1_14to1_13_2.data;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.*;

public class CommandRewriter1_14 extends CommandRewriter
{
    public CommandRewriter1_14(final Protocol lllllllllllllllIllIlllIlIlIllIIl) {
        super(lllllllllllllllIllIlllIlIlIllIIl);
    }
    
    @Override
    protected String handleArgumentType(final String lllllllllllllllIllIlllIlIlIlIIIl) {
        if (lllllllllllllllIllIlllIlIlIlIIIl.equals("minecraft:nbt")) {
            return "minecraft:nbt_compound_tag";
        }
        return super.handleArgumentType(lllllllllllllllIllIlllIlIlIlIIIl);
    }
}
