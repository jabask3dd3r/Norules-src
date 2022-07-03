package net.minecraft.client.renderer.entity;

import net.minecraft.entity.item.*;
import net.minecraft.entity.*;
import net.minecraft.block.state.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.*;
import net.minecraft.client.model.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.math.*;

public class RenderMinecart<T extends EntityMinecart> extends Render<T>
{
    protected /* synthetic */ ModelBase modelMinecart;
    private static final /* synthetic */ ResourceLocation MINECART_TEXTURES;
    
    @Override
    protected ResourceLocation getEntityTexture(final T lllllllllllllIIllIlllIIIIlIIIllI) {
        return RenderMinecart.MINECART_TEXTURES;
    }
    
    static {
        MINECART_TEXTURES = new ResourceLocation("textures/entity/minecart.png");
    }
    
    protected void renderCartContents(final T lllllllllllllIIllIlllIIIIIllllll, final float lllllllllllllIIllIlllIIIIlIIIIIl, final IBlockState lllllllllllllIIllIlllIIIIIlllllI) {
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getBlockRendererDispatcher().renderBlockBrightness(lllllllllllllIIllIlllIIIIIlllllI, lllllllllllllIIllIlllIIIIIllllll.getBrightness());
        GlStateManager.popMatrix();
    }
    
    public RenderMinecart(final RenderManager lllllllllllllIIllIlllIIIlIIIllIl) {
        super(lllllllllllllIIllIlllIIIlIIIllIl);
        this.modelMinecart = new ModelMinecart();
        this.shadowSize = 0.5f;
    }
    
