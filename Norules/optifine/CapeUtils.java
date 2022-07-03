package optifine;

import java.awt.image.*;
import java.awt.*;
import net.minecraft.client.entity.*;
import org.apache.commons.io.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.texture.*;

public class CapeUtils
{
    public static BufferedImage parseCape(final BufferedImage lllllllllllllllllIllIIlllIlIIIlI) {
        int lllllllllllllllllIllIIlllIlIIIIl = 64;
        int lllllllllllllllllIllIIlllIlIIIII = 32;
        for (int lllllllllllllllllIllIIlllIIlllll = lllllllllllllllllIllIIlllIlIIIlI.getWidth(), lllllllllllllllllIllIIlllIIllllI = lllllllllllllllllIllIIlllIlIIIlI.getHeight(); lllllllllllllllllIllIIlllIlIIIIl < lllllllllllllllllIllIIlllIIlllll || lllllllllllllllllIllIIlllIlIIIII < lllllllllllllllllIllIIlllIIllllI; lllllllllllllllllIllIIlllIlIIIIl *= 2, lllllllllllllllllIllIIlllIlIIIII *= 2) {}
        final BufferedImage lllllllllllllllllIllIIlllIIlllIl = new BufferedImage(lllllllllllllllllIllIIlllIlIIIIl, lllllllllllllllllIllIIlllIlIIIII, 2);
        final Graphics lllllllllllllllllIllIIlllIIlllII = lllllllllllllllllIllIIlllIIlllIl.getGraphics();
        lllllllllllllllllIllIIlllIIlllII.drawImage(lllllllllllllllllIllIIlllIlIIIlI, 0, 0, null);
        lllllllllllllllllIllIIlllIIlllII.dispose();
        return lllllllllllllllllIllIIlllIIlllIl;
    }
    
    public static void downloadCape(final AbstractClientPlayer lllllllllllllllllIllIIlllIlllIll) {
        final String lllllllllllllllllIllIIlllIlllIlI = lllllllllllllllllIllIIlllIlllIll.getNameClear();
        if (lllllllllllllllllIllIIlllIlllIlI != null && !lllllllllllllllllIllIIlllIlllIlI.isEmpty()) {
            final String lllllllllllllllllIllIIlllIlllIIl = String.valueOf(new StringBuilder("http://s.optifine.net/capes/").append(lllllllllllllllllIllIIlllIlllIlI).append(".png"));
            final String lllllllllllllllllIllIIlllIlllIII = FilenameUtils.getBaseName(lllllllllllllllllIllIIlllIlllIIl);
            final ResourceLocation lllllllllllllllllIllIIlllIllIlll = new ResourceLocation(String.valueOf(new StringBuilder("capeof/").append(lllllllllllllllllIllIIlllIlllIII)));
            final TextureManager lllllllllllllllllIllIIlllIllIllI = Minecraft.getMinecraft().getTextureManager();
            final ITextureObject lllllllllllllllllIllIIlllIllIlIl = lllllllllllllllllIllIIlllIllIllI.getTexture(lllllllllllllllllIllIIlllIllIlll);
            if (lllllllllllllllllIllIIlllIllIlIl != null && lllllllllllllllllIllIIlllIllIlIl instanceof ThreadDownloadImageData) {
                final ThreadDownloadImageData lllllllllllllllllIllIIlllIllIlII = (ThreadDownloadImageData)lllllllllllllllllIllIIlllIllIlIl;
                if (lllllllllllllllllIllIIlllIllIlII.imageFound != null) {
                    if (lllllllllllllllllIllIIlllIllIlII.imageFound) {
                        lllllllllllllllllIllIIlllIlllIll.setLocationOfCape(lllllllllllllllllIllIIlllIllIlll);
                    }
                    return;
                }
            }
            final CapeImageBuffer lllllllllllllllllIllIIlllIllIIll = new CapeImageBuffer(lllllllllllllllllIllIIlllIlllIll, lllllllllllllllllIllIIlllIllIlll);
            final ThreadDownloadImageData lllllllllllllllllIllIIlllIllIIlI = new ThreadDownloadImageData(null, lllllllllllllllllIllIIlllIlllIIl, null, lllllllllllllllllIllIIlllIllIIll);
            lllllllllllllllllIllIIlllIllIIlI.pipeline = true;
            lllllllllllllllllIllIIlllIllIllI.loadTexture(lllllllllllllllllIllIIlllIllIlll, lllllllllllllllllIllIIlllIllIIlI);
        }
    }
}
