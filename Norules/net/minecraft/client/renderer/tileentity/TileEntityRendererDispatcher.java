package net.minecraft.client.renderer.tileentity;

import net.minecraft.world.*;
import net.minecraft.entity.*;
import net.minecraft.client.gui.*;
import java.util.*;
import com.google.common.collect.*;
import net.minecraft.client.model.*;
import net.minecraft.tileentity.*;
import net.minecraft.client.renderer.vertex.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.crash.*;
import javax.annotation.*;

public class TileEntityRendererDispatcher
{
    public static /* synthetic */ double staticPlayerX;
    private /* synthetic */ boolean drawingBatch;
    public static /* synthetic */ TileEntityRendererDispatcher instance;
    public /* synthetic */ RayTraceResult cameraHitResult;
    public /* synthetic */ World worldObj;
    public /* synthetic */ TileEntity tileEntityRendered;
    public /* synthetic */ Entity entity;
    public /* synthetic */ float entityYaw;
    public /* synthetic */ FontRenderer fontRenderer;
    public /* synthetic */ float entityPitch;
    public /* synthetic */ double entityY;
    public static /* synthetic */ double staticPlayerZ;
    public static /* synthetic */ double staticPlayerY;
    public /* synthetic */ TextureManager renderEngine;
    private /* synthetic */ Tessellator batchBuffer;
    public /* synthetic */ double entityZ;
    public final /* synthetic */ Map<Class, TileEntitySpecialRenderer> mapSpecialRenderers;
    public /* synthetic */ double entityX;
    
    public void func_192855_a(final TileEntity lllllllllllllIIIIlIIIIllIIIllIll, final double lllllllllllllIIIIlIIIIllIIIllIlI, final double lllllllllllllIIIIlIIIIllIIlIIIII, final double lllllllllllllIIIIlIIIIllIIIllIII, final float lllllllllllllIIIIlIIIIllIIIlIlll, final float lllllllllllllIIIIlIIIIllIIIlllIl) {
        this.func_192854_a(lllllllllllllIIIIlIIIIllIIIllIll, lllllllllllllIIIIlIIIIllIIIllIlI, lllllllllllllIIIIlIIIIllIIlIIIII, lllllllllllllIIIIlIIIIllIIIllIII, lllllllllllllIIIIlIIIIllIIIlIlll, -1, lllllllllllllIIIIlIIIIllIIIlllIl);
    }
    
    public FontRenderer getFontRenderer() {
        return this.fontRenderer;
    }
    
    private TileEntityRendererDispatcher() {
        this.mapSpecialRenderers = (Map<Class, TileEntitySpecialRenderer>)Maps.newHashMap();
        this.batchBuffer = new Tessellator(2097152);
        this.drawingBatch = false;
        this.mapSpecialRenderers.put(TileEntitySign.class, new TileEntitySignRenderer());
        this.mapSpecialRenderers.put(TileEntityMobSpawner.class, new TileEntityMobSpawnerRenderer());
        this.mapSpecialRenderers.put(TileEntityPiston.class, new TileEntityPistonRenderer());
        this.mapSpecialRenderers.put(TileEntityChest.class, new TileEntityChestRenderer());
        this.mapSpecialRenderers.put(TileEntityEnderChest.class, new TileEntityEnderChestRenderer());
        this.mapSpecialRenderers.put(TileEntityEnchantmentTable.class, new TileEntityEnchantmentTableRenderer());
        this.mapSpecialRenderers.put(TileEntityEndPortal.class, new TileEntityEndPortalRenderer());
        this.mapSpecialRenderers.put(TileEntityEndGateway.class, new TileEntityEndGatewayRenderer());
        this.mapSpecialRenderers.put(TileEntityBeacon.class, new TileEntityBeaconRenderer());
        this.mapSpecialRenderers.put(TileEntitySkull.class, new TileEntitySkullRenderer());
        this.mapSpecialRenderers.put(TileEntityBanner.class, new TileEntityBannerRenderer());
        this.mapSpecialRenderers.put(TileEntityStructure.class, new TileEntityStructureRenderer());
        this.mapSpecialRenderers.put(TileEntityShulkerBox.class, new TileEntityShulkerBoxRenderer(new ModelShulker()));
        this.mapSpecialRenderers.put(TileEntityBed.class, new TileEntityBedRenderer());
        for (final TileEntitySpecialRenderer<?> lllllllllllllIIIIlIIIIllIlllllIl : this.mapSpecialRenderers.values()) {
            lllllllllllllIIIIlIIIIllIlllllIl.setRendererDispatcher(this);
        }
    }
    
