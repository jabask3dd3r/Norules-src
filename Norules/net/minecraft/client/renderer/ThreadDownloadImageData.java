package net.minecraft.client.renderer;

import java.util.concurrent.atomic.*;
import javax.annotation.*;
import java.awt.image.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.resources.*;
import javax.imageio.*;
import net.minecraft.util.*;
import java.net.*;
import org.apache.commons.io.*;
import java.io.*;
import optifine.*;

public class ThreadDownloadImageData extends SimpleTexture
{
    private /* synthetic */ boolean textureUploaded;
    private static final /* synthetic */ AtomicInteger TEXTURE_DOWNLOADER_THREAD_ID;
    @Nullable
    private final /* synthetic */ File cacheFile;
    @Nullable
    private /* synthetic */ Thread imageThread;
    private final /* synthetic */ String imageUrl;
    public /* synthetic */ boolean pipeline;
    @Nullable
    private final /* synthetic */ IImageBuffer imageBuffer;
    private static final /* synthetic */ Logger LOGGER;
    @Nullable
    private /* synthetic */ BufferedImage bufferedImage;
    public /* synthetic */ Boolean imageFound;
    
    private boolean shouldPipeline() {
        if (!this.pipeline) {
            return false;
        }
        final Proxy lllllllllllllIIllIIIIIllIlIlllIl = Minecraft.getMinecraft().getProxy();
        return (lllllllllllllIIllIIIIIllIlIlllIl.type() == Proxy.Type.DIRECT || lllllllllllllIIllIIIIIllIlIlllIl.type() == Proxy.Type.SOCKS) && this.imageUrl.startsWith("http://");
    }
    
    private void checkTextureUploaded() {
        if (!this.textureUploaded && this.bufferedImage != null) {
            this.textureUploaded = true;
            if (this.textureLocation != null) {
                this.deleteGlTexture();
            }
            TextureUtil.uploadTextureImage(super.getGlTextureId(), this.bufferedImage);
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        TEXTURE_DOWNLOADER_THREAD_ID = new AtomicInteger(0);
    }
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllIIllIIIIIllIllIlIII) throws IOException {
        if (this.bufferedImage == null && this.textureLocation != null) {
            super.loadTexture(lllllllllllllIIllIIIIIllIllIlIII);
        }
        if (this.imageThread == null) {
            if (this.cacheFile != null && this.cacheFile.isFile()) {
                ThreadDownloadImageData.LOGGER.debug("Loading http texture from local cache ({})", (Object)this.cacheFile);
                try {
                    this.bufferedImage = ImageIO.read(this.cacheFile);
                    if (this.imageBuffer != null) {
                        this.setBufferedImage(this.imageBuffer.parseUserSkin(this.bufferedImage));
                    }
                    this.loadingFinished();
                }
                catch (IOException lllllllllllllIIllIIIIIllIllIIlll) {
                    ThreadDownloadImageData.LOGGER.error("Couldn't load skin {}", (Object)this.cacheFile, (Object)lllllllllllllIIllIIIIIllIllIIlll);
                    this.loadTextureFromServer();
                }
            }
            else {
                this.loadTextureFromServer();
            }
        }
    }
    
    @Override
    public int getGlTextureId() {
        this.checkTextureUploaded();
        return super.getGlTextureId();
    }
    
    public ThreadDownloadImageData(@Nullable final File lllllllllllllIIllIIIIIlllIIIIIIl, final String lllllllllllllIIllIIIIIlllIIIIIII, final ResourceLocation lllllllllllllIIllIIIIIllIllllIlI, @Nullable final IImageBuffer lllllllllllllIIllIIIIIllIllllllI) {
        super(lllllllllllllIIllIIIIIllIllllIlI);
        this.imageFound = null;
        this.pipeline = false;
        this.cacheFile = lllllllllllllIIllIIIIIlllIIIIIIl;
        this.imageUrl = lllllllllllllIIllIIIIIlllIIIIIII;
        this.imageBuffer = lllllllllllllIIllIIIIIllIllllllI;
    }
    
    public void setBufferedImage(final BufferedImage lllllllllllllIIllIIIIIllIllIllIl) {
        this.bufferedImage = lllllllllllllIIllIIIIIllIllIllIl;
        if (this.imageBuffer != null) {
            this.imageBuffer.skinAvailable();
        }
        this.imageFound = (this.bufferedImage != null);
    }
    
    private void loadingFinished() {
        this.imageFound = (this.bufferedImage != null);
        if (this.imageBuffer instanceof CapeImageBuffer) {
            final CapeImageBuffer lllllllllllllIIllIIIIIllIlIIIIIl = (CapeImageBuffer)this.imageBuffer;
            lllllllllllllIIllIIIIIllIlIIIIIl.cleanup();
        }
    }
    
