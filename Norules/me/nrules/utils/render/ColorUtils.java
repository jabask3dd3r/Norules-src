package me.nrules.utils.render;

import java.awt.*;
import java.text.*;
import net.minecraft.client.renderer.*;

public class ColorUtils
{
    public static Color blend(final Color lllllllllllllIIllIIlIIIlIllllIlI, final Color lllllllllllllIIllIIlIIIllIIIIllI, final double lllllllllllllIIllIIlIIIllIIIIlIl) {
        final float lllllllllllllIIllIIlIIIllIIIIlII = (float)lllllllllllllIIllIIlIIIllIIIIlIl;
        final float lllllllllllllIIllIIlIIIllIIIIIll = 1.0f - lllllllllllllIIllIIlIIIllIIIIlII;
        final float[] lllllllllllllIIllIIlIIIllIIIIIlI = new float[3];
        final float[] lllllllllllllIIllIIlIIIllIIIIIIl = new float[3];
        lllllllllllllIIllIIlIIIlIllllIlI.getColorComponents(lllllllllllllIIllIIlIIIllIIIIIlI);
        lllllllllllllIIllIIlIIIllIIIIllI.getColorComponents(lllllllllllllIIllIIlIIIllIIIIIIl);
        float lllllllllllllIIllIIlIIIllIIIIIII = lllllllllllllIIllIIlIIIllIIIIIlI[0] * lllllllllllllIIllIIlIIIllIIIIlII + lllllllllllllIIllIIlIIIllIIIIIIl[0] * lllllllllllllIIllIIlIIIllIIIIIll;
        float lllllllllllllIIllIIlIIIlIlllllll = lllllllllllllIIllIIlIIIllIIIIIlI[1] * lllllllllllllIIllIIlIIIllIIIIlII + lllllllllllllIIllIIlIIIllIIIIIIl[1] * lllllllllllllIIllIIlIIIllIIIIIll;
        float lllllllllllllIIllIIlIIIlIllllllI = lllllllllllllIIllIIlIIIllIIIIIlI[2] * lllllllllllllIIllIIlIIIllIIIIlII + lllllllllllllIIllIIlIIIllIIIIIIl[2] * lllllllllllllIIllIIlIIIllIIIIIll;
        if (lllllllllllllIIllIIlIIIllIIIIIII < 0.0f) {
            lllllllllllllIIllIIlIIIllIIIIIII = 0.0f;
        }
        else if (lllllllllllllIIllIIlIIIllIIIIIII > 255.0f) {
            lllllllllllllIIllIIlIIIllIIIIIII = 255.0f;
        }
        if (lllllllllllllIIllIIlIIIlIlllllll < 0.0f) {
            lllllllllllllIIllIIlIIIlIlllllll = 0.0f;
        }
        else if (lllllllllllllIIllIIlIIIlIlllllll > 255.0f) {
            lllllllllllllIIllIIlIIIlIlllllll = 255.0f;
        }
        if (lllllllllllllIIllIIlIIIlIllllllI < 0.0f) {
            lllllllllllllIIllIIlIIIlIllllllI = 0.0f;
        }
        else if (lllllllllllllIIllIIlIIIlIllllllI > 255.0f) {
            lllllllllllllIIllIIlIIIlIllllllI = 255.0f;
        }
        Color lllllllllllllIIllIIlIIIlIlllllIl = null;
        try {
            lllllllllllllIIllIIlIIIlIlllllIl = new Color(lllllllllllllIIllIIlIIIllIIIIIII, lllllllllllllIIllIIlIIIlIlllllll, lllllllllllllIIllIIlIIIlIllllllI);
        }
        catch (IllegalArgumentException lllllllllllllIIllIIlIIIlIlllllII) {
            final NumberFormat lllllllllllllIIllIIlIIIlIllllIll = NumberFormat.getNumberInstance();
            System.out.println(String.valueOf(new StringBuilder(String.valueOf(lllllllllllllIIllIIlIIIlIllllIll.format(lllllllllllllIIllIIlIIIllIIIIIII))).append("; ").append(lllllllllllllIIllIIlIIIlIllllIll.format(lllllllllllllIIllIIlIIIlIlllllll)).append("; ").append(lllllllllllllIIllIIlIIIlIllllIll.format(lllllllllllllIIllIIlIIIlIllllllI))));
            lllllllllllllIIllIIlIIIlIlllllII.printStackTrace();
        }
        return lllllllllllllIIllIIlIIIlIlllllIl;
    }
    
