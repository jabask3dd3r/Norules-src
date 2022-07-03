package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.math.*;
import javax.annotation.*;
import net.minecraft.init.*;
import optifine.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.*;
import net.minecraft.item.*;
import net.minecraft.world.storage.*;

public class RenderItemFrame extends Render<EntityItemFrame>
{
    private final /* synthetic */ Minecraft mc;
    private final /* synthetic */ RenderItem itemRenderer;
    private static final /* synthetic */ ResourceLocation MAP_BACKGROUND_TEXTURES;
    private final /* synthetic */ ModelResourceLocation itemFrameModel;
    private final /* synthetic */ ModelResourceLocation mapModel;
    
    @Override
    protected void renderName(final EntityItemFrame lllllllllllllIlIIlllIlIllIIIlllI, final double lllllllllllllIlIIlllIlIllIIIIlIl, final double lllllllllllllIlIIlllIlIllIIIllII, final double lllllllllllllIlIIlllIlIllIIIlIll) {
        if (Minecraft.isGuiEnabled() && !lllllllllllllIlIIlllIlIllIIIlllI.getDisplayedItem().func_190926_b() && lllllllllllllIlIIlllIlIllIIIlllI.getDisplayedItem().hasDisplayName() && this.renderManager.pointedEntity == lllllllllllllIlIIlllIlIllIIIlllI) {
            final double lllllllllllllIlIIlllIlIllIIIlIlI = lllllllllllllIlIIlllIlIllIIIlllI.getDistanceSqToEntity(this.renderManager.renderViewEntity);
            final float lllllllllllllIlIIlllIlIllIIIlIIl = lllllllllllllIlIIlllIlIllIIIlllI.isSneaking() ? 32.0f : 64.0f;
            if (lllllllllllllIlIIlllIlIllIIIlIlI < lllllllllllllIlIIlllIlIllIIIlIIl * lllllllllllllIlIIlllIlIllIIIlIIl) {
                final String lllllllllllllIlIIlllIlIllIIIlIII = lllllllllllllIlIIlllIlIllIIIlllI.getDisplayedItem().getDisplayName();
                this.renderLivingLabel(lllllllllllllIlIIlllIlIllIIIlllI, lllllllllllllIlIIlllIlIllIIIlIII, lllllllllllllIlIIlllIlIllIIIIlIl, lllllllllllllIlIIlllIlIllIIIllII, lllllllllllllIlIIlllIlIllIIIlIll, 64);
            }
        }
    }
    
