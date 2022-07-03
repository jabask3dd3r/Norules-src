package net.minecraft.client.renderer;

import org.lwjgl.util.vector.*;
import java.nio.*;
import org.lwjgl.*;
import optifine.*;
import javax.annotation.*;
import org.lwjgl.opengl.*;

public class GlStateManager
{
    private static final /* synthetic */ BooleanState normalizeState;
    private static final /* synthetic */ CullState cullState;
    private static final /* synthetic */ BooleanState rescaleNormalState;
    private static final /* synthetic */ AlphaState alphaState;
    private static final /* synthetic */ BooleanState[] lightState;
    private static final /* synthetic */ ColorMaterialState colorMaterialState;
    private static final /* synthetic */ TexGenState texGenState;
    private static /* synthetic */ int activeTextureUnit;
    private static final /* synthetic */ BlendState blendState;
    private static /* synthetic */ int activeShadeModel;
    private static final /* synthetic */ ColorMask colorMaskState;
    private static final /* synthetic */ BooleanState lightingState;
    private static final /* synthetic */ ColorLogicState colorLogicState;
    private static final /* synthetic */ TextureState[] textureState;
    private static final /* synthetic */ Color colorState;
    public static /* synthetic */ boolean clearEnabled;
    private static final /* synthetic */ DepthState depthState;
    private static final /* synthetic */ PolygonOffsetState polygonOffsetState;
    private static final /* synthetic */ FloatBuffer BUF_FLOAT_16;
    private static final /* synthetic */ FloatBuffer BUF_FLOAT_4;
    private static final /* synthetic */ FogState fogState;
    private static final /* synthetic */ ClearState clearState;
    
    public static void pushMatrix() {
        GL11.glPushMatrix();
    }
    
    public static void glTexCoordPointer(final int lllllllllllllIlIlIlIIIllIlllIIIl, final int lllllllllllllIlIlIlIIIllIlllIlII, final int lllllllllllllIlIlIlIIIllIlllIIll, final ByteBuffer lllllllllllllIlIlIlIIIllIlllIIlI) {
        GL11.glTexCoordPointer(lllllllllllllIlIlIlIIIllIlllIIIl, lllllllllllllIlIlIlIIIllIlllIlII, lllllllllllllIlIlIlIIIllIlllIIll, lllllllllllllIlIlIlIIIllIlllIIlI);
    }
    
    public static void disableBlend() {
        GlStateManager.blendState.blend.setDisabled();
    }
    
    public static String glGetString(final int lllllllllllllIlIlIlIIIlIlllllIIl) {
        return GL11.glGetString(lllllllllllllIlIlIlIIIlIlllllIIl);
    }
    
    public static void translate(final float lllllllllllllIlIlIlIIIlllllIlIII, final float lllllllllllllIlIlIlIIIlllllIIlII, final float lllllllllllllIlIlIlIIIlllllIIllI) {
        GL11.glTranslatef(lllllllllllllIlIlIlIIIlllllIlIII, lllllllllllllIlIlIlIIIlllllIIlII, lllllllllllllIlIlIlIIIlllllIIllI);
    }
    
    public static void glDrawArrays(final int lllllllllllllIlIlIlIIIllIIllIIIl, final int lllllllllllllIlIlIlIIIllIIllIIII, final int lllllllllllllIlIlIlIIIllIIlIllII) {
        GL11.glDrawArrays(lllllllllllllIlIlIlIIIllIIllIIIl, lllllllllllllIlIlIlIIIllIIllIIII, lllllllllllllIlIlIlIIIllIIlIllII);
    }
    
    public static void clearColor(final float lllllllllllllIlIlIlIIlIIIlIIIIlI, final float lllllllllllllIlIlIlIIlIIIlIIIIIl, final float lllllllllllllIlIlIlIIlIIIIllllll, final float lllllllllllllIlIlIlIIlIIIIllllIl) {
        if (lllllllllllllIlIlIlIIlIIIlIIIIlI != GlStateManager.clearState.color.red || lllllllllllllIlIlIlIIlIIIlIIIIIl != GlStateManager.clearState.color.green || lllllllllllllIlIlIlIIlIIIIllllll != GlStateManager.clearState.color.blue || lllllllllllllIlIlIlIIlIIIIllllIl != GlStateManager.clearState.color.alpha) {
            GlStateManager.clearState.color.red = lllllllllllllIlIlIlIIlIIIlIIIIlI;
            GlStateManager.clearState.color.green = lllllllllllllIlIlIlIIlIIIlIIIIIl;
            GlStateManager.clearState.color.blue = lllllllllllllIlIlIlIIlIIIIllllll;
            GlStateManager.clearState.color.alpha = lllllllllllllIlIlIlIIlIIIIllllIl;
            GL11.glClearColor(lllllllllllllIlIlIlIIlIIIlIIIIlI, lllllllllllllIlIlIlIIlIIIlIIIIIl, lllllllllllllIlIlIlIIlIIIIllllll, lllllllllllllIlIlIlIIlIIIIllllIl);
        }
    }
    
    public static void glDisableClientState(final int lllllllllllllIlIlIlIIIllIIllllII) {
        GL11.glDisableClientState(lllllllllllllIlIlIlIIIllIIllllII);
    }
    
    public static void enableCull() {
        GlStateManager.cullState.cullFace.setEnabled();
    }
    
    public static void cullFace(final CullFace lllllllllllllIlIlIlIIlIlIlIllllI) {
        cullFace(lllllllllllllIlIlIlIIlIlIlIllllI.mode);
    }
    
    public static int getBoundTexture() {
        return GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName;
    }
    
    public static void enableOutlineMode(final int lllllllllllllIlIlIlIIlIlIlllllIl) {
        GlStateManager.BUF_FLOAT_4.put(0, (lllllllllllllIlIlIlIIlIlIlllllIl >> 16 & 0xFF) / 255.0f);
        GlStateManager.BUF_FLOAT_4.put(1, (lllllllllllllIlIlIlIIlIlIlllllIl >> 8 & 0xFF) / 255.0f);
        GlStateManager.BUF_FLOAT_4.put(2, (lllllllllllllIlIlIlIIlIlIlllllIl >> 0 & 0xFF) / 255.0f);
        GlStateManager.BUF_FLOAT_4.put(3, (lllllllllllllIlIlIlIIlIlIlllllIl >> 24 & 0xFF) / 255.0f);
        glTexEnv(8960, 8705, GlStateManager.BUF_FLOAT_4);
        glTexEnvi(8960, 8704, 34160);
        glTexEnvi(8960, 34161, 7681);
        glTexEnvi(8960, 34176, 34166);
        glTexEnvi(8960, 34192, 768);
        glTexEnvi(8960, 34162, 7681);
        glTexEnvi(8960, 34184, 5890);
        glTexEnvi(8960, 34200, 770);
    }
    
    public static void enableFog() {
        GlStateManager.fogState.fog.setEnabled();
    }
    
    public static void blendFunc(final int lllllllllllllIlIlIlIIlIllIIllIll, final int lllllllllllllIlIlIlIIlIllIIlllII) {
        if (lllllllllllllIlIlIlIIlIllIIllIll != GlStateManager.blendState.srcFactor || lllllllllllllIlIlIlIIlIllIIlllII != GlStateManager.blendState.dstFactor) {
            GlStateManager.blendState.srcFactor = lllllllllllllIlIlIlIIlIllIIllIll;
            GlStateManager.blendState.dstFactor = lllllllllllllIlIlIlIIlIllIIlllII;
            GL11.glBlendFunc(lllllllllllllIlIlIlIIlIllIIllIll, lllllllllllllIlIlIlIIlIllIIlllII);
        }
    }
    
    public static void ortho(final double lllllllllllllIlIlIlIIlIIIIIIllll, final double lllllllllllllIlIlIlIIlIIIIIlIlII, final double lllllllllllllIlIlIlIIlIIIIIIllIl, final double lllllllllllllIlIlIlIIlIIIIIlIIlI, final double lllllllllllllIlIlIlIIlIIIIIIlIll, final double lllllllllllllIlIlIlIIlIIIIIIlIlI) {
        GL11.glOrtho(lllllllllllllIlIlIlIIlIIIIIIllll, lllllllllllllIlIlIlIIlIIIIIlIlII, lllllllllllllIlIlIlIIlIIIIIIllIl, lllllllllllllIlIlIlIIlIIIIIlIIlI, lllllllllllllIlIlIlIIlIIIIIIlIll, lllllllllllllIlIlIlIIlIIIIIIlIlI);
    }
    
    public static int glGetInteger(final int lllllllllllllIlIlIlIIIlIllllIIIl) {
        return GL11.glGetInteger(lllllllllllllIlIlIlIIIlIllllIIIl);
    }
    
    public static void scale(final float lllllllllllllIlIlIlIIIllllllIlll, final float lllllllllllllIlIlIlIIIllllllIllI, final float lllllllllllllIlIlIlIIIlllllllIII) {
        GL11.glScalef(lllllllllllllIlIlIlIIIllllllIlll, lllllllllllllIlIlIlIIIllllllIllI, lllllllllllllIlIlIlIIIlllllllIII);
    }
    
    public static void glEnableClientState(final int lllllllllllllIlIlIlIIIllIIlllIIl) {
        GL11.glEnableClientState(lllllllllllllIlIlIlIIIllIIlllIIl);
    }
    
    public static void glFog(final int lllllllllllllIlIlIlIIlIlIllIlIlI, final FloatBuffer lllllllllllllIlIlIlIIlIlIllIIlll) {
        GL11.glFog(lllllllllllllIlIlIlIIlIlIllIlIlI, lllllllllllllIlIlIlIIlIlIllIIlll);
    }
    
    public static void popMatrix() {
        GL11.glPopMatrix();
    }
    
    public static void depthFunc(final int lllllllllllllIlIlIlIIlIllIlIlIlI) {
        if (lllllllllllllIlIlIlIIlIllIlIlIlI != GlStateManager.depthState.depthFunc) {
            GlStateManager.depthState.depthFunc = lllllllllllllIlIlIlIIlIllIlIlIlI;
            GL11.glDepthFunc(lllllllllllllIlIlIlIIlIllIlIlIlI);
        }
    }
    
    public static boolean isFogEnabled() {
        return GlStateManager.fogState.fog.currentState;
    }
    
