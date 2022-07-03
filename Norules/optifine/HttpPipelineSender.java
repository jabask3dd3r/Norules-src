package optifine;

import java.nio.charset.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class HttpPipelineSender extends Thread
{
    private /* synthetic */ HttpPipelineConnection httpPipelineConnection;
    private static /* synthetic */ Charset ASCII;
    
    private void write(final OutputStream llllllllllllllIlIIlIllIIIlIlllll, final String llllllllllllllIlIIlIllIIIlIllIll) throws IOException {
        final byte[] llllllllllllllIlIIlIllIIIlIlllIl = llllllllllllllIlIIlIllIIIlIllIll.getBytes(HttpPipelineSender.ASCII);
        llllllllllllllIlIIlIllIIIlIlllll.write(llllllllllllllIlIIlIllIIIlIlllIl);
    }
    
    static {
        CRLF = "\r\n";
        HttpPipelineSender.ASCII = Charset.forName("ASCII");
    }
    
    private void writeRequest(final HttpRequest llllllllllllllIlIIlIllIIIllIlIIl, final OutputStream llllllllllllllIlIIlIllIIIllIlIII) throws IOException {
        this.write(llllllllllllllIlIIlIllIIIllIlIII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIlIllIIIllIlIIl.getMethod())).append(" ").append(llllllllllllllIlIIlIllIIIllIlIIl.getFile()).append(" ").append(llllllllllllllIlIIlIllIIIllIlIIl.getHttp()).append("\r\n")));
        final Map<String, String> llllllllllllllIlIIlIllIIIllIllIl = llllllllllllllIlIIlIllIIIllIlIIl.getHeaders();
        for (final String llllllllllllllIlIIlIllIIIllIllII : llllllllllllllIlIIlIllIIIllIllIl.keySet()) {
            final String llllllllllllllIlIIlIllIIIllIlIll = llllllllllllllIlIIlIllIIIllIlIIl.getHeaders().get(llllllllllllllIlIIlIllIIIllIllII);
            this.write(llllllllllllllIlIIlIllIIIllIlIII, String.valueOf(new StringBuilder(String.valueOf(llllllllllllllIlIIlIllIIIllIllII)).append(": ").append(llllllllllllllIlIIlIllIIIllIlIll).append("\r\n")));
        }
        this.write(llllllllllllllIlIIlIllIIIllIlIII, "\r\n");
    }
    
    private void connect() throws IOException {
        final String llllllllllllllIlIIlIllIIlIIIIIII = this.httpPipelineConnection.getHost();
        final int llllllllllllllIlIIlIllIIIlllllll = this.httpPipelineConnection.getPort();
        final Proxy llllllllllllllIlIIlIllIIIllllllI = this.httpPipelineConnection.getProxy();
        final Socket llllllllllllllIlIIlIllIIIlllllIl = new Socket(llllllllllllllIlIIlIllIIIllllllI);
        llllllllllllllIlIIlIllIIIlllllIl.connect(new InetSocketAddress(llllllllllllllIlIIlIllIIlIIIIIII, llllllllllllllIlIIlIllIIIlllllll), 5000);
        this.httpPipelineConnection.setSocket(llllllllllllllIlIIlIllIIIlllllIl);
    }
    
    public HttpPipelineSender(final HttpPipelineConnection llllllllllllllIlIIlIllIIlIIlIlll) {
        super("HttpPipelineSender");
        this.httpPipelineConnection = null;
        this.httpPipelineConnection = llllllllllllllIlIIlIllIIlIIlIlll;
    }
    
    @Override
    public void run() {
        HttpPipelineRequest llllllllllllllIlIIlIllIIlIIIllll = null;
        try {
            this.connect();
            while (!Thread.interrupted()) {
                llllllllllllllIlIIlIllIIlIIIllll = this.httpPipelineConnection.getNextRequestSend();
                final HttpRequest llllllllllllllIlIIlIllIIlIIIlllI = llllllllllllllIlIIlIllIIlIIIllll.getHttpRequest();
                final OutputStream llllllllllllllIlIIlIllIIlIIIllIl = this.httpPipelineConnection.getOutputStream();
                this.writeRequest(llllllllllllllIlIIlIllIIlIIIlllI, llllllllllllllIlIIlIllIIlIIIllIl);
                this.httpPipelineConnection.onRequestSent(llllllllllllllIlIIlIllIIlIIIllll);
            }
        }
        catch (InterruptedException llllllllllllllIlIIlIllIIlIIIllII) {}
        catch (Exception llllllllllllllIlIIlIllIIlIIIlIll) {
            this.httpPipelineConnection.onExceptionSend(llllllllllllllIlIIlIllIIlIIIllll, llllllllllllllIlIIlIllIIlIIIlIll);
        }
    }
}
