package font;

import net.minecraft.client.renderer.*;
import java.awt.image.*;
import java.awt.*;

public final class FontData
{
    private /* synthetic */ int fontHeight;
    private /* synthetic */ int texId;
    private /* synthetic */ int textureWidth;
    private final /* synthetic */ CharacterData[] characterBounds;
    private /* synthetic */ int textureHeight;
    
    public boolean hasBounds(final char lllllllllllllIlIllIIIlIlIIIlIlIl) {
        return lllllllllllllIlIllIIIlIlIIIlIlIl >= '\0' && lllllllllllllIlIllIIIlIlIIIlIlIl < '\u0100';
    }
    
    public int getStringWidth(final String lllllllllllllIlIllIIIlIlIIlIIIlI) {
        int lllllllllllllIlIllIIIlIlIIlIIIIl = 0;
        final boolean lllllllllllllIlIllIIIlIlIIIllIIl;
        final float lllllllllllllIlIllIIIlIlIIIllIlI = ((char[])(Object)(lllllllllllllIlIllIIIlIlIIIllIIl = (boolean)(Object)lllllllllllllIlIllIIIlIlIIlIIIlI.toCharArray())).length;
        for (long lllllllllllllIlIllIIIlIlIIIllIll = 0; lllllllllllllIlIllIIIlIlIIIllIll < lllllllllllllIlIllIIIlIlIIIllIlI; ++lllllllllllllIlIllIIIlIlIIIllIll) {
            final char lllllllllllllIlIllIIIlIlIIlIIIII = lllllllllllllIlIllIIIlIlIIIllIIl[lllllllllllllIlIllIIIlIlIIIllIll];
            lllllllllllllIlIllIIIlIlIIlIIIIl += this.characterBounds[lllllllllllllIlIllIIIlIlIIlIIIII].width;
        }
        return lllllllllllllIlIllIIIlIlIIlIIIIl;
    }
    
    public int getTextureHeight() {
        return this.textureHeight;
    }
    
    public boolean hasFont() {
        return this.texId != -1;
    }
    
    public FontData() {
        this.characterBounds = new CharacterData[256];
        this.texId = -1;
        this.fontHeight = 0;
    }
    
    public void bind() {
        GlStateManager.bindTexture(this.texId);
    }
    
    public CharacterData getCharacterBounds(final char lllllllllllllIlIllIIIlIlIIlIllIl) {
        return this.characterBounds[lllllllllllllIlIllIIIlIlIIlIllIl];
    }
    
    public int getFontHeight() {
        return this.fontHeight;
    }
    
    public int getTextureWidth() {
        return this.textureWidth;
    }
    
