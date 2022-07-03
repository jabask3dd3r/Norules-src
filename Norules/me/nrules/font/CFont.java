package me.nrules.font;

import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.*;
import java.awt.image.*;
import java.awt.*;
import java.awt.geom.*;

public class CFont
{
    protected /* synthetic */ int charOffset;
    protected /* synthetic */ int fontHeight;
    protected /* synthetic */ Font font;
    protected /* synthetic */ boolean fractionalMetrics;
    protected /* synthetic */ CharData[] charData;
    protected /* synthetic */ boolean antiAlias;
    protected /* synthetic */ DynamicTexture tex;
    
    public int getStringHeight(final String lllllllllllllIlIIIlIlIlIllIIllIl) {
        return this.getHeight();
    }
    
    public void setFont(final Font lllllllllllllIlIIIlIlIlIlIIllIIl) {
        this.font = lllllllllllllIlIIIlIlIlIlIIllIIl;
        this.tex = this.setupTexture(lllllllllllllIlIIIlIlIlIlIIllIIl, this.antiAlias, this.fractionalMetrics, this.charData);
    }
    
    protected void drawQuad(final float lllllllllllllIlIIIlIlIlIlllIIlll, final float lllllllllllllIlIIIlIlIlIllIllIlI, final float lllllllllllllIlIIIlIlIlIllIllIIl, final float lllllllllllllIlIIIlIlIlIlllIIlII, final float lllllllllllllIlIIIlIlIlIlllIIIll, final float lllllllllllllIlIIIlIlIlIllIlIllI, final float lllllllllllllIlIIIlIlIlIlllIIIIl, final float lllllllllllllIlIIIlIlIlIllIlIlII) {
        final float lllllllllllllIlIIIlIlIlIllIlllll = lllllllllllllIlIIIlIlIlIlllIIIll / 512.0f;
        final float lllllllllllllIlIIIlIlIlIllIllllI = lllllllllllllIlIIIlIlIlIllIlIllI / 512.0f;
        final float lllllllllllllIlIIIlIlIlIllIlllIl = lllllllllllllIlIIIlIlIlIlllIIIIl / 512.0f;
        final float lllllllllllllIlIIIlIlIlIllIlllII = lllllllllllllIlIIIlIlIlIllIlIlII / 512.0f;
        GL11.glTexCoord2f(lllllllllllllIlIIIlIlIlIllIlllll + lllllllllllllIlIIIlIlIlIllIlllIl, lllllllllllllIlIIIlIlIlIllIllllI);
        GL11.glVertex2d((double)(lllllllllllllIlIIIlIlIlIlllIIlll + lllllllllllllIlIIIlIlIlIllIllIIl), (double)lllllllllllllIlIIIlIlIlIllIllIlI);
        GL11.glTexCoord2f(lllllllllllllIlIIIlIlIlIllIlllll, lllllllllllllIlIIIlIlIlIllIllllI);
        GL11.glVertex2d((double)lllllllllllllIlIIIlIlIlIlllIIlll, (double)lllllllllllllIlIIIlIlIlIllIllIlI);
        GL11.glTexCoord2f(lllllllllllllIlIIIlIlIlIllIlllll, lllllllllllllIlIIIlIlIlIllIllllI + lllllllllllllIlIIIlIlIlIllIlllII);
        GL11.glVertex2d((double)lllllllllllllIlIIIlIlIlIlllIIlll, (double)(lllllllllllllIlIIIlIlIlIllIllIlI + lllllllllllllIlIIIlIlIlIlllIIlII));
        GL11.glTexCoord2f(lllllllllllllIlIIIlIlIlIllIlllll, lllllllllllllIlIIIlIlIlIllIllllI + lllllllllllllIlIIIlIlIlIllIlllII);
        GL11.glVertex2d((double)lllllllllllllIlIIIlIlIlIlllIIlll, (double)(lllllllllllllIlIIIlIlIlIllIllIlI + lllllllllllllIlIIIlIlIlIlllIIlII));
        GL11.glTexCoord2f(lllllllllllllIlIIIlIlIlIllIlllll + lllllllllllllIlIIIlIlIlIllIlllIl, lllllllllllllIlIIIlIlIlIllIllllI + lllllllllllllIlIIIlIlIlIllIlllII);
        GL11.glVertex2d((double)(lllllllllllllIlIIIlIlIlIlllIIlll + lllllllllllllIlIIIlIlIlIllIllIIl), (double)(lllllllllllllIlIIIlIlIlIllIllIlI + lllllllllllllIlIIIlIlIlIlllIIlII));
        GL11.glTexCoord2f(lllllllllllllIlIIIlIlIlIllIlllll + lllllllllllllIlIIIlIlIlIllIlllIl, lllllllllllllIlIIIlIlIlIllIllllI);
        GL11.glVertex2d((double)(lllllllllllllIlIIIlIlIlIlllIIlll + lllllllllllllIlIIIlIlIlIllIllIIl), (double)lllllllllllllIlIIIlIlIlIllIllIlI);
    }
    
