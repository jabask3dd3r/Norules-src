package me.nrules.font;

import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import java.awt.*;
import java.util.*;
import me.nrules.utils.render.*;

public class CFontRenderer extends CFont
{
    protected /* synthetic */ DynamicTexture texItalicBold;
    protected /* synthetic */ CharData[] boldItalicChars;
    protected /* synthetic */ CharData[] italicChars;
    private /* synthetic */ float[] charWidthFloat;
    private final /* synthetic */ byte[] glyphWidth;
    protected /* synthetic */ DynamicTexture texBold;
    protected /* synthetic */ DynamicTexture texItalic;
    private final /* synthetic */ int[] colorCode;
    private final /* synthetic */ int[] charWidth;
    protected /* synthetic */ CharData[] boldChars;
    
    public void drawTotalCenteredStringWithShadow(final String lllllllllllllIIIIIIIlllIIIlIIIll, final double lllllllllllllIIIIIIIlllIIIlIIIlI, final double lllllllllllllIIIIIIIlllIIIlIIllI, final int lllllllllllllIIIIIIIlllIIIlIIIII) {
        this.drawStringWithShadow(lllllllllllllIIIIIIIlllIIIlIIIll, lllllllllllllIIIIIIIlllIIIlIIIlI - this.getStringWidth(lllllllllllllIIIIIIIlllIIIlIIIll) / 2.0f, lllllllllllllIIIIIIIlllIIIlIIllI - this.getStringHeight(lllllllllllllIIIIIIIlllIIIlIIIll) / 2.0f, lllllllllllllIIIIIIIlllIIIlIIIII);
    }
    
    public String trimStringToWidth(final String lllllllllllllIIIIIIIllIlllllIIIl, final int lllllllllllllIIIIIIIllIlllllIIII) {
        return this.trimStringToWidth(lllllllllllllIIIIIIIllIlllllIIIl, lllllllllllllIIIIIIIllIlllllIIII, false);
    }
    