    public static void glLineWidth(final float lllllllllllllIlIlIlIIIllIIlIlIIl) {
        GL11.glLineWidth(lllllllllllllIlIlIlIIIllIIlIlIIl);
    }
    
    public static void disableDepth() {
        GlStateManager.depthState.depthTest.setDisabled();
    }
    
    public static void enableAlpha() {
        GlStateManager.alphaState.alphaTest.setEnabled();
    }
    
    public static void matrixMode(final int lllllllllllllIlIlIlIIlIIIIlIlIIl) {
        GL11.glMatrixMode(lllllllllllllIlIlIlIIlIIIIlIlIIl);
    }
    
    public static void disableLight(final int lllllllllllllIlIlIlIIlIlllIIlIll) {
        GlStateManager.lightState[lllllllllllllIlIlIlIIlIlllIIlIll].setDisabled();
    }
    
    public static void disableFog() {
        GlStateManager.fogState.fog.setDisabled();
    }
    
    public static void glTexCoordPointer(final int lllllllllllllIlIlIlIIIllIlllllIl, final int lllllllllllllIlIlIlIIIlllIIIIIII, final int lllllllllllllIlIlIlIIIllIllllIll, final int lllllllllllllIlIlIlIIIllIllllllI) {
        GL11.glTexCoordPointer(lllllllllllllIlIlIlIIIllIlllllIl, lllllllllllllIlIlIlIIIlllIIIIIII, lllllllllllllIlIlIlIIIllIllllIll, (long)lllllllllllllIlIlIlIIIllIllllllI);
    }
    
    public static void enableBlend() {
        GlStateManager.blendState.blend.setEnabled();
    }
    
    public static void enableColorMaterial() {
        GlStateManager.colorMaterialState.colorMaterial.setEnabled();
    }
    
    public static void setFogStart(final float lllllllllllllIlIlIlIIlIlIlllIIII) {
        if (lllllllllllllIlIlIlIIlIlIlllIIII != GlStateManager.fogState.start) {
            GlStateManager.fogState.start = lllllllllllllIlIlIlIIlIlIlllIIII;
            GL11.glFogf(2915, lllllllllllllIlIlIlIIlIlIlllIIII);
        }
    }
    
    public static void viewport(final int lllllllllllllIlIlIlIIlIIIlllllIl, final int lllllllllllllIlIlIlIIlIIIlllllII, final int lllllllllllllIlIlIlIIlIIIllllIll, final int lllllllllllllIlIlIlIIlIIIllllllI) {
        GL11.glViewport(lllllllllllllIlIlIlIIlIIIlllllIl, lllllllllllllIlIlIlIIlIIIlllllII, lllllllllllllIlIlIlIIlIIIllllIll, lllllllllllllIlIlIlIIlIIIllllllI);
    }
    
    public static void glTexParameterf(final int lllllllllllllIlIlIlIIlIlIIIIlIIl, final int lllllllllllllIlIlIlIIlIlIIIIlIll, final float lllllllllllllIlIlIlIIlIlIIIIlIlI) {
        GL11.glTexParameterf(lllllllllllllIlIlIlIIlIlIIIIlIIl, lllllllllllllIlIlIlIIlIlIIIIlIll, lllllllllllllIlIlIlIIlIlIIIIlIlI);
    }
    
    public static void setFogEnabled(final boolean lllllllllllllIlIlIlIIIlIllIlIlIl) {
        GlStateManager.fogState.fog.setState(lllllllllllllIlIlIlIIIlIllIlIlIl);
    }
    
    public static void enableColorLogic() {
        GlStateManager.colorLogicState.colorLogicOp.setEnabled();
    }
    
    public static void bindCurrentTexture() {
        GL11.glBindTexture(3553, GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName);
    }
    
    public static void enableDepth() {
        GlStateManager.depthState.depthTest.setEnabled();
    }
    
    public static void multMatrix(final FloatBuffer lllllllllllllIlIlIlIIIllllIllIII) {
        GL11.glMultMatrix(lllllllllllllIlIlIlIIIllllIllIII);
    }
    
    public static void glBegin(final int lllllllllllllIlIlIlIIIllIIllIllI) {
        GL11.glBegin(lllllllllllllIlIlIlIIIllIIllIllI);
    }
    
    public static void rotate(final Quaternion lllllllllllllIlIlIlIIIllllIlIlIl) {
        multMatrix(quatToGlMatrix(GlStateManager.BUF_FLOAT_16, lllllllllllllIlIlIlIIIllllIlIlIl));
    }
    
    public static void glLight(final int lllllllllllllIlIlIlIIlIllIllllIl, final int lllllllllllllIlIlIlIIlIllIllllII, final FloatBuffer lllllllllllllIlIlIlIIlIllIlllIll) {
        GL11.glLight(lllllllllllllIlIlIlIIlIllIllllIl, lllllllllllllIlIlIlIIlIllIllllII, lllllllllllllIlIlIlIIlIllIlllIll);
    }
    
    public static void glPixelStorei(final int lllllllllllllIlIlIlIIIllIIIlIIlI, final int lllllllllllllIlIlIlIIIllIIIlIIIl) {
        GL11.glPixelStorei(lllllllllllllIlIlIlIIIllIIIlIIlI, lllllllllllllIlIlIlIIIllIIIlIIIl);
    }
    
    public static void deleteTexture(final int lllllllllllllIlIlIlIIlIIlllIllIl) {
        if (lllllllllllllIlIlIlIIlIIlllIllIl != 0) {
            GL11.glDeleteTextures(lllllllllllllIlIlIlIIlIIlllIllIl);
            final int lllllllllllllIlIlIlIIlIIlllIlIIl;
            final double lllllllllllllIlIlIlIIlIIlllIlIlI = ((TextureState[])(Object)(lllllllllllllIlIlIlIIlIIlllIlIIl = (int)(Object)GlStateManager.textureState)).length;
            for (Exception lllllllllllllIlIlIlIIlIIlllIlIll = (Exception)0; lllllllllllllIlIlIlIIlIIlllIlIll < lllllllllllllIlIlIlIIlIIlllIlIlI; ++lllllllllllllIlIlIlIIlIIlllIlIll) {
                final TextureState lllllllllllllIlIlIlIIlIIlllIlllI = lllllllllllllIlIlIlIIlIIlllIlIIl[lllllllllllllIlIlIlIIlIIlllIlIll];
                if (lllllllllllllIlIlIlIIlIIlllIlllI.textureName == lllllllllllllIlIlIlIIlIIlllIllIl) {
                    lllllllllllllIlIlIlIIlIIlllIlllI.textureName = 0;
                }
            }
        }
    }
    
    public static void colorMaterial(final int lllllllllllllIlIlIlIIlIlllIIIlll, final int lllllllllllllIlIlIlIIlIlllIIIllI) {
        if (lllllllllllllIlIlIlIIlIlllIIIlll != GlStateManager.colorMaterialState.face || lllllllllllllIlIlIlIIlIlllIIIllI != GlStateManager.colorMaterialState.mode) {
            GlStateManager.colorMaterialState.face = lllllllllllllIlIlIlIIlIlllIIIlll;
            GlStateManager.colorMaterialState.mode = lllllllllllllIlIlIlIIlIlllIIIllI;
            GL11.glColorMaterial(lllllllllllllIlIlIlIIlIlllIIIlll, lllllllllllllIlIlIlIIlIlllIIIllI);
        }
    }
    
    public static void disableLighting() {
        GlStateManager.lightingState.setDisabled();
    }
    
    public static void clearDepth(final double lllllllllllllIlIlIlIIlIIIllIIllI) {
        if (lllllllllllllIlIlIlIIlIIIllIIllI != GlStateManager.clearState.depth) {
            GlStateManager.clearState.depth = lllllllllllllIlIlIlIIlIIIllIIllI;
            GL11.glClearDepth(lllllllllllllIlIlIlIIlIIIllIIllI);
        }
    }
    
    public static void glReadPixels(final int lllllllllllllIlIlIlIIIllIIIIIIlI, final int lllllllllllllIlIlIlIIIllIIIIlIII, final int lllllllllllllIlIlIlIIIllIIIIIlll, final int lllllllllllllIlIlIlIIIllIIIIIllI, final int lllllllllllllIlIlIlIIIlIlllllllI, final int lllllllllllllIlIlIlIIIllIIIIIlII, final IntBuffer lllllllllllllIlIlIlIIIlIllllllII) {
        GL11.glReadPixels(lllllllllllllIlIlIlIIIllIIIIIIlI, lllllllllllllIlIlIlIIIllIIIIlIII, lllllllllllllIlIlIlIIIllIIIIIlll, lllllllllllllIlIlIlIIIllIIIIIllI, lllllllllllllIlIlIlIIIlIlllllllI, lllllllllllllIlIlIlIIIllIIIIIlII, lllllllllllllIlIlIlIIIlIllllllII);
    }
    
    public static void enableRescaleNormal() {
        GlStateManager.rescaleNormalState.setEnabled();
    }
    
    public static void setActiveTexture(final int lllllllllllllIlIlIlIIlIlIIlIllII) {
        if (GlStateManager.activeTextureUnit != lllllllllllllIlIlIlIIlIlIIlIllII - OpenGlHelper.defaultTexUnit) {
            GlStateManager.activeTextureUnit = lllllllllllllIlIlIlIIlIlIIlIllII - OpenGlHelper.defaultTexUnit;
            OpenGlHelper.setActiveTexture(lllllllllllllIlIlIlIIlIlIIlIllII);
        }
    }
    
    public static void glNormalPointer(final int lllllllllllllIlIlIlIIIlllIIIlIII, final int lllllllllllllIlIlIlIIIlllIIIlIlI, final ByteBuffer lllllllllllllIlIlIlIIIlllIIIIllI) {
        GL11.glNormalPointer(lllllllllllllIlIlIlIIIlllIIIlIII, lllllllllllllIlIlIlIIIlllIIIlIlI, lllllllllllllIlIlIlIIIlllIIIIllI);
    }
    
    public static int glGetError() {
        return GL11.glGetError();
    }
    
    public static void enableNormalize() {
        GlStateManager.normalizeState.setEnabled();
    }
    
