package optifine;

import java.util.*;

public class FileUploadThread extends Thread
{
    private /* synthetic */ byte[] content;
    private /* synthetic */ IFileUploadListener listener;
    private /* synthetic */ Map headers;
    private /* synthetic */ String urlString;
    
    public IFileUploadListener getListener() {
        return this.listener;
    }
    
    @Override
    public void run() {
        try {
            HttpUtils.post(this.urlString, this.headers, this.content);
            this.listener.fileUploadFinished(this.urlString, this.content, null);
        }
        catch (Exception llllllllllllllllllIIIlIlIIlllIII) {
            this.listener.fileUploadFinished(this.urlString, this.content, llllllllllllllllllIIIlIlIIlllIII);
        }
    }
    
    public String getUrlString() {
        return this.urlString;
    }
    
    public byte[] getContent() {
        return this.content;
    }
    
    public FileUploadThread(final String llllllllllllllllllIIIlIlIlIIIlII, final Map llllllllllllllllllIIIlIlIlIIIIll, final byte[] llllllllllllllllllIIIlIlIlIIIIlI, final IFileUploadListener llllllllllllllllllIIIlIlIIllllII) {
        this.urlString = llllllllllllllllllIIIlIlIlIIIlII;
        this.headers = llllllllllllllllllIIIlIlIlIIIIll;
        this.content = llllllllllllllllllIIIlIlIlIIIIlI;
        this.listener = llllllllllllllllllIIIlIlIIllllII;
    }
}
