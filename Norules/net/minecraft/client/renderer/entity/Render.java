package net.minecraft.client.renderer.entity;

import net.optifine.entity.model.*;
import net.minecraft.scoreboard.*;
import net.minecraft.client.gui.*;
import javax.annotation.*;
import net.minecraft.block.state.*;
import net.minecraft.world.*;
import optifine.*;
import shadersmod.client.*;
import net.minecraft.client.renderer.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.renderer.culling.*;

public abstract class Render<T extends Entity> implements IEntityRenderer
{
    public /* synthetic */ float shadowSize;
    private /* synthetic */ ResourceLocation locationTextureCustom;
    protected /* synthetic */ boolean renderOutlines;
    private static final /* synthetic */ ResourceLocation SHADOW_TEXTURES;
    protected /* synthetic */ float shadowOpaque;
    protected final /* synthetic */ RenderManager renderManager;
    private /* synthetic */ Class entityClass;
    
    @Override
    public void setEntityClass(final Class llllllllllllllIlIIlllllIIIIIIlll) {
        this.entityClass = llllllllllllllIlIIlllllIIIIIIlll;
    }
    
    public void bindTexture(final ResourceLocation llllllllllllllIlIIlllllllIlllIlI) {
        this.renderManager.renderEngine.bindTexture(llllllllllllllIlIIlllllllIlllIlI);
    }
    
    protected void renderName(final T llllllllllllllIlIIlllllllllIIIIl, final double llllllllllllllIlIIlllllllllIIIII, final double llllllllllllllIlIIllllllllIlllll, final double llllllllllllllIlIIllllllllIllllI) {
        if (this.canRenderName(llllllllllllllIlIIlllllllllIIIIl)) {
            this.renderLivingLabel(llllllllllllllIlIIlllllllllIIIIl, llllllllllllllIlIIlllllllllIIIIl.getDisplayName().getFormattedText(), llllllllllllllIlIIlllllllllIIIII, llllllllllllllIlIIllllllllIlllll, llllllllllllllIlIIllllllllIllllI, 64);
        }
    }
    
    protected int getTeamColor(final T llllllllllllllIlIIllllllllllIIII) {
        int llllllllllllllIlIIllllllllllIlII = 16777215;
        final ScorePlayerTeam llllllllllllllIlIIllllllllllIIll = (ScorePlayerTeam)llllllllllllllIlIIllllllllllIIII.getTeam();
        if (llllllllllllllIlIIllllllllllIIll != null) {
            final String llllllllllllllIlIIllllllllllIIlI = FontRenderer.getFormatFromString(llllllllllllllIlIIllllllllllIIll.getColorPrefix());
            if (llllllllllllllIlIIllllllllllIIlI.length() >= 2) {
                llllllllllllllIlIIllllllllllIlII = this.getFontRendererFromRenderManager().getColorCode(llllllllllllllIlIIllllllllllIIlI.charAt(1));
            }
        }
        return llllllllllllllIlIIllllllllllIlII;
    }
    
    @Nullable
    protected abstract ResourceLocation getEntityTexture(final T p0);
    
    protected void renderEntityName(final T llllllllllllllIlIIllllllllIlIIlI, final double llllllllllllllIlIIllllllllIlIIIl, final double llllllllllllllIlIIllllllllIIlIIl, final double llllllllllllllIlIIllllllllIIlIII, final String llllllllllllllIlIIllllllllIIlllI, final double llllllllllllllIlIIllllllllIIllIl) {
        this.renderLivingLabel(llllllllllllllIlIIllllllllIlIIlI, llllllllllllllIlIIllllllllIIlllI, llllllllllllllIlIIllllllllIlIIIl, llllllllllllllIlIIllllllllIIlIIl, llllllllllllllIlIIllllllllIIlIII, 64);
    }
    
    public void renderMultipass(final T llllllllllllllIlIIlllllIIIIlIlIl, final double llllllllllllllIlIIlllllIIIIlIlII, final double llllllllllllllIlIIlllllIIIIlIIll, final double llllllllllllllIlIIlllllIIIIlIIlI, final float llllllllllllllIlIIlllllIIIIlIIIl, final float llllllllllllllIlIIlllllIIIIlIIII) {
    }
    
    public RenderManager getRenderManager() {
        return this.renderManager;
    }
    
