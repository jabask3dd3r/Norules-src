package optifine;

import java.net.*;
import java.util.regex.*;
import java.io.*;
import java.util.*;

public class HttpPipelineConnection
{
    private /* synthetic */ long timeLastActivityMs;
    private /* synthetic */ List<HttpPipelineRequest> listRequestsSend;
    private /* synthetic */ int countRequests;
    private /* synthetic */ boolean responseReceived;
    private /* synthetic */ int keepaliveMaxCount;
    private /* synthetic */ Socket socket;
    private /* synthetic */ Proxy proxy;
    private /* synthetic */ int port;
    private /* synthetic */ OutputStream outputStream;
    private /* synthetic */ String host;
    private /* synthetic */ InputStream inputStream;
    private /* synthetic */ List<HttpPipelineRequest> listRequests;
    private /* synthetic */ HttpPipelineSender httpPipelineSender;
    private static final /* synthetic */ Pattern patternFullUrl;
    private /* synthetic */ long keepaliveTimeoutMs;
    private /* synthetic */ boolean terminated;
    private /* synthetic */ HttpPipelineReceiver httpPipelineReceiver;
    
    private void checkTimeout() {
        if (this.socket != null) {
            long lllllllllllllIIlllllllIlIllllIII = this.keepaliveTimeoutMs;
            if (this.listRequests.size() > 0) {
                lllllllllllllIIlllllllIlIllllIII = 5000L;
            }
            final long lllllllllllllIIlllllllIlIlllIlll = System.currentTimeMillis();
            if (lllllllllllllIIlllllllIlIlllIlll > this.timeLastActivityMs + lllllllllllllIIlllllllIlIllllIII) {
                this.terminate(new InterruptedException(String.valueOf(new StringBuilder("Timeout ").append(lllllllllllllIIlllllllIlIllllIII))));
            }
        }
    }
    
    private synchronized void terminate(final Exception lllllllllllllIIlllllllIlIIIIlIII) {
        if (!this.terminated) {
            this.terminated = true;
            this.terminateRequests(lllllllllllllIIlllllllIlIIIIlIII);
            if (this.httpPipelineSender != null) {
                this.httpPipelineSender.interrupt();
            }
            if (this.httpPipelineReceiver != null) {
                this.httpPipelineReceiver.interrupt();
            }
            try {
                if (this.socket != null) {
                    this.socket.close();
                }
            }
            catch (IOException ex) {}
            this.socket = null;
            this.inputStream = null;
            this.outputStream = null;
        }
    }
    
    public synchronized HttpPipelineRequest getNextRequestReceive() throws InterruptedException {
        return this.getNextRequest(this.listRequests, false);
    }
    
    private void checkResponseHeader(final HttpResponse lllllllllllllIIlllllllIlIIllIlII) {
        final String lllllllllllllIIlllllllIlIIllllIl = lllllllllllllIIlllllllIlIIllIlII.getHeader("Connection");
        if (lllllllllllllIIlllllllIlIIllllIl != null && !lllllllllllllIIlllllllIlIIllllIl.toLowerCase().equals("keep-alive")) {
            this.terminate(new EOFException("Connection not keep-alive"));
        }
        final String lllllllllllllIIlllllllIlIIllllII = lllllllllllllIIlllllllIlIIllIlII.getHeader("Keep-Alive");
        if (lllllllllllllIIlllllllIlIIllllII != null) {
            final String[] lllllllllllllIIlllllllIlIIlllIll = Config.tokenize(lllllllllllllIIlllllllIlIIllllII, ",;");
            for (int lllllllllllllIIlllllllIlIIlllIlI = 0; lllllllllllllIIlllllllIlIIlllIlI < lllllllllllllIIlllllllIlIIlllIll.length; ++lllllllllllllIIlllllllIlIIlllIlI) {
                final String lllllllllllllIIlllllllIlIIlllIIl = lllllllllllllIIlllllllIlIIlllIll[lllllllllllllIIlllllllIlIIlllIlI];
                final String[] lllllllllllllIIlllllllIlIIlllIII = this.split(lllllllllllllIIlllllllIlIIlllIIl, '=');
                if (lllllllllllllIIlllllllIlIIlllIII.length >= 2) {
                    if (lllllllllllllIIlllllllIlIIlllIII[0].equals("timeout")) {
                        final int lllllllllllllIIlllllllIlIIllIlll = Config.parseInt(lllllllllllllIIlllllllIlIIlllIII[1], -1);
                        if (lllllllllllllIIlllllllIlIIllIlll > 0) {
                            this.keepaliveTimeoutMs = lllllllllllllIIlllllllIlIIllIlll * 1000;
                        }
                    }
                    if (lllllllllllllIIlllllllIlIIlllIII[0].equals("max")) {
                        final int lllllllllllllIIlllllllIlIIllIllI = Config.parseInt(lllllllllllllIIlllllllIlIIlllIII[1], -1);
                        if (lllllllllllllIIlllllllIlIIllIllI > 0) {
                            this.keepaliveMaxCount = lllllllllllllIIlllllllIlIIllIllI;
                        }
                    }
                }
            }
        }
    }
    
