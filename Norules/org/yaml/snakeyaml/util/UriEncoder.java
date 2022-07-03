package org.yaml.snakeyaml.util;

import java.net.*;
import org.yaml.snakeyaml.error.*;
import java.io.*;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.*;
import java.nio.*;
import java.nio.charset.*;

public abstract class UriEncoder
{
    private static final /* synthetic */ CharsetDecoder UTF8Decoder;
    private static final /* synthetic */ Escaper escaper;
    
    public static String decode(final String llllllllllllllIIllIIIlIlllllIlIl) {
        try {
            return URLDecoder.decode(llllllllllllllIIllIIIlIlllllIlIl, "UTF-8");
        }
        catch (UnsupportedEncodingException llllllllllllllIIllIIIlIlllllIlll) {
            throw new YAMLException(llllllllllllllIIllIIIlIlllllIlll);
        }
    }
    
    public static String encode(final String llllllllllllllIIllIIIllIIIIIIIII) {
        return UriEncoder.escaper.escape(llllllllllllllIIllIIIllIIIIIIIII);
    }
    
    static {
        SAFE_CHARS = "-_.!~*'()@:$&,;=[]/";
        UTF8Decoder = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT);
        escaper = new PercentEscaper("-_.!~*'()@:$&,;=[]/", false);
    }
    
    public static String decode(final ByteBuffer llllllllllllllIIllIIIlIlllllllIl) throws CharacterCodingException {
        final CharBuffer llllllllllllllIIllIIIlIlllllllII = UriEncoder.UTF8Decoder.decode(llllllllllllllIIllIIIlIlllllllIl);
        return llllllllllllllIIllIIIlIlllllllII.toString();
    }
}