    public void preDrawBatch() {
        this.batchBuffer.getBuffer().begin(7, DefaultVertexFormats.BLOCK);
        this.drawingBatch = true;
    }
    
    public void renderTileEntity(final TileEntity lllllllllllllIIIIlIIIIllIlIIllII, final float lllllllllllllIIIIlIIIIllIlIIlIll, final int lllllllllllllIIIIlIIIIllIlIIIIIl) {
        if (lllllllllllllIIIIlIIIIllIlIIllII.getDistanceSq(this.entityX, this.entityY, this.entityZ) < lllllllllllllIIIIlIIIIllIlIIllII.getMaxRenderDistanceSquared()) {
            RenderHelper.enableStandardItemLighting();
            boolean lllllllllllllIIIIlIIIIllIlIIlIIl = true;
            if (Reflector.ForgeTileEntity_hasFastRenderer.exists()) {
                lllllllllllllIIIIlIIIIllIlIIlIIl = (!this.drawingBatch || !Reflector.callBoolean(lllllllllllllIIIIlIIIIllIlIIllII, Reflector.ForgeTileEntity_hasFastRenderer, new Object[0]));
            }
            if (lllllllllllllIIIIlIIIIllIlIIlIIl) {
                final int lllllllllllllIIIIlIIIIllIlIIlIII = this.worldObj.getCombinedLight(lllllllllllllIIIIlIIIIllIlIIllII.getPos(), 0);
                final int lllllllllllllIIIIlIIIIllIlIIIlll = lllllllllllllIIIIlIIIIllIlIIlIII % 65536;
                final int lllllllllllllIIIIlIIIIllIlIIIllI = lllllllllllllIIIIlIIIIllIlIIlIII / 65536;
                OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)lllllllllllllIIIIlIIIIllIlIIIlll, (float)lllllllllllllIIIIlIIIIllIlIIIllI);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            }
            final BlockPos lllllllllllllIIIIlIIIIllIlIIIlIl = lllllllllllllIIIIlIIIIllIlIIllII.getPos();
            this.func_192854_a(lllllllllllllIIIIlIIIIllIlIIllII, lllllllllllllIIIIlIIIIllIlIIIlIl.getX() - TileEntityRendererDispatcher.staticPlayerX, lllllllllllllIIIIlIIIIllIlIIIlIl.getY() - TileEntityRendererDispatcher.staticPlayerY, lllllllllllllIIIIlIIIIllIlIIIlIl.getZ() - TileEntityRendererDispatcher.staticPlayerZ, lllllllllllllIIIIlIIIIllIlIIlIll, lllllllllllllIIIIlIIIIllIlIIIIIl, 1.0f);
        }
    }
    
    public void renderTileEntityAt(final TileEntity lllllllllllllIIIIlIIIIllIIllIlIl, final double lllllllllllllIIIIlIIIIllIIlIlllI, final double lllllllllllllIIIIlIIIIllIIllIIll, final double lllllllllllllIIIIlIIIIllIIllIIlI, final float lllllllllllllIIIIlIIIIllIIlIlIll) {
        this.func_192855_a(lllllllllllllIIIIlIIIIllIIllIlIl, lllllllllllllIIIIlIIIIllIIlIlllI, lllllllllllllIIIIlIIIIllIIllIIll, lllllllllllllIIIIlIIIIllIIllIIlI, lllllllllllllIIIIlIIIIllIIlIlIll, 1.0f);
    }
    
    public void drawBatch(final int lllllllllllllIIIIlIIIIlIlllIIIlI) {
        this.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        RenderHelper.disableStandardItemLighting();
        GlStateManager.blendFunc(770, 771);
        GlStateManager.enableBlend();
        GlStateManager.disableCull();
        if (Minecraft.isAmbientOcclusionEnabled()) {
            GlStateManager.shadeModel(7425);
        }
        else {
            GlStateManager.shadeModel(7424);
        }
        if (lllllllllllllIIIIlIIIIlIlllIIIlI > 0) {
            this.batchBuffer.getBuffer().sortVertexData(0.0f, 0.0f, 0.0f);
        }
        this.batchBuffer.draw();
        RenderHelper.enableStandardItemLighting();
        this.drawingBatch = false;
    }
    
    public <T extends TileEntity> TileEntitySpecialRenderer<T> getSpecialRendererByClass(final Class<? extends TileEntity> lllllllllllllIIIIlIIIIllIlllIIlI) {
        TileEntitySpecialRenderer<T> lllllllllllllIIIIlIIIIllIlllIlII = this.mapSpecialRenderers.get(lllllllllllllIIIIlIIIIllIlllIIlI);
        if (lllllllllllllIIIIlIIIIllIlllIlII == null && lllllllllllllIIIIlIIIIllIlllIIlI != TileEntity.class) {
            lllllllllllllIIIIlIIIIllIlllIlII = (TileEntitySpecialRenderer<T>)this.getSpecialRendererByClass((Class<? extends TileEntity>)lllllllllllllIIIIlIIIIllIlllIIlI.getSuperclass());
            this.mapSpecialRenderers.put(lllllllllllllIIIIlIIIIllIlllIIlI, lllllllllllllIIIIlIIIIllIlllIlII);
        }
        return lllllllllllllIIIIlIIIIllIlllIlII;
    }
    
    public void func_192854_a(final TileEntity lllllllllllllIIIIlIIIIllIIIIlIII, final double lllllllllllllIIIIlIIIIllIIIIIlll, final double lllllllllllllIIIIlIIIIlIlllllIlI, final double lllllllllllllIIIIlIIIIllIIIIIlIl, final float lllllllllllllIIIIlIIIIllIIIIIlII, final int lllllllllllllIIIIlIIIIllIIIIIIll, final float lllllllllllllIIIIlIIIIlIllllIllI) {
        final TileEntitySpecialRenderer<TileEntity> lllllllllllllIIIIlIIIIllIIIIIIIl = this.getSpecialRenderer(lllllllllllllIIIIlIIIIllIIIIlIII);
        if (lllllllllllllIIIIlIIIIllIIIIIIIl != null) {
            try {
                this.tileEntityRendered = lllllllllllllIIIIlIIIIllIIIIlIII;
                if (this.drawingBatch && Reflector.callBoolean(lllllllllllllIIIIlIIIIllIIIIlIII, Reflector.ForgeTileEntity_hasFastRenderer, new Object[0])) {
                    lllllllllllllIIIIlIIIIllIIIIIIIl.renderTileEntityFast(lllllllllllllIIIIlIIIIllIIIIlIII, lllllllllllllIIIIlIIIIllIIIIIlll, lllllllllllllIIIIlIIIIlIlllllIlI, lllllllllllllIIIIlIIIIllIIIIIlIl, lllllllllllllIIIIlIIIIllIIIIIlII, lllllllllllllIIIIlIIIIllIIIIIIll, lllllllllllllIIIIlIIIIlIllllIllI, this.batchBuffer.getBuffer());
                }
                else {
                    lllllllllllllIIIIlIIIIllIIIIIIIl.func_192841_a(lllllllllllllIIIIlIIIIllIIIIlIII, lllllllllllllIIIIlIIIIllIIIIIlll, lllllllllllllIIIIlIIIIlIlllllIlI, lllllllllllllIIIIlIIIIllIIIIIlIl, lllllllllllllIIIIlIIIIllIIIIIlII, lllllllllllllIIIIlIIIIllIIIIIIll, lllllllllllllIIIIlIIIIlIllllIllI);
                }
                this.tileEntityRendered = null;
            }
            catch (Throwable lllllllllllllIIIIlIIIIllIIIIIIII) {
                final CrashReport lllllllllllllIIIIlIIIIlIllllllll = CrashReport.makeCrashReport(lllllllllllllIIIIlIIIIllIIIIIIII, "Rendering Block Entity");
                final CrashReportCategory lllllllllllllIIIIlIIIIlIlllllllI = lllllllllllllIIIIlIIIIlIllllllll.makeCategory("Block Entity Details");
                lllllllllllllIIIIlIIIIllIIIIlIII.addInfoToCrashReport(lllllllllllllIIIIlIIIIlIlllllllI);
                throw new ReportedException(lllllllllllllIIIIlIIIIlIllllllll);
            }
        }
    }
    
    static {
        TileEntityRendererDispatcher.instance = new TileEntityRendererDispatcher();
    }
    
    public void setWorld(@Nullable final World lllllllllllllIIIIlIIIIlIlllIllII) {
        this.worldObj = lllllllllllllIIIIlIIIIlIlllIllII;
        if (lllllllllllllIIIIlIIIIlIlllIllII == null) {
            this.entity = null;
        }
    }
    
    @Nullable
    public <T extends TileEntity> TileEntitySpecialRenderer<T> getSpecialRenderer(@Nullable final TileEntity lllllllllllllIIIIlIIIIllIllIlIll) {
        return (lllllllllllllIIIIlIIIIllIllIlIll == null) ? null : this.getSpecialRendererByClass(lllllllllllllIIIIlIIIIllIllIlIll.getClass());
    }
    
    public void prepare(final World lllllllllllllIIIIlIIIIllIlIllIll, final TextureManager lllllllllllllIIIIlIIIIllIlIllIlI, final FontRenderer lllllllllllllIIIIlIIIIllIllIIIII, final Entity lllllllllllllIIIIlIIIIllIlIllIII, final RayTraceResult lllllllllllllIIIIlIIIIllIlIlIlll, final float lllllllllllllIIIIlIIIIllIlIlIllI) {
        if (this.worldObj != lllllllllllllIIIIlIIIIllIlIllIll) {
            this.setWorld(lllllllllllllIIIIlIIIIllIlIllIll);
        }
        this.renderEngine = lllllllllllllIIIIlIIIIllIlIllIlI;
        this.entity = lllllllllllllIIIIlIIIIllIlIllIII;
        this.fontRenderer = lllllllllllllIIIIlIIIIllIllIIIII;
        this.cameraHitResult = lllllllllllllIIIIlIIIIllIlIlIlll;
        this.entityYaw = lllllllllllllIIIIlIIIIllIlIllIII.prevRotationYaw + (lllllllllllllIIIIlIIIIllIlIllIII.rotationYaw - lllllllllllllIIIIlIIIIllIlIllIII.prevRotationYaw) * lllllllllllllIIIIlIIIIllIlIlIllI;
        this.entityPitch = lllllllllllllIIIIlIIIIllIlIllIII.prevRotationPitch + (lllllllllllllIIIIlIIIIllIlIllIII.rotationPitch - lllllllllllllIIIIlIIIIllIlIllIII.prevRotationPitch) * lllllllllllllIIIIlIIIIllIlIlIllI;
        this.entityX = lllllllllllllIIIIlIIIIllIlIllIII.lastTickPosX + (lllllllllllllIIIIlIIIIllIlIllIII.posX - lllllllllllllIIIIlIIIIllIlIllIII.lastTickPosX) * lllllllllllllIIIIlIIIIllIlIlIllI;
        this.entityY = lllllllllllllIIIIlIIIIllIlIllIII.lastTickPosY + (lllllllllllllIIIIlIIIIllIlIllIII.posY - lllllllllllllIIIIlIIIIllIlIllIII.lastTickPosY) * lllllllllllllIIIIlIIIIllIlIlIllI;
        this.entityZ = lllllllllllllIIIIlIIIIllIlIllIII.lastTickPosZ + (lllllllllllllIIIIlIIIIllIlIllIII.posZ - lllllllllllllIIIIlIIIIllIlIllIII.lastTickPosZ) * lllllllllllllIIIIlIIIIllIlIlIllI;
    }
}
