package optifine;

import net.minecraft.client.renderer.*;

public class Blender
{
    public static void setupBlend(final int lllllllllllllIIlIIIllIIIllIlIIlI, final float lllllllllllllIIlIIIllIIIllIIllll) {
        switch (lllllllllllllIIlIIIllIIIllIlIIlI) {
            case 0: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 771);
                GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllIIlIIIllIIIllIIllll);
                break;
            }
            case 1: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(770, 1);
                GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllIIlIIIllIIIllIIllll);
                break;
            }
            case 2: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(775, 0);
                GlStateManager.color(lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, 1.0f);
                break;
            }
            case 3: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(774, 771);
                GlStateManager.color(lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll);
                break;
            }
            case 4: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(1, 1);
                GlStateManager.color(lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, 1.0f);
                break;
            }
            case 5: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(0, 769);
                GlStateManager.color(lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, 1.0f);
                break;
            }
            case 6: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(1, 769);
                GlStateManager.color(lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, 1.0f);
                break;
            }
            case 7: {
                GlStateManager.disableAlpha();
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(774, 768);
                GlStateManager.color(lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, lllllllllllllIIlIIIllIIIllIIllll, 1.0f);
                break;
            }
            case 8: {
                GlStateManager.enableAlpha();
                GlStateManager.disableBlend();
                GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllIIlIIIllIIIllIIllll);
                break;
            }
        }
        GlStateManager.enableTexture2D();
    }
    
    public static int parseBlend(String lllllllllllllIIlIIIllIIIllIlIlIl) {
        if (lllllllllllllIIlIIIllIIIllIlIlIl == null) {
            return 1;
        }
        lllllllllllllIIlIIIllIIIllIlIlIl = lllllllllllllIIlIIIllIIIllIlIlIl.toLowerCase().trim();
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("alpha")) {
            return 0;
        }
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("add")) {
            return 1;
        }
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("subtract")) {
            return 2;
        }
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("multiply")) {
            return 3;
        }
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("dodge")) {
            return 4;
        }
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("burn")) {
            return 5;
        }
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("screen")) {
            return 6;
        }
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("overlay")) {
            return 7;
        }
        if (lllllllllllllIIlIIIllIIIllIlIlIl.equals("replace")) {
            return 8;
        }
        Config.warn(String.valueOf(new StringBuilder("Unknown blend: ").append(lllllllllllllIIlIIIllIIIllIlIlIl)));
        return 1;
    }
    
    static {
        BLEND_SUBSTRACT = 2;
        BLEND_MULTIPLY = 3;
        BLEND_OVERLAY = 7;
        BLEND_REPLACE = 8;
        BLEND_ADD = 1;
        BLEND_SCREEN = 6;
        BLEND_ALPHA = 0;
        BLEND_DEFAULT = 1;
        BLEND_DODGE = 4;
        BLEND_BURN = 5;
    }
    
    public static void clearBlend(final float lllllllllllllIIlIIIllIIIllIIllII) {
        GlStateManager.disableAlpha();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 1);
        GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllIIlIIIllIIIllIIllII);
    }
}
