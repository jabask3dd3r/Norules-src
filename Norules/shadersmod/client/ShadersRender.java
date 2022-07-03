package shadersmod.client;

import net.minecraft.entity.*;
import net.minecraft.client.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.texture.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.culling.*;
import java.nio.*;
import net.minecraft.tileentity.*;
import optifine.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;

public class ShadersRender
{
    private static final /* synthetic */ ResourceLocation END_PORTAL_TEXTURE;
    
    public static void beaconBeamBegin() {
        Shaders.useProgram(14);
    }
    
    public static void beaconBeamStartQuad2() {
    }
    
    public static void renderEnchantedGlintEnd() {
        if (Shaders.isRenderingWorld) {
            if (Shaders.isRenderingFirstPersonHand() && Shaders.isRenderBothHands()) {
                Shaders.useProgram(19);
            }
            else {
                Shaders.useProgram(16);
            }
        }
        else {
            Shaders.useProgram(0);
        }
    }
    
    public static void endTerrain() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(3);
        }
    }
    
    public static void setupTerrain(final RenderGlobal lllllllllllllllIIIIlIlIlllIIlIlI, final Entity lllllllllllllllIIIIlIlIlllIIlIIl, final double lllllllllllllllIIIIlIlIlllIIlIII, final ICamera lllllllllllllllIIIIlIlIlllIIIlll, final int lllllllllllllllIIIIlIlIlllIIllII, final boolean lllllllllllllllIIIIlIlIlllIIIlIl) {
        lllllllllllllllIIIIlIlIlllIIlIlI.setupTerrain(lllllllllllllllIIIIlIlIlllIIlIIl, lllllllllllllllIIIIlIlIlllIIlIII, lllllllllllllllIIIIlIlIlllIIIlll, lllllllllllllllIIIIlIlIlllIIllII, lllllllllllllllIIIIlIlIlllIIIlIl);
    }
    
    public static void renderHand1(final EntityRenderer lllllllllllllllIIIIlIlIllIlIllll, final float lllllllllllllllIIIIlIlIllIllIIIl, final int lllllllllllllllIIIIlIlIllIllIIII) {
        if (!Shaders.isShadowPass && !Shaders.isBothHandsRendered()) {
            Shaders.readCenterDepth();
            GlStateManager.enableBlend();
            Shaders.beginHand();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            Shaders.setSkipRenderHands(Shaders.isHandRenderedMain(), Shaders.isHandRenderedOff());
            lllllllllllllllIIIIlIlIllIlIllll.renderHand(lllllllllllllllIIIIlIlIllIllIIIl, lllllllllllllllIIIIlIlIllIllIIII, true, false, true);
            Shaders.endHand();
            Shaders.setHandsRendered(true, true);
            Shaders.setSkipRenderHands(false, false);
        }
    }
    
    public static void postRenderChunkLayer(final BlockRenderLayer lllllllllllllllIIIIlIlIlIllIllll) {
        if (OpenGlHelper.useVbo()) {
            GL11.glDisableClientState(32885);
            GL20.glDisableVertexAttribArray(Shaders.midTexCoordAttrib);
            GL20.glDisableVertexAttribArray(Shaders.tangentAttrib);
            GL20.glDisableVertexAttribArray(Shaders.entityAttrib);
        }
        if (Shaders.isRenderBackFace(lllllllllllllllIIIIlIlIlIllIllll)) {
            GlStateManager.enableCull();
        }
    }
    
    public static void endTranslucent() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(3);
        }
    }
    
    public static void beginTranslucent() {
        if (Shaders.isRenderingWorld) {
            if (Shaders.usedDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33995);
                Shaders.checkGLError("pre copy depth");
                GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, Shaders.renderWidth, Shaders.renderHeight);
                Shaders.checkGLError("copy depth");
                GlStateManager.setActiveTexture(33984);
            }
            Shaders.useProgram(12);
        }
    }
    
    public static void setFrustrumPosition(final ICamera lllllllllllllllIIIIlIlIlllIllllI, final double lllllllllllllllIIIIlIlIlllIllIIl, final double lllllllllllllllIIIIlIlIlllIllIII, final double lllllllllllllllIIIIlIlIlllIlIlll) {
        lllllllllllllllIIIIlIlIlllIllllI.setPosition(lllllllllllllllIIIIlIlIlllIllIIl, lllllllllllllllIIIIlIlIlllIllIII, lllllllllllllllIIIIlIlIlllIlIlll);
    }
    
    static {
        END_PORTAL_TEXTURE = new ResourceLocation("textures/entity/end_portal.png");
    }
    
    public static void renderHand0(final EntityRenderer lllllllllllllllIIIIlIlIllIlllIlI, final float lllllllllllllllIIIIlIlIllIlllllI, final int lllllllllllllllIIIIlIlIllIllllIl) {
        if (!Shaders.isShadowPass) {
            final boolean lllllllllllllllIIIIlIlIllIllllII = Shaders.isItemToRenderMainTranslucent();
            final boolean lllllllllllllllIIIIlIlIllIlllIll = Shaders.isItemToRenderOffTranslucent();
            if (!lllllllllllllllIIIIlIlIllIllllII || !lllllllllllllllIIIIlIlIllIlllIll) {
                Shaders.readCenterDepth();
                Shaders.beginHand();
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                Shaders.setSkipRenderHands(lllllllllllllllIIIIlIlIllIllllII, lllllllllllllllIIIIlIlIllIlllIll);
                lllllllllllllllIIIIlIlIllIlllIlI.renderHand(lllllllllllllllIIIIlIlIllIlllllI, lllllllllllllllIIIIlIlIllIllllIl, true, false, false);
                Shaders.endHand();
                Shaders.setHandsRendered(!lllllllllllllllIIIIlIlIllIllllII, !lllllllllllllllIIIIlIlIllIlllIll);
                Shaders.setSkipRenderHands(false, false);
            }
        }
    }
    
    public static void endBlockDamage() {
        if (Shaders.isRenderingWorld) {
            GlStateManager.depthMask(true);
            Shaders.useProgram(3);
        }
    }
    
    public static void beaconBeamDraw1() {
    }
    
    public static void beginTerrainSolid() {
        if (Shaders.isRenderingWorld) {
            Shaders.fogEnabled = true;
            Shaders.useProgram(7);
        }
    }
    
    public static void renderShadowMap(final EntityRenderer lllllllllllllllIIIIlIlIlIlllllll, final int lllllllllllllllIIIIlIlIllIIIlIll, final float lllllllllllllllIIIIlIlIllIIIlIlI, final long lllllllllllllllIIIIlIlIllIIIlIIl) {
        if (Shaders.usedShadowDepthBuffers > 0 && --Shaders.shadowPassCounter <= 0) {
            final Minecraft lllllllllllllllIIIIlIlIllIIIlIII = Minecraft.getMinecraft();
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow pass");
            final RenderGlobal lllllllllllllllIIIIlIlIllIIIIlll = lllllllllllllllIIIIlIlIllIIIlIII.renderGlobal;
            Shaders.isShadowPass = true;
            Shaders.shadowPassCounter = Shaders.shadowPassInterval;
            Shaders.preShadowPassThirdPersonView = lllllllllllllllIIIIlIlIllIIIlIII.gameSettings.thirdPersonView;
            lllllllllllllllIIIIlIlIllIIIlIII.gameSettings.thirdPersonView = 1;
            Shaders.checkGLError("pre shadow");
            GL11.glMatrixMode(5889);
            GL11.glPushMatrix();
            GL11.glMatrixMode(5888);
            GL11.glPushMatrix();
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow clear");
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.sfb);
            Shaders.checkGLError("shadow bind sfb");
            Shaders.useProgram(30);
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow camera");
            lllllllllllllllIIIIlIlIlIlllllll.setupCameraTransform(lllllllllllllllIIIIlIlIllIIIlIlI, 2);
            Shaders.setCameraShadow(lllllllllllllllIIIIlIlIllIIIlIlI);
            ActiveRenderInfo.updateRenderInfo(lllllllllllllllIIIIlIlIllIIIlIII.player, lllllllllllllllIIIIlIlIllIIIlIII.gameSettings.thirdPersonView == 2);
            Shaders.checkGLError("shadow camera");
            GL20.glDrawBuffers(Shaders.sfbDrawBuffers);
            Shaders.checkGLError("shadow drawbuffers");
            GL11.glReadBuffer(0);
            Shaders.checkGLError("shadow readbuffer");
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, Shaders.sfbDepthTextures.get(0), 0);
            if (Shaders.usedShadowColorBuffers != 0) {
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064, 3553, Shaders.sfbColorTextures.get(0), 0);
            }
            Shaders.checkFramebufferStatus("shadow fb");
            GL11.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glClear((Shaders.usedShadowColorBuffers != 0) ? 16640 : 256);
            Shaders.checkGLError("shadow clear");
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow frustum");
            final ClippingHelper lllllllllllllllIIIIlIlIllIIIIllI = ClippingHelperShadow.getInstance();
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow culling");
            final Frustum lllllllllllllllIIIIlIlIllIIIIlIl = new Frustum(lllllllllllllllIIIIlIlIllIIIIllI);
            final Entity lllllllllllllllIIIIlIlIllIIIIlII = lllllllllllllllIIIIlIlIllIIIlIII.getRenderViewEntity();
            final double lllllllllllllllIIIIlIlIllIIIIIll = lllllllllllllllIIIIlIlIllIIIIlII.lastTickPosX + (lllllllllllllllIIIIlIlIllIIIIlII.posX - lllllllllllllllIIIIlIlIllIIIIlII.lastTickPosX) * lllllllllllllllIIIIlIlIllIIIlIlI;
            final double lllllllllllllllIIIIlIlIllIIIIIlI = lllllllllllllllIIIIlIlIllIIIIlII.lastTickPosY + (lllllllllllllllIIIIlIlIllIIIIlII.posY - lllllllllllllllIIIIlIlIllIIIIlII.lastTickPosY) * lllllllllllllllIIIIlIlIllIIIlIlI;
            final double lllllllllllllllIIIIlIlIllIIIIIIl = lllllllllllllllIIIIlIlIllIIIIlII.lastTickPosZ + (lllllllllllllllIIIIlIlIllIIIIlII.posZ - lllllllllllllllIIIIlIlIllIIIIlII.lastTickPosZ) * lllllllllllllllIIIIlIlIllIIIlIlI;
            lllllllllllllllIIIIlIlIllIIIIlIl.setPosition(lllllllllllllllIIIIlIlIllIIIIIll, lllllllllllllllIIIIlIlIllIIIIIlI, lllllllllllllllIIIIlIlIllIIIIIIl);
            GlStateManager.shadeModel(7425);
            GlStateManager.enableDepth();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            GlStateManager.colorMask(true, true, true, true);
            GlStateManager.disableCull();
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow prepareterrain");
            lllllllllllllllIIIIlIlIllIIIlIII.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow setupterrain");
            int lllllllllllllllIIIIlIlIllIIIIIII = 0;
            lllllllllllllllIIIIlIlIllIIIIIII = lllllllllllllllIIIIlIlIlIlllllll.frameCount++;
            lllllllllllllllIIIIlIlIllIIIIlll.setupTerrain(lllllllllllllllIIIIlIlIllIIIIlII, lllllllllllllllIIIIlIlIllIIIlIlI, lllllllllllllllIIIIlIlIllIIIIlIl, lllllllllllllllIIIIlIlIllIIIIIII, lllllllllllllllIIIIlIlIllIIIlIII.player.isSpectator());
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow updatechunks");
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow terrain");
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            GlStateManager.disableAlpha();
            lllllllllllllllIIIIlIlIllIIIIlll.renderBlockLayer(BlockRenderLayer.SOLID, lllllllllllllllIIIIlIlIllIIIlIlI, 2, lllllllllllllllIIIIlIlIllIIIIlII);
            Shaders.checkGLError("shadow terrain solid");
            GlStateManager.enableAlpha();
            lllllllllllllllIIIIlIlIllIIIIlll.renderBlockLayer(BlockRenderLayer.CUTOUT_MIPPED, lllllllllllllllIIIIlIlIllIIIlIlI, 2, lllllllllllllllIIIIlIlIllIIIIlII);
            Shaders.checkGLError("shadow terrain cutoutmipped");
            lllllllllllllllIIIIlIlIllIIIlIII.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
            lllllllllllllllIIIIlIlIllIIIIlll.renderBlockLayer(BlockRenderLayer.CUTOUT, lllllllllllllllIIIIlIlIllIIIlIlI, 2, lllllllllllllllIIIIlIlIllIIIIlII);
            Shaders.checkGLError("shadow terrain cutout");
            lllllllllllllllIIIIlIlIllIIIlIII.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
            GlStateManager.shadeModel(7424);
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow entities");
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, 0);
            }
            lllllllllllllllIIIIlIlIllIIIIlll.renderEntities(lllllllllllllllIIIIlIlIllIIIIlII, lllllllllllllllIIIIlIlIllIIIIlIl, lllllllllllllllIIIIlIlIllIIIlIlI);
            Shaders.checkGLError("shadow entities");
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
            GlStateManager.disableBlend();
            GlStateManager.enableCull();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.alphaFunc(516, 0.1f);
            if (Shaders.usedShadowDepthBuffers >= 2) {
                GlStateManager.setActiveTexture(33989);
                Shaders.checkGLError("pre copy shadow depth");
                GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, Shaders.shadowMapWidth, Shaders.shadowMapHeight);
                Shaders.checkGLError("copy shadow depth");
                GlStateManager.setActiveTexture(33984);
            }
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
            lllllllllllllllIIIIlIlIllIIIlIII.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            GlStateManager.shadeModel(7425);
            Shaders.checkGLError("shadow pre-translucent");
            GL20.glDrawBuffers(Shaders.sfbDrawBuffers);
            Shaders.checkGLError("shadow drawbuffers pre-translucent");
            Shaders.checkFramebufferStatus("shadow pre-translucent");
            if (Shaders.isRenderShadowTranslucent()) {
                lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow translucent");
                lllllllllllllllIIIIlIlIllIIIIlll.renderBlockLayer(BlockRenderLayer.TRANSLUCENT, lllllllllllllllIIIIlIlIllIIIlIlI, 2, lllllllllllllllIIIIlIlIllIIIIlII);
                Shaders.checkGLError("shadow translucent");
            }
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                RenderHelper.enableStandardItemLighting();
                Reflector.call(Reflector.ForgeHooksClient_setRenderPass, 1);
                lllllllllllllllIIIIlIlIllIIIIlll.renderEntities(lllllllllllllllIIIIlIlIllIIIIlII, lllllllllllllllIIIIlIlIllIIIIlIl, lllllllllllllllIIIIlIlIllIIIlIlI);
                Reflector.call(Reflector.ForgeHooksClient_setRenderPass, -1);
                RenderHelper.disableStandardItemLighting();
                Shaders.checkGLError("shadow entities 1");
            }
            GlStateManager.shadeModel(7424);
            GlStateManager.depthMask(true);
            GlStateManager.enableCull();
            GlStateManager.disableBlend();
            GL11.glFlush();
            Shaders.checkGLError("shadow flush");
            Shaders.isShadowPass = false;
            lllllllllllllllIIIIlIlIllIIIlIII.gameSettings.thirdPersonView = Shaders.preShadowPassThirdPersonView;
            lllllllllllllllIIIIlIlIllIIIlIII.mcProfiler.endStartSection("shadow postprocess");
            if (Shaders.hasGlGenMipmap) {
                if (Shaders.usedShadowDepthBuffers >= 1) {
                    if (Shaders.shadowMipmapEnabled[0]) {
                        GlStateManager.setActiveTexture(33988);
                        GlStateManager.bindTexture(Shaders.sfbDepthTextures.get(0));
                        GL30.glGenerateMipmap(3553);
                        GL11.glTexParameteri(3553, 10241, Shaders.shadowFilterNearest[0] ? 9984 : 9987);
                    }
                    if (Shaders.usedShadowDepthBuffers >= 2 && Shaders.shadowMipmapEnabled[1]) {
                        GlStateManager.setActiveTexture(33989);
                        GlStateManager.bindTexture(Shaders.sfbDepthTextures.get(1));
                        GL30.glGenerateMipmap(3553);
                        GL11.glTexParameteri(3553, 10241, Shaders.shadowFilterNearest[1] ? 9984 : 9987);
                    }
                    GlStateManager.setActiveTexture(33984);
                }
                if (Shaders.usedShadowColorBuffers >= 1) {
                    if (Shaders.shadowColorMipmapEnabled[0]) {
                        GlStateManager.setActiveTexture(33997);
                        GlStateManager.bindTexture(Shaders.sfbColorTextures.get(0));
                        GL30.glGenerateMipmap(3553);
                        GL11.glTexParameteri(3553, 10241, Shaders.shadowColorFilterNearest[0] ? 9984 : 9987);
                    }
                    if (Shaders.usedShadowColorBuffers >= 2 && Shaders.shadowColorMipmapEnabled[1]) {
                        GlStateManager.setActiveTexture(33998);
                        GlStateManager.bindTexture(Shaders.sfbColorTextures.get(1));
                        GL30.glGenerateMipmap(3553);
                        GL11.glTexParameteri(3553, 10241, Shaders.shadowColorFilterNearest[1] ? 9984 : 9987);
                    }
                    GlStateManager.setActiveTexture(33984);
                }
            }
            Shaders.checkGLError("shadow postprocess");
            EXTFramebufferObject.glBindFramebufferEXT(36160, Shaders.dfb);
            GL11.glViewport(0, 0, Shaders.renderWidth, Shaders.renderHeight);
            Shaders.activeDrawBuffers = null;
            lllllllllllllllIIIIlIlIllIIIlIII.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            Shaders.useProgram(7);
            GL11.glMatrixMode(5888);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5889);
            GL11.glPopMatrix();
            GL11.glMatrixMode(5888);
            Shaders.checkGLError("shadow end");
        }
    }
    
    public static void renderEnchantedGlintBegin() {
        Shaders.useProgram(17);
    }
    
    public static void setupArrayPointersVbo() {
        final int lllllllllllllllIIIIlIlIlIllIllIl = 14;
        GL11.glVertexPointer(3, 5126, 56, 0L);
        GL11.glColorPointer(4, 5121, 56, 12L);
        GL11.glTexCoordPointer(2, 5126, 56, 16L);
        OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glTexCoordPointer(2, 5122, 56, 24L);
        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
        GL11.glNormalPointer(5120, 56, 28L);
        GL20.glVertexAttribPointer(Shaders.midTexCoordAttrib, 2, 5126, false, 56, 32L);
        GL20.glVertexAttribPointer(Shaders.tangentAttrib, 4, 5122, false, 56, 40L);
        GL20.glVertexAttribPointer(Shaders.entityAttrib, 3, 5122, false, 56, 48L);
    }
    
    public static void preRenderChunkLayer(final BlockRenderLayer lllllllllllllllIIIIlIlIlIlllIIlI) {
        if (Shaders.isRenderBackFace(lllllllllllllllIIIIlIlIlIlllIIlI)) {
            GlStateManager.disableCull();
        }
        if (OpenGlHelper.useVbo()) {
            GL11.glEnableClientState(32885);
            GL20.glEnableVertexAttribArray(Shaders.midTexCoordAttrib);
            GL20.glEnableVertexAttribArray(Shaders.tangentAttrib);
            GL20.glEnableVertexAttribArray(Shaders.entityAttrib);
        }
    }
    
    public static void renderFPOverlay(final EntityRenderer lllllllllllllllIIIIlIlIllIIlllIl, final float lllllllllllllllIIIIlIlIllIIlllII, final int lllllllllllllllIIIIlIlIllIIllIII) {
        if (!Shaders.isShadowPass) {
            Shaders.beginFPOverlay();
            lllllllllllllllIIIIlIlIllIIlllIl.renderHand(lllllllllllllllIIIIlIlIllIIlllII, lllllllllllllllIIIIlIlIllIIllIII, false, true, false);
            Shaders.endFPOverlay();
        }
    }
    
    public static void beaconBeamDraw2() {
        GlStateManager.disableBlend();
    }
    
    public static void renderItemFP(final ItemRenderer lllllllllllllllIIIIlIlIllIlIlIII, final float lllllllllllllllIIIIlIlIllIlIIIll, final boolean lllllllllllllllIIIIlIlIllIlIIllI) {
        Shaders.setRenderingFirstPersonHand(true);
        GlStateManager.depthMask(true);
        if (lllllllllllllllIIIIlIlIllIlIIllI) {
            GlStateManager.depthFunc(519);
            GL11.glPushMatrix();
            final IntBuffer lllllllllllllllIIIIlIlIllIlIIlIl = Shaders.activeDrawBuffers;
            Shaders.setDrawBuffers(Shaders.drawBuffersNone);
            Shaders.renderItemKeepDepthMask = true;
            lllllllllllllllIIIIlIlIllIlIlIII.renderItemInFirstPerson(lllllllllllllllIIIIlIlIllIlIIIll);
            Shaders.renderItemKeepDepthMask = false;
            Shaders.setDrawBuffers(lllllllllllllllIIIIlIlIllIlIIlIl);
            GL11.glPopMatrix();
        }
        GlStateManager.depthFunc(515);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        lllllllllllllllIIIIlIlIllIlIlIII.renderItemInFirstPerson(lllllllllllllllIIIIlIlIllIlIIIll);
        Shaders.setRenderingFirstPersonHand(false);
    }
    
    public static void beginTerrainCutout() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(7);
        }
    }
    
    public static boolean renderEndPortal(final TileEntityEndPortal lllllllllllllllIIIIlIlIlIlIlllII, final double lllllllllllllllIIIIlIlIlIlIllIll, final double lllllllllllllllIIIIlIlIlIlIIlIIl, final double lllllllllllllllIIIIlIlIlIlIllIIl, final float lllllllllllllllIIIIlIlIlIlIllIII, final int lllllllllllllllIIIIlIlIlIlIlIlll, final float lllllllllllllllIIIIlIlIlIlIlIllI) {
        if (!Shaders.isShadowPass && Shaders.programsID[Shaders.activeProgram] == 0) {
            return false;
        }
        GlStateManager.disableLighting();
        Config.getTextureManager().bindTexture(ShadersRender.END_PORTAL_TEXTURE);
        final Tessellator lllllllllllllllIIIIlIlIlIlIlIlIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIIIIlIlIlIlIlIlII = lllllllllllllllIIIIlIlIlIlIlIlIl.getBuffer();
        lllllllllllllllIIIIlIlIlIlIlIlII.begin(7, DefaultVertexFormats.BLOCK);
        final float lllllllllllllllIIIIlIlIlIlIlIIll = 0.5f;
        final float lllllllllllllllIIIIlIlIlIlIlIIlI = lllllllllllllllIIIIlIlIlIlIlIIll * 0.15f;
        final float lllllllllllllllIIIIlIlIlIlIlIIIl = lllllllllllllllIIIIlIlIlIlIlIIll * 0.3f;
        final float lllllllllllllllIIIIlIlIlIlIlIIII = lllllllllllllllIIIIlIlIlIlIlIIll * 0.4f;
        final float lllllllllllllllIIIIlIlIlIlIIllll = 0.0f;
        final float lllllllllllllllIIIIlIlIlIlIIlllI = 0.2f;
        final float lllllllllllllllIIIIlIlIlIlIIllIl = System.currentTimeMillis() % 100000L / 100000.0f;
        final int lllllllllllllllIIIIlIlIlIlIIllII = 240;
        if (lllllllllllllllIIIIlIlIlIlIlllII.shouldRenderFace(EnumFacing.SOUTH)) {
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl + 1.0, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl + 1.0, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
        }
        if (lllllllllllllllIIIIlIlIlIlIlllII.shouldRenderFace(EnumFacing.NORTH)) {
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl + 1.0, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl + 1.0, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
        }
        if (lllllllllllllllIIIIlIlIlIlIlllII.shouldRenderFace(EnumFacing.EAST)) {
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl + 1.0, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl + 1.0, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
        }
        if (lllllllllllllllIIIIlIlIlIlIlllII.shouldRenderFace(EnumFacing.WEST)) {
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl + 1.0, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl + 1.0, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
        }
        if (lllllllllllllllIIIIlIlIlIlIlllII.shouldRenderFace(EnumFacing.DOWN)) {
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
        }
        if (lllllllllllllllIIIIlIlIlIlIlllII.shouldRenderFace(EnumFacing.UP)) {
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl + lllllllllllllllIIIIlIlIlIlIlIllI, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl + lllllllllllllllIIIIlIlIlIlIlIllI, lllllllllllllllIIIIlIlIlIlIllIIl + 1.0).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll + 1.0, lllllllllllllllIIIIlIlIlIlIIlIIl + lllllllllllllllIIIIlIlIlIlIlIllI, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
            lllllllllllllllIIIIlIlIlIlIlIlII.pos(lllllllllllllllIIIIlIlIlIlIllIll, lllllllllllllllIIIIlIlIlIlIIlIIl + lllllllllllllllIIIIlIlIlIlIlIllI, lllllllllllllllIIIIlIlIlIlIllIIl).color(lllllllllllllllIIIIlIlIlIlIlIIlI, lllllllllllllllIIIIlIlIlIlIlIIIl, lllllllllllllllIIIIlIlIlIlIlIIII, 1.0f).tex(lllllllllllllllIIIIlIlIlIlIIlllI + lllllllllllllllIIIIlIlIlIlIIllIl, lllllllllllllllIIIIlIlIlIlIIllll + lllllllllllllllIIIIlIlIlIlIIllIl).lightmap(lllllllllllllllIIIIlIlIlIlIIllII, lllllllllllllllIIIIlIlIlIlIIllII).endVertex();
        }
        lllllllllllllllIIIIlIlIlIlIlIlIl.draw();
        GlStateManager.enableLighting();
        return true;
    }
    
    public static void beginBlockDamage() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(11);
            if (Shaders.programsID[11] == Shaders.programsID[7]) {
                Shaders.setDrawBuffers(Shaders.drawBuffersColorAtt0);
                GlStateManager.depthMask(false);
            }
        }
    }
    
    public static void beaconBeamStartQuad1() {
    }
    
    public static void beginTerrainCutoutMipped() {
        if (Shaders.isRenderingWorld) {
            Shaders.useProgram(7);
        }
    }
}
