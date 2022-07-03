package net.minecraft.client.renderer;

import net.minecraft.client.renderer.entity.*;
import it.unimi.dsi.fastutil.longs.*;
import net.minecraft.client.*;
import net.minecraft.world.chunk.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.block.material.*;
import net.minecraft.block.state.*;
import org.lwjgl.input.*;
import net.minecraft.entity.*;
import net.minecraft.world.border.*;
import javax.annotation.*;
import net.minecraft.client.audio.*;
import shadersmod.client.*;
import org.lwjgl.util.vector.*;
import net.minecraft.client.particle.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import optifine.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.chunk.*;
import com.google.common.collect.*;
import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;
import java.util.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.shader.*;
import java.io.*;
import com.google.gson.*;
import net.minecraft.block.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import net.minecraft.crash.*;
import net.minecraft.util.*;

public class RenderGlobal implements IResourceManagerReloadListener, IWorldEventListener
{
    private /* synthetic */ VertexBuffer starVBO;
    private /* synthetic */ List renderInfosTileEntitiesNormal;
    private /* synthetic */ int renderDistanceSq;
    private /* synthetic */ VertexBuffer sky2VBO;
    private /* synthetic */ ViewFrustum viewFrustum;
    private final /* synthetic */ RenderManager renderManager;
    private /* synthetic */ int countEntitiesRendered;
    private static final /* synthetic */ ResourceLocation MOON_PHASES_TEXTURES;
    private /* synthetic */ Framebuffer entityOutlineFramebuffer;
    private /* synthetic */ double lastViewEntityY;
    private final /* synthetic */ Vector3d debugTerrainFrustumPosition;
    public /* synthetic */ Set chunksToUpdateForced;
    private final /* synthetic */ TextureAtlasSprite[] destroyBlockIcons;
    private /* synthetic */ int frustumUpdatePosChunkX;
    private /* synthetic */ List renderInfosEntitiesShadow;
    private /* synthetic */ int renderEntitiesStartupCounter;
    private static final /* synthetic */ Set SET_ALL_FACINGS;
    private static final /* synthetic */ ResourceLocation END_SKY_TEXTURES;
    private /* synthetic */ double frustumUpdatePosY;
    private /* synthetic */ double prevRenderSortX;
    private /* synthetic */ int starGLCallList;
    private static final /* synthetic */ ResourceLocation SUN_TEXTURES;
    private /* synthetic */ int cloudTickCounter;
    private /* synthetic */ int renderDistanceChunks;
    private /* synthetic */ ChunkRenderDispatcher renderDispatcher;
    private /* synthetic */ double prevRenderSortY;
    private /* synthetic */ List<ContainerLocalRenderInformation> renderInfos;
    private /* synthetic */ List renderInfosTileEntities;
    public /* synthetic */ boolean displayListEntitiesDirty;
    public /* synthetic */ boolean renderOverlayDamaged;
    private /* synthetic */ ShaderGroup entityOutlineShader;
    private /* synthetic */ int renderDistance;
    private /* synthetic */ double frustumUpdatePosZ;
    private /* synthetic */ List renderInfosNormal;
    private final /* synthetic */ Map<BlockPos, ISound> mapSoundPositions;
    private /* synthetic */ boolean entityOutlinesRendered;
    private final /* synthetic */ VertexFormat vertexBufferFormat;
    private static final /* synthetic */ ResourceLocation CLOUDS_TEXTURES;
    private /* synthetic */ double lastViewEntityYaw;
    private /* synthetic */ boolean vboEnabled;
    private /* synthetic */ double lastViewEntityZ;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
    private /* synthetic */ int countTileEntitiesRendered;
    private /* synthetic */ Deque visibilityDeque;
    private /* synthetic */ List renderInfosEntities;
    private /* synthetic */ double prevRenderSortZ;
    private /* synthetic */ List renderInfosTileEntitiesShadow;
    private /* synthetic */ RenderEnv renderEnv;
    private /* synthetic */ List renderInfosEntitiesNormal;
    private /* synthetic */ double frustumUpdatePosX;
    private /* synthetic */ int frustumUpdatePosChunkY;
    private /* synthetic */ Long2ObjectMap<Chunk> worldChunkProviderMap;
    private /* synthetic */ int countLoadedChunksPrev;
    public final /* synthetic */ Minecraft mc;
    private /* synthetic */ Set<RenderChunk> chunksToUpdate;
    private /* synthetic */ List renderInfosShadow;
    public /* synthetic */ Set chunksToResortTransparency;
    public /* synthetic */ Entity renderedEntity;
    private final /* synthetic */ Vector4f[] debugTerrainMatrix;
    private /* synthetic */ int countEntitiesHidden;
    private /* synthetic */ int frustumUpdatePosChunkZ;
    private /* synthetic */ double lastViewEntityX;
    private /* synthetic */ IChunkProvider worldChunkProvider;
    private final /* synthetic */ TextureManager renderEngine;
    private /* synthetic */ WorldClient theWorld;
    public final /* synthetic */ Map<Integer, DestroyBlockProgress> damagedBlocks;
    private /* synthetic */ int glSkyList;
    static /* synthetic */ Deque<ContainerLocalRenderInformation> renderInfoCache;
    private /* synthetic */ int countEntitiesTotal;
    private final /* synthetic */ Set<BlockPos> setLightUpdates;
    private /* synthetic */ boolean debugFixTerrainFrustum;
    private final /* synthetic */ Set<TileEntity> setTileEntities;
    public /* synthetic */ boolean renderOverlayEyes;
    private /* synthetic */ ClippingHelper debugFixedClippingHelper;
    private /* synthetic */ ChunkRenderContainer renderContainer;
    private /* synthetic */ double lastViewEntityPitch;
    private /* synthetic */ CloudRenderer cloudRenderer;
    /* synthetic */ IRenderChunkFactory renderChunkFactory;
    private static final /* synthetic */ Logger LOGGER;
    private /* synthetic */ VertexBuffer skyVBO;
    private static final /* synthetic */ ResourceLocation FORCEFIELD_TEXTURES;
    private /* synthetic */ int glSkyList2;
    
    public int getCountChunksToUpdate() {
        return this.chunksToUpdate.size();
    }
    
    private void generateSky() {
        final Tessellator lllllllllllllllIlllIlIllIIIllIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIlllIlIllIIIllIII = lllllllllllllllIlllIlIllIIIllIIl.getBuffer();
        if (this.skyVBO != null) {
            this.skyVBO.deleteGlBuffers();
        }
        if (this.glSkyList >= 0) {
            GLAllocation.deleteDisplayLists(this.glSkyList);
            this.glSkyList = -1;
        }
        if (this.vboEnabled) {
            this.skyVBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderSky(lllllllllllllllIlllIlIllIIIllIII, 16.0f, false);
            lllllllllllllllIlllIlIllIIIllIII.finishDrawing();
            lllllllllllllllIlllIlIllIIIllIII.reset();
            this.skyVBO.bufferData(lllllllllllllllIlllIlIllIIIllIII.getByteBuffer());
        }
        else {
            this.glSkyList = GLAllocation.generateDisplayLists(1);
            GlStateManager.glNewList(this.glSkyList, 4864);
            this.renderSky(lllllllllllllllIlllIlIllIIIllIII, 16.0f, false);
            lllllllllllllllIlllIlIllIIIllIIl.draw();
            GlStateManager.glEndList();
        }
    }
    
    public int renderBlockLayer(final BlockRenderLayer lllllllllllllllIlllIlIIIlIllIlII, final double lllllllllllllllIlllIlIIIllIIIlII, final int lllllllllllllllIlllIlIIIllIIIIll, final Entity lllllllllllllllIlllIlIIIlIllIIll) {
        RenderHelper.disableStandardItemLighting();
        if (lllllllllllllllIlllIlIIIlIllIlII == BlockRenderLayer.TRANSLUCENT) {
            this.mc.mcProfiler.startSection("translucent_sort");
            final double lllllllllllllllIlllIlIIIllIIIIIl = lllllllllllllllIlllIlIIIlIllIIll.posX - this.prevRenderSortX;
            final double lllllllllllllllIlllIlIIIllIIIIII = lllllllllllllllIlllIlIIIlIllIIll.posY - this.prevRenderSortY;
            final double lllllllllllllllIlllIlIIIlIllllll = lllllllllllllllIlllIlIIIlIllIIll.posZ - this.prevRenderSortZ;
            if (lllllllllllllllIlllIlIIIllIIIIIl * lllllllllllllllIlllIlIIIllIIIIIl + lllllllllllllllIlllIlIIIllIIIIII * lllllllllllllllIlllIlIIIllIIIIII + lllllllllllllllIlllIlIIIlIllllll * lllllllllllllllIlllIlIIIlIllllll > 1.0) {
                this.prevRenderSortX = lllllllllllllllIlllIlIIIlIllIIll.posX;
                this.prevRenderSortY = lllllllllllllllIlllIlIIIlIllIIll.posY;
                this.prevRenderSortZ = lllllllllllllllIlllIlIIIlIllIIll.posZ;
                int lllllllllllllllIlllIlIIIlIlllllI = 0;
                this.chunksToResortTransparency.clear();
                for (final ContainerLocalRenderInformation lllllllllllllllIlllIlIIIlIllllIl : this.renderInfos) {
                    if (lllllllllllllllIlllIlIIIlIllllIl.renderChunk.compiledChunk.isLayerStarted(lllllllllllllllIlllIlIIIlIllIlII) && lllllllllllllllIlllIlIIIlIlllllI++ < 15) {
                        this.chunksToResortTransparency.add(lllllllllllllllIlllIlIIIlIllllIl.renderChunk);
                    }
                }
            }
            this.mc.mcProfiler.endSection();
        }
        this.mc.mcProfiler.startSection("filterempty");
        int lllllllllllllllIlllIlIIIlIllllII = 0;
        final boolean lllllllllllllllIlllIlIIIlIlllIll = lllllllllllllllIlllIlIIIlIllIlII == BlockRenderLayer.TRANSLUCENT;
        final int lllllllllllllllIlllIlIIIlIlllIlI = lllllllllllllllIlllIlIIIlIlllIll ? (this.renderInfos.size() - 1) : 0;
        for (int lllllllllllllllIlllIlIIIlIlllIIl = lllllllllllllllIlllIlIIIlIlllIll ? -1 : this.renderInfos.size(), lllllllllllllllIlllIlIIIlIlllIII = lllllllllllllllIlllIlIIIlIlllIll ? -1 : 1, lllllllllllllllIlllIlIIIlIllIlll = lllllllllllllllIlllIlIIIlIlllIlI; lllllllllllllllIlllIlIIIlIllIlll != lllllllllllllllIlllIlIIIlIlllIIl; lllllllllllllllIlllIlIIIlIllIlll += lllllllllllllllIlllIlIIIlIlllIII) {
            final RenderChunk lllllllllllllllIlllIlIIIlIllIllI = this.renderInfos.get(lllllllllllllllIlllIlIIIlIllIlll).renderChunk;
            if (!lllllllllllllllIlllIlIIIlIllIllI.getCompiledChunk().isLayerEmpty(lllllllllllllllIlllIlIIIlIllIlII)) {
                ++lllllllllllllllIlllIlIIIlIllllII;
                this.renderContainer.addRenderChunk(lllllllllllllllIlllIlIIIlIllIllI, lllllllllllllllIlllIlIIIlIllIlII);
            }
        }
        if (lllllllllllllllIlllIlIIIlIllllII == 0) {
            this.mc.mcProfiler.endSection();
            return lllllllllllllllIlllIlIIIlIllllII;
        }
        if (Config.isFogOff() && this.mc.entityRenderer.fogStandard) {
            GlStateManager.disableFog();
        }
        this.mc.mcProfiler.endStartSection(String.valueOf(new StringBuilder("render_").append(lllllllllllllllIlllIlIIIlIllIlII)));
        this.renderBlockLayer(lllllllllllllllIlllIlIIIlIllIlII);
        this.mc.mcProfiler.endSection();
        return lllllllllllllllIlllIlIIIlIllllII;
    }
    
    @Override
    public void onEntityRemoved(final Entity lllllllllllllllIlllIIIlIlIlIllIl) {
        if (Config.isDynamicLights()) {
            DynamicLights.entityRemoved(lllllllllllllllIlllIIIlIlIlIllIl, this);
        }
    }
    
