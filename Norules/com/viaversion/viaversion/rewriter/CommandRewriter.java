package com.viaversion.viaversion.rewriter;

import com.viaversion.viaversion.api.protocol.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.protocol.packet.*;
import com.viaversion.viaversion.api.protocol.remapper.*;
import java.util.*;

public abstract class CommandRewriter
{
    protected final /* synthetic */ Map<String, CommandArgumentConsumer> parserHandlers;
    protected final /* synthetic */ Protocol protocol;
    
    public void handleArgument(final PacketWrapper lllllllllllllIlIIlIllIIIIIIIIIII, final String lllllllllllllIlIIlIlIllllllllIll) throws Exception {
        final CommandArgumentConsumer lllllllllllllIlIIlIlIllllllllllI = this.parserHandlers.get(lllllllllllllIlIIlIlIllllllllIll);
        if (lllllllllllllIlIIlIlIllllllllllI != null) {
            lllllllllllllIlIIlIlIllllllllllI.accept(lllllllllllllIlIIlIllIIIIIIIIIII);
        }
    }
    
    public void registerDeclareCommands(final ClientboundPacketType lllllllllllllIlIIlIlIlllllllIllI) {
        this.protocol.registerClientbound(lllllllllllllIlIIlIlIlllllllIllI, new PacketRemapper() {
            @Override
            public void registerMap() {
                int llllllllllllllllIIIllllllIIIlIIl;
                int llllllllllllllllIIIllllllIIIllII;
                byte llllllllllllllllIIIllllllIIIlllI;
                byte llllllllllllllllIIIllllllIIIllIl;
                String llllllllllllllllIIIllllllIIlIIII;
                String llllllllllllllllIIIllllllIIIllll;
                this.handler(llllllllllllllllIIIllllllIIIIlll -> {
                    for (llllllllllllllllIIIllllllIIIlIIl = llllllllllllllllIIIllllllIIIIlll.passthrough((Type<Integer>)Type.VAR_INT), llllllllllllllllIIIllllllIIIllII = 0; llllllllllllllllIIIllllllIIIllII < llllllllllllllllIIIllllllIIIlIIl; ++llllllllllllllllIIIllllllIIIllII) {
                        llllllllllllllllIIIllllllIIIlllI = llllllllllllllllIIIllllllIIIIlll.passthrough((Type<Byte>)Type.BYTE);
                        llllllllllllllllIIIllllllIIIIlll.passthrough(Type.VAR_INT_ARRAY_PRIMITIVE);
                        if ((llllllllllllllllIIIllllllIIIlllI & 0x8) != 0x0) {
                            llllllllllllllllIIIllllllIIIIlll.passthrough((Type<Object>)Type.VAR_INT);
                        }
                        llllllllllllllllIIIllllllIIIllIl = (byte)(llllllllllllllllIIIllllllIIIlllI & 0x3);
                        if (llllllllllllllllIIIllllllIIIllIl == 1 || llllllllllllllllIIIllllllIIIllIl == 2) {
                            llllllllllllllllIIIllllllIIIIlll.passthrough(Type.STRING);
                        }
                        if (llllllllllllllllIIIllllllIIIllIl == 2) {
                            llllllllllllllllIIIllllllIIlIIII = llllllllllllllllIIIllllllIIIIlll.read(Type.STRING);
                            llllllllllllllllIIIllllllIIIllll = CommandRewriter.this.handleArgumentType(llllllllllllllllIIIllllllIIlIIII);
                            if (llllllllllllllllIIIllllllIIIllll != null) {
                                llllllllllllllllIIIllllllIIIIlll.write(Type.STRING, llllllllllllllllIIIllllllIIIllll);
                            }
                            CommandRewriter.this.handleArgument(llllllllllllllllIIIllllllIIIIlll, llllllllllllllllIIIllllllIIlIIII);
                        }
                        if ((llllllllllllllllIIIllllllIIIlllI & 0x10) != 0x0) {
                            llllllllllllllllIIIllllllIIIIlll.passthrough(Type.STRING);
                        }
                    }
                    llllllllllllllllIIIllllllIIIIlll.passthrough((Type<Object>)Type.VAR_INT);
                });
            }
        });
    }
    