    public float drawString(final String lllllllllllllIIIIIIIllIlllIIlllI, double lllllllllllllIIIIIIIllIllIlllIll, double lllllllllllllIIIIIIIllIllIlllIlI, int lllllllllllllIIIIIIIllIllIlllIIl, final boolean lllllllllllllIIIIIIIllIlllIIlIlI) {
        --lllllllllllllIIIIIIIllIllIlllIll;
        if (lllllllllllllIIIIIIIllIlllIIlllI == null) {
            return 0.0f;
        }
        if (lllllllllllllIIIIIIIllIllIlllIIl == 553648127) {
            lllllllllllllIIIIIIIllIllIlllIIl = 16777215;
        }
        if ((lllllllllllllIIIIIIIllIllIlllIIl & 0xFC000000) == 0x0) {
            lllllllllllllIIIIIIIllIllIlllIIl |= 0xFF000000;
        }
        if (lllllllllllllIIIIIIIllIlllIIlIlI) {
            lllllllllllllIIIIIIIllIllIlllIIl = ((lllllllllllllIIIIIIIllIllIlllIIl & 0xFCFCFC) >> 2 | (lllllllllllllIIIIIIIllIllIlllIIl & new Color(20, 20, 20, 200).getRGB()));
        }
        CharData[] lllllllllllllIIIIIIIllIlllIIlIIl = this.charData;
        final float lllllllllllllIIIIIIIllIlllIIlIII = (lllllllllllllIIIIIIIllIllIlllIIl >> 24 & 0xFF) / 255.0f;
        boolean lllllllllllllIIIIIIIllIlllIIIlll = false;
        boolean lllllllllllllIIIIIIIllIlllIIIllI = false;
        boolean lllllllllllllIIIIIIIllIlllIIIlIl = false;
        boolean lllllllllllllIIIIIIIllIlllIIIlII = false;
        lllllllllllllIIIIIIIllIllIlllIll *= (long)2.0;
        lllllllllllllIIIIIIIllIllIlllIlI = (lllllllllllllIIIIIIIllIllIlllIlI - 3.0) * 2.0;
        GL11.glPushMatrix();
        GlStateManager.scale(0.5, 0.5, 0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.color((lllllllllllllIIIIIIIllIllIlllIIl >> 16 & 0xFF) / 255.0f, (lllllllllllllIIIIIIIllIllIlllIIl >> 8 & 0xFF) / 255.0f, (lllllllllllllIIIIIIIllIllIlllIIl & 0xFF) / 255.0f, lllllllllllllIIIIIIIllIlllIIlIII);
        final int lllllllllllllIIIIIIIllIlllIIIIll = lllllllllllllIIIIIIIllIlllIIlllI.length();
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture(this.tex.getGlTextureId());
        GL11.glBindTexture(3553, this.tex.getGlTextureId());
        for (int lllllllllllllIIIIIIIllIlllIIIIlI = 0; lllllllllllllIIIIIIIllIlllIIIIlI < lllllllllllllIIIIIIIllIlllIIIIll; ++lllllllllllllIIIIIIIllIlllIIIIlI) {
            final char lllllllllllllIIIIIIIllIlllIIIIIl = lllllllllllllIIIIIIIllIlllIIlllI.charAt(lllllllllllllIIIIIIIllIlllIIIIlI);
            if (String.valueOf(lllllllllllllIIIIIIIllIlllIIIIIl).equals("з")) {
                int lllllllllllllIIIIIIIllIlllIIIIII = 21;
                try {
                    lllllllllllllIIIIIIIllIlllIIIIII = "0123456789abcdefklmnor".indexOf(lllllllllllllIIIIIIIllIlllIIlllI.charAt(lllllllllllllIIIIIIIllIlllIIIIlI + 1));
                }
                catch (Exception lllllllllllllIIIIIIIllIllIllllll) {
                    lllllllllllllIIIIIIIllIllIllllll.printStackTrace();
                }
                if (lllllllllllllIIIIIIIllIlllIIIIII < 16) {
                    lllllllllllllIIIIIIIllIlllIIIlll = false;
                    lllllllllllllIIIIIIIllIlllIIIllI = false;
                    lllllllllllllIIIIIIIllIlllIIIlII = false;
                    lllllllllllllIIIIIIIllIlllIIIlIl = false;
                    GlStateManager.bindTexture(this.tex.getGlTextureId());
                    lllllllllllllIIIIIIIllIlllIIlIIl = this.charData;
                    if (lllllllllllllIIIIIIIllIlllIIIIII < 0) {
                        lllllllllllllIIIIIIIllIlllIIIIII = 15;
                    }
                    if (lllllllllllllIIIIIIIllIlllIIlIlI) {
                        lllllllllllllIIIIIIIllIlllIIIIII += 16;
                    }
                    final int lllllllllllllIIIIIIIllIllIlllllI = this.colorCode[lllllllllllllIIIIIIIllIlllIIIIII];
                    GlStateManager.color((lllllllllllllIIIIIIIllIllIlllllI >> 16 & 0xFF) / 255.0f, (lllllllllllllIIIIIIIllIllIlllllI >> 8 & 0xFF) / 255.0f, (lllllllllllllIIIIIIIllIllIlllllI & 0xFF) / 255.0f, lllllllllllllIIIIIIIllIlllIIlIII);
                }
                else if (lllllllllllllIIIIIIIllIlllIIIIII == 17) {
                    lllllllllllllIIIIIIIllIlllIIIlll = true;
                    if (lllllllllllllIIIIIIIllIlllIIIllI) {
                        GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                        lllllllllllllIIIIIIIllIlllIIlIIl = this.boldItalicChars;
                    }
                    else {
                        GlStateManager.bindTexture(this.texBold.getGlTextureId());
                        lllllllllllllIIIIIIIllIlllIIlIIl = this.boldChars;
                    }
                }
                else if (lllllllllllllIIIIIIIllIlllIIIIII == 18) {
                    lllllllllllllIIIIIIIllIlllIIIlIl = true;
                }
                else if (lllllllllllllIIIIIIIllIlllIIIIII == 19) {
                    lllllllllllllIIIIIIIllIlllIIIlII = true;
                }
                else if (lllllllllllllIIIIIIIllIlllIIIIII == 20) {
                    lllllllllllllIIIIIIIllIlllIIIllI = true;
                    if (lllllllllllllIIIIIIIllIlllIIIlll) {
                        GlStateManager.bindTexture(this.texItalicBold.getGlTextureId());
                        lllllllllllllIIIIIIIllIlllIIlIIl = this.boldItalicChars;
                    }
                    else {
                        GlStateManager.bindTexture(this.texItalic.getGlTextureId());
                        lllllllllllllIIIIIIIllIlllIIlIIl = this.italicChars;
                    }
                }
                else if (lllllllllllllIIIIIIIllIlllIIIIII == 21) {
                    lllllllllllllIIIIIIIllIlllIIIlll = false;
                    lllllllllllllIIIIIIIllIlllIIIllI = false;
                    lllllllllllllIIIIIIIllIlllIIIlII = false;
                    lllllllllllllIIIIIIIllIlllIIIlIl = false;
                    GlStateManager.color((lllllllllllllIIIIIIIllIllIlllIIl >> 16 & 0xFF) / 255.0f, (lllllllllllllIIIIIIIllIllIlllIIl >> 8 & 0xFF) / 255.0f, (lllllllllllllIIIIIIIllIllIlllIIl & 0xFF) / 255.0f, lllllllllllllIIIIIIIllIlllIIlIII);
                    GlStateManager.bindTexture(this.tex.getGlTextureId());
                    lllllllllllllIIIIIIIllIlllIIlIIl = this.charData;
                }
                ++lllllllllllllIIIIIIIllIlllIIIIlI;
            }
            else if (lllllllllllllIIIIIIIllIlllIIIIIl < lllllllllllllIIIIIIIllIlllIIlIIl.length) {
                GL11.glBegin(4);
                this.drawChar(lllllllllllllIIIIIIIllIlllIIlIIl, lllllllllllllIIIIIIIllIlllIIIIIl, (float)lllllllllllllIIIIIIIllIllIlllIll, (float)lllllllllllllIIIIIIIllIllIlllIlI);
                GL11.glEnd();
                if (lllllllllllllIIIIIIIllIlllIIIlIl) {
                    this.drawLine((double)lllllllllllllIIIIIIIllIllIlllIll, lllllllllllllIIIIIIIllIllIlllIlI + lllllllllllllIIIIIIIllIlllIIlIIl[lllllllllllllIIIIIIIllIlllIIIIIl].height / 2.0f, lllllllllllllIIIIIIIllIllIlllIll + (double)lllllllllllllIIIIIIIllIlllIIlIIl[lllllllllllllIIIIIIIllIlllIIIIIl].width - 8.0, lllllllllllllIIIIIIIllIllIlllIlI + lllllllllllllIIIIIIIllIlllIIlIIl[lllllllllllllIIIIIIIllIlllIIIIIl].height / 2.0f, 1.0f);
                }
                if (lllllllllllllIIIIIIIllIlllIIIlII) {
                    this.drawLine((double)lllllllllllllIIIIIIIllIllIlllIll, lllllllllllllIIIIIIIllIllIlllIlI + lllllllllllllIIIIIIIllIlllIIlIIl[lllllllllllllIIIIIIIllIlllIIIIIl].height - 2.0, lllllllllllllIIIIIIIllIllIlllIll + (double)lllllllllllllIIIIIIIllIlllIIlIIl[lllllllllllllIIIIIIIllIlllIIIIIl].width - 8.0, lllllllllllllIIIIIIIllIllIlllIlI + lllllllllllllIIIIIIIllIlllIIlIIl[lllllllllllllIIIIIIIllIlllIIIIIl].height - 2.0, 1.0f);
                }
                lllllllllllllIIIIIIIllIllIlllIll += lllllllllllllIIIIIIIllIlllIIlIIl[lllllllllllllIIIIIIIllIlllIIIIIl].width - 8 + this.charOffset;
            }
        }
        GL11.glPopMatrix();
        return lllllllllllllIIIIIIIllIllIlllIll / 2.0f;
    }
    
    public float drawCenteredString(final String lllllllllllllIIIIIIIlllIIIllIIlI, final double lllllllllllllIIIIIIIlllIIIllIllI, final double lllllllllllllIIIIIIIlllIIIllIlIl, final int lllllllllllllIIIIIIIlllIIIllIlII) {
        return this.drawString(lllllllllllllIIIIIIIlllIIIllIIlI, lllllllllllllIIIIIIIlllIIIllIllI - this.getStringWidth(lllllllllllllIIIIIIIlllIIIllIIlI) / 2, lllllllllllllIIIIIIIlllIIIllIlIl, lllllllllllllIIIIIIIlllIIIllIlII);
    }
    
    private void setupMinecraftColorcodes() {
        for (int lllllllllllllIIIIIIIllIIlIIllIll = 0; lllllllllllllIIIIIIIllIIlIIllIll < 32; ++lllllllllllllIIIIIIIllIIlIIllIll) {
            final int lllllllllllllIIIIIIIllIIlIIllIlI = (lllllllllllllIIIIIIIllIIlIIllIll >> 3 & 0x1) * 85;
            int lllllllllllllIIIIIIIllIIlIIllIIl = (lllllllllllllIIIIIIIllIIlIIllIll >> 2 & 0x1) * 170 + lllllllllllllIIIIIIIllIIlIIllIlI;
            int lllllllllllllIIIIIIIllIIlIIllIII = (lllllllllllllIIIIIIIllIIlIIllIll >> 1 & 0x1) * 170 + lllllllllllllIIIIIIIllIIlIIllIlI;
            int lllllllllllllIIIIIIIllIIlIIlIlll = (lllllllllllllIIIIIIIllIIlIIllIll >> 0 & 0x1) * 170 + lllllllllllllIIIIIIIllIIlIIllIlI;
            if (lllllllllllllIIIIIIIllIIlIIllIll == 6) {
                lllllllllllllIIIIIIIllIIlIIllIIl += 85;
            }
            if (lllllllllllllIIIIIIIllIIlIIllIll >= 16) {
                lllllllllllllIIIIIIIllIIlIIllIIl /= 4;
                lllllllllllllIIIIIIIllIIlIIllIII /= 4;
                lllllllllllllIIIIIIIllIIlIIlIlll /= 4;
            }
            this.colorCode[lllllllllllllIIIIIIIllIIlIIllIll] = ((lllllllllllllIIIIIIIllIIlIIllIIl & 0xFF) << 16 | (lllllllllllllIIIIIIIllIIlIIllIII & 0xFF) << 8 | (lllllllllllllIIIIIIIllIIlIIlIlll & 0xFF));
        }
    }
    
    public CFontRenderer(final Font lllllllllllllIIIIIIIlllIIlllIIII, final boolean lllllllllllllIIIIIIIlllIIlllIIll, final boolean lllllllllllllIIIIIIIlllIIlllIIlI) {
        super(lllllllllllllIIIIIIIlllIIlllIIII, lllllllllllllIIIIIIIlllIIlllIIll, lllllllllllllIIIIIIIlllIIlllIIlI);
        this.boldChars = new CharData[167];
        this.italicChars = new CharData[167];
        this.boldItalicChars = new CharData[167];
        this.charWidthFloat = new float[256];
        this.glyphWidth = new byte[65536];
        this.charWidth = new int[256];
        this.colorCode = new int[32];
        this.setupMinecraftColorcodes();
        this.setupBoldItalicIDs();
    }
    
    public void drawTotalCenteredString(final String lllllllllllllIIIIIIIlllIIIIIIlIl, final double lllllllllllllIIIIIIIlllIIIIIlIIl, final double lllllllllllllIIIIIIIlllIIIIIIIll, final int lllllllllllllIIIIIIIlllIIIIIIIlI) {
        this.drawString(lllllllllllllIIIIIIIlllIIIIIIlIl, lllllllllllllIIIIIIIlllIIIIIlIIl - this.getStringWidth(lllllllllllllIIIIIIIlllIIIIIIlIl) / 2.0f, lllllllllllllIIIIIIIlllIIIIIIIll - this.getStringHeight(lllllllllllllIIIIIIIlllIIIIIIlIl) / 2.0f, lllllllllllllIIIIIIIlllIIIIIIIlI);
    }
    
    private void drawLine(final double lllllllllllllIIIIIIIllIlIllIlllI, final double lllllllllllllIIIIIIIllIlIllIllIl, final double lllllllllllllIIIIIIIllIlIllIllII, final double lllllllllllllIIIIIIIllIlIllIlIll, final float lllllllllllllIIIIIIIllIlIllIllll) {
        GL11.glDisable(3553);
        GL11.glLineWidth(lllllllllllllIIIIIIIllIlIllIllll);
        GL11.glBegin(1);
        GL11.glVertex2d(lllllllllllllIIIIIIIllIlIllIlllI, lllllllllllllIIIIIIIllIlIllIllIl);
        GL11.glVertex2d(lllllllllllllIIIIIIIllIlIllIllII, lllllllllllllIIIIIIIllIlIllIlIll);
        GL11.glEnd();
        GL11.glEnable(3553);
    }
    
    public static String getFormatFromString(final String lllllllllllllIIIIIIIllIlIIIIlIIl) {
        String lllllllllllllIIIIIIIllIlIIIIlIII = "";
        int lllllllllllllIIIIIIIllIlIIIIIlll = -1;
        final int lllllllllllllIIIIIIIllIlIIIIIllI = lllllllllllllIIIIIIIllIlIIIIlIIl.length();
        while ((lllllllllllllIIIIIIIllIlIIIIIlll = lllllllllllllIIIIIIIllIlIIIIlIIl.indexOf(167, lllllllllllllIIIIIIIllIlIIIIIlll + 1)) != -1) {
            if (lllllllllllllIIIIIIIllIlIIIIIlll < lllllllllllllIIIIIIIllIlIIIIIllI - 1) {
                final char lllllllllllllIIIIIIIllIlIIIIIlIl = lllllllllllllIIIIIIIllIlIIIIlIIl.charAt(lllllllllllllIIIIIIIllIlIIIIIlll + 1);
                if (isFormatColor(lllllllllllllIIIIIIIllIlIIIIIlIl)) {
                    lllllllllllllIIIIIIIllIlIIIIlIII = String.valueOf(new StringBuilder("з").append(lllllllllllllIIIIIIIllIlIIIIIlIl));
                }
                else {
                    if (!isFormatSpecial(lllllllllllllIIIIIIIllIlIIIIIlIl)) {
                        continue;
                    }
                    lllllllllllllIIIIIIIllIlIIIIlIII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIIIllIlIIIIlIII)).append("з").append(lllllllllllllIIIIIIIllIlIIIIIlIl));
                }
            }
        }
        return lllllllllllllIIIIIIIllIlIIIIlIII;
    }
    
    @Override
    public int getStringWidth(final String lllllllllllllIIIIIIIllIllIIlIlll) {
        if (lllllllllllllIIIIIIIllIllIIlIlll == null) {
            return 0;
        }
        int lllllllllllllIIIIIIIllIllIlIIIII = 0;
        CharData[] lllllllllllllIIIIIIIllIllIIlllll = this.charData;
        boolean lllllllllllllIIIIIIIllIllIIllllI = false;
        boolean lllllllllllllIIIIIIIllIllIIlllIl = false;
        for (int lllllllllllllIIIIIIIllIllIIlllII = lllllllllllllIIIIIIIllIllIIlIlll.length(), lllllllllllllIIIIIIIllIllIIllIll = 0; lllllllllllllIIIIIIIllIllIIllIll < lllllllllllllIIIIIIIllIllIIlllII; ++lllllllllllllIIIIIIIllIllIIllIll) {
            final char lllllllllllllIIIIIIIllIllIIllIlI = lllllllllllllIIIIIIIllIllIIlIlll.charAt(lllllllllllllIIIIIIIllIllIIllIll);
            if (lllllllllllllIIIIIIIllIllIIllIlI == 'з' && lllllllllllllIIIIIIIllIllIIllIll < lllllllllllllIIIIIIIllIllIIlllII) {
                final int lllllllllllllIIIIIIIllIllIIllIIl = "0123456789abcdefklmnor".indexOf(lllllllllllllIIIIIIIllIllIIllIlI);
                if (lllllllllllllIIIIIIIllIllIIllIIl < 16) {
                    lllllllllllllIIIIIIIllIllIIllllI = false;
                    lllllllllllllIIIIIIIllIllIIlllIl = false;
                }
                else if (lllllllllllllIIIIIIIllIllIIllIIl == 17) {
                    lllllllllllllIIIIIIIllIllIIllllI = true;
                    if (lllllllllllllIIIIIIIllIllIIlllIl) {
                        lllllllllllllIIIIIIIllIllIIlllll = this.boldItalicChars;
                    }
                    else {
                        lllllllllllllIIIIIIIllIllIIlllll = this.boldChars;
                    }
                }
                else if (lllllllllllllIIIIIIIllIllIIllIIl == 20) {
                    lllllllllllllIIIIIIIllIllIIlllIl = true;
                    if (lllllllllllllIIIIIIIllIllIIllllI) {
                        lllllllllllllIIIIIIIllIllIIlllll = this.boldItalicChars;
                    }
                    else {
                        lllllllllllllIIIIIIIllIllIIlllll = this.italicChars;
                    }
                }
                else if (lllllllllllllIIIIIIIllIllIIllIIl == 21) {
                    lllllllllllllIIIIIIIllIllIIllllI = false;
                    lllllllllllllIIIIIIIllIllIIlllIl = false;
                    lllllllllllllIIIIIIIllIllIIlllll = this.charData;
                }
                ++lllllllllllllIIIIIIIllIllIIllIll;
            }
            else if (lllllllllllllIIIIIIIllIllIIllIlI < lllllllllllllIIIIIIIllIllIIlllll.length && lllllllllllllIIIIIIIllIllIIllIlI >= '\0') {
                lllllllllllllIIIIIIIllIllIlIIIII += lllllllllllllIIIIIIIllIllIIlllll[lllllllllllllIIIIIIIllIllIIllIlI].width - 8 + this.charOffset;
            }
        }
        return lllllllllllllIIIIIIIllIllIlIIIII / 2;
    }
    
    @Override
    public void setFractionalMetrics(final boolean lllllllllllllIIIIIIIllIlIlllllIl) {
        super.setFractionalMetrics(lllllllllllllIIIIIIIllIlIlllllIl);
        this.setupBoldItalicIDs();
    }
    
    public float drawStringWithShadow(final String lllllllllllllIIIIIIIlllIIlIlIIIl, final double lllllllllllllIIIIIIIlllIIlIlIIII, final double lllllllllllllIIIIIIIlllIIlIlIlIl, final int lllllllllllllIIIIIIIlllIIlIlIlII) {
        final float lllllllllllllIIIIIIIlllIIlIlIIll = this.drawString(lllllllllllllIIIIIIIlllIIlIlIIIl, lllllllllllllIIIIIIIlllIIlIlIIII + 0.5, lllllllllllllIIIIIIIlllIIlIlIlIl + 0.5, lllllllllllllIIIIIIIlllIIlIlIlII, true);
        return Math.max(lllllllllllllIIIIIIIlllIIlIlIIll, this.drawString(lllllllllllllIIIIIIIlllIIlIlIIIl, lllllllllllllIIIIIIIlllIIlIlIIII, lllllllllllllIIIIIIIlllIIlIlIlIl, lllllllllllllIIIIIIIlllIIlIlIlII, false));
    }
    
    public List<String> listFormattedStringToWidth(final String lllllllllllllIIIIIIIllIllllllIlI, final int lllllllllllllIIIIIIIllIllllllIIl) {
        return Arrays.asList(this.wrapFormattedStringToWidth(lllllllllllllIIIIIIIllIllllllIlI, lllllllllllllIIIIIIIllIllllllIIl).split("\n"));
    }
    
    public List<String> wrapWords(final String lllllllllllllIIIIIIIllIlIlIIllIl, final double lllllllllllllIIIIIIIllIlIlIllIlI) {
        final List lllllllllllllIIIIIIIllIlIlIllIIl = new ArrayList();
        if (this.getStringWidth(lllllllllllllIIIIIIIllIlIlIIllIl) > lllllllllllllIIIIIIIllIlIlIllIlI) {
            final String[] lllllllllllllIIIIIIIllIlIlIllIII = lllllllllllllIIIIIIIllIlIlIIllIl.split(" ");
            String lllllllllllllIIIIIIIllIlIlIlIlll = "";
            char lllllllllllllIIIIIIIllIlIlIlIllI = '\uffff';
            String[] lllllllllllllIIIIIIIllIlIlIlIlIl;
            for (int lllllllllllllIIIIIIIllIlIlIlIlII = (lllllllllllllIIIIIIIllIlIlIlIlIl = lllllllllllllIIIIIIIllIlIlIllIII).length, lllllllllllllIIIIIIIllIlIlIlIIll = 0; lllllllllllllIIIIIIIllIlIlIlIIll < lllllllllllllIIIIIIIllIlIlIlIlII; ++lllllllllllllIIIIIIIllIlIlIlIIll) {
                final String lllllllllllllIIIIIIIllIlIlIlIIlI = lllllllllllllIIIIIIIllIlIlIlIlIl[lllllllllllllIIIIIIIllIlIlIlIIll];
                final int lllllllllllllIIIIIIIllIlIlIlIIIl = 0;
                while (lllllllllllllIIIIIIIllIlIlIlIIll < lllllllllllllIIIIIIIllIlIlIlIIlI.toCharArray().length) {
                    final char lllllllllllllIIIIIIIllIlIlIlIIII = lllllllllllllIIIIIIIllIlIlIlIIlI.toCharArray()[lllllllllllllIIIIIIIllIlIlIlIIll];
                    if (lllllllllllllIIIIIIIllIlIlIlIIII == 'з' && lllllllllllllIIIIIIIllIlIlIlIIll < lllllllllllllIIIIIIIllIlIlIlIIlI.toCharArray().length - 1) {
                        lllllllllllllIIIIIIIllIlIlIlIllI = lllllllllllllIIIIIIIllIlIlIlIIlI.toCharArray()[lllllllllllllIIIIIIIllIlIlIlIIll + 1];
                    }
                    ++lllllllllllllIIIIIIIllIlIlIlIIll;
                }
                if (this.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIIIllIlIlIlIlll)).append(lllllllllllllIIIIIIIllIlIlIlIIlI).append(" "))) < lllllllllllllIIIIIIIllIlIlIllIlI) {
                    lllllllllllllIIIIIIIllIlIlIlIlll = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIIIllIlIlIlIlll)).append(lllllllllllllIIIIIIIllIlIlIlIIlI).append(" "));
                }
                else {
                    lllllllllllllIIIIIIIllIlIlIllIIl.add(lllllllllllllIIIIIIIllIlIlIlIlll);
                    lllllllllllllIIIIIIIllIlIlIlIlll = String.valueOf(new StringBuilder(String.valueOf('з' + lllllllllllllIIIIIIIllIlIlIlIllI)).append(lllllllllllllIIIIIIIllIlIlIlIIlI).append(" "));
                }
            }
            if (lllllllllllllIIIIIIIllIlIlIlIlll.length() > 0) {
                if (this.getStringWidth(lllllllllllllIIIIIIIllIlIlIlIlll) < lllllllllllllIIIIIIIllIlIlIllIlI) {
                    lllllllllllllIIIIIIIllIlIlIllIIl.add(String.valueOf(new StringBuilder(String.valueOf('з' + lllllllllllllIIIIIIIllIlIlIlIllI)).append(lllllllllllllIIIIIIIllIlIlIlIlll).append(" ")));
                    lllllllllllllIIIIIIIllIlIlIlIlll = "";
                }
                else {
                    for (final String lllllllllllllIIIIIIIllIlIlIIllll : this.formatString(lllllllllllllIIIIIIIllIlIlIlIlll, lllllllllllllIIIIIIIllIlIlIllIlI)) {
                        lllllllllllllIIIIIIIllIlIlIllIIl.add(lllllllllllllIIIIIIIllIlIlIIllll);
                    }
                }
            }
        }
        else {
            lllllllllllllIIIIIIIllIlIlIllIIl.add(lllllllllllllIIIIIIIllIlIlIIllIl);
        }
        return (List<String>)lllllllllllllIIIIIIIllIlIlIllIIl;
    }
    
    private void setupBoldItalicIDs() {
        this.texBold = this.setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
        this.texItalic = this.setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
    }
    
    @Override
    public void setAntiAlias(final boolean lllllllllllllIIIIIIIllIllIIIIIll) {
        super.setAntiAlias(lllllllllllllIIIIIIIllIllIIIIIll);
        this.setupBoldItalicIDs();
    }
    
    private float getCharWidthFloat(final char lllllllllllllIIIIIIIllIIllIllIlI) {
        if (lllllllllllllIIIIIIIllIIllIllIlI == 'з') {
            return -1.0f;
        }
        if (lllllllllllllIIIIIIIllIIllIllIlI == ' ' || lllllllllllllIIIIIIIllIIllIllIlI == 'а') {
            return this.charWidthFloat[32];
        }
        final int lllllllllllllIIIIIIIllIIllIllIIl = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???ом???л╗\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261▒\u2265\u2264\u2320\u2321\u00f7\u2248░\u2219╖\u221a\u207f?\u25a0\u0000".indexOf(lllllllllllllIIIIIIIllIIllIllIlI);
        if (lllllllllllllIIIIIIIllIIllIllIlI > '\0' && lllllllllllllIIIIIIIllIIllIllIIl != -1) {
            return this.charWidthFloat[lllllllllllllIIIIIIIllIIllIllIIl];
        }
        if (this.glyphWidth[lllllllllllllIIIIIIIllIIllIllIlI] != 0) {
            final int lllllllllllllIIIIIIIllIIllIllIII = this.glyphWidth[lllllllllllllIIIIIIIllIIllIllIlI] & 0xFF;
            final int lllllllllllllIIIIIIIllIIllIlIlll = lllllllllllllIIIIIIIllIIllIllIII >>> 4;
            int lllllllllllllIIIIIIIllIIllIlIllI = lllllllllllllIIIIIIIllIIllIllIII & 0xF;
            return (float)((++lllllllllllllIIIIIIIllIIllIlIllI - lllllllllllllIIIIIIIllIIllIlIlll) / 2 + 1);
        }
        return 0.0f;
    }
    
    public String trimStringToWidth(final String lllllllllllllIIIIIIIllIIllIIIIIl, final int lllllllllllllIIIIIIIllIIllIIIIII, final boolean lllllllllllllIIIIIIIllIIlIllllll) {
        final StringBuilder lllllllllllllIIIIIIIllIIlIlllllI = new StringBuilder();
        float lllllllllllllIIIIIIIllIIlIllllIl = 0.0f;
        final int lllllllllllllIIIIIIIllIIlIllllII = lllllllllllllIIIIIIIllIIlIllllll ? (lllllllllllllIIIIIIIllIIllIIIIIl.length() - 1) : 0;
        final int lllllllllllllIIIIIIIllIIlIlllIll = lllllllllllllIIIIIIIllIIlIllllll ? -1 : 1;
        boolean lllllllllllllIIIIIIIllIIlIlllIlI = false;
        boolean lllllllllllllIIIIIIIllIIlIlllIIl = false;
        for (int lllllllllllllIIIIIIIllIIlIlllIII = lllllllllllllIIIIIIIllIIlIllllII; lllllllllllllIIIIIIIllIIlIlllIII >= 0 && lllllllllllllIIIIIIIllIIlIlllIII < lllllllllllllIIIIIIIllIIllIIIIIl.length() && lllllllllllllIIIIIIIllIIlIllllIl < lllllllllllllIIIIIIIllIIllIIIIII; lllllllllllllIIIIIIIllIIlIlllIII += lllllllllllllIIIIIIIllIIlIlllIll) {
            final char lllllllllllllIIIIIIIllIIlIllIlll = lllllllllllllIIIIIIIllIIllIIIIIl.charAt(lllllllllllllIIIIIIIllIIlIlllIII);
            final float lllllllllllllIIIIIIIllIIlIllIllI = this.getCharWidthFloat(lllllllllllllIIIIIIIllIIlIllIlll);
            if (lllllllllllllIIIIIIIllIIlIlllIlI) {
                lllllllllllllIIIIIIIllIIlIlllIlI = false;
                if (lllllllllllllIIIIIIIllIIlIllIlll != 'l' && lllllllllllllIIIIIIIllIIlIllIlll != 'L') {
                    if (lllllllllllllIIIIIIIllIIlIllIlll == 'r' || lllllllllllllIIIIIIIllIIlIllIlll == 'R') {
                        lllllllllllllIIIIIIIllIIlIlllIIl = false;
                    }
                }
                else {
                    lllllllllllllIIIIIIIllIIlIlllIIl = true;
                }
            }
            else if (lllllllllllllIIIIIIIllIIlIllIllI < 0.0f) {
                lllllllllllllIIIIIIIllIIlIlllIlI = true;
            }
            else {
                lllllllllllllIIIIIIIllIIlIllllIl += lllllllllllllIIIIIIIllIIlIllIllI;
                if (lllllllllllllIIIIIIIllIIlIlllIIl) {
                    ++lllllllllllllIIIIIIIllIIlIllllIl;
                }
            }
            if (lllllllllllllIIIIIIIllIIlIllllIl > lllllllllllllIIIIIIIllIIllIIIIII) {
                break;
            }
            if (lllllllllllllIIIIIIIllIIlIllllll) {
                lllllllllllllIIIIIIIllIIlIlllllI.insert(0, lllllllllllllIIIIIIIllIIlIllIlll);
            }
            else {
                lllllllllllllIIIIIIIllIIlIlllllI.append(lllllllllllllIIIIIIIllIIlIllIlll);
            }
        }
        return String.valueOf(lllllllllllllIIIIIIIllIIlIlllllI);
    }
    
    String wrapFormattedStringToWidth(final String lllllllllllllIIIIIIIllIlIIIlllIl, final int lllllllllllllIIIIIIIllIlIIIlllII) {
        if (lllllllllllllIIIIIIIllIlIIIlllIl.length() <= 1) {
            return lllllllllllllIIIIIIIllIlIIIlllIl;
        }
        final int lllllllllllllIIIIIIIllIlIIIllIll = this.sizeStringToWidth(lllllllllllllIIIIIIIllIlIIIlllIl, lllllllllllllIIIIIIIllIlIIIlllII);
        if (lllllllllllllIIIIIIIllIlIIIlllIl.length() <= lllllllllllllIIIIIIIllIlIIIllIll) {
            return lllllllllllllIIIIIIIllIlIIIlllIl;
        }
        final String lllllllllllllIIIIIIIllIlIIIllIlI = lllllllllllllIIIIIIIllIlIIIlllIl.substring(0, lllllllllllllIIIIIIIllIlIIIllIll);
        final char lllllllllllllIIIIIIIllIlIIIllIIl = lllllllllllllIIIIIIIllIlIIIlllIl.charAt(lllllllllllllIIIIIIIllIlIIIllIll);
        final boolean lllllllllllllIIIIIIIllIlIIIllIII = lllllllllllllIIIIIIIllIlIIIllIIl == ' ' || lllllllllllllIIIIIIIllIlIIIllIIl == '\n';
        final String lllllllllllllIIIIIIIllIlIIIlIlll = String.valueOf(new StringBuilder(String.valueOf(getFormatFromString(lllllllllllllIIIIIIIllIlIIIllIlI))).append(lllllllllllllIIIIIIIllIlIIIlllIl.substring(lllllllllllllIIIIIIIllIlIIIllIll + (lllllllllllllIIIIIIIllIlIIIllIII ? 1 : 0))));
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIIIllIlIIIllIlI)).append("\n").append(this.wrapFormattedStringToWidth(lllllllllllllIIIIIIIllIlIIIlIlll, lllllllllllllIIIIIIIllIlIIIlllII)));
    }
    
    private static boolean isFormatSpecial(final char lllllllllllllIIIIIIIllIIlIlIIlll) {
        return (lllllllllllllIIIIIIIllIIlIlIIlll >= 'k' && lllllllllllllIIIIIIIllIIlIlIIlll <= 'o') || (lllllllllllllIIIIIIIllIIlIlIIlll >= 'K' && lllllllllllllIIIIIIIllIIlIlIIlll <= 'O') || lllllllllllllIIIIIIIllIIlIlIIlll == 'r' || lllllllllllllIIIIIIIllIIlIlIIlll == 'R';
    }
    
    public void drawBorderedString(final String lllllllllllllIIIIIIIllIllllIlIIl, final double lllllllllllllIIIIIIIllIllllIIIll, final double lllllllllllllIIIIIIIllIllllIIlll, final int lllllllllllllIIIIIIIllIllllIIllI) {
        GlStateManager.pushMatrix();
        GL11.glTranslated(0.5, 0.0, 0.0);
        this.drawString(lllllllllllllIIIIIIIllIllllIlIIl, lllllllllllllIIIIIIIllIllllIIIll, lllllllllllllIIIIIIIllIllllIIlll, ColorUtils.getColor(0, lllllllllllllIIIIIIIllIllllIIllI >> 24 & 0xFF), false);
        GL11.glTranslated(1.0, 0.0, 0.0);
        this.drawString(lllllllllllllIIIIIIIllIllllIlIIl, lllllllllllllIIIIIIIllIllllIIIll, lllllllllllllIIIIIIIllIllllIIlll, ColorUtils.getColor(0, lllllllllllllIIIIIIIllIllllIIllI >> 24 & 0xFF), false);
        GL11.glTranslated(-0.5, 0.5, 0.0);
        this.drawString(lllllllllllllIIIIIIIllIllllIlIIl, lllllllllllllIIIIIIIllIllllIIIll, lllllllllllllIIIIIIIllIllllIIlll, ColorUtils.getColor(0, lllllllllllllIIIIIIIllIllllIIllI >> 24 & 0xFF), false);
        GL11.glTranslated(0.0, -1.0, 0.0);
        this.drawString(lllllllllllllIIIIIIIllIllllIlIIl, lllllllllllllIIIIIIIllIllllIIIll, lllllllllllllIIIIIIIllIllllIIlll, ColorUtils.getColor(0, lllllllllllllIIIIIIIllIllllIIllI >> 24 & 0xFF), false);
        GL11.glTranslated(0.0, 0.5, 0.0);
        this.drawString(lllllllllllllIIIIIIIllIllllIlIIl, lllllllllllllIIIIIIIllIllllIIIll, lllllllllllllIIIIIIIllIllllIIlll, lllllllllllllIIIIIIIllIllllIIllI, false);
        GL11.glTranslated(-1.0, -1.0, 0.0);
        GlStateManager.popMatrix();
    }
    
    @Override
    public void setFont(final Font lllllllllllllIIIIIIIllIllIIIlIll) {
        super.setFont(lllllllllllllIIIIIIIllIllIIIlIll);
        this.setupBoldItalicIDs();
    }
    
    public float drawString(final String lllllllllllllIIIIIIIlllIIlIIIIIl, final double lllllllllllllIIIIIIIlllIIlIIIIII, final double lllllllllllllIIIIIIIlllIIlIIIlII, final int lllllllllllllIIIIIIIlllIIlIIIIll) {
        return this.drawString(lllllllllllllIIIIIIIlllIIlIIIIIl, lllllllllllllIIIIIIIlllIIlIIIIII, lllllllllllllIIIIIIIlllIIlIIIlII, lllllllllllllIIIIIIIlllIIlIIIIll, false);
    }
    
    public List<String> formatString(final String lllllllllllllIIIIIIIllIlIIlIlllI, final double lllllllllllllIIIIIIIllIlIIllIllI) {
        final List lllllllllllllIIIIIIIllIlIIllIlIl = new ArrayList();
        String lllllllllllllIIIIIIIllIlIIllIlII = "";
        char lllllllllllllIIIIIIIllIlIIllIIll = '\uffff';
        final char[] lllllllllllllIIIIIIIllIlIIllIIlI = lllllllllllllIIIIIIIllIlIIlIlllI.toCharArray();
        for (int lllllllllllllIIIIIIIllIlIIllIIIl = 0; lllllllllllllIIIIIIIllIlIIllIIIl < lllllllllllllIIIIIIIllIlIIllIIlI.length; ++lllllllllllllIIIIIIIllIlIIllIIIl) {
            final char lllllllllllllIIIIIIIllIlIIllIIII = lllllllllllllIIIIIIIllIlIIllIIlI[lllllllllllllIIIIIIIllIlIIllIIIl];
            if (lllllllllllllIIIIIIIllIlIIllIIII == 'з' && lllllllllllllIIIIIIIllIlIIllIIIl < lllllllllllllIIIIIIIllIlIIllIIlI.length - 1) {
                lllllllllllllIIIIIIIllIlIIllIIll = lllllllllllllIIIIIIIllIlIIllIIlI[lllllllllllllIIIIIIIllIlIIllIIIl + 1];
            }
            if (this.getStringWidth(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIIIllIlIIllIlII)).append(lllllllllllllIIIIIIIllIlIIllIIII))) < lllllllllllllIIIIIIIllIlIIllIllI) {
                lllllllllllllIIIIIIIllIlIIllIlII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIIIIIIllIlIIllIlII)).append(lllllllllllllIIIIIIIllIlIIllIIII));
            }
            else {
                lllllllllllllIIIIIIIllIlIIllIlIl.add(lllllllllllllIIIIIIIllIlIIllIlII);
                lllllllllllllIIIIIIIllIlIIllIlII = String.valueOf(new StringBuilder(String.valueOf('з' + lllllllllllllIIIIIIIllIlIIllIIll)).append(String.valueOf(lllllllllllllIIIIIIIllIlIIllIIII)));
            }
        }
        if (lllllllllllllIIIIIIIllIlIIllIlII.length() > 0) {
            lllllllllllllIIIIIIIllIlIIllIlIl.add(lllllllllllllIIIIIIIllIlIIllIlII);
        }
        return (List<String>)lllllllllllllIIIIIIIllIlIIllIlIl;
    }
    
    private int sizeStringToWidth(final String lllllllllllllIIIIIIIllIIllllIlII, final int lllllllllllllIIIIIIIllIIllllIIll) {
        final int lllllllllllllIIIIIIIllIIllllIIlI = lllllllllllllIIIIIIIllIIllllIlII.length();
        float lllllllllllllIIIIIIIllIIllllIIIl = 0.0f;
        int lllllllllllllIIIIIIIllIIllllIIII = 0;
        int lllllllllllllIIIIIIIllIIlllIllll = -1;
        boolean lllllllllllllIIIIIIIllIIlllIlllI = false;
        while (lllllllllllllIIIIIIIllIIllllIIII < lllllllllllllIIIIIIIllIIllllIIlI) {
            final char lllllllllllllIIIIIIIllIIlllIllIl = lllllllllllllIIIIIIIllIIllllIlII.charAt(lllllllllllllIIIIIIIllIIllllIIII);
            Label_0163: {
                switch (lllllllllllllIIIIIIIllIIlllIllIl) {
                    case '\n': {
                        --lllllllllllllIIIIIIIllIIllllIIII;
                        break Label_0163;
                    }
                    case ' ': {
                        lllllllllllllIIIIIIIllIIlllIllll = lllllllllllllIIIIIIIllIIllllIIII;
                        break;
                    }
                    case 'з': {
                        if (lllllllllllllIIIIIIIllIIllllIIII >= lllllllllllllIIIIIIIllIIllllIIlI - 1) {
                            break Label_0163;
                        }
                        ++lllllllllllllIIIIIIIllIIllllIIII;
                        final char lllllllllllllIIIIIIIllIIlllIllII = lllllllllllllIIIIIIIllIIllllIlII.charAt(lllllllllllllIIIIIIIllIIllllIIII);
                        if (lllllllllllllIIIIIIIllIIlllIllII == 'l' || lllllllllllllIIIIIIIllIIlllIllII == 'L') {
                            lllllllllllllIIIIIIIllIIlllIlllI = true;
                            break Label_0163;
                        }
                        if (lllllllllllllIIIIIIIllIIlllIllII == 'r' || lllllllllllllIIIIIIIllIIlllIllII == 'R' || isFormatColor(lllllllllllllIIIIIIIllIIlllIllII)) {
                            lllllllllllllIIIIIIIllIIlllIlllI = false;
                        }
                        break Label_0163;
                    }
                }
                lllllllllllllIIIIIIIllIIllllIIIl += this.getCharWidthFloat(lllllllllllllIIIIIIIllIIlllIllIl);
                if (lllllllllllllIIIIIIIllIIlllIlllI) {
                    ++lllllllllllllIIIIIIIllIIllllIIIl;
                }
            }
            if (lllllllllllllIIIIIIIllIIlllIllIl == '\n') {
                lllllllllllllIIIIIIIllIIlllIllll = ++lllllllllllllIIIIIIIllIIllllIIII;
                break;
            }
            if (Math.round(lllllllllllllIIIIIIIllIIllllIIIl) > lllllllllllllIIIIIIIllIIllllIIll) {
                break;
            }
            ++lllllllllllllIIIIIIIllIIllllIIII;
        }
        return (lllllllllllllIIIIIIIllIIllllIIII != lllllllllllllIIIIIIIllIIllllIIlI && lllllllllllllIIIIIIIllIIlllIllll != -1 && lllllllllllllIIIIIIIllIIlllIllll < lllllllllllllIIIIIIIllIIllllIIII) ? lllllllllllllIIIIIIIllIIlllIllll : lllllllllllllIIIIIIIllIIllllIIII;
    }
    
    public float drawCenteredStringWithShadow(final String lllllllllllllIIIIIIIlllIIIIllIIl, final double lllllllllllllIIIIIIIlllIIIIllIII, final double lllllllllllllIIIIIIIlllIIIIlIlll, final int lllllllllllllIIIIIIIlllIIIIlIllI) {
        return this.drawStringWithShadow(lllllllllllllIIIIIIIlllIIIIllIIl, lllllllllllllIIIIIIIlllIIIIllIII - this.getStringWidth(lllllllllllllIIIIIIIlllIIIIllIIl) / 2.0f, lllllllllllllIIIIIIIlllIIIIlIlll, lllllllllllllIIIIIIIlllIIIIlIllI);
    }
    
    public float drawNoBSString(String lllllllllllllIIIIIIIlllIIllIIIlI, final double lllllllllllllIIIIIIIlllIIllIIIIl, final float lllllllllllllIIIIIIIlllIIllIIlIl, final int lllllllllllllIIIIIIIlllIIlIlllll) {
        lllllllllllllIIIIIIIlllIIllIIIlI = (int)((String)lllllllllllllIIIIIIIlllIIllIIIlI).replaceAll("\u00c3\u201a", "");
        return this.drawString((String)lllllllllllllIIIIIIIlllIIllIIIlI, lllllllllllllIIIIIIIlllIIllIIIIl, lllllllllllllIIIIIIIlllIIllIIlIl, lllllllllllllIIIIIIIlllIIlIlllll, false);
    }
    
    private static boolean isFormatColor(final char lllllllllllllIIIIIIIllIIlIlIIIll) {
        return (lllllllllllllIIIIIIIllIIlIlIIIll >= '0' && lllllllllllllIIIIIIIllIIlIlIIIll <= '9') || (lllllllllllllIIIIIIIllIIlIlIIIll >= 'a' && lllllllllllllIIIIIIIllIIlIlIIIll <= 'f') || (lllllllllllllIIIIIIIllIIlIlIIIll >= 'A' && lllllllllllllIIIIIIIllIIlIlIIIll <= 'F');
    }
}