    public int getHeight() {
        return (this.fontHeight - 8) / 2;
    }
    
    protected DynamicTexture setupTexture(final Font lllllllllllllIlIIIlIlIllIIllllII, final boolean lllllllllllllIlIIIlIlIllIlIIIIlI, final boolean lllllllllllllIlIIIlIlIllIIlllIlI, final CharData[] lllllllllllllIlIIIlIlIllIlIIIIII) {
        final BufferedImage lllllllllllllIlIIIlIlIllIIllllll = this.generateFontImage(lllllllllllllIlIIIlIlIllIIllllII, lllllllllllllIlIIIlIlIllIlIIIIlI, lllllllllllllIlIIIlIlIllIIlllIlI, lllllllllllllIlIIIlIlIllIlIIIIII);
        try {
            return new DynamicTexture(lllllllllllllIlIIIlIlIllIIllllll);
        }
        catch (Exception lllllllllllllIlIIIlIlIllIIlllllI) {
            lllllllllllllIlIIIlIlIllIIlllllI.printStackTrace();
            return null;
        }
    }
    
    public void drawChar(final CharData[] lllllllllllllIlIIIlIlIlIlllllIIl, final char lllllllllllllIlIIIlIlIlIlllllIII, final float lllllllllllllIlIIIlIlIlIllllllIl, final float lllllllllllllIlIIIlIlIlIllllllII) throws ArrayIndexOutOfBoundsException {
        try {
            this.drawQuad(lllllllllllllIlIIIlIlIlIllllllIl, lllllllllllllIlIIIlIlIlIllllllII, (float)lllllllllllllIlIIIlIlIlIlllllIIl[lllllllllllllIlIIIlIlIlIlllllIII].width, (float)lllllllllllllIlIIIlIlIlIlllllIIl[lllllllllllllIlIIIlIlIlIlllllIII].height, (float)lllllllllllllIlIIIlIlIlIlllllIIl[lllllllllllllIlIIIlIlIlIlllllIII].storedX, (float)lllllllllllllIlIIIlIlIlIlllllIIl[lllllllllllllIlIIIlIlIlIlllllIII].storedY, (float)lllllllllllllIlIIIlIlIlIlllllIIl[lllllllllllllIlIIIlIlIlIlllllIII].width, (float)lllllllllllllIlIIIlIlIlIlllllIIl[lllllllllllllIlIIIlIlIlIlllllIII].height);
        }
        catch (Exception lllllllllllllIlIIIlIlIlIlllllIll) {
            lllllllllllllIlIIIlIlIlIlllllIll.printStackTrace();
        }
    }
    
    public Font getFont() {
        return this.font;
    }
    
    public void setAntiAlias(final boolean lllllllllllllIlIIIlIlIlIlIlIlIll) {
        if (this.antiAlias != lllllllllllllIlIIIlIlIlIlIlIlIll) {
            this.antiAlias = lllllllllllllIlIIIlIlIlIlIlIlIll;
            this.tex = this.setupTexture(this.font, lllllllllllllIlIIIlIlIlIlIlIlIll, this.fractionalMetrics, this.charData);
        }
    }
    
    public boolean isFractionalMetrics() {
        return this.fractionalMetrics;
    }
    