    @Override
    public void doRender(final EntityItemFrame lllllllllllllIlIIlllIlIllIlllIll, final double lllllllllllllIlIIlllIlIlllIIlIIl, final double lllllllllllllIlIIlllIlIllIllIllI, final double lllllllllllllIlIIlllIlIlllIIIlll, final float lllllllllllllIlIIlllIlIlllIIIllI, final float lllllllllllllIlIIlllIlIlllIIIlIl) {
        GlStateManager.pushMatrix();
        final BlockPos lllllllllllllIlIIlllIlIlllIIIlII = lllllllllllllIlIIlllIlIllIlllIll.getHangingPosition();
        final double lllllllllllllIlIIlllIlIlllIIIIll = lllllllllllllIlIIlllIlIlllIIIlII.getX() - lllllllllllllIlIIlllIlIllIlllIll.posX + lllllllllllllIlIIlllIlIlllIIlIIl;
        final double lllllllllllllIlIIlllIlIlllIIIIlI = lllllllllllllIlIIlllIlIlllIIIlII.getY() - lllllllllllllIlIIlllIlIllIlllIll.posY + lllllllllllllIlIIlllIlIllIllIllI;
        final double lllllllllllllIlIIlllIlIlllIIIIIl = lllllllllllllIlIIlllIlIlllIIIlII.getZ() - lllllllllllllIlIIlllIlIllIlllIll.posZ + lllllllllllllIlIIlllIlIlllIIIlll;
        GlStateManager.translate(lllllllllllllIlIIlllIlIlllIIIIll + 0.5, lllllllllllllIlIIlllIlIlllIIIIlI + 0.5, lllllllllllllIlIIlllIlIlllIIIIIl + 0.5);
        GlStateManager.rotate(180.0f - lllllllllllllIlIIlllIlIllIlllIll.rotationYaw, 0.0f, 1.0f, 0.0f);
        this.renderManager.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        final BlockRendererDispatcher lllllllllllllIlIIlllIlIlllIIIIII = this.mc.getBlockRendererDispatcher();
        final ModelManager lllllllllllllIlIIlllIlIllIllllll = lllllllllllllIlIIlllIlIlllIIIIII.getBlockModelShapes().getModelManager();
        IBakedModel lllllllllllllIlIIlllIlIllIllllIl = null;
        if (lllllllllllllIlIIlllIlIllIlllIll.getDisplayedItem().getItem() instanceof ItemMap) {
            final IBakedModel lllllllllllllIlIIlllIlIllIlllllI = lllllllllllllIlIIlllIlIllIllllll.getModel(this.mapModel);
        }
        else {
            lllllllllllllIlIIlllIlIllIllllIl = lllllllllllllIlIIlllIlIllIllllll.getModel(this.itemFrameModel);
        }
        GlStateManager.pushMatrix();
        GlStateManager.translate(-0.5f, -0.5f, -0.5f);
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIlIIlllIlIllIlllIll));
        }
        lllllllllllllIlIIlllIlIlllIIIIII.getBlockModelRenderer().renderModelBrightnessColor(lllllllllllllIlIIlllIlIllIllllIl, 1.0f, 1.0f, 1.0f, 1.0f);
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        GlStateManager.popMatrix();
        GlStateManager.translate(0.0f, 0.0f, 0.4375f);
        this.renderItem(lllllllllllllIlIIlllIlIllIlllIll);
        GlStateManager.popMatrix();
        this.renderName(lllllllllllllIlIIlllIlIllIlllIll, lllllllllllllIlIIlllIlIlllIIlIIl + lllllllllllllIlIIlllIlIllIlllIll.facingDirection.getFrontOffsetX() * 0.3f, lllllllllllllIlIIlllIlIllIllIllI - 0.25, lllllllllllllIlIIlllIlIlllIIIlll + lllllllllllllIlIIlllIlIllIlllIll.facingDirection.getFrontOffsetZ() * 0.3f);
    }
    
    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(final EntityItemFrame lllllllllllllIlIIlllIlIllIlIllll) {
        return null;
    }
    
    private void renderItem(final EntityItemFrame lllllllllllllIlIIlllIlIllIIlllIl) {
        final ItemStack lllllllllllllIlIIlllIlIllIlIIlIl = lllllllllllllIlIIlllIlIllIIlllIl.getDisplayedItem();
        if (!lllllllllllllIlIIlllIlIllIlIIlIl.func_190926_b()) {
            if (!Config.zoomMode) {
                final Entity lllllllllllllIlIIlllIlIllIlIIlII = this.mc.player;
                final double lllllllllllllIlIIlllIlIllIlIIIll = lllllllllllllIlIIlllIlIllIIlllIl.getDistanceSq(lllllllllllllIlIIlllIlIllIlIIlII.posX, lllllllllllllIlIIlllIlIllIlIIlII.posY, lllllllllllllIlIIlllIlIllIlIIlII.posZ);
                if (lllllllllllllIlIIlllIlIllIlIIIll > 4096.0) {
                    return;
                }
            }
            GlStateManager.pushMatrix();
            GlStateManager.disableLighting();
            final boolean lllllllllllllIlIIlllIlIllIlIIIlI = lllllllllllllIlIIlllIlIllIlIIlIl.getItem() instanceof ItemMap;
            final int lllllllllllllIlIIlllIlIllIlIIIIl = lllllllllllllIlIIlllIlIllIlIIIlI ? (lllllllllllllIlIIlllIlIllIIlllIl.getRotation() % 4 * 2) : lllllllllllllIlIIlllIlIllIIlllIl.getRotation();
            GlStateManager.rotate(lllllllllllllIlIIlllIlIllIlIIIIl * 360.0f / 8.0f, 0.0f, 0.0f, 1.0f);
            if (!Reflector.postForgeBusEvent(Reflector.RenderItemInFrameEvent_Constructor, lllllllllllllIlIIlllIlIllIIlllIl, this)) {
                if (lllllllllllllIlIIlllIlIllIlIIIlI) {
                    this.renderManager.renderEngine.bindTexture(RenderItemFrame.MAP_BACKGROUND_TEXTURES);
                    GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                    final float lllllllllllllIlIIlllIlIllIlIIIII = 0.0078125f;
                    GlStateManager.scale(0.0078125f, 0.0078125f, 0.0078125f);
                    GlStateManager.translate(-64.0f, -64.0f, 0.0f);
                    final MapData lllllllllllllIlIIlllIlIllIIlllll = ReflectorForge.getMapData(Items.FILLED_MAP, lllllllllllllIlIIlllIlIllIlIIlIl, lllllllllllllIlIIlllIlIllIIlllIl.world);
                    GlStateManager.translate(0.0f, 0.0f, -1.0f);
                    if (lllllllllllllIlIIlllIlIllIIlllll != null) {
                        this.mc.entityRenderer.getMapItemRenderer().renderMap(lllllllllllllIlIIlllIlIllIIlllll, true);
                    }
                }
                else {
                    GlStateManager.scale(0.5f, 0.5f, 0.5f);
                    GlStateManager.pushAttrib();
                    RenderHelper.enableStandardItemLighting();
                    this.itemRenderer.renderItem(lllllllllllllIlIIlllIlIllIlIIlIl, ItemCameraTransforms.TransformType.FIXED);
                    RenderHelper.disableStandardItemLighting();
                    GlStateManager.popAttrib();
                }
            }
            GlStateManager.enableLighting();
            GlStateManager.popMatrix();
        }
    }
    
    static {
        MAP_BACKGROUND_TEXTURES = new ResourceLocation("textures/map/map_background.png");
    }
    
    public RenderItemFrame(final RenderManager lllllllllllllIlIIlllIlIlllIlllII, final RenderItem lllllllllllllIlIIlllIlIlllIllIII) {
        super(lllllllllllllIlIIlllIlIlllIlllII);
        this.mc = Minecraft.getMinecraft();
        this.itemFrameModel = new ModelResourceLocation("item_frame", "normal");
        this.mapModel = new ModelResourceLocation("item_frame", "map");
        this.itemRenderer = lllllllllllllIlIIlllIlIlllIllIII;
    }
}
