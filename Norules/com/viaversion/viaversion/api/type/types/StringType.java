package com.viaversion.viaversion.api.type.types;

import com.viaversion.viaversion.api.type.*;
import io.netty.buffer.*;
import com.google.common.base.*;
import java.nio.charset.*;

public class StringType extends Type<String>
{
    private final /* synthetic */ int maxLength;
    private static final /* synthetic */ int maxJavaCharUtf8Length;
    
    public StringType() {
        this(32767);
    }
    
    public StringType(final int lllllllllllllllllIIlllIllIlIllIl) {
        super(String.class);
        this.maxLength = lllllllllllllllllIIlllIllIlIllIl;
    }
    
    @Override
    public void write(final ByteBuf lllllllllllllllllIIlllIllIIlIlIl, final String lllllllllllllllllIIlllIllIIllIII) throws Exception {
        Preconditions.checkArgument(lllllllllllllllllIIlllIllIIllIII.length() <= this.maxLength, "Cannot send string longer than Short.MAX_VALUE (got %s characters)", new Object[] { lllllllllllllllllIIlllIllIIllIII.length() });
        final byte[] lllllllllllllllllIIlllIllIIlIlll = lllllllllllllllllIIlllIllIIllIII.getBytes(StandardCharsets.UTF_8);
        Type.VAR_INT.writePrimitive(lllllllllllllllllIIlllIllIIlIlIl, lllllllllllllllllIIlllIllIIlIlll.length);
        lllllllllllllllllIIlllIllIIlIlIl.writeBytes(lllllllllllllllllIIlllIllIIlIlll);
    }
    
    static {
        maxJavaCharUtf8Length = Character.toString('\uffff').getBytes(StandardCharsets.UTF_8).length;
    }
    
    @Override
    public String read(final ByteBuf lllllllllllllllllIIlllIllIlIIIIl) throws Exception {
        final int lllllllllllllllllIIlllIllIlIIlII = Type.VAR_INT.readPrimitive(lllllllllllllllllIIlllIllIlIIIIl);
        Preconditions.checkArgument(lllllllllllllllllIIlllIllIlIIlII <= this.maxLength * StringType.maxJavaCharUtf8Length, String.valueOf(new StringBuilder().append("Cannot receive string longer than Short.MAX_VALUE * ").append(StringType.maxJavaCharUtf8Length).append(" bytes (got %s bytes)")), new Object[] { lllllllllllllllllIIlllIllIlIIlII });
        final String lllllllllllllllllIIlllIllIlIIIll = lllllllllllllllllIIlllIllIlIIIIl.toString(lllllllllllllllllIIlllIllIlIIIIl.readerIndex(), lllllllllllllllllIIlllIllIlIIlII, StandardCharsets.UTF_8);
        lllllllllllllllllIIlllIllIlIIIIl.skipBytes(lllllllllllllllllIIlllIllIlIIlII);
        Preconditions.checkArgument(lllllllllllllllllIIlllIllIlIIIll.length() <= this.maxLength, "Cannot receive string longer than Short.MAX_VALUE characters (got %s bytes)", new Object[] { lllllllllllllllllIIlllIllIlIIIll.length() });
        return lllllllllllllllllIIlllIllIlIIIll;
    }
}