    private FontData setFont(final Font lllllllllllllIlIllIIIlIlIlIlIIIl, final boolean lllllllllllllIlIllIIIlIlIlIlIIII, final boolean lllllllllllllIlIllIIIlIlIIlllllI, final int lllllllllllllIlIllIIIlIlIIllllIl, final int lllllllllllllIlIllIIIlIlIlIIllIl) {
        if (this.texId == -1) {
            this.texId = GLUtils.getTexture();
        }
        FontMetrics lllllllllllllIlIllIIIlIlIlIIllII = new Canvas().getFontMetrics(lllllllllllllIlIllIIIlIlIlIlIIIl);
        int lllllllllllllIlIllIIIlIlIlIIlIll = 0;
        int lllllllllllllIlIllIIIlIlIlIIlIlI = 0;
        int lllllllllllllIlIllIIIlIlIlIIlIIl = 0;
        for (int lllllllllllllIlIllIIIlIlIlIIlIII = 0; lllllllllllllIlIllIIIlIlIlIIlIII < this.characterBounds.length; ++lllllllllllllIlIllIIIlIlIlIIlIII) {
            final char lllllllllllllIlIllIIIlIlIlIIIlll = (char)lllllllllllllIlIllIIIlIlIlIIlIII;
            final int lllllllllllllIlIllIIIlIlIlIIIllI = lllllllllllllIlIllIIIlIlIlIIllII.getHeight();
            final int lllllllllllllIlIllIIIlIlIlIIIlIl = lllllllllllllIlIllIIIlIlIlIIllII.charWidth(lllllllllllllIlIllIIIlIlIlIIIlll);
            if (lllllllllllllIlIllIIIlIlIlIIlIII != 0 && lllllllllllllIlIllIIIlIlIlIIlIII % lllllllllllllIlIllIIIlIlIIllllIl == 0) {
                lllllllllllllIlIllIIIlIlIlIIlIlI = lllllllllllllIlIllIIIlIlIlIIllIl;
                lllllllllllllIlIllIIIlIlIlIIlIIl += lllllllllllllIlIllIIIlIlIlIIlIll + lllllllllllllIlIllIIIlIlIlIIllIl;
                lllllllllllllIlIllIIIlIlIlIIlIll = 0;
            }
            if (lllllllllllllIlIllIIIlIlIlIIIllI > lllllllllllllIlIllIIIlIlIlIIlIll) {
                lllllllllllllIlIllIIIlIlIlIIlIll = lllllllllllllIlIllIIIlIlIlIIIllI;
                if (lllllllllllllIlIllIIIlIlIlIIlIll > this.fontHeight) {
                    this.fontHeight = lllllllllllllIlIllIIIlIlIlIIlIll;
                }
            }
            this.characterBounds[lllllllllllllIlIllIIIlIlIlIIlIII] = new CharacterData(lllllllllllllIlIllIIIlIlIlIIlIlI, lllllllllllllIlIllIIIlIlIlIIlIIl, lllllllllllllIlIllIIIlIlIlIIIlIl, lllllllllllllIlIllIIIlIlIlIIIllI);
            lllllllllllllIlIllIIIlIlIlIIlIlI += lllllllllllllIlIllIIIlIlIlIIIlIl + lllllllllllllIlIllIIIlIlIlIIllIl;
            if (lllllllllllllIlIllIIIlIlIlIIlIlI + lllllllllllllIlIllIIIlIlIlIIIlIl + lllllllllllllIlIllIIIlIlIlIIllIl > this.textureWidth) {
                this.textureWidth = lllllllllllllIlIllIIIlIlIlIIlIlI + lllllllllllllIlIllIIIlIlIlIIIlIl + lllllllllllllIlIllIIIlIlIlIIllIl;
            }
            if (lllllllllllllIlIllIIIlIlIlIIlIIl + lllllllllllllIlIllIIIlIlIlIIIllI + lllllllllllllIlIllIIIlIlIlIIllIl > this.textureHeight) {
                this.textureHeight = lllllllllllllIlIllIIIlIlIlIIlIIl + lllllllllllllIlIllIIIlIlIlIIIllI + lllllllllllllIlIllIIIlIlIlIIllIl;
            }
        }
        final BufferedImage lllllllllllllIlIllIIIlIlIlIIIlII = new BufferedImage(this.textureWidth, this.textureHeight, 2);
        final Graphics2D lllllllllllllIlIllIIIlIlIlIIIIll = (Graphics2D)lllllllllllllIlIllIIIlIlIlIIIlII.getGraphics();
        lllllllllllllIlIllIIIlIlIlIIIIll.setFont(lllllllllllllIlIllIIIlIlIlIlIIIl);
        lllllllllllllIlIllIIIlIlIlIIllII = lllllllllllllIlIllIIIlIlIlIIIIll.getFontMetrics(lllllllllllllIlIllIIIlIlIlIlIIIl);
        lllllllllllllIlIllIIIlIlIlIIIIll.setColor(new Color(255, 255, 255, 0));
        lllllllllllllIlIllIIIlIlIlIIIIll.fillRect(0, 0, this.textureWidth, this.textureHeight);
        lllllllllllllIlIllIIIlIlIlIIIIll.setColor(Color.WHITE);
        lllllllllllllIlIllIIIlIlIlIIIIll.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, lllllllllllllIlIllIIIlIlIIlllllI ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        lllllllllllllIlIllIIIlIlIlIIIIll.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, lllllllllllllIlIllIIIlIlIlIlIIII ? RenderingHints.VALUE_TEXT_ANTIALIAS_GASP : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        lllllllllllllIlIllIIIlIlIlIIIIll.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, lllllllllllllIlIllIIIlIlIlIlIIII ? RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY : RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
        for (int lllllllllllllIlIllIIIlIlIlIIIIlI = 0; lllllllllllllIlIllIIIlIlIlIIIIlI < this.characterBounds.length; ++lllllllllllllIlIllIIIlIlIlIIIIlI) {
            lllllllllllllIlIllIIIlIlIlIIIIll.drawString(String.valueOf((char)lllllllllllllIlIllIIIlIlIlIIIIlI), this.characterBounds[lllllllllllllIlIllIIIlIlIlIIIIlI].x, this.characterBounds[lllllllllllllIlIllIIIlIlIlIIIIlI].y + lllllllllllllIlIllIIIlIlIlIIllII.getAscent());
        }
        GLUtils.applyTexture(this.texId, lllllllllllllIlIllIIIlIlIlIIIlII, lllllllllllllIlIllIIIlIlIlIlIIII ? 9729 : 9728, 10497);
        return this;
    }
    
    public FontData setFont(final Font lllllllllllllIlIllIIIlIlIllIIlIl, final boolean lllllllllllllIlIllIIIlIlIllIIIIl) {
        return this.setFont(lllllllllllllIlIllIIIlIlIllIIlIl, lllllllllllllIlIllIIIlIlIllIIIIl, lllllllllllllIlIllIIIlIlIllIIIIl, 16, 2);
    }
    
    public class CharacterData
    {
        public final /* synthetic */ int height;
        public final /* synthetic */ int width;
        public final /* synthetic */ int x;
        public final /* synthetic */ int y;
        
        public CharacterData(final int lllllllllllllllIllIIllIIlIlllIIl, final int lllllllllllllllIllIIllIIlIllIIII, final int lllllllllllllllIllIIllIIlIllIllI, final int lllllllllllllllIllIIllIIlIlIllIl) {
            this.x = lllllllllllllllIllIIllIIlIlllIIl;
            this.y = lllllllllllllllIllIIllIIlIllIIII;
            this.width = lllllllllllllllIllIIllIIlIllIllI;
            this.height = lllllllllllllllIllIIllIIlIlIllIl;
        }
    }
}