    @Override
    public void doRender(final T lllllllllllllIIllIlllIIIIlIlllII, double lllllllllllllIIllIlllIIIIlIllIll, double lllllllllllllIIllIlllIIIIlIllIlI, double lllllllllllllIIllIlllIIIIlIllIIl, float lllllllllllllIIllIlllIIIIlIllIII, final float lllllllllllllIIllIlllIIIIlllIIII) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(lllllllllllllIIllIlllIIIIlIlllII);
        long lllllllllllllIIllIlllIIIIllIllll = lllllllllllllIIllIlllIIIIlIlllII.getEntityId() * 493286711L;
        lllllllllllllIIllIlllIIIIllIllll = lllllllllllllIIllIlllIIIIllIllll * lllllllllllllIIllIlllIIIIllIllll * 4392167121L + lllllllllllllIIllIlllIIIIllIllll * 98761L;
        final float lllllllllllllIIllIlllIIIIllIlllI = (((lllllllllllllIIllIlllIIIIllIllll >> 16 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        final float lllllllllllllIIllIlllIIIIllIllIl = (((lllllllllllllIIllIlllIIIIllIllll >> 20 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        final float lllllllllllllIIllIlllIIIIllIllII = (((lllllllllllllIIllIlllIIIIllIllll >> 24 & 0x7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        GlStateManager.translate(lllllllllllllIIllIlllIIIIllIlllI, lllllllllllllIIllIlllIIIIllIllIl, lllllllllllllIIllIlllIIIIllIllII);
        final double lllllllllllllIIllIlllIIIIllIlIll = lllllllllllllIIllIlllIIIIlIlllII.lastTickPosX + (lllllllllllllIIllIlllIIIIlIlllII.posX - lllllllllllllIIllIlllIIIIlIlllII.lastTickPosX) * lllllllllllllIIllIlllIIIIlllIIII;
        final double lllllllllllllIIllIlllIIIIllIlIlI = lllllllllllllIIllIlllIIIIlIlllII.lastTickPosY + (lllllllllllllIIllIlllIIIIlIlllII.posY - lllllllllllllIIllIlllIIIIlIlllII.lastTickPosY) * lllllllllllllIIllIlllIIIIlllIIII;
        final double lllllllllllllIIllIlllIIIIllIlIIl = lllllllllllllIIllIlllIIIIlIlllII.lastTickPosZ + (lllllllllllllIIllIlllIIIIlIlllII.posZ - lllllllllllllIIllIlllIIIIlIlllII.lastTickPosZ) * lllllllllllllIIllIlllIIIIlllIIII;
        final double lllllllllllllIIllIlllIIIIllIlIII = 0.30000001192092896;
        final Vec3d lllllllllllllIIllIlllIIIIllIIlll = lllllllllllllIIllIlllIIIIlIlllII.getPos(lllllllllllllIIllIlllIIIIllIlIll, lllllllllllllIIllIlllIIIIllIlIlI, lllllllllllllIIllIlllIIIIllIlIIl);
        float lllllllllllllIIllIlllIIIIllIIllI = lllllllllllllIIllIlllIIIIlIlllII.prevRotationPitch + (lllllllllllllIIllIlllIIIIlIlllII.rotationPitch - lllllllllllllIIllIlllIIIIlIlllII.prevRotationPitch) * lllllllllllllIIllIlllIIIIlllIIII;
        if (lllllllllllllIIllIlllIIIIllIIlll != null) {
            Vec3d lllllllllllllIIllIlllIIIIllIIlIl = lllllllllllllIIllIlllIIIIlIlllII.getPosOffset(lllllllllllllIIllIlllIIIIllIlIll, lllllllllllllIIllIlllIIIIllIlIlI, lllllllllllllIIllIlllIIIIllIlIIl, 0.30000001192092896);
            Vec3d lllllllllllllIIllIlllIIIIllIIlII = lllllllllllllIIllIlllIIIIlIlllII.getPosOffset(lllllllllllllIIllIlllIIIIllIlIll, lllllllllllllIIllIlllIIIIllIlIlI, lllllllllllllIIllIlllIIIIllIlIIl, -0.30000001192092896);
            if (lllllllllllllIIllIlllIIIIllIIlIl == null) {
                lllllllllllllIIllIlllIIIIllIIlIl = lllllllllllllIIllIlllIIIIllIIlll;
            }
            if (lllllllllllllIIllIlllIIIIllIIlII == null) {
                lllllllllllllIIllIlllIIIIllIIlII = lllllllllllllIIllIlllIIIIllIIlll;
            }
            lllllllllllllIIllIlllIIIIlIllIll += lllllllllllllIIllIlllIIIIllIIlll.xCoord - lllllllllllllIIllIlllIIIIllIlIll;
            lllllllllllllIIllIlllIIIIlIllIlI += (lllllllllllllIIllIlllIIIIllIIlIl.yCoord + lllllllllllllIIllIlllIIIIllIIlII.yCoord) / 2.0 - lllllllllllllIIllIlllIIIIllIlIlI;
            lllllllllllllIIllIlllIIIIlIllIIl += lllllllllllllIIllIlllIIIIllIIlll.zCoord - lllllllllllllIIllIlllIIIIllIlIIl;
            Vec3d lllllllllllllIIllIlllIIIIllIIIll = lllllllllllllIIllIlllIIIIllIIlII.addVector(-lllllllllllllIIllIlllIIIIllIIlIl.xCoord, -lllllllllllllIIllIlllIIIIllIIlIl.yCoord, -lllllllllllllIIllIlllIIIIllIIlIl.zCoord);
            if (lllllllllllllIIllIlllIIIIllIIIll.lengthVector() != 0.0) {
                lllllllllllllIIllIlllIIIIllIIIll = lllllllllllllIIllIlllIIIIllIIIll.normalize();
                lllllllllllllIIllIlllIIIIlIllIII = (float)(Math.atan2(lllllllllllllIIllIlllIIIIllIIIll.zCoord, lllllllllllllIIllIlllIIIIllIIIll.xCoord) * 180.0 / 3.141592653589793);
                lllllllllllllIIllIlllIIIIllIIllI = (float)(Math.atan(lllllllllllllIIllIlllIIIIllIIIll.yCoord) * 73.0);
            }
        }
        GlStateManager.translate((float)lllllllllllllIIllIlllIIIIlIllIll, (float)lllllllllllllIIllIlllIIIIlIllIlI + 0.375f, (float)lllllllllllllIIllIlllIIIIlIllIIl);
        GlStateManager.rotate(180.0f - lllllllllllllIIllIlllIIIIlIllIII, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(-lllllllllllllIIllIlllIIIIllIIllI, 0.0f, 0.0f, 1.0f);
        final float lllllllllllllIIllIlllIIIIllIIIlI = lllllllllllllIIllIlllIIIIlIlllII.getRollingAmplitude() - lllllllllllllIIllIlllIIIIlllIIII;
        float lllllllllllllIIllIlllIIIIllIIIIl = lllllllllllllIIllIlllIIIIlIlllII.getDamage() - lllllllllllllIIllIlllIIIIlllIIII;
        if (lllllllllllllIIllIlllIIIIllIIIIl < 0.0f) {
            lllllllllllllIIllIlllIIIIllIIIIl = 0.0f;
        }
        if (lllllllllllllIIllIlllIIIIllIIIlI > 0.0f) {
            GlStateManager.rotate(MathHelper.sin(lllllllllllllIIllIlllIIIIllIIIlI) * lllllllllllllIIllIlllIIIIllIIIlI * lllllllllllllIIllIlllIIIIllIIIIl / 10.0f * lllllllllllllIIllIlllIIIIlIlllII.getRollingDirection(), 1.0f, 0.0f, 0.0f);
        }
        final int lllllllllllllIIllIlllIIIIllIIIII = lllllllllllllIIllIlllIIIIlIlllII.getDisplayTileOffset();
        if (this.renderOutlines) {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(lllllllllllllIIllIlllIIIIlIlllII));
        }
        final IBlockState lllllllllllllIIllIlllIIIIlIlllll = lllllllllllllIIllIlllIIIIlIlllII.getDisplayTile();
        if (lllllllllllllIIllIlllIIIIlIlllll.getRenderType() != EnumBlockRenderType.INVISIBLE) {
            GlStateManager.pushMatrix();
            this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
            final float lllllllllllllIIllIlllIIIIlIllllI = 0.75f;
            GlStateManager.scale(0.75f, 0.75f, 0.75f);
            GlStateManager.translate(-0.5f, (lllllllllllllIIllIlllIIIIllIIIII - 8) / 16.0f, 0.5f);
            this.renderCartContents(lllllllllllllIIllIlllIIIIlIlllII, lllllllllllllIIllIlllIIIIlllIIII, lllllllllllllIIllIlllIIIIlIlllll);
            GlStateManager.popMatrix();
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.bindEntityTexture(lllllllllllllIIllIlllIIIIlIlllII);
        }
        GlStateManager.scale(-1.0f, -1.0f, 1.0f);
        this.modelMinecart.render(lllllllllllllIIllIlllIIIIlIlllII, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.popMatrix();
        if (this.renderOutlines) {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        super.doRender(lllllllllllllIIllIlllIIIIlIlllII, lllllllllllllIIllIlllIIIIlIllIll, lllllllllllllIIllIlllIIIIlIllIlI, lllllllllllllIIllIlllIIIIlIllIIl, lllllllllllllIIllIlllIIIIlIllIII, lllllllllllllIIllIlllIIIIlllIIII);
    }
}
