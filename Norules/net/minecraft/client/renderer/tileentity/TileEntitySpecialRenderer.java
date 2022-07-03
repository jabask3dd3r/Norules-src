package net.minecraft.client.renderer.tileentity;

import net.minecraft.tileentity.*;
import net.optifine.entity.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;

public abstract class TileEntitySpecialRenderer<T extends TileEntity> implements IEntityRenderer
{
    protected /* synthetic */ TileEntityRendererDispatcher rendererDispatcher;
    private /* synthetic */ ResourceLocation locationTextureCustom;
    private /* synthetic */ Class tileEntityClass;
    
    @Override
    public Class getEntityClass() {
        return this.tileEntityClass;
    }
    
    static {
        DESTROY_STAGES = new ResourceLocation[] { new ResourceLocation("textures/blocks/destroy_stage_0.png"), new ResourceLocation("textures/blocks/destroy_stage_1.png"), new ResourceLocation("textures/blocks/destroy_stage_2.png"), new ResourceLocation("textures/blocks/destroy_stage_3.png"), new ResourceLocation("textures/blocks/destroy_stage_4.png"), new ResourceLocation("textures/blocks/destroy_stage_5.png"), new ResourceLocation("textures/blocks/destroy_stage_6.png"), new ResourceLocation("textures/blocks/destroy_stage_7.png"), new ResourceLocation("textures/blocks/destroy_stage_8.png"), new ResourceLocation("textures/blocks/destroy_stage_9.png") };
    }
    
    @Override
    public void setLocationTextureCustom(final ResourceLocation lllllllllllllllIlIllIIIlIlllllII) {
        this.locationTextureCustom = lllllllllllllllIlIllIIIlIlllllII;
    }
    
    @Override
    public void setEntityClass(final Class lllllllllllllllIlIllIIIllIIIllll) {
        this.tileEntityClass = lllllllllllllllIlIllIIIllIIIllll;
    }
    
    public void renderTileEntityFast(final T lllllllllllllllIlIllIIIllIlIIlIl, final double lllllllllllllllIlIllIIIllIlIIlII, final double lllllllllllllllIlIllIIIllIlIIIll, final double lllllllllllllllIlIllIIIllIlIIIlI, final float lllllllllllllllIlIllIIIllIlIIIIl, final int lllllllllllllllIlIllIIIllIlIIIII, final float lllllllllllllllIlIllIIIllIIlllll, final BufferBuilder lllllllllllllllIlIllIIIllIIllllI) {
    }
    
    public boolean isGlobalRenderer(final T lllllllllllllllIlIllIIIlllIIlIll) {
        return false;
    }
    
    public void setRendererDispatcher(final TileEntityRendererDispatcher lllllllllllllllIlIllIIIlllIlIIII) {
        this.rendererDispatcher = lllllllllllllllIlIllIIIlllIlIIII;
    }
    
    @Override
    public ResourceLocation getLocationTextureCustom() {
        return this.locationTextureCustom;
    }
    
    protected void bindTexture(final ResourceLocation lllllllllllllllIlIllIIIlllIlllIl) {
        final TextureManager lllllllllllllllIlIllIIIlllIlllII = this.rendererDispatcher.renderEngine;
        if (lllllllllllllllIlIllIIIlllIlllII != null) {
            lllllllllllllllIlIllIIIlllIlllII.bindTexture(lllllllllllllllIlIllIIIlllIlllIl);
        }
    }
    
    public void func_192841_a(final T lllllllllllllllIlIllIIIlllllIIll, final double lllllllllllllllIlIllIIIllllIlIIl, final double lllllllllllllllIlIllIIIlllllIIIl, final double lllllllllllllllIlIllIIIlllllIIII, final float lllllllllllllllIlIllIIIllllIllll, final int lllllllllllllllIlIllIIIllllIlllI, final float lllllllllllllllIlIllIIIllllIllIl) {
        final ITextComponent lllllllllllllllIlIllIIIllllIllII = lllllllllllllllIlIllIIIlllllIIll.getDisplayName();
        if (lllllllllllllllIlIllIIIllllIllII != null && this.rendererDispatcher.cameraHitResult != null && lllllllllllllllIlIllIIIlllllIIll.getPos().equals(this.rendererDispatcher.cameraHitResult.getBlockPos())) {
            this.setLightmapDisabled(true);
            this.drawNameplate(lllllllllllllllIlIllIIIlllllIIll, lllllllllllllllIlIllIIIllllIllII.getFormattedText(), lllllllllllllllIlIllIIIllllIlIIl, lllllllllllllllIlIllIIIlllllIIIl, lllllllllllllllIlIllIIIlllllIIII, 12);
            this.setLightmapDisabled(false);
        }
    }
    
    protected void setLightmapDisabled(final boolean lllllllllllllllIlIllIIIllllIIIlI) {
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        if (lllllllllllllllIlIllIIIllllIIIlI) {
            GlStateManager.disableTexture2D();
        }
        else {
            GlStateManager.enableTexture2D();
        }
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    protected World getWorld() {
        return this.rendererDispatcher.worldObj;
    }
    
    public FontRenderer getFontRenderer() {
        return this.rendererDispatcher.getFontRenderer();
    }
    
    protected void drawNameplate(final T lllllllllllllllIlIllIIIllIllllIl, final String lllllllllllllllIlIllIIIllIllllII, final double lllllllllllllllIlIllIIIllIlIllll, final double lllllllllllllllIlIllIIIllIlIlllI, final double lllllllllllllllIlIllIIIllIlIllIl, final int lllllllllllllllIlIllIIIllIlIllII) {
        final Entity lllllllllllllllIlIllIIIllIllIlll = this.rendererDispatcher.entity;
        final double lllllllllllllllIlIllIIIllIllIllI = lllllllllllllllIlIllIIIllIllllIl.getDistanceSq(lllllllllllllllIlIllIIIllIllIlll.posX, lllllllllllllllIlIllIIIllIllIlll.posY, lllllllllllllllIlIllIIIllIllIlll.posZ);
        if (lllllllllllllllIlIllIIIllIllIllI <= lllllllllllllllIlIllIIIllIlIllII * lllllllllllllllIlIllIIIllIlIllII) {
            final float lllllllllllllllIlIllIIIllIllIlIl = this.rendererDispatcher.entityYaw;
            final float lllllllllllllllIlIllIIIllIllIlII = this.rendererDispatcher.entityPitch;
            final boolean lllllllllllllllIlIllIIIllIllIIll = false;
            EntityRenderer.drawNameplate(this.getFontRenderer(), lllllllllllllllIlIllIIIllIllllII, (float)lllllllllllllllIlIllIIIllIlIllll + 0.5f, (float)lllllllllllllllIlIllIIIllIlIlllI + 1.5f, (float)lllllllllllllllIlIllIIIllIlIllIl + 0.5f, 0, lllllllllllllllIlIllIIIllIllIlIl, lllllllllllllllIlIllIIIllIllIlII, false, false);
        }
    }
    
    public TileEntitySpecialRenderer() {
        this.tileEntityClass = null;
        this.locationTextureCustom = null;
    }
}
