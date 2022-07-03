package net.minecraft.client.renderer;

import net.minecraft.util.math.*;
import java.nio.*;

public class RenderHelper
{
    private static final /* synthetic */ Vec3d LIGHT1_POS;
    private static final /* synthetic */ FloatBuffer COLOR_BUFFER;
    private static final /* synthetic */ Vec3d LIGHT0_POS;
    
    public static void disableStandardItemLighting() {
        GlStateManager.disableLighting();
        GlStateManager.disableLight(0);
        GlStateManager.disableLight(1);
        GlStateManager.disableColorMaterial();
    }
    
    public static FloatBuffer setColorBuffer(final float lllllllllllllIIlllIIlIIIlIlIlIll, final float lllllllllllllIIlllIIlIIIlIlIlIlI, final float lllllllllllllIIlllIIlIIIlIlIlIIl, final float lllllllllllllIIlllIIlIIIlIlIllII) {
        RenderHelper.COLOR_BUFFER.clear();
        RenderHelper.COLOR_BUFFER.put(lllllllllllllIIlllIIlIIIlIlIlIll).put(lllllllllllllIIlllIIlIIIlIlIlIlI).put(lllllllllllllIIlllIIlIIIlIlIlIIl).put(lllllllllllllIIlllIIlIIIlIlIllII);
        RenderHelper.COLOR_BUFFER.flip();
        return RenderHelper.COLOR_BUFFER;
    }
    
    private static FloatBuffer setColorBuffer(final double lllllllllllllIIlllIIlIIIlIllIlll, final double lllllllllllllIIlllIIlIIIlIllIllI, final double lllllllllllllIIlllIIlIIIlIllIlIl, final double lllllllllllllIIlllIIlIIIlIlllIII) {
        return setColorBuffer((float)lllllllllllllIIlllIIlIIIlIllIlll, (float)lllllllllllllIIlllIIlIIIlIllIllI, (float)lllllllllllllIIlllIIlIIIlIllIlIl, (float)lllllllllllllIIlllIIlIIIlIlllIII);
    }
    
    static {
        COLOR_BUFFER = GLAllocation.createDirectFloatBuffer(4);
        LIGHT0_POS = new Vec3d(0.20000000298023224, 1.0, -0.699999988079071).normalize();
        LIGHT1_POS = new Vec3d(-0.20000000298023224, 1.0, 0.699999988079071).normalize();
    }
    
    public static void enableGUIStandardItemLighting() {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-30.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(165.0f, 1.0f, 0.0f, 0.0f);
        enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
    
    public static void enableStandardItemLighting() {
        GlStateManager.enableLighting();
        GlStateManager.enableLight(0);
        GlStateManager.enableLight(1);
        GlStateManager.enableColorMaterial();
        GlStateManager.colorMaterial(1032, 5634);
        GlStateManager.glLight(16384, 4611, setColorBuffer(RenderHelper.LIGHT0_POS.xCoord, RenderHelper.LIGHT0_POS.yCoord, RenderHelper.LIGHT0_POS.zCoord, 0.0));
        final float lllllllllllllIIlllIIlIIIllIIIIll = 0.6f;
        GlStateManager.glLight(16384, 4609, setColorBuffer(0.6f, 0.6f, 0.6f, 1.0f));
        GlStateManager.glLight(16384, 4608, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GlStateManager.glLight(16384, 4610, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GlStateManager.glLight(16385, 4611, setColorBuffer(RenderHelper.LIGHT1_POS.xCoord, RenderHelper.LIGHT1_POS.yCoord, RenderHelper.LIGHT1_POS.zCoord, 0.0));
        GlStateManager.glLight(16385, 4609, setColorBuffer(0.6f, 0.6f, 0.6f, 1.0f));
        GlStateManager.glLight(16385, 4608, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GlStateManager.glLight(16385, 4610, setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GlStateManager.shadeModel(7424);
        final float lllllllllllllIIlllIIlIIIllIIIIlI = 0.4f;
        GlStateManager.glLightModel(2899, setColorBuffer(0.4f, 0.4f, 0.4f, 1.0f));
    }
}