    public static void shadeModel(final int lllllllllllllIlIlIlIIlIIlIIIIlll) {
        if (lllllllllllllIlIlIlIIlIIlIIIIlll != GlStateManager.activeShadeModel) {
            GL11.glShadeModel(GlStateManager.activeShadeModel = lllllllllllllIlIlIlIIlIIlIIIIlll);
        }
    }
    
    public static void enableTexGenCoord(final TexGen lllllllllllllIlIlIlIIlIlIlIIIlll) {
        texGenCoord(lllllllllllllIlIlIlIIlIlIlIIIlll).textureGen.setEnabled();
    }
    
    public static void color(final float lllllllllllllIlIlIlIIIlllIlIIIll, final float lllllllllllllIlIlIlIIIlllIlIIIlI, final float lllllllllllllIlIlIlIIIlllIlIIIIl) {
        color(lllllllllllllIlIlIlIIIlllIlIIIll, lllllllllllllIlIlIlIIIlllIlIIIlI, lllllllllllllIlIlIlIIIlllIlIIIIl, 1.0f);
    }
    
    public static void disablePolygonOffset() {
        GlStateManager.polygonOffsetState.polygonOffsetFill.setDisabled();
    }
    
    public static void colorMask(final boolean lllllllllllllIlIlIlIIlIIIlllIIIl, final boolean lllllllllllllIlIlIlIIlIIIlllIlII, final boolean lllllllllllllIlIlIlIIlIIIlllIIll, final boolean lllllllllllllIlIlIlIIlIIIllIlllI) {
        if (lllllllllllllIlIlIlIIlIIIlllIIIl != GlStateManager.colorMaskState.red || lllllllllllllIlIlIlIIlIIIlllIlII != GlStateManager.colorMaskState.green || lllllllllllllIlIlIlIIlIIIlllIIll != GlStateManager.colorMaskState.blue || lllllllllllllIlIlIlIIlIIIllIlllI != GlStateManager.colorMaskState.alpha) {
            GlStateManager.colorMaskState.red = lllllllllllllIlIlIlIIlIIIlllIIIl;
            GlStateManager.colorMaskState.green = lllllllllllllIlIlIlIIlIIIlllIlII;
            GlStateManager.colorMaskState.blue = lllllllllllllIlIlIlIIlIIIlllIIll;
            GlStateManager.colorMaskState.alpha = lllllllllllllIlIlIlIIlIIIllIlllI;
            GL11.glColorMask(lllllllllllllIlIlIlIIlIIIlllIIIl, lllllllllllllIlIlIlIIlIIIlllIlII, lllllllllllllIlIlIlIIlIIIlllIIll, lllllllllllllIlIlIlIIlIIIllIlllI);
        }
    }
    
    public static void disableRescaleNormal() {
        GlStateManager.rescaleNormalState.setDisabled();
    }
    
    public static void disableOutlineMode() {
        glTexEnvi(8960, 8704, 8448);
        glTexEnvi(8960, 34161, 8448);
        glTexEnvi(8960, 34162, 8448);
        glTexEnvi(8960, 34176, 5890);
        glTexEnvi(8960, 34184, 5890);
        glTexEnvi(8960, 34192, 768);
        glTexEnvi(8960, 34200, 770);
    }
    
    public static void getFloat(final int lllllllllllllIlIlIlIIlIIIIIlllIl, final FloatBuffer lllllllllllllIlIlIlIIlIIIIIllllI) {
        GL11.glGetFloat(lllllllllllllIlIlIlIIlIIIIIlllIl, lllllllllllllIlIlIlIIlIIIIIllllI);
    }
    
    public static void popAttrib() {
        GL11.glPopAttrib();
    }
    
    public static void enableLighting() {
        GlStateManager.lightingState.setEnabled();
    }
    
    public static void glCopyTexSubImage2D(final int lllllllllllllIlIlIlIIlIIlIIlllll, final int lllllllllllllIlIlIlIIlIIlIIllllI, final int lllllllllllllIlIlIlIIlIIlIIlllIl, final int lllllllllllllIlIlIlIIlIIlIIlllII, final int lllllllllllllIlIlIlIIlIIlIlIIIll, final int lllllllllllllIlIlIlIIlIIlIIllIlI, final int lllllllllllllIlIlIlIIlIIlIIllIIl, final int lllllllllllllIlIlIlIIlIIlIlIIIII) {
        GL11.glCopyTexSubImage2D(lllllllllllllIlIlIlIIlIIlIIlllll, lllllllllllllIlIlIlIIlIIlIIllllI, lllllllllllllIlIlIlIIlIIlIIlllIl, lllllllllllllIlIlIlIIlIIlIIlllII, lllllllllllllIlIlIlIIlIIlIlIIIll, lllllllllllllIlIlIlIIlIIlIIllIlI, lllllllllllllIlIlIlIIlIIlIIllIIl, lllllllllllllIlIlIlIIlIIlIlIIIII);
    }
    
    public static void disableNormalize() {
        GlStateManager.normalizeState.setDisabled();
    }
    
    public static void deleteTextures(final IntBuffer lllllllllllllIlIlIlIIIlIllIllIll) {
        lllllllllllllIlIlIlIIIlIllIllIll.rewind();
        while (lllllllllllllIlIlIlIIIlIllIllIll.position() < lllllllllllllIlIlIlIIIlIllIllIll.limit()) {
            final int lllllllllllllIlIlIlIIIlIllIllIlI = lllllllllllllIlIlIlIIIlIllIllIll.get();
            deleteTexture(lllllllllllllIlIlIlIIIlIllIllIlI);
        }
        lllllllllllllIlIlIlIIIlIllIllIll.rewind();
    }
    
    public static void setFog(final FogMode lllllllllllllIlIlIlIIlIlIllllIlI) {
        setFog(lllllllllllllIlIlIlIIlIlIllllIlI.capabilityId);
    }
    