    protected void loadTextureFromServer() {
        this.imageThread = new Thread(String.valueOf(new StringBuilder("Texture Downloader #").append(ThreadDownloadImageData.TEXTURE_DOWNLOADER_THREAD_ID.incrementAndGet()))) {
            @Override
            public void run() {
                HttpURLConnection llllllllllllllIlIIIlIlIllllIlIII = null;
                ThreadDownloadImageData.LOGGER.debug("Downloading http texture from {} to {}", (Object)ThreadDownloadImageData.this.imageUrl, (Object)ThreadDownloadImageData.this.cacheFile);
                if (ThreadDownloadImageData.this.shouldPipeline()) {
                    ThreadDownloadImageData.this.loadPipelined();
                }
                else {
                    try {
                        llllllllllllllIlIIIlIlIllllIlIII = (HttpURLConnection)new URL(ThreadDownloadImageData.this.imageUrl).openConnection(Minecraft.getMinecraft().getProxy());
                        llllllllllllllIlIIIlIlIllllIlIII.setDoInput(true);
                        llllllllllllllIlIIIlIlIllllIlIII.setDoOutput(false);
                        llllllllllllllIlIIIlIlIllllIlIII.connect();
                        if (llllllllllllllIlIIIlIlIllllIlIII.getResponseCode() / 100 != 2) {
                            if (llllllllllllllIlIIIlIlIllllIlIII.getErrorStream() != null) {
                                Config.readAll(llllllllllllllIlIIIlIlIllllIlIII.getErrorStream());
                            }
                            return;
                        }
                        BufferedImage llllllllllllllIlIIIlIlIllllIIllI = null;
                        if (ThreadDownloadImageData.this.cacheFile != null) {
                            FileUtils.copyInputStreamToFile(llllllllllllllIlIIIlIlIllllIlIII.getInputStream(), ThreadDownloadImageData.this.cacheFile);
                            final BufferedImage llllllllllllllIlIIIlIlIllllIIlll = ImageIO.read(ThreadDownloadImageData.this.cacheFile);
                        }
                        else {
                            llllllllllllllIlIIIlIlIllllIIllI = TextureUtil.readBufferedImage(llllllllllllllIlIIIlIlIllllIlIII.getInputStream());
                        }
                        if (ThreadDownloadImageData.this.imageBuffer != null) {
                            llllllllllllllIlIIIlIlIllllIIllI = ThreadDownloadImageData.this.imageBuffer.parseUserSkin(llllllllllllllIlIIIlIlIllllIIllI);
                        }
                        ThreadDownloadImageData.this.setBufferedImage(llllllllllllllIlIIIlIlIllllIIllI);
                    }
                    catch (Exception llllllllllllllIlIIIlIlIllllIIlIl) {
                        ThreadDownloadImageData.LOGGER.error(String.valueOf(new StringBuilder("Couldn't download http texture: ").append(llllllllllllllIlIIIlIlIllllIIlIl.getMessage())));
                        return;
                    }
                    finally {
                        if (llllllllllllllIlIIIlIlIllllIlIII != null) {
                            llllllllllllllIlIIIlIlIllllIlIII.disconnect();
                        }
                        ThreadDownloadImageData.this.loadingFinished();
                    }
                    if (llllllllllllllIlIIIlIlIllllIlIII != null) {
                        llllllllllllllIlIIIlIlIllllIlIII.disconnect();
                    }
                    ThreadDownloadImageData.this.loadingFinished();
                }
            }
        };
        this.imageThread.setDaemon(true);
        this.imageThread.start();
    }
    
    private void loadPipelined() {
        try {
            final HttpRequest lllllllllllllIIllIIIIIllIlIlIIlI = HttpPipeline.makeRequest(this.imageUrl, Minecraft.getMinecraft().getProxy());
            final HttpResponse lllllllllllllIIllIIIIIllIlIlIIIl = HttpPipeline.executeRequest(lllllllllllllIIllIIIIIllIlIlIIlI);
            if (lllllllllllllIIllIIIIIllIlIlIIIl.getStatus() / 100 != 2) {
                return;
            }
            final byte[] lllllllllllllIIllIIIIIllIlIlIIII = lllllllllllllIIllIIIIIllIlIlIIIl.getBody();
            final ByteArrayInputStream lllllllllllllIIllIIIIIllIlIIllll = new ByteArrayInputStream(lllllllllllllIIllIIIIIllIlIlIIII);
            BufferedImage lllllllllllllIIllIIIIIllIlIIllIl = null;
            if (this.cacheFile != null) {
                FileUtils.copyInputStreamToFile((InputStream)lllllllllllllIIllIIIIIllIlIIllll, this.cacheFile);
                final BufferedImage lllllllllllllIIllIIIIIllIlIIlllI = ImageIO.read(this.cacheFile);
            }
            else {
                lllllllllllllIIllIIIIIllIlIIllIl = TextureUtil.readBufferedImage(lllllllllllllIIllIIIIIllIlIIllll);
            }
            if (this.imageBuffer != null) {
                lllllllllllllIIllIIIIIllIlIIllIl = this.imageBuffer.parseUserSkin(lllllllllllllIIllIIIIIllIlIIllIl);
            }
            this.setBufferedImage(lllllllllllllIIllIIIIIllIlIIllIl);
        }
        catch (Exception lllllllllllllIIllIIIIIllIlIIllII) {
            ThreadDownloadImageData.LOGGER.error(String.valueOf(new StringBuilder("Couldn't download http texture: ").append(lllllllllllllIIllIIIIIllIlIIllII.getClass().getName()).append(": ").append(lllllllllllllIIllIIIIIllIlIIllII.getMessage())));
            return;
        }
        finally {
            this.loadingFinished();
        }
        this.loadingFinished();
    }
}
