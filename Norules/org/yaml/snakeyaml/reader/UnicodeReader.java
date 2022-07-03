package org.yaml.snakeyaml.reader;

import java.nio.charset.*;
import java.io.*;

public class UnicodeReader extends Reader
{
    private static final /* synthetic */ Charset UTF8;
    private static final /* synthetic */ Charset UTF16BE;
    /* synthetic */ PushbackInputStream internalIn;
    /* synthetic */ InputStreamReader internalIn2;
    private static final /* synthetic */ Charset UTF16LE;
    
    public String getEncoding() {
        return this.internalIn2.getEncoding();
    }
    
    protected void init() throws IOException {
        if (this.internalIn2 != null) {
            return;
        }
        final byte[] lllllllllllllIIlIlIIIIlIIlllIlII = new byte[3];
        final int lllllllllllllIIlIlIIIIlIIlllIIll = this.internalIn.read(lllllllllllllIIlIlIIIIlIIlllIlII, 0, lllllllllllllIIlIlIIIIlIIlllIlII.length);
        Charset lllllllllllllIIlIlIIIIlIIlllIlIl = null;
        int lllllllllllllIIlIlIIIIlIIlllIIlI = 0;
        if (lllllllllllllIIlIlIIIIlIIlllIlII[0] == -17 && lllllllllllllIIlIlIIIIlIIlllIlII[1] == -69 && lllllllllllllIIlIlIIIIlIIlllIlII[2] == -65) {
            final Charset lllllllllllllIIlIlIIIIlIIlllllII = UnicodeReader.UTF8;
            final int lllllllllllllIIlIlIIIIlIIllllIll = lllllllllllllIIlIlIIIIlIIlllIIll - 3;
        }
        else if (lllllllllllllIIlIlIIIIlIIlllIlII[0] == -2 && lllllllllllllIIlIlIIIIlIIlllIlII[1] == -1) {
            final Charset lllllllllllllIIlIlIIIIlIIllllIlI = UnicodeReader.UTF16BE;
            final int lllllllllllllIIlIlIIIIlIIllllIIl = lllllllllllllIIlIlIIIIlIIlllIIll - 2;
        }
        else if (lllllllllllllIIlIlIIIIlIIlllIlII[0] == -1 && lllllllllllllIIlIlIIIIlIIlllIlII[1] == -2) {
            final Charset lllllllllllllIIlIlIIIIlIIllllIII = UnicodeReader.UTF16LE;
            final int lllllllllllllIIlIlIIIIlIIlllIlll = lllllllllllllIIlIlIIIIlIIlllIIll - 2;
        }
        else {
            lllllllllllllIIlIlIIIIlIIlllIlIl = UnicodeReader.UTF8;
            lllllllllllllIIlIlIIIIlIIlllIIlI = lllllllllllllIIlIlIIIIlIIlllIIll;
        }
        if (lllllllllllllIIlIlIIIIlIIlllIIlI > 0) {
            this.internalIn.unread(lllllllllllllIIlIlIIIIlIIlllIlII, lllllllllllllIIlIlIIIIlIIlllIIll - lllllllllllllIIlIlIIIIlIIlllIIlI, lllllllllllllIIlIlIIIIlIIlllIIlI);
        }
        final CharsetDecoder lllllllllllllIIlIlIIIIlIIlllIIIl = lllllllllllllIIlIlIIIIlIIlllIlIl.newDecoder().onUnmappableCharacter(CodingErrorAction.REPORT);
        this.internalIn2 = new InputStreamReader(this.internalIn, lllllllllllllIIlIlIIIIlIIlllIIIl);
    }
    
    @Override
    public void close() throws IOException {
        this.init();
        this.internalIn2.close();
    }
    
    @Override
    public int read(final char[] lllllllllllllIIlIlIIIIlIIllIIIlI, final int lllllllllllllIIlIlIIIIlIIllIIIIl, final int lllllllllllllIIlIlIIIIlIIllIIIII) throws IOException {
        this.init();
        return this.internalIn2.read(lllllllllllllIIlIlIIIIlIIllIIIlI, lllllllllllllIIlIlIIIIlIIllIIIIl, lllllllllllllIIlIlIIIIlIIllIIIII);
    }
    
    static {
        BOM_SIZE = 3;
        UTF8 = Charset.forName("UTF-8");
        UTF16BE = Charset.forName("UTF-16BE");
        UTF16LE = Charset.forName("UTF-16LE");
    }
    
    public UnicodeReader(final InputStream lllllllllllllIIlIlIIIIlIlIIIIllI) {
        this.internalIn2 = null;
        this.internalIn = new PushbackInputStream(lllllllllllllIIlIlIIIIlIlIIIIllI, 3);
    }
}