    public boolean isMultipass() {
        return false;
    }
    
    @Override
    public Class getEntityClass() {
        return this.entityClass;
    }
    
    public void doRender(final T llllllllllllllIlIIllllllllllllll, final double llllllllllllllIlIlIIIIIIIIIIIlIl, final double llllllllllllllIlIlIIIIIIIIIIIlII, final double llllllllllllllIlIIllllllllllllII, final float llllllllllllllIlIlIIIIIIIIIIIIlI, final float llllllllllllllIlIlIIIIIIIIIIIIIl) {
        if (!this.renderOutlines) {
            this.renderName(llllllllllllllIlIIllllllllllllll, llllllllllllllIlIlIIIIIIIIIIIlIl, llllllllllllllIlIlIIIIIIIIIIIlII, llllllllllllllIlIIllllllllllllII);
        }
    }
    
    private World getWorldFromRenderManager() {
        return this.renderManager.worldObj;
    }
    
    private void renderShadowSingle(final IBlockState llllllllllllllIlIIlllllIlIIlIllI, final double llllllllllllllIlIIlllllIlIllIlII, final double llllllllllllllIlIIlllllIlIllIIll, final double llllllllllllllIlIIlllllIlIIIlllI, final BlockPos llllllllllllllIlIIlllllIlIllIIIl, final float llllllllllllllIlIIlllllIlIllIIII, final float llllllllllllllIlIIlllllIlIIIlIIl, final double llllllllllllllIlIIlllllIlIlIlllI, final double llllllllllllllIlIIlllllIlIIIIllI, final double llllllllllllllIlIIlllllIlIIIIlII) {
        if (llllllllllllllIlIIlllllIlIIlIllI.isFullCube()) {
            final Tessellator llllllllllllllIlIIlllllIlIlIlIll = Tessellator.getInstance();
            final BufferBuilder llllllllllllllIlIIlllllIlIlIlIlI = llllllllllllllIlIIlllllIlIlIlIll.getBuffer();
            double llllllllllllllIlIIlllllIlIlIlIIl = (llllllllllllllIlIIlllllIlIllIIII - (llllllllllllllIlIIlllllIlIllIIll - (llllllllllllllIlIIlllllIlIllIIIl.getY() + llllllllllllllIlIIlllllIlIIIIllI)) / 2.0) * 0.5 * this.getWorldFromRenderManager().getLightBrightness(llllllllllllllIlIIlllllIlIllIIIl);
            if (llllllllllllllIlIIlllllIlIlIlIIl >= 0.0) {
                if (llllllllllllllIlIIlllllIlIlIlIIl > 1.0) {
                    llllllllllllllIlIIlllllIlIlIlIIl = 1.0;
                }
                final AxisAlignedBB llllllllllllllIlIIlllllIlIlIlIII = llllllllllllllIlIIlllllIlIIlIllI.getBoundingBox(this.getWorldFromRenderManager(), llllllllllllllIlIIlllllIlIllIIIl);
                final double llllllllllllllIlIIlllllIlIlIIlll = llllllllllllllIlIIlllllIlIllIIIl.getX() + llllllllllllllIlIIlllllIlIlIlIII.minX + llllllllllllllIlIIlllllIlIlIlllI;
                final double llllllllllllllIlIIlllllIlIlIIllI = llllllllllllllIlIIlllllIlIllIIIl.getX() + llllllllllllllIlIIlllllIlIlIlIII.maxX + llllllllllllllIlIIlllllIlIlIlllI;
                final double llllllllllllllIlIIlllllIlIlIIlIl = llllllllllllllIlIIlllllIlIllIIIl.getY() + llllllllllllllIlIIlllllIlIlIlIII.minY + llllllllllllllIlIIlllllIlIIIIllI + 0.015625;
                final double llllllllllllllIlIIlllllIlIlIIIll = llllllllllllllIlIIlllllIlIllIIIl.getZ() + llllllllllllllIlIIlllllIlIlIlIII.minZ + llllllllllllllIlIIlllllIlIIIIlII;
                final double llllllllllllllIlIIlllllIlIlIIIIl = llllllllllllllIlIIlllllIlIllIIIl.getZ() + llllllllllllllIlIIlllllIlIlIlIII.maxZ + llllllllllllllIlIIlllllIlIIIIlII;
                final float llllllllllllllIlIIlllllIlIlIIIII = (float)((llllllllllllllIlIIlllllIlIllIlII - llllllllllllllIlIIlllllIlIlIIlll) / 2.0 / llllllllllllllIlIIlllllIlIIIlIIl + 0.5);
                final float llllllllllllllIlIIlllllIlIIllllI = (float)((llllllllllllllIlIIlllllIlIllIlII - llllllllllllllIlIIlllllIlIlIIllI) / 2.0 / llllllllllllllIlIIlllllIlIIIlIIl + 0.5);
                final float llllllllllllllIlIIlllllIlIIlllII = (float)((llllllllllllllIlIIlllllIlIIIlllI - llllllllllllllIlIIlllllIlIlIIIll) / 2.0 / llllllllllllllIlIIlllllIlIIIlIIl + 0.5);
                final float llllllllllllllIlIIlllllIlIIllIll = (float)((llllllllllllllIlIIlllllIlIIIlllI - llllllllllllllIlIIlllllIlIlIIIIl) / 2.0 / llllllllllllllIlIIlllllIlIIIlIIl + 0.5);
                llllllllllllllIlIIlllllIlIlIlIlI.pos(llllllllllllllIlIIlllllIlIlIIlll, llllllllllllllIlIIlllllIlIlIIlIl, llllllllllllllIlIIlllllIlIlIIIll).tex(llllllllllllllIlIIlllllIlIlIIIII, llllllllllllllIlIIlllllIlIIlllII).color(1.0f, 1.0f, 1.0f, (float)llllllllllllllIlIIlllllIlIlIlIIl).endVertex();
                llllllllllllllIlIIlllllIlIlIlIlI.pos(llllllllllllllIlIIlllllIlIlIIlll, llllllllllllllIlIIlllllIlIlIIlIl, llllllllllllllIlIIlllllIlIlIIIIl).tex(llllllllllllllIlIIlllllIlIlIIIII, llllllllllllllIlIIlllllIlIIllIll).color(1.0f, 1.0f, 1.0f, (float)llllllllllllllIlIIlllllIlIlIlIIl).endVertex();
                llllllllllllllIlIIlllllIlIlIlIlI.pos(llllllllllllllIlIIlllllIlIlIIllI, llllllllllllllIlIIlllllIlIlIIlIl, llllllllllllllIlIIlllllIlIlIIIIl).tex(llllllllllllllIlIIlllllIlIIllllI, llllllllllllllIlIIlllllIlIIllIll).color(1.0f, 1.0f, 1.0f, (float)llllllllllllllIlIIlllllIlIlIlIIl).endVertex();
                llllllllllllllIlIIlllllIlIlIlIlI.pos(llllllllllllllIlIIlllllIlIlIIllI, llllllllllllllIlIIlllllIlIlIIlIl, llllllllllllllIlIIlllllIlIlIIIll).tex(llllllllllllllIlIIlllllIlIIllllI, llllllllllllllIlIIlllllIlIIlllII).color(1.0f, 1.0f, 1.0f, (float)llllllllllllllIlIIlllllIlIlIlIIl).endVertex();
            }
        }
    }
    
