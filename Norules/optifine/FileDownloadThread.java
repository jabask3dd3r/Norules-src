package optifine;

import net.minecraft.client.*;

public class FileDownloadThread extends Thread
{
    private /* synthetic */ String urlString;
    private /* synthetic */ IFileDownloadListener listener;
    
    public FileDownloadThread(final String llllllllllllllIllIIIllIIIIIIIIIl, final IFileDownloadListener llllllllllllllIllIIIllIIIIIIIIII) {
        this.urlString = null;
        this.listener = null;
        this.urlString = llllllllllllllIllIIIllIIIIIIIIIl;
        this.listener = llllllllllllllIllIIIllIIIIIIIIII;
    }
    
    public String getUrlString() {
        return this.urlString;
    }
    
    public IFileDownloadListener getListener() {
        return this.listener;
    }
    
    @Override
    public void run() {
        try {
            final byte[] llllllllllllllIllIIIlIllllllllII = HttpPipeline.get(this.urlString, Minecraft.getMinecraft().getProxy());
            this.listener.fileDownloadFinished(this.urlString, llllllllllllllIllIIIlIllllllllII, null);
        }
        catch (Exception llllllllllllllIllIIIlIlllllllIll) {
            this.listener.fileDownloadFinished(this.urlString, null, llllllllllllllIllIIIlIlllllllIll);
        }
    }
}
