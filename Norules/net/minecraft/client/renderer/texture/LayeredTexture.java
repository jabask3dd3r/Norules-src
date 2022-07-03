package net.minecraft.client.renderer.texture;

import java.util.*;
import net.minecraft.util.*;
import java.awt.*;
import java.awt.image.*;
import org.apache.commons.io.*;
import java.io.*;
import net.minecraft.client.resources.*;
import com.google.common.collect.*;
import org.apache.logging.log4j.*;

public class LayeredTexture extends AbstractTexture
{
    public final /* synthetic */ List<String> layeredTextureNames;
    private static final /* synthetic */ Logger LOGGER;
    
    @Override
    public void loadTexture(final IResourceManager lllllllllllllIIllIIIIIIIIIlIIlII) throws IOException {
        this.deleteGlTexture();
        BufferedImage lllllllllllllIIllIIIIIIIIIlIIIll = null;
        for (final String lllllllllllllIIllIIIIIIIIIlIIIlI : this.layeredTextureNames) {
            IResource lllllllllllllIIllIIIIIIIIIlIIIIl = null;
            try {
                if (lllllllllllllIIllIIIIIIIIIlIIIlI == null) {
                    continue;
                }
                lllllllllllllIIllIIIIIIIIIlIIIIl = lllllllllllllIIllIIIIIIIIIlIIlII.getResource(new ResourceLocation(lllllllllllllIIllIIIIIIIIIlIIIlI));
                final BufferedImage lllllllllllllIIllIIIIIIIIIlIIIII = TextureUtil.readBufferedImage(lllllllllllllIIllIIIIIIIIIlIIIIl.getInputStream());
                if (lllllllllllllIIllIIIIIIIIIlIIIll == null) {
                    lllllllllllllIIllIIIIIIIIIlIIIll = new BufferedImage(lllllllllllllIIllIIIIIIIIIlIIIII.getWidth(), lllllllllllllIIllIIIIIIIIIlIIIII.getHeight(), 2);
                }
                lllllllllllllIIllIIIIIIIIIlIIIll.getGraphics().drawImage(lllllllllllllIIllIIIIIIIIIlIIIII, 0, 0, null);
                continue;
            }
            catch (IOException lllllllllllllIIllIIIIIIIIIIlllll) {
                LayeredTexture.LOGGER.error("Couldn't load layered image", (Throwable)lllllllllllllIIllIIIIIIIIIIlllll);
            }
            finally {
                IOUtils.closeQuietly((Closeable)lllllllllllllIIllIIIIIIIIIlIIIIl);
            }
            return;
        }
        TextureUtil.uploadTextureImage(this.getGlTextureId(), lllllllllllllIIllIIIIIIIIIlIIIll);
    }
    
    public LayeredTexture(final String... lllllllllllllIIllIIIIIIIIIllIIII) {
        this.layeredTextureNames = (List<String>)Lists.newArrayList((Object[])lllllllllllllIIllIIIIIIIIIllIIII);
    }
    
    static {
        LOGGER = LogManager.getLogger();
    }
}