    protected void renderLivingLabel(final T llllllllllllllIlIIlllllIIIlIIlll, final String llllllllllllllIlIIlllllIIIllIlII, final double llllllllllllllIlIIlllllIIIllIIll, final double llllllllllllllIlIIlllllIIIllIIlI, final double llllllllllllllIlIIlllllIIIllIIIl, final int llllllllllllllIlIIlllllIIIlIIIlI) {
        final double llllllllllllllIlIIlllllIIIlIllll = llllllllllllllIlIIlllllIIIlIIlll.getDistanceSqToEntity(this.renderManager.renderViewEntity);
        if (llllllllllllllIlIIlllllIIIlIllll <= llllllllllllllIlIIlllllIIIlIIIlI * llllllllllllllIlIIlllllIIIlIIIlI) {
            final boolean llllllllllllllIlIIlllllIIIlIlllI = llllllllllllllIlIIlllllIIIlIIlll.isSneaking();
            final float llllllllllllllIlIIlllllIIIlIllIl = this.renderManager.playerViewY;
            final float llllllllllllllIlIIlllllIIIlIllII = this.renderManager.playerViewX;
            final boolean llllllllllllllIlIIlllllIIIlIlIll = this.renderManager.options.thirdPersonView == 2;
            final float llllllllllllllIlIIlllllIIIlIlIlI = llllllllllllllIlIIlllllIIIlIIlll.height + 0.5f - (llllllllllllllIlIIlllllIIIlIlllI ? 0.25f : 0.0f);
            final int llllllllllllllIlIIlllllIIIlIlIIl = "deadmau5".equals(llllllllllllllIlIIlllllIIIllIlII) ? -10 : 0;
            EntityRenderer.drawNameplate(this.getFontRendererFromRenderManager(), llllllllllllllIlIIlllllIIIllIlII, (float)llllllllllllllIlIIlllllIIIllIIll, (float)llllllllllllllIlIIlllllIIIllIIlI + llllllllllllllIlIIlllllIIIlIlIlI, (float)llllllllllllllIlIIlllllIIIllIIIl, llllllllllllllIlIIlllllIIIlIlIIl, llllllllllllllIlIIlllllIIIlIllIl, llllllllllllllIlIIlllllIIIlIllII, llllllllllllllIlIIlllllIIIlIlIll, llllllllllllllIlIIlllllIIIlIlllI);
        }
    }
    
