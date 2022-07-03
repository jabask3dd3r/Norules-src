package net.minecraft.client.renderer.entity;

import net.minecraft.entity.monster.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.culling.*;
import net.minecraft.util.math.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.entity.layers.*;
import net.minecraft.client.model.*;

public class RenderShulker extends RenderLiving<EntityShulker>
{
    public static final /* synthetic */ ResourceLocation[] SHULKER_ENDERGOLEM_TEXTURE;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
    
    static {
        SHULKER_ENDERGOLEM_TEXTURE = new ResourceLocation[] { new ResourceLocation("textures/entity/shulker/shulker_white.png"), new ResourceLocation("textures/entity/shulker/shulker_orange.png"), new ResourceLocation("textures/entity/shulker/shulker_magenta.png"), new ResourceLocation("textures/entity/shulker/shulker_light_blue.png"), new ResourceLocation("textures/entity/shulker/shulker_yellow.png"), new ResourceLocation("textures/entity/shulker/shulker_lime.png"), new ResourceLocation("textures/entity/shulker/shulker_pink.png"), new ResourceLocation("textures/entity/shulker/shulker_gray.png"), new ResourceLocation("textures/entity/shulker/shulker_silver.png"), new ResourceLocation("textures/entity/shulker/shulker_cyan.png"), new ResourceLocation("textures/entity/shulker/shulker_purple.png"), new ResourceLocation("textures/entity/shulker/shulker_blue.png"), new ResourceLocation("textures/entity/shulker/shulker_brown.png"), new ResourceLocation("textures/entity/shulker/shulker_green.png"), new ResourceLocation("textures/entity/shulker/shulker_red.png"), new ResourceLocation("textures/entity/shulker/shulker_black.png") };
    }
    
    @Override
    protected void preRenderCallback(final EntityShulker lllllllllllllIlllIlIlIIlIlIIllII, final float lllllllllllllIlllIlIlIIlIlIIlIll) {
        final float lllllllllllllIlllIlIlIIlIlIIlIlI = 0.999f;
        GlStateManager.scale(0.999f, 0.999f, 0.999f);
    }
    