    public static Color blendColors(final float[] lllllllllllllIIllIIlIIIllIlIlIII, final Color[] lllllllllllllIIllIIlIIIllIIlllIl, final float lllllllllllllIIllIIlIIIllIIlllII) {
        Color lllllllllllllIIllIIlIIIllIlIIlIl = null;
        if (lllllllllllllIIllIIlIIIllIlIlIII == null) {
            throw new IllegalArgumentException("Fractions can't be null");
        }
        if (lllllllllllllIIllIIlIIIllIIlllIl == null) {
            throw new IllegalArgumentException("Colours can't be null");
        }
        if (lllllllllllllIIllIIlIIIllIlIlIII.length != lllllllllllllIIllIIlIIIllIIlllIl.length) {
            throw new IllegalArgumentException("Fractions and colours must have equal number of elements");
        }
        final int[] lllllllllllllIIllIIlIIIllIlIIlII = getFractionIndicies(lllllllllllllIIllIIlIIIllIlIlIII, lllllllllllllIIllIIlIIIllIIlllII);
        if (lllllllllllllIIllIIlIIIllIlIIlII[0] < 0 || lllllllllllllIIllIIlIIIllIlIIlII[0] >= lllllllllllllIIllIIlIIIllIlIlIII.length || lllllllllllllIIllIIlIIIllIlIIlII[1] < 0 || lllllllllllllIIllIIlIIIllIlIIlII[1] >= lllllllllllllIIllIIlIIIllIlIlIII.length) {
            return lllllllllllllIIllIIlIIIllIIlllIl[0];
        }
        final float[] lllllllllllllIIllIIlIIIllIlIIIll = { lllllllllllllIIllIIlIIIllIlIlIII[lllllllllllllIIllIIlIIIllIlIIlII[0]], lllllllllllllIIllIIlIIIllIlIlIII[lllllllllllllIIllIIlIIIllIlIIlII[1]] };
        final Color[] lllllllllllllIIllIIlIIIllIlIIIlI = { lllllllllllllIIllIIlIIIllIIlllIl[lllllllllllllIIllIIlIIIllIlIIlII[0]], lllllllllllllIIllIIlIIIllIIlllIl[lllllllllllllIIllIIlIIIllIlIIlII[1]] };
        final float lllllllllllllIIllIIlIIIllIlIIIIl = lllllllllllllIIllIIlIIIllIlIIIll[1] - lllllllllllllIIllIIlIIIllIlIIIll[0];
        final float lllllllllllllIIllIIlIIIllIlIIIII = lllllllllllllIIllIIlIIIllIIlllII - lllllllllllllIIllIIlIIIllIlIIIll[0];
        final float lllllllllllllIIllIIlIIIllIIlllll = lllllllllllllIIllIIlIIIllIlIIIII / lllllllllllllIIllIIlIIIllIlIIIIl;
        lllllllllllllIIllIIlIIIllIlIIlIl = blend(lllllllllllllIIllIIlIIIllIlIIIlI[0], lllllllllllllIIllIIlIIIllIlIIIlI[1], 1.0f - lllllllllllllIIllIIlIIIllIIlllll);
        return lllllllllllllIIllIIlIIIllIlIIlIl;
    }
    