    protected boolean canRenderName(final T llllllllllllllIlIIllllllllIllIll) {
        return llllllllllllllIlIIllllllllIllIll.getAlwaysRenderNameTagForRender() && llllllllllllllIlIIllllllllIllIll.hasCustomName();
    }
    
    static {
        SHADOW_TEXTURES = new ResourceLocation("textures/misc/shadow.png");
    }
    
    private void renderShadow(final Entity llllllllllllllIlIIllllllIlIIllII, final double llllllllllllllIlIIllllllIIlIIIlI, final double llllllllllllllIlIIllllllIIlIIIII, final double llllllllllllllIlIIllllllIIIlllll, final float llllllllllllllIlIIllllllIIIlllIl, final float llllllllllllllIlIIllllllIIIllIll) {
        if (!Config.isShaders() || !Shaders.shouldSkipDefaultShadow) {
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.renderManager.renderEngine.bindTexture(Render.SHADOW_TEXTURES);
            final World llllllllllllllIlIIllllllIlIIIIIl = this.getWorldFromRenderManager();
            GlStateManager.depthMask(false);
            float llllllllllllllIlIIllllllIIllllll = this.shadowSize;
            if (llllllllllllllIlIIllllllIlIIllII instanceof EntityLiving) {
                final EntityLiving llllllllllllllIlIIllllllIIllllIl = (EntityLiving)llllllllllllllIlIIllllllIlIIllII;
                llllllllllllllIlIIllllllIIllllll *= llllllllllllllIlIIllllllIIllllIl.getRenderSizeModifier();
                if (llllllllllllllIlIIllllllIIllllIl.isChild()) {
                    llllllllllllllIlIIllllllIIllllll *= 0.5f;
                }
            }
            final double llllllllllllllIlIIllllllIIlllIll = llllllllllllllIlIIllllllIlIIllII.lastTickPosX + (llllllllllllllIlIIllllllIlIIllII.posX - llllllllllllllIlIIllllllIlIIllII.lastTickPosX) * llllllllllllllIlIIllllllIIIllIll;
            final double llllllllllllllIlIIllllllIIlllIIl = llllllllllllllIlIIllllllIlIIllII.lastTickPosY + (llllllllllllllIlIIllllllIlIIllII.posY - llllllllllllllIlIIllllllIlIIllII.lastTickPosY) * llllllllllllllIlIIllllllIIIllIll;
            final double llllllllllllllIlIIllllllIIllIlll = llllllllllllllIlIIllllllIlIIllII.lastTickPosZ + (llllllllllllllIlIIllllllIlIIllII.posZ - llllllllllllllIlIIllllllIlIIllII.lastTickPosZ) * llllllllllllllIlIIllllllIIIllIll;
            final int llllllllllllllIlIIllllllIIllIlIl = MathHelper.floor(llllllllllllllIlIIllllllIIlllIll - llllllllllllllIlIIllllllIIllllll);
            final int llllllllllllllIlIIllllllIIllIIll = MathHelper.floor(llllllllllllllIlIIllllllIIlllIll + llllllllllllllIlIIllllllIIllllll);
            final int llllllllllllllIlIIllllllIIllIIIl = MathHelper.floor(llllllllllllllIlIIllllllIIlllIIl - llllllllllllllIlIIllllllIIllllll);
            final int llllllllllllllIlIIllllllIIlIllll = MathHelper.floor(llllllllllllllIlIIllllllIIlllIIl);
            final int llllllllllllllIlIIllllllIIlIlllI = MathHelper.floor(llllllllllllllIlIIllllllIIllIlll - llllllllllllllIlIIllllllIIllllll);
            final int llllllllllllllIlIIllllllIIlIllIl = MathHelper.floor(llllllllllllllIlIIllllllIIllIlll + llllllllllllllIlIIllllllIIllllll);
            final double llllllllllllllIlIIllllllIIlIllII = llllllllllllllIlIIllllllIIlIIIlI - llllllllllllllIlIIllllllIIlllIll;
            final double llllllllllllllIlIIllllllIIlIlIll = llllllllllllllIlIIllllllIIlIIIII - llllllllllllllIlIIllllllIIlllIIl;
            final double llllllllllllllIlIIllllllIIlIlIlI = llllllllllllllIlIIllllllIIIlllll - llllllllllllllIlIIllllllIIllIlll;
            final Tessellator llllllllllllllIlIIllllllIIlIlIIl = Tessellator.getInstance();
            final BufferBuilder llllllllllllllIlIIllllllIIlIlIII = llllllllllllllIlIIllllllIIlIlIIl.getBuffer();
            llllllllllllllIlIIllllllIIlIlIII.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            for (final BlockPos llllllllllllllIlIIllllllIIlIIlll : BlockPos.getAllInBoxMutable(new BlockPos(llllllllllllllIlIIllllllIIllIlIl, llllllllllllllIlIIllllllIIllIIIl, llllllllllllllIlIIllllllIIlIlllI), new BlockPos(llllllllllllllIlIIllllllIIllIIll, llllllllllllllIlIIllllllIIlIllll, llllllllllllllIlIIllllllIIlIllIl))) {
                final IBlockState llllllllllllllIlIIllllllIIlIIllI = llllllllllllllIlIIllllllIlIIIIIl.getBlockState(llllllllllllllIlIIllllllIIlIIlll.down());
                if (llllllllllllllIlIIllllllIIlIIllI.getRenderType() != EnumBlockRenderType.INVISIBLE && llllllllllllllIlIIllllllIlIIIIIl.getLightFromNeighbors(llllllllllllllIlIIllllllIIlIIlll) > 3) {
                    this.renderShadowSingle(llllllllllllllIlIIllllllIIlIIllI, llllllllllllllIlIIllllllIIlIIIlI, llllllllllllllIlIIllllllIIlIIIII, llllllllllllllIlIIllllllIIIlllll, llllllllllllllIlIIllllllIIlIIlll, llllllllllllllIlIIllllllIIIlllIl, llllllllllllllIlIIllllllIIllllll, llllllllllllllIlIIllllllIIlIllII, llllllllllllllIlIIllllllIIlIlIll, llllllllllllllIlIIllllllIIlIlIlI);
                }
            }
            llllllllllllllIlIIllllllIIlIlIIl.draw();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.disableBlend();
            GlStateManager.depthMask(true);
        }
    }
    
