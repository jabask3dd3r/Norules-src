package net.minecraft.client.renderer;

import java.nio.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.vertex.*;
import me.nrules.*;
import me.nrules.module.misc.*;
import net.minecraft.world.biome.*;
import net.minecraft.entity.player.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.material.*;
import me.nrules.event.events.*;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.inventory.*;
import net.minecraft.block.state.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.block.properties.*;
import net.minecraft.entity.passive.*;
import net.minecraft.client.resources.*;
import net.minecraft.util.text.*;
import optifine.*;
import net.minecraft.server.integrated.*;
import net.minecraft.enchantment.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import net.minecraft.util.math.*;
import org.lwjgl.util.glu.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.renderer.chunk.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.tileentity.*;
import me.nrules.module.render.*;
import me.nrules.notifications.*;
import net.minecraft.crash.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.advancements.*;
import net.minecraft.client.gui.*;
import java.io.*;
import com.google.gson.*;
import net.minecraft.client.renderer.block.model.*;
import javax.annotation.*;
import net.minecraft.entity.monster.*;
import com.google.common.base.*;
import net.minecraft.entity.item.*;
import java.util.*;
import net.minecraft.client.shader.*;
import net.minecraft.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import org.apache.logging.log4j.*;

public class EntityRenderer implements IResourceManagerReloadListener
{
    private /* synthetic */ ShaderGroup[] fxaaShaders;
    private final /* synthetic */ DynamicTexture lightmapTexture;
    private /* synthetic */ float smoothCamYaw;
    private /* synthetic */ float fovModifierHand;
    private /* synthetic */ boolean cloudFog;
    private /* synthetic */ double cameraPitch;
    private /* synthetic */ float fogColor2;
    public /* synthetic */ int frameCount;
    private final /* synthetic */ FloatBuffer fogColorBuffer;
    private /* synthetic */ int shaderIndex;
    private static final /* synthetic */ ResourceLocation SNOW_TEXTURES;
    private /* synthetic */ long lastErrorCheckTimeMs;
    private /* synthetic */ long timeWorldIcon;
    private /* synthetic */ double cameraZoom;
    private /* synthetic */ float field_190568_ad;
    private /* synthetic */ int serverWaitTime;
    public /* synthetic */ ShaderGroup theShaderGroup;
    private /* synthetic */ float fovModifierHandPrev;
    private /* synthetic */ float avgServerTimeDiff;
    private /* synthetic */ int debugViewDirection;
    private /* synthetic */ long lastServerTime;
    private /* synthetic */ float farPlaneDistance;
    private /* synthetic */ float smoothCamFilterX;
    private /* synthetic */ boolean lightmapUpdateNeeded;
    private /* synthetic */ Entity pointedEntity;
    private /* synthetic */ boolean drawBlockOutline;
    public static /* synthetic */ int anaglyphField;
    private /* synthetic */ float scopeMath;
    private final /* synthetic */ float[] rainXCoords;
    private /* synthetic */ MouseFilter mouseFilterYAxis;
    private /* synthetic */ long prevFrameTime;
    private /* synthetic */ boolean renderHand;
    public /* synthetic */ ItemRenderer itemRenderer;
    private /* synthetic */ float smoothCamPartialTicks;
    private /* synthetic */ boolean initialized;
    private final /* synthetic */ MapItemRenderer theMapItemRenderer;
    public /* synthetic */ float fogColorGreen;
    private /* synthetic */ float bossColorModifierPrev;
    private /* synthetic */ float smoothCamPitch;
    private /* synthetic */ World updatedWorld;
    private final /* synthetic */ Random random;
    private static final /* synthetic */ Logger LOGGER;
    public /* synthetic */ float fogColorBlue;
    private /* synthetic */ float torchFlickerX;
    private /* synthetic */ float smoothCamFilterY;
    private /* synthetic */ int serverWaitTimeCurrent;
    private /* synthetic */ long renderEndNanoTime;
    public /* synthetic */ float fogColorRed;
    private /* synthetic */ boolean debugView;
    private /* synthetic */ boolean loadVisibleChunks;
    public static /* synthetic */ boolean anaglyphEnable;
    private /* synthetic */ float avgServerTickDiff;
    private final /* synthetic */ IResourceManager resourceManager;
    private /* synthetic */ double cameraYaw;
    private final /* synthetic */ ResourceLocation locationLightMap;
    private /* synthetic */ ItemStack field_190566_ab;
    private /* synthetic */ boolean useShader;
    private /* synthetic */ float torchFlickerDX;
    private /* synthetic */ MouseFilter mouseFilterXAxis;
    private /* synthetic */ int lastServerTicks;
    private final /* synthetic */ int[] lightmapColors;
    private final /* synthetic */ float[] rainYCoords;
    public static final /* synthetic */ int SHADER_COUNT;
    private /* synthetic */ float bossColorModifier;
    private /* synthetic */ int rendererUpdateCount;
    private /* synthetic */ float thirdPersonDistancePrev;
    private /* synthetic */ float fogColor1;
    private /* synthetic */ int field_190567_ac;
    private /* synthetic */ float clipDistance;
    private final /* synthetic */ Minecraft mc;
    public /* synthetic */ boolean fogStandard;
    private static final /* synthetic */ ResourceLocation[] SHADERS_TEXTURES;
    private /* synthetic */ float field_190569_ae;
    private /* synthetic */ int rainSoundCounter;
    
    public MapItemRenderer getMapItemRenderer() {
        return this.theMapItemRenderer;
    }
    
    private void updateMainMenu(final GuiMainMenu lllllllllllllllIIIIlllllIIlllIll) {
        try {
            String lllllllllllllllIIIIlllllIIllllll = null;
            final Calendar lllllllllllllllIIIIlllllIIlllllI = Calendar.getInstance();
            lllllllllllllllIIIIlllllIIlllllI.setTime(new Date());
            final int lllllllllllllllIIIIlllllIIllllIl = lllllllllllllllIIIIlllllIIlllllI.get(5);
            final int lllllllllllllllIIIIlllllIIllllII = lllllllllllllllIIIIlllllIIlllllI.get(2) + 1;
            if (lllllllllllllllIIIIlllllIIllllIl == 8 && lllllllllllllllIIIIlllllIIllllII == 4) {
                lllllllllllllllIIIIlllllIIllllll = "Happy birthday, OptiFine!";
            }
            if (lllllllllllllllIIIIlllllIIllllIl == 14 && lllllllllllllllIIIIlllllIIllllII == 8) {
                lllllllllllllllIIIIlllllIIllllll = "Happy birthday, sp614x!";
            }
            if (lllllllllllllllIIIIlllllIIllllll == null) {
                return;
            }
            Reflector.setFieldValue(lllllllllllllllIIIIlllllIIlllIll, Reflector.GuiMainMenu_splashText, lllllllllllllllIIIIlllllIIllllll);
        }
        catch (Throwable t) {}
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllllIIIlIIIllIIIIIlll) {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        if (this.shaderIndex == EntityRenderer.SHADER_COUNT) {
            this.loadEntityShader(this.mc.getRenderViewEntity());
        }
        else {
            this.loadShader(EntityRenderer.SHADERS_TEXTURES[this.shaderIndex]);
        }
    }
    
    protected void renderRainSnow(final float lllllllllllllllIIIlIIIIIIlIllIIl) {
        if (Reflector.ForgeWorldProvider_getWeatherRenderer.exists()) {
            final WorldProvider lllllllllllllllIIIlIIIIIIlIllIII = this.mc.world.provider;
            final Object lllllllllllllllIIIlIIIIIIlIlIlll = Reflector.call(lllllllllllllllIIIlIIIIIIlIllIII, Reflector.ForgeWorldProvider_getWeatherRenderer, new Object[0]);
            if (lllllllllllllllIIIlIIIIIIlIlIlll != null) {
                Reflector.callVoid(lllllllllllllllIIIlIIIIIIlIlIlll, Reflector.IRenderHandler_render, lllllllllllllllIIIlIIIIIIlIllIIl, this.mc.world, this.mc);
                return;
            }
        }
        final float lllllllllllllllIIIlIIIIIIlIlIllI = this.mc.world.getRainStrength(lllllllllllllllIIIlIIIIIIlIllIIl);
        if (Config.isRainOff()) {
            return;
        }
        this.enableLightmap();
        final Entity lllllllllllllllIIIlIIIIIIlIlIlIl = this.mc.getRenderViewEntity();
        final World lllllllllllllllIIIlIIIIIIlIlIlII = this.mc.world;
        final int lllllllllllllllIIIlIIIIIIlIlIIll = MathHelper.floor(lllllllllllllllIIIlIIIIIIlIlIlIl.posX);
        final int lllllllllllllllIIIlIIIIIIlIlIIlI = MathHelper.floor(lllllllllllllllIIIlIIIIIIlIlIlIl.posY);
        final int lllllllllllllllIIIlIIIIIIlIlIIIl = MathHelper.floor(lllllllllllllllIIIlIIIIIIlIlIlIl.posZ);
        final Tessellator lllllllllllllllIIIlIIIIIIlIlIIII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIIIlIIIIIIlIIllll = lllllllllllllllIIIlIIIIIIlIlIIII.getBuffer();
        GlStateManager.disableCull();
        GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.alphaFunc(516, 0.1f);
        final double lllllllllllllllIIIlIIIIIIlIIlllI = lllllllllllllllIIIlIIIIIIlIlIlIl.lastTickPosX + (lllllllllllllllIIIlIIIIIIlIlIlIl.posX - lllllllllllllllIIIlIIIIIIlIlIlIl.lastTickPosX) * lllllllllllllllIIIlIIIIIIlIllIIl;
        final double lllllllllllllllIIIlIIIIIIlIIllIl = lllllllllllllllIIIlIIIIIIlIlIlIl.lastTickPosY + (lllllllllllllllIIIlIIIIIIlIlIlIl.posY - lllllllllllllllIIIlIIIIIIlIlIlIl.lastTickPosY) * lllllllllllllllIIIlIIIIIIlIllIIl;
        final double lllllllllllllllIIIlIIIIIIlIIllII = lllllllllllllllIIIlIIIIIIlIlIlIl.lastTickPosZ + (lllllllllllllllIIIlIIIIIIlIlIlIl.posZ - lllllllllllllllIIIlIIIIIIlIlIlIl.lastTickPosZ) * lllllllllllllllIIIlIIIIIIlIllIIl;
        final int lllllllllllllllIIIlIIIIIIlIIlIll = MathHelper.floor(lllllllllllllllIIIlIIIIIIlIIllIl);
        int lllllllllllllllIIIlIIIIIIlIIlIlI = 5;
        if (Config.isRainFancy()) {
            lllllllllllllllIIIlIIIIIIlIIlIlI = 10;
        }
        int lllllllllllllllIIIlIIIIIIlIIlIIl = -1;
        final float lllllllllllllllIIIlIIIIIIlIIlIII = this.rendererUpdateCount + lllllllllllllllIIIlIIIIIIlIllIIl;
        lllllllllllllllIIIlIIIIIIlIIllll.setTranslation(-lllllllllllllllIIIlIIIIIIlIIlllI, -lllllllllllllllIIIlIIIIIIlIIllIl, -lllllllllllllllIIIlIIIIIIlIIllII);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final BlockPos.MutableBlockPos lllllllllllllllIIIlIIIIIIlIIIlll = new BlockPos.MutableBlockPos();
        for (int lllllllllllllllIIIlIIIIIIlIIIllI = lllllllllllllllIIIlIIIIIIlIlIIIl - lllllllllllllllIIIlIIIIIIlIIlIlI; lllllllllllllllIIIlIIIIIIlIIIllI <= lllllllllllllllIIIlIIIIIIlIlIIIl + lllllllllllllllIIIlIIIIIIlIIlIlI; ++lllllllllllllllIIIlIIIIIIlIIIllI) {
            for (int lllllllllllllllIIIlIIIIIIlIIIlIl = lllllllllllllllIIIlIIIIIIlIlIIll - lllllllllllllllIIIlIIIIIIlIIlIlI; lllllllllllllllIIIlIIIIIIlIIIlIl <= lllllllllllllllIIIlIIIIIIlIlIIll + lllllllllllllllIIIlIIIIIIlIIlIlI; ++lllllllllllllllIIIlIIIIIIlIIIlIl) {
                final int lllllllllllllllIIIlIIIIIIlIIIlII = (lllllllllllllllIIIlIIIIIIlIIIllI - lllllllllllllllIIIlIIIIIIlIlIIIl + 16) * 32 + lllllllllllllllIIIlIIIIIIlIIIlIl - lllllllllllllllIIIlIIIIIIlIlIIll + 16;
                final double lllllllllllllllIIIlIIIIIIlIIIIll = this.rainXCoords[lllllllllllllllIIIlIIIIIIlIIIlII] * 0.5;
                final double lllllllllllllllIIIlIIIIIIlIIIIlI = this.rainYCoords[lllllllllllllllIIIlIIIIIIlIIIlII] * 0.5;
                lllllllllllllllIIIlIIIIIIlIIIlll.setPos(lllllllllllllllIIIlIIIIIIlIIIlIl, 0, lllllllllllllllIIIlIIIIIIlIIIllI);
                final Biome lllllllllllllllIIIlIIIIIIlIIIIIl = lllllllllllllllIIIlIIIIIIlIlIlII.getBiome(lllllllllllllllIIIlIIIIIIlIIIlll);
                final int lllllllllllllllIIIlIIIIIIlIIIIII = lllllllllllllllIIIlIIIIIIlIlIlII.getPrecipitationHeight(lllllllllllllllIIIlIIIIIIlIIIlll).getY();
                int lllllllllllllllIIIlIIIIIIIllllll = lllllllllllllllIIIlIIIIIIlIlIIlI - lllllllllllllllIIIlIIIIIIlIIlIlI;
                int lllllllllllllllIIIlIIIIIIIlllllI = lllllllllllllllIIIlIIIIIIlIlIIlI + lllllllllllllllIIIlIIIIIIlIIlIlI;
                if (lllllllllllllllIIIlIIIIIIIllllll < lllllllllllllllIIIlIIIIIIlIIIIII) {
                    lllllllllllllllIIIlIIIIIIIllllll = lllllllllllllllIIIlIIIIIIlIIIIII;
                }
                if (lllllllllllllllIIIlIIIIIIIlllllI < lllllllllllllllIIIlIIIIIIlIIIIII) {
                    lllllllllllllllIIIlIIIIIIIlllllI = lllllllllllllllIIIlIIIIIIlIIIIII;
                }
                int lllllllllllllllIIIlIIIIIIIllllIl;
                if ((lllllllllllllllIIIlIIIIIIIllllIl = lllllllllllllllIIIlIIIIIIlIIIIII) < lllllllllllllllIIIlIIIIIIlIIlIll) {
                    lllllllllllllllIIIlIIIIIIIllllIl = lllllllllllllllIIIlIIIIIIlIIlIll;
                }
                if (lllllllllllllllIIIlIIIIIIIllllll != lllllllllllllllIIIlIIIIIIIlllllI) {
                    this.random.setSeed(lllllllllllllllIIIlIIIIIIlIIIlIl * lllllllllllllllIIIlIIIIIIlIIIlIl * 3121 + lllllllllllllllIIIlIIIIIIlIIIlIl * 45238971 ^ lllllllllllllllIIIlIIIIIIlIIIllI * lllllllllllllllIIIlIIIIIIlIIIllI * 418711 + lllllllllllllllIIIlIIIIIIlIIIllI * 13761);
                    lllllllllllllllIIIlIIIIIIlIIIlll.setPos(lllllllllllllllIIIlIIIIIIlIIIlIl, lllllllllllllllIIIlIIIIIIIllllll, lllllllllllllllIIIlIIIIIIlIIIllI);
                    final float lllllllllllllllIIIlIIIIIIIllllII = lllllllllllllllIIIlIIIIIIlIIIIIl.getFloatTemperature(lllllllllllllllIIIlIIIIIIlIIIlll);
                    if (lllllllllllllllIIIlIIIIIIlIlIlII.getBiomeProvider().getTemperatureAtHeight(lllllllllllllllIIIlIIIIIIIllllII, lllllllllllllllIIIlIIIIIIlIIIIII) >= 0.15f) {
                        if (lllllllllllllllIIIlIIIIIIlIIlIIl != 1) {
                            if (lllllllllllllllIIIlIIIIIIlIIlIIl >= 0) {
                                lllllllllllllllIIIlIIIIIIlIlIIII.draw();
                            }
                            lllllllllllllllIIIlIIIIIIlIIlIIl = 1;
                            this.mc.getTextureManager().bindTexture(EntityRenderer.SNOW_TEXTURES);
                            lllllllllllllllIIIlIIIIIIlIIllll.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                        }
                        final double lllllllllllllllIIIlIIIIIIIlllIll = -((this.rendererUpdateCount & 0x1FF) + lllllllllllllllIIIlIIIIIIlIllIIl) / 512.0f;
                        final double lllllllllllllllIIIlIIIIIIIlllIlI = this.random.nextDouble() + lllllllllllllllIIIlIIIIIIlIIlIII * 0.03 * (float)this.random.nextGaussian();
                        final double lllllllllllllllIIIlIIIIIIIlllIIl = this.random.nextDouble() + lllllllllllllllIIIlIIIIIIlIIlIII * (float)this.random.nextGaussian() * 0.001;
                        final double lllllllllllllllIIIlIIIIIIIlllIII = lllllllllllllllIIIlIIIIIIlIIIlIl + 0.5f - lllllllllllllllIIIlIIIIIIlIlIlIl.posX;
                        final double lllllllllllllllIIIlIIIIIIIllIlll = lllllllllllllllIIIlIIIIIIlIIIllI + 0.5f - lllllllllllllllIIIlIIIIIIlIlIlIl.posZ;
                        final float lllllllllllllllIIIlIIIIIIIllIllI = MathHelper.sqrt(lllllllllllllllIIIlIIIIIIIlllIII * lllllllllllllllIIIlIIIIIIIlllIII + lllllllllllllllIIIlIIIIIIIllIlll * lllllllllllllllIIIlIIIIIIIllIlll) / lllllllllllllllIIIlIIIIIIlIIlIlI;
                        final float lllllllllllllllIIIlIIIIIIIllIlIl = Main.moduleManager.getModule(VisualSnow.class).isToggled() ? 0.33f : 0.0f;
                        lllllllllllllllIIIlIIIIIIlIIIlll.setPos(lllllllllllllllIIIlIIIIIIlIIIlIl, lllllllllllllllIIIlIIIIIIIllllIl, lllllllllllllllIIIlIIIIIIlIIIllI);
                        final int lllllllllllllllIIIlIIIIIIIllIlII = (lllllllllllllllIIIlIIIIIIlIlIlII.getCombinedLight(lllllllllllllllIIIlIIIIIIlIIIlll, 0) * 3 + 15728880) / 4;
                        final int lllllllllllllllIIIlIIIIIIIllIIll = lllllllllllllllIIIlIIIIIIIllIlII >> 16 & 0x1249;
                        final int lllllllllllllllIIIlIIIIIIIllIIlI = lllllllllllllllIIIlIIIIIIIllIlII & 0x1249;
                        lllllllllllllllIIIlIIIIIIlIIllll.pos(lllllllllllllllIIIlIIIIIIlIIIlIl - lllllllllllllllIIIlIIIIIIlIIIIll + 0.5, lllllllllllllllIIIlIIIIIIIlllllI, lllllllllllllllIIIlIIIIIIlIIIllI - lllllllllllllllIIIlIIIIIIlIIIIlI + 0.5).tex(0.0 + lllllllllllllllIIIlIIIIIIIlllIlI, lllllllllllllllIIIlIIIIIIIllllll * 0.25 + lllllllllllllllIIIlIIIIIIIlllIll + lllllllllllllllIIIlIIIIIIIlllIIl).color(1.0f, 1.0f, 1.0f, lllllllllllllllIIIlIIIIIIIllIlIl).lightmap(lllllllllllllllIIIlIIIIIIIllIIll, lllllllllllllllIIIlIIIIIIIllIIlI).endVertex();
                        lllllllllllllllIIIlIIIIIIlIIllll.pos(lllllllllllllllIIIlIIIIIIlIIIlIl + lllllllllllllllIIIlIIIIIIlIIIIll + 0.5, lllllllllllllllIIIlIIIIIIIlllllI, lllllllllllllllIIIlIIIIIIlIIIllI + lllllllllllllllIIIlIIIIIIlIIIIlI + 0.5).tex(1.0 + lllllllllllllllIIIlIIIIIIIlllIlI, lllllllllllllllIIIlIIIIIIIllllll * 0.25 + lllllllllllllllIIIlIIIIIIIlllIll + lllllllllllllllIIIlIIIIIIIlllIIl).color(1.0f, 1.0f, 1.0f, lllllllllllllllIIIlIIIIIIIllIlIl).lightmap(lllllllllllllllIIIlIIIIIIIllIIll, lllllllllllllllIIIlIIIIIIIllIIlI).endVertex();
                        lllllllllllllllIIIlIIIIIIlIIllll.pos(lllllllllllllllIIIlIIIIIIlIIIlIl + lllllllllllllllIIIlIIIIIIlIIIIll + 0.5, lllllllllllllllIIIlIIIIIIIllllll, lllllllllllllllIIIlIIIIIIlIIIllI + lllllllllllllllIIIlIIIIIIlIIIIlI + 0.5).tex(1.0 + lllllllllllllllIIIlIIIIIIIlllIlI, lllllllllllllllIIIlIIIIIIIlllllI * 0.25 + lllllllllllllllIIIlIIIIIIIlllIll + lllllllllllllllIIIlIIIIIIIlllIIl).color(1.0f, 1.0f, 1.0f, lllllllllllllllIIIlIIIIIIIllIlIl).lightmap(lllllllllllllllIIIlIIIIIIIllIIll, lllllllllllllllIIIlIIIIIIIllIIlI).endVertex();
                        lllllllllllllllIIIlIIIIIIlIIllll.pos(lllllllllllllllIIIlIIIIIIlIIIlIl - lllllllllllllllIIIlIIIIIIlIIIIll + 0.5, lllllllllllllllIIIlIIIIIIIllllll, lllllllllllllllIIIlIIIIIIlIIIllI - lllllllllllllllIIIlIIIIIIlIIIIlI + 0.5).tex(0.0 + lllllllllllllllIIIlIIIIIIIlllIlI, lllllllllllllllIIIlIIIIIIIlllllI * 0.25 + lllllllllllllllIIIlIIIIIIIlllIll + lllllllllllllllIIIlIIIIIIIlllIIl).color(1.0f, 1.0f, 1.0f, lllllllllllllllIIIlIIIIIIIllIlIl).lightmap(lllllllllllllllIIIlIIIIIIIllIIll, lllllllllllllllIIIlIIIIIIIllIIlI).endVertex();
                    }
                    else {
                        if (lllllllllllllllIIIlIIIIIIlIIlIIl != 1) {
                            if (lllllllllllllllIIIlIIIIIIlIIlIIl >= 0) {
                                lllllllllllllllIIIlIIIIIIlIlIIII.draw();
                            }
                            lllllllllllllllIIIlIIIIIIlIIlIIl = 1;
                            this.mc.getTextureManager().bindTexture(EntityRenderer.SNOW_TEXTURES);
                            lllllllllllllllIIIlIIIIIIlIIllll.begin(7, DefaultVertexFormats.PARTICLE_POSITION_TEX_COLOR_LMAP);
                        }
                        final double lllllllllllllllIIIlIIIIIIIllIIIl = -((this.rendererUpdateCount & 0x1FF) + lllllllllllllllIIIlIIIIIIlIllIIl) / 512.0f;
                        final double lllllllllllllllIIIlIIIIIIIllIIII = this.random.nextDouble() + lllllllllllllllIIIlIIIIIIlIIlIII * 0.03 * (float)this.random.nextGaussian();
                        final double lllllllllllllllIIIlIIIIIIIlIllll = this.random.nextDouble() + lllllllllllllllIIIlIIIIIIlIIlIII * (float)this.random.nextGaussian() * 0.001;
                        final double lllllllllllllllIIIlIIIIIIIlIlllI = lllllllllllllllIIIlIIIIIIlIIIlIl + 0.5f - lllllllllllllllIIIlIIIIIIlIlIlIl.posX;
                        final double lllllllllllllllIIIlIIIIIIIlIllIl = lllllllllllllllIIIlIIIIIIlIIIllI + 0.5f - lllllllllllllllIIIlIIIIIIlIlIlIl.posZ;
                        final float lllllllllllllllIIIlIIIIIIIlIllII = MathHelper.sqrt(lllllllllllllllIIIlIIIIIIIlIlllI * lllllllllllllllIIIlIIIIIIIlIlllI + lllllllllllllllIIIlIIIIIIIlIllIl * lllllllllllllllIIIlIIIIIIIlIllIl) / lllllllllllllllIIIlIIIIIIlIIlIlI;
                        final float lllllllllllllllIIIlIIIIIIIlIlIll = Main.moduleManager.getModule(VisualSnow.class).isToggled() ? 0.33f : 0.0f;
                        lllllllllllllllIIIlIIIIIIlIIIlll.setPos(lllllllllllllllIIIlIIIIIIlIIIlIl, lllllllllllllllIIIlIIIIIIIllllIl, lllllllllllllllIIIlIIIIIIlIIIllI);
                        final int lllllllllllllllIIIlIIIIIIIlIlIlI = (lllllllllllllllIIIlIIIIIIlIlIlII.getCombinedLight(lllllllllllllllIIIlIIIIIIlIIIlll, 0) * 3 + 15728880) / 4;
                        final int lllllllllllllllIIIlIIIIIIIlIlIIl = lllllllllllllllIIIlIIIIIIIlIlIlI >> 16 & 0x1249;
                        final int lllllllllllllllIIIlIIIIIIIlIlIII = lllllllllllllllIIIlIIIIIIIlIlIlI & 0x1249;
                        lllllllllllllllIIIlIIIIIIlIIllll.pos(lllllllllllllllIIIlIIIIIIlIIIlIl - lllllllllllllllIIIlIIIIIIlIIIIll + 0.5, lllllllllllllllIIIlIIIIIIIlllllI, lllllllllllllllIIIlIIIIIIlIIIllI - lllllllllllllllIIIlIIIIIIlIIIIlI + 0.5).tex(0.0 + lllllllllllllllIIIlIIIIIIIllIIII, lllllllllllllllIIIlIIIIIIIllllll * 0.25 + lllllllllllllllIIIlIIIIIIIllIIIl + lllllllllllllllIIIlIIIIIIIlIllll).color(1.0f, 1.0f, 1.0f, lllllllllllllllIIIlIIIIIIIlIlIll).lightmap(lllllllllllllllIIIlIIIIIIIlIlIIl, lllllllllllllllIIIlIIIIIIIlIlIII).endVertex();
                        lllllllllllllllIIIlIIIIIIlIIllll.pos(lllllllllllllllIIIlIIIIIIlIIIlIl + lllllllllllllllIIIlIIIIIIlIIIIll + 0.5, lllllllllllllllIIIlIIIIIIIlllllI, lllllllllllllllIIIlIIIIIIlIIIllI + lllllllllllllllIIIlIIIIIIlIIIIlI + 0.5).tex(1.0 + lllllllllllllllIIIlIIIIIIIllIIII, lllllllllllllllIIIlIIIIIIIllllll * 0.25 + lllllllllllllllIIIlIIIIIIIllIIIl + lllllllllllllllIIIlIIIIIIIlIllll).color(1.0f, 1.0f, 1.0f, lllllllllllllllIIIlIIIIIIIlIlIll).lightmap(lllllllllllllllIIIlIIIIIIIlIlIIl, lllllllllllllllIIIlIIIIIIIlIlIII).endVertex();
                        lllllllllllllllIIIlIIIIIIlIIllll.pos(lllllllllllllllIIIlIIIIIIlIIIlIl + lllllllllllllllIIIlIIIIIIlIIIIll + 0.5, lllllllllllllllIIIlIIIIIIIllllll, lllllllllllllllIIIlIIIIIIlIIIllI + lllllllllllllllIIIlIIIIIIlIIIIlI + 0.5).tex(1.0 + lllllllllllllllIIIlIIIIIIIllIIII, lllllllllllllllIIIlIIIIIIIlllllI * 0.25 + lllllllllllllllIIIlIIIIIIIllIIIl + lllllllllllllllIIIlIIIIIIIlIllll).color(1.0f, 1.0f, 1.0f, lllllllllllllllIIIlIIIIIIIlIlIll).lightmap(lllllllllllllllIIIlIIIIIIIlIlIIl, lllllllllllllllIIIlIIIIIIIlIlIII).endVertex();
                        lllllllllllllllIIIlIIIIIIlIIllll.pos(lllllllllllllllIIIlIIIIIIlIIIlIl - lllllllllllllllIIIlIIIIIIlIIIIll + 0.5, lllllllllllllllIIIlIIIIIIIllllll, lllllllllllllllIIIlIIIIIIlIIIllI - lllllllllllllllIIIlIIIIIIlIIIIlI + 0.5).tex(0.0 + lllllllllllllllIIIlIIIIIIIllIIII, lllllllllllllllIIIlIIIIIIIlllllI * 0.25 + lllllllllllllllIIIlIIIIIIIllIIIl + lllllllllllllllIIIlIIIIIIIlIllll).color(1.0f, 1.0f, 1.0f, lllllllllllllllIIIlIIIIIIIlIlIll).lightmap(lllllllllllllllIIIlIIIIIIIlIlIIl, lllllllllllllllIIIlIIIIIIIlIlIII).endVertex();
                    }
                }
            }
        }
        if (lllllllllllllllIIIlIIIIIIlIIlIIl >= 0) {
            lllllllllllllllIIIlIIIIIIlIlIIII.draw();
        }
        lllllllllllllllIIIlIIIIIIlIIllll.setTranslation(0.0, 0.0, 0.0);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.alphaFunc(516, 0.1f);
        this.disableLightmap();
    }
    
