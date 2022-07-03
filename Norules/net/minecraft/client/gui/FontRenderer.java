package net.minecraft.client.gui;

import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.client.settings.*;
import me.nrules.*;
import me.nrules.module.render.*;
import net.minecraft.client.*;
import com.mojang.realmsclient.gui.*;
import com.ibm.icu.text.*;
import org.lwjgl.opengl.*;
import me.nrules.utils.render.*;
import java.util.*;
import optifine.*;
import org.apache.commons.io.*;
import java.io.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;

public class FontRenderer implements IResourceManagerReloadListener
{
    private /* synthetic */ boolean strikethroughStyle;
    private /* synthetic */ int textColor;
    public /* synthetic */ boolean enabled;
    private final /* synthetic */ TextureManager renderEngine;
    public /* synthetic */ int FONT_HEIGHT;
    public /* synthetic */ float offsetBold;
    private /* synthetic */ float blue;
    private /* synthetic */ float alpha;
    private final /* synthetic */ byte[] glyphWidth;
    private /* synthetic */ float posX;
    private /* synthetic */ boolean underlineStyle;
    private /* synthetic */ ResourceLocation locationFontTexture;
    private final /* synthetic */ int[] charWidth;
    private /* synthetic */ float posY;
    private /* synthetic */ boolean blend;
    public /* synthetic */ Random fontRandom;
    private final /* synthetic */ int[] colorCode;
    private /* synthetic */ boolean randomStyle;
    private /* synthetic */ boolean unicodeFlag;
    private static final /* synthetic */ ResourceLocation[] UNICODE_PAGE_LOCATIONS;
    private /* synthetic */ float[] charWidthFloat;
    private /* synthetic */ boolean boldStyle;
    private /* synthetic */ boolean italicStyle;
    private /* synthetic */ float green;
    private /* synthetic */ boolean bidiFlag;
    private /* synthetic */ GlBlendState oldBlendState;
    private /* synthetic */ float red;
    public /* synthetic */ GameSettings gameSettings;
    public /* synthetic */ ResourceLocation locationFontTextureBase;
    