    @Override
    public ResourceLocation getLocationTextureCustom() {
        return this.locationTextureCustom;
    }
    
    public static void renderOffsetAABB(final AxisAlignedBB llllllllllllllIlIIlllllIIllIllII, final double llllllllllllllIlIIlllllIIllIlIll, final double llllllllllllllIlIIlllllIIllIIlII, final double llllllllllllllIlIIlllllIIllIlIIl) {
        GlStateManager.disableTexture2D();
        final Tessellator llllllllllllllIlIIlllllIIllIlIII = Tessellator.getInstance();
        final BufferBuilder llllllllllllllIlIIlllllIIllIIlll = llllllllllllllIlIIlllllIIllIlIII.getBuffer();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        llllllllllllllIlIIlllllIIllIIlll.setTranslation(llllllllllllllIlIIlllllIIllIlIll, llllllllllllllIlIIlllllIIllIIlII, llllllllllllllIlIIlllllIIllIlIIl);
        llllllllllllllIlIIlllllIIllIIlll.begin(7, DefaultVertexFormats.POSITION_NORMAL);
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(0.0f, 0.0f, -1.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(0.0f, 0.0f, 1.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(0.0f, -1.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(0.0f, 1.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.minX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(-1.0f, 0.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.minZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.maxY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIIlll.pos(llllllllllllllIlIIlllllIIllIllII.maxX, llllllllllllllIlIIlllllIIllIllII.minY, llllllllllllllIlIIlllllIIllIllII.maxZ).normal(1.0f, 0.0f, 0.0f).endVertex();
        llllllllllllllIlIIlllllIIllIlIII.draw();
        llllllllllllllIlIIlllllIIllIIlll.setTranslation(0.0, 0.0, 0.0);
        GlStateManager.enableTexture2D();
    }
    
    private void renderEntityOnFire(final Entity llllllllllllllIlIIlllllllIIIIlll, final double llllllllllllllIlIIlllllllIIllllI, final double llllllllllllllIlIIlllllllIIlllIl, final double llllllllllllllIlIIlllllllIIlllII, final float llllllllllllllIlIIlllllllIIllIll) {
        GlStateManager.disableLighting();
        final TextureMap llllllllllllllIlIIlllllllIIllIlI = Minecraft.getMinecraft().getTextureMapBlocks();
        final TextureAtlasSprite llllllllllllllIlIIlllllllIIllIIl = llllllllllllllIlIIlllllllIIllIlI.getAtlasSprite("minecraft:blocks/fire_layer_0");
        final TextureAtlasSprite llllllllllllllIlIIlllllllIIllIII = llllllllllllllIlIIlllllllIIllIlI.getAtlasSprite("minecraft:blocks/fire_layer_1");
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)llllllllllllllIlIIlllllllIIllllI, (float)llllllllllllllIlIIlllllllIIlllIl, (float)llllllllllllllIlIIlllllllIIlllII);
        final float llllllllllllllIlIIlllllllIIlIlll = llllllllllllllIlIIlllllllIIIIlll.width * 0.8f;
        GlStateManager.scale(llllllllllllllIlIIlllllllIIlIlll, llllllllllllllIlIIlllllllIIlIlll, llllllllllllllIlIIlllllllIIlIlll);
        final Tessellator llllllllllllllIlIIlllllllIIlIllI = Tessellator.getInstance();
        final BufferBuilder llllllllllllllIlIIlllllllIIlIlIl = llllllllllllllIlIIlllllllIIlIllI.getBuffer();
        float llllllllllllllIlIIlllllllIIlIlII = 0.5f;
        final float llllllllllllllIlIIlllllllIIlIIll = 0.0f;
        float llllllllllllllIlIIlllllllIIlIIlI = llllllllllllllIlIIlllllllIIIIlll.height / llllllllllllllIlIIlllllllIIlIlll;
        float llllllllllllllIlIIlllllllIIlIIIl = (float)(llllllllllllllIlIIlllllllIIIIlll.posY - llllllllllllllIlIIlllllllIIIIlll.getEntityBoundingBox().minY);
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.translate(0.0f, 0.2f, -0.8f + (int)llllllllllllllIlIIlllllllIIlIIlI * 0.02f);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        float llllllllllllllIlIIlllllllIIlIIII = 0.0f;
        int llllllllllllllIlIIlllllllIIIllll = 0;
        llllllllllllllIlIIlllllllIIlIlIl.begin(7, DefaultVertexFormats.POSITION_TEX);
        while (llllllllllllllIlIIlllllllIIlIIlI > 0.0f) {
            final TextureAtlasSprite llllllllllllllIlIIlllllllIIIlllI = (llllllllllllllIlIIlllllllIIIllll % 2 == 0) ? llllllllllllllIlIIlllllllIIllIIl : llllllllllllllIlIIlllllllIIllIII;
            this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            float llllllllllllllIlIIlllllllIIIllIl = llllllllllllllIlIIlllllllIIIlllI.getMinU();
            final float llllllllllllllIlIIlllllllIIIllII = llllllllllllllIlIIlllllllIIIlllI.getMinV();
            float llllllllllllllIlIIlllllllIIIlIll = llllllllllllllIlIIlllllllIIIlllI.getMaxU();
            final float llllllllllllllIlIIlllllllIIIlIlI = llllllllllllllIlIIlllllllIIIlllI.getMaxV();
            if (llllllllllllllIlIIlllllllIIIllll / 2 % 2 == 0) {
                final float llllllllllllllIlIIlllllllIIIlIIl = llllllllllllllIlIIlllllllIIIlIll;
                llllllllllllllIlIIlllllllIIIlIll = llllllllllllllIlIIlllllllIIIllIl;
                llllllllllllllIlIIlllllllIIIllIl = llllllllllllllIlIIlllllllIIIlIIl;
            }
            llllllllllllllIlIIlllllllIIlIlIl.pos(llllllllllllllIlIIlllllllIIlIlII - 0.0f, 0.0f - llllllllllllllIlIIlllllllIIlIIIl, llllllllllllllIlIIlllllllIIlIIII).tex(llllllllllllllIlIIlllllllIIIlIll, llllllllllllllIlIIlllllllIIIlIlI).endVertex();
            llllllllllllllIlIIlllllllIIlIlIl.pos(-llllllllllllllIlIIlllllllIIlIlII - 0.0f, 0.0f - llllllllllllllIlIIlllllllIIlIIIl, llllllllllllllIlIIlllllllIIlIIII).tex(llllllllllllllIlIIlllllllIIIllIl, llllllllllllllIlIIlllllllIIIlIlI).endVertex();
            llllllllllllllIlIIlllllllIIlIlIl.pos(-llllllllllllllIlIIlllllllIIlIlII - 0.0f, 1.4f - llllllllllllllIlIIlllllllIIlIIIl, llllllllllllllIlIIlllllllIIlIIII).tex(llllllllllllllIlIIlllllllIIIllIl, llllllllllllllIlIIlllllllIIIllII).endVertex();
            llllllllllllllIlIIlllllllIIlIlIl.pos(llllllllllllllIlIIlllllllIIlIlII - 0.0f, 1.4f - llllllllllllllIlIIlllllllIIlIIIl, llllllllllllllIlIIlllllllIIlIIII).tex(llllllllllllllIlIIlllllllIIIlIll, llllllllllllllIlIIlllllllIIIllII).endVertex();
            llllllllllllllIlIIlllllllIIlIIlI -= 0.45f;
            llllllllllllllIlIIlllllllIIlIIIl -= 0.45f;
            llllllllllllllIlIIlllllllIIlIlII *= 0.9f;
            llllllllllllllIlIIlllllllIIlIIII += 0.03f;
            ++llllllllllllllIlIIlllllllIIIllll;
        }
        llllllllllllllIlIIlllllllIIlIllI.draw();
        GlStateManager.popMatrix();
        GlStateManager.enableLighting();
    }
    
    @Override
    public void setLocationTextureCustom(final ResourceLocation llllllllllllllIlIIllllIllllllllI) {
        this.locationTextureCustom = llllllllllllllIlIIllllIllllllllI;
    }
    
    protected boolean bindEntityTexture(final T llllllllllllllIlIIlllllllIllllll) {
        ResourceLocation llllllllllllllIlIIllllllllIIIIIl = this.getEntityTexture(llllllllllllllIlIIlllllllIllllll);
        if (this.locationTextureCustom != null) {
            llllllllllllllIlIIllllllllIIIIIl = this.locationTextureCustom;
        }
        if (llllllllllllllIlIIllllllllIIIIIl == null) {
            return false;
        }
        this.bindTexture(llllllllllllllIlIIllllllllIIIIIl);
        return true;
    }
    
    protected Render(final RenderManager llllllllllllllIlIlIIIIIIIIlIIllI) {
        this.shadowOpaque = 1.0f;
        this.entityClass = null;
        this.locationTextureCustom = null;
        this.renderManager = llllllllllllllIlIlIIIIIIIIlIIllI;
    }
    
    public void doRenderShadowAndFire(final Entity llllllllllllllIlIIlllllIIlIIlllI, final double llllllllllllllIlIIlllllIIlIlIllI, final double llllllllllllllIlIIlllllIIlIIllII, final double llllllllllllllIlIIlllllIIlIIlIll, final float llllllllllllllIlIIlllllIIlIlIIll, final float llllllllllllllIlIIlllllIIlIlIIlI) {
        if (this.renderManager.options != null) {
            if (this.renderManager.options.entityShadows && this.shadowSize > 0.0f && !llllllllllllllIlIIlllllIIlIIlllI.isInvisible() && this.renderManager.isRenderShadow()) {
                final double llllllllllllllIlIIlllllIIlIlIIIl = this.renderManager.getDistanceToCamera(llllllllllllllIlIIlllllIIlIIlllI.posX, llllllllllllllIlIIlllllIIlIIlllI.posY, llllllllllllllIlIIlllllIIlIIlllI.posZ);
                final float llllllllllllllIlIIlllllIIlIlIIII = (float)((1.0 - llllllllllllllIlIIlllllIIlIlIIIl / 256.0) * this.shadowOpaque);
                if (llllllllllllllIlIIlllllIIlIlIIII > 0.0f) {
                    this.renderShadow(llllllllllllllIlIIlllllIIlIIlllI, llllllllllllllIlIIlllllIIlIlIllI, llllllllllllllIlIIlllllIIlIIllII, llllllllllllllIlIIlllllIIlIIlIll, llllllllllllllIlIIlllllIIlIlIIII, llllllllllllllIlIIlllllIIlIlIIlI);
                }
            }
            if (llllllllllllllIlIIlllllIIlIIlllI.canRenderOnFire() && (!(llllllllllllllIlIIlllllIIlIIlllI instanceof EntityPlayer) || !((EntityPlayer)llllllllllllllIlIIlllllIIlIIlllI).isSpectator())) {
                this.renderEntityOnFire(llllllllllllllIlIIlllllIIlIIlllI, llllllllllllllIlIIlllllIIlIlIllI, llllllllllllllIlIIlllllIIlIIllII, llllllllllllllIlIIlllllIIlIIlIll, llllllllllllllIlIIlllllIIlIlIIlI);
            }
        }
    }
    
    public boolean shouldRender(final T llllllllllllllIlIlIIIIIIIIIlIIlI, final ICamera llllllllllllllIlIlIIIIIIIIIlIIIl, final double llllllllllllllIlIlIIIIIIIIIlIllI, final double llllllllllllllIlIlIIIIIIIIIlIlIl, final double llllllllllllllIlIlIIIIIIIIIIlllI) {
        AxisAlignedBB llllllllllllllIlIlIIIIIIIIIlIIll = llllllllllllllIlIlIIIIIIIIIlIIlI.getRenderBoundingBox().expandXyz(0.5);
        if (llllllllllllllIlIlIIIIIIIIIlIIll.hasNaN() || llllllllllllllIlIlIIIIIIIIIlIIll.getAverageEdgeLength() == 0.0) {
            llllllllllllllIlIlIIIIIIIIIlIIll = new AxisAlignedBB(llllllllllllllIlIlIIIIIIIIIlIIlI.posX - 2.0, llllllllllllllIlIlIIIIIIIIIlIIlI.posY - 2.0, llllllllllllllIlIlIIIIIIIIIlIIlI.posZ - 2.0, llllllllllllllIlIlIIIIIIIIIlIIlI.posX + 2.0, llllllllllllllIlIlIIIIIIIIIlIIlI.posY + 2.0, llllllllllllllIlIlIIIIIIIIIlIIlI.posZ + 2.0);
        }
        return llllllllllllllIlIlIIIIIIIIIlIIlI.isInRangeToRender3d(llllllllllllllIlIlIIIIIIIIIlIllI, llllllllllllllIlIlIIIIIIIIIlIlIl, llllllllllllllIlIlIIIIIIIIIIlllI) && (llllllllllllllIlIlIIIIIIIIIlIIlI.ignoreFrustumCheck || llllllllllllllIlIlIIIIIIIIIlIIIl.isBoundingBoxInFrustum(llllllllllllllIlIlIIIIIIIIIlIIll));
    }
    
    public FontRenderer getFontRendererFromRenderManager() {
        return this.renderManager.getFontRenderer();
    }
    
    public void setRenderOutlines(final boolean llllllllllllllIlIlIIIIIIIIlIIIlI) {
        this.renderOutlines = llllllllllllllIlIlIIIIIIIIlIIIlI;
    }
}
