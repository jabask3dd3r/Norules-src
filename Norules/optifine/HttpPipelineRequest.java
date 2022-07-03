package optifine;

public class HttpPipelineRequest
{
    private /* synthetic */ boolean closed;
    private /* synthetic */ HttpListener httpListener;
    private /* synthetic */ HttpRequest httpRequest;
    
    public HttpListener getHttpListener() {
        return this.httpListener;
    }
    
    public HttpPipelineRequest(final HttpRequest llllllllllllllIIIIlIIIlllIlIllII, final HttpListener llllllllllllllIIIIlIIIlllIlIlIII) {
        this.httpRequest = null;
        this.httpListener = null;
        this.closed = false;
        this.httpRequest = llllllllllllllIIIIlIIIlllIlIllII;
        this.httpListener = llllllllllllllIIIIlIIIlllIlIlIII;
    }
    
    public boolean isClosed() {
        return this.closed;
    }
    
    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }
    
    public void setClosed(final boolean llllllllllllllIIIIlIIIlllIIllIll) {
        this.closed = llllllllllllllIIIIlIIIlllIIllIll;
    }
}