    private String normalizeUrl(final String lllllllllllllIIlllllllIlIlIlIIlI, final HttpRequest lllllllllllllIIlllllllIlIlIIllII) {
        if (HttpPipelineConnection.patternFullUrl.matcher(lllllllllllllIIlllllllIlIlIlIIlI).matches()) {
            return lllllllllllllIIlllllllIlIlIlIIlI;
        }
        if (lllllllllllllIIlllllllIlIlIlIIlI.startsWith("//")) {
            return String.valueOf(new StringBuilder("http:").append(lllllllllllllIIlllllllIlIlIlIIlI));
        }
        String lllllllllllllIIlllllllIlIlIlIIII = lllllllllllllIIlllllllIlIlIIllII.getHost();
        if (lllllllllllllIIlllllllIlIlIIllII.getPort() != 80) {
            lllllllllllllIIlllllllIlIlIlIIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlllllllIlIlIlIIII)).append(":").append(lllllllllllllIIlllllllIlIlIIllII.getPort()));
        }
        if (lllllllllllllIIlllllllIlIlIlIIlI.startsWith("/")) {
            return String.valueOf(new StringBuilder("http://").append(lllllllllllllIIlllllllIlIlIlIIII).append(lllllllllllllIIlllllllIlIlIlIIlI));
        }
        final String lllllllllllllIIlllllllIlIlIIllll = lllllllllllllIIlllllllIlIlIIllII.getFile();
        final int lllllllllllllIIlllllllIlIlIIlllI = lllllllllllllIIlllllllIlIlIIllll.lastIndexOf("/");
        return (lllllllllllllIIlllllllIlIlIIlllI >= 0) ? String.valueOf(new StringBuilder("http://").append(lllllllllllllIIlllllllIlIlIlIIII).append(lllllllllllllIIlllllllIlIlIIllll.substring(0, lllllllllllllIIlllllllIlIlIIlllI + 1)).append(lllllllllllllIIlllllllIlIlIlIIlI)) : String.valueOf(new StringBuilder("http://").append(lllllllllllllIIlllllllIlIlIlIIII).append("/").append(lllllllllllllIIlllllllIlIlIlIIlI));
    }
    
    public synchronized boolean addRequest(final HttpPipelineRequest lllllllllllllIIlllllllIllIlIIIll) {
        if (this.isClosed()) {
            return false;
        }
        this.addRequest(lllllllllllllIIlllllllIllIlIIIll, this.listRequests);
        this.addRequest(lllllllllllllIIlllllllIllIlIIIll, this.listRequestsSend);
        ++this.countRequests;
        return true;
    }
    
    public synchronized InputStream getInputStream() throws IOException, InterruptedException {
        while (this.inputStream == null) {
            this.checkTimeout();
            this.wait(1000L);
        }
        return this.inputStream;
    }
    
    public synchronized boolean isClosed() {
        return this.terminated || this.countRequests >= this.keepaliveMaxCount;
    }
    
    static {
        LF = "\n";
        TIMEOUT_READ_MS = 5000;
        TIMEOUT_CONNECT_MS = 5000;
        patternFullUrl = Pattern.compile("^[a-zA-Z]+://.*");
    }
    
    private void terminateRequests(final Exception lllllllllllllIIlllllllIIlllllllI) {
        if (this.listRequests.size() > 0) {
            if (!this.responseReceived) {
                final HttpPipelineRequest lllllllllllllIIlllllllIlIIIIIIIl = this.listRequests.remove(0);
                lllllllllllllIIlllllllIlIIIIIIIl.getHttpListener().failed(lllllllllllllIIlllllllIlIIIIIIIl.getHttpRequest(), lllllllllllllIIlllllllIIlllllllI);
                lllllllllllllIIlllllllIlIIIIIIIl.setClosed(true);
            }
            while (this.listRequests.size() > 0) {
                final HttpPipelineRequest lllllllllllllIIlllllllIlIIIIIIII = this.listRequests.remove(0);
                HttpPipeline.addRequest(lllllllllllllIIlllllllIlIIIIIIII);
            }
        }
    }
    
    private String[] split(final String lllllllllllllIIlllllllIlIIlIIIIl, final char lllllllllllllIIlllllllIlIIlIIIII) {
        final int lllllllllllllIIlllllllIlIIlIIlII = lllllllllllllIIlllllllIlIIlIIIIl.indexOf(lllllllllllllIIlllllllIlIIlIIIII);
        if (lllllllllllllIIlllllllIlIIlIIlII < 0) {
            return new String[] { lllllllllllllIIlllllllIlIIlIIIIl };
        }
        final String lllllllllllllIIlllllllIlIIlIIIll = lllllllllllllIIlllllllIlIIlIIIIl.substring(0, lllllllllllllIIlllllllIlIIlIIlII);
        final String lllllllllllllIIlllllllIlIIlIIIlI = lllllllllllllIIlllllllIlIIlIIIIl.substring(lllllllllllllIIlllllllIlIIlIIlII + 1);
        return new String[] { lllllllllllllIIlllllllIlIIlIIIll, lllllllllllllIIlllllllIlIIlIIIlI };
    }
    
    public String getHost() {
        return this.host;
    }
    
    private HttpPipelineRequest getNextRequest(final List<HttpPipelineRequest> lllllllllllllIIlllllllIllIIIIIIl, final boolean lllllllllllllIIlllllllIlIlllllIl) throws InterruptedException {
        while (lllllllllllllIIlllllllIllIIIIIIl.size() <= 0) {
            this.checkTimeout();
            this.wait(1000L);
        }
        this.onActivity();
        if (lllllllllllllIIlllllllIlIlllllIl) {
            return lllllllllllllIIlllllllIllIIIIIIl.remove(0);
        }
        return lllllllllllllIIlllllllIllIIIIIIl.get(0);
    }
    
    public synchronized OutputStream getOutputStream() throws InterruptedException, IOException {
        while (this.outputStream == null) {
            this.checkTimeout();
            this.wait(1000L);
        }
        return this.outputStream;
    }
    
    public synchronized void setSocket(final Socket lllllllllllllIIlllllllIllIIlIlII) throws IOException {
        if (!this.terminated) {
            if (this.socket != null) {
                throw new IllegalArgumentException("Already connected");
            }
            this.socket = lllllllllllllIIlllllllIllIIlIlII;
            this.socket.setTcpNoDelay(true);
            this.inputStream = this.socket.getInputStream();
            this.outputStream = new BufferedOutputStream(this.socket.getOutputStream());
            this.onActivity();
            this.notifyAll();
        }
    }
    
    public HttpPipelineConnection(final String lllllllllllllIIlllllllIllIlIlIIl, final int lllllllllllllIIlllllllIllIlIllII, final Proxy lllllllllllllIIlllllllIllIlIlIll) {
        this.host = null;
        this.port = 0;
        this.proxy = Proxy.NO_PROXY;
        this.listRequests = new LinkedList<HttpPipelineRequest>();
        this.listRequestsSend = new LinkedList<HttpPipelineRequest>();
        this.socket = null;
        this.inputStream = null;
        this.outputStream = null;
        this.httpPipelineSender = null;
        this.httpPipelineReceiver = null;
        this.countRequests = 0;
        this.responseReceived = false;
        this.keepaliveTimeoutMs = 5000L;
        this.keepaliveMaxCount = 1000;
        this.timeLastActivityMs = System.currentTimeMillis();
        this.terminated = false;
        this.host = lllllllllllllIIlllllllIllIlIlIIl;
        this.port = lllllllllllllIIlllllllIllIlIllII;
        this.proxy = lllllllllllllIIlllllllIllIlIlIll;
        this.httpPipelineSender = new HttpPipelineSender(this);
        this.httpPipelineSender.start();
        this.httpPipelineReceiver = new HttpPipelineReceiver(this);
        this.httpPipelineReceiver.start();
    }
    
    public synchronized void onExceptionSend(final HttpPipelineRequest lllllllllllllIIlllllllIlIIIllIIl, final Exception lllllllllllllIIlllllllIlIIIlIllI) {
        this.terminate(lllllllllllllIIlllllllIlIIIlIllI);
    }
    
    public synchronized void onRequestSent(final HttpPipelineRequest lllllllllllllIIlllllllIlIllIlllI) {
        if (!this.terminated) {
            this.onActivity();
        }
    }
    
    private void addRequest(final HttpPipelineRequest lllllllllllllIIlllllllIllIIlllII, final List<HttpPipelineRequest> lllllllllllllIIlllllllIllIIllIII) {
        lllllllllllllIIlllllllIllIIllIII.add(lllllllllllllIIlllllllIllIIlllII);
        this.notifyAll();
    }
    
    public int getPort() {
        return this.port;
    }
    
    public synchronized HttpPipelineRequest getNextRequestSend() throws InterruptedException, IOException {
        if (this.listRequestsSend.size() <= 0 && this.outputStream != null) {
            this.outputStream.flush();
        }
        return this.getNextRequest(this.listRequestsSend, true);
    }
    
    public synchronized void onResponseReceived(final HttpPipelineRequest lllllllllllllIIlllllllIlIlIlllIl, final HttpResponse lllllllllllllIIlllllllIlIllIIlII) {
        if (!this.terminated) {
            this.responseReceived = true;
            this.onActivity();
            if (this.listRequests.size() <= 0 || this.listRequests.get(0) != lllllllllllllIIlllllllIlIlIlllIl) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder("Response out of order: ").append(lllllllllllllIIlllllllIlIlIlllIl)));
            }
            this.listRequests.remove(0);
            lllllllllllllIIlllllllIlIlIlllIl.setClosed(true);
            String lllllllllllllIIlllllllIlIllIIIll = lllllllllllllIIlllllllIlIllIIlII.getHeader("Location");
            if (lllllllllllllIIlllllllIlIllIIlII.getStatus() / 100 == 3 && lllllllllllllIIlllllllIlIllIIIll != null && lllllllllllllIIlllllllIlIlIlllIl.getHttpRequest().getRedirects() < 5) {
                try {
                    lllllllllllllIIlllllllIlIllIIIll = this.normalizeUrl(lllllllllllllIIlllllllIlIllIIIll, lllllllllllllIIlllllllIlIlIlllIl.getHttpRequest());
                    final HttpRequest lllllllllllllIIlllllllIlIllIIIlI = HttpPipeline.makeRequest(lllllllllllllIIlllllllIlIllIIIll, lllllllllllllIIlllllllIlIlIlllIl.getHttpRequest().getProxy());
                    lllllllllllllIIlllllllIlIllIIIlI.setRedirects(lllllllllllllIIlllllllIlIlIlllIl.getHttpRequest().getRedirects() + 1);
                    final HttpPipelineRequest lllllllllllllIIlllllllIlIllIIIIl = new HttpPipelineRequest(lllllllllllllIIlllllllIlIllIIIlI, lllllllllllllIIlllllllIlIlIlllIl.getHttpListener());
                    HttpPipeline.addRequest(lllllllllllllIIlllllllIlIllIIIIl);
                }
                catch (IOException lllllllllllllIIlllllllIlIllIIIII) {
                    lllllllllllllIIlllllllIlIlIlllIl.getHttpListener().failed(lllllllllllllIIlllllllIlIlIlllIl.getHttpRequest(), lllllllllllllIIlllllllIlIllIIIII);
                }
            }
            else {
                final HttpListener lllllllllllllIIlllllllIlIlIlllll = lllllllllllllIIlllllllIlIlIlllIl.getHttpListener();
                lllllllllllllIIlllllllIlIlIlllll.finished(lllllllllllllIIlllllllIlIlIlllIl.getHttpRequest(), lllllllllllllIIlllllllIlIllIIlII);
            }
            this.checkResponseHeader(lllllllllllllIIlllllllIlIllIIlII);
        }
    }
    
    public HttpPipelineConnection(final String lllllllllllllIIlllllllIllIllIlII, final int lllllllllllllIIlllllllIllIllIllI) {
        this(lllllllllllllIIlllllllIllIllIlII, lllllllllllllIIlllllllIllIllIllI, Proxy.NO_PROXY);
    }
    
    public synchronized boolean hasActiveRequests() {
        return this.listRequests.size() > 0;
    }
    
    public int getCountRequests() {
        return this.countRequests;
    }
    
    private void onActivity() {
        this.timeLastActivityMs = System.currentTimeMillis();
    }
    
    public synchronized void onExceptionReceive(final HttpPipelineRequest lllllllllllllIIlllllllIlIIIlIIlI, final Exception lllllllllllllIIlllllllIlIIIlIIIl) {
        this.terminate(lllllllllllllIIlllllllIlIIIlIIIl);
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
}
