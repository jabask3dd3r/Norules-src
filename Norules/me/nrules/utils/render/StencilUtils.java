package me.nrules.utils.render;

import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.shader.*;
import org.lwjgl.opengl.*;

public class StencilUtils
{
    static /* synthetic */ Minecraft mc;
    
    public static void write(final boolean lllllllllllllIlIlIIlllIIIIlllIll) {
        checkSetupFBO();
        GL11.glClearStencil(0);
        GL11.glClear(1024);
        GL11.glEnable(2960);
        GL11.glStencilFunc(519, 1, 65535);
        GL11.glStencilOp(7680, 7680, 7681);
        if (!lllllllllllllIlIlIIlllIIIIlllIll) {
            GlStateManager.colorMask(false, false, false, false);
        }
    }
    
    public static void erase(final boolean lllllllllllllIlIlIIlllIIIIllllll) {
        GL11.glStencilFunc(lllllllllllllIlIlIIlllIIIIllllll ? 514 : 517, 1, 65535);
        GL11.glStencilOp(7680, 7680, 7681);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.enableAlpha();
        GlStateManager.enableBlend();
        GL11.glAlphaFunc(516, 0.0f);
    }
    
    public static void setupFBO(final Framebuffer lllllllllllllIlIlIIlllIIIIllIlIl) {
        EXTFramebufferObject.glDeleteRenderbuffersEXT(lllllllllllllIlIlIIlllIIIIllIlIl.depthBuffer);
        final int lllllllllllllIlIlIIlllIIIIllIlII = EXTFramebufferObject.glGenRenderbuffersEXT();
        EXTFramebufferObject.glBindRenderbufferEXT(36161, lllllllllllllIlIlIIlllIIIIllIlII);
        EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
        EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, lllllllllllllIlIlIIlllIIIIllIlII);
        EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, lllllllllllllIlIlIIlllIIIIllIlII);
    }
    
    static {
        StencilUtils.mc = Minecraft.getMinecraft();
    }
    
    public static void checkSetupFBO() {
        final Framebuffer lllllllllllllIlIlIIlllIIIIlllIIl = StencilUtils.mc.getFramebuffer();
        if (lllllllllllllIlIlIIlllIIIIlllIIl != null && lllllllllllllIlIlIIlllIIIIlllIIl.depthBuffer > -1) {
            setupFBO(lllllllllllllIlIlIIlllIIIIlllIIl);
            lllllllllllllIlIlIIlllIIIIlllIIl.depthBuffer = -1;
        }
    }
    
    public static void dispose() {
        GL11.glDisable(2960);
        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
    }
}
