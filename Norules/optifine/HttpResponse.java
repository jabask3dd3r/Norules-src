package optifine;

import java.util.*;

public class HttpResponse
{
    private /* synthetic */ int status;
    private /* synthetic */ Map<String, String> headers;
    private /* synthetic */ String statusLine;
    private /* synthetic */ byte[] body;
    
    public String getHeader(final String lllllllllllllIlIlIlIllIIllIlIIlI) {
        return this.headers.get(lllllllllllllIlIlIlIllIIllIlIIlI);
    }
    
    public byte[] getBody() {
        return this.body;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public String getStatusLine() {
        return this.statusLine;
    }
    
    public Map getHeaders() {
        return this.headers;
    }
    
    public HttpResponse(final int lllllllllllllIlIlIlIllIIlllllIII, final String lllllllllllllIlIlIlIllIIlllIlllI, final Map lllllllllllllIlIlIlIllIIllllIllI, final byte[] lllllllllllllIlIlIlIllIIlllIlIlI) {
        this.status = 0;
        this.statusLine = null;
        this.headers = new LinkedHashMap<String, String>();
        this.body = null;
        this.status = lllllllllllllIlIlIlIllIIlllllIII;
        this.statusLine = lllllllllllllIlIlIlIllIIlllIlllI;
        this.headers = (Map<String, String>)lllllllllllllIlIlIlIllIIllllIllI;
        this.body = lllllllllllllIlIlIlIllIIlllIlIlI;
    }
}
