package optifine;

import java.net.*;
import java.io.*;
import java.util.*;

public class HttpPipeline
{
    private static /* synthetic */ Map mapConnections;
    
    public static byte[] get(final String lllllllllllllIIlIlllllIlllllllll, final Proxy lllllllllllllIIlIlllllIllllllllI) throws IOException {
        if (lllllllllllllIIlIlllllIlllllllll.startsWith("file:")) {
            final URL lllllllllllllIIlIlllllIlllllllIl = new URL(lllllllllllllIIlIlllllIlllllllll);
            final InputStream lllllllllllllIIlIlllllIlllllllII = lllllllllllllIIlIlllllIlllllllIl.openStream();
            final byte[] lllllllllllllIIlIlllllIllllllIll = Config.readAll(lllllllllllllIIlIlllllIlllllllII);
            return lllllllllllllIIlIlllllIllllllIll;
        }
        final HttpRequest lllllllllllllIIlIlllllIllllllIlI = makeRequest(lllllllllllllIIlIlllllIlllllllll, lllllllllllllIIlIlllllIllllllllI);
        final HttpResponse lllllllllllllIIlIlllllIllllllIIl = executeRequest(lllllllllllllIIlIlllllIllllllIlI);
        if (lllllllllllllIIlIlllllIllllllIIl.getStatus() / 100 != 2) {
            throw new IOException(String.valueOf(new StringBuilder("HTTP response: ").append(lllllllllllllIIlIlllllIllllllIIl.getStatus())));
        }
        return lllllllllllllIIlIlllllIllllllIIl.getBody();
    }
    
    public static boolean hasActiveRequests() {
        for (final Object lllllllllllllIIlIlllllIlllIlIllI : HttpPipeline.mapConnections.values()) {
            if (((HttpPipelineConnection)lllllllllllllIIlIlllllIlllIlIllI).hasActiveRequests()) {
                return true;
            }
        }
        return false;
    }
    
    public static void addRequest(final String lllllllllllllIIlIllllllIIllIlIII, final HttpListener lllllllllllllIIlIllllllIIllIIIlI, final Proxy lllllllllllllIIlIllllllIIllIIllI) throws IOException {
        final HttpRequest lllllllllllllIIlIllllllIIllIIlIl = makeRequest(lllllllllllllIIlIllllllIIllIlIII, lllllllllllllIIlIllllllIIllIIllI);
        final HttpPipelineRequest lllllllllllllIIlIllllllIIllIIlII = new HttpPipelineRequest(lllllllllllllIIlIllllllIIllIIlIl, lllllllllllllIIlIllllllIIllIIIlI);
        addRequest(lllllllllllllIIlIllllllIIllIIlII);
    }
    
    public static byte[] get(final String lllllllllllllIIlIllllllIIIIIIlIl) throws IOException {
        return get(lllllllllllllIIlIllllllIIIIIIlIl, Proxy.NO_PROXY);
    }
    
    static {
        HEADER_CONNECTION = "Connection";
        HEADER_HOST = "Host";
        HEADER_TRANSFER_ENCODING = "Transfer-Encoding";
        HEADER_ACCEPT = "Accept";
        HEADER_USER_AGENT = "User-Agent";
        HEADER_KEEP_ALIVE = "Keep-Alive";
        HEADER_VALUE_KEEP_ALIVE = "keep-alive";
        HEADER_VALUE_CHUNKED = "chunked";
        HEADER_LOCATION = "Location";
        HttpPipeline.mapConnections = new HashMap();
    }
    