    @Override
    public boolean shouldRender(final EntityShulker lllllllllllllIlllIlIlIIlIllIlIlI, final ICamera lllllllllllllIlllIlIlIIlIlllIIll, final double lllllllllllllIlllIlIlIIlIllIlIII, final double lllllllllllllIlllIlIlIIlIlllIIIl, final double lllllllllllllIlllIlIlIIlIllIIllI) {
        if (super.shouldRender(lllllllllllllIlllIlIlIIlIllIlIlI, lllllllllllllIlllIlIlIIlIlllIIll, lllllllllllllIlllIlIlIIlIllIlIII, lllllllllllllIlllIlIlIIlIlllIIIl, lllllllllllllIlllIlIlIIlIllIIllI)) {
            return true;
        }
        if (lllllllllllllIlllIlIlIIlIllIlIlI.getClientTeleportInterp() > 0 && lllllllllllllIlllIlIlIIlIllIlIlI.isAttachedToBlock()) {
            final BlockPos lllllllllllllIlllIlIlIIlIllIllll = lllllllllllllIlllIlIlIIlIllIlIlI.getOldAttachPos();
            final BlockPos lllllllllllllIlllIlIlIIlIllIlllI = lllllllllllllIlllIlIlIIlIllIlIlI.getAttachmentPos();
            final Vec3d lllllllllllllIlllIlIlIIlIllIllIl = new Vec3d(lllllllllllllIlllIlIlIIlIllIlllI.getX(), lllllllllllllIlllIlIlIIlIllIlllI.getY(), lllllllllllllIlllIlIlIIlIllIlllI.getZ());
            final Vec3d lllllllllllllIlllIlIlIIlIllIllII = new Vec3d(lllllllllllllIlllIlIlIIlIllIllll.getX(), lllllllllllllIlllIlIlIIlIllIllll.getY(), lllllllllllllIlllIlIlIIlIllIllll.getZ());
            if (lllllllllllllIlllIlIlIIlIlllIIll.isBoundingBoxInFrustum(new AxisAlignedBB(lllllllllllllIlllIlIlIIlIllIllII.xCoord, lllllllllllllIlllIlIlIIlIllIllII.yCoord, lllllllllllllIlllIlIlIIlIllIllII.zCoord, lllllllllllllIlllIlIlIIlIllIllIl.xCoord, lllllllllllllIlllIlIlIIlIllIllIl.yCoord, lllllllllllllIlllIlIlIIlIllIllIl.zCoord))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    protected void rotateCorpse(final EntityShulker lllllllllllllIlllIlIlIIlIlIlIlll, final float lllllllllllllIlllIlIlIIlIlIlIllI, final float lllllllllllllIlllIlIlIIlIlIlIIII, final float lllllllllllllIlllIlIlIIlIlIlIlII) {
        super.rotateCorpse(lllllllllllllIlllIlIlIIlIlIlIlll, lllllllllllllIlllIlIlIIlIlIlIllI, lllllllllllllIlllIlIlIIlIlIlIIII, lllllllllllllIlllIlIlIIlIlIlIlII);
        switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlllIlIlIIlIlIlIlll.getAttachmentFacing().ordinal()]) {
            case 6: {
                GlStateManager.translate(0.5f, 0.5f, 0.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 5: {
                GlStateManager.translate(-0.5f, 0.5f, 0.0f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 3: {
                GlStateManager.translate(0.0f, 0.5f, -0.5f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                break;
            }
            case 4: {
                GlStateManager.translate(0.0f, 0.5f, 0.5f);
                GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                break;
            }
            case 2: {
                GlStateManager.translate(0.0f, 1.0f, 0.0f);
                GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                break;
            }
        }
    }
    
    public RenderShulker(final RenderManager lllllllllllllIlllIlIlIIllIlIllll) {
        super(lllllllllllllIlllIlIlIIllIlIllll, new ModelShulker(), 0.0f);
        ((RenderLivingBase<EntityLivingBase>)this).addLayer(new HeadLayer((HeadLayer)null));
    }
    
    static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
        final int[] $switch_TABLE$net$minecraft$util$EnumFacing = RenderShulker.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
        if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
            return $switch_TABLE$net$minecraft$util$EnumFacing;
        }
        final long lllllllllllllIlllIlIlIIlIIIlIlll = (Object)new int[EnumFacing.values().length];
        try {
            lllllllllllllIlllIlIlIIlIIIlIlll[EnumFacing.DOWN.ordinal()] = true;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            lllllllllllllIlllIlIlIIlIIIlIlll[EnumFacing.EAST.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            lllllllllllllIlllIlIlIIlIIIlIlll[EnumFacing.NORTH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            lllllllllllllIlllIlIlIIlIIIlIlll[EnumFacing.SOUTH.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            lllllllllllllIlllIlIlIIlIIIlIlll[EnumFacing.UP.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            lllllllllllllIlllIlIlIIlIIIlIlll[EnumFacing.WEST.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
        return RenderShulker.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlllIlIlIIlIIIlIlll;
    }
    
    @Override
    protected ResourceLocation getEntityTexture(final EntityShulker lllllllllllllIlllIlIlIIlIlIllllI) {
        return RenderShulker.SHULKER_ENDERGOLEM_TEXTURE[lllllllllllllIlllIlIlIIlIlIllllI.func_190769_dn().getMetadata()];
    }
    
    @Override
    public void doRender(final EntityShulker lllllllllllllIlllIlIlIIllIIllIlI, final double lllllllllllllIlllIlIlIIllIIIlIll, final double lllllllllllllIlllIlIlIIllIIllIII, final double lllllllllllllIlllIlIlIIllIIlIlll, final float lllllllllllllIlllIlIlIIllIIlIllI, final float lllllllllllllIlllIlIlIIllIIlIlIl) {
        final int lllllllllllllIlllIlIlIIllIIlIlII = lllllllllllllIlllIlIlIIllIIllIlI.getClientTeleportInterp();
        if (lllllllllllllIlllIlIlIIllIIlIlII > 0 && lllllllllllllIlllIlIlIIllIIllIlI.isAttachedToBlock()) {
            final BlockPos lllllllllllllIlllIlIlIIllIIlIIll = lllllllllllllIlllIlIlIIllIIllIlI.getAttachmentPos();
            final BlockPos lllllllllllllIlllIlIlIIllIIlIIlI = lllllllllllllIlllIlIlIIllIIllIlI.getOldAttachPos();
            double lllllllllllllIlllIlIlIIllIIlIIIl = (lllllllllllllIlllIlIlIIllIIlIlII - lllllllllllllIlllIlIlIIllIIlIlIl) / 6.0;
            lllllllllllllIlllIlIlIIllIIlIIIl *= lllllllllllllIlllIlIlIIllIIlIIIl;
            final double lllllllllllllIlllIlIlIIllIIlIIII = (lllllllllllllIlllIlIlIIllIIlIIll.getX() - lllllllllllllIlllIlIlIIllIIlIIlI.getX()) * lllllllllllllIlllIlIlIIllIIlIIIl;
            final double lllllllllllllIlllIlIlIIllIIIllll = (lllllllllllllIlllIlIlIIllIIlIIll.getY() - lllllllllllllIlllIlIlIIllIIlIIlI.getY()) * lllllllllllllIlllIlIlIIllIIlIIIl;
            final double lllllllllllllIlllIlIlIIllIIIlllI = (lllllllllllllIlllIlIlIIllIIlIIll.getZ() - lllllllllllllIlllIlIlIIllIIlIIlI.getZ()) * lllllllllllllIlllIlIlIIllIIlIIIl;
            super.doRender(lllllllllllllIlllIlIlIIllIIllIlI, lllllllllllllIlllIlIlIIllIIIlIll - lllllllllllllIlllIlIlIIllIIlIIII, lllllllllllllIlllIlIlIIllIIllIII - lllllllllllllIlllIlIlIIllIIIllll, lllllllllllllIlllIlIlIIllIIlIlll - lllllllllllllIlllIlIlIIllIIIlllI, lllllllllllllIlllIlIlIIllIIlIllI, lllllllllllllIlllIlIlIIllIIlIlIl);
        }
        else {
            super.doRender(lllllllllllllIlllIlIlIIllIIllIlI, lllllllllllllIlllIlIlIIllIIIlIll, lllllllllllllIlllIlIlIIllIIllIII, lllllllllllllIlllIlIlIIllIIlIlll, lllllllllllllIlllIlIlIIllIIlIllI, lllllllllllllIlllIlIlIIllIIlIlIl);
        }
    }
    
    @Override
    public ModelShulker getMainModel() {
        return (ModelShulker)super.getMainModel();
    }
    
    class HeadLayer implements LayerRenderer<EntityShulker>
    {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
        
        @Override
        public void doRenderLayer(final EntityShulker lllllllllllllIlIlllIIIIlllIllIIl, final float lllllllllllllIlIlllIIIIllllIIIlI, final float lllllllllllllIlIlllIIIIllllIIIIl, final float lllllllllllllIlIlllIIIIllllIIIII, final float lllllllllllllIlIlllIIIIlllIlllll, final float lllllllllllllIlIlllIIIIlllIllllI, final float lllllllllllllIlIlllIIIIlllIlllIl, final float lllllllllllllIlIlllIIIIlllIlllII) {
            GlStateManager.pushMatrix();
            switch ($SWITCH_TABLE$net$minecraft$util$EnumFacing()[lllllllllllllIlIlllIIIIlllIllIIl.getAttachmentFacing().ordinal()]) {
                case 6: {
                    GlStateManager.rotate(90.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(1.0f, -1.0f, 0.0f);
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 5: {
                    GlStateManager.rotate(-90.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(-1.0f, -1.0f, 0.0f);
                    GlStateManager.rotate(180.0f, 0.0f, 1.0f, 0.0f);
                    break;
                }
                case 3: {
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(0.0f, -1.0f, -1.0f);
                    break;
                }
                case 4: {
                    GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
                    GlStateManager.rotate(90.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(0.0f, -1.0f, 1.0f);
                    break;
                }
                case 2: {
                    GlStateManager.rotate(180.0f, 1.0f, 0.0f, 0.0f);
                    GlStateManager.translate(0.0f, -2.0f, 0.0f);
                    break;
                }
            }
            final ModelRenderer lllllllllllllIlIlllIIIIlllIllIll = RenderShulker.this.getMainModel().head;
            lllllllllllllIlIlllIIIIlllIllIll.rotateAngleY = lllllllllllllIlIlllIIIIlllIllllI * 0.017453292f;
            lllllllllllllIlIlllIIIIlllIllIll.rotateAngleX = lllllllllllllIlIlllIIIIlllIlllIl * 0.017453292f;
            RenderShulker.this.bindTexture(RenderShulker.SHULKER_ENDERGOLEM_TEXTURE[lllllllllllllIlIlllIIIIlllIllIIl.func_190769_dn().getMetadata()]);
            lllllllllllllIlIlllIIIIlllIllIll.render(lllllllllllllIlIlllIIIIlllIlllII);
            GlStateManager.popMatrix();
        }
        
        static /* synthetic */ int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
            final int[] $switch_TABLE$net$minecraft$util$EnumFacing = HeadLayer.$SWITCH_TABLE$net$minecraft$util$EnumFacing;
            if ($switch_TABLE$net$minecraft$util$EnumFacing != null) {
                return $switch_TABLE$net$minecraft$util$EnumFacing;
            }
            final char lllllllllllllIlIlllIIIIlllIIIIII = (Object)new int[EnumFacing.values().length];
            try {
                lllllllllllllIlIlllIIIIlllIIIIII[EnumFacing.DOWN.ordinal()] = true;
            }
            catch (NoSuchFieldError noSuchFieldError) {}
            try {
                lllllllllllllIlIlllIIIIlllIIIIII[EnumFacing.EAST.ordinal()] = 6;
            }
            catch (NoSuchFieldError noSuchFieldError2) {}
            try {
                lllllllllllllIlIlllIIIIlllIIIIII[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError noSuchFieldError3) {}
            try {
                lllllllllllllIlIlllIIIIlllIIIIII[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError noSuchFieldError4) {}
            try {
                lllllllllllllIlIlllIIIIlllIIIIII[EnumFacing.UP.ordinal()] = 2;
            }
            catch (NoSuchFieldError noSuchFieldError5) {}
            try {
                lllllllllllllIlIlllIIIIlllIIIIII[EnumFacing.WEST.ordinal()] = 5;
            }
            catch (NoSuchFieldError noSuchFieldError6) {}
            return HeadLayer.$SWITCH_TABLE$net$minecraft$util$EnumFacing = (int[])(Object)lllllllllllllIlIlllIIIIlllIIIIII;
        }
        
        private HeadLayer() {
        }
        
        @Override
        public boolean shouldCombineTextures() {
            return false;
        }
    }
}