    public static void color(final int lllllllllllllIIllIIlIIIlllIIlIII) {
        final float lllllllllllllIIllIIlIIIlllIIIlll = (lllllllllllllIIllIIlIIIlllIIlIII & 0xFF) / 255.0f;
        final float lllllllllllllIIllIIlIIIlllIIIllI = (lllllllllllllIIllIIlIIIlllIIlIII >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIllIIlIIIlllIIIlIl = (lllllllllllllIIllIIlIIIlllIIlIII >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIllIIlIIIlllIIIlII = (lllllllllllllIIllIIlIIIlllIIlIII >> 24 & 0xFF) / 255.0f;
        GlStateManager.color(lllllllllllllIIllIIlIIIlllIIIlll, lllllllllllllIIllIIlIIIlllIIIllI, lllllllllllllIIllIIlIIIlllIIIlIl, lllllllllllllIIllIIlIIIlllIIIlII);
    }
    
    public static int getColor(final int lllllllllllllIIllIIlIIIlllIlllIl) {
        return getColor(lllllllllllllIIllIIlIIIlllIlllIl, lllllllllllllIIllIIlIIIlllIlllIl, lllllllllllllIIllIIlIIIlllIlllIl, 255);
    }
    
    public static int getColor(final int lllllllllllllIIllIIlIIIlIlIIlIII, final int lllllllllllllIIllIIlIIIlIlIIllII, final int lllllllllllllIIllIIlIIIlIlIIIllI, final int lllllllllllllIIllIIlIIIlIlIIlIlI) {
        int lllllllllllllIIllIIlIIIlIlIIlIIl = 0;
        lllllllllllllIIllIIlIIIlIlIIlIIl |= lllllllllllllIIllIIlIIIlIlIIlIlI << 24;
        lllllllllllllIIllIIlIIIlIlIIlIIl |= lllllllllllllIIllIIlIIIlIlIIlIII << 16;
        lllllllllllllIIllIIlIIIlIlIIlIIl |= lllllllllllllIIllIIlIIIlIlIIllII << 8;
        return lllllllllllllIIllIIlIIIlIlIIlIIl |= lllllllllllllIIllIIlIIIlIlIIIllI;
    }
    
    public static int getColor(final Color lllllllllllllIIllIIlIIIllllIIIIl) {
        return getColor(lllllllllllllIIllIIlIIIllllIIIIl.getRed(), lllllllllllllIIllIIlIIIllllIIIIl.getGreen(), lllllllllllllIIllIIlIIIllllIIIIl.getBlue(), lllllllllllllIIllIIlIIIllllIIIIl.getAlpha());
    }
    
    public static int withTransparency(final int lllllllllllllIIllIIlIIIlllIlIIlI, final float lllllllllllllIIllIIlIIIlllIlIIIl) {
        final float lllllllllllllIIllIIlIIIlllIlIlIl = (lllllllllllllIIllIIlIIIlllIlIIlI >> 16 & 0xFF) / 255.0f;
        final float lllllllllllllIIllIIlIIIlllIlIlII = (lllllllllllllIIllIIlIIIlllIlIIlI >> 8 & 0xFF) / 255.0f;
        final float lllllllllllllIIllIIlIIIlllIlIIll = (lllllllllllllIIllIIlIIIlllIlIIlI >> 0 & 0xFF) / 255.0f;
        return new Color(lllllllllllllIIllIIlIIIlllIlIlIl, lllllllllllllIIllIIlIIIlllIlIlII, lllllllllllllIIllIIlIIIlllIlIIll, lllllllllllllIIllIIlIIIlllIlIIIl).getRGB();
    }
    
    public static int getColor(final int lllllllllllllIIllIIlIIIlIIllIllI, final int lllllllllllllIIllIIlIIIlIIllIlIl) {
        return getColor(lllllllllllllIIllIIlIIIlIIllIllI, lllllllllllllIIllIIlIIIlIIllIllI, lllllllllllllIIllIIlIIIlIIllIllI, lllllllllllllIIllIIlIIIlIIllIlIl);
    }
    
    public static int astolfoColors1(final float lllllllllllllIIllIIlIIIlIIllIIII, final float lllllllllllllIIllIIlIIIlIIlIlIll) {
        float lllllllllllllIIllIIlIIIlIIlIlllI;
        float lllllllllllllIIllIIlIIIlIIlIllIl;
        for (lllllllllllllIIllIIlIIIlIIlIlllI = 3500.0f, lllllllllllllIIllIIlIIIlIIlIllIl = System.currentTimeMillis() % (int)lllllllllllllIIllIIlIIIlIIlIlllI + (lllllllllllllIIllIIlIIIlIIlIlIll - lllllllllllllIIllIIlIIIlIIllIIII) * 12.0f; lllllllllllllIIllIIlIIIlIIlIllIl > lllllllllllllIIllIIlIIIlIIlIlllI; lllllllllllllIIllIIlIIIlIIlIllIl -= lllllllllllllIIllIIlIIIlIIlIlllI) {}
        lllllllllllllIIllIIlIIIlIIlIllIl /= lllllllllllllIIllIIlIIIlIIlIlllI;
        if (lllllllllllllIIllIIlIIIlIIlIllIl > 0.5) {
            lllllllllllllIIllIIlIIIlIIlIllIl = 0.5f - (lllllllllllllIIllIIlIIIlIIlIllIl - 0.5f);
        }
        lllllllllllllIIllIIlIIIlIIlIllIl += 0.5f;
        return Color.HSBtoRGB(lllllllllllllIIllIIlIIIlIIlIllIl, 0.5f, 1.0f);
    }
    
    public static int[] getFractionIndicies(final float[] lllllllllllllIIllIIlIIIllIlllIlI, final float lllllllllllllIIllIIlIIIllIllIlIl) {
        final int[] lllllllllllllIIllIIlIIIllIlllIII = new int[2];
        int lllllllllllllIIllIIlIIIllIllIlll;
        for (lllllllllllllIIllIIlIIIllIllIlll = 0; lllllllllllllIIllIIlIIIllIllIlll < lllllllllllllIIllIIlIIIllIlllIlI.length && lllllllllllllIIllIIlIIIllIlllIlI[lllllllllllllIIllIIlIIIllIllIlll] <= lllllllllllllIIllIIlIIIllIllIlIl; ++lllllllllllllIIllIIlIIIllIllIlll) {}
        if (lllllllllllllIIllIIlIIIllIllIlll >= lllllllllllllIIllIIlIIIllIlllIlI.length) {
            lllllllllllllIIllIIlIIIllIllIlll = lllllllllllllIIllIIlIIIllIlllIlI.length - 1;
        }
        lllllllllllllIIllIIlIIIllIlllIII[0] = lllllllllllllIIllIIlIIIllIllIlll - 1;
        lllllllllllllIIllIIlIIIllIlllIII[1] = lllllllllllllIIllIIlIIIllIllIlll;
        return lllllllllllllIIllIIlIIIllIlllIII;
    }
    
    public static int getColor(final int lllllllllllllIIllIIlIIIlIlIIIIII, final int lllllllllllllIIllIIlIIIlIIllllll, final int lllllllllllllIIllIIlIIIlIIlllIll) {
        return 0xFF000000 | lllllllllllllIIllIIlIIIlIlIIIIII << 16 | lllllllllllllIIllIIlIIIlIIllllll << 8 | lllllllllllllIIllIIlIIIlIIlllIll;
    }
    
    public static int astolfoColors(final int lllllllllllllIIllIIlIIIlIlIlIllI, final int lllllllllllllIIllIIlIIIlIlIllIIl) {
        float lllllllllllllIIllIIlIIIlIlIlIlll;
        float lllllllllllllIIllIIlIIIlIlIllIII;
        for (lllllllllllllIIllIIlIIIlIlIlIlll = 2900.0f, lllllllllllllIIllIIlIIIlIlIllIII = System.currentTimeMillis() % (int)lllllllllllllIIllIIlIIIlIlIlIlll + (float)((lllllllllllllIIllIIlIIIlIlIllIIl - lllllllllllllIIllIIlIIIlIlIlIllI) * 9); lllllllllllllIIllIIlIIIlIlIllIII > lllllllllllllIIllIIlIIIlIlIlIlll; lllllllllllllIIllIIlIIIlIlIllIII -= lllllllllllllIIllIIlIIIlIlIlIlll) {}
        if ((lllllllllllllIIllIIlIIIlIlIllIII /= lllllllllllllIIllIIlIIIlIlIlIlll) > 0.5) {
            lllllllllllllIIllIIlIIIlIlIllIII = 0.5f - (lllllllllllllIIllIIlIIIlIlIllIII - 0.5f);
        }
        return Color.HSBtoRGB(lllllllllllllIIllIIlIIIlIlIllIII += 0.5f, 0.5f, 1.0f);
    }
    
    public static Color getHealthColor(final float lllllllllllllIIllIIlIIIlIllIlIII, final float lllllllllllllIIllIIlIIIlIllIIlll) {
        final float[] lllllllllllllIIllIIlIIIlIllIIllI = { 0.0f, 0.5f, 1.0f };
        final Color[] lllllllllllllIIllIIlIIIlIllIIlIl = { new Color(108, 0, 0), new Color(255, 51, 0), Color.GREEN };
        final float lllllllllllllIIllIIlIIIlIllIIlII = lllllllllllllIIllIIlIIIlIllIlIII / lllllllllllllIIllIIlIIIlIllIIlll;
        return blendColors(lllllllllllllIIllIIlIIIlIllIIllI, lllllllllllllIIllIIlIIIlIllIIlIl, lllllllllllllIIllIIlIIIlIllIIlII).brighter();
    }
}