    public static HttpResponse executeRequest(final HttpRequest lllllllllllllIIlIlllllIllllIIIIl) throws IOException {
        final Map<String, Object> lllllllllllllIIlIlllllIllllIlIIl = new HashMap<String, Object>();
        final String lllllllllllllIIlIlllllIllllIlIII = "Response";
        final String lllllllllllllIIlIlllllIllllIIlll = "Exception";
        final HttpListener lllllllllllllIIlIlllllIllllIIllI = new HttpListener() {
            @Override
            public void failed(final HttpRequest lllllllllllllIIllIIlIllllIIIIIll, final Exception lllllllllllllIIllIIlIllllIIIIIII) {
                synchronized (lllllllllllllIIlIlllllIllllIlIIl) {
                    lllllllllllllIIlIlllllIllllIlIIl.put("Exception", lllllllllllllIIllIIlIllllIIIIIII);
                    lllllllllllllIIlIlllllIllllIlIIl.notifyAll();
                }
                // monitorexit(this.val$map)
            }
            
            @Override
            public void finished(final HttpRequest lllllllllllllIIllIIlIllllIIIllII, final HttpResponse lllllllllllllIIllIIlIllllIIIlIIl) {
                synchronized (lllllllllllllIIlIlllllIllllIlIIl) {
                    lllllllllllllIIlIlllllIllllIlIIl.put("Response", lllllllllllllIIllIIlIllllIIIlIIl);
                    lllllllllllllIIlIlllllIllllIlIIl.notifyAll();
                }
                // monitorexit(this.val$map)
            }
        };
        synchronized (lllllllllllllIIlIlllllIllllIlIIl) {
            final HttpPipelineRequest lllllllllllllIIlIlllllIllllIIlIl = new HttpPipelineRequest(lllllllllllllIIlIlllllIllllIIIIl, lllllllllllllIIlIlllllIllllIIllI);
            addRequest(lllllllllllllIIlIlllllIllllIIlIl);
            try {
                lllllllllllllIIlIlllllIllllIlIIl.wait();
            }
            catch (InterruptedException lllllllllllllIIlIlllllIllllIIlII) {
                throw new InterruptedIOException("Interrupted");
            }
            final Exception lllllllllllllIIlIlllllIllllIIIll = lllllllllllllIIlIlllllIllllIlIIl.get("Exception");
            if (lllllllllllllIIlIlllllIllllIIIll != null) {
                if (lllllllllllllIIlIlllllIllllIIIll instanceof IOException) {
                    throw (IOException)lllllllllllllIIlIlllllIllllIIIll;
                }
                if (lllllllllllllIIlIlllllIllllIIIll instanceof RuntimeException) {
                    throw (RuntimeException)lllllllllllllIIlIlllllIllllIIIll;
                }
                throw new RuntimeException(lllllllllllllIIlIlllllIllllIIIll.getMessage(), lllllllllllllIIlIlllllIllllIIIll);
            }
            else {
                final HttpResponse lllllllllllllIIlIlllllIllllIIIlI = lllllllllllllIIlIlllllIllllIlIIl.get("Response");
                if (lllllllllllllIIlIlllllIllllIIIlI == null) {
                    throw new IOException("Response is null");
                }
                // monitorexit(lllllllllllllIIlIlllllIllllIlIIl)
                return lllllllllllllIIlIlllllIllllIIIlI;
            }
        }
    }
    
    public static void addRequest(final HttpPipelineRequest lllllllllllllIIlIllllllIIIlllIlI) {
        final HttpRequest lllllllllllllIIlIllllllIIIlllIIl = lllllllllllllIIlIllllllIIIlllIlI.getHttpRequest();
        for (HttpPipelineConnection lllllllllllllIIlIllllllIIIlllIII = getConnection(lllllllllllllIIlIllllllIIIlllIIl.getHost(), lllllllllllllIIlIllllllIIIlllIIl.getPort(), lllllllllllllIIlIllllllIIIlllIIl.getProxy()); !lllllllllllllIIlIllllllIIIlllIII.addRequest(lllllllllllllIIlIllllllIIIlllIlI); lllllllllllllIIlIllllllIIIlllIII = getConnection(lllllllllllllIIlIllllllIIIlllIIl.getHost(), lllllllllllllIIlIllllllIIIlllIIl.getPort(), lllllllllllllIIlIllllllIIIlllIIl.getProxy())) {
            removeConnection(lllllllllllllIIlIllllllIIIlllIIl.getHost(), lllllllllllllIIlIllllllIIIlllIIl.getPort(), lllllllllllllIIlIllllllIIIlllIIl.getProxy(), lllllllllllllIIlIllllllIIIlllIII);
        }
    }
    