    public int getStringWidth(final String lllllllllllllIlIIIlIlIlIllIIIIII) {
        int lllllllllllllIlIIIlIlIlIlIllllll = 0;
        char[] lllllllllllllIlIIIlIlIlIlIlllllI;
        for (int lllllllllllllIlIIIlIlIlIlIllllIl = (lllllllllllllIlIIIlIlIlIlIlllllI = lllllllllllllIlIIIlIlIlIllIIIIII.toCharArray()).length, lllllllllllllIlIIIlIlIlIlIllllII = 0; lllllllllllllIlIIIlIlIlIlIllllII < lllllllllllllIlIIIlIlIlIlIllllIl; ++lllllllllllllIlIIIlIlIlIlIllllII) {
            final char lllllllllllllIlIIIlIlIlIlIlllIll = lllllllllllllIlIIIlIlIlIlIlllllI[lllllllllllllIlIIIlIlIlIlIllllII];
            if (lllllllllllllIlIIIlIlIlIlIlllIll < this.charData.length && lllllllllllllIlIIIlIlIlIlIlllIll >= '\0') {
                lllllllllllllIlIIIlIlIlIlIllllll += this.charData[lllllllllllllIlIIIlIlIlIlIlllIll].width - 8 + this.charOffset;
            }
        }
        return lllllllllllllIlIIIlIlIlIlIllllll / 2;
    }
    
    public CFont(final Font lllllllllllllIlIIIlIlIllIlIlIIlI, final boolean lllllllllllllIlIIIlIlIllIlIlIIIl, final boolean lllllllllllllIlIIIlIlIllIlIIllII) {
        this.charData = new CharData[1087];
        this.fontHeight = -1;
        this.charOffset = 0;
        this.font = lllllllllllllIlIIIlIlIllIlIlIIlI;
        this.antiAlias = lllllllllllllIlIIIlIlIllIlIlIIIl;
        this.fractionalMetrics = lllllllllllllIlIIIlIlIllIlIIllII;
        this.tex = this.setupTexture(lllllllllllllIlIIIlIlIllIlIlIIlI, lllllllllllllIlIIIlIlIllIlIlIIIl, lllllllllllllIlIIIlIlIllIlIIllII, this.charData);
    }
    
    public void setFractionalMetrics(final boolean lllllllllllllIlIIIlIlIlIlIlIIlII) {
        if (this.fractionalMetrics != lllllllllllllIlIIIlIlIlIlIlIIlII) {
            this.fractionalMetrics = lllllllllllllIlIIIlIlIlIlIlIIlII;
            this.tex = this.setupTexture(this.font, this.antiAlias, lllllllllllllIlIIIlIlIlIlIlIIlII, this.charData);
        }
    }
    
    public boolean isAntiAlias() {
        return this.antiAlias;
    }
    
