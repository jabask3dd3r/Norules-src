package com.viaversion.viabackwards.protocol.protocol1_13_2to1_14.data;

import com.viaversion.viaversion.rewriter.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.*;

public class CommandRewriter1_14 extends CommandRewriter
{
    @Override
    protected String handleArgumentType(final String llllllllllllllIIlIIlIlllllIIlIlI) {
        final long llllllllllllllIIlIIlIlllllIIIlll = (long)llllllllllllllIIlIIlIlllllIIlIlI;
        float llllllllllllllIIlIIlIlllllIIIllI = -1;
        switch (((String)llllllllllllllIIlIIlIlllllIIIlll).hashCode()) {
            case -783223342: {
                if (((String)llllllllllllllIIlIIlIlllllIIIlll).equals("minecraft:nbt_compound_tag")) {
                    llllllllllllllIIlIIlIlllllIIIllI = 0;
                    break;
                }
                break;
            }
            case 543170382: {
                if (((String)llllllllllllllIIlIIlIlllllIIIlll).equals("minecraft:nbt_tag")) {
                    llllllllllllllIIlIIlIlllllIIIllI = 1;
                    break;
                }
                break;
            }
            case -1006391174: {
                if (((String)llllllllllllllIIlIIlIlllllIIIlll).equals("minecraft:time")) {
                    llllllllllllllIIlIIlIlllllIIIllI = 2;
                    break;
                }
                break;
            }
        }
        switch (llllllllllllllIIlIIlIlllllIIIllI) {
            case 0.0f: {
                return "minecraft:nbt";
            }
            case 1.0f: {
                return "brigadier:string";
            }
            case 2.0f: {
                return "brigadier:integer";
            }
            default: {
                return super.handleArgumentType(llllllllllllllIIlIIlIlllllIIlIlI);
            }
        }
    }
    
    public CommandRewriter1_14(final Protocol llllllllllllllIIlIIlIlllllIlIIlI) {
        super(llllllllllllllIIlIIlIlllllIlIIlI);
        this.parserHandlers.put("minecraft:nbt_tag", llllllllllllllIIlIIlIlllllIIIIIl -> llllllllllllllIIlIIlIlllllIIIIIl.write(Type.VAR_INT, 2));
        this.parserHandlers.put("minecraft:time", llllllllllllllIIlIIlIlllllIIIIll -> {
            llllllllllllllIIlIIlIlllllIIIIll.write(Type.BYTE, (Byte)1);
            llllllllllllllIIlIIlIlllllIIIIll.write(Type.INT, 0);
        });
    }
}