    private static String makeConnectionKey(final String lllllllllllllIIlIllllllIIIIIllll, final int lllllllllllllIIlIllllllIIIIIlIlI, final Proxy lllllllllllllIIlIllllllIIIIIllIl) {
        final String lllllllllllllIIlIllllllIIIIIllII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlIllllllIIIIIllll)).append(":").append(lllllllllllllIIlIllllllIIIIIlIlI).append("-").append(lllllllllllllIIlIllllllIIIIIllIl));
        return lllllllllllllIIlIllllllIIIIIllII;
    }
    
    private static synchronized HttpPipelineConnection getConnection(final String lllllllllllllIIlIllllllIIIlIlIlI, final int lllllllllllllIIlIllllllIIIlIlllI, final Proxy lllllllllllllIIlIllllllIIIlIlIII) {
        final String lllllllllllllIIlIllllllIIIlIllII = makeConnectionKey(lllllllllllllIIlIllllllIIIlIlIlI, lllllllllllllIIlIllllllIIIlIlllI, lllllllllllllIIlIllllllIIIlIlIII);
        HttpPipelineConnection lllllllllllllIIlIllllllIIIlIlIll = HttpPipeline.mapConnections.get(lllllllllllllIIlIllllllIIIlIllII);
        if (lllllllllllllIIlIllllllIIIlIlIll == null) {
            lllllllllllllIIlIllllllIIIlIlIll = new HttpPipelineConnection(lllllllllllllIIlIllllllIIIlIlIlI, lllllllllllllIIlIllllllIIIlIlllI, lllllllllllllIIlIllllllIIIlIlIII);
            HttpPipeline.mapConnections.put(lllllllllllllIIlIllllllIIIlIllII, lllllllllllllIIlIllllllIIIlIlIll);
        }
        return lllllllllllllIIlIllllllIIIlIlIll;
    }
    
    private static synchronized void removeConnection(final String lllllllllllllIIlIllllllIIIIllIIl, final int lllllllllllllIIlIllllllIIIIllIII, final Proxy lllllllllllllIIlIllllllIIIIlIlll, final HttpPipelineConnection lllllllllllllIIlIllllllIIIIlllII) {
        final String lllllllllllllIIlIllllllIIIIllIll = makeConnectionKey(lllllllllllllIIlIllllllIIIIllIIl, lllllllllllllIIlIllllllIIIIllIII, lllllllllllllIIlIllllllIIIIlIlll);
        final HttpPipelineConnection lllllllllllllIIlIllllllIIIIllIlI = HttpPipeline.mapConnections.get(lllllllllllllIIlIllllllIIIIllIll);
        if (lllllllllllllIIlIllllllIIIIllIlI == lllllllllllllIIlIllllllIIIIlllII) {
            HttpPipeline.mapConnections.remove(lllllllllllllIIlIllllllIIIIllIll);
        }
    }
    
    public static void addRequest(final String lllllllllllllIIlIllllllIIlllIIIl, final HttpListener lllllllllllllIIlIllllllIIlllIIII) throws IOException {
        addRequest(lllllllllllllIIlIllllllIIlllIIIl, lllllllllllllIIlIllllllIIlllIIII, Proxy.NO_PROXY);
    }
    
    public static HttpRequest makeRequest(final String lllllllllllllIIlIllllllIIlIIlIII, final Proxy lllllllllllllIIlIllllllIIlIIIlll) throws IOException {
        final URL lllllllllllllIIlIllllllIIlIlIIIl = new URL(lllllllllllllIIlIllllllIIlIIlIII);
        if (!lllllllllllllIIlIllllllIIlIlIIIl.getProtocol().equals("http")) {
            throw new IOException(String.valueOf(new StringBuilder("Only protocol http is supported: ").append(lllllllllllllIIlIllllllIIlIlIIIl)));
        }
        final String lllllllllllllIIlIllllllIIlIlIIII = lllllllllllllIIlIllllllIIlIlIIIl.getFile();
        final String lllllllllllllIIlIllllllIIlIIllll = lllllllllllllIIlIllllllIIlIlIIIl.getHost();
        int lllllllllllllIIlIllllllIIlIIlllI = lllllllllllllIIlIllllllIIlIlIIIl.getPort();
        if (lllllllllllllIIlIllllllIIlIIlllI <= 0) {
            lllllllllllllIIlIllllllIIlIIlllI = 80;
        }
        final String lllllllllllllIIlIllllllIIlIIllIl = "GET";
        final String lllllllllllllIIlIllllllIIlIIllII = "HTTP/1.1";
        final Map<String, String> lllllllllllllIIlIllllllIIlIIlIll = new LinkedHashMap<String, String>();
        lllllllllllllIIlIllllllIIlIIlIll.put("User-Agent", String.valueOf(new StringBuilder("Java/").append(System.getProperty("java.version"))));
        lllllllllllllIIlIllllllIIlIIlIll.put("Host", lllllllllllllIIlIllllllIIlIIllll);
        lllllllllllllIIlIllllllIIlIIlIll.put("Accept", "text/html, image/gif, image/png");
        lllllllllllllIIlIllllllIIlIIlIll.put("Connection", "keep-alive");
        final byte[] lllllllllllllIIlIllllllIIlIIlIlI = new byte[0];
        final HttpRequest lllllllllllllIIlIllllllIIlIIlIIl = new HttpRequest(lllllllllllllIIlIllllllIIlIIllll, lllllllllllllIIlIllllllIIlIIlllI, lllllllllllllIIlIllllllIIlIIIlll, lllllllllllllIIlIllllllIIlIIllIl, lllllllllllllIIlIllllllIIlIlIIII, lllllllllllllIIlIllllllIIlIIllII, lllllllllllllIIlIllllllIIlIIlIll, lllllllllllllIIlIllllllIIlIIlIlI);
        return lllllllllllllIIlIllllllIIlIIlIIl;
    }
}