    protected BufferedImage generateFontImage(final Font lllllllllllllIlIIIlIlIllIIlIIlIl, final boolean lllllllllllllIlIIIlIlIllIIIlIlII, final boolean lllllllllllllIlIIIlIlIllIIIlIIll, final CharData[] lllllllllllllIlIIIlIlIllIIlIIIlI) {
        final int lllllllllllllIlIIIlIlIllIIlIIIIl = 512;
        final BufferedImage lllllllllllllIlIIIlIlIllIIlIIIII = new BufferedImage(lllllllllllllIlIIIlIlIllIIlIIIIl, lllllllllllllIlIIIlIlIllIIlIIIIl, 2);
        final Graphics2D lllllllllllllIlIIIlIlIllIIIlllll = (Graphics2D)lllllllllllllIlIIIlIlIllIIlIIIII.getGraphics();
        lllllllllllllIlIIIlIlIllIIIlllll.setFont(lllllllllllllIlIIIlIlIllIIlIIlIl);
        lllllllllllllIlIIIlIlIllIIIlllll.setColor(new Color(255, 255, 255, 0));
        lllllllllllllIlIIIlIlIllIIIlllll.fillRect(0, 0, lllllllllllllIlIIIlIlIllIIlIIIIl, lllllllllllllIlIIIlIlIllIIlIIIIl);
        lllllllllllllIlIIIlIlIllIIIlllll.setColor(Color.WHITE);
        lllllllllllllIlIIIlIlIllIIIlllll.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, lllllllllllllIlIIIlIlIllIIIlIIll ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        lllllllllllllIlIIIlIlIllIIIlllll.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, lllllllllllllIlIIIlIlIllIIIlIlII ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        lllllllllllllIlIIIlIlIllIIIlllll.setRenderingHint(RenderingHints.KEY_ANTIALIASING, lllllllllllllIlIIIlIlIllIIIlIlII ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        final FontMetrics lllllllllllllIlIIIlIlIllIIIllllI = lllllllllllllIlIIIlIlIllIIIlllll.getFontMetrics();
        int lllllllllllllIlIIIlIlIllIIIlllIl = 0;
        int lllllllllllllIlIIIlIlIllIIIlllII = 0;
        int lllllllllllllIlIIIlIlIllIIIllIll = 1;
        for (int lllllllllllllIlIIIlIlIllIIIllIlI = 0; lllllllllllllIlIIIlIlIllIIIllIlI < lllllllllllllIlIIIlIlIllIIlIIIlI.length; ++lllllllllllllIlIIIlIlIllIIIllIlI) {
            final char lllllllllllllIlIIIlIlIllIIIllIIl = (char)lllllllllllllIlIIIlIlIllIIIllIlI;
            final CharData lllllllllllllIlIIIlIlIllIIIllIII = new CharData();
            final Rectangle2D lllllllllllllIlIIIlIlIllIIIlIlll = lllllllllllllIlIIIlIlIllIIIllllI.getStringBounds(String.valueOf(lllllllllllllIlIIIlIlIllIIIllIIl), lllllllllllllIlIIIlIlIllIIIlllll);
            lllllllllllllIlIIIlIlIllIIIllIII.width = lllllllllllllIlIIIlIlIllIIIlIlll.getBounds().width + 8;
            lllllllllllllIlIIIlIlIllIIIllIII.height = lllllllllllllIlIIIlIlIllIIIlIlll.getBounds().height;
            if (lllllllllllllIlIIIlIlIllIIIlllII + lllllllllllllIlIIIlIlIllIIIllIII.width >= lllllllllllllIlIIIlIlIllIIlIIIIl) {
                lllllllllllllIlIIIlIlIllIIIlllII = 0;
                lllllllllllllIlIIIlIlIllIIIllIll += lllllllllllllIlIIIlIlIllIIIlllIl;
                lllllllllllllIlIIIlIlIllIIIlllIl = 0;
            }
            if (lllllllllllllIlIIIlIlIllIIIllIII.height > lllllllllllllIlIIIlIlIllIIIlllIl) {
                lllllllllllllIlIIIlIlIllIIIlllIl = lllllllllllllIlIIIlIlIllIIIllIII.height;
            }
            lllllllllllllIlIIIlIlIllIIIllIII.storedX = lllllllllllllIlIIIlIlIllIIIlllII;
            lllllllllllllIlIIIlIlIllIIIllIII.storedY = lllllllllllllIlIIIlIlIllIIIllIll;
            if (lllllllllllllIlIIIlIlIllIIIllIII.height > this.fontHeight) {
                this.fontHeight = lllllllllllllIlIIIlIlIllIIIllIII.height;
            }
            lllllllllllllIlIIIlIlIllIIlIIIlI[lllllllllllllIlIIIlIlIllIIIllIlI] = lllllllllllllIlIIIlIlIllIIIllIII;
            lllllllllllllIlIIIlIlIllIIIlllll.drawString(String.valueOf(lllllllllllllIlIIIlIlIllIIIllIIl), lllllllllllllIlIIIlIlIllIIIlllII + 2, lllllllllllllIlIIIlIlIllIIIllIll + lllllllllllllIlIIIlIlIllIIIllllI.getAscent());
            lllllllllllllIlIIIlIlIllIIIlllII += lllllllllllllIlIIIlIlIllIIIllIII.width;
        }
        return lllllllllllllIlIIIlIlIllIIlIIIII;
    }
    
    protected class CharData
    {
        public /* synthetic */ int height;
        public /* synthetic */ int storedY;
        public /* synthetic */ int storedX;
        public /* synthetic */ int width;
    }
}
