package font;

import net.minecraft.client.renderer.*;

public class BasicFontRenderer implements FontRenderer
{
    protected /* synthetic */ int kerning;
    protected final /* synthetic */ FontData fontData;
    
    @Override
    public FontData getFontData() {
        return this.fontData;
    }
    
    public BasicFontRenderer() {
        this.fontData = new FontData();
        this.kerning = 0;
    }
    
    public int getKerning() {
        return this.kerning;
    }
    
    @Override
    public int drawString(final String llIlIIIllIIIlII, final int llIlIIIlIlllllI, final int llIlIIIlIllllIl, final int llIlIIIllIIIIIl) {
        return this.drawString(this.fontData, llIlIIIllIIIlII, llIlIIIlIlllllI, llIlIIIlIllllIl, llIlIIIllIIIIIl);
    }
    
    @Override
    public int drawString(final FontData llIlIIIllIlIllI, final String llIlIIIllIlIlIl, int llIlIIIllIlIlII, final int llIlIIIllIlIIll, final int llIlIIIllIlIIlI) {
        if (!llIlIIIllIlIllI.hasFont()) {
            return 0;
        }
        GlStateManager.enableBlend();
        llIlIIIllIlIllI.bind();
        GLUtils.glColor(llIlIIIllIlIIlI);
        for (int llIlIIIllIllIll = llIlIIIllIlIlIl.length(), llIlIIIllIllIlI = 0; llIlIIIllIllIlI < llIlIIIllIllIll; ++llIlIIIllIllIlI) {
            final char llIlIIIllIllIIl = llIlIIIllIlIlIl.charAt(llIlIIIllIllIlI);
            if (llIlIIIllIlIllI.hasBounds(llIlIIIllIllIIl)) {
                final FontData.CharacterData llIlIIIllIllIII = llIlIIIllIlIllI.getCharacterBounds(llIlIIIllIllIIl);
                FontUtils.drawTextureRect((float)llIlIIIllIlIlII, (float)llIlIIIllIlIIll, (float)llIlIIIllIllIII.width, (float)llIlIIIllIllIII.height, llIlIIIllIllIII.x / (float)llIlIIIllIlIllI.getTextureWidth(), llIlIIIllIllIII.y / (float)llIlIIIllIlIllI.getTextureHeight(), (llIlIIIllIllIII.x + llIlIIIllIllIII.width) / (float)llIlIIIllIlIllI.getTextureWidth(), (llIlIIIllIllIII.y + llIlIIIllIllIII.height) / (float)llIlIIIllIlIllI.getTextureHeight());
                llIlIIIllIlIlII += llIlIIIllIllIII.width + this.kerning;
            }
        }
        return llIlIIIllIlIlII;
    }
    
    public void setKerning(final int llIlIIIlIllIIll) {
        this.kerning = llIlIIIlIllIIll;
    }
    
    public int getHeight() {
        return this.fontData.getFontHeight();
    }
}