    protected CommandRewriter(final Protocol lllllllllllllIlIIlIllIIIIIIIlIII) {
        this.parserHandlers = new HashMap<String, CommandArgumentConsumer>();
        this.protocol = lllllllllllllIlIIlIllIIIIIIIlIII;
        final byte lllllllllllllIlIIlIlIlllllIlIIIl;
        this.parserHandlers.put("brigadier:double", lllllllllllllIlIIlIlIlllllIlIIII -> {
            lllllllllllllIlIIlIlIlllllIlIIIl = lllllllllllllIlIIlIlIlllllIlIIII.passthrough((Type<Byte>)Type.BYTE);
            if ((lllllllllllllIlIIlIlIlllllIlIIIl & 0x1) != 0x0) {
                lllllllllllllIlIIlIlIlllllIlIIII.passthrough((Type<Object>)Type.DOUBLE);
            }
            if ((lllllllllllllIlIIlIlIlllllIlIIIl & 0x2) != 0x0) {
                lllllllllllllIlIIlIlIlllllIlIIII.passthrough((Type<Object>)Type.DOUBLE);
            }
            return;
        });
        final byte lllllllllllllIlIIlIlIlllllIlIlll;
        this.parserHandlers.put("brigadier:float", lllllllllllllIlIIlIlIlllllIlIllI -> {
            lllllllllllllIlIIlIlIlllllIlIlll = lllllllllllllIlIIlIlIlllllIlIllI.passthrough((Type<Byte>)Type.BYTE);
            if ((lllllllllllllIlIIlIlIlllllIlIlll & 0x1) != 0x0) {
                lllllllllllllIlIIlIlIlllllIlIllI.passthrough((Type<Object>)Type.FLOAT);
            }
            if ((lllllllllllllIlIIlIlIlllllIlIlll & 0x2) != 0x0) {
                lllllllllllllIlIIlIlIlllllIlIllI.passthrough((Type<Object>)Type.FLOAT);
            }
            return;
        });
        final byte lllllllllllllIlIIlIlIlllllIlllIl;
        this.parserHandlers.put("brigadier:integer", lllllllllllllIlIIlIlIlllllIlllII -> {
            lllllllllllllIlIIlIlIlllllIlllIl = lllllllllllllIlIIlIlIlllllIlllII.passthrough((Type<Byte>)Type.BYTE);
            if ((lllllllllllllIlIIlIlIlllllIlllIl & 0x1) != 0x0) {
                lllllllllllllIlIIlIlIlllllIlllII.passthrough((Type<Object>)Type.INT);
            }
            if ((lllllllllllllIlIIlIlIlllllIlllIl & 0x2) != 0x0) {
                lllllllllllllIlIIlIlIlllllIlllII.passthrough((Type<Object>)Type.INT);
            }
            return;
        });
        final byte lllllllllllllIlIIlIlIllllllIIIll;
        this.parserHandlers.put("brigadier:long", lllllllllllllIlIIlIlIllllllIIlII -> {
            lllllllllllllIlIIlIlIllllllIIIll = lllllllllllllIlIIlIlIllllllIIlII.passthrough((Type<Byte>)Type.BYTE);
            if ((lllllllllllllIlIIlIlIllllllIIIll & 0x1) != 0x0) {
                lllllllllllllIlIIlIlIllllllIIlII.passthrough((Type<Object>)Type.LONG);
            }
            if ((lllllllllllllIlIIlIlIllllllIIIll & 0x2) != 0x0) {
                lllllllllllllIlIIlIlIllllllIIlII.passthrough((Type<Object>)Type.LONG);
            }
            return;
        });
        this.parserHandlers.put("brigadier:string", lllllllllllllIlIIlIlIllllllIlIII -> lllllllllllllIlIIlIlIllllllIlIII.passthrough((Type<Object>)Type.VAR_INT));
        this.parserHandlers.put("minecraft:entity", lllllllllllllIlIIlIlIllllllIlIlI -> lllllllllllllIlIIlIlIllllllIlIlI.passthrough((Type<Object>)Type.BYTE));
        this.parserHandlers.put("minecraft:score_holder", lllllllllllllIlIIlIlIllllllIllIl -> lllllllllllllIlIIlIlIllllllIllIl.passthrough((Type<Object>)Type.BYTE));
    }
    
    protected String handleArgumentType(final String lllllllllllllIlIIlIlIlllllllIIIl) {
        return lllllllllllllIlIIlIlIlllllllIIIl;
    }
    
    @FunctionalInterface
    public interface CommandArgumentConsumer
    {
        void accept(final PacketWrapper p0) throws Exception;
    }
}
