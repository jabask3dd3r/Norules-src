package optifine;

import java.net.*;
import java.util.*;

public class HttpRequest
{
    private /* synthetic */ String file;
    private /* synthetic */ String http;
    private /* synthetic */ int port;
    private /* synthetic */ byte[] body;
    private /* synthetic */ Proxy proxy;
    private /* synthetic */ String host;
    private /* synthetic */ Map<String, String> headers;
    private /* synthetic */ String method;
    private /* synthetic */ int redirects;
    
    static {
        METHOD_POST = "POST";
        METHOD_HEAD = "HEAD";
        HTTP_1_1 = "HTTP/1.1";
        HTTP_1_0 = "HTTP/1.0";
        METHOD_GET = "GET";
    }
    
    public int getRedirects() {
        return this.redirects;
    }
    
    public byte[] getBody() {
        return this.body;
    }
    
    public int getPort() {
        return this.port;
    }
    
    public Proxy getProxy() {
        return this.proxy;
    }
    
    public String getFile() {
        return this.file;
    }
    
    public String getHost() {
        return this.host;
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public void setRedirects(final int lIIllllIIIllIll) {
        this.redirects = lIIllllIIIllIll;
    }
    
    public Map<String, String> getHeaders() {
        return this.headers;
    }
    
    public String getHttp() {
        return this.http;
    }
    
    public HttpRequest(final String lIIllllIIlllllI, final int lIIllllIIllllIl, final Proxy lIIllllIIllllII, final String lIIllllIIlllIll, final String lIIllllIlIIIIll, final String lIIllllIIlllIIl, final Map<String, String> lIIllllIIlllIII, final byte[] lIIllllIIllIlll) {
        this.host = null;
        this.port = 0;
        this.proxy = Proxy.NO_PROXY;
        this.method = null;
        this.file = null;
        this.http = null;
        this.headers = new LinkedHashMap<String, String>();
        this.body = null;
        this.redirects = 0;
        this.host = lIIllllIIlllllI;
        this.port = lIIllllIIllllIl;
        this.proxy = lIIllllIIllllII;
        this.method = lIIllllIIlllIll;
        this.file = lIIllllIlIIIIll;
        this.http = lIIllllIIlllIIl;
        this.headers = lIIllllIIlllIII;
        this.body = lIIllllIIllIlll;
    }
}
