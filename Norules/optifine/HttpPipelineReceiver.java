package optifine;

import java.nio.charset.*;
import java.util.*;
import java.io.*;

public class HttpPipelineReceiver extends Thread
{
    private static final /* synthetic */ Charset ASCII;
    private /* synthetic */ HttpPipelineConnection httpPipelineConnection;
    
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            HttpPipelineRequest llllllllllllIlllllIIlIlIIlIlIIII = null;
            try {
                llllllllllllIlllllIIlIlIIlIlIIII = this.httpPipelineConnection.getNextRequestReceive();
                final InputStream llllllllllllIlllllIIlIlIIlIIllll = this.httpPipelineConnection.getInputStream();
                final HttpResponse llllllllllllIlllllIIlIlIIlIIlllI = this.readResponse(llllllllllllIlllllIIlIlIIlIIllll);
                this.httpPipelineConnection.onResponseReceived(llllllllllllIlllllIIlIlIIlIlIIII, llllllllllllIlllllIIlIlIIlIIlllI);
            }
            catch (InterruptedException llllllllllllIlllllIIlIlIIlIIllIl) {}
            catch (Exception llllllllllllIlllllIIlIlIIlIIllII) {
                this.httpPipelineConnection.onExceptionReceive(llllllllllllIlllllIIlIlIIlIlIIII, llllllllllllIlllllIIlIlIIlIIllII);
            }
        }
    }
    
    private HttpResponse readResponse(final InputStream llllllllllllIlllllIIlIlIIIlllIlI) throws IOException {
        final String llllllllllllIlllllIIlIlIIIlllIIl = this.readLine(llllllllllllIlllllIIlIlIIIlllIlI);
        final String[] llllllllllllIlllllIIlIlIIIlllIII = Config.tokenize(llllllllllllIlllllIIlIlIIIlllIIl, " ");
        if (llllllllllllIlllllIIlIlIIIlllIII.length < 3) {
            throw new IOException(String.valueOf(new StringBuilder("Invalid status line: ").append(llllllllllllIlllllIIlIlIIIlllIIl)));
        }
        final String llllllllllllIlllllIIlIlIIIllIlll = llllllllllllIlllllIIlIlIIIlllIII[0];
        final int llllllllllllIlllllIIlIlIIIllIllI = Config.parseInt(llllllllllllIlllllIIlIlIIIlllIII[1], 0);
        final String llllllllllllIlllllIIlIlIIIllIlIl = llllllllllllIlllllIIlIlIIIlllIII[2];
        final Map<String, String> llllllllllllIlllllIIlIlIIIllIlII = new LinkedHashMap<String, String>();
        while (true) {
            final String llllllllllllIlllllIIlIlIIIllIIll = this.readLine(llllllllllllIlllllIIlIlIIIlllIlI);
            if (llllllllllllIlllllIIlIlIIIllIIll.length() <= 0) {
                break;
            }
            final int llllllllllllIlllllIIlIlIIIlIlllI = llllllllllllIlllllIIlIlIIIllIIll.indexOf(":");
            if (llllllllllllIlllllIIlIlIIIlIlllI <= 0) {
                continue;
            }
            final String llllllllllllIlllllIIlIlIIIlIllIl = llllllllllllIlllllIIlIlIIIllIIll.substring(0, llllllllllllIlllllIIlIlIIIlIlllI).trim();
            final String llllllllllllIlllllIIlIlIIIlIllII = llllllllllllIlllllIIlIlIIIllIIll.substring(llllllllllllIlllllIIlIlIIIlIlllI + 1).trim();
            llllllllllllIlllllIIlIlIIIllIlII.put(llllllllllllIlllllIIlIlIIIlIllIl, llllllllllllIlllllIIlIlIIIlIllII);
        }
        byte[] llllllllllllIlllllIIlIlIIIllIIlI = null;
        final String llllllllllllIlllllIIlIlIIIllIIIl = llllllllllllIlllllIIlIlIIIllIlII.get("Content-Length");
        if (llllllllllllIlllllIIlIlIIIllIIIl != null) {
            final int llllllllllllIlllllIIlIlIIIllIIII = Config.parseInt(llllllllllllIlllllIIlIlIIIllIIIl, -1);
            if (llllllllllllIlllllIIlIlIIIllIIII > 0) {
                llllllllllllIlllllIIlIlIIIllIIlI = new byte[llllllllllllIlllllIIlIlIIIllIIII];
                this.readFull(llllllllllllIlllllIIlIlIIIllIIlI, llllllllllllIlllllIIlIlIIIlllIlI);
            }
        }
        else {
            final String llllllllllllIlllllIIlIlIIIlIllll = llllllllllllIlllllIIlIlIIIllIlII.get("Transfer-Encoding");
            if (Config.equals(llllllllllllIlllllIIlIlIIIlIllll, "chunked")) {
                llllllllllllIlllllIIlIlIIIllIIlI = this.readContentChunked(llllllllllllIlllllIIlIlIIIlllIlI);
            }
        }
        return new HttpResponse(llllllllllllIlllllIIlIlIIIllIllI, llllllllllllIlllllIIlIlIIIlllIIl, llllllllllllIlllllIIlIlIIIllIlII, llllllllllllIlllllIIlIlIIIllIIlI);
    }
    
    public HttpPipelineReceiver(final HttpPipelineConnection llllllllllllIlllllIIlIlIIlIlIllI) {
        super("HttpPipelineReceiver");
        this.httpPipelineConnection = null;
        this.httpPipelineConnection = llllllllllllIlllllIIlIlIIlIlIllI;
    }
    
    private byte[] readContentChunked(final InputStream llllllllllllIlllllIIlIlIIIIlIIII) throws IOException {
        final ByteArrayOutputStream llllllllllllIlllllIIlIlIIIIlIllI = new ByteArrayOutputStream();
        int llllllllllllIlllllIIlIlIIIIlIIll;
        do {
            final String llllllllllllIlllllIIlIlIIIIlIlIl = this.readLine(llllllllllllIlllllIIlIlIIIIlIIII);
            final String[] llllllllllllIlllllIIlIlIIIIlIlII = Config.tokenize(llllllllllllIlllllIIlIlIIIIlIlIl, "; ");
            llllllllllllIlllllIIlIlIIIIlIIll = Integer.parseInt(llllllllllllIlllllIIlIlIIIIlIlII[0], 16);
            final byte[] llllllllllllIlllllIIlIlIIIIlIIlI = new byte[llllllllllllIlllllIIlIlIIIIlIIll];
            this.readFull(llllllllllllIlllllIIlIlIIIIlIIlI, llllllllllllIlllllIIlIlIIIIlIIII);
            llllllllllllIlllllIIlIlIIIIlIllI.write(llllllllllllIlllllIIlIlIIIIlIIlI);
            this.readLine(llllllllllllIlllllIIlIlIIIIlIIII);
        } while (llllllllllllIlllllIIlIlIIIIlIIll != 0);
        return llllllllllllIlllllIIlIlIIIIlIllI.toByteArray();
    }
    
    private void readFull(final byte[] llllllllllllIlllllIIlIlIIIIIIlIl, final InputStream llllllllllllIlllllIIlIlIIIIIIlII) throws IOException {
        int llllllllllllIlllllIIlIlIIIIIIIll;
        for (int llllllllllllIlllllIIlIlIIIIIIIlI = 0; llllllllllllIlllllIIlIlIIIIIIIlI < llllllllllllIlllllIIlIlIIIIIIlIl.length; llllllllllllIlllllIIlIlIIIIIIIlI += llllllllllllIlllllIIlIlIIIIIIIll) {
            llllllllllllIlllllIIlIlIIIIIIIll = llllllllllllIlllllIIlIlIIIIIIlII.read(llllllllllllIlllllIIlIlIIIIIIlIl, llllllllllllIlllllIIlIlIIIIIIIlI, llllllllllllIlllllIIlIlIIIIIIlIl.length - llllllllllllIlllllIIlIlIIIIIIIlI);
            if (llllllllllllIlllllIIlIlIIIIIIIll < 0) {
                throw new EOFException();
            }
        }
    }
    
    static {
        HEADER_CONTENT_LENGTH = "Content-Length";
        CR = '\r';
        LF = '\n';
        ASCII = Charset.forName("ASCII");
    }
    
    private String readLine(final InputStream llllllllllllIlllllIIlIIllllIllll) throws IOException {
        final ByteArrayOutputStream llllllllllllIlllllIIlIIlllllIlIl = new ByteArrayOutputStream();
        int llllllllllllIlllllIIlIIlllllIlII = -1;
        boolean llllllllllllIlllllIIlIIlllllIIll = false;
        while (true) {
            final int llllllllllllIlllllIIlIIlllllIIlI = llllllllllllIlllllIIlIIllllIllll.read();
            if (llllllllllllIlllllIIlIIlllllIIlI < 0) {
                break;
            }
            llllllllllllIlllllIIlIIlllllIlIl.write(llllllllllllIlllllIIlIIlllllIIlI);
            if (llllllllllllIlllllIIlIIlllllIlII == 13 && llllllllllllIlllllIIlIIlllllIIlI == 10) {
                llllllllllllIlllllIIlIIlllllIIll = true;
                break;
            }
            llllllllllllIlllllIIlIIlllllIlII = llllllllllllIlllllIIlIIlllllIIlI;
        }
        final byte[] llllllllllllIlllllIIlIIlllllIIIl = llllllllllllIlllllIIlIIlllllIlIl.toByteArray();
        String llllllllllllIlllllIIlIIlllllIIII = new String(llllllllllllIlllllIIlIIlllllIIIl, HttpPipelineReceiver.ASCII);
        if (llllllllllllIlllllIIlIIlllllIIll) {
            llllllllllllIlllllIIlIIlllllIIII = llllllllllllIlllllIIlIIlllllIIII.substring(0, llllllllllllIlllllIIlIIlllllIIII.length() - 2);
        }
        return llllllllllllIlllllIIlIIlllllIIII;
    }
}