    public void renderEntityOutlineFramebuffer() {
        if (this.isRenderEntityOutlines()) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
            this.entityOutlineFramebuffer.framebufferRenderExt(this.mc.displayWidth, this.mc.displayHeight, false);
            GlStateManager.disableBlend();
        }
    }
    
    public WorldClient getWorld() {
        return this.theWorld;
    }
    
    private void cleanupDamagedBlocks(final Iterator<DestroyBlockProgress> lllllllllllllllIlllIlIIIlIIIllll) {
        while (lllllllllllllllIlllIlIIIlIIIllll.hasNext()) {
            final DestroyBlockProgress lllllllllllllllIlllIlIIIlIIlIIlI = lllllllllllllllIlllIlIIIlIIIllll.next();
            final int lllllllllllllllIlllIlIIIlIIlIIIl = lllllllllllllllIlllIlIIIlIIlIIlI.getCreationCloudUpdateTick();
            if (this.cloudTickCounter - lllllllllllllllIlllIlIIIlIIlIIIl > 400) {
                lllllllllllllllIlllIlIIIlIIIllll.remove();
            }
        }
    }
    
    public int getCountEntitiesRendered() {
        return this.countEntitiesRendered;
    }
    
    private void renderBlockLayer(final BlockRenderLayer lllllllllllllllIlllIlIIIlIIlllIl) {
        this.mc.entityRenderer.enableLightmap();
        if (OpenGlHelper.useVbo()) {
            GlStateManager.glEnableClientState(32884);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.glEnableClientState(32888);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.lightmapTexUnit);
            GlStateManager.glEnableClientState(32888);
            OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
            GlStateManager.glEnableClientState(32886);
        }
        if (Config.isShaders()) {
            ShadersRender.preRenderChunkLayer(lllllllllllllllIlllIlIIIlIIlllIl);
        }
        this.renderContainer.renderChunkLayer(lllllllllllllllIlllIlIIIlIIlllIl);
        if (Config.isShaders()) {
            ShadersRender.postRenderChunkLayer(lllllllllllllllIlllIlIIIlIIlllIl);
        }
        if (OpenGlHelper.useVbo()) {
            for (final VertexFormatElement lllllllllllllllIlllIlIIIlIlIIIIl : DefaultVertexFormats.BLOCK.getElements()) {
                final VertexFormatElement.EnumUsage lllllllllllllllIlllIlIIIlIlIIIII = lllllllllllllllIlllIlIIIlIlIIIIl.getUsage();
                final int lllllllllllllllIlllIlIIIlIIlllll = lllllllllllllllIlllIlIIIlIlIIIIl.getIndex();
                switch ($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[lllllllllllllllIlllIlIIIlIlIIIII.ordinal()]) {
                    default: {
                        continue;
                    }
                    case 1: {
                        GlStateManager.glDisableClientState(32884);
                        continue;
                    }
                    case 4: {
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + lllllllllllllllIlllIlIIIlIIlllll);
                        GlStateManager.glDisableClientState(32888);
                        OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
                        continue;
                    }
                    case 3: {
                        GlStateManager.glDisableClientState(32886);
                        GlStateManager.resetColor();
                        continue;
                    }
                }
            }
        }
        this.mc.entityRenderer.disableLightmap();
    }
    
    private int func_190572_a(final boolean lllllllllllllllIlllIIIlIlIllllIl) {
        int lllllllllllllllIlllIIIlIlIllllII = this.mc.gameSettings.particleSetting;
        if (lllllllllllllllIlllIIIlIlIllllIl && lllllllllllllllIlllIIIlIlIllllII == 2 && this.theWorld.rand.nextInt(10) == 0) {
            lllllllllllllllIlllIIIlIlIllllII = 1;
        }
        if (lllllllllllllllIlllIIIlIlIllllII == 1 && this.theWorld.rand.nextInt(3) == 0) {
            lllllllllllllllIlllIIIlIlIllllII = 2;
        }
        return lllllllllllllllIlllIIIlIlIllllII;
    }
    
    public static void renderFilledBox(final double lllllllllllllllIlllIIlIIIllIlllI, final double lllllllllllllllIlllIIlIIlIIIIlIl, final double lllllllllllllllIlllIIlIIIllIlIlI, final double lllllllllllllllIlllIIlIIIllIlIIl, final double lllllllllllllllIlllIIlIIIllIlIII, final double lllllllllllllllIlllIIlIIIllllllI, final float lllllllllllllllIlllIIlIIIllIIlIl, final float lllllllllllllllIlllIIlIIIllllIIl, final float lllllllllllllllIlllIIlIIIllllIII, final float lllllllllllllllIlllIIlIIIlllIllI) {
        final Tessellator lllllllllllllllIlllIIlIIIlllIlII = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIlllIIlIIIlllIIlI = lllllllllllllllIlllIIlIIIlllIlII.getBuffer();
        lllllllllllllllIlllIIlIIIlllIIlI.begin(5, DefaultVertexFormats.POSITION_COLOR);
        addChainedFilledBoxVertices(lllllllllllllllIlllIIlIIIlllIIlI, lllllllllllllllIlllIIlIIIllIlllI, lllllllllllllllIlllIIlIIlIIIIlIl, lllllllllllllllIlllIIlIIIllIlIlI, lllllllllllllllIlllIIlIIIllIlIIl, lllllllllllllllIlllIIlIIIllIlIII, lllllllllllllllIlllIIlIIIllllllI, lllllllllllllllIlllIIlIIIllIIlIl, lllllllllllllllIlllIIlIIIllllIIl, lllllllllllllllIlllIIlIIIllllIII, lllllllllllllllIlllIIlIIIlllIllI);
        lllllllllllllllIlllIIlIIIlllIlII.draw();
    }
    
    @Override
    public void spawnParticle(final int lllllllllllllllIlllIIIllIllIlIll, final boolean lllllllllllllllIlllIIIllIllIlIlI, final double lllllllllllllllIlllIIIllIllIlIIl, final double lllllllllllllllIlllIIIllIllIlIII, final double lllllllllllllllIlllIIIllIllIIlll, final double lllllllllllllllIlllIIIllIllIIllI, final double lllllllllllllllIlllIIIllIllIIlIl, final double lllllllllllllllIlllIIIllIllIIlII, final int... lllllllllllllllIlllIIIllIlIllIIl) {
        this.func_190570_a(lllllllllllllllIlllIIIllIllIlIll, lllllllllllllllIlllIIIllIllIlIlI, false, lllllllllllllllIlllIIIllIllIlIIl, lllllllllllllllIlllIIIllIllIlIII, lllllllllllllllIlllIIIllIllIIlll, lllllllllllllllIlllIIIllIllIIllI, lllllllllllllllIlllIIIllIllIIlIl, lllllllllllllllIlllIIIllIllIIlII, lllllllllllllllIlllIIIllIlIllIIl);
    }
    
    public int getCountTileEntitiesRendered() {
        return this.countTileEntitiesRendered;
    }
    
    public void createBindEntityOutlineFbs(final int lllllllllllllllIlllIlIlIIllllIlI, final int lllllllllllllllIlllIlIlIIlllIllI) {
        if (OpenGlHelper.shadersSupported && this.entityOutlineShader != null) {
            this.entityOutlineShader.createBindFramebuffers(lllllllllllllllIlllIlIlIIllllIlI, lllllllllllllllIlllIlIlIIlllIllI);
        }
    }
    
    public void drawBlockDamageTexture(final Tessellator lllllllllllllllIlllIIlIlllllIllI, final BufferBuilder lllllllllllllllIlllIIlIlllIIIIIl, final Entity lllllllllllllllIlllIIlIlllllIIlI, final float lllllllllllllllIlllIIlIlllllIIII) {
        final double lllllllllllllllIlllIIlIllllIlllI = lllllllllllllllIlllIIlIlllllIIlI.lastTickPosX + (lllllllllllllllIlllIIlIlllllIIlI.posX - lllllllllllllllIlllIIlIlllllIIlI.lastTickPosX) * lllllllllllllllIlllIIlIlllllIIII;
        final double lllllllllllllllIlllIIlIllllIllII = lllllllllllllllIlllIIlIlllllIIlI.lastTickPosY + (lllllllllllllllIlllIIlIlllllIIlI.posY - lllllllllllllllIlllIIlIlllllIIlI.lastTickPosY) * lllllllllllllllIlllIIlIlllllIIII;
        final double lllllllllllllllIlllIIlIllllIlIll = lllllllllllllllIlllIIlIlllllIIlI.lastTickPosZ + (lllllllllllllllIlllIIlIlllllIIlI.posZ - lllllllllllllllIlllIIlIlllllIIlI.lastTickPosZ) * lllllllllllllllIlllIIlIlllllIIII;
        if (!this.damagedBlocks.isEmpty()) {
            this.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            this.preRenderDamagedBlocks();
            lllllllllllllllIlllIIlIlllIIIIIl.begin(7, DefaultVertexFormats.BLOCK);
            lllllllllllllllIlllIIlIlllIIIIIl.setTranslation(-lllllllllllllllIlllIIlIllllIlllI, -lllllllllllllllIlllIIlIllllIllII, -lllllllllllllllIlllIIlIllllIlIll);
            lllllllllllllllIlllIIlIlllIIIIIl.noColor();
            final Iterator<DestroyBlockProgress> lllllllllllllllIlllIIlIllllIlIIl = this.damagedBlocks.values().iterator();
            while (lllllllllllllllIlllIIlIllllIlIIl.hasNext()) {
                final DestroyBlockProgress lllllllllllllllIlllIIlIllllIlIII = lllllllllllllllIlllIIlIllllIlIIl.next();
                final BlockPos lllllllllllllllIlllIIlIllllIIllI = lllllllllllllllIlllIIlIllllIlIII.getPosition();
                final double lllllllllllllllIlllIIlIllllIIlII = lllllllllllllllIlllIIlIllllIIllI.getX() - lllllllllllllllIlllIIlIllllIlllI;
                final double lllllllllllllllIlllIIlIllllIIIlI = lllllllllllllllIlllIIlIllllIIllI.getY() - lllllllllllllllIlllIIlIllllIllII;
                final double lllllllllllllllIlllIIlIllllIIIII = lllllllllllllllIlllIIlIllllIIllI.getZ() - lllllllllllllllIlllIIlIllllIlIll;
                final Block lllllllllllllllIlllIIlIlllIllllI = this.theWorld.getBlockState(lllllllllllllllIlllIIlIllllIIllI).getBlock();
                boolean lllllllllllllllIlllIIlIlllIllIlI = false;
                if (Reflector.ForgeTileEntity_canRenderBreaking.exists()) {
                    boolean lllllllllllllllIlllIIlIlllIllIII = lllllllllllllllIlllIIlIlllIllllI instanceof BlockChest || lllllllllllllllIlllIIlIlllIllllI instanceof BlockEnderChest || lllllllllllllllIlllIIlIlllIllllI instanceof BlockSign || lllllllllllllllIlllIIlIlllIllllI instanceof BlockSkull;
                    if (!lllllllllllllllIlllIIlIlllIllIII) {
                        final TileEntity lllllllllllllllIlllIIlIlllIlIllI = this.theWorld.getTileEntity(lllllllllllllllIlllIIlIllllIIllI);
                        if (lllllllllllllllIlllIIlIlllIlIllI != null) {
                            lllllllllllllllIlllIIlIlllIllIII = Reflector.callBoolean(lllllllllllllllIlllIIlIlllIlIllI, Reflector.ForgeTileEntity_canRenderBreaking, new Object[0]);
                        }
                    }
                    final boolean lllllllllllllllIlllIIlIlllIlllII = !lllllllllllllllIlllIIlIlllIllIII;
                }
                else {
                    lllllllllllllllIlllIIlIlllIllIlI = (!(lllllllllllllllIlllIIlIlllIllllI instanceof BlockChest) && !(lllllllllllllllIlllIIlIlllIllllI instanceof BlockEnderChest) && !(lllllllllllllllIlllIIlIlllIllllI instanceof BlockSign) && !(lllllllllllllllIlllIIlIlllIllllI instanceof BlockSkull));
                }
                if (lllllllllllllllIlllIIlIlllIllIlI) {
                    if (lllllllllllllllIlllIIlIllllIIlII * lllllllllllllllIlllIIlIllllIIlII + lllllllllllllllIlllIIlIllllIIIlI * lllllllllllllllIlllIIlIllllIIIlI + lllllllllllllllIlllIIlIllllIIIII * lllllllllllllllIlllIIlIllllIIIII > 1024.0) {
                        lllllllllllllllIlllIIlIllllIlIIl.remove();
                    }
                    else {
                        final IBlockState lllllllllllllllIlllIIlIlllIlIlII = this.theWorld.getBlockState(lllllllllllllllIlllIIlIllllIIllI);
                        if (lllllllllllllllIlllIIlIlllIlIlII.getMaterial() == Material.AIR) {
                            continue;
                        }
                        final int lllllllllllllllIlllIIlIlllIIIllI = lllllllllllllllIlllIIlIllllIlIII.getPartialBlockDamage();
                        final TextureAtlasSprite lllllllllllllllIlllIIlIlllIIIlIl = this.destroyBlockIcons[lllllllllllllllIlllIIlIlllIIIllI];
                        final BlockRendererDispatcher lllllllllllllllIlllIIlIlllIIIlII = this.mc.getBlockRendererDispatcher();
                        lllllllllllllllIlllIIlIlllIIIlII.renderBlockDamage(lllllllllllllllIlllIIlIlllIlIlII, lllllllllllllllIlllIIlIllllIIllI, lllllllllllllllIlllIIlIlllIIIlIl, this.theWorld);
                    }
                }
            }
            lllllllllllllllIlllIIlIlllllIllI.draw();
            lllllllllllllllIlllIIlIlllIIIIIl.setTranslation(0.0, 0.0, 0.0);
            this.postRenderDamagedBlocks();
        }
    }
    
    public void updateClouds() {
        if (Config.isShaders() && Keyboard.isKeyDown(61) && Keyboard.isKeyDown(19)) {
            Shaders.uninit();
            Shaders.loadShaderPack();
            Reflector.Minecraft_actionKeyF3.setValue(this.mc, Boolean.TRUE);
        }
        ++this.cloudTickCounter;
        if (this.cloudTickCounter % 20 == 0) {
            this.cleanupDamagedBlocks(this.damagedBlocks.values().iterator());
        }
        if (!this.setLightUpdates.isEmpty() && !this.renderDispatcher.hasNoFreeRenderBuilders() && this.chunksToUpdate.isEmpty()) {
            final Iterator<BlockPos> lllllllllllllllIlllIlIIIlIIIIlIl = this.setLightUpdates.iterator();
            while (lllllllllllllllIlllIlIIIlIIIIlIl.hasNext()) {
                final BlockPos lllllllllllllllIlllIlIIIlIIIIlII = lllllllllllllllIlllIlIIIlIIIIlIl.next();
                lllllllllllllllIlllIlIIIlIIIIlIl.remove();
                final int lllllllllllllllIlllIlIIIlIIIIIll = lllllllllllllllIlllIlIIIlIIIIlII.getX();
                final int lllllllllllllllIlllIlIIIlIIIIIlI = lllllllllllllllIlllIlIIIlIIIIlII.getY();
                final int lllllllllllllllIlllIlIIIlIIIIIIl = lllllllllllllllIlllIlIIIlIIIIlII.getZ();
                this.markBlocksForUpdate(lllllllllllllllIlllIlIIIlIIIIIll - 1, lllllllllllllllIlllIlIIIlIIIIIlI - 1, lllllllllllllllIlllIlIIIlIIIIIIl - 1, lllllllllllllllIlllIlIIIlIIIIIll + 1, lllllllllllllllIlllIlIIIlIIIIIlI + 1, lllllllllllllllIlllIlIIIlIIIIIIl + 1, false);
            }
        }
    }
    
    public String getDebugInfoRenders() {
        final int lllllllllllllllIlllIlIIlllllIlII = this.viewFrustum.renderChunks.length;
        final int lllllllllllllllIlllIlIIlllllIIll = this.getRenderedChunks();
        return String.format("C: %d/%d %sD: %d, L: %d, %s", lllllllllllllllIlllIlIIlllllIIll, lllllllllllllllIlllIlIIlllllIlII, this.mc.renderChunksMany ? "(s) " : "", this.renderDistanceChunks, this.setLightUpdates.size(), (this.renderDispatcher == null) ? "null" : this.renderDispatcher.getDebugInfo());
    }
    
    private void renderStars(final BufferBuilder lllllllllllllllIlllIlIlIlIlIllll) {
        final Random lllllllllllllllIlllIlIlIllIIllIl = new Random(10842L);
        lllllllllllllllIlllIlIlIlIlIllll.begin(7, DefaultVertexFormats.POSITION);
        for (int lllllllllllllllIlllIlIlIllIIllII = 0; lllllllllllllllIlllIlIlIllIIllII < 1500; ++lllllllllllllllIlllIlIlIllIIllII) {
            double lllllllllllllllIlllIlIlIllIIlIll = lllllllllllllllIlllIlIlIllIIllIl.nextFloat() * 2.0f - 1.0f;
            double lllllllllllllllIlllIlIlIllIIlIlI = lllllllllllllllIlllIlIlIllIIllIl.nextFloat() * 2.0f - 1.0f;
            double lllllllllllllllIlllIlIlIllIIlIIl = lllllllllllllllIlllIlIlIllIIllIl.nextFloat() * 2.0f - 1.0f;
            final double lllllllllllllllIlllIlIlIllIIlIII = 0.15f + lllllllllllllllIlllIlIlIllIIllIl.nextFloat() * 0.1f;
            double lllllllllllllllIlllIlIlIllIIIlll = lllllllllllllllIlllIlIlIllIIlIll * lllllllllllllllIlllIlIlIllIIlIll + lllllllllllllllIlllIlIlIllIIlIlI * lllllllllllllllIlllIlIlIllIIlIlI + lllllllllllllllIlllIlIlIllIIlIIl * lllllllllllllllIlllIlIlIllIIlIIl;
            if (lllllllllllllllIlllIlIlIllIIIlll < 1.0 && lllllllllllllllIlllIlIlIllIIIlll > 0.01) {
                lllllllllllllllIlllIlIlIllIIIlll = 1.0 / Math.sqrt(lllllllllllllllIlllIlIlIllIIIlll);
                lllllllllllllllIlllIlIlIllIIlIll *= lllllllllllllllIlllIlIlIllIIIlll;
                lllllllllllllllIlllIlIlIllIIlIlI *= lllllllllllllllIlllIlIlIllIIIlll;
                lllllllllllllllIlllIlIlIllIIlIIl *= lllllllllllllllIlllIlIlIllIIIlll;
                final double lllllllllllllllIlllIlIlIllIIIllI = lllllllllllllllIlllIlIlIllIIlIll * 100.0;
                final double lllllllllllllllIlllIlIlIllIIIlIl = lllllllllllllllIlllIlIlIllIIlIlI * 100.0;
                final double lllllllllllllllIlllIlIlIllIIIlII = lllllllllllllllIlllIlIlIllIIlIIl * 100.0;
                final double lllllllllllllllIlllIlIlIllIIIIll = Math.atan2(lllllllllllllllIlllIlIlIllIIlIll, lllllllllllllllIlllIlIlIllIIlIIl);
                final double lllllllllllllllIlllIlIlIllIIIIlI = Math.sin(lllllllllllllllIlllIlIlIllIIIIll);
                final double lllllllllllllllIlllIlIlIllIIIIIl = Math.cos(lllllllllllllllIlllIlIlIllIIIIll);
                final double lllllllllllllllIlllIlIlIllIIIIII = Math.atan2(Math.sqrt(lllllllllllllllIlllIlIlIllIIlIll * lllllllllllllllIlllIlIlIllIIlIll + lllllllllllllllIlllIlIlIllIIlIIl * lllllllllllllllIlllIlIlIllIIlIIl), lllllllllllllllIlllIlIlIllIIlIlI);
                final double lllllllllllllllIlllIlIlIlIllllll = Math.sin(lllllllllllllllIlllIlIlIllIIIIII);
                final double lllllllllllllllIlllIlIlIlIlllllI = Math.cos(lllllllllllllllIlllIlIlIllIIIIII);
                final double lllllllllllllllIlllIlIlIlIllllIl = lllllllllllllllIlllIlIlIllIIllIl.nextDouble() * 3.141592653589793 * 2.0;
                final double lllllllllllllllIlllIlIlIlIllllII = Math.sin(lllllllllllllllIlllIlIlIlIllllIl);
                final double lllllllllllllllIlllIlIlIlIlllIll = Math.cos(lllllllllllllllIlllIlIlIlIllllIl);
                for (int lllllllllllllllIlllIlIlIlIlllIlI = 0; lllllllllllllllIlllIlIlIlIlllIlI < 4; ++lllllllllllllllIlllIlIlIlIlllIlI) {
                    final double lllllllllllllllIlllIlIlIlIlllIIl = 0.0;
                    final double lllllllllllllllIlllIlIlIlIlllIII = ((lllllllllllllllIlllIlIlIlIlllIlI & 0x2) - 1) * lllllllllllllllIlllIlIlIllIIlIII;
                    final double lllllllllllllllIlllIlIlIlIllIlll = ((lllllllllllllllIlllIlIlIlIlllIlI + 1 & 0x2) - 1) * lllllllllllllllIlllIlIlIllIIlIII;
                    final double lllllllllllllllIlllIlIlIlIllIllI = 0.0;
                    final double lllllllllllllllIlllIlIlIlIllIlIl = lllllllllllllllIlllIlIlIlIlllIII * lllllllllllllllIlllIlIlIlIlllIll - lllllllllllllllIlllIlIlIlIllIlll * lllllllllllllllIlllIlIlIlIllllII;
                    final double lllllllllllllllIlllIlIlIlIllIlII = lllllllllllllllIlllIlIlIlIllIlll * lllllllllllllllIlllIlIlIlIlllIll + lllllllllllllllIlllIlIlIlIlllIII * lllllllllllllllIlllIlIlIlIllllII;
                    final double lllllllllllllllIlllIlIlIlIllIIll = lllllllllllllllIlllIlIlIlIllIlIl * lllllllllllllllIlllIlIlIlIllllll + 0.0 * lllllllllllllllIlllIlIlIlIlllllI;
                    final double lllllllllllllllIlllIlIlIlIllIIlI = 0.0 * lllllllllllllllIlllIlIlIlIllllll - lllllllllllllllIlllIlIlIlIllIlIl * lllllllllllllllIlllIlIlIlIlllllI;
                    final double lllllllllllllllIlllIlIlIlIllIIIl = lllllllllllllllIlllIlIlIlIllIIlI * lllllllllllllllIlllIlIlIllIIIIlI - lllllllllllllllIlllIlIlIlIllIlII * lllllllllllllllIlllIlIlIllIIIIIl;
                    final double lllllllllllllllIlllIlIlIlIllIIII = lllllllllllllllIlllIlIlIlIllIlII * lllllllllllllllIlllIlIlIllIIIIlI + lllllllllllllllIlllIlIlIlIllIIlI * lllllllllllllllIlllIlIlIllIIIIIl;
                    lllllllllllllllIlllIlIlIlIlIllll.pos(lllllllllllllllIlllIlIlIllIIIllI + lllllllllllllllIlllIlIlIlIllIIIl, lllllllllllllllIlllIlIlIllIIIlIl + lllllllllllllllIlllIlIlIlIllIIll, lllllllllllllllIlllIlIlIllIIIlII + lllllllllllllllIlllIlIlIlIllIIII).endVertex();
                }
            }
        }
    }
    
    public void loadRenderers() {
        if (this.theWorld != null) {
            if (this.renderDispatcher == null) {
                this.renderDispatcher = new ChunkRenderDispatcher();
            }
            this.displayListEntitiesDirty = true;
            Blocks.LEAVES.setGraphicsLevel(Config.isTreesFancy());
            Blocks.LEAVES2.setGraphicsLevel(Config.isTreesFancy());
            BlockModelRenderer.updateAoLightValue();
            RenderGlobal.renderInfoCache.clear();
            if (Config.isDynamicLights()) {
                DynamicLights.clear();
            }
            this.renderDistanceChunks = this.mc.gameSettings.renderDistanceChunks;
            this.renderDistance = this.renderDistanceChunks * 16;
            this.renderDistanceSq = this.renderDistance * this.renderDistance;
            final boolean lllllllllllllllIlllIlIlIlIIIIllI = this.vboEnabled;
            this.vboEnabled = OpenGlHelper.useVbo();
            if (lllllllllllllllIlllIlIlIlIIIIllI && !this.vboEnabled) {
                this.renderContainer = new RenderList();
                this.renderChunkFactory = new ListChunkFactory();
            }
            else if (!lllllllllllllllIlllIlIlIlIIIIllI && this.vboEnabled) {
                this.renderContainer = new VboRenderList();
                this.renderChunkFactory = new VboChunkFactory();
            }
            if (lllllllllllllllIlllIlIlIlIIIIllI != this.vboEnabled) {
                this.generateStars();
                this.generateSky();
                this.generateSky2();
            }
            if (this.viewFrustum != null) {
                this.viewFrustum.deleteGlResources();
            }
            this.stopChunkUpdates();
            synchronized (this.setTileEntities) {
                this.setTileEntities.clear();
            }
            // monitorexit(this.setTileEntities)
            this.viewFrustum = new ViewFrustum(this.theWorld, this.mc.gameSettings.renderDistanceChunks, this, this.renderChunkFactory);
            if (this.theWorld != null) {
                final Entity lllllllllllllllIlllIlIlIlIIIIlIl = this.mc.getRenderViewEntity();
                if (lllllllllllllllIlllIlIlIlIIIIlIl != null) {
                    this.viewFrustum.updateChunkPositions(lllllllllllllllIlllIlIlIlIIIIlIl.posX, lllllllllllllllIlllIlIlIlIIIIlIl.posZ);
                }
            }
            this.renderEntitiesStartupCounter = 2;
        }
    }
    
    private void spawnParticle(final EnumParticleTypes lllllllllllllllIlllIIIllIIIllIll, final double lllllllllllllllIlllIIIllIIIllIlI, final double lllllllllllllllIlllIIIllIIlIIIlI, final double lllllllllllllllIlllIIIllIIIllIII, final double lllllllllllllllIlllIIIllIIlIIIII, final double lllllllllllllllIlllIIIllIIIlllll, final double lllllllllllllllIlllIIIllIIIllllI, final int... lllllllllllllllIlllIIIllIIIlllIl) {
        this.spawnParticle(lllllllllllllllIlllIIIllIIIllIll.getParticleID(), lllllllllllllllIlllIIIllIIIllIll.getShouldIgnoreRange(), lllllllllllllllIlllIIIllIIIllIlI, lllllllllllllllIlllIIIllIIlIIIlI, lllllllllllllllIlllIIIllIIIllIII, lllllllllllllllIlllIIIllIIlIIIII, lllllllllllllllIlllIIIllIIIlllll, lllllllllllllllIlllIIIllIIIllllI, lllllllllllllllIlllIIIllIIIlllIl);
    }
    
    private void func_193054_a(final World lllllllllllllllIlllIIIlllIIIIlII, final BlockPos lllllllllllllllIlllIIIlllIIIIIll, final boolean lllllllllllllllIlllIIIlllIIIIIlI) {
        for (final EntityLivingBase lllllllllllllllIlllIIIlllIIIIlIl : lllllllllllllllIlllIIIlllIIIIlII.getEntitiesWithinAABB((Class<? extends Entity>)EntityLivingBase.class, new AxisAlignedBB(lllllllllllllllIlllIIIlllIIIIIll).expandXyz(3.0))) {
            lllllllllllllllIlllIIIlllIIIIlIl.func_191987_a(lllllllllllllllIlllIIIlllIIIIIll, lllllllllllllllIlllIIIlllIIIIIlI);
        }
    }
    
    private ContainerLocalRenderInformation allocateRenderInformation(final RenderChunk lllllllllllllllIlllIIIIllIlllIII, final EnumFacing lllllllllllllllIlllIIIIllIllllII, final int lllllllllllllllIlllIIIIllIlllIll) {
        ContainerLocalRenderInformation lllllllllllllllIlllIIIIllIlllIIl = null;
        if (RenderGlobal.renderInfoCache.isEmpty()) {
            final ContainerLocalRenderInformation lllllllllllllllIlllIIIIllIlllIlI = new ContainerLocalRenderInformation(lllllllllllllllIlllIIIIllIlllIII, lllllllllllllllIlllIIIIllIllllII, lllllllllllllllIlllIIIIllIlllIll);
        }
        else {
            lllllllllllllllIlllIIIIllIlllIIl = RenderGlobal.renderInfoCache.pollLast();
            lllllllllllllllIlllIIIIllIlllIIl.initialize(lllllllllllllllIlllIIIIllIlllIII, lllllllllllllllIlllIIIIllIllllII, lllllllllllllllIlllIIIIllIlllIll);
        }
        lllllllllllllllIlllIIIIllIlllIIl.cacheable = true;
        return lllllllllllllllIlllIIIIllIlllIIl;
    }
    
    public void updateTileEntities(final Collection<TileEntity> lllllllllllllllIlllIIIIlllIIlIII, final Collection<TileEntity> lllllllllllllllIlllIIIIlllIIIlII) {
        synchronized (this.setTileEntities) {
            this.setTileEntities.removeAll(lllllllllllllllIlllIIIIlllIIlIII);
            this.setTileEntities.addAll(lllllllllllllllIlllIIIIlllIIIlII);
        }
        // monitorexit(this.setTileEntities)
    }
    
    private void generateStars() {
        final Tessellator lllllllllllllllIlllIlIlIllllIIll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIlllIlIlIllllIIlI = lllllllllllllllIlllIlIlIllllIIll.getBuffer();
        if (this.starVBO != null) {
            this.starVBO.deleteGlBuffers();
        }
        if (this.starGLCallList >= 0) {
            GLAllocation.deleteDisplayLists(this.starGLCallList);
            this.starGLCallList = -1;
        }
        if (this.vboEnabled) {
            this.starVBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderStars(lllllllllllllllIlllIlIlIllllIIlI);
            lllllllllllllllIlllIlIlIllllIIlI.finishDrawing();
            lllllllllllllllIlllIlIlIllllIIlI.reset();
            this.starVBO.bufferData(lllllllllllllllIlllIlIlIllllIIlI.getByteBuffer());
        }
        else {
            this.starGLCallList = GLAllocation.generateDisplayLists(1);
            GlStateManager.pushMatrix();
            GlStateManager.glNewList(this.starGLCallList, 4864);
            this.renderStars(lllllllllllllllIlllIlIlIllllIIlI);
            lllllllllllllllIlllIlIlIllllIIll.draw();
            GlStateManager.glEndList();
            GlStateManager.popMatrix();
        }
    }
    
    public void renderWorldBorder(final Entity lllllllllllllllIlllIIllIIlIIIIll, final float lllllllllllllllIlllIIllIIlllIlll) {
        final Tessellator lllllllllllllllIlllIIllIIlllIllI = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIlllIIllIIlllIlIl = lllllllllllllllIlllIIllIIlllIllI.getBuffer();
        final WorldBorder lllllllllllllllIlllIIllIIlllIlII = this.theWorld.getWorldBorder();
        final double lllllllllllllllIlllIIllIIlllIIll = this.mc.gameSettings.renderDistanceChunks * 16;
        if (lllllllllllllllIlllIIllIIlIIIIll.posX >= lllllllllllllllIlllIIllIIlllIlII.maxX() - lllllllllllllllIlllIIllIIlllIIll || lllllllllllllllIlllIIllIIlIIIIll.posX <= lllllllllllllllIlllIIllIIlllIlII.minX() + lllllllllllllllIlllIIllIIlllIIll || lllllllllllllllIlllIIllIIlIIIIll.posZ >= lllllllllllllllIlllIIllIIlllIlII.maxZ() - lllllllllllllllIlllIIllIIlllIIll || lllllllllllllllIlllIIllIIlIIIIll.posZ <= lllllllllllllllIlllIIllIIlllIlII.minZ() + lllllllllllllllIlllIIllIIlllIIll) {
            double lllllllllllllllIlllIIllIIlllIIIl = 1.0 - lllllllllllllllIlllIIllIIlllIlII.getClosestDistance(lllllllllllllllIlllIIllIIlIIIIll) / lllllllllllllllIlllIIllIIlllIIll;
            lllllllllllllllIlllIIllIIlllIIIl = Math.pow(lllllllllllllllIlllIIllIIlllIIIl, 4.0);
            final double lllllllllllllllIlllIIllIIllIllll = lllllllllllllllIlllIIllIIlIIIIll.lastTickPosX + (lllllllllllllllIlllIIllIIlIIIIll.posX - lllllllllllllllIlllIIllIIlIIIIll.lastTickPosX) * lllllllllllllllIlllIIllIIlllIlll;
            final double lllllllllllllllIlllIIllIIllIllIl = lllllllllllllllIlllIIllIIlIIIIll.lastTickPosY + (lllllllllllllllIlllIIllIIlIIIIll.posY - lllllllllllllllIlllIIllIIlIIIIll.lastTickPosY) * lllllllllllllllIlllIIllIIlllIlll;
            final double lllllllllllllllIlllIIllIIllIlIll = lllllllllllllllIlllIIllIIlIIIIll.lastTickPosZ + (lllllllllllllllIlllIIllIIlIIIIll.posZ - lllllllllllllllIlllIIllIIlIIIIll.lastTickPosZ) * lllllllllllllllIlllIIllIIlllIlll;
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            this.renderEngine.bindTexture(RenderGlobal.FORCEFIELD_TEXTURES);
            GlStateManager.depthMask(false);
            GlStateManager.pushMatrix();
            final int lllllllllllllllIlllIIllIIllIlIIl = lllllllllllllllIlllIIllIIlllIlII.getStatus().getID();
            final float lllllllllllllllIlllIIllIIllIIlll = (lllllllllllllllIlllIIllIIllIlIIl >> 16 & 0xFF) / 255.0f;
            final float lllllllllllllllIlllIIllIIllIIllI = (lllllllllllllllIlllIIllIIllIlIIl >> 8 & 0xFF) / 255.0f;
            final float lllllllllllllllIlllIIllIIllIIlIl = (lllllllllllllllIlllIIllIIllIlIIl & 0xFF) / 255.0f;
            GlStateManager.color(lllllllllllllllIlllIIllIIllIIlll, lllllllllllllllIlllIIllIIllIIllI, lllllllllllllllIlllIIllIIllIIlIl, (float)lllllllllllllllIlllIIllIIlllIIIl);
            GlStateManager.doPolygonOffset(-3.0f, -3.0f);
            GlStateManager.enablePolygonOffset();
            GlStateManager.alphaFunc(516, 0.1f);
            GlStateManager.enableAlpha();
            GlStateManager.disableCull();
            final float lllllllllllllllIlllIIllIIllIIlII = Minecraft.getSystemTime() % 3000L / 3000.0f;
            final float lllllllllllllllIlllIIllIIllIIIll = 0.0f;
            final float lllllllllllllllIlllIIllIIllIIIIl = 0.0f;
            final float lllllllllllllllIlllIIllIIlIlllll = 128.0f;
            lllllllllllllllIlllIIllIIlllIlIl.begin(7, DefaultVertexFormats.POSITION_TEX);
            lllllllllllllllIlllIIllIIlllIlIl.setTranslation(-lllllllllllllllIlllIIllIIllIllll, -lllllllllllllllIlllIIllIIllIllIl, -lllllllllllllllIlllIIllIIllIlIll);
            double lllllllllllllllIlllIIllIIlIlllIl = Math.max(MathHelper.floor(lllllllllllllllIlllIIllIIllIlIll - lllllllllllllllIlllIIllIIlllIIll), lllllllllllllllIlllIIllIIlllIlII.minZ());
            double lllllllllllllllIlllIIllIIlIllIll = Math.min(MathHelper.ceil(lllllllllllllllIlllIIllIIllIlIll + lllllllllllllllIlllIIllIIlllIIll), lllllllllllllllIlllIIllIIlllIlII.maxZ());
            if (lllllllllllllllIlllIIllIIllIllll > lllllllllllllllIlllIIllIIlllIlII.maxX() - lllllllllllllllIlllIIllIIlllIIll) {
                float lllllllllllllllIlllIIllIIlIllIIl = 0.0f;
                for (double lllllllllllllllIlllIIllIIlIllIII = lllllllllllllllIlllIIllIIlIlllIl; lllllllllllllllIlllIIllIIlIllIII < lllllllllllllllIlllIIllIIlIllIll; ++lllllllllllllllIlllIIllIIlIllIII, lllllllllllllllIlllIIllIIlIllIIl += 0.5f) {
                    final double lllllllllllllllIlllIIllIIlIlIllI = Math.min(1.0, lllllllllllllllIlllIIllIIlIllIll - lllllllllllllllIlllIIllIIlIllIII);
                    final float lllllllllllllllIlllIIllIIlIlIlII = (float)lllllllllllllllIlllIIllIIlIlIllI * 0.5f;
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlllIlII.maxX(), 256.0, lllllllllllllllIlllIIllIIlIllIII).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIllIIl, lllllllllllllllIlllIIllIIllIIlII + 0.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlllIlII.maxX(), 256.0, lllllllllllllllIlllIIllIIlIllIII + lllllllllllllllIlllIIllIIlIlIllI).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIlIlII + lllllllllllllllIlllIIllIIlIllIIl, lllllllllllllllIlllIIllIIllIIlII + 0.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlllIlII.maxX(), 0.0, lllllllllllllllIlllIIllIIlIllIII + lllllllllllllllIlllIIllIIlIlIllI).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIlIlII + lllllllllllllllIlllIIllIIlIllIIl, lllllllllllllllIlllIIllIIllIIlII + 128.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlllIlII.maxX(), 0.0, lllllllllllllllIlllIIllIIlIllIII).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIllIIl, lllllllllllllllIlllIIllIIllIIlII + 128.0f).endVertex();
                }
            }
            if (lllllllllllllllIlllIIllIIllIllll < lllllllllllllllIlllIIllIIlllIlII.minX() + lllllllllllllllIlllIIllIIlllIIll) {
                float lllllllllllllllIlllIIllIIlIlIIlI = 0.0f;
                for (double lllllllllllllllIlllIIllIIlIlIIII = lllllllllllllllIlllIIllIIlIlllIl; lllllllllllllllIlllIIllIIlIlIIII < lllllllllllllllIlllIIllIIlIllIll; ++lllllllllllllllIlllIIllIIlIlIIII, lllllllllllllllIlllIIllIIlIlIIlI += 0.5f) {
                    final double lllllllllllllllIlllIIllIIlIIlllI = Math.min(1.0, lllllllllllllllIlllIIllIIlIllIll - lllllllllllllllIlllIIllIIlIlIIII);
                    final float lllllllllllllllIlllIIllIIlIIllIl = (float)lllllllllllllllIlllIIllIIlIIlllI * 0.5f;
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlllIlII.minX(), 256.0, lllllllllllllllIlllIIllIIlIlIIII).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIlIIlI, lllllllllllllllIlllIIllIIllIIlII + 0.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlllIlII.minX(), 256.0, lllllllllllllllIlllIIllIIlIlIIII + lllllllllllllllIlllIIllIIlIIlllI).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIllIl + lllllllllllllllIlllIIllIIlIlIIlI, lllllllllllllllIlllIIllIIllIIlII + 0.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlllIlII.minX(), 0.0, lllllllllllllllIlllIIllIIlIlIIII + lllllllllllllllIlllIIllIIlIIlllI).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIllIl + lllllllllllllllIlllIIllIIlIlIIlI, lllllllllllllllIlllIIllIIllIIlII + 128.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlllIlII.minX(), 0.0, lllllllllllllllIlllIIllIIlIlIIII).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIlIIlI, lllllllllllllllIlllIIllIIllIIlII + 128.0f).endVertex();
                }
            }
            lllllllllllllllIlllIIllIIlIlllIl = Math.max(MathHelper.floor(lllllllllllllllIlllIIllIIllIllll - lllllllllllllllIlllIIllIIlllIIll), lllllllllllllllIlllIIllIIlllIlII.minX());
            lllllllllllllllIlllIIllIIlIllIll = Math.min(MathHelper.ceil(lllllllllllllllIlllIIllIIllIllll + lllllllllllllllIlllIIllIIlllIIll), lllllllllllllllIlllIIllIIlllIlII.maxX());
            if (lllllllllllllllIlllIIllIIllIlIll > lllllllllllllllIlllIIllIIlllIlII.maxZ() - lllllllllllllllIlllIIllIIlllIIll) {
                float lllllllllllllllIlllIIllIIlIIllII = 0.0f;
                for (double lllllllllllllllIlllIIllIIlIIlIll = lllllllllllllllIlllIIllIIlIlllIl; lllllllllllllllIlllIIllIIlIIlIll < lllllllllllllllIlllIIllIIlIllIll; ++lllllllllllllllIlllIIllIIlIIlIll, lllllllllllllllIlllIIllIIlIIllII += 0.5f) {
                    final double lllllllllllllllIlllIIllIIlIIlIlI = Math.min(1.0, lllllllllllllllIlllIIllIIlIllIll - lllllllllllllllIlllIIllIIlIIlIll);
                    final float lllllllllllllllIlllIIllIIlIIlIIl = (float)lllllllllllllllIlllIIllIIlIIlIlI * 0.5f;
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlIIlIll, 256.0, lllllllllllllllIlllIIllIIlllIlII.maxZ()).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIllII, lllllllllllllllIlllIIllIIllIIlII + 0.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlIIlIll + lllllllllllllllIlllIIllIIlIIlIlI, 256.0, lllllllllllllllIlllIIllIIlllIlII.maxZ()).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIlIIl + lllllllllllllllIlllIIllIIlIIllII, lllllllllllllllIlllIIllIIllIIlII + 0.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlIIlIll + lllllllllllllllIlllIIllIIlIIlIlI, 0.0, lllllllllllllllIlllIIllIIlllIlII.maxZ()).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIlIIl + lllllllllllllllIlllIIllIIlIIllII, lllllllllllllllIlllIIllIIllIIlII + 128.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlIIlIll, 0.0, lllllllllllllllIlllIIllIIlllIlII.maxZ()).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIllII, lllllllllllllllIlllIIllIIllIIlII + 128.0f).endVertex();
                }
            }
            if (lllllllllllllllIlllIIllIIllIlIll < lllllllllllllllIlllIIllIIlllIlII.minZ() + lllllllllllllllIlllIIllIIlllIIll) {
                float lllllllllllllllIlllIIllIIlIIlIII = 0.0f;
                for (double lllllllllllllllIlllIIllIIlIIIlll = lllllllllllllllIlllIIllIIlIlllIl; lllllllllllllllIlllIIllIIlIIIlll < lllllllllllllllIlllIIllIIlIllIll; ++lllllllllllllllIlllIIllIIlIIIlll, lllllllllllllllIlllIIllIIlIIlIII += 0.5f) {
                    final double lllllllllllllllIlllIIllIIlIIIllI = Math.min(1.0, lllllllllllllllIlllIIllIIlIllIll - lllllllllllllllIlllIIllIIlIIIlll);
                    final float lllllllllllllllIlllIIllIIlIIIlIl = (float)lllllllllllllllIlllIIllIIlIIIllI * 0.5f;
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlIIIlll, 256.0, lllllllllllllllIlllIIllIIlllIlII.minZ()).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIlIII, lllllllllllllllIlllIIllIIllIIlII + 0.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlIIIlll + lllllllllllllllIlllIIllIIlIIIllI, 256.0, lllllllllllllllIlllIIllIIlllIlII.minZ()).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIIlIl + lllllllllllllllIlllIIllIIlIIlIII, lllllllllllllllIlllIIllIIllIIlII + 0.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlIIIlll + lllllllllllllllIlllIIllIIlIIIllI, 0.0, lllllllllllllllIlllIIllIIlllIlII.minZ()).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIIlIl + lllllllllllllllIlllIIllIIlIIlIII, lllllllllllllllIlllIIllIIllIIlII + 128.0f).endVertex();
                    lllllllllllllllIlllIIllIIlllIlIl.pos(lllllllllllllllIlllIIllIIlIIIlll, 0.0, lllllllllllllllIlllIIllIIlllIlII.minZ()).tex(lllllllllllllllIlllIIllIIllIIlII + lllllllllllllllIlllIIllIIlIIlIII, lllllllllllllllIlllIIllIIllIIlII + 128.0f).endVertex();
                }
            }
            lllllllllllllllIlllIIllIIlllIllI.draw();
            lllllllllllllllIlllIIllIIlllIlIl.setTranslation(0.0, 0.0, 0.0);
            GlStateManager.enableCull();
            GlStateManager.disableAlpha();
            GlStateManager.doPolygonOffset(0.0f, 0.0f);
            GlStateManager.disablePolygonOffset();
            GlStateManager.enableAlpha();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
        }
    }
    
    public void renderClouds(float lllllllllllllllIlllIIlllIlIlllII, final int lllllllllllllllIlllIIlllIllllIlI, final double lllllllllllllllIlllIIlllIlIllIlI, final double lllllllllllllllIlllIIlllIllllIII, final double lllllllllllllllIlllIIlllIlllIlll) {
        if (!Config.isCloudsOff()) {
            if (Reflector.ForgeWorldProvider_getCloudRenderer.exists()) {
                final WorldProvider lllllllllllllllIlllIIlllIlllIllI = this.mc.world.provider;
                final Object lllllllllllllllIlllIIlllIlllIlIl = Reflector.call(lllllllllllllllIlllIIlllIlllIllI, Reflector.ForgeWorldProvider_getCloudRenderer, new Object[0]);
                if (lllllllllllllllIlllIIlllIlllIlIl != null) {
                    Reflector.callVoid(lllllllllllllllIlllIIlllIlllIlIl, Reflector.IRenderHandler_render, lllllllllllllllIlllIIlllIlIlllII, this.theWorld, this.mc);
                    return;
                }
            }
            if (this.mc.world.provider.isSurfaceWorld()) {
                if (Config.isShaders()) {
                    Shaders.beginClouds();
                }
                if (Config.isCloudsFancy()) {
                    this.renderCloudsFancy(lllllllllllllllIlllIIlllIlIlllII, lllllllllllllllIlllIIlllIllllIlI, lllllllllllllllIlllIIlllIlIllIlI, lllllllllllllllIlllIIlllIllllIII, lllllllllllllllIlllIIlllIlllIlll);
                }
                else {
                    final float lllllllllllllllIlllIIlllIlllIlII = lllllllllllllllIlllIIlllIlIlllII;
                    lllllllllllllllIlllIIlllIlIlllII = 0.0f;
                    GlStateManager.disableCull();
                    final int lllllllllllllllIlllIIlllIlllIIll = 32;
                    final int lllllllllllllllIlllIIlllIlllIIlI = 8;
                    final Tessellator lllllllllllllllIlllIIlllIlllIIIl = Tessellator.getInstance();
                    final BufferBuilder lllllllllllllllIlllIIlllIlllIIII = lllllllllllllllIlllIIlllIlllIIIl.getBuffer();
                    this.renderEngine.bindTexture(RenderGlobal.CLOUDS_TEXTURES);
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                    final Vec3d lllllllllllllllIlllIIlllIllIllll = this.theWorld.getCloudColour(lllllllllllllllIlllIIlllIlIlllII);
                    float lllllllllllllllIlllIIlllIllIlllI = (float)lllllllllllllllIlllIIlllIllIllll.xCoord;
                    float lllllllllllllllIlllIIlllIllIllIl = (float)lllllllllllllllIlllIIlllIllIllll.yCoord;
                    float lllllllllllllllIlllIIlllIllIllII = (float)lllllllllllllllIlllIIlllIllIllll.zCoord;
                    this.cloudRenderer.prepareToRender(false, this.cloudTickCounter, lllllllllllllllIlllIIlllIlllIlII, lllllllllllllllIlllIIlllIllIllll);
                    if (this.cloudRenderer.shouldUpdateGlList()) {
                        this.cloudRenderer.startUpdateGlList();
                        if (lllllllllllllllIlllIIlllIllllIlI != 2) {
                            final float lllllllllllllllIlllIIlllIllIlIll = (lllllllllllllllIlllIIlllIllIlllI * 30.0f + lllllllllllllllIlllIIlllIllIllIl * 59.0f + lllllllllllllllIlllIIlllIllIllII * 11.0f) / 100.0f;
                            final float lllllllllllllllIlllIIlllIllIlIlI = (lllllllllllllllIlllIIlllIllIlllI * 30.0f + lllllllllllllllIlllIIlllIllIllIl * 70.0f) / 100.0f;
                            final float lllllllllllllllIlllIIlllIllIlIIl = (lllllllllllllllIlllIIlllIllIlllI * 30.0f + lllllllllllllllIlllIIlllIllIllII * 70.0f) / 100.0f;
                            lllllllllllllllIlllIIlllIllIlllI = lllllllllllllllIlllIIlllIllIlIll;
                            lllllllllllllllIlllIIlllIllIllIl = lllllllllllllllIlllIIlllIllIlIlI;
                            lllllllllllllllIlllIIlllIllIllII = lllllllllllllllIlllIIlllIllIlIIl;
                        }
                        final float lllllllllllllllIlllIIlllIllIlIII = 4.8828125E-4f;
                        final double lllllllllllllllIlllIIlllIllIIlll = this.cloudTickCounter + lllllllllllllllIlllIIlllIlIlllII;
                        double lllllllllllllllIlllIIlllIllIIllI = lllllllllllllllIlllIIlllIlIllIlI + lllllllllllllllIlllIIlllIllIIlll * 0.029999999329447746;
                        final int lllllllllllllllIlllIIlllIllIIlIl = MathHelper.floor(lllllllllllllllIlllIIlllIllIIllI / 2048.0);
                        final int lllllllllllllllIlllIIlllIllIIlII = MathHelper.floor(lllllllllllllllIlllIIlllIlllIlll / 2048.0);
                        lllllllllllllllIlllIIlllIllIIllI -= lllllllllllllllIlllIIlllIllIIlIl * 2048;
                        final double lllllllllllllllIlllIIlllIllIIIll = lllllllllllllllIlllIIlllIlllIlll - lllllllllllllllIlllIIlllIllIIlII * 2048;
                        float lllllllllllllllIlllIIlllIllIIIlI = this.theWorld.provider.getCloudHeight() - (float)lllllllllllllllIlllIIlllIllllIII + 0.33f;
                        lllllllllllllllIlllIIlllIllIIIlI += this.mc.gameSettings.ofCloudsHeight * 128.0f;
                        final float lllllllllllllllIlllIIlllIllIIIIl = (float)(lllllllllllllllIlllIIlllIllIIllI * 4.8828125E-4);
                        final float lllllllllllllllIlllIIlllIllIIIII = (float)(lllllllllllllllIlllIIlllIllIIIll * 4.8828125E-4);
                        lllllllllllllllIlllIIlllIlllIIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                        for (int lllllllllllllllIlllIIlllIlIlllll = -256; lllllllllllllllIlllIIlllIlIlllll < 256; lllllllllllllllIlllIIlllIlIlllll += 32) {
                            for (int lllllllllllllllIlllIIlllIlIllllI = -256; lllllllllllllllIlllIIlllIlIllllI < 256; lllllllllllllllIlllIIlllIlIllllI += 32) {
                                lllllllllllllllIlllIIlllIlllIIII.pos(lllllllllllllllIlllIIlllIlIlllll + 0, lllllllllllllllIlllIIlllIllIIIlI, lllllllllllllllIlllIIlllIlIllllI + 32).tex((lllllllllllllllIlllIIlllIlIlllll + 0) * 4.8828125E-4f + lllllllllllllllIlllIIlllIllIIIIl, (lllllllllllllllIlllIIlllIlIllllI + 32) * 4.8828125E-4f + lllllllllllllllIlllIIlllIllIIIII).color(lllllllllllllllIlllIIlllIllIlllI, lllllllllllllllIlllIIlllIllIllIl, lllllllllllllllIlllIIlllIllIllII, 0.8f).endVertex();
                                lllllllllllllllIlllIIlllIlllIIII.pos(lllllllllllllllIlllIIlllIlIlllll + 32, lllllllllllllllIlllIIlllIllIIIlI, lllllllllllllllIlllIIlllIlIllllI + 32).tex((lllllllllllllllIlllIIlllIlIlllll + 32) * 4.8828125E-4f + lllllllllllllllIlllIIlllIllIIIIl, (lllllllllllllllIlllIIlllIlIllllI + 32) * 4.8828125E-4f + lllllllllllllllIlllIIlllIllIIIII).color(lllllllllllllllIlllIIlllIllIlllI, lllllllllllllllIlllIIlllIllIllIl, lllllllllllllllIlllIIlllIllIllII, 0.8f).endVertex();
                                lllllllllllllllIlllIIlllIlllIIII.pos(lllllllllllllllIlllIIlllIlIlllll + 32, lllllllllllllllIlllIIlllIllIIIlI, lllllllllllllllIlllIIlllIlIllllI + 0).tex((lllllllllllllllIlllIIlllIlIlllll + 32) * 4.8828125E-4f + lllllllllllllllIlllIIlllIllIIIIl, (lllllllllllllllIlllIIlllIlIllllI + 0) * 4.8828125E-4f + lllllllllllllllIlllIIlllIllIIIII).color(lllllllllllllllIlllIIlllIllIlllI, lllllllllllllllIlllIIlllIllIllIl, lllllllllllllllIlllIIlllIllIllII, 0.8f).endVertex();
                                lllllllllllllllIlllIIlllIlllIIII.pos(lllllllllllllllIlllIIlllIlIlllll + 0, lllllllllllllllIlllIIlllIllIIIlI, lllllllllllllllIlllIIlllIlIllllI + 0).tex((lllllllllllllllIlllIIlllIlIlllll + 0) * 4.8828125E-4f + lllllllllllllllIlllIIlllIllIIIIl, (lllllllllllllllIlllIIlllIlIllllI + 0) * 4.8828125E-4f + lllllllllllllllIlllIIlllIllIIIII).color(lllllllllllllllIlllIIlllIllIlllI, lllllllllllllllIlllIIlllIllIllIl, lllllllllllllllIlllIIlllIllIllII, 0.8f).endVertex();
                            }
                        }
                        lllllllllllllllIlllIIlllIlllIIIl.draw();
                        this.cloudRenderer.endUpdateGlList();
                    }
                    this.cloudRenderer.renderGlList();
                    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                    GlStateManager.disableBlend();
                    GlStateManager.enableCull();
                }
                if (Config.isShaders()) {
                    Shaders.endClouds();
                }
            }
        }
    }
    
    public RenderChunk getRenderChunk(final BlockPos lllllllllllllllIlllIIIIlllIlIIll) {
        return this.viewFrustum.getRenderChunk(lllllllllllllllIlllIIIIlllIlIIll);
    }
    
    public boolean hasNoChunkUpdates() {
        return this.chunksToUpdate.isEmpty() && this.renderDispatcher.hasChunkUpdates();
    }
    
    protected boolean isRenderEntityOutlines() {
        return !Config.isFastRender() && !Config.isShaders() && !Config.isAntialiasing() && (this.entityOutlineFramebuffer != null && this.entityOutlineShader != null && this.mc.player != null);
    }
    
    public int getCountRenderers() {
        return this.viewFrustum.renderChunks.length;
    }
    
    @Override
    public void playRecord(@Nullable final SoundEvent lllllllllllllllIlllIIIlllIIllIIl, final BlockPos lllllllllllllllIlllIIIlllIIllIII) {
        final ISound lllllllllllllllIlllIIIlllIIlIlll = this.mapSoundPositions.get(lllllllllllllllIlllIIIlllIIllIII);
        if (lllllllllllllllIlllIIIlllIIlIlll != null) {
            this.mc.getSoundHandler().stopSound(lllllllllllllllIlllIIIlllIIlIlll);
            this.mapSoundPositions.remove(lllllllllllllllIlllIIIlllIIllIII);
        }
        if (lllllllllllllllIlllIIIlllIIllIIl != null) {
            final ItemRecord lllllllllllllllIlllIIIlllIIlIllI = ItemRecord.getBySound(lllllllllllllllIlllIIIlllIIllIIl);
            if (lllllllllllllllIlllIIIlllIIlIllI != null) {
                this.mc.ingameGUI.setRecordPlayingMessage(lllllllllllllllIlllIIIlllIIlIllI.getRecordNameLocal());
            }
            final ISound lllllllllllllllIlllIIIlllIIlIlIl = PositionedSoundRecord.getRecordSoundRecord(lllllllllllllllIlllIIIlllIIllIIl, (float)lllllllllllllllIlllIIIlllIIllIII.getX(), (float)lllllllllllllllIlllIIIlllIIllIII.getY(), (float)lllllllllllllllIlllIIIlllIIllIII.getZ());
            this.mapSoundPositions.put(lllllllllllllllIlllIIIlllIIllIII, lllllllllllllllIlllIIIlllIIlIlIl);
            this.mc.getSoundHandler().playSound(lllllllllllllllIlllIIIlllIIlIlIl);
        }
        this.func_193054_a(this.theWorld, lllllllllllllllIlllIIIlllIIllIII, lllllllllllllllIlllIIIlllIIllIIl != null);
    }
    
    public int getCountLoadedChunks() {
        if (this.theWorld == null) {
            return 0;
        }
        final IChunkProvider lllllllllllllllIlllIIIIlllIlllII = this.theWorld.getChunkProvider();
        if (lllllllllllllllIlllIIIIlllIlllII == null) {
            return 0;
        }
        if (lllllllllllllllIlllIIIIlllIlllII != this.worldChunkProvider) {
            this.worldChunkProvider = lllllllllllllllIlllIIIIlllIlllII;
            this.worldChunkProviderMap = (Long2ObjectMap<Chunk>)Reflector.getFieldValue(lllllllllllllllIlllIIIIlllIlllII, Reflector.ChunkProviderClient_chunkMapping);
        }
        return (this.worldChunkProviderMap == null) ? 0 : this.worldChunkProviderMap.size();
    }
    
    public void resetClouds() {
        this.cloudRenderer.reset();
    }
    
    protected void stopChunkUpdates() {
        this.chunksToUpdate.clear();
        this.renderDispatcher.stopChunkUpdates();
    }
    
    private void markBlocksForUpdate(final int lllllllllllllllIlllIIlIIIIIllIIl, final int lllllllllllllllIlllIIlIIIIIlIIII, final int lllllllllllllllIlllIIlIIIIIlIlll, final int lllllllllllllllIlllIIlIIIIIlIllI, final int lllllllllllllllIlllIIlIIIIIlIlIl, final int lllllllllllllllIlllIIlIIIIIIllII, final boolean lllllllllllllllIlllIIlIIIIIlIIll) {
        this.viewFrustum.markBlocksForUpdate(lllllllllllllllIlllIIlIIIIIllIIl, lllllllllllllllIlllIIlIIIIIlIIII, lllllllllllllllIlllIIlIIIIIlIlll, lllllllllllllllIlllIIlIIIIIlIllI, lllllllllllllllIlllIIlIIIIIlIlIl, lllllllllllllllIlllIIlIIIIIIllII, lllllllllllllllIlllIIlIIIIIlIIll);
    }
    
    @Override
    public void sendBlockBreakProgress(final int lllllllllllllllIlllIIIIlllllllIl, final BlockPos lllllllllllllllIlllIIIIlllllIlll, final int lllllllllllllllIlllIIIIllllllIll) {
        if (lllllllllllllllIlllIIIIllllllIll >= 0 && lllllllllllllllIlllIIIIllllllIll < 10) {
            DestroyBlockProgress lllllllllllllllIlllIIIIllllllIlI = this.damagedBlocks.get(lllllllllllllllIlllIIIIlllllllIl);
            if (lllllllllllllllIlllIIIIllllllIlI == null || lllllllllllllllIlllIIIIllllllIlI.getPosition().getX() != lllllllllllllllIlllIIIIlllllIlll.getX() || lllllllllllllllIlllIIIIllllllIlI.getPosition().getY() != lllllllllllllllIlllIIIIlllllIlll.getY() || lllllllllllllllIlllIIIIllllllIlI.getPosition().getZ() != lllllllllllllllIlllIIIIlllllIlll.getZ()) {
                lllllllllllllllIlllIIIIllllllIlI = new DestroyBlockProgress(lllllllllllllllIlllIIIIlllllllIl, lllllllllllllllIlllIIIIlllllIlll);
                this.damagedBlocks.put(lllllllllllllllIlllIIIIlllllllIl, lllllllllllllllIlllIIIIllllllIlI);
            }
            lllllllllllllllIlllIIIIllllllIlI.setPartialBlockDamage(lllllllllllllllIlllIIIIllllllIll);
            lllllllllllllllIlllIIIIllllllIlI.setCloudUpdateTick(this.cloudTickCounter);
        }
        else {
            this.damagedBlocks.remove(lllllllllllllllIlllIIIIlllllllIl);
        }
    }
    
    public String getDebugInfoEntities() {
        return String.valueOf(new StringBuilder("E: ").append(this.countEntitiesRendered).append("/").append(this.countEntitiesTotal).append(", B: ").append(this.countEntitiesHidden).append(", ").append(Config.getVersionDebug()));
    }
    
    @Override
    public void onEntityAdded(final Entity lllllllllllllllIlllIIIlIlIllIlIl) {
        RandomMobs.entityLoaded(lllllllllllllllIlllIIIlIlIllIlIl, this.theWorld);
        if (Config.isDynamicLights()) {
            DynamicLights.entityAdded(lllllllllllllllIlllIIIlIlIllIlIl, this);
        }
    }
    
    @Override
    public void markBlockRangeForRenderUpdate(final int lllllllllllllllIlllIIIlllIlIIlll, final int lllllllllllllllIlllIIIlllIlIIlIl, final int lllllllllllllllIlllIIIlllIlIIlII, final int lllllllllllllllIlllIIIlllIlIIIll, final int lllllllllllllllIlllIIIlllIlIlllI, final int lllllllllllllllIlllIIIlllIlIIIIl) {
        this.markBlocksForUpdate(lllllllllllllllIlllIIIlllIlIIlll - 1, lllllllllllllllIlllIIIlllIlIIlIl - 1, lllllllllllllllIlllIIIlllIlIIlII - 1, lllllllllllllllIlllIIIlllIlIIIll + 1, lllllllllllllllIlllIIIlllIlIlllI + 1, lllllllllllllllIlllIIIlllIlIIIIl + 1, false);
    }
    
    @Nullable
    private RenderChunk getRenderChunkOffset(final BlockPos lllllllllllllllIlllIlIIlIIIlIIlI, final RenderChunk lllllllllllllllIlllIlIIlIIIIlIIl, final EnumFacing lllllllllllllllIlllIlIIlIIIIlIII) {
        final BlockPos lllllllllllllllIlllIlIIlIIIIllll = lllllllllllllllIlllIlIIlIIIIlIIl.getBlockPosOffset16(lllllllllllllllIlllIlIIlIIIIlIII);
        if (lllllllllllllllIlllIlIIlIIIIllll.getY() >= 0 && lllllllllllllllIlllIlIIlIIIIllll.getY() < 256) {
            final int lllllllllllllllIlllIlIIlIIIIlllI = lllllllllllllllIlllIlIIlIIIlIIlI.getX() - lllllllllllllllIlllIlIIlIIIIllll.getX();
            final int lllllllllllllllIlllIlIIlIIIIllIl = lllllllllllllllIlllIlIIlIIIlIIlI.getZ() - lllllllllllllllIlllIlIIlIIIIllll.getZ();
            if (Config.isFogOff()) {
                if (Math.abs(lllllllllllllllIlllIlIIlIIIIlllI) > this.renderDistance || Math.abs(lllllllllllllllIlllIlIIlIIIIllIl) > this.renderDistance) {
                    return null;
                }
            }
            else {
                final int lllllllllllllllIlllIlIIlIIIIllII = lllllllllllllllIlllIlIIlIIIIlllI * lllllllllllllllIlllIlIIlIIIIlllI + lllllllllllllllIlllIlIIlIIIIllIl * lllllllllllllllIlllIlIIlIIIIllIl;
                if (lllllllllllllllIlllIlIIlIIIIllII > this.renderDistanceSq) {
                    return null;
                }
            }
            return lllllllllllllllIlllIlIIlIIIIlIIl.getRenderChunkOffset16(this.viewFrustum, lllllllllllllllIlllIlIIlIIIIlIII);
        }
        return null;
    }
    
    public void setDisplayListEntitiesDirty() {
        this.displayListEntitiesDirty = true;
    }
    
    private void preRenderDamagedBlocks() {
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 0.5f);
        GlStateManager.doPolygonOffset(-3.0f, -3.0f);
        GlStateManager.enablePolygonOffset();
        GlStateManager.alphaFunc(516, 0.1f);
        GlStateManager.enableAlpha();
        GlStateManager.pushMatrix();
        if (Config.isShaders()) {
            ShadersRender.beginBlockDamage();
        }
    }
    
    protected int getRenderedChunks() {
        int lllllllllllllllIlllIlIIllllIlIIl = 0;
        for (final ContainerLocalRenderInformation lllllllllllllllIlllIlIIllllIlIII : this.renderInfos) {
            final CompiledChunk lllllllllllllllIlllIlIIllllIIlll = lllllllllllllllIlllIlIIllllIlIII.renderChunk.compiledChunk;
            if (lllllllllllllllIlllIlIIllllIIlll != CompiledChunk.DUMMY && !lllllllllllllllIlllIlIIllllIIlll.isEmpty()) {
                ++lllllllllllllllIlllIlIIllllIlIIl;
            }
        }
        return lllllllllllllllIlllIlIIllllIlIIl;
    }
    
    public void setupTerrain(final Entity lllllllllllllllIlllIlIIllIllllll, final double lllllllllllllllIlllIlIIllIlllllI, ICamera lllllllllllllllIlllIlIIlIllllllI, final int lllllllllllllllIlllIlIIllIllllII, final boolean lllllllllllllllIlllIlIIllIlllIll) {
        if (this.mc.gameSettings.renderDistanceChunks != this.renderDistanceChunks) {
            this.loadRenderers();
        }
        this.theWorld.theProfiler.startSection("camera");
        final double lllllllllllllllIlllIlIIllIlllIlI = lllllllllllllllIlllIlIIllIllllll.posX - this.frustumUpdatePosX;
        final double lllllllllllllllIlllIlIIllIlllIIl = lllllllllllllllIlllIlIIllIllllll.posY - this.frustumUpdatePosY;
        final double lllllllllllllllIlllIlIIllIlllIII = lllllllllllllllIlllIlIIllIllllll.posZ - this.frustumUpdatePosZ;
        if (this.frustumUpdatePosChunkX != lllllllllllllllIlllIlIIllIllllll.chunkCoordX || this.frustumUpdatePosChunkY != lllllllllllllllIlllIlIIllIllllll.chunkCoordY || this.frustumUpdatePosChunkZ != lllllllllllllllIlllIlIIllIllllll.chunkCoordZ || lllllllllllllllIlllIlIIllIlllIlI * lllllllllllllllIlllIlIIllIlllIlI + lllllllllllllllIlllIlIIllIlllIIl * lllllllllllllllIlllIlIIllIlllIIl + lllllllllllllllIlllIlIIllIlllIII * lllllllllllllllIlllIlIIllIlllIII > 16.0) {
            this.frustumUpdatePosX = lllllllllllllllIlllIlIIllIllllll.posX;
            this.frustumUpdatePosY = lllllllllllllllIlllIlIIllIllllll.posY;
            this.frustumUpdatePosZ = lllllllllllllllIlllIlIIllIllllll.posZ;
            this.frustumUpdatePosChunkX = lllllllllllllllIlllIlIIllIllllll.chunkCoordX;
            this.frustumUpdatePosChunkY = lllllllllllllllIlllIlIIllIllllll.chunkCoordY;
            this.frustumUpdatePosChunkZ = lllllllllllllllIlllIlIIllIllllll.chunkCoordZ;
            this.viewFrustum.updateChunkPositions(lllllllllllllllIlllIlIIllIllllll.posX, lllllllllllllllIlllIlIIllIllllll.posZ);
        }
        if (Config.isDynamicLights()) {
            DynamicLights.update(this);
        }
        this.theWorld.theProfiler.endStartSection("renderlistcamera");
        final double lllllllllllllllIlllIlIIllIllIlll = lllllllllllllllIlllIlIIllIllllll.lastTickPosX + (lllllllllllllllIlllIlIIllIllllll.posX - lllllllllllllllIlllIlIIllIllllll.lastTickPosX) * lllllllllllllllIlllIlIIllIlllllI;
        final double lllllllllllllllIlllIlIIllIllIllI = lllllllllllllllIlllIlIIllIllllll.lastTickPosY + (lllllllllllllllIlllIlIIllIllllll.posY - lllllllllllllllIlllIlIIllIllllll.lastTickPosY) * lllllllllllllllIlllIlIIllIlllllI;
        final double lllllllllllllllIlllIlIIllIllIlIl = lllllllllllllllIlllIlIIllIllllll.lastTickPosZ + (lllllllllllllllIlllIlIIllIllllll.posZ - lllllllllllllllIlllIlIIllIllllll.lastTickPosZ) * lllllllllllllllIlllIlIIllIlllllI;
        this.renderContainer.initialize(lllllllllllllllIlllIlIIllIllIlll, lllllllllllllllIlllIlIIllIllIllI, lllllllllllllllIlllIlIIllIllIlIl);
        this.theWorld.theProfiler.endStartSection("cull");
        if (this.debugFixedClippingHelper != null) {
            final Frustum lllllllllllllllIlllIlIIllIllIlII = new Frustum(this.debugFixedClippingHelper);
            lllllllllllllllIlllIlIIllIllIlII.setPosition(this.debugTerrainFrustumPosition.x, this.debugTerrainFrustumPosition.y, this.debugTerrainFrustumPosition.z);
            lllllllllllllllIlllIlIIlIllllllI = lllllllllllllllIlllIlIIllIllIlII;
        }
        this.mc.mcProfiler.endStartSection("culling");
        final BlockPos lllllllllllllllIlllIlIIllIllIIll = new BlockPos(lllllllllllllllIlllIlIIllIllIlll, lllllllllllllllIlllIlIIllIllIllI + lllllllllllllllIlllIlIIllIllllll.getEyeHeight(), lllllllllllllllIlllIlIIllIllIlIl);
        final RenderChunk lllllllllllllllIlllIlIIllIllIIlI = this.viewFrustum.getRenderChunk(lllllllllllllllIlllIlIIllIllIIll);
        new BlockPos(MathHelper.floor(lllllllllllllllIlllIlIIllIllIlll / 16.0) * 16, MathHelper.floor(lllllllllllllllIlllIlIIllIllIllI / 16.0) * 16, MathHelper.floor(lllllllllllllllIlllIlIIllIllIlIl / 16.0) * 16);
        this.displayListEntitiesDirty = (this.displayListEntitiesDirty || !this.chunksToUpdate.isEmpty() || lllllllllllllllIlllIlIIllIllllll.posX != this.lastViewEntityX || lllllllllllllllIlllIlIIllIllllll.posY != this.lastViewEntityY || lllllllllllllllIlllIlIIllIllllll.posZ != this.lastViewEntityZ || lllllllllllllllIlllIlIIllIllllll.rotationPitch != this.lastViewEntityPitch || lllllllllllllllIlllIlIIllIllllll.rotationYaw != this.lastViewEntityYaw);
        this.lastViewEntityX = lllllllllllllllIlllIlIIllIllllll.posX;
        this.lastViewEntityY = lllllllllllllllIlllIlIIllIllllll.posY;
        this.lastViewEntityZ = lllllllllllllllIlllIlIIllIllllll.posZ;
        this.lastViewEntityPitch = lllllllllllllllIlllIlIIllIllllll.rotationPitch;
        this.lastViewEntityYaw = lllllllllllllllIlllIlIIllIllllll.rotationYaw;
        final boolean lllllllllllllllIlllIlIIllIllIIIl = this.debugFixedClippingHelper != null;
        this.mc.mcProfiler.endStartSection("update");
        Lagometer.timerVisibility.start();
        final int lllllllllllllllIlllIlIIllIllIIII = this.getCountLoadedChunks();
        if (lllllllllllllllIlllIlIIllIllIIII != this.countLoadedChunksPrev) {
            this.countLoadedChunksPrev = lllllllllllllllIlllIlIIllIllIIII;
            this.displayListEntitiesDirty = true;
        }
        if (Shaders.isShadowPass) {
            this.renderInfos = (List<ContainerLocalRenderInformation>)this.renderInfosShadow;
            this.renderInfosEntities = this.renderInfosEntitiesShadow;
            this.renderInfosTileEntities = this.renderInfosTileEntitiesShadow;
            if (!lllllllllllllllIlllIlIIllIllIIIl && this.displayListEntitiesDirty) {
                this.renderInfos.clear();
                this.renderInfosEntities.clear();
                this.renderInfosTileEntities.clear();
                final RenderInfoLazy lllllllllllllllIlllIlIIllIlIllll = new RenderInfoLazy();
                final Iterator<RenderChunk> lllllllllllllllIlllIlIIllIlIlllI = ShadowUtils.makeShadowChunkIterator(this.theWorld, lllllllllllllllIlllIlIIllIlllllI, lllllllllllllllIlllIlIIllIllllll, this.renderDistanceChunks, this.viewFrustum);
                while (lllllllllllllllIlllIlIIllIlIlllI.hasNext()) {
                    final RenderChunk lllllllllllllllIlllIlIIllIlIllIl = lllllllllllllllIlllIlIIllIlIlllI.next();
                    if (lllllllllllllllIlllIlIIllIlIllIl != null) {
                        lllllllllllllllIlllIlIIllIlIllll.setRenderChunk(lllllllllllllllIlllIlIIllIlIllIl);
                        if (!lllllllllllllllIlllIlIIllIlIllIl.compiledChunk.isEmpty() || lllllllllllllllIlllIlIIllIlIllIl.isNeedsUpdate()) {
                            this.renderInfos.add(lllllllllllllllIlllIlIIllIlIllll.getRenderInfo());
                        }
                        final BlockPos lllllllllllllllIlllIlIIllIlIllII = lllllllllllllllIlllIlIIllIlIllIl.getPosition();
                        if (ChunkUtils.hasEntities(this.theWorld.getChunkFromBlockCoords(lllllllllllllllIlllIlIIllIlIllII))) {
                            this.renderInfosEntities.add(lllllllllllllllIlllIlIIllIlIllll.getRenderInfo());
                        }
                        if (lllllllllllllllIlllIlIIllIlIllIl.getCompiledChunk().getTileEntities().size() <= 0) {
                            continue;
                        }
                        this.renderInfosTileEntities.add(lllllllllllllllIlllIlIIllIlIllll.getRenderInfo());
                    }
                }
            }
        }
        else {
            this.renderInfos = (List<ContainerLocalRenderInformation>)this.renderInfosNormal;
            this.renderInfosEntities = this.renderInfosEntitiesNormal;
            this.renderInfosTileEntities = this.renderInfosTileEntitiesNormal;
        }
        if (!lllllllllllllllIlllIlIIllIllIIIl && this.displayListEntitiesDirty && !Shaders.isShadowPass) {
            this.displayListEntitiesDirty = false;
            for (final ContainerLocalRenderInformation lllllllllllllllIlllIlIIllIlIlIll : this.renderInfos) {
                this.freeRenderInformation(lllllllllllllllIlllIlIIllIlIlIll);
            }
            this.renderInfos.clear();
            this.renderInfosEntities.clear();
            this.renderInfosTileEntities.clear();
            this.visibilityDeque.clear();
            final Deque lllllllllllllllIlllIlIIllIlIlIlI = this.visibilityDeque;
            Entity.setRenderDistanceWeight(MathHelper.clamp(this.mc.gameSettings.renderDistanceChunks / 8.0, 1.0, 2.5));
            boolean lllllllllllllllIlllIlIIllIlIlIIl = this.mc.renderChunksMany;
            if (lllllllllllllllIlllIlIIllIllIIlI != null) {
                boolean lllllllllllllllIlllIlIIllIlIlIII = false;
                final ContainerLocalRenderInformation lllllllllllllllIlllIlIIllIlIIlll = new ContainerLocalRenderInformation(lllllllllllllllIlllIlIIllIllIIlI, null, 0);
                final Set lllllllllllllllIlllIlIIllIlIIllI = RenderGlobal.SET_ALL_FACINGS;
                if (lllllllllllllllIlllIlIIllIlIIllI.size() == 1) {
                    final Vector3f lllllllllllllllIlllIlIIllIlIIlIl = this.getViewVector(lllllllllllllllIlllIlIIllIllllll, lllllllllllllllIlllIlIIllIlllllI);
                    final EnumFacing lllllllllllllllIlllIlIIllIlIIlII = EnumFacing.getFacingFromVector(lllllllllllllllIlllIlIIllIlIIlIl.x, lllllllllllllllIlllIlIIllIlIIlIl.y, lllllllllllllllIlllIlIIllIlIIlIl.z).getOpposite();
                    lllllllllllllllIlllIlIIllIlIIllI.remove(lllllllllllllllIlllIlIIllIlIIlII);
                }
                if (lllllllllllllllIlllIlIIllIlIIllI.isEmpty()) {
                    lllllllllllllllIlllIlIIllIlIlIII = true;
                }
                if (lllllllllllllllIlllIlIIllIlIlIII && !lllllllllllllllIlllIlIIllIlllIll) {
                    this.renderInfos.add(lllllllllllllllIlllIlIIllIlIIlll);
                }
                else {
                    if (lllllllllllllllIlllIlIIllIlllIll && this.theWorld.getBlockState(lllllllllllllllIlllIlIIllIllIIll).isOpaqueCube()) {
                        lllllllllllllllIlllIlIIllIlIlIIl = false;
                    }
                    lllllllllllllllIlllIlIIllIllIIlI.setFrameIndex(lllllllllllllllIlllIlIIllIllllII);
                    lllllllllllllllIlllIlIIllIlIlIlI.add(lllllllllllllllIlllIlIIllIlIIlll);
                }
            }
            else {
                final int lllllllllllllllIlllIlIIllIlIIIll = (lllllllllllllllIlllIlIIllIllIIll.getY() > 0) ? 248 : 8;
                for (int lllllllllllllllIlllIlIIllIlIIIIl = -this.renderDistanceChunks; lllllllllllllllIlllIlIIllIlIIIIl <= this.renderDistanceChunks; ++lllllllllllllllIlllIlIIllIlIIIIl) {
                    for (int lllllllllllllllIlllIlIIllIlIIIII = -this.renderDistanceChunks; lllllllllllllllIlllIlIIllIlIIIII <= this.renderDistanceChunks; ++lllllllllllllllIlllIlIIllIlIIIII) {
                        final RenderChunk lllllllllllllllIlllIlIIllIIllllI = this.viewFrustum.getRenderChunk(new BlockPos((lllllllllllllllIlllIlIIllIlIIIIl << 4) + 8, lllllllllllllllIlllIlIIllIlIIIll, (lllllllllllllllIlllIlIIllIlIIIII << 4) + 8));
                        if (lllllllllllllllIlllIlIIllIIllllI != null && ((ICamera)lllllllllllllllIlllIlIIlIllllllI).isBoundingBoxInFrustum(lllllllllllllllIlllIlIIllIIllllI.boundingBox)) {
                            lllllllllllllllIlllIlIIllIIllllI.setFrameIndex(lllllllllllllllIlllIlIIllIllllII);
                            lllllllllllllllIlllIlIIllIlIlIlI.add(new ContainerLocalRenderInformation(lllllllllllllllIlllIlIIllIIllllI, null, 0));
                        }
                    }
                }
            }
            this.mc.mcProfiler.startSection("iteration");
            final EnumFacing[] lllllllllllllllIlllIlIIllIIlllIl = EnumFacing.VALUES;
            final int lllllllllllllllIlllIlIIllIIllIll = lllllllllllllllIlllIlIIllIIlllIl.length;
            while (!lllllllllllllllIlllIlIIllIlIlIlI.isEmpty()) {
                final ContainerLocalRenderInformation lllllllllllllllIlllIlIIllIIllIlI = lllllllllllllllIlllIlIIllIlIlIlI.poll();
                final RenderChunk lllllllllllllllIlllIlIIllIIllIIl = lllllllllllllllIlllIlIIllIIllIlI.renderChunk;
                final EnumFacing lllllllllllllllIlllIlIIllIIllIII = lllllllllllllllIlllIlIIllIIllIlI.facing;
                boolean lllllllllllllllIlllIlIIllIIlIlll = false;
                final CompiledChunk lllllllllllllllIlllIlIIllIIlIllI = lllllllllllllllIlllIlIIllIIllIIl.compiledChunk;
                if (!lllllllllllllllIlllIlIIllIIlIllI.isEmpty() || lllllllllllllllIlllIlIIllIIllIIl.isNeedsUpdate()) {
                    this.renderInfos.add(lllllllllllllllIlllIlIIllIIllIlI);
                    lllllllllllllllIlllIlIIllIIlIlll = true;
                }
                if (ChunkUtils.hasEntities(lllllllllllllllIlllIlIIllIIllIIl.getChunk(this.theWorld))) {
                    this.renderInfosEntities.add(lllllllllllllllIlllIlIIllIIllIlI);
                    lllllllllllllllIlllIlIIllIIlIlll = true;
                }
                if (lllllllllllllllIlllIlIIllIIlIllI.getTileEntities().size() > 0) {
                    this.renderInfosTileEntities.add(lllllllllllllllIlllIlIIllIIllIlI);
                    lllllllllllllllIlllIlIIllIIlIlll = true;
                }
                for (final EnumFacing lllllllllllllllIlllIlIIllIIlIIlI : lllllllllllllllIlllIlIIllIIlllIl) {
                    if ((!lllllllllllllllIlllIlIIllIlIlIIl || !lllllllllllllllIlllIlIIllIIllIlI.hasDirection(lllllllllllllllIlllIlIIllIIlIIlI.getOpposite())) && (!lllllllllllllllIlllIlIIllIlIlIIl || lllllllllllllllIlllIlIIllIIllIII == null || lllllllllllllllIlllIlIIllIIlIllI.isVisible(lllllllllllllllIlllIlIIllIIllIII.getOpposite(), lllllllllllllllIlllIlIIllIIlIIlI))) {
                        final RenderChunk lllllllllllllllIlllIlIIllIIlIIII = this.getRenderChunkOffset(lllllllllllllllIlllIlIIllIllIIll, lllllllllllllllIlllIlIIllIIllIIl, lllllllllllllllIlllIlIIllIIlIIlI);
                        if (lllllllllllllllIlllIlIIllIIlIIII != null && lllllllllllllllIlllIlIIllIIlIIII.setFrameIndex(lllllllllllllllIlllIlIIllIllllII) && ((ICamera)lllllllllllllllIlllIlIIlIllllllI).isBoundingBoxInFrustum(lllllllllllllllIlllIlIIllIIlIIII.boundingBox)) {
                            final int lllllllllllllllIlllIlIIllIIIlllI = lllllllllllllllIlllIlIIllIIllIlI.setFacing | 1 << lllllllllllllllIlllIlIIllIIlIIlI.ordinal();
                            final ContainerLocalRenderInformation lllllllllllllllIlllIlIIllIIIllIl = this.allocateRenderInformation(lllllllllllllllIlllIlIIllIIlIIII, lllllllllllllllIlllIlIIllIIlIIlI, lllllllllllllllIlllIlIIllIIIlllI);
                            lllllllllllllllIlllIlIIllIlIlIlI.add(lllllllllllllllIlllIlIIllIIIllIl);
                        }
                    }
                }
                if (!lllllllllllllllIlllIlIIllIIlIlll) {
                    this.freeRenderInformation(lllllllllllllllIlllIlIIllIIllIlI);
                }
            }
            this.mc.mcProfiler.endSection();
        }
        this.mc.mcProfiler.endStartSection("captureFrustum");
        if (this.debugFixTerrainFrustum) {
            this.fixTerrainFrustum(lllllllllllllllIlllIlIIllIllIlll, lllllllllllllllIlllIlIIllIllIllI, lllllllllllllllIlllIlIIllIllIlIl);
            this.debugFixTerrainFrustum = false;
        }
        Lagometer.timerVisibility.end();
        if (Shaders.isShadowPass) {
            Shaders.mcProfilerEndSection();
        }
        else {
            this.mc.mcProfiler.endStartSection("rebuildNear");
            final Set<RenderChunk> lllllllllllllllIlllIlIIllIIIlIll = this.chunksToUpdate;
            this.chunksToUpdate = (Set<RenderChunk>)Sets.newLinkedHashSet();
            Lagometer.timerChunkUpdate.start();
            for (final ContainerLocalRenderInformation lllllllllllllllIlllIlIIllIIIlIIl : this.renderInfos) {
                final RenderChunk lllllllllllllllIlllIlIIllIIIIlll = lllllllllllllllIlllIlIIllIIIlIIl.renderChunk;
                if (lllllllllllllllIlllIlIIllIIIIlll.isNeedsUpdate() || lllllllllllllllIlllIlIIllIIIlIll.contains(lllllllllllllllIlllIlIIllIIIIlll)) {
                    this.displayListEntitiesDirty = true;
                    final BlockPos lllllllllllllllIlllIlIIllIIIIllI = lllllllllllllllIlllIlIIllIIIIlll.getPosition();
                    final boolean lllllllllllllllIlllIlIIllIIIIlIl = lllllllllllllllIlllIlIIllIllIIll.distanceSq(lllllllllllllllIlllIlIIllIIIIllI.getX() + 8, lllllllllllllllIlllIlIIllIIIIllI.getY() + 8, lllllllllllllllIlllIlIIllIIIIllI.getZ() + 8) < 768.0;
                    if (!lllllllllllllllIlllIlIIllIIIIlIl) {
                        this.chunksToUpdate.add(lllllllllllllllIlllIlIIllIIIIlll);
                    }
                    else if (!lllllllllllllllIlllIlIIllIIIIlll.isPlayerUpdate()) {
                        this.chunksToUpdateForced.add(lllllllllllllllIlllIlIIllIIIIlll);
                    }
                    else {
                        this.mc.mcProfiler.startSection("build near");
                        this.renderDispatcher.updateChunkNow(lllllllllllllllIlllIlIIllIIIIlll);
                        lllllllllllllllIlllIlIIllIIIIlll.clearNeedsUpdate();
                        this.mc.mcProfiler.endSection();
                    }
                }
            }
            Lagometer.timerChunkUpdate.end();
            this.chunksToUpdate.addAll(lllllllllllllllIlllIlIIllIIIlIll);
            this.mc.mcProfiler.endSection();
        }
    }
    
    @Nullable
    private Particle func_190571_b(final int lllllllllllllllIlllIIIlIllIlIIIl, final boolean lllllllllllllllIlllIIIlIllIlIIII, final boolean lllllllllllllllIlllIIIlIlllIIIIl, final double lllllllllllllllIlllIIIlIlllIIIII, final double lllllllllllllllIlllIIIlIllIlllll, final double lllllllllllllllIlllIIIlIllIllllI, final double lllllllllllllllIlllIIIlIllIIlIll, final double lllllllllllllllIlllIIIlIllIIlIlI, final double lllllllllllllllIlllIIIlIllIIlIIl, final int... lllllllllllllllIlllIIIlIllIllIlI) {
        final Entity lllllllllllllllIlllIIIlIllIllIIl = this.mc.getRenderViewEntity();
        if (this.mc == null || lllllllllllllllIlllIIIlIllIllIIl == null || this.mc.effectRenderer == null) {
            return null;
        }
        final int lllllllllllllllIlllIIIlIllIllIII = this.func_190572_a(lllllllllllllllIlllIIIlIlllIIIIl);
        final double lllllllllllllllIlllIIIlIllIlIlll = lllllllllllllllIlllIIIlIllIllIIl.posX - lllllllllllllllIlllIIIlIlllIIIII;
        final double lllllllllllllllIlllIIIlIllIlIllI = lllllllllllllllIlllIIIlIllIllIIl.posY - lllllllllllllllIlllIIIlIllIlllll;
        final double lllllllllllllllIlllIIIlIllIlIlIl = lllllllllllllllIlllIIIlIllIllIIl.posZ - lllllllllllllllIlllIIIlIllIllllI;
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.EXPLOSION_HUGE.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.EXPLOSION_LARGE.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.EXPLOSION_NORMAL.getParticleID() && !Config.isAnimatedExplosion()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SUSPENDED.getParticleID() && !Config.isWaterParticles()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SUSPENDED_DEPTH.getParticleID() && !Config.isVoidParticles()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SMOKE_NORMAL.getParticleID() && !Config.isAnimatedSmoke()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SMOKE_LARGE.getParticleID() && !Config.isAnimatedSmoke()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SPELL_MOB.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SPELL_MOB_AMBIENT.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SPELL.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SPELL_INSTANT.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.SPELL_WITCH.getParticleID() && !Config.isPotionParticles()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.PORTAL.getParticleID() && !Config.isAnimatedPortal()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.FLAME.getParticleID() && !Config.isAnimatedFlame()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.REDSTONE.getParticleID() && !Config.isAnimatedRedstone()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.DRIP_WATER.getParticleID() && !Config.isDrippingWaterLava()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.DRIP_LAVA.getParticleID() && !Config.isDrippingWaterLava()) {
            return null;
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.FIREWORKS_SPARK.getParticleID() && !Config.isFireworkParticles()) {
            return null;
        }
        if (!lllllllllllllllIlllIIIlIllIlIIII) {
            double lllllllllllllllIlllIIIlIllIlIlII = 1024.0;
            if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.CRIT.getParticleID()) {
                lllllllllllllllIlllIIIlIllIlIlII = 38416.0;
            }
            if (lllllllllllllllIlllIIIlIllIlIlll * lllllllllllllllIlllIIIlIllIlIlll + lllllllllllllllIlllIIIlIllIlIllI * lllllllllllllllIlllIIIlIllIlIllI + lllllllllllllllIlllIIIlIllIlIlIl * lllllllllllllllIlllIIIlIllIlIlIl > lllllllllllllllIlllIIIlIllIlIlII) {
                return null;
            }
            if (lllllllllllllllIlllIIIlIllIllIII > 1) {
                return null;
            }
        }
        final Particle lllllllllllllllIlllIIIlIllIlIIll = this.mc.effectRenderer.spawnEffectParticle(lllllllllllllllIlllIIIlIllIlIIIl, lllllllllllllllIlllIIIlIlllIIIII, lllllllllllllllIlllIIIlIllIlllll, lllllllllllllllIlllIIIlIllIllllI, lllllllllllllllIlllIIIlIllIIlIll, lllllllllllllllIlllIIIlIllIIlIlI, lllllllllllllllIlllIIIlIllIIlIIl, lllllllllllllllIlllIIIlIllIllIlI);
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.WATER_BUBBLE.getParticleID()) {
            CustomColors.updateWaterFX(lllllllllllllllIlllIIIlIllIlIIll, this.theWorld, lllllllllllllllIlllIIIlIlllIIIII, lllllllllllllllIlllIIIlIllIlllll, lllllllllllllllIlllIIIlIllIllllI, this.renderEnv);
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.WATER_SPLASH.getParticleID()) {
            CustomColors.updateWaterFX(lllllllllllllllIlllIIIlIllIlIIll, this.theWorld, lllllllllllllllIlllIIIlIlllIIIII, lllllllllllllllIlllIIIlIllIlllll, lllllllllllllllIlllIIIlIllIllllI, this.renderEnv);
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.WATER_DROP.getParticleID()) {
            CustomColors.updateWaterFX(lllllllllllllllIlllIIIlIllIlIIll, this.theWorld, lllllllllllllllIlllIIIlIlllIIIII, lllllllllllllllIlllIIIlIllIlllll, lllllllllllllllIlllIIIlIllIllllI, this.renderEnv);
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.TOWN_AURA.getParticleID()) {
            CustomColors.updateMyceliumFX(lllllllllllllllIlllIIIlIllIlIIll);
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.PORTAL.getParticleID()) {
            CustomColors.updatePortalFX(lllllllllllllllIlllIIIlIllIlIIll);
        }
        if (lllllllllllllllIlllIIIlIllIlIIIl == EnumParticleTypes.REDSTONE.getParticleID()) {
            CustomColors.updateReddustFX(lllllllllllllllIlllIIIlIllIlIIll, this.theWorld, lllllllllllllllIlllIIIlIlllIIIII, lllllllllllllllIlllIIIlIllIlllll, lllllllllllllllIlllIIIlIllIllllI);
        }
        return lllllllllllllllIlllIIIlIllIlIIll;
    }
    
    private boolean isOutlineActive(final Entity lllllllllllllllIlllIlIIlllllllII, final Entity lllllllllllllllIlllIlIIllllllIll, final ICamera lllllllllllllllIlllIlIIllllllIlI) {
        final boolean lllllllllllllllIlllIlIIllllllllI = lllllllllllllllIlllIlIIllllllIll instanceof EntityLivingBase && ((EntityLivingBase)lllllllllllllllIlllIlIIllllllIll).isPlayerSleeping();
        return (lllllllllllllllIlllIlIIlllllllII != lllllllllllllllIlllIlIIllllllIll || this.mc.gameSettings.thirdPersonView != 0 || lllllllllllllllIlllIlIIllllllllI) && (lllllllllllllllIlllIlIIlllllllII.isGlowing() || (this.mc.player.isSpectator() && this.mc.gameSettings.keyBindSpectatorOutlines.isKeyDown() && lllllllllllllllIlllIlIIlllllllII instanceof EntityPlayer && (lllllllllllllllIlllIlIIlllllllII.ignoreFrustumCheck || lllllllllllllllIlllIlIIllllllIlI.isBoundingBoxInFrustum(lllllllllllllllIlllIlIIlllllllII.getEntityBoundingBox()) || lllllllllllllllIlllIlIIlllllllII.isRidingOrBeingRiddenBy(this.mc.player))));
    }
    
    private void postRenderDamagedBlocks() {
        GlStateManager.disableAlpha();
        GlStateManager.doPolygonOffset(0.0f, 0.0f);
        GlStateManager.disablePolygonOffset();
        GlStateManager.enableAlpha();
        GlStateManager.depthMask(true);
        GlStateManager.popMatrix();
        if (Config.isShaders()) {
            ShadersRender.endBlockDamage();
        }
    }
    
    @Override
    public void playSoundToAllNearExcept(@Nullable final EntityPlayer lllllllllllllllIlllIIIllIllllllI, final SoundEvent lllllllllllllllIlllIIIllIlllllIl, final SoundCategory lllllllllllllllIlllIIIllIlllllII, final double lllllllllllllllIlllIIIllIllllIll, final double lllllllllllllllIlllIIIllIllllIlI, final double lllllllllllllllIlllIIIllIllllIIl, final float lllllllllllllllIlllIIIllIllllIII, final float lllllllllllllllIlllIIIllIlllIlll) {
    }
    
    public static void drawBoundingBox(final double lllllllllllllllIlllIIlIlIIllIIIl, final double lllllllllllllllIlllIIlIlIIlIIIIl, final double lllllllllllllllIlllIIlIlIIlIllll, final double lllllllllllllllIlllIIlIlIIlIlllI, final double lllllllllllllllIlllIIlIlIIlIllIl, final double lllllllllllllllIlllIIlIlIIIllIIl, final float lllllllllllllllIlllIIlIlIIlIlIll, final float lllllllllllllllIlllIIlIlIIlIlIlI, final float lllllllllllllllIlllIIlIlIIlIlIIl, final float lllllllllllllllIlllIIlIlIIIlIIlI) {
        final Tessellator lllllllllllllllIlllIIlIlIIlIIlll = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIlllIIlIlIIlIIllI = lllllllllllllllIlllIIlIlIIlIIlll.getBuffer();
        lllllllllllllllIlllIIlIlIIlIIllI.begin(3, DefaultVertexFormats.POSITION_COLOR);
        drawBoundingBox(lllllllllllllllIlllIIlIlIIlIIllI, lllllllllllllllIlllIIlIlIIllIIIl, lllllllllllllllIlllIIlIlIIlIIIIl, lllllllllllllllIlllIIlIlIIlIllll, lllllllllllllllIlllIIlIlIIlIlllI, lllllllllllllllIlllIIlIlIIlIllIl, lllllllllllllllIlllIIlIlIIIllIIl, lllllllllllllllIlllIIlIlIIlIlIll, lllllllllllllllIlllIIlIlIIlIlIlI, lllllllllllllllIlllIIlIlIIlIlIIl, lllllllllllllllIlllIIlIlIIIlIIlI);
        lllllllllllllllIlllIIlIlIIlIIlll.draw();
    }
    
    private void generateSky2() {
        final Tessellator lllllllllllllllIlllIlIllIIllIIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIlllIlIllIIlIllll = lllllllllllllllIlllIlIllIIllIIIl.getBuffer();
        if (this.sky2VBO != null) {
            this.sky2VBO.deleteGlBuffers();
        }
        if (this.glSkyList2 >= 0) {
            GLAllocation.deleteDisplayLists(this.glSkyList2);
            this.glSkyList2 = -1;
        }
        if (this.vboEnabled) {
            this.sky2VBO = new VertexBuffer(this.vertexBufferFormat);
            this.renderSky(lllllllllllllllIlllIlIllIIlIllll, -16.0f, true);
            lllllllllllllllIlllIlIllIIlIllll.finishDrawing();
            lllllllllllllllIlllIlIllIIlIllll.reset();
            this.sky2VBO.bufferData(lllllllllllllllIlllIlIllIIlIllll.getByteBuffer());
        }
        else {
            this.glSkyList2 = GLAllocation.generateDisplayLists(1);
            GlStateManager.glNewList(this.glSkyList2, 4864);
            this.renderSky(lllllllllllllllIlllIlIllIIlIllll, -16.0f, true);
            lllllllllllllllIlllIlIllIIllIIIl.draw();
            GlStateManager.glEndList();
        }
    }
    
    @Override
    public void broadcastSound(final int lllllllllllllllIlllIIIlIlIIllIll, final BlockPos lllllllllllllllIlllIIIlIlIIllIII, final int lllllllllllllllIlllIIIlIlIIlIlll) {
        switch (lllllllllllllllIlllIIIlIlIIllIll) {
            case 1023:
            case 1028:
            case 1038: {
                final Entity lllllllllllllllIlllIIIlIlIIlIllI = this.mc.getRenderViewEntity();
                if (lllllllllllllllIlllIIIlIlIIlIllI == null) {
                    break;
                }
                final double lllllllllllllllIlllIIIlIlIIlIlII = lllllllllllllllIlllIIIlIlIIllIII.getX() - lllllllllllllllIlllIIIlIlIIlIllI.posX;
                final double lllllllllllllllIlllIIIlIlIIlIIlI = lllllllllllllllIlllIIIlIlIIllIII.getY() - lllllllllllllllIlllIIIlIlIIlIllI.posY;
                final double lllllllllllllllIlllIIIlIlIIlIIII = lllllllllllllllIlllIIIlIlIIllIII.getZ() - lllllllllllllllIlllIIIlIlIIlIllI.posZ;
                final double lllllllllllllllIlllIIIlIlIIIlllI = Math.sqrt(lllllllllllllllIlllIIIlIlIIlIlII * lllllllllllllllIlllIIIlIlIIlIlII + lllllllllllllllIlllIIIlIlIIlIIlI * lllllllllllllllIlllIIIlIlIIlIIlI + lllllllllllllllIlllIIIlIlIIlIIII * lllllllllllllllIlllIIIlIlIIlIIII);
                double lllllllllllllllIlllIIIlIlIIIllII = lllllllllllllllIlllIIIlIlIIlIllI.posX;
                double lllllllllllllllIlllIIIlIlIIIlIll = lllllllllllllllIlllIIIlIlIIlIllI.posY;
                double lllllllllllllllIlllIIIlIlIIIlIlI = lllllllllllllllIlllIIIlIlIIlIllI.posZ;
                if (lllllllllllllllIlllIIIlIlIIIlllI > 0.0) {
                    lllllllllllllllIlllIIIlIlIIIllII += lllllllllllllllIlllIIIlIlIIlIlII / lllllllllllllllIlllIIIlIlIIIlllI * 2.0;
                    lllllllllllllllIlllIIIlIlIIIlIll += lllllllllllllllIlllIIIlIlIIlIIlI / lllllllllllllllIlllIIIlIlIIIlllI * 2.0;
                    lllllllllllllllIlllIIIlIlIIIlIlI += lllllllllllllllIlllIIIlIlIIlIIII / lllllllllllllllIlllIIIlIlIIIlllI * 2.0;
                }
                if (lllllllllllllllIlllIIIlIlIIllIll == 1023) {
                    this.theWorld.playSound(lllllllllllllllIlllIIIlIlIIIllII, lllllllllllllllIlllIIIlIlIIIlIll, lllllllllllllllIlllIIIlIlIIIlIlI, SoundEvents.ENTITY_WITHER_SPAWN, SoundCategory.HOSTILE, 1.0f, 1.0f, false);
                    break;
                }
                if (lllllllllllllllIlllIIIlIlIIllIll == 1038) {
                    this.theWorld.playSound(lllllllllllllllIlllIIIlIlIIIllII, lllllllllllllllIlllIIIlIlIIIlIll, lllllllllllllllIlllIIIlIlIIIlIlI, SoundEvents.field_193782_bq, SoundCategory.HOSTILE, 1.0f, 1.0f, false);
                    break;
                }
                this.theWorld.playSound(lllllllllllllllIlllIIIlIlIIIllII, lllllllllllllllIlllIIIlIlIIIlIll, lllllllllllllllIlllIIIlIlIIIlIlI, SoundEvents.ENTITY_ENDERDRAGON_DEATH, SoundCategory.HOSTILE, 5.0f, 1.0f, false);
                break;
            }
        }
    }
    
    private void renderCloudsFancy(final float lllllllllllllllIlllIIllIllIllIll, final int lllllllllllllllIlllIIlllIIIIlllI, final double lllllllllllllllIlllIIlllIIIIllIl, final double lllllllllllllllIlllIIllIllIllIII, final double lllllllllllllllIlllIIllIllIlIlll) {
        final float lllllllllllllllIlllIIlllIIIIlIlI = 0.0f;
        GlStateManager.disableCull();
        final Tessellator lllllllllllllllIlllIIlllIIIIlIIl = Tessellator.getInstance();
        final BufferBuilder lllllllllllllllIlllIIlllIIIIlIII = lllllllllllllllIlllIIlllIIIIlIIl.getBuffer();
        final float lllllllllllllllIlllIIlllIIIIIlll = 12.0f;
        final float lllllllllllllllIlllIIlllIIIIIllI = 4.0f;
        final double lllllllllllllllIlllIIlllIIIIIlIl = this.cloudTickCounter + lllllllllllllllIlllIIlllIIIIlIlI;
        double lllllllllllllllIlllIIlllIIIIIlII = (lllllllllllllllIlllIIlllIIIIllIl + lllllllllllllllIlllIIlllIIIIIlIl * 0.029999999329447746) / 12.0;
        double lllllllllllllllIlllIIlllIIIIIIll = lllllllllllllllIlllIIllIllIlIlll / 12.0 + 0.33000001311302185;
        float lllllllllllllllIlllIIlllIIIIIIlI = this.theWorld.provider.getCloudHeight() - (float)lllllllllllllllIlllIIllIllIllIII + 0.33f;
        lllllllllllllllIlllIIlllIIIIIIlI += this.mc.gameSettings.ofCloudsHeight * 128.0f;
        final int lllllllllllllllIlllIIlllIIIIIIIl = MathHelper.floor(lllllllllllllllIlllIIlllIIIIIlII / 2048.0);
        final int lllllllllllllllIlllIIlllIIIIIIII = MathHelper.floor(lllllllllllllllIlllIIlllIIIIIIll / 2048.0);
        lllllllllllllllIlllIIlllIIIIIlII -= lllllllllllllllIlllIIlllIIIIIIIl * 2048;
        lllllllllllllllIlllIIlllIIIIIIll -= lllllllllllllllIlllIIlllIIIIIIII * 2048;
        this.renderEngine.bindTexture(RenderGlobal.CLOUDS_TEXTURES);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        final Vec3d lllllllllllllllIlllIIllIllllllll = this.theWorld.getCloudColour(lllllllllllllllIlllIIlllIIIIlIlI);
        float lllllllllllllllIlllIIllIlllllllI = (float)lllllllllllllllIlllIIllIllllllll.xCoord;
        float lllllllllllllllIlllIIllIllllllIl = (float)lllllllllllllllIlllIIllIllllllll.yCoord;
        float lllllllllllllllIlllIIllIllllllII = (float)lllllllllllllllIlllIIllIllllllll.zCoord;
        this.cloudRenderer.prepareToRender(true, this.cloudTickCounter, lllllllllllllllIlllIIllIllIllIll, lllllllllllllllIlllIIllIllllllll);
        if (lllllllllllllllIlllIIlllIIIIlllI != 2) {
            final float lllllllllllllllIlllIIllIlllllIll = (lllllllllllllllIlllIIllIlllllllI * 30.0f + lllllllllllllllIlllIIllIllllllIl * 59.0f + lllllllllllllllIlllIIllIllllllII * 11.0f) / 100.0f;
            final float lllllllllllllllIlllIIllIlllllIlI = (lllllllllllllllIlllIIllIlllllllI * 30.0f + lllllllllllllllIlllIIllIllllllIl * 70.0f) / 100.0f;
            final float lllllllllllllllIlllIIllIlllllIIl = (lllllllllllllllIlllIIllIlllllllI * 30.0f + lllllllllllllllIlllIIllIllllllII * 70.0f) / 100.0f;
            lllllllllllllllIlllIIllIlllllllI = lllllllllllllllIlllIIllIlllllIll;
            lllllllllllllllIlllIIllIllllllIl = lllllllllllllllIlllIIllIlllllIlI;
            lllllllllllllllIlllIIllIllllllII = lllllllllllllllIlllIIllIlllllIIl;
        }
        final float lllllllllllllllIlllIIllIlllllIII = lllllllllllllllIlllIIllIlllllllI * 0.9f;
        final float lllllllllllllllIlllIIllIllllIlll = lllllllllllllllIlllIIllIllllllIl * 0.9f;
        final float lllllllllllllllIlllIIllIllllIllI = lllllllllllllllIlllIIllIllllllII * 0.9f;
        final float lllllllllllllllIlllIIllIllllIlIl = lllllllllllllllIlllIIllIlllllllI * 0.7f;
        final float lllllllllllllllIlllIIllIllllIlII = lllllllllllllllIlllIIllIllllllIl * 0.7f;
        final float lllllllllllllllIlllIIllIllllIIll = lllllllllllllllIlllIIllIllllllII * 0.7f;
        final float lllllllllllllllIlllIIllIllllIIlI = lllllllllllllllIlllIIllIlllllllI * 0.8f;
        final float lllllllllllllllIlllIIllIllllIIIl = lllllllllllllllIlllIIllIllllllIl * 0.8f;
        final float lllllllllllllllIlllIIllIllllIIII = lllllllllllllllIlllIIllIllllllII * 0.8f;
        final float lllllllllllllllIlllIIllIlllIllll = 0.00390625f;
        final float lllllllllllllllIlllIIllIlllIlllI = MathHelper.floor(lllllllllllllllIlllIIlllIIIIIlII) * 0.00390625f;
        final float lllllllllllllllIlllIIllIlllIllIl = MathHelper.floor(lllllllllllllllIlllIIlllIIIIIIll) * 0.00390625f;
        final float lllllllllllllllIlllIIllIlllIllII = (float)(lllllllllllllllIlllIIlllIIIIIlII - MathHelper.floor(lllllllllllllllIlllIIlllIIIIIlII));
        final float lllllllllllllllIlllIIllIlllIlIll = (float)(lllllllllllllllIlllIIlllIIIIIIll - MathHelper.floor(lllllllllllllllIlllIIlllIIIIIIll));
        final int lllllllllllllllIlllIIllIlllIlIlI = 8;
        final int lllllllllllllllIlllIIllIlllIlIIl = 4;
        final float lllllllllllllllIlllIIllIlllIlIII = 9.765625E-4f;
        GlStateManager.scale(12.0f, 1.0f, 12.0f);
        for (int lllllllllllllllIlllIIllIlllIIlll = 0; lllllllllllllllIlllIIllIlllIIlll < 2; ++lllllllllllllllIlllIIllIlllIIlll) {
            if (lllllllllllllllIlllIIllIlllIIlll == 0) {
                GlStateManager.colorMask(false, false, false, false);
            }
            else {
                switch (lllllllllllllllIlllIIlllIIIIlllI) {
                    case 0: {
                        GlStateManager.colorMask(false, true, true, true);
                        break;
                    }
                    case 1: {
                        GlStateManager.colorMask(true, false, false, true);
                        break;
                    }
                    case 2: {
                        GlStateManager.colorMask(true, true, true, true);
                        break;
                    }
                }
            }
            this.cloudRenderer.renderGlList();
        }
        if (this.cloudRenderer.shouldUpdateGlList()) {
            this.cloudRenderer.startUpdateGlList();
            for (int lllllllllllllllIlllIIllIlllIIllI = -3; lllllllllllllllIlllIIllIlllIIllI <= 4; ++lllllllllllllllIlllIIllIlllIIllI) {
                for (int lllllllllllllllIlllIIllIlllIIlIl = -3; lllllllllllllllIlllIIllIlllIIlIl <= 4; ++lllllllllllllllIlllIIllIlllIIlIl) {
                    lllllllllllllllIlllIIlllIIIIlIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
                    final float lllllllllllllllIlllIIllIlllIIlII = (float)(lllllllllllllllIlllIIllIlllIIllI * 8);
                    final float lllllllllllllllIlllIIllIlllIIIll = (float)(lllllllllllllllIlllIIllIlllIIlIl * 8);
                    final float lllllllllllllllIlllIIllIlllIIIlI = lllllllllllllllIlllIIllIlllIIlII - lllllllllllllllIlllIIllIlllIllII;
                    final float lllllllllllllllIlllIIllIlllIIIIl = lllllllllllllllIlllIIllIlllIIIll - lllllllllllllllIlllIIllIlllIlIll;
                    if (lllllllllllllllIlllIIlllIIIIIIlI > -5.0f) {
                        lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + 8.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIlIl, lllllllllllllllIlllIIllIllllIlII, lllllllllllllllIlllIIllIllllIIll, 0.8f).normal(0.0f, -1.0f, 0.0f).endVertex();
                        lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 8.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + 8.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIlIl, lllllllllllllllIlllIIllIllllIlII, lllllllllllllllIlllIIllIllllIIll, 0.8f).normal(0.0f, -1.0f, 0.0f).endVertex();
                        lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 8.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIlIl, lllllllllllllllIlllIIllIllllIlII, lllllllllllllllIlllIIllIllllIIll, 0.8f).normal(0.0f, -1.0f, 0.0f).endVertex();
                        lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIlIl, lllllllllllllllIlllIIllIllllIlII, lllllllllllllllIlllIIllIllllIIll, 0.8f).normal(0.0f, -1.0f, 0.0f).endVertex();
                    }
                    if (lllllllllllllllIlllIIlllIIIIIIlI <= 5.0f) {
                        lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f - 9.765625E-4f, lllllllllllllllIlllIIllIlllIIIIl + 8.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllllI, lllllllllllllllIlllIIllIllllllIl, lllllllllllllllIlllIIllIllllllII, 0.8f).normal(0.0f, 1.0f, 0.0f).endVertex();
                        lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 8.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f - 9.765625E-4f, lllllllllllllllIlllIIllIlllIIIIl + 8.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllllI, lllllllllllllllIlllIIllIllllllIl, lllllllllllllllIlllIIllIllllllII, 0.8f).normal(0.0f, 1.0f, 0.0f).endVertex();
                        lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 8.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f - 9.765625E-4f, lllllllllllllllIlllIIllIlllIIIIl + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllllI, lllllllllllllllIlllIIllIllllllIl, lllllllllllllllIlllIIllIllllllII, 0.8f).normal(0.0f, 1.0f, 0.0f).endVertex();
                        lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f - 9.765625E-4f, lllllllllllllllIlllIIllIlllIIIIl + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllllI, lllllllllllllllIlllIIllIllllllIl, lllllllllllllllIlllIIllIllllllII, 0.8f).normal(0.0f, 1.0f, 0.0f).endVertex();
                    }
                    if (lllllllllllllllIlllIIllIlllIIllI > -1) {
                        for (int lllllllllllllllIlllIIllIlllIIIII = 0; lllllllllllllllIlllIIllIlllIIIII < 8; ++lllllllllllllllIlllIIllIlllIIIII) {
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + lllllllllllllllIlllIIllIlllIIIII + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + 8.0f).tex((lllllllllllllllIlllIIllIlllIIlII + lllllllllllllllIlllIIllIlllIIIII + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllIII, lllllllllllllllIlllIIllIllllIlll, lllllllllllllllIlllIIllIllllIllI, 0.8f).normal(-1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + lllllllllllllllIlllIIllIlllIIIII + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f, lllllllllllllllIlllIIllIlllIIIIl + 8.0f).tex((lllllllllllllllIlllIIllIlllIIlII + lllllllllllllllIlllIIllIlllIIIII + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllIII, lllllllllllllllIlllIIllIllllIlll, lllllllllllllllIlllIIllIllllIllI, 0.8f).normal(-1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + lllllllllllllllIlllIIllIlllIIIII + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f, lllllllllllllllIlllIIllIlllIIIIl + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + lllllllllllllllIlllIIllIlllIIIII + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllIII, lllllllllllllllIlllIIllIllllIlll, lllllllllllllllIlllIIllIllllIllI, 0.8f).normal(-1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + lllllllllllllllIlllIIllIlllIIIII + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + lllllllllllllllIlllIIllIlllIIIII + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllIII, lllllllllllllllIlllIIllIllllIlll, lllllllllllllllIlllIIllIllllIllI, 0.8f).normal(-1.0f, 0.0f, 0.0f).endVertex();
                        }
                    }
                    if (lllllllllllllllIlllIIllIlllIIllI <= 1) {
                        for (int lllllllllllllllIlllIIllIllIlllll = 0; lllllllllllllllIlllIIllIllIlllll < 8; ++lllllllllllllllIlllIIllIllIlllll) {
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + lllllllllllllllIlllIIllIllIlllll + 1.0f - 9.765625E-4f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + 8.0f).tex((lllllllllllllllIlllIIllIlllIIlII + lllllllllllllllIlllIIllIllIlllll + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllIII, lllllllllllllllIlllIIllIllllIlll, lllllllllllllllIlllIIllIllllIllI, 0.8f).normal(1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + lllllllllllllllIlllIIllIllIlllll + 1.0f - 9.765625E-4f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f, lllllllllllllllIlllIIllIlllIIIIl + 8.0f).tex((lllllllllllllllIlllIIllIlllIIlII + lllllllllllllllIlllIIllIllIlllll + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllIII, lllllllllllllllIlllIIllIllllIlll, lllllllllllllllIlllIIllIllllIllI, 0.8f).normal(1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + lllllllllllllllIlllIIllIllIlllll + 1.0f - 9.765625E-4f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f, lllllllllllllllIlllIIllIlllIIIIl + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + lllllllllllllllIlllIIllIllIlllll + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllIII, lllllllllllllllIlllIIllIllllIlll, lllllllllllllllIlllIIllIllllIllI, 0.8f).normal(1.0f, 0.0f, 0.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + lllllllllllllllIlllIIllIllIlllll + 1.0f - 9.765625E-4f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + lllllllllllllllIlllIIllIllIlllll + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIlllllIII, lllllllllllllllIlllIIllIllllIlll, lllllllllllllllIlllIIllIllllIllI, 0.8f).normal(1.0f, 0.0f, 0.0f).endVertex();
                        }
                    }
                    if (lllllllllllllllIlllIIllIlllIIlIl > -1) {
                        for (int lllllllllllllllIlllIIllIllIllllI = 0; lllllllllllllllIlllIIllIllIllllI < 8; ++lllllllllllllllIlllIIllIllIllllI) {
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f, lllllllllllllllIlllIIllIlllIIIIl + lllllllllllllllIlllIIllIllIllllI + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + lllllllllllllllIlllIIllIllIllllI + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIIlI, lllllllllllllllIlllIIllIllllIIIl, lllllllllllllllIlllIIllIllllIIII, 0.8f).normal(0.0f, 0.0f, -1.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 8.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f, lllllllllllllllIlllIIllIlllIIIIl + lllllllllllllllIlllIIllIllIllllI + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + lllllllllllllllIlllIIllIllIllllI + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIIlI, lllllllllllllllIlllIIllIllllIIIl, lllllllllllllllIlllIIllIllllIIII, 0.8f).normal(0.0f, 0.0f, -1.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 8.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + lllllllllllllllIlllIIllIllIllllI + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + lllllllllllllllIlllIIllIllIllllI + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIIlI, lllllllllllllllIlllIIllIllllIIIl, lllllllllllllllIlllIIllIllllIIII, 0.8f).normal(0.0f, 0.0f, -1.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + lllllllllllllllIlllIIllIllIllllI + 0.0f).tex((lllllllllllllllIlllIIllIlllIIlII + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + lllllllllllllllIlllIIllIllIllllI + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIIlI, lllllllllllllllIlllIIllIllllIIIl, lllllllllllllllIlllIIllIllllIIII, 0.8f).normal(0.0f, 0.0f, -1.0f).endVertex();
                        }
                    }
                    if (lllllllllllllllIlllIIllIlllIIlIl <= 1) {
                        for (int lllllllllllllllIlllIIllIllIlllIl = 0; lllllllllllllllIlllIIllIllIlllIl < 8; ++lllllllllllllllIlllIIllIllIlllIl) {
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f, lllllllllllllllIlllIIllIlllIIIIl + lllllllllllllllIlllIIllIllIlllIl + 1.0f - 9.765625E-4f).tex((lllllllllllllllIlllIIllIlllIIlII + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + lllllllllllllllIlllIIllIllIlllIl + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIIlI, lllllllllllllllIlllIIllIllllIIIl, lllllllllllllllIlllIIllIllllIIII, 0.8f).normal(0.0f, 0.0f, 1.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 8.0f, lllllllllllllllIlllIIlllIIIIIIlI + 4.0f, lllllllllllllllIlllIIllIlllIIIIl + lllllllllllllllIlllIIllIllIlllIl + 1.0f - 9.765625E-4f).tex((lllllllllllllllIlllIIllIlllIIlII + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + lllllllllllllllIlllIIllIllIlllIl + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIIlI, lllllllllllllllIlllIIllIllllIIIl, lllllllllllllllIlllIIllIllllIIII, 0.8f).normal(0.0f, 0.0f, 1.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 8.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + lllllllllllllllIlllIIllIllIlllIl + 1.0f - 9.765625E-4f).tex((lllllllllllllllIlllIIllIlllIIlII + 8.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + lllllllllllllllIlllIIllIllIlllIl + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIIlI, lllllllllllllllIlllIIllIllllIIIl, lllllllllllllllIlllIIllIllllIIII, 0.8f).normal(0.0f, 0.0f, 1.0f).endVertex();
                            lllllllllllllllIlllIIlllIIIIlIII.pos(lllllllllllllllIlllIIllIlllIIIlI + 0.0f, lllllllllllllllIlllIIlllIIIIIIlI + 0.0f, lllllllllllllllIlllIIllIlllIIIIl + lllllllllllllllIlllIIllIllIlllIl + 1.0f - 9.765625E-4f).tex((lllllllllllllllIlllIIllIlllIIlII + 0.0f) * 0.00390625f + lllllllllllllllIlllIIllIlllIlllI, (lllllllllllllllIlllIIllIlllIIIll + lllllllllllllllIlllIIllIllIlllIl + 0.5f) * 0.00390625f + lllllllllllllllIlllIIllIlllIllIl).color(lllllllllllllllIlllIIllIllllIIlI, lllllllllllllllIlllIIllIllllIIIl, lllllllllllllllIlllIIllIllllIIII, 0.8f).normal(0.0f, 0.0f, 1.0f).endVertex();
                        }
                    }
                    lllllllllllllllIlllIIlllIIIIlIIl.draw();
                }
            }
            this.cloudRenderer.endUpdateGlList();
        }
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.disableBlend();
        GlStateManager.enableCull();
    }
    
    public void renderSky(final float lllllllllllllllIlllIIlllllIIllIl, final int lllllllllllllllIlllIlIIIIIIIllIl) {
        if (Reflector.ForgeWorldProvider_getSkyRenderer.exists()) {
            final WorldProvider lllllllllllllllIlllIlIIIIIIIllII = this.mc.world.provider;
            final Object lllllllllllllllIlllIlIIIIIIIlIll = Reflector.call(lllllllllllllllIlllIlIIIIIIIllII, Reflector.ForgeWorldProvider_getSkyRenderer, new Object[0]);
            if (lllllllllllllllIlllIlIIIIIIIlIll != null) {
                Reflector.callVoid(lllllllllllllllIlllIlIIIIIIIlIll, Reflector.IRenderHandler_render, lllllllllllllllIlllIIlllllIIllIl, this.theWorld, this.mc);
                return;
            }
        }
        if (this.mc.world.provider.getDimensionType() == DimensionType.THE_END) {
            this.renderSkyEnd();
        }
        else if (this.mc.world.provider.isSurfaceWorld()) {
            GlStateManager.disableTexture2D();
            final boolean lllllllllllllllIlllIlIIIIIIIlIlI = Config.isShaders();
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.disableTexture2D();
            }
            Vec3d lllllllllllllllIlllIlIIIIIIIlIIl = this.theWorld.getSkyColor(this.mc.getRenderViewEntity(), lllllllllllllllIlllIIlllllIIllIl);
            lllllllllllllllIlllIlIIIIIIIlIIl = CustomColors.getSkyColor(lllllllllllllllIlllIlIIIIIIIlIIl, this.mc.world, this.mc.getRenderViewEntity().posX, this.mc.getRenderViewEntity().posY + 1.0, this.mc.getRenderViewEntity().posZ);
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.setSkyColor(lllllllllllllllIlllIlIIIIIIIlIIl);
            }
            float lllllllllllllllIlllIlIIIIIIIlIII = (float)lllllllllllllllIlllIlIIIIIIIlIIl.xCoord;
            float lllllllllllllllIlllIlIIIIIIIIlll = (float)lllllllllllllllIlllIlIIIIIIIlIIl.yCoord;
            float lllllllllllllllIlllIlIIIIIIIIllI = (float)lllllllllllllllIlllIlIIIIIIIlIIl.zCoord;
            if (lllllllllllllllIlllIlIIIIIIIllIl != 2) {
                final float lllllllllllllllIlllIlIIIIIIIIlII = (lllllllllllllllIlllIlIIIIIIIlIII * 30.0f + lllllllllllllllIlllIlIIIIIIIIlll * 59.0f + lllllllllllllllIlllIlIIIIIIIIllI * 11.0f) / 100.0f;
                final float lllllllllllllllIlllIlIIIIIIIIIlI = (lllllllllllllllIlllIlIIIIIIIlIII * 30.0f + lllllllllllllllIlllIlIIIIIIIIlll * 70.0f) / 100.0f;
                final float lllllllllllllllIlllIlIIIIIIIIIII = (lllllllllllllllIlllIlIIIIIIIlIII * 30.0f + lllllllllllllllIlllIlIIIIIIIIllI * 70.0f) / 100.0f;
                lllllllllllllllIlllIlIIIIIIIlIII = lllllllllllllllIlllIlIIIIIIIIlII;
                lllllllllllllllIlllIlIIIIIIIIlll = lllllllllllllllIlllIlIIIIIIIIIlI;
                lllllllllllllllIlllIlIIIIIIIIllI = lllllllllllllllIlllIlIIIIIIIIIII;
            }
            GlStateManager.color(lllllllllllllllIlllIlIIIIIIIlIII, lllllllllllllllIlllIlIIIIIIIIlll, lllllllllllllllIlllIlIIIIIIIIllI);
            final Tessellator lllllllllllllllIlllIIllllllllllI = Tessellator.getInstance();
            final BufferBuilder lllllllllllllllIlllIIlllllllllII = lllllllllllllllIlllIIllllllllllI.getBuffer();
            GlStateManager.depthMask(false);
            GlStateManager.enableFog();
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.enableFog();
            }
            GlStateManager.color(lllllllllllllllIlllIlIIIIIIIlIII, lllllllllllllllIlllIlIIIIIIIIlll, lllllllllllllllIlllIlIIIIIIIIllI);
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.preSkyList();
            }
            if (Config.isSkyEnabled()) {
                if (this.vboEnabled) {
                    this.skyVBO.bindBuffer();
                    GlStateManager.glEnableClientState(32884);
                    GlStateManager.glVertexPointer(3, 5126, 12, 0);
                    this.skyVBO.drawArrays(7);
                    this.skyVBO.unbindBuffer();
                    GlStateManager.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.glSkyList);
                }
            }
            GlStateManager.disableFog();
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.disableFog();
            }
            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderHelper.disableStandardItemLighting();
            final float[] lllllllllllllllIlllIIllllllllIlI = this.theWorld.provider.calcSunriseSunsetColors(this.theWorld.getCelestialAngle(lllllllllllllllIlllIIlllllIIllIl), lllllllllllllllIlllIIlllllIIllIl);
            if (lllllllllllllllIlllIIllllllllIlI != null && Config.isSunMoonEnabled()) {
                GlStateManager.disableTexture2D();
                if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                    Shaders.disableTexture2D();
                }
                GlStateManager.shadeModel(7425);
                GlStateManager.pushMatrix();
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate((MathHelper.sin(this.theWorld.getCelestialAngleRadians(lllllllllllllllIlllIIlllllIIllIl)) < 0.0f) ? 180.0f : 0.0f, 0.0f, 0.0f, 1.0f);
                GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                float lllllllllllllllIlllIIllllllllIIl = lllllllllllllllIlllIIllllllllIlI[0];
                float lllllllllllllllIlllIIlllllllIlll = lllllllllllllllIlllIIllllllllIlI[1];
                float lllllllllllllllIlllIIlllllllIlIl = lllllllllllllllIlllIIllllllllIlI[2];
                if (lllllllllllllllIlllIlIIIIIIIllIl != 2) {
                    final float lllllllllllllllIlllIIlllllllIIll = (lllllllllllllllIlllIIllllllllIIl * 30.0f + lllllllllllllllIlllIIlllllllIlll * 59.0f + lllllllllllllllIlllIIlllllllIlIl * 11.0f) / 100.0f;
                    final float lllllllllllllllIlllIIlllllllIIII = (lllllllllllllllIlllIIllllllllIIl * 30.0f + lllllllllllllllIlllIIlllllllIlll * 70.0f) / 100.0f;
                    final float lllllllllllllllIlllIIllllllIlllI = (lllllllllllllllIlllIIllllllllIIl * 30.0f + lllllllllllllllIlllIIlllllllIlIl * 70.0f) / 100.0f;
                    lllllllllllllllIlllIIllllllllIIl = lllllllllllllllIlllIIlllllllIIll;
                    lllllllllllllllIlllIIlllllllIlll = lllllllllllllllIlllIIlllllllIIII;
                    lllllllllllllllIlllIIlllllllIlIl = lllllllllllllllIlllIIllllllIlllI;
                }
                lllllllllllllllIlllIIlllllllllII.begin(6, DefaultVertexFormats.POSITION_COLOR);
                lllllllllllllllIlllIIlllllllllII.pos(0.0, 100.0, 0.0).color(lllllllllllllllIlllIIllllllllIIl, lllllllllllllllIlllIIlllllllIlll, lllllllllllllllIlllIIlllllllIlIl, lllllllllllllllIlllIIllllllllIlI[3]).endVertex();
                final int lllllllllllllllIlllIIllllllIllIl = 16;
                for (int lllllllllllllllIlllIIllllllIlIll = 0; lllllllllllllllIlllIIllllllIlIll <= 16; ++lllllllllllllllIlllIIllllllIlIll) {
                    final float lllllllllllllllIlllIIllllllIlIlI = lllllllllllllllIlllIIllllllIlIll * 6.2831855f / 16.0f;
                    final float lllllllllllllllIlllIIllllllIlIII = MathHelper.sin(lllllllllllllllIlllIIllllllIlIlI);
                    final float lllllllllllllllIlllIIllllllIIllI = MathHelper.cos(lllllllllllllllIlllIIllllllIlIlI);
                    lllllllllllllllIlllIIlllllllllII.pos(lllllllllllllllIlllIIllllllIlIII * 120.0f, lllllllllllllllIlllIIllllllIIllI * 120.0f, -lllllllllllllllIlllIIllllllIIllI * 40.0f * lllllllllllllllIlllIIllllllllIlI[3]).color(lllllllllllllllIlllIIllllllllIlI[0], lllllllllllllllIlllIIllllllllIlI[1], lllllllllllllllIlllIIllllllllIlI[2], 0.0f).endVertex();
                }
                lllllllllllllllIlllIIllllllllllI.draw();
                GlStateManager.popMatrix();
                GlStateManager.shadeModel(7424);
            }
            GlStateManager.enableTexture2D();
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.enableTexture2D();
            }
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.pushMatrix();
            final float lllllllllllllllIlllIIllllllIIlII = 1.0f - this.theWorld.getRainStrength(lllllllllllllllIlllIIlllllIIllIl);
            GlStateManager.color(1.0f, 1.0f, 1.0f, lllllllllllllllIlllIIllllllIIlII);
            GlStateManager.rotate(-90.0f, 0.0f, 1.0f, 0.0f);
            CustomSky.renderSky(this.theWorld, this.renderEngine, lllllllllllllllIlllIIlllllIIllIl);
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.preCelestialRotate();
            }
            GlStateManager.rotate(this.theWorld.getCelestialAngle(lllllllllllllllIlllIIlllllIIllIl) * 360.0f, 1.0f, 0.0f, 0.0f);
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.postCelestialRotate();
            }
            float lllllllllllllllIlllIIllllllIIIlI = 30.0f;
            if (Config.isSunTexture()) {
                this.renderEngine.bindTexture(RenderGlobal.SUN_TEXTURES);
                lllllllllllllllIlllIIlllllllllII.begin(7, DefaultVertexFormats.POSITION_TEX);
                lllllllllllllllIlllIIlllllllllII.pos(-lllllllllllllllIlllIIllllllIIIlI, 100.0, -lllllllllllllllIlllIIllllllIIIlI).tex(0.0, 0.0).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(lllllllllllllllIlllIIllllllIIIlI, 100.0, -lllllllllllllllIlllIIllllllIIIlI).tex(1.0, 0.0).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(lllllllllllllllIlllIIllllllIIIlI, 100.0, lllllllllllllllIlllIIllllllIIIlI).tex(1.0, 1.0).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-lllllllllllllllIlllIIllllllIIIlI, 100.0, lllllllllllllllIlllIIllllllIIIlI).tex(0.0, 1.0).endVertex();
                lllllllllllllllIlllIIllllllllllI.draw();
            }
            lllllllllllllllIlllIIllllllIIIlI = 20.0f;
            if (Config.isMoonTexture()) {
                this.renderEngine.bindTexture(RenderGlobal.MOON_PHASES_TEXTURES);
                final int lllllllllllllllIlllIIllllllIIIII = this.theWorld.getMoonPhase();
                final int lllllllllllllllIlllIIlllllIllllI = lllllllllllllllIlllIIllllllIIIII % 4;
                final int lllllllllllllllIlllIIlllllIlllII = lllllllllllllllIlllIIllllllIIIII / 4 % 2;
                final float lllllllllllllllIlllIIlllllIllIlI = (lllllllllllllllIlllIIlllllIllllI + 0) / 4.0f;
                final float lllllllllllllllIlllIIlllllIlIlll = (lllllllllllllllIlllIIlllllIlllII + 0) / 2.0f;
                final float lllllllllllllllIlllIIlllllIlIlIl = (lllllllllllllllIlllIIlllllIllllI + 1) / 4.0f;
                final float lllllllllllllllIlllIIlllllIlIlII = (lllllllllllllllIlllIIlllllIlllII + 1) / 2.0f;
                lllllllllllllllIlllIIlllllllllII.begin(7, DefaultVertexFormats.POSITION_TEX);
                lllllllllllllllIlllIIlllllllllII.pos(-lllllllllllllllIlllIIllllllIIIlI, -100.0, lllllllllllllllIlllIIllllllIIIlI).tex(lllllllllllllllIlllIIlllllIlIlIl, lllllllllllllllIlllIIlllllIlIlII).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(lllllllllllllllIlllIIllllllIIIlI, -100.0, lllllllllllllllIlllIIllllllIIIlI).tex(lllllllllllllllIlllIIlllllIllIlI, lllllllllllllllIlllIIlllllIlIlII).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(lllllllllllllllIlllIIllllllIIIlI, -100.0, -lllllllllllllllIlllIIllllllIIIlI).tex(lllllllllllllllIlllIIlllllIllIlI, lllllllllllllllIlllIIlllllIlIlll).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-lllllllllllllllIlllIIllllllIIIlI, -100.0, -lllllllllllllllIlllIIllllllIIIlI).tex(lllllllllllllllIlllIIlllllIlIlIl, lllllllllllllllIlllIIlllllIlIlll).endVertex();
                lllllllllllllllIlllIIllllllllllI.draw();
            }
            GlStateManager.disableTexture2D();
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.disableTexture2D();
            }
            final float lllllllllllllllIlllIIlllllIlIIll = this.theWorld.getStarBrightness(lllllllllllllllIlllIIlllllIIllIl) * lllllllllllllllIlllIIllllllIIlII;
            if (lllllllllllllllIlllIIlllllIlIIll > 0.0f && Config.isStarsEnabled() && !CustomSky.hasSkyLayers(this.theWorld)) {
                GlStateManager.color(lllllllllllllllIlllIIlllllIlIIll, lllllllllllllllIlllIIlllllIlIIll, lllllllllllllllIlllIIlllllIlIIll, lllllllllllllllIlllIIlllllIlIIll);
                if (this.vboEnabled) {
                    this.starVBO.bindBuffer();
                    GlStateManager.glEnableClientState(32884);
                    GlStateManager.glVertexPointer(3, 5126, 12, 0);
                    this.starVBO.drawArrays(7);
                    this.starVBO.unbindBuffer();
                    GlStateManager.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.starGLCallList);
                }
            }
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.enableFog();
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.enableFog();
            }
            GlStateManager.popMatrix();
            GlStateManager.disableTexture2D();
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.disableTexture2D();
            }
            GlStateManager.color(0.0f, 0.0f, 0.0f);
            final double lllllllllllllllIlllIIlllllIlIIlI = this.mc.player.getPositionEyes(lllllllllllllllIlllIIlllllIIllIl).yCoord - this.theWorld.getHorizon();
            if (lllllllllllllllIlllIIlllllIlIIlI < 0.0) {
                GlStateManager.pushMatrix();
                GlStateManager.translate(0.0f, 12.0f, 0.0f);
                if (this.vboEnabled) {
                    this.sky2VBO.bindBuffer();
                    GlStateManager.glEnableClientState(32884);
                    GlStateManager.glVertexPointer(3, 5126, 12, 0);
                    this.sky2VBO.drawArrays(7);
                    this.sky2VBO.unbindBuffer();
                    GlStateManager.glDisableClientState(32884);
                }
                else {
                    GlStateManager.callList(this.glSkyList2);
                }
                GlStateManager.popMatrix();
                final float lllllllllllllllIlllIIlllllIlIIIl = 1.0f;
                final float lllllllllllllllIlllIIlllllIlIIII = -(float)(lllllllllllllllIlllIIlllllIlIIlI + 65.0);
                final float lllllllllllllllIlllIIlllllIIllll = -1.0f;
                lllllllllllllllIlllIIlllllllllII.begin(7, DefaultVertexFormats.POSITION_COLOR);
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, lllllllllllllllIlllIIlllllIlIIII, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, lllllllllllllllIlllIIlllllIlIIII, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, lllllllllllllllIlllIIlllllIlIIII, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, lllllllllllllllIlllIIlllllIlIIII, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, lllllllllllllllIlllIIlllllIlIIII, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, lllllllllllllllIlllIIlllllIlIIII, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, lllllllllllllllIlllIIlllllIlIIII, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, lllllllllllllllIlllIIlllllIlIIII, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(-1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, -1.0, 1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIlllllllllII.pos(1.0, -1.0, -1.0).color(0, 0, 0, 255).endVertex();
                lllllllllllllllIlllIIllllllllllI.draw();
            }
            if (this.theWorld.provider.isSkyColored()) {
                GlStateManager.color(lllllllllllllllIlllIlIIIIIIIlIII * 0.2f + 0.04f, lllllllllllllllIlllIlIIIIIIIIlll * 0.2f + 0.04f, lllllllllllllllIlllIlIIIIIIIIllI * 0.6f + 0.1f);
            }
            else {
                GlStateManager.color(lllllllllllllllIlllIlIIIIIIIlIII, lllllllllllllllIlllIlIIIIIIIIlll, lllllllllllllllIlllIlIIIIIIIIllI);
            }
            if (this.mc.gameSettings.renderDistanceChunks <= 4) {
                GlStateManager.color(this.mc.entityRenderer.fogColorRed, this.mc.entityRenderer.fogColorGreen, this.mc.entityRenderer.fogColorBlue);
            }
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, -(float)(lllllllllllllllIlllIIlllllIlIIlI - 16.0), 0.0f);
            if (Config.isSkyEnabled()) {
                GlStateManager.callList(this.glSkyList2);
            }
            GlStateManager.popMatrix();
            GlStateManager.enableTexture2D();
            if (lllllllllllllllIlllIlIIIIIIIlIlI) {
                Shaders.enableTexture2D();
            }
            GlStateManager.depthMask(true);
        }
    }
    
    private void fixTerrainFrustum(final double lllllllllllllllIlllIlIIIllllIIlI, final double lllllllllllllllIlllIlIIIllllIIIl, final double lllllllllllllllIlllIlIIIlllllIII) {
        this.debugFixedClippingHelper = new ClippingHelperImpl();
        ((ClippingHelperImpl)this.debugFixedClippingHelper).init();
        final Matrix4f lllllllllllllllIlllIlIIIllllIlll = new Matrix4f(this.debugFixedClippingHelper.modelviewMatrix);
        lllllllllllllllIlllIlIIIllllIlll.transpose();
        final Matrix4f lllllllllllllllIlllIlIIIllllIllI = new Matrix4f(this.debugFixedClippingHelper.projectionMatrix);
        lllllllllllllllIlllIlIIIllllIllI.transpose();
        final Matrix4f lllllllllllllllIlllIlIIIllllIlIl = new Matrix4f();
        Matrix4f.mul((org.lwjgl.util.vector.Matrix4f)lllllllllllllllIlllIlIIIllllIllI, (org.lwjgl.util.vector.Matrix4f)lllllllllllllllIlllIlIIIllllIlll, (org.lwjgl.util.vector.Matrix4f)lllllllllllllllIlllIlIIIllllIlIl);
        lllllllllllllllIlllIlIIIllllIlIl.invert();
        this.debugTerrainFrustumPosition.x = lllllllllllllllIlllIlIIIllllIIlI;
        this.debugTerrainFrustumPosition.y = lllllllllllllllIlllIlIIIllllIIIl;
        this.debugTerrainFrustumPosition.z = lllllllllllllllIlllIlIIIlllllIII;
        this.debugTerrainMatrix[0] = new Vector4f(-1.0f, -1.0f, -1.0f, 1.0f);
        this.debugTerrainMatrix[1] = new Vector4f(1.0f, -1.0f, -1.0f, 1.0f);
        this.debugTerrainMatrix[2] = new Vector4f(1.0f, 1.0f, -1.0f, 1.0f);
        this.debugTerrainMatrix[3] = new Vector4f(-1.0f, 1.0f, -1.0f, 1.0f);
        this.debugTerrainMatrix[4] = new Vector4f(-1.0f, -1.0f, 1.0f, 1.0f);
        this.debugTerrainMatrix[5] = new Vector4f(1.0f, -1.0f, 1.0f, 1.0f);
        this.debugTerrainMatrix[6] = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.debugTerrainMatrix[7] = new Vector4f(-1.0f, 1.0f, 1.0f, 1.0f);
        for (int lllllllllllllllIlllIlIIIllllIlII = 0; lllllllllllllllIlllIlIIIllllIlII < 8; ++lllllllllllllllIlllIlIIIllllIlII) {
            Matrix4f.transform((org.lwjgl.util.vector.Matrix4f)lllllllllllllllIlllIlIIIllllIlIl, this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII], this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII]);
            final Vector4f vector4f = this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII];
            vector4f.x /= this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII].w;
            final Vector4f vector4f2 = this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII];
            vector4f2.y /= this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII].w;
            final Vector4f vector4f3 = this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII];
            vector4f3.z /= this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII].w;
            this.debugTerrainMatrix[lllllllllllllllIlllIlIIIllllIlII].w = 1.0f;
        }
    }
    
    public void drawSelectionBox(final EntityPlayer lllllllllllllllIlllIIlIlIllllIIl, final RayTraceResult lllllllllllllllIlllIIlIlIllllIII, final int lllllllllllllllIlllIIlIllIIIIIlI, final float lllllllllllllllIlllIIlIlIlllIlII) {
        if (lllllllllllllllIlllIIlIllIIIIIlI == 0 && lllllllllllllllIlllIIlIlIllllIII.typeOfHit == RayTraceResult.Type.BLOCK) {
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.glLineWidth(2.0f);
            GlStateManager.disableTexture2D();
            if (Config.isShaders()) {
                Shaders.disableTexture2D();
            }
            GlStateManager.depthMask(false);
            final BlockPos lllllllllllllllIlllIIlIllIIIIIII = lllllllllllllllIlllIIlIlIllllIII.getBlockPos();
            final IBlockState lllllllllllllllIlllIIlIlIlllllll = this.theWorld.getBlockState(lllllllllllllllIlllIIlIllIIIIIII);
            if (lllllllllllllllIlllIIlIlIlllllll.getMaterial() != Material.AIR && this.theWorld.getWorldBorder().contains(lllllllllllllllIlllIIlIllIIIIIII)) {
                final double lllllllllllllllIlllIIlIlIllllllI = lllllllllllllllIlllIIlIlIllllIIl.lastTickPosX + (lllllllllllllllIlllIIlIlIllllIIl.posX - lllllllllllllllIlllIIlIlIllllIIl.lastTickPosX) * lllllllllllllllIlllIIlIlIlllIlII;
                final double lllllllllllllllIlllIIlIlIlllllIl = lllllllllllllllIlllIIlIlIllllIIl.lastTickPosY + (lllllllllllllllIlllIIlIlIllllIIl.posY - lllllllllllllllIlllIIlIlIllllIIl.lastTickPosY) * lllllllllllllllIlllIIlIlIlllIlII;
                final double lllllllllllllllIlllIIlIlIlllllII = lllllllllllllllIlllIIlIlIllllIIl.lastTickPosZ + (lllllllllllllllIlllIIlIlIllllIIl.posZ - lllllllllllllllIlllIIlIlIllllIIl.lastTickPosZ) * lllllllllllllllIlllIIlIlIlllIlII;
                drawSelectionBoundingBox(lllllllllllllllIlllIIlIlIlllllll.getSelectedBoundingBox(this.theWorld, lllllllllllllllIlllIIlIllIIIIIII).expandXyz(0.0020000000949949026).offset(-lllllllllllllllIlllIIlIlIllllllI, -lllllllllllllllIlllIIlIlIlllllIl, -lllllllllllllllIlllIIlIlIlllllII), 0.0f, 0.0f, 0.0f, 0.4f);
            }
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            if (Config.isShaders()) {
                Shaders.enableTexture2D();
            }
            GlStateManager.disableBlend();
        }
    }
    
    private Set<EnumFacing> getVisibleFacings(final BlockPos lllllllllllllllIlllIlIIlIIlllllI) {
        final VisGraph lllllllllllllllIlllIlIIlIIllllII = new VisGraph();
        final BlockPos lllllllllllllllIlllIlIIlIIlllIlI = new BlockPos(lllllllllllllllIlllIlIIlIIlllllI.getX() >> 4 << 4, lllllllllllllllIlllIlIIlIIlllllI.getY() >> 4 << 4, lllllllllllllllIlllIlIIlIIlllllI.getZ() >> 4 << 4);
        final Chunk lllllllllllllllIlllIlIIlIIlllIII = this.theWorld.getChunkFromBlockCoords(lllllllllllllllIlllIlIIlIIlllIlI);
        for (final BlockPos.MutableBlockPos lllllllllllllllIlllIlIIlIIllIllI : BlockPos.getAllInBoxMutable(lllllllllllllllIlllIlIIlIIlllIlI, lllllllllllllllIlllIlIIlIIlllIlI.add(15, 15, 15))) {
            if (lllllllllllllllIlllIlIIlIIlllIII.getBlockState(lllllllllllllllIlllIlIIlIIllIllI).isOpaqueCube()) {
                lllllllllllllllIlllIlIIlIIllllII.setOpaqueCube(lllllllllllllllIlllIlIIlIIllIllI);
            }
        }
        return lllllllllllllllIlllIlIIlIIllllII.getVisibleFacings(lllllllllllllllIlllIlIIlIIlllllI);
    }
    
    public RenderGlobal(final Minecraft lllllllllllllllIlllIlIlllIIIlIll) {
        this.chunksToUpdate = (Set<RenderChunk>)Sets.newLinkedHashSet();
        this.renderInfos = (List<ContainerLocalRenderInformation>)Lists.newArrayListWithCapacity(69696);
        this.setTileEntities = (Set<TileEntity>)Sets.newHashSet();
        this.starGLCallList = -1;
        this.glSkyList = -1;
        this.glSkyList2 = -1;
        this.damagedBlocks = (Map<Integer, DestroyBlockProgress>)Maps.newHashMap();
        this.mapSoundPositions = (Map<BlockPos, ISound>)Maps.newHashMap();
        this.destroyBlockIcons = new TextureAtlasSprite[10];
        this.frustumUpdatePosX = Double.MIN_VALUE;
        this.frustumUpdatePosY = Double.MIN_VALUE;
        this.frustumUpdatePosZ = Double.MIN_VALUE;
        this.frustumUpdatePosChunkX = Integer.MIN_VALUE;
        this.frustumUpdatePosChunkY = Integer.MIN_VALUE;
        this.frustumUpdatePosChunkZ = Integer.MIN_VALUE;
        this.lastViewEntityX = Double.MIN_VALUE;
        this.lastViewEntityY = Double.MIN_VALUE;
        this.lastViewEntityZ = Double.MIN_VALUE;
        this.lastViewEntityPitch = Double.MIN_VALUE;
        this.lastViewEntityYaw = Double.MIN_VALUE;
        this.renderDistanceChunks = -1;
        this.renderEntitiesStartupCounter = 2;
        this.debugTerrainMatrix = new Vector4f[8];
        this.debugTerrainFrustumPosition = new Vector3d();
        this.displayListEntitiesDirty = true;
        this.setLightUpdates = (Set<BlockPos>)Sets.newHashSet();
        this.chunksToResortTransparency = new LinkedHashSet();
        this.chunksToUpdateForced = new LinkedHashSet();
        this.visibilityDeque = new ArrayDeque();
        this.renderInfosEntities = new ArrayList(1024);
        this.renderInfosTileEntities = new ArrayList(1024);
        this.renderInfosNormal = new ArrayList(1024);
        this.renderInfosEntitiesNormal = new ArrayList(1024);
        this.renderInfosTileEntitiesNormal = new ArrayList(1024);
        this.renderInfosShadow = new ArrayList(1024);
        this.renderInfosEntitiesShadow = new ArrayList(1024);
        this.renderInfosTileEntitiesShadow = new ArrayList(1024);
        this.renderDistance = 0;
        this.renderDistanceSq = 0;
        this.worldChunkProvider = null;
        this.worldChunkProviderMap = null;
        this.countLoadedChunksPrev = 0;
        this.renderEnv = new RenderEnv(this.theWorld, Blocks.AIR.getDefaultState(), new BlockPos(0, 0, 0));
        this.renderOverlayDamaged = false;
        this.renderOverlayEyes = false;
        this.cloudRenderer = new CloudRenderer(lllllllllllllllIlllIlIlllIIIlIll);
        this.mc = lllllllllllllllIlllIlIlllIIIlIll;
        this.renderManager = lllllllllllllllIlllIlIlllIIIlIll.getRenderManager();
        this.renderEngine = lllllllllllllllIlllIlIlllIIIlIll.getTextureManager();
        this.renderEngine.bindTexture(RenderGlobal.FORCEFIELD_TEXTURES);
        GlStateManager.glTexParameteri(3553, 10242, 10497);
        GlStateManager.glTexParameteri(3553, 10243, 10497);
        GlStateManager.bindTexture(0);
        this.updateDestroyBlockIcons();
        this.vboEnabled = OpenGlHelper.useVbo();
        if (this.vboEnabled) {
            this.renderContainer = new VboRenderList();
            this.renderChunkFactory = new VboChunkFactory();
        }
        else {
            this.renderContainer = new RenderList();
            this.renderChunkFactory = new ListChunkFactory();
        }
        this.vertexBufferFormat = new VertexFormat();
        this.vertexBufferFormat.addElement(new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3));
        this.generateStars();
        this.generateSky();
        this.generateSky2();
    }
    
    @Override
    public void onResourceManagerReload(final IResourceManager lllllllllllllllIlllIlIlllIIIIlII) {
        this.updateDestroyBlockIcons();
    }
    
    private void renderSky(final BufferBuilder lllllllllllllllIlllIlIllIIIIIIII, final float lllllllllllllllIlllIlIllIIIIlIII, final boolean lllllllllllllllIlllIlIllIIIIIlll) {
        final int lllllllllllllllIlllIlIllIIIIIllI = 64;
        final int lllllllllllllllIlllIlIllIIIIIlIl = 6;
        lllllllllllllllIlllIlIllIIIIIIII.begin(7, DefaultVertexFormats.POSITION);
        for (int lllllllllllllllIlllIlIllIIIIIlII = -384; lllllllllllllllIlllIlIllIIIIIlII <= 384; lllllllllllllllIlllIlIllIIIIIlII += 64) {
            for (int lllllllllllllllIlllIlIllIIIIIIll = -384; lllllllllllllllIlllIlIllIIIIIIll <= 384; lllllllllllllllIlllIlIllIIIIIIll += 64) {
                float lllllllllllllllIlllIlIllIIIIIIlI = (float)lllllllllllllllIlllIlIllIIIIIlII;
                float lllllllllllllllIlllIlIllIIIIIIIl = (float)(lllllllllllllllIlllIlIllIIIIIlII + 64);
                if (lllllllllllllllIlllIlIllIIIIIlll) {
                    lllllllllllllllIlllIlIllIIIIIIIl = (float)lllllllllllllllIlllIlIllIIIIIlII;
                    lllllllllllllllIlllIlIllIIIIIIlI = (float)(lllllllllllllllIlllIlIllIIIIIlII + 64);
                }
                lllllllllllllllIlllIlIllIIIIIIII.pos(lllllllllllllllIlllIlIllIIIIIIlI, lllllllllllllllIlllIlIllIIIIlIII, lllllllllllllllIlllIlIllIIIIIIll).endVertex();
                lllllllllllllllIlllIlIllIIIIIIII.pos(lllllllllllllllIlllIlIllIIIIIIIl, lllllllllllllllIlllIlIllIIIIlIII, lllllllllllllllIlllIlIllIIIIIIll).endVertex();
                lllllllllllllllIlllIlIllIIIIIIII.pos(lllllllllllllllIlllIlIllIIIIIIIl, lllllllllllllllIlllIlIllIIIIlIII, lllllllllllllllIlllIlIllIIIIIIll + 64).endVertex();
                lllllllllllllllIlllIlIllIIIIIIII.pos(lllllllllllllllIlllIlIllIIIIIIlI, lllllllllllllllIlllIlIllIIIIlIII, lllllllllllllllIlllIlIllIIIIIIll + 64).endVertex();
            }
        }
    }
    
    static {
        LOGGER = LogManager.getLogger();
        MOON_PHASES_TEXTURES = new ResourceLocation("textures/environment/moon_phases.png");
        SUN_TEXTURES = new ResourceLocation("textures/environment/sun.png");
        CLOUDS_TEXTURES = new ResourceLocation("textures/environment/clouds.png");
        END_SKY_TEXTURES = new ResourceLocation("textures/environment/end_sky.png");
        FORCEFIELD_TEXTURES = new ResourceLocation("textures/misc/forcefield.png");
        SET_ALL_FACINGS = Collections.unmodifiableSet((Set<?>)new HashSet<Object>(Arrays.asList(EnumFacing.VALUES)));
        RenderGlobal.renderInfoCache = new ArrayDeque<ContainerLocalRenderInformation>();
    }
    
    @Override
    public void notifyBlockUpdate(final World lllllllllllllllIlllIIIllllllIllI, final BlockPos lllllllllllllllIlllIIIlllllIIlIl, final IBlockState lllllllllllllllIlllIIIllllllIIlI, final IBlockState lllllllllllllllIlllIIIllllllIIII, final int lllllllllllllllIlllIIIlllllIIIll) {
        final int lllllllllllllllIlllIIIlllllIllII = lllllllllllllllIlllIIIlllllIIlIl.getX();
        final int lllllllllllllllIlllIIIlllllIlIlI = lllllllllllllllIlllIIIlllllIIlIl.getY();
        final int lllllllllllllllIlllIIIlllllIlIIl = lllllllllllllllIlllIIIlllllIIlIl.getZ();
        this.markBlocksForUpdate(lllllllllllllllIlllIIIlllllIllII - 1, lllllllllllllllIlllIIIlllllIlIlI - 1, lllllllllllllllIlllIIIlllllIlIIl - 1, lllllllllllllllIlllIIIlllllIllII + 1, lllllllllllllllIlllIIIlllllIlIlI + 1, lllllllllllllllIlllIIIlllllIlIIl + 1, (lllllllllllllllIlllIIIlllllIIIll & 0x8) != 0x0);
    }
    
    private void renderSkyEnd() {
        if (Config.isSkyEnabled()) {
            GlStateManager.disableFog();
            GlStateManager.disableAlpha();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderHelper.disableStandardItemLighting();
            GlStateManager.depthMask(false);
            this.renderEngine.bindTexture(RenderGlobal.END_SKY_TEXTURES);
            final Tessellator lllllllllllllllIlllIlIIIIlllIIIl = Tessellator.getInstance();
            final BufferBuilder lllllllllllllllIlllIlIIIIlllIIII = lllllllllllllllIlllIlIIIIlllIIIl.getBuffer();
            for (int lllllllllllllllIlllIlIIIIllIllll = 0; lllllllllllllllIlllIlIIIIllIllll < 6; ++lllllllllllllllIlllIlIIIIllIllll) {
                GlStateManager.pushMatrix();
                if (lllllllllllllllIlllIlIIIIllIllll == 1) {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (lllllllllllllllIlllIlIIIIllIllll == 2) {
                    GlStateManager.rotate(-90.0f, 1.0f, 0.0f, 0.0f);
                }
                if (lllllllllllllllIlllIlIIIIllIllll == 3) {
                    GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                }
                if (lllllllllllllllIlllIlIIIIllIllll == 4) {
                    GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                }
                if (lllllllllllllllIlllIlIIIIllIllll == 5) {
                    GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                }
                lllllllllllllllIlllIlIIIIlllIIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                int lllllllllllllllIlllIlIIIIllIlllI = 40;
                int lllllllllllllllIlllIlIIIIllIllIl = 40;
                int lllllllllllllllIlllIlIIIIllIllII = 40;
                if (Config.isCustomColors()) {
                    Vec3d lllllllllllllllIlllIlIIIIllIlIll = new Vec3d(lllllllllllllllIlllIlIIIIllIlllI / 255.0, lllllllllllllllIlllIlIIIIllIllIl / 255.0, lllllllllllllllIlllIlIIIIllIllII / 255.0);
                    lllllllllllllllIlllIlIIIIllIlIll = CustomColors.getWorldSkyColor(lllllllllllllllIlllIlIIIIllIlIll, this.theWorld, this.mc.getRenderViewEntity(), 0.0f);
                    lllllllllllllllIlllIlIIIIllIlllI = (int)(lllllllllllllllIlllIlIIIIllIlIll.xCoord * 255.0);
                    lllllllllllllllIlllIlIIIIllIllIl = (int)(lllllllllllllllIlllIlIIIIllIlIll.yCoord * 255.0);
                    lllllllllllllllIlllIlIIIIllIllII = (int)(lllllllllllllllIlllIlIIIIllIlIll.zCoord * 255.0);
                }
                lllllllllllllllIlllIlIIIIlllIIII.pos(-100.0, -100.0, -100.0).tex(0.0, 0.0).color(lllllllllllllllIlllIlIIIIllIlllI, lllllllllllllllIlllIlIIIIllIllIl, lllllllllllllllIlllIlIIIIllIllII, 255).endVertex();
                lllllllllllllllIlllIlIIIIlllIIII.pos(-100.0, -100.0, 100.0).tex(0.0, 16.0).color(lllllllllllllllIlllIlIIIIllIlllI, lllllllllllllllIlllIlIIIIllIllIl, lllllllllllllllIlllIlIIIIllIllII, 255).endVertex();
                lllllllllllllllIlllIlIIIIlllIIII.pos(100.0, -100.0, 100.0).tex(16.0, 16.0).color(lllllllllllllllIlllIlIIIIllIlllI, lllllllllllllllIlllIlIIIIllIllIl, lllllllllllllllIlllIlIIIIllIllII, 255).endVertex();
                lllllllllllllllIlllIlIIIIlllIIII.pos(100.0, -100.0, -100.0).tex(16.0, 0.0).color(lllllllllllllllIlllIlIIIIllIlllI, lllllllllllllllIlllIlIIIIllIllIl, lllllllllllllllIlllIlIIIIllIllII, 255).endVertex();
                lllllllllllllllIlllIlIIIIlllIIIl.draw();
                GlStateManager.popMatrix();
            }
            GlStateManager.depthMask(true);
            GlStateManager.enableTexture2D();
            GlStateManager.enableAlpha();
            GlStateManager.disableBlend();
        }
    }
    
    public void updateChunks(long lllllllllllllllIlllIIllIlIIllIIl) {
        lllllllllllllllIlllIIllIlIIllIIl += (long)1.0E8;
        this.displayListEntitiesDirty |= this.renderDispatcher.runChunkUploads(lllllllllllllllIlllIIllIlIIllIIl);
        if (this.chunksToUpdateForced.size() > 0) {
            final Iterator lllllllllllllllIlllIIllIlIlIIlIl = this.chunksToUpdateForced.iterator();
            while (lllllllllllllllIlllIIllIlIlIIlIl.hasNext()) {
                final RenderChunk lllllllllllllllIlllIIllIlIlIIlII = lllllllllllllllIlllIIllIlIlIIlIl.next();
                if (!this.renderDispatcher.updateChunkLater(lllllllllllllllIlllIIllIlIlIIlII)) {
                    break;
                }
                lllllllllllllllIlllIIllIlIlIIlII.clearNeedsUpdate();
                lllllllllllllllIlllIIllIlIlIIlIl.remove();
                this.chunksToUpdate.remove(lllllllllllllllIlllIIllIlIlIIlII);
                this.chunksToResortTransparency.remove(lllllllllllllllIlllIIllIlIlIIlII);
            }
        }
        if (this.chunksToResortTransparency.size() > 0) {
            final Iterator lllllllllllllllIlllIIllIlIlIIIll = this.chunksToResortTransparency.iterator();
            if (lllllllllllllllIlllIIllIlIlIIIll.hasNext()) {
                final RenderChunk lllllllllllllllIlllIIllIlIlIIIlI = lllllllllllllllIlllIIllIlIlIIIll.next();
                if (this.renderDispatcher.updateTransparencyLater(lllllllllllllllIlllIIllIlIlIIIlI)) {
                    lllllllllllllllIlllIIllIlIlIIIll.remove();
                }
            }
        }
        int lllllllllllllllIlllIIllIlIlIIIIl = 0;
        int lllllllllllllllIlllIIllIlIlIIIII = Config.getUpdatesPerFrame();
        final int lllllllllllllllIlllIIllIlIIlllll = lllllllllllllllIlllIIllIlIlIIIII * 2;
        if (!this.chunksToUpdate.isEmpty()) {
            final Iterator<RenderChunk> lllllllllllllllIlllIIllIlIIllllI = this.chunksToUpdate.iterator();
            while (lllllllllllllllIlllIIllIlIIllllI.hasNext()) {
                final RenderChunk lllllllllllllllIlllIIllIlIIlllIl = lllllllllllllllIlllIIllIlIIllllI.next();
                boolean lllllllllllllllIlllIIllIlIIllIll = false;
                if (lllllllllllllllIlllIIllIlIIlllIl.isNeedsUpdateCustom()) {
                    final boolean lllllllllllllllIlllIIllIlIIlllII = this.renderDispatcher.updateChunkNow(lllllllllllllllIlllIIllIlIIlllIl);
                }
                else {
                    lllllllllllllllIlllIIllIlIIllIll = this.renderDispatcher.updateChunkLater(lllllllllllllllIlllIIllIlIIlllIl);
                }
                if (!lllllllllllllllIlllIIllIlIIllIll) {
                    break;
                }
                lllllllllllllllIlllIIllIlIIlllIl.clearNeedsUpdate();
                lllllllllllllllIlllIIllIlIIllllI.remove();
                if (lllllllllllllllIlllIIllIlIIlllIl.getCompiledChunk().isEmpty() && lllllllllllllllIlllIIllIlIlIIIII < lllllllllllllllIlllIIllIlIIlllll) {
                    ++lllllllllllllllIlllIIllIlIlIIIII;
                }
                if (++lllllllllllllllIlllIIllIlIlIIIIl >= lllllllllllllllIlllIIllIlIlIIIII) {
                    break;
                }
            }
        }
    }
    
    public boolean hasCloudFog(final double lllllllllllllllIlllIIlllIlIIIIIl, final double lllllllllllllllIlllIIlllIlIIIIII, final double lllllllllllllllIlllIIlllIIllllll, final float lllllllllllllllIlllIIlllIIlllllI) {
        return false;
    }
    
    public static void renderFilledBox(final AxisAlignedBB lllllllllllllllIlllIIlIIlIlIIlIl, final float lllllllllllllllIlllIIlIIlIlIIIll, final float lllllllllllllllIlllIIlIIlIlIlIll, final float lllllllllllllllIlllIIlIIlIlIlIIl, final float lllllllllllllllIlllIIlIIlIIlllIl) {
        renderFilledBox(lllllllllllllllIlllIIlIIlIlIIlIl.minX, lllllllllllllllIlllIIlIIlIlIIlIl.minY, lllllllllllllllIlllIIlIIlIlIIlIl.minZ, lllllllllllllllIlllIIlIIlIlIIlIl.maxX, lllllllllllllllIlllIIlIIlIlIIlIl.maxY, lllllllllllllllIlllIIlIIlIlIIlIl.maxZ, lllllllllllllllIlllIIlIIlIlIIIll, lllllllllllllllIlllIIlIIlIlIlIll, lllllllllllllllIlllIIlIIlIlIlIIl, lllllllllllllllIlllIIlIIlIIlllIl);
    }
    
    public void setWorldAndLoadRenderers(@Nullable final WorldClient lllllllllllllllIlllIlIlIlIIIllIl) {
        if (this.theWorld != null) {
            this.theWorld.removeEventListener(this);
        }
        this.frustumUpdatePosX = Double.MIN_VALUE;
        this.frustumUpdatePosY = Double.MIN_VALUE;
        this.frustumUpdatePosZ = Double.MIN_VALUE;
        this.frustumUpdatePosChunkX = Integer.MIN_VALUE;
        this.frustumUpdatePosChunkY = Integer.MIN_VALUE;
        this.frustumUpdatePosChunkZ = Integer.MIN_VALUE;
        this.renderManager.set(lllllllllllllllIlllIlIlIlIIIllIl);
        this.theWorld = lllllllllllllllIlllIlIlIlIIIllIl;
        if (Config.isDynamicLights()) {
            DynamicLights.clear();
        }
        if (lllllllllllllllIlllIlIlIlIIIllIl != null) {
            lllllllllllllllIlllIlIlIlIIIllIl.addEventListener(this);
            this.loadRenderers();
        }
        else {
            this.chunksToUpdate.clear();
            this.renderInfos.clear();
            if (this.viewFrustum != null) {
                this.viewFrustum.deleteGlResources();
                this.viewFrustum = null;
            }
            if (this.renderDispatcher != null) {
                this.renderDispatcher.stopWorkerThreads();
            }
            this.renderDispatcher = null;
        }
    }
    
    @Nullable
    private Particle spawnEntityFX(final int lllllllllllllllIlllIIIllIIIIlIII, final boolean lllllllllllllllIlllIIIlIllllllIl, final double lllllllllllllllIlllIIIlIllllllII, final double lllllllllllllllIlllIIIllIIIIIlIl, final double lllllllllllllllIlllIIIlIlllllIlI, final double lllllllllllllllIlllIIIllIIIIIIll, final double lllllllllllllllIlllIIIlIlllllIII, final double lllllllllllllllIlllIIIlIllllIlll, final int... lllllllllllllllIlllIIIlIllllIllI) {
        return this.func_190571_b(lllllllllllllllIlllIIIllIIIIlIII, lllllllllllllllIlllIIIlIllllllIl, false, lllllllllllllllIlllIIIlIllllllII, lllllllllllllllIlllIIIllIIIIIlIl, lllllllllllllllIlllIIIlIlllllIlI, lllllllllllllllIlllIIIllIIIIIIll, lllllllllllllllIlllIIIlIlllllIII, lllllllllllllllIlllIIIlIllllIlll, lllllllllllllllIlllIIIlIllllIllI);
    }
    
    @Override
    public void notifyLightSet(final BlockPos lllllllllllllllIlllIIIllllIlIIlI) {
        this.setLightUpdates.add(lllllllllllllllIlllIIIllllIlIIlI.toImmutable());
    }
    
    public void renderEntities(final Entity lllllllllllllllIlllIlIlIIlIlIllI, final ICamera lllllllllllllllIlllIlIlIIlIlIlIl, final float lllllllllllllllIlllIlIlIIlIlIlII) {
        int lllllllllllllllIlllIlIlIIlIlIIll = 0;
        if (Reflector.MinecraftForgeClient_getRenderPass.exists()) {
            lllllllllllllllIlllIlIlIIlIlIIll = Reflector.callInt(Reflector.MinecraftForgeClient_getRenderPass, new Object[0]);
        }
        if (this.renderEntitiesStartupCounter > 0) {
            if (lllllllllllllllIlllIlIlIIlIlIIll > 0) {
                return;
            }
            --this.renderEntitiesStartupCounter;
        }
        else {
            final double lllllllllllllllIlllIlIlIIlIlIIlI = lllllllllllllllIlllIlIlIIlIlIllI.prevPosX + (lllllllllllllllIlllIlIlIIlIlIllI.posX - lllllllllllllllIlllIlIlIIlIlIllI.prevPosX) * lllllllllllllllIlllIlIlIIlIlIlII;
            final double lllllllllllllllIlllIlIlIIlIlIIIl = lllllllllllllllIlllIlIlIIlIlIllI.prevPosY + (lllllllllllllllIlllIlIlIIlIlIllI.posY - lllllllllllllllIlllIlIlIIlIlIllI.prevPosY) * lllllllllllllllIlllIlIlIIlIlIlII;
            final double lllllllllllllllIlllIlIlIIlIlIIII = lllllllllllllllIlllIlIlIIlIlIllI.prevPosZ + (lllllllllllllllIlllIlIlIIlIlIllI.posZ - lllllllllllllllIlllIlIlIIlIlIllI.prevPosZ) * lllllllllllllllIlllIlIlIIlIlIlII;
            this.theWorld.theProfiler.startSection("prepare");
            TileEntityRendererDispatcher.instance.prepare(this.theWorld, this.mc.getTextureManager(), this.mc.fontRendererObj, this.mc.getRenderViewEntity(), this.mc.objectMouseOver, lllllllllllllllIlllIlIlIIlIlIlII);
            this.renderManager.cacheActiveRenderInfo(this.theWorld, this.mc.fontRendererObj, this.mc.getRenderViewEntity(), this.mc.pointedEntity, this.mc.gameSettings, lllllllllllllllIlllIlIlIIlIlIlII);
            if (lllllllllllllllIlllIlIlIIlIlIIll == 0) {
                this.countEntitiesTotal = 0;
                this.countEntitiesRendered = 0;
                this.countEntitiesHidden = 0;
                this.countTileEntitiesRendered = 0;
            }
            final Entity lllllllllllllllIlllIlIlIIlIIllll = this.mc.getRenderViewEntity();
            final double lllllllllllllllIlllIlIlIIlIIlllI = lllllllllllllllIlllIlIlIIlIIllll.lastTickPosX + (lllllllllllllllIlllIlIlIIlIIllll.posX - lllllllllllllllIlllIlIlIIlIIllll.lastTickPosX) * lllllllllllllllIlllIlIlIIlIlIlII;
            final double lllllllllllllllIlllIlIlIIlIIllIl = lllllllllllllllIlllIlIlIIlIIllll.lastTickPosY + (lllllllllllllllIlllIlIlIIlIIllll.posY - lllllllllllllllIlllIlIlIIlIIllll.lastTickPosY) * lllllllllllllllIlllIlIlIIlIlIlII;
            final double lllllllllllllllIlllIlIlIIlIIllII = lllllllllllllllIlllIlIlIIlIIllll.lastTickPosZ + (lllllllllllllllIlllIlIlIIlIIllll.posZ - lllllllllllllllIlllIlIlIIlIIllll.lastTickPosZ) * lllllllllllllllIlllIlIlIIlIlIlII;
            TileEntityRendererDispatcher.staticPlayerX = lllllllllllllllIlllIlIlIIlIIlllI;
            TileEntityRendererDispatcher.staticPlayerY = lllllllllllllllIlllIlIlIIlIIllIl;
            TileEntityRendererDispatcher.staticPlayerZ = lllllllllllllllIlllIlIlIIlIIllII;
            this.renderManager.setRenderPosition(lllllllllllllllIlllIlIlIIlIIlllI, lllllllllllllllIlllIlIlIIlIIllIl, lllllllllllllllIlllIlIlIIlIIllII);
            this.mc.entityRenderer.enableLightmap();
            this.theWorld.theProfiler.endStartSection("global");
            final List<Entity> lllllllllllllllIlllIlIlIIlIIlIll = this.theWorld.getLoadedEntityList();
            if (lllllllllllllllIlllIlIlIIlIlIIll == 0) {
                this.countEntitiesTotal = lllllllllllllllIlllIlIlIIlIIlIll.size();
            }
            if (Config.isFogOff() && this.mc.entityRenderer.fogStandard) {
                GlStateManager.disableFog();
            }
            final boolean lllllllllllllllIlllIlIlIIlIIlIlI = Reflector.ForgeEntity_shouldRenderInPass.exists();
            final boolean lllllllllllllllIlllIlIlIIlIIlIIl = Reflector.ForgeTileEntity_shouldRenderInPass.exists();
            for (int lllllllllllllllIlllIlIlIIlIIlIII = 0; lllllllllllllllIlllIlIlIIlIIlIII < this.theWorld.weatherEffects.size(); ++lllllllllllllllIlllIlIlIIlIIlIII) {
                final Entity lllllllllllllllIlllIlIlIIlIIIlll = this.theWorld.weatherEffects.get(lllllllllllllllIlllIlIlIIlIIlIII);
                if (!lllllllllllllllIlllIlIlIIlIIlIlI || Reflector.callBoolean(lllllllllllllllIlllIlIlIIlIIIlll, Reflector.ForgeEntity_shouldRenderInPass, lllllllllllllllIlllIlIlIIlIlIIll)) {
                    ++this.countEntitiesRendered;
                    if (lllllllllllllllIlllIlIlIIlIIIlll.isInRangeToRender3d(lllllllllllllllIlllIlIlIIlIlIIlI, lllllllllllllllIlllIlIlIIlIlIIIl, lllllllllllllllIlllIlIlIIlIlIIII)) {
                        this.renderManager.renderEntityStatic(lllllllllllllllIlllIlIlIIlIIIlll, lllllllllllllllIlllIlIlIIlIlIlII, false);
                    }
                }
            }
            this.theWorld.theProfiler.endStartSection("entities");
            final boolean lllllllllllllllIlllIlIlIIlIIIllI = Config.isShaders();
            if (lllllllllllllllIlllIlIlIIlIIIllI) {
                Shaders.beginEntities();
            }
            final boolean lllllllllllllllIlllIlIlIIlIIIlIl = this.mc.gameSettings.fancyGraphics;
            this.mc.gameSettings.fancyGraphics = Config.isDroppedItemsFancy();
            final List<Entity> lllllllllllllllIlllIlIlIIlIIIlII = (List<Entity>)Lists.newArrayList();
            final List<Entity> lllllllllllllllIlllIlIlIIlIIIIll = (List<Entity>)Lists.newArrayList();
            final BlockPos.PooledMutableBlockPos lllllllllllllllIlllIlIlIIlIIIIlI = BlockPos.PooledMutableBlockPos.retain();
            for (final Object lllllllllllllllIlllIlIlIIlIIIIIl : this.renderInfosEntities) {
                final ContainerLocalRenderInformation lllllllllllllllIlllIlIlIIlIIIIII = (ContainerLocalRenderInformation)lllllllllllllllIlllIlIlIIlIIIIIl;
                final Chunk lllllllllllllllIlllIlIlIIIllllll = lllllllllllllllIlllIlIlIIlIIIIII.renderChunk.getChunk(this.theWorld);
                final ClassInheritanceMultiMap<Entity> lllllllllllllllIlllIlIlIIIlllllI = lllllllllllllllIlllIlIlIIIllllll.getEntityLists()[lllllllllllllllIlllIlIlIIlIIIIII.renderChunk.getPosition().getY() / 16];
                if (!lllllllllllllllIlllIlIlIIIlllllI.isEmpty()) {
                    for (final Entity lllllllllllllllIlllIlIlIIIllllIl : lllllllllllllllIlllIlIlIIIlllllI) {
                        if (!lllllllllllllllIlllIlIlIIlIIlIlI || Reflector.callBoolean(lllllllllllllllIlllIlIlIIIllllIl, Reflector.ForgeEntity_shouldRenderInPass, lllllllllllllllIlllIlIlIIlIlIIll)) {
                            final boolean lllllllllllllllIlllIlIlIIIllllII = this.renderManager.shouldRender(lllllllllllllllIlllIlIlIIIllllIl, lllllllllllllllIlllIlIlIIlIlIlIl, lllllllllllllllIlllIlIlIIlIlIIlI, lllllllllllllllIlllIlIlIIlIlIIIl, lllllllllllllllIlllIlIlIIlIlIIII) || lllllllllllllllIlllIlIlIIIllllIl.isRidingOrBeingRiddenBy(this.mc.player);
                            if (!lllllllllllllllIlllIlIlIIIllllII) {
                                continue;
                            }
                            final boolean lllllllllllllllIlllIlIlIIIlllIll = this.mc.getRenderViewEntity() instanceof EntityLivingBase && ((EntityLivingBase)this.mc.getRenderViewEntity()).isPlayerSleeping();
                            if ((lllllllllllllllIlllIlIlIIIllllIl == this.mc.getRenderViewEntity() && this.mc.gameSettings.thirdPersonView == 0 && !lllllllllllllllIlllIlIlIIIlllIll) || (lllllllllllllllIlllIlIlIIIllllIl.posY >= 0.0 && lllllllllllllllIlllIlIlIIIllllIl.posY < 256.0 && !this.theWorld.isBlockLoaded(lllllllllllllllIlllIlIlIIlIIIIlI.setPos(lllllllllllllllIlllIlIlIIIllllIl)))) {
                                continue;
                            }
                            ++this.countEntitiesRendered;
                            this.renderedEntity = lllllllllllllllIlllIlIlIIIllllIl;
                            if (lllllllllllllllIlllIlIlIIlIIIllI) {
                                Shaders.nextEntity(lllllllllllllllIlllIlIlIIIllllIl);
                            }
                            this.renderManager.renderEntityStatic(lllllllllllllllIlllIlIlIIIllllIl, lllllllllllllllIlllIlIlIIlIlIlII, false);
                            this.renderedEntity = null;
                            if (this.isOutlineActive(lllllllllllllllIlllIlIlIIIllllIl, lllllllllllllllIlllIlIlIIlIIllll, lllllllllllllllIlllIlIlIIlIlIlIl)) {
                                lllllllllllllllIlllIlIlIIlIIIlII.add(lllllllllllllllIlllIlIlIIIllllIl);
                            }
                            if (!this.renderManager.isRenderMultipass(lllllllllllllllIlllIlIlIIIllllIl)) {
                                continue;
                            }
                            lllllllllllllllIlllIlIlIIlIIIIll.add(lllllllllllllllIlllIlIlIIIllllIl);
                        }
                    }
                }
            }
            lllllllllllllllIlllIlIlIIlIIIIlI.release();
            if (!lllllllllllllllIlllIlIlIIlIIIIll.isEmpty()) {
                for (final Entity lllllllllllllllIlllIlIlIIIlllIlI : lllllllllllllllIlllIlIlIIlIIIIll) {
                    if (!lllllllllllllllIlllIlIlIIlIIlIlI || Reflector.callBoolean(lllllllllllllllIlllIlIlIIIlllIlI, Reflector.ForgeEntity_shouldRenderInPass, lllllllllllllllIlllIlIlIIlIlIIll)) {
                        if (lllllllllllllllIlllIlIlIIlIIIllI) {
                            Shaders.nextEntity(lllllllllllllllIlllIlIlIIIlllIlI);
                        }
                        this.renderManager.renderMultipass(lllllllllllllllIlllIlIlIIIlllIlI, lllllllllllllllIlllIlIlIIlIlIlII);
                    }
                }
            }
            if (lllllllllllllllIlllIlIlIIlIlIIll == 0 && this.isRenderEntityOutlines() && (!lllllllllllllllIlllIlIlIIlIIIlII.isEmpty() || this.entityOutlinesRendered)) {
                this.theWorld.theProfiler.endStartSection("entityOutlines");
                this.entityOutlineFramebuffer.framebufferClear();
                this.entityOutlinesRendered = !lllllllllllllllIlllIlIlIIlIIIlII.isEmpty();
                if (!lllllllllllllllIlllIlIlIIlIIIlII.isEmpty()) {
                    GlStateManager.depthFunc(519);
                    GlStateManager.disableFog();
                    this.entityOutlineFramebuffer.bindFramebuffer(false);
                    RenderHelper.disableStandardItemLighting();
                    this.renderManager.setRenderOutlines(true);
                    for (int lllllllllllllllIlllIlIlIIIlllIIl = 0; lllllllllllllllIlllIlIlIIIlllIIl < lllllllllllllllIlllIlIlIIlIIIlII.size(); ++lllllllllllllllIlllIlIlIIIlllIIl) {
                        final Entity lllllllllllllllIlllIlIlIIIlllIII = lllllllllllllllIlllIlIlIIlIIIlII.get(lllllllllllllllIlllIlIlIIIlllIIl);
                        if (!lllllllllllllllIlllIlIlIIlIIlIlI || Reflector.callBoolean(lllllllllllllllIlllIlIlIIIlllIII, Reflector.ForgeEntity_shouldRenderInPass, lllllllllllllllIlllIlIlIIlIlIIll)) {
                            if (lllllllllllllllIlllIlIlIIlIIIllI) {
                                Shaders.nextEntity(lllllllllllllllIlllIlIlIIIlllIII);
                            }
                            this.renderManager.renderEntityStatic(lllllllllllllllIlllIlIlIIIlllIII, lllllllllllllllIlllIlIlIIlIlIlII, false);
                        }
                    }
                    this.renderManager.setRenderOutlines(false);
                    RenderHelper.enableStandardItemLighting();
                    GlStateManager.depthMask(false);
                    this.entityOutlineShader.loadShaderGroup(lllllllllllllllIlllIlIlIIlIlIlII);
                    GlStateManager.enableLighting();
                    GlStateManager.depthMask(true);
                    GlStateManager.enableFog();
                    GlStateManager.enableBlend();
                    GlStateManager.enableColorMaterial();
                    GlStateManager.depthFunc(515);
                    GlStateManager.enableDepth();
                    GlStateManager.enableAlpha();
                }
                this.mc.getFramebuffer().bindFramebuffer(false);
            }
            if (!this.isRenderEntityOutlines() && (!lllllllllllllllIlllIlIlIIlIIIlII.isEmpty() || this.entityOutlinesRendered)) {
                this.theWorld.theProfiler.endStartSection("entityOutlines");
                this.entityOutlinesRendered = !lllllllllllllllIlllIlIlIIlIIIlII.isEmpty();
                if (!lllllllllllllllIlllIlIlIIlIIIlII.isEmpty()) {
                    GlStateManager.disableFog();
                    GlStateManager.disableDepth();
                    this.mc.entityRenderer.disableLightmap();
                    RenderHelper.disableStandardItemLighting();
                    this.renderManager.setRenderOutlines(true);
                    for (int lllllllllllllllIlllIlIlIIIllIlll = 0; lllllllllllllllIlllIlIlIIIllIlll < lllllllllllllllIlllIlIlIIlIIIlII.size(); ++lllllllllllllllIlllIlIlIIIllIlll) {
                        final Entity lllllllllllllllIlllIlIlIIIllIllI = lllllllllllllllIlllIlIlIIlIIIlII.get(lllllllllllllllIlllIlIlIIIllIlll);
                        if (!lllllllllllllllIlllIlIlIIlIIlIlI || Reflector.callBoolean(lllllllllllllllIlllIlIlIIIllIllI, Reflector.ForgeEntity_shouldRenderInPass, lllllllllllllllIlllIlIlIIlIlIIll)) {
                            if (lllllllllllllllIlllIlIlIIlIIIllI) {
                                Shaders.nextEntity(lllllllllllllllIlllIlIlIIIllIllI);
                            }
                            this.renderManager.renderEntityStatic(lllllllllllllllIlllIlIlIIIllIllI, lllllllllllllllIlllIlIlIIlIlIlII, false);
                        }
                    }
                    this.renderManager.setRenderOutlines(false);
                    RenderHelper.enableStandardItemLighting();
                    this.mc.entityRenderer.enableLightmap();
                    GlStateManager.enableDepth();
                    GlStateManager.enableFog();
                }
            }
            this.mc.gameSettings.fancyGraphics = lllllllllllllllIlllIlIlIIlIIIlIl;
            final FontRenderer lllllllllllllllIlllIlIlIIIllIlIl = TileEntityRendererDispatcher.instance.getFontRenderer();
            if (lllllllllllllllIlllIlIlIIlIIIllI) {
                Shaders.endEntities();
                Shaders.beginBlockEntities();
            }
            this.theWorld.theProfiler.endStartSection("blockentities");
            RenderHelper.enableStandardItemLighting();
            if (Reflector.ForgeTileEntity_hasFastRenderer.exists()) {
                TileEntityRendererDispatcher.instance.preDrawBatch();
            }
            for (final Object lllllllllllllllIlllIlIlIIIllIlII : this.renderInfosTileEntities) {
                final ContainerLocalRenderInformation lllllllllllllllIlllIlIlIIIllIIll = (ContainerLocalRenderInformation)lllllllllllllllIlllIlIlIIIllIlII;
                final List<TileEntity> lllllllllllllllIlllIlIlIIIllIIlI = lllllllllllllllIlllIlIlIIIllIIll.renderChunk.getCompiledChunk().getTileEntities();
                if (!lllllllllllllllIlllIlIlIIIllIIlI.isEmpty()) {
                    for (final TileEntity lllllllllllllllIlllIlIlIIIllIIII : lllllllllllllllIlllIlIlIIIllIIlI) {
                        if (lllllllllllllllIlllIlIlIIlIIlIIl) {
                            if (!Reflector.callBoolean(lllllllllllllllIlllIlIlIIIllIIII, Reflector.ForgeTileEntity_shouldRenderInPass, lllllllllllllllIlllIlIlIIlIlIIll)) {
                                continue;
                            }
                            final AxisAlignedBB lllllllllllllllIlllIlIlIIIlIllll = (AxisAlignedBB)Reflector.call(lllllllllllllllIlllIlIlIIIllIIII, Reflector.ForgeTileEntity_getRenderBoundingBox, new Object[0]);
                            if (lllllllllllllllIlllIlIlIIIlIllll != null && !lllllllllllllllIlllIlIlIIlIlIlIl.isBoundingBoxInFrustum(lllllllllllllllIlllIlIlIIIlIllll)) {
                                continue;
                            }
                        }
                        final Class lllllllllllllllIlllIlIlIIIlIlllI = lllllllllllllllIlllIlIlIIIllIIII.getClass();
                        if (lllllllllllllllIlllIlIlIIIlIlllI == TileEntitySign.class && !Config.zoomMode) {
                            final EntityPlayer lllllllllllllllIlllIlIlIIIlIllIl = this.mc.player;
                            final double lllllllllllllllIlllIlIlIIIlIllII = lllllllllllllllIlllIlIlIIIllIIII.getDistanceSq(lllllllllllllllIlllIlIlIIIlIllIl.posX, lllllllllllllllIlllIlIlIIIlIllIl.posY, lllllllllllllllIlllIlIlIIIlIllIl.posZ);
                            if (lllllllllllllllIlllIlIlIIIlIllII > 256.0) {
                                lllllllllllllllIlllIlIlIIIllIlIl.enabled = false;
                            }
                        }
                        if (lllllllllllllllIlllIlIlIIlIIIllI) {
                            Shaders.nextBlockEntity(lllllllllllllllIlllIlIlIIIllIIII);
                        }
                        TileEntityRendererDispatcher.instance.renderTileEntity(lllllllllllllllIlllIlIlIIIllIIII, lllllllllllllllIlllIlIlIIlIlIlII, -1);
                        ++this.countTileEntitiesRendered;
                        lllllllllllllllIlllIlIlIIIllIlIl.enabled = true;
                    }
                }
            }
            synchronized (this.setTileEntities) {
                for (final TileEntity lllllllllllllllIlllIlIlIIIlIlIll : this.setTileEntities) {
                    if (!lllllllllllllllIlllIlIlIIlIIlIIl || Reflector.callBoolean(lllllllllllllllIlllIlIlIIIlIlIll, Reflector.ForgeTileEntity_shouldRenderInPass, lllllllllllllllIlllIlIlIIlIlIIll)) {
                        if (lllllllllllllllIlllIlIlIIlIIIllI) {
                            Shaders.nextBlockEntity(lllllllllllllllIlllIlIlIIIlIlIll);
                        }
                        TileEntityRendererDispatcher.instance.renderTileEntity(lllllllllllllllIlllIlIlIIIlIlIll, lllllllllllllllIlllIlIlIIlIlIlII, -1);
                    }
                }
            }
            // monitorexit(this.setTileEntities)
            if (Reflector.ForgeTileEntity_hasFastRenderer.exists()) {
                TileEntityRendererDispatcher.instance.drawBatch(lllllllllllllllIlllIlIlIIlIlIIll);
            }
            this.renderOverlayDamaged = true;
            this.preRenderDamagedBlocks();
            for (final DestroyBlockProgress lllllllllllllllIlllIlIlIIIlIlIlI : this.damagedBlocks.values()) {
                BlockPos lllllllllllllllIlllIlIlIIIlIlIIl = lllllllllllllllIlllIlIlIIIlIlIlI.getPosition();
                if (this.theWorld.getBlockState(lllllllllllllllIlllIlIlIIIlIlIIl).getBlock().hasTileEntity()) {
                    TileEntity lllllllllllllllIlllIlIlIIIlIlIII = this.theWorld.getTileEntity(lllllllllllllllIlllIlIlIIIlIlIIl);
                    if (lllllllllllllllIlllIlIlIIIlIlIII instanceof TileEntityChest) {
                        final TileEntityChest lllllllllllllllIlllIlIlIIIlIIlll = (TileEntityChest)lllllllllllllllIlllIlIlIIIlIlIII;
                        if (lllllllllllllllIlllIlIlIIIlIIlll.adjacentChestXNeg != null) {
                            lllllllllllllllIlllIlIlIIIlIlIIl = lllllllllllllllIlllIlIlIIIlIlIIl.offset(EnumFacing.WEST);
                            lllllllllllllllIlllIlIlIIIlIlIII = this.theWorld.getTileEntity(lllllllllllllllIlllIlIlIIIlIlIIl);
                        }
                        else if (lllllllllllllllIlllIlIlIIIlIIlll.adjacentChestZNeg != null) {
                            lllllllllllllllIlllIlIlIIIlIlIIl = lllllllllllllllIlllIlIlIIIlIlIIl.offset(EnumFacing.NORTH);
                            lllllllllllllllIlllIlIlIIIlIlIII = this.theWorld.getTileEntity(lllllllllllllllIlllIlIlIIIlIlIIl);
                        }
                    }
                    final IBlockState lllllllllllllllIlllIlIlIIIlIIllI = this.theWorld.getBlockState(lllllllllllllllIlllIlIlIIIlIlIIl);
                    if (lllllllllllllllIlllIlIlIIIlIlIII == null || !lllllllllllllllIlllIlIlIIIlIIllI.func_191057_i()) {
                        continue;
                    }
                    if (lllllllllllllllIlllIlIlIIlIIIllI) {
                        Shaders.nextBlockEntity(lllllllllllllllIlllIlIlIIIlIlIII);
                    }
                    TileEntityRendererDispatcher.instance.renderTileEntity(lllllllllllllllIlllIlIlIIIlIlIII, lllllllllllllllIlllIlIlIIlIlIlII, lllllllllllllllIlllIlIlIIIlIlIlI.getPartialBlockDamage());
                }
            }
            this.postRenderDamagedBlocks();
            this.renderOverlayDamaged = false;
            this.mc.entityRenderer.disableLightmap();
            this.mc.mcProfiler.endSection();
        }
    }
    
    public static void addChainedFilledBoxVertices(final BufferBuilder lllllllllllllllIlllIIlIIIIlllIIl, final double lllllllllllllllIlllIIlIIIlIIIllI, final double lllllllllllllllIlllIIlIIIlIIIlIl, final double lllllllllllllllIlllIIlIIIlIIIlII, final double lllllllllllllllIlllIIlIIIIlIllll, final double lllllllllllllllIlllIIlIIIlIIIIlI, final double lllllllllllllllIlllIIlIIIlIIIIIl, final float lllllllllllllllIlllIIlIIIIlIlIlI, final float lllllllllllllllIlllIIlIIIIlIlIII, final float lllllllllllllllIlllIIlIIIIllllIl, final float lllllllllllllllIlllIIlIIIIlllIll) {
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIlIl, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIlIIIllI, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIlII).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
        lllllllllllllllIlllIIlIIIIlllIIl.pos(lllllllllllllllIlllIIlIIIIlIllll, lllllllllllllllIlllIIlIIIlIIIIlI, lllllllllllllllIlllIIlIIIlIIIIIl).color(lllllllllllllllIlllIIlIIIIlIlIlI, lllllllllllllllIlllIIlIIIIlIlIII, lllllllllllllllIlllIIlIIIIllllIl, lllllllllllllllIlllIIlIIIIlllIll).endVertex();
    }
    
    public void makeEntityOutlineShader() {
        if (OpenGlHelper.shadersSupported) {
            if (ShaderLinkHelper.getStaticShaderLinkHelper() == null) {
                ShaderLinkHelper.setNewStaticShaderLinkHelper();
            }
            final ResourceLocation lllllllllllllllIlllIlIllIlIllIlI = new ResourceLocation("shaders/post/entity_outline.json");
            try {
                this.entityOutlineShader = new ShaderGroup(this.mc.getTextureManager(), this.mc.getResourceManager(), this.mc.getFramebuffer(), lllllllllllllllIlllIlIllIlIllIlI);
                this.entityOutlineShader.createBindFramebuffers(this.mc.displayWidth, this.mc.displayHeight);
                this.entityOutlineFramebuffer = this.entityOutlineShader.getFramebufferRaw("final");
            }
            catch (IOException lllllllllllllllIlllIlIllIlIllIII) {
                RenderGlobal.LOGGER.warn("Failed to load shader: {}", (Object)lllllllllllllllIlllIlIllIlIllIlI, (Object)lllllllllllllllIlllIlIllIlIllIII);
                this.entityOutlineShader = null;
                this.entityOutlineFramebuffer = null;
            }
            catch (JsonSyntaxException lllllllllllllllIlllIlIllIlIlIllI) {
                RenderGlobal.LOGGER.warn("Failed to load shader: {}", (Object)lllllllllllllllIlllIlIllIlIllIlI, (Object)lllllllllllllllIlllIlIllIlIlIllI);
                this.entityOutlineShader = null;
                this.entityOutlineFramebuffer = null;
            }
        }
        else {
            this.entityOutlineShader = null;
            this.entityOutlineFramebuffer = null;
        }
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage() {
        final int[] $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = RenderGlobal.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        if ($switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage != null) {
            return $switch_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
        }
        final float lllllllllllllllIlllIIIIllIlIllll = (Object)new int[VertexFormatElement.EnumUsage.values().length];
        try {
            lllllllllllllllIlllIIIIllIlIllll[VertexFormatElement.EnumUsage.BLEND_WEIGHT.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllllIlllIIIIllIlIllll[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllllIlllIIIIllIlIllll[VertexFormatElement.EnumUsage.MATRIX.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllllIlllIIIIllIlIllll[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllllIlllIIIIllIlIllll[VertexFormatElement.EnumUsage.PADDING.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllllIlllIIIIllIlIllll[VertexFormatElement.EnumUsage.POSITION.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        try {
            lllllllllllllllIlllIIIIllIlIllll[VertexFormatElement.EnumUsage.UV.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError7) {}
        return RenderGlobal.$SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = (int[])(Object)lllllllllllllllIlllIIIIllIlIllll;
    }
    
    public static void drawSelectionBoundingBox(final AxisAlignedBB lllllllllllllllIlllIIlIlIlIlIllI, final float lllllllllllllllIlllIIlIlIlIlllII, final float lllllllllllllllIlllIIlIlIlIlIIIl, final float lllllllllllllllIlllIIlIlIlIllIIl, final float lllllllllllllllIlllIIlIlIlIIlllI) {
        drawBoundingBox(lllllllllllllllIlllIIlIlIlIlIllI.minX, lllllllllllllllIlllIIlIlIlIlIllI.minY, lllllllllllllllIlllIIlIlIlIlIllI.minZ, lllllllllllllllIlllIIlIlIlIlIllI.maxX, lllllllllllllllIlllIIlIlIlIlIllI.maxY, lllllllllllllllIlllIIlIlIlIlIllI.maxZ, lllllllllllllllIlllIIlIlIlIlllII, lllllllllllllllIlllIIlIlIlIlIIIl, lllllllllllllllIlllIIlIlIlIllIIl, lllllllllllllllIlllIIlIlIlIIlllI);
    }
    
    private void updateDestroyBlockIcons() {
        final TextureMap lllllllllllllllIlllIlIllIlllIIlI = this.mc.getTextureMapBlocks();
        for (int lllllllllllllllIlllIlIllIlllIIII = 0; lllllllllllllllIlllIlIllIlllIIII < this.destroyBlockIcons.length; ++lllllllllllllllIlllIlIllIlllIIII) {
            this.destroyBlockIcons[lllllllllllllllIlllIlIllIlllIIII] = lllllllllllllllIlllIlIllIlllIIlI.getAtlasSprite(String.valueOf(new StringBuilder("minecraft:blocks/destroy_stage_").append(lllllllllllllllIlllIlIllIlllIIII)));
        }
    }
    
    protected Vector3f getViewVector(final Entity lllllllllllllllIlllIlIIIllIllIlI, final double lllllllllllllllIlllIlIIIllIllIIl) {
        float lllllllllllllllIlllIlIIIlllIIIII = (float)(lllllllllllllllIlllIlIIIllIllIlI.prevRotationPitch + (lllllllllllllllIlllIlIIIllIllIlI.rotationPitch - lllllllllllllllIlllIlIIIllIllIlI.prevRotationPitch) * lllllllllllllllIlllIlIIIllIllIIl);
        final float lllllllllllllllIlllIlIIIllIlllll = (float)(lllllllllllllllIlllIlIIIllIllIlI.prevRotationYaw + (lllllllllllllllIlllIlIIIllIllIlI.rotationYaw - lllllllllllllllIlllIlIIIllIllIlI.prevRotationYaw) * lllllllllllllllIlllIlIIIllIllIIl);
        if (Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) {
            lllllllllllllllIlllIlIIIlllIIIII += 180.0f;
        }
        final float lllllllllllllllIlllIlIIIllIllllI = MathHelper.cos(-lllllllllllllllIlllIlIIIllIlllll * 0.017453292f - 3.1415927f);
        final float lllllllllllllllIlllIlIIIllIlllIl = MathHelper.sin(-lllllllllllllllIlllIlIIIllIlllll * 0.017453292f - 3.1415927f);
        final float lllllllllllllllIlllIlIIIllIlllII = -MathHelper.cos(-lllllllllllllllIlllIlIIIlllIIIII * 0.017453292f);
        final float lllllllllllllllIlllIlIIIllIllIll = MathHelper.sin(-lllllllllllllllIlllIlIIIlllIIIII * 0.017453292f);
        return new Vector3f(lllllllllllllllIlllIlIIIllIlllIl * lllllllllllllllIlllIlIIIllIlllII, lllllllllllllllIlllIlIIIllIllIll, lllllllllllllllIlllIlIIIllIllllI * lllllllllllllllIlllIlIIIllIlllII);
    }
    
    @Override
    public void playEvent(final EntityPlayer lllllllllllllllIlllIIIlIIlIlIlll, final int lllllllllllllllIlllIIIlIIIlIIIlI, final BlockPos lllllllllllllllIlllIIIlIIIlIIIIl, final int lllllllllllllllIlllIIIlIIlIlIlII) {
        final Random lllllllllllllllIlllIIIlIIlIlIIll = this.theWorld.rand;
        switch (lllllllllllllllIlllIIIlIIIlIIIlI) {
            case 1000: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_DISPENSER_DISPENSE, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                break;
            }
            case 1001: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.BLOCKS, 1.0f, 1.2f, false);
                break;
            }
            case 1002: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_DISPENSER_LAUNCH, SoundCategory.BLOCKS, 1.0f, 1.2f, false);
                break;
            }
            case 1003: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ENDEREYE_LAUNCH, SoundCategory.NEUTRAL, 1.0f, 1.2f, false);
                break;
            }
            case 1004: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_FIREWORK_SHOOT, SoundCategory.NEUTRAL, 1.0f, 1.2f, false);
                break;
            }
            case 1005: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1006: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_WOODEN_DOOR_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1007: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1008: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_FENCE_GATE_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1009: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5f, 2.6f + (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.8f, false);
                break;
            }
            case 1010: {
                if (Item.getItemById(lllllllllllllllIlllIIIlIIlIlIlII) instanceof ItemRecord) {
                    this.theWorld.playRecord(lllllllllllllllIlllIIIlIIIlIIIIl, ((ItemRecord)Item.getItemById(lllllllllllllllIlllIIIlIIlIlIlII)).getSound());
                    break;
                }
                this.theWorld.playRecord(lllllllllllllllIlllIIIlIIIlIIIIl, null);
                break;
            }
            case 1011: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_IRON_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1012: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1013: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1014: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_FENCE_GATE_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1015: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_GHAST_WARN, SoundCategory.HOSTILE, 10.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1016: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_GHAST_SHOOT, SoundCategory.HOSTILE, 10.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1017: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ENDERDRAGON_SHOOT, SoundCategory.HOSTILE, 10.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1018: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.HOSTILE, 2.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1019: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ZOMBIE_ATTACK_DOOR_WOOD, SoundCategory.HOSTILE, 2.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1020: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, SoundCategory.HOSTILE, 2.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1021: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ZOMBIE_BREAK_DOOR_WOOD, SoundCategory.HOSTILE, 2.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1022: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_WITHER_BREAK_BLOCK, SoundCategory.HOSTILE, 2.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1024: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.HOSTILE, 2.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1025: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_BAT_TAKEOFF, SoundCategory.NEUTRAL, 0.05f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1026: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ZOMBIE_INFECT, SoundCategory.HOSTILE, 2.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1027: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CONVERTED, SoundCategory.NEUTRAL, 2.0f, (lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() - lllllllllllllllIlllIIIlIIlIlIIll.nextFloat()) * 0.2f + 1.0f, false);
                break;
            }
            case 1029: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_ANVIL_DESTROY, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1030: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1031: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_ANVIL_LAND, SoundCategory.BLOCKS, 0.3f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1032: {
                this.mc.getSoundHandler().playSound(PositionedSoundRecord.getMasterRecord(SoundEvents.BLOCK_PORTAL_TRAVEL, lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() * 0.4f + 0.8f));
                break;
            }
            case 1033: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_CHORUS_FLOWER_GROW, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                break;
            }
            case 1034: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_CHORUS_FLOWER_DEATH, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                break;
            }
            case 1035: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_BREWING_STAND_BREW, SoundCategory.BLOCKS, 1.0f, 1.0f, false);
                break;
            }
            case 1036: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_IRON_TRAPDOOR_CLOSE, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 1037: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_IRON_TRAPDOOR_OPEN, SoundCategory.BLOCKS, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2000: {
                final int lllllllllllllllIlllIIIlIIlIlIIlI = lllllllllllllllIlllIIIlIIlIlIlII % 3 - 1;
                final int lllllllllllllllIlllIIIlIIlIlIIIl = lllllllllllllllIlllIIIlIIlIlIlII / 3 % 3 - 1;
                final double lllllllllllllllIlllIIIlIIlIlIIII = lllllllllllllllIlllIIIlIIIlIIIIl.getX() + lllllllllllllllIlllIIIlIIlIlIIlI * 0.6 + 0.5;
                final double lllllllllllllllIlllIIIlIIlIIllll = lllllllllllllllIlllIIIlIIIlIIIIl.getY() + 0.5;
                final double lllllllllllllllIlllIIIlIIlIIlllI = lllllllllllllllIlllIIIlIIIlIIIIl.getZ() + lllllllllllllllIlllIIIlIIlIlIIIl * 0.6 + 0.5;
                for (int lllllllllllllllIlllIIIlIIlIIllIl = 0; lllllllllllllllIlllIIIlIIlIIllIl < 10; ++lllllllllllllllIlllIIIlIIlIIllIl) {
                    final double lllllllllllllllIlllIIIlIIlIIllII = lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() * 0.2 + 0.01;
                    final double lllllllllllllllIlllIIIlIIlIIlIll = lllllllllllllllIlllIIIlIIlIlIIII + lllllllllllllllIlllIIIlIIlIlIIlI * 0.01 + (lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() - 0.5) * lllllllllllllllIlllIIIlIIlIlIIIl * 0.5;
                    final double lllllllllllllllIlllIIIlIIlIIlIlI = lllllllllllllllIlllIIIlIIlIIllll + (lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() - 0.5) * 0.5;
                    final double lllllllllllllllIlllIIIlIIlIIlIIl = lllllllllllllllIlllIIIlIIlIIlllI + lllllllllllllllIlllIIIlIIlIlIIIl * 0.01 + (lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() - 0.5) * lllllllllllllllIlllIIIlIIlIlIIlI * 0.5;
                    final double lllllllllllllllIlllIIIlIIlIIlIII = lllllllllllllllIlllIIIlIIlIlIIlI * lllllllllllllllIlllIIIlIIlIIllII + lllllllllllllllIlllIIIlIIlIlIIll.nextGaussian() * 0.01;
                    final double lllllllllllllllIlllIIIlIIlIIIlll = -0.03 + lllllllllllllllIlllIIIlIIlIlIIll.nextGaussian() * 0.01;
                    final double lllllllllllllllIlllIIIlIIlIIIllI = lllllllllllllllIlllIIIlIIlIlIIIl * lllllllllllllllIlllIIIlIIlIIllII + lllllllllllllllIlllIIIlIIlIlIIll.nextGaussian() * 0.01;
                    this.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlllIIIlIIlIIlIll, lllllllllllllllIlllIIIlIIlIIlIlI, lllllllllllllllIlllIIIlIIlIIlIIl, lllllllllllllllIlllIIIlIIlIIlIII, lllllllllllllllIlllIIIlIIlIIIlll, lllllllllllllllIlllIIIlIIlIIIllI, new int[0]);
                }
            }
            case 2001: {
                final Block lllllllllllllllIlllIIIlIIlIIIlIl = Block.getBlockById(lllllllllllllllIlllIIIlIIlIlIlII & 0xFFF);
                if (lllllllllllllllIlllIIIlIIlIIIlIl.getDefaultState().getMaterial() != Material.AIR) {
                    SoundType lllllllllllllllIlllIIIlIIlIIIlII = lllllllllllllllIlllIIIlIIlIIIlIl.getSoundType();
                    if (Reflector.ForgeBlock_getSoundType.exists()) {
                        lllllllllllllllIlllIIIlIIlIIIlII = (SoundType)Reflector.call(lllllllllllllllIlllIIIlIIlIIIlIl, Reflector.ForgeBlock_getSoundType, Block.getStateById(lllllllllllllllIlllIIIlIIlIlIlII), this.theWorld, lllllllllllllllIlllIIIlIIIlIIIIl, null);
                    }
                    this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, lllllllllllllllIlllIIIlIIlIIIlII.getBreakSound(), SoundCategory.BLOCKS, (lllllllllllllllIlllIIIlIIlIIIlII.getVolume() + 1.0f) / 2.0f, lllllllllllllllIlllIIIlIIlIIIlII.getPitch() * 0.8f, false);
                }
                this.mc.effectRenderer.addBlockDestroyEffects(lllllllllllllllIlllIIIlIIIlIIIIl, lllllllllllllllIlllIIIlIIlIIIlIl.getStateFromMeta(lllllllllllllllIlllIIIlIIlIlIlII >> 12 & 0xFF));
                break;
            }
            case 2002:
            case 2007: {
                final double lllllllllllllllIlllIIIlIIlIIIIll = lllllllllllllllIlllIIIlIIIlIIIIl.getX();
                final double lllllllllllllllIlllIIIlIIlIIIIlI = lllllllllllllllIlllIIIlIIIlIIIIl.getY();
                final double lllllllllllllllIlllIIIlIIlIIIIIl = lllllllllllllllIlllIIIlIIIlIIIIl.getZ();
                for (int lllllllllllllllIlllIIIlIIlIIIIII = 0; lllllllllllllllIlllIIIlIIlIIIIII < 8; ++lllllllllllllllIlllIIIlIIlIIIIII) {
                    this.spawnParticle(EnumParticleTypes.ITEM_CRACK, lllllllllllllllIlllIIIlIIlIIIIll, lllllllllllllllIlllIIIlIIlIIIIlI, lllllllllllllllIlllIIIlIIlIIIIIl, lllllllllllllllIlllIIIlIIlIlIIll.nextGaussian() * 0.15, lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() * 0.2, lllllllllllllllIlllIIIlIIlIlIIll.nextGaussian() * 0.15, Item.getIdFromItem(Items.SPLASH_POTION));
                }
                final float lllllllllllllllIlllIIIlIIIllllll = (lllllllllllllllIlllIIIlIIlIlIlII >> 16 & 0xFF) / 255.0f;
                final float lllllllllllllllIlllIIIlIIIlllllI = (lllllllllllllllIlllIIIlIIlIlIlII >> 8 & 0xFF) / 255.0f;
                final float lllllllllllllllIlllIIIlIIIllllIl = (lllllllllllllllIlllIIIlIIlIlIlII >> 0 & 0xFF) / 255.0f;
                final EnumParticleTypes lllllllllllllllIlllIIIlIIIllllII = (lllllllllllllllIlllIIIlIIIlIIIlI == 2007) ? EnumParticleTypes.SPELL_INSTANT : EnumParticleTypes.SPELL;
                for (int lllllllllllllllIlllIIIlIIIlllIll = 0; lllllllllllllllIlllIIIlIIIlllIll < 100; ++lllllllllllllllIlllIIIlIIIlllIll) {
                    final double lllllllllllllllIlllIIIlIIIlllIlI = lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() * 4.0;
                    final double lllllllllllllllIlllIIIlIIIlllIIl = lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() * 3.141592653589793 * 2.0;
                    final double lllllllllllllllIlllIIIlIIIlllIII = Math.cos(lllllllllllllllIlllIIIlIIIlllIIl) * lllllllllllllllIlllIIIlIIIlllIlI;
                    final double lllllllllllllllIlllIIIlIIIllIlll = 0.01 + lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() * 0.5;
                    final double lllllllllllllllIlllIIIlIIIllIllI = Math.sin(lllllllllllllllIlllIIIlIIIlllIIl) * lllllllllllllllIlllIIIlIIIlllIlI;
                    final Particle lllllllllllllllIlllIIIlIIIllIlIl = this.spawnEntityFX(lllllllllllllllIlllIIIlIIIllllII.getParticleID(), lllllllllllllllIlllIIIlIIIllllII.getShouldIgnoreRange(), lllllllllllllllIlllIIIlIIlIIIIll + lllllllllllllllIlllIIIlIIIlllIII * 0.1, lllllllllllllllIlllIIIlIIlIIIIlI + 0.3, lllllllllllllllIlllIIIlIIlIIIIIl + lllllllllllllllIlllIIIlIIIllIllI * 0.1, lllllllllllllllIlllIIIlIIIlllIII, lllllllllllllllIlllIIIlIIIllIlll, lllllllllllllllIlllIIIlIIIllIllI, new int[0]);
                    if (lllllllllllllllIlllIIIlIIIllIlIl != null) {
                        final float lllllllllllllllIlllIIIlIIIllIlII = 0.75f + lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() * 0.25f;
                        lllllllllllllllIlllIIIlIIIllIlIl.setRBGColorF(lllllllllllllllIlllIIIlIIIllllll * lllllllllllllllIlllIIIlIIIllIlII, lllllllllllllllIlllIIIlIIIlllllI * lllllllllllllllIlllIIIlIIIllIlII, lllllllllllllllIlllIIIlIIIllllIl * lllllllllllllllIlllIIIlIIIllIlII);
                        lllllllllllllllIlllIIIlIIIllIlIl.multiplyVelocity((float)lllllllllllllllIlllIIIlIIIlllIlI);
                    }
                }
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_SPLASH_POTION_BREAK, SoundCategory.NEUTRAL, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 2003: {
                final double lllllllllllllllIlllIIIlIIIllIIll = lllllllllllllllIlllIIIlIIIlIIIIl.getX() + 0.5;
                final double lllllllllllllllIlllIIIlIIIllIIlI = lllllllllllllllIlllIIIlIIIlIIIIl.getY();
                final double lllllllllllllllIlllIIIlIIIllIIIl = lllllllllllllllIlllIIIlIIIlIIIIl.getZ() + 0.5;
                for (int lllllllllllllllIlllIIIlIIIllIIII = 0; lllllllllllllllIlllIIIlIIIllIIII < 8; ++lllllllllllllllIlllIIIlIIIllIIII) {
                    this.spawnParticle(EnumParticleTypes.ITEM_CRACK, lllllllllllllllIlllIIIlIIIllIIll, lllllllllllllllIlllIIIlIIIllIIlI, lllllllllllllllIlllIIIlIIIllIIIl, lllllllllllllllIlllIIIlIIlIlIIll.nextGaussian() * 0.15, lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() * 0.2, lllllllllllllllIlllIIIlIIlIlIIll.nextGaussian() * 0.15, Item.getIdFromItem(Items.ENDER_EYE));
                }
                for (double lllllllllllllllIlllIIIlIIIlIllll = 0.0; lllllllllllllllIlllIIIlIIIlIllll < 6.283185307179586; lllllllllllllllIlllIIIlIIIlIllll += 0.15707963267948966) {
                    this.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllllllIlllIIIlIIIllIIll + Math.cos(lllllllllllllllIlllIIIlIIIlIllll) * 5.0, lllllllllllllllIlllIIIlIIIllIIlI - 0.4, lllllllllllllllIlllIIIlIIIllIIIl + Math.sin(lllllllllllllllIlllIIIlIIIlIllll) * 5.0, Math.cos(lllllllllllllllIlllIIIlIIIlIllll) * -5.0, 0.0, Math.sin(lllllllllllllllIlllIIIlIIIlIllll) * -5.0, new int[0]);
                    this.spawnParticle(EnumParticleTypes.PORTAL, lllllllllllllllIlllIIIlIIIllIIll + Math.cos(lllllllllllllllIlllIIIlIIIlIllll) * 5.0, lllllllllllllllIlllIIIlIIIllIIlI - 0.4, lllllllllllllllIlllIIIlIIIllIIIl + Math.sin(lllllllllllllllIlllIIIlIIIlIllll) * 5.0, Math.cos(lllllllllllllllIlllIIIlIIIlIllll) * -7.0, 0.0, Math.sin(lllllllllllllllIlllIIIlIIIlIllll) * -7.0, new int[0]);
                }
            }
            case 2004: {
                for (int lllllllllllllllIlllIIIlIIIlIlllI = 0; lllllllllllllllIlllIIIlIIIlIlllI < 20; ++lllllllllllllllIlllIIIlIIIlIlllI) {
                    final double lllllllllllllllIlllIIIlIIIlIllIl = lllllllllllllllIlllIIIlIIIlIIIIl.getX() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    final double lllllllllllllllIlllIIIlIIIlIllII = lllllllllllllllIlllIIIlIIIlIIIIl.getY() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    final double lllllllllllllllIlllIIIlIIIlIlIll = lllllllllllllllIlllIIIlIIIlIIIIl.getZ() + 0.5 + (this.theWorld.rand.nextFloat() - 0.5) * 2.0;
                    this.theWorld.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, lllllllllllllllIlllIIIlIIIlIllIl, lllllllllllllllIlllIIIlIIIlIllII, lllllllllllllllIlllIIIlIIIlIlIll, 0.0, 0.0, 0.0, new int[0]);
                    this.theWorld.spawnParticle(EnumParticleTypes.FLAME, lllllllllllllllIlllIIIlIIIlIllIl, lllllllllllllllIlllIIIlIIIlIllII, lllllllllllllllIlllIIIlIIIlIlIll, 0.0, 0.0, 0.0, new int[0]);
                }
            }
            case 2005: {
                ItemDye.spawnBonemealParticles(this.theWorld, lllllllllllllllIlllIIIlIIIlIIIIl, lllllllllllllllIlllIIIlIIlIlIlII);
                break;
            }
            case 2006: {
                for (int lllllllllllllllIlllIIIlIIIlIlIlI = 0; lllllllllllllllIlllIIIlIIIlIlIlI < 200; ++lllllllllllllllIlllIIIlIIIlIlIlI) {
                    final float lllllllllllllllIlllIIIlIIIlIlIIl = lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() * 4.0f;
                    final float lllllllllllllllIlllIIIlIIIlIlIII = lllllllllllllllIlllIIIlIIlIlIIll.nextFloat() * 6.2831855f;
                    final double lllllllllllllllIlllIIIlIIIlIIlll = MathHelper.cos(lllllllllllllllIlllIIIlIIIlIlIII) * lllllllllllllllIlllIIIlIIIlIlIIl;
                    final double lllllllllllllllIlllIIIlIIIlIIllI = 0.01 + lllllllllllllllIlllIIIlIIlIlIIll.nextDouble() * 0.5;
                    final double lllllllllllllllIlllIIIlIIIlIIlIl = MathHelper.sin(lllllllllllllllIlllIIIlIIIlIlIII) * lllllllllllllllIlllIIIlIIIlIlIIl;
                    final Particle lllllllllllllllIlllIIIlIIIlIIlII = this.spawnEntityFX(EnumParticleTypes.DRAGON_BREATH.getParticleID(), false, lllllllllllllllIlllIIIlIIIlIIIIl.getX() + lllllllllllllllIlllIIIlIIIlIIlll * 0.1, lllllllllllllllIlllIIIlIIIlIIIIl.getY() + 0.3, lllllllllllllllIlllIIIlIIIlIIIIl.getZ() + lllllllllllllllIlllIIIlIIIlIIlIl * 0.1, lllllllllllllllIlllIIIlIIIlIIlll, lllllllllllllllIlllIIIlIIIlIIllI, lllllllllllllllIlllIIIlIIIlIIlIl, new int[0]);
                    if (lllllllllllllllIlllIIIlIIIlIIlII != null) {
                        lllllllllllllllIlllIIIlIIIlIIlII.multiplyVelocity(lllllllllllllllIlllIIIlIIIlIlIIl);
                    }
                }
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ENDERDRAGON_FIREBALL_EPLD, SoundCategory.HOSTILE, 1.0f, this.theWorld.rand.nextFloat() * 0.1f + 0.9f, false);
                break;
            }
            case 3000: {
                this.theWorld.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, true, lllllllllllllllIlllIIIlIIIlIIIIl.getX() + 0.5, lllllllllllllllIlllIIIlIIIlIIIIl.getY() + 0.5, lllllllllllllllIlllIIIlIIIlIIIIl.getZ() + 0.5, 0.0, 0.0, 0.0, new int[0]);
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.BLOCK_END_GATEWAY_SPAWN, SoundCategory.BLOCKS, 10.0f, (1.0f + (this.theWorld.rand.nextFloat() - this.theWorld.rand.nextFloat()) * 0.2f) * 0.7f, false);
                break;
            }
            case 3001: {
                this.theWorld.playSound(lllllllllllllllIlllIIIlIIIlIIIIl, SoundEvents.ENTITY_ENDERDRAGON_GROWL, SoundCategory.HOSTILE, 64.0f, 0.8f + this.theWorld.rand.nextFloat() * 0.3f, false);
                break;
            }
        }
    }
    
    public void deleteAllDisplayLists() {
    }
    
    @Override
    public void func_190570_a(final int lllllllllllllllIlllIIIllIIlllIll, final boolean lllllllllllllllIlllIIIllIIlllIlI, final boolean lllllllllllllllIlllIIIllIIlllIIl, final double lllllllllllllllIlllIIIllIIlllIII, final double lllllllllllllllIlllIIIllIIllIlll, final double lllllllllllllllIlllIIIllIIllIllI, final double lllllllllllllllIlllIIIllIlIIIIll, final double lllllllllllllllIlllIIIllIIllIlII, final double lllllllllllllllIlllIIIllIIllIIll, final int... lllllllllllllllIlllIIIllIIllIIlI) {
        try {
            this.func_190571_b(lllllllllllllllIlllIIIllIIlllIll, lllllllllllllllIlllIIIllIIlllIlI, lllllllllllllllIlllIIIllIIlllIIl, lllllllllllllllIlllIIIllIIlllIII, lllllllllllllllIlllIIIllIIllIlll, lllllllllllllllIlllIIIllIIllIllI, lllllllllllllllIlllIIIllIlIIIIll, lllllllllllllllIlllIIIllIIllIlII, lllllllllllllllIlllIIIllIIllIIll, lllllllllllllllIlllIIIllIIllIIlI);
        }
        catch (Throwable lllllllllllllllIlllIIIllIIllllll) {
            final CrashReport lllllllllllllllIlllIIIllIIlllllI = CrashReport.makeCrashReport(lllllllllllllllIlllIIIllIIllllll, "Exception while adding particle");
            final CrashReportCategory lllllllllllllllIlllIIIllIIllllIl = lllllllllllllllIlllIIIllIIlllllI.makeCategory("Particle being added");
            lllllllllllllllIlllIIIllIIllllIl.addCrashSection("ID", lllllllllllllllIlllIIIllIIlllIll);
            if (lllllllllllllllIlllIIIllIIllIIlI != null) {
                lllllllllllllllIlllIIIllIIllllIl.addCrashSection("Parameters", lllllllllllllllIlllIIIllIIllIIlI);
            }
            lllllllllllllllIlllIIIllIIllllIl.setDetail("Position", new ICrashReportDetail<String>() {
                @Override
                public String call() throws Exception {
                    return CrashReportCategory.getCoordinateInfo(lllllllllllllllIlllIIIllIIlllIII, lllllllllllllllIlllIIIllIIllIlll, lllllllllllllllIlllIIIllIIllIllI);
                }
            });
            throw new ReportedException(lllllllllllllllIlllIIIllIIlllllI);
        }
    }
    
    public static void drawBoundingBox(final BufferBuilder lllllllllllllllIlllIIlIIllIIlllI, final double lllllllllllllllIlllIIlIIlllIIIIl, final double lllllllllllllllIlllIIlIIllIIlIII, final double lllllllllllllllIlllIIlIIllIllIlI, final double lllllllllllllllIlllIIlIIllIllIII, final double lllllllllllllllIlllIIlIIllIlIllI, final double lllllllllllllllIlllIIlIIlIllllll, final float lllllllllllllllIlllIIlIIllIlIlII, final float lllllllllllllllIlllIIlIIlIlllIll, final float lllllllllllllllIlllIIlIIlIlllIIl, final float lllllllllllllllIlllIIlIIllIIllII) {
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIIlIII, lllllllllllllllIlllIIlIIllIllIlI).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIllIllIII, lllllllllllllllIlllIIlIIllIIlIII, lllllllllllllllIlllIIlIIllIllIlI).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIllIllIII, lllllllllllllllIlllIIlIIllIIlIII, lllllllllllllllIlllIIlIIlIllllll).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIIlIII, lllllllllllllllIlllIIlIIlIllllll).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIIlIII, lllllllllllllllIlllIIlIIllIllIlI).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIlIllI, lllllllllllllllIlllIIlIIllIllIlI).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIllIllIII, lllllllllllllllIlllIIlIIllIlIllI, lllllllllllllllIlllIIlIIllIllIlI).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIllIllIII, lllllllllllllllIlllIIlIIllIlIllI, lllllllllllllllIlllIIlIIlIllllll).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIlIllI, lllllllllllllllIlllIIlIIlIllllll).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIlIllI, lllllllllllllllIlllIIlIIllIllIlI).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, 0.0f).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIlIllI, lllllllllllllllIlllIIlIIlIllllll).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIlllIIIIl, lllllllllllllllIlllIIlIIllIIlIII, lllllllllllllllIlllIIlIIlIllllll).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIllIllIII, lllllllllllllllIlllIIlIIllIIlIII, lllllllllllllllIlllIIlIIlIllllll).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, 0.0f).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIllIllIII, lllllllllllllllIlllIIlIIllIlIllI, lllllllllllllllIlllIIlIIlIllllll).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIllIllIII, lllllllllllllllIlllIIlIIllIlIllI, lllllllllllllllIlllIIlIIllIllIlI).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, 0.0f).endVertex();
        lllllllllllllllIlllIIlIIllIIlllI.pos(lllllllllllllllIlllIIlIIllIllIII, lllllllllllllllIlllIIlIIllIIlIII, lllllllllllllllIlllIIlIIllIllIlI).color(lllllllllllllllIlllIIlIIllIlIlII, lllllllllllllllIlllIIlIIlIlllIll, lllllllllllllllIlllIIlIIlIlllIIl, lllllllllllllllIlllIIlIIllIIllII).endVertex();
    }
    
    private void freeRenderInformation(final ContainerLocalRenderInformation lllllllllllllllIlllIIIIllIllIIlI) {
        if (lllllllllllllllIlllIIIIllIllIIlI.cacheable) {
            RenderGlobal.renderInfoCache.add(lllllllllllllllIlllIIIIllIllIIlI);
        }
    }
    
    public int getCountActiveRenderers() {
        return this.renderInfos.size();
    }
    
    public static class ContainerLocalRenderInformation
    {
        /* synthetic */ boolean cacheable;
        /* synthetic */ RenderChunk renderChunk;
        /* synthetic */ EnumFacing facing;
        /* synthetic */ int setFacing;
        
        public ContainerLocalRenderInformation(final RenderChunk llllllllllllllllIIllllIIIlIlllll, final EnumFacing llllllllllllllllIIllllIIIlIllllI, final int llllllllllllllllIIllllIIIlIlllIl) {
            this.cacheable = false;
            this.renderChunk = llllllllllllllllIIllllIIIlIlllll;
            this.facing = llllllllllllllllIIllllIIIlIllllI;
            this.setFacing = llllllllllllllllIIllllIIIlIlllIl;
        }
        
        public void setDirection(final byte llllllllllllllllIIllllIIIlIlIlII, final EnumFacing llllllllllllllllIIllllIIIlIlIIII) {
            this.setFacing = (this.setFacing | llllllllllllllllIIllllIIIlIlIlII | 1 << llllllllllllllllIIllllIIIlIlIIII.ordinal());
        }
        
        public boolean hasDirection(final EnumFacing llllllllllllllllIIllllIIIlIIlIlI) {
            return (this.setFacing & 1 << llllllllllllllllIIllllIIIlIIlIlI.ordinal()) > 0;
        }
        
        private void initialize(final RenderChunk llllllllllllllllIIllllIIIlIIIIII, final EnumFacing llllllllllllllllIIllllIIIlIIIIll, final int llllllllllllllllIIllllIIIIlllllI) {
            this.renderChunk = llllllllllllllllIIllllIIIlIIIIII;
            this.facing = llllllllllllllllIIllllIIIlIIIIll;
            this.setFacing = llllllllllllllllIIllllIIIIlllllI;
        }
    }
}
