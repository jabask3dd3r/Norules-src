package me.nrules.utils.render.cosmetic;

import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import java.io.*;
import net.minecraft.client.renderer.texture.*;
import java.awt.image.*;
import java.awt.*;
import net.minecraft.entity.*;

public class CosmeticRender implements LayerRenderer<AbstractClientPlayer>
{
    private final /* synthetic */ RenderPlayer playerRenderer;
    
    public CosmeticRender(final RenderPlayer lllllIlIII) {
        this.playerRenderer = lllllIlIII;
    }
    
    public static void bindTexture(final String llllIIllIl, final String llllIlIIlI) {
        final IImageBuffer llllIlIIIl = new IImageBuffer() {
            @Override
            public BufferedImage parseUserSkin(final BufferedImage lllllllllllllIlIllllIlIIlllIIIll) {
                return parseCape(lllllllllllllIlIllllIlIIlllIIIll);
            }
            
            @Override
            public void skinAvailable() {
            }
        };
        final ResourceLocation llllIlIIII = new ResourceLocation(llllIlIIlI);
        final TextureManager llllIIllll = Minecraft.getMinecraft().getTextureManager();
        llllIIllll.getTexture(llllIlIIII);
        final ThreadDownloadImageData llllIIlllI = new ThreadDownloadImageData(null, llllIIllIl, null, llllIlIIIl);
        llllIIllll.loadTexture(llllIlIIII, llllIIlllI);
    }
    
    private static BufferedImage parseCape(final BufferedImage llllIIIIII) {
        int lllIllllll = 64;
        int lllIlllllI = 32;
        for (int lllIllllIl = llllIIIIII.getWidth(), lllIllllII = llllIIIIII.getHeight(); lllIllllll < lllIllllIl || lllIlllllI < lllIllllII; lllIllllll *= 2, lllIlllllI *= 2) {}
        final BufferedImage lllIlllIll = new BufferedImage(lllIllllll, lllIlllllI, 2);
        final Graphics lllIlllIlI = lllIlllIll.getGraphics();
        lllIlllIlI.drawImage(llllIIIIII, 0, 0, null);
        lllIlllIlI.dispose();
        return lllIlllIll;
    }
    
    @Override
    public void doRenderLayer(final AbstractClientPlayer lllllIIIll, final float lllllIIIlI, final float lllllIIIIl, final float lllllIIIII, final float llllIlllll, final float llllIllllI, final float llllIlllIl, final float llllIlllII) {
        if (!lllllIIIll.hasPlayerInfo() || lllllIIIll.isInvisible()) {
            return;
        }
    }
    
    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