    public static void glFogi(final int lllllllllllllIlIlIlIIlIlIllIIlII, final int lllllllllllllIlIlIlIIlIlIllIIIIl) {
        GL11.glFogi(lllllllllllllIlIlIlIIlIlIllIIlII, lllllllllllllIlIlIlIIlIlIllIIIIl);
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen = GlStateManager.$SWITCH_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen;
        if ($switch_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen != null) {
            return $switch_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen;
        }
        final long lllllllllllllIlIlIlIIIlIllIIllIl = (Object)new int[TexGen.values().length];
        try {
            lllllllllllllIlIlIlIIIlIllIIllIl[TexGen.Q.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlIlIlIIIlIllIIllIl[TexGen.R.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlIlIlIIIlIllIIllIl[TexGen.S.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlIlIlIIIlIllIIllIl[TexGen.T.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        return GlStateManager.$SWITCH_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen = (int[])(Object)lllllllllllllIlIlIlIIIlIllIIllIl;
    }
    
    public static void glBlendEquation(final int lllllllllllllIlIlIlIIlIlIlllllll) {
        GL14.glBlendEquation(lllllllllllllIlIlIlIIlIlIlllllll);
    }
    
    public static void disableCull() {
        GlStateManager.cullState.cullFace.setDisabled();
    }
    
    public static void scale(final double lllllllllllllIlIlIlIIIlllllIlllI, final double lllllllllllllIlIlIlIIIllllllIIII, final double lllllllllllllIlIlIlIIIlllllIllll) {
        GL11.glScaled(lllllllllllllIlIlIlIIIlllllIlllI, lllllllllllllIlIlIlIIIllllllIIII, lllllllllllllIlIlIlIIIlllllIllll);
    }
    
    public static FloatBuffer quatToGlMatrix(final FloatBuffer lllllllllllllIlIlIlIIIlllIllllIl, final Quaternion lllllllllllllIlIlIlIIIlllIllllII) {
        lllllllllllllIlIlIlIIIlllIllllIl.clear();
        final float lllllllllllllIlIlIlIIIllllIIIllI = lllllllllllllIlIlIlIIIlllIllllII.x * lllllllllllllIlIlIlIIIlllIllllII.x;
        final float lllllllllllllIlIlIlIIIllllIIIlIl = lllllllllllllIlIlIlIIIlllIllllII.x * lllllllllllllIlIlIlIIIlllIllllII.y;
        final float lllllllllllllIlIlIlIIIllllIIIlII = lllllllllllllIlIlIlIIIlllIllllII.x * lllllllllllllIlIlIlIIIlllIllllII.z;
        final float lllllllllllllIlIlIlIIIllllIIIIll = lllllllllllllIlIlIlIIIlllIllllII.x * lllllllllllllIlIlIlIIIlllIllllII.w;
        final float lllllllllllllIlIlIlIIIllllIIIIlI = lllllllllllllIlIlIlIIIlllIllllII.y * lllllllllllllIlIlIlIIIlllIllllII.y;
        final float lllllllllllllIlIlIlIIIllllIIIIIl = lllllllllllllIlIlIlIIIlllIllllII.y * lllllllllllllIlIlIlIIIlllIllllII.z;
        final float lllllllllllllIlIlIlIIIllllIIIIII = lllllllllllllIlIlIlIIIlllIllllII.y * lllllllllllllIlIlIlIIIlllIllllII.w;
        final float lllllllllllllIlIlIlIIIlllIllllll = lllllllllllllIlIlIlIIIlllIllllII.z * lllllllllllllIlIlIlIIIlllIllllII.z;
        final float lllllllllllllIlIlIlIIIlllIlllllI = lllllllllllllIlIlIlIIIlllIllllII.z * lllllllllllllIlIlIlIIIlllIllllII.w;
        lllllllllllllIlIlIlIIIlllIllllIl.put(1.0f - 2.0f * (lllllllllllllIlIlIlIIIllllIIIIlI + lllllllllllllIlIlIlIIIlllIllllll));
        lllllllllllllIlIlIlIIIlllIllllIl.put(2.0f * (lllllllllllllIlIlIlIIIllllIIIlIl + lllllllllllllIlIlIlIIIlllIlllllI));
        lllllllllllllIlIlIlIIIlllIllllIl.put(2.0f * (lllllllllllllIlIlIlIIIllllIIIlII - lllllllllllllIlIlIlIIIllllIIIIII));
        lllllllllllllIlIlIlIIIlllIllllIl.put(0.0f);
        lllllllllllllIlIlIlIIIlllIllllIl.put(2.0f * (lllllllllllllIlIlIlIIIllllIIIlIl - lllllllllllllIlIlIlIIIlllIlllllI));
        lllllllllllllIlIlIlIIIlllIllllIl.put(1.0f - 2.0f * (lllllllllllllIlIlIlIIIllllIIIllI + lllllllllllllIlIlIlIIIlllIllllll));
        lllllllllllllIlIlIlIIIlllIllllIl.put(2.0f * (lllllllllllllIlIlIlIIIllllIIIIIl + lllllllllllllIlIlIlIIIllllIIIIll));
        lllllllllllllIlIlIlIIIlllIllllIl.put(0.0f);
        lllllllllllllIlIlIlIIIlllIllllIl.put(2.0f * (lllllllllllllIlIlIlIIIllllIIIlII + lllllllllllllIlIlIlIIIllllIIIIII));
        lllllllllllllIlIlIlIIIlllIllllIl.put(2.0f * (lllllllllllllIlIlIlIIIllllIIIIIl - lllllllllllllIlIlIlIIIllllIIIIll));
        lllllllllllllIlIlIlIIIlllIllllIl.put(1.0f - 2.0f * (lllllllllllllIlIlIlIIIllllIIIllI + lllllllllllllIlIlIlIIIllllIIIIlI));
        lllllllllllllIlIlIlIIIlllIllllIl.put(0.0f);
        lllllllllllllIlIlIlIIIlllIllllIl.put(0.0f);
        lllllllllllllIlIlIlIIIlllIllllIl.put(0.0f);
        lllllllllllllIlIlIlIIIlllIllllIl.put(0.0f);
        lllllllllllllIlIlIlIIIlllIllllIl.put(1.0f);
        lllllllllllllIlIlIlIIIlllIllllIl.rewind();
        return lllllllllllllIlIlIlIIIlllIllllIl;
    }
    
    private static TexGenCoord texGenCoord(final TexGen lllllllllllllIlIlIlIIlIlIIlIlllI) {
        switch ($SWITCH_TABLE$net$minecraft$client$renderer$GlStateManager$TexGen()[lllllllllllllIlIlIlIIlIlIIlIlllI.ordinal()]) {
            case 1: {
                return GlStateManager.texGenState.s;
            }
            case 2: {
                return GlStateManager.texGenState.t;
            }
            case 3: {
                return GlStateManager.texGenState.r;
            }
            case 4: {
                return GlStateManager.texGenState.q;
            }
            default: {
                return GlStateManager.texGenState.s;
            }
        }
    }
    
    public static void resetColor() {
        GlStateManager.colorState.red = -1.0f;
        GlStateManager.colorState.green = -1.0f;
        GlStateManager.colorState.blue = -1.0f;
        GlStateManager.colorState.alpha = -1.0f;
    }
    
    public static void glVertexPointer(final int lllllllllllllIlIlIlIIIllIllIIlIl, final int lllllllllllllIlIlIlIIIllIllIIlII, final int lllllllllllllIlIlIlIIIllIllIIIll, final int lllllllllllllIlIlIlIIIllIllIIllI) {
        GL11.glVertexPointer(lllllllllllllIlIlIlIIIllIllIIlIl, lllllllllllllIlIlIlIIIllIllIIlII, lllllllllllllIlIlIlIIIllIllIIIll, (long)lllllllllllllIlIlIlIIIllIllIIllI);
    }
    
    public static void glColorPointer(final int lllllllllllllIlIlIlIIIllIlIIIIIl, final int lllllllllllllIlIlIlIIIllIlIIIlII, final int lllllllllllllIlIlIlIIIllIIllllll, final ByteBuffer lllllllllllllIlIlIlIIIllIIlllllI) {
        GL11.glColorPointer(lllllllllllllIlIlIlIIIllIlIIIIIl, lllllllllllllIlIlIlIIIllIlIIIlII, lllllllllllllIlIlIlIIIllIIllllll, lllllllllllllIlIlIlIIIllIIlllllI);
    }
    
    public static void glTexParameteri(final int lllllllllllllIlIlIlIIlIlIIIIIIII, final int lllllllllllllIlIlIlIIlIIllllllll, final int lllllllllllllIlIlIlIIlIIlllllllI) {
        GL11.glTexParameteri(lllllllllllllIlIlIlIIlIlIIIIIIII, lllllllllllllIlIlIlIIlIIllllllll, lllllllllllllIlIlIlIIlIIlllllllI);
    }
    
    public static void enableLight(final int lllllllllllllIlIlIlIIlIlllIIllIl) {
        GlStateManager.lightState[lllllllllllllIlIlIlIIlIlllIIllIl].setEnabled();
    }
    
    public static void glPolygonMode(final int lllllllllllllIlIlIlIIlIlIlIlIllI, final int lllllllllllllIlIlIlIIlIlIlIlIlIl) {
        GL11.glPolygonMode(lllllllllllllIlIlIlIIlIlIlIlIllI, lllllllllllllIlIlIlIIlIlIlIlIlIl);
    }
    
    public static void enableTexture2D() {
        GlStateManager.textureState[GlStateManager.activeTextureUnit].texture2DState.setEnabled();
    }
    
    public static void glNormal3f(final float lllllllllllllIlIlIlIIlIllIlIlllI, final float lllllllllllllIlIlIlIIlIllIlIllIl, final float lllllllllllllIlIlIlIIlIllIlIllII) {
        GL11.glNormal3f(lllllllllllllIlIlIlIIlIllIlIlllI, lllllllllllllIlIlIlIIlIllIlIllIl, lllllllllllllIlIlIlIIlIllIlIllII);
    }
    
    public static void texGen(final TexGen lllllllllllllIlIlIlIIlIlIIllllII, final int lllllllllllllIlIlIlIIlIlIIlllIll) {
        final TexGenCoord lllllllllllllIlIlIlIIlIlIIllllIl = texGenCoord(lllllllllllllIlIlIlIIlIlIIllllII);
        if (lllllllllllllIlIlIlIIlIlIIlllIll != lllllllllllllIlIlIlIIlIlIIllllIl.param) {
            lllllllllllllIlIlIlIIlIlIIllllIl.param = lllllllllllllIlIlIlIIlIlIIlllIll;
            GL11.glTexGeni(lllllllllllllIlIlIlIIlIlIIllllIl.coord, 9472, lllllllllllllIlIlIlIIlIlIIlllIll);
        }
    }
    
    public static void glTexEnvi(final int lllllllllllllIlIlIlIIlIlIIIllIll, final int lllllllllllllIlIlIlIIlIlIIIllIlI, final int lllllllllllllIlIlIlIIlIlIIIllIIl) {
        GL11.glTexEnvi(lllllllllllllIlIlIlIIlIlIIIllIll, lllllllllllllIlIlIlIIlIlIIIllIlI, lllllllllllllIlIlIlIIlIlIIIllIIl);
    }
    
    public static void glGetTexImage(final int lllllllllllllIlIlIlIIlIIlIIIllIl, final int lllllllllllllIlIlIlIIlIIlIIIllII, final int lllllllllllllIlIlIlIIlIIlIIlIIII, final int lllllllllllllIlIlIlIIlIIlIIIlIlI, final IntBuffer lllllllllllllIlIlIlIIlIIlIIIlllI) {
        GL11.glGetTexImage(lllllllllllllIlIlIlIIlIIlIIIllIl, lllllllllllllIlIlIlIIlIIlIIIllII, lllllllllllllIlIlIlIIlIIlIIlIIII, lllllllllllllIlIlIlIIlIIlIIIlIlI, lllllllllllllIlIlIlIIlIIlIIIlllI);
    }
    
    public static void disableAlpha() {
        GlStateManager.alphaState.alphaTest.setDisabled();
    }
    
    public static void doPolygonOffset(final float lllllllllllllIlIlIlIIlIlIlIlIIlI, final float lllllllllllllIlIlIlIIlIlIlIIllll) {
        if (lllllllllllllIlIlIlIIlIlIlIlIIlI != GlStateManager.polygonOffsetState.factor || lllllllllllllIlIlIlIIlIlIlIIllll != GlStateManager.polygonOffsetState.units) {
            GlStateManager.polygonOffsetState.factor = lllllllllllllIlIlIlIIlIlIlIlIIlI;
            GlStateManager.polygonOffsetState.units = lllllllllllllIlIlIlIIlIlIlIIllll;
            GL11.glPolygonOffset(lllllllllllllIlIlIlIIlIlIlIlIIlI, lllllllllllllIlIlIlIIlIlIlIIllll);
        }
    }
    
    public static void glVertex3f(final float lllllllllllllIlIlIlIIIlllIIlIIIl, final float lllllllllllllIlIlIlIIIlllIIlIIll, final float lllllllllllllIlIlIlIIIlllIIlIIlI) {
        GL11.glVertex3f(lllllllllllllIlIlIlIIIlllIIlIIIl, lllllllllllllIlIlIlIIIlllIIlIIll, lllllllllllllIlIlIlIIIlllIIlIIlI);
    }
    
    public static void glColorPointer(final int lllllllllllllIlIlIlIIIllIlIlIIIl, final int lllllllllllllIlIlIlIIIllIlIIllII, final int lllllllllllllIlIlIlIIIllIlIIlIll, final int lllllllllllllIlIlIlIIIllIlIIlIlI) {
        GL11.glColorPointer(lllllllllllllIlIlIlIIIllIlIlIIIl, lllllllllllllIlIlIlIIIllIlIIllII, lllllllllllllIlIlIlIIIllIlIIlIll, (long)lllllllllllllIlIlIlIIIllIlIIlIlI);
    }
    
    public static void color(final float lllllllllllllIlIlIlIIIlllIlIlIlI, final float lllllllllllllIlIlIlIIIlllIlIllIl, final float lllllllllllllIlIlIlIIIlllIlIllII, final float lllllllllllllIlIlIlIIIlllIlIlIll) {
        if (lllllllllllllIlIlIlIIIlllIlIlIlI != GlStateManager.colorState.red || lllllllllllllIlIlIlIIIlllIlIllIl != GlStateManager.colorState.green || lllllllllllllIlIlIlIIIlllIlIllII != GlStateManager.colorState.blue || lllllllllllllIlIlIlIIIlllIlIlIll != GlStateManager.colorState.alpha) {
            GlStateManager.colorState.red = lllllllllllllIlIlIlIIIlllIlIlIlI;
            GlStateManager.colorState.green = lllllllllllllIlIlIlIIIlllIlIllIl;
            GlStateManager.colorState.blue = lllllllllllllIlIlIlIIIlllIlIllII;
            GlStateManager.colorState.alpha = lllllllllllllIlIlIlIIIlllIlIlIll;
            GL11.glColor4f(lllllllllllllIlIlIlIIIlllIlIlIlI, lllllllllllllIlIlIlIIIlllIlIllIl, lllllllllllllIlIlIlIIIlllIlIllII, lllllllllllllIlIlIlIIIlllIlIlIll);
        }
    }
    
    public static void disableTexGenCoord(final TexGen lllllllllllllIlIlIlIIlIlIlIIIlII) {
        texGenCoord(lllllllllllllIlIlIlIIlIlIlIIIlII).textureGen.setDisabled();
    }
    
    public static void setFogDensity(final float lllllllllllllIlIlIlIIlIlIlllIIll) {
        if (lllllllllllllIlIlIlIIlIlIlllIIll != GlStateManager.fogState.density) {
            GlStateManager.fogState.density = lllllllllllllIlIlIlIIlIlIlllIIll;
            GL11.glFogf(2914, lllllllllllllIlIlIlIIlIlIlllIIll);
        }
    }
    
    public static void glTexEnv(final int lllllllllllllIlIlIlIIlIlIIlIIlII, final int lllllllllllllIlIlIlIIlIlIIlIIIll, final FloatBuffer lllllllllllllIlIlIlIIlIlIIlIIlIl) {
        GL11.glTexEnv(lllllllllllllIlIlIlIIlIlIIlIIlII, lllllllllllllIlIlIlIIlIlIIlIIIll, lllllllllllllIlIlIlIIlIlIIlIIlIl);
    }
    
    static {
        BUF_FLOAT_16 = BufferUtils.createFloatBuffer(16);
        BUF_FLOAT_4 = BufferUtils.createFloatBuffer(4);
        alphaState = new AlphaState(null);
        lightingState = new BooleanState(2896);
        lightState = new BooleanState[8];
        GlStateManager.clearEnabled = true;
        for (int lllllllllllllIlIlIlIIlIlllIllIll = 0; lllllllllllllIlIlIlIIlIlllIllIll < 8; ++lllllllllllllIlIlIlIIlIlllIllIll) {
            GlStateManager.lightState[lllllllllllllIlIlIlIIlIlllIllIll] = new BooleanState(16384 + lllllllllllllIlIlIlIIlIlllIllIll);
        }
        colorMaterialState = new ColorMaterialState(null);
        blendState = new BlendState(null);
        depthState = new DepthState(null);
        fogState = new FogState(null);
        cullState = new CullState(null);
        polygonOffsetState = new PolygonOffsetState(null);
        colorLogicState = new ColorLogicState(null);
        texGenState = new TexGenState(null);
        clearState = new ClearState(null);
        stencilState = new StencilState(null);
        normalizeState = new BooleanState(2977);
        textureState = new TextureState[32];
        for (int lllllllllllllIlIlIlIIlIlllIllIlI = 0; lllllllllllllIlIlIlIIlIlllIllIlI < GlStateManager.textureState.length; ++lllllllllllllIlIlIlIIlIlllIllIlI) {
            GlStateManager.textureState[lllllllllllllIlIlIlIIlIlllIllIlI] = new TextureState(null);
        }
        GlStateManager.activeShadeModel = 7425;
        rescaleNormalState = new BooleanState(32826);
        colorMaskState = new ColorMask(null);
        colorState = new Color();
    }
    
    public static void texGen(final TexGen lllllllllllllIlIlIlIIlIlIIllIIll, final int lllllllllllllIlIlIlIIlIlIIllIlIl, final FloatBuffer lllllllllllllIlIlIlIIlIlIIllIlII) {
        GL11.glTexGen(texGenCoord(lllllllllllllIlIlIlIIlIlIIllIIll).coord, lllllllllllllIlIlIlIIlIlIIllIlIl, lllllllllllllIlIlIlIIlIlIIllIlII);
    }
    
    public static void glLightModel(final int lllllllllllllIlIlIlIIlIllIllIllI, final FloatBuffer lllllllllllllIlIlIlIIlIllIllIlll) {
        GL11.glLightModel(lllllllllllllIlIlIlIIlIllIllIllI, lllllllllllllIlIlIlIIlIllIllIlll);
    }
    
    public static void disableTexture2D() {
        GlStateManager.textureState[GlStateManager.activeTextureUnit].texture2DState.setDisabled();
    }
    
    public static void callList(final int lllllllllllllIlIlIlIIIllIIlIIllI) {
        GL11.glCallList(lllllllllllllIlIlIlIIIllIIlIIllI);
    }
    
    public static void glEnd() {
        GL11.glEnd();
    }
    
    public static void glEndList() {
        GL11.glEndList();
    }
    
    public static void tryBlendFuncSeparate(final int lllllllllllllIlIlIlIIlIllIIIlIIl, final int lllllllllllllIlIlIlIIlIllIIIlIII, final int lllllllllllllIlIlIlIIlIllIIIIIll, final int lllllllllllllIlIlIlIIlIllIIIIIlI) {
        if (lllllllllllllIlIlIlIIlIllIIIlIIl != GlStateManager.blendState.srcFactor || lllllllllllllIlIlIlIIlIllIIIlIII != GlStateManager.blendState.dstFactor || lllllllllllllIlIlIlIIlIllIIIIIll != GlStateManager.blendState.srcFactorAlpha || lllllllllllllIlIlIlIIlIllIIIIIlI != GlStateManager.blendState.dstFactorAlpha) {
            GlStateManager.blendState.srcFactor = lllllllllllllIlIlIlIIlIllIIIlIIl;
            GlStateManager.blendState.dstFactor = lllllllllllllIlIlIlIIlIllIIIlIII;
            GlStateManager.blendState.srcFactorAlpha = lllllllllllllIlIlIlIIlIllIIIIIll;
            GlStateManager.blendState.dstFactorAlpha = lllllllllllllIlIlIlIIlIllIIIIIlI;
            OpenGlHelper.glBlendFunc(lllllllllllllIlIlIlIIlIllIIIlIIl, lllllllllllllIlIlIlIIlIllIIIlIII, lllllllllllllIlIlIlIIlIllIIIIIll, lllllllllllllIlIlIlIIlIllIIIIIlI);
        }
    }
    
    public static void enableBlendProfile(final Profile lllllllllllllIlIlIlIIIlIlllIlllI) {
        lllllllllllllIlIlIlIIIlIlllIlllI.apply();
    }
    
    public static void glGetInteger(final int lllllllllllllIlIlIlIIIlIllllIllI, final IntBuffer lllllllllllllIlIlIlIIIlIllllIlIl) {
        GL11.glGetInteger(lllllllllllllIlIlIlIIIlIllllIllI, lllllllllllllIlIlIlIIIlIllllIlIl);
    }
    
    public static void disableColorLogic() {
        GlStateManager.colorLogicState.colorLogicOp.setDisabled();
    }
    
    public static void alphaFunc(final int lllllllllllllIlIlIlIIlIlllIlIIIl, final float lllllllllllllIlIlIlIIlIlllIlIIlI) {
        if (lllllllllllllIlIlIlIIlIlllIlIIIl != GlStateManager.alphaState.func || lllllllllllllIlIlIlIIlIlllIlIIlI != GlStateManager.alphaState.ref) {
            GlStateManager.alphaState.func = lllllllllllllIlIlIlIIlIlllIlIIIl;
            GlStateManager.alphaState.ref = lllllllllllllIlIlIlIIlIlllIlIIlI;
            GL11.glAlphaFunc(lllllllllllllIlIlIlIIlIlllIlIIIl, lllllllllllllIlIlIlIIlIlllIlIIlI);
        }
    }
    
    public static int getActiveTextureUnit() {
        return OpenGlHelper.defaultTexUnit + GlStateManager.activeTextureUnit;
    }
    
    public static void bindTexture(final int lllllllllllllIlIlIlIIlIIlllIIlll) {
        if (lllllllllllllIlIlIlIIlIIlllIIlll != GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName) {
            GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName = lllllllllllllIlIlIlIIlIIlllIIlll;
            GL11.glBindTexture(3553, lllllllllllllIlIlIlIIlIIlllIIlll);
        }
    }
    
    public static void glTexEnvf(final int lllllllllllllIlIlIlIIlIlIIIlIIlI, final int lllllllllllllIlIlIlIIlIlIIIlIIIl, final float lllllllllllllIlIlIlIIlIlIIIlIIII) {
        GL11.glTexEnvf(lllllllllllllIlIlIlIIlIlIIIlIIlI, lllllllllllllIlIlIlIIlIlIIIlIIIl, lllllllllllllIlIlIlIIlIlIIIlIIII);
    }
    
    public static void setBlendState(final GlBlendState lllllllllllllIlIlIlIIIlIllIIllll) {
        GlStateManager.blendState.blend.setState(lllllllllllllIlIlIlIIIlIllIIllll.enabled);
        blendFunc(lllllllllllllIlIlIlIIIlIllIIllll.srcFactor, lllllllllllllIlIlIlIIIlIllIIllll.dstFactor);
    }
    
    public static void tryBlendFuncSeparate(final SourceFactor lllllllllllllIlIlIlIIlIllIIlIlIl, final DestFactor lllllllllllllIlIlIlIIlIllIIlIIII, final SourceFactor lllllllllllllIlIlIlIIlIllIIlIIll, final DestFactor lllllllllllllIlIlIlIIlIllIIIlllI) {
        tryBlendFuncSeparate(lllllllllllllIlIlIlIIlIllIIlIlIl.factor, lllllllllllllIlIlIlIIlIllIIlIIII.factor, lllllllllllllIlIlIlIIlIllIIlIIll.factor, lllllllllllllIlIlIlIIlIllIIIlllI.factor);
    }
    
    public static int glGetTexLevelParameteri(final int lllllllllllllIlIlIlIIlIIllllIlll, final int lllllllllllllIlIlIlIIlIIlllllIIl, final int lllllllllllllIlIlIlIIlIIlllllIII) {
        return GL11.glGetTexLevelParameteri(lllllllllllllIlIlIlIIlIIllllIlll, lllllllllllllIlIlIlIIlIIlllllIIl, lllllllllllllIlIlIlIIlIIlllllIII);
    }
    
    public static void depthMask(final boolean lllllllllllllIlIlIlIIlIllIlIIllI) {
        if (lllllllllllllIlIlIlIIlIllIlIIllI != GlStateManager.depthState.maskEnabled) {
            GlStateManager.depthState.maskEnabled = lllllllllllllIlIlIlIIlIllIlIIllI;
            GL11.glDepthMask(lllllllllllllIlIlIlIIlIllIlIIllI);
        }
    }
    
    public static void loadIdentity() {
        GL11.glLoadIdentity();
    }
    
    private static void cullFace(final int lllllllllllllIlIlIlIIlIlIlIlllII) {
        if (lllllllllllllIlIlIlIIlIlIlIlllII != GlStateManager.cullState.mode) {
            GlStateManager.cullState.mode = lllllllllllllIlIlIlIIlIlIlIlllII;
            GL11.glCullFace(lllllllllllllIlIlIlIIlIlIlIlllII);
        }
    }
    
    public static void glDeleteLists(final int lllllllllllllIlIlIlIIIllIIlIIIIl, final int lllllllllllllIlIlIlIIIllIIlIIIlI) {
        GL11.glDeleteLists(lllllllllllllIlIlIlIIIllIIlIIIIl, lllllllllllllIlIlIlIIIllIIlIIIlI);
    }
    
    public static void clear(final int lllllllllllllIlIlIlIIlIIIIllIIlI) {
        if (GlStateManager.clearEnabled) {
            GL11.glClear(lllllllllllllIlIlIlIIlIIIIllIIlI);
        }
    }
    
    public static void glNewList(final int lllllllllllllIlIlIlIIIllIIIllIll, final int lllllllllllllIlIlIlIIIllIIIllIlI) {
        GL11.glNewList(lllllllllllllIlIlIlIIIllIIIllIll, lllllllllllllIlIlIlIIIllIIIllIlI);
    }
    
    public static void glTexSubImage2D(final int lllllllllllllIlIlIlIIlIIlIlllIII, final int lllllllllllllIlIlIlIIlIIlIllIlll, final int lllllllllllllIlIlIlIIlIIlIllIllI, final int lllllllllllllIlIlIlIIlIIlIlllllI, final int lllllllllllllIlIlIlIIlIIlIllllIl, final int lllllllllllllIlIlIlIIlIIlIllllII, final int lllllllllllllIlIlIlIIlIIlIllIIlI, final int lllllllllllllIlIlIlIIlIIlIlllIlI, final IntBuffer lllllllllllllIlIlIlIIlIIlIllIIII) {
        GL11.glTexSubImage2D(lllllllllllllIlIlIlIIlIIlIlllIII, lllllllllllllIlIlIlIIlIIlIllIlll, lllllllllllllIlIlIlIIlIIlIllIllI, lllllllllllllIlIlIlIIlIIlIlllllI, lllllllllllllIlIlIlIIlIIlIllllIl, lllllllllllllIlIlIlIIlIIlIllllII, lllllllllllllIlIlIlIIlIIlIllIIlI, lllllllllllllIlIlIlIIlIIlIlllIlI, lllllllllllllIlIlIlIIlIIlIllIIII);
    }
    
    public static void checkBoundTexture() {
        if (Config.isMinecraftThread()) {
            final int lllllllllllllIlIlIlIIIlIlllIIlIl = GL11.glGetInteger(34016);
            final int lllllllllllllIlIlIlIIIlIlllIIlII = GL11.glGetInteger(32873);
            final int lllllllllllllIlIlIlIIIlIlllIIIll = getActiveTextureUnit();
            final int lllllllllllllIlIlIlIIIlIlllIIIlI = getBoundTexture();
            if (lllllllllllllIlIlIlIIIlIlllIIIlI > 0 && (lllllllllllllIlIlIlIIIlIlllIIlIl != lllllllllllllIlIlIlIIIlIlllIIIll || lllllllllllllIlIlIlIIIlIlllIIlII != lllllllllllllIlIlIlIIIlIlllIIIlI)) {
                Config.dbg(String.valueOf(new StringBuilder("checkTexture: act: ").append(lllllllllllllIlIlIlIIIlIlllIIIll).append(", glAct: ").append(lllllllllllllIlIlIlIIIlIlllIIlIl).append(", tex: ").append(lllllllllllllIlIlIlIIIlIlllIIIlI).append(", glTex: ").append(lllllllllllllIlIlIlIIIlIlllIIlII)));
            }
        }
    }
    
    public static void glVertexPointer(final int lllllllllllllIlIlIlIIIllIlIllIIl, final int lllllllllllllIlIlIlIIIllIlIllIII, final int lllllllllllllIlIlIlIIIllIlIllIll, final ByteBuffer lllllllllllllIlIlIlIIIllIlIlIllI) {
        GL11.glVertexPointer(lllllllllllllIlIlIlIIIllIlIllIIl, lllllllllllllIlIlIlIIIllIlIllIII, lllllllllllllIlIlIlIIIllIlIllIll, lllllllllllllIlIlIlIIIllIlIlIllI);
    }
    
    public static void blendFunc(final SourceFactor lllllllllllllIlIlIlIIlIllIlIIIIl, final DestFactor lllllllllllllIlIlIlIIlIllIlIIIII) {
        blendFunc(lllllllllllllIlIlIlIIlIllIlIIIIl.factor, lllllllllllllIlIlIlIIlIllIlIIIII.factor);
    }
    
    public static void colorLogicOp(final LogicOp lllllllllllllIlIlIlIIlIlIlIIllIl) {
        colorLogicOp(lllllllllllllIlIlIlIIlIlIlIIllIl.opcode);
    }
    
    public static void disableColorMaterial() {
        GlStateManager.colorMaterialState.colorMaterial.setDisabled();
    }
    
    private static void setFog(final int lllllllllllllIlIlIlIIlIlIlllIlll) {
        if (lllllllllllllIlIlIlIIlIlIlllIlll != GlStateManager.fogState.mode) {
            GlStateManager.fogState.mode = lllllllllllllIlIlIlIIlIlIlllIlll;
            GL11.glFogi(2917, lllllllllllllIlIlIlIIlIlIlllIlll);
        }
    }
    
    public static void translate(final double lllllllllllllIlIlIlIIIllllIlllII, final double lllllllllllllIlIlIlIIIllllIllllI, final double lllllllllllllIlIlIlIIIllllIllIlI) {
        GL11.glTranslated(lllllllllllllIlIlIlIIIllllIlllII, lllllllllllllIlIlIlIIIllllIllllI, lllllllllllllIlIlIlIIIllllIllIlI);
    }
    
    public static void pushAttrib() {
        GL11.glPushAttrib(8256);
    }
    
    public static void setFogEnd(final float lllllllllllllIlIlIlIIlIlIllIlllI) {
        if (lllllllllllllIlIlIlIIlIlIllIlllI != GlStateManager.fogState.end) {
            GlStateManager.fogState.end = lllllllllllllIlIlIlIIlIlIllIlllI;
            GL11.glFogf(2916, lllllllllllllIlIlIlIIlIlIllIlllI);
        }
    }
    
    public static int glGenLists(final int lllllllllllllIlIlIlIIIllIIIllIII) {
        return GL11.glGenLists(lllllllllllllIlIlIlIIIllIIIllIII);
    }
    
    public static void colorLogicOp(final int lllllllllllllIlIlIlIIlIlIlIIlIIl) {
        if (lllllllllllllIlIlIlIIlIlIlIIlIIl != GlStateManager.colorLogicState.opcode) {
            GlStateManager.colorLogicState.opcode = lllllllllllllIlIlIlIIlIlIlIIlIIl;
            GL11.glLogicOp(lllllllllllllIlIlIlIIlIlIlIIlIIl);
        }
    }
    
    public static void rotate(final float lllllllllllllIlIlIlIIlIIIIIIIlIl, final float lllllllllllllIlIlIlIIlIIIIIIIlII, final float lllllllllllllIlIlIlIIlIIIIIIIIll, final float lllllllllllllIlIlIlIIlIIIIIIIIlI) {
        GL11.glRotatef(lllllllllllllIlIlIlIIlIIIIIIIlIl, lllllllllllllIlIlIlIIlIIIIIIIlII, lllllllllllllIlIlIlIIlIIIIIIIIll, lllllllllllllIlIlIlIIlIIIIIIIIlI);
    }
    
    public static void glTexImage2D(final int lllllllllllllIlIlIlIIlIIllIlIIll, final int lllllllllllllIlIlIlIIlIIllIlIIlI, final int lllllllllllllIlIlIlIIlIIllIllIlI, final int lllllllllllllIlIlIlIIlIIllIlIIII, final int lllllllllllllIlIlIlIIlIIllIIllll, final int lllllllllllllIlIlIlIIlIIllIlIlll, final int lllllllllllllIlIlIlIIlIIllIIllIl, final int lllllllllllllIlIlIlIIlIIllIlIlIl, @Nullable final IntBuffer lllllllllllllIlIlIlIIlIIllIlIlII) {
        GL11.glTexImage2D(lllllllllllllIlIlIlIIlIIllIlIIll, lllllllllllllIlIlIlIIlIIllIlIIlI, lllllllllllllIlIlIlIIlIIllIllIlI, lllllllllllllIlIlIlIIlIIllIlIIII, lllllllllllllIlIlIlIIlIIllIIllll, lllllllllllllIlIlIlIIlIIllIlIlll, lllllllllllllIlIlIlIIlIIllIIllIl, lllllllllllllIlIlIlIIlIIllIlIlIl, lllllllllllllIlIlIlIIlIIllIlIlII);
    }
    
    public static int generateTexture() {
        return GL11.glGenTextures();
    }
    
    public static void getBlendState(final GlBlendState lllllllllllllIlIlIlIIIlIllIlIIll) {
        lllllllllllllIlIlIlIIIlIllIlIIll.enabled = GlStateManager.blendState.blend.currentState;
        lllllllllllllIlIlIlIIIlIllIlIIll.srcFactor = GlStateManager.blendState.srcFactor;
        lllllllllllllIlIlIlIIIlIllIlIIll.dstFactor = GlStateManager.blendState.dstFactor;
    }
    
    public static void enablePolygonOffset() {
        GlStateManager.polygonOffsetState.polygonOffsetFill.setEnabled();
    }
    
    public static void disableBlendProfile(final Profile lllllllllllllIlIlIlIIIlIlllIlIll) {
        lllllllllllllIlIlIlIIIlIlllIlIll.clean();
    }
    
    public static void glTexCoord2f(final float lllllllllllllIlIlIlIIIlllIIllIIl, final float lllllllllllllIlIlIlIIIlllIIllIlI) {
        GL11.glTexCoord2f(lllllllllllllIlIlIlIIIlllIIllIIl, lllllllllllllIlIlIlIIIlllIIllIlI);
    }
    
    static class TexGenState
    {
        public /* synthetic */ TexGenCoord q;
        public /* synthetic */ TexGenCoord s;
        public /* synthetic */ TexGenCoord t;
        public /* synthetic */ TexGenCoord r;
        
        private TexGenState() {
            this.s = new TexGenCoord(8192, 3168);
            this.t = new TexGenCoord(8193, 3169);
            this.r = new TexGenCoord(8194, 3170);
            this.q = new TexGenCoord(8195, 3171);
        }
    }
    
    static class TexGenCoord
    {
        public /* synthetic */ int param;
        public /* synthetic */ BooleanState textureGen;
        public /* synthetic */ int coord;
        
        public TexGenCoord(final int lllllllllllllIIllIIlIIllIlIIIIIl, final int lllllllllllllIIllIIlIIllIlIIIIll) {
            this.param = -1;
            this.coord = lllllllllllllIIllIIlIIllIlIIIIIl;
            this.textureGen = new BooleanState(lllllllllllllIIllIIlIIllIlIIIIll);
        }
    }
    
    static class BooleanState
    {
        private /* synthetic */ boolean currentState;
        private final /* synthetic */ int capability;
        
        public void setState(final boolean llllllllllllllIIIlIIIIlIlIllllII) {
            if (llllllllllllllIIIlIIIIlIlIllllII != this.currentState) {
                this.currentState = llllllllllllllIIIlIIIIlIlIllllII;
                if (llllllllllllllIIIlIIIIlIlIllllII) {
                    GL11.glEnable(this.capability);
                }
                else {
                    GL11.glDisable(this.capability);
                }
            }
        }
        
        public void setDisabled() {
            this.setState(false);
        }
        
        public void setEnabled() {
            this.setState(true);
        }
        
        public BooleanState(final int llllllllllllllIIIlIIIIlIllIIIllI) {
            this.capability = llllllllllllllIIIlIIIIlIllIIIllI;
        }
    }
    
    public enum FogMode
    {
        LINEAR("LINEAR", 0, 9729), 
        EXP2("EXP2", 2, 2049);
        
        public final /* synthetic */ int capabilityId;
        
        EXP("EXP", 1, 2048);
        
        private FogMode(final String llllllllllllllIIIIIIlIIIIlIlIIll, final int llllllllllllllIIIIIIlIIIIlIlIIlI, final int llllllllllllllIIIIIIlIIIIlIlIIIl) {
            this.capabilityId = llllllllllllllIIIIIIlIIIIlIlIIIl;
        }
    }
    
    static class PolygonOffsetState
    {
        public /* synthetic */ BooleanState polygonOffsetLine;
        public /* synthetic */ float factor;
        public /* synthetic */ BooleanState polygonOffsetFill;
        public /* synthetic */ float units;
        
        private PolygonOffsetState() {
            this.polygonOffsetFill = new BooleanState(32823);
            this.polygonOffsetLine = new BooleanState(10754);
        }
    }
    
    static class Color
    {
        public /* synthetic */ float blue;
        public /* synthetic */ float green;
        public /* synthetic */ float alpha;
        public /* synthetic */ float red;
        
        public Color(final float llllllllllllllIllllIIIllIIIlIlII, final float llllllllllllllIllllIIIllIIIllIII, final float llllllllllllllIllllIIIllIIIlIlll, final float llllllllllllllIllllIIIllIIIlIllI) {
            this.red = 1.0f;
            this.green = 1.0f;
            this.blue = 1.0f;
            this.alpha = 1.0f;
            this.red = llllllllllllllIllllIIIllIIIlIlII;
            this.green = llllllllllllllIllllIIIllIIIllIII;
            this.blue = llllllllllllllIllllIIIllIIIlIlll;
            this.alpha = llllllllllllllIllllIIIllIIIlIllI;
        }
        
        public Color() {
            this(1.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    static class ColorMask
    {
        public /* synthetic */ boolean red;
        public /* synthetic */ boolean blue;
        public /* synthetic */ boolean alpha;
        public /* synthetic */ boolean green;
        
        private ColorMask() {
            this.red = true;
            this.green = true;
            this.blue = true;
            this.alpha = true;
        }
    }
    
    static class ColorLogicState
    {
        public /* synthetic */ int opcode;
        public /* synthetic */ BooleanState colorLogicOp;
        
        private ColorLogicState() {
            this.colorLogicOp = new BooleanState(3058);
            this.opcode = 5379;
        }
    }
    
    static class ClearState
    {
        public /* synthetic */ Color color;
        public /* synthetic */ double depth;
        
        private ClearState() {
            this.depth = 1.0;
            this.color = new Color(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }
    
    static class StencilFunc
    {
        public /* synthetic */ int func;
        public /* synthetic */ int mask;
        
        private StencilFunc() {
            this.func = 519;
            this.mask = -1;
        }
    }
    
    static class BlendState
    {
        public /* synthetic */ int srcFactorAlpha;
        public /* synthetic */ int srcFactor;
        public /* synthetic */ int dstFactor;
        public /* synthetic */ BooleanState blend;
        public /* synthetic */ int dstFactorAlpha;
        
        private BlendState() {
            this.blend = new BooleanState(3042);
            this.srcFactor = 1;
            this.dstFactor = 0;
            this.srcFactorAlpha = 1;
            this.dstFactorAlpha = 0;
        }
    }
    
    public enum LogicOp
    {
        COPY_INVERTED("COPY_INVERTED", 5, 5388), 
        AND_REVERSE("AND_REVERSE", 2, 5378), 
        NOR("NOR", 10, 5384), 
        EQUIV("EQUIV", 6, 5385), 
        AND_INVERTED("AND_INVERTED", 1, 5380), 
        INVERT("INVERT", 7, 5386), 
        SET("SET", 14, 5391), 
        OR("OR", 11, 5383), 
        CLEAR("CLEAR", 3, 5376), 
        COPY("COPY", 4, 5379), 
        NOOP("NOOP", 9, 5381), 
        OR_INVERTED("OR_INVERTED", 12, 5389), 
        XOR("XOR", 15, 5382), 
        NAND("NAND", 8, 5390);
        
        public final /* synthetic */ int opcode;
        
        OR_REVERSE("OR_REVERSE", 13, 5387), 
        AND("AND", 0, 5377);
        
        private LogicOp(final String lllllllllllllIlIIlIlIlllIllIllIl, final int lllllllllllllIlIIlIlIlllIllIllII, final int lllllllllllllIlIIlIlIlllIllIllll) {
            this.opcode = lllllllllllllIlIIlIlIlllIllIllll;
        }
    }
    
    public enum Profile
    {
        PLAYER_SKIN(1) {
            @Override
            public void apply() {
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            }
            
            @Override
            public void clean() {
                GlStateManager.disableBlend();
            }
        }, 
        TRANSPARENT_MODEL(2) {
            @Override
            public void apply() {
                GlStateManager.color(1.0f, 1.0f, 1.0f, 0.15f);
                GlStateManager.depthMask(false);
                GlStateManager.enableBlend();
                GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
                GlStateManager.alphaFunc(516, 0.003921569f);
            }
            
            @Override
            public void clean() {
                GlStateManager.disableBlend();
                GlStateManager.alphaFunc(516, 0.1f);
                GlStateManager.depthMask(true);
            }
        }, 
        DEFAULT(0) {
            @Override
            public void apply() {
                GlStateManager.disableAlpha();
                GlStateManager.alphaFunc(519, 0.0f);
                GlStateManager.disableLighting();
                GL11.glLightModel(2899, RenderHelper.setColorBuffer(0.2f, 0.2f, 0.2f, 1.0f));
                for (int llllllllllllllllIIIIIllIIIlIllll = 0; llllllllllllllllIIIIIllIIIlIllll < 8; ++llllllllllllllllIIIIIllIIIlIllll) {
                    GlStateManager.disableLight(llllllllllllllllIIIIIllIIIlIllll);
                    GL11.glLight(16384 + llllllllllllllllIIIIIllIIIlIllll, 4608, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                    GL11.glLight(16384 + llllllllllllllllIIIIIllIIIlIllll, 4611, RenderHelper.setColorBuffer(0.0f, 0.0f, 1.0f, 0.0f));
                    if (llllllllllllllllIIIIIllIIIlIllll == 0) {
                        GL11.glLight(16384 + llllllllllllllllIIIIIllIIIlIllll, 4609, RenderHelper.setColorBuffer(1.0f, 1.0f, 1.0f, 1.0f));
                        GL11.glLight(16384 + llllllllllllllllIIIIIllIIIlIllll, 4610, RenderHelper.setColorBuffer(1.0f, 1.0f, 1.0f, 1.0f));
                    }
                    else {
                        GL11.glLight(16384 + llllllllllllllllIIIIIllIIIlIllll, 4609, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                        GL11.glLight(16384 + llllllllllllllllIIIIIllIIIlIllll, 4610, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
                    }
                }
                GlStateManager.disableColorMaterial();
                GlStateManager.colorMaterial(1032, 5634);
                GlStateManager.disableDepth();
                GlStateManager.depthFunc(513);
                GlStateManager.depthMask(true);
                GlStateManager.disableBlend();
                GlStateManager.blendFunc(SourceFactor.ONE, DestFactor.ZERO);
                GlStateManager.tryBlendFuncSeparate(SourceFactor.ONE, DestFactor.ZERO, SourceFactor.ONE, DestFactor.ZERO);
                GL14.glBlendEquation(32774);
                GlStateManager.disableFog();
                GL11.glFogi(2917, 2048);
                GlStateManager.setFogDensity(1.0f);
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(1.0f);
                GL11.glFog(2918, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                if (GLContext.getCapabilities().GL_NV_fog_distance) {
                    GL11.glFogi(2917, 34140);
                }
                GlStateManager.doPolygonOffset(0.0f, 0.0f);
                GlStateManager.disableColorLogic();
                GlStateManager.colorLogicOp(5379);
                GlStateManager.disableTexGenCoord(TexGen.S);
                GlStateManager.texGen(TexGen.S, 9216);
                GlStateManager.texGen(TexGen.S, 9474, RenderHelper.setColorBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.texGen(TexGen.S, 9217, RenderHelper.setColorBuffer(1.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.disableTexGenCoord(TexGen.T);
                GlStateManager.texGen(TexGen.T, 9216);
                GlStateManager.texGen(TexGen.T, 9474, RenderHelper.setColorBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GlStateManager.texGen(TexGen.T, 9217, RenderHelper.setColorBuffer(0.0f, 1.0f, 0.0f, 0.0f));
                GlStateManager.disableTexGenCoord(TexGen.R);
                GlStateManager.texGen(TexGen.R, 9216);
                GlStateManager.texGen(TexGen.R, 9474, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.texGen(TexGen.R, 9217, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.disableTexGenCoord(TexGen.Q);
                GlStateManager.texGen(TexGen.Q, 9216);
                GlStateManager.texGen(TexGen.Q, 9474, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.texGen(TexGen.Q, 9217, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GlStateManager.setActiveTexture(0);
                GL11.glTexParameteri(3553, 10240, 9729);
                GL11.glTexParameteri(3553, 10241, 9986);
                GL11.glTexParameteri(3553, 10242, 10497);
                GL11.glTexParameteri(3553, 10243, 10497);
                GL11.glTexParameteri(3553, 33085, 1000);
                GL11.glTexParameteri(3553, 33083, 1000);
                GL11.glTexParameteri(3553, 33082, -1000);
                GL11.glTexParameterf(3553, 34049, 0.0f);
                GL11.glTexEnvi(8960, 8704, 8448);
                GL11.glTexEnv(8960, 8705, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 0.0f));
                GL11.glTexEnvi(8960, 34161, 8448);
                GL11.glTexEnvi(8960, 34162, 8448);
                GL11.glTexEnvi(8960, 34176, 5890);
                GL11.glTexEnvi(8960, 34177, 34168);
                GL11.glTexEnvi(8960, 34178, 34166);
                GL11.glTexEnvi(8960, 34184, 5890);
                GL11.glTexEnvi(8960, 34185, 34168);
                GL11.glTexEnvi(8960, 34186, 34166);
                GL11.glTexEnvi(8960, 34192, 768);
                GL11.glTexEnvi(8960, 34193, 768);
                GL11.glTexEnvi(8960, 34194, 770);
                GL11.glTexEnvi(8960, 34200, 770);
                GL11.glTexEnvi(8960, 34201, 770);
                GL11.glTexEnvi(8960, 34202, 770);
                GL11.glTexEnvf(8960, 34163, 1.0f);
                GL11.glTexEnvf(8960, 3356, 1.0f);
                GlStateManager.disableNormalize();
                GlStateManager.shadeModel(7425);
                GlStateManager.disableRescaleNormal();
                GlStateManager.colorMask(true, true, true, true);
                GlStateManager.clearDepth(1.0);
                GL11.glLineWidth(1.0f);
                GL11.glNormal3f(0.0f, 0.0f, 1.0f);
                GL11.glPolygonMode(1028, 6914);
                GL11.glPolygonMode(1029, 6914);
            }
            
            @Override
            public void clean() {
            }
        };
        
        private Profile(final String lllllllllllllllIIIllllllIIIIlIIl, final int lllllllllllllllIIIllllllIIIIlIII) {
        }
        
        public abstract void apply();
        
        public abstract void clean();
    }
    
    public enum DestFactor
    {
        SRC_ALPHA("SRC_ALPHA", 11, 770), 
        SRC_COLOR("SRC_COLOR", 12, 768);
        
        public final /* synthetic */ int factor;
        
        CONSTANT_ALPHA("CONSTANT_ALPHA", 0, 32771), 
        CONSTANT_COLOR("CONSTANT_COLOR", 1, 32769), 
        ONE_MINUS_DST_ALPHA("ONE_MINUS_DST_ALPHA", 7, 773), 
        DST_ALPHA("DST_ALPHA", 2, 772), 
        ONE_MINUS_SRC_COLOR("ONE_MINUS_SRC_COLOR", 10, 769), 
        ONE("ONE", 4, 1), 
        ONE_MINUS_SRC_ALPHA("ONE_MINUS_SRC_ALPHA", 9, 771), 
        ONE_MINUS_DST_COLOR("ONE_MINUS_DST_COLOR", 8, 775), 
        ONE_MINUS_CONSTANT_COLOR("ONE_MINUS_CONSTANT_COLOR", 6, 32770), 
        ONE_MINUS_CONSTANT_ALPHA("ONE_MINUS_CONSTANT_ALPHA", 5, 32772), 
        DST_COLOR("DST_COLOR", 3, 774), 
        ZERO("ZERO", 13, 0);
        
        private DestFactor(final String lIlIIlIIllIIIII, final int lIlIIlIIlIlllll, final int lIlIIlIIllIIIlI) {
            this.factor = lIlIIlIIllIIIlI;
        }
    }
    
    public enum SourceFactor
    {
        CONSTANT_COLOR("CONSTANT_COLOR", 1, 32769), 
        SRC_ALPHA_SATURATE("SRC_ALPHA_SATURATE", 12, 776), 
        DST_ALPHA("DST_ALPHA", 2, 772), 
        ONE_MINUS_CONSTANT_COLOR("ONE_MINUS_CONSTANT_COLOR", 6, 32770), 
        SRC_COLOR("SRC_COLOR", 13, 768), 
        ONE_MINUS_CONSTANT_ALPHA("ONE_MINUS_CONSTANT_ALPHA", 5, 32772), 
        DST_COLOR("DST_COLOR", 3, 774), 
        ZERO("ZERO", 14, 0), 
        SRC_ALPHA("SRC_ALPHA", 11, 770), 
        ONE_MINUS_SRC_ALPHA("ONE_MINUS_SRC_ALPHA", 9, 771), 
        CONSTANT_ALPHA("CONSTANT_ALPHA", 0, 32771);
        
        public final /* synthetic */ int factor;
        
        ONE_MINUS_SRC_COLOR("ONE_MINUS_SRC_COLOR", 10, 769), 
        ONE_MINUS_DST_ALPHA("ONE_MINUS_DST_ALPHA", 7, 773), 
        ONE("ONE", 4, 1), 
        ONE_MINUS_DST_COLOR("ONE_MINUS_DST_COLOR", 8, 775);
        
        private SourceFactor(final String lllllllllllllllIlIllllIlIlIIllll, final int lllllllllllllllIlIllllIlIlIIlllI, final int lllllllllllllllIlIllllIlIlIIllIl) {
            this.factor = lllllllllllllllIlIllllIlIlIIllIl;
        }
    }
    
    public enum TexGen
    {
        S("S", 0), 
        R("R", 2), 
        T("T", 1), 
        Q("Q", 3);
        
        private TexGen(final String lllllllllllllllllllllIIIllllllII, final int lllllllllllllllllllllIIIlllllIll) {
        }
    }
    
    static class CullState
    {
        public /* synthetic */ BooleanState cullFace;
        public /* synthetic */ int mode;
        
        private CullState() {
            this.cullFace = new BooleanState(2884);
            this.mode = 1029;
        }
    }
    
    static class AlphaState
    {
        public /* synthetic */ BooleanState alphaTest;
        public /* synthetic */ float ref;
        public /* synthetic */ int func;
        
        private AlphaState() {
            this.alphaTest = new BooleanState(3008);
            this.func = 519;
            this.ref = -1.0f;
        }
    }
    
    static class FogState
    {
        public /* synthetic */ int mode;
        public /* synthetic */ float start;
        public /* synthetic */ float density;
        public /* synthetic */ float end;
        public /* synthetic */ BooleanState fog;
        
        private FogState() {
            this.fog = new BooleanState(2912);
            this.mode = 2048;
            this.density = 1.0f;
            this.end = 1.0f;
        }
    }
    
    public enum CullFace
    {
        FRONT("FRONT", 0, 1028);
        
        public final /* synthetic */ int mode;
        
        FRONT_AND_BACK("FRONT_AND_BACK", 2, 1032), 
        BACK("BACK", 1, 1029);
        
        private CullFace(final String lllllllllllllIlIIIIIIIIllllllIIl, final int lllllllllllllIlIIIIIIIIllllllIII, final int lllllllllllllIlIIIIIIIIllllllIll) {
            this.mode = lllllllllllllIlIIIIIIIIllllllIll;
        }
    }
    
    static class TextureState
    {
        public /* synthetic */ int textureName;
        public /* synthetic */ BooleanState texture2DState;
        
        private TextureState() {
            this.texture2DState = new BooleanState(3553);
        }
    }
    
    static class DepthState
    {
        public /* synthetic */ int depthFunc;
        public /* synthetic */ BooleanState depthTest;
        public /* synthetic */ boolean maskEnabled;
        
        private DepthState() {
            this.depthTest = new BooleanState(2929);
            this.maskEnabled = true;
            this.depthFunc = 513;
        }
    }
    
    static class ColorMaterialState
    {
        public /* synthetic */ int mode;
        public /* synthetic */ int face;
        public /* synthetic */ BooleanState colorMaterial;
        
        private ColorMaterialState() {
            this.colorMaterial = new BooleanState(2903);
            this.face = 1032;
            this.mode = 5634;
        }
    }
    
    static class StencilState
    {
        public /* synthetic */ StencilFunc func;
        public /* synthetic */ int mask;
        public /* synthetic */ int zpass;
        public /* synthetic */ int fail;
        public /* synthetic */ int zfail;
        
        private StencilState() {
            this.func = new StencilFunc(null);
            this.mask = -1;
            this.fail = 7680;
            this.zfail = 7680;
            this.zpass = 7680;
        }
    }
}