    public ShaderGroup getShaderGroup() {
        return this.theShaderGroup;
    }
    
    private void renderWorldPass(final int lllllllllllllllIIIlIIIIIllIllllI, final float lllllllllllllllIIIlIIIIIlllIllll, final long lllllllllllllllIIIlIIIIIlllIlllI) {
        final boolean lllllllllllllllIIIlIIIIIlllIllIl = Config.isShaders();
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.beginRenderPass(lllllllllllllllIIIlIIIIIllIllllI, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIlllIlllI);
        }
        final RenderGlobal lllllllllllllllIIIlIIIIIlllIllII = this.mc.renderGlobal;
        final ParticleManager lllllllllllllllIIIlIIIIIlllIlIll = this.mc.effectRenderer;
        final boolean lllllllllllllllIIIlIIIIIlllIlIlI = this.isDrawBlockOutline();
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("clear");
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.setViewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }
        else {
            GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
        }
        this.updateFogColor(lllllllllllllllIIIlIIIIIlllIllll);
        GlStateManager.clear(16640);
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.clearRenderBuffer();
        }
        this.mc.mcProfiler.endStartSection("camera");
        this.setupCameraTransform(lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI);
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.setCamera(lllllllllllllllIIIlIIIIIlllIllll);
        }
        ActiveRenderInfo.updateRenderInfo(this.mc.player, this.mc.gameSettings.thirdPersonView == 2);
        this.mc.mcProfiler.endStartSection("frustum");
        final ClippingHelper lllllllllllllllIIIlIIIIIlllIlIIl = ClippingHelperImpl.getInstance();
        this.mc.mcProfiler.endStartSection("culling");
        final ICamera lllllllllllllllIIIlIIIIIlllIlIII = new Frustum(lllllllllllllllIIIlIIIIIlllIlIIl);
        final Entity lllllllllllllllIIIlIIIIIlllIIlll = this.mc.getRenderViewEntity();
        final double lllllllllllllllIIIlIIIIIlllIIllI = lllllllllllllllIIIlIIIIIlllIIlll.lastTickPosX + (lllllllllllllllIIIlIIIIIlllIIlll.posX - lllllllllllllllIIIlIIIIIlllIIlll.lastTickPosX) * lllllllllllllllIIIlIIIIIlllIllll;
        final double lllllllllllllllIIIlIIIIIlllIIlIl = lllllllllllllllIIIlIIIIIlllIIlll.lastTickPosY + (lllllllllllllllIIIlIIIIIlllIIlll.posY - lllllllllllllllIIIlIIIIIlllIIlll.lastTickPosY) * lllllllllllllllIIIlIIIIIlllIllll;
        final double lllllllllllllllIIIlIIIIIlllIIlII = lllllllllllllllIIIlIIIIIlllIIlll.lastTickPosZ + (lllllllllllllllIIIlIIIIIlllIIlll.posZ - lllllllllllllllIIIlIIIIIlllIIlll.lastTickPosZ) * lllllllllllllllIIIlIIIIIlllIllll;
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            ShadersRender.setFrustrumPosition(lllllllllllllllIIIlIIIIIlllIlIII, lllllllllllllllIIIlIIIIIlllIIllI, lllllllllllllllIIIlIIIIIlllIIlIl, lllllllllllllllIIIlIIIIIlllIIlII);
        }
        else {
            lllllllllllllllIIIlIIIIIlllIlIII.setPosition(lllllllllllllllIIIlIIIIIlllIIllI, lllllllllllllllIIIlIIIIIlllIIlIl, lllllllllllllllIIIlIIIIIlllIIlII);
        }
        if ((Config.isSkyEnabled() || Config.isSunMoonEnabled() || Config.isStarsEnabled()) && !Shaders.isShadowPass) {
            this.setupFog(-1, lllllllllllllllIIIlIIIIIlllIllll);
            this.mc.mcProfiler.endStartSection("sky");
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(lllllllllllllllIIIlIIIIIlllIllll, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
            if (lllllllllllllllIIIlIIIIIlllIllIl) {
                Shaders.beginSky();
            }
            lllllllllllllllIIIlIIIIIlllIllII.renderSky(lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI);
            if (lllllllllllllllIIIlIIIIIlllIllIl) {
                Shaders.endSky();
            }
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(lllllllllllllllIIIlIIIIIlllIllll, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
        }
        else {
            GlStateManager.disableBlend();
        }
        this.setupFog(0, lllllllllllllllIIIlIIIIIlllIllll);
        GlStateManager.shadeModel(7425);
        if (lllllllllllllllIIIlIIIIIlllIIlll.posY + lllllllllllllllIIIlIIIIIlllIIlll.getEyeHeight() < 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f) {
            this.renderCloudsCheck(lllllllllllllllIIIlIIIIIlllIllII, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI, lllllllllllllllIIIlIIIIIlllIIllI, lllllllllllllllIIIlIIIIIlllIIlIl, lllllllllllllllIIIlIIIIIlllIIlII);
        }
        this.mc.mcProfiler.endStartSection("prepareterrain");
        this.setupFog(0, lllllllllllllllIIIlIIIIIlllIllll);
        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        RenderHelper.disableStandardItemLighting();
        this.mc.mcProfiler.endStartSection("terrain_setup");
        this.checkLoadVisibleChunks(lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIlllIlIII, this.mc.player.isSpectator());
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            ShadersRender.setupTerrain(lllllllllllllllIIIlIIIIIlllIllII, lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIlllIlIII, this.frameCount++, this.mc.player.isSpectator());
        }
        else {
            lllllllllllllllIIIlIIIIIlllIllII.setupTerrain(lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIlllIlIII, this.frameCount++, this.mc.player.isSpectator());
        }
        if (lllllllllllllllIIIlIIIIIllIllllI == 0 || lllllllllllllllIIIlIIIIIllIllllI == 2) {
            this.mc.mcProfiler.endStartSection("updatechunks");
            Lagometer.timerChunkUpload.start();
            this.mc.renderGlobal.updateChunks(lllllllllllllllIIIlIIIIIlllIlllI);
            Lagometer.timerChunkUpload.end();
        }
        this.mc.mcProfiler.endStartSection("terrain");
        Lagometer.timerTerrain.start();
        if (this.mc.gameSettings.ofSmoothFps && lllllllllllllllIIIlIIIIIllIllllI > 0) {
            this.mc.mcProfiler.endStartSection("finish");
            GL11.glFinish();
            this.mc.mcProfiler.endStartSection("terrain");
        }
        GlStateManager.matrixMode(5888);
        GlStateManager.pushMatrix();
        GlStateManager.disableAlpha();
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            ShadersRender.beginTerrainSolid();
        }
        lllllllllllllllIIIlIIIIIlllIllII.renderBlockLayer(BlockRenderLayer.SOLID, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI, lllllllllllllllIIIlIIIIIlllIIlll);
        GlStateManager.enableAlpha();
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            ShadersRender.beginTerrainCutoutMipped();
        }
        lllllllllllllllIIIlIIIIIlllIllII.renderBlockLayer(BlockRenderLayer.CUTOUT_MIPPED, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI, lllllllllllllllIIIlIIIIIlllIIlll);
        this.mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            ShadersRender.beginTerrainCutout();
        }
        lllllllllllllllIIIlIIIIIlllIllII.renderBlockLayer(BlockRenderLayer.CUTOUT, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI, lllllllllllllllIIIlIIIIIlllIIlll);
        this.mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            ShadersRender.endTerrain();
        }
        Lagometer.timerTerrain.end();
        GlStateManager.shadeModel(7424);
        GlStateManager.alphaFunc(516, 0.1f);
        if (!this.debugView) {
            GlStateManager.matrixMode(5888);
            GlStateManager.popMatrix();
            GlStateManager.pushMatrix();
            RenderHelper.enableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("entities");
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, 0);
            }
            lllllllllllllllIIIlIIIIIlllIllII.renderEntities(lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIlIII, lllllllllllllllIIIlIIIIIlllIllll);
            if (Reflector.ForgeHooksClient_setRenderPass.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, -1);
            }
            RenderHelper.disableStandardItemLighting();
            this.disableLightmap();
        }
        GlStateManager.matrixMode(5888);
        GlStateManager.popMatrix();
        if (lllllllllllllllIIIlIIIIIlllIlIlI && this.mc.objectMouseOver != null && !lllllllllllllllIIIlIIIIIlllIIlll.isInsideOfMaterial(Material.WATER)) {
            final EntityPlayer lllllllllllllllIIIlIIIIIlllIIIll = (EntityPlayer)lllllllllllllllIIIlIIIIIlllIIlll;
            GlStateManager.disableAlpha();
            this.mc.mcProfiler.endStartSection("outline");
            final EventRender3D lllllllllllllllIIIlIIIIIlllIIIlI = new EventRender3D(lllllllllllllllIIIlIIIIIlllIllll, 0, 0, 0);
            lllllllllllllllIIIlIIIIIlllIIIlI.call();
            if (!Reflector.ForgeHooksClient_onDrawBlockHighlight.exists() || !Reflector.callBoolean(Reflector.ForgeHooksClient_onDrawBlockHighlight, lllllllllllllllIIIlIIIIIlllIllII, lllllllllllllllIIIlIIIIIlllIIIll, this.mc.objectMouseOver, 0, lllllllllllllllIIIlIIIIIlllIllll)) {
                lllllllllllllllIIIlIIIIIlllIllII.drawSelectionBox(lllllllllllllllIIIlIIIIIlllIIIll, this.mc.objectMouseOver, 0, lllllllllllllllIIIlIIIIIlllIllll);
            }
            GlStateManager.enableAlpha();
        }
        if (this.mc.debugRenderer.shouldRender()) {
            final boolean lllllllllllllllIIIlIIIIIlllIIIIl = GlStateManager.isFogEnabled();
            GlStateManager.disableFog();
            this.mc.debugRenderer.renderDebug(lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIlllIlllI);
            GlStateManager.setFogEnabled(lllllllllllllllIIIlIIIIIlllIIIIl);
        }
        if (!lllllllllllllllIIIlIIIIIlllIllII.damagedBlocks.isEmpty()) {
            this.mc.mcProfiler.endStartSection("destroyProgress");
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            this.mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).setBlurMipmap(false, false);
            lllllllllllllllIIIlIIIIIlllIllII.drawBlockDamageTexture(Tessellator.getInstance(), Tessellator.getInstance().getBuffer(), lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIllll);
            this.mc.getTextureManager().getTexture(TextureMap.LOCATION_BLOCKS_TEXTURE).restoreLastBlurMipmap();
            GlStateManager.disableBlend();
        }
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.disableBlend();
        if (!this.debugView) {
            this.enableLightmap();
            this.mc.mcProfiler.endStartSection("litParticles");
            if (lllllllllllllllIIIlIIIIIlllIllIl) {
                Shaders.beginLitParticles();
            }
            lllllllllllllllIIIlIIIIIlllIlIll.renderLitParticles(lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIllll);
            RenderHelper.disableStandardItemLighting();
            this.setupFog(0, lllllllllllllllIIIlIIIIIlllIllll);
            this.mc.mcProfiler.endStartSection("particles");
            if (lllllllllllllllIIIlIIIIIlllIllIl) {
                Shaders.beginParticles();
            }
            lllllllllllllllIIIlIIIIIlllIlIll.renderParticles(lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIllll);
            if (lllllllllllllllIIIlIIIIIlllIllIl) {
                Shaders.endParticles();
            }
            this.disableLightmap();
        }
        GlStateManager.depthMask(false);
        GlStateManager.enableCull();
        this.mc.mcProfiler.endStartSection("weather");
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.beginWeather();
        }
        this.renderRainSnow(lllllllllllllllIIIlIIIIIlllIllll);
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.endWeather();
        }
        GlStateManager.depthMask(true);
        lllllllllllllllIIIlIIIIIlllIllII.renderWorldBorder(lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIllll);
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            ShadersRender.renderHand0(this, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI);
            Shaders.preWater();
        }
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.alphaFunc(516, 0.1f);
        this.setupFog(0, lllllllllllllllIIIlIIIIIlllIllll);
        GlStateManager.enableBlend();
        GlStateManager.depthMask(false);
        this.mc.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        GlStateManager.shadeModel(7425);
        this.mc.mcProfiler.endStartSection("translucent");
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.beginWater();
        }
        lllllllllllllllIIIlIIIIIlllIllII.renderBlockLayer(BlockRenderLayer.TRANSLUCENT, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI, lllllllllllllllIIIlIIIIIlllIIlll);
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.endWater();
        }
        if (Reflector.ForgeHooksClient_setRenderPass.exists() && !this.debugView) {
            RenderHelper.enableStandardItemLighting();
            this.mc.mcProfiler.endStartSection("entities");
            Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, 1);
            this.mc.renderGlobal.renderEntities(lllllllllllllllIIIlIIIIIlllIIlll, lllllllllllllllIIIlIIIIIlllIlIII, lllllllllllllllIIIlIIIIIlllIllll);
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            Reflector.callVoid(Reflector.ForgeHooksClient_setRenderPass, -1);
            RenderHelper.disableStandardItemLighting();
        }
        GlStateManager.shadeModel(7424);
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.disableBlend();
        GlStateManager.disableFog();
        if (lllllllllllllllIIIlIIIIIlllIIlll.posY + lllllllllllllllIIIlIIIIIlllIIlll.getEyeHeight() >= 128.0 + this.mc.gameSettings.ofCloudsHeight * 128.0f) {
            this.mc.mcProfiler.endStartSection("aboveClouds");
            this.renderCloudsCheck(lllllllllllllllIIIlIIIIIlllIllII, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI, lllllllllllllllIIIlIIIIIlllIIllI, lllllllllllllllIIIlIIIIIlllIIlIl, lllllllllllllllIIIlIIIIIlllIIlII);
        }
        if (Reflector.ForgeHooksClient_dispatchRenderLast.exists()) {
            this.mc.mcProfiler.endStartSection("forge_render_last");
            Reflector.callVoid(Reflector.ForgeHooksClient_dispatchRenderLast, lllllllllllllllIIIlIIIIIlllIllII, lllllllllllllllIIIlIIIIIlllIllll);
        }
        final Event3D lllllllllllllllIIIlIIIIIlllIIIII = new Event3D(lllllllllllllllIIIlIIIIIlllIllll);
        lllllllllllllllIIIlIIIIIlllIIIII.call();
        this.mc.mcProfiler.endStartSection("hand");
        if (this.renderHand && !Shaders.isShadowPass) {
            if (lllllllllllllllIIIlIIIIIlllIllIl) {
                ShadersRender.renderHand1(this, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI);
                Shaders.renderCompositeFinal();
            }
            GlStateManager.clear(256);
            if (lllllllllllllllIIIlIIIIIlllIllIl) {
                ShadersRender.renderFPOverlay(this, lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI);
            }
            else {
                this.renderHand(lllllllllllllllIIIlIIIIIlllIllll, lllllllllllllllIIIlIIIIIllIllllI);
            }
        }
        if (lllllllllllllllIIIlIIIIIlllIllIl) {
            Shaders.endRender();
        }
    }
    
    private boolean isDrawBlockOutline() {
        if (!this.drawBlockOutline) {
            return false;
        }
        final Entity lllllllllllllllIIIlIIIIlIIIlIlll = this.mc.getRenderViewEntity();
        boolean lllllllllllllllIIIlIIIIlIIIlIllI = lllllllllllllllIIIlIIIIlIIIlIlll instanceof EntityPlayer && !this.mc.gameSettings.hideGUI;
        if (lllllllllllllllIIIlIIIIlIIIlIllI && !((EntityPlayer)lllllllllllllllIIIlIIIIlIIIlIlll).capabilities.allowEdit) {
            final ItemStack lllllllllllllllIIIlIIIIlIIIlIlIl = ((EntityPlayer)lllllllllllllllIIIlIIIIlIIIlIlll).getHeldItemMainhand();
            if (this.mc.objectMouseOver != null && this.mc.objectMouseOver.typeOfHit == RayTraceResult.Type.BLOCK) {
                final BlockPos lllllllllllllllIIIlIIIIlIIIlIlII = this.mc.objectMouseOver.getBlockPos();
                final IBlockState lllllllllllllllIIIlIIIIlIIIlIIll = this.mc.world.getBlockState(lllllllllllllllIIIlIIIIlIIIlIlII);
                final Block lllllllllllllllIIIlIIIIlIIIlIIlI = lllllllllllllllIIIlIIIIlIIIlIIll.getBlock();
                if (this.mc.playerController.getCurrentGameType() == GameType.SPECTATOR) {
                    lllllllllllllllIIIlIIIIlIIIlIllI = (ReflectorForge.blockHasTileEntity(lllllllllllllllIIIlIIIIlIIIlIIll) && this.mc.world.getTileEntity(lllllllllllllllIIIlIIIIlIIIlIlII) instanceof IInventory);
                }
                else {
                    lllllllllllllllIIIlIIIIlIIIlIllI = (!lllllllllllllllIIIlIIIIlIIIlIlIl.func_190926_b() && (lllllllllllllllIIIlIIIIlIIIlIlIl.canDestroy(lllllllllllllllIIIlIIIIlIIIlIIlI) || lllllllllllllllIIIlIIIIlIIIlIlIl.canPlaceOn(lllllllllllllllIIIlIIIIlIIIlIIlI)));
                }
            }
        }
        return lllllllllllllllIIIlIIIIlIIIlIllI;
    }
    
    private void renderCloudsCheck(final RenderGlobal lllllllllllllllIIIlIIIIIllIIIlll, final float lllllllllllllllIIIlIIIIIllIIIllI, final int lllllllllllllllIIIlIIIIIlIlllllI, final double lllllllllllllllIIIlIIIIIllIIIlII, final double lllllllllllllllIIIlIIIIIlIllllII, final double lllllllllllllllIIIlIIIIIllIIIIlI) {
        if (this.mc.gameSettings.renderDistanceChunks >= 4 && !Config.isCloudsOff() && Shaders.shouldRenderClouds(this.mc.gameSettings)) {
            this.mc.mcProfiler.endStartSection("clouds");
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(lllllllllllllllIIIlIIIIIllIIIllI, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance * 4.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.pushMatrix();
            this.setupFog(0, lllllllllllllllIIIlIIIIIllIIIllI);
            lllllllllllllllIIIlIIIIIllIIIlll.renderClouds(lllllllllllllllIIIlIIIIIllIIIllI, lllllllllllllllIIIlIIIIIlIlllllI, lllllllllllllllIIIlIIIIIllIIIlII, lllllllllllllllIIIlIIIIIlIllllII, lllllllllllllllIIIlIIIIIllIIIIlI);
            GlStateManager.disableFog();
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            Project.gluPerspective(this.getFOVModifier(lllllllllllllllIIIlIIIIIllIIIllI, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
            GlStateManager.matrixMode(5888);
        }
    }
    
    public static void drawNameplate(final FontRenderer lllllllllllllllIIIIllllIIlIIlIlI, final String lllllllllllllllIIIIllllIIlIIlIIl, final float lllllllllllllllIIIIllllIIlIIlIII, final float lllllllllllllllIIIIllllIIlIlIlII, final float lllllllllllllllIIIIllllIIlIlIIll, final int lllllllllllllllIIIIllllIIlIIIlIl, final float lllllllllllllllIIIIllllIIlIlIIIl, final float lllllllllllllllIIIIllllIIlIIIIll, final boolean lllllllllllllllIIIIllllIIlIIIIlI, final boolean lllllllllllllllIIIIllllIIlIIlllI) {
        GlStateManager.pushMatrix();
        GlStateManager.translate(lllllllllllllllIIIIllllIIlIIlIII, lllllllllllllllIIIIllllIIlIlIlII, lllllllllllllllIIIIllllIIlIlIIll);
        GlStateManager.glNormal3f(0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-lllllllllllllllIIIIllllIIlIlIIIl, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate((lllllllllllllllIIIIllllIIlIIIIlI ? -1 : 1) * lllllllllllllllIIIIllllIIlIIIIll, 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(-0.025f, -0.025f, 0.025f);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(false);
        if (!lllllllllllllllIIIIllllIIlIIlllI) {
            GlStateManager.disableDepth();
        }
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final int lllllllllllllllIIIIllllIIlIIllIl = lllllllllllllllIIIIllllIIlIIlIlI.getStringWidth(lllllllllllllllIIIIllllIIlIIlIIl) / 2;
        GlStateManager.disableTexture2D();
        final Tessellator lllllllllllllllIIIIllllIIlIIllII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIIIIllllIIlIIlIll = lllllllllllllllIIIIllllIIlIIllII.getBuffer();
        lllllllllllllllIIIIllllIIlIIlIll.begin(7, DefaultVertexFormats.POSITION_COLOR);
        lllllllllllllllIIIIllllIIlIIlIll.pos(-lllllllllllllllIIIIllllIIlIIllIl - 1, -1 + lllllllllllllllIIIIllllIIlIIIlIl, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        lllllllllllllllIIIIllllIIlIIlIll.pos(-lllllllllllllllIIIIllllIIlIIllIl - 1, 8 + lllllllllllllllIIIIllllIIlIIIlIl, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        lllllllllllllllIIIIllllIIlIIlIll.pos(lllllllllllllllIIIIllllIIlIIllIl + 1, 8 + lllllllllllllllIIIIllllIIlIIIlIl, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        lllllllllllllllIIIIllllIIlIIlIll.pos(lllllllllllllllIIIIllllIIlIIllIl + 1, -1 + lllllllllllllllIIIIllllIIlIIIlIl, 0.0).color(0.0f, 0.0f, 0.0f, 0.25f).endVertex();
        lllllllllllllllIIIIllllIIlIIllII.draw();
        GlStateManager.enableTexture2D();
        if (!lllllllllllllllIIIIllllIIlIIlllI) {
            lllllllllllllllIIIIllllIIlIIlIlI.drawString(lllllllllllllllIIIIllllIIlIIlIIl, -lllllllllllllllIIIIllllIIlIIlIlI.getStringWidth(lllllllllllllllIIIIllllIIlIIlIIl) / 2, lllllllllllllllIIIIllllIIlIIIlIl, 553648127);
            GlStateManager.enableDepth();
        }
        GlStateManager.depthMask(true);
        lllllllllllllllIIIIllllIIlIIlIlI.drawString(lllllllllllllllIIIIllllIIlIIlIIl, -lllllllllllllllIIIIllllIIlIIlIlI.getStringWidth(lllllllllllllllIIIIllllIIlIIlIIl) / 2, lllllllllllllllIIIIllllIIlIIIlIl, lllllllllllllllIIIIllllIIlIIlllI ? 553648127 : -1);
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.popMatrix();
    }
    
    private void renderHand(final float lllllllllllllllIIIlIIIIllllIllII, final int lllllllllllllllIIIlIIIIllllIlIII) {
        this.renderHand(lllllllllllllllIIIlIIIIllllIllII, lllllllllllllllIIIlIIIIllllIlIII, true, true, false);
    }
    
    public void orientCamera(final float lllllllllllllllIIIlIIIlIIIllllll) {
        final Entity lllllllllllllllIIIlIIIlIIIlllllI = this.mc.getRenderViewEntity();
        float lllllllllllllllIIIlIIIlIIIllllIl = lllllllllllllllIIIlIIIlIIIlllllI.getEyeHeight();
        double lllllllllllllllIIIlIIIlIIIllllII = lllllllllllllllIIIlIIIlIIIlllllI.prevPosX + (lllllllllllllllIIIlIIIlIIIlllllI.posX - lllllllllllllllIIIlIIIlIIIlllllI.prevPosX) * lllllllllllllllIIIlIIIlIIIllllll;
        double lllllllllllllllIIIlIIIlIIIlllIll = lllllllllllllllIIIlIIIlIIIlllllI.prevPosY + (lllllllllllllllIIIlIIIlIIIlllllI.posY - lllllllllllllllIIIlIIIlIIIlllllI.prevPosY) * lllllllllllllllIIIlIIIlIIIllllll + lllllllllllllllIIIlIIIlIIIllllIl;
        double lllllllllllllllIIIlIIIlIIIlllIlI = lllllllllllllllIIIlIIIlIIIlllllI.prevPosZ + (lllllllllllllllIIIlIIIlIIIlllllI.posZ - lllllllllllllllIIIlIIIlIIIlllllI.prevPosZ) * lllllllllllllllIIIlIIIlIIIllllll;
        if (lllllllllllllllIIIlIIIlIIIlllllI instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllIIIlIIIlIIIlllllI).isPlayerSleeping()) {
            ++lllllllllllllllIIIlIIIlIIIllllIl;
            GlStateManager.translate(0.0f, 0.3f, 0.0f);
            if (!this.mc.gameSettings.debugCamEnable) {
                final BlockPos lllllllllllllllIIIlIIIlIIIlllIIl = new BlockPos(lllllllllllllllIIIlIIIlIIIlllllI);
                final IBlockState lllllllllllllllIIIlIIIlIIIlllIII = this.mc.world.getBlockState(lllllllllllllllIIIlIIIlIIIlllIIl);
                final Block lllllllllllllllIIIlIIIlIIIllIlll = lllllllllllllllIIIlIIIlIIIlllIII.getBlock();
                if (Reflector.ForgeHooksClient_orientBedCamera.exists()) {
                    Reflector.callVoid(Reflector.ForgeHooksClient_orientBedCamera, this.mc.world, lllllllllllllllIIIlIIIlIIIlllIIl, lllllllllllllllIIIlIIIlIIIlllIII, lllllllllllllllIIIlIIIlIIIlllllI);
                }
                else if (lllllllllllllllIIIlIIIlIIIllIlll == Blocks.BED) {
                    final int lllllllllllllllIIIlIIIlIIIllIllI = lllllllllllllllIIIlIIIlIIIlllIII.getValue((IProperty<EnumFacing>)BlockBed.FACING).getHorizontalIndex();
                    GlStateManager.rotate((float)(lllllllllllllllIIIlIIIlIIIllIllI * 90), 0.0f, 1.0f, 0.0f);
                }
                GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlllllI.prevRotationYaw + (lllllllllllllllIIIlIIIlIIIlllllI.rotationYaw - lllllllllllllllIIIlIIIlIIIlllllI.prevRotationYaw) * lllllllllllllllIIIlIIIlIIIllllll + 180.0f, 0.0f, -1.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlllllI.prevRotationPitch + (lllllllllllllllIIIlIIIlIIIlllllI.rotationPitch - lllllllllllllllIIIlIIIlIIIlllllI.prevRotationPitch) * lllllllllllllllIIIlIIIlIIIllllll, -1.0f, 0.0f, 0.0f);
            }
        }
        else if (this.mc.gameSettings.thirdPersonView > 0) {
            double lllllllllllllllIIIlIIIlIIIllIlIl = this.thirdPersonDistancePrev + (4.0f - this.thirdPersonDistancePrev) + CameraClip.cameraFov.getValFloat();
            if (this.mc.gameSettings.debugCamEnable) {
                GlStateManager.translate(0.0f, 0.0f, (float)(-lllllllllllllllIIIlIIIlIIIllIlIl));
            }
            else {
                final float lllllllllllllllIIIlIIIlIIIllIlII = lllllllllllllllIIIlIIIlIIIlllllI.rotationYaw;
                float lllllllllllllllIIIlIIIlIIIllIIlI = lllllllllllllllIIIlIIIlIIIlllllI.rotationPitch;
                if (this.mc.gameSettings.thirdPersonView == 2) {
                    lllllllllllllllIIIlIIIlIIIllIIlI += 180.0f;
                }
                final double lllllllllllllllIIIlIIIlIIIllIIIl = -MathHelper.sin(lllllllllllllllIIIlIIIlIIIllIlII * 0.017453292f) * MathHelper.cos(lllllllllllllllIIIlIIIlIIIllIIlI * 0.017453292f) * lllllllllllllllIIIlIIIlIIIllIlIl;
                final double lllllllllllllllIIIlIIIlIIIlIllll = MathHelper.cos(lllllllllllllllIIIlIIIlIIIllIlII * 0.017453292f) * MathHelper.cos(lllllllllllllllIIIlIIIlIIIllIIlI * 0.017453292f) * lllllllllllllllIIIlIIIlIIIllIlIl;
                final double lllllllllllllllIIIlIIIlIIIlIllIl = -MathHelper.sin(lllllllllllllllIIIlIIIlIIIllIIlI * 0.017453292f) * lllllllllllllllIIIlIIIlIIIllIlIl;
                for (int lllllllllllllllIIIlIIIlIIIlIllII = 0; lllllllllllllllIIIlIIIlIIIlIllII < 8; ++lllllllllllllllIIIlIIIlIIIlIllII) {
                    float lllllllllllllllIIIlIIIlIIIlIlIll = (float)((lllllllllllllllIIIlIIIlIIIlIllII & 0x1) * 2 - 1);
                    float lllllllllllllllIIIlIIIlIIIlIlIIl = (float)((lllllllllllllllIIIlIIIlIIIlIllII >> 1 & 0x1) * 2 - 1);
                    float lllllllllllllllIIIlIIIlIIIlIIlll = (float)((lllllllllllllllIIIlIIIlIIIlIllII >> 2 & 0x1) * 2 - 1);
                    lllllllllllllllIIIlIIIlIIIlIlIll *= 0.1f;
                    lllllllllllllllIIIlIIIlIIIlIlIIl *= 0.1f;
                    lllllllllllllllIIIlIIIlIIIlIIlll *= 0.1f;
                    final RayTraceResult lllllllllllllllIIIlIIIlIIIlIIlIl = this.mc.world.rayTraceBlocks(new Vec3d(lllllllllllllllIIIlIIIlIIIllllII + lllllllllllllllIIIlIIIlIIIlIlIll, lllllllllllllllIIIlIIIlIIIlllIll + lllllllllllllllIIIlIIIlIIIlIlIIl, lllllllllllllllIIIlIIIlIIIlllIlI + lllllllllllllllIIIlIIIlIIIlIIlll), new Vec3d(lllllllllllllllIIIlIIIlIIIllllII - lllllllllllllllIIIlIIIlIIIllIIIl + lllllllllllllllIIIlIIIlIIIlIlIll + lllllllllllllllIIIlIIIlIIIlIIlll, lllllllllllllllIIIlIIIlIIIlllIll - lllllllllllllllIIIlIIIlIIIlIllIl + lllllllllllllllIIIlIIIlIIIlIlIIl, lllllllllllllllIIIlIIIlIIIlllIlI - lllllllllllllllIIIlIIIlIIIlIllll + lllllllllllllllIIIlIIIlIIIlIIlll));
                    if (lllllllllllllllIIIlIIIlIIIlIIlIl != null) {
                        final double lllllllllllllllIIIlIIIlIIIlIIlII = lllllllllllllllIIIlIIIlIIIlIIlIl.hitVec.distanceTo(new Vec3d(lllllllllllllllIIIlIIIlIIIllllII, lllllllllllllllIIIlIIIlIIIlllIll, lllllllllllllllIIIlIIIlIIIlllIlI));
                        if (!Main.moduleManager.getModuleByName("CameraClip").isToggled() && lllllllllllllllIIIlIIIlIIIlIIlII < lllllllllllllllIIIlIIIlIIIllIlIl) {
                            lllllllllllllllIIIlIIIlIIIllIlIl = lllllllllllllllIIIlIIIlIIIlIIlII;
                        }
                    }
                }
                if (this.mc.gameSettings.thirdPersonView == 2) {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                }
                if (CameraClip.fortnite.getValBoolean() && Main.moduleManager.getModuleByName("CameraClip").isToggled()) {
                    GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlllllI.rotationPitch - lllllllllllllllIIIlIIIlIIIllIIlI, 1.0f, 0.0f, 0.0f);
                    GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlllllI.rotationYaw - lllllllllllllllIIIlIIIlIIIllIlII, 0.0f, 1.0f, 0.0f);
                    GlStateManager.translate(-1.0f, 0.0f, (float)(-lllllllllllllllIIIlIIIlIIIllIlIl) + 2.0f);
                    GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIllIlII - lllllllllllllllIIIlIIIlIIIlllllI.rotationYaw, 0.0f, 1.0f, 0.0f);
                    GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIllIIlI - lllllllllllllllIIIlIIIlIIIlllllI.rotationPitch, 1.0f, 0.0f, 0.0f);
                }
                else {
                    GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlllllI.rotationPitch - lllllllllllllllIIIlIIIlIIIllIIlI, 1.0f, 0.0f, 0.0f);
                    GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlllllI.rotationYaw - lllllllllllllllIIIlIIIlIIIllIlII, 0.0f, 1.0f, 0.0f);
                    GlStateManager.translate(0.0f, 0.0f, (float)(-lllllllllllllllIIIlIIIlIIIllIlIl));
                    GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIllIlII - lllllllllllllllIIIlIIIlIIIlllllI.rotationYaw, 0.0f, 1.0f, 0.0f);
                    GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIllIIlI - lllllllllllllllIIIlIIIlIIIlllllI.rotationPitch, 1.0f, 0.0f, 0.0f);
                }
            }
        }
        else {
            GlStateManager.translate(0.0f, 0.0f, 0.05f);
        }
        if (Reflector.EntityViewRenderEvent_CameraSetup_Constructor.exists()) {
            if (!this.mc.gameSettings.debugCamEnable) {
                float lllllllllllllllIIIlIIIlIIIlIIIll = lllllllllllllllIIIlIIIlIIIlllllI.prevRotationYaw + (lllllllllllllllIIIlIIIlIIIlllllI.rotationYaw - lllllllllllllllIIIlIIIlIIIlllllI.prevRotationYaw) * lllllllllllllllIIIlIIIlIIIllllll + 180.0f;
                float lllllllllllllllIIIlIIIlIIIlIIIIl = lllllllllllllllIIIlIIIlIIIlllllI.prevRotationPitch + (lllllllllllllllIIIlIIIlIIIlllllI.rotationPitch - lllllllllllllllIIIlIIIlIIIlllllI.prevRotationPitch) * lllllllllllllllIIIlIIIlIIIllllll;
                float lllllllllllllllIIIlIIIlIIIIlllll = 0.0f;
                if (lllllllllllllllIIIlIIIlIIIlllllI instanceof EntityAnimal) {
                    final EntityAnimal lllllllllllllllIIIlIIIlIIIIlllIl = (EntityAnimal)lllllllllllllllIIIlIIIlIIIlllllI;
                    lllllllllllllllIIIlIIIlIIIlIIIll = lllllllllllllllIIIlIIIlIIIIlllIl.prevRotationYawHead + (lllllllllllllllIIIlIIIlIIIIlllIl.rotationYawHead - lllllllllllllllIIIlIIIlIIIIlllIl.prevRotationYawHead) * lllllllllllllllIIIlIIIlIIIllllll + 180.0f;
                }
                final IBlockState lllllllllllllllIIIlIIIlIIIIlllII = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.world, lllllllllllllllIIIlIIIlIIIlllllI, lllllllllllllllIIIlIIIlIIIllllll);
                final Object lllllllllllllllIIIlIIIlIIIIllIll = Reflector.newInstance(Reflector.EntityViewRenderEvent_CameraSetup_Constructor, this, lllllllllllllllIIIlIIIlIIIlllllI, lllllllllllllllIIIlIIIlIIIIlllII, lllllllllllllllIIIlIIIlIIIllllll, lllllllllllllllIIIlIIIlIIIlIIIll, lllllllllllllllIIIlIIIlIIIlIIIIl, lllllllllllllllIIIlIIIlIIIIlllll);
                Reflector.postForgeBusEvent(lllllllllllllllIIIlIIIlIIIIllIll);
                lllllllllllllllIIIlIIIlIIIIlllll = Reflector.callFloat(lllllllllllllllIIIlIIIlIIIIllIll, Reflector.EntityViewRenderEvent_CameraSetup_getRoll, new Object[0]);
                lllllllllllllllIIIlIIIlIIIlIIIIl = Reflector.callFloat(lllllllllllllllIIIlIIIlIIIIllIll, Reflector.EntityViewRenderEvent_CameraSetup_getPitch, new Object[0]);
                lllllllllllllllIIIlIIIlIIIlIIIll = Reflector.callFloat(lllllllllllllllIIIlIIIlIIIIllIll, Reflector.EntityViewRenderEvent_CameraSetup_getYaw, new Object[0]);
                GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIIlllll, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlIIIIl, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlIIIll, 0.0f, 1.0f, 0.0f);
            }
        }
        else if (!this.mc.gameSettings.debugCamEnable) {
            GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlllllI.prevRotationPitch + (lllllllllllllllIIIlIIIlIIIlllllI.rotationPitch - lllllllllllllllIIIlIIIlIIIlllllI.prevRotationPitch) * lllllllllllllllIIIlIIIlIIIllllll, 1.0f, 0.0f, 0.0f);
            if (lllllllllllllllIIIlIIIlIIIlllllI instanceof EntityAnimal) {
                final EntityAnimal lllllllllllllllIIIlIIIlIIIIllIlI = (EntityAnimal)lllllllllllllllIIIlIIIlIIIlllllI;
                GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIIllIlI.prevRotationYawHead + (lllllllllllllllIIIlIIIlIIIIllIlI.rotationYawHead - lllllllllllllllIIIlIIIlIIIIllIlI.prevRotationYawHead) * lllllllllllllllIIIlIIIlIIIllllll + 180.0f, 0.0f, 1.0f, 0.0f);
            }
            else {
                GlStateManager.rotate(lllllllllllllllIIIlIIIlIIIlllllI.prevRotationYaw + (lllllllllllllllIIIlIIIlIIIlllllI.rotationYaw - lllllllllllllllIIIlIIIlIIIlllllI.prevRotationYaw) * lllllllllllllllIIIlIIIlIIIllllll + 180.0f, 0.0f, 1.0f, 0.0f);
            }
        }
        GlStateManager.translate(0.0f, -lllllllllllllllIIIlIIIlIIIllllIl, 0.0f);
        lllllllllllllllIIIlIIIlIIIllllII = lllllllllllllllIIIlIIIlIIIlllllI.prevPosX + (lllllllllllllllIIIlIIIlIIIlllllI.posX - lllllllllllllllIIIlIIIlIIIlllllI.prevPosX) * lllllllllllllllIIIlIIIlIIIllllll;
        lllllllllllllllIIIlIIIlIIIlllIll = lllllllllllllllIIIlIIIlIIIlllllI.prevPosY + (lllllllllllllllIIIlIIIlIIIlllllI.posY - lllllllllllllllIIIlIIIlIIIlllllI.prevPosY) * lllllllllllllllIIIlIIIlIIIllllll + lllllllllllllllIIIlIIIlIIIllllIl;
        lllllllllllllllIIIlIIIlIIIlllIlI = lllllllllllllllIIIlIIIlIIIlllllI.prevPosZ + (lllllllllllllllIIIlIIIlIIIlllllI.posZ - lllllllllllllllIIIlIIIlIIIlllllI.prevPosZ) * lllllllllllllllIIIlIIIlIIIllllll;
        this.cloudFog = this.mc.renderGlobal.hasCloudFog(lllllllllllllllIIIlIIIlIIIllllII, lllllllllllllllIIIlIIIlIIIlllIll, lllllllllllllllIIIlIIIlIIIlllIlI, lllllllllllllllIIIlIIIlIIIllllll);
    }
    
    private void updateLightmap(final float lllllllllllllllIIIlIIIIllIIIllll) {
        if (this.lightmapUpdateNeeded) {
            this.mc.mcProfiler.startSection("lightTex");
            final World lllllllllllllllIIIlIIIIllIlIlIIl = this.mc.world;
            if (lllllllllllllllIIIlIIIIllIlIlIIl != null) {
                if (Config.isCustomColors() && CustomColors.updateLightmap(lllllllllllllllIIIlIIIIllIlIlIIl, this.torchFlickerX, this.lightmapColors, this.mc.player.isPotionActive(MobEffects.NIGHT_VISION))) {
                    this.lightmapTexture.updateDynamicTexture();
                    this.lightmapUpdateNeeded = false;
                    this.mc.mcProfiler.endSection();
                    return;
                }
                final float lllllllllllllllIIIlIIIIllIlIlIII = lllllllllllllllIIIlIIIIllIlIlIIl.getSunBrightness(1.0f);
                final float lllllllllllllllIIIlIIIIllIlIIlll = lllllllllllllllIIIlIIIIllIlIlIII * 0.95f + 0.05f;
                for (int lllllllllllllllIIIlIIIIllIlIIllI = 0; lllllllllllllllIIIlIIIIllIlIIllI < 256; ++lllllllllllllllIIIlIIIIllIlIIllI) {
                    float lllllllllllllllIIIlIIIIllIlIIlIl = lllllllllllllllIIIlIIIIllIlIlIIl.provider.getLightBrightnessTable()[lllllllllllllllIIIlIIIIllIlIIllI / 16] * lllllllllllllllIIIlIIIIllIlIIlll;
                    final float lllllllllllllllIIIlIIIIllIlIIlII = lllllllllllllllIIIlIIIIllIlIlIIl.provider.getLightBrightnessTable()[lllllllllllllllIIIlIIIIllIlIIllI % 16] * (this.torchFlickerX * 0.1f + 1.5f);
                    if (lllllllllllllllIIIlIIIIllIlIlIIl.getLastLightningBolt() > 0) {
                        lllllllllllllllIIIlIIIIllIlIIlIl = lllllllllllllllIIIlIIIIllIlIlIIl.provider.getLightBrightnessTable()[lllllllllllllllIIIlIIIIllIlIIllI / 16];
                    }
                    final float lllllllllllllllIIIlIIIIllIlIIIll = lllllllllllllllIIIlIIIIllIlIIlIl * (lllllllllllllllIIIlIIIIllIlIlIII * 0.65f + 0.35f);
                    final float lllllllllllllllIIIlIIIIllIlIIIlI = lllllllllllllllIIIlIIIIllIlIIlIl * (lllllllllllllllIIIlIIIIllIlIlIII * 0.65f + 0.35f);
                    final float lllllllllllllllIIIlIIIIllIlIIIIl = lllllllllllllllIIIlIIIIllIlIIlII * ((lllllllllllllllIIIlIIIIllIlIIlII * 0.6f + 0.4f) * 0.6f + 0.4f);
                    final float lllllllllllllllIIIlIIIIllIlIIIII = lllllllllllllllIIIlIIIIllIlIIlII * (lllllllllllllllIIIlIIIIllIlIIlII * lllllllllllllllIIIlIIIIllIlIIlII * 0.6f + 0.4f);
                    float lllllllllllllllIIIlIIIIllIIlllll = lllllllllllllllIIIlIIIIllIlIIIll + lllllllllllllllIIIlIIIIllIlIIlII;
                    float lllllllllllllllIIIlIIIIllIIllllI = lllllllllllllllIIIlIIIIllIlIIIlI + lllllllllllllllIIIlIIIIllIlIIIIl;
                    float lllllllllllllllIIIlIIIIllIIlllIl = lllllllllllllllIIIlIIIIllIlIIlIl + lllllllllllllllIIIlIIIIllIlIIIII;
                    lllllllllllllllIIIlIIIIllIIlllll = lllllllllllllllIIIlIIIIllIIlllll * 0.96f + 0.03f;
                    lllllllllllllllIIIlIIIIllIIllllI = lllllllllllllllIIIlIIIIllIIllllI * 0.96f + 0.03f;
                    lllllllllllllllIIIlIIIIllIIlllIl = lllllllllllllllIIIlIIIIllIIlllIl * 0.96f + 0.03f;
                    if (this.bossColorModifier > 0.0f) {
                        final float lllllllllllllllIIIlIIIIllIIlllII = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * lllllllllllllllIIIlIIIIllIIIllll;
                        lllllllllllllllIIIlIIIIllIIlllll = lllllllllllllllIIIlIIIIllIIlllll * (1.0f - lllllllllllllllIIIlIIIIllIIlllII) + lllllllllllllllIIIlIIIIllIIlllll * 0.7f * lllllllllllllllIIIlIIIIllIIlllII;
                        lllllllllllllllIIIlIIIIllIIllllI = lllllllllllllllIIIlIIIIllIIllllI * (1.0f - lllllllllllllllIIIlIIIIllIIlllII) + lllllllllllllllIIIlIIIIllIIllllI * 0.6f * lllllllllllllllIIIlIIIIllIIlllII;
                        lllllllllllllllIIIlIIIIllIIlllIl = lllllllllllllllIIIlIIIIllIIlllIl * (1.0f - lllllllllllllllIIIlIIIIllIIlllII) + lllllllllllllllIIIlIIIIllIIlllIl * 0.6f * lllllllllllllllIIIlIIIIllIIlllII;
                    }
                    if (lllllllllllllllIIIlIIIIllIlIlIIl.provider.getDimensionType().getId() == 1) {
                        lllllllllllllllIIIlIIIIllIIlllll = 0.22f + lllllllllllllllIIIlIIIIllIlIIlII * 0.75f;
                        lllllllllllllllIIIlIIIIllIIllllI = 0.28f + lllllllllllllllIIIlIIIIllIlIIIIl * 0.75f;
                        lllllllllllllllIIIlIIIIllIIlllIl = 0.25f + lllllllllllllllIIIlIIIIllIlIIIII * 0.75f;
                    }
                    if (Reflector.ForgeWorldProvider_getLightmapColors.exists()) {
                        final float[] lllllllllllllllIIIlIIIIllIIllIll = { lllllllllllllllIIIlIIIIllIIlllll, lllllllllllllllIIIlIIIIllIIllllI, lllllllllllllllIIIlIIIIllIIlllIl };
                        Reflector.call(lllllllllllllllIIIlIIIIllIlIlIIl.provider, Reflector.ForgeWorldProvider_getLightmapColors, lllllllllllllllIIIlIIIIllIIIllll, lllllllllllllllIIIlIIIIllIlIlIII, lllllllllllllllIIIlIIIIllIlIIlIl, lllllllllllllllIIIlIIIIllIlIIlII, lllllllllllllllIIIlIIIIllIIllIll);
                        lllllllllllllllIIIlIIIIllIIlllll = lllllllllllllllIIIlIIIIllIIllIll[0];
                        lllllllllllllllIIIlIIIIllIIllllI = lllllllllllllllIIIlIIIIllIIllIll[1];
                        lllllllllllllllIIIlIIIIllIIlllIl = lllllllllllllllIIIlIIIIllIIllIll[2];
                    }
                    lllllllllllllllIIIlIIIIllIIlllll = MathHelper.clamp(lllllllllllllllIIIlIIIIllIIlllll, 0.0f, 1.0f);
                    lllllllllllllllIIIlIIIIllIIllllI = MathHelper.clamp(lllllllllllllllIIIlIIIIllIIllllI, 0.0f, 1.0f);
                    lllllllllllllllIIIlIIIIllIIlllIl = MathHelper.clamp(lllllllllllllllIIIlIIIIllIIlllIl, 0.0f, 1.0f);
                    if (this.mc.player.isPotionActive(MobEffects.NIGHT_VISION)) {
                        final float lllllllllllllllIIIlIIIIllIIllIlI = this.getNightVisionBrightness(this.mc.player, lllllllllllllllIIIlIIIIllIIIllll);
                        float lllllllllllllllIIIlIIIIllIIllIIl = 1.0f / lllllllllllllllIIIlIIIIllIIlllll;
                        if (lllllllllllllllIIIlIIIIllIIllIIl > 1.0f / lllllllllllllllIIIlIIIIllIIllllI) {
                            lllllllllllllllIIIlIIIIllIIllIIl = 1.0f / lllllllllllllllIIIlIIIIllIIllllI;
                        }
                        if (lllllllllllllllIIIlIIIIllIIllIIl > 1.0f / lllllllllllllllIIIlIIIIllIIlllIl) {
                            lllllllllllllllIIIlIIIIllIIllIIl = 1.0f / lllllllllllllllIIIlIIIIllIIlllIl;
                        }
                        lllllllllllllllIIIlIIIIllIIlllll = lllllllllllllllIIIlIIIIllIIlllll * (1.0f - lllllllllllllllIIIlIIIIllIIllIlI) + lllllllllllllllIIIlIIIIllIIlllll * lllllllllllllllIIIlIIIIllIIllIIl * lllllllllllllllIIIlIIIIllIIllIlI;
                        lllllllllllllllIIIlIIIIllIIllllI = lllllllllllllllIIIlIIIIllIIllllI * (1.0f - lllllllllllllllIIIlIIIIllIIllIlI) + lllllllllllllllIIIlIIIIllIIllllI * lllllllllllllllIIIlIIIIllIIllIIl * lllllllllllllllIIIlIIIIllIIllIlI;
                        lllllllllllllllIIIlIIIIllIIlllIl = lllllllllllllllIIIlIIIIllIIlllIl * (1.0f - lllllllllllllllIIIlIIIIllIIllIlI) + lllllllllllllllIIIlIIIIllIIlllIl * lllllllllllllllIIIlIIIIllIIllIIl * lllllllllllllllIIIlIIIIllIIllIlI;
                    }
                    if (lllllllllllllllIIIlIIIIllIIlllll > 1.0f) {
                        lllllllllllllllIIIlIIIIllIIlllll = 1.0f;
                    }
                    if (lllllllllllllllIIIlIIIIllIIllllI > 1.0f) {
                        lllllllllllllllIIIlIIIIllIIllllI = 1.0f;
                    }
                    if (lllllllllllllllIIIlIIIIllIIlllIl > 1.0f) {
                        lllllllllllllllIIIlIIIIllIIlllIl = 1.0f;
                    }
                    final float lllllllllllllllIIIlIIIIllIIllIII = this.mc.gameSettings.gammaSetting;
                    float lllllllllllllllIIIlIIIIllIIlIlll = 1.0f - lllllllllllllllIIIlIIIIllIIlllll;
                    float lllllllllllllllIIIlIIIIllIIlIllI = 1.0f - lllllllllllllllIIIlIIIIllIIllllI;
                    float lllllllllllllllIIIlIIIIllIIlIlIl = 1.0f - lllllllllllllllIIIlIIIIllIIlllIl;
                    lllllllllllllllIIIlIIIIllIIlIlll = 1.0f - lllllllllllllllIIIlIIIIllIIlIlll * lllllllllllllllIIIlIIIIllIIlIlll * lllllllllllllllIIIlIIIIllIIlIlll * lllllllllllllllIIIlIIIIllIIlIlll;
                    lllllllllllllllIIIlIIIIllIIlIllI = 1.0f - lllllllllllllllIIIlIIIIllIIlIllI * lllllllllllllllIIIlIIIIllIIlIllI * lllllllllllllllIIIlIIIIllIIlIllI * lllllllllllllllIIIlIIIIllIIlIllI;
                    lllllllllllllllIIIlIIIIllIIlIlIl = 1.0f - lllllllllllllllIIIlIIIIllIIlIlIl * lllllllllllllllIIIlIIIIllIIlIlIl * lllllllllllllllIIIlIIIIllIIlIlIl * lllllllllllllllIIIlIIIIllIIlIlIl;
                    lllllllllllllllIIIlIIIIllIIlllll = lllllllllllllllIIIlIIIIllIIlllll * (1.0f - lllllllllllllllIIIlIIIIllIIllIII) + lllllllllllllllIIIlIIIIllIIlIlll * lllllllllllllllIIIlIIIIllIIllIII;
                    lllllllllllllllIIIlIIIIllIIllllI = lllllllllllllllIIIlIIIIllIIllllI * (1.0f - lllllllllllllllIIIlIIIIllIIllIII) + lllllllllllllllIIIlIIIIllIIlIllI * lllllllllllllllIIIlIIIIllIIllIII;
                    lllllllllllllllIIIlIIIIllIIlllIl = lllllllllllllllIIIlIIIIllIIlllIl * (1.0f - lllllllllllllllIIIlIIIIllIIllIII) + lllllllllllllllIIIlIIIIllIIlIlIl * lllllllllllllllIIIlIIIIllIIllIII;
                    lllllllllllllllIIIlIIIIllIIlllll = lllllllllllllllIIIlIIIIllIIlllll * 0.96f + 0.03f;
                    lllllllllllllllIIIlIIIIllIIllllI = lllllllllllllllIIIlIIIIllIIllllI * 0.96f + 0.03f;
                    lllllllllllllllIIIlIIIIllIIlllIl = lllllllllllllllIIIlIIIIllIIlllIl * 0.96f + 0.03f;
                    if (lllllllllllllllIIIlIIIIllIIlllll > 1.0f) {
                        lllllllllllllllIIIlIIIIllIIlllll = 1.0f;
                    }
                    if (lllllllllllllllIIIlIIIIllIIllllI > 1.0f) {
                        lllllllllllllllIIIlIIIIllIIllllI = 1.0f;
                    }
                    if (lllllllllllllllIIIlIIIIllIIlllIl > 1.0f) {
                        lllllllllllllllIIIlIIIIllIIlllIl = 1.0f;
                    }
                    if (lllllllllllllllIIIlIIIIllIIlllll < 0.0f) {
                        lllllllllllllllIIIlIIIIllIIlllll = 0.0f;
                    }
                    if (lllllllllllllllIIIlIIIIllIIllllI < 0.0f) {
                        lllllllllllllllIIIlIIIIllIIllllI = 0.0f;
                    }
                    if (lllllllllllllllIIIlIIIIllIIlllIl < 0.0f) {
                        lllllllllllllllIIIlIIIIllIIlllIl = 0.0f;
                    }
                    final int lllllllllllllllIIIlIIIIllIIlIlII = 255;
                    final int lllllllllllllllIIIlIIIIllIIlIIll = (int)(lllllllllllllllIIIlIIIIllIIlllll * 255.0f);
                    final int lllllllllllllllIIIlIIIIllIIlIIlI = (int)(lllllllllllllllIIIlIIIIllIIllllI * 255.0f);
                    final int lllllllllllllllIIIlIIIIllIIlIIIl = (int)(lllllllllllllllIIIlIIIIllIIlllIl * 255.0f);
                    this.lightmapColors[lllllllllllllllIIIlIIIIllIlIIllI] = (0xFF000000 | lllllllllllllllIIIlIIIIllIIlIIll << 16 | lllllllllllllllIIIlIIIIllIIlIIlI << 8 | lllllllllllllllIIIlIIIIllIIlIIIl);
                }
                this.lightmapTexture.updateDynamicTexture();
                this.lightmapUpdateNeeded = false;
                this.mc.mcProfiler.endSection();
            }
        }
    }
    
    private void frameInit() {
        if (!this.initialized) {
            TextureUtils.registerResourceListener();
            if (Config.getBitsOs() == 64 && Config.getBitsJre() == 32) {
                Config.setNotify64BitJava(true);
            }
            this.initialized = true;
        }
        Config.checkDisplayMode();
        final World lllllllllllllllIIIIlllllIlIlllll = this.mc.world;
        if (lllllllllllllllIIIIlllllIlIlllll != null) {
            if (Config.getNewRelease() != null) {
                final String lllllllllllllllIIIIlllllIlIllllI = "HD_U".replace("HD_U", "HD Ultra").replace("L", "Light");
                final String lllllllllllllllIIIIlllllIlIlllIl = String.valueOf(new StringBuilder(String.valueOf(lllllllllllllllIIIIlllllIlIllllI)).append(" ").append(Config.getNewRelease()));
                final TextComponentString lllllllllllllllIIIIlllllIlIlllII = new TextComponentString(I18n.format("of.message.newVersion", lllllllllllllllIIIIlllllIlIlllIl));
                Config.setNewRelease(null);
            }
            if (Config.isNotify64BitJava()) {
                Config.setNotify64BitJava(false);
                final TextComponentString lllllllllllllllIIIIlllllIlIllIll = new TextComponentString(I18n.format("of.message.java64Bit", new Object[0]));
                this.mc.ingameGUI.getChatGUI().printChatMessage(lllllllllllllllIIIIlllllIlIllIll);
            }
        }
        if (this.mc.currentScreen instanceof GuiMainMenu) {
            this.updateMainMenu((GuiMainMenu)this.mc.currentScreen);
        }
        if (this.updatedWorld != lllllllllllllllIIIIlllllIlIlllll) {
            RandomMobs.worldChanged(this.updatedWorld, lllllllllllllllIIIIlllllIlIlllll);
            Config.updateThreadPriorities();
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
            this.updatedWorld = lllllllllllllllIIIIlllllIlIlllll;
        }
        if (!this.setFxaaShader(Shaders.configAntialiasingLevel)) {
            Shaders.configAntialiasingLevel = 0;
        }
    }
    
    public void renderStreamIndicator(final float lllllllllllllllIIIlIIIIlIIlIIIIl) {
        this.setupOverlayRendering();
    }
    
    private void waitForServerThread() {
        this.serverWaitTimeCurrent = 0;
        if (Config.isSmoothWorld() && Config.isSingleProcessor()) {
            if (this.mc.isIntegratedServerRunning()) {
                final IntegratedServer lllllllllllllllIIIIlllllIlllIIlI = this.mc.getIntegratedServer();
                if (lllllllllllllllIIIIlllllIlllIIlI != null) {
                    final boolean lllllllllllllllIIIIlllllIlllIIIl = this.mc.isGamePaused();
                    if (!lllllllllllllllIIIIlllllIlllIIIl && !(this.mc.currentScreen instanceof GuiDownloadTerrain)) {
                        if (this.serverWaitTime > 0) {
                            Lagometer.timerServer.start();
                            Config.sleep(this.serverWaitTime);
                            Lagometer.timerServer.end();
                            this.serverWaitTimeCurrent = this.serverWaitTime;
                        }
                        final long lllllllllllllllIIIIlllllIlllIIII = System.nanoTime() / 1000000L;
                        if (this.lastServerTime != 0L && this.lastServerTicks != 0) {
                            long lllllllllllllllIIIIlllllIllIllll = lllllllllllllllIIIIlllllIlllIIII - this.lastServerTime;
                            if (lllllllllllllllIIIIlllllIllIllll < 0L) {
                                this.lastServerTime = lllllllllllllllIIIIlllllIlllIIII;
                                lllllllllllllllIIIIlllllIllIllll = 0L;
                            }
                            if (lllllllllllllllIIIIlllllIllIllll >= 50L) {
                                this.lastServerTime = lllllllllllllllIIIIlllllIlllIIII;
                                final int lllllllllllllllIIIIlllllIllIlllI = lllllllllllllllIIIIlllllIlllIIlI.getTickCounter();
                                int lllllllllllllllIIIIlllllIllIllIl = lllllllllllllllIIIIlllllIllIlllI - this.lastServerTicks;
                                if (lllllllllllllllIIIIlllllIllIllIl < 0) {
                                    this.lastServerTicks = lllllllllllllllIIIIlllllIllIlllI;
                                    lllllllllllllllIIIIlllllIllIllIl = 0;
                                }
                                if (lllllllllllllllIIIIlllllIllIllIl < 1 && this.serverWaitTime < 100) {
                                    this.serverWaitTime += 2;
                                }
                                if (lllllllllllllllIIIIlllllIllIllIl > 1 && this.serverWaitTime > 0) {
                                    --this.serverWaitTime;
                                }
                                this.lastServerTicks = lllllllllllllllIIIIlllllIllIlllI;
                            }
                        }
                        else {
                            this.lastServerTime = lllllllllllllllIIIIlllllIlllIIII;
                            this.lastServerTicks = lllllllllllllllIIIIlllllIlllIIlI.getTickCounter();
                            this.avgServerTickDiff = 1.0f;
                            this.avgServerTimeDiff = 50.0f;
                        }
                    }
                    else {
                        if (this.mc.currentScreen instanceof GuiDownloadTerrain) {
                            Config.sleep(20L);
                        }
                        this.lastServerTime = 0L;
                        this.lastServerTicks = 0;
                    }
                }
            }
        }
        else {
            this.lastServerTime = 0L;
            this.lastServerTicks = 0;
        }
    }
    
    private void updateFogColor(final float lllllllllllllllIIIIllllllllIIllI) {
        final World lllllllllllllllIIIIllllllllIIlIl = this.mc.world;
        final Entity lllllllllllllllIIIIllllllllIIlII = this.mc.getRenderViewEntity();
        float lllllllllllllllIIIIllllllllIIIll = 0.25f + 0.75f * this.mc.gameSettings.renderDistanceChunks / 32.0f;
        lllllllllllllllIIIIllllllllIIIll = 1.0f - (float)Math.pow(lllllllllllllllIIIIllllllllIIIll, 0.25);
        Vec3d lllllllllllllllIIIIllllllllIIIlI = lllllllllllllllIIIIllllllllIIlIl.getSkyColor(this.mc.getRenderViewEntity(), lllllllllllllllIIIIllllllllIIllI);
        lllllllllllllllIIIIllllllllIIIlI = CustomColors.getWorldSkyColor(lllllllllllllllIIIIllllllllIIIlI, lllllllllllllllIIIIllllllllIIlIl, this.mc.getRenderViewEntity(), lllllllllllllllIIIIllllllllIIllI);
        final float lllllllllllllllIIIIllllllllIIIIl = (float)lllllllllllllllIIIIllllllllIIIlI.xCoord;
        final float lllllllllllllllIIIIllllllllIIIII = (float)lllllllllllllllIIIIllllllllIIIlI.yCoord;
        final float lllllllllllllllIIIIlllllllIlllll = (float)lllllllllllllllIIIIllllllllIIIlI.zCoord;
        Vec3d lllllllllllllllIIIIlllllllIllllI = lllllllllllllllIIIIllllllllIIlIl.getFogColor(lllllllllllllllIIIIllllllllIIllI);
        lllllllllllllllIIIIlllllllIllllI = CustomColors.getWorldFogColor(lllllllllllllllIIIIlllllllIllllI, lllllllllllllllIIIIllllllllIIlIl, this.mc.getRenderViewEntity(), lllllllllllllllIIIIllllllllIIllI);
        if (Main.moduleManager.getModule(SkyColor.class).isToggled()) {
            this.fogColorRed = SkyColor.red.getValInt() / 255.0f;
            this.fogColorGreen = SkyColor.blue.getValInt() / 255.0f;
            this.fogColorBlue = SkyColor.green.getValInt() / 255.0f;
        }
        else {
            this.fogColorRed = (float)lllllllllllllllIIIIlllllllIllllI.xCoord;
            this.fogColorGreen = (float)lllllllllllllllIIIIlllllllIllllI.yCoord;
            this.fogColorBlue = (float)lllllllllllllllIIIIlllllllIllllI.zCoord;
        }
        if (this.mc.gameSettings.renderDistanceChunks >= 4) {
            final double lllllllllllllllIIIIlllllllIlllIl = (MathHelper.sin(lllllllllllllllIIIIllllllllIIlIl.getCelestialAngleRadians(lllllllllllllllIIIIllllllllIIllI)) > 0.0f) ? -1.0 : 1.0;
            final Vec3d lllllllllllllllIIIIlllllllIlllII = new Vec3d(lllllllllllllllIIIIlllllllIlllIl, 0.0, 0.0);
            float lllllllllllllllIIIIlllllllIllIll = (float)lllllllllllllllIIIIllllllllIIlII.getLook(lllllllllllllllIIIIllllllllIIllI).dotProduct(lllllllllllllllIIIIlllllllIlllII);
            if (lllllllllllllllIIIIlllllllIllIll < 0.0f) {
                lllllllllllllllIIIIlllllllIllIll = 0.0f;
            }
            if (lllllllllllllllIIIIlllllllIllIll > 0.0f) {
                final float[] lllllllllllllllIIIIlllllllIllIlI = lllllllllllllllIIIIllllllllIIlIl.provider.calcSunriseSunsetColors(lllllllllllllllIIIIllllllllIIlIl.getCelestialAngle(lllllllllllllllIIIIllllllllIIllI), lllllllllllllllIIIIllllllllIIllI);
                if (lllllllllllllllIIIIlllllllIllIlI != null) {
                    lllllllllllllllIIIIlllllllIllIll *= lllllllllllllllIIIIlllllllIllIlI[3];
                    this.fogColorRed = this.fogColorRed * (1.0f - lllllllllllllllIIIIlllllllIllIll) + lllllllllllllllIIIIlllllllIllIlI[0] * lllllllllllllllIIIIlllllllIllIll;
                    this.fogColorGreen = this.fogColorGreen * (1.0f - lllllllllllllllIIIIlllllllIllIll) + lllllllllllllllIIIIlllllllIllIlI[1] * lllllllllllllllIIIIlllllllIllIll;
                    this.fogColorBlue = this.fogColorBlue * (1.0f - lllllllllllllllIIIIlllllllIllIll) + lllllllllllllllIIIIlllllllIllIlI[2] * lllllllllllllllIIIIlllllllIllIll;
                }
            }
        }
        this.fogColorRed += (lllllllllllllllIIIIllllllllIIIIl - this.fogColorRed) * lllllllllllllllIIIIllllllllIIIll;
        this.fogColorGreen += (lllllllllllllllIIIIllllllllIIIII - this.fogColorGreen) * lllllllllllllllIIIIllllllllIIIll;
        this.fogColorBlue += (lllllllllllllllIIIIlllllllIlllll - this.fogColorBlue) * lllllllllllllllIIIIllllllllIIIll;
        final float lllllllllllllllIIIIlllllllIllIIl = lllllllllllllllIIIIllllllllIIlIl.getRainStrength(lllllllllllllllIIIIllllllllIIllI);
        if (lllllllllllllllIIIIlllllllIllIIl > 0.0f) {
            final float lllllllllllllllIIIIlllllllIllIII = 1.0f - lllllllllllllllIIIIlllllllIllIIl * 0.5f;
            final float lllllllllllllllIIIIlllllllIlIlll = 1.0f - lllllllllllllllIIIIlllllllIllIIl * 0.4f;
            this.fogColorRed *= lllllllllllllllIIIIlllllllIllIII;
            this.fogColorGreen *= lllllllllllllllIIIIlllllllIllIII;
            this.fogColorBlue *= lllllllllllllllIIIIlllllllIlIlll;
        }
        final float lllllllllllllllIIIIlllllllIlIllI = lllllllllllllllIIIIllllllllIIlIl.getThunderStrength(lllllllllllllllIIIIllllllllIIllI);
        if (lllllllllllllllIIIIlllllllIlIllI > 0.0f) {
            final float lllllllllllllllIIIIlllllllIlIlIl = 1.0f - lllllllllllllllIIIIlllllllIlIllI * 0.5f;
            this.fogColorRed *= lllllllllllllllIIIIlllllllIlIlIl;
            this.fogColorGreen *= lllllllllllllllIIIIlllllllIlIlIl;
            this.fogColorBlue *= lllllllllllllllIIIIlllllllIlIlIl;
        }
        final IBlockState lllllllllllllllIIIIlllllllIlIlII = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.world, lllllllllllllllIIIIllllllllIIlII, lllllllllllllllIIIIllllllllIIllI);
        if (this.cloudFog) {
            final Vec3d lllllllllllllllIIIIlllllllIlIIll = lllllllllllllllIIIIllllllllIIlIl.getCloudColour(lllllllllllllllIIIIllllllllIIllI);
            this.fogColorRed = (float)lllllllllllllllIIIIlllllllIlIIll.xCoord;
            this.fogColorGreen = (float)lllllllllllllllIIIIlllllllIlIIll.yCoord;
            this.fogColorBlue = (float)lllllllllllllllIIIIlllllllIlIIll.zCoord;
        }
        else if (Reflector.ForgeBlock_getFogColor.exists()) {
            final Vec3d lllllllllllllllIIIIlllllllIlIIlI = ActiveRenderInfo.projectViewFromEntity(lllllllllllllllIIIIllllllllIIlII, lllllllllllllllIIIIllllllllIIllI);
            final BlockPos lllllllllllllllIIIIlllllllIlIIIl = new BlockPos(lllllllllllllllIIIIlllllllIlIIlI);
            final IBlockState lllllllllllllllIIIIlllllllIlIIII = this.mc.world.getBlockState(lllllllllllllllIIIIlllllllIlIIIl);
            final Vec3d lllllllllllllllIIIIlllllllIIllll = (Vec3d)Reflector.call(lllllllllllllllIIIIlllllllIlIIII.getBlock(), Reflector.ForgeBlock_getFogColor, this.mc.world, lllllllllllllllIIIIlllllllIlIIIl, lllllllllllllllIIIIlllllllIlIIII, lllllllllllllllIIIIllllllllIIlII, new Vec3d(this.fogColorRed, this.fogColorGreen, this.fogColorBlue), lllllllllllllllIIIIllllllllIIllI);
            this.fogColorRed = (float)lllllllllllllllIIIIlllllllIIllll.xCoord;
            this.fogColorGreen = (float)lllllllllllllllIIIIlllllllIIllll.yCoord;
            this.fogColorBlue = (float)lllllllllllllllIIIIlllllllIIllll.zCoord;
        }
        else if (lllllllllllllllIIIIlllllllIlIlII.getMaterial() == Material.WATER) {
            float lllllllllllllllIIIIlllllllIIlllI = 0.0f;
            if (lllllllllllllllIIIIllllllllIIlII instanceof EntityLivingBase) {
                lllllllllllllllIIIIlllllllIIlllI = EnchantmentHelper.getRespirationModifier((EntityLivingBase)lllllllllllllllIIIIllllllllIIlII) * 0.2f;
                if (((EntityLivingBase)lllllllllllllllIIIIllllllllIIlII).isPotionActive(MobEffects.WATER_BREATHING)) {
                    lllllllllllllllIIIIlllllllIIlllI = lllllllllllllllIIIIlllllllIIlllI * 0.3f + 0.6f;
                }
            }
            this.fogColorRed = 0.02f + lllllllllllllllIIIIlllllllIIlllI;
            this.fogColorGreen = 0.02f + lllllllllllllllIIIIlllllllIIlllI;
            this.fogColorBlue = 0.2f + lllllllllllllllIIIIlllllllIIlllI;
            final Vec3d lllllllllllllllIIIIlllllllIIllIl = CustomColors.getUnderwaterColor(this.mc.world, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ);
            if (lllllllllllllllIIIIlllllllIIllIl != null) {
                this.fogColorRed = (float)lllllllllllllllIIIIlllllllIIllIl.xCoord;
                this.fogColorGreen = (float)lllllllllllllllIIIIlllllllIIllIl.yCoord;
                this.fogColorBlue = (float)lllllllllllllllIIIIlllllllIIllIl.zCoord;
            }
        }
        else if (lllllllllllllllIIIIlllllllIlIlII.getMaterial() == Material.LAVA) {
            this.fogColorRed = 0.6f;
            this.fogColorGreen = 0.1f;
            this.fogColorBlue = 0.0f;
            final Vec3d lllllllllllllllIIIIlllllllIIllII = CustomColors.getUnderlavaColor(this.mc.world, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ);
            if (lllllllllllllllIIIIlllllllIIllII != null) {
                this.fogColorRed = (float)lllllllllllllllIIIIlllllllIIllII.xCoord;
                this.fogColorGreen = (float)lllllllllllllllIIIIlllllllIIllII.yCoord;
                this.fogColorBlue = (float)lllllllllllllllIIIIlllllllIIllII.zCoord;
            }
        }
        final float lllllllllllllllIIIIlllllllIIlIll = this.fogColor2 + (this.fogColor1 - this.fogColor2) * lllllllllllllllIIIIllllllllIIllI;
        this.fogColorRed *= lllllllllllllllIIIIlllllllIIlIll;
        this.fogColorGreen *= lllllllllllllllIIIIlllllllIIlIll;
        this.fogColorBlue *= lllllllllllllllIIIIlllllllIIlIll;
        double lllllllllllllllIIIIlllllllIIlIlI = (lllllllllllllllIIIIllllllllIIlII.lastTickPosY + (lllllllllllllllIIIIllllllllIIlII.posY - lllllllllllllllIIIIllllllllIIlII.lastTickPosY) * lllllllllllllllIIIIllllllllIIllI) * lllllllllllllllIIIIllllllllIIlIl.provider.getVoidFogYFactor();
        if (lllllllllllllllIIIIllllllllIIlII instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllIIIIllllllllIIlII).isPotionActive(MobEffects.BLINDNESS)) {
            final int lllllllllllllllIIIIlllllllIIlIIl = ((EntityLivingBase)lllllllllllllllIIIIllllllllIIlII).getActivePotionEffect(MobEffects.BLINDNESS).getDuration();
            if (lllllllllllllllIIIIlllllllIIlIIl < 20) {
                lllllllllllllllIIIIlllllllIIlIlI *= 1.0f - lllllllllllllllIIIIlllllllIIlIIl / 20.0f;
            }
            else {
                lllllllllllllllIIIIlllllllIIlIlI = 0.0;
            }
        }
        if (lllllllllllllllIIIIlllllllIIlIlI < 1.0) {
            if (lllllllllllllllIIIIlllllllIIlIlI < 0.0) {
                lllllllllllllllIIIIlllllllIIlIlI = 0.0;
            }
            lllllllllllllllIIIIlllllllIIlIlI *= lllllllllllllllIIIIlllllllIIlIlI;
            this.fogColorRed *= (float)lllllllllllllllIIIIlllllllIIlIlI;
            this.fogColorGreen *= (float)lllllllllllllllIIIIlllllllIIlIlI;
            this.fogColorBlue *= (float)lllllllllllllllIIIIlllllllIIlIlI;
        }
        if (this.bossColorModifier > 0.0f) {
            final float lllllllllllllllIIIIlllllllIIlIII = this.bossColorModifierPrev + (this.bossColorModifier - this.bossColorModifierPrev) * lllllllllllllllIIIIllllllllIIllI;
            this.fogColorRed = this.fogColorRed * (1.0f - lllllllllllllllIIIIlllllllIIlIII) + this.fogColorRed * 0.7f * lllllllllllllllIIIIlllllllIIlIII;
            this.fogColorGreen = this.fogColorGreen * (1.0f - lllllllllllllllIIIIlllllllIIlIII) + this.fogColorGreen * 0.6f * lllllllllllllllIIIIlllllllIIlIII;
            this.fogColorBlue = this.fogColorBlue * (1.0f - lllllllllllllllIIIIlllllllIIlIII) + this.fogColorBlue * 0.6f * lllllllllllllllIIIIlllllllIIlIII;
        }
        if (lllllllllllllllIIIIllllllllIIlII instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllIIIIllllllllIIlII).isPotionActive(MobEffects.NIGHT_VISION)) {
            final float lllllllllllllllIIIIlllllllIIIlll = this.getNightVisionBrightness((EntityLivingBase)lllllllllllllllIIIIllllllllIIlII, lllllllllllllllIIIIllllllllIIllI);
            float lllllllllllllllIIIIlllllllIIIllI = 1.0f / this.fogColorRed;
            if (lllllllllllllllIIIIlllllllIIIllI > 1.0f / this.fogColorGreen) {
                lllllllllllllllIIIIlllllllIIIllI = 1.0f / this.fogColorGreen;
            }
            if (lllllllllllllllIIIIlllllllIIIllI > 1.0f / this.fogColorBlue) {
                lllllllllllllllIIIIlllllllIIIllI = 1.0f / this.fogColorBlue;
            }
            this.fogColorRed = this.fogColorRed * (1.0f - lllllllllllllllIIIIlllllllIIIlll) + this.fogColorRed * lllllllllllllllIIIIlllllllIIIllI * lllllllllllllllIIIIlllllllIIIlll;
            this.fogColorGreen = this.fogColorGreen * (1.0f - lllllllllllllllIIIIlllllllIIIlll) + this.fogColorGreen * lllllllllllllllIIIIlllllllIIIllI * lllllllllllllllIIIIlllllllIIIlll;
            this.fogColorBlue = this.fogColorBlue * (1.0f - lllllllllllllllIIIIlllllllIIIlll) + this.fogColorBlue * lllllllllllllllIIIIlllllllIIIllI * lllllllllllllllIIIIlllllllIIIlll;
        }
        if (this.mc.gameSettings.anaglyph) {
            final float lllllllllllllllIIIIlllllllIIIlIl = (this.fogColorRed * 30.0f + this.fogColorGreen * 59.0f + this.fogColorBlue * 11.0f) / 100.0f;
            final float lllllllllllllllIIIIlllllllIIIlII = (this.fogColorRed * 30.0f + this.fogColorGreen * 70.0f) / 100.0f;
            final float lllllllllllllllIIIIlllllllIIIIll = (this.fogColorRed * 30.0f + this.fogColorBlue * 70.0f) / 100.0f;
            this.fogColorRed = lllllllllllllllIIIIlllllllIIIlIl;
            this.fogColorGreen = lllllllllllllllIIIIlllllllIIIlII;
            this.fogColorBlue = lllllllllllllllIIIIlllllllIIIIll;
        }
        if (Reflector.EntityViewRenderEvent_FogColors_Constructor.exists()) {
            final Object lllllllllllllllIIIIlllllllIIIIlI = Reflector.newInstance(Reflector.EntityViewRenderEvent_FogColors_Constructor, this, lllllllllllllllIIIIllllllllIIlII, lllllllllllllllIIIIlllllllIlIlII, lllllllllllllllIIIIllllllllIIllI, this.fogColorRed, this.fogColorGreen, this.fogColorBlue);
            Reflector.postForgeBusEvent(lllllllllllllllIIIIlllllllIIIIlI);
            this.fogColorRed = Reflector.callFloat(lllllllllllllllIIIIlllllllIIIIlI, Reflector.EntityViewRenderEvent_FogColors_getRed, new Object[0]);
            this.fogColorGreen = Reflector.callFloat(lllllllllllllllIIIIlllllllIIIIlI, Reflector.EntityViewRenderEvent_FogColors_getGreen, new Object[0]);
            this.fogColorBlue = Reflector.callFloat(lllllllllllllllIIIIlllllllIIIIlI, Reflector.EntityViewRenderEvent_FogColors_getBlue, new Object[0]);
        }
        Shaders.setClearColor(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 0.0f);
    }
    
    private void addRainParticles() {
        float lllllllllllllllIIIlIIIIIlIlIIllI = this.mc.world.getRainStrength(1.0f);
        if (!Config.isRainFancy()) {
            lllllllllllllllIIIlIIIIIlIlIIllI /= 2.0f;
        }
        if (lllllllllllllllIIIlIIIIIlIlIIllI != 0.0f && Config.isRainSplash()) {
            this.random.setSeed(this.rendererUpdateCount * 312987231L);
            final Entity lllllllllllllllIIIlIIIIIlIlIIlIl = this.mc.getRenderViewEntity();
            final World lllllllllllllllIIIlIIIIIlIlIIlII = this.mc.world;
            final BlockPos lllllllllllllllIIIlIIIIIlIlIIIll = new BlockPos(lllllllllllllllIIIlIIIIIlIlIIlIl);
            final int lllllllllllllllIIIlIIIIIlIlIIIlI = 10;
            double lllllllllllllllIIIlIIIIIlIlIIIIl = 0.0;
            double lllllllllllllllIIIlIIIIIlIlIIIII = 0.0;
            double lllllllllllllllIIIlIIIIIlIIlllll = 0.0;
            int lllllllllllllllIIIlIIIIIlIIllllI = 0;
            int lllllllllllllllIIIlIIIIIlIIlllIl = (int)(100.0f * lllllllllllllllIIIlIIIIIlIlIIllI * lllllllllllllllIIIlIIIIIlIlIIllI);
            if (this.mc.gameSettings.particleSetting == 1) {
                lllllllllllllllIIIlIIIIIlIIlllIl >>= 1;
            }
            else if (this.mc.gameSettings.particleSetting == 2) {
                lllllllllllllllIIIlIIIIIlIIlllIl = 0;
            }
            for (int lllllllllllllllIIIlIIIIIlIIlllII = 0; lllllllllllllllIIIlIIIIIlIIlllII < lllllllllllllllIIIlIIIIIlIIlllIl; ++lllllllllllllllIIIlIIIIIlIIlllII) {
                final BlockPos lllllllllllllllIIIlIIIIIlIIllIll = lllllllllllllllIIIlIIIIIlIlIIlII.getPrecipitationHeight(lllllllllllllllIIIlIIIIIlIlIIIll.add(this.random.nextInt(10) - this.random.nextInt(10), 0, this.random.nextInt(10) - this.random.nextInt(10)));
                final Biome lllllllllllllllIIIlIIIIIlIIllIlI = lllllllllllllllIIIlIIIIIlIlIIlII.getBiome(lllllllllllllllIIIlIIIIIlIIllIll);
                final BlockPos lllllllllllllllIIIlIIIIIlIIllIIl = lllllllllllllllIIIlIIIIIlIIllIll.down();
                final IBlockState lllllllllllllllIIIlIIIIIlIIllIII = lllllllllllllllIIIlIIIIIlIlIIlII.getBlockState(lllllllllllllllIIIlIIIIIlIIllIIl);
                if (lllllllllllllllIIIlIIIIIlIIllIll.getY() <= lllllllllllllllIIIlIIIIIlIlIIIll.getY() + 10 && lllllllllllllllIIIlIIIIIlIIllIll.getY() >= lllllllllllllllIIIlIIIIIlIlIIIll.getY() - 10 && lllllllllllllllIIIlIIIIIlIIllIlI.canRain() && lllllllllllllllIIIlIIIIIlIIllIlI.getFloatTemperature(lllllllllllllllIIIlIIIIIlIIllIll) >= 0.15f) {
                    final double lllllllllllllllIIIlIIIIIlIIlIlll = this.random.nextDouble();
                    final double lllllllllllllllIIIlIIIIIlIIlIllI = this.random.nextDouble();
                    final AxisAlignedBB lllllllllllllllIIIlIIIIIlIIlIlIl = lllllllllllllllIIIlIIIIIlIIllIII.getBoundingBox(lllllllllllllllIIIlIIIIIlIlIIlII, lllllllllllllllIIIlIIIIIlIIllIIl);
                    if (lllllllllllllllIIIlIIIIIlIIllIII.getMaterial() != Material.LAVA && lllllllllllllllIIIlIIIIIlIIllIII.getBlock() != Blocks.MAGMA) {
                        if (lllllllllllllllIIIlIIIIIlIIllIII.getMaterial() != Material.AIR) {
                            ++lllllllllllllllIIIlIIIIIlIIllllI;
                            if (this.random.nextInt(lllllllllllllllIIIlIIIIIlIIllllI) == 0) {
                                lllllllllllllllIIIlIIIIIlIlIIIIl = lllllllllllllllIIIlIIIIIlIIllIIl.getX() + lllllllllllllllIIIlIIIIIlIIlIlll;
                                lllllllllllllllIIIlIIIIIlIlIIIII = lllllllllllllllIIIlIIIIIlIIllIIl.getY() + 0.1f + lllllllllllllllIIIlIIIIIlIIlIlIl.maxY - 1.0;
                                lllllllllllllllIIIlIIIIIlIIlllll = lllllllllllllllIIIlIIIIIlIIllIIl.getZ() + lllllllllllllllIIIlIIIIIlIIlIllI;
                            }
                            this.mc.world.spawnParticle(EnumParticleTypes.WATER_DROP, lllllllllllllllIIIlIIIIIlIIllIIl.getX() + lllllllllllllllIIIlIIIIIlIIlIlll, lllllllllllllllIIIlIIIIIlIIllIIl.getY() + 0.1f + lllllllllllllllIIIlIIIIIlIIlIlIl.maxY, lllllllllllllllIIIlIIIIIlIIllIIl.getZ() + lllllllllllllllIIIlIIIIIlIIlIllI, 0.0, 0.0, 0.0, new int[0]);
                        }
                    }
                    else {
                        this.mc.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIIIlIIIIIlIIllIll.getX() + lllllllllllllllIIIlIIIIIlIIlIlll, lllllllllllllllIIIlIIIIIlIIllIll.getY() + 0.1f - lllllllllllllllIIIlIIIIIlIIlIlIl.minY, lllllllllllllllIIIlIIIIIlIIllIll.getZ() + lllllllllllllllIIIlIIIIIlIIlIllI, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
            }
            if (lllllllllllllllIIIlIIIIIlIIllllI > 0 && this.random.nextInt(3) < this.rainSoundCounter++) {
                this.rainSoundCounter = 0;
                if (lllllllllllllllIIIlIIIIIlIlIIIII > lllllllllllllllIIIlIIIIIlIlIIIll.getY() + 1 && lllllllllllllllIIIlIIIIIlIlIIlII.getPrecipitationHeight(lllllllllllllllIIIlIIIIIlIlIIIll).getY() > MathHelper.floor((float)lllllllllllllllIIIlIIIIIlIlIIIll.getY())) {
                    this.mc.world.playSound(lllllllllllllllIIIlIIIIIlIlIIIIl, lllllllllllllllIIIlIIIIIlIlIIIII, lllllllllllllllIIIlIIIIIlIIlllll, SoundEvents.WEATHER_RAIN_ABOVE, SoundCategory.WEATHER, 0.1f, 0.5f, false);
                }
                else {
                    this.mc.world.playSound(lllllllllllllllIIIlIIIIIlIlIIIIl, lllllllllllllllIIIlIIIIIlIlIIIII, lllllllllllllllIIIlIIIIIlIIlllll, SoundEvents.WEATHER_RAIN, SoundCategory.WEATHER, 0.2f, 1.0f, false);
                }
            }
        }
    }
    
    public void switchUseShader() {
        this.useShader = !this.useShader;
    }
    
    public EntityRenderer(final Minecraft lllllllllllllllIIIlIIIllIIlIlIIl, final IResourceManager lllllllllllllllIIIlIIIllIIllIIII) {
        this.random = new Random();
        this.mouseFilterXAxis = new MouseFilter();
        this.mouseFilterYAxis = new MouseFilter();
        this.thirdPersonDistancePrev = 4.0f;
        this.renderHand = true;
        this.drawBlockOutline = true;
        this.prevFrameTime = Minecraft.getSystemTime();
        this.rainXCoords = new float[1024];
        this.rainYCoords = new float[1024];
        this.fogColorBuffer = GLAllocation.createDirectFloatBuffer(16);
        this.cameraZoom = 1.0;
        this.initialized = false;
        this.updatedWorld = null;
        this.fogStandard = false;
        this.clipDistance = 128.0f;
        this.lastServerTime = 0L;
        this.lastServerTicks = 0;
        this.serverWaitTime = 0;
        this.serverWaitTimeCurrent = 0;
        this.avgServerTimeDiff = 0.0f;
        this.avgServerTickDiff = 0.0f;
        this.lastErrorCheckTimeMs = 0L;
        this.fxaaShaders = new ShaderGroup[10];
        this.loadVisibleChunks = false;
        this.scopeMath = 1.0f;
        this.shaderIndex = EntityRenderer.SHADER_COUNT;
        this.mc = lllllllllllllllIIIlIIIllIIlIlIIl;
        this.resourceManager = lllllllllllllllIIIlIIIllIIllIIII;
        this.itemRenderer = lllllllllllllllIIIlIIIllIIlIlIIl.getItemRenderer();
        this.theMapItemRenderer = new MapItemRenderer(lllllllllllllllIIIlIIIllIIlIlIIl.getTextureManager());
        this.lightmapTexture = new DynamicTexture(16, 16);
        this.locationLightMap = lllllllllllllllIIIlIIIllIIlIlIIl.getTextureManager().getDynamicTextureLocation("lightMap", this.lightmapTexture);
        this.lightmapColors = this.lightmapTexture.getTextureData();
        this.theShaderGroup = null;
        for (int lllllllllllllllIIIlIIIllIIlIllll = 0; lllllllllllllllIIIlIIIllIIlIllll < 32; ++lllllllllllllllIIIlIIIllIIlIllll) {
            for (int lllllllllllllllIIIlIIIllIIlIlllI = 0; lllllllllllllllIIIlIIIllIIlIlllI < 32; ++lllllllllllllllIIIlIIIllIIlIlllI) {
                final float lllllllllllllllIIIlIIIllIIlIllIl = (float)(lllllllllllllllIIIlIIIllIIlIlllI - 16);
                final float lllllllllllllllIIIlIIIllIIlIllII = (float)(lllllllllllllllIIIlIIIllIIlIllll - 16);
                final float lllllllllllllllIIIlIIIllIIlIlIll = MathHelper.sqrt(lllllllllllllllIIIlIIIllIIlIllIl * lllllllllllllllIIIlIIIllIIlIllIl + lllllllllllllllIIIlIIIllIIlIllII * lllllllllllllllIIIlIIIllIIlIllII);
                this.rainXCoords[lllllllllllllllIIIlIIIllIIlIllll << 5 | lllllllllllllllIIIlIIIllIIlIlllI] = -lllllllllllllllIIIlIIIllIIlIllII / lllllllllllllllIIIlIIIllIIlIlIll;
                this.rainYCoords[lllllllllllllllIIIlIIIllIIlIllll << 5 | lllllllllllllllIIIlIIIllIIlIlllI] = lllllllllllllllIIIlIIIllIIlIllIl / lllllllllllllllIIIlIIIllIIlIlIll;
            }
        }
    }
    
    private void frameFinish() {
        if (this.mc.world != null) {
            final long lllllllllllllllIIIIlllllIlIIllll = System.currentTimeMillis();
            if (lllllllllllllllIIIIlllllIlIIllll > this.lastErrorCheckTimeMs + 10000L) {
                this.lastErrorCheckTimeMs = lllllllllllllllIIIIlllllIlIIllll;
                final int lllllllllllllllIIIIlllllIlIIlllI = GlStateManager.glGetError();
                if (lllllllllllllllIIIIlllllIlIIlllI != 0) {
                    final String lllllllllllllllIIIIlllllIlIIllIl = GLU.gluErrorString(lllllllllllllllIIIIlllllIlIIlllI);
                    final TextComponentString lllllllllllllllIIIIlllllIlIIllII = new TextComponentString(I18n.format("of.message.openglError", lllllllllllllllIIIIlllllIlIIlllI, lllllllllllllllIIIIlllllIlIIllIl));
                    this.mc.ingameGUI.getChatGUI().printChatMessage(lllllllllllllllIIIIlllllIlIIllII);
                }
            }
        }
    }
    
    private void updateFovModifierHand() {
        float lllllllllllllllIIIlIIIlIlIIlllll = 1.0f;
        if (this.mc.getRenderViewEntity() instanceof AbstractClientPlayer) {
            final AbstractClientPlayer lllllllllllllllIIIlIIIlIlIIllllI = (AbstractClientPlayer)this.mc.getRenderViewEntity();
            lllllllllllllllIIIlIIIlIlIIlllll = lllllllllllllllIIIlIIIlIlIIllllI.getFovModifier();
        }
        this.fovModifierHandPrev = this.fovModifierHand;
        this.fovModifierHand += (lllllllllllllllIIIlIIIlIlIIlllll - this.fovModifierHand) * 0.5f;
        if (this.fovModifierHand > 1.5f) {
            this.fovModifierHand = 1.5f;
        }
        if (this.fovModifierHand < 0.1f) {
            this.fovModifierHand = 0.1f;
        }
    }
    
    private void setupFog(final int lllllllllllllllIIIIllllllIIlllII, final float lllllllllllllllIIIIllllllIIllIll) {
        this.fogStandard = false;
        final Entity lllllllllllllllIIIIllllllIlIIIll = this.mc.getRenderViewEntity();
        this.func_191514_d(false);
        GlStateManager.glNormal3f(0.0f, -1.0f, 0.0f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        final IBlockState lllllllllllllllIIIIllllllIlIIIlI = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.world, lllllllllllllllIIIIllllllIlIIIll, lllllllllllllllIIIIllllllIIllIll);
        float lllllllllllllllIIIIllllllIlIIIIl = -1.0f;
        if (Reflector.ForgeHooksClient_getFogDensity.exists()) {
            lllllllllllllllIIIIllllllIlIIIIl = Reflector.callFloat(Reflector.ForgeHooksClient_getFogDensity, this, lllllllllllllllIIIIllllllIlIIIll, lllllllllllllllIIIIllllllIlIIIlI, lllllllllllllllIIIIllllllIIllIll, 0.1f);
        }
        if (lllllllllllllllIIIIllllllIlIIIIl >= 0.0f) {
            GlStateManager.setFogDensity(lllllllllllllllIIIIllllllIlIIIIl);
        }
        else if (lllllllllllllllIIIIllllllIlIIIll instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllIIIIllllllIlIIIll).isPotionActive(MobEffects.BLINDNESS)) {
            float lllllllllllllllIIIIllllllIlIIIII = 5.0f;
            final int lllllllllllllllIIIIllllllIIlllll = ((EntityLivingBase)lllllllllllllllIIIIllllllIlIIIll).getActivePotionEffect(MobEffects.BLINDNESS).getDuration();
            if (lllllllllllllllIIIIllllllIIlllll < 20) {
                lllllllllllllllIIIIllllllIlIIIII = 5.0f + (this.farPlaneDistance - 5.0f) * (1.0f - lllllllllllllllIIIIllllllIIlllll / 20.0f);
            }
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.LINEAR);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.LINEAR);
            }
            if (lllllllllllllllIIIIllllllIIlllII == -1) {
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(lllllllllllllllIIIIllllllIlIIIII * 0.8f);
            }
            else {
                GlStateManager.setFogStart(lllllllllllllllIIIIllllllIlIIIII * 0.25f);
                GlStateManager.setFogEnd(lllllllllllllllIIIIllllllIlIIIII);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance && Config.isFogFancy()) {
                GlStateManager.glFogi(34138, 34139);
            }
        }
        else if (this.cloudFog) {
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.EXP);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.EXP);
            }
            GlStateManager.setFogDensity(0.1f);
        }
        else if (lllllllllllllllIIIIllllllIlIIIlI.getMaterial() == Material.WATER && !Main.moduleManager.getModuleByName("NoOverlay").isToggled()) {
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.EXP);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.EXP);
            }
            if (lllllllllllllllIIIIllllllIlIIIll instanceof EntityLivingBase) {
                if (((EntityLivingBase)lllllllllllllllIIIIllllllIlIIIll).isPotionActive(MobEffects.WATER_BREATHING)) {
                    GlStateManager.setFogDensity(0.01f);
                }
                else {
                    GlStateManager.setFogDensity(0.1f - EnchantmentHelper.getRespirationModifier((EntityLivingBase)lllllllllllllllIIIIllllllIlIIIll) * 0.03f);
                }
            }
            else {
                GlStateManager.setFogDensity(0.1f);
            }
            if (Config.isClearWater()) {
                GlStateManager.setFogDensity(0.02f);
            }
        }
        else if (lllllllllllllllIIIIllllllIlIIIlI.getMaterial() == Material.LAVA && !Main.moduleManager.getModuleByName("NoOverlay").isToggled()) {
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.EXP);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.EXP);
            }
            GlStateManager.setFogDensity(2.0f);
        }
        else {
            final float lllllllllllllllIIIIllllllIIllllI = this.farPlaneDistance;
            this.fogStandard = true;
            if (Config.isShaders()) {
                Shaders.setFog(GlStateManager.FogMode.LINEAR);
            }
            else {
                GlStateManager.setFog(GlStateManager.FogMode.LINEAR);
            }
            if (lllllllllllllllIIIIllllllIIlllII == -1) {
                GlStateManager.setFogStart(0.0f);
                GlStateManager.setFogEnd(lllllllllllllllIIIIllllllIIllllI);
            }
            else {
                GlStateManager.setFogStart(lllllllllllllllIIIIllllllIIllllI * Config.getFogStart());
                GlStateManager.setFogEnd(lllllllllllllllIIIIllllllIIllllI);
            }
            if (GLContext.getCapabilities().GL_NV_fog_distance) {
                if (Config.isFogFancy()) {
                    GlStateManager.glFogi(34138, 34139);
                }
                if (Config.isFogFast()) {
                    GlStateManager.glFogi(34138, 34140);
                }
            }
            if (this.mc.world.provider.doesXZShowFog((int)lllllllllllllllIIIIllllllIlIIIll.posX, (int)lllllllllllllllIIIIllllllIlIIIll.posZ) || this.mc.ingameGUI.getBossOverlay().shouldCreateFog()) {
                GlStateManager.setFogStart(lllllllllllllllIIIIllllllIIllllI * 0.05f);
                GlStateManager.setFogEnd(lllllllllllllllIIIIllllllIIllllI);
            }
            if (Reflector.ForgeHooksClient_onFogRender.exists()) {
                Reflector.callVoid(Reflector.ForgeHooksClient_onFogRender, this, lllllllllllllllIIIIllllllIlIIIll, lllllllllllllllIIIIllllllIlIIIlI, lllllllllllllllIIIIllllllIIllIll, lllllllllllllllIIIIllllllIIlllII, lllllllllllllllIIIIllllllIIllllI);
            }
        }
        GlStateManager.enableColorMaterial();
        GlStateManager.enableFog();
        GlStateManager.colorMaterial(1028, 4608);
    }
    
    private void updateTorchFlicker() {
        this.torchFlickerDX += (float)((Math.random() - Math.random()) * Math.random() * Math.random());
        this.torchFlickerDX *= (float)0.9;
        this.torchFlickerX += this.torchFlickerDX - this.torchFlickerX;
        this.lightmapUpdateNeeded = true;
    }
    
    public float getNightVisionBrightness(final EntityLivingBase lllllllllllllllIIIlIIIIlIlllIIlI, final float lllllllllllllllIIIlIIIIlIlllIIIl) {
        final int lllllllllllllllIIIlIIIIlIlllIIll = lllllllllllllllIIIlIIIIlIlllIIlI.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration();
        return (lllllllllllllllIIIlIIIIlIlllIIll > 200) ? 1.0f : (0.7f + MathHelper.sin((lllllllllllllllIIIlIIIIlIlllIIll - lllllllllllllllIIIlIIIIlIlllIIIl) * 3.1415927f * 0.2f) * 0.3f);
    }
    
    private FloatBuffer setFogColorBuffer(final float lllllllllllllllIIIIllllllIIIIlII, final float lllllllllllllllIIIIllllllIIIIIll, final float lllllllllllllllIIIIllllllIIIIlll, final float lllllllllllllllIIIIllllllIIIIllI) {
        if (Config.isShaders()) {
            Shaders.setFogColor(lllllllllllllllIIIIllllllIIIIlII, lllllllllllllllIIIIllllllIIIIIll, lllllllllllllllIIIIllllllIIIIlll);
        }
        this.fogColorBuffer.clear();
        this.fogColorBuffer.put(lllllllllllllllIIIIllllllIIIIlII).put(lllllllllllllllIIIIllllllIIIIIll).put(lllllllllllllllIIIIllllllIIIIlll).put(lllllllllllllllIIIIllllllIIIIllI);
        this.fogColorBuffer.flip();
        return this.fogColorBuffer;
    }
    
    public void func_191514_d(final boolean lllllllllllllllIIIIllllllIIlIIII) {
        if (lllllllllllllllIIIIllllllIIlIIII) {
            GlStateManager.glFog(2918, this.setFogColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        }
        else {
            GlStateManager.glFog(2918, this.setFogColorBuffer(this.fogColorRed, this.fogColorGreen, this.fogColorBlue, 1.0f));
        }
    }
    
    private float getFOVModifier(final float lllllllllllllllIIIlIIIlIlIIlIIlI, final boolean lllllllllllllllIIIlIIIlIlIIIlIII) {
        if (this.debugView) {
            return 90.0f;
        }
        final Entity lllllllllllllllIIIlIIIlIlIIlIIII = this.mc.getRenderViewEntity();
        float lllllllllllllllIIIlIIIlIlIIIllll = 70.0f;
        if (lllllllllllllllIIIlIIIlIlIIIlIII) {
            lllllllllllllllIIIlIIIlIlIIIllll = this.mc.gameSettings.fovSetting;
            if (Config.isDynamicFov()) {
                lllllllllllllllIIIlIIIlIlIIIllll *= this.fovModifierHandPrev + (this.fovModifierHand - this.fovModifierHandPrev) * lllllllllllllllIIIlIIIlIlIIlIIlI;
            }
        }
        boolean lllllllllllllllIIIlIIIlIlIIIlllI = false;
        if (this.mc.currentScreen == null) {
            final GameSettings lllllllllllllllIIIlIIIlIlIIIllIl = this.mc.gameSettings;
            lllllllllllllllIIIlIIIlIlIIIlllI = GameSettings.isKeyDown(this.mc.gameSettings.ofKeyBindZoom);
        }
        if (lllllllllllllllIIIlIIIlIlIIIlllI) {
            if (!Config.zoomMode) {
                Config.zoomMode = true;
                this.mc.gameSettings.smoothCamera = true;
                this.mc.renderGlobal.displayListEntitiesDirty = true;
            }
            if (Config.zoomMode) {
                lllllllllllllllIIIlIIIlIlIIIllll /= 4.0f;
            }
        }
        else if (Config.zoomMode) {
            Config.zoomMode = false;
            this.mc.gameSettings.smoothCamera = false;
            this.mouseFilterXAxis = new MouseFilter();
            this.mouseFilterYAxis = new MouseFilter();
            this.mc.renderGlobal.displayListEntitiesDirty = true;
        }
        if (lllllllllllllllIIIlIIIlIlIIlIIII instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllIIIlIIIlIlIIlIIII).getHealth() <= 0.0f) {
            final float lllllllllllllllIIIlIIIlIlIIIllII = ((EntityLivingBase)lllllllllllllllIIIlIIIlIlIIlIIII).deathTime + lllllllllllllllIIIlIIIlIlIIlIIlI;
            lllllllllllllllIIIlIIIlIlIIIllll /= (1.0f - 500.0f / (lllllllllllllllIIIlIIIlIlIIIllII + 500.0f)) * 2.0f + 1.0f;
        }
        final IBlockState lllllllllllllllIIIlIIIlIlIIIlIll = ActiveRenderInfo.getBlockStateAtEntityViewpoint(this.mc.world, lllllllllllllllIIIlIIIlIlIIlIIII, lllllllllllllllIIIlIIIlIlIIlIIlI);
        if (lllllllllllllllIIIlIIIlIlIIIlIll.getMaterial() == Material.WATER) {
            lllllllllllllllIIIlIIIlIlIIIllll = lllllllllllllllIIIlIIIlIlIIIllll * 60.0f / 70.0f;
        }
        return Reflector.ForgeHooksClient_getFOVModifier.exists() ? Reflector.callFloat(Reflector.ForgeHooksClient_getFOVModifier, this, lllllllllllllllIIIlIIIlIlIIlIIII, lllllllllllllllIIIlIIIlIlIIIlIll, lllllllllllllllIIIlIIIlIlIIlIIlI, lllllllllllllllIIIlIIIlIlIIIllll) : lllllllllllllllIIIlIIIlIlIIIllll;
    }
    
    private void loadAllVisibleChunks(final Entity lllllllllllllllIIIIlllllIIIIIIlI, final double lllllllllllllllIIIIlllllIIIIIIIl, final ICamera lllllllllllllllIIIIlllllIIIIIIII, final boolean lllllllllllllllIIIIlllllIIIIlIll) {
        final RenderGlobal lllllllllllllllIIIIlllllIIIIlIlI = Config.getRenderGlobal();
        int lllllllllllllllIIIIlllllIIIIlIIl = lllllllllllllllIIIIlllllIIIIlIlI.getCountLoadedChunks();
        final long lllllllllllllllIIIIlllllIIIIlIII = System.currentTimeMillis();
        Config.dbg("Loading visible chunks");
        long lllllllllllllllIIIIlllllIIIIIlll = System.currentTimeMillis() + 5000L;
        int lllllllllllllllIIIIlllllIIIIIllI = 0;
        boolean lllllllllllllllIIIIlllllIIIIIlIl = false;
        do {
            lllllllllllllllIIIIlllllIIIIIlIl = false;
            for (int lllllllllllllllIIIIlllllIIIIIlII = 0; lllllllllllllllIIIIlllllIIIIIlII < 100; ++lllllllllllllllIIIIlllllIIIIIlII) {
                lllllllllllllllIIIIlllllIIIIlIlI.displayListEntitiesDirty = true;
                lllllllllllllllIIIIlllllIIIIlIlI.setupTerrain(lllllllllllllllIIIIlllllIIIIIIlI, lllllllllllllllIIIIlllllIIIIIIIl, lllllllllllllllIIIIlllllIIIIIIII, this.frameCount++, lllllllllllllllIIIIlllllIIIIlIll);
                if (!lllllllllllllllIIIIlllllIIIIlIlI.hasNoChunkUpdates()) {
                    lllllllllllllllIIIIlllllIIIIIlIl = true;
                }
                lllllllllllllllIIIIlllllIIIIIllI += lllllllllllllllIIIIlllllIIIIlIlI.getCountChunksToUpdate();
                lllllllllllllllIIIIlllllIIIIlIlI.updateChunks(System.nanoTime() + 1000000000L);
                lllllllllllllllIIIIlllllIIIIIllI -= lllllllllllllllIIIIlllllIIIIlIlI.getCountChunksToUpdate();
            }
            if (lllllllllllllllIIIIlllllIIIIlIlI.getCountLoadedChunks() != lllllllllllllllIIIIlllllIIIIlIIl) {
                lllllllllllllllIIIIlllllIIIIIlIl = true;
                lllllllllllllllIIIIlllllIIIIlIIl = lllllllllllllllIIIIlllllIIIIlIlI.getCountLoadedChunks();
            }
            if (System.currentTimeMillis() > lllllllllllllllIIIIlllllIIIIIlll) {
                Config.log(String.valueOf(new StringBuilder("Chunks loaded: ").append(lllllllllllllllIIIIlllllIIIIIllI)));
                lllllllllllllllIIIIlllllIIIIIlll = System.currentTimeMillis() + 5000L;
            }
        } while (lllllllllllllllIIIIlllllIIIIIlIl);
        Config.log(String.valueOf(new StringBuilder("Chunks loaded: ").append(lllllllllllllllIIIIlllllIIIIIllI)));
        Config.log("Finished loading visible chunks");
        RenderChunk.renderChunksUpdated = 0;
    }
    
    public void updateCameraAndRender(final float lllllllllllllllIIIlIIIIlIlIIlIIl, final long lllllllllllllllIIIlIIIIlIlIIlIII) {
        this.frameInit();
        final boolean lllllllllllllllIIIlIIIIlIlIllllI = Display.isActive();
        if (!lllllllllllllllIIIlIIIIlIlIllllI && this.mc.gameSettings.pauseOnLostFocus && (!this.mc.gameSettings.touchscreen || !Mouse.isButtonDown(1))) {
            if (Minecraft.getSystemTime() - this.prevFrameTime > 500L) {
                this.mc.displayInGameMenu();
            }
        }
        else {
            this.prevFrameTime = Minecraft.getSystemTime();
        }
        this.mc.mcProfiler.startSection("mouse");
        if (lllllllllllllllIIIlIIIIlIlIllllI && Minecraft.IS_RUNNING_ON_MAC && this.mc.inGameHasFocus && !Mouse.isInsideWindow()) {
            Mouse.setGrabbed(false);
            Mouse.setCursorPosition(Display.getWidth() / 2, Display.getHeight() / 2 - 20);
            Mouse.setGrabbed(true);
        }
        if (this.mc.inGameHasFocus && lllllllllllllllIIIlIIIIlIlIllllI) {
            this.mc.mouseHelper.mouseXYChange();
            this.mc.func_193032_ao().func_193299_a(this.mc.mouseHelper);
            final float lllllllllllllllIIIlIIIIlIlIlllIl = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float lllllllllllllllIIIlIIIIlIlIlllII = lllllllllllllllIIIlIIIIlIlIlllIl * lllllllllllllllIIIlIIIIlIlIlllIl * lllllllllllllllIIIlIIIIlIlIlllIl * 8.0f;
            float lllllllllllllllIIIlIIIIlIlIllIll = this.mc.mouseHelper.deltaX * lllllllllllllllIIIlIIIIlIlIlllII;
            float lllllllllllllllIIIlIIIIlIlIllIlI = this.mc.mouseHelper.deltaY * lllllllllllllllIIIlIIIIlIlIlllII;
            int lllllllllllllllIIIlIIIIlIlIllIIl = 1;
            if (this.mc.gameSettings.invertMouse) {
                lllllllllllllllIIIlIIIIlIlIllIIl = -1;
            }
            if (this.mc.gameSettings.smoothCamera) {
                this.smoothCamYaw += lllllllllllllllIIIlIIIIlIlIllIll;
                this.smoothCamPitch += lllllllllllllllIIIlIIIIlIlIllIlI;
                final float lllllllllllllllIIIlIIIIlIlIllIII = lllllllllllllllIIIlIIIIlIlIIlIIl - this.smoothCamPartialTicks;
                this.smoothCamPartialTicks = lllllllllllllllIIIlIIIIlIlIIlIIl;
                lllllllllllllllIIIlIIIIlIlIllIll = this.smoothCamFilterX * lllllllllllllllIIIlIIIIlIlIllIII;
                lllllllllllllllIIIlIIIIlIlIllIlI = this.smoothCamFilterY * lllllllllllllllIIIlIIIIlIlIllIII;
                this.mc.player.setAngles(lllllllllllllllIIIlIIIIlIlIllIll, lllllllllllllllIIIlIIIIlIlIllIlI * lllllllllllllllIIIlIIIIlIlIllIIl);
            }
            else {
                this.smoothCamYaw = 0.0f;
                this.smoothCamPitch = 0.0f;
                this.mc.player.setAngles(lllllllllllllllIIIlIIIIlIlIllIll, lllllllllllllllIIIlIIIIlIlIllIlI * lllllllllllllllIIIlIIIIlIlIllIIl);
            }
        }
        this.mc.mcProfiler.endSection();
        if (!this.mc.skipRenderWorld) {
            EntityRenderer.anaglyphEnable = this.mc.gameSettings.anaglyph;
            final ScaledResolution lllllllllllllllIIIlIIIIlIlIlIlll = new ScaledResolution(this.mc);
            final int lllllllllllllllIIIlIIIIlIlIlIllI = lllllllllllllllIIIlIIIIlIlIlIlll.getScaledWidth();
            final int lllllllllllllllIIIlIIIIlIlIlIlIl = lllllllllllllllIIIlIIIIlIlIlIlll.getScaledHeight();
            final int lllllllllllllllIIIlIIIIlIlIlIlII = Mouse.getX() * lllllllllllllllIIIlIIIIlIlIlIllI / this.mc.displayWidth;
            final int lllllllllllllllIIIlIIIIlIlIlIIll = lllllllllllllllIIIlIIIIlIlIlIlIl - Mouse.getY() * lllllllllllllllIIIlIIIIlIlIlIlIl / this.mc.displayHeight - 1;
            final int lllllllllllllllIIIlIIIIlIlIlIIlI = this.mc.gameSettings.limitFramerate;
            if (this.mc.world == null) {
                GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
                GlStateManager.matrixMode(5889);
                GlStateManager.loadIdentity();
                GlStateManager.matrixMode(5888);
                GlStateManager.loadIdentity();
                this.setupOverlayRendering();
                this.renderEndNanoTime = System.nanoTime();
                TileEntityRendererDispatcher.instance.renderEngine = this.mc.getTextureManager();
                TileEntityRendererDispatcher.instance.fontRenderer = this.mc.fontRendererObj;
            }
            else {
                this.mc.mcProfiler.startSection("level");
                int lllllllllllllllIIIlIIIIlIlIlIIIl = Math.min(Minecraft.getDebugFPS(), lllllllllllllllIIIlIIIIlIlIlIIlI);
                lllllllllllllllIIIlIIIIlIlIlIIIl = Math.max(lllllllllllllllIIIlIIIIlIlIlIIIl, 60);
                final long lllllllllllllllIIIlIIIIlIlIlIIII = System.nanoTime() - lllllllllllllllIIIlIIIIlIlIIlIII;
                final long lllllllllllllllIIIlIIIIlIlIIllll = Math.max(1000000000 / lllllllllllllllIIIlIIIIlIlIlIIIl / 4 - lllllllllllllllIIIlIIIIlIlIlIIII, 0L);
                this.renderWorld(lllllllllllllllIIIlIIIIlIlIIlIIl, System.nanoTime() + lllllllllllllllIIIlIIIIlIlIIllll);
                if (this.mc.isSingleplayer() && this.timeWorldIcon < Minecraft.getSystemTime() - 1000L) {
                    this.timeWorldIcon = Minecraft.getSystemTime();
                    if (!this.mc.getIntegratedServer().isWorldIconSet()) {
                        this.createWorldIcon();
                    }
                }
                if (OpenGlHelper.shadersSupported) {
                    this.mc.renderGlobal.renderEntityOutlineFramebuffer();
                    if (this.theShaderGroup != null && this.useShader) {
                        GlStateManager.matrixMode(5890);
                        GlStateManager.pushMatrix();
                        GlStateManager.loadIdentity();
                        this.theShaderGroup.loadShaderGroup(lllllllllllllllIIIlIIIIlIlIIlIIl);
                        GlStateManager.popMatrix();
                    }
                    this.mc.getFramebuffer().bindFramebuffer(true);
                }
                this.renderEndNanoTime = System.nanoTime();
                this.mc.mcProfiler.endStartSection("gui");
                if (!this.mc.gameSettings.hideGUI || this.mc.currentScreen != null) {
                    GlStateManager.alphaFunc(516, 0.1f);
                    this.setupOverlayRendering();
                    this.func_190563_a(lllllllllllllllIIIlIIIIlIlIlIllI, lllllllllllllllIIIlIIIIlIlIlIlIl, lllllllllllllllIIIlIIIIlIlIIlIIl);
                    this.mc.ingameGUI.renderGameOverlay(lllllllllllllllIIIlIIIIlIlIIlIIl);
                    if (this.mc.gameSettings.ofShowFps && !this.mc.gameSettings.showDebugInfo) {
                        Config.drawFps();
                    }
                    if (this.mc.gameSettings.showDebugInfo) {
                        Lagometer.showLagometer(lllllllllllllllIIIlIIIIlIlIlIlll);
                    }
                }
                this.mc.mcProfiler.endSection();
            }
            if (this.mc.currentScreen != null) {
                GlStateManager.clear(256);
                try {
                    if (Reflector.ForgeHooksClient_drawScreen.exists()) {
                        Reflector.callVoid(Reflector.ForgeHooksClient_drawScreen, this.mc.currentScreen, lllllllllllllllIIIlIIIIlIlIlIlII, lllllllllllllllIIIlIIIIlIlIlIIll, this.mc.func_193989_ak());
                    }
                    else {
                        this.mc.currentScreen.drawScreen(lllllllllllllllIIIlIIIIlIlIlIlII, lllllllllllllllIIIlIIIIlIlIlIIll, this.mc.func_193989_ak());
                    }
                }
                catch (Throwable lllllllllllllllIIIlIIIIlIlIIlllI) {
                    final CrashReport lllllllllllllllIIIlIIIIlIlIIllIl = CrashReport.makeCrashReport(lllllllllllllllIIIlIIIIlIlIIlllI, "Rendering screen");
                    final CrashReportCategory lllllllllllllllIIIlIIIIlIlIIllII = lllllllllllllllIIIlIIIIlIlIIllIl.makeCategory("Screen render details");
                    lllllllllllllllIIIlIIIIlIlIIllII.setDetail("Screen name", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return EntityRenderer.this.mc.currentScreen.getClass().getCanonicalName();
                        }
                    });
                    lllllllllllllllIIIlIIIIlIlIIllII.setDetail("Mouse location", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d)", lllllllllllllllIIIlIIIIlIlIlIlII, lllllllllllllllIIIlIIIIlIlIlIIll, Mouse.getX(), Mouse.getY());
                        }
                    });
                    lllllllllllllllIIIlIIIIlIlIIllII.setDetail("Screen size", new ICrashReportDetail<String>() {
                        @Override
                        public String call() throws Exception {
                            return String.format("Scaled: (%d, %d). Absolute: (%d, %d). Scale factor of %d", lllllllllllllllIIIlIIIIlIlIlIlll.getScaledWidth(), lllllllllllllllIIIlIIIIlIlIlIlll.getScaledHeight(), EntityRenderer.this.mc.displayWidth, EntityRenderer.this.mc.displayHeight, lllllllllllllllIIIlIIIIlIlIlIlll.getScaleFactor());
                        }
                    });
                    throw new ReportedException(lllllllllllllllIIIlIIIIlIlIIllIl);
                }
            }
        }
        final ScaledResolution lllllllllllllllIIIlIIIIlIlIIlIll = new ScaledResolution(this.mc);
        if (Main.moduleManager.getModule(Notifications.class).isToggled()) {
            NotificationPublisher.publish(lllllllllllllllIIIlIIIIlIlIIlIll);
        }
        this.frameFinish();
        this.waitForServerThread();
        Lagometer.updateLagometer();
        if (this.mc.gameSettings.ofProfiler) {
            this.mc.gameSettings.showDebugProfilerChart = true;
        }
    }
    
    private void hurtCameraEffect(final float lllllllllllllllIIIlIIIlIIlllllIl) {
        if (Main.moduleManager.getModuleByName("CameraClip").isToggled()) {
            if (this.mc.getRenderViewEntity() instanceof EntityLivingBase) {
                final EntityLivingBase lllllllllllllllIIIlIIIlIIlllllII = (EntityLivingBase)this.mc.getRenderViewEntity();
                float lllllllllllllllIIIlIIIlIIllllIll = lllllllllllllllIIIlIIIlIIlllllII.hurtTime - lllllllllllllllIIIlIIIlIIlllllIl;
                if (lllllllllllllllIIIlIIIlIIlllllII.getHealth() <= 0.0f) {
                    final float lllllllllllllllIIIlIIIlIIllllIlI = lllllllllllllllIIIlIIIlIIlllllII.deathTime + lllllllllllllllIIIlIIIlIIlllllIl;
                    GlStateManager.rotate(40.0f - 8000.0f / (lllllllllllllllIIIlIIIlIIllllIlI + 200.0f), 0.0f, 0.0f, 1.0f);
                }
                if (lllllllllllllllIIIlIIIlIIllllIll < 0.0f) {
                    return;
                }
                lllllllllllllllIIIlIIIlIIllllIll /= lllllllllllllllIIIlIIIlIIlllllII.maxHurtTime;
                lllllllllllllllIIIlIIIlIIllllIll = MathHelper.sin(lllllllllllllllIIIlIIIlIIllllIll * lllllllllllllllIIIlIIIlIIllllIll * lllllllllllllllIIIlIIIlIIllllIll * lllllllllllllllIIIlIIIlIIllllIll * 3.1415927f);
                final float lllllllllllllllIIIlIIIlIIllllIIl = lllllllllllllllIIIlIIIlIIlllllII.attackedAtYaw;
                GlStateManager.rotate(-lllllllllllllllIIIlIIIlIIllllIIl, 0.0f, 1.0f, 0.0f);
                GlStateManager.rotate((float)(-lllllllllllllllIIIlIIIlIIllllIll * Main.settingsManager.getSettingByName("HurtEffect").getValDouble()), 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(lllllllllllllllIIIlIIIlIIllllIIl, 0.0f, 1.0f, 0.0f);
            }
        }
        else if (this.mc.getRenderViewEntity() instanceof EntityLivingBase) {
            final EntityLivingBase lllllllllllllllIIIlIIIlIIllllIII = (EntityLivingBase)this.mc.getRenderViewEntity();
            float lllllllllllllllIIIlIIIlIIlllIlll = lllllllllllllllIIIlIIIlIIllllIII.hurtTime - lllllllllllllllIIIlIIIlIIlllllIl;
            if (lllllllllllllllIIIlIIIlIIllllIII.getHealth() <= 0.0f) {
                final float lllllllllllllllIIIlIIIlIIlllIlIl = lllllllllllllllIIIlIIIlIIllllIII.deathTime + lllllllllllllllIIIlIIIlIIlllllIl;
                GlStateManager.rotate(40.0f - 8000.0f / (lllllllllllllllIIIlIIIlIIlllIlIl + 200.0f), 0.0f, 0.0f, 1.0f);
            }
            if (lllllllllllllllIIIlIIIlIIlllIlll < 0.0f) {
                return;
            }
            lllllllllllllllIIIlIIIlIIlllIlll /= lllllllllllllllIIIlIIIlIIllllIII.maxHurtTime;
            lllllllllllllllIIIlIIIlIIlllIlll = MathHelper.sin(lllllllllllllllIIIlIIIlIIlllIlll * lllllllllllllllIIIlIIIlIIlllIlll * lllllllllllllllIIIlIIIlIIlllIlll * lllllllllllllllIIIlIIIlIIlllIlll * 3.1415927f);
            final float lllllllllllllllIIIlIIIlIIlllIlII = lllllllllllllllIIIlIIIlIIllllIII.attackedAtYaw;
            GlStateManager.rotate(-lllllllllllllllIIIlIIIlIIlllIlII, 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(-lllllllllllllllIIIlIIIlIIlllIlll * 14.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(lllllllllllllllIIIlIIIlIIlllIlII, 0.0f, 1.0f, 0.0f);
        }
    }
    
    private void checkLoadVisibleChunks(final Entity lllllllllllllllIIIIlllllIIlIlIII, final float lllllllllllllllIIIIlllllIIlIIIII, final ICamera lllllllllllllllIIIIlllllIIlIIllI, final boolean lllllllllllllllIIIIlllllIIIllllI) {
        final int lllllllllllllllIIIIlllllIIlIIlII = 201435902;
        if (this.loadVisibleChunks) {
            this.loadVisibleChunks = false;
            this.loadAllVisibleChunks(lllllllllllllllIIIIlllllIIlIlIII, lllllllllllllllIIIIlllllIIlIIIII, lllllllllllllllIIIIlllllIIlIIllI, lllllllllllllllIIIIlllllIIIllllI);
            this.mc.ingameGUI.getChatGUI().deleteChatLine(lllllllllllllllIIIIlllllIIlIIlII);
        }
        if (Keyboard.isKeyDown(61) && Keyboard.isKeyDown(38)) {
            if (this.mc.gameSettings.field_194146_ao.getKeyCode() == 38) {
                if (this.mc.currentScreen instanceof GuiScreenAdvancements) {
                    this.mc.displayGuiScreen(null);
                }
                while (Keyboard.next()) {}
            }
            if (this.mc.currentScreen != null) {
                return;
            }
            this.loadVisibleChunks = true;
            final TextComponentString lllllllllllllllIIIIlllllIIlIIIll = new TextComponentString(I18n.format("of.message.loadingVisibleChunks", new Object[0]));
            this.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(lllllllllllllllIIIIlllllIIlIIIll, lllllllllllllllIIIIlllllIIlIIlII);
            Reflector.Minecraft_actionKeyF3.setValue(this.mc, Boolean.TRUE);
        }
    }
    
    public void disableLightmap() {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.disableLightmap();
        }
    }
    
    public boolean isShaderActive() {
        return OpenGlHelper.shadersSupported && this.theShaderGroup != null;
    }
    
    public void loadShader(final ResourceLocation lllllllllllllllIIIlIIIllIIIIllll) {
        if (OpenGlHelper.isFramebufferEnabled()) {
            try {
                this.theShaderGroup = new ShaderGroup(this.mc.getTextureManager(), this.resourceManager, this.mc.getFramebuffer(), lllllllllllllllIIIlIIIllIIIIllll);
                this.theShaderGroup.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.useShader = true;
            }
            catch (IOException lllllllllllllllIIIlIIIllIIIIlllI) {
                EntityRenderer.LOGGER.warn("Failed to load shader: {}", (Object)lllllllllllllllIIIlIIIllIIIIllll, (Object)lllllllllllllllIIIlIIIllIIIIlllI);
                this.shaderIndex = EntityRenderer.SHADER_COUNT;
                this.useShader = false;
            }
            catch (JsonSyntaxException lllllllllllllllIIIlIIIllIIIIllIl) {
                EntityRenderer.LOGGER.warn("Failed to load shader: {}", (Object)lllllllllllllllIIIlIIIllIIIIllll, (Object)lllllllllllllllIIIlIIIllIIIIllIl);
                this.shaderIndex = EntityRenderer.SHADER_COUNT;
                this.useShader = false;
            }
        }
    }
    
    public void setupOverlayRendering() {
        final ScaledResolution lllllllllllllllIIIIlllllllllllIl = new ScaledResolution(this.mc);
        GlStateManager.clear(256);
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, lllllllllllllllIIIIlllllllllllIl.getScaledWidth_double(), lllllllllllllllIIIIlllllllllllIl.getScaledHeight_double(), 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
    }
    
    private void func_190563_a(final int lllllllllllllllIIIIllllIIIlIlIIl, final int lllllllllllllllIIIIllllIIIIllIll, final float lllllllllllllllIIIIllllIIIIllIlI) {
        if (this.field_190566_ab != null && this.field_190567_ac > 0) {
            final int lllllllllllllllIIIIllllIIIlIIllI = 40 - this.field_190567_ac;
            final float lllllllllllllllIIIIllllIIIlIIlIl = (lllllllllllllllIIIIllllIIIlIIllI + lllllllllllllllIIIIllllIIIIllIlI) / 40.0f;
            final float lllllllllllllllIIIIllllIIIlIIlII = lllllllllllllllIIIIllllIIIlIIlIl * lllllllllllllllIIIIllllIIIlIIlIl;
            final float lllllllllllllllIIIIllllIIIlIIIll = lllllllllllllllIIIIllllIIIlIIlIl * lllllllllllllllIIIIllllIIIlIIlII;
            final float lllllllllllllllIIIIllllIIIlIIIlI = 10.25f * lllllllllllllllIIIIllllIIIlIIIll * lllllllllllllllIIIIllllIIIlIIlII + -24.95f * lllllllllllllllIIIIllllIIIlIIlII * lllllllllllllllIIIIllllIIIlIIlII + 25.5f * lllllllllllllllIIIIllllIIIlIIIll + -13.8f * lllllllllllllllIIIIllllIIIlIIlII + 4.0f * lllllllllllllllIIIIllllIIIlIIlIl;
            final float lllllllllllllllIIIIllllIIIlIIIIl = lllllllllllllllIIIIllllIIIlIIIlI * 3.1415927f;
            final float lllllllllllllllIIIIllllIIIlIIIII = this.field_190568_ad * (lllllllllllllllIIIIllllIIIlIlIIl / 4);
            final float lllllllllllllllIIIIllllIIIIlllll = this.field_190569_ae * (lllllllllllllllIIIIllllIIIIllIll / 4);
            GlStateManager.enableAlpha();
            GlStateManager.pushMatrix();
            GlStateManager.pushAttrib();
            GlStateManager.enableDepth();
            GlStateManager.disableCull();
            RenderHelper.enableStandardItemLighting();
            GlStateManager.translate(lllllllllllllllIIIIllllIIIlIlIIl / 2 + lllllllllllllllIIIIllllIIIlIIIII * MathHelper.abs(MathHelper.sin(lllllllllllllllIIIIllllIIIlIIIIl * 2.0f)), lllllllllllllllIIIIllllIIIIllIll / 2 + lllllllllllllllIIIIllllIIIIlllll * MathHelper.abs(MathHelper.sin(lllllllllllllllIIIIllllIIIlIIIIl * 2.0f)), -50.0f);
            final float lllllllllllllllIIIIllllIIIIllllI = 50.0f + 175.0f * MathHelper.sin(lllllllllllllllIIIIllllIIIlIIIIl);
            GlStateManager.scale(lllllllllllllllIIIIllllIIIIllllI, -lllllllllllllllIIIIllllIIIIllllI, lllllllllllllllIIIIllllIIIIllllI);
            GlStateManager.rotate(900.0f * MathHelper.abs(MathHelper.sin(lllllllllllllllIIIIllllIIIlIIIIl)), 0.0f, 1.0f, 0.0f);
            GlStateManager.rotate(6.0f * MathHelper.cos(lllllllllllllllIIIIllllIIIlIIlIl * 8.0f), 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(6.0f * MathHelper.cos(lllllllllllllllIIIIllllIIIlIIlIl * 8.0f), 0.0f, 0.0f, 1.0f);
            this.mc.getRenderItem().renderItem(this.field_190566_ab, ItemCameraTransforms.TransformType.FIXED);
            GlStateManager.popAttrib();
            GlStateManager.popMatrix();
            RenderHelper.disableStandardItemLighting();
            GlStateManager.enableCull();
            GlStateManager.disableDepth();
        }
    }
    
    public void loadEntityShader(@Nullable final Entity lllllllllllllllIIIlIIIllIIIlIllI) {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.deleteShaderGroup();
            }
            this.theShaderGroup = null;
            if (lllllllllllllllIIIlIIIllIIIlIllI instanceof EntityCreeper) {
                this.loadShader(new ResourceLocation("shaders/post/creeper.json"));
            }
            else if (lllllllllllllllIIIlIIIllIIIlIllI instanceof EntitySpider) {
                this.loadShader(new ResourceLocation("shaders/post/spider.json"));
            }
            else if (lllllllllllllllIIIlIIIllIIIlIllI instanceof EntityEnderman) {
                this.loadShader(new ResourceLocation("shaders/post/invert.json"));
            }
            else if (Reflector.ForgeHooksClient_loadEntityShader.exists()) {
                Reflector.call(Reflector.ForgeHooksClient_loadEntityShader, lllllllllllllllIIIlIIIllIIIlIllI, this);
            }
        }
    }
    
    public void func_190565_a(final ItemStack lllllllllllllllIIIIllllIIIlllIlI) {
        this.field_190566_ab = lllllllllllllllIIIIllllIIIlllIlI;
        this.field_190567_ac = 40;
        this.field_190568_ad = this.random.nextFloat() * 2.0f - 1.0f;
        this.field_190569_ae = this.random.nextFloat() * 2.0f - 1.0f;
    }
    
    public void renderWorld(final float lllllllllllllllIIIlIIIIlIIIIIIll, final long lllllllllllllllIIIlIIIIlIIIIIlIl) {
        this.updateLightmap(lllllllllllllllIIIlIIIIlIIIIIIll);
        if (this.mc.getRenderViewEntity() == null) {
            this.mc.setRenderViewEntity(this.mc.player);
        }
        this.getMouseOver(lllllllllllllllIIIlIIIIlIIIIIIll);
        if (Config.isShaders()) {
            Shaders.beginRender(this.mc, lllllllllllllllIIIlIIIIlIIIIIIll, lllllllllllllllIIIlIIIIlIIIIIlIl);
        }
        GlStateManager.enableDepth();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1f);
        this.mc.mcProfiler.startSection("center");
        if (this.mc.gameSettings.anaglyph) {
            EntityRenderer.anaglyphField = 0;
            GlStateManager.colorMask(false, true, true, false);
            this.renderWorldPass(0, lllllllllllllllIIIlIIIIlIIIIIIll, lllllllllllllllIIIlIIIIlIIIIIlIl);
            EntityRenderer.anaglyphField = 1;
            GlStateManager.colorMask(true, false, false, false);
            this.renderWorldPass(1, lllllllllllllllIIIlIIIIlIIIIIIll, lllllllllllllllIIIlIIIIlIIIIIlIl);
            GlStateManager.colorMask(true, true, true, false);
        }
        else {
            this.renderWorldPass(2, lllllllllllllllIIIlIIIIlIIIIIIll, lllllllllllllllIIIlIIIIlIIIIIlIl);
        }
        this.mc.mcProfiler.endSection();
    }
    
    public void setupCameraTransform(final float lllllllllllllllIIIlIIIIlllllIllI, final int lllllllllllllllIIIlIIIIlllllllII) {
        this.farPlaneDistance = (float)(this.mc.gameSettings.renderDistanceChunks * 16);
        if (Config.isFogFancy()) {
            this.farPlaneDistance *= 0.95f;
        }
        if (Config.isFogFast()) {
            this.farPlaneDistance *= 0.83f;
        }
        GlStateManager.matrixMode(5889);
        GlStateManager.loadIdentity();
        final float lllllllllllllllIIIlIIIIllllllIll = 0.07f;
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate(-(lllllllllllllllIIIlIIIIlllllllII * 2 - 1) * 0.07f, 0.0f, 0.0f);
        }
        this.clipDistance = this.farPlaneDistance * 2.0f;
        if (this.clipDistance < 173.0f) {
            this.clipDistance = 173.0f;
        }
        if (this.cameraZoom != 1.0) {
            GlStateManager.translate((float)this.cameraYaw, (float)(-this.cameraPitch), 0.0f);
            GlStateManager.scale(this.cameraZoom, this.cameraZoom, 1.0);
        }
        Project.gluPerspective(this.getFOVModifier(lllllllllllllllIIIlIIIIlllllIllI, true), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.clipDistance);
        GlStateManager.matrixMode(5888);
        GlStateManager.loadIdentity();
        if (this.mc.gameSettings.anaglyph) {
            GlStateManager.translate((lllllllllllllllIIIlIIIIlllllllII * 2 - 1) * 0.1f, 0.0f, 0.0f);
        }
        this.hurtCameraEffect(lllllllllllllllIIIlIIIIlllllIllI);
        if (this.mc.gameSettings.viewBobbing) {
            this.setupViewBobbing(lllllllllllllllIIIlIIIIlllllIllI);
        }
        final float lllllllllllllllIIIlIIIIllllllIlI = this.mc.player.prevTimeInPortal + (this.mc.player.timeInPortal - this.mc.player.prevTimeInPortal) * lllllllllllllllIIIlIIIIlllllIllI;
        if (lllllllllllllllIIIlIIIIllllllIlI > 0.0f) {
            int lllllllllllllllIIIlIIIIllllllIIl = 20;
            if (this.mc.player.isPotionActive(MobEffects.NAUSEA)) {
                lllllllllllllllIIIlIIIIllllllIIl = 7;
            }
            float lllllllllllllllIIIlIIIIllllllIII = 5.0f / (lllllllllllllllIIIlIIIIllllllIlI * lllllllllllllllIIIlIIIIllllllIlI + 5.0f) - lllllllllllllllIIIlIIIIllllllIlI * 0.04f;
            lllllllllllllllIIIlIIIIllllllIII *= lllllllllllllllIIIlIIIIllllllIII;
            GlStateManager.rotate((this.rendererUpdateCount + lllllllllllllllIIIlIIIIlllllIllI) * lllllllllllllllIIIlIIIIllllllIIl, 0.0f, 1.0f, 1.0f);
            GlStateManager.scale(1.0f / lllllllllllllllIIIlIIIIllllllIII, 1.0f, 1.0f);
            GlStateManager.rotate(-(this.rendererUpdateCount + lllllllllllllllIIIlIIIIlllllIllI) * lllllllllllllllIIIlIIIIllllllIIl, 0.0f, 1.0f, 1.0f);
        }
        this.orientCamera(lllllllllllllllIIIlIIIIlllllIllI);
        if (this.debugView) {
            switch (this.debugViewDirection) {
                case 0: {
                    GlStateManager.rotate(90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 1: {
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 2: {
                    GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 3: {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    break;
                }
                case 4: {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                    break;
                }
            }
        }
    }
    
    public void getMouseOver(final float lllllllllllllllIIIlIIIlIllIIlIlI) {
        final Entity lllllllllllllllIIIlIIIlIllIIlIIl = this.mc.getRenderViewEntity();
        if (lllllllllllllllIIIlIIIlIllIIlIIl != null && this.mc.world != null) {
            this.mc.mcProfiler.startSection("pick");
            this.mc.pointedEntity = null;
            double lllllllllllllllIIIlIIIlIllIIlIII = this.mc.playerController.getBlockReachDistance();
            this.mc.objectMouseOver = lllllllllllllllIIIlIIIlIllIIlIIl.rayTrace(lllllllllllllllIIIlIIIlIllIIlIII, lllllllllllllllIIIlIIIlIllIIlIlI);
            final Vec3d lllllllllllllllIIIlIIIlIllIIIlll = lllllllllllllllIIIlIIIlIllIIlIIl.getPositionEyes(lllllllllllllllIIIlIIIlIllIIlIlI);
            boolean lllllllllllllllIIIlIIIlIllIIIllI = false;
            final int lllllllllllllllIIIlIIIlIllIIIlIl = 3;
            double lllllllllllllllIIIlIIIlIllIIIlII = lllllllllllllllIIIlIIIlIllIIlIII;
            if (this.mc.playerController.extendedReach()) {
                lllllllllllllllIIIlIIIlIllIIIlII = (lllllllllllllllIIIlIIIlIllIIlIII = 6.0);
            }
            else if (lllllllllllllllIIIlIIIlIllIIlIII > 3.0) {
                lllllllllllllllIIIlIIIlIllIIIllI = true;
            }
            if (this.mc.objectMouseOver != null) {
                lllllllllllllllIIIlIIIlIllIIIlII = this.mc.objectMouseOver.hitVec.distanceTo(lllllllllllllllIIIlIIIlIllIIIlll);
            }
            final Vec3d lllllllllllllllIIIlIIIlIllIIIIll = lllllllllllllllIIIlIIIlIllIIlIIl.getLook(1.0f);
            final Vec3d lllllllllllllllIIIlIIIlIllIIIIlI = lllllllllllllllIIIlIIIlIllIIIlll.addVector(lllllllllllllllIIIlIIIlIllIIIIll.xCoord * lllllllllllllllIIIlIIIlIllIIlIII, lllllllllllllllIIIlIIIlIllIIIIll.yCoord * lllllllllllllllIIIlIIIlIllIIlIII, lllllllllllllllIIIlIIIlIllIIIIll.zCoord * lllllllllllllllIIIlIIIlIllIIlIII);
            this.pointedEntity = null;
            Vec3d lllllllllllllllIIIlIIIlIllIIIIIl = null;
            final float lllllllllllllllIIIlIIIlIllIIIIII = 1.0f;
            final List<Entity> lllllllllllllllIIIlIIIlIlIllllll = this.mc.world.getEntitiesInAABBexcluding(lllllllllllllllIIIlIIIlIllIIlIIl, lllllllllllllllIIIlIIIlIllIIlIIl.getEntityBoundingBox().addCoord(lllllllllllllllIIIlIIIlIllIIIIll.xCoord * lllllllllllllllIIIlIIIlIllIIlIII, lllllllllllllllIIIlIIIlIllIIIIll.yCoord * lllllllllllllllIIIlIIIlIllIIlIII, lllllllllllllllIIIlIIIlIllIIIIll.zCoord * lllllllllllllllIIIlIIIlIllIIlIII).expand(1.0, 1.0, 1.0), (Predicate<? super Entity>)Predicates.and((Predicate)EntitySelectors.NOT_SPECTATING, (Predicate)new Predicate<Entity>() {
                public boolean apply(@Nullable final Entity llllllllllllllllllIIlIIllIlllllI) {
                    return llllllllllllllllllIIlIIllIlllllI != null && llllllllllllllllllIIlIIllIlllllI.canBeCollidedWith();
                }
            }));
            double lllllllllllllllIIIlIIIlIlIlllllI = lllllllllllllllIIIlIIIlIllIIIlII;
            for (int lllllllllllllllIIIlIIIlIlIllllIl = 0; lllllllllllllllIIIlIIIlIlIllllIl < lllllllllllllllIIIlIIIlIlIllllll.size(); ++lllllllllllllllIIIlIIIlIlIllllIl) {
                final Entity lllllllllllllllIIIlIIIlIlIllllII = lllllllllllllllIIIlIIIlIlIllllll.get(lllllllllllllllIIIlIIIlIlIllllIl);
                final AxisAlignedBB lllllllllllllllIIIlIIIlIlIlllIll = lllllllllllllllIIIlIIIlIlIllllII.getEntityBoundingBox().expandXyz(lllllllllllllllIIIlIIIlIlIllllII.getCollisionBorderSize());
                final RayTraceResult lllllllllllllllIIIlIIIlIlIlllIlI = lllllllllllllllIIIlIIIlIlIlllIll.calculateIntercept(lllllllllllllllIIIlIIIlIllIIIlll, lllllllllllllllIIIlIIIlIllIIIIlI);
                if (lllllllllllllllIIIlIIIlIlIlllIll.isVecInside(lllllllllllllllIIIlIIIlIllIIIlll)) {
                    if (lllllllllllllllIIIlIIIlIlIlllllI >= 0.0) {
                        this.pointedEntity = lllllllllllllllIIIlIIIlIlIllllII;
                        lllllllllllllllIIIlIIIlIllIIIIIl = ((lllllllllllllllIIIlIIIlIlIlllIlI == null) ? lllllllllllllllIIIlIIIlIllIIIlll : lllllllllllllllIIIlIIIlIlIlllIlI.hitVec);
                        lllllllllllllllIIIlIIIlIlIlllllI = 0.0;
                    }
                }
                else if (lllllllllllllllIIIlIIIlIlIlllIlI != null) {
                    final double lllllllllllllllIIIlIIIlIlIlllIIl = lllllllllllllllIIIlIIIlIllIIIlll.distanceTo(lllllllllllllllIIIlIIIlIlIlllIlI.hitVec);
                    if (lllllllllllllllIIIlIIIlIlIlllIIl < lllllllllllllllIIIlIIIlIlIlllllI || lllllllllllllllIIIlIIIlIlIlllllI == 0.0) {
                        boolean lllllllllllllllIIIlIIIlIlIlllIII = false;
                        if (Reflector.ForgeEntity_canRiderInteract.exists()) {
                            lllllllllllllllIIIlIIIlIlIlllIII = Reflector.callBoolean(lllllllllllllllIIIlIIIlIlIllllII, Reflector.ForgeEntity_canRiderInteract, new Object[0]);
                        }
                        if (!lllllllllllllllIIIlIIIlIlIlllIII && lllllllllllllllIIIlIIIlIlIllllII.getLowestRidingEntity() == lllllllllllllllIIIlIIIlIllIIlIIl.getLowestRidingEntity()) {
                            if (lllllllllllllllIIIlIIIlIlIlllllI == 0.0) {
                                this.pointedEntity = lllllllllllllllIIIlIIIlIlIllllII;
                                lllllllllllllllIIIlIIIlIllIIIIIl = lllllllllllllllIIIlIIIlIlIlllIlI.hitVec;
                            }
                        }
                        else {
                            this.pointedEntity = lllllllllllllllIIIlIIIlIlIllllII;
                            lllllllllllllllIIIlIIIlIllIIIIIl = lllllllllllllllIIIlIIIlIlIlllIlI.hitVec;
                            lllllllllllllllIIIlIIIlIlIlllllI = lllllllllllllllIIIlIIIlIlIlllIIl;
                        }
                    }
                }
            }
            if (this.pointedEntity != null && lllllllllllllllIIIlIIIlIllIIIllI && lllllllllllllllIIIlIIIlIllIIIlll.distanceTo(lllllllllllllllIIIlIIIlIllIIIIIl) > 3.0) {
                this.pointedEntity = null;
                this.mc.objectMouseOver = new RayTraceResult(RayTraceResult.Type.MISS, lllllllllllllllIIIlIIIlIllIIIIIl, null, new BlockPos(lllllllllllllllIIIlIIIlIllIIIIIl));
            }
            if (this.pointedEntity != null && (lllllllllllllllIIIlIIIlIlIlllllI < lllllllllllllllIIIlIIIlIllIIIlII || this.mc.objectMouseOver == null)) {
                this.mc.objectMouseOver = new RayTraceResult(this.pointedEntity, lllllllllllllllIIIlIIIlIllIIIIIl);
                if (this.pointedEntity instanceof EntityLivingBase || this.pointedEntity instanceof EntityItemFrame) {
                    this.mc.pointedEntity = this.pointedEntity;
                }
            }
            this.mc.mcProfiler.endSection();
        }
    }
    
    public void updateRenderer() {
        if (OpenGlHelper.shadersSupported && ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
            ShaderLinkHelper.setNewStaticShaderLinkHelper();
        }
        this.updateFovModifierHand();
        this.updateTorchFlicker();
        this.fogColor2 = this.fogColor1;
        this.thirdPersonDistancePrev = 4.0f;
        if (this.mc.gameSettings.smoothCamera) {
            final float lllllllllllllllIIIlIIIlIllllllII = this.mc.gameSettings.mouseSensitivity * 0.6f + 0.2f;
            final float lllllllllllllllIIIlIIIlIlllllIll = lllllllllllllllIIIlIIIlIllllllII * lllllllllllllllIIIlIIIlIllllllII * lllllllllllllllIIIlIIIlIllllllII * 8.0f;
            this.smoothCamFilterX = this.mouseFilterXAxis.smooth(this.smoothCamYaw, 0.05f * lllllllllllllllIIIlIIIlIlllllIll);
            this.smoothCamFilterY = this.mouseFilterYAxis.smooth(this.smoothCamPitch, 0.05f * lllllllllllllllIIIlIIIlIlllllIll);
            this.smoothCamPartialTicks = 0.0f;
            this.smoothCamYaw = 0.0f;
            this.smoothCamPitch = 0.0f;
        }
        else {
            this.smoothCamFilterX = 0.0f;
            this.smoothCamFilterY = 0.0f;
            this.mouseFilterXAxis.reset();
            this.mouseFilterYAxis.reset();
        }
        if (this.mc.getRenderViewEntity() == null) {
            this.mc.setRenderViewEntity(this.mc.player);
        }
        final Entity lllllllllllllllIIIlIIIlIlllllIlI = this.mc.getRenderViewEntity();
        final double lllllllllllllllIIIlIIIlIlllllIIl = lllllllllllllllIIIlIIIlIlllllIlI.posX;
        final double lllllllllllllllIIIlIIIlIlllllIII = lllllllllllllllIIIlIIIlIlllllIlI.posY + lllllllllllllllIIIlIIIlIlllllIlI.getEyeHeight();
        final double lllllllllllllllIIIlIIIlIllllIlll = lllllllllllllllIIIlIIIlIlllllIlI.posZ;
        final float lllllllllllllllIIIlIIIlIllllIllI = this.mc.world.getLightBrightness(new BlockPos(lllllllllllllllIIIlIIIlIlllllIIl, lllllllllllllllIIIlIIIlIlllllIII, lllllllllllllllIIIlIIIlIllllIlll));
        float lllllllllllllllIIIlIIIlIllllIlIl = this.mc.gameSettings.renderDistanceChunks / 16.0f;
        lllllllllllllllIIIlIIIlIllllIlIl = MathHelper.clamp(lllllllllllllllIIIlIIIlIllllIlIl, 0.0f, 1.0f);
        final float lllllllllllllllIIIlIIIlIllllIlII = lllllllllllllllIIIlIIIlIllllIllI * (1.0f - lllllllllllllllIIIlIIIlIllllIlIl) + lllllllllllllllIIIlIIIlIllllIlIl;
        this.fogColor1 += (lllllllllllllllIIIlIIIlIllllIlII - this.fogColor1) * 0.1f;
        ++this.rendererUpdateCount;
        this.itemRenderer.updateEquippedItem();
        this.addRainParticles();
        this.bossColorModifierPrev = this.bossColorModifier;
        if (this.mc.ingameGUI.getBossOverlay().shouldDarkenSky()) {
            this.bossColorModifier += 0.05f;
            if (this.bossColorModifier > 1.0f) {
                this.bossColorModifier = 1.0f;
            }
        }
        else if (this.bossColorModifier > 0.0f) {
            this.bossColorModifier -= 0.0125f;
        }
        if (this.field_190567_ac > 0) {
            --this.field_190567_ac;
            if (this.field_190567_ac == 0) {
                this.field_190566_ab = null;
            }
        }
    }
    
    private void setupViewBobbing(final float lllllllllllllllIIIlIIIlIIllIIIIl) {
        if (this.mc.getRenderViewEntity() instanceof EntityPlayer) {
            final EntityPlayer lllllllllllllllIIIlIIIlIIllIIIII = (EntityPlayer)this.mc.getRenderViewEntity();
            final float lllllllllllllllIIIlIIIlIIlIlllll = lllllllllllllllIIIlIIIlIIllIIIII.distanceWalkedModified - lllllllllllllllIIIlIIIlIIllIIIII.prevDistanceWalkedModified;
            final float lllllllllllllllIIIlIIIlIIlIllllI = -(lllllllllllllllIIIlIIIlIIllIIIII.distanceWalkedModified + lllllllllllllllIIIlIIIlIIlIlllll * lllllllllllllllIIIlIIIlIIllIIIIl);
            final float lllllllllllllllIIIlIIIlIIlIlllIl = lllllllllllllllIIIlIIIlIIllIIIII.prevCameraYaw + (lllllllllllllllIIIlIIIlIIllIIIII.cameraYaw - lllllllllllllllIIIlIIIlIIllIIIII.prevCameraYaw) * lllllllllllllllIIIlIIIlIIllIIIIl;
            final float lllllllllllllllIIIlIIIlIIlIlllII = lllllllllllllllIIIlIIIlIIllIIIII.prevCameraPitch + (lllllllllllllllIIIlIIIlIIllIIIII.cameraPitch - lllllllllllllllIIIlIIIlIIllIIIII.prevCameraPitch) * lllllllllllllllIIIlIIIlIIllIIIIl;
            GlStateManager.translate(MathHelper.sin(lllllllllllllllIIIlIIIlIIlIllllI * 3.1415927f) * lllllllllllllllIIIlIIIlIIlIlllIl * 0.5f, -Math.abs(MathHelper.cos(lllllllllllllllIIIlIIIlIIlIllllI * 3.1415927f) * lllllllllllllllIIIlIIIlIIlIlllIl), 0.0f);
            GlStateManager.rotate(MathHelper.sin(lllllllllllllllIIIlIIIlIIlIllllI * 3.1415927f) * lllllllllllllllIIIlIIIlIIlIlllIl * 3.0f, 0.0f, 0.0f, 1.0f);
            GlStateManager.rotate(Math.abs(MathHelper.cos(lllllllllllllllIIIlIIIlIIlIllllI * 3.1415927f - 0.2f) * lllllllllllllllIIIlIIIlIIlIlllIl) * 5.0f, 1.0f, 0.0f, 0.0f);
            GlStateManager.rotate(lllllllllllllllIIIlIIIlIIlIlllII, 1.0f, 0.0f, 0.0f);
        }
    }
    
    public void updateShaderGroupSize(final int lllllllllllllllIIIlIIIlIlllIIIIl, final int lllllllllllllllIIIlIIIlIlllIIIll) {
        if (OpenGlHelper.shadersSupported) {
            if (this.theShaderGroup != null) {
                this.theShaderGroup.createBindFramebuffers(lllllllllllllllIIIlIIIlIlllIIIIl, lllllllllllllllIIIlIIIlIlllIIIll);
            }
            this.mc.renderGlobal.createBindEntityOutlineFbs(lllllllllllllllIIIlIIIlIlllIIIIl, lllllllllllllllIIIlIIIlIlllIIIll);
        }
    }
    
    private void createWorldIcon() {
        if (this.mc.renderGlobal.getRenderedChunks() > 10 && this.mc.renderGlobal.hasNoChunkUpdates() && !this.mc.getIntegratedServer().isWorldIconSet()) {
            final BufferedImage lllllllllllllllIIIlIIIIlIIllIIll = ScreenShotHelper.createScreenshot(this.mc.displayWidth, this.mc.displayHeight, this.mc.getFramebuffer());
            int lllllllllllllllIIIlIIIIlIIllIIlI = lllllllllllllllIIIlIIIIlIIllIIll.getWidth();
            final int lllllllllllllllIIIlIIIIlIIllIIIl = lllllllllllllllIIIlIIIIlIIllIIll.getHeight();
            int lllllllllllllllIIIlIIIIlIIllIIII = 0;
            int lllllllllllllllIIIlIIIIlIIlIllll = 0;
            if (lllllllllllllllIIIlIIIIlIIllIIlI > lllllllllllllllIIIlIIIIlIIllIIIl) {
                lllllllllllllllIIIlIIIIlIIllIIII = (lllllllllllllllIIIlIIIIlIIllIIlI - lllllllllllllllIIIlIIIIlIIllIIIl) / 2;
                lllllllllllllllIIIlIIIIlIIllIIlI = lllllllllllllllIIIlIIIIlIIllIIIl;
            }
            else {
                lllllllllllllllIIIlIIIIlIIlIllll = (lllllllllllllllIIIlIIIIlIIllIIIl - lllllllllllllllIIIlIIIIlIIllIIlI) / 2;
            }
            try {
                final BufferedImage lllllllllllllllIIIlIIIIlIIlIlllI = new BufferedImage(64, 64, 1);
                final Graphics lllllllllllllllIIIlIIIIlIIlIllIl = lllllllllllllllIIIlIIIIlIIlIlllI.createGraphics();
                lllllllllllllllIIIlIIIIlIIlIllIl.drawImage(lllllllllllllllIIIlIIIIlIIllIIll, 0, 0, 64, 64, lllllllllllllllIIIlIIIIlIIllIIII, lllllllllllllllIIIlIIIIlIIlIllll, lllllllllllllllIIIlIIIIlIIllIIII + lllllllllllllllIIIlIIIIlIIllIIlI, lllllllllllllllIIIlIIIIlIIlIllll + lllllllllllllllIIIlIIIIlIIllIIlI, null);
                lllllllllllllllIIIlIIIIlIIlIllIl.dispose();
                ImageIO.write(lllllllllllllllIIIlIIIIlIIlIlllI, "png", this.mc.getIntegratedServer().getWorldIconFile());
            }
            catch (IOException lllllllllllllllIIIlIIIIlIIlIllII) {
                EntityRenderer.LOGGER.warn("Couldn't save auto screenshot", (Throwable)lllllllllllllllIIIlIIIIlIIlIllII);
            }
        }
    }
    
    public void enableLightmap() {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.matrixMode(5890);
        GlStateManager.loadIdentity();
        final float lllllllllllllllIIIlIIIIlllIIlIII = 0.00390625f;
        GlStateManager.scale(0.00390625f, 0.00390625f, 0.00390625f);
        GlStateManager.translate(8.0f, 8.0f, 8.0f);
        GlStateManager.matrixMode(5888);
        this.mc.getTextureManager().bindTexture(this.locationLightMap);
        GlStateManager.glTexParameteri(3553, 10241, 9729);
        GlStateManager.glTexParameteri(3553, 10240, 9729);
        GlStateManager.glTexParameteri(3553, 10242, 10496);
        GlStateManager.glTexParameteri(3553, 10243, 10496);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.enableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
        if (Config.isShaders()) {
            Shaders.enableLightmap();
        }
    }
    
    public void stopUseShader() {
        if (this.theShaderGroup != null) {
            this.theShaderGroup.deleteShaderGroup();
        }
        this.theShaderGroup = null;
        this.shaderIndex = EntityRenderer.SHADER_COUNT;
    }
    
    static {
        LOGGER = LogManager.getLogger();
        RAIN_TEXTURES = new ResourceLocation("textures/environment/rain.png");
        SNOW_TEXTURES = new ResourceLocation("textures/environment/snow.png");
        SHADERS_TEXTURES = new ResourceLocation[] { new ResourceLocation("shaders/post/notch.json"), new ResourceLocation("shaders/post/fxaa.json"), new ResourceLocation("shaders/post/art.json"), new ResourceLocation("shaders/post/bumpy.json"), new ResourceLocation("shaders/post/blobs2.json"), new ResourceLocation("shaders/post/pencil.json"), new ResourceLocation("shaders/post/color_convolve.json"), new ResourceLocation("shaders/post/deconverge.json"), new ResourceLocation("shaders/post/flip.json"), new ResourceLocation("shaders/post/invert.json"), new ResourceLocation("shaders/post/ntsc.json"), new ResourceLocation("shaders/post/outline.json"), new ResourceLocation("shaders/post/phosphor.json"), new ResourceLocation("shaders/post/scan_pincushion.json"), new ResourceLocation("shaders/post/sobel.json"), new ResourceLocation("shaders/post/bits.json"), new ResourceLocation("shaders/post/desaturate.json"), new ResourceLocation("shaders/post/green.json"), new ResourceLocation("shaders/post/blur.json"), new ResourceLocation("shaders/post/wobble.json"), new ResourceLocation("shaders/post/blobs.json"), new ResourceLocation("shaders/post/antialias.json"), new ResourceLocation("shaders/post/creeper.json"), new ResourceLocation("shaders/post/spider.json") };
        SHADER_COUNT = EntityRenderer.SHADERS_TEXTURES.length;
    }
    
    public void renderHand(final float lllllllllllllllIIIlIIIIlllIlllIl, final int lllllllllllllllIIIlIIIIlllIlIIll, final boolean lllllllllllllllIIIlIIIIlllIlIIlI, final boolean lllllllllllllllIIIlIIIIlllIllIlI, final boolean lllllllllllllllIIIlIIIIlllIllIIl) {
        if (!this.debugView) {
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            final float lllllllllllllllIIIlIIIIlllIllIII = 0.07f;
            if (this.mc.gameSettings.anaglyph) {
                GlStateManager.translate(-(lllllllllllllllIIIlIIIIlllIlIIll * 2 - 1) * 0.07f, 0.0f, 0.0f);
            }
            if (Config.isShaders()) {
                Shaders.applyHandDepth();
            }
            Project.gluPerspective(this.getFOVModifier(lllllllllllllllIIIlIIIIlllIlllIl, false), this.mc.displayWidth / (float)this.mc.displayHeight, 0.05f, this.farPlaneDistance * 2.0f);
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            if (this.mc.gameSettings.anaglyph) {
                GlStateManager.translate((lllllllllllllllIIIlIIIIlllIlIIll * 2 - 1) * 0.1f, 0.0f, 0.0f);
            }
            boolean lllllllllllllllIIIlIIIIlllIlIlll = false;
            if (lllllllllllllllIIIlIIIIlllIlIIlI) {
                GlStateManager.pushMatrix();
                this.hurtCameraEffect(lllllllllllllllIIIlIIIIlllIlllIl);
                if (this.mc.gameSettings.viewBobbing) {
                    this.setupViewBobbing(lllllllllllllllIIIlIIIIlllIlllIl);
                }
                lllllllllllllllIIIlIIIIlllIlIlll = (this.mc.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping());
                final boolean lllllllllllllllIIIlIIIIlllIlIllI = !ReflectorForge.renderFirstPersonHand(this.mc.renderGlobal, lllllllllllllllIIIlIIIIlllIlllIl, lllllllllllllllIIIlIIIIlllIlIIll);
                if (lllllllllllllllIIIlIIIIlllIlIllI && this.mc.gameSettings.thirdPersonView == 0 && !lllllllllllllllIIIlIIIIlllIlIlll && !this.mc.gameSettings.hideGUI && !this.mc.playerController.isSpectator()) {
                    this.enableLightmap();
                    if (Config.isShaders()) {
                        ShadersRender.renderItemFP(this.itemRenderer, lllllllllllllllIIIlIIIIlllIlllIl, lllllllllllllllIIIlIIIIlllIllIIl);
                    }
                    else {
                        this.itemRenderer.renderItemInFirstPerson(lllllllllllllllIIIlIIIIlllIlllIl);
                    }
                    this.disableLightmap();
                }
                GlStateManager.popMatrix();
            }
            if (!lllllllllllllllIIIlIIIIlllIllIlI) {
                return;
            }
            this.disableLightmap();
            if (this.mc.gameSettings.thirdPersonView == 0 && !lllllllllllllllIIIlIIIIlllIlIlll) {
                this.itemRenderer.renderOverlays(lllllllllllllllIIIlIIIIlllIlllIl);
                this.hurtCameraEffect(lllllllllllllllIIIlIIIIlllIlllIl);
            }
            if (this.mc.gameSettings.viewBobbing) {
                this.setupViewBobbing(lllllllllllllllIIIlIIIIlllIlllIl);
            }
        }
    }
    
    public void func_190564_k() {
        this.field_190566_ab = null;
        this.theMapItemRenderer.clearLoadedMaps();
    }
    
    public boolean setFxaaShader(final int lllllllllllllllIIIIlllllIIllIIll) {
        if (!OpenGlHelper.isFramebufferEnabled()) {
            return false;
        }
        if (this.theShaderGroup != null && this.theShaderGroup != this.fxaaShaders[2] && this.theShaderGroup != this.fxaaShaders[4]) {
            return true;
        }
        if (lllllllllllllllIIIIlllllIIllIIll != 2 && lllllllllllllllIIIIlllllIIllIIll != 4) {
            if (this.theShaderGroup == null) {
                return true;
            }
            this.theShaderGroup.deleteShaderGroup();
            this.theShaderGroup = null;
            return true;
        }
        else {
            if (this.theShaderGroup != null && this.theShaderGroup == this.fxaaShaders[lllllllllllllllIIIIlllllIIllIIll]) {
                return true;
            }
            if (this.mc.world == null) {
                return true;
            }
            this.loadShader(new ResourceLocation(String.valueOf(new StringBuilder("shaders/post/fxaa_of_").append(lllllllllllllllIIIIlllllIIllIIll).append("x.json"))));
            this.fxaaShaders[lllllllllllllllIIIIlllllIIllIIll] = this.theShaderGroup;
            return this.useShader;
        }
    }
}
