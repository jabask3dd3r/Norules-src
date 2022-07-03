package net.minecraft.client.renderer.texture;

import net.minecraft.util.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.resources.data.*;
import optifine.*;
import shadersmod.client.*;
import org.apache.commons.io.*;
import net.minecraft.client.resources.*;
import java.awt.image.*;
import java.io.*;

public class SimpleTexture extends AbstractTexture
{
    private static final /* synthetic */ Logger LOG;
    protected final /* synthetic */ ResourceLocation textureLocation;
    
    static {
        LOG = LogManager.getLogger();
    }
    
    public SimpleTexture(final ResourceLocation llllllllllllllllIlllIllIllllIlll) {
        this.textureLocation = llllllllllllllllIlllIllIllllIlll;
    }
    
    @Override
    public void loadTexture(final IResourceManager llllllllllllllllIlllIllIlllIlIll) throws IOException {
        this.deleteGlTexture();
        IResource llllllllllllllllIlllIllIlllIlIlI = null;
        try {
            llllllllllllllllIlllIllIlllIlIlI = llllllllllllllllIlllIllIlllIlIll.getResource(this.textureLocation);
            final BufferedImage llllllllllllllllIlllIllIlllIlIIl = TextureUtil.readBufferedImage(llllllllllllllllIlllIllIlllIlIlI.getInputStream());
            boolean llllllllllllllllIlllIllIlllIlIII = false;
            boolean llllllllllllllllIlllIllIlllIIlll = false;
            if (llllllllllllllllIlllIllIlllIlIlI.hasMetadata()) {
                try {
                    final TextureMetadataSection llllllllllllllllIlllIllIlllIIllI = llllllllllllllllIlllIllIlllIlIlI.getMetadata("texture");
                    if (llllllllllllllllIlllIllIlllIIllI != null) {
                        llllllllllllllllIlllIllIlllIlIII = llllllllllllllllIlllIllIlllIIllI.getTextureBlur();
                        llllllllllllllllIlllIllIlllIIlll = llllllllllllllllIlllIllIlllIIllI.getTextureClamp();
                    }
                }
                catch (RuntimeException llllllllllllllllIlllIllIlllIIlIl) {
                    SimpleTexture.LOG.warn("Failed reading metadata of: {}", (Object)this.textureLocation, (Object)llllllllllllllllIlllIllIlllIIlIl);
                }
            }
            if (Config.isShaders()) {
                ShadersTex.loadSimpleTexture(this.getGlTextureId(), llllllllllllllllIlllIllIlllIlIIl, llllllllllllllllIlllIllIlllIlIII, llllllllllllllllIlllIllIlllIIlll, llllllllllllllllIlllIllIlllIlIll, this.textureLocation, this.getMultiTexID());
            }
            else {
                TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), llllllllllllllllIlllIllIlllIlIIl, llllllllllllllllIlllIllIlllIlIII, llllllllllllllllIlllIllIlllIIlll);
            }
        }
        finally {
            IOUtils.closeQuietly((Closeable)llllllllllllllllIlllIllIlllIlIlI);
        }
        IOUtils.closeQuietly((Closeable)llllllllllllllllIlllIllIlllIlIlI);
    }
}