    private int renderString(String lllllllllllllIIlllIlIIIIlIllllll, final float lllllllllllllIIlllIlIIIIllIIIlII, final float lllllllllllllIIlllIlIIIIlIllllIl, int lllllllllllllIIlllIlIIIIlIllllII, final boolean lllllllllllllIIlllIlIIIIlIlllIll) {
        if (lllllllllllllIIlllIlIIIIlIllllll == null) {
            return 0;
        }
        if (this.bidiFlag) {
            lllllllllllllIIlllIlIIIIlIllllll = this.bidiReorder(lllllllllllllIIlllIlIIIIlIllllll);
        }
        if ((lllllllllllllIIlllIlIIIIlIllllII & 0xFC000000) == 0x0) {
            lllllllllllllIIlllIlIIIIlIllllII |= 0xFF000000;
        }
        if (lllllllllllllIIlllIlIIIIlIlllIll) {
            lllllllllllllIIlllIlIIIIlIllllII = ((lllllllllllllIIlllIlIIIIlIllllII & 0xFCFCFC) >> 2 | (lllllllllllllIIlllIlIIIIlIllllII & 0xFF000000));
        }
        this.red = (lllllllllllllIIlllIlIIIIlIllllII >> 16 & 0xFF) / 255.0f;
        this.blue = (lllllllllllllIIlllIlIIIIlIllllII >> 8 & 0xFF) / 255.0f;
        this.green = (lllllllllllllIIlllIlIIIIlIllllII & 0xFF) / 255.0f;
        this.alpha = (lllllllllllllIIlllIlIIIIlIllllII >> 24 & 0xFF) / 255.0f;
        this.setColor(this.red, this.blue, this.green, this.alpha);
        this.posX = lllllllllllllIIlllIlIIIIllIIIlII;
        this.posY = lllllllllllllIIlllIlIIIIlIllllIl;
        if (Main.moduleManager.getModule(NameProtect.class).isToggled() && Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().world != null) {
            lllllllllllllIIlllIlIIIIlIllllll = lllllllllllllIIlllIlIIIIlIllllll.replaceAll(Minecraft.getMinecraft().player.getName(), String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("Daddy")));
        }
        this.renderStringAtPos(lllllllllllllIIlllIlIIIIlIllllll, lllllllllllllIIlllIlIIIIlIlllIll);
        return (int)this.posX;
    }
    
    static {
        UNICODE_PAGE_LOCATIONS = new ResourceLocation[256];
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllIIlllIlIIlIIIIIlIll) {
        this.locationFontTexture = FontUtils.getHdFontLocation(this.locationFontTextureBase);
        for (int lllllllllllllIIlllIlIIlIIIIIlIlI = 0; lllllllllllllIIlllIlIIlIIIIIlIlI < FontRenderer.UNICODE_PAGE_LOCATIONS.length; ++lllllllllllllIIlllIlIIlIIIIIlIlI) {
            FontRenderer.UNICODE_PAGE_LOCATIONS[lllllllllllllIIlllIlIIlIIIIIlIlI] = null;
        }
        this.readFontTexture();
        this.readGlyphSizes();
    }
    
    protected void bindTexture(final ResourceLocation lllllllllllllIIlllIIllllIlllIIIl) {
        this.renderEngine.bindTexture(lllllllllllllIIlllIIllllIlllIIIl);
    }
    
    private String bidiReorder(final String lllllllllllllIIlllIlIIIlIIIllIIl) {
        try {
            final Bidi lllllllllllllIIlllIlIIIlIIIllIll = new Bidi(new ArabicShaping(8).shape(lllllllllllllIIlllIlIIIlIIIllIIl), 127);
            lllllllllllllIIlllIlIIIlIIIllIll.setReorderingMode(0);
            return lllllllllllllIIlllIlIIIlIIIllIll.writeReordered(2);
        }
        catch (ArabicShapingException lllllllllllllIIlllIlIIIlIIIllIlI) {
            return lllllllllllllIIlllIlIIIlIIIllIIl;
        }
    }
    
    public int drawStringWithShadow(final String lllllllllllllIIlllIlIIIlIlIIllIl, final float lllllllllllllIIlllIlIIIlIlIIIlll, final float lllllllllllllIIlllIlIIIlIlIIlIll, final int lllllllllllllIIlllIlIIIlIlIIlIlI) {
        return this.drawString(lllllllllllllIIlllIlIIIlIlIIllIl, lllllllllllllIIlllIlIIIlIlIIIlll, lllllllllllllIIlllIlIIIlIlIIlIll, lllllllllllllIIlllIlIIIlIlIIlIlI, true);
    }
    
    String wrapFormattedStringToWidth(final String lllllllllllllIIlllIIllllllIlIlIl, final int lllllllllllllIIlllIIllllllIlIlII) {
        if (lllllllllllllIIlllIIllllllIlIlIl.length() <= 1) {
            return lllllllllllllIIlllIIllllllIlIlIl;
        }
        final int lllllllllllllIIlllIIllllllIlIIll = this.sizeStringToWidth(lllllllllllllIIlllIIllllllIlIlIl, lllllllllllllIIlllIIllllllIlIlII);
        if (lllllllllllllIIlllIIllllllIlIlIl.length() <= lllllllllllllIIlllIIllllllIlIIll) {
            return lllllllllllllIIlllIIllllllIlIlIl;
        }
        final String lllllllllllllIIlllIIllllllIlIIlI = lllllllllllllIIlllIIllllllIlIlIl.substring(0, lllllllllllllIIlllIIllllllIlIIll);
        final char lllllllllllllIIlllIIllllllIlIIIl = lllllllllllllIIlllIIllllllIlIlIl.charAt(lllllllllllllIIlllIIllllllIlIIll);
        final boolean lllllllllllllIIlllIIllllllIlIIII = lllllllllllllIIlllIIllllllIlIIIl == ' ' || lllllllllllllIIlllIIllllllIlIIIl == '\n';
        final String lllllllllllllIIlllIIllllllIIllll = String.valueOf(new StringBuilder(String.valueOf(getFormatFromString(lllllllllllllIIlllIIllllllIlIIlI))).append(lllllllllllllIIlllIIllllllIlIlIl.substring(lllllllllllllIIlllIIllllllIlIIll + (lllllllllllllIIlllIIllllllIlIIII ? 1 : 0))));
        return String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlllIIllllllIlIIlI)).append("\n").append(this.wrapFormattedStringToWidth(lllllllllllllIIlllIIllllllIIllll, lllllllllllllIIlllIIllllllIlIlII)));
    }
    
    private void renderSplitString(final String lllllllllllllIIlllIlIIIIIIllIIIl, final int lllllllllllllIIlllIlIIIIIIllIIII, int lllllllllllllIIlllIlIIIIIIlIIlIl, final int lllllllllllllIIlllIlIIIIIIlIIlII, final boolean lllllllllllllIIlllIlIIIIIIlIllIl) {
        for (final String lllllllllllllIIlllIlIIIIIIlIllII : this.listFormattedStringToWidth(lllllllllllllIIlllIlIIIIIIllIIIl, lllllllllllllIIlllIlIIIIIIlIIlII)) {
            this.renderStringAligned(lllllllllllllIIlllIlIIIIIIlIllII, lllllllllllllIIlllIlIIIIIIllIIII, (int)lllllllllllllIIlllIlIIIIIIlIIlIl, lllllllllllllIIlllIlIIIIIIlIIlII, this.textColor, lllllllllllllIIlllIlIIIIIIlIllIl);
            lllllllllllllIIlllIlIIIIIIlIIlIl += this.FONT_HEIGHT;
        }
    }
    
    private void loadGlyphTexture(final int lllllllllllllIIlllIlIIIlIlllllIl) {
        this.bindTexture(this.getUnicodePageLocation(lllllllllllllIIlllIlIIIlIlllllIl));
    }
    
    public boolean getBidiFlag() {
        return this.bidiFlag;
    }
    
    public boolean getUnicodeFlag() {
        return this.unicodeFlag;
    }
    
    private float renderDefaultChar(final int lllllllllllllIIlllIlIIIllIIlIIll, final boolean lllllllllllllIIlllIlIIIllIIlIIlI) {
        final int lllllllllllllIIlllIlIIIllIIlIIIl = lllllllllllllIIlllIlIIIllIIlIIll % 16 * 8;
        final int lllllllllllllIIlllIlIIIllIIlIIII = lllllllllllllIIlllIlIIIllIIlIIll / 16 * 8;
        final int lllllllllllllIIlllIlIIIllIIIllll = lllllllllllllIIlllIlIIIllIIlIIlI ? 1 : 0;
        this.bindTexture(this.locationFontTexture);
        final float lllllllllllllIIlllIlIIIllIIIlllI = this.charWidthFloat[lllllllllllllIIlllIlIIIllIIlIIll];
        final float lllllllllllllIIlllIlIIIllIIIllIl = 7.99f;
        GlStateManager.glBegin(5);
        GlStateManager.glTexCoord2f(lllllllllllllIIlllIlIIIllIIlIIIl / 128.0f, lllllllllllllIIlllIlIIIllIIlIIII / 128.0f);
        GlStateManager.glVertex3f(this.posX + lllllllllllllIIlllIlIIIllIIIllll, this.posY, 0.0f);
        GlStateManager.glTexCoord2f(lllllllllllllIIlllIlIIIllIIlIIIl / 128.0f, (lllllllllllllIIlllIlIIIllIIlIIII + 7.99f) / 128.0f);
        GlStateManager.glVertex3f(this.posX - lllllllllllllIIlllIlIIIllIIIllll, this.posY + 7.99f, 0.0f);
        GlStateManager.glTexCoord2f((lllllllllllllIIlllIlIIIllIIlIIIl + lllllllllllllIIlllIlIIIllIIIllIl - 1.0f) / 128.0f, lllllllllllllIIlllIlIIIllIIlIIII / 128.0f);
        GlStateManager.glVertex3f(this.posX + lllllllllllllIIlllIlIIIllIIIllIl - 1.0f + lllllllllllllIIlllIlIIIllIIIllll, this.posY, 0.0f);
        GlStateManager.glTexCoord2f((lllllllllllllIIlllIlIIIllIIlIIIl + lllllllllllllIIlllIlIIIllIIIllIl - 1.0f) / 128.0f, (lllllllllllllIIlllIlIIIllIIlIIII + 7.99f) / 128.0f);
        GlStateManager.glVertex3f(this.posX + lllllllllllllIIlllIlIIIllIIIllIl - 1.0f - lllllllllllllIIlllIlIIIllIIIllll, this.posY + 7.99f, 0.0f);
        GlStateManager.glEnd();
        return lllllllllllllIIlllIlIIIllIIIlllI;
    }
    
    protected void enableAlpha() {
        GlStateManager.enableAlpha();
    }
    
    protected void setColor(final float lllllllllllllIIlllIIllllIllllIll, final float lllllllllllllIIlllIIllllIllllllI, final float lllllllllllllIIlllIIllllIllllIIl, final float lllllllllllllIIlllIIllllIlllllII) {
        GlStateManager.color(lllllllllllllIIlllIIllllIllllIll, lllllllllllllIIlllIIllllIllllllI, lllllllllllllIIlllIIllllIllllIIl, lllllllllllllIIlllIIllllIlllllII);
    }
    
    public void drawBorderedString(final String lllllllllllllIIlllIlIIIllIlIllII, final double lllllllllllllIIlllIlIIIllIlIlIll, final double lllllllllllllIIlllIlIIIllIlIlIlI, final int lllllllllllllIIlllIlIIIllIlIlIIl) {
        GlStateManager.pushMatrix();
        GL11.glTranslated(0.5, 0.0, 0.0);
        this.drawString(lllllllllllllIIlllIlIIIllIlIllII, lllllllllllllIIlllIlIIIllIlIlIll, lllllllllllllIIlllIlIIIllIlIlIlI, ColorUtils.getColor(0, lllllllllllllIIlllIlIIIllIlIlIIl >> 24 & 0xFF));
        GL11.glTranslated(1.0, 0.0, 0.0);
        this.drawString(lllllllllllllIIlllIlIIIllIlIllII, lllllllllllllIIlllIlIIIllIlIlIll, lllllllllllllIIlllIlIIIllIlIlIlI, ColorUtils.getColor(0, lllllllllllllIIlllIlIIIllIlIlIIl >> 24 & 0xFF));
        GL11.glTranslated(-0.5, 0.5, 0.0);
        this.drawString(lllllllllllllIIlllIlIIIllIlIllII, lllllllllllllIIlllIlIIIllIlIlIll, lllllllllllllIIlllIlIIIllIlIlIlI, ColorUtils.getColor(0, lllllllllllllIIlllIlIIIllIlIlIIl >> 24 & 0xFF));
        GL11.glTranslated(0.0, -1.0, 0.0);
        this.drawString(lllllllllllllIIlllIlIIIllIlIllII, lllllllllllllIIlllIlIIIllIlIlIll, lllllllllllllIIlllIlIIIllIlIlIlI, ColorUtils.getColor(0, lllllllllllllIIlllIlIIIllIlIlIIl >> 24 & 0xFF));
        GL11.glTranslated(0.0, 0.5, 0.0);
        this.drawString(lllllllllllllIIlllIlIIIllIlIllII, lllllllllllllIIlllIlIIIllIlIlIll, lllllllllllllIIlllIlIIIllIlIlIlI, lllllllllllllIIlllIlIIIllIlIlIIl);
        GL11.glTranslated(-1.0, -1.0, 0.0);
        GlStateManager.popMatrix();
    }
    
    public String trimStringToWidth(final String lllllllllllllIIlllIlIIIIlIIIIllI, final int lllllllllllllIIlllIlIIIIlIIIlIII) {
        return this.trimStringToWidth(lllllllllllllIIlllIlIIIIlIIIIllI, lllllllllllllIIlllIlIIIIlIIIlIII, false);
    }
    
    public List<String> listFormattedStringToWidth(final String lllllllllllllIIlllIIllllllllIlll, final int lllllllllllllIIlllIIllllllllIlIl) {
        return Arrays.asList(this.wrapFormattedStringToWidth(lllllllllllllIIlllIIllllllllIlll, lllllllllllllIIlllIIllllllllIlIl).split("\n"));
    }
    
    private static boolean isFormatSpecial(final char lllllllllllllIIlllIIlllllIlIIlII) {
        return (lllllllllllllIIlllIIlllllIlIIlII >= 'k' && lllllllllllllIIlllIIlllllIlIIlII <= 'o') || (lllllllllllllIIlllIIlllllIlIIlII >= 'K' && lllllllllllllIIlllIIlllllIlIIlII <= 'O') || lllllllllllllIIlllIIlllllIlIIlII == 'r' || lllllllllllllIIlllIIlllllIlIIlII == 'R';
    }
    
    public void setBidiFlag(final boolean lllllllllllllIIlllIlIIIIIIIIIIII) {
        this.bidiFlag = lllllllllllllIIlllIlIIIIIIIIIIII;
    }
    
    private void renderStringAtPos(final String lllllllllllllIIlllIlIIIIllllllIl, final boolean lllllllllllllIIlllIlIIIlIIIIlIIl) {
        for (int lllllllllllllIIlllIlIIIlIIIIlIII = 0; lllllllllllllIIlllIlIIIlIIIIlIII < lllllllllllllIIlllIlIIIIllllllIl.length(); ++lllllllllllllIIlllIlIIIlIIIIlIII) {
            char lllllllllllllIIlllIlIIIlIIIIIlll = lllllllllllllIIlllIlIIIIllllllIl.charAt(lllllllllllllIIlllIlIIIlIIIIlIII);
            if (lllllllllllllIIlllIlIIIlIIIIIlll == '§' && lllllllllllllIIlllIlIIIlIIIIlIII + 1 < lllllllllllllIIlllIlIIIIllllllIl.length()) {
                int lllllllllllllIIlllIlIIIlIIIIIllI = "0123456789abcdefklmnor".indexOf(String.valueOf(lllllllllllllIIlllIlIIIIllllllIl.charAt(lllllllllllllIIlllIlIIIlIIIIlIII + 1)).toLowerCase(Locale.ROOT).charAt(0));
                if (lllllllllllllIIlllIlIIIlIIIIIllI < 16) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    if (lllllllllllllIIlllIlIIIlIIIIIllI < 0 || lllllllllllllIIlllIlIIIlIIIIIllI > 15) {
                        lllllllllllllIIlllIlIIIlIIIIIllI = 15;
                    }
                    if (lllllllllllllIIlllIlIIIlIIIIlIIl) {
                        lllllllllllllIIlllIlIIIlIIIIIllI += 16;
                    }
                    int lllllllllllllIIlllIlIIIlIIIIIlIl = this.colorCode[lllllllllllllIIlllIlIIIlIIIIIllI];
                    if (Config.isCustomColors()) {
                        lllllllllllllIIlllIlIIIlIIIIIlIl = CustomColors.getTextColor(lllllllllllllIIlllIlIIIlIIIIIllI, lllllllllllllIIlllIlIIIlIIIIIlIl);
                    }
                    this.textColor = lllllllllllllIIlllIlIIIlIIIIIlIl;
                    this.setColor((lllllllllllllIIlllIlIIIlIIIIIlIl >> 16) / 255.0f, (lllllllllllllIIlllIlIIIlIIIIIlIl >> 8 & 0xFF) / 255.0f, (lllllllllllllIIlllIlIIIlIIIIIlIl & 0xFF) / 255.0f, this.alpha);
                }
                else if (lllllllllllllIIlllIlIIIlIIIIIllI == 16) {
                    this.randomStyle = true;
                }
                else if (lllllllllllllIIlllIlIIIlIIIIIllI == 17) {
                    this.boldStyle = true;
                }
                else if (lllllllllllllIIlllIlIIIlIIIIIllI == 18) {
                    this.strikethroughStyle = true;
                }
                else if (lllllllllllllIIlllIlIIIlIIIIIllI == 19) {
                    this.underlineStyle = true;
                }
                else if (lllllllllllllIIlllIlIIIlIIIIIllI == 20) {
                    this.italicStyle = true;
                }
                else if (lllllllllllllIIlllIlIIIlIIIIIllI == 21) {
                    this.randomStyle = false;
                    this.boldStyle = false;
                    this.strikethroughStyle = false;
                    this.underlineStyle = false;
                    this.italicStyle = false;
                    this.setColor(this.red, this.blue, this.green, this.alpha);
                }
                ++lllllllllllllIIlllIlIIIlIIIIlIII;
            }
            else {
                int lllllllllllllIIlllIlIIIlIIIIIlII = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".indexOf(lllllllllllllIIlllIlIIIlIIIIIlll);
                if (this.randomStyle && lllllllllllllIIlllIlIIIlIIIIIlII != -1) {
                    final int lllllllllllllIIlllIlIIIlIIIIIIll = this.getCharWidth(lllllllllllllIIlllIlIIIlIIIIIlll);
                    char lllllllllllllIIlllIlIIIlIIIIIIlI;
                    do {
                        lllllllllllllIIlllIlIIIlIIIIIlII = this.fontRandom.nextInt("\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".length());
                        lllllllllllllIIlllIlIIIlIIIIIIlI = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".charAt(lllllllllllllIIlllIlIIIlIIIIIlII);
                    } while (lllllllllllllIIlllIlIIIlIIIIIIll != this.getCharWidth(lllllllllllllIIlllIlIIIlIIIIIIlI));
                    lllllllllllllIIlllIlIIIlIIIIIlll = lllllllllllllIIlllIlIIIlIIIIIIlI;
                }
                final float lllllllllllllIIlllIlIIIlIIIIIIIl = (lllllllllllllIIlllIlIIIlIIIIIlII != -1 && !this.unicodeFlag) ? this.offsetBold : 0.5f;
                final boolean lllllllllllllIIlllIlIIIlIIIIIIII = (lllllllllllllIIlllIlIIIlIIIIIlll == '\0' || lllllllllllllIIlllIlIIIlIIIIIlII == -1 || this.unicodeFlag) && lllllllllllllIIlllIlIIIlIIIIlIIl;
                if (lllllllllllllIIlllIlIIIlIIIIIIII) {
                    this.posX -= lllllllllllllIIlllIlIIIlIIIIIIIl;
                    this.posY -= lllllllllllllIIlllIlIIIlIIIIIIIl;
                }
                float lllllllllllllIIlllIlIIIIllllllll = this.renderChar(lllllllllllllIIlllIlIIIlIIIIIlll, this.italicStyle);
                if (lllllllllllllIIlllIlIIIlIIIIIIII) {
                    this.posX += lllllllllllllIIlllIlIIIlIIIIIIIl;
                    this.posY += lllllllllllllIIlllIlIIIlIIIIIIIl;
                }
                if (this.boldStyle) {
                    this.posX += lllllllllllllIIlllIlIIIlIIIIIIIl;
                    if (lllllllllllllIIlllIlIIIlIIIIIIII) {
                        this.posX -= lllllllllllllIIlllIlIIIlIIIIIIIl;
                        this.posY -= lllllllllllllIIlllIlIIIlIIIIIIIl;
                    }
                    this.renderChar(lllllllllllllIIlllIlIIIlIIIIIlll, this.italicStyle);
                    this.posX -= lllllllllllllIIlllIlIIIlIIIIIIIl;
                    if (lllllllllllllIIlllIlIIIlIIIIIIII) {
                        this.posX += lllllllllllllIIlllIlIIIlIIIIIIIl;
                        this.posY += lllllllllllllIIlllIlIIIlIIIIIIIl;
                    }
                    lllllllllllllIIlllIlIIIIllllllll += lllllllllllllIIlllIlIIIlIIIIIIIl;
                }
                this.doDraw(lllllllllllllIIlllIlIIIIllllllll);
            }
        }
    }
    
    private String trimStringNewline(String lllllllllllllIIlllIlIIIIIlIllIlI) {
        while (lllllllllllllIIlllIlIIIIIlIllIlI != null && ((String)lllllllllllllIIlllIlIIIIIlIllIlI).endsWith("\n")) {
            lllllllllllllIIlllIlIIIIIlIllIlI = ((String)lllllllllllllIIlllIlIIIIIlIllIlI).substring(0, ((String)lllllllllllllIIlllIlIIIIIlIllIlI).length() - 1);
        }
        return (String)lllllllllllllIIlllIlIIIIIlIllIlI;
    }
    
    public void drawSplitString(String lllllllllllllIIlllIlIIIIIlIIIllI, final int lllllllllllllIIlllIlIIIIIlIIIlIl, final int lllllllllllllIIlllIlIIIIIlIIlllI, final int lllllllllllllIIlllIlIIIIIlIIIIll, final int lllllllllllllIIlllIlIIIIIlIIIIlI) {
        if (this.blend) {
            GlStateManager.getBlendState(this.oldBlendState);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        }
        this.resetStyles();
        this.textColor = lllllllllllllIIlllIlIIIIIlIIIIlI;
        lllllllllllllIIlllIlIIIIIlIIIllI = (int)this.trimStringNewline((String)lllllllllllllIIlllIlIIIIIlIIIllI);
        this.renderSplitString((String)lllllllllllllIIlllIlIIIIIlIIIllI, lllllllllllllIIlllIlIIIIIlIIIlIl, lllllllllllllIIlllIlIIIIIlIIlllI, lllllllllllllIIlllIlIIIIIlIIIIll, false);
        if (this.blend) {
            GlStateManager.setBlendState(this.oldBlendState);
        }
    }
    
    public int getCharWidth(final char lllllllllllllIIlllIlIIIIlIlIIIlI) {
        return Math.round(this.getCharWidthFloat(lllllllllllllIIlllIlIIIIlIlIIIlI));
    }
    
    private int sizeStringToWidth(final String lllllllllllllIIlllIIlllllIlllIll, final int lllllllllllllIIlllIIlllllIlllIlI) {
        final int lllllllllllllIIlllIIlllllIlllIIl = lllllllllllllIIlllIIlllllIlllIll.length();
        float lllllllllllllIIlllIIlllllIlllIII = 0.0f;
        int lllllllllllllIIlllIIlllllIllIlll = 0;
        int lllllllllllllIIlllIIlllllIllIllI = -1;
        boolean lllllllllllllIIlllIIlllllIllIlIl = false;
        while (lllllllllllllIIlllIIlllllIllIlll < lllllllllllllIIlllIIlllllIlllIIl) {
            final char lllllllllllllIIlllIIlllllIllIlII = lllllllllllllIIlllIIlllllIlllIll.charAt(lllllllllllllIIlllIIlllllIllIlll);
            Label_0163: {
                switch (lllllllllllllIIlllIIlllllIllIlII) {
                    case '\n': {
                        --lllllllllllllIIlllIIlllllIllIlll;
                        break Label_0163;
                    }
                    case ' ': {
                        lllllllllllllIIlllIIlllllIllIllI = lllllllllllllIIlllIIlllllIllIlll;
                        break;
                    }
                    case '§': {
                        if (lllllllllllllIIlllIIlllllIllIlll >= lllllllllllllIIlllIIlllllIlllIIl - 1) {
                            break Label_0163;
                        }
                        ++lllllllllllllIIlllIIlllllIllIlll;
                        final char lllllllllllllIIlllIIlllllIllIIll = lllllllllllllIIlllIIlllllIlllIll.charAt(lllllllllllllIIlllIIlllllIllIlll);
                        if (lllllllllllllIIlllIIlllllIllIIll == 'l' || lllllllllllllIIlllIIlllllIllIIll == 'L') {
                            lllllllllllllIIlllIIlllllIllIlIl = true;
                            break Label_0163;
                        }
                        if (lllllllllllllIIlllIIlllllIllIIll == 'r' || lllllllllllllIIlllIIlllllIllIIll == 'R' || isFormatColor(lllllllllllllIIlllIIlllllIllIIll)) {
                            lllllllllllllIIlllIIlllllIllIlIl = false;
                        }
                        break Label_0163;
                    }
                }
                lllllllllllllIIlllIIlllllIlllIII += this.getCharWidthFloat(lllllllllllllIIlllIIlllllIllIlII);
                if (lllllllllllllIIlllIIlllllIllIlIl) {
                    ++lllllllllllllIIlllIIlllllIlllIII;
                }
            }
            if (lllllllllllllIIlllIIlllllIllIlII == '\n') {
                lllllllllllllIIlllIIlllllIllIllI = ++lllllllllllllIIlllIIlllllIllIlll;
                break;
            }
            if (Math.round(lllllllllllllIIlllIIlllllIlllIII) > lllllllllllllIIlllIIlllllIlllIlI) {
                break;
            }
            ++lllllllllllllIIlllIIlllllIllIlll;
        }
        return (lllllllllllllIIlllIIlllllIllIlll != lllllllllllllIIlllIIlllllIlllIIl && lllllllllllllIIlllIIlllllIllIllI != -1 && lllllllllllllIIlllIIlllllIllIllI < lllllllllllllIIlllIIlllllIllIlll) ? lllllllllllllIIlllIIlllllIllIllI : lllllllllllllIIlllIIlllllIllIlll;
    }
    
    private void readGlyphSizes() {
        IResource lllllllllllllIIlllIlIIIllIllllIl = null;
        try {
            lllllllllllllIIlllIlIIIllIllllIl = this.getResource(new ResourceLocation("font/glyph_sizes.bin"));
            lllllllllllllIIlllIlIIIllIllllIl.getInputStream().read(this.glyphWidth);
        }
        catch (IOException lllllllllllllIIlllIlIIIllIllllII) {
            throw new RuntimeException(lllllllllllllIIlllIlIIIllIllllII);
        }
        finally {
            IOUtils.closeQuietly((Closeable)lllllllllllllIIlllIlIIIllIllllIl);
        }
        IOUtils.closeQuietly((Closeable)lllllllllllllIIlllIlIIIllIllllIl);
    }
    
    private static boolean isFormatColor(final char lllllllllllllIIlllIIlllllIlIIllI) {
        return (lllllllllllllIIlllIIlllllIlIIllI >= '0' && lllllllllllllIIlllIIlllllIlIIllI <= '9') || (lllllllllllllIIlllIIlllllIlIIllI >= 'a' && lllllllllllllIIlllIIlllllIlIIllI <= 'f') || (lllllllllllllIIlllIIlllllIlIIllI >= 'A' && lllllllllllllIIlllIIlllllIlIIllI <= 'F');
    }
    
    private ResourceLocation getUnicodePageLocation(final int lllllllllllllIIlllIlIIIllIIIIIlI) {
        if (FontRenderer.UNICODE_PAGE_LOCATIONS[lllllllllllllIIlllIlIIIllIIIIIlI] == null) {
            FontRenderer.UNICODE_PAGE_LOCATIONS[lllllllllllllIIlllIlIIIllIIIIIlI] = new ResourceLocation(String.format("textures/font/unicode_page_%02x.png", lllllllllllllIIlllIlIIIllIIIIIlI));
            FontRenderer.UNICODE_PAGE_LOCATIONS[lllllllllllllIIlllIlIIIllIIIIIlI] = FontUtils.getHdFontLocation(FontRenderer.UNICODE_PAGE_LOCATIONS[lllllllllllllIIlllIlIIIllIIIIIlI]);
        }
        return FontRenderer.UNICODE_PAGE_LOCATIONS[lllllllllllllIIlllIlIIIllIIIIIlI];
    }
    
    public void setUnicodeFlag(final boolean lllllllllllllIIlllIlIIIIIIIIlIll) {
        this.unicodeFlag = lllllllllllllIIlllIlIIIIIIIIlIll;
    }
    
    public int getColorCode(final char lllllllllllllIIlllIIlllllIIIlIll) {
        final int lllllllllllllIIlllIIlllllIIIlIlI = "0123456789abcdef".indexOf(lllllllllllllIIlllIIlllllIIIlIll);
        if (lllllllllllllIIlllIIlllllIIIlIlI >= 0 && lllllllllllllIIlllIIlllllIIIlIlI < this.colorCode.length) {
            int lllllllllllllIIlllIIlllllIIIlIIl = this.colorCode[lllllllllllllIIlllIIlllllIIIlIlI];
            if (Config.isCustomColors()) {
                lllllllllllllIIlllIIlllllIIIlIIl = CustomColors.getTextColor(lllllllllllllIIlllIIlllllIIIlIlI, lllllllllllllIIlllIIlllllIIIlIIl);
            }
            return lllllllllllllIIlllIIlllllIIIlIIl;
        }
        return 16777215;
    }
    
    private float renderChar(final char lllllllllllllIIlllIlIIIllIlIIIll, final boolean lllllllllllllIIlllIlIIIllIlIIIlI) {
        if (lllllllllllllIIlllIlIIIllIlIIIll != ' ' && lllllllllllllIIlllIlIIIllIlIIIll != ' ') {
            final int lllllllllllllIIlllIlIIIllIlIIIIl = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".indexOf(lllllllllllllIIlllIlIIIllIlIIIll);
            return (lllllllllllllIIlllIlIIIllIlIIIIl != -1 && !this.unicodeFlag) ? this.renderDefaultChar(lllllllllllllIIlllIlIIIllIlIIIIl, lllllllllllllIIlllIlIIIllIlIIIlI) : this.renderUnicodeChar(lllllllllllllIIlllIlIIIllIlIIIll, lllllllllllllIIlllIlIIIllIlIIIlI);
        }
        return this.unicodeFlag ? 4.0f : this.charWidthFloat[lllllllllllllIIlllIlIIIllIlIIIll];
    }
    
    private void resetStyles() {
        this.randomStyle = false;
        this.boldStyle = false;
        this.italicStyle = false;
        this.underlineStyle = false;
        this.strikethroughStyle = false;
    }
    
    private float getCharWidthFloat(final char lllllllllllllIIlllIlIIIIlIIllIII) {
        if (lllllllllllllIIlllIlIIIIlIIllIII == '§') {
            return -1.0f;
        }
        if (lllllllllllllIIlllIlIIIIlIIllIII == ' ' || lllllllllllllIIlllIlIIIIlIIllIII == ' ') {
            return this.charWidthFloat[32];
        }
        final int lllllllllllllIIlllIlIIIIlIIlIlll = "\u00c0\u00c1\u00c2\u00c8\u00ca\u00cb\u00cd\u00d3\u00d4\u00d5\u00da\u00df\u00e3\u00f5\u011f\u0130\u0131\u0152\u0153\u015e\u015f\u0174\u0175\u017e\u0207\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000\u00c7\u00fc\u00e9\u00e2\u00e4\u00e0\u00e5\u00e7\u00ea\u00eb\u00e8\u00ef\u00ee\u00ec\u00c4\u00c5\u00c9\u00e6\u00c6\u00f4\u00f6\u00f2\u00fb\u00f9\u00ff\u00d6\u00dc\u00f8?\u00d8\u00d7\u0192\u00e1\u00ed\u00f3\u00fa\u00f1\u00d1???®¬???«»\u2591\u2592\u2593\u2502\u2524\u2561\u2562\u2556\u2555\u2563\u2551\u2557\u255d\u255c\u255b\u2510\u2514\u2534\u252c\u251c\u2500\u253c\u255e\u255f\u255a\u2554\u2569\u2566\u2560\u2550\u256c\u2567\u2568\u2564\u2565\u2559\u2558\u2552\u2553\u256b\u256a\u2518\u250c\u2588\u2584\u258c\u2590\u2580\u03b1\u03b2\u0393\u03c0\u03a3\u03c3\u03bc\u03c4\u03a6\u0398\u03a9\u03b4\u221e\u2205\u2208\u2229\u2261±\u2265\u2264\u2320\u2321\u00f7\u2248°\u2219·\u221a\u207f?\u25a0\u0000".indexOf(lllllllllllllIIlllIlIIIIlIIllIII);
        if (lllllllllllllIIlllIlIIIIlIIllIII > '\0' && lllllllllllllIIlllIlIIIIlIIlIlll != -1 && !this.unicodeFlag) {
            return this.charWidthFloat[lllllllllllllIIlllIlIIIIlIIlIlll];
        }
        if (this.glyphWidth[lllllllllllllIIlllIlIIIIlIIllIII] != 0) {
            final int lllllllllllllIIlllIlIIIIlIIlIllI = this.glyphWidth[lllllllllllllIIlllIlIIIIlIIllIII] & 0xFF;
            final int lllllllllllllIIlllIlIIIIlIIlIlIl = lllllllllllllIIlllIlIIIIlIIlIllI >>> 4;
            int lllllllllllllIIlllIlIIIIlIIlIlII = lllllllllllllIIlllIlIIIIlIIlIllI & 0xF;
            return (float)((++lllllllllllllIIlllIlIIIIlIIlIlII - lllllllllllllIIlllIlIIIIlIIlIlIl) / 2 + 1);
        }
        return 0.0f;
    }
    
    public int splitStringWidth(final String lllllllllllllIIlllIlIIIIIIIllIII, final int lllllllllllllIIlllIlIIIIIIIlIllI) {
        return this.FONT_HEIGHT * this.listFormattedStringToWidth(lllllllllllllIIlllIlIIIIIIIllIII, lllllllllllllIIlllIlIIIIIIIlIllI).size();
    }
    
    private float renderUnicodeChar(final char lllllllllllllIIlllIlIIIlIlIlllll, final boolean lllllllllllllIIlllIlIIIlIlIllllI) {
        final int lllllllllllllIIlllIlIIIlIllIlIlI = this.glyphWidth[lllllllllllllIIlllIlIIIlIlIlllll] & 0xFF;
        if (lllllllllllllIIlllIlIIIlIllIlIlI == 0) {
            return 0.0f;
        }
        final int lllllllllllllIIlllIlIIIlIllIlIIl = lllllllllllllIIlllIlIIIlIlIlllll / '\u0100';
        this.loadGlyphTexture(lllllllllllllIIlllIlIIIlIllIlIIl);
        final int lllllllllllllIIlllIlIIIlIllIlIII = lllllllllllllIIlllIlIIIlIllIlIlI >>> 4;
        final int lllllllllllllIIlllIlIIIlIllIIlll = lllllllllllllIIlllIlIIIlIllIlIlI & 0xF;
        final float lllllllllllllIIlllIlIIIlIllIIllI = (float)lllllllllllllIIlllIlIIIlIllIlIII;
        final float lllllllllllllIIlllIlIIIlIllIIlIl = (float)(lllllllllllllIIlllIlIIIlIllIIlll + 1);
        final float lllllllllllllIIlllIlIIIlIllIIlII = lllllllllllllIIlllIlIIIlIlIlllll % '\u0010' * 16 + lllllllllllllIIlllIlIIIlIllIIllI;
        final float lllllllllllllIIlllIlIIIlIllIIIll = (float)((lllllllllllllIIlllIlIIIlIlIlllll & '\u00ff') / 16 * 16);
        final float lllllllllllllIIlllIlIIIlIllIIIlI = lllllllllllllIIlllIlIIIlIllIIlIl - lllllllllllllIIlllIlIIIlIllIIllI - 0.02f;
        final float lllllllllllllIIlllIlIIIlIllIIIIl = lllllllllllllIIlllIlIIIlIlIllllI ? 1.0f : 0.0f;
        GlStateManager.glBegin(5);
        GlStateManager.glTexCoord2f(lllllllllllllIIlllIlIIIlIllIIlII / 256.0f, lllllllllllllIIlllIlIIIlIllIIIll / 256.0f);
        GlStateManager.glVertex3f(this.posX + lllllllllllllIIlllIlIIIlIllIIIIl, this.posY, 0.0f);
        GlStateManager.glTexCoord2f(lllllllllllllIIlllIlIIIlIllIIlII / 256.0f, (lllllllllllllIIlllIlIIIlIllIIIll + 15.98f) / 256.0f);
        GlStateManager.glVertex3f(this.posX - lllllllllllllIIlllIlIIIlIllIIIIl, this.posY + 7.99f, 0.0f);
        GlStateManager.glTexCoord2f((lllllllllllllIIlllIlIIIlIllIIlII + lllllllllllllIIlllIlIIIlIllIIIlI) / 256.0f, lllllllllllllIIlllIlIIIlIllIIIll / 256.0f);
        GlStateManager.glVertex3f(this.posX + lllllllllllllIIlllIlIIIlIllIIIlI / 2.0f + lllllllllllllIIlllIlIIIlIllIIIIl, this.posY, 0.0f);
        GlStateManager.glTexCoord2f((lllllllllllllIIlllIlIIIlIllIIlII + lllllllllllllIIlllIlIIIlIllIIIlI) / 256.0f, (lllllllllllllIIlllIlIIIlIllIIIll + 15.98f) / 256.0f);
        GlStateManager.glVertex3f(this.posX + lllllllllllllIIlllIlIIIlIllIIIlI / 2.0f - lllllllllllllIIlllIlIIIlIllIIIIl, this.posY + 7.99f, 0.0f);
        GlStateManager.glEnd();
        return (lllllllllllllIIlllIlIIIlIllIIlIl - lllllllllllllIIlllIlIIIlIllIIllI) / 2.0f + 1.0f;
    }
    
    private int renderStringAligned(final String lllllllllllllIIlllIlIIIIllIlIIll, int lllllllllllllIIlllIlIIIIllIlIIlI, final int lllllllllllllIIlllIlIIIIllIllIIl, final int lllllllllllllIIlllIlIIIIllIllIII, final int lllllllllllllIIlllIlIIIIllIIllll, final boolean lllllllllllllIIlllIlIIIIllIlIllI) {
        if (this.bidiFlag) {
            final int lllllllllllllIIlllIlIIIIllIlIlIl = this.getStringWidth(this.bidiReorder(lllllllllllllIIlllIlIIIIllIlIIll));
            lllllllllllllIIlllIlIIIIllIlIIlI = lllllllllllllIIlllIlIIIIllIlIIlI + lllllllllllllIIlllIlIIIIllIllIII - lllllllllllllIIlllIlIIIIllIlIlIl;
        }
        return this.renderString(lllllllllllllIIlllIlIIIIllIlIIll, (float)lllllllllllllIIlllIlIIIIllIlIIlI, (float)lllllllllllllIIlllIlIIIIllIllIIl, lllllllllllllIIlllIlIIIIllIIllll, lllllllllllllIIlllIlIIIIllIlIllI);
    }
    
    public static String getFormatFromString(final String lllllllllllllIIlllIIlllllIIlllIl) {
        String lllllllllllllIIlllIIlllllIIlllII = "";
        int lllllllllllllIIlllIIlllllIIllIll = -1;
        final int lllllllllllllIIlllIIlllllIIllIlI = lllllllllllllIIlllIIlllllIIlllIl.length();
        while ((lllllllllllllIIlllIIlllllIIllIll = lllllllllllllIIlllIIlllllIIlllIl.indexOf(167, lllllllllllllIIlllIIlllllIIllIll + 1)) != -1) {
            if (lllllllllllllIIlllIIlllllIIllIll < lllllllllllllIIlllIIlllllIIllIlI - 1) {
                final char lllllllllllllIIlllIIlllllIIllIIl = lllllllllllllIIlllIIlllllIIlllIl.charAt(lllllllllllllIIlllIIlllllIIllIll + 1);
                if (isFormatColor(lllllllllllllIIlllIIlllllIIllIIl)) {
                    lllllllllllllIIlllIIlllllIIlllII = String.valueOf(new StringBuilder("§").append(lllllllllllllIIlllIIlllllIIllIIl));
                }
                else {
                    if (!isFormatSpecial(lllllllllllllIIlllIIlllllIIllIIl)) {
                        continue;
                    }
                    lllllllllllllIIlllIIlllllIIlllII = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIlllIIlllllIIlllII)).append("§").append(lllllllllllllIIlllIIlllllIIllIIl));
                }
            }
        }
        return lllllllllllllIIlllIIlllllIIlllII;
    }
    
    private void readFontTexture() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1        /* lllllllllllllIIlllIlIIIlllllIIII */
        //     2: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //     3: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //     4: getfield        net/minecraft/client/gui/FontRenderer.locationFontTexture:Lnet/minecraft/util/ResourceLocation;
        //     7: invokevirtual   net/minecraft/client/gui/FontRenderer.getResource:(Lnet/minecraft/util/ResourceLocation;)Lnet/minecraft/client/resources/IResource;
        //    10: astore_1        /* lllllllllllllIIlllIlIIIlllllIIII */
        //    11: aload_1         /* lllllllllllllIIlllIlIIIlllllIIII */
        //    12: invokeinterface net/minecraft/client/resources/IResource.getInputStream:()Ljava/io/InputStream;
        //    17: invokestatic    net/minecraft/client/renderer/texture/TextureUtil.readBufferedImage:(Ljava/io/InputStream;)Ljava/awt/image/BufferedImage;
        //    20: astore_2        /* lllllllllllllIIlllIlIIIlllIlIllI */
        //    21: goto            43
        //    24: astore_3        /* lllllllllllllIIlllIlIIIlllIlIlIl */
        //    25: new             Ljava/lang/RuntimeException;
        //    28: dup            
        //    29: aload_3         /* lllllllllllllIIlllIlIIIllllIllIl */
        //    30: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    33: athrow         
        //    34: astore          lllllllllllllIIlllIlIIIlllIlIlII
        //    36: aload_1         /* lllllllllllllIIlllIlIIIlllllIIII */
        //    37: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    40: aload           lllllllllllllIIlllIlIIIlllIlIlII
        //    42: athrow         
        //    43: aload_1         /* lllllllllllllIIlllIlIIIlllllIIII */
        //    44: invokestatic    org/apache/commons/io/IOUtils.closeQuietly:(Ljava/io/Closeable;)V
        //    47: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //    48: getfield        net/minecraft/client/gui/FontRenderer.locationFontTexture:Lnet/minecraft/util/ResourceLocation;
        //    51: invokestatic    optifine/FontUtils.readFontProperties:(Lnet/minecraft/util/ResourceLocation;)Ljava/util/Properties;
        //    54: astore_3        /* lllllllllllllIIlllIlIIIlllIlIlIl */
        //    55: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //    56: aload_3         /* lllllllllllllIIlllIlIIIllllIllII */
        //    57: ldc_w           "blend"
        //    60: iconst_0       
        //    61: invokestatic    optifine/FontUtils.readBoolean:(Ljava/util/Properties;Ljava/lang/String;Z)Z
        //    64: putfield        net/minecraft/client/gui/FontRenderer.blend:Z
        //    67: aload_2         /* lllllllllllllIIlllIlIIIllllIlllI */
        //    68: invokevirtual   java/awt/image/BufferedImage.getWidth:()I
        //    71: istore          lllllllllllllIIlllIlIIIllllIlIll
        //    73: aload_2         /* lllllllllllllIIlllIlIIIllllIlllI */
        //    74: invokevirtual   java/awt/image/BufferedImage.getHeight:()I
        //    77: istore          lllllllllllllIIlllIlIIIllllIlIlI
        //    79: iload           lllllllllllllIIlllIlIIIllllIlIll
        //    81: bipush          16
        //    83: idiv           
        //    84: istore          lllllllllllllIIlllIlIIIllllIlIIl
        //    86: iload           lllllllllllllIIlllIlIIIllllIlIlI
        //    88: bipush          16
        //    90: idiv           
        //    91: istore          lllllllllllllIIlllIlIIIllllIlIII
        //    93: iload           lllllllllllllIIlllIlIIIllllIlIll
        //    95: i2f            
        //    96: ldc_w           128.0
        //    99: fdiv           
        //   100: fstore          lllllllllllllIIlllIlIIIllllIIlll
        //   102: fload           lllllllllllllIIlllIlIIIllllIIlll
        //   104: fconst_1       
        //   105: fconst_2       
        //   106: invokestatic    optifine/Config.limit:(FFF)F
        //   109: fstore          lllllllllllllIIlllIlIIIllllIIllI
        //   111: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //   112: fconst_1       
        //   113: fload           lllllllllllllIIlllIlIIIllllIIllI
        //   115: fdiv           
        //   116: putfield        net/minecraft/client/gui/FontRenderer.offsetBold:F
        //   119: aload_3         /* lllllllllllllIIlllIlIIIllllIllII */
        //   120: ldc_w           "offsetBold"
        //   123: ldc_w           -1.0
        //   126: invokestatic    optifine/FontUtils.readFloat:(Ljava/util/Properties;Ljava/lang/String;F)F
        //   129: fstore          lllllllllllllIIlllIlIIIllllIIlIl
        //   131: fload           lllllllllllllIIlllIlIIIllllIIlIl
        //   133: fconst_0       
        //   134: fcmpl          
        //   135: iflt            144
        //   138: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //   139: fload           lllllllllllllIIlllIlIIIllllIIlIl
        //   141: putfield        net/minecraft/client/gui/FontRenderer.offsetBold:F
        //   144: iload           lllllllllllllIIlllIlIIIllllIlIll
        //   146: iload           lllllllllllllIIlllIlIIIllllIlIlI
        //   148: imul           
        //   149: newarray        I
        //   151: astore          lllllllllllllIIlllIlIIIllllIIlII
        //   153: aload_2         /* lllllllllllllIIlllIlIIIllllIlllI */
        //   154: iconst_0       
        //   155: iconst_0       
        //   156: iload           lllllllllllllIIlllIlIIIllllIlIll
        //   158: iload           lllllllllllllIIlllIlIIIllllIlIlI
        //   160: aload           lllllllllllllIIlllIlIIIllllIIlII
        //   162: iconst_0       
        //   163: iload           lllllllllllllIIlllIlIIIllllIlIll
        //   165: invokevirtual   java/awt/image/BufferedImage.getRGB:(IIII[III)[I
        //   168: pop            
        //   169: iconst_0       
        //   170: istore          lllllllllllllIIlllIlIIIllllIIIll
        //   172: goto            359
        //   175: iload           lllllllllllllIIlllIlIIIllllIIIll
        //   177: bipush          16
        //   179: irem           
        //   180: istore          lllllllllllllIIlllIlIIIllllIIIlI
        //   182: iload           lllllllllllllIIlllIlIIIllllIIIll
        //   184: bipush          16
        //   186: idiv           
        //   187: istore          lllllllllllllIIlllIlIIIllllIIIIl
        //   189: iconst_0       
        //   190: istore          lllllllllllllIIlllIlIIIllllIIIII
        //   192: iload           lllllllllllllIIlllIlIIIllllIlIIl
        //   194: iconst_1       
        //   195: isub           
        //   196: istore          lllllllllllllIIlllIlIIIllllIIIII
        //   198: goto            290
        //   201: iload           lllllllllllllIIlllIlIIIllllIIIlI
        //   203: iload           lllllllllllllIIlllIlIIIllllIlIIl
        //   205: imul           
        //   206: iload           lllllllllllllIIlllIlIIIllllIIIII
        //   208: iadd           
        //   209: istore          lllllllllllllIIlllIlIIIlllIlllll
        //   211: iconst_1       
        //   212: istore          lllllllllllllIIlllIlIIIlllIllllI
        //   214: iconst_0       
        //   215: istore          lllllllllllllIIlllIlIIIlllIlllIl
        //   217: goto            267
        //   220: iload           lllllllllllllIIlllIlIIIllllIIIIl
        //   222: iload           lllllllllllllIIlllIlIIIllllIlIII
        //   224: imul           
        //   225: iload           lllllllllllllIIlllIlIIIlllIlllIl
        //   227: iadd           
        //   228: iload           lllllllllllllIIlllIlIIIllllIlIll
        //   230: imul           
        //   231: istore          lllllllllllllIIlllIlIIIlllIlllII
        //   233: aload           lllllllllllllIIlllIlIIIllllIIlII
        //   235: iload           lllllllllllllIIlllIlIIIlllIlllll
        //   237: iload           lllllllllllllIIlllIlIIIlllIlllII
        //   239: iadd           
        //   240: iaload         
        //   241: istore          lllllllllllllIIlllIlIIIlllIllIll
        //   243: iload           lllllllllllllIIlllIlIIIlllIllIll
        //   245: bipush          24
        //   247: ishr           
        //   248: sipush          255
        //   251: iand           
        //   252: istore          lllllllllllllIIlllIlIIIlllIllIlI
        //   254: iload           lllllllllllllIIlllIlIIIlllIllIlI
        //   256: bipush          16
        //   258: if_icmple       264
        //   261: iconst_0       
        //   262: istore          lllllllllllllIIlllIlIIIlllIllllI
        //   264: iinc            lllllllllllllIIlllIlIIIlllIlllIl, 1
        //   267: iload           lllllllllllllIIlllIlIIIlllIlllIl
        //   269: iload           lllllllllllllIIlllIlIIIllllIlIII
        //   271: if_icmpge       279
        //   274: iload           lllllllllllllIIlllIlIIIlllIllllI
        //   276: ifne            220
        //   279: iload           lllllllllllllIIlllIlIIIlllIllllI
        //   281: ifne            287
        //   284: goto            295
        //   287: iinc            lllllllllllllIIlllIlIIIllllIIIII, -1
        //   290: iload           lllllllllllllIIlllIlIIIllllIIIII
        //   292: ifge            201
        //   295: iload           lllllllllllllIIlllIlIIIllllIIIll
        //   297: bipush          65
        //   299: if_icmpne       306
        //   302: iload           lllllllllllllIIlllIlIIIllllIIIll
        //   304: istore          lllllllllllllIIlllIlIIIllllIIIll
        //   306: iload           lllllllllllllIIlllIlIIIllllIIIll
        //   308: bipush          32
        //   310: if_icmpne       339
        //   313: iload           lllllllllllllIIlllIlIIIllllIlIIl
        //   315: bipush          8
        //   317: if_icmpgt       330
        //   320: fconst_2       
        //   321: fload           lllllllllllllIIlllIlIIIllllIIlll
        //   323: fmul           
        //   324: f2i            
        //   325: istore          lllllllllllllIIlllIlIIIllllIIIII
        //   327: goto            339
        //   330: ldc_w           1.5
        //   333: fload           lllllllllllllIIlllIlIIIllllIIlll
        //   335: fmul           
        //   336: f2i            
        //   337: istore          lllllllllllllIIlllIlIIIllllIIIII
        //   339: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //   340: getfield        net/minecraft/client/gui/FontRenderer.charWidthFloat:[F
        //   343: iload           lllllllllllllIIlllIlIIIllllIIIll
        //   345: iload           lllllllllllllIIlllIlIIIllllIIIII
        //   347: iconst_1       
        //   348: iadd           
        //   349: i2f            
        //   350: fload           lllllllllllllIIlllIlIIIllllIIlll
        //   352: fdiv           
        //   353: fconst_1       
        //   354: fadd           
        //   355: fastore        
        //   356: iinc            lllllllllllllIIlllIlIIIllllIIIll, 1
        //   359: iload           lllllllllllllIIlllIlIIIllllIIIll
        //   361: sipush          256
        //   364: if_icmplt       175
        //   367: aload_3         /* lllllllllllllIIlllIlIIIllllIllII */
        //   368: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //   369: getfield        net/minecraft/client/gui/FontRenderer.charWidthFloat:[F
        //   372: invokestatic    optifine/FontUtils.readCustomCharWidths:(Ljava/util/Properties;[F)V
        //   375: iconst_0       
        //   376: istore          lllllllllllllIIlllIlIIIlllIllIIl
        //   378: goto            401
        //   381: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //   382: getfield        net/minecraft/client/gui/FontRenderer.charWidth:[I
        //   385: iload           lllllllllllllIIlllIlIIIlllIllIIl
        //   387: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //   388: getfield        net/minecraft/client/gui/FontRenderer.charWidthFloat:[F
        //   391: iload           lllllllllllllIIlllIlIIIlllIllIIl
        //   393: faload         
        //   394: invokestatic    java/lang/Math.round:(F)I
        //   397: iastore        
        //   398: iinc            lllllllllllllIIlllIlIIIlllIllIIl, 1
        //   401: iload           lllllllllllllIIlllIlIIIlllIllIIl
        //   403: aload_0         /* lllllllllllllIIlllIlIIIlllIllIII */
        //   404: getfield        net/minecraft/client/gui/FontRenderer.charWidth:[I
        //   407: arraylength    
        //   408: if_icmplt       381
        //   411: return         
        //    StackMapTable: 00 13 FF 00 18 00 02 07 00 02 07 02 B2 00 01 07 02 A9 49 07 02 D4 FC 00 08 07 03 77 FF 00 64 00 0B 07 00 02 07 02 B2 07 03 77 07 03 C4 01 01 01 01 02 02 02 00 00 FD 00 1E 07 03 C5 01 FE 00 19 01 01 01 FE 00 12 01 01 01 FE 00 2B 01 01 01 F8 00 02 0B 07 F8 00 02 04 0A 17 08 F8 00 13 15 13
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      21     24     34     Ljava/io/IOException;
        //  2      34     34     43     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public int drawString(final String lllllllllllllIIlllIlIIIlIIlllllI, final double lllllllllllllIIlllIlIIIlIIlllIII, final double lllllllllllllIIlllIlIIIlIIllIlll, final int lllllllllllllIIlllIlIIIlIIllIllI) {
        return this.enabled ? this.drawString(lllllllllllllIIlllIlIIIlIIlllllI, (float)lllllllllllllIIlllIlIIIlIIlllIII, (float)lllllllllllllIIlllIlIIIlIIllIlll, lllllllllllllIIlllIlIIIlIIllIllI, false) : 0;
    }
    
    protected void doDraw(final float lllllllllllllIIlllIlIIIIlllIlIII) {
        if (this.strikethroughStyle) {
            final Tessellator lllllllllllllIIlllIlIIIIlllIlllI = Tessellator.getInstance();
            final BufferBuilder lllllllllllllIIlllIlIIIIlllIllIl = lllllllllllllIIlllIlIIIIlllIlllI.getBuffer();
            GlStateManager.disableTexture2D();
            lllllllllllllIIlllIlIIIIlllIllIl.begin(7, DefaultVertexFormats.POSITION);
            lllllllllllllIIlllIlIIIIlllIllIl.pos(this.posX, this.posY + this.FONT_HEIGHT / 2, 0.0).endVertex();
            lllllllllllllIIlllIlIIIIlllIllIl.pos(this.posX + lllllllllllllIIlllIlIIIIlllIlIII, this.posY + this.FONT_HEIGHT / 2, 0.0).endVertex();
            lllllllllllllIIlllIlIIIIlllIllIl.pos(this.posX + lllllllllllllIIlllIlIIIIlllIlIII, this.posY + this.FONT_HEIGHT / 2 - 1.0f, 0.0).endVertex();
            lllllllllllllIIlllIlIIIIlllIllIl.pos(this.posX, this.posY + this.FONT_HEIGHT / 2 - 1.0f, 0.0).endVertex();
            lllllllllllllIIlllIlIIIIlllIlllI.draw();
            GlStateManager.enableTexture2D();
        }
        if (this.underlineStyle) {
            final Tessellator lllllllllllllIIlllIlIIIIlllIllII = Tessellator.getInstance();
            final BufferBuilder lllllllllllllIIlllIlIIIIlllIlIll = lllllllllllllIIlllIlIIIIlllIllII.getBuffer();
            GlStateManager.disableTexture2D();
            lllllllllllllIIlllIlIIIIlllIlIll.begin(7, DefaultVertexFormats.POSITION);
            final int lllllllllllllIIlllIlIIIIlllIlIlI = this.underlineStyle ? -1 : 0;
            lllllllllllllIIlllIlIIIIlllIlIll.pos(this.posX + lllllllllllllIIlllIlIIIIlllIlIlI, this.posY + this.FONT_HEIGHT, 0.0).endVertex();
            lllllllllllllIIlllIlIIIIlllIlIll.pos(this.posX + lllllllllllllIIlllIlIIIIlllIlIII, this.posY + this.FONT_HEIGHT, 0.0).endVertex();
            lllllllllllllIIlllIlIIIIlllIlIll.pos(this.posX + lllllllllllllIIlllIlIIIIlllIlIII, this.posY + this.FONT_HEIGHT - 1.0f, 0.0).endVertex();
            lllllllllllllIIlllIlIIIIlllIlIll.pos(this.posX + lllllllllllllIIlllIlIIIIlllIlIlI, this.posY + this.FONT_HEIGHT - 1.0f, 0.0).endVertex();
            lllllllllllllIIlllIlIIIIlllIllII.draw();
            GlStateManager.enableTexture2D();
        }
        this.posX += lllllllllllllIIlllIlIIIIlllIlIII;
    }
    
    public int getStringWidth(final String lllllllllllllIIlllIlIIIIlIlIlIll) {
        if (lllllllllllllIIlllIlIIIIlIlIlIll == null) {
            return 0;
        }
        float lllllllllllllIIlllIlIIIIlIllIIIl = 0.0f;
        boolean lllllllllllllIIlllIlIIIIlIllIIII = false;
        for (int lllllllllllllIIlllIlIIIIlIlIllll = 0; lllllllllllllIIlllIlIIIIlIlIllll < lllllllllllllIIlllIlIIIIlIlIlIll.length(); ++lllllllllllllIIlllIlIIIIlIlIllll) {
            char lllllllllllllIIlllIlIIIIlIlIlllI = lllllllllllllIIlllIlIIIIlIlIlIll.charAt(lllllllllllllIIlllIlIIIIlIlIllll);
            float lllllllllllllIIlllIlIIIIlIlIllIl = this.getCharWidthFloat(lllllllllllllIIlllIlIIIIlIlIlllI);
            if (lllllllllllllIIlllIlIIIIlIlIllIl < 0.0f && lllllllllllllIIlllIlIIIIlIlIllll < lllllllllllllIIlllIlIIIIlIlIlIll.length() - 1) {
                ++lllllllllllllIIlllIlIIIIlIlIllll;
                lllllllllllllIIlllIlIIIIlIlIlllI = lllllllllllllIIlllIlIIIIlIlIlIll.charAt(lllllllllllllIIlllIlIIIIlIlIllll);
                if (lllllllllllllIIlllIlIIIIlIlIlllI != 'l' && lllllllllllllIIlllIlIIIIlIlIlllI != 'L') {
                    if (lllllllllllllIIlllIlIIIIlIlIlllI == 'r' || lllllllllllllIIlllIlIIIIlIlIlllI == 'R') {
                        lllllllllllllIIlllIlIIIIlIllIIII = false;
                    }
                }
                else {
                    lllllllllllllIIlllIlIIIIlIllIIII = true;
                }
                lllllllllllllIIlllIlIIIIlIlIllIl = 0.0f;
            }
            lllllllllllllIIlllIlIIIIlIllIIIl += lllllllllllllIIlllIlIIIIlIlIllIl;
            if (lllllllllllllIIlllIlIIIIlIllIIII && lllllllllllllIIlllIlIIIIlIlIllIl > 0.0f) {
                lllllllllllllIIlllIlIIIIlIllIIIl += (this.unicodeFlag ? 1.0f : this.offsetBold);
            }
        }
        return Math.round(lllllllllllllIIlllIlIIIIlIllIIIl);
    }
    
    public FontRenderer(final GameSettings lllllllllllllIIlllIlIIlIIIlIllIl, final ResourceLocation lllllllllllllIIlllIlIIlIIIIlllIl, final TextureManager lllllllllllllIIlllIlIIlIIIIllIll, final boolean lllllllllllllIIlllIlIIlIIIIllIIl) {
        this.charWidth = new int[256];
        this.FONT_HEIGHT = 9;
        this.fontRandom = new Random();
        this.glyphWidth = new byte[65536];
        this.colorCode = new int[32];
        this.enabled = true;
        this.offsetBold = 1.0f;
        this.charWidthFloat = new float[256];
        this.blend = false;
        this.oldBlendState = new GlBlendState();
        this.gameSettings = lllllllllllllIIlllIlIIlIIIlIllIl;
        this.locationFontTextureBase = lllllllllllllIIlllIlIIlIIIIlllIl;
        this.locationFontTexture = lllllllllllllIIlllIlIIlIIIIlllIl;
        this.renderEngine = lllllllllllllIIlllIlIIlIIIIllIll;
        this.unicodeFlag = lllllllllllllIIlllIlIIlIIIIllIIl;
        this.locationFontTexture = FontUtils.getHdFontLocation(this.locationFontTextureBase);
        this.bindTexture(this.locationFontTexture);
        for (int lllllllllllllIIlllIlIIlIIIlIlIIl = 0; lllllllllllllIIlllIlIIlIIIlIlIIl < 32; ++lllllllllllllIIlllIlIIlIIIlIlIIl) {
            final int lllllllllllllIIlllIlIIlIIIlIlIII = (lllllllllllllIIlllIlIIlIIIlIlIIl >> 3 & 0x1) * 85;
            int lllllllllllllIIlllIlIIlIIIlIIlll = (lllllllllllllIIlllIlIIlIIIlIlIIl >> 2 & 0x1) * 170 + lllllllllllllIIlllIlIIlIIIlIlIII;
            int lllllllllllllIIlllIlIIlIIIlIIllI = (lllllllllllllIIlllIlIIlIIIlIlIIl >> 1 & 0x1) * 170 + lllllllllllllIIlllIlIIlIIIlIlIII;
            int lllllllllllllIIlllIlIIlIIIlIIlIl = (lllllllllllllIIlllIlIIlIIIlIlIIl >> 0 & 0x1) * 170 + lllllllllllllIIlllIlIIlIIIlIlIII;
            if (lllllllllllllIIlllIlIIlIIIlIlIIl == 6) {
                lllllllllllllIIlllIlIIlIIIlIIlll += 85;
            }
            if (lllllllllllllIIlllIlIIlIIIlIllIl.anaglyph) {
                final int lllllllllllllIIlllIlIIlIIIlIIlII = (lllllllllllllIIlllIlIIlIIIlIIlll * 30 + lllllllllllllIIlllIlIIlIIIlIIllI * 59 + lllllllllllllIIlllIlIIlIIIlIIlIl * 11) / 100;
                final int lllllllllllllIIlllIlIIlIIIlIIIll = (lllllllllllllIIlllIlIIlIIIlIIlll * 30 + lllllllllllllIIlllIlIIlIIIlIIllI * 70) / 100;
                final int lllllllllllllIIlllIlIIlIIIlIIIlI = (lllllllllllllIIlllIlIIlIIIlIIlll * 30 + lllllllllllllIIlllIlIIlIIIlIIlIl * 70) / 100;
                lllllllllllllIIlllIlIIlIIIlIIlll = lllllllllllllIIlllIlIIlIIIlIIlII;
                lllllllllllllIIlllIlIIlIIIlIIllI = lllllllllllllIIlllIlIIlIIIlIIIll;
                lllllllllllllIIlllIlIIlIIIlIIlIl = lllllllllllllIIlllIlIIlIIIlIIIlI;
            }
            if (lllllllllllllIIlllIlIIlIIIlIlIIl >= 16) {
                lllllllllllllIIlllIlIIlIIIlIIlll /= 4;
                lllllllllllllIIlllIlIIlIIIlIIllI /= 4;
                lllllllllllllIIlllIlIIlIIIlIIlIl /= 4;
            }
            this.colorCode[lllllllllllllIIlllIlIIlIIIlIlIIl] = ((lllllllllllllIIlllIlIIlIIIlIIlll & 0xFF) << 16 | (lllllllllllllIIlllIlIIlIIIlIIllI & 0xFF) << 8 | (lllllllllllllIIlllIlIIlIIIlIIlIl & 0xFF));
        }
        this.readGlyphSizes();
    }
    
    public String trimStringToWidth(final String lllllllllllllIIlllIlIIIIIllIlIIl, final int lllllllllllllIIlllIlIIIIIlllIlIl, final boolean lllllllllllllIIlllIlIIIIIllIIlll) {
        final StringBuilder lllllllllllllIIlllIlIIIIIlllIIll = new StringBuilder();
        float lllllllllllllIIlllIlIIIIIlllIIlI = 0.0f;
        final int lllllllllllllIIlllIlIIIIIlllIIIl = lllllllllllllIIlllIlIIIIIllIIlll ? (lllllllllllllIIlllIlIIIIIllIlIIl.length() - 1) : 0;
        final int lllllllllllllIIlllIlIIIIIlllIIII = lllllllllllllIIlllIlIIIIIllIIlll ? -1 : 1;
        boolean lllllllllllllIIlllIlIIIIIllIllll = false;
        boolean lllllllllllllIIlllIlIIIIIllIlllI = false;
        for (int lllllllllllllIIlllIlIIIIIllIllIl = lllllllllllllIIlllIlIIIIIlllIIIl; lllllllllllllIIlllIlIIIIIllIllIl >= 0 && lllllllllllllIIlllIlIIIIIllIllIl < lllllllllllllIIlllIlIIIIIllIlIIl.length() && lllllllllllllIIlllIlIIIIIlllIIlI < lllllllllllllIIlllIlIIIIIlllIlIl; lllllllllllllIIlllIlIIIIIllIllIl += lllllllllllllIIlllIlIIIIIlllIIII) {
            final char lllllllllllllIIlllIlIIIIIllIllII = lllllllllllllIIlllIlIIIIIllIlIIl.charAt(lllllllllllllIIlllIlIIIIIllIllIl);
            final float lllllllllllllIIlllIlIIIIIllIlIll = this.getCharWidthFloat(lllllllllllllIIlllIlIIIIIllIllII);
            if (lllllllllllllIIlllIlIIIIIllIllll) {
                lllllllllllllIIlllIlIIIIIllIllll = false;
                if (lllllllllllllIIlllIlIIIIIllIllII != 'l' && lllllllllllllIIlllIlIIIIIllIllII != 'L') {
                    if (lllllllllllllIIlllIlIIIIIllIllII == 'r' || lllllllllllllIIlllIlIIIIIllIllII == 'R') {
                        lllllllllllllIIlllIlIIIIIllIlllI = false;
                    }
                }
                else {
                    lllllllllllllIIlllIlIIIIIllIlllI = true;
                }
            }
            else if (lllllllllllllIIlllIlIIIIIllIlIll < 0.0f) {
                lllllllllllllIIlllIlIIIIIllIllll = true;
            }
            else {
                lllllllllllllIIlllIlIIIIIlllIIlI += lllllllllllllIIlllIlIIIIIllIlIll;
                if (lllllllllllllIIlllIlIIIIIllIlllI) {
                    ++lllllllllllllIIlllIlIIIIIlllIIlI;
                }
            }
            if (lllllllllllllIIlllIlIIIIIlllIIlI > lllllllllllllIIlllIlIIIIIlllIlIl) {
                break;
            }
            if (lllllllllllllIIlllIlIIIIIllIIlll) {
                lllllllllllllIIlllIlIIIIIlllIIll.insert(0, lllllllllllllIIlllIlIIIIIllIllII);
            }
            else {
                lllllllllllllIIlllIlIIIIIlllIIll.append(lllllllllllllIIlllIlIIIIIllIllII);
            }
        }
        return String.valueOf(lllllllllllllIIlllIlIIIIIlllIIll);
    }
    
    protected IResource getResource(final ResourceLocation lllllllllllllIIlllIIllllIllIlllI) throws IOException {
        return Minecraft.getMinecraft().getResourceManager().getResource(lllllllllllllIIlllIIllllIllIlllI);
    }
    
    public int drawString(final String lllllllllllllIIlllIlIIIlIIlIIlIl, final float lllllllllllllIIlllIlIIIlIIlIIlII, final float lllllllllllllIIlllIlIIIlIIlIlIll, final int lllllllllllllIIlllIlIIIlIIlIIIlI, final boolean lllllllllllllIIlllIlIIIlIIlIIIIl) {
        this.enableAlpha();
        if (this.blend) {
            GlStateManager.getBlendState(this.oldBlendState);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        }
        this.resetStyles();
        int lllllllllllllIIlllIlIIIlIIlIIlll = 0;
        if (lllllllllllllIIlllIlIIIlIIlIIIIl) {
            int lllllllllllllIIlllIlIIIlIIlIlIII = this.renderString(lllllllllllllIIlllIlIIIlIIlIIlIl, lllllllllllllIIlllIlIIIlIIlIIlII + 1.0f, lllllllllllllIIlllIlIIIlIIlIlIll + 1.0f, lllllllllllllIIlllIlIIIlIIlIIIlI, true);
            lllllllllllllIIlllIlIIIlIIlIlIII = Math.max(lllllllllllllIIlllIlIIIlIIlIlIII, this.renderString(lllllllllllllIIlllIlIIIlIIlIIlIl, lllllllllllllIIlllIlIIIlIIlIIlII, lllllllllllllIIlllIlIIIlIIlIlIll, lllllllllllllIIlllIlIIIlIIlIIIlI, false));
        }
        else {
            lllllllllllllIIlllIlIIIlIIlIIlll = this.renderString(lllllllllllllIIlllIlIIIlIIlIIlIl, lllllllllllllIIlllIlIIIlIIlIIlII, lllllllllllllIIlllIlIIIlIIlIlIll, lllllllllllllIIlllIlIIIlIIlIIIlI, false);
        }
        if (this.blend) {
            GlStateManager.setBlendState(this.oldBlendState);
        }
        return lllllllllllllIIlllIlIIIlIIlIIlll;
    }
}
